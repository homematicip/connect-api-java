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

package de.eq3.plugin.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.eq3.plugin.domain.discover.DiscoverResponse;
import de.eq3.plugin.domain.features.ColorTemperature;
import de.eq3.plugin.serialization.PluginMessage;

class TestDeserializer {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String json = "{\n" +
				"  \"id\": \"myMessageId\",\n" +
				"  \"pluginId\": \"myPluginId\",\n" +
				"  \"type\": \"DISCOVER_RESPONSE\",\n" +
				"  \"body\": {\n" +
				"    \"success\": true,\n" +
				"    \"devices\": [\n" +
				"      {\n" +
				"        \"deviceId\": \"popel\",\n" +
				"        \"modelType\": \"SuperLight1000\",\n" +
				"        \"friendlyName\": \"Eine Lampe\",\n" +
				"        \"firmwareVersion\": \"brandneu\",\n" +
				"        \"deviceType\": \"LIGHT\",\n" +
				"        \"features\": [\n" +
				"          {\n" +
				"            \"type\": \"maintenance\",\n" +
				"            \"unreach\": true,\n" +
				"            \"lowBat\": true\n" +
				"          },\n" +
				"          {\n" +
				"            \"type\": \"switchState\",\n" +
				"            \"on\": \"false\"\n" +
				"          },\n" +
				"          {\n" +
				"            \"type\": \"dimming\",\n" +
				"            \"dimLevel\": 0.5\n" +
				"          },\n" +
				"          {\n" +
				"            \"type\": \"colorTemperature\",\n" +
				"            \"colorTemperature\": 4000,\n" +
				"            \"minimalColorTemperature\": 2000,\n" +
				"            \"maximumColorTemperature\": 7000\n" +
				"          },\n" +
				"          {\n" +
				"            \"type\": \"color\",\n" +
				"            \"hue\": 270,\n" +
				"            \"saturation\": 0.5\n" +
				"          }\n" +
				"        ]\n" +
				"      }\n" +
				"    ]\n" +
				"  }\n" +
				"}";

		try {
			System.out.println("Start Deserializer");
			PluginMessage<DiscoverResponse> message = new ObjectMapper().readValue(json, PluginMessage.class);

			String jsonStr = "{\"colorTemperature\":null,\"minimalColorTemperature\":2000,\"maximumColorTemperature\":10000}";

			ColorTemperature colorTemperature = new ObjectMapper().readValue(jsonStr, ColorTemperature.class);

//			Color color = new Color()

			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
