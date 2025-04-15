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

package de.eq3.plugin.domain.plugin;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.documentation.PluginSentMessageDocumentation;
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
@PluginSentMessageDocumentation(
		messageType = PluginMessageType.Fields.PLUGIN_STATE_RESPONSE,
		description = "Message sent by the plugin containing the current plugin status. "
				+ "It should be sent when requested by the server, and proactively whenever a state change occurs. "
				+ "Typically right after starting the plugin, after configuration, or if an error occurs that "
				+ "requires user interaction. Include a map with human readable, localized names if you want to update "
				+ "your plugin's name that is displayed on HCUweb and in the Homematic IP smartphone app.",
		envelope = PluginMessage.class,
		correspondingMessage = PluginStateRequest.class)
public class PluginStateResponse implements Body {
	@FieldDocumentation(
			description = "A human readable, localized name of the plugin. Keys must follow ISO 639-1 language codes. "
					+ "The key 'de' is required.",
			example = "{\"en\": \"My plugin\", \"de\": \"Mein Plugin\"}",
			nullable = true)
	@JsonAlias("pluginName")
	private Map<String, String> friendlyName;

	@FieldDocumentation(description = "Enumerated type of the plugin status, displayed on HCUweb.", nullable = false)
	private PluginReadinessStatus pluginReadinessStatus;
}
