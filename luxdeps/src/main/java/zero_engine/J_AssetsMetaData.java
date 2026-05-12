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
 * J_AssetsMetaData
 */	

import java.util.EnumSet;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class J_AssetsMetaData {
	
	public Agent parentAgent;

	public EnumSet<OL_AssetFlowCategories> activeAssetFlows = EnumSet.noneOf(OL_AssetFlowCategories.class);
		
	public Double totalInstalledPVPower_kW = 0.0;
	public Double totalInstalledWindPower_kW = 0.0;
	public Double totalInstalledBatteryStorageCapacity_MWh = 0.0;
	
	public Double initialPV_kW;
	public Double PVPotential_kW;
	public OL_PVOrientation PVOrientation; //Default orientation of PV system
	public Double windPotential_kW;
	
	public Map<OL_EnergyAssetType, Double> map_numberOfActiveAssets;
	public Map<OL_EnergyAssetType, Double> map_activeAssetsCapacity_kW;
	
	/**
     * Default constructor
     */
	public J_AssetsMetaData() {
		
	}
	
    public J_AssetsMetaData(Agent parentAgent) {
    	this.parentAgent = parentAgent;
    }
    
    public void updateActiveAssetData(ArrayList<GridConnection> gcList) {
    	activeAssetFlows.clear();
    	for(GridConnection GC : gcList){
    		if (GC.v_isActive) {
	    		for (J_EA ea : GC.c_energyAssets) {
	    			if (ea.assetFlowCategory!=null) {
	    				activeAssetFlows.add(ea.assetFlowCategory);
	    			}
	    		}
    		}
    	}
    	if (activeAssetFlows.contains(OL_AssetFlowCategories.batteriesChargingPower_kW)) { activeAssetFlows.add(OL_AssetFlowCategories.batteriesDischargingPower_kW); }
    	if (activeAssetFlows.contains(OL_AssetFlowCategories.V2GPower_kW)) { activeAssetFlows.add(OL_AssetFlowCategories.evChargingPower_kW); }
    	
	}

    public J_AssetsMetaData getClone() {
    	J_AssetsMetaData clone = new J_AssetsMetaData(this.parentAgent);
    	clone.activeAssetFlows = this.activeAssetFlows.clone();
  
    	clone.totalInstalledPVPower_kW = this.totalInstalledPVPower_kW.doubleValue();
    	clone.totalInstalledWindPower_kW = this.totalInstalledWindPower_kW.doubleValue();
    	clone.totalInstalledBatteryStorageCapacity_MWh = this.totalInstalledBatteryStorageCapacity_MWh.doubleValue();
    	clone.initialPV_kW = this.initialPV_kW != null ? this.initialPV_kW.doubleValue() : null;
    	clone.PVPotential_kW = this.PVPotential_kW != null ? this.PVPotential_kW.doubleValue() : null;
    	clone.PVOrientation = this.PVOrientation != null ? this.PVOrientation : null;
    	clone.windPotential_kW = this.windPotential_kW != null ? this.windPotential_kW.doubleValue() : null;
    	return clone;
    }
    
    public void saveActiveAssetAndCapacities(ArrayList<GridConnection> gcList) {
    	if(map_activeAssetsCapacity_kW != null || map_numberOfActiveAssets != null) {
    		throw new RuntimeException("Trying to save active assets, in assetMetaData, for the second time. Not allowed.");
    	}
    	map_numberOfActiveAssets = new HashMap<>();
    	map_activeAssetsCapacity_kW = new HashMap<>();
    	for(GridConnection GC : gcList){
    		if (GC.v_isActive) {
	    		for (J_EA ea : GC.c_energyAssets) {
	    			if (ea.getEAType()!=null) {
	    				double capacityEA_kW = map_activeAssetsCapacity_kW.get(ea.getEAType()) != null ? map_activeAssetsCapacity_kW.get(ea.getEAType()) : 0;
	    				double numberOfActiveEA = map_numberOfActiveAssets.get(ea.getEAType()) != null ? map_numberOfActiveAssets.get(ea.getEAType()) : 0;
	    				switch(ea.getEAType()) {
	    					case PHOTOVOLTAIC:
	    					case WINDMILL:
	    						capacityEA_kW += ((J_EAProduction)ea).getCapacityElectric_kW();
	    						break;
	    					case PHOTOTHERMAL:
	    						capacityEA_kW += ((J_EAProduction)ea).getCapacityHeat_kW();
	    						break;
	    					case GAS_BURNER:
	    					case HEAT_PUMP_AIR:
	    					case ELECTROLYSER:
	    						capacityEA_kW += ((J_EAConversion)ea).getInputCapacity_kW();
	    						break;
	    					case DIESEL_GENERATOR:
	    					case METHANE_GENERATOR:
	    						capacityEA_kW += ((J_EAConversion)ea).getOutputCapacity_kW();
	    						break;
	    					case STORAGE_ELECTRIC:
	    						capacityEA_kW += ((J_EAStorageElectric)ea).getCapacityElectric_kW();
	    						break;
	    					case ELECTRIC_VEHICLE:	
	    					case ELECTRIC_VAN:
	    					case ELECTRIC_TRUCK:
	    					//case PETROLEUM_FUEL_VEHICLE:	
	    					//case PETROLEUM_FUEL_VAN:
	    					//case PETROLEUM_FUEL_TRUCK:
	    					//case HYDROGEN_VEHICLE:	
	    					//case HYDROGEN_VAN:
	    					case HYDROGEN_TRUCK:
	    						numberOfActiveEA+= ((I_Vehicle)ea).getVehicleScaling_fr();
	    					default:
	    						//traceln("Unsupported EA found for asset capacity rapid run save!");
	    				}
	    				if(capacityEA_kW > 0){
	    					map_numberOfActiveAssets.put(ea.getEAType(), numberOfActiveEA + 1);
	    					map_activeAssetsCapacity_kW.put(ea.getEAType(), capacityEA_kW);
	    				}
	    				else if(numberOfActiveEA > 0) {
	    					map_activeAssetsCapacity_kW.put(ea.getEAType(), 0.0);
	    					map_numberOfActiveAssets.put(ea.getEAType(), numberOfActiveEA);
	    				}
	    			}
	    		}
    		}
    	}
    }
    public Set<OL_EnergyAssetType> getActiveAssets() {
    	return map_activeAssetsCapacity_kW.keySet();
    }
    
    public double getNumberOfActiveAssets(OL_EnergyAssetType assetType) {
    	return map_numberOfActiveAssets.get(assetType) != null ? map_numberOfActiveAssets.get(assetType) : 0;
    }
    public double getActiveAssetCapacity_kW(OL_EnergyAssetType assetType) {
    	return map_activeAssetsCapacity_kW.get(assetType) != null ? map_activeAssetsCapacity_kW.get(assetType) : 0;
    }
    
    public Map<OL_EnergyAssetType, Double> getNumberOfActiveAssetsMap() {
    	return new HashMap<>(map_numberOfActiveAssets);
    }
    public Map<OL_EnergyAssetType, Double> getActiveAssetsCapacityMap() {
    	return new HashMap<>(map_activeAssetsCapacity_kW);
    }
    
    public void setActiveAssetsInfoMaps(Map<OL_EnergyAssetType, Double> map_numberOfActiveAssets, Map<OL_EnergyAssetType, Double> map_activeAssetsCapacity_kW) {
    	if(this.map_activeAssetsCapacity_kW != null || this.map_numberOfActiveAssets != null) {
    		throw new RuntimeException("Trying to save active assets, in assetMetaData, for the second time. Not allowed.");
    	}
    	this.map_numberOfActiveAssets = map_numberOfActiveAssets;
    	this.map_activeAssetsCapacity_kW = map_activeAssetsCapacity_kW;
    }
    
	@Override
	public String toString() {
		return "totalInstalledPVPower_kW: " + totalInstalledPVPower_kW + 
				", totalInstalledWindPower_kW: " + totalInstalledWindPower_kW + 
	            ", totalInstalledBatteryStorageCapacity_MWh: " + totalInstalledBatteryStorageCapacity_MWh +
	            activeAssetFlows.toString();

	}
} 
