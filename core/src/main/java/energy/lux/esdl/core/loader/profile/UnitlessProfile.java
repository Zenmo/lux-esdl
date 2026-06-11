package energy.lux.esdl.core.loader.profile;

import zero_engine.EnergyModel;
import zero_engine.J_ProfilePointer;
import zero_engine.OL_ProfileUnits;

/**
 * Data prepared to put into J_ProfilePointer
 */
public record UnitlessProfile(
        double startRelativeToLuxStart_h,
        double step_h,
        double[] values
) {
    /**
     * Convert to final format and register with LUX Engine
     */
    public J_ProfilePointer toLuxProfile(EnergyModel luxModel, String name, OL_ProfileUnits unit) {
        var luxProfile = new J_ProfilePointer(
                name,
                values,
                step_h,
                startRelativeToLuxStart_h,
                OL_ProfileUnits.PRICE_EURPMWH
        );

        luxModel.f_addProfile(luxProfile);

        return luxProfile;
    }
}
