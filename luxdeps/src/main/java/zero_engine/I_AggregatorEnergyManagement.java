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


public interface I_AggregatorEnergyManagement extends I_StoreStatesAndReset
{
	// Must be implemented by the class (the class should contain these Lists and Map!!)
	public List<Class<? extends I_AggregatorAssetManagement>> getInternalAggregatorAssetManagements();//Inherent asset management that the EMS handles itself
	public List<Class<? extends I_AggregatorAssetManagement>> getSupportedExternalAggregatorAssetManagements(); // Supported submanagements that can support the EMS code
    public Map<Class<? extends I_AggregatorAssetManagement>, I_AggregatorAssetManagement> getActiveExternalAggregatorAssetManagements(); //Submanagements that actively support the EMS code

	//Manage EMS (Called by GC)
	public void operateAggregatorEnergyManagement(J_TimeVariables timeVariables);

	
	//Set sub managements
    default void setExternalAggregatorAssetManagement(I_AggregatorAssetManagement aggregatorAssetManagementInstance) {
    	
    	if(aggregatorAssetManagementInstance == null) {
    		throw new RuntimeException("Can't call setExternalAssetManagement() with input 'null'. -> If you are trying to remove something, use removeExternalAssetManagement() instead.");
    	}
    	
    	//Get the assetmanagement (interface) type (I_ChargingManagement, I_HeatingManagement, etc.)
    	Class<? extends I_AggregatorAssetManagement> aggregatorAssetManagementType = aggregatorAssetManagementInstance.getAggregatorAssetManagementInterfaceType();
    	
    	//Check if setAssetManagement is actually supported by this EnergyManagement class
    	if (getSupportedExternalAggregatorAssetManagements().stream().noneMatch(supported -> supported.isAssignableFrom(aggregatorAssetManagementType))) {
    	    throw new RuntimeException("Trying to set an unsupported sub asset management type for an EMS.");
    	}
    	getActiveExternalAggregatorAssetManagements().put(aggregatorAssetManagementType, aggregatorAssetManagementInstance);
    }
    
    default void removeExternalAggregatorAssetManagement(Class<? extends I_AggregatorAssetManagement> aggregatorAssetManagementType) {
    	if(aggregatorAssetManagementType.cast(getActiveExternalAggregatorAssetManagements().get(aggregatorAssetManagementType)) != null) {
    		getActiveExternalAggregatorAssetManagements().remove(aggregatorAssetManagementType);
    	}
    }

	//Get assetManagements (return null if not present)
    default <T extends I_AggregatorAssetManagement> T getExternalAggregatorAssetManagement(Class<T> aggregatorAssetManagementType) {//Inputs can be I_HeatingManagement, I_ChargingManagement, etc.
    	//Check if getAssetManagement is actually supported by this EnergyManagement class if not -> return null automatically.
    	if (getSupportedExternalAggregatorAssetManagements().stream().noneMatch(supported -> aggregatorAssetManagementType.isAssignableFrom(supported))) {
    	    return null;
    	}
        return aggregatorAssetManagementType.cast(getActiveExternalAggregatorAssetManagements().get(aggregatorAssetManagementType));
    }
    
    //Check of certain AssetManagement is present in the EMS (Inherent or through external management)
    default <T> boolean isAggregatorAssetManagementActive(Class<T> aggregatorAssetManagementType) {
    	return getInternalAggregatorAssetManagements().contains(aggregatorAssetManagementType) || getActiveExternalAggregatorAssetManagements().get(aggregatorAssetManagementType) != null;
    }

    //Check of certain Assets can potentially be managed by the EMS (Internal or through potentially externalmanagement)
    default <T> boolean isAggregatorAssetManagementSupported(Class<T> aggregatorAssetManagementType) {
    	return getInternalAggregatorAssetManagements().contains(aggregatorAssetManagementType) || getSupportedExternalAggregatorAssetManagements().contains(aggregatorAssetManagementType);
    }
} 
