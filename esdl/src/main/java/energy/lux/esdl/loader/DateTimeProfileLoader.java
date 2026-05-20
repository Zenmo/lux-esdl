package energy.lux.esdl.loader;

import energy.lux.esdl.DateTimeUtil;
import energy.lux.esdl.NotImplemented;
import energy.lux.esdl.iterator.RootIterator;
import esdl.DateTimeProfile;
import esdl.EnergyMarket;
import esdl.EnvironmentalProfiles;
import esdl.ProfileElement;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.J_ProfilePointer;
import zero_engine.OL_ProfileUnits;
import zerointerfaceloader.Zero_Loader;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class DateTimeProfileLoader {
    private static final Logger logger = LoggerFactory.getLogger(RootIterator.class);

    /**
     * This interprets the source data as Kelvin.
     * The ESDL specification says it should be Celsius.
     */
    public static void loadOutsideTemperature(
            EnvironmentalProfiles environmentalProfiles,
            Zero_Loader luxLoader
    ) {
        var luxModel = luxLoader.energyModel;

        if (environmentalProfiles.getOutsideTemperatureProfile() instanceof DateTimeProfile outsideTemperatureProfile) {
            luxModel.pp_ambientTemperature_degC = DateTimeProfileLoader.createProfilePointer(
                    luxLoader,
                    outsideTemperatureProfile,
                    "esdl_outside_temperature_deg_c",
                    OL_ProfileUnits.TEMPERATURE_DEGC,
                    v -> v - 273.15
            );
        } else {
            throw new NotImplemented("Outside temperature profile is only implemented for DateTimeProfile");
        }
    }

    /**
     * TODO: This assumes that only electricity prices are given.
     */
    public static void loadDayAheadElectricityPricing(
            EnergyMarket energyMarket,
            Zero_Loader luxLoader
    ) {
        if (energyMarket.getMarketPrice() instanceof DateTimeProfile marketPriceProfile) {
            var elements = sorted(marketPriceProfile.getElement());

            for (var element : elements) {
                double value = element.getValue();
                if (value < -1.0 || value > 10.0) {
                    throw new IllegalArgumentException(
                            "Day-ahead electricity price " + value + " €/kWh is outside the expected range [-1.0, 10.0] €/kWh"
                    );
                }
            }

            luxLoader.energyModel.pp_dayAheadElectricityPricing_eurpMWh = createProfilePointer(
                    luxLoader,
                    marketPriceProfile,
                    "esdl_day_ahead_electricity_pricing_eur_per_mwh",
                    OL_ProfileUnits.PRICE_EURPMWH,
                    v -> v * 1000.0
            );
        }
    }

    public static void loadSolarIrradiance(
            EnvironmentalProfiles environmentalProfiles,
            Zero_Loader luxLoader
    ) {
        logger.warn("Solar irradiance not loaded, don't know how to convert it to the LUX format");
    }

    static J_ProfilePointer createProfilePointer(
            Zero_Loader luxLoader,
            DateTimeProfile esdlProfile,
            String profileId,
            OL_ProfileUnits unit
    ) {
        return createProfilePointer(luxLoader, esdlProfile, profileId, unit, v -> v);
    }

    static J_ProfilePointer createProfilePointer(
            Zero_Loader luxLoader,
            DateTimeProfile esdlProfile,
            String profileId,
            OL_ProfileUnits unit,
            Function<Double, Double> valueTransformer
    ) {
        var elements = sorted(esdlProfile.getElement());
        // TODO: give a warning if the time series is outside of the simulation year

        var hoursValues = toHoursValues(elements, luxLoader.getYear(), valueTransformer);

        return luxLoader.f_createEngineProfile(
            profileId,
            hoursValues.hours,
            hoursValues.values,
            unit
        );
    }

    static private HoursValues toHoursValues(
            List<ProfileElement> profileElements,
            int startYear,
            Function<Double, Double> valueTransformer
    ) {
        var luxStart = DateTimeUtil.luxJan1stInstant(startYear);

        var hours = new double[profileElements.size()];
        var values = new double[profileElements.size()];

        var i = 0;
        for (var element : profileElements) {
            hours[i] = DateTimeUtil.hoursBetween(luxStart, element.getFrom());
            values[i] = valueTransformer.apply(element.getValue());
            i++;
        }

        return new HoursValues(hours, values);
    }

    static private List<ProfileElement> sorted(EList<ProfileElement> profileElements) {
        return profileElements
                .stream()
                .sorted(Comparator.comparing(ProfileElement::getFrom))
                .toList();
    }

    /**
     * Pair array of hours from jan 1st of the year set in LUX
     * with corresponding array of values.
     */
    private record HoursValues(
            double[] hours,
            double[] values
    ) {}
}
