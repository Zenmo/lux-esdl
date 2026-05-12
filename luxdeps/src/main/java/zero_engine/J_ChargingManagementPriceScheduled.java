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
 * J_ChargingManagementPriceScheduled
 */	
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import zeroPackage.Market;
import zeroPackage.FlexConsumptionAsset;
import zeroPackage.FlexAssetScheduler;
import zeroPackage.ZeroMath;


@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)
public class J_ChargingManagementPriceScheduled implements I_ChargingManagement {

    private GridConnection gc;
    private J_TimeParameters timeParameters;
    private OL_ChargingAttitude activeChargingType = OL_ChargingAttitude.PRICE;
    private double marketFeedback_eurpMWhpkW = 40; // PLACEHOLDER VALUE!
    private boolean V2GActive = false;
    
    //Stored
    // The "Simple Wrapper" defined inside
    private static class ActiveSession {
    	public final I_ChargingRequest chargingRequest;
        public double[] chargeProfile_kW;
        //public double startTime_h;
        public boolean isFinished = false;
        private int currentIdx = 0;
        //private double endTime_h;

        public ActiveSession(I_ChargingRequest chargingRequest, double[] chargeProfile_kW) {
            this.chargingRequest = chargingRequest;
            this.chargeProfile_kW = chargeProfile_kW;
            //this.startTime_h = startTime_h;            
        }
        
        public void charge(J_ChargePoint chargePoint, GridConnection gc, J_TimeVariables timeVariables) {
        	chargePoint.charge(this.chargingRequest, this.chargeProfile_kW[currentIdx], timeVariables, gc);	
        	currentIdx++;
        	if ( this.chargeProfile_kW.length == currentIdx) {
        		this.isFinished = true;
        	}
        }
        
        /*public void checkIfFinished() {
        	if (currentIdx < chargeProfile_kW.length) {
        		traceln("Warning!! Charge sesssion aborted too early! Missing %s timesteps!", chargeProfile_kW.length-currentIdx);
        	}
        }*/
    }
    
    private List<I_ChargingRequest> previousChargingRequests = new ArrayList<>();    
    private List<ActiveSession> activeSessions = new ArrayList<>();
    
    private List<I_ChargingRequest> previousChargingRequestsStored;    
    private List<ActiveSession> activeSessionsStored;
    
    /**
     * Default constructor
     */
    public J_ChargingManagementPriceScheduled( GridConnection gc, J_TimeParameters timeParameters) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    }
        
    public OL_ChargingAttitude getCurrentChargingType() {
    	return activeChargingType;
    }
    
    public double getMarketFeedback_eurpMWhpkW() {
    	return marketFeedback_eurpMWhpkW;
    }
    
    public void setMarketFeedback_eurpMWhpkW(double marketFeedback_eurpMWhpkW) {
    	this.marketFeedback_eurpMWhpkW = marketFeedback_eurpMWhpkW;
    }
    /**
     * This charging strategy creates a charging schedule that is quasi-cost-optimal, and allows the inclusion of a market feedback mechanism to reduce excessive charging spikes during minimum price intervals.
     * 
     */
    public void manageCharging(J_ChargePoint chargePoint, J_TimeVariables timeVariables) {
    	double t_h = timeVariables.getT_h();

    	//double currentElectricityPriceConsumption_eurpkWh = gc.energyModel.pp_dayAheadElectricityPricing_eurpMWh.getCurrentValue() * 0.001;
    	List<I_ChargingRequest> currentChargingRequests = chargePoint.getCurrentActiveChargingRequests();
       	for (I_ChargingRequest chargingRequest : currentChargingRequests) {
       		if (!previousChargingRequests.contains(chargingRequest)) { // Schedule new charging session!
       			//double chargeNeedForNextTrip_kWh = chargingRequest.getEnergyNeedForNextTrip_kWh() - chargingRequest.getCurrentSOC_kWh(); // Can be negative if recharging is not needed for next trip!
       			double chargeNeedForNextTrip_kWh = chargingRequest.getStorageCapacity_kWh() - chargingRequest.getCurrentSOC_kWh(); // Can be negative if recharging is not needed for next trip!
       			double maxChargePower_kW = chargePoint.getMaxChargingCapacity_kW(chargingRequest);
       			// Get session duration
       			double duration_h = chargingRequest.getLeaveTime_h() - t_h;
       			int length = (int)ceil(duration_h/timeParameters.getTimeStep_h()); // 
       			if (duration_h <= 0) {
       				traceln("ChargingRequest starting after endtime! Duration_h: %s", duration_h);
       				//throw new RuntimeException("ChargingRequest starting after endtime!");
       			}
       			// Get price curve for duration
       			double[] priceCurve = Arrays.copyOfRange(gc.energyModel.pp_dayAheadElectricityPricing_eurpMWh.getAllValues(), roundToInt(t_h/timeParameters.getTimeStep_h()), length+roundToInt(t_h/timeParameters.getTimeStep_h()));
       			Market market = new Market(priceCurve, marketFeedback_eurpMWhpkW, 0, 0, 0);
       			FlexConsumptionAsset asset = new FlexConsumptionAsset(maxChargePower_kW, 20, timeParameters.getTimeStep_h(), length*timeParameters.getTimeStep_h(), null);
       			/*if (chargeNeedForNextTrip_kWh > (maxChargePower_kW * timeParameters.getTimeStep_h()*(length) )) {
       				traceln("Warning! chargeNeedForNextTrip_kWh is too high for duration of charging session! Deficit: %s", chargeNeedForNextTrip_kWh - (maxChargePower_kW*(timeParameters.getTimeStep_h()*(length))));
       			} else {
       				traceln("Charging session long enough for chargeNeedForNextTrip_kWh");
       			}*/
       			chargeNeedForNextTrip_kWh=max(0,min(chargeNeedForNextTrip_kWh, maxChargePower_kW * timeParameters.getTimeStep_h()*length));
       			double[] chargeProfile_kW = new double[length];
       			if (chargeNeedForNextTrip_kWh>0) {
       				//traceln("Profile length: %s, price-curve length: %s", loadProfile_kW.length, priceCurve.length);
       				chargeProfile_kW = FlexAssetScheduler.scheduleWrapper(chargeProfile_kW, asset, chargeNeedForNextTrip_kWh, market, timeParameters.getTimeStep_h(), false);
       				
       				/*
       				double chargeVolumeCheck_kWh = ZeroMath.arraySum(chargeProfile_kW) * timeParameters.getTimeStep_h();
       				if (DoubleCompare.greaterThanZero(chargeNeedForNextTrip_kWh - chargeVolumeCheck_kWh)) {
       					traceln("Warning!! Scheduled charging energy is lower than chargeNeedForNextTrip_kWh! Deficit: %s", chargeNeedForNextTrip_kWh - chargeVolumeCheck_kWh);
       				}
       				for (int i = 0; i< length; i++) {
       					if (chargeProfile_kW[i] > maxChargePower_kW) {
       						double excessChargePower_kW = chargeProfile_kW[i] - maxChargePower_kW;
       						String err = String.format("Scheduled chargePower greater than maxChargePower_kW!! Excess: %s", excessChargePower_kW);
       						System.err.print(err); 
       					}
       				}*/
       			}
       			
       			previousChargingRequests.add(chargingRequest);
       			activeSessions.add(new ActiveSession(chargingRequest, chargeProfile_kW));       			
       		} 
       	}
   		// Execute charging of active sessions
		for (ActiveSession session : activeSessions) {			
			if (!currentChargingRequests.contains(session.chargingRequest)) { // || index == session.chargeProfile_kW.length) {
				//throw new RuntimeException("ChargingSession was prematurely aborted!");
				traceln("Warning! ChargingSession was prematurely aborted! Ignore this warning if it occurs after changing EV-sliders during live-sim.");
				//traceln("ChargingRequest: %s", session.chargingRequest);
				session.isFinished = true;
				previousChargingRequests.remove(session.chargingRequest);
			} else if (session.chargeProfile_kW.length>0) {
				session.charge(chargePoint, gc, timeVariables);
				if (session.isFinished) {
					previousChargingRequests.remove(session.chargingRequest);
				}
			}			
		}       					
		activeSessions.removeIf(session -> session.isFinished); // Must be outside of for-loop over this collection!
    }

    public void abortSession(I_ChargingRequest chargingRequest) {
    	previousChargingRequests.remove(chargingRequest);
    	ActiveSession session = findFirst(activeSessions, x -> x.chargingRequest == chargingRequest);
    	activeSessions.remove(session);
    }
    
	public void setV2GActive(boolean activateV2G) {
		throw new RuntimeException("ChargingManagementPriceScheduled does not support V2G charging!");
		/*
		this.V2GActive = activateV2G;
		this.gc.c_electricVehicles.forEach(ev -> ev.setV2GActive(activateV2G)); // NEEDED TO HAVE EV ASSET IN CORRECT assetFlowCatagory
		this.gc.c_chargingSessions.forEach(cs -> cs.setV2GActive(activateV2G)); // NEEDED TO HAVE CS ASSET IN CORRECT assetFlowCatagory
		*/
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
		previousChargingRequestsStored = previousChargingRequests;    
		activeSessionsStored = activeSessions;
	    
		previousChargingRequests = new ArrayList<>(); // Don't use clear()! It will also clear the 'stored' list; as it's not a copy, just a pointer to the same list!
	    activeSessions = new ArrayList<>();	 
	    //traceln("active session reset!");
	}
	public void restoreStates() {
		previousChargingRequests = previousChargingRequestsStored;
		activeSessions = activeSessionsStored;
	}
	
	
    @Override
 	public String toString() {
 		return "Active charging type: " + this.activeChargingType;

 	}
}
 
