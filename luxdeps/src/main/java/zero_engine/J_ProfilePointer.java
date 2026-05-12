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
 * J_ProfilePointer
 */	
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,    // also stores full profiles to file. Maybe arrange a way to 'skip' this?
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")

public class J_ProfilePointer{
	public String name = "";
	private double currentValue = 0;
	private OL_ProfileUnits profileUnits;
	
	// Using internal array instead of tableFunction
	private double[] a_profile;
	private double dataTimeStep_h;
	private double dataStartTime_h; // relative to 00:00h on jan 1st of simulation year
	private boolean enableProfileLooping = true;
	
    /**
     * Default constructor
     */
	public J_ProfilePointer() {
	
	}
	
    public J_ProfilePointer(String name, double[] profile, double dataTimeStep_h, double dataStartTime_h, OL_ProfileUnits profileUnits) {
    	if (profileUnits == null) {
    		throw new RuntimeException("Attempting to create J_ProfilePointer with null profileUnits!");
    	}
    	this.name = name;
    	this.a_profile = profile;
    	this.dataTimeStep_h = dataTimeStep_h;
    	this.dataStartTime_h = dataStartTime_h;	    	
    	this.profileUnits = profileUnits;
    }

    public void updateValue(double t_h) {
    	this.currentValue = this.getValue(t_h);
    }
    
    public double getCurrentValue() {
    	return this.currentValue;
    }
    
    public double getValue(double time_h) {
    	//return this.tableFunction.get(t_h);
    	int index_n = (int)((time_h-dataStartTime_h)/dataTimeStep_h);
    	if (enableProfileLooping && index_n >= a_profile.length) {
    		index_n = index_n % a_profile.length;
    	} else if ( index_n >= a_profile.length ) {
    		traceln("Time out of upper bound for evaluating J_EAProfile power in profile %s!", this.name);
//    		time_h = a_energyProfile_kWh.length * profileTimestep_h - 1;
    		throw new RuntimeException(String.format("Time out of upper bound for evaluating J_EAProfile power! Time is: %s", time_h));
    	}
    	if ( index_n < 0 ) {
    		traceln("Time out of lower bound for evaluating J_EAProfile power in profile %s!", this.name);
    		throw new RuntimeException(String.format("Time out of lower bound for evaluating J_EAProfile power! Time is: %s", time_h));
    	}
    	double currentValue_kW = this.a_profile[index_n]; 
    	return currentValue_kW;
    }
       
    public double[] getAllValues() {
    	//return this.tableFunction.getValues();
    	return this.a_profile.clone();
    }
    
    public double getDataTimeStep_h() {
    	return dataTimeStep_h;
    }
    
    public double getDataStartTime_h() {
    	return dataStartTime_h;
    }
    
    public double[] getAllShiftedValues() {
        double[] shiftedValues = new double[a_profile.length];
        for (int i = 0; i < a_profile.length; i++) {
            int index_n = (int)((i * dataTimeStep_h - dataStartTime_h) / dataTimeStep_h);
            index_n = index_n % a_profile.length;
            if (index_n < 0) {
                index_n += a_profile.length;
            }
            shiftedValues[i] = a_profile[index_n];
        }
        return shiftedValues;
    }
    
    public OL_ProfileUnits getProfileUnits() {
    	return profileUnits;
    }
    
	@Override
	public String toString() {
		return "profile: " + this.name + " current value: " + this.currentValue; 
	}
} 
