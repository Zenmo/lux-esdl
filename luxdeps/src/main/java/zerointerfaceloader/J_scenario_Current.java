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

public class J_scenario_Current implements Serializable {

	private Agent parentAgent;
	private boolean isCurrentlyActive = true;
	private Double currentContractDeliveryCapacity_kW = 0.0;
	private Double currentContractFeedinCapacity_kW = 0.0;
	private Double currentPhysicalConnectionCapacity_kW = 0.0;
	private Integer currentPV_kW = 0;
	private OL_PVOrientation currentPV_orientation;
	private Float currentWind_kW = 0f;
	private Float currentBatteryPower_kW = 0f;
	private Float currentBatteryCapacity_kWh = 0f;
	private OL_GridConnectionHeatingType currentHeatingType = OL_GridConnectionHeatingType.NONE;
	private Integer currentPetroleumFuelCars = 0;
	private Integer currentPetroleumFuelVans = 0;
	private Integer currentPetroleumFuelTrucks = 0;
	private Integer currentHydrogenCars = 0; 
	private Integer currentHydrogenVans = 0;
	private Integer currentHydrogenTrucks = 0;
	private Integer currentEVCars = 0;
	private Integer currentEVVans = 0;
	private Integer currentEVTrucks = 0;
	private Double currentEVCarChargePower_kW = 0.0;
	private Double currentEVVanChargePower_kW = 0.0;
	private Double currentEVTruckChargePower_kW = 0.0; 
		
		
    /**
     * Default constructor
     */
    public J_scenario_Current() {
    }
    
    /**
     * Constructor initializing the fields
     */
    /*
    public J_scenario_Current() {
    }
    */
    
    // Setters
    public void setParentAgent(Agent parentAgent) {
        this.parentAgent = parentAgent;
    }
    
    public void setIsCurrentlyActive(boolean isCurrentlyActive) {
        this.isCurrentlyActive = isCurrentlyActive;
    }
    
    public void setCurrentContractDeliveryCapacity_kW(Double currentContractDeliveryCapacity_kW) {
    	this.currentContractDeliveryCapacity_kW = currentContractDeliveryCapacity_kW;
    }
    
    public void setCurrentContractFeedinCapacity_kW(Double currentContractFeedinCapacity_kW) {
    	this.currentContractFeedinCapacity_kW = currentContractFeedinCapacity_kW;
    }
    
    public void setCurrentPhysicalConnectionCapacity_kW(Double currentPhysicalConnectionCapacity_kW) {
    	this.currentPhysicalConnectionCapacity_kW = currentPhysicalConnectionCapacity_kW;
    }
    
    public void setCurrentPV_kW(int currentPV_kW) {
    	this.currentPV_kW = currentPV_kW;
    }
    
    
    public void setCurrentPV_orientation(OL_PVOrientation currentPV_orientation) {
        this.currentPV_orientation = currentPV_orientation;
    }
	
    public void setCurrentWind_kW(Float currentWind_kW) {
        this.currentWind_kW = currentWind_kW;
    }

    public void setCurrentBatteryPower_kW(Float currentBatteryPower_kW) {
        this.currentBatteryPower_kW = currentBatteryPower_kW;
    }

    public void setCurrentBatteryCapacity_kWh(Float currentBatteryCapacity_kWh) {
        this.currentBatteryCapacity_kWh = currentBatteryCapacity_kWh;
    }

    public void setCurrentHeatingType(OL_GridConnectionHeatingType currentHeatingType) {
        this.currentHeatingType = currentHeatingType;
    }

    public void setCurrentPetroleumFuelCars(Integer currentPetroleumFuelCars) {
        this.currentPetroleumFuelCars = currentPetroleumFuelCars;
    }

    public void setCurrentPetroleumFuelVans(Integer currentPetroleumFuelVans) {
        this.currentPetroleumFuelVans = currentPetroleumFuelVans;
    }

    public void setCurrentPetroleumFuelTrucks(Integer currentPetroleumFuelTrucks) {
        this.currentPetroleumFuelTrucks = currentPetroleumFuelTrucks;
    }
  
    public void setCurrentHydrogenCars(Integer currentHydrogenCars) {
        this.currentHydrogenCars = currentHydrogenCars;
    }

    public void setCurrentHydrogenVans(Integer currentHydrogenVans) {
        this.currentHydrogenVans = currentHydrogenVans;
    }

    public void setCurrentHydrogenTrucks(Integer currentHydrogenTrucks) {
        this.currentHydrogenTrucks = currentHydrogenTrucks;
    }
    
    public void setCurrentEVCars(Integer currentEVCars) {
        this.currentEVCars = currentEVCars;
    }

    public void setCurrentEVVans(Integer currentEVVans) {
        this.currentEVVans = currentEVVans;
    }

    public void setCurrentEVTrucks(Integer currentEVTrucks) {
        this.currentEVTrucks = currentEVTrucks;
    }
    
    public void setCurrentEVCarChargePower_kW(Double currentEVCarChargePower_kW) {
        this.currentEVCarChargePower_kW = currentEVCarChargePower_kW;
    }

    public void setCurrentEVVanChargePower_kW(Double currentEVVanChargePower_kW) {
        this.currentEVVanChargePower_kW = currentEVVanChargePower_kW;
    }

    public void setCurrentEVTruckChargePower_kW(Double currentEVTruckChargePower_kW) {
        this.currentEVTruckChargePower_kW = currentEVTruckChargePower_kW;
    }
    
    
    // Getters
    public Agent getParentAgent() {
        return parentAgent;
    }
    
    public boolean getIsCurrentlyActive() {
        return isCurrentlyActive;
    }
    
    public Double getCurrentContractDeliveryCapacity_kW() {
    	return currentContractDeliveryCapacity_kW;
    }

    public Double getCurrentContractFeedinCapacity_kW() {
    	return currentContractFeedinCapacity_kW;
    }
    
    public Double getCurrentPhysicalConnectionCapacity_kW() {
    	return currentPhysicalConnectionCapacity_kW;
    }    
    	
    public Integer getCurrentPV_kW() {
    	if (currentPV_kW == null) {
    		return 0;
    	}
        return currentPV_kW;
    }
    
    public OL_PVOrientation getCurrentPV_orientation() {
        return this.currentPV_orientation;
    }
    
    public Float getCurrentWind_kW() {
        return currentWind_kW;
    }
    
    public Float getCurrentBatteryPower_kW() {
        return currentBatteryPower_kW;
    }
    
    public Float getCurrentBatteryCapacity_kWh() {
        return currentBatteryCapacity_kWh;
    }
    
    public OL_GridConnectionHeatingType getCurrentHeatingType() {
        return currentHeatingType;
    }
	
    public Integer getCurrentPetroleumFuelCars() {
        return currentPetroleumFuelCars;
    }

    public Integer getCurrentPetroleumFuelVans() {
        return currentPetroleumFuelVans;
    }

    public Integer getCurrentPetroleumFuelTrucks() {
        return currentPetroleumFuelTrucks;
    }

    public Integer getCurrentHydrogenCars() {
        return currentHydrogenCars;
    }

    public Integer getCurrentHydrogenVans() {
        return currentHydrogenVans;
    }

    public Integer getCurrentHydrogenTrucks() {
        return currentHydrogenTrucks;
    }
    
    public Integer getCurrentEVCars() {
        return currentEVCars;
    }

    public Integer getCurrentEVVans() {
        return currentEVVans;
    }

    public Integer getCurrentEVTrucks() {
        return currentEVTrucks;
    }
    
    public Double getCurrentEVCarChargePower_kW() {
        return currentEVCarChargePower_kW;
    }

    public Double getCurrentEVVanChargePower_kW() {
        return currentEVVanChargePower_kW;
    }

    public Double getCurrentEVTruckChargePower_kW() {
        return currentEVTruckChargePower_kW;
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
