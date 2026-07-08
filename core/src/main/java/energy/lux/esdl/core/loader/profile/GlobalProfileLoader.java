package energy.lux.esdl.core.loader.profile;

import energy.lux.esdl.core.loader.profile.bare.BareProfileChecker;
import energy.lux.esdl.core.loader.profile.bare.BareProfileReader;
import energy.lux.esdl.core.loader.profile.unit.DayAheadElectricityPriceConverter;
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

    public void loadDayAheadElectricityPricing(
            EnergyMarket energyMarket
    ) {
        var marketPrice = energyMarket.getMarketPrice();
        if (marketPrice == null) {
            logger.warn("Loading EnergyMarket without price profile is not implemented");
            return;
        }

        var barePriceTimeSeries = this.bareProfileReader.readProfile(marketPrice);
        var priceTimeSeriesWithUnit = DayAheadElectricityPriceConverter.timeSeriesToLuxUnit(
                barePriceTimeSeries,
                marketPrice.getProfileQuantityAndUnit()
        );
        var priceProfilePointer = this.profilePointerFactory.timeSeriesToProfilePointer(
                priceTimeSeriesWithUnit.timeSeries(),
                "esdl_day_ahead_electricity_pricing_eur_per_mwh",
                priceTimeSeriesWithUnit.unit()
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
