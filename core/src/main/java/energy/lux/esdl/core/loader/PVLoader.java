package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import energy.lux.esdl.core.loader.pv.PVOrientation;
import energy.lux.esdl.core.util.Util;
import esdl.PVInstallation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.GridConnection;
import zero_engine.J_EAProduction;
import zero_engine.J_ProfilePointer;
import zero_engine.OL_EnergyAssetType;
import zero_engine.OL_EnergyCarriers;
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

    public static void loadPVInstallation(
            PVInstallation pvInstallation,
            GridConnection luxGridConnection,
            Zero_Loader luxLoader,
            ProfilePointerRegistry profilePointerRegistry
    ) {
        var installationPowerKw = getInstallationPowerKw(pvInstallation);

        var orientation = PVOrientation.of(pvInstallation);
        var profilePointer = profilePointerRegistry.findProfilePointer(orientation.profileName());

        if (profilePointer == null) {
            logger.warn(
                    "No generated PV profile for {} of installation {}, falling back to the"
                            + " default south profile of LUX",
                    orientation,
                    pvInstallation.getName()
            );
            loadWithDefaultProfile(pvInstallation, luxGridConnection, luxLoader, installationPowerKw);
            return;
        }

        loadWithGeneratedProfile(pvInstallation, luxGridConnection, luxLoader, profilePointer, installationPowerKw);
    }

    /**
     * The profile was modelled for the tilt and azimuth that this installation states, so the
     * orientation is already in the profile and the LUX orientation enum has nothing left to
     * choose. That enum only names a south and an east-west profile, so it cannot express what
     * the ESDL describes, and the asset is built directly instead of through
     * {@link Zero_Loader#f_addPVProductionAsset}.
     */
    private static void loadWithGeneratedProfile(
            PVInstallation pvInstallation,
            GridConnection luxGridConnection,
            Zero_Loader luxLoader,
            J_ProfilePointer profilePointer,
            double installationPowerKw
    ) {
        new J_EAProduction(
                luxGridConnection,
                OL_EnergyAssetType.PHOTOVOLTAIC,
                pvInstallation.getName(),
                OL_EnergyCarriers.ELECTRICITY,
                installationPowerKw,
                luxLoader.energyModel.p_timeParameters,
                profilePointer
        );
    }

    /**
     * Used for the older files, which describe PV but carry no irradiance to model it from.
     */
    private static void loadWithDefaultProfile(
            PVInstallation pvInstallation,
            GridConnection luxGridConnection,
            Zero_Loader luxLoader,
            double installationPowerKw
    ) {
        luxLoader.f_addPVProductionAsset(
                luxGridConnection,
                pvInstallation.getName(),
                installationPowerKw,
                OL_PVOrientation.SOUTH
        );
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
