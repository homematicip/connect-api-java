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

package de.eq3.plugin.domain.control;

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
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Jacksonized
@PluginSentMessageDocumentation(
		messageType = PluginMessageType.Fields.HMIP_SYSTEM_REQUEST,
		description = "Message sent by the plugin get the current system state or to control devices, groups or other "
				+ "functions of the Homematic IP system. Refer to the <<hmip_system_requests>> chapter for the "
				+ "documentation of all available paths and corresponding body schemas.",
		envelope = PluginMessage.class,
		correspondingMessage = HmipSystemResponse.class)
public class HmipSystemRequest implements Body {
	@FieldDocumentation(
			description = "Path of the request.",
			example = "/hmip/device/control/setSwitchState",
			nullable = false)
	private String path;

	@FieldDocumentation(
			description = "Body of the request, structured according to the schema defined for the request path. "
					+ "If the schema has no parameters, include an empty JSON.",
			example = "{\"on\":true,\"channelIndex\":1,\"deviceId\":\"3014F711A000000000001234\"}",
			nullable = false)
	private Object body;

}
