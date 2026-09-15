package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.util.Util;
import esdl.PVInstallation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.GridConnection;
import zero_engine.OL_PVOrientation;
import zerointerfaceloader.Zero_Loader;

/**
 * TODO: us AVGC values
 */
public class PVLoader {
    private static final Logger logger = LoggerFactory.getLogger(PVLoader.class);

    private static double baseIrradianceWPerM2 = 1000.0;

    private static double defaultPanelEfficiency = 0.2;

    private static double defaultInverterEfficiency = 0.95;

    public static void loadPVInstallation(PVInstallation pvInstallation, GridConnection luxGridConnection, Zero_Loader luxLoader) {
        var installationPowerKw = getInstallationPowerKw(pvInstallation);
        luxLoader.f_addPVProductionAsset(luxGridConnection, pvInstallation.getName(), installationPowerKw, OL_PVOrientation.SOUTH);
    }

    /**
     * Prefer the installed power that the ESDL states.
     * <p>
     * Not every file has it: tue.esdl for instance only describes the roof, with a surface area
     * and a panel efficiency, and falling through to a power of zero would silently leave those
     * houses without any production.
     */
    private static double getInstallationPowerKw(PVInstallation pvInstallation) {
        // The congestion scenario files state this in kW: 5 to 9 kWp on 6 to 16 m2 of roof.
        // The older files state watts, so those are now a thousand times too large.
        // TODO: decide per file, or get the unit into the ESDL.
        var installedPowerKw = pvInstallation.getPower();
        if (installedPowerKw != 0.0) {
            return installedPowerKw;
        }

        var estimatedPowerKw = estimatePowerKwFromSurfaceArea(pvInstallation);
        if (estimatedPowerKw == 0.0) {
            logger.warn(
                    "PV installation {} states neither a power nor a surface area, it will not produce anything",
                    pvInstallation.getName()
            );
        }
        return estimatedPowerKw;
    }

    private static double estimatePowerKwFromSurfaceArea(PVInstallation pvInstallation) {
        var efficiency = calculateEfficiency(pvInstallation);
        return pvInstallation.getSurfaceArea() * efficiency * baseIrradianceWPerM2 * 0.001;
    }

    private static double calculateEfficiency(PVInstallation pvInstallation) {
        var panelEfficiency = Util.defaultIfZero(pvInstallation.getPanelEfficiency(), defaultPanelEfficiency);
        var inverterEfficiency = Util.defaultIfZero(pvInstallation.getInverterEfficiency(), defaultInverterEfficiency);

        return panelEfficiency * inverterEfficiency;
    }
}
