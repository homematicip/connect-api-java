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

package de.eq3.plugin.domain.config;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.documentation.SystemSentMessageDocumentation;
import de.eq3.plugin.domain.Body;
import de.eq3.plugin.serialization.PluginMessage;
import de.eq3.plugin.serialization.PluginMessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Jacksonized
@Builder
@AllArgsConstructor
@SystemSentMessageDocumentation(
		messageType = PluginMessageType.Fields.CONFIG_UPDATE_REQUEST,
		description = "Message sent by the Home Control Unit containing configuration parameter updates for "
				+ "the plugin in a key-value fashion. This message is sent whenever a user makes configuration "
				+ "changes for the plugin via HCUweb and saves them.",
		envelope = PluginMessage.class,
		correspondingMessage = ConfigUpdateResponse.class)
public class ConfigUpdateRequest implements Body {
	@FieldDocumentation(
			description = "Property identifier to value mapping.",
			example = "{\"stringProperty\":\"127.0.0.1\",\"numberParameter\":0.5,\"integerParameter\":10,"
					+ "\"booleanParameter\":true,\"enumProperty\": \"GREEN\"}",
			nullable = true)
	private Map<String, Object> properties;
	@FieldDocumentation(
			description = "The plugin may include a feedback message in the response to this request. "
					+ "This field contains a ISO 639-1 code of the desired language for that feedback message. "
					+ "Plugins may fall back to a default language.",
			example = "en",
			nullable = true)
	private String languageCode;
}
