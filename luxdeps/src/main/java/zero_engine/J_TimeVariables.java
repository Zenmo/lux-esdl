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
 * J_TimeVariables
 */	
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect(
	    fieldVisibility = Visibility.ANY,    // also stores full profiles to file. Maybe arrange a way to 'skip' this?
	    getterVisibility = Visibility.NONE,
	    isGetterVisibility = Visibility.NONE,
	    setterVisibility = Visibility.NONE,
	    creatorVisibility = Visibility.NONE
	)
	@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")

public final class J_TimeVariables {
	////Time Variables -> Updated every timestep
	private double t_h; //Current energymodel runtime: t_h = 0, corresponds to 'jan 1 0:00' of the start year 
	private double anyLogicTime_h; // anyLogicTime is the experiment time used for DataSets/ResultsUI. t = 0 corresponds to the start of the simulation
	private double timeOfDay_h;
	private int timeStepsElapsed;

	private OL_Days dayOfWeek;
	
	private boolean isDaytime;
	private boolean isWeekday;
	private boolean isSummerWeek;
	private boolean isWinterWeek;
	private boolean isLastTimeStepOfDay;
	
	/**
     * Default constructor
     */
	public J_TimeVariables() {
		
	}
	
	public J_TimeVariables(int v_timeStepsElapsed, J_TimeParameters timeParameters){
		updateTimeVariables(v_timeStepsElapsed, timeParameters);
	}
	
	public void updateTimeVariables(int v_timeStepsElapsed, J_TimeParameters timeParameters) {
		timeStepsElapsed = v_timeStepsElapsed;
		anyLogicTime_h = timeStepsElapsed * timeParameters.getTimeStep_h();
		t_h = anyLogicTime_h + timeParameters.getRunStartTime_h();
		int dayIndex = (int) ((t_h / 24 + timeParameters.getDayOfWeek1jan()) % 7);	
		dayOfWeek = OL_Days.values()[dayIndex];
		isDaytime = t_h % 24 > 6 && t_h % 24 < 18;
		isWeekday = (t_h+(timeParameters.getDayOfWeek1jan()-1)*24) % (24*7) < (24*5);
		isSummerWeek = (t_h % 8760) >= timeParameters.getStartOfSummerWeek_h() && (t_h % 8760) < timeParameters.getStartOfSummerWeek_h() + 24*7;
		isWinterWeek = (t_h % 8760) >= timeParameters.getStartOfWinterWeek_h() && (t_h % 8760) < timeParameters.getStartOfWinterWeek_h() + 24*7;
		isLastTimeStepOfDay = t_h % 24 == (24-timeParameters.getTimeStep_h());
		timeOfDay_h = t_h % 24;
	}
	
	public double getT_h() {
	    return t_h;
	}
	
	public double getAnyLogicTime_h() {
		return anyLogicTime_h;
	}

	public double getTimeOfDay_h() {
	    return timeOfDay_h;
	}

	public OL_Days getDayOfWeek() {
		return dayOfWeek;
	}
	
	public int getTimeStepsElapsed() {
	    return timeStepsElapsed;
	}

	public boolean isDaytime() {
	    return isDaytime;
	}

	public boolean isWeekday() {
	    return isWeekday;
	}

	public boolean isSummerWeek() {
	    return isSummerWeek;
	}

	public boolean isWinterWeek() {
	    return isWinterWeek;
	}

	public boolean isLastTimeStepOfDay() {
	    return isLastTimeStepOfDay;
	}
	
	public Date getDate(Experiment experiment, J_TimeParameters timeParameters) {
		Date startDate = experiment.getEngine().getStartDate();
		long startDateUnixTime_ms = startDate.getTime();
		long runtime_ms = (long) (timeStepsElapsed * timeParameters.getTimeStep_h() * 60 * 60 * 1000);
		Date date = new Date();
		date.setTime(startDateUnixTime_ms + runtime_ms);
		return date;
	}
	
	
	@Override
	public String toString() {
	    return "J_TimeVariables{" +
	            "t_h=" + t_h +
	            ", anyLogicTime_h=" + anyLogicTime_h +
	            ", timeOfDay_h=" + timeOfDay_h +
	            ", timeStepsElapsed=" + timeStepsElapsed +
	            ", dayOfWeek=" + dayOfWeek +
	            ", isDaytime=" + isDaytime +
	            ", isWeekday=" + isWeekday +
	            ", isSummerWeek=" + isSummerWeek +
	            ", isWinterWeek=" + isWinterWeek +
	            ", isLastTimeStepOfDay=" + isLastTimeStepOfDay +
	            '}';
	}
} 
