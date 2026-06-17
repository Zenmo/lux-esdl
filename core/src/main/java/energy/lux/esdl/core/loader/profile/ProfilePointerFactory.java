package energy.lux.esdl.core.loader.profile;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import zero_engine.EnergyModel;
import zero_engine.J_ProfilePointer;
import zero_engine.OL_ProfileUnits;

import java.time.Year;

import static energy.lux.esdl.core.util.DateTimeUtil.durationToHours;
import static energy.lux.esdl.core.util.DateTimeUtil.getHourOffset;

public class ProfilePointerFactory {
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
        var startRelativeToLuxStart_h = getHourOffset(luxStart, timeSeries.getStart());
        var stepHours = durationToHours(timeSeries.getStep());

        var luxProfile = new J_ProfilePointer(
                name,
                timeSeries.copyValuesArray(),
                stepHours,
                startRelativeToLuxStart_h,
                unit
        );

        luxModel.f_addProfile(luxProfile);

        return luxProfile;
    }
}
