package energy.lux.esdl.core.iterator;

import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.util.Util;
import energy.lux.esdl.core.loader.ElectricityDemandLoader;
import energy.lux.esdl.core.loader.HomeBatteryLoader;
import energy.lux.esdl.core.loader.PVLoader;
import energy.lux.esdl.core.loader.SwitchStatus;
import esdl.*;
import esdl.util.EsdlSwitch;
import org.eclipse.emf.ecore.EObject;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

import java.util.HashSet;
import java.util.Set;

import static energy.lux.esdl.core.loader.SwitchStatus.DONE;

/**
 * Iterate through the network behind EConnection
 * and add the assets to the LUX grid connection
 */
public class GridConnectionAssetIterator extends EsdlSwitch<SwitchStatus> {
    private final GridConnection luxGridConnection;

    private final Zero_Loader luxLoader;
    private final EnergyModel energyModel;

    private final ElectricityDemandLoader electricityDemandLoader;

    private final EConnection entryPoint;

    private final Set<Port> visitedPorts = new HashSet<>();
    private final Set<EnergyAsset> processedAssets = new HashSet<>();

    public GridConnectionAssetIterator(GridConnection luxGridConnection, Zero_Loader luxLoader, EConnection entryPoint) {
        this.luxGridConnection = luxGridConnection;
        this.luxLoader = luxLoader;
        this.energyModel = luxLoader.energyModel;
        this.electricityDemandLoader = new ElectricityDemandLoader(luxLoader);
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

    public SwitchStatus caseBattery(Battery battery) {
        if (this.processedAssets.add(battery)) {
            HomeBatteryLoader.loadBattery(battery, luxGridConnection, luxLoader);
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
            var heatingPreferences = luxLoader.f_getHouseHeatingPreferences();
            luxLoader.f_addHeatAsset(luxGridConnection, OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, maxThermalPowerKw, heatingPreferences);
            I_HeatingManagement heatingManagement = new J_HeatingManagementPIcontrol(luxGridConnection, energyModel.p_timeParameters, OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP);
            luxGridConnection.f_setHeatingManagement(heatingManagement);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseHybridHeatPump(HybridHeatPump hybridHeatPump) {
        if (this.processedAssets.add(hybridHeatPump)) {
            var maxThermalPowerKw = hybridHeatPump.getHeatPumpThermalPower() * 0.001;
            var heatingPreferences = luxLoader.f_getHouseHeatingPreferences();
            luxLoader.f_addHeatAsset(luxGridConnection, OL_GridConnectionHeatingType.HYBRID_HEATPUMP, maxThermalPowerKw, heatingPreferences);
            I_HeatingManagement heatingManagement = new J_HeatingManagementPIcontrolHybridHeatpump(luxGridConnection, energyModel.p_timeParameters, OL_GridConnectionHeatingType.HYBRID_HEATPUMP);
            luxGridConnection.f_setHeatingManagement(heatingManagement);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseEVChargingStation(EVChargingStation evChargingStation) {
        if (this.processedAssets.add(evChargingStation)) {
            var maxChargingPowerKw = evChargingStation.getPower() * 0.001;
            double consumedEnergy_kWh = evChargingStation.getFullLoadHours() * maxChargingPowerKw;
            double traveledDistance_km = consumedEnergy_kWh / luxLoader.avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm;
            J_EAEV ev = luxLoader.f_addElectricVehicle(luxGridConnection, OL_EnergyAssetType.ELECTRIC_VEHICLE, false, traveledDistance_km, maxChargingPowerKw, OL_ChargingAttitude.SIMPLE);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseElectricityDemand(ElectricityDemand demand) {
        if (!this.processedAssets.add(demand)) {
            return DONE;
        }

        this.electricityDemandLoader.loadElectricityDemand(demand, luxGridConnection);
        return DONE;
    }
}
