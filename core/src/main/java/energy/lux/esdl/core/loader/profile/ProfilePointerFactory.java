package energy.lux.esdl.core.loader.profile;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.EsdlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.EnergyModel;
import zero_engine.J_ProfilePointer;
import zero_engine.OL_ProfileUnits;

import java.time.Year;

import static energy.lux.esdl.core.util.DateTimeUtil.durationToHours;
import static energy.lux.esdl.core.util.DateTimeUtil.getHourOffset;

public class ProfilePointerFactory {
    private static final Logger logger = LoggerFactory.getLogger(ProfilePointerFactory.class);

    private final EnergyModel luxModel;

    private final Year luxStart;

    public ProfilePointerFactory(EnergyModel luxModel) {
        this.luxModel = luxModel;

        int startYear = luxModel.p_timeParameters.getStartYear();
        this.luxStart = Year.of(startYear);
    }

    /**
     * Convert from a Zenmo TimeSeries to a LUX ProfilePointer
     * and register it with the LUX Engine.
     */
    public J_ProfilePointer timeSeriesToProfilePointer(
            ArrayTimeSeries timeSeries,
            String name,
            OL_ProfileUnits unit
    ) {
        var values = timeSeries.copyValuesArray();
        var stepHours = durationToHours(timeSeries.getStep());

        var startRelativeToLuxStart_h = alignStartToSimulationYear(
                getHourOffset(luxStart, timeSeries.getStart()),
                values.length * stepHours,
                name
        );

        var luxProfile = new J_ProfilePointer(
                name,
                values,
                stepHours,
                startRelativeToLuxStart_h,
                unit
        );

        luxModel.f_addProfile(luxProfile);

        return luxProfile;
    }

    /**
     * LUX reads a profile by the index {@code (time - start) / step} and only wraps indexes that
     * run past the end of the data. A profile that starts after the 1st of January of the
     * simulation year therefore yields a negative index and throws on the first timestep.
     * <p>
     * Stepping the start back by whole profile lengths lands on the same data point that the
     * wrap-around would have reached had the index been allowed to go negative, so for a profile
     * covering a full year the day of the year still lines up.
     * <p>
     * The weather profiles of the congestion scenarios need this: they are stamped
     * 2050-01-01T23:50:00+0000, almost 25 hours into the simulation year.
     */
    private double alignStartToSimulationYear(
            double startRelativeToLuxStart_h,
            double profileDuration_h,
            String name
    ) {
        if (startRelativeToLuxStart_h <= 0) {
            return startRelativeToLuxStart_h;
        }

        if (profileDuration_h <= 0) {
            throw new EsdlException("Profile " + name + " has no duration, cannot align it to the simulation year");
        }

        var wholeProfilesToStepBack = Math.ceil(startRelativeToLuxStart_h / profileDuration_h);
        var alignedStart_h = startRelativeToLuxStart_h - wholeProfilesToStepBack * profileDuration_h;

        logger.warn(
                "Profile {} starts {} hours after the start of simulation year {}."
                        + " Moving its start back by {} whole profile length(s) to {} hours,"
                        + " because LUX cannot evaluate a profile that starts in the future.",
                name,
                startRelativeToLuxStart_h,
                luxStart,
                wholeProfilesToStepBack,
                alignedStart_h
        );

        return alignedStart_h;
    }
}
