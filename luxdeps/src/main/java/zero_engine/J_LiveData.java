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

import java.util.EnumSet;
/**
 * J_LiveData
 */	
//import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class J_LiveData {
	
	public EnumSet<OL_EnergyCarriers> activeEnergyCarriers;
	public EnumSet<OL_EnergyCarriers> activeConsumptionEnergyCarriers;
	public EnumSet<OL_EnergyCarriers> activeProductionEnergyCarriers;
	
	public J_AssetsMetaData assetsMetaData;
	public J_ConnectionMetaData connectionMetaData;

	public J_DataSetMap dsm_liveDemand_kW = new J_DataSetMap(OL_EnergyCarriers.class); 
	public J_DataSetMap dsm_liveSupply_kW = new J_DataSetMap(OL_EnergyCarriers.class); 
	
	public DataSet data_totalDemand_kW = new DataSet(672); 
	public DataSet data_totalSupply_kW = new DataSet(672);
	public DataSet data_liveElectricityBalance_kW = new DataSet(672);
	public DataSet data_gridCapacityDemand_kW = new DataSet(672); 
	public DataSet data_gridCapacitySupply_kW = new DataSet(672);

	public J_DataSetMap<OL_AssetFlowCategories> dsm_liveAssetFlows_kW = new J_DataSetMap(OL_AssetFlowCategories.class); 
	public DataSet data_batteryStoredEnergyLiveWeek_MWh = new DataSet(672);
	public DataSet data_batterySOC_fr = new DataSet(672);
    /**
     * Default constructor
     */
	
	public J_LiveData() {
	
	}

    public void clearLiveDatasets() {
    	for(OL_EnergyCarriers EC : activeConsumptionEnergyCarriers){
    		if (dsm_liveDemand_kW.get(EC) != null ) {
    			dsm_liveDemand_kW.get(EC).reset();
    		}
    	}
    	
    	for(OL_EnergyCarriers EC : activeProductionEnergyCarriers){
    		if (dsm_liveSupply_kW.get(EC) != null ) {
    			dsm_liveSupply_kW.get(EC).reset();
    		}
    	}
    	
    	for (OL_AssetFlowCategories AC : assetsMetaData.activeAssetFlows) { // First add missing assetFlow datasets if there are any
    		if (dsm_liveAssetFlows_kW.get(AC) != null ) {
    			dsm_liveAssetFlows_kW.get(AC).reset();
    		}
    	}

    	data_totalDemand_kW.reset();
    	data_totalSupply_kW.reset();
    	data_liveElectricityBalance_kW.reset();
    	data_gridCapacityDemand_kW.reset();
    	data_gridCapacitySupply_kW.reset();


    	data_batteryStoredEnergyLiveWeek_MWh.reset();
    	data_batterySOC_fr.reset();
    	
    }
    
    public void resetLiveDatasets(J_TimeParameters timeParameters) {
    	for(OL_EnergyCarriers EC : activeConsumptionEnergyCarriers){
    		DataSet dsDemand = new DataSet( (int)(168 / timeParameters.getTimeStep_h()) );
    		for (double t = timeParameters.getRunStartTime_h(); t < timeParameters.getRunEndTime_h(); t += timeParameters.getTimeStep_h()) {
    			dsDemand.add( t, 0);
    		}
    		dsm_liveDemand_kW.put( EC, dsDemand);
    	}
    	
    	for(OL_EnergyCarriers EC : activeProductionEnergyCarriers){
    		DataSet dsSupply = new DataSet( (int)(168 / timeParameters.getTimeStep_h()) );
    		for (double t = timeParameters.getRunStartTime_h(); t < timeParameters.getRunEndTime_h(); t += timeParameters.getTimeStep_h()) {
    			dsSupply.add( t, 0);
    		}
    		dsm_liveSupply_kW.put( EC, dsSupply);
    	}
    	
    	for (OL_AssetFlowCategories AC : assetsMetaData.activeAssetFlows) { // First add missing assetFlow datasets if there are any
			if (!dsm_liveAssetFlows_kW.keySet().contains(AC)) {
				DataSet dsAsset = new DataSet((int)(168 / timeParameters.getTimeStep_h()));
				dsm_liveAssetFlows_kW.put(AC, dsAsset);
			}
    	}
    	
		for (double t = timeParameters.getRunStartTime_h(); t < timeParameters.getRunEndTime_h(); t += timeParameters.getTimeStep_h()) {
			
			for (OL_AssetFlowCategories AC : assetsMetaData.activeAssetFlows) {
				dsm_liveAssetFlows_kW.get(AC).add(t, 0);
			}

	    	data_totalDemand_kW.add( t, 0); 
	    	data_totalSupply_kW.add( t, 0);
	    	data_liveElectricityBalance_kW.add( t, 0);
	    	data_gridCapacityDemand_kW.add( t, 0); 
	    	data_gridCapacitySupply_kW.add( t, 0);


	    	data_batteryStoredEnergyLiveWeek_MWh.add( t, 0);
	    	data_batterySOC_fr.add( t, 0);	
		}
    }
    
    public void addTimeStep(double AnyLogicTime_h, J_FlowsMap fm_currentBalanceFlows_kW, J_FlowsMap fm_currentConsumptionFlows_kW, J_FlowsMap fm_currentProductionFlows_kW, J_ValueMap<OL_AssetFlowCategories> assetFlowsMap, double v_currentPrimaryEnergyProduction_kW, double v_currentFinalEnergyConsumption_kW, double v_currentPrimaryEnergyProductionHeatpumps_kW, double v_currentEnergyCurtailed_kW, double currentStoredEnergyBatteries_MWh) {

    	//Energy carrier flows
    	for (OL_EnergyCarriers EC : activeConsumptionEnergyCarriers) {
    		this.dsm_liveDemand_kW.get(EC).add( AnyLogicTime_h, roundToDecimal(fm_currentConsumptionFlows_kW.get(EC), 3) );
    	}
    	for (OL_EnergyCarriers EC : activeProductionEnergyCarriers) {
    		this.dsm_liveSupply_kW.get(EC).add( AnyLogicTime_h, roundToDecimal(fm_currentProductionFlows_kW.get(EC), 3) );
    	}

    	//Electricity balance
    	this.data_liveElectricityBalance_kW.add(AnyLogicTime_h, fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY));

    	//Total demand and supply
    	this.data_totalDemand_kW.add(AnyLogicTime_h, v_currentFinalEnergyConsumption_kW);
    	this.data_totalSupply_kW.add(AnyLogicTime_h, v_currentPrimaryEnergyProduction_kW);

    	//Live capacity datasets
    	this.data_gridCapacityDemand_kW.add(AnyLogicTime_h, connectionMetaData.getContractedDeliveryCapacity_kW());
    	this.data_gridCapacitySupply_kW.add(AnyLogicTime_h, -connectionMetaData.getContractedFeedinCapacity_kW());

    	//// Gather specific electricity flows from corresponding energy assets
		//for (OL_AssetFlowCategories AC : assetFlowsMap.keySet()) {
		for (OL_AssetFlowCategories AC : dsm_liveAssetFlows_kW.keySet()) {	
			//traceln("Assetsflows in dsm_liveAssetflows_kW: %s", dsm_liveAssetFlows_kW.keySet());
			/*if (!dsm_liveAssetFlows_kW.keySet().contains(AC)) {
				traceln("Trying to add assetflow: %s", AC);
				traceln("Parent GC: %s", ((GridConnection)parentAgent).p_gridConnectionID);
			}*/
			dsm_liveAssetFlows_kW.get(AC).add(AnyLogicTime_h, roundToDecimal(assetFlowsMap.get(AC),3));
		}
    	
		//Batteries    
    	this.data_batteryStoredEnergyLiveWeek_MWh.add(AnyLogicTime_h, currentStoredEnergyBatteries_MWh);
    	if(assetsMetaData.totalInstalledBatteryStorageCapacity_MWh > 0){
    		this.data_batterySOC_fr.add(AnyLogicTime_h, roundToDecimal(currentStoredEnergyBatteries_MWh/assetsMetaData.totalInstalledBatteryStorageCapacity_MWh, 3) );	
    	}
    	else{
    		this.data_batterySOC_fr.add(AnyLogicTime_h, 0);	
    	}	
	

    }
    
	public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Active Energy Carriers: ");
        sb.append(this.activeEnergyCarriers);
        sb.append(System.lineSeparator());
        sb.append("Consumption Carriers: ");
        sb.append(this.activeConsumptionEnergyCarriers);
        sb.append(System.lineSeparator());
        sb.append("Production Carriers: ");
        sb.append(this.activeProductionEnergyCarriers);
        sb.append(System.lineSeparator());
        sb.append("Asset Flow Caterogies: ");
        sb.append(this.assetsMetaData.activeAssetFlows);
        sb.append(System.lineSeparator());
        sb.append("Number of datapoints: ");
        sb.append(this.data_totalDemand_kW.size());
        
        return sb.toString();
	}
}
 
