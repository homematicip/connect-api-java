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

package de.eq3.plugin.domain.control;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.documentation.SystemSentMessageDocumentation;
import de.eq3.plugin.domain.Body;
import de.eq3.plugin.domain.features.IFeature;
import de.eq3.plugin.serialization.FeatureDeserializer;
import de.eq3.plugin.serialization.PluginMessage;
import de.eq3.plugin.serialization.PluginMessageType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@SystemSentMessageDocumentation(
		messageType = PluginMessageType.Fields.CONTROL_REQUEST,
		description = "Message sent by the Home Control Unit to control a plugin device. Contains supported features "
				+ "and their desired target values. The values of features not included in the set shall remain unchanged.",
		envelope = PluginMessage.class,
		correspondingMessage = ControlResponse.class)
public class ControlRequest implements Body {
	@FieldDocumentation(
			description = "Unique identifier of the plugin device to be controlled.",
			example = "c0acf4e7-6e23-42cf-ae93-364f65b9e22a",
			nullable = false)
	private String deviceId;

	@JsonDeserialize(contentUsing = FeatureDeserializer.class)
	@FieldDocumentation(
			description = "Set of features with target values.",
			example = "[{\"dimLevel\":0.20,\"type\":\"dimming\"},{\"on\":true,\"type\":\"switchState\"}]",
			nullable = false)
	private Set<IFeature> features;

	@JsonCreator
	public ControlRequest(@JsonProperty(value = "deviceId", required = true) String deviceId,
			@JsonProperty(value = "features", required = true) Set<IFeature> features) {

		this.deviceId = deviceId;
		this.features = features;
	}
}
