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

package de.eq3.plugin.domain.user.message;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import de.eq3.plugin.documentation.FieldDocumentation;
import de.eq3.plugin.documentation.PluginSentMessageDocumentation;
import de.eq3.plugin.domain.Body;
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
		messageType = PluginMessageType.Fields.CREATE_USER_MESSAGE_REQUEST,
		description = "Message sent by the plugin for issuing a new user message to be shown in the Homematic IP "
				+ "smartphone app.",
		correspondingMessage = CreateUserMessageResponse.class,
		envelope = PluginMessage.class)
public class CreateUserMessageRequest implements Body {
	@FieldDocumentation(
			description = "Identifier of the user message to be created. If a user message with the same "
					+ "identifier already exists, the Homematic IP smartphone app will replace that message.",
			example = "c0acf4e7-6e23-42cf-ae93-364f65b9e22a",
			nullable = false)
	private String userMessageId;

	@FieldDocumentation(
			description = "The timestamp of issuing the user message.",
			example = "123456789",
			nullable = false)
	private long timestamp;

	@FieldDocumentation(
			description = "The category of the user message. Used by the Homematic IP smartphone app to show "
					+ "the message with applicable color and icon.",
			example = "ERROR",
			nullable = false)
	private MessageCategory messageCategory;

	@FieldDocumentation(
			description = "The behavior type of the user message. Used by the Homematic IP smartphone app to "
					+ "enable the user to dismiss or acknowledge the message, if applicable.",
			example = "NOT_DISMISSIBLE",
			nullable = false)
	private BehaviorType behaviorType;

	@FieldDocumentation(
			description = "Localized title of the user message. Keys must follow ISO 639-1 language codes.",
			example = "{\"en\": \"Connection error\", \"de\": \"Verbindungsfehler\"}",
			nullable = false)
	private Map<String, String> title;

	@FieldDocumentation(
			description = "Localized detailed message. Keys must follow ISO 639-1 language codes",
			example = "{\"en\": \"The connection to the bridge cannot be established.\", \"de\": \"Die Verbindung zur Bridge kann nicht aufgebaut werden.\"}",
			nullable = false)
	private Map<String, String> message;
}
