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
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.domain.features.IFeature;

public final class FeatureDeserializer<T extends IFeature> extends JsonDeserializer<T> {
	@Override
	public T deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		JsonNode jsonNode = ctx.readTree(jp);

		String type = jsonNode.get("type").asText();
		Feature feature = Feature.fromIdentifier(type)
				.orElseThrow(() -> new IllegalArgumentException("Feature type is not supported"));

		// Check if null fields are nullable
		Set<String> missingValues = getMissingValues(feature, jsonNode);
		if (!missingValues.isEmpty()) {
			throw new PluginMessageFormatException(missingValues.toString());
		}

		// Check if there are values out of range
		Set<String> valuesOutOfRange = getValuesOutOfRange(feature, jsonNode);
		if (!valuesOutOfRange.isEmpty()) {
			throw new PluginMessageFormatException(valuesOutOfRange.toString());
		}

		return jp.getCodec().treeToValue(jsonNode, feature.getMappingClazz());
	}

	private Set<String> getMissingValues(Feature feature, JsonNode node) {
		Set<String> missingValues = new HashSet<>();

		List<Field> fields = Arrays.stream(feature.getMappingClazz().getDeclaredFields())
				.filter(field -> field.isAnnotationPresent(FieldDocumentation.class))
				.collect(Collectors.toList());

		fields.forEach(field -> {
			boolean nullable = field.getAnnotation(FieldDocumentation.class).nullable();
			if (!nullable && node.get(field.getName()) == null) {
				missingValues.add("Field " + field.getName() + " is missing");
			}
		});
		return missingValues;
	}

	private Set<String> getValuesOutOfRange(Feature feature, JsonNode node) {
		List<Field> fields = Arrays.stream(feature.getMappingClazz().getDeclaredFields())
				.filter(field -> field.isAnnotationPresent(FieldDocumentation.class))
				.collect(Collectors.toList());
		Set<String> valuesOutOfRange = new HashSet<>();
		fields.forEach(field -> {
			String minValue = field.getAnnotation(FieldDocumentation.class).minValue();
			String maxValue = field.getAnnotation(FieldDocumentation.class).maxValue();
			if (node.get(field.getName()) == null
					|| !(node.get(field.getName()) != null && !minValue.isEmpty() || !maxValue.isEmpty())) {
				return;
			}
			String fieldType = field.getType().getName();
			boolean valueOutOfRange = false;
			switch (fieldType) {
			case "java.lang.Integer":
				int intValue = node.get(field.getName()).intValue();
				valueOutOfRange = (!minValue.isEmpty() && intValue < Integer.parseInt(minValue))
						|| (!maxValue.isEmpty() && intValue > Integer.parseInt(maxValue));
				break;
			case "java.lang.Double":
				double doubleValue = node.get(field.getName()).doubleValue();
				valueOutOfRange = (!minValue.isEmpty() && doubleValue < Double.parseDouble(minValue))
						|| (!maxValue.isEmpty() && doubleValue > Double.parseDouble(maxValue));
				break;
			default:
				break;
			}
			if (valueOutOfRange) {
				valuesOutOfRange.add("Wrong value given for " + field.getName() + ". The given value "
						+ node.get(field.getName()) + " is out of range of " + minValue + "-" + maxValue);
			}
		});
		return valuesOutOfRange;
	}

}