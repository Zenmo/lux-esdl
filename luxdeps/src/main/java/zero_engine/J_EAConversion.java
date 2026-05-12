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
 * J_EAConversion
 */
public class J_EAConversion extends zero_engine.J_EAFlex implements Serializable {
	protected OL_EnergyCarriers energyCarrierProduced;
	protected OL_EnergyCarriers energyCarrierConsumed;
	protected double eta_r;
	protected double inputCapacity_kW;
	protected double outputCapacity_kW;
	
	private OL_AssetFlowCategories inputAssetFlowCategory;
	private OL_AssetFlowCategories outputAssetFlowCategory;
	/**
     * Default constructor
     */
	public J_EAConversion() {
	}
    
	/**
     * Constructor initializing the fields, and setting assetFlowCategory (Assetflowcategory is filled with OUTPUT product of the conversion!)
     */
    public J_EAConversion(I_AssetOwner owner, OL_EnergyAssetType energyAssetType, double outputCapacity_kW, double efficiency_r, OL_EnergyCarriers energyCarrierProduced, OL_EnergyCarriers energyCarrierConsumed, OL_AssetFlowCategories inputAssetFlowCategory, OL_AssetFlowCategories outputAssetFlowCategory,  J_TimeParameters timeParameters) {   	
    	if(inputAssetFlowCategory != null && outputAssetFlowCategory != null) {
    		throw new RuntimeException("Trying to assign 2 assetflow categories to a J_EAConversion, this is not allowed (YET)!!. Only an Input OR an output Assetflow is supported.");
    	}
    	if(inputAssetFlowCategory != null) {
    		this.inputAssetFlowCategory = inputAssetFlowCategory;
    		this.assetFlowCategory = inputAssetFlowCategory;
    	}
    	else if(outputAssetFlowCategory != null) {
    		this.outputAssetFlowCategory = outputAssetFlowCategory;
    		this.assetFlowCategory = outputAssetFlowCategory;
    	}
    	construct(owner, energyAssetType, outputCapacity_kW, efficiency_r, energyCarrierProduced, energyCarrierConsumed, timeParameters);
    }

    /**
     * Constructor initializing the fields
     */
    public J_EAConversion(I_AssetOwner owner, OL_EnergyAssetType energyAssetType, double outputCapacity_kW, double efficiency_r, OL_EnergyCarriers energyCarrierProduced, OL_EnergyCarriers energyCarrierConsumed, J_TimeParameters timeParameters) {
    	construct(owner, energyAssetType, outputCapacity_kW, efficiency_r, energyCarrierProduced, energyCarrierConsumed, timeParameters);
	}
	    private void construct(I_AssetOwner owner, OL_EnergyAssetType energyAssetType, double outputCapacity_kW, double efficiency_r, OL_EnergyCarriers energyCarrierProduced, OL_EnergyCarriers energyCarrierConsumed, J_TimeParameters timeParameters) {
		    this.setOwner(owner);
		    this.timeParameters = timeParameters;	    
		    this.energyAssetType = energyAssetType;
		    this.outputCapacity_kW = outputCapacity_kW;
		    this.eta_r = efficiency_r;
		    this.inputCapacity_kW = this.outputCapacity_kW / this.eta_r;
		    this.energyCarrierProduced = energyCarrierProduced;
		    this.energyCarrierConsumed = energyCarrierConsumed;
		    this.activeProductionEnergyCarriers.add(this.energyCarrierProduced);		
			this.activeConsumptionEnergyCarriers.add(this.energyCarrierConsumed);
			registerEnergyAsset(timeParameters);
	    }

    @Override
    public J_FlowPacket f_updateAllFlows(double powerFraction_fr, J_TimeVariables timeVariables) {
    	if(DoubleCompare.lessThanZero(powerFraction_fr)) {
			throw new RuntimeException("Impossible to operate conversion asset with negative powerfraction.");    		
    	}
    	else if ( DoubleCompare.equalsZero(powerFraction_fr) ) {
    		this.lastFlowsMap.clear();
    		this.lastEnergyUse_kW = 0;
         	J_FlowsMap flowsMapCopy = new J_FlowsMap();
         	J_ValueMap assetFlowsMapCopy = new J_ValueMap(OL_AssetFlowCategories.class);
         	J_FlowPacket flowPacket = new J_FlowPacket(flowsMapCopy.cloneMap(this.flowsMap), this.energyUse_kW, assetFlowsMapCopy.cloneMap(this.assetFlowsMap));
    		return flowPacket;
    	}
    	else {
    		return super.f_updateAllFlows( powerFraction_fr, timeVariables );
    	}
    }
    
	@Override
	public void operate(double powerFraction_fr, J_TimeVariables timeVariables) {
		this.energyUse_kW = powerFraction_fr * this.inputCapacity_kW * (1 - this.eta_r);
		this.energyUsed_kWh += this.energyUse_kW * this.timeParameters.getTimeStep_h();
    	this.flowsMap.put(this.energyCarrierConsumed, powerFraction_fr * this.inputCapacity_kW);
    	this.flowsMap.addFlow(this.energyCarrierProduced, -powerFraction_fr * this.outputCapacity_kW); // We don't put here, in case the energy carrier is the same
    	if (this.assetFlowCategory != null) {
    		if(this.inputAssetFlowCategory != null) {
    			this.assetFlowsMap.put(this.assetFlowCategory, powerFraction_fr * this.inputCapacity_kW);    			
    		}
    		else if(this.outputAssetFlowCategory != null) {
    			this.assetFlowsMap.put(this.assetFlowCategory, powerFraction_fr * this.outputCapacity_kW);
    		}
    	}
	}
	
	public J_FlowsMap get_heatFromEnergyCarrier_kW() {
		J_FlowsMap flowMap = new J_FlowsMap();
		flowMap.put(this.energyCarrierConsumed, -this.getLastFlows().get(OL_EnergyCarriers.HEAT));
		return flowMap;
	}
	
	public J_FlowsMap get_consumptionForHeating_kW() {
		J_FlowsMap flowMap = new J_FlowsMap();
		if (this.activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HEAT)) { // small check to catch conversion assets like electrolysers.
			flowMap.put(this.energyCarrierConsumed, this.getLastFlows().get(this.energyCarrierConsumed));
		}
		return flowMap;		
	}
	
	public void setInputCapacity_kW ( double inputCapacity_kW ) {
		this.inputCapacity_kW = inputCapacity_kW;
		this.outputCapacity_kW = this.inputCapacity_kW * this.eta_r;
	}
	
	public void setOutputCapacity_kW ( double outputCapacity_kW ) {
		this.outputCapacity_kW = outputCapacity_kW;
		this.inputCapacity_kW = this.outputCapacity_kW / this.eta_r;
	}
	
	public void setEta_r( double efficiency_r) {
		this.eta_r = efficiency_r;
		this.inputCapacity_kW = this.outputCapacity_kW / this.eta_r;
	}
	
	public double getInputCapacity_kW() {
		return this.inputCapacity_kW;
	}

	public double getOutputCapacity_kW() {
		return this.outputCapacity_kW;
	}
	
	public double getEta_r() {
		return this.eta_r;
	}
	
	public OL_EnergyCarriers getEnergyCarrierProduced() {
		return this.energyCarrierProduced;
	}
	
	public OL_EnergyCarriers getEnergyCarrierConsumed() {
		return this.energyCarrierConsumed;
	}
	
	@Override
	public String toString() {	
		return  this.energyAssetType + ", "			
				+ this.energyCarrierConsumed + " -> " + this.energyCarrierProduced + ", "
				+ "OutputCapacity: " + this.outputCapacity_kW + " kW, " 
				+ "with efficiency: " + this.eta_r + ", "
				+ "Current output: " + -this.getLastFlows().get(this.energyCarrierProduced) + " kW";
	}
}                          
