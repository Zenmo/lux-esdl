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
 * J_EAStorage
 */
public class J_EAStorage extends J_EAFlex {

	protected OL_EnergyCarriers storageMedium;
	protected double storageCapacity_kWh;
	protected double chargeCapacity_kW;
	protected double etaCharge_r;
	protected double etaDischarge_r;
	protected double stateOfCharge_fr;
	protected double initialStateOfCharge_fr;
	protected double stateOfChargeStored_r;
	protected double discharged_kWh = 0;
	protected double charged_kWh = 0;

    /**
     * Default constructor for serialization
     */
    public J_EAStorage() {
    }
    
    /**
     * Default constructor
     */
    public J_EAStorage(I_AssetOwner owner,  OL_EnergyAssetType energyAssetType, OL_EnergyCarriers storageMedium, double chargeCapacity_kW, double storageCapacity_kWh, double roundTripEfficiency_fr, double initialStateOfCharge_fr, J_TimeParameters timeParameters ) {
    	this.setOwner(owner);
		this.energyAssetType = energyAssetType;
		this.storageMedium = storageMedium;
		this.chargeCapacity_kW = chargeCapacity_kW;
		this.storageCapacity_kWh = storageCapacity_kWh;
		this.setRoundTripEfficiency_r(roundTripEfficiency_fr);
		this.initialStateOfCharge_fr = initialStateOfCharge_fr;
		this.stateOfCharge_fr = initialStateOfCharge_fr;
		this.timeParameters = timeParameters;
		
	    this.activeProductionEnergyCarriers.add(storageMedium);		
		this.activeConsumptionEnergyCarriers.add(storageMedium);
		registerEnergyAsset(timeParameters);
    }

	@Override
	public void operate(double powerFraction_fr, J_TimeVariables timeVariables) {
    	double inputPower_kW = powerFraction_fr * chargeCapacity_kW; // Positive power going into Storage, Negative if going out.
    	
    	double deltaEnergy_kWh; //Change in contents of storage
    	
    	// charging/discharging losses
    	if (inputPower_kW > 0) { // charging (the storage 'consumes' energy)
    		deltaEnergy_kWh = etaCharge_r * inputPower_kW * timeParameters.getTimeStep_h(); // Actual change of energy content of battery after losses. deltaEnergy_kWh is smaller than inputPower_kW * timestep_h!
    	} else { // discharging (the storage 'produces' energy)
    		deltaEnergy_kWh = inputPower_kW / etaDischarge_r * timeParameters.getTimeStep_h(); // Actual change of energy content of battery after losses. deltaEnergy_kWh is larger than inputPower_kW * timestep_h!
    	}
    	
    	// Limit SoC to feasible range (0-1)
    	deltaEnergy_kWh = - min( -deltaEnergy_kWh, (stateOfCharge_fr * storageCapacity_kWh) ); // Prevent negative charge
    	deltaEnergy_kWh = min(deltaEnergy_kWh, (1 - stateOfCharge_fr) * storageCapacity_kWh ); // Prevent overcharge
    	
    	//Set the final remaining flows
    	double storageInput_kW = 0;
    	double storageOutput_kW = 0;
    	if (deltaEnergy_kWh > 0) { // charging, deltaEnergy_kWh and inputPower_kW positive
    		inputPower_kW = deltaEnergy_kWh / timeParameters.getTimeStep_h() / etaCharge_r;
    		storageInput_kW = inputPower_kW;
    		storageOutput_kW = 0;
    		energyUse_kW = (1-etaCharge_r)*inputPower_kW;    		
    	} else { // discharging, deltaEnergy_kWh and inputPower_kW negative
    		inputPower_kW = deltaEnergy_kWh / timeParameters.getTimeStep_h() * etaDischarge_r;
    		storageInput_kW = 0;
    		storageOutput_kW = -inputPower_kW; 
    		energyUse_kW = -deltaEnergy_kWh / timeParameters.getTimeStep_h() * (1-etaDischarge_r);
    	}
    	energyUsed_kWh += energyUse_kW * timeParameters.getTimeStep_h();
    	
		discharged_kWh += storageOutput_kW * timeParameters.getTimeStep_h(); // Not the change-in-SoC, but the energy flowing out of the battery after losses.
		charged_kWh += storageInput_kW * timeParameters.getTimeStep_h(); // Not the change-in-SoC, but the energy flowing into the battery before losses.
		
		updateStateOfCharge( deltaEnergy_kWh );
		flowsMap.put(storageMedium, storageInput_kW-storageOutput_kW);
	}
	
	protected void updateStateOfCharge( double deltaEnergy_kWh ) {
		stateOfCharge_fr += deltaEnergy_kWh / storageCapacity_kWh;
	}
	
	//Setters
	public void setRoundTripEfficiency_r(double roundTripEfficiency_r) {
		if (roundTripEfficiency_r < 0 || roundTripEfficiency_r > 1) {
			traceln("Infeasible eta_r! Should be larger than 0 and no larger than 1! Setting eta_r=1. Input value is: %s", roundTripEfficiency_r);
			this.etaCharge_r = 1;			
			this.etaDischarge_r = 1;
		} else {
			this.etaCharge_r = Math.sqrt(roundTripEfficiency_r);			
			this.etaDischarge_r = Math.sqrt(roundTripEfficiency_r);
		}		
	}
	
	public void setStorageCapacity_kWh(double storageCapacity_kWh) {
		this.storageCapacity_kWh = storageCapacity_kWh;
	}
	public void setChargeCapacity_kW(double chargeCapacity_kW) {
		this.chargeCapacity_kW = chargeCapacity_kW;
	}
	
	//Getters
	public double getCurrentStateOfCharge_fr() {
    	return this.stateOfCharge_fr;
	}

	public double getStorageCapacity_kWh() {
		return this.storageCapacity_kWh;
	}
	
	public double getChargeCapacity_kW() {
		return this.chargeCapacity_kW;
	}

	public double getCurrentStateOfCharge_kWh() {
		return this.stateOfCharge_fr * this.storageCapacity_kWh;
	}
	
	public double getChargingEfficiency_r() {
		return this.etaCharge_r;
	}
	
	public double getDischargingEfficiency_r() {
		return this.etaDischarge_r;
	}
	
    @Override
    public void storeStatesAndReset() {
    	// Each energy asset that has some states should overwrite this function!
    	energyUsedStored_kWh = energyUsed_kWh;
    	energyUsed_kWh = 0.0;
    	stateOfChargeStored_r = stateOfCharge_fr;
    	stateOfCharge_fr = initialStateOfCharge_fr;    
    	charged_kWh = 0;
    	discharged_kWh = 0;
    	clear();    	
    }
    
	@Override
    public void restoreStates() {
    	// Each energy asset that has some states should overwrite this function!
    	energyUsed_kWh = energyUsedStored_kWh;    	
    	stateOfCharge_fr = stateOfChargeStored_r;
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
