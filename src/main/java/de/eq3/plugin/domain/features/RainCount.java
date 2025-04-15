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
@FeatureDocumentation(description = "Feature representing the amount of rain measured by a plugin device.")
public class RainCount implements IFeature {
	@FieldDocumentation(
			description = "The type of this feature. Must match rainCount.",
			example = "rainCount",
			nullable = false)
	private final Feature type = Feature.RAIN_COUNT;

	@FieldDocumentation(
			description = "The total accumulated amount of rain in mm.",
			example = "12",
			minValue = "0",
			nullable = true)
	private Double rainCounter;

	@FieldDocumentation(
			description = "The accumulated amount of yesterday's rain in mm.",
			example = "12",
			minValue = "0",
			nullable = true)
	private Double yesterdayRainCounter;

	@FieldDocumentation(
			description = "The accumulated amount of today's rain in mm.",
			example = "12",
			minValue = "0",
			nullable = true)
	private Double todayRainCounter;
}
