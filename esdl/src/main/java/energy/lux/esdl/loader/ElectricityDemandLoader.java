package energy.lux.esdl.loader;

import energy.lux.esdl.NotImplemented;
import energy.lux.esdl.Util;
import esdl.*;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

import static energy.lux.esdl.loader.SwitchStatus.DONE;

public class ElectricityDemandLoader {
    public static void loadElectricityDemand(ElectricityDemand demand, GridConnection luxGridConnection, Zero_Loader luxLoader) {
        var dateTimeProfile = findFirstDateTimeProfile(demand);
        if (dateTimeProfile == null) {
            throw new NotImplemented("No DateTimeProfile found for " + Util.printItem(demand));
        }

        var profilePointer = DateTimeProfileLoader.createProfilePointer(
                luxLoader,
                dateTimeProfile,
                demand.getId() + "_demand",
                OL_ProfileUnits.KWHPQUARTERHOUR,
                v -> v * 0.001
        );
        var demandAsset = new J_EAProfile(
                luxGridConnection,
                OL_EnergyCarriers.ELECTRICITY,
                profilePointer,
                OL_AssetFlowCategories.fixedConsumptionElectric_kW,
                luxLoader.energyModel.p_timeParameters
        );
        demandAsset.setEnergyAssetName(demand.getName());
    }

    private static DateTimeProfile findFirstDateTimeProfile(EnergyAsset asset) {
        for (Port port : asset.getPort()) {
            for (GenericProfile profile : port.getProfile()) {
                if (profile instanceof DateTimeProfile dateTimeProfile) {
                    return dateTimeProfile;
                }
            }
        }
        return null;
    }
}
