package energy.lux.esdl.core.loader.pv;

import esdl.AbstractBuilding;
import esdl.Area;
import esdl.Asset;
import esdl.PVInstallation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Collects the distinct orientations of all PV installations in an area, before any of them
 * are loaded.
 * Generating a profile means calling out to pvlib, a python package, which is expensive to start.
 * Scanning up front keeps the loading of an individual installation unchanged: it reads its
 * asset and creates its asset, with the profile it needs already registered.
 */
public class PVOrientationScanner {
    private static final Logger logger = LoggerFactory.getLogger(PVOrientationScanner.class);

    public static Set<PVOrientation> scanOrientations(Area area) {
        var orientations = new LinkedHashSet<PVOrientation>();
        for (var pvInstallation : findPVInstallations(area)) {
            orientations.add(PVOrientation.of(pvInstallation));
        }

        logger.info(
                "Found {} distinct PV orientation(s) in the ESDL",
                orientations.size()
        );

        return orientations;
    }

    public static List<PVInstallation> findPVInstallations(Area area) {
        var pvInstallations = new ArrayList<PVInstallation>();
        collectFromArea(area, pvInstallations);
        return pvInstallations;
    }

    // Current ESDL files only have PVInstallations inside Buildings, for completeness we also walk through the area.
    private static void collectFromArea(Area area, List<PVInstallation> pvInstallations) {
        for (Asset asset : area.getAsset()) {
            collectFromAsset(asset, pvInstallations);
        }

        for (Area nestedArea : area.getArea()) {
            collectFromArea(nestedArea, pvInstallations);
        }
    }

    private static void collectFromAsset(Asset asset, List<PVInstallation> pvInstallations) {
        if (asset instanceof PVInstallation pvInstallation) {
            pvInstallations.add(pvInstallation);
            return;
        }

        if (asset instanceof AbstractBuilding building) {
            for (Asset containedAsset : building.getAsset()) {
                collectFromAsset(containedAsset, pvInstallations);
            }
        }
    }
}
