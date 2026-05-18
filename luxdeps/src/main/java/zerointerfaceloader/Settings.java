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
 * Settings
 */	

@lombok.Builder
@lombok.Value
@lombok.experimental.Accessors(fluent = true)
public class Settings {
		
	//Simulation settings (Time)
	@lombok.Builder.Default
	double timeStep_h = 0.25; //Length of the simulation timestep in Hr	
	@lombok.Builder.Default
	int summerWeekNumber = 18; //Week number of the year where data will be stored for to display a 'default' summerweek
	@lombok.Builder.Default
	int winterWeekNumber = 49; //Week number of the year where data will be stored for to display a 'default' winterweek
	@lombok.Builder.Default
	double simDuration_h = 8760; // (Rapid sim (and Live sim before loop) duration in hours since the start time h.
	
	
	//Simulation settings (Startup)
	boolean reloadDatabase; // Reloads the excels into the project database
	boolean createCurrentElectricityEA; // Create current Electric assets if a real electricity profile or total is present. 
										//--> Put on 'false' to prevent electric assets from being made on top of real 
										//electricity total or profile, to prevent wrong energy totals.
	boolean runHeadlessAtStartup;// Runs year simulation on starting of the model
	@lombok.Builder.Default
	OL_GridNodeProfileLoaderType gridNodeProfileLoaderType = OL_GridNodeProfileLoaderType.NET_LOAD;
	
	
	//Simulation settings (UI)
	Boolean showKPISummary;		// Setting used to active the KPI summary of the resultsUI. If on true, it will be shown after a year simulation
	ArrayList<String> subscopesToSimulate;	// Selected subscopes to simulate (used for larger models that have memory/speed problems).
	OL_RadioButtonSetup resultsUIRadioButtonSetup; // Selected (radiobuttons -> graphs) setup for the resultsUI. 
	List<OL_ChartTypes> resultsUISelectedChartTypes_Energy; // Selected (Energy) charts setup for the resultsUI. 
	List<OL_ChartTypes> resultsUISelectedChartTypes_Economic; // Selected (Economic) charts setup for the resultsUI. 
	
	boolean isPublicModel; // Boolean used to control if the model should be ran in a public version mode:
							// Connection owners where dataSharingAgreed = false, cant be clicked. Just like low level gridnodes.
	List<OL_MapOverlayTypes> activeMapOverlayTypes; //If defined it will override the default map overlay setup as defined in the generic interface/loader.
													//Add all map overlays to this list that you want to be usable in the simulation
} 
