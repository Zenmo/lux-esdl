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
 * J_ElectrolyserManagementPowerSurplus
 */	
public class J_ElectrolyserManagementPowerSurplus implements I_ElectrolyserManagement {
	
	private GridConnection gc;
	private J_TimeParameters timeParameters;

	//Management specific
	private Agent target;
	private List<Double> forecastRES_kW = new ArrayList<>();
	private List<Double> forecastTargetPowerFlows_kW = new ArrayList<>();
	private DataSet lastWeekTargetPowerFlows_kW = new DataSet(672);
	
	private boolean b_forecast_lastWeekBased = false; // EMS functionality option: Determine forcast based on last weeks power.
	
	//Storing
	private List<Double> storedForecastRES_kW = new ArrayList<>();
	private List<Double> storedForecastTargetPowerFlows_kW = new ArrayList<>();
	private DataSet storedLastWeekTargetPowerFlows_kW; 
	
	/**
     * Empty constructor for serialization
     */
    public J_ElectrolyserManagementPowerSurplus() {
    }
    
	/**
     * Default constructor
     */
    public J_ElectrolyserManagementPowerSurplus(GridConnection gc, J_TimeParameters timeParameters) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    	this.setTarget(gc);
    }
	/**
     * Default constructor setting target
     */
    public J_ElectrolyserManagementPowerSurplus(GridConnection gc, Agent target, J_TimeParameters timeParameters) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    	setTarget(target);
    }
    
    public void manageElectrolyser(J_TimeVariables timeVariables) {
    	J_EAConversionElectrolyser electrolyserAsset = (J_EAConversionElectrolyser)findFirst(gc.c_conversionAssets, asset -> asset.getEAType() == OL_EnergyAssetType.ELECTROLYSER);

    	//Consider GC its own limits
    	double allowedDeliveryCapacity_kW = gc.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW();
    	double availableElectricPower_kW = max(0, allowedDeliveryCapacity_kW - gc.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY));
    	
    	//Define forecast time
    	double forecast_time_h = electrolyserAsset.getStartUpTimeStandby_h()+ 2*timeParameters.getTimeStep_h();

    	//Get current target values
    	J_FlowsMap flowsMap = electrolyserAsset.getLastFlows();
    	double previousElectrolyserConsumption_kW = max(0,flowsMap.get(OL_EnergyCarriers.ELECTRICITY));
    	double currentTargetPowerFlow_kW = getTargetCurrentPowerFlow_kW() - previousElectrolyserConsumption_kW;
    	lastWeekTargetPowerFlows_kW.add(timeVariables.getT_h(), currentTargetPowerFlow_kW);
    	
    	//Set the electrolyser state
    	if(electrolyserAsset.usesElectrolyserStates()) {
    		electrolyserStateControl_Surplus(electrolyserAsset, currentTargetPowerFlow_kW, forecast_time_h, timeParameters, timeVariables);
    	}
    	
    	//Determine electrolyser setpoint based on electrolyser state
    	double electrolyserSetpointElectric_kW = 0;
    	if(electrolyserAsset.usesElectrolyserStates()) {
	    	switch (electrolyserAsset.getState()){
	    		case SHUTDOWN:
	    		case STANDBY: 
	    			electrolyserSetpointElectric_kW = 0;
	    			break;
	    		case POWER_UP:
	    		case IDLE: 
	    			electrolyserSetpointElectric_kW = electrolyserAsset.getIdlePowerLoadRatio_r()*electrolyserAsset.getInputCapacity_kW();
	    			break;
	    		case FUNCTIONAL:
	    			electrolyserSetpointElectric_kW = electrolyserAsset.getInputCapacity_kW()*electrolyserAsset.getMininumProductionRatio_r();
	    			break;
	    		case FULLCAPACITY:
	    			electrolyserSetpointElectric_kW = min(electrolyserAsset.getInputCapacity_kW(), abs(-currentTargetPowerFlow_kW));
	    			break;
	    	}
    	}
    	else {
    		electrolyserSetpointElectric_kW = min(electrolyserAsset.getInputCapacity_kW(), abs(-currentTargetPowerFlow_kW));
    	}
    	
    	//Limit the electrolyser setpoint
    	electrolyserSetpointElectric_kW = min(availableElectricPower_kW, electrolyserSetpointElectric_kW);
    	
    	gc.f_updateFlexAssetFlows(electrolyserAsset, electrolyserSetpointElectric_kW/electrolyserAsset.getInputCapacity_kW(), timeVariables);
    }
    
    
    
    private void electrolyserStateControl_Surplus(J_EAConversionElectrolyser electrolyserAsset, double currentTargetPowerFlow_kW, double forecast_time_h, J_TimeParameters timeParameters, J_TimeVariables timeVariables){
    	double solar_forecast_kW;
    	double wind_forecast_kW;

    	//Initialize limitation values
    	if (forecastRES_kW.size() == 0){
    		for(int i = timeVariables.getTimeStepsElapsed(); i < timeVariables.getTimeStepsElapsed() + roundToInt(forecast_time_h/timeParameters.getTimeStep_h()); i++){
    			solar_forecast_kW = - gc.energyModel.pp_PVProduction35DegSouth_fr.getValue(timeVariables.getT_h() + i*timeParameters.getTimeStep_h()) * getTargetTotalInstalledPVPower_kW();
    			wind_forecast_kW = - gc.energyModel.pp_windProduction_fr.getValue(timeVariables.getT_h() + i*timeParameters.getTimeStep_h()) * getTargetTotalInstalledWindPower_kW();
    			forecastRES_kW.add(solar_forecast_kW + wind_forecast_kW);
    			forecastTargetPowerFlows_kW.add(currentTargetPowerFlow_kW - forecastRES_kW.get(0) + solar_forecast_kW + wind_forecast_kW);
    		}
    	}
    	else if(timeVariables.getTimeStepsElapsed() < (8760-forecast_time_h)/timeParameters.getTimeStep_h()){//Get future limitation values
    		
    		//Get current RES production
    		double currentRESProduction_kW = forecastRES_kW.get(0);
    		
    		//Update forecast array RES
    		forecastRES_kW.remove(0);
    		
    		solar_forecast_kW = - gc.energyModel.pp_PVProduction35DegSouth_fr.getValue(timeVariables.getT_h() + forecast_time_h) * getTargetTotalInstalledPVPower_kW();
    		wind_forecast_kW = - gc.energyModel.pp_windProduction_fr.getValue(timeVariables.getT_h() + forecast_time_h) * getTargetTotalInstalledWindPower_kW();
    		
    		forecastRES_kW.add(solar_forecast_kW + wind_forecast_kW); 
    		
    		//Update forecast array Target power flow
    		forecastTargetPowerFlows_kW.remove(0);
    		
    		//Get past target power flow and weather (last week) if last week forecast prediction is selected.
    		if (b_forecast_lastWeekBased && lastWeekTargetPowerFlows_kW.size() > 672 - roundToInt(forecast_time_h/timeParameters.getTimeStep_h())){ // Use last week to create the forecast	
    		
    			double lastWeekTargetPowerFlow_kW = lastWeekTargetPowerFlows_kW.getY(roundToInt(forecast_time_h/timeParameters.getTimeStep_h()));
    			double solar_lastWeek_kW = - gc.energyModel.pp_PVProduction35DegSouth_fr.getValue(timeVariables.getT_h() + forecast_time_h - 168) * getTargetTotalInstalledPVPower_kW();
    			double wind_lastWeek_kW = - gc.energyModel.pp_windProduction_fr.getValue(timeVariables.getT_h() + forecast_time_h - 168) * getTargetTotalInstalledWindPower_kW();
    				
    			forecastTargetPowerFlows_kW.add(lastWeekTargetPowerFlow_kW - solar_lastWeek_kW - wind_lastWeek_kW + solar_forecast_kW + wind_forecast_kW);
    		}
    		else{//use current power flow to predict forecast
    			forecastTargetPowerFlows_kW.add(currentTargetPowerFlow_kW - currentRESProduction_kW + forecastRES_kW.get(roundToInt(forecast_time_h/timeParameters.getTimeStep_h())-1));
    		}
    	}


    	//Set state based on current state and forecast.
    	switch (electrolyserAsset.getState()){

    		case SHUTDOWN: //Not ready to be powerd up and complete shut down (when broken, maintenance, etc.)
    			break;
    		case STANDBY: // Ready to be powered on, but no electricity consumption.
    			//Check if electrolyser will be able to be functional at least two time steps when powering up, if so: power_up = true.
    			if (forecastTargetPowerFlows_kW.get(roundToInt(forecast_time_h/timeParameters.getTimeStep_h())-2) < 0 && forecastTargetPowerFlows_kW.get(roundToInt(forecast_time_h/timeParameters.getTimeStep_h())-1) < 0){
    				electrolyserAsset.setElectrolyserState(OL_ElectrolyserState.POWER_UP);
    				electrolyserAsset.setRemainingPowerUpDuration_timesteps(roundToInt(electrolyserAsset.getStartUpTimeStandby_h()/timeParameters.getTimeStep_h()));
    			}
    			break;
    		case POWER_UP:
    			if(electrolyserAsset.getRemainingPowerUpDuration_timesteps() == 0){
    				electrolyserAsset.setElectrolyserState(OL_ElectrolyserState.IDLE);
    			}
    			break;
    		case IDLE: // Ready to start producing hydrogen, heated up, so consuming electricity, but not producing hydrogen yet.
    			if ( currentTargetPowerFlow_kW < 0 ){
    				electrolyserAsset.setElectrolyserState(OL_ElectrolyserState.FUNCTIONAL);
    			}
    			else{
    				boolean power_down = true;
    				for(int i = 0; i < forecastTargetPowerFlows_kW.size() - 2; i++){
    					if (forecastTargetPowerFlows_kW.get(i) < 0){
    						power_down = false;
    					}
    				}
    			
    				//Set mode based on power down or not.
    				if (power_down){
    					electrolyserAsset.setElectrolyserState(OL_ElectrolyserState.STANDBY);
    				}
    			}
    		break;
    		case FUNCTIONAL: // Producing hydrogen at minimum possible amount (to make sure system is working correctly, no leaks).
    			if ( currentTargetPowerFlow_kW < 0 ){
    				electrolyserAsset.setElectrolyserState(OL_ElectrolyserState.FULLCAPACITY);
    			}
    			else{
    				electrolyserAsset.setElectrolyserState(OL_ElectrolyserState.IDLE);
    			}
    			break;
    		case FULLCAPACITY:	// Producing hydrogen as much as possible.
    			if ( currentTargetPowerFlow_kW < 0 ){
    				// Stay at full capacity
    			}
    			else{ // Skip FUNCTIONAL — go directly to IDLE when surplus is gone
    				electrolyserAsset.setElectrolyserState(OL_ElectrolyserState.IDLE);
    			}
    			break;
    	}
    }
    
    public void setTarget(Agent target) {
    	this.target = target;
    }
    
    public double getTargetTotalInstalledPVPower_kW() {
    	if ( this.target == null) {
    		return 0;
    	}
    	else if (this.target == this.gc) {
    		return gc.v_liveAssetsMetaData.totalInstalledPVPower_kW;
    	}
    	else if (this.target instanceof GridNode targetGN) {
    		return targetGN.v_totalInstalledPVPower_kW;
    	}
    	else if (this.target instanceof EnergyCoop targetCoop) {
    		return targetCoop.v_liveAssetsMetaData.totalInstalledPVPower_kW;
    	}
    	else {
    		throw new RuntimeException("Target found for J_ElectrolyserManagementPowerSurplus that is not supported ( " + this.target + " )!");
    	}
    }
    public double getTargetTotalInstalledWindPower_kW() {
    	if ( this.target == null) {
    		return 0;
    	}
    	else if (this.target == this.gc) {
    		return gc.v_liveAssetsMetaData.totalInstalledWindPower_kW;
    	}
    	else if (this.target instanceof GridNode targetGN) {
    		return targetGN.v_totalInstalledWindPower_kW;
    	}
    	else if (this.target instanceof EnergyCoop targetCoop) {
    		return targetCoop.v_liveAssetsMetaData.totalInstalledWindPower_kW;
    	}
    	else {
    		throw new RuntimeException("Target found for J_ElectrolyserManagementPowerSurplus that is not supported ( " + this.target + " )!");
    	}
    }
    public double getTargetCurrentPowerFlow_kW() {
    	if ( this.target == null) {
    		return 0;
    	}
    	else if (this.target == this.gc) {
    		return gc.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY);
    	}
    	else if (this.target instanceof GridNode targetGN) {
    		return targetGN.v_currentLoad_kW;
    	}
    	else if (this.target instanceof EnergyCoop targetCoop) {
    		return targetCoop.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY);
    	}
    	else {
    		throw new RuntimeException("Target found for J_ElectrolyserManagementPowerSurplus that is not supported ( " + this.target + " )!");
    	}
    }
    
    ////Store and reset states
	public void storeStatesAndReset() {
		this.storedForecastRES_kW = this.forecastRES_kW;
		this.storedForecastTargetPowerFlows_kW = this.forecastTargetPowerFlows_kW;
		this.storedLastWeekTargetPowerFlows_kW = this.lastWeekTargetPowerFlows_kW;
		this.forecastRES_kW = new ArrayList<>();
		this.forecastTargetPowerFlows_kW = new ArrayList<>();
		this.lastWeekTargetPowerFlows_kW = new DataSet(672);
	}
	public void restoreStates() {
		this.forecastRES_kW = storedForecastRES_kW;
		this.forecastTargetPowerFlows_kW = this.storedForecastTargetPowerFlows_kW;
		this.lastWeekTargetPowerFlows_kW = this.storedLastWeekTargetPowerFlows_kW;
	}
	
	@Override
	public String toString() {
		return "J_ElectrolyserManagementPowerSurplus: \n" +
				"Target: " + this.target + "\n" +
				"b_forecast_lastWeekBased: " + this.b_forecast_lastWeekBased;
	}
} 
