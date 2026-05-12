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
 * J_EAConsumption
 */
public class J_EAConsumption extends zero_engine.J_EAProfile implements Serializable {

	private double yearlyDemand_kWh;
	//public double loadLoad_kWh = 0;
	/**
     * Default constructor
     */
    public J_EAConsumption() {
    }

    /**
     * Constructor initializing the fields
     */
    public J_EAConsumption(I_AssetOwner owner, OL_EnergyAssetType type, String name, double yearlyDemand_kWh, OL_EnergyCarriers energyCarrier, J_TimeParameters timeParameters, J_ProfilePointer profile) {
		/*if (yearlyDemand_kWh == 0.0) {
			throw new RuntimeException("Unable to construct J_EAConsumption: " + name + " because consumption is zero." );
		}*/
    	this.setOwner(owner);
	    this.timeParameters = timeParameters;	    
		
    	this.energyAssetName = name;
		this.energyAssetType = type;
    	
		this.yearlyDemand_kWh = yearlyDemand_kWh;
		if (profile.getProfileUnits() == OL_ProfileUnits.YEARLYTOTALFRACTION) {
			this.profileUnitScaler_r = yearlyDemand_kWh;
			this.profilePointer = profile;
		} else {
			throw new RuntimeException("Invalid OL_ProfileUnits type for J_EAConsumption!");
		}
		this.energyCarrier =  energyCarrier;
		
		
		this.activeConsumptionEnergyCarriers.add(this.energyCarrier);
		
		if (this.energyCarrier == OL_EnergyCarriers.ELECTRICITY) {
			if (this.energyAssetType == OL_EnergyAssetType.ELECTRIC_HOB) {
				this.assetFlowCategory = OL_AssetFlowCategories.electricHobConsumption_kW; //
			}
			else {
				this.assetFlowCategory = OL_AssetFlowCategories.fixedConsumptionElectric_kW; //
			}
		}
		else if (this.energyCarrier == OL_EnergyCarriers.HEAT) {
			if (this.energyAssetType == OL_EnergyAssetType.HOT_WATER_CONSUMPTION) {
				this.assetFlowCategory = OL_AssetFlowCategories.hotWaterConsumption_kW;
			}
			else {
				this.assetFlowCategory = OL_AssetFlowCategories.spaceHeating_kW;
			}
		}

		registerEnergyAsset(timeParameters);
    }

    public String getAssetName() {
    	return this.energyAssetName;
    }
    
    public void setConsumptionScaling_fr(double consumptionScaling_fr) {
    	this.profileScaling_fr = consumptionScaling_fr;
    }
    
    public double getConsumptionScaling_fr() {
    	return this.profileScaling_fr;
    }
    
    
    /*@Override
    public void f_updateAllFlows(double v_powerFraction_fr) {
		throw new RuntimeException("J_EAConsumption.f_updateAllFlows() should be called without arguments!");
	}
	
	public void f_updateAllFlows() {
		double ratioOfCapacity = profilePointer.getCurrentValue();		
		this.operate(ratioOfCapacity);
		if (ratioOfCapacity>0.0) { // Skip when there is no consumption -> saves time?
			if (parentAgent instanceof GridConnection) {    		
	    		//((GridConnection)parentAgent).f_addFlows(arr, this);
	    		((GridConnection)parentAgent).f_addFlows(flowsMap, this.energyUse_kW, assetFlowsMap, this);
	    	}

		}
		this.lastFlowsMap.cloneMap(this.flowsMap);
    	this.lastEnergyUse_kW = this.energyUse_kW;
    	this.clear();
    }
    
	@Override
	public void operate(double ratioOfCapacity) {

    	double consumption_kW = ratioOfCapacity * this.yearlyDemand_kWh * this.consumptionScaling_fr;
		
    	this.energyUse_kW = consumption_kW;
    	this.energyUsed_kWh += this.energyUse_kW * this.timestep_h;

		flowsMap.put(this.energyCarrier, consumption_kW);		
		if (this.assetFlowCategory != null) {
			assetFlowsMap.put(this.assetFlowCategory, consumption_kW);
		}
   	}*/

    public J_ProfilePointer getProfilePointer() {
    	return this.profilePointer;
    }
    
    @Override
    public double getBaseConsumption_kWh() {
    	return yearlyDemand_kWh;
    }
    
	@Override
	public String toString() {
		return
			"type = " + this.getClass().toString() + " " +
			"owner = " + this.getOwner() +" " +
			"energyCarrier = " + this.energyCarrier + " " + 
			"yearlyDemand_kWh = " + this.yearlyDemand_kWh;
	}
	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */
	private static final long serialVersionUID = 1L;
}
 
