package energy.lux.esdl.core.loader.profile;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;

/**
 * The weather of the ESDL, as far as modelling PV production needs it.
 */
public record Weather(
        ArrayTimeSeries globalHorizontalIrradiance_wpm2,
        ArrayTimeSeries outsideTemperature_degC
) {
    public static Weather none() {
        return new Weather(null, null);
    }
}
