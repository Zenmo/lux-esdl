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
 * J_ChargePoint
 */	
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,    // 
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")

public class J_ChargePoint implements I_ChargePointRegistration{
	
	private boolean hasSocketRestrictions;
	private int nbSockets;
	private double maxChargeCapacityPerSocket_kW;
	private List<Double> socketCapacitiesList_kW;
	private boolean V1GCapable;
	private boolean V2GCapable;
	
	private List<I_ChargingRequest> currentActiveChargingRequests = new ArrayList<>();
	

	private List<I_ChargingRequest> storedActiveChargingRequests = null;

    /**
     * Constructor for (de-)serialisation
     */
	public J_ChargePoint() {
	};
	
	/**
     * Default constructor
     * No restrictions on sockets
     */
    public J_ChargePoint(boolean V1GCapable, boolean V2GCapable ) {
    	this.V1GCapable = V1GCapable;
    	this.V2GCapable = V2GCapable;
    	this.hasSocketRestrictions = false;
    }

   /**
    * With equal restrictions on sockets
    */
   public J_ChargePoint(boolean V1GCapable, boolean V2GCapable, double maxChargeCapacityPerSocket_kW) {	
   	this.V1GCapable = V1GCapable;
   	this.V2GCapable = V2GCapable;
   	this.addSocketRestrictions(maxChargeCapacityPerSocket_kW);
   }
   
    /**
     * With various restrictions on sockets
     */
    public J_ChargePoint(boolean V1GCapable, boolean V2GCapable, List<Double> socketCapacitiesList_kW) {	
    	this.V1GCapable = V1GCapable;
    	this.V2GCapable = V2GCapable;
    	this.addSocketRestrictions(socketCapacitiesList_kW);
    }
    
    //Charge chargingRequest trough socket
    public void charge( I_ChargingRequest chargingRequest, double charge_kW, J_TimeVariables timeVariables, GridConnection parentGC ) { //GC is TEMPORARY FIX
		if (charge_kW < 0 && !this.V2GCapable) {
			throw new RuntimeException("Trying to do V2G trough a ChargePoint that is not V2GCapable");
		}
		double powerFraction_fr = DoubleCompare.equalsZero(chargingRequest.getVehicleChargingCapacity_kW()) ? 0.0 : charge_kW / chargingRequest.getVehicleChargingCapacity_kW();
		J_FlowPacket flowPacket = chargingRequest.f_updateAllFlows( powerFraction_fr, timeVariables);
		parentGC.f_addFlows(flowPacket, (J_EA)chargingRequest);
    }
    
    protected void performCheck() { //This call will check if all chargingrequest have been charged in a timestep. 
    	boolean check = true;
    	if(!check) {
    		throw new RuntimeException("Not all active charging requests where charged.");
    	}
    }
    
    
    //Functions used by trip/charging session managers to (de)register at the J_ChargePoint
    public void registerChargingRequest( I_ChargingRequest chargingRequest ) {
    	// TODO: (Longterm) Make this more complex when we need to take socket restrictions into account.
    	if(!isRegistered(chargingRequest)) {
    		this.currentActiveChargingRequests.add(chargingRequest);
    	}
    	else {
    		traceln("Trying to register a chargingrequest that is already registered!");
    	}
    }
    public void deregisterChargingRequest( I_ChargingRequest chargingRequest ) {
    	if(isRegistered(chargingRequest)) {
    		this.currentActiveChargingRequests.remove(chargingRequest);
    	}
    	else {
    		traceln("Trying to Deregister a chargingrequest that is not registered!");
    	}
    }    
    public boolean isRegistered( I_ChargingRequest chargingRequest ) {
    	return this.currentActiveChargingRequests.contains(chargingRequest);
    }
    
    
    public double getMaxChargingCapacity_kW(I_ChargingRequest chargingRequest) {
    	if(hasSocketRestrictions) {
    		return min(chargingRequest.getVehicleChargingCapacity_kW(), this.getSocketChargingCapacity_kW(chargingRequest));    		
    	}
    	else {
    		return chargingRequest.getVehicleChargingCapacity_kW();
    	}
    }
    
	public double getChargeDeadline_h(I_ChargingRequest chargingRequest) {
		double chargeNeedForNextTrip_kWh = chargingRequest.getRemainingChargeDemand_kWh(); // 
		double chargeTimeMargin_h = 0.25;// Margin to be ready with charging before start of next trip
		double nextTripStartTime_h = chargingRequest.getLeaveTime_h();
		double chargeDeadline_h = nextTripStartTime_h - (chargeNeedForNextTrip_kWh / this.getMaxChargingCapacity_kW(chargingRequest)) - chargeTimeMargin_h;
		return chargeDeadline_h;    		
	}
	
	
    public void addSocketRestrictions( double maxChargeCapacityPerSocket_kW) {
    	if(maxChargeCapacityPerSocket_kW <= 0) {
    		throw new RuntimeException("Trying to add socket restrictions to a J_ChargePoint with maxChargeCapacityPerSocket_kW = " + maxChargeCapacityPerSocket_kW);
    	}
    	this.hasSocketRestrictions = true;
    	this.maxChargeCapacityPerSocket_kW = maxChargeCapacityPerSocket_kW;
    }
    public void addSocketRestrictions( List<Double> socketCapacitiesList_kW) {
    	for(Double socketCapacity_kW : socketCapacitiesList_kW) {
    		if(socketCapacity_kW <= 0) {
        		throw new RuntimeException("Trying to add a socket restrictionsList to a J_ChargePoint that contains a socketCapacity_kW of " + socketCapacity_kW);
        	}
    	}
    	this.hasSocketRestrictions = true;
    	this.socketCapacitiesList_kW = socketCapacitiesList_kW;
    }
  
    private double getSocketChargingCapacity_kW(I_ChargingRequest chargingRequest) {
    	if(hasSocketRestrictions) {
    		if(socketCapacitiesList_kW == null) {
    			return maxChargeCapacityPerSocket_kW;
    		}
    		else {
    			return this.socketCapacitiesList_kW.get(getSocketIndexNb(chargingRequest));
    		}
    	}
    	else {
    		return chargingRequest.getVehicleChargingCapacity_kW();
    	}
    }
    
    private int getSocketIndexNb(I_ChargingRequest chargingRequest) {
    	return this.currentActiveChargingRequests.indexOf(chargingRequest);
    }
    
    //V1G and V2G capabilities setters/getters
    public void setV1GCapability(boolean V1GCapable) {
		this.V1GCapable = V1GCapable;
	}
	public void setV2GCapability(boolean V2GCapable) {
		this.V2GCapable = V2GCapable;
	}
	public boolean getV1GCapable() {
		return this.V1GCapable;
	}
	public boolean getV2GCapable() {
		return this.V2GCapable;
	}
	
	public int getCurrentNumberOfChargeRequests() {
		return this.currentActiveChargingRequests.size();
	}
	
	public List<I_ChargingRequest> getCurrentActiveChargingRequests(){
		return this.currentActiveChargingRequests;
	}
	
    public void storeStatesAndReset() {
    	this.storedActiveChargingRequests = new ArrayList<>(this.currentActiveChargingRequests);
    	this.currentActiveChargingRequests.clear();
    	//traceln("ChargePoint sessions cleared!");
    }
    
    public void restoreStates() {
    	this.currentActiveChargingRequests = new ArrayList<>(this.storedActiveChargingRequests);
    	this.storedActiveChargingRequests.clear();
    }
    
	@Override
	public String toString() {
		return "ChargePoint: hasSocketRestrictions: " + this.hasSocketRestrictions + 
				", V1G: " + this.V1GCapable + ", V2G: " + this.V2GCapable + 
				", ChargingCapacityPerSocket_kW: " + this.maxChargeCapacityPerSocket_kW +
				", currentNrOfChargeRequests: " + this.currentActiveChargingRequests.size();
				
	}
} 
