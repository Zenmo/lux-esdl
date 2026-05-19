package energy.lux.esdl.loader;

import energy.lux.esdl.NotImplemented;
import energy.lux.esdl.Util;
import esdl.*;
import esdl.util.EsdlSwitch;
import org.eclipse.emf.ecore.EObject;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

import java.util.HashSet;
import java.util.Set;

import static energy.lux.esdl.loader.SwitchStatus.DONE;

/**
 * Iterate through the network behind EConnection
 * and add the assets to the LUX grid connection
 */
public class GridConnectionAssetLoader extends EsdlSwitch<SwitchStatus> {
    private final GridConnection luxGridConnection;

    private final Zero_Loader luxLoader;

    private final EConnection entryPoint;

    private final Set<Port> visitedPorts = new HashSet<>();
    private final Set<EnergyAsset> processedAssets = new HashSet<>();

    public GridConnectionAssetLoader(GridConnection luxGridConnection, Zero_Loader luxLoader, EConnection entryPoint) {
        this.luxGridConnection = luxGridConnection;
        this.luxLoader = luxLoader;
        // prevent exiting the grid connection while searching through the cables
        this.entryPoint = entryPoint;
    }

    @Override
    public SwitchStatus defaultCase(EObject object) {
        throw new RuntimeException("Unexpected asset type " + object.toString());
    }

    @Override
    public SwitchStatus caseEnergyAsset(EnergyAsset energyAsset) {
        throw new NotImplemented("Not implemented loading Energy Asset " + Util.printItem(energyAsset));
    }

    @Override
    public SwitchStatus caseEConnection(EConnection eConnection) {
        if (eConnection != entryPoint) {
            throw new RuntimeException("Found a grid connection within a grid connection: " + Util.printItem(eConnection));
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseInPort(InPort inPort) {
        if (this.visitedPorts.add(inPort)) {
            doSwitch(inPort.getEnergyasset());
            for (var outPort: inPort.getConnectedTo()) {
                doSwitch(outPort);
            }
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseOutPort(OutPort outPort) {
        if (this.visitedPorts.add(outPort)) {
            doSwitch(outPort.getEnergyasset());
            for (var inPort: outPort.getConnectedTo()) {
                doSwitch(inPort);
            }
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseElectricityNetwork(ElectricityNetwork electricityNetwork) {
        for (Port port : electricityNetwork.getPort()) {
            this.doSwitch(port);
        }
        return DONE;
    }

    @Override
    public SwitchStatus casePVInstallation(PVInstallation pvInstallation) {
        if (this.processedAssets.add(pvInstallation)) {
            PVLoader.loadPVInstallation(pvInstallation, luxGridConnection, luxLoader);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseHeatPump(HeatPump heatPump) {
        if (this.processedAssets.add(heatPump)) {
            var maxThermalPowerKw = heatPump.getPower() * 0.001;
            luxLoader.f_addHeatAsset(luxGridConnection, OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, maxThermalPowerKw);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseHybridHeatPump(HybridHeatPump hybridHeatPump) {
        if (this.processedAssets.add(hybridHeatPump)) {
            var maxThermalPowerKw = hybridHeatPump.getHeatPumpThermalPower() * 0.001;
            luxLoader.f_addHeatAsset(luxGridConnection, OL_GridConnectionHeatingType.HYBRID_HEATPUMP, maxThermalPowerKw);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseEVChargingStation(EVChargingStation evChargingStation) {
        if (this.processedAssets.add(evChargingStation)) {
            var maxChargingPowerKw = evChargingStation.getPower() * 0.001;
            luxLoader.f_addElectricVehicle(luxGridConnection, OL_EnergyAssetType.ELECTRIC_VEHICLE, true, 8_000, maxChargingPowerKw);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseElectricityDemand(ElectricityDemand demand) {
        if (!this.processedAssets.add(demand)) {
            return DONE;
        }

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
        return DONE;
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
