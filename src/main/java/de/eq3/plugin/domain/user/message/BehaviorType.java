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

import de.eq3.plugin.documentation.TypeDocumentation;
import de.eq3.plugin.documentation.TypeValueDocumentation;

@TypeDocumentation(
		description = "Behavior type of a user message created by a plugin to be shown in the Homematic IP smartphone "
				+ "app. Used by app to enable the user to dismiss or acknowledge the message, or to prevent the user "
				+ "from dismissing it.")
public enum BehaviorType {

	@TypeValueDocumentation(description = "Users may not dismiss the user message in the Homematic IP smartphone app.")
	NOT_DISMISSIBLE,

	@TypeValueDocumentation(
			description = "Users may dismiss the user message in the Homematic IP smartphone app. "
					+ "The plugin will not receive an acknowledgement event when the message is dismissed.")
	DISMISSIBLE,

	@TypeValueDocumentation(
			description = "Users may acknowledge and thereby dismiss the user message in the Homematic IP "
					+ "smartphone app. The plugin will receive an acknowledgement event with AckType OK when "
					+ "the message is acknowledged.")
	ACKNOWLEDGEABLE_BY_OK,

	@TypeValueDocumentation(
			description = "Users may acknowledge the user message by selecting YES or NO in the Homematic IP "
					+ "smartphone app. The plugin will receive an acknowledgement event with AckType YES or NO "
					+ "when the message is acknowledged. The plugin may then dismiss the user message by sending a "
					+ "delete user message request.")
	ACKNOWLEDGEABLE_BY_YES_NO
}
