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

import java.util.Arrays;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonValue;

import de.eq3.plugin.documentation.TypeDocumentation;
import de.eq3.plugin.domain.features.ActualTemperature;
import de.eq3.plugin.domain.features.BatteryState;
import de.eq3.plugin.domain.features.CO2Concentration;
import de.eq3.plugin.domain.features.ClimateOperationMode;
import de.eq3.plugin.domain.features.Color;
import de.eq3.plugin.domain.features.ColorTemperature;
import de.eq3.plugin.domain.features.ContactSensorState;
import de.eq3.plugin.domain.features.CoolingTemperatureOffset;
import de.eq3.plugin.domain.features.CurrentPower;
import de.eq3.plugin.domain.features.Dimming;
import de.eq3.plugin.domain.features.EnergyCounter;
import de.eq3.plugin.domain.features.HeatingTemperatureOffset;
import de.eq3.plugin.domain.features.HotWaterBoost;
import de.eq3.plugin.domain.features.Humidity;
import de.eq3.plugin.domain.features.IFeature;
import de.eq3.plugin.domain.features.Illumination;
import de.eq3.plugin.domain.features.Maintenance;
import de.eq3.plugin.domain.features.MoistureDetected;
import de.eq3.plugin.domain.features.OnTime;
import de.eq3.plugin.domain.features.ParticulateMassOne;
import de.eq3.plugin.domain.features.ParticulateMassTen;
import de.eq3.plugin.domain.features.ParticulateMassTwoPointFive;
import de.eq3.plugin.domain.features.ParticulateTypicalSize;
import de.eq3.plugin.domain.features.PresenceDetected;
import de.eq3.plugin.domain.features.PresenceMode;
import de.eq3.plugin.domain.features.RainCount;
import de.eq3.plugin.domain.features.Raining;
import de.eq3.plugin.domain.features.SetPointTemperature;
import de.eq3.plugin.domain.features.ShutterDirection;
import de.eq3.plugin.domain.features.ShutterLevel;
import de.eq3.plugin.domain.features.SlatsLevel;
import de.eq3.plugin.domain.features.SmokeAlarm;
import de.eq3.plugin.domain.features.Storm;
import de.eq3.plugin.domain.features.Sunshine;
import de.eq3.plugin.domain.features.SunshineDuration;
import de.eq3.plugin.domain.features.SupplyTemperature;
import de.eq3.plugin.domain.features.SwitchState;
import de.eq3.plugin.domain.features.VehicleRange;
import de.eq3.plugin.domain.features.WaterlevelDetected;
import de.eq3.plugin.domain.features.WindDirection;
import de.eq3.plugin.domain.features.WindSpeed;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@TypeDocumentation(description = "Feature types for plugin devices to be included in the Homematic IP system.")
public enum Feature {
	// basic features
	MAINTENANCE("maintenance", Maintenance.class),

	PRESENCE_MODE("presenceMode", PresenceMode.class),

	// switching / light features
	SWITCH_STATE("switchState", SwitchState.class),

	DIMMING("dimming", Dimming.class),

	COLOR("color", Color.class),

	COLOR_TEMPERATURE("colorTemperature", ColorTemperature.class),

	ON_TIME("onTime", OnTime.class),

	// Shading features
	SHUTTER_LEVEL("shutterLevel", ShutterLevel.class),

	SHUTTER_DIRECTION("shutterDirection", ShutterDirection.class),

	SLATS_LEVEL("slatsLevel", SlatsLevel.class),

	// climate features
	HOT_WATER_BOOST("hotWaterBoost", HotWaterBoost.class),

	SUPPLY_TEMPERATURE("supplyTemperature", SupplyTemperature.class),

	HEATING_TEMPERATURE_OFFSET("heatingTemperatureOffset", HeatingTemperatureOffset.class),

	COOLING_TEMPERATURE_OFFSET("coolingTemperatureOffset", CoolingTemperatureOffset.class),

	CLIMATE_OPERATION_MODE("climateOperationMode", ClimateOperationMode.class),

	HUMIDITY("humidity", Humidity.class),

	SET_POINT_TEMPERATURE("setPointTemperature", SetPointTemperature.class),

	ACTUAL_TEMPERATURE("actualTemperature", ActualTemperature.class),

	ILLUMINATION("illumination", Illumination.class),

	WINDSPEED("windSpeed", WindSpeed.class),

	WINDDIRECTION("windDirection", WindDirection.class),

	STORM("storm", Storm.class),

	SUNSHINE("sunshine", Sunshine.class),

	SUNSHINE_DURATION("sunshineDuration", SunshineDuration.class),

	RAINING("raining", Raining.class),

	RAIN_COUNT("rainCount", RainCount.class),

	CO2CONCENTRATION("co2", CO2Concentration.class),

	PARTICULATEMASS_ONE("particulateMassConcentrationOne", ParticulateMassOne.class),

	PARTICULATEMASS_TWO_POINT_FIVE("particulateMassTwoPointFive", ParticulateMassTwoPointFive.class),

	PARTICULATEMASS_TEN("particulateMassTen", ParticulateMassTen.class),

	PARTICULATE_TYPICAL_SIZE("particulateTypicalSize", ParticulateTypicalSize.class),

	// Sensor features
	PRESENCE_DETECTED("presenceDetected", PresenceDetected.class),

	SMOKE_ALARM("smokeAlarm", SmokeAlarm.class),

	CONTACT_SENSOR_STATE("contactSensorState", ContactSensorState.class),

	MOISTURE_DETECTED("moistureDetected", MoistureDetected.class),

	WATER_DETECTED("waterlevelDetected", WaterlevelDetected.class),

	// HEMS features
	CURRENT_POWER("currentPower", CurrentPower.class),

	ENERGY_COUNTER("energyCounter", EnergyCounter.class),

	BATTERY_STATE("batteryState", BatteryState.class),

	VEHICLE_RANGE("vehicleRange", VehicleRange.class);

	@JsonValue
	@Getter
	private final String identifier;
	private final Class<? extends IFeature> mappingClazz;

	public static Optional<Feature> fromIdentifier(String identifier) {
		return Arrays.stream(values()).filter(feature -> feature.identifier.equals(identifier)).findFirst();
	}

	public <T> Class<T> getMappingClazz() {
		return (Class<T>) mappingClazz;
	}

	@Override
	public String toString() {
		return this.identifier;
	}
}
