/**
 * Copyright 2014-2025 eQ-3 AG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.eq3.plugin.serialization;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import de.eq3.plugin.domain.Body;

final class PluginMessageDeserializer<T extends Body> extends JsonDeserializer<PluginMessage<T>> {
	private static final String ID_FIELD = "id";

	private static final String PLUGIN_ID_FIELD = "pluginId";

	private static final String TYPE_FIELD = "type";

	@Override
	public PluginMessage<T> deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		JsonNode node = jp.getCodec().readTree(jp);

		boolean hasId = node.hasNonNull(ID_FIELD);
		boolean hasPluginId = node.hasNonNull(PLUGIN_ID_FIELD);
		boolean hasTypeField = node.hasNonNull(TYPE_FIELD);

		if (!(hasId && hasPluginId && hasTypeField)) {
			Set<String> missingFields = new TreeSet<>();
			if (!hasId) {
				missingFields.add(ID_FIELD);
			}
			if (!hasPluginId) {
				missingFields.add(PLUGIN_ID_FIELD);
			}
			if (!hasTypeField) {
				missingFields.add(TYPE_FIELD);
			}
			throw new PluginMessageFormatException("Plugin message is missing mandatory field(s): " + missingFields);
		}
		String type = node.get(TYPE_FIELD).asText();

		PluginMessageType pluginMessageType;
		try {
			pluginMessageType = PluginMessageType.valueOf(type);
		} catch (Exception e) {
			throw new PluginMessageFormatException("Unknown plugin message type: " + type);
		}

		JsonNode bodyJson = node.get("body");

		Set<String> requiredFields = getRequiredFields(pluginMessageType);

		Set<String> missingFields = requiredFields.stream()
				.filter(requiredField -> bodyJson == null || !bodyJson.hasNonNull(requiredField))
				.collect(Collectors.toSet());

		if (!missingFields.isEmpty()) {
			throw new PluginMessageFormatException(
					"Insufficient body for plugin message type " + type + ". Missing field(s): " + missingFields);
		}

		T body = (T) jp.getCodec().treeToValue(bodyJson, pluginMessageType.getMappingClazz());
		return new PluginMessage<>(node.get(ID_FIELD).asText(), node.get(PLUGIN_ID_FIELD).asText(), pluginMessageType,
				body);
	}

	private Set<String> getRequiredFields(PluginMessageType pluginMessageType) {
		Set<String> requiredFields = new HashSet<>();

		Optional<Constructor<?>> jsonCreator = Arrays
				.stream(pluginMessageType.getMappingClazz().getDeclaredConstructors())
				.filter(constructor -> constructor.isAnnotationPresent(JsonCreator.class))
				.findFirst();

		jsonCreator.ifPresent(constructor -> Arrays.stream(constructor.getParameters()).forEach(parameter -> {
			JsonProperty jsonProperty = parameter.getAnnotation(JsonProperty.class);
			if (jsonProperty != null && jsonProperty.required()) {
				requiredFields.add(jsonProperty.value());
			}
		}));

		return requiredFields;
	}
}