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
 * J_ChargingManagementOffPeak
 */	
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)
public class J_ChargingManagementOffPeak implements I_ChargingManagement {

    private GridConnection gc;
    private J_TimeParameters timeParameters;
    private OL_ChargingAttitude activeChargingType = OL_ChargingAttitude.BALANCE_GRID;
    private double filterTimeScale_h = 5*24;
    private double filterDiffGain_r;
    private double initialValueGCdemandLowPassed_kW = 0.5;
    private double GCdemandLowPassed_kW = this.initialValueGCdemandLowPassed_kW;
    
    private double startTimeOfReducedChargingInterval_hr = 17; // Hour of the day
    private double endTimeOfReducedChargingInterval_hr = 21; // Hour of the day
    
    private boolean V2GActive = false;
    
    
    //Stored
    private double storedGCdemandLowPassed_kW;
    
    /**
     * Default constructor
     */
    public J_ChargingManagementOffPeak( ) {
    }
    
    public J_ChargingManagementOffPeak( GridConnection gc, J_TimeParameters timeParameters) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    	this.filterDiffGain_r = 1/(filterTimeScale_h/timeParameters.getTimeStep_h());
    }
   
    
    public OL_ChargingAttitude getCurrentChargingType() {
    	return activeChargingType;
    }
    /**
     * One of the simplest charging algorithms.
     * 
     */
    public void manageCharging(J_ChargePoint chargePoint, J_TimeVariables timeVariables) {    	
    	double t_h = timeVariables.getT_h();
   
    	// Use current GC-load (so without EV charging!) as an 'equivalent price' signal, and use EV battery flexibility to make local load flatter.
    	double currentBalanceBeforeEV_kW = gc.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY);
    	GCdemandLowPassed_kW += (currentBalanceBeforeEV_kW - GCdemandLowPassed_kW) * filterDiffGain_r;
    	
		//Determine if time is currently in reduced charging interval
		double hourOfTheDay = t_h % 24;
		
		double intervalLength_hr = (endTimeOfReducedChargingInterval_hr - startTimeOfReducedChargingInterval_hr + 24) % 24;
		if(intervalLength_hr == 0) intervalLength_hr = 24; // (Start time == End time: for now defined as charge as little as possible all day.
		double intervalEndTimeSinceModelStart_hr = t_h - ((t_h - startTimeOfReducedChargingInterval_hr + 24) % 24) + intervalLength_hr;
		boolean timeIsInReducedChargingInterval = ((hourOfTheDay - startTimeOfReducedChargingInterval_hr + 24) % 24) < intervalLength_hr;

       	for (I_ChargingRequest chargingRequest : chargePoint.getCurrentActiveChargingRequests()) {
			double chargeNeedForNextTrip_kWh = chargingRequest.getEnergyNeedForNextTrip_kWh() - chargingRequest.getCurrentSOC_kWh(); // Can be negative if recharging is not needed for next trip!
			double chargeSetpoint_kW = 0;    			
			if ( t_h >= chargePoint.getChargeDeadline_h(chargingRequest) && chargeNeedForNextTrip_kWh > 0) { // Must-charge time at max charging power
				chargeSetpoint_kW = chargePoint.getMaxChargingCapacity_kW(chargingRequest);	
			} else {
				if(timeIsInReducedChargingInterval && chargeNeedForNextTrip_kWh > 0) {
    				double chargeTimeMargin_h = 0.5; // Margin to be ready with charging before start of next trip
    				double timeBetweenEndOfIntervalAndNextTripStartTime_hr = max(0, chargingRequest.getLeaveTime_h() - intervalEndTimeSinceModelStart_hr - chargeTimeMargin_h);
    				double energyThatCanBeChargedAfterIntervalEnded_kWh = timeBetweenEndOfIntervalAndNextTripStartTime_hr * chargePoint.getMaxChargingCapacity_kW(chargingRequest);
    				double energyThatNeedsToBeChargedDuringInterval_kWh = max(0, chargeNeedForNextTrip_kWh - energyThatCanBeChargedAfterIntervalEnded_kWh);
    		    	
    				double avgPowerDemandTillEndOfInterval_kW = energyThatNeedsToBeChargedDuringInterval_kWh / (intervalEndTimeSinceModelStart_hr - t_h);
    				chargeSetpoint_kW = avgPowerDemandTillEndOfInterval_kW;
				}
				else { // Dom laden
					chargeSetpoint_kW = chargePoint.getMaxChargingCapacity_kW(chargingRequest);
				}
			}
	    	//Send the chargepower setpoints to the chargepoint
	       	chargePoint.charge(chargingRequest, chargeSetpoint_kW, timeVariables, gc); 
    	}
    }

    public void setStartTimeOfReducedChargingInterval_hr(double startTimeOfReducedChargingInterval_hr) {
    	this.startTimeOfReducedChargingInterval_hr = startTimeOfReducedChargingInterval_hr;
    }
    
    public void setEndTimeOfReducedChargingInterval_hr(double endTimeOfReducedChargingInterval_hr) {
    	this.endTimeOfReducedChargingInterval_hr = endTimeOfReducedChargingInterval_hr;
    }  
    
    public double getStartTimeOfReducedChargingInterval_hr() {
    	return this.startTimeOfReducedChargingInterval_hr;
    }
    
    public double getEndTimeOfReducedChargingInterval_hr() {
    	return this.endTimeOfReducedChargingInterval_hr;
    }
    
	public void setV2GActive(boolean activateV2G) {
		this.V2GActive = activateV2G;
		this.gc.c_electricVehicles.forEach(ev -> ev.setV2GActive(activateV2G)); // NEEDED TO HAVE EV ASSET IN CORRECT assetFlowCatagory
		this.gc.c_chargingSessions.forEach(cs -> cs.setV2GActive(activateV2G)); // NEEDED TO HAVE CS ASSET IN CORRECT assetFlowCatagory
	}
	
	public boolean getV2GActive() {
		return this.V2GActive;
	}
	
	
	
    //Get parentagent
    public Agent getParentAgent() {
    	return this.gc;
    }
    
    //Store and reset states
	public void storeStatesAndReset() {
		this.storedGCdemandLowPassed_kW = this.GCdemandLowPassed_kW;
		this.GCdemandLowPassed_kW = this.initialValueGCdemandLowPassed_kW;
	}
	public void restoreStates() {
		this.GCdemandLowPassed_kW = this.storedGCdemandLowPassed_kW;
	}
	
	@Override
	public String toString() {
		return "Active charging type: " + this.activeChargingType;
	}
} 
