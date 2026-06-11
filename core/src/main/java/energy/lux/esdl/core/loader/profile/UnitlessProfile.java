package energy.lux.esdl.core.loader.profile;

/**
 * Data prepared to put into J_ProfilePointer
 */
public record UnitlessProfile(
        double startRelativeToLuxStart_h,
        double step_h,
        double[] values
) {
}
