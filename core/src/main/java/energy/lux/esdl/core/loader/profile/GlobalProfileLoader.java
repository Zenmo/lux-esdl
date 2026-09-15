package energy.lux.esdl.core.loader.profile;

import energy.lux.esdl.core.loader.profile.bare.BareProfileChecker;
import energy.lux.esdl.core.loader.profile.bare.BareProfileReader;
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
     * @return the outside temperature in Celsius, or null when the ESDL states none. It is
     * handed back as well as registered because the PV production model needs it too.
     */
    public ArrayTimeSeries loadOutsideTemperature(
            EnvironmentalProfiles environmentalProfiles
    ) {
        var temperatureProfile = environmentalProfiles.getOutsideTemperatureProfile();
        if (temperatureProfile == null) {
            return null;
        }

        var outsideTemperature_degC = this.bareProfileReader.readProfile(temperatureProfile);

        var temperatureProfilePointer = this.profilePointerFactory.timeSeriesToProfilePointer(
                outsideTemperature_degC,
                "esdl_outside_temperature_deg_c",
                OL_ProfileUnits.TEMPERATURE_DEGC
        );

        luxLoader.energyModel.pp_ambientTemperature_degC = temperatureProfilePointer;

        return outsideTemperature_degC;
    }

    /**
     * TODO: This assumes that only electricity prices are given.
     */
    public void loadDayAheadElectricityPricing(
            EnergyMarket energyMarket,
            TimeOfUseTariff timeOfUseTariff
    ) {
        var marketPrice = energyMarket.getMarketPrice();
        if (marketPrice == null) {
            return;
        }

        var priceTimeSeries = this.bareProfileReader.readProfile(marketPrice);

        // LUX has no time of use tariff of its own, so it is charged by raising the price
        // that the engine sees. Do this before the range check so it covers the final prices.
        if (timeOfUseTariff != null) {
            priceTimeSeries = timeOfUseTariff.addTo(priceTimeSeries);
            logger.info(
                    "Added a time of use tariff of up to {} EUR/MWh to the day-ahead electricity price",
                    timeOfUseTariff.peakTariff_eurpMWh()
            );
        }

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

    /**
     * The irradiance is not a profile that LUX uses on its own. It is the input the PV
     * production profiles are modelled from, so it is handed back to the caller rather than
     * registered with the engine.
     * It is resampled to the LUX time step, so the panels are modelled at the resolution the simulation runs at
     * rather than the ten minutes the ESDL files state.
     * @return global horizontal irradiance in W/m2, or null when the ESDL states none
     */
    public ArrayTimeSeries readSolarIrradiance(
            EnvironmentalProfiles environmentalProfiles
    ) {
        var solarIrradianceProfile = environmentalProfiles.getSolarIrradianceProfile();
        if (solarIrradianceProfile == null) {
            logger.info("The ESDL states no solar irradiance, PV profiles cannot be generated from it");
            return null;
        }

        return this.bareProfileReader.readProfile(solarIrradianceProfile);
    }
}
