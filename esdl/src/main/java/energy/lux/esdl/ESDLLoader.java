package energy.lux.esdl;

import esdl.*;
import zero_engine.EnergyModel;
import zerointerfaceloader.Zero_Loader;

/**
 * Transform ESDL EnergySystem to a LUX EnergyModel.
 */
public class ESDLLoader {
    /**
     * LUX {@link EnergyModel} is a property of the loader {@link Zero_Loader}.
     * The loader is passed because it might have some useful methods.
     */
    public static void loadEsdlIntoLux(
            EnergySystem esdlEnergySystem,
            Zero_Loader luxLoader
    ) {
        loadEnvironmentalProfiles(esdlEnergySystem.getEnergySystemInformation(), luxLoader);
        loadParties(esdlEnergySystem.getParties(), luxLoader);
        loadMeasures(esdlEnergySystem.getMeasures(), luxLoader);
        loadServices(esdlEnergySystem.getServices(), luxLoader);

        for (Instance instance : esdlEnergySystem.getInstance()) {
            Area area = instance.getArea();
            if (area != null) {
                loadArea(area, luxLoader);
            }
        }
    }

    private static void loadEnvironmentalProfiles(
            EnergySystemInformation info,
            Zero_Loader luxLoader
    ) {
        if (info == null) return;
        EnvironmentalProfiles envProfiles = info.getEnvironmentalProfiles();
        if (envProfiles == null) return;

        if (envProfiles.getOutsideTemperatureProfile() instanceof DateTimeProfile outsideTemp) {
            for (ProfileElement element : outsideTemp.getElement()) {
                // TODO: use element.getValue(), element.getFrom(), element.getTo()
            }
        }
        if (envProfiles.getSolarIrradianceProfile() instanceof DateTimeProfile solarIrradiance) {
            for (ProfileElement element : solarIrradiance.getElement()) {
                // TODO: use solar irradiance data
            }
        }
        if (envProfiles.getSoilTemperatureProfile() instanceof DateTimeProfile soilTemp) {
            for (ProfileElement element : soilTemp.getElement()) {
                // TODO: use soil temperature data
            }
        }
    }

    private static void loadParties(Parties parties, Zero_Loader luxLoader) {
        if (parties == null) return;
        for (Party party : parties.getParty()) {
            // TODO: handle party (e.g. DSO)
        }
    }

    private static void loadMeasures(Measures measures, Zero_Loader luxLoader) {
        if (measures == null) return;
        for (AbstractMeasure abstractMeasure : measures.getMeasure()) {
            if (abstractMeasure instanceof Measure measure) {
                CostInformation costInfo = measure.getCostInformation();
                // TODO: use cost information (e.g. bandwidth tariff prices)
            }
        }
    }

    private static void loadServices(Services services, Zero_Loader luxLoader) {
        if (services == null) return;
        for (Service service : services.getService()) {
            if (service instanceof EnergyMarket energyMarket) {
                if (energyMarket.getMarketPrice() instanceof DateTimeProfile marketPrice) {
                    for (ProfileElement element : marketPrice.getElement()) {
                        // TODO: use market price data
                    }
                }
            }
        }
    }

    private static void loadArea(Area area, Zero_Loader luxLoader) {
        for (Asset asset : area.getAsset()) {
            if (asset instanceof Joint joint) {
                // TODO: map to LUX grid node
            } else if (asset instanceof ElectricityCable cable) {
                // TODO: map to LUX grid connection (grid cables use 4x150Al/4x95Al, home cables use 4x6Cu)
            } else if (asset instanceof Transformer transformer) {
                // TODO: map transformer
            } else if (asset instanceof Import source) {
                // TODO: map import/source
            } else if (asset instanceof Building building) {
                loadBuilding(building, luxLoader);
            }
        }

        for (Area subArea : area.getArea()) {
            loadArea(subArea, luxLoader);
        }
    }

    private static void loadBuilding(Building building, Zero_Loader luxLoader) {
        EnergyModel energyModel = luxLoader.energyModel;

        var house = energyModel.add_Houses();
        house.p_gridConnectionID = building.getId();

        var owner = energyModel.add_pop_connectionOwners();
        owner.p_actorID = building.getId() + "_owner";
        house.p_ownerID = owner.p_actorID;

        for (Asset asset : building.getAsset()) {
            if (asset instanceof EConnection eConnection) {
                // TODO: use electricity connection properties (capacity, owner, energy contract)
            } else if (asset instanceof ElectricityNetwork electricityNetwork) {
                // TODO: handle phase grid (3 phases per building)
            } else if (asset instanceof ElectricityDemand demand) {
                for (Port port : demand.getPort()) {
                    for (GenericProfile profile : port.getProfile()) {
                        if (profile instanceof DateTimeProfile demandProfile) {
                            for (ProfileElement element : demandProfile.getElement()) {
                                // TODO: load demand time series into LUX
                            }
                        }
                    }
                }
            } else if (asset instanceof PVInstallation pv) {
                // TODO: call luxLoader.f_addPVProductionAsset(house, pv.getName(), installedPower_kW, orientation)
            } else if (asset instanceof EVChargingStation evStation) {
                // TODO: add EV charging via luxLoader
            } else if (asset instanceof HybridHeatPump heatPump) {
                // TODO: add heat pump via luxLoader
            }
        }
    }
}
