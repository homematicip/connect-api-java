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
@FeatureDocumentation(
		description = "Feature representing the mass concentration of particulate matter of size PM 1 measured "
				+ "by a plugin device.")
public class ParticulateMassOne implements IFeature {
	@FieldDocumentation(
			description = "The type of this feature. Must match particulateMassOne.",
			example = "particulateMassOne",
			nullable = false)
	private final Feature type = Feature.PARTICULATEMASS_ONE;

	@FieldDocumentation(
			description = "The mass concentration of particulate matter of size PM 1 in µg/m3.",
			example = "100",
			minValue = "0",
			nullable = true)
	private Double particulateMassConcentrationOne;

	@FieldDocumentation(
			description = "The average mass concentration of particulate matter of size PM 1 in µg/m3 over 24 h.",
			example = "100",
			minValue = "0",
			nullable = true)
	private Double particulateMassConcentrationOneAverage;

	@FieldDocumentation(
			description = "The number concentration of particulate matter of size PM 1  µg/cm3.",
			example = "100",
			minValue = "0",
			nullable = true)
	private Double particulateNumberConcentrationOne;

}
