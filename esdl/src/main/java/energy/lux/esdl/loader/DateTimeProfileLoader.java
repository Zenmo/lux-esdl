package energy.lux.esdl.loader;

import energy.lux.esdl.NotImplemented;
import esdl.DateTimeProfile;
import esdl.EnvironmentalProfiles;
import esdl.ProfileElement;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.J_ProfilePointer;
import zero_engine.OL_ProfileUnits;
import zerointerfaceloader.Zero_Loader;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DateTimeProfileLoader {
    private static final Logger logger = LoggerFactory.getLogger(RootLoader.class);

    static void loadOutsideTemperature(
            EnvironmentalProfiles environmentalProfiles,
            Zero_Loader luxLoader
    ) {
        var luxModel = luxLoader.energyModel;

        if (environmentalProfiles.getOutsideTemperatureProfile() instanceof DateTimeProfile outsideTemperatureProfile) {
            luxModel.pp_ambientTemperature_degC = DateTimeProfileLoader.createProfilePointer(
                    luxLoader,
                    outsideTemperatureProfile,
                    "esdl_outside_temperature_deg_c",
                    OL_ProfileUnits.TEMPERATURE_DEGC
            );
        } else {
            throw new NotImplemented("Outside temperature profile is only implemented for DateTimeProfile");
        }
    }

    static void loadSolarIrradiance(
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
        var elements = sorted(esdlProfile.getElement());
        // TODO: give a warning if the time series is outside of the simulation year

        var hoursValues = toHoursValues(elements, luxLoader.getYear());

        return luxLoader.f_createEngineProfile(
            profileId,
            hoursValues.hours,
            hoursValues.values,
            unit
        );
    }

    static private HoursValues toHoursValues(
            List<ProfileElement> profileElements,
            int startYear
    ) {
        var luxStart = luxJan1stInstant(startYear);

        var hours = new double[profileElements.size()];
        var values = new double[profileElements.size()];

        var i = 0;
        for (var element : profileElements) {
            hours[i] = hoursBetween(luxStart, element.getFrom());
            values[i] = element.getValue();
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

    static private Instant luxJan1stInstant(int year) {
        // LUX usually runs in the timezone Europe/Amsterdam
        var timeZone = ZoneId.of("Europe/Amsterdam");
        return ZonedDateTime.of(year, 1, 1, 0, 0, 0, 0, timeZone)
                .toInstant();
    }

    static private double hoursBetween(Instant from, Date to) {
         var milliseconds = to.getTime() - from.toEpochMilli();
         return (double) milliseconds / Duration.ofHours(1).toMillis();
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
