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

package de.eq3.plugin.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.documentation.SchemaDocumentation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@SchemaDocumentation(
		description = "Schema of an error object that may be included in response messages sent by the plugin or the "
				+ "Home Control Unit when an error occurs while processing a request.")
public class Error {
	@FieldDocumentation(
			description = "A code used to categorize the error, typically a number or enumerated type, for internal "
					+ "use by the Home Control Unit to differentiate error types received from the plugin.",
			example = "BRIDGE_OFFLINE",
			nullable = false)
	private String code;
	@FieldDocumentation(
			description = "An optional message that provides additional details or context about the error.",
			example = "Failed to process the request because the bridge is currently not responding.",
			nullable = true)
	private String message;
}
