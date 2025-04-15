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
@FeatureDocumentation(description = "Feature representing the light color temperature of a plugin device.")
public class ColorTemperature implements IFeature {
	public static final int LAST_VALUE = 10050;
	public static final int IGNORE_VALUE = 10100;
	public static final int DIM_2_WARM = 10150;
	public static final int DYNAMIC_DAYLIGHT = 10200;

	@FieldDocumentation(
			description = "The type of this feature. Must match colorTemperature.",
			example = "colorTemperature",
			nullable = false)
	private final Feature type = Feature.COLOR_TEMPERATURE;

	@FieldDocumentation(
			description = "The lowest possible color temperature in Kelvin (°K).",
			example = "2000",
			minValue = "0",
			nullable = true)
	private Integer minimalColorTemperature;

	@FieldDocumentation(
			description = "The highest possible color temperature in Kelvin (°K).",
			example = "6500",
			minValue = "0",
			nullable = true)
	private Integer maximumColorTemperature;

	@FieldDocumentation(
			description = "The current color temperature in Kelvin (°K). The value must be between "
					+ "minimalColorTemperature and maximumColorTemperature. Additionally, allowed special values are "
					+ LAST_VALUE + " for the last value, " + IGNORE_VALUE + " for ignore value, " + DIM_2_WARM
					+ " for the dim2warm function and " + DYNAMIC_DAYLIGHT + " for the dynamic daylight function.",
			example = "6500",
			minValue = "0",
			specialValues = { "" + LAST_VALUE, "" + IGNORE_VALUE, "" + DIM_2_WARM, "" + DYNAMIC_DAYLIGHT },
			nullable = true)
	private Integer colorTemperature;

}
