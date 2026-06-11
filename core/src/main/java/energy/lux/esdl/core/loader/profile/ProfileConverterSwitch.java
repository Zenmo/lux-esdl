package energy.lux.esdl.core.loader.profile;

import energy.lux.esdl.core.util.Util;
import esdl.DateTimeProfile;
import esdl.GenericProfile;
import esdl.TimeSeriesProfile;
import esdl.util.EsdlSwitch;
import lombok.Builder;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

import java.util.function.Function;

/**
 * Convert ESDL profiles to the format used by LUX Profiles.
 */
@Builder
public class ProfileConverterSwitch extends EsdlSwitch<UnitlessProfile> {
    private int luxStartYear;

    /**
     * Function to do simple conversions between the units used in ESDL and in LUX.
     */
    @NonNull
    @Builder.Default
    private Function<Double, Double> valueTransformer = d -> d;

    @Override
    public UnitlessProfile defaultCase(EObject object) {
        throw new RuntimeException(
                String.format(
                        "%s can only process profiles, found %s",
                        this.getClass().getSimpleName(),
                        Util.printObject(object)
                )
        );
    }

    @Override
    public UnitlessProfile caseGenericProfile(GenericProfile genericProfile) {
        throw new RuntimeException(
                String.format(
                        "Not implemented profile type %s",
                        genericProfile.getClass().getSimpleName()
                )
        );
    }

    @Override
    public UnitlessProfile caseTimeSeriesProfile(TimeSeriesProfile esdlTimeSeries) {
        return TimeSeriesProfileConverter.convertTimeSeries(esdlTimeSeries, luxStartYear, valueTransformer);
    }

    @Override
    public UnitlessProfile caseDateTimeProfile(DateTimeProfile esdlDateTimeProfile) {
        return DateTimeProfileConvertor.convertDateTimeProfile(esdlDateTimeProfile, luxStartYear, valueTransformer);
    }
}
