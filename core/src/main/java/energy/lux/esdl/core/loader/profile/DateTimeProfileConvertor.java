package energy.lux.esdl.core.loader.profile;

import energy.lux.esdl.core.util.DateTimeUtil;
import esdl.DateTimeProfile;
import esdl.ProfileElement;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class DateTimeProfileConvertor {
    static UnitlessProfile convertDateTimeProfile(
            DateTimeProfile esdlProfile,
            int startYear,
            Function<Double, Double> valueTransformer
    ) {
        var profileElements = sorted(esdlProfile.getElement());
        if (profileElements.isEmpty()) {
            throw new RuntimeException("Need at least one element in DateTimeProfile");
        }

        var luxStart = DateTimeUtil.luxJan1stInstant(startYear);

        var startRelativeToLux_h = DateTimeUtil.hoursBetween(luxStart, profileElements.get(0).getFrom());
        var values = new double[profileElements.size()];

        var i = 0;
        for (var element : profileElements) {
            values[i] = valueTransformer.apply(element.getValue());
            i++;
        }

        return new UnitlessProfile(startRelativeToLux_h, getStepInHours(profileElements), values);
    }

    private static List<ProfileElement> sorted(List<ProfileElement> profileElements) {
        return profileElements
                .stream()
                .sorted(Comparator.comparing(ProfileElement::getFrom))
                .toList();
    }

    private static double getStepInHours(List<ProfileElement> profileElements) {
        return DateTimeUtil.hoursBetween(profileElements.get(0).getFrom(), profileElements.get(0).getTo());
    }
}
