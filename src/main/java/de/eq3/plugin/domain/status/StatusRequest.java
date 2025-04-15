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
		messageType = PluginMessageType.Fields.STATUS_REQUEST,
		description = "Message sent by the Home Control Unit to obtain current status data of some or all plugin devices.",
		envelope = PluginMessage.class,
		correspondingMessage = StatusResponse.class)
public class StatusRequest implements Body {
	@FieldDocumentation(
			description = "Optional set of unique identifiers of the devices that shall be included in the response. "
					+ "If omitted, all devices shall be included in the response.",
			nullable = true)
	private Set<String> deviceIds;
}
