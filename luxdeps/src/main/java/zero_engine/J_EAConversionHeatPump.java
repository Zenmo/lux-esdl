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
 * J_EAConversionHeatPump
 */
public class J_EAConversionHeatPump extends zero_engine.J_EAConversion implements Serializable, I_HeatingAsset {
	private double COP_r;
	private double belowZeroHeatpumpEtaReductionFactor;
	protected double outputTemperature_degC;
	private double baseTemperature_degC;
	private double sourceAssetHeatPower_kW; // for water-water heatpump functionality
	protected OL_AmbientTempType ambientTempType;
	public double totalElectricityConsumed_kWh =0;
	public J_EA p_linkedSourceEnergyAsset;
	public double p_baseTemperatureReference;

    /**
     * Default constructor
     */
    public J_EAConversionHeatPump() {
    }

    //Agent parentAgent, double outputCapacity_kW, double efficiency_r, double timestep_h, double outputTemperature_degC) {

    /**
     * Constructor initializing the fields
     */
    public J_EAConversionHeatPump(I_AssetOwner owner, double inputElectricCapacity_kW, double eta_r, J_TimeParameters timeParameters, double outputTemperature_degC, double baseTemperature_degC, double sourceAssetHeatPower_kW, double belowZeroHeatpumpEtaReductionFactor, OL_AmbientTempType ambientTempType ) {
		this.setOwner(owner);
	    this.timeParameters = timeParameters;
		this.inputCapacity_kW = inputElectricCapacity_kW;
	    this.eta_r = eta_r;
	    this.outputTemperature_degC = outputTemperature_degC;

	    this.ambientTempType = ambientTempType;
	    this.updateAmbientTemperature( this.baseTemperature_degC );

	    //this.COP_r = eta_r * ( 273.15 + outputTemperature_degC ) / ( outputTemperature_degC - baseTemperature_degC );
	   // traceln("Carnot-based Heatpump COP with parameter eta_r is no longer used! Replaced by empirical COP-curve.");
	    this.COP_r = calculateCOP(this.outputTemperature_degC, this.baseTemperature_degC);
	    
	    this.sourceAssetHeatPower_kW = sourceAssetHeatPower_kW;
	    this.belowZeroHeatpumpEtaReductionFactor = belowZeroHeatpumpEtaReductionFactor;

	    this.energyCarrierProduced = OL_EnergyCarriers.HEAT;
    	this.energyCarrierConsumed= OL_EnergyCarriers.ELECTRICITY;  
    	
	    this.activeProductionEnergyCarriers.add(this.energyCarrierProduced);   	
		this.activeConsumptionEnergyCarriers.add(this.energyCarrierConsumed);
		this.assetFlowCategory = OL_AssetFlowCategories.heatPumpElectricityConsumption_kW;
		registerEnergyAsset(timeParameters);
	}

	public void updateParameters(double baseTemperature_degC, double outputTemperature_degC) {
		this.baseTemperature_degC = baseTemperature_degC;
		this.outputTemperature_degC = outputTemperature_degC;
		if ( this.baseTemperature_degC > this.outputTemperature_degC) {
			traceln("**** EXCEPTION **** Heatpump baseTemperature ( " + this.baseTemperature_degC + ") > outputTemperature ( " + this.outputTemperature_degC + ") ");
		}
		//this.COP_r = this.eta_r * ( 273.15 + this.outputTemperature_degC ) / ( this.outputTemperature_degC - this.baseTemperature_degC );
	    this.COP_r = calculateCOP(this.outputTemperature_degC, this.baseTemperature_degC); //8.74 - 0.190 * deltaT + 0.00126 * deltaT * deltaT;
		
		// water heatpump should take sourceAsset power transfer limitations into account (e.g. residual heat). Ugly but effectively limiting heat power output.
    	
		if( this.sourceAssetHeatPower_kW > 0) {
	    	this.outputCapacity_kW = min( this.outputCapacity_kW, this.sourceAssetHeatPower_kW / (1 - (1 / COP_r )));
	    	//traceln("Water water heatpump heat capacity limited from source! =" + this.capacityHeat_kW);
		} 
		else {
				this.outputCapacity_kW = this.inputCapacity_kW * this.COP_r; 
				//traceln("heatpump updating temp: " + baseTemperature_degC);
				if( baseTemperature_degC < 0 ) {
					this.COP_r = this.COP_r / this.belowZeroHeatpumpEtaReductionFactor;
				}
		}
    	//traceln("J_EAConversionHeatpump capacityHeat_kW = "+ this.capacityHeat_kW + ", sourceAssetHeatPower_kW " + this.sourceAssetHeatPower_kW );
    
	}

	public void updateAmbientTemperature(double baseTemperature_degC) {
		// water heatpump should take sourceAsset power transfer limitations into account (e.g. residual heat). Ugly but effectively limiting heat power output.
    	
		//traceln("J_EAHeatpump capacityHeat_kW = " + this.capacityHeat_kW + ", baseTemperature = "+ baseTemperature_degC + ", outputtemperature = "+ outputTemperature_degC);
		updateParameters(baseTemperature_degC, this.outputTemperature_degC);
		this.COP_r = calculateCOP(this.outputTemperature_degC, this.baseTemperature_degC); //this.eta_r * ( 273.15 + this.outputTemperature_degC ) / ( this.outputTemperature_degC - this.baseTemperature_degC );
	    this.outputCapacity_kW = this.inputCapacity_kW * this.COP_r;
	}

	public void setCOP(double COP_r) {
		this.COP_r = COP_r;
		this.outputCapacity_kW = this.inputCapacity_kW * this.COP_r;
	}
	
	public double getCOP() {
		//traceln("Heatpump output temperature: " + this.outputTemperature_degC);
		return this.COP_r;
	}
	
	@Override
	public void operate(double powerFraction_fr, J_TimeVariables timeVariables) {

		double electricityConsumption_kW = powerFraction_fr * this.inputCapacity_kW;
		this.totalElectricityConsumed_kWh += electricityConsumption_kW * this.timeParameters.getTimeStep_h();
    	double heatProduction_kW = electricityConsumption_kW * this.COP_r;

    	/*
    	double heatConsumption_kW = 0;
    	if(this.ambientTempType.equals("WATER")) {
    		//traceln("test water heatpump EA code for heat consumption. WATER ambient temp type detected ");
    		double maxAvailableSourcePower_kW = this.sourceAssetHeatPower_kW;
    		
    		heatConsumption_kW = heatProduction_kW - electricityConsumption_kW;
    		//update effective energy production of source asset!
    		this.p_linkedSourceEnergyAsset.v_powerFraction_fr += ( heatConsumption_kW / ((J_EAProduction)this.p_linkedSourceEnergyAsset).getCapacityHeat_kW() );
//    		this.ownerAsset.p_linkedSourceEnergyAsset.j_ea.heatProduction_kW += this.heatConsumption_kW;
       	}
       	*/
    	if (this.ambientTempType == OL_AmbientTempType.HEAT_GRID ) {
    		this.energyUse_kW = 0;
    		flowsMap.put(OL_EnergyCarriers.HEAT, -electricityConsumption_kW);
    		flowsMap.put(OL_EnergyCarriers.ELECTRICITY, electricityConsumption_kW);
    	}
    	else {
	    	this.energyUse_kW = electricityConsumption_kW - heatProduction_kW; 		
			flowsMap.put(OL_EnergyCarriers.HEAT, -heatProduction_kW);		
			flowsMap.put(OL_EnergyCarriers.ELECTRICITY, electricityConsumption_kW);		
	    }
    	this.assetFlowsMap.addFlow	(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW, electricityConsumption_kW);
		this.energyUsed_kWh += energyUse_kW * this.timeParameters.getTimeStep_h();
	}

	public void setSourceAssetHeatPower(double sourceAssetHeatPower_kW) {
		this.sourceAssetHeatPower_kW = sourceAssetHeatPower_kW;
		//traceln("sourceAssetHeatPower_kW is set to: "+sourceAssetHeatPower_kW);
	}
	
	public void setBaseTemperature_degC( double baseTemperature_degC) {
		this.baseTemperature_degC = baseTemperature_degC;
		this.updateParameters( this.baseTemperature_degC, this.outputTemperature_degC);
	}
    
	public OL_AmbientTempType getAmbientTempType() {
		return this.ambientTempType;
	}
	
	public double calculateCOP(double outputTemperature_degC, double baseTemperature_degC) {
		double deltaT = max(1,this.outputTemperature_degC - this.baseTemperature_degC); // Limit deltaT to at least 1 degree.
	    double COP_r = 8.74 - 0.190 * deltaT + 0.00126 * deltaT*deltaT;
	    return COP_r;
	}

	
	public double getOutputTemperature_degC() {
		return this.outputTemperature_degC;
	}
	/*
	@Override
	public String toString() {
		return
			"type = " + this.getClass().toString() + " " +
			"parentAgent = " + parentAgent +" " +
			"capacityElectricity_kW = " + capacityElectric_kW +" "+
			"capacityHeat_kW = " + capacityHeat_kW +" "+
			"baseTemperature_degC = " + baseTemperature_degC + " "+
			"ambientTempType = " + ambientTempType + " "+
			"sourceAssetHeatPower_kW = " + sourceAssetHeatPower_kW + " " +
			"outputTemperature_degC = " + outputTemperature_degC +" "+
			"energyUsed_kWh = " + energyUsed_kWh + " "+
			"heatProduced_kWh = " + heatProduced_kWh + " "+
			"heatConsumed_kWh = " + heatConsumed_kWh + " ";
	}
	*/	
}
 
