package energy.lux.esdl.core.loader.profile.bare;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import com.zenmo.timeseries.untyped.TimeSeries;
import esdl.DateTimeProfile;
import esdl.ProfileElement;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

class DateTimeProfileReader {
    static ArrayTimeSeries convertDateTimeProfile(
        DateTimeProfile esdlProfile
    ) {
        var profileElements = sorted(esdlProfile.getElement());
        if (profileElements.isEmpty()) {
            throw new RuntimeException("Need at least one element in DateTimeProfile");
        }

        var values = new double[profileElements.size()];

        var i = 0;
        for (var element : profileElements) {
            values[i] = element.getValue();
            i++;
        }

        var timeSeriesWithEsdlStep = ArrayTimeSeries.builder()
                .step(getStep(profileElements))
                .values(values)
                .start(profileElements.get(0).getFrom().toInstant())
                .build();

        return timeSeriesWithEsdlStep;
    }

    private static List<ProfileElement> sorted(List<ProfileElement> profileElements) {
        return profileElements
                .stream()
                .sorted(Comparator.comparing(ProfileElement::getFrom))
                .toList();
    }

    private static Duration getStep(List<ProfileElement> profileElements) {
        return Duration.between(
                profileElements.get(0).getFrom().toInstant(),
                profileElements.get(0).getTo().toInstant()
        );
    }
}
