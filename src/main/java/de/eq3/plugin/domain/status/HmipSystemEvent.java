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
		messageType = PluginMessageType.Fields.HMIP_SYSTEM_EVENT,
		description = "Message sent by the Home Control Unit containing a partial status update of the Homematic IP "
				+ "system. The updated system components are represented as push events of various types within a "
				+ "transaction object. Refer to the <<hmip_system_events>> chapter for the documentation "
				+ "of the transaction object and all available push event types.",
		envelope = PluginMessage.class)
public class HmipSystemEvent implements Body {
	@FieldDocumentation(
			description = "Transaction object containing <<hmip_system_events,push events>>.",
			example = "{\"origin\":{\"originType\":\"DEVICE\",\"id\":\"3014F711A00000C000000ABC\"},"
					+ "\"accessPointId\":\"3014F711A00000C000000ABC\",\"timestamp\":1744111671079,"
					+ "\"events\":{\"0\":{\"pushEventType\":\"DEVICE_CHANGED\","
					+ "\"device\":{\"id\":\"3014F711A00000C000000ABC\","
					+ "\"homeId\":\"a36f0853-fb07-4bc9-a9e8-0a8598696b81\",\"type\":\"PLUGGABLE_DIMMER\","
					+ "\"modelType\":\"HmIP-PDT\",\"label\":\"Dimmer\",\"permanentlyReachable\":true,"
					+ "\"functionalChannels\":{\"0\":{\"label\":\"\",\"deviceId\":\"3014F711A00000C000000ABC\","
					+ "\"index\":0,\"groupIndex\":0,\"functionalChannelType\":\"DEVICE_BASE\","
					+ "\"groups\":[\"3e9872bc-b339-41ae-b9be-d56d0290768a\"],\"unreach\":false,\"dutyCycle\":false},"
					+ "\"1\":{\"label\":\"\",\"deviceId\":\"3014F711A00000C000000ABC\",\"index\":1,\"groupIndex\":1,"
					+ "\"functionalChannelType\":\"DIMMER_CHANNEL\","
					+ "\"groups\":[\"adbe5e27-5af0-40bb-b33a-efdfa030ff82\"],\"channelRole\":\"DIMMING_ACTUATOR\","
					+ "\"on\":true,\"dimLevel\":1.0}}}}}}",
			nullable = false)
	private Object eventTransaction;
}
