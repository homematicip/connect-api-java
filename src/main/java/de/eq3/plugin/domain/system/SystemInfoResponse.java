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

package de.eq3.plugin.domain.system;

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
		messageType = PluginMessageType.Fields.SYSTEM_INFO_RESPONSE,
		description = "Message sent by the Home Control Unit containing system information.",
		envelope = PluginMessage.class,
		correspondingMessage = SystemInfoRequest.class)
public class SystemInfoResponse implements Body {
	@FieldDocumentation(
			description = "Flag to indicate whether the request was successful.",
			nullable = false,
			example = "true")
	private boolean success;

	@FieldDocumentation(
			description = "Online mode flag. If true, the hcu is in online mode. If false, the hcu is in offline mode.",
			nullable = false)
	private boolean isOnlineMode;

	@FieldDocumentation(description = "The IP address of the Home Control Unit.", nullable = false)
	private String ipAddress;
}
