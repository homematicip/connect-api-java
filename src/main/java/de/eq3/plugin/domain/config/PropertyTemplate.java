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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.documentation.SchemaDocumentation;
import de.eq3.plugin.domain.Body;
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
@SchemaDocumentation(description = "Template for plugin configuration properties and associated constraints.")
public class PropertyTemplate implements Body {
	@FieldDocumentation(
			description = "A human readable friendly name of the parameter.",
			example = "Example parameter",
			nullable = false)
	private String friendlyName;

	@FieldDocumentation(description = "Enumerated data type of the parameter.", example = "STRING", nullable = false)
	private PropertyType dataType;

	@FieldDocumentation(
			description = "A human readable description of the parameter.",
			example = "IP-Address of the gateway.",
			nullable = true)
	private String description;

	@FieldDocumentation(
			description = "Determines whether the parameter is required or optional.",
			example = "true",
			nullable = true)
	private Boolean required;

	@FieldDocumentation(
			description = "The order of this property. "
					+ "HCUweb presents properties sorted by order, starting with the lowest order at the top. "
					+ "Orders do not have do be sequential, i.e. gaps are possible (e.g. 0, 100, 300).",
			example = "1",
			nullable = true)
	private Integer order;

	@FieldDocumentation(
			description = "A minimum value for numeric parameters like 'INTEGER'.",
			example = "1",
			nullable = true)
	private Integer minimum;

	@FieldDocumentation(
			description = "A maximum value for numeric parameters like 'INTEGER'.",
			example = "99",
			nullable = true)
	private Integer maximum;

	@FieldDocumentation(
			description = "A minimum length for text-based parameters like 'STRING' or 'PASSWORD'.",
			example = "20",
			nullable = true)
	private Integer minimumLength;

	@FieldDocumentation(
			description = "A maximum length for text based parameters like 'STRING' or 'PASSWORD'.",
			example = "255",
			nullable = true)
	private Integer maximumLength;

	@FieldDocumentation(
			description = "A pattern for text-based parameters like 'STRING' or 'PASSWORD' to match. "
					+ "The pattern has to be a regular expression with ECMAScript (JavaScript) syntax and semantics. "
					+ "The example contains a pattern for a string of exactly 5 letters from A to Z.",
			example = "^[A-Z]{5}$",
			nullable = true)
	private String pattern;

	@FieldDocumentation(
			description = "A default value for the parameter.",
			example = "Lorem ipsum dolor sit amet.",
			nullable = true)
	private String defaultValue;

	@FieldDocumentation(
			description = "The currently configured parameter value.",
			example = "127.0.0.1",
			nullable = true)
	private String currentValue;

	@FieldDocumentation(
			description = "List of possible values a parameter may be set to. Applicable for text-based parameters "
					+ "with predefined values to choose from, like 'ENUM' or 'TYPEAHEAD'.",
			example = "[\"RED\", \"GREEN\", \"BLUE\"]",
			nullable = true)
	private List<String> values;

	@FieldDocumentation(
			description = "Identifier of the group in which HCUweb shall present this property.",
			example = "exampleGroup",
			nullable = true)
	private String groupId;

	public PropertyTemplate(String friendlyName, String description, boolean required, PropertyType dataType) {
		this.friendlyName = friendlyName;
		this.description = description;
		this.required = required;
		this.dataType = dataType;
	}

	public Boolean isRequired() {
		return required;
	}
}
