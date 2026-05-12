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
 * J_AggregatorBatteryManagementCollectiveSelfConsumption_exportRate
 */	

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,    // 
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)

public class J_AggregatorBatteryManagementCollectiveSelfConsumption_exportRate implements I_AggregatorBatteryManagement {

	EnergyCoop energyCoop;
	
    /**
     * Default constructor
     */
	public J_AggregatorBatteryManagementCollectiveSelfConsumption_exportRate() {

	}
	
    public J_AggregatorBatteryManagementCollectiveSelfConsumption_exportRate( EnergyCoop energyCoop) {
    	this.energyCoop = energyCoop;
    }
    
    public void manageExternalBatterySetpoints(J_TimeVariables timeVariables) {
    	//Get all members that have a battery that is put on the external setpoint mode
    	List<GridConnection> memberedGCWithSetpointBatteries = findAll(energyCoop.f_getMemberGridConnectionsCollectionPointer(), GC -> GC.p_batteryAsset != null && GC.f_getBatteryManagement() != null && GC.f_getBatteryManagement() instanceof J_BatteryManagementExternalSetpoint);

		//Determine prefered charge setpoint of the battery, for maximum (collective) selfconsumption (equal to negative or positive balance)
		double collectiveChargeSetpoint_kW = 0;
		for(GridConnection GC : energyCoop.f_getMemberGridConnectionsCollectionPointer()) {
			double currentBatteryPowerElectric = 0;
			if(memberedGCWithSetpointBatteries.contains(GC)) {
				currentBatteryPowerElectric = GC.fm_currentAssetFlows_kW.get(OL_AssetFlowCategories.batteriesChargingPower_kW) - GC.fm_currentAssetFlows_kW.get(OL_AssetFlowCategories.batteriesDischargingPower_kW);			
			}
			
			collectiveChargeSetpoint_kW -= (GC.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY) - currentBatteryPowerElectric);
		}

		//Initialize iterable gc list
		List<GridConnection> memberedGCWithSetpointBatteries_withFreeCapacity = new ArrayList<GridConnection>();

		//Only add the gc that have the same direction as net coop charge flow to the gc that will use their battery
		for(GridConnection GC : memberedGCWithSetpointBatteries){
			
			double currentBatteryPowerElectric = GC.fm_currentAssetFlows_kW.get(OL_AssetFlowCategories.batteriesChargingPower_kW) - GC.fm_currentAssetFlows_kW.get(OL_AssetFlowCategories.batteriesDischargingPower_kW);
			
			double gc_balanceFlow = GC.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY) - currentBatteryPowerElectric;
			if((collectiveChargeSetpoint_kW < 0 && -gc_balanceFlow < 0) || (collectiveChargeSetpoint_kW > 0 && -gc_balanceFlow > 0)){
				memberedGCWithSetpointBatteries_withFreeCapacity.add(GC);
			}
		}

		//Initialize variables
		double remainingSumOfChargeSetpoints_kW = collectiveChargeSetpoint_kW;
		double gc_balanceFlowElectricity_kW;
		double gc_calculatedChargeSetpoint_kW;
		double gc_actualChargeSetpoint_kW;
		List<GridConnection> memberedGCWithSetpointBatteries_noCapacity = new ArrayList<GridConnection>();

		//Loop until no gc have battery capacity left or the setpoint is reached
		while( Math.abs(remainingSumOfChargeSetpoints_kW) > 0.0001 && memberedGCWithSetpointBatteries_withFreeCapacity.size() > 0){
			memberedGCWithSetpointBatteries_noCapacity.clear();
			double removedSumOfChargedSetpoints_kW = 0;
			double totalBalanceFlowRemainingGC_kW = 0;
			
			//Calculate the new combined balance flow, to use for distributing the remaining chargeSetpoint
			for(GridConnection GC : memberedGCWithSetpointBatteries_withFreeCapacity){
				double currentBatteryPowerElectric = GC.fm_currentAssetFlows_kW.get(OL_AssetFlowCategories.batteriesChargingPower_kW) - GC.fm_currentAssetFlows_kW.get(OL_AssetFlowCategories.batteriesDischargingPower_kW);
				totalBalanceFlowRemainingGC_kW += (GC.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY) - currentBatteryPowerElectric);
			}
			if (Math.abs(totalBalanceFlowRemainingGC_kW) < 0.0001) {
		   		traceln("Warning: totalBalanceFlowRemainingGC is zero, cant distribute any further, nr GC left: " + memberedGCWithSetpointBatteries_withFreeCapacity.size());
		    	break;
			}
			
			//Iterate over the gc that still have space left in their charge capacity or battery storage
			for(GridConnection GC : memberedGCWithSetpointBatteries_withFreeCapacity){
				J_BatteryManagementExternalSetpoint gridConnectionBatteryAlgorithm = (J_BatteryManagementExternalSetpoint)GC.f_getBatteryManagement();
				double currentBatteryPowerElectric = GC.fm_currentAssetFlows_kW.get(OL_AssetFlowCategories.batteriesChargingPower_kW) - GC.fm_currentAssetFlows_kW.get(OL_AssetFlowCategories.batteriesDischargingPower_kW);
				
				gc_balanceFlowElectricity_kW = GC.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY) - currentBatteryPowerElectric;
				gc_calculatedChargeSetpoint_kW = gridConnectionBatteryAlgorithm.getChargeSetpoint_kW() + remainingSumOfChargeSetpoints_kW * ( gc_balanceFlowElectricity_kW / totalBalanceFlowRemainingGC_kW);
				
				//First remove setpoint from previous iteration again
				removedSumOfChargedSetpoints_kW -= gridConnectionBatteryAlgorithm.getChargeSetpoint_kW();
				
				//Set and get new setpoint
				gc_actualChargeSetpoint_kW = gridConnectionBatteryAlgorithm.setChargeSetpoint_kW(gc_calculatedChargeSetpoint_kW);
				
				//Add new setpoint to removed setpiont total for this iteration again (netto this is increased by the additional amount compared to last iteration)
				removedSumOfChargedSetpoints_kW += gc_actualChargeSetpoint_kW;
				
				//If the actual setpoint that has been returned by the gc is not equal to the required setpoint, it means the gc cant charge/dis charge any further, so remove it from the pool 
				if(gc_calculatedChargeSetpoint_kW != gc_actualChargeSetpoint_kW){
					memberedGCWithSetpointBatteries_noCapacity.add(GC);
				}
			}
			//Update the remaining pool of GC and to be distributed setpoint_kW
			memberedGCWithSetpointBatteries_withFreeCapacity.removeAll(memberedGCWithSetpointBatteries_noCapacity);
			remainingSumOfChargeSetpoints_kW -= removedSumOfChargedSetpoints_kW;
		}
    }
    
    
    
    //Get parentagent
    public Agent getParentAgent() {
    	return this.energyCoop;
    }
    
    //Store and reset states
	public void storeStatesAndReset() {
		//Nothing to store/reset
	}
	public void restoreStates() {
		//Nothing to store/reset
	}
	
	
	@Override
	public String toString() {
		return super.toString();
	}

} 
