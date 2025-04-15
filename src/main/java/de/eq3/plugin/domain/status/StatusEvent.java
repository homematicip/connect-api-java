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

package de.eq3.plugin.domain.status;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.documentation.PluginSentMessageDocumentation;
import de.eq3.plugin.domain.Body;
import de.eq3.plugin.domain.features.IFeature;
import de.eq3.plugin.serialization.FeatureDeserializer;
import de.eq3.plugin.serialization.PluginMessage;
import de.eq3.plugin.serialization.PluginMessageType;
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
@PluginSentMessageDocumentation(
		messageType = PluginMessageType.Fields.STATUS_EVENT,
		description = "Message sent by the plugin containing a partial status update of a single plugin device.",
		envelope = PluginMessage.class)
public class StatusEvent implements Body {
	@FieldDocumentation(
			description = "Unique identifier of the device.",
			example = "662dba0f-13a9-4509-9b96-ca6deed7977d",
			nullable = false)
	private String deviceId;
	@FieldDocumentation(
			description = "Set of updated features. Not included features are assumed unchanged.",
			nullable = false)
	@JsonDeserialize(contentUsing = FeatureDeserializer.class)
	private Set<IFeature> features;
}
