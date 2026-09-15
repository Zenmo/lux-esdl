package energy.lux.esdl.core.loader.pv;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import com.zenmo.timeseries.untyped.ArrayTimeSeriesImpl;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.OL_ProfileUnits;

import java.util.Collection;

/**
 * Models a PV production profile for every orientation the ESDL uses and registers them all,
 * before the first grid connection is loaded.
 * <p>
 * Doing it up front is what keeps the one expensive step, starting pvlib, outside the
 * traversal. PVLoader finds them back by {@link PVOrientation#profileName()}, so the loading
 * of an individual installation stays a lookup.
 */
public class PVProfileLoader {
    private static final Logger logger = LoggerFactory.getLogger(PVProfileLoader.class);

    /**
     * @param globalHorizontalIrradiance the irradiance of the ESDL, which decides both the
     *                                   weather the panels see and the time axis the profiles
     *                                   end up on
     */
    public static void generateAndRegister(
            ProfilePointerRegistry profilePointerRegistry,
            PVSite site,
            ArrayTimeSeries globalHorizontalIrradiance,
            Collection<PVOrientation> orientations
    ) {
        if (orientations.isEmpty()) {
            return;
        }

        var generator = new PvlibProfileGenerator(site);
        var generatedProfiles = generator.generateProfiles(globalHorizontalIrradiance, orientations);

        for (var generatedProfile : generatedProfiles.entrySet()) {
            var orientation = generatedProfile.getKey();
            var timeSeries = onSameTimeAxis(globalHorizontalIrradiance, generatedProfile.getValue());

            profilePointerRegistry.registerProfilePointer(
                    orientation.profileName(),
                    timeSeries,
                    OL_ProfileUnits.NORMALIZEDPOWER
            );
        }

        logger.info("Registered {} generated PV profile(s) with the LUX engine", generatedProfiles.size());
    }

    /**
     * pvlib returns one value per irradiance value, so the generated profile inherits the start
     * and the step of the irradiance it was modelled from.
     */
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
