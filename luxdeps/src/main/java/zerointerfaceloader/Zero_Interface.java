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

import java.io.FileOutputStream;
import java.util.stream.Stream;
import java.util.Dictionary.*;
import java.util.Hashtable.*;
import java.util.*;
import java.util.stream.Collectors;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;  
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Instant;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

//Possibility to turn of traceln
import java.io.OutputStream;
import java.io.PrintStream;

//Curves
import com.anylogic.engine.markup.AbstractCurve;
import com.anylogic.engine.markup.GISMarkupSegment;
import com.anylogic.engine.markup.GISPoint;
//import zero_engine.OL_EnergyCarriers;
//import zero_engine.OL_EnergyCarriers;
import com.querydsl.core.types.dsl.TimeExpression;
//import zero_engine.J_EAStorageElectric;
//import zero_engine.J_EAConsumption;
import org.apache.commons.lang3.tuple.Triple;
import javax.media.jai.widget.ViewportListener;
 

public class Zero_Interface extends Agent
{
  // Excel Files

  // Parameters

  public 
EnergyModel  energyModel;

  /**
   * Returns default value for parameter <code>energyModel</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public EnergyModel _energyModel_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_energyModel( EnergyModel value ) {
    if (value == this.energyModel) {
      return;
    }
    EnergyModel _oldValue_xjal = this.energyModel;
    this.energyModel = value;
    onChange_energyModel_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter energyModel.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_energyModel()</code> method instead.
   */
  protected void onChange_energyModel() {
    onChange_energyModel_xjal( energyModel );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_energyModel_xjal( EnergyModel oldValue ) {
	int index;
    {
      digital_twin_results.UI_Results self = uI_Results;
      EnergyModel _value;
      _value = energyModel
;
      uI_Results.set_energyModel( _value );
    }  
  }


  public 
Settings  settings;

  /**
   * Returns default value for parameter <code>settings</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Settings _settings_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_settings( Settings value ) {
    if (value == this.settings) {
      return;
    }
    Settings _oldValue_xjal = this.settings;
    this.settings = value;
    onChange_settings_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter settings.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_settings()</code> method instead.
   */
  protected void onChange_settings() {
    onChange_settings_xjal( settings );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_settings_xjal( Settings oldValue ) {  
  }


  public 
List<ShapeImage>  p_currentActiveInfoBubble;

  /**
   * Returns default value for parameter <code>p_currentActiveInfoBubble</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public List<ShapeImage> _p_currentActiveInfoBubble_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
new ArrayList<ShapeImage>() 
;
  }

  public void set_p_currentActiveInfoBubble( List<ShapeImage> value ) {
    if (value == this.p_currentActiveInfoBubble) {
      return;
    }
    List<ShapeImage> _oldValue_xjal = this.p_currentActiveInfoBubble;
    this.p_currentActiveInfoBubble = value;
    onChange_p_currentActiveInfoBubble_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_currentActiveInfoBubble.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_currentActiveInfoBubble()</code> method instead.
   */
  protected void onChange_p_currentActiveInfoBubble() {
    onChange_p_currentActiveInfoBubble_xjal( p_currentActiveInfoBubble );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_currentActiveInfoBubble_xjal( List<ShapeImage> oldValue ) {
	int index;
    {
      digital_twin_results.UI_Results self = uI_Results;
      List<ShapeImage> _value;
      _value = p_currentActiveInfoBubble
;
      uI_Results.set_p_currentActiveInfoBubble( _value );
    }  
  }


  public 
int  p_minSelectedGCForPublicAggregation;

  /**
   * Returns default value for parameter <code>p_minSelectedGCForPublicAggregation</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _p_minSelectedGCForPublicAggregation_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
10 
;
  }

  public void set_p_minSelectedGCForPublicAggregation( int value ) {
    if (value == this.p_minSelectedGCForPublicAggregation) {
      return;
    }
    int _oldValue_xjal = this.p_minSelectedGCForPublicAggregation;
    this.p_minSelectedGCForPublicAggregation = value;
    onChange_p_minSelectedGCForPublicAggregation_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_minSelectedGCForPublicAggregation.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_minSelectedGCForPublicAggregation()</code> method instead.
   */
  protected void onChange_p_minSelectedGCForPublicAggregation() {
    onChange_p_minSelectedGCForPublicAggregation_xjal( p_minSelectedGCForPublicAggregation );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_minSelectedGCForPublicAggregation_xjal( int oldValue ) {  
  }


  public 
boolean  b_inEnergyHubSelectionMode;

  /**
   * Returns default value for parameter <code>b_inEnergyHubSelectionMode</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_inEnergyHubSelectionMode_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
false 
;
  }

  public void set_b_inEnergyHubSelectionMode( boolean value ) {
    if (value == this.b_inEnergyHubSelectionMode) {
      return;
    }
    boolean _oldValue_xjal = this.b_inEnergyHubSelectionMode;
    this.b_inEnergyHubSelectionMode = value;
    onChange_b_inEnergyHubSelectionMode_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_inEnergyHubSelectionMode.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_inEnergyHubSelectionMode()</code> method instead.
   */
  protected void onChange_b_inEnergyHubSelectionMode() {
    onChange_b_inEnergyHubSelectionMode_xjal( b_inEnergyHubSelectionMode );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_inEnergyHubSelectionMode_xjal( boolean oldValue ) {  
  }


  public 
boolean  b_inEnergyHubMode;

  /**
   * Returns default value for parameter <code>b_inEnergyHubMode</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_inEnergyHubMode_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
false 
;
  }

  public void set_b_inEnergyHubMode( boolean value ) {
    if (value == this.b_inEnergyHubMode) {
      return;
    }
    boolean _oldValue_xjal = this.b_inEnergyHubMode;
    this.b_inEnergyHubMode = value;
    onChange_b_inEnergyHubMode_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_inEnergyHubMode.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_inEnergyHubMode()</code> method instead.
   */
  protected void onChange_b_inEnergyHubMode() {
    onChange_b_inEnergyHubMode_xjal( b_inEnergyHubMode );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_inEnergyHubMode_xjal( boolean oldValue ) {  
  }


  public 
User  user;

  /**
   * Returns default value for parameter <code>user</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public User _user_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_user( User value ) {
    if (value == this.user) {
      return;
    }
    User _oldValue_xjal = this.user;
    this.user = value;
    onChange_user_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter user.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_user()</code> method instead.
   */
  protected void onChange_user() {
    onChange_user_xjal( user );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_user_xjal( User oldValue ) {  
  }


  /**
   * Should be filled with the Project_data record created in the startup of the project model
   */
  public 
Project_data  project_data;

  /**
   * Returns default value for parameter <code>project_data</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Project_data _project_data_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_project_data( Project_data value ) {
    if (value == this.project_data) {
      return;
    }
    Project_data _oldValue_xjal = this.project_data;
    this.project_data = value;
    onChange_project_data_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter project_data.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_project_data()</code> method instead.
   */
  protected void onChange_project_data() {
    onChange_project_data_xjal( project_data );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_project_data_xjal( Project_data oldValue ) {  
  }


  public 
UI_company  uI_Company;

  /**
   * Returns default value for parameter <code>uI_Company</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public UI_company _uI_Company_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_uI_Company( UI_company value ) {
    if (value == this.uI_Company) {
      return;
    }
    UI_company _oldValue_xjal = this.uI_Company;
    this.uI_Company = value;
    onChange_uI_Company_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter uI_Company.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_uI_Company()</code> method instead.
   */
  protected void onChange_uI_Company() {
    onChange_uI_Company_xjal( uI_Company );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_uI_Company_xjal( UI_company oldValue ) {  
  }


  public 
UI_EnergyHub  uI_EnergyHub;

  /**
   * Returns default value for parameter <code>uI_EnergyHub</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public UI_EnergyHub _uI_EnergyHub_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_uI_EnergyHub( UI_EnergyHub value ) {
    if (value == this.uI_EnergyHub) {
      return;
    }
    UI_EnergyHub _oldValue_xjal = this.uI_EnergyHub;
    this.uI_EnergyHub = value;
    onChange_uI_EnergyHub_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter uI_EnergyHub.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_uI_EnergyHub()</code> method instead.
   */
  protected void onChange_uI_EnergyHub() {
    onChange_uI_EnergyHub_xjal( uI_EnergyHub );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_uI_EnergyHub_xjal( UI_EnergyHub oldValue ) {  
  }


  public 
ShapeRadioButtonGroup  rb_scenarios;

  /**
   * Returns default value for parameter <code>rb_scenarios</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ShapeRadioButtonGroup _rb_scenarios_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_rb_scenarios( ShapeRadioButtonGroup value ) {
    if (value == this.rb_scenarios) {
      return;
    }
    ShapeRadioButtonGroup _oldValue_xjal = this.rb_scenarios;
    this.rb_scenarios = value;
    onChange_rb_scenarios_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter rb_scenarios.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_rb_scenarios()</code> method instead.
   */
  protected void onChange_rb_scenarios() {
    onChange_rb_scenarios_xjal( rb_scenarios );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_rb_scenarios_xjal( ShapeRadioButtonGroup oldValue ) {  
  }


  public 
String  t_scenario_current;

  /**
   * Returns default value for parameter <code>t_scenario_current</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _t_scenario_current_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
"Het huidige scenario bevat de energie dynamieken van dit moment. \n" +
"Dit omvat o.a. de huidige zonnepanelen, het aantal elektrische \n" +
"voertuigen in per buurt, de energie consumptie profielen van bedrijven \n" + 
"en de huidige gasconsumptie voor verwarming." 
;
  }

  public void set_t_scenario_current( String value ) {
    if (value == this.t_scenario_current) {
      return;
    }
    String _oldValue_xjal = this.t_scenario_current;
    this.t_scenario_current = value;
    onChange_t_scenario_current_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter t_scenario_current.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_t_scenario_current()</code> method instead.
   */
  protected void onChange_t_scenario_current() {
    onChange_t_scenario_current_xjal( t_scenario_current );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_t_scenario_current_xjal( String oldValue ) {  
  }


  public 
String  t_scenario_future;

  /**
   * Returns default value for parameter <code>t_scenario_future</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _t_scenario_future_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
"Het toekomstige scenario bevat de energie dynamieken van dit moment, \n" +
"plus de toekomst plannen van alle bedrijven die de enquete hebben \n" +
"ingevuld. Deze plannen kunnen bevatten: het instaleren van extra \n" +
"zonnepanelen, aangevraagde net uitbereiding, maar ook plannen voor \n" + 
"het electrificeren van het transport." 
;
  }

  public void set_t_scenario_future( String value ) {
    if (value == this.t_scenario_future) {
      return;
    }
    String _oldValue_xjal = this.t_scenario_future;
    this.t_scenario_future = value;
    onChange_t_scenario_future_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter t_scenario_future.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_t_scenario_future()</code> method instead.
   */
  protected void onChange_t_scenario_future() {
    onChange_t_scenario_future_xjal( t_scenario_future );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_t_scenario_future_xjal( String oldValue ) {  
  }


  public 
String  t_scenario_custom;

  /**
   * Returns default value for parameter <code>t_scenario_custom</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _t_scenario_custom_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
"" 
;
  }

  public void set_t_scenario_custom( String value ) {
    if (value == this.t_scenario_custom) {
      return;
    }
    String _oldValue_xjal = this.t_scenario_custom;
    this.t_scenario_custom = value;
    onChange_t_scenario_custom_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter t_scenario_custom.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_t_scenario_custom()</code> method instead.
   */
  protected void onChange_t_scenario_custom() {
    onChange_t_scenario_custom_xjal( t_scenario_custom );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_t_scenario_custom_xjal( String oldValue ) {  
  }


  public 
J_SliderSettings_Residential  p_residentialScenario_Current;

  /**
   * Returns default value for parameter <code>p_residentialScenario_Current</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_SliderSettings_Residential _p_residentialScenario_Current_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_p_residentialScenario_Current( J_SliderSettings_Residential value ) {
    if (value == this.p_residentialScenario_Current) {
      return;
    }
    J_SliderSettings_Residential _oldValue_xjal = this.p_residentialScenario_Current;
    this.p_residentialScenario_Current = value;
    onChange_p_residentialScenario_Current_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_residentialScenario_Current.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_residentialScenario_Current()</code> method instead.
   */
  protected void onChange_p_residentialScenario_Current() {
    onChange_p_residentialScenario_Current_xjal( p_residentialScenario_Current );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_residentialScenario_Current_xjal( J_SliderSettings_Residential oldValue ) {  
  }


  /**
   * Map that matches OL_FilterOptionsGC option with a user friendly name
   */
  public 
Map<OL_FilterOptionsGC, String>  map_filterOptionUINames;

  /**
   * Returns default value for parameter <code>map_filterOptionUINames</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_FilterOptionsGC, String> _map_filterOptionUINames_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
Map.of(
OL_FilterOptionsGC.COMPANIES, "Bedrijfspanden",
OL_FilterOptionsGC.HOUSES,"Woonhuizen",
OL_FilterOptionsGC.DETAILED,"Met bekende data",
OL_FilterOptionsGC.NONDETAILED,"Met geschatte data",
OL_FilterOptionsGC.HAS_PV,"Met zonnepanelen",
OL_FilterOptionsGC.HAS_TRANSPORT,"Met voertuigen",
OL_FilterOptionsGC.HAS_EV,"Met EV",
OL_FilterOptionsGC.GRIDTOPOLOGY_SELECTEDLOOP,"In de aangewezen 'lus'",
OL_FilterOptionsGC.SELECTED_NEIGHBORHOOD,"In de aangewezen 'buurt'",
OL_FilterOptionsGC.MANUAL_SELECTION, "Handmatige selectie"
) 
;
  }

  public void set_map_filterOptionUINames( Map<OL_FilterOptionsGC, String> value ) {
    if (value == this.map_filterOptionUINames) {
      return;
    }
    Map<OL_FilterOptionsGC, String> _oldValue_xjal = this.map_filterOptionUINames;
    this.map_filterOptionUINames = value;
    onChange_map_filterOptionUINames_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_filterOptionUINames.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_filterOptionUINames()</code> method instead.
   */
  protected void onChange_map_filterOptionUINames() {
    onChange_map_filterOptionUINames_xjal( map_filterOptionUINames );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_filterOptionUINames_xjal( Map<OL_FilterOptionsGC, String> oldValue ) {  
  }


  /**
   * Map that matches the user friendly name with the OL_FilterOptionsGC option<br>
   * -> This is created dynamically and a direct reverse copy of map_filterOptionUINames
   */
  public 
Map<String, OL_FilterOptionsGC>  map_UINamesFilterOption;

  /**
   * Returns default value for parameter <code>map_UINamesFilterOption</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<String, OL_FilterOptionsGC> _map_UINamesFilterOption_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_map_UINamesFilterOption( Map<String, OL_FilterOptionsGC> value ) {
    if (value == this.map_UINamesFilterOption) {
      return;
    }
    Map<String, OL_FilterOptionsGC> _oldValue_xjal = this.map_UINamesFilterOption;
    this.map_UINamesFilterOption = value;
    onChange_map_UINamesFilterOption_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_UINamesFilterOption.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_UINamesFilterOption()</code> method instead.
   */
  protected void onChange_map_UINamesFilterOption() {
    onChange_map_UINamesFilterOption_xjal( map_UINamesFilterOption );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_UINamesFilterOption_xjal( Map<String, OL_FilterOptionsGC> oldValue ) {  
  }


  public 
String  p_defaultMainSliderGCName_solarfarm;

  /**
   * Returns default value for parameter <code>p_defaultMainSliderGCName_solarfarm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_defaultMainSliderGCName_solarfarm_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
"Main solarfarm slider" 
;
  }

  public void set_p_defaultMainSliderGCName_solarfarm( String value ) {
    if (value == this.p_defaultMainSliderGCName_solarfarm) {
      return;
    }
    String _oldValue_xjal = this.p_defaultMainSliderGCName_solarfarm;
    this.p_defaultMainSliderGCName_solarfarm = value;
    onChange_p_defaultMainSliderGCName_solarfarm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultMainSliderGCName_solarfarm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultMainSliderGCName_solarfarm()</code> method instead.
   */
  protected void onChange_p_defaultMainSliderGCName_solarfarm() {
    onChange_p_defaultMainSliderGCName_solarfarm_xjal( p_defaultMainSliderGCName_solarfarm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultMainSliderGCName_solarfarm_xjal( String oldValue ) {  
  }


  public 
String  p_defaultMainSliderGCName_windfarm;

  /**
   * Returns default value for parameter <code>p_defaultMainSliderGCName_windfarm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_defaultMainSliderGCName_windfarm_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
"Main windfarm slider" 
;
  }

  public void set_p_defaultMainSliderGCName_windfarm( String value ) {
    if (value == this.p_defaultMainSliderGCName_windfarm) {
      return;
    }
    String _oldValue_xjal = this.p_defaultMainSliderGCName_windfarm;
    this.p_defaultMainSliderGCName_windfarm = value;
    onChange_p_defaultMainSliderGCName_windfarm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultMainSliderGCName_windfarm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultMainSliderGCName_windfarm()</code> method instead.
   */
  protected void onChange_p_defaultMainSliderGCName_windfarm() {
    onChange_p_defaultMainSliderGCName_windfarm_xjal( p_defaultMainSliderGCName_windfarm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultMainSliderGCName_windfarm_xjal( String oldValue ) {  
  }


  public 
String  p_defaultMainSliderGCName_battery;

  /**
   * Returns default value for parameter <code>p_defaultMainSliderGCName_battery</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_defaultMainSliderGCName_battery_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
"Main battery slider" 
;
  }

  public void set_p_defaultMainSliderGCName_battery( String value ) {
    if (value == this.p_defaultMainSliderGCName_battery) {
      return;
    }
    String _oldValue_xjal = this.p_defaultMainSliderGCName_battery;
    this.p_defaultMainSliderGCName_battery = value;
    onChange_p_defaultMainSliderGCName_battery_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultMainSliderGCName_battery.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultMainSliderGCName_battery()</code> method instead.
   */
  protected void onChange_p_defaultMainSliderGCName_battery() {
    onChange_p_defaultMainSliderGCName_battery_xjal( p_defaultMainSliderGCName_battery );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultMainSliderGCName_battery_xjal( String oldValue ) {  
  }


  public 
String  p_defaultEnergyHubSliderGCName_solarfarm;

  /**
   * Returns default value for parameter <code>p_defaultEnergyHubSliderGCName_solarfarm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_defaultEnergyHubSliderGCName_solarfarm_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
"EnergyHub solarfarm slider" 
;
  }

  public void set_p_defaultEnergyHubSliderGCName_solarfarm( String value ) {
    if (value == this.p_defaultEnergyHubSliderGCName_solarfarm) {
      return;
    }
    String _oldValue_xjal = this.p_defaultEnergyHubSliderGCName_solarfarm;
    this.p_defaultEnergyHubSliderGCName_solarfarm = value;
    onChange_p_defaultEnergyHubSliderGCName_solarfarm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultEnergyHubSliderGCName_solarfarm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultEnergyHubSliderGCName_solarfarm()</code> method instead.
   */
  protected void onChange_p_defaultEnergyHubSliderGCName_solarfarm() {
    onChange_p_defaultEnergyHubSliderGCName_solarfarm_xjal( p_defaultEnergyHubSliderGCName_solarfarm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultEnergyHubSliderGCName_solarfarm_xjal( String oldValue ) {  
  }


  public 
String  p_defaultEnergyHubSliderGCName_windfarm;

  /**
   * Returns default value for parameter <code>p_defaultEnergyHubSliderGCName_windfarm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_defaultEnergyHubSliderGCName_windfarm_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
"EnergyHub windfarm slider" 
;
  }

  public void set_p_defaultEnergyHubSliderGCName_windfarm( String value ) {
    if (value == this.p_defaultEnergyHubSliderGCName_windfarm) {
      return;
    }
    String _oldValue_xjal = this.p_defaultEnergyHubSliderGCName_windfarm;
    this.p_defaultEnergyHubSliderGCName_windfarm = value;
    onChange_p_defaultEnergyHubSliderGCName_windfarm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultEnergyHubSliderGCName_windfarm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultEnergyHubSliderGCName_windfarm()</code> method instead.
   */
  protected void onChange_p_defaultEnergyHubSliderGCName_windfarm() {
    onChange_p_defaultEnergyHubSliderGCName_windfarm_xjal( p_defaultEnergyHubSliderGCName_windfarm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultEnergyHubSliderGCName_windfarm_xjal( String oldValue ) {  
  }


  public 
String  p_defaultEnergyHubSliderGCName_battery;

  /**
   * Returns default value for parameter <code>p_defaultEnergyHubSliderGCName_battery</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_defaultEnergyHubSliderGCName_battery_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return 
"EnergyHub battery slider" 
;
  }

  public void set_p_defaultEnergyHubSliderGCName_battery( String value ) {
    if (value == this.p_defaultEnergyHubSliderGCName_battery) {
      return;
    }
    String _oldValue_xjal = this.p_defaultEnergyHubSliderGCName_battery;
    this.p_defaultEnergyHubSliderGCName_battery = value;
    onChange_p_defaultEnergyHubSliderGCName_battery_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultEnergyHubSliderGCName_battery.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultEnergyHubSliderGCName_battery()</code> method instead.
   */
  protected void onChange_p_defaultEnergyHubSliderGCName_battery() {
    onChange_p_defaultEnergyHubSliderGCName_battery_xjal( p_defaultEnergyHubSliderGCName_battery );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultEnergyHubSliderGCName_battery_xjal( String oldValue ) {  
  }


  public 
String  p_customMapOverlayName;

  /**
   * Returns default value for parameter <code>p_customMapOverlayName</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_customMapOverlayName_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_p_customMapOverlayName( String value ) {
    if (value == this.p_customMapOverlayName) {
      return;
    }
    String _oldValue_xjal = this.p_customMapOverlayName;
    this.p_customMapOverlayName = value;
    onChange_p_customMapOverlayName_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_customMapOverlayName.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_customMapOverlayName()</code> method instead.
   */
  protected void onChange_p_customMapOverlayName() {
    onChange_p_customMapOverlayName_xjal( p_customMapOverlayName );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_customMapOverlayName_xjal( String oldValue ) {  
  }


  public 
ShapeGroup  p_customMapOverlayLegend;

  /**
   * Returns default value for parameter <code>p_customMapOverlayLegend</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ShapeGroup _p_customMapOverlayLegend_DefaultValue_xjal() {
    final Zero_Interface self = this;
    return null;
  }

  public void set_p_customMapOverlayLegend( ShapeGroup value ) {
    if (value == this.p_customMapOverlayLegend) {
      return;
    }
    ShapeGroup _oldValue_xjal = this.p_customMapOverlayLegend;
    this.p_customMapOverlayLegend = value;
    onChange_p_customMapOverlayLegend_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_customMapOverlayLegend.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_customMapOverlayLegend()</code> method instead.
   */
  protected void onChange_p_customMapOverlayLegend() {
    onChange_p_customMapOverlayLegend_xjal( p_customMapOverlayLegend );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_customMapOverlayLegend_xjal( ShapeGroup oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    energyModel = _energyModel_DefaultValue_xjal();
    settings = _settings_DefaultValue_xjal();
    p_currentActiveInfoBubble = _p_currentActiveInfoBubble_DefaultValue_xjal();
    p_minSelectedGCForPublicAggregation = _p_minSelectedGCForPublicAggregation_DefaultValue_xjal();
    b_inEnergyHubSelectionMode = _b_inEnergyHubSelectionMode_DefaultValue_xjal();
    b_inEnergyHubMode = _b_inEnergyHubMode_DefaultValue_xjal();
    user = _user_DefaultValue_xjal();
    project_data = _project_data_DefaultValue_xjal();
    uI_Company = _uI_Company_DefaultValue_xjal();
    uI_EnergyHub = _uI_EnergyHub_DefaultValue_xjal();
    rb_scenarios = _rb_scenarios_DefaultValue_xjal();
    t_scenario_current = _t_scenario_current_DefaultValue_xjal();
    t_scenario_future = _t_scenario_future_DefaultValue_xjal();
    t_scenario_custom = _t_scenario_custom_DefaultValue_xjal();
    p_residentialScenario_Current = _p_residentialScenario_Current_DefaultValue_xjal();
    map_filterOptionUINames = _map_filterOptionUINames_DefaultValue_xjal();
    map_UINamesFilterOption = _map_UINamesFilterOption_DefaultValue_xjal();
    p_defaultMainSliderGCName_solarfarm = _p_defaultMainSliderGCName_solarfarm_DefaultValue_xjal();
    p_defaultMainSliderGCName_windfarm = _p_defaultMainSliderGCName_windfarm_DefaultValue_xjal();
    p_defaultMainSliderGCName_battery = _p_defaultMainSliderGCName_battery_DefaultValue_xjal();
    p_defaultEnergyHubSliderGCName_solarfarm = _p_defaultEnergyHubSliderGCName_solarfarm_DefaultValue_xjal();
    p_defaultEnergyHubSliderGCName_windfarm = _p_defaultEnergyHubSliderGCName_windfarm_DefaultValue_xjal();
    p_defaultEnergyHubSliderGCName_battery = _p_defaultEnergyHubSliderGCName_battery_DefaultValue_xjal();
    p_customMapOverlayName = _p_customMapOverlayName_DefaultValue_xjal();
    p_customMapOverlayLegend = _p_customMapOverlayLegend_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "energyModel":
      if ( _callOnChange_xjal ) {
        set_energyModel( (EnergyModel) _value_xjal );
      } else {
        energyModel = (EnergyModel) _value_xjal;
      }
      return true;
    case "settings":
      if ( _callOnChange_xjal ) {
        set_settings( (Settings) _value_xjal );
      } else {
        settings = (Settings) _value_xjal;
      }
      return true;
    case "p_currentActiveInfoBubble":
      if ( _callOnChange_xjal ) {
        set_p_currentActiveInfoBubble( (List<ShapeImage>) _value_xjal );
      } else {
        p_currentActiveInfoBubble = (List<ShapeImage>) _value_xjal;
      }
      return true;
    case "p_minSelectedGCForPublicAggregation":
      if ( _callOnChange_xjal ) {
        set_p_minSelectedGCForPublicAggregation( ((Number) _value_xjal).intValue() );
      } else {
        p_minSelectedGCForPublicAggregation = ((Number) _value_xjal).intValue();
      }
      return true;
    case "b_inEnergyHubSelectionMode":
      if ( _callOnChange_xjal ) {
        set_b_inEnergyHubSelectionMode( (Boolean) _value_xjal );
      } else {
        b_inEnergyHubSelectionMode = (Boolean) _value_xjal;
      }
      return true;
    case "b_inEnergyHubMode":
      if ( _callOnChange_xjal ) {
        set_b_inEnergyHubMode( (Boolean) _value_xjal );
      } else {
        b_inEnergyHubMode = (Boolean) _value_xjal;
      }
      return true;
    case "user":
      if ( _callOnChange_xjal ) {
        set_user( (User) _value_xjal );
      } else {
        user = (User) _value_xjal;
      }
      return true;
    case "project_data":
      if ( _callOnChange_xjal ) {
        set_project_data( (Project_data) _value_xjal );
      } else {
        project_data = (Project_data) _value_xjal;
      }
      return true;
    case "uI_Company":
      if ( _callOnChange_xjal ) {
        set_uI_Company( (UI_company) _value_xjal );
      } else {
        uI_Company = (UI_company) _value_xjal;
      }
      return true;
    case "uI_EnergyHub":
      if ( _callOnChange_xjal ) {
        set_uI_EnergyHub( (UI_EnergyHub) _value_xjal );
      } else {
        uI_EnergyHub = (UI_EnergyHub) _value_xjal;
      }
      return true;
    case "rb_scenarios":
      if ( _callOnChange_xjal ) {
        set_rb_scenarios( (ShapeRadioButtonGroup) _value_xjal );
      } else {
        rb_scenarios = (ShapeRadioButtonGroup) _value_xjal;
      }
      return true;
    case "t_scenario_current":
      if ( _callOnChange_xjal ) {
        set_t_scenario_current( (String) _value_xjal );
      } else {
        t_scenario_current = (String) _value_xjal;
      }
      return true;
    case "t_scenario_future":
      if ( _callOnChange_xjal ) {
        set_t_scenario_future( (String) _value_xjal );
      } else {
        t_scenario_future = (String) _value_xjal;
      }
      return true;
    case "t_scenario_custom":
      if ( _callOnChange_xjal ) {
        set_t_scenario_custom( (String) _value_xjal );
      } else {
        t_scenario_custom = (String) _value_xjal;
      }
      return true;
    case "p_residentialScenario_Current":
      if ( _callOnChange_xjal ) {
        set_p_residentialScenario_Current( (J_SliderSettings_Residential) _value_xjal );
      } else {
        p_residentialScenario_Current = (J_SliderSettings_Residential) _value_xjal;
      }
      return true;
    case "map_filterOptionUINames":
      if ( _callOnChange_xjal ) {
        set_map_filterOptionUINames( (Map<OL_FilterOptionsGC, String>) _value_xjal );
      } else {
        map_filterOptionUINames = (Map<OL_FilterOptionsGC, String>) _value_xjal;
      }
      return true;
    case "map_UINamesFilterOption":
      if ( _callOnChange_xjal ) {
        set_map_UINamesFilterOption( (Map<String, OL_FilterOptionsGC>) _value_xjal );
      } else {
        map_UINamesFilterOption = (Map<String, OL_FilterOptionsGC>) _value_xjal;
      }
      return true;
    case "p_defaultMainSliderGCName_solarfarm":
      if ( _callOnChange_xjal ) {
        set_p_defaultMainSliderGCName_solarfarm( (String) _value_xjal );
      } else {
        p_defaultMainSliderGCName_solarfarm = (String) _value_xjal;
      }
      return true;
    case "p_defaultMainSliderGCName_windfarm":
      if ( _callOnChange_xjal ) {
        set_p_defaultMainSliderGCName_windfarm( (String) _value_xjal );
      } else {
        p_defaultMainSliderGCName_windfarm = (String) _value_xjal;
      }
      return true;
    case "p_defaultMainSliderGCName_battery":
      if ( _callOnChange_xjal ) {
        set_p_defaultMainSliderGCName_battery( (String) _value_xjal );
      } else {
        p_defaultMainSliderGCName_battery = (String) _value_xjal;
      }
      return true;
    case "p_defaultEnergyHubSliderGCName_solarfarm":
      if ( _callOnChange_xjal ) {
        set_p_defaultEnergyHubSliderGCName_solarfarm( (String) _value_xjal );
      } else {
        p_defaultEnergyHubSliderGCName_solarfarm = (String) _value_xjal;
      }
      return true;
    case "p_defaultEnergyHubSliderGCName_windfarm":
      if ( _callOnChange_xjal ) {
        set_p_defaultEnergyHubSliderGCName_windfarm( (String) _value_xjal );
      } else {
        p_defaultEnergyHubSliderGCName_windfarm = (String) _value_xjal;
      }
      return true;
    case "p_defaultEnergyHubSliderGCName_battery":
      if ( _callOnChange_xjal ) {
        set_p_defaultEnergyHubSliderGCName_battery( (String) _value_xjal );
      } else {
        p_defaultEnergyHubSliderGCName_battery = (String) _value_xjal;
      }
      return true;
    case "p_customMapOverlayName":
      if ( _callOnChange_xjal ) {
        set_p_customMapOverlayName( (String) _value_xjal );
      } else {
        p_customMapOverlayName = (String) _value_xjal;
      }
      return true;
    case "p_customMapOverlayLegend":
      if ( _callOnChange_xjal ) {
        set_p_customMapOverlayLegend( (ShapeGroup) _value_xjal );
      } else {
        p_customMapOverlayLegend = (ShapeGroup) _value_xjal;
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
    case "energyModel": _result_xjal = energyModel; break;
    case "settings": _result_xjal = settings; break;
    case "p_currentActiveInfoBubble": _result_xjal = p_currentActiveInfoBubble; break;
    case "p_minSelectedGCForPublicAggregation": _result_xjal = p_minSelectedGCForPublicAggregation; break;
    case "b_inEnergyHubSelectionMode": _result_xjal = b_inEnergyHubSelectionMode; break;
    case "b_inEnergyHubMode": _result_xjal = b_inEnergyHubMode; break;
    case "user": _result_xjal = user; break;
    case "project_data": _result_xjal = project_data; break;
    case "uI_Company": _result_xjal = uI_Company; break;
    case "uI_EnergyHub": _result_xjal = uI_EnergyHub; break;
    case "rb_scenarios": _result_xjal = rb_scenarios; break;
    case "t_scenario_current": _result_xjal = t_scenario_current; break;
    case "t_scenario_future": _result_xjal = t_scenario_future; break;
    case "t_scenario_custom": _result_xjal = t_scenario_custom; break;
    case "p_residentialScenario_Current": _result_xjal = p_residentialScenario_Current; break;
    case "map_filterOptionUINames": _result_xjal = map_filterOptionUINames; break;
    case "map_UINamesFilterOption": _result_xjal = map_UINamesFilterOption; break;
    case "p_defaultMainSliderGCName_solarfarm": _result_xjal = p_defaultMainSliderGCName_solarfarm; break;
    case "p_defaultMainSliderGCName_windfarm": _result_xjal = p_defaultMainSliderGCName_windfarm; break;
    case "p_defaultMainSliderGCName_battery": _result_xjal = p_defaultMainSliderGCName_battery; break;
    case "p_defaultEnergyHubSliderGCName_solarfarm": _result_xjal = p_defaultEnergyHubSliderGCName_solarfarm; break;
    case "p_defaultEnergyHubSliderGCName_windfarm": _result_xjal = p_defaultEnergyHubSliderGCName_windfarm; break;
    case "p_defaultEnergyHubSliderGCName_battery": _result_xjal = p_defaultEnergyHubSliderGCName_battery; break;
    case "p_customMapOverlayName": _result_xjal = p_customMapOverlayName; break;
    case "p_customMapOverlayLegend": _result_xjal = p_customMapOverlayLegend; break;
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
      list.add( "energyModel" );
      list.add( "settings" );
      list.add( "p_currentActiveInfoBubble" );
      list.add( "p_minSelectedGCForPublicAggregation" );
      list.add( "b_inEnergyHubSelectionMode" );
      list.add( "b_inEnergyHubMode" );
      list.add( "user" );
      list.add( "project_data" );
      list.add( "uI_Company" );
      list.add( "uI_EnergyHub" );
      list.add( "rb_scenarios" );
      list.add( "t_scenario_current" );
      list.add( "t_scenario_future" );
      list.add( "t_scenario_custom" );
      list.add( "p_residentialScenario_Current" );
      list.add( "map_filterOptionUINames" );
      list.add( "map_UINamesFilterOption" );
      list.add( "p_defaultMainSliderGCName_solarfarm" );
      list.add( "p_defaultMainSliderGCName_windfarm" );
      list.add( "p_defaultMainSliderGCName_battery" );
      list.add( "p_defaultEnergyHubSliderGCName_solarfarm" );
      list.add( "p_defaultEnergyHubSliderGCName_windfarm" );
      list.add( "p_defaultEnergyHubSliderGCName_battery" );
      list.add( "p_customMapOverlayName" );
      list.add( "p_customMapOverlayLegend" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
boolean 
 b_resultsUpToDate;
  public 
GridNode 
 v_clickedGridNode;
  public 
GISRegion 
 GISregion_antiLaag;
  public 
OL_GISObjectType 
 v_clickedObjectType;
  public 
double 
 v_outsideTemperature;
  public 
int 
 v_solarIrradiance;
  public 
String 
 v_windspeed;
  public 
Color 
 v_restBuildingLineColor;
  public 
EnergyCoop 
 v_customEnergyCoop;
  public 
int 
 v_numberOfSurveyCompanyGC;
  public 
ShapeRadioButtonGroup 
 rb_mapOverlay;
  public 
Zero_Loader 
 zero_loader;
  public 
GIS_Object 
 v_clickedObject;
  public 
Color 
 v_LVGridColor;
  public 
Color 
 v_HVGridColor;
  public 
Color 
 v_gasGridColor;
  public 
Color 
 v_energyLabelAColor;
  public 
Color 
 v_energyLabelBColor;
  public 
Color 
 v_energyLabelCColor;
  public 
Color 
 v_energyLabelDColor;
  public 
Color 
 v_energyLabelEColor;
  public 
Color 
 v_energyLabelFColor;
  public 
Color 
 v_energyLabelUnknownColor;
  public 
Color 
 v_energyLabelGColor;
  public 
Color 
 v_MVGridColor;
  public 
String 
 v_clickedObjectText;
  public 
Color 
 v_simulationArea1Color;
  public 
Color 
 v_companyBuildingColor;
  public 
Color 
 v_detailedCompanyBuildingColor;
  public 
Color 
 v_houseBuildingColor;
  public 
Color 
 v_restBuildingColor;
  public 
Color 
 v_solarParkColor;
  public 
Color 
 v_selectionColor;
  public 
Color 
 v_selectionColorAddBuildings;
  public 
Color 
 v_HVMVNodeColor;
  public 
Color 
 v_HVMVLineColor;
  public 
Color 
 v_solarParkLineColor;
  public 
Color 
 v_electrolyserColor;
  public 
Color 
 v_chargingStationColor;
  public 
Color 
 v_antiLayerColor;
  public 
Color 
 v_electrolyserLineColor;
  public 
Color 
 v_chargingStationLineColor;
  public 
Color 
 v_simulationArea1LineColor;
  public 
Color 
 v_backgroundColor;
  public 
Color 
 v_gridNodeFeedinColor;
  public 
Color 
 v_batteryColor;
  public 
Color 
 v_batteryLineColor;
  public 
Color 
 v_windFarmColor;
  public 
Color 
 v_windFarmLineColor;
  public 
Color 
 v_MVLVNodeColor;
  public 
Color 
 v_MVLVLineColor;
  public 
Color 
 v_gridNodeColorStrained;
  public 
Color 
 v_gridNodeLineColorStrained;
  public 
Color 
 v_gridNodeColorCongested;
  public 
Color 
 v_gridLineColorCongested;
  public 
Color 
 v_unknownConsumptionColor;
  public 
boolean 
 b_updateLiveCongestionColors;
  public 
Color 
 v_newChargingStationColor;
  public 
Color 
 v_newChargingStationLineColor;
  public 
int 
 v_selectedGridConnectionIndex;
  public 
int 
 v_nbGridConnectionsInSelectedBuilding;
  public 
Color 
 v_companyBuildingLineColor;
  public 
Color 
 v_detailedCompanyBuildingLineColor;
  public 
Color 
 v_houseBuildingLineColor;
  public 
Color 
 v_parcelColor;
  public 
Color 
 v_parcelLineColor;
  public 
Color 
 v_MVMVNodeColor;
  public 
Color 
 v_MVMVLineColor;
  public 
double 
 v_HVMVNodeSize;
  public 
double 
 v_MVMVNodeSize;
  public 
double 
 v_MVLVNodeSize;
  public 
double 
 v_energyAssetLineWidth;
  public 
boolean 
 b_runningMainInterfaceScenarios;
  public 
boolean 
 b_gridLoopsAreDefined;
  public 
Color 
 v_forcedClickScreenColor;
  public 
boolean 
 b_inManualFilterSelectionMode;
  public 
J_InfoText 
 v_infoText;
  public 
Color 
 v_parkingSpaceColor_private;
  public 
Color 
 v_parkingSpaceLineColor_private;
  public 
Color 
 v_parkingSpaceColor_electric;
  public 
Color 
 v_parkingSpaceLineColor_electric;
  public 
Color 
 v_parkingSpaceColor_public;
  public 
Color 
 v_parkingSpaceLineColor_public;
  public 
boolean 
 v_HVMVNodeIsVisible;
  public 
Color 
 v_gridNodeLineColorUncongested;
  public 
Color 
 v_gridNodeColorUncongested;
  public 
Color 
 v_LVLVNodeColor;
  public 
Color 
 v_LVLVLineColor;
  public 
double 
 v_LVLVNodeSize;
  public 
int 
 v_amountOfDefinedGridLoops;
  public 
Color 
 v_gridNodeColorCapacityUnknown;
  public 
Color 
 v_gridNodeLineColorCapacityUnknown;
  public 
Color 
 v_parkingSpaceLineColor_unkown;
  public 
Color 
 v_parkingSpaceColor_unkown;
  public 
ViewArea 
 v_currentViewArea;

  // Collection Variables
  public 
ArrayList <
GIS_Object > c_GISNeighborhoods = new ArrayList<GIS_Object>();
  public 
LinkedHashMap <
String , 
J_scenario_Future > c_scenarioMap_Future = new LinkedHashMap<String, J_scenario_Future>();
  public 
LinkedHashMap <
String , 
J_scenario_Current > c_scenarioMap_Current = new LinkedHashMap<String, J_scenario_Current>();
  public 
ArrayList <
J_EA > c_orderedVehicles = new ArrayList<J_EA>();
  public 
ArrayList <
GCUtility > c_orderedHeatingSystemsCompanies = new ArrayList<GCUtility>();
  public 
ArrayList <
GCUtility > c_orderedPVSystemsCompanies = new ArrayList<GCUtility>();
  public 
ArrayList <
GCHouse > c_orderedHeatingSystemsHouses = new ArrayList<GCHouse>();
  public 
ArrayList <
GISRegion > c_GISNetplanes = new ArrayList<GISRegion>();
  public 
ArrayList <
GridConnection > c_selectedGridConnections = new ArrayList<GridConnection>();
  public 
ArrayList <
GISRoute > c_LVCables = new ArrayList<GISRoute>();
  public 
ArrayList <
GISRoute > c_MVCables = new ArrayList<GISRoute>();
  protected 
ArrayList <
OL_FilterOptionsGC > c_selectedFilterOptions = new ArrayList<OL_FilterOptionsGC>();
  public 
ArrayList <
GIS_Object > c_selectedObjects = new ArrayList<GIS_Object>();
  public 
ArrayList <
GridConnection > c_manualFilterDeselectedGC = new ArrayList<GridConnection>();
  public 
ArrayList <
GridConnection > c_manualFilterSelectedGC = new ArrayList<GridConnection>();
  public 
ArrayList <
GridNode > c_filterSelectedGridLoops = new ArrayList<GridNode>();
  public 
ArrayList <
GIS_Object > c_filterSelectedNeighborhoods = new ArrayList<GIS_Object>();
  public 
ArrayList <
GIS_Object > c_orderedParkingSpaces = new ArrayList<GIS_Object>();
  public 
ArrayList <
GCHouse > c_orderedPVSystemsHouses = new ArrayList<GCHouse>();
  public 
LinkedHashSet <
OL_GISObjectType > c_modelActiveSpecialGISObjects = new LinkedHashSet<OL_GISObjectType>();
  public 
ArrayList <
GCPublicCharger > c_orderedV1GChargers = new ArrayList<GCPublicCharger>();
  public 
LinkedHashSet <
OL_ParkingSpaceType > c_modelActiveParkingSpaceTypes = new LinkedHashSet<OL_ParkingSpaceType>();
  public 
ArrayList <
GCPublicCharger > c_orderedV2GChargers = new ArrayList<GCPublicCharger>();
  public 
LinkedHashSet <
OL_GISBuildingTypes > c_modelActiveDefaultGISBuildings = new LinkedHashSet<OL_GISBuildingTypes>();
  public 
ArrayList <
I_Vehicle > c_orderedVehiclesPrivateParking = new ArrayList<I_Vehicle>();
  /**
   * Niet laadpleinen, alleen losse palen
   */
  public 
ArrayList <
GCPublicCharger > c_orderedPublicChargers = new ArrayList<GCPublicCharger>();
  public 
ArrayList <
OL_MapOverlayTypes > c_loadedMapOverlayTypes = new ArrayList<OL_MapOverlayTypes>();
  public 
ArrayList <
GCHouse > c_orderedPTSystemsHouses = new ArrayList<GCHouse>();
  public 
LinkedHashMap <
String , 
List<J_EAFuelVehicle> > c_mappingOfVehiclesPerCharger = new LinkedHashMap<String, List<J_EAFuelVehicle>>();
  public 
ArrayList <
UI_Results > c_UIResultsInstances = new ArrayList<UI_Results>();
  public 
LinkedHashMap <
String , 
List<I_Vehicle> > c_additionalVehicles = new LinkedHashMap<String, List<I_Vehicle>>();
  public 
ArrayList <
OL_FilterOptionsGC > c_cbFilterOptions = new ArrayList<OL_FilterOptionsGC>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Zero_Interface.class );

  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }


  // Events

  public EventTimeout e_calculateEnergyBalance = new EventTimeout(this);
  public EventTimeout e_setStartView = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot_outsideTemperature_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot_solarIrradiance_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == e_calculateEnergyBalance ) return "e_calculateEnergyBalance";
     if( _e == e_setStartView ) return "e_setStartView";
     if( _e == _plot_outsideTemperature_autoUpdateEvent_xjal ) return "plot_outsideTemperature auto update event";
     if( _e == _plot_solarIrradiance_autoUpdateEvent_xjal ) return "plot_solarIrradiance auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == e_calculateEnergyBalance ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == e_setStartView ) return EVENT_TIMEOUT_MODE_ONCE;
    if ( _e == _plot_outsideTemperature_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot_solarIrradiance_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == e_calculateEnergyBalance ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == e_setStartView ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _plot_outsideTemperature_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _plot_solarIrradiance_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    return super.getFirstOccurrenceTime( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( EventTimeout _e ) {
    double _t;
    if( _e == e_calculateEnergyBalance) {
      _t = 
energyModel.p_timeParameters.getTimeStep_h() 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _plot_outsideTemperature_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _plot_solarIrradiance_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == e_calculateEnergyBalance ) {
      EventTimeout self = _e;

// Trigger timestep in energymodel for continuous simulation ('interactive mode')
energyModel.f_runTimestep();


// This function colors the trafos according to the amount of congestion. (maybe move this function call somewhere else?)
if ( b_updateLiveCongestionColors ){
	for (GridNode gn : energyModel.pop_gridNodes) {
		if ((v_clickedObjectType != OL_GISObjectType.GRIDNODE || v_clickedGridNode != gn) && gn.p_energyCarrier == OL_EnergyCarriers.ELECTRICITY) {
			f_setColorsBasedOnCongestion_gridnodes(gn, true);
		}
	}
}


// Update the NFATO values in the selected companyUI
if(uI_Company != null){
	if(uI_Company.v_NFATO_active){
		uI_Company.f_getNFATOValues();
	}
}


// Get the weather info
f_getWeatherInfo(); 
;
      return;
    }
    if ( _e == e_setStartView ) {
      EventTimeout self = _e;

f_setStartView(); 
;
      return;
    }
    if ( _e == _plot_outsideTemperature_autoUpdateEvent_xjal ) {
      plot_outsideTemperature.updateData();
      return;
    }
    if ( _e == _plot_solarIrradiance_autoUpdateEvent_xjal ) {
      plot_solarIrradiance.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Embedded Objects

  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _uI_Results_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _uI_Tabs_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _pop_UI_EnergyHub_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  public digital_twin_results.UI_Results uI_Results;
  public UI_Tabs uI_Tabs;

  public String getNameOf( Agent ao ) {
    if ( ao == uI_Results ) return "uI_Results";
    if ( ao == uI_Tabs ) return "uI_Tabs";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    if ( ao == uI_Results ) return _uI_Results_animationSettings_xjal;
    if ( ao == uI_Tabs ) return _uI_Tabs_animationSettings_xjal;
    return super.getAnimationSettingsOf( ao );
  }

  public class _pop_UI_Company_Population extends AgentArrayList<UI_company> {
    _pop_UI_Company_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public UI_company instantiateAgent( int index ) {
    	return instantiate_pop_UI_Company_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( UI_company agent, int index, TableInput tableInput ) {
      setupParameters_pop_UI_Company_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( UI_company agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_UI_Company_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "UI_company")
  public _pop_UI_Company_Population pop_UI_Company = new _pop_UI_Company_Population( this );
  public class _pop_UI_EnergyHub_Population extends AgentArrayList<UI_EnergyHub> {
    _pop_UI_EnergyHub_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public UI_EnergyHub instantiateAgent( int index ) {
    	return instantiate_pop_UI_EnergyHub_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( UI_EnergyHub agent, int index, TableInput tableInput ) {
      setupParameters_pop_UI_EnergyHub_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( UI_EnergyHub agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_UI_EnergyHub_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "UI_EnergyHub")
  public _pop_UI_EnergyHub_Population pop_UI_EnergyHub = new _pop_UI_EnergyHub_Population( this );

  public String getNameOf( AgentList<?> aolist ) {
    if( aolist == pop_UI_Company ) return "pop_UI_Company";
    if( aolist == pop_UI_EnergyHub ) return "pop_UI_EnergyHub";
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    if( aolist == pop_UI_EnergyHub ) return _pop_UI_EnergyHub_animationSettings_xjal;
    return super.getAnimationSettingsOf( aolist );
  }

  /**
   * Returns the agent element at the specified position in pop_UI_Company
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public UI_company pop_UI_Company(int index) {
    return pop_UI_Company.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_UI_Company<br>
   * @return newly created embedded object
   */
  public UI_company add_pop_UI_Company() {
    int index = pop_UI_Company.size();
    UI_company _result_xjal = instantiate_pop_UI_Company_xjal( index );
    pop_UI_Company.callSetupParameters( _result_xjal, index );
    pop_UI_Company.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_UI_Company<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_UI_Company.size()</code> method <strong>before</strong> this method is called
   * @param p_companyName
   * @param p_maxAddedVehicles
   * @param p_scenarioSettings_Current
   * @param p_scenarioSettings_Future
   * @param p_gridConnection
   * @param p_maxSavingsSliders_default
   * @param p_minSavingsSliders_default
   * @return newly created embedded object
   */
  public UI_company add_pop_UI_Company( String p_companyName, int p_maxAddedVehicles, J_scenario_Current p_scenarioSettings_Current, J_scenario_Future p_scenarioSettings_Future, GridConnection p_gridConnection, double p_maxSavingsSliders_default, double p_minSavingsSliders_default ) {
    int index = pop_UI_Company.size();
    UI_company _result_xjal = instantiate_pop_UI_Company_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_companyName = p_companyName;
    _result_xjal.p_maxAddedVehicles = p_maxAddedVehicles;
    _result_xjal.p_scenarioSettings_Current = p_scenarioSettings_Current;
    _result_xjal.p_scenarioSettings_Future = p_scenarioSettings_Future;
    _result_xjal.p_gridConnection = p_gridConnection;
    _result_xjal.p_maxSavingsSliders_default = p_maxSavingsSliders_default;
    _result_xjal.p_minSavingsSliders_default = p_minSavingsSliders_default;
    // Finish embedded object creation
    pop_UI_Company.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_UI_Company<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_UI_Company - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_UI_Company
   */
  public boolean remove_pop_UI_Company( UI_company object ) {
    if( ! pop_UI_Company._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_UI_EnergyHub
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public UI_EnergyHub pop_UI_EnergyHub(int index) {
    return pop_UI_EnergyHub.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_UI_EnergyHub<br>
   * @return newly created embedded object
   */
  public UI_EnergyHub add_pop_UI_EnergyHub() {
    int index = pop_UI_EnergyHub.size();
    UI_EnergyHub _result_xjal = instantiate_pop_UI_EnergyHub_xjal( index );
    pop_UI_EnergyHub.callSetupParameters( _result_xjal, index );
    pop_UI_EnergyHub.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_UI_EnergyHub<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_UI_EnergyHub.size()</code> method <strong>before</strong> this method is called
   * @param p_energyHubBackGroundColor
   * @param p_energyHubLineColor
   * @param p_energyHubLineWidth
   * @param p_energyHubLineStyle
   * @return newly created embedded object
   */
  public UI_EnergyHub add_pop_UI_EnergyHub( Color p_energyHubBackGroundColor, Color p_energyHubLineColor, double p_energyHubLineWidth, LineStyle p_energyHubLineStyle ) {
    int index = pop_UI_EnergyHub.size();
    UI_EnergyHub _result_xjal = instantiate_pop_UI_EnergyHub_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_energyHubBackGroundColor = p_energyHubBackGroundColor;
    _result_xjal.p_energyHubLineColor = p_energyHubLineColor;
    _result_xjal.p_energyHubLineWidth = p_energyHubLineWidth;
    _result_xjal.p_energyHubLineStyle = p_energyHubLineStyle;
    // Finish embedded object creation
    pop_UI_EnergyHub.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_UI_EnergyHub<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_UI_EnergyHub - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_UI_EnergyHub
   */
  public boolean remove_pop_UI_EnergyHub( UI_EnergyHub object ) {
    if( ! pop_UI_EnergyHub._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected UI_company instantiate_pop_UI_Company_xjal( final int index ) {
    UI_company _result_xjal = new UI_company( getEngine(), this, pop_UI_Company );
    
    pop_UI_Company._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_UI_Company_xjal( final UI_company self, final int index, TableInput _t ) {
    self.p_companyName = self._p_companyName_DefaultValue_xjal();
    self.p_maxAddedVehicles = self._p_maxAddedVehicles_DefaultValue_xjal();
    self.p_scenarioSettings_Current = self._p_scenarioSettings_Current_DefaultValue_xjal();
    self.p_scenarioSettings_Future = self._p_scenarioSettings_Future_DefaultValue_xjal();
    self.p_gridConnection = self._p_gridConnection_DefaultValue_xjal();
    self.p_maxSavingsSliders_default = self._p_maxSavingsSliders_default_DefaultValue_xjal();
    self.p_minSavingsSliders_default = self._p_minSavingsSliders_default_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_UI_Company_xjal( UI_company self, final int index, TableInput _t ) {

    // Port connections
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
energyModel 
;
    self.p_cutOff_MWh = self._p_cutOff_MWh_DefaultValue_xjal();
    self.gr_infoText = 
gr_infoText 
;
    self.gr_closeInfoText = 
gr_closeInfoText 
;
    self.t_infoTextDescription = 
t_infoTextDescription 
;
    self.rect_infoText = 
rect_infoText 
;
    self.p_currentActiveInfoBubble = 
p_currentActiveInfoBubble 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_uI_Results_xjal( digital_twin_results.UI_Results self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected UI_Tabs instantiate_uI_Tabs_xjal() {
    UI_Tabs _result_xjal = new UI_Tabs( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_uI_Tabs_xjal( final UI_Tabs self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_uI_Tabs_xjal( UI_Tabs self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected UI_EnergyHub instantiate_pop_UI_EnergyHub_xjal( final int index ) {
    UI_EnergyHub _result_xjal = new UI_EnergyHub( getEngine(), this, pop_UI_EnergyHub );
    
    pop_UI_EnergyHub._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_UI_EnergyHub_xjal( final UI_EnergyHub self, final int index, TableInput _t ) {
    self.p_energyHubBackGroundColor = self._p_energyHubBackGroundColor_DefaultValue_xjal();
    self.p_energyHubLineColor = self._p_energyHubLineColor_DefaultValue_xjal();
    self.p_energyHubLineWidth = self._p_energyHubLineWidth_DefaultValue_xjal();
    self.p_energyHubLineStyle = self._p_energyHubLineStyle_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_UI_EnergyHub_xjal( UI_EnergyHub self, final int index, TableInput _t ) {

    // Port connections
  }

  // Functions

  protected void f_setColorsBasedOnEnergyLabels( GIS_Object b ) { 

if (b.gisRegion != null){

	OL_GridConnectionEnergyLabel buildingLowestEnergyLabel = OL_GridConnectionEnergyLabel.UNKNOWN;
	
	//Find the lowest energy label in the building
	for(GridConnection GC : b.c_containedGridConnections){
		buildingLowestEnergyLabel = J_PBLUtil.getWorstEnergyLabel(buildingLowestEnergyLabel, GC.p_energyLabel);
	}
	
	//Color building based on lowest energy label
	switch(buildingLowestEnergyLabel){
		case A:
			b.gisRegion.setFillColor(v_energyLabelAColor);
		break;
		case B:
			b.gisRegion.setFillColor(v_energyLabelBColor);
		break;
		case C:
			b.gisRegion.setFillColor(v_energyLabelCColor);
		break;
		case D:
			b.gisRegion.setFillColor(v_energyLabelDColor);
		break;
		case E:
			b.gisRegion.setFillColor(v_energyLabelEColor);
		break;
		case F:
			b.gisRegion.setFillColor(v_energyLabelFColor);
		break;
		case G:
			b.gisRegion.setFillColor(v_energyLabelGColor);
		break;
		case NONE:
		case UNKNOWN:
			b.gisRegion.setFillColor(v_energyLabelUnknownColor);
		break;
	}
} 
  }

  /**
   * Function that selects gisregions after click on the map
   */
  protected void f_selectGISRegion( double clickx, double clicky ) { 

//After a click, reset previous clicked building/gridNode colors and text
ArrayList<GIS_Object> buildingsConnectedToSelectedBuildingsList = new ArrayList<>();

//Deselect previous selection
f_deselectPreviousSelect();

//Check if click was on Gridnode, if yes, select grid node
for ( GridNode GN : energyModel.pop_gridNodes ){
	if( GN.gisRegion != null && GN.gisRegion.contains(clickx, clicky) && GN.gisRegion.isVisible() ){
		if(f_checkIfGCsAreAccesible(GN.f_getAllLowerLVLConnectedGridConnections())){
			f_selectGridNode(GN);
		}
		else{
			f_selectEnergyModel();
		}
		return;
	}
}

//Group all buildings with gisobjects in one array for a single loop (Fastest way to convert pop to list is writing out the loop)
List<GIS_Object> allGISObjects = new ArrayList<>();
for(GIS_Building b : energyModel.pop_GIS_Buildings) {
    allGISObjects.add(b);
}
for(GIS_Object object : energyModel.pop_GIS_Objects) {
    allGISObjects.add(object);
}

//Check if click was on Building or GISObject such as chargers, solarfields, windfarm, if yes: Select.
for ( GIS_Object GISObject : allGISObjects ){
	if( GISObject.gisRegion != null && GISObject.gisRegion.contains(clickx, clicky) ) {
		if (GISObject.gisRegion.isVisible()) { //only allow us to click on visible objects
			if (GISObject.c_containedGridConnections.size() > 0 ) { // only allow objects with gridconnections
				if(f_checkIfGCsAreAccesible(GISObject.c_containedGridConnections)){
					if(GISObject.c_containedGridConnections.size() == 1){
						buildingsConnectedToSelectedBuildingsList.addAll(GISObject.c_containedGridConnections.get(0).c_connectedGISObjects); // Find buildings powered by the same GC as the clicked object 
					}
					else{
						buildingsConnectedToSelectedBuildingsList.add(GISObject);
					}
					f_selectBuilding(GISObject, buildingsConnectedToSelectedBuildingsList);		
				}
				else{
					f_selectEnergyModel();
				}
				return;
			}
		}
	}
}

//Still no clicked object? : select energyModel
f_selectEnergyModel(); 
  }

  public void f_styleAreas( GIS_Object gis_area ) { 

double width = 1;

if (gis_area instanceof GIS_Parcel ||
	gis_area.c_containedGridConnections.size() == 0 ||
	gis_area.c_containedGridConnections.get(0) instanceof GCPublicCharger ) {
	// Parcels, Chargers and GIS Objects without GCs are always the default color
	gis_area.f_style(null, null, null, null);
	return;
}

//Get selected map overlay type, based on loaded order of the radio buttons
OL_MapOverlayTypes selectedMapOverlayType;
if(rb_mapOverlay != null){
	selectedMapOverlayType = c_loadedMapOverlayTypes.get(rb_mapOverlay.getValue());
}
else{
	selectedMapOverlayType = OL_MapOverlayTypes.DEFAULT;
}
//Set the correct map overlay
switch(selectedMapOverlayType){
	case DEFAULT:
		gis_area.f_style(null, null, null, null);
		break;
	case ELECTRICITY_CONSUMPTION:
		if (project_data.project_type() == OL_ProjectType.RESIDENTIAL) {
			f_setColorsBasedOnConsumptionProfileHouseholds(gis_area);
		}
		else {
			f_setColorsBasedOnElectricityConsumption(gis_area);
		}
		break;
	case PV_PRODUCTION:
		f_setColorsBasedOnProduction(gis_area);
		break;
	case GRID_NEIGHBOURS:
		f_setColorsBasedOnGridTopology_objects(gis_area);
		break;
	case CONGESTION:
		f_setColorsBasedOnCongestion_objects(gis_area);
		break;
	case ENERGY_LABEL:
		f_setColorsBasedOnEnergyLabels(gis_area);
		break;
	case PARKING_TYPE:
		f_setColorsBasedOnParkingType_objects(gis_area);
		break;
	case CUSTOM:
		f_setColorsBasedOnCustom_objects(gis_area);
		break;
} 
  }

  public void f_styleSimulationAreas( GIS_Object area ) { 

GISRegion gisregion = area.gisRegion; 

switch( area.p_GISObjectType ) {
	case ANTI_LAYER:
		gisregion.setVisible(true);	
		gisregion.setLineStyle( LINE_STYLE_SOLID );
		gisregion.setLineWidth( 0);
		gisregion.setLineColor( v_antiLayerColor );
		gisregion.setFillColor( v_antiLayerColor );
		GISregion_antiLaag = gisregion;
		
		//Pas p_id aan naar een normale naam
		area.p_id = "Buitengebied";
	break;
	
	default:
		gisregion.setVisible(true);	
		gisregion.setLineColor( v_simulationArea1LineColor );
		gisregion.setLineStyle( LINE_STYLE_SOLID );
		gisregion.setLineWidth( 1);
		gisregion.setFillColor( v_simulationArea1Color );
} 
  }

  public void f_styleGridNodes( GridNode GN ) { 

//Get selected map overlay type, based on loaded order of the radio buttons
OL_MapOverlayTypes selectedMapOverlayType;
if(rb_mapOverlay != null){
	selectedMapOverlayType = c_loadedMapOverlayTypes.get(rb_mapOverlay.getValue());
}
else{
	selectedMapOverlayType = OL_MapOverlayTypes.DEFAULT;
}
//Set the correct map overlay
switch(selectedMapOverlayType){
	case DEFAULT:
	case ELECTRICITY_CONSUMPTION:
	case PV_PRODUCTION:
		if(!b_updateLiveCongestionColors){
			switch( GN.p_nodeType ) {
				case LVLV:
					f_styleLVLV(GN.gisRegion);
					break;
				case MVLV:
					f_styleMVLV(GN.gisRegion);
					break;
				case SUBMV:
					f_styleSUBMV(GN.gisRegion);
					break;
				case MVMV:
					f_styleMVMV(GN.gisRegion);
					break;
				case HVMV:
					f_styleHVMV(GN.gisRegion);
					break;
				case HT:
					
					break;
				case MT:
					
					break;
				case LT:
					
					break;
				default:
			}
		}
		else{
			f_setColorsBasedOnCongestion_gridnodes(GN, true);
		}
		break;
	case GRID_NEIGHBOURS:
		f_setColorsBasedOnGridTopology_gridnodes(GN);
		break;
	case CONGESTION:
		f_setColorsBasedOnCongestion_gridnodes(GN, false);
		break;
	case PARKING_TYPE:
		f_setColorsBasedOnParkingType_gridnodes(GN);
		break;
	case CUSTOM:
		f_setColorsBasedOnCustom_gridnodes(GN);
		break;
} 
  }

  public void f_styleMVLV( GISRegion gisregion ) { 

gisregion.setLineStyle( LINE_STYLE_SOLID );
gisregion.setLineColor( v_MVLVLineColor );
gisregion.setLineWidth(2);		
gisregion.setFillColor(v_MVLVNodeColor); 
  }

  public void f_styleHVMV( GISRegion gisregion ) { 

gisregion.setFillColor(v_HVMVNodeColor);
gisregion.setLineStyle( LINE_STYLE_SOLID );
gisregion.setLineColor( v_HVMVLineColor );
gisregion.setLineWidth(2);
gisregion.setVisible(v_HVMVNodeIsVisible); 
  }

  public void f_setUITabs(  ) { 

//Create the tabs for the project
f_createUITabs_default();

//Initialize the uI_Tabs with the gridconnections
uI_Tabs.f_initializeUI_Tabs(energyModel.f_getGridConnectionsCollectionPointer(), energyModel.f_getPausedGridConnectionsCollectionPointer(), f_getMainInterfaceSliderEAGCs());

//Initialize sliders and start scenario with certain presets
b_runningMainInterfaceScenarios = true;
f_setSliderPresets();
b_runningMainInterfaceScenarios = false;

//Store the initial slider state for Residential areas for the scenario current button
if (project_data.project_type() == OL_ProjectType.RESIDENTIAL) {
	f_storeResidentialScenario_Current();
} 
  }

  protected void f_selectGridNode( GridNode GN ) { 

v_clickedGridNode = GN;
v_clickedObjectType = OL_GISObjectType.GRIDNODE;

//Disable the KPI summary (button)
uI_Results.getCheckbox_KPISummary().setSelected(false, true);
uI_Results.getCheckbox_KPISummary().setEnabled(false);


// Set info text
if ( GN.p_realCapacityAvailable ) {
	v_clickedObjectText = GN.p_nodeType + "-station, " + Integer.toString( ((int)GN.p_capacity_kW) ) + " kW, ID: " + GN.p_gridNodeID + ", aansluitingen: " + GN.f_getConnectedGridConnections().size() + ", Type station: " + GN.p_description;
}
else {
	v_clickedObjectText =  GN.p_nodeType + "-station, " + Integer.toString( ((int)GN.p_capacity_kW) ) + " kW (ingeschat), ID: " + GN.p_gridNodeID + ", aansluitingen: " + GN.f_getConnectedGridConnections().size() + ", Type station: " + GN.p_description;
}

// Color the GridNode
GN.gisRegion.setFillColor( v_selectionColor );
GN.gisRegion.setLineColor( orange );

// Color the connected GridConnections
for ( GridConnection GC : GN.f_getAllLowerLVLConnectedGridConnections()){
	if (GC.c_connectedGISObjects.size() == 0){
		//traceln("Gridconnection with ID " + GC.p_ownerID + " and index " + GC.getIndex() + " has no GIS building");
	}
	else {
		GC.c_connectedGISObjects.forEach(gb -> gb.f_style(v_gridNodeFeedinColor, v_gridNodeFeedinColor, 2.0, null));
	}
}

uI_Results.f_updateUIresultsGridNode(GN); 
  }

  protected void f_selectBuilding( GIS_Object b, ArrayList<GIS_Object> buildingsConnectedToSelectedGC_list ) { 

v_clickedObject = b;
c_selectedObjects = new ArrayList<GIS_Object>(buildingsConnectedToSelectedGC_list);
v_clickedObjectType = b.p_GISObjectType;

//Enable checkbox
uI_Results.getCheckbox_KPISummary().setEnabled(true);

// Color all buildings of the GridConnection associated with the selected building
//if (!c_selectedObjects.get(0).c_containedGridConnections.get(0).p_ownerID.equals("-") && !c_selectedObjects.get(0).c_containedGridConnections.get(0).p_ownerID.contains("woonfunctie") && !c_selectedObjects.get(0).c_containedGridConnections.get(0).p_ownerID.contains("Onbekend")){
	for (GIS_Object obj : c_selectedObjects) { //Buildings that are grouped, select as well.
		obj.gisRegion.setFillColor(v_selectionColorAddBuildings);
	}
//}

//Check the number of GCs in building
v_nbGridConnectionsInSelectedBuilding = b.c_containedGridConnections.size();

//Multiple GC in building: set additional adress in building info + buttons
if ( v_nbGridConnectionsInSelectedBuilding > 1 ){
	v_selectedGridConnectionIndex = 0;
	v_clickedObjectText = "Pand met " + b.c_containedGridConnections.size() + " adressen: " + b.p_id;
	gr_multipleBuildingInfo.setVisible(true);
}
else {
	String text = "";
	if (project_data.project_type() == OL_ProjectType.BUSINESSPARK) {
		if (b instanceof GIS_Building) {
			if(b.c_containedGridConnections.get(0).p_owner.p_detailedCompany){
				text = b.c_containedGridConnections.get(0).p_owner.p_actorID + ", ";
			}
			else if(b.p_annotation != null){
				text = b.p_annotation + ", ";
			}
		}
		else {
			text = b.p_id + ", ";
		}
	}
	else{
		if(b.p_annotation != null){
			text = b.p_annotation + ", ";
		}
		else{
			text = b.p_id + ", ";
		}		
	}
	
	//Set adres text
	if (c_selectedObjects.get(0).c_containedGridConnections.get(0).p_address == null || c_selectedObjects.get(0).c_containedGridConnections.get(0).p_address.getAddress() == null) {
		text = text + "Onbekend adres";
	}
	else {
		text = text + c_selectedObjects.get(0).c_containedGridConnections.get(0).p_address.getAddress();
	}
	
	v_clickedObjectText = text;
	gr_multipleBuildingInfo.setVisible(false);
}



//Update the resultsUI
f_updateUIResultsData();

//Set the button for going to the company UI (needs to be at the end of this function!)
f_setUIButton();

//alle panden met meerdere adressen hebben op dit moment (16-7-24) dezelfde functie(s) voor ieder adres, dus dit is op dit moment zinloos
//f_listFunctions();
 
  }

  protected void f_deselectPreviousSelect(  ) { 

OL_GISObjectType previousClickedObjectType = v_clickedObjectType;
List<GIS_Object> previousSelectedObjects = new ArrayList<>(c_selectedObjects);
GridNode previousClickedGridNode = v_clickedGridNode;
v_clickedObject = null;
c_selectedGridConnections.clear();
c_selectedObjects.clear();
v_clickedGridNode = null;

if(previousClickedObjectType != null){
	// Update for results_ui when deselecting objects to show entire area again as default option
	v_clickedObjectText = "None";
	v_clickedObjectType = null;
	button_goToUI.setVisible(false);
	gr_multipleBuildingInfo.setVisible(false);
	
	// We restore the colors of what we clicked on before
	if (previousClickedObjectType == OL_GISObjectType.GRIDNODE){
		f_styleGridNodes(previousClickedGridNode);
		for ( Agent agent : previousClickedGridNode.f_getAllLowerLVLConnectedGridConnections()){	
			if (agent instanceof GridConnection) {
				GridConnection GC = (GridConnection)agent;
				for (GIS_Object a : GC.c_connectedGISObjects) {
					f_styleAreas(a);
				}
			}
		}
	}
	else if (previousClickedObjectType == OL_GISObjectType.BUILDING ||
			 previousClickedObjectType == OL_GISObjectType.SOLARFARM ||
			 previousClickedObjectType == OL_GISObjectType.WINDFARM ||
			 previousClickedObjectType == OL_GISObjectType.ELECTROLYSER ||
			 previousClickedObjectType == OL_GISObjectType.BATTERY ||
			 previousClickedObjectType == OL_GISObjectType.CHARGER ||
			 previousClickedObjectType == OL_GISObjectType.PARKING){
		for(GIS_Object previousClickedObject: previousSelectedObjects){
			f_styleAreas(previousClickedObject);
		}
	}
	
	if(v_customEnergyCoop != null){
		energyModel.f_removeEnergyCoop(v_customEnergyCoop, energyModel.p_timeVariables);
		v_customEnergyCoop = null;
	}
} 
  }

  public void f_connectResultsUI(  ) { 

//Style resultsUI
f_styleResultsUI();

//Set ResultsUI radiobutton setup
List<OL_ChartTypes> selectedChartTypes_Energy = settings.resultsUISelectedChartTypes_Energy();
if(selectedChartTypes_Energy == null){ // Temporary backup till all models have switched to new setup functionality
	selectedChartTypes_Energy = f_getSelectedChartTypes_Energy();
}
List<OL_ChartTypes> selectedChartTypes_Economic = settings.resultsUISelectedChartTypes_Economic();

//Disable summary button if summary is not selected
if(settings.showKPISummary() == null || !settings.showKPISummary()){
	uI_Results.getCheckbox_KPISummary().setVisible(false);
}

//Connect resultsUI
uI_Results.f_initializeResultsUI(selectedChartTypes_Energy, selectedChartTypes_Economic);

c_UIResultsInstances.add(uI_Results); 
  }

  public void f_resetSettings(  ) { 

if(!b_runningMainInterfaceScenarios){
	b_resultsUpToDate = false;

	// Update asset flow categories of all agents
	energyModel.f_updateActiveAssetsMetaData();
	
	// Switch to the live plots and do not allow the user to switch away from the live plot when the year is not yet simulated	
	for (UI_Results ui_results : c_UIResultsInstances) {
		if (ui_results.f_getSelectedObjectData() != null) {	
			f_enableLivePlotsOnly(ui_results);
		}
	}
	
	// On all screens cover the resultsUI Buttons with the simulate year button
	f_setAllSimulateYearScreens();
	
	runSimulation();
} 
  }

  protected void f_initialPVSystemsOrder(  ) { 

List<GCHouse> houses = new ArrayList<GCHouse>(energyModel.Houses.findAll( x -> true));
List<GCHouse> housesWithoutPV = houses.stream().filter( gc -> !gc.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW) ).collect(Collectors.toList());
List<GCHouse> housesWithPV = new ArrayList<>(houses);
housesWithPV.removeAll(housesWithoutPV);

c_orderedPVSystemsHouses = new ArrayList<>(housesWithoutPV);
c_orderedPVSystemsHouses.addAll(housesWithPV);


List<GCUtility> companies = new ArrayList<GCUtility>(energyModel.UtilityConnections.findAll( x -> true));
List<GCUtility> companiesWithoutPV = companies.stream().filter( gc -> !gc.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW) ).collect(Collectors.toList());
List<GCUtility> companiesWithPV = companies.stream().filter( gc -> gc.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW) ).collect(Collectors.toList());
List<GCUtility> detailedCompaniesWithPV = companiesWithPV.stream().filter( gc -> gc.p_owner != null && gc.p_owner.p_detailedCompany ).collect(Collectors.toList());
List<GCUtility> genericCompaniesWithPV = new ArrayList<>(companiesWithPV);
genericCompaniesWithPV.removeAll(detailedCompaniesWithPV);

c_orderedPVSystemsCompanies = new ArrayList<>(companiesWithoutPV);
c_orderedPVSystemsCompanies.addAll(genericCompaniesWithPV);
c_orderedPVSystemsCompanies.addAll(detailedCompaniesWithPV);

 
  }

  void f_initialElectricVehiclesOrder(  ) { 

// First we make a copy of all the vehicle energy assets
List<J_EA> EAs = new ArrayList<>(findAll(energyModel.f_getEnergyAssets(), ea -> !(ea.getOwner() instanceof GCPublicCharger)));
EAs = EAs.stream().filter(ea -> ea instanceof I_Vehicle).collect(Collectors.toList());
// Find all the EVs at the start of the simulation
ArrayList<J_EA> otherEAs = EAs.stream().filter(ea -> !(ea instanceof J_EAEV)).collect(Collectors.toCollection(ArrayList::new));
// We make sure that the EVs at the start of the simulation are the last in the list


for(J_EA vehicle : EAs){
	if(vehicle instanceof J_EAEV && !(vehicle.getOwner() instanceof GCUtility)){ // Companies can not get lower EV then current situation
		otherEAs.add((J_EAEV) vehicle);	
	}
}

c_orderedVehicles = otherEAs; 
  }

  void f_initialHeatingSystemsOrder(  ) { 

List<GCHouse> houses = new ArrayList<GCHouse>(energyModel.Houses.findAll( x -> true));
List<GCHouse> housesWithoutHP = houses.stream().filter( gc -> gc.f_getCurrentHeatingType() != OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP ).collect(Collectors.toList());
List<GCHouse> housesWithHP = new ArrayList<>(houses);
housesWithHP.removeAll(housesWithoutHP);

c_orderedHeatingSystemsHouses = new ArrayList<>(housesWithoutHP);
c_orderedHeatingSystemsHouses.addAll(housesWithHP);

List<GCUtility> companies = new ArrayList<GCUtility>(energyModel.UtilityConnections.findAll( gc -> gc.f_getCurrentHeatingType() != OL_GridConnectionHeatingType.NONE && gc.f_getCurrentHeatingType() != OL_GridConnectionHeatingType.CUSTOM));
List<GCUtility> companiesWithoutHP = companies.stream().filter( gc -> gc.f_getCurrentHeatingType() != OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP).collect(Collectors.toList());
List<GCUtility> companiesWithHP = companies.stream().filter( gc -> gc.f_getCurrentHeatingType() == OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP ).collect(Collectors.toList());
List<GCUtility> detailedCompaniesWithHP = companiesWithHP.stream().filter( gc -> gc.p_owner != null && gc.p_owner.p_detailedCompany ).collect(Collectors.toList());
List<GCUtility> genericCompaniesWithHP = new ArrayList<>(companiesWithHP);
genericCompaniesWithHP.removeAll(detailedCompaniesWithHP);

c_orderedHeatingSystemsCompanies = new ArrayList<>(companiesWithoutHP);
c_orderedHeatingSystemsCompanies.addAll(genericCompaniesWithHP);
c_orderedHeatingSystemsCompanies.addAll(detailedCompaniesWithHP);

 
  }

  void f_initialAssetOrdering(  ) { 

f_initialElectricVehiclesOrder();
f_initialPVSystemsOrder();
f_initialPTSystemsOrder_households();
f_initialHeatingSystemsOrder();
f_initialParkingSpacesOrder();
f_initialChargerOrder();
f_initializePrivateAndPublicParkingCarsOrder();
f_initializeAdditionalVehicles();
f_projectSpecificOrderedCollectionAdjustments();

 
  }

  void f_setColorsBasedOnElectricityConsumption( GIS_Object gis_area ) { 

if(gis_area.c_containedGridConnections.size() > 0){

	double yearlyEnergyConsumption = sum( gis_area.c_containedGridConnections, x -> x.v_rapidRunData.getTotalElectricityConsumed_MWh());
	
	if ( yearlyEnergyConsumption < 10){ gis_area.f_style( rect_mapOverlayLegend_ElectricityConsumption1.getFillColor(), null, null, null);}
	else if ( yearlyEnergyConsumption < 50){ gis_area.f_style( rect_mapOverlayLegend_ElectricityConsumption2.getFillColor(), null, null, null);}
	else if ( yearlyEnergyConsumption < 150){ gis_area.f_style( rect_mapOverlayLegend_ElectricityConsumption3.getFillColor(), null, null, null);}
	else if ( yearlyEnergyConsumption < 500){ gis_area.f_style( rect_mapOverlayLegend_ElectricityConsumption4.getFillColor(), null, null, null);}
	else if ( yearlyEnergyConsumption > 500){ gis_area.f_style( rect_mapOverlayLegend_ElectricityConsumption5.getFillColor(), null, null, null);}
} 
  }

  protected void f_setColorsBasedOnProduction( GIS_Object gis_area ) { 

if (gis_area.c_containedGridConnections.size() > 0) {
	
	//Define medium PV Value
	double mediumPVValue_kWp = 100;
	if (project_data.project_type() == OL_ProjectType.RESIDENTIAL){
		mediumPVValue_kWp = 5;
	}
	
	//Calculate total pv capacity on the gis object
	double totalPVCapacity_kWp = 0;
	for(GridConnection GC : gis_area.c_containedGridConnections){
		totalPVCapacity_kWp += GC.v_liveAssetsMetaData.totalInstalledPVPower_kW;
	}
	
	//Set color of object based on total pv capacity
	if(totalPVCapacity_kWp == 0){
		gis_area.f_style(rect_mapOverlayLegend_PVProduction1.getFillColor(), null, null, null);
	}
	else if (totalPVCapacity_kWp < mediumPVValue_kWp){
		gis_area.f_style(rect_mapOverlayLegend_PVProduction2.getFillColor(), null, null, null);
	}
	else{
		gis_area.f_style(rect_mapOverlayLegend_PVProduction3.getFillColor(), null, null, null);
	}
} 
  }

  protected void f_projectSpecificSettings(  ) { 

//Should be overridden in child interface!!!
traceln("Forgot to override project specific settings!!"); 
  }

  public void f_UIStartup(  ) { 

// UI elements

//Project specific settings
f_projectSpecificSettings();

// Initialize the slider Asset Ordering lists
f_initialAssetOrdering();

//Connect the results UI
f_connectResultsUI();

//Initialize the UITabs
f_setUITabs();

//Initialize scenario radio button
f_initializeScenarioRadioButton();

//Initialize the legend
f_initializeLegend();

//Initialize map overlay buttons
f_initializeMapOverlayRadioButton();

//Set ui button visibility false at startup
f_createAdditionalUIs();
button_goToUI.setVisible(false);

//Create and set the grid topology colors (Netvlakken)
f_setGridTopologyColors();

//Disable cable button if no cables have been loaded in
if(c_LVCables.size() == 0 && c_MVCables.size() == 0){
	checkbox_cables.setVisible(false);
}

//Set order of certain layovers and submenus
f_initializePresentationOrder();

//Set to public model version styling if activated
if(settings.isPublicModel() || user.GCAccessType != OL_UserGCAccessType.FULL){
	f_changeDefaultColorOfPrivateGC();
}

//Turn on update of live congestion colloring
b_updateLiveCongestionColors = true;

//Set filter combo box options
f_setFilterComboBoxOptions(); 
  }

  /**
   * Functino used by the loader to create new GIS objects on the GIS map
   */
  public 
GISRegion 
 f_createGISObject( double[] gisTokens ) { 

GISRegion gisregion = new GISRegion(map, gisTokens);
return gisregion; 
  }

  protected void f_enableTraceln( PrintStream originalPrintStream ) { 

System.setOut(originalPrintStream); 
  }

  protected 
PrintStream 
 f_disableTraceln(  ) { 

PrintStream originalPrintStream = System.out;

System.setOut(new PrintStream(new OutputStream() {
        public void write(int b) {
        }
    }));
return originalPrintStream; 
  }

  void f_setColorsBasedOnConsumptionProfileHouseholds( GIS_Object gis_area ) { 

double yearlyElectricityConsumption_kWh = 0;
for( GridConnection gc : gis_area.c_containedGridConnections){
	if(gc.v_rapidRunData != null){
		yearlyElectricityConsumption_kWh += gc.v_rapidRunData.getTotalElectricityConsumed_MWh()*1000;
	}
	else{
		for ( J_EAConsumption consumptionAsset : gc.c_consumptionAssets){
			if( consumptionAsset.getEAType() == OL_EnergyAssetType.ELECTRICITY_DEMAND ){
				yearlyElectricityConsumption_kWh += consumptionAsset.getBaseConsumption_kWh();
			}
		}
	}
}

if ( yearlyElectricityConsumption_kWh == 0) { gis_area.f_style( v_unknownConsumptionColor, null, null, null );}
else if ( yearlyElectricityConsumption_kWh < 1500){ gis_area.f_style( rect_mapOverlayLegend_ElectricityConsumption1.getFillColor(), null, null, null);}
else if ( yearlyElectricityConsumption_kWh < 2500){ gis_area.f_style( rect_mapOverlayLegend_ElectricityConsumption2.getFillColor(), null, null, null);}
else if ( yearlyElectricityConsumption_kWh < 4000){ gis_area.f_style( rect_mapOverlayLegend_ElectricityConsumption3.getFillColor(), null, null, null);}
else if ( yearlyElectricityConsumption_kWh < 6000){ gis_area.f_style( rect_mapOverlayLegend_ElectricityConsumption4.getFillColor(), null, null, null);}
else if ( yearlyElectricityConsumption_kWh > 6000){ gis_area.f_style( rect_mapOverlayLegend_ElectricityConsumption5.getFillColor(), null, null, null);}
	
 
  }

  protected void f_updateMainInterfaceSliders(  ) { 

uI_Tabs.f_updateSliders();

if(uI_EnergyHub != null){
	uI_EnergyHub.uI_Tabs.f_updateSliders();
} 
  }

  void f_setColorsBasedOnGridTopology_objects( GIS_Object gis_area ) { 

if (gis_area.c_containedGridConnections.size() > 0) {
	Color color = gis_area.c_containedGridConnections.get(0).p_parentNodeElectric.p_uniqueColor;
	for(GridConnection GC : gis_area.c_containedGridConnections){
		if(GC.p_owner.p_detailedCompany){
			color = GC.p_parentNodeElectric.p_uniqueColor;
		}
	}
	gis_area.f_style(color, black, 1.0, null);
} 
  }

  void f_getWeatherInfo(  ) { 

v_outsideTemperature = roundToDecimal(energyModel.pp_ambientTemperature_degC.getCurrentValue(), 1);
v_solarIrradiance = roundToInt(energyModel.pp_PVProduction35DegSouth_fr.getCurrentValue() * 1000);

double windspeed = roundToDecimal(energyModel.pp_windProduction_fr.getCurrentValue(), 1);
if (windspeed < 0.2){
	v_windspeed = "Laag";
}
else if (windspeed < 0.6){
	v_windspeed = "Midden";
}
else if (windspeed < 0.8){
	v_windspeed = "Hoog";
}
else {
	v_windspeed = "Zeer hoog";
} 
  }

  protected void f_updateUIResultsData(  ) { 

for (GridConnection gc : c_selectedObjects.get(0).c_containedGridConnections) {
	if (!c_selectedGridConnections.contains(gc)) {
		c_selectedGridConnections.add(gc);
	}
}

if(c_selectedGridConnections.size()>1){
	v_customEnergyCoop = energyModel.f_addEnergyCoop(c_selectedGridConnections, energyModel.p_timeParameters);
	uI_Results.f_updateResultsUI(v_customEnergyCoop);
}
else{
	uI_Results.f_updateResultsUI(c_selectedGridConnections.get(0));
}
 
  }

  public void f_setGridTopologyColors(  ) { 

//Find all MV substations
List<GridNode> MVsubstations = findAll(energyModel.pop_gridNodes, GN -> GN.p_nodeType == OL_GridNodeType.SUBMV);

if(MVsubstations.size() > 0 || project_data.project_type() == OL_ProjectType.RESIDENTIAL){
	b_gridLoopsAreDefined = true;
}

v_amountOfDefinedGridLoops = 0;

if(MVsubstations != null){
	//Set all unique grid topology colors for each substation and its children if the gridloops are defined
	for (GridNode MVsub : MVsubstations){
		
		//Create a unique color from a spectrum and assign it to the subMV
		MVsub.p_uniqueColor = spectrumColor(v_amountOfDefinedGridLoops, MVsubstations.size());
		
		//Assign unique color to all underlying grid nodes
		MVsub.f_getLowerLVLConnectedGridNodes().forEach(GN -> GN.p_uniqueColor = MVsub.p_uniqueColor);
		
		//Update spectrum color index and total defined colours
		v_amountOfDefinedGridLoops++;
	}
}
else if(project_data.project_type() == OL_ProjectType.RESIDENTIAL){
	int totalNotToplevelGridNodes = energyModel.f_getGridNodesNotTopLevel().size();
	//Set all unique grid topology colors for each substation and its children if the gridloops are defined
	for (GridNode node : energyModel.f_getGridNodesNotTopLevel()){
		
		//Create a unique color from a spectrum and assign it to the subMV
		node.p_uniqueColor = spectrumColor(v_amountOfDefinedGridLoops, totalNotToplevelGridNodes);

		//Update spectrum color index and total defined colours
		v_amountOfDefinedGridLoops++;
	}
} 
  }

  public void f_styleSUBMV( GISRegion gisregion ) { 

gisregion.setVisible(false); 
  }

  public void f_styleMVMV( GISRegion gisregion ) { 

gisregion.setFillColor(v_MVMVNodeColor);
gisregion.setLineStyle( LINE_STYLE_SOLID );
gisregion.setLineColor( v_MVMVLineColor );
gisregion.setLineWidth(2); 
  }

  protected void f_listFunctions(  ) { 

if(c_selectedObjects.get(0).c_containedGridConnections.size() > 1){
	HashMap<String, Integer> functionsList = new HashMap<String, Integer>();
	
	for (int i = 0; i < c_selectedObjects.get(0).c_containedGridConnections.size(); i++) {
		//split functies als er meerdere zijn
		String[] splitFunctions = c_selectedObjects.get(0).c_containedGridConnections.get(i).p_purposeBAG.split(",");
		
		for (int j = 0; j < splitFunctions.length; j++) {
			// als de key al bestaat, itereer
			if (functionsList.get(splitFunctions[j]) != null) {
				functionsList.put(splitFunctions[j], functionsList.get(splitFunctions[j]) + 1);
			}
			// zo niet, voeg toe
			else {
				functionsList.put(splitFunctions[j],1);
			}
		}
	}
	
	/*
	for (String i : functionsList.keySet()) {
		traceln(i + ": " + functionsList.get(i));
	}
	*/
} 
  }

  protected void f_setUIButton(  ) { 

switch(v_clickedObjectType){

case BUILDING:
	if (c_selectedGridConnections.size() > 1 || !(c_selectedGridConnections.get(0) instanceof GCUtility) || !c_selectedGridConnections.get(0).v_isActive){
		button_goToUI.setVisible(false);
	}
	else{
		button_goToUI.setText("Ga naar het Bedrijfsportaal");
		button_goToUI.setVisible(true);
	}
	break;
	
case ELECTROLYSER:
	button_goToUI.setText("Ga naar het Waterstof Dashboard");
	button_goToUI.setVisible(true);
	break;
	
case BATTERY:
	button_goToUI.setText("Ga naar het Batterijen Dashboard");
	button_goToUI.setVisible(true);
	break;	

case CHARGER:
	button_goToUI.setVisible(false);
	break;
	
default:
	button_goToUI.setVisible(false);
	break;
}
 
  }

  public 
GISRoute 
 f_createGISLine( double[] GISCoords, OL_GISObjectType objectType ) { 


Curve curve = new Curve();
for(int i = 0; i+3 < GISCoords.length; i += 2){
	GISMarkupSegmentLine segment = new GISMarkupSegmentLine(GISCoords[i], GISCoords[i+1], GISCoords[i+2], GISCoords[i+3]);
	curve.addSegment(segment);
}

//Create route (line)
GISRoute gisroute = new GISRoute(map, curve, true);

//Object styling
switch(objectType){

	case LV_CABLE:
		c_LVCables.add(gisroute);
		//Styling
		gisroute.setLineStyle(LINE_STYLE_SOLID);
		gisroute.setLineWidth(0.8);
		gisroute.setLineColor(v_LVGridColor);
		gisroute.setVisible(false);
		break;
		
	case MV_CABLE:
		c_MVCables.add(gisroute);
		//Styling
		gisroute.setLineStyle(LINE_STYLE_SOLID);
		gisroute.setLineWidth(1);
		gisroute.setLineColor(v_MVGridColor);
		gisroute.setVisible(false);
		break;
}

return gisroute;
 
  }

  void f_setColorsBasedOnGridTopology_gridnodes( GridNode GN ) { 

if(GN.gisRegion != null){
	GN.gisRegion.setFillColor(GN.p_uniqueColor);
	GN.gisRegion.setLineColor(GN.p_uniqueColor.brighter());
} 
  }

  protected void f_setSliderPresets(  ) { 

//Should be overridden in child interface!!!
traceln("Forgot to override project specific slider settings!!"); 
  }

  public void f_projectSpecificStyling(  ) { 

//Function used to set the colors, styling, and other parameters/functions for each specific project
//Should be overridden!!
traceln("DID NOT OVERRIDE THE PROJECT SPECIFIC STYLING!"); 
  }

  protected void f_projectSpecificOrderedCollectionAdjustments(  ) { 

//Function that can be used to make project specific adjustments to the ordered collection
//SHOULD BE OVERRIDEN IF YOU WANT TO USE THIS 
  }

  protected void f_applyFilter( OL_FilterOptionsGC selectedFilter, String selectedFilterName ) { 

c_selectedFilterOptions.add(selectedFilter);

ArrayList<GridConnection> toBeFilteredGC = new ArrayList<GridConnection>();

if(c_selectedFilterOptions.size()>1 && c_selectedGridConnections.size()> 0){ // Already filtering
	toBeFilteredGC = new ArrayList<GridConnection>(c_selectedGridConnections);
}
else{ // First filter
	toBeFilteredGC = new ArrayList<GridConnection>(energyModel.f_getActiveGridConnections());
}

//After a filter selecttion, reset previous clicked building/gridNode colors and text
f_deselectPreviousSelect();


//Can filter return 0? (Only allowed for filters who are not inmediately active (gridLoops, nbh, etc.)
boolean filterCanReturnZero = false;

switch(selectedFilter){
	case COMPANIES:
		f_filterCompanies(toBeFilteredGC);
		break;
		
	case HOUSES:
		f_filterHouses(toBeFilteredGC);
		break;
		
	case DETAILED:
		f_filterDetailed(toBeFilteredGC);
		break;
		
	case NONDETAILED:
		f_filterEstimated(toBeFilteredGC);
		break;
		
	case HAS_PV:
		f_filterHasPV(toBeFilteredGC);
		break;
		
	case HAS_TRANSPORT:
		f_filterHasTransport(toBeFilteredGC);
		break;
		
	case HAS_EV:
		f_filterHasEV(toBeFilteredGC);
		break;	
		
	case GRIDTOPOLOGY_SELECTEDLOOP:
		if(!c_filterSelectedGridLoops.isEmpty()){
			f_filterGridLoops(toBeFilteredGC);
		}
		else{
		
			f_setForcedClickScreenText("Selecteer een lus");
			if(!b_inEnergyHubSelectionMode){
				f_setForcedClickScreenVisibility(true);
			}

			if(c_loadedMapOverlayTypes.contains(OL_MapOverlayTypes.GRID_NEIGHBOURS)){
				rb_mapOverlay.setValue(c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.GRID_NEIGHBOURS),true);			
			}
			if(c_selectedFilterOptions.size() > 1){
				c_selectedGridConnections = new ArrayList<>(toBeFilteredGC);	
			}
			else{
				filterCanReturnZero = true;
			}
		}
		break;
		
	case SELECTED_NEIGHBORHOOD:
		if(!c_filterSelectedNeighborhoods.isEmpty()){
			f_filterNeighborhoods(toBeFilteredGC);
		}
		else{
			f_setForcedClickScreenText("Selecteer een buurt");
			if(!b_inEnergyHubSelectionMode){
				f_setForcedClickScreenVisibility(true);
			}
			if(c_selectedFilterOptions.size() > 1){
				c_selectedGridConnections = new ArrayList<>(toBeFilteredGC);
			}
			else{
				filterCanReturnZero = true;
			}
		}
		break;
	case MANUAL_SELECTION:
		if(c_manualFilterSelectedGC.size() > 0){
			f_filterManualSelection(toBeFilteredGC);
		}
		else if(c_selectedFilterOptions.size() > 1){ 
			if(c_manualFilterDeselectedGC.size() > 0){
				f_filterManualSelection(toBeFilteredGC);
			}
			else{
				c_selectedGridConnections = new ArrayList<>(toBeFilteredGC);
			}
		}
		else{
			filterCanReturnZero = true;
		}
			
		break;
}

if(c_selectedGridConnections.size() == 0 && !filterCanReturnZero){ // Not allowed to return zero, while returning zero
	f_removeFilter(selectedFilter, selectedFilterName);
	
	//Notify filter has not been applied, cause no results are given
	f_setErrorScreen("Geselecteerde filter geeft geen resultaten. De filter is gedeactiveerd.", 0, 0);
}
else if(c_selectedGridConnections.size() == 0 && filterCanReturnZero){//Allowed to return zero filtered gc, while returning zero
	//Do nothing
}
else{//Filtered GC returns GC

	//Set color of all gis objects of new filter selection
	v_clickedObjectType = OL_GISObjectType.BUILDING;
		
	for (GridConnection GC: c_selectedGridConnections){
		for (GIS_Object objectGIS : GC.c_connectedGISObjects) {
			objectGIS.gisRegion.setFillColor(v_selectionColorAddBuildings);
			c_selectedObjects.add(objectGIS);
		}
	}
	
	//Set graphs	
	if(c_selectedGridConnections.size()>1){
		v_customEnergyCoop = energyModel.f_addEnergyCoop(c_selectedGridConnections, energyModel.p_timeParameters);
		uI_Results.f_updateResultsUI(v_customEnergyCoop);
	}
	else{
		uI_Results.f_updateResultsUI(c_selectedGridConnections.get(0));
	}			
} 
  }

  protected void f_setFilter( OL_FilterOptionsGC selectedFilter ) { 

String selectedFilterName = map_filterOptionUINames.get(selectedFilter);

//Remove manual filter first
if(selectedFilter != OL_FilterOptionsGC.MANUAL_SELECTION && c_selectedFilterOptions.contains(OL_FilterOptionsGC.MANUAL_SELECTION)){
	button_removeManualSelection.action();
}

if(!c_selectedFilterOptions.contains(selectedFilter)){ // Set filter
	traceln("Geselecteerde filter ( " + selectedFilterName + " ) toegevoegd.");
	t_activeFilters.setText( t_activeFilters.getText() + selectedFilterName + "\n");
	f_applyFilter(selectedFilter, selectedFilterName);
}
else if(c_selectedFilterOptions.contains(selectedFilter)){ // Remove filter
	f_removeFilter(selectedFilter, selectedFilterName);
} 
  }

  protected void f_removeAllFilters(  ) { 

c_selectedFilterOptions.clear();
t_activeFilters.setText("");

//Deselect everything and set region as main
f_clearSelectionAndSelectEnergyModel(); 
  }

  protected void f_selectGridLoop( double clickx, double clicky ) { 


//Check if click was on Building, if yes, select grid building
for ( GIS_Building b : energyModel.pop_GIS_Buildings ){
	if( b.gisRegion != null && b.gisRegion.contains(clickx, clicky) ){
		if (b.gisRegion.isVisible()) { //only allow us to click on visible objects
			if (b.c_containedGridConnections.size() > 0 ) { // only allow buildings with gridconnections
				GridConnection clickedGridConnection = b.c_containedGridConnections.get(0); // Find buildings powered by the same GC as the clicked building
				GridNode clickedGridConnectionConnectedGridNode = clickedGridConnection.p_parentNodeElectric;
				ArrayList<GridNode> allGridNodes = new ArrayList<GridNode>(energyModel.f_getGridNodesTopLevel());
				allGridNodes.addAll(energyModel.f_getGridNodesNotTopLevel());
				
				while(	clickedGridConnectionConnectedGridNode.p_parentNodeID != null && 
					  	clickedGridConnectionConnectedGridNode.p_nodeType != OL_GridNodeType.SUBMV &&
					  	clickedGridConnectionConnectedGridNode.p_nodeType != OL_GridNodeType.MVMV &&
					  	clickedGridConnectionConnectedGridNode.p_nodeType != OL_GridNodeType.HVMV
					  	){
					String parentNodeName = clickedGridConnectionConnectedGridNode.p_parentNodeID;
					if(parentNodeName != null && !parentNodeName.equals("-") && !parentNodeName.equals("")){
						clickedGridConnectionConnectedGridNode = findFirst(allGridNodes, GN -> GN.p_gridNodeID.equals(parentNodeName));
					}
					else{ // At top node --> select the directly attached grid node instead, and break out of while loop.
						clickedGridConnectionConnectedGridNode = clickedGridConnection.p_parentNodeElectric;
						break;
					}
				}	
				
				//This deselect the previous selection of gridloops
				f_setFilter(OL_FilterOptionsGC.GRIDTOPOLOGY_SELECTEDLOOP);
				
				if(c_filterSelectedGridLoops.contains(clickedGridConnectionConnectedGridNode)){
					c_filterSelectedGridLoops.remove(clickedGridConnectionConnectedGridNode);
				}
				else{
					c_filterSelectedGridLoops.add(clickedGridConnectionConnectedGridNode);
				}
			
				if(gr_forceMapSelection.isVisible()){
					f_setForcedClickScreenText("");
					if(!b_inEnergyHubSelectionMode){
						f_setForcedClickScreenVisibility(false);
					}
				}
				
				//This selects the new selection of gridloops
				f_setFilter(OL_FilterOptionsGC.GRIDTOPOLOGY_SELECTEDLOOP);
				
				return;
				
			}
		}
	}
}
 
  }

  protected void f_filterCompanies( ArrayList<GridConnection> toBeFilteredGC ) { 

c_selectedGridConnections = new ArrayList<>(findAll(toBeFilteredGC, GC -> GC instanceof GCUtility));

 
  }

  protected void f_filterHouses( ArrayList<GridConnection> toBeFilteredGC ) { 

c_selectedGridConnections = new ArrayList<>(findAll(toBeFilteredGC, GC -> GC instanceof GCHouse));

 
  }

  protected void f_filterDetailed( ArrayList<GridConnection> toBeFilteredGC ) { 

c_selectedGridConnections = new ArrayList<>(findAll(toBeFilteredGC, GC -> GC.p_owner.p_detailedCompany));
 
  }

  protected void f_filterEstimated( ArrayList<GridConnection> toBeFilteredGC ) { 

c_selectedGridConnections = new ArrayList<>(findAll(toBeFilteredGC, GC -> !GC.p_owner.p_detailedCompany));
 
  }

  protected void f_filterHasPV( ArrayList<GridConnection> toBeFilteredGC ) { 

c_selectedGridConnections = new ArrayList<>();
for(GridConnection GC : toBeFilteredGC){ //Find all GC with PV AND a gis region (to prevent selecting slider PVGC)
	if(GC.c_connectedGISObjects.size() > 0 && GC.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW)){
		c_selectedGridConnections.add(GC);
	}
} 
  }

  protected void f_filterHasTransport( ArrayList<GridConnection> toBeFilteredGC ) { 

c_selectedGridConnections = new ArrayList<>(findAll(toBeFilteredGC, GC -> GC.c_vehicleAssets.size() > 0));

 
  }

  protected void f_removeFilter( OL_FilterOptionsGC selectedFilter, String selectedFilterName ) { 

c_selectedFilterOptions.remove(selectedFilter);

ArrayList<OL_FilterOptionsGC> toBeReappliedFilters = new ArrayList<OL_FilterOptionsGC>(c_selectedFilterOptions);
c_selectedFilterOptions.clear();

if(toBeReappliedFilters.size() > 0){
	for(OL_FilterOptionsGC filterOption : toBeReappliedFilters){
		f_applyFilter(filterOption, selectedFilterName);
	}
	String toBeAdjustedFilterText = t_activeFilters.getText();
	String newActiveFilterText = toBeAdjustedFilterText.replace(selectedFilterName + "\n", "");
	t_activeFilters.setText(newActiveFilterText);
	
	traceln("Filter ( " + selectedFilterName + " ) is verwijderd.");
}
else{ // All filters removed
	traceln("Filter ( " + selectedFilterName + " ) is verwijderd.");
	f_removeAllFilters();
} 
  }

  protected void f_filterGridLoops( ArrayList<GridConnection> toBeFilteredGC ) { 

HashSet<GridConnection> gridConnectionsOnLoop = new HashSet<GridConnection>();

for(GridNode GridLoop : c_filterSelectedGridLoops)
	if(b_gridLoopsAreDefined){
		OL_GridNodeType loopTopNodeType= GridLoop.p_nodeType;
		switch(loopTopNodeType){
			case MVLV:
				for(GridConnection GC : GridLoop.f_getConnectedGridConnections()){
					if(toBeFilteredGC.contains(GC)){
						gridConnectionsOnLoop.add(GC);
					}
				}
				break;
			case SUBMV:
				for(GridConnection GC : GridLoop.f_getAllLowerLVLConnectedGridConnections()){
					if(toBeFilteredGC.contains(GC)){
						gridConnectionsOnLoop.add(GC);
					}
				}
				break;
			
			case MVMV:
				for(GridConnection GC : GridLoop.f_getConnectedGridConnections()){
					if(toBeFilteredGC.contains(GC)){
						gridConnectionsOnLoop.add(GC);
					}
				}
				
				break;
				
			case HVMV:
				for(GridConnection GC : GridLoop.f_getConnectedGridConnections()){
					if(toBeFilteredGC.contains(GC)){
						gridConnectionsOnLoop.add(GC);
					}
				}
				break;
		}
	}
	else{
		for(GridConnection GC : GridLoop.f_getAllLowerLVLConnectedGridConnections()){
			if(toBeFilteredGC.contains(GC)){
				gridConnectionsOnLoop.add(GC);
			}
		}
	}

c_selectedGridConnections = new ArrayList<>(gridConnectionsOnLoop); 
  }

  public void f_setErrorScreen( String errorMessage, double xOffset, double yOffset ) { 

gr_errorScreen.setPos(xOffset, yOffset);

//Reset location and height
button_errorOK.setY(550);
rect_errorMessage.setY(380);
rect_errorMessage.setHeight(200);
t_errorMessage.setY(430);

//Set position above all other things
f_setShapePresentationOnTop(gr_errorScreen);

int width_numberOfCharacters = 44;

// Set Text
Pair<String, Integer> p = v_infoText.restrictWidth(errorMessage, width_numberOfCharacters);
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

  protected void f_styleResultsUI(  ) { 

uI_Results.f_styleResultsUIHeader(zenmocolor_blue3.getFillColor(), zenmocolor_blue3.getFillColor(), 1.0, LINE_STYLE_SOLID);
uI_Results.f_styleAllCharts(v_backgroundColor, zenmocolor_blue3.getFillColor(), 1.0, LINE_STYLE_SOLID); 
  }

  protected void f_selectNeighborhood( double clickx, double clicky ) { 


//Check if click was on Building, if yes, select grid building
for ( GIS_Object region : c_GISNeighborhoods ){
	if( region.gisRegion != null && region.gisRegion.contains(clickx, clicky) ){
		if (region.gisRegion.isVisible()) { //only allow us to click on visible objects	
				
			GIS_Object clickedNeighborhood = region;
			

			//This deselects the previous selected neighborhood filter
			f_setFilter(OL_FilterOptionsGC.SELECTED_NEIGHBORHOOD);
			
			if(c_filterSelectedNeighborhoods.contains(clickedNeighborhood)){
				c_filterSelectedNeighborhoods.remove(clickedNeighborhood);
			}
			else{
				c_filterSelectedNeighborhoods.add(clickedNeighborhood);
			}

			if(gr_forceMapSelection.isVisible()){
				f_setForcedClickScreenText("");
				if(!b_inEnergyHubSelectionMode){
					f_setForcedClickScreenVisibility(false);
				}
			}
			//This sets the new selected neighborhoods filter
			f_setFilter(OL_FilterOptionsGC.SELECTED_NEIGHBORHOOD);
			
			return;	
		}
	}
}
 
  }

  protected void f_filterNeighborhoods( ArrayList<GridConnection> toBeFilteredGC ) { 

ArrayList<GridConnection> gridConnectionsInNeighborhood = new ArrayList<GridConnection>();

for(GridConnection GC : toBeFilteredGC){
	for(GIS_Object nbh : c_filterSelectedNeighborhoods)
		if( nbh.gisRegion.contains(GC.p_latitude, GC.p_longitude) ){
			gridConnectionsInNeighborhood.add(GC);
		}
}

//If NBH results in zero GC, remove last added nbh
if(gridConnectionsInNeighborhood.isEmpty() && !c_filterSelectedNeighborhoods.isEmpty()){
	c_filterSelectedNeighborhoods.remove(c_filterSelectedNeighborhoods.size() - 1);
}

c_selectedGridConnections = new ArrayList<>(gridConnectionsInNeighborhood); 
  }

  protected void f_enableLivePlotsOnly( UI_Results resultsUI ) { 

if (resultsUI.f_getSelectedObjectData() != null) {
	if(resultsUI.getGr_resultsUIHeader().isVisible()){
		if(resultsUI.getResultsUIModeRadioButtons() != null){
			resultsUI.getResultsUIModeRadioButtons().setValue(0, true);
		}
		resultsUI.getEnergyRadioButtons().setValue(0, true);
	}
	resultsUI.chartProfielen.getPeriodRadioButton().setValue(0, true);
	resultsUI.f_enableNonLivePlotRadioButtons(false);
}
for (ShapeRadioButtonGroup rb :resultsUI.chartProfielen.getAllPeriodRadioButtons()) {
	rb.setValue(0, false);
}
resultsUI.chartProfielen.getPeriodRadioButton().setValue(0, true);

resultsUI.f_enableNonLivePlotRadioButtons(false); 
  }

  protected void f_filterManualSelection( ArrayList<GridConnection> toBeFilteredGC ) { 

ArrayList<GridConnection> resultingGridConnectionSelection = new ArrayList<GridConnection>();

if(c_selectedFilterOptions.size() > 1){
	resultingGridConnectionSelection.addAll(toBeFilteredGC);
}
else{//Manual selection is the only active filter -> Resulting grid connection selection should start empty
}

for(GridConnection manualSelectedGC : c_manualFilterSelectedGC){
	if(!resultingGridConnectionSelection.contains(manualSelectedGC)){
		resultingGridConnectionSelection.add(manualSelectedGC);
	}
}
for(GridConnection manualDeselectedGC : c_manualFilterDeselectedGC){
	if(resultingGridConnectionSelection.contains(manualDeselectedGC)){
		resultingGridConnectionSelection.remove(manualDeselectedGC);
	}
}


c_selectedGridConnections = new ArrayList<>(resultingGridConnectionSelection); 
  }

  protected void f_selectManualFilteredGC( double clickx, double clicky ) { 

//Initialize clickedObject
GIS_Object clickedObject = null;

//Check if click was on Building, if yes, select building
for ( GIS_Object object : energyModel.pop_GIS_Buildings ){//pop_GIS_Buildings
	if( object.gisRegion != null && object.gisRegion.contains(clickx, clicky) ){
		if (object.gisRegion.isVisible()) { //only allow us to click on visible objects	
			if (object.c_containedGridConnections.size() > 0 ){
				clickedObject = object;
				break;
			}
		}
	}
}

//If click was not on a building, check if click was on an EA, if yes, select EA
if(clickedObject == null){
	for ( GIS_Object object : energyModel.pop_GIS_Objects ){//pop_GIS_Buildings
		if( object.gisRegion != null && object.gisRegion.contains(clickx, clicky) ){
			if (object.gisRegion.isVisible()) { //only allow us to click on visible objects	
				if (object.c_containedGridConnections.size() > 0 ){
					clickedObject = object;
					break;
				}
			}
		}
	}
}

//If a building or EA has been selected perform click functionality
if(clickedObject != null){
	boolean select = true; // Deselect == false;
	boolean removedFromSelectedGC = false;
	boolean removedFromDeselectedGC = false;

	ArrayList<GridConnection> clickedGridConnections = new ArrayList<GridConnection>(clickedObject.c_containedGridConnections);
	
	for (GridConnection clickedGC : clickedGridConnections){
		if(c_selectedGridConnections.contains(clickedGC)){
			c_selectedGridConnections.remove(clickedGC);
			select = false;
		}
		
		if(c_manualFilterSelectedGC.contains(clickedGC)){
			c_manualFilterSelectedGC.remove(clickedGC);
		}
		else if(c_manualFilterDeselectedGC.contains(clickedGC)){
			c_manualFilterDeselectedGC.remove(clickedGC);
		}
	}
	
	if(select){
		c_selectedGridConnections.addAll(clickedGridConnections);
		c_manualFilterSelectedGC.addAll(clickedGridConnections);
		traceln("Handmatig geselecteerd object toegevoegd aan selectie");
	}
	else{
		c_manualFilterDeselectedGC.addAll(clickedGridConnections);
		traceln("Handmatig geselecteerd object verwijderd van selectie");
	}
	
	
	//Disable traceln
	PrintStream originalPrintStream = f_disableTraceln();
	
	//This deactivates the previous selection
	f_setFilter(OL_FilterOptionsGC.MANUAL_SELECTION);
				
	//This activates the new selection
	f_setFilter(OL_FilterOptionsGC.MANUAL_SELECTION);
	
	//Enable traceln
	f_enableTraceln(originalPrintStream);
	
	return;
} 
  }

  protected void f_setForcedClickScreenText( String forcedClickScreenText ) { 

t_forcedClickMessage.setText(forcedClickScreenText);

if(t_forcedClickMessage.getText().equals("")){
	gr_ForceMapSelectionText.setVisible(false);
}
else{
	gr_ForceMapSelectionText.setVisible(true);
} 
  }

  void f_setMapViewBounds( List<GIS_Object> GISObjects ) { 

// Initialize min and max values
double minLat = Double.MAX_VALUE;
double maxLat = Double.MIN_VALUE;
double minLon = Double.MAX_VALUE;
double maxLon = Double.MIN_VALUE;
 
// Loop through all GISRegions and find the bounding box
for(GIS_Object go : GISObjects){
	
	GISRegion region = go.gisRegion;
    double[] points = region.getPoints(); // Get the boundary points of the region
 
    for (int i = 0; i < points.length; i += 2) { // i+=2 because data is in lat, lon pairs
        double lat = points[i];       // Latitude
        double lon = points[i + 1];   // Longitude
 
 
 
        // Update min/max latitude and longitude
        minLat = Math.min(minLat, lat);
        maxLat = Math.max(maxLat, lat);
        minLon = Math.min(minLon, lon);
        maxLon = Math.max(maxLon, lon);
    }
}

//Make it slightly bigger, so it isnt exact on the line of the regions
minLat = minLat - 0.0001;
maxLat = maxLat + 0.0001;
minLon = minLon - 0.0001;
maxLon = maxLon + 0.0001;
        
// Set the map to fit the calculated bounds
map.fitBounds(minLat, minLon, maxLat, maxLon); 
  }

  public void f_setStartView(  ) { 

//traceln("f_setStartView() reached!");

if(project_data.map_centre_latitude() != null && project_data.map_centre_longitude() != null && project_data.map_centre_latitude() != 0 && project_data.map_centre_longitude() != 0){
	map.setCenterLatitude(project_data.map_centre_latitude());
	map.setCenterLongitude(project_data.map_centre_longitude());
}
else{
	ArrayList<GIS_Object> gisObjects_for_mapViewBounds = new ArrayList<GIS_Object>();
	if((settings.subscopesToSimulate() == null || settings.subscopesToSimulate().size() == 0) && findAll(energyModel.pop_GIS_Objects, gisObject -> gisObject.p_GISObjectType == OL_GISObjectType.REGION).size() > 0){
		gisObjects_for_mapViewBounds.addAll(findAll(energyModel.pop_GIS_Objects, gisObject -> gisObject.p_GISObjectType == OL_GISObjectType.REGION));
	}
	else{
		for (GIS_Object building : energyModel.pop_GIS_Buildings) {
			if(building.gisRegion.isVisible()){
				gisObjects_for_mapViewBounds.add(building);
			}
		}
	}
	f_setMapViewBounds(gisObjects_for_mapViewBounds);
}

if(project_data.map_scale() != null){
	map.setMapScale(project_data.map_scale());
}

va_Interface.navigateTo();
v_currentViewArea = va_Interface; 
  }

  public void f_setInfoText( ShapeImage infoBubble, String descriptionText, double xPosition, double yPosition ) { 

if ( p_currentActiveInfoBubble.size() > 0 && p_currentActiveInfoBubble.get(0) == infoBubble ) {
	// If we click a second time on the same bubble it should close the window
	p_currentActiveInfoBubble.clear();
	gr_infoText.setVisible(false);
}
else {
	p_currentActiveInfoBubble.clear();
	p_currentActiveInfoBubble.add(infoBubble);
	
	int width_ch = 50;
	// Set Text
	Pair<String, Integer> p = v_infoText.restrictWidth(descriptionText, width_ch);
	t_infoTextDescription.setText(p.getFirst());
	
	// Set Size
	rect_infoText.setWidth(width_ch * 7.5); // about 7.5 px per char for sans serif 14 pt
	rect_infoText.setHeight(50 + p.getSecond() * 20); // about 50 px for title and 20 px per line for sans serif 14 pt

	// Set Position
	// The group position is on the top left, not the centre.
	double margin_px = 15;
	//double posX = f_getAbsolutePosition(infoBubble).getX();
	//double posY = f_getAbsolutePosition(infoBubble).getY();
	if (xPosition < (v_currentViewArea.getX() + v_currentViewArea.getWidth()/2) ) {
		// bubble is on the left half, so text should appear to the right
		gr_infoText.setX( xPosition + margin_px + infoBubble.getWidth()/2);
	}
	else {
		// bubble is on the right half, so text should appear to the left
		gr_infoText.setX( xPosition - margin_px + infoBubble.getWidth()/2 - rect_infoText.getWidth());
	}
	
	// In AnyLogic the Y-Axis is inverted
	if (yPosition > (v_currentViewArea.getY() + v_currentViewArea.getHeight()/2) ) {
		// bubble is on the bottom half, so text should appear above
		gr_infoText.setY( yPosition - margin_px + infoBubble.getHeight()/2 - rect_infoText.getHeight());
	}
	else {
		// bubble is on the top half, so text should appear below
		gr_infoText.setY( yPosition + margin_px + infoBubble.getHeight()/2);
	}
	
	// Position of close button
	gr_closeInfoText.setX( width_ch * 7.5 - 20 ); // 20 px offset from the right hand side
	
	gr_infoText.setVisible(true);
} 
  }

  void f_changeDefaultColorOfPrivateGC(  ) { 

for(GIS_Object object : energyModel.pop_GIS_Objects){
	for(GridConnection GC : object.c_containedGridConnections){
		if(!GC.p_owner.b_dataIsAccessible){
			object.p_defaultFillColor = transparent(object.p_defaultFillColor, 0.6);//v_dataSharingDisagreedColor;
			object.p_defaultLineStyle = LINE_STYLE_DOTTED;
			object.f_style(null, null, null, null);
			break;
		}
	}
}

for(GIS_Building building : energyModel.pop_GIS_Buildings){
	for(GridConnection GC : building.c_containedGridConnections){
		if(!GC.p_owner.b_dataIsAccessible){
			building.p_defaultFillColor = transparent(building.p_defaultFillColor, 0.6);//v_dataSharingDisagreedColor;
			building.p_defaultLineStyle = LINE_STYLE_DOTTED;
			building.f_style(null, null, null, null);
			break;
		}
	}
} 
  }

  void f_initialParkingSpacesOrder(  ) { 

f_shuffleListWithFixedSeed(c_orderedParkingSpaces); 
  }

  void f_initialChargerOrder(  ) { 

c_orderedV1GChargers = new ArrayList<>();
c_orderedV2GChargers = new ArrayList<>();
c_orderedPublicChargers = new ArrayList<>();

List<GCPublicCharger> c_inactiveV1GChargers = new ArrayList<>();
List<GCPublicCharger> c_inactiveV2GChargers = new ArrayList<>();

for (GCPublicCharger gc : energyModel.PublicChargers) {
	if(gc.f_getChargingManagement() == null){
		throw new RuntimeException("Public charger found without chargingmanagement!");
	}
	J_ChargePoint chargePoint = gc.f_getChargePoint();
	
	//Get the correct list the public charger should be added to
	List<GCPublicCharger> collectionPointerV1GChargers = c_orderedV1GChargers;
	List<GCPublicCharger> collectionPointerV2GChargers = c_orderedV2GChargers;
	if(!gc.v_isActive){
		collectionPointerV1GChargers = c_inactiveV1GChargers;
		collectionPointerV2GChargers = c_inactiveV2GChargers;	
	}
	
	//Assign the gc to a certain location in the ordered list based on the capabilities
	if (chargePoint.getV1GCapable()) {
		collectionPointerV1GChargers.add(0, gc);
	}
	else {
		collectionPointerV1GChargers.add(gc);
	}
	if (chargePoint.getV2GCapable()) {
		collectionPointerV2GChargers.add(0, gc);
	}
	else {
		collectionPointerV2GChargers.add(gc);
	}
	
	if ( !gc.p_isChargingCentre ) { //Should maybe be a check for charger capabilities as well? 
		c_orderedPublicChargers.add(gc);
	}
}

c_orderedV1GChargers.addAll( c_inactiveV1GChargers );
c_orderedV2GChargers.addAll( c_inactiveV2GChargers );


f_shuffleListWithFixedSeed(c_orderedPublicChargers); 
  }

  protected void f_initializeSpecialGISObjectsLegend(  ) { 

int numberOfSpecialActiveGISObjectTypes = 0;

for(OL_GISObjectType activeSpecialGISObjectType : c_modelActiveSpecialGISObjects){
	if(activeSpecialGISObjectType == OL_GISObjectType.PARKING){
		for(OL_ParkingSpaceType activeParkingSpaceType : c_modelActiveParkingSpaceTypes){
			numberOfSpecialActiveGISObjectTypes ++;
			Pair<ShapeText, ShapeRectangle> legendShapes = f_getNextSpecialLegendShapes(numberOfSpecialActiveGISObjectTypes);
			f_setParkingSpaceLegendItem(activeParkingSpaceType, legendShapes.getFirst(), legendShapes.getSecond());
		}
	}
	else{
		numberOfSpecialActiveGISObjectTypes ++;
		Pair<ShapeText, ShapeRectangle> legendShapes = f_getNextSpecialLegendShapes(numberOfSpecialActiveGISObjectTypes);
		f_setSpecialGISObjectLegendItem(activeSpecialGISObjectType, legendShapes.getFirst(), legendShapes.getSecond());
		
		if(activeSpecialGISObjectType == OL_GISObjectType.CHARGER){
			numberOfSpecialActiveGISObjectTypes ++;
			legendShapes = f_getNextSpecialLegendShapes(numberOfSpecialActiveGISObjectTypes);
			legendShapes.getFirst().setVisible(true);
			legendShapes.getSecond().setVisible(true);
			legendShapes.getFirst().setText("Laadpaal/plein (Toegevoegd)");
			legendShapes.getSecond().setFillColor(v_newChargingStationColor);
			legendShapes.getSecond().setLineColor(v_newChargingStationLineColor);	
		}
	}
} 
  }

  public void f_setTrafoText(  ) { 

if ( v_clickedGridNode.p_realCapacityAvailable ) {
	v_clickedObjectText = v_clickedGridNode.p_nodeType + "-station, " + Integer.toString( ((int)v_clickedGridNode.p_capacity_kW) ) + " kW, ID: " + v_clickedGridNode.p_gridNodeID + ", aansluitingen: " + v_clickedGridNode.f_getConnectedGridConnections().size() + ", Type station: " + v_clickedGridNode.p_description;
}
else {
	v_clickedObjectText =  v_clickedGridNode.p_nodeType + "-station, " + Integer.toString( ((int)v_clickedGridNode.p_capacity_kW) ) + " kW (ingeschat), ID: " + v_clickedGridNode.p_gridNodeID + ", aansluitingen: " + v_clickedGridNode.f_getConnectedGridConnections().size() + ", Type station: " + v_clickedGridNode.p_description;
} 
  }

  protected void f_setSpecialGISObjectLegendItem( OL_GISObjectType activeSpecialGISObjectType, ShapeText legendText, ShapeRectangle legendRect ) { 

legendText.setVisible(true);
legendRect.setVisible(true);

switch(activeSpecialGISObjectType){
	case SOLARFARM:
		legendText.setText("Zonneveld");
		legendRect.setFillColor(v_solarParkColor);
		legendRect.setLineColor(v_solarParkLineColor);
		break;
	case WINDFARM:
		legendText.setText("Windmolen");
		legendRect.setFillColor(v_windFarmColor);
		legendRect.setLineColor(v_windFarmLineColor);
		break;
	case CHARGER:
		legendText.setText("Laadpaal/plein (Bestaand)");
		legendRect.setFillColor(v_chargingStationColor);
		legendRect.setLineColor(v_chargingStationLineColor);
		break;
	case BATTERY:	
		legendText.setText("Batterij");
		legendRect.setFillColor(v_batteryColor);
		legendRect.setLineColor(v_batteryLineColor);
		break;
	case PARCEL:
		legendText.setText("Nieuw Perceel");
		legendRect.setFillColor(v_parcelColor);
		legendRect.setLineColor(v_parcelLineColor);
		break;
	case ELECTROLYSER:
		legendText.setText("Electrolyser");
		legendRect.setFillColor(v_electrolyserColor);
		legendRect.setLineColor(v_electrolyserLineColor);
		break;
} 
  }

  protected void f_initializeLegend(  ) { 

//Default GIS buildings
f_initializeDefaultGISBuildingsLegend();

//Special gis objects
f_initializeSpecialGISObjectsLegend(); 
  }

  protected void f_setParkingSpaceLegendItem( OL_ParkingSpaceType activeParkingSpaceType, ShapeText legendText, ShapeRectangle legendRect ) { 

legendText.setVisible(true);
legendRect.setVisible(true);

switch(activeParkingSpaceType){
	case PUBLIC:
		legendText.setText("Parkeerplek: publiek");
		legendRect.setFillColor(v_parkingSpaceColor_public);
		legendRect.setLineColor(v_parkingSpaceLineColor_public);
		break;
	case PRIVATE:
		legendText.setText("Parkeerplek: privé");
		legendRect.setFillColor(v_parkingSpaceColor_private);
		legendRect.setLineColor(v_parkingSpaceLineColor_private);
		break;
	case ELECTRIC:
		legendText.setText("Parkeerplek: electrisch");
		legendRect.setFillColor(v_parkingSpaceColor_electric);
		legendRect.setLineColor(v_parkingSpaceLineColor_electric);
		break;
} 
  }

  protected 
Pair<ShapeText, ShapeRectangle> 
 f_getNextSpecialLegendShapes( int legendShapesNumber ) { 

ShapeText legendText;
ShapeRectangle legendRect;

switch(legendShapesNumber){
	case 1:
		legendText = t_specialGISObjectLegend1;
		legendRect = rect_specialGISObjectLegend1;
		break;
	case 2:
		legendText = t_specialGISObjectLegend2;
		legendRect = rect_specialGISObjectLegend2;
		break;
	case 3:
		legendText = t_specialGISObjectLegend3;
		legendRect = rect_specialGISObjectLegend3;
		break;
	case 4:
		legendText = t_specialGISObjectLegend4;
		legendRect = rect_specialGISObjectLegend4;
		break;
	case 5:
		legendText = t_specialGISObjectLegend5;
		legendRect = rect_specialGISObjectLegend5;
		break;
	case 6:
		legendText = t_specialGISObjectLegend6;
		legendRect = rect_specialGISObjectLegend6;
		break;
	case 7:
		legendText = t_specialGISObjectLegend7;
		legendRect = rect_specialGISObjectLegend7;
		break;
	case 8:
		legendText = t_specialGISObjectLegend8;
		legendRect = rect_specialGISObjectLegend8;
		break;
	case 9:
		legendText = t_specialGISObjectLegend9;
		legendRect = rect_specialGISObjectLegend9;
		break;
	case 10:
		legendText = t_specialGISObjectLegend10;
		legendRect = rect_specialGISObjectLegend10;
		break;
	case 11:
		legendText = t_specialGISObjectLegend11;
		legendRect = rect_specialGISObjectLegend11;
		break;
	case 12:
		legendText = t_specialGISObjectLegend12;
		legendRect = rect_specialGISObjectLegend12;
		break;
	default:
		legendText = t_specialGISObjectLegend1;
		legendRect = rect_specialGISObjectLegend1;
		break;
}

return new Pair(legendText, legendRect);
 
  }

  protected void f_initializeDefaultGISBuildingsLegend(  ) { 

int numberOfDefaultActiveGISObjectTypes = 1;//Always start at 2 (1 ++) for the building types, cause 'selection' is always present (for now).

for(OL_GISBuildingTypes activeDefaultGISBuildingType : c_modelActiveDefaultGISBuildings){
	numberOfDefaultActiveGISObjectTypes ++;
	Pair<ShapeText, ShapeOval> legendShapes = f_getNextDefaultLegendShapes(numberOfDefaultActiveGISObjectTypes);
	f_setDefaultGISBuildingLegendItem(activeDefaultGISBuildingType, legendShapes.getFirst(), legendShapes.getSecond());
} 
  }

  protected 
Pair<ShapeText, ShapeOval> 
 f_getNextDefaultLegendShapes( int legendShapesNumber ) { 

ShapeText legendText;
ShapeOval legendOval;

switch(legendShapesNumber){
	case 1:
		legendText = t_defaultLegend1;
		legendOval = oval_defaultLegend1;
		break;
	case 2:
		legendText = t_defaultLegend2;
		legendOval = oval_defaultLegend2;
		break;
	case 3:
		legendText = t_defaultLegend3;
		legendOval = oval_defaultLegend3;
		break;
	case 4:
		legendText = t_defaultLegend4;
		legendOval = oval_defaultLegend4;
		break;
	case 5:
		legendText = t_defaultLegend5;
		legendOval = oval_defaultLegend5;
		break;
	default:
		legendText = t_defaultLegend1;
		legendOval = oval_defaultLegend1;
}

return new Pair(legendText, legendOval);
 
  }

  protected void f_setDefaultGISBuildingLegendItem( OL_GISBuildingTypes activeDefaultGISBuildingType, ShapeText legendText, ShapeOval legendOval ) { 

legendText.setVisible(true);
legendOval.setVisible(true);

switch(activeDefaultGISBuildingType){
	case DETAILED_COMPANY:
		legendText.setText("Gedetaileerd bedrijf: " + v_numberOfSurveyCompanyGC);
		legendOval.setFillColor(v_detailedCompanyBuildingColor);
		legendOval.setLineColor(v_detailedCompanyBuildingLineColor);
		break;
	case DEFAULT_COMPANY:
		int totalDefaulltCompanies = energyModel.UtilityConnections.size() - v_numberOfSurveyCompanyGC;
		legendText.setText("Standaard bedrijf: " + totalDefaulltCompanies);
		legendOval.setFillColor(v_companyBuildingColor);
		legendOval.setLineColor(v_companyBuildingLineColor);
		break;
	case HOUSE:
		int totalHouses = energyModel.Houses.size();
		legendText.setText("Huizen: " + totalHouses);
		legendOval.setFillColor(v_houseBuildingColor);
		legendOval.setLineColor(v_houseBuildingLineColor);
		break;
	case REMAINING:
		legendText.setText("Overige gebouwen");
		legendOval.setFillColor(v_restBuildingColor);
		legendOval.setLineColor(v_restBuildingLineColor);
		break;
}
 
  }

  void f_setColorsBasedOnCongestion_objects( GIS_Object gis_area ) { 

if (gis_area.c_containedGridConnections.size() > 0) {
	double maxLoad_fr_gis_object = 0;
	boolean capacityKnown = false;
	
	for(GridConnection gc : gis_area.c_containedGridConnections){
		if(gc.v_rapidRunData != null){
			double maxLoad_fr_gc = 0;
			double maxLoad_fr_gc_delivery = gc.v_rapidRunData.connectionMetaData.getContractedDeliveryCapacity_kW() > 0 && gc.v_rapidRunData.connectionMetaData.getContractedDeliveryCapacityKnown() ? gc.v_rapidRunData.getPeakDelivery_kW()/gc.v_rapidRunData.connectionMetaData.getContractedDeliveryCapacity_kW() : 0;
			double maxLoad_fr_gc_feedin = gc.v_rapidRunData.connectionMetaData.getContractedFeedinCapacity_kW() > 0 && gc.v_rapidRunData.connectionMetaData.getContractedFeedinCapacityKnown()  ? gc.v_rapidRunData.getPeakFeedin_kW()/gc.v_rapidRunData.connectionMetaData.getContractedFeedinCapacity_kW() : 0;

			switch(rb_mapOverlayLegend_congestion.getValue()){
				case 0:
					maxLoad_fr_gc = maxLoad_fr_gc_delivery;
					
					if(gc.v_rapidRunData.connectionMetaData.getContractedDeliveryCapacityKnown()){
						capacityKnown = true;
					}
					break;
				case 1:
					maxLoad_fr_gc = maxLoad_fr_gc_feedin;
					if(gc.v_rapidRunData.connectionMetaData.getContractedFeedinCapacityKnown()){
						capacityKnown = true;
					}
					break;
				case 2:
					maxLoad_fr_gc = max(maxLoad_fr_gc_delivery, maxLoad_fr_gc_feedin);
					if(maxLoad_fr_gc_delivery > maxLoad_fr_gc_feedin && gc.v_rapidRunData.connectionMetaData.getContractedDeliveryCapacityKnown()){
						capacityKnown = true;
					}
					else if(maxLoad_fr_gc_feedin > maxLoad_fr_gc_delivery && gc.v_rapidRunData.connectionMetaData.getContractedFeedinCapacityKnown()){
						capacityKnown = true;
					}
					break;
			}
			if(maxLoad_fr_gc > maxLoad_fr_gis_object){
				maxLoad_fr_gis_object = maxLoad_fr_gc;
			}
		}
	}
	
	//Set colour based on found parameters
	if(!capacityKnown && project_data.project_type() != RESIDENTIAL){
		gis_area.gisRegion.setFillColor(v_gridNodeColorCapacityUnknown);
		gis_area.gisRegion.setLineColor(v_gridNodeLineColorCapacityUnknown);
	} else if (maxLoad_fr_gis_object > 1) {
		gis_area.gisRegion.setFillColor(v_gridNodeColorCongested);
		gis_area.gisRegion.setLineColor(v_gridLineColorCongested);
	} else if (maxLoad_fr_gis_object > 0.7) {
		gis_area.gisRegion.setFillColor(v_gridNodeColorStrained);
		gis_area.gisRegion.setLineColor(v_gridNodeLineColorStrained);
	} else {
		gis_area.gisRegion.setFillColor(v_gridNodeColorUncongested);
		gis_area.gisRegion.setLineColor(v_gridNodeLineColorUncongested);
	}
} 
  }

  void f_setColorsBasedOnCongestion_gridnodes( GridNode gn, boolean isLiveSim ) { 

if (gn!=null && gn.gisRegion != null){
	double maxLoad_fr = 0;
	if(isLiveSim){
		maxLoad_fr = abs(gn.v_currentLoad_kW)/gn.p_capacity_kW;
	}
	else{
		J_LoadDurationCurves loadCurves = gn.f_getDuurkrommes(energyModel.p_timeParameters);
		double maxLoad_fr_delivery = gn.p_capacity_kW > 0 ? abs(loadCurves.ds_loadDurationCurveTotal_kW.getY(0))/gn.p_capacity_kW : 0;
		double maxLoad_fr_feedin = gn.p_capacity_kW > 0 ? abs(loadCurves.ds_loadDurationCurveTotal_kW.getY(loadCurves.ds_loadDurationCurveTotal_kW.size()-1))/gn.p_capacity_kW : 0;

		switch(rb_mapOverlayLegend_congestion.getValue()){
			case 0:
				maxLoad_fr = maxLoad_fr_delivery;
				break;
			case 1:
				maxLoad_fr = maxLoad_fr_feedin;
				break;
			case 2:
				maxLoad_fr = max(maxLoad_fr_delivery, maxLoad_fr_feedin);
				break;
		}
	}
	
	if(!isLiveSim && !gn.p_realCapacityAvailable && project_data.project_type() != RESIDENTIAL){
		gn.gisRegion.setFillColor(v_gridNodeColorCapacityUnknown);
		gn.gisRegion.setLineColor(v_gridNodeLineColorCapacityUnknown);
	} else if (maxLoad_fr > 1) {
		gn.gisRegion.setFillColor(v_gridNodeColorCongested);
		gn.gisRegion.setLineColor(v_gridLineColorCongested);
	} else if (maxLoad_fr > 0.7) {
		gn.gisRegion.setFillColor(v_gridNodeColorStrained);
		gn.gisRegion.setLineColor(v_gridNodeLineColorStrained);
	} else {
		gn.gisRegion.setFillColor(v_gridNodeColorUncongested);
		gn.gisRegion.setLineColor(v_gridNodeLineColorUncongested);
	}
	
	if( gn == v_clickedGridNode){ // dit zorgt ervoor dat de kleuringfunctie correct werkt in zowel live stand als pauze stand
		gn.gisRegion.setFillColor( v_selectionColor );
		gn.gisRegion.setLineColor( orange );
	}
} 
  }

  public void f_clearSelectionAndSelectEnergyModel(  ) { 

f_deselectPreviousSelect();
f_selectEnergyModel(); 
  }

  public void f_styleLVLV( GISRegion gisregion ) { 

gisregion.setLineStyle( LINE_STYLE_SOLID );
gisregion.setLineColor( v_LVLVLineColor );
gisregion.setLineWidth(2);		
gisregion.setFillColor(v_LVLVNodeColor); 
  }

  void f_initializeMapOverlayRadioButton(  ) { 

//Set active map overlay types if they are set in the project settings
if(settings.activeMapOverlayTypes() != null && settings.activeMapOverlayTypes().size() > 0){
	c_loadedMapOverlayTypes = new ArrayList<OL_MapOverlayTypes>(settings.activeMapOverlayTypes());
	if(!c_loadedMapOverlayTypes.contains(OL_MapOverlayTypes.DEFAULT)){
		c_loadedMapOverlayTypes.add(0, OL_MapOverlayTypes.DEFAULT); // Force default to be available
	}
}
else{//Take the default
	c_loadedMapOverlayTypes.add(OL_MapOverlayTypes.DEFAULT);
	c_loadedMapOverlayTypes.add(OL_MapOverlayTypes.ELECTRICITY_CONSUMPTION);
	c_loadedMapOverlayTypes.add(OL_MapOverlayTypes.PV_PRODUCTION);
	c_loadedMapOverlayTypes.add(OL_MapOverlayTypes.GRID_NEIGHBOURS);
	c_loadedMapOverlayTypes.add(OL_MapOverlayTypes.CONGESTION);
	if(project_data.project_type() == OL_ProjectType.RESIDENTIAL){
		c_loadedMapOverlayTypes.add(OL_MapOverlayTypes.PARKING_TYPE);
	}
}


//Adjust the visualisation of the radiobuttons
Presentable presentable = gr_mapOverlayLegenda.getPresentable();
boolean ispublic = true;
double x = 756;
double y = c_loadedMapOverlayTypes.size() < 6 ? 837 : 837 - 18;
double width = 130;
double height = 0;//Not needed, automatically adjust by adding options
Color textColor = Color.BLACK;
boolean enabled = true;
Font font = new Font("Dialog", Font.PLAIN, 11);
boolean vertical = true;


//Set words for the radiobutton options
List<String> RadioButtonOptions_list = new ArrayList<String>();
for(OL_MapOverlayTypes mapOverlayType : c_loadedMapOverlayTypes){
	switch(mapOverlayType){
		case DEFAULT:
			RadioButtonOptions_list.add("Standaard");
			break;
		case ELECTRICITY_CONSUMPTION:
			RadioButtonOptions_list.add("Elektriciteitsverbruik");
			break;
		case PV_PRODUCTION:
			RadioButtonOptions_list.add("PV Opwek");
			break;
		case GRID_NEIGHBOURS:
			RadioButtonOptions_list.add("Energie Buren");
			break;
		case CONGESTION:
			RadioButtonOptions_list.add("Netbelasting");
			break;
		case ENERGY_LABEL:
			RadioButtonOptions_list.add("Energielabel");
			break;
		case PARKING_TYPE:
			RadioButtonOptions_list.add("Parkeer type");
			break;
		case CUSTOM:
			RadioButtonOptions_list.add(p_customMapOverlayName);
			break;
	}
} 

String[] RadioButtonOptions = RadioButtonOptions_list.toArray(String[]::new);

//Create the radiobutton and set the correct action.
rb_mapOverlay = new ShapeRadioButtonGroup(presentable, ispublic, x ,y, width, height, textColor, enabled, font, vertical, RadioButtonOptions){
	@Override
	public void action() {
		f_setMapOverlay();
	}
};

presentation.add(rb_mapOverlay);

//For now: Adjust location of radiobutton title if 6 buttons
if(c_loadedMapOverlayTypes.size() > 5){
	gr_colorings.setY(-17);
} 
  }

  protected void f_setMapOverlay(  ) { 

//reset legend
gr_defaultLegenda.setVisible(false);
gr_mapOverlayLegend_ElectricityConsumption.setVisible(false);
gr_mapOverlayLegend_PVProduction.setVisible(false);
gr_mapOverlayLegend_gridNeighbours.setVisible(false);
gr_mapOverlayLegend_congestion.setVisible(false);
gr_mapOverlayLegend_EnergyLabel.setVisible(false);
if (p_customMapOverlayLegend != null) {
	p_customMapOverlayLegend.setVisible(false);
}
b_updateLiveCongestionColors = false;

if(!b_inEnergyHubMode){
	f_clearSelectionAndSelectEnergyModel();
}

//Get selected map overlay type, based on loaded order of the radio buttons
OL_MapOverlayTypes selectedMapOverlayType = c_loadedMapOverlayTypes.get(rb_mapOverlay.getValue());

//Set the correct map overlay
switch(selectedMapOverlayType){
	case DEFAULT:
		f_setMapOverlay_Default();
		break;
	case ELECTRICITY_CONSUMPTION:
		f_setMapOverlay_ElectricityConsumption();
		break;
	case PV_PRODUCTION:
		f_setMapOverlay_PVProduction();
		break;
	case GRID_NEIGHBOURS:
		f_setMapOverlay_GridTopology();
		break;
	case CONGESTION:
		f_setMapOverlay_Congestion();
		break;
	case ENERGY_LABEL:
		f_setMapOverlay_EnergyLabel();
		break;
	case PARKING_TYPE:
		f_setMapOverlay_ParkingType();
		break;
	case CUSTOM:
		f_setMapOverlay_Custom();
		break;
} 
  }

  void f_setMapOverlay_ElectricityConsumption(  ) { 

//Set legend
b_updateLiveCongestionColors = true;
gr_mapOverlayLegend_ElectricityConsumption.setVisible(true);

//Colour gis objects
if (project_data.project_type() == OL_ProjectType.RESIDENTIAL){
	for (GIS_Building building : energyModel.pop_GIS_Buildings){
		f_setColorsBasedOnConsumptionProfileHouseholds(building);
	}
}
else {
	if(energyModel.v_rapidRunData == null){
		f_setErrorScreen("Dit overzicht wordt pas beschikbaar na het uitvoeren van een jaarsimulatie. In plaats daarvan is de standaard kaart geselecteerd.", 0, 0);
		rb_mapOverlay.setValue(c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.DEFAULT),true);
		return;			
	}
	gr_mapOverlayLegend_ElectricityConsumption.setVisible(true);
	for (GIS_Building building : energyModel.pop_GIS_Buildings){
		if(building.gisRegion.isVisible()){
			f_setColorsBasedOnElectricityConsumption(building);
		}
	}
	/*for (GIS_Object object : energyModel.pop_GIS_Objects){
		f_setColorsBasedOnConsumpion(object);
	}*/
} 
  }

  void f_setMapOverlay_PVProduction(  ) { 

//Set legend
b_updateLiveCongestionColors = true;
gr_mapOverlayLegend_PVProduction.setVisible(true);

//Colour gis objects
for (GIS_Building building : energyModel.pop_GIS_Buildings){
	f_setColorsBasedOnProduction(building);
}
/*for (GIS_Object object : energyModel.pop_GIS_Objects){
	f_setColorsBasedOnProduction(object);
}*/ 
  }

  void f_setMapOverlay_GridTopology(  ) { 

//Set legend
gr_mapOverlayLegend_gridNeighbours.setVisible(true);
b_updateLiveCongestionColors = false;

//Colour gis objects
for (GIS_Building building : energyModel.pop_GIS_Buildings){
	f_setColorsBasedOnGridTopology_objects(building);
}
/*for (GIS_Object object : energyModel.pop_GIS_Objects){
	f_setColorsBasedOnGridTopology_objects(object);
}*/
for (GridNode GN : energyModel.pop_gridNodes){
	f_setColorsBasedOnGridTopology_gridnodes(GN);
} 
  }

  void f_setMapOverlay_Congestion(  ) { 

if(energyModel.v_rapidRunData == null){
	f_setErrorScreen("Dit overzicht wordt pas beschikbaar na het uitvoeren van een jaarsimulatie. In plaats daarvan is de standaard kaart geselecteerd.", 0, 0);
	rb_mapOverlay.setValue(c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.DEFAULT),true);
	return;			
}

//Set legend
gr_mapOverlayLegend_congestion.setVisible(true);
b_updateLiveCongestionColors = false;

//Colour gis objects
for (GIS_Building building : energyModel.pop_GIS_Buildings){
	f_setColorsBasedOnCongestion_objects(building);
}
/*
for (GIS_Object object : energyModel.pop_GIS_Objects){
	f_setColorsBasedOnCongestion_objects(object);
}
*/
for (GridNode GN : energyModel.pop_gridNodes){
	f_setColorsBasedOnCongestion_gridnodes(GN, false);
} 
  }

  void f_setMapOverlay_Default(  ) { 

b_updateLiveCongestionColors = true;
gr_defaultLegenda.setVisible(true);	
for (GIS_Building b: energyModel.pop_GIS_Buildings) {
	f_styleAreas(b);
}
/*for (GIS_Object object : energyModel.pop_GIS_Objects){
	f_styleAreas(object);
}*/ 
  }

  void f_setMapOverlay_EnergyLabel(  ) { 

//Set legend
b_updateLiveCongestionColors = true;
gr_mapOverlayLegend_EnergyLabel.setVisible(true);

for (GIS_Building building : energyModel.pop_GIS_Buildings){
	f_setColorsBasedOnEnergyLabels(building);
} 
  }

  protected void f_setShapePresentationOnTop( Shape shape ) { 

presentation.remove(shape);
presentation.insert(presentation.size(), shape); 
  }

  protected void f_initializePresentationOrder(  ) { 

//Set order of certain layovers and submenus
f_setShapePresentationOnTop(map);
f_setShapePresentationOnTop(gr_zoomButton);
f_setShapePresentationOnTop(gr_sliderClickBlocker);
f_setShapePresentationOnTop(gr_forceMapSelection);
f_setShapePresentationOnTop(gr_filterInterface);
f_setShapePresentationOnTop(gr_infoText);
 
  }

  protected void f_setForcedClickScreenVisibility( boolean showForcedClickScreen ) { 

gr_forceMapSelection.setVisible(showForcedClickScreen); 
  }

  protected void f_selectEnergyHubGC( double clickx, double clicky ) { 

if(b_inManualFilterSelectionMode){
	f_selectManualFilteredGC(clickx, clicky);
}
else if (c_selectedFilterOptions.contains(OL_FilterOptionsGC.GRIDTOPOLOGY_SELECTEDLOOP) || 
		c_selectedFilterOptions.contains(OL_FilterOptionsGC.SELECTED_NEIGHBORHOOD)){
	
	if(c_selectedFilterOptions.contains(OL_FilterOptionsGC.GRIDTOPOLOGY_SELECTEDLOOP)){
		f_selectGridLoop(clickx, clicky);
	}
	if(c_selectedFilterOptions.contains(OL_FilterOptionsGC.SELECTED_NEIGHBORHOOD)){
		f_selectNeighborhood(clickx, clicky);
	}
} 
  }

  void f_startEnergyHubConfiguration(  ) { 

pauseSimulation();

b_inEnergyHubMode = true;
b_inEnergyHubSelectionMode = true;

f_setForcedClickScreenText("");
f_setForcedClickScreenVisibility(true);

cb_showFilterInterface.setSelected(true, true);
gr_filterInterface.setPos(170, 580); 
  }

  protected void f_finalizeEnergyHubConfiguration(  ) { 

if(b_inEnergyHubSelectionMode){
	if(button_completeManualSelectionMode.isVisible()){
		button_completeManualSelectionMode.action();
	}


	//Move scenario radiobuttons over
	f_getScenarioButtons().setPos( 
		gr_energyHubPresentation.getX() + uI_EnergyHub.rect_scenarios.getX() + 25.0,
		gr_energyHubPresentation.getY() + uI_EnergyHub.rect_scenarios.getY() + 50.0
	);
	
	//Set map in correct pos and navigate to e-hub view
	map.setPos( 
		gr_energyHubPresentation.getX() + uI_EnergyHub.rect_map.getX() + 10.0,
		gr_energyHubPresentation.getY() + uI_EnergyHub.rect_map.getY() + 10.0
	);
	map.setScale( 0.85, 0.85 );
	va_EHubDashboard.navigateTo();
	v_currentViewArea = va_EHubDashboard;
	
	//Copy selected GC and coop to e-hub dashboard
	v_customEnergyCoop.p_actorID = "eHubConfiguratorCoop";
	uI_EnergyHub.v_energyHubCoop = v_customEnergyCoop;
	
	//Set E-hub selection mode false
	b_inEnergyHubSelectionMode = false;
	
	uI_EnergyHub.f_initializeEnergyHubDashboard();
}
 
  }

  public void f_createUITabs_default(  ) { 

// CHOOSE WHICH TABS YOU WANT TO BE ABLE TO SHOW FOR YOUR PROJECT 
// (OVERRIDE FUNCTION IN CHILD IF YOU WANT OTHER THAN DEFAULT)

// Adding the (child) tabs to the tabArea population

// If you use an extension of a tab, you must update the pointer to the instance of the interface
// Something like: tabElectricity.zero_Interface = loader_Project.zero_Interface;
// No update to the pointer is needed for the generic tabs


uI_Tabs.add_pop_tabElectricity();
uI_Tabs.add_pop_tabHeating();
uI_Tabs.add_pop_tabMobility();

// Group visibilities
// When using an extension of a generic tab don't forget to typecast it!
if (project_data.project_type() == OL_ProjectType.RESIDENTIAL) {
	((tabElectricity)uI_Tabs.pop_tabElectricity.get(0)).getGroupElectricityDemandSliders_ResidentialArea().setVisible(true);
	((tabHeating)uI_Tabs.pop_tabHeating.get(0)).getGroupHeatDemandSlidersResidentialArea().setVisible(true);
	((tabMobility)uI_Tabs.pop_tabMobility.get(0)).getGr_mobilitySliders_residential().setVisible(true);
}
else {
	uI_Tabs.add_pop_tabEHub();
	((tabElectricity)uI_Tabs.pop_tabElectricity.get(0)).getGroupElectricityDemandSliders_Businesspark().setVisible(true);
	((tabHeating)uI_Tabs.pop_tabHeating.get(0)).getGroupHeatDemandSlidersCompanies().setVisible(true);
	((tabMobility)uI_Tabs.pop_tabMobility.get(0)).getGr_mobilitySliders_default().setVisible(true);
	((tabEHub)uI_Tabs.pop_tabEHub.get(0)).getGroupHubSliders().setVisible(true);
} 
  }

  void f_initializePrivateAndPublicParkingCarsOrder(  ) { 

//Get all public and private parked cars
c_orderedVehiclesPrivateParking = new ArrayList<>();
List<J_EAFuelVehicle> allPublicParkedCars = new ArrayList<>();
for (GCHouse house : energyModel.Houses) {
	if (house.p_eigenOprit) {
		c_orderedVehiclesPrivateParking.addAll(house.c_vehicleAssets);
	}
	else{
		allPublicParkedCars.addAll(house.c_petroleumFuelVehicles);	
	}
}

//Shuffle the collections to not have skewed initialization
f_shuffleListWithFixedSeed(c_orderedVehiclesPrivateParking);
f_shuffleListWithFixedSeed(allPublicParkedCars);

//Get the total amount of public chargers
int totalChargers = c_orderedPublicChargers.size();

if(totalChargers > 0){
	// Fair distribution of vehicles across chargers
	List<Integer> numberOfCarsPerCharger = f_getNumberOfCarsPerCharger(allPublicParkedCars.size(), totalChargers);
	
	// Assign vehicles to chargers
	c_mappingOfVehiclesPerCharger.clear();
	int index = 0;
	for (int i = 0; i < totalChargers; i++) {
	    GCPublicCharger charger = c_orderedPublicChargers.get(i);
	    int numberOfCars = numberOfCarsPerCharger.get(i);
	
	    List<J_EAFuelVehicle> assignedCars = new ArrayList<>(allPublicParkedCars.subList(index, index + numberOfCars));
	    c_mappingOfVehiclesPerCharger.put(charger.p_uid, assignedCars);
	
	    // Place vehicles depending on whether the charger is active
	    if (charger.v_isActive) {
	        for (J_EAFuelVehicle car : assignedCars) {
	           	J_ActivityTrackerTrips tripTracker = car.getTripTracker(); //Needed, as triptracker is removed when removeEnergyAsset is called.
				car.removeEnergyAsset();
				car.setTripTracker(tripTracker);//Re-set the triptracker again, for storing.
	        }
	    }
	
	    index += numberOfCars;
	}
}
 
  }

  public void f_simulateYearFromMainInterface(  ) { 


gr_simulateYear.setVisible(false);		
gr_loadIconYearSimulation.setVisible(true);

new Thread( () -> {
	//Run rapid run
	energyModel.f_runRapidSimulation();
	
	//After rapid run: remove loading screen
	f_removeAllSimulateYearScreens();

	if (c_selectedGridConnections.size() == 0){//Update main area collection
		uI_Results.f_updateResultsUI(energyModel);
	}
	else if (c_selectedGridConnections.size() == 1){//Update selected GC area collection
		uI_Results.f_updateResultsUI(c_selectedGridConnections.get(0));
	}
	else if(c_selectedGridConnections.size() > 1){//Update COOP area collection
		uI_Results.f_updateResultsUI(v_customEnergyCoop);
	}
	if (uI_EnergyHub != null && uI_EnergyHub.v_energyHubCoop != null) {
		uI_EnergyHub.uI_Results.f_updateResultsUI(uI_EnergyHub.v_energyHubCoop);
	}
	
	//Update and show kpi summary chart after run
	if(settings.showKPISummary() != null && settings.showKPISummary() && v_clickedObjectType != OL_GISObjectType.GRIDNODE){
		uI_Results.getCheckbox_KPISummary().setSelected(true, true);
	}
	
	//Enable radio buttons again
	uI_Results.f_enableNonLivePlotRadioButtons(true);
	if(uI_EnergyHub != null){
		uI_EnergyHub.uI_Results.f_enableNonLivePlotRadioButtons(true);
	}
	if(uI_Company != null){
		uI_Company.uI_Results.f_enableNonLivePlotRadioButtons(true); 
	}
	
	b_resultsUpToDate = true;
}).start(); 
  }

  void f_initialPTSystemsOrder_households(  ) { 

List<GCHouse> houses = new ArrayList<GCHouse>(energyModel.Houses.findAll( x -> true));
List<GCHouse> housesWithoutPT = houses.stream().filter( gc -> !gc.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW) ).collect(Collectors.toList());
List<GCHouse> housesWithPT = new ArrayList<>(houses);
housesWithPT.removeAll(housesWithoutPT);

c_orderedPTSystemsHouses = new ArrayList<>(housesWithoutPT);
c_orderedPTSystemsHouses.addAll(housesWithPT);
 
  }

  void f_setMapOverlay_ParkingType(  ) { 

//Set legend
b_updateLiveCongestionColors = true;

//Colour gis objects
for (GIS_Building building : energyModel.pop_GIS_Buildings){
	f_setColorsBasedOnParkingType_objects(building);
}
for (GridNode GN : energyModel.pop_gridNodes){
	f_setColorsBasedOnParkingType_gridnodes(GN);
} 
  }

  void f_setColorsBasedOnParkingType_objects( GIS_Object gis_area ) { 

if (gis_area.c_containedGridConnections.size() > 0) {
	
	//Unkown by default
	Color objectColor = v_parkingSpaceColor_unkown;
	Color objectLineColor = v_parkingSpaceLineColor_unkown;
	
	//Check if houses and if public parking
	boolean containsHouses = false;
	boolean containsHousesWithPublicParking = false;
	for(GridConnection gc : gis_area.c_containedGridConnections){
		if(gc instanceof GCHouse){
			containsHouses = true;
			if(!((GCHouse)gc).p_eigenOprit){
				containsHousesWithPublicParking = true;
			}
		}
	}
	
	//Change color based on parking type if houses present
	if(containsHouses){
		if(containsHousesWithPublicParking){
			objectColor = v_parkingSpaceColor_public;
			objectLineColor = v_parkingSpaceLineColor_public;		
		}
		else{
			objectColor = v_parkingSpaceColor_private;
			objectLineColor = v_parkingSpaceLineColor_private;
		}
	}
	gis_area.f_style(objectColor, objectLineColor, null, null);
} 
  }

  void f_setColorsBasedOnParkingType_gridnodes( GridNode GN ) { 

if(GN.gisRegion != null){
	GN.gisRegion.setFillColor(v_parkingSpaceColor_unkown);
	GN.gisRegion.setLineColor(v_parkingSpaceLineColor_unkown);
} 
  }

  
List<Integer> 
 f_getNumberOfCarsPerCharger( int totalPublicParkedCars, int totalPublicChargers ) { 

List<Integer> numberOfCarsPerCharger = new ArrayList<>();
if(totalPublicChargers > 0){

	    
	int baseNumberOfCars = (int) floor(totalPublicParkedCars / totalPublicChargers); //Could also simply be totalPublicParkedCars / totalPublicChargers, as int/int is already floored, but just to make sure what should happen here it is written in full
	int remainingCars = totalPublicParkedCars % totalPublicChargers;  // extra vehicles that can be distributed
	
	for (int i = 0; i < totalPublicChargers; i++) {
	    if (i < remainingCars) {
	        numberOfCarsPerCharger.add(baseNumberOfCars + 1); // some chargers get one extra
	    } else {
	        numberOfCarsPerCharger.add(baseNumberOfCars);
	    }
	}
}

return numberOfCarsPerCharger; 
  }

  public 
ShapeRadioButtonGroup 
 f_getScenarioButtons(  ) { 

return rb_scenarios; 
  }

  void f_enableAllPlots( UI_Results resultsUI, I_EnergyData selectedObjectInterface ) { 

if (resultsUI.f_getSelectedObjectData() != null) {	
	uI_Results.f_updateResultsUI(selectedObjectInterface);
	uI_Results.f_enableNonLivePlotRadioButtons(true);
} 
  }

  protected void f_setAllSimulateYearScreens(  ) { 

gr_simulateYear.setVisible(true);
if(uI_EnergyHub != null){
	uI_EnergyHub.gr_simulateYearEnergyHub.setVisible(true);
}
if(uI_Company != null){
	uI_Company.gr_simulateYearScreen.setVisible(true);
} 
  }

  public void f_removeAllSimulateYearScreens(  ) { 

gr_simulateYear.setVisible(false);
gr_loadIconYearSimulation.setVisible(false);
if(uI_EnergyHub != null){
	uI_EnergyHub.gr_simulateYearEnergyHub.setVisible(false);
	uI_EnergyHub.gr_loadIconYearSimulationEnergyHub.setVisible(false);
}
if(uI_Company != null){
	uI_Company.gr_simulateYearScreen.setVisible(false);
	uI_Company.gr_loadIcon.setVisible(false);
} 
  }

  void f_cancelEnergyHubConfiguration(  ) { 

button_clearFilters.action();

b_inEnergyHubMode = false;
b_inEnergyHubSelectionMode = false;

f_setForcedClickScreenText("");
f_setForcedClickScreenVisibility(false);

cb_showFilterInterface.setSelected(false, true); 
  }

  protected void f_filterHasEV( ArrayList<GridConnection> toBeFilteredGC ) { 

c_selectedGridConnections = new ArrayList<>(findAll(toBeFilteredGC, GC -> GC.c_electricVehicles.size() > 0));
//Werkt nog niet helemaal naar behoren, want ghost assets worden nog niet aangemaakt, 
//en dus hebben bedrijven met ghost ev geen c_electricVehicles en dus komen niet door deze filter.
// --> Als ghost vehicles ook worden aangemaakt, werkt het wel. 
  }

  void f_initializeAdditionalVehicles(  ) { 

for(GridConnection GC : energyModel.UtilityConnections){
	c_additionalVehicles.put(GC.p_uid, new ArrayList<I_Vehicle>());
} 
  }

  protected void f_createAdditionalUIs(  ) { 

//Energy hub dashboard
if(project_data.project_type() == OL_ProjectType.BUSINESSPARK){
	uI_EnergyHub = add_pop_UI_EnergyHub();
}

//Private companyUI dashboard
if(energyModel.UtilityConnections.size() > 0){
	uI_Company = add_pop_UI_Company();
}

/* 
//Hydrogen dashboard NOT FINISHED
for(GCEnergyConversion conversionGC : energyModel.EnergyConversionSites){
	for(J_EAConversion conversionEA : conversionGC.c_conversionAssets){
		if(conversionEA instanceof J_EAConversionElectrolyser){	
			uI_Hydrogen = add_pop_UI_Hydrogen();
			break;
		}
	}
}

//Battery dashboard NOT FINISHED
for(GCGridBattery batteryGC : energyModel.GridBatteries){
	if(batteryGC.c_connectedGISObjects.size()>0){	
		uI_Battery = add_pop_UI_Battery();
		break;
	}
}
*/ 
  }

  protected void f_setCompaniesScenario( LinkedHashMap scenarioMap ) { 

if(!energyModel.UtilityConnections.isEmpty()){
	//Solution for now
	int companyUIScenarioRBIndex = 0;
	if(scenarioMap == c_scenarioMap_Current){
		companyUIScenarioRBIndex = 0;
	}
	else if(scenarioMap == c_scenarioMap_Future){
		companyUIScenarioRBIndex = 1;
	}
	else{
		throw new RuntimeException("Tried to call the setCompaniesScenario function with a non existing companyUI scenario");
	}
	
	//Set companyUI to correct radio button setting
	uI_Company.b_runningMainInterfaceScenarioSettings = true;
	for (GCUtility  GC : energyModel.UtilityConnections){
		uI_Company.f_setCompanyUI(GC);
		uI_Company.getRb_scenariosPrivateUI().setValue(companyUIScenarioRBIndex, true);
	}
	uI_Company.b_runningMainInterfaceScenarioSettings = false;
} 
  }

  void f_initializeScenarioRadioButton(  ) { 

//Set the default visualisation of the radiobuttons
Presentable presentable = this.presentation.getPresentable();
boolean ispublic = true;
double x = rb_scenarios_template.getX();
double y = rb_scenarios_template.getY();
double width = rb_scenarios_template.getWidth();
double height = 0;//Not needed, automatically adjust by adding options
Color textColor = Color.BLACK;
boolean enabled = true;
Font font = new Font("Dialog", Font.PLAIN, 14);
boolean vertical = true;

//Set words for the radiobutton options
String[] RadioButtonOptions = f_getScenarioOptions();

//Check if it contains the custom option
boolean containsCustomOption = false;
for(String scenarioOption : RadioButtonOptions){
	if(scenarioOption.equals("Custom")){
		containsCustomOption = true;
	}
}

if(!containsCustomOption){
	traceln("WARNING: Scenario radiobutton option 'Custom' was not included in the custom scenario options, it has automatically been added!");
    RadioButtonOptions = Arrays.copyOf(RadioButtonOptions, RadioButtonOptions.length + 1);
    RadioButtonOptions[RadioButtonOptions.length - 1] = "Custom";										
}

//Create the radiobutton and set the correct action.
rb_scenarios = new ShapeRadioButtonGroup(presentable, ispublic, x ,y, width, height, textColor, enabled, font, vertical, RadioButtonOptions){
	@Override
	public void action() {
		f_scenarioRadioButtonAction();
	}
};

presentation.add(rb_scenarios);

//For now: Adjust location of radiobutton title if 6 buttons
if(c_loadedMapOverlayTypes.size() > 5){
	gr_colorings.setY(-17);
} 
  }

  protected 
String 
 f_setSelectedScenario(  ) { 

//Default scenario switch statement, override this function if you want to add/change scenario options!
String selected_scenario = "";

switch(rb_scenarios.getValue()){
	case 0:
		selected_scenario = "Huidige situatie";
		f_setScenario_Current();

	break;
	case 1:
		if(project_data.project_type() == OL_ProjectType.BUSINESSPARK){
			selected_scenario = "Toekomstplannen";
			f_setScenario_Future();
		}
		else if(project_data.project_type() == OL_ProjectType.RESIDENTIAL){
			selected_scenario = "Custom";
			t_scenarioDescription.setText(t_scenario_custom);
		}
	break;
	case 2:
		selected_scenario = "Custom";
		t_scenarioDescription.setText(t_scenario_custom);
	break;
	
	default:
		traceln("Unsupported scenario selected");
}

return selected_scenario; 
  }

  protected 
String[] 
 f_getScenarioOptions(  ) { 

//OVERRIDE THIS FUNCTION IF YOU WANT TO ADJUST THE SCENARIO OPTIONS.
// -> MAKE SURE TO ALWAYS INCLUDE A CUSTOM
String[] scenarioOptions = null;
if(project_data.project_type() == OL_ProjectType.BUSINESSPARK){
	scenarioOptions = new String[]{"Huidige situatie", "Toekomstplannen", "Custom"};
}
else if(project_data.project_type() == OL_ProjectType.RESIDENTIAL){
	scenarioOptions = new String[]{"Huidige situatie", "Custom"};
}
return scenarioOptions; 
  }

  protected void f_setScenario_Future(  ) { 

if(c_scenarioMap_Future != null){
	f_setCompaniesScenario(c_scenarioMap_Future);
}
//Set specifc assets active/non-active
f_projectSpecificScenarioSettings("Future");

//Set the scenario text
t_scenarioDescription.setText(t_scenario_future); 
  }

  protected void f_setScenario_Current(  ) { 

//if(project_data.project_type() == OL_ProjectType.BUSINESSPARK && c_scenarioMap_Current != null){
if(c_scenarioMap_Current != null){
	f_setCompaniesScenario(c_scenarioMap_Current);
}
//Reset sliders for households
if(project_data.project_type() == OL_ProjectType.RESIDENTIAL && p_residentialScenario_Current != null){
	f_setResidentialScenario_Current();
}


//Set specifc assets active/non-active
f_projectSpecificScenarioSettings("Current");

//Set the scenario text
t_scenarioDescription.setText(t_scenario_current); 
  }

  protected void f_resetSpecialSlidersAndButtons(  ) { 

if (uI_Tabs.pop_tabEHub.size() > 0){
	if (uI_Tabs.pop_tabEHub.get(0).getButton_remove_nfato() != null){
		uI_Tabs.pop_tabEHub.get(0).getButton_remove_nfato().action();
	}
}

//Project specific sliders and buttons reset
f_resetProjectSpecificSlidersAndButtons(); 
  }

  protected void f_resetProjectSpecificSlidersAndButtons(  ) { 

//OVERRIDE THIS FUNCTION IF YOU WANT TO RESET CERTAIN CUSTOM SLIDERS 
//AND BUTTONS THAT ARE NOT IN THE GENERIC LOADERFACE 
  }

  protected void f_projectSpecificScenarioSettings( String selectedScenario ) { 

//OVERRIDE IF THIS IS NEEDED FOR YOUR SPECIFIC PROJECT

//Example code:
/*
//Find specific scenario assets
GridConnection testGC_new = findFirst(energyModel.UtilityConnections, GC -> GC.p_gridConnectionID.equals("testGC_nieuwBouw"));
GIS_Building testBuilding_additionalBuilding = findFirst(energyModel.pop_GIS_Buildings, B -> B.p_id.equals("testBuilding_additionalBuilding"));

switch(selectedScenario){
	case "Current":
		//Pause assets
		testGC_new.f_setActive(false);			
		testBuilding_additionalBuilding.gisRegion.setVisible(false);
		break;
	
	case "Future":
		//Unpause assets
		testGC_new.f_setActive(true);			
		testBuilding_additionalBuilding.gisRegion.setVisible(true);
		break;
}
*/
 
  }

  protected void f_setResidentialScenario_Current(  ) { 

////Electricity
tabElectricity tabElec = uI_Tabs.pop_tabElectricity.get(0);

double pv_pct = p_residentialScenario_Current.getHousesWithPV_pct();
tabElec.sl_householdPVResidentialArea_pct.setValue(roundToInt(pv_pct), true);

double battery_pct = p_residentialScenario_Current.getPvHousesWithBattery_pct();
tabElec.sl_householdBatteriesResidentialArea_pct.setValue(roundToInt(battery_pct), true);

//Electric cooking
double cooking_pct = p_residentialScenario_Current.getCooking_pct();
tabElec.sl_householdElectricCookingResidentialArea_pct.setValue(roundToInt(cooking_pct), true);

//Consumption growth
double electricityDemandIncrease_pct = p_residentialScenario_Current.getElectricityDemandIncrease_pct();
tabElec.sl_electricityDemandIncreaseResidentialArea_pct.setValue(roundToInt(electricityDemandIncrease_pct), true);

//Gridbatteries
double averageNeighbourhoodBatterySize_kWh = p_residentialScenario_Current.getAverageNeighbourhoodBatterySize_kWh();
tabElec.sl_gridBatteriesResidentialArea_kWh.setValue(averageNeighbourhoodBatterySize_kWh, true);

////Heating
tabHeating tabHeat = uI_Tabs.pop_tabHeating.get(0);

double housesWithGasBurners_pct = p_residentialScenario_Current.getHousesWithGasBurners_pct();
double housesWithHybridHeatpump_pct = p_residentialScenario_Current.getHousesWithHybridHeatpump_pct();
double housesWithElectricHeatpump_pct = p_residentialScenario_Current.getHousesWithElectricHeatpump_pct();
boolean cb_householdHTDistrictHeatingActive = p_residentialScenario_Current.getCb_householdHTDistrictHeatingActive();
boolean cb_householdLTDistrictHeatingActive = p_residentialScenario_Current.getCb_householdLTDistrictHeatingActive();

if(cb_householdHTDistrictHeatingActive || cb_householdLTDistrictHeatingActive){
	tabHeat.sl_householdGasBurnerResidentialArea_pct.setValue(housesWithGasBurners_pct, false);
	tabHeat.sl_householdHybridHeatpumpResidentialArea.setValue(housesWithHybridHeatpump_pct, false);
	tabHeat.sl_householdElectricHeatPumpResidentialArea_pct.setValue(housesWithElectricHeatpump_pct, false);
	if(cb_householdHTDistrictHeatingActive){
		tabHeat.cb_householdHTDistrictHeatingResidentialArea.setSelected(cb_householdHTDistrictHeatingActive, false);
		tabHeat.cb_householdLTDistrictHeatingResidentialArea.setSelected(cb_householdLTDistrictHeatingActive, true);
	}
	else if(cb_householdLTDistrictHeatingActive){
		tabHeat.cb_householdHTDistrictHeatingResidentialArea.setSelected(cb_householdHTDistrictHeatingActive, false);
		tabHeat.cb_householdLTDistrictHeatingResidentialArea.setSelected(cb_householdLTDistrictHeatingActive, true);
	}
}
else{
	tabHeat.sl_householdGasBurnerResidentialArea_pct.setValue(housesWithGasBurners_pct, true);
	tabHeat.sl_householdHybridHeatpumpResidentialArea.setValue(housesWithHybridHeatpump_pct, true);
	tabHeat.sl_householdElectricHeatPumpResidentialArea_pct.setValue(housesWithElectricHeatpump_pct, true);
	tabHeat.cb_householdHTDistrictHeatingResidentialArea.setSelected(cb_householdHTDistrictHeatingActive, false);
	tabHeat.cb_householdLTDistrictHeatingResidentialArea.setSelected(cb_householdLTDistrictHeatingActive, false);
}


//Houses with Airco
double pctOfHousesWithAirco = p_residentialScenario_Current.getHousesWithAirco_pct();
tabHeat.sl_householdAircoResidentialArea_pct.setValue(pctOfHousesWithAirco, true);

//Houses with better isolation
double pctOfHousesWithImprovedInsulation = p_residentialScenario_Current.getHousesWithImprovedInsulation_pct();
tabHeat.sl_householdHeatDemandReductionResidentialArea_pct.setValue(roundToInt(pctOfHousesWithImprovedInsulation), true);

//PT
double nbHousesWithPT_pct = p_residentialScenario_Current.getNbHousesWithPT_pct();
tabHeat.sl_rooftopPTHouses_pct.setValue(roundToInt(nbHousesWithPT_pct), true);



////Mobility
tabMobility tabMob = uI_Tabs.pop_tabMobility.get(0);

//Private EV
double privateEVs_pct = p_residentialScenario_Current.getPrivateEVs_pct();
double privateEVsThatSupportV2G_pct = p_residentialScenario_Current.getPrivateEVsThatSupportV2G_pct();
tabMob.sl_privateEVsResidentialArea_pct.setValue(roundToInt(privateEVs_pct), true);
tabMob.sl_EVsThatSupportV2G_pct.setValue(roundToInt(privateEVsThatSupportV2G_pct), true);

//Selected charging mode
String selectedChargingAttitudeStringPrivateEV = p_residentialScenario_Current.getSelectedChargingAttitudeStringPrivateEVs();
boolean V2GActivePrivateEV = p_residentialScenario_Current.getV2GActivePrivateEVs();

tabMob.cb_chargingAttitudePrivateParkedCars.setValue(selectedChargingAttitudeStringPrivateEV, true);
tabMob.cb_activateV2GPrivateParkedCars.setSelected(V2GActivePrivateEV, true);

//Chargers
double activePublicChargers_pct = p_residentialScenario_Current.getActivePublicChargers_pct();
tabMob.sl_publicChargersResidentialArea_pct.setValue(roundToInt(activePublicChargers_pct), true);

double V1G_pct = p_residentialScenario_Current.getChargersV1G_pct();
double V2G_pct = p_residentialScenario_Current.getChargersV2G_pct();
tabMob.sl_chargersThatSupportV1G_pct.setValue(roundToInt(V1G_pct), true);
tabMob.sl_chargersThatSupportV2G_pct.setValue(roundToInt(V2G_pct), true);

//Selected charging mode
String selectedChargingAttitudeStringChargers = p_residentialScenario_Current.getSelectedChargingAttitudeStringChargers();
boolean V2GActiveChargers = p_residentialScenario_Current.getV2GActiveChargers();

tabMob.cb_chargingAttitudePrivatePublicChargers.setValue(selectedChargingAttitudeStringChargers, true);
tabMob.cb_activateV2GPublicChargers.setSelected(V2GActiveChargers, true); 
  }

  protected void f_storeResidentialScenario_Current(  ) { 

//Create the class that will store the initial slider settings of a residential model
p_residentialScenario_Current = new J_SliderSettings_Residential();

////Electricity
if(uI_Tabs.pop_tabElectricity.size() > 0){
	tabElectricity tabElec = uI_Tabs.pop_tabElectricity.get(0);
	
	double housesWithPV_pct = tabElec.sl_householdPVResidentialArea_pct.getValue();
	p_residentialScenario_Current.setHousesWithPV_pct(housesWithPV_pct);
	
	double pvHousesWithBattery_pct = tabElec.sl_householdBatteriesResidentialArea_pct.getValue();
	p_residentialScenario_Current.setPvHousesWithBattery_pct(pvHousesWithBattery_pct);
	
	
	//Electric cooking
	double cooking_pct = tabElec.sl_householdElectricCookingResidentialArea_pct.getValue();
	p_residentialScenario_Current.setCooking_pct(cooking_pct);
	
	//Consumption growth
	double electricityDemandIncrease_pct = tabElec.sl_electricityDemandIncreaseResidentialArea_pct.getValue();
	p_residentialScenario_Current.setElectricityDemandIncrease_pct(electricityDemandIncrease_pct);
	
	//Gridbatteries
	double averageNeighbourhoodBatterySize_kWh = tabElec.sl_gridBatteriesResidentialArea_kWh.getValue();
	p_residentialScenario_Current.setAverageNeighbourhoodBatterySize_kWh(averageNeighbourhoodBatterySize_kWh);
}

////Heating
if(uI_Tabs.pop_tabHeating.size() > 0){
	tabHeating tabHeat = uI_Tabs.pop_tabHeating.get(0);
	
	double housesWithGasBurners_pct = tabHeat.sl_householdGasBurnerResidentialArea_pct.getValue();
	double housesWithHybridHeatpump_pct = tabHeat.sl_householdHybridHeatpumpResidentialArea.getValue();
	double housesWithElectricHeatpump_pct = tabHeat.sl_householdElectricHeatPumpResidentialArea_pct.getValue();
	boolean cb_householdHTDistrictHeatingActive = tabHeat.cb_householdHTDistrictHeatingResidentialArea.isSelected();
	boolean cb_householdLTDistrictHeatingActive = tabHeat.cb_householdLTDistrictHeatingResidentialArea.isSelected();
	
	p_residentialScenario_Current.setHousesWithGasBurners_pct(housesWithGasBurners_pct);
	p_residentialScenario_Current.setHousesWithHybridHeatpump_pct(housesWithHybridHeatpump_pct);
	p_residentialScenario_Current.setHousesWithElectricHeatpump_pct(housesWithElectricHeatpump_pct);
	p_residentialScenario_Current.setCb_householdHTDistrictHeatingActive(cb_householdHTDistrictHeatingActive);
	p_residentialScenario_Current.setCb_householdLTDistrictHeatingActive(cb_householdLTDistrictHeatingActive);
	
	
	//Houses with Airco
	double housesWithAirco_pct = tabHeat.sl_householdAircoResidentialArea_pct.getValue();
	p_residentialScenario_Current.setHousesWithAirco_pct(housesWithAirco_pct);
	
	//Houses with better isolation
	double housesWithImprovedInsulation_pct = tabHeat.sl_householdHeatDemandReductionResidentialArea_pct.getValue();
	p_residentialScenario_Current.setHousesWithImprovedInsulation_pct(housesWithImprovedInsulation_pct);
	
	//PT
	double nbHousesWithPT_pct = tabHeat.sl_rooftopPTHouses_pct.getValue();
	p_residentialScenario_Current.setNbHousesWithPT_pct(nbHousesWithPT_pct);
}

////Mobility
if(uI_Tabs.pop_tabMobility.size() > 0){
	tabMobility tabMob = uI_Tabs.pop_tabMobility.get(0);
	
	//Private EV
	double privateEVs_pct = tabMob.sl_privateEVsResidentialArea_pct.getValue();
	double privateEVsThatSupportV2G_pct = tabMob.sl_EVsThatSupportV2G_pct.getValue();
	p_residentialScenario_Current.setPrivateEVs_pct(privateEVs_pct);
	p_residentialScenario_Current.setPrivateEVsThatSupportV2G_pct(privateEVsThatSupportV2G_pct);
	
	//Selected charging mode
	String selectedChargingAttitudeStringPrivateEVs = tabMob.cb_chargingAttitudePrivateParkedCars.getValue();
	boolean V2GActivePrivateEVs = tabMob.cb_activateV2GPrivateParkedCars.isSelected();
	p_residentialScenario_Current.setSelectedChargingAttitudeStringPrivateEVs(selectedChargingAttitudeStringPrivateEVs);
	p_residentialScenario_Current.setV2GActivePrivateEVs(V2GActivePrivateEVs);
	
	//Chargers
	double activePublicChargers_pct = tabMob.sl_publicChargersResidentialArea_pct.getValue();
	double chargersV1G_pct = tabMob.sl_chargersThatSupportV1G_pct.getValue();
	double chargersV2G_pct = tabMob.sl_chargersThatSupportV2G_pct.getValue();
	
	p_residentialScenario_Current.setActivePublicChargers_pct(activePublicChargers_pct);
	p_residentialScenario_Current.setChargersV1G_pct(chargersV1G_pct);
	p_residentialScenario_Current.setChargersV2G_pct(chargersV2G_pct);
	
	//Selected charging mode
	String selectedChargingAttitudeStringChargers = tabMob.cb_chargingAttitudePrivatePublicChargers.getValue();
	boolean V2GActiveChargers = tabMob.cb_activateV2GPublicChargers.isSelected();
	p_residentialScenario_Current.setSelectedChargingAttitudeStringChargers(selectedChargingAttitudeStringChargers);
	p_residentialScenario_Current.setV2GActiveChargers(V2GActiveChargers);
} 
  }

  public 
String 
 f_getDateAndTimeString(  ) { 

Date date = energyModel.f_getDate();

SimpleDateFormat formatter = new SimpleDateFormat();
formatter.applyPattern("dd MMM yyyy, kk:mm");

return formatter.format(date); 
  }

  public 
String 
 f_getDateString(  ) { 

Date date = energyModel.f_getDate();

SimpleDateFormat formatter = new SimpleDateFormat();
formatter.applyPattern("dd MMM yyyy");

return formatter.format(date); 
  }

  public void f_setLoadingScreen( boolean visibility, double xOffset, double yOffset ) { 

if (visibility) {
	// Screen Size / View Area is 1920 x 980, so centre at 960, 490
	// Icon Size is 180 x 180, so top left at 960 - 90 = 870, 490 - 90 = 400
	double xPos = 870 + xOffset;
	double yPos = 400 + yOffset;
	
	image_loadingScreenIcon.setPos(xPos, yPos);
	
	// Make sure the image is at the top of the presentation level
	f_setShapePresentationOnTop(image_loadingScreenIcon);
	image_loadingScreenIcon.setVisible(true);
}
else {
	image_loadingScreenIcon.setVisible(false);
} 
  }

  void f_scenarioRadioButtonAction(  ) { 

//Set boolean of running main interface scenario true
b_runningMainInterfaceScenarios = true;

////Set selected scenario
String selected_scenario = f_setSelectedScenario();	

//Set scenario name text to the correct scenario
t_scenarioName.setText("Scenario: " + selected_scenario);
traceln("Selected scenario: \"" + selected_scenario + "\"");

//Deselect the selected building, if selected GC is now paused
if(c_selectedGridConnections.size()>0 && !c_selectedGridConnections.get(0).v_isActive){
	f_clearSelectionAndSelectEnergyModel();
}

//Set boolean of running main interface scenario false
b_runningMainInterfaceScenarios = false;

if(!selected_scenario.equals("Custom")){
	f_resetSettings();
	
	f_updateMainInterfaceSliders();
	
	//Colour recolor pv map again if it is active
	if(c_loadedMapOverlayTypes.get(rb_mapOverlay.getValue()) == OL_MapOverlayTypes.PV_PRODUCTION){
		rb_mapOverlay.setValue(c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.PV_PRODUCTION),true);
	}
}



/*
//Pause simulation and set loading screen
pauseSimulation();
f_setLoadingScreen(true, 0, 0);

new Thread( () -> {
	
	//Set selected scenario
	String selected_scenario = f_setSelectedScenario();		
	
	//Set scenario name text to the correct scenario
	t_scenarioName.setText("Scenario: " + selected_scenario);
	traceln("Selected scenario: \"" + selected_scenario + "\"");
	
	//Deselect the selected building, if selected GC is now paused
	if(c_selectedGridConnections.size()>0 && !c_selectedGridConnections.get(0).v_isActive){
		f_clearSelectionAndSelectEnergyModel();
	}
	
	//Set boolean of running main interface scenario true
	b_runningMainInterfaceScenarios = false;
	
	if(!selected_scenario.equals("Custom")){
		f_resetSettings();
		
		f_updateMainInterfaceSliders();
		
		//Colour recolor pv map again if it is active
		if(c_loadedMapOverlayTypes.get(rb_mapOverlay.getValue()) == OL_MapOverlayTypes.PV_PRODUCTION){
			rb_mapOverlay.setValue(c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.PV_PRODUCTION),true);
		}
	}
	
	//Resume live simulation and remove loading screen
	runSimulation();
	f_setLoadingScreen(false, 0, 0);
	
}).start();
*/ 
  }

  public void f_setScenarioToCustom(  ) { 

String[] scenarioOptions = f_getScenarioOptions();

int customOptionIndex = 0;
for(String scenarioOption : scenarioOptions){
	if(scenarioOption.equals("Custom")){
		break;
	}
	customOptionIndex++;
}

rb_scenarios.setValue(customOptionIndex, true); 
  }

  void f_setFilterComboBoxOptions(  ) { 

//Check wheter a filter will result in anything. The order it is added here, is the order it will show up in the filter drop down menu.
if(energyModel.Houses.size() > 0){
	c_cbFilterOptions.add(OL_FilterOptionsGC.HOUSES);
}
if(energyModel.UtilityConnections.size() > 0){
	c_cbFilterOptions.add(OL_FilterOptionsGC.COMPANIES);
	if(v_numberOfSurveyCompanyGC > 0){
		c_cbFilterOptions.add(OL_FilterOptionsGC.DETAILED);
	}
}

if(findAll(energyModel.pop_GIS_Objects, gisObject -> gisObject.p_GISObjectType == OL_GISObjectType.REGION).size() > 1){
	c_cbFilterOptions.add(SELECTED_NEIGHBORHOOD);
}
if(b_gridLoopsAreDefined){
	c_cbFilterOptions.add(OL_FilterOptionsGC.GRIDTOPOLOGY_SELECTEDLOOP);
}


//More specific default options only available if GC accestype is full
if(user.GCAccessType == OL_UserGCAccessType.FULL){
	c_cbFilterOptions.add(OL_FilterOptionsGC.HAS_PV);
	if(c_cbFilterOptions.contains(OL_FilterOptionsGC.COMPANIES)){
		c_cbFilterOptions.add(OL_FilterOptionsGC.HAS_TRANSPORT);
		c_cbFilterOptions.add(OL_FilterOptionsGC.HAS_EV);
	}
	else{
		for (J_EA ea : energyModel.c_energyAssets) {
		    if (ea instanceof I_Vehicle) {
				c_cbFilterOptions.add(OL_FilterOptionsGC.HAS_TRANSPORT);
				c_cbFilterOptions.add(OL_FilterOptionsGC.HAS_EV);
		        break;
		    }
		}
	}
}

c_cbFilterOptions.add(OL_FilterOptionsGC.NONDETAILED);


String[] filterOptionsNames = new String[1 + c_cbFilterOptions.size()];
filterOptionsNames[0] = "-";
for(int j = 1; j < c_cbFilterOptions.size() + 1; j++){
	filterOptionsNames[j] = map_filterOptionUINames.get(c_cbFilterOptions.get(j-1));
}

cb_filterOptions.setItems(filterOptionsNames, false);

//Set cb to correct option
cb_filterOptions.setValueIndex(0, false);


//Create the reverse of map_filterOptionUINames -> map_UINamesFilterOption
map_UINamesFilterOption = new HashMap<>();
for (Map.Entry<OL_FilterOptionsGC, String> entry : map_filterOptionUINames.entrySet()) {
    map_UINamesFilterOption.put(entry.getValue(), entry.getKey());
}
 
  }

  public void f_selectEnergyModel(  ) { 

v_clickedObjectType = OL_GISObjectType.REGION;
uI_Results.f_updateResultsUI(energyModel);

//Enable kpi summary button
uI_Results.getCheckbox_KPISummary().setEnabled(true); 
  }

  public 
boolean 
 f_checkIfGCsAreAccesible( List<GridConnection> GCList ) { 

if(!settings.isPublicModel() && user.GCAccessType == OL_UserGCAccessType.FULL){
	return true;
}
if(GCList.size() >= p_minSelectedGCForPublicAggregation){
	return true;
}
for(GridConnection GC : GCList){
	if(!GC.p_owner.b_dataIsAccessible){
		return false;
	}
}
return true; 
  }

  protected 
List<GridConnection> 
 f_getMainInterfaceSliderEAGCs(  ) { 

List<GridConnection> electricityTabEASliderGCs = new ArrayList<GridConnection>();

//Find the energy production slider gcs that are not specificly for the EnergyHub
List<GCEnergyProduction> electricityTabEASliderGCs_prod = findAll(energyModel.EnergyProductionSites, sliderProd -> 
	sliderProd.p_isSliderGC && 
	!sliderProd.p_gridConnectionID.equals(p_defaultEnergyHubSliderGCName_solarfarm) && 
	!sliderProd.p_gridConnectionID.equals(p_defaultEnergyHubSliderGCName_windfarm));

//traceln("electricityTabEASliderGCs_prod.size(): %s", electricityTabEASliderGCs_prod.size());																								

if(electricityTabEASliderGCs_prod.size() == 2){
	electricityTabEASliderGCs.addAll(electricityTabEASliderGCs_prod);
}
else{
	throw new RuntimeException("electricityTabEASliderGCs_prod.size() != 2 -> Should be exactly 2, one solarfarm and one windfarm.");
}

//Find the GridBattery slider gcs that are not specificly for the EnergyHub
List<GCGridBattery> electricityTabEASliderGCs_bat = findAll(energyModel.GridBatteries, sliderBat -> sliderBat.p_isSliderGC && 
																									!sliderBat.p_gridConnectionID.equals("EnergyHub battery slider"));

if(project_data.project_type() == OL_ProjectType.BUSINESSPARK && electricityTabEASliderGCs_bat.size() != 1){
	throw new RuntimeException("electricityTabEASliderGCs_bat.size() != 1 -> Should be exactly 1 for businesspark models.");
}
else{
	electricityTabEASliderGCs.addAll(electricityTabEASliderGCs_bat);
}

return electricityTabEASliderGCs; 
  }

  /**
   * Function used to shuffle whatever list, but instead of a fully random shuffle, it is using randomTrue (random but with fixed seed of anylogic). -> For multiple simulations, the outcome will be the same.
   */
  public void f_shuffleListWithFixedSeed( List<?> list ) { 

for (int i = list.size() - 1; i > 0; i--) {
    int j = 0;
    // Go through all possible positions 0..i
    for (int k = 0; k <= i; k++) {
        // With probability 1/(remaining slots), pick this position
        if (randomTrue(1.0 / (i - k + 1))) {
            j = k;
            break; // stop after choosing
        }
    }
    Collections.swap(list, i, j);
} 
  }

  protected void f_setMapOverlay_Custom(  ) { 

//Override function to replace map overlay with custom colors 
  }

  protected void f_setColorsBasedOnCustom_objects( GIS_Object gis_area ) { 

//Override function to replace map overlay with custom colors 
  }

  protected void f_setColorsBasedOnCustom_gridnodes( GridNode GN ) { 

//Override function to replace map overlay with custom colors 
  }

  
List<OL_ChartTypes> 
 f_getSelectedChartTypes_Energy(  ) { 

////TEMPORARY FUNCTION TO LET ALL CURRENT PROJECTS FUNCTION STILL!
List<OL_ChartTypes> loadedChartTypes_Energy = new ArrayList<>();
loadedChartTypes_Energy.add(OL_ChartTypes.PROFILES);
loadedChartTypes_Energy.add(OL_ChartTypes.BAR_TOTALS);
loadedChartTypes_Energy.add(OL_ChartTypes.LOAD_DURATION_CURVES);
loadedChartTypes_Energy.add(OL_ChartTypes.SANKEY);

//Aditional charts selected:
if(settings.resultsUIRadioButtonSetup() != null){
	switch(settings.resultsUIRadioButtonSetup()){
		case DEFAULT_AND_GESPREKSLEIDRAAD:
			loadedChartTypes_Energy.add(OL_ChartTypes.GESPREKSLEIDRAAD);
			break;
		case DEFAULT_AND_GESPREKSLEIDRAADBEDRIJVEN:
			loadedChartTypes_Energy.add(OL_ChartTypes.GESPREKSLEIDRAAD_BEDRIJVEN);
			break;
		case DEFAULT_AND_BATTERY:	
			loadedChartTypes_Energy.add(OL_ChartTypes.BATTERY);
			break;
		case DEFAULT_AND_BATTERY_AND_GESPREKSLEIDRAADBEDRIJVEN:	
			loadedChartTypes_Energy.add(OL_ChartTypes.BATTERY);
			loadedChartTypes_Energy.add(OL_ChartTypes.GESPREKSLEIDRAAD_BEDRIJVEN);
			break;
		case DEFAULT_AND_BATTERY_AND_ECONOMIC:	
			loadedChartTypes_Energy.add(OL_ChartTypes.BATTERY);
			break;
		case DEFAULT_AND_GESPREKSLEIDRAADBEDRIJVEN_AND_GTO:	
			loadedChartTypes_Energy.add(OL_ChartTypes.GESPREKSLEIDRAAD_BEDRIJVEN);
			loadedChartTypes_Energy.add(OL_ChartTypes.GTO);
			break;
		case OFF:
			loadedChartTypes_Energy.clear();
			break;
	}
}
return loadedChartTypes_Energy; 
  }

  void f_clickOnMap( double clickx, double clicky ) { 

if(b_inEnergyHubMode ){
	if(b_inEnergyHubSelectionMode){
		f_selectEnergyHubGC(clickx, clicky);
	}
}
else if(b_inManualFilterSelectionMode){
	f_selectManualFilteredGC(clickx, clicky);
}
else{
	if (uI_Tabs.pop_tabEHub.size() > 0 && uI_Tabs.pop_tabEHub.get(0).b_inCapacitySharingSelectionMode) {
		uI_Tabs.pop_tabEHub.get(0).f_checkGISRegion(clickx, clicky);
	}
	else if (c_selectedFilterOptions.contains(OL_FilterOptionsGC.GRIDTOPOLOGY_SELECTEDLOOP) || 
			c_selectedFilterOptions.contains(OL_FilterOptionsGC.SELECTED_NEIGHBORHOOD)){
		
		if(c_selectedFilterOptions.contains(OL_FilterOptionsGC.GRIDTOPOLOGY_SELECTEDLOOP)){
			f_selectGridLoop(clickx, clicky);
		}
		if(c_selectedFilterOptions.contains(OL_FilterOptionsGC.SELECTED_NEIGHBORHOOD)){
			f_selectNeighborhood(clickx, clicky);
		}
	}
	
	else {
		if(c_selectedFilterOptions.size() > 0){
			f_removeAllFilters();
		}
		f_selectGISRegion(clickx, clicky);
	}
} 
  }

  void f_clearAdditionalGCBuildingSelection(  ) { 

c_selectedObjects.remove(v_clickedObject);
for(GIS_Object previousAdditionalSelectedObjects : c_selectedObjects){
	f_styleAreas(previousAdditionalSelectedObjects);
}
c_selectedObjects = new ArrayList<>(List.of(v_clickedObject)); 
  }

  void f_switchSelectedGCInBuilding(  ) { 

c_selectedGridConnections.add(v_clickedObject.c_containedGridConnections.get(v_selectedGridConnectionIndex -1));
if(c_selectedGridConnections.get(0).c_connectedGISObjects.size() > 1){ //Also color all buildings attached to the selected GC
	c_selectedObjects = new ArrayList<>(c_selectedGridConnections.get(0).c_connectedGISObjects);
	for (GIS_Object obj : c_selectedObjects) {
		obj.gisRegion.setFillColor(v_selectionColorAddBuildings);
	}
}
uI_Results.f_updateResultsUI(c_selectedGridConnections.get(0)); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_outsideTemperature_expression0_dataSet_xjal_XValue(  ) {
	return _datasetUpdateTime_xjal();
  }
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_outsideTemperature_expression0_dataSet_xjal_YValue(  ) {
    return 
v_outsideTemperature 
;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_solarIrradiance_expression0_dataSet_xjal_XValue(  ) {
	return _datasetUpdateTime_xjal();
  }
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_solarIrradiance_expression0_dataSet_xjal_YValue(  ) {
    return 
v_solarIrradiance 
;
  }

  // View areas
  public ViewArea va_Interface = new ViewArea( this, null, 0, 0, 1920, 980 );
  public ViewArea va_EHubDashboard = new ViewArea( this, null, 2600, -2200, 1920, 980 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1920.0, 980.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "va_Interface", this.va_Interface );
      _output.put( "va_EHubDashboard", this.va_EHubDashboard );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 3 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_goToUI_Font = new Font("Dialog", 1, 9 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_scenarios_template_Font = new Font("Dialog", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_gotoEngine_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_nextBuilding_Font = new Font("Dialog", 0, 9 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_previousBuilding_Font = _button_nextBuilding_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_cables_Font = _button_gotoEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_showFilterInterface_Font = _button_gotoEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_filterOptions_Font = _button_gotoEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_clearFilters_Font = _button_gotoEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_removeManualSelection_Font = _button_gotoEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_manualFilterSelection_Font = _button_gotoEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_completeManualSelectionMode_Font = _button_gotoEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_mapOverlayLegend_congestion_Font = _button_nextBuilding_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_input_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_simulationEngine_Font = new Font("SansSerif", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_date_Font = new Font("SansSerif", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_legendaColors_Font = new Font("SansSerif", 1, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_mapClickingFunctions_Font = _t_legendaColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_stylingFunctions_Font = _t_simulationEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_clickedObjectInfo_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_buildingColors_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gridnodeColors_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specificBuildingColors_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_areaColors_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_generalColors_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_additionalUIs_Font = _t_simulationEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_scenarios_Font = new Font("Calibri", 1, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_scenarioDescription_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_scenarioName_Font = new Font("Calibri", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_resultsUIFunctions_Font = _t_simulationEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_scenarioDictionaries_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_initializationFunctions_Font = _t_simulationEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_inputParameters_Font = _t_simulationEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_ordereringDescription_Font = _t_date_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_outsideTemperature_Font = new Font("Cambria", 1, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_solarIrradiance_Font = _t_outsideTemperature_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_windSpeed_Font = _t_outsideTemperature_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_multipleBuildingInfo_Font = _t_scenarioDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayFunctionalities_Font = _t_input_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_scenarioFunctions_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_sliderInitialization_Font = _t_simulationEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_GISObjectCreationFunctions_Font = _t_simulationEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_selectionColors_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_filterFunctions_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_filterDescription_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_activeFilters_Font = _t_clickedObjectInfo_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_activeFilters_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_filterInterface_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_selectedGridLoop_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_selectedNBh_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_errorMessage_Font = new Font("SansSerif", 1, 24 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_errorOK_Font = _t_legendaColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_dataAccesibilityFunctionalities_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_infoBubbleFunctions_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_publicVersion_Font = _t_errorMessage_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_dynamicLegend_Font = _t_input_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_visualObjects_Font = _t_simulationEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_infoTextHeader_Font = new Font("Calibri", 1, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_infoTextDescription_Font = _t_simulationEngine_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_forcedClickMessage_Font = new Font("SansSerif", 0, 36 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_completeEnergyHubSelection_grayedOut_Font = new Font("SansSerif", 1, 28 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_completeEnergyHubSelection_Font = _txt_completeEnergyHubSelection_grayedOut_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_energyHubConfigurator_Font = new Font("SansSerif", 0, 48 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_cancelEnergyHubConfiguration_Font = _txt_completeEnergyHubSelection_grayedOut_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_supportFunctions_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_legenda_Font = new Font("Calibri", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_infrastructure_Font = new Font("Calibri", 0, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_congestedGridnode_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_gridnode_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_strainedGridnode_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_MV_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_LV_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_buildings_Font = _t_infrastructure_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_colorings_Font = _t_scenarioDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_ElectricityConsumption1_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_ElectricityConsumption2_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_ElectricityConsumption3_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_ElectricityConsumption4_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_ElectricityConsumption5_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_defaultLegend2_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_defaultLegend5_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_defaultLegend3_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_defaultLegend4_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_defaultLegend1_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_PVProduction1_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_PVProduction2_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_PVProduction3_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_gridNeighbours1_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_gridNeighbours2_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_gridNeighbours3_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_gridNeighbours4_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_gridNeighbours5_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_congestion3_Font = _t_scenarioDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_congestion1_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_congestion2_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_EnergyLabelA_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_EnergyLabelB_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_EnergyLabelC_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_EnergyLabelD_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_EnergyLabelE_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_EnergyLabelF_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_EnergyLabelG_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayLegend_EnergyLabelUnknown_Font = _txt_mapOverlayLegend_ElectricityConsumption1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend1_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend2_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend3_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend4_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend5_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend6_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend7_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend8_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend9_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend10_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend11_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_specialGISObjectLegend12_Font = _t_scenarioDictionaries_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_seeMoreLegend_Font = new Font("SansSerif", 2, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_loadIconSmall_Font = new Font("SansSerif", 1, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_simulateYearToCalculateCostsSmall_Font = _t_loadIconSmall_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_cablesAndPipesColors_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mapOverlayColors_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_projectSpecificScenarios_Font = _t_buildingColors_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_defaultSliderNames_Font = _t_date_Font;
  protected static final Color _rect_logoBackground_Fill_Color = new Color( 0x28B0C4DE, true );
  protected static final Color _arc_zoomIn_Fill_Color = new Color( 0xFF2C2C2C, true );
  protected static final Color _arc_zoomIn_Line_Color = new Color( 0xFF2C2C2C, true );
  protected static final Color _arc_zoomOut_Fill_Color = new Color( 0xFF2C2C2C, true );
  protected static final Color _arc_zoomOut_Line_Color = new Color( 0xFF2C2C2C, true );
  protected static final Color _rect_zoomButton_Fill_Color = new Color( 0xFF2C2C2C, true );
  protected static final Color _rect_zoomButton_Line_Color = new Color( 0xFF2C2C2C, true );
  @AnyLogicInternalCodegenAPI
  protected static final Color _t_outsideTemperature_Color = new Color( 0xFF8B8B8B, true );
  @AnyLogicInternalCodegenAPI
  protected static final Color _t_solarIrradiance_Color = new Color( 0xFF8B8B8B, true );
  @AnyLogicInternalCodegenAPI
  protected static final Color _t_windSpeed_Color = new Color( 0xFF8B8B8B, true );
  protected static final Color _rect_errorScreenGrayOut_Fill_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_errorScreenGrayOut_Line_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_errorScreenClickBlocking_Fill_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_errorScreenClickBlocking_Line_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_sliderClickBlocker2_Fill_Color = new Color( 0xFFFFFF, true );
  protected static final Color _rect_forceMapSelectionClickBlocker1_Fill_Color = new Color( 0xFFFFFF, true );
  protected static final Color _rect_forceMapSelectionClickBlocker2_Fill_Color = new Color( 0xFFFFFF, true );
  protected static final Color _rect_forceMapSelectionClickBlocker3_Fill_Color = new Color( 0xFFFFFF, true );
  protected static final Color _rect_forceMapSelectionClickBlocker4_Fill_Color = new Color( 0xFFFFFF, true );
  protected static final Color _rect_forceMapSelection1_Fill_Color = new Color( 0x96C0C0C0, true );
  protected static final Color _rect_forceMapSelection2_Fill_Color = new Color( 0x96C0C0C0, true );
  protected static final Color _rect_forceMapSelection3_Fill_Color = new Color( 0x96C0C0C0, true );
  protected static final Color _rect_forceMapSelection4_Fill_Color = new Color( 0x96C0C0C0, true );
  protected static final Color _button_cancelEnergyHubConfiguration_Line_Color = new Color( 0xFFDC3545, true );
  protected static final Color _rect_mapOverlayLegend_ElectricityConsumption3_Fill_Color = new Color( 0xFFFBF9A2, true );
  protected static final Color _rect_mapOverlayLegend_ElectricityConsumption4_Fill_Color = new Color( 0xFFEFC472, true );
  protected static final Color _rect_loadIconSmall_Fill_Color = new Color( 0xE9F5F5F5, true );
  protected static final Color _zenmocolor_blue3_Fill_Color = new Color( 0xFFC1E6E6, true );
  protected static final Color _zenmocolor_blue_Fill_Color = new Color( 0xFF007E84, true );
  protected static final Color _zenmocolor_blue1_Fill_Color = new Color( 0xFF289CA0, true );
  protected static final Color _zenmocolor_yellow_Fill_Color = new Color( 0xFFFCC200, true );
  protected static final Color _zenmocolor_yellow1_Fill_Color = new Color( 0xFFF9CE3E, true );
  protected static final Color _zenmocolor_yellow2_Fill_Color = new Color( 0xFFF9DC7C, true );
  protected static final Color _zenmocolor_yellow3_Fill_Color = new Color( 0xFFF9EBBB, true );
  protected static final Color _zenmocolor_red_Fill_Color = new Color( 0xFFE4005B, true );
  protected static final Color _zenmocolor_red1_Fill_Color = new Color( 0xFFEA3A81, true );
  protected static final Color _zenmocolor_red2_Fill_Color = new Color( 0xFFF279A9, true );
  protected static final Color _zenmocolor_red3_Fill_Color = new Color( 0xFFF7B9D2, true );
  protected static final Color _zenmocolor_blue2_Fill_Color = new Color( 0xFF5FBCBF, true );
  protected static final Color _line1_Line_Color = new Color( 0xFFF9DC7C, true );
  protected static final Color _line2_Line_Color = new Color( 0xFFF9DC7C, true );
  protected static final Color _line3_Line_Color = new Color( 0xFFF9DC7C, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_sliderCollectionOrdering = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_canvas = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_gismap = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _pop_UI_EnergyHub_presentation = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_energyHubPresentation = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_logoBackground = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_tueLogo = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_luxLogo = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_zenmoLogo = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_logos = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mainFunctions = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_simulationEngine = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_input = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_input = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_simulationEngine = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_simulationEngine = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_date = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _arc_zoomIn = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _arc_zoomOut = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_zoomButton = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_zoomButtonSeperator = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_zoomIn1 = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_zoomIn2 = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_zoomOut = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_zoomIn = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_zoomOut = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_zoomButton = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_legendaColors = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_mapClickingFunctions = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_stylingFunctions = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_clickedObjectInfo = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_clickedObjectInfo = 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_clickedObjectInfo = 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_buildingColors = 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gridnodeColors = 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specificBuildingColors = 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_areaColors = 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_generalColors = 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_additionalUIs = 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_scenarios = 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_scenarioDescription = 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_scenarioName = 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_scenarioDescription = 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_resultsUIFunctions = 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_scenarioDictionaries = 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_initializationFunctions = 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_inputParameters = 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_ordereringDescription = 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_ordereringDescription = 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_outsideTemperature = 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_solarIrradiance = 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_windSpeed = 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_multipleBuildingInfo = 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_multipleBuildingInfo = 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_CustomColors = 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayFunctionalities = 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _uI_Tabs_presentation = 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_scenarioText = 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_scenarioFunctions = 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _map = 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_sliderInitialization = 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_GISObjectCreationFunctions = 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _uI_Results_presentation = 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_uI_Results_presentation = 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_filterFunctions = 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_selectionColors = 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_filterFunctions = 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_filterInterface = 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_filterDescription = 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_activeFilters = 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_activeFilters = 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_filterInterface = 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_selectedGridLoop = 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_selectedNBh = 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_filterInterface = 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_errorScreenGrayOut = 76;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_errorScreenClickBlocking = 77;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_errorMessage = 78;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_errorMessage = 79;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_errorOK = 80;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_errorOK = 81;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_errorOK = 82;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_errorScreen = 83;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_sliderClickBlocker = 84;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_sliderClickBlocker2 = 85;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_sliderClickBlocker = 86;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_dataAccesibilityFunctionalities = 87;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_ìnfoBubbleFunctions = 88;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_infoBubbleFunctions = 89;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_publicVersion = 90;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_publicVersionWarningMessage = 91;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_publicVersionWarningMessage = 92;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_dynamicLegend = 93;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_dynamicLegend = 94;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_visualObjects = 95;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_infoText = 96;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_closeInfoText = 97;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_closeInfoText1 = 98;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_closeInfoText2 = 99;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_closeInfoText = 100;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_infoTextHeader = 101;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_infoTextDescription = 102;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_infoText = 103;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceMapSelectionClickBlocker1 = 104;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceMapSelectionClickBlocker2 = 105;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceMapSelectionClickBlocker3 = 106;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceMapSelectionClickBlocker4 = 107;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceMapSelection1 = 108;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceMapSelection2 = 109;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceMapSelection3 = 110;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceMapSelection4 = 111;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_selectText = 112;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_forcedClickMessage = 113;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_ForceMapSelectionText = 114;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_completeSelection_grayedOut = 115;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_completeEnergyHubSelection_grayedOut = 116;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_completeEnergyHubSelection_grayedOut = 117;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_completeSelection = 118;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_completeEnergyHubSelection = 119;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_completeEnergyHubSelection = 120;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_energyHubConfigurator = 121;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_energyHubConfigurator = 122;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_energieHubConfiguratorTxt = 123;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_cancelEnergyHubConfiguration = 124;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_cancelEnergyHubConfiguration = 125;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_cancelEnergyHubConfiguration = 126;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_energyHubSelectionButtons = 127;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_forceMapSelection = 128;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_supportFunctions = 129;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_supportFunctions = 130;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_supportFunctions = 131;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_legenda = 132;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_legenda = 133;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_legendaSeperator1 = 134;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_legendaSeperator2 = 135;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_infrastructure = 136;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_infrastructure = 137;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline_congestedGridnode = 138;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_congestedGridnode = 139;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline_gridnode = 140;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_gridnode = 141;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline_strainedGridnode = 142;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_strainedGridnode = 143;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gridnodes = 144;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_MV = 145;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_LV = 146;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_LV = 147;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_MV = 148;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_cablesLegend = 149;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_infrastructure = 150;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_buildings = 151;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_buildings = 152;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_colorings = 153;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_colorings = 154;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_buildings = 155;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_ElectricityConsumption1 = 156;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_ElectricityConsumption2 = 157;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_ElectricityConsumption3 = 158;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_ElectricityConsumption4 = 159;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_ElectricityConsumption5 = 160;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_ElectricityConsumption1 = 161;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_ElectricityConsumption2 = 162;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_ElectricityConsumption3 = 163;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_ElectricityConsumption4 = 164;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_ElectricityConsumption5 = 165;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_mapOverlayLegend_ElectricityConsumption = 166;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_defaultLegend4 = 167;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_defaultLegend2 = 168;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_defaultLegend5 = 169;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_defaultLegend5 = 170;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_defaultLegend3 = 171;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_defaultLegend2 = 172;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_defaultLegend4 = 173;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_defaultLegend3 = 174;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_defaultLegend1 = 175;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_defaultLegend1 = 176;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_defaultLegenda = 177;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_PVProduction1 = 178;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_PVProduction2 = 179;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_PVProduction3 = 180;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_PVProduction1 = 181;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_PVProduction2 = 182;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_PVProduction3 = 183;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_mapOverlayLegend_PVProduction = 184;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_gridNeighbours1 = 185;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_gridNeighbours2 = 186;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_gridNeighbours3 = 187;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_gridNeighbours1 = 188;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_gridNeighbours2 = 189;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_gridNeighbours3 = 190;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_gridNeighbours4 = 191;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_gridNeighbours4 = 192;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_gridNeighbours5 = 193;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_mapOverlayLegend_gridNeighbours = 194;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_congestion3 = 195;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_congestion1 = 196;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_congestion1 = 197;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_mapOverlayLegend_congestion_Degrees = 198;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_congestion21 = 199;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_congestion22 = 200;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_congestion23 = 201;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_rect_mapOverlayLegend_congestion2 = 202;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_congestion2 = 203;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_mapOverlayLegend_congestion_Types = 204;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_mapOverlayLegend_congestion = 205;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_EnergyLabelA = 206;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_EnergyLabelB = 207;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_EnergyLabelC = 208;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_EnergyLabelD = 209;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_EnergyLabelE = 210;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_EnergyLabelA = 211;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_EnergyLabelB = 212;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_EnergyLabelC = 213;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_EnergyLabelD = 214;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_EnergyLabelE = 215;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_EnergyLabelF = 216;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_EnergyLabelF = 217;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_EnergyLabelG = 218;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_EnergyLabelG = 219;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mapOverlayLegend_EnergyLabelUnknown = 220;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayLegend_EnergyLabelUnknown = 221;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_mapOverlayLegend_EnergyLabel = 222;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_mapOverlayLegenda = 223;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend1 = 224;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend1 = 225;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend2 = 226;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend2 = 227;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend3 = 228;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend3 = 229;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend4 = 230;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend4 = 231;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend5 = 232;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend5 = 233;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend6 = 234;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend6 = 235;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_extendedLegendLine = 236;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_extendedLegend = 237;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend7 = 238;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend7 = 239;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend8 = 240;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend8 = 241;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend9 = 242;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend9 = 243;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend10 = 244;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend10 = 245;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend11 = 246;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend11 = 247;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_specialGISObjectLegend12 = 248;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_specialGISObjectLegend12 = 249;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = 250;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_extendedLegend = 251;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_seeMoreLegend = 252;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_specificGISObjectLegend = 253;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_legenda = 254;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_loadIconSmall = 255;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_loadIconSmall = 256;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_loadIconSmall = 257;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_loadIconYearSimulation = 258;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_simulateYearScreenSmall = 259;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_simulateYearToCalculateCostsSmall = 260;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_simulateYearToCalculateCostsSmall = 261;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_simulateYearButton = 262;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_simulateYear = 263;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_simulateYearScreen = 264;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_cablesAndPipesColors = 265;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mapOverlayColors = 266;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_blue3 = 267;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_blue = 268;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_blue1 = 269;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_yellow = 270;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_yellow1 = 271;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_yellow2 = 272;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_yellow3 = 273;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_red = 274;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_red1 = 275;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_red2 = 276;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_red3 = 277;
  @AnyLogicInternalCodegenAPI
  protected static final int _zenmocolor_blue2 = 278;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = 279;
  @AnyLogicInternalCodegenAPI
  protected static final int _line2 = 280;
  @AnyLogicInternalCodegenAPI
  protected static final int _line3 = 281;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_projectSpecificScenarios = 282;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_loadingScreenIcon = 283;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_defaultSliderNames = 284;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_defaultSliderNames = 285;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_outsideTemperature = 286;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_solarIrradiance = 287;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_goToUI = 288;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_scenarios_template = 289;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_gotoEngine = 290;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_nextBuilding = 291;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_previousBuilding = 292;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_cables = 293;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_showFilterInterface = 294;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_filterOptions = 295;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_clearFilters = 296;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_removeManualSelection = 297;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_manualFilterSelection = 298;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_completeManualSelectionMode = 299;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_mapOverlayLegend_congestion = 300;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 301;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    if (_a == uI_Tabs) { return true; }
    if (_a == uI_Results) { return true; }
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_congestedGridnode_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 20.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_congestedGridnode_pointsDY_xjal() {
    return new double[] { 0.0, -14.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_congestedGridnode_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_gridnode_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 20.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_gridnode_pointsDY_xjal() {
    return new double[] { 0.0, -14.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_gridnode_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_strainedGridnode_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 20.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_strainedGridnode_pointsDY_xjal() {
    return new double[] { 0.0, -14.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_strainedGridnode_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rect_sliderCollectionOrdering, rect_canvas, rect_gismap, gr_energyHubPresentation, gr_logos, rect_mainFunctions, rect_simulationEngine, rect_input, t_input, line_simulationEngine, t_simulationEngine, t_date, gr_zoomButton, t_legendaColors, t_mapClickingFunctions, t_stylingFunctions, gr_clickedObjectInfo, t_buildingColors, t_gridnodeColors, t_specificBuildingColors, t_areaColors, txt_generalColors, button_goToUI, txt_additionalUIs, rb_scenarios_template, t_scenarios, gr_scenarioDescription, t_resultsUIFunctions, t_scenarioDictionaries, t_initializationFunctions, t_inputParameters, button_gotoEngine, line_ordereringDescription, t_ordereringDescription, t_outsideTemperature, t_solarIrradiance, t_windSpeed, plot_outsideTemperature, plot_solarIrradiance, gr_multipleBuildingInfo, rect_CustomColors, txt_mapOverlayFunctionalities, uI_Tabs_presentation, rect_scenarioText, txt_scenarioFunctions, checkbox_cables, map, txt_sliderInitialization, txt_GISObjectCreationFunctions, gr_uI_Results_presentation, rect_filterFunctions, t_selectionColors, txt_filterFunctions, cb_showFilterInterface, gr_filterInterface, gr_errorScreen, gr_sliderClickBlocker, txt_dataAccesibilityFunctionalities, rect_ìnfoBubbleFunctions, txt_infoBubbleFunctions, gr_publicVersionWarningMessage, rect_dynamicLegend, txt_dynamicLegend, txt_visualObjects, gr_infoText, gr_forceMapSelection, gr_supportFunctions, gr_legenda, gr_simulateYearScreen, txt_cablesAndPipesColors, txt_mapOverlayColors, zenmocolor_blue3, zenmocolor_blue, zenmocolor_blue1, zenmocolor_yellow, zenmocolor_yellow1, zenmocolor_yellow2, zenmocolor_yellow3, zenmocolor_red, zenmocolor_red1, zenmocolor_red2, zenmocolor_red3, zenmocolor_blue2, line1, line2, line3, txt_projectSpecificScenarios, image_loadingScreenIcon, rect_defaultSliderNames, txt_defaultSliderNames);
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level1_xjal() {
	  level1.addAll();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _image_tueLogo:
        if (true) {
          ShapeImage self = this.image_tueLogo;
          
getExperimentHost().openWebSite("https://www.tue.nl/en/"); 
        }
        break;
      case _image_luxLogo:
        if (true) {
          ShapeImage self = this.image_luxLogo;
          
//Go to website on click
getExperimentHost().openWebSite("https://lux.energy/");
 
        }
        break;
      case _image_zenmoLogo:
        if (true) {
          ShapeImage self = this.image_zenmoLogo;
          
getExperimentHost().openWebSite("https://zenmo.com/"); 
        }
        break;
      case _rect_zoomIn:
        if (true) {
          ShapeRectangle self = this.rect_zoomIn;
          
map.zoomIn(); 
        }
        break;
      case _rect_zoomOut:
        if (true) {
          ShapeRectangle self = this.rect_zoomOut;
          
map.zoomOut(); 
        }
        break;
      case _map:
        if (true) {
          ShapeGISMap self = this.map;
          
f_clickOnMap(clickx, clicky); 
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
      case _rect_sliderClickBlocker:
        if (true) {
          ShapeRectangle self = this.rect_sliderClickBlocker;
          
int clickBlocker; 
        }
        break;
      case _i_publicVersionWarningMessage:
        if (true) {
          ShapeImage self = this.i_publicVersionWarningMessage;
          
f_setInfoText(i_publicVersionWarningMessage, v_infoText.publicVersionWarning, i_publicVersionWarningMessage.getX() + gr_publicVersionWarningMessage.getX(), i_publicVersionWarningMessage.getY() + gr_publicVersionWarningMessage.getY()); 
        }
        break;
      case _gr_closeInfoText:
        if (true) {
          ShapeGroup self = this.gr_closeInfoText;
          
p_currentActiveInfoBubble.clear();
gr_infoText.setVisible(false); 
        }
        break;
      case _rect_forceMapSelectionClickBlocker1:
        if (true) {
          ShapeRectangle self = this.rect_forceMapSelectionClickBlocker1;
          
int clickblocker; 
        }
        break;
      case _rect_forceMapSelectionClickBlocker2:
        if (true) {
          ShapeRectangle self = this.rect_forceMapSelectionClickBlocker2;
          
int clickblocker; 
        }
        break;
      case _rect_forceMapSelectionClickBlocker3:
        if (true) {
          ShapeRectangle self = this.rect_forceMapSelectionClickBlocker3;
          
int clickblocker; 
        }
        break;
      case _rect_forceMapSelectionClickBlocker4:
        if (true) {
          ShapeRectangle self = this.rect_forceMapSelectionClickBlocker4;
          
int clickblocker; 
        }
        break;
      case _gr_completeEnergyHubSelection:
        if (true) {
          ShapeGroup self = this.gr_completeEnergyHubSelection;
          
f_finalizeEnergyHubConfiguration(); 
        }
        break;
      case _gr_cancelEnergyHubConfiguration:
        if (true) {
          ShapeGroup self = this.gr_cancelEnergyHubConfiguration;
          
f_cancelEnergyHubConfiguration(); 
        }
        break;
      case _i_mapOverlayLegend_congestion_Degrees:
        if (true) {
          ShapeImage self = this.i_mapOverlayLegend_congestion_Degrees;
          
f_setInfoText(i_mapOverlayLegend_congestion_Degrees, v_infoText.i_mapOverlayLegend_congestion_Degrees, i_mapOverlayLegend_congestion_Degrees.getX() + gr_mapOverlayLegend_congestion.getX() + gr_mapOverlayLegenda.getX()  + gr_legenda.getX(), i_mapOverlayLegend_congestion_Degrees.getY() + gr_mapOverlayLegend_congestion.getY() + gr_mapOverlayLegenda.getY()  + gr_legenda.getY()); 
        }
        break;
      case _i_mapOverlayLegend_congestion_Types:
        if (true) {
          ShapeImage self = this.i_mapOverlayLegend_congestion_Types;
          
f_setInfoText(i_mapOverlayLegend_congestion_Types, v_infoText.i_mapOverlayLegend_congestion_Types, i_mapOverlayLegend_congestion_Types.getX() + gr_mapOverlayLegend_congestion.getX() + gr_mapOverlayLegenda.getX() + gr_legenda.getX(), i_mapOverlayLegend_congestion_Types.getY() + gr_mapOverlayLegend_congestion.getY() + gr_mapOverlayLegenda.getY() + gr_legenda.getY()); 
        }
        break;
      case _t_seeMoreLegend:
        if (true) {
          ShapeText self = this.t_seeMoreLegend;
          
if(!gr_extendedLegend.isVisible()){
	gr_extendedLegend.setVisible(true);
	t_seeMoreLegend.setText("Zie minder...");
}
else{
	gr_extendedLegend.setVisible(false);
	t_seeMoreLegend.setText("Zie meer...");
} 
        }
        break;
      case _gr_simulateYearButton:
        if (true) {
          ShapeGroup self = this.gr_simulateYearButton;
          
f_simulateYearFromMainInterface(); 
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
      case _button_goToUI: {
          ShapeButton self = this.button_goToUI;
if(energyModel.v_rapidRunData != null){
	switch(v_clickedObjectType){
	
		case BUILDING:
			uI_Company.f_setCompanyUI(c_selectedGridConnections.get(0));
			uI_Company.va_companyUI.navigateTo();
			v_currentViewArea = uI_Company.va_companyUI;
			break;
		
		case ELECTROLYSER:
			//uI_Hydrogen.f_setHydrogenUI(c_selectedGridConnections.get(0));
			//uI_Hydrogen.va_hydrogenUI.navigateTo();
			//v_currentViewArea = uI_Hydrogen.va_hydrogenUI;
			break;
		
		case BATTERY:
			//uI_Battery.f_setBatteryUI(c_selectedGridConnections.get(0));
			//uI_Battery.va_batteryUI.navigateTo();
			//v_currentViewArea = uI_Battery.va_batteryUI;
			break;
		
		case SOLARFARM:
		case WINDFARM:
		case CHARGER:
		default:
		break;
	}
}
else{
	f_setErrorScreen("Je kan alleen naar de companyUI gaan als er een jaar simulatie is voltooid.", 0, 0);
}
 
;}
        break;
      case _button_gotoEngine: {
          ShapeButton self = this.button_gotoEngine;
energyModel.va_engine.navigateTo(); 
;}
        break;
      case _button_nextBuilding: {
          ShapeButton self = this.button_nextBuilding;
if (v_selectedGridConnectionIndex < v_nbGridConnectionsInSelectedBuilding ){
	c_selectedGridConnections.clear();
	v_selectedGridConnectionIndex += 1;

	if(v_customEnergyCoop != null){
		energyModel.f_removeEnergyCoop(v_customEnergyCoop, energyModel.p_timeVariables);
		v_customEnergyCoop = null;
	}
	
	if(c_selectedObjects.size()> 1){
		f_clearAdditionalGCBuildingSelection();
	}

	if( v_selectedGridConnectionIndex > 0){// Index > 0 -> Select the gc at the index in the building containedGC (index 1 = index 0 in containedGC). 
		f_switchSelectedGCInBuilding();
	}

	//Set dashboard UI button
	f_setUIButton();
} 
;}
        break;
      case _button_previousBuilding: {
          ShapeButton self = this.button_previousBuilding;
if (v_selectedGridConnectionIndex > 0){
	c_selectedGridConnections.clear();
	v_selectedGridConnectionIndex -= 1;
	
	if(c_selectedObjects.size()> 1){
		f_clearAdditionalGCBuildingSelection();
	}
	
	if( v_selectedGridConnectionIndex > 0){// Index > 0 -> Select the gc at the index in the building containedGC (index 1 = index 0 in containedGC). 
		f_switchSelectedGCInBuilding();
	}
	else { // Index = 0 -> Create coop containing all gc in this building, to visualize the total of the building
		c_selectedGridConnections.addAll(v_clickedObject.c_containedGridConnections);
		
		v_customEnergyCoop = energyModel.f_addEnergyCoop(c_selectedGridConnections, energyModel.p_timeParameters);
		uI_Results.f_updateResultsUI(v_customEnergyCoop);
	}
	
	//Set dashboard UI button
	f_setUIButton();
} 
;}
        break;
      case _button_clearFilters: {
          ShapeButton self = this.button_clearFilters;
c_filterSelectedGridLoops.clear();
c_filterSelectedNeighborhoods.clear();
c_manualFilterSelectedGC.clear();
c_manualFilterDeselectedGC.clear();
b_inManualFilterSelectionMode = false;
if (c_manualFilterSelectedGC.isEmpty() && c_manualFilterDeselectedGC.isEmpty() && c_selectedFilterOptions.contains(OL_FilterOptionsGC.MANUAL_SELECTION)){
	f_setFilter(OL_FilterOptionsGC.MANUAL_SELECTION);
}

f_setForcedClickScreenText("");
if(!b_inEnergyHubSelectionMode){
	f_setForcedClickScreenVisibility(false);
}
	
f_removeAllFilters();
traceln("Alle filters zijn verwijderd."); 
;}
        break;
      case _button_removeManualSelection: {
          ShapeButton self = this.button_removeManualSelection;
if(c_selectedFilterOptions.contains(OL_FilterOptionsGC.MANUAL_SELECTION)){
	c_manualFilterSelectedGC.clear();
	c_manualFilterDeselectedGC.clear();
	
	f_setForcedClickScreenText("");
	if(!b_inEnergyHubSelectionMode){
		f_setForcedClickScreenVisibility(false);
	}
	
	b_inManualFilterSelectionMode = false;
	if (c_manualFilterSelectedGC.isEmpty() && c_manualFilterDeselectedGC.isEmpty() && c_selectedFilterOptions.contains(OL_FilterOptionsGC.MANUAL_SELECTION)){
		f_setFilter(OL_FilterOptionsGC.MANUAL_SELECTION);
	}
} 
;}
        break;
      case _button_manualFilterSelection: {
          ShapeButton self = this.button_manualFilterSelection;
if(!b_inManualFilterSelectionMode){
	b_inManualFilterSelectionMode = true;
	
	f_setForcedClickScreenText("(De)Selecteer gebouwen");
	if(!b_inEnergyHubSelectionMode){
		f_setForcedClickScreenVisibility(true);
	}
	
	if(!c_selectedFilterOptions.contains(OL_FilterOptionsGC.MANUAL_SELECTION)){
		f_setFilter(OL_FilterOptionsGC.MANUAL_SELECTION);
	}
}
else{ 
	b_inManualFilterSelectionMode = false;
	
	f_setForcedClickScreenText("");
	if(!b_inEnergyHubSelectionMode){
		f_setForcedClickScreenVisibility(false);
	}
	
	if (c_manualFilterSelectedGC.isEmpty() && c_manualFilterDeselectedGC.isEmpty() && c_selectedFilterOptions.contains(OL_FilterOptionsGC.MANUAL_SELECTION)){
		f_setFilter(OL_FilterOptionsGC.MANUAL_SELECTION);
	}
} 
;}
        break;
      case _button_completeManualSelectionMode: {
          ShapeButton self = this.button_completeManualSelectionMode;
if(b_inManualFilterSelectionMode){
	button_manualFilterSelection.action();
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
      case _checkbox_cables: {
          ShapeCheckBox self = this.checkbox_cables;
boolean showCables = checkbox_cables.isSelected();

for(GISRoute GISCable : c_LVCables){
	GISCable.setVisible(showCables);
}

for(GISRoute GISCable : c_MVCables){
	GISCable.setVisible(showCables);
}

gr_cablesLegend.setVisible(showCables); 
;}
        break;
      case _cb_showFilterInterface: {
          ShapeCheckBox self = this.cb_showFilterInterface;
gr_filterInterface.setVisible(cb_showFilterInterface.isSelected());

if(!cb_showFilterInterface.isSelected()){
	button_clearFilters.action();
	gr_sliderClickBlocker.setVisible(false);
}
else{
	gr_sliderClickBlocker.setVisible(true);
	gr_filterInterface.setPos(170, 710);
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
  public void executeShapeControlAction( int _shape, int index, int value ) {
    switch( _shape ) {
      case _rb_scenarios_template: {
          ShapeRadioButtonGroup self = this.rb_scenarios_template;
f_scenarioRadioButtonAction(); 
;}
        break;
      case _rb_mapOverlayLegend_congestion: {
          ShapeRadioButtonGroup self = this.rb_mapOverlayLegend_congestion;
rb_mapOverlay.setValue(rb_mapOverlay.getValue(), true); 
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
      case _cb_filterOptions: {
          ShapeComboBox self = this.cb_filterOptions;
if(!cb_filterOptions.getValue().equals("-")){
	f_setFilter(map_UINamesFilterOption.get(cb_filterOptions.getValue()));
	
	cb_filterOptions.setValueIndex(0);
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
      case _checkbox_cables: return 
false 
;
      default: return super.getShapeControlDefaultValueBoolean( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getShapeControlDefaultValueInt( int _shape, int index ) {
    switch(_shape) {
      case _rb_scenarios_template: return 
0 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  protected ShapeButton button_goToUI;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rb_scenarios_template_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    boolean _visible = 
false 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeRadioButtonGroup rb_scenarios_template;
  protected ShapeButton button_gotoEngine;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_nextBuilding_SetDynamicParams_xjal( ShapeButton shape ) {
    shape.setEnabled(
v_selectedGridConnectionIndex < v_nbGridConnectionsInSelectedBuilding 
);
  }
  
  protected ShapeButton button_nextBuilding;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_previousBuilding_SetDynamicParams_xjal( ShapeButton shape ) {
    shape.setEnabled(
v_selectedGridConnectionIndex > 0 
);
  }
  
  protected ShapeButton button_previousBuilding;
  protected ShapeCheckBox checkbox_cables;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _cb_showFilterInterface_SetDynamicParams_xjal( ShapeCheckBox shape ) {
    boolean _visible = 
cb_showFilterInterface.isEnabled() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
!settings.isPublicModel() && c_cbFilterOptions.size() > 0 
);
 	}
  }
  
  protected ShapeCheckBox cb_showFilterInterface;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _cb_filterOptions_SetDynamicParams_xjal( ShapeComboBox shape ) {
    shape.setEnabled(
!gr_ForceMapSelectionText.isVisible() 
);
  }
  
  protected ShapeComboBox cb_filterOptions;
  protected ShapeButton button_clearFilters;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_removeManualSelection_SetDynamicParams_xjal( ShapeButton shape ) {
    shape.setEnabled(
!(c_manualFilterSelectedGC.isEmpty() && c_manualFilterDeselectedGC.isEmpty()) 
);
  }
  
  protected ShapeButton button_removeManualSelection;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_manualFilterSelection_SetDynamicParams_xjal( ShapeButton shape ) {
    shape.setEnabled(
user.GCAccessType == OL_UserGCAccessType.FULL && (!gr_ForceMapSelectionText.isVisible() || b_inManualFilterSelectionMode) 
);
    shape.setText(
b_inManualFilterSelectionMode ? "Selectie voltooien" : "Handmatige selectie" 
);
  }
  
  protected ShapeButton button_manualFilterSelection;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_completeManualSelectionMode_SetDynamicParams_xjal( ShapeButton shape ) {
    boolean _visible = 
gr_ForceMapSelectionText.isVisible() && b_inManualFilterSelectionMode  
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
button_completeManualSelectionMode.isVisible() 
);
 	}
  }
  
  protected ShapeButton button_completeManualSelectionMode;
  protected ShapeRadioButtonGroup rb_mapOverlayLegend_congestion;
  protected TimePlot plot_outsideTemperature;
  protected TimePlot plot_solarIrradiance;
  protected ShapeRectangle rect_sliderCollectionOrdering;
  protected ShapeRectangle rect_canvas;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_gismap_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
zenmocolor_blue3.getFillColor() 
);
  }
  
  protected ShapeRectangle rect_gismap;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _pop_UI_EnergyHub_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, _a );
    return shape;
  }

  protected ShapeAgentPopulationGroup pop_UI_EnergyHub_presentation;
  protected ShapeGroup gr_energyHubPresentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_logoBackground_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_backgroundColor 
);
  }
  
  protected ShapeRectangle rect_logoBackground;
  protected ShapeImage image_tueLogo;
  protected ShapeImage image_luxLogo;
  protected ShapeImage image_zenmoLogo;
  protected ShapeGroup gr_logos;
  protected ShapeRectangle rect_mainFunctions;
  protected ShapeRectangle rect_simulationEngine;
  protected ShapeRectangle rect_input;
  protected ShapeText t_input;
  protected ShapeLine line_simulationEngine;
  protected ShapeText t_simulationEngine;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_date_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
energyModel.v_isRapidRun ? f_getDateString() : f_getDateAndTimeString() 
);
  }
  
  protected ShapeText t_date;
  protected ShapeArc arc_zoomIn;
  protected ShapeArc arc_zoomOut;
  protected ShapeRectangle rect_zoomButton;
  protected ShapeLine line_zoomButtonSeperator;
  protected ShapeLine line_zoomIn1;
  protected ShapeLine line_zoomIn2;
  protected ShapeLine line_zoomOut;
  protected ShapeRectangle rect_zoomIn;
  protected ShapeRectangle rect_zoomOut;
  protected ShapeGroup gr_zoomButton;
  protected ShapeText t_legendaColors;
  protected ShapeText t_mapClickingFunctions;
  protected ShapeText t_stylingFunctions;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_clickedObjectInfo_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
zenmocolor_blue3.getFillColor() 
);
    shape.setFillColor(
zenmocolor_blue3.getFillColor() 
);
  }
  
  protected ShapeRectangle rect_clickedObjectInfo;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_clickedObjectInfo_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
v_clickedObjectText.equals("None") ? 
"Selecteer een gebouw of trafostation" :
v_clickedObjectText 
);
  }
  
  protected ShapeText t_clickedObjectInfo;
  protected ShapeGroup gr_clickedObjectInfo;
  protected ShapeText t_buildingColors;
  protected ShapeText t_gridnodeColors;
  protected ShapeText t_specificBuildingColors;
  protected ShapeText t_areaColors;
  protected ShapeText txt_generalColors;
  protected ShapeText txt_additionalUIs;
  protected ShapeText t_scenarios;
  protected ShapeText t_scenarioDescription;
  protected ShapeText t_scenarioName;
  protected ShapeGroup gr_scenarioDescription;
  protected ShapeText t_resultsUIFunctions;
  protected ShapeText t_scenarioDictionaries;
  protected ShapeText t_initializationFunctions;
  protected ShapeText t_inputParameters;
  protected ShapeLine line_ordereringDescription;
  protected ShapeText t_ordereringDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_outsideTemperature_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Buiten temperatuur " + v_outsideTemperature + " graden" 
);
  }
  
  protected ShapeText t_outsideTemperature;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_solarIrradiance_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Zonneinstraling " + v_solarIrradiance + " W/m2" 
);
  }
  
  protected ShapeText t_solarIrradiance;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_windSpeed_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Windsnelheid: " + v_windspeed  
);
  }
  
  protected ShapeText t_windSpeed;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_multipleBuildingInfo_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
v_selectedGridConnectionIndex > 0 && c_selectedGridConnections.size() > 0 && c_selectedGridConnections.get(0).p_owner.p_detailedCompany ?
"Je kijkt naar: " + c_selectedGridConnections.get(0).p_ownerID + ", " + c_selectedGridConnections.get(0).p_address.getAddress()
:
v_selectedGridConnectionIndex > 0 && c_selectedGridConnections.size() > 0 && c_selectedGridConnections.get(0).p_address != null ?
"Je kijkt naar: de aansluiting van " + c_selectedGridConnections.get(0).p_address.getAddress()
:
v_selectedGridConnectionIndex > 0 ?
"Je kijkt naar het " + (v_selectedGridConnectionIndex ) + "e adres in het geselecteerde pand"
:  
"Je kijkt naar de som van alle " + v_nbGridConnectionsInSelectedBuilding + " addressen in dit pand" 
);
  }
  
  protected ShapeText t_multipleBuildingInfo;
  protected ShapeGroup gr_multipleBuildingInfo;
  protected ShapeRectangle rect_CustomColors;
  protected ShapeText txt_mapOverlayFunctionalities;
  protected ShapeEmbeddedObjectPresentation uI_Tabs_presentation;
  protected ShapeRectangle rect_scenarioText;
  protected ShapeText txt_scenarioFunctions;
  protected ShapeGISMap map;
  protected ShapeText txt_sliderInitialization;
  protected ShapeText txt_GISObjectCreationFunctions;
  protected ShapeEmbeddedObjectPresentation uI_Results_presentation;
  protected ShapeGroup gr_uI_Results_presentation;
  protected ShapeRectangle rect_filterFunctions;
  protected ShapeText t_selectionColors;
  protected ShapeText txt_filterFunctions;
  protected ShapeRectangle rect_filterInterface;
  protected ShapeText txt_filterDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_activeFilters_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
!t_activeFilters.getText().equals("") ? "Actieve filters:" : "Geen Actieve Filters." 
);
  }
  
  protected ShapeText txt_activeFilters;
  protected ShapeText t_activeFilters;
  protected ShapeText txt_filterInterface;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_selectedGridLoop_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
c_selectedFilterOptions.contains(OL_FilterOptionsGC.GRIDTOPOLOGY_SELECTEDLOOP) 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
c_filterSelectedGridLoops.size() == 1 ? "Geselecteerde lus: " + c_filterSelectedGridLoops.get(0).p_gridNodeID : c_filterSelectedGridLoops.size() > 1 ? "Meerdere lussen geselecteerd." : "Geen lus geselecteerd." 
);
 	}
  }
  
  protected ShapeText t_selectedGridLoop;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_selectedNBh_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
c_selectedFilterOptions.contains(OL_FilterOptionsGC.SELECTED_NEIGHBORHOOD) 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
c_filterSelectedNeighborhoods.size() == 1 ? "Geselecteerde buurt: " + c_filterSelectedNeighborhoods.get(0).p_id : c_filterSelectedNeighborhoods.size() > 1 ? "Meerdere buurten geselecteerd." : "Geen buurt geselecteerd." 
);
 	}
  }
  
  protected ShapeText t_selectedNBh;
  protected ShapeGroup gr_filterInterface;
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
  protected ShapeGroup gr_errorScreen;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_sliderClickBlocker_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
new Color(255, 255, 255, 0) 
);
  }
  
  protected ShapeRectangle rect_sliderClickBlocker;
  protected ShapeRectangle rect_sliderClickBlocker2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_sliderClickBlocker_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
200 
);
    shape.setY(
750 
);
  }
  
  protected ShapeGroup gr_sliderClickBlocker;
  protected ShapeText txt_dataAccesibilityFunctionalities;
  protected ShapeRectangle rect_ìnfoBubbleFunctions;
  protected ShapeText txt_infoBubbleFunctions;
  protected ShapeText txt_publicVersion;
  protected ShapeImage i_publicVersionWarningMessage;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_publicVersionWarningMessage_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
settings.isPublicModel() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
740 
);
    shape.setY(
40 
);
 	}
  }
  
  protected ShapeGroup gr_publicVersionWarningMessage;
  protected ShapeRectangle rect_dynamicLegend;
  protected ShapeText txt_dynamicLegend;
  protected ShapeText txt_visualObjects;
  protected ShapeRoundedRectangle rect_infoText;
  protected ShapeOval oval_closeInfoText;
  protected ShapeLine line_closeInfoText1;
  protected ShapeLine line_closeInfoText2;
  protected ShapeGroup gr_closeInfoText;
  protected ShapeText t_infoTextHeader;
  protected ShapeText t_infoTextDescription;
  protected ShapeGroup gr_infoText;
  protected ShapeRectangle rect_forceMapSelectionClickBlocker1;
  protected ShapeRectangle rect_forceMapSelectionClickBlocker2;
  protected ShapeRectangle rect_forceMapSelectionClickBlocker3;
  protected ShapeRectangle rect_forceMapSelectionClickBlocker4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_forceMapSelection1_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_forcedClickScreenColor 
);
  }
  
  protected ShapeRectangle rect_forceMapSelection1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_forceMapSelection2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_forcedClickScreenColor 
);
  }
  
  protected ShapeRectangle rect_forceMapSelection2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_forceMapSelection3_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_forcedClickScreenColor 
);
  }
  
  protected ShapeRectangle rect_forceMapSelection3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_forceMapSelection4_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_forcedClickScreenColor 
);
  }
  
  protected ShapeRectangle rect_forceMapSelection4;
  protected ShapeRoundedRectangle rect_selectText;
  protected ShapeText t_forcedClickMessage;
  protected ShapeGroup gr_ForceMapSelectionText;
  protected ShapeRoundedRectangle button_completeSelection_grayedOut;
  protected ShapeText txt_completeEnergyHubSelection_grayedOut;
  protected ShapeGroup gr_completeEnergyHubSelection_grayedOut;
  protected ShapeRoundedRectangle button_completeSelection;
  protected ShapeText txt_completeEnergyHubSelection;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_completeEnergyHubSelection_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
c_selectedGridConnections.size()>1 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeGroup gr_completeEnergyHubSelection;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_energyHubConfigurator_SetDynamicParams_xjal( ShapeRoundedRectangle shape ) {
    shape.setLineColor(
uI_EnergyHub.p_energyHubLineColor 
);
    shape.setFillColor(
uI_EnergyHub.p_energyHubBackGroundColor 
);
  }
  
  protected ShapeRoundedRectangle rect_energyHubConfigurator;
  protected ShapeText txt_energyHubConfigurator;
  protected ShapeGroup gr_energieHubConfiguratorTxt;
  protected ShapeRoundedRectangle button_cancelEnergyHubConfiguration;
  protected ShapeText txt_cancelEnergyHubConfiguration;
  protected ShapeGroup gr_cancelEnergyHubConfiguration;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_energyHubSelectionButtons_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
b_inEnergyHubSelectionMode //&& gr_forceMapSelection.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeGroup gr_energyHubSelectionButtons;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_forceMapSelection_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
960 
);
    shape.setY(
500 
);
  }
  
  protected ShapeGroup gr_forceMapSelection;
  protected ShapeRectangle rect_supportFunctions;
  protected ShapeText t_supportFunctions;
  protected ShapeGroup gr_supportFunctions;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_legenda_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
zenmocolor_blue3.getFillColor() 
);
  }
  
  protected ShapeRectangle rect_legenda;
  protected ShapeText t_legenda;
  protected ShapeLine line_legendaSeperator1;
  protected ShapeLine line_legendaSeperator2;
  protected ShapeText t_infrastructure;
  protected ShapeLine line_infrastructure;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline_congestedGridnode_SetDynamicParams_xjal( ShapePolyLine shape ) {
    shape.setLineColor(
v_gridLineColorCongested 
);
    shape.setFillColor(
v_gridNodeColorCongested 
);
  }
  
  protected ShapePolyLine polyline_congestedGridnode;
  protected ShapeText txt_congestedGridnode;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline_gridnode_SetDynamicParams_xjal( ShapePolyLine shape ) {
    shape.setLineColor(
v_MVLVLineColor 
);
    shape.setFillColor(
v_MVLVNodeColor 
);
  }
  
  protected ShapePolyLine polyline_gridnode;
  protected ShapeText txt_gridnode;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline_strainedGridnode_SetDynamicParams_xjal( ShapePolyLine shape ) {
    shape.setLineColor(
v_gridNodeLineColorStrained 
);
    shape.setFillColor(
v_gridNodeColorStrained 
);
  }
  
  protected ShapePolyLine polyline_strainedGridnode;
  protected ShapeText txt_strainedGridnode;
  protected ShapeGroup gr_gridnodes;
  protected ShapeText t_MV;
  protected ShapeText t_LV;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line_LV_SetDynamicParams_xjal( ShapeLine shape ) {
    shape.setColor(
v_LVGridColor 
);
  }
  
  protected ShapeLine line_LV;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line_MV_SetDynamicParams_xjal( ShapeLine shape ) {
    shape.setColor(
v_MVGridColor 
);
  }
  
  protected ShapeLine line_MV;
  protected ShapeGroup gr_cablesLegend;
  protected ShapeGroup gr_infrastructure;
  protected ShapeText t_buildings;
  protected ShapeLine line_buildings;
  protected ShapeText txt_colorings;
  protected ShapeGroup gr_colorings;
  protected ShapeGroup gr_buildings;
  protected ShapeRectangle rect_mapOverlayLegend_ElectricityConsumption1;
  protected ShapeRectangle rect_mapOverlayLegend_ElectricityConsumption2;
  protected ShapeRectangle rect_mapOverlayLegend_ElectricityConsumption3;
  protected ShapeRectangle rect_mapOverlayLegend_ElectricityConsumption4;
  protected ShapeRectangle rect_mapOverlayLegend_ElectricityConsumption5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_ElectricityConsumption1_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
project_data.project_type() == OL_ProjectType.RESIDENTIAL ? "< 1500 kWh / jaar" : "< 10 MWh / jaar" 
);
  }
  
  protected ShapeText txt_mapOverlayLegend_ElectricityConsumption1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_ElectricityConsumption2_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
project_data.project_type() == OL_ProjectType.RESIDENTIAL ? "< 2500 kWh / jaar" : "< 50 MWh / jaar" 
);
  }
  
  protected ShapeText txt_mapOverlayLegend_ElectricityConsumption2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_ElectricityConsumption3_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
project_data.project_type() == OL_ProjectType.RESIDENTIAL ? "< 4000 kWh / jaar" : "< 150 MWh / jaar" 
);
  }
  
  protected ShapeText txt_mapOverlayLegend_ElectricityConsumption3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_ElectricityConsumption4_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
project_data.project_type() == OL_ProjectType.RESIDENTIAL ? "< 6000 kWh / jaar" : "< 500 MWh / jaar" 
);
  }
  
  protected ShapeText txt_mapOverlayLegend_ElectricityConsumption4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_ElectricityConsumption5_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
project_data.project_type() == OL_ProjectType.RESIDENTIAL ? "> 6000 kWh / jaar" : "> 500 MWh / jaar" 
);
  }
  
  protected ShapeText txt_mapOverlayLegend_ElectricityConsumption5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_mapOverlayLegend_ElectricityConsumption_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
    shape.setY(
-10 
);
  }
  
  protected ShapeGroup gr_mapOverlayLegend_ElectricityConsumption;
  protected ShapeOval oval_defaultLegend4;
  protected ShapeText t_defaultLegend2;
  protected ShapeText t_defaultLegend5;
  protected ShapeOval oval_defaultLegend5;
  protected ShapeText t_defaultLegend3;
  protected ShapeOval oval_defaultLegend2;
  protected ShapeText t_defaultLegend4;
  protected ShapeOval oval_defaultLegend3;
  protected ShapeText t_defaultLegend1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval_defaultLegend1_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_selectionColor 
);
  }
  
  protected ShapeOval oval_defaultLegend1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_defaultLegenda_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
10 
);
    shape.setY(
10 
);
  }
  
  protected ShapeGroup gr_defaultLegenda;
  protected ShapeRectangle rect_mapOverlayLegend_PVProduction1;
  protected ShapeRectangle rect_mapOverlayLegend_PVProduction2;
  protected ShapeRectangle rect_mapOverlayLegend_PVProduction3;
  protected ShapeText txt_mapOverlayLegend_PVProduction1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_PVProduction2_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
project_data.project_type() == OL_ProjectType.RESIDENTIAL ? "< 5000 kWh / jaar" : "< 100 MWh / jaar" 
);
  }
  
  protected ShapeText txt_mapOverlayLegend_PVProduction2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_PVProduction3_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
project_data.project_type() == OL_ProjectType.RESIDENTIAL ? "> 5000 kWh / jaar" : "> 100 MWh / jaar" 
);
  }
  
  protected ShapeText txt_mapOverlayLegend_PVProduction3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_mapOverlayLegend_PVProduction_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
    shape.setY(
-10 
);
  }
  
  protected ShapeGroup gr_mapOverlayLegend_PVProduction;
  protected ShapeRectangle rect_mapOverlayLegend_gridNeighbours1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_gridNeighbours2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    boolean _visible = 
txt_mapOverlayLegend_gridNeighbours2.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_gridNeighbours2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_gridNeighbours3_SetDynamicParams_xjal( ShapeRectangle shape ) {
    boolean _visible = 
txt_mapOverlayLegend_gridNeighbours3.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_gridNeighbours3;
  protected ShapeText txt_mapOverlayLegend_gridNeighbours1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_gridNeighbours2_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
v_amountOfDefinedGridLoops > 0 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_mapOverlayLegend_gridNeighbours2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_gridNeighbours3_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
v_amountOfDefinedGridLoops > 1 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_mapOverlayLegend_gridNeighbours3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_gridNeighbours4_SetDynamicParams_xjal( ShapeRectangle shape ) {
    boolean _visible = 
txt_mapOverlayLegend_gridNeighbours4.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_gridNeighbours4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_gridNeighbours4_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
v_amountOfDefinedGridLoops > 2 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_mapOverlayLegend_gridNeighbours4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mapOverlayLegend_gridNeighbours5_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
v_amountOfDefinedGridLoops > 4 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_mapOverlayLegend_gridNeighbours5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_mapOverlayLegend_gridNeighbours_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
    shape.setY(
-10 
);
  }
  
  protected ShapeGroup gr_mapOverlayLegend_gridNeighbours;
  protected ShapeText txt_mapOverlayLegend_congestion3;
  protected ShapeRectangle rect_mapOverlayLegend_congestion1;
  protected ShapeText txt_mapOverlayLegend_congestion1;
  protected ShapeImage i_mapOverlayLegend_congestion_Degrees;
  protected ShapeRectangle rect_mapOverlayLegend_congestion21;
  protected ShapeRectangle rect_mapOverlayLegend_congestion22;
  protected ShapeRectangle rect_mapOverlayLegend_congestion23;
  protected ShapeGroup gr_rect_mapOverlayLegend_congestion2;
  protected ShapeText txt_mapOverlayLegend_congestion2;
  protected ShapeImage i_mapOverlayLegend_congestion_Types;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_mapOverlayLegend_congestion_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
10 
);
    shape.setY(
-10 
);
  }
  
  protected ShapeGroup gr_mapOverlayLegend_congestion;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_EnergyLabelA_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_energyLabelAColor 
);
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_EnergyLabelA;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_EnergyLabelB_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_energyLabelBColor 
);
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_EnergyLabelB;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_EnergyLabelC_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_energyLabelCColor 
);
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_EnergyLabelC;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_EnergyLabelD_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_energyLabelDColor 
);
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_EnergyLabelD;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_EnergyLabelE_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_energyLabelEColor 
);
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_EnergyLabelE;
  protected ShapeText txt_mapOverlayLegend_EnergyLabelA;
  protected ShapeText txt_mapOverlayLegend_EnergyLabelB;
  protected ShapeText txt_mapOverlayLegend_EnergyLabelC;
  protected ShapeText txt_mapOverlayLegend_EnergyLabelD;
  protected ShapeText txt_mapOverlayLegend_EnergyLabelE;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_EnergyLabelF_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_energyLabelFColor 
);
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_EnergyLabelF;
  protected ShapeText txt_mapOverlayLegend_EnergyLabelF;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_EnergyLabelG_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_energyLabelGColor 
);
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_EnergyLabelG;
  protected ShapeText txt_mapOverlayLegend_EnergyLabelG;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_mapOverlayLegend_EnergyLabelUnknown_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_energyLabelUnknownColor 
);
  }
  
  protected ShapeRectangle rect_mapOverlayLegend_EnergyLabelUnknown;
  protected ShapeText txt_mapOverlayLegend_EnergyLabelUnknown;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_mapOverlayLegend_EnergyLabel_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
10 
);
    shape.setY(
-20 
);
  }
  
  protected ShapeGroup gr_mapOverlayLegend_EnergyLabel;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_mapOverlayLegenda_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
70 
);
    shape.setY(
20 
);
  }
  
  protected ShapeGroup gr_mapOverlayLegenda;
  protected ShapeRectangle rect_specialGISObjectLegend1;
  protected ShapeText t_specialGISObjectLegend1;
  protected ShapeRectangle rect_specialGISObjectLegend2;
  protected ShapeText t_specialGISObjectLegend2;
  protected ShapeRectangle rect_specialGISObjectLegend3;
  protected ShapeText t_specialGISObjectLegend3;
  protected ShapeRectangle rect_specialGISObjectLegend4;
  protected ShapeText t_specialGISObjectLegend4;
  protected ShapeRectangle rect_specialGISObjectLegend5;
  protected ShapeText t_specialGISObjectLegend5;
  protected ShapeRectangle rect_specialGISObjectLegend6;
  protected ShapeText t_specialGISObjectLegend6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_extendedLegendLine_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
rect_legenda.getLineColor() 
);
  }
  
  protected ShapeRectangle rect_extendedLegendLine;
  protected ShapeRectangle rect_extendedLegend;
  protected ShapeRectangle rect_specialGISObjectLegend7;
  protected ShapeText t_specialGISObjectLegend7;
  protected ShapeRectangle rect_specialGISObjectLegend8;
  protected ShapeText t_specialGISObjectLegend8;
  protected ShapeRectangle rect_specialGISObjectLegend9;
  protected ShapeText t_specialGISObjectLegend9;
  protected ShapeRectangle rect_specialGISObjectLegend10;
  protected ShapeText t_specialGISObjectLegend10;
  protected ShapeRectangle rect_specialGISObjectLegend11;
  protected ShapeText t_specialGISObjectLegend11;
  protected ShapeRectangle rect_specialGISObjectLegend12;
  protected ShapeText t_specialGISObjectLegend12;
  protected ShapeLine line;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_extendedLegend_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
120 
);
    shape.setY(
-5 
);
  }
  
  protected ShapeGroup gr_extendedLegend;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_seeMoreLegend_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
t_specialGISObjectLegend7.isVisible(); 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_seeMoreLegend;
  protected ShapeGroup gr_specificGISObjectLegend;
  protected ShapeGroup gr_legenda;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_loadIconSmall_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
zenmocolor_blue1.getFillColor() 
);
  }
  
  protected ShapeRectangle rect_loadIconSmall;
  protected ShapeImage image_loadIconSmall;
  protected ShapeText t_loadIconSmall;
  protected ShapeGroup gr_loadIconYearSimulation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_simulateYearScreenSmall_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
zenmocolor_blue2.getFillColor() 
);
  }
  
  protected ShapeRectangle rect_simulateYearScreenSmall;
  protected ShapeText t_simulateYearToCalculateCostsSmall;
  protected ShapeImage image_simulateYearToCalculateCostsSmall;
  protected ShapeGroup gr_simulateYearButton;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_simulateYear_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
-250 
);
    shape.setY(
20 
);
  }
  
  protected ShapeGroup gr_simulateYear;
  protected ShapeGroup gr_simulateYearScreen;
  protected ShapeText txt_cablesAndPipesColors;
  protected ShapeText txt_mapOverlayColors;
  protected ShapeRectangle zenmocolor_blue3;
  protected ShapeRectangle zenmocolor_blue;
  protected ShapeRectangle zenmocolor_blue1;
  protected ShapeRectangle zenmocolor_yellow;
  protected ShapeRectangle zenmocolor_yellow1;
  protected ShapeRectangle zenmocolor_yellow2;
  protected ShapeRectangle zenmocolor_yellow3;
  protected ShapeRectangle zenmocolor_red;
  protected ShapeRectangle zenmocolor_red1;
  protected ShapeRectangle zenmocolor_red2;
  protected ShapeRectangle zenmocolor_red3;
  protected ShapeRectangle zenmocolor_blue2;
  protected ShapeLine line1;
  protected ShapeLine line2;
  protected ShapeLine line3;
  protected ShapeText txt_projectSpecificScenarios;
  protected ShapeImage image_loadingScreenIcon;
  protected ShapeRectangle rect_defaultSliderNames;
  protected ShapeText txt_defaultSliderNames;
  protected com.anylogic.engine.markup.Level level;
  protected com.anylogic.engine.markup.Level level1;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    button_goToUI = new ShapeButton(
Zero_Interface.this, true, 1140.0, 87.0,
			270.0, 43.0,
            black, true,
_button_goToUI_Font,
			"Ga naar bedrijfs interface" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_goToUI, 0 );
      }
    };
    rb_scenarios_template = new ShapeRadioButtonGroup(
Zero_Interface.this, true, 19.333, 144.667,
			380.0, 135.0,
            black, true,
_rb_scenarios_template_Font, true,
            new String[]{"Huidige situatie", "Toekomstplannen", "Custom", } ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rb_scenarios_template_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_scenarios_template, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _rb_scenarios_template, 0 ) );
      }
    };
    button_gotoEngine = new ShapeButton(
Zero_Interface.this, true, -260.0, 960.0,
			210.0, 40.0,
            black, true,
_button_gotoEngine_Font,
			"Go to Engine" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_gotoEngine, 0 );
      }
    };
    button_nextBuilding = new ShapeButton(
Zero_Interface.this, true, -65.0, 32.0,
			155.0, 20.0,
            black, true,
_button_nextBuilding_Font,
			"Toon volgend adres" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_nextBuilding_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_nextBuilding, 0 );
      }
    };
    button_previousBuilding = new ShapeButton(
Zero_Interface.this, true, -65.0, 53.0,
			155.0, 20.0,
            black, true,
_button_previousBuilding_Font,
			"Toon vorig adres" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_previousBuilding_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_previousBuilding, 0 );
      }
    };
    checkbox_cables = new ShapeCheckBox(
Zero_Interface.this,true,20.0, 460.0,
		190.0, 30.0,
            black, true,
            _checkbox_cables_Font,
			"Toon stroom kabels" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_cables, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_cables, 0 ) );
      }
    };
    cb_showFilterInterface = new ShapeCheckBox(
Zero_Interface.this,true,20.0, 480.0,
		120.0, 30.0,
            black, true,
            _cb_showFilterInterface_Font,
			"Filter opties" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _cb_showFilterInterface_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_showFilterInterface, 0, value );
      }
    };
    cb_filterOptions = new ShapeComboBox(
Zero_Interface.this, true, -10.0, -140.0,
			200.0, 20.0,
            white, black, true,
_cb_filterOptions_Font,
            new String[]{"-", "Bedrijfspanden", "Woonhuizen", "Met bekende data", "Met geschatte data", "Met zonnepanelen", "Met voertuigen", "Met EV", "In de aangwezen 'buurt'", "In de aangewezen 'lus'", }, false, ShapeControl.TYPE_STRING ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _cb_filterOptions_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_filterOptions, 0, value );
      }
    };
    button_clearFilters = new ShapeButton(
Zero_Interface.this, true, 40.0, 130.0,
			150.0, 30.0,
            black, true,
_button_clearFilters_Font,
			"Verwijder alle filters" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_clearFilters, 0 );
      }
    };
    button_removeManualSelection = new ShapeButton(
Zero_Interface.this, true, 40.0, 85.0,
			150.0, 30.0,
            black, true,
_button_removeManualSelection_Font,
			"Wis handmatige selectie" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_removeManualSelection_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_removeManualSelection, 0 );
      }
    };
    button_manualFilterSelection = new ShapeButton(
Zero_Interface.this, true, 40.0, 50.0,
			150.0, 30.0,
            black, true,
_button_manualFilterSelection_Font,
			"Handmatige selectie" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_manualFilterSelection_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_manualFilterSelection, 0 );
      }
    };
    button_completeManualSelectionMode = new ShapeButton(
Zero_Interface.this, true, 220.0, -30.0,
			170.0, 50.0,
            black, true,
_button_completeManualSelectionMode_Font,
			"Voltooi handmatige selectie" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_completeManualSelectionMode_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_completeManualSelectionMode, 0 );
      }
    };
    rb_mapOverlayLegend_congestion = new ShapeRadioButtonGroup(
Zero_Interface.this, true, -80.0, 5.0,
			150.0, 70.0,
            black, true,
_rb_mapOverlayLegend_congestion_Font, true,
            new String[]{"Afname", "Teruglevering", "Beide", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_mapOverlayLegend_congestion, 0, value );
      }
    };
    rect_sliderCollectionOrdering = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, -800.0, 0.0, 0.0,
            dodgerBlue, white,
			1220.0, 400.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_canvas = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-600.0, -200.0, 0.0, 0.0,
            null, white,
			6000.0, 2400.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_gismap = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,400.0, 85.0, 0.0, 0.0,
            null, null,
			1020.0, 675.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_gismap_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_logoBackground = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-960.0, -70.0, 0.0, 0.0,
            null, _rect_logoBackground_Fill_Color,
			1960.0, 160.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_logoBackground_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_logoBackground.setVisible( false );
    image_tueLogo = new ShapeImage(
		Zero_Interface.this, SHAPE_DRAW_2D3D, true, 730.0, 25.0, 0.0, 0.0,
205.802, 60.0, "/zerointerfaceloader/",
			new String[]{"logo_TUe_red.png","logo_TUe_white.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _image_tueLogo, 0, clickx, clicky );
      }
    };
    image_luxLogo = new ShapeImage(
		Zero_Interface.this, SHAPE_DRAW_2D3D, true, -858.0, 13.0, 0.0, 0.0,
216.0, 90.947, "/zerointerfaceloader/",
			new String[]{"logo_lux-energy-twin.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _image_luxLogo, 0, clickx, clicky );
      }
    };
    image_zenmoLogo = new ShapeImage(
		Zero_Interface.this, SHAPE_DRAW_2D3D, true, 532.0, 16.0, 0.0, 0.0,
170.0, 73.0, "/zerointerfaceloader/",
			new String[]{"logo_zenmo.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _image_zenmoLogo, 0, clickx, clicky );
      }
    };
    rect_mainFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-700.0, 0.0, 0.0, 0.0,
            green, white,
			680.0, 1060.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_simulationEngine = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-270.0, 860.0, 0.0, 0.0,
            green, white,
			250.0, 200.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_input = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-700.0, 0.0, 0.0, 0.0,
            green, white,
			169.0, 40.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_input = new ShapeText(
        SHAPE_DRAW_2D, true,-640.0, 5.0, 0.0, 0.0,
        green,"Input",
        _t_input_Font, ALIGNMENT_LEFT );
    line_simulationEngine = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -230.0, 890.0, 0.0, black,
 		170.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    t_simulationEngine = new ShapeText(
        SHAPE_DRAW_2D, true,-151.0, 870.0, 0.0, 0.0,
        black,"Simulation engine",
        _t_simulationEngine_Font, ALIGNMENT_CENTER );
    t_date = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 54.0, 0.0, 0.0,
        black,"Datum",
        _t_date_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_date_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    arc_zoomIn = new ShapeArc(
     SHAPE_DRAW_2D3D, true, -2.5319999999999965, -20.114000000000004, 0.0, 0.0,
            _arc_zoomIn_Line_Color, _arc_zoomIn_Fill_Color,
			17.53, 17.53, 10.0, 0.0, -3.1276299663106166, 3.1101766737906735,
			1.0, LINE_STYLE_SOLID );
    arc_zoomOut = new ShapeArc(
     SHAPE_DRAW_2D3D, true, -2.483000000000004, 8.137, 0.0, 0.0,
            _arc_zoomOut_Line_Color, _arc_zoomOut_Fill_Color,
			17.483, 17.483, 10.0, 0.0, 0.020943951856169794, 3.1101766737906735,
			1.0, LINE_STYLE_SOLID );
    rect_zoomButton = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-20.0, -20.0, 0.0, 0.0,
            _rect_zoomButton_Line_Color, _rect_zoomButton_Fill_Color,
			35.0, 28.0, 10.0, 1.0, LINE_STYLE_SOLID );
    line_zoomButtonSeperator = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -16.0, -5.0, 0.0, gray,
 		27.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line_zoomIn1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -9.0, -21.0, 0.0, white,
 		12.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_zoomIn2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -3.0, -27.0, 0.0, white,
 		0.0,	12.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_zoomOut = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -10.0, 8.0, 0.0, white,
 		15.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    rect_zoomIn = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-20.0, -35.0, 0.0, 0.0,
            null, null,
			35.0, 30.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_zoomIn, 0, clickx, clicky );
      }
    };
    rect_zoomOut = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-20.0, -5.0, 0.0, 0.0,
            null, null,
			35.0, 30.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_zoomOut, 0, clickx, clicky );
      }
    };
    t_legendaColors = new ShapeText(
        SHAPE_DRAW_2D, true,380.0, 1020.0, 0.0, 0.0,
        black,"Legenda Colors",
        _t_legendaColors_Font, ALIGNMENT_LEFT );
    t_mapClickingFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 1020.0, 0.0, 0.0,
        black,"Map connections and clicking",
        _t_mapClickingFunctions_Font, ALIGNMENT_LEFT );
    t_stylingFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-680.0, 301.0, 0.0, 0.0,
        black,"Interface styling:",
        _t_stylingFunctions_Font, ALIGNMENT_LEFT );
    rect_clickedObjectInfo = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,40.0, -131.0, 0.0, 0.0,
            white, white,
			555.0, 20.0, 10.0, 3.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_clickedObjectInfo_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_clickedObjectInfo = new ShapeText(
        SHAPE_DRAW_2D, true,321.0, -129.0, 0.0, 0.0,
        black,"Selecteer een gebouw",
        _t_clickedObjectInfo_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_clickedObjectInfo_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_buildingColors = new ShapeText(
        SHAPE_DRAW_2D, true,680.0, 1030.0, 0.0, 0.0,
        black,"Building colors",
        _t_buildingColors_Font, ALIGNMENT_LEFT );
    t_gridnodeColors = new ShapeText(
        SHAPE_DRAW_2D, true,1022.0, 1030.0, 0.0, 0.0,
        black,"GridNode colors",
        _t_gridnodeColors_Font, ALIGNMENT_LEFT );
    t_specificBuildingColors = new ShapeText(
        SHAPE_DRAW_2D, true,680.0, 1250.0, 0.0, 0.0,
        black,"Specific building colors",
        _t_specificBuildingColors_Font, ALIGNMENT_LEFT );
    t_areaColors = new ShapeText(
        SHAPE_DRAW_2D, true,1300.0, 1180.0, 0.0, 0.0,
        black,"Area colors",
        _t_areaColors_Font, ALIGNMENT_LEFT );
    txt_generalColors = new ShapeText(
        SHAPE_DRAW_2D, true,1300.0, 1030.0, 0.0, 0.0,
        black,"General styling",
        _txt_generalColors_Font, ALIGNMENT_LEFT );
    txt_additionalUIs = new ShapeText(
        SHAPE_DRAW_2D, true,-290.0, 370.0, 0.0, 0.0,
        black,"Additional UIs:",
        _txt_additionalUIs_Font, ALIGNMENT_LEFT );
    t_scenarios = new ShapeText(
        SHAPE_DRAW_2D, true,19.333, 118.667, 0.0, 0.0,
        black,"Selecteer een scenario",
        _t_scenarios_Font, ALIGNMENT_LEFT );
    t_scenarioDescription = new ShapeText(
        SHAPE_DRAW_2D, true,0.667, -24.667, 0.0, 0.0,
        black,"Het huidige scenario bevat de energie dynamieken van dit moment.\nDit omvat o.a. de huidige zonnepanelen op de daken van huizen en \nbedrijven, het aantal voertuigen per type, de elektriciteitsconsumptie\nvan het gebied, en de huidige gasconsumptie voor verwarming.",
        _t_scenarioDescription_Font, ALIGNMENT_CENTER );
    t_scenarioName = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -50.0, 0.0, 0.0,
        black,"Huidig scenario",
        _t_scenarioName_Font, ALIGNMENT_CENTER );
    t_resultsUIFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-680.0, 730.0, 0.0, 0.0,
        black,"Results UI initialization",
        _t_resultsUIFunctions_Font, ALIGNMENT_LEFT );
    t_scenarioDictionaries = new ShapeText(
        SHAPE_DRAW_2D, true,-290.0, 290.0, 0.0, 0.0,
        black,"Scenario dictionaries",
        _t_scenarioDictionaries_Font, ALIGNMENT_LEFT );
    t_initializationFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-680.0, 150.0, 0.0, 0.0,
        black,"Interface initialization functions",
        _t_initializationFunctions_Font, ALIGNMENT_LEFT );
    t_inputParameters = new ShapeText(
        SHAPE_DRAW_2D, true,-680.0, 50.0, 0.0, 0.0,
        black,"Input Parameters",
        _t_inputParameters_Font, ALIGNMENT_LEFT );
    line_ordereringDescription = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 40.0, -755.0, 0.0, black,
 		210.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    t_ordereringDescription = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, -780.0, 0.0, 0.0,
        black,"Initial conditions & ordering",
        _t_ordereringDescription_Font, ALIGNMENT_LEFT );
    t_outsideTemperature = new ShapeText(
        SHAPE_DRAW_2D, true,1326.0, 17.0, 0.0, 0.0,
        _t_outsideTemperature_Color,"Buitentemperatuur: 23 graden",
        _t_outsideTemperature_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_outsideTemperature_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_solarIrradiance = new ShapeText(
        SHAPE_DRAW_2D, true,1326.0, 42.0, 0.0, 0.0,
        _t_solarIrradiance_Color,"Zonne instraling: 12 w/m2",
        _t_solarIrradiance_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_solarIrradiance_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_windSpeed = new ShapeText(
        SHAPE_DRAW_2D, true,1326.0, 67.0, 0.0, 0.0,
        _t_windSpeed_Color,"Windsnelheid: hoog",
        _t_windSpeed_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_windSpeed_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_multipleBuildingInfo = new ShapeText(
        SHAPE_DRAW_2D, true,-360.0, 57.0, 0.0, 0.0,
        black,"Je kijkt naar de som van alle 5  addressen samen in het geselecteerde pand",
        _t_multipleBuildingInfo_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_multipleBuildingInfo_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_CustomColors = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1880.0, 1400.0, 0.0, 0.0,
            gold, white,
			630.0, 640.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_mapOverlayFunctionalities = new ShapeText(
        SHAPE_DRAW_2D, true,1900.0, 1410.0, 0.0, 0.0,
        black,"Map Overlay Functionalities\n",
        _txt_mapOverlayFunctionalities_Font, ALIGNMENT_LEFT );
    rect_scenarioText = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,-1210.0, 0.0, 0.0, 0.0,
            black, white,
			460.0, 700.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_scenarioFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-1190.0, 20.0, 0.0, 0.0,
        black,"Scenario functions, text and settings",
        _txt_scenarioFunctions_Font, ALIGNMENT_LEFT );
    txt_sliderInitialization = new ShapeText(
        SHAPE_DRAW_2D, true,-680.0, 551.0, 0.0, 0.0,
        black,"Slider Initialization",
        _txt_sliderInitialization_Font, ALIGNMENT_LEFT );
    txt_GISObjectCreationFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-290.0, 60.0, 0.0, 0.0,
        black,"GIS Object creation functions",
        _txt_GISObjectCreationFunctions_Font, ALIGNMENT_LEFT );
    rect_filterFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-1620.0, 0.0, 0.0, 0.0,
            black, white,
			360.0, 630.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_selectionColors = new ShapeText(
        SHAPE_DRAW_2D, true,380.0, 1050.0, 0.0, 0.0,
        black,"Selection colors",
        _t_selectionColors_Font, ALIGNMENT_LEFT );
    txt_filterFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-1580.0, 20.0, 0.0, 0.0,
        black,"Filter Functions",
        _txt_filterFunctions_Font, ALIGNMENT_LEFT );
    rect_filterInterface = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-150.0, -180.0, 0.0, 0.0,
            black, white,
			350.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_filterDescription = new ShapeText(
        SHAPE_DRAW_2D, true,-130.0, -140.0, 0.0, 0.0,
        black,"Selecteer gebouwen:",
        _txt_filterDescription_Font, ALIGNMENT_LEFT );
    txt_activeFilters = new ShapeText(
        SHAPE_DRAW_2D, true,-130.0, -110.0, 0.0, 0.0,
        black,"Geen Actieve Filters.",
        _txt_activeFilters_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_activeFilters_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_activeFilters = new ShapeText(
        SHAPE_DRAW_2D, true,-130.0, -90.0, 0.0, 0.0,
        black,"",
        _t_activeFilters_Font, ALIGNMENT_LEFT );
    txt_filterInterface = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, -170.0, 0.0, 0.0,
        black,"Filter opties",
        _txt_filterInterface_Font, ALIGNMENT_CENTER );
    t_selectedGridLoop = new ShapeText(
        SHAPE_DRAW_2D, true,-130.0, 140.0, 0.0, 0.0,
        black,"",
        _t_selectedGridLoop_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_selectedGridLoop_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_selectedNBh = new ShapeText(
        SHAPE_DRAW_2D, true,-130.0, 117.0, 0.0, 0.0,
        black,"",
        _t_selectedNBh_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_selectedNBh_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_errorScreenGrayOut = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            _rect_errorScreenGrayOut_Line_Color, _rect_errorScreenGrayOut_Fill_Color,
			1920.0, 980.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_errorScreenClickBlocking = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
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
true,690.0, 380.0, 0.0,
        red, white,
540.0, 200.0,10.0,
		4.0, LINE_STYLE_SOLID );
    t_errorMessage = new ShapeText(
        SHAPE_DRAW_2D, true,960.0, 430.0, 0.0, 0.0,
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
    rect_sliderClickBlocker = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, -240.0, 0.0, 0.0,
            null, white,
			400.0, 470.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_sliderClickBlocker_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_sliderClickBlocker, 0, clickx, clicky );
      }
    };
    rect_sliderClickBlocker2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, -240.0, 0.0, 0.0,
            null, _rect_sliderClickBlocker2_Fill_Color,
			400.0, 470.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_dataAccesibilityFunctionalities = new ShapeText(
        SHAPE_DRAW_2D, true,-680.0, 865.0, 0.0, 0.0,
        black,"Data Accesibility Functionalities",
        _txt_dataAccesibilityFunctionalities_Font, ALIGNMENT_LEFT );
    rect_ìnfoBubbleFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-2070.0, 0.0, 0.0, 0.0,
            black, white,
			360.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_infoBubbleFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-2040.0, 30.0, 0.0, 0.0,
        black,"Info Bubble Functions",
        _txt_infoBubbleFunctions_Font, ALIGNMENT_LEFT );
    txt_publicVersion = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -20.0, 0.0, 0.0,
        red,"Dit is een publieke versie met beperkte functionaliteiten",
        _txt_publicVersion_Font, ALIGNMENT_CENTER );
    i_publicVersionWarningMessage = new ShapeImage(
		Zero_Interface.this, SHAPE_DRAW_2D3D, true, 304.0, -14.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_publicVersionWarningMessage, 0, clickx, clicky );
      }
    };
    rect_dynamicLegend = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1360.0, 1400.0, 0.0, 0.0,
            red, white,
			470.0, 310.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_dynamicLegend = new ShapeText(
        SHAPE_DRAW_2D, true,1380.0, 1420.0, 0.0, 0.0,
        black,"Dynamic legend functionality",
        _txt_dynamicLegend_Font, ALIGNMENT_LEFT );
    txt_visualObjects = new ShapeText(
        SHAPE_DRAW_2D, true,-290.0, 140.0, 0.0, 0.0,
        black,"GIS Objects pure for visuals",
        _txt_visualObjects_Font, ALIGNMENT_LEFT );
    rect_infoText = new ShapeRoundedRectangle(
true,0.0, 0.0, 0.0,
        black, white,
620.0, 170.0,10.0,
		1.0, LINE_STYLE_SOLID );
    oval_closeInfoText = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       black, darkGray,
	   12.0, 12.0, 10.0, 1.0, LINE_STYLE_SOLID );
    line_closeInfoText1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -6.0, 6.0, 0.0, white,
 		12.0,	-12.0, 0.0, 3.0, 10.0, LINE_STYLE_SOLID );
    line_closeInfoText2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 6.0, 6.0, 0.0, white,
 		-12.0,	-12.0, 0.0, 3.0, 10.0, LINE_STYLE_SOLID );
    t_infoTextHeader = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 20.0, 0.0, 0.0,
        black,"Extra Informatie",
        _t_infoTextHeader_Font, ALIGNMENT_LEFT );
    t_infoTextDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 50.0, 0.0, 0.0,
        black,"\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\nDuis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat\nnulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui\nofficia deserunt mollit anim id est laborum.\"",
        _t_infoTextDescription_Font, ALIGNMENT_LEFT );
    rect_forceMapSelectionClickBlocker1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-960.0, -500.0, 0.0, 0.0,
            null, _rect_forceMapSelectionClickBlocker1_Fill_Color,
			410.0, 980.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_forceMapSelectionClickBlocker1, 0, clickx, clicky );
      }
    };
  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP1_xjal() {
    rect_forceMapSelectionClickBlocker2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-550.0, -500.0, 0.0, 0.0,
            null, _rect_forceMapSelectionClickBlocker2_Fill_Color,
			1000.0, 130.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_forceMapSelectionClickBlocker2, 0, clickx, clicky );
      }
    };
    rect_forceMapSelectionClickBlocker3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-550.0, 250.0, 0.0, 0.0,
            null, _rect_forceMapSelectionClickBlocker3_Fill_Color,
			1000.0, 230.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_forceMapSelectionClickBlocker3, 0, clickx, clicky );
      }
    };
    rect_forceMapSelectionClickBlocker4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,450.0, -500.0, 0.0, 0.0,
            null, _rect_forceMapSelectionClickBlocker4_Fill_Color,
			510.0, 980.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_forceMapSelectionClickBlocker4, 0, clickx, clicky );
      }
    };
    rect_forceMapSelection1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-960.0, -620.0, 0.0, 0.0,
            null, _rect_forceMapSelection1_Fill_Color,
			410.0, 1200.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_forceMapSelection1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_forceMapSelection2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-550.0, -620.0, 0.0, 0.0,
            null, _rect_forceMapSelection2_Fill_Color,
			1000.0, 250.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_forceMapSelection2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_forceMapSelection3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-550.0, 250.0, 0.0, 0.0,
            null, _rect_forceMapSelection3_Fill_Color,
			1000.0, 330.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_forceMapSelection3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_forceMapSelection4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,450.0, -620.0, 0.0, 0.0,
            null, _rect_forceMapSelection4_Fill_Color,
			510.0, 1200.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_forceMapSelection4_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_selectText = new ShapeRoundedRectangle(
true,-440.0, -40.0, 0.0,
        black, white,
860.0, 70.0,10.0,
		2.0, LINE_STYLE_SOLID );
    t_forcedClickMessage = new ShapeText(
        SHAPE_DRAW_2D, true,-10.0, -30.0, 0.0, 0.0,
        black,"",
        _t_forcedClickMessage_Font, ALIGNMENT_CENTER );
    button_completeSelection_grayedOut = new ShapeRoundedRectangle(
true,-140.0, -40.0, 0.0,
        gray, gainsboro,
275.0, 75.0,10.0,
		3.0, LINE_STYLE_SOLID );
    txt_completeEnergyHubSelection_grayedOut = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -20.0, 0.0, 0.0,
        gray,"Voltooien",
        _txt_completeEnergyHubSelection_grayedOut_Font, ALIGNMENT_CENTER );
    button_completeSelection = new ShapeRoundedRectangle(
true,-140.0, -40.0, 0.0,
        black, white,
275.0, 75.0,10.0,
		3.0, LINE_STYLE_SOLID );
    txt_completeEnergyHubSelection = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -20.0, 0.0, 0.0,
        black,"Voltooien",
        _txt_completeEnergyHubSelection_Font, ALIGNMENT_CENTER );
    rect_energyHubConfigurator = new ShapeRoundedRectangle(
true,-500.0, -50.0, 0.0,
        black, white,
1000.0, 90.0,10.0,
		2.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_energyHubConfigurator_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_energyHubConfigurator = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -35.0, 0.0, 0.0,
        black,"Energie Hub Configurator",
        _txt_energyHubConfigurator_Font, ALIGNMENT_CENTER );
    button_cancelEnergyHubConfiguration = new ShapeRoundedRectangle(
true,-90.0, -30.0, 0.0,
        _button_cancelEnergyHubConfiguration_Line_Color, white,
275.0, 75.0,10.0,
		3.0, LINE_STYLE_SOLID );
    txt_cancelEnergyHubConfiguration = new ShapeText(
        SHAPE_DRAW_2D, true,48.0, -10.0, 0.0, 0.0,
        black,"Annuleer",
        _txt_cancelEnergyHubConfiguration_Font, ALIGNMENT_CENTER );
    rect_supportFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-140.0, -110.0, 0.0, 0.0,
            black, white,
			300.0, 190.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_supportFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -100.0, 0.0, 0.0,
        black,"Support functions",
        _t_supportFunctions_Font, ALIGNMENT_LEFT );
    rect_legenda = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-500.0, -90.0, 0.0, 0.0,
            yellowGreen, white,
			1000.0, 183.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_legenda_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_legenda = new ShapeText(
        SHAPE_DRAW_2D, true,-470.0, -110.0, 0.0, 0.0,
        black,"Legenda",
        _t_legenda_Font, ALIGNMENT_LEFT );
    line_legendaSeperator1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -165.0, -70.0, 0.0, lavender,
 		0.0,	140.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line_legendaSeperator2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -10.0, -70.0, 0.0, lavender,
 		0.0,	140.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    t_infrastructure = new ShapeText(
        SHAPE_DRAW_2D, true,-60.0, -79.0, 0.0, 0.0,
        black,"Infrastructuur",
        _t_infrastructure_Font, ALIGNMENT_LEFT );
    line_infrastructure = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -120.0, -59.0, 0.0, lavender,
 		271.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    polyline_congestedGridnode = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -55.0, 40.0, 0.0, black, null,
            4, _polyline_congestedGridnode_pointsDX_xjal(), _polyline_congestedGridnode_pointsDY_xjal(), _polyline_congestedGridnode_pointsDZ_xjal(), false, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _polyline_congestedGridnode_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_congestedGridnode = new ShapeText(
        SHAPE_DRAW_2D, true,-25.0, 25.0, 0.0, 0.0,
        black,"Trafo overbelast",
        _txt_congestedGridnode_Font, ALIGNMENT_LEFT );
    polyline_gridnode = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -55.0, -7.0, 0.0, black, null,
            4, _polyline_gridnode_pointsDX_xjal(), _polyline_gridnode_pointsDY_xjal(), _polyline_gridnode_pointsDZ_xjal(), false, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _polyline_gridnode_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_gridnode = new ShapeText(
        SHAPE_DRAW_2D, true,-25.0, -21.0, 0.0, 0.0,
        black,"Trafo stabiel",
        _txt_gridnode_Font, ALIGNMENT_LEFT );
    polyline_strainedGridnode = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -55.0, 15.0, 0.0, black, null,
            4, _polyline_strainedGridnode_pointsDX_xjal(), _polyline_strainedGridnode_pointsDY_xjal(), _polyline_strainedGridnode_pointsDZ_xjal(), false, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _polyline_strainedGridnode_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_strainedGridnode = new ShapeText(
        SHAPE_DRAW_2D, true,-25.0, 2.0, 0.0, 0.0,
        black,"Trafo belast",
        _txt_strainedGridnode_Font, ALIGNMENT_LEFT );
    t_MV = new ShapeText(
        SHAPE_DRAW_2D, true,-15.0, -50.0, 0.0, 0.0,
        black,"MS-net",
        _t_MV_Font, ALIGNMENT_LEFT );
    t_LV = new ShapeText(
        SHAPE_DRAW_2D, true,-15.0, -25.0, 0.0, 0.0,
        black,"LS-net",
        _t_LV_Font, ALIGNMENT_LEFT );
    line_LV = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -40.0, -15.0, 0.0, darkOrchid,
 		10.0,	0.0, 0.0, 2.5, 10.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _line_LV_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    line_MV = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -40.0, -40.0, 0.0, steelBlue,
 		10.0,	0.0, 0.0, 2.5, 10.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _line_MV_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_buildings = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, -84.0, 0.0, 0.0,
        black,"Gebouwen",
        _t_buildings_Font, ALIGNMENT_LEFT );
    line_buildings = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 380.0, -64.0, 0.0, lavender,
 		-458.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_colorings = new ShapeText(
        SHAPE_DRAW_2D, true,4.0, -71.0, 0.0, 0.0,
        black,"Kleur gebouwen o.b.v.:",
        _txt_colorings_Font, ALIGNMENT_CENTER );
    rect_mapOverlayLegend_ElectricityConsumption1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -52.0, 0.0, 0.0,
            gray, white,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_mapOverlayLegend_ElectricityConsumption2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -28.0, 0.0, 0.0,
            gray, lightYellow,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_mapOverlayLegend_ElectricityConsumption3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -4.0, 0.0, 0.0,
            gray, _rect_mapOverlayLegend_ElectricityConsumption3_Fill_Color,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_mapOverlayLegend_ElectricityConsumption4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, 20.0, 0.0, 0.0,
            gray, _rect_mapOverlayLegend_ElectricityConsumption4_Fill_Color,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_mapOverlayLegend_ElectricityConsumption5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, 44.0, 0.0, 0.0,
            gray, indianRed,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_mapOverlayLegend_ElectricityConsumption1 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -51.0, 0.0, 0.0,
        black,"< 10 MWh / jaar",
        _txt_mapOverlayLegend_ElectricityConsumption1_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_ElectricityConsumption1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_ElectricityConsumption2 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -28.0, 0.0, 0.0,
        black,"< 50 MWh / jaar",
        _txt_mapOverlayLegend_ElectricityConsumption2_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_ElectricityConsumption2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_ElectricityConsumption3 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -3.0, 0.0, 0.0,
        black,"< 150 MWh / jaar",
        _txt_mapOverlayLegend_ElectricityConsumption3_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_ElectricityConsumption3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_ElectricityConsumption4 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, 21.0, 0.0, 0.0,
        black,"< 500 MWh / jaar",
        _txt_mapOverlayLegend_ElectricityConsumption4_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_ElectricityConsumption4_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_ElectricityConsumption5 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, 45.0, 0.0, 0.0,
        black,"> 500 MWh / jaar",
        _txt_mapOverlayLegend_ElectricityConsumption5_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_ElectricityConsumption5_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    oval_defaultLegend4 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-60.0, 10.0, 0.0, 0.0,
       black, white,
	   6.5, 6.5, 10.0, 1.0, LINE_STYLE_SOLID );
    oval_defaultLegend4.setVisible( false );
    t_defaultLegend2 = new ShapeText(
        SHAPE_DRAW_2D, true,-39.5, -47.5, 0.0, 0.0,
        black,"Gedetaileerd bedrijf",
        _t_defaultLegend2_Font, ALIGNMENT_LEFT );
    t_defaultLegend2.setVisible( false );
    t_defaultLegend5 = new ShapeText(
        SHAPE_DRAW_2D, true,-39.5, 27.5, 0.0, 0.0,
        black,"Overig",
        _t_defaultLegend5_Font, ALIGNMENT_LEFT );
    t_defaultLegend5.setVisible( false );
    oval_defaultLegend5 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-60.0, 35.0, 0.0, 0.0,
       black, white,
	   6.5, 6.5, 10.0, 1.0, LINE_STYLE_SOLID );
    oval_defaultLegend5.setVisible( false );
    t_defaultLegend3 = new ShapeText(
        SHAPE_DRAW_2D, true,-39.5, -22.5, 0.0, 0.0,
        black,"Bedrijf",
        _t_defaultLegend3_Font, ALIGNMENT_LEFT );
    t_defaultLegend3.setVisible( false );
    oval_defaultLegend2 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-60.0, -40.0, 0.0, 0.0,
       black, white,
	   6.5, 6.5, 10.0, 1.0, LINE_STYLE_SOLID );
    oval_defaultLegend2.setVisible( false );
    t_defaultLegend4 = new ShapeText(
        SHAPE_DRAW_2D, true,-39.5, 2.5, 0.0, 0.0,
        black,"Huis",
        _t_defaultLegend4_Font, ALIGNMENT_LEFT );
    t_defaultLegend4.setVisible( false );
    oval_defaultLegend3 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-60.0, -15.0, 0.0, 0.0,
       black, white,
	   6.5, 6.5, 10.0, 1.0, LINE_STYLE_SOLID );
    oval_defaultLegend3.setVisible( false );
    t_defaultLegend1 = new ShapeText(
        SHAPE_DRAW_2D, true,-39.5, -72.5, 0.0, 0.0,
        black,"Selectie",
        _t_defaultLegend1_Font, ALIGNMENT_LEFT );
    oval_defaultLegend1 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-60.0, -65.0, 0.0, 0.0,
       black, white,
	   6.5, 6.5, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval_defaultLegend1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_mapOverlayLegend_PVProduction1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -52.0, 0.0, 0.0,
            gray, white,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_mapOverlayLegend_PVProduction2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -28.0, 0.0, 0.0,
            gray, yellow,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_mapOverlayLegend_PVProduction3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -4.0, 0.0, 0.0,
            gray, gold,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_mapOverlayLegend_PVProduction1 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -51.0, 0.0, 0.0,
        black,"Geen opwek",
        _txt_mapOverlayLegend_PVProduction1_Font, ALIGNMENT_LEFT );
    txt_mapOverlayLegend_PVProduction2 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -28.0, 0.0, 0.0,
        black,"< 100 MWh / jaar",
        _txt_mapOverlayLegend_PVProduction2_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_PVProduction2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_PVProduction3 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -3.0, 0.0, 0.0,
        black,"> 100 MWh / jaar",
        _txt_mapOverlayLegend_PVProduction3_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_PVProduction3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_mapOverlayLegend_gridNeighbours1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -52.0, 0.0, 0.0,
            black, gray,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_mapOverlayLegend_gridNeighbours2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -28.0, 0.0, 0.0,
            black, blue,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_gridNeighbours2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_mapOverlayLegend_gridNeighbours3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -4.0, 0.0, 0.0,
            black, red,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_gridNeighbours3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_gridNeighbours1 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -51.0, 0.0, 0.0,
        black,"Onbekend",
        _txt_mapOverlayLegend_gridNeighbours1_Font, ALIGNMENT_LEFT );
    txt_mapOverlayLegend_gridNeighbours2 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -28.0, 0.0, 0.0,
        black,"Lus 1",
        _txt_mapOverlayLegend_gridNeighbours2_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_gridNeighbours2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_gridNeighbours3 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -3.0, 0.0, 0.0,
        black,"Lus 2",
        _txt_mapOverlayLegend_gridNeighbours3_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_gridNeighbours3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_mapOverlayLegend_gridNeighbours4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, 20.0, 0.0, 0.0,
            black, lime,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_gridNeighbours4_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_gridNeighbours4 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, 20.0, 0.0, 0.0,
        black,"Lus 3",
        _txt_mapOverlayLegend_gridNeighbours4_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_gridNeighbours4_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_gridNeighbours5 = new ShapeText(
        SHAPE_DRAW_2D, true,-18.0, 50.0, 0.0, 0.0,
        black,"Etc.",
        _txt_mapOverlayLegend_gridNeighbours5_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mapOverlayLegend_gridNeighbours5_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_gridNeighbours5.setVisible( false );
    txt_mapOverlayLegend_congestion3 = new ShapeText(
        SHAPE_DRAW_2D, true,-80.0, -10.0, 0.0, 0.0,
        black,"Type belasting:",
        _txt_mapOverlayLegend_congestion3_Font, ALIGNMENT_LEFT );
    rect_mapOverlayLegend_congestion1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-80.0, -55.0, 0.0, 0.0,
            black, gray,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_mapOverlayLegend_congestion1 = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, -55.0, 0.0, 0.0,
        black,"Onbekende capaciteit",
        _txt_mapOverlayLegend_congestion1_Font, ALIGNMENT_LEFT );
    i_mapOverlayLegend_congestion_Degrees = new ShapeImage(
		Zero_Interface.this, SHAPE_DRAW_2D3D, true, 60.0, -33.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_mapOverlayLegend_congestion_Degrees, 0, clickx, clicky );
      }
    };
    rect_mapOverlayLegend_congestion21 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-15.0, -7.0, 0.0, 0.0,
            black, green,
			8.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_mapOverlayLegend_congestion22 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-7.0, -7.0, 0.0, 0.0,
            black, orange,
			9.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_mapOverlayLegend_congestion23 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,2.0, -7.0, 0.0, 0.0,
            black, red,
			8.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_mapOverlayLegend_congestion2 = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, -30.0, 0.0, 0.0,
        black,"Stabiel - Overbelast",
        _txt_mapOverlayLegend_congestion2_Font, ALIGNMENT_LEFT );
    i_mapOverlayLegend_congestion_Types = new ShapeImage(
		Zero_Interface.this, SHAPE_DRAW_2D3D, true, -5.0, -12.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_mapOverlayLegend_congestion_Types, 0, clickx, clicky );
      }
    };
    rect_mapOverlayLegend_EnergyLabelA = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -52.0, 0.0, 0.0,
            gray, darkGreen,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_EnergyLabelA_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_mapOverlayLegend_EnergyLabelB = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -35.0, 0.0, 0.0,
            gray, green,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_EnergyLabelB_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_mapOverlayLegend_EnergyLabelC = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -18.0, 0.0, 0.0,
            gray, yellowGreen,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_EnergyLabelC_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_mapOverlayLegend_EnergyLabelD = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, -1.0, 0.0, 0.0,
            gray, gold,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_EnergyLabelD_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_mapOverlayLegend_EnergyLabelE = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, 16.0, 0.0, 0.0,
            gray, orange,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_EnergyLabelE_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_EnergyLabelA = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -51.0, 0.0, 0.0,
        black,"Energielabel A",
        _txt_mapOverlayLegend_EnergyLabelA_Font, ALIGNMENT_LEFT );
    txt_mapOverlayLegend_EnergyLabelB = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -35.0, 0.0, 0.0,
        black,"Energielabel B",
        _txt_mapOverlayLegend_EnergyLabelB_Font, ALIGNMENT_LEFT );
    txt_mapOverlayLegend_EnergyLabelC = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -17.0, 0.0, 0.0,
        black,"Energielabel C",
        _txt_mapOverlayLegend_EnergyLabelC_Font, ALIGNMENT_LEFT );
    txt_mapOverlayLegend_EnergyLabelD = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, 0.0, 0.0, 0.0,
        black,"Energielabel D",
        _txt_mapOverlayLegend_EnergyLabelD_Font, ALIGNMENT_LEFT );
    txt_mapOverlayLegend_EnergyLabelE = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, 17.0, 0.0, 0.0,
        black,"Energielabel E",
        _txt_mapOverlayLegend_EnergyLabelE_Font, ALIGNMENT_LEFT );
    rect_mapOverlayLegend_EnergyLabelF = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, 33.0, 0.0, 0.0,
            gray, orangeRed,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_EnergyLabelF_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_EnergyLabelF = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, 34.0, 0.0, 0.0,
        black,"Energielabel F",
        _txt_mapOverlayLegend_EnergyLabelF_Font, ALIGNMENT_LEFT );
    rect_mapOverlayLegend_EnergyLabelG = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, 50.0, 0.0, 0.0,
            gray, red,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_EnergyLabelG_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_EnergyLabelG = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, 51.0, 0.0, 0.0,
        black,"Energielabel G",
        _txt_mapOverlayLegend_EnergyLabelG_Font, ALIGNMENT_LEFT );
    rect_mapOverlayLegend_EnergyLabelUnknown = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-60.0, 67.0, 0.0, 0.0,
            gray, gray,
			25.0, 15.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_mapOverlayLegend_EnergyLabelUnknown_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mapOverlayLegend_EnergyLabelUnknown = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, 68.0, 0.0, 0.0,
        black,"Onbekend",
        _txt_mapOverlayLegend_EnergyLabelUnknown_Font, ALIGNMENT_LEFT );
    rect_specialGISObjectLegend1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-180.0, -40.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend1.setVisible( false );
    t_specialGISObjectLegend1 = new ShapeText(
        SHAPE_DRAW_2D, true,-150.0, -40.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend1_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend1.setVisible( false );
  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP2_xjal() {
    rect_specialGISObjectLegend2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-180.0, -20.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend2.setVisible( false );
    t_specialGISObjectLegend2 = new ShapeText(
        SHAPE_DRAW_2D, true,-150.0, -20.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend2_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend2.setVisible( false );
    rect_specialGISObjectLegend3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-180.0, 0.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend3.setVisible( false );
    t_specialGISObjectLegend3 = new ShapeText(
        SHAPE_DRAW_2D, true,-150.0, 0.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend3_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend3.setVisible( false );
    rect_specialGISObjectLegend4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-180.0, 20.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend4.setVisible( false );
    t_specialGISObjectLegend4 = new ShapeText(
        SHAPE_DRAW_2D, true,-150.0, 20.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend4_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend4.setVisible( false );
    rect_specialGISObjectLegend5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-180.0, 40.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend5.setVisible( false );
    t_specialGISObjectLegend5 = new ShapeText(
        SHAPE_DRAW_2D, true,-150.0, 40.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend5_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend5.setVisible( false );
    rect_specialGISObjectLegend6 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-180.0, 60.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend6.setVisible( false );
    t_specialGISObjectLegend6 = new ShapeText(
        SHAPE_DRAW_2D, true,-150.0, 60.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend6_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend6.setVisible( false );
    rect_extendedLegendLine = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-114.0, -85.0, 0.0, 0.0,
            yellowGreen, white,
			204.0, 183.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_extendedLegendLine_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_extendedLegend = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-115.0, -84.5, 0.0, 0.0,
            null, white,
			204.0, 182.0, 10.0, 0.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend7 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-90.0, -35.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend7.setVisible( false );
    t_specialGISObjectLegend7 = new ShapeText(
        SHAPE_DRAW_2D, true,-60.0, -35.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend7_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend7.setVisible( false );
    rect_specialGISObjectLegend8 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-90.0, -15.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend8.setVisible( false );
    t_specialGISObjectLegend8 = new ShapeText(
        SHAPE_DRAW_2D, true,-60.0, -15.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend8_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend8.setVisible( false );
    rect_specialGISObjectLegend9 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-90.0, 5.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend9.setVisible( false );
    t_specialGISObjectLegend9 = new ShapeText(
        SHAPE_DRAW_2D, true,-60.0, 5.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend9_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend9.setVisible( false );
    rect_specialGISObjectLegend10 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-90.0, 25.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend10.setVisible( false );
    t_specialGISObjectLegend10 = new ShapeText(
        SHAPE_DRAW_2D, true,-60.0, 25.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend10_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend10.setVisible( false );
    rect_specialGISObjectLegend11 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-90.0, 45.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend11.setVisible( false );
    t_specialGISObjectLegend11 = new ShapeText(
        SHAPE_DRAW_2D, true,-60.0, 45.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend11_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend11.setVisible( false );
    rect_specialGISObjectLegend12 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-90.0, 65.0, 0.0, 0.0,
            black, white,
			15.0, 15.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_specialGISObjectLegend12.setVisible( false );
    t_specialGISObjectLegend12 = new ShapeText(
        SHAPE_DRAW_2D, true,-60.0, 65.0, 0.0, 0.0,
        black,"Zonneweide",
        _t_specialGISObjectLegend12_Font, ALIGNMENT_LEFT );
    t_specialGISObjectLegend12.setVisible( false );
    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -115.0, -49.0, 0.0, lavender,
 		192.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    t_seeMoreLegend = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -70.0, 0.0, 0.0,
        dodgerBlue,"Zie meer...",
        _t_seeMoreLegend_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_seeMoreLegend_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _t_seeMoreLegend, 0, clickx, clicky );
      }
    };
    rect_loadIconSmall = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-219.0, -50.0, 0.0, 0.0,
            lavender, _rect_loadIconSmall_Fill_Color,
			460.0, 250.0, 10.0, 1.0, LINE_STYLE_DASHED ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_loadIconSmall_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    image_loadIconSmall = new ShapeImage(
		Zero_Interface.this, SHAPE_DRAW_2D3D, true, -19.0, 60.0, 0.0, 0.0,
60.0, 60.0, "/zerointerfaceloader/",
			new String[]{"icon_loading.gif",} );
    t_loadIconSmall = new ShapeText(
        SHAPE_DRAW_2D, true,12.0, 15.0, 0.0, 0.0,
        black,"Jaar wordt gesimuleerd",
        _t_loadIconSmall_Font, ALIGNMENT_CENTER );
    rect_simulateYearScreenSmall = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -95.0, 0.0, 0.0,
            null, white,
			460.0, 185.0, 10.0, 1.0, LINE_STYLE_DASHED ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_simulateYearScreenSmall_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_simulateYearToCalculateCostsSmall = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, -60.0, 0.0, 0.0,
        black,"Simuleer jaar voor KPI's",
        _t_simulateYearToCalculateCostsSmall_Font, ALIGNMENT_CENTER );
    image_simulateYearToCalculateCostsSmall = new ShapeImage(
		Zero_Interface.this, SHAPE_DRAW_2D3D, true, -200.0, -75.0, 0.0, 0.0,
60.0, 60.0, "/zerointerfaceloader/",
			new String[]{"icon_greater_than.png",} );
    txt_cablesAndPipesColors = new ShapeText(
        SHAPE_DRAW_2D, true,380.0, 1150.0, 0.0, 0.0,
        black,"Cables and pipes colors",
        _txt_cablesAndPipesColors_Font, ALIGNMENT_LEFT );
    txt_mapOverlayColors = new ShapeText(
        SHAPE_DRAW_2D, true,380.0, 1270.0, 0.0, 0.0,
        black,"Specific map overlay colors",
        _txt_mapOverlayColors_Font, ALIGNMENT_LEFT );
    zenmocolor_blue3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1920.0, 1260.0, 0.0, 0.0,
            black, _zenmocolor_blue3_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_blue = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1920.0, 1020.0, 0.0, 0.0,
            black, _zenmocolor_blue_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_blue1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1920.0, 1100.0, 0.0, 0.0,
            black, _zenmocolor_blue1_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_yellow = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,2020.0, 1020.0, 0.0, 0.0,
            black, _zenmocolor_yellow_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_yellow1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,2020.0, 1100.0, 0.0, 0.0,
            black, _zenmocolor_yellow1_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_yellow2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,2020.0, 1180.0, 0.0, 0.0,
            black, _zenmocolor_yellow2_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_yellow3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,2020.0, 1260.0, 0.0, 0.0,
            black, _zenmocolor_yellow3_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_red = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1820.0, 1020.0, 0.0, 0.0,
            black, _zenmocolor_red_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_red1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1820.0, 1100.0, 0.0, 0.0,
            black, _zenmocolor_red1_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_red2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1820.0, 1180.0, 0.0, 0.0,
            black, _zenmocolor_red2_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_red3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1820.0, 1260.0, 0.0, 0.0,
            black, _zenmocolor_red3_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    zenmocolor_blue2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1920.0, 1180.0, 0.0, 0.0,
            black, _zenmocolor_blue2_Fill_Color,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    line1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 10.0, 300.0, 0.0, _line1_Line_Color,
 		375.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 10.0, 440.0, 0.0, _line2_Line_Color,
 		375.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line3 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 5.0, 100.0, 0.0, _line3_Line_Color,
 		375.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_projectSpecificScenarios = new ShapeText(
        SHAPE_DRAW_2D, true,-1190.0, 500.0, 0.0, 0.0,
        black,"Project specific scenarios",
        _txt_projectSpecificScenarios_Font, ALIGNMENT_LEFT );
    image_loadingScreenIcon = new ShapeImage(
		Zero_Interface.this, SHAPE_DRAW_2D3D, true, 3040.0, 680.0, 0.0, 0.0,
180.0, 180.0, "/zerointerfaceloader/",
			new String[]{"icon_loading.gif",} );
    image_loadingScreenIcon.setVisible( false );
    rect_defaultSliderNames = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,400.0, 2000.0, 0.0, 0.0,
            black, white,
			420.0, 170.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_defaultSliderNames = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 2010.0, 0.0, 0.0,
        black,"Default Slider Names",
        _txt_defaultSliderNames_Font, ALIGNMENT_LEFT );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataSet> _items = new ArrayList<DataSet>( 1 );
    _items.add( new DataSet(96, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( _datasetUpdateTime_xjal() == _lastUpdateX ) { return; }
      _d.add( __plot_outsideTemperature_expression0_dataSet_xjal_XValue(  ), __plot_outsideTemperature_expression0_dataSet_xjal_YValue(  ) );
      _lastUpdateX = _datasetUpdateTime_xjal();
    }
  } ) ); 
    List<String> _titles = new ArrayList<>( 1 );
    _titles.add( "Title" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 1 );
    _appearances.add( new Chart2DPlot.Appearance( blue, true, true, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot_outsideTemperature = new TimePlot(
Zero_Interface.this, true, 1335.0, 12.0,
			84.0, 23.0,
            null, black,
            0.0, 0.0,
			84.0, 23.0, white, black, black,
            30.0, Chart.NONE,

96 
            , Chart.WINDOW_MOVES_WITH_TIME, "HH:mm", Chart.SCALE_FIXED,

-5 
            , 
28 
, Chart.GRID_NONE, Chart.GRID_NONE,
            yellowGreen, gold, _items, _titles, _appearances );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 1 );
    _items.add( new DataSet(96, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( _datasetUpdateTime_xjal() == _lastUpdateX ) { return; }
      _d.add( __plot_solarIrradiance_expression0_dataSet_xjal_XValue(  ), __plot_solarIrradiance_expression0_dataSet_xjal_YValue(  ) );
      _lastUpdateX = _datasetUpdateTime_xjal();
    }
  } ) ); 
    List<String> _titles = new ArrayList<>( 1 );
    _titles.add( "Title" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 1 );
    _appearances.add( new Chart2DPlot.Appearance( gold, true, true, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot_solarIrradiance = new TimePlot(
Zero_Interface.this, true, 1335.0, 38.0,
			84.0, 23.0,
            null, black,
            0.0, 0.0,
			84.0, 23.0, white, black, black,
            30.0, Chart.NONE,

96 
            , Chart.WINDOW_MOVES_WITH_TIME, "HH:mm", Chart.SCALE_FIXED,

0 
            , 
1000 
, Chart.GRID_NONE, Chart.GRID_NONE,
            yellowGreen, gold, _items, _titles, _appearances );
    }
    pop_UI_EnergyHub_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, pop_UI_EnergyHub) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _pop_UI_EnergyHub_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
    };
    {
    gr_energyHubPresentation = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 2600.0, -2200.0, 0.0, 0.0
	
	     , pop_UI_EnergyHub_presentation );
    }
    {
    gr_logos = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 940.0, -10.0, 0.0, 0.0
	
	     , rect_logoBackground
	     , image_tueLogo
	     , image_luxLogo
	     , image_zenmoLogo );
    }
    {
    gr_zoomButton = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 1330.0, 680.0, 0.0, 0.0
	
	     , arc_zoomIn
	     , arc_zoomOut
	     , rect_zoomButton
	     , line_zoomButtonSeperator
	     , line_zoomIn1
	     , line_zoomIn2
	     , line_zoomOut
	     , rect_zoomIn
	     , rect_zoomOut );
    }
    {
    gr_clickedObjectInfo = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 370.0, 220.0, 0.0, 0.0
	
	     , rect_clickedObjectInfo
	     , t_clickedObjectInfo );
    }
    {
    gr_scenarioDescription = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 199.333, 374.667, 0.0, 0.0
	
	     , t_scenarioDescription
	     , t_scenarioName );
    }
    {
    gr_multipleBuildingInfo = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 1040.0, 55.0, 0.0, 0.0
	
	     , button_nextBuilding
	     , button_previousBuilding
	     , t_multipleBuildingInfo );
    }
    gr_multipleBuildingInfo.setVisible( false );
    {
    uI_Tabs_presentation = new ShapeEmbeddedObjectPresentation( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    uI_Results_presentation = new ShapeEmbeddedObjectPresentation( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_uI_Results_presentation = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 1440.0, 230.0, 0.0, 0.0
	
	     , uI_Results_presentation );
    }
    {
    gr_filterInterface = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, -1470.0, 830.0, 0.0, 0.0
	
	     , rect_filterInterface
	     , txt_filterDescription
	     , cb_filterOptions
	     , txt_activeFilters
	     , t_activeFilters
	     , txt_filterInterface
	     , button_clearFilters
	     , t_selectedGridLoop
	     , t_selectedNBh
	     , button_removeManualSelection
	     , button_manualFilterSelection );
    }
    gr_filterInterface.setVisible( false );
    {
    button_errorOK = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 960.0, 550.0, 0.0, 0.0
	
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
    gr_errorScreen = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 3380.0, -100.0, 0.0, 0.0
	
	     , rect_errorScreenGrayOut
	     , rect_errorScreenClickBlocking
	     , rect_errorMessage
	     , t_errorMessage
	     , button_errorOK );
    }
    gr_errorScreen.setVisible( false );
    {
    gr_sliderClickBlocker = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, -440.0, -1860.0, 0.0, 0.0
	
	     , rect_sliderClickBlocker
	     , rect_sliderClickBlocker2 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_sliderClickBlocker_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_sliderClickBlocker.setVisible( false );
    {
    gr_publicVersionWarningMessage = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 460.0, -2160.0, 0.0, 0.0
	
	     , txt_publicVersion
	     , i_publicVersionWarningMessage ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_publicVersionWarningMessage_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_closeInfoText = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 600.0, 20.0, 0.0, 0.0
	
	     , oval_closeInfoText
	     , line_closeInfoText1
	     , line_closeInfoText2 ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_closeInfoText, 0, clickx, clicky );
      }
    };
    }
    {
    gr_infoText = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, -2260.0, 360.0, 0.0, 0.0
	
	     , rect_infoText
	     , gr_closeInfoText
	     , t_infoTextHeader
	     , t_infoTextDescription );
    }
    gr_infoText.setVisible( false );
    {
    gr_ForceMapSelectionText = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, -40.0, -320.0, 0.0, 0.0
	
	     , rect_selectText
	     , button_completeManualSelectionMode
	     , t_forcedClickMessage );
    }
    gr_ForceMapSelectionText.setVisible( false );
    {
    gr_completeEnergyHubSelection_grayedOut = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D, true, -770.0, 550.0, 0.0, 0.0
	
	     , button_completeSelection_grayedOut
	     , txt_completeEnergyHubSelection_grayedOut );
    }
    {
    gr_completeEnergyHubSelection = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D, true, -770.0, 550.0, 0.0, 0.0
	
	     , button_completeSelection
	     , txt_completeEnergyHubSelection ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_completeEnergyHubSelection_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_completeEnergyHubSelection, 0, clickx, clicky );
      }
    };
    }
    {
    gr_energieHubConfiguratorTxt = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D, true, -60.0, -190.0, 0.0, 0.0
	
	     , rect_energyHubConfigurator
	     , txt_energyHubConfigurator );
    }
    {
    gr_cancelEnergyHubConfiguration = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D, true, -820.0, 630.0, 0.0, 0.0
	
	     , button_cancelEnergyHubConfiguration
	     , txt_cancelEnergyHubConfiguration ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_cancelEnergyHubConfiguration, 0, clickx, clicky );
      }
    };
    }
    {
    gr_energyHubSelectionButtons = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D, true, 10.0, -240.0, 0.0, 0.0
	
	     , gr_completeEnergyHubSelection_grayedOut
	     , gr_completeEnergyHubSelection
	     , gr_energieHubConfiguratorTxt
	     , gr_cancelEnergyHubConfiguration ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_energyHubSelectionButtons_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_forceMapSelection = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 1080.0, -1480.0, 0.0, 0.0
	
	     , rect_forceMapSelectionClickBlocker1
	     , rect_forceMapSelectionClickBlocker2
	     , rect_forceMapSelectionClickBlocker3
	     , rect_forceMapSelectionClickBlocker4
	     , rect_forceMapSelection1
	     , rect_forceMapSelection2
	     , rect_forceMapSelection3
	     , rect_forceMapSelection4
	     , gr_ForceMapSelectionText
	     , gr_energyHubSelectionButtons ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_forceMapSelection_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_forceMapSelection.setVisible( false );
    {
    gr_supportFunctions = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, -540.0, -110.0, 0.0, 0.0
	
	     , rect_supportFunctions
	     , t_supportFunctions );
    }
    {
    gr_gridnodes = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, -75.0, -19.0, 0.0, 0.0
	
	     , polyline_congestedGridnode
	     , txt_congestedGridnode
	     , polyline_gridnode
	     , txt_gridnode
	     , polyline_strainedGridnode
	     , txt_strainedGridnode );
    }
    {
    gr_cablesLegend = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 75.0, 5.0, 0.0, 0.0
	
	     , t_MV
	     , t_LV
	     , line_LV
	     , line_MV );
    }
    gr_cablesLegend.setVisible( false );
    {
    gr_infrastructure = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, -340.0, 5.0, 0.0, 0.0
	
	     , t_infrastructure
	     , line_infrastructure
	     , gr_gridnodes
	     , gr_cablesLegend );
    }
    {
    gr_colorings = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, -180.0, 0.0, 0.0, 0.0
	
	     , txt_colorings );
    }
    {
    gr_buildings = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 80.0, 10.0, 0.0, 0.0
	
	     , t_buildings
	     , line_buildings
	     , gr_colorings );
    }
    {
    gr_mapOverlayLegend_ElectricityConsumption = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 180.0, -10.0, 0.0, 0.0
	
	     , rect_mapOverlayLegend_ElectricityConsumption1
	     , rect_mapOverlayLegend_ElectricityConsumption2
	     , rect_mapOverlayLegend_ElectricityConsumption3
	     , rect_mapOverlayLegend_ElectricityConsumption4
	     , rect_mapOverlayLegend_ElectricityConsumption5
	     , txt_mapOverlayLegend_ElectricityConsumption1
	     , txt_mapOverlayLegend_ElectricityConsumption2
	     , txt_mapOverlayLegend_ElectricityConsumption3
	     , txt_mapOverlayLegend_ElectricityConsumption4
	     , txt_mapOverlayLegend_ElectricityConsumption5 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_mapOverlayLegend_ElectricityConsumption_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_mapOverlayLegend_ElectricityConsumption.setVisible( false );
    {
    gr_defaultLegenda = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 10.0, 10.0, 0.0, 0.0
	
	     , oval_defaultLegend4
	     , t_defaultLegend2
	     , t_defaultLegend5
	     , oval_defaultLegend5
	     , t_defaultLegend3
	     , oval_defaultLegend2
	     , t_defaultLegend4
	     , oval_defaultLegend3
	     , t_defaultLegend1
	     , oval_defaultLegend1 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_defaultLegenda_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_mapOverlayLegend_PVProduction = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 380.0, 0.0, 0.0, 0.0
	
	     , rect_mapOverlayLegend_PVProduction1
	     , rect_mapOverlayLegend_PVProduction2
	     , rect_mapOverlayLegend_PVProduction3
	     , txt_mapOverlayLegend_PVProduction1
	     , txt_mapOverlayLegend_PVProduction2
	     , txt_mapOverlayLegend_PVProduction3 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_mapOverlayLegend_PVProduction_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_mapOverlayLegend_PVProduction.setVisible( false );
    {
    gr_mapOverlayLegend_gridNeighbours = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 600.0, 0.0, 0.0, 0.0
	
	     , rect_mapOverlayLegend_gridNeighbours1
	     , rect_mapOverlayLegend_gridNeighbours2
	     , rect_mapOverlayLegend_gridNeighbours3
	     , txt_mapOverlayLegend_gridNeighbours1
	     , txt_mapOverlayLegend_gridNeighbours2
	     , txt_mapOverlayLegend_gridNeighbours3
	     , rect_mapOverlayLegend_gridNeighbours4
	     , txt_mapOverlayLegend_gridNeighbours4
	     , txt_mapOverlayLegend_gridNeighbours5 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_mapOverlayLegend_gridNeighbours_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_mapOverlayLegend_gridNeighbours.setVisible( false );
    {
    gr_rect_mapOverlayLegend_congestion2 = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, -65.0, -25.0, 0.0, 0.0
	
	     , rect_mapOverlayLegend_congestion21
	     , rect_mapOverlayLegend_congestion22
	     , rect_mapOverlayLegend_congestion23 );
    }
    {
    gr_mapOverlayLegend_congestion = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 800.0, 0.0, 0.0, 0.0
	
	     , rb_mapOverlayLegend_congestion
	     , txt_mapOverlayLegend_congestion3
	     , rect_mapOverlayLegend_congestion1
	     , txt_mapOverlayLegend_congestion1
	     , i_mapOverlayLegend_congestion_Degrees
	     , gr_rect_mapOverlayLegend_congestion2
	     , txt_mapOverlayLegend_congestion2
	     , i_mapOverlayLegend_congestion_Types ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_mapOverlayLegend_congestion_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_mapOverlayLegend_congestion.setVisible( false );
    {
    gr_mapOverlayLegend_EnergyLabel = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 985.0, -5.0, 0.0, 0.0
	
	     , rect_mapOverlayLegend_EnergyLabelA
	     , rect_mapOverlayLegend_EnergyLabelB
	     , rect_mapOverlayLegend_EnergyLabelC
	     , rect_mapOverlayLegend_EnergyLabelD
	     , rect_mapOverlayLegend_EnergyLabelE
	     , txt_mapOverlayLegend_EnergyLabelA
	     , txt_mapOverlayLegend_EnergyLabelB
	     , txt_mapOverlayLegend_EnergyLabelC
	     , txt_mapOverlayLegend_EnergyLabelD
	     , txt_mapOverlayLegend_EnergyLabelE
	     , rect_mapOverlayLegend_EnergyLabelF
	     , txt_mapOverlayLegend_EnergyLabelF
	     , rect_mapOverlayLegend_EnergyLabelG
	     , txt_mapOverlayLegend_EnergyLabelG
	     , rect_mapOverlayLegend_EnergyLabelUnknown
	     , txt_mapOverlayLegend_EnergyLabelUnknown ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_mapOverlayLegend_EnergyLabel_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_mapOverlayLegend_EnergyLabel.setVisible( false );
    {
    gr_mapOverlayLegenda = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 1750.0, 840.0, 0.0, 0.0
	
	     , gr_mapOverlayLegend_ElectricityConsumption
	     , gr_defaultLegenda
	     , gr_mapOverlayLegend_PVProduction
	     , gr_mapOverlayLegend_gridNeighbours
	     , gr_mapOverlayLegend_congestion
	     , gr_mapOverlayLegend_EnergyLabel ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_mapOverlayLegenda_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_extendedLegend = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 170.0, 960.0, 0.0, 0.0
	
	     , rect_extendedLegendLine
	     , rect_extendedLegend
	     , rect_specialGISObjectLegend7
	     , t_specialGISObjectLegend7
	     , rect_specialGISObjectLegend8
	     , t_specialGISObjectLegend8
	     , rect_specialGISObjectLegend9
	     , t_specialGISObjectLegend9
	     , rect_specialGISObjectLegend10
	     , t_specialGISObjectLegend10
	     , rect_specialGISObjectLegend11
	     , t_specialGISObjectLegend11
	     , rect_specialGISObjectLegend12
	     , t_specialGISObjectLegend12
	     , line ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_extendedLegend_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_extendedLegend.setVisible( false );
    {
    gr_specificGISObjectLegend = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 440.0, 0.0, 0.0, 0.0
	
	     , rect_specialGISObjectLegend1
	     , t_specialGISObjectLegend1
	     , rect_specialGISObjectLegend2
	     , t_specialGISObjectLegend2
	     , rect_specialGISObjectLegend3
	     , t_specialGISObjectLegend3
	     , rect_specialGISObjectLegend4
	     , t_specialGISObjectLegend4
	     , rect_specialGISObjectLegend5
	     , t_specialGISObjectLegend5
	     , rect_specialGISObjectLegend6
	     , t_specialGISObjectLegend6
	     , gr_extendedLegend
	     , t_seeMoreLegend );
    }
    {
    gr_legenda = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 910.0, 880.0, 0.0, 0.0
	
	     , rect_legenda
	     , t_legenda
	     , line_legendaSeperator1
	     , line_legendaSeperator2
	     , gr_infrastructure
	     , gr_buildings
	     , gr_mapOverlayLegenda
	     , gr_specificGISObjectLegend );
    }
    {
    gr_loadIconYearSimulation = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, -261.0, -25.0, 0.0, 0.0
	
	     , rect_loadIconSmall
	     , image_loadIconSmall
	     , t_loadIconSmall );
    }
    gr_loadIconYearSimulation.setVisible( false );
    {
    gr_simulateYearButton = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 10.0, 50.0, 0.0, 0.0
	
	     , t_simulateYearToCalculateCostsSmall
	     , image_simulateYearToCalculateCostsSmall ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_simulateYearButton, 0, clickx, clicky );
      }
    };
    }
    {
    gr_simulateYear = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 270.0, 20.0, 0.0, 0.0
	
	     , rect_simulateYearScreenSmall
	     , gr_simulateYearButton ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_simulateYear_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_simulateYear.setVisible( false );
    {
    gr_simulateYearScreen = new ShapeGroup( Zero_Interface.this, SHAPE_DRAW_2D3D, true, 1920.0, 160.0, 0.0, 0.0
	
	     , gr_loadIconYearSimulation
	     , gr_simulateYear );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
    uI_Tabs_presentation.setEmbeddedObject_xjal( uI_Tabs );
    uI_Results_presentation.setEmbeddedObject_xjal( uI_Results );
    uI_Tabs_presentation.setEmbeddedObject_xjal( uI_Tabs );
    uI_Results_presentation.setEmbeddedObject_xjal( uI_Results );
  }



  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    map = new ShapeGISMap(
		Zero_Interface.this, SHAPE_DRAW_2D3D, true, 410.0, 130.0,
			1000.0, 620.0, "/zerointerfaceloader/", new ShapeGISMap.Layer[] { }, 52.539123187983904, 6.173604854475837, 4.0E-5, silver,
white, true,
		TileURLProviderType.CUSTOM, new String[] {"https://gistiles.lux.energy/maptiler-base-v4-hdpi/[zoom]/[x]/[y].png"},
		new AnyLogicOnlineRouteProvider(RoutingMethod.FASTEST, RouteProviderTransportType.CAR, 1),
		1 ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _map, 0, clickx, clicky );
      }
    };
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
    level1 = new com.anylogic.engine.markup.Level(this, "level1", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level,
      level1 };
    _createPersistentElementsBP0_xjal();
    _createPersistentElementsBP1_xjal();
    _createPersistentElementsBP2_xjal();
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
  public Zero_Interface( Engine engine, Agent owner, AgentList<? extends Zero_Interface> ownerPopulation ) {
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
    uI_Tabs = instantiate_uI_Tabs_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public Zero_Interface() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public Zero_Interface( EnergyModel energyModel, Settings settings, List<ShapeImage> p_currentActiveInfoBubble, int p_minSelectedGCForPublicAggregation, boolean b_inEnergyHubSelectionMode, boolean b_inEnergyHubMode, User user, Project_data project_data, UI_company uI_Company, UI_EnergyHub uI_EnergyHub, ShapeRadioButtonGroup rb_scenarios, String t_scenario_current, String t_scenario_future, String t_scenario_custom, J_SliderSettings_Residential p_residentialScenario_Current, Map<OL_FilterOptionsGC, String> map_filterOptionUINames, Map<String, OL_FilterOptionsGC> map_UINamesFilterOption, String p_defaultMainSliderGCName_solarfarm, String p_defaultMainSliderGCName_windfarm, String p_defaultMainSliderGCName_battery, String p_defaultEnergyHubSliderGCName_solarfarm, String p_defaultEnergyHubSliderGCName_windfarm, String p_defaultEnergyHubSliderGCName_battery, String p_customMapOverlayName, ShapeGroup p_customMapOverlayLegend ) {
    markParametersAreSet();
    this.energyModel = energyModel;
    this.settings = settings;
    this.p_currentActiveInfoBubble = p_currentActiveInfoBubble;
    this.p_minSelectedGCForPublicAggregation = p_minSelectedGCForPublicAggregation;
    this.b_inEnergyHubSelectionMode = b_inEnergyHubSelectionMode;
    this.b_inEnergyHubMode = b_inEnergyHubMode;
    this.user = user;
    this.project_data = project_data;
    this.uI_Company = uI_Company;
    this.uI_EnergyHub = uI_EnergyHub;
    this.rb_scenarios = rb_scenarios;
    this.t_scenario_current = t_scenario_current;
    this.t_scenario_future = t_scenario_future;
    this.t_scenario_custom = t_scenario_custom;
    this.p_residentialScenario_Current = p_residentialScenario_Current;
    this.map_filterOptionUINames = map_filterOptionUINames;
    this.map_UINamesFilterOption = map_UINamesFilterOption;
    this.p_defaultMainSliderGCName_solarfarm = p_defaultMainSliderGCName_solarfarm;
    this.p_defaultMainSliderGCName_windfarm = p_defaultMainSliderGCName_windfarm;
    this.p_defaultMainSliderGCName_battery = p_defaultMainSliderGCName_battery;
    this.p_defaultEnergyHubSliderGCName_solarfarm = p_defaultEnergyHubSliderGCName_solarfarm;
    this.p_defaultEnergyHubSliderGCName_windfarm = p_defaultEnergyHubSliderGCName_windfarm;
    this.p_defaultEnergyHubSliderGCName_battery = p_defaultEnergyHubSliderGCName_battery;
    this.p_customMapOverlayName = p_customMapOverlayName;
    this.p_customMapOverlayLegend = p_customMapOverlayLegend;
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
    setupPlainVariables_Zero_Interface_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
	_initialize_level1_xjal();
    level.initialize();
    level1.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Zero_Interface.this, true, 0, 0, 0, 0 , level, level1 );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Zero_Interface.this, getElementProperty( "zerointerfaceloader.Zero_Interface.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );


    // Space setup
    setupSpace( map );
    disableSteps();
    setNetworkUserDefined();
    // Creating non-replicated embedded objects
    setupParameters_uI_Results_xjal( uI_Results, null );
    doBeforeCreate_uI_Results_xjal( uI_Results, null );
    uI_Results.createAsEmbedded();
    setupParameters_uI_Tabs_xjal( uI_Tabs, null );
    doBeforeCreate_uI_Tabs_xjal( uI_Tabs, null );
    uI_Tabs.createAsEmbedded();
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    for ( int i = 0; i < pop_UI_Company.size(); i++ ) {
      UI_company _a = pop_UI_Company.get(i);
      setupParameters_pop_UI_Company_xjal( _a, i, null );
      doBeforeCreate_pop_UI_Company_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < pop_UI_EnergyHub.size(); i++ ) {
      UI_EnergyHub _a = pop_UI_EnergyHub.get(i);
      setupParameters_pop_UI_EnergyHub_xjal( _a, i, null );
      doBeforeCreate_pop_UI_EnergyHub_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    setupInitialConditions_xjal( Zero_Interface.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    rb_scenarios_template.setValueToDefault();
    checkbox_cables.setValueToDefault();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    e_calculateEnergyBalance.start();
    e_setStartView.start();
    _plot_outsideTemperature_autoUpdateEvent_xjal.start();
    _plot_solarIrradiance_autoUpdateEvent_xjal.start();
    for (Agent embeddedObject : pop_UI_Company) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_UI_EnergyHub) {
      embeddedObject.startAsEmbedded();
    }
    uI_Results.startAsEmbedded();
    uI_Tabs.startAsEmbedded();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Zero_Interface_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Zero_Interface_xjal() {
    v_LVGridColor = 
purple 
;
    v_HVGridColor = 
red 
;
    v_gasGridColor = 
brown 
;
    v_energyLabelAColor = 
darkGreen 
;
    v_energyLabelBColor = 
green 
;
    v_energyLabelCColor = 
yellowGreen 
;
    v_energyLabelDColor = 
gold 
;
    v_energyLabelEColor = 
orange 
;
    v_energyLabelFColor = 
orangeRed 
;
    v_energyLabelUnknownColor = 
gray 
;
    v_energyLabelGColor = 
red 
;
    v_MVGridColor = 
steelBlue 
;
    v_clickedObjectText = 
"None" 
;
    v_simulationArea1Color = 
new Color(178, 34, 34, 0) 
;
    v_companyBuildingColor = 
teal 
;
    v_detailedCompanyBuildingColor = 
navy 
;
    v_houseBuildingColor = 
new Color(154, 208, 194) 
;
    v_restBuildingColor = 
gainsboro 
;
    v_solarParkColor = 
new Color(250, 246, 179, 206) 
;
    v_selectionColor = 
yellow 
;
    v_selectionColorAddBuildings = 
yellow 
;
    v_HVMVNodeColor = 
new Color(253, 223, 134, 206) 
;
    v_HVMVLineColor = 
navy 
;
    v_solarParkLineColor = 
gold 
;
    v_electrolyserColor = 
new Color(33, 164, 195) 
;
    v_chargingStationColor = 
cyan 
;
    v_antiLayerColor = 
new Color(192, 192, 192, 100) 
;
    v_electrolyserLineColor = 
navy 
;
    v_chargingStationLineColor = 
darkBlue 
;
    v_simulationArea1LineColor = 
dimGray 
;
    v_backgroundColor = 
(new Color(208, 208, 245)).brighter() 
;
    v_gridNodeFeedinColor = 
orange 
;
    v_batteryColor = 
green.darker() 
;
    v_batteryLineColor = 
green 
;
    v_windFarmColor = 
white 
;
    v_windFarmLineColor = 
black 
;
    v_MVLVNodeColor = 
green 
;
    v_MVLVLineColor = 
green.brighter() 
;
    v_gridNodeColorStrained = 
orange 
;
    v_gridNodeLineColorStrained = 
orange.brighter() 
;
    v_gridNodeColorCongested = 
red 
;
    v_gridLineColorCongested = 
red.brighter() 
;
    v_unknownConsumptionColor = 
white 
;
    b_updateLiveCongestionColors = 
false 
;
    v_newChargingStationColor = 
new Color(173, 255, 47, 156) 
;
    v_newChargingStationLineColor = 
green 
;
    v_selectedGridConnectionIndex = 
0 
;
    v_nbGridConnectionsInSelectedBuilding = 
0 
;
    v_companyBuildingLineColor = 
black 
;
    v_detailedCompanyBuildingLineColor = 
black 
;
    v_houseBuildingLineColor = 
black 
;
    v_parcelColor = 
navajoWhite 
;
    v_parcelLineColor = 
black 
;
    v_MVMVNodeColor = 
new Color(253, 223, 134, 206) 
;
    v_MVMVLineColor = 
navy 
;
    v_HVMVNodeSize = 
100 
;
    v_MVMVNodeSize = 
30 
;
    v_MVLVNodeSize = 
20 
;
    v_energyAssetLineWidth = 
2 
;
    b_runningMainInterfaceScenarios = 
false 
;
    b_gridLoopsAreDefined = 
false 
;
    v_forcedClickScreenColor = 
new Color(105, 105, 105, 150) 
;
    b_inManualFilterSelectionMode = 
false 
;
    v_infoText = 
new J_InfoText() 
;
    v_parkingSpaceColor_private = 
salmon 
;
    v_parkingSpaceLineColor_private = 
red 
;
    v_parkingSpaceColor_electric = 
lightGreen 
;
    v_parkingSpaceLineColor_electric = 
green 
;
    v_parkingSpaceColor_public = 
lightBlue 
;
    v_parkingSpaceLineColor_public = 
blue 
;
    v_HVMVNodeIsVisible = 
false 
;
    v_gridNodeLineColorUncongested = 
green.brighter() 
;
    v_gridNodeColorUncongested = 
green 
;
    v_LVLVNodeColor = 
green 
;
    v_LVLVLineColor = 
green.brighter() 
;
    v_LVLVNodeSize = 
10 
;
    v_amountOfDefinedGridLoops = 
0 
;
    v_gridNodeColorCapacityUnknown = 
gray 
;
    v_gridNodeLineColorCapacityUnknown = 
gray.brighter() 
;
    v_parkingSpaceLineColor_unkown = 
gray.darker() 
;
    v_parkingSpaceColor_unkown = 
gray 
;
    v_currentViewArea = 
va_Interface 
;
  }

  // User API -----------------------------------------------------
  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }


  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<>();
    }
    list.add( pop_UI_Company );
    list.add( uI_Results );
    list.add( uI_Tabs );
    list.add( pop_UI_EnergyHub );
    return list;
  }

  public AgentList<? extends Zero_Interface> getPopulation() {
    return (AgentList<? extends Zero_Interface>) super.getPopulation();
  }

  public List<? extends Zero_Interface> agentsInRange( double distance ) {
    return (List<? extends Zero_Interface>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _plot_outsideTemperature_autoUpdateEvent_xjal ) return false;
    if ( _e == _plot_solarIrradiance_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    e_calculateEnergyBalance.onDestroy();
    e_setStartView.onDestroy();
    _plot_outsideTemperature_autoUpdateEvent_xjal.onDestroy();
    _plot_solarIrradiance_autoUpdateEvent_xjal.onDestroy();
    for (Agent _item : pop_UI_Company) {
      _item.onDestroy();
    }
    uI_Results.onDestroy();
    uI_Tabs.onDestroy();
    for (Agent _item : pop_UI_EnergyHub) {
      _item.onDestroy();
    }
    map.destroy();
  	for (int _pIdx = 0; _pIdx < plot_outsideTemperature.getCount(); _pIdx++) {
  		DataSet _ds = plot_outsideTemperature.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_outsideTemperature.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_outsideTemperature : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < plot_solarIrradiance.getCount(); _pIdx++) {
  		DataSet _ds = plot_solarIrradiance.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_solarIrradiance.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_solarIrradiance : " + _t );
  	}
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    for (Agent _item : pop_UI_Company) {
      _item.doFinish();
    }
    uI_Results.doFinish();
    uI_Tabs.doFinish();
    for (Agent _item : pop_UI_EnergyHub) {
      _item.doFinish();
    }
  }

  // Additional class code

public ShapeButton getButton_goToUI() {
	return this.button_goToUI;
}
public ShapeRadioButtonGroup getBuildingColorsRB(){
	return this.rb_mapOverlay;
}
public ShapeCheckBox getCb_showFilterInterface(){
	return this.cb_showFilterInterface;
}
public ShapeComboBox getCb_filterOptions(){
	return this.cb_filterOptions;
}
 
  // End of additional class code

}
