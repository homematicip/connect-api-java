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

package de.eq3.plugin.domain.plugin;

import de.eq3.plugin.documentation.TypeDocumentation;
import de.eq3.plugin.documentation.TypeValueDocumentation;

@TypeDocumentation(
		description = "Enumerated type of the plugin state. Included in a <<PluginStateResponse>> sent by the plugin"
				+ " to the Home Control Unit.")
public enum PluginReadinessStatus {

	@TypeValueDocumentation(
			description = "The plugin is up and running. This status should be used to communicate to users that the " +
					"plugin is ready for usage, typically right after startup or after successfully applying a configuration update.")
	READY,

	@TypeValueDocumentation(
			description = "The plugin could not be started, or any other unexpected error occurred. This status should "
					+ "be used to communicate to users that the plugin is not functioning as expected.")
	ERROR,

	@TypeValueDocumentation(
			description = "The plugin has to be configured to work as intended. This status should be used to "
					+ "communicate to users that they have to configure the plugin via HCUweb.")
	CONFIG_REQUIRED;
}
