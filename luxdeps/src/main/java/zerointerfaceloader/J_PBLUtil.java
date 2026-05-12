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
 * J_PBLUtil
 */	
public class J_PBLUtil {
	
	//Convert string into OL_PBL_DwellingType option
	public static OL_HouseholdCookingMethod getPBLCookingTypeOptionFromPBLData(String value) {
		if(value == null || value.equals("")) {
			return OL_HouseholdCookingMethod.UNKNOWN;
		}
		else {
			return OL_HouseholdCookingMethod.valueOf(value);
		}
	}
	
	//Convert input int or string into OL_PBL_DwellingType option
	public static OL_PBL_DwellingType getPBLDwellingTypeOption(Integer value) {
		String str_value = value != null ? String.valueOf(value) : null; 
		return getPBLDwellingTypeOption(str_value);
	}
	public static OL_PBL_DwellingType getPBLDwellingTypeOption(String value) {
		if(value == null || value.equals("")) {
			return OL_PBL_DwellingType.UNKNOWN;
		}
		else {
			return OL_PBL_DwellingType.valueOf(J_PBLUtil.getOLTypeString(value));
		}
	}
	
	//Convert input buildYear into ConstructionPeriod option (spaceHeating)
	public static int getConstructionPeriodOption_spaceHeatingAndResidents(int buildYear) {
		if (buildYear <= 1929){ return 0;}
		if (buildYear <= 1945){ return 1;}
		if (buildYear <= 1964){ return 2;}
		if (buildYear <= 1974){ return 3;}
		if (buildYear <= 1991){ return 4;}
		if (buildYear <= 1995){ return 5;}
		if (buildYear <= 1999){ return 6;}
		if (buildYear <= 2005){ return 7;}
		if (buildYear <= 2010){ return 8;}
		if (buildYear <= 2014){ return 9;}
		return 10; //Anything above 2014 = 10
	}
	//Convert input buildYear into ConstructionPeriod option (dhw and cooking)
	public static int getConstructionPeriodOption_DHWAndCooking(int buildYear) {
		if (buildYear <= 1930){ return 0;}
		if (buildYear <= 1959){ return 1;}
		if (buildYear <= 1980){ return 2;}
		if (buildYear <= 1995){ return 3;}
		return 4; //Anything above 1995 = 4
	}
	
	//Convert input int or string into OL_PBL_OwnershipType option
	public static OL_PBL_OwnershipType getPBLOwnershipTypeOption(Integer value) {
		String str_value = value != null ? String.valueOf(value) : null;
		return getPBLOwnershipTypeOption(str_value);
	}
	public static OL_PBL_OwnershipType getPBLOwnershipTypeOption(String value) {
		if(value == null || value.equals("")) {
			return OL_PBL_OwnershipType.UNKNOWN;
		}
		else {
			return OL_PBL_OwnershipType.valueOf(J_PBLUtil.getOLTypeString(value));
		}
	}
	
	//Convert input string of energylabel into OL_GridConnectionEnergyLabel option	
	public static OL_GridConnectionEnergyLabel getEnergyLabelOption(String energyLabel) {
		if(energyLabel == null || energyLabel.equals("x") || energyLabel.equals("")) {
			return OL_GridConnectionEnergyLabel.UNKNOWN;
		}
		else if(energyLabel.startsWith("A+")) { //For now all A+, A++, etc. are converted into A
			return OL_GridConnectionEnergyLabel.A;
		}
		else {
			return OL_GridConnectionEnergyLabel.valueOf(energyLabel);
		}
	}
	
	public static OL_GridConnectionInsulationLabel getWorstInsulationLabel(OL_GridConnectionInsulationLabel insulationLabel_1, OL_GridConnectionInsulationLabel insulationLabel_2) {
		return convertEnergyToInsulationLabel(getWorstEnergyLabel(convertInsulationToEnergyLabel(insulationLabel_1), convertInsulationToEnergyLabel(insulationLabel_2)));
	}
	
	public static OL_GridConnectionEnergyLabel getWorstEnergyLabel(OL_GridConnectionEnergyLabel energyLabel_1, OL_GridConnectionEnergyLabel energyLabel_2) {
		energyLabel_1 = energyLabel_1 != null ? energyLabel_1 : OL_GridConnectionEnergyLabel.UNKNOWN;
		energyLabel_2 = energyLabel_2 != null ? energyLabel_2 : OL_GridConnectionEnergyLabel.UNKNOWN;
		
		//Find the lowest energy label in the building
		if (energyLabel_1 != OL_GridConnectionEnergyLabel.NONE && energyLabel_2 != OL_GridConnectionEnergyLabel.NONE ){
			switch(energyLabel_2){
				case A:
					if(energyLabel_1 == OL_GridConnectionEnergyLabel.UNKNOWN){
						return OL_GridConnectionEnergyLabel.A;
					}
				break;
				case B:
					if(energyLabel_1 == OL_GridConnectionEnergyLabel.UNKNOWN || energyLabel_1 == OL_GridConnectionEnergyLabel.A){
						return OL_GridConnectionEnergyLabel.B;
					}
				break;
				case C:
					if(energyLabel_1 == OL_GridConnectionEnergyLabel.UNKNOWN || energyLabel_1 == OL_GridConnectionEnergyLabel.B
					   || energyLabel_1 == OL_GridConnectionEnergyLabel.C){
						return OL_GridConnectionEnergyLabel.C;
					}
				break;
				case D:
					if(energyLabel_1 != OL_GridConnectionEnergyLabel.E || energyLabel_1 != OL_GridConnectionEnergyLabel.F
					   || energyLabel_1 != OL_GridConnectionEnergyLabel.G){
						return OL_GridConnectionEnergyLabel.D;
					}
				break;
				case E:
					if(energyLabel_1 != OL_GridConnectionEnergyLabel.F || energyLabel_1 != OL_GridConnectionEnergyLabel.G){
						return OL_GridConnectionEnergyLabel.E;
					}
				break;
				case F:
					if(energyLabel_1 != OL_GridConnectionEnergyLabel.G){
						return OL_GridConnectionEnergyLabel.F;
					}
				break;
				case G:
					return OL_GridConnectionEnergyLabel.G;
			}
			return energyLabel_1;
		}
		else {
			return OL_GridConnectionEnergyLabel.NONE;
		}
	}
	
	//Convert input string of insulationlabel into OL_GridConnectionInsulationLabel option	
	public static OL_GridConnectionInsulationLabel getInsulationLabelOption(String insulationLabel) {
		return convertEnergyToInsulationLabel(getEnergyLabelOption(insulationLabel));
	}
	
	//Get the most suited regression population
	public static int getPBLRegressionPopulation(OL_GridConnectionInsulationLabel insulationLabel, OL_PBL_DwellingType dwellingType) {
		if (insulationLabel == null || insulationLabel == OL_GridConnectionInsulationLabel.NONE || insulationLabel == OL_GridConnectionInsulationLabel.UNKNOWN){ 
		    return 3;
		} 
		else if(dwellingType == OL_PBL_DwellingType.TYPE_1){//If detached house
			return 2;
		}
		else {
			return 1;
		}
	}
	
	//Get the TNO surface code based on floor surface
	public static int getTNOFloorSurfaceCode(double floorSurfaceArea_m2) {
		if (floorSurfaceArea_m2 < 75){ return 1;}
		if (floorSurfaceArea_m2 < 100){ return 2;}
		if (floorSurfaceArea_m2 < 125){ return 3;}
		if (floorSurfaceArea_m2 < 150){ return 4;}
		return 5; // floorSurfaceArea_m2 >= 150 -> 5
	}
	
	
	public static OL_GridConnectionHeatingType getHeatingTypeOptionFromPBLData(String PBLHeatingTypeString) {
		if (PBLHeatingTypeString == null || PBLHeatingTypeString.equals("")){ return OL_GridConnectionHeatingType.UNKNOWN;}
		if (PBLHeatingTypeString.equals("HR")){ return OL_GridConnectionHeatingType.GAS_BURNER;}
		if (PBLHeatingTypeString.equals("gebiedsoptie")){ return OL_GridConnectionHeatingType.UNKNOWN;}
		if (PBLHeatingTypeString.equals("Pellet")){ return OL_GridConnectionHeatingType.UNKNOWN;}
		if (PBLHeatingTypeString.contains("WP")){ return OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP;}//eWP_lw (lucht water), of eWP_ww (water water)
		traceln("Unknown PBL heating string (" + PBLHeatingTypeString + ") found! Converted into UNKNOWN heating type.");
		return OL_GridConnectionHeatingType.UNKNOWN;
	}
	
	
	
	//Support functions
	private static String getOLTypeString(String number) {
		return "TYPE_" + number;
	}
	
	public static OL_GridConnectionEnergyLabel convertInsulationToEnergyLabel(OL_GridConnectionInsulationLabel insulationLabel) {
		return insulationLabel != null ? OL_GridConnectionEnergyLabel.valueOf(insulationLabel.toString()) : null;
	}
	public static OL_GridConnectionInsulationLabel convertEnergyToInsulationLabel(OL_GridConnectionEnergyLabel energyLabel) {
		return energyLabel != null ? OL_GridConnectionInsulationLabel.valueOf(energyLabel.toString()) : null;
	}
} 
