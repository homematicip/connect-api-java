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
		description = "Enumerated data type of a plugin configuration property defined in a property template.")
public enum PropertyType {

	@TypeValueDocumentation(
			description = "Type for string properties. In the property template, use the fields 'minimumLength', "
					+ "'maximumLength' and 'pattern' to define constraints.")
	STRING,

	@TypeValueDocumentation(
			description = "Type for floating point number properties. In the property template, use the fields "
					+ "'minimum' and 'maximum' to define constraints.")
	NUMBER,

	@TypeValueDocumentation(
			description = "Type for integer properties. In the property template, use the fields 'minimum' and "
					+ "'maximum' to define constraints.")
	INTEGER,

	@TypeValueDocumentation(description = "Type for boolean properties.")
	BOOLEAN,

	@TypeValueDocumentation(
			description = "Type for property with a predefined set of values. In the property template, use the "
					+ "field 'values' to provide the set of possible values.")
	ENUM,

	@TypeValueDocumentation(
			description = "Type for string properties with autocompletion. In the property template, use the field "
					+ "'values' for a list of possible values the user may select while typing.")
	TYPEAHEAD,

	@TypeValueDocumentation(
			description = "Type for string properties that cannot be modified by user. In the property template, use "
					+ "the field 'currentValue' for the read-only text.")
	READONLY,

	@TypeValueDocumentation(description = "Type for password properties. Will be displayed obscured.")
	PASSWORD,

	@TypeValueDocumentation(
			description = "Type for for weblink properties. In the property template, use the field 'currentValue' "
					+ "for the link and the field 'defaultValue' for additional info text.")
	WEBLINK,

	@TypeValueDocumentation(
			description = "Type for QR code properties. In the property template, use the field 'currentValue' for "
					+ "the text used to generate the QR code.")
	QRCODE
}
