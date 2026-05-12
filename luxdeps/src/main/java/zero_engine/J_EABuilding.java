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
 * J_EABuilding
 */
//import com.fasterxml.jackson.annotation.JsonTypeName;
//@JsonTypeName("J_EABuilding")
public class J_EABuilding extends zero_engine.J_EAStorageHeat implements Serializable {

	private double solarAbsorptionFactor_m2;
	private double solarRadiation_Wpm2 = 0;
	private double additionalVentilationLosses_fr = 0;
	private double coldExtracted_kWh = 0;
	//Slider scaling factor
	private double lossScalingFactor_fr = 1;
	
	// Optional Interior/Exterior Heat buffers
	private double interiorDelayTime_h;
	private double[] interiorReleaseSchedule_kWh;
	private double[] interiorReleaseScheduleStored_kWh;
	private int interiorReleaseScheduleIndex;
	private double exteriorDelayTime_h;
	private double[] exteriorReleaseSchedule_kWh;
	private double[] exteriorReleaseScheduleStored_kWh;
	private int exteriorReleaseScheduleIndex;	
	
    /**
     * Default constructor
     */
    public J_EABuilding() {
    }

    /**
     * Constructor initializing the fields
     */
    public J_EABuilding(I_AssetOwner owner, double capacityHeat_kW, double lossFactor_WpK, J_TimeParameters timeParameters, double initialTemperature_degC, double heatCapacity_JpK, double solarAbsorptionFactor_m2) {
		this.setOwner(owner);
		this.timeParameters = timeParameters;
		this.capacityHeat_kW = capacityHeat_kW;
		this.lossFactor_WpK = lossFactor_WpK;
		this.initialTemperature_degC = initialTemperature_degC;
		this.temperature_degC = initialTemperature_degC;
		this.heatCapacity_JpK = heatCapacity_JpK;
		this.ambientTempType = OL_AmbientTempType.AMBIENT_AIR;
		this.solarAbsorptionFactor_m2 = solarAbsorptionFactor_m2;
		this.energyAssetType = OL_EnergyAssetType.BUILDINGTHERMALS;
	    if (lossFactor_WpK < 0) {
	    	throw new RuntimeException(String.format("Exception: J_EABuilding with negative lossfactor! %s", lossFactor_WpK));	    	
	    }
	    
	    this.activeProductionEnergyCarriers.add(OL_EnergyCarriers.HEAT);		
		this.activeConsumptionEnergyCarriers.add(OL_EnergyCarriers.HEAT);
		this.assetFlowCategory = OL_AssetFlowCategories.spaceHeating_kW;
		registerEnergyAsset(timeParameters);
    }

	@Override
	public double calculateLoss_kW() {
		double heatLoss_kW = (this.lossFactor_WpK * ( this.temperature_degC - this.ambientTemperature_degC ) / 1000) * lossScalingFactor_fr;
		return heatLoss_kW;
	}

	public double solarHeating_kW() {
		double solarHeating_kW = this.solarAbsorptionFactor_m2 * this.solarRadiation_Wpm2 / 1000;
		return solarHeating_kW;

	}
	
	public double calculateAdditionalVentilationLoss_kW() {
		double additionalVentilationLoss_kW = this.additionalVentilationLosses_fr * calculateLoss_kW();
		return additionalVentilationLoss_kW;
	}
	
		@Override
	public J_FlowPacket f_updateAllFlows(double powerFraction_fr, J_TimeVariables timeVariables) {
		if (powerFraction_fr > 1) {			
			traceln("JEABuilding capacityHeat_kW is too low! "+ capacityHeat_kW);
		}
		return super.f_updateAllFlows(powerFraction_fr, timeVariables);
	}

	@Override
	public void operate(double powerFraction_fr, J_TimeVariables timeVariables) {
		
		/*if (DoubleCompare.lessThanZero(powerFraction_fr)) {
			throw new RuntimeException("Cooling of the J_EABuilding is not yet supported.");
		}*/
		double lossPower_kW = calculateLoss_kW(); // Heat exchange with environment through convection
		double additionalVentilationLoss_kW = calculateAdditionalVentilationLoss_kW();
		double solarHeating_kW = solarHeating_kW(); // Heat influx from sunlight
		this.energyUse_kW = lossPower_kW + additionalVentilationLoss_kW - solarHeating_kW;
		this.energyUsed_kWh += max(0, this.energyUse_kW * this.timeParameters.getTimeStep_h()); // Only heat loss! Not heat gain when outside is hotter than inside!
		this.ambientEnergyAbsorbed_kWh += max(0, -this.energyUse_kW * this.timeParameters.getTimeStep_h()); // Only heat gain from outside air and/or solar irradiance!

		double inputPower_kW = powerFraction_fr * this.capacityHeat_kW; // positive power means lowering the buffer temperature!		
    	
		double deltaEnergy_kWh = -energyUse_kW* this.timeParameters.getTimeStep_h();
		if (this.interiorDelayTime_h != 0.0) {
			deltaEnergy_kWh += getInteriorHeatRelease( inputPower_kW * this.timeParameters.getTimeStep_h() );
    	}
		else { 
			deltaEnergy_kWh += inputPower_kW * this.timeParameters.getTimeStep_h(); // to check the request with the energy currently in storage
		}
		updateStateOfCharge( deltaEnergy_kWh );
		
		this.heatCharged_kWh += max(0,inputPower_kW * this.timeParameters.getTimeStep_h());
		this.coldExtracted_kWh +=max(0,-inputPower_kW * this.timeParameters.getTimeStep_h());
		
		this.flowsMap.put(OL_EnergyCarriers.HEAT, inputPower_kW);

		if (this.assetFlowCategory != null) {
			assetFlowsMap.put(this.assetFlowCategory, inputPower_kW);
		}
	}

	@Override
	public String toString() {
		return
			this.getClass().toString() + " " +
			"energyUsed_kWh (heat losses) = " + this.energyUsed_kWh + "kWh, " +
			"temp = " + this.temperature_degC + ", " +
			"lossFactor_WpK = " + this.lossFactor_WpK + ", "+
			"heatCapacity_JpK = " + this.heatCapacity_JpK;
	}

	@Override
	protected void updateStateOfCharge( double deltaEnergy_kWh ) {
		double tempDelta_degC = deltaEnergy_kWh / (this.heatCapacity_JpK / 3.6E6 );
		this.temperature_degC += tempDelta_degC;
	}

	@Override
	public double getCurrentTemperature() {
		return this.temperature_degC;
	}
	
	@Override
	public double getLossFactor_WpK() {
		return this.lossFactor_WpK;
	}
	
	public void setLossFactor_WpK( double lossFactor_WpK) {
		this.lossFactor_WpK = lossFactor_WpK;
	}
	
	public void setAdditionalVentilation_fr( double ventilation_fr) {
		this.additionalVentilationLosses_fr = ventilation_fr;
	}
	
	public void setLossScalingFactor_fr( double lossScalingFactor_fr) {
		this.lossScalingFactor_fr = lossScalingFactor_fr;
	}
	
	public double getLossScalingFactor_fr() {
		return this.lossScalingFactor_fr;
	}
	
	@Override
    public void storeStatesAndReset() {
    	// Each energy asset that has some states should overwrite this function!
		this.energyUsedStored_kWh = this.energyUsed_kWh;
		this.ambientEnergyAbsorbedStored_kWh = this.ambientEnergyAbsorbed_kWh;
		this.energyUsed_kWh = 0.0;
		this.ambientEnergyAbsorbed_kWh = 0.0;
		this.temperatureStored_degC = this.temperature_degC;
		this.temperature_degC = this.initialTemperature_degC;
		if (this.interiorReleaseSchedule_kWh != null) {
			this.interiorReleaseScheduleStored_kWh = this.interiorReleaseSchedule_kWh;
			Arrays.fill(this.interiorReleaseSchedule_kWh, 0.0);
		}
		if (this.exteriorReleaseSchedule_kWh != null) {
			this.exteriorReleaseScheduleStored_kWh = this.exteriorReleaseSchedule_kWh;
			Arrays.fill(this.exteriorReleaseSchedule_kWh, 0.0);
		}
		clear();
    }
    
	@Override
    public void restoreStates() {
    	// Each energy asset that has some states should overwrite this function!
		this.energyUsed_kWh = this.energyUsedStored_kWh;
		this.ambientEnergyAbsorbed_kWh = this.ambientEnergyAbsorbedStored_kWh;
		this.temperature_degC = this.temperatureStored_degC;
		this.interiorReleaseSchedule_kWh = this.interiorReleaseScheduleStored_kWh;
		this.exteriorReleaseSchedule_kWh = this.exteriorReleaseScheduleStored_kWh;		
    }
	
	@Override
	public void updateAmbientTemperature(double currentAmbientTemperature_degC) { // TODO: Hoe zorgen we dat we deze niet vergeten aan te roepen??
		this.ambientTemperature_degC = currentAmbientTemperature_degC;
	}

	public void updateSolarRadiation(double solarRadiation_Wpm2) { // TODO: Hoe zorgen we dat we deze niet vergeten aan te roepen??
		this.solarRadiation_Wpm2 = solarRadiation_Wpm2;
	}
	
	
	// Methods for Optional Heat Buffer
	// Interior heat buffer may represent the radiator or floor heating. Typical delay is 0.5 or 3 hours respectively.	
	public void addInteriorHeatBuffer(double delayTime_h) {
		this.interiorDelayTime_h = delayTime_h;
		this.interiorReleaseSchedule_kWh = new double[ (int)(delayTime_h / this.timeParameters.getTimeStep_h()) ];
		this.interiorReleaseScheduleIndex = 0;
	}

	// Exterior heat buffer may represent the walls and roof of the building. Typical delay is 8 hours.
	public void addExteriorHeatBuffer(double delayTime_h) {
		this.exteriorDelayTime_h = delayTime_h;
		this.exteriorReleaseSchedule_kWh = new double[ (int)(delayTime_h / this.timeParameters.getTimeStep_h()) ];
		this.exteriorReleaseScheduleIndex = 0;
	}
	
    private double getInteriorHeatRelease(double heatAbsorbed_kWh) {
    	// Distribute the added energy evenly over the release schedule
    	//traceln("Interior schedule before: " + Arrays.toString(this.interiorReleaseSchedule_kWh));
    	for (int x = 0; x < this.interiorReleaseSchedule_kWh.length; x++) {
    		this.interiorReleaseSchedule_kWh[x] += heatAbsorbed_kWh / this.interiorReleaseSchedule_kWh.length;
    	}
    	// Store the current value
    	double heatReleased_kWh = this.interiorReleaseSchedule_kWh[this.interiorReleaseScheduleIndex];
    	// Reset the current value
        this.interiorReleaseSchedule_kWh[this.interiorReleaseScheduleIndex] = 0;
    	// Shift over the index
    	this.interiorReleaseScheduleIndex++;
    	this.interiorReleaseScheduleIndex = this.interiorReleaseScheduleIndex % this.interiorReleaseSchedule_kWh.length;
    	//traceln("Interior schedule after: " + Arrays.toString(this.interiorReleaseSchedule_kWh));    	
 
    	return heatReleased_kWh;
    }
    
    private double getExteriorHeatRelease(double heatAbsorbed_kWh) {
    	// Distribute the added energy evenly over the release schedule
    	for (int x = 0; x < this.exteriorReleaseSchedule_kWh.length; x++) {
    		this.exteriorReleaseSchedule_kWh[x] += heatAbsorbed_kWh / this.exteriorReleaseSchedule_kWh.length;
    	}
    	// Store the current value
    	double heatReleased_kWh = this.exteriorReleaseSchedule_kWh[this.exteriorReleaseScheduleIndex];
    	// Reset the current value
        this.exteriorReleaseSchedule_kWh[this.exteriorReleaseScheduleIndex] = 0;
    	// Shift over the index
    	this.exteriorReleaseScheduleIndex++;
    	this.exteriorReleaseScheduleIndex = this.exteriorReleaseScheduleIndex % this.exteriorReleaseSchedule_kWh.length;
    	
    	return heatReleased_kWh;
    }
    
    @Override
	public double getRemainingHeatStorageHeat_kWh() {
    	double remainingHeatStorageHeat_kWh = super.getRemainingHeatStorageHeat_kWh(); 
    	remainingHeatStorageHeat_kWh += getRemainingHeatBufferHeat_kWh();
    	return remainingHeatStorageHeat_kWh;
    }
    
    public double getRemainingHeatBufferHeat_kWh() {
    	double remainingHeatBufferHeat_kWh = 0;
		if( this.interiorDelayTime_h != 0.0) {
	    	for (int x = 0; x < this.interiorReleaseSchedule_kWh.length; x++) {
	    		remainingHeatBufferHeat_kWh += this.interiorReleaseSchedule_kWh[x];
	    	}
		}
		if( this.exteriorDelayTime_h != 0.0) {
	    	for (int x = 0; x < this.exteriorReleaseSchedule_kWh.length; x++) {
	    		remainingHeatBufferHeat_kWh += this.exteriorReleaseSchedule_kWh[x];    		
	    	}
		}
    	return remainingHeatBufferHeat_kWh;
    }
    
    public boolean hasHeatBuffer() {
    	if (this.exteriorDelayTime_h != 0 || this.interiorDelayTime_h != 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */
	private static final long serialVersionUID = 1L;
}

 
