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

package de.eq3.plugin.domain.device;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.documentation.SchemaDocumentation;
import de.eq3.plugin.domain.features.IFeature;
import de.eq3.plugin.serialization.DeviceType;
import de.eq3.plugin.serialization.FeatureDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@SchemaDocumentation(description = "Model for a plugin device to be included in a Homematic IP system.")
public class Device {
	@FieldDocumentation(
			description = "Unique identifier of the device.",
			example = "c0acf4e7-6e23-42cf-ae93-364f65b9e22a",
			nullable = false)
	private String deviceId;

	@FieldDocumentation(description = "A vendor specific model type.", example = "LTA004", nullable = true)
	private String modelType;

	@FieldDocumentation(
			description = "A describing label for the device.",
			example = "White Ambiance light bulb",
			nullable = true)
	private String friendlyName;

	@FieldDocumentation(
			description = "The firmware version currently running on the device.",
			example = "1.2.3",
			nullable = true)
	private String firmwareVersion;

	@FieldDocumentation(description = "One of the supported device archetypes.", example = "LIGHT", nullable = false)
	private DeviceType deviceType;

	@JsonDeserialize(contentUsing = FeatureDeserializer.class)
	@FieldDocumentation(
			description = "Supported features of the device. They must be either required or optional features "
					+ "of the corresponding device archetype.",
			nullable = true)
	private Set<IFeature> features;
}
