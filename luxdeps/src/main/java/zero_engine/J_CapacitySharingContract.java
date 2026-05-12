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
 * J_CapacitySharingContract
 */	
public class J_CapacitySharingContract {
	GridConnection receivingGC;
	GridConnection sendingGC;
	
	//Arrays
	double[] capacitySharingWeekdayDeliveryCapacity_kW;
	double[] capacitySharingWeekenddayDeliveryCapacity_kW;
	double[] capacitySharingWeekdayFeedinCapacity_kW;
	double[] capacitySharingWeekenddayFeedinCapacity_kW;
	
	//Variables
	double currentSharedDeliveryCapacity_kW = 0;
	double currentSharedFeedinCapacity_kW = 0;
	
    /**
     * Default constructor
     */
    public J_CapacitySharingContract(GridConnection receivingGC, GridConnection sendingGC, double[] capacitySharingWeekdayDeliveryCapacity_kW, 
    		double[] capacitySharingWeekenddayDeliveryCapacity_kW, double[] capacitySharingWeekdayFeedinCapacity_kW, 
    		double[] capacitySharingWeekenddayFeedinCapacity_kW, J_TimeVariables timeVariables) {
    	
    	if(receivingGC == null || sendingGC == null) {
    		throw new RuntimeException("It is not possible to create a capacity sharing contract without specifying both the recieving and sending GC");
    	}
    	this.receivingGC = receivingGC;
    	this.sendingGC = sendingGC;
    	
    	receivingGC.v_liveConnectionMetaData.addCapacitySharingContract(this);
    	sendingGC.v_liveConnectionMetaData.addCapacitySharingContract(this);
    	
    	this.capacitySharingWeekdayDeliveryCapacity_kW = capacitySharingWeekdayDeliveryCapacity_kW;
    	this.capacitySharingWeekenddayDeliveryCapacity_kW = capacitySharingWeekenddayDeliveryCapacity_kW;
    	this.capacitySharingWeekdayFeedinCapacity_kW = capacitySharingWeekdayFeedinCapacity_kW;
    	this.capacitySharingWeekenddayFeedinCapacity_kW = capacitySharingWeekenddayFeedinCapacity_kW;
    	
    	this.update(sendingGC, timeVariables);
    }
    
    public void update(GridConnection callerGC, J_TimeVariables timeVariables) {
    	if(callerGC == sendingGC) { //Update is called from both GC, but these values only need to be calculated once.
		    int hourOfDay = roundToInt(floor(timeVariables.getTimeOfDay_h()));
	    	if (timeVariables.getDayOfWeek() == OL_Days.SATURDAY || timeVariables.getDayOfWeek() == OL_Days.SUNDAY) {
	    		this.currentSharedDeliveryCapacity_kW = capacitySharingWeekenddayDeliveryCapacity_kW[hourOfDay];
	    		this.currentSharedFeedinCapacity_kW = capacitySharingWeekenddayFeedinCapacity_kW[hourOfDay];
	    	}
	    	else {
	    		this.currentSharedDeliveryCapacity_kW = capacitySharingWeekdayDeliveryCapacity_kW[hourOfDay];
	    		this.currentSharedFeedinCapacity_kW = capacitySharingWeekdayFeedinCapacity_kW[hourOfDay];
	    	}
    	}
    }
    
    public double getCurrentSharedDeliveryCapacity_kW(GridConnection requestingGC) {
    	int receiveOrSendDirectionFactor = requestingGC == receivingGC ? 1 : -1;
    	return receiveOrSendDirectionFactor * this.currentSharedDeliveryCapacity_kW;
    }

    public double getCurrentSharedFeedinCapacity_kW(GridConnection requestingGC) {
    	int receiveOrSendDirectionFactor = requestingGC == receivingGC ? 1 : -1;
    	return receiveOrSendDirectionFactor * this.currentSharedFeedinCapacity_kW;
    }
    
    public double getSharedDeliveryCapacityAtHourOfWeekDay_kW(int hourOfDay) {
    	return capacitySharingWeekdayDeliveryCapacity_kW[hourOfDay];
    }
    public double getSharedDeliveryCapacityAtHourOfWeekendDay_kW(int hourOfDay) {
    	return capacitySharingWeekenddayDeliveryCapacity_kW[hourOfDay];
    }
    public double getSharedFeedinCapacityAtHourOfWeekDay_kW(int hourOfDay) {
    	return capacitySharingWeekdayFeedinCapacity_kW[hourOfDay];
    }
    public double getSharedFeedinCapacityAtHourOfWeekendDay_kW(int hourOfDay) {
    	return capacitySharingWeekenddayFeedinCapacity_kW[hourOfDay];
    }
    
	@Override
	public String toString() {
		return super.toString();
	}
} 
