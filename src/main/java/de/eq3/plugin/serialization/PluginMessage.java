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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.eq3.plugin.documentation.EnvelopeDocumentation;
import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.domain.Body;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = PluginMessageDeserializer.class)
@EnvelopeDocumentation(description = "Envelope for messages sent by Home Control Unit or plugins.")
public class PluginMessage<T extends Body> {
	@FieldDocumentation(
			description = "Message identifier, used in subsequent messages of the same flow.",
			example = "38967997-e1b3-463f-8dc4-f889bb5d10a2",
			nullable = false)
	private String id;
	@FieldDocumentation(
			description = "Unique plugin identifier.",
			example = "de.doe.jane.plugin.example",
			nullable = false)
	private String pluginId;
	@FieldDocumentation(
			description = "Message type, defining the schema of the message body.",
			example = "PLUGIN_STATE_REQUEST",
			nullable = false)
	private PluginMessageType type;

	@FieldDocumentation(
			description = "The body of the message, structured according to the message type.",
			nullable = true,
			example = "{}")
	private T body;

	@JsonCreator
	public PluginMessage(@JsonProperty(value = "id", required = true) String id,
			@JsonProperty(value = "pluginId", required = true) String pluginId,
			@JsonProperty(value = "type", required = true) PluginMessageType type,
			@JsonProperty(value = "body") T body) {

		this.id = id;
		this.pluginId = pluginId;
		this.type = type;
		this.body = body;
	}
}
