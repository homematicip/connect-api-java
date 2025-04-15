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

package de.eq3.plugin.domain.features;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import de.eq3.plugin.documentation.FeatureDocumentation;
import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.serialization.Feature;
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
@FeatureDocumentation(description = "Feature representing general maintenance functions of a plugin device.")
public class Maintenance implements IFeature {
	@FieldDocumentation(
			description = "The type of this feature. Must match maintenance.",
			example = "maintenance",
			nullable = true)
	private final Feature type = Feature.MAINTENANCE;

	@FieldDocumentation(
			description = "Flag to indicate whether the device is currently unreachable.",
			example = "false",
			nullable = true)
	private Boolean unreach;

	@FieldDocumentation(
			description = "Flag to indicate whether the device's battery is low.",
			example = "false",
			nullable = true)
	private Boolean lowBat;

	@FieldDocumentation(
			description = "Flag to indicate whether the sabotage contact sensor of the device is triggered.",
			example = "false",
			nullable = true)
	private Boolean sabotage;

	public Boolean isUnreach() {
		return this.unreach;
	}

	public Boolean isLowBat() {
		return this.lowBat;
	}

	public Boolean isSabotage() {
		return this.sabotage;
	}
}
