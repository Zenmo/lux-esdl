package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.loader.profile.ProfileConverterSwitch;
import energy.lux.esdl.core.loader.profile.ProfileLoader;
import energy.lux.esdl.core.util.Util;
import esdl.*;
import lombok.val;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

public class ElectricityDemandLoader {
    public static void loadElectricityDemand(
            ElectricityDemand demand,
            GridConnection luxGridConnection,
            Zero_Loader luxLoader
    ) {
        var dateTimeProfile = findFirstProfile(demand);
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
            GenericProfile profile,
            ElectricityDemand demand,
            GridConnection luxGridConnection,
            Zero_Loader luxLoader
    ) {
        var luxEngine = luxLoader.energyModel;
        var startYear = luxEngine.p_timeParameters.getStartYear();

        val unitlessProfile = ProfileConverterSwitch.builder()
                .luxStartYear(startYear)
                .valueTransformer(v -> v * 0.001)
                .build()
                .doSwitch(profile);

        var luxProfile = unitlessProfile.toLuxProfile(luxEngine, demand.getId() + "_demand", OL_ProfileUnits.KWHPQUARTERHOUR);

        var demandAsset = new J_EAProfile(
                luxGridConnection,
                OL_EnergyCarriers.ELECTRICITY,
                luxProfile,
                OL_AssetFlowCategories.fixedConsumptionElectric_kW,
                luxEngine.p_timeParameters
        );
        demandAsset.setEnergyAssetName(demand.getName());
        return demandAsset;
    }

    private static GenericProfile findFirstProfile(EnergyAsset asset) {
        for (Port port : asset.getPort()) {
            for (GenericProfile profile : port.getProfile()) {
                if (profile != null) {
                    return profile;
                }
            }
        }
        return null;
    }
}
