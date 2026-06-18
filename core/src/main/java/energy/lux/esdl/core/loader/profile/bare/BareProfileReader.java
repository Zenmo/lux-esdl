package energy.lux.esdl.core.loader.profile.bare;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import esdl.GenericProfile;

import java.time.temporal.TemporalAmount;

/**
 * Loads a profile from ESDL and aligns it with the time step of the LUX simulation.
 * Bare means the profile is loaded without a unit or quantity.
 */
public class BareProfileReader {
    private final TemporalAmount luxTimeStep;

    private final BareProfileSwitch profileReaderSwitch;

    private final BareProfileChecker bareProfileChecker;

    public BareProfileReader(TemporalAmount luxTimeStep, BareProfileChecker bareProfileChecker) {
        this.luxTimeStep = luxTimeStep;
        this.bareProfileChecker = bareProfileChecker;
        this.profileReaderSwitch = new BareProfileSwitch();
    }

    public ArrayTimeSeries readProfile(GenericProfile esdlProfile) {
        var timeSeriesWithEsdlStep = this.profileReaderSwitch.doSwitch(esdlProfile);

        bareProfileChecker.checkProfileEclipsesSimulationPeriod(timeSeriesWithEsdlStep, esdlProfile.getId());

        var timeSeriesWithLuxStep = timeSeriesWithEsdlStep.convertStep(luxTimeStep);

        return timeSeriesWithLuxStep;
    }
}
