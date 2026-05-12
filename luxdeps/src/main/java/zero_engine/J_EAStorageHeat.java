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
 * J_EAStorageHeat
 */
public class J_EAStorageHeat extends zero_engine.J_EAStorage {

	public OL_EnergyCarriers storageMedium = OL_EnergyCarriers.HEAT;
	private double storageCapacity_kWh;
	
	private double stateOfCharge_fr;
	protected double lossFactor_WpK;
	protected double capacityHeat_kW;
	
	protected double heatCharged_kWh;
	protected double heatDischarged_kWh;
	
	protected double temperature_degC;
	protected double temperatureStored_degC;
	protected double initialTemperature_degC;
	protected double minTemperature_degC;
	protected double maxTemperature_degC;
	private double setTemperature_degC;
	protected double heatCapacity_JpK;
	protected double ambientTemperature_degC;
	protected double ambientEnergyAbsorbed_kWh=0;
	protected double ambientEnergyAbsorbedStored_kWh=0;
	protected OL_AmbientTempType ambientTempType;
	//Secureing updates
	private boolean updateAmbientTemperatureHasBeenCalled = false;


    /**
     * Default constructor
     */
    public J_EAStorageHeat() {
    }

    /**
     * Constructor initializing the fields
     */
    public J_EAStorageHeat(I_AssetOwner owner, OL_EnergyAssetType energyAssetType, double capacityHeat_kW, double lossFactor_WpK, J_TimeParameters timeParameters, double initialTemperature_degC, double minTemperature_degC, double maxTemperature_degC, double setTemperature_degC, double heatCapacity_JpK, OL_AmbientTempType ambientTempType ) {
		this.setOwner(owner);
		this.timeParameters = timeParameters;
		this.energyAssetType = energyAssetType;
		this.capacityHeat_kW = capacityHeat_kW;
		this.lossFactor_WpK = lossFactor_WpK;
		this.temperature_degC = initialTemperature_degC;
		this.initialTemperature_degC = initialTemperature_degC;
		this.minTemperature_degC = minTemperature_degC;
		this.maxTemperature_degC = maxTemperature_degC;
		this.setTemperature_degC = setTemperature_degC;
		
		if(this.initialTemperature_degC > this.maxTemperature_degC || this.initialTemperature_degC < this.minTemperature_degC) {
			new RuntimeException("Heatbuffer initial temperature is not within the defined min/max temperature limits of the buffer");
		}
		if(this.setTemperature_degC > this.maxTemperature_degC || this.setTemperature_degC < this.minTemperature_degC) {
			new RuntimeException("Heatbuffer set temperature is not within the defined min/max temperature limits of the buffer");
		}
		
		this.heatCapacity_JpK = heatCapacity_JpK;
		this.ambientTempType = ambientTempType;
		this.storageCapacity_kWh = ( maxTemperature_degC - minTemperature_degC ) * heatCapacity_JpK / 3.6e+6;
		this.stateOfCharge_fr = (( initialTemperature_degC - minTemperature_degC ) / (maxTemperature_degC - minTemperature_degC ) );
	    this.activeProductionEnergyCarriers.add(OL_EnergyCarriers.HEAT);		
		this.activeConsumptionEnergyCarriers.add(OL_EnergyCarriers.HEAT);
		registerEnergyAsset(timeParameters);
    }

	public double calculateLoss_kW() {
		if(ambientTempType != OL_AmbientTempType.FIXED && !this.updateAmbientTemperatureHasBeenCalled) {
			new RuntimeException("Ambient temperature has not been updated for the heat storage asset, make sure to call the updateAmbientTemperature() method while using a heat storage");
		}
		else {
			updateAmbientTemperatureHasBeenCalled = false;
		}
		double heatLoss_kW = lossFactor_WpK * ( temperature_degC - ambientTemperature_degC )  * 0.001;
		return heatLoss_kW;
	}

	@Override
	public void operate(double powerFraction_fr, J_TimeVariables timeVariables) {
		//traceln("StorageAsset Heat Operatefunctie: ambienttemperature = "+ambientTemperature_degC);
		//traceln("StorageAsset Heat Operatefunctie: ambienttemperature = "+ambientTemperature_degC+" | powerFraction_fr = " + ratioOfChargeCapacity_r + ".");
		//traceln("<><><><> heatstorage reset heatproduction = "+heatProduction_kW+", heatconsumption_kW = "+heatConsumption_kW+" heatProduced_kWh = "+heatProduced_kWh + "heatConsumed = "+heatConsumed_kWh + ", losses= "+energyUsed_kWh );
		

		double lossPower_kW = calculateLoss_kW(); // Heat lost to the environment; this call also updates energyUse_kW and the 'state of charge' (temperature).
		this.energyUse_kW = lossPower_kW;
		energyUsed_kWh += max(0,energyUse_kW * timeParameters.getTimeStep_h()); // Only heat loss! Not heat gain when outside is hotter than inside!
		
		//Calculate requested input power
		double inputPower_kW = powerFraction_fr * capacityHeat_kW; // positive power means adding heat to the buffer
		
    	// Limit input power to usable SoC range (0-1) (Only limits power requests and input, not losses!)
		double usableEnergyInStorage_kWh = (stateOfCharge_fr * storageCapacity_kWh) - (lossPower_kW*timeParameters.getTimeStep_h());
		inputPower_kW = - min( -inputPower_kW, usableEnergyInStorage_kWh/timeParameters.getTimeStep_h() ); // Prevent negative charge
		inputPower_kW = min(inputPower_kW, (storageCapacity_kWh - usableEnergyInStorage_kWh)/timeParameters.getTimeStep_h() ); // Prevent overcharge
		
    	//Accounting of (dis)charged heat
		double heatDischarged_kW = max(-inputPower_kW, 0);
		double heatCharged_kW = max(inputPower_kW, 0);
		heatDischarged_kWh += heatDischarged_kW * timeParameters.getTimeStep_h();
		heatCharged_kWh += heatCharged_kW * timeParameters.getTimeStep_h();
		
    	double deltaEnergy_kWh = (inputPower_kW-lossPower_kW) * timeParameters.getTimeStep_h(); // to check the request with the energy currently in storage   	
		updateStateOfCharge( deltaEnergy_kWh );
		
		if (this.temperature_degC > this.maxTemperature_degC) {
			traceln("Warning!! Heat storage temperature too high! Strorage asset: %s", this);
		} else if (this.temperature_degC < this.minTemperature_degC) {
			traceln("Warning!! Heat storage temperature too low! Strorage asset: %s", this);
		}

		flowsMap.put(OL_EnergyCarriers.HEAT, heatCharged_kW-heatDischarged_kW);		
		
	}
	
	@Override
    public void storeStatesAndReset() {
    	// Each energy asset that has some states should overwrite this function!
    	energyUsedStored_kWh = energyUsed_kWh;
    	ambientEnergyAbsorbedStored_kWh = ambientEnergyAbsorbed_kWh;
    	energyUsed_kWh = 0.0;
    	ambientEnergyAbsorbed_kWh = 0.0;
    	temperatureStored_degC = temperature_degC;
    	temperature_degC = initialTemperature_degC;
    	clear();    	
    }
    
	@Override
    public void restoreStates() {
    	// Each energy asset that has some states should overwrite this function!
    	energyUsed_kWh = energyUsedStored_kWh;
    	ambientEnergyAbsorbed_kWh = ambientEnergyAbsorbedStored_kWh;
    	temperature_degC = temperatureStored_degC;
    }

	@Override
	public String toString() {
		return
			"type = " + this.getClass().toString() + " " +
			"Energy consumed = " + this.energyUsed_kWh +
			" temp = " + this.temperature_degC + " " +
			"capacityHeat_kW = " + this.capacityHeat_kW +" "+
			"stateOfCharge_fr = " + this.stateOfCharge_fr+" "+
			"minTemperature_degC = " + this.minTemperature_degC+" "+
			"maxTemperature_degC = " + this.maxTemperature_degC+" "+
			"setTemperature_degC = " + this.setTemperature_degC+" "+			
			"ambientTemperature_degC = "+this.ambientTemperature_degC+" "+
			"energyUsed_kWh (losses) = " + this.energyUsed_kWh + " "+
			"heatDischarged_kWh = "+ this.heatDischarged_kWh + " "+
			"heatCharged_kWh = "+ this.heatCharged_kWh + " ";
	}

	@Override
	protected void updateStateOfCharge( double deltaEnergy_kWh ) {
		double tempDelta_degC = deltaEnergy_kWh / (heatCapacity_JpK / 3.6E6 );
		this.temperature_degC += tempDelta_degC;
		stateOfCharge_fr = ( temperature_degC - minTemperature_degC) / (maxTemperature_degC - minTemperature_degC);
	}

	public double getInitialTemperature_degC() {
		return this.initialTemperature_degC;
	}
	
	//@Override
	public double getCurrentTemperature() {
		return temperature_degC;
	}

	public double getSetTemperature_degC() {
		return setTemperature_degC;
	}
	
	public double getMinTemperature_degC() {
		return minTemperature_degC;
	}
	
	public double getMaxTemperature_degC() {
		return maxTemperature_degC;
	}

	public double getStorageCapacity_kWh() {
		return storageCapacity_kWh;
	}

	public double getCapacityHeat_kW() {
		return this.capacityHeat_kW;
	}
	
	public double getHeatCapacity_JpK() {
		return heatCapacity_JpK;
	}
	
	public double getLossFactor_WpK() {
		return lossFactor_WpK;
	}
	
	public double getAmbientTemperature_degC() {
		return ambientTemperature_degC;
	}
	
	public OL_AmbientTempType getAmbientTempType() {
		return this.ambientTempType;
	}

	public double getStartingHeatStorageHeat_kWh() {
		return (this.initialTemperature_degC - this.minTemperature_degC) * heatCapacity_JpK /3.6e6;
	}
	
	public double getRemainingHeatStorageHeat_kWh() {
		return (this.temperature_degC - this.minTemperature_degC) * heatCapacity_JpK /3.6e6;
	}

	public void updateAmbientTemperature(double currentAmbientTemperature_degC) {
		this.updateAmbientTemperatureHasBeenCalled = true;
		ambientTemperature_degC = currentAmbientTemperature_degC;
	}
}

 
