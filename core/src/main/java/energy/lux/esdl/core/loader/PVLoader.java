package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import energy.lux.esdl.core.loader.pv.PVOrientation;
import energy.lux.esdl.core.util.Util;
import esdl.PVInstallation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.energyassets.J_EAProduction;
import energy.lux.engine.optionlists.OL_EnergyAssetType;
import energy.lux.engine.optionlists.OL_EnergyCarriers;
import energy.lux.engine.EnergyModel;

/**
 * TODO: us AVGC values
 */
public class PVLoader {
    private static final Logger logger = LoggerFactory.getLogger(PVLoader.class);

    private static double baseIrradianceWPerM2 = 1000.0;

    private static double defaultPanelEfficiency = 0.2;

    private static double defaultInverterEfficiency = 0.95;

    public static void loadPVInstallation(
            PVInstallation pvInstallation,
            GridConnection luxGridConnection,
            EnergyModel energyModel,
            ProfilePointerRegistry profilePointerRegistry
    ) {
        var installationPowerKw = getInstallationPowerKw(pvInstallation);

        var orientation = PVOrientation.of(pvInstallation);
        var profilePointer = profilePointerRegistry.findProfilePointer(orientation.profileName());

        if (profilePointer == null) {
            throw new EsdlException(String.format(
                    "No generated PV profile for %s of installation %s. The ESDL needs the irradiance to model it from.",
                    orientation,
                    pvInstallation.getName()
            ));
        }

        // The profile was modelled for the tilt and azimuth that this installation states, so the orientation is
        // already in it. The LUX orientation enum only names a south and an east-west profile.
        new J_EAProduction(
                luxGridConnection,
                OL_EnergyAssetType.PHOTOVOLTAIC,
                pvInstallation.getName(),
                OL_EnergyCarriers.ELECTRICITY,
                installationPowerKw,
                energyModel.p_timeParameters,
                profilePointer
        );
    }

    private static double getInstallationPowerKw(PVInstallation pvInstallation) {
        var installedPower_W = pvInstallation.getPower();
        if (installedPower_W != 0.0) {
            return installedPower_W * 0.001;
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
