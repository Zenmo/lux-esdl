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

import java.awt.geom.Arc2D;

//import kotlinx.serialization.internal.ArrayListClassDesc;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import java.math.BigDecimal; 

public class UI_company extends Agent
{
  // Parameters

  public 
String  p_companyName;

  /**
   * Returns default value for parameter <code>p_companyName</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_companyName_DefaultValue_xjal() {
    final UI_company self = this;
    return null;
  }

  public void set_p_companyName( String value ) {
    if (value == this.p_companyName) {
      return;
    }
    String _oldValue_xjal = this.p_companyName;
    this.p_companyName = value;
    onChange_p_companyName_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_companyName.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_companyName()</code> method instead.
   */
  protected void onChange_p_companyName() {
    onChange_p_companyName_xjal( p_companyName );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_companyName_xjal( String oldValue ) {  
  }


  /**
   * Amount of vehicles that can additionally be added on the already existing ones
   */
  public 
int  p_maxAddedVehicles;

  /**
   * Returns default value for parameter <code>p_maxAddedVehicles</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _p_maxAddedVehicles_DefaultValue_xjal() {
    final UI_company self = this;
    return 
20 
;
  }

  public void set_p_maxAddedVehicles( int value ) {
    if (value == this.p_maxAddedVehicles) {
      return;
    }
    int _oldValue_xjal = this.p_maxAddedVehicles;
    this.p_maxAddedVehicles = value;
    onChange_p_maxAddedVehicles_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_maxAddedVehicles.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_maxAddedVehicles()</code> method instead.
   */
  protected void onChange_p_maxAddedVehicles() {
    onChange_p_maxAddedVehicles_xjal( p_maxAddedVehicles );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_maxAddedVehicles_xjal( int oldValue ) {  
  }


  public 
J_scenario_Current  p_scenarioSettings_Current;

  /**
   * Returns default value for parameter <code>p_scenarioSettings_Current</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_scenario_Current _p_scenarioSettings_Current_DefaultValue_xjal() {
    final UI_company self = this;
    return null;
  }

  public void set_p_scenarioSettings_Current( J_scenario_Current value ) {
    if (value == this.p_scenarioSettings_Current) {
      return;
    }
    J_scenario_Current _oldValue_xjal = this.p_scenarioSettings_Current;
    this.p_scenarioSettings_Current = value;
    onChange_p_scenarioSettings_Current_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_scenarioSettings_Current.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_scenarioSettings_Current()</code> method instead.
   */
  protected void onChange_p_scenarioSettings_Current() {
    onChange_p_scenarioSettings_Current_xjal( p_scenarioSettings_Current );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_scenarioSettings_Current_xjal( J_scenario_Current oldValue ) {  
  }


  public 
J_scenario_Future  p_scenarioSettings_Future;

  /**
   * Returns default value for parameter <code>p_scenarioSettings_Future</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_scenario_Future _p_scenarioSettings_Future_DefaultValue_xjal() {
    final UI_company self = this;
    return null;
  }

  public void set_p_scenarioSettings_Future( J_scenario_Future value ) {
    if (value == this.p_scenarioSettings_Future) {
      return;
    }
    J_scenario_Future _oldValue_xjal = this.p_scenarioSettings_Future;
    this.p_scenarioSettings_Future = value;
    onChange_p_scenarioSettings_Future_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_scenarioSettings_Future.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_scenarioSettings_Future()</code> method instead.
   */
  protected void onChange_p_scenarioSettings_Future() {
    onChange_p_scenarioSettings_Future_xjal( p_scenarioSettings_Future );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_scenarioSettings_Future_xjal( J_scenario_Future oldValue ) {  
  }


  public 
GridConnection  p_gridConnection;

  /**
   * Returns default value for parameter <code>p_gridConnection</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public GridConnection _p_gridConnection_DefaultValue_xjal() {
    final UI_company self = this;
    return null;
  }

  public void set_p_gridConnection( GridConnection value ) {
    if (value == this.p_gridConnection) {
      return;
    }
    GridConnection _oldValue_xjal = this.p_gridConnection;
    this.p_gridConnection = value;
    onChange_p_gridConnection_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_gridConnection.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_gridConnection()</code> method instead.
   */
  protected void onChange_p_gridConnection() {
    onChange_p_gridConnection_xjal( p_gridConnection );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_gridConnection_xjal( GridConnection oldValue ) {  
  }


  public 
double  p_maxSavingsSliders_default;

  /**
   * Returns default value for parameter <code>p_maxSavingsSliders_default</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_maxSavingsSliders_default_DefaultValue_xjal() {
    final UI_company self = this;
    return 
50 
;
  }

  public void set_p_maxSavingsSliders_default( double value ) {
    if (value == this.p_maxSavingsSliders_default) {
      return;
    }
    double _oldValue_xjal = this.p_maxSavingsSliders_default;
    this.p_maxSavingsSliders_default = value;
    onChange_p_maxSavingsSliders_default_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_maxSavingsSliders_default.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_maxSavingsSliders_default()</code> method instead.
   */
  protected void onChange_p_maxSavingsSliders_default() {
    onChange_p_maxSavingsSliders_default_xjal( p_maxSavingsSliders_default );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_maxSavingsSliders_default_xjal( double oldValue ) {  
  }


  public 
double  p_minSavingsSliders_default;

  /**
   * Returns default value for parameter <code>p_minSavingsSliders_default</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_minSavingsSliders_default_DefaultValue_xjal() {
    final UI_company self = this;
    return 
-50 
;
  }

  public void set_p_minSavingsSliders_default( double value ) {
    if (value == this.p_minSavingsSliders_default) {
      return;
    }
    double _oldValue_xjal = this.p_minSavingsSliders_default;
    this.p_minSavingsSliders_default = value;
    onChange_p_minSavingsSliders_default_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_minSavingsSliders_default.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_minSavingsSliders_default()</code> method instead.
   */
  protected void onChange_p_minSavingsSliders_default() {
    onChange_p_minSavingsSliders_default_xjal( p_minSavingsSliders_default );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_minSavingsSliders_default_xjal( double oldValue ) {  
  }


  public 
ShapeRectangle[][]  matrix_vehicleTripsConfigurationButtons;

  /**
   * Returns default value for parameter <code>matrix_vehicleTripsConfigurationButtons</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ShapeRectangle[][] _matrix_vehicleTripsConfigurationButtons_DefaultValue_xjal() {
    final UI_company self = this;
    return new ShapeRectangle[][]
{
    { // Monday (0)
        rect_configureVehicleTrips_monday_0,
        rect_configureVehicleTrips_monday_1,
        rect_configureVehicleTrips_monday_2,
        rect_configureVehicleTrips_monday_3,
        rect_configureVehicleTrips_monday_4,
        rect_configureVehicleTrips_monday_5,
        rect_configureVehicleTrips_monday_6,
        rect_configureVehicleTrips_monday_7,
        rect_configureVehicleTrips_monday_8,
        rect_configureVehicleTrips_monday_9,
        rect_configureVehicleTrips_monday_10,
        rect_configureVehicleTrips_monday_11,
        rect_configureVehicleTrips_monday_12,
        rect_configureVehicleTrips_monday_13,
        rect_configureVehicleTrips_monday_14,
        rect_configureVehicleTrips_monday_15,
        rect_configureVehicleTrips_monday_16,
        rect_configureVehicleTrips_monday_17,
        rect_configureVehicleTrips_monday_18,
        rect_configureVehicleTrips_monday_19,
        rect_configureVehicleTrips_monday_20,
        rect_configureVehicleTrips_monday_21,
        rect_configureVehicleTrips_monday_22,
        rect_configureVehicleTrips_monday_23
    },
    { // Tuesday (1)
        rect_configureVehicleTrips_tuesday_0,
        rect_configureVehicleTrips_tuesday_1,
        rect_configureVehicleTrips_tuesday_2,
        rect_configureVehicleTrips_tuesday_3,
        rect_configureVehicleTrips_tuesday_4,
        rect_configureVehicleTrips_tuesday_5,
        rect_configureVehicleTrips_tuesday_6,
        rect_configureVehicleTrips_tuesday_7,
        rect_configureVehicleTrips_tuesday_8,
        rect_configureVehicleTrips_tuesday_9,
        rect_configureVehicleTrips_tuesday_10,
        rect_configureVehicleTrips_tuesday_11,
        rect_configureVehicleTrips_tuesday_12,
        rect_configureVehicleTrips_tuesday_13,
        rect_configureVehicleTrips_tuesday_14,
        rect_configureVehicleTrips_tuesday_15,
        rect_configureVehicleTrips_tuesday_16,
        rect_configureVehicleTrips_tuesday_17,
        rect_configureVehicleTrips_tuesday_18,
        rect_configureVehicleTrips_tuesday_19,
        rect_configureVehicleTrips_tuesday_20,
        rect_configureVehicleTrips_tuesday_21,
        rect_configureVehicleTrips_tuesday_22,
        rect_configureVehicleTrips_tuesday_23
    },
    { // Wednesday (2)
        rect_configureVehicleTrips_wednesday_0,
        rect_configureVehicleTrips_wednesday_1,
        rect_configureVehicleTrips_wednesday_2,
        rect_configureVehicleTrips_wednesday_3,
        rect_configureVehicleTrips_wednesday_4,
        rect_configureVehicleTrips_wednesday_5,
        rect_configureVehicleTrips_wednesday_6,
        rect_configureVehicleTrips_wednesday_7,
        rect_configureVehicleTrips_wednesday_8,
        rect_configureVehicleTrips_wednesday_9,
        rect_configureVehicleTrips_wednesday_10,
        rect_configureVehicleTrips_wednesday_11,
        rect_configureVehicleTrips_wednesday_12,
        rect_configureVehicleTrips_wednesday_13,
        rect_configureVehicleTrips_wednesday_14,
        rect_configureVehicleTrips_wednesday_15,
        rect_configureVehicleTrips_wednesday_16,
        rect_configureVehicleTrips_wednesday_17,
        rect_configureVehicleTrips_wednesday_18,
        rect_configureVehicleTrips_wednesday_19,
        rect_configureVehicleTrips_wednesday_20,
        rect_configureVehicleTrips_wednesday_21,
        rect_configureVehicleTrips_wednesday_22,
        rect_configureVehicleTrips_wednesday_23
    },
    { // Thursday (3)
        rect_configureVehicleTrips_thursday_0,
        rect_configureVehicleTrips_thursday_1,
        rect_configureVehicleTrips_thursday_2,
        rect_configureVehicleTrips_thursday_3,
        rect_configureVehicleTrips_thursday_4,
        rect_configureVehicleTrips_thursday_5,
        rect_configureVehicleTrips_thursday_6,
        rect_configureVehicleTrips_thursday_7,
        rect_configureVehicleTrips_thursday_8,
        rect_configureVehicleTrips_thursday_9,
        rect_configureVehicleTrips_thursday_10,
        rect_configureVehicleTrips_thursday_11,
        rect_configureVehicleTrips_thursday_12,
        rect_configureVehicleTrips_thursday_13,
        rect_configureVehicleTrips_thursday_14,
        rect_configureVehicleTrips_thursday_15,
        rect_configureVehicleTrips_thursday_16,
        rect_configureVehicleTrips_thursday_17,
        rect_configureVehicleTrips_thursday_18,
        rect_configureVehicleTrips_thursday_19,
        rect_configureVehicleTrips_thursday_20,
        rect_configureVehicleTrips_thursday_21,
        rect_configureVehicleTrips_thursday_22,
        rect_configureVehicleTrips_thursday_23
    },
    { // Friday (4)
        rect_configureVehicleTrips_friday_0,
        rect_configureVehicleTrips_friday_1,
        rect_configureVehicleTrips_friday_2,
        rect_configureVehicleTrips_friday_3,
        rect_configureVehicleTrips_friday_4,
        rect_configureVehicleTrips_friday_5,
        rect_configureVehicleTrips_friday_6,
        rect_configureVehicleTrips_friday_7,
        rect_configureVehicleTrips_friday_8,
        rect_configureVehicleTrips_friday_9,
        rect_configureVehicleTrips_friday_10,
        rect_configureVehicleTrips_friday_11,
        rect_configureVehicleTrips_friday_12,
        rect_configureVehicleTrips_friday_13,
        rect_configureVehicleTrips_friday_14,
        rect_configureVehicleTrips_friday_15,
        rect_configureVehicleTrips_friday_16,
        rect_configureVehicleTrips_friday_17,
        rect_configureVehicleTrips_friday_18,
        rect_configureVehicleTrips_friday_19,
        rect_configureVehicleTrips_friday_20,
        rect_configureVehicleTrips_friday_21,
        rect_configureVehicleTrips_friday_22,
        rect_configureVehicleTrips_friday_23
    },
    { // Saturday (5)
        rect_configureVehicleTrips_saturday_0,
        rect_configureVehicleTrips_saturday_1,
        rect_configureVehicleTrips_saturday_2,
        rect_configureVehicleTrips_saturday_3,
        rect_configureVehicleTrips_saturday_4,
        rect_configureVehicleTrips_saturday_5,
        rect_configureVehicleTrips_saturday_6,
        rect_configureVehicleTrips_saturday_7,
        rect_configureVehicleTrips_saturday_8,
        rect_configureVehicleTrips_saturday_9,
        rect_configureVehicleTrips_saturday_10,
        rect_configureVehicleTrips_saturday_11,
        rect_configureVehicleTrips_saturday_12,
        rect_configureVehicleTrips_saturday_13,
        rect_configureVehicleTrips_saturday_14,
        rect_configureVehicleTrips_saturday_15,
        rect_configureVehicleTrips_saturday_16,
        rect_configureVehicleTrips_saturday_17,
        rect_configureVehicleTrips_saturday_18,
        rect_configureVehicleTrips_saturday_19,
        rect_configureVehicleTrips_saturday_20,
        rect_configureVehicleTrips_saturday_21,
        rect_configureVehicleTrips_saturday_22,
        rect_configureVehicleTrips_saturday_23
    },
    { // Sunday (6)
        rect_configureVehicleTrips_sunday_0,
        rect_configureVehicleTrips_sunday_1,
        rect_configureVehicleTrips_sunday_2,
        rect_configureVehicleTrips_sunday_3,
        rect_configureVehicleTrips_sunday_4,
        rect_configureVehicleTrips_sunday_5,
        rect_configureVehicleTrips_sunday_6,
        rect_configureVehicleTrips_sunday_7,
        rect_configureVehicleTrips_sunday_8,
        rect_configureVehicleTrips_sunday_9,
        rect_configureVehicleTrips_sunday_10,
        rect_configureVehicleTrips_sunday_11,
        rect_configureVehicleTrips_sunday_12,
        rect_configureVehicleTrips_sunday_13,
        rect_configureVehicleTrips_sunday_14,
        rect_configureVehicleTrips_sunday_15,
        rect_configureVehicleTrips_sunday_16,
        rect_configureVehicleTrips_sunday_17,
        rect_configureVehicleTrips_sunday_18,
        rect_configureVehicleTrips_sunday_19,
        rect_configureVehicleTrips_sunday_20,
        rect_configureVehicleTrips_sunday_21,
        rect_configureVehicleTrips_sunday_22,
        rect_configureVehicleTrips_sunday_23
    }
} 
;
  }

  public void set_matrix_vehicleTripsConfigurationButtons( ShapeRectangle[][] value ) {
    if (value == this.matrix_vehicleTripsConfigurationButtons) {
      return;
    }
    ShapeRectangle[][] _oldValue_xjal = this.matrix_vehicleTripsConfigurationButtons;
    this.matrix_vehicleTripsConfigurationButtons = value;
    onChange_matrix_vehicleTripsConfigurationButtons_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter matrix_vehicleTripsConfigurationButtons.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_matrix_vehicleTripsConfigurationButtons()</code> method instead.
   */
  protected void onChange_matrix_vehicleTripsConfigurationButtons() {
    onChange_matrix_vehicleTripsConfigurationButtons_xjal( matrix_vehicleTripsConfigurationButtons );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_matrix_vehicleTripsConfigurationButtons_xjal( ShapeRectangle[][] oldValue ) {  
  }


  /**
   * Map of GC_UUID to<br>
   * 	Map<J_TripTracker, Triptracker> New triptracker to original triptracker.<br>
   * -> When new triptracker is replaced again, the newest triptracker should get the original triptracker as value again.
   */
  public 
Map<String, Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips>>  map_customTripTrackerToOriginal;

  /**
   * Returns default value for parameter <code>map_customTripTrackerToOriginal</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<String, Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips>> _map_customTripTrackerToOriginal_DefaultValue_xjal() {
    final UI_company self = this;
    return 
new HashMap<>() 
;
  }

  public void set_map_customTripTrackerToOriginal( Map<String, Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips>> value ) {
    if (value == this.map_customTripTrackerToOriginal) {
      return;
    }
    Map<String, Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips>> _oldValue_xjal = this.map_customTripTrackerToOriginal;
    this.map_customTripTrackerToOriginal = value;
    onChange_map_customTripTrackerToOriginal_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_customTripTrackerToOriginal.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_customTripTrackerToOriginal()</code> method instead.
   */
  protected void onChange_map_customTripTrackerToOriginal() {
    onChange_map_customTripTrackerToOriginal_xjal( map_customTripTrackerToOriginal );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_customTripTrackerToOriginal_xjal( Map<String, Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips>> oldValue ) {  
  }


  /**
   * Map of GC_UUID to<br>
   * 	Map of vehicleType to<br>
   * 		Boolean matrix of created weekly configuration
   */
  public 
Map<String, Map<OL_VehicleType, J_CustomTripTrackerGenerator.StoredTripConfiguration>>  map_storedCustomTripButtonConfiguration;

  /**
   * Returns default value for parameter <code>map_storedCustomTripButtonConfiguration</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<String, Map<OL_VehicleType, J_CustomTripTrackerGenerator.StoredTripConfiguration>> _map_storedCustomTripButtonConfiguration_DefaultValue_xjal() {
    final UI_company self = this;
    return 
new HashMap<>() 
;
  }

  public void set_map_storedCustomTripButtonConfiguration( Map<String, Map<OL_VehicleType, J_CustomTripTrackerGenerator.StoredTripConfiguration>> value ) {
    if (value == this.map_storedCustomTripButtonConfiguration) {
      return;
    }
    Map<String, Map<OL_VehicleType, J_CustomTripTrackerGenerator.StoredTripConfiguration>> _oldValue_xjal = this.map_storedCustomTripButtonConfiguration;
    this.map_storedCustomTripButtonConfiguration = value;
    onChange_map_storedCustomTripButtonConfiguration_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_storedCustomTripButtonConfiguration.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_storedCustomTripButtonConfiguration()</code> method instead.
   */
  protected void onChange_map_storedCustomTripButtonConfiguration() {
    onChange_map_storedCustomTripButtonConfiguration_xjal( map_storedCustomTripButtonConfiguration );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_storedCustomTripButtonConfiguration_xjal( Map<String, Map<OL_VehicleType, J_CustomTripTrackerGenerator.StoredTripConfiguration>> oldValue ) {  
  }


  public 
boolean[][]  matrix_defaultValuesCustomTripButtons;

  /**
   * Returns default value for parameter <code>matrix_defaultValuesCustomTripButtons</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean[][] _matrix_defaultValuesCustomTripButtons_DefaultValue_xjal() {
    final UI_company self = this;
    return new boolean[][]
{
	//  0      1      2      3      4      5      6      7      8      9      10     11     12     13     14     15     16     17     18     19     20     21     22     23
	{ false, false, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, false },
	{ false, false, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, false },
	{ false, false, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, false },
	{ false, false, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, false },
	{ false, false, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, false },
	{ false, false, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, false },
	{ false, false, false, false, false, false, false, false, true,  true,  true,  true,  true,  true,  true,  true,  true,  false, false, false, false, false, false, false }
} 
;
  }

  public void set_matrix_defaultValuesCustomTripButtons( boolean[][] value ) {
    if (value == this.matrix_defaultValuesCustomTripButtons) {
      return;
    }
    boolean[][] _oldValue_xjal = this.matrix_defaultValuesCustomTripButtons;
    this.matrix_defaultValuesCustomTripButtons = value;
    onChange_matrix_defaultValuesCustomTripButtons_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter matrix_defaultValuesCustomTripButtons.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_matrix_defaultValuesCustomTripButtons()</code> method instead.
   */
  protected void onChange_matrix_defaultValuesCustomTripButtons() {
    onChange_matrix_defaultValuesCustomTripButtons_xjal( matrix_defaultValuesCustomTripButtons );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_matrix_defaultValuesCustomTripButtons_xjal( boolean[][] oldValue ) {  
  }


  public 
Map<OL_Days, ShapeCheckBox>  map_dayToEnableDayButtons;

  /**
   * Returns default value for parameter <code>map_dayToEnableDayButtons</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_Days, ShapeCheckBox> _map_dayToEnableDayButtons_DefaultValue_xjal() {
    final UI_company self = this;
    return 
Map.ofEntries(
	Map.entry(OL_Days.MONDAY, cb_configureVehicleTripsMonday),
	Map.entry(OL_Days.TUESDAY,cb_configureVehicleTripsTuesday),
	Map.entry(OL_Days.WEDNESDAY, cb_configureVehicleTripsWednesday),
	Map.entry(OL_Days.THURSDAY, cb_configureVehicleTripsThursday),
	Map.entry(OL_Days.FRIDAY, cb_configureVehicleTripsFriday),
	Map.entry(OL_Days.SATURDAY, cb_configureVehicleTripsSaturday),
	Map.entry(OL_Days.SUNDAY, cb_configureVehicleTripsSunday)
) 
;
  }

  public void set_map_dayToEnableDayButtons( Map<OL_Days, ShapeCheckBox> value ) {
    if (value == this.map_dayToEnableDayButtons) {
      return;
    }
    Map<OL_Days, ShapeCheckBox> _oldValue_xjal = this.map_dayToEnableDayButtons;
    this.map_dayToEnableDayButtons = value;
    onChange_map_dayToEnableDayButtons_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_dayToEnableDayButtons.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_dayToEnableDayButtons()</code> method instead.
   */
  protected void onChange_map_dayToEnableDayButtons() {
    onChange_map_dayToEnableDayButtons_xjal( map_dayToEnableDayButtons );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_dayToEnableDayButtons_xjal( Map<OL_Days, ShapeCheckBox> oldValue ) {  
  }


  public 
Color  p_configureVehicleTripsOnColor;

  /**
   * Returns default value for parameter <code>p_configureVehicleTripsOnColor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Color _p_configureVehicleTripsOnColor_DefaultValue_xjal() {
    final UI_company self = this;
    return 
new Color(252, 194, 0) 
;
  }

  public void set_p_configureVehicleTripsOnColor( Color value ) {
    if (value == this.p_configureVehicleTripsOnColor) {
      return;
    }
    Color _oldValue_xjal = this.p_configureVehicleTripsOnColor;
    this.p_configureVehicleTripsOnColor = value;
    onChange_p_configureVehicleTripsOnColor_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_configureVehicleTripsOnColor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_configureVehicleTripsOnColor()</code> method instead.
   */
  protected void onChange_p_configureVehicleTripsOnColor() {
    onChange_p_configureVehicleTripsOnColor_xjal( p_configureVehicleTripsOnColor );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_configureVehicleTripsOnColor_xjal( Color oldValue ) {  
  }


  public 
Color  p_configureVehicleTripsOffColor;

  /**
   * Returns default value for parameter <code>p_configureVehicleTripsOffColor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Color _p_configureVehicleTripsOffColor_DefaultValue_xjal() {
    final UI_company self = this;
    return 
white 
;
  }

  public void set_p_configureVehicleTripsOffColor( Color value ) {
    if (value == this.p_configureVehicleTripsOffColor) {
      return;
    }
    Color _oldValue_xjal = this.p_configureVehicleTripsOffColor;
    this.p_configureVehicleTripsOffColor = value;
    onChange_p_configureVehicleTripsOffColor_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_configureVehicleTripsOffColor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_configureVehicleTripsOffColor()</code> method instead.
   */
  protected void onChange_p_configureVehicleTripsOffColor() {
    onChange_p_configureVehicleTripsOffColor_xjal( p_configureVehicleTripsOffColor );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_configureVehicleTripsOffColor_xjal( Color oldValue ) {  
  }


  public 
Map<OL_Days, ShapeGroup>  map_dayToDisableRectangles;

  /**
   * Returns default value for parameter <code>map_dayToDisableRectangles</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_Days, ShapeGroup> _map_dayToDisableRectangles_DefaultValue_xjal() {
    final UI_company self = this;
    return null;
  }

  public void set_map_dayToDisableRectangles( Map<OL_Days, ShapeGroup> value ) {
    if (value == this.map_dayToDisableRectangles) {
      return;
    }
    Map<OL_Days, ShapeGroup> _oldValue_xjal = this.map_dayToDisableRectangles;
    this.map_dayToDisableRectangles = value;
    onChange_map_dayToDisableRectangles_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_dayToDisableRectangles.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_dayToDisableRectangles()</code> method instead.
   */
  protected void onChange_map_dayToDisableRectangles() {
    onChange_map_dayToDisableRectangles_xjal( map_dayToDisableRectangles );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_dayToDisableRectangles_xjal( Map<OL_Days, ShapeGroup> oldValue ) {  
  }


  /**
   * Map of GC_UUID to<br>
   * 	Map of vehicleType to<br>
   * 		Boolean matrix of created weekly configuration
   */
  public 
Map<String, Map<OL_VehicleType, List<J_ActivityTrackerTrips.TripRecord>>>  map_createdCustomTripWeeklyConfiguration;

  /**
   * Returns default value for parameter <code>map_createdCustomTripWeeklyConfiguration</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<String, Map<OL_VehicleType, List<J_ActivityTrackerTrips.TripRecord>>> _map_createdCustomTripWeeklyConfiguration_DefaultValue_xjal() {
    final UI_company self = this;
    return 
new HashMap<>() 
;
  }

  public void set_map_createdCustomTripWeeklyConfiguration( Map<String, Map<OL_VehicleType, List<J_ActivityTrackerTrips.TripRecord>>> value ) {
    if (value == this.map_createdCustomTripWeeklyConfiguration) {
      return;
    }
    Map<String, Map<OL_VehicleType, List<J_ActivityTrackerTrips.TripRecord>>> _oldValue_xjal = this.map_createdCustomTripWeeklyConfiguration;
    this.map_createdCustomTripWeeklyConfiguration = value;
    onChange_map_createdCustomTripWeeklyConfiguration_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_createdCustomTripWeeklyConfiguration.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_createdCustomTripWeeklyConfiguration()</code> method instead.
   */
  protected void onChange_map_createdCustomTripWeeklyConfiguration() {
    onChange_map_createdCustomTripWeeklyConfiguration_xjal( map_createdCustomTripWeeklyConfiguration );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_createdCustomTripWeeklyConfiguration_xjal( Map<String, Map<OL_VehicleType, List<J_ActivityTrackerTrips.TripRecord>>> oldValue ) {  
  }


  public 
double  p_defaultTravelDistance_km;

  /**
   * Returns default value for parameter <code>p_defaultTravelDistance_km</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_defaultTravelDistance_km_DefaultValue_xjal() {
    final UI_company self = this;
    return 
200 
;
  }

  public void set_p_defaultTravelDistance_km( double value ) {
    if (value == this.p_defaultTravelDistance_km) {
      return;
    }
    double _oldValue_xjal = this.p_defaultTravelDistance_km;
    this.p_defaultTravelDistance_km = value;
    onChange_p_defaultTravelDistance_km_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultTravelDistance_km.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultTravelDistance_km()</code> method instead.
   */
  protected void onChange_p_defaultTravelDistance_km() {
    onChange_p_defaultTravelDistance_km_xjal( p_defaultTravelDistance_km );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultTravelDistance_km_xjal( double oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_companyName = _p_companyName_DefaultValue_xjal();
    p_maxAddedVehicles = _p_maxAddedVehicles_DefaultValue_xjal();
    p_scenarioSettings_Current = _p_scenarioSettings_Current_DefaultValue_xjal();
    p_scenarioSettings_Future = _p_scenarioSettings_Future_DefaultValue_xjal();
    p_gridConnection = _p_gridConnection_DefaultValue_xjal();
    p_maxSavingsSliders_default = _p_maxSavingsSliders_default_DefaultValue_xjal();
    p_minSavingsSliders_default = _p_minSavingsSliders_default_DefaultValue_xjal();
    matrix_vehicleTripsConfigurationButtons = _matrix_vehicleTripsConfigurationButtons_DefaultValue_xjal();
    map_customTripTrackerToOriginal = _map_customTripTrackerToOriginal_DefaultValue_xjal();
    map_storedCustomTripButtonConfiguration = _map_storedCustomTripButtonConfiguration_DefaultValue_xjal();
    matrix_defaultValuesCustomTripButtons = _matrix_defaultValuesCustomTripButtons_DefaultValue_xjal();
    map_dayToEnableDayButtons = _map_dayToEnableDayButtons_DefaultValue_xjal();
    p_configureVehicleTripsOnColor = _p_configureVehicleTripsOnColor_DefaultValue_xjal();
    p_configureVehicleTripsOffColor = _p_configureVehicleTripsOffColor_DefaultValue_xjal();
    map_dayToDisableRectangles = _map_dayToDisableRectangles_DefaultValue_xjal();
    map_createdCustomTripWeeklyConfiguration = _map_createdCustomTripWeeklyConfiguration_DefaultValue_xjal();
    p_defaultTravelDistance_km = _p_defaultTravelDistance_km_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_companyName":
      if ( _callOnChange_xjal ) {
        set_p_companyName( (String) _value_xjal );
      } else {
        p_companyName = (String) _value_xjal;
      }
      return true;
    case "p_maxAddedVehicles":
      if ( _callOnChange_xjal ) {
        set_p_maxAddedVehicles( ((Number) _value_xjal).intValue() );
      } else {
        p_maxAddedVehicles = ((Number) _value_xjal).intValue();
      }
      return true;
    case "p_scenarioSettings_Current":
      if ( _callOnChange_xjal ) {
        set_p_scenarioSettings_Current( (J_scenario_Current) _value_xjal );
      } else {
        p_scenarioSettings_Current = (J_scenario_Current) _value_xjal;
      }
      return true;
    case "p_scenarioSettings_Future":
      if ( _callOnChange_xjal ) {
        set_p_scenarioSettings_Future( (J_scenario_Future) _value_xjal );
      } else {
        p_scenarioSettings_Future = (J_scenario_Future) _value_xjal;
      }
      return true;
    case "p_gridConnection":
      if ( _callOnChange_xjal ) {
        set_p_gridConnection( (GridConnection) _value_xjal );
      } else {
        p_gridConnection = (GridConnection) _value_xjal;
      }
      return true;
    case "p_maxSavingsSliders_default":
      if ( _callOnChange_xjal ) {
        set_p_maxSavingsSliders_default( ((Number) _value_xjal).doubleValue() );
      } else {
        p_maxSavingsSliders_default = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_minSavingsSliders_default":
      if ( _callOnChange_xjal ) {
        set_p_minSavingsSliders_default( ((Number) _value_xjal).doubleValue() );
      } else {
        p_minSavingsSliders_default = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "matrix_vehicleTripsConfigurationButtons":
      if ( _callOnChange_xjal ) {
        set_matrix_vehicleTripsConfigurationButtons( (ShapeRectangle[][]) _value_xjal );
      } else {
        matrix_vehicleTripsConfigurationButtons = (ShapeRectangle[][]) _value_xjal;
      }
      return true;
    case "map_customTripTrackerToOriginal":
      if ( _callOnChange_xjal ) {
        set_map_customTripTrackerToOriginal( (Map<String, Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips>>) _value_xjal );
      } else {
        map_customTripTrackerToOriginal = (Map<String, Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips>>) _value_xjal;
      }
      return true;
    case "map_storedCustomTripButtonConfiguration":
      if ( _callOnChange_xjal ) {
        set_map_storedCustomTripButtonConfiguration( (Map<String, Map<OL_VehicleType, J_CustomTripTrackerGenerator.StoredTripConfiguration>>) _value_xjal );
      } else {
        map_storedCustomTripButtonConfiguration = (Map<String, Map<OL_VehicleType, J_CustomTripTrackerGenerator.StoredTripConfiguration>>) _value_xjal;
      }
      return true;
    case "matrix_defaultValuesCustomTripButtons":
      if ( _callOnChange_xjal ) {
        set_matrix_defaultValuesCustomTripButtons( (boolean[][]) _value_xjal );
      } else {
        matrix_defaultValuesCustomTripButtons = (boolean[][]) _value_xjal;
      }
      return true;
    case "map_dayToEnableDayButtons":
      if ( _callOnChange_xjal ) {
        set_map_dayToEnableDayButtons( (Map<OL_Days, ShapeCheckBox>) _value_xjal );
      } else {
        map_dayToEnableDayButtons = (Map<OL_Days, ShapeCheckBox>) _value_xjal;
      }
      return true;
    case "p_configureVehicleTripsOnColor":
      if ( _callOnChange_xjal ) {
        set_p_configureVehicleTripsOnColor( (Color) _value_xjal );
      } else {
        p_configureVehicleTripsOnColor = (Color) _value_xjal;
      }
      return true;
    case "p_configureVehicleTripsOffColor":
      if ( _callOnChange_xjal ) {
        set_p_configureVehicleTripsOffColor( (Color) _value_xjal );
      } else {
        p_configureVehicleTripsOffColor = (Color) _value_xjal;
      }
      return true;
    case "map_dayToDisableRectangles":
      if ( _callOnChange_xjal ) {
        set_map_dayToDisableRectangles( (Map<OL_Days, ShapeGroup>) _value_xjal );
      } else {
        map_dayToDisableRectangles = (Map<OL_Days, ShapeGroup>) _value_xjal;
      }
      return true;
    case "map_createdCustomTripWeeklyConfiguration":
      if ( _callOnChange_xjal ) {
        set_map_createdCustomTripWeeklyConfiguration( (Map<String, Map<OL_VehicleType, List<J_ActivityTrackerTrips.TripRecord>>>) _value_xjal );
      } else {
        map_createdCustomTripWeeklyConfiguration = (Map<String, Map<OL_VehicleType, List<J_ActivityTrackerTrips.TripRecord>>>) _value_xjal;
      }
      return true;
    case "p_defaultTravelDistance_km":
      if ( _callOnChange_xjal ) {
        set_p_defaultTravelDistance_km( ((Number) _value_xjal).doubleValue() );
      } else {
        p_defaultTravelDistance_km = ((Number) _value_xjal).doubleValue();
      }
      return true;
    default:
      return super.setParameter( _name_xjal, _value_xjal, _callOnChange_xjal );
    }
  }

  @Override
  public <T> T getParameter(String _name_xjal) {
    Object _result_xjal;
    switch ( _name_xjal ) {
    case "p_companyName": _result_xjal = p_companyName; break;
    case "p_maxAddedVehicles": _result_xjal = p_maxAddedVehicles; break;
    case "p_scenarioSettings_Current": _result_xjal = p_scenarioSettings_Current; break;
    case "p_scenarioSettings_Future": _result_xjal = p_scenarioSettings_Future; break;
    case "p_gridConnection": _result_xjal = p_gridConnection; break;
    case "p_maxSavingsSliders_default": _result_xjal = p_maxSavingsSliders_default; break;
    case "p_minSavingsSliders_default": _result_xjal = p_minSavingsSliders_default; break;
    case "matrix_vehicleTripsConfigurationButtons": _result_xjal = matrix_vehicleTripsConfigurationButtons; break;
    case "map_customTripTrackerToOriginal": _result_xjal = map_customTripTrackerToOriginal; break;
    case "map_storedCustomTripButtonConfiguration": _result_xjal = map_storedCustomTripButtonConfiguration; break;
    case "matrix_defaultValuesCustomTripButtons": _result_xjal = matrix_defaultValuesCustomTripButtons; break;
    case "map_dayToEnableDayButtons": _result_xjal = map_dayToEnableDayButtons; break;
    case "p_configureVehicleTripsOnColor": _result_xjal = p_configureVehicleTripsOnColor; break;
    case "p_configureVehicleTripsOffColor": _result_xjal = p_configureVehicleTripsOffColor; break;
    case "map_dayToDisableRectangles": _result_xjal = map_dayToDisableRectangles; break;
    case "map_createdCustomTripWeeklyConfiguration": _result_xjal = map_createdCustomTripWeeklyConfiguration; break;
    case "p_defaultTravelDistance_km": _result_xjal = p_defaultTravelDistance_km; break;
    default: _result_xjal = super.getParameter( _name_xjal ); break;
    }
    return (T) _result_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private static String[] _parameterNames_xjal;

  @Override
  public String[] getParameterNames() {
    String[] result = _parameterNames_xjal;
    if (result == null) {
      List<String> list = new ArrayList<>( Arrays.asList( super.getParameterNames() ) );
      list.add( "p_companyName" );
      list.add( "p_maxAddedVehicles" );
      list.add( "p_scenarioSettings_Current" );
      list.add( "p_scenarioSettings_Future" );
      list.add( "p_gridConnection" );
      list.add( "p_maxSavingsSliders_default" );
      list.add( "p_minSavingsSliders_default" );
      list.add( "matrix_vehicleTripsConfigurationButtons" );
      list.add( "map_customTripTrackerToOriginal" );
      list.add( "map_storedCustomTripButtonConfiguration" );
      list.add( "matrix_defaultValuesCustomTripButtons" );
      list.add( "map_dayToEnableDayButtons" );
      list.add( "p_configureVehicleTripsOnColor" );
      list.add( "p_configureVehicleTripsOffColor" );
      list.add( "map_dayToDisableRectangles" );
      list.add( "map_createdCustomTripWeeklyConfiguration" );
      list.add( "p_defaultTravelDistance_km" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
String 
 v_adressGC;
  public 
double 
 v_physicalConnectionCapacity_kW;
  public 
double 
 v_NFATO_kW_delivery;
  public 
double 
 v_NFATO_kW_feedin;
  public 
boolean 
 v_NFATO_active;
  private 
OL_VehicleType 
 v_currentTripConfiguringVehicleType;
  public 
Color 
 v_companyUIBackgroundColor;
  public 
Color 
 v_companyUILineColor;
  public 
double 
 v_minPVSlider;
  public 
double 
 v_maxPVSlider;
  public 
double 
 v_defaultPVSlider;
  public 
double 
 v_minBatSlider;
  public 
double 
 v_maxBatSlider;
  public 
double 
 v_defaultBatSlider;
  public 
int 
 v_nbEVCars;
  public 
int 
 v_nbHydrogenCars;
  public 
int 
 v_nbPetroleumFuelCars;
  public 
int 
 v_nbEVVans;
  public 
int 
 v_nbEVTrucks;
  public 
int 
 v_nbPetroleumFuelVans;
  public 
int 
 v_nbPetroleumFuelTrucks;
  public 
int 
 v_nbHydrogenVans;
  public 
int 
 v_nbHydrogenTrucks;
  public 
int 
 v_minEVCarSlider;
  public 
int 
 v_minHydrogenCarSlider;
  public 
int 
 v_maxEVCarSlider;
  public 
int 
 v_minPetroleumFuelCarSlider;
  public 
int 
 v_maxHydrogenCarSlider;
  public 
int 
 v_maxPetroleumFuelCarSlider;
  public 
int 
 v_minEVVanSlider;
  public 
int 
 v_minHydrogenVanSlider;
  public 
int 
 v_maxEVVanSlider;
  public 
int 
 v_minPetroleumFuelVanSlider;
  public 
int 
 v_maxHydrogenVanSlider;
  public 
int 
 v_maxPetroleumFuelVanSlider;
  public 
int 
 v_minEVTruckSlider;
  public 
int 
 v_minHydrogenTruckSlider;
  public 
int 
 v_maxEVTruckSlider;
  public 
int 
 v_minPetroleumFuelTruckSlider;
  public 
int 
 v_maxPetroleumFuelTruckSlider;
  public 
int 
 v_maxHydrogenTruckSlider;
  public 
Color 
 v_chartBackgroundColor;
  public 
double 
 v_companyUILineWidth;
  public 
double 
 v_chartLineWidth;
  public 
Color 
 v_companyUIBackgroundColorSliders;
  public 
Color 
 v_loadScreenColor;
  public 
double 
 v_minContractDeliveryCapacity_kW;
  public 
double 
 v_maxContractDeliveryCapacity_kW;
  public 
double 
 v_defaultContractDeliveryCapacity_kW;
  public 
boolean 
 b_runningMainInterfaceScenarioSettings;
  public 
double 
 v_minContractFeedinCapacity_kW;
  public 
double 
 v_maxContractFeedinCapacity_kW;
  public 
double 
 v_defaultContractFeedinCapacity_kW;
  public 
boolean 
 b_runningMainInterfaceSlider;
  public 
double 
 v_minSavingsSliders;
  public 
double 
 v_maxSavingsSliders;

  // Collection Variables
  public 
LinkedHashSet <
OL_Days > c_activeVehicleConfigurationDays = new LinkedHashSet<OL_Days>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( UI_company.class );

  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 10.0 );

  @Override
  public Scale getScale() {
    return scale;
  }




  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Embedded Objects

  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _uI_Results_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  public digital_twin_results.UI_Results uI_Results;

  public String getNameOf( Agent ao ) {
    if ( ao == uI_Results ) return "uI_Results";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    if ( ao == uI_Results ) return _uI_Results_animationSettings_xjal;
    return super.getAnimationSettingsOf( ao );
  }


  public String getNameOf( AgentList<?> aolist ) {
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    return super.getAnimationSettingsOf( aolist );
  }


  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected digital_twin_results.UI_Results instantiate_uI_Results_xjal() {
    digital_twin_results.UI_Results _result_xjal = new digital_twin_results.UI_Results( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_uI_Results_xjal( final digital_twin_results.UI_Results self, TableInput _t ) {
    self.energyModel = 
zero_Interface.energyModel 
;
    self.p_cutOff_MWh = self._p_cutOff_MWh_DefaultValue_xjal();
    self.gr_infoText = self._gr_infoText_DefaultValue_xjal();
    self.gr_closeInfoText = self._gr_closeInfoText_DefaultValue_xjal();
    self.t_infoTextDescription = self._t_infoTextDescription_DefaultValue_xjal();
    self.rect_infoText = self._rect_infoText_DefaultValue_xjal();
    self.p_currentActiveInfoBubble = self._p_currentActiveInfoBubble_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_uI_Results_xjal( digital_twin_results.UI_Results self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 380.0
;
double _y_xjal = 220.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }

  // Functions

  void f_setScenarioFuture(  ) { 

//Set button to custom early on, so traceln will get ignored.
rb_scenariosPrivateUI.setValue(2, false);


////Heating

//Heating savings
sl_heatDemandCompanyReduction.setValue(p_scenarioSettings_Future.getPlannedHeatSavings_pct(), true);

//Heating type (aangenomen dat het hetzelfde blijft, want hebben geen vraag die dat stelt in het formulier)
int nr_currentHeatingType = 0;
switch (p_scenarioSettings_Future.getPlannedHeatingType()){
	case GAS_BURNER:
		nr_currentHeatingType = 0;
		break;

	case HYBRID_HEATPUMP:
		nr_currentHeatingType = 1;
		break;

	case ELECTRIC_HEATPUMP:
		nr_currentHeatingType = 2;
		break;
		
	//case HYDROGENBURNER:
	case DISTRICTHEAT:
		nr_currentHeatingType = 3;
		break;

	case GAS_CHP:
		nr_currentHeatingType = 4;
		break;
		
	default:
}
rb_heatingTypePrivateUI.setValue(nr_currentHeatingType, true);		


////Electricity

//Electricity savings
sl_electricityDemandCompanyReduction.setValue(p_scenarioSettings_Future.getPlannedElectricitySavings_pct(), true);

//Connection capacity (Physical)
v_physicalConnectionCapacity_kW = p_scenarioSettings_Future.getRequestedPhysicalConnectionCapacity_kW();
double requestedContractDeliveryCapacity_kW = p_scenarioSettings_Future.getRequestedContractDeliveryCapacity_kW();
double requestedContractFeedinCapacity_kW = p_scenarioSettings_Future.getRequestedContractFeedinCapacity_kW();
p_gridConnection.v_liveConnectionMetaData.setCapacities_kW(requestedContractDeliveryCapacity_kW, requestedContractFeedinCapacity_kW, v_physicalConnectionCapacity_kW);

//Connection capacity (Delivery)
sl_GCCapacityCompany.setValue(requestedContractDeliveryCapacity_kW, true);

//Connection capacity (Feedin)
sl_GCCapacityCompany_Feedin.setValue(requestedContractFeedinCapacity_kW, true);

//Solar panel power
sl_rooftopPVCompany.setValue(p_scenarioSettings_Future.getPlannedPV_kW(), true);

//Battery capacity
sl_batteryCompany.setValue(p_scenarioSettings_Future.getPlannedBatteryCapacity_kWh(), true);

//Curtailment setting
cb_curtailmentCompany.setSelected(p_scenarioSettings_Future.getPlannedCurtailment(), true);

////Mobility

//Mobility savings
sl_mobilityDemandCompanyReduction.setValue(p_scenarioSettings_Future.getPlannedTransportSavings_pct(), true);

//Cars (VOLGORDE BELANGRIJK)
sl_hydrogenCarsCompany.setValue(p_scenarioSettings_Future.getPlannedHydrogenCars(), true);
sl_electricCarsCompany.setValue(p_scenarioSettings_Future.getPlannedEVCars(), true);
//sl_petroleumFuelCarsCompany.setValue(c_scenarioSettings_Future.getPlannedPetroleumFuelCars(), true);

//Vans (VOLGORDE BELANGRIJK)
sl_hydrogenVansCompany.setValue(p_scenarioSettings_Future.getPlannedHydrogenVans(), true);
sl_electricVansCompany.setValue(p_scenarioSettings_Future.getPlannedEVVans(), true);
//sl_petroleumFuelVansCompany.setValue(c_scenarioSettings_Future.getPlannedPetroleumFuelVans(), true);

//Trucks (VOLGORDE BELANGRIJK)
sl_hydrogenTrucksCompany.setValue(p_scenarioSettings_Future.getPlannedHydrogenTrucks(), true);
sl_electricTrucksCompany.setValue(p_scenarioSettings_Future.getPlannedEVTrucks(), true);
//sl_petroleumFuelTrucksCompany.setValue(c_scenarioSettings_Future.getPlannedPetroleumFuelTrucks(), true);

//set active if active in future
p_gridConnection.f_setActive(p_scenarioSettings_Future.getIsActiveInFuture(), zero_Interface.energyModel.p_timeVariables);

//Reset triptrackers
f_resetAllVehiclesToOriginalTripTracker();

//Reset button to future, due to sliders putting it on custom
rb_scenariosPrivateUI.setValue(1, false); 
  }

  public void f_setScenario( int scenario_nr ) { 

switch (scenario_nr){

	case 0: // Current
		f_setScenarioCurrent();

		if(!b_runningMainInterfaceScenarioSettings){
			traceln("Selected scenario: Current");
		}
		
	break;
	
	case 1: // Future
		f_setScenarioFuture();

		if(!b_runningMainInterfaceScenarioSettings){
			traceln("Selected scenario: Future");
		}
	break;
	
	case 2: // Custom
		if(rb_scenariosPrivateUI.getValue() == 2){
			return;
		}
		rb_scenariosPrivateUI.setValue(2, false);
		
		if(!b_runningMainInterfaceSlider){
			traceln("Selected scenario: Custom");
		}
	break;
	
	default:
}

//Set 'results up to date' to false
zero_Interface.b_resultsUpToDate = false; 
  }

  void f_setScenarioCurrent(  ) { 

//Set button to custom early on, so traceln will get ignored.
rb_scenariosPrivateUI.setValue(2, false);


////Heating

//Heating savings
sl_heatDemandCompanyReduction.setValue(0, true);

//Heating type
int nr_currentHeatingType = 0;
switch (p_scenarioSettings_Current.getCurrentHeatingType()){
	case GAS_BURNER:
		nr_currentHeatingType = 0;
		break;

	case HYBRID_HEATPUMP:
		nr_currentHeatingType = 1;
		break;

	case ELECTRIC_HEATPUMP:
		nr_currentHeatingType = 2;
		break;
		
	//case HYDROGENBURNER:
	case DISTRICTHEAT:
		nr_currentHeatingType = 3;
		break;
	
	case GAS_CHP:
		nr_currentHeatingType = 4;
		break;
		
	default:
}
rb_heatingTypePrivateUI.setValue(nr_currentHeatingType, true);		


////Electricity

//Electricity savings
sl_electricityDemandCompanyReduction.setValue(0, true);

//Connection capacity (Physical)
v_physicalConnectionCapacity_kW = p_scenarioSettings_Current.getCurrentPhysicalConnectionCapacity_kW();
double currentContractDeliveryCapacity_kW = p_scenarioSettings_Current.getCurrentContractDeliveryCapacity_kW();
double currentContractFeedinCapacity_kW = p_scenarioSettings_Current.getCurrentContractFeedinCapacity_kW();
p_gridConnection.v_liveConnectionMetaData.setCapacities_kW(currentContractDeliveryCapacity_kW, currentContractFeedinCapacity_kW, v_physicalConnectionCapacity_kW);

//Connection capacity (Delivery)
sl_GCCapacityCompany.setValue(currentContractDeliveryCapacity_kW, true);

//Connection capacity (Feedin)
sl_GCCapacityCompany_Feedin.setValue(currentContractFeedinCapacity_kW, true);


//Solar panel power
sl_rooftopPVCompany.setValue(v_minPVSlider, true);

//Battery capacity
sl_batteryCompany.setValue(v_minBatSlider, true);

//Curtailment setting
cb_curtailmentCompany.setSelected(false, false);

////Mobility

//Mobility savings
sl_mobilityDemandCompanyReduction.setValue(0, true);

//Cars (VOLGORDE BELANGRIJK)
sl_hydrogenCarsCompany.setValue(p_scenarioSettings_Current.getCurrentHydrogenCars(), true);
sl_electricCarsCompany.setValue(p_scenarioSettings_Current.getCurrentEVCars(), true);
//sl_petroleumFuelCarsCompany.setValue(c_scenarioSettings_Current.getCurrentPetroleumFuelCars(), true);

//Vans (VOLGORDE BELANGRIJK)
sl_hydrogenVansCompany.setValue(p_scenarioSettings_Current.getCurrentHydrogenVans(), true);
sl_electricVansCompany.setValue(p_scenarioSettings_Current.getCurrentEVVans(), true);
//sl_petroleumFuelVansCompany.setValue(c_scenarioSettings_Current.getCurrentPetroleumFuelVans(), true);

//Trucks (VOLGORDE BELANGRIJK)
sl_hydrogenTrucksCompany.setValue(p_scenarioSettings_Current.getCurrentHydrogenTrucks(), true);
sl_electricTrucksCompany.setValue(p_scenarioSettings_Current.getCurrentEVTrucks(), true);
//sl_petroleumFuelTrucksCompany.setValue(c_scenarioSettings_Current.getCurrentPetroleumFuelTrucks(), true);

//set active if active in present
p_gridConnection.f_setActive(p_scenarioSettings_Current.getIsCurrentlyActive(), zero_Interface.energyModel.p_timeVariables);

//Reset triptrackers
f_resetAllVehiclesToOriginalTripTracker();

//Reset button to current, due to sliders putting it on custom
rb_scenariosPrivateUI.setValue(0, false);
 
  }

  void f_setHeatingType( GridConnection GC, OL_GridConnectionHeatingType selectedHeatingType ) { 

//Check if selected is not the same as previous, if not: continue with the setting of new heating type
if (GC.f_getCurrentHeatingType() == selectedHeatingType){
	//traceln("Selected heating type is the same as previous heating type");
	return;
}

//Remove from heat grid if it was connected to one.
GC.p_parentNodeHeat = null;
GC.p_parentNodeHeatID = null;

//Remove primary heating asset
GC.f_removeAllHeatingAssets();

//Get needed cacacity
double capacityThermal_kW;

//Select heat demand consumption asset 
J_EAConsumption heatDemandAsset = findFirst(GC.c_consumptionAssets, j_ea->j_ea.getEAType() == OL_EnergyAssetType.HEAT_DEMAND);

//Check heating demand asset is null (shouldnt be possible)
if (heatDemandAsset != null){
	capacityThermal_kW = heatDemandAsset.getBaseConsumption_kWh()/8760*10; // --> average hourly consumption * 10 --> to always have enough capacity
}
else{
	//Select profile heat demand asset 
	J_EAProfile heatDemandAsset_Profile = findFirst(GC.c_profileAssets, j_ea->j_ea.getEnergyCarrier() == OL_EnergyCarriers.HEAT);
	
	if(heatDemandAsset_Profile != null){
		capacityThermal_kW = heatDemandAsset_Profile.getPeakConsumptionPower_kW();//heatDemandAsset_Profile.getProfileScaling_fr() * max(heatDemandAsset_Profile.a_energyProfile_kWh)*4;
	}
	else{
		traceln("No heating demand asset found for GC:" + GC.p_gridConnectionID);
		traceln("--> No heating asset created");
		return;
	}
		
}

capacityThermal_kW = capacityThermal_kW * 2;//For now just make it always twice as high, to be able to support savings/additional consumption slider settings.

//Algemeen
J_TimeParameters timeParameters = zero_Interface.energyModel.p_timeParameters;
double efficiency;
double outputTemperature_degC;

//Heatpump specifieke parameters
double baseTemperature_degC = zero_Interface.energyModel.pp_ambientTemperature_degC.getCurrentValue();
double capacityElectric_kW;		
OL_AmbientTempType ambientTempType;
double sourceAssetHeatPower_kW;
double belowZeroHeatpumpEtaReductionFactor;



//Create selected heating type
switch (selectedHeatingType){
	case GAS_BURNER:
		
		//Add primary heating asset (gasburner)
		efficiency = zero_Interface.energyModel.avgc_data.p_avgEfficiencyGasBurner_fr;
		outputTemperature_degC = zero_Interface.energyModel.avgc_data.p_avgOutputTemperatureGasBurner_degC;
		
		new J_EAConversionGasBurner(GC, capacityThermal_kW, efficiency, timeParameters, outputTemperature_degC);
		
		break;
	
	case HYBRID_HEATPUMP:
		
		//Add primary heating asset (heatpump)
		capacityElectric_kW = capacityThermal_kW / 3; //-- /3, want is hybride, dus kleiner
		efficiency = zero_Interface.energyModel.avgc_data.p_avgEfficiencyHeatpump_fr;
		outputTemperature_degC = zero_Interface.energyModel.avgc_data.p_avgOutputTemperatureHybridHeatpump_degC;
		ambientTempType = OL_AmbientTempType.AMBIENT_AIR;
		sourceAssetHeatPower_kW = 0;
		belowZeroHeatpumpEtaReductionFactor = 1;
		
		J_EAConversionHeatPump heatPumpHybrid = new J_EAConversionHeatPump(GC, capacityElectric_kW, efficiency, timeParameters, outputTemperature_degC, baseTemperature_degC, sourceAssetHeatPower_kW, belowZeroHeatpumpEtaReductionFactor, ambientTempType );
		zero_Interface.energyModel.c_ambientDependentAssets.add(heatPumpHybrid);
		
		//Add secondary heating asset (gasburner)
		efficiency = zero_Interface.energyModel.avgc_data.p_avgEfficiencyGasBurner_fr;
		outputTemperature_degC = zero_Interface.energyModel.avgc_data.p_avgOutputTemperatureGasBurner_degC;
		
		J_EAConversionGasBurner gasBurnerHybrid = new J_EAConversionGasBurner(GC, capacityThermal_kW, efficiency, timeParameters, outputTemperature_degC);
		//GC.p_secondaryHeatingAsset = gasBurnerHybrid;
		
		break;
	
	case ELECTRIC_HEATPUMP:

		//Add primary heating asset (heatpump)
		capacityElectric_kW = capacityThermal_kW;
		efficiency = zero_Interface.energyModel.avgc_data.p_avgEfficiencyHeatpump_fr;
		outputTemperature_degC = zero_Interface.energyModel.avgc_data.p_avgOutputTemperatureElectricHeatpump_degC;
		ambientTempType = OL_AmbientTempType.AMBIENT_AIR;
		sourceAssetHeatPower_kW = 0;
		belowZeroHeatpumpEtaReductionFactor = 1;
		
		new J_EAConversionHeatPump(GC, capacityElectric_kW, efficiency, timeParameters, outputTemperature_degC, baseTemperature_degC, sourceAssetHeatPower_kW, belowZeroHeatpumpEtaReductionFactor, ambientTempType );	
		
		//Add secondary heating asset (if needed??)		//E-boiler!!??		
		break;
	
	case HYDROGENBURNER:
		
		efficiency = zero_Interface.energyModel.avgc_data.p_avgEfficiencyHydrogenBurner_fr;
		outputTemperature_degC = zero_Interface.energyModel.avgc_data.p_avgOutputTemperatureHydrogenBurner_degC;
	    
		//Add primary heating asset (hydrogenburner)
		new J_EAConversionHydrogenBurner(GC, capacityThermal_kW, efficiency, timeParameters, outputTemperature_degC);
		
		break;
	
	case DISTRICTHEAT:

		efficiency = zero_Interface.energyModel.avgc_data.p_avgEfficiencyDistrictHeatingDeliverySet_fr;
		outputTemperature_degC = zero_Interface.energyModel.avgc_data.p_avgOutputTemperatureDistrictHeatingDeliverySet_degC;
				
		new J_EAConversionHeatDeliverySet(GC, capacityThermal_kW, efficiency, timeParameters, outputTemperature_degC);
		
		//Add GC to heat grid if it exists, else create new one
		GC.p_parentNodeHeat = findFirst(zero_Interface.energyModel.f_getRootGridNodes(), node -> node.p_energyCarrier == OL_EnergyCarriers.HEAT);
		if(GC.p_parentNodeHeat == null){
			GridNode GN_heat = zero_Interface.energyModel.add_pop_gridNodes();
			GN_heat.p_gridNodeID = "Heatgrid";
			
			// Check wether transformer capacity is known or estimated
			GN_heat.p_capacity_kW = 1000000;	
			GN_heat.p_realCapacityAvailable = false;
			
			// Basic GN information
			GN_heat.p_description = "Warmtenet";

			//Define node type
			GN_heat.p_nodeType = OL_GridNodeType.HT;
			GN_heat.p_energyCarrier = OL_EnergyCarriers.HEAT;
			
			//Define GN location
			GN_heat.p_latitude = 0;
			GN_heat.p_longitude = 0;
			GN_heat.setLatLon(GN_heat.p_latitude, GN_heat.p_longitude);
			
			//Connect
			GC.p_parentNodeHeat = GN_heat;
			
			//Show warning that heat grid is not a simple solution
			f_setErrorScreen("LET OP: Er is nu een 'warmtenet' gecreëerd. Maar er is geen warmtebron aanwezig in het model. Daarom zal de benodigde warmte voor het warmtenet in de resultaten te zien zijn als warmte import.");
		}
		GC.p_parentNodeHeatID = GC.p_parentNodeHeat.p_gridNodeID;
		break;
	
	case GAS_CHP:

		efficiency = zero_Interface.energyModel.avgc_data.p_avgEfficiencyCHP_thermal_fr + zero_Interface.energyModel.avgc_data.p_avgEfficiencyCHP_electric_fr;
		outputTemperature_degC = zero_Interface.energyModel.avgc_data.p_avgOutputTemperatureCHP_degC;
		double outputCapacityElectric_kW = (capacityThermal_kW/zero_Interface.energyModel.avgc_data.p_avgEfficiencyCHP_thermal_fr) * zero_Interface.energyModel.avgc_data.p_avgEfficiencyCHP_electric_fr;
		
		new J_EAConversionGasCHP(GC, outputCapacityElectric_kW, capacityThermal_kW, efficiency, timeParameters, outputTemperature_degC );
			
		break;
}

// Add a management for the chosen heating type
GC.f_addHeatManagement(selectedHeatingType, false);		 
  }

  void f_setGCCapacity( GridConnection GC, double setGridConnectionCapacity_kW, String type ) { 

double contractedDeliveryCapacity_kW = GC.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW();
double contractedFeedinCapacity_kW = GC.v_liveConnectionMetaData.getContractedFeedinCapacity_kW();
double physicalCapacity_kW = GC.v_liveConnectionMetaData.getPhysicalCapacity_kW();

switch(type){
	case "DELIVERY":
		contractedDeliveryCapacity_kW = setGridConnectionCapacity_kW;
		break;
	case "FEEDIN":
		contractedFeedinCapacity_kW = setGridConnectionCapacity_kW;
		break;
	case "PHYSICAL":
		physicalCapacity_kW = setGridConnectionCapacity_kW;
		break;
}

GC.v_liveConnectionMetaData.setCapacities_kW(contractedDeliveryCapacity_kW, contractedFeedinCapacity_kW, physicalCapacity_kW); 
  }

  void f_setBattery( GridConnection GC, double setBatteryCapacity_kWh ) { 

J_EAStorage batteryAsset = findFirst(GC.c_storageAssets, p -> p.getEAType() == OL_EnergyAssetType.STORAGE_ELECTRIC );

if (setBatteryCapacity_kWh == 0) {	
	if (batteryAsset != null) {
		batteryAsset.removeEnergyAsset();
	}
}
else {
	double c_rate = 1.0 / zero_Interface.energyModel.avgc_data.p_avgRatioBatteryCapacity_v_Power;
	if (batteryAsset == null) {
		batteryAsset = new J_EAStorageElectric(GC, setBatteryCapacity_kWh * c_rate, setBatteryCapacity_kWh, 0.5, zero_Interface.energyModel.p_timeParameters);	
	}
	else {		
		if (batteryAsset.getStorageCapacity_kWh() != 0) {
			c_rate = ((J_EAStorageElectric)batteryAsset).getCapacityElectric_kW()/((J_EAStorageElectric)batteryAsset).getStorageCapacity_kWh();
		}
		((J_EAStorageElectric)batteryAsset).setStorageCapacity_kWh(setBatteryCapacity_kWh, GC);
		((J_EAStorageElectric)batteryAsset).setCapacityElectric_kW(c_rate * setBatteryCapacity_kWh);
	}
	
	//Add battery algorithm if it is not present
	if(GC.f_getBatteryManagement() == null){
		GC.f_setBatteryManagement(new J_BatteryManagementSelfConsumption(GC, zero_Interface.energyModel.p_timeParameters));
	}
}
 
  }

  void f_setPVSystem( GridConnection GC, double v_rooftopPV_kWp ) { 

J_EAProduction pvAsset = findFirst(GC.c_productionAssets, p -> p.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC );
if (pvAsset != null){
	if (v_rooftopPV_kWp == 0) {
		pvAsset.removeEnergyAsset();
	}
	else {
		pvAsset.setCapacityElectric_kW(v_rooftopPV_kWp, GC);
	}
}
else{
	if (v_rooftopPV_kWp != 0) {
		f_addPVAsset(GC, OL_EnergyAssetType.PHOTOVOLTAIC, v_rooftopPV_kWp);
	}
} 
  }

  /**
   * Set Slider presets (limits, start value, text) for private company sliders
   */
  void f_setSliderPresets(  ) { 

//Heating radio button
f_setHeatingRB();

//Set grid capacity slider
f_setGCCapacitySliderPresets();

//PV slider
f_setPVSliderPresets();

//Battery slider
f_setBatSliderPresets();

//Vehicles sliders
f_setVehicleSliderPresets();
f_closeVehicleTripsConfigurationMenu();

//Demand Reduction sliders
f_setDemandReductionSliderPresets(); 
  }

  void f_setComboBoxOwnedGC(  ) { 

String currentSelectedGCString = "";
int i = 1;
List<String> ownedGCs = new ArrayList<String>();
for(GridConnection GC : p_gridConnection.p_owner.f_getOwnedGridConnections()){
	if(GC instanceof GCUtility){
		String GCDisplayName = "Aansluiting " + i + ": " + GC.p_address.getAddress();
		ownedGCs.add(GCDisplayName);
		i++;
		
		if(GC == p_gridConnection){
			currentSelectedGCString = GCDisplayName;
		}
	}
}
String[] ownedGCsArray = new String[ownedGCs.size()];
for(int j = 0; j < ownedGCsArray.length; j++){
	ownedGCsArray[j] = ownedGCs.get(j);
}

cb_selectGC.setItems(ownedGCsArray, false);

//Set cb to correct gc
cb_selectGC.setValue(currentSelectedGCString, false); 
  }

  void f_setPVSliderPresets(  ) { 

//Set back end range (to prevent anylogic errors)
sl_rooftopPVCompany.setRange(0, 2000000);

//Set range specific for each company
v_minPVSlider = roundToInt(p_scenarioSettings_Current.getCurrentPV_kW());
v_maxPVSlider = roundToInt(zero_Interface.energyModel.avgc_data.p_avgRatioRoofPotentialPV* p_gridConnection.p_roofSurfaceArea_m2*zero_Interface.energyModel.avgc_data.p_avgPVPower_kWpm2);
if(v_maxPVSlider <= v_minPVSlider){
	v_maxPVSlider = v_minPVSlider + 1000;
}
v_defaultPVSlider = v_minPVSlider; 
  }

  void f_setBatSliderPresets(  ) { 

//Set back end range (to prevent anylogic errors)
sl_batteryCompany.setRange(0, 10000);

double upperLimit = 1000 + 1000 * Math.ceil(p_scenarioSettings_Current.getCurrentPV_kW()/1000.0);
v_minBatSlider = roundToInt(p_scenarioSettings_Current.getCurrentBatteryCapacity_kWh());
v_maxBatSlider = Math.max(v_minBatSlider*2, upperLimit);
v_defaultBatSlider = v_minBatSlider; 
  }

  void f_setVehicleSliderPresets(  ) { 

//Cars
f_setCarSliderPresets();

//Vans
f_setVanSliderPresets();

//Trucks
f_setTruckSliderPresets(); 
  }

  void f_setCarSliderPresets(  ) { 

//Set back end range (to prevent anylogic errors)
sl_electricCarsCompany.setRange(0, 500);
sl_petroleumFuelCarsCompany.setRange(0, 500);
sl_hydrogenCarsCompany.setRange(0, 500);


//Get default values
int default_nbEVCars = p_scenarioSettings_Current.getCurrentEVCars();
int default_nbPetroleumFuelCars = p_scenarioSettings_Current.getCurrentPetroleumFuelCars();
int default_nbHydrogenCars = p_scenarioSettings_Current.getCurrentHydrogenCars();

//Set minimum value
v_minEVCarSlider = default_nbEVCars;
v_minPetroleumFuelCarSlider = 0;
v_minHydrogenCarSlider = 0;

//Determine realistic max additional vehicles
int max_additonal_vehicles = p_maxAddedVehicles; //min((default_nbEVCars + default_nbPetroleumFuelCars + default_nbHydrogenCars)*1, 20);

//Set maximum
v_maxEVCarSlider = default_nbEVCars + default_nbPetroleumFuelCars + default_nbHydrogenCars + max_additonal_vehicles; // loading of EV is included in the quarter electricity data --> Cant filter --> cant get less EV than atm.
v_maxPetroleumFuelCarSlider = default_nbPetroleumFuelCars + default_nbHydrogenCars + max_additonal_vehicles;
v_maxHydrogenCarSlider = default_nbPetroleumFuelCars + default_nbHydrogenCars + max_additonal_vehicles;

//Set default values
v_nbEVCars = default_nbEVCars;
v_nbPetroleumFuelCars = default_nbPetroleumFuelCars;
v_nbHydrogenCars = default_nbHydrogenCars;

//Set slider knobs
sl_electricCarsCompany.setValue(v_nbEVCars, false);
sl_petroleumFuelCarsCompany.setValue(v_nbPetroleumFuelCars, false);
sl_hydrogenCarsCompany.setValue(v_nbHydrogenCars, false);
 
  }

  void f_setVanSliderPresets(  ) { 

//Set back end range (to prevent anylogic errors)
sl_electricVansCompany.setRange(0, 500);
sl_petroleumFuelVansCompany.setRange(0, 500);
sl_hydrogenVansCompany.setRange(0, 500);

//Get default values
int default_nbEVVans = p_scenarioSettings_Current.getCurrentEVVans();
int default_nbPetroleumFuelVans = p_scenarioSettings_Current.getCurrentPetroleumFuelVans();
int default_nbHydrogenVans = p_scenarioSettings_Current.getCurrentHydrogenVans();

//Set minimum value
v_minEVVanSlider = default_nbEVVans;
v_minPetroleumFuelVanSlider = 0;
v_minHydrogenVanSlider = 0;

//Determine realistic max additional vehicles
int max_additonal_vehicles = p_maxAddedVehicles; //min((default_nbEVVans + default_nbPetroleumFuelVans + default_nbHydrogenVans)*2, 20);

//Set maximum
v_maxEVVanSlider = default_nbEVVans + default_nbPetroleumFuelVans + default_nbHydrogenVans + max_additonal_vehicles; // loading of EV is included in the quarter electricity data --> Cant filter --> cant get less EV than atm.
v_maxPetroleumFuelVanSlider = default_nbPetroleumFuelVans + default_nbHydrogenVans + max_additonal_vehicles;
v_maxHydrogenVanSlider = default_nbPetroleumFuelVans + default_nbHydrogenVans + max_additonal_vehicles;

//Set default values
v_nbEVVans = default_nbEVVans;
v_nbPetroleumFuelVans = default_nbPetroleumFuelVans;
v_nbHydrogenVans = default_nbHydrogenVans;

//Set slider knob
sl_electricVansCompany.setValue(v_nbEVVans, false);
sl_petroleumFuelVansCompany.setValue(v_nbPetroleumFuelVans, false);
sl_hydrogenVansCompany.setValue(v_nbHydrogenVans, false);
 
  }

  void f_setTruckSliderPresets(  ) { 

//Set back end range (to prevent anylogic errors)
sl_electricTrucksCompany.setRange(0, 500);
sl_petroleumFuelTrucksCompany.setRange(0, 500);
sl_hydrogenTrucksCompany.setRange(0, 500);

//Get default values
int default_nbEVTrucks = p_scenarioSettings_Current.getCurrentEVTrucks();
int default_nbPetroleumFuelTrucks = p_scenarioSettings_Current.getCurrentPetroleumFuelTrucks();
int default_nbHydrogenTrucks = p_scenarioSettings_Current.getCurrentHydrogenTrucks();

//Set minimum value
v_minEVTruckSlider = default_nbEVTrucks;
v_minPetroleumFuelTruckSlider = 0;
v_minHydrogenTruckSlider = 0;

//Determine realistic max additional vehicles
int max_additonal_vehicles = p_maxAddedVehicles; //min((default_nbEVTrucks + default_nbPetroleumFuelTrucks + default_nbHydrogenTrucks)*2, 20);

//Set maximum
v_maxEVTruckSlider = default_nbEVTrucks + default_nbPetroleumFuelTrucks + default_nbHydrogenTrucks + max_additonal_vehicles; // loading of EV is included in the quarter electricity data --> Cant filter --> cant get less EV than atm.
v_maxPetroleumFuelTruckSlider = default_nbPetroleumFuelTrucks + default_nbHydrogenTrucks + max_additonal_vehicles;
v_maxHydrogenTruckSlider = default_nbPetroleumFuelTrucks + default_nbHydrogenTrucks + max_additonal_vehicles;

//Set default values
v_nbEVTrucks = default_nbEVTrucks;
v_nbPetroleumFuelTrucks = default_nbPetroleumFuelTrucks;
v_nbHydrogenTrucks = default_nbHydrogenTrucks;

//Set slider knob
sl_electricTrucksCompany.setValue(v_nbEVTrucks, false);
sl_petroleumFuelTrucksCompany.setValue(v_nbPetroleumFuelTrucks, false);
sl_hydrogenTrucksCompany.setValue(v_nbHydrogenTrucks, false);
 
  }

  void f_createVehicle( GridConnection parentGC, OL_VehicleType vehicleType, OL_EnergyCarriers fuelType, J_ActivityTrackerTrips tripTracker, boolean available, boolean isAdditionalVehicle ) { 

double energyConsumption_kWhpkm = 0;
double vehicleScaling 			= 1.0;
J_TimeParameters timeParameters	= zero_Interface.energyModel.p_timeParameters;

if (fuelType == OL_EnergyCarriers.ELECTRICITY){ // Create EVS
	double storageCapacity_kWh 		= 0;
	double capacityElectricity_kW 	= 0;
	double stateOfCharge_fr  		= 1; // Initial state of charge

	switch(vehicleType){
		case CAR:
			capacityElectricity_kW	= (p_scenarioSettings_Current.getCurrentEVCarChargePower_kW() > 0) ? p_scenarioSettings_Current.getCurrentEVCarChargePower_kW() : zero_Interface.energyModel.avgc_data.p_avgEVMaxChargePowerCar_kW;
			storageCapacity_kWh		= zero_Interface.energyModel.avgc_data.p_avgEVStorageCar_kWh;
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm;
		break;
		case VAN:
			capacityElectricity_kW	= (p_scenarioSettings_Current.getCurrentEVVanChargePower_kW() > 0) ? p_scenarioSettings_Current.getCurrentEVVanChargePower_kW() : zero_Interface.energyModel.avgc_data.p_avgEVMaxChargePowerVan_kW;
			storageCapacity_kWh		= zero_Interface.energyModel.avgc_data.p_avgEVStorageVan_kWh;
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionVan_kWhpkm;
		break;
		case TRUCK:
			capacityElectricity_kW	= (p_scenarioSettings_Current.getCurrentEVTruckChargePower_kW() > 0) ? p_scenarioSettings_Current.getCurrentEVTruckChargePower_kW() : zero_Interface.energyModel.avgc_data.p_avgEVMaxChargePowerTruck_kW;
			storageCapacity_kWh		= zero_Interface.energyModel.avgc_data.p_avgEVStorageTruck_kWh;
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionTruck_kWhpkm;
		break;
	
	}
	
	//Create EV and connect to GC and selected trip tracker
	J_EAEV electricVehicle = new J_EAEV(parentGC, capacityElectricity_kW, storageCapacity_kWh, stateOfCharge_fr, timeParameters, energyConsumption_kWhpkm, vehicleScaling, vehicleType, tripTracker, available);	
	
	if (isAdditionalVehicle){
		electricVehicle.getTripTracker().setDistanceScaling_fr(1-sl_mobilityDemandCompanyReduction.getValue()/100.0);
		zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).add(electricVehicle);
		if(tripTracker == null){
			f_addNewInstanceOfCustomTripTrackerToAdditionalVehicle(electricVehicle);
		}
	}
	else{
		zero_Interface.c_orderedVehicles.add(0, electricVehicle);
	}
	
	//Check if charging management is present if not: add default management
	if(parentGC.f_getCurrentChargingType() == OL_ChargingAttitude.NONE){
		parentGC.f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
	}
}
else {
    if (fuelType == OL_EnergyCarriers.PETROLEUM_FUEL) { // Create petroleumFuel vehicles
        switch (vehicleType) {
            case CAR:
                energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgGasolineConsumptionCar_kWhpkm;
                break;
            case VAN:
                energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgDieselConsumptionVan_kWhpkm;
                break;
            case TRUCK:
                energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgDieselConsumptionTruck_kWhpkm;
                break;
        }
    } else if (fuelType == OL_EnergyCarriers.HYDROGEN) { // Create hydrogen vehicles
        switch (vehicleType) {
            case CAR:
                energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgHydrogenConsumptionCar_kWhpkm;
                break;
            case VAN:
                energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgHydrogenConsumptionVan_kWhpkm;
                break;
            case TRUCK:
                energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgHydrogenConsumptionTruck_kWhpkm;
                break;
        }
    }

    // Create fuel vehicle and connect to GC and selected trip tracker
    J_EAFuelVehicle fuelVehicle = new J_EAFuelVehicle(parentGC, energyConsumption_kWhpkm, timeParameters, vehicleScaling, vehicleType, tripTracker, fuelType, available);

    if (isAdditionalVehicle) {
		fuelVehicle.getTripTracker().setDistanceScaling_fr(1-sl_mobilityDemandCompanyReduction.getValue()/100.0);
        zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).add(fuelVehicle);
        if(tripTracker == null){
			f_addNewInstanceOfCustomTripTrackerToAdditionalVehicle(fuelVehicle);
		}
    } else {
        zero_Interface.c_orderedVehicles.add(0, fuelVehicle);
    }
}

 
  }

  void f_setElectricVehicleSliders( GridConnection GC, OL_VehicleType vehicleType, int setAmountOfVehicles ) { 

int local_EV_nb;
int local_PetroleumFuelV_nb;
int local_HydrogenV_nb;
int max_amount_petroleumFuel_vehicles;

switch (vehicleType){
	case CAR:
		local_EV_nb = v_nbEVCars;
		local_PetroleumFuelV_nb = v_nbPetroleumFuelCars;
		local_HydrogenV_nb = v_nbHydrogenCars;
		max_amount_petroleumFuel_vehicles = v_maxPetroleumFuelCarSlider;
		break;
	case VAN:
		local_EV_nb = v_nbEVVans;
		local_PetroleumFuelV_nb = v_nbPetroleumFuelVans;
		local_HydrogenV_nb = v_nbHydrogenVans;
		max_amount_petroleumFuel_vehicles = v_maxPetroleumFuelVanSlider;
		break;
	case TRUCK:
		local_EV_nb = v_nbEVTrucks;
		local_PetroleumFuelV_nb = v_nbPetroleumFuelTrucks;
		local_HydrogenV_nb = v_nbHydrogenTrucks;
		max_amount_petroleumFuel_vehicles = v_maxPetroleumFuelTruckSlider;
		break;
	default:
		traceln("SLIDER SET TO WRONG VEHICLE TYPE, DO NOTHING");
		return;
}


if (setAmountOfVehicles > local_EV_nb){ // Slider has increased the amount of selected vehicles
	
	//First convert all other existing additional vehicles
	int nbOfOtherAdditionalVehiclesOfThisClass = findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && (vehicle.getFuelType() == OL_EnergyCarriers.PETROLEUM_FUEL || vehicle.getFuelType() == OL_EnergyCarriers.HYDROGEN)).size();
	while(setAmountOfVehicles > local_EV_nb && nbOfOtherAdditionalVehiclesOfThisClass > 0 ){
		// Find an additional PetroleumFuel vehicle
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.PETROLEUM_FUEL);
		
		if(petroleumFuelVehicle != null){
			J_ActivityTrackerTrips tripTracker = petroleumFuelVehicle.getTripTracker();
			
			// Remove PetroleumFuel vehicle		
			boolean available = petroleumFuelVehicle.getAvailability();
			petroleumFuelVehicle.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(petroleumFuelVehicle);
			zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
			
			//Create new additional EV
			f_createVehicle(GC, vehicleType, OL_EnergyCarriers.ELECTRICITY, tripTracker, available, true);			

			//Update local variables
			local_EV_nb++;
			local_PetroleumFuelV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
		else{
			// Find an additional Hydrogen vehicle
			J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.HYDROGEN);
			J_ActivityTrackerTrips tripTracker = hydrogenVehicle.getTripTracker();
			
			// Remove Hydrogen vehicle		
			boolean available = hydrogenVehicle.getAvailability();
			hydrogenVehicle.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(hydrogenVehicle);
			zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
			
			//Create new additional EV
			f_createVehicle(GC, vehicleType, OL_EnergyCarriers.ELECTRICITY, tripTracker, available, true);

			//Update local variables
			local_EV_nb++;
			local_HydrogenV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
	}
	
	while ( setAmountOfVehicles > local_EV_nb && local_PetroleumFuelV_nb > 0) {
		// Find a PetroleumFuel vehicle
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.PETROLEUM_FUEL && vehicle.getOwner() == GC);
		J_ActivityTrackerTrips tripTracker = petroleumFuelVehicle.getTripTracker(); 
		
		// Remove PetroleumFuel vehicle		
		boolean available = petroleumFuelVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
		petroleumFuelVehicle.removeEnergyAsset();

		//Create new EV
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.ELECTRICITY, tripTracker, available, false);
			
		//Update variables
		local_EV_nb++;
		local_PetroleumFuelV_nb--;
	}
	while (setAmountOfVehicles > local_EV_nb && local_HydrogenV_nb > 0){
		// Find a Hydrogen vehicle
		J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.HYDROGEN  && vehicle.getOwner() == GC);
		J_ActivityTrackerTrips tripTracker = hydrogenVehicle.getTripTracker();
		
		// Remove Hydrogen vehicle		
		boolean available = hydrogenVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
		hydrogenVehicle.removeEnergyAsset();

		//Create new EV
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.ELECTRICITY, tripTracker, available, false);
	
		//Update variables
		local_EV_nb++;
		local_HydrogenV_nb--;
	}
	while (setAmountOfVehicles > local_EV_nb){ //If still not enough EV:
		// Create additional vehicles
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.ELECTRICITY, null, true, true);
		
		//Update variables
		local_EV_nb++;
	}
}
else if(setAmountOfVehicles < local_EV_nb){ // Slider has decreased the amount of selected vehicles
	
	ArrayList<I_Vehicle> additionalVehicles = new ArrayList<>(findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.ELECTRICITY ));
	while(setAmountOfVehicles < local_EV_nb && additionalVehicles.size() > 0){ //If there are additional EV, remove them first
		//Find additional created vehicle
		J_EAEV ev = (J_EAEV)additionalVehicles.get(additionalVehicles.size()-1); // Get latest added
		
		// Remove electric vehicle
		additionalVehicles.remove(ev);
		zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(ev);
		zero_Interface.c_orderedVehicles.remove(ev);
		ev.removeEnergyAsset();
			
		//Update variable
		local_EV_nb--;
	}
	while ( setAmountOfVehicles < local_EV_nb && local_PetroleumFuelV_nb < max_amount_petroleumFuel_vehicles) {
		//Find a to be removed EV
		J_EAEV ev = (J_EAEV)findFirst(zero_Interface.c_orderedVehicles, vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.ELECTRICITY && !zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).contains(vehicle)  && vehicle.getOwner() == GC);
		J_ActivityTrackerTrips tripTracker = ev.getTripTracker();

		//Remove EV
		boolean available = ev.getAvailability();
		zero_Interface.c_orderedVehicles.remove(ev);
		ev.removeEnergyAsset();
		
		// Create petroleumFuel vehicle	
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.PETROLEUM_FUEL, tripTracker, available, false);				
		
		local_EV_nb--;
		local_PetroleumFuelV_nb++;
	}
}

//Update variables
switch (vehicleType){
	case CAR:
		v_nbEVCars = local_EV_nb;
		v_nbPetroleumFuelCars = local_PetroleumFuelV_nb;
		v_nbHydrogenCars = local_HydrogenV_nb;
		break;
	case VAN:
		v_nbEVVans = local_EV_nb;
		v_nbPetroleumFuelVans = local_PetroleumFuelV_nb;
		v_nbHydrogenVans = local_HydrogenV_nb;
		break;
	case TRUCK:
		v_nbEVTrucks = local_EV_nb;
		v_nbPetroleumFuelTrucks = local_PetroleumFuelV_nb;
		v_nbHydrogenTrucks = local_HydrogenV_nb;
		break;
} 
  }

  void f_setPetroleumFuelVehicleSliders( GridConnection GC, OL_VehicleType vehicleType, int setAmountOfVehicles ) { 

int local_EV_nb;
int local_PetroleumFuelV_nb;
int local_HydrogenV_nb;

int min_amount_EV;
int	max_amount_EV;

switch (vehicleType){
	case CAR:
		local_EV_nb = v_nbEVCars;
		local_PetroleumFuelV_nb = v_nbPetroleumFuelCars;
		local_HydrogenV_nb = v_nbHydrogenCars;
		min_amount_EV = v_minEVCarSlider;
		max_amount_EV = v_maxEVCarSlider;
		break;
	case VAN:
		local_EV_nb = v_nbEVVans;
		local_PetroleumFuelV_nb = v_nbPetroleumFuelVans;
		local_HydrogenV_nb = v_nbHydrogenVans;
		min_amount_EV = v_minEVVanSlider;
		max_amount_EV = v_maxEVVanSlider;
		break;
	case TRUCK:
		local_EV_nb = v_nbEVTrucks;
		local_PetroleumFuelV_nb = v_nbPetroleumFuelTrucks;
		local_HydrogenV_nb = v_nbHydrogenTrucks;
		min_amount_EV = v_minEVTruckSlider;
		max_amount_EV = v_maxEVTruckSlider;
		break;
	default:
		traceln("SLIDER SET TO WRONG VEHICLE TYPE, DO NOTHING");
		return;
}


if (setAmountOfVehicles > local_PetroleumFuelV_nb){ // Slider has increased the amount of selected vehicles
	//First convert all other existing additional vehicles
	int nbOfOtherAdditionalVehiclesOfThisClass = findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && (vehicle.getFuelType() == OL_EnergyCarriers.HYDROGEN || vehicle.getFuelType() == OL_EnergyCarriers.ELECTRICITY)).size();
	while(setAmountOfVehicles > local_PetroleumFuelV_nb && nbOfOtherAdditionalVehiclesOfThisClass > 0 ){
		// Find an additional EV vehicle
		J_EAEV ev = (J_EAEV)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.ELECTRICITY);
			
		if(ev != null){
			J_ActivityTrackerTrips tripTracker = ev.getTripTracker();
		
			// Remove EV
			boolean available = ev.getAvailability();
			ev.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(ev);
			zero_Interface.c_orderedVehicles.remove(ev);
			
			//Create new additional PetroleumFuel vehicle
			f_createVehicle(GC, vehicleType, OL_EnergyCarriers.PETROLEUM_FUEL, tripTracker, available, true);

			//Update local variables
			local_PetroleumFuelV_nb++;
			local_EV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
		else{
			// Find an additional Hydrogen vehicle
			J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.HYDROGEN);
			J_ActivityTrackerTrips tripTracker = hydrogenVehicle.getTripTracker();
			
			// Remove Hydrogen vehicle		
			boolean available = hydrogenVehicle.getAvailability();
			hydrogenVehicle.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(hydrogenVehicle);
			zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
			
			//Create new additional PetroleumFuel vehicle
			f_createVehicle(GC, vehicleType, OL_EnergyCarriers.PETROLEUM_FUEL, tripTracker, available, true);

			//Update local variables
			local_PetroleumFuelV_nb++;
			local_HydrogenV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
	}
	while ( setAmountOfVehicles > local_PetroleumFuelV_nb && local_EV_nb > min_amount_EV) {
		// Find an EV
		J_EAEV ev = (J_EAEV)findFirst(zero_Interface.c_orderedVehicles, vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.ELECTRICITY  && vehicle.getOwner() == GC);
		J_ActivityTrackerTrips tripTracker = ev.getTripTracker();
		
		//Remove one EV
		boolean available = ev.getAvailability();
		zero_Interface.c_orderedVehicles.remove(ev);
		ev.removeEnergyAsset();
		
		//Create new PetroleumFuel vehicle
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.PETROLEUM_FUEL, tripTracker, available, false);
			
		//Update variables
		local_PetroleumFuelV_nb++;
		local_EV_nb--;
	}
	while (setAmountOfVehicles > local_PetroleumFuelV_nb && local_HydrogenV_nb > 0){
		// Find a Hydrogen vehicle
		J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.HYDROGEN  && vehicle.getOwner() == GC);
		J_ActivityTrackerTrips tripTracker = hydrogenVehicle.getTripTracker();
		
		// Remove hydrogen vehicle			
		boolean available = hydrogenVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
		hydrogenVehicle.removeEnergyAsset();
		
		//Create new PetroleumFuel vehicle
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.PETROLEUM_FUEL, tripTracker, available, false);
	
		//Update variables
		local_PetroleumFuelV_nb++;
		local_HydrogenV_nb--;
	}
	while (setAmountOfVehicles > local_PetroleumFuelV_nb){ // Create additional vehicles
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.PETROLEUM_FUEL, null, true, true);
		local_PetroleumFuelV_nb++;
	}
}
else if(setAmountOfVehicles < local_PetroleumFuelV_nb){ // Slider has decreased the amount of selected vehicles
	
	ArrayList<I_Vehicle> additionalVehicles = new ArrayList<>(findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.PETROLEUM_FUEL ));
	while(setAmountOfVehicles < local_PetroleumFuelV_nb && additionalVehicles.size() > 0){ //Remove additional PetroleumFuel vehicles first
		//Find additional created vehicle
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)additionalVehicles.get(additionalVehicles.size()-1); // Get latest added
		
		// Remove petroleumFuel vehicle
		additionalVehicles.remove(petroleumFuelVehicle);
		zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(petroleumFuelVehicle);
		petroleumFuelVehicle.removeEnergyAsset();
		zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
		
		//Update variable
		local_PetroleumFuelV_nb--;
	}
	while ( setAmountOfVehicles < local_PetroleumFuelV_nb && local_EV_nb < max_amount_EV) {
		// Find a to be removed PetroleumFuel vehicle
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.PETROLEUM_FUEL && !zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).contains(vehicle)  && vehicle.getOwner() == GC);
		J_ActivityTrackerTrips tripTracker = petroleumFuelVehicle.getTripTracker();
		
		// Remove petroleumFuel vehicle		
		boolean available = petroleumFuelVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
		petroleumFuelVehicle.removeEnergyAsset();
		
		//Create new EV
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.ELECTRICITY, tripTracker, available, false);
			
		//Update variables
		local_PetroleumFuelV_nb--;
		local_EV_nb++;
	}
}

//Update variables
switch (vehicleType){
	case CAR:
		v_nbEVCars = local_EV_nb;
		v_nbPetroleumFuelCars = local_PetroleumFuelV_nb;
		v_nbHydrogenCars = local_HydrogenV_nb;
		break;
	case VAN:
		v_nbEVVans = local_EV_nb;
		v_nbPetroleumFuelVans = local_PetroleumFuelV_nb;
		v_nbHydrogenVans = local_HydrogenV_nb;
		break;
	case TRUCK:
		v_nbEVTrucks = local_EV_nb;
		v_nbPetroleumFuelTrucks = local_PetroleumFuelV_nb;
		v_nbHydrogenTrucks = local_HydrogenV_nb;
		break;
} 
  }

  public void f_setHydrogenVehicleSliders( GridConnection GC, OL_VehicleType vehicleType, int setAmountOfVehicles ) { 

int local_EV_nb;
int local_PetroleumFuelV_nb;
int local_HydrogenV_nb;

int min_amount_EV;
int	max_amount_EV;

switch (vehicleType){
	case CAR:
		local_EV_nb = v_nbEVCars;
		local_PetroleumFuelV_nb = v_nbPetroleumFuelCars;
		local_HydrogenV_nb = v_nbHydrogenCars;
		min_amount_EV = v_minEVCarSlider;
		max_amount_EV = v_maxEVCarSlider;
		break;
	case VAN:
		local_EV_nb = v_nbEVVans;
		local_PetroleumFuelV_nb = v_nbPetroleumFuelVans;
		local_HydrogenV_nb = v_nbHydrogenVans;
		min_amount_EV = v_minEVVanSlider;
		max_amount_EV = v_maxEVVanSlider;
		break;
	case TRUCK:
		local_EV_nb = v_nbEVTrucks;
		local_PetroleumFuelV_nb = v_nbPetroleumFuelTrucks;
		local_HydrogenV_nb = v_nbHydrogenTrucks;
		min_amount_EV = v_minEVTruckSlider;
		max_amount_EV = v_maxEVTruckSlider;
		break;
	default:
		traceln("SLIDER SET TO WRONG VEHICLE TYPE, DO NOTHING");
		return;
}

if (setAmountOfVehicles > local_HydrogenV_nb){ // Slider has increased the amount of selected vehicles
	
	//First convert all other existing additional vehicles
	int nbOfOtherAdditionalVehiclesOfThisClass = findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && (vehicle.getFuelType() == OL_EnergyCarriers.PETROLEUM_FUEL || vehicle.getFuelType() == OL_EnergyCarriers.ELECTRICITY)).size();
	while(setAmountOfVehicles > local_HydrogenV_nb && nbOfOtherAdditionalVehiclesOfThisClass > 0 ){
		// Find an additional PetroleumFuel vehicle
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.PETROLEUM_FUEL);
		
		if(petroleumFuelVehicle != null){
			J_ActivityTrackerTrips tripTracker = petroleumFuelVehicle.getTripTracker();
			
			// Remove PetroleumFuel vehicle		
			boolean available = petroleumFuelVehicle.getAvailability();
			petroleumFuelVehicle.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(petroleumFuelVehicle);
			zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
			
			//Create new additional Hydrogen vehicle
			f_createVehicle(GC, vehicleType, OL_EnergyCarriers.HYDROGEN, tripTracker, available, true);			

			//Update local variables
			local_HydrogenV_nb++;
			local_PetroleumFuelV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
		else{
			// Find an additional EV vehicle
			J_EAEV ev = (J_EAEV)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.ELECTRICITY);
			J_ActivityTrackerTrips tripTracker = ev.getTripTracker();
		
			// Remove EV
			boolean available = ev.getAvailability();
			ev.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(ev);
			zero_Interface.c_orderedVehicles.remove(ev);
			
			//Create new additional Hydrogen vehicle
			f_createVehicle(GC, vehicleType, OL_EnergyCarriers.HYDROGEN, tripTracker, available, true);

			//Update local variables
			local_HydrogenV_nb++;
			local_EV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
	}
	while ( setAmountOfVehicles > local_HydrogenV_nb && local_PetroleumFuelV_nb > 0) {
		// Find a to be removed PetroleumFuel vehicle
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.PETROLEUM_FUEL  && vehicle.getOwner() == GC);
		J_ActivityTrackerTrips tripTracker = petroleumFuelVehicle.getTripTracker();

		//Remove petroleumFuel vehicle
		boolean available = petroleumFuelVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
		petroleumFuelVehicle.removeEnergyAsset();
		
		//Create new Hydrogen vehicle
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.HYDROGEN, tripTracker, available, false);
			
		//Update variables
		local_HydrogenV_nb++;
		local_PetroleumFuelV_nb--;
		
	}
	while (setAmountOfVehicles > local_HydrogenV_nb && local_EV_nb > min_amount_EV){
		// Find a to be removed EV
		J_EAEV ev = (J_EAEV)findFirst(zero_Interface.c_orderedVehicles, vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.ELECTRICITY  && vehicle.getOwner() == GC);
		J_ActivityTrackerTrips tripTracker = ev.getTripTracker();
		
		// Remove EV
		boolean available = ev.getAvailability();
		zero_Interface.c_orderedVehicles.remove(ev);
		ev.removeEnergyAsset();
		
		//Create new Hydrogen vehicle
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.HYDROGEN, tripTracker, available, false);
			
		//Update variables
		local_HydrogenV_nb++;
		local_EV_nb--;
	}
	while (setAmountOfVehicles > local_HydrogenV_nb){ // Create additional vehicles
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.HYDROGEN, null, true, true);
		local_HydrogenV_nb++;	
	}
}
else if(setAmountOfVehicles < local_HydrogenV_nb){ // Slider has decreased the amount of selected vehicles
	
	ArrayList<I_Vehicle> additionalVehicles = new ArrayList<>(findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.HYDROGEN ));
	while(setAmountOfVehicles < local_HydrogenV_nb && additionalVehicles.size() > 0){//Remove additional Hydrogen vehicles first
		//Find additional created vehicle
		J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)additionalVehicles.get(additionalVehicles.size()-1); // Get latest added
		
		// Remove hydrogen vehicle
		additionalVehicles.remove(hydrogenVehicle);
		zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(hydrogenVehicle);
		hydrogenVehicle.removeEnergyAsset();
		zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
		
		//Update variable
		local_HydrogenV_nb--;
	}
	while ( setAmountOfVehicles < local_HydrogenV_nb && local_EV_nb < max_amount_EV) {
		// Find a to be removed Hydrogen vehicle
		J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getFuelType() == OL_EnergyCarriers.HYDROGEN && !zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).contains(vehicle)  && vehicle.getOwner() == GC);
		J_ActivityTrackerTrips tripTracker = hydrogenVehicle.getTripTracker();
		
		// Remove hydrogen vehicle			
		boolean available = hydrogenVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
		hydrogenVehicle.removeEnergyAsset();
		
		//Create new EV vehicle
		f_createVehicle(GC, vehicleType, OL_EnergyCarriers.ELECTRICITY, tripTracker, available, false);
	
		//Update variables
		local_HydrogenV_nb--;
		local_EV_nb++;
	}
}

//Update variables
switch (vehicleType){
	case CAR:
		v_nbEVCars = local_EV_nb;
		v_nbPetroleumFuelCars = local_PetroleumFuelV_nb;
		v_nbHydrogenCars = local_HydrogenV_nb;
		break;
	case VAN:
		v_nbEVVans = local_EV_nb;
		v_nbPetroleumFuelVans = local_PetroleumFuelV_nb;
		v_nbHydrogenVans = local_HydrogenV_nb;
		break;
	case TRUCK:
		v_nbEVTrucks = local_EV_nb;
		v_nbPetroleumFuelTrucks = local_PetroleumFuelV_nb;
		v_nbHydrogenTrucks = local_HydrogenV_nb;
		break;
} 
  }

  void f_setResultsUIPresets(  ) { 

//Set the order of the presentation objects
f_setPresentationOrder();


//Set the locations and visibilities of the ResultsUI agents
uI_Results.f_setChartProfiles_Presentation(0, 0, true);
uI_Results.f_setChartBalance_Presentation(530, 0, true);
uI_Results.f_setChartGridLoad_Presentation(1060, 0, false);
uI_Results.f_setChartSankey_Presentation(1060, 0, true);
uI_Results.f_setResultsUIHeader(null, null, false);

//Disable KPIsummary button if KPIsummary is not selected
if(zero_Interface.settings.showKPISummary() == null || !zero_Interface.settings.showKPISummary()){
	uI_Results.getCheckbox_KPISummary().setVisible(false);
}
else{
	//uI_Results.f_setCB_KPISummary_Presentation(10, -30, true);
}

//Set selected object display flase
uI_Results.b_isCompanyUIResultsUI = true;

//Set the color of the charts
uI_Results.f_styleAllCharts(v_chartBackgroundColor, v_companyUILineColor, v_chartLineWidth, LINE_STYLE_SOLID); 
  }

  public void f_setCompanyUI( GridConnection GC ) { 

//Initialize parameters
p_gridConnection = GC;
p_companyName = GC.p_ownerID;
v_adressGC = GC.p_address.getAddress();
p_scenarioSettings_Current = zero_Interface.c_scenarioMap_Current.get(GC.p_uid);
p_scenarioSettings_Future = zero_Interface.c_scenarioMap_Future.get(GC.p_uid);

//Scale companyName to the box size
f_setNameTextSize();

//Set the sliders to the correct settings
f_setSelectedGCSliders();

//Set the new graphs/building selection
if(!b_runningMainInterfaceScenarioSettings && !b_runningMainInterfaceSlider && p_gridConnection.v_isActive){
	f_updateUIResultsCompanyUI();
}

//Set connected GC combobox 
f_setComboBoxOwnedGC();

//Enable/disable all sliders (based on paused)
f_enableAllSliders(p_gridConnection.v_isActive);
 
  }

  void f_updateUIResultsCompanyUI(  ) { 

//Update data
uI_Results.f_updateResultsUI(p_gridConnection);

//Set all charts
if(p_gridConnection.v_rapidRunData != null){
	uI_Results.f_setAllCharts();
}

//Set all charts visible
uI_Results.f_setChartProfiles_Presentation(null, null, true);
uI_Results.f_setChartBalance_Presentation(null, null, true);

if(cb_showGridloadPlot.isSelected())
	uI_Results.f_setChartGridLoad_Presentation(null, null, true);
else{
	uI_Results.f_setChartSankey_Presentation(null, null, true);
} 
  }

  void f_setHeatingRB(  ) { 

int nr_currentHeatingType = 0;
String rbHeating_acces = "enabled";

switch (p_scenarioSettings_Current.getCurrentHeatingType()){
	case GAS_BURNER:
		nr_currentHeatingType = 0;
		break;
	case HYBRID_HEATPUMP:
		nr_currentHeatingType = 1;
		rbHeating_acces = "disabled";
		break;
	case ELECTRIC_HEATPUMP:
		nr_currentHeatingType = 2;
		rbHeating_acces = "disabled";
		break;
	case DISTRICTHEAT:
		nr_currentHeatingType = 3;
		break;
	case LT_DISTRICTHEAT:
		nr_currentHeatingType = 3;
		rbHeating_acces = "disabled";
		break;
	case CUSTOM:
		nr_currentHeatingType = 4;
		rbHeating_acces = "disabled";
		break;
	default:
		rbHeating_acces = "invisible";
}

if (rbHeating_acces.equals("disabled") || rbHeating_acces.equals("invisible")){
	rb_heatingTypePrivateUI.setEnabled(false);
	
	if(p_gridConnection.v_hasQuarterHourlyValues){
		sl_heatDemandCompanyReduction.setEnabled(false);
	}
	
	if (rbHeating_acces.equals("invisible")){
		rb_heatingTypePrivateUI.setVisible(false);
		gr_heatDemandReductionSlider.setVisible(false);
	}
	else {
		gr_heatDemandReductionSlider.setVisible(true);
	}
}
else{ // if(rbHeating_acces.equals("enabled"){
	rb_heatingTypePrivateUI.setEnabled(true);
	rb_heatingTypePrivateUI.setVisible(true);
	sl_heatDemandCompanyReduction.setEnabled(true);
	gr_heatDemandReductionSlider.setVisible(true);
}
 
  }

  public void f_addPVAsset( GridConnection parentGC, OL_EnergyAssetType asset_type, double installedPower_kW ) { 

String asset_name					= "Solar Panels";
double capacityElectric_kW			= installedPower_kW;
double capacityHeat_kW				= 0;
double yearlyProductionMethane_kWh 	= 0;
double yearlyProductionHydrogen_kWh = 0;
J_TimeParameters timeParameters 					= zero_Interface.energyModel.p_timeParameters;
double outputTemperature_degC 		= 0;

J_EAProduction production_asset = new J_EAProduction(parentGC, asset_type, asset_name, OL_EnergyCarriers.ELECTRICITY, capacityElectric_kW, timeParameters, zero_Interface.energyModel.pp_PVProduction35DegSouth_fr);
parentGC.v_liveAssetsMetaData.updateActiveAssetData(new ArrayList<GridConnection>(List.of(parentGC)));
 
  }

  void f_setSelectedGCSliders(  ) { 

//Initialize slider presets to selected GC (min, max, etc.)
f_setSliderPresets();

//If GC not active in current situation, disable scenario rb
rb_scenariosPrivateUI.setEnabled(p_scenarioSettings_Current.getIsCurrentlyActive());

//Find the current heating type
int nr_currentHeatingType = 0;
switch (p_gridConnection.f_getCurrentHeatingType()){
	case GAS_BURNER:
		nr_currentHeatingType = 0;
	break;

	case HYBRID_HEATPUMP:
		nr_currentHeatingType = 1;
	break;

	case ELECTRIC_HEATPUMP:
		nr_currentHeatingType = 2;
	break;
		
	case DISTRICTHEAT:
	case LT_DISTRICTHEAT:
		nr_currentHeatingType = 3;
	break;
	case CUSTOM:
		nr_currentHeatingType = 4;
	break;	
	default:
		nr_currentHeatingType = 4;
}

//Find the current heat saving percentage
int currentHeatSavings = 0;

J_EAConsumption consumptionEAHEAT = findFirst(p_gridConnection.c_consumptionAssets, consumptionAsset -> consumptionAsset.getEAType() == OL_EnergyAssetType.HEAT_DEMAND);
if (consumptionEAHEAT != null){
	currentHeatSavings = roundToInt((consumptionEAHEAT.getConsumptionScaling_fr() - 1)*-100);
}
else{   
	J_EAProfile profileEAHEAT = findFirst(p_gridConnection.c_profileAssets, profileAsset -> profileAsset.getEnergyCarrier() == OL_EnergyCarriers.HEAT);
	if (profileEAHEAT != null){
		currentHeatSavings = roundToInt((profileEAHEAT.getProfileScaling_fr() - 1)*-100);
	}
}

//Find the current electricity savings percentage
int currentElectricitySavings = 0;

J_EAConsumption consumptionEAELECTRIC = findFirst(p_gridConnection.c_consumptionAssets, consumptionAsset -> consumptionAsset.getEAType() == OL_EnergyAssetType.ELECTRICITY_DEMAND);
if (consumptionEAELECTRIC != null){
	currentElectricitySavings = roundToInt((consumptionEAELECTRIC.getConsumptionScaling_fr() - 1)*-100);
}
else{
	J_EAProfile profileEAELECTRIC = findFirst(p_gridConnection.c_profileAssets, profileAsset -> profileAsset.getAssetFlowCategory() == OL_AssetFlowCategories.fixedConsumptionElectric_kW);
	if (profileEAELECTRIC != null){
		currentElectricitySavings = roundToInt((profileEAELECTRIC.getProfileScaling_fr() - 1)*-100);
	}
}

//Find the current Connection capacity (delivery)
double GCContractCapacityCurrent_Delivery = p_gridConnection.v_liveConnectionMetaData.getDefaultContractedDeliveryCapacity_kW();

//Find the current Connection capacity (feedin)
double GCContractCapacityCurrent_Feedin = p_gridConnection.v_liveConnectionMetaData.getDefaultContractedFeedinCapacity_kW();

//Set the nfato values
f_getNFATOValues();

//Find the current battery capacity
int BatteryCapacityCurrent = 0;
J_EAStorage batteryAsset = findFirst(p_gridConnection.c_storageAssets, p -> p.getEAType() == OL_EnergyAssetType.STORAGE_ELECTRIC );
if (batteryAsset != null){
	BatteryCapacityCurrent = roundToInt(((J_EAStorageElectric)batteryAsset).getStorageCapacity_kWh());
}

//Find the current PV capacity
int PVCapacityCurrent = 0;
if (p_gridConnection.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW)){
	J_EAProduction pvAsset = findFirst(p_gridConnection.c_productionAssets, p -> p.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC );
	PVCapacityCurrent = roundToInt(pvAsset.getCapacityElectric_kW());
}

//Find the current curtailment setting
boolean currentCurtailmentSetting = p_gridConnection.f_isAssetManagementActive(I_CurtailManagement.class);

//Find the current transport savings
int currentTransportSavings = 0;
if (p_gridConnection.c_tripTrackers.size() > 0){
	currentTransportSavings = - roundToInt(p_gridConnection.c_tripTrackers.get(0).getDistanceScaling_fr()*100) + 100;
}


//Find the current number of vehicles for each type
int nbEcarsCurrent = count(p_gridConnection.c_electricVehicles, p->p.getEAType() == OL_EnergyAssetType.ELECTRIC_VEHICLE);
int nbHydrogencarsCurrent = count(p_gridConnection.c_hydrogenVehicles, p->p.getEAType() == OL_EnergyAssetType.HYDROGEN_VEHICLE);
int nbPetroleumFuelcarsCurrent = count(p_gridConnection.c_petroleumFuelVehicles, p->p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE);

int nbEvansCurrent = count(p_gridConnection.c_electricVehicles, p->p.getEAType() == OL_EnergyAssetType.ELECTRIC_VAN);
int nbHydrogenvansCurrent = count(p_gridConnection.c_hydrogenVehicles, p->p.getEAType() == OL_EnergyAssetType.HYDROGEN_VAN);
int nbPetroleumFuelvansCurrent = count(p_gridConnection.c_petroleumFuelVehicles, p->p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VAN);

int nbEtrucksCurrent = count(p_gridConnection.c_electricVehicles, p->p.getEAType() == OL_EnergyAssetType.ELECTRIC_TRUCK);
int nbHydrogentrucksCurrent = count(p_gridConnection.c_hydrogenVehicles, p->p.getEAType() == OL_EnergyAssetType.HYDROGEN_TRUCK);
int nbPetroleumFueltrucksCurrent = count(p_gridConnection.c_petroleumFuelVehicles, p->p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK);

//Check on electric cars, cause for companies that have quarterlyhour electricity data, the initial ea for EV (and other electric appliances) are not made.
if (p_gridConnection.v_hasQuarterHourlyValues){
	
	nbEcarsCurrent += v_minEVCarSlider;
	nbEvansCurrent += v_minEVVanSlider;
	nbEtrucksCurrent += v_minEVTruckSlider;
}


////Set slider knobs at the currently (!) correct points

//heating
rb_heatingTypePrivateUI.setValue(nr_currentHeatingType, false);		

//Heat savings
sl_heatDemandCompanyReduction.setValue(currentHeatSavings, false);

//Electricity savings
sl_electricityDemandCompanyReduction.setValue(currentElectricitySavings, false);

//Contract connection capacity (delivery)
sl_GCCapacityCompany.setValue(GCContractCapacityCurrent_Delivery, false);
v_defaultContractDeliveryCapacity_kW = GCContractCapacityCurrent_Delivery;

//Contract connection capacity (feedin)
sl_GCCapacityCompany_Feedin.setValue(GCContractCapacityCurrent_Feedin, false);
v_defaultContractFeedinCapacity_kW = GCContractCapacityCurrent_Feedin;

//Battery capacity
sl_batteryCompany.setValue(BatteryCapacityCurrent, false);
v_defaultBatSlider = BatteryCapacityCurrent;

//Solar panel power
sl_rooftopPVCompany.setValue(PVCapacityCurrent, false);
v_defaultPVSlider = PVCapacityCurrent;

//Curtailment setting
cb_curtailmentCompany.setSelected(currentCurtailmentSetting, false);


//Mobility savings
sl_mobilityDemandCompanyReduction.setValue(currentTransportSavings, false);

//Cars 
sl_electricCarsCompany.setValue(nbEcarsCurrent, false);
sl_hydrogenCarsCompany.setValue(nbHydrogencarsCurrent, false);
sl_petroleumFuelCarsCompany.setValue(nbPetroleumFuelcarsCurrent, false);

v_nbEVCars = nbEcarsCurrent;
v_nbHydrogenCars = nbHydrogencarsCurrent;
v_nbPetroleumFuelCars = nbPetroleumFuelcarsCurrent;


//Vans
sl_electricVansCompany.setValue(nbEvansCurrent, false);
sl_hydrogenVansCompany.setValue(nbHydrogenvansCurrent, false);
sl_petroleumFuelVansCompany.setValue(nbPetroleumFuelvansCurrent, false);

v_nbEVVans = nbEvansCurrent;
v_nbHydrogenVans = nbHydrogenvansCurrent;
v_nbPetroleumFuelVans = nbPetroleumFuelvansCurrent;


//Trucks
sl_electricTrucksCompany.setValue(nbEtrucksCurrent, false);
sl_hydrogenTrucksCompany.setValue(nbHydrogentrucksCurrent, false);
sl_petroleumFuelTrucksCompany.setValue(nbPetroleumFueltrucksCurrent, false);

v_nbEVTrucks = nbEtrucksCurrent;
v_nbHydrogenTrucks = nbHydrogentrucksCurrent;
v_nbPetroleumFuelTrucks = nbPetroleumFueltrucksCurrent; 
  }

  void f_selectGCOnMainInterface(  ) { 

//Select the newly selected GC also on the main interface (if not paused)
zero_Interface.f_clearSelectionAndSelectEnergyModel();

if(p_gridConnection.v_isActive){
	zero_Interface.f_selectBuilding(p_gridConnection.c_connectedGISObjects.get(0), p_gridConnection.c_connectedGISObjects);
} 
  }

  public void f_setSimulateYearScreen(  ) { 

if(!b_runningMainInterfaceScenarioSettings && !b_runningMainInterfaceSlider){
	//Update main interface sliders according to the companyUI changes 
	zero_Interface.f_updateMainInterfaceSliders();
	
	//Set it for main interface as well
	zero_Interface.f_resetSettings();
	
	//Update variable to change to custom scenario
	zero_Interface.f_setScenarioToCustom();
} 
  }

  void f_setGCCapacitySliderPresets(  ) { 

////Get current physical capacity
v_physicalConnectionCapacity_kW = p_scenarioSettings_Current.getCurrentPhysicalConnectionCapacity_kW();

////Delivery
//Set back end range (to prevent anylogic errors)
sl_GCCapacityCompany.setRange(0, 100000);

//Get current grid capacity
double defaultGCCapacitySlider = p_scenarioSettings_Current.getCurrentContractDeliveryCapacity_kW();

//Get future grid capacity
double futureGCCapacity_delivery_kW = p_scenarioSettings_Future.getRequestedContractDeliveryCapacity_kW();

//Set range specific for specific intervals of capacity
v_minContractDeliveryCapacity_kW = 0;
v_maxContractDeliveryCapacity_kW = v_physicalConnectionCapacity_kW;
v_defaultContractDeliveryCapacity_kW = roundToInt(defaultGCCapacitySlider);

//Set slider knob
sl_GCCapacityCompany.setValue(v_defaultContractDeliveryCapacity_kW, false);


////Feedin
//Set back end range (to prevent anylogic errors)
sl_GCCapacityCompany_Feedin.setRange(0, 100000);

//Get current grid capacity
double defaultGCCapacitySlider_Feedin = p_scenarioSettings_Current.getCurrentContractFeedinCapacity_kW();

//Set range specific for specific intervals of capacity
v_minContractFeedinCapacity_kW = 0;
v_maxContractFeedinCapacity_kW = v_physicalConnectionCapacity_kW;
v_defaultContractFeedinCapacity_kW = roundToInt(defaultGCCapacitySlider_Feedin);

//Set slider knob
sl_GCCapacityCompany_Feedin.setValue(v_defaultContractFeedinCapacity_kW, false); 
  }

  void f_setNameTextSize(  ) { 

if (p_companyName == null) {
    return;
}

int excess = p_companyName.length() - 24;
if (excess > 0){
	t_companyName.setScale(pow(0.9, excess));
}
//Works for now: Possible to make it more accurate using getFontMetrics package and comparing width of text with the name text box width.
//--> Not done for now. 
  }

  void f_getNFATOValues(  ) { 

v_NFATO_active = p_gridConnection.v_liveConnectionMetaData.hasCapacitySharingContract();
v_NFATO_kW_delivery = p_gridConnection.v_liveConnectionMetaData.getCurrentSharedDeliveryCapacity_kW();
v_NFATO_kW_feedin = p_gridConnection.v_liveConnectionMetaData.getCurrentSharedFeedinCapacity_kW();

if(v_NFATO_kW_delivery > 0){
	t_GCCapacityCompany_delivery_nfato.setColor(green);
}
else if(v_NFATO_kW_delivery < 0){
	t_GCCapacityCompany_delivery_nfato.setColor(red);
}
else{
	t_GCCapacityCompany_delivery_nfato.setColor(black);
}

if(v_NFATO_kW_feedin > 0){
	t_GCCapacityCompany_Feedin_nfato.setColor(green);
}
else if(v_NFATO_kW_feedin < 0){
	t_GCCapacityCompany_Feedin_nfato.setColor(red);
}
else{
	t_GCCapacityCompany_Feedin_nfato.setColor(black);
}
 
  }

  public void f_enableAllSliders( boolean enable ) { 

sl_heatDemandCompanyReduction.setEnabled(enable);
rb_heatingTypePrivateUI.setEnabled(enable);

sl_electricityDemandCompanyReduction.setEnabled(enable);
sl_GCCapacityCompany.setEnabled(enable);
sl_GCCapacityCompany_Feedin.setEnabled(enable);
sl_batteryCompany.setEnabled(enable);
sl_rooftopPVCompany.setEnabled(enable);
cb_curtailmentCompany.setEnabled(enable);

sl_mobilityDemandCompanyReduction.setEnabled(enable);

sl_electricCarsCompany.setEnabled(enable);
sl_hydrogenCarsCompany.setEnabled(enable);
sl_petroleumFuelCarsCompany.setEnabled(enable);

sl_electricVansCompany.setEnabled(enable);
sl_hydrogenVansCompany.setEnabled(enable);
sl_petroleumFuelVansCompany.setEnabled(enable);

sl_electricTrucksCompany.setEnabled(enable);
sl_hydrogenTrucksCompany.setEnabled(enable);
sl_petroleumFuelTrucksCompany.setEnabled(enable);

// Disabled / Invisible heating based on current scenario settings
if (enable) {
	f_setHeatingRB();
} 
  }

  public void f_setErrorScreen( String errorMessage ) { 

//Reset location and height
button_errorOK.setY(50);
rect_errorMessage.setY(-120);
rect_errorMessage.setHeight(200);
t_errorMessage.setY(-70);

//Set position above all other things
presentation.remove(gr_errorScreen);
presentation.insert(presentation.size(), gr_errorScreen);

int width_numberOfCharacters = 44;

// Set Text
Pair<String, Integer> p = zero_Interface.v_infoText.restrictWidth(errorMessage, width_numberOfCharacters);
errorMessage = p.getFirst();
int numberOfLines = p.getSecond();
int additionalLines = max(0, numberOfLines - 3);

// Set Size
rect_errorMessage.setHeight(rect_errorMessage.getHeight() + additionalLines * 40);
rect_errorMessage.setY(rect_errorMessage.getY() - 40 * additionalLines);
//button_errorOK.setY(button_errorOK.getY() - 10 * additionalLines);
t_errorMessage.setY(t_errorMessage.getY() - 40 * additionalLines);

t_errorMessage.setText(errorMessage);
gr_errorScreen.setVisible(true); 
  }

  void f_setDemandReductionSliderPresets(  ) { 

v_minSavingsSliders = p_minSavingsSliders_default;
v_maxSavingsSliders = p_maxSavingsSliders_default;
sl_heatDemandCompanyReduction.setRange(v_minSavingsSliders, v_maxSavingsSliders);
sl_electricityDemandCompanyReduction.setRange(v_minSavingsSliders, v_maxSavingsSliders);
sl_mobilityDemandCompanyReduction.setRange(v_minSavingsSliders, v_maxSavingsSliders); 
  }

  void f_selectDifferentOwnedGC( int selectedOwnedGCIndex ) { 

//Set companyUI to the new GC
f_setCompanyUI(p_gridConnection.p_owner.f_getOwnedGridConnections().get(selectedOwnedGCIndex));

//Select the gc on the main interface (map) aswell
f_selectGCOnMainInterface();

 
  }

  void f_rapidRunFromCompanyUI(  ) { 

//Set correct overlay
gr_simulateYearScreen.setVisible(false);		
gr_loadIcon.setVisible(true);
		

//Run simulation
new Thread( () -> {	
	zero_Interface.energyModel.f_runRapidSimulation();
	zero_Interface.uI_Results.f_updateResultsUI(zero_Interface.energyModel);
	f_updateUIResultsCompanyUI();
	gr_loadIcon.setVisible(false);
	
	//Update and show kpi summary chart after run
	if(zero_Interface.settings.showKPISummary() != null && zero_Interface.settings.showKPISummary()){
		uI_Results.getCheckbox_KPISummary().setSelected(true, true);
	}
	
	//Update results up to date boolean
	uI_Results.f_enableNonLivePlotRadioButtons(true);
	zero_Interface.b_resultsUpToDate = true;
	zero_Interface.gr_simulateYear.setVisible(false);
	zero_Interface.uI_Results.f_enableNonLivePlotRadioButtons(true);
	
}).start();
 
  }

  void f_activateDailyDifferenceButtons( boolean activate ) { 

map_dayToEnableDayButtons.values().forEach(cb -> cb.setEnabled(activate));

if(!activate){
	map_dayToEnableDayButtons.values().forEach(cb -> cb.setSelected(true, true));
}

map_dayToDisableRectangles.entrySet().stream()
    .filter(entry -> entry.getKey() != OL_Days.MONDAY)
    .forEach(entry -> entry.getValue().setVisible(!activate));
     
  }

  void f_confirmVehicleTripsConfiguration( OL_VehicleType vehicleType ) { 

if(f_createCustomTripConfiguration(vehicleType)){
	f_replaceAllCurrentTripTrackersWithCustom(vehicleType);
} 
  }

  void f_openVehicleTripsConfigurationMenu( OL_VehicleType vehicleType ) { 

String vehicleTypeString = "";
String pluralAddition = "";
switch(vehicleType){
	case CAR:
		vehicleTypeString = "Auto";
		pluralAddition = "'s";
		break;
	case VAN:
		vehicleTypeString = "Busje";
		pluralAddition = "s";
		break;
	case TRUCK:
		vehicleTypeString = "Truck";
		pluralAddition = "s";
		break;
}

t_tripConfiguratorExplanation.setText("Wanneer zijn je " + vehicleTypeString + pluralAddition + " onderweg?");
t_configureVehicleTrips_km.setText("Weeklijks gereden afstand per " + vehicleTypeString + ":");
v_currentTripConfiguringVehicleType = vehicleType;
f_initializeVehicleTripsConfigurationMenuButtons(vehicleType);
gr_configureVehicleTrips.setVisible(true); 
  }

  
boolean 
 f_createCustomTripConfiguration( OL_VehicleType vehicleType ) { 


boolean[][] tripMatrix = f_getTripBooleanMatrix();
double weeklyTravelDistance_km = eb_configureVehicleTrips_weeklyDistance_km.getDoubleValue();

//Validate values and continue
if(J_CustomTripTrackerGenerator.checkIfCustomTripInputsAreValid(tripMatrix, weeklyTravelDistance_km)){
	//Store this setting, so buttons can be brought back to this when reopening the menu for this gc and vehicle type
	Map<OL_VehicleType, J_CustomTripTrackerGenerator.StoredTripConfiguration> storeGCVehicleCustomTripValuesMap = map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid);
	if(storeGCVehicleCustomTripValuesMap == null){
		map_storedCustomTripButtonConfiguration.put(p_gridConnection.p_uid, new HashMap<>());
	}
	
	J_CustomTripTrackerGenerator.StoredTripConfiguration storedTripButtonConfiguration = new J_CustomTripTrackerGenerator.StoredTripConfiguration(tripMatrix, weeklyTravelDistance_km, cb_configureVehicleTrips_dailyDistinction.isSelected(), c_activeVehicleConfigurationDays);
	map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid).put(vehicleType, storedTripButtonConfiguration);
	
	//Create customTripRecords
	List<J_ActivityTrackerTrips.TripRecord> customTripRecords = J_CustomTripTrackerGenerator.getCustomTripTrackerRecords(f_getTripBooleanMatrix(), weeklyTravelDistance_km); 
	
	//Add it to stored custom trip values maps
	Map<OL_VehicleType, List<J_ActivityTrackerTrips.TripRecord>> GCCustomTripRecordsMap = map_createdCustomTripWeeklyConfiguration.get(p_gridConnection.p_uid);
	if(GCCustomTripRecordsMap == null){
		map_createdCustomTripWeeklyConfiguration.put(p_gridConnection.p_uid, new HashMap<>());
	}
	map_createdCustomTripWeeklyConfiguration.get(p_gridConnection.p_uid).put(vehicleType, customTripRecords);
	
	return true;
}
else{
	f_setErrorScreen("De custom rijtijden configuratie is niet doorgevoerd, door een onbekende error.");
	return false;
} 
  }

  void f_replaceAllCurrentTripTrackersWithCustom( OL_VehicleType vehicleType ) { 

List<J_ActivityTrackerTrips.TripRecord> customTripRecords = map_createdCustomTripWeeklyConfiguration.get(p_gridConnection.p_uid).get(vehicleType);

J_TimeVariables timeVariables = zero_Interface.energyModel.p_timeVariables;
J_TimeParameters timeParameters = zero_Interface.energyModel.p_timeParameters;

for(I_Vehicle vehicle : findAll(p_gridConnection.c_vehicleAssets, veh -> veh.getVehicleType() == vehicleType)){
	//First get the old trip tracker
	J_ActivityTrackerTrips currentTripTracker = vehicle.getTripTracker();
	
	//Before creating new triptracker, that automatically connects EV again to chargepoint, remove it from chargepoint first.
	if(vehicle instanceof J_EAEV ev && p_gridConnection.f_getChargePoint().isRegistered(ev)){
		p_gridConnection.f_getChargePoint().deregisterChargingRequest(ev);
	}
	
	//Create new triptracker and add to vehicle
	J_ActivityTrackerTrips newCustomTripTracker = new J_ActivityTrackerTrips(customTripRecords, vehicle, p_gridConnection.f_getChargePoint(), timeParameters, timeVariables); 	
	
	//Replace current with new one
	f_replaceTripTrackerWithOtherTripTracker(currentTripTracker, newCustomTripTracker);
	
	//Create/maintain link with original and new trip tracker
	f_storeOriginalTripTracker(currentTripTracker, newCustomTripTracker);
}
 
  }

  void f_storeOriginalTripTracker( J_ActivityTrackerTrips oldTripTracker, J_ActivityTrackerTrips newTripTracker ) { 

Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips> thisGCCustomToOriginalTripTrackerMap = map_customTripTrackerToOriginal.get(p_gridConnection.p_uid);

//Check if map already exists, if not: initialize new map for this GC
if(thisGCCustomToOriginalTripTrackerMap == null){
	thisGCCustomToOriginalTripTrackerMap = new HashMap();
	map_customTripTrackerToOriginal.put(p_gridConnection.p_uid, thisGCCustomToOriginalTripTrackerMap);
}

//Update or add custom to original Triptracker link.
if(thisGCCustomToOriginalTripTrackerMap.get(oldTripTracker) != null){
	thisGCCustomToOriginalTripTrackerMap.put(newTripTracker, thisGCCustomToOriginalTripTrackerMap.get(oldTripTracker));
	thisGCCustomToOriginalTripTrackerMap.remove(oldTripTracker);
}
else{
	thisGCCustomToOriginalTripTrackerMap.put(newTripTracker, oldTripTracker);
} 
  }

  void f_initializeVehicleTripsConfigurationMenuButtons( OL_VehicleType vehicleType ) { 

if(map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid) != null &&
	map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid).get(vehicleType) != null){
	boolean[][] previousButtonConfigurationMatrix = map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid).get(vehicleType).buttonConfigurationMatrix();
	double previousWeeklyTravelDistance_km = map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid).get(vehicleType).weeklyTravelDistance_km();
	boolean dailyDistinctionEnabled = map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid).get(vehicleType).dailyDistinctionEnabled();
    Set<OL_Days> activeDays = map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid).get(vehicleType).activeDays();

	//Set dailyDifferenceEnabled button correctly
	cb_configureVehicleTrips_dailyDistinction.setSelected(dailyDistinctionEnabled, true);

	for(OL_Days day : J_TimeParameters.getOrderedDaysList()){
		map_dayToEnableDayButtons.get(day).setSelected(activeDays.contains(day), true);
	}
	//Set all buttons to correct values
	f_setAllVehicleTripsConfigurationButtonsToInputMatrix(previousButtonConfigurationMatrix);
	
	//Set weekly travel distance to correct value;
	eb_configureVehicleTrips_weeklyDistance_km.setText(BigDecimal.valueOf(previousWeeklyTravelDistance_km).stripTrailingZeros().toPlainString(), false);
}
else{ // No previous configuration for this GC and/or vehicle type -> Everything at default values
	f_setAllVehicleTripsConfigurationButtonsToDefault();
}
 
  }

  void f_closeVehicleTripsConfigurationMenu(  ) { 

gr_configureVehicleTrips.setVisible(false);
v_currentTripConfiguringVehicleType = null; 
  }

  void f_addNewInstanceOfCustomTripTrackerToAdditionalVehicle( I_Vehicle vehicle ) { 

//Check if this vehicle should get a custom triptracker
if(map_createdCustomTripWeeklyConfiguration.get(p_gridConnection.p_uid) != null && map_createdCustomTripWeeklyConfiguration.get(p_gridConnection.p_uid).get(vehicle) != null){
	//Get the records for the custom triptracker
	List<J_ActivityTrackerTrips.TripRecord> customTripRecords = map_createdCustomTripWeeklyConfiguration.get(p_gridConnection.p_uid).get(vehicle);
	
	J_TimeVariables timeVariables = zero_Interface.energyModel.p_timeVariables;
	J_TimeParameters timeParameters = zero_Interface.energyModel.p_timeParameters;
	
	//Get the old trip tracker
	J_ActivityTrackerTrips currentTripTracker = vehicle.getTripTracker();
	
	//Before creating new triptracker, that automatically connects EV again to chargepoint, remove it from chargepoint first.
	if(vehicle instanceof J_EAEV ev && p_gridConnection.f_getChargePoint().isRegistered(ev)){
		p_gridConnection.f_getChargePoint().deregisterChargingRequest(ev);
	}
	
	//Create new triptracker
	J_ActivityTrackerTrips newCustomTripTracker = new J_ActivityTrackerTrips(customTripRecords, vehicle, p_gridConnection.f_getChargePoint(), timeParameters, timeVariables); 	
	
	//Replace current with new one
	f_replaceTripTrackerWithOtherTripTracker(currentTripTracker, newCustomTripTracker);
} 	 
  }

  void f_resetAllVehiclesToOriginalTripTracker(  ) { 

Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips> GCcustomTripTrackerToOriginalMap = map_customTripTrackerToOriginal.get(p_gridConnection.p_uid);

if(GCcustomTripTrackerToOriginalMap != null && !GCcustomTripTrackerToOriginalMap.isEmpty()){
	for(I_Vehicle vehicle : p_gridConnection.c_vehicleAssets){
		J_ActivityTrackerTrips originalTripTracker = GCcustomTripTrackerToOriginalMap.get(vehicle.getTripTracker());
		if(originalTripTracker != null){
			//Reverse custom triptracker to original
			originalTripTracker.setVehicle(vehicle); //Needed, cause vehicleEA might have changed for this trip tracker
			f_replaceTripTrackerWithOtherTripTracker(vehicle.getTripTracker(), originalTripTracker);
		}
	}
	//Clear the links
	GCcustomTripTrackerToOriginalMap.clear();
}

 
  }

  void f_replaceTripTrackerWithOtherTripTracker( J_ActivityTrackerTrips currentTripTracker, J_ActivityTrackerTrips newTripTracker ) { 

I_Vehicle vehicle = currentTripTracker.getVehicle();
J_ChargePoint chargePoint = p_gridConnection.f_getChargePoint();

//Remove current
p_gridConnection.c_tripTrackers.remove(currentTripTracker);
currentTripTracker.setVehicle(null);

if(vehicle instanceof J_EAEV ev && chargePoint.isRegistered(ev)){
	chargePoint.deregisterChargingRequest(ev);
}

//Add new one, and set scaling equally as old one.
newTripTracker.setDistanceScaling_fr(currentTripTracker.getDistanceScaling_fr());
p_gridConnection.c_tripTrackers.add(newTripTracker);
vehicle.setTripTracker(newTripTracker);
vehicle.setAvailability(true);
newTripTracker.setStartIndex(zero_Interface.energyModel.p_timeVariables, chargePoint); 
  }

  void f_resetVehicleTypeToOriginalTripTracker( OL_VehicleType vehicleType ) { 

Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips> GCcustomTripTrackerToOriginalMap = map_customTripTrackerToOriginal.get(p_gridConnection.p_uid);

if(GCcustomTripTrackerToOriginalMap != null && !GCcustomTripTrackerToOriginalMap.isEmpty()){
    for(I_Vehicle vehicle : p_gridConnection.c_vehicleAssets){
    	if(vehicle.getVehicleType() == vehicleType){
            J_ActivityTrackerTrips customTripTracker = vehicle.getTripTracker();
	        J_ActivityTrackerTrips originalTripTracker = GCcustomTripTrackerToOriginalMap.get(customTripTracker);
	        if(originalTripTracker != null){
	            
	            //Reverse custom triptracker to original
	            originalTripTracker.setVehicle(vehicle); //Needed, cause vehicleEA might have changed for this trip tracker
	            f_replaceTripTrackerWithOtherTripTracker(customTripTracker, originalTripTracker);
				
	            //Remove previous link
	            GCcustomTripTrackerToOriginalMap.remove(customTripTracker);
	        }
        }
    }
} 
  }

  void f_setAllVehicleTripsConfigurationButtonsToDefault(  ) { 

//Disable distinction button
cb_configureVehicleTrips_dailyDistinction.setSelected(false, true);
f_setAllVehicleTripsConfigurationButtonsToInputMatrix(matrix_defaultValuesCustomTripButtons);
eb_configureVehicleTrips_weeklyDistance_km.setValueToDefault(); 
  }

  
boolean[][] 
 f_getTripBooleanMatrix(  ) { 

int rows = matrix_vehicleTripsConfigurationButtons.length;
int cols = rows > 0 ? matrix_vehicleTripsConfigurationButtons[0].length : 0;

boolean[][] booleanMatrix = new boolean[rows][cols];

for (int i = 0; i < rows; i++) {
	for (int j = 0; j < cols; j++) {
    
        Color fillColor = matrix_vehicleTripsConfigurationButtons[i][j].getFillColor();
        if (fillColor.equals(p_configureVehicleTripsOnColor)) {
            booleanMatrix[i][j] = true;
        } 
        else { // default for unrecognized colors
            booleanMatrix[i][j] = false;
        }
    }
}

return booleanMatrix; 
  }

  void f_setAllVehicleTripsConfigurationButtonsToInputMatrix( boolean[][] booleanMatrix ) { 

for (int day = 0; day < matrix_vehicleTripsConfigurationButtons.length; day++) {
    for (int hour = 0; hour < matrix_vehicleTripsConfigurationButtons[day].length; hour++) {
        if (booleanMatrix[day][hour]) {
            matrix_vehicleTripsConfigurationButtons[day][hour].setFillColor(p_configureVehicleTripsOnColor);
        } else {
            matrix_vehicleTripsConfigurationButtons[day][hour].setFillColor(p_configureVehicleTripsOffColor);
        }
    }
} 
  }

  void f_initializeDayToDisableRectanglesMap(  ) { 

//Needed, cause groups are created after map initialization, creating errors if done in default value
map_dayToDisableRectangles = new LinkedHashMap<OL_Days, ShapeGroup>();
map_dayToDisableRectangles.put(OL_Days.MONDAY,    gr_disableTripConfigurationButtons_monday);
map_dayToDisableRectangles.put(OL_Days.TUESDAY,   gr_disableTripConfigurationButtons_tuesday);
map_dayToDisableRectangles.put(OL_Days.WEDNESDAY, gr_disableTripConfigurationButtons_wednesday);
map_dayToDisableRectangles.put(OL_Days.THURSDAY,  gr_disableTripConfigurationButtons_thursday);
map_dayToDisableRectangles.put(OL_Days.FRIDAY,    gr_disableTripConfigurationButtons_friday);
map_dayToDisableRectangles.put(OL_Days.SATURDAY,  gr_disableTripConfigurationButtons_saturday);
map_dayToDisableRectangles.put(OL_Days.SUNDAY,    gr_disableTripConfigurationButtons_sunday); 
  }

  void f_setPresentationOrder(  ) { 

presentation.remove(uI_Results_presentation);
presentation.insert(presentation.size()-1, uI_Results_presentation);
presentation.remove(gr_loadIcon);
presentation.insert(presentation.size()-1, gr_loadIcon);
presentation.remove(gr_simulateYearScreen);
presentation.insert(presentation.size()-1, gr_simulateYearScreen);
presentation.remove(gr_configureVehicleTrips);
presentation.insert(presentation.size()-1, gr_configureVehicleTrips);
presentation.remove(gr_GCisPausedScreen);
presentation.insert(presentation.size()-1, gr_GCisPausedScreen); 
  }

  void f_enableSingleDay( boolean enable, OL_Days day ) { 

if(enable){
	c_activeVehicleConfigurationDays.add(day);
}
else{
	c_activeVehicleConfigurationDays.remove(day);
	//Set color of entire row to off, if turned off.
	for(ShapeRectangle rectangle : matrix_vehicleTripsConfigurationButtons[J_TimeParameters.getDayIndexFromDay(day)]){
		rectangle.setFillColor(p_configureVehicleTripsOffColor);
	}
}
map_dayToDisableRectangles.get(day).setVisible(!enable); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea va_companyUI = new ViewArea( this, "company UI", 0, 0, 1920, 980 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1920.0, 980.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "va_companyUI", this.va_companyUI );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _button1_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_scenariosPrivateUI_Font = new Font("Dialog", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button2_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button3_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_openVehicleTripsConfigurationMenu_car_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_openVehicleTripsConfigurationMenu_van_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_openVehicleTripsConfigurationMenu_truck_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_selectGC_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_heatingTypePrivateUI_Font = new Font("Dialog", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_curtailmentCompany_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_showGridloadPlot_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_configureVehicleTrips_dailyDistinction_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_confirm_configureVehicleTrips_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_cancel_configureVehicleTrips_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_configureVehicleTripsMonday_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_configureVehicleTripsTuesday_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_configureVehicleTripsWednesday_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_configureVehicleTripsThursday_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_configureVehicleTripsFriday_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_configureVehicleTripsSaturday_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_configureVehicleTripsSunday_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_configureVehicleTrips_reset_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _eb_configureVehicleTrips_weeklyDistance_km_Font = _button1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_storedScenarios_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_scenario_Font = new Font("Calibri", 1, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_scenarioSettings_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_sliderPresetsAndLimits_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_sliderFunctions_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_initialization_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_uiResult_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_warmte_Font = new Font("Calibri", 1, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_GCCapacity_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text195_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_heatDemandReductionCompanies_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_elektriciteit_Font = _txt_warmte_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mobiliteit_Font = _txt_warmte_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricityDemandReductionCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text279_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text266_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfElectricVansCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text271_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfHydrogenVansCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text285_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfPetroleumFuelVansCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text274_Font = new Font("Dialog", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfPetroleumFuelTrucksCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfHydrogenTrucksCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text272_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text286_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text268_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text275_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfElectricTrucksCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text265_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfElectricCarsCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text267_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_mobilityDemandReductionCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text270_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfHydrogenCarsCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text284_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfPetroleumFuelCarsCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text273_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text9_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_batteryCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text283_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_rooftopSolarCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_PVPower_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_Feedin_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_GCCapacityCompany_Feedin_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_companyName_Font = new Font("SansSerif", 1, 48 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCadress_Font = new Font("SansSerif", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartNameLeft_Font = new Font("SansSerif", 0, 24 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartNameMiddle_Font = _txt_chartNameLeft_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartNameRight_Font = _txt_chartNameLeft_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_simulateYearToCalculateCostsSmall_Font = new Font("SansSerif", 1, 28 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_loadIconSmall_Font = _t_simulateYearToCalculateCostsSmall_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_curtailmentDescriptionCompany_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_nfatoValues_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_additionalGCCapacityInfo_Font = new Font("SansSerif", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = new Font("SansSerif", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = _text1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = _text1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_delivery2_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_Feedin_2_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_physical_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_table_ConnectionCapacityInfo_owned_Font = _txt_additionalGCCapacityInfo_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_table_ConnectionCapacityInfo_nfato_Font = _txt_additionalGCCapacityInfo_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_delivery_nfato_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_Feedin_nfato_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_physical_nfato_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_table_ConnectionCapacityInfo_known_Font = _txt_additionalGCCapacityInfo_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_delivery3_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_Feedin_3_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCCapacityCompany_physical1_Font = _rb_scenariosPrivateUI_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_GCisPausedScreen_Font = _t_simulateYearToCalculateCostsSmall_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_GCisPaused_Font = new Font("SansSerif", 1, 72 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_errorMessage_Font = new Font("SansSerif", 1, 24 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_errorOK_Font = new Font("SansSerif", 1, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_setSimYearScreen_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_selectDifferentOwnedGC_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_configureVehicleTrips_km_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_1_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_2_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_3_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_4_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_5_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_6_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_7_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_8_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_9_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_10_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_11_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_12_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_13_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_14_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_15_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_16_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_17_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_18_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_19_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_20_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_21_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_22_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_23_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_24_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_0_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_weeklyDistance_unit_Font = _text1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_monday_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_tuesday_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_wednesday_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_thursday_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_friday_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_saturday_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureVehicleTrips_sunday_Font = _text274_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_tripConfiguratorExplanation_Font = new Font("Dialog", 1, 18 );
  protected static final Color _ovalTransportButton1_Fill_Color = new Color( 0xFFD7EFF2, true );
  protected static final Color _rect_loadIcon_Fill_Color = new Color( 0xE9F5F5F5, true );
  protected static final Color _rect_loadIcon_Line_Color = new Color( 0xE9F5F5F5, true );
  protected static final Color _rect_GCisPausedScreen_Fill_Color = new Color( 0xE9F5F5F5, true );
  protected static final Color _rect_GCisPausedScreen_Line_Color = new Color( 0xE9F5F5F5, true );
  protected static final Color _rect_errorScreenGrayOut_Fill_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_errorScreenGrayOut_Line_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_errorScreenClickBlocking_Fill_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_errorScreenClickBlocking_Line_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_configureVehicleTripsBackground_Fill_Color = new Color( 0xFF289CA0, true );
  protected static final Color _rect_disableTripConfigurationButtons_monday1_Fill_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_monday1_Line_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_tuesday1_Fill_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_tuesday1_Line_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_sunday1_Fill_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_sunday1_Line_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_saturday1_Fill_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_saturday1_Line_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_friday1_Fill_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_friday1_Line_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_thursday1_Fill_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_thursday1_Line_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_wednesday1_Fill_Color = new Color( 0x96FFFFFF, true );
  protected static final Color _rect_disableTripConfigurationButtons_wednesday1_Line_Color = new Color( 0x96FFFFFF, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_canvas = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_background = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_sliders = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_scenarios = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_storedScenarios = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_scenario = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_scenarioRB = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_scenarioSettings = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_sliderPresetsAndLimits = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_sliderFunctions = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_initialization = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_uiResult = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_warmte = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_GCCapacity = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _text195 = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_heatDemandReductionCompanies = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_heatDemandReductionSlider = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_elektriciteit = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mobiliteit = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricityDemandReductionCompany = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _text279 = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _text266 = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfElectricVansCompany = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _text271 = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfHydrogenVansCompany = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _text285 = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfPetroleumFuelVansCompany = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _text274 = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfPetroleumFuelTrucksCompany = 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfHydrogenTrucksCompany = 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _text272 = 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _text286 = 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _text268 = 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _text275 = 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfElectricTrucksCompany = 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _text265 = 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfElectricCarsCompany = 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _text267 = 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_mobilityDemandReductionCompany = 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _text270 = 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfHydrogenCarsCompany = 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _text284 = 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfPetroleumFuelCarsCompany = 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _text273 = 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_companyMobilitySliders = 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _text9 = 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_selectedGC = 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_batteryCompany = 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _text283 = 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalElectricityButton1 = 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _image4 = 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_electricityButton1 = 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalHeatButton1 = 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _image11 = 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_heatButton1 = 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalTransportButton1 = 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _image16 = 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_transportButton1 = 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _g_energyDemandSettings = 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_rooftopSolarCompany = 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_PVPower = 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany_Feedin = 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_GCCapacityCompany_Feedin = 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_companyUISliders = 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _roundRect_companyName = 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_companyName = 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCadress = 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_companyDetails = 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _uI_Results_presentation = 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _mask_resultsUI1 = 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _mask_resultsUI2 = 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_chartNameLeft = 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartNameLeft = 76;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartNameLeft = 77;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_chartNameMiddle = 78;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartNameMiddle = 79;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartNameMiddle = 80;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_chartNameRight = 81;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartNameRight = 82;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartNameRight = 83;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_simulateYearScreen2 = 84;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_simulateYearToCalculateCostsSmall = 85;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_simulateYearToCalculateCostsSmall = 86;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_simulateYearToCalculateKPIs = 87;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_simulateYearScreen = 88;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_loadIcon = 89;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GCisPausedScreen3 = 90;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_loadIconSmall = 91;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_loadIconSmall = 92;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_loadIconText = 93;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_loadIcon = 94;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_curtailmentDescriptionCompany = 95;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_nfatoValues = 96;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_table_GridconnectionCapacaties = 97;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_additionalGCCapacityInfo = 98;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 99;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 100;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 101;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany_delivery2 = 102;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany_Feedin_2 = 103;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany_physical = 104;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_table_ConnectionCapacityInfo_1 = 105;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_table_ConnectionCapacityInfo_owned = 106;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_table_ConnectionCapacityInfo_3 = 107;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_Table_NFATO = 108;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_table_ConnectionCapacityInfo_nfato = 109;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany_delivery_nfato = 110;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany_Feedin_nfato = 111;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany_physical_nfato = 112;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_table_ConnectionCapacityInfo_NFATO = 113;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_table_nfato = 114;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_table_ConnectionCapacityInfo_2 = 115;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_table_ConnectionCapacityInfo_known = 116;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany_delivery3 = 117;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany_Feedin_3 = 118;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCCapacityCompany_physical1 = 119;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_TableConnectionCapacity = 120;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GCisPausedScreen = 121;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GCisPausedScreen2 = 122;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_GCisPausedScreen = 123;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_simulateYearToCalculateCostsSmall1 = 124;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_GCisPausedScreenText = 125;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_GCisPaused = 126;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_GCisPausedScreen = 127;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_errorScreenGrayOut = 128;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_errorScreenClickBlocking = 129;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_errorMessage = 130;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_errorMessage = 131;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_errorOK = 132;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_errorOK = 133;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_errorOK = 134;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_errorScreen = 135;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_setSimYearScreen = 136;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_selectDifferentOwnedGC = 137;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTripsBackground = 138;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_0 = 139;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_1 = 140;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_2 = 141;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_3 = 142;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_4 = 143;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_5 = 144;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_6 = 145;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_7 = 146;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_8 = 147;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_9 = 148;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_10 = 149;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_11 = 150;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_12 = 151;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_13 = 152;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_14 = 153;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_15 = 154;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_16 = 155;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_17 = 156;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_18 = 157;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_19 = 158;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_20 = 159;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_21 = 160;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_22 = 161;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_monday_23 = 162;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_0 = 163;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_0 = 164;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_0 = 165;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_0 = 166;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_0 = 167;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_0 = 168;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_1 = 169;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_1 = 170;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_1 = 171;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_1 = 172;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_1 = 173;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_1 = 174;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_2 = 175;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_2 = 176;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_2 = 177;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_2 = 178;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_2 = 179;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_2 = 180;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_3 = 181;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_3 = 182;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_3 = 183;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_3 = 184;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_3 = 185;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_3 = 186;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_4 = 187;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_4 = 188;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_4 = 189;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_4 = 190;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_4 = 191;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_4 = 192;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_5 = 193;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_5 = 194;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_5 = 195;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_5 = 196;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_5 = 197;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_5 = 198;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_6 = 199;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_6 = 200;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_6 = 201;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_6 = 202;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_6 = 203;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_6 = 204;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_7 = 205;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_7 = 206;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_7 = 207;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_7 = 208;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_7 = 209;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_7 = 210;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_8 = 211;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_8 = 212;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_8 = 213;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_8 = 214;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_8 = 215;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_8 = 216;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_9 = 217;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_9 = 218;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_9 = 219;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_9 = 220;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_9 = 221;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_9 = 222;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_10 = 223;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_10 = 224;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_10 = 225;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_10 = 226;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_10 = 227;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_10 = 228;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_11 = 229;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_11 = 230;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_11 = 231;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_11 = 232;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_11 = 233;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_11 = 234;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_12 = 235;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_12 = 236;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_12 = 237;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_12 = 238;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_12 = 239;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_12 = 240;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_13 = 241;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_13 = 242;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_13 = 243;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_13 = 244;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_13 = 245;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_13 = 246;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_14 = 247;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_14 = 248;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_14 = 249;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_14 = 250;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_14 = 251;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_14 = 252;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_15 = 253;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_15 = 254;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_15 = 255;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_15 = 256;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_15 = 257;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_15 = 258;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_16 = 259;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_16 = 260;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_16 = 261;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_16 = 262;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_16 = 263;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_16 = 264;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_17 = 265;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_17 = 266;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_17 = 267;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_17 = 268;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_17 = 269;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_17 = 270;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_18 = 271;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_18 = 272;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_18 = 273;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_18 = 274;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_18 = 275;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_18 = 276;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_19 = 277;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_19 = 278;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_19 = 279;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_19 = 280;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_19 = 281;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_19 = 282;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_20 = 283;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_20 = 284;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_20 = 285;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_20 = 286;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_20 = 287;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_20 = 288;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_21 = 289;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_21 = 290;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_21 = 291;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_21 = 292;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_21 = 293;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_21 = 294;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_22 = 295;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_22 = 296;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_22 = 297;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_22 = 298;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_22 = 299;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_22 = 300;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_friday_23 = 301;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_sunday_23 = 302;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_tuesday_23 = 303;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_saturday_23 = 304;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_thursday_23 = 305;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_configureVehicleTrips_wednesday_23 = 306;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_configureVehicleTrips_weekButtons = 307;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_configureVehicleTrips_km = 308;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_monday = 309;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_monday1 = 310;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_disableTripConfigurationButtons_monday = 311;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_tuesday = 312;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_tuesday1 = 313;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_disableTripConfigurationButtons_tuesday = 314;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_sunday = 315;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_sunday1 = 316;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_disableTripConfigurationButtons_sunday = 317;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_saturday = 318;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_saturday1 = 319;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_disableTripConfigurationButtons_saturday = 320;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_friday = 321;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_friday1 = 322;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_disableTripConfigurationButtons_friday = 323;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_thursday = 324;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_thursday1 = 325;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_disableTripConfigurationButtons_thursday = 326;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_wednesday = 327;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_disableTripConfigurationButtons_wednesday1 = 328;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_disableTripConfigurationButtons_wednesday = 329;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_tripConfigurationDisableRectangles = 330;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_1 = 331;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_2 = 332;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_3 = 333;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_4 = 334;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_5 = 335;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_6 = 336;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_7 = 337;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_8 = 338;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_9 = 339;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_10 = 340;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_11 = 341;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_12 = 342;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_13 = 343;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_14 = 344;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_15 = 345;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_16 = 346;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_17 = 347;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_18 = 348;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_19 = 349;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_20 = 350;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_21 = 351;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_22 = 352;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_23 = 353;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_24 = 354;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_0 = 355;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_configureVehicleTripsNumbers = 356;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_weeklyDistance_unit = 357;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_monday = 358;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_tuesday = 359;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_wednesday = 360;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_thursday = 361;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_friday = 362;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_saturday = 363;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureVehicleTrips_sunday = 364;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_vehicleTripConfiguratorWeekdays = 365;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_tripConfiguratorExplanation = 366;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_configureVehicleTrips = 367;
  @AnyLogicInternalCodegenAPI
  protected static final int _button1 = 368;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_scenariosPrivateUI = 369;
  @AnyLogicInternalCodegenAPI
  protected static final int _button2 = 370;
  @AnyLogicInternalCodegenAPI
  protected static final int _button3 = 371;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_GCCapacityCompany = 372;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatDemandCompanyReduction = 373;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricityDemandCompanyReduction = 374;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_openVehicleTripsConfigurationMenu_car = 375;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_openVehicleTripsConfigurationMenu_van = 376;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_openVehicleTripsConfigurationMenu_truck = 377;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricVansCompany = 378;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_hydrogenVansCompany = 379;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_petroleumFuelVansCompany = 380;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_hydrogenTrucksCompany = 381;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricTrucksCompany = 382;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_petroleumFuelTrucksCompany = 383;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricCarsCompany = 384;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_mobilityDemandCompanyReduction = 385;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_hydrogenCarsCompany = 386;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_petroleumFuelCarsCompany = 387;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_selectGC = 388;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_batteryCompany = 389;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_heatingTypePrivateUI = 390;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_rooftopPVCompany = 391;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_GCCapacityCompany_Feedin = 392;
  @AnyLogicInternalCodegenAPI
  protected static final int _button = 393;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_curtailmentCompany = 394;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_showGridloadPlot = 395;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_configureVehicleTrips_dailyDistinction = 396;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_confirm_configureVehicleTrips = 397;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_cancel_configureVehicleTrips = 398;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_configureVehicleTripsMonday = 399;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_configureVehicleTripsTuesday = 400;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_configureVehicleTripsWednesday = 401;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_configureVehicleTripsThursday = 402;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_configureVehicleTripsFriday = 403;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_configureVehicleTripsSaturday = 404;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_configureVehicleTripsSunday = 405;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_configureVehicleTrips_reset = 406;
  @AnyLogicInternalCodegenAPI
  protected static final int _eb_configureVehicleTrips_weeklyDistance_km = 407;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 408;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    if (_a == uI_Results) { return true; }
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rect_canvas, rect_background, rect_sliders, rect_scenarios, text, text4, txt_storedScenarios, button1, gr_scenarioRB, txt_scenarioSettings, txt_sliderPresetsAndLimits, txt_sliderFunctions, button2, button3, txt_initialization, txt_uiResult, gr_companyUISliders, button, gr_companyDetails, uI_Results_presentation, mask_resultsUI1, mask_resultsUI2, gr_chartNameLeft, gr_chartNameMiddle, gr_chartNameRight, gr_simulateYearScreen, gr_loadIcon, txt_curtailmentDescriptionCompany, cb_curtailmentCompany, txt_nfatoValues, gr_TableConnectionCapacity, gr_GCisPausedScreen, cb_showGridloadPlot, gr_errorScreen, txt_setSimYearScreen, txt_selectDifferentOwnedGC, gr_configureVehicleTrips);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _gr_simulateYearToCalculateKPIs:
        if (true) {
          ShapeGroup self = this.gr_simulateYearToCalculateKPIs;
          
f_rapidRunFromCompanyUI(); 
        }
        break;
      case _gr_GCisPausedScreenText:
        if (true) {
          ShapeGroup self = this.gr_GCisPausedScreenText;
          
//Set correct overlay
gr_simulateYearScreen.setVisible(false);		
gr_loadIcon.setVisible(true);
rect_GCisPausedScreen3.setVisible(true);

//Unpause gc
p_gridConnection.f_setActive(true, zero_Interface.energyModel.p_timeVariables);
zero_Interface.b_resultsUpToDate = false;
zero_Interface.f_setScenarioToCustom();
f_enableAllSliders(true);


//Run simulation
new Thread( () -> {	
	
	//Run rapid run in engine
	zero_Interface.energyModel.f_runRapidSimulation();
	
	//Update map selection and resultsUIs
	f_selectGCOnMainInterface();
	f_updateUIResultsCompanyUI();
	
	//Update and show kpi summary chart after run
	if(zero_Interface.settings.showKPISummary() != null && zero_Interface.settings.showKPISummary()){
		uI_Results.getCheckbox_KPISummary().setSelected(true, true);
	}
	
	//Remove all simulation screens
	zero_Interface.f_removeAllSimulateYearScreens();
	rect_GCisPausedScreen3.setVisible(false);
}).start();


//Update results up to date boolean
zero_Interface.b_resultsUpToDate = true;
 
        }
        break;
      case _rect_errorScreenClickBlocking:
        if (true) {
          ShapeRectangle self = this.rect_errorScreenClickBlocking;
          
double click_block = 0; 
        }
        break;
      case _button_errorOK:
        if (true) {
          ShapeGroup self = this.button_errorOK;
          
gr_errorScreen.setVisible(false); 
        }
        break;
      case _rect_configureVehicleTrips_monday_0:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_0;
          
if(rect_configureVehicleTrips_monday_0.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_0.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][0].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_0.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][0].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_1:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_1;
          
if(rect_configureVehicleTrips_monday_1.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_1.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][1].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_1.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][1].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_2:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_2;
          
if(rect_configureVehicleTrips_monday_2.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_2.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][2].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_2.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][2].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_3:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_3;
          
if(rect_configureVehicleTrips_monday_3.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_3.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][3].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_3.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][3].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_4:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_4;
          
if(rect_configureVehicleTrips_monday_4.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_4.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][4].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_4.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][4].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_5:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_5;
          
if(rect_configureVehicleTrips_monday_5.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_5.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][5].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_5.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][5].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_6:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_6;
          
if(rect_configureVehicleTrips_monday_6.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_6.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][6].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_6.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][6].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_7:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_7;
          
if(rect_configureVehicleTrips_monday_7.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_7.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][7].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_7.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][7].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_8:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_8;
          
if(rect_configureVehicleTrips_monday_8.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_8.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][8].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_8.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][8].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_9:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_9;
          
if(rect_configureVehicleTrips_monday_9.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_9.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][9].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_9.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][9].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_10:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_10;
          
if(rect_configureVehicleTrips_monday_10.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_10.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][10].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_10.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][10].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_11:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_11;
          
if(rect_configureVehicleTrips_monday_11.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_11.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][11].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_11.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][11].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_12:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_12;
          
if(rect_configureVehicleTrips_monday_12.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_12.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][12].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_12.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][12].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_13:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_13;
          
if(rect_configureVehicleTrips_monday_13.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_13.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][13].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_13.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][13].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_14:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_14;
          
if(rect_configureVehicleTrips_monday_14.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_14.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][14].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_14.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][14].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_15:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_15;
          
if(rect_configureVehicleTrips_monday_15.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_15.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][15].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_15.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][15].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_16:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_16;
          
if(rect_configureVehicleTrips_monday_16.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_16.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][16].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_16.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][16].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_17:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_17;
          
if(rect_configureVehicleTrips_monday_17.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_17.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][17].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_17.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][17].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_18:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_18;
          
if(rect_configureVehicleTrips_monday_18.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_18.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][18].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_18.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][18].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_19:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_19;
          
if(rect_configureVehicleTrips_monday_19.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_19.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][19].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_19.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][19].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_20:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_20;
          
if(rect_configureVehicleTrips_monday_20.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_20.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][20].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_20.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][20].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_21:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_21;
          
if(rect_configureVehicleTrips_monday_21.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_21.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][21].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_21.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][21].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_22:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_22;
          
if(rect_configureVehicleTrips_monday_22.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_22.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][22].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_22.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][22].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_monday_23:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_monday_23;
          
if(rect_configureVehicleTrips_monday_23.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_monday_23.setFillColor(p_configureVehicleTripsOnColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][23].setFillColor(p_configureVehicleTripsOnColor);
		}
	}
}
else{
	rect_configureVehicleTrips_monday_23.setFillColor(p_configureVehicleTripsOffColor);
	if(!cb_configureVehicleTrips_dailyDistinction.isSelected()){
		for (int row = 1; row < matrix_vehicleTripsConfigurationButtons.length; row++) {
		    matrix_vehicleTripsConfigurationButtons[row][23].setFillColor(p_configureVehicleTripsOffColor);
		}
	}
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_0:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_0;
          
if(rect_configureVehicleTrips_tuesday_0.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_0.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_0.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_0:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_0;
          
if(rect_configureVehicleTrips_wednesday_0.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_0.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_0.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_0:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_0;
          
if(rect_configureVehicleTrips_thursday_0.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_0.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_0.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_0:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_0;
          
if(rect_configureVehicleTrips_friday_0.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_0.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_0.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_0:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_0;
          
if(rect_configureVehicleTrips_saturday_0.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_0.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_0.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_0:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_0;
          
if(rect_configureVehicleTrips_sunday_0.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_0.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_0.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_1:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_1;
          
if(rect_configureVehicleTrips_wednesday_1.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_1.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_1.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_1:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_1;
          
if(rect_configureVehicleTrips_thursday_1.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_1.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_1.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_1:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_1;
          
if(rect_configureVehicleTrips_tuesday_1.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_1.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_1.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_1:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_1;
          
if(rect_configureVehicleTrips_sunday_1.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_1.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_1.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_1:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_1;
          
if(rect_configureVehicleTrips_friday_1.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_1.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_1.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_1:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_1;
          
if(rect_configureVehicleTrips_saturday_1.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_1.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_1.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_2:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_2;
          
if(rect_configureVehicleTrips_wednesday_2.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_2.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_2.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_2:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_2;
          
if(rect_configureVehicleTrips_thursday_2.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_2.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_2.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_2:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_2;
          
if(rect_configureVehicleTrips_tuesday_2.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_2.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_2.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_2:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_2;
          
if(rect_configureVehicleTrips_sunday_2.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_2.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_2.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_2:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_2;
          
if(rect_configureVehicleTrips_friday_2.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_2.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_2.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_2:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_2;
          
if(rect_configureVehicleTrips_saturday_2.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_2.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_2.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_3:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_3;
          
if(rect_configureVehicleTrips_wednesday_3.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_3.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_3.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_3:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_3;
          
if(rect_configureVehicleTrips_thursday_3.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_3.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_3.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_3:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_3;
          
if(rect_configureVehicleTrips_tuesday_3.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_3.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_3.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_3:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_3;
          
if(rect_configureVehicleTrips_sunday_3.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_3.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_3.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_3:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_3;
          
if(rect_configureVehicleTrips_friday_3.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_3.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_3.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_3:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_3;
          
if(rect_configureVehicleTrips_saturday_3.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_3.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_3.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_4:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_4;
          
if(rect_configureVehicleTrips_friday_4.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_4.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_4.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_4:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_4;
          
if(rect_configureVehicleTrips_sunday_4.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_4.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_4.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_4:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_4;
          
if(rect_configureVehicleTrips_tuesday_4.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_4.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_4.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_4:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_4;
          
if(rect_configureVehicleTrips_saturday_4.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_4.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_4.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_4:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_4;
          
if(rect_configureVehicleTrips_thursday_4.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_4.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_4.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_4:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_4;
          
if(rect_configureVehicleTrips_wednesday_4.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_4.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_4.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_5:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_5;
          
if(rect_configureVehicleTrips_friday_5.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_5.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_5.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_5:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_5;
          
if(rect_configureVehicleTrips_sunday_5.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_5.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_5.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_5:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_5;
          
if(rect_configureVehicleTrips_tuesday_5.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_5.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_5.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_5:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_5;
          
if(rect_configureVehicleTrips_saturday_5.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_5.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_5.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_5:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_5;
          
if(rect_configureVehicleTrips_thursday_5.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_5.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_5.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_5:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_5;
          
if(rect_configureVehicleTrips_wednesday_5.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_5.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_5.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_6:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_6;
          
if(rect_configureVehicleTrips_friday_6.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_6.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_6.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_6:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_6;
          
if(rect_configureVehicleTrips_sunday_6.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_6.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_6.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_6:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_6;
          
if(rect_configureVehicleTrips_tuesday_6.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_6.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_6.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_6:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_6;
          
if(rect_configureVehicleTrips_saturday_6.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_6.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_6.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_6:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_6;
          
if(rect_configureVehicleTrips_thursday_6.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_6.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_6.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_6:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_6;
          
if(rect_configureVehicleTrips_wednesday_6.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_6.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_6.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_7:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_7;
          
if(rect_configureVehicleTrips_friday_7.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_7.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_7.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_7:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_7;
          
if(rect_configureVehicleTrips_sunday_7.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_7.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_7.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_7:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_7;
          
if(rect_configureVehicleTrips_tuesday_7.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_7.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_7.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_7:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_7;
          
if(rect_configureVehicleTrips_saturday_7.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_7.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_7.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_7:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_7;
          
if(rect_configureVehicleTrips_thursday_7.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_7.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_7.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_7:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_7;
          
if(rect_configureVehicleTrips_wednesday_7.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_7.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_7.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_8:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_8;
          
if(rect_configureVehicleTrips_friday_8.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_8.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_8.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_8:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_8;
          
if(rect_configureVehicleTrips_sunday_8.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_8.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_8.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_8:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_8;
          
if(rect_configureVehicleTrips_tuesday_8.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_8.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_8.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_8:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_8;
          
if(rect_configureVehicleTrips_saturday_8.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_8.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_8.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_8:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_8;
          
if(rect_configureVehicleTrips_thursday_8.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_8.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_8.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_8:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_8;
          
if(rect_configureVehicleTrips_wednesday_8.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_8.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_8.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_9:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_9;
          
if(rect_configureVehicleTrips_friday_9.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_9.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_9.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_9:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_9;
          
if(rect_configureVehicleTrips_sunday_9.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_9.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_9.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_9:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_9;
          
if(rect_configureVehicleTrips_tuesday_9.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_9.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_9.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_9:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_9;
          
if(rect_configureVehicleTrips_saturday_9.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_9.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_9.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_9:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_9;
          
if(rect_configureVehicleTrips_thursday_9.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_9.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_9.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_9:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_9;
          
if(rect_configureVehicleTrips_wednesday_9.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_9.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_9.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_10:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_10;
          
if(rect_configureVehicleTrips_friday_10.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_10.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_10.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_10:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_10;
          
if(rect_configureVehicleTrips_sunday_10.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_10.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_10.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_10:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_10;
          
if(rect_configureVehicleTrips_tuesday_10.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_10.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_10.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_10:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_10;
          
if(rect_configureVehicleTrips_saturday_10.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_10.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_10.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_10:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_10;
          
if(rect_configureVehicleTrips_thursday_10.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_10.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_10.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_10:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_10;
          
if(rect_configureVehicleTrips_wednesday_10.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_10.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_10.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_11:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_11;
          
if(rect_configureVehicleTrips_friday_11.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_11.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_11.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_11:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_11;
          
if(rect_configureVehicleTrips_sunday_11.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_11.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_11.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_11:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_11;
          
if(rect_configureVehicleTrips_tuesday_11.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_11.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_11.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_11:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_11;
          
if(rect_configureVehicleTrips_saturday_11.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_11.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_11.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_11:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_11;
          
if(rect_configureVehicleTrips_thursday_11.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_11.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_11.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_11:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_11;
          
if(rect_configureVehicleTrips_wednesday_11.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_11.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_11.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_12:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_12;
          
if(rect_configureVehicleTrips_friday_12.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_12.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_12.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_12:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_12;
          
if(rect_configureVehicleTrips_sunday_12.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_12.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_12.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_12:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_12;
          
if(rect_configureVehicleTrips_tuesday_12.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_12.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_12.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_12:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_12;
          
if(rect_configureVehicleTrips_saturday_12.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_12.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_12.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_12:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_12;
          
if(rect_configureVehicleTrips_thursday_12.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_12.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_12.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_12:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_12;
          
if(rect_configureVehicleTrips_wednesday_12.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_12.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_12.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_13:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_13;
          
if(rect_configureVehicleTrips_friday_13.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_13.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_13.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_13:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_13;
          
if(rect_configureVehicleTrips_sunday_13.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_13.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_13.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_13:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_13;
          
if(rect_configureVehicleTrips_tuesday_13.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_13.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_13.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_13:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_13;
          
if(rect_configureVehicleTrips_saturday_13.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_13.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_13.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_13:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_13;
          
if(rect_configureVehicleTrips_thursday_13.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_13.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_13.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_13:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_13;
          
if(rect_configureVehicleTrips_wednesday_13.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_13.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_13.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_14:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_14;
          
if(rect_configureVehicleTrips_friday_14.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_14.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_14.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_14:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_14;
          
if(rect_configureVehicleTrips_sunday_14.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_14.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_14.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_14:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_14;
          
if(rect_configureVehicleTrips_tuesday_14.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_14.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_14.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_14:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_14;
          
if(rect_configureVehicleTrips_saturday_14.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_14.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_14.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_14:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_14;
          
if(rect_configureVehicleTrips_thursday_14.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_14.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_14.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_14:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_14;
          
if(rect_configureVehicleTrips_wednesday_14.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_14.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_14.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_15:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_15;
          
if(rect_configureVehicleTrips_friday_15.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_15.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_15.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_15:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_15;
          
if(rect_configureVehicleTrips_sunday_15.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_15.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_15.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_15:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_15;
          
if(rect_configureVehicleTrips_tuesday_15.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_15.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_15.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_15:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_15;
          
if(rect_configureVehicleTrips_saturday_15.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_15.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_15.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_15:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_15;
          
if(rect_configureVehicleTrips_thursday_15.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_15.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_15.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_15:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_15;
          
if(rect_configureVehicleTrips_wednesday_15.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_15.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_15.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_16:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_16;
          
if(rect_configureVehicleTrips_friday_16.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_16.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_16.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_16:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_16;
          
if(rect_configureVehicleTrips_sunday_16.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_16.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_16.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_16:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_16;
          
if(rect_configureVehicleTrips_tuesday_16.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_16.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_16.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_16:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_16;
          
if(rect_configureVehicleTrips_saturday_16.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_16.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_16.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_16:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_16;
          
if(rect_configureVehicleTrips_thursday_16.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_16.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_16.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_16:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_16;
          
if(rect_configureVehicleTrips_wednesday_16.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_16.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_16.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_17:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_17;
          
if(rect_configureVehicleTrips_friday_17.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_17.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_17.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_17:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_17;
          
if(rect_configureVehicleTrips_sunday_17.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_17.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_17.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_17:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_17;
          
if(rect_configureVehicleTrips_tuesday_17.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_17.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_17.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_17:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_17;
          
if(rect_configureVehicleTrips_saturday_17.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_17.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_17.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_17:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_17;
          
if(rect_configureVehicleTrips_thursday_17.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_17.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_17.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_17:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_17;
          
if(rect_configureVehicleTrips_wednesday_17.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_17.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_17.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_18:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_18;
          
if(rect_configureVehicleTrips_friday_18.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_18.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_18.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_18:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_18;
          
if(rect_configureVehicleTrips_sunday_18.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_18.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_18.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_18:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_18;
          
if(rect_configureVehicleTrips_tuesday_18.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_18.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_18.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_18:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_18;
          
if(rect_configureVehicleTrips_saturday_18.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_18.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_18.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_18:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_18;
          
if(rect_configureVehicleTrips_thursday_18.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_18.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_18.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_18:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_18;
          
if(rect_configureVehicleTrips_wednesday_18.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_18.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_18.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_19:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_19;
          
if(rect_configureVehicleTrips_friday_19.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_19.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_19.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_19:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_19;
          
if(rect_configureVehicleTrips_sunday_19.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_19.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_19.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_19:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_19;
          
if(rect_configureVehicleTrips_tuesday_19.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_19.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_19.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_19:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_19;
          
if(rect_configureVehicleTrips_saturday_19.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_19.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_19.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_19:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_19;
          
if(rect_configureVehicleTrips_thursday_19.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_19.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_19.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_19:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_19;
          
if(rect_configureVehicleTrips_wednesday_19.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_19.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_19.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_20:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_20;
          
if(rect_configureVehicleTrips_friday_20.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_20.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_20.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_20:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_20;
          
if(rect_configureVehicleTrips_sunday_20.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_20.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_20.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_20:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_20;
          
if(rect_configureVehicleTrips_tuesday_20.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_20.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_20.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_20:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_20;
          
if(rect_configureVehicleTrips_saturday_20.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_20.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_20.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_20:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_20;
          
if(rect_configureVehicleTrips_thursday_20.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_20.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_20.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_20:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_20;
          
if(rect_configureVehicleTrips_wednesday_20.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_20.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_20.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_21:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_21;
          
if(rect_configureVehicleTrips_friday_21.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_21.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_21.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_21:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_21;
          
if(rect_configureVehicleTrips_sunday_21.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_21.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_21.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_21:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_21;
          
if(rect_configureVehicleTrips_tuesday_21.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_21.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_21.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_21:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_21;
          
if(rect_configureVehicleTrips_saturday_21.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_21.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_21.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_21:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_21;
          
if(rect_configureVehicleTrips_thursday_21.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_21.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_21.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_21:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_21;
          
if(rect_configureVehicleTrips_wednesday_21.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_21.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_21.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_22:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_22;
          
if(rect_configureVehicleTrips_friday_22.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_22.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_22.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_22:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_22;
          
if(rect_configureVehicleTrips_sunday_22.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_22.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_22.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_22:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_22;
          
if(rect_configureVehicleTrips_tuesday_22.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_22.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_22.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_22:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_22;
          
if(rect_configureVehicleTrips_saturday_22.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_22.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_22.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_22:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_22;
          
if(rect_configureVehicleTrips_thursday_22.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_22.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_22.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_22:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_22;
          
if(rect_configureVehicleTrips_wednesday_22.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_22.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_22.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_friday_23:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_friday_23;
          
if(rect_configureVehicleTrips_friday_23.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_friday_23.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_friday_23.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_sunday_23:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_sunday_23;
          
if(rect_configureVehicleTrips_sunday_23.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_sunday_23.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_sunday_23.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_tuesday_23:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_tuesday_23;
          
if(rect_configureVehicleTrips_tuesday_23.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_tuesday_23.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_tuesday_23.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_saturday_23:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_saturday_23;
          
if(rect_configureVehicleTrips_saturday_23.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_saturday_23.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_saturday_23.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_thursday_23:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_thursday_23;
          
if(rect_configureVehicleTrips_thursday_23.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_thursday_23.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_thursday_23.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_configureVehicleTrips_wednesday_23:
        if (true) {
          ShapeRectangle self = this.rect_configureVehicleTrips_wednesday_23;
          
if(rect_configureVehicleTrips_wednesday_23.getFillColor().equals(p_configureVehicleTripsOffColor)){
	rect_configureVehicleTrips_wednesday_23.setFillColor(p_configureVehicleTripsOnColor);
}
else{
	rect_configureVehicleTrips_wednesday_23.setFillColor(p_configureVehicleTripsOffColor);
} 
        }
        break;
      case _rect_disableTripConfigurationButtons_monday:
        if (true) {
          ShapeRectangle self = this.rect_disableTripConfigurationButtons_monday;
          
; 
        }
        break;
      case _rect_disableTripConfigurationButtons_tuesday:
        if (true) {
          ShapeRectangle self = this.rect_disableTripConfigurationButtons_tuesday;
          
; 
        }
        break;
      case _rect_disableTripConfigurationButtons_sunday:
        if (true) {
          ShapeRectangle self = this.rect_disableTripConfigurationButtons_sunday;
          
; 
        }
        break;
      case _rect_disableTripConfigurationButtons_saturday:
        if (true) {
          ShapeRectangle self = this.rect_disableTripConfigurationButtons_saturday;
          
; 
        }
        break;
      case _rect_disableTripConfigurationButtons_friday:
        if (true) {
          ShapeRectangle self = this.rect_disableTripConfigurationButtons_friday;
          
; 
        }
        break;
      case _rect_disableTripConfigurationButtons_thursday:
        if (true) {
          ShapeRectangle self = this.rect_disableTripConfigurationButtons_thursday;
          
; 
        }
        break;
      case _rect_disableTripConfigurationButtons_wednesday:
        if (true) {
          ShapeRectangle self = this.rect_disableTripConfigurationButtons_wednesday;
          
; 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _button1: {
          ShapeButton self = this.button1;
p_gridConnection.va_gridConnection.navigateTo(); 
;}
        break;
      case _button2: {
          ShapeButton self = this.button2;
((GIS_Building)p_gridConnection.c_connectedGISObjects.get(0)).va_building.navigateTo(); 
;}
        break;
      case _button3: {
          ShapeButton self = this.button3;
p_gridConnection.p_owner.va_ConnectionOwner.navigateTo(); 
;}
        break;
      case _button_openVehicleTripsConfigurationMenu_car: {
          ShapeButton self = this.button_openVehicleTripsConfigurationMenu_car;
if(v_currentTripConfiguringVehicleType != OL_VehicleType.CAR){
	f_openVehicleTripsConfigurationMenu(OL_VehicleType.CAR);
}
else{
	f_closeVehicleTripsConfigurationMenu();
}
 
;}
        break;
      case _button_openVehicleTripsConfigurationMenu_van: {
          ShapeButton self = this.button_openVehicleTripsConfigurationMenu_van;
if(v_currentTripConfiguringVehicleType != OL_VehicleType.VAN){
	f_openVehicleTripsConfigurationMenu(OL_VehicleType.VAN);
}
else{
	f_closeVehicleTripsConfigurationMenu();
} 
;}
        break;
      case _button_openVehicleTripsConfigurationMenu_truck: {
          ShapeButton self = this.button_openVehicleTripsConfigurationMenu_truck;
if(v_currentTripConfiguringVehicleType != OL_VehicleType.TRUCK){
	f_openVehicleTripsConfigurationMenu(OL_VehicleType.TRUCK);
}
else{
	f_closeVehicleTripsConfigurationMenu();
} 
;}
        break;
      case _button: {
          ShapeButton self = this.button;
zero_Interface.uI_Results.getCheckbox_KPISummary().setSelected(false, true);

zero_Interface.va_Interface.navigateTo();
zero_Interface.v_currentViewArea = zero_Interface.va_Interface;
 
;}
        break;
      case _button_confirm_configureVehicleTrips: {
          ShapeButton self = this.button_confirm_configureVehicleTrips;
f_confirmVehicleTripsConfiguration(v_currentTripConfiguringVehicleType);
f_closeVehicleTripsConfigurationMenu();

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _button_cancel_configureVehicleTrips: {
          ShapeButton self = this.button_cancel_configureVehicleTrips;
f_closeVehicleTripsConfigurationMenu(); 
;}
        break;
      case _button_configureVehicleTrips_reset: {
          ShapeButton self = this.button_configureVehicleTrips_reset;
if(map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid) != null &&
	map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid).get(v_currentTripConfiguringVehicleType) != null){
	map_storedCustomTripButtonConfiguration.get(p_gridConnection.p_uid).remove(v_currentTripConfiguringVehicleType);
	f_initializeVehicleTripsConfigurationMenuButtons(v_currentTripConfiguringVehicleType);
	f_resetVehicleTypeToOriginalTripTracker(v_currentTripConfiguringVehicleType);
}
else{
	f_setAllVehicleTripsConfigurationButtonsToDefault();
} 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, boolean value ) {
    switch( _shape ) {
      case _cb_curtailmentCompany: {
          ShapeCheckBox self = this.cb_curtailmentCompany;
if (cb_curtailmentCompany.isSelected()) {
	p_gridConnection.f_setExternalAssetManagement(new J_CurtailManagementContractCapacity(p_gridConnection, zero_Interface.energyModel.p_timeParameters));
}
else {
	p_gridConnection.f_removeExternalAssetManagement(I_CurtailManagement.class);
}

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _cb_showGridloadPlot: {
          ShapeCheckBox self = this.cb_showGridloadPlot;
uI_Results.f_setChartGridLoad_Presentation(null, null, cb_showGridloadPlot.isSelected());
uI_Results.f_setChartSankey_Presentation(null, null, !cb_showGridloadPlot.isSelected());

if(cb_showGridloadPlot.isSelected()){
	txt_chartNameRight.setText("Netbelasting");
}
else{
	txt_chartNameRight.setText("Energiestromen");
} 
;}
        break;
      case _cb_configureVehicleTrips_dailyDistinction: {
          ShapeCheckBox self = this.cb_configureVehicleTrips_dailyDistinction;
f_activateDailyDifferenceButtons(cb_configureVehicleTrips_dailyDistinction.isSelected()); 
;}
        break;
      case _cb_configureVehicleTripsMonday: {
          ShapeCheckBox self = this.cb_configureVehicleTripsMonday;
f_enableSingleDay(cb_configureVehicleTripsMonday.isSelected(), OL_Days.MONDAY); 
;}
        break;
      case _cb_configureVehicleTripsTuesday: {
          ShapeCheckBox self = this.cb_configureVehicleTripsTuesday;
f_enableSingleDay(cb_configureVehicleTripsTuesday.isSelected(), OL_Days.TUESDAY); 
;}
        break;
      case _cb_configureVehicleTripsWednesday: {
          ShapeCheckBox self = this.cb_configureVehicleTripsWednesday;
f_enableSingleDay(cb_configureVehicleTripsWednesday.isSelected(), OL_Days.WEDNESDAY); 
;}
        break;
      case _cb_configureVehicleTripsThursday: {
          ShapeCheckBox self = this.cb_configureVehicleTripsThursday;
f_enableSingleDay(cb_configureVehicleTripsThursday.isSelected(), OL_Days.THURSDAY); 
;}
        break;
      case _cb_configureVehicleTripsFriday: {
          ShapeCheckBox self = this.cb_configureVehicleTripsFriday;
f_enableSingleDay(cb_configureVehicleTripsFriday.isSelected(), OL_Days.FRIDAY); 
;}
        break;
      case _cb_configureVehicleTripsSaturday: {
          ShapeCheckBox self = this.cb_configureVehicleTripsSaturday;
f_enableSingleDay(cb_configureVehicleTripsSaturday.isSelected(), OL_Days.SATURDAY); 
;}
        break;
      case _cb_configureVehicleTripsSunday: {
          ShapeCheckBox self = this.cb_configureVehicleTripsSunday;
f_enableSingleDay(cb_configureVehicleTripsSunday.isSelected(), OL_Days.SUNDAY); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, int value ) {
    switch( _shape ) {
      case _rb_scenariosPrivateUI: {
          ShapeRadioButtonGroup self = this.rb_scenariosPrivateUI;
if (p_scenarioSettings_Current != null && p_scenarioSettings_Future != null){
	f_setScenario(rb_scenariosPrivateUI.getValue());
}

// Simulate Year button on Interface
zero_Interface.f_resetSettings(); 
;}
        break;
      case _rb_heatingTypePrivateUI: {
          ShapeRadioButtonGroup self = this.rb_heatingTypePrivateUI;
if (!rb_heatingTypePrivateUI.isEnabled()){// check if disabled, if so, skip when called
	return;
}

//Convert radiobutton integer to OL type
OL_GridConnectionHeatingType selectedHeatingType;
switch (rb_heatingTypePrivateUI.getValue()){
	case 0:
		selectedHeatingType = OL_GridConnectionHeatingType.GAS_BURNER;
		break;
	case 1:
		selectedHeatingType = OL_GridConnectionHeatingType.HYBRID_HEATPUMP;
		break;
	case 2:
		selectedHeatingType = OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP;
		break;
	case 3:
		selectedHeatingType = OL_GridConnectionHeatingType.DISTRICTHEAT;
		break;
	case 4:
		selectedHeatingType = OL_GridConnectionHeatingType.CUSTOM;
		f_setErrorScreen("De 'custom' verwarming optie wordt alleen gebruikt ter visualisatie voor bedrijven die starten met een 'custom' warmte systeem. In plaats van 'custom' is de knop nu gezet op 'HR ketel aardgas'.");
		rb_heatingTypePrivateUI.setValue(0);
		return;
	default:
		selectedHeatingType = OL_GridConnectionHeatingType.NONE;
}


//Radio button function
f_setHeatingType(p_gridConnection, selectedHeatingType);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, double value ) {
    switch( _shape ) {
      case _sl_GCCapacityCompany: {
          ShapeSlider self = this.sl_GCCapacityCompany;
f_setGCCapacity(p_gridConnection, sl_GCCapacityCompany.getValue(), "DELIVERY");

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_heatDemandCompanyReduction: {
          ShapeSlider self = this.sl_heatDemandCompanyReduction;
double newHeatDemandReduction_pct = sl_heatDemandCompanyReduction.getValue();
double consumptionScaling_fr = 1  - newHeatDemandReduction_pct/100;

for (J_EAProfile j_ea : p_gridConnection.c_profileAssets) {
	if(j_ea.getEnergyCarrier()== OL_EnergyCarriers.HEAT && !(j_ea instanceof J_EAProduction)){
		j_ea.setProfileScaling_fr( consumptionScaling_fr );
	}
}


//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_electricityDemandCompanyReduction: {
          ShapeSlider self = this.sl_electricityDemandCompanyReduction;
double newElectricityDemandReduction_pct = sl_electricityDemandCompanyReduction.getValue();
double consumptionScaling_fr = 1  - newElectricityDemandReduction_pct/100;

for (J_EAProfile j_ea : p_gridConnection.c_profileAssets) {
	if(j_ea.getAssetFlowCategory() == OL_AssetFlowCategories.fixedConsumptionElectric_kW){
		j_ea.setProfileScaling_fr( consumptionScaling_fr );
	}
}

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen();
 
;}
        break;
      case _sl_electricVansCompany: {
          ShapeSlider self = this.sl_electricVansCompany;
//Slider function
f_setElectricVehicleSliders(p_gridConnection, OL_VehicleType.VAN, (int)sl_electricVansCompany.getValue());

//Update the other two sliders aswell
sl_hydrogenVansCompany.setValue(v_nbHydrogenVans, false);
sl_petroleumFuelVansCompany.setValue(v_nbPetroleumFuelVans, false);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_hydrogenVansCompany: {
          ShapeSlider self = this.sl_hydrogenVansCompany;
//Slider function
f_setHydrogenVehicleSliders(p_gridConnection, OL_VehicleType.VAN, (int)sl_hydrogenVansCompany.getValue());

//Update the other two sliders aswell
sl_electricVansCompany.setValue(v_nbEVVans, false);
sl_petroleumFuelVansCompany.setValue(v_nbPetroleumFuelVans, false);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_petroleumFuelVansCompany: {
          ShapeSlider self = this.sl_petroleumFuelVansCompany;
//Slider function
f_setPetroleumFuelVehicleSliders(p_gridConnection, OL_VehicleType.VAN, (int)sl_petroleumFuelVansCompany.getValue());

//Update the other two sliders aswell
sl_electricVansCompany.setValue(v_nbEVVans, false);
sl_hydrogenVansCompany.setValue(v_nbHydrogenVans, false);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_hydrogenTrucksCompany: {
          ShapeSlider self = this.sl_hydrogenTrucksCompany;
//Slider function
f_setHydrogenVehicleSliders(p_gridConnection, OL_VehicleType.TRUCK, (int)sl_hydrogenTrucksCompany.getValue());

//Update the other two sliders aswell
sl_electricTrucksCompany.setValue(v_nbEVTrucks, false);
sl_petroleumFuelTrucksCompany.setValue(v_nbPetroleumFuelTrucks, false);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_electricTrucksCompany: {
          ShapeSlider self = this.sl_electricTrucksCompany;
//Slider function
f_setElectricVehicleSliders(p_gridConnection, OL_VehicleType.TRUCK, (int)sl_electricTrucksCompany.getValue());

//Update the other two sliders aswell
sl_hydrogenTrucksCompany.setValue(v_nbHydrogenTrucks, false);
sl_petroleumFuelTrucksCompany.setValue(v_nbPetroleumFuelTrucks, false);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_petroleumFuelTrucksCompany: {
          ShapeSlider self = this.sl_petroleumFuelTrucksCompany;
//Slider function
f_setPetroleumFuelVehicleSliders(p_gridConnection, OL_VehicleType.TRUCK, (int)sl_petroleumFuelTrucksCompany.getValue());

//Update the other two sliders aswell
sl_electricTrucksCompany.setValue(v_nbEVTrucks, false);
sl_hydrogenTrucksCompany.setValue(v_nbHydrogenTrucks, false);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_electricCarsCompany: {
          ShapeSlider self = this.sl_electricCarsCompany;
//Slider function
f_setElectricVehicleSliders(p_gridConnection, OL_VehicleType.CAR, (int)sl_electricCarsCompany.getValue());

//Update the other two sliders aswell
sl_hydrogenCarsCompany.setValue(v_nbHydrogenCars, false);
sl_petroleumFuelCarsCompany.setValue(v_nbPetroleumFuelCars, false);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_mobilityDemandCompanyReduction: {
          ShapeSlider self = this.sl_mobilityDemandCompanyReduction;
p_gridConnection.c_tripTrackers.forEach(tt -> tt.setDistanceScaling_fr(1-sl_mobilityDemandCompanyReduction.getValue()/100));

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_hydrogenCarsCompany: {
          ShapeSlider self = this.sl_hydrogenCarsCompany;
//Slider function
f_setHydrogenVehicleSliders(p_gridConnection, OL_VehicleType.CAR, (int)sl_hydrogenCarsCompany.getValue());

//Update the other two sliders aswell
sl_electricCarsCompany.setValue(v_nbEVCars, false);
sl_petroleumFuelCarsCompany.setValue(v_nbPetroleumFuelCars, false);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_petroleumFuelCarsCompany: {
          ShapeSlider self = this.sl_petroleumFuelCarsCompany;
//Slider function
f_setPetroleumFuelVehicleSliders(p_gridConnection, OL_VehicleType.CAR, (int)sl_petroleumFuelCarsCompany.getValue());

//Update the other two sliders aswell
sl_electricCarsCompany.setValue(v_nbEVCars, false);
sl_hydrogenCarsCompany.setValue(v_nbHydrogenCars, false);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_batteryCompany: {
          ShapeSlider self = this.sl_batteryCompany;
//traceln("Slider werkt nog niet volledig!!, batterij sturing werkt nog niet goed");
f_setBattery(p_gridConnection, sl_batteryCompany.getValue());

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_rooftopPVCompany: {
          ShapeSlider self = this.sl_rooftopPVCompany;
f_setPVSystem(p_gridConnection, sl_rooftopPVCompany.getValue());

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_GCCapacityCompany_Feedin: {
          ShapeSlider self = this.sl_GCCapacityCompany_Feedin;
f_setGCCapacity(p_gridConnection, sl_GCCapacityCompany_Feedin.getValue(), "FEEDIN");

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
        

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, String value ) {
    switch( _shape ) {
      case _cb_selectGC: {
          ShapeComboBox self = this.cb_selectGC;
f_selectDifferentOwnedGC(cb_selectGC.getValueIndex()); 
;}
        break;
      case _eb_configureVehicleTrips_weeklyDistance_km: {
          ShapeTextField self = this.eb_configureVehicleTrips_weeklyDistance_km;
try {
    double d = eb_configureVehicleTrips_weeklyDistance_km.getDoubleValue(); // Throws error if not a double
    if (d > 0) {
        // valid input
    } else {
        eb_configureVehicleTrips_weeklyDistance_km.setValueToDefault();
        f_setErrorScreen("De wekelijkse afstand moet groter zijn dan 0 km.");
    }
} catch (Exception e) {
    eb_configureVehicleTrips_weeklyDistance_km.setValueToDefault();
    f_setErrorScreen("De wekelijkse afstand moet een getal zijn die groter is dan 0 km.");
} 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
         
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean getShapeControlDefaultValueBoolean( int _shape, int index ) {
    switch(_shape) {
      case _cb_configureVehicleTrips_dailyDistinction: return 
false 
;
      case _cb_configureVehicleTripsMonday: return 
true 
;
      case _cb_configureVehicleTripsTuesday: return 
true 
;
      case _cb_configureVehicleTripsWednesday: return 
true 
;
      case _cb_configureVehicleTripsThursday: return 
true 
;
      case _cb_configureVehicleTripsFriday: return 
true 
;
      case _cb_configureVehicleTripsSaturday: return 
true 
;
      case _cb_configureVehicleTripsSunday: return 
true 
;
      default: return super.getShapeControlDefaultValueBoolean( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getShapeControlDefaultValueInt( int _shape, int index ) {
    switch(_shape) {
      case _rb_scenariosPrivateUI: return 
0 
;
      case _rb_heatingTypePrivateUI: return 
0 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlDefaultValueDouble( int _shape, int index ) {
    switch(_shape) {
      case _sl_GCCapacityCompany: return 
v_defaultContractDeliveryCapacity_kW 
;
      case _sl_heatDemandCompanyReduction: return 
0 
;
      case _sl_electricityDemandCompanyReduction: return 
0 
;
      case _sl_electricVansCompany: return 
v_nbEVVans 
;
      case _sl_hydrogenVansCompany: return 
v_nbHydrogenVans 
;
      case _sl_petroleumFuelVansCompany: return 
v_nbPetroleumFuelVans 
;
      case _sl_hydrogenTrucksCompany: return 
v_nbHydrogenTrucks 
;
      case _sl_electricTrucksCompany: return 
v_nbEVTrucks 
;
      case _sl_petroleumFuelTrucksCompany: return 
v_nbPetroleumFuelTrucks 
;
      case _sl_electricCarsCompany: return 
v_nbEVCars 
;
      case _sl_mobilityDemandCompanyReduction: return 
0 
;
      case _sl_hydrogenCarsCompany: return 
v_nbHydrogenCars 
;
      case _sl_petroleumFuelCarsCompany: return 
v_nbPetroleumFuelCars 
;
      case _sl_batteryCompany: return 
v_defaultBatSlider 
;
      case _sl_rooftopPVCompany: return 
v_defaultPVSlider 
;
      case _sl_GCCapacityCompany_Feedin: return 
v_defaultContractFeedinCapacity_kW 
;
      default: return super.getShapeControlDefaultValueDouble( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getShapeControlDefaultValueString( int _shape, int index ) {
    switch(_shape) {
      case _eb_configureVehicleTrips_weeklyDistance_km: return 
"200" 
;
      default: return super.getShapeControlDefaultValueString( _shape, index );
    }
  }

  protected ShapeButton button1;
  protected ShapeRadioButtonGroup rb_scenariosPrivateUI;
  protected ShapeButton button2;
  protected ShapeButton button3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_GCCapacityCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minContractDeliveryCapacity_kW ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxContractDeliveryCapacity_kW ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_GCCapacityCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_heatDemandCompanyReduction_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minSavingsSliders ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxSavingsSliders ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_heatDemandCompanyReduction;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_electricityDemandCompanyReduction_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minSavingsSliders ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxSavingsSliders ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_electricityDemandCompanyReduction;
  protected ShapeButton button_openVehicleTripsConfigurationMenu_car;
  protected ShapeButton button_openVehicleTripsConfigurationMenu_van;
  protected ShapeButton button_openVehicleTripsConfigurationMenu_truck;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_electricVansCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minEVVanSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxEVVanSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_electricVansCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_hydrogenVansCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minHydrogenVanSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxHydrogenVanSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_hydrogenVansCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_petroleumFuelVansCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minPetroleumFuelVanSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxPetroleumFuelVanSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_petroleumFuelVansCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_hydrogenTrucksCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minHydrogenTruckSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxHydrogenTruckSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_hydrogenTrucksCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_electricTrucksCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minEVTruckSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxEVTruckSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_electricTrucksCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_petroleumFuelTrucksCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minPetroleumFuelTruckSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxPetroleumFuelTruckSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_petroleumFuelTrucksCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_electricCarsCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minEVCarSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxEVCarSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_electricCarsCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_mobilityDemandCompanyReduction_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minSavingsSliders ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxSavingsSliders ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_mobilityDemandCompanyReduction;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_hydrogenCarsCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minHydrogenCarSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxHydrogenCarSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_hydrogenCarsCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_petroleumFuelCarsCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minPetroleumFuelCarSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxPetroleumFuelCarSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_petroleumFuelCarsCompany;
  protected ShapeComboBox cb_selectGC;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_batteryCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minBatSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxBatSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_batteryCompany;
  protected ShapeRadioButtonGroup rb_heatingTypePrivateUI;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_rooftopPVCompany_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minPVSlider ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxPVSlider ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_rooftopPVCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_GCCapacityCompany_Feedin_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
v_minContractFeedinCapacity_kW ;
      @AnyLogicInternalCodegenAPI
      double _max = 
v_maxContractFeedinCapacity_kW ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_GCCapacityCompany_Feedin;
  protected ShapeButton button;
  protected ShapeCheckBox cb_curtailmentCompany;
  protected ShapeCheckBox cb_showGridloadPlot;
  protected ShapeCheckBox cb_configureVehicleTrips_dailyDistinction;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_confirm_configureVehicleTrips_SetDynamicParams_xjal( ShapeButton shape ) {
    shape.setEnabled(
c_activeVehicleConfigurationDays.size()>0 
);
  }
  
  protected ShapeButton button_confirm_configureVehicleTrips;
  protected ShapeButton button_cancel_configureVehicleTrips;
  protected ShapeCheckBox cb_configureVehicleTripsMonday;
  protected ShapeCheckBox cb_configureVehicleTripsTuesday;
  protected ShapeCheckBox cb_configureVehicleTripsWednesday;
  protected ShapeCheckBox cb_configureVehicleTripsThursday;
  protected ShapeCheckBox cb_configureVehicleTripsFriday;
  protected ShapeCheckBox cb_configureVehicleTripsSaturday;
  protected ShapeCheckBox cb_configureVehicleTripsSunday;
  protected ShapeButton button_configureVehicleTrips_reset;
  protected ShapeTextField eb_configureVehicleTrips_weeklyDistance_km;
  protected ShapeRectangle rect_canvas;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_background_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_companyUILineColor 
);
    shape.setFillColor(
v_companyUIBackgroundColor 
);
    shape.setLineWidth(
v_companyUILineWidth 
);
  }
  
  protected ShapeRectangle rect_background;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_sliders_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_companyUILineColor 
);
    shape.setFillColor(
v_companyUIBackgroundColorSliders 
);
    shape.setLineWidth(
v_companyUILineWidth 
);
  }
  
  protected ShapeRectangle rect_sliders;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_scenarios_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_companyUILineColor 
);
    shape.setFillColor(
v_companyUIBackgroundColorSliders 
);
    shape.setLineWidth(
v_companyUILineWidth 
);
  }
  
  protected ShapeRectangle rect_scenarios;
  protected ShapeText text;
  protected ShapeText text4;
  protected ShapeText txt_storedScenarios;
  protected ShapeText txt_scenario;
  protected ShapeGroup gr_scenarioRB;
  protected ShapeText txt_scenarioSettings;
  protected ShapeText txt_sliderPresetsAndLimits;
  protected ShapeText txt_sliderFunctions;
  protected ShapeText txt_initialization;
  protected ShapeText txt_uiResult;
  protected ShapeText txt_warmte;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCCapacityCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_GCCapacityCompany.getIntValue() + " kW" 
);
  }
  
  protected ShapeText t_GCCapacityCompany;
  protected ShapeText txt_GCCapacity;
  protected ShapeText text195;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_heatDemandReductionCompanies_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_heatDemandCompanyReduction.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_heatDemandReductionCompanies;
  protected ShapeGroup gr_heatDemandReductionSlider;
  protected ShapeText txt_elektriciteit;
  protected ShapeText txt_mobiliteit;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_electricityDemandReductionCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_electricityDemandCompanyReduction.getIntValue() + "%"
 
);
  }
  
  protected ShapeText t_electricityDemandReductionCompany;
  protected ShapeText text279;
  protected ShapeText text266;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_numberOfElectricVansCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_electricVansCompany.getIntValue() 
);
  }
  
  protected ShapeText t_numberOfElectricVansCompany;
  protected ShapeText text271;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_numberOfHydrogenVansCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_hydrogenVansCompany.getIntValue() 
);
  }
  
  protected ShapeText t_numberOfHydrogenVansCompany;
  protected ShapeText text285;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_numberOfPetroleumFuelVansCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_petroleumFuelVansCompany.getIntValue() 
);
  }
  
  protected ShapeText t_numberOfPetroleumFuelVansCompany;
  protected ShapeText text274;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_numberOfPetroleumFuelTrucksCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_petroleumFuelTrucksCompany.getIntValue() 
);
  }
  
  protected ShapeText t_numberOfPetroleumFuelTrucksCompany;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_numberOfHydrogenTrucksCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_hydrogenTrucksCompany.getIntValue() 
);
  }
  
  protected ShapeText t_numberOfHydrogenTrucksCompany;
  protected ShapeText text272;
  protected ShapeText text286;
  protected ShapeText text268;
  protected ShapeText text275;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_numberOfElectricTrucksCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_electricTrucksCompany.getIntValue() 
);
  }
  
  protected ShapeText t_numberOfElectricTrucksCompany;
  protected ShapeText text265;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_numberOfElectricCarsCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_electricCarsCompany.getIntValue() 
);
  }
  
  protected ShapeText t_numberOfElectricCarsCompany;
  protected ShapeText text267;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_mobilityDemandReductionCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_mobilityDemandCompanyReduction.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_mobilityDemandReductionCompany;
  protected ShapeText text270;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_numberOfHydrogenCarsCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_hydrogenCarsCompany.getIntValue() 
);
  }
  
  protected ShapeText t_numberOfHydrogenCarsCompany;
  protected ShapeText text284;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_numberOfPetroleumFuelCarsCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_petroleumFuelCarsCompany.getIntValue() 
);
  }
  
  protected ShapeText t_numberOfPetroleumFuelCarsCompany;
  protected ShapeText text273;
  protected ShapeGroup gr_companyMobilitySliders;
  protected ShapeText text9;
  protected ShapeGroup gr_selectedGC;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_batteryCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_batteryCompany.getIntValue() + " kWh" 
);
  }
  
  protected ShapeText t_batteryCompany;
  protected ShapeText text283;
  protected ShapeOval ovalElectricityButton1;
  protected ShapeImage image4;
  protected ShapeGroup gr_electricityButton1;
  protected ShapeOval ovalHeatButton1;
  protected ShapeImage image11;
  protected ShapeGroup gr_heatButton1;
  protected ShapeOval ovalTransportButton1;
  protected ShapeImage image16;
  protected ShapeGroup gr_transportButton1;
  protected ShapeGroup g_energyDemandSettings;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_rooftopSolarCompany_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_rooftopPVCompany.getIntValue() + " kW" 
);
  }
  
  protected ShapeText t_rooftopSolarCompany;
  protected ShapeText txt_PVPower;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCCapacityCompany_Feedin_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_GCCapacityCompany_Feedin.getIntValue() + " kW" 
);
  }
  
  protected ShapeText t_GCCapacityCompany_Feedin;
  protected ShapeText txt_GCCapacityCompany_Feedin;
  protected ShapeGroup gr_companyUISliders;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _roundRect_companyName_SetDynamicParams_xjal( ShapeRoundedRectangle shape ) {
    shape.setLineColor(
v_companyUILineColor 
);
    shape.setLineWidth(
v_companyUILineWidth 
);
  }
  
  protected ShapeRoundedRectangle roundRect_companyName;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_companyName_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
p_companyName 
);
  }
  
  protected ShapeText t_companyName;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCadress_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
v_adressGC 
);
  }
  
  protected ShapeText t_GCadress;
  protected ShapeGroup gr_companyDetails;
  protected ShapeEmbeddedObjectPresentation uI_Results_presentation;
  protected ShapeRectangle mask_resultsUI1;
  protected ShapeRectangle mask_resultsUI2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_chartNameLeft_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_companyUILineColor 
);
    shape.setFillColor(
v_chartBackgroundColor 
);
    shape.setLineWidth(
v_chartLineWidth 
);
  }
  
  protected ShapeRectangle rect_chartNameLeft;
  protected ShapeText txt_chartNameLeft;
  protected ShapeGroup gr_chartNameLeft;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_chartNameMiddle_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_companyUILineColor 
);
    shape.setFillColor(
v_chartBackgroundColor 
);
    shape.setLineWidth(
v_chartLineWidth 
);
  }
  
  protected ShapeRectangle rect_chartNameMiddle;
  protected ShapeText txt_chartNameMiddle;
  protected ShapeGroup gr_chartNameMiddle;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_chartNameRight_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_companyUILineColor 
);
    shape.setFillColor(
v_chartBackgroundColor 
);
    shape.setLineWidth(
v_chartLineWidth 
);
  }
  
  protected ShapeRectangle rect_chartNameRight;
  protected ShapeText txt_chartNameRight;
  protected ShapeGroup gr_chartNameRight;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_simulateYearScreen2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_companyUIBackgroundColor 
);
    shape.setFillColor(
v_companyUIBackgroundColor 
);
    shape.setLineWidth(
v_chartLineWidth+0.5 
);
  }
  
  protected ShapeRectangle rect_simulateYearScreen2;
  protected ShapeText t_simulateYearToCalculateCostsSmall;
  protected ShapeImage image_simulateYearToCalculateCostsSmall;
  protected ShapeGroup gr_simulateYearToCalculateKPIs;
  protected ShapeGroup gr_simulateYearScreen;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_loadIcon_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_loadScreenColor 
);
    shape.setFillColor(
v_loadScreenColor 
);
    shape.setLineWidth(
v_chartLineWidth+0.5 
);
  }
  
  protected ShapeRectangle rect_loadIcon;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GCisPausedScreen3_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_loadScreenColor 
);
    shape.setFillColor(
v_loadScreenColor 
);
    shape.setLineWidth(
v_chartLineWidth+0.5 
);
  }
  
  protected ShapeRectangle rect_GCisPausedScreen3;
  protected ShapeImage image_loadIconSmall;
  protected ShapeText t_loadIconSmall;
  protected ShapeGroup gr_loadIconText;
  protected ShapeGroup gr_loadIcon;
  protected ShapeText txt_curtailmentDescriptionCompany;
  protected ShapeText txt_nfatoValues;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_table_GridconnectionCapacaties_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_companyUILineColor 
);
    shape.setLineWidth(
v_companyUILineWidth 
);
  }
  
  protected ShapeRectangle rect_table_GridconnectionCapacaties;
  protected ShapeText txt_additionalGCCapacityInfo;
  protected ShapeText text1;
  protected ShapeText text2;
  protected ShapeText text3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCCapacityCompany_delivery2_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
t_GCCapacityCompany.getText() 
);
  }
  
  protected ShapeText t_GCCapacityCompany_delivery2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCCapacityCompany_Feedin_2_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
t_GCCapacityCompany_Feedin.getText() 
);
  }
  
  protected ShapeText t_GCCapacityCompany_Feedin_2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCCapacityCompany_physical_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
roundToInt(v_physicalConnectionCapacity_kW) + " kW" 
);
  }
  
  protected ShapeText t_GCCapacityCompany_physical;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line_table_ConnectionCapacityInfo_1_SetDynamicParams_xjal( ShapeLine shape ) {
    shape.setColor(
v_companyUILineColor 
);
    shape.setLineWidth(
v_companyUILineWidth 
);
  }
  
  protected ShapeLine line_table_ConnectionCapacityInfo_1;
  protected ShapeText txt_table_ConnectionCapacityInfo_owned;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line_table_ConnectionCapacityInfo_3_SetDynamicParams_xjal( ShapeLine shape ) {
    shape.setColor(
v_companyUILineColor 
);
    shape.setLineWidth(
v_companyUILineWidth 
);
  }
  
  protected ShapeLine line_table_ConnectionCapacityInfo_3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_Table_NFATO_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_companyUILineColor 
);
    shape.setLineWidth(
v_companyUILineWidth 
);
  }
  
  protected ShapeRectangle rect_Table_NFATO;
  protected ShapeText txt_table_ConnectionCapacityInfo_nfato;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCCapacityCompany_delivery_nfato_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
roundToInt(v_NFATO_kW_delivery) + " kW" 
);
  }
  
  protected ShapeText t_GCCapacityCompany_delivery_nfato;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCCapacityCompany_Feedin_nfato_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
roundToInt(v_NFATO_kW_feedin) + " kW" 
);
  }
  
  protected ShapeText t_GCCapacityCompany_Feedin_nfato;
  protected ShapeText t_GCCapacityCompany_physical_nfato;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line_table_ConnectionCapacityInfo_NFATO_SetDynamicParams_xjal( ShapeLine shape ) {
    shape.setColor(
v_companyUILineColor 
);
    shape.setLineWidth(
v_companyUILineWidth 
);
  }
  
  protected ShapeLine line_table_ConnectionCapacityInfo_NFATO;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_table_nfato_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
v_NFATO_active



 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeGroup gr_table_nfato;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line_table_ConnectionCapacityInfo_2_SetDynamicParams_xjal( ShapeLine shape ) {
    shape.setColor(
v_companyUILineColor 
);
    shape.setLineWidth(
v_companyUILineWidth 
);
  }
  
  protected ShapeLine line_table_ConnectionCapacityInfo_2;
  protected ShapeText txt_table_ConnectionCapacityInfo_known;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCCapacityCompany_delivery3_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
p_scenarioSettings_Current.getCurrentContractDeliveryCapacity_kW() != sl_GCCapacityCompany.getValue() ? "Custom" :
p_gridConnection.v_liveConnectionMetaData.getContractedDeliveryCapacityKnown() ? "Bekend" : "Geschat" 
);
  }
  
  protected ShapeText t_GCCapacityCompany_delivery3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCCapacityCompany_Feedin_3_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
p_scenarioSettings_Current.getCurrentContractFeedinCapacity_kW() != sl_GCCapacityCompany_Feedin.getValue() ? "Custom" :
p_gridConnection.v_liveConnectionMetaData.getContractedFeedinCapacityKnown() ? "Bekend" : "Geschat" 
);
  }
  
  protected ShapeText t_GCCapacityCompany_Feedin_3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_GCCapacityCompany_physical1_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
p_scenarioSettings_Current.getCurrentPhysicalConnectionCapacity_kW() != v_physicalConnectionCapacity_kW ? "Custom" :
p_gridConnection.v_liveConnectionMetaData.getPhysicalCapacityKnown() ? "Bekend" : "Geschat" 
);
  }
  
  protected ShapeText t_GCCapacityCompany_physical1;
  protected ShapeGroup gr_TableConnectionCapacity;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GCisPausedScreen_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_loadScreenColor 
);
    shape.setFillColor(
v_loadScreenColor 
);
    shape.setLineWidth(
v_chartLineWidth+0.5 
);
  }
  
  protected ShapeRectangle rect_GCisPausedScreen;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GCisPausedScreen2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_companyUIBackgroundColor 
);
    shape.setFillColor(
v_companyUIBackgroundColor 
);
    shape.setLineWidth(
v_chartLineWidth+0.5 
);
  }
  
  protected ShapeRectangle rect_GCisPausedScreen2;
  protected ShapeText t_GCisPausedScreen;
  protected ShapeImage image_simulateYearToCalculateCostsSmall1;
  protected ShapeGroup gr_GCisPausedScreenText;
  protected ShapeText txt_GCisPaused;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_GCisPausedScreen_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
!p_gridConnection.v_isActive 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
1375 
);
    shape.setY(
540 
);
 	}
  }
  
  protected ShapeGroup gr_GCisPausedScreen;
  protected ShapeRectangle rect_errorScreenGrayOut;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_errorScreenClickBlocking_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
null 
);
    shape.setFillColor(
null 
);
  }
  
  protected ShapeRectangle rect_errorScreenClickBlocking;
  protected ShapeRoundedRectangle rect_errorMessage;
  protected ShapeText t_errorMessage;
  protected ShapeRectangle rect_errorOK;
  protected ShapeText txt_errorOK;
  protected ShapeGroup button_errorOK;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_errorScreen_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
960 
);
    shape.setY(
500 
);
  }
  
  protected ShapeGroup gr_errorScreen;
  protected ShapeText txt_setSimYearScreen;
  protected ShapeText txt_selectDifferentOwnedGC;
  protected ShapeRectangle rect_configureVehicleTripsBackground;
  protected ShapeRectangle rect_configureVehicleTrips_monday_0;
  protected ShapeRectangle rect_configureVehicleTrips_monday_1;
  protected ShapeRectangle rect_configureVehicleTrips_monday_2;
  protected ShapeRectangle rect_configureVehicleTrips_monday_3;
  protected ShapeRectangle rect_configureVehicleTrips_monday_4;
  protected ShapeRectangle rect_configureVehicleTrips_monday_5;
  protected ShapeRectangle rect_configureVehicleTrips_monday_6;
  protected ShapeRectangle rect_configureVehicleTrips_monday_7;
  protected ShapeRectangle rect_configureVehicleTrips_monday_8;
  protected ShapeRectangle rect_configureVehicleTrips_monday_9;
  protected ShapeRectangle rect_configureVehicleTrips_monday_10;
  protected ShapeRectangle rect_configureVehicleTrips_monday_11;
  protected ShapeRectangle rect_configureVehicleTrips_monday_12;
  protected ShapeRectangle rect_configureVehicleTrips_monday_13;
  protected ShapeRectangle rect_configureVehicleTrips_monday_14;
  protected ShapeRectangle rect_configureVehicleTrips_monday_15;
  protected ShapeRectangle rect_configureVehicleTrips_monday_16;
  protected ShapeRectangle rect_configureVehicleTrips_monday_17;
  protected ShapeRectangle rect_configureVehicleTrips_monday_18;
  protected ShapeRectangle rect_configureVehicleTrips_monday_19;
  protected ShapeRectangle rect_configureVehicleTrips_monday_20;
  protected ShapeRectangle rect_configureVehicleTrips_monday_21;
  protected ShapeRectangle rect_configureVehicleTrips_monday_22;
  protected ShapeRectangle rect_configureVehicleTrips_monday_23;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_0;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_0;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_0;
  protected ShapeRectangle rect_configureVehicleTrips_friday_0;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_0;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_0;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_1;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_1;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_1;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_1;
  protected ShapeRectangle rect_configureVehicleTrips_friday_1;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_1;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_2;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_2;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_2;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_2;
  protected ShapeRectangle rect_configureVehicleTrips_friday_2;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_2;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_3;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_3;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_3;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_3;
  protected ShapeRectangle rect_configureVehicleTrips_friday_3;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_3;
  protected ShapeRectangle rect_configureVehicleTrips_friday_4;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_4;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_4;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_4;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_4;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_4;
  protected ShapeRectangle rect_configureVehicleTrips_friday_5;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_5;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_5;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_5;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_5;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_5;
  protected ShapeRectangle rect_configureVehicleTrips_friday_6;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_6;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_6;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_6;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_6;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_6;
  protected ShapeRectangle rect_configureVehicleTrips_friday_7;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_7;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_7;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_7;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_7;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_7;
  protected ShapeRectangle rect_configureVehicleTrips_friday_8;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_8;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_8;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_8;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_8;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_8;
  protected ShapeRectangle rect_configureVehicleTrips_friday_9;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_9;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_9;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_9;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_9;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_9;
  protected ShapeRectangle rect_configureVehicleTrips_friday_10;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_10;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_10;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_10;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_10;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_10;
  protected ShapeRectangle rect_configureVehicleTrips_friday_11;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_11;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_11;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_11;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_11;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_11;
  protected ShapeRectangle rect_configureVehicleTrips_friday_12;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_12;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_12;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_12;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_12;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_12;
  protected ShapeRectangle rect_configureVehicleTrips_friday_13;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_13;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_13;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_13;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_13;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_13;
  protected ShapeRectangle rect_configureVehicleTrips_friday_14;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_14;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_14;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_14;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_14;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_14;
  protected ShapeRectangle rect_configureVehicleTrips_friday_15;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_15;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_15;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_15;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_15;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_15;
  protected ShapeRectangle rect_configureVehicleTrips_friday_16;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_16;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_16;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_16;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_16;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_16;
  protected ShapeRectangle rect_configureVehicleTrips_friday_17;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_17;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_17;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_17;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_17;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_17;
  protected ShapeRectangle rect_configureVehicleTrips_friday_18;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_18;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_18;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_18;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_18;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_18;
  protected ShapeRectangle rect_configureVehicleTrips_friday_19;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_19;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_19;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_19;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_19;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_19;
  protected ShapeRectangle rect_configureVehicleTrips_friday_20;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_20;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_20;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_20;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_20;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_20;
  protected ShapeRectangle rect_configureVehicleTrips_friday_21;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_21;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_21;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_21;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_21;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_21;
  protected ShapeRectangle rect_configureVehicleTrips_friday_22;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_22;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_22;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_22;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_22;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_22;
  protected ShapeRectangle rect_configureVehicleTrips_friday_23;
  protected ShapeRectangle rect_configureVehicleTrips_sunday_23;
  protected ShapeRectangle rect_configureVehicleTrips_tuesday_23;
  protected ShapeRectangle rect_configureVehicleTrips_saturday_23;
  protected ShapeRectangle rect_configureVehicleTrips_thursday_23;
  protected ShapeRectangle rect_configureVehicleTrips_wednesday_23;
  protected ShapeGroup gr_configureVehicleTrips_weekButtons;
  protected ShapeText t_configureVehicleTrips_km;
  protected ShapeRectangle rect_disableTripConfigurationButtons_monday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_monday1;
  protected ShapeGroup gr_disableTripConfigurationButtons_monday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_tuesday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_tuesday1;
  protected ShapeGroup gr_disableTripConfigurationButtons_tuesday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_sunday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_sunday1;
  protected ShapeGroup gr_disableTripConfigurationButtons_sunday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_saturday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_saturday1;
  protected ShapeGroup gr_disableTripConfigurationButtons_saturday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_friday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_friday1;
  protected ShapeGroup gr_disableTripConfigurationButtons_friday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_thursday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_thursday1;
  protected ShapeGroup gr_disableTripConfigurationButtons_thursday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_wednesday;
  protected ShapeRectangle rect_disableTripConfigurationButtons_wednesday1;
  protected ShapeGroup gr_disableTripConfigurationButtons_wednesday;
  protected ShapeGroup gr_tripConfigurationDisableRectangles;
  protected ShapeText txt_configureVehicleTrips_1;
  protected ShapeText txt_configureVehicleTrips_2;
  protected ShapeText txt_configureVehicleTrips_3;
  protected ShapeText txt_configureVehicleTrips_4;
  protected ShapeText txt_configureVehicleTrips_5;
  protected ShapeText txt_configureVehicleTrips_6;
  protected ShapeText txt_configureVehicleTrips_7;
  protected ShapeText txt_configureVehicleTrips_8;
  protected ShapeText txt_configureVehicleTrips_9;
  protected ShapeText txt_configureVehicleTrips_10;
  protected ShapeText txt_configureVehicleTrips_11;
  protected ShapeText txt_configureVehicleTrips_12;
  protected ShapeText txt_configureVehicleTrips_13;
  protected ShapeText txt_configureVehicleTrips_14;
  protected ShapeText txt_configureVehicleTrips_15;
  protected ShapeText txt_configureVehicleTrips_16;
  protected ShapeText txt_configureVehicleTrips_17;
  protected ShapeText txt_configureVehicleTrips_18;
  protected ShapeText txt_configureVehicleTrips_19;
  protected ShapeText txt_configureVehicleTrips_20;
  protected ShapeText txt_configureVehicleTrips_21;
  protected ShapeText txt_configureVehicleTrips_22;
  protected ShapeText txt_configureVehicleTrips_23;
  protected ShapeText txt_configureVehicleTrips_24;
  protected ShapeText txt_configureVehicleTrips_0;
  protected ShapeGroup gr_configureVehicleTripsNumbers;
  protected ShapeText txt_configureVehicleTrips_weeklyDistance_unit;
  protected ShapeText txt_configureVehicleTrips_monday;
  protected ShapeText txt_configureVehicleTrips_tuesday;
  protected ShapeText txt_configureVehicleTrips_wednesday;
  protected ShapeText txt_configureVehicleTrips_thursday;
  protected ShapeText txt_configureVehicleTrips_friday;
  protected ShapeText txt_configureVehicleTrips_saturday;
  protected ShapeText txt_configureVehicleTrips_sunday;
  protected ShapeGroup gr_vehicleTripConfiguratorWeekdays;
  protected ShapeText t_tripConfiguratorExplanation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_configureVehicleTrips_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
360 
);
    shape.setY(
580 
);
  }
  
  protected ShapeGroup gr_configureVehicleTrips;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    button1 = new ShapeButton(
UI_company.this, true, 180.0, -80.0,
			160.0, 40.0,
            black, true,
_button1_Font,
			"Go to GC in engine" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button1, 0 );
      }
    };
    rb_scenariosPrivateUI = new ShapeRadioButtonGroup(
UI_company.this, true, -100.0, -60.0,
			180.0, 120.0,
            black, true,
_rb_scenariosPrivateUI_Font, true,
            new String[]{"Huidige situatie", "Toekomstplannen", "Custom", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_scenariosPrivateUI, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _rb_scenariosPrivateUI, 0 ) );
      }
    };
    button2 = new ShapeButton(
UI_company.this, true, 360.0, -80.0,
			160.0, 40.0,
            black, true,
_button2_Font,
			"Go to Building in engine" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button2, 0 );
      }
    };
    button3 = new ShapeButton(
UI_company.this, true, 0.0, -80.0,
			160.0, 40.0,
            black, true,
_button3_Font,
			"Go to Owner in engine" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button3, 0 );
      }
    };
    sl_GCCapacityCompany = new ShapeSlider(
UI_company.this, true, -58.0, 1.0,
			100.0, 30.0,
            true, false,
            v_minContractDeliveryCapacity_kW
            , v_maxContractDeliveryCapacity_kW
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_GCCapacityCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_GCCapacityCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_GCCapacityCompany, 0 ), getMax() ) );
      }
    };
    sl_heatDemandCompanyReduction = new ShapeSlider(
UI_company.this, true, 62.0, -130.0,
			100.0, 30.0,
            true, false,
            v_minSavingsSliders
            , v_maxSavingsSliders
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_heatDemandCompanyReduction_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_heatDemandCompanyReduction, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_heatDemandCompanyReduction, 0 ), getMax() ) );
      }
    };
    sl_electricityDemandCompanyReduction = new ShapeSlider(
UI_company.this, true, -58.0, -29.0,
			100.0, 30.0,
            true, false,
            v_minSavingsSliders
            , v_maxSavingsSliders
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_electricityDemandCompanyReduction_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_electricityDemandCompanyReduction, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_electricityDemandCompanyReduction, 0 ), getMax() ) );
      }
    };
    button_openVehicleTripsConfigurationMenu_car = new ShapeButton(
UI_company.this, true, 35.0, -125.0,
			125.0, 20.0,
            black, true,
_button_openVehicleTripsConfigurationMenu_car_Font,
			"Configureer rijtijden" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_openVehicleTripsConfigurationMenu_car, 0 );
      }
    };
    button_openVehicleTripsConfigurationMenu_van = new ShapeButton(
UI_company.this, true, 35.0, -25.0,
			125.0, 20.0,
            black, true,
_button_openVehicleTripsConfigurationMenu_van_Font,
			"Configureer rijtijden" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_openVehicleTripsConfigurationMenu_van, 0 );
      }
    };
    button_openVehicleTripsConfigurationMenu_truck = new ShapeButton(
UI_company.this, true, 35.0, 75.0,
			125.0, 20.0,
            black, true,
_button_openVehicleTripsConfigurationMenu_truck_Font,
			"Configureer rijtijden" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_openVehicleTripsConfigurationMenu_truck, 0 );
      }
    };
    sl_electricVansCompany = new ShapeSlider(
UI_company.this, true, 62.0, -3.0,
			100.0, 30.0,
            true, false,
            v_minEVVanSlider
            , v_maxEVVanSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_electricVansCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_electricVansCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_electricVansCompany, 0 ), getMax() ) );
      }
    };
    sl_hydrogenVansCompany = new ShapeSlider(
UI_company.this, true, 62.0, 22.0,
			100.0, 30.0,
            true, false,
            v_minHydrogenVanSlider
            , v_maxHydrogenVanSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_hydrogenVansCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_hydrogenVansCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_hydrogenVansCompany, 0 ), getMax() ) );
      }
    };
    sl_petroleumFuelVansCompany = new ShapeSlider(
UI_company.this, true, 62.0, 47.0,
			100.0, 30.0,
            true, false,
            v_minPetroleumFuelVanSlider
            , v_maxPetroleumFuelVanSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_petroleumFuelVansCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_petroleumFuelVansCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_petroleumFuelVansCompany, 0 ), getMax() ) );
      }
    };
    sl_hydrogenTrucksCompany = new ShapeSlider(
UI_company.this, true, 62.0, 117.0,
			100.0, 30.0,
            true, false,
            v_minHydrogenTruckSlider
            , v_maxHydrogenTruckSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_hydrogenTrucksCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_hydrogenTrucksCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_hydrogenTrucksCompany, 0 ), getMax() ) );
      }
    };
    sl_electricTrucksCompany = new ShapeSlider(
UI_company.this, true, 62.0, 92.0,
			100.0, 30.0,
            true, false,
            v_minEVTruckSlider
            , v_maxEVTruckSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_electricTrucksCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_electricTrucksCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_electricTrucksCompany, 0 ), getMax() ) );
      }
    };
    sl_petroleumFuelTrucksCompany = new ShapeSlider(
UI_company.this, true, 62.0, 142.0,
			100.0, 30.0,
            true, false,
            v_minPetroleumFuelTruckSlider
            , v_maxPetroleumFuelTruckSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_petroleumFuelTrucksCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_petroleumFuelTrucksCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_petroleumFuelTrucksCompany, 0 ), getMax() ) );
      }
    };
    sl_electricCarsCompany = new ShapeSlider(
UI_company.this, true, 62.0, -103.0,
			100.0, 30.0,
            true, false,
            v_minEVCarSlider
            , v_maxEVCarSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_electricCarsCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_electricCarsCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_electricCarsCompany, 0 ), getMax() ) );
      }
    };
    sl_mobilityDemandCompanyReduction = new ShapeSlider(
UI_company.this, true, 62.0, -160.0,
			100.0, 30.0,
            true, false,
            v_minSavingsSliders
            , v_maxSavingsSliders
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_mobilityDemandCompanyReduction_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_mobilityDemandCompanyReduction, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_mobilityDemandCompanyReduction, 0 ), getMax() ) );
      }
    };
    sl_hydrogenCarsCompany = new ShapeSlider(
UI_company.this, true, 62.0, -78.0,
			100.0, 30.0,
            true, false,
            v_minHydrogenCarSlider
            , v_maxHydrogenCarSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_hydrogenCarsCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_hydrogenCarsCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_hydrogenCarsCompany, 0 ), getMax() ) );
      }
    };
    sl_petroleumFuelCarsCompany = new ShapeSlider(
UI_company.this, true, 62.0, -54.0,
			100.0, 30.0,
            true, false,
            v_minPetroleumFuelCarSlider
            , v_maxPetroleumFuelCarSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_petroleumFuelCarsCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_petroleumFuelCarsCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_petroleumFuelCarsCompany, 0 ), getMax() ) );
      }
    };
    cb_selectGC = new ShapeComboBox(
UI_company.this, true, -84.0, -13.0,
			190.0, 20.0,
            white, black, true,
_cb_selectGC_Font,
            new String[]{"0", "1", }, false, ShapeControl.TYPE_STRING ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_selectGC, 0, value );
      }
    };
    sl_batteryCompany = new ShapeSlider(
UI_company.this, true, -58.0, 61.0,
			100.0, 30.0,
            true, false,
            v_minBatSlider
            , v_maxBatSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_batteryCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_batteryCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_batteryCompany, 0 ), getMax() ) );
      }
    };
    rb_heatingTypePrivateUI = new ShapeRadioButtonGroup(
UI_company.this, true, -290.0, -206.0,
			180.0, 121.0,
            black, true,
_rb_heatingTypePrivateUI_Font, true,
            new String[]{"HR ketel aardgas", "Hybride warmtepomp", "Elek. warmtepomp", "Warmtenet", "Custom", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_heatingTypePrivateUI, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _rb_heatingTypePrivateUI, 0 ) );
      }
    };
    sl_rooftopPVCompany = new ShapeSlider(
UI_company.this, true, -58.0, 91.0,
			100.0, 30.0,
            true, false,
            v_minPVSlider
            , v_maxPVSlider
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_rooftopPVCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_rooftopPVCompany, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_rooftopPVCompany, 0 ), getMax() ) );
      }
    };
    sl_GCCapacityCompany_Feedin = new ShapeSlider(
UI_company.this, true, -58.0, 31.0,
			100.0, 30.0,
            true, false,
            v_minContractFeedinCapacity_kW
            , v_maxContractFeedinCapacity_kW
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_GCCapacityCompany_Feedin_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_GCCapacityCompany_Feedin, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_GCCapacityCompany_Feedin, 0 ), getMax() ) );
      }
    };
    button = new ShapeButton(
UI_company.this, true, 1670.0, 20.0,
			230.0, 50.0,
            black, true,
_button_Font,
			"Terug naar hoofdscherm" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button, 0 );
      }
    };
    cb_curtailmentCompany = new ShapeCheckBox(
UI_company.this,true,291.0, 564.0,
		20.0, 30.0,
            black, true,
            _cb_curtailmentCompany_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_curtailmentCompany, 0, value );
      }
    };
    cb_showGridloadPlot = new ShapeCheckBox(
UI_company.this,true,1450.0, 130.0,
		180.0, 30.0,
            black, true,
            _cb_showGridloadPlot_Font,
			"Toon Netbelasting duurkromme" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_showGridloadPlot, 0, value );
      }
    };
    cb_configureVehicleTrips_dailyDistinction = new ShapeCheckBox(
UI_company.this,true,20.0, 90.0,
		135.0, 30.0,
            black, true,
            _cb_configureVehicleTrips_dailyDistinction_Font,
			"Verschil per dag" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_configureVehicleTrips_dailyDistinction, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_configureVehicleTrips_dailyDistinction, 0 ) );
      }
    };
    button_confirm_configureVehicleTrips = new ShapeButton(
UI_company.this, true, 20.0, 360.0,
			215.0, 30.0,
            black, true,
_button_confirm_configureVehicleTrips_Font,
			"Voltooi voertuig rijtijden configuratie" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_confirm_configureVehicleTrips_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_confirm_configureVehicleTrips, 0 );
      }
    };
    button_cancel_configureVehicleTrips = new ShapeButton(
UI_company.this, true, 615.0, 360.0,
			115.0, 30.0,
            black, true,
_button_cancel_configureVehicleTrips_Font,
			"Annuleren" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_cancel_configureVehicleTrips, 0 );
      }
    };
    cb_configureVehicleTripsMonday = new ShapeCheckBox(
UI_company.this,true,100.0, 140.0,
		20.0, 30.0,
            black, true,
            _cb_configureVehicleTripsMonday_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_configureVehicleTripsMonday, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_configureVehicleTripsMonday, 0 ) );
      }
    };
    cb_configureVehicleTripsTuesday = new ShapeCheckBox(
UI_company.this,true,100.0, 170.0,
		20.0, 30.0,
            black, false,
            _cb_configureVehicleTripsTuesday_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_configureVehicleTripsTuesday, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_configureVehicleTripsTuesday, 0 ) );
      }
    };
    cb_configureVehicleTripsWednesday = new ShapeCheckBox(
UI_company.this,true,100.0, 200.0,
		20.0, 30.0,
            black, false,
            _cb_configureVehicleTripsWednesday_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_configureVehicleTripsWednesday, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_configureVehicleTripsWednesday, 0 ) );
      }
    };
    cb_configureVehicleTripsThursday = new ShapeCheckBox(
UI_company.this,true,100.0, 230.0,
		20.0, 30.0,
            black, false,
            _cb_configureVehicleTripsThursday_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_configureVehicleTripsThursday, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_configureVehicleTripsThursday, 0 ) );
      }
    };
    cb_configureVehicleTripsFriday = new ShapeCheckBox(
UI_company.this,true,100.0, 260.0,
		20.0, 30.0,
            black, false,
            _cb_configureVehicleTripsFriday_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_configureVehicleTripsFriday, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_configureVehicleTripsFriday, 0 ) );
      }
    };
    cb_configureVehicleTripsSaturday = new ShapeCheckBox(
UI_company.this,true,100.0, 290.0,
		20.0, 30.0,
            black, false,
            _cb_configureVehicleTripsSaturday_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_configureVehicleTripsSaturday, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_configureVehicleTripsSaturday, 0 ) );
      }
    };
    cb_configureVehicleTripsSunday = new ShapeCheckBox(
UI_company.this,true,100.0, 320.0,
		20.0, 30.0,
            black, false,
            _cb_configureVehicleTripsSunday_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_configureVehicleTripsSunday, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_configureVehicleTripsSunday, 0 ) );
      }
    };
    button_configureVehicleTrips_reset = new ShapeButton(
UI_company.this, true, 500.0, 360.0,
			100.0, 30.0,
            black, true,
_button_configureVehicleTrips_reset_Font,
			"reset values" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_configureVehicleTrips_reset, 0 );
      }
    };
    eb_configureVehicleTrips_weeklyDistance_km = new ShapeTextField(
UI_company.this, true,545.0, 70.0,
			100.0, 30.0,
            white, black, true, _eb_configureVehicleTrips_weeklyDistance_km_Font ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _eb_configureVehicleTrips_weeklyDistance_km, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setText( getShapeControlDefaultValueString( _eb_configureVehicleTrips_weeklyDistance_km, 0 ) );
      }
    };
    rect_canvas = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-1160.0, -400.0, 0.0, 0.0,
            black, white,
			4560.0, 1800.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_background = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            black, white,
			1920.0, 980.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_background_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_sliders = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 140.0, 0.0, 0.0,
            black, white,
			360.0, 840.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_sliders_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_scenarios = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            black, white,
			360.0, 140.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_scenarios_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text = new ShapeText(
        SHAPE_DRAW_2D, false,-440.0, 20.0, 0.0, 0.0,
        black,"Colors and Styling",
        _text_Font, ALIGNMENT_LEFT );
    text4 = new ShapeText(
        SHAPE_DRAW_2D, false,-750.0, 20.0, 0.0, 0.0,
        black,"Company parameters",
        _text4_Font, ALIGNMENT_LEFT );
    txt_storedScenarios = new ShapeText(
        SHAPE_DRAW_2D, false,-750.0, 110.0, 0.0, 0.0,
        black,"Scenarios",
        _txt_storedScenarios_Font, ALIGNMENT_LEFT );
    txt_scenario = new ShapeText(
        SHAPE_DRAW_2D, true,-100.0, -80.0, 0.0, 0.0,
        black,"Selecteer een scenario",
        _txt_scenario_Font, ALIGNMENT_LEFT );
    txt_scenarioSettings = new ShapeText(
        SHAPE_DRAW_2D, true,-440.0, 340.0, 0.0, 0.0,
        black,"Set Sliders to Scenario",
        _txt_scenarioSettings_Font, ALIGNMENT_LEFT );
    txt_sliderPresetsAndLimits = new ShapeText(
        SHAPE_DRAW_2D, true,-1100.0, 160.0, 0.0, 0.0,
        black,"Slider limits and presets",
        _txt_sliderPresetsAndLimits_Font, ALIGNMENT_LEFT );
    txt_sliderFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-440.0, 460.0, 0.0, 0.0,
        black,"Slider functions",
        _txt_sliderFunctions_Font, ALIGNMENT_LEFT );
    txt_initialization = new ShapeText(
        SHAPE_DRAW_2D, true,-1100.0, 10.0, 0.0, 0.0,
        black,"Initialization",
        _txt_initialization_Font, ALIGNMENT_LEFT );
    txt_uiResult = new ShapeText(
        SHAPE_DRAW_2D, true,-1060.0, 1280.0, 0.0, 0.0,
        black,"UI_Result connection (graphs)",
        _txt_uiResult_Font, ALIGNMENT_LEFT );
    txt_warmte = new ShapeText(
        SHAPE_DRAW_2D, true,-240.0, -270.0, 0.0, 0.0,
        black,"Warmte",
        _txt_warmte_Font, ALIGNMENT_LEFT );
    t_GCCapacityCompany = new ShapeText(
        SHAPE_DRAW_2D, true,-85.0, 6.0, 0.0, 0.0,
        black,"0 kW",
        _t_GCCapacityCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCCapacityCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_GCCapacity = new ShapeText(
        SHAPE_DRAW_2D, true,-290.0, 6.0, 0.0, 0.0,
        black,"Contr. capaciteit (af.)",
        _txt_GCCapacity_Font, ALIGNMENT_LEFT );
    text195 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, -125.0, 0.0, 0.0,
        black,"Besparing warmte",
        _text195_Font, ALIGNMENT_LEFT );
    t_heatDemandReductionCompanies = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, -125.0, 0.0, 0.0,
        black,"0%",
        _t_heatDemandReductionCompanies_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_heatDemandReductionCompanies_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_elektriciteit = new ShapeText(
        SHAPE_DRAW_2D, true,-240.0, -68.0, 0.0, 0.0,
        black,"Elektriciteit",
        _txt_elektriciteit_Font, ALIGNMENT_LEFT );
    txt_mobiliteit = new ShapeText(
        SHAPE_DRAW_2D, true,-240.0, 166.0, 0.0, 0.0,
        black,"Transport",
        _txt_mobiliteit_Font, ALIGNMENT_LEFT );
    t_electricityDemandReductionCompany = new ShapeText(
        SHAPE_DRAW_2D, true,-85.0, -24.0, 0.0, 0.0,
        black,"0%",
        _t_electricityDemandReductionCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_electricityDemandReductionCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text279 = new ShapeText(
        SHAPE_DRAW_2D, true,-290.0, -24.0, 0.0, 0.0,
        black,"Besparing elektriciteit",
        _text279_Font, ALIGNMENT_LEFT );
    text266 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, 0.0, 0.0, 0.0,
        black,"Elektrisch",
        _text266_Font, ALIGNMENT_LEFT );
    t_numberOfElectricVansCompany = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, 0.0, 0.0, 0.0,
        black,"0",
        _t_numberOfElectricVansCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_numberOfElectricVansCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text271 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, 25.0, 0.0, 0.0,
        black,"Waterstof",
        _text271_Font, ALIGNMENT_LEFT );
    t_numberOfHydrogenVansCompany = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, 25.0, 0.0, 0.0,
        black,"0",
        _t_numberOfHydrogenVansCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_numberOfHydrogenVansCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text285 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, 50.0, 0.0, 0.0,
        black,"Fossiele brandstof",
        _text285_Font, ALIGNMENT_LEFT );
    t_numberOfPetroleumFuelVansCompany = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, 50.0, 0.0, 0.0,
        black,"0",
        _t_numberOfPetroleumFuelVansCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_numberOfPetroleumFuelVansCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text274 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, -25.0, 0.0, 0.0,
        black,"Busjes",
        _text274_Font, ALIGNMENT_LEFT );
    t_numberOfPetroleumFuelTrucksCompany = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, 145.0, 0.0, 0.0,
        black,"0",
        _t_numberOfPetroleumFuelTrucksCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_numberOfPetroleumFuelTrucksCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_numberOfHydrogenTrucksCompany = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, 120.0, 0.0, 0.0,
        black,"0",
        _t_numberOfHydrogenTrucksCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_numberOfHydrogenTrucksCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text272 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, 120.0, 0.0, 0.0,
        black,"Waterstof",
        _text272_Font, ALIGNMENT_LEFT );
    text286 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, 145.0, 0.0, 0.0,
        black,"Fossiele brandstof",
        _text286_Font, ALIGNMENT_LEFT );
    text268 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, 95.0, 0.0, 0.0,
        black,"Elektrisch",
        _text268_Font, ALIGNMENT_LEFT );
    text275 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, 70.0, 0.0, 0.0,
        black,"Trucks",
        _text275_Font, ALIGNMENT_LEFT );
    t_numberOfElectricTrucksCompany = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, 95.0, 0.0, 0.0,
        black,"0",
        _t_numberOfElectricTrucksCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_numberOfElectricTrucksCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text265 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, -100.0, 0.0, 0.0,
        black,"Elektrisch",
        _text265_Font, ALIGNMENT_LEFT );
    t_numberOfElectricCarsCompany = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, -100.0, 0.0, 0.0,
        black,"0",
        _t_numberOfElectricCarsCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_numberOfElectricCarsCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text267 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, -155.0, 0.0, 0.0,
        black,"Besparing transport",
        _text267_Font, ALIGNMENT_LEFT );
    t_mobilityDemandReductionCompany = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, -155.0, 0.0, 0.0,
        black,"0%",
        _t_mobilityDemandReductionCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_mobilityDemandReductionCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text270 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, -75.0, 0.0, 0.0,
        black,"Waterstof",
        _text270_Font, ALIGNMENT_LEFT );
    t_numberOfHydrogenCarsCompany = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, -75.0, 0.0, 0.0,
        black,"0",
        _t_numberOfHydrogenCarsCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_numberOfHydrogenCarsCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text284 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, -50.0, 0.0, 0.0,
        black,"Fossiele brandstof",
        _text284_Font, ALIGNMENT_LEFT );
    t_numberOfPetroleumFuelCarsCompany = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, -50.0, 0.0, 0.0,
        black,"0",
        _t_numberOfPetroleumFuelCarsCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_numberOfPetroleumFuelCarsCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text273 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, -125.0, 0.0, 0.0,
        black,"Auto's",
        _text273_Font, ALIGNMENT_LEFT );
    text9 = new ShapeText(
        SHAPE_DRAW_2D, true,-240.0, -10.0, 0.0, 0.0,
        black,"Geselecteerde Aansluiting:",
        _text9_Font, ALIGNMENT_LEFT );
    t_batteryCompany = new ShapeText(
        SHAPE_DRAW_2D, true,-85.0, 66.0, 0.0, 0.0,
        black,"0 kWh",
        _t_batteryCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_batteryCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text283 = new ShapeText(
        SHAPE_DRAW_2D, true,-290.0, 66.0, 0.0, 0.0,
        black,"Batterij capaciteit",
        _text283_Font, ALIGNMENT_LEFT );
    ovalElectricityButton1 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       whiteSmoke, lightYellow,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    image4 = new ShapeImage(
		UI_company.this, SHAPE_DRAW_2D3D, true, -14.0, -12.0, 0.0, 0.0,
28.0, 24.0, "/zerointerfaceloader/",
			new String[]{"noun-electricity-3408805.png",} );
    ovalHeatButton1 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       whiteSmoke, mistyRose,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    image11 = new ShapeImage(
		UI_company.this, SHAPE_DRAW_2D3D, true, -14.0, -12.0, 0.0, 0.0,
28.0, 24.0, "/zerointerfaceloader/",
			new String[]{"noun-fire-2429630.png",} );
    ovalTransportButton1 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       whiteSmoke, _ovalTransportButton1_Fill_Color,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    image16 = new ShapeImage(
		UI_company.this, SHAPE_DRAW_2D3D, true, -14.0, -12.0, 0.0, 0.0,
28.0, 24.0, "/zerointerfaceloader/",
			new String[]{"noun-car-1777731.png",} );
    t_rooftopSolarCompany = new ShapeText(
        SHAPE_DRAW_2D, true,-85.0, 96.0, 0.0, 0.0,
        black,"0 kW",
        _t_rooftopSolarCompany_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_rooftopSolarCompany_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_PVPower = new ShapeText(
        SHAPE_DRAW_2D, true,-290.0, 96.0, 0.0, 0.0,
        black,"PV vermogen",
        _txt_PVPower_Font, ALIGNMENT_LEFT );
    t_GCCapacityCompany_Feedin = new ShapeText(
        SHAPE_DRAW_2D, true,-85.0, 36.0, 0.0, 0.0,
        black,"0 kW",
        _t_GCCapacityCompany_Feedin_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCCapacityCompany_Feedin_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_GCCapacityCompany_Feedin = new ShapeText(
        SHAPE_DRAW_2D, true,-290.0, 36.0, 0.0, 0.0,
        black,"Contr. capaciteit (te.)",
        _txt_GCCapacityCompany_Feedin_Font, ALIGNMENT_LEFT );
    roundRect_companyName = new ShapeRoundedRectangle(
true,-298.0, -59.512, 0.0,
        black, white,
596.0, 119.024,10.0,
		2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _roundRect_companyName_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP1_xjal() {
    t_companyName = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -46.34, 0.0, 0.0,
        black,"Company Name",
        _t_companyName_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_companyName_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_GCadress = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, 23.17, 0.0, 0.0,
        black,"Adress",
        _t_GCadress_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCadress_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    mask_resultsUI1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,370.0, 60.0, 0.0, 0.0,
            white, white,
			470.0, 110.0, 10.0, 3.0, LINE_STYLE_SOLID );
    mask_resultsUI1.setVisible( false );
    mask_resultsUI2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,845.0, 270.0, 0.0, 0.0,
            white, white,
			2495.0, 700.0, 10.0, 3.0, LINE_STYLE_SOLID );
    mask_resultsUI2.setVisible( false );
    rect_chartNameLeft = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -30.0, 0.0, 0.0,
            black, white,
			460.0, 50.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_chartNameLeft_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_chartNameLeft = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -20.0, 0.0, 0.0,
        black,"Profielen",
        _txt_chartNameLeft_Font, ALIGNMENT_CENTER );
    rect_chartNameMiddle = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -30.0, 0.0, 0.0,
            black, white,
			460.0, 50.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_chartNameMiddle_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_chartNameMiddle = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -20.0, 0.0, 0.0,
        black,"Opwek/verbruik diagram",
        _txt_chartNameMiddle_Font, ALIGNMENT_CENTER );
    rect_chartNameRight = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -30.0, 0.0, 0.0,
            black, white,
			460.0, 50.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_chartNameRight_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_chartNameRight = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -20.0, 0.0, 0.0,
        black,"Energiestromen",
        _txt_chartNameRight_Font, ALIGNMENT_CENTER );
    rect_simulateYearScreen2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-535.0, -320.0, 0.0, 0.0,
            mistyRose, white,
			1060.0, 750.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_simulateYearScreen2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_simulateYearToCalculateCostsSmall = new ShapeText(
        SHAPE_DRAW_2D, true,-140.0, -40.0, 0.0, 0.0,
        black,"Simuleer jaar voor KPI's",
        _t_simulateYearToCalculateCostsSmall_Font, ALIGNMENT_CENTER );
    image_simulateYearToCalculateCostsSmall = new ShapeImage(
		UI_company.this, SHAPE_DRAW_2D3D, true, -420.0, -70.0, 0.0, 0.0,
102.315, 99.723, "/zerointerfaceloader/",
			new String[]{"icon_greater_than.png",} );
    rect_loadIcon = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-1520.0, -60.969, 0.0, 0.0,
            _rect_loadIcon_Line_Color, _rect_loadIcon_Fill_Color,
			1065.0, 755.969, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_loadIcon_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GCisPausedScreen3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-1990.0, -60.0, 0.0, 0.0,
            mistyRose, white,
			480.0, 755.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GCisPausedScreen3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GCisPausedScreen3.setVisible( false );
    image_loadIconSmall = new ShapeImage(
		UI_company.this, SHAPE_DRAW_2D3D, true, -27.610999999999876, -5.4780000000000655, 0.0, 0.0,
61.016, 60.969, "/zerointerfaceloader/",
			new String[]{"icon_loading.gif",} );
    t_loadIconSmall = new ShapeText(
        SHAPE_DRAW_2D, true,2.8969999999999345, -55.96199999999999, 0.0, 0.0,
        black,"Jaar wordt gesimuleerd ",
        _t_loadIconSmall_Font, ALIGNMENT_CENTER );
    txt_curtailmentDescriptionCompany = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 571.0, 0.0, 0.0,
        black,"Curtailment opwek",
        _txt_curtailmentDescriptionCompany_Font, ALIGNMENT_LEFT );
    txt_nfatoValues = new ShapeText(
        SHAPE_DRAW_2D, true,-440.0, 680.0, 0.0, 0.0,
        black,"NF ATO values",
        _txt_nfatoValues_Font, ALIGNMENT_LEFT );
    rect_table_GridconnectionCapacaties = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-185.0, -60.0, 0.0, 0.0,
            black, white,
			380.0, 120.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_table_GridconnectionCapacaties_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_additionalGCCapacityInfo = new ShapeText(
        SHAPE_DRAW_2D, true,-178.0, -51.0, 0.0, 0.0,
        black,"Aansluitings capaciteit type",
        _txt_additionalGCCapacityInfo_Font, ALIGNMENT_LEFT );
    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,-175.0, -17.0, 0.0, 0.0,
        black,"Fysieke capaciteit",
        _text1_Font, ALIGNMENT_LEFT );
    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,-175.0, 8.0, 0.0, 0.0,
        black,"Contract capaciteit afname",
        _text2_Font, ALIGNMENT_LEFT );
    text3 = new ShapeText(
        SHAPE_DRAW_2D, true,-175.0, 33.0, 0.0, 0.0,
        black,"Contract capaciteit teruglevering",
        _text3_Font, ALIGNMENT_LEFT );
    t_GCCapacityCompany_delivery2 = new ShapeText(
        SHAPE_DRAW_2D, true,152.0, 8.0, 0.0, 0.0,
        black,"0 kW",
        _t_GCCapacityCompany_delivery2_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCCapacityCompany_delivery2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_GCCapacityCompany_Feedin_2 = new ShapeText(
        SHAPE_DRAW_2D, true,152.0, 33.0, 0.0, 0.0,
        black,"0 kW",
        _t_GCCapacityCompany_Feedin_2_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCCapacityCompany_Feedin_2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_GCCapacityCompany_physical = new ShapeText(
        SHAPE_DRAW_2D, true,152.0, -17.0, 0.0, 0.0,
        black,"0 kW",
        _t_GCCapacityCompany_physical_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCCapacityCompany_physical_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    line_table_ConnectionCapacityInfo_1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 41.0, -60.0, 0.0, black,
 		0.0,	120.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _line_table_ConnectionCapacityInfo_1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_table_ConnectionCapacityInfo_owned = new ShapeText(
        SHAPE_DRAW_2D, true,152.0, -51.0, 0.0, 0.0,
        black,"Capaciteit",
        _txt_table_ConnectionCapacityInfo_owned_Font, ALIGNMENT_CENTER );
    line_table_ConnectionCapacityInfo_3 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -185.0, -25.0, 0.0, black,
 		380.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _line_table_ConnectionCapacityInfo_3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_Table_NFATO = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-30.0, -60.0, 0.0, 0.0,
            black, white,
			65.0, 120.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_Table_NFATO_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_table_ConnectionCapacityInfo_nfato = new ShapeText(
        SHAPE_DRAW_2D, true,3.0, -51.0, 0.0, 0.0,
        black,"NF ATO",
        _txt_table_ConnectionCapacityInfo_nfato_Font, ALIGNMENT_CENTER );
    t_GCCapacityCompany_delivery_nfato = new ShapeText(
        SHAPE_DRAW_2D, true,0.5, 8.0, 0.0, 0.0,
        black,"0 kW",
        _t_GCCapacityCompany_delivery_nfato_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCCapacityCompany_delivery_nfato_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_GCCapacityCompany_Feedin_nfato = new ShapeText(
        SHAPE_DRAW_2D, true,0.5, 33.0, 0.0, 0.0,
        black,"0 kW",
        _t_GCCapacityCompany_Feedin_nfato_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCCapacityCompany_Feedin_nfato_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_GCCapacityCompany_physical_nfato = new ShapeText(
        SHAPE_DRAW_2D, true,0.5, -17.0, 0.0, 0.0,
        black,"---",
        _t_GCCapacityCompany_physical_nfato_Font, ALIGNMENT_CENTER );
    line_table_ConnectionCapacityInfo_NFATO = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -30.0, -25.0, 0.0, black,
 		65.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _line_table_ConnectionCapacityInfo_NFATO_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    line_table_ConnectionCapacityInfo_2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 109.0, -60.0, 0.0, black,
 		0.0,	120.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _line_table_ConnectionCapacityInfo_2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_table_ConnectionCapacityInfo_known = new ShapeText(
        SHAPE_DRAW_2D, true,75.0, -51.0, 0.0, 0.0,
        black,"Status",
        _txt_table_ConnectionCapacityInfo_known_Font, ALIGNMENT_CENTER );
    t_GCCapacityCompany_delivery3 = new ShapeText(
        SHAPE_DRAW_2D, true,75.0, 8.0, 0.0, 0.0,
        black,"Custom",
        _t_GCCapacityCompany_delivery3_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCCapacityCompany_delivery3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_GCCapacityCompany_Feedin_3 = new ShapeText(
        SHAPE_DRAW_2D, true,75.0, 33.0, 0.0, 0.0,
        black,"Geschat",
        _t_GCCapacityCompany_Feedin_3_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCCapacityCompany_Feedin_3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_GCCapacityCompany_physical1 = new ShapeText(
        SHAPE_DRAW_2D, true,75.0, -17.0, 0.0, 0.0,
        black,"Bekend",
        _t_GCCapacityCompany_physical1_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_GCCapacityCompany_physical1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GCisPausedScreen = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-1010.0, -320.0, 0.0, 0.0,
            _rect_GCisPausedScreen_Line_Color, _rect_GCisPausedScreen_Fill_Color,
			545.0, 760.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GCisPausedScreen_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GCisPausedScreen2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-535.0, -320.0, 0.0, 0.0,
            mistyRose, white,
			1075.0, 760.0, 10.0, 2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GCisPausedScreen2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_GCisPausedScreen = new ShapeText(
        SHAPE_DRAW_2D, true,-140.0, -80.0, 0.0, 0.0,
        black,"Onpauzeer aansluiting\nen \nsimuleer jaar voor KPI's",
        _t_GCisPausedScreen_Font, ALIGNMENT_CENTER );
    image_simulateYearToCalculateCostsSmall1 = new ShapeImage(
		UI_company.this, SHAPE_DRAW_2D3D, true, -420.0, -70.0, 0.0, 0.0,
102.315, 99.723, "/zerointerfaceloader/",
			new String[]{"icon_greater_than.png",} );
    txt_GCisPaused = new ShapeText(
        SHAPE_DRAW_2D, true,-235.0, -230.0, 0.0, 0.0,
        black,"Aansluiting is gepauzeerd!",
        _txt_GCisPaused_Font, ALIGNMENT_CENTER );
    rect_errorScreenGrayOut = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-960.0, -500.0, 0.0, 0.0,
            _rect_errorScreenGrayOut_Line_Color, _rect_errorScreenGrayOut_Fill_Color,
			1920.0, 980.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_errorScreenClickBlocking = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-960.0, -500.0, 0.0, 0.0,
            _rect_errorScreenClickBlocking_Line_Color, _rect_errorScreenClickBlocking_Fill_Color,
			1920.0, 980.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_errorScreenClickBlocking_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_errorScreenClickBlocking, 0, clickx, clicky );
      }
    };
    rect_errorMessage = new ShapeRoundedRectangle(
true,-270.0, -120.0, 0.0,
        red, white,
540.0, 200.0,10.0,
		4.0, LINE_STYLE_SOLID );
    t_errorMessage = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -70.0, 0.0, 0.0,
        black,"TYPE YOUR ERROR MESSAGE HERE",
        _t_errorMessage_Font, ALIGNMENT_CENTER );
    rect_errorOK = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -20.0, 0.0, 0.0,
            black, white,
			120.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_errorOK = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -10.0, 0.0, 0.0,
        black,"Ok",
        _txt_errorOK_Font, ALIGNMENT_CENTER );
    txt_setSimYearScreen = new ShapeText(
        SHAPE_DRAW_2D, true,-440.0, 800.0, 0.0, 0.0,
        black,"Simulate year screen",
        _txt_setSimYearScreen_Font, ALIGNMENT_LEFT );
    txt_selectDifferentOwnedGC = new ShapeText(
        SHAPE_DRAW_2D, true,-440.0, 250.0, 0.0, 0.0,
        black,"Select different owned GC",
        _txt_selectDifferentOwnedGC_Font, ALIGNMENT_LEFT );
    rect_configureVehicleTripsBackground = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 20.0, 0.0, 0.0,
            null, _rect_configureVehicleTripsBackground_Fill_Color,
			750.0, 380.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_configureVehicleTrips_monday_0 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_0, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-275.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_1, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-250.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_2, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-225.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_3, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_4, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-175.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_5, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_6 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-150.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_6, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_7 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-125.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_7, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_8 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-100.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_8, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_9 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-75.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_9, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_10 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-50.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_10, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_11 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-25.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_11, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_12 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_12, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_13 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,25.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_13, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_14 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,50.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_14, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_15 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,75.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_15, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_16 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,100.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_16, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_17 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,125.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_17, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_18 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,150.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_18, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_19 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,175.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_19, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_20 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,200.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_20, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_21 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,225.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_21, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_22 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,250.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_22, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_monday_23 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,275.0, -107.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_monday_23, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_0 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_0, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_0 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_0, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_0 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_0, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_0 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_0, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_0 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_0, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_0 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_0, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-275.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_1, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-275.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_1, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-275.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_1, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-275.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_1, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-275.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_1, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-275.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_1, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-250.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_2, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-250.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_2, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-250.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_2, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-250.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_2, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-250.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_2, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-250.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_2, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-225.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_3, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-225.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_3, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-225.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_3, 0, clickx, clicky );
      }
    };
  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP2_xjal() {
    rect_configureVehicleTrips_sunday_3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-225.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_3, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-225.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_3, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-225.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_3, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_4, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_4, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_4, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_4, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_4, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_4, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-175.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_5, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-175.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_5, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-175.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_5, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-175.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_5, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-175.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_5, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-175.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_5, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_6 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-150.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_6, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_6 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-150.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_6, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_6 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-150.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_6, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_6 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-150.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_6, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_6 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-150.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_6, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_6 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-150.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_6, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_7 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-125.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_7, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_7 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-125.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_7, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_7 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-125.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_7, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_7 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-125.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_7, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_7 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-125.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_7, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_7 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-125.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_7, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_8 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-100.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_8, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_8 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-100.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_8, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_8 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-100.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_8, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_8 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-100.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_8, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_8 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-100.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_8, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_8 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-100.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_8, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_9 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-75.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_9, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_9 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-75.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_9, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_9 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-75.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_9, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_9 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-75.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_9, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_9 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-75.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_9, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_9 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-75.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_9, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_10 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-50.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_10, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_10 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-50.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_10, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_10 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-50.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_10, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_10 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-50.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_10, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_10 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-50.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_10, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_10 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-50.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_10, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_11 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-25.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_11, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_11 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-25.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_11, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_11 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-25.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_11, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_11 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-25.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_11, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_11 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-25.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_11, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_11 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-25.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_11, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_12 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_12, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_12 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_12, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_12 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_12, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_12 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_12, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_12 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_12, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_12 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_12, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_13 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,25.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_13, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_13 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,25.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_13, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_13 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,25.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_13, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_13 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,25.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_13, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_13 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,25.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_13, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_13 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,25.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_13, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_14 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,50.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_14, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_14 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,50.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_14, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_14 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,50.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_14, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_14 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,50.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_14, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_14 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,50.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_14, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_14 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,50.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_14, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_15 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,75.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_15, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_15 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,75.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_15, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_15 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,75.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_15, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_15 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,75.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_15, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_15 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,75.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_15, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_15 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,75.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_15, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_16 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,100.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_16, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_16 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,100.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_16, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_16 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,100.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_16, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_16 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,100.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_16, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_16 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,100.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_16, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_16 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,100.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_16, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_17 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,125.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_17, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_17 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,125.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_17, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_17 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,125.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_17, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_17 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,125.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_17, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_17 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,125.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_17, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_17 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,125.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_17, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_18 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,150.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_18, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_18 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,150.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_18, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_18 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,150.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_18, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_18 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,150.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_18, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_18 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,150.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_18, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_18 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,150.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_18, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_19 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,175.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_19, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_19 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,175.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_19, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_19 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,175.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_19, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_19 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,175.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_19, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_19 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,175.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_19, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_19 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,175.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_19, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_20 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,200.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_20, 0, clickx, clicky );
      }
    };
  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP3_xjal() {
    rect_configureVehicleTrips_sunday_20 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,200.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_20, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_20 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,200.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_20, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_20 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,200.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_20, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_20 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,200.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_20, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_20 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,200.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_20, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_21 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,225.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_21, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_21 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,225.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_21, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_21 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,225.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_21, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_21 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,225.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_21, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_21 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,225.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_21, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_21 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,225.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_21, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_22 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,250.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_22, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_22 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,250.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_22, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_22 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,250.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_22, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_22 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,250.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_22, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_22 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,250.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_22, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_22 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,250.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_22, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_friday_23 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,275.0, 13.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_friday_23, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_sunday_23 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,275.0, 73.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_sunday_23, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_tuesday_23 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,275.0, -77.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_tuesday_23, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_saturday_23 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,275.0, 43.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_saturday_23, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_thursday_23 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,275.0, -17.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_thursday_23, 0, clickx, clicky );
      }
    };
    rect_configureVehicleTrips_wednesday_23 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,275.0, -47.0, 0.0, 0.0,
            black, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_configureVehicleTrips_wednesday_23, 0, clickx, clicky );
      }
    };
    t_configureVehicleTrips_km = new ShapeText(
        SHAPE_DRAW_2D, true,595.0, 45.0, 0.0, 0.0,
        black,"Weeklijks gereden afstand per voertuig",
        _t_configureVehicleTrips_km_Font, ALIGNMENT_CENTER );
    rect_disableTripConfigurationButtons_monday = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            null, null,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_disableTripConfigurationButtons_monday, 0, clickx, clicky );
      }
    };
    rect_disableTripConfigurationButtons_monday1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            _rect_disableTripConfigurationButtons_monday1_Line_Color, _rect_disableTripConfigurationButtons_monday1_Fill_Color,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_disableTripConfigurationButtons_tuesday = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            null, null,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_disableTripConfigurationButtons_tuesday, 0, clickx, clicky );
      }
    };
    rect_disableTripConfigurationButtons_tuesday1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            _rect_disableTripConfigurationButtons_tuesday1_Line_Color, _rect_disableTripConfigurationButtons_tuesday1_Fill_Color,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_disableTripConfigurationButtons_sunday = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            null, null,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_disableTripConfigurationButtons_sunday, 0, clickx, clicky );
      }
    };
    rect_disableTripConfigurationButtons_sunday1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            _rect_disableTripConfigurationButtons_sunday1_Line_Color, _rect_disableTripConfigurationButtons_sunday1_Fill_Color,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_disableTripConfigurationButtons_saturday = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            null, null,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_disableTripConfigurationButtons_saturday, 0, clickx, clicky );
      }
    };
    rect_disableTripConfigurationButtons_saturday1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            _rect_disableTripConfigurationButtons_saturday1_Line_Color, _rect_disableTripConfigurationButtons_saturday1_Fill_Color,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_disableTripConfigurationButtons_friday = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            null, null,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_disableTripConfigurationButtons_friday, 0, clickx, clicky );
      }
    };
    rect_disableTripConfigurationButtons_friday1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            _rect_disableTripConfigurationButtons_friday1_Line_Color, _rect_disableTripConfigurationButtons_friday1_Fill_Color,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_disableTripConfigurationButtons_thursday = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            null, null,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_disableTripConfigurationButtons_thursday, 0, clickx, clicky );
      }
    };
    rect_disableTripConfigurationButtons_thursday1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            _rect_disableTripConfigurationButtons_thursday1_Line_Color, _rect_disableTripConfigurationButtons_thursday1_Fill_Color,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_disableTripConfigurationButtons_wednesday = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            null, null,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_disableTripConfigurationButtons_wednesday, 0, clickx, clicky );
      }
    };
    rect_disableTripConfigurationButtons_wednesday1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-300.0, -12.0, 0.0, 0.0,
            _rect_disableTripConfigurationButtons_wednesday1_Line_Color, _rect_disableTripConfigurationButtons_wednesday1_Fill_Color,
			600.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_configureVehicleTrips_1 = new ShapeText(
        SHAPE_DRAW_2D, true,-275.0, -15.0, 0.0, 0.0,
        black,"1",
        _txt_configureVehicleTrips_1_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_2 = new ShapeText(
        SHAPE_DRAW_2D, true,-250.0, -15.0, 0.0, 0.0,
        black,"2",
        _txt_configureVehicleTrips_2_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_3 = new ShapeText(
        SHAPE_DRAW_2D, true,-225.0, -15.0, 0.0, 0.0,
        black,"3",
        _txt_configureVehicleTrips_3_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_4 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, -15.0, 0.0, 0.0,
        black,"4",
        _txt_configureVehicleTrips_4_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_5 = new ShapeText(
        SHAPE_DRAW_2D, true,-175.0, -15.0, 0.0, 0.0,
        black,"5",
        _txt_configureVehicleTrips_5_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_6 = new ShapeText(
        SHAPE_DRAW_2D, true,-150.0, -15.0, 0.0, 0.0,
        black,"6",
        _txt_configureVehicleTrips_6_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_7 = new ShapeText(
        SHAPE_DRAW_2D, true,-125.0, -15.0, 0.0, 0.0,
        black,"7",
        _txt_configureVehicleTrips_7_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_8 = new ShapeText(
        SHAPE_DRAW_2D, true,-100.0, -15.0, 0.0, 0.0,
        black,"8",
        _txt_configureVehicleTrips_8_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_9 = new ShapeText(
        SHAPE_DRAW_2D, true,-75.0, -15.0, 0.0, 0.0,
        black,"9",
        _txt_configureVehicleTrips_9_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_10 = new ShapeText(
        SHAPE_DRAW_2D, true,-50.0, -15.0, 0.0, 0.0,
        black,"10",
        _txt_configureVehicleTrips_10_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_11 = new ShapeText(
        SHAPE_DRAW_2D, true,-25.0, -15.0, 0.0, 0.0,
        black,"11",
        _txt_configureVehicleTrips_11_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_12 = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -15.0, 0.0, 0.0,
        black,"12",
        _txt_configureVehicleTrips_12_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_13 = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, -15.0, 0.0, 0.0,
        black,"13",
        _txt_configureVehicleTrips_13_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_14 = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, -15.0, 0.0, 0.0,
        black,"14",
        _txt_configureVehicleTrips_14_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_15 = new ShapeText(
        SHAPE_DRAW_2D, true,75.0, -15.0, 0.0, 0.0,
        black,"15",
        _txt_configureVehicleTrips_15_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_16 = new ShapeText(
        SHAPE_DRAW_2D, true,100.0, -15.0, 0.0, 0.0,
        black,"16",
        _txt_configureVehicleTrips_16_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_17 = new ShapeText(
        SHAPE_DRAW_2D, true,125.0, -15.0, 0.0, 0.0,
        black,"17",
        _txt_configureVehicleTrips_17_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_18 = new ShapeText(
        SHAPE_DRAW_2D, true,150.0, -15.0, 0.0, 0.0,
        black,"18",
        _txt_configureVehicleTrips_18_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_19 = new ShapeText(
        SHAPE_DRAW_2D, true,175.0, -15.0, 0.0, 0.0,
        black,"19",
        _txt_configureVehicleTrips_19_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_20 = new ShapeText(
        SHAPE_DRAW_2D, true,200.0, -15.0, 0.0, 0.0,
        black,"20",
        _txt_configureVehicleTrips_20_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_21 = new ShapeText(
        SHAPE_DRAW_2D, true,225.0, -15.0, 0.0, 0.0,
        black,"21",
        _txt_configureVehicleTrips_21_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_22 = new ShapeText(
        SHAPE_DRAW_2D, true,250.0, -15.0, 0.0, 0.0,
        black,"22",
        _txt_configureVehicleTrips_22_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_23 = new ShapeText(
        SHAPE_DRAW_2D, true,275.0, -15.0, 0.0, 0.0,
        black,"23",
        _txt_configureVehicleTrips_23_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_24 = new ShapeText(
        SHAPE_DRAW_2D, true,300.0, -15.0, 0.0, 0.0,
        black,"24",
        _txt_configureVehicleTrips_24_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_0 = new ShapeText(
        SHAPE_DRAW_2D, true,-300.0, -15.0, 0.0, 0.0,
        black,"0",
        _txt_configureVehicleTrips_0_Font, ALIGNMENT_CENTER );
    txt_configureVehicleTrips_weeklyDistance_unit = new ShapeText(
        SHAPE_DRAW_2D, true,660.0, 75.0, 0.0, 0.0,
        black,"km",
        _txt_configureVehicleTrips_weeklyDistance_unit_Font, ALIGNMENT_LEFT );
    txt_configureVehicleTrips_monday = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, -105.0, 0.0, 0.0,
        black,"Maandag",
        _txt_configureVehicleTrips_monday_Font, ALIGNMENT_LEFT );
    txt_configureVehicleTrips_tuesday = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, -75.0, 0.0, 0.0,
        black,"Dinsdag",
        _txt_configureVehicleTrips_tuesday_Font, ALIGNMENT_LEFT );
    txt_configureVehicleTrips_wednesday = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, -45.0, 0.0, 0.0,
        black,"Woensdag",
        _txt_configureVehicleTrips_wednesday_Font, ALIGNMENT_LEFT );
    txt_configureVehicleTrips_thursday = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, -15.0, 0.0, 0.0,
        black,"Donderdag",
        _txt_configureVehicleTrips_thursday_Font, ALIGNMENT_LEFT );
    txt_configureVehicleTrips_friday = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, 15.0, 0.0, 0.0,
        black,"Vrijdag",
        _txt_configureVehicleTrips_friday_Font, ALIGNMENT_LEFT );
    txt_configureVehicleTrips_saturday = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, 45.0, 0.0, 0.0,
        black,"Zaterdag",
        _txt_configureVehicleTrips_saturday_Font, ALIGNMENT_LEFT );
    txt_configureVehicleTrips_sunday = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, 75.0, 0.0, 0.0,
        black,"Zondag",
        _txt_configureVehicleTrips_sunday_Font, ALIGNMENT_LEFT );
    t_tripConfiguratorExplanation = new ShapeText(
        SHAPE_DRAW_2D, true,190.0, 45.0, 0.0, 0.0,
        black,"Wanneer zijn je voertuigen onderweg?",
        _t_tripConfiguratorExplanation_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_scenarioRB = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 140.0, 100.0, 0.0, 0.0
	
	     , rb_scenariosPrivateUI
	     , txt_scenario );
    }
    {
    gr_heatDemandReductionSlider = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, -120.0, -106.0, 0.0, 0.0
	
	     , sl_heatDemandCompanyReduction
	     , text195
	     , t_heatDemandReductionCompanies );
    }
    {
    gr_companyMobilitySliders = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, -120.0, 360.0, 0.0, 0.0
	
	     , button_openVehicleTripsConfigurationMenu_car
	     , button_openVehicleTripsConfigurationMenu_van
	     , button_openVehicleTripsConfigurationMenu_truck
	     , sl_electricVansCompany
	     , text266
	     , t_numberOfElectricVansCompany
	     , sl_hydrogenVansCompany
	     , text271
	     , t_numberOfHydrogenVansCompany
	     , sl_petroleumFuelVansCompany
	     , text285
	     , t_numberOfPetroleumFuelVansCompany
	     , text274
	     , t_numberOfPetroleumFuelTrucksCompany
	     , t_numberOfHydrogenTrucksCompany
	     , text272
	     , text286
	     , text268
	     , text275
	     , sl_hydrogenTrucksCompany
	     , t_numberOfElectricTrucksCompany
	     , sl_electricTrucksCompany
	     , sl_petroleumFuelTrucksCompany
	     , sl_electricCarsCompany
	     , text265
	     , t_numberOfElectricCarsCompany
	     , text267
	     , sl_mobilityDemandCompanyReduction
	     , t_mobilityDemandReductionCompany
	     , sl_hydrogenCarsCompany
	     , text270
	     , t_numberOfHydrogenCarsCompany
	     , sl_petroleumFuelCarsCompany
	     , text284
	     , t_numberOfPetroleumFuelCarsCompany
	     , text273 );
    }
    {
    gr_selectedGC = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, -60.0, -290.0, 0.0, 0.0
	
	     , cb_selectGC
	     , text9 );
    }
    {
    gr_electricityButton1 = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, -560.0, 42.0, 0.0, 0.0
	
	     , ovalElectricityButton1
	     , image4 );
    }
    {
    gr_heatButton1 = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, -560.0, -160.0, 0.0, 0.0
	
	     , ovalHeatButton1
	     , image11 );
    }
    {
    gr_transportButton1 = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, -560.0, 276.0, 0.0, 0.0
	
	     , ovalTransportButton1
	     , image16 );
    }
    {
    g_energyDemandSettings = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 280.0, -100.0, 0.0, 0.0
	
	     , gr_electricityButton1
	     , gr_heatButton1
	     , gr_transportButton1 );
    }
    {
    gr_companyUISliders = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 310.0, 445.0, 0.0, 0.0
	
	     , txt_warmte
	     , t_GCCapacityCompany
	     , sl_GCCapacityCompany
	     , txt_GCCapacity
	     , gr_heatDemandReductionSlider
	     , txt_elektriciteit
	     , txt_mobiliteit
	     , t_electricityDemandReductionCompany
	     , sl_electricityDemandCompanyReduction
	     , text279
	     , gr_companyMobilitySliders
	     , gr_selectedGC
	     , sl_batteryCompany
	     , t_batteryCompany
	     , text283
	     , g_energyDemandSettings
	     , rb_heatingTypePrivateUI
	     , t_rooftopSolarCompany
	     , sl_rooftopPVCompany
	     , txt_PVPower
	     , t_GCCapacityCompany_Feedin
	     , sl_GCCapacityCompany_Feedin
	     , txt_GCCapacityCompany_Feedin );
    }
    {
    gr_companyDetails = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 1140.0, 80.0, 0.0, 0.0
	
	     , roundRect_companyName
	     , t_companyName
	     , t_GCadress );
    }
    {
    uI_Results_presentation = new ShapeEmbeddedObjectPresentation( UI_company.this, SHAPE_DRAW_2D3D, false, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartNameLeft = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 610.0, 200.0, 0.0, 0.0
	
	     , rect_chartNameLeft
	     , txt_chartNameLeft );
    }
    {
    gr_chartNameMiddle = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 1140.0, 200.0, 0.0, 0.0
	
	     , rect_chartNameMiddle
	     , txt_chartNameMiddle );
    }
    {
    gr_chartNameRight = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 1670.0, 200.0, 0.0, 0.0
	
	     , rect_chartNameRight
	     , txt_chartNameRight );
    }
    {
    gr_simulateYearToCalculateKPIs = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, -35.0, 40.0, 0.0, 0.0
	
	     , t_simulateYearToCalculateCostsSmall
	     , image_simulateYearToCalculateCostsSmall ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_simulateYearToCalculateKPIs, 0, clickx, clicky );
      }
    };
    }
    {
    gr_simulateYearScreen = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 1375.0, 540.0, 0.0, 0.0
	
	     , rect_simulateYearScreen2
	     , gr_simulateYearToCalculateKPIs );
    }
    gr_simulateYearScreen.setVisible( false );
    {
    gr_loadIconText = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, -1220.0, 280.0, 0.0, 0.0
	
	     , image_loadIconSmall
	     , t_loadIconSmall );
    }
    {
    gr_loadIcon = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 2360.0, 280.0, 0.0, 0.0
	
	     , rect_loadIcon
	     , rect_GCisPausedScreen3
	     , gr_loadIconText );
    }
    gr_loadIcon.setVisible( false );
    {
    gr_table_nfato = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 225.0, 0.0, 0.0, 0.0
	
	     , rect_Table_NFATO
	     , txt_table_ConnectionCapacityInfo_nfato
	     , t_GCCapacityCompany_delivery_nfato
	     , t_GCCapacityCompany_Feedin_nfato
	     , t_GCCapacityCompany_physical_nfato
	     , line_table_ConnectionCapacityInfo_NFATO ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_table_nfato_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_TableConnectionCapacity = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 565.0, 80.0, 0.0, 0.0
	
	     , rect_table_GridconnectionCapacaties
	     , txt_additionalGCCapacityInfo
	     , text1
	     , text2
	     , text3
	     , t_GCCapacityCompany_delivery2
	     , t_GCCapacityCompany_Feedin_2
	     , t_GCCapacityCompany_physical
	     , line_table_ConnectionCapacityInfo_1
	     , txt_table_ConnectionCapacityInfo_owned
	     , line_table_ConnectionCapacityInfo_3
	     , gr_table_nfato
	     , line_table_ConnectionCapacityInfo_2
	     , txt_table_ConnectionCapacityInfo_known
	     , t_GCCapacityCompany_delivery3
	     , t_GCCapacityCompany_Feedin_3
	     , t_GCCapacityCompany_physical1 );
    }
    {
    gr_GCisPausedScreenText = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, -35.0, 40.0, 0.0, 0.0
	
	     , t_GCisPausedScreen
	     , image_simulateYearToCalculateCostsSmall1 ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_GCisPausedScreenText, 0, clickx, clicky );
      }
    };
    }
    {
    gr_GCisPausedScreen = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 4480.0, 920.0, 0.0, 0.0
	
	     , rect_GCisPausedScreen
	     , rect_GCisPausedScreen2
	     , gr_GCisPausedScreenText
	     , txt_GCisPaused ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_GCisPausedScreen_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_GCisPausedScreen.setVisible( false );
    {
    button_errorOK = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 0.0, 50.0, 0.0, 0.0
	
	     , rect_errorOK
	     , txt_errorOK ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _button_errorOK, 0, clickx, clicky );
      }
    };
    }
    {
    gr_errorScreen = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 6480.0, 600.0, 0.0, 0.0
	
	     , rect_errorScreenGrayOut
	     , rect_errorScreenClickBlocking
	     , rect_errorMessage
	     , t_errorMessage
	     , button_errorOK ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_errorScreen_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_errorScreen.setVisible( false );
    {
    gr_configureVehicleTrips_weekButtons = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 430.0, 250.0, 0.0, 0.0
	
	     , rect_configureVehicleTrips_monday_0
	     , rect_configureVehicleTrips_monday_1
	     , rect_configureVehicleTrips_monday_2
	     , rect_configureVehicleTrips_monday_3
	     , rect_configureVehicleTrips_monday_4
	     , rect_configureVehicleTrips_monday_5
	     , rect_configureVehicleTrips_monday_6
	     , rect_configureVehicleTrips_monday_7
	     , rect_configureVehicleTrips_monday_8
	     , rect_configureVehicleTrips_monday_9
	     , rect_configureVehicleTrips_monday_10
	     , rect_configureVehicleTrips_monday_11
	     , rect_configureVehicleTrips_monday_12
	     , rect_configureVehicleTrips_monday_13
	     , rect_configureVehicleTrips_monday_14
	     , rect_configureVehicleTrips_monday_15
	     , rect_configureVehicleTrips_monday_16
	     , rect_configureVehicleTrips_monday_17
	     , rect_configureVehicleTrips_monday_18
	     , rect_configureVehicleTrips_monday_19
	     , rect_configureVehicleTrips_monday_20
	     , rect_configureVehicleTrips_monday_21
	     , rect_configureVehicleTrips_monday_22
	     , rect_configureVehicleTrips_monday_23
	     , rect_configureVehicleTrips_tuesday_0
	     , rect_configureVehicleTrips_wednesday_0
	     , rect_configureVehicleTrips_thursday_0
	     , rect_configureVehicleTrips_friday_0
	     , rect_configureVehicleTrips_saturday_0
	     , rect_configureVehicleTrips_sunday_0
	     , rect_configureVehicleTrips_wednesday_1
	     , rect_configureVehicleTrips_thursday_1
	     , rect_configureVehicleTrips_tuesday_1
	     , rect_configureVehicleTrips_sunday_1
	     , rect_configureVehicleTrips_friday_1
	     , rect_configureVehicleTrips_saturday_1
	     , rect_configureVehicleTrips_wednesday_2
	     , rect_configureVehicleTrips_thursday_2
	     , rect_configureVehicleTrips_tuesday_2
	     , rect_configureVehicleTrips_sunday_2
	     , rect_configureVehicleTrips_friday_2
	     , rect_configureVehicleTrips_saturday_2
	     , rect_configureVehicleTrips_wednesday_3
	     , rect_configureVehicleTrips_thursday_3
	     , rect_configureVehicleTrips_tuesday_3
	     , rect_configureVehicleTrips_sunday_3
	     , rect_configureVehicleTrips_friday_3
	     , rect_configureVehicleTrips_saturday_3
	     , rect_configureVehicleTrips_friday_4
	     , rect_configureVehicleTrips_sunday_4
	     , rect_configureVehicleTrips_tuesday_4
	     , rect_configureVehicleTrips_saturday_4
	     , rect_configureVehicleTrips_thursday_4
	     , rect_configureVehicleTrips_wednesday_4
	     , rect_configureVehicleTrips_friday_5
	     , rect_configureVehicleTrips_sunday_5
	     , rect_configureVehicleTrips_tuesday_5
	     , rect_configureVehicleTrips_saturday_5
	     , rect_configureVehicleTrips_thursday_5
	     , rect_configureVehicleTrips_wednesday_5
	     , rect_configureVehicleTrips_friday_6
	     , rect_configureVehicleTrips_sunday_6
	     , rect_configureVehicleTrips_tuesday_6
	     , rect_configureVehicleTrips_saturday_6
	     , rect_configureVehicleTrips_thursday_6
	     , rect_configureVehicleTrips_wednesday_6
	     , rect_configureVehicleTrips_friday_7
	     , rect_configureVehicleTrips_sunday_7
	     , rect_configureVehicleTrips_tuesday_7
	     , rect_configureVehicleTrips_saturday_7
	     , rect_configureVehicleTrips_thursday_7
	     , rect_configureVehicleTrips_wednesday_7
	     , rect_configureVehicleTrips_friday_8
	     , rect_configureVehicleTrips_sunday_8
	     , rect_configureVehicleTrips_tuesday_8
	     , rect_configureVehicleTrips_saturday_8
	     , rect_configureVehicleTrips_thursday_8
	     , rect_configureVehicleTrips_wednesday_8
	     , rect_configureVehicleTrips_friday_9
	     , rect_configureVehicleTrips_sunday_9
	     , rect_configureVehicleTrips_tuesday_9
	     , rect_configureVehicleTrips_saturday_9
	     , rect_configureVehicleTrips_thursday_9
	     , rect_configureVehicleTrips_wednesday_9
	     , rect_configureVehicleTrips_friday_10
	     , rect_configureVehicleTrips_sunday_10
	     , rect_configureVehicleTrips_tuesday_10
	     , rect_configureVehicleTrips_saturday_10
	     , rect_configureVehicleTrips_thursday_10
	     , rect_configureVehicleTrips_wednesday_10
	     , rect_configureVehicleTrips_friday_11
	     , rect_configureVehicleTrips_sunday_11
	     , rect_configureVehicleTrips_tuesday_11
	     , rect_configureVehicleTrips_saturday_11
	     , rect_configureVehicleTrips_thursday_11
	     , rect_configureVehicleTrips_wednesday_11
	     , rect_configureVehicleTrips_friday_12
	     , rect_configureVehicleTrips_sunday_12
	     , rect_configureVehicleTrips_tuesday_12
	     , rect_configureVehicleTrips_saturday_12
	     , rect_configureVehicleTrips_thursday_12
	     , rect_configureVehicleTrips_wednesday_12
	     , rect_configureVehicleTrips_friday_13
	     , rect_configureVehicleTrips_sunday_13
	     , rect_configureVehicleTrips_tuesday_13
	     , rect_configureVehicleTrips_saturday_13
	     , rect_configureVehicleTrips_thursday_13
	     , rect_configureVehicleTrips_wednesday_13
	     , rect_configureVehicleTrips_friday_14
	     , rect_configureVehicleTrips_sunday_14
	     , rect_configureVehicleTrips_tuesday_14
	     , rect_configureVehicleTrips_saturday_14
	     , rect_configureVehicleTrips_thursday_14
	     , rect_configureVehicleTrips_wednesday_14
	     , rect_configureVehicleTrips_friday_15
	     , rect_configureVehicleTrips_sunday_15
	     , rect_configureVehicleTrips_tuesday_15
	     , rect_configureVehicleTrips_saturday_15
	     , rect_configureVehicleTrips_thursday_15
	     , rect_configureVehicleTrips_wednesday_15
	     , rect_configureVehicleTrips_friday_16
	     , rect_configureVehicleTrips_sunday_16
	     , rect_configureVehicleTrips_tuesday_16
	     , rect_configureVehicleTrips_saturday_16
	     , rect_configureVehicleTrips_thursday_16
	     , rect_configureVehicleTrips_wednesday_16
	     , rect_configureVehicleTrips_friday_17
	     , rect_configureVehicleTrips_sunday_17
	     , rect_configureVehicleTrips_tuesday_17
	     , rect_configureVehicleTrips_saturday_17
	     , rect_configureVehicleTrips_thursday_17
	     , rect_configureVehicleTrips_wednesday_17
	     , rect_configureVehicleTrips_friday_18
	     , rect_configureVehicleTrips_sunday_18
	     , rect_configureVehicleTrips_tuesday_18
	     , rect_configureVehicleTrips_saturday_18
	     , rect_configureVehicleTrips_thursday_18
	     , rect_configureVehicleTrips_wednesday_18
	     , rect_configureVehicleTrips_friday_19
	     , rect_configureVehicleTrips_sunday_19
	     , rect_configureVehicleTrips_tuesday_19
	     , rect_configureVehicleTrips_saturday_19
	     , rect_configureVehicleTrips_thursday_19
	     , rect_configureVehicleTrips_wednesday_19
	     , rect_configureVehicleTrips_friday_20
	     , rect_configureVehicleTrips_sunday_20
	     , rect_configureVehicleTrips_tuesday_20
	     , rect_configureVehicleTrips_saturday_20
	     , rect_configureVehicleTrips_thursday_20
	     , rect_configureVehicleTrips_wednesday_20
	     , rect_configureVehicleTrips_friday_21
	     , rect_configureVehicleTrips_sunday_21
	     , rect_configureVehicleTrips_tuesday_21
	     , rect_configureVehicleTrips_saturday_21
	     , rect_configureVehicleTrips_thursday_21
	     , rect_configureVehicleTrips_wednesday_21
	     , rect_configureVehicleTrips_friday_22
	     , rect_configureVehicleTrips_sunday_22
	     , rect_configureVehicleTrips_tuesday_22
	     , rect_configureVehicleTrips_saturday_22
	     , rect_configureVehicleTrips_thursday_22
	     , rect_configureVehicleTrips_wednesday_22
	     , rect_configureVehicleTrips_friday_23
	     , rect_configureVehicleTrips_sunday_23
	     , rect_configureVehicleTrips_tuesday_23
	     , rect_configureVehicleTrips_saturday_23
	     , rect_configureVehicleTrips_thursday_23
	     , rect_configureVehicleTrips_wednesday_23 );
    }
    {
    gr_disableTripConfigurationButtons_monday = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 0.0, -95.0, 0.0, 0.0
	
	     , rect_disableTripConfigurationButtons_monday
	     , rect_disableTripConfigurationButtons_monday1 );
    }
    {
    gr_disableTripConfigurationButtons_tuesday = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 0.0, -65.0, 0.0, 0.0
	
	     , rect_disableTripConfigurationButtons_tuesday
	     , rect_disableTripConfigurationButtons_tuesday1 );
    }
    {
    gr_disableTripConfigurationButtons_sunday = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 0.0, 85.0, 0.0, 0.0
	
	     , rect_disableTripConfigurationButtons_sunday
	     , rect_disableTripConfigurationButtons_sunday1 );
    }
    {
    gr_disableTripConfigurationButtons_saturday = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 0.0, 55.0, 0.0, 0.0
	
	     , rect_disableTripConfigurationButtons_saturday
	     , rect_disableTripConfigurationButtons_saturday1 );
    }
    {
    gr_disableTripConfigurationButtons_friday = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 0.0, 25.0, 0.0, 0.0
	
	     , rect_disableTripConfigurationButtons_friday
	     , rect_disableTripConfigurationButtons_friday1 );
    }
    {
    gr_disableTripConfigurationButtons_thursday = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 0.0, -5.0, 0.0, 0.0
	
	     , rect_disableTripConfigurationButtons_thursday
	     , rect_disableTripConfigurationButtons_thursday1 );
    }
    {
    gr_disableTripConfigurationButtons_wednesday = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 0.0, -35.0, 0.0, 0.0
	
	     , rect_disableTripConfigurationButtons_wednesday
	     , rect_disableTripConfigurationButtons_wednesday1 );
    }
    {
    gr_tripConfigurationDisableRectangles = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, 430.0, 250.0, 0.0, 0.0
	
	     , gr_disableTripConfigurationButtons_monday
	     , gr_disableTripConfigurationButtons_tuesday
	     , gr_disableTripConfigurationButtons_sunday
	     , gr_disableTripConfigurationButtons_saturday
	     , gr_disableTripConfigurationButtons_friday
	     , gr_disableTripConfigurationButtons_thursday
	     , gr_disableTripConfigurationButtons_wednesday );
    }
    {
    gr_configureVehicleTripsNumbers = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D, true, 430.0, 140.0, 0.0, 0.0
	
	     , txt_configureVehicleTrips_1
	     , txt_configureVehicleTrips_2
	     , txt_configureVehicleTrips_3
	     , txt_configureVehicleTrips_4
	     , txt_configureVehicleTrips_5
	     , txt_configureVehicleTrips_6
	     , txt_configureVehicleTrips_7
	     , txt_configureVehicleTrips_8
	     , txt_configureVehicleTrips_9
	     , txt_configureVehicleTrips_10
	     , txt_configureVehicleTrips_11
	     , txt_configureVehicleTrips_12
	     , txt_configureVehicleTrips_13
	     , txt_configureVehicleTrips_14
	     , txt_configureVehicleTrips_15
	     , txt_configureVehicleTrips_16
	     , txt_configureVehicleTrips_17
	     , txt_configureVehicleTrips_18
	     , txt_configureVehicleTrips_19
	     , txt_configureVehicleTrips_20
	     , txt_configureVehicleTrips_21
	     , txt_configureVehicleTrips_22
	     , txt_configureVehicleTrips_23
	     , txt_configureVehicleTrips_24
	     , txt_configureVehicleTrips_0 );
    }
    {
    gr_vehicleTripConfiguratorWeekdays = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D, true, 60.0, 250.0, 0.0, 0.0
	
	     , txt_configureVehicleTrips_monday
	     , txt_configureVehicleTrips_tuesday
	     , txt_configureVehicleTrips_wednesday
	     , txt_configureVehicleTrips_thursday
	     , txt_configureVehicleTrips_friday
	     , txt_configureVehicleTrips_saturday
	     , txt_configureVehicleTrips_sunday );
    }
    {
    gr_configureVehicleTrips = new ShapeGroup( UI_company.this, SHAPE_DRAW_2D3D, true, -550.0, 1500.0, 0.0, 0.0
	
	     , rect_configureVehicleTripsBackground
	     , gr_configureVehicleTrips_weekButtons
	     , cb_configureVehicleTrips_dailyDistinction
	     , button_confirm_configureVehicleTrips
	     , button_cancel_configureVehicleTrips
	     , t_configureVehicleTrips_km
	     , cb_configureVehicleTripsMonday
	     , cb_configureVehicleTripsTuesday
	     , cb_configureVehicleTripsWednesday
	     , cb_configureVehicleTripsThursday
	     , cb_configureVehicleTripsFriday
	     , cb_configureVehicleTripsSaturday
	     , cb_configureVehicleTripsSunday
	     , button_configureVehicleTrips_reset
	     , gr_tripConfigurationDisableRectangles
	     , gr_configureVehicleTripsNumbers
	     , eb_configureVehicleTrips_weeklyDistance_km
	     , txt_configureVehicleTrips_weeklyDistance_unit
	     , gr_vehicleTripConfiguratorWeekdays
	     , t_tripConfiguratorExplanation ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_configureVehicleTrips_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_configureVehicleTrips.setVisible( false );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
    uI_Results_presentation.setEmbeddedObject_xjal( uI_Results );
    uI_Results_presentation.setEmbeddedObject_xjal( uI_Results );
  }



  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
    _createPersistentElementsBP0_xjal();
    _createPersistentElementsBP1_xjal();
    _createPersistentElementsBP2_xjal();
    _createPersistentElementsBP3_xjal();
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

	


  /**
   * Constructor
   */
  public UI_company( Engine engine, Agent owner, AgentList<? extends UI_company> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
    uI_Results = instantiate_uI_Results_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    zero_Interface = get_Zero_Interface();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public UI_company() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public UI_company( String p_companyName, int p_maxAddedVehicles, J_scenario_Current p_scenarioSettings_Current, J_scenario_Future p_scenarioSettings_Future, GridConnection p_gridConnection, double p_maxSavingsSliders_default, double p_minSavingsSliders_default, ShapeRectangle[][] matrix_vehicleTripsConfigurationButtons, Map<String, Map<J_ActivityTrackerTrips, J_ActivityTrackerTrips>> map_customTripTrackerToOriginal, Map<String, Map<OL_VehicleType, J_CustomTripTrackerGenerator.StoredTripConfiguration>> map_storedCustomTripButtonConfiguration, boolean[][] matrix_defaultValuesCustomTripButtons, Map<OL_Days, ShapeCheckBox> map_dayToEnableDayButtons, Color p_configureVehicleTripsOnColor, Color p_configureVehicleTripsOffColor, Map<OL_Days, ShapeGroup> map_dayToDisableRectangles, Map<String, Map<OL_VehicleType, List<J_ActivityTrackerTrips.TripRecord>>> map_createdCustomTripWeeklyConfiguration, double p_defaultTravelDistance_km ) {
    markParametersAreSet();
    this.p_companyName = p_companyName;
    this.p_maxAddedVehicles = p_maxAddedVehicles;
    this.p_scenarioSettings_Current = p_scenarioSettings_Current;
    this.p_scenarioSettings_Future = p_scenarioSettings_Future;
    this.p_gridConnection = p_gridConnection;
    this.p_maxSavingsSliders_default = p_maxSavingsSliders_default;
    this.p_minSavingsSliders_default = p_minSavingsSliders_default;
    this.matrix_vehicleTripsConfigurationButtons = matrix_vehicleTripsConfigurationButtons;
    this.map_customTripTrackerToOriginal = map_customTripTrackerToOriginal;
    this.map_storedCustomTripButtonConfiguration = map_storedCustomTripButtonConfiguration;
    this.matrix_defaultValuesCustomTripButtons = matrix_defaultValuesCustomTripButtons;
    this.map_dayToEnableDayButtons = map_dayToEnableDayButtons;
    this.p_configureVehicleTripsOnColor = p_configureVehicleTripsOnColor;
    this.p_configureVehicleTripsOffColor = p_configureVehicleTripsOffColor;
    this.map_dayToDisableRectangles = map_dayToDisableRectangles;
    this.map_createdCustomTripWeeklyConfiguration = map_createdCustomTripWeeklyConfiguration;
    this.p_defaultTravelDistance_km = p_defaultTravelDistance_km;
  }

  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_UI_company_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( UI_company.this, true, 0, 0, 0, 0 , level );
		presentation.getConfiguration3D().setEnvironmentRotationX(0.0f);
		presentation.getConfiguration3D().setEnvironmentRotationY(0.0f);
		presentation.getConfiguration3D().setEnvironmentRotationZ(0.0f);
		presentation.getConfiguration3D().setEnvironmentIntensity(1.0d);
		presentation.getConfiguration3D().setUseEnvironmentForBackground(true);
		presentation.getConfiguration3D().setUseEnvironmentForLightning(true);
        presentation.getConfiguration3D().setSkybox(SkyboxType.NONE);
    presentation.getConfiguration3D().setBackgroundColor( silver );
    addAll( c_activeVehicleConfigurationDays, new OL_Days[] 
{
	OL_Days.MONDAY,
	OL_Days.TUESDAY,
	OL_Days.WEDNESDAY,
	OL_Days.THURSDAY,
	OL_Days.FRIDAY,
	OL_Days.SATURDAY,
	OL_Days.SUNDAY
} 
    );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( UI_company.this, getElementProperty( "zerointerfaceloader.UI_company.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );


    // Space setup
    {
      double _x_xjal = 
500 
;
      double _y_xjal = 
500 
;
      double _z_xjal = 
0 
;
      setupSpace( _x_xjal, _y_xjal, _z_xjal );
    }
    disableSteps();
    setNetworkUserDefined();
    setLayoutType( LAYOUT_USER_DEFINED );
    // Creating non-replicated embedded objects
    setupParameters_uI_Results_xjal( uI_Results, null );
    doBeforeCreate_uI_Results_xjal( uI_Results, null );
    uI_Results.createAsEmbedded();
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( UI_company.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    rb_scenariosPrivateUI.setValueToDefault();
    sl_GCCapacityCompany.setValueToDefault();
    sl_heatDemandCompanyReduction.setValueToDefault();
    sl_electricityDemandCompanyReduction.setValueToDefault();
    sl_electricVansCompany.setValueToDefault();
    sl_hydrogenVansCompany.setValueToDefault();
    sl_petroleumFuelVansCompany.setValueToDefault();
    sl_hydrogenTrucksCompany.setValueToDefault();
    sl_electricTrucksCompany.setValueToDefault();
    sl_petroleumFuelTrucksCompany.setValueToDefault();
    sl_electricCarsCompany.setValueToDefault();
    sl_mobilityDemandCompanyReduction.setValueToDefault();
    sl_hydrogenCarsCompany.setValueToDefault();
    sl_petroleumFuelCarsCompany.setValueToDefault();
    sl_batteryCompany.setValueToDefault();
    rb_heatingTypePrivateUI.setValueToDefault();
    sl_rooftopPVCompany.setValueToDefault();
    sl_GCCapacityCompany_Feedin.setValueToDefault();
    cb_configureVehicleTrips_dailyDistinction.setValueToDefault();
    cb_configureVehicleTripsMonday.setValueToDefault();
    cb_configureVehicleTripsTuesday.setValueToDefault();
    cb_configureVehicleTripsWednesday.setValueToDefault();
    cb_configureVehicleTripsThursday.setValueToDefault();
    cb_configureVehicleTripsFriday.setValueToDefault();
    cb_configureVehicleTripsSaturday.setValueToDefault();
    cb_configureVehicleTripsSunday.setValueToDefault();
    eb_configureVehicleTrips_weeklyDistance_km.setValueToDefault();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    uI_Results.startAsEmbedded();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

//Initialize graph locations and visibility
f_setResultsUIPresets();

zero_Interface.c_UIResultsInstances.add(uI_Results);

f_initializeDayToDisableRectanglesMap(); 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_UI_company_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_UI_company_xjal() {
    v_companyUIBackgroundColor = 
new Color(95, 188, 191); 
;
    v_companyUILineColor = 
new Color(0, 126, 132) 
;
    v_minPVSlider = 
0 
;
    v_maxPVSlider = 
100 
;
    v_defaultPVSlider = 
0 
;
    v_minBatSlider = 
0 
;
    v_maxBatSlider = 
1000 
;
    v_defaultBatSlider = 
0 
;
    v_nbEVCars = 
0 
;
    v_nbHydrogenCars = 
0 
;
    v_nbPetroleumFuelCars = 
0 
;
    v_nbEVVans = 
0 
;
    v_nbEVTrucks = 
0 
;
    v_nbPetroleumFuelVans = 
0 
;
    v_nbPetroleumFuelTrucks = 
0 
;
    v_nbHydrogenVans = 
0 
;
    v_nbHydrogenTrucks = 
0 
;
    v_minEVCarSlider = 
0 
;
    v_minHydrogenCarSlider = 
0 
;
    v_maxEVCarSlider = 
20 
;
    v_minPetroleumFuelCarSlider = 
0 
;
    v_maxHydrogenCarSlider = 
20 
;
    v_maxPetroleumFuelCarSlider = 
20 
;
    v_minEVVanSlider = 
0 
;
    v_minHydrogenVanSlider = 
0 
;
    v_maxEVVanSlider = 
20 
;
    v_minPetroleumFuelVanSlider = 
0 
;
    v_maxHydrogenVanSlider = 
20 
;
    v_maxPetroleumFuelVanSlider = 
20 
;
    v_minEVTruckSlider = 
0 
;
    v_minHydrogenTruckSlider = 
0 
;
    v_maxEVTruckSlider = 
20 
;
    v_minPetroleumFuelTruckSlider = 
0 
;
    v_maxPetroleumFuelTruckSlider = 
20 
;
    v_maxHydrogenTruckSlider = 
20 
;
    v_chartBackgroundColor = 
white 
;
    v_companyUILineWidth = 
2 
;
    v_chartLineWidth = 
2 
;
    v_companyUIBackgroundColorSliders = 
white 
;
    v_loadScreenColor = 
v_companyUIBackgroundColor 
;
    v_minContractDeliveryCapacity_kW = 
0 
;
    v_maxContractDeliveryCapacity_kW = 
100 
;
    v_defaultContractDeliveryCapacity_kW = 
0 
;
    b_runningMainInterfaceScenarioSettings = 
false 
;
    v_minContractFeedinCapacity_kW = 
0 
;
    v_maxContractFeedinCapacity_kW = 
100 
;
    v_defaultContractFeedinCapacity_kW = 
0 
;
    b_runningMainInterfaceSlider = 
false 
;
    v_minSavingsSliders = 
-50 
;
    v_maxSavingsSliders = 
50 
;
  }

  // User API -----------------------------------------------------
  public Zero_Interface get_Zero_Interface() {
    {
      Agent owner = getOwner();
      if ( owner instanceof Zero_Interface ) return (Zero_Interface) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zerointerfaceloader.Zero_Interface zero_Interface;

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<>();
    }
    list.add( uI_Results );
    return list;
  }

  public AgentList<? extends UI_company> getPopulation() {
    return (AgentList<? extends UI_company>) super.getPopulation();
  }

  public List<? extends UI_company> agentsInRange( double distance ) {
    return (List<? extends UI_company>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    uI_Results.onDestroy();
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    uI_Results.doFinish();
  }

  // Additional class code


//Getters for shapes
public ShapeRadioButtonGroup getRb_scenariosPrivateUI() {
	return this.rb_scenariosPrivateUI;
}

public ShapeRadioButtonGroup getRb_heatingTypePrivateUI() {
	return this.rb_heatingTypePrivateUI;
}

public ShapeSlider getSl_batteryCompany(){
	return this.sl_batteryCompany;
}

public ShapeSlider getSl_heatDemandCompanyReduction(){
	return this.sl_heatDemandCompanyReduction;
}

public ShapeSlider getSl_electricityDemandCompanyReduction(){
	return this.sl_electricityDemandCompanyReduction;
}

public ShapeSlider getSl_mobilityDemandCompanyReduction(){
	return this.sl_mobilityDemandCompanyReduction;
}

public ShapeSlider getSl_hydrogenTrucksCompany(){
	return this.sl_hydrogenTrucksCompany;
} 
  // End of additional class code

}
