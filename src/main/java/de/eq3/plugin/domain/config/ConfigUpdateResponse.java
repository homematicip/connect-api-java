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
		messageType = PluginMessageType.Fields.CONFIG_UPDATE_RESPONSE,
		description = "Message sent by the plugin containing the status of a configuration update. "
				+ "May be sent multiple times in case of a multi-step configuration update with required "
				+ "user interaction (e.g. button press on a gateway). The message identifier must be identical to "
				+ "the one used in the preceding request.",
		envelope = PluginMessage.class,
		correspondingMessage = ConfigUpdateRequest.class)
public class ConfigUpdateResponse implements Body {
	@FieldDocumentation(
			description = "Result or intermediate status of the configuration update.",
			example = "APPLIED",
			nullable = false)
	private ConfigUpdateResponseStatus status;

	@FieldDocumentation(
			description = "Optional feedback message containing further configuration steps or information to be "
					+ "shown to the user via HCUweb. The message shall be provided in the requested language according "
					+ "to the language code included in the request. Plugins may fall back to a default language.",
			example = "Please press gateway button to proceed.",
			nullable = true)
	private String message;
}
