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

package de.eq3.plugin.domain.inclusion;

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
		messageType = PluginMessageType.Fields.INCLUSION_EVENT,
		description = "Message sent by the Home Control Unit to notify the plugin about the plugin devices that are "
				+ "currently included in the Homematic IP system. As a reaction to this event, the plugin is expected "
				+ "to send a status response including states of all included devices.",
		envelope = PluginMessage.class)
public class InclusionEvent implements Body {
	@FieldDocumentation(
			description = "Set of unique identifiers of the included devices.",
			example = "[\"0384bf83-8d26-4c0b-be69-c6fc35c93c41\", \"6c3bffe2-e275-4810-8d8c-42b914a9e05a\"]",
			nullable = false)
	private Set<String> deviceIds;
}
