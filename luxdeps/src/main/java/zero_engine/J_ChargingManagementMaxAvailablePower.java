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
 * J_ChargingManagementMaxAvailablePower
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

public class J_ChargingManagementMaxAvailablePower implements I_ChargingManagement {
	private GridConnection gc;
    private J_TimeParameters timeParameters;
    private OL_ChargingAttitude activeChargingType = OL_ChargingAttitude.MAX_POWER;
    
    private boolean V2GActive = false;
    
    /**
     * Default constructor
     */
    public J_ChargingManagementMaxAvailablePower( ) {
    
    }
    
    public J_ChargingManagementMaxAvailablePower( GridConnection gc, J_TimeParameters timeParameters) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    }
    
    public OL_ChargingAttitude getCurrentChargingType() {
    	return activeChargingType;
    }
    
    public void manageCharging(J_ChargePoint chargePoint, J_TimeVariables timeVariables) {
    	double t_h = timeVariables.getT_h();

    	double remainingChargingPower_kW = gc.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW() - gc.fm_currentBalanceFlows_kW.get(ELECTRICITY);
    	if (gc.p_batteryAsset!=null) {
    		remainingChargingPower_kW += gc.p_batteryAsset.getCapacityAvailable_kW();
    	}
    	ArrayList<I_ChargingRequest> copiedChargingRequestList = new ArrayList<>(chargePoint.getCurrentActiveChargingRequests());
    	//this.chargePoint.getCurrentActiveChargingRequests().forEach(chargingRequest -> {if(ev.getAvailability() && ev.getCurrentStateOfCharge_fr()<1) { copiedVehicleList.add(ev);}}); // only vehicle that are available and not full
    	//int countDeletedItems = 0;

    	// Sort chargingRequests by time until charge deadline
    	copiedChargingRequestList.sort((chargingRequest1, chargingRequest2) -> Double.compare(chargePoint.getChargeDeadline_h(chargingRequest1), chargePoint.getChargeDeadline_h(chargingRequest2)));

    	for ( I_ChargingRequest chargingRequest : copiedChargingRequestList){
			double chargeNeedForNextTrip_kWh = max(0, chargingRequest.getEnergyNeedForNextTrip_kWh() - chargingRequest.getCurrentSOC_kWh());
			
			double chargingSetpoint_kW;
			if ( t_h >= chargePoint.getChargeDeadline_h(chargingRequest) && chargeNeedForNextTrip_kWh > 0) { // Must-charge time at max charging power
				chargingSetpoint_kW =  chargePoint.getMaxChargingCapacity_kW(chargingRequest);	
			}
			else {
				chargingSetpoint_kW = remainingChargingPower_kW;
			}
			
			double chargingPower_kW = min(max(0,chargingSetpoint_kW), chargePoint.getMaxChargingCapacity_kW(chargingRequest));
			
			//Send the chargepower setpoints to the chargepoint
	       	chargePoint.charge(chargingRequest, chargingPower_kW, timeVariables, gc); 
			remainingChargingPower_kW = max(0, remainingChargingPower_kW - chargingPower_kW); // Assumes the asset complies with the command!   			
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
