package energy.lux.esdl.loader;

import energy.lux.esdl.NotImplemented;
import energy.lux.esdl.Util;
import esdl.*;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

public class ElectricityDemandLoader {
    public static void loadElectricityDemand(
            ElectricityDemand demand,
            GridConnection luxGridConnection,
            Zero_Loader luxLoader
    ) {
        var dateTimeProfile = findFirstDateTimeProfile(demand);
        if (dateTimeProfile != null) {
            loadProfile(dateTimeProfile, demand, luxGridConnection, luxLoader);
            return;
        }

        double annualDemandKwh = demand.getFullLoadHours() * demand.getPower() * 0.001;
        if (annualDemandKwh != 0.0) {
            luxLoader.f_addElectricityDemandProfile(luxGridConnection, annualDemandKwh, 0.0, false, "default_house_electricity_demand_fr");
            return;
        }

        throw new NotImplemented("This type of ElectricityDemand is not implemented: " + Util.printItem(demand));
    }

    private static J_EAProfile loadProfile(
            DateTimeProfile dateTimeProfile,
            ElectricityDemand demand,
            GridConnection luxGridConnection,
            Zero_Loader luxLoader
    ) {
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
        return  demandAsset;
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
