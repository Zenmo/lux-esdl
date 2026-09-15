package energy.lux.esdl.core.loader.pv;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import com.zenmo.timeseries.untyped.ArrayTimeSeriesImpl;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import energy.lux.esdl.core.loader.profile.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.OL_ProfileUnits;

import java.util.Collection;

/**
 * Models a PV production profile for every orientation the ESDL uses and registers them all,
 * before the first grid connection is loaded.
 * Doing it up front is what keeps the one expensive step, starting pvlib, outside the
 * traversal. PVLoader finds them back by PVOrientation::profileName()
 */
public class PVProfileLoader {
    private static final Logger logger = LoggerFactory.getLogger(PVProfileLoader.class);

    public static void generateAndRegister(
            ProfilePointerRegistry profilePointerRegistry,
            PVSite site,
            Weather weather,
            Collection<PVOrientation> orientations
    ) {
        if (orientations.isEmpty()) {
            return;
        }

        var generator = new PvlibProfileGenerator(site);
        var generatedProfiles = generator.generateProfiles(weather, orientations);

        for (var generatedProfile : generatedProfiles.entrySet()) {
            var orientation = generatedProfile.getKey();
            var timeSeries = onSameTimeAxis(
                    weather.globalHorizontalIrradiance_wpm2(),
                    generatedProfile.getValue()
            );

            profilePointerRegistry.registerProfilePointer(
                    orientation.profileName(),
                    timeSeries,
                    OL_ProfileUnits.NORMALIZEDPOWER
            );
        }

        logger.info("Registered {} generated PV profile(s) with the LUX engine", generatedProfiles.size());
    }

    private static ArrayTimeSeries onSameTimeAxis(
            ArrayTimeSeries globalHorizontalIrradiance,
            double[] generatedValues
    ) {
        return new ArrayTimeSeriesImpl(
                globalHorizontalIrradiance.getStart(),
                globalHorizontalIrradiance.getStep(),
                generatedValues
        );
    }
}
