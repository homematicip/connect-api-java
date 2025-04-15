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

package de.eq3.plugin.domain.status;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.documentation.PluginSentMessageDocumentation;
import de.eq3.plugin.domain.Body;
import de.eq3.plugin.domain.device.Device;
import de.eq3.plugin.domain.error.Error;
import de.eq3.plugin.serialization.DeviceDeserializer;
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
		messageType = PluginMessageType.Fields.STATUS_RESPONSE,
		description = "Message sent by the plugin containing full device and feature status data for previously "
				+ "requested devices. May be sent unsolicited.",
		envelope = PluginMessage.class,
		correspondingMessage = StatusRequest.class)
public class StatusResponse implements Body {
	@FieldDocumentation(
			description = "Flag to indicate whether the retrieval of state was successful.",
			nullable = false)
	private boolean success;
	@FieldDocumentation(description = "Set of plugin devices with their current status data.", nullable = false)
	@JsonDeserialize(contentUsing = DeviceDeserializer.class)
	private Set<Device> devices;
	@FieldDocumentation(
			description = "Optional error object to provide further information on failure.",
			nullable = true,
			example = "null")
	private Error error;
}
