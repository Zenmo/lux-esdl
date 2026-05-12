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

import java.time.Instant;

/**
 * J_ModelSave
 */	
public class J_ModelSave implements Serializable {
	
	public Instant projectDataLastModifiedDate;
	public String[] zorm_project_names;
	
	public EnergyModel energyModel;
	public ArrayList<GridNode> c_gridNodes = new ArrayList<GridNode>();
	public ArrayList<GIS_Object> c_GISObjects = new ArrayList<GIS_Object>();
	
	public ArrayList<GCUtility> c_orderedPVSystemsCompanies;
	public ArrayList<GCHouse> c_orderedPVSystemsHouses;
	public ArrayList<J_EA> c_orderedVehicles;
	public ArrayList<GCUtility> c_orderedHeatingSystemsCompanies;
	public ArrayList<GCHouse> c_orderedHeatingSystemsHouses;
	public ArrayList<J_EAFuelVehicle> c_orderedActiveVehiclesPublicParking;
	public ArrayList<J_EAFuelVehicle> c_orderedNonActiveVehiclesPublicParking;
	public ArrayList<I_Vehicle> c_orderedVehiclesPrivateParking;
	public ArrayList<GIS_Object> c_orderedParkingSpaces;
	
	public ArrayList<GCPublicCharger> c_orderedV1GChargers;
	public ArrayList<GCPublicCharger> c_orderedV2GChargers;
	public ArrayList<GCPublicCharger> c_orderedPublicChargers;

	public LinkedHashMap<String, List<J_EAFuelVehicle>> c_mappingOfVehiclesPerCharger;
	public LinkedHashMap<String, J_scenario_Current> c_scenarioMap_Current;
	public LinkedHashMap<String, J_scenario_Future> c_scenarioMap_Future;
	
	public LinkedHashMap<String, List<I_Vehicle>> c_additionalVehicleHashMaps;
	
    /**
     * Default constructor
     */
    public J_ModelSave() {
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
