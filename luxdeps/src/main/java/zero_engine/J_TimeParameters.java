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

import java.time.LocalDate;
import java.time.DayOfWeek;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,    // also stores full profiles to file. Maybe arrange a way to 'skip' this?
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")

/**
 * J_TimeParameters
 */	
public final class J_TimeParameters {
	////Time parameters:
	private final double timeStep_h;
	private final int startYear;
	private final double[] monthStartHours;
	private final int dayOfWeek1jan;
	private final double runStartTime_h;
	private final double runEndTime_h;
	private final int summerWeekNumber;
	private final int winterWeekNumber;
	private final double startOfSummerWeek_h;
	private final double startOfWinterWeek_h;
	
	public J_TimeParameters(
		double timeStep_h,
		int startYear,
		double[] monthStartHours,
		double runStartTime_h,
		double runEndTime_h,
		int summerWeekNumber,
		int winterWeekNumber
	) {
		this.timeStep_h = timeStep_h;
		this.startYear = startYear;
		this.monthStartHours = monthStartHours;
		this.runStartTime_h = runStartTime_h;
		this.runEndTime_h = runEndTime_h;
		this.summerWeekNumber = summerWeekNumber;
		this.winterWeekNumber = winterWeekNumber;
		this.dayOfWeek1jan = DayOfWeek.from(LocalDate.of(startYear, 1, 1)).getValue();
		this.startOfSummerWeek_h = roundToInt(24 * (summerWeekNumber * 7 + (8-dayOfWeek1jan)%7));
		this.startOfWinterWeek_h = roundToInt(24 * (winterWeekNumber * 7 + (8-dayOfWeek1jan)%7));
	}
	
	// Creator for deserialisation. (needed because of final fields!)
	@JsonCreator
    public J_TimeParameters(
        @JsonProperty("timeStep_h") double timeStep_h,
        @JsonProperty("startYear") int startYear,
        @JsonProperty("monthStartHours") double[] monthStartHours,
        @JsonProperty("dayOfWeek1jan") int dayOfWeek1jan,
        @JsonProperty("runStartTime_h") double runStartTime_h,
        @JsonProperty("runEndTime_h") double runEndTime_h,
        @JsonProperty("summerWeekNumber") int summerWeekNumber,
        @JsonProperty("winterWeekNumber") int winterWeekNumber,
        @JsonProperty("startOfSummerWeek_h") double startOfSummerWeek_h,
        @JsonProperty("startOfWinterWeek_h") double startOfWinterWeek_h
    ) {
		this(timeStep_h, startYear, monthStartHours, runStartTime_h, runEndTime_h, summerWeekNumber, winterWeekNumber);
    }
	
	////Time Parameter getters
	public double getTimeStep_h() {
	    return timeStep_h;
	}
	public int getStartYear() {
	    return startYear;
	}
	public double[] getMonthStartHours() {
	    return monthStartHours;
	}
	public int getDayOfWeek1jan() {
	    return dayOfWeek1jan;
	}
	public double getRunStartTime_h() {
	    return runStartTime_h;
	}
	public double getRunEndTime_h() {
	    return runEndTime_h;
	}
	public int getSummerWeekNumber() {
	    return summerWeekNumber;
	}
	public int getWinterWeekNumber() {
	    return winterWeekNumber;
	}
	public double getStartOfSummerWeek_h() {
	    return startOfSummerWeek_h;
	}
	public double getStartOfWinterWeek_h() {
	    return startOfWinterWeek_h;
	}
	public double getRunDuration_h() {
		return runEndTime_h - runStartTime_h;
	}
	
	@Override
	public String toString() {
	    return "J_TimeParameters{" +
	            "timeStep_h=" + timeStep_h +
	            ", startYear=" + startYear +
	            ", monthStartHours=" + java.util.Arrays.toString(monthStartHours) +
	            ", dayOfWeek1jan=" + dayOfWeek1jan +
	            ", runStartTime_h=" + runStartTime_h +
	            ", runEndTime_h=" + runEndTime_h +
	            ", summerWeekNumber=" + summerWeekNumber +
	            ", winterWeekNumber=" + winterWeekNumber +
	            ", startOfSummerWeek_h=" + startOfSummerWeek_h +
	            ", startOfWinterWeek_h=" + startOfWinterWeek_h +
	            '}';
	}
} 
