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
@SchemaDocumentation(description = "Template for a group in which properties are presented together.")
public class GroupTemplate implements Body {
	@FieldDocumentation(description = "A human readable name of the group.", example = "Network", nullable = false)
	private String friendlyName;

	@FieldDocumentation(
			description = "A human readable description of the group.",
			example = "Settings of gateway in the local network.",
			nullable = true)
	private String description;

	@FieldDocumentation(
			description = "The order of this group. "
					+ "HCUweb presents property groups sorted by order, starting with the lowest order at the top. "
					+ "Orders do not need do be sequential, i.e. gaps are possible (e.g. 0, 100, 300).",
			example = "1",
			nullable = true)
	private Integer order;

	public GroupTemplate(String friendlyName) {
		this.friendlyName = friendlyName;
	}

}
