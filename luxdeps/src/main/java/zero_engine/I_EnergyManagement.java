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

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.CLASS,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type"  // 👈 this will be the field name in your JSON
	)


public interface I_EnergyManagement extends I_StoreStatesAndReset
{

	// Must be implemented by the class (the class should contain these Lists and Map!!)
	public List<Class<? extends I_AssetManagement>> getInternalAssetManagements();//Inherent asset management that the EMS handles itself
	public List<Class<? extends I_AssetManagement>> getSupportedExternalAssetManagements(); // Supported submanagements that can support the EMS code
    public Map<Class<? extends I_AssetManagement>, I_AssetManagement> getActiveExternalAssetManagements(); //Submanagements that actively support the EMS code

	//Manage EMS (Called by GC)
	public void manageFlexAssets(J_TimeVariables timeVariables);

	
	//Set sub managements
    default void setExternalAssetManagement(I_AssetManagement assetManagementInstance) {
    	
    	if(assetManagementInstance == null) {
    		throw new RuntimeException("Can't call setExternalAssetManagement() with input 'null'. -> If you are trying to remove something, use removeExternalAssetManagement() instead.");
    	}
    	
    	//Get the assetmanagement (interface) type (I_ChargingManagement, I_HeatingManagement, etc.)
    	Class<? extends I_AssetManagement> assetManagementType = assetManagementInstance.getAssetManagementInterfaceType();
    	
    	//Check if setAssetManagement is actually supported by this EnergyManagement class
    	if (getSupportedExternalAssetManagements().stream().noneMatch(supported -> supported.isAssignableFrom(assetManagementType))) {
    	    throw new RuntimeException("Trying to set an unsupported sub asset management type for an EMS.");
    	}
    	getActiveExternalAssetManagements().put(assetManagementType, assetManagementInstance);
    	
    	//Recheck configuration
    	setChecked(false); 
    }
    
    default void removeExternalAssetManagement(Class<? extends I_AssetManagement> assetManagementType) {
    	if(assetManagementType.cast(getActiveExternalAssetManagements().get(assetManagementType)) != null) {
    		getActiveExternalAssetManagements().remove(assetManagementType);
        	
    		//Recheck configuration
        	setChecked(false); 
    	}
    }

	//Get assetManagements (return null if not present)
    default <T extends I_AssetManagement> T getExternalAssetManagement(Class<T> assetManagementType) {//Inputs can be I_HeatingManagement, I_ChargingManagement, etc.
    	//Check if getAssetManagement is actually supported by this EnergyManagement class if not -> return null automatically.
    	if (getSupportedExternalAssetManagements().stream().noneMatch(supported -> assetManagementType.isAssignableFrom(supported))) {
    	    return null;
    	}
        return assetManagementType.cast(getActiveExternalAssetManagements().get(assetManagementType));
    }
    
    //Check of certain AssetManagement is present in the EMS (Inherent or through external management)
    default <T> boolean isAssetManagementActive(Class<T> assetManagementType) {
    	return getInternalAssetManagements().contains(assetManagementType) || getActiveExternalAssetManagements().get(assetManagementType) != null;
    }

    //Check of certain Assets can potentially be managed by the EMS (Internal or through potentially externalmanagement)
    default <T> boolean isAssetManagementSupported(Class<T> assetManagementType) {
    	return getInternalAssetManagements().contains(assetManagementType) || getSupportedExternalAssetManagements().contains(assetManagementType);
    }
    
    
    
    ////Checks
    //Check configuration: Should be called whenever a management or asset has been removed/added/changed.
    default public void checkConfiguration(List<J_EAFlex> flexAssetsGCList) {
    	
    	//Check if all active flex assets are managed by the EMS
    	List<J_EAFlex> flexAssets = new ArrayList<>(flexAssetsGCList);

    	while (flexAssets.size()>0){ //While loop to prevent checking the same J_EAFlex type multiple times.
    		for(J_EAFlex asset : flexAssets) {
				if(asset instanceof J_EAEV || asset instanceof J_EAChargingSession){
					if(!isAssetManagementActive(I_ChargingManagement.class)) {
						throw new RuntimeException("An " + asset.getEAType() + " is found at GC that has an EMS that does not have active charging management.");
					}
					flexAssets.removeAll(findAll(flexAssets, vehicle -> vehicle instanceof J_EAEV || vehicle instanceof J_EAChargingSession));
					break;
				}
				else if(asset instanceof I_HeatingAsset || asset instanceof J_EAStorageHeat || asset instanceof J_EAConversionAirConditioner){
					if(!isAssetManagementActive(I_HeatingManagement.class)) {
						throw new RuntimeException("A heating asset is found at GC that has an EMS that does not have active heating management.");
					}
					if(getExternalAssetManagement(I_HeatingManagement.class) != null) {
						getExternalAssetManagement(I_HeatingManagement.class).initializeAssets();
					}
					flexAssets.removeAll(findAll(flexAssets, heatAsset -> heatAsset instanceof I_HeatingAsset || heatAsset instanceof J_EAStorageHeat || heatAsset instanceof J_EAConversionAirConditioner));
					break;
				}
				else if(asset instanceof J_EAStorageElectric){
					if(!isAssetManagementActive(I_BatteryManagement.class)) {
						throw new RuntimeException("A battery is found at a GC that has an EMS that does not have active battery management.");
					}
					flexAssets.removeAll(findAll(flexAssets, battery -> battery instanceof J_EAStorageElectric));
					break;
				}
				else if(asset instanceof J_EAConversionElectrolyser){
					if(!isAssetManagementActive(I_ElectrolyserManagement.class)) {
						throw new RuntimeException("An electrolyser is found at a GC that has an EMS that does not have active electrolyser management.");
					}
					flexAssets.removeAll(findAll(flexAssets, electrolyser -> electrolyser instanceof J_EAConversionElectrolyser));
					break;
				}
				else if(asset.getEAType() == OL_EnergyAssetType.DIESEL_GENERATOR || asset.getEAType() == OL_EnergyAssetType.METHANE_GENERATOR || asset.getEAType() == OL_EnergyAssetType.FUEL_CELL){
					if(!isAssetManagementActive(I_BackupGeneratorManagement.class)) {
						throw new RuntimeException("A backup generator is found at a GC that has an EMS that does not have active Backup Generator management.");
					}
					flexAssets.removeAll(findAll(flexAssets, generator -> generator.getEAType() == OL_EnergyAssetType.DIESEL_GENERATOR || generator.getEAType() == OL_EnergyAssetType.METHANE_GENERATOR || generator.getEAType() == OL_EnergyAssetType.FUEL_CELL));
					break;
				}
				else {
					throw new RuntimeException("Asset found that is not managed by I_AssetManagement, can not be checked.");
					//If you create a custom EMS, who does support other assets, override this method!
				}
			}
    	}
    	
    	//This EMS class specific Checks
    	checkConfigurationEMSSpecific(new ArrayList<>(flexAssetsGCList));
    	
    	//Set checked boolean to true
    	setChecked(true);
    }
    
    //Function used to add specific checks to EMS class
    public void checkConfigurationEMSSpecific(List<J_EAFlex> flexAssetsGCList); 
        
    //Boolean setting
    public void setChecked(boolean checked); //Set boolean to false so class doesn't check itself at start of next timestep.

    
    ////Specific Management calls
	//Specific management activation
	public void setV2GActive(boolean enableV2G);	
	public boolean getV2GActive();
	
	//Get specific types
	public OL_GridConnectionHeatingType getCurrentHeatingType();
	public OL_ChargingAttitude getCurrentChargingType();
} 
