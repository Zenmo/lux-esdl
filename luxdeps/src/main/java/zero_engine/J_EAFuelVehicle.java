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
 * J_EAConversionPetroleumFuelVehicle
 */
public class J_EAFuelVehicle extends J_EAFixed implements I_Vehicle, Serializable {

	private OL_EnergyCarriers energyCarrierConsumed;
	private boolean available = true;
	private boolean availableStored = true;
	private double energyConsumption_kWhpkm;
	private double vehicleScaling;
	private J_ActivityTrackerTrips tripTracker;
	
	/**
     * Default constructor
     */
    public J_EAFuelVehicle() {
    }

    /**
     * Constructor initializing the fields
     */
    public J_EAFuelVehicle(I_AssetOwner owner, double energyConsumption_kWhpkm, J_TimeParameters timeParameters, double vehicleScaling, OL_EnergyAssetType energyAssetType, J_ActivityTrackerTrips tripTracker, OL_EnergyCarriers energyCarrier ) {
    	this(owner, energyConsumption_kWhpkm, timeParameters, vehicleScaling, energyAssetType, tripTracker, energyCarrier, true );
    }
    public J_EAFuelVehicle(I_AssetOwner owner, double energyConsumption_kWhpkm, J_TimeParameters timeParameters, double vehicleScaling, OL_EnergyAssetType energyAssetType, J_ActivityTrackerTrips tripTracker, OL_EnergyCarriers energyCarrier, boolean available ) {
	    if (energyCarrier == OL_EnergyCarriers.HEAT || energyCarrier == OL_EnergyCarriers.ELECTRICITY) {
	    	throw new RuntimeException("Invalid choice of energy carrier for J_EAFuelVehicle");
	    }
		this.setOwner(owner);
	    this.timeParameters = timeParameters;
	    this.energyConsumption_kWhpkm = energyConsumption_kWhpkm;
	    this.vehicleScaling = vehicleScaling;
	    this.energyAssetType = energyAssetType;
	    this.tripTracker = tripTracker;
	    this.available = available;
	    if (tripTracker != null) {
	    	tripTracker.vehicle=this;
	    }
	    
	    this.energyCarrierConsumed = energyCarrier;
		this.activeConsumptionEnergyCarriers.add(this.energyCarrierConsumed);
		registerEnergyAsset(timeParameters);
	}
    
    @Override
    public J_FlowPacket f_updateAllFlows(J_TimeVariables timeVariables) {
    	flowsMap.put(this.energyCarrierConsumed, this.energyUse_kW);
    	J_FlowsMap flowsMapCopy = new J_FlowsMap();
     	J_ValueMap assetFlowsMapCopy = new J_ValueMap(OL_AssetFlowCategories.class);
     	J_FlowPacket flowPacket = new J_FlowPacket(flowsMapCopy.cloneMap(this.flowsMap), this.energyUse_kW, assetFlowsMapCopy.cloneMap(this.assetFlowsMap));
    	this.lastFlowsMap = flowsMap;
    	this.lastEnergyUse_kW = this.energyUse_kW;
    	clear(); 
    	return flowPacket;
    }
    
    @Override
    public void operate(J_TimeVariables timeVariables) {
    	throw new RuntimeException("Operate was implemented because abstract J_EAFixed prescribed it, but should not be called.");
    }
    
	public boolean startTrip(J_TimeVariables timeVariables) {
		if (available) {
			this.available = false;
			//traceln("PetroleumFuel vehicle starting trip!");
			return true;
		} else {
			traceln("Trip not started because vehicle not available!");
			return false; // Trip not started because vehicle not available!
		}
	}	

    public boolean endTrip(double tripDist_km) {	
		if(available) {
			traceln("Trip not ended because vehicle never left!");
			return false;
		} else {
	    	this.available = true;
	    	return true;
		}
    }
    
    public void setAvailability(boolean available) {
    	this.available = available;
    }

	public boolean progressTrip(double marginalTripDist_km) {
		if( available) {
			traceln("Trip not updated because vehicle never left!");
			return false;
		}
		else {
			//mileage_km += marginalTripDist_km;
	    	double energyUsedThisTimestep_kWh = marginalTripDist_km * vehicleScaling * energyConsumption_kWhpkm;
	    	energyUsed_kWh += energyUsedThisTimestep_kWh;
	    	//petroleumFuelConsumption_kW = energyUsedThisTimestep_kWh / timestep_h;
	    	energyUse_kW += energyUsedThisTimestep_kWh / timeParameters.getTimeStep_h();
			return true;
		}
	}
	
	public void setVehicleScaling(double vehicleScaling) {
    	this.vehicleScaling = vehicleScaling;
    }
    
	public void setTripTracker(J_ActivityTrackerTrips tracker) {
		this.tripTracker = tracker;
	}
	
	public J_ActivityTrackerTrips getTripTracker() {
		return this.tripTracker;
	}
	
	public boolean getAvailability() {
		return this.available;
	}
	
	public double getVehicleScaling_fr() {
		return this.vehicleScaling;
	}
	
	public double getEnergyConsumption_kWhpkm() {
		return this.energyConsumption_kWhpkm * this.vehicleScaling;
	}
	
	public OL_EnergyCarriers getEnergyCarrierConsumed() {
		return this.energyCarrierConsumed;
	}
	
	@Override
    public void storeStatesAndReset() {
    	// Each energy asset that has some states should overwrite this function!
    	energyUsedStored_kWh = energyUsed_kWh;
    	energyUsed_kWh = 0.0;
    	availableStored = available;
    	available = true;
    	clear();    	
    }
    
	@Override
    public void restoreStates() {
    	// Each energy asset that has some states should overwrite this function!
    	energyUsed_kWh = energyUsedStored_kWh;    	
    	available = availableStored;
    }
	
	
	@Override
	public String toString() {
		return
			"energy carrier = " + energyCarrierConsumed + " " +		
			"energyConsumption_kWhpkm =" + energyConsumption_kWhpkm + " " +
			"vehicleScaling = " + vehicleScaling;
	}

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */
	private static final long serialVersionUID = 1L;
}

 
