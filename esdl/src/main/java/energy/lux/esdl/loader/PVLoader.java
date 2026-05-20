package energy.lux.esdl.loader;

import energy.lux.esdl.util.Util;
import esdl.PVInstallation;
import zero_engine.GridConnection;
import zero_engine.OL_PVOrientation;
import zerointerfaceloader.Zero_Loader;

/**
 * TODO: us AVGC values
 */
public class PVLoader {
    private static double baseIrradianceWPerM2 = 1000.0;

    private static double defaultPanelEfficiency = 0.2;

    private static double defaultInverterEfficiency = 0.95;

    public static void loadPVInstallation(PVInstallation pvInstallation, GridConnection luxGridConnection, Zero_Loader luxLoader) {
        var installationPowerKw = getInstallationPowerKw(pvInstallation);
        luxLoader.f_addPVProductionAsset(luxGridConnection, pvInstallation.getName(), installationPowerKw, OL_PVOrientation.SOUTH);
    }

    private static double getInstallationPowerKw(PVInstallation pvInstallation) {
        var efficiency = calculateEfficiency(pvInstallation);
        return pvInstallation.getSurfaceArea() * efficiency * baseIrradianceWPerM2 * 0.001;
    }

    private static double calculateEfficiency(PVInstallation pvInstallation) {
        var panelEfficiency = Util.defaultIfZero(pvInstallation.getPanelEfficiency(), defaultPanelEfficiency);
        var inverterEfficiency = Util.defaultIfZero(pvInstallation.getInverterEfficiency(), defaultInverterEfficiency);

        return panelEfficiency * inverterEfficiency;
    }
}
