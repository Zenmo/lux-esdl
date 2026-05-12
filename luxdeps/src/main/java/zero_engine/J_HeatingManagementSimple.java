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
 * J_HeatingManagementSimple
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

public class J_HeatingManagementSimple implements I_HeatingManagement {

    private boolean isInitialized = false;
    private GridConnection gc;
    private J_TimeParameters timeParameters;
	private List<OL_GridConnectionHeatingType> validHeatingTypes = Arrays.asList(
		OL_GridConnectionHeatingType.GAS_BURNER, 
		OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, 
		OL_GridConnectionHeatingType.HYDROGENBURNER,
		OL_GridConnectionHeatingType.DISTRICTHEAT,
		OL_GridConnectionHeatingType.LT_DISTRICTHEAT
	);
	private OL_GridConnectionHeatingType currentHeatingType;

	private J_EABuilding building;	
    private J_EAConversion heatingAsset;
    private J_EAConversionAirConditioner AC;
    private J_HeatingPreferences heatingPreferences;
	private J_EAStorageHeat hotWaterBuffer;
	private List<J_EAProduction> ptAssets;
    private boolean hasPT = false;
    
    // PI control gains for AC
    private double P_gain_kWpDegC = 1*1;
    private double I_gain_kWphDegC = 0.1*2;
    //private double I_state_hDegC = 0;
    private double I_state_AC_hDegC = 0;
    private boolean AC_active = false;
    
    //Stored parameters
    private double storedI_state_AC_hDegC;
    private boolean AC_active_stored = false;
    
	/**
     * Default constructor
     */
    public J_HeatingManagementSimple() {
    	
    }
    
    public J_HeatingManagementSimple( GridConnection gc, J_TimeParameters timeParameters, OL_GridConnectionHeatingType heatingType) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    	this.currentHeatingType = heatingType;
    }
      
    
    public void manageHeating(J_TimeVariables timeVariables) {
    	if ( !isInitialized ) {
    		this.initializeAssets();
    	}
    	
    	double hotWaterDemand_kW = gc.p_DHWAsset != null ? gc.p_DHWAsset.getLastFlows().get(OL_EnergyCarriers.HEAT) : 0;
    	
    	if(hasPT) {//Adjust the hot water and overall heat demand with the buffer and pt
    		double remainingHotWaterDemand_kW = J_HeatingFunctionLibrary.managePTAndHotWaterHeatBuffer(hotWaterBuffer, ptAssets, hotWaterDemand_kW, timeVariables, gc); // also updates fm_currentBalanceFlows_kW(heat)!
    	}
    	
    	double heatDemand_kW = gc.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.HEAT);
    	
    	double heatingAssetPower_kW = 0;

    	if(this.building != null) {    		
    		double buildingHeatingDemand_kW = 0;
	    	double buildingTemp_degC = building.getCurrentTemperature();
	    	double timeOfDay_h = timeVariables.getTimeOfDay_h();
	    	J_HeatingFunctionLibrary.setWindowVentilation_fr(this.building, heatingPreferences.getWindowOpenSetpoint_degc() ); 
	    	
	    	//Stookdagen approximation > boven 18 graden is niet verwarmen
	    	double avgTemp24h_degC = gc.energyModel.pf_ambientTemperature_degC.getForecast();
	    	if(avgTemp24h_degC > J_HeatingFunctionLibrary.heatingDaysAvgTempTreshold_degC) {
	    		buildingHeatingDemand_kW = max(0, heatingPreferences.getNightTimeSetPoint_degC() - buildingTemp_degC) * this.building.heatCapacity_JpK / 3.6e6 / timeParameters.getTimeStep_h();	
	    		if (this.AC != null && !AC_active && buildingTemp_degC > heatingPreferences.getMaxComfortTemperature_degC()  ) {
	    			//traceln("Enabling airconditioner!");
	    			AC_active = true;
	    		}
	    	}
	    	///On heating days
	    	else {
		    	if (timeOfDay_h < heatingPreferences.getStartOfDayTime_h() || timeOfDay_h >= heatingPreferences.getStartOfNightTime_h()) {
		    		
		    		if (buildingTemp_degC < heatingPreferences.getNightTimeSetPoint_degC()) {
		    			// Nighttime and building temperature too low
		    			buildingHeatingDemand_kW = (heatingPreferences.getNightTimeSetPoint_degC() - buildingTemp_degC) * this.building.heatCapacity_JpK / 3.6e6 / timeParameters.getTimeStep_h();
		    		}
		    		else {
		    			// Nighttime and building temperature acceptable
		    		}
		    	}
		    	else {
		    		if (buildingTemp_degC < heatingPreferences.getDayTimeSetPoint_degC()) {
		    			// Daytime and building temperature too low
		    			buildingHeatingDemand_kW = (heatingPreferences.getDayTimeSetPoint_degC() - buildingTemp_degC) * this.building.heatCapacity_JpK / 3.6e6 / timeParameters.getTimeStep_h();
		    		}
		    		else {
		    			// Daytime and building temperature acceptable
		    		}
		    	}
	    		if (AC_active) {
	    			//traceln("Disabling airconditioner!");
	    			AC_active = false;
	    			I_state_AC_hDegC = 0;
	    		}
	    	}
	    	heatingAssetPower_kW = min(heatingAsset.getOutputCapacity_kW(),buildingHeatingDemand_kW + heatDemand_kW); // minimum not strictly needed as asset will limit power by itself. Could be used later if we notice demand is higher than capacity of heating asset.			
			double heatIntoBuilding_kW = max(0, heatingAssetPower_kW - heatDemand_kW); // Will lead to energy(heat) imbalance when heatDemand_kW is larger than heating asset capacity.
	    	
	    	double coolingPower_kW = 0;
	    	
	    	if (AC_active) { 
	    		double deltaT_cooling_degC = (building.getCurrentTemperature() - heatingPreferences.getMaxComfortTemperature_degC());
	    		if (deltaT_cooling_degC < -1) {
	    			this.AC_active=false;
	    			//traceln("Building temp more than 1 degree below maxcomfort, turning off AC!");
	    		} else {
		        	I_state_AC_hDegC = max(0,I_state_AC_hDegC + deltaT_cooling_degC * timeParameters.getTimeStep_h()); // max(0,...) to prevent buildup of negative integrator during warm periods.
		        	coolingPower_kW = min(AC.getOutputCapacity_kW(),max(0,(deltaT_cooling_degC * P_gain_kWpDegC * 2 + I_state_AC_hDegC * I_gain_kWphDegC))); // max(0,...), so only cooling allowed, no heating.
		        	if (coolingPower_kW > 0) {
		        		//traceln("Airconditioner active! Cooling power: %s kW, building temp: %s, maxComfortTemp: %s", coolingPower_kW, buildingTemp_degC, heatingPreferences.getMaxComfortTemperature_degC());
		        		//traceln("Current building temperature: %s deg C", buildingTemp_degC);
		        		//traceln("MaxComfortTemp: %s", heatingPreferences.getMaxComfortTemperature_degC());
		        	}
	    		}
	        	gc.f_updateFlexAssetFlows(AC, coolingPower_kW / AC.getOutputCapacity_kW(), timeVariables);	        	
	    	} 
			
			//gc.f_updateFlexAssetFlows(building, heatIntoBuilding_kW / building.getCapacityHeat_kW(), timeVariables);
			gc.f_updateFlexAssetFlows(building, (heatIntoBuilding_kW-coolingPower_kW) / building.getCapacityHeat_kW(), timeVariables);

    	} else {    	    	
    		heatingAssetPower_kW = heatDemand_kW; // Will lead to energy(heat) imbalance when heatDemand_kW is larger than heating asset capacity.
    	}
    	gc.f_updateFlexAssetFlows(heatingAsset, heatingAssetPower_kW / heatingAsset.getOutputCapacity_kW(), timeVariables);

    }
    
    
    public void initializeAssets() {
    	if (!validHeatingTypes.contains(this.currentHeatingType)) {
    		throw new RuntimeException(this.getClass() + " does not support heating type: " + this.currentHeatingType);
    	}
    	List<J_EAProduction> ptAssets = findAll(gc.c_productionAssets, ea -> ea.energyAssetType == OL_EnergyAssetType.PHOTOTHERMAL);
    	if (ptAssets.size() > 0) {
        	if(gc.p_DHWAsset == null) {
        		throw new RuntimeException(this.getClass() + " requires a hot water demand to make sense to use this heating management with PT.");
        	}
        	this.ptAssets = ptAssets;
        	this.hasPT = true;
    	}
    	if (gc.p_heatBuffer != null) {
        	if(gc.p_DHWAsset == null || ptAssets.size() == 0) {
        		throw new RuntimeException(this.getClass() + " requires a hot water demand and PT to make sense to use this heating management with heatbuffer.");
        	}
    		this.hotWaterBuffer = gc.p_heatBuffer;
    	}
    	if(gc.p_BuildingThermalAsset != null) {
        	this.building = gc.p_BuildingThermalAsset;
        	if(this.heatingPreferences == null) {
        		heatingPreferences = new J_HeatingPreferences();
        	}
    	}
    	J_EAProfile heatProfile = findFirst(gc.c_profileAssets, x -> x.getEnergyCarrier() == OL_EnergyCarriers.HEAT);
    	if (heatProfile == null && this.building == null) {
    		throw new RuntimeException(this.getClass() + " requires a heat demand asset.");
    	}
    	if (gc.c_heatingAssets.size() == 0) {
    		throw new RuntimeException(this.getClass() + " requires at least one heating asset.");
    	}
    	if (gc.c_heatingAssets.size() > 1) {
    		throw new RuntimeException(this.getClass() + " does not support more than one heating asset.");
    	}
    	this.heatingAsset = gc.c_heatingAssets.get(0);
    	if (heatingAsset instanceof J_EAConversionGasBurner) {
    		this.currentHeatingType = OL_GridConnectionHeatingType.GAS_BURNER;
    	} else if (heatingAsset instanceof J_EAConversionHeatPump) {
    		if (gc.p_parentNodeHeatID != null) {
    			this.currentHeatingType = OL_GridConnectionHeatingType.LT_DISTRICTHEAT;
    		} else {
    			this.currentHeatingType = OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP;
    		}
    	} else if (heatingAsset instanceof J_EAConversionHeatDeliverySet) {
    		this.currentHeatingType = OL_GridConnectionHeatingType.DISTRICTHEAT;
    	} else if (heatingAsset instanceof J_EAConversionHydrogenBurner) {
    		this.currentHeatingType = OL_GridConnectionHeatingType.HYDROGENBURNER;
    	} else {
    		throw new RuntimeException(this.getClass() + " Unsupported heating asset!");    		
    	}
    	if ( gc instanceof GCHouse house) {
    		if (house.p_airco!=null) {
    			if (this.building == null) {
    				throw new RuntimeException("AirConditioner can only be used in combination with J_EABuilding thermal model, but no J_EABuilding present on gridconnection!");
    			}
    			this.AC = house.p_airco;
    		} else {
    			this.AC = null;
    			this.AC_active = false;
    			this.I_state_AC_hDegC = 0;
    		}
    	}

    	this.isInitialized = true;
    }
    
    
    public void notInitialized() {
    	this.isInitialized = false;
    }
    
    public List<OL_GridConnectionHeatingType> getValidHeatingTypes() {
    	return this.validHeatingTypes;
    }
    
    public OL_GridConnectionHeatingType getCurrentHeatingType() {
    	return this.currentHeatingType;
    }
    
    public void setHeatingPreferences(J_HeatingPreferences heatingPreferences) {
    	this.heatingPreferences = heatingPreferences;
    }
    
    public J_HeatingPreferences getHeatingPreferences() {
    	return this.heatingPreferences;
    }
    
    
    
    //Get parentagent
    public Agent getParentAgent() {
    	return this.gc;
    }
    
	public void storeStatesAndReset() {
	    this.storedI_state_AC_hDegC = this.I_state_AC_hDegC;
		this.I_state_AC_hDegC = 0;
		this.AC_active_stored = this.AC_active;
	}
	public void restoreStates() {
		this.I_state_AC_hDegC = this.storedI_state_AC_hDegC;
		this.AC_active = this.AC_active_stored;
	}
	
	@Override
	public String toString() {
		return "HeatingManagement Simple with heating type: " + getCurrentHeatingType().toString();
	}
}
 
