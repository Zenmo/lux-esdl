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

import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.lang.reflect.Field;
import org.apache.commons.lang3.tuple.Triple;
import zeroPackage.ZeroMath;
import javax.management.RuntimeErrorException;

//@JsonIgnoreProperties({"va_gridConnection","_origin_VA","_pl_powerFlows_autoUpdateEvent_xjal","_SOC_plot_autoUpdateEvent_xjal"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id") 

public class GridConnection extends Agent
        implements 
I_EnergyData, I_AssetOwner 
{
  // Parameters

  public 
String  p_parentNodeElectricID;

  /**
   * Returns default value for parameter <code>p_parentNodeElectricID</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_parentNodeElectricID_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_parentNodeElectricID( String value ) {
    if (value == this.p_parentNodeElectricID) {
      return;
    }
    String _oldValue_xjal = this.p_parentNodeElectricID;
    this.p_parentNodeElectricID = value;
    onChange_p_parentNodeElectricID_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_parentNodeElectricID.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_parentNodeElectricID()</code> method instead.
   */
  protected void onChange_p_parentNodeElectricID() {
    onChange_p_parentNodeElectricID_xjal( p_parentNodeElectricID );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_parentNodeElectricID_xjal( String oldValue ) {  
  }


  public 
String  p_gridConnectionID;

  /**
   * Returns default value for parameter <code>p_gridConnectionID</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_gridConnectionID_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_gridConnectionID( String value ) {
    if (value == this.p_gridConnectionID) {
      return;
    }
    String _oldValue_xjal = this.p_gridConnectionID;
    this.p_gridConnectionID = value;
    onChange_p_gridConnectionID_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_gridConnectionID.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_gridConnectionID()</code> method instead.
   */
  protected void onChange_p_gridConnectionID() {
    onChange_p_gridConnectionID_xjal( p_gridConnectionID );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_gridConnectionID_xjal( String oldValue ) {  
  }


  public 
String  p_parentNodeHeatID;

  /**
   * Returns default value for parameter <code>p_parentNodeHeatID</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_parentNodeHeatID_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_parentNodeHeatID( String value ) {
    if (value == this.p_parentNodeHeatID) {
      return;
    }
    String _oldValue_xjal = this.p_parentNodeHeatID;
    this.p_parentNodeHeatID = value;
    onChange_p_parentNodeHeatID_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_parentNodeHeatID.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_parentNodeHeatID()</code> method instead.
   */
  protected void onChange_p_parentNodeHeatID() {
    onChange_p_parentNodeHeatID_xjal( p_parentNodeHeatID );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_parentNodeHeatID_xjal( String oldValue ) {  
  }


  public 
J_EABuilding  p_BuildingThermalAsset;

  /**
   * Returns default value for parameter <code>p_BuildingThermalAsset</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_EABuilding _p_BuildingThermalAsset_DefaultValue_xjal() {
    final GridConnection self = this;
    return 
null 
;
  }

  public void set_p_BuildingThermalAsset( J_EABuilding value ) {
    if (value == this.p_BuildingThermalAsset) {
      return;
    }
    J_EABuilding _oldValue_xjal = this.p_BuildingThermalAsset;
    this.p_BuildingThermalAsset = value;
    onChange_p_BuildingThermalAsset_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_BuildingThermalAsset.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_BuildingThermalAsset()</code> method instead.
   */
  protected void onChange_p_BuildingThermalAsset() {
    onChange_p_BuildingThermalAsset_xjal( p_BuildingThermalAsset );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_BuildingThermalAsset_xjal( J_EABuilding oldValue ) {  
  }


  public 
String  p_ownerID;

  /**
   * Returns default value for parameter <code>p_ownerID</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_ownerID_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_ownerID( String value ) {
    if (value == this.p_ownerID) {
      return;
    }
    String _oldValue_xjal = this.p_ownerID;
    this.p_ownerID = value;
    onChange_p_ownerID_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_ownerID.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_ownerID()</code> method instead.
   */
  protected void onChange_p_ownerID() {
    onChange_p_ownerID_xjal( p_ownerID );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_ownerID_xjal( String oldValue ) {  
  }


  public 
J_EAStorageElectric  p_batteryAsset;

  /**
   * Returns default value for parameter <code>p_batteryAsset</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_EAStorageElectric _p_batteryAsset_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_batteryAsset( J_EAStorageElectric value ) {
    if (value == this.p_batteryAsset) {
      return;
    }
    J_EAStorageElectric _oldValue_xjal = this.p_batteryAsset;
    this.p_batteryAsset = value;
    onChange_p_batteryAsset_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_batteryAsset.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_batteryAsset()</code> method instead.
   */
  protected void onChange_p_batteryAsset() {
    onChange_p_batteryAsset_xjal( p_batteryAsset );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_batteryAsset_xjal( J_EAStorageElectric oldValue ) {  
  }


  public 
J_EAStorageHeat  p_heatBuffer;

  /**
   * Returns default value for parameter <code>p_heatBuffer</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_EAStorageHeat _p_heatBuffer_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_heatBuffer( J_EAStorageHeat value ) {
    if (value == this.p_heatBuffer) {
      return;
    }
    J_EAStorageHeat _oldValue_xjal = this.p_heatBuffer;
    this.p_heatBuffer = value;
    onChange_p_heatBuffer_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_heatBuffer.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_heatBuffer()</code> method instead.
   */
  protected void onChange_p_heatBuffer() {
    onChange_p_heatBuffer_xjal( p_heatBuffer );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_heatBuffer_xjal( J_EAStorageHeat oldValue ) {  
  }


  public 
J_EAStorageGas  p_gasBuffer;

  /**
   * Returns default value for parameter <code>p_gasBuffer</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_EAStorageGas _p_gasBuffer_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_gasBuffer( J_EAStorageGas value ) {
    if (value == this.p_gasBuffer) {
      return;
    }
    J_EAStorageGas _oldValue_xjal = this.p_gasBuffer;
    this.p_gasBuffer = value;
    onChange_p_gasBuffer_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_gasBuffer.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_gasBuffer()</code> method instead.
   */
  protected void onChange_p_gasBuffer() {
    onChange_p_gasBuffer_xjal( p_gasBuffer );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_gasBuffer_xjal( J_EAStorageGas oldValue ) {  
  }


  public 
J_ActivityTrackerCooking  p_cookingTracker;

  /**
   * Returns default value for parameter <code>p_cookingTracker</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_ActivityTrackerCooking _p_cookingTracker_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_cookingTracker( J_ActivityTrackerCooking value ) {
    if (value == this.p_cookingTracker) {
      return;
    }
    J_ActivityTrackerCooking _oldValue_xjal = this.p_cookingTracker;
    this.p_cookingTracker = value;
    onChange_p_cookingTracker_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_cookingTracker.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_cookingTracker()</code> method instead.
   */
  protected void onChange_p_cookingTracker() {
    onChange_p_cookingTracker_xjal( p_cookingTracker );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_cookingTracker_xjal( J_ActivityTrackerCooking oldValue ) {  
  }


  public 
OL_GridConnectionInsulationLabel  p_insulationLabel;

  /**
   * Returns default value for parameter <code>p_insulationLabel</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_GridConnectionInsulationLabel _p_insulationLabel_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_insulationLabel( OL_GridConnectionInsulationLabel value ) {
    if (value == this.p_insulationLabel) {
      return;
    }
    OL_GridConnectionInsulationLabel _oldValue_xjal = this.p_insulationLabel;
    this.p_insulationLabel = value;
    onChange_p_insulationLabel_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_insulationLabel.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_insulationLabel()</code> method instead.
   */
  protected void onChange_p_insulationLabel() {
    onChange_p_insulationLabel_xjal( p_insulationLabel );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_insulationLabel_xjal( OL_GridConnectionInsulationLabel oldValue ) {  
  }


  public 
J_EAProfile  p_DHWAsset;

  /**
   * Returns default value for parameter <code>p_DHWAsset</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_EAProfile _p_DHWAsset_DefaultValue_xjal() {
    final GridConnection self = this;
    return 
null 
;
  }

  public void set_p_DHWAsset( J_EAProfile value ) {
    if (value == this.p_DHWAsset) {
      return;
    }
    J_EAProfile _oldValue_xjal = this.p_DHWAsset;
    this.p_DHWAsset = value;
    onChange_p_DHWAsset_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_DHWAsset.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_DHWAsset()</code> method instead.
   */
  protected void onChange_p_DHWAsset() {
    onChange_p_DHWAsset_xjal( p_DHWAsset );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_DHWAsset_xjal( J_EAProfile oldValue ) {  
  }


  public 
double  p_longitude;

  /**
   * Returns default value for parameter <code>p_longitude</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_longitude_DefaultValue_xjal() {
    final GridConnection self = this;
    return 0.0;
  }

  public void set_p_longitude( double value ) {
    if (value == this.p_longitude) {
      return;
    }
    double _oldValue_xjal = this.p_longitude;
    this.p_longitude = value;
    onChange_p_longitude_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_longitude.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_longitude()</code> method instead.
   */
  protected void onChange_p_longitude() {
    onChange_p_longitude_xjal( p_longitude );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_longitude_xjal( double oldValue ) {  
  }


  public 
double  p_latitude;

  /**
   * Returns default value for parameter <code>p_latitude</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_latitude_DefaultValue_xjal() {
    final GridConnection self = this;
    return 0.0;
  }

  public void set_p_latitude( double value ) {
    if (value == this.p_latitude) {
      return;
    }
    double _oldValue_xjal = this.p_latitude;
    this.p_latitude = value;
    onChange_p_latitude_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_latitude.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_latitude()</code> method instead.
   */
  protected void onChange_p_latitude() {
    onChange_p_latitude_xjal( p_latitude );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_latitude_xjal( double oldValue ) {  
  }


  public 
double  p_floorSurfaceArea_m2;

  /**
   * Returns default value for parameter <code>p_floorSurfaceArea_m2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_floorSurfaceArea_m2_DefaultValue_xjal() {
    final GridConnection self = this;
    return 0.0;
  }

  public void set_p_floorSurfaceArea_m2( double value ) {
    if (value == this.p_floorSurfaceArea_m2) {
      return;
    }
    double _oldValue_xjal = this.p_floorSurfaceArea_m2;
    this.p_floorSurfaceArea_m2 = value;
    onChange_p_floorSurfaceArea_m2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_floorSurfaceArea_m2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_floorSurfaceArea_m2()</code> method instead.
   */
  protected void onChange_p_floorSurfaceArea_m2() {
    onChange_p_floorSurfaceArea_m2_xjal( p_floorSurfaceArea_m2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_floorSurfaceArea_m2_xjal( double oldValue ) {  
  }


  public 
ConnectionOwner  p_owner;

  /**
   * Returns default value for parameter <code>p_owner</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ConnectionOwner _p_owner_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_owner( ConnectionOwner value ) {
    if (value == this.p_owner) {
      return;
    }
    ConnectionOwner _oldValue_xjal = this.p_owner;
    this.p_owner = value;
    onChange_p_owner_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_owner.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_owner()</code> method instead.
   */
  protected void onChange_p_owner() {
    onChange_p_owner_xjal( p_owner );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_owner_xjal( ConnectionOwner oldValue ) {  
  }


  public 
double  p_roofSurfaceArea_m2;

  /**
   * Returns default value for parameter <code>p_roofSurfaceArea_m2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_roofSurfaceArea_m2_DefaultValue_xjal() {
    final GridConnection self = this;
    return 0.0;
  }

  public void set_p_roofSurfaceArea_m2( double value ) {
    if (value == this.p_roofSurfaceArea_m2) {
      return;
    }
    double _oldValue_xjal = this.p_roofSurfaceArea_m2;
    this.p_roofSurfaceArea_m2 = value;
    onChange_p_roofSurfaceArea_m2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_roofSurfaceArea_m2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_roofSurfaceArea_m2()</code> method instead.
   */
  protected void onChange_p_roofSurfaceArea_m2() {
    onChange_p_roofSurfaceArea_m2_xjal( p_roofSurfaceArea_m2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_roofSurfaceArea_m2_xjal( double oldValue ) {  
  }


  public 
String  p_purposeBAG;

  /**
   * Returns default value for parameter <code>p_purposeBAG</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_purposeBAG_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_purposeBAG( String value ) {
    if (value == this.p_purposeBAG) {
      return;
    }
    String _oldValue_xjal = this.p_purposeBAG;
    this.p_purposeBAG = value;
    onChange_p_purposeBAG_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_purposeBAG.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_purposeBAG()</code> method instead.
   */
  protected void onChange_p_purposeBAG() {
    onChange_p_purposeBAG_xjal( p_purposeBAG );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_purposeBAG_xjal( String oldValue ) {  
  }


  /**
   * A Java class that contains all the relevant information about the grid connection address. The class contains a method .getAddress() which returns a formatted String of the address.
   */
  public 
J_Address  p_address;

  /**
   * Returns default value for parameter <code>p_address</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_Address _p_address_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_address( J_Address value ) {
    if (value == this.p_address) {
      return;
    }
    J_Address _oldValue_xjal = this.p_address;
    this.p_address = value;
    onChange_p_address_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_address.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_address()</code> method instead.
   */
  protected void onChange_p_address() {
    onChange_p_address_xjal( p_address );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_address_xjal( J_Address oldValue ) {  
  }


  public 
GridNode  p_parentNodeHeat;

  /**
   * Returns default value for parameter <code>p_parentNodeHeat</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public GridNode _p_parentNodeHeat_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_parentNodeHeat( GridNode value ) {
    if (value == this.p_parentNodeHeat) {
      return;
    }
    GridNode _oldValue_xjal = this.p_parentNodeHeat;
    this.p_parentNodeHeat = value;
    onChange_p_parentNodeHeat_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_parentNodeHeat.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_parentNodeHeat()</code> method instead.
   */
  protected void onChange_p_parentNodeHeat() {
    onChange_p_parentNodeHeat_xjal( p_parentNodeHeat );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_parentNodeHeat_xjal( GridNode oldValue ) {  
  }


  public 
GridNode  p_parentNodeElectric;

  /**
   * Returns default value for parameter <code>p_parentNodeElectric</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public GridNode _p_parentNodeElectric_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_parentNodeElectric( GridNode value ) {
    if (value == this.p_parentNodeElectric) {
      return;
    }
    GridNode _oldValue_xjal = this.p_parentNodeElectric;
    this.p_parentNodeElectric = value;
    onChange_p_parentNodeElectric_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_parentNodeElectric.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_parentNodeElectric()</code> method instead.
   */
  protected void onChange_p_parentNodeElectric() {
    onChange_p_parentNodeElectric_xjal( p_parentNodeElectric );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_parentNodeElectric_xjal( GridNode oldValue ) {  
  }


  public 
boolean  v_isActive;

  /**
   * Returns default value for parameter <code>v_isActive</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _v_isActive_DefaultValue_xjal() {
    final GridConnection self = this;
    return 
true 
;
  }

  public void set_v_isActive( boolean value ) {
    if (value == this.v_isActive) {
      return;
    }
    boolean _oldValue_xjal = this.v_isActive;
    this.v_isActive = value;
    onChange_v_isActive_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter v_isActive.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_v_isActive()</code> method instead.
   */
  protected void onChange_v_isActive() {
    onChange_v_isActive_xjal( v_isActive );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_v_isActive_xjal( boolean oldValue ) {  
  }


  public 
OL_GridConnectionEnergyLabel  p_energyLabel;

  /**
   * Returns default value for parameter <code>p_energyLabel</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_GridConnectionEnergyLabel _p_energyLabel_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_energyLabel( OL_GridConnectionEnergyLabel value ) {
    if (value == this.p_energyLabel) {
      return;
    }
    OL_GridConnectionEnergyLabel _oldValue_xjal = this.p_energyLabel;
    this.p_energyLabel = value;
    onChange_p_energyLabel_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_energyLabel.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_energyLabel()</code> method instead.
   */
  protected void onChange_p_energyLabel() {
    onChange_p_energyLabel_xjal( p_energyLabel );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_energyLabel_xjal( OL_GridConnectionEnergyLabel oldValue ) {  
  }


  public 
J_EAConversionAirConditioner  p_airco;

  /**
   * Returns default value for parameter <code>p_airco</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_EAConversionAirConditioner _p_airco_DefaultValue_xjal() {
    final GridConnection self = this;
    return null;
  }

  public void set_p_airco( J_EAConversionAirConditioner value ) {
    if (value == this.p_airco) {
      return;
    }
    J_EAConversionAirConditioner _oldValue_xjal = this.p_airco;
    this.p_airco = value;
    onChange_p_airco_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_airco.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_airco()</code> method instead.
   */
  protected void onChange_p_airco() {
    onChange_p_airco_xjal( p_airco );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_airco_xjal( J_EAConversionAirConditioner oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_parentNodeElectricID = _p_parentNodeElectricID_DefaultValue_xjal();
    p_gridConnectionID = _p_gridConnectionID_DefaultValue_xjal();
    p_parentNodeHeatID = _p_parentNodeHeatID_DefaultValue_xjal();
    p_BuildingThermalAsset = _p_BuildingThermalAsset_DefaultValue_xjal();
    p_ownerID = _p_ownerID_DefaultValue_xjal();
    p_batteryAsset = _p_batteryAsset_DefaultValue_xjal();
    p_heatBuffer = _p_heatBuffer_DefaultValue_xjal();
    p_gasBuffer = _p_gasBuffer_DefaultValue_xjal();
    p_cookingTracker = _p_cookingTracker_DefaultValue_xjal();
    p_insulationLabel = _p_insulationLabel_DefaultValue_xjal();
    p_DHWAsset = _p_DHWAsset_DefaultValue_xjal();
    p_longitude = _p_longitude_DefaultValue_xjal();
    p_latitude = _p_latitude_DefaultValue_xjal();
    p_floorSurfaceArea_m2 = _p_floorSurfaceArea_m2_DefaultValue_xjal();
    p_owner = _p_owner_DefaultValue_xjal();
    p_roofSurfaceArea_m2 = _p_roofSurfaceArea_m2_DefaultValue_xjal();
    p_purposeBAG = _p_purposeBAG_DefaultValue_xjal();
    p_address = _p_address_DefaultValue_xjal();
    p_parentNodeHeat = _p_parentNodeHeat_DefaultValue_xjal();
    p_parentNodeElectric = _p_parentNodeElectric_DefaultValue_xjal();
    v_isActive = _v_isActive_DefaultValue_xjal();
    p_energyLabel = _p_energyLabel_DefaultValue_xjal();
    p_airco = _p_airco_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_parentNodeElectricID":
      if ( _callOnChange_xjal ) {
        set_p_parentNodeElectricID( (String) _value_xjal );
      } else {
        p_parentNodeElectricID = (String) _value_xjal;
      }
      return true;
    case "p_gridConnectionID":
      if ( _callOnChange_xjal ) {
        set_p_gridConnectionID( (String) _value_xjal );
      } else {
        p_gridConnectionID = (String) _value_xjal;
      }
      return true;
    case "p_parentNodeHeatID":
      if ( _callOnChange_xjal ) {
        set_p_parentNodeHeatID( (String) _value_xjal );
      } else {
        p_parentNodeHeatID = (String) _value_xjal;
      }
      return true;
    case "p_BuildingThermalAsset":
      if ( _callOnChange_xjal ) {
        set_p_BuildingThermalAsset( (J_EABuilding) _value_xjal );
      } else {
        p_BuildingThermalAsset = (J_EABuilding) _value_xjal;
      }
      return true;
    case "p_ownerID":
      if ( _callOnChange_xjal ) {
        set_p_ownerID( (String) _value_xjal );
      } else {
        p_ownerID = (String) _value_xjal;
      }
      return true;
    case "p_batteryAsset":
      if ( _callOnChange_xjal ) {
        set_p_batteryAsset( (J_EAStorageElectric) _value_xjal );
      } else {
        p_batteryAsset = (J_EAStorageElectric) _value_xjal;
      }
      return true;
    case "p_heatBuffer":
      if ( _callOnChange_xjal ) {
        set_p_heatBuffer( (J_EAStorageHeat) _value_xjal );
      } else {
        p_heatBuffer = (J_EAStorageHeat) _value_xjal;
      }
      return true;
    case "p_gasBuffer":
      if ( _callOnChange_xjal ) {
        set_p_gasBuffer( (J_EAStorageGas) _value_xjal );
      } else {
        p_gasBuffer = (J_EAStorageGas) _value_xjal;
      }
      return true;
    case "p_cookingTracker":
      if ( _callOnChange_xjal ) {
        set_p_cookingTracker( (J_ActivityTrackerCooking) _value_xjal );
      } else {
        p_cookingTracker = (J_ActivityTrackerCooking) _value_xjal;
      }
      return true;
    case "p_insulationLabel":
      if ( _callOnChange_xjal ) {
        set_p_insulationLabel( (OL_GridConnectionInsulationLabel) _value_xjal );
      } else {
        p_insulationLabel = (OL_GridConnectionInsulationLabel) _value_xjal;
      }
      return true;
    case "p_DHWAsset":
      if ( _callOnChange_xjal ) {
        set_p_DHWAsset( (J_EAProfile) _value_xjal );
      } else {
        p_DHWAsset = (J_EAProfile) _value_xjal;
      }
      return true;
    case "p_longitude":
      if ( _callOnChange_xjal ) {
        set_p_longitude( ((Number) _value_xjal).doubleValue() );
      } else {
        p_longitude = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_latitude":
      if ( _callOnChange_xjal ) {
        set_p_latitude( ((Number) _value_xjal).doubleValue() );
      } else {
        p_latitude = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_floorSurfaceArea_m2":
      if ( _callOnChange_xjal ) {
        set_p_floorSurfaceArea_m2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_floorSurfaceArea_m2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_owner":
      if ( _callOnChange_xjal ) {
        set_p_owner( (ConnectionOwner) _value_xjal );
      } else {
        p_owner = (ConnectionOwner) _value_xjal;
      }
      return true;
    case "p_roofSurfaceArea_m2":
      if ( _callOnChange_xjal ) {
        set_p_roofSurfaceArea_m2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_roofSurfaceArea_m2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_purposeBAG":
      if ( _callOnChange_xjal ) {
        set_p_purposeBAG( (String) _value_xjal );
      } else {
        p_purposeBAG = (String) _value_xjal;
      }
      return true;
    case "p_address":
      if ( _callOnChange_xjal ) {
        set_p_address( (J_Address) _value_xjal );
      } else {
        p_address = (J_Address) _value_xjal;
      }
      return true;
    case "p_parentNodeHeat":
      if ( _callOnChange_xjal ) {
        set_p_parentNodeHeat( (GridNode) _value_xjal );
      } else {
        p_parentNodeHeat = (GridNode) _value_xjal;
      }
      return true;
    case "p_parentNodeElectric":
      if ( _callOnChange_xjal ) {
        set_p_parentNodeElectric( (GridNode) _value_xjal );
      } else {
        p_parentNodeElectric = (GridNode) _value_xjal;
      }
      return true;
    case "v_isActive":
      if ( _callOnChange_xjal ) {
        set_v_isActive( (Boolean) _value_xjal );
      } else {
        v_isActive = (Boolean) _value_xjal;
      }
      return true;
    case "p_energyLabel":
      if ( _callOnChange_xjal ) {
        set_p_energyLabel( (OL_GridConnectionEnergyLabel) _value_xjal );
      } else {
        p_energyLabel = (OL_GridConnectionEnergyLabel) _value_xjal;
      }
      return true;
    case "p_airco":
      if ( _callOnChange_xjal ) {
        set_p_airco( (J_EAConversionAirConditioner) _value_xjal );
      } else {
        p_airco = (J_EAConversionAirConditioner) _value_xjal;
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
    case "p_parentNodeElectricID": _result_xjal = p_parentNodeElectricID; break;
    case "p_gridConnectionID": _result_xjal = p_gridConnectionID; break;
    case "p_parentNodeHeatID": _result_xjal = p_parentNodeHeatID; break;
    case "p_BuildingThermalAsset": _result_xjal = p_BuildingThermalAsset; break;
    case "p_ownerID": _result_xjal = p_ownerID; break;
    case "p_batteryAsset": _result_xjal = p_batteryAsset; break;
    case "p_heatBuffer": _result_xjal = p_heatBuffer; break;
    case "p_gasBuffer": _result_xjal = p_gasBuffer; break;
    case "p_cookingTracker": _result_xjal = p_cookingTracker; break;
    case "p_insulationLabel": _result_xjal = p_insulationLabel; break;
    case "p_DHWAsset": _result_xjal = p_DHWAsset; break;
    case "p_longitude": _result_xjal = p_longitude; break;
    case "p_latitude": _result_xjal = p_latitude; break;
    case "p_floorSurfaceArea_m2": _result_xjal = p_floorSurfaceArea_m2; break;
    case "p_owner": _result_xjal = p_owner; break;
    case "p_roofSurfaceArea_m2": _result_xjal = p_roofSurfaceArea_m2; break;
    case "p_purposeBAG": _result_xjal = p_purposeBAG; break;
    case "p_address": _result_xjal = p_address; break;
    case "p_parentNodeHeat": _result_xjal = p_parentNodeHeat; break;
    case "p_parentNodeElectric": _result_xjal = p_parentNodeElectric; break;
    case "v_isActive": _result_xjal = v_isActive; break;
    case "p_energyLabel": _result_xjal = p_energyLabel; break;
    case "p_airco": _result_xjal = p_airco; break;
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
      list.add( "p_parentNodeElectricID" );
      list.add( "p_gridConnectionID" );
      list.add( "p_parentNodeHeatID" );
      list.add( "p_BuildingThermalAsset" );
      list.add( "p_ownerID" );
      list.add( "p_batteryAsset" );
      list.add( "p_heatBuffer" );
      list.add( "p_gasBuffer" );
      list.add( "p_cookingTracker" );
      list.add( "p_insulationLabel" );
      list.add( "p_DHWAsset" );
      list.add( "p_longitude" );
      list.add( "p_latitude" );
      list.add( "p_floorSurfaceArea_m2" );
      list.add( "p_owner" );
      list.add( "p_roofSurfaceArea_m2" );
      list.add( "p_purposeBAG" );
      list.add( "p_address" );
      list.add( "p_parentNodeHeat" );
      list.add( "p_parentNodeElectric" );
      list.add( "v_isActive" );
      list.add( "p_energyLabel" );
      list.add( "p_airco" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
double 
 v_currentEnergyCurtailed_kW;
  public 
double 
 v_currentPrimaryEnergyProductionHeatpumps_kW;
  public 
boolean 
 v_hasQuarterHourlyValues;
  public 
J_FlowsMap 
 fm_currentConsumptionFlows_kW;
  public 
J_FlowsMap 
 fm_currentProductionFlows_kW;
  public 
double 
 v_currentPrimaryEnergyProduction_kW;
  public 
double 
 v_currentFinalEnergyConsumption_kW;
  public 
J_FlowsMap 
 fm_currentBalanceFlows_kW;
  public 
double 
 v_batteryStoredEnergy_kWh;
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
  public 
J_ValueMap 
 fm_currentAssetFlows_kW;
  public 
J_RapidRunData 
 v_originalRapidRunData;
  public 
J_FlowsMap 
 fm_consumptionForHeating_kW;
  public 
J_FlowsMap 
 fm_heatFromEnergyCarrier_kW;
  private 
J_ChargePoint 
 p_chargePoint;
  /**
   * Is variable to be able to make it private, but functions as a parameter -> doesnt change during rapid run.
   */
  private 
I_EnergyManagement 
 p_energyManagement;
  public 
double 
 v_previousPowerElectricity_kW;
  /**
   * Heat balance of previous timestep
   */
  public 
double 
 v_previousPowerHeat_kW;
  public 
J_RapidRunData 
 v_previousRunData;

  // Collection Variables
  public 
ArrayList <
J_EA > c_energyAssets = new ArrayList<J_EA>();
  public 
ArrayList <
J_EAStorage > c_storageAssets = new ArrayList<J_EAStorage>();
  public 
ArrayList <
J_EAConsumption > c_consumptionAssets = new ArrayList<J_EAConsumption>();
  public 
ArrayList <
J_EAProduction > c_productionAssets = new ArrayList<J_EAProduction>();
  public 
ArrayList <
J_EAConversion > c_conversionAssets = new ArrayList<J_EAConversion>();
  public 
ArrayList <
I_Vehicle > c_vehicleAssets = new ArrayList<I_Vehicle>();
  public 
ArrayList <
J_EAFuelVehicle > c_petroleumFuelVehicles = new ArrayList<J_EAFuelVehicle>();
  public 
ArrayList <
J_ActivityTrackerTrips > c_tripTrackers = new ArrayList<J_ActivityTrackerTrips>();
  public 
ArrayList <
J_EAProfile > c_profileAssets = new ArrayList<J_EAProfile>();
  public 
ArrayList <
GIS_Object > c_connectedGISObjects = new ArrayList<GIS_Object>();
  public 
ArrayList <
J_EAFuelVehicle > c_hydrogenVehicles = new ArrayList<J_EAFuelVehicle>();
  public 
ArrayList <
EnergyCoop > c_parentCoops = new ArrayList<EnergyCoop>();
  public 
ArrayList <
J_EAChargingSession > c_chargingSessions = new ArrayList<J_EAChargingSession>();
  /**
   * A collection of assets that can deliver heat. This collection does not include the heat buffer or thermal building.
   */
  public 
ArrayList <
J_EAConversion > c_heatingAssets = new ArrayList<J_EAConversion>();
  public 
ArrayList <
J_EAEV > c_electricVehicles = new ArrayList<J_EAEV>();
  public 
ArrayList <
J_EAFlex > c_flexAssets = new ArrayList<J_EAFlex>();
  public 
ArrayList <
J_EAFixed > c_fixedAssets = new ArrayList<J_EAFixed>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( GridConnection.class );

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


  // Events
	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _pl_powerFlows_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _pl_powerFlows_autoUpdateEvent_xjal ) return "pl_powerFlows auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _pl_powerFlows_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _pl_powerFlows_autoUpdateEvent_xjal ) {
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
    if( _e == _pl_powerFlows_autoUpdateEvent_xjal) {
      _t = 
15 
;
      _t = toModelTime( _t, MINUTE );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == _pl_powerFlows_autoUpdateEvent_xjal ) {
      pl_powerFlows.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Functions

  void f_connectToParents(  ) { 

GridNode myParentNodeElectric = findFirst(energyModel.pop_gridNodes, p->p.p_gridNodeID.equals(p_parentNodeElectricID)) ;
if( myParentNodeElectric != null ) {
	p_parentNodeElectric = myParentNodeElectric;
	myParentNodeElectric.f_connectToChild(this);
}

GridNode myParentNodeHeat = findFirst(energyModel.pop_gridNodes, p->p.p_gridNodeID.equals(p_parentNodeHeatID)) ;
if( myParentNodeHeat != null ) {
	p_parentNodeHeat = myParentNodeHeat;
	myParentNodeHeat.f_connectToChild(this);
}

if ( p_owner == null ){
	p_owner = findFirst(energyModel.pop_connectionOwners, p->p.p_actorID.equals(p_ownerID));
}

if ( p_owner != null ){
	p_owner.f_connectToChild(this);
}
/*EnergySupplier myParentEnergySupplier = findFirst(main.pop_energySuppliers, p->p.p_actorID.equals(p_ownerID)) ;
if( myParentEnergySupplier instanceof EnergySupplier) {
	//p_ownerActor = myParentEnergySupplier;
	l_ownerActor.connectTo(myParentEnergySupplier);
	myParentEnergySupplier.f_connectToChild(this);
}
EnergyCoop myParentEnergyCoop = findFirst(main.pop_energyCoops, p->p.p_actorID.equals(p_ownerID)) ;
if( myParentEnergyCoop instanceof EnergyCoop) {
	//p_ownerActor = myParentEnergyCoop;
	l_ownerActor.connectTo(myParentEnergyCoop);
	myParentEnergyCoop.f_connectToChild(this);
}*/ 
  }

  void f_connectionMetering( J_TimeVariables timeVariables, boolean isRapidRun ) { 

if ( DoubleCompare.greaterThanZero(abs(fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.HEAT))) && p_parentNodeHeat == null ) {
	//if (p_BuildingThermalAsset == null || !p_BuildingThermalAsset.hasHeatBuffer()) {
		traceln("heat consumption: %s kW", fm_currentConsumptionFlows_kW.get(OL_EnergyCarriers.HEAT));
		traceln("heat production: %s kW", fm_currentProductionFlows_kW.get(OL_EnergyCarriers.HEAT));
		traceln("Heat unbalance in gridConnection: " + p_gridConnectionID);
		pauseSimulation();
	//}
}

if (isRapidRun){
	f_rapidRunDataLogging(timeVariables);
} else {
	f_fillLiveDataSets(timeVariables);
}
 
  }

  void f_operateFlexAssets( J_TimeVariables timeVariables ) { 

if(p_energyManagement != null){
	p_energyManagement.manageFlexAssets(timeVariables);
} 
  }

  void f_calculateEnergyBalance( J_TimeVariables timeVariables, boolean isRapidRun ) { 

v_previousPowerElectricity_kW = fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY);
v_previousPowerHeat_kW = fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.HEAT);

fm_currentProductionFlows_kW.clear();
fm_currentConsumptionFlows_kW.clear();
fm_currentBalanceFlows_kW.clear();
fm_currentAssetFlows_kW.clear();

fm_heatFromEnergyCarrier_kW.clear();
fm_consumptionForHeating_kW.clear();

v_currentPrimaryEnergyProduction_kW = 0;
v_currentFinalEnergyConsumption_kW = 0;

v_currentEnergyCurtailed_kW = 0;
v_currentPrimaryEnergyProductionHeatpumps_kW = 0;
v_batteryStoredEnergy_kWh = 0;

v_liveConnectionMetaData.updateGridCapacitySharingManager(timeVariables);

c_tripTrackers.forEach(t -> t.manageActivities(timeVariables, p_chargePoint));
c_chargingSessions.forEach(cs -> cs.manageCurrentChargingSession(timeVariables, p_chargePoint, this));

f_operateFixedAssets(timeVariables);
f_operateFlexAssets(timeVariables);

f_connectionMetering(timeVariables, isRapidRun); 
  }

  void f_operateFixedAssets( J_TimeVariables timeVariables ) { 

for (J_EAFixed j_ea : c_fixedAssets) {
	J_FlowPacket flowPacket = j_ea.f_updateAllFlows(timeVariables);
	f_addFlows(flowPacket, j_ea);
} 
  }

  void f_resetStates( J_TimeVariables timeVariables ) { 

fm_currentProductionFlows_kW.clear();
fm_currentConsumptionFlows_kW.clear();
fm_currentBalanceFlows_kW.clear();
fm_heatFromEnergyCarrier_kW.clear();
fm_consumptionForHeating_kW.clear();
//fm_currentAssetFlows_kW.clear(); // Why not this one?? (I'd have to check, but all these fm's are reset at calculateEnergyBalance, so they possibly could all be removed, ~Luc 20/03/26)

v_previousPowerElectricity_kW = 0;
v_previousPowerHeat_kW = 0;

v_rapidRunData.resetAccumulators(v_liveData.activeEnergyCarriers, v_liveData.activeConsumptionEnergyCarriers, v_liveData.activeProductionEnergyCarriers); //f_initializeAccumulators();

//Reset specific variables/collections in specific GC types (GCProduction, GConversion, etc.)
f_resetSpecificGCStates();

// Reset other classes
if(p_energyManagement != null){
	p_energyManagement.storeStatesAndReset();
}

if(p_chargePoint != null){
	p_chargePoint.storeStatesAndReset();
}

c_energyAssets.forEach(ea -> ea.storeStatesAndReset());

c_tripTrackers.forEach(tt -> {
	tt.storeStatesAndReset();
	tt.setStartIndex(timeVariables, f_getChargePoint());
	}
);
	
if (p_cookingTracker != null) {
	p_cookingTracker.storeStatesAndReset();
} 
  }

  void f_setOperatingSwitches(  ) { 

if( this instanceof GCDistrictHeating gc) { // Temporarily disabled while transfering to class-based energy assets!
	gc.f_setConfigurationBooleans();
} 
  }

  public void f_connectToJ_EA( J_EA j_ea, J_TimeParameters timeParameters ) { 

f_addEnergyCarriersAndAssetCategoriesFromEA(j_ea, timeParameters, energyModel.p_timeVariables);

energyModel.c_energyAssets.add(j_ea);
c_energyAssets.add(j_ea);

//If EMS is present: set checked boolean to false. Also for fixed assets: (heating management looks at those as well).
if (p_energyManagement != null) {
	p_energyManagement.setChecked(false);
}
		
if(j_ea instanceof J_EAFixed j_eaFixed){
	f_connectToJ_EAFixed(j_eaFixed, timeParameters);
}
else if(j_ea instanceof J_EAFlex j_eaFlex){
	f_connectToJ_EAFlex(j_eaFlex, timeParameters);
}
else{
	throw new RuntimeException("Trying to connect a J_EA to a GC that is neither J_EAFixed or J_EAFlex!");
} 
  }

  void f_initialize( J_TimeParameters timeParameters ) { 

if (v_liveConnectionMetaData.getPhysicalCapacity_kW() < 0) {
	throw new RuntimeException("Exception: GridConnection " + p_gridConnectionID + " has negative physical connection capacity!");
} else if (v_liveConnectionMetaData.getContractedDeliveryCapacity_kW() < 0) {
	throw new RuntimeException("Exception: GridConnection " + p_gridConnectionID + " has negative contracted delivery capacity!");
} else if (v_liveConnectionMetaData.getContractedFeedinCapacity_kW() < 0) {
	throw new RuntimeException("Exception: GridConnection " + p_gridConnectionID + " has negative contracted feed in capacity!");
}

if ( c_connectedGISObjects.size()>0) {
	if(p_longitude == 0){ p_longitude = c_connectedGISObjects.get(0).p_longitude;}; // Get longitude of first building (only used to get nearest trafo)
	if(p_latitude == 0){ p_latitude = c_connectedGISObjects.get(0).p_latitude;}; // Get latitude of first building (only used to get nearest trafo)
	setLatLon(p_latitude, p_longitude);  
			
	//If GC has no assigned trafo_id --> Assign to nearest trafo
	if (p_parentNodeElectricID == null){
		//Set nearest agent as trafo
		GridNode nearestLVStation = getNearestAgent(energyModel.c_gridNodesNotTopLevel);
		if (nearestLVStation!=null) {
			p_parentNodeElectricID = nearestLVStation.p_gridNodeID;
		}
	}		
}

if (p_parentNodeElectricID == null) {
	p_parentNodeElectricID = findFirst(energyModel.pop_gridNodes, GN->GN.p_energyCarrier.equals(OL_EnergyCarriers.ELECTRICITY)).p_gridNodeID;
	traceln("GridConnection %s wasn't assigned a GridNodeElectric! Using first gridNode Electric in pop_gridNodes", this);
}

f_connectToParents();
if ( p_parentNodeElectric == null ) {
	traceln("GC: %s with id %s", this, p_gridConnectionID);
	traceln("GN id %s", p_parentNodeElectricID);
	throw new RuntimeException("Exception: GridConnection not connected to GridNodeElectric!");
}
else {
	// Calculate the Wind and PV Installed under the parent gridnode
	double PV_kW = 0;
	double Wind_kW = 0;
	for (J_EAProduction j_ea : c_productionAssets) {
		if (j_ea.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC) {
			PV_kW += ((J_EAProduction)j_ea).getCapacityElectric_kW();
		}
		else if (j_ea.getEAType() == OL_EnergyAssetType.WINDMILL) {
			Wind_kW += ((J_EAProduction)j_ea).getCapacityElectric_kW();
		}
	}
	p_parentNodeElectric.v_totalInstalledPVPower_kW += PV_kW;
	p_parentNodeElectric.v_totalInstalledWindPower_kW += Wind_kW;
}

f_setOperatingSwitches();

// Initializing Live Data Class
v_liveAssetsMetaData.updateActiveAssetData(new ArrayList<>(List.of(this)));

f_initializeDataSets(timeParameters);
 
  }

  void f_addFlows( J_FlowPacket flowPacket, J_EA caller ) { 

if (caller instanceof J_EAStorageElectric) { 
	fm_currentBalanceFlows_kW.addFlow(OL_EnergyCarriers.ELECTRICITY, flowPacket.flowsMap.get(OL_EnergyCarriers.ELECTRICITY));

	// Only allocate battery losses as consumption. Charging/discharging is neither production nor consumption. Do we need an element in flowsmap indicating power into storage??
	fm_currentConsumptionFlows_kW.addFlow(OL_EnergyCarriers.ELECTRICITY, max(0, flowPacket.energyUse_kW));
	v_currentFinalEnergyConsumption_kW += max(0, flowPacket.energyUse_kW);
	v_batteryStoredEnergy_kWh += ((J_EAStorageElectric)caller).getCurrentStateOfCharge_kWh();
} else {
	fm_currentBalanceFlows_kW.addFlows(flowPacket.flowsMap);
	for (OL_EnergyCarriers EC : flowPacket.flowsMap.keySet()) {
		double flow_kW = flowPacket.flowsMap.get(EC);		
		if (flow_kW < 0) {
			fm_currentProductionFlows_kW.addFlow(EC, -flow_kW);
		}
		else {
			fm_currentConsumptionFlows_kW.addFlow(EC, flow_kW);
		}
	}
	v_currentPrimaryEnergyProduction_kW += max(0, -flowPacket.energyUse_kW);
	v_currentFinalEnergyConsumption_kW += max(0, flowPacket.energyUse_kW);
}

if (caller instanceof I_HeatingAsset heatingAsset) {
	fm_heatFromEnergyCarrier_kW.addFlows(heatingAsset.get_heatFromEnergyCarrier_kW()); 
    fm_consumptionForHeating_kW.addFlows(heatingAsset.get_consumptionForHeating_kW());
}

if ( caller instanceof J_EAConversionHeatPump ) {
	v_currentPrimaryEnergyProductionHeatpumps_kW -= flowPacket.energyUse_kW;
}

fm_currentAssetFlows_kW.addFlows(flowPacket.assetFlowsMap); 
  }

  public void f_removeTheJ_EA( J_EA j_ea ) { 

c_energyAssets.remove(j_ea);
energyModel.c_energyAssets.remove(j_ea);

//If EMS is present: set checked boolean to false. Also for fixed assets: (heating management looks at those as well).		
if (p_energyManagement != null) {
	p_energyManagement.setChecked(false);
}

if(j_ea instanceof J_EAFixed j_eaFixed){
	f_removeTheJ_EAFixed(j_eaFixed);
}
else if(j_ea instanceof J_EAFlex j_eaFlex){
	f_removeTheJ_EAFlex(j_eaFlex);
}
else{
	throw new RuntimeException("Trying to remove a J_EA from a GC that is neither J_EAFixed or J_EAFlex!");
} 
  }

  void f_resetSpecificGCStates(  ) { 

// to be overwritten by child GCs! 
  }

  void f_resetStatesAfterRapidRun(  ) { 

//Reset specificGC states after rapid run
f_resetSpecificGCStatesAfterRapidRun();

//Restore other classes
if(p_energyManagement != null){
	p_energyManagement.restoreStates();
}

if(p_chargePoint != null){
	p_chargePoint.restoreStates();
}

c_energyAssets.forEach(ea -> ea.restoreStates());

c_tripTrackers.forEach(tt-> tt.restoreStates());
	
if (p_cookingTracker != null) {
	p_cookingTracker.restoreStates();
} 
  }

  void f_resetSpecificGCStatesAfterRapidRun(  ) { 

// to be overwritten by child GCs! 
  }

  public void f_removeFlows( J_FlowPacket flowPacket, J_EA caller ) { 

for (OL_EnergyCarriers EC : flowPacket.flowsMap.keySet()) {
	fm_currentBalanceFlows_kW.addFlow(EC, -flowPacket.flowsMap.get(EC));
	
	if (flowPacket.flowsMap.get(EC) < 0) {
		fm_currentProductionFlows_kW.addFlow(EC, flowPacket.flowsMap.get(EC));
	}
	else if (flowPacket.flowsMap.get(EC) > 0){
		fm_currentConsumptionFlows_kW.addFlow(EC, -flowPacket.flowsMap.get(EC));
	}
}

if (caller instanceof J_EAStorageElectric) { 
	// Only allocate battery losses as consumption. Charging/discharging is neither production nor consumption. Do we need an element in flowsmap indicating power into storage??
	fm_currentConsumptionFlows_kW.addFlow(OL_EnergyCarriers.ELECTRICITY, max(0, flowPacket.energyUse_kW));
	v_currentFinalEnergyConsumption_kW += max(0, flowPacket.energyUse_kW);
} else {
	double curtailment_kW = max(0, -flowPacket.energyUse_kW);
	double lostLoad_kW = max(0, flowPacket.energyUse_kW);
	v_currentEnergyCurtailed_kW += curtailment_kW;
	v_currentPrimaryEnergyProduction_kW -= curtailment_kW;
	v_currentFinalEnergyConsumption_kW -= lostLoad_kW;
}

if ( caller instanceof J_EAConversionHeatPump ) {
	v_currentPrimaryEnergyProductionHeatpumps_kW += flowPacket.energyUse_kW;
}
fm_currentAssetFlows_kW.removeFlows(flowPacket.assetFlowsMap);
/*for(var AC : flowPacket.assetFlowsMap.keySet()) {
	fm_currentAssetFlows_kW.addFlow(AC, -flowPacket.assetFlowsMap.get(AC));
}*/
 
  }

  void f_fillLiveDataSets( J_TimeVariables timeVariables ) { 

v_liveData.addTimeStep(timeVariables.getAnyLogicTime_h(),
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

  void f_rapidRunDataLogging( J_TimeVariables timeVariables ) { 

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
	timeVariables); 
  }

  /**
   * Function to pause a gridconnection so it is not operated or counted towards totals in the energy model.
   */
  public void f_setActive( boolean setActive, J_TimeVariables timeVariables ) { 

if((energyModel.c_pausedGridConnections.contains(this) && !setActive) || 
  (!energyModel.c_pausedGridConnections.contains(this) && setActive)){
	return;
}

if (!setActive) {
	energyModel.c_gridConnections.remove(this);
	energyModel.c_pausedGridConnections.add(this);
	
	// Set GIS Region visibility
	for (GIS_Object obj : c_connectedGISObjects) {
		obj.gisRegion.setVisible(false);
	}	

	// update GN parents' wind / solar totals
	p_parentNodeElectric.f_updateTotalInstalledProductionAssets(OL_EnergyAssetType.PHOTOVOLTAIC, v_liveAssetsMetaData.totalInstalledPVPower_kW, false);
	p_parentNodeElectric.f_updateTotalInstalledProductionAssets(OL_EnergyAssetType.WINDMILL, v_liveAssetsMetaData.totalInstalledWindPower_kW, false);
	energyModel.v_liveAssetsMetaData.totalInstalledPVPower_kW -= v_liveAssetsMetaData.totalInstalledPVPower_kW;
	energyModel.v_liveAssetsMetaData.totalInstalledWindPower_kW -= v_liveAssetsMetaData.totalInstalledWindPower_kW;
	energyModel.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh -= v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
	
	for(EnergyCoop coop : c_parentCoops){
		coop.v_liveAssetsMetaData.totalInstalledPVPower_kW -= v_liveAssetsMetaData.totalInstalledPVPower_kW;
		coop.v_liveAssetsMetaData.totalInstalledWindPower_kW -= v_liveAssetsMetaData.totalInstalledWindPower_kW;
		coop.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh -= v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
		double coopContractDeliveryCapacity_kW = coop.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW();
		double coopContractFeedinCapacity_kW = coop.v_liveConnectionMetaData.getContractedFeedinCapacity_kW();
		coopContractDeliveryCapacity_kW -= v_liveConnectionMetaData.getContractedDeliveryCapacity_kW();
		coopContractFeedinCapacity_kW -= v_liveConnectionMetaData.getContractedFeedinCapacity_kW();
		double coopPhysicalCapacity_kW = max(coopContractDeliveryCapacity_kW, coopContractFeedinCapacity_kW);
		coop.v_liveConnectionMetaData.setCapacities_kW(coopContractDeliveryCapacity_kW, coopContractFeedinCapacity_kW, coopPhysicalCapacity_kW);
	}
	
	// Is setting all of these to zero overkill?
	fm_currentProductionFlows_kW.clear();
	fm_currentConsumptionFlows_kW.clear();
	fm_currentBalanceFlows_kW.clear();
	fm_currentAssetFlows_kW.clear();
	fm_heatFromEnergyCarrier_kW.clear();
	fm_consumptionForHeating_kW.clear();

	v_previousPowerElectricity_kW = 0;
	v_previousPowerHeat_kW = 0;

	v_currentEnergyCurtailed_kW = 0;
	v_currentPrimaryEnergyProductionHeatpumps_kW = 0;
	v_batteryStoredEnergy_kWh = 0;

	v_isActive = setActive;
}
else {
	//traceln("Activating gridConnection");
	energyModel.c_gridConnections.add(this);
	energyModel.c_pausedGridConnections.remove(this);

	// Set GIS Region visibility
	for (GIS_Object obj : c_connectedGISObjects) {
		obj.gisRegion.setVisible(true);
	}
	
	v_isActive = setActive; // v_isActive must be true before calling updateActiveAssetData!
	v_liveAssetsMetaData.updateActiveAssetData(new ArrayList<>(List.of(this)));
	v_liveAssetsMetaData.activeAssetFlows.forEach(x->energyModel.f_addAssetFlow(x));
	v_liveAssetsMetaData.activeAssetFlows.forEach(x-> c_parentCoops.forEach(coop -> coop.f_addAssetFlow(x, energyModel.p_timeParameters, timeVariables)));
		
	// update GN parents' wind / solar totals (will be wrong if you changed your totals while paused)
	p_parentNodeElectric.f_updateTotalInstalledProductionAssets(OL_EnergyAssetType.PHOTOVOLTAIC, v_liveAssetsMetaData.totalInstalledPVPower_kW, true);
	p_parentNodeElectric.f_updateTotalInstalledProductionAssets(OL_EnergyAssetType.WINDMILL, v_liveAssetsMetaData.totalInstalledWindPower_kW, true);
	energyModel.v_liveAssetsMetaData.totalInstalledPVPower_kW += v_liveAssetsMetaData.totalInstalledPVPower_kW;
	energyModel.v_liveAssetsMetaData.totalInstalledWindPower_kW += v_liveAssetsMetaData.totalInstalledWindPower_kW;
	energyModel.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh += v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
	
	for(EnergyCoop coop : c_parentCoops){
		coop.v_liveAssetsMetaData.totalInstalledPVPower_kW += v_liveAssetsMetaData.totalInstalledPVPower_kW;
		coop.v_liveAssetsMetaData.totalInstalledWindPower_kW += v_liveAssetsMetaData.totalInstalledWindPower_kW;
		coop.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh += v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh;

		double coopContractDeliveryCapacity_kW = coop.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW();
		double coopContractFeedinCapacity_kW = coop.v_liveConnectionMetaData.getContractedFeedinCapacity_kW();
		coopContractDeliveryCapacity_kW += v_liveConnectionMetaData.getContractedDeliveryCapacity_kW();
		coopContractFeedinCapacity_kW += v_liveConnectionMetaData.getContractedFeedinCapacity_kW();
		double coopPhysicalCapacity_kW = max(coopContractDeliveryCapacity_kW, coopContractFeedinCapacity_kW);
		coop.v_liveConnectionMetaData.setCapacities_kW(coopContractDeliveryCapacity_kW, coopContractFeedinCapacity_kW, coopPhysicalCapacity_kW);
		
		if(!v_liveConnectionMetaData.getContractedDeliveryCapacityKnown()){
			coop.v_liveConnectionMetaData.setContractedDeliveryCapacityKnown(false);
		}
		if(!v_liveConnectionMetaData.getContractedFeedinCapacityKnown()){
			coop.v_liveConnectionMetaData.setContractedFeedinCapacityKnown(false);
		} 
	}
	
	//Fast forward time dependent energy assets (if present)
	c_chargingSessions.forEach(cs -> cs.fastForwardCharingSessions(timeVariables.getT_h(), p_chargePoint));
	c_vehicleAssets.forEach(vehicle -> vehicle.setAvailability(true));
	if (p_chargePoint != null) {
	    c_tripTrackers.forEach(tt -> {
	        if (tt.vehicle instanceof J_EAEV ev && p_chargePoint.isRegistered(ev)) {
	            p_chargePoint.deregisterChargingRequest(ev);
	        }
	        tt.setStartIndex(timeVariables, f_getChargePoint());
	    });
	}
		
	//Initialize datasets for all EC and AssetFlowCategories and clear all.
	f_initializeDataSets(energyModel.p_timeParameters);
	v_liveData.clearLiveDatasets();
} 
  }

  void f_initializeDataSets( J_TimeParameters timeParameters ) { 

v_liveData.dsm_liveDemand_kW.createEmptyDataSets(v_liveData.activeConsumptionEnergyCarriers, (int)(168 / timeParameters.getTimeStep_h()));
v_liveData.dsm_liveSupply_kW.createEmptyDataSets(v_liveData.activeProductionEnergyCarriers, (int)(168 / timeParameters.getTimeStep_h()));
v_liveData.dsm_liveAssetFlows_kW.createEmptyDataSets(v_liveData.assetsMetaData.activeAssetFlows, (int)(168 / timeParameters.getTimeStep_h()));
 
  }

  public void f_startAfterDeserialisation( J_TimeParameters timeParameters, J_TimeVariables timeVariables ) { 

fm_currentProductionFlows_kW = new J_FlowsMap();
fm_currentConsumptionFlows_kW = new J_FlowsMap();
fm_currentBalanceFlows_kW = new J_FlowsMap();
fm_currentAssetFlows_kW = new J_ValueMap(OL_AssetFlowCategories.class);
fm_heatFromEnergyCarrier_kW = new J_FlowsMap();
fm_consumptionForHeating_kW = new J_FlowsMap();

v_liveData = new J_LiveData();
v_liveData.activeEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeProductionEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeConsumptionEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);

v_liveData.connectionMetaData = v_liveConnectionMetaData;
v_liveData.assetsMetaData = v_liveAssetsMetaData;

v_liveData.dsm_liveDemand_kW.createEmptyDataSets(v_liveData.activeConsumptionEnergyCarriers, roundToInt(168/timeParameters.getTimeStep_h()));
v_liveData.dsm_liveSupply_kW.createEmptyDataSets(v_liveData.activeProductionEnergyCarriers, roundToInt(168/timeParameters.getTimeStep_h()));
v_liveData.dsm_liveAssetFlows_kW.createEmptyDataSets(v_liveData.assetsMetaData.activeAssetFlows, roundToInt(168/timeParameters.getTimeStep_h()));

for (J_EA j_ea : c_energyAssets) {
	f_addEnergyCarriersAndAssetCategoriesFromEA(j_ea, timeParameters, timeVariables);
}
 
  }

  public void f_removeAllHeatingAssets(  ) { 

while (c_heatingAssets.size() > 0) {
	c_heatingAssets.get(0).removeEnergyAsset();
} 
  }

  public 
OL_GridConnectionHeatingType 
 f_getCurrentHeatingType(  ) { 

if (p_energyManagement != null) {
	return p_energyManagement.getCurrentHeatingType();
}
else {
	return OL_GridConnectionHeatingType.NONE;
} 
  }

  /**
   * This function takes heatingType as an argument and adds the default heating management class to the GridConnection
   */
  public void f_addHeatManagement( OL_GridConnectionHeatingType heatingType, boolean isGhost ) { 

if (heatingType == OL_GridConnectionHeatingType.NONE) {
	return;
}
if (isGhost) {
	f_setExternalAssetManagement(new J_HeatingManagementGhost( this, energyModel.p_timeParameters, heatingType ));
	return;
}
if (heatingType == OL_GridConnectionHeatingType.CUSTOM) {
	throw new RuntimeException("f_addHeatManagementToGC called with heating type CUSTOM");
}

boolean hasThermalBuilding = this.p_BuildingThermalAsset != null;
boolean hasHeatBuffer = this.p_heatBuffer != null;
Triple<OL_GridConnectionHeatingType, Boolean, Boolean> triple = Triple.of( heatingType, hasThermalBuilding, hasHeatBuffer );
Class<? extends I_HeatingManagement> managementClass = energyModel.c_defaultHeatingStrategies.get(triple);

if (managementClass == null) {
	throw new RuntimeException("No heating strategy available for heatingType: " + heatingType + " with hasThermalBuilding: " + hasThermalBuilding + " and hasHeatBuffer: " + hasHeatBuffer);
}

I_HeatingManagement heatingManagement = null;
try {
	heatingManagement = managementClass.getDeclaredConstructor(GridConnection.class, J_TimeParameters.class, OL_GridConnectionHeatingType.class).newInstance(this, energyModel.p_timeParameters, heatingType);
}
catch (Exception e) {
	e.printStackTrace();
}

J_HeatingPreferences existingHeatingPreferences = f_getHeatingManagement() != null ? f_getHeatingManagement().getHeatingPreferences() : null; //Store the existing heating preferences

heatingManagement.setHeatingPreferences(existingHeatingPreferences); // Reasign the existing heating preferences
f_setExternalAssetManagement(heatingManagement);
 
  }

  public void f_addConsumptionEnergyCarrier( OL_EnergyCarriers EC, J_TimeParameters timeParameters, J_TimeVariables timeVariables ) { 

v_liveData.activeEnergyCarriers.add(EC);
v_liveData.activeConsumptionEnergyCarriers.add(EC);

DataSet dsDemand = new DataSet( (int)(168 / timeParameters.getTimeStep_h()) );

double endTime = timeVariables.getAnyLogicTime_h();
double startTime = max(0, timeVariables.getAnyLogicTime_h() - 168);

for (double t = startTime; t <= endTime; t += timeParameters.getTimeStep_h()) {
	dsDemand.add( t, 0);
}
v_liveData.dsm_liveDemand_kW.put( EC, dsDemand);
 
  }

  public void f_addProductionEnergyCarrier( OL_EnergyCarriers EC, J_TimeParameters timeParameters, J_TimeVariables timeVariables ) { 

v_liveData.activeEnergyCarriers.add(EC);
v_liveData.activeProductionEnergyCarriers.add(EC);

DataSet dsSupply = new DataSet( (int)(168 / timeParameters.getTimeStep_h()) );

double endTime = timeVariables.getAnyLogicTime_h();
double startTime = max(0, timeVariables.getAnyLogicTime_h() - 168);

for (double t = startTime; t <= endTime; t += timeParameters.getTimeStep_h()) {
	dsSupply.add( t, 0);
}
v_liveData.dsm_liveSupply_kW.put( EC, dsSupply);
 
  }

  public void f_addAssetFlow( OL_AssetFlowCategories AC, J_TimeParameters timeParameters, J_TimeVariables timeVariables ) { 

if (!v_liveAssetsMetaData.activeAssetFlows.contains(AC)) {
	v_liveAssetsMetaData.activeAssetFlows.add(AC);
	
	DataSet dsAsset = new DataSet( (int)(168 / timeParameters.getTimeStep_h()) );
	
	double endTime = timeVariables.getAnyLogicTime_h();
	double startTime = max(0, timeVariables.getAnyLogicTime_h() - 168);

	for (double t = startTime; t <= endTime; t += timeParameters.getTimeStep_h()) {
		dsAsset.add( t, 0);
	}
	v_liveData.dsm_liveAssetFlows_kW.put( AC, dsAsset);
	
	if (AC == OL_AssetFlowCategories.batteriesChargingPower_kW) { // also add batteriesDischarging!
		v_liveAssetsMetaData.activeAssetFlows.add(OL_AssetFlowCategories.batteriesDischargingPower_kW);
		dsAsset = new DataSet( (int)(168 / timeParameters.getTimeStep_h()) );
		for (double t = startTime; t <= endTime; t += timeParameters.getTimeStep_h()) {
			dsAsset.add( t, 0);
		}
		v_liveData.dsm_liveAssetFlows_kW.put( OL_AssetFlowCategories.batteriesDischargingPower_kW, dsAsset);
	}
	if (AC == OL_AssetFlowCategories.V2GPower_kW && !v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.evChargingPower_kW)) { // also add evCharging!
		v_liveAssetsMetaData.activeAssetFlows.add(OL_AssetFlowCategories.evChargingPower_kW);	
		dsAsset = new DataSet( (int)(168 / timeParameters.getTimeStep_h()) );
		for (double t = startTime; t <= endTime; t += timeParameters.getTimeStep_h()) {
			dsAsset.add( t, 0);
		}
		v_liveData.dsm_liveAssetFlows_kW.put( OL_AssetFlowCategories.evChargingPower_kW, dsAsset);
	}
	
	//Add asset flow also to aggregators
	c_parentCoops.forEach(x -> x.f_addAssetFlow(AC, timeParameters, timeVariables));
	energyModel.f_addAssetFlow(AC);
}			 
  }

  public void f_activateV2GChargingMode( boolean enableV2G, J_TimeParameters timeParameters, J_TimeVariables timeVariables ) { 

if(energyModel.b_isInitialized){
	p_energyManagement.setV2GActive(enableV2G);
	if (enableV2G){
		f_addAssetFlow(OL_AssetFlowCategories.V2GPower_kW, timeParameters, timeVariables);
	}
} 
  }

  /**
   * This function takes heatingType as an argument and adds the default heating management class to the GridConnection
   */
  public void f_addChargingManagement( OL_ChargingAttitude chargingType ) { 

if (chargingType == null) {
	if (c_electricVehicles.size()>0){
		throw new RuntimeException("Charging strategy needed when electric vehicles are present!");
	}
}

if (chargingType == OL_ChargingAttitude.CUSTOM) {
	throw new RuntimeException("f_addChargingManagementToGC called with charging type CUSTOM");
}

Class<? extends I_ChargingManagement> managementClass;
switch (chargingType) {			
	case SIMPLE:
		managementClass = J_ChargingManagementSimple.class;
		break;
	case PRICE:
		managementClass = J_ChargingManagementPrice.class;		
		break;
	case PRICE_MARKET_FEEDBACK:
		managementClass = J_ChargingManagementPriceScheduled.class;
		break;
	case BALANCE_LOCAL:
		managementClass = J_ChargingManagementLocalBalancing.class;
		break;
	case BALANCE_GRID:
		managementClass = J_ChargingManagementGridBalancing.class;
		break;
	case MAX_POWER:
		managementClass = J_ChargingManagementMaxAvailablePower.class;
		break;
	default:
		throw new RuntimeException("No matching charging strategy available for chargingType: " + chargingType);
}

I_ChargingManagement chargingManagement = null;
try {
	chargingManagement = managementClass.getDeclaredConstructor(GridConnection.class, J_TimeParameters.class).newInstance(this, energyModel.p_timeParameters);
}
catch (Exception e) {
	e.printStackTrace();
}

f_setExternalAssetManagement(chargingManagement);

if(p_chargePoint == null){
	p_chargePoint = new J_ChargePoint(true, true);
} 
  }

  void f_addEnergyCarriersAndAssetCategoriesFromEA( J_EA j_ea, J_TimeParameters timeParameters, J_TimeVariables timeVariables ) { 

for (OL_EnergyCarriers EC : j_ea.getActiveConsumptionEnergyCarriers()) {
	if (!v_liveData.activeConsumptionEnergyCarriers.contains(EC)) {
		v_liveData.activeConsumptionEnergyCarriers.add(EC);
		v_liveData.activeEnergyCarriers.add(EC);
		if (energyModel.b_isInitialized && v_isActive) {
			f_addConsumptionEnergyCarrier(EC, timeParameters, timeVariables);	
			//Add EC to energyModel
			energyModel.f_addConsumptionEnergyCarrier(EC);
			c_parentCoops.forEach(x -> x.f_addConsumptionEnergyCarrier(EC, timeParameters, timeVariables));
		}
	}
}

for (OL_EnergyCarriers EC : j_ea.getActiveProductionEnergyCarriers()) {
	if (!v_liveData.activeProductionEnergyCarriers.contains(EC)) {
		v_liveData.activeProductionEnergyCarriers.add(EC);
		v_liveData.activeEnergyCarriers.add(EC);
		if (energyModel.b_isInitialized && v_isActive) {		
			f_addProductionEnergyCarrier(EC, timeParameters, timeVariables);
			//Add EC to energyModel
			energyModel.f_addProductionEnergyCarrier(EC);
			c_parentCoops.forEach(x -> x.f_addProductionEnergyCarrier(EC, timeParameters, timeVariables));
		}
	}
}

if(j_ea.assetFlowCategory != null &&!v_liveAssetsMetaData.activeAssetFlows.contains(j_ea.assetFlowCategory)) { // add live dataset
	OL_AssetFlowCategories AC = j_ea.assetFlowCategory;
	if (energyModel.b_isInitialized && v_isActive) {	
		f_addAssetFlow(AC, timeParameters, timeVariables);	
	}
	else{
		v_liveAssetsMetaData.activeAssetFlows.add(AC);
	}
} 
  }

  public void f_setChargingManagement( I_ChargingManagement chargingManagement ) { 

f_setExternalAssetManagement(chargingManagement);

if(p_chargePoint == null){
	p_chargePoint = new J_ChargePoint(true, true);
} 
  }

  public 
boolean 
 f_getHeatingTypeIsGhost(  ) { 

return f_getHeatingManagement() instanceof J_HeatingManagementGhost; 
  }

  public void f_setHeatingPreferences( J_HeatingPreferences heatingPreferences ) { 

f_getHeatingManagement().setHeatingPreferences(heatingPreferences); 
  }

  public 
OL_ChargingAttitude 
 f_getCurrentChargingType(  ) { 

if (p_energyManagement != null) {
	return p_energyManagement.getCurrentChargingType();
}
else {
	return OL_ChargingAttitude.NONE;
} 
  }

  public 
boolean 
 f_getV2GActive(  ) { 

if (p_energyManagement != null) {
	return this.p_energyManagement.getV2GActive();
}
else {
	return false;
} 
  }

  public 
I_BatteryManagement 
 f_getBatteryManagement(  ) { 

return f_getExternalAssetManagement(I_BatteryManagement.class); 
  }

  public void f_setHeatingManagement( I_HeatingManagement heatingManagement ) { 

f_setExternalAssetManagement(heatingManagement);
 
  }

  public void f_setBatteryManagement( I_BatteryManagement batteryManagement ) { 

f_setExternalAssetManagement(batteryManagement);
 
  }

  public 
I_ChargingManagement 
 f_getChargingManagement(  ) { 

return f_getExternalAssetManagement(I_ChargingManagement.class); 
  }

  public 
I_HeatingManagement 
 f_getHeatingManagement(  ) { 

return f_getExternalAssetManagement(I_HeatingManagement.class); 
  }

  public 
J_ChargePoint 
 f_getChargePoint(  ) { 

return p_chargePoint; 
  }

  public void f_setChargePoint( J_ChargePoint chargePoint ) { 

this.p_chargePoint = chargePoint; 
  }

  public 
boolean 
 f_isActive(  ) { 

return v_isActive; 
  }

  /**
   * This function replaces the old way of calling f_updateAllFlows directly, in order for the GC to manage its bookkeeping.
   */
  public void f_updateFlexAssetFlows( J_EAFlex j_ea, double powerFraction_fr, J_TimeVariables timeVariables ) { 

J_FlowPacket fp = j_ea.f_updateAllFlows(powerFraction_fr, timeVariables);
f_addFlows(fp, j_ea); 
  }

  public void f_setEnergyManagement( I_EnergyManagement energyManagement ) { 

this.p_energyManagement = energyManagement; 
  }

  public 
I_EnergyManagement 
 f_getEnergyManagement(  ) { 

return this.p_energyManagement; 
  }

  public void f_setExternalAssetManagement( I_AssetManagement externalAssetManagement ) { 

if(p_energyManagement == null){
	p_energyManagement = new J_EnergyManagementDefault(this, energyModel.p_timeParameters);
}
this.p_energyManagement.setExternalAssetManagement(externalAssetManagement);
     
  }

  public 
<T extends I_AssetManagement> T 
 f_getExternalAssetManagement( Class<T>  assetManagementInterfaceType ) { 

if(this.p_energyManagement != null){
	return this.p_energyManagement.getExternalAssetManagement(assetManagementInterfaceType);
}
else{
	return null;
} 
  }

  void f_connectToJ_EAFlex( J_EAFlex j_ea, J_TimeParameters timeParameters ) { 

c_flexAssets.add(j_ea);

if (j_ea instanceof J_EAEV ev) {
	if(p_chargePoint == null){
		p_chargePoint = new J_ChargePoint(true, true);
	}
	c_vehicleAssets.add(ev);
	c_electricVehicles.add(ev);
	energyModel.c_EVs.add(ev);	
	ev.setV2GActive(f_getV2GActive());
		
	//Connect triptracker that belongs to the EV
	f_connectTripTracker(ev, timeParameters);
	
}
else if (j_ea instanceof J_EAChargingSession chargingSession) {
	if(p_chargePoint == null){
		p_chargePoint = new J_ChargePoint(true, true);
	}
	c_chargingSessions.add(chargingSession);
	chargingSession.setV2GActive(f_getV2GActive());
}
else if (j_ea instanceof J_EAConversion conversionAsset) {
	c_conversionAssets.add(conversionAsset);
	
	//Check if heating asset		
	if (conversionAsset instanceof I_HeatingAsset) {
		c_heatingAssets.add(conversionAsset);
		if (j_ea instanceof J_EAConversionHeatPump) {
			energyModel.c_ambientDependentAssets.add(j_ea);
		}
	}
	else if ( conversionAsset.energyAssetType == OL_EnergyAssetType.GAS_PIT || j_ea.energyAssetType == OL_EnergyAssetType.ELECTRIC_HOB){
		if (p_cookingTracker == null) {
			int rowIndex = uniform_discr(2, 300); 
			p_cookingTracker = new J_ActivityTrackerCooking(energyModel.p_cookingPatternCsv, rowIndex, (energyModel.p_timeVariables.getAnyLogicTime_h())*60, (J_EAConversion)j_ea );			
		} 
		else {
			p_cookingTracker.HOB = (J_EAConversion)j_ea;
		}
	} 
	else if (j_ea instanceof J_EAConversionAirConditioner aircoAsset) {
		p_airco = aircoAsset;
		energyModel.c_ambientDependentAssets.add(aircoAsset);
	}

} 
else if (j_ea instanceof J_EAStorage storageAsset) {
	c_storageAssets.add(storageAsset);
	energyModel.c_storageAssets.add(storageAsset);
	if (j_ea instanceof J_EAStorageHeat) {
		energyModel.c_ambientDependentAssets.add(j_ea);
		if (j_ea instanceof J_EABuilding buildingAsset) {
			p_BuildingThermalAsset = buildingAsset;
		}
		else {
			p_heatBuffer = (J_EAStorageHeat)j_ea;
		}
	} 
	else if (j_ea instanceof J_EAStorageGas gasStorage) {
		p_gasBuffer = gasStorage;
	} 
	else if (j_ea instanceof J_EAStorageElectric battery) {
		p_batteryAsset = battery;
		double capacity_MWh = battery.getStorageCapacity_kWh()/1000;
		v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh += capacity_MWh;
		c_parentCoops.forEach( coop -> coop.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh += capacity_MWh);
		energyModel.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh += capacity_MWh;
	}
} else {
	throw new RuntimeException("Trying to connect GC with unrecognized J_EAFlex asset!");
} 
  }

  
J_ActivityTrackerTrips 
 f_getNewTripTracker( OL_EnergyAssetType assetType, I_Vehicle vehicle, J_TimeParameters timeParameters ) { 

J_ActivityTrackerTrips tripTracker;
if (assetType == OL_EnergyAssetType.ELECTRIC_TRUCK || assetType == OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK || assetType == OL_EnergyAssetType.HYDROGEN_TRUCK) {
	int rowIndex = uniform_discr(1, 7);	//Truck trip CSV has 7 valid rows.
	tripTracker = new J_ActivityTrackerTrips(timeParameters, energyModel.p_truckTripsCsv, rowIndex, energyModel.p_timeVariables, vehicle, p_chargePoint);
} else if (assetType == OL_EnergyAssetType.PETROLEUM_FUEL_VAN || assetType == OL_EnergyAssetType.ELECTRIC_VAN || assetType == OL_EnergyAssetType.HYDROGEN_VAN) {// No mobility pattern for business vans available yet!! Falling back to truck mobility pattern
	int rowIndex = uniform_discr(1, 7); //Truck trip CSV (used for vans) has 7 valid rows.
	tripTracker = new J_ActivityTrackerTrips(timeParameters, energyModel.p_truckTripsCsv, rowIndex, energyModel.p_timeVariables, vehicle, p_chargePoint);
	tripTracker.setAnnualDistance_km(30_000); //Wat gebeurt hier???
} else if(assetType == OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE || assetType == OL_EnergyAssetType.ELECTRIC_VEHICLE || assetType == OL_EnergyAssetType.HYDROGEN_VEHICLE) {
	int rowIndex = uniform_discr(0, 200); //Car trip CSV has 200+ valid rows.
	while (rowIndex == 28 || rowIndex == 42 || rowIndex == 150) { // 28, 42, 150, 445, 457, 483, 540, 563 all impossible triptrackers for vehicles with 116 kWh and 0.16 kWhpkm
		rowIndex = uniform_discr(0, 200);
	}
	tripTracker = new J_ActivityTrackerTrips(timeParameters, energyModel.p_householdTripsCsv, rowIndex, energyModel.p_timeVariables, vehicle, p_chargePoint);
}
else{
	throw new RuntimeException("Trying to get a new trip tracker for an unsupported vehicle type");
}

return tripTracker; 
  }

  void f_connectToJ_EAFixed( J_EAFixed j_ea, J_TimeParameters timeParameters ) { 

c_fixedAssets.add(j_ea);

if (j_ea instanceof J_EAProfile profileAsset) {
	c_profileAssets.add(profileAsset);
	if (j_ea.getAssetFlowCategory() == OL_AssetFlowCategories.hotWaterConsumption_kW) {
		p_DHWAsset = profileAsset;	
	}
}

if (j_ea instanceof J_EAFuelVehicle fuelVehicle) {
	c_vehicleAssets.add(fuelVehicle);
	
	if (fuelVehicle.getEnergyCarrierConsumed() == OL_EnergyCarriers.PETROLEUM_FUEL) {
		c_petroleumFuelVehicles.add(fuelVehicle);
	}
	else if (fuelVehicle.getEnergyCarrierConsumed() == OL_EnergyCarriers.HYDROGEN) {
		c_hydrogenVehicles.add(fuelVehicle);		
	}
	else {
		traceln("Warning! f_connectToJ_EAFixed found a fuelVehicle with unknown energy carrier.");
	}
	
	//Connect triptracker that belongs to the vehicle
	f_connectTripTracker(fuelVehicle, timeParameters);
}
else if (j_ea instanceof J_EAConsumption consumptionAsset) {
	c_consumptionAssets.add(consumptionAsset);	
} 
else if (j_ea instanceof J_EAProduction productionAsset) {
	c_productionAssets.add(productionAsset);

	if (j_ea.energyAssetType == OL_EnergyAssetType.PHOTOVOLTAIC) {
		double capacity_kW = productionAsset.getCapacityElectric_kW();
		v_liveAssetsMetaData.totalInstalledPVPower_kW += capacity_kW;
		if ( p_parentNodeElectric != null ) {
			p_parentNodeElectric.f_updateTotalInstalledProductionAssets(OL_EnergyAssetType.PHOTOVOLTAIC, capacity_kW, true);
		}
		c_parentCoops.forEach( coop -> coop.v_liveAssetsMetaData.totalInstalledPVPower_kW += capacity_kW);
		energyModel.v_liveAssetsMetaData.totalInstalledPVPower_kW += capacity_kW;
	}
	else if (productionAsset.energyAssetType == OL_EnergyAssetType.WINDMILL) {
		double capacity_kW = productionAsset.getCapacityElectric_kW();
		v_liveAssetsMetaData.totalInstalledWindPower_kW += capacity_kW;
		if ( p_parentNodeElectric != null ) {
			p_parentNodeElectric.f_updateTotalInstalledProductionAssets(OL_EnergyAssetType.WINDMILL, capacity_kW, true);
		}
		c_parentCoops.forEach( coop -> coop.v_liveAssetsMetaData.totalInstalledWindPower_kW += capacity_kW);
		energyModel.v_liveAssetsMetaData.totalInstalledWindPower_kW += capacity_kW;
	}
	else if (productionAsset.energyAssetType == OL_EnergyAssetType.PHOTOTHERMAL){

	}
}
else if (j_ea instanceof J_EAPetroleumFuelTractor tractor) {
	c_profileAssets.add(tractor);
}
else if (j_ea instanceof J_EAProfile) {
	return;
}
else{
	throw new RuntimeException("Trying to connect GC with unrecognized J_EAFixed asset!");
} 
  }

  void f_checkConfiguration(  ) { 

if(c_flexAssets.size() > 0){
	if(p_energyManagement != null){
		p_energyManagement.checkConfiguration(c_flexAssets);
	}
	else{
		throw new RuntimeException("GC: " + p_gridConnectionID + " has flex assets, without an EMS");
	}
}
 
  }

  void f_removeTheJ_EAFixed( J_EAFixed j_ea ) { 

c_fixedAssets.remove(j_ea);

if (j_ea instanceof J_EAProfile profileAsset) {
	c_profileAssets.remove(profileAsset);
	if (j_ea.getAssetFlowCategory() == OL_AssetFlowCategories.hotWaterConsumption_kW) {
		p_DHWAsset = null;	
	}
}

if (j_ea instanceof J_EAFuelVehicle fuelVehicle) {
	c_vehicleAssets.remove(fuelVehicle);
	
	if (fuelVehicle.getEnergyCarrierConsumed() == OL_EnergyCarriers.PETROLEUM_FUEL) {
		c_petroleumFuelVehicles.remove( fuelVehicle );
	}
	else if (fuelVehicle.getEnergyCarrierConsumed() == OL_EnergyCarriers.HYDROGEN) {
		c_hydrogenVehicles.remove(fuelVehicle);
	}
	else {
		traceln("Warning! f_removeTheJ_EAFixed found a fuelVehicle with unknown energy carrier.");			
	}

	J_ActivityTrackerTrips tripTracker = fuelVehicle.getTripTracker();
	c_tripTrackers.remove( tripTracker );
	fuelVehicle.setTripTracker(null);
}
else if (j_ea instanceof J_EAConsumption) {
	c_consumptionAssets.remove((J_EAConsumption)j_ea);	
	if( j_ea.energyAssetType == OL_EnergyAssetType.ELECTRICITY_DEMAND ) {
	
	}
	if( j_ea.energyAssetType == OL_EnergyAssetType.ELECTRIC_HOB ) {
	
	}
}
else if (j_ea instanceof J_EAProduction) {
	c_productionAssets.remove((J_EAProduction)j_ea);

	if (j_ea.energyAssetType == OL_EnergyAssetType.PHOTOVOLTAIC) {
		J_EAProduction otherPV = findFirst(c_productionAssets, x -> x.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC);
		double capacity_kW = ((J_EAProduction)j_ea).getCapacityElectric_kW();
		v_liveAssetsMetaData.totalInstalledPVPower_kW -= capacity_kW;
		if ( p_parentNodeElectric != null ) {
			p_parentNodeElectric.f_updateTotalInstalledProductionAssets(OL_EnergyAssetType.PHOTOVOLTAIC, capacity_kW, false);
		}
		c_parentCoops.forEach( coop -> coop.v_liveAssetsMetaData.totalInstalledPVPower_kW -= capacity_kW);		
		energyModel.v_liveAssetsMetaData.totalInstalledPVPower_kW -= capacity_kW;
	}
	else if (j_ea.energyAssetType == OL_EnergyAssetType.WINDMILL) {
		double capacity_kW = ((J_EAProduction)j_ea).getCapacityElectric_kW();
		v_liveAssetsMetaData.totalInstalledWindPower_kW -= capacity_kW;
		if ( p_parentNodeElectric != null ) {
			p_parentNodeElectric.f_updateTotalInstalledProductionAssets(OL_EnergyAssetType.WINDMILL, capacity_kW, false);
		}
		c_parentCoops.forEach( coop -> coop.v_liveAssetsMetaData.totalInstalledPVPower_kW -= capacity_kW);		
		energyModel.v_liveAssetsMetaData.totalInstalledWindPower_kW -= capacity_kW;
	}
	else if (j_ea.energyAssetType == OL_EnergyAssetType.PHOTOTHERMAL){
	
	}
} 
  }

  void f_removeTheJ_EAFlex( J_EAFlex j_ea ) { 

c_flexAssets.remove(j_ea);

if (j_ea instanceof J_EAEV ev) {
	c_vehicleAssets.remove(ev);
	c_electricVehicles.remove(ev);
	energyModel.c_EVs.remove(ev);
	if(p_chargePoint.isRegistered(ev)){
		p_chargePoint.deregisterChargingRequest(ev);
	}
	J_ActivityTrackerTrips tripTracker = ev.getTripTracker();
	c_tripTrackers.remove( tripTracker );
	ev.setTripTracker(null);
}
else if (j_ea instanceof J_EAChargingSession chargeSession) {
	c_chargingSessions.remove(chargeSession);
	if(p_chargePoint.isRegistered(chargeSession)){
		p_chargePoint.deregisterChargingRequest(chargeSession);
	}
}
else if (j_ea instanceof J_EAConversion) {
	c_conversionAssets.remove((J_EAConversion)j_ea);
	
	//Check if heating asset		
	if (j_ea instanceof I_HeatingAsset) {
		c_heatingAssets.remove(j_ea);

		// Special Heating Assets
		if (j_ea instanceof J_EAConversionHeatPump) {
			energyModel.c_ambientDependentAssets.remove(j_ea);
		} 
		else if (j_ea instanceof J_EAConversionGasCHP) {
		
		}	
	}
	else if ( j_ea.energyAssetType == OL_EnergyAssetType.GAS_PIT || j_ea.energyAssetType == OL_EnergyAssetType.ELECTRIC_HOB){
		p_cookingTracker = null;
	} 
	else if (j_ea instanceof J_EAConversionElectrolyser) {
	
	}
	else if (j_ea instanceof J_EAConversionAirConditioner) {
		p_airco = null;
		energyModel.c_ambientDependentAssets.remove(j_ea);
	}
} 
else if  (j_ea instanceof J_EAStorage) {
	c_storageAssets.remove((J_EAStorage)j_ea);
	energyModel.c_storageAssets.remove((J_EAStorage)j_ea);
	if (j_ea instanceof J_EAStorageHeat) {
		energyModel.c_ambientDependentAssets.remove(j_ea);
		if (j_ea.energyAssetType == OL_EnergyAssetType.BUILDINGTHERMALS) {	
			p_BuildingThermalAsset = null;
		}
		else {
			p_heatBuffer = null;
		}
	} 
	else if (j_ea instanceof J_EAStorageGas) {
		p_gasBuffer = null;
	} 
	else if (j_ea instanceof J_EAStorageElectric) {
		p_batteryAsset = null;
		v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh -= ((J_EAStorageElectric)j_ea).getStorageCapacity_kWh()/1000;
		energyModel.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh -= ((J_EAStorageElectric)j_ea).getStorageCapacity_kWh()/1000;
	}
}
else if (j_ea instanceof J_EAConversionAirConditioner) {
	p_airco = null;
} 
  }

  void f_connectTripTracker( I_Vehicle vehicle, J_TimeParameters timeParameters ) { 

J_ActivityTrackerTrips tripTracker = vehicle.getTripTracker();

// TODO: Needs a refactor, this code that creates a triptracker is very different from the rest of the functionality of connect to j_ea. However the trip CSVs make it awkward to place it in the constructor of the asset.
if (tripTracker == null) { // Only provide new tripTracker when vehicle doesn't have it yet!
	OL_EnergyAssetType assetType = ((J_EA)vehicle).getEAType();
	tripTracker = f_getNewTripTracker(assetType, vehicle, timeParameters);
	vehicle.setTripTracker(tripTracker);
}
else if( vehicle.getAvailability() && vehicle instanceof J_EAEV ev){ // J_EAEV that already has triptracker, but still needs to prepare next trip to determine chargedeadline.
	tripTracker.prepareNextActivity(energyModel.p_timeVariables.getT_h()*60, p_chargePoint);
}
c_tripTrackers.add( tripTracker ); 
  }

  public void f_removeExternalAssetManagement( Class<? extends I_AssetManagement> assetManagementInterfaceType ) { 

if(this.p_energyManagement != null){
	this.p_energyManagement.removeExternalAssetManagement(assetManagementInterfaceType);
} 
  }

  public 
boolean 
 f_isAssetManagementActive( Class<? extends I_AssetManagement>  assetManagementInterfaceType ) { 

if(this.p_energyManagement != null){
	return this.p_energyManagement.isAssetManagementActive(assetManagementInterfaceType);
}
else{
	return false;
} 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression0_dataSet_xjal_XValue(  ) {
	return _datasetUpdateTime_xjal();
  }
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression0_dataSet_xjal_YValue(  ) {
    return 
fm_currentAssetFlows_kW.get(windProductionElectric_kW) + fm_currentAssetFlows_kW.get(pvProductionElectric_kW) 
;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression1_dataSet_xjal_XValue(  ) {
	return _datasetUpdateTime_xjal();
  }
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression1_dataSet_xjal_YValue(  ) {
    return 
fm_currentAssetFlows_kW.get(heatPumpElectricityConsumption_kW) 
;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression2_dataSet_xjal_XValue(  ) {
	return _datasetUpdateTime_xjal();
  }
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression2_dataSet_xjal_YValue(  ) {
    return 
fm_currentAssetFlows_kW.get(evChargingPower_kW)-fm_currentAssetFlows_kW.get(OL_AssetFlowCategories.V2GPower_kW) 
;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression3_dataSet_xjal_XValue(  ) {
	return _datasetUpdateTime_xjal();
  }
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression3_dataSet_xjal_YValue(  ) {
    return 
fm_currentAssetFlows_kW.get(batteriesChargingPower_kW) 
;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression4_dataSet_xjal_XValue(  ) {
	return _datasetUpdateTime_xjal();
  }
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression4_dataSet_xjal_YValue(  ) {
    return 
fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY) 
;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression5_dataSet_xjal_XValue(  ) {
	return _datasetUpdateTime_xjal();
  }
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression5_dataSet_xjal_YValue(  ) {
    return 
v_liveConnectionMetaData.getContractedDeliveryCapacity_kW() 
;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression6_dataSet_xjal_XValue(  ) {
	return _datasetUpdateTime_xjal();
  }
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __pl_powerFlows_expression6_dataSet_xjal_YValue(  ) {
    return 
- v_liveConnectionMetaData.getContractedFeedinCapacity_kW() 
;
  }

  // View areas
  public ViewArea va_gridConnection = new ViewArea( this, null, 0, 0, 1920, 980 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1920.0, 980.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "va_gridConnection", this.va_gridConnection );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_viewData_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text6_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text10_Font = new Font("SansSerif", 0, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_energyBalance_Font = new Font("SansSerif", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_energyBalance = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _line2 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _line4 = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _line5 = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _text6 = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _line6 = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _text10 = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_energyBalance = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_powerFlows = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_viewData = 17;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 18;

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
	  level.addAll(rect_energyBalance, text, line, line1, text1, line2, text2, text4, line4, line5, text5, text6, line6, pl_powerFlows, text10, txt_energyBalance, button_viewData);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _button_viewData: {
          ShapeButton self = this.button_viewData;
energyModel.energyDataViewer.f_fillEnergyDataViewer(this, energyModel.p_timeParameters);
energyModel.energyDataViewer.viewArea.navigateTo(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  protected ShapeButton button_viewData;
  protected TimePlot pl_powerFlows;
  protected ShapeRectangle rect_energyBalance;
  protected ShapeText text;
  protected ShapeLine line;
  protected ShapeLine line1;
  protected ShapeText text1;
  protected ShapeLine line2;
  protected ShapeText text2;
  protected ShapeText text4;
  protected ShapeLine line4;
  protected ShapeLine line5;
  protected ShapeText text5;
  protected ShapeText text6;
  protected ShapeLine line6;
  protected ShapeText text10;
  protected ShapeText txt_energyBalance;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    button_viewData = new ShapeButton(
GridConnection.this, true, 360.0, -60.0,
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
    rect_energyBalance = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,0.0, 600.0, 0.0, 0.0,
            null, azure,
			570.0, 380.0, 10.0, 1.0, LINE_STYLE_SOLID );
    text = new ShapeText(
        SHAPE_DRAW_2D, false,50.0, 10.0, 0.0, 0.0,
        black,"ID & connections",
        _text_Font, ALIGNMENT_LEFT );
    line = new ShapeLine(
		SHAPE_DRAW_2D3D, false, 20.0, 30.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line1 = new ShapeLine(
		SHAPE_DRAW_2D3D, false, 250.0, 30.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text1 = new ShapeText(
        SHAPE_DRAW_2D, false,280.0, 10.0, 0.0, 0.0,
        black,"Characteristics",
        _text1_Font, ALIGNMENT_LEFT );
    line2 = new ShapeLine(
		SHAPE_DRAW_2D3D, false, 600.0, 30.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text2 = new ShapeText(
        SHAPE_DRAW_2D, false,640.0, 10.0, 0.0, 0.0,
        black,"Assets",
        _text2_Font, ALIGNMENT_LEFT );
    text4 = new ShapeText(
        SHAPE_DRAW_2D, false,970.0, 10.0, 0.0, 0.0,
        black,"Functions",
        _text4_Font, ALIGNMENT_LEFT );
    line4 = new ShapeLine(
		SHAPE_DRAW_2D3D, false, 920.0, 30.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line5 = new ShapeLine(
		SHAPE_DRAW_2D3D, false, 900.0, 50.0, 0.0, black,
 		0.0,	90.0, 0.0, 1.0, 10.0, LINE_STYLE_DOTTED );
    text5 = new ShapeText(
        SHAPE_DRAW_2D, false,880.0, 86.0, 0.0, 4.71238898038469,
        black,"Init",
        _text5_Font, ALIGNMENT_LEFT );
    text6 = new ShapeText(
        SHAPE_DRAW_2D, false,880.0, 300.0, 0.0, 4.71238898038469,
        black,"Occuring",
        _text6_Font, ALIGNMENT_LEFT );
    line6 = new ShapeLine(
		SHAPE_DRAW_2D3D, false, 900.0, 260.0, 0.0, black,
 		0.0,	190.0, 0.0, 1.0, 10.0, LINE_STYLE_DOTTED );
    text10 = new ShapeText(
        SHAPE_DRAW_2D, false,130.0, 1010.0, 0.0, 0.0,
        black,"Electricity flows within grid connection",
        _text10_Font, ALIGNMENT_LEFT );
    txt_energyBalance = new ShapeText(
        SHAPE_DRAW_2D, false,280.0, 610.0, 0.0, 0.0,
        black,"Energy balance monitor",
        _txt_energyBalance_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataSet> _items = new ArrayList<DataSet>( 7 );
    _items.add( new DataSet(672, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( _datasetUpdateTime_xjal() == _lastUpdateX ) { return; }
      _d.add( __pl_powerFlows_expression0_dataSet_xjal_XValue(  ), __pl_powerFlows_expression0_dataSet_xjal_YValue(  ) );
      _lastUpdateX = _datasetUpdateTime_xjal();
    }
  } ) ); 
    _items.add( new DataSet(672, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( _datasetUpdateTime_xjal() == _lastUpdateX ) { return; }
      _d.add( __pl_powerFlows_expression1_dataSet_xjal_XValue(  ), __pl_powerFlows_expression1_dataSet_xjal_YValue(  ) );
      _lastUpdateX = _datasetUpdateTime_xjal();
    }
  } ) ); 
    _items.add( new DataSet(672, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( _datasetUpdateTime_xjal() == _lastUpdateX ) { return; }
      _d.add( __pl_powerFlows_expression2_dataSet_xjal_XValue(  ), __pl_powerFlows_expression2_dataSet_xjal_YValue(  ) );
      _lastUpdateX = _datasetUpdateTime_xjal();
    }
  } ) ); 
    _items.add( new DataSet(672, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( _datasetUpdateTime_xjal() == _lastUpdateX ) { return; }
      _d.add( __pl_powerFlows_expression3_dataSet_xjal_XValue(  ), __pl_powerFlows_expression3_dataSet_xjal_YValue(  ) );
      _lastUpdateX = _datasetUpdateTime_xjal();
    }
  } ) ); 
    _items.add( new DataSet(672, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( _datasetUpdateTime_xjal() == _lastUpdateX ) { return; }
      _d.add( __pl_powerFlows_expression4_dataSet_xjal_XValue(  ), __pl_powerFlows_expression4_dataSet_xjal_YValue(  ) );
      _lastUpdateX = _datasetUpdateTime_xjal();
    }
  } ) ); 
    _items.add( new DataSet(672, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( _datasetUpdateTime_xjal() == _lastUpdateX ) { return; }
      _d.add( __pl_powerFlows_expression5_dataSet_xjal_XValue(  ), __pl_powerFlows_expression5_dataSet_xjal_YValue(  ) );
      _lastUpdateX = _datasetUpdateTime_xjal();
    }
  } ) ); 
    _items.add( new DataSet(672, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( _datasetUpdateTime_xjal() == _lastUpdateX ) { return; }
      _d.add( __pl_powerFlows_expression6_dataSet_xjal_XValue(  ), __pl_powerFlows_expression6_dataSet_xjal_YValue(  ) );
      _lastUpdateX = _datasetUpdateTime_xjal();
    }
  } ) ); 
    List<String> _titles = new ArrayList<>( 7 );
    _titles.add( "Production assets output [kW]" );
    _titles.add( "Conversion assets demand [kW]" );
    _titles.add( "EV charging demand [kW]" );
    _titles.add( "Battery load [kW]" );
    _titles.add( "GRID LOAD" );
    _titles.add( "Grid connection limit" );
    _titles.add( " Grid connection limit" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 7 );
    _appearances.add( new Chart2DPlot.Appearance( violetRed, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( coral, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( limeGreen, true, false, Chart.INTERPOLATION_LINEAR, 2.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( maroon, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( blue, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( red, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( red, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    pl_powerFlows = new TimePlot(
GridConnection.this, false, 20.0, 1010.0,
			500.0, 280.0,
            null, null,
            50.0, 30.0,
			420.0, 160.0, white, black, black,
            60.0, Chart.SOUTH,

48 
            , Chart.WINDOW_MOVES_WITH_TIME, "HH:mm", Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }



  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
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
  public GridConnection( Engine engine, Agent owner, AgentList<? extends GridConnection> ownerPopulation ) {
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
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    energyModel = get_EnergyModel();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public GridConnection() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public GridConnection( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco ) {
    markParametersAreSet();
    this.p_parentNodeElectricID = p_parentNodeElectricID;
    this.p_gridConnectionID = p_gridConnectionID;
    this.p_parentNodeHeatID = p_parentNodeHeatID;
    this.p_BuildingThermalAsset = p_BuildingThermalAsset;
    this.p_ownerID = p_ownerID;
    this.p_batteryAsset = p_batteryAsset;
    this.p_heatBuffer = p_heatBuffer;
    this.p_gasBuffer = p_gasBuffer;
    this.p_cookingTracker = p_cookingTracker;
    this.p_insulationLabel = p_insulationLabel;
    this.p_DHWAsset = p_DHWAsset;
    this.p_longitude = p_longitude;
    this.p_latitude = p_latitude;
    this.p_floorSurfaceArea_m2 = p_floorSurfaceArea_m2;
    this.p_owner = p_owner;
    this.p_roofSurfaceArea_m2 = p_roofSurfaceArea_m2;
    this.p_purposeBAG = p_purposeBAG;
    this.p_address = p_address;
    this.p_parentNodeHeat = p_parentNodeHeat;
    this.p_parentNodeElectric = p_parentNodeElectric;
    this.v_isActive = v_isActive;
    this.p_energyLabel = p_energyLabel;
    this.p_airco = p_airco;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_GridConnection_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( GridConnection.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon = new ShapeModelElementsGroup( GridConnection.this, getElementProperty( "zero_engine.GridConnection.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
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
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( GridConnection.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _pl_powerFlows_autoUpdateEvent_xjal.start();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

energyModel.c_gridConnections.add(this);


v_liveData = new J_LiveData();
v_liveData.activeEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeProductionEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeConsumptionEnergyCarriers= EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveConnectionMetaData = new J_ConnectionMetaData(this);
v_liveAssetsMetaData = new J_AssetsMetaData(this);
v_liveData.connectionMetaData = v_liveConnectionMetaData;
v_liveData.assetsMetaData = v_liveAssetsMetaData;

fm_currentProductionFlows_kW = new J_FlowsMap();
fm_currentConsumptionFlows_kW = new J_FlowsMap();
fm_currentBalanceFlows_kW = new J_FlowsMap();
fm_currentAssetFlows_kW = new J_ValueMap(OL_AssetFlowCategories.class);

fm_consumptionForHeating_kW = new J_FlowsMap();
fm_heatFromEnergyCarrier_kW = new J_FlowsMap(); 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_GridConnection_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_GridConnection_xjal() {
    v_previousPowerElectricity_kW = 
0 
;
    v_previousPowerHeat_kW = 
0 
;
    v_previousRunData = 
null 
;
  }

  // User API -----------------------------------------------------
  public EnergyModel get_EnergyModel() {
    {
      Agent owner = getOwner();
      if ( owner instanceof EnergyModel ) return (EnergyModel) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zero_engine.EnergyModel energyModel;

  public AgentList<? extends GridConnection> getPopulation() {
    return (AgentList<? extends GridConnection>) super.getPopulation();
  }

  public List<? extends GridConnection> agentsInRange( double distance ) {
    return (List<? extends GridConnection>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _pl_powerFlows_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _pl_powerFlows_autoUpdateEvent_xjal.onDestroy();
  	for (int _pIdx = 0; _pIdx < pl_powerFlows.getCount(); _pIdx++) {
  		DataSet _ds = pl_powerFlows.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = pl_powerFlows.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "pl_powerFlows : " + _t );
  	}
    super.onDestroy();
  }

  // Additional class code

public final String p_uid = UUID.randomUUID().toString();

public OL_ResultScope getScope(){return OL_ResultScope.GRIDCONNECTION;}
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
