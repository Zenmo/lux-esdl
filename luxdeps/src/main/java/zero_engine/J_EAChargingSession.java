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
* J_EAChargingSession
*/	
public class J_EAChargingSession extends zero_engine.J_EAFlex implements I_ChargingRequest {
	
	private List<J_ChargingSessionData> chargingSessionDataList;
	private int socketNb;
	
	//Current session information
	private J_ChargingSessionData currentChargingSessionData;
	
	private double currentChargingSessionSOC_kWh = 0;
	private double currentSessionChargingBalance_kWh = 0;
	
	//Next session
	private int nextSessionIndex = 0;
	
	//Vehicle scaling
	private double vehicleScaling = 1;
 
	//V2GActive/capability (override) parameters
	private boolean V2GActive = false;
	private double V2GCapabilityProbablityOverride = 0;
	private boolean overrideV2GCapability = false;
 
	//Monitoring
	private double totalCharged_kWh = 0;
	private double totalDischarged_kWh = 0;
 
	//Stored live sim values
	private J_ChargingSessionData storedCurrentChargingSessionData;
	private double storedCurrentChargingSessionSOC_kWh;
	private double storedCurrentSessionChargingBalance_kWh;
	private double storedTotalCharged_kWh;
	private double storedTotalDischarged_kWh;
	private int storedNextSessionIndex;	
	
    /**
     * Constructor for (de-)serialisation
     */
	public J_EAChargingSession() {
	}
	
    /**
     * Default constructor initializing the fields
     */	
	public J_EAChargingSession(I_AssetOwner owner, List<J_ChargingSessionData> chargingSessionDataList, int socketNb, J_TimeParameters timeParameters) {
		this.setOwner(owner);	
		this.timeParameters = timeParameters;
		this.socketNb = socketNb;
    	this.chargingSessionDataList = chargingSessionDataList;
    	
	    this.activeProductionEnergyCarriers.add(OL_EnergyCarriers.ELECTRICITY);   	
		this.activeConsumptionEnergyCarriers.add(OL_EnergyCarriers.ELECTRICITY);
		this.setV2GActive(this.V2GActive);
		
		registerEnergyAsset(timeParameters);
	}
	
	@Override
	public void operate(double ratioOfChargeCapacity_r, J_TimeVariables timeVariables) {
 
    	double chargeSetpoint_kW = ratioOfChargeCapacity_r * this.getVehicleChargingCapacity_kW(); // capped between -1 and 1 does already happen in f_updateAllFlows()!
    	double chargePower_kW = max(min(chargeSetpoint_kW, (this.getStorageCapacity_kWh() - this.getCurrentSOC_kWh()) / this.timeParameters.getTimeStep_h()), -this.getCurrentSOC_kWh() / this.timeParameters.getTimeStep_h()); // Limit charge power to stay within SoC 0-100
 
		//Round to floating point precision
    	chargePower_kW = roundToDecimal(chargePower_kW, 10);
    	
    	//Bookkeeping of energy flows
    	double electricityProduction_kW = max(-chargePower_kW, 0);
		double electricityConsumption_kW = max(chargePower_kW, 0);
		this.currentChargingSessionSOC_kWh += chargePower_kW * this.timeParameters.getTimeStep_h();
		this.currentSessionChargingBalance_kWh += chargePower_kW * this.timeParameters.getTimeStep_h();
 
		updateChargingHistory( electricityProduction_kW, electricityConsumption_kW );
 
		//Update the EC flows map
		flowsMap.put(OL_EnergyCarriers.ELECTRICITY, electricityConsumption_kW - electricityProduction_kW);
		
		//Update the assetFlowsMap
		if (chargePower_kW > 0) { // charging
			assetFlowsMap.put(OL_AssetFlowCategories.evChargingPower_kW, electricityConsumption_kW);
		}
		else if(chargePower_kW < 0){
			if(this.currentChargingSessionData.getV2GCapable() && this.V2GActive) {
				assetFlowsMap.put(OL_AssetFlowCategories.V2GPower_kW, electricityProduction_kW);
			}
			else {
				throw new RuntimeException("Trying to discharge a chargingsession, that does not have the capability or where v2g is not activated! (chargePower_kW = " + chargePower_kW + ")");
			}
		}
	}
	
 
	
	public void manageCurrentChargingSession(J_TimeVariables timeVariables, I_ChargePointRegistration chargePointRegistration, GridConnection GC) {
		
		if (this.currentChargingSessionData != null && timeVariables.getT_h() >= this.currentChargingSessionData.getLeaveTime_h()) { // End session
			if (DoubleCompare.greaterThanZero(this.getRemainingChargeDemand_kWh()) ) { traceln("!!Chargesession ended but charge demand not fullfilled!! Remaining demand: %s kWh", this.getRemainingChargeDemand_kWh()); }
			this.energyUsed_kWh += this.currentSessionChargingBalance_kWh; //Add all netto energy charged to the vehicle as final consumption
			this.energyUse_kW += this.currentSessionChargingBalance_kWh/this.timeParameters.getTimeStep_h(); //Add all netto energy charged to the vehicle as final consumption
			GC.f_updateFlexAssetFlows(this, 0.0, timeVariables); //Call needed to transfer energyUse_kW to add flows
			this.currentChargingSessionData = null;
			chargePointRegistration.deregisterChargingRequest(this);
			this.currentSessionChargingBalance_kWh = 0;
			this.currentChargingSessionSOC_kWh = 0;
		}
		
 
		if ( this.currentChargingSessionData == null ) { // socket currently free
			 // check if we are not already past the last charging session.
			// Find next charging session on this socket
			
			
			while (this.nextSessionIndex < this.chargingSessionDataList.size() && this.chargingSessionDataList.get(nextSessionIndex).getSocketNb() != this.socketNb) {				
				this.nextSessionIndex++;
			}  
			
			if (this.nextSessionIndex >= this.chargingSessionDataList.size()) { // no more sessions available
				return;	
 
			} else {					
				loadChargingSessionData(this.chargingSessionDataList.get(nextSessionIndex));
				
				if (timeVariables.getT_h() > this.currentChargingSessionData.getStartTime_h()) {
					traceln("Chargesession %s started %s hours too late!", this.nextSessionIndex, timeVariables.getT_h() - this.currentChargingSessionData.getStartTime_h());	
					if (timeVariables.getT_h() >= this.currentChargingSessionData.getLeaveTime_h()) {
						traceln("!!Chargesession started after its endTime_h!!");
					}
				}
				this.nextSessionIndex++;
			}
		}
 
		if(this.currentChargingSessionData != null && this.currentChargingSessionData.getStartTime_h() == timeVariables.getT_h()) {
			chargePointRegistration.registerChargingRequest(this);
		}
	}
	
	public void loadChargingSessionData(J_ChargingSessionData chargingSessionData) {
		this.currentChargingSessionData = chargingSessionData.getClone();
		if(this.overrideV2GCapability) {
			this.currentChargingSessionData.overrideV2GCapability(this.overrideV2GCapability, random() < this.V2GCapabilityProbablityOverride);
		}
		this.currentChargingSessionSOC_kWh = currentChargingSessionData.getInitialSOC_kWh() * this.vehicleScaling;
	}
	
	//Get current ChargingRequest (interface) information
	public double getLeaveTime_h() {
		return this.currentChargingSessionData.getLeaveTime_h();
	}
 
	public double getVehicleChargingCapacity_kW() {
		return this.currentChargingSessionData.getChargingCapacity_kW() * this.vehicleScaling;
	}
	
	public double getCurrentSOC_kWh() {
		return this.currentChargingSessionSOC_kWh;
	}
	
	public double getStorageCapacity_kWh() {
		return this.currentChargingSessionData.getStorageCapacity_kWh() * this.vehicleScaling;
	}
 
    public double getEnergyNeedForNextTrip_kWh() {
    	return this.currentChargingSessionData.getEnergyNeededForNextTrip_kWh() * this.vehicleScaling;
    }
    
    public double getRemainingChargeDemand_kWh() {
        return (this.currentChargingSessionData.getEnergyNeededForNextTrip_kWh() * this.vehicleScaling) - getCurrentSOC_kWh();
    }
    
	public double getRemainingAverageChargingDemand_kW(double t_h) {
		return getLeaveTime_h() > t_h ? getRemainingChargeDemand_kWh() / (getLeaveTime_h() - t_h) : 0;
	}
	
	public double getVehicleScaling_fr() {
		return this.vehicleScaling;
	}
	
	public boolean getV2GCapable() {
		return this.currentChargingSessionData.getV2GCapable();
	}
	
	//Availability (If chargingsession is currently active)
	public boolean getAvailability(double t_h) {
		return this.currentChargingSessionData != null ? this.currentChargingSessionData.getAvailability(t_h) : false;
	}
	
	//V2G activation and capabilities
	public void enableV2GCapabilityOverride(boolean enableV2GCapabilityOverride, Double V2GCapabilityProbablityOverride) {
		this.overrideV2GCapability = enableV2GCapabilityOverride;
		this.V2GCapabilityProbablityOverride = V2GCapabilityProbablityOverride;
		setV2GActive(getV2GActive());
	}
	
	protected void setV2GActive(boolean activateV2G) { // Should only be called by the chargingManagement class or J_EAChargingSession during initialization itself. (No such thing as friend class in java, so only can put on protected).
		this.V2GActive = activateV2G;
		if((!this.overrideV2GCapability || (this.overrideV2GCapability && this.V2GCapabilityProbablityOverride > 0)) && activateV2G) {
			this.assetFlowCategory = OL_AssetFlowCategories.V2GPower_kW;
		}
		else {
			this.assetFlowCategory = OL_AssetFlowCategories.evChargingPower_kW;
		}
	}
 
	public boolean getV2GActive() {
		return this.V2GActive;
	}
	
	
	//Fast forward charging sessions when GC is unpaused to prevent massive peaks for GCs that are trying to catch up
	public void fastForwardCharingSessions(double t_h, I_ChargePointRegistration chargePointRegistration) {	
		
		//Clear current charging session
		this.currentChargingSessionData = null;
		this.currentSessionChargingBalance_kWh = 0;
		this.currentChargingSessionSOC_kWh = 0;
		
		if(chargePointRegistration.isRegistered(this)) {
			chargePointRegistration.deregisterChargingRequest(this);
		}
		
		//Find next charging session that starts after the current time
		while (this.nextSessionIndex < this.chargingSessionDataList.size() && (this.chargingSessionDataList.get(this.nextSessionIndex).getSocketNb() != socketNb || this.chargingSessionDataList.get(this.nextSessionIndex).getStartTime_h() <= t_h)) {				
			this.nextSessionIndex++;
		}
		
		if (this.nextSessionIndex >= this.chargingSessionDataList.size()) { // no more sessions available
			return;					
		} else { //Load upcomming charger session and increase next session index					
			loadChargingSessionData(this.chargingSessionDataList.get(nextSessionIndex));
			this.nextSessionIndex++;
		}
		
		if(this.currentChargingSessionData != null && this.currentChargingSessionData.getStartTime_h() == t_h) {
			chargePointRegistration.registerChargingRequest(this);
		}
	}
    
	
	public void updateChargingHistory(double electricityProduced_kW, double electricityConsumed_kW) {
		this.totalCharged_kWh += electricityConsumed_kW * this.timeParameters.getTimeStep_h();
		this.totalDischarged_kWh += electricityProduced_kW * this.timeParameters.getTimeStep_h();
	}
	
	
	public double getTotalChargeAmount_kWh() {
		return this.totalCharged_kWh;
	}
	public double getTotalDischargeAmount_kWh() {
		return this.totalDischarged_kWh;
	}
	
    public void storeStatesAndReset() {
    	//Store
    	this.energyUsedStored_kWh = this.energyUsed_kWh;
    	this.storedCurrentChargingSessionSOC_kWh = this.currentChargingSessionSOC_kWh;
    	this.storedCurrentSessionChargingBalance_kWh = this.currentSessionChargingBalance_kWh;
    	this.storedTotalCharged_kWh = totalCharged_kWh;
    	this.storedTotalDischarged_kWh = totalDischarged_kWh;	
    	this.storedCurrentChargingSessionData = this.currentChargingSessionData;
    	this.storedNextSessionIndex = this.nextSessionIndex;
    	
    	//Reset
    	this.energyUsed_kWh = 0.0;
    	this.currentChargingSessionSOC_kWh = 0;
    	this.currentSessionChargingBalance_kWh = 0;
    	this.totalCharged_kWh = 0;
    	this.totalDischarged_kWh = 0;	
    	this.currentChargingSessionData = null;
    	this.nextSessionIndex = 0;
    	clear();    	
    }
    
    public void restoreStates() {
    	this.energyUsed_kWh = this.energyUsedStored_kWh;
    	this.currentChargingSessionSOC_kWh = this.storedCurrentChargingSessionSOC_kWh;
    	this.currentSessionChargingBalance_kWh = this.storedCurrentSessionChargingBalance_kWh;
    	this.totalCharged_kWh = this.storedTotalCharged_kWh;
    	this.totalDischarged_kWh = this.storedTotalDischarged_kWh;	
    	this.currentChargingSessionData = this.storedCurrentChargingSessionData;
    	this.nextSessionIndex = this.storedNextSessionIndex;
    }
    
	@Override
	public String toString() {
		return "Current session info: chargingCapacity_kW: " + getVehicleChargingCapacity_kW() +
				", getEnergyNeedForNextTrip_kWh: " + getEnergyNeedForNextTrip_kWh() +
				", getCurrentSOC_kWh(): " + getCurrentSOC_kWh() +
				", getRemainingChargeDemand_kWh: " + getRemainingChargeDemand_kWh() +
				", getLeaveTime_h: " + getLeaveTime_h();
	}
} 
