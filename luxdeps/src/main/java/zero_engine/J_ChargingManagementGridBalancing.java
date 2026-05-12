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
 * J_ChargingManagementGridBalancing
 */	

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import java.util.EnumSet;

@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)
public class J_ChargingManagementGridBalancing implements I_ChargingManagement {

    private GridConnection gc;
    private J_TimeParameters timeParameters;
    private double timeStep_h;
    private OL_ChargingAttitude activeChargingType = OL_ChargingAttitude.BALANCE_GRID;
    private boolean V2GActive = false;

    /**
     * Default constructor
     */
    public J_ChargingManagementGridBalancing( ) {
    }
    
    public J_ChargingManagementGridBalancing( GridConnection gc, J_TimeParameters timeParameters) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    	this.timeStep_h = timeParameters.getTimeStep_h();
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
    
    	for (I_ChargingRequest chargeRequest : chargePoint.getCurrentActiveChargingRequests()) {
	    	double chargeSetpoint_kW = 0;
			double maxChargePower = chargePoint.getMaxChargingCapacity_kW(chargeRequest);
			double remainingChargeDemand_kWh = chargeRequest.getRemainingChargeDemand_kWh(); // Can be negative if recharging is not needed for next trip!
	
			GridNode parentNode = gc.p_parentNodeElectric;
			double currentBalanceOnGridNodeWithoutEV_kW = parentNode.v_currentLoad_kW - parentNode.f_getCurrentChargingPowerBalancingThisGN_kW();
	    	double gridNodeLowPassedLoad_kW = parentNode.v_lowPassedLoadFilter_kW;
	    	
			double nextTripStartTime_h = chargeRequest.getLeaveTime_h();
			double chargeTimeMargin_h = 0.5; // Margin to be ready with charging before start of next trip
			double chargeDeadline_h =  nextTripStartTime_h - remainingChargeDemand_kWh / maxChargePower - chargeTimeMargin_h;
			double remainingFlexTime_h = chargeDeadline_h - t_h; // measure of flexiblity left in current charging session.
			double remainingTimeToCharge = nextTripStartTime_h - t_h - chargeTimeMargin_h;
			
			if ( t_h >= chargeDeadline_h && remainingChargeDemand_kWh > 0) { // Must-charge time at max charging power
				chargeSetpoint_kW = min(maxChargePower, remainingChargeDemand_kWh / this.timeStep_h);	
			} else {
				double flexGain_r_manual = 0.8;
				double flexGain_r = 1/max(1, (double)parentNode.f_getCurrentNumberOfChargeRequestsBalancingThisGN()) * flexGain_r_manual; // how strongly to 'follow' currentBalanceBeforeEV_kW -> influenced by the amount of charging chargers at this momment
				chargeSetpoint_kW = max(0, chargeRequest.getRemainingAverageChargingDemand_kW(t_h) + (gridNodeLowPassedLoad_kW - currentBalanceOnGridNodeWithoutEV_kW) * (min(1,flexGain_r)));			    				
				if ( this.V2GActive && chargePoint.getV2GCapable() && chargeRequest.getV2GCapable() && remainingFlexTime_h > 1 && chargeSetpoint_kW == 0 ) { // Surpluss flexibility
					chargeSetpoint_kW = min(0, chargeRequest.getRemainingAverageChargingDemand_kW(t_h) + (gridNodeLowPassedLoad_kW - currentBalanceOnGridNodeWithoutEV_kW) * (min(1,flexGain_r)));
				}    
			}

	    	//Send the chargepower setpoint to the chargepoint
	       	chargePoint.charge(chargeRequest, chargeSetpoint_kW, timeVariables, gc);
    	}
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
		
	}
	public void restoreStates() {

	}
	
	
    @Override
	public String toString() {
		return "Active charging type: " + this.activeChargingType;

	}
} 
