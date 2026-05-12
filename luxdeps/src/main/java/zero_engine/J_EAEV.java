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
* J_EAEV
*/
import com.fasterxml.jackson.annotation.JsonTypeName;

//@JsonTypeName("J_EAEV")
public class J_EAEV extends J_EAFlex implements I_Vehicle, I_ChargingRequest {
 
	private boolean available = true;
	private boolean availableStored = true;
	private double energyConsumption_kWhpkm;
	private double vehicleScaling;
	private J_ActivityTrackerTrips tripTracker;
	
	public OL_EnergyCarriers storageMedium = OL_EnergyCarriers.ELECTRICITY;
	private double stateOfCharge_fr;
	private double initialstateOfCharge_fr;
	private double stateOfChargeStored_r;
	protected double capacityElectric_kW;
	private double storageCapacity_kWh;
 
	private boolean V2GCapable = true; // For now default true: Add to constructor, where constructor calls: setV2GCapable(boolean isV2GCapable) to adjust min rato of capacity accordingly
	private boolean V2GActive = false;

	// Should this be in here?	
	private double energyNeedForNextTrip_kWh;
	private double energyNeedForNextTripStored_kWh;
	//public OL_EVChargingNeed chargingNeed;
	private double energyChargedOutsideModelArea_kWh = 0;
	private double energyChargedOutsideModelAreaStored_kWh;
	private double charged_kWh = 0;
	private double discharged_kWh = 0;
    /**
     * Default constructor
     */
    public J_EAEV() {
    }
 
    /**
     * Constructor initializing the fields
     */
    public J_EAEV(I_AssetOwner owner, double capacityElectricity_kW, double storageCapacity_kWh, double stateOfCharge_fr, J_TimeParameters timeParameters, double energyConsumption_kWhpkm, double vehicleScaling, OL_EnergyAssetType energyAssetType, J_ActivityTrackerTrips tripTracker) {
    	this(owner, capacityElectricity_kW, storageCapacity_kWh, stateOfCharge_fr, timeParameters, energyConsumption_kWhpkm, vehicleScaling, energyAssetType, tripTracker, true);
    }
    
    public J_EAEV(I_AssetOwner owner, double capacityElectricity_kW, double storageCapacity_kWh, double stateOfCharge_fr, J_TimeParameters timeParameters, double energyConsumption_kWhpkm, double vehicleScaling, OL_EnergyAssetType energyAssetType, J_ActivityTrackerTrips tripTracker, boolean available) {    
		this.setOwner(owner);
		this.timeParameters = timeParameters;
		this.capacityElectric_kW = capacityElectricity_kW; // for EV, this is max charging power.
		this.storageCapacity_kWh = storageCapacity_kWh;
		this.initialstateOfCharge_fr = stateOfCharge_fr;
		this.stateOfCharge_fr = initialstateOfCharge_fr;
		this.energyConsumption_kWhpkm = energyConsumption_kWhpkm;
		this.vehicleScaling = vehicleScaling;
	    this.energyAssetType = energyAssetType;
	    this.tripTracker = tripTracker;
    	this.available = available;
	    if (tripTracker != null) {
	    	tripTracker.vehicle=this;	    	
	    }
	    // Validation checks
	    if (capacityElectric_kW <= 0 || storageCapacity_kWh <= 0 || energyConsumption_kWhpkm <= 0) {
	    	throw new RuntimeException(String.format("Exception: J_EAEV in invalid state! Energy Asset: %s, capacityElectric_kW: %s, storageCapacity_kWh: %s, energyConsumption_kWhpkm %s", this, capacityElectric_kW, storageCapacity_kWh, energyConsumption_kWhpkm));
	    	
	    }
	    this.activeProductionEnergyCarriers.add(this.storageMedium);   	
		this.activeConsumptionEnergyCarriers.add(this.storageMedium);
		
		if(V2GCapable && this.V2GActive) {
			this.assetFlowCategory = OL_AssetFlowCategories.V2GPower_kW;
		} else {
			this.assetFlowCategory = OL_AssetFlowCategories.evChargingPower_kW;
		}
		
		registerEnergyAsset(timeParameters);
    }
    
	@Override
	public void operate(double ratioOfChargeCapacity_r, J_TimeVariables timeVariables) {
		if (!available) {
			throw new RuntimeException("Trying to charge EV that is not available for charging!");
		}
		double chargeSetpoint_kW = ratioOfChargeCapacity_r * this.capacityElectric_kW * vehicleScaling; // capped between -1 and 1. (does already happen in f_updateAllFlows()!)
    	double chargePower_kW = max(min(chargeSetpoint_kW, (1 - stateOfCharge_fr) * storageCapacity_kWh * vehicleScaling / this.timeParameters.getTimeStep_h()), -stateOfCharge_fr * storageCapacity_kWh * vehicleScaling / this.timeParameters.getTimeStep_h()); // Limit charge power to stay within SoC 0-100
    	
    	//traceln("state of charge: " + stateOfCharge_fr * storageCapacity_kWh + ", charged: " + discharge_kW / 4+ " kWh, charging power kW: " + discharge_kW);
		double electricityProduction_kW = max(-chargePower_kW, 0);
		double electricityConsumption_kW = max(chargePower_kW, 0);
		updateStateOfCharge( chargePower_kW );

		updateChargingHistory( electricityProduction_kW, electricityConsumption_kW );

		flowsMap.put(OL_EnergyCarriers.ELECTRICITY, electricityConsumption_kW - electricityProduction_kW);
		// Split charging and discharing power 'at the source'!
		if (chargePower_kW > 0) { // charging
			assetFlowsMap.put(OL_AssetFlowCategories.evChargingPower_kW, electricityConsumption_kW);
		} else if(chargePower_kW < 0){
			if(this.V2GCapable && this.V2GActive) {
				assetFlowsMap.put(OL_AssetFlowCategories.V2GPower_kW, electricityProduction_kW);
			}
			else {
				throw new RuntimeException("Trying to discharge an EV, that does not have the capability or where v2g is not activated!");
			}
		}
	}
 
	public void updateStateOfCharge( double power_kW ) {
		if(vehicleScaling > 0){
			stateOfCharge_fr += ( power_kW * this.timeParameters.getTimeStep_h() ) / (storageCapacity_kWh * vehicleScaling);
		}
		else {
			stateOfCharge_fr = 0;
		}
	}
	public void updateChargingHistory(double electricityProduced_kW, double electricityConsumed_kW) {
		discharged_kWh += electricityProduced_kW * this.timeParameters.getTimeStep_h();
		charged_kWh += electricityConsumed_kW * this.timeParameters.getTimeStep_h();
	}
	
	public boolean startTrip(J_TimeVariables timeVariables) {
		if (available) {
			((GridConnection)this.getOwner()).f_updateFlexAssetFlows(this , 0.0, timeVariables);
			this.available = false;
			//Update (charging) flows to zero, because vehicle is away.

			return true;
		} else {
			traceln("Trip not started because EV not available!");
			return false; // Trip not started because EV not available!
		}
	}	
 
	public boolean endTrip(double tripDist_km) {
	
		if(available) {
			traceln("Trip not ended because EV never left!");
			return false;
		}else if (this.vehicleScaling == 0) {
			this.available = true;
			return true;
		} else {
			//mileage_km += tripDist_km;
			double consumption_fr = (tripDist_km * energyConsumption_kWhpkm) / (storageCapacity_kWh);
			//traceln("J_EAEV.endTrip(), trip consumption: %s [pct of SoC], specific consumption kWh/km: %s", 100*consumption_fr, energyConsumption_kWhpkm);
			stateOfCharge_fr -= (tripDist_km * vehicleScaling * energyConsumption_kWhpkm) / (storageCapacity_kWh * vehicleScaling);

			energyUsed_kWh += tripDist_km * vehicleScaling * energyConsumption_kWhpkm;
			energyUse_kW += tripDist_km * vehicleScaling * energyConsumption_kWhpkm / this.timeParameters.getTimeStep_h();
			if (stateOfCharge_fr < 0) {
				traceln("EV of type: " + this.energyAssetType + " arrived home with negative SOC: " + roundToDecimal(100 * stateOfCharge_fr,2) + "%");
			}
			this.available = true;
			return true;
		}
	}
	
	// Methods from I_Vehicle
	public void setVehicleScaling(double vehicleScaling) {
    	this.vehicleScaling = vehicleScaling;
    }
    
	public void setTripTracker(J_ActivityTrackerTrips tracker) {
		this.tripTracker = tracker;
	}
	
	public void setEnergyNeedForNextTrip_kWh(double energyNeedForNextTrip_kWh) {
		this.energyNeedForNextTrip_kWh = energyNeedForNextTrip_kWh;
	}
	
	public J_ActivityTrackerTrips getTripTracker() {
		return this.tripTracker;
	}
	
	public boolean getAvailability() {
		return this.available;
	}
	
	public void setAvailability(boolean available) {
    	this.available = available;
    }
	
	public double getVehicleScaling_fr() {
		return this.vehicleScaling;
	}
	
	public double getEnergyConsumption_kWhpkm() {
		return this.energyConsumption_kWhpkm * this.vehicleScaling;
	}
	
	// Methods from I_ChargingRequest
	public double getLeaveTime_h() {
		return getNextTripStartTime_h();
	}	
	
	public double getNextTripStartTime_h() {
		return this.tripTracker.getNextEventStartTime_h();
	}

	public double getCurrentStateOfCharge_fr() {
    	return this.stateOfCharge_fr;
	}
 
	public double getStorageCapacity_kWh() {
		return this.storageCapacity_kWh * this.vehicleScaling;
	}

	public double getCurrentSOC_kWh() {
		return this.stateOfCharge_fr * this.getStorageCapacity_kWh();
	}
		
	public double getVehicleChargingCapacity_kW() {
		return this.capacityElectric_kW * this.vehicleScaling;
	}

	public double getEnergyNeedForNextTrip_kWh() {
		return this.energyNeedForNextTrip_kWh;
	}
	
	public double getRemainingChargeDemand_kWh() {
		return max(0, this.getEnergyNeedForNextTrip_kWh() - this.getCurrentSOC_kWh());
	}
	
	public double getRemainingAverageChargingDemand_kW(double t_h) {
		return getLeaveTime_h() > t_h ? getRemainingChargeDemand_kWh() / (getLeaveTime_h() - t_h) : 0;
	}
	
	public double getChargingTimeToFull_MIN() {
		double chargingTime_min = ceil( 60 * ((storageCapacity_kWh * vehicleScaling) - (storageCapacity_kWh * vehicleScaling) * stateOfCharge_fr) / (capacityElectric_kW * vehicleScaling) ) ;
		return chargingTime_min;
	}
 	
	// Other methods
	public double getTotalChargeAmount_kWh() {
		return this.charged_kWh;
	}
	public double getTotalDischargeAmount_kWh() {
		return this.discharged_kWh;
	}
	
	public double getEnergyChargedOutsideModelArea_kWh() {
		return energyChargedOutsideModelArea_kWh;
	}
	
	//V2G capabilities
	public void setV2GCapable(boolean isV2GCapable) {
		this.V2GCapable = isV2GCapable;
		setV2GActive(getV2GActive());
	}
	
	public boolean getV2GCapable() {
		return this.V2GCapable;
	}
	
	public boolean getV2GActive() {
		return this.V2GActive;
	}
	
	protected void setV2GActive(boolean activateV2G) { // Should only be called by the chargingManagement class or J_EAEV during initialization itself. (No such thing as friend class in java, so only can put on protected).
		this.V2GActive = activateV2G;
		if(this.V2GCapable && activateV2G) {
			this.assetFlowCategory = OL_AssetFlowCategories.V2GPower_kW;
		}
		else {
			this.assetFlowCategory = OL_AssetFlowCategories.evChargingPower_kW;
		}
	}
	
	@Override
    public void storeStatesAndReset() {
		//traceln("EV reset!");
    	energyUsedStored_kWh = energyUsed_kWh;
    	energyUsed_kWh = 0.0;
    	stateOfChargeStored_r = stateOfCharge_fr;
    	stateOfCharge_fr = initialstateOfCharge_fr;
    	availableStored = available;
    	available = true;
    	energyNeedForNextTripStored_kWh = energyNeedForNextTrip_kWh;
    	energyNeedForNextTrip_kWh = 0;
    	energyChargedOutsideModelAreaStored_kWh = energyChargedOutsideModelArea_kWh;
    	energyChargedOutsideModelArea_kWh = 0;
    	charged_kWh = 0;
    	discharged_kWh = 0;
    	clear();    	
    }
    
	@Override
    public void restoreStates() {
    	energyUsed_kWh = energyUsedStored_kWh;    	
    	stateOfCharge_fr = stateOfChargeStored_r;
    	available = availableStored;
    	energyNeedForNextTrip_kWh = energyNeedForNextTripStored_kWh;
    	energyChargedOutsideModelArea_kWh = energyChargedOutsideModelAreaStored_kWh;
    	charged_kWh = 0;
    	discharged_kWh = 0;
    }
	
	@Override
	public String toString() {
		return
			"SOC = " + roundToDecimal( stateOfCharge_fr, 2 ) + " " +
			"storageCapacity_kWh = " + storageCapacity_kWh + " " +
			"charged_kWh = " + roundToDecimal( charged_kWh, 2 );
	}
}
 
 
