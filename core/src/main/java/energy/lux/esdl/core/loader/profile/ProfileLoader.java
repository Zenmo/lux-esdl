package energy.lux.esdl.core.loader.profile;

import energy.lux.esdl.core.NotImplemented;
import esdl.DateTimeProfile;
import esdl.EnergyMarket;
import esdl.EnvironmentalProfiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.J_ProfilePointer;
import zero_engine.OL_ProfileUnits;
import zerointerfaceloader.Zero_Loader;

import java.util.function.Function;

public class ProfileLoader {
    private static final Logger logger = LoggerFactory.getLogger(ProfileLoader.class);

    /**
     * This interprets the source data as Kelvin.
     * The ESDL specification says it should be Celsius.
     */
    public static void loadOutsideTemperature(
            EnvironmentalProfiles environmentalProfiles,
            Zero_Loader luxLoader
    ) {
        var temperatureProfile = environmentalProfiles.getOutsideTemperatureProfile();
        if (temperatureProfile == null) {
            return;
        }

        var luxModel = luxLoader.energyModel;
        var startYear = luxLoader.energyModel.p_timeParameters.getStartYear();

        luxModel.pp_ambientTemperature_degC = ProfileConverterSwitch.builder()
                .luxStartYear(startYear)
                .build()
                .doSwitch(temperatureProfile)
                .toLuxProfile(luxModel, "esdl_outside_temperature_deg_c", OL_ProfileUnits.TEMPERATURE_DEGC);
    }

    public static double kelvinToCelsius(double v) {
        return v - 273.15;
    }

    /**
     * TODO: This assumes that only electricity prices are given.
     */
    public static void loadDayAheadElectricityPricing(
            EnergyMarket energyMarket,
            Zero_Loader luxLoader
    ) {
        var startYear = luxLoader.energyModel.p_timeParameters.getStartYear();
        var unitlessProfile = ProfileConverterSwitch.builder().luxStartYear(startYear).build().doSwitch(energyMarket.getMarketPrice());
        for (var value : unitlessProfile.values()) {
            if (value < -1000 || value > 10_000) {
                logger.error(
                        "Day-ahead electricity price {} €/MWh is outside the expected range [-1000, 10_000] €/MWh",
                        value
                );
            }
        }

        luxLoader.energyModel.pp_dayAheadElectricityPricing_eurpMWh = unitlessProfile.toLuxProfile(
                luxLoader.energyModel,
                "esdl_day_ahead_electricity_pricing_eur_per_mwh",
                OL_ProfileUnits.PRICE_EURPMWH
        );
    }

    public static void loadSolarIrradiance(
            EnvironmentalProfiles environmentalProfiles,
            Zero_Loader luxLoader
    ) {
        logger.warn("Solar irradiance not loaded, don't know how to convert it to the LUX format");
    }
}
