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
 * J_ChargingSessionData
 */	

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,    // 
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")

public class J_ChargingSessionData {
	private double startTime_h;
	private double endTime_h;
	private double timeStep_h;
	private double chargingDemand_kWh;
	private double batterySize_kWh;
	private double initialSOC_kWh;
	private double vehicleMaxChargingPower_kW;
	private int socketNb;
	
	private boolean V2GCapable = true;

	
	private boolean V2GCapabilityIsOverriden = false;
	private boolean V2GCapableOverride = true;
	
    /**
     * Constructor for (de-)serialisation
     */
	public J_ChargingSessionData() {
	}
	
    /**
     * Default constructor initializing the fields
     */
    public J_ChargingSessionData(double startTime_quarterhours, double endTime_quarterhours, double chargingDemand_kWh, double batterySize_kWh, double chargingPower_kW, int socketNb, boolean V2GCapable, double timeStep_h) {
    
    	this.startTime_h = 0.25 * startTime_quarterhours;
    	this.endTime_h = 0.25 * endTime_quarterhours;
    	this.chargingDemand_kWh = chargingDemand_kWh;
    	this.batterySize_kWh = batterySize_kWh;
    	this.vehicleMaxChargingPower_kW = chargingPower_kW; 
    	this.initialSOC_kWh = 0; //Required to be 0, to prevent jumps in energy in the model
    	this.socketNb = socketNb-1;
    	this.V2GCapable = V2GCapable;
    	this.timeStep_h = timeStep_h;
    	if(this.startTime_h > this.endTime_h){
    		new RuntimeException("StartTime is later then the endtime for J_ChargingSession");
    	}
    	
    	//Override to get continious energy balance!
    	if(true) {
	    	this.initialSOC_kWh = 0; //Required to be 0, to prevent jumps in energy in the model
	    	this.batterySize_kWh = chargingDemand_kWh; //-> Equal to charging demand, as initial SOC starts
    	}
    }
    
    public double getStartTime_h() {
    	return this.startTime_h;
    }
    
	public double getLeaveTime_h() {
		return this.endTime_h;
	}

	public double getChargingCapacity_kW() {
		return this.vehicleMaxChargingPower_kW;
	}
	
	public double getStorageCapacity_kWh() {
		return this.batterySize_kWh;
	}
	
	public double getInitialSOC_kWh() {
		return this.initialSOC_kWh;
	}

    public double getEnergyNeededForNextTrip_kWh() {
    	return this.chargingDemand_kWh + this.initialSOC_kWh;
    }
    
    public J_ChargingSessionData getClone() {
    	return new J_ChargingSessionData((this.startTime_h*4), (this.endTime_h*4), this.chargingDemand_kWh, this.batterySize_kWh, this.vehicleMaxChargingPower_kW, this.socketNb, this.V2GCapable, this.timeStep_h);
    }
    
	public double getVehicleScaling_fr() {
		return 1.0;
	}
	
	public boolean getV2GCapable() {
		if(this.V2GCapabilityIsOverriden) {
			return this.V2GCapableOverride;
		}
		else {
			return this.V2GCapable;
		}
	}
    
	public int getSocketNb() {
	    return this.socketNb;
	}
	
	public boolean getAvailability(double t_h) {
		return this.startTime_h < t_h && t_h < this.endTime_h;
	}

	
	public void overrideV2GCapability(boolean V2GCapabilityIsOverriden, boolean V2GCapableOverride) {
		this.V2GCapabilityIsOverriden = V2GCapabilityIsOverriden;
		if(this.V2GCapabilityIsOverriden) {
			this.V2GCapableOverride = V2GCapableOverride;
		}
	}
   
	@Override
	public String toString() {
		return "StartTime_h: " + startTime_h + ", endTime_h: " + endTime_h + ", Pmax: " + vehicleMaxChargingPower_kW + "kW, demand: " + chargingDemand_kWh + "kWh";
	}
} 
