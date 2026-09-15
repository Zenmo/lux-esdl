package energy.lux.esdl.core.loader.pv;

import esdl.AbstractBuilding;
import esdl.Area;
import esdl.Asset;
import esdl.PVInstallation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Collects the distinct orientations of all PV installations in an area, before any of them
 * is loaded.
 * <p>
 * Generating a profile means calling out to pvlib, which is expensive to start and cheap to
 * run once started, so every orientation in the file has to be known before the first call.
 * Scanning up front keeps the loading of an individual installation unchanged: it reads its
 * asset and creates its asset, with the profile it needs already registered.
 * <p>
 * This walks the containment of the area rather than the electricity network, so it also finds
 * installations that no cable reaches. Generating a profile for one of those wastes a pvlib run
 * but cannot make the model wrong.
 */
public class PVOrientationScanner {
    private static final Logger logger = LoggerFactory.getLogger(PVOrientationScanner.class);

    /**
     * Insertion ordered so that a run generates its profiles in the same order every time,
     * which keeps the logs and the generator request comparable between runs.
     */
    public static Set<PVOrientation> scanOrientations(Area area) {
        var orientations = new LinkedHashSet<PVOrientation>();
        collectFromArea(area, orientations);

        logger.info(
                "Found {} distinct PV orientation(s) in the ESDL",
                orientations.size()
        );

        return orientations;
    }

    private static void collectFromArea(Area area, Set<PVOrientation> orientations) {
        for (Asset asset : area.getAsset()) {
            collectFromAsset(asset, orientations);
        }

        for (Area nestedArea : area.getArea()) {
            collectFromArea(nestedArea, orientations);
        }
    }

    private static void collectFromAsset(Asset asset, Set<PVOrientation> orientations) {
        if (asset instanceof PVInstallation pvInstallation) {
            orientations.add(PVOrientation.of(pvInstallation));
            return;
        }

        // The congestion scenario files put the PV installation of a house inside its building.
        if (asset instanceof AbstractBuilding building) {
            for (Asset containedAsset : building.getAsset()) {
                collectFromAsset(containedAsset, orientations);
            }
        }
    }
}
