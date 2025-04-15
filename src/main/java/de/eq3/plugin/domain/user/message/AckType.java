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
		description = "Acknowledgement type of a user message created by a plugin to be shown in the Homematic IP "
				+ "smartphone app.")
public enum AckType {

	@TypeValueDocumentation(
			description = "User acknowledged the message with OK. "
					+ "Applicable for user messages with BehaviorType 'ACKNOWLEDGEABLE_BY_OK'.")
	OK,

	@TypeValueDocumentation(
			description = "User acknowledged the message with YES. "
					+ "Applicable for user messages with BehaviorType 'ACKNOWLEDGEABLE_BY_YES_NO'.")
	YES,

	@TypeValueDocumentation(
			description = "User acknowledged the message with NO. "
					+ "Applicable for user messages with BehaviorType 'ACKNOWLEDGEABLE_BY_YES_NO'.")
	NO
}