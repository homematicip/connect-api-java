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
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Jacksonized
@SystemSentMessageDocumentation(
		messageType = PluginMessageType.Fields.HMIP_SYSTEM_RESPONSE,
		description = "Message sent by the Home Control Unit containing the result of a preceding system request.",
		envelope = PluginMessage.class,
		correspondingMessage = HmipSystemRequest.class)
public class HmipSystemResponse implements Body {
	@FieldDocumentation(description = "Return code based on HTTP status codes.", example = "400", nullable = false)
	private int code;

	@FieldDocumentation(
			description = "Optional response body as JSON. If the return code is not 200, the body will typically be "
					+ "an error response containing the String representation of a more detailed error code. "
					+ "Refer to the <<error_glossary>> chapter for the documentation of all Homematic IP system error "
					+ "codes.",
			nullable = true,
			example = "{\"errorCode\":\"FEATURE_NOT_SUPPORTED\"}")
	private Object body;

}
