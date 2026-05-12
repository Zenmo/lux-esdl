package zero_engine;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.routing.*;
import com.anylogic.engine.presentation.*;
import com.anylogic.engine.gui.*;
import com.anylogic.engine.omniverse_connector.*;

import com.anylogic.libraries.modules.markup_descriptors.*;

import static zero_engine.OL_GridNodeType.*;
import static zero_engine.OL_EnergyCarriers.*;
import static zero_engine.OL_ElectrolyserState.*;
import static zero_engine.OL_GISObjectType.*;
import static zero_engine.OL_EnergyAssetType.*;
import static zero_engine.OL_PBL_OwnershipType.*;
import static zero_engine.OL_ContractType.*;
import static zero_engine.OL_DeliveryContractType.*;
import static zero_engine.OL_TransportContractType.*;
import static zero_engine.OL_ConnectionContractType.*;
import static zero_engine.OL_TaxContractType.*;
import static zero_engine.OL_GridConnectionHeatingType.*;
import static zero_engine.OL_GridConnectionInsulationLabel.*;
import static zero_engine.OL_MobilityPatternType.*;
import static zero_engine.OL_ChargingAttitude.*;
import static zero_engine.OL_BatteryOperationMode.*;
import static zero_engine.OL_ElectrolyserOperationMode.*;
import static zero_engine.OL_ConnectionOwnerType.*;
import static zero_engine.OL_ProfileUnits.*;
import static zero_engine.OL_HouseholdCookingMethod.*;
import static zero_engine.OL_FlowsMapKeys.*;
import static zero_engine.OL_EnergyTaxesBracket.*;
import static zero_engine.OL_ResultScope.*;
import static zero_engine.OL_ParkingSpaceType.*;
import static zero_engine.OL_AmbientTempType.*;
import static zero_engine.OL_AssetFlowCategories.*;
import static zero_engine.OL_VehicleType.*;
import static zero_engine.OL_Days.*;
import static zero_engine.OL_PBL_DwellingType.*;
import static zero_engine.OL_GridConnectionEnergyLabel.*;
import static zero_engine.OL_GridNodeProfileLoaderType.*;
import static zero_engine.OL_GridOperator.*;
import static zero_engine.OL_ConnectionSizeType.*;
import static zero_engine.OL_PVOrientation.*;

import static com.anylogic.engine.Utilities.*;

/**
 * J_EAStorageElectric
 */
public class J_EAStorageElectric extends J_EAStorage implements Serializable {
	
	protected OL_EnergyCarriers storageMedium = OL_EnergyCarriers.ELECTRICITY;
	
	//protected double etaCharge_r; // charging efficiency
	//protected double etaDischarge_r;
	//protected double capacityElectric_kW;
	
    /**
     * Default constructor
     */
    public J_EAStorageElectric() {
    }

    /**
     * Constructor initializing the fields
     */
    public J_EAStorageElectric(I_AssetOwner owner, double chargeCapacity_kW, double storageCapacity_kWh, double stateOfCharge_fr, J_TimeParameters timeParameters ) {
		this.setOwner(owner);
		this.timeParameters = timeParameters;
		this.chargeCapacity_kW = chargeCapacity_kW;
		this.storageCapacity_kWh = storageCapacity_kWh;
		this.initialStateOfCharge_fr = stateOfCharge_fr;
		this.stateOfCharge_fr = this.initialStateOfCharge_fr;
		this.energyAssetType = OL_EnergyAssetType.STORAGE_ELECTRIC;
		double eta_r=0.9; // Default cycle efficiency of 90%. Add this as an argument to constructor?
		this.etaCharge_r = Math.sqrt(eta_r);
		this.etaDischarge_r = Math.sqrt(eta_r);
	    this.activeProductionEnergyCarriers.add(this.storageMedium);		
		this.activeConsumptionEnergyCarriers.add(this.storageMedium);
		this.assetFlowCategory = OL_AssetFlowCategories.batteriesChargingPower_kW;
		registerEnergyAsset(timeParameters);
    }
    
	@Override
	public void operate(double ratioOfChargeCapacity_r, J_TimeVariables timeVariables) {
    	double inputPower_kW = ratioOfChargeCapacity_r * chargeCapacity_kW; // Electric power going into battery, before losses.
    	double deltaEnergy_kWh;   // The change in energy stored in the battery this timestep ('internal' energy)
    	
    	// charging/discharging losses
    	if (inputPower_kW > 0) { // charging (the battery 'consumes' electricity)
    		deltaEnergy_kWh = etaCharge_r * inputPower_kW * timeParameters.getTimeStep_h(); // Actual change of energy content of battery after losses. deltaEnergy_kWh is smaller than inputPower_kW * timestep_h!
    	} else { // discharging (the battery 'produces' electricity)
    		deltaEnergy_kWh = inputPower_kW / etaDischarge_r * timeParameters.getTimeStep_h(); // Actual change of energy content of battery after losses. deltaEnergy_kWh is larger than inputPower_kW * timestep_h!
    	}

    	// Limit SoC to feasible range (0-1)
    	deltaEnergy_kWh = - min( -deltaEnergy_kWh, (stateOfCharge_fr * storageCapacity_kWh) ); // Prevent negative charge
    	deltaEnergy_kWh = min(deltaEnergy_kWh, (1 - stateOfCharge_fr) * storageCapacity_kWh ); // Prevent overcharge
    	
    	double electricityConsumption_kW = 0;
    	double electricityProduction_kW = 0;
    	if (deltaEnergy_kWh > 0) { // charging, deltaEnergy_kWh and inputPower_kW positive
    		inputPower_kW = deltaEnergy_kWh / timeParameters.getTimeStep_h() / etaCharge_r;
    		electricityConsumption_kW = inputPower_kW;
    		electricityProduction_kW = 0;
    		energyUse_kW = (1-etaCharge_r)*inputPower_kW;    		
    	} else { // discharging, deltaEnergy_kWh and inputPower_kW negative
    		inputPower_kW = deltaEnergy_kWh / timeParameters.getTimeStep_h() * etaDischarge_r;
    		electricityConsumption_kW = 0;
    		electricityProduction_kW = -inputPower_kW; 
    		energyUse_kW = -deltaEnergy_kWh / timeParameters.getTimeStep_h() * (1-etaDischarge_r);
    	}
    	energyUsed_kWh += energyUse_kW * timeParameters.getTimeStep_h();
    	
		discharged_kWh += electricityProduction_kW * timeParameters.getTimeStep_h(); // Not the change-in-SoC, but the energy flowing out of the battery after losses.
		charged_kWh += electricityConsumption_kW * timeParameters.getTimeStep_h(); // Not the change-in-SoC, but the energy flowing into the battery before losses.
		
		updateStateOfCharge( deltaEnergy_kWh );

		flowsMap.put(OL_EnergyCarriers.ELECTRICITY, electricityConsumption_kW-electricityProduction_kW);		

		// Split charging and discharing power 'at the source'!
		assetFlowsMap.put(OL_AssetFlowCategories.batteriesChargingPower_kW, electricityConsumption_kW);
		assetFlowsMap.put(OL_AssetFlowCategories.batteriesDischargingPower_kW, electricityProduction_kW);
	}
	
	public void setBatteryEfficiency_r(double eta_r) {
		if (eta_r < 0 || eta_r > 1) {
			traceln("Infeasible eta_r! Should be larger than 0 and no larger than 1! Setting eta_r=1. Input value is: %s", eta_r);
			this.etaCharge_r = 1;			
			this.etaDischarge_r = 1;
		} else {
			this.etaCharge_r = Math.sqrt(eta_r);			
			this.etaDischarge_r = Math.sqrt(eta_r);
		}		
	}
	
	public double getCapacityAvailable_kW() {
		double availableCapacity_kW;
		if ( stateOfCharge_fr * storageCapacity_kWh  > chargeCapacity_kW * timeParameters.getTimeStep_h()) {
			availableCapacity_kW = chargeCapacity_kW;
		}
		else {
			availableCapacity_kW =  stateOfCharge_fr * storageCapacity_kWh / timeParameters.getTimeStep_h(); // Allow to drain completely
		}
		return availableCapacity_kW;
	}
	
	public double getMaxChargePower_kW() { // Always a positive number!
		return min(chargeCapacity_kW, (1-stateOfCharge_fr) * storageCapacity_kWh / timeParameters.getTimeStep_h() / etaCharge_r);
	}
	
	public double getMaxDischargePower_kW() { // Always a positive number!
		return min(chargeCapacity_kW, stateOfCharge_fr * storageCapacity_kWh / timeParameters.getTimeStep_h() * etaDischarge_r);
	}
	
	public double getCapacityElectric_kW() {
		return this.chargeCapacity_kW;
	}

	public double getTotalChargeAmount_kWh() {
		return this.charged_kWh;
	}
	public double getTotalDischargeAmount_kWh() {
		return this.discharged_kWh;
	}
	
	public double getChargingEfficiency_r() {
		return this.etaCharge_r;
	}
	
	public double getDischargingEfficiency_r() {
		return this.etaDischarge_r;
	}
	
	public void setStorageCapacity_kWh(double storageCapacity_kWh, GridConnection gc) {
		double difference_kWh = storageCapacity_kWh - this.storageCapacity_kWh;
		this.storageCapacity_kWh = storageCapacity_kWh;
		gc.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh += difference_kWh/1000;
		gc.c_parentCoops.forEach( coop -> coop.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh += difference_kWh/1000);
		gc.energyModel.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh += difference_kWh/1000;
	}

	public void setCapacityElectric_kW(double capacityElectric_kW) {
		this.chargeCapacity_kW = capacityElectric_kW;
	}
	
	@Override
	public String toString() {
		return 
			"type = " + this.getClass().toString() + "\n" +
			"stateOfCharge_fr = " + this.stateOfCharge_fr + "\n" +
			"storageCapacity_kWh = " + this.storageCapacity_kWh + "\n" +
			"chargeCapacity_kW = " + this.chargeCapacity_kW + "\n" +
			"discharged_kWh " + this.discharged_kWh + "\n"+
			"charged_kWh " + this.charged_kWh + "\n";
	}
} 
