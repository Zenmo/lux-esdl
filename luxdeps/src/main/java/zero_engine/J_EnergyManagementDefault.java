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
 * J_EnergyManagementDefault
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

public class J_EnergyManagementDefault implements I_EnergyManagement{
	
    private GridConnection GC;
    private J_TimeParameters timeParameters;
    
	List<Class<? extends I_AssetManagement>> internalAssetManagements = new ArrayList<>(); //Inherent asset management that the EMS handles itself
	List<Class<? extends I_AssetManagement>> supportedExternalAssetManagements = 
												new ArrayList<>(Arrays.asList(
													//J_HeatingManagementSimple.class, 
													I_HeatingManagement.class,
													I_ChargingManagement.class, 
													I_BatteryManagement.class,
													I_BackupGeneratorManagement.class,
													I_CurtailManagement.class
												));
	Map<Class<? extends I_AssetManagement>, I_AssetManagement> activeExternalAssetManagements = new HashMap();			
	
	boolean isChecked = false;
    
    /**
     * Empty constructor for serialization
     */
    public J_EnergyManagementDefault() {
    }
    
    /**
     * Default constructor
     */
    public J_EnergyManagementDefault(GridConnection GC, J_TimeParameters timeParameters) {
    	this.GC = GC;
    	this.timeParameters = timeParameters;
    }
    
    
    public void manageFlexAssets(J_TimeVariables timeVariables) {
    	if ( !isChecked ) {
    		this.checkConfiguration(GC.c_flexAssets);
    	}
    	
    	//1. Call Heating management
    	if(this.getExternalAssetManagement(I_HeatingManagement.class) != null) {
    		this.getExternalAssetManagement(I_HeatingManagement.class).manageHeating(timeVariables);
    	}
    	
    	//2. Call Charging management
    	if(this.getExternalAssetManagement(I_ChargingManagement.class) != null) {
    		this.getExternalAssetManagement(I_ChargingManagement.class).manageCharging(GC.f_getChargePoint(), timeVariables);
    	}
    	
    	//3. Call Battery management
    	if(this.getExternalAssetManagement(I_BatteryManagement.class) != null) {
    		this.getExternalAssetManagement(I_BatteryManagement.class).manageBattery(timeVariables);
    	}
    	
    	//4. Call BackupGenerator management
    	if(this.getExternalAssetManagement(I_BackupGeneratorManagement.class) != null) {
    		this.getExternalAssetManagement(I_BackupGeneratorManagement.class).manageBackupGenerator(timeVariables);
    	}
    	
    	//5. Call curtailment management
    	if(this.getExternalAssetManagement(I_CurtailManagement.class) != null) {
    		this.getExternalAssetManagement(I_CurtailManagement.class).manageCurtailment(timeVariables);
    	}
    }
    
    
	//Specific child management activation
	public void setV2GActive(boolean enableV2G) {
		if(this.getExternalAssetManagement(I_ChargingManagement.class) != null) {
			this.getExternalAssetManagement(I_ChargingManagement.class).setV2GActive(enableV2G);
		}
	}
    public boolean getV2GActive() {
		if(this.getExternalAssetManagement(I_ChargingManagement.class) != null) {
			return this.getExternalAssetManagement(I_ChargingManagement.class).getV2GActive();
		}
		else {
			return false;
		}
    }
	
	//Get child management types
	public OL_GridConnectionHeatingType getCurrentHeatingType() {
		if(this.getExternalAssetManagement(I_HeatingManagement.class) != null) {
			return this.getExternalAssetManagement(I_HeatingManagement.class).getCurrentHeatingType();
		}
		else {
			return OL_GridConnectionHeatingType.NONE;
		}
	}
	public OL_ChargingAttitude getCurrentChargingType() {
		if(this.getExternalAssetManagement(I_ChargingManagement.class) != null) {
			return this.getExternalAssetManagement(I_ChargingManagement.class).getCurrentChargingType();
		}
		else {
			return OL_ChargingAttitude.NONE;
		}
	}
	
	
	//Get inherent, supported and active Asset management classes
	public List<Class<? extends I_AssetManagement>> getInternalAssetManagements(){
		return this.internalAssetManagements;
	}
	public List<Class<? extends I_AssetManagement>> getSupportedExternalAssetManagements(){
		return this.supportedExternalAssetManagements;
	}
	public Map<Class<? extends I_AssetManagement>, I_AssetManagement> getActiveExternalAssetManagements(){
		return this.activeExternalAssetManagements;
	}    
	
	////Checks
	public void checkConfigurationEMSSpecific(List<J_EAFlex> flexAssetsGCList) {
		
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
    ////Store and reset states
	public void storeStatesAndReset() {
		activeExternalAssetManagements.values().forEach(subManagement -> subManagement.storeStatesAndReset());
	}
	public void restoreStates() {
		activeExternalAssetManagements.values().forEach(subManagement -> subManagement.restoreStates());
	}
	
	@Override
	public String toString() {
		String outputString = "J_EnergyManagementDefault: \n" + "Active internal managements: \n";
		for(Class<? extends I_AssetManagement> internalAssetManagement : this.internalAssetManagements) {
			outputString += "-" + internalAssetManagement + "\n";
		}
		outputString += "\n" + "Active external managements: \n";
		for(I_AssetManagement activeExternalAssetManagement : this.activeExternalAssetManagements.values()) {
			outputString += "-" + activeExternalAssetManagement.toString() + "\n";
		}		
		return outputString;
	}
} 
