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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.FileOutputStream;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Dictionary.*;
import java.util.Hashtable.*;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Triple;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;


//Possibility to turn of traceln
import java.io.OutputStream;
import java.io.PrintStream;

//Import survey API library
import com.zenmo.vallum.Vallum;
import com.zenmo.zummon.companysurvey.TimeSeries;

import zeroPackage.ZeroMath;
import com.zenmo.zummon.companysurvey.PandIDKt;
import com.zenmo.vallum.PandKt;
import kotlinx.datetime.DateTimeUnit;

import com.zenmo.zummon.companysurvey.HeatingType;
import com.querydsl.core.types.dsl.CaseBuilder;

import energy.lux.uplux.*;
//import java.util.UUID;
import kotlin.uuid.Uuid;
import org.eclipse.jetty.server.LowResourceMonitor.MaxConnectionsLowResourceCheck;
import com.zenmo.zummon.companysurvey.PVOrientation; 

public class Zero_Loader extends Agent
{
  // Text Files
  public TextFile inputCSVcookingActivities = new TextFile( this, "/zerointerfaceloader/", TextFile.READ, "data_Generic/inputECookerPatterns.csv", null, new char[] { ',' } );
  public TextFile inputCSVhouseholdTrips = new TextFile( this, "/zerointerfaceloader/", TextFile.READ, "data_Generic/AlbatrossProcessedVehicleTrips.csv", null, new char[] { ',' } );
  public TextFile inputCSVtruckTrips = new TextFile( this, "/zerointerfaceloader/", TextFile.READ, "data_Generic/inputTruckTripPatterns.csv", null, new char[] { ',' } );

  // Parameters

  public 
Zero_Interface  zero_Interface;

  /**
   * Returns default value for parameter <code>zero_Interface</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Zero_Interface _zero_Interface_DefaultValue_xjal() {
    final Zero_Loader self = this;
    return null;
  }

  public void set_zero_Interface( Zero_Interface value ) {
    if (value == this.zero_Interface) {
      return;
    }
    Zero_Interface _oldValue_xjal = this.zero_Interface;
    this.zero_Interface = value;
    onChange_zero_Interface_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter zero_Interface.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_zero_Interface()</code> method instead.
   */
  protected void onChange_zero_Interface() {
    onChange_zero_Interface_xjal( zero_Interface );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_zero_Interface_xjal( Zero_Interface oldValue ) {  
  }


  public 
DefaultProfiles_data  defaultProfiles_data;

  /**
   * Returns default value for parameter <code>defaultProfiles_data</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public DefaultProfiles_data _defaultProfiles_data_DefaultValue_xjal() {
    final Zero_Loader self = this;
    return null;
  }

  public void set_defaultProfiles_data( DefaultProfiles_data value ) {
    if (value == this.defaultProfiles_data) {
      return;
    }
    DefaultProfiles_data _oldValue_xjal = this.defaultProfiles_data;
    this.defaultProfiles_data = value;
    onChange_defaultProfiles_data_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter defaultProfiles_data.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_defaultProfiles_data()</code> method instead.
   */
  protected void onChange_defaultProfiles_data() {
    onChange_defaultProfiles_data_xjal( defaultProfiles_data );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_defaultProfiles_data_xjal( DefaultProfiles_data oldValue ) {  
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
    final Zero_Loader self = this;
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


  /**
   * Should be filled with the settings record created in the startup of the project model
   */
  public 
Settings  settings;

  /**
   * Returns default value for parameter <code>settings</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Settings _settings_DefaultValue_xjal() {
    final Zero_Loader self = this;
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
User  user;

  /**
   * Returns default value for parameter <code>user</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public User _user_DefaultValue_xjal() {
    final Zero_Loader self = this;
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


  public 
J_RemainingTotalsManager  p_remainingTotals;

  /**
   * Returns default value for parameter <code>p_remainingTotals</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_RemainingTotalsManager _p_remainingTotals_DefaultValue_xjal() {
    final Zero_Loader self = this;
    return 
new J_RemainingTotalsManager(avgc_data) 
;
  }

  public void set_p_remainingTotals( J_RemainingTotalsManager value ) {
    if (value == this.p_remainingTotals) {
      return;
    }
    J_RemainingTotalsManager _oldValue_xjal = this.p_remainingTotals;
    this.p_remainingTotals = value;
    onChange_p_remainingTotals_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_remainingTotals.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_remainingTotals()</code> method instead.
   */
  protected void onChange_p_remainingTotals() {
    onChange_p_remainingTotals_xjal( p_remainingTotals );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_remainingTotals_xjal( J_RemainingTotalsManager oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    zero_Interface = _zero_Interface_DefaultValue_xjal();
    defaultProfiles_data = _defaultProfiles_data_DefaultValue_xjal();
    project_data = _project_data_DefaultValue_xjal();
    settings = _settings_DefaultValue_xjal();
    user = _user_DefaultValue_xjal();
    p_remainingTotals = _p_remainingTotals_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "zero_Interface":
      if ( _callOnChange_xjal ) {
        set_zero_Interface( (Zero_Interface) _value_xjal );
      } else {
        zero_Interface = (Zero_Interface) _value_xjal;
      }
      return true;
    case "defaultProfiles_data":
      if ( _callOnChange_xjal ) {
        set_defaultProfiles_data( (DefaultProfiles_data) _value_xjal );
      } else {
        defaultProfiles_data = (DefaultProfiles_data) _value_xjal;
      }
      return true;
    case "project_data":
      if ( _callOnChange_xjal ) {
        set_project_data( (Project_data) _value_xjal );
      } else {
        project_data = (Project_data) _value_xjal;
      }
      return true;
    case "settings":
      if ( _callOnChange_xjal ) {
        set_settings( (Settings) _value_xjal );
      } else {
        settings = (Settings) _value_xjal;
      }
      return true;
    case "user":
      if ( _callOnChange_xjal ) {
        set_user( (User) _value_xjal );
      } else {
        user = (User) _value_xjal;
      }
      return true;
    case "p_remainingTotals":
      if ( _callOnChange_xjal ) {
        set_p_remainingTotals( (J_RemainingTotalsManager) _value_xjal );
      } else {
        p_remainingTotals = (J_RemainingTotalsManager) _value_xjal;
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
    case "zero_Interface": _result_xjal = zero_Interface; break;
    case "defaultProfiles_data": _result_xjal = defaultProfiles_data; break;
    case "project_data": _result_xjal = project_data; break;
    case "settings": _result_xjal = settings; break;
    case "user": _result_xjal = user; break;
    case "p_remainingTotals": _result_xjal = p_remainingTotals; break;
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
      list.add( "zero_Interface" );
      list.add( "defaultProfiles_data" );
      list.add( "project_data" );
      list.add( "settings" );
      list.add( "user" );
      list.add( "p_remainingTotals" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
double 
 v_timeOfModelStart_ms;
  public 
int 
 v_numberOfSurveyCompanyGC;
  public 
Map<String, com.zenmo.bag.Pand> 
 map_buildingData_Vallum;
  public 
double 
 v_probabilityForAdditionalCar_privateParking;
  public 
double 
 v_probabilityForAdditionalCar_publicParking;
  public 
double 
 totalSpaceHeatDemand_kwhpa;
  public 
Instant 
 v_projectDataLastChangedDate;
  public 
double 
 v_modelStartUpDuration_s;
  public 
Map<Integer,List<DHWProfile_data>> 
 map_nrOfResidentsToDHWProfiles_data;

  // Collection Variables
  public 
ArrayList <
String > c_gridNodeIDsInScope = new ArrayList<String>();
  public 
ArrayList <
Building_data > c_companyBuilding_data = new ArrayList<Building_data>();
  public 
ArrayList <
GridNode_data > c_gridNode_data = new ArrayList<GridNode_data>();
  private 
ArrayList <
Building_data > c_surveyCompanyBuilding_data = new ArrayList<Building_data>();
  public 
ArrayList <
Building_data > c_houseBuilding_data = new ArrayList<Building_data>();
  public 
ArrayList <
Solarfarm_data > c_solarfarm_data = new ArrayList<Solarfarm_data>();
  public 
ArrayList <
Windfarm_data > c_windfarm_data = new ArrayList<Windfarm_data>();
  public 
ArrayList <
Electrolyser_data > c_electrolyser_data = new ArrayList<Electrolyser_data>();
  public 
ArrayList <
Battery_data > c_battery_data = new ArrayList<Battery_data>();
  public 
ArrayList <
Cable_data > c_cable_data = new ArrayList<Cable_data>();
  public 
ArrayList <
Neighbourhood_data > c_neighbourhood_data = new ArrayList<Neighbourhood_data>();
  public 
ArrayList <
Building_data > c_remainingBuilding_data = new ArrayList<Building_data>();
  public 
ArrayList <
Chargingstation_data > c_chargingstation_data = new ArrayList<Chargingstation_data>();
  public 
ArrayList <
Parcel_data > c_parcel_data = new ArrayList<Parcel_data>();
  public 
ArrayList <
Building_data > c_vallumBuilding_data = new ArrayList<Building_data>();
  public 
ArrayList <
CustomProfile_data > c_customProfiles_data = new ArrayList<CustomProfile_data>();
  public 
ArrayList <
String > c_gridNodeIDsWithProfiles = new ArrayList<String>();
  public 
ArrayList <
ChargerProfile_data > c_chargerProfiles_data = new ArrayList<ChargerProfile_data>();
  public 
ArrayList <
ParkingSpace_data > c_parkingSpace_data = new ArrayList<ParkingSpace_data>();
  private 
ArrayList <
GIS_Object > c_activeNBH = new ArrayList<GIS_Object>();
  public 
ArrayList <
PBL_SpaceHeatingAndResidents_data > c_lookupTablePBL_spaceHeatingAndResidents = new ArrayList<PBL_SpaceHeatingAndResidents_data>();
  public 
ArrayList <
PBL_DHWAndCooking_data > c_lookupTablePBL_DHWAndCooking = new ArrayList<PBL_DHWAndCooking_data>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Zero_Loader.class );

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

  public zero_engine.EnergyModel energyModel;
  public AVGC_data avgc_data;

  public String getNameOf( Agent ao ) {
    if ( ao == energyModel ) return "energyModel";
    if ( ao == avgc_data ) return "avgc_data";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
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
  protected zero_engine.EnergyModel instantiate_energyModel_xjal() {
    zero_engine.EnergyModel _result_xjal = new zero_engine.EnergyModel( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_energyModel_xjal( final zero_engine.EnergyModel self, TableInput _t ) {
    self.b_parallelizeConnectionOwners = self._b_parallelizeConnectionOwners_DefaultValue_xjal();
    self.b_parallelizeGridConnections = self._b_parallelizeGridConnections_DefaultValue_xjal();
    self.p_tempForecastTime_h = self._p_tempForecastTime_h_DefaultValue_xjal();
    self.p_truckTripsCsv = self._p_truckTripsCsv_DefaultValue_xjal();
    self.p_householdTripsCsv = self._p_householdTripsCsv_DefaultValue_xjal();
    self.p_cookingPatternCsv = self._p_cookingPatternCsv_DefaultValue_xjal();
    self.avgc_data = self._avgc_data_DefaultValue_xjal();
    self.b_enableDLR = self._b_enableDLR_DefaultValue_xjal();
    self.b_isInitialized = self._b_isInitialized_DefaultValue_xjal();
    self.b_storePreviousRapidRunData = self._b_storePreviousRapidRunData_DefaultValue_xjal();
    self.p_regionName = self._p_regionName_DefaultValue_xjal();
    self.b_isDeserialised = self._b_isDeserialised_DefaultValue_xjal();
    self.p_timeVariables = self._p_timeVariables_DefaultValue_xjal();
    self.p_timeParameters = self._p_timeParameters_DefaultValue_xjal();
    self.p_pvForecastTime_h = self._p_pvForecastTime_h_DefaultValue_xjal();
    self.p_windForecastTime_h = self._p_windForecastTime_h_DefaultValue_xjal();
    self.p_epexForecastTime_h = self._p_epexForecastTime_h_DefaultValue_xjal();
    self.p_CO2EmissionFactorForecastTime_h = self._p_CO2EmissionFactorForecastTime_h_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_energyModel_xjal( zero_engine.EnergyModel self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 
0 
;double _y_xjal = 
0 
;double _z_xjal = 
0 
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected AVGC_data instantiate_avgc_data_xjal() {
    AVGC_data _result_xjal = new AVGC_data( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_avgc_data_xjal( final AVGC_data self, TableInput _t ) {
    self.p_avgHouseConnectionCapacity_kW = self._p_avgHouseConnectionCapacity_kW_DefaultValue_xjal();
    self.p_avgHouseHeatingMethod = self._p_avgHouseHeatingMethod_DefaultValue_xjal();
    self.p_avgUtilityConnectionCapacity_kW = self._p_avgUtilityConnectionCapacity_kW_DefaultValue_xjal();
    self.p_avgUtilityHeatingMethod = self._p_avgUtilityHeatingMethod_DefaultValue_xjal();
    self.p_avgHouseElectricityConsumption_kWh_yr = self._p_avgHouseElectricityConsumption_kWh_yr_DefaultValue_xjal();
    self.p_avgHouseGasConsumption_m3_yr = self._p_avgHouseGasConsumption_m3_yr_DefaultValue_xjal();
    self.p_shareOfElectricVehicleOwnership = self._p_shareOfElectricVehicleOwnership_DefaultValue_xjal();
    self.p_ratioHouseInstalledPV = self._p_ratioHouseInstalledPV_DefaultValue_xjal();
    self.p_avgHousePVInstallationPower_kWp = self._p_avgHousePVInstallationPower_kWp_DefaultValue_xjal();
    self.p_avgEVStorageCar_kWh = self._p_avgEVStorageCar_kWh_DefaultValue_xjal();
    self.p_avgEVMaxChargePowerCar_kW = self._p_avgEVMaxChargePowerCar_kW_DefaultValue_xjal();
    self.p_avgEVStorageVan_kWh = self._p_avgEVStorageVan_kWh_DefaultValue_xjal();
    self.p_avgEVStorageTruck_kWh = self._p_avgEVStorageTruck_kWh_DefaultValue_xjal();
    self.p_avgEVMaxChargePowerVan_kW = self._p_avgEVMaxChargePowerVan_kW_DefaultValue_xjal();
    self.p_avgEVMaxChargePowerTruck_kW = self._p_avgEVMaxChargePowerTruck_kW_DefaultValue_xjal();
    self.p_avgEVEnergyConsumptionCar_kWhpkm = self._p_avgEVEnergyConsumptionCar_kWhpkm_DefaultValue_xjal();
    self.p_avgEVEnergyConsumptionVan_kWhpkm = self._p_avgEVEnergyConsumptionVan_kWhpkm_DefaultValue_xjal();
    self.p_avgEVEnergyConsumptionTruck_kWhpkm = self._p_avgEVEnergyConsumptionTruck_kWhpkm_DefaultValue_xjal();
    self.p_gas_kWhpm3 = self._p_gas_kWhpm3_DefaultValue_xjal();
    self.p_hydrogenEnergyDensity_kWh_Nm3 = self._p_hydrogenEnergyDensity_kWh_Nm3_DefaultValue_xjal();
    self.p_hydrogenDensity_kg_Nm3 = self._p_hydrogenDensity_kg_Nm3_DefaultValue_xjal();
    self.p_oxygenDensity_kg_Nm3 = self._p_oxygenDensity_kg_Nm3_DefaultValue_xjal();
    self.p_oxygenProduction_kgO2pkgH2 = self._p_oxygenProduction_kgO2pkgH2_DefaultValue_xjal();
    self.p_hydrogenSpecificEnergy_kWh_kg = self._p_hydrogenSpecificEnergy_kWh_kg_DefaultValue_xjal();
    self.p_diesel_kWhpl = self._p_diesel_kWhpl_DefaultValue_xjal();
    self.p_avgDieselConsumptionCar_kmpl = self._p_avgDieselConsumptionCar_kmpl_DefaultValue_xjal();
    self.p_avgGasolineConsumptionCar_kmpl = self._p_avgGasolineConsumptionCar_kmpl_DefaultValue_xjal();
    self.p_gasoline_kWhpl = self._p_gasoline_kWhpl_DefaultValue_xjal();
    self.p_avgDieselConsumptionCar_kWhpkm = self._p_avgDieselConsumptionCar_kWhpkm_DefaultValue_xjal();
    self.p_avgGasolineConsumptionCar_kWhpkm = self._p_avgGasolineConsumptionCar_kWhpkm_DefaultValue_xjal();
    self.p_avgDieselConsumptionVan_kmpl = self._p_avgDieselConsumptionVan_kmpl_DefaultValue_xjal();
    self.p_avgDieselConsumptionVan_kWhpkm = self._p_avgDieselConsumptionVan_kWhpkm_DefaultValue_xjal();
    self.p_avgDieselConsumptionTruck_kmpl = self._p_avgDieselConsumptionTruck_kmpl_DefaultValue_xjal();
    self.p_avgDieselConsumptionTruck_kWhpkm = self._p_avgDieselConsumptionTruck_kWhpkm_DefaultValue_xjal();
    self.p_avgCOPHeatpump = self._p_avgCOPHeatpump_DefaultValue_xjal();
    self.p_avgUtilityPVPower_kWp = self._p_avgUtilityPVPower_kWp_DefaultValue_xjal();
    self.p_ratioElectricTrucks = self._p_ratioElectricTrucks_DefaultValue_xjal();
    self.p_avgCompanyHeatingMethod = self._p_avgCompanyHeatingMethod_DefaultValue_xjal();
    self.p_avgPVPower_kWpm2 = self._p_avgPVPower_kWpm2_DefaultValue_xjal();
    self.p_avgRatioBatteryCapacity_v_Power = self._p_avgRatioBatteryCapacity_v_Power_DefaultValue_xjal();
    self.p_avgHydrogenConsumptionCar_kWhpkm = self._p_avgHydrogenConsumptionCar_kWhpkm_DefaultValue_xjal();
    self.p_avgHydrogenConsumptionVan_kWhpkm = self._p_avgHydrogenConsumptionVan_kWhpkm_DefaultValue_xjal();
    self.p_avgHydrogenConsumptionTruck_kWhpkm = self._p_avgHydrogenConsumptionTruck_kWhpkm_DefaultValue_xjal();
    self.p_avgRatioRoofPotentialPV = self._p_avgRatioRoofPotentialPV_DefaultValue_xjal();
    self.p_avgEfficiencyHeatpump_fr = self._p_avgEfficiencyHeatpump_fr_DefaultValue_xjal();
    self.p_avgOutputTemperatureElectricHeatpump_degC = self._p_avgOutputTemperatureElectricHeatpump_degC_DefaultValue_xjal();
    self.p_avgEfficiencyGasBurner_fr = self._p_avgEfficiencyGasBurner_fr_DefaultValue_xjal();
    self.p_avgOutputTemperatureGasBurner_degC = self._p_avgOutputTemperatureGasBurner_degC_DefaultValue_xjal();
    self.p_avgEfficiencyHydrogenBurner_fr = self._p_avgEfficiencyHydrogenBurner_fr_DefaultValue_xjal();
    self.p_avgOutputTemperatureHydrogenBurner_degC = self._p_avgOutputTemperatureHydrogenBurner_degC_DefaultValue_xjal();
    self.p_defaultNrOfVehiclesPerChargerSocket = self._p_defaultNrOfVehiclesPerChargerSocket_DefaultValue_xjal();
    self.p_avgAnnualTravelDistanceVan_km = self._p_avgAnnualTravelDistanceVan_km_DefaultValue_xjal();
    self.p_avgAnnualTravelDistanceCompanyCar_km = self._p_avgAnnualTravelDistanceCompanyCar_km_DefaultValue_xjal();
    self.p_avgAnnualTravelDistanceTruck_km = self._p_avgAnnualTravelDistanceTruck_km_DefaultValue_xjal();
    self.p_avgFullLoadHoursPV_hr = self._p_avgFullLoadHoursPV_hr_DefaultValue_xjal();
    self.p_avgCompanyElectricityConsumption_kWhpm2 = self._p_avgCompanyElectricityConsumption_kWhpm2_DefaultValue_xjal();
    self.p_avgCompanyGasConsumption_m3pm2 = self._p_avgCompanyGasConsumption_m3pm2_DefaultValue_xjal();
    self.p_avgCompanyHeatConsumption_kWhpm2 = self._p_avgCompanyHeatConsumption_kWhpm2_DefaultValue_xjal();
    self.p_avgSolarFieldPower_kWppha = self._p_avgSolarFieldPower_kWppha_DefaultValue_xjal();
    self.p_avgEfficiencyCHP_thermal_fr = self._p_avgEfficiencyCHP_thermal_fr_DefaultValue_xjal();
    self.p_avgEfficiencyCHP_electric_fr = self._p_avgEfficiencyCHP_electric_fr_DefaultValue_xjal();
    self.p_avgOutputTemperatureCHP_degC = self._p_avgOutputTemperatureCHP_degC_DefaultValue_xjal();
    self.p_avgEfficiencyDistrictHeatingDeliverySet_fr = self._p_avgEfficiencyDistrictHeatingDeliverySet_fr_DefaultValue_xjal();
    self.p_avgOutputTemperatureDistrictHeatingDeliverySet_degC = self._p_avgOutputTemperatureDistrictHeatingDeliverySet_degC_DefaultValue_xjal();
    self.p_v2gProbability = self._p_v2gProbability_DefaultValue_xjal();
    self.p_v1gProbability = self._p_v1gProbability_DefaultValue_xjal();
    self.p_avgPTPower_kWpm2 = self._p_avgPTPower_kWpm2_DefaultValue_xjal();
    self.p_avgHeatBufferWaterVolumePerHPPower_m3pkW = self._p_avgHeatBufferWaterVolumePerHPPower_m3pkW_DefaultValue_xjal();
    self.p_avgHeatBufferWaterVolumePerPTSurface_m3pm2 = self._p_avgHeatBufferWaterVolumePerPTSurface_m3pm2_DefaultValue_xjal();
    self.p_waterHeatCapacity_JpkgK = self._p_waterHeatCapacity_JpkgK_DefaultValue_xjal();
    self.p_waterDensity_kgpm3 = self._p_waterDensity_kgpm3_DefaultValue_xjal();
    self.p_avgMaxHeatBufferTemperature_degC = self._p_avgMaxHeatBufferTemperature_degC_DefaultValue_xjal();
    self.p_avgMinHeatBufferTemperature_degC = self._p_avgMinHeatBufferTemperature_degC_DefaultValue_xjal();
    self.p_avgPTPanelSize_m2 = self._p_avgPTPanelSize_m2_DefaultValue_xjal();
    self.p_avgRatioHouseBatteryStorageCapacity_v_PVPower = self._p_avgRatioHouseBatteryStorageCapacity_v_PVPower_DefaultValue_xjal();
    self.p_avgNrOfCarsPerHouse = self._p_avgNrOfCarsPerHouse_DefaultValue_xjal();
    self.p_avgAnnualTravelDistancePrivateCar_km = self._p_avgAnnualTravelDistancePrivateCar_km_DefaultValue_xjal();
    self.p_avgAnnualTravelDistanceSecondVSFirstCar_fr = self._p_avgAnnualTravelDistanceSecondVSFirstCar_fr_DefaultValue_xjal();
    self.map_yearlySummerWinterTimeStartHour = self._map_yearlySummerWinterTimeStartHour_DefaultValue_xjal();
    self.p_minHeatpumpElectricCapacity_kW = self._p_minHeatpumpElectricCapacity_kW_DefaultValue_xjal();
    self.p_minGasBurnerOutputCapacity_kW = self._p_minGasBurnerOutputCapacity_kW_DefaultValue_xjal();
    self.p_minHydrogenBurnerOutputCapacity_kW = self._p_minHydrogenBurnerOutputCapacity_kW_DefaultValue_xjal();
    self.p_minDistrictHeatingDeliverySetOutputCapacity_kW = self._p_minDistrictHeatingDeliverySetOutputCapacity_kW_DefaultValue_xjal();
    self.p_avgOutputTemperatureHybridHeatpump_degC = self._p_avgOutputTemperatureHybridHeatpump_degC_DefaultValue_xjal();
    self.p_minAnnualTravelDistanceSurveyVehicle_km = self._p_minAnnualTravelDistanceSurveyVehicle_km_DefaultValue_xjal();
    self.p_PBL_HeatingLossFactor_fr = self._p_PBL_HeatingLossFactor_fr_DefaultValue_xjal();
    self.map_insulationLabel_lossfactorPerFloorSurface_WpKm2 = self._map_insulationLabel_lossfactorPerFloorSurface_WpKm2_DefaultValue_xjal();
    self.p_solarAbsorptionFloorSurfaceScalingFactor_fr = self._p_solarAbsorptionFloorSurfaceScalingFactor_fr_DefaultValue_xjal();
    self.p_avgSpaceHeatingTotalGasConsumptionShare_fr = self._p_avgSpaceHeatingTotalGasConsumptionShare_fr_DefaultValue_xjal();
    self.p_avgCookingTotalGasConsumptionShare_fr = self._p_avgCookingTotalGasConsumptionShare_fr_DefaultValue_xjal();
    self.p_avgDHWTotalGasConsumptionShare_fr = self._p_avgDHWTotalGasConsumptionShare_fr_DefaultValue_xjal();
    self.p_heatCapacitySizingConstant_JpK = self._p_heatCapacitySizingConstant_JpK_DefaultValue_xjal();
    self.p_heatCapacitySizingSlope_JpKm2 = self._p_heatCapacitySizingSlope_JpKm2_DefaultValue_xjal();
    self.p_heatCapacitySizingFactor_fr = self._p_heatCapacitySizingFactor_fr_DefaultValue_xjal();
    self.p_maxAvgHouseElectricityConsumptionOffset_kWhpa = self._p_maxAvgHouseElectricityConsumptionOffset_kWhpa_DefaultValue_xjal();
    self.p_maxAvgHouseGasConsumptionOffset_m3pa = self._p_maxAvgHouseGasConsumptionOffset_m3pa_DefaultValue_xjal();
    self.map_insulationLabel_cooldownPeriod_hr = self._map_insulationLabel_cooldownPeriod_hr_DefaultValue_xjal();
    self.p_avgHouseCookingMethod = self._p_avgHouseCookingMethod_DefaultValue_xjal();
    self.p_defaultNrOfSocketsPerCharger = self._p_defaultNrOfSocketsPerCharger_DefaultValue_xjal();
    self.map_avgCostOfEnergyCarrier_eurpkWh = self._map_avgCostOfEnergyCarrier_eurpkWh_DefaultValue_xjal();
    self.map_avgAssetSizeDependentCAPEX_eurpkW = self._map_avgAssetSizeDependentCAPEX_eurpkW_DefaultValue_xjal();
    self.map_avgAssetLifeTime_yr = self._map_avgAssetLifeTime_yr_DefaultValue_xjal();
    self.map_avgAssetSizeDependentOPEX_eurpkWpyr = self._map_avgAssetSizeDependentOPEX_eurpkWpyr_DefaultValue_xjal();
    self.map_gridOperatorTarrifs = self._map_gridOperatorTarrifs_DefaultValue_xjal();
    self.map_energyTaxesECImport_eurpkWh = self._map_energyTaxesECImport_eurpkWh_DefaultValue_xjal();
    self.VAT_energy_fr = self._VAT_energy_fr_DefaultValue_xjal();
    self.VAT_CAPEXAndOPEX_fr = self._VAT_CAPEXAndOPEX_fr_DefaultValue_xjal();
    self.map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh = self._map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh_DefaultValue_xjal();
    self.p_defaultPVOrientation = self._p_defaultPVOrientation_DefaultValue_xjal();
    self.map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh = self._map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh_DefaultValue_xjal();
    self.p_reductionInEnergyTaxes_eurpyr = self._p_reductionInEnergyTaxes_eurpyr_DefaultValue_xjal();
    self.map_bracketDependentEnergyTaxesECImport_eurpkWh = self._map_bracketDependentEnergyTaxesECImport_eurpkWh_DefaultValue_xjal();
    self.map_avgAssetBaseCAPEX_eur = self._map_avgAssetBaseCAPEX_eur_DefaultValue_xjal();
    self.map_avgAssetBaseOPEX_eurpyr = self._map_avgAssetBaseOPEX_eurpyr_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_avgc_data_xjal( AVGC_data self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 
0 
;double _y_xjal = 
0 
;double _z_xjal = 
0 
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }

  // Functions

  /**
   * Creates the outline of the simulated area
   */
  protected void f_createGISRegions(  ) { 

// Create neighborhoods and draw them
for (Neighbourhood_data NBH : c_neighbourhood_data) {	
	GIS_Object area = energyModel.add_pop_GIS_Objects();
	
	area.p_id = NBH.neighbourhoodname();
	area.p_GISObjectType = f_getNBHGISObjectType(area, NBH.neighbourhoodcode(), NBH.neighbourhoodtype());

	//Create gisregion
	area.gisRegion = zero_Interface.f_createGISObject(f_createGISObjectTokens(NBH.polygon(), area.p_GISObjectType));

	//Style area 
	zero_Interface.f_styleSimulationAreas(area);
	zero_Interface.c_GISNeighborhoods.add(area);
	
	
	//Energy totals
	p_remainingTotals.addNBH(NBH);
}

 
  }

  protected void f_createGridConnections(  ) { 

//Energy production sites
f_createSolarParks();
f_createWindFarms();

//Other infra assets
f_createChargingStations();
f_createElectrolysers();
f_createBatteries();

//Consumers
f_createCompanies();
f_createHouses(); 
  }

  /**
   * Generieke functie die flexibele modelconfiguratie mogelijk maakt op basis van externe data. Expliciet gemodelleerd om profiling en volgorde van initialisatie te kunnen controleren.<br>
   * <br>
   * @param: none<br>
   * @return: none<br>
   * @since: Sprint 6<br>
   * @author: Jorrit
   */
  public void f_configureEngine_default(  ) { 

//Set basic input files
energyModel.p_truckTripsCsv = inputCSVtruckTrips;
energyModel.p_householdTripsCsv = inputCSVhouseholdTrips;
energyModel.p_cookingPatternCsv = inputCSVcookingActivities;

//Actors
f_createActors();

//Create regions and initialize energy totals per region
f_createGISRegions();

if(user.NBHAccessType != null && user.NBHAccessType != OL_UserNBHAccessType.FULL){
	f_removeObjectsNotInActiveNBH();
}

//Initialize specific slider GC
f_initializeSpecificSliderGC();

//Grid nodes
f_createGridNodes();

//Grid connections
f_createGridConnections();

//Additional GIS objects
f_createAdditionalGISObjects();

//Initialize the engine
energyModel.f_initializeEngine();
 
  }

  protected void f_createGridNodes(  ) { 

OL_GridNodeType nodeType;
GISRegion gisregion;

// Grid operator (for now only one in the area)
GridOperator Grid_Operator = findFirst(energyModel.pop_gridOperators, p->p.p_actorID.equals(project_data.grid_operator().toString())) ;

for (GridNode_data GN_data : c_gridNode_data) {
	//    if no scope selected, or if node has 'all scopes' in input file or if the node specific scope is selected (exists in the arrayList)       
	if( settings.subscopesToSimulate() == null || settings.subscopesToSimulate().isEmpty() || GN_data.subscope() == null || settings.subscopesToSimulate().indexOf(GN_data.subscope()) > -1 ){ 
		if (GN_data.status()) {
			GridNode GN = energyModel.add_pop_gridNodes();
			GN.p_gridNodeID = GN_data.gridnode_id();
			c_gridNodeIDsInScope.add(GN.p_gridNodeID);
			
			// Check wether transformer capacity is known or estimated
			GN.p_capacity_kW = GN_data.capacity_kw();
			GN.p_originalCapacity_kW = GN.p_capacity_kW;	
			GN.p_realCapacityAvailable = GN_data.is_capacity_available();
			
			// Basic GN information
			//GN.p_nodeStatus = GN_data.status();
			GN.p_description = GN_data.description();
			
			// Connect
			GN.p_parentNodeID = GN_data.parent_node_id(); // Needs to be manually defined in the excel file of the nodes!
			GN.p_ownerGridOperator = Grid_Operator;
			
			//Define node type
			GN.p_nodeType = GN_data.type();
			switch (GN_data.type()) {
			    case LVLV:
			    case MVLV:
			    case SUBMV:
			    case MVMV:
			    case HVMV:
			        GN.p_energyCarrier = OL_EnergyCarriers.ELECTRICITY;
			        break;
			    default:
			        traceln("There is a gridnode in your input file with an incorrect node type");
			        break;
			}
			
			//Define GN location
			GN.p_latitude = GN_data.latitude();
			GN.p_longitude = GN_data.longitude();
			GN.setLatLon(GN.p_latitude, GN.p_longitude);
			
			//Create gis region
			GN.gisRegion = zero_Interface.f_createGISObject(f_createGISNodesTokens(GN));
			zero_Interface.f_styleGridNodes(GN);
			
			//Grid operator nodes
			Grid_Operator.c_electricityGridNodes.add(GN);
			
			
			//Gridnode service area
			if (GN_data.service_area_polygon() != null){
				//Create service area gis object
				GN.p_serviceAreaGisRegion = zero_Interface.f_createGISObject(f_createGISObjectTokens(GN_data.service_area_polygon(), OL_GISObjectType.GN_SERVICE_AREA));
				
				//Add to hashmap
				zero_Interface.c_GISNetplanes.add( GN.p_serviceAreaGisRegion );
			}
			
			//Gridnode profile
			if(GN_data.profile_data_kWh() != null && settings.gridNodeProfileLoaderType() != OL_GridNodeProfileLoaderType.NO_PROFILE){
				f_addGridNodeProfile(GN, GN_data.profile_data_kWh());
			}
		}
	}
}

 
  }

  protected 
double[] 
 f_createGISObjectTokens( String RegionCoords, OL_GISObjectType GISObjectType ) { 

if (RegionCoords.startsWith("MultiPolygon")){
	RegionCoords = RegionCoords.replace("MultiPolygon (((","");
	RegionCoords = RegionCoords.replace(","," ");
	RegionCoords = RegionCoords.replace(")))","");
}
else if(RegionCoords.startsWith("MULTIPOLYGON")){
	RegionCoords = RegionCoords.replace("MULTIPOLYGON (((","");
	RegionCoords = RegionCoords.replace(","," ");
	RegionCoords = RegionCoords.replace(")))","");
}
else if(RegionCoords.startsWith("Poly")){
	RegionCoords = RegionCoords.replace("Polygon ((","");
	RegionCoords = RegionCoords.replace(","," ");
	RegionCoords = RegionCoords.replace("))","");
}
else if(RegionCoords.startsWith("POLYGON")){
	RegionCoords = RegionCoords.replace("POLYGON ((","");
	RegionCoords = RegionCoords.replace(","," ");
	RegionCoords = RegionCoords.replace("))","");
}
else if(RegionCoords.startsWith("MultiLineString")){
	RegionCoords = RegionCoords.replace("MultiLineString ((","");
	RegionCoords = RegionCoords.replace(","," ");
	RegionCoords = RegionCoords.replace("))","");
}
else if(RegionCoords.startsWith("LineString")){
	RegionCoords = RegionCoords.replace("LineString (","");
	RegionCoords = RegionCoords.replace(","," ");
	RegionCoords = RegionCoords.replace(")","");
}
else {
	traceln("GIS coordinaten in de excel data die niet starten met Multi of Poly");
}



if(RegionCoords.contains(")(") || RegionCoords.contains(") (") || RegionCoords.contains(")  (")){
	if (GISObjectType == OL_GISObjectType.ANTI_LAYER){
		RegionCoords = RegionCoords.replace(")("," "); // Combine all polies into one!
		RegionCoords = RegionCoords.replace(") ("," "); // Combine all polies into one!
	}
	else{
		RegionCoords = RegionCoords.split("\\)")[0];
	}
}

RegionCoords = RegionCoords.replace("  "," ");
String delims = " ";
String[] tokens;
tokens = RegionCoords.split(delims);

int nbCoords = tokens.length;
double[] GISCoords = new double[nbCoords];
		
for (int i=0; i<nbCoords; i++) {
	if (i % 2 == 0) { // latitudes
		GISCoords[i]=Double.parseDouble(tokens[i+1]);
	} else { // longitudes
		GISCoords[i]=Double.parseDouble(tokens[i-1]);
	}
}
return GISCoords; 
  }

  /**
   * Automatisch inladen van excel files uit de model map naar de database.<br>
   * <br>
   * @author: Ate<br>
   * @since: 14-12-23
   */
  protected void f_importExcelTablesToDB(  ) { 

if(settings.reloadDatabase()){
	
	//Get the database names that are selected for reloading
	List<String[]> databaseNames = project_data.databaseNames();
	
	//Get the model database
	ModelDatabase modelDB = getEngine().getModelDatabase();
	
	//Loop over all databases
	for(String[] databaseName : databaseNames){
	
		//Create the file path string
		String filePathString = "data_" + project_data.project_name() + "/" + databaseName[0] + "_" + project_data.project_name() + ".xlsx";
		
		//If file exists, load it into the database
		File f = new File(filePathString);
		if(f.exists() && !f.isDirectory()) { 			
			Database myFileDatabase = new Database(this, databaseName[1], filePathString);
			modelDB.importFromExternalDB(myFileDatabase.getConnection(), databaseName[1], databaseName[1], true, false);
			traceln("Database %s has been updated.", databaseName[1]);	
		} else { // if file does not exist, clear the database to make sure there are no wrong values in the simulation!
			executeStatement("DELETE FROM " + databaseName[1] + " c");
			traceln("File not found, database %s has been cleared!", databaseName[1]);
		}
	}

	//Overwrite specific database values
	f_overwriteSpecificDatabaseValues();
} 
  }

  /**
   * Function used to generate solar parks: grid connections and park owner (connection owner actor)
   */
  protected void f_createSolarParks(  ) { 

GCEnergyProduction solarpark;

List<String> existing_actors = new ArrayList();
List<String> existing_solarFields = new ArrayList();

for (Solarfarm_data dataSolarfarm : f_getSolarfarmsInSubScope(c_solarfarm_data)) {
	if (!existing_solarFields.contains( dataSolarfarm.gc_id() )) {
		solarpark = energyModel.add_EnergyProductionSites();
		
		solarpark.set_p_gridConnectionID( dataSolarfarm.gc_id() );
		//Set Address
		solarpark.p_address = new J_Address(dataSolarfarm.streetname(), 
											dataSolarfarm.house_number(), 
											dataSolarfarm.house_letter(), 
											dataSolarfarm.house_addition(), 
											dataSolarfarm.postalcode(), 
											dataSolarfarm.city());
    	

		//Check wether it can be changed using sliders
		solarpark.p_isSliderGC = dataSolarfarm.isSliderGC();
		
		//Grid Capacity
		double physicalCapacity_kW = dataSolarfarm.connection_capacity_kw();
		double contractedFeedinCapacity_kW = dataSolarfarm.contracted_feed_in_capacity_kw() != null ? dataSolarfarm.contracted_feed_in_capacity_kw() : physicalCapacity_kW; 
		double contractedDeliveryCapacity_kW = dataSolarfarm.contracted_delivery_capacity_kw() != null ? dataSolarfarm.contracted_delivery_capacity_kw() : 0; 
		solarpark.v_liveConnectionMetaData.setCapacities_kW(contractedDeliveryCapacity_kW, contractedFeedinCapacity_kW, physicalCapacity_kW);
		
		boolean physicalCapacityKnown = physicalCapacity_kW > 0;
		boolean contractedFeedinCapacityKnown = dataSolarfarm.contracted_feed_in_capacity_kw() != null;
		boolean contractedDeliveryCapacityKnown = dataSolarfarm.contracted_delivery_capacity_kw() != null;
		solarpark.v_liveConnectionMetaData.setCapacitiesKnown(contractedDeliveryCapacityKnown, contractedFeedinCapacityKnown, physicalCapacityKnown);		
		
		
		
		//solarpark.set_p_heatingType( OL_GridConnectionHeatingType.NONE );	
		solarpark.set_p_ownerID( dataSolarfarm.owner_id() );	
		solarpark.set_p_parentNodeElectricID( dataSolarfarm.gridnode_id() );
		
		solarpark.v_isActive = dataSolarfarm.initially_active() ;
		
		//Add EA
		//Get GridNode to know if it has a GridNode profile
		OL_GridNodeProfileLoaderType gridNodeProfileLoaderType = OL_GridNodeProfileLoaderType.NO_PROFILE;
		if (solarpark.p_parentNodeElectricID != null){
			GridNode gn = findFirst(energyModel.pop_gridNodes, GN -> GN.p_gridNodeID.equals(dataSolarfarm.gridnode_id()));
			if (gn != null) {
				gridNodeProfileLoaderType = gn.p_profileType;
			} 
		}
		if(gridNodeProfileLoaderType != OL_GridNodeProfileLoaderType.INCLUDE_PV || gridNodeProfileLoaderType != OL_GridNodeProfileLoaderType.NET_LOAD){
			OL_PVOrientation pvOrientation = dataSolarfarm.orientation() != null ? dataSolarfarm.orientation() : avgc_data.p_defaultPVOrientation;
			f_addPVProductionAsset(solarpark, "Solar farm" , dataSolarfarm.capacity_electric_kw(), pvOrientation);
		}
		
		//Set owner
		ConnectionOwner owner;
		if (!existing_actors.contains(solarpark.p_ownerID)){ // check if owner exists already, if not, create new owner.
			owner = energyModel.add_pop_connectionOwners();
			
			owner.set_p_actorID( dataSolarfarm.owner_id());
			owner.set_p_connectionOwnerType( OL_ConnectionOwnerType.SOLARFARM_OP );
			owner.b_dataSharingAgreed = true;
			existing_actors.add(owner.p_actorID);
		}
		else { // Owner exists already: add new GC to existing owner
			owner = findFirst(energyModel.f_getConnectionOwners(), p -> p.p_actorID.equals(dataSolarfarm.owner_id()));
		}
		
		solarpark.set_p_owner( owner );
		
		existing_solarFields.add(solarpark.p_gridConnectionID);		
	}
	else { // solarpark and its owner exist already, only create new gis building which is added to the park
		solarpark = findFirst(energyModel.EnergyProductionSites, p -> p.p_gridConnectionID.equals(dataSolarfarm.gc_id()) );
	}
	
	if (dataSolarfarm.polygon() != null) {
		//Create GIS object for the solar park
		GIS_Object area = f_createGISObject( dataSolarfarm.gc_name(), dataSolarfarm.latitude(), dataSolarfarm.longitude(), dataSolarfarm.polygon(), OL_GISObjectType.SOLARFARM);
		
		//Add to collections
		area.c_containedGridConnections.add(solarpark);
		solarpark.c_connectedGISObjects.add(area);
		
		//Style building
		area.set_p_defaultFillColor( zero_Interface.v_solarParkColor );
		area.set_p_defaultLineColor( zero_Interface.v_solarParkLineColor );
		area.set_p_defaultLineWidth( zero_Interface.v_energyAssetLineWidth);
		zero_Interface.f_styleAreas(area);
	}
}
 
  }

  /**
   * Function used to create (neighborhood) battery grid connection and actor
   */
  protected void f_createBatteries(  ) { 

GCGridBattery gridbattery;

List<String> existing_actors = new ArrayList();
List<String> existing_gridbatteries = new ArrayList();

for (Battery_data dataBattery : f_getBatteriesInSubScope(c_battery_data)) {
	if (!existing_gridbatteries.contains(dataBattery.gc_id())) { // Check if batteryGC exists already, if not, create new batter GC + EA
		
		//Add gridbattery gc
		gridbattery = energyModel.add_GridBatteries();
		
		//GC parameters
		gridbattery.set_p_gridConnectionID( dataBattery.gc_id () );
		gridbattery.set_p_ownerID( dataBattery.owner_id() );
		
		//Set Address
		gridbattery.p_address = new J_Address(dataBattery.streetname(), 
										      dataBattery.house_number(), 
										      dataBattery.house_letter(), 
										      dataBattery.house_addition(), 
										      dataBattery.postalcode(), 
										      dataBattery.city());
										     
		//Check wether it can be changed using sliders
		gridbattery.p_isSliderGC = dataBattery.isSliderGC();
		
		//Grid Capacity
		double physicalCapacity_kW = dataBattery.connection_capacity_kw();
		double contractedFeedinCapacity_kW = dataBattery.contracted_feed_in_capacity_kw() != null ? dataBattery.contracted_feed_in_capacity_kw() : physicalCapacity_kW; 
		double contractedDeliveryCapacity_kW = dataBattery.contracted_delivery_capacity_kw() != null ? dataBattery.contracted_delivery_capacity_kw() : 0; 
		gridbattery.v_liveConnectionMetaData.setCapacities_kW(contractedDeliveryCapacity_kW, contractedFeedinCapacity_kW, physicalCapacity_kW);
		
		boolean physicalCapacityKnown = physicalCapacity_kW > 0;
		boolean contractedFeedinCapacityKnown = dataBattery.contracted_feed_in_capacity_kw() != null;
		boolean contractedDeliveryCapacityKnown = dataBattery.contracted_delivery_capacity_kw() != null;
		gridbattery.v_liveConnectionMetaData.setCapacitiesKnown(contractedDeliveryCapacityKnown, contractedFeedinCapacityKnown, physicalCapacityKnown);		
		
		
		//Set parent node electric
		gridbattery.set_p_parentNodeElectricID( dataBattery.gridnode_id() );
	
		//Get default (initial) operation mode management class
		I_BatteryManagement batteryAlgorithm;
		switch (dataBattery.operation_mode()) {
			case PRICE:
				batteryAlgorithm = new J_BatteryManagementPrice(gridbattery, energyModel.p_timeParameters);
				break;
			case PEAK_SHAVING_PARENT_NODE:
				batteryAlgorithm = new J_BatteryManagementPeakShaving(gridbattery, energyModel.p_timeParameters);
				GridNode gn = findFirst(energyModel.pop_gridNodes, x -> x.p_gridNodeID.equals(dataBattery.gridnode_id()));
				if (gn == null) {
					throw new RuntimeException("Could not find GridNode with ID: " + gridbattery.p_parentNodeElectricID + " for GCGridBattery");
				}
				((J_BatteryManagementPeakShaving)batteryAlgorithm).setTarget(gn);
				break;
			case SELF_CONSUMPTION_PARENT_NODE:
				batteryAlgorithm = new J_BatteryManagementSelfConsumptionGridNode(gridbattery, energyModel.p_timeParameters);
				break;
			case PEAK_SHAVING_COOP:
				// target agent is still null, should be set at the moment of coop creation
				batteryAlgorithm = new J_BatteryManagementPeakShaving(gridbattery, energyModel.p_timeParameters);
				((J_BatteryManagementPeakShaving)batteryAlgorithm).setTargetType( OL_ResultScope.ENERGYCOOP );
				break;
			default:
				throw new RuntimeException("Battery Operation Mode: " + dataBattery.operation_mode() + " is not supported for GCGridBattery.");
		}
		
		//Set management
		gridbattery.f_setBatteryManagement(batteryAlgorithm);
		
		//Get initial state
		gridbattery.v_isActive = dataBattery.initially_active();
		
		//Create energy asset for the battery
		f_addStorage(gridbattery, dataBattery.capacity_electric_kw(), dataBattery.storage_capacity_kwh(), OL_EnergyAssetType.STORAGE_ELECTRIC );	
		
		
		//Set owner
		ConnectionOwner owner;
		if (!existing_actors.contains(gridbattery.p_ownerID)){ // check if owner exists already, if not, create new owner.
			owner = energyModel.add_pop_connectionOwners();
			owner.set_p_actorID( gridbattery.p_ownerID );
			owner.set_p_connectionOwnerType( OL_ConnectionOwnerType.BATTERY_OP );
			owner.b_dataSharingAgreed = true;
			existing_actors.add(gridbattery.p_ownerID);
		}
		else { // Owner exists already: add new GC to existing owner
			owner = findFirst(energyModel.f_getConnectionOwners(), p -> p.p_actorID.equals(dataBattery.owner_id()));
		}
		
		gridbattery.set_p_owner( owner );
		
		existing_gridbatteries.add(gridbattery.p_gridConnectionID);
		
	}
	else{
		gridbattery = findFirst(energyModel.GridBatteries, p -> p.p_gridConnectionID.equals(dataBattery.gc_id()) );
	}
	
	if (dataBattery.polygon() != null) {
		//Create gis object for the battery
		GIS_Object area =  f_createGISObject( dataBattery.gc_name(), dataBattery.latitude(), dataBattery.longitude(), dataBattery.polygon(), OL_GISObjectType.BATTERY);

		//Add to collections
		gridbattery.c_connectedGISObjects.add(area);
		area.c_containedGridConnections.add(gridbattery);
			
		//Style building
		area.set_p_defaultFillColor( zero_Interface.v_batteryColor );
		area.set_p_defaultLineColor( zero_Interface.v_batteryLineColor );
		area.set_p_defaultLineWidth( zero_Interface.v_energyAssetLineWidth);
		zero_Interface.f_styleAreas(area);
	}

} 
  }

  /**
   * Function used to create electrolyser grid connections and actors
   */
  protected void f_createElectrolysers(  ) { 

List<String> existing_actors = new ArrayList();

for (Electrolyser_data dataElectrolyser : f_getElectrolysersInSubScope(c_electrolyser_data)) {
	GCEnergyConversion H2Electrolyser = energyModel.add_EnergyConversionSites();

	H2Electrolyser.p_gridConnectionID = dataElectrolyser.gc_id();
	H2Electrolyser.p_ownerID = dataElectrolyser.owner_id();	
	H2Electrolyser.p_parentNodeElectricID = dataElectrolyser.gridnode_id();
	
	//Set Address
	H2Electrolyser.p_address = new J_Address(dataElectrolyser.streetname(), 
										     dataElectrolyser.house_number(), 
										     dataElectrolyser.house_letter(), 
										     dataElectrolyser.house_addition(), 
										     dataElectrolyser.postalcode(), 
										     dataElectrolyser.city());

	//Grid Capacity
	double physicalCapacity_kW = dataElectrolyser.connection_capacity_kw();
	double contractedFeedinCapacity_kW = dataElectrolyser.contracted_feed_in_capacity_kw() != null ? dataElectrolyser.contracted_feed_in_capacity_kw() : physicalCapacity_kW; 
	double contractedDeliveryCapacity_kW = dataElectrolyser.contracted_delivery_capacity_kw() != null ? dataElectrolyser.contracted_delivery_capacity_kw() : 0; 
	H2Electrolyser.v_liveConnectionMetaData.setCapacities_kW(contractedDeliveryCapacity_kW, contractedFeedinCapacity_kW, physicalCapacity_kW);
	
	boolean physicalCapacityKnown = physicalCapacity_kW > 0;
	boolean contractedFeedinCapacityKnown = dataElectrolyser.contracted_feed_in_capacity_kw() != null;
	boolean contractedDeliveryCapacityKnown = dataElectrolyser.contracted_delivery_capacity_kw() != null;
	H2Electrolyser.v_liveConnectionMetaData.setCapacitiesKnown(contractedDeliveryCapacityKnown, contractedFeedinCapacityKnown, physicalCapacityKnown);		
	

	//Activation and electrolyser specifications
	H2Electrolyser.v_isActive = dataElectrolyser.initially_active();	

	//Electrolyser operation mode
	H2Electrolyser.f_setEnergyManagement(new J_EnergyManagementElectrolyser(H2Electrolyser, energyModel.p_timeParameters));
	I_ElectrolyserManagement electrolyserManagement;
	switch(dataElectrolyser.default_operation_mode()){
		case PRICE:
			double maxElectricityPriceForProfit_eurp_kWh = dataElectrolyser.conversion_efficiency()*energyModel.avgc_data.economicAVGC.getAvgCostOfEnergyCarrier_eurpkWh(OL_EnergyCarriers.HYDROGEN);
			electrolyserManagement = new J_ElectrolyserManagementPrice(H2Electrolyser, maxElectricityPriceForProfit_eurp_kWh, energyModel.p_timeParameters);
			break;
		case POWER_SURPLUS:
			GridNode targetGN = findFirst(energyModel.pop_gridNodes, gn -> gn.p_gridNodeID.equals(H2Electrolyser.p_parentNodeElectricID));
			electrolyserManagement = new J_ElectrolyserManagementPowerSurplus(H2Electrolyser, targetGN, energyModel.p_timeParameters);
			break;
		default:
			traceln("No or unsupported default operation mode found for GC Electrolyser. Default (Power surplus) is taken.");
			electrolyserManagement = new J_ElectrolyserManagementPowerSurplus(H2Electrolyser, energyModel.p_timeParameters);
	}
	H2Electrolyser.f_setExternalAssetManagement(electrolyserManagement);
	
	//Create EA for the electrolyser GC
	J_EAConversionElectrolyser h2ElectrolyserEA = new J_EAConversionElectrolyser(H2Electrolyser, dataElectrolyser.capacity_electric_kw(), dataElectrolyser.conversion_efficiency(), energyModel.p_timeParameters, OL_ElectrolyserState.STANDBY, dataElectrolyser.idle_consumption_power_ratio(), dataElectrolyser.min_production_ratio(), dataElectrolyser.load_change_time_h(), dataElectrolyser.start_up_time_shutdown_h(), dataElectrolyser.start_up_time_standby_h(), dataElectrolyser.start_up_time_idle_h());
	
	//Set owner
	ConnectionOwner owner;
	if (!existing_actors.contains(H2Electrolyser.p_ownerID)){ // check if owner exists already, if not, create new owner.
		owner = energyModel.add_pop_connectionOwners();
		
		owner.set_p_actorID( H2Electrolyser.p_ownerID );
		owner.set_p_connectionOwnerType( OL_ConnectionOwnerType.ELECTROLYSER_OP );
		owner.b_dataSharingAgreed = true;
		existing_actors.add(H2Electrolyser.p_ownerID);
	}
	else { // Owner exists already: add new GC to existing owner
		owner = findFirst(energyModel.f_getConnectionOwners(), p -> p.p_actorID.equals(dataElectrolyser.owner_id()));
	}
	
	H2Electrolyser.set_p_owner( owner );

	if (dataElectrolyser.polygon() != null) {			
		//Create GIS object for the electrolyser
		GIS_Object area = f_createGISObject( dataElectrolyser.gc_name(), dataElectrolyser.latitude(), dataElectrolyser.longitude(), dataElectrolyser.polygon(), OL_GISObjectType.ELECTROLYSER);

		//Add to collections
		area.c_containedGridConnections.add(H2Electrolyser);
		H2Electrolyser.c_connectedGISObjects.add(area);
	
		
		//Style building
		area.set_p_defaultFillColor( zero_Interface.v_electrolyserColor );
		area.set_p_defaultLineColor( zero_Interface.v_electrolyserLineColor );
		area.set_p_defaultLineWidth( zero_Interface.v_energyAssetLineWidth);
		zero_Interface.f_styleAreas(area);
	}
} 
  }

  /**
   * Function used to create all windfarm grid connections, actors, EAs and GISObjects
   */
  protected void f_createWindFarms(  ) { 

GCEnergyProduction windfarm;

List<String> existing_actors = new ArrayList();
List<String> existing_windFarms = new ArrayList();

for (Windfarm_data dataWindfarm : f_getWindfarmsInSubScope(c_windfarm_data)) {
	if (!existing_windFarms.contains(dataWindfarm.gc_id())) { // Check if windfarm exists already, if not, create new windfarm GC + turbine
		windfarm = energyModel.add_EnergyProductionSites();

		windfarm.set_p_gridConnectionID( dataWindfarm.gc_id() );
		
		//Set Address
		windfarm.p_address = new J_Address(dataWindfarm.streetname(), 
										   dataWindfarm.house_number(), 
										   dataWindfarm.house_letter(), 
										   dataWindfarm.house_addition(), 
										   dataWindfarm.postalcode(), 
										   dataWindfarm.city());

		//Check wether it can be changed using sliders
		windfarm.p_isSliderGC = dataWindfarm.isSliderGC();
	
		//Grid capacity
		double physicalCapacity_kW = dataWindfarm.connection_capacity_kw();
		double contractedFeedinCapacity_kW = dataWindfarm.contracted_feed_in_capacity_kw() != null ? dataWindfarm.contracted_feed_in_capacity_kw() : physicalCapacity_kW; 
		double contractedDeliveryCapacity_kW = dataWindfarm.contracted_delivery_capacity_kw() != null ? dataWindfarm.contracted_delivery_capacity_kw() : 0; 
		windfarm.v_liveConnectionMetaData.setCapacities_kW(contractedDeliveryCapacity_kW, contractedFeedinCapacity_kW, physicalCapacity_kW);
		
		boolean physicalCapacityKnown = physicalCapacity_kW > 0;
		boolean contractedFeedinCapacityKnown = dataWindfarm.contracted_feed_in_capacity_kw() != null;
		boolean contractedDeliveryCapacityKnown = dataWindfarm.contracted_delivery_capacity_kw() != null;
		windfarm.v_liveConnectionMetaData.setCapacitiesKnown(contractedDeliveryCapacityKnown, contractedFeedinCapacityKnown, physicalCapacityKnown);		
		
		
		//Connections
		windfarm.p_ownerID = dataWindfarm.owner_id();	
		windfarm.p_parentNodeElectricID = dataWindfarm.gridnode_id();
		
		//Get initial state
		windfarm.v_isActive = dataWindfarm.initially_active();
		
		//Create EA for the windturbine GC
		f_addWindProductionAsset(windfarm, "Windmill onshore", dataWindfarm.capacity_electric_kw());
		//f_addEnergyProduction(windfarm, OL_EnergyAssetType.WINDMILL, "Windmill onshore", dataWindfarm.capacity_electric_kw());
		
		//Set owner
		ConnectionOwner owner;
		if (!existing_actors.contains(windfarm.p_ownerID)){ // check if owner exists already, if not, create new owner.
			owner = energyModel.add_pop_connectionOwners();
			
			owner.set_p_actorID( windfarm.p_ownerID );
			owner.set_p_connectionOwnerType( OL_ConnectionOwnerType.WINDFARM_OP );
			owner.b_dataSharingAgreed = true;
			existing_actors.add(windfarm.p_ownerID);
		}
		else { // Owner exists already: add new GC to existing owner
			owner = findFirst(energyModel.f_getConnectionOwners(), p -> p.p_actorID.equals(dataWindfarm.owner_id()));
		}
		
		windfarm.set_p_owner( owner );
		
		existing_windFarms.add(windfarm.p_gridConnectionID);	
	}
	else { // winfarm and its owner exist already, only create new gis building which is added to the farm
		windfarm = findFirst(energyModel.EnergyProductionSites, p -> p.p_gridConnectionID.equals(dataWindfarm.gc_id()) );		
	}
	
	//Create GIS object for the windfarm
	if (dataWindfarm.polygon() != null) {
		GIS_Object area = f_createGISObject( dataWindfarm.gc_name(), dataWindfarm.latitude(), dataWindfarm.longitude(), dataWindfarm.polygon(), OL_GISObjectType.WINDFARM );
		
		//Add to collections
		area.c_containedGridConnections.add(windfarm);
		windfarm.c_connectedGISObjects.add(area);
		
		//Style building
		area.set_p_defaultFillColor( zero_Interface.v_windFarmColor );
		area.set_p_defaultLineColor( zero_Interface.v_windFarmLineColor );
		area.set_p_defaultLineWidth( zero_Interface.v_energyAssetLineWidth);
		zero_Interface.f_styleAreas(area);
	}
} 
  }

  protected 
double[] 
 f_createGISNodesTokens( GridNode GN ) { 

double scaling_factor_LVLV = zero_Interface.v_LVLVNodeSize;
double scaling_factor_MVLV = zero_Interface.v_MVLVNodeSize;
double scaling_factor_MVMV = zero_Interface.v_MVMVNodeSize;
double scaling_factor_HVMV = zero_Interface.v_HVMVNodeSize;

int nb_GISCoords;
String node_shape = "TRIANGLE";
double scaling_factor_gridnode = 0;

switch( GN.p_nodeType ) {
		case LVLV:
		nb_GISCoords = 6;
		node_shape = "TRIANGLE";
		scaling_factor_gridnode = scaling_factor_LVLV;		
		break;
		case MVLV:
		nb_GISCoords = 6;
		node_shape = "TRIANGLE";
		scaling_factor_gridnode = scaling_factor_MVLV;
		break;
		case SUBMV:
		nb_GISCoords = 6;
		node_shape = "TRIANGLE";
		scaling_factor_gridnode = scaling_factor_MVLV;	
		break;
		case MVMV:
		nb_GISCoords = 6;
		node_shape = "TRIANGLE";
		scaling_factor_gridnode = scaling_factor_MVMV;	
		break;
		case HVMV:
		nb_GISCoords = 6;
		node_shape = "TRIANGLE";
		scaling_factor_gridnode = scaling_factor_HVMV;	
		break;
		case HT:
		nb_GISCoords = 6;	
		break;
		case MT:
		nb_GISCoords = 6;	
		break;
		case LT:
		nb_GISCoords = 6;	
		break;
		case LT5thgen:
		nb_GISCoords = 6;	
		break;
		default:
		nb_GISCoords = 6;
}

double[] GISCoords = new double[nb_GISCoords];


switch(node_shape){

	case "TRIANGLE":
		//latitudes
		GISCoords[0]=GN.p_latitude;
		GISCoords[2]=GN.p_latitude - scaling_factor_gridnode*0.00001;
		GISCoords[4]=GN.p_latitude - scaling_factor_gridnode*0.00001;
		
		//longitudes
		GISCoords[1]=GN.p_longitude;
		GISCoords[3]=GN.p_longitude + scaling_factor_gridnode*0.00001;
		GISCoords[5]=GN.p_longitude - scaling_factor_gridnode*0.00001;
		break;
	case "DIAMOND":
		//latitudes
		GISCoords[0]=GN.p_latitude;
		GISCoords[2]=GN.p_latitude - scaling_factor_gridnode*0.00001;
		GISCoords[4]=GN.p_latitude;
		GISCoords[6]=GN.p_latitude + scaling_factor_gridnode*0.00001;
		
		//longitudes
		GISCoords[1]=GN.p_longitude;
		GISCoords[3]=GN.p_longitude + scaling_factor_gridnode*0.00001;
		GISCoords[5]=GN.p_longitude + scaling_factor_gridnode*0.00001*2;
		GISCoords[7]=GN.p_longitude + scaling_factor_gridnode*0.00001;
		break;
	/*
	case "CIRCLE":
			// if you want Circle coordinates -->
		//x = r * cos(t) + a
		//y = r * sin(t) + b
		//t is an angle between 0 and 2π (more steps is more circle points, about 10-12 should suffice. --> adjust nb_GISCoords accordingly
		// r is the radius: 0.000009 degrees in latitude is about 1 meter 
		// a and b are latitude and longitude
		break;
	*/
}

return GISCoords;





 
  }

  /**
   * Function used to generate specific actors like grid operator, energy supplier and energy coop. Actors used to create variable pricing.
   */
  protected void f_createEnergyActors(  ) { 

// Create the grid operator
GridOperator GO = energyModel.add_pop_gridOperators();

GO.p_actorID = project_data.grid_operator().toString();
GO.p_hasCongestionPricing = project_data.hasCongestionPricing() != null ? project_data.hasCongestionPricing() : false;


// Create the energy coop
if (project_data.energy_coop() != null && !project_data.energy_coop().equals("None")){
	
	EnergyCoop EC = energyModel.add_pop_energyCoops();
	
	EC.p_actorID = project_data.energy_coop();
	EC.p_gridOperator = GO;
	//EC.p_CoopParent = EC.p_actorID; // WAT BETEKENT COOP PARENT??
}


// Energy supplier
if (project_data.energy_supplier() != null && !project_data.energy_supplier().equals("None")){
	
	EnergySupplier ES = energyModel.add_pop_energySuppliers(); 
	
	ES.p_actorID = project_data.energy_supplier();
}

 
  }

  /**
   * Creating the companies (using a single GC) + owned buildings, that have not filled in the survey. If created, they will be simulated using average values, scaled with the totals (CBS data) of the area.
   */
  protected void f_createGenericCompanies(  ) { 

//Initialize variables
List<GCUtility> generic_company_GCs = new ArrayList();

//Get buildings in scope
List<Building_data> buildingDataGenericCompanies = f_getBuildingsInSubScope(c_companyBuilding_data);

//Add generic companies to the legend if in model
if(buildingDataGenericCompanies.size()>0){
	zero_Interface.c_modelActiveDefaultGISBuildings.add(OL_GISBuildingTypes.DEFAULT_COMPANY);
}

//Loop over the remaining buildings in c_CompanyBuilding_data (Survey buildings have been removed from this collection)
for (Building_data genericCompany : buildingDataGenericCompanies) {
	
	GCUtility companyGC = findFirst(generic_company_GCs, GC -> GC.p_gridConnectionID.equals(genericCompany.address_id()));
	
	if(companyGC == null){
		//Create new companyGC
		companyGC = energyModel.add_UtilityConnections();

		//Update counter and collections
		generic_company_GCs.add(companyGC);
		
		//Set parameters for the Grid Connection
		companyGC.p_gridConnectionID = genericCompany.address_id();		
		
		
		//Energylabel and InsulationLabel
		companyGC.p_energyLabel = genericCompany.energy_label() != null ? genericCompany.energy_label() : OL_GridConnectionEnergyLabel.UNKNOWN;
		companyGC.p_insulationLabel = genericCompany.insulation_label() != null ? genericCompany.insulation_label() : OL_GridConnectionInsulationLabel.UNKNOWN;
	
		
		// Check that is needed until connectioncapacity is no longer in 'Panden' excel
		if (genericCompany.contracted_capacity_kw() == null || genericCompany.contracted_capacity_kw() < 0) {
			companyGC.v_liveConnectionMetaData.setCapacities_kW(avgc_data.p_avgUtilityConnectionCapacity_kW, avgc_data.p_avgUtilityConnectionCapacity_kW, avgc_data.p_avgUtilityConnectionCapacity_kW);
			companyGC.v_liveConnectionMetaData.setCapacitiesKnown(false, false, false);
		}
		else{
			companyGC.v_liveConnectionMetaData.setCapacities_kW(genericCompany.contracted_capacity_kw(), genericCompany.contracted_capacity_kw(), genericCompany.contracted_capacity_kw());
			companyGC.v_liveConnectionMetaData.setCapacitiesKnown(true, false, false);
		}

		//set GC Address
		companyGC.p_address = new J_Address(genericCompany.streetname(), 
										    genericCompany.house_number(), 
										    genericCompany.house_letter(), 
										    genericCompany.house_addition(), 
										    genericCompany.postalcode(), 
										    genericCompany.city());
		
		
		//Set location of GC
	 	companyGC.p_latitude = genericCompany.latitude(); 
	 	companyGC.p_longitude = genericCompany.longitude();
	 	companyGC.setLatLon(companyGC.p_latitude, companyGC.p_longitude);  
	 	
	 	//Set PV information
		companyGC.v_liveAssetsMetaData.initialPV_kW = genericCompany.pv_installed_kwp() != null ? genericCompany.pv_installed_kwp() : 0;
		companyGC.v_liveAssetsMetaData.PVPotential_kW = genericCompany.pv_potential_kwp(); // if null: pv potential will be determined by sliders!
	 	companyGC.v_liveAssetsMetaData.PVOrientation = genericCompany.pv_orientation() != null ? genericCompany.pv_orientation() : avgc_data.p_defaultPVOrientation;
	 	
	 	//Update remaining totals (AFTER Lat/Lon has been defined!)
		p_remainingTotals.adjustTotalNumberOfAnonymousCompanies(companyGC, 1);
		p_remainingTotals.adjustTotalFloorSurfaceAnonymousCompanies_m2(companyGC, genericCompany.address_floor_surface_m2());
		
		//Connect GC to grid node
		companyGC.p_parentNodeElectricID = genericCompany.gridnode_id ();
		
		// Create new actor and assign GC to that
		ConnectionOwner COC = energyModel.add_pop_connectionOwners(); // Create Connection owner company
			
		COC.p_actorID = genericCompany.address_id();
		COC.p_connectionOwnerType = OL_ConnectionOwnerType.COMPANY;
		COC.p_detailedCompany = false;
		COC.b_dataSharingAgreed = true;
		
		companyGC.p_owner = COC;
		companyGC.p_ownerID = COC.p_actorID;
	}
	
	//Check wheter this building already exists
	GIS_Building existingBuilding = findFirst(energyModel.pop_GIS_Buildings, gisBuilding -> gisBuilding.p_id.equals(genericCompany.building_id()));
	
	if(existingBuilding == null){//Create new GIS building and connect
		GIS_Building b = f_createGISBuilding( genericCompany, companyGC );

		companyGC.p_roofSurfaceArea_m2 += b.p_roofSurfaceArea_m2;
			
		//Style building
		b.p_defaultFillColor = zero_Interface.v_companyBuildingColor;
		b.p_defaultLineColor = zero_Interface.v_companyBuildingLineColor;
		zero_Interface.f_styleAreas(b);
	}
	else{// Connect with existing building
		f_connectGCToExistingBuilding(companyGC, existingBuilding, genericCompany);
	}
	
	companyGC.p_floorSurfaceArea_m2 += genericCompany.address_floor_surface_m2();
}

//Finalize the remaining totals distribution
p_remainingTotals.finalizeRemainingTotalsDistributionCompanies();

//Add EA to all generic companies (Has to be after the remaining totals finalization, so cant happen at the same time as the creation of the GC and their buildings)
for (GridConnection GCcompany : generic_company_GCs ) {
	f_iEAGenericCompanies(GCcompany);
} 
  }

  /**
   * Creates the GIS object(s) building(s) for the companies and houses
   */
  protected 
GIS_Building 
 f_createGISBuilding( Building_data buildingData, GridConnection parentGC ) { 

GIS_Building b = energyModel.add_pop_GIS_Buildings();

b.p_id = buildingData.building_id();
b.p_GISObjectType = OL_GISObjectType.BUILDING;
b.p_buildingYear = buildingData.build_year();	
b.p_status = buildingData.status();
b.p_useType = buildingData.purpose();	

// Adres data
b.p_annotation = buildingData.annotation();

//Create gisregion
b.gisRegion = zero_Interface.f_createGISObject(f_createGISObjectTokens(buildingData.polygon(), b.p_GISObjectType));

//Use the first point of the polygon as lat lon
double[] gisregion_points = b.gisRegion.getPoints(); // get all points of the gisArea of the building in the format lat1,lon1,lat2,lon2, etc.

//position and coordinates
b.p_latitude = gisregion_points[0];
b.p_longitude = gisregion_points[1];

//Set latlon
b.setLatLon(b.p_latitude, b.p_longitude);


//Define roof surface area (with Null checks and gisregion area as back up)
b.p_roofSurfaceArea_m2 = buildingData.polygon_area_m2() != null ? buildingData.polygon_area_m2() : b.gisRegion.area();

//Define floor surface area (with Null check, and make it 0 if unkown, else counting errors due to order of loadin of building data)
b.p_floorSurfaceArea_m2 = buildingData.address_floor_surface_m2() != null ? buildingData.address_floor_surface_m2() : 0;

//Add to collections
b.c_containedGridConnections.add(parentGC);
parentGC.c_connectedGISObjects.add(b);


return b; 
  }

  public void f_addElectricityDemandProfile( GridConnection parentGC, double yearlyElectricityDemand_kWh, Double pvPower_kW, boolean hasQuarterlyData, String profileName ) { 

if ( hasQuarterlyData == true ) { // Add quarterly electricity data pattern if available 
	
	//Initialize the arrays
	List<Double> yearlyElectricityFeedin_kWh_list = null; 
	List<Double> yearlyElectricityProduction_kWh_list = null;
	
	//Check for PV, and if so: check for additional quarterhourly values
	if(pvPower_kW != null && pvPower_kW > 0){
		//Check for feedin values availability, if available: fill the list, if not, list = null;
		try {
			if(selectFirstValue(Double.class, "SELECT " + profileName + "_feedin FROM comp_elec_consumption LIMIT 1;") != null){
		  		yearlyElectricityFeedin_kWh_list = selectValues(double.class, "SELECT " + profileName + "_feedin FROM comp_elec_consumption;");			
			}
		}
		catch(Exception e) {
			//Do nothing, cause initialized with null;
		}
		
		//Check for bruto production values availability, if available: fill the list, if not, list = null;
		try {
			if(selectFirstValue(Double.class, "SELECT " + profileName + "_production FROM comp_elec_consumption LIMIT 1;") != null){
		  		yearlyElectricityProduction_kWh_list = selectValues(double.class, "SELECT " + profileName + "_production FROM comp_elec_consumption;");
			}
		}
		catch(Exception e) {
			//Do nothing, cause initialized with null;
		}
	}
	
	//Get the delivery values
	List<Double> yearlyElectricityDelivery_kWh_list = selectValues(double.class, "SELECT " + profileName + "_demand FROM comp_elec_consumption;");
	
	
	//Convert lists into arrays
	double[] yearlyElectricityDelivery_kWh_array = (yearlyElectricityDelivery_kWh_list != null) ? yearlyElectricityDelivery_kWh_list.stream().mapToDouble(d -> max(0,d)).toArray() : null;
	double[] yearlyElectricityFeedin_kWh_array = 	(yearlyElectricityFeedin_kWh_list != null) ? yearlyElectricityFeedin_kWh_list.stream().mapToDouble(d -> max(0,d)).toArray() : null;
	double[] yearlyElectricityProduction_kWh_array = (yearlyElectricityProduction_kWh_list != null) ? yearlyElectricityProduction_kWh_list.stream().mapToDouble(d -> max(0,d)).toArray() : null;
	

	//Preprocess and add the profiles
	f_createPreprocessedElectricityProfile_PV(parentGC, yearlyElectricityDelivery_kWh_array, yearlyElectricityFeedin_kWh_array, yearlyElectricityProduction_kWh_array, pvPower_kW, null);

} 

else { // Add regular electricity and consumption profiles
	J_ProfilePointer profilePointer = energyModel.f_findProfile(profileName);
	J_EAConsumption profile = new J_EAConsumption(parentGC, OL_EnergyAssetType.ELECTRICITY_DEMAND, profileName, yearlyElectricityDemand_kWh, OL_EnergyCarriers.ELECTRICITY, energyModel.p_timeParameters, profilePointer);
} 
  }

  /**
   * Creates "empty" parcels on the gismap, these parcels do not contain buildings or gridconnections. Currently no need for the function to return the GIS_Object.
   */
  protected void f_createGISParcels(  ) { 

//Add GISObject type to the legenda
if(c_parcel_data.size()>0){
	zero_Interface.c_modelActiveSpecialGISObjects.add(OL_GISObjectType.PARCEL);
}

for (Parcel_data dataParcel : c_parcel_data) {
		
	GIS_Parcel parcel = energyModel.add_pop_GIS_Parcels();
	
	parcel.set_p_latitude( dataParcel.latitude() );
	parcel.set_p_longitude( dataParcel.longitude() );
	parcel.setLatLon(parcel.p_latitude, parcel.p_longitude);	
	parcel.set_p_id( dataParcel.parcel_id() );
	parcel.set_p_GISObjectType(OL_GISObjectType.PARCEL);
	
	//Building + styling the gisregion and putting it on the map
	GISRegion gisregion = zero_Interface.f_createGISObject(f_createGISObjectTokens( dataParcel.polygon(), parcel.p_GISObjectType));
	parcel.gisRegion = gisregion;
	
	parcel.set_p_defaultFillColor( zero_Interface.v_parcelColor );
	parcel.set_p_defaultLineColor( zero_Interface.v_parcelLineColor );
	parcel.set_p_defaultLineStyle( LineStyle.LINE_STYLE_DASHED );
	zero_Interface.f_styleAreas(parcel);
} 
  }

  /**
   * Creates the GIS object for the area EA (windfarms, solarparks, electrolysers, batteries, etc.)
   */
  protected 
GIS_Object 
 f_createGISObject( String name, double latitude, double longitude, String polygon, OL_GISObjectType GISObjectType ) { 

GIS_Object area = energyModel.add_pop_GIS_Objects();

area.p_id = name;
area.p_annotation = area.p_id;
area.p_GISObjectType = GISObjectType;

//position and coordinates
area.p_latitude = latitude;
area.p_longitude = longitude;
area.setLatLon(area.p_latitude, area.p_longitude);		

//Create gisregion
area.gisRegion = zero_Interface.f_createGISObject(f_createGISObjectTokens(polygon, area.p_GISObjectType));

//Add GISObject type to the legenda
zero_Interface.c_modelActiveSpecialGISObjects.add(area.p_GISObjectType);

return area;
 
  }

  protected void f_createSurveyCompanies_Zorm(  ) { 

//Start survey company GC counter
v_numberOfSurveyCompanyGC = 0;

//Get the survey data
List<com.zenmo.zummon.companysurvey.Survey> surveys = f_getSurveys();
traceln("Size of survey List: %s", surveys.size());

//Get the building data
try{
	map_buildingData_Vallum = com.zenmo.vallum.PandKt.fetchBagPanden(surveys);
}
catch (Exception e){ //if api of bag is down, leave bag buildings empty and display error message
	zero_Interface.f_setErrorScreen("BAG API is offline, het is mogelijk dat bepaalde panden niet zijn ingeladen!", 0, 0);
}


traceln("Companies that filled in the survey:");
for (var survey : surveys) {
	
	traceln(survey.getCompanyName());
	
	//Create connection owner
	ConnectionOwner survey_owner = energyModel.add_pop_connectionOwners();
	survey_owner.p_actorID = survey.getCompanyName();
	survey_owner.p_connectionOwnerType = OL_ConnectionOwnerType.COMPANY;
	survey_owner.p_detailedCompany = true;
	survey_owner.b_dataSharingAgreed = survey.getDataSharingAgreed();
	survey_owner.b_dataIsAccessible = f_getAccessOfSurveyGC(survey.getDataSharingAgreed(), survey.getId());
	
	for (var address : survey.getAddresses()) {
        for (var gridConnection: address.getGridConnections()) {

		 	//Check if it has (or will have) a direct connection with the grid (either gas or electric), if not: skip this gc.
		 	boolean hasNaturalGasConnection = (gridConnection.getNaturalGas().getHasConnection() != null)? gridConnection.getNaturalGas().getHasConnection() : false;	 	
		 	boolean hasExpansionRequest = (gridConnection.getElectricity().getGridExpansion().getHasRequestAtGridOperator() != null ) ? gridConnection.getElectricity().getGridExpansion().getHasRequestAtGridOperator() : false;
		 	
		 	if (!gridConnection.getElectricity().getHasConnection() && !hasExpansionRequest && !hasNaturalGasConnection){
				traceln("surveyGC with sequence: " + gridConnection.getSequence() + " is not created, as it has no connection to the grid, future grid connection or current gas connection.");	
			 	continue;
		 	}
		 	
		 	//Create GC
		 	GCUtility companyGC = energyModel.add_UtilityConnections();		  
		 	
		 	//Update number of survey companies (Connections)
			v_numberOfSurveyCompanyGC++;
		
			//Set parameters for the Grid Connection
			companyGC.p_ownerID = survey.getCompanyName();
		 	companyGC.p_gridConnectionID = gridConnection.getSequence().toString() ;

		 	//Find actor and connect GC 
			companyGC.p_owner = survey_owner;	
			
			//Adress data
			companyGC.p_address = new J_Address(address.getStreet(), 
								    address.getHouseNumber(), 
								    address.getHouseLetter(), 
								    address.getHouseNumberSuffix(), 
								    address.getPostalCode(), 
								    address.getCity());

			//Get attached building info
			List<Building_data> buildings = f_getSurveyGCBuildingData(companyGC, gridConnection);
			
			//Total new additional floor/roof surface area
		 	double totalNewFloorSurfaceAreaGC_m2 = 0;
		 	double totalNewRoofSurfaceAreaGC_m2 = 0;
			
			//Create the GIS buildings
			for (Building_data buildingData : buildings) {
				GIS_Building gisBuilding = findFirst(energyModel.pop_GIS_Buildings, b -> b.p_id.equals(buildingData.building_id())); // Check if building already exists in engine
				if (gisBuilding != null) {
				    // Connect GC to existing building in engine
				    f_connectGCToExistingBuilding(companyGC, gisBuilding, buildingData);
				}
				else{ 
					gisBuilding = f_createGISBuilding( buildingData, companyGC);				
				}
				
				//Set name of building
				if(gisBuilding.p_annotation == null){
					gisBuilding.p_annotation = companyGC.p_ownerID;
				}
				
				//Accumulate surface areas
				totalNewFloorSurfaceAreaGC_m2 += buildingData.address_floor_surface_m2();
				totalNewRoofSurfaceAreaGC_m2 += gisBuilding.p_roofSurfaceArea_m2;
				
				//Set trafo ID
				companyGC.p_parentNodeElectricID = buildingData.gridnode_id();
				
				//Energylabel and InsulationLabel
				companyGC.p_energyLabel = J_PBLUtil.getWorstEnergyLabel(companyGC.p_energyLabel, buildingData.energy_label());
				companyGC.p_insulationLabel = J_PBLUtil.getWorstInsulationLabel(companyGC.p_insulationLabel, buildingData.insulation_label());
				
				//Style building
				gisBuilding.p_defaultFillColor = zero_Interface.v_detailedCompanyBuildingColor;
				gisBuilding.p_defaultLineColor = zero_Interface.v_detailedCompanyBuildingLineColor;
				zero_Interface.f_styleAreas(gisBuilding);
				
			}      
			
			//Add (combined) building data to GC (latitude and longitude + area)
			companyGC.p_floorSurfaceArea_m2 += totalNewFloorSurfaceAreaGC_m2;
			companyGC.p_roofSurfaceArea_m2 += totalNewRoofSurfaceAreaGC_m2;
			

			if(!companyGC.c_connectedGISObjects.isEmpty()){
				companyGC.p_longitude = companyGC.c_connectedGISObjects.get(0).p_longitude; // Get longitude of first building (only used to get nearest trafo)
				companyGC.p_latitude = companyGC.c_connectedGISObjects.get(0).p_latitude; // Get latitude of first building (only used to get nearest trafo)
				
				if(buildings.isEmpty()){ //GC will not have gotten a gridnode assigned,
					for (var PID : gridConnection.getPandIds() ) {
						Building_data surveyBuildingData = findFirst(c_surveyCompanyBuilding_data, b -> b.building_id().equals(PID.getValue()));
						if(surveyBuildingData != null){
							companyGC.p_parentNodeElectricID = surveyBuildingData.gridnode_id();
							break;
						}
					}
				}
				
				//In Subscope check
				if(companyGC.p_parentNodeElectricID != null && !c_gridNodeIDsInScope.contains(companyGC.p_parentNodeElectricID)){
					//--> Company not in subscope -> PAUSE AND REMOVE FROM ASSIGNED GRIDNODE
					companyGC.p_parentNodeElectricID = null;
					companyGC.v_isActive = false;
				}
			}
			else{
				traceln("Gridconnection %s with owner %s has no buildings!!!", companyGC.p_gridConnectionID, companyGC.p_ownerID);
			}
			
			//Set lat lon
			companyGC.setLatLon(companyGC.p_latitude, companyGC.p_longitude); 
			
			if(user.NBHAccessType != null && user.NBHAccessType != OL_UserNBHAccessType.FULL){
				if(!f_isLocatedInActiveNBH(companyGC.p_latitude, companyGC.p_longitude)){
					companyGC.p_parentNodeElectricID = null;
					companyGC.v_isActive = false;
					v_numberOfSurveyCompanyGC--;
				}
			}
			
			//Energy asset initialization
			f_iEASurveyCompanies_Zorm(companyGC, gridConnection); 
        }
    }
}

//If survey companies are present, add to the ui legend
if(v_numberOfSurveyCompanyGC>0){
	//Add to the legend
	zero_Interface.c_modelActiveDefaultGISBuildings.add(OL_GISBuildingTypes.DETAILED_COMPANY);

	//Pass the number of survey companies to interface for the dynamic legend
	zero_Interface.v_numberOfSurveyCompanyGC = v_numberOfSurveyCompanyGC;
} 
  }

  protected 
List<com.zenmo.zummon.companysurvey.Survey> 
 f_getSurveys(  ) { 

//Connect with API to database
Vallum vallum = new Vallum(user.PROJECT_CLIENT_ID(), user.PROJECT_CLIENT_SECRET());

List<com.zenmo.zummon.companysurvey.Survey> surveys = new ArrayList();


String[] zorm_project_names;

if(project_data.zorm_project_names() != null){
	zorm_project_names = project_data.zorm_project_names();
}
else{
	zorm_project_names = new String[]{project_data.project_name()};
}

v_projectDataLastChangedDate = vallum.getProjectLastModifiedAt(zorm_project_names[0]);
//traceln("Data last changed date: %s", v_projectDataLastChangedDate);
if(zorm_project_names.length>1) {
	for (int i = 1; i<zorm_project_names.length; i++) {
		if (vallum.getProjectLastModifiedAt(zorm_project_names[i]).isAfter(v_projectDataLastChangedDate)) {
			v_projectDataLastChangedDate = vallum.getProjectLastModifiedAt(zorm_project_names[i]);
		}
	//traceln("Data last changed date: %s", v_projectDataLastChangedDate);
	}	
}

surveys = vallum.getEnabledSurveysByProjectNames(zorm_project_names);


//Clear vallum user data
user.clearVallumUser();

return surveys; 
  }

  protected void f_createActors(  ) { 

//Create specific actors like Grid operator, energy supplier, energy coop
f_createEnergyActors(); 
  }

  /**
   * This function determines the heatingType (OL_GridConnectionHeatingType) from the list of heating types (zummon.companysurvey.HeatingType)
   */
  protected 
OL_GridConnectionHeatingType 
 f_getHeatingTypeSurvey( GridConnection engineGC, com.zenmo.zummon.companysurvey.GridConnection surveyGC ) { 

// This function determines a heatingType for the GC, which will be passed on to the function that determines the heating management
OL_GridConnectionHeatingType heatingType = null;

if (surveyGC.getHeat().getHeatingTypes().size() > 1) {
	// We currently only recognize a couple of combinations that we assume are meant as hybrid heatpumps
	if (surveyGC.getHeat().getHeatingTypes().size() == 2) {
		if (surveyGC.getHeat().getHeatingTypes().contains(HeatingType.GAS_BOILER)) {
			if (surveyGC.getHeat().getHeatingTypes().contains(HeatingType.HYBRID_HEATPUMP) || surveyGC.getHeat().getHeatingTypes().contains(HeatingType.ELECTRIC_HEATPUMP)) {
				heatingType = OL_GridConnectionHeatingType.HYBRID_HEATPUMP;
			}
		}
	}
}
else if (surveyGC.getHeat().getHeatingTypes().size() == 1) {
	// We translate the survey enum to the OL_GridConnectionHeatingType
	switch(surveyGC.getHeat().getHeatingTypes().get(0)) {
		case GAS_BOILER:
			heatingType = OL_GridConnectionHeatingType.GAS_BURNER;
			break;
		case HYBRID_HEATPUMP:
			heatingType = OL_GridConnectionHeatingType.HYBRID_HEATPUMP;
			break;
		case ELECTRIC_HEATPUMP:
			heatingType = OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP;
			break;
		case DISTRICT_HEATING:
			heatingType = OL_GridConnectionHeatingType.DISTRICTHEAT;
			break;
		case COMBINED_HEAT_AND_POWER:
			heatingType = OL_GridConnectionHeatingType.GAS_CHP;
			break;	
		case OTHER:
			heatingType = OL_GridConnectionHeatingType.CUSTOM;
			break;
		default:
			throw new RuntimeException("Incorrect heating: " + surveyGC.getHeat().getHeatingTypes().get(0) + " detected for '" + engineGC.p_ownerID + "'");
	}
}
else if (surveyGC.getHeat().getHeatingTypes().size() == 0) {
	// There is no heating type in the survey, but there is gas consumption (either yearly total or hourly values)
	if ( (surveyGC.getNaturalGas().getAnnualDelivery_m3() != null && surveyGC.getNaturalGas().getAnnualDelivery_m3() > 0)
	 || ( surveyGC.getNaturalGas().getHourlyDelivery_m3() != null && surveyGC.getNaturalGas().getHourlyDelivery_m3().hasNumberOfValuesForOneYear() ) ) {
		// We assume that all gas consumption is to heat the building(s)
		heatingType = OL_GridConnectionHeatingType.GAS_BURNER;
	}
	else {
		heatingType = OL_GridConnectionHeatingType.NONE;
	}
}
if (heatingType == null) {
	heatingType = OL_GridConnectionHeatingType.CUSTOM;
}

return heatingType; 
  }

  public 
J_EAEV 
 f_addElectricVehicle( GridConnection parentGC, OL_EnergyAssetType vehicle_type, boolean isDefaultVehicle, double annualTravelDistance_km, double maxChargingPower_kW ) { 

double storageCapacity_kWh 		= 0;
double energyConsumption_kWhpkm = 0;
double capacityElectricity_kW 	= 0;
double stateOfCharge_fr  		= 1; // Initial state of charge
J_TimeParameters timeParameters	= energyModel.p_timeParameters;
double vehicleScaling 			= 1.0;

switch(vehicle_type){
	
	/*
	case ELECTRIC_VEHICLE_COMUTERS: // ??? Hoe laad je andere laadprofielen in.?? Deze moet ander laadprofiel dan de Standaard Electric_vehicle 
		capacityElectricity_kW	= avgc_data.p_avgEVMaxChargePowerCar_kW;
		storageCapacity_kWh		= avgc_data.p_avgEVStorageCar_kWh;
		energyConsumption_kWhpkm = avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm;
	break;
	*/
	
	case ELECTRIC_VEHICLE:
		capacityElectricity_kW	= avgc_data.p_avgEVMaxChargePowerCar_kW;
		storageCapacity_kWh		= avgc_data.p_avgEVStorageCar_kWh;
		energyConsumption_kWhpkm = avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm;
	break;
	
	case ELECTRIC_VAN:
		capacityElectricity_kW 	= avgc_data.p_avgEVMaxChargePowerVan_kW;
		storageCapacity_kWh		= avgc_data.p_avgEVStorageVan_kWh;
		energyConsumption_kWhpkm = avgc_data.p_avgEVEnergyConsumptionVan_kWhpkm;
	break;
	
	case ELECTRIC_TRUCK:
		capacityElectricity_kW	= avgc_data.p_avgEVMaxChargePowerTruck_kW;
		storageCapacity_kWh		= avgc_data.p_avgEVStorageTruck_kWh;
		energyConsumption_kWhpkm = avgc_data.p_avgEVEnergyConsumptionTruck_kWhpkm;
	break;
	
}

if (!isDefaultVehicle && maxChargingPower_kW > 0){
	capacityElectricity_kW	= maxChargingPower_kW;
}
if (!isDefaultVehicle && maxChargingPower_kW <= 0) {
	traceln("Trying to create an EV with no/negative maxChargingPower_kW: %s", maxChargingPower_kW);
}

//Create the EV vehicle energy asset with the set parameters + links
J_EAEV electricVehicle = new J_EAEV(parentGC, capacityElectricity_kW, storageCapacity_kWh, stateOfCharge_fr, timeParameters, energyConsumption_kWhpkm, vehicleScaling, vehicle_type, null);	

if (!isDefaultVehicle && annualTravelDistance_km > avgc_data.p_minAnnualTravelDistanceSurveyVehicle_km){
		electricVehicle.getTripTracker().setAnnualDistance_km(annualTravelDistance_km);
}
else if (vehicle_type == OL_EnergyAssetType.ELECTRIC_VAN){
		electricVehicle.getTripTracker().setAnnualDistance_km(avgc_data.p_avgAnnualTravelDistanceVan_km);
}

return electricVehicle; 
  }

  public 
J_EAFuelVehicle 
 f_addPetroleumFuelVehicle( GridConnection parentGC, OL_EnergyAssetType vehicle_type, Boolean isDefaultVehicle, double annualTravelDistance_km ) { 

double energyConsumption_kWhpkm = 0;
double vehicleScaling = 1.0;

//PetroleumFuel car
switch (vehicle_type){
	
	case PETROLEUM_FUEL_VEHICLE:
		energyConsumption_kWhpkm = roundToDecimal(uniform(0.7, 1.3),2) * avgc_data.p_avgGasolineConsumptionCar_kWhpkm;
	break;
	
	case PETROLEUM_FUEL_VAN:
		energyConsumption_kWhpkm = avgc_data.p_avgDieselConsumptionVan_kWhpkm;
	break;
	
	case PETROLEUM_FUEL_TRUCK:
		energyConsumption_kWhpkm = avgc_data.p_avgDieselConsumptionTruck_kWhpkm;
	break;
}

//Create EA
J_EAFuelVehicle petroleumFuelVehicle = new J_EAFuelVehicle(parentGC, energyConsumption_kWhpkm, energyModel.p_timeParameters, vehicleScaling, vehicle_type, null, OL_EnergyCarriers.PETROLEUM_FUEL);

//Set annual travel distance
if (!isDefaultVehicle && annualTravelDistance_km > avgc_data.p_minAnnualTravelDistanceSurveyVehicle_km){
		petroleumFuelVehicle.getTripTracker().setAnnualDistance_km(annualTravelDistance_km);
}
else if (vehicle_type == OL_EnergyAssetType.PETROLEUM_FUEL_VAN){
		petroleumFuelVehicle.getTripTracker().setAnnualDistance_km(avgc_data.p_avgAnnualTravelDistanceVan_km);
}

return petroleumFuelVehicle;



 
  }

  public void f_addStorage( GridConnection parentGC, double storagePower_kw, double storageCapacity_kWh, OL_EnergyAssetType storageType ) { 

J_EAStorage storage = null;

switch (storageType){

	case STORAGE_ELECTRIC:
		double initialStateOfCharge_fr = 0.5;
		storage = new J_EAStorageElectric(parentGC, storagePower_kw, storageCapacity_kWh, initialStateOfCharge_fr, energyModel.p_timeParameters);
		//traceln("Battery with StorageCapacity_kWh: %s", storageCapacity_kWh);
	break;
	
	case STORAGE_HEAT:
		double lossFactor_WpK = 0; // For now no losses, waiting for new setup heating assets before this can be implemented correctly (its JEA_Building depedent)
		double minTemperature_degC = avgc_data.p_avgMinHeatBufferTemperature_degC;
		double maxTemperature_degC = avgc_data.p_avgMaxHeatBufferTemperature_degC;
		double initialTemperature_degC = (minTemperature_degC + maxTemperature_degC) / 2;
		double setTemperature_degC = initialTemperature_degC;
		//double storageCapacity_kg = (storageCapacity_kWh*3.6e6)/(avgc_data.p_waterHeatCapacity_JpkgK * (maxTemperature_degC - minTemperature_degC));
		//double heatCapacity_JpK = avgc_data.p_waterHeatCapacity_JpkgK * storageCapacity_kg;
		//in short ->
		double heatCapacity_JpK = storageCapacity_kWh*3.6e6 / (maxTemperature_degC - minTemperature_degC); 
		new J_EAStorageHeat(parentGC, storageType, storagePower_kw, lossFactor_WpK, energyModel.p_timeParameters, initialTemperature_degC, minTemperature_degC, maxTemperature_degC, setTemperature_degC, heatCapacity_JpK, OL_AmbientTempType.AMBIENT_AIR );
			
	break;
	
	case STORAGE_GAS:
	
	break;
	
	default:
	
	return;
}
 
  }

  /**
   * Initialisation of the Energy assets using average values for companies that have not filled in the survey (yet) combined with totals (floor surface, electricity/yr, gas/yr and trucks)  of the simulated area.
   */
  protected void f_iEAGenericCompanies( GridConnection companyGC ) { 

//Get GridNode to know if it has a GridNode profile
OL_GridNodeProfileLoaderType gridNodeProfileLoaderType = OL_GridNodeProfileLoaderType.NO_PROFILE;
if (companyGC.p_parentNodeElectricID != null){
	GridNode gn = findFirst(energyModel.pop_gridNodes, GN -> GN.p_gridNodeID.equals(companyGC.p_parentNodeElectricID));
	if (gn != null) {
		gridNodeProfileLoaderType = gn.p_profileType;
	} 
}
//Create current & future scenario parameter list
J_scenario_Current current_scenario_list = new J_scenario_Current();
zero_Interface.c_scenarioMap_Current.put(companyGC.p_uid, current_scenario_list);

J_scenario_Future future_scenario_list = new J_scenario_Future();
zero_Interface.c_scenarioMap_Future.put(companyGC.p_uid, future_scenario_list);

//Set parent
current_scenario_list.setParentAgent(companyGC);
future_scenario_list.setParentAgent(companyGC);

//Add current grid capacity to current (and future, feedin, physical, as no data on plans so assumption it is/stays the same) scenario list
current_scenario_list.setCurrentContractDeliveryCapacity_kW(companyGC.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW());
future_scenario_list.setRequestedContractDeliveryCapacity_kW(companyGC.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW());
current_scenario_list.setCurrentContractFeedinCapacity_kW(companyGC.v_liveConnectionMetaData.getContractedFeedinCapacity_kW());
future_scenario_list.setRequestedContractFeedinCapacity_kW(companyGC.v_liveConnectionMetaData.getContractedFeedinCapacity_kW());
current_scenario_list.setCurrentPhysicalConnectionCapacity_kW(companyGC.v_liveConnectionMetaData.getPhysicalCapacity_kW());
future_scenario_list.setRequestedPhysicalConnectionCapacity_kW(companyGC.v_liveConnectionMetaData.getPhysicalCapacity_kW());

//Basic heating and electricity demand profiles
if (companyGC.p_floorSurfaceArea_m2 > 0){
	
	if(p_remainingTotals.getRemainingElectricityDeliveryCompanies_kWh(companyGC) > 0 && gridNodeProfileLoaderType == OL_GridNodeProfileLoaderType.NO_PROFILE){
		//Building base electricity load
		double Remaining_electricity_demand_kWh_p_m2_yr = p_remainingTotals.getElectricityDeliveryOfAnonymousCompanies_kWhpm2(companyGC);
		double yearlyElectricityDemand_kWh = Remaining_electricity_demand_kWh_p_m2_yr * companyGC.p_floorSurfaceArea_m2;
		
		//Add base load profile
		f_addElectricityDemandProfile(companyGC, yearlyElectricityDemand_kWh, null, false, "default_office_electricity_demand_fr");
	}
	if(p_remainingTotals.getRemainingGasDeliveryCompanies_m3(companyGC) > 0){
		//Building gas demand profile (purely heating)
		double Remaining_gas_demand_m3_p_m2_yr = p_remainingTotals.getGasDeliveryOfAnonymousCompanies_m3pm2(companyGC);
		double yearlyGasDemand_m3 = Remaining_gas_demand_m3_p_m2_yr*companyGC.p_floorSurfaceArea_m2;
		double ratioGasUsedForHeating = 1;
		
		//Add heat demand profile
		OL_GridConnectionHeatingType heatingType = avgc_data.p_avgCompanyHeatingMethod;
		double maxHeatOutputPower_kW = f_createHeatProfileFromAnnualGasTotal(companyGC, heatingType, yearlyGasDemand_m3, ratioGasUsedForHeating);
		f_addHeatAsset(companyGC, heatingType, maxHeatOutputPower_kW);
		companyGC.f_addHeatManagement(heatingType, false);
		
		//Set current scenario heating type
		current_scenario_list.setCurrentHeatingType(heatingType);
		future_scenario_list.setPlannedHeatingType(heatingType);		
	}
}


//Production asset (PV)
Double pv_installed_kwp = companyGC.v_liveAssetsMetaData.initialPV_kW;
if (gridNodeProfileLoaderType == OL_GridNodeProfileLoaderType.INCLUDE_PV || gridNodeProfileLoaderType == OL_GridNodeProfileLoaderType.NET_LOAD){ //dont count production if there is measured data on Node
	pv_installed_kwp = 0.0;
}
if(pv_installed_kwp != null && pv_installed_kwp > 0){
	f_addPVProductionAsset(companyGC, "Rooftop Solar", pv_installed_kwp, companyGC.v_liveAssetsMetaData.PVOrientation);
	
	current_scenario_list.setCurrentPV_kW(roundToInt(pv_installed_kwp));
	current_scenario_list.setCurrentPV_orientation(companyGC.v_liveAssetsMetaData.PVOrientation);
	future_scenario_list.setPlannedPV_kW(roundToInt(pv_installed_kwp));
	future_scenario_list.setPlannedPV_orientation(companyGC.v_liveAssetsMetaData.PVOrientation);
}


//add to scenario: current & future
current_scenario_list.setCurrentBatteryPower_kW(0f);
current_scenario_list.setCurrentBatteryCapacity_kWh(0f);
future_scenario_list.setPlannedBatteryPower_kW(0f);
future_scenario_list.setPlannedBatteryCapacity_kWh(0f);

	
//Transport (total remaining cars, vans and trucks (total as defined in project selection - survey company usage)

//Cars
if(p_remainingTotals.getRemainingNumberOfVehiclesCompanies(companyGC, OL_VehicleType.CAR) > 0){
	int nbCars = 0;
	int ceiledRemainingNumberOfCarsPerCompany = p_remainingTotals.getCeiledRemainingNumberOfVehiclesPerCompany(companyGC, OL_VehicleType.CAR);
	for (int k = 0; k < ceiledRemainingNumberOfCarsPerCompany; k++){
		f_addPetroleumFuelVehicle(companyGC, OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE, true, 0);
		p_remainingTotals.adjustRemainingNumberOfVehiclesCompanies(companyGC, OL_VehicleType.CAR, - 1);
		nbCars++;
	}
	
	//Reduce remaining number of anonymous companies that still can get vehicles
	p_remainingTotals.adjustRemainingNumberOfAnonymousCompaniesForVehicleType(companyGC, OL_VehicleType.CAR, - 1);
	
	//Set current scenario cars
	current_scenario_list.setCurrentPetroleumFuelCars(nbCars);
	//Set planned scenario cars
	future_scenario_list.setPlannedEVCars(0);
}

//Vans
if(p_remainingTotals.getRemainingNumberOfVehiclesCompanies(companyGC, OL_VehicleType.VAN) > 0){
	int nbVans = 0;
	int ceiledRemainingNumberOfVansPerCompany = p_remainingTotals.getCeiledRemainingNumberOfVehiclesPerCompany(companyGC, OL_VehicleType.VAN);
	for (int k = 0; k< ceiledRemainingNumberOfVansPerCompany; k++){
		f_addPetroleumFuelVehicle(companyGC, OL_EnergyAssetType.PETROLEUM_FUEL_VAN, true, 0);
		p_remainingTotals.adjustRemainingNumberOfVehiclesCompanies(companyGC, OL_VehicleType.VAN, - 1);
		nbVans++;
	}
	
	//Reduce remaining number of anonymous companies that still can get vehicles
	p_remainingTotals.adjustRemainingNumberOfAnonymousCompaniesForVehicleType(companyGC, OL_VehicleType.VAN, - 1);
	
	//Set current scenario vans
	current_scenario_list.setCurrentPetroleumFuelVans(nbVans);
	//Set planned scenario vans
	future_scenario_list.setPlannedEVVans(0);
}

//Trucks
if (p_remainingTotals.getRemainingNumberOfVehiclesCompanies(companyGC, OL_VehicleType.TRUCK) > 0){
	int nbTrucks= 0;
	int ceiledRemainingNumberOfTrucksPerCompany = p_remainingTotals.getCeiledRemainingNumberOfVehiclesPerCompany(companyGC, OL_VehicleType.TRUCK);
	for (int k = 0; k< ceiledRemainingNumberOfTrucksPerCompany; k++){
		f_addPetroleumFuelVehicle(companyGC, OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK, true, 0);
		p_remainingTotals.adjustRemainingNumberOfVehiclesCompanies(companyGC, OL_VehicleType.TRUCK, - 1);
		nbTrucks++;
	}
	
	//Reduce remaining number of anonymous companies that still can get vehicles
	p_remainingTotals.adjustRemainingNumberOfAnonymousCompaniesForVehicleType(companyGC, OL_VehicleType.TRUCK, - 1);
		
	//Set current scenario trucks
	current_scenario_list.setCurrentPetroleumFuelTrucks(nbTrucks);
	//Set planned scenario trucks
	future_scenario_list.setPlannedEVTrucks(0);
} 
  }

  protected void f_createRemainingBuildings(  ) { 

//If remaining buildings in model, add to legend
if(c_remainingBuilding_data.size()>0){
	zero_Interface.c_modelActiveDefaultGISBuildings.add(OL_GISBuildingTypes.REMAINING);
}

for (Building_data remainingBuilding_data : c_remainingBuilding_data) {
	
	GIS_Building building = energyModel.add_pop_GIS_Buildings();
	building.p_id = remainingBuilding_data.building_id();
	building.p_longitude = remainingBuilding_data.longitude();
	building.p_latitude = remainingBuilding_data.latitude();
	building.setLatLon(building.p_latitude, building.p_longitude);		
	building.p_GISObjectType = OL_GISObjectType.REMAINING_BUILDING;
	
	//Building + styling the gisregion and putting it on the map		
	building.gisRegion = zero_Interface.f_createGISObject(f_createGISObjectTokens(remainingBuilding_data.polygon(), building.p_GISObjectType));
	
	building.p_defaultFillColor = zero_Interface.v_restBuildingColor;
	building.p_defaultLineColor = zero_Interface.v_restBuildingLineColor;
	zero_Interface.f_styleAreas(building);
} 
  }

  public void f_addTransportHydrogen( GridConnection parentGC, OL_EnergyAssetType vehicle_type, boolean isDefaultVehicle, double annualTravelDistance_km ) { 

double energyConsumption_kWhpkm = 0;
double vehicleScaling = 1.0;

//Hydrogen car
switch (vehicle_type){

	case HYDROGEN_VEHICLE:
		energyConsumption_kWhpkm = avgc_data.p_avgHydrogenConsumptionCar_kWhpkm;
	break;
	
	case HYDROGEN_VAN:
		energyConsumption_kWhpkm = avgc_data.p_avgHydrogenConsumptionVan_kWhpkm;
	break;
	
	case HYDROGEN_TRUCK:
		energyConsumption_kWhpkm = avgc_data.p_avgHydrogenConsumptionTruck_kWhpkm;
	break;
}

//Create EA
J_EAFuelVehicle hydrogenVehicle = new J_EAFuelVehicle(parentGC, energyConsumption_kWhpkm, energyModel.p_timeParameters, vehicleScaling, vehicle_type, null, OL_EnergyCarriers.HYDROGEN);

//Set annual travel distance
if (!isDefaultVehicle && annualTravelDistance_km > avgc_data.p_minAnnualTravelDistanceSurveyVehicle_km){
		hydrogenVehicle.getTripTracker().setAnnualDistance_km(annualTravelDistance_km);
}
else if (vehicle_type == OL_EnergyAssetType.HYDROGEN_VAN){
		hydrogenVehicle.getTripTracker().setAnnualDistance_km(avgc_data.p_avgAnnualTravelDistanceVan_km);
} 
  }

  protected 
String 
 f_createChargerPolygon( double lat, double lon ) { 

//Create shape coords and polygon string, that matches output of QGIS: Polygon(lon,lat,lon,lat, etc.)
int nb_points = 6;
String chargerPolygon = "POLYGON ((";

for (int i=0; i < nb_points ; i++){
	if(i > 0){
		chargerPolygon += ",";
	}
	double size = 0.00004;
	chargerPolygon += 1.64 * size * sin( i * ( 2 * Math.PI ) / nb_points) + lon;
	chargerPolygon += ",";
	chargerPolygon += size * cos( i * ( 2 * Math.PI ) / nb_points) + lat;
}

return chargerPolygon;
 
  }

  protected void f_createChargingStations(  ) { 

//Initialize parameters
int laadpaal_nr = 1;
int laadCentrum_nr = 1;

//Loop over charging stations
for (Chargingstation_data dataChargingStation : f_getChargingstationsInSubScope(c_chargingstation_data)){

	GCPublicCharger chargingStation = energyModel.add_PublicChargers();
	chargingStation.p_gridConnectionID = dataChargingStation.gc_id();
	chargingStation.p_ownerID = dataChargingStation.owner_id();				
	chargingStation.p_isChargingCentre = dataChargingStation.is_charging_centre();
		
	//Make owner name if it is not filled in (used for display on UI).
	if (dataChargingStation.owner_id() == null){
		if(chargingStation.p_isChargingCentre){
			chargingStation.p_ownerID = "Publiek laadcentrum " + laadCentrum_nr;
			laadCentrum_nr++;
		}
		else{
			chargingStation.p_ownerID = "Publieke laadpaal " + laadpaal_nr;
			laadpaal_nr++;
	
		}		
	}
	
	//Create and connect ConnectionOwner	
	ConnectionOwner owner = energyModel.add_pop_connectionOwners();
	owner.p_actorID = chargingStation.p_ownerID;
	owner.p_connectionOwnerType = OL_ConnectionOwnerType.CHARGEPOINT_OP;
	owner.b_dataSharingAgreed = true;
	chargingStation.p_owner = owner;
		
	//Set Address
	chargingStation.p_address = new J_Address(dataChargingStation.streetname(), 
											  dataChargingStation.house_number(), 
											  dataChargingStation.house_letter(), 
											  dataChargingStation.house_addition(), 
											  dataChargingStation.postalcode(), 
											  dataChargingStation.city());
											
	
	//Electric Capacity
	if (dataChargingStation.connection_capacity_kw() != null) {
		// Assume the connection capacity is both physical and contracted.
		double connectionCapacity_kW = dataChargingStation.connection_capacity_kw();
		chargingStation.v_liveConnectionMetaData.setCapacities_kW(connectionCapacity_kW, connectionCapacity_kW, connectionCapacity_kW);
		chargingStation.v_liveConnectionMetaData.setCapacitiesKnown(true, true, true);
	}
	
	//Set parent node
	chargingStation.p_parentNodeElectricID = dataChargingStation.gridnode_id();
	
	//Is active at start?
	chargingStation.v_isActive = dataChargingStation.initially_active();
			
		
	//Default charger parameters
	double numberOfSockets = dataChargingStation.number_of_chargers() != null ? dataChargingStation.number_of_chargers() : avgc_data.p_defaultNrOfSocketsPerCharger;
	double maxPowerPerSocket_kW = dataChargingStation.power_per_charger_kw() != null ? dataChargingStation.power_per_charger_kw() : avgc_data.p_avgEVMaxChargePowerCar_kW;

	//Assumption is all chargepoints are the same for one GCPublicCharger
	boolean V1GCapable = true; //randomTrue(avgc_data.p_v1gProbability);
	boolean V2GCapable = true; //randomTrue(avgc_data.p_v2gProbability);
	chargingStation.f_setChargePoint(new J_ChargePoint(V1GCapable, V2GCapable, maxPowerPerSocket_kW));
	chargingStation.f_setChargingManagement(new J_ChargingManagementSimple(chargingStation, energyModel.p_timeParameters));
		
	//Create chargingsession/vehicles
	if(dataChargingStation.vehicle_type() == OL_EnergyAssetType.CHARGER){

		int sessionSocketNr = 0;
		List<J_ChargingSessionData> chargerProfile = f_getChargerProfile();
		for(int i = 0; i< numberOfSockets; i++){
			if(i != 0 && numberOfSockets % i == 0){
				chargerProfile = f_getChargerProfile();
				sessionSocketNr = 0;
			}
			new J_EAChargingSession(chargingStation, chargerProfile, sessionSocketNr, energyModel.p_timeParameters);
			sessionSocketNr++;
		}
	}
	else{
		for(int k = 0; k < numberOfSockets*avgc_data.p_defaultNrOfVehiclesPerChargerSocket; k++ ){
			f_addElectricVehicle(chargingStation, dataChargingStation.vehicle_type(), true, 0, maxPowerPerSocket_kW);
		}
	}
	
	
	//Get polygonString for GIS object	
	String polygonString;
	if (chargingStation.p_isChargingCentre) {
		if(dataChargingStation.polygon() == null){
			throw new RuntimeException("Trying to make a charging CENTRE without specifying the polygon, this is only possible for a single charge POLE");
		}
		polygonString = dataChargingStation.polygon();
	}
	else{
		polygonString = f_createChargerPolygon(dataChargingStation.latitude(), dataChargingStation.longitude());	
	}

	//Create EA GIS object (building) for the charging centre
	GIS_Object gisregion = f_createGISObject( dataChargingStation.gc_name(), dataChargingStation.latitude(), dataChargingStation.longitude(), polygonString, OL_GISObjectType.CHARGER );
	
	//Add to collections
	gisregion.c_containedGridConnections.add(chargingStation);
	chargingStation.c_connectedGISObjects.add(gisregion);
	
	//Style GIS object
	if(chargingStation.v_isActive){
		gisregion.set_p_defaultFillColor( zero_Interface.v_chargingStationColor );
		gisregion.set_p_defaultLineColor( zero_Interface.v_chargingStationLineColor );
	}
	else{
		gisregion.set_p_defaultFillColor( zero_Interface.v_newChargingStationColor );
		gisregion.set_p_defaultLineColor( zero_Interface.v_newChargingStationLineColor );
	}
	gisregion.set_p_defaultLineWidth( zero_Interface.v_energyAssetLineWidth);
	zero_Interface.f_styleAreas(gisregion);
}

 
  }

  protected void f_createInterface(  ) { 

//OVERRIDE THE zero_Interface parameter here
//zero_Interface = YOUR INTERFACE;
throw new RuntimeException("Didnt replace the generic interface with a project interface!"); 
  }

  protected void f_createGISCables(  ) { 

//Create cables
for (Cable_data dataCable : c_cable_data) {
	if(dataCable.line().contains("Multi")){
		continue;
	}
	zero_Interface.f_createGISLine(f_createGISObjectTokens(dataCable.line(), dataCable.type()), dataCable.type());
} 
  }

  /**
   * Principe:<br>
   * verbruik = levering + productie - teruglevering
   */
  protected void f_createPreprocessedElectricityProfile_PV( GridConnection parentGC, double[] yearlyElectricityDelivery_kWh, double[] yearlyElectricityFeedin_kWh, double[] yearlyElectricityProduction_kWh, Double pvPower_kW, double[] yearlyHeatPumpElectricityConsumption_kWh ) { 

double extraConsumption_kWh = 0;


//Initialize parameters		
double nettDelivery_kWh;
double[] yearlyElectricityConsumption_kWh = new double[yearlyElectricityDelivery_kWh.length];
double[] timeAxis_h = new double[yearlyElectricityDelivery_kWh.length];
for (int i = 0; i<yearlyElectricityDelivery_kWh.length; i++){
	timeAxis_h[i] = energyModel.p_timeParameters.getRunStartTime_h() + i*0.25;
}

//Preprocessing and adding new array to the J_EAProfile
if (yearlyElectricityProduction_kWh != null && yearlyElectricityFeedin_kWh != null) { // When delivery, feedin and production profiles are available
	
	for (int i = 0; i < yearlyElectricityDelivery_kWh.length; i++) {	
		yearlyElectricityConsumption_kWh[i] = yearlyElectricityDelivery_kWh[i] - yearlyElectricityFeedin_kWh[i] + yearlyElectricityProduction_kWh[i];
		extraConsumption_kWh += -min(yearlyElectricityConsumption_kWh[i],0);
		yearlyElectricityConsumption_kWh[i] = max(0,yearlyElectricityConsumption_kWh[i]);
	}

	nettDelivery_kWh = Arrays.stream(yearlyElectricityDelivery_kWh).sum() - Arrays.stream(yearlyElectricityFeedin_kWh).sum();
	//traceln("Calculating consumption profile on delivery, feedin and production profiles for company %s with %s kWp PV", parentGC.p_gridConnectionID, pvPower_kW);
} else if (pvPower_kW != null && pvPower_kW > 0) { // When only delivery, feedin profiles are available, in addition to PV power, make explicit consumption and production arrays using delivery profile and PV installed power [kW]
	
	if (yearlyElectricityFeedin_kWh != null) { // Terugleveringsdata beschikbaar
		//traceln("Estimating electricity consumption based on delivery and feedin profiles with pv power estimate for company %s with %s kWp PV", parentGC.p_gridConnectionID, pvPower_kW);
		double addedConsumption_kWh = 0;
		for (int i = 0; i < yearlyElectricityDelivery_kWh.length; i++) {
			double pvPowerEstimate_kW = pvPower_kW * energyModel.pp_PVProduction35DegSouth_fr.getValue(energyModel.p_timeParameters.getRunStartTime_h()+i*0.25);
			double estimatedConsumption_kWh = yearlyElectricityDelivery_kWh[i] + max(0, pvPowerEstimate_kW*0.25 - yearlyElectricityFeedin_kWh[i]);
			addedConsumption_kWh += max(0, pvPowerEstimate_kW*0.25 - yearlyElectricityFeedin_kWh[i]);
			yearlyElectricityConsumption_kWh[i] = max(0,estimatedConsumption_kWh);
		}
		//traceln("Added electricity consumed compared to delivery profile: %s MWh", addedConsumption_kWh/1000);
	} else { // Zonder terugleveringsdata, alleen afname
		traceln("Estimating electricity consumption based on delivery profile and pv power for company %s with %s kWp PV", parentGC.p_gridConnectionID, pvPower_kW);
		double pvPowerEstimate_kW = 0;
		double estimatedConsumption_kWh = 0;
		double addedConsumption_kWh = 0;
		for (int i = 0; i < yearlyElectricityDelivery_kWh.length; i++) {
			pvPowerEstimate_kW = pvPower_kW * energyModel.pp_PVProduction35DegSouth_fr.getValue(energyModel.p_timeParameters.getRunStartTime_h()+i*0.25);
			
			if (yearlyElectricityDelivery_kWh[i] != 0) { // Only update consumption if delivery is non-zero, otherwise hold previously estimated consumption constant
				estimatedConsumption_kWh = yearlyElectricityDelivery_kWh[i] + pvPowerEstimate_kW*0.25;
				//addedConsumption_kWh += pvPowerEstimate_kW * 0.25;
			} else {
				estimatedConsumption_kWh = min(pvPowerEstimate_kW*0.25, estimatedConsumption_kWh); // Take minimum to prevent to much consumption when there is not enough sun in model sun, compared to real sun data!!
				
				//addedConsumption_kWh += max(0, estimatedConsumption_kWh - pvPowerEstimate_kW*0.25);//* 0.25;
			}
			yearlyElectricityConsumption_kWh[i] = max(0,estimatedConsumption_kWh);
		}
		//traceln("Added electricity consumed compared to delivery profile: %s MWh", addedConsumption_kWh/1000);
	}
	
	nettDelivery_kWh = Arrays.stream(yearlyElectricityDelivery_kWh).sum();
} else { // No PV production
	yearlyElectricityConsumption_kWh=yearlyElectricityDelivery_kWh;
	nettDelivery_kWh = Arrays.stream(yearlyElectricityDelivery_kWh).sum();
}

//Adjust remaining totals
p_remainingTotals.adjustRemainingElectricityDeliveryCompanies_kWh(parentGC,  - nettDelivery_kWh);
			
if (extraConsumption_kWh > 1) {
	traceln("Preprocessing of delivery and production data led to negative consumption of: %s kWh", extraConsumption_kWh);
	traceln("Consumption profile was capped to 0kW");
}
 
if(yearlyHeatPumpElectricityConsumption_kWh != null){
	for(int i = 0; i < yearlyHeatPumpElectricityConsumption_kWh.length; i++){
		yearlyHeatPumpElectricityConsumption_kWh[i] = max(0,yearlyHeatPumpElectricityConsumption_kWh[i]);
	}
	double[] preProcessedDefaultConsumptionProfile = new double[yearlyElectricityConsumption_kWh.length];
	for(int i = 0; i < preProcessedDefaultConsumptionProfile.length; i++){
		preProcessedDefaultConsumptionProfile[i] = max(0,yearlyElectricityConsumption_kWh[i] - yearlyHeatPumpElectricityConsumption_kWh[i]);
	}
	//profile.a_energyProfile_kWh = preProcessedDefaultConsumptionProfile;
	String heatpumpAssetName = parentGC.p_ownerID + " custom heat pump electricity consumption profile";
	J_ProfilePointer heatpumpProfilePointer = f_createEngineProfile(heatpumpAssetName, timeAxis_h, yearlyHeatPumpElectricityConsumption_kWh, OL_ProfileUnits.KWHPQUARTERHOUR);	
	J_EAProfile profileHeatPumpElectricityConsumption = new J_EAProfile(parentGC, OL_EnergyCarriers.ELECTRICITY, heatpumpProfilePointer, OL_AssetFlowCategories.heatPumpElectricityConsumption_kW, energyModel.p_timeParameters);
	//profileHeatPumpElectricityConsumption.setStartTime_h(v_simStartHour_h);
	profileHeatPumpElectricityConsumption.setEnergyAssetName(heatpumpAssetName);	
	yearlyElectricityConsumption_kWh = preProcessedDefaultConsumptionProfile;
}

// Create the actual profile asset
String energyAssetName = parentGC.p_ownerID + " custom profile";
J_ProfilePointer profilePointer = f_createEngineProfile(energyAssetName, timeAxis_h, yearlyElectricityConsumption_kWh, OL_ProfileUnits.KWHPQUARTERHOUR);
//Create the profile 
J_EAProfile profile = new J_EAProfile(parentGC, OL_EnergyCarriers.ELECTRICITY, profilePointer, OL_AssetFlowCategories.fixedConsumptionElectric_kW, energyModel.p_timeParameters);		
//profile.setStartTime_h(v_simStartHour_h);
profile.setEnergyAssetName(energyAssetName);

 
  }

  public void f_startUpLoader_default(  ) { 

traceln("---------------------------");
traceln("======= STARTING UP =======");
traceln("---------------------------");
traceln("");

double startTime = System.currentTimeMillis();
v_timeOfModelStart_ms = startTime;

//Get simulation start time
f_setSimulationTimeParameters();

//Send avgc data to engine
avgc_data.f_setAVGC_data(project_data.grid_operator(), energyModel.p_timeParameters.getStartYear());

// Set default heating strategies
f_setDefaultHeatingStrategies();

//Import excel data to the anylogic database
f_importExcelTablesToDB();

//Fill the record collections
f_readDatabase();

//Initialize model totals
p_remainingTotals.initializeModelTotals(project_data, user);

//Weather market data
f_setEngineProfiles();

//Create the project interface
f_createInterface();

//Initialize the pointers on the interface
f_initializeInterfacePointers();

//Project specific styling (Needs to happen before configuring the engine)
zero_Interface.f_projectSpecificStyling();

// Populate the model
f_configureEngine_default();

//Start up of the User Interface (Needs to happen after configuring the engine)
zero_Interface.f_UIStartup();

//Ending of the start up
double endTime = System.currentTimeMillis();
double duration = endTime - startTime;
v_modelStartUpDuration_s = roundToDecimal(duration / 1000, 3);

traceln(" ");
traceln("*** Start up finished *** ");
traceln("*** Start up duration: "+ v_modelStartUpDuration_s + " s ***");
traceln(" ");


//Simulate full year simulation for initial KPIs
if( settings.runHeadlessAtStartup() ){
	energyModel.f_runRapidSimulation(); // Do a full year run to have KPIs right away!
	
	if(project_data.project_type() == BUSINESSPARK){
		for(GCUtility GC : energyModel.UtilityConnections){
			if(GC.p_owner.p_detailedCompany){ // For now only detailed companies
				GC.v_originalRapidRunData = GC.v_rapidRunData;
			}
		}
	}
	zero_Interface.gr_simulateYear.setVisible(false);
	zero_Interface.gr_loadIconYearSimulation.setVisible(false);
	zero_Interface.b_resultsUpToDate = true;
	zero_Interface.uI_Results.f_enableNonLivePlotRadioButtons(true);
}
else {
	zero_Interface.f_resetSettings();
}

zero_Interface.uI_Results.f_updateResultsUI(energyModel);

//Clear all data record collections after loader is done
f_clearDataRecords(); 
  }

  protected void f_readDatabase(  ) { 

//Override this function and:
//Fill the data parameters and collections using your own functions here 
  }

  protected void f_clearDataRecords(  ) { 

//Function used to clear all data record collections after the loader is done
//-> no longer needed, by clearing it is send to the garbage collector -> saves memory

/*
genericProfiles_data = null;
c_gridNode_data.clear();
c_companyBuilding_data.clear();
c_houseBuilding_data.clear();
c_remainingBuilding_data.clear();
c_solarfarm_data.clear();
c_windfarm_data.clear();
c_electrolyser_data.clear();
c_battery_data.clear();
c_chargingstation_data.clear();
c_neighbourhood_data.clear();
c_parkingSpace_data.clear();
c_parcel_data.clear();
c_cable_data.clear();
*/
 
  }

  protected void f_createSurveyCompanies_Excel(  ) { 

traceln("Survey companies excel should be overridden with your own code"); 
  }

  protected void f_createCompanies(  ) { 

//Create survey companies based on survey inload structure
switch(project_data.survey_type()){
	
	case ZORM:
		f_createSurveyCompanies_Zorm();
		break;
		
	case EXCEL:
		f_createSurveyCompanies_Excel();
		break;
		
	case NONE:
		//Do nothing.
		break;
}

//Create generic companies
f_createGenericCompanies(); 
  }

  protected void f_createAdditionalGISObjects(  ) { 

//Parking spaces
f_createParkingSpots();

//Parcels
f_createGISParcels();

//Remaining buildings (no GC or EA)
f_createRemainingBuildings();

//Cables
f_createGISCables(); 
  }

  protected void f_overwriteSpecificDatabaseValues(  ) { 

//SHOULD BE OVERRIDDEN

//Function used to overwrite specific database values after the databases have been loaded in
//Usecases for example are adjusting floor surface area to 0, to cause no consumption, etc.
// --> without the loss of data in your database sources itself

//Example code
/*
//Adjust building floor surface area to 0 to cause no consumption (empty buildings)

List<String> buildingIDS = new ArrayList<String>();

// Define the building ids that need to have no consumption
String buildingID_XXXX = "XXXX";

buildingIDS.add(buildingID_XXXX);


for(String buildingID : buildingIDS){
	update(buildings)
  	.where(buildings.building_id.eq(buildingID))
  	.set(buildings.cumulative_floor_surface_m2, 0.0)
  	.execute();
}
*/ 
  }

  public 
double[] 
 f_convertFloatArrayToDoubleArray( float[] floatArray ) { 

if (floatArray == null) {
        return null;
}
double[] doubleArray = new double[floatArray.length];
for (int i = 0; i < floatArray.length; i++) {
    doubleArray[i] = floatArray[i];
}
return doubleArray; 
  }

  protected 
double 
 f_getPreprocessedElectricityConsumptionTotal( GridConnection parentGC, double annualElectricityDelivery_kWh, Integer annualElectricityFeedin_kWh, Integer annualElectricityProduction_kWh, Double pvPower_kW ) { 

double annualElectricityConsumption_kWh = 0;
if(annualElectricityFeedin_kWh != null){
	if(annualElectricityProduction_kWh != null){
		annualElectricityConsumption_kWh = annualElectricityDelivery_kWh - annualElectricityFeedin_kWh + annualElectricityProduction_kWh;
	}
	else if(pvPower_kW != null && pvPower_kW > 0){
		annualElectricityConsumption_kWh = annualElectricityDelivery_kWh - annualElectricityFeedin_kWh + pvPower_kW*avgc_data.p_avgFullLoadHoursPV_hr;
	}
	else{//Geen opwek
		annualElectricityConsumption_kWh = annualElectricityDelivery_kWh;
	}
}
else if(pvPower_kW != null && pvPower_kW > 0){
	//WAT HIER?? Voor nu consumption = delivery
	//Maar: moet preprocessing van standaard profiel worden, waar gelijktijdigheid gecheckt wordt!
	annualElectricityConsumption_kWh = annualElectricityDelivery_kWh;
}
else{
	annualElectricityConsumption_kWh = annualElectricityDelivery_kWh;
}
return annualElectricityConsumption_kWh;
 
  }

  public void f_createCustomPVAsset( GridConnection parentGC, double[] yearlyElectricityProduction_kWh, Double pvPower_kW ) { 

if (yearlyElectricityProduction_kWh.length < 35040) {
	traceln("Skipping creation of PV asset: need 35040 data points, got %d", yearlyElectricityProduction_kWh.length);
	return;
}

yearlyElectricityProduction_kWh = Arrays.copyOfRange(yearlyElectricityProduction_kWh, 0, 35040);
        
// Generate custom PV production asset using production data!
double[] a_arguments = IntStream.range(0, 35040).mapToDouble(i -> energyModel.p_timeParameters.getRunStartTime_h() + i*0.25).toArray(); // time axis

// From kWh/quarter to normalized power
double totalProduction_kWh = Arrays.stream(yearlyElectricityProduction_kWh).sum();
double fullLoadHours_h = totalProduction_kWh / pvPower_kW;
double[] a_normalizedPower_fr = Arrays.stream(yearlyElectricityProduction_kWh).map(i -> 4 * i / totalProduction_kWh * fullLoadHours_h ).toArray();

//TableFunction tf_customPVproduction_fr = new TableFunction(a_arguments, a_normalizedPower_fr, TableFunction.InterpolationType.INTERPOLATION_LINEAR, 2, TableFunction.OutOfRangeAction.OUTOFRANGE_REPEAT, 0.0);
//J_ProfilePointer profilePointer = new J_ProfilePointer((parentGC.p_ownerID + "_PVproduction") , tf_customPVproduction_fr, OL_ProfileUnits.NORMALIZEDPOWER);
double dataTimeStep_h = 0.25;
double dataStartTime_h = 0.0;
J_ProfilePointer profilePointer = new J_ProfilePointer(("GC: " + parentGC.p_gridConnectionID + " custom pv profile") , a_normalizedPower_fr, dataTimeStep_h, dataStartTime_h, OL_ProfileUnits.NORMALIZEDPOWER);
energyModel.f_addProfile(profilePointer);
J_EAProduction production_asset = new J_EAProduction(parentGC, OL_EnergyAssetType.PHOTOVOLTAIC, (parentGC.p_ownerID + "_rooftopPV"), OL_EnergyCarriers.ELECTRICITY, (double)pvPower_kW, energyModel.p_timeParameters, profilePointer);

traceln("Custom PV asset added to GC: " + parentGC.p_ownerID); 
  }

  protected void f_iEASurveyCompanies_Zorm( GridConnection companyGC, com.zenmo.zummon.companysurvey.GridConnection gridConnection ) { 

//Initialize boolean that sets the creation of currently existing electric (demand) EA
boolean createElectricEA = true;

//Create current scenario parameter list
J_scenario_Current current_scenario_list = new J_scenario_Current();
zero_Interface.c_scenarioMap_Current.put(companyGC.p_uid, current_scenario_list);

//Create future scenario parameter list
J_scenario_Future future_scenario_list = new J_scenario_Future();
zero_Interface.c_scenarioMap_Future.put(companyGC.p_uid, future_scenario_list);



//Get PV power (used for preprocessing and estimating grid capacity if unknown)
Double pvPower_kW = (gridConnection.getSupply().getPvInstalledKwp() != null) ? new Double(gridConnection.getSupply().getPvInstalledKwp()) : null;


////Electricity (connection and consumption)
//Check for electricity connection and data
if (gridConnection.getElectricity().getHasConnection()){
	
	//Connection capacities
	//TEMPORARY CONVERSION NEEDED UNTIL NO LONGER INTEGER FROM SURVEY
	Integer contractedFeedinCapacity_kW_INTEGER = gridConnection.getElectricity().getGrootverbruik().getContractedConnectionSupplyCapacityKw();
	Integer physicalCapacity_kW_INTEGER = gridConnection.getElectricity().getGrootverbruik().getPhysicalCapacityKw();	
	Double contractedDeliveryCapacity_kW = gridConnection.getElectricity().getContractedConnectionCapacityKw();
	Double contractedFeedinCapacity_kW = contractedFeedinCapacity_kW_INTEGER != null ? contractedFeedinCapacity_kW_INTEGER.doubleValue() : null;
	Double physicalCapacity_kW = physicalCapacity_kW_INTEGER != null ? physicalCapacity_kW_INTEGER.doubleValue() : null;
	boolean contractedDeliveryCapacityKnown = contractedDeliveryCapacity_kW != null && contractedDeliveryCapacity_kW >= 0;
	boolean contractedFeedinCapacityKnown = contractedFeedinCapacity_kW != null && contractedFeedinCapacity_kW >= 0;
	boolean physicalCapacityKnown = physicalCapacity_kW != null && physicalCapacity_kW >= 0;
			
	//Backups
	if(!contractedDeliveryCapacityKnown){//Backup for contracted delivery capacity if unknown (make same as physical if known or else average)
		if(physicalCapacityKnown){
			contractedDeliveryCapacity_kW = physicalCapacity_kW.doubleValue();
		}
		else{
			traceln("SURVEYOWNER HAS NOT FILLED IN DELIVERY OR PHYSICAL CONNECTION CAPACITY! -> Average utility connection taken as contracted Delivery Capacity.");		
			contractedDeliveryCapacity_kW = avgc_data.p_avgUtilityConnectionCapacity_kW;
		}
	}
	if(!contractedFeedinCapacityKnown){	//Backup for contracted feedin capacity if unknown
		contractedFeedinCapacity_kW = 0.0; // Assume no contract capacity, not even when there is PV.
	}
	if(!physicalCapacityKnown || physicalCapacity_kW < contractedDeliveryCapacity_kW || physicalCapacity_kW < contractedFeedinCapacity_kW){	//Backup for connection capacity if unknown OR smaller than 
		physicalCapacity_kW = max(contractedDeliveryCapacity_kW, contractedFeedinCapacity_kW); //Contracted connection capacity
	}
	
	//Set values
	companyGC.v_liveConnectionMetaData.setCapacities_kW(contractedDeliveryCapacity_kW, contractedFeedinCapacity_kW, physicalCapacity_kW);
	companyGC.v_liveConnectionMetaData.setCapacitiesKnown(contractedDeliveryCapacityKnown, contractedFeedinCapacityKnown, physicalCapacityKnown);
		
	//Add to current scenario list
	current_scenario_list.setCurrentContractDeliveryCapacity_kW(companyGC.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW());
	current_scenario_list.setCurrentContractFeedinCapacity_kW(companyGC.v_liveConnectionMetaData.getContractedFeedinCapacity_kW());
	current_scenario_list.setCurrentPhysicalConnectionCapacity_kW(companyGC.v_liveConnectionMetaData.getPhysicalCapacity_kW());
	
	
	//Electricity consumption profile
	String profileName = "default_office_electricity_demand_fr";
	
	//Check if quarter hourly values are available in vallum
	boolean createdTimeSeriesAssets = f_createElectricityTimeSeriesAssets(companyGC, gridConnection);
	
	if(createdTimeSeriesAssets){
		if(!settings.createCurrentElectricityEA()){//input boolean: Dont create current electric energy assets if electricity profile or total is known.
			createElectricEA = false;
		}
	}
	else{ //(!createdTimeSeriesAssets) { // 
		double yearlyElectricityConsumption_kWh  = 0;
		try { // Check if quarterly hour values are available in excel database
			if(selectFirstValue(Double.class, "SELECT " + "ccid" + gridConnection.getSequence().toString() + "_demand FROM comp_elec_consumption LIMIT 1;") != null){
		  		companyGC.v_hasQuarterHourlyValues = true;
				profileName = "ccid" + companyGC.p_gridConnectionID;
				
				//Check if solar was already producing in simualtion year (Check for now: if year production = 0 , no solar yet, if year production = null, no data: so assume there was solar already)
				if(gridConnection.getElectricity().getAnnualElectricityProduction_kWh() != null && gridConnection.getElectricity().getAnnualElectricityProduction_kWh  () == 0){
					pvPower_kW = null;
				}
		
				if (!settings.createCurrentElectricityEA()){//input boolean: Dont create current electric energy assets if electricity profile is present.
					createElectricEA = false;
				}
			}
		}
		catch(Exception e) {
			//Data not available, do nothing and leave v_hasQuarterHourlyValues on false.
		}
		
		if(companyGC.v_hasQuarterHourlyValues == false){//Calculate yearly consumption based on yearly delivery (and yearly feedin, production or solarpanels if available)
			//Get totals
			double yearlyElectricityDelivery_kWh = (gridConnection.getElectricity().getAnnualElectricityDemandKwh() != null) ? gridConnection.getElectricity().getAnnualElectricityDemandKwh() : 0; // Yearly electricity consumption (0 if value is null)
			Integer yearlyElectricityFeedin_kWh = gridConnection.getElectricity().getAnnualElectricityFeedIn_kWh();
			Integer yearlyElectricityProduction_kWh = gridConnection.getElectricity().getAnnualElectricityProduction_kWh();
			
			//Calculate consumption
			yearlyElectricityConsumption_kWh = f_getPreprocessedElectricityConsumptionTotal(companyGC, yearlyElectricityDelivery_kWh, yearlyElectricityFeedin_kWh, yearlyElectricityProduction_kWh, pvPower_kW);
			
			//If no electricity consumption, determine the consumption based on average values and floor surface and connection capacity
			if(yearlyElectricityConsumption_kWh == 0){
				yearlyElectricityConsumption_kWh = avgc_data.p_avgCompanyElectricityConsumption_kWhpm2*companyGC.p_floorSurfaceArea_m2;
				
				//Check if it is within the contracted limits (peak should at least be 20% lower than contracted capacity
				if(yearlyElectricityConsumption_kWh*defaultProfiles_data.getDefaultOfficeElectricityDemandProfileMaximum_fr() > 0.8*companyGC.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW()){
					yearlyElectricityConsumption_kWh = 0.8*companyGC.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW()/defaultProfiles_data.getDefaultOfficeElectricityDemandProfileMaximum_fr();
				}
				 
			}
			else if(!settings.createCurrentElectricityEA()){//input boolean: Dont create current electric energy assets if electricity profile or total is known.
					createElectricEA = false;
			}
			
			//Update total Yearly electricity consumption (only when no timestep data available, cause when thats avaiable, it happens in the preprocessing function)
			if (yearlyElectricityDelivery_kWh != 0){
				p_remainingTotals.adjustRemainingElectricityDeliveryCompanies_kWh(companyGC,  - yearlyElectricityDelivery_kWh);
			}
			else{
				p_remainingTotals.adjustRemainingElectricityDeliveryCompanies_kWh(companyGC,  - yearlyElectricityConsumption_kWh);
			}
		}
		
		//Add base electricity demand profile (with profile if available, with generic pattern if only yearly data is available)
		f_addElectricityDemandProfile(companyGC, yearlyElectricityConsumption_kWh, pvPower_kW, companyGC.v_hasQuarterHourlyValues, profileName);
	}
}

//If everything is 0 set the GC as non active
if(companyGC.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW() == 0 && companyGC.v_liveConnectionMetaData.getContractedFeedinCapacity_kW() == 0 && companyGC.v_liveConnectionMetaData.getPhysicalCapacity_kW() == 0){
	companyGC.v_isActive = false;
}
		
//Grid expansion request
if (gridConnection.getElectricity().getGridExpansion().getHasRequestAtGridOperator() != null && gridConnection.getElectricity().getGridExpansion().getHasRequestAtGridOperator()){
	future_scenario_list.setRequestedContractDeliveryCapacity_kW(((gridConnection.getElectricity().getGridExpansion().getRequestedKW() != null) ? gridConnection.getElectricity().getGridExpansion().getRequestedKW() : 0) + companyGC.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW());
	future_scenario_list.setRequestedContractFeedinCapacity_kW(((gridConnection.getElectricity().getGridExpansion().getRequestedKW() != null) ? gridConnection.getElectricity().getGridExpansion().getRequestedKW() : 0) + companyGC.v_liveConnectionMetaData.getContractedFeedinCapacity_kW());
	future_scenario_list.setRequestedPhysicalConnectionCapacity_kW(max(companyGC.v_liveConnectionMetaData.getPhysicalCapacity_kW(), max(future_scenario_list.getRequestedContractDeliveryCapacity_kW(), future_scenario_list.getRequestedContractFeedinCapacity_kW())));
}
else{
	future_scenario_list.setRequestedContractDeliveryCapacity_kW(companyGC.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW());
	future_scenario_list.setRequestedContractFeedinCapacity_kW(companyGC.v_liveConnectionMetaData.getContractedFeedinCapacity_kW());
	future_scenario_list.setRequestedPhysicalConnectionCapacity_kW(companyGC.v_liveConnectionMetaData.getPhysicalCapacity_kW());
}


////Supply (pv, wind, etc.)
if (gridConnection.getSupply().getHasSupply() != null && gridConnection.getSupply().getHasSupply()){
	//gridConnection.getElectricity().getAnnualElectricityProductionKwh() // Staat niet meer in het formulier!
	
	double[] yearlyElectricityProduction_kWh_array = null;
	
	var quarterHourlyProduction_kWh = gridConnection.getElectricity().getQuarterHourlyProduction_kWh();
	if (quarterHourlyProduction_kWh != null && quarterHourlyProduction_kWh.hasNumberOfValuesForOneYear()) {
		yearlyElectricityProduction_kWh_array = f_timeSeriesToQuarterHourlyDoubleArray(quarterHourlyProduction_kWh);
	}
	
	if(yearlyElectricityProduction_kWh_array == null && gridConnection.getSupply().getPvInstalledKwp() != null && gridConnection.getSupply().getPvInstalledKwp() > 0){
		try {
			if(selectFirstValue(Double.class, "SELECT " + "ccid" + companyGC.p_gridConnectionID + "_production FROM comp_elec_consumption LIMIT 1;") != null){
		  		List<Double> yearlyElectricityProduction_kWh_list = selectValues(double.class, "SELECT " + "ccid" + companyGC.p_gridConnectionID + "_production FROM comp_elec_consumption;");
				yearlyElectricityProduction_kWh_array = (yearlyElectricityProduction_kWh_list != null) ? yearlyElectricityProduction_kWh_list.stream().mapToDouble(d -> max(0,d)).toArray() : null;
			}
		}
		catch(Exception e) {
		}
	}
	if (yearlyElectricityProduction_kWh_array != null && gridConnection.getSupply().getPvInstalledKwp() != null && gridConnection.getSupply().getPvInstalledKwp() > 0 && !gridConnection.getHeat().getHeatingTypes().contains(com.zenmo.zummon.companysurvey.HeatingType.COMBINED_HEAT_AND_POWER)){
		f_createCustomPVAsset(companyGC, yearlyElectricityProduction_kWh_array, (double)gridConnection.getSupply().getPvInstalledKwp()); // Create custom PV asset when production data is available!
		
		companyGC.v_liveAssetsMetaData.PVOrientation = OL_PVOrientation.CUSTOM;
		companyGC.v_liveAssetsMetaData.initialPV_kW = (double)gridConnection.getSupply().getPvInstalledKwp();
		current_scenario_list.setCurrentPV_kW(gridConnection.getSupply().getPvInstalledKwp());
		current_scenario_list.setCurrentPV_orientation(OL_PVOrientation.CUSTOM);
	} 
	else if (gridConnection.getSupply().getPvInstalledKwp() != null && gridConnection.getSupply().getPvInstalledKwp() > 0){			
		OL_PVOrientation installedPVOrientation = f_getPVOrientationFromZorm(gridConnection.getSupply().getPvOrientation());
		f_addPVProductionAsset(companyGC, "Rooftop Solar", (double) gridConnection.getSupply().getPvInstalledKwp(), installedPVOrientation);
		
		//add to scenario: current
		companyGC.v_liveAssetsMetaData.initialPV_kW = (double)gridConnection.getSupply().getPvInstalledKwp();
		companyGC.v_liveAssetsMetaData.PVOrientation = installedPVOrientation;
		current_scenario_list.setCurrentPV_kW(gridConnection.getSupply().getPvInstalledKwp());
		current_scenario_list.setCurrentPV_orientation(installedPVOrientation);
	}
	else{
		companyGC.v_liveAssetsMetaData.initialPV_kW = 0.0;
		companyGC.v_liveAssetsMetaData.PVOrientation = avgc_data.p_defaultPVOrientation;
		current_scenario_list.setCurrentPV_kW(0);
		current_scenario_list.setCurrentPV_orientation(avgc_data.p_defaultPVOrientation);
	} 	
	//Wind
	if (gridConnection.getSupply().getWindInstalledKw() != null && gridConnection.getSupply().getWindInstalledKw() > 0){
		f_addWindProductionAsset(companyGC, "Wind mill", gridConnection.getSupply().getWindInstalledKw());

		//add to scenario: current
		current_scenario_list.setCurrentWind_kW(gridConnection.getSupply().getWindInstalledKw());
	}
}
else{
	companyGC.v_liveAssetsMetaData.initialPV_kW = 0.0;
	companyGC.v_liveAssetsMetaData.PVOrientation = avgc_data.p_defaultPVOrientation;
	current_scenario_list.setCurrentPV_kW(0);
	current_scenario_list.setCurrentPV_orientation(avgc_data.p_defaultPVOrientation);
}

//Planned supply (PV)
if (gridConnection.getSupply().getPvPlanned() != null && gridConnection.getSupply().getPvPlanned()){
	future_scenario_list.setPlannedPV_kW(current_scenario_list.getCurrentPV_kW() + (gridConnection.getSupply().getPvPlannedKwp() != null ? gridConnection.getSupply().getPvPlannedKwp() : 0)); 
	future_scenario_list.setPlannedPV_year(gridConnection.getSupply().getPvPlannedYear());
	future_scenario_list.setPlannedPV_orientation(f_getPVOrientationFromZorm(gridConnection.getSupply().getPvPlannedOrientation()));
}
else{
	future_scenario_list.setPlannedPV_kW(current_scenario_list.getCurrentPV_kW());
}

//Planned supply (Wind)
if (gridConnection.getSupply().getWindPlannedKw() != null && gridConnection.getSupply().getWindPlannedKw() > 0){
	future_scenario_list.setPlannedWind_kW(current_scenario_list.getCurrentWind_kW() + (gridConnection.getSupply().getWindPlannedKw() != null ? gridConnection.getSupply().getWindPlannedKw() : 0));
	// plannedWind_year // ???
}
else{
	future_scenario_list.setPlannedWind_kW(current_scenario_list.getCurrentWind_kW());
}

////Heating and gas
OL_GridConnectionHeatingType heatingType = f_heatingSurveyCompany(companyGC, gridConnection);

//add heating type to scenario: current and future
current_scenario_list.setCurrentHeatingType(heatingType);
future_scenario_list.setPlannedHeatingType(heatingType);


// Electric Storage
Float battery_power_kW = 0f;
Float battery_capacity_kWh = 0f;

if (gridConnection.getStorage().getHasBattery() != null && gridConnection.getStorage().getHasBattery() && createElectricEA){ // Check if battery present and if electric demand EA should be created
	if (gridConnection.getStorage().getBatteryPowerKw() != null){
		battery_power_kW = gridConnection.getStorage().getBatteryPowerKw();
	}
	if (gridConnection.getStorage().getBatteryCapacityKwh() != null){
		battery_capacity_kWh = gridConnection.getStorage().getBatteryCapacityKwh();	
	}
	
	if (battery_power_kW > 0 && battery_capacity_kWh > 0) {
		f_addStorage(companyGC, battery_power_kW, battery_capacity_kWh, OL_EnergyAssetType.STORAGE_ELECTRIC);
		companyGC.f_setBatteryManagement(new J_BatteryManagementSelfConsumption(companyGC, energyModel.p_timeParameters));
	}	
}

//add to scenario: current
current_scenario_list.setCurrentBatteryCapacity_kWh(battery_capacity_kWh);
current_scenario_list.setCurrentBatteryPower_kW(battery_power_kW);

	
	
if (gridConnection.getStorage().getHasThermalStorage() != null && gridConnection.getStorage().getHasThermalStorage()){ // Check for thermal storage
	//gridConnection.getStorage().getThermalStorageKw()
	//J_EAStorageHeat(Agent parentAgent, OL_EAStorageTypes heatStorageType, double capacityHeat_kW, double lossFactor_WpK, double timestep_h, double initialTemperature_degC, double minTemperature_degC, double maxTemperature_degC, double setTemperature_degC, double heatCapacity_JpK, String ambientTempType ) {
	//J_EAStorageHeat(companyGC, OL_EAStorageTypes heatStorageType, double capacityHeat_kW, double lossFactor_WpK, double timestep_h, double initialTemperature_degC, double minTemperature_degC, double maxTemperature_degC, double setTemperature_degC, double heatCapacity_JpK, String ambientTempType ) {
	//Denk ook aan aansturing?!!
}

if (gridConnection.getStorage().getHasPlannedBattery() != null && gridConnection.getStorage().getHasPlannedBattery()){ // Check for planned battery
	future_scenario_list.setPlannedBatteryCapacity_kWh((gridConnection.getStorage().getPlannedBatteryCapacityKwh() != null ? gridConnection.getStorage().getPlannedBatteryCapacityKwh() : 0) + current_scenario_list.getCurrentBatteryCapacity_kWh());
	future_scenario_list.setPlannedBatteryPower_kW((gridConnection.getStorage().getPlannedBatteryPowerKw() != null ? gridConnection.getStorage().getPlannedBatteryPowerKw() : 0) + current_scenario_list.getCurrentBatteryPower_kW());
}
else{
future_scenario_list.setPlannedBatteryCapacity_kWh(current_scenario_list.getCurrentBatteryCapacity_kWh());
future_scenario_list.setPlannedBatteryPower_kW(current_scenario_list.getCurrentBatteryPower_kW());
}



////Transport

//Cars of comuters and visitors 
int nbDailyCarVisitors_notNull = (gridConnection.getTransport().getNumDailyCarVisitors() != null) ? gridConnection.getTransport().getNumDailyCarVisitors() : 0;
int nbDailyCarCommuters_notNull = (gridConnection.getTransport().getNumDailyCarAndVanCommuters() != null) ? gridConnection.getTransport().getNumDailyCarAndVanCommuters() : 0;

if (nbDailyCarCommuters_notNull + nbDailyCarVisitors_notNull > 0){	
	
	int nbEVCarsComute = (gridConnection.getTransport().getNumCommuterAndVisitorChargePoints() != null) ? gridConnection.getTransport().getNumCommuterAndVisitorChargePoints() : 0; // Wat doen we hier mee????
	int nbPetroleumFuelCarsComute = max(0, nbDailyCarCommuters_notNull + nbDailyCarVisitors_notNull - nbEVCarsComute);

	boolean isDefaultVehicle = true;
	double maxChargingPower_kW 		= avgc_data.p_avgEVMaxChargePowerCar_kW;	
	
	for (int i = 0; i< nbPetroleumFuelCarsComute; i++){
		f_addPetroleumFuelVehicle(companyGC, OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE, isDefaultVehicle, 0);
	}
	
	
	//check if charge power is filled in
	if (nbEVCarsComute > 0 && gridConnection.getTransport().getCars().getPowerPerChargePointKw() != null){
		if (gridConnection.getTransport().getCars().getPowerPerChargePointKw() <= 0) {
			traceln("Survey data contains no/negative Car maxChargingPower_kW: %s", gridConnection.getTransport().getCars().getPowerPerChargePointKw());
		}
		else{
			maxChargingPower_kW 		= gridConnection.getTransport().getCars().getPowerPerChargePointKw();		
			isDefaultVehicle			= false;
		}
	}
	
	if (createElectricEA){ // Check if electric demand EA should be created
		for (int j = 0; j< nbEVCarsComute; j++){
			f_addElectricVehicle(companyGC, OL_EnergyAssetType.ELECTRIC_VEHICLE, isDefaultVehicle, 0, maxChargingPower_kW);
		}
	}
	
	//add to scenario: current
	current_scenario_list.setCurrentEVCars(nbEVCarsComute);
	current_scenario_list.setCurrentPetroleumFuelCars(nbPetroleumFuelCarsComute);
	
	//Initialize future cars
	future_scenario_list.setPlannedEVCars(current_scenario_list.getCurrentEVCars());

}


//Business vehicles
if (gridConnection.getTransport().getHasVehicles() != null && gridConnection.getTransport().getHasVehicles()){

	//Cars
	if (gridConnection.getTransport().getCars().getNumCars() != null && gridConnection.getTransport().getCars().getNumCars() != 0){
		
		
		//Update remaning amount of cars (company owned only)
		p_remainingTotals.adjustRemainingNumberOfVehiclesCompanies(companyGC, OL_VehicleType.VAN, - gridConnection.getTransport().getCars().getNumCars());
		
		//Get amount of EV and petroleumFuel cars
		Integer nbEVCars = gridConnection.getTransport().getCars().getNumElectricCars();
		if (nbEVCars == null) {
		    nbEVCars = 0;
		}
		int nbPetroleumFuelCars = gridConnection.getTransport().getCars().getNumCars() - nbEVCars;
		
		//Initialize parameters
		boolean isDefaultVehicle		= true;
		double annualTravelDistance_km 	= 0;
		double maxChargingPower_kW 		= avgc_data.p_avgEVMaxChargePowerCar_kW;
		
		//check if annual travel distance is filled in
		if (gridConnection.getTransport().getCars().getAnnualTravelDistancePerCarKm() != null){
			annualTravelDistance_km 	= gridConnection.getTransport().getCars().getAnnualTravelDistancePerCarKm();
			isDefaultVehicle			= false;
		}
		
		//create petroleumFuel vehicle
		for (int i = 0; i< nbPetroleumFuelCars; i++){
			f_addPetroleumFuelVehicle(companyGC, OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE, isDefaultVehicle, annualTravelDistance_km);
		}
		
		//Get number of chargepoints if filled in
		//int numberOfChargepointsBusinessCars = gridConnection.getTransport().getCars().getNumChargePoints() !=  null ? gridConnection.getTransport().getCars().getNumChargePoints() : 0;
				
		//check if charge power is filled in
		if (nbEVCars > 0 && gridConnection.getTransport().getCars().getPowerPerChargePointKw() != null){
			if (gridConnection.getTransport().getCars().getPowerPerChargePointKw() <= 0) {
				traceln("Survey data contains no/negative Car maxChargingPower_kW: %s", gridConnection.getTransport().getCars().getPowerPerChargePointKw());
			}
			else{
				maxChargingPower_kW 		= gridConnection.getTransport().getCars().getPowerPerChargePointKw();		
				isDefaultVehicle			= false;
			}		
		}
		
		//create EV
		if (createElectricEA){ // Check if electric demand EA should be created
			for (int j = 0; j< nbEVCars; j++){
				f_addElectricVehicle(companyGC, OL_EnergyAssetType.ELECTRIC_VEHICLE, isDefaultVehicle, annualTravelDistance_km, maxChargingPower_kW);
			}
		}
		
		//add to scenario: current
		current_scenario_list.setCurrentEVCars(((current_scenario_list.getCurrentEVCars() != null) ? current_scenario_list.getCurrentEVCars() : 0) + nbEVCars);
		current_scenario_list.setCurrentPetroleumFuelCars(((current_scenario_list.getCurrentPetroleumFuelCars() != null) ? current_scenario_list.getCurrentPetroleumFuelCars() : 0) + nbPetroleumFuelCars);
		current_scenario_list.setCurrentEVCarChargePower_kW(maxChargingPower_kW);
		
		//Update Planned cars
		future_scenario_list.setPlannedEVCars((gridConnection.getTransport().getCars().getNumPlannedElectricCars() != null ? gridConnection.getTransport().getCars().getNumPlannedElectricCars() : 0) + current_scenario_list.getCurrentEVCars());
		future_scenario_list.setPlannedHydrogenCars((gridConnection.getTransport().getCars().getNumPlannedHydrogenCars() != null) ? gridConnection.getTransport().getCars().getNumPlannedHydrogenCars() : 0);
		
	}
	
	
	//Vans
	if (gridConnection.getTransport().getVans().getNumVans() != null && gridConnection.getTransport().getVans().getNumVans() != 0){
		
		//Update remaning amount of vans
		p_remainingTotals.adjustRemainingNumberOfVehiclesCompanies(companyGC, OL_VehicleType.VAN, - gridConnection.getTransport().getVans().getNumVans());
		
		Integer nbEVVans = gridConnection.getTransport().getVans().getNumElectricVans();	
		if (nbEVVans == null) {
		    nbEVVans = 0;
		}	
		int nbPetroleumFuelVans = gridConnection.getTransport().getVans().getNumVans() - nbEVVans;

		boolean isDefaultVehicle		= true;
		double annualTravelDistance_km 	= 0;
		double maxChargingPower_kW 		= avgc_data.p_avgEVMaxChargePowerVan_kW;		
		
		//check if annual travel distance is filled in
		if (gridConnection.getTransport().getVans().getAnnualTravelDistancePerVanKm() != null){
			annualTravelDistance_km 	= gridConnection.getTransport().getVans().getAnnualTravelDistancePerVanKm();
			isDefaultVehicle			= false;
		}
		
		//create petroleumFuel vehicles
		for (int i = 0; i< nbPetroleumFuelVans; i++){
			f_addPetroleumFuelVehicle(companyGC, OL_EnergyAssetType.PETROLEUM_FUEL_VAN, isDefaultVehicle, annualTravelDistance_km);
		}
		
		//Get number of chargepoints if filled in
		//int numberOfChargepointsVans = gridConnection.getTransport().getVans().getNumChargePoints() !=  null ? gridConnection.getTransport().getVans().getNumChargePoints() : 0;
				
				
		//check if charge power is filled in
		if (nbEVVans > 0 && gridConnection.getTransport().getVans().getPowerPerChargePointKw() != null){
			if (gridConnection.getTransport().getVans().getPowerPerChargePointKw() < 0) {
				traceln("Survey data contains no/negative Van maxChargingPower_kW: %s", gridConnection.getTransport().getVans().getPowerPerChargePointKw());
			}
			else{
				maxChargingPower_kW 		= gridConnection.getTransport().getVans().getPowerPerChargePointKw();	
				isDefaultVehicle			= false;
			}		
		}
		
		//create electric vehicles
		if (createElectricEA){ // Check if electric demand EA should be created
			for (int j = 0; j< nbEVVans; j++){
				f_addElectricVehicle(companyGC, OL_EnergyAssetType.ELECTRIC_VAN, isDefaultVehicle, annualTravelDistance_km, maxChargingPower_kW);
			}
		}
		
		//add to scenario: current
		current_scenario_list.setCurrentEVVans(nbEVVans);
		current_scenario_list.setCurrentPetroleumFuelVans(nbPetroleumFuelVans);
		current_scenario_list.setCurrentEVVanChargePower_kW(maxChargingPower_kW);
		
		//Planned
		future_scenario_list.setPlannedEVVans((gridConnection.getTransport().getVans().getNumPlannedElectricVans() != null ? gridConnection.getTransport().getVans().getNumPlannedElectricVans() : 0) + current_scenario_list.getCurrentEVVans());
		future_scenario_list.setPlannedHydrogenVans((gridConnection.getTransport().getVans().getNumPlannedHydrogenVans() != null) ? gridConnection.getTransport().getVans().getNumPlannedHydrogenVans() : 0);
	}
	
		
	
	//Trucks
	if (gridConnection.getTransport().getTrucks().getNumTrucks() != null && gridConnection.getTransport().getTrucks().getNumTrucks() != 0){
		
		//Update remaning amount of trucks
		p_remainingTotals.adjustRemainingNumberOfVehiclesCompanies(companyGC, OL_VehicleType.TRUCK, - gridConnection.getTransport().getTrucks().getNumTrucks());

		Integer nbEVTrucks = gridConnection.getTransport().getTrucks().getNumElectricTrucks();		
		if (nbEVTrucks == null) {
		    nbEVTrucks = 0;
		}
		int nbPetroleumFuelTrucks = gridConnection.getTransport().getTrucks().getNumTrucks() - nbEVTrucks;
	
		boolean isDefaultVehicle		= true;
		double annualTravelDistance_km = 0;
		double maxChargingPower_kW = avgc_data.p_avgEVMaxChargePowerTruck_kW;
		
		//check if annual travel distance is filled in
		if (gridConnection.getTransport().getTrucks().getAnnualTravelDistancePerTruckKm() != null){
			annualTravelDistance_km 	= gridConnection.getTransport().getTrucks().getAnnualTravelDistancePerTruckKm();
			isDefaultVehicle			= false;
		}
		
		//create petroleumFuel vehicles
		for (int i = 0; i< nbPetroleumFuelTrucks; i++){
			f_addPetroleumFuelVehicle(companyGC, OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK, isDefaultVehicle, annualTravelDistance_km);
		}
		
		//Get number of chargepoints if filled in
		//int numberOfChargepointsVans = gridConnection.getTransport().getTrucks().getNumChargePoints() !=  null ? gridConnection.getTransport().getTrucks().getNumChargePoints() : 0;
			
			
		//check if charge power is filled in
		if (nbEVTrucks > 0 && gridConnection.getTransport().getTrucks().getPowerPerChargePointKw() != null){
			if (gridConnection.getTransport().getTrucks().getPowerPerChargePointKw() <= 0) {
				traceln("Survey data contains no/negative Truck maxChargingPower_kW: %s", gridConnection.getTransport().getTrucks().getPowerPerChargePointKw());
			}
			else{
				maxChargingPower_kW 		= gridConnection.getTransport().getTrucks().getPowerPerChargePointKw();
				isDefaultVehicle			= false;
			}		
		}
		
		//create electric vehicles
		if (createElectricEA){ // Check if electric demand EA should be created
			for (int j = 0; j< nbEVTrucks; j++){
				f_addElectricVehicle(companyGC, OL_EnergyAssetType.ELECTRIC_TRUCK, isDefaultVehicle, annualTravelDistance_km, maxChargingPower_kW);
			}
		}
		
		//add to scenario: current
		current_scenario_list.setCurrentEVTrucks(nbEVTrucks);
		current_scenario_list.setCurrentPetroleumFuelTrucks(nbPetroleumFuelTrucks);
		current_scenario_list.setCurrentEVTruckChargePower_kW(maxChargingPower_kW);
		
		//Planned
		future_scenario_list.setPlannedEVTrucks((gridConnection.getTransport().getTrucks().getNumPlannedElectricTrucks() != null ? gridConnection.getTransport().getTrucks().getNumPlannedElectricTrucks() : 0) + current_scenario_list.getCurrentEVTrucks());
		future_scenario_list.setPlannedHydrogenTrucks((gridConnection.getTransport().getTrucks().getNumPlannedHydrogenTrucks() != null) ? gridConnection.getTransport().getTrucks().getNumPlannedHydrogenTrucks() : 0);
	}
	
	//Other
	if (Objects.nonNull(gridConnection.getTransport().getOtherVehicles().getHasOtherVehicles())){
		// Wat doen we hier mee???
	}
}

//Set Default charging management if EV is present
if(companyGC.c_electricVehicles.size() + companyGC.c_chargingSessions.size() > 0){
	companyGC.f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
}

//Add tractors
f_createPetroleumFuelTractors(companyGC, gridConnection.getTransport().getAgriculture());

//Save if building is paused at start
current_scenario_list.setIsCurrentlyActive(companyGC.v_isActive);
future_scenario_list.setIsActiveInFuture(companyGC.v_isActive); 
  }

  
Building_data 
 f_createBuildingData_Vallum( GridConnection companyGC, String PandID ) { 

com.zenmo.bag.Pand pand_data_vallum = map_buildingData_Vallum.get(PandID);

Building_data building_data_record = null;
if(pand_data_vallum != null){ // Only happens if building has been selected in survey, that is no longer available in BAG (Destroyed for example).
	//Calculate surface area
	GISRegion gisRegion = zero_Interface.f_createGISObject(f_createGISObjectTokens(pand_data_vallum.getGeometry().toString(), OL_GISObjectType.BUILDING));
	double surfaceArea_m2 = gisRegion.area();
	gisRegion.remove();
	
	
	//Create a building_data record
	building_data_record = Building_data.builder().
	
	address_id("verblijfsobject." + PandID).
	building_id(PandID).
	streetname(companyGC.p_address.getStreetName()).
	house_number(companyGC.p_address.getHouseNumber()).
	house_letter(companyGC.p_address.getHouseLetter()).
	house_addition(companyGC.p_address.getHouseAddition()).
	postalcode(companyGC.p_address.getPostalcode()).
	city(companyGC.p_address.getPostalcode()).
	build_year(pand_data_vallum.getBouwjaar()).	
	status(pand_data_vallum.getStatus()).
	//purpose(row.get( buildings.purpose )).
	address_floor_surface_m2(surfaceArea_m2).
	polygon_area_m2(surfaceArea_m2).
	annotation(companyGC.p_owner.p_actorID).
	//extra_info(row.get( buildings.extra_info )).
	//gridnode_id(row.get( buildings.gridnode_id )).
	//latitude(row.get( buildings.latitude )).
	//longitude(row.get( buildings.longitude )).
	polygon(pand_data_vallum.getGeometry().toString()).
	build();
}
else{
	traceln("WARNING: SELECTED BUILDING IN SURVEY IS NO LONGER IN THE BAG DATABASE -> BUILDING CAN/HAS NOT BE(EN) CREATED!");
}

return building_data_record; 
  }

  protected void f_createPetroleumFuelTractors( GridConnection companyGridConnection, com.zenmo.zummon.companysurvey.Agriculture agricultureSurveyData ) { 

final double annualPetroleumFuel_L = Optional.ofNullable(agricultureSurveyData.getAnnualDieselUsage_L()).orElse(0.0);
final int numTractors = Optional.ofNullable(agricultureSurveyData.getNumTractors()).orElse(annualPetroleumFuel_L > 0.0 ? 1 : 0);

if (numTractors > 0 && annualPetroleumFuel_L <= 0.0) {
    // TODO: this should be in Tractor constructor
    throw new RuntimeException("Tractor petroleumFuel usage missing for " + companyGridConnection.p_gridConnectionID);
}

CustomProfile_data tractorProfile = findFirst(c_customProfiles_data, profile -> profile.customProfileID().equals("TractorProfile")); ///????

for (int i = 0; i < numTractors; i++) {
	if(tractorProfile == null){
		throw new RuntimeException("Trying to make a tractor, without having loaded in a tractor profile for GC: " + companyGridConnection.p_gridConnectionID);
	}
    new J_EAPetroleumFuelTractor(companyGridConnection, annualPetroleumFuel_L / numTractors, tractorProfile.getValuesArray(), energyModel.p_timeParameters);
} 
  }

  protected 
boolean 
 f_createElectricityTimeSeriesAssets( GridConnection gridConnection, com.zenmo.zummon.companysurvey.GridConnection gridConnectionSurvey ) { 

var electricitySurvey = gridConnectionSurvey.getElectricity();

double[] deliveryTimeSeries_kWh = f_timeSeriesToQuarterHourlyDoubleArray(electricitySurvey.getQuarterHourlyDelivery_kWh());
if (deliveryTimeSeries_kWh == null) {
	// delivery is the minimum we require to do anything with timeseries data
	return false;
}

double[] feedInTimeSeries_kWh = f_timeSeriesToQuarterHourlyDoubleArray(electricitySurvey.getQuarterHourlyFeedIn_kWh());
double[] productionTimeSeries_kWh = f_timeSeriesToQuarterHourlyDoubleArray(electricitySurvey.getQuarterHourlyProduction_kWh());

Double pvPower_kW = Optional.ofNullable(gridConnectionSurvey.getSupply().getPvInstalledKwp())
	.map(it -> (double) it)
	.orElse(null);

double[] heatPumpElectricityTimeSeries_kWh = f_timeSeriesToQuarterHourlyDoubleArray(gridConnectionSurvey.getHeat().getHeatPumpElectricityConsumptionTimeSeries_kWh());

//Preprocess the arrays and create the consumption pattern
f_createPreprocessedElectricityProfile_PV(gridConnection, deliveryTimeSeries_kWh, feedInTimeSeries_kWh, productionTimeSeries_kWh, pvPower_kW, heatPumpElectricityTimeSeries_kWh);

gridConnection.v_hasQuarterHourlyValues = true;

return true; 
  }

  public 
double[] 
 f_timeSeriesToQuarterHourlyDoubleArray( com.zenmo.zummon.companysurvey.TimeSeries timeSeries ) { 

int targetYear = energyModel.p_timeParameters.getStartYear();
if (timeSeries == null) {
	return null;
}

if (!timeSeries.hasNumberOfValuesForOneYear()) {
	String errorString = "Time series has too few values for one year";
	System.err.println(errorString);
	return null;
}

return f_convertFloatArrayToDoubleArray(timeSeries.convertToQuarterHourly().getFullYearOrFudgeIt(targetYear)); 
  }

  protected void f_connectGCToExistingBuilding( GridConnection connectingGC, GIS_Building existingBuilding, Building_data connectingBuildingData ) { 

//Get the total roof surface of the building
double buildingRoofSurface = existingBuilding.p_roofSurfaceArea_m2;

//Building roof surface removal from all earlier connected GC (so excluding the new one!)
int currentAmountOfConnectedGCWithBuilding = existingBuilding.c_containedGridConnections.size();
for(GridConnection earlierConnectedGC : existingBuilding.c_containedGridConnections){
	earlierConnectedGC.p_roofSurfaceArea_m2 -= buildingRoofSurface/currentAmountOfConnectedGCWithBuilding;
	
	if(earlierConnectedGC.p_roofSurfaceArea_m2 < 0){
		new RuntimeException("Negative roofsurface for GC: " + earlierConnectedGC.p_gridConnectionID + " after removal of earlier distributed building roofsurface. This should never be possible!");
	}
}

//Connect new GC to the building now
existingBuilding.c_containedGridConnections.add(connectingGC);
connectingGC.c_connectedGISObjects.add(existingBuilding);


//Adding the newly distributed roof surfaces to the gc (now including the new one!)
int newAmountOfConnectedGCWithBuilding = currentAmountOfConnectedGCWithBuilding + 1;
for(GridConnection connectedGC : existingBuilding.c_containedGridConnections){
	connectedGC.p_roofSurfaceArea_m2 += buildingRoofSurface/newAmountOfConnectedGCWithBuilding;
}

//Also add the new connecting building data address floor surface
existingBuilding.p_floorSurfaceArea_m2 += connectingBuildingData.address_floor_surface_m2(); 
  }

  protected void f_addHeatAsset( GridConnection parentGC, OL_GridConnectionHeatingType heatAssetType, double maxHeatOutputPower_kW ) { 

//Initialize parameters
double heatOutputCapacityGasBurner_kW;
double inputCapacityElectric_kW;
double efficiency;
double baseTemperature_degC;
double outputTemperature_degC;
OL_AmbientTempType ambientTempType;
double sourceAssetHeatPower_kW;
double belowZeroHeatpumpEtaReductionFactor;
if(parentGC.p_BuildingThermalAsset == null){
	maxHeatOutputPower_kW = maxHeatOutputPower_kW*2; // Make the asset capacity twice as high, to make sure it can handle the load in other scenarios with more heat consumption.
}

switch (heatAssetType){ // There is always only one heatingType, If there are many assets the type is CUSTOM

	case GAS_BURNER:
		heatOutputCapacityGasBurner_kW = max(avgc_data.p_minGasBurnerOutputCapacity_kW, maxHeatOutputPower_kW);
		J_EAConversionGasBurner gasBurner = new J_EAConversionGasBurner(parentGC, heatOutputCapacityGasBurner_kW , avgc_data.p_avgEfficiencyGasBurner_fr, energyModel.p_timeParameters, 90);
		break;
	
	case HYBRID_HEATPUMP:
	
		//Add primary heating asset (heatpump) (if its not part of the basic profile already
		inputCapacityElectric_kW = max(avgc_data.p_minHeatpumpElectricCapacity_kW, maxHeatOutputPower_kW / 3); //-- /3, kan nog kleiner want is hybride zodat gasbrander ook bij springt, dus kleiner MOETEN aanname voor hoe klein onderzoeken
		efficiency = avgc_data.p_avgEfficiencyHeatpump_fr;
		baseTemperature_degC = zero_Interface.energyModel.pp_ambientTemperature_degC.getCurrentValue();
		outputTemperature_degC = avgc_data.p_avgOutputTemperatureHybridHeatpump_degC;
		ambientTempType = OL_AmbientTempType.AMBIENT_AIR;
		sourceAssetHeatPower_kW = 0;
		belowZeroHeatpumpEtaReductionFactor = 1;
		
		J_EAConversionHeatPump heatPumpHybrid = new J_EAConversionHeatPump(parentGC, inputCapacityElectric_kW, efficiency, energyModel.p_timeParameters, outputTemperature_degC, baseTemperature_degC, sourceAssetHeatPower_kW, belowZeroHeatpumpEtaReductionFactor, ambientTempType);

		zero_Interface.energyModel.c_ambientDependentAssets.add(heatPumpHybrid);
		
		//Add secondary heating asset (gasburner)
		heatOutputCapacityGasBurner_kW = max(avgc_data.p_minGasBurnerOutputCapacity_kW, maxHeatOutputPower_kW);
		efficiency = avgc_data.p_avgEfficiencyGasBurner_fr;
		outputTemperature_degC = avgc_data.p_avgOutputTemperatureGasBurner_degC;
		
		J_EAConversionGasBurner gasBurnerHybrid = new J_EAConversionGasBurner(parentGC, heatOutputCapacityGasBurner_kW, efficiency, energyModel.p_timeParameters, outputTemperature_degC);		
		break;
	
	case ELECTRIC_HEATPUMP:
		//Add primary heating asset (heatpump)
		inputCapacityElectric_kW = max(avgc_data.p_minHeatpumpElectricCapacity_kW, maxHeatOutputPower_kW); // Could be a lot smaller due to high cop
		efficiency = avgc_data.p_avgEfficiencyHeatpump_fr;
		baseTemperature_degC = zero_Interface.energyModel.pp_ambientTemperature_degC.getCurrentValue();
		outputTemperature_degC = avgc_data.p_avgOutputTemperatureElectricHeatpump_degC;
		ambientTempType = OL_AmbientTempType.AMBIENT_AIR;
		sourceAssetHeatPower_kW = 0;
		belowZeroHeatpumpEtaReductionFactor = 1;
		
		new J_EAConversionHeatPump(parentGC, inputCapacityElectric_kW, efficiency, energyModel.p_timeParameters, outputTemperature_degC, baseTemperature_degC, sourceAssetHeatPower_kW, belowZeroHeatpumpEtaReductionFactor, ambientTempType );		
		break;

	case GAS_CHP:
		
		double outputCapacityElectric_kW = (maxHeatOutputPower_kW/avgc_data.p_avgEfficiencyCHP_thermal_fr) * avgc_data.p_avgEfficiencyCHP_electric_fr;
		outputTemperature_degC = avgc_data.p_avgOutputTemperatureCHP_degC;
		efficiency = avgc_data.p_avgEfficiencyCHP_thermal_fr + avgc_data.p_avgEfficiencyCHP_electric_fr;
		
		new J_EAConversionGasCHP(parentGC, outputCapacityElectric_kW, maxHeatOutputPower_kW, efficiency, energyModel.p_timeParameters, outputTemperature_degC );
		break;

	case DISTRICTHEAT:
		double heatOutputCapacityDeliverySet_kW = max(avgc_data.p_minDistrictHeatingDeliverySetOutputCapacity_kW, maxHeatOutputPower_kW);
		outputTemperature_degC = avgc_data.p_avgOutputTemperatureDistrictHeatingDeliverySet_degC;
		efficiency = avgc_data.p_avgEfficiencyDistrictHeatingDeliverySet_fr;
		
		new J_EAConversionHeatDeliverySet(parentGC, heatOutputCapacityDeliverySet_kW, efficiency, energyModel.p_timeParameters, outputTemperature_degC);
		
		//Add GC to heat grid
		GridNode heatgrid = findFirst(energyModel.pop_gridNodes, node -> node.p_energyCarrier == OL_EnergyCarriers.HEAT);
		if(heatgrid == null){
			heatgrid = f_createHeatGridNode();
		}
		parentGC.p_parentNodeHeatID = heatgrid.p_gridNodeID;	
		break;
		
	case CUSTOM:
		f_addCustomHeatAsset(parentGC, maxHeatOutputPower_kW);
		break;
		
	default:
		traceln("HEATING TYPE NOT FOUND FOR GC: " + parentGC);
}											 
  }

  
GridNode 
 f_createHeatGridNode(  ) { 

GridNode GN_heat = energyModel.add_pop_gridNodes();
GN_heat.p_gridNodeID = "Heatgrid";

// Check wether transformer capacity is known or estimated
GN_heat.p_capacity_kW = 1000000;	
GN_heat.p_realCapacityAvailable = false;

// Basic GN information
GN_heat.p_description = "Warmtenet";

/*
//Owner
GN_heat.p_ownerGridOperator = Grid_Operator;
*/

//Define node type
GN_heat.p_nodeType = OL_GridNodeType.HT;
GN_heat.p_energyCarrier = OL_EnergyCarriers.HEAT;

//Define GN location
GN_heat.p_latitude = 0;
GN_heat.p_longitude = 0;
GN_heat.setLatLon(GN_heat.p_latitude, GN_heat.p_longitude);

//Create gis region
/*
GN.gisRegion = zero_Interface.f_createGISObject(f_createGISNodesTokens(GN));
zero_Interface.f_styleGridNodes(GN);
zero_Interface.c_GISNodes.add(GN.gisRegion);
*/

return GN_heat; 
  }

  protected void f_addSliderSolarfarm( String sliderGCID, String gridNodeID ) { 

c_solarfarm_data.add(0, Solarfarm_data.builder().
isSliderGC(true).

gc_id(sliderGCID).
gc_name("Slider solarfarm").
owner_id("Slider solarfarm owner").
streetname(null).
house_number(null).
house_letter(null).
house_addition(null).
postalcode(null).
city(null).
gridnode_id(gridNodeID).
initially_active(false).

orientation(OL_PVOrientation.SOUTH).

capacity_electric_kw(0.0).
connection_capacity_kw(0.0).
contracted_delivery_capacity_kw(0.0).
contracted_feed_in_capacity_kw(0.0).

latitude(0).
longitude(0).
polygon(null).
build()); 
  }

  protected void f_addSliderWindfarm( String sliderGCID, String gridNodeID ) { 

c_windfarm_data.add(0, Windfarm_data.builder().
isSliderGC(true).

gc_id(sliderGCID).
gc_name("Slider windfarm").
owner_id("Slider windfarm owner").
streetname(null).
house_number(null).
house_letter(null).
house_addition(null).
postalcode(null).
city(null).
gridnode_id(gridNodeID).
initially_active(false).

capacity_electric_kw(0.0).
connection_capacity_kw(0.0).
contracted_delivery_capacity_kw(0.0).
contracted_feed_in_capacity_kw(0.0).

latitude(0).
longitude(0).
polygon(null).
build());
 
  }

  protected void f_addSliderBattery( String sliderGCID, String gridNodeID ) { 

c_battery_data.add(0, Battery_data.builder().
isSliderGC(true).

gc_id(sliderGCID).
gc_name("Slider battery").
owner_id("Slider battery owner").
streetname(null).
house_number(null).
house_letter(null).
house_addition(null).
postalcode(null).
city(null).
gridnode_id(gridNodeID).
initially_active(false).

capacity_electric_kw(0.0).
connection_capacity_kw(0.0).
contracted_delivery_capacity_kw(0.0).
contracted_feed_in_capacity_kw(0.0).

storage_capacity_kwh(0.0).
operation_mode(OL_BatteryOperationMode.PEAK_SHAVING_PARENT_NODE).
latitude(0).
longitude(0).
polygon(null).
build()); 
  }

  protected void f_initializeSpecificSliderGC(  ) { 

//Create slider GC data packages for assetGC that do not have a sliderGC data package yet 
Solarfarm_data sliderSolarfarm_data = findFirst(c_solarfarm_data, sf_data -> sf_data.isSliderGC());
Windfarm_data sliderWindfarm_data = findFirst(c_windfarm_data, wf_data -> wf_data.isSliderGC());
Battery_data sliderBattery_data = findFirst(c_battery_data, bat_data -> bat_data.isSliderGC());

//Get top gridnode id
GridNode_data topGridNode = findFirst(c_gridNode_data, node_data -> node_data.type() == OL_GridNodeType.HVMV);
if ( topGridNode == null ) {
	throw new RuntimeException("Unable to find top GridNode of type HVMV to create slider assets.");
}
String topGridNodeID = topGridNode.gridnode_id();

//Create data package for e-hub dashboard slider gcs
if(project_data.project_type() == OL_ProjectType.BUSINESSPARK){
	f_addSliderSolarfarm(zero_Interface.p_defaultEnergyHubSliderGCName_solarfarm, topGridNodeID);
	f_addSliderWindfarm(zero_Interface.p_defaultEnergyHubSliderGCName_windfarm, topGridNodeID);
	f_addSliderBattery(zero_Interface.p_defaultEnergyHubSliderGCName_battery, topGridNodeID);
}

//If no slider data package is present yet for the main: add one as well.
if(sliderSolarfarm_data == null){
	f_addSliderSolarfarm(zero_Interface.p_defaultMainSliderGCName_solarfarm, topGridNodeID);
}
if(sliderWindfarm_data == null){
	f_addSliderWindfarm(zero_Interface.p_defaultMainSliderGCName_windfarm, topGridNodeID);
}
if(project_data.project_type() == OL_ProjectType.RESIDENTIAL){
	for(GridNode_data nodeData : c_gridNode_data){
		f_addSliderBattery(zero_Interface.p_defaultMainSliderGCName_battery + " " + nodeData.gridnode_id(), nodeData.gridnode_id());
	}
}
else{
	if(sliderBattery_data == null){
		f_addSliderBattery(zero_Interface.p_defaultMainSliderGCName_battery, topGridNodeID);
	}
} 
  }

  /**
   * Functie van gillis voor inladen weer data!
   */
  public 
J_ProfilePointer 
 f_createEngineProfile( String profileID, double[] arguments, double[] values, OL_ProfileUnits profileUnitType ) { 

J_ProfilePointer profilePointer = f_createProfilePointer(profileID, arguments, values, profileUnitType, null);

energyModel.f_addProfile(profilePointer);
return profilePointer; 
  }

  /**
   * Functie van gillis voor inladen weer data!
   */
  public void f_setEngineProfiles(  ) { 

//Profile Arguments
double[] a_arguments_hr = ListUtil.doubleListToArray(defaultProfiles_data.arguments_hr());

//Weather data
double[] a_ambientTemperatureProfile_degC = ListUtil.doubleListToArray(defaultProfiles_data.ambientTemperatureProfile_degC());
double[] a_PVProductionProfile35DegSouth_fr = ListUtil.doubleListToArray(defaultProfiles_data.PVProductionProfile35DegSouth_fr());
double[] a_PVProductionProfile15DegEastWest_fr = ListUtil.doubleListToArray(defaultProfiles_data.PVProductionProfile15DegEastWest_fr());
double[] a_windProductionProfile_fr = ListUtil.doubleListToArray(defaultProfiles_data.windProductionProfile_fr());

//EPEX data
double[] a_epexProfile_eurpMWh = ListUtil.doubleListToArray(defaultProfiles_data.epexProfile_eurpMWh()); 

//CO2 emission data
double[] a_CO2EmissionFactorElectricityImport_kgpkWh = ListUtil.doubleListToArray(defaultProfiles_data.CO2EmissionFactorElectricityImport_kgpkWh()); 

//Various demand data
double[] a_defaultHouseElectricityDemandProfile_fr = ListUtil.doubleListToArray(defaultProfiles_data.defaultHouseElectricityDemandProfile_fr());
double[] a_defaultHouseHotWaterDemandProfile_fr = ListUtil.doubleListToArray(defaultProfiles_data.defaultHouseHotWaterDemandProfile_fr());
double[] a_defaultHouseCookingDemandProfile_fr = ListUtil.doubleListToArray(defaultProfiles_data.defaultHouseCookingDemandProfile_fr());
double[] a_defaultOfficeElectricityDemandProfile_fr = ListUtil.doubleListToArray(defaultProfiles_data.defaultOfficeElectricityDemandProfile_fr());
double[] a_defaultBuildingHeatDemandProfile_fr = ListUtil.doubleListToArray(defaultProfiles_data.defaultBuildingHeatDemandProfile_fr());

//Create Weather engine profiles
energyModel.pp_ambientTemperature_degC = f_createEngineProfile("ambient_temperature_degC", a_arguments_hr, a_ambientTemperatureProfile_degC, OL_ProfileUnits.TEMPERATURE_DEGC);
energyModel.pp_PVProduction35DegSouth_fr = f_createEngineProfile("pv_production_35degsouth_fr", a_arguments_hr, a_PVProductionProfile35DegSouth_fr, OL_ProfileUnits.NORMALIZEDPOWER);
energyModel.pp_PVProduction15DegEastWest_fr = f_createEngineProfile("pv_production_15degeastwest_fr", a_arguments_hr, a_PVProductionProfile15DegEastWest_fr, OL_ProfileUnits.NORMALIZEDPOWER);
energyModel.pp_windProduction_fr = f_createEngineProfile("wind_production_fr", a_arguments_hr, a_windProductionProfile_fr, OL_ProfileUnits.NORMALIZEDPOWER);

//Create Epex engine profile
energyModel.pp_dayAheadElectricityPricing_eurpMWh = f_createEngineProfile("epex_price_eurpMWh", a_arguments_hr, a_epexProfile_eurpMWh, OL_ProfileUnits.PRICE_EURPMWH);

//Create CO2 emission engine profile
energyModel.pp_CO2EmissionFactorElectricityImport_kgpkWh = f_createEngineProfile("CO2EmissionFactorElectricityImport_kgpkWh", a_arguments_hr, a_CO2EmissionFactorElectricityImport_kgpkWh, OL_ProfileUnits.CO2EMISSION_KGPKWH);

//Create Consumption engine profiles:
f_createEngineProfile("default_house_electricity_demand_fr", a_arguments_hr, a_defaultHouseElectricityDemandProfile_fr, OL_ProfileUnits.YEARLYTOTALFRACTION);
f_createEngineProfile("default_house_hot_water_demand_fr", a_arguments_hr, a_defaultHouseHotWaterDemandProfile_fr, OL_ProfileUnits.YEARLYTOTALFRACTION);
f_createEngineProfile("default_house_cooking_demand_fr", a_arguments_hr, a_defaultHouseCookingDemandProfile_fr, OL_ProfileUnits.YEARLYTOTALFRACTION);
f_createEngineProfile("default_office_electricity_demand_fr", a_arguments_hr, a_defaultOfficeElectricityDemandProfile_fr, OL_ProfileUnits.YEARLYTOTALFRACTION);
f_createEngineProfile("default_building_heat_demand_fr", a_arguments_hr, a_defaultBuildingHeatDemandProfile_fr, OL_ProfileUnits.YEARLYTOTALFRACTION);

//Create custom engine profiles
for(CustomProfile_data customProfile : c_customProfiles_data){
	f_createEngineProfile(customProfile.customProfileID(), customProfile.getArgumentsArray(), customProfile.getValuesArray(), customProfile.profileUnits()); // What type of profiles usually in custom profiles?? Custom production profiles?
} 
  }

  protected void f_addGridNodeProfile( GridNode gridnode, double[] profile_data_kWh ) { 

//Create gridconnection where the profile is attached to
GridConnection GC_GridNode_profile = energyModel.add_pop_gridConnections();

//Set GC id
GC_GridNode_profile.p_gridConnectionID = "GridNode " + gridnode.p_gridNodeID + " profile GC";

//Set gridnode as parent
GC_GridNode_profile.p_parentNodeElectricID = gridnode.p_gridNodeID;

//Set capacity same as gridnode
GC_GridNode_profile.v_liveConnectionMetaData.setCapacities_kW(gridnode.p_capacity_kW, gridnode.p_capacity_kW, gridnode.p_capacity_kW);
GC_GridNode_profile.v_liveConnectionMetaData.setCapacitiesKnown(false, false, false);

//Set lat lon same as gridnode
GC_GridNode_profile.p_latitude = gridnode.p_latitude; // Get latitude of first building (only used to get nearest trafo)
GC_GridNode_profile.p_longitude = gridnode.p_longitude; // Get longitude of first building (only used to get nearest trafo)

if(project_data.gridnode_profile_timestep_hr() == null){
	throw new RuntimeException("Trying to load in gridnode profiles, without specifying the timestep of the data in the project_data");
}
else if(project_data.gridnode_profile_timestep_hr() < energyModel.p_timeParameters.getTimeStep_h()){
	throw new RuntimeException("Trying to loadin gridnode profile timestep data with smaller resolution (" + project_data.gridnode_profile_timestep_hr() + ") than simulation model time steps (" + energyModel.p_timeParameters.getTimeStep_h() + "): This is not supported by the preprocessing yet!");
}

double profileTimestep_hr = project_data.gridnode_profile_timestep_hr();
double modelToProfileStepsRatio = profileTimestep_hr / energyModel.p_timeParameters.getTimeStep_h();

int roundedModelToProfileStepsRatio = roundToInt(modelToProfileStepsRatio);

// Check: ratio must be integer
if (abs(modelToProfileStepsRatio - roundedModelToProfileStepsRatio) > 1e-9) {
    throw new RuntimeException("Profile timestep (" + profileTimestep_hr + ") is not an integer multiple of model timestep (" + energyModel.p_timeParameters.getTimeStep_h() + ")");
}

double[] a_yearlyElectricityDelivery_kWh = new double[profile_data_kWh.length * roundedModelToProfileStepsRatio];
double[] a_yearlyElectricityFeedin_kWh = new double[profile_data_kWh.length * roundedModelToProfileStepsRatio];

double maxFeedin_kWh = 0;
int idx = 0;
for (double dataStep_kWh : profile_data_kWh) {

    // Energy per model timestep
    double stepEnergy_kWh = dataStep_kWh * (energyModel.p_timeParameters.getTimeStep_h() / profileTimestep_hr);

    for (int i = 0; i < roundedModelToProfileStepsRatio; i++) {
        double currentFeedin_kWh;
        double currentDelivery_kWh;

        if (stepEnergy_kWh >= 0) {
            currentDelivery_kWh = stepEnergy_kWh;
            currentFeedin_kWh = 0;
        }
        else {
            currentDelivery_kWh = 0;
            currentFeedin_kWh = -stepEnergy_kWh;
            if (currentFeedin_kWh > maxFeedin_kWh) {
                maxFeedin_kWh = currentFeedin_kWh;
            }
        }
        a_yearlyElectricityDelivery_kWh[idx] = currentDelivery_kWh;
        a_yearlyElectricityFeedin_kWh[idx]   = currentFeedin_kWh;

        idx++;
    }
}

gridnode.p_profileType = settings.gridNodeProfileLoaderType();

if (gridnode.p_profileType == OL_GridNodeProfileLoaderType.NET_LOAD){
	f_createPreprocessedElectricityProfile_PV(GC_GridNode_profile, a_yearlyElectricityDelivery_kWh, a_yearlyElectricityFeedin_kWh, a_yearlyElectricityFeedin_kWh, null, null);
	if (maxFeedin_kWh > 0){
		double pvPower_kW = 2.5 * (maxFeedin_kWh/energyModel.p_timeParameters.getTimeStep_h()); // Estimation needed for pv power
		f_createCustomPVAsset(GC_GridNode_profile, a_yearlyElectricityFeedin_kWh, pvPower_kW);
	}
}
else { //INCLUDE_PV or EXCLUDE_PV
	Double pvPower_kW = f_getGNTotalPV_kWp(gridnode);
	boolean isPvPowerKnownAndPositive = pvPower_kW != null && pvPower_kW != 0;
	if (maxFeedin_kWh <= 0 && !isPvPowerKnownAndPositive) {
		f_createPreprocessedElectricityProfile_PV(GC_GridNode_profile, a_yearlyElectricityDelivery_kWh, null, null, null, null);
	}
	else if (maxFeedin_kWh > 0 && !isPvPowerKnownAndPositive){
		if (gridnode.p_profileType == OL_GridNodeProfileLoaderType.INCLUDE_PV){
			pvPower_kW = 2.5 * (maxFeedin_kWh/energyModel.p_timeParameters.getTimeStep_h()); // Estimation needed for pv power
			traceln("PV Power has been estimated!");
			f_createPreprocessedElectricityProfile_PV(GC_GridNode_profile, a_yearlyElectricityDelivery_kWh, a_yearlyElectricityFeedin_kWh, null, pvPower_kW, null);
			f_addPVProductionAsset(GC_GridNode_profile, "Total current Solar on GridNode", pvPower_kW, OL_PVOrientation.SOUTH);
			//f_addEnergyProduction(GC_GridNode_profile, OL_EnergyAssetType.PHOTOVOLTAIC, "Total current Solar on GridNode", pvPower_kW);
		}
		else { //EXCLUDE_PV
			throw new RuntimeException("Grid node profile contains feed-in but no PV power is found in Building_data for EXCLUDE_PV. This is not allowed.");
		}
	}
	else {
		if (maxFeedin_kWh > 4*pvPower_kW){
			throw new RuntimeException("Max feed-in of grid node profile is higher than Excel building/solarfarm data!");
		}
		f_createPreprocessedElectricityProfile_PV(GC_GridNode_profile, a_yearlyElectricityDelivery_kWh, a_yearlyElectricityFeedin_kWh, null, pvPower_kW, null);
		if (gridnode.p_profileType == OL_GridNodeProfileLoaderType.INCLUDE_PV){
			f_addPVProductionAsset(GC_GridNode_profile, "Total current Solar on GridNode", pvPower_kW, OL_PVOrientation.SOUTH);
			//f_addEnergyProduction(GC_GridNode_profile, OL_EnergyAssetType.PHOTOVOLTAIC, "Total current Solar on GridNode", pvPower_kW);
		}
	}
}

c_gridNodeIDsWithProfiles.add(gridnode.p_gridNodeID); 
  }

  protected 
J_ChargingSessionData 
 f_createChargingSession( String chargingSessionData ) { 

String[] chargingSessionInfo = chargingSessionData.split("/"); 

double startIndex = Double.parseDouble(chargingSessionInfo[0]);
double endIndex = Double.parseDouble(chargingSessionInfo[1]);
double chargingDemand_kWh = Double.parseDouble(chargingSessionInfo[2]);
double batteryCap_kWh = Double.parseDouble(chargingSessionInfo[3]);
double chargingPower_kW = Double.parseDouble(chargingSessionInfo[5]);
int socket = Integer.parseInt(chargingSessionInfo[6]);
boolean isV2GCapable = randomTrue(avgc_data.p_v2gProbability);
double timeStep_h = 0.25;

//Cap charging demand to what is actual possible according to chargetime interval * charge power
chargingDemand_kWh = min(chargingPower_kW * (endIndex - startIndex) * 0.25, chargingDemand_kWh);

return new J_ChargingSessionData(startIndex, endIndex, chargingDemand_kWh, batteryCap_kWh, chargingPower_kW, socket, isV2GCapable, timeStep_h); 
  }

  protected 
List<J_ChargingSessionData>  
 f_createNewChargerProfile( ChargerProfile_data chargerProfileData ) { 

// example: 2/54/50.3/72.1/21.8/10.8/2
List<String> chargerProfileDataValues = chargerProfileData.valuesList();
List<J_ChargingSessionData> chargerProfile = new ArrayList<J_ChargingSessionData>();		

for(int i = 0; i < chargerProfileDataValues.size(); i++){
	chargerProfile.add(f_createChargingSession(chargerProfileDataValues.get(i)));
}

return chargerProfile; 
  }

  protected 
List<J_ChargingSessionData>  
 f_getChargerProfile(  ) { 

List<J_ChargingSessionData> chargerProfile;
int randomIndex;

if(c_chargerProfiles_data.size()>0){
	randomIndex = uniform_discr(0, c_chargerProfiles_data.size() - 1);
	chargerProfile = f_createNewChargerProfile(c_chargerProfiles_data.get(randomIndex));
	c_chargerProfiles_data.remove(randomIndex);
	energyModel.c_chargerProfiles.add(chargerProfile);
}
else{
	randomIndex = uniform_discr(0, energyModel.c_chargerProfiles.size() - 1);
	chargerProfile = energyModel.c_chargerProfiles.get(randomIndex);
}

return chargerProfile; 
  }

  protected void f_addCookingAsset( GCHouse GC, OL_HouseholdCookingMethod cookingType, double yearlyCookingDemand_kWh ) { 

if(cookingType != OL_HouseholdCookingMethod.NONE){
	if(yearlyCookingDemand_kWh <= 0){
		throw new RuntimeException("Trying to create a cooking asset, without specifying the yearly energy consumption");
	}

	OL_EnergyAssetType energyAssetType;
	OL_EnergyCarriers energyCarrier;
	if(cookingType == OL_HouseholdCookingMethod.GAS){
		energyAssetType = OL_EnergyAssetType.GAS_PIT;
		energyCarrier = OL_EnergyCarriers.METHANE;
	}
	else if(cookingType == OL_HouseholdCookingMethod.ELECTRIC){
		energyAssetType = OL_EnergyAssetType.ELECTRIC_HOB;
		energyCarrier = OL_EnergyCarriers.ELECTRICITY;
	}
	else{
		throw new RuntimeException("Unsupported cookingtype found! ( " + cookingType + " )");
	}
	
	J_ProfilePointer pp = energyModel.f_findProfile("default_house_cooking_demand_fr");	
	new J_EAConsumption(GC, energyAssetType, "default_house_cooking_demand_fr", yearlyCookingDemand_kWh, energyCarrier, energyModel.p_timeParameters, pp);
	GC.p_cookingMethod = cookingType;
} 
  }

  protected 
double 
 f_addHotWaterDemand( GridConnection GC, double yearlyHWD_kWh, int numberOfResidents ) { 

if(yearlyHWD_kWh <= 0){
	throw new RuntimeException("Trying to create a DHW asset, without specifying the yearly energy consumption");
}
J_ProfilePointer pp = f_getDHWProfile(numberOfResidents);
if(pp == null){
	pp = energyModel.f_findProfile("default_house_hot_water_demand_fr");
	J_EAConsumption profile = new J_EAConsumption(GC, OL_EnergyAssetType.HOT_WATER_CONSUMPTION, "default_house_hot_water_demand_fr", yearlyHWD_kWh, OL_EnergyCarriers.HEAT, energyModel.p_timeParameters, pp);
	return profile.getPeakConsumptionPower_kW();
} else {
	J_EAProfile profile = new J_EAProfile( GC, OL_EnergyCarriers.HEAT, pp, OL_AssetFlowCategories.hotWaterConsumption_kW, energyModel.p_timeParameters);
	return profile.getPeakConsumptionPower_kW();
}
 
  }

  protected void f_addBuildingHeatModel( GridConnection parentGC, double floorArea_m2, Double heatDemand_kwhpa, J_HeatingPreferences heatingPreferences ) { 

double maxPowerHeat_kW = 1000; 				//Dit is hoeveel vermogen het huis kan afgeven/opnemen, moet voldoende hoog zijn zodat het niet beperkend is voor warmteoverdracht tussen heatingAsset en J_EABuilding. Wordt alleen gebruikt in rekenstap van ratio of capacity
double lossFactor_WpK; 						//Dit is wat bepaalt hoeveel warmte het huis verliest/opneemt per tijdstap per delta_T
double initialTemp_degC = heatingPreferences.getCurrentPreferedTemperatureSetpoint_degC(0);
double buildingCooldownPeriod_hr;
double heatCapacity_JpK; 					//hoeveel lucht zit er in je huis dat je moet verwarmen?
double solarAbsorptionFactor_m2; 	//hoeveel m2 effectieve dak en muur oppervlakte er is dat opwarmt door zonneinstraling

//Determine the heat loss factor based on yearly energy energy consumption for heating or energyLabel
if(heatDemand_kwhpa != null && heatDemand_kwhpa > 0){
	lossFactor_WpK = heatDemand_kwhpa / avgc_data.p_PBL_HeatingLossFactor_fr;
}
else{
	switch (parentGC.p_insulationLabel){
		case NONE:
		case UNKNOWN:
			lossFactor_WpK = uniform (avgc_data.map_insulationLabel_lossfactorPerFloorSurface_WpKm2.get(OL_GridConnectionInsulationLabel.B), avgc_data.map_insulationLabel_lossfactorPerFloorSurface_WpKm2.get(OL_GridConnectionInsulationLabel.G)) * floorArea_m2;
			break;
		default:
			lossFactor_WpK = avgc_data.map_insulationLabel_lossfactorPerFloorSurface_WpKm2.get(parentGC.p_insulationLabel);
	}
}

//Determine the solar absortion factor_m2 based on floor surface.
solarAbsorptionFactor_m2 = floorArea_m2 * avgc_data.p_solarAbsorptionFloorSurfaceScalingFactor_fr; //solar irradiance [W/m2]

//Determine the heat capacity of the building based on a cooldown period

switch (parentGC.p_insulationLabel){
		case NONE:
		case UNKNOWN:
			buildingCooldownPeriod_hr = uniform (avgc_data.map_insulationLabel_cooldownPeriod_hr.get(OL_GridConnectionInsulationLabel.B), avgc_data.map_insulationLabel_cooldownPeriod_hr.get(OL_GridConnectionInsulationLabel.G));
			break;
		default:
			buildingCooldownPeriod_hr = avgc_data.map_insulationLabel_cooldownPeriod_hr.get(parentGC.p_insulationLabel);
}


//Determine the heat capacity of the building based on the floor surface and some factors
double secondsPerHour = 3600;
heatCapacity_JpK = lossFactor_WpK * secondsPerHour * buildingCooldownPeriod_hr; // Calculates heatCapacity_JpK of the building as a function of LossFactor_WpK and cooldownTimescale_h
//Create the thermal building asset
parentGC.p_BuildingThermalAsset = new J_EABuilding( parentGC, maxPowerHeat_kW, lossFactor_WpK, energyModel.p_timeParameters, initialTemp_degC, heatCapacity_JpK, solarAbsorptionFactor_m2 );


//FOR NOW DEFAULT NO INTERIOR/EXTERIOR HEAT BUFFERS -> NOT NECESSARY
/*
double delayHeatReleaseInteriorHeatsink_hr = 0;
double lossToExteriorFromInteriorHeatSink_fr;
if(randomTrue(0.2)){
	delayHeatReleaseInteriorHeatsink_hr = 3;
}
else {
	delayHeatReleaseInteriorHeatsink_hr = 0.5;
}

parentGC.p_BuildingThermalAsset.addInteriorHeatBuffer(delayHeatReleaseInteriorHeatsink_hr);

double delayHeatReleaseRoofAndWall_hr = 8.0;
parentGC.p_BuildingThermalAsset.addExteriorHeatBuffer(delayHeatReleaseRoofAndWall_hr);
*/ 
  }

  protected 
List<Building_data> 
 f_getBuildingsInSubScope( List<Building_data> initialBuildingList ) { 

List<Building_data> scopedBuildingList = new ArrayList<>();

if(settings.subscopesToSimulate() == null || settings.subscopesToSimulate().size() == 0){
	scopedBuildingList.addAll(initialBuildingList);
}
else{
	for (Building_data dataBuilding : initialBuildingList) {
		for (int i = 0; i < c_gridNodeIDsInScope.size() ; i++){
			if (dataBuilding.gridnode_id().equals( c_gridNodeIDsInScope.get(i))){
				scopedBuildingList.add(dataBuilding);
			}
		}	
	}
}
return scopedBuildingList; 
  }

  /**
   * Creates the houses using a single GC, and their building. After creation, they will be simulated using average values.
   */
  protected void f_createHouses(  ) { 

List<Building_data> buildingDataHouses = f_getBuildingsInSubScope(c_houseBuilding_data);

traceln("Aantal panden met woonfunctie in BAG data: " + buildingDataHouses.size());

int i = 0;


if(buildingDataHouses.size()>0){
	//Add houses to the legend if in model
	zero_Interface.c_modelActiveDefaultGISBuildings.add(OL_GISBuildingTypes.HOUSE);
	
	//PreCalculate the probabilities for an additional Car for houses
	f_calculateProbabilitiesForAdditionalCar(buildingDataHouses);
}



for (Building_data houseBuildingData : buildingDataHouses) {
	GCHouse GCH = energyModel.add_Houses();
	ConnectionOwner	COH = energyModel.add_pop_connectionOwners();
	
	//Set parameters for the Grid Connection
 	GCH.p_gridConnectionID = houseBuildingData.address_id();
	GCH.p_ownerID = "Woonhuis" + Integer.toString(i);	//aanname : huiseigenaar is eigenbaas

	GCH.p_purposeBAG = houseBuildingData.purpose();
	
	//pand gegevens
	GCH.p_buildYear = houseBuildingData.build_year();
	GCH.p_eigenOprit = houseBuildingData.has_private_parking() != null ? houseBuildingData.has_private_parking() : false;
	
	//PBL heating
	boolean dataAvailablePBL = houseBuildingData.dwelling_type() != OL_PBL_DwellingType.UNKNOWN && houseBuildingData.ownership_type() != OL_PBL_OwnershipType.UNKNOWN && houseBuildingData.local_factor() != null && houseBuildingData.regional_climate_correction_factor() != null;
	if(houseBuildingData.use_pbl_data() && dataAvailablePBL){
		GCH.p_PBLParameters = new J_PBLParameters(houseBuildingData.dwelling_type(), 
												  houseBuildingData.ownership_type(),  
												  houseBuildingData.insulation_label(), 
												  houseBuildingData.local_factor(), 
												  houseBuildingData.regional_climate_correction_factor());
	}
	
	
	//Energylabel and InsulationLabel
	if (houseBuildingData.energy_label() != null) {
	    GCH.p_energyLabel = houseBuildingData.energy_label();
	    GCH.p_insulationLabel = houseBuildingData.insulation_label() != null ? houseBuildingData.insulation_label() : OL_GridConnectionInsulationLabel.valueOf(GCH.p_energyLabel.toString());
	} 
	else if (houseBuildingData.insulation_label() != null) {
	    GCH.p_insulationLabel = houseBuildingData.insulation_label();
	    GCH.p_energyLabel = OL_GridConnectionEnergyLabel.valueOf(GCH.p_insulationLabel.toString());
	} 
	else {
	    GCH.p_energyLabel = f_estimateEnergyLabel(GCH.p_buildYear);
	    GCH.p_insulationLabel = OL_GridConnectionInsulationLabel.valueOf(GCH.p_energyLabel.toString());
	}
	
	//Connection data
	boolean gridConnectionCapacityKnown = houseBuildingData.contracted_capacity_kw() != null && houseBuildingData.contracted_capacity_kw() > 0;
	double gridConnectionCapacity_kW = gridConnectionCapacityKnown ? houseBuildingData.contracted_capacity_kw() : avgc_data.p_avgHouseConnectionCapacity_kW;
	GCH.v_liveConnectionMetaData.setCapacities_kW(gridConnectionCapacity_kW, gridConnectionCapacity_kW, gridConnectionCapacity_kW);
	GCH.v_liveConnectionMetaData.setCapacitiesKnown(gridConnectionCapacityKnown, gridConnectionCapacityKnown, gridConnectionCapacityKnown);
	
	//Address data
	GCH.p_address = new J_Address(houseBuildingData.streetname(), 
							      houseBuildingData.house_number(), 
							      houseBuildingData.house_letter(), 
							      houseBuildingData.house_addition(), 
							      houseBuildingData.postalcode(), 
							      houseBuildingData.city());

	//Location
	GCH.p_longitude = houseBuildingData.longitude();
	GCH.p_latitude = houseBuildingData.latitude();
	GCH.setLatLon(GCH.p_latitude, GCH.p_longitude);
	
	//Connect GC to grid node
	GCH.p_parentNodeElectricID = houseBuildingData.gridnode_id();
		
	//Set parameters for the Actor: ConnectionOwner
	COH.p_actorID = GCH.p_ownerID;
	COH.p_connectionOwnerType = OL_ConnectionOwnerType.HOUSEHOLD;
	COH.p_detailedCompany = false;
	GCH.p_owner = COH;
	
	
	//Check wheter this building already exists
	GIS_Building existingBuilding = findFirst(energyModel.pop_GIS_Buildings, gisBuilding -> gisBuilding.p_id.equals(houseBuildingData.building_id()));
	
	if(existingBuilding == null){//Create new GIS building and connect
		GIS_Building b = f_createGISBuilding( houseBuildingData, GCH );
		GCH.p_roofSurfaceArea_m2 = houseBuildingData.polygon_area_m2();

		//Style building
		b.p_defaultFillColor = zero_Interface.v_houseBuildingColor;
		b.p_defaultLineColor = zero_Interface.v_houseBuildingLineColor;
		zero_Interface.f_styleAreas(b);
	}
	else{// Connect with existing building
		f_connectGCToExistingBuilding(GCH, existingBuilding, houseBuildingData);
	}
	
	//Floor surface of GC
	GCH.p_floorSurfaceArea_m2 = houseBuildingData.address_floor_surface_m2();
	
	//Set PV information
	GCH.v_liveAssetsMetaData.initialPV_kW = houseBuildingData.pv_installed_kwp() != null ? houseBuildingData.pv_installed_kwp() : 0;
	GCH.v_liveAssetsMetaData.PVPotential_kW = GCH.v_liveAssetsMetaData.initialPV_kW > 0 ? GCH.v_liveAssetsMetaData.initialPV_kW : houseBuildingData.pv_potential_kwp(); // To prevent sliders from changing outcomes
	GCH.v_liveAssetsMetaData.PVOrientation = houseBuildingData.pv_orientation() != null ? houseBuildingData.pv_orientation() : avgc_data.p_defaultPVOrientation;
	
	//Create and add EnergyAssets
	f_addEnergyAssetsToHouses(GCH, houseBuildingData.electricity_consumption_kwhpa(), houseBuildingData.gas_consumption_m3pa(), houseBuildingData.heating_type(), houseBuildingData.cooking_type());
	
	i++;
}

//Backup for when pv_potential kWp is null, needs to be after all houses have been made, so rooftop surface is distributed correctly
for(GCHouse GCH : energyModel.Houses){
	if(GCH.v_liveAssetsMetaData.PVPotential_kW == null){
		GCH.v_liveAssetsMetaData.PVPotential_kW = GCH.p_roofSurfaceArea_m2*avgc_data.p_avgRatioRoofPotentialPV*avgc_data.p_avgPVPower_kWpm2;
	}
}
	
//traceln("Total space heat demand houses input " + roundToDecimal(totalSpaceHeatDemand_kwhpa/1000000,3) + "GWh"); 
  }

  /**
   * Initialisation of the Energy assets using average values for houses
   */
  protected void f_addEnergyAssetsToHouses( GCHouse house, Double electricityDemand_kwhpa, Double gasDemand_m3pa, OL_GridConnectionHeatingType heatingType, OL_HouseholdCookingMethod cookingType ) { 

//Add generic electricity demand profile 
GridNode gn = findFirst(energyModel.pop_gridNodes, x -> x.p_gridNodeID.equals( house.p_parentNodeElectricID));

if ( gn.p_profileType == OL_GridNodeProfileLoaderType.NO_PROFILE ){
	if(electricityDemand_kwhpa == null){
		electricityDemand_kwhpa = uniform(avgc_data.p_avgHouseElectricityConsumption_kWh_yr - avgc_data.p_maxAvgHouseElectricityConsumptionOffset_kWhpa, 
										  avgc_data.p_avgHouseElectricityConsumption_kWh_yr + avgc_data.p_maxAvgHouseElectricityConsumptionOffset_kWhpa);
	}
	f_addElectricityDemandProfile(house, electricityDemand_kwhpa, null, false, "default_house_electricity_demand_fr");
}


//Add Heating assets: Spaceheating, DHW and cooking
f_addHeatAssetsToHouses(house, gasDemand_m3pa, heatingType, cookingType);


//Add pv
f_addPVToHouses(house, gn);

//Add cars
f_addCarsToHouses(house);
 
  }

  protected 
J_HeatingPreferences 
 f_getHouseHeatingPreferences(  ) { 

double nightTimeSetPoint_degC = 18;
double dayTimeSetPoint_degC = 20;
double startOfDayTime_h = 8;
double startOfNightTime_h = 23;


if( randomTrue(0.5) ){ //50% kans op ochtend ritme
	nightTimeSetPoint_degC = uniform_discr(12,18);
	dayTimeSetPoint_degC = uniform_discr(18, 24);
	startOfDayTime_h = uniform_discr(5,10) + uniform_discr(0,4) / 4.0;
	startOfNightTime_h = uniform_discr(21,23);

}
else if (randomTrue(0.5) ){ // 25% kans op hele dag aan
	nightTimeSetPoint_degC = uniform_discr(18,21);
	dayTimeSetPoint_degC = nightTimeSetPoint_degC;
	startOfDayTime_h = -1;
	startOfNightTime_h = 25;

}
else { // 25% kans op smiddags/savonds aan
	nightTimeSetPoint_degC = uniform_discr(14,18);
	dayTimeSetPoint_degC = uniform_discr(18, 24);
	startOfDayTime_h = uniform_discr(14, 16) + uniform_discr(0,4) / 4.0;
	startOfNightTime_h = uniform_discr(21,23);
}

double maxComfortTemperature_degC = dayTimeSetPoint_degC + 2;
double windowOpenSetpoint_degC = maxComfortTemperature_degC+1; // Hardcoded offset of +1, to prevent OffPeakHeating from triggering extra ventilation.
double minComfortTemperature_degC = dayTimeSetPoint_degC - 2;

//Create heating preferences class
J_HeatingPreferences heatingPreferences = new J_HeatingPreferences(startOfDayTime_h, startOfNightTime_h, dayTimeSetPoint_degC, nightTimeSetPoint_degC, maxComfortTemperature_degC, minComfortTemperature_degC, windowOpenSetpoint_degC);
return heatingPreferences; 
  }

  void f_createParkingSpots(  ) { 

List<GCEnergyProduction> carportGCList = new ArrayList<GCEnergyProduction>();

for (ParkingSpace_data dataParkingSpace : f_getParkingSpacesInSubScope(c_parkingSpace_data)){

	//Create parking gis object	
	GIS_Object parkingSpace = f_createGISObject(dataParkingSpace.parking_id(), dataParkingSpace.latitude(), dataParkingSpace.longitude(), dataParkingSpace.polygon(), OL_GISObjectType.PARKING);
	String parkingSpaceType = dataParkingSpace.type().toString().substring(0, 1).toUpperCase() + dataParkingSpace.type().toString().substring(1).toLowerCase();
	parkingSpace.p_annotation = "Parkeerplek: " + parkingSpaceType + ", " + dataParkingSpace.additional_info();
	
	//Set correct color and legend collection based on parking type
	switch(dataParkingSpace.type()){
		case PRIVATE:
		case DISABLED:
		case KISS_AND_RIDE:
			parkingSpace.p_defaultFillColor = zero_Interface.v_parkingSpaceColor_private;
			parkingSpace.p_defaultLineColor = zero_Interface.v_parkingSpaceLineColor_private;
			zero_Interface.c_modelActiveParkingSpaceTypes.add(OL_ParkingSpaceType.PRIVATE);
			break;
		case PUBLIC:
			parkingSpace.p_defaultFillColor = zero_Interface.v_parkingSpaceColor_public;
			parkingSpace.p_defaultLineColor = zero_Interface.v_parkingSpaceLineColor_public;
			zero_Interface.c_modelActiveParkingSpaceTypes.add(OL_ParkingSpaceType.PUBLIC);
			break;
		case ELECTRIC:
			parkingSpace.p_defaultFillColor = zero_Interface.v_parkingSpaceColor_electric;
			parkingSpace.p_defaultLineColor = zero_Interface.v_parkingSpaceLineColor_electric;
			zero_Interface.c_modelActiveParkingSpaceTypes.add(OL_ParkingSpaceType.ELECTRIC);		
			break;
	}
	
	//Add to ordered collection on the interface
	zero_Interface.c_orderedParkingSpaces.add(parkingSpace);

	//Style gis object
	parkingSpace.f_style(null, null, null, null);	
	
	//Get energyProduction GC	
	GCEnergyProduction carportGC = findFirst(carportGCList, gc -> gc.p_parentNodeElectricID.equals(dataParkingSpace.gridnode_id()));
	
	if(carportGC == null){ // If non existend -> Create one.
		carportGC = energyModel.add_EnergyProductionSites();
		
		carportGC.p_gridConnectionID = "Parking space gridconnection: " + dataParkingSpace.parking_id();
		double physicalCapacity_kW = 1 + dataParkingSpace.pv_potential_kwp(); // 1 + is fix to prevent errors in engine for 0 capacity (= 0 pv potential for all parking spaces attached to this GC)
		double contractedFeedinCapacity_kW = 1 + dataParkingSpace.pv_potential_kwp(); // 1 + is fix to prevent errors in engine for 0 capacity (= 0 pv potential for all parking spaces attached to this GC)
		carportGC.v_liveConnectionMetaData.setCapacities_kW(0, contractedFeedinCapacity_kW, physicalCapacity_kW);
		carportGC.v_liveConnectionMetaData.setCapacitiesKnown(false, false, false);
		
		carportGC.p_parentNodeElectricID = dataParkingSpace.gridnode_id();

		carportGC.p_latitude = dataParkingSpace.latitude();		
		carportGC.p_longitude = dataParkingSpace.longitude();
		
		//Address
		carportGC.p_address = new J_Address();
		carportGC.p_address.setStreetName(dataParkingSpace.street());
		
		//CO
		ConnectionOwner COC = energyModel.add_pop_connectionOwners(); // Create Connection owner company
			
		COC.p_actorID = "Parking space connection owner: " + dataParkingSpace.parking_id();
		COC.p_connectionOwnerType = OL_ConnectionOwnerType.PARKINGSPACE_OP;
		COC.p_detailedCompany = false;
		COC.b_dataSharingAgreed = true;
		
		carportGC.p_owner = COC;
		carportGC.p_ownerID = COC.p_actorID;
		
		//Add to collections
		parkingSpace.c_containedGridConnections.add(carportGC);
		carportGC.c_connectedGISObjects.add(parkingSpace);
		carportGCList.add(carportGC);
		
		//Initialize pv potential
		carportGC.v_liveAssetsMetaData.PVPotential_kW = 0.0;
	}
	else{
		double physicalCapacity_kW = carportGC.v_liveConnectionMetaData.getPhysicalCapacity_kW() + dataParkingSpace.pv_potential_kwp();
		double contractedFeedinCapacity_kW = carportGC.v_liveConnectionMetaData.getContractedFeedinCapacity_kW() + dataParkingSpace.pv_potential_kwp();
		carportGC.v_liveConnectionMetaData.setCapacities_kW(0, contractedFeedinCapacity_kW, physicalCapacity_kW);
		
				
		//Add to collections
		parkingSpace.c_containedGridConnections.add(carportGC);
		carportGC.c_connectedGISObjects.add(parkingSpace);
	}
	
	//Update pv potential of carport energy production site
	carportGC.v_liveAssetsMetaData.PVPotential_kW += dataParkingSpace.pv_potential_kwp() != null ? dataParkingSpace.pv_potential_kwp() : 0;
} 
  }

  protected 
List<Solarfarm_data> 
 f_getSolarfarmsInSubScope( List<Solarfarm_data> initialSolarfarmsList ) { 

List<Solarfarm_data> scopedSolarfarmsList = new ArrayList<>();

if(settings.subscopesToSimulate() == null || settings.subscopesToSimulate().size() == 0){
	scopedSolarfarmsList.addAll(initialSolarfarmsList);
}
else{
	for (Solarfarm_data dataSolarfarm : initialSolarfarmsList) {
		for (int i = 0; i < c_gridNodeIDsInScope.size() ; i++){
			if (dataSolarfarm.gridnode_id().equals( c_gridNodeIDsInScope.get(i))){
				scopedSolarfarmsList.add(dataSolarfarm);
			}
		}	
	}
}
return scopedSolarfarmsList; 
  }

  protected 
List<Windfarm_data> 
 f_getWindfarmsInSubScope( List<Windfarm_data> initialWindfarmsList ) { 

List<Windfarm_data> scopedWindfarmsList = new ArrayList<>();

if(settings.subscopesToSimulate() == null || settings.subscopesToSimulate().size() == 0){
	scopedWindfarmsList.addAll(initialWindfarmsList);
}
else{
	for (Windfarm_data dataWindfarm : initialWindfarmsList) {
		for (int i = 0; i < c_gridNodeIDsInScope.size() ; i++){
			if (dataWindfarm.gridnode_id().equals( c_gridNodeIDsInScope.get(i))){
				scopedWindfarmsList.add(dataWindfarm);
			}
		}	
	}
}
return scopedWindfarmsList; 
  }

  protected 
List<Chargingstation_data> 
 f_getChargingstationsInSubScope( List<Chargingstation_data> initialChargingstationsList ) { 

List<Chargingstation_data> scopedChargingstationsList = new ArrayList<>();

if(settings.subscopesToSimulate() == null || settings.subscopesToSimulate().size() == 0){
	scopedChargingstationsList.addAll(initialChargingstationsList);
}
else{
	for (Chargingstation_data dataChargingstation : initialChargingstationsList) {
		for (int i = 0; i < c_gridNodeIDsInScope.size() ; i++){
			if (dataChargingstation.gridnode_id().equals( c_gridNodeIDsInScope.get(i))){
				scopedChargingstationsList.add(dataChargingstation);
			}
		}	
	}
}
return scopedChargingstationsList; 
  }

  protected 
List<Electrolyser_data> 
 f_getElectrolysersInSubScope( List<Electrolyser_data> initialElectrolysersList ) { 

List<Electrolyser_data> scopedElectrolysersList = new ArrayList<>();

if(settings.subscopesToSimulate() == null || settings.subscopesToSimulate().size() == 0){
	scopedElectrolysersList.addAll(initialElectrolysersList);
}
else{
	for (Electrolyser_data dataElectrolyser : initialElectrolysersList) {
		for (int i = 0; i < c_gridNodeIDsInScope.size() ; i++){
			if (dataElectrolyser.gridnode_id().equals( c_gridNodeIDsInScope.get(i))){
				scopedElectrolysersList.add(dataElectrolyser);
			}
		}	
	}
}
return scopedElectrolysersList; 
  }

  protected 
List<ParkingSpace_data> 
 f_getParkingSpacesInSubScope( List<ParkingSpace_data> initialParkingSpaceList ) { 

List<ParkingSpace_data> scopedParkingSpacesList = new ArrayList<>();

if(settings.subscopesToSimulate() == null || settings.subscopesToSimulate().size() == 0){
	scopedParkingSpacesList.addAll(initialParkingSpaceList);
}
else{
	for (ParkingSpace_data dataParkingSpace : initialParkingSpaceList) {
		for (int i = 0; i < c_gridNodeIDsInScope.size() ; i++){
			if (dataParkingSpace.gridnode_id().equals( c_gridNodeIDsInScope.get(i))){
				scopedParkingSpacesList.add(dataParkingSpace);
			}
		}	
	}
}
return scopedParkingSpacesList; 
  }

  protected 
List<Battery_data> 
 f_getBatteriesInSubScope( List<Battery_data> initialBatteriesList ) { 

List<Battery_data> scopedBatteriesList = new ArrayList<>();

if(settings.subscopesToSimulate() == null || settings.subscopesToSimulate().size() == 0){
	scopedBatteriesList.addAll(initialBatteriesList);
}
else{
	for (Battery_data dataBattery : initialBatteriesList) {
		for (int i = 0; i < c_gridNodeIDsInScope.size() ; i++){
			if (dataBattery.gridnode_id().equals( c_gridNodeIDsInScope.get(i))){
				scopedBatteriesList.add(dataBattery);
			}
		}	
	}
}
return scopedBatteriesList; 
  }

  
List<Building_data> 
 f_getSurveyGCBuildingData( GridConnection companyGC, com.zenmo.zummon.companysurvey.GridConnection vallumGC ) { 

List<Building_data> connectedBuildingsData = new ArrayList<Building_data>();

if ( vallumGC.getPandIds() != null && !vallumGC.getPandIds().isEmpty()) {
	for (var PID : vallumGC.getPandIds() ) {
		List<Building_data> buildingsDataSameID = findAll(c_companyBuilding_data, b -> b.building_id().equals(PID.getValue()));
		Building_data connectedBuildingData = null;
		if(buildingsDataSameID.size() == 1){ // Only one building package with same id, so this building package belongs to this GC
			connectedBuildingData = buildingsDataSameID.get(0);
		}
		else{//Multiple building packages with this building id -> Find the right one based on address, if none are found: pick a package without address
			connectedBuildingData = findFirst(buildingsDataSameID, buildingData -> buildingData.house_number() != null && companyGC.p_address.getHouseNumber() != null && buildingData.house_number().intValue() == companyGC.p_address.getHouseNumber().intValue());
			if(connectedBuildingData == null){ //If no matching house numbers, find first object that has no house number.
				connectedBuildingData = findFirst(buildingsDataSameID, buildingData -> buildingData.house_number() == null);
			}
		}
		
		if (connectedBuildingData != null) {
		    // Remove from company building data and add to survey
		    c_companyBuilding_data.remove(connectedBuildingData);
		    c_surveyCompanyBuilding_data.add(connectedBuildingData);
		    // Set trafo ID
		    companyGC.p_parentNodeElectricID = connectedBuildingData.gridnode_id();
		}
		else if (map_buildingData_Vallum != null && !map_buildingData_Vallum.isEmpty()) {
		        // Create new building package
		        connectedBuildingData = f_createBuildingData_Vallum(companyGC, PID.getValue());
		        c_vallumBuilding_data.add(connectedBuildingData);
		}
		
		if (connectedBuildingData != null) {
			connectedBuildingsData.add(connectedBuildingData);
		}
	}
} 
else {// No building connected in zorm? -> check if it is manually connected in excel (using gc_id column)
	connectedBuildingsData = findAll(c_companyBuilding_data, b -> b.gc_id() != null && b.gc_id().equals(companyGC.p_gridConnectionID));
	if(connectedBuildingsData == null || connectedBuildingsData.size() == 0){
		traceln("GC %s has no building in zorm and also no manual connection with building in excel", companyGC.p_gridConnectionID);
	}
	else{
		c_companyBuilding_data.removeAll(connectedBuildingsData);
	}
}

return connectedBuildingsData; 
  }

  protected 
OL_GridConnectionHeatingType 
 f_heatingSurveyCompany( GridConnection engineGC, com.zenmo.zummon.companysurvey.GridConnection surveyGC ) { 

// Set heatingType
OL_GridConnectionHeatingType heatingType = f_getHeatingTypeSurvey(engineGC, surveyGC);

if(heatingType == OL_GridConnectionHeatingType.CUSTOM){
	f_addCustomHeatingSetup(engineGC, surveyGC);
}
else{
	// Create building profiles, peakHeatConsumption_kW is null if there is no heat consumption
	Double peakHeatConsumption_kW = f_createSurveyHeatProfiles( engineGC, surveyGC, heatingType );
	
	// Create EA conversions
	if (peakHeatConsumption_kW != null) {
		f_addHeatAsset(engineGC, heatingType, peakHeatConsumption_kW);
	}
	
	if (surveyGC.getStorage() != null && surveyGC.getStorage().getHasThermalStorage() != null) {
		//if (surveyGC.getStorage().getThermalStorageKw() != null) {
			//double storagePower_kW = surveyGC.getStorage().getThermalStorageKw();
		//}
		// TODO: find a way to determine the storage capacity 
		// f_addStorage(parentGC, storagePower_kw, storageCapacity_kWh, storageType);
	}
	
	// Heating management (needs: heatingType & assets such as building thermal model or profiles, survey companies never have a thermal building mdoel)
	boolean isGhost = heatingType != OL_GridConnectionHeatingType.NONE && peakHeatConsumption_kW == null;
	
	//Add heating management
	engineGC.f_addHeatManagement(heatingType, isGhost);
}

return heatingType; 
  }

  protected 
Double 
 f_createSurveyHeatProfiles( GridConnection engineGC, com.zenmo.zummon.companysurvey.GridConnection surveyGC, OL_GridConnectionHeatingType heatingType ) { 

////Gas and Heating
if (surveyGC.getNaturalGas().getHasConnection() != null && surveyGC.getNaturalGas().getHasConnection() ) {
	switch (heatingType) {
		case HYBRID_HEATPUMP:
			// Exception for hybrid heatpumps, when it will be a ghost asset make gas profile
			if (!settings.createCurrentElectricityEA() && (engineGC.v_hasQuarterHourlyValues || f_surveyHasGasData(surveyGC)) ) {
				f_createGasProfileFromSurvey( engineGC, surveyGC );
				return null;
			}
			else {
				// We know there is no data, hence we directly call the estimate function
				return f_createHeatProfileFromEstimates(engineGC);
			}
		case GAS_BURNER:
		case GAS_CHP:
			// heat consumption profiel
			return f_createHeatProfileFromGasSurvey( engineGC, surveyGC, heatingType );
		default:
			if (surveyGC.getNaturalGas().getPercentageUsedForHeating() != null && surveyGC.getNaturalGas().getPercentageUsedForHeating() != 0.0) {				
				// TODO: Find a solution to surveys filled in without heatingType that is not this hacky
				if (surveyGC.getNaturalGas().getEan().equals("123456789012345678")) {
					return null;
				}
				throw new RuntimeException("Gas data used for heating in survey, but no corresponding heating type");
			}
			else {
				f_createGasProfileFromSurvey( engineGC, surveyGC );
				return null;				
			}
	}
}
else if ( heatingType == OL_GridConnectionHeatingType.DISTRICTHEAT || heatingType == OL_GridConnectionHeatingType.LT_DISTRICTHEAT ) {
	return f_createHeatProfileFromSurvey(engineGC, surveyGC);
}
else if ( heatingType == OL_GridConnectionHeatingType.NONE ) {
	return null;
}
else {
	if(!settings.createCurrentElectricityEA() && engineGC.v_hasQuarterHourlyValues){
		if(heatingType == OL_GridConnectionHeatingType.HYBRID_HEATPUMP){
			return null; // Could create an estimated gas profile here: not done for now.
		}
		if(heatingType == OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP){
			return null;
		}
	}
	return f_createHeatProfileFromEstimates(engineGC);
} 
  }

  protected 
boolean 
 f_surveyHasGasData( com.zenmo.zummon.companysurvey.GridConnection surveyGC ) { 

if ( surveyGC.getNaturalGas().getAnnualDelivery_m3() != null && surveyGC.getNaturalGas().getAnnualDelivery_m3() > 0) {
	return true;
}
else if (surveyGC.getNaturalGas().getHourlyDelivery_m3() != null && surveyGC.getNaturalGas().getHourlyDelivery_m3().hasNumberOfValuesForOneYear()) {
	return true;
}
else {
	return false;
} 
  }

  protected void f_createGasProfileFromGasTS( GridConnection engineGC, com.zenmo.zummon.companysurvey.GridConnection surveyGC ) { 

// Gas delivery profile in m3
//double[] profile_m3ph = f_convertFloatArrayToDoubleArray(surveyGC.getNaturalGas().getHourlyDelivery_m3().getFlatDataPoints());
double[] profile_m3pqh = f_timeSeriesToQuarterHourlyDoubleArray(surveyGC.getNaturalGas().getHourlyDelivery_m3());

// TODO: Check startdate of profile! Perhaps update vallum method to do so?

traceln("Gas data array length: %s", profile_m3pqh.length);
double dataTimeStep_h = 0.25;
double[] a_arguments_hr = new double[profile_m3pqh.length];
for (int i = 0; i<profile_m3pqh.length; i++) {
	a_arguments_hr[i] = i*dataTimeStep_h;
}
//Calculate yearly gas delivery
double yearlyGasDelivery_m3pa = Arrays.stream(profile_m3pqh).sum();

String energyAssetName = engineGC.p_ownerID + " custom gas profile";
// We assume all delivery is consumption and convert m3 to kWh
double[] profile_kW = ZeroMath.arrayMultiply(profile_m3pqh, avgc_data.p_gas_kWhpm3);
J_ProfilePointer profilePointer = f_createEngineProfile(energyAssetName, a_arguments_hr, profile_m3pqh, OL_ProfileUnits.KWHPQUARTERHOUR);

// Then we create the profile asset and name it
J_EAProfile j_ea = new J_EAProfile(engineGC, OL_EnergyCarriers.METHANE, profilePointer, null, energyModel.p_timeParameters);
j_ea.setEnergyAssetName(energyAssetName);

if(engineGC.p_owner.p_detailedCompany){
	p_remainingTotals.adjustRemainingGasDeliveryCompanies_m3(engineGC,  - yearlyGasDelivery_m3pa);
} 
  }

  protected 
double 
 f_createHeatProfileFromAnnualGasTotal( GridConnection engineGC, OL_GridConnectionHeatingType heatingType, double yearlyGasDelivery_m3, double ratioGasUsedForHeating ) { 

// First check what the heat conversion efficiency is from gas
double gasToHeatEfficiency = f_getGasToHeatEfficiency(heatingType);
// Finally, multiply the gas delivery with the total conversion factor to get the heat consumption
double yearlyConsumptionHeat_kWh = yearlyGasDelivery_m3 * avgc_data.p_gas_kWhpm3 * gasToHeatEfficiency * ratioGasUsedForHeating;
// We assume the heat consumption follows a standard profile
String profileName = "default_building_heat_demand_fr";
J_ProfilePointer profilePointer = energyModel.f_findProfile(profileName);
new J_EAConsumption(engineGC, OL_EnergyAssetType.HEAT_DEMAND, profileName, yearlyConsumptionHeat_kWh, OL_EnergyCarriers.HEAT, energyModel.p_timeParameters, profilePointer);

if(engineGC.p_owner.p_detailedCompany){
	p_remainingTotals.adjustRemainingGasDeliveryCompanies_m3(engineGC,  - yearlyGasDelivery_m3);
}

return yearlyConsumptionHeat_kWh * max(profilePointer.getAllValues())/energyModel.p_timeParameters.getTimeStep_h(); 
  }

  protected void f_createGasProfileFromAnnualGasTotal( GridConnection engineGC, double yearlyGasDelivery_m3 ) { 

// We assume all delivery is consumption and convert m3 to kWh
double yearlyGasConsumption_kWh = yearlyGasDelivery_m3 * avgc_data.p_gas_kWhpm3;
// We assume the gas consumption follows a standard heat consumption profile
String profileName = "default_building_heat_demand_fr";
J_ProfilePointer buildingHeatConsumptionProfile = energyModel.f_findProfile(profileName);
new J_EAConsumption(engineGC, OL_EnergyAssetType.METHANE_DEMAND, profileName, yearlyGasConsumption_kWh, OL_EnergyCarriers.METHANE, energyModel.p_timeParameters, buildingHeatConsumptionProfile);	 

if(engineGC.p_owner.p_detailedCompany){
	p_remainingTotals.adjustRemainingGasDeliveryCompanies_m3(engineGC,  - yearlyGasDelivery_m3);
} 
  }

  protected void f_createGasProfileFromSurvey( GridConnection engineGC, com.zenmo.zummon.companysurvey.GridConnection surveyGC ) { 

if (surveyGC.getNaturalGas().getHourlyDelivery_m3() != null && surveyGC.getNaturalGas().getHourlyDelivery_m3().hasNumberOfValuesForOneYear()) {
	f_createGasProfileFromGasTS( engineGC, surveyGC );
}
else if (surveyGC.getNaturalGas().getAnnualDelivery_m3() != null && surveyGC.getNaturalGas().getAnnualDelivery_m3() > 0) {
	double yearlyGasDelivery_m3 = surveyGC.getNaturalGas().getAnnualDelivery_m3();
	f_createGasProfileFromAnnualGasTotal( engineGC, yearlyGasDelivery_m3 );
}
else {
	f_createGasProfileFromEstimates( engineGC );
} 
  }

  protected 
double 
 f_createHeatProfileFromGasSurvey( GridConnection engineGC, com.zenmo.zummon.companysurvey.GridConnection surveyGC, OL_GridConnectionHeatingType heatingType ) { 

if (surveyGC.getNaturalGas().getHourlyDelivery_m3() != null && surveyGC.getNaturalGas().getHourlyDelivery_m3().hasNumberOfValuesForOneYear()) {
	return f_createHeatProfileFromGasTS( engineGC, surveyGC, heatingType );
}
else if ( surveyGC.getNaturalGas().getAnnualDelivery_m3() != null && surveyGC.getNaturalGas().getAnnualDelivery_m3() > 0) {
	double yearlyGasDelivery_m3 = surveyGC.getNaturalGas().getAnnualDelivery_m3();
	double ratioGasUsedForHeating = f_getRatioGasUsedForHeating(surveyGC);
	return f_createHeatProfileFromAnnualGasTotal( engineGC, heatingType, yearlyGasDelivery_m3, ratioGasUsedForHeating );
}
else {
	return f_createHeatProfileFromEstimates( engineGC );
} 
  }

  protected 
double 
 f_createHeatProfileFromGasTS( GridConnection engineGC, com.zenmo.zummon.companysurvey.GridConnection surveyGC, OL_GridConnectionHeatingType heatingType ) { 

// Gas profile
//double[] profile_m3ph = f_convertFloatArrayToDoubleArray(surveyGC.getNaturalGas().getHourlyDelivery_m3().getFlatDataPoints());
double[] profile_m3pqh = f_timeSeriesToQuarterHourlyDoubleArray(surveyGC.getNaturalGas().getHourlyDelivery_m3());
// TODO: Check startdate of profile! Perhaps update vallum method to do so?
//traceln("Gas data array length: %s", profile_m3ph.length);
//double[] a_arguments_hr = ListUtil.doubleListToArray(defaultProfiles_data.arguments_hr());

double dataTimeStep_h = 0.25;
double[] a_arguments_hr = new double[profile_m3pqh.length];
for (int i = 0; i<profile_m3pqh.length; i++) {
	a_arguments_hr[i] = i*dataTimeStep_h;
}

double yearlyGasDelivery_m3pa = Arrays.stream(profile_m3pqh).sum();

String energyAssetName = engineGC.p_ownerID + " custom building heat profile";
// First check what the heat conversion efficiency is from gas
double gasToHeatEfficiency = f_getGasToHeatEfficiency(heatingType);
// Then check which part of the gas consumption is used for heating
double ratioGasUsedForHeating = f_getRatioGasUsedForHeating(surveyGC);
// Finally, multiply the gas profile with the total conversion factor to get the heat profile
double[] profile_kWhpqh = ZeroMath.arrayMultiply(profile_m3pqh, avgc_data.p_gas_kWhpm3 * gasToHeatEfficiency * ratioGasUsedForHeating);
J_ProfilePointer profilePointer = f_createEngineProfile(energyAssetName, a_arguments_hr, profile_kWhpqh, OL_ProfileUnits.KWHPQUARTERHOUR);

// Then we create the profile asset and name it
J_EAProfile j_ea = new J_EAProfile(engineGC, OL_EnergyCarriers.HEAT, profilePointer, null , energyModel.p_timeParameters);
j_ea.setEnergyAssetName(energyAssetName);

if(engineGC.p_owner.p_detailedCompany){
	p_remainingTotals.adjustRemainingGasDeliveryCompanies_m3(engineGC,  - yearlyGasDelivery_m3pa);
}

return max(profile_m3pqh)/dataTimeStep_h; 
  }

  protected 
double 
 f_getGasToHeatEfficiency( OL_GridConnectionHeatingType heatingType ) { 

switch (heatingType){
	case GAS_BURNER:
	case HYBRID_HEATPUMP:
		return avgc_data.p_avgEfficiencyGasBurner_fr;
	case GAS_CHP:
		return avgc_data.p_avgEfficiencyCHP_thermal_fr;
	default:
		throw new RuntimeException("Unable to find Gas to Heat efficiency of heatingType: " + heatingType);
} 
  }

  protected 
double 
 f_getRatioGasUsedForHeating( com.zenmo.zummon.companysurvey.GridConnection surveyGC ) { 

if (surveyGC.getNaturalGas().getPercentageUsedForHeating() != null) {
	return surveyGC.getNaturalGas().getPercentageUsedForHeating() / 100.0;
}
else {
	return 1.0;
} 
  }

  protected void f_createGasProfileFromEstimates( GridConnection engineGC ) { 

double yearlyGasDelivery_m3 = engineGC.p_floorSurfaceArea_m2 * avgc_data.p_avgCompanyGasConsumption_m3pm2;
f_createGasProfileFromAnnualGasTotal(engineGC, yearlyGasDelivery_m3);

if(engineGC.p_owner.p_detailedCompany){
	p_remainingTotals.adjustRemainingGasDeliveryCompanies_m3(engineGC,  - yearlyGasDelivery_m3);
} 
  }

  protected 
double 
 f_createHeatProfileFromEstimates( GridConnection engineGC ) { 

double yearlyGasConsumption_m3 = engineGC.p_floorSurfaceArea_m2 * avgc_data.p_avgCompanyGasConsumption_m3pm2;
double yearlyHeatConsumption_kWh = yearlyGasConsumption_m3 * avgc_data.p_gas_kWhpm3;
return f_createHeatProfileFromAnnualHeatTotal( engineGC, yearlyHeatConsumption_kWh ); 
  }

  protected 
double 
 f_createHeatProfileFromHeatTS( GridConnection engineGC, com.zenmo.zummon.companysurvey.GridConnection surveyGC ) { 


String energyAssetName = engineGC.p_ownerID + " custom heat profile";
// Heat profile

//double[] profile_kWhpqh = f_convertFloatArrayToDoubleArray(surveyGC.getHeat().getHeatDeliveryTimeSeries_kWh().getFlatDataPoints());
double[] profile_kWhpqh = f_timeSeriesToQuarterHourlyDoubleArray(surveyGC.getHeat().getHeatDeliveryTimeSeries_kWh());

double[] a_arguments_hr;
double dataTimeStep_h;
if ( profile_kWhpqh.length > 10000) { // if longer than 10_000 values, conclude it's quarter-hourly data, not hourly
	dataTimeStep_h = 0.25;
	a_arguments_hr = new double[profile_kWhpqh.length];
	for (int i = 0; i<profile_kWhpqh.length; i++) {
		a_arguments_hr[i] = i*dataTimeStep_h;
	}
} else {
	//dataTimeStep_h = 1;
	throw new RuntimeException("Assumed heatprofile was quarter-hourly, but it has less than 10_000 datapoints!");
}
ZeroMath.arrayMultiply(profile_kWhpqh, avgc_data.p_avgEfficiencyDistrictHeatingDeliverySet_fr);
J_ProfilePointer profilePointer = f_createEngineProfile(energyAssetName, a_arguments_hr, profile_kWhpqh, OL_ProfileUnits.KWHPQUARTERHOUR);
// We multiply by the delivery set efficiency to go from delivery to consumption
// TODO: Fix this for LT_DISTRICTHEAT, they have a different efficiency!
 
// Then we create the profile asset and name it
J_EAProfile j_ea = new J_EAProfile(engineGC, OL_EnergyCarriers.HEAT, profilePointer, null , energyModel.p_timeParameters);
j_ea.setEnergyAssetName(energyAssetName);

return max(profile_kWhpqh)/dataTimeStep_h; 
  }

  protected 
double 
 f_createHeatProfileFromAnnualHeatTotal( GridConnection engineGC, double yearlyConsumptionHeat_kWh ) { 

// We assume the heat consumption follows a standard profile
String profileName = "default_building_heat_demand_fr";
J_ProfilePointer profilePointer = energyModel.f_findProfile(profileName);
new J_EAConsumption(engineGC, OL_EnergyAssetType.HEAT_DEMAND, profileName, yearlyConsumptionHeat_kWh, OL_EnergyCarriers.HEAT, energyModel.p_timeParameters, profilePointer);

return yearlyConsumptionHeat_kWh * max(profilePointer.getAllValues())/energyModel.p_timeParameters.getTimeStep_h(); 
  }

  protected 
double 
 f_createHeatProfileFromSurvey( GridConnection engineGC, com.zenmo.zummon.companysurvey.GridConnection surveyGC ) { 

if (surveyGC.getHeat() != null && surveyGC.getHeat().getHeatDeliveryTimeSeries_kWh() != null) {
	return f_createHeatProfileFromHeatTS(engineGC, surveyGC);
}
else if (surveyGC.getHeat() != null && surveyGC.getHeat().getAnnualDistrictHeatingDelivery_GJ() != null) {
	double yearlyHeatDelivery_kWh = surveyGC.getHeat().getAnnualDistrictHeatingDelivery_GJ()*277.777778 ;
	// TODO: Fix this for LT_DISTRICTHEAT, they have a different efficiency!
	double yearlyHeatConsumption_kWh = yearlyHeatDelivery_kWh * avgc_data.p_avgEfficiencyDistrictHeatingDeliverySet_fr;
	return f_createHeatProfileFromAnnualHeatTotal(engineGC, yearlyHeatConsumption_kWh);
}
else {
	return f_createHeatProfileFromEstimates(engineGC);
} 
  }

  void f_setDefaultHeatingStrategies(  ) { 

// Triples ( heatingType, hasThermalBuilding, hasHeatBuffer )
Triple<OL_GridConnectionHeatingType, Boolean, Boolean> triple = null;

triple = Triple.of(OL_GridConnectionHeatingType.GAS_BURNER, false, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );
triple = Triple.of(OL_GridConnectionHeatingType.GAS_BURNER, true, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );
triple = Triple.of(OL_GridConnectionHeatingType.GAS_BURNER, true, true);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );

triple = Triple.of(OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, false, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );
triple = Triple.of(OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, true, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementPIcontrol.class );
triple = Triple.of(OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, true, true);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementPIcontrol.class );

triple = Triple.of(OL_GridConnectionHeatingType.HYBRID_HEATPUMP, false, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementProfileHybridHeatPump.class );
triple = Triple.of(OL_GridConnectionHeatingType.HYBRID_HEATPUMP, true, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementPIcontrolHybridHeatpump.class );
triple = Triple.of(OL_GridConnectionHeatingType.HYBRID_HEATPUMP, true, true);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementPIcontrolHybridHeatpump.class );

triple = Triple.of(OL_GridConnectionHeatingType.DISTRICTHEAT, false, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );
triple = Triple.of(OL_GridConnectionHeatingType.DISTRICTHEAT, true, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );
triple = Triple.of(OL_GridConnectionHeatingType.DISTRICTHEAT, true, true);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );

triple = Triple.of(OL_GridConnectionHeatingType.LT_DISTRICTHEAT, false, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );
triple = Triple.of(OL_GridConnectionHeatingType.LT_DISTRICTHEAT, true, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );
triple = Triple.of(OL_GridConnectionHeatingType.LT_DISTRICTHEAT, true, true);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );

triple = Triple.of(OL_GridConnectionHeatingType.HYDROGENBURNER, false, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );
triple = Triple.of(OL_GridConnectionHeatingType.HYDROGENBURNER, true, false);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class );
triple = Triple.of(OL_GridConnectionHeatingType.HYDROGENBURNER, true, true);
energyModel.c_defaultHeatingStrategies.put( triple, J_HeatingManagementSimple.class ); 
  }

  protected void f_addCustomHeatingSetup( GridConnection engineGC, com.zenmo.zummon.companysurvey.GridConnection surveyGC ) { 

throw new RuntimeException("HeatingType is CUSTOM. You must override the function: f_addCustomHeatingSetup!"); 
  }

  protected void f_addCustomHeatAsset( GridConnection parentGC, double maxHeatOutputPower_kW ) { 

throw new RuntimeException("HeatingType is CUSTOM. You must override the function: f_addCustomHeatAsset!"); 
  }

  protected void f_addCarsToHouses( GCHouse house ) { 

double probabilityForLeftOverCar = house.p_eigenOprit ? v_probabilityForAdditionalCar_privateParking : v_probabilityForAdditionalCar_publicParking;
int amountOfOwnedCars = (int) floor(avgc_data.p_avgNrOfCarsPerHouse) + (randomTrue(probabilityForLeftOverCar) ? 1 : 0);

////Create Vehicles based on the amount of owned cars
for(int i = 0; i < amountOfOwnedCars ; i++){
	double tripTrackerScaling = 1;
	
	if(i>0){//If more than 1 car: 2+ cars all have smaller travel average travel distance
		tripTrackerScaling *= avgc_data.p_avgAnnualTravelDistanceSecondVSFirstCar_fr;
	}
	//Oprit? -> only then you should have a chance to start with EV (public ev is not supported by sliders, public chargepoint is then used instead)
	if( house.p_eigenOprit){
		if (randomTrue( avgc_data.p_shareOfElectricVehicleOwnership)){
			J_EAEV ev = f_addElectricVehicle(house, OL_EnergyAssetType.ELECTRIC_VEHICLE, true, 0, 0);
			ev.getTripTracker().setAnnualDistance_km(ev.getTripTracker().getAnnualDistance_km()*tripTrackerScaling);
			//Set Default charging management
			if(house.f_getCurrentChargingType() == OL_ChargingAttitude.NONE){
				house.f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
			}
		}
		else{
			J_EAFuelVehicle petroleumFuelVehicle = f_addPetroleumFuelVehicle(house, OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE, true, 0);
			petroleumFuelVehicle.getTripTracker().setAnnualDistance_km(petroleumFuelVehicle.getTripTracker().getAnnualDistance_km()*tripTrackerScaling);
		}
	}
	else {
		J_EAFuelVehicle petroleumFuelVehicle = f_addPetroleumFuelVehicle(house, OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE, true, 0);
		petroleumFuelVehicle.getTripTracker().setAnnualDistance_km(petroleumFuelVehicle.getTripTracker().getAnnualDistance_km()*tripTrackerScaling);
	}
} 
  }

  protected void f_calculateProbabilitiesForAdditionalCar( List<Building_data> buildingDataHouses ) { 

//Precalculate the amount of households and households that have private parking for vehicle distribution
int totalNumberOfHouses = 0;
int numberOfHousesPrivateParking = 0;
for (Building_data houseBuildingData : buildingDataHouses) {
	totalNumberOfHouses++;
	if(houseBuildingData.has_private_parking() != null && houseBuildingData.has_private_parking()){
		numberOfHousesPrivateParking++;
	}
}

//Determine the total cars in the area based on the average of the area
int totalCars = roundToInt(avgc_data.p_avgNrOfCarsPerHouse * totalNumberOfHouses);
int numberOfHousesPublicParking = totalNumberOfHouses - numberOfHousesPrivateParking;

//Calculate the base number of cars that everyone gets, and the total leftover cars that should be distributed
int baseCars = (int) floor(avgc_data.p_avgNrOfCarsPerHouse);
int leftOverCars = totalCars - baseCars * totalNumberOfHouses;

// Determine leftover cars distributed for private and public parking (bias to private parking)
int leftOverForPrivateParking = min(leftOverCars, numberOfHousesPrivateParking);
int leftOverForPublicParking = max(0, leftOverCars - leftOverForPrivateParking);

//Calculate the leftover car probability for private and public parking
v_probabilityForAdditionalCar_privateParking = ((double) leftOverForPrivateParking) / numberOfHousesPrivateParking; // Calculate probability for leftover car for private parking
v_probabilityForAdditionalCar_publicParking = ((double) leftOverForPublicParking) / numberOfHousesPublicParking; // Calculate probability for leftover car for public parking
 
  }

  void f_initializeInterfacePointers(  ) { 

//Set parameters/pointers in the interface
zero_Interface.zero_loader = this;
zero_Interface.energyModel = energyModel;
zero_Interface.uI_Results.energyModel = energyModel;
zero_Interface.project_data = project_data;
zero_Interface.settings = settings;
zero_Interface.user = user;
 
  }

  public void f_setSimulationTimeParameters(  ) { 

//Sim start year
int simStartYear = getExperiment().getEngine().getStartDate().getYear() + 1900;  // 1900 years offset because of Java/AnyLogic convention

// Create date at start of simulation year to use to calculate v_simStartHour_h
Date d = new Date();
d.setYear(simStartYear - 1900);
d.setMonth(0);
d.setHours(0);
d.setSeconds(0);
d.setMinutes(0);
d.setDate(1);

//Calculate sim start hour
double simStartTime_h = roundToInt((getExperiment().getEngine().getStartDate().getTime() - d.getTime())/1000.0/60/60); //Get time is in ms -> converted into hours

//Fix for if start is within summer time, the v_simStartHour_h is not correct anymore
double summerTimeStart_h = avgc_data.map_yearlySummerWinterTimeStartHour.get(simStartYear).getFirst();
double winterTimeStart_h = avgc_data.map_yearlySummerWinterTimeStartHour.get(simStartYear).getSecond();
if(simStartTime_h > summerTimeStart_h && simStartTime_h < winterTimeStart_h){
	simStartTime_h += 1;
}

//Set sim duration if it is set
double simDuration_h; //Sim duration in hours
if(getExperiment().getEngine().getStopDate() != null){ //If experiment has set time, it gets bias
	simDuration_h = roundToInt(((double)getExperiment().getEngine().getStopDate().getTime() - getExperiment().getEngine().getStartDate().getTime())/1000.0/60/60); //Get time is in ms -> converted into hours
	if(simStartTime_h > summerTimeStart_h && simStartTime_h + simDuration_h > winterTimeStart_h){//Compensate if start time is in summer time, and end time is in winter time -> simulation would otherwise have 1 hour too much
		simDuration_h -= 1;
	}
	if(simStartTime_h < summerTimeStart_h && simStartTime_h + simDuration_h < winterTimeStart_h){//Compensate if start time is in winter time, and end time is in summer time -> simulation would otherwise have 1 hour too less
		simDuration_h += 1;
	}
}
else{
	simDuration_h = settings.simDuration_h();
}

//Checks
if (simStartTime_h % 24 != 0) {
	throw new RuntimeException("Impossible to run a model that does not start at midnight. Please check the start in the simulation settings.");
}
if (simDuration_h % 24 != 0) {
	throw new RuntimeException("Impossible to run a model that does not have a runtime that is an exact multiple of a day. Please check the start and endtime in the simulation settings.");
}
if (simDuration_h <= 0) {
	throw new RuntimeException("Impossible to run a model that has a runtime that is <= 0. Please check the start and endtime in the simulation settings or simduration_h in the 'settings' class.");
}

//Calculate simEndTime_h
double simEndTime_h = simStartTime_h + simDuration_h;

//Get month start hours based on if leap year or not
double[] monthStartHours;
if(simStartYear % 4 == 0){
	monthStartHours = avgc_data.monthStartHours_leapYear;
}
else{
	monthStartHours = avgc_data.monthStartHours_default;
}

//Create time parameters object in engine
energyModel.p_timeParameters = new J_TimeParameters(
	settings.timeStep_h(),
	simStartYear,
	monthStartHours,
	simStartTime_h,
	simEndTime_h,
	settings.summerWeekNumber(),
	settings.winterWeekNumber()
);

//Initialize time variables object in engine
energyModel.p_timeVariables = new J_TimeVariables(0, energyModel.p_timeParameters); 
  }

  
boolean 
 f_getAccessOfSurveyGC( boolean dataSharingAgreed, Uuid companyUUID ) { 

// If public model: only dataSharingAgreed matters
if (settings.isPublicModel()) {
    return dataSharingAgreed;
}

// If private model: several conditions allow access
return 	user.GCAccessType == OL_UserGCAccessType.FULL ||
        dataSharingAgreed ||
        user.accessibleCompanyIDs.contains(companyUUID.toString()); 
  }

  
boolean 
 f_isLocatedInActiveNBH( double lat, double lon ) { 

if(user.NBHAccessType == OL_UserNBHAccessType.FULL){
	return true;
}
else{
	for(GIS_Object activeNBH : c_activeNBH){
		if(activeNBH.gisRegion.contains(lat, lon)){
			return true;
		}
	}
	return false;
} 
  }

  void f_removeObjectsNotInActiveNBH(  ) { 

//GridNodes
for(GridNode_data dataGN : new ArrayList<GridNode_data>(c_gridNode_data)){
	if(!dataGN.gridnode_id().equals("T0") && !f_isLocatedInActiveNBH(dataGN.latitude(), dataGN.longitude())){
		c_gridNode_data.remove(dataGN);
	}
}

//Buildings
for(Building_data dataCompanyBuilding : new ArrayList<Building_data>(c_companyBuilding_data)){
	if(!f_isLocatedInActiveNBH(dataCompanyBuilding.latitude(), dataCompanyBuilding.longitude())){
		c_companyBuilding_data.remove(dataCompanyBuilding);
	}
}
for(Building_data dataCompanyBuilding : new ArrayList<Building_data>(c_houseBuilding_data)){
	if(!f_isLocatedInActiveNBH(dataCompanyBuilding.latitude(), dataCompanyBuilding.longitude())){
		c_houseBuilding_data.remove(dataCompanyBuilding);
	}
}
for(Building_data dataCompanyBuilding : new ArrayList<Building_data>(c_remainingBuilding_data)){
	if(!f_isLocatedInActiveNBH(dataCompanyBuilding.latitude(), dataCompanyBuilding.longitude())){
		c_remainingBuilding_data.remove(dataCompanyBuilding);
	}
}

//EA GCs
for(Solarfarm_data dataSF : new ArrayList<Solarfarm_data>(c_solarfarm_data)){
	if(!f_isLocatedInActiveNBH(dataSF.latitude(), dataSF.longitude())){
		c_solarfarm_data.remove(dataSF);
	}
}
for(Windfarm_data dataWF : new ArrayList<Windfarm_data>(c_windfarm_data)){
	if(!f_isLocatedInActiveNBH(dataWF.latitude(), dataWF.longitude())){
		c_windfarm_data.remove(dataWF);
	}
}
for(Battery_data dataBattery : new ArrayList<Battery_data>(c_battery_data)){
	if(!f_isLocatedInActiveNBH(dataBattery.latitude(), dataBattery.longitude())){
		c_battery_data.remove(dataBattery);
	}
}
for(Chargingstation_data dataCS : new ArrayList<Chargingstation_data>(c_chargingstation_data)){
	if(!f_isLocatedInActiveNBH(dataCS.latitude(), dataCS.longitude())){
		c_chargingstation_data.remove(dataCS);
	}
}

//Additional GIS Objects
for(ParkingSpace_data dataParking : new ArrayList<ParkingSpace_data>(c_parkingSpace_data)){
	if(!f_isLocatedInActiveNBH(dataParking.latitude(), dataParking.longitude())){
		c_parkingSpace_data.remove(dataParking);
	}
}
for(Parcel_data dataParcel : new ArrayList<Parcel_data>(c_parcel_data)){
	if(!f_isLocatedInActiveNBH(dataParcel.latitude(), dataParcel.longitude())){
		c_parcel_data.remove(dataParcel);
	}
}
for(Cable_data dataCable : new ArrayList<Cable_data>(c_cable_data)){
	if(!f_isLocatedInActiveNBH(dataCable.latitude(), dataCable.longitude())){
		c_cable_data.remove(dataCable);
	}
}
 
  }

  private 
OL_GISObjectType 
 f_getNBHGISObjectType( GIS_Object NBH, String NBHCode, OL_GISObjectType defaultGISObjectType ) { 

if( defaultGISObjectType == OL_GISObjectType.ANTI_LAYER || 
	(user.NBHAccessType == OL_UserNBHAccessType.SPECIFIED && !user.accessibleNBH.contains(NBHCode))
	){
	return OL_GISObjectType.ANTI_LAYER;	
}
else{
	c_activeNBH.add(NBH);
	return OL_GISObjectType.REGION;
} 
  }

  public 
double 
 f_getSpaceHeatingDemand_PBL_kWh( double floorSurfaceArea_m2, PBL_SpaceHeatingAndResidents_data spaceHeatingObjectPBL, double localFactor, double regionalClimateCorrectionFactor ) { 

//Get the slope and constant from the PBL data
double slope_m3pm2pa = spaceHeatingObjectPBL.slope_space_heating_gas_m3pm2a();
double constant_m3pa = spaceHeatingObjectPBL.constant_space_heating_gas_m3pa();

//Determine the space heating gas demand based on the floor surface
double functionalSpaceHeatingDemand_m3pa = floorSurfaceArea_m2 * slope_m3pm2pa + constant_m3pa;

//Convert to kwh and multiply by the local and climate factors
double functionalSpaceHeatingDemand_kWh = functionalSpaceHeatingDemand_m3pa * avgc_data.p_gas_kWhpm3 * localFactor * regionalClimateCorrectionFactor ;
return functionalSpaceHeatingDemand_kWh; 
  }

  public 
PBL_SpaceHeatingAndResidents_data 
 f_getPBLObject_spaceHeatingAndResidents( OL_PBL_DwellingType dwellingType, int buildYear, OL_PBL_OwnershipType ownershipType, OL_GridConnectionInsulationLabel insulationLabel ) { 

int constructionPeriod = J_PBLUtil.getConstructionPeriodOption_spaceHeatingAndResidents(buildYear);
int regressionPopulation = J_PBLUtil.getPBLRegressionPopulation(insulationLabel, dwellingType);

PBL_SpaceHeatingAndResidents_data PBLObject_spaceHeatingAndResidents = findFirst(c_lookupTablePBL_spaceHeatingAndResidents, pbl -> pbl.dwelling_type() == dwellingType &&
																							   pbl.construction_period() == constructionPeriod &&
																							   pbl.ownership_type() == ownershipType &&
																							   pbl.insulation_label() == insulationLabel &&
																							   pbl.regression_population() == regressionPopulation
																							   );

// Check for no matching pbl object found
if (PBLObject_spaceHeatingAndResidents == null) {
    System.out.println("Error: no matching pbl object found for spaceheating with conditions:");
    System.out.println(" dwellingType = " + dwellingType);
    System.out.println(" constructionPeriod = " + constructionPeriod);
    System.out.println(" ownershipType = " + ownershipType);
    System.out.println(" insulationLabel = " + insulationLabel);
    System.out.println(" regressionPopulation = " + regressionPopulation);
    throw new RuntimeException("No matching PBL object found!");
}

return PBLObject_spaceHeatingAndResidents; 
  }

  public 
PBL_DHWAndCooking_data 
 f_getPBLObject_DHWAndCooking( int buildYear, double floorSurfaceArea_m2, int householdSize ) { 

int constructionPeriod = J_PBLUtil.getConstructionPeriodOption_DHWAndCooking(buildYear);
int surfaceCode = J_PBLUtil.getTNOFloorSurfaceCode(floorSurfaceArea_m2);

PBL_DHWAndCooking_data PBLObject_DHWAndCooking = findFirst(c_lookupTablePBL_DHWAndCooking, pbl -> pbl.construction_period() == constructionPeriod &&
																								  pbl.surface_code() == surfaceCode &&
																								  pbl.household_size() == householdSize);
																								  
// Check for no matches
if (PBLObject_DHWAndCooking == null) {
    System.out.println("Error: no matching PBL object found for PBL DHW and Cooking demand with conditions:");
    System.out.println("  constructionPeriod = " + constructionPeriod);
    System.out.println("  floorSurfaceArea_m2 = " + floorSurfaceArea_m2);
    System.out.println("  surfaceCode = " + surfaceCode);
    System.out.println("  householdSize = " + householdSize);
    throw new RuntimeException("No matching PBL object found!"); // Misschien wat een te harde error? 
    													  // Hij kan altijd nog terug vallen op de backup toch?
}

return PBLObject_DHWAndCooking; 
  }

  protected 
OL_GridConnectionEnergyLabel 
 f_estimateEnergyLabel( int constructionYear ) { 

if (constructionYear < 1980) {
	return OL_GridConnectionEnergyLabel.D;
}
else if (constructionYear < 1996) {
	return OL_GridConnectionEnergyLabel.C;
}
else if (constructionYear < 2008) {
	return OL_GridConnectionEnergyLabel.B;
}
else {
	return OL_GridConnectionEnergyLabel.A;
} 
  }

  public 
int 
 f_getNumberOfResidents_PBL( PBL_SpaceHeatingAndResidents_data spaceHeatingObjectPBL, double floorSurfaceArea_m2 ) { 

// Determine the number of residents
int numberOfResidents = roundToInt(floorSurfaceArea_m2 * spaceHeatingObjectPBL.slope_residents() + spaceHeatingObjectPBL.constant_residents());
if(numberOfResidents < 1){
	numberOfResidents = 1;
}
else if(numberOfResidents > 5){	
	traceln("House found with more than 5 residents -> number of residents is capped to 5! Number of residents found: " + numberOfResidents + ", floorSurfaceArea_m2: " + floorSurfaceArea_m2);
	numberOfResidents = 5;
}
return numberOfResidents; 
  }

  protected void f_addHeatAssetsToHouses( GCHouse house, Double gasDemand_m3pa, OL_GridConnectionHeatingType heatingType, OL_HouseholdCookingMethod cookingType ) { 

//Add building heat model and asset
double annualNaturalGasConsumption_kwhpa;
if(gasDemand_m3pa != null) {
	annualNaturalGasConsumption_kwhpa = gasDemand_m3pa * avgc_data.p_gas_kWhpm3;
}
else{
	annualNaturalGasConsumption_kwhpa =  uniform(avgc_data.p_avgHouseGasConsumption_m3_yr - avgc_data.p_maxAvgHouseGasConsumptionOffset_m3pa, 
										         avgc_data.p_avgHouseGasConsumption_m3_yr + avgc_data.p_maxAvgHouseGasConsumptionOffset_m3pa)
	 											 * avgc_data.p_gas_kWhpm3;
}

double spaceHeatingDemand_kwhpa;
double hotWaterDemand_kWhpa;
double cookingDemand_kWhpa;
int numberOfResidents = 0;
if(house.p_PBLParameters != null){
	PBL_SpaceHeatingAndResidents_data spaceHeatingDataObject = f_getPBLObject_spaceHeatingAndResidents(house.p_PBLParameters.getDwellingType(), house.p_buildYear, house.p_PBLParameters.getOwnershipType(), house.p_insulationLabel);
	spaceHeatingDemand_kwhpa = f_getSpaceHeatingDemand_PBL_kWh(house.p_floorSurfaceArea_m2, spaceHeatingDataObject, house.p_PBLParameters.getLocalFactor(), house.p_PBLParameters.getRegionalClimateCorrectionFactor());
	
	numberOfResidents = f_getNumberOfResidents_PBL(spaceHeatingDataObject, house.p_floorSurfaceArea_m2);
	
	PBL_DHWAndCooking_data DHWAndCookingDataObject = f_getPBLObject_DHWAndCooking(house.p_buildYear, house.p_floorSurfaceArea_m2, numberOfResidents);
	hotWaterDemand_kWhpa = DHWAndCookingDataObject.dhw_gas_demand_m3pa() * avgc_data.p_gas_kWhpm3;
	cookingDemand_kWhpa = DHWAndCookingDataObject.cooking_gas_demand_m3pa() * avgc_data.p_gas_kWhpm3;
}
else{
	numberOfResidents = f_estimateHouseNmbrResidents();
	
	spaceHeatingDemand_kwhpa = annualNaturalGasConsumption_kwhpa * avgc_data.p_avgSpaceHeatingTotalGasConsumptionShare_fr;
	hotWaterDemand_kWhpa = annualNaturalGasConsumption_kwhpa * avgc_data.p_avgDHWTotalGasConsumptionShare_fr;
	cookingDemand_kWhpa = annualNaturalGasConsumption_kwhpa * avgc_data.p_avgCookingTotalGasConsumptionShare_fr;

	//hotWaterDemand_kWhpa = f_estimateHouseDHWDemand_kWh(house.p_floorSurfaceArea_m2);
	if(cookingDemand_kWhpa <= 0){ // If still 0 -> no gas consumption in house, make estimation for cooking 
		cookingDemand_kWhpa = f_estimateHouseCookingDemand_kWh();
	}
}

//Get the house heating preferences
J_HeatingPreferences heatingPreferences = f_getHouseHeatingPreferences();

f_addBuildingHeatModel(house, house.p_floorSurfaceArea_m2, spaceHeatingDemand_kwhpa, heatingPreferences);

//Add hot water demand
double maxHotWaterDemand_kW = 0;
if(hotWaterDemand_kWhpa > 0){
	maxHotWaterDemand_kW = f_addHotWaterDemand(house, hotWaterDemand_kWhpa, numberOfResidents);
}

//Add cooking demand
if(cookingType == null || cookingType == OL_HouseholdCookingMethod.UNKNOWN){
	cookingType = avgc_data.p_avgHouseCookingMethod;
}
f_addCookingAsset(house, cookingType, cookingDemand_kWhpa);

//Determine required heating capacity for the heating asset	
double maximalTemperatureDifference_K = 30.0; // Approximation
double maxHeatOutputPower_kW = house.p_BuildingThermalAsset.getLossFactor_WpK() * maximalTemperatureDifference_K / 1000 + maxHotWaterDemand_kW;

/*if (hotWaterDemand_kWhpa > 0) {
	// A standard domestic peak is roughly 25-30 kW for instant hot water delivery
	maxHeatOutputPower_kW += 100.0; 
}*/

//Check if heating type is known: Else: take avgc
if(heatingType == null || heatingType == OL_GridConnectionHeatingType.UNKNOWN){
	heatingType = avgc_data.p_avgHouseHeatingMethod;
}

//Add heating asset
f_addHeatAsset(house, heatingType, maxHeatOutputPower_kW);

//Add heating management and set the heating preferences
house.f_addHeatManagement(heatingType, false);
house.f_setHeatingPreferences(heatingPreferences);

//For calibrating AVG data PBL loss factor 
totalSpaceHeatDemand_kwhpa += spaceHeatingDemand_kwhpa; 
  }

  
int 
 f_estimateHouseNmbrResidents(  ) { 

int numberOfResidents = uniform_discr(1,5);
return numberOfResidents; 
  }

  
double 
 f_estimateHouseCookingDemand_kWh(  ) { 

double yearlyCookingDemand_kWh = uniform_discr(70,130); //SOURCE? -> Put in AVGC!
return yearlyCookingDemand_kWh;
 
  }

  
Double 
 f_getGNTotalPV_kWp( GridNode GN ) { 

//Function to get the total PV nominal power under grid node
Double totalPVPower_kW = null;

for (Building_data house : c_houseBuilding_data){
	if(house.pv_installed_kwp() != null && house.gridnode_id() != null && house.gridnode_id().equals(GN.p_gridNodeID)) {
		if (totalPVPower_kW == null){
			totalPVPower_kW = 0.0;
		}
		totalPVPower_kW += house.pv_installed_kwp();
	}
}

for (Building_data company : c_companyBuilding_data){
	if(company.pv_installed_kwp() != null && company.gridnode_id() != null && company.gridnode_id().equals(GN.p_gridNodeID)) {
		if (totalPVPower_kW == null){
			totalPVPower_kW = 0.0;
		}
		totalPVPower_kW += company.pv_installed_kwp();
	}
}

//if (totalPVPower_kW == null) return null;

for (Solarfarm_data solarfarm : c_solarfarm_data){
	if(solarfarm.initially_active() && solarfarm.capacity_electric_kw() > 0 && solarfarm.gridnode_id() != null && solarfarm.gridnode_id().equals(GN.p_gridNodeID)) {
		if (totalPVPower_kW == null){
			totalPVPower_kW = 0.0;
		}
		totalPVPower_kW += solarfarm.capacity_electric_kw();
	}
}

for (Windfarm_data windpark : c_windfarm_data){
	if(windpark.initially_active() && windpark.capacity_electric_kw() > 0 && windpark.gridnode_id() != null && windpark.gridnode_id().equals(GN.p_gridNodeID)) {
		throw new RuntimeException("Windfarm found for grid node that is going to contain preprocessed profile data -> not allowed/supported yet.");
	}
}

return totalPVPower_kW; 
  }

  protected void f_addPVToHouses( GCHouse house, GridNode gn ) { 

double installedRooftopSolar_kW = house.v_liveAssetsMetaData.initialPV_kW != null ? house.v_liveAssetsMetaData.initialPV_kW : 0;
OL_PVOrientation pvOrientation = house.v_liveAssetsMetaData.PVOrientation;

if (gn.p_profileType == OL_GridNodeProfileLoaderType.INCLUDE_PV || gn.p_profileType == OL_GridNodeProfileLoaderType.NET_LOAD){ //dont count production if there is measured data on Node
	installedRooftopSolar_kW = 0;
}

if (installedRooftopSolar_kW > 0) {
	f_addPVProductionAsset(house, "Residential Solar", installedRooftopSolar_kW, pvOrientation);
} 
  }

  public void f_addPVProductionAsset( GridConnection parentGC, String asset_name, double installedPower_kW, OL_PVOrientation pvOrientation ) { 

J_TimeParameters timeParameters = energyModel.p_timeParameters;
OL_EnergyCarriers energyCarrier = OL_EnergyCarriers.ELECTRICITY;
J_ProfilePointer profilePointer = f_getPVTProfilePointer(pvOrientation);

J_EAProduction production_asset = new J_EAProduction(parentGC, OL_EnergyAssetType.PHOTOVOLTAIC, asset_name, energyCarrier, installedPower_kW, timeParameters, profilePointer); 
  }

  public 
J_ProfilePointer 
 f_getPVTProfilePointer( OL_PVOrientation pvtOrientation ) { 

J_ProfilePointer profilePointer = null;

if(pvtOrientation == null){
	throw new RuntimeException("Trying to get a pvt profile pointer whithout specifying the orientation. Not allowed!");
}
switch (pvtOrientation){
	case EASTWEST:
		profilePointer = energyModel.pp_PVProduction15DegEastWest_fr;
	case SOUTH:
		profilePointer = energyModel.pp_PVProduction35DegSouth_fr;
}

return profilePointer; 
  }

  public void f_addWindProductionAsset( GridConnection parentGC, String asset_name, double installedPower_kW ) { 

J_TimeParameters timeParameters = energyModel.p_timeParameters;
OL_EnergyCarriers energyCarrier = OL_EnergyCarriers.ELECTRICITY;
J_ProfilePointer profilePointer = energyModel.pp_windProduction_fr;

J_EAProduction production_asset = new J_EAProduction(parentGC, OL_EnergyAssetType.WINDMILL, asset_name, energyCarrier, installedPower_kW, timeParameters, profilePointer); 
  }

  public void f_addPTProductionAsset( GridConnection parentGC, String asset_name, double installedPower_kW, OL_PVOrientation ptOrientation ) { 

//CONCEPT VERSION
J_TimeParameters timeParameters = energyModel.p_timeParameters;
OL_EnergyCarriers energyCarrier = OL_EnergyCarriers.HEAT;
J_ProfilePointer profilePointer = f_getPVTProfilePointer(ptOrientation);

J_EAProduction production_asset = new J_EAProduction(parentGC, OL_EnergyAssetType.PHOTOVOLTAIC, asset_name, energyCarrier, installedPower_kW, timeParameters, profilePointer); 
  }

  
OL_PVOrientation 
 f_getPVOrientationFromZorm( com.zenmo.zummon.companysurvey.PVOrientation PVOrientationZorm ) { 

OL_PVOrientation pvOrientation = avgc_data.p_defaultPVOrientation;

if(PVOrientationZorm != null){
	switch(PVOrientationZorm){
		case SOUTH:
			pvOrientation = OL_PVOrientation.SOUTH;
			break;
		case EAST_WEST:
			pvOrientation = OL_PVOrientation.EASTWEST;
			break;
	}
}

return pvOrientation; 
  }

  protected 
J_ProfilePointer 
 f_getDHWProfile( int numberOfResidents ) { 

int randomIndex;
J_ProfilePointer ppDHWProfile = null;

double offset_h = (energyModel.p_timeParameters.getDayOfWeek1jan() - 1) * 24.0; //Monday = index 0: -> detailed DHW profiles always start on monday! -> To have no offset you need to subtract -1.

if(map_nrOfResidentsToDHWProfiles_data.containsKey(numberOfResidents) && map_nrOfResidentsToDHWProfiles_data.get(numberOfResidents).size() > 0){
	List<DHWProfile_data> profiles = map_nrOfResidentsToDHWProfiles_data.get(numberOfResidents);
	randomIndex = uniform_discr(0, profiles.size() - 1);
	DHWProfile_data dhwProfile = profiles.get(randomIndex);
	ppDHWProfile = f_createProfilePointer(dhwProfile.DHWProfileID(), dhwProfile.getArgumentsArray(), dhwProfile.getValuesArray(), dhwProfile.profileUnits(), offset_h);
	profiles.remove(randomIndex);
	if(!energyModel.map_nrOfResidentsToDHWprofiles.containsKey(numberOfResidents)){
		energyModel.map_nrOfResidentsToDHWprofiles.put(numberOfResidents, new ArrayList<>());
	}
	energyModel.map_nrOfResidentsToDHWprofiles.get(numberOfResidents).add(ppDHWProfile);
	energyModel.f_addProfile(ppDHWProfile);
}
else if (energyModel.map_nrOfResidentsToDHWprofiles.containsKey(numberOfResidents) && energyModel.map_nrOfResidentsToDHWprofiles.get(numberOfResidents).size() > 0){
	List<J_ProfilePointer> assignedProfiles = energyModel.map_nrOfResidentsToDHWprofiles.get(numberOfResidents);
	randomIndex = uniform_discr(0, assignedProfiles.size() - 1);
	ppDHWProfile = assignedProfiles.get(randomIndex);
}

return ppDHWProfile; 
  }

  protected 
J_ProfilePointer 
 f_createProfilePointer( String profileID, double[] arguments, double[] values, OL_ProfileUnits profileUnitType, Double offset_h ) { 

double dataTimeStep_h = (arguments[arguments.length-1] - arguments[0])/(arguments.length-1);
double simTimeStep_h = settings.timeStep_h(); 
double a_profile[];

double dataStartTime_h = offset_h != null ? arguments[0] - offset_h : arguments[0];

if (simTimeStep_h < dataTimeStep_h) { //Interpolate data to timeStep_h = 0.25
	//traceln("***** profilePointer using tableFunction to interpolate hourly data into quarter-hourly data ********");
	if ((dataTimeStep_h/simTimeStep_h)%1.0 != 0.0) {
		throw new RuntimeException("dataTimeStep_h is not an integer multiple of modelTimeStep! Unsupported dataformat!");
	}
	TableFunction tableFunction = new TableFunction(arguments, values, TableFunction.InterpolationType.INTERPOLATION_LINEAR, 2, TableFunction.OutOfRangeAction.OUTOFRANGE_REPEAT, 0.0);
	a_profile = new double[values.length*(int)(dataTimeStep_h/simTimeStep_h)];
	for (int i=0; i<a_profile.length; i++) {
		a_profile[i] = tableFunction.get(arguments[0]+i*simTimeStep_h);
	}
	dataTimeStep_h = simTimeStep_h;
} else if (simTimeStep_h > dataTimeStep_h) {
	throw new RuntimeException("dataTimeStep_h smaller than modelTimeStep! Unsupported dataformat! Need to implement downsampling to allow this");
} else {
	a_profile=values;
}

J_ProfilePointer profilePointer = new J_ProfilePointer(profileID, a_profile, dataTimeStep_h, dataStartTime_h, profileUnitType);	

return profilePointer; 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea viewArea = new ViewArea( this, null, 0, 0, 2200, 980 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1920.0, 980.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "viewArea", this.viewArea );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_input_Font = new Font("SansSerif", 1, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_connectedModels_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_projectDataTracking_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_loaderStartupDefault_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_createGridNodes_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("SansSerif", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_inputFiles_Font = new Font("SansSerif", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_inputFileFunctions_Font = _t_inputFiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_dataCollectionFill_Font = _t_inputFiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_createActorFunctions_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_createEnergyGC_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_createHouses_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_createCompanies_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_addEnergyAssetFunctions_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_createGISObjects_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_overwriteDatabaseValues_Font = _t_inputFiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_supportFunctions_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_connectToFunctions_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_DebuggingDataCollections_Font = new Font("SansSerif", 0, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_addSpecificSliderGC_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_filterSubScopeFunctions_Font = _t_connectedModels_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_canvas = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_projectDataTracking = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_loader = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_input = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_connectedModels = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_connectedModels = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_projectDataTracking = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_defaultStartup = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_dataCollections = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GridNodeFunctions = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_loaderStartupDefault = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_createGridNodes = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_dataInput = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_inputFiles = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_inputFileFunctions = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_dataCollectionFill = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_ActorFunctions = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_createActorFunctions = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_createEnergyGC = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_createEnergyGC = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_createHouses = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_createHouses = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_consumerGC_residential = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_createCompanies = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_createCompanies = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_consumerGC_businesspark = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_addEA = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_addEnergyAssetFunctions = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_addEAFunctions = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_createGISObjects = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_createGISObjects = 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_createGISObjects = 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_overwriteDatabaseValues = 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_supportFunctions = 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_supportFunctions = 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_connectToFunctions = 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_connectToFunctions = 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_DebuggingDataCollections = 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_addSpecificSliderGC = 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_addSpecificSliderGC = 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_subScopeFunctions = 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_filterSubScopeFunctions = 43;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 44;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rect_canvas, rect_projectDataTracking, rect_loader, txt_input, rect_connectedModels, t_connectedModels, txt_projectDataTracking, rect_defaultStartup, rect_dataCollections, rect_GridNodeFunctions, txt_loaderStartupDefault, txt_createGridNodes, rect_dataInput, text, t_inputFiles, t_inputFileFunctions, txt_dataCollectionFill, rect_ActorFunctions, txt_createActorFunctions, rect_createEnergyGC, txt_createEnergyGC, gr_consumerGC_residential, gr_consumerGC_businesspark, gr_addEAFunctions, gr_createGISObjects, txt_overwriteDatabaseValues, rect_supportFunctions, txt_supportFunctions, rect_connectToFunctions, txt_connectToFunctions, txt_DebuggingDataCollections, rect_addSpecificSliderGC, txt_addSpecificSliderGC, rect_subScopeFunctions, txt_filterSubScopeFunctions);
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level1_xjal() {
	  level1.addAll();
  }

  protected ShapeRectangle rect_canvas;
  protected ShapeRectangle rect_projectDataTracking;
  protected ShapeRectangle rect_loader;
  protected ShapeText txt_input;
  protected ShapeRectangle rect_connectedModels;
  protected ShapeText t_connectedModels;
  protected ShapeText txt_projectDataTracking;
  protected ShapeRectangle rect_defaultStartup;
  protected ShapeRectangle rect_dataCollections;
  protected ShapeRectangle rect_GridNodeFunctions;
  protected ShapeText txt_loaderStartupDefault;
  protected ShapeText txt_createGridNodes;
  protected ShapeRectangle rect_dataInput;
  protected ShapeText text;
  protected ShapeText t_inputFiles;
  protected ShapeText t_inputFileFunctions;
  protected ShapeText txt_dataCollectionFill;
  protected ShapeRectangle rect_ActorFunctions;
  protected ShapeText txt_createActorFunctions;
  protected ShapeRectangle rect_createEnergyGC;
  protected ShapeText txt_createEnergyGC;
  protected ShapeRectangle rect_createHouses;
  protected ShapeText txt_createHouses;
  protected ShapeGroup gr_consumerGC_residential;
  protected ShapeRectangle rect_createCompanies;
  protected ShapeText txt_createCompanies;
  protected ShapeGroup gr_consumerGC_businesspark;
  protected ShapeRectangle rect_addEA;
  protected ShapeText txt_addEnergyAssetFunctions;
  protected ShapeGroup gr_addEAFunctions;
  protected ShapeRectangle rect_createGISObjects;
  protected ShapeText txt_createGISObjects;
  protected ShapeGroup gr_createGISObjects;
  protected ShapeText txt_overwriteDatabaseValues;
  protected ShapeRectangle rect_supportFunctions;
  protected ShapeText txt_supportFunctions;
  protected ShapeRectangle rect_connectToFunctions;
  protected ShapeText txt_connectToFunctions;
  protected ShapeText txt_DebuggingDataCollections;
  protected ShapeRectangle rect_addSpecificSliderGC;
  protected ShapeText txt_addSpecificSliderGC;
  protected ShapeRectangle rect_subScopeFunctions;
  protected ShapeText txt_filterSubScopeFunctions;
  protected com.anylogic.engine.markup.Level level;
  protected com.anylogic.engine.markup.Level level1;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rect_canvas = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            green, white,
			2200.0, 980.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_projectDataTracking = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1760.0, 50.0, 0.0, 0.0,
            red, white,
			420.0, 290.0, 10.0, 2.0, LINE_STYLE_SOLID );
    rect_loader = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            green, white,
			169.0, 40.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_input = new ShapeText(
        SHAPE_DRAW_2D, true,55.0, 7.0, 0.0, 0.0,
        green,"Loader",
        _txt_input_Font, ALIGNMENT_LEFT );
    rect_connectedModels = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 840.0, 0.0, 0.0,
            green, white,
			290.0, 140.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_connectedModels = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 850.0, 0.0, 0.0,
        black,"Connected Models",
        _t_connectedModels_Font, ALIGNMENT_LEFT );
    txt_projectDataTracking = new ShapeText(
        SHAPE_DRAW_2D, true,1780.0, 60.0, 0.0, 0.0,
        black,"Time and data Tracking",
        _txt_projectDataTracking_Font, ALIGNMENT_LEFT );
    rect_defaultStartup = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,20.0, 50.0, 0.0, 0.0,
            black, white,
			340.0, 260.0, 10.0, 2.0, LINE_STYLE_SOLID );
    rect_dataCollections = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-440.0, 0.0, 0.0, 0.0,
            salmon, white,
			437.0, 980.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_GridNodeFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,20.0, 500.0, 0.0, 0.0,
            black, white,
			340.0, 140.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_loaderStartupDefault = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 60.0, 0.0, 0.0,
        black,"Loader default startup:",
        _txt_loaderStartupDefault_Font, ALIGNMENT_LEFT );
    txt_createGridNodes = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 510.0, 0.0, 0.0,
        black,"Create Grid node functions",
        _txt_createGridNodes_Font, ALIGNMENT_LEFT );
    rect_dataInput = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-440.0, 0.0, 0.0, 0.0,
            salmon, white,
			169.0, 40.0, 10.0, 3.0, LINE_STYLE_SOLID );
    text = new ShapeText(
        SHAPE_DRAW_2D, true,-400.0, 10.0, 0.0, 0.0,
        salmon,"Data input",
        _text_Font, ALIGNMENT_LEFT );
    t_inputFiles = new ShapeText(
        SHAPE_DRAW_2D, true,-400.0, 760.0, 0.0, 0.0,
        black,"Basic Input files:",
        _t_inputFiles_Font, ALIGNMENT_LEFT );
    t_inputFileFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-420.0, 60.0, 0.0, 0.0,
        black,"Read input files to database:",
        _t_inputFileFunctions_Font, ALIGNMENT_LEFT );
    txt_dataCollectionFill = new ShapeText(
        SHAPE_DRAW_2D, true,-420.0, 160.0, 0.0, 0.0,
        black,"Fill the data collections:",
        _txt_dataCollectionFill_Font, ALIGNMENT_LEFT );
    rect_ActorFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,20.0, 430.0, 0.0, 0.0,
            black, white,
			340.0, 60.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_createActorFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 440.0, 0.0, 0.0,
        black,"Create Actor functions",
        _txt_createActorFunctions_Font, ALIGNMENT_LEFT );
    rect_createEnergyGC = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,400.0, 700.0, 0.0, 0.0,
            black, white,
			400.0, 270.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_createEnergyGC = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 710.0, 0.0, 0.0,
        black,"Create Energy GC functions \n",
        _txt_createEnergyGC_Font, ALIGNMENT_LEFT );
    rect_createHouses = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-170.0, -20.0, 0.0, 0.0,
            black, white,
			420.0, 520.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_createHouses = new ShapeText(
        SHAPE_DRAW_2D, true,-160.0, -10.0, 0.0, 0.0,
        black,"Create Houses",
        _txt_createHouses_Font, ALIGNMENT_LEFT );
    rect_createCompanies = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-170.0, -180.0, 0.0, 0.0,
            black, white,
			400.0, 570.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_createCompanies = new ShapeText(
        SHAPE_DRAW_2D, true,-158.134, -168.134, 0.0, 0.0,
        black,"Create Companies",
        _txt_createCompanies_Font, ALIGNMENT_LEFT );
    rect_addEA = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-180.0, -140.0, 0.0, 0.0,
            black, white,
			450.0, 690.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_addEnergyAssetFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,-160.0, -130.0, 0.0, 0.0,
        black,"Add EA functions",
        _txt_addEnergyAssetFunctions_Font, ALIGNMENT_LEFT );
    rect_createGISObjects = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-180.0, -120.0, 0.0, 0.0,
            black, white,
			420.0, 230.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_createGISObjects = new ShapeText(
        SHAPE_DRAW_2D, true,-161.492, -109.13, 0.0, 0.0,
        black,"Create GIS objects",
        _txt_createGISObjects_Font, ALIGNMENT_LEFT );
    txt_overwriteDatabaseValues = new ShapeText(
        SHAPE_DRAW_2D, true,-420.0, 110.0, 0.0, 0.0,
        black,"Overwrite specific database values:",
        _txt_overwriteDatabaseValues_Font, ALIGNMENT_LEFT );
    rect_supportFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1760.0, 860.0, 0.0, 0.0,
            black, white,
			420.0, 100.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_supportFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,1780.0, 870.0, 0.0, 0.0,
        black,"Support Functions",
        _txt_supportFunctions_Font, ALIGNMENT_LEFT );
    rect_connectToFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1760.0, 760.0, 0.0, 0.0,
            black, white,
			420.0, 90.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_connectToFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,1780.0, 770.0, 0.0, 0.0,
        black,"Connect To Functions",
        _txt_connectToFunctions_Font, ALIGNMENT_LEFT );
    txt_DebuggingDataCollections = new ShapeText(
        SHAPE_DRAW_2D, true,-420.0, 890.0, 0.0, 0.0,
        black,"Data collections used for Debugging",
        _txt_DebuggingDataCollections_Font, ALIGNMENT_LEFT );
    rect_addSpecificSliderGC = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,20.0, 320.0, 0.0, 0.0,
            black, white,
			340.0, 100.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_addSpecificSliderGC = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, 330.0, 0.0, 0.0,
        black,"Add specific slider GC",
        _txt_addSpecificSliderGC_Font, ALIGNMENT_LEFT );
    rect_subScopeFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,20.0, 650.0, 0.0, 0.0,
            black, white,
			340.0, 180.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_filterSubScopeFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 660.0, 0.0, 0.0,
        black,"SubScope filter functions",
        _txt_filterSubScopeFunctions_Font, ALIGNMENT_LEFT );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_consumerGC_residential = new ShapeGroup( Zero_Loader.this, SHAPE_DRAW_2D3D, true, 1000.0, 70.0, 0.0, 0.0
	
	     , rect_createHouses
	     , txt_createHouses );
    }
    {
    gr_consumerGC_businesspark = new ShapeGroup( Zero_Loader.this, SHAPE_DRAW_2D3D, true, 570.0, 230.0, 0.0, 0.0
	
	     , rect_createCompanies
	     , txt_createCompanies );
    }
    {
    gr_addEAFunctions = new ShapeGroup( Zero_Loader.this, SHAPE_DRAW_2D3D, true, 1460.0, 190.0, 0.0, 0.0
	
	     , rect_addEA
	     , txt_addEnergyAssetFunctions );
    }
    {
    gr_createGISObjects = new ShapeGroup( Zero_Loader.this, SHAPE_DRAW_2D3D, true, 1940.0, 640.0, 0.0, 0.0
	
	     , rect_createGISObjects
	     , txt_createGISObjects );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }



  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
    level1 = new com.anylogic.engine.markup.Level(this, "level1", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level,
      level1 };
    _createPersistentElementsBP0_xjal();
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
  public Zero_Loader( Engine engine, Agent owner, AgentList<? extends Zero_Loader> ownerPopulation ) {
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
    energyModel = instantiate_energyModel_xjal();
    avgc_data = instantiate_avgc_data_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public Zero_Loader() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public Zero_Loader( Zero_Interface zero_Interface, DefaultProfiles_data defaultProfiles_data, Project_data project_data, Settings settings, User user, J_RemainingTotalsManager p_remainingTotals ) {
    markParametersAreSet();
    this.zero_Interface = zero_Interface;
    this.defaultProfiles_data = defaultProfiles_data;
    this.project_data = project_data;
    this.settings = settings;
    this.user = user;
    this.p_remainingTotals = p_remainingTotals;
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
    setupPlainVariables_Zero_Loader_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
	_initialize_level1_xjal();
    level.initialize();
    level1.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Zero_Loader.this, true, 0, 0, 0, 0 , level, level1 );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Zero_Loader.this, getElementProperty( "zerointerfaceloader.Zero_Loader.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
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
    setupParameters_energyModel_xjal( energyModel, null );
    doBeforeCreate_energyModel_xjal( energyModel, null );
    energyModel.createAsEmbedded();
    setupParameters_avgc_data_xjal( avgc_data, null );
    doBeforeCreate_avgc_data_xjal( avgc_data, null );
    avgc_data.createAsEmbedded();
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( Zero_Loader.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    energyModel.startAsEmbedded();
    avgc_data.startAsEmbedded();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Zero_Loader_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Zero_Loader_xjal() {
    v_modelStartUpDuration_s = 
0 
;
    map_nrOfResidentsToDHWProfiles_data = 
new HashMap<>() 
;
  }

  // User API -----------------------------------------------------
  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<>();
    }
    list.add( energyModel );
    list.add( avgc_data );
    return list;
  }

  public AgentList<? extends Zero_Loader> getPopulation() {
    return (AgentList<? extends Zero_Loader>) super.getPopulation();
  }

  public List<? extends Zero_Loader> agentsInRange( double distance ) {
    return (List<? extends Zero_Loader>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    energyModel.onDestroy();
    avgc_data.onDestroy();
    inputCSVcookingActivities.close();
    inputCSVhouseholdTrips.close();
    inputCSVtruckTrips.close();
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    energyModel.doFinish();
    avgc_data.doFinish();
  }


}
