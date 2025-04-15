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

package de.eq3.plugin.domain.config;

import de.eq3.plugin.documentation.TypeDocumentation;
import de.eq3.plugin.documentation.TypeValueDocumentation;

@TypeDocumentation(
		description = "Describes the result or intermediate status of a plugin configuration update that was "
				+ "triggered by a HCUweb user by updating the plugin configuration and saving the changes.")
public enum ConfigUpdateResponseStatus {

	@TypeValueDocumentation(description = "The plugin configuration update was applied successfully.")
	APPLIED,

	@TypeValueDocumentation(
			description = "The plugin configuration update is still pending, e.g. because applying it takes "
					+ "time or requires user interaction.")
	PENDING,

	@TypeValueDocumentation(description = "The plugin configuration update could not be applied.")
	FAILED
}
