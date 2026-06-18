package energy.lux.esdl.core.loader.profile;

import energy.lux.esdl.core.loader.profile.bare.BareProfileChecker;
import energy.lux.esdl.core.loader.profile.bare.BareProfileReader;
import energy.lux.esdl.core.loader.profile.unit.OutsideTemperatureConverter;
import energy.lux.esdl.core.util.DateTimeUtil;
import esdl.EnergyMarket;
import esdl.EnvironmentalProfiles;
import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import com.zenmo.timeseries.untyped.TimeSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.OL_ProfileUnits;
import zerointerfaceloader.Zero_Loader;

import java.time.Year;

/**
 * Loads model-wide profiles
 */
public class GlobalProfileLoader {
    private static final Logger logger = LoggerFactory.getLogger(GlobalProfileLoader.class);

    private final Zero_Loader luxLoader;

    private final ProfilePointerFactory profilePointerFactory;

    private final BareProfileReader bareProfileReader;

    public GlobalProfileLoader(
            Zero_Loader luxLoader
    ) {
        this.luxLoader = luxLoader;

        var energyModel = luxLoader.energyModel;
        var timeParameters = energyModel.p_timeParameters;

        this.profilePointerFactory = new ProfilePointerFactory(energyModel);
        this.bareProfileReader = new BareProfileReader(
                DateTimeUtil.hoursToDuration(timeParameters.getTimeStep_h()),
                new BareProfileChecker(Year.of(timeParameters.getStartYear()))
        );
    }

    /**
     * This interprets the source data as Kelvin.
     * The ESDL specification says it should be Celsius.
     */
    public void loadOutsideTemperature(
            EnvironmentalProfiles environmentalProfiles
    ) {
        var temperatureProfile = environmentalProfiles.getOutsideTemperatureProfile();
        if (temperatureProfile == null) {
            return;
        }

        var bareTemperatureTimeSeries = this.bareProfileReader.readProfile(temperatureProfile);
        var temperatureTimeSeriesWithUnit = OutsideTemperatureConverter.timeSeriesToLuxUnit(
                bareTemperatureTimeSeries,
                temperatureProfile.getProfileQuantityAndUnit()
        );
        var temperatureProfilePointer = this.profilePointerFactory.timeSeriesToProfilePointer(
                temperatureTimeSeriesWithUnit,
                "esdl_outside_temperature_deg_c"
        );

        luxLoader.energyModel.pp_ambientTemperature_degC = temperatureProfilePointer;
    }

    /**
     * TODO: This assumes that only electricity prices are given.
     */
    public void loadDayAheadElectricityPricing(
            EnergyMarket energyMarket
    ) {
        var marketPrice = energyMarket.getMarketPrice();
        if (marketPrice == null) {
            return;
        }

        var priceTimeSeries = this.bareProfileReader.readProfile(marketPrice);
        for (var value : priceTimeSeries.copyValuesArray()) {
            if (value < -1000 || value > 10_000) {
                logger.error(
                        "Day-ahead electricity price {} €/MWh is outside the expected range [-1000, 10_000] €/MWh",
                        value
                );
            }
        }
        var priceProfilePointer = this.profilePointerFactory.timeSeriesToProfilePointer(
                priceTimeSeries,
                "esdl_day_ahead_electricity_pricing_eur_per_mwh",
                OL_ProfileUnits.PRICE_EURPMWH
        );
        luxLoader.energyModel.pp_dayAheadElectricityPricing_eurpMWh = priceProfilePointer;
    }

    public void loadSolarIrradiance(
            EnvironmentalProfiles environmentalProfiles
    ) {
        var solarIrradianceProfile = environmentalProfiles.getSolarIrradianceProfile();
        if (solarIrradianceProfile == null) {
            return;
        }
        logger.warn("Solar irradiance not loaded, don't know how to convert it to the LUX format");
    }
}
