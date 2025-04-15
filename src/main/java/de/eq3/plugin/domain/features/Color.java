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
@FeatureDocumentation(description = "Feature representing the light color of a plugin device.")
public class Color implements IFeature {
	public static final int HUE_LAST_VALUE = 360;
	public static final int HUE_IGNORE_VALUE = 361;
	public static final double SATURATION_LAST_VALUE = 1.005;
	public static final double SATURATION_IGNORE_VALUE = 1.01;

	@FieldDocumentation(
			description = "The type of this feature. Must match color.",
			example = "color",
			nullable = false)
	private final Feature type = Feature.COLOR;

	@FieldDocumentation(
			description = "The hue color value in degrees on the color wheel. Special values are  " + HUE_LAST_VALUE
					+ " for the last value and " + HUE_IGNORE_VALUE + " as the ignore value.",
			example = "240",
			minValue = "0",
			maxValue = "361",
			specialValues = { "" + HUE_LAST_VALUE, "" + HUE_IGNORE_VALUE },
			nullable = true)
	private Integer hue;

	@FieldDocumentation(
			description = "The color intensity. Special values are " + SATURATION_LAST_VALUE
					+ " for the last value and " + SATURATION_IGNORE_VALUE + " as the ignore value.",
			example = "0.5",
			minValue = "0",
			maxValue = "1",
			specialValues = { "" + SATURATION_LAST_VALUE, "" + SATURATION_IGNORE_VALUE },
			nullable = true)
	private Double saturationLevel;
}
