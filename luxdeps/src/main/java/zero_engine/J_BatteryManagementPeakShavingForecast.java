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

import zeroPackage.ZeroMath;
/**
 * J_BatteryManagementPeakShavingForecastGrid
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


public class J_BatteryManagementPeakShavingForecast implements I_BatteryManagement {

	private double[] batteryChargingSchedule_kW = new double[96];
    private GridConnection parentGC;
    private Agent target = parentGC;
    private OL_ResultScope targetType = OL_ResultScope.GRIDCONNECTION;
    List<GridConnection> c_targetGridConnections = new ArrayList<GridConnection>();
	Map<String, I_HeatingAsset> heatingAssets = new HashMap<>(); // Maps GridConnectionID to heatingAsset
    private J_TimeParameters timeParameters;
	
    //Stored
	private double[] storedBatteryChargingSchedule_kW;
	
	public J_BatteryManagementPeakShavingForecast() {
		
	}
	
    
	public J_BatteryManagementPeakShavingForecast( GridConnection parentGC, J_TimeParameters timeParameters ) {
    	this.parentGC = parentGC;
    	this.timeParameters = timeParameters;
    	if (parentGC instanceof GCGridBattery) {
    		this.setTarget(null);
    	} else {
    		this.setTarget(parentGC);
    	}
    	this.initializeAssets();
    }
	
	public void initializeAssets() {
		// This management is not able to forecast other flex assets. The only exception is a heating asset that follows a profile.
		heatingAssets.clear();
		for (GridConnection gc : c_targetGridConnections) {
			J_EAFlex heatingAsset = null;
			for (J_EAFlex flexAsset : gc.c_flexAssets) {
				if (flexAsset == parentGC.p_batteryAsset) {
					continue;
				}
				else if (flexAsset instanceof I_HeatingAsset && heatingAsset == null ) {
					heatingAsset = flexAsset;
					heatingAssets.put(gc.p_gridConnectionID, (I_HeatingAsset)heatingAsset);
				}
				else {
					throw new RuntimeException("J_BatteryManagementPeakShavingForecast does not support other flex assets, multiple flex assets found in GC: " + gc.p_gridConnectionID);
				}
			}
		}
	}
	
	public void manageBattery(J_TimeVariables timeVariables) {
    	if(parentGC.p_batteryAsset != null && parentGC.p_batteryAsset.getStorageCapacity_kWh() > 0) {
			if (this.target == null) {
		    	parentGC.f_updateFlexAssetFlows(parentGC.p_batteryAsset, 0.0, timeVariables);
	    		return;
	    	}
			int index = roundToInt(timeVariables.getTimeOfDay_h()/timeParameters.getTimeStep_h());
			if(index == 0){
				this.batteryChargingSchedule_kW = this.calculateBatteryChargingSchedule(timeVariables);
			}
			parentGC.f_updateFlexAssetFlows(parentGC.p_batteryAsset, this.batteryChargingSchedule_kW[index] / parentGC.p_batteryAsset.getCapacityElectric_kW(), timeVariables);
    	}
    }
	
	/*
	 * This method creates a 24 hour electricity load forecast based on all fixed profiles, including possible heating demand
	 */
	private double[] getNettoBalanceForecast_kW(J_TimeVariables timeVariables) {	
		
		double[] nettoBalanceTotal_kW = new double[roundToInt(24/timeParameters.getTimeStep_h())];
		double timeAtStartForecast_h = timeVariables.getT_h();
		int indexAtStartForecast = roundToInt(timeAtStartForecast_h/timeParameters.getTimeStep_h());
		
		List<J_EAProfile> electricityProfiles = new ArrayList<>();
		Map<String, List<J_EAProfile>> heatProfiles = new HashMap<>(); // Key = GC ID. Because the heating asset is relevant this is stored seperately for each GC

		for (GridConnection gc : c_targetGridConnections){		
			electricityProfiles.addAll(findAll(gc.c_profileAssets, j_ea -> j_ea.energyCarrier == OL_EnergyCarriers.ELECTRICITY));
			List<J_EAProfile> heatDemandProfiles = new ArrayList<>();
			heatDemandProfiles.addAll(findAll(gc.c_profileAssets, j_ea -> j_ea.energyCarrier == OL_EnergyCarriers.HEAT));
			heatProfiles.put(gc.p_gridConnectionID, heatDemandProfiles);
		}
		
		for (J_EAProfile profile : electricityProfiles) {
			double scalar = profile.getProfileScaling_fr()*profile.getProfileUnitScaler_fr();
			if (profile instanceof J_EAProduction) {
				scalar *= -1;
			}
			for (int i = 0; i < nettoBalanceTotal_kW.length; i++) {
				nettoBalanceTotal_kW[i] += scalar * profile.profilePointer.getValue((i + indexAtStartForecast)*timeParameters.getTimeStep_h());
			}
		}

		J_ProfilePointer ambientTemperatures = this.parentGC.energyModel.pp_ambientTemperature_degC;

		for (GridConnection gc : c_targetGridConnections) {
			I_HeatingAsset heatingAsset = this.heatingAssets.get(gc.p_gridConnectionID);
			if (heatingAsset != null && ((J_EA)heatingAsset).activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.ELECTRICITY)) {
				for (J_EAProfile profile : heatProfiles.get(gc.p_gridConnectionID)) {
					for (int i = 0; i < nettoBalanceTotal_kW.length; i++) {
						double t = timeAtStartForecast_h + i * timeParameters.getTimeStep_h();
						double efficiency = 1.0;
						if (heatingAsset instanceof J_EAConversionElectricHeater electricHeater) {
							efficiency = electricHeater.getEta_r();
						}
						else if (heatingAsset instanceof J_EAConversionHeatPump heatPump) {
							// TODO: Fix this for other ambientTempTypes
							efficiency = heatPump.calculateCOP(heatPump.getOutputTemperature_degC(), ambientTemperatures.getValue(t));
						}
						else {
							throw new RuntimeException("Unknown heating asset type in J_BatteryManagementPeakShavingForecast, GC with ID: " + gc.p_gridConnectionID + " has a heating asset of type: " + heatingAsset.getClass());
						}
						nettoBalanceTotal_kW[i] += profile.profilePointer.getValue((i + indexAtStartForecast)*timeParameters.getTimeStep_h()) / efficiency;
					}
				}
			}
		}		
		return nettoBalanceTotal_kW;
	}
	
	
	
	private double[] calculateBatteryChargingSchedule(J_TimeVariables timeVariables) {
			
		double[] nettoBalanceTotal_kW = getNettoBalanceForecast_kW(timeVariables);
		double amountOfHoursInADay = 24;
		
		//Initialize chargepoint array
		double[] newBatteryChargingSchedule_kW = new double[96];

		//Calculate the total export over the day that can be collected by the battery
		double totalExport_kWh = 0;
		for(int i = 0; i < nettoBalanceTotal_kW.length; i++){
			if(nettoBalanceTotal_kW[i] < 0){
				totalExport_kWh += min(parentGC.p_batteryAsset.getCapacityElectric_kW(), -nettoBalanceTotal_kW[i])*timeParameters.getTimeStep_h();
			}
		}
			
		//Flatten the morning net balance while charging
		double totalDailyImport_kWh = 0;
		for(int i = 0; i < nettoBalanceTotal_kW.length; i++){
			if(i< amountOfHoursInADay/timeParameters.getTimeStep_h()){
				totalDailyImport_kWh += max(0,nettoBalanceTotal_kW[i]*timeParameters.getTimeStep_h());
			}
		}

		double batteryEnergyNeeded_kWh = max(0,(parentGC.p_batteryAsset.getStorageCapacity_kWh()*(1-parentGC.p_batteryAsset.getCurrentStateOfCharge_fr()))/parentGC.p_batteryAsset.getChargingEfficiency_r()-totalExport_kWh);
		double averageDailyConsumption_kW = (totalDailyImport_kWh + batteryEnergyNeeded_kWh)/amountOfHoursInADay;

		//If 24 hours
		for(int i = 0; i < nettoBalanceTotal_kW.length; i++){
			newBatteryChargingSchedule_kW[i] += averageDailyConsumption_kW - nettoBalanceTotal_kW[i];
		}
		
		return newBatteryChargingSchedule_kW;
	}
	
	
	
	public void setTarget( Agent agent ) {
    	if ( agent == null) {
    		target = null;
    		this.targetType = null;
    	}
    	else if (agent == this.parentGC) {
    		target = agent;
    		this.targetType = OL_ResultScope.GRIDCONNECTION;
    		c_targetGridConnections = new ArrayList<GridConnection>();
    		c_targetGridConnections.add((GridConnection)target);
    	}
    	else if (agent instanceof GridNode) {
    		target = agent;
    		this.targetType = OL_ResultScope.GRIDNODE;
    		c_targetGridConnections = new ArrayList<GridConnection>(((GridNode)target).f_getAllLowerLVLConnectedGridConnections());
    	}
    	else if (agent instanceof EnergyCoop) {
    		target = agent;
    		this.targetType = OL_ResultScope.ENERGYCOOP;
    		c_targetGridConnections = new ArrayList<GridConnection>(((EnergyCoop)target).f_getAllChildMemberGridConnections());
    	}
    	else {
    		throw new RuntimeException("Not able to set " + agent + " as a target for J_BatteryPeakShaving");
    	}
    	this.initializeAssets();
    }

	
	
    //Get parentagent
    public Agent getParentAgent() {
    	return this.parentGC;
    }
    
    
	//Store and reset states
	public void storeStatesAndReset() {
		this.storedBatteryChargingSchedule_kW = batteryChargingSchedule_kW;
		this.batteryChargingSchedule_kW = new double[batteryChargingSchedule_kW.length];
	}
	public void restoreStates() {
		this.batteryChargingSchedule_kW = this.storedBatteryChargingSchedule_kW;
	}
	
	@Override
	public String toString() {
		return "parentGC: " + parentGC +
		", target: " + target +
		", c_targetGridConnections: " + c_targetGridConnections;
	}

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;

} 
