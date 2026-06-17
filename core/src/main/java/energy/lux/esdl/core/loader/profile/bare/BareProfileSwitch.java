package energy.lux.esdl.core.loader.profile.bare;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.util.Util;
import esdl.DateTimeProfile;
import esdl.GenericProfile;
import esdl.TimeSeriesProfile;
import esdl.util.EsdlSwitch;
import org.eclipse.emf.ecore.EObject;

/**
 * Convert different types of ESDL profiles to Zenmo TimeSeries
 */
class BareProfileSwitch extends EsdlSwitch<ArrayTimeSeries> {
    @Override
    public ArrayTimeSeries defaultCase(EObject object) {
        throw new RuntimeException(
                String.format(
                        "%s can only process profiles, found %s",
                        this.getClass().getSimpleName(),
                        Util.printObject(object)
                )
        );
    }

    @Override
    public ArrayTimeSeries caseGenericProfile(GenericProfile genericProfile) {
        throw new RuntimeException(
                String.format(
                        "Not implemented profile type %s",
                        genericProfile.getClass().getSimpleName()
                )
        );
    }

    @Override
    public ArrayTimeSeries caseTimeSeriesProfile(TimeSeriesProfile esdlTimeSeries) {
        return TimeSeriesProfileReader.readProfile(esdlTimeSeries);
    }

    @Override
    public ArrayTimeSeries caseDateTimeProfile(DateTimeProfile esdlDateTimeProfile) {
        return DateTimeProfileReader.convertDateTimeProfile(esdlDateTimeProfile);
    }
}
