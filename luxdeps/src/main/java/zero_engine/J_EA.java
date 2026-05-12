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
 * J_EA
 */
import java.util.EnumSet;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;


@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,    // ✅ only public fields are serialized
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.CLASS,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type"
	)

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
abstract public class J_EA implements Cloneable, I_StoreStatesAndReset {
	protected J_TimeParameters timeParameters;
	private I_AssetOwner owner; // This is private because it is not allowed for the children to access this.
	protected OL_EnergyAssetType energyAssetType;
	protected OL_AssetFlowCategories assetFlowCategory;
	protected String energyAssetName;
	protected J_FlowsMap flowsMap = new J_FlowsMap();
	protected J_FlowsMap lastFlowsMap = new J_FlowsMap();
	protected J_ValueMap assetFlowsMap = new J_ValueMap(OL_AssetFlowCategories.class);
	protected double lastEnergyUse_kW = 0.0;
	 
	protected EnumSet<OL_EnergyCarriers> activeProductionEnergyCarriers = EnumSet.noneOf(OL_EnergyCarriers.class); // To fill activeProductionEnergyCarriers in GridConnections and EnergyModel	
	protected EnumSet<OL_EnergyCarriers> activeConsumptionEnergyCarriers = EnumSet.noneOf(OL_EnergyCarriers.class); // To fill activeConsumptionEnergyCarriers in GridConnections and EnergyModel
		
	protected double energyUsed_kWh = 0.0;
	protected double energyUse_kW = 0.0;
	protected double energyUsedStored_kWh = 0.0;
	 
	protected boolean isRemoved = false;

    /**
     * Default constructor
     */
    public J_EA() {
    }
    
    protected void setOwner(I_AssetOwner owner) {
    	this.owner = owner;
    }
    
    protected boolean ownerIsActive() {
    	return this.owner.f_isActive();
    }
    
    public void registerEnergyAsset(J_TimeParameters timeParameters) {	
    	this.owner.f_connectToJ_EA(this, timeParameters);
    }
    
    public void reRegisterEnergyAsset(J_TimeParameters timeParameters) {
    	if (!this.isRemoved) {
    		throw new RuntimeException("Can not register energy asset that was not removed.");
    	}
    	else {
    		this.isRemoved = false;
    		this.registerEnergyAsset(timeParameters);
    	}
    }
    
    public void removeEnergyAsset() {
    	this.isRemoved = true;
    	this.owner.f_removeTheJ_EA(this);    	
    }
    
    public void clear() {
	    flowsMap.clear();
	    assetFlowsMap.clear();
    	energyUse_kW = 0;
    }

    public void storeStatesAndReset() {
    	// Each energy asset that has some states should overwrite this function!
    	energyUsedStored_kWh = energyUsed_kWh;
    	energyUsed_kWh = 0.0;
    	clear();    	
    }
    
    public void restoreStates() {
    	// Each energy asset that has some states should overwrite this function!
    	energyUsed_kWh = energyUsedStored_kWh;
    }
    
    public I_AssetOwner getOwner() {
    	return this.owner;
    }
    
    public double getEnergyUsed_kWh() {
    	return energyUsed_kWh;
    }
    
	public EnumSet<OL_EnergyCarriers> getActiveProductionEnergyCarriers() {
		return this.activeProductionEnergyCarriers;
	}
    
    public EnumSet<OL_EnergyCarriers> getActiveConsumptionEnergyCarriers() {
		return this.activeConsumptionEnergyCarriers;
	}
	
	public EnumSet<OL_EnergyCarriers> getActiveEnergyCarriers() {
		EnumSet<OL_EnergyCarriers> allActiveEnergyCarriers = EnumSet.copyOf(this.activeProductionEnergyCarriers);
		allActiveEnergyCarriers.addAll(this.activeConsumptionEnergyCarriers);
		return allActiveEnergyCarriers;
	}
	
    public J_FlowsMap getLastFlows() {
    	return this.lastFlowsMap;
    }
    
	 public OL_EnergyAssetType getEAType() {
		 return energyAssetType;
	 }
	 
	 public OL_AssetFlowCategories getAssetFlowCategory() {
		 return this.assetFlowCategory;
	 }

	 public void setEnergyAssetName(String name) {
		 this.energyAssetName = name;
	 }
	 
	 public void setEnergyAssetType(OL_EnergyAssetType assetType) {
		 this.energyAssetType = assetType;
	 }
	 
	 public void setAssetFlowCategory(OL_AssetFlowCategories assetFlowCat) {
		 this.assetFlowCategory = assetFlowCat;
	 }
}
 
