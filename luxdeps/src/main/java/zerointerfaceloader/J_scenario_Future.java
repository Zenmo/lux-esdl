package zerointerfaceloader;

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

import zero_engine.*;
import digital_twin_results.*;

import static zerointerfaceloader.OL_FilterOptionsGC.*;
import static zerointerfaceloader.OL_GISBuildingTypes.*;
import static zerointerfaceloader.OL_ProjectType.*;
import static zerointerfaceloader.OL_CustomScenarioTabs.*;
import static zerointerfaceloader.OL_SurveyType.*;
import static zerointerfaceloader.OL_MapOverlayTypes.*;
import static zerointerfaceloader.OL_UserGCAccessType.*;
import static zerointerfaceloader.OL_UserNBHAccessType.*;

import static com.anylogic.engine.Utilities.*;

/**
 * Scenario_future
 */	

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;


@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,    // ✅ only public fields are serialized
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type"  // 👈 this will be the field name in your JSON
	)
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")

public class J_scenario_Future implements Serializable {

	private Agent parentAgent;
	private boolean isActiveInFuture = true; //Boolean used to see if gc is active in future scenario
	private Double requestedContractDeliveryCapacity_kW = 0.0;
	private Double requestedContractFeedinCapacity_kW = 0.0;
	private Double requestedPhysicalConnectionCapacity_kW = 0.0;
	private double plannedHeatSavings_pct = 0;
	private OL_GridConnectionHeatingType plannedHeatingType = OL_GridConnectionHeatingType.NONE;
	private double plannedElectricitySavings_pct = 0;
	private boolean plannedCurtailment = false;
	private Integer plannedPV_kW = 0;
	private Integer plannedPV_year;
	private OL_PVOrientation plannedPV_orientation;
	private Float plannedWind_kW = 0f;
	private Float plannedBatteryPower_kW = 0f;
	private Float plannedBatteryCapacity_kWh = 0f;
	//Integer plannedWind_year;
	private double plannedTransportSavings_pct = 0;
	private Integer plannedEVCars = 0;
	private Integer plannedEVVans = 0;
	private Integer plannedEVTrucks = 0;
	private Integer plannedHydrogenCars = 0;
	private Integer plannedHydrogenVans = 0;
	private Integer plannedHydrogenTrucks = 0; 

    /**
     * Default constructor
     */
    public J_scenario_Future() {
    }
    
    /**
     * Constructor initializing the fields
     */
    /*
    public J_scenario_Future(Agent parentAgent, Integer plannedPV_kW, Integer plannedPV_year, Float plannedWind_kW, Integer plannedEVCars, Integer plannedEVVans, Integer plannedEVTrucks) {

		
    }
    */
    
    // Setters
    public void setParentAgent(Agent parentAgent) {
        this.parentAgent = parentAgent;
    }
    
    public void setIsActiveInFuture(boolean isActiveInFuture) {
        this.isActiveInFuture = isActiveInFuture;
    }

    public void setRequestedContractDeliveryCapacity_kW(Double requestedContractDeliveryCapacity_kW) {
        this.requestedContractDeliveryCapacity_kW = requestedContractDeliveryCapacity_kW;
    }
    
    public void setRequestedContractFeedinCapacity_kW(Double requestedContractFeedinCapacity_kW) {
        this.requestedContractFeedinCapacity_kW = requestedContractFeedinCapacity_kW;
    }
    
    public void setRequestedPhysicalConnectionCapacity_kW(Double requestedPhysicalConnectionCapacity_kW) {
        this.requestedPhysicalConnectionCapacity_kW = requestedPhysicalConnectionCapacity_kW;
    }
    
    public void setPlannedHeatSavings_pct(double plannedHeatSavings_pct) {
    	this.plannedHeatSavings_pct = plannedHeatSavings_pct;
    }
    
    public void setPlannedHeatingType(OL_GridConnectionHeatingType plannedHeatingType) {
    	this.plannedHeatingType = plannedHeatingType;
    }
    
    public void setPlannedElectricitySavings_pct(double plannedElectricitySavings_pct) {
    	this.plannedElectricitySavings_pct = plannedElectricitySavings_pct;
    }
    
    public void setPlannedCurtailment(boolean plannedCurtailment) {
    	this.plannedCurtailment = plannedCurtailment;
    }
    
    public void setPlannedPV_kW(Integer plannedPV_kW) {
        this.plannedPV_kW = plannedPV_kW;
    }

    public void setPlannedPV_year(Integer plannedPV_year) {
        this.plannedPV_year = plannedPV_year;
    }
    
    public void setPlannedPV_orientation(OL_PVOrientation plannedPV_orientation) {
        this.plannedPV_orientation = plannedPV_orientation;
    }
    
    public void setPlannedWind_kW(Float plannedWind_kW) {
        this.plannedWind_kW = plannedWind_kW;
    }

    public void setPlannedBatteryPower_kW(Float plannedBatteryPower_kW) {
        this.plannedBatteryPower_kW = plannedBatteryPower_kW;
    }

    public void setPlannedBatteryCapacity_kWh(Float plannedBatteryCapacity_kWh) {
        this.plannedBatteryCapacity_kWh = plannedBatteryCapacity_kWh;
    }
    
    public void setPlannedTransportSavings_pct(double plannedTransportSavings_pct) {
    	this.plannedTransportSavings_pct = plannedTransportSavings_pct;
    }
    
    public void setPlannedEVCars(Integer plannedEVCars) {
        this.plannedEVCars = plannedEVCars;
    }

    public void setPlannedEVVans(Integer plannedEVVans) {
        this.plannedEVVans = plannedEVVans;
    }

    public void setPlannedEVTrucks(Integer plannedEVTrucks) {
        this.plannedEVTrucks = plannedEVTrucks;
    }

    public void setPlannedHydrogenCars(Integer plannedHydrogenCars) {
        this.plannedHydrogenCars = plannedHydrogenCars;
    }

    public void setPlannedHydrogenVans(Integer plannedHydrogenVans) {
        this.plannedHydrogenVans = plannedHydrogenVans;
    }

    public void setPlannedHydrogenTrucks(Integer plannedHydrogenTrucks) {
        this.plannedHydrogenTrucks = plannedHydrogenTrucks;
    }
   
    // Getters
    public Agent getParentAgent() {
        return parentAgent;
    }
    
    public boolean getIsActiveInFuture() {
        return isActiveInFuture;
    }
    
    public Double getRequestedContractDeliveryCapacity_kW() {
        return requestedContractDeliveryCapacity_kW;
    } 
    
    public Double getRequestedContractFeedinCapacity_kW() {
        return requestedContractFeedinCapacity_kW;
    } 

    public Double getRequestedPhysicalConnectionCapacity_kW() {
    	return requestedPhysicalConnectionCapacity_kW;
    }
    
    public double getPlannedHeatSavings_pct() {
    	return plannedHeatSavings_pct;
    }
    
    public OL_GridConnectionHeatingType getPlannedHeatingType() {
    	return plannedHeatingType;
    }
    
    public double getPlannedElectricitySavings_pct() {
    	return plannedElectricitySavings_pct;
    } 
    
    public boolean getPlannedCurtailment() {
    	return plannedCurtailment;
    }
    
    public Integer getPlannedPV_kW() {
    	if (plannedPV_kW == null) {
    		return 0;
    	}
        return plannedPV_kW;
    }

    public Integer getPlannedPV_year() {
        return plannedPV_year;
    }

    public OL_PVOrientation getPlannedPV_orientation() {
        return this.plannedPV_orientation;
    }
    
    public Float getPlannedWind_kW() {
        return plannedWind_kW;
    }

    public Float getPlannedBatteryPower_kW() {
    	if (plannedBatteryPower_kW == null) {
    		return 0f;
    	}
        return plannedBatteryPower_kW;
    }
    
    public Float getPlannedBatteryCapacity_kWh() {
    	if (plannedBatteryCapacity_kWh == null) {
    		return 0f;
    	}
        return plannedBatteryCapacity_kWh;
    }
    
    public double getPlannedTransportSavings_pct() {
    	return plannedTransportSavings_pct;
    }
    
    public Integer getPlannedEVCars() {
        return plannedEVCars;
    }

    public Integer getPlannedEVVans() {
        return plannedEVVans;
    }

    public Integer getPlannedEVTrucks() {
        return plannedEVTrucks;
    }
    
    public Integer getPlannedHydrogenCars() {
        return plannedHydrogenCars;
    }

    public Integer getPlannedHydrogenVans() {
        return plannedHydrogenVans;
    }

    public Integer getPlannedHydrogenTrucks() {
        return plannedHydrogenTrucks;
    }
    
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;

} 
