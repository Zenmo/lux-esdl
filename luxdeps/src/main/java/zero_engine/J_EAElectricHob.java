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
 * J_EAElectricHob
 */	
public class J_EAElectricHob extends J_EAConversion implements Serializable {

	//protected double outputTemperature_degC;

    /**
     * Default constructor
     */
	// The efficiency is the amount of heat that is retained within the building
    public J_EAElectricHob(I_AssetOwner owner, double inputCapacity_kW, double efficiency, J_TimeParameters timeParameters, double outputTemperature_degC) {
    	this.setOwner(owner);
	    this.timeParameters = timeParameters;
	    this.inputCapacity_kW = inputCapacity_kW;
	    this.eta_r = efficiency;
	    this.outputCapacity_kW = inputCapacity_kW * efficiency;
	    //this.outputTemperature_degC = outputTemperature_degC;
		this.energyCarrierProduced = OL_EnergyCarriers.HEAT;
		this.energyCarrierConsumed = OL_EnergyCarriers.ELECTRICITY;
	    this.energyAssetType = OL_EnergyAssetType.ELECTRIC_HOB;
	    this.assetFlowCategory = OL_AssetFlowCategories.electricHobConsumption_kW;
	    this.activeProductionEnergyCarriers.add(this.energyCarrierProduced);		
		this.activeConsumptionEnergyCarriers.add(this.energyCarrierConsumed);
		registerEnergyAsset(timeParameters);
    }

    @Override
    public void operate( double powerFraction_fr, J_TimeVariables timeVariables ) {
    	double heatProduction_kW = this.inputCapacity_kW * powerFraction_fr * eta_r;
		double electricityConsumption_kW = this.inputCapacity_kW * powerFraction_fr;
		this.energyUse_kW = (electricityConsumption_kW - heatProduction_kW);
		this.energyUsed_kWh += this.timeParameters.getTimeStep_h() * (electricityConsumption_kW - heatProduction_kW); // This represents losses!
		//this.heatProduced_kWh += heatProduction_kW * timestep_h;
		flowsMap.put(OL_EnergyCarriers.ELECTRICITY, electricityConsumption_kW);		
		flowsMap.put(OL_EnergyCarriers.HEAT, -heatProduction_kW);	
		assetFlowsMap.put(this.assetFlowCategory, electricityConsumption_kW);
    }
    
	@Override
	public String toString() {
		return
			"AssetType = " + energyAssetType + ", " +
			"Energy consumed = " + this.energyUsed_kWh + ", " +
			" capacityElectric_kW = " + this.inputCapacity_kW +" "+
			"eta_r = " + this.eta_r+ ", " +
			"energyUsed_kWh (losses) = " + this.energyUsed_kWh;
	}
	
	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;

} 
