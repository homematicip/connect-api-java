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
		messageType = PluginMessageType.Fields.CONFIG_TEMPLATE_REQUEST,
		description = "Message sent by the Home Control Unit to request a template with configuration parameters and "
				+ "associated constraints required by the plugin. The template will be used by HCUweb to present "
				+ "a form with the configuration parameters. The plugin may perform some work in the background "
				+ "before sending a response. That time should not exceed 10s.",
		envelope = PluginMessage.class,
		correspondingMessage = ConfigTemplateResponse.class)
public class ConfigTemplateRequest implements Body {
	@FieldDocumentation(
			description = "ISO 639-1 code of the language in which the configuration template shall be returned. "
					+ "Plugins may fall back to a default language. Required are english (en) and german (de)",
			example = "en",
			nullable = true)
	private String languageCode;
}
