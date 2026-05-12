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
 * J_HeatingPreferences
 */	
public class J_HeatingPreferences {

    /**
     * Default constructor
     */
    private double startOfDayTime_h = 8;
    private double startOfNightTime_h = 23;
    private double dayTimeSetPoint_degC = 20;
    private double nightTimeSetPoint_degC = 18;
    private double windowOpenSetpoint_degC = 25;
    
    private double maxComfortTemperature_degC = dayTimeSetPoint_degC + 3;
    private double minComfortTemperature_degC = dayTimeSetPoint_degC - 2;
    
    public J_HeatingPreferences() {
    }
    
    public J_HeatingPreferences(double startOfDayTime_h, double startOfNightTime_h, double dayTimeSetPoint_degC, double nightTimeSetPoint_degC, double maxComfortTemperature_degC, double minComfortTemperature_degC, double windowOpenSetpoint_degC) {
    	
        this.startOfDayTime_h = startOfDayTime_h;
        this.startOfNightTime_h = startOfNightTime_h;
        this.dayTimeSetPoint_degC = dayTimeSetPoint_degC;
        this.nightTimeSetPoint_degC = nightTimeSetPoint_degC;
        this.maxComfortTemperature_degC = maxComfortTemperature_degC;
        this.minComfortTemperature_degC = minComfortTemperature_degC;
        this.windowOpenSetpoint_degC = windowOpenSetpoint_degC;
    }
    
    //Setters
    public void setStartOfDayTime_h(double startOfDayTime_h) {
    	this.startOfDayTime_h = startOfDayTime_h;
    }
    public void setStartOfNightTime_h(double startOfNightTime_h) {
    	this.startOfNightTime_h = startOfNightTime_h;
    }
    public void setDayTimeSetPoint_degC(double dayTimeSetPoint_degC) {
    	this.dayTimeSetPoint_degC = dayTimeSetPoint_degC;
    }
    public void setNightTimeSetPoint_degC(double nightTimeSetPoint_degC) {
    	this.nightTimeSetPoint_degC = nightTimeSetPoint_degC;
    }
    public void setMaxComfortTemperature_degC(double maxComfortTemperature_degC) {
    	this.maxComfortTemperature_degC = maxComfortTemperature_degC;
    }
    public void setMinComfortTemperature_degC(double minComfortTemperature_degC) {
    	this.minComfortTemperature_degC = minComfortTemperature_degC;
    }
    
    //Getters
    public double getStartOfDayTime_h() {
    	return this.startOfDayTime_h;
    }
    public double getStartOfNightTime_h() {
    	return this.startOfNightTime_h;
    }
    public double getDayTimeSetPoint_degC() {
    	return this.dayTimeSetPoint_degC;
    }
    public double getNightTimeSetPoint_degC() {
    	return this.nightTimeSetPoint_degC;
    }
    public double getMaxComfortTemperature_degC() {
    	return this.maxComfortTemperature_degC;
    }
    public double getMinComfortTemperature_degC() {
    	return this.minComfortTemperature_degC;
    }
    public double getWindowOpenSetpoint_degc() {
    	return this.windowOpenSetpoint_degC;
    }
    
	public double getCurrentPreferedTemperatureSetpoint_degC(double timeOfDay_h) {
		if (timeOfDay_h < getStartOfDayTime_h() || timeOfDay_h >= getStartOfNightTime_h()) {
			return getNightTimeSetPoint_degC();
		}
		else {
			return getDayTimeSetPoint_degC();
		}
	}
	
	@Override
	public String toString() {
		return 
        "StartOfDayTime_h = " + this.startOfDayTime_h + 
        ", StartOfNightTime_h = " + this.startOfNightTime_h + 
        ", DayTimeSetPoint_degC = " + this.dayTimeSetPoint_degC + 
        ", NightTimeSetPoint_degC = " + this.nightTimeSetPoint_degC + 
        ", MaxComfortTemperature_degC = " + this.maxComfortTemperature_degC + 
        ", MinComfortTemperature_degC = " + this.minComfortTemperature_degC +
        ", WindowOpenSetpoint_degC = " + this.windowOpenSetpoint_degC;
	}

} 
