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
		messageType = PluginMessageType.Fields.CONFIG_TEMPLATE_RESPONSE,
		description = "Message sent by the plugin containing a template with plugin configuration parameters and "
				+ "associated constraints. To improve usability, it is possible to order and group the properties. "
				+ "The message identifier must be identical to the one used in the preceding request.",
		envelope = PluginMessage.class,
		correspondingMessage = ConfigTemplateRequest.class)
public class ConfigTemplateResponse implements Body {
	@FieldDocumentation(description = "Property identifier to template mapping.", nullable = false)
	private Map<String, PropertyTemplate> properties;

	@FieldDocumentation(description = "Group identifier to template mapping.", nullable = true)
	private Map<String, GroupTemplate> groups;
}
