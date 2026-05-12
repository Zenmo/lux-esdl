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
 * J_HeatingManagementProfileHybridHeatPump
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

public class J_HeatingManagementProfileHybridHeatPump implements I_HeatingManagement {
	
	private boolean isInitialized = false;
	private GridConnection gc;
    private J_TimeParameters timeParameters;
	private List<OL_GridConnectionHeatingType> validHeatingTypes = Arrays.asList(
		OL_GridConnectionHeatingType.HYBRID_HEATPUMP
	);
	private OL_GridConnectionHeatingType currentHeatingType;
	private J_EAConversionHeatPump heatPumpAsset;
	private J_EAConversionGasBurner gasBurnerAsset;
	private J_HeatingPreferences heatingPreferences;
	/**
     * Default constructor
     */
	public J_HeatingManagementProfileHybridHeatPump() {
		
	}
	
    public J_HeatingManagementProfileHybridHeatPump( GridConnection gc, J_TimeParameters timeParameters, OL_GridConnectionHeatingType heatingType) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    	this.currentHeatingType = heatingType;
    }

    public void manageHeating(J_TimeVariables timeVariables) {
    	if ( !isInitialized ) {
    		this.initializeAssets();
    	}
    	double heatDemand_kW = gc.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.HEAT);
    	if (heatPumpAsset.getCOP() > 3.0 ) {
    		if (heatDemand_kW < heatPumpAsset.getOutputCapacity_kW()) {
    	    	gc.f_updateFlexAssetFlows(heatPumpAsset, heatDemand_kW / heatPumpAsset.getOutputCapacity_kW(), timeVariables);
    	    	gc.f_updateFlexAssetFlows(gasBurnerAsset, 0.0, timeVariables);
    			return;
    		}
    		else if (heatDemand_kW < heatPumpAsset.getOutputCapacity_kW() + gasBurnerAsset.getOutputCapacity_kW() ) {
    	    	gc.f_updateFlexAssetFlows(heatPumpAsset, 1.0, timeVariables);
    	    	gc.f_updateFlexAssetFlows(gasBurnerAsset, (heatDemand_kW - heatPumpAsset.getOutputCapacity_kW()) / gasBurnerAsset.getOutputCapacity_kW(), timeVariables);
    			return;
    		}
    		else {
    			throw new RuntimeException(this.getClass() + " in GC: " + gc.p_gridConnectionID + " does not have enough combined capacity to fulfil the heat demand");
    		}
    	}
    	else {
    		if (heatDemand_kW < gasBurnerAsset.getOutputCapacity_kW()) {
    	    	gc.f_updateFlexAssetFlows(gasBurnerAsset, heatDemand_kW / gasBurnerAsset.getOutputCapacity_kW(), timeVariables);
    	    	gc.f_updateFlexAssetFlows(heatPumpAsset, 0.0, timeVariables);
    			return;
    		}
    		else if (heatDemand_kW < gasBurnerAsset.getOutputCapacity_kW() + heatPumpAsset.getOutputCapacity_kW() ) {
    	    	gc.f_updateFlexAssetFlows(gasBurnerAsset, 1.0, timeVariables);
    	    	gc.f_updateFlexAssetFlows(heatPumpAsset, (heatDemand_kW - gasBurnerAsset.getOutputCapacity_kW()) / heatPumpAsset.getOutputCapacity_kW(), timeVariables);
    			return;
    		}
    		else {
    			throw new RuntimeException(this.getClass() + " in GC: " + gc.p_gridConnectionID + " does not have enough combined capacity to fulfil the heat demand");
    		}
    	}
    }
    
    public void initializeAssets() {
    	if (!validHeatingTypes.contains(this.currentHeatingType)) {
    		throw new RuntimeException(this.getClass() + " does not support heating type: " + this.currentHeatingType);
    	}
    	if (gc.p_heatBuffer != null) {
    		throw new RuntimeException(this.getClass() + " does not support heat buffers.");
    	}
    	if (gc.p_BuildingThermalAsset != null) {
    		throw new RuntimeException(this.getClass() + " does not support a building asset.");
    	}
    	J_EAProfile heatProfile = findFirst(gc.c_profileAssets, x -> x.getEnergyCarrier() == OL_EnergyCarriers.HEAT && x.getEAType() != OL_EnergyAssetType.HOT_WATER_CONSUMPTION);
    	if (heatProfile == null) {
    		throw new RuntimeException(this.getClass() + " requires a HEAT_DEMAND profile.");
    	}
    	if (gc.c_heatingAssets.size() != 2) {
    		throw new RuntimeException(this.getClass() + " requires exactly two heating assets.");
    	}
    	// TODO: Add a check if the power of the asset is sufficient?
    	if (gc.c_heatingAssets.get(0) instanceof J_EAConversionGasBurner) {
    		this.gasBurnerAsset = (J_EAConversionGasBurner)gc.c_heatingAssets.get(0);
    	}
    	else if (gc.c_heatingAssets.get(1) instanceof J_EAConversionGasBurner) {
    		this.gasBurnerAsset = (J_EAConversionGasBurner)gc.c_heatingAssets.get(1);    		
    	}
    	else {
    		throw new RuntimeException(this.getClass() + " requires a Gas Burner");
    	}
    	if (gc.c_heatingAssets.get(0) instanceof J_EAConversionHeatPump) {
    		this.heatPumpAsset = (J_EAConversionHeatPump)gc.c_heatingAssets.get(0);
    	}
    	else if (gc.c_heatingAssets.get(1) instanceof J_EAConversionHeatPump) {
    		this.heatPumpAsset = (J_EAConversionHeatPump)gc.c_heatingAssets.get(1);    		
    	}
    	else {
    		throw new RuntimeException(this.getClass() + " requires a Heat Pump");
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
