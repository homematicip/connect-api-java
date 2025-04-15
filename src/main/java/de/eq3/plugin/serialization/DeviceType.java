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

package de.eq3.plugin.serialization;

import java.util.Set;

import de.eq3.plugin.documentation.TypeDocumentation;
import de.eq3.plugin.documentation.TypeValueDocumentation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@TypeDocumentation(
		description = "Enumerated type of the plugin device archetypes. "
				+ "Each type supports a set of required and/or optional features.")
public enum DeviceType {

	@TypeValueDocumentation(description = "Type for device that can be switched on or off.")
	SWITCH(Set.of(Feature.SWITCH_STATE), Set.of(Feature.MAINTENANCE, Feature.ON_TIME)),

	@TypeValueDocumentation(description = "Type for lighting devices like light bulbs or light strips.")
	LIGHT(Set.of(Feature.SWITCH_STATE),
			Set.of(Feature.MAINTENANCE, Feature.DIMMING, Feature.COLOR_TEMPERATURE, Feature.COLOR, Feature.ON_TIME)),

	@TypeValueDocumentation(description = "Type for window covering devices like electric window shutters.")
	WINDOW_COVERING(Set.of(Feature.SHUTTER_LEVEL),
			Set.of(Feature.MAINTENANCE, Feature.SLATS_LEVEL, Feature.SHUTTER_DIRECTION)),

	@TypeValueDocumentation(
			description = "Type for devices like motion sensors that can detect presence in a room or area.")
	OCCUPANCY_SENSOR(Set.of(Feature.PRESENCE_DETECTED), Set.of(Feature.MAINTENANCE)),

	@TypeValueDocumentation(description = "Type for smoke detecting devices.")
	SMOKE_ALARM(Set.of(Feature.SMOKE_ALARM), Set.of(Feature.MAINTENANCE)),

	@TypeValueDocumentation(
			description = "Type for devices that can be triggered to send out single switch signals to the system, "
					+ "like buttons.")
	SWITCH_INPUT(Set.of(), Set.of(Feature.MAINTENANCE)),

	@TypeValueDocumentation(
			description = "Type for contact sensors detecting, for example, if a window is opened or closed.")
	CONTACT_SENSOR(Set.of(Feature.CONTACT_SENSOR_STATE), Set.of(Feature.MAINTENANCE)),

	@TypeValueDocumentation(description = "Type for heat pumps.")
	HEAT_PUMP(Set.of(Feature.CLIMATE_OPERATION_MODE),
			Set.of(Feature.MAINTENANCE, Feature.PRESENCE_MODE, Feature.SUPPLY_TEMPERATURE,
					Feature.HEATING_TEMPERATURE_OFFSET, Feature.COOLING_TEMPERATURE_OFFSET, Feature.HOT_WATER_BOOST)),

	@TypeValueDocumentation(
			description = "Type for thermostats, i.e. devices that can heat or cool to a setpoint temperature.")
	THERMOSTAT(Set.of(Feature.SET_POINT_TEMPERATURE),
			Set.of(Feature.MAINTENANCE, Feature.ACTUAL_TEMPERATURE, Feature.HUMIDITY, Feature.CO2CONCENTRATION)),

	@TypeValueDocumentation(description = "Type for sensors that measure particulate matter in the environment.")
	PARTICULATE_MATTER_SENSOR(Set.of(),
			Set.of(Feature.PARTICULATEMASS_ONE, Feature.PARTICULATEMASS_TWO_POINT_FIVE, Feature.PARTICULATEMASS_TEN,
					Feature.PARTICULATE_TYPICAL_SIZE, Feature.MAINTENANCE, Feature.ACTUAL_TEMPERATURE,
					Feature.HUMIDITY)),

	@TypeValueDocumentation(
			description = "Type for sensors measuring or detecting parameters of the environment, like the current "
					+ "temperature or whether it rains or not.")
	CLIMATE_SENSOR(Set.of(),
			Set.of(Feature.ACTUAL_TEMPERATURE, Feature.MAINTENANCE, Feature.HUMIDITY, Feature.ILLUMINATION,
					Feature.WINDSPEED, Feature.WINDDIRECTION, Feature.STORM, Feature.SUNSHINE,
					Feature.SUNSHINE_DURATION, Feature.RAINING, Feature.RAIN_COUNT, Feature.CO2CONCENTRATION)),

	@TypeValueDocumentation(description = "Type for water sensors.")
	WATER_SENSOR(Set.of(Feature.WATER_DETECTED), Set.of(Feature.MAINTENANCE, Feature.MOISTURE_DETECTED)),

	@TypeValueDocumentation(description = "Type for electric vehicle chargers.")
	EV_CHARGER(Set.of(Feature.CURRENT_POWER), Set.of(Feature.MAINTENANCE, Feature.ENERGY_COUNTER)),

	@TypeValueDocumentation(description = "Type for inverters like solar power inverters.")
	INVERTER(Set.of(Feature.CURRENT_POWER), Set.of(Feature.MAINTENANCE, Feature.ENERGY_COUNTER)),

	@TypeValueDocumentation(description = "Type for devices monitoring the energy input and output of other devices.")
	ENERGY_METER(Set.of(Feature.CURRENT_POWER), Set.of(Feature.MAINTENANCE, Feature.ENERGY_COUNTER)),

	@TypeValueDocumentation(
			description = "Type for grid connection points, i.e. the device that connects your home to the electrical grid.")
	GRID_CONNECTION_POINT(Set.of(Feature.CURRENT_POWER), Set.of(Feature.MAINTENANCE, Feature.ENERGY_COUNTER)),

	@TypeValueDocumentation(description = "Type for air conditioning devices.")
	HVAC(Set.of(Feature.CURRENT_POWER), Set.of(Feature.MAINTENANCE, Feature.ENERGY_COUNTER)),

	@TypeValueDocumentation(description = "Type for batteries.")
	BATTERY(Set.of(Feature.BATTERY_STATE), Set.of(Feature.MAINTENANCE, Feature.ENERGY_COUNTER, Feature.CURRENT_POWER)),

	@TypeValueDocumentation(description = "Type for electric vehicles.")
	VEHICLE(Set.of(Feature.BATTERY_STATE), Set.of(Feature.MAINTENANCE, Feature.VEHICLE_RANGE)),;

	private final Set<Feature> requiredFeatures;
	private final Set<Feature> optionalFeatures;
}
