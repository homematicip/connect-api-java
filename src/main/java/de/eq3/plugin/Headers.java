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

package de.eq3.plugin;

import de.eq3.plugin.documentation.HeaderDocumentation;
import de.eq3.plugin.documentation.HeaderValueDocumentation;
import lombok.Getter;

@HeaderDocumentation
public enum Headers {
	@HeaderValueDocumentation(
			description = "Unique identifier of your plugin",
			required = true,
			example = "de.doe.jane.plugin.example")
	PLUGIN_ID("plugin-id"),

	@HeaderValueDocumentation(
			description = "If true, your plugin will receive Homematic IP system events via WebSocket",
			required = false,
			example = "true")
	HMIP_SYSTEM_EVENTS("hmip-system-events"),

	@HeaderValueDocumentation(
			description = "Authorization token of a Connect API client associated to the plugin identifier. "
					+ "Installed plugins can find their authorization token in the /TOKEN file located in the "
					+ "root directory of their container.",
			required = true,
			example = "B23FB0DC7FDAA140CDF679D5F78F047C16CEF349691A3E9B425DE16E291E51DF")
	AUTHTOKEN("authtoken");

	@Getter
	final String value;

	Headers(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
