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

import java.awt.geom.Arc2D;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.core.type.TypeReference;

// For deserialisation
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.lang.reflect.Field;

import java.io.FileOutputStream;
import java.util.stream.Stream;
import java.util.Dictionary.*;
import java.util.Hashtable.*;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Triple;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;  
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

import com.anylogic.cloud.util.DateUtils; 

public class EnergyModel extends Agent
        implements 
I_EnergyData 
{
  // Parameters

  /**
   * Schakelaar om optionele visualisatie-agent te creëren.<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Jorrit
   */
  public 
boolean  b_parallelizeConnectionOwners;

  /**
   * Returns default value for parameter <code>b_parallelizeConnectionOwners</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_parallelizeConnectionOwners_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
false 
;
  }

  public void set_b_parallelizeConnectionOwners( boolean value ) {
    if (value == this.b_parallelizeConnectionOwners) {
      return;
    }
    boolean _oldValue_xjal = this.b_parallelizeConnectionOwners;
    this.b_parallelizeConnectionOwners = value;
    onChange_b_parallelizeConnectionOwners_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_parallelizeConnectionOwners.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_parallelizeConnectionOwners()</code> method instead.
   */
  protected void onChange_b_parallelizeConnectionOwners() {
    onChange_b_parallelizeConnectionOwners_xjal( b_parallelizeConnectionOwners );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_parallelizeConnectionOwners_xjal( boolean oldValue ) {  
  }


  /**
   * Boolean om paralelle berekening van gridconnections aan te zetten.<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */
  public 
boolean  b_parallelizeGridConnections;

  /**
   * Returns default value for parameter <code>b_parallelizeGridConnections</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_parallelizeGridConnections_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
false 
;
  }

  public void set_b_parallelizeGridConnections( boolean value ) {
    if (value == this.b_parallelizeGridConnections) {
      return;
    }
    boolean _oldValue_xjal = this.b_parallelizeGridConnections;
    this.b_parallelizeGridConnections = value;
    onChange_b_parallelizeGridConnections_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_parallelizeGridConnections.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_parallelizeGridConnections()</code> method instead.
   */
  protected void onChange_b_parallelizeGridConnections() {
    onChange_b_parallelizeGridConnections_xjal( b_parallelizeGridConnections );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_parallelizeGridConnections_xjal( boolean oldValue ) {  
  }


  public 
double  p_tempForecastTime_h;

  /**
   * Returns default value for parameter <code>p_tempForecastTime_h</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_tempForecastTime_h_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
24
 
;
  }

  public void set_p_tempForecastTime_h( double value ) {
    if (value == this.p_tempForecastTime_h) {
      return;
    }
    double _oldValue_xjal = this.p_tempForecastTime_h;
    this.p_tempForecastTime_h = value;
    onChange_p_tempForecastTime_h_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_tempForecastTime_h.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_tempForecastTime_h()</code> method instead.
   */
  protected void onChange_p_tempForecastTime_h() {
    onChange_p_tempForecastTime_h_xjal( p_tempForecastTime_h );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_tempForecastTime_h_xjal( double oldValue ) {  
  }


  public 
TextFile  p_truckTripsCsv;

  /**
   * Returns default value for parameter <code>p_truckTripsCsv</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public TextFile _p_truckTripsCsv_DefaultValue_xjal() {
    final EnergyModel self = this;
    return null;
  }

  public void set_p_truckTripsCsv( TextFile value ) {
    if (value == this.p_truckTripsCsv) {
      return;
    }
    TextFile _oldValue_xjal = this.p_truckTripsCsv;
    this.p_truckTripsCsv = value;
    onChange_p_truckTripsCsv_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_truckTripsCsv.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_truckTripsCsv()</code> method instead.
   */
  protected void onChange_p_truckTripsCsv() {
    onChange_p_truckTripsCsv_xjal( p_truckTripsCsv );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_truckTripsCsv_xjal( TextFile oldValue ) {  
  }


  public 
TextFile  p_householdTripsCsv;

  /**
   * Returns default value for parameter <code>p_householdTripsCsv</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public TextFile _p_householdTripsCsv_DefaultValue_xjal() {
    final EnergyModel self = this;
    return null;
  }

  public void set_p_householdTripsCsv( TextFile value ) {
    if (value == this.p_householdTripsCsv) {
      return;
    }
    TextFile _oldValue_xjal = this.p_householdTripsCsv;
    this.p_householdTripsCsv = value;
    onChange_p_householdTripsCsv_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_householdTripsCsv.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_householdTripsCsv()</code> method instead.
   */
  protected void onChange_p_householdTripsCsv() {
    onChange_p_householdTripsCsv_xjal( p_householdTripsCsv );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_householdTripsCsv_xjal( TextFile oldValue ) {  
  }


  public 
TextFile  p_cookingPatternCsv;

  /**
   * Returns default value for parameter <code>p_cookingPatternCsv</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public TextFile _p_cookingPatternCsv_DefaultValue_xjal() {
    final EnergyModel self = this;
    return null;
  }

  public void set_p_cookingPatternCsv( TextFile value ) {
    if (value == this.p_cookingPatternCsv) {
      return;
    }
    TextFile _oldValue_xjal = this.p_cookingPatternCsv;
    this.p_cookingPatternCsv = value;
    onChange_p_cookingPatternCsv_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_cookingPatternCsv.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_cookingPatternCsv()</code> method instead.
   */
  protected void onChange_p_cookingPatternCsv() {
    onChange_p_cookingPatternCsv_xjal( p_cookingPatternCsv );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_cookingPatternCsv_xjal( TextFile oldValue ) {  
  }


  public 
J_AVGC_data  avgc_data;

  /**
   * Returns default value for parameter <code>avgc_data</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_AVGC_data _avgc_data_DefaultValue_xjal() {
    final EnergyModel self = this;
    return null;
  }

  public void set_avgc_data( J_AVGC_data value ) {
    if (value == this.avgc_data) {
      return;
    }
    J_AVGC_data _oldValue_xjal = this.avgc_data;
    this.avgc_data = value;
    onChange_avgc_data_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter avgc_data.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_avgc_data()</code> method instead.
   */
  protected void onChange_avgc_data() {
    onChange_avgc_data_xjal( avgc_data );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_avgc_data_xjal( J_AVGC_data oldValue ) {  
  }


  /**
   * Schakelaar om optionele visualisatie-agent te creëren.<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Jorrit
   */
  public 
boolean  b_enableDLR;

  /**
   * Returns default value for parameter <code>b_enableDLR</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_enableDLR_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
false 
;
  }

  public void set_b_enableDLR( boolean value ) {
    if (value == this.b_enableDLR) {
      return;
    }
    boolean _oldValue_xjal = this.b_enableDLR;
    this.b_enableDLR = value;
    onChange_b_enableDLR_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_enableDLR.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_enableDLR()</code> method instead.
   */
  protected void onChange_b_enableDLR() {
    onChange_b_enableDLR_xjal( b_enableDLR );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_enableDLR_xjal( boolean oldValue ) {  
  }


  public 
boolean  b_isInitialized;

  /**
   * Returns default value for parameter <code>b_isInitialized</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_isInitialized_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
false 
;
  }

  public void set_b_isInitialized( boolean value ) {
    if (value == this.b_isInitialized) {
      return;
    }
    boolean _oldValue_xjal = this.b_isInitialized;
    this.b_isInitialized = value;
    onChange_b_isInitialized_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_isInitialized.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_isInitialized()</code> method instead.
   */
  protected void onChange_b_isInitialized() {
    onChange_b_isInitialized_xjal( b_isInitialized );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_isInitialized_xjal( boolean oldValue ) {  
  }


  /**
   * Schakelaar om optionele visualisatie-agent te creëren.<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Jorrit
   */
  public 
boolean  b_storePreviousRapidRunData;

  /**
   * Returns default value for parameter <code>b_storePreviousRapidRunData</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_storePreviousRapidRunData_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
true 
;
  }

  public void set_b_storePreviousRapidRunData( boolean value ) {
    if (value == this.b_storePreviousRapidRunData) {
      return;
    }
    boolean _oldValue_xjal = this.b_storePreviousRapidRunData;
    this.b_storePreviousRapidRunData = value;
    onChange_b_storePreviousRapidRunData_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_storePreviousRapidRunData.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_storePreviousRapidRunData()</code> method instead.
   */
  protected void onChange_b_storePreviousRapidRunData() {
    onChange_b_storePreviousRapidRunData_xjal( b_storePreviousRapidRunData );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_storePreviousRapidRunData_xjal( boolean oldValue ) {  
  }


  public 
String  p_regionName;

  /**
   * Returns default value for parameter <code>p_regionName</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_regionName_DefaultValue_xjal() {
    final EnergyModel self = this;
    return null;
  }

  public void set_p_regionName( String value ) {
    if (value == this.p_regionName) {
      return;
    }
    String _oldValue_xjal = this.p_regionName;
    this.p_regionName = value;
    onChange_p_regionName_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_regionName.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_regionName()</code> method instead.
   */
  protected void onChange_p_regionName() {
    onChange_p_regionName_xjal( p_regionName );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_regionName_xjal( String oldValue ) {  
  }


  public 
boolean  b_isDeserialised;

  /**
   * Returns default value for parameter <code>b_isDeserialised</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_isDeserialised_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
false 
;
  }

  public void set_b_isDeserialised( boolean value ) {
    if (value == this.b_isDeserialised) {
      return;
    }
    boolean _oldValue_xjal = this.b_isDeserialised;
    this.b_isDeserialised = value;
    onChange_b_isDeserialised_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_isDeserialised.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_isDeserialised()</code> method instead.
   */
  protected void onChange_b_isDeserialised() {
    onChange_b_isDeserialised_xjal( b_isDeserialised );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_isDeserialised_xjal( boolean oldValue ) {  
  }


  /**
   * This is an AnyLogic parameter, instead of a variable as the name might suggest, because there should only be one instance of this class, created at initialisation.
   */
  public 
J_TimeVariables  p_timeVariables;

  /**
   * Returns default value for parameter <code>p_timeVariables</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_TimeVariables _p_timeVariables_DefaultValue_xjal() {
    final EnergyModel self = this;
    return null;
  }

  public void set_p_timeVariables( J_TimeVariables value ) {
    if (value == this.p_timeVariables) {
      return;
    }
    J_TimeVariables _oldValue_xjal = this.p_timeVariables;
    this.p_timeVariables = value;
    onChange_p_timeVariables_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_timeVariables.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_timeVariables()</code> method instead.
   */
  protected void onChange_p_timeVariables() {
    onChange_p_timeVariables_xjal( p_timeVariables );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_timeVariables_xjal( J_TimeVariables oldValue ) {  
  }


  public 
J_TimeParameters  p_timeParameters;

  /**
   * Returns default value for parameter <code>p_timeParameters</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_TimeParameters _p_timeParameters_DefaultValue_xjal() {
    final EnergyModel self = this;
    return null;
  }

  public void set_p_timeParameters( J_TimeParameters value ) {
    if (value == this.p_timeParameters) {
      return;
    }
    J_TimeParameters _oldValue_xjal = this.p_timeParameters;
    this.p_timeParameters = value;
    onChange_p_timeParameters_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_timeParameters.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_timeParameters()</code> method instead.
   */
  protected void onChange_p_timeParameters() {
    onChange_p_timeParameters_xjal( p_timeParameters );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_timeParameters_xjal( J_TimeParameters oldValue ) {  
  }


  public 
double  p_pvForecastTime_h;

  /**
   * Returns default value for parameter <code>p_pvForecastTime_h</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_pvForecastTime_h_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
18 
;
  }

  public void set_p_pvForecastTime_h( double value ) {
    if (value == this.p_pvForecastTime_h) {
      return;
    }
    double _oldValue_xjal = this.p_pvForecastTime_h;
    this.p_pvForecastTime_h = value;
    onChange_p_pvForecastTime_h_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_pvForecastTime_h.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_pvForecastTime_h()</code> method instead.
   */
  protected void onChange_p_pvForecastTime_h() {
    onChange_p_pvForecastTime_h_xjal( p_pvForecastTime_h );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_pvForecastTime_h_xjal( double oldValue ) {  
  }


  public 
double  p_windForecastTime_h;

  /**
   * Returns default value for parameter <code>p_windForecastTime_h</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_windForecastTime_h_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
18 
;
  }

  public void set_p_windForecastTime_h( double value ) {
    if (value == this.p_windForecastTime_h) {
      return;
    }
    double _oldValue_xjal = this.p_windForecastTime_h;
    this.p_windForecastTime_h = value;
    onChange_p_windForecastTime_h_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_windForecastTime_h.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_windForecastTime_h()</code> method instead.
   */
  protected void onChange_p_windForecastTime_h() {
    onChange_p_windForecastTime_h_xjal( p_windForecastTime_h );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_windForecastTime_h_xjal( double oldValue ) {  
  }


  public 
double  p_epexForecastTime_h;

  /**
   * Returns default value for parameter <code>p_epexForecastTime_h</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_epexForecastTime_h_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
18 
;
  }

  public void set_p_epexForecastTime_h( double value ) {
    if (value == this.p_epexForecastTime_h) {
      return;
    }
    double _oldValue_xjal = this.p_epexForecastTime_h;
    this.p_epexForecastTime_h = value;
    onChange_p_epexForecastTime_h_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_epexForecastTime_h.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_epexForecastTime_h()</code> method instead.
   */
  protected void onChange_p_epexForecastTime_h() {
    onChange_p_epexForecastTime_h_xjal( p_epexForecastTime_h );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_epexForecastTime_h_xjal( double oldValue ) {  
  }


  public 
double  p_CO2EmissionFactorForecastTime_h;

  /**
   * Returns default value for parameter <code>p_CO2EmissionFactorForecastTime_h</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_CO2EmissionFactorForecastTime_h_DefaultValue_xjal() {
    final EnergyModel self = this;
    return 
18 
;
  }

  public void set_p_CO2EmissionFactorForecastTime_h( double value ) {
    if (value == this.p_CO2EmissionFactorForecastTime_h) {
      return;
    }
    double _oldValue_xjal = this.p_CO2EmissionFactorForecastTime_h;
    this.p_CO2EmissionFactorForecastTime_h = value;
    onChange_p_CO2EmissionFactorForecastTime_h_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_CO2EmissionFactorForecastTime_h.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_CO2EmissionFactorForecastTime_h()</code> method instead.
   */
  protected void onChange_p_CO2EmissionFactorForecastTime_h() {
    onChange_p_CO2EmissionFactorForecastTime_h_xjal( p_CO2EmissionFactorForecastTime_h );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_CO2EmissionFactorForecastTime_h_xjal( double oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    b_parallelizeConnectionOwners = _b_parallelizeConnectionOwners_DefaultValue_xjal();
    b_parallelizeGridConnections = _b_parallelizeGridConnections_DefaultValue_xjal();
    p_tempForecastTime_h = _p_tempForecastTime_h_DefaultValue_xjal();
    p_truckTripsCsv = _p_truckTripsCsv_DefaultValue_xjal();
    p_householdTripsCsv = _p_householdTripsCsv_DefaultValue_xjal();
    p_cookingPatternCsv = _p_cookingPatternCsv_DefaultValue_xjal();
    avgc_data = _avgc_data_DefaultValue_xjal();
    b_enableDLR = _b_enableDLR_DefaultValue_xjal();
    b_isInitialized = _b_isInitialized_DefaultValue_xjal();
    b_storePreviousRapidRunData = _b_storePreviousRapidRunData_DefaultValue_xjal();
    p_regionName = _p_regionName_DefaultValue_xjal();
    b_isDeserialised = _b_isDeserialised_DefaultValue_xjal();
    p_timeVariables = _p_timeVariables_DefaultValue_xjal();
    p_timeParameters = _p_timeParameters_DefaultValue_xjal();
    p_pvForecastTime_h = _p_pvForecastTime_h_DefaultValue_xjal();
    p_windForecastTime_h = _p_windForecastTime_h_DefaultValue_xjal();
    p_epexForecastTime_h = _p_epexForecastTime_h_DefaultValue_xjal();
    p_CO2EmissionFactorForecastTime_h = _p_CO2EmissionFactorForecastTime_h_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "b_parallelizeConnectionOwners":
      if ( _callOnChange_xjal ) {
        set_b_parallelizeConnectionOwners( (Boolean) _value_xjal );
      } else {
        b_parallelizeConnectionOwners = (Boolean) _value_xjal;
      }
      return true;
    case "b_parallelizeGridConnections":
      if ( _callOnChange_xjal ) {
        set_b_parallelizeGridConnections( (Boolean) _value_xjal );
      } else {
        b_parallelizeGridConnections = (Boolean) _value_xjal;
      }
      return true;
    case "p_tempForecastTime_h":
      if ( _callOnChange_xjal ) {
        set_p_tempForecastTime_h( ((Number) _value_xjal).doubleValue() );
      } else {
        p_tempForecastTime_h = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_truckTripsCsv":
      if ( _callOnChange_xjal ) {
        set_p_truckTripsCsv( (TextFile) _value_xjal );
      } else {
        p_truckTripsCsv = (TextFile) _value_xjal;
      }
      return true;
    case "p_householdTripsCsv":
      if ( _callOnChange_xjal ) {
        set_p_householdTripsCsv( (TextFile) _value_xjal );
      } else {
        p_householdTripsCsv = (TextFile) _value_xjal;
      }
      return true;
    case "p_cookingPatternCsv":
      if ( _callOnChange_xjal ) {
        set_p_cookingPatternCsv( (TextFile) _value_xjal );
      } else {
        p_cookingPatternCsv = (TextFile) _value_xjal;
      }
      return true;
    case "avgc_data":
      if ( _callOnChange_xjal ) {
        set_avgc_data( (J_AVGC_data) _value_xjal );
      } else {
        avgc_data = (J_AVGC_data) _value_xjal;
      }
      return true;
    case "b_enableDLR":
      if ( _callOnChange_xjal ) {
        set_b_enableDLR( (Boolean) _value_xjal );
      } else {
        b_enableDLR = (Boolean) _value_xjal;
      }
      return true;
    case "b_isInitialized":
      if ( _callOnChange_xjal ) {
        set_b_isInitialized( (Boolean) _value_xjal );
      } else {
        b_isInitialized = (Boolean) _value_xjal;
      }
      return true;
    case "b_storePreviousRapidRunData":
      if ( _callOnChange_xjal ) {
        set_b_storePreviousRapidRunData( (Boolean) _value_xjal );
      } else {
        b_storePreviousRapidRunData = (Boolean) _value_xjal;
      }
      return true;
    case "p_regionName":
      if ( _callOnChange_xjal ) {
        set_p_regionName( (String) _value_xjal );
      } else {
        p_regionName = (String) _value_xjal;
      }
      return true;
    case "b_isDeserialised":
      if ( _callOnChange_xjal ) {
        set_b_isDeserialised( (Boolean) _value_xjal );
      } else {
        b_isDeserialised = (Boolean) _value_xjal;
      }
      return true;
    case "p_timeVariables":
      if ( _callOnChange_xjal ) {
        set_p_timeVariables( (J_TimeVariables) _value_xjal );
      } else {
        p_timeVariables = (J_TimeVariables) _value_xjal;
      }
      return true;
    case "p_timeParameters":
      if ( _callOnChange_xjal ) {
        set_p_timeParameters( (J_TimeParameters) _value_xjal );
      } else {
        p_timeParameters = (J_TimeParameters) _value_xjal;
      }
      return true;
    case "p_pvForecastTime_h":
      if ( _callOnChange_xjal ) {
        set_p_pvForecastTime_h( ((Number) _value_xjal).doubleValue() );
      } else {
        p_pvForecastTime_h = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_windForecastTime_h":
      if ( _callOnChange_xjal ) {
        set_p_windForecastTime_h( ((Number) _value_xjal).doubleValue() );
      } else {
        p_windForecastTime_h = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_epexForecastTime_h":
      if ( _callOnChange_xjal ) {
        set_p_epexForecastTime_h( ((Number) _value_xjal).doubleValue() );
      } else {
        p_epexForecastTime_h = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_CO2EmissionFactorForecastTime_h":
      if ( _callOnChange_xjal ) {
        set_p_CO2EmissionFactorForecastTime_h( ((Number) _value_xjal).doubleValue() );
      } else {
        p_CO2EmissionFactorForecastTime_h = ((Number) _value_xjal).doubleValue();
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
    case "b_parallelizeConnectionOwners": _result_xjal = b_parallelizeConnectionOwners; break;
    case "b_parallelizeGridConnections": _result_xjal = b_parallelizeGridConnections; break;
    case "p_tempForecastTime_h": _result_xjal = p_tempForecastTime_h; break;
    case "p_truckTripsCsv": _result_xjal = p_truckTripsCsv; break;
    case "p_householdTripsCsv": _result_xjal = p_householdTripsCsv; break;
    case "p_cookingPatternCsv": _result_xjal = p_cookingPatternCsv; break;
    case "avgc_data": _result_xjal = avgc_data; break;
    case "b_enableDLR": _result_xjal = b_enableDLR; break;
    case "b_isInitialized": _result_xjal = b_isInitialized; break;
    case "b_storePreviousRapidRunData": _result_xjal = b_storePreviousRapidRunData; break;
    case "p_regionName": _result_xjal = p_regionName; break;
    case "b_isDeserialised": _result_xjal = b_isDeserialised; break;
    case "p_timeVariables": _result_xjal = p_timeVariables; break;
    case "p_timeParameters": _result_xjal = p_timeParameters; break;
    case "p_pvForecastTime_h": _result_xjal = p_pvForecastTime_h; break;
    case "p_windForecastTime_h": _result_xjal = p_windForecastTime_h; break;
    case "p_epexForecastTime_h": _result_xjal = p_epexForecastTime_h; break;
    case "p_CO2EmissionFactorForecastTime_h": _result_xjal = p_CO2EmissionFactorForecastTime_h; break;
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
      list.add( "b_parallelizeConnectionOwners" );
      list.add( "b_parallelizeGridConnections" );
      list.add( "p_tempForecastTime_h" );
      list.add( "p_truckTripsCsv" );
      list.add( "p_householdTripsCsv" );
      list.add( "p_cookingPatternCsv" );
      list.add( "avgc_data" );
      list.add( "b_enableDLR" );
      list.add( "b_isInitialized" );
      list.add( "b_storePreviousRapidRunData" );
      list.add( "p_regionName" );
      list.add( "b_isDeserialised" );
      list.add( "p_timeVariables" );
      list.add( "p_timeParameters" );
      list.add( "p_pvForecastTime_h" );
      list.add( "p_windForecastTime_h" );
      list.add( "p_epexForecastTime_h" );
      list.add( "p_CO2EmissionFactorForecastTime_h" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  /**
   * Fraction of yearly demand in MWh per hour, multiplied by demand in MWh per year = MW for that hour
   */
  public 
J_ProfilePointer 
 pp_windProduction_fr;
  public 
double 
 v_totalBatteryChargeAmount_MWh;
  public 
double 
 v_totalBatteryDischargeAmount_MWh;
  public 
double 
 v_totalBatteryEnergyUsed_MWh;
  public 
double 
 v_totalEnergyCurtailed_MWh;
  public 
double 
 v_timeSeriesRuntime_ms;
  public 
double 
 v_gridNodesRuntime_ms;
  public 
double 
 v_gridConnectionsRuntime_ms;
  public 
double 
 v_incentivesRuntime_ms;
  public 
double 
 v_financialsRuntime_ms;
  public 
double 
 v_currentFinalEnergyConsumption_kW;
  public 
double 
 v_currentPrimaryEnergyProduction_kW;
  public 
double 
 v_currentEnergyCurtailed_kW;
  public 
double 
 v_currentEnergyImport_kW;
  public 
double 
 v_currentEnergyExport_kW;
  public 
double 
 v_currentElectricityImport_kW;
  public 
double 
 v_currentElectricityExport_kW;
  public 
double 
 v_currentPrimaryEnergyProductionHeatpumps_kW;
  public 
double 
 v_electricityYieldForecast_fr;
  /**
   * Fraction of yearly demand in MWh per hour, multiplied by demand in MWh per year = MW for that hour
   */
  public 
J_ProfilePointer 
 pp_PVProduction35DegSouth_fr;
  public 
J_ProfileForecaster 
 pf_windProduction_fr;
  public 
J_ProfileForecaster 
 pf_PVProduction35DegSouth_fr;
  public 
J_ProfileForecaster 
 pf_dayAheadElectricityPricing_eurpMWh;
  public 
J_ProfilePointer 
 pp_dayAheadElectricityPricing_eurpMWh;
  public 
J_FlowsMap 
 fm_currentBalanceFlows_kW;
  public 
J_FlowsMap 
 fm_currentConsumptionFlows_kW;
  public 
J_FlowsMap 
 fm_currentProductionFlows_kW;
  public 
J_RapidRunData 
 v_rapidRunData;
  public 
J_LiveData 
 v_liveData;
  public 
J_AssetsMetaData 
 v_liveAssetsMetaData;
  public 
J_ConnectionMetaData 
 v_liveConnectionMetaData;
  /**
   * Fraction of yearly demand in MWh per hour, multiplied by demand in MWh per year = MW for that hour
   */
  public 
J_ProfilePointer 
 pp_PVProduction15DegEastWest_fr;
  /**
   * Fraction of yearly demand in MWh per hour, multiplied by demand in MWh per year = MW for that hour
   */
  public 
J_ProfilePointer 
 pp_ambientTemperature_degC;
  public 
J_ProfileForecaster 
 pf_PVProduction15DegEastWest_fr;
  public 
J_ProfileForecaster 
 pf_ambientTemperature_degC;
  public 
J_ValueMap<OL_AssetFlowCategories> 
 fm_currentAssetFlows_kW;
  public 
double 
 v_batteryStoredEnergy_kWh;
  public 
J_FlowsMap 
 fm_consumptionForHeating_kW;
  public 
J_FlowsMap 
 fm_heatFromEnergyCarrier_kW;
  public 
J_ProfilePointer 
 pp_CO2EmissionFactorElectricityImport_kgpkWh;
  public 
J_ProfileForecaster 
 pf_CO2EmissionFactorElectricityImport_kgpkWh;
  public 
int 
 v_timeStepsElapsed;
  public 
double 
 v_modelSelfSufficiency_fr;
  public 
double 
 v_modelSelfConsumption_fr;
  public 
boolean 
 v_isRapidRun;
  public 
double 
 v_batteryStoredEnergyDeltaSinceStart_MWh;
  public 
double 
 v_totalEnergyProduced_MWh;
  public 
double 
 v_totalEnergySelfConsumed_MWh;
  public 
double 
 v_totalElectricityConsumed_MWh;
  public 
double 
 v_totalElectricityProduced_MWh;
  public 
double 
 v_totalElectricitySelfConsumed_MWh;
  public 
double 
 v_individualSelfConsumption_fr;
  public 
double 
 v_collectiveSelfConsumption_fr;
  public 
double 
 v_individualSelfSufficiency_fr;
  public 
double 
 v_kpiCalcsRuntime_ms;
  public 
double 
 v_currentDLRfactor_fr;
  public 
double 
 v_minDLRfactor_fr;
  public 
double 
 v_maxDLRfactor_fr;
  public 
double 
 v_totalEnergyImport_MWh;
  public 
double 
 v_totalEnergyExport_MWh;
  public 
double 
 v_totalEnergyConsumed_MWh;
  public 
J_RapidRunData 
 v_previousRunData;
  public 
int 
 v_liveSimLoopCount;
  public 
Map<Integer,List<J_ProfilePointer>> 
 map_nrOfResidentsToDHWprofiles;

  // Collection Variables
  public 
ArrayList <
ConnectionOwner > c_connectionOwners = new ArrayList<ConnectionOwner>();
  
ArrayList <
GridNode > c_gridNodesTopLevel = new ArrayList<GridNode>();
  
ArrayList <
GridNode > c_gridNodesNotTopLevel = new ArrayList<GridNode>();
  public 
ArrayList <
GridConnection > c_gridConnections = new ArrayList<GridConnection>();
  public 
ArrayList <
J_EA > c_ambientDependentAssets = new ArrayList<J_EA>();
  public 
ArrayList <
J_EA > c_energyAssets = new ArrayList<J_EA>();
  public 
ArrayList <
J_EAStorage > c_storageAssets = new ArrayList<J_EAStorage>();
  public 
ArrayList <
J_EAEV > c_EVs = new ArrayList<J_EAEV>();
  public 
ArrayList <
Actor > c_actors = new ArrayList<Actor>();
  /**
   * A subGridConnections are a subset of (children of) of GridConnections that are "part" of another GC and thus are not counted towards the totals.
   */
  public 
ArrayList <
GridConnection > c_subGridConnections = new ArrayList<GridConnection>();
  
ArrayList <
GridNode > c_gridNodeExecutionList = new ArrayList<GridNode>();
  
ArrayList <
GridNode > c_gridNodeExecutionListReverse = new ArrayList<GridNode>();
  /**
   * A paused GridConnection is removed from the collection c_gridConnections and stored in here. Paused GridConnections are not operated or counted towards totals.
   */
  public 
ArrayList <
GridConnection > c_pausedGridConnections = new ArrayList<GridConnection>();
  public 
ArrayList <
J_ProfilePointer > c_profiles = new ArrayList<J_ProfilePointer>();
  public 
ArrayList <
J_ProfileForecaster > c_forecasts = new ArrayList<J_ProfileForecaster>();
  public 
ArrayList <
List<J_ChargingSessionData> > c_chargerProfiles = new ArrayList<List<J_ChargingSessionData>>();
  /**
   * The keys are triples: ( heatingType, boolean hasBuildingThermalModel, boolean hasHeatBuffer ). These map to classes (not instances!) that implement the heating interface. The classes are usually instantiated with the GridConnection as an argument of the constructor.<br>
   * An example of how to use this mapping to create an instance for a triple t, and GridConnection gc: <br>
   * I_HeatingManagement x = c_defaultHeatingStrategies.get(t).getDeclaredConstructor(GridConnection.class, OL_GridConnectionHeatingType.class).newInstance(gc, heatingType);
   */
  public 
LinkedHashMap <
Triple<OL_GridConnectionHeatingType, Boolean, Boolean> , 
Class<? extends I_HeatingManagement> > c_defaultHeatingStrategies = new LinkedHashMap<Triple<OL_GridConnectionHeatingType, Boolean, Boolean>, Class<? extends I_HeatingManagement>>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( EnergyModel.class );

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

  public EnergyDataViewer energyDataViewer;
  public NationalEnergyMarket nationalEnergyMarket;

  public String getNameOf( Agent ao ) {
    if ( ao == energyDataViewer ) return "energyDataViewer";
    if ( ao == nationalEnergyMarket ) return "nationalEnergyMarket";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    return super.getAnimationSettingsOf( ao );
  }

  public class _pop_gridNodes_Population extends AgentArrayList<GridNode> {
    _pop_gridNodes_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GridNode instantiateAgent( int index ) {
    	return instantiate_pop_gridNodes_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GridNode agent, int index, TableInput tableInput ) {
      setupParameters_pop_gridNodes_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GridNode agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_gridNodes_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GridNode")
  public _pop_gridNodes_Population pop_gridNodes = new _pop_gridNodes_Population( this );
  public class _pop_gridConnections_Population extends AgentArrayList<GridConnection> {
    _pop_gridConnections_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GridConnection instantiateAgent( int index ) {
    	return instantiate_pop_gridConnections_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GridConnection agent, int index, TableInput tableInput ) {
      setupParameters_pop_gridConnections_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GridConnection agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_gridConnections_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GridConnection")
  public _pop_gridConnections_Population pop_gridConnections = new _pop_gridConnections_Population( this );
  public class _pop_connectionOwners_Population extends AgentArrayList<ConnectionOwner> {
    _pop_connectionOwners_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public ConnectionOwner instantiateAgent( int index ) {
    	return instantiate_pop_connectionOwners_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( ConnectionOwner agent, int index, TableInput tableInput ) {
      setupParameters_pop_connectionOwners_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( ConnectionOwner agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_connectionOwners_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "ConnectionOwner")
  public _pop_connectionOwners_Population pop_connectionOwners = new _pop_connectionOwners_Population( this );
  public class _pop_energySuppliers_Population extends AgentArrayList<EnergySupplier> {
    _pop_energySuppliers_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public EnergySupplier instantiateAgent( int index ) {
    	return instantiate_pop_energySuppliers_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( EnergySupplier agent, int index, TableInput tableInput ) {
      setupParameters_pop_energySuppliers_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( EnergySupplier agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_energySuppliers_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "EnergySupplier")
  public _pop_energySuppliers_Population pop_energySuppliers = new _pop_energySuppliers_Population( this );
  public class _pop_energyCoops_Population extends AgentArrayList<EnergyCoop> {
    _pop_energyCoops_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public EnergyCoop instantiateAgent( int index ) {
    	return instantiate_pop_energyCoops_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( EnergyCoop agent, int index, TableInput tableInput ) {
      setupParameters_pop_energyCoops_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( EnergyCoop agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_energyCoops_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "EnergyCoop")
  public _pop_energyCoops_Population pop_energyCoops = new _pop_energyCoops_Population( this );
  public class _pop_gridOperators_Population extends AgentArrayList<GridOperator> {
    _pop_gridOperators_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GridOperator instantiateAgent( int index ) {
    	return instantiate_pop_gridOperators_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GridOperator agent, int index, TableInput tableInput ) {
      setupParameters_pop_gridOperators_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GridOperator agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_gridOperators_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GridOperator")
  public _pop_gridOperators_Population pop_gridOperators = new _pop_gridOperators_Population( this );
  public class _Houses_Population extends AgentArrayList<GCHouse> {
    _Houses_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GCHouse instantiateAgent( int index ) {
    	return instantiate_Houses_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GCHouse agent, int index, TableInput tableInput ) {
      setupParameters_Houses_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GCHouse agent, int index, TableInput tableInput ) {
      doBeforeCreate_Houses_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GCHouse")
  public _Houses_Population Houses = new _Houses_Population( this );
  public class _DistrictHeatingSystems_Population extends AgentArrayList<GCDistrictHeating> {
    _DistrictHeatingSystems_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GCDistrictHeating instantiateAgent( int index ) {
    	return instantiate_DistrictHeatingSystems_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GCDistrictHeating agent, int index, TableInput tableInput ) {
      setupParameters_DistrictHeatingSystems_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GCDistrictHeating agent, int index, TableInput tableInput ) {
      doBeforeCreate_DistrictHeatingSystems_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GCDistrictHeating")
  public _DistrictHeatingSystems_Population DistrictHeatingSystems = new _DistrictHeatingSystems_Population( this );
  public class _EnergyProductionSites_Population extends AgentArrayList<GCEnergyProduction> {
    _EnergyProductionSites_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GCEnergyProduction instantiateAgent( int index ) {
    	return instantiate_EnergyProductionSites_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GCEnergyProduction agent, int index, TableInput tableInput ) {
      setupParameters_EnergyProductionSites_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GCEnergyProduction agent, int index, TableInput tableInput ) {
      doBeforeCreate_EnergyProductionSites_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GCEnergyProduction")
  public _EnergyProductionSites_Population EnergyProductionSites = new _EnergyProductionSites_Population( this );
  public class _EnergyConversionSites_Population extends AgentArrayList<GCEnergyConversion> {
    _EnergyConversionSites_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GCEnergyConversion instantiateAgent( int index ) {
    	return instantiate_EnergyConversionSites_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GCEnergyConversion agent, int index, TableInput tableInput ) {
      setupParameters_EnergyConversionSites_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GCEnergyConversion agent, int index, TableInput tableInput ) {
      doBeforeCreate_EnergyConversionSites_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GCEnergyConversion")
  public _EnergyConversionSites_Population EnergyConversionSites = new _EnergyConversionSites_Population( this );
  public class _UtilityConnections_Population extends AgentArrayList<GCUtility> {
    _UtilityConnections_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GCUtility instantiateAgent( int index ) {
    	return instantiate_UtilityConnections_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GCUtility agent, int index, TableInput tableInput ) {
      setupParameters_UtilityConnections_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GCUtility agent, int index, TableInput tableInput ) {
      doBeforeCreate_UtilityConnections_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GCUtility")
  public _UtilityConnections_Population UtilityConnections = new _UtilityConnections_Population( this );
  public class _GridBatteries_Population extends AgentArrayList<GCGridBattery> {
    _GridBatteries_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GCGridBattery instantiateAgent( int index ) {
    	return instantiate_GridBatteries_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GCGridBattery agent, int index, TableInput tableInput ) {
      setupParameters_GridBatteries_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GCGridBattery agent, int index, TableInput tableInput ) {
      doBeforeCreate_GridBatteries_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GCGridBattery")
  public _GridBatteries_Population GridBatteries = new _GridBatteries_Population( this );
  public class _pop_GIS_Buildings_Population extends AgentArrayList<GIS_Building> {
    _pop_GIS_Buildings_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GIS_Building instantiateAgent( int index ) {
    	return instantiate_pop_GIS_Buildings_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GIS_Building agent, int index, TableInput tableInput ) {
      setupParameters_pop_GIS_Buildings_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GIS_Building agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_GIS_Buildings_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GIS_Building")
  public _pop_GIS_Buildings_Population pop_GIS_Buildings = new _pop_GIS_Buildings_Population( this );
  public class _pop_GIS_Objects_Population extends AgentArrayList<GIS_Object> {
    _pop_GIS_Objects_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GIS_Object instantiateAgent( int index ) {
    	return instantiate_pop_GIS_Objects_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GIS_Object agent, int index, TableInput tableInput ) {
      setupParameters_pop_GIS_Objects_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GIS_Object agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_GIS_Objects_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GIS_Object")
  public _pop_GIS_Objects_Population pop_GIS_Objects = new _pop_GIS_Objects_Population( this );
  public class _pop_GIS_Parcels_Population extends AgentArrayList<GIS_Parcel> {
    _pop_GIS_Parcels_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GIS_Parcel instantiateAgent( int index ) {
    	return instantiate_pop_GIS_Parcels_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GIS_Parcel agent, int index, TableInput tableInput ) {
      setupParameters_pop_GIS_Parcels_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GIS_Parcel agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_GIS_Parcels_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GIS_Parcel")
  public _pop_GIS_Parcels_Population pop_GIS_Parcels = new _pop_GIS_Parcels_Population( this );
  public class _PublicChargers_Population extends AgentArrayList<GCPublicCharger> {
    _PublicChargers_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GCPublicCharger instantiateAgent( int index ) {
    	return instantiate_PublicChargers_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GCPublicCharger agent, int index, TableInput tableInput ) {
      setupParameters_PublicChargers_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GCPublicCharger agent, int index, TableInput tableInput ) {
      doBeforeCreate_PublicChargers_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GCPublicCharger")
  public _PublicChargers_Population PublicChargers = new _PublicChargers_Population( this );
  public class _Neighborhoods_Population extends AgentArrayList<GCNeighborhood> {
    _Neighborhoods_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public GCNeighborhood instantiateAgent( int index ) {
    	return instantiate_Neighborhoods_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( GCNeighborhood agent, int index, TableInput tableInput ) {
      setupParameters_Neighborhoods_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( GCNeighborhood agent, int index, TableInput tableInput ) {
      doBeforeCreate_Neighborhoods_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "GCNeighborhood")
  public _Neighborhoods_Population Neighborhoods = new _Neighborhoods_Population( this );

  public String getNameOf( AgentList<?> aolist ) {
    if( aolist == pop_gridNodes ) return "pop_gridNodes";
    if( aolist == pop_gridConnections ) return "pop_gridConnections";
    if( aolist == pop_connectionOwners ) return "pop_connectionOwners";
    if( aolist == pop_energySuppliers ) return "pop_energySuppliers";
    if( aolist == pop_energyCoops ) return "pop_energyCoops";
    if( aolist == pop_gridOperators ) return "pop_gridOperators";
    if( aolist == Houses ) return "Houses";
    if( aolist == DistrictHeatingSystems ) return "DistrictHeatingSystems";
    if( aolist == EnergyProductionSites ) return "EnergyProductionSites";
    if( aolist == EnergyConversionSites ) return "EnergyConversionSites";
    if( aolist == UtilityConnections ) return "UtilityConnections";
    if( aolist == GridBatteries ) return "GridBatteries";
    if( aolist == pop_GIS_Buildings ) return "pop_GIS_Buildings";
    if( aolist == pop_GIS_Objects ) return "pop_GIS_Objects";
    if( aolist == pop_GIS_Parcels ) return "pop_GIS_Parcels";
    if( aolist == PublicChargers ) return "PublicChargers";
    if( aolist == Neighborhoods ) return "Neighborhoods";
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    return super.getAnimationSettingsOf( aolist );
  }

  /**
   * Returns the agent element at the specified position in pop_gridNodes
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GridNode pop_gridNodes(int index) {
    return pop_gridNodes.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_gridNodes<br>
   * @return newly created embedded object
   */
  public GridNode add_pop_gridNodes() {
    int index = pop_gridNodes.size();
    GridNode _result_xjal = instantiate_pop_gridNodes_xjal( index );
    pop_gridNodes.callSetupParameters( _result_xjal, index );
    pop_gridNodes.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_gridNodes<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_gridNodes.size()</code> method <strong>before</strong> this method is called
   * @param p_gridNodeID
   * @param p_parentNodeID
   * @param p_nodeType
   * @param p_energyCarrier
   * @param p_capacity_kW
   * @param p_transportBuffer
   * @param p_ownerGridOperator
   * @param p_gridNodeOwnerID
   * @param b_transportBufferValid
   * @param p_longitude
   * @param p_latitude
   * @param gisRegion
   * @param p_description
   * @param p_realCapacityAvailable
   * @param p_serviceAreaGisRegion
   * @param p_uniqueColor
   * @param p_localNodalPricingFactor_eurpkWh
   * @param p_defaultLineColor
   * @param p_defaultFillColor
   * @param p_localNodalPricingTreshold_fr
   * @param p_originalCapacity_kW
   * @param p_profileType
   * @return newly created embedded object
   */
  public GridNode add_pop_gridNodes( String p_gridNodeID, String p_parentNodeID, OL_GridNodeType p_nodeType, OL_EnergyCarriers p_energyCarrier, double p_capacity_kW, J_EAStorageHeat p_transportBuffer, GridOperator p_ownerGridOperator, String p_gridNodeOwnerID, boolean b_transportBufferValid, double p_longitude, double p_latitude, GISRegion gisRegion, String p_description, boolean p_realCapacityAvailable, GISRegion p_serviceAreaGisRegion, Color p_uniqueColor, double p_localNodalPricingFactor_eurpkWh, Color p_defaultLineColor, Color p_defaultFillColor, double p_localNodalPricingTreshold_fr, double p_originalCapacity_kW, OL_GridNodeProfileLoaderType p_profileType ) {
    int index = pop_gridNodes.size();
    GridNode _result_xjal = instantiate_pop_gridNodes_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_gridNodeID = p_gridNodeID;
    _result_xjal.p_parentNodeID = p_parentNodeID;
    _result_xjal.p_nodeType = p_nodeType;
    _result_xjal.p_energyCarrier = p_energyCarrier;
    _result_xjal.p_capacity_kW = p_capacity_kW;
    _result_xjal.p_transportBuffer = p_transportBuffer;
    _result_xjal.p_ownerGridOperator = p_ownerGridOperator;
    _result_xjal.p_gridNodeOwnerID = p_gridNodeOwnerID;
    _result_xjal.b_transportBufferValid = b_transportBufferValid;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.gisRegion = gisRegion;
    _result_xjal.p_description = p_description;
    _result_xjal.p_realCapacityAvailable = p_realCapacityAvailable;
    _result_xjal.p_serviceAreaGisRegion = p_serviceAreaGisRegion;
    _result_xjal.p_uniqueColor = p_uniqueColor;
    _result_xjal.p_localNodalPricingFactor_eurpkWh = p_localNodalPricingFactor_eurpkWh;
    _result_xjal.p_defaultLineColor = p_defaultLineColor;
    _result_xjal.p_defaultFillColor = p_defaultFillColor;
    _result_xjal.p_localNodalPricingTreshold_fr = p_localNodalPricingTreshold_fr;
    _result_xjal.p_originalCapacity_kW = p_originalCapacity_kW;
    _result_xjal.p_profileType = p_profileType;
    // Finish embedded object creation
    pop_gridNodes.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_gridNodes<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_gridNodes - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_gridNodes
   */
  public boolean remove_pop_gridNodes( GridNode object ) {
    if( ! pop_gridNodes._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_gridConnections
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GridConnection pop_gridConnections(int index) {
    return pop_gridConnections.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_gridConnections<br>
   * @return newly created embedded object
   */
  public GridConnection add_pop_gridConnections() {
    int index = pop_gridConnections.size();
    GridConnection _result_xjal = instantiate_pop_gridConnections_xjal( index );
    pop_gridConnections.callSetupParameters( _result_xjal, index );
    pop_gridConnections.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_gridConnections<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_gridConnections.size()</code> method <strong>before</strong> this method is called
   * @param p_parentNodeElectricID
   * @param p_gridConnectionID
   * @param p_parentNodeHeatID
   * @param p_BuildingThermalAsset
   * @param p_ownerID
   * @param p_batteryAsset
   * @param p_heatBuffer
   * @param p_gasBuffer
   * @param p_cookingTracker
   * @param p_insulationLabel
   * @param p_DHWAsset
   * @param p_longitude
   * @param p_latitude
   * @param p_floorSurfaceArea_m2
   * @param p_owner
   * @param p_roofSurfaceArea_m2
   * @param p_purposeBAG
   * @param p_address
   * @param p_parentNodeHeat
   * @param p_parentNodeElectric
   * @param v_isActive
   * @param p_energyLabel
   * @param p_airco
   * @return newly created embedded object
   */
  public GridConnection add_pop_gridConnections( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco ) {
    int index = pop_gridConnections.size();
    GridConnection _result_xjal = instantiate_pop_gridConnections_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_parentNodeElectricID = p_parentNodeElectricID;
    _result_xjal.p_gridConnectionID = p_gridConnectionID;
    _result_xjal.p_parentNodeHeatID = p_parentNodeHeatID;
    _result_xjal.p_BuildingThermalAsset = p_BuildingThermalAsset;
    _result_xjal.p_ownerID = p_ownerID;
    _result_xjal.p_batteryAsset = p_batteryAsset;
    _result_xjal.p_heatBuffer = p_heatBuffer;
    _result_xjal.p_gasBuffer = p_gasBuffer;
    _result_xjal.p_cookingTracker = p_cookingTracker;
    _result_xjal.p_insulationLabel = p_insulationLabel;
    _result_xjal.p_DHWAsset = p_DHWAsset;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    _result_xjal.p_owner = p_owner;
    _result_xjal.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    _result_xjal.p_purposeBAG = p_purposeBAG;
    _result_xjal.p_address = p_address;
    _result_xjal.p_parentNodeHeat = p_parentNodeHeat;
    _result_xjal.p_parentNodeElectric = p_parentNodeElectric;
    _result_xjal.v_isActive = v_isActive;
    _result_xjal.p_energyLabel = p_energyLabel;
    _result_xjal.p_airco = p_airco;
    // Finish embedded object creation
    pop_gridConnections.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_gridConnections<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_gridConnections - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_gridConnections
   */
  public boolean remove_pop_gridConnections( GridConnection object ) {
    if( ! pop_gridConnections._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_connectionOwners
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public ConnectionOwner pop_connectionOwners(int index) {
    return pop_connectionOwners.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_connectionOwners<br>
   * @return newly created embedded object
   */
  public ConnectionOwner add_pop_connectionOwners() {
    int index = pop_connectionOwners.size();
    ConnectionOwner _result_xjal = instantiate_pop_connectionOwners_xjal( index );
    pop_connectionOwners.callSetupParameters( _result_xjal, index );
    pop_connectionOwners.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_connectionOwners<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_connectionOwners.size()</code> method <strong>before</strong> this method is called
   * @param p_actorID
   * @param p_actorGroup
   * @param p_actorSubgroup
   * @param p_coopParent
   * @param p_electricitySupplier
   * @param p_gridOperator
   * @param p_methaneSupplier
   * @param p_hydrogenSupplier
   * @param p_heatSupplier
   * @param p_connectionOwnerType
   * @param p_detailedCompany
   * @param p_energySupplierID
   * @param p_energyCoopID
   * @param b_dataSharingAgreed
   * @param b_dataIsAccessible
   * @return newly created embedded object
   */
  public ConnectionOwner add_pop_connectionOwners( String p_actorID, String p_actorGroup, String p_actorSubgroup, EnergyCoop p_coopParent, Actor p_electricitySupplier, Actor p_gridOperator, Actor p_methaneSupplier, Actor p_hydrogenSupplier, Actor p_heatSupplier, OL_ConnectionOwnerType p_connectionOwnerType, boolean p_detailedCompany, String p_energySupplierID, String p_energyCoopID, boolean b_dataSharingAgreed, boolean b_dataIsAccessible ) {
    int index = pop_connectionOwners.size();
    ConnectionOwner _result_xjal = instantiate_pop_connectionOwners_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_actorID = p_actorID;
    _result_xjal.p_actorGroup = p_actorGroup;
    _result_xjal.p_actorSubgroup = p_actorSubgroup;
    _result_xjal.p_coopParent = p_coopParent;
    _result_xjal.p_electricitySupplier = p_electricitySupplier;
    _result_xjal.p_gridOperator = p_gridOperator;
    _result_xjal.p_methaneSupplier = p_methaneSupplier;
    _result_xjal.p_hydrogenSupplier = p_hydrogenSupplier;
    _result_xjal.p_heatSupplier = p_heatSupplier;
    _result_xjal.p_connectionOwnerType = p_connectionOwnerType;
    _result_xjal.p_detailedCompany = p_detailedCompany;
    _result_xjal.p_energySupplierID = p_energySupplierID;
    _result_xjal.p_energyCoopID = p_energyCoopID;
    _result_xjal.b_dataSharingAgreed = b_dataSharingAgreed;
    _result_xjal.b_dataIsAccessible = b_dataIsAccessible;
    // Finish embedded object creation
    pop_connectionOwners.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_connectionOwners<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_connectionOwners - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_connectionOwners
   */
  public boolean remove_pop_connectionOwners( ConnectionOwner object ) {
    if( ! pop_connectionOwners._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_energySuppliers
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public EnergySupplier pop_energySuppliers(int index) {
    return pop_energySuppliers.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_energySuppliers<br>
   * @return newly created embedded object
   */
  public EnergySupplier add_pop_energySuppliers() {
    int index = pop_energySuppliers.size();
    EnergySupplier _result_xjal = instantiate_pop_energySuppliers_xjal( index );
    pop_energySuppliers.callSetupParameters( _result_xjal, index );
    pop_energySuppliers.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_energySuppliers<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_energySuppliers.size()</code> method <strong>before</strong> this method is called
   * @param p_actorID
   * @param p_actorGroup
   * @param p_actorSubgroup
   * @param p_fixedElectricityPrice_eurpkWh
   * @param p_fixedHeatPrice_eurpkWh
   * @param p_fixedMethanePrice_eurpkWh
   * @param p_fixedHydrogenPrice_eurpkWh
   * @param p_variableElectricityPriceOverNational_eurpkWh
   * @param p_fixedFeedinTariff_eurpkWh
   * @param p_salderenActive
   * @return newly created embedded object
   */
  public EnergySupplier add_pop_energySuppliers( String p_actorID, String p_actorGroup, String p_actorSubgroup, double p_fixedElectricityPrice_eurpkWh, double p_fixedHeatPrice_eurpkWh, double p_fixedMethanePrice_eurpkWh, double p_fixedHydrogenPrice_eurpkWh, double p_variableElectricityPriceOverNational_eurpkWh, double p_fixedFeedinTariff_eurpkWh, boolean p_salderenActive ) {
    int index = pop_energySuppliers.size();
    EnergySupplier _result_xjal = instantiate_pop_energySuppliers_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_actorID = p_actorID;
    _result_xjal.p_actorGroup = p_actorGroup;
    _result_xjal.p_actorSubgroup = p_actorSubgroup;
    _result_xjal.p_fixedElectricityPrice_eurpkWh = p_fixedElectricityPrice_eurpkWh;
    _result_xjal.p_fixedHeatPrice_eurpkWh = p_fixedHeatPrice_eurpkWh;
    _result_xjal.p_fixedMethanePrice_eurpkWh = p_fixedMethanePrice_eurpkWh;
    _result_xjal.p_fixedHydrogenPrice_eurpkWh = p_fixedHydrogenPrice_eurpkWh;
    _result_xjal.p_variableElectricityPriceOverNational_eurpkWh = p_variableElectricityPriceOverNational_eurpkWh;
    _result_xjal.p_fixedFeedinTariff_eurpkWh = p_fixedFeedinTariff_eurpkWh;
    _result_xjal.p_salderenActive = p_salderenActive;
    // Finish embedded object creation
    pop_energySuppliers.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_energySuppliers<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_energySuppliers - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_energySuppliers
   */
  public boolean remove_pop_energySuppliers( EnergySupplier object ) {
    if( ! pop_energySuppliers._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_energyCoops
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public EnergyCoop pop_energyCoops(int index) {
    return pop_energyCoops.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_energyCoops<br>
   * @return newly created embedded object
   */
  public EnergyCoop add_pop_energyCoops() {
    int index = pop_energyCoops.size();
    EnergyCoop _result_xjal = instantiate_pop_energyCoops_xjal( index );
    pop_energyCoops.callSetupParameters( _result_xjal, index );
    pop_energyCoops.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_energyCoops<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_energyCoops.size()</code> method <strong>before</strong> this method is called
   * @param p_actorID
   * @param p_actorGroup
   * @param p_actorSubgroup
   * @param p_actorContractList
   * @param p_electricitySupplier
   * @param p_CoopParent
   * @param p_gridOperator
   * @param p_methaneSupplier
   * @param p_hydrogenSupplier
   * @param p_heatSupplier
   * @return newly created embedded object
   */
  public EnergyCoop add_pop_energyCoops( String p_actorID, String p_actorGroup, String p_actorSubgroup, com.fasterxml.jackson.databind.node.ArrayNode p_actorContractList, Actor p_electricitySupplier, Actor p_CoopParent, Actor p_gridOperator, Actor p_methaneSupplier, Actor p_hydrogenSupplier, Actor p_heatSupplier ) {
    int index = pop_energyCoops.size();
    EnergyCoop _result_xjal = instantiate_pop_energyCoops_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_actorID = p_actorID;
    _result_xjal.p_actorGroup = p_actorGroup;
    _result_xjal.p_actorSubgroup = p_actorSubgroup;
    _result_xjal.p_actorContractList = p_actorContractList;
    _result_xjal.p_electricitySupplier = p_electricitySupplier;
    _result_xjal.p_CoopParent = p_CoopParent;
    _result_xjal.p_gridOperator = p_gridOperator;
    _result_xjal.p_methaneSupplier = p_methaneSupplier;
    _result_xjal.p_hydrogenSupplier = p_hydrogenSupplier;
    _result_xjal.p_heatSupplier = p_heatSupplier;
    // Finish embedded object creation
    pop_energyCoops.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_energyCoops<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_energyCoops - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_energyCoops
   */
  public boolean remove_pop_energyCoops( EnergyCoop object ) {
    if( ! pop_energyCoops._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_gridOperators
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GridOperator pop_gridOperators(int index) {
    return pop_gridOperators.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_gridOperators<br>
   * @return newly created embedded object
   */
  public GridOperator add_pop_gridOperators() {
    int index = pop_gridOperators.size();
    GridOperator _result_xjal = instantiate_pop_gridOperators_xjal( index );
    pop_gridOperators.callSetupParameters( _result_xjal, index );
    pop_gridOperators.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_gridOperators<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_gridOperators.size()</code> method <strong>before</strong> this method is called
   * @param p_actorID
   * @param p_actorGroup
   * @param p_actorSubgroup
   * @return newly created embedded object
   */
  public GridOperator add_pop_gridOperators( String p_actorID, String p_actorGroup, String p_actorSubgroup ) {
    int index = pop_gridOperators.size();
    GridOperator _result_xjal = instantiate_pop_gridOperators_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_actorID = p_actorID;
    _result_xjal.p_actorGroup = p_actorGroup;
    _result_xjal.p_actorSubgroup = p_actorSubgroup;
    // Finish embedded object creation
    pop_gridOperators.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_gridOperators<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_gridOperators - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_gridOperators
   */
  public boolean remove_pop_gridOperators( GridOperator object ) {
    if( ! pop_gridOperators._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in Houses
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GCHouse Houses(int index) {
    return Houses.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection Houses<br>
   * @return newly created embedded object
   */
  public GCHouse add_Houses() {
    int index = Houses.size();
    GCHouse _result_xjal = instantiate_Houses_xjal( index );
    Houses.callSetupParameters( _result_xjal, index );
    Houses.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection Houses<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>Houses.size()</code> method <strong>before</strong> this method is called
   * @param p_parentNodeElectricID
   * @param p_gridConnectionID
   * @param p_parentNodeHeatID
   * @param p_BuildingThermalAsset
   * @param p_ownerID
   * @param p_batteryAsset
   * @param p_heatBuffer
   * @param p_gasBuffer
   * @param p_cookingTracker
   * @param p_insulationLabel
   * @param p_DHWAsset
   * @param p_longitude
   * @param p_latitude
   * @param p_floorSurfaceArea_m2
   * @param p_owner
   * @param p_roofSurfaceArea_m2
   * @param p_purposeBAG
   * @param p_address
   * @param p_parentNodeHeat
   * @param p_parentNodeElectric
   * @param v_isActive
   * @param p_energyLabel
   * @param p_airco
   * @param p_buildYear
   * @param p_eigenOprit
   * @param p_cookingMethod
   * @param p_PBLParameters
   * @return newly created embedded object
   */
  public GCHouse add_Houses( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco, int p_buildYear, boolean p_eigenOprit, OL_HouseholdCookingMethod p_cookingMethod, J_PBLParameters p_PBLParameters ) {
    int index = Houses.size();
    GCHouse _result_xjal = instantiate_Houses_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_parentNodeElectricID = p_parentNodeElectricID;
    _result_xjal.p_gridConnectionID = p_gridConnectionID;
    _result_xjal.p_parentNodeHeatID = p_parentNodeHeatID;
    _result_xjal.p_BuildingThermalAsset = p_BuildingThermalAsset;
    _result_xjal.p_ownerID = p_ownerID;
    _result_xjal.p_batteryAsset = p_batteryAsset;
    _result_xjal.p_heatBuffer = p_heatBuffer;
    _result_xjal.p_gasBuffer = p_gasBuffer;
    _result_xjal.p_cookingTracker = p_cookingTracker;
    _result_xjal.p_insulationLabel = p_insulationLabel;
    _result_xjal.p_DHWAsset = p_DHWAsset;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    _result_xjal.p_owner = p_owner;
    _result_xjal.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    _result_xjal.p_purposeBAG = p_purposeBAG;
    _result_xjal.p_address = p_address;
    _result_xjal.p_parentNodeHeat = p_parentNodeHeat;
    _result_xjal.p_parentNodeElectric = p_parentNodeElectric;
    _result_xjal.v_isActive = v_isActive;
    _result_xjal.p_energyLabel = p_energyLabel;
    _result_xjal.p_airco = p_airco;
    _result_xjal.p_buildYear = p_buildYear;
    _result_xjal.p_eigenOprit = p_eigenOprit;
    _result_xjal.p_cookingMethod = p_cookingMethod;
    _result_xjal.p_PBLParameters = p_PBLParameters;
    // Finish embedded object creation
    Houses.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection Houses<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object Houses - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to Houses
   */
  public boolean remove_Houses( GCHouse object ) {
    if( ! Houses._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in DistrictHeatingSystems
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GCDistrictHeating DistrictHeatingSystems(int index) {
    return DistrictHeatingSystems.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection DistrictHeatingSystems<br>
   * @return newly created embedded object
   */
  public GCDistrictHeating add_DistrictHeatingSystems() {
    int index = DistrictHeatingSystems.size();
    GCDistrictHeating _result_xjal = instantiate_DistrictHeatingSystems_xjal( index );
    DistrictHeatingSystems.callSetupParameters( _result_xjal, index );
    DistrictHeatingSystems.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection DistrictHeatingSystems<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>DistrictHeatingSystems.size()</code> method <strong>before</strong> this method is called
   * @param p_parentNodeElectricID
   * @param p_gridConnectionID
   * @param p_parentNodeHeatID
   * @param p_BuildingThermalAsset
   * @param p_ownerID
   * @param p_batteryAsset
   * @param p_heatBuffer
   * @param p_gasBuffer
   * @param p_cookingTracker
   * @param p_insulationLabel
   * @param p_DHWAsset
   * @param p_longitude
   * @param p_latitude
   * @param p_floorSurfaceArea_m2
   * @param p_owner
   * @param p_roofSurfaceArea_m2
   * @param p_purposeBAG
   * @param p_address
   * @param p_parentNodeHeat
   * @param p_parentNodeElectric
   * @param v_isActive
   * @param p_energyLabel
   * @param p_airco
   * @param p_residualHeatLTSource
   * @param p_DHheatStorage
   * @return newly created embedded object
   */
  public GCDistrictHeating add_DistrictHeatingSystems( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco, J_EAProduction p_residualHeatLTSource, J_EAStorageHeat p_DHheatStorage ) {
    int index = DistrictHeatingSystems.size();
    GCDistrictHeating _result_xjal = instantiate_DistrictHeatingSystems_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_parentNodeElectricID = p_parentNodeElectricID;
    _result_xjal.p_gridConnectionID = p_gridConnectionID;
    _result_xjal.p_parentNodeHeatID = p_parentNodeHeatID;
    _result_xjal.p_BuildingThermalAsset = p_BuildingThermalAsset;
    _result_xjal.p_ownerID = p_ownerID;
    _result_xjal.p_batteryAsset = p_batteryAsset;
    _result_xjal.p_heatBuffer = p_heatBuffer;
    _result_xjal.p_gasBuffer = p_gasBuffer;
    _result_xjal.p_cookingTracker = p_cookingTracker;
    _result_xjal.p_insulationLabel = p_insulationLabel;
    _result_xjal.p_DHWAsset = p_DHWAsset;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    _result_xjal.p_owner = p_owner;
    _result_xjal.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    _result_xjal.p_purposeBAG = p_purposeBAG;
    _result_xjal.p_address = p_address;
    _result_xjal.p_parentNodeHeat = p_parentNodeHeat;
    _result_xjal.p_parentNodeElectric = p_parentNodeElectric;
    _result_xjal.v_isActive = v_isActive;
    _result_xjal.p_energyLabel = p_energyLabel;
    _result_xjal.p_airco = p_airco;
    _result_xjal.p_residualHeatLTSource = p_residualHeatLTSource;
    _result_xjal.p_DHheatStorage = p_DHheatStorage;
    // Finish embedded object creation
    DistrictHeatingSystems.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection DistrictHeatingSystems<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object DistrictHeatingSystems - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to DistrictHeatingSystems
   */
  public boolean remove_DistrictHeatingSystems( GCDistrictHeating object ) {
    if( ! DistrictHeatingSystems._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in EnergyProductionSites
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GCEnergyProduction EnergyProductionSites(int index) {
    return EnergyProductionSites.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection EnergyProductionSites<br>
   * @return newly created embedded object
   */
  public GCEnergyProduction add_EnergyProductionSites() {
    int index = EnergyProductionSites.size();
    GCEnergyProduction _result_xjal = instantiate_EnergyProductionSites_xjal( index );
    EnergyProductionSites.callSetupParameters( _result_xjal, index );
    EnergyProductionSites.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection EnergyProductionSites<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>EnergyProductionSites.size()</code> method <strong>before</strong> this method is called
   * @param p_parentNodeElectricID
   * @param p_gridConnectionID
   * @param p_parentNodeHeatID
   * @param p_BuildingThermalAsset
   * @param p_ownerID
   * @param p_batteryAsset
   * @param p_heatBuffer
   * @param p_gasBuffer
   * @param p_cookingTracker
   * @param p_insulationLabel
   * @param p_DHWAsset
   * @param p_longitude
   * @param p_latitude
   * @param p_floorSurfaceArea_m2
   * @param p_owner
   * @param p_roofSurfaceArea_m2
   * @param p_purposeBAG
   * @param p_address
   * @param p_parentNodeHeat
   * @param p_parentNodeElectric
   * @param v_isActive
   * @param p_energyLabel
   * @param p_airco
   * @param p_isSliderGC
   * @return newly created embedded object
   */
  public GCEnergyProduction add_EnergyProductionSites( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco, boolean p_isSliderGC ) {
    int index = EnergyProductionSites.size();
    GCEnergyProduction _result_xjal = instantiate_EnergyProductionSites_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_parentNodeElectricID = p_parentNodeElectricID;
    _result_xjal.p_gridConnectionID = p_gridConnectionID;
    _result_xjal.p_parentNodeHeatID = p_parentNodeHeatID;
    _result_xjal.p_BuildingThermalAsset = p_BuildingThermalAsset;
    _result_xjal.p_ownerID = p_ownerID;
    _result_xjal.p_batteryAsset = p_batteryAsset;
    _result_xjal.p_heatBuffer = p_heatBuffer;
    _result_xjal.p_gasBuffer = p_gasBuffer;
    _result_xjal.p_cookingTracker = p_cookingTracker;
    _result_xjal.p_insulationLabel = p_insulationLabel;
    _result_xjal.p_DHWAsset = p_DHWAsset;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    _result_xjal.p_owner = p_owner;
    _result_xjal.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    _result_xjal.p_purposeBAG = p_purposeBAG;
    _result_xjal.p_address = p_address;
    _result_xjal.p_parentNodeHeat = p_parentNodeHeat;
    _result_xjal.p_parentNodeElectric = p_parentNodeElectric;
    _result_xjal.v_isActive = v_isActive;
    _result_xjal.p_energyLabel = p_energyLabel;
    _result_xjal.p_airco = p_airco;
    _result_xjal.p_isSliderGC = p_isSliderGC;
    // Finish embedded object creation
    EnergyProductionSites.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection EnergyProductionSites<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object EnergyProductionSites - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to EnergyProductionSites
   */
  public boolean remove_EnergyProductionSites( GCEnergyProduction object ) {
    if( ! EnergyProductionSites._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in EnergyConversionSites
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GCEnergyConversion EnergyConversionSites(int index) {
    return EnergyConversionSites.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection EnergyConversionSites<br>
   * @return newly created embedded object
   */
  public GCEnergyConversion add_EnergyConversionSites() {
    int index = EnergyConversionSites.size();
    GCEnergyConversion _result_xjal = instantiate_EnergyConversionSites_xjal( index );
    EnergyConversionSites.callSetupParameters( _result_xjal, index );
    EnergyConversionSites.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection EnergyConversionSites<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>EnergyConversionSites.size()</code> method <strong>before</strong> this method is called
   * @param p_parentNodeElectricID
   * @param p_gridConnectionID
   * @param p_parentNodeHeatID
   * @param p_BuildingThermalAsset
   * @param p_ownerID
   * @param p_batteryAsset
   * @param p_heatBuffer
   * @param p_gasBuffer
   * @param p_cookingTracker
   * @param p_insulationLabel
   * @param p_DHWAsset
   * @param p_longitude
   * @param p_latitude
   * @param p_floorSurfaceArea_m2
   * @param p_owner
   * @param p_roofSurfaceArea_m2
   * @param p_purposeBAG
   * @param p_address
   * @param p_parentNodeHeat
   * @param p_parentNodeElectric
   * @param v_isActive
   * @param p_energyLabel
   * @param p_airco
   * @return newly created embedded object
   */
  public GCEnergyConversion add_EnergyConversionSites( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco ) {
    int index = EnergyConversionSites.size();
    GCEnergyConversion _result_xjal = instantiate_EnergyConversionSites_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_parentNodeElectricID = p_parentNodeElectricID;
    _result_xjal.p_gridConnectionID = p_gridConnectionID;
    _result_xjal.p_parentNodeHeatID = p_parentNodeHeatID;
    _result_xjal.p_BuildingThermalAsset = p_BuildingThermalAsset;
    _result_xjal.p_ownerID = p_ownerID;
    _result_xjal.p_batteryAsset = p_batteryAsset;
    _result_xjal.p_heatBuffer = p_heatBuffer;
    _result_xjal.p_gasBuffer = p_gasBuffer;
    _result_xjal.p_cookingTracker = p_cookingTracker;
    _result_xjal.p_insulationLabel = p_insulationLabel;
    _result_xjal.p_DHWAsset = p_DHWAsset;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    _result_xjal.p_owner = p_owner;
    _result_xjal.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    _result_xjal.p_purposeBAG = p_purposeBAG;
    _result_xjal.p_address = p_address;
    _result_xjal.p_parentNodeHeat = p_parentNodeHeat;
    _result_xjal.p_parentNodeElectric = p_parentNodeElectric;
    _result_xjal.v_isActive = v_isActive;
    _result_xjal.p_energyLabel = p_energyLabel;
    _result_xjal.p_airco = p_airco;
    // Finish embedded object creation
    EnergyConversionSites.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection EnergyConversionSites<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object EnergyConversionSites - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to EnergyConversionSites
   */
  public boolean remove_EnergyConversionSites( GCEnergyConversion object ) {
    if( ! EnergyConversionSites._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in UtilityConnections
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GCUtility UtilityConnections(int index) {
    return UtilityConnections.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection UtilityConnections<br>
   * @return newly created embedded object
   */
  public GCUtility add_UtilityConnections() {
    int index = UtilityConnections.size();
    GCUtility _result_xjal = instantiate_UtilityConnections_xjal( index );
    UtilityConnections.callSetupParameters( _result_xjal, index );
    UtilityConnections.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection UtilityConnections<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>UtilityConnections.size()</code> method <strong>before</strong> this method is called
   * @param p_parentNodeElectricID
   * @param p_gridConnectionID
   * @param p_parentNodeHeatID
   * @param p_BuildingThermalAsset
   * @param p_ownerID
   * @param p_batteryAsset
   * @param p_heatBuffer
   * @param p_gasBuffer
   * @param p_cookingTracker
   * @param p_insulationLabel
   * @param p_DHWAsset
   * @param p_longitude
   * @param p_latitude
   * @param p_floorSurfaceArea_m2
   * @param p_owner
   * @param p_roofSurfaceArea_m2
   * @param p_purposeBAG
   * @param p_address
   * @param p_parentNodeHeat
   * @param p_parentNodeElectric
   * @param v_isActive
   * @param p_energyLabel
   * @param p_airco
   * @return newly created embedded object
   */
  public GCUtility add_UtilityConnections( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco ) {
    int index = UtilityConnections.size();
    GCUtility _result_xjal = instantiate_UtilityConnections_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_parentNodeElectricID = p_parentNodeElectricID;
    _result_xjal.p_gridConnectionID = p_gridConnectionID;
    _result_xjal.p_parentNodeHeatID = p_parentNodeHeatID;
    _result_xjal.p_BuildingThermalAsset = p_BuildingThermalAsset;
    _result_xjal.p_ownerID = p_ownerID;
    _result_xjal.p_batteryAsset = p_batteryAsset;
    _result_xjal.p_heatBuffer = p_heatBuffer;
    _result_xjal.p_gasBuffer = p_gasBuffer;
    _result_xjal.p_cookingTracker = p_cookingTracker;
    _result_xjal.p_insulationLabel = p_insulationLabel;
    _result_xjal.p_DHWAsset = p_DHWAsset;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    _result_xjal.p_owner = p_owner;
    _result_xjal.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    _result_xjal.p_purposeBAG = p_purposeBAG;
    _result_xjal.p_address = p_address;
    _result_xjal.p_parentNodeHeat = p_parentNodeHeat;
    _result_xjal.p_parentNodeElectric = p_parentNodeElectric;
    _result_xjal.v_isActive = v_isActive;
    _result_xjal.p_energyLabel = p_energyLabel;
    _result_xjal.p_airco = p_airco;
    // Finish embedded object creation
    UtilityConnections.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection UtilityConnections<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object UtilityConnections - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to UtilityConnections
   */
  public boolean remove_UtilityConnections( GCUtility object ) {
    if( ! UtilityConnections._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in GridBatteries
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GCGridBattery GridBatteries(int index) {
    return GridBatteries.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection GridBatteries<br>
   * @return newly created embedded object
   */
  public GCGridBattery add_GridBatteries() {
    int index = GridBatteries.size();
    GCGridBattery _result_xjal = instantiate_GridBatteries_xjal( index );
    GridBatteries.callSetupParameters( _result_xjal, index );
    GridBatteries.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection GridBatteries<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>GridBatteries.size()</code> method <strong>before</strong> this method is called
   * @param p_parentNodeElectricID
   * @param p_gridConnectionID
   * @param p_parentNodeHeatID
   * @param p_BuildingThermalAsset
   * @param p_ownerID
   * @param p_batteryAsset
   * @param p_heatBuffer
   * @param p_gasBuffer
   * @param p_cookingTracker
   * @param p_insulationLabel
   * @param p_DHWAsset
   * @param p_longitude
   * @param p_latitude
   * @param p_floorSurfaceArea_m2
   * @param p_owner
   * @param p_roofSurfaceArea_m2
   * @param p_purposeBAG
   * @param p_address
   * @param p_parentNodeHeat
   * @param p_parentNodeElectric
   * @param v_isActive
   * @param p_energyLabel
   * @param p_airco
   * @param p_isSliderGC
   * @return newly created embedded object
   */
  public GCGridBattery add_GridBatteries( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco, boolean p_isSliderGC ) {
    int index = GridBatteries.size();
    GCGridBattery _result_xjal = instantiate_GridBatteries_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_parentNodeElectricID = p_parentNodeElectricID;
    _result_xjal.p_gridConnectionID = p_gridConnectionID;
    _result_xjal.p_parentNodeHeatID = p_parentNodeHeatID;
    _result_xjal.p_BuildingThermalAsset = p_BuildingThermalAsset;
    _result_xjal.p_ownerID = p_ownerID;
    _result_xjal.p_batteryAsset = p_batteryAsset;
    _result_xjal.p_heatBuffer = p_heatBuffer;
    _result_xjal.p_gasBuffer = p_gasBuffer;
    _result_xjal.p_cookingTracker = p_cookingTracker;
    _result_xjal.p_insulationLabel = p_insulationLabel;
    _result_xjal.p_DHWAsset = p_DHWAsset;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    _result_xjal.p_owner = p_owner;
    _result_xjal.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    _result_xjal.p_purposeBAG = p_purposeBAG;
    _result_xjal.p_address = p_address;
    _result_xjal.p_parentNodeHeat = p_parentNodeHeat;
    _result_xjal.p_parentNodeElectric = p_parentNodeElectric;
    _result_xjal.v_isActive = v_isActive;
    _result_xjal.p_energyLabel = p_energyLabel;
    _result_xjal.p_airco = p_airco;
    _result_xjal.p_isSliderGC = p_isSliderGC;
    // Finish embedded object creation
    GridBatteries.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection GridBatteries<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object GridBatteries - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to GridBatteries
   */
  public boolean remove_GridBatteries( GCGridBattery object ) {
    if( ! GridBatteries._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_GIS_Buildings
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GIS_Building pop_GIS_Buildings(int index) {
    return pop_GIS_Buildings.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_GIS_Buildings<br>
   * @return newly created embedded object
   */
  public GIS_Building add_pop_GIS_Buildings() {
    int index = pop_GIS_Buildings.size();
    GIS_Building _result_xjal = instantiate_pop_GIS_Buildings_xjal( index );
    pop_GIS_Buildings.callSetupParameters( _result_xjal, index );
    pop_GIS_Buildings.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_GIS_Buildings<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_GIS_Buildings.size()</code> method <strong>before</strong> this method is called
   * @param gisRegion
   * @param p_longitude
   * @param p_latitude
   * @param p_GISObjectType
   * @param p_id
   * @param p_defaultLineColor
   * @param p_defaultFillColor
   * @param p_defaultLineWidth
   * @param p_defaultLineStyle
   * @param p_annotation
   * @param p_defaultFillColorString
   * @param p_defaultLineColorString
   * @param p_defaultLineStyleString
   * @param p_status
   * @param p_useType
   * @param p_buildingYear
   * @param p_floorSurfaceArea_m2
   * @param p_floors
   * @param p_roofSurfaceArea_m2
   * @param p_pandNaam
   * @return newly created embedded object
   */
  public GIS_Building add_pop_GIS_Buildings( GISRegion gisRegion, double p_longitude, double p_latitude, OL_GISObjectType p_GISObjectType, String p_id, Color p_defaultLineColor, Color p_defaultFillColor, double p_defaultLineWidth, LineStyle p_defaultLineStyle, String p_annotation, String p_defaultFillColorString, String p_defaultLineColorString, String p_defaultLineStyleString, String p_status, String p_useType, double p_buildingYear, double p_floorSurfaceArea_m2, double p_floors, double p_roofSurfaceArea_m2, String p_pandNaam ) {
    int index = pop_GIS_Buildings.size();
    GIS_Building _result_xjal = instantiate_pop_GIS_Buildings_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.gisRegion = gisRegion;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_GISObjectType = p_GISObjectType;
    _result_xjal.p_id = p_id;
    _result_xjal.p_defaultLineColor = p_defaultLineColor;
    _result_xjal.p_defaultFillColor = p_defaultFillColor;
    _result_xjal.p_defaultLineWidth = p_defaultLineWidth;
    _result_xjal.p_defaultLineStyle = p_defaultLineStyle;
    _result_xjal.p_annotation = p_annotation;
    _result_xjal.p_defaultFillColorString = p_defaultFillColorString;
    _result_xjal.p_defaultLineColorString = p_defaultLineColorString;
    _result_xjal.p_defaultLineStyleString = p_defaultLineStyleString;
    _result_xjal.p_status = p_status;
    _result_xjal.p_useType = p_useType;
    _result_xjal.p_buildingYear = p_buildingYear;
    _result_xjal.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    _result_xjal.p_floors = p_floors;
    _result_xjal.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    _result_xjal.p_pandNaam = p_pandNaam;
    // Finish embedded object creation
    pop_GIS_Buildings.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_GIS_Buildings<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_GIS_Buildings - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_GIS_Buildings
   */
  public boolean remove_pop_GIS_Buildings( GIS_Building object ) {
    if( ! pop_GIS_Buildings._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_GIS_Objects
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GIS_Object pop_GIS_Objects(int index) {
    return pop_GIS_Objects.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_GIS_Objects<br>
   * @return newly created embedded object
   */
  public GIS_Object add_pop_GIS_Objects() {
    int index = pop_GIS_Objects.size();
    GIS_Object _result_xjal = instantiate_pop_GIS_Objects_xjal( index );
    pop_GIS_Objects.callSetupParameters( _result_xjal, index );
    pop_GIS_Objects.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_GIS_Objects<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_GIS_Objects.size()</code> method <strong>before</strong> this method is called
   * @param gisRegion
   * @param p_longitude
   * @param p_latitude
   * @param p_GISObjectType
   * @param p_id
   * @param p_defaultLineColor
   * @param p_defaultFillColor
   * @param p_defaultLineWidth
   * @param p_defaultLineStyle
   * @param p_annotation
   * @param p_defaultFillColorString
   * @param p_defaultLineColorString
   * @param p_defaultLineStyleString
   * @return newly created embedded object
   */
  public GIS_Object add_pop_GIS_Objects( GISRegion gisRegion, double p_longitude, double p_latitude, OL_GISObjectType p_GISObjectType, String p_id, Color p_defaultLineColor, Color p_defaultFillColor, double p_defaultLineWidth, LineStyle p_defaultLineStyle, String p_annotation, String p_defaultFillColorString, String p_defaultLineColorString, String p_defaultLineStyleString ) {
    int index = pop_GIS_Objects.size();
    GIS_Object _result_xjal = instantiate_pop_GIS_Objects_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.gisRegion = gisRegion;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_GISObjectType = p_GISObjectType;
    _result_xjal.p_id = p_id;
    _result_xjal.p_defaultLineColor = p_defaultLineColor;
    _result_xjal.p_defaultFillColor = p_defaultFillColor;
    _result_xjal.p_defaultLineWidth = p_defaultLineWidth;
    _result_xjal.p_defaultLineStyle = p_defaultLineStyle;
    _result_xjal.p_annotation = p_annotation;
    _result_xjal.p_defaultFillColorString = p_defaultFillColorString;
    _result_xjal.p_defaultLineColorString = p_defaultLineColorString;
    _result_xjal.p_defaultLineStyleString = p_defaultLineStyleString;
    // Finish embedded object creation
    pop_GIS_Objects.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_GIS_Objects<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_GIS_Objects - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_GIS_Objects
   */
  public boolean remove_pop_GIS_Objects( GIS_Object object ) {
    if( ! pop_GIS_Objects._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_GIS_Parcels
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GIS_Parcel pop_GIS_Parcels(int index) {
    return pop_GIS_Parcels.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_GIS_Parcels<br>
   * @return newly created embedded object
   */
  public GIS_Parcel add_pop_GIS_Parcels() {
    int index = pop_GIS_Parcels.size();
    GIS_Parcel _result_xjal = instantiate_pop_GIS_Parcels_xjal( index );
    pop_GIS_Parcels.callSetupParameters( _result_xjal, index );
    pop_GIS_Parcels.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_GIS_Parcels<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_GIS_Parcels.size()</code> method <strong>before</strong> this method is called
   * @param gisRegion
   * @param p_longitude
   * @param p_latitude
   * @param p_GISObjectType
   * @param p_id
   * @param p_defaultLineColor
   * @param p_defaultFillColor
   * @param p_defaultLineWidth
   * @param p_defaultLineStyle
   * @param p_annotation
   * @param p_defaultFillColorString
   * @param p_defaultLineColorString
   * @param p_defaultLineStyleString
   * @param p_address
   * @return newly created embedded object
   */
  public GIS_Parcel add_pop_GIS_Parcels( GISRegion gisRegion, double p_longitude, double p_latitude, OL_GISObjectType p_GISObjectType, String p_id, Color p_defaultLineColor, Color p_defaultFillColor, double p_defaultLineWidth, LineStyle p_defaultLineStyle, String p_annotation, String p_defaultFillColorString, String p_defaultLineColorString, String p_defaultLineStyleString, J_Address p_address ) {
    int index = pop_GIS_Parcels.size();
    GIS_Parcel _result_xjal = instantiate_pop_GIS_Parcels_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.gisRegion = gisRegion;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_GISObjectType = p_GISObjectType;
    _result_xjal.p_id = p_id;
    _result_xjal.p_defaultLineColor = p_defaultLineColor;
    _result_xjal.p_defaultFillColor = p_defaultFillColor;
    _result_xjal.p_defaultLineWidth = p_defaultLineWidth;
    _result_xjal.p_defaultLineStyle = p_defaultLineStyle;
    _result_xjal.p_annotation = p_annotation;
    _result_xjal.p_defaultFillColorString = p_defaultFillColorString;
    _result_xjal.p_defaultLineColorString = p_defaultLineColorString;
    _result_xjal.p_defaultLineStyleString = p_defaultLineStyleString;
    _result_xjal.p_address = p_address;
    // Finish embedded object creation
    pop_GIS_Parcels.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_GIS_Parcels<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_GIS_Parcels - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_GIS_Parcels
   */
  public boolean remove_pop_GIS_Parcels( GIS_Parcel object ) {
    if( ! pop_GIS_Parcels._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in PublicChargers
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GCPublicCharger PublicChargers(int index) {
    return PublicChargers.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection PublicChargers<br>
   * @return newly created embedded object
   */
  public GCPublicCharger add_PublicChargers() {
    int index = PublicChargers.size();
    GCPublicCharger _result_xjal = instantiate_PublicChargers_xjal( index );
    PublicChargers.callSetupParameters( _result_xjal, index );
    PublicChargers.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection PublicChargers<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>PublicChargers.size()</code> method <strong>before</strong> this method is called
   * @param p_parentNodeElectricID
   * @param p_gridConnectionID
   * @param p_parentNodeHeatID
   * @param p_BuildingThermalAsset
   * @param p_ownerID
   * @param p_batteryAsset
   * @param p_heatBuffer
   * @param p_gasBuffer
   * @param p_cookingTracker
   * @param p_insulationLabel
   * @param p_DHWAsset
   * @param p_longitude
   * @param p_latitude
   * @param p_floorSurfaceArea_m2
   * @param p_owner
   * @param p_roofSurfaceArea_m2
   * @param p_purposeBAG
   * @param p_address
   * @param p_parentNodeHeat
   * @param p_parentNodeElectric
   * @param v_isActive
   * @param p_energyLabel
   * @param p_airco
   * @param p_isChargingCentre
   * @return newly created embedded object
   */
  public GCPublicCharger add_PublicChargers( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco, boolean p_isChargingCentre ) {
    int index = PublicChargers.size();
    GCPublicCharger _result_xjal = instantiate_PublicChargers_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_parentNodeElectricID = p_parentNodeElectricID;
    _result_xjal.p_gridConnectionID = p_gridConnectionID;
    _result_xjal.p_parentNodeHeatID = p_parentNodeHeatID;
    _result_xjal.p_BuildingThermalAsset = p_BuildingThermalAsset;
    _result_xjal.p_ownerID = p_ownerID;
    _result_xjal.p_batteryAsset = p_batteryAsset;
    _result_xjal.p_heatBuffer = p_heatBuffer;
    _result_xjal.p_gasBuffer = p_gasBuffer;
    _result_xjal.p_cookingTracker = p_cookingTracker;
    _result_xjal.p_insulationLabel = p_insulationLabel;
    _result_xjal.p_DHWAsset = p_DHWAsset;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    _result_xjal.p_owner = p_owner;
    _result_xjal.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    _result_xjal.p_purposeBAG = p_purposeBAG;
    _result_xjal.p_address = p_address;
    _result_xjal.p_parentNodeHeat = p_parentNodeHeat;
    _result_xjal.p_parentNodeElectric = p_parentNodeElectric;
    _result_xjal.v_isActive = v_isActive;
    _result_xjal.p_energyLabel = p_energyLabel;
    _result_xjal.p_airco = p_airco;
    _result_xjal.p_isChargingCentre = p_isChargingCentre;
    // Finish embedded object creation
    PublicChargers.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection PublicChargers<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object PublicChargers - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to PublicChargers
   */
  public boolean remove_PublicChargers( GCPublicCharger object ) {
    if( ! PublicChargers._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in Neighborhoods
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public GCNeighborhood Neighborhoods(int index) {
    return Neighborhoods.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection Neighborhoods<br>
   * @return newly created embedded object
   */
  public GCNeighborhood add_Neighborhoods() {
    int index = Neighborhoods.size();
    GCNeighborhood _result_xjal = instantiate_Neighborhoods_xjal( index );
    Neighborhoods.callSetupParameters( _result_xjal, index );
    Neighborhoods.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection Neighborhoods<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>Neighborhoods.size()</code> method <strong>before</strong> this method is called
   * @param p_parentNodeElectricID
   * @param p_gridConnectionID
   * @param p_parentNodeHeatID
   * @param p_BuildingThermalAsset
   * @param p_ownerID
   * @param p_batteryAsset
   * @param p_heatBuffer
   * @param p_gasBuffer
   * @param p_cookingTracker
   * @param p_insulationLabel
   * @param p_DHWAsset
   * @param p_longitude
   * @param p_latitude
   * @param p_floorSurfaceArea_m2
   * @param p_owner
   * @param p_roofSurfaceArea_m2
   * @param p_purposeBAG
   * @param p_address
   * @param p_parentNodeHeat
   * @param p_parentNodeElectric
   * @param v_isActive
   * @param p_energyLabel
   * @param p_airco
   * @param p_nbCompaniesTotal
   * @param p_nbHouseholds
   * @param p_municipalityCode
   * @param p_nbServices
   * @param p_nbIndustry
   * @param p_nbAgriculture
   * @param p_ignoreGridCapacityBattery
   * @param p_chpAsset
   * @return newly created embedded object
   */
  public GCNeighborhood add_Neighborhoods( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco, int p_nbCompaniesTotal, int p_nbHouseholds, String p_municipalityCode, int p_nbServices, int p_nbIndustry, int p_nbAgriculture, boolean p_ignoreGridCapacityBattery, J_EAConversionGasCHP p_chpAsset ) {
    int index = Neighborhoods.size();
    GCNeighborhood _result_xjal = instantiate_Neighborhoods_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_parentNodeElectricID = p_parentNodeElectricID;
    _result_xjal.p_gridConnectionID = p_gridConnectionID;
    _result_xjal.p_parentNodeHeatID = p_parentNodeHeatID;
    _result_xjal.p_BuildingThermalAsset = p_BuildingThermalAsset;
    _result_xjal.p_ownerID = p_ownerID;
    _result_xjal.p_batteryAsset = p_batteryAsset;
    _result_xjal.p_heatBuffer = p_heatBuffer;
    _result_xjal.p_gasBuffer = p_gasBuffer;
    _result_xjal.p_cookingTracker = p_cookingTracker;
    _result_xjal.p_insulationLabel = p_insulationLabel;
    _result_xjal.p_DHWAsset = p_DHWAsset;
    _result_xjal.p_longitude = p_longitude;
    _result_xjal.p_latitude = p_latitude;
    _result_xjal.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    _result_xjal.p_owner = p_owner;
    _result_xjal.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    _result_xjal.p_purposeBAG = p_purposeBAG;
    _result_xjal.p_address = p_address;
    _result_xjal.p_parentNodeHeat = p_parentNodeHeat;
    _result_xjal.p_parentNodeElectric = p_parentNodeElectric;
    _result_xjal.v_isActive = v_isActive;
    _result_xjal.p_energyLabel = p_energyLabel;
    _result_xjal.p_airco = p_airco;
    _result_xjal.p_nbCompaniesTotal = p_nbCompaniesTotal;
    _result_xjal.p_nbHouseholds = p_nbHouseholds;
    _result_xjal.p_municipalityCode = p_municipalityCode;
    _result_xjal.p_nbServices = p_nbServices;
    _result_xjal.p_nbIndustry = p_nbIndustry;
    _result_xjal.p_nbAgriculture = p_nbAgriculture;
    _result_xjal.p_ignoreGridCapacityBattery = p_ignoreGridCapacityBattery;
    _result_xjal.p_chpAsset = p_chpAsset;
    // Finish embedded object creation
    Neighborhoods.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection Neighborhoods<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object Neighborhoods - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to Neighborhoods
   */
  public boolean remove_Neighborhoods( GCNeighborhood object ) {
    if( ! Neighborhoods._remove( object ) ) {
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
  protected GridNode instantiate_pop_gridNodes_xjal( final int index ) {
    GridNode _result_xjal = new GridNode( getEngine(), this, pop_gridNodes );
    
    pop_gridNodes._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_gridNodes_xjal( final GridNode self, final int index, TableInput _t ) {
    self.p_gridNodeID = self._p_gridNodeID_DefaultValue_xjal();
    self.p_parentNodeID = self._p_parentNodeID_DefaultValue_xjal();
    self.p_nodeType = self._p_nodeType_DefaultValue_xjal();
    self.p_energyCarrier = self._p_energyCarrier_DefaultValue_xjal();
    self.p_capacity_kW = self._p_capacity_kW_DefaultValue_xjal();
    self.p_transportBuffer = self._p_transportBuffer_DefaultValue_xjal();
    self.p_ownerGridOperator = self._p_ownerGridOperator_DefaultValue_xjal();
    self.p_gridNodeOwnerID = self._p_gridNodeOwnerID_DefaultValue_xjal();
    self.b_transportBufferValid = self._b_transportBufferValid_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.gisRegion = self._gisRegion_DefaultValue_xjal();
    self.p_description = self._p_description_DefaultValue_xjal();
    self.p_realCapacityAvailable = self._p_realCapacityAvailable_DefaultValue_xjal();
    self.p_serviceAreaGisRegion = self._p_serviceAreaGisRegion_DefaultValue_xjal();
    self.p_uniqueColor = self._p_uniqueColor_DefaultValue_xjal();
    self.p_localNodalPricingFactor_eurpkWh = self._p_localNodalPricingFactor_eurpkWh_DefaultValue_xjal();
    self.p_defaultLineColor = self._p_defaultLineColor_DefaultValue_xjal();
    self.p_defaultFillColor = self._p_defaultFillColor_DefaultValue_xjal();
    self.p_localNodalPricingTreshold_fr = self._p_localNodalPricingTreshold_fr_DefaultValue_xjal();
    self.p_originalCapacity_kW = self._p_originalCapacity_kW_DefaultValue_xjal();
    self.p_profileType = self._p_profileType_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_gridNodes_xjal( GridNode self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 
0 
;double _y_xjal = 
0 
;double _z_xjal = 
0 
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GridConnection instantiate_pop_gridConnections_xjal( final int index ) {
    GridConnection _result_xjal = new GridConnection( getEngine(), this, pop_gridConnections );
    
    pop_gridConnections._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_gridConnections_xjal( final GridConnection self, final int index, TableInput _t ) {
    self.p_parentNodeElectricID = self._p_parentNodeElectricID_DefaultValue_xjal();
    self.p_gridConnectionID = self._p_gridConnectionID_DefaultValue_xjal();
    self.p_parentNodeHeatID = self._p_parentNodeHeatID_DefaultValue_xjal();
    self.p_BuildingThermalAsset = self._p_BuildingThermalAsset_DefaultValue_xjal();
    self.p_ownerID = self._p_ownerID_DefaultValue_xjal();
    self.p_batteryAsset = self._p_batteryAsset_DefaultValue_xjal();
    self.p_heatBuffer = self._p_heatBuffer_DefaultValue_xjal();
    self.p_gasBuffer = self._p_gasBuffer_DefaultValue_xjal();
    self.p_cookingTracker = self._p_cookingTracker_DefaultValue_xjal();
    self.p_insulationLabel = self._p_insulationLabel_DefaultValue_xjal();
    self.p_DHWAsset = self._p_DHWAsset_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_floorSurfaceArea_m2 = self._p_floorSurfaceArea_m2_DefaultValue_xjal();
    self.p_owner = self._p_owner_DefaultValue_xjal();
    self.p_roofSurfaceArea_m2 = self._p_roofSurfaceArea_m2_DefaultValue_xjal();
    self.p_purposeBAG = self._p_purposeBAG_DefaultValue_xjal();
    self.p_address = self._p_address_DefaultValue_xjal();
    self.p_parentNodeHeat = self._p_parentNodeHeat_DefaultValue_xjal();
    self.p_parentNodeElectric = self._p_parentNodeElectric_DefaultValue_xjal();
    self.v_isActive = self._v_isActive_DefaultValue_xjal();
    self.p_energyLabel = self._p_energyLabel_DefaultValue_xjal();
    self.p_airco = self._p_airco_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_gridConnections_xjal( GridConnection self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected EnergyDataViewer instantiate_energyDataViewer_xjal() {
    EnergyDataViewer _result_xjal = new EnergyDataViewer( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_energyDataViewer_xjal( final EnergyDataViewer self, TableInput _t ) {
    self.p_areaType = self._p_areaType_DefaultValue_xjal();
    self.p_name = self._p_name_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_energyDataViewer_xjal( EnergyDataViewer self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected ConnectionOwner instantiate_pop_connectionOwners_xjal( final int index ) {
    ConnectionOwner _result_xjal = new ConnectionOwner( getEngine(), this, pop_connectionOwners );
    
    pop_connectionOwners._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_connectionOwners_xjal( final ConnectionOwner self, final int index, TableInput _t ) {
    self.p_coopParent = self._p_coopParent_DefaultValue_xjal();
    self.p_electricitySupplier = self._p_electricitySupplier_DefaultValue_xjal();
    self.p_gridOperator = self._p_gridOperator_DefaultValue_xjal();
    self.p_methaneSupplier = self._p_methaneSupplier_DefaultValue_xjal();
    self.p_hydrogenSupplier = self._p_hydrogenSupplier_DefaultValue_xjal();
    self.p_heatSupplier = self._p_heatSupplier_DefaultValue_xjal();
    self.p_connectionOwnerType = self._p_connectionOwnerType_DefaultValue_xjal();
    self.p_detailedCompany = self._p_detailedCompany_DefaultValue_xjal();
    self.p_energySupplierID = self._p_energySupplierID_DefaultValue_xjal();
    self.p_energyCoopID = self._p_energyCoopID_DefaultValue_xjal();
    self.b_dataSharingAgreed = self._b_dataSharingAgreed_DefaultValue_xjal();
    self.b_dataIsAccessible = self._b_dataIsAccessible_DefaultValue_xjal();
    self.p_actorID = self._p_actorID_DefaultValue_xjal();
    self.p_actorGroup = self._p_actorGroup_DefaultValue_xjal();
    self.p_actorSubgroup = self._p_actorSubgroup_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_connectionOwners_xjal( ConnectionOwner self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected EnergySupplier instantiate_pop_energySuppliers_xjal( final int index ) {
    EnergySupplier _result_xjal = new EnergySupplier( getEngine(), this, pop_energySuppliers );
    
    pop_energySuppliers._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_energySuppliers_xjal( final EnergySupplier self, final int index, TableInput _t ) {
    self.p_fixedElectricityPrice_eurpkWh = self._p_fixedElectricityPrice_eurpkWh_DefaultValue_xjal();
    self.p_fixedHeatPrice_eurpkWh = self._p_fixedHeatPrice_eurpkWh_DefaultValue_xjal();
    self.p_fixedMethanePrice_eurpkWh = self._p_fixedMethanePrice_eurpkWh_DefaultValue_xjal();
    self.p_fixedHydrogenPrice_eurpkWh = self._p_fixedHydrogenPrice_eurpkWh_DefaultValue_xjal();
    self.p_variableElectricityPriceOverNational_eurpkWh = self._p_variableElectricityPriceOverNational_eurpkWh_DefaultValue_xjal();
    self.p_fixedFeedinTariff_eurpkWh = self._p_fixedFeedinTariff_eurpkWh_DefaultValue_xjal();
    self.p_salderenActive = self._p_salderenActive_DefaultValue_xjal();
    self.p_actorID = self._p_actorID_DefaultValue_xjal();
    self.p_actorGroup = self._p_actorGroup_DefaultValue_xjal();
    self.p_actorSubgroup = self._p_actorSubgroup_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_energySuppliers_xjal( EnergySupplier self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected EnergyCoop instantiate_pop_energyCoops_xjal( final int index ) {
    EnergyCoop _result_xjal = new EnergyCoop( getEngine(), this, pop_energyCoops );
    
    pop_energyCoops._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_energyCoops_xjal( final EnergyCoop self, final int index, TableInput _t ) {
    self.p_actorContractList = self._p_actorContractList_DefaultValue_xjal();
    self.p_electricitySupplier = self._p_electricitySupplier_DefaultValue_xjal();
    self.p_CoopParent = self._p_CoopParent_DefaultValue_xjal();
    self.p_gridOperator = self._p_gridOperator_DefaultValue_xjal();
    self.p_methaneSupplier = self._p_methaneSupplier_DefaultValue_xjal();
    self.p_hydrogenSupplier = self._p_hydrogenSupplier_DefaultValue_xjal();
    self.p_heatSupplier = self._p_heatSupplier_DefaultValue_xjal();
    self.p_actorID = self._p_actorID_DefaultValue_xjal();
    self.p_actorGroup = self._p_actorGroup_DefaultValue_xjal();
    self.p_actorSubgroup = self._p_actorSubgroup_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_energyCoops_xjal( EnergyCoop self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GridOperator instantiate_pop_gridOperators_xjal( final int index ) {
    GridOperator _result_xjal = new GridOperator( getEngine(), this, pop_gridOperators );
    
    pop_gridOperators._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_gridOperators_xjal( final GridOperator self, final int index, TableInput _t ) {
    self.p_actorID = self._p_actorID_DefaultValue_xjal();
    self.p_actorGroup = self._p_actorGroup_DefaultValue_xjal();
    self.p_actorSubgroup = self._p_actorSubgroup_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_gridOperators_xjal( GridOperator self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected NationalEnergyMarket instantiate_nationalEnergyMarket_xjal() {
    NationalEnergyMarket _result_xjal = new NationalEnergyMarket( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_nationalEnergyMarket_xjal( final NationalEnergyMarket self, TableInput _t ) {
    self.p_actorID = self._p_actorID_DefaultValue_xjal();
    self.p_actorGroup = self._p_actorGroup_DefaultValue_xjal();
    self.p_actorSubgroup = self._p_actorSubgroup_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_nationalEnergyMarket_xjal( NationalEnergyMarket self, TableInput _t ) {
	double _initial_speed = 
0 
;
	self.setSpeed(_initial_speed, MPS);
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GCHouse instantiate_Houses_xjal( final int index ) {
    GCHouse _result_xjal = new GCHouse( getEngine(), this, Houses );
    
    Houses._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_Houses_xjal( final GCHouse self, final int index, TableInput _t ) {
    self.p_buildYear = self._p_buildYear_DefaultValue_xjal();
    self.p_eigenOprit = self._p_eigenOprit_DefaultValue_xjal();
    self.p_cookingMethod = self._p_cookingMethod_DefaultValue_xjal();
    self.p_PBLParameters = self._p_PBLParameters_DefaultValue_xjal();
    self.p_parentNodeElectricID = self._p_parentNodeElectricID_DefaultValue_xjal();
    self.p_gridConnectionID = self._p_gridConnectionID_DefaultValue_xjal();
    self.p_parentNodeHeatID = self._p_parentNodeHeatID_DefaultValue_xjal();
    self.p_BuildingThermalAsset = self._p_BuildingThermalAsset_DefaultValue_xjal();
    self.p_ownerID = self._p_ownerID_DefaultValue_xjal();
    self.p_batteryAsset = self._p_batteryAsset_DefaultValue_xjal();
    self.p_heatBuffer = self._p_heatBuffer_DefaultValue_xjal();
    self.p_gasBuffer = self._p_gasBuffer_DefaultValue_xjal();
    self.p_cookingTracker = self._p_cookingTracker_DefaultValue_xjal();
    self.p_insulationLabel = self._p_insulationLabel_DefaultValue_xjal();
    self.p_DHWAsset = self._p_DHWAsset_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_floorSurfaceArea_m2 = self._p_floorSurfaceArea_m2_DefaultValue_xjal();
    self.p_owner = self._p_owner_DefaultValue_xjal();
    self.p_roofSurfaceArea_m2 = self._p_roofSurfaceArea_m2_DefaultValue_xjal();
    self.p_purposeBAG = self._p_purposeBAG_DefaultValue_xjal();
    self.p_address = self._p_address_DefaultValue_xjal();
    self.p_parentNodeHeat = self._p_parentNodeHeat_DefaultValue_xjal();
    self.p_parentNodeElectric = self._p_parentNodeElectric_DefaultValue_xjal();
    self.v_isActive = self._v_isActive_DefaultValue_xjal();
    self.p_energyLabel = self._p_energyLabel_DefaultValue_xjal();
    self.p_airco = self._p_airco_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_Houses_xjal( GCHouse self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GCDistrictHeating instantiate_DistrictHeatingSystems_xjal( final int index ) {
    GCDistrictHeating _result_xjal = new GCDistrictHeating( getEngine(), this, DistrictHeatingSystems );
    
    DistrictHeatingSystems._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_DistrictHeatingSystems_xjal( final GCDistrictHeating self, final int index, TableInput _t ) {
    self.p_residualHeatLTSource = self._p_residualHeatLTSource_DefaultValue_xjal();
    self.p_DHheatStorage = self._p_DHheatStorage_DefaultValue_xjal();
    self.p_parentNodeElectricID = self._p_parentNodeElectricID_DefaultValue_xjal();
    self.p_gridConnectionID = self._p_gridConnectionID_DefaultValue_xjal();
    self.p_parentNodeHeatID = self._p_parentNodeHeatID_DefaultValue_xjal();
    self.p_BuildingThermalAsset = self._p_BuildingThermalAsset_DefaultValue_xjal();
    self.p_ownerID = self._p_ownerID_DefaultValue_xjal();
    self.p_batteryAsset = self._p_batteryAsset_DefaultValue_xjal();
    self.p_heatBuffer = self._p_heatBuffer_DefaultValue_xjal();
    self.p_gasBuffer = self._p_gasBuffer_DefaultValue_xjal();
    self.p_cookingTracker = self._p_cookingTracker_DefaultValue_xjal();
    self.p_insulationLabel = self._p_insulationLabel_DefaultValue_xjal();
    self.p_DHWAsset = self._p_DHWAsset_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_floorSurfaceArea_m2 = self._p_floorSurfaceArea_m2_DefaultValue_xjal();
    self.p_owner = self._p_owner_DefaultValue_xjal();
    self.p_roofSurfaceArea_m2 = self._p_roofSurfaceArea_m2_DefaultValue_xjal();
    self.p_purposeBAG = self._p_purposeBAG_DefaultValue_xjal();
    self.p_address = self._p_address_DefaultValue_xjal();
    self.p_parentNodeHeat = self._p_parentNodeHeat_DefaultValue_xjal();
    self.p_parentNodeElectric = self._p_parentNodeElectric_DefaultValue_xjal();
    self.v_isActive = self._v_isActive_DefaultValue_xjal();
    self.p_energyLabel = self._p_energyLabel_DefaultValue_xjal();
    self.p_airco = self._p_airco_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_DistrictHeatingSystems_xjal( GCDistrictHeating self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GCEnergyProduction instantiate_EnergyProductionSites_xjal( final int index ) {
    GCEnergyProduction _result_xjal = new GCEnergyProduction( getEngine(), this, EnergyProductionSites );
    
    EnergyProductionSites._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_EnergyProductionSites_xjal( final GCEnergyProduction self, final int index, TableInput _t ) {
    self.p_isSliderGC = self._p_isSliderGC_DefaultValue_xjal();
    self.p_parentNodeElectricID = self._p_parentNodeElectricID_DefaultValue_xjal();
    self.p_gridConnectionID = self._p_gridConnectionID_DefaultValue_xjal();
    self.p_parentNodeHeatID = self._p_parentNodeHeatID_DefaultValue_xjal();
    self.p_BuildingThermalAsset = self._p_BuildingThermalAsset_DefaultValue_xjal();
    self.p_ownerID = self._p_ownerID_DefaultValue_xjal();
    self.p_batteryAsset = self._p_batteryAsset_DefaultValue_xjal();
    self.p_heatBuffer = self._p_heatBuffer_DefaultValue_xjal();
    self.p_gasBuffer = self._p_gasBuffer_DefaultValue_xjal();
    self.p_cookingTracker = self._p_cookingTracker_DefaultValue_xjal();
    self.p_insulationLabel = self._p_insulationLabel_DefaultValue_xjal();
    self.p_DHWAsset = self._p_DHWAsset_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_floorSurfaceArea_m2 = self._p_floorSurfaceArea_m2_DefaultValue_xjal();
    self.p_owner = self._p_owner_DefaultValue_xjal();
    self.p_roofSurfaceArea_m2 = self._p_roofSurfaceArea_m2_DefaultValue_xjal();
    self.p_purposeBAG = self._p_purposeBAG_DefaultValue_xjal();
    self.p_address = self._p_address_DefaultValue_xjal();
    self.p_parentNodeHeat = self._p_parentNodeHeat_DefaultValue_xjal();
    self.p_parentNodeElectric = self._p_parentNodeElectric_DefaultValue_xjal();
    self.v_isActive = self._v_isActive_DefaultValue_xjal();
    self.p_energyLabel = self._p_energyLabel_DefaultValue_xjal();
    self.p_airco = self._p_airco_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_EnergyProductionSites_xjal( GCEnergyProduction self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GCEnergyConversion instantiate_EnergyConversionSites_xjal( final int index ) {
    GCEnergyConversion _result_xjal = new GCEnergyConversion( getEngine(), this, EnergyConversionSites );
    
    EnergyConversionSites._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_EnergyConversionSites_xjal( final GCEnergyConversion self, final int index, TableInput _t ) {
    self.p_parentNodeElectricID = self._p_parentNodeElectricID_DefaultValue_xjal();
    self.p_gridConnectionID = self._p_gridConnectionID_DefaultValue_xjal();
    self.p_parentNodeHeatID = self._p_parentNodeHeatID_DefaultValue_xjal();
    self.p_BuildingThermalAsset = self._p_BuildingThermalAsset_DefaultValue_xjal();
    self.p_ownerID = self._p_ownerID_DefaultValue_xjal();
    self.p_batteryAsset = self._p_batteryAsset_DefaultValue_xjal();
    self.p_heatBuffer = self._p_heatBuffer_DefaultValue_xjal();
    self.p_gasBuffer = self._p_gasBuffer_DefaultValue_xjal();
    self.p_cookingTracker = self._p_cookingTracker_DefaultValue_xjal();
    self.p_insulationLabel = self._p_insulationLabel_DefaultValue_xjal();
    self.p_DHWAsset = self._p_DHWAsset_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_floorSurfaceArea_m2 = self._p_floorSurfaceArea_m2_DefaultValue_xjal();
    self.p_owner = self._p_owner_DefaultValue_xjal();
    self.p_roofSurfaceArea_m2 = self._p_roofSurfaceArea_m2_DefaultValue_xjal();
    self.p_purposeBAG = self._p_purposeBAG_DefaultValue_xjal();
    self.p_address = self._p_address_DefaultValue_xjal();
    self.p_parentNodeHeat = self._p_parentNodeHeat_DefaultValue_xjal();
    self.p_parentNodeElectric = self._p_parentNodeElectric_DefaultValue_xjal();
    self.v_isActive = self._v_isActive_DefaultValue_xjal();
    self.p_energyLabel = self._p_energyLabel_DefaultValue_xjal();
    self.p_airco = self._p_airco_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_EnergyConversionSites_xjal( GCEnergyConversion self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GCUtility instantiate_UtilityConnections_xjal( final int index ) {
    GCUtility _result_xjal = new GCUtility( getEngine(), this, UtilityConnections );
    
    UtilityConnections._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_UtilityConnections_xjal( final GCUtility self, final int index, TableInput _t ) {
    self.p_parentNodeElectricID = self._p_parentNodeElectricID_DefaultValue_xjal();
    self.p_gridConnectionID = self._p_gridConnectionID_DefaultValue_xjal();
    self.p_parentNodeHeatID = self._p_parentNodeHeatID_DefaultValue_xjal();
    self.p_BuildingThermalAsset = self._p_BuildingThermalAsset_DefaultValue_xjal();
    self.p_ownerID = self._p_ownerID_DefaultValue_xjal();
    self.p_batteryAsset = self._p_batteryAsset_DefaultValue_xjal();
    self.p_heatBuffer = self._p_heatBuffer_DefaultValue_xjal();
    self.p_gasBuffer = self._p_gasBuffer_DefaultValue_xjal();
    self.p_cookingTracker = self._p_cookingTracker_DefaultValue_xjal();
    self.p_insulationLabel = self._p_insulationLabel_DefaultValue_xjal();
    self.p_DHWAsset = self._p_DHWAsset_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_floorSurfaceArea_m2 = self._p_floorSurfaceArea_m2_DefaultValue_xjal();
    self.p_owner = self._p_owner_DefaultValue_xjal();
    self.p_roofSurfaceArea_m2 = self._p_roofSurfaceArea_m2_DefaultValue_xjal();
    self.p_purposeBAG = self._p_purposeBAG_DefaultValue_xjal();
    self.p_address = self._p_address_DefaultValue_xjal();
    self.p_parentNodeHeat = self._p_parentNodeHeat_DefaultValue_xjal();
    self.p_parentNodeElectric = self._p_parentNodeElectric_DefaultValue_xjal();
    self.v_isActive = self._v_isActive_DefaultValue_xjal();
    self.p_energyLabel = self._p_energyLabel_DefaultValue_xjal();
    self.p_airco = self._p_airco_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_UtilityConnections_xjal( GCUtility self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GCGridBattery instantiate_GridBatteries_xjal( final int index ) {
    GCGridBattery _result_xjal = new GCGridBattery( getEngine(), this, GridBatteries );
    
    GridBatteries._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_GridBatteries_xjal( final GCGridBattery self, final int index, TableInput _t ) {
    self.p_isSliderGC = self._p_isSliderGC_DefaultValue_xjal();
    self.p_parentNodeElectricID = self._p_parentNodeElectricID_DefaultValue_xjal();
    self.p_gridConnectionID = self._p_gridConnectionID_DefaultValue_xjal();
    self.p_parentNodeHeatID = self._p_parentNodeHeatID_DefaultValue_xjal();
    self.p_BuildingThermalAsset = self._p_BuildingThermalAsset_DefaultValue_xjal();
    self.p_ownerID = self._p_ownerID_DefaultValue_xjal();
    self.p_batteryAsset = self._p_batteryAsset_DefaultValue_xjal();
    self.p_heatBuffer = self._p_heatBuffer_DefaultValue_xjal();
    self.p_gasBuffer = self._p_gasBuffer_DefaultValue_xjal();
    self.p_cookingTracker = self._p_cookingTracker_DefaultValue_xjal();
    self.p_insulationLabel = self._p_insulationLabel_DefaultValue_xjal();
    self.p_DHWAsset = self._p_DHWAsset_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_floorSurfaceArea_m2 = self._p_floorSurfaceArea_m2_DefaultValue_xjal();
    self.p_owner = self._p_owner_DefaultValue_xjal();
    self.p_roofSurfaceArea_m2 = self._p_roofSurfaceArea_m2_DefaultValue_xjal();
    self.p_purposeBAG = self._p_purposeBAG_DefaultValue_xjal();
    self.p_address = self._p_address_DefaultValue_xjal();
    self.p_parentNodeHeat = self._p_parentNodeHeat_DefaultValue_xjal();
    self.p_parentNodeElectric = self._p_parentNodeElectric_DefaultValue_xjal();
    self.v_isActive = self._v_isActive_DefaultValue_xjal();
    self.p_energyLabel = self._p_energyLabel_DefaultValue_xjal();
    self.p_airco = self._p_airco_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_GridBatteries_xjal( GCGridBattery self, final int index, TableInput _t ) {

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GIS_Building instantiate_pop_GIS_Buildings_xjal( final int index ) {
    GIS_Building _result_xjal = new GIS_Building( getEngine(), this, pop_GIS_Buildings );
    
    pop_GIS_Buildings._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_GIS_Buildings_xjal( final GIS_Building self, final int index, TableInput _t ) {
    self.p_status = self._p_status_DefaultValue_xjal();
    self.p_useType = self._p_useType_DefaultValue_xjal();
    self.p_buildingYear = self._p_buildingYear_DefaultValue_xjal();
    self.p_floorSurfaceArea_m2 = self._p_floorSurfaceArea_m2_DefaultValue_xjal();
    self.p_floors = self._p_floors_DefaultValue_xjal();
    self.p_roofSurfaceArea_m2 = self._p_roofSurfaceArea_m2_DefaultValue_xjal();
    self.p_pandNaam = self._p_pandNaam_DefaultValue_xjal();
    self.gisRegion = self._gisRegion_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_GISObjectType = self._p_GISObjectType_DefaultValue_xjal();
    self.p_id = self._p_id_DefaultValue_xjal();
    self.p_defaultLineColor = self._p_defaultLineColor_DefaultValue_xjal();
    self.p_defaultFillColor = self._p_defaultFillColor_DefaultValue_xjal();
    self.p_defaultLineWidth = self._p_defaultLineWidth_DefaultValue_xjal();
    self.p_defaultLineStyle = self._p_defaultLineStyle_DefaultValue_xjal();
    self.p_annotation = self._p_annotation_DefaultValue_xjal();
    self.p_defaultFillColorString = self._p_defaultFillColorString_DefaultValue_xjal();
    self.p_defaultLineColorString = self._p_defaultLineColorString_DefaultValue_xjal();
    self.p_defaultLineStyleString = self._p_defaultLineStyleString_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_GIS_Buildings_xjal( GIS_Building self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 
0 
;double _y_xjal = 
0 
;double _z_xjal = 
0 
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GIS_Object instantiate_pop_GIS_Objects_xjal( final int index ) {
    GIS_Object _result_xjal = new GIS_Object( getEngine(), this, pop_GIS_Objects );
    
    pop_GIS_Objects._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_GIS_Objects_xjal( final GIS_Object self, final int index, TableInput _t ) {
    self.gisRegion = self._gisRegion_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_GISObjectType = self._p_GISObjectType_DefaultValue_xjal();
    self.p_id = self._p_id_DefaultValue_xjal();
    self.p_defaultLineColor = self._p_defaultLineColor_DefaultValue_xjal();
    self.p_defaultFillColor = self._p_defaultFillColor_DefaultValue_xjal();
    self.p_defaultLineWidth = self._p_defaultLineWidth_DefaultValue_xjal();
    self.p_defaultLineStyle = self._p_defaultLineStyle_DefaultValue_xjal();
    self.p_annotation = self._p_annotation_DefaultValue_xjal();
    self.p_defaultFillColorString = self._p_defaultFillColorString_DefaultValue_xjal();
    self.p_defaultLineColorString = self._p_defaultLineColorString_DefaultValue_xjal();
    self.p_defaultLineStyleString = self._p_defaultLineStyleString_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_GIS_Objects_xjal( GIS_Object self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 
0 
;double _y_xjal = 
0 
;double _z_xjal = 
0 
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GIS_Parcel instantiate_pop_GIS_Parcels_xjal( final int index ) {
    GIS_Parcel _result_xjal = new GIS_Parcel( getEngine(), this, pop_GIS_Parcels );
    
    pop_GIS_Parcels._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_GIS_Parcels_xjal( final GIS_Parcel self, final int index, TableInput _t ) {
    self.p_address = self._p_address_DefaultValue_xjal();
    self.gisRegion = self._gisRegion_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_GISObjectType = self._p_GISObjectType_DefaultValue_xjal();
    self.p_id = self._p_id_DefaultValue_xjal();
    self.p_defaultLineColor = self._p_defaultLineColor_DefaultValue_xjal();
    self.p_defaultFillColor = self._p_defaultFillColor_DefaultValue_xjal();
    self.p_defaultLineWidth = self._p_defaultLineWidth_DefaultValue_xjal();
    self.p_defaultLineStyle = self._p_defaultLineStyle_DefaultValue_xjal();
    self.p_annotation = self._p_annotation_DefaultValue_xjal();
    self.p_defaultFillColorString = self._p_defaultFillColorString_DefaultValue_xjal();
    self.p_defaultLineColorString = self._p_defaultLineColorString_DefaultValue_xjal();
    self.p_defaultLineStyleString = self._p_defaultLineStyleString_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_GIS_Parcels_xjal( GIS_Parcel self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 
0 
;double _y_xjal = 
0 
;double _z_xjal = 
0 
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GCPublicCharger instantiate_PublicChargers_xjal( final int index ) {
    GCPublicCharger _result_xjal = new GCPublicCharger( getEngine(), this, PublicChargers );
    
    PublicChargers._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_PublicChargers_xjal( final GCPublicCharger self, final int index, TableInput _t ) {
    self.p_isChargingCentre = self._p_isChargingCentre_DefaultValue_xjal();
    self.p_parentNodeElectricID = self._p_parentNodeElectricID_DefaultValue_xjal();
    self.p_gridConnectionID = self._p_gridConnectionID_DefaultValue_xjal();
    self.p_parentNodeHeatID = self._p_parentNodeHeatID_DefaultValue_xjal();
    self.p_BuildingThermalAsset = self._p_BuildingThermalAsset_DefaultValue_xjal();
    self.p_ownerID = self._p_ownerID_DefaultValue_xjal();
    self.p_batteryAsset = self._p_batteryAsset_DefaultValue_xjal();
    self.p_heatBuffer = self._p_heatBuffer_DefaultValue_xjal();
    self.p_gasBuffer = self._p_gasBuffer_DefaultValue_xjal();
    self.p_cookingTracker = self._p_cookingTracker_DefaultValue_xjal();
    self.p_insulationLabel = self._p_insulationLabel_DefaultValue_xjal();
    self.p_DHWAsset = self._p_DHWAsset_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_floorSurfaceArea_m2 = self._p_floorSurfaceArea_m2_DefaultValue_xjal();
    self.p_owner = self._p_owner_DefaultValue_xjal();
    self.p_roofSurfaceArea_m2 = self._p_roofSurfaceArea_m2_DefaultValue_xjal();
    self.p_purposeBAG = self._p_purposeBAG_DefaultValue_xjal();
    self.p_address = self._p_address_DefaultValue_xjal();
    self.p_parentNodeHeat = self._p_parentNodeHeat_DefaultValue_xjal();
    self.p_parentNodeElectric = self._p_parentNodeElectric_DefaultValue_xjal();
    self.v_isActive = self._v_isActive_DefaultValue_xjal();
    self.p_energyLabel = self._p_energyLabel_DefaultValue_xjal();
    self.p_airco = self._p_airco_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_PublicChargers_xjal( GCPublicCharger self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 
0 
;double _y_xjal = 
0 
;double _z_xjal = 
0 
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected GCNeighborhood instantiate_Neighborhoods_xjal( final int index ) {
    GCNeighborhood _result_xjal = new GCNeighborhood( getEngine(), this, Neighborhoods );
    
    Neighborhoods._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_Neighborhoods_xjal( final GCNeighborhood self, final int index, TableInput _t ) {
    self.p_nbCompaniesTotal = self._p_nbCompaniesTotal_DefaultValue_xjal();
    self.p_nbHouseholds = self._p_nbHouseholds_DefaultValue_xjal();
    self.p_municipalityCode = self._p_municipalityCode_DefaultValue_xjal();
    self.p_nbServices = self._p_nbServices_DefaultValue_xjal();
    self.p_nbIndustry = self._p_nbIndustry_DefaultValue_xjal();
    self.p_nbAgriculture = self._p_nbAgriculture_DefaultValue_xjal();
    self.p_ignoreGridCapacityBattery = self._p_ignoreGridCapacityBattery_DefaultValue_xjal();
    self.p_chpAsset = self._p_chpAsset_DefaultValue_xjal();
    self.p_parentNodeElectricID = self._p_parentNodeElectricID_DefaultValue_xjal();
    self.p_gridConnectionID = self._p_gridConnectionID_DefaultValue_xjal();
    self.p_parentNodeHeatID = self._p_parentNodeHeatID_DefaultValue_xjal();
    self.p_BuildingThermalAsset = self._p_BuildingThermalAsset_DefaultValue_xjal();
    self.p_ownerID = self._p_ownerID_DefaultValue_xjal();
    self.p_batteryAsset = self._p_batteryAsset_DefaultValue_xjal();
    self.p_heatBuffer = self._p_heatBuffer_DefaultValue_xjal();
    self.p_gasBuffer = self._p_gasBuffer_DefaultValue_xjal();
    self.p_cookingTracker = self._p_cookingTracker_DefaultValue_xjal();
    self.p_insulationLabel = self._p_insulationLabel_DefaultValue_xjal();
    self.p_DHWAsset = self._p_DHWAsset_DefaultValue_xjal();
    self.p_longitude = self._p_longitude_DefaultValue_xjal();
    self.p_latitude = self._p_latitude_DefaultValue_xjal();
    self.p_floorSurfaceArea_m2 = self._p_floorSurfaceArea_m2_DefaultValue_xjal();
    self.p_owner = self._p_owner_DefaultValue_xjal();
    self.p_roofSurfaceArea_m2 = self._p_roofSurfaceArea_m2_DefaultValue_xjal();
    self.p_purposeBAG = self._p_purposeBAG_DefaultValue_xjal();
    self.p_address = self._p_address_DefaultValue_xjal();
    self.p_parentNodeHeat = self._p_parentNodeHeat_DefaultValue_xjal();
    self.p_parentNodeElectric = self._p_parentNodeElectric_DefaultValue_xjal();
    self.v_isActive = self._v_isActive_DefaultValue_xjal();
    self.p_energyLabel = self._p_energyLabel_DefaultValue_xjal();
    self.p_airco = self._p_airco_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_Neighborhoods_xjal( GCNeighborhood self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 
0 
;double _y_xjal = 
0 
;double _z_xjal = 
0 
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }

  // Functions

  void f_updatePricesForNextTimestep(  ) { 

// Update the dayaheadprice
nationalEnergyMarket.f_updateEnergyPrice(p_timeParameters, p_timeVariables);

//
for (EnergySupplier e : pop_energySuppliers) {
	e.f_updateEnergyPrice();
}
for (GridOperator g : pop_gridOperators) {
	if( g.p_hasCongestionPricing ){
		g.f_updateCongestionTariff();
	}
}
for (EnergyCoop e : pop_energyCoops) {
	//e.f_updateEnergyPrice();
	//e.f_updateOtherIncentives();
	//e.f_setPriceBandsExperiment();
	e.f_updateIncentives();
}

for (GridNode GN : c_gridNodeExecutionListReverse) {
	GN.f_propagateNodalPricing();
}


/*if (p_parallelize) {
	c_connectionOwners.parallelStream().forEach(co -> co.f_updateIncentives());	
} else {*/
	for (ConnectionOwner c : pop_connectionOwners) {
		c.f_updateIncentives();
	}
//} 
  }

  void f_updateTimeseries(  ) { 

c_profiles.forEach(p -> p.updateValue(p_timeVariables.getT_h())); // 

//if (b_enableDLR) {
	//v_currentDLRfactor_fr = 1 + max(-0.1,pp_windProduction_fr.getCurrentValue() * 0.025*(30-pp_ambientTemperature_degC.getCurrentValue()) + 0.5 - pp_PVProduction35DegSouth_fr.getCurrentValue());
	//v_currentDLRfactor_fr = 1 + uniform(-0.1, 1.0);
	//v_minDLRfactor_fr = min (v_minDLRfactor_fr, v_currentDLRfactor_fr);
	//v_maxDLRfactor_fr = max (v_maxDLRfactor_fr, v_currentDLRfactor_fr);
	//acc_totalDLRfactor_f.addStep( v_currentDLRfactor_fr);
	/*if (v_currentDLRfactor_fr < 0.5) {
		traceln("v_currentDLRfactor_fr is invalid! %s", v_currentDLRfactor_fr);
		pauseSimulation();
	}*/
//}
//traceln("Current DLR factor: %s, ", v_currentDLRfactor_fr);
//traceln("Time hour " + time(HOUR) + ", t_h " + t_h + ", fleet demand " + v_currentLogisticsFleetEDemand_fr);

//Update ambient dependent assets
f_updateAmbientDependentAssets();

// Update forecasts,  the relevant profile pointers are already updated above
c_forecasts.forEach(f -> f.updateForecast(p_timeVariables.getT_h()));

// The ElectricityYieldForecast assumes solar and wind forecasts have the same forecast time
if ( v_liveAssetsMetaData.totalInstalledPVPower_kW + v_liveAssetsMetaData.totalInstalledWindPower_kW > 0 ) {
	v_electricityYieldForecast_fr = (pf_PVProduction35DegSouth_fr.getForecast() * v_liveAssetsMetaData.totalInstalledPVPower_kW + pf_windProduction_fr.getForecast() * v_liveAssetsMetaData.totalInstalledWindPower_kW) / (v_liveAssetsMetaData.totalInstalledPVPower_kW + v_liveAssetsMetaData.totalInstalledWindPower_kW);
}

for (GridNode GN : c_gridNodeExecutionList) {
	GN.f_updateForecasts();
}
 
  }

  void f_calculateGridnodeFlows(  ) { 

v_currentElectricityImport_kW = 0;
v_currentElectricityExport_kW = 0;

for(GridNode n : c_gridNodeExecutionList) {
	n.f_calculateEnergyBalance(p_timeVariables, p_timeParameters, v_isRapidRun);
}

for(GridNode n : c_gridNodesTopLevel) {
	if (n.p_energyCarrier == OL_EnergyCarriers.ELECTRICITY) {
		v_currentElectricityImport_kW += max(0, n.v_currentLoad_kW );
		v_currentElectricityExport_kW += max(0, -n.v_currentLoad_kW );
	}
}
 
  }

  void f_calculateActorFlows(  ) { 

/*
if (b_parallelizeConnectionOwners) {
	c_connectionOwners.parallelStream().forEach(co -> co.f_updateFinances());
} else {
	for (ConnectionOwner c : pop_connectionOwners) {
		c.f_updateFinances();
	}
}
*/

for (EnergyCoop h : pop_energyCoops) {
	h.f_calculateEnergyBalance(p_timeVariables, v_isRapidRun);
}
/*for (EnergySupplier e : pop_energySuppliers) {
	e.f_updateFinances();
}*/
 
  }

  public void f_sumBatteryUse(  ) { 

v_totalBatteryDischargeAmount_MWh = 0;
v_totalBatteryChargeAmount_MWh = 0;
v_totalBatteryEnergyUsed_MWh = 0;

for(J_EA ea : c_energyAssets) { // Single loop of all assets without using c_EVs and c_storageAssets
	if( ea instanceof J_EAStorageElectric storageElectric) {
		v_totalBatteryDischargeAmount_MWh += storageElectric.getTotalDischargeAmount_kWh() / 1000;
		v_totalBatteryChargeAmount_MWh += storageElectric.getTotalChargeAmount_kWh() / 1000;
		v_totalBatteryEnergyUsed_MWh += storageElectric.getEnergyUsed_kWh() / 1000;
	}
	
	if( ea instanceof J_EAEV ev) {
		v_totalBatteryDischargeAmount_MWh += ev.getTotalDischargeAmount_kWh() / 1000;
		v_totalBatteryChargeAmount_MWh += ev.getTotalChargeAmount_kWh() / 1000;
		v_totalBatteryEnergyUsed_MWh += ev.getEnergyUsed_kWh() / 1000;
	}
	
	if( ea instanceof J_EAChargingSession cs) {
		v_totalBatteryDischargeAmount_MWh += cs.getTotalDischargeAmount_kWh() / 1000;
		v_totalBatteryChargeAmount_MWh += cs.getTotalChargeAmount_kWh() / 1000;
		v_totalBatteryEnergyUsed_MWh += cs.getEnergyUsed_kWh() / 1000;
	}
}

//Calculate delta stored energy in battery for energy balance check
v_batteryStoredEnergyDeltaSinceStart_MWh = v_totalBatteryChargeAmount_MWh - v_totalBatteryDischargeAmount_MWh - v_totalBatteryEnergyUsed_MWh;
if (v_batteryStoredEnergyDeltaSinceStart_MWh == Double.NaN) {
	v_batteryStoredEnergyDeltaSinceStart_MWh = 0;
}
traceln("Electricity delta in batteries (including EVs): "+ v_batteryStoredEnergyDeltaSinceStart_MWh + " MWh"); 
  }

  void f_calculateGridConnectionFlows(  ) { 

fm_currentProductionFlows_kW.clear();
fm_currentConsumptionFlows_kW.clear();
fm_currentBalanceFlows_kW.clear();
fm_heatFromEnergyCarrier_kW.clear();
fm_consumptionForHeating_kW.clear();
fm_currentAssetFlows_kW.clear();

v_currentFinalEnergyConsumption_kW = 0;
v_currentPrimaryEnergyProduction_kW = 0;
v_currentEnergyCurtailed_kW = 0;
v_currentPrimaryEnergyProductionHeatpumps_kW = 0;
v_batteryStoredEnergy_kWh = 0;

if (b_parallelizeGridConnections) {
	c_gridConnections.parallelStream().forEach(gc -> gc.f_calculateEnergyBalance(p_timeVariables, v_isRapidRun));
} 
else {
	for(GridConnection gc : c_gridConnections) {
		gc.f_calculateEnergyBalance(p_timeVariables, v_isRapidRun);
	}
}

//OLD LOCATION OF AGGREGATOR CALL, NECESSARY IF MANAGEMENT IS WITHOUT TIME STEP DELAY

for(GridConnection gc : c_gridConnections) { // Can't do this in parallel due to different threads writing to the same values!
	
	fm_currentBalanceFlows_kW.addFlows(gc.fm_currentBalanceFlows_kW);
	fm_currentProductionFlows_kW.addFlows(gc.fm_currentProductionFlows_kW);
	fm_currentConsumptionFlows_kW.addFlows(gc.fm_currentConsumptionFlows_kW);
	fm_heatFromEnergyCarrier_kW.addFlows(gc.fm_heatFromEnergyCarrier_kW);
	fm_consumptionForHeating_kW.addFlows(gc.fm_consumptionForHeating_kW);
	fm_currentAssetFlows_kW.addFlows(gc.fm_currentAssetFlows_kW);
	v_currentFinalEnergyConsumption_kW += gc.v_currentFinalEnergyConsumption_kW;
	v_currentPrimaryEnergyProduction_kW += gc.v_currentPrimaryEnergyProduction_kW;
	v_currentEnergyCurtailed_kW += gc.v_currentEnergyCurtailed_kW;
	v_batteryStoredEnergy_kWh += gc.v_batteryStoredEnergy_kWh;
	v_currentPrimaryEnergyProductionHeatpumps_kW += gc.v_currentPrimaryEnergyProductionHeatpumps_kW;
}

for (GridConnection gc : c_subGridConnections) {
	gc.f_calculateEnergyBalance(p_timeVariables, v_isRapidRun);
}

v_currentEnergyImport_kW = 0.0;
v_currentEnergyExport_kW = 0.0;
for (OL_EnergyCarriers EC : v_liveData.activeEnergyCarriers) {
	double netFlow_kW = fm_currentBalanceFlows_kW.get(EC);
	v_currentEnergyImport_kW += max( 0, netFlow_kW );
	v_currentEnergyExport_kW += max( 0, -netFlow_kW );
}

//Call aggregator functions (ONLY WORK WITH TIME STEP DELAY FOR NOW) (LOCATION OF THIS CALL IS NOT DETERMINED YET, FOR NOW HERE)
f_runAggregators();
 
  }

  private void f_initializeForecasts(  ) { 

pf_ambientTemperature_degC = new J_ProfileForecaster(null, pp_ambientTemperature_degC, p_tempForecastTime_h, p_timeVariables.getT_h(), p_timeParameters.getTimeStep_h());
c_forecasts.add(pf_ambientTemperature_degC);

pf_PVProduction35DegSouth_fr = new J_ProfileForecaster(null, pp_PVProduction35DegSouth_fr, p_pvForecastTime_h, p_timeVariables.getT_h(), p_timeParameters.getTimeStep_h());
c_forecasts.add(pf_PVProduction35DegSouth_fr);

pf_PVProduction15DegEastWest_fr = new J_ProfileForecaster(null, pp_PVProduction15DegEastWest_fr, p_pvForecastTime_h, p_timeVariables.getT_h(), p_timeParameters.getTimeStep_h());
c_forecasts.add(pf_PVProduction15DegEastWest_fr);

pf_windProduction_fr = new J_ProfileForecaster(null, pp_windProduction_fr, p_windForecastTime_h, p_timeVariables.getT_h(), p_timeParameters.getTimeStep_h());
c_forecasts.add(pf_windProduction_fr);

pf_dayAheadElectricityPricing_eurpMWh = new J_ProfileForecaster(null, pp_dayAheadElectricityPricing_eurpMWh, p_epexForecastTime_h, p_timeVariables.getT_h(), p_timeParameters.getTimeStep_h());
c_forecasts.add(pf_dayAheadElectricityPricing_eurpMWh);

pf_CO2EmissionFactorElectricityImport_kgpkWh = new J_ProfileForecaster(null, pp_CO2EmissionFactorElectricityImport_kgpkWh, p_CO2EmissionFactorForecastTime_h, p_timeVariables.getT_h(), p_timeParameters.getTimeStep_h());
c_forecasts.add(pf_CO2EmissionFactorElectricityImport_kgpkWh);
 
  }

  public void f_runRapidSimulation(  ) { 

pauseSimulation();

traceln(" ");
traceln("*** Running headless simulation *** ");
traceln(" ");

double startTime1 = System.currentTimeMillis();

int v_timeStepsElapsed_live = v_timeStepsElapsed;
v_timeStepsElapsed=0;
p_timeVariables.updateTimeVariables(v_timeStepsElapsed, p_timeParameters);

//// Store and reset model states
for (GridConnection GC : c_gridConnections) {
	
	if (GC.v_rapidRunData != null) {
		if (b_storePreviousRapidRunData) {
			GC.v_previousRunData = GC.v_rapidRunData;
		}
	} 
	// TODO: Fix Boolean store assets here?
	GC.v_rapidRunData = new J_RapidRunData(p_timeParameters, true);
	GC.v_rapidRunData.assetsMetaData = GC.v_liveAssetsMetaData.getClone();
	GC.v_rapidRunData.assetsMetaData.saveActiveAssetAndCapacities(new ArrayList<>(List.of(GC)));
	GC.v_rapidRunData.connectionMetaData = GC.v_liveConnectionMetaData.getClone();
	GC.v_rapidRunData.initializeAccumulators(GC.v_liveData.activeEnergyCarriers, GC.v_liveData.activeConsumptionEnergyCarriers, GC.v_liveData.activeProductionEnergyCarriers, GC.v_liveAssetsMetaData.activeAssetFlows); //f_initializeAccumulators();
		
	// f_resetStates resets the accumulators in rapidrundata, so must be after copying the previous run data		
	GC.f_resetStates(p_timeVariables); 
	
}
for (GridConnection GC : c_subGridConnections) {
	GC.f_resetStates(p_timeVariables);
}

for (GridNode GN : pop_gridNodes) {
	GN.f_resetStates(p_timeParameters);
}

for (ConnectionOwner CO : pop_connectionOwners) {
	CO.f_resetStates();
}

for (EnergyCoop EC : pop_energyCoops) {
	if (EC.v_rapidRunData != null) {
		if (b_storePreviousRapidRunData) {
			EC.v_previousRunData = EC.v_rapidRunData;
		}
	} 
	EC.v_rapidRunData = new J_RapidRunData(p_timeParameters, true);
	EC.v_rapidRunData.assetsMetaData = EC.v_liveAssetsMetaData.getClone();
	EC.v_rapidRunData.assetsMetaData.saveActiveAssetAndCapacities(EC.f_getAllChildMemberGridConnections());
	EC.v_rapidRunData.connectionMetaData = EC.v_liveConnectionMetaData.getClone();
	EC.v_rapidRunData.setStoreTotalAssetFlows(true);
	EC.v_rapidRunData.initializeAccumulators(EC.v_liveData.activeEnergyCarriers, EC.v_liveData.activeConsumptionEnergyCarriers, EC.v_liveData.activeProductionEnergyCarriers, EC.v_liveAssetsMetaData.activeAssetFlows);
	EC.f_resetStates();

}

c_profiles.forEach(p -> p.updateValue(p_timeParameters.getRunStartTime_h()));
c_forecasts.forEach(p -> p.initializeForecast(p_timeParameters.getRunStartTime_h())); 

if (v_rapidRunData != null && b_storePreviousRapidRunData) {
	v_previousRunData = v_rapidRunData;
}
v_rapidRunData = new J_RapidRunData(p_timeParameters, true);
v_rapidRunData.assetsMetaData = v_liveAssetsMetaData.getClone();
v_rapidRunData.assetsMetaData.saveActiveAssetAndCapacities(c_gridConnections);	
v_rapidRunData.connectionMetaData = v_liveConnectionMetaData.getClone();
v_rapidRunData.initializeAccumulators(v_liveData.activeEnergyCarriers, v_liveData.activeConsumptionEnergyCarriers, v_liveData.activeProductionEnergyCarriers, v_liveAssetsMetaData.activeAssetFlows); //f_initializeAccumulators();	
f_resetAnnualValues();

v_isRapidRun = true;

////Run energy calculations loop
for(v_timeStepsElapsed = 0; v_timeStepsElapsed < (p_timeParameters.getRunEndTime_h()-p_timeParameters.getRunStartTime_h())/p_timeParameters.getTimeStep_h(); v_timeStepsElapsed++ ){
	// Update time-series for model-wide variables (such as temps, wind, etc.)
	double startTime = System.currentTimeMillis();
	p_timeVariables.updateTimeVariables(v_timeStepsElapsed, p_timeParameters);
	f_updateTimeseries();
	v_timeSeriesRuntime_ms += (System.currentTimeMillis()-startTime);
	
	// Operate assets on each gridConnection
	startTime = System.currentTimeMillis();
	f_calculateGridConnectionFlows();
	v_gridConnectionsRuntime_ms += (System.currentTimeMillis()-startTime);
	
	// Calculate grid node flows
	startTime = System.currentTimeMillis();
	f_calculateGridnodeFlows();
	v_gridNodesRuntime_ms += (System.currentTimeMillis()-startTime);
	
	// Financial accounting of energy flows
	startTime = System.currentTimeMillis();
	f_calculateActorFlows();
	v_financialsRuntime_ms += (System.currentTimeMillis()-startTime);
	
	// Update elektriciteitsprijzen
	startTime = System.currentTimeMillis();
	f_updatePricesForNextTimestep();
	v_incentivesRuntime_ms += (System.currentTimeMillis()-startTime);

	//Run rapid data logging
	v_rapidRunData.addTimeStep(fm_currentBalanceFlows_kW, 
								fm_currentConsumptionFlows_kW, 
								fm_currentProductionFlows_kW, 
								fm_heatFromEnergyCarrier_kW,
								fm_consumptionForHeating_kW,
								fm_currentAssetFlows_kW,
								v_currentPrimaryEnergyProduction_kW, 
								v_currentFinalEnergyConsumption_kW, 
								v_currentPrimaryEnergyProductionHeatpumps_kW, 
								v_currentEnergyCurtailed_kW,
								v_batteryStoredEnergy_kWh/1000,
								p_timeVariables);
}	



////Caclulate KPIs
double startTime = System.currentTimeMillis();
f_calculateKPIs();

//Perform energy balance check
f_performEnergyBalanceCheck();

v_kpiCalcsRuntime_ms = (System.currentTimeMillis()-startTime);


traceln("---FINISHED YEAR MODEL RUN----");


////Return model to previous state to continue simulation run
v_timeStepsElapsed = v_timeStepsElapsed_live;
p_timeVariables.updateTimeVariables(v_timeStepsElapsed, p_timeParameters);

for (GridConnection GC : c_gridConnections) {
	GC.f_resetStatesAfterRapidRun();
}

v_isRapidRun = false;

double duration = System.currentTimeMillis() - startTime1;

traceln("*** headless run duration: "+ duration/1000 + " s ***");

traceln("Live-sim t_h after rapidRun: %s", p_timeVariables.getT_h());
if (b_isDeserialised) {
	traceln("Anylogic Model time(HOUR): %s", time(HOUR));
}
c_profiles.forEach(p -> p.updateValue(p_timeVariables.getT_h())); 
c_forecasts.forEach(p -> p.initializeForecast(p_timeVariables.getT_h())); 
 
  }

  /**
   * Executed on simulation end to export data.<br>
   * <br>
   * @author: JorritvandenHouten<br>
   * @since: Sprint 6
   */
  public void f_calculateKPIs(  ) { 

pop_gridNodes.forEach(gn -> gn.f_calculateKPIs());

pop_energyCoops.forEach(ec -> ec.f_calculateKPIs());

// Totals from accumulators:
v_totalElectricityConsumed_MWh = v_rapidRunData.getTotalElectricityConsumed_MWh();
v_totalElectricityProduced_MWh= v_rapidRunData.getTotalElectricityProduced_MWh();

v_totalEnergyConsumed_MWh = v_rapidRunData.getTotalEnergyConsumed_MWh();
v_totalEnergyProduced_MWh = v_rapidRunData.getTotalEnergyProduced_MWh();
v_totalEnergyImport_MWh = v_rapidRunData.am_totalBalanceAccumulators_kW.totalIntegralPos_kWh()/1000;
v_totalEnergyExport_MWh = -v_rapidRunData.am_totalBalanceAccumulators_kW.totalIntegralNeg_kWh()/1000;
v_totalEnergyCurtailed_MWh = v_rapidRunData.getTotalEnergyCurtailed_MWh();

// Electricity self consumption
v_individualSelfSufficiency_fr = sum(c_gridConnections, gc -> gc.v_rapidRunData.getTotalElectricitySelfConsumed_MWh()) / v_totalElectricityConsumed_MWh;
v_individualSelfConsumption_fr = sum(c_gridConnections, gc -> gc.v_rapidRunData.getTotalElectricitySelfConsumed_MWh()) / v_totalElectricityProduced_MWh;
v_totalElectricitySelfConsumed_MWh = v_rapidRunData.getTotalElectricitySelfConsumed_MWh();
v_collectiveSelfConsumption_fr = v_totalElectricitySelfConsumed_MWh / v_totalElectricityProduced_MWh;

traceln("");
traceln("__--** Totals **--__");
traceln("Energy consumed: "+ v_totalEnergyConsumed_MWh + " MWh");
traceln("Energy produced: "+ v_totalEnergyProduced_MWh + " MWh");
traceln("Energy import: "+ v_totalEnergyImport_MWh + " MWh");
traceln("Energy export: "+ v_totalEnergyExport_MWh + " MWh");


 
  }

  public void f_resetAnnualValues(  ) { 

v_rapidRunData.resetAccumulators(v_liveData.activeEnergyCarriers, v_liveData.activeConsumptionEnergyCarriers, v_liveData.activeProductionEnergyCarriers); //f_initializeAccumulators();

// Others
//acc_totalDLRfactor_f.reset();

 
  }

  public void f_runTimestep(  ) { 

if( p_timeVariables.getAnyLogicTime_h() != 0.0 && p_timeVariables.getAnyLogicTime_h() % (p_timeParameters.getRunEndTime_h() - p_timeParameters.getRunStartTime_h()) == 0.0) {
	f_loopSimulation();
}

// The very first step is to update time variables
p_timeVariables.updateTimeVariables(v_timeStepsElapsed, p_timeParameters);

// Update tijdreeksen in leesbare variabelen
f_updateTimeseries();

// Operate assets on each gridConnection
f_calculateGridConnectionFlows();

// Calculate grid node flows
f_calculateGridnodeFlows();

// Financial accounting of energy flows
f_calculateActorFlows();

// Update elektriciteitsprijzen
f_updatePricesForNextTimestep();

//Update live data
f_updateLiveData();

v_timeStepsElapsed ++;
 
  }

  private void f_buildGridNodeTree(  ) { 

//Initialize top level grid values
double topLevelElectricGridCapacity_kW = 0;
boolean topLevelGridCapacitiesKnown = true;

	// First make all links between GridNodes
for( GridNode GN : pop_gridNodes ) {
	GN.f_connectToParentNode();
}

// First clear lists (needed after deserialisation)
c_gridNodeExecutionList.clear();
c_gridNodeExecutionListReverse.clear();
c_gridNodesTopLevel.clear();
c_gridNodesNotTopLevel.clear();
	
// Then build execution order list
for( GridNode GN : pop_gridNodes ) {
	GridNode parentNode = findFirst(pop_gridNodes, p->p.p_gridNodeID.equals(GN.p_parentNodeID)); // Works as long as p_gridNodeID is not null. p_parentNodeID can be null no problemo.
	//if (GN.p_parentNodeID == null) {
	if (parentNode == null) {
		f_gridNodeRecursiveAdd(GN);
		c_gridNodesTopLevel.add(GN);
		if(GN.p_energyCarrier == OL_EnergyCarriers.ELECTRICITY){
			topLevelElectricGridCapacity_kW +=GN.p_capacity_kW;
			if(!GN.p_realCapacityAvailable){
				topLevelGridCapacitiesKnown = false;
			}
		}
	} else {
		c_gridNodesNotTopLevel.add(GN);	
		if (GN.p_gridNodeID.equals(parentNode.p_parentNodeID)) {
			traceln("Throwing exception because of circular dependency between gridNodes! GridNode %s and parentNode %s", GN.p_gridNodeID, parentNode.p_gridNodeID);
			throw new RuntimeException("Exception: circular GridNode dependency, only tree-topology supported");
		}
	}
}
c_gridNodeExecutionListReverse = c_gridNodeExecutionList;
Collections.reverse(c_gridNodeExecutionList);


//Set cumulative toplevel grid values as energyModel values
v_liveConnectionMetaData.setCapacities_kW(topLevelElectricGridCapacity_kW, topLevelElectricGridCapacity_kW, topLevelElectricGridCapacity_kW);
v_liveConnectionMetaData.setCapacitiesKnown(topLevelGridCapacitiesKnown, topLevelGridCapacitiesKnown, topLevelGridCapacitiesKnown);

//traceln("Grid Node execution list: %s", c_gridNodeExecutionList ); 
  }

  public void f_gridNodeRecursiveAdd( GridNode GN ) { 

c_gridNodeExecutionList.add(GN);
for (GridNode GNchild : GN.c_connectedGridNodes) {
	f_gridNodeRecursiveAdd(GNchild);
}

 
  }

  public 
ArrayList<GridConnection> 
 f_getActiveGridConnections(  ) { 

ArrayList<GridConnection> copyOfGridConnectionList = new ArrayList<>(c_gridConnections);
copyOfGridConnectionList.removeAll(Arrays.asList(pop_gridConnections)); // Remove all default gridconnections (no flex control, only used for gridnode profile)
return copyOfGridConnectionList;
 
  }

  public void f_initializeEngine(  ) { 

// What if this function is accidently called twice? Need to start with a clean sheet?
if (b_isInitialized) {
	throw new RuntimeException("Error: Engine was initalized a second time.");
}

/*
Date startDate = date();
p_year = startDate.getYear() + 1900;

LocalDate localDate = LocalDate.of(p_year, 1, 1);
v_dayOfWeek1jan = DayOfWeek.from(localDate).getValue();
p_startOfWinterWeek_h = roundToInt(24 * (p_winterWeekNumber * 7 + (8-v_dayOfWeek1jan)%7)); // Week 49 is winterweek.
p_startOfSummerWeek_h = roundToInt(24 * (p_summerWeekNumber * 7 + (8-v_dayOfWeek1jan)%7)); // Week 18 is summerweek.



int monthIdx = 0;
while ( t_h > hourOfYearPerMonth[monthIdx] ) {
	monthIdx++;
	if (monthIdx==hourOfYearPerMonth.length){
		break;
	}	
}

int dayOfMonth = 1+(int)((t_h - hourOfYearPerMonth[monthIdx])/24.0);
traceln("Day of month start: %s", dayOfMonth);
traceln("Month of year start: %s", monthIdx);
startDate.setMonth(monthIdx);
startDate.setDate(dayOfMonth);
startDate.setHours(0);
startDate.setMinutes(0);
traceln("Startdate: %s", startDate);
//startDate.set
getExperiment().getEngine().setStartDate(startDate); 
*/

//traceln("Day of the week on january 1st %s: %s, int value: %s", p_year, DayOfWeek.from(localDate).name(), v_dayOfWeek1jan);

// Initialize all agents in the correct order, creating all connections. What about setting initial values? And how about repeated simulations?
f_buildGridNodeTree();
c_gridConnections.forEach(GC -> GC.f_initialize(p_timeParameters));

// Only relevant for deserialisation:
c_pausedGridConnections.forEach(GC -> GC.f_initialize(p_timeParameters));

pop_connectionOwners.forEach(CO -> CO.f_initialize());
pop_energyCoops.forEach(EC -> EC.f_initialize(p_timeParameters)); // Not yet robust when there is no supplier initialized!



// Initializing Live Data Class
v_liveAssetsMetaData.updateActiveAssetData(c_gridConnections);
for (GridConnection GC : c_gridConnections) {
	v_liveData.activeEnergyCarriers.addAll(GC.v_liveData.activeEnergyCarriers);
	v_liveData.activeConsumptionEnergyCarriers.addAll(GC.v_liveData.activeConsumptionEnergyCarriers);
	v_liveData.activeProductionEnergyCarriers.addAll(GC.v_liveData.activeProductionEnergyCarriers);
}

// Loop over populations to check v_ispaused
f_initializePause();

for (GridNode GN : c_gridNodeExecutionList) {
	GN.f_initializeGridnode();
}

v_liveData.connectionMetaData.setContractedDeliveryCapacityKnown(false);
v_liveData.connectionMetaData.setContractedFeedinCapacityKnown(false);
v_liveData.connectionMetaData.setPhysicalCapacityKnown(false);

f_initializeForecasts();

f_initializeLiveDataSets();

//f_initializeAccumulators();

// Use parallelisation?
if (c_gridConnections.size() > 100) {
	b_parallelizeGridConnections = true;
}
if (pop_connectionOwners.size() > 500 && b_parallelizeGridConnections) {
	b_parallelizeConnectionOwners = true;
}

b_isInitialized = true; 
  }

  public 
ArrayList<ConnectionOwner> 
 f_getConnectionOwners(  ) { 

return c_connectionOwners; 
  }

  public 
double 
 f_getTopLevelGridCapacity_kW(  ) { 

return v_liveConnectionMetaData.getPhysicalCapacity_kW(); 
  }

  public 
ArrayList<J_EA> 
 f_getEnergyAssets(  ) { 

return c_energyAssets; 
  }

  public 
ArrayList<GridNode> 
 f_getGridNodesTopLevel(  ) { 

return this.c_gridNodesTopLevel; 
  }

  public 
ArrayList<GridNode> 
 f_getGridNodesNotTopLevel(  ) { 

return this.c_gridNodesNotTopLevel; 
  }

  /**
   * Function to initialize the paused gridconnections.
   */
  void f_initializePause(  ) { 

for (GridConnection GC : UtilityConnections) {
	if (!GC.v_isActive) {
		GC.f_setActive(false, p_timeVariables);
	}
}
for (GridConnection GC : EnergyProductionSites) {
	if (!GC.v_isActive) {
		GC.f_setActive(false, p_timeVariables);
	}
}
for (GridConnection GC : EnergyConversionSites) {
	if (!GC.v_isActive) {
		GC.f_setActive(false, p_timeVariables);
	}
}
for (GridConnection GC : GridBatteries) {
	if (!GC.v_isActive) {
		GC.f_setActive(false, p_timeVariables);
	}
}
for (GridConnection GC : PublicChargers) {
	if (!GC.v_isActive) {
		GC.f_setActive(false, p_timeVariables);
	}
} 
  }

  public void f_addProfile( J_ProfilePointer profile ) { 

c_profiles.add(profile); 
  }

  public 
ArrayList<GridConnection> 
 f_getPausedGridConnections(  ) { 

return c_pausedGridConnections; 
  }

  public 
J_ProfilePointer 
 f_findProfile( String assetName ) { 

J_ProfilePointer profilePointer = findFirst(c_profiles, p -> p.name.equals(assetName));
//traceln("J_EAConsumption with name %s found profile asset: %s", assetName, profilePointer);
if (profilePointer == null) {
	traceln("No profilePointer with name %s found", assetName);
	throw new RuntimeException(String.format("Consumption or production asset without valid profile!") );
}
return profilePointer; 
  }

  void f_updateLiveData(  ) { 

//Current timestep
double currentTime_h = p_timeVariables.getAnyLogicTime_h();

v_liveData.addTimeStep(currentTime_h,
	fm_currentBalanceFlows_kW,
	fm_currentConsumptionFlows_kW,
	fm_currentProductionFlows_kW,
	fm_currentAssetFlows_kW,
	v_currentPrimaryEnergyProduction_kW, 
	v_currentFinalEnergyConsumption_kW, 
	v_currentPrimaryEnergyProductionHeatpumps_kW, 
	v_currentEnergyCurtailed_kW, 
	v_batteryStoredEnergy_kWh/1000 
);
 
  }

  void f_initializeLiveDataSets(  ) { 

v_liveData.dsm_liveDemand_kW.createEmptyDataSets(v_liveData.activeEnergyCarriers, roundToInt(168/p_timeParameters.getTimeStep_h()));
v_liveData.dsm_liveSupply_kW.createEmptyDataSets(v_liveData.activeEnergyCarriers, roundToInt(168/p_timeParameters.getTimeStep_h()));
v_liveData.dsm_liveAssetFlows_kW.createEmptyDataSets(v_liveData.assetsMetaData.activeAssetFlows, roundToInt(168/p_timeParameters.getTimeStep_h())); 
  }

  public 
EnergyCoop 
 f_addEnergyCoop( ArrayList<GridConnection> gcList, J_TimeParameters timeParameters ) { 

// Add energyCoop
EnergyCoop energyCoop = add_pop_energyCoops();
energyCoop.p_actorID = "Custom Coop for filtered GC list";
// Connect GCs, connectionOwners and energyCoop and gather data
/*for(GridConnection gc : gcList) {
	if(gc.p_owner == null) {
		throw new RuntimeException("Can't add gridConnection without a connectionOwner to EnergyCoop!");
	} else {
		gc.p_owner.p_actorGroup = "member";
		gc.p_owner.p_coopParent = energyCoop;
		gc.p_owner.f_initialize();
	}
}*/
// Initialisation, collecting data and calculating KPIs.
energyCoop.f_initializeCustomCoop(gcList, timeParameters);

// Adding this coop to the list of coops in the GC
gcList.forEach(gc -> gc.c_parentCoops.add(energyCoop));

// Return energyCoop to caller 
return energyCoop; 
  }

  public void f_removeEnergyCoop( EnergyCoop energyCoop, J_TimeVariables timeVariables ) { 

// Connect GCs, connectionOwners and energyCoop and gather data
for(Agent CO : energyCoop.c_coopCustomers){
	if(CO instanceof ConnectionOwner){
		((ConnectionOwner)CO).p_coopParent = null;
		((ConnectionOwner)CO).f_initialize();	
	}
}

for(Agent CO : energyCoop.c_coopMembers){
	if(CO instanceof ConnectionOwner){
		((ConnectionOwner)CO).p_coopParent = null;
		((ConnectionOwner)CO).f_initialize();	
	}
}

// Removing this coop from the list of coops in the GC
for (GridConnection GC : energyCoop.f_getAllChildMemberGridConnections()) {
	GC.c_parentCoops.remove(energyCoop);
	if(GC instanceof GCGridBattery && GC.f_getBatteryManagement() instanceof J_BatteryManagementPeakShaving && ((J_BatteryManagementPeakShaving)GC.f_getBatteryManagement()).getTargetType() == OL_ResultScope.ENERGYCOOP){
		((J_BatteryManagementPeakShaving)GC.f_getBatteryManagement()).setTarget(null);
		((J_BatteryManagementPeakShaving)GC.f_getBatteryManagement()).setTargetType( OL_ResultScope.ENERGYCOOP );
		GC.f_setActive(false, timeVariables);
	}
}

// Remove energyCoop from pop_energyCoops.
remove_pop_energyCoops(energyCoop);

 
  }

  public void f_addConsumptionEnergyCarrier( OL_EnergyCarriers EC ) { 

if (!v_liveData.activeConsumptionEnergyCarriers.contains(EC)) {
	v_liveData.activeEnergyCarriers.add(EC);
	v_liveData.activeConsumptionEnergyCarriers.add(EC);
	
	DataSet dsDemand = new DataSet( (int)(168 / p_timeParameters.getTimeStep_h()) );
	
	double endTime = p_timeVariables.getAnyLogicTime_h();
	double startTime = max(0, p_timeVariables.getAnyLogicTime_h() - 168);

	for (double t = startTime; t <= endTime; t += p_timeParameters.getTimeStep_h()) {
		dsDemand.add( t, 0);
	}
	v_liveData.dsm_liveDemand_kW.put( EC, dsDemand);
} 
  }

  public void f_updateActiveAssetsMetaData(  ) { 


//Update main area
v_liveAssetsMetaData.updateActiveAssetData(f_getAllGridConnections());

//Update coop
if(pop_energyCoops.size()>0){
	pop_energyCoops.get(pop_energyCoops.size()-1).v_liveAssetsMetaData.updateActiveAssetData(pop_energyCoops.get(pop_energyCoops.size()-1).f_getAllChildMemberGridConnections());
}	

//Update grid connection active asset data
for(GridConnection GC : f_getAllGridConnections()){
	GC.v_liveAssetsMetaData.updateActiveAssetData(new ArrayList<>(List.of(GC)));
}
 
  }

  public void f_addProductionEnergyCarrier( OL_EnergyCarriers EC ) { 

if (!v_liveData.activeProductionEnergyCarriers.contains(EC)) {
	v_liveData.activeEnergyCarriers.add(EC);
	v_liveData.activeProductionEnergyCarriers.add(EC);
	
	DataSet dsSupply = new DataSet( (int)(168 / p_timeParameters.getTimeStep_h()) );

	double endTime = p_timeVariables.getAnyLogicTime_h();
	double startTime = max(0, p_timeVariables.getAnyLogicTime_h() - 168);

	for (double t = startTime; t <= endTime; t += p_timeParameters.getTimeStep_h()) {
		dsSupply.add( t, 0);
	}
	v_liveData.dsm_liveSupply_kW.put( EC, dsSupply);
} 
  }

  void f_updateAmbientDependentAssets(  ) { 

// Update environmental conditions for relevant energy assets
for( J_EA e : c_ambientDependentAssets ) {
	if( e instanceof J_EAStorageHeat) { // includes J_EABuilding
		switch(((J_EAStorageHeat) e).getAmbientTempType()){
			case FIXED:
				//Do nothing, use preset ambient temp
				break;
			case AMBIENT_AIR:
				((J_EAStorageHeat)e).updateAmbientTemperature( pp_ambientTemperature_degC.getCurrentValue() );
				break;
			case BUILDING:
				new RuntimeException("AmbientTempType 'BUILDING' is not supported yet for J_EAStorageHeat!");
				/*
				GridConnection parentGC = (GridConnection)e.getParentAgent();
				if(parentGC.p_BuildingThermalAsset == null){
					new RuntimeException("GC has heat storage with AmbientTempType 'Building', with no J_EABuilding present");
				}
				else{
					((J_EAStorageHeat)e).updateAmbientTemperature(parentGC.p_BuildingThermalAsset.getCurrentTemperature());
				}
				*/
				break;
			case HEAT_GRID:
				// Do Nothing, keep fixed temp for now
				//new RuntimeException("AmbientTempType 'HEAT_GRID' is not supported yet for J_EAStorageHeat!");
				break;
			case HEAT_STORAGE:
				new RuntimeException("AmbientTempType 'HEAT_STORAGE' is not supported yet for J_EAStorageHeat!");
				break;
		}	
	}
	if (e instanceof J_EAConversionHeatPump) {
			switch(((J_EAConversionHeatPump) e).getAmbientTempType()){
			case FIXED:
				//Do nothing, use preset ambient temp
				break;
			case AMBIENT_AIR:
				((J_EAConversionHeatPump)e).updateAmbientTemperature( pp_ambientTemperature_degC.getCurrentValue() );
				break;
			case BUILDING:
				new RuntimeException("AmbientTempType 'BUILDING' is not supported yet for J_EAConversionHeatPump!");
				/*
				GridConnection parentGC = (GridConnection)e.getParentAgent();
				if(parentGC.p_BuildingThermalAsset == null){
					new RuntimeException("GC has heatpump with AmbientTempType 'Building', with no J_EABuilding present");
				}
				else{
					((J_EAConversionHeatPump)e).updateAmbientTemperature(parentGC.p_BuildingThermalAsset.getCurrentTemperature());
				}
				*/
				break;
			case HEAT_GRID:
				new RuntimeException("AmbientTempType 'HEAT_GRID' is not supported yet for J_EAConversionHeatPump!");
				break;
			case HEAT_STORAGE:
				new RuntimeException("AmbientTempType 'HEAT_STORAGE' is not supported yet for J_EAConversionHeatPump!");
				break;
			}		
	}
	if( e instanceof J_EABuilding ) {
		//traceln("v_currentSolarPowerNormalized_r: %s", v_currentSolarPowerNormalized_r);
		((J_EABuilding)e).updateSolarRadiation(pp_PVProduction35DegSouth_fr.getCurrentValue()*1000);
	}
} 
  }

  void f_performEnergyBalanceCheck(  ) { 

//Get battery energy use for balance check
f_sumBatteryUse();

// *** Total energy balance ***
double deltaThermalEnergySinceStart_MWh = 0;
double totalAmbientHeating_MWh = 0;
double totalEnergyCurtailed_MWh = 0;
double totalEnergyProduced_MWh = 0;
double totalEnergyUsed_MWh = 0;
double totalEnergyChargedOutsideModel_MWh = 0;
double totalHeatProduced_MWh = 0;
for (J_EA e : c_energyAssets) {
	if (e.ownerIsActive()) {
		double EnergyUsed_kWh = e.getEnergyUsed_kWh();
		if (EnergyUsed_kWh > 0) {
			if( e instanceof J_EAConversionGasCHP ) {
				totalEnergyUsed_MWh += EnergyUsed_kWh/1000;
				//electricityProduced_kWh = ((J_EAConversionGasCHP)e).getElectricityProduced_kWh();
				//electricityProduced_MWh += electricityProduced_kWh/1000;
			} else {
				totalEnergyUsed_MWh += EnergyUsed_kWh/1000;
			}
		} else {
			totalEnergyProduced_MWh -= EnergyUsed_kWh/1000;
			if ( e instanceof J_EABuilding ) {
				traceln("Building has produced more energy than it has used?? Is lossfactor too low?");
				traceln("Lossfactor: %s", ((J_EABuilding)e).lossFactor_WpK);
			}
		}
		if (e instanceof J_EAStorageHeat) { // includes J_EABuilding
			totalAmbientHeating_MWh += ((J_EAStorageHeat)e).ambientEnergyAbsorbed_kWh/1000;
			totalHeatProduced_MWh += ((J_EAStorageHeat)e).ambientEnergyAbsorbed_kWh/1000;
			totalEnergyProduced_MWh += ((J_EAStorageHeat)e).ambientEnergyAbsorbed_kWh/1000;
			deltaThermalEnergySinceStart_MWh += (((J_EAStorageHeat)e).getRemainingHeatStorageHeat_kWh() - ((J_EAStorageHeat)e).getStartingHeatStorageHeat_kWh())/1000;						
		}
		if (e instanceof J_EAEV) {
			totalEnergyChargedOutsideModel_MWh += ((J_EAEV)e).getEnergyChargedOutsideModelArea_kWh()/1000;
		}
		if (e instanceof J_EAConversionHeatPump) {
			totalHeatProduced_MWh -= EnergyUsed_kWh/1000;						
		}
	}
}
double v_totalDeltaStoredEnergy_MWh = v_batteryStoredEnergyDeltaSinceStart_MWh + deltaThermalEnergySinceStart_MWh; // Positive number means more energy stored at the end of the simulation. 

//Total selfconsumption, selfsufficiency
v_totalEnergySelfConsumed_MWh = v_totalEnergyConsumed_MWh - (v_totalEnergyImport_MWh + max(0,-v_totalDeltaStoredEnergy_MWh)); // Putting positive delta-stored energy here assumes this energy was imported as opposed to self-produced. Putting negative delta-stored energy here assumes this energy was self-consumed, as opposed to exported.
//v_totalSelfConsumedEnergy_MWh = totalEnergyUsed_MWh - (v_totalImportedEnergy_MWh + max(0,-v_totalDeltaStoredEnergy_MWh)); // Putting positive delta-stored energy here assumes this energy was imported as opposed to self-produced. Putting negative delta-stored energy here assumes this energy was self-consumed, as opposed to exported.

// Export and production-based selfconsumption
if ( v_totalEnergyProduced_MWh > 0 ){
	v_modelSelfConsumption_fr = v_totalEnergySelfConsumed_MWh / v_totalEnergyProduced_MWh;
}
traceln("");
traceln("Total energy absorbed from environment by buildings: %s MWh", totalAmbientHeating_MWh);
traceln("Delta thermal stored energy since start: %s MWh", deltaThermalEnergySinceStart_MWh);
traceln("Total energy from vehicles charging outside the model scope: %s MWh", totalEnergyChargedOutsideModel_MWh);

traceln("Energy selfconsumption: " + v_modelSelfConsumption_fr*100 + "%");
double totalElectricitySelfConsumption_fr = 0;

/*if ( v_totalElectricityProduced_MWh > 0 ){
	totalElectricitySelfConsumption_fr = 1 - fm_totalExports_MWh.get(OL_EnergyCarriers.ELECTRICITY)/v_totalElectricityProduced_MWh;
}*/

//v_modelSelfSufficiency_fr = 1 - (v_totalElectricityImport_MWh + max(0,v_totalMethaneImport_MWh - v_totalMethaneExport_MWh) + max(0,v_totalHydrogenImport_MWh - v_totalHydrogenExport_MWh) + v_totalPetroleumFuelImport_MWh - v_batteryStoredEnergyDeltaSinceStart_MWh - deltaThermalEnergySinceStart_MWh) / v_totalEnergyUsed_MWh;
v_modelSelfSufficiency_fr = v_totalEnergySelfConsumed_MWh / v_totalEnergyConsumed_MWh; // Calculation based on (total_consumption - total_import) / total_consumption. Positive delta-stored energy is contained in v_totalSelfConsumedEnergy_MWh. 
//v_modelSelfSufficiency_fr = v_totalSelfConsumedEnergy_MWh / totalEnergyUsed_MWh; // Calculation based on (total_consumption - total_import) / total_consumption. Positive delta-stored energy is contained in v_totalSelfConsumedEnergy_MWh. 

traceln("Energy selfsufficiency (via import calc): %s %%", v_modelSelfSufficiency_fr*100);
//double totalSelfSufficiency_fr_check = (v_totalEnergyProduced_MWh - (v_totalElectricityExport_MWh + max(0,v_totalMethaneExport_MWh-v_totalMethaneImport_MWh) + max(0,v_totalHydrogenExport_MWh-v_totalHydrogenImport_MWh)))/v_totalEnergyUsed_MWh; // Calculation based on (total_production - total_export) / total_consumption
//double totalSelfSufficiency_fr_check = v_totalSelfConsumedEnergyCheck_MWh / totalEnergyUsed_MWh; // Calculation based on (total_production - total_export) / total_consumption. Negative delta-stored energy is contained in v_totalSelfConsumedEnergy_MWh. 

// Remaining difference due to different temps of houses start vs end?
traceln("");
for (OL_EnergyCarriers EC : v_liveData.activeEnergyCarriers) {
	traceln("Import " + EC.toString() + ": " + v_rapidRunData.getTotalImport_MWh(EC) + " MWh");
	traceln("Export " + EC.toString() + ": " + v_rapidRunData.getTotalExport_MWh(EC) + " MWh");
}

traceln("");
traceln("__--** Checks **--__");

traceln("Check energy used from array and from energy assets: %s MWh", ( v_totalEnergyConsumed_MWh - totalEnergyUsed_MWh) );
traceln("Check energy produced from array and from energy assets: %s MWh", ( v_totalEnergyProduced_MWh - totalEnergyProduced_MWh) );

double energyBalanceCheck_MWh = v_totalEnergyImport_MWh + v_totalEnergyProduced_MWh - (v_totalEnergyExport_MWh + v_totalEnergyConsumed_MWh + v_totalDeltaStoredEnergy_MWh);
traceln("Check on energy balance is: " + energyBalanceCheck_MWh + " MWh, must be zero!");
traceln("");

if ( Math.abs(energyBalanceCheck_MWh) > 1e-6 ) {
	traceln("");
	String warningString = String.format("__--** WARNING!!!! **--__");
	String errorString = String.format("ENERGY BALANCE ERROR EXCEEDING TOLERANCE!! Error: %s MWh", energyBalanceCheck_MWh);
	traceln(warningString);
	//traceln(red, errorString);
	System.err.println(errorString);
	traceln(warningString);
	traceln("");

} 
  }

  public void f_startAfterDeserialisation(  ) { 

// Reconstruct the LiveData class
/*v_liveData = new J_LiveData(this);
v_liveData.activeEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeProductionEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeConsumptionEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);

//v_liveConnectionMetaData = new J_ConnectionMetaData(this);
//v_liveAssetsMetaData = new J_AssetsMetaData(this);
v_liveData.connectionMetaData = v_liveConnectionMetaData;
v_liveData.assetsMetaData = v_liveAssetsMetaData;*/

v_liveData.resetLiveDatasets(p_timeParameters);

fm_currentProductionFlows_kW = new J_FlowsMap();
fm_currentConsumptionFlows_kW = new J_FlowsMap();
fm_currentBalanceFlows_kW = new J_FlowsMap();
fm_currentAssetFlows_kW = new J_ValueMap(OL_AssetFlowCategories.class);
fm_heatFromEnergyCarrier_kW = new J_FlowsMap();
fm_consumptionForHeating_kW = new J_FlowsMap();

// Reconstruct the LiveData class in the EnergyCoops
pop_energyCoops.forEach(ec -> ec.f_startAfterDeserialisation(p_timeParameters));

// Reconstruct the LiveData class in the GridConnections and add EnergyCarriers
List<GridConnection> allGridConnections = new ArrayList<>(c_gridConnections);
allGridConnections.addAll(c_pausedGridConnections);

allGridConnections.forEach(gc -> gc.f_startAfterDeserialisation(p_timeParameters, p_timeVariables));

// Initialize time and date
//v_hourOfYearStart=hourOfYearPerMonth[getMonth()] + (getDayOfMonth()-1)*24;
v_timeStepsElapsed = 0;
p_timeVariables.updateTimeVariables(v_timeStepsElapsed, p_timeParameters);

/*
Date startDate = date();
p_year = startDate.getYear() + 1900;

LocalDate localDate = LocalDate.of(p_year, 1, 1);
//v_dayOfWeek1jan = DayOfWeek.from(localDate).getValue();
p_startOfWinterWeek_h = roundToInt(24 * (p_winterWeekNumber * 7 + (8-v_dayOfWeek1jan)%7)); // Week 49 is winterweek.
p_startOfSummerWeek_h = roundToInt(24 * (p_summerWeekNumber * 7 + (8-v_dayOfWeek1jan)%7)); // Week 18 is summerweek.

int monthIdx = 0;
while ( t_h > hourOfYearPerMonth[monthIdx] ) {
	monthIdx++;
	if (monthIdx==hourOfYearPerMonth.length){
		break;
	}	
}

int dayOfMonth = 1+(int)((t_h - hourOfYearPerMonth[monthIdx])/24.0);
traceln("Day of month start: %s", dayOfMonth);
traceln("Month of year start: %s", monthIdx);
startDate.setMonth(monthIdx);
startDate.setDate(dayOfMonth);
startDate.setHours(0);
startDate.setMinutes(0);
traceln("Startdate: %s", startDate);
//startDate.set
getExperiment().getEngine().setStartDate(startDate); 
*/

f_initializeForecasts();

f_initializeLiveDataSets();

b_isDeserialised = true; 
  }

  public 
Pair<J_DataSetMap, J_DataSetMap> 
 f_getPeakWeekDataSets(  ) { 

double[] elecBalance_kW = v_rapidRunData.am_totalBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getTimeSeries_kW();

int maxIndex = 0; // index with peak import
for (int i = 1; i < elecBalance_kW.length; i++) {
    if (elecBalance_kW[i] > elecBalance_kW[maxIndex]) {
        maxIndex = i;
    }
}

int minIndex = 0; // index with peak export
for (int i = 1; i < elecBalance_kW.length; i++) {
    if (elecBalance_kW[i] < elecBalance_kW[minIndex]) {
        minIndex = i;
    }
}

int startIdx = max(0,maxIndex - 7*48);
int endIdx = max(startIdx + 7*96, maxIndex + 7*48);
J_DataSetMap peakImportWeekAssetFlows = new J_DataSetMap(OL_AssetFlowCategories.class);
for (OL_AssetFlowCategories AC : v_rapidRunData.am_assetFlowsAccumulators_kW.keySet()) {
	double[] assetFlowArray_kW = v_rapidRunData.am_assetFlowsAccumulators_kW.get(AC).getTimeSeries_kW();
	for (int i=startIdx; i<endIdx; i++) {
		peakImportWeekAssetFlows.get(AC).add(p_timeParameters.getTimeStep_h() * i, assetFlowArray_kW[i]);
	}
}

startIdx = max(0,minIndex - 7*48);
endIdx = max(startIdx + 7*96, minIndex + 7*48);
J_DataSetMap peakExportWeekAssetFlows = new J_DataSetMap(OL_AssetFlowCategories.class);
for (OL_AssetFlowCategories AC : v_rapidRunData.am_assetFlowsAccumulators_kW.keySet()) {
	double[] assetFlowArray_kW = v_rapidRunData.am_assetFlowsAccumulators_kW.get(AC).getTimeSeries_kW();
	for (int i=startIdx; i<endIdx; i++) {
		peakExportWeekAssetFlows.get(AC).add(p_timeParameters.getTimeStep_h() * i, assetFlowArray_kW[i]);
	}
}

return new Pair<>(peakImportWeekAssetFlows, peakExportWeekAssetFlows);
 
  }

  public void f_addAssetFlow( OL_AssetFlowCategories AC ) { 

if (!v_liveAssetsMetaData.activeAssetFlows.contains(AC)) {
	v_liveAssetsMetaData.activeAssetFlows.add(AC);
	
	DataSet dsAsset = new DataSet( (int)(168 / p_timeParameters.getTimeStep_h()) );
	
	double endTime = p_timeVariables.getAnyLogicTime_h();
	double startTime = max(0, p_timeVariables.getAnyLogicTime_h() - 168);

	for (double t = startTime; t <= endTime; t += p_timeParameters.getTimeStep_h()) {
		dsAsset.add( t, 0);
	}
	v_liveData.dsm_liveAssetFlows_kW.put( AC, dsAsset);
	
	if (AC == OL_AssetFlowCategories.batteriesChargingPower_kW) { // also add batteriesDischarging!
		dsAsset = new DataSet( (int)(168 / p_timeParameters.getTimeStep_h()) );
		
		for (double t = startTime; t <= endTime; t += p_timeParameters.getTimeStep_h()) {
			dsAsset.add( t, 0);
		}
		v_liveData.dsm_liveAssetFlows_kW.put( OL_AssetFlowCategories.batteriesDischargingPower_kW, dsAsset);
	}
	if (AC == OL_AssetFlowCategories.V2GPower_kW && !v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.evChargingPower_kW)) { // also add evCharging!
		dsAsset = new DataSet( (int)(168 / p_timeParameters.getTimeStep_h()) );
		
		for (double t = startTime; t <= endTime; t += p_timeParameters.getTimeStep_h()) {
			dsAsset.add( t, 0);
		}
		v_liveData.dsm_liveAssetFlows_kW.put( OL_AssetFlowCategories.evChargingPower_kW, dsAsset);
	}	
} 
  }

  public 
List<GridConnection> 
 f_getGridConnectionsCollectionPointer(  ) { 

return this.c_gridConnections; 
  }

  public 
List<GridConnection> 
 f_getPausedGridConnectionsCollectionPointer(  ) { 

return this.c_pausedGridConnections; 
  }

  void f_runAggregators(  ) { 

//Function used to perform central management functions (like setpoint battery steering)

//Run energy coop aggrator
for (EnergyCoop EC : pop_energyCoops) {
	EC.f_operateAggregatorEnergyManagement(p_timeVariables);
} 
  }

  public 
Date 
 f_getDate(  ) { 

Date startDate = getExperiment().getEngine().getStartDate();
long startDateUnixTime_ms = startDate.getTime();
long runtime_ms = (long) (v_timeStepsElapsed * p_timeParameters.getTimeStep_h() * 60 * 60 * 1000);
Date date = new Date();
date.setTime(startDateUnixTime_ms + runtime_ms);
return date; 
  }

  void f_loopSimulation(  ) { 

v_liveSimLoopCount++;
v_timeStepsElapsed = 0;
f_clearAllLiveDatasets();
traceln("The simulation has been looped."); 
  }

  void f_clearAllLiveDatasets(  ) { 

//Energy Model
v_liveData.clearLiveDatasets();

//Energy Coops
pop_energyCoops.forEach(EC -> EC.v_liveData.clearLiveDatasets());

//GridConnections
c_gridConnections.forEach(GC -> GC.v_liveData.clearLiveDatasets());
c_pausedGridConnections.forEach(GC -> GC.v_liveData.clearLiveDatasets()); 
  }

  public 
ArrayList<GridConnection> 
 f_getAllGridConnections(  ) { 

ArrayList<GridConnection> copyOfGridConnectionList = new ArrayList<>(c_gridConnections);
copyOfGridConnectionList.addAll(c_pausedGridConnections);
copyOfGridConnectionList.removeAll(Arrays.asList(pop_gridConnections)); // Remove all default gridconnections (no flex control, only used for gridnode profile)

return copyOfGridConnectionList;
 
  }

  public void f_checkConfiguration(  ) { 

c_gridConnections.forEach(gc -> gc.f_checkConfiguration());
 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea va_engine = new ViewArea( this, null, 0, 0, 1920, 980 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1920.0, 980.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "va_engine", this.va_engine );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_rapidSim_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_viewData_Font = _button_rapidSim_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_Profiles_Font = new Font("SansSerif", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_energyBalanceCheck_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_gridConnections_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_infraAndAssets_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_actors_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_otherAgents_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_variables_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_forecastLengths_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_initialization_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_UI_visualisationAgens_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text12_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text14_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_Forecasters_Font = _txt_Profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_simulationEngine_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_updateFunctions_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_energyModelState_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_rapidRunTimeProfiling_Font = new Font("SansSerif", 1, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_outputs_Font = _txt_energyBalanceCheck_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_timeParametersAndVariables_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_additionalData_Font = _txt_Profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_simulationSettings_Font = _txt_Profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_timeParameters1_Font = _txt_Profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_projectParameters_Font = _txt_Profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_loopSimulationFunctionality_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_checkFunctions_Font = _txt_gridConnections_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_parametersAndProfiles = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_Profiles = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_energyBalanceCheck2 = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_energyBalanceCheck1 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_energyBalanceCheck = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_gridConnections = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_gridConnections = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_infraAndAssets = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_infraAndAssets = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_actors = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_actors = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_otherAgents = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_otherAgents = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_variables = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_variables = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_forecastLengths = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_initialization = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_initialization = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_UI_visualisationAgens = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_UI_visualisationAgens = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _line10 = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _text12 = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_forecastLengths = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _line11 = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _text14 = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_Forecasters = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_simulationEngine = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_simulationEngine = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_updateFunctions = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_updateFunctions = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_energyModelState = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_energyModelState = 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_output2 = 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_rapidRunTimeProfiling = 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_rapidRunTimeProfiling = 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_output3 = 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_outputs = 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_timeParametersAndVariables = 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_timeParametersAndVariables = 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_parametersAndProfiles1 = 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_additionalData = 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_simulationSettings = 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_timeParameters1 = 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_projectParameters = 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_loopSimulationFunctionality = 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_updateFunctions1 = 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_checkFunctions = 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_checkFunctions = 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_rapidSim = 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_viewData = 50;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 51;

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
	  level.addAll(rect_parametersAndProfiles, txt_Profiles, rect_energyBalanceCheck2, rect_energyBalanceCheck1, txt_energyBalanceCheck, txt_gridConnections, line_gridConnections, txt_infraAndAssets, line_infraAndAssets, line_actors, txt_actors, line_otherAgents, txt_otherAgents, line_variables, txt_variables, txt_forecastLengths, line_initialization, txt_initialization, line_UI_visualisationAgens, txt_UI_visualisationAgens, button_rapidSim, line10, text12, line_forecastLengths, line11, text14, button_viewData, txt_Forecasters, txt_simulationEngine, line_simulationEngine, txt_updateFunctions, line_updateFunctions, txt_energyModelState, line_energyModelState, rect_output2, txt_rapidRunTimeProfiling, line_rapidRunTimeProfiling, rect_output3, txt_outputs, line_timeParametersAndVariables, txt_timeParametersAndVariables, rect_parametersAndProfiles1, txt_additionalData, txt_simulationSettings, txt_timeParameters1, txt_projectParameters, txt_loopSimulationFunctionality, line_updateFunctions1, txt_checkFunctions, line_checkFunctions);
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level1_xjal() {
	  level1.addAll();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _button_rapidSim: {
          ShapeButton self = this.button_rapidSim;
f_runRapidSimulation(); 
;}
        break;
      case _button_viewData: {
          ShapeButton self = this.button_viewData;
energyDataViewer.f_fillEnergyDataViewer(this, p_timeParameters);
energyDataViewer.viewArea.navigateTo(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  protected ShapeButton button_rapidSim;
  protected ShapeButton button_viewData;
  protected ShapeRectangle rect_parametersAndProfiles;
  protected ShapeText txt_Profiles;
  protected ShapeRectangle rect_energyBalanceCheck2;
  protected ShapeRectangle rect_energyBalanceCheck1;
  protected ShapeText txt_energyBalanceCheck;
  protected ShapeText txt_gridConnections;
  protected ShapeLine line_gridConnections;
  protected ShapeText txt_infraAndAssets;
  protected ShapeLine line_infraAndAssets;
  protected ShapeLine line_actors;
  protected ShapeText txt_actors;
  protected ShapeLine line_otherAgents;
  protected ShapeText txt_otherAgents;
  protected ShapeLine line_variables;
  protected ShapeText txt_variables;
  protected ShapeText txt_forecastLengths;
  protected ShapeLine line_initialization;
  protected ShapeText txt_initialization;
  protected ShapeLine line_UI_visualisationAgens;
  protected ShapeText txt_UI_visualisationAgens;
  protected ShapeLine line10;
  protected ShapeText text12;
  protected ShapeLine line_forecastLengths;
  protected ShapeLine line11;
  protected ShapeText text14;
  protected ShapeText txt_Forecasters;
  protected ShapeText txt_simulationEngine;
  protected ShapeLine line_simulationEngine;
  protected ShapeText txt_updateFunctions;
  protected ShapeLine line_updateFunctions;
  protected ShapeText txt_energyModelState;
  protected ShapeLine line_energyModelState;
  protected ShapeRectangle rect_output2;
  protected ShapeText txt_rapidRunTimeProfiling;
  protected ShapeLine line_rapidRunTimeProfiling;
  protected ShapeRectangle rect_output3;
  protected ShapeText txt_outputs;
  protected ShapeLine line_timeParametersAndVariables;
  protected ShapeText txt_timeParametersAndVariables;
  protected ShapeRectangle rect_parametersAndProfiles1;
  protected ShapeText txt_additionalData;
  protected ShapeText txt_simulationSettings;
  protected ShapeText txt_timeParameters1;
  protected ShapeText txt_projectParameters;
  protected ShapeText txt_loopSimulationFunctionality;
  protected ShapeLine line_updateFunctions1;
  protected ShapeText txt_checkFunctions;
  protected ShapeLine line_checkFunctions;
  protected com.anylogic.engine.markup.Level level;
  protected com.anylogic.engine.markup.Level level1;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    button_rapidSim = new ShapeButton(
EnergyModel.this, true, 1280.0, 40.0,
			140.0, 30.0,
            black, true,
_button_rapidSim_Font,
			"Run Rapid Simulation" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_rapidSim, 0 );
      }
    };
    button_viewData = new ShapeButton(
EnergyModel.this, true, 220.0, -60.0,
			100.0, 30.0,
            black, true,
_button_viewData_Font,
			"View Data" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_viewData, 0 );
      }
    };
    rect_parametersAndProfiles = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-880.0, 400.0, 0.0, 0.0,
            green, white,
			780.0, 610.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_Profiles = new ShapeText(
        SHAPE_DRAW_2D, true,-861.0, 445.0, 0.0, 0.0,
        black,"Profiles:",
        _txt_Profiles_Font, ALIGNMENT_LEFT );
    rect_energyBalanceCheck2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,960.0, 980.0, 0.0, 0.0,
            peru, white,
			420.0, 440.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_energyBalanceCheck1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,960.0, 980.0, 0.0, 0.0,
            peru, white,
			420.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_energyBalanceCheck = new ShapeText(
        SHAPE_DRAW_2D, true,1080.0, 990.0, 0.0, 0.0,
        peru,"EnergyBalance Check\n",
        _txt_energyBalanceCheck_Font, ALIGNMENT_LEFT );
    txt_gridConnections = new ShapeText(
        SHAPE_DRAW_2D, true,120.0, 10.0, 0.0, 0.0,
        black,"Gridconnections",
        _txt_gridConnections_Font, ALIGNMENT_LEFT );
    line_gridConnections = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 60.0, 30.0, 0.0, black,
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_infraAndAssets = new ShapeText(
        SHAPE_DRAW_2D, true,440.0, 10.0, 0.0, 0.0,
        black,"Infra & assets",
        _txt_infraAndAssets_Font, ALIGNMENT_LEFT );
    line_infraAndAssets = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 380.0, 30.0, 0.0, black,
 		180.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line_actors = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 60.0, 320.0, 0.0, black,
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_actors = new ShapeText(
        SHAPE_DRAW_2D, true,130.0, 300.0, 0.0, 0.0,
        black,"Actors",
        _txt_actors_Font, ALIGNMENT_LEFT );
    line_otherAgents = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 60.0, 510.0, 0.0, black,
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_otherAgents = new ShapeText(
        SHAPE_DRAW_2D, true,150.0, 490.0, 0.0, 0.0,
        black,"Other populations",
        _txt_otherAgents_Font, ALIGNMENT_CENTER );
    line_variables = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -850.0, 900.0, 0.0, black,
 		180.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_variables = new ShapeText(
        SHAPE_DRAW_2D, true,-789.0, 881.0, 0.0, 0.0,
        black,"DLR factors",
        _txt_variables_Font, ALIGNMENT_LEFT );
    txt_forecastLengths = new ShapeText(
        SHAPE_DRAW_2D, true,-343.0, 647.0, 0.0, 0.0,
        black,"Forecasts lengths",
        _txt_forecastLengths_Font, ALIGNMENT_CENTER );
    line_initialization = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 680.0, 30.0, 0.0, black,
 		240.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_initialization = new ShapeText(
        SHAPE_DRAW_2D, true,800.0, 10.0, 0.0, 0.0,
        black,"Initialization",
        _txt_initialization_Font, ALIGNMENT_CENTER );
    line_UI_visualisationAgens = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 381.0, 320.0, 0.0, black,
 		180.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_UI_visualisationAgens = new ShapeText(
        SHAPE_DRAW_2D, true,407.0, 302.0, 0.0, 0.0,
        black,"UI & Visualisation agents",
        _txt_UI_visualisationAgens_Font, ALIGNMENT_LEFT );
    line10 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 1620.0, 530.0, 0.0, black,
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text12 = new ShapeText(
        SHAPE_DRAW_2D, true,1710.0, 510.0, 0.0, 0.0,
        black,"Getters",
        _text12_Font, ALIGNMENT_CENTER );
    line_forecastLengths = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -430.0, 665.0, 0.0, black,
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line11 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 1620.0, 340.0, 0.0, black,
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text14 = new ShapeText(
        SHAPE_DRAW_2D, true,1710.0, 320.0, 0.0, 0.0,
        black,"Adders",
        _text14_Font, ALIGNMENT_CENTER );
    txt_Forecasters = new ShapeText(
        SHAPE_DRAW_2D, true,-860.0, 642.0, 0.0, 0.0,
        black,"Forecasters:",
        _txt_Forecasters_Font, ALIGNMENT_LEFT );
    txt_simulationEngine = new ShapeText(
        SHAPE_DRAW_2D, true,1150.0, 10.0, 0.0, 0.0,
        black,"Simulation engine",
        _txt_simulationEngine_Font, ALIGNMENT_CENTER );
    line_simulationEngine = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 1050.0, 30.0, 0.0, black,
 		220.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_updateFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,1710.0, 220.0, 0.0, 0.0,
        black,"Update functions",
        _txt_updateFunctions_Font, ALIGNMENT_CENTER );
    line_updateFunctions = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 1620.0, 240.0, 0.0, black,
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_energyModelState = new ShapeText(
        SHAPE_DRAW_2D, true,100.0, 720.0, 0.0, 0.0,
        black,"EnergyModel Data",
        _txt_energyModelState_Font, ALIGNMENT_LEFT );
    line_energyModelState = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 60.0, 740.0, 0.0, black,
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    rect_output2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 980.0, 0.0, 0.0,
            red, white,
			900.0, 440.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_rapidRunTimeProfiling = new ShapeText(
        SHAPE_DRAW_2D, true,1143.0, 598.0, 0.0, 0.0,
        black,"Rapid Run Time Profiling",
        _txt_rapidRunTimeProfiling_Font, ALIGNMENT_CENTER );
    line_rapidRunTimeProfiling = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 1040.0, 620.0, 0.0, black,
 		220.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    rect_output3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 980.0, 0.0, 0.0,
            red, white,
			180.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_outputs = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 990.0, 0.0, 0.0,
        red,"Outputs\n",
        _txt_outputs_Font, ALIGNMENT_LEFT );
    line_timeParametersAndVariables = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 1050.0, 370.0, 0.0, black,
 		220.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_timeParametersAndVariables = new ShapeText(
        SHAPE_DRAW_2D, true,1150.0, 350.0, 0.0, 0.0,
        black,"Time variables",
        _txt_timeParametersAndVariables_Font, ALIGNMENT_CENTER );
    rect_parametersAndProfiles1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-880.0, 0.0, 0.0, 0.0,
            green, white,
			780.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_additionalData = new ShapeText(
        SHAPE_DRAW_2D, true,-370.0, 445.0, 0.0, 0.0,
        black,"Data:",
        _txt_additionalData_Font, ALIGNMENT_LEFT );
    txt_simulationSettings = new ShapeText(
        SHAPE_DRAW_2D, true,-380.0, 60.0, 0.0, 0.0,
        black,"Simulation settings:",
        _txt_simulationSettings_Font, ALIGNMENT_LEFT );
    txt_timeParameters1 = new ShapeText(
        SHAPE_DRAW_2D, true,-630.0, 60.0, 0.0, 0.0,
        black,"Time parameters:",
        _txt_timeParameters1_Font, ALIGNMENT_LEFT );
    txt_projectParameters = new ShapeText(
        SHAPE_DRAW_2D, true,-850.0, 60.0, 0.0, 0.0,
        black,"Project parameters:",
        _txt_projectParameters_Font, ALIGNMENT_LEFT );
    txt_loopSimulationFunctionality = new ShapeText(
        SHAPE_DRAW_2D, true,1720.0, 30.0, 0.0, 0.0,
        black,"Loop simulation functionality",
        _txt_loopSimulationFunctionality_Font, ALIGNMENT_CENTER );
    line_updateFunctions1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 1630.0, 50.0, 0.0, black,
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_checkFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,1710.0, 130.0, 0.0, 0.0,
        black,"Check functions",
        _txt_checkFunctions_Font, ALIGNMENT_CENTER );
    line_checkFunctions = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 1620.0, 150.0, 0.0, black,
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
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
  public EnergyModel( Engine engine, Agent owner, AgentList<? extends EnergyModel> ownerPopulation ) {
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
    energyDataViewer = instantiate_energyDataViewer_xjal();
    nationalEnergyMarket = instantiate_nationalEnergyMarket_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public EnergyModel() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public EnergyModel( boolean b_parallelizeConnectionOwners, boolean b_parallelizeGridConnections, double p_tempForecastTime_h, TextFile p_truckTripsCsv, TextFile p_householdTripsCsv, TextFile p_cookingPatternCsv, J_AVGC_data avgc_data, boolean b_enableDLR, boolean b_isInitialized, boolean b_storePreviousRapidRunData, String p_regionName, boolean b_isDeserialised, J_TimeVariables p_timeVariables, J_TimeParameters p_timeParameters, double p_pvForecastTime_h, double p_windForecastTime_h, double p_epexForecastTime_h, double p_CO2EmissionFactorForecastTime_h ) {
    markParametersAreSet();
    this.b_parallelizeConnectionOwners = b_parallelizeConnectionOwners;
    this.b_parallelizeGridConnections = b_parallelizeGridConnections;
    this.p_tempForecastTime_h = p_tempForecastTime_h;
    this.p_truckTripsCsv = p_truckTripsCsv;
    this.p_householdTripsCsv = p_householdTripsCsv;
    this.p_cookingPatternCsv = p_cookingPatternCsv;
    this.avgc_data = avgc_data;
    this.b_enableDLR = b_enableDLR;
    this.b_isInitialized = b_isInitialized;
    this.b_storePreviousRapidRunData = b_storePreviousRapidRunData;
    this.p_regionName = p_regionName;
    this.b_isDeserialised = b_isDeserialised;
    this.p_timeVariables = p_timeVariables;
    this.p_timeParameters = p_timeParameters;
    this.p_pvForecastTime_h = p_pvForecastTime_h;
    this.p_windForecastTime_h = p_windForecastTime_h;
    this.p_epexForecastTime_h = p_epexForecastTime_h;
    this.p_CO2EmissionFactorForecastTime_h = p_CO2EmissionFactorForecastTime_h;
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
    setupPlainVariables_EnergyModel_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
	_initialize_level1_xjal();
    level.initialize();
    level1.initialize();
    presentation = new ShapeTopLevelPresentationGroup( EnergyModel.this, true, 0, 0, 0, 0 , level, level1 );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( EnergyModel.this, getElementProperty( "zero_engine.EnergyModel.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
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
    setupParameters_energyDataViewer_xjal( energyDataViewer, null );
    doBeforeCreate_energyDataViewer_xjal( energyDataViewer, null );
    energyDataViewer.createAsEmbedded();
    setupParameters_nationalEnergyMarket_xjal( nationalEnergyMarket, null );
    doBeforeCreate_nationalEnergyMarket_xjal( nationalEnergyMarket, null );
    nationalEnergyMarket.createAsEmbedded();
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    pop_gridNodes.setEnvironment( this );
    for ( int i = 0; i < pop_gridNodes.size(); i++ ) {
      GridNode _a = pop_gridNodes.get(i);
      setupParameters_pop_gridNodes_xjal( _a, i, null );
      doBeforeCreate_pop_gridNodes_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < pop_gridConnections.size(); i++ ) {
      GridConnection _a = pop_gridConnections.get(i);
      setupParameters_pop_gridConnections_xjal( _a, i, null );
      doBeforeCreate_pop_gridConnections_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < pop_connectionOwners.size(); i++ ) {
      ConnectionOwner _a = pop_connectionOwners.get(i);
      setupParameters_pop_connectionOwners_xjal( _a, i, null );
      doBeforeCreate_pop_connectionOwners_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < pop_energySuppliers.size(); i++ ) {
      EnergySupplier _a = pop_energySuppliers.get(i);
      setupParameters_pop_energySuppliers_xjal( _a, i, null );
      doBeforeCreate_pop_energySuppliers_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < pop_energyCoops.size(); i++ ) {
      EnergyCoop _a = pop_energyCoops.get(i);
      setupParameters_pop_energyCoops_xjal( _a, i, null );
      doBeforeCreate_pop_energyCoops_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < pop_gridOperators.size(); i++ ) {
      GridOperator _a = pop_gridOperators.get(i);
      setupParameters_pop_gridOperators_xjal( _a, i, null );
      doBeforeCreate_pop_gridOperators_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < Houses.size(); i++ ) {
      GCHouse _a = Houses.get(i);
      setupParameters_Houses_xjal( _a, i, null );
      doBeforeCreate_Houses_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < DistrictHeatingSystems.size(); i++ ) {
      GCDistrictHeating _a = DistrictHeatingSystems.get(i);
      setupParameters_DistrictHeatingSystems_xjal( _a, i, null );
      doBeforeCreate_DistrictHeatingSystems_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < EnergyProductionSites.size(); i++ ) {
      GCEnergyProduction _a = EnergyProductionSites.get(i);
      setupParameters_EnergyProductionSites_xjal( _a, i, null );
      doBeforeCreate_EnergyProductionSites_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < EnergyConversionSites.size(); i++ ) {
      GCEnergyConversion _a = EnergyConversionSites.get(i);
      setupParameters_EnergyConversionSites_xjal( _a, i, null );
      doBeforeCreate_EnergyConversionSites_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < UtilityConnections.size(); i++ ) {
      GCUtility _a = UtilityConnections.get(i);
      setupParameters_UtilityConnections_xjal( _a, i, null );
      doBeforeCreate_UtilityConnections_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    for ( int i = 0; i < GridBatteries.size(); i++ ) {
      GCGridBattery _a = GridBatteries.get(i);
      setupParameters_GridBatteries_xjal( _a, i, null );
      doBeforeCreate_GridBatteries_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    pop_GIS_Buildings.setEnvironment( this );
    for ( int i = 0; i < pop_GIS_Buildings.size(); i++ ) {
      GIS_Building _a = pop_GIS_Buildings.get(i);
      setupParameters_pop_GIS_Buildings_xjal( _a, i, null );
      doBeforeCreate_pop_GIS_Buildings_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    pop_GIS_Objects.setEnvironment( this );
    for ( int i = 0; i < pop_GIS_Objects.size(); i++ ) {
      GIS_Object _a = pop_GIS_Objects.get(i);
      setupParameters_pop_GIS_Objects_xjal( _a, i, null );
      doBeforeCreate_pop_GIS_Objects_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    pop_GIS_Parcels.setEnvironment( this );
    for ( int i = 0; i < pop_GIS_Parcels.size(); i++ ) {
      GIS_Parcel _a = pop_GIS_Parcels.get(i);
      setupParameters_pop_GIS_Parcels_xjal( _a, i, null );
      doBeforeCreate_pop_GIS_Parcels_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    PublicChargers.setEnvironment( this );
    for ( int i = 0; i < PublicChargers.size(); i++ ) {
      GCPublicCharger _a = PublicChargers.get(i);
      setupParameters_PublicChargers_xjal( _a, i, null );
      doBeforeCreate_PublicChargers_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    Neighborhoods.setEnvironment( this );
    for ( int i = 0; i < Neighborhoods.size(); i++ ) {
      GCNeighborhood _a = Neighborhoods.get(i);
      setupParameters_Neighborhoods_xjal( _a, i, null );
      doBeforeCreate_Neighborhoods_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    setupInitialConditions_xjal( EnergyModel.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    for (Agent embeddedObject : pop_gridNodes) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_gridConnections) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_connectionOwners) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_energySuppliers) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_energyCoops) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_gridOperators) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : Houses) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : DistrictHeatingSystems) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : EnergyProductionSites) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : EnergyConversionSites) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : UtilityConnections) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : GridBatteries) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_GIS_Buildings) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_GIS_Objects) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_GIS_Parcels) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : PublicChargers) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : Neighborhoods) {
      embeddedObject.startAsEmbedded();
    }
    energyDataViewer.startAsEmbedded();
    nationalEnergyMarket.startAsEmbedded();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

v_liveData = new J_LiveData();
v_liveData.activeEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeProductionEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeConsumptionEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveConnectionMetaData = new J_ConnectionMetaData(this);
v_liveAssetsMetaData = new J_AssetsMetaData(this);
v_liveData.connectionMetaData = v_liveConnectionMetaData;
v_liveData.assetsMetaData = v_liveAssetsMetaData;

fm_currentProductionFlows_kW = new J_FlowsMap();
fm_currentConsumptionFlows_kW = new J_FlowsMap();
fm_currentBalanceFlows_kW = new J_FlowsMap();
fm_heatFromEnergyCarrier_kW = new J_FlowsMap();
fm_consumptionForHeating_kW = new J_FlowsMap();
fm_currentAssetFlows_kW = new J_ValueMap(OL_AssetFlowCategories.class); 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_EnergyModel_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_EnergyModel_xjal() {
    v_timeStepsElapsed = 
0 
;
    v_modelSelfSufficiency_fr = 
0 
;
    v_modelSelfConsumption_fr = 
0 
;
    v_isRapidRun = 
false 
;
    v_batteryStoredEnergyDeltaSinceStart_MWh = 
0 
;
    v_totalEnergyProduced_MWh = 
0 
;
    v_totalEnergySelfConsumed_MWh = 
0 
;
    v_totalElectricityConsumed_MWh = 
0 
;
    v_totalElectricityProduced_MWh = 
0 
;
    v_totalElectricitySelfConsumed_MWh = 
0 
;
    v_individualSelfConsumption_fr = 
0 
;
    v_collectiveSelfConsumption_fr = 
0 
;
    v_individualSelfSufficiency_fr = 
0 
;
    v_kpiCalcsRuntime_ms = 
0 
;
    v_currentDLRfactor_fr = 
1.0 
;
    v_minDLRfactor_fr = 
2 
;
    v_maxDLRfactor_fr = 
1 
;
    v_totalEnergyImport_MWh = 
0 
;
    v_totalEnergyExport_MWh = 
0 
;
    v_totalEnergyConsumed_MWh = 
0 
;
    v_previousRunData = 
null 
;
    v_liveSimLoopCount = 
0 
;
    map_nrOfResidentsToDHWprofiles = 
new HashMap<>() 
;
  }

  // User API -----------------------------------------------------
  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<>();
    }
    list.add( pop_gridNodes );
    list.add( pop_gridConnections );
    list.add( energyDataViewer );
    list.add( pop_connectionOwners );
    list.add( pop_energySuppliers );
    list.add( pop_energyCoops );
    list.add( pop_gridOperators );
    list.add( nationalEnergyMarket );
    list.add( Houses );
    list.add( DistrictHeatingSystems );
    list.add( EnergyProductionSites );
    list.add( EnergyConversionSites );
    list.add( UtilityConnections );
    list.add( GridBatteries );
    list.add( pop_GIS_Buildings );
    list.add( pop_GIS_Objects );
    list.add( pop_GIS_Parcels );
    list.add( PublicChargers );
    list.add( Neighborhoods );
    return list;
  }

  public AgentList<? extends EnergyModel> getPopulation() {
    return (AgentList<? extends EnergyModel>) super.getPopulation();
  }

  public List<? extends EnergyModel> agentsInRange( double distance ) {
    return (List<? extends EnergyModel>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    for (Agent _item : pop_gridNodes) {
      _item.onDestroy();
    }
    for (Agent _item : pop_gridConnections) {
      _item.onDestroy();
    }
    energyDataViewer.onDestroy();
    for (Agent _item : pop_connectionOwners) {
      _item.onDestroy();
    }
    for (Agent _item : pop_energySuppliers) {
      _item.onDestroy();
    }
    for (Agent _item : pop_energyCoops) {
      _item.onDestroy();
    }
    for (Agent _item : pop_gridOperators) {
      _item.onDestroy();
    }
    nationalEnergyMarket.onDestroy();
    for (Agent _item : Houses) {
      _item.onDestroy();
    }
    for (Agent _item : DistrictHeatingSystems) {
      _item.onDestroy();
    }
    for (Agent _item : EnergyProductionSites) {
      _item.onDestroy();
    }
    for (Agent _item : EnergyConversionSites) {
      _item.onDestroy();
    }
    for (Agent _item : UtilityConnections) {
      _item.onDestroy();
    }
    for (Agent _item : GridBatteries) {
      _item.onDestroy();
    }
    for (Agent _item : pop_GIS_Buildings) {
      _item.onDestroy();
    }
    for (Agent _item : pop_GIS_Objects) {
      _item.onDestroy();
    }
    for (Agent _item : pop_GIS_Parcels) {
      _item.onDestroy();
    }
    for (Agent _item : PublicChargers) {
      _item.onDestroy();
    }
    for (Agent _item : Neighborhoods) {
      _item.onDestroy();
    }
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    for (Agent _item : pop_gridNodes) {
      _item.doFinish();
    }
    for (Agent _item : pop_gridConnections) {
      _item.doFinish();
    }
    energyDataViewer.doFinish();
    for (Agent _item : pop_connectionOwners) {
      _item.doFinish();
    }
    for (Agent _item : pop_energySuppliers) {
      _item.doFinish();
    }
    for (Agent _item : pop_energyCoops) {
      _item.doFinish();
    }
    for (Agent _item : pop_gridOperators) {
      _item.doFinish();
    }
    nationalEnergyMarket.doFinish();
    for (Agent _item : Houses) {
      _item.doFinish();
    }
    for (Agent _item : DistrictHeatingSystems) {
      _item.doFinish();
    }
    for (Agent _item : EnergyProductionSites) {
      _item.doFinish();
    }
    for (Agent _item : EnergyConversionSites) {
      _item.doFinish();
    }
    for (Agent _item : UtilityConnections) {
      _item.doFinish();
    }
    for (Agent _item : GridBatteries) {
      _item.doFinish();
    }
    for (Agent _item : pop_GIS_Buildings) {
      _item.doFinish();
    }
    for (Agent _item : pop_GIS_Objects) {
      _item.doFinish();
    }
    for (Agent _item : pop_GIS_Parcels) {
      _item.doFinish();
    }
    for (Agent _item : PublicChargers) {
      _item.doFinish();
    }
    for (Agent _item : Neighborhoods) {
      _item.doFinish();
    }
  }

  // Additional class code

public OL_ResultScope getScope(){return OL_ResultScope.ENERGYMODEL;}
public J_RapidRunData getRapidRunData(){return v_rapidRunData;}
public J_LiveData getLiveData(){return v_liveData;}
public J_RapidRunData getPreviousRapidRunData(){return v_previousRunData;}

public static void forceSetOwner(Agent agent, AgentArrayList pop) throws Exception {
	Agent owner = pop.getOwner();
    Field f = Agent.class.getDeclaredField("d");
    f.setAccessible(true);
    f.set(agent, owner);
    Field ff = Agent.class.getDeclaredField("j");
    ff.setAccessible(true);
    ff.set(agent, pop);
    /*Field c = Agent.class.getDeclaredField("c");
    traceln("Field c: %s", c);
    c.setAccessible(true);
    c.toString();*/
} 
  // End of additional class code

}
