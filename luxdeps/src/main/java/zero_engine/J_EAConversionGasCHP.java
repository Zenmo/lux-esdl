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
 * J_EAConversionGasCHP
 */
public class J_EAConversionGasCHP extends zero_engine.J_EAConversion implements Serializable, I_HeatingAsset {

	protected double outputTemperature_degC;
	protected double outputHeatCapacity_kW;
	protected double outputElectricCapacity_kW;
	protected List<OL_EnergyCarriers> energyCarriersProduced = new ArrayList<>();
    
	/**
     * Default constructor
     */
	
    public J_EAConversionGasCHP() {
    }

    /**
     * Constructor initializing the fields
     */
    public J_EAConversionGasCHP(I_AssetOwner owner, double outputElectricCapacity_kW, double outputHeatCapacity_kW, double efficiency, J_TimeParameters timeParameters, double outputTemperature_degC ) {
	    if (outputElectricCapacity_kW < 0 || outputHeatCapacity_kW < 0 || (outputElectricCapacity_kW == 0 && outputHeatCapacity_kW == 0)) {
	    	throw new RuntimeException("Impossible capacities for J_EAConversionGasCHP. outputElectricCapacity_kW: " + outputElectricCapacity_kW + ", outputHeatCapacity_kW: " + outputHeatCapacity_kW);
	    }
    	this.setOwner(owner);
	    this.timeParameters = timeParameters;
	    this.outputElectricCapacity_kW = outputElectricCapacity_kW;
	    this.outputHeatCapacity_kW = outputHeatCapacity_kW; 
	    this.eta_r = efficiency;
	    this.inputCapacity_kW = (outputElectricCapacity_kW + outputHeatCapacity_kW) / this.eta_r ;
	    this.outputTemperature_degC = outputTemperature_degC;
	    
	    this.energyAssetType = OL_EnergyAssetType.METHANE_CHP;
	    
    	this.energyCarriersProduced.add( OL_EnergyCarriers.ELECTRICITY );
    	this.energyCarriersProduced.add( OL_EnergyCarriers.HEAT );
    	this.energyCarrierConsumed= OL_EnergyCarriers.METHANE;
    	
        this.activeProductionEnergyCarriers.addAll(energyCarriersProduced);
    	this.activeConsumptionEnergyCarriers.add(this.energyCarrierConsumed);
    	this.assetFlowCategory = OL_AssetFlowCategories.CHPProductionElectric_kW;
	    registerEnergyAsset(timeParameters);
	}

	@Override
    public void operate(double powerFraction_fr, J_TimeVariables timeVariables) {
    	double electricityProduction_kW = this.outputElectricCapacity_kW * powerFraction_fr;
		double heatProduction_kW = this.outputHeatCapacity_kW * powerFraction_fr;
		double methaneConsumption_kW = this.inputCapacity_kW * powerFraction_fr;
		
		this.energyUse_kW = methaneConsumption_kW - heatProduction_kW - electricityProduction_kW ;
		this.energyUsed_kWh += energyUse_kW * this.timeParameters.getTimeStep_h();

		//this.heatProduced_kWh += heatProduction_kW * timestep_h;
		//this.electricityProduced_kWh += electricityProduction_kW * timestep_h;
		
		flowsMap.put(OL_EnergyCarriers.HEAT, -heatProduction_kW);		
		flowsMap.put(OL_EnergyCarriers.ELECTRICITY, -electricityProduction_kW);
		flowsMap.put(OL_EnergyCarriers.METHANE, methaneConsumption_kW);
		assetFlowsMap.put(this.assetFlowCategory, electricityProduction_kW);
    }

	@Override
	public void setInputCapacity_kW( double inputCapacity_kW) {
		double scaling_fr = inputCapacity_kW / this.inputCapacity_kW;
		this.inputCapacity_kW = inputCapacity_kW;
		this.outputHeatCapacity_kW = scaling_fr * this.outputHeatCapacity_kW;
		this.outputElectricCapacity_kW = scaling_fr * this.outputElectricCapacity_kW;
	}
	
	@Override
	public void setEta_r( double efficiency) {
	    this.eta_r = efficiency;
	    this.inputCapacity_kW = (this.outputElectricCapacity_kW + this.outputHeatCapacity_kW) / this.eta_r ;
	}
	
	@Override
	public OL_EnergyCarriers getEnergyCarrierProduced() {
		throw new RuntimeException("Can not get EnergyCarrierProduced from J_EAConversionGasCHP, use getEnergyCarriersProduced() instead.");
	}
	
	public List<OL_EnergyCarriers> getEnergyCarriersProduced() {
		return this.energyCarriersProduced;
	}
	
	@Override
	public String toString() {	
		return  this.energyAssetType + ", "				
				+ "OutputElectricCapacity: " + this.outputElectricCapacity_kW + " kW, " 
				+ "OutputHeatCapacity: " + this.outputHeatCapacity_kW + " kW, "
				+ "with efficiency: " + this.eta_r + ", "
				+ "Current electric output: " + -this.getLastFlows().get(OL_EnergyCarriers.ELECTRICITY) + " kW, "
				+ "Current heat output: " + -this.getLastFlows().get(OL_EnergyCarriers.HEAT) + " kW";
	}
	
	//@Override
	public double getCurrentTemperature() {
		return outputTemperature_degC;
	}
	
	public double getOutputHeatCapacity_kW() {
		return outputHeatCapacity_kW;
	}
	public double getOutputElectricCapacity_kW() {
		return outputElectricCapacity_kW;
	}
	
	@Override
	public double getOutputCapacity_kW() {
		throw new RuntimeException("Can't use the basic getOutputcapacity of this Asset, as it has 2 outputs. So You need to specify which output!");
	}
} 
