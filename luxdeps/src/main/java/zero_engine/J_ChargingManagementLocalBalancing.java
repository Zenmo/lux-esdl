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
 * J_ChargingManagementLocalBalancing
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
public class J_ChargingManagementLocalBalancing implements I_ChargingManagement {

    private GridConnection gc;
    private J_TimeParameters timeParameters;
    private OL_ChargingAttitude activeChargingType = OL_ChargingAttitude.BALANCE_LOCAL;
    private double filterTimeScale_h = 5*24;
    private double filterDiffGain_r;
    private double initialValueGCdemandLowPassed_kW = 0.5;
    private double GCdemandLowPassed_kW = this.initialValueGCdemandLowPassed_kW;
    
    private boolean V2GActive = false;
    
    //Stored
    private double storedGCdemandLowPassed_kW;
    
    /**
     * Default constructor
     */
    public J_ChargingManagementLocalBalancing( ) {
    }
    
    public J_ChargingManagementLocalBalancing( GridConnection gc, J_TimeParameters timeParameters) {
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
    	
       	for (I_ChargingRequest chargingRequest : chargePoint.getCurrentActiveChargingRequests()) {
			double chargeNeedForFullBattery_kWh = chargingRequest.getStorageCapacity_kWh() - chargingRequest.getCurrentSOC_kWh(); // try to charge completely.
			double remainingFlexTime_h = chargePoint.getChargeDeadline_h(chargingRequest) - t_h; // measure of flexiblity left in current charging session. (this relates to minimum SoC need for next trip, not to a full battery!)
			double avgPowerDemandTillTrip_kW = chargeNeedForFullBattery_kWh / (chargingRequest.getLeaveTime_h() - t_h); // Avg power needed to achieve full battery
			double chargeSetpoint_kW = 0;			
			if ( remainingFlexTime_h <= 0.25 ) { // Must-charge time at max charging power
				chargeSetpoint_kW = chargePoint.getMaxChargingCapacity_kW(chargingRequest);
			} else {
				double flexGain_r_manual = 0.2; // 'Optimal' value depends on the relative magnitude of the peaks/dips in the GCdemand-before-EV compared to the total charging volume. Too high flexgain could quickly 'drain' flexiblity, too small would mean that peaks/valleys are not filled as much as possible.
				int currentNbActiveChargingSessions = chargePoint.getCurrentNumberOfChargeRequests();
				double flexGain_r = flexGain_r_manual/(double)max(1,currentNbActiveChargingSessions); // how strongly to 'follow' currentBalanceBeforeEV_kW
				chargeSetpoint_kW = max(0, avgPowerDemandTillTrip_kW + (GCdemandLowPassed_kW - currentBalanceBeforeEV_kW) * (min(1/(double)currentNbActiveChargingSessions,remainingFlexTime_h*flexGain_r))); // limit 'local-balance-term' to 1/currentNbActiveChargingSessions to prevent overcompensation from multiple chargeSessions.		    				
    			if ( this.V2GActive && chargePoint.getV2GCapable() && chargingRequest.getV2GCapable() && remainingFlexTime_h > 1 && chargeSetpoint_kW == 0 ) { // Surpluss flexibility
					chargeSetpoint_kW = min(0, avgPowerDemandTillTrip_kW - (currentBalanceBeforeEV_kW - GCdemandLowPassed_kW) * (min(1/(double)currentNbActiveChargingSessions,remainingFlexTime_h*flexGain_r)));
    			}
			}
	    	//Send the chargepower setpoint to the chargepoint			
			chargePoint.charge(chargingRequest, chargeSetpoint_kW, timeVariables, gc);  		
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
	
    public Agent getParentAgent() {
    	return this.gc;
    }
	
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
