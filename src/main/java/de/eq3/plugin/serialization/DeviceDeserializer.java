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

package de.eq3.plugin.serialization;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import de.eq3.plugin.domain.device.Device;
import de.eq3.plugin.domain.features.IFeature;

public final class DeviceDeserializer extends JsonDeserializer<Device> {
	@Override
	public Device deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		JsonNode jsonNode = ctx.readTree(jp);

		Device device = jp.getCodec().treeToValue(jsonNode, Device.class);

		if (!hasRequiredFeatures(device)) {
			throw new IllegalArgumentException("Device is missing required features "
					+ device.getDeviceType().getRequiredFeatures() + " for device type " + device.getDeviceType());
		}

		Set<Feature> invalidFeatures = getInvalidFeatures(device);

		if (!invalidFeatures.isEmpty()) {
			throw new IllegalArgumentException("Device contains invalid features " + invalidFeatures
					+ " for device type " + device.getDeviceType());
		}
		return device;
	}

	private boolean hasRequiredFeatures(Device device) {
		return device.getFeatures()
				.stream()
				.map(IFeature::getType)
				.collect(Collectors.toSet())
				.containsAll(device.getDeviceType().getRequiredFeatures());
	}

	private Set<Feature> getInvalidFeatures(Device device) {
		return device.getFeatures()
				.stream()
				.filter(feature -> !device.getDeviceType().getRequiredFeatures().contains(feature.getType())
						&& !device.getDeviceType().getOptionalFeatures().contains(feature.getType()))
				.map(IFeature::getType)
				.collect(Collectors.toSet());
	}
}