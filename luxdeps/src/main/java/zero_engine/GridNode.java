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
import java.lang.reflect.Field;
import zeroPackage.ZeroMath;
//import zeroPackage.ZeroAccumulator; 

public class GridNode extends Agent
{
  // Parameters

  public 
String  p_gridNodeID;

  /**
   * Returns default value for parameter <code>p_gridNodeID</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_gridNodeID_DefaultValue_xjal() {
    final GridNode self = this;
    return null;
  }

  public void set_p_gridNodeID( String value ) {
    if (value == this.p_gridNodeID) {
      return;
    }
    String _oldValue_xjal = this.p_gridNodeID;
    this.p_gridNodeID = value;
    onChange_p_gridNodeID_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_gridNodeID.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_gridNodeID()</code> method instead.
   */
  protected void onChange_p_gridNodeID() {
    onChange_p_gridNodeID_xjal( p_gridNodeID );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_gridNodeID_xjal( String oldValue ) {  
  }


  public 
String  p_parentNodeID;

  /**
   * Returns default value for parameter <code>p_parentNodeID</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_parentNodeID_DefaultValue_xjal() {
    final GridNode self = this;
    return null;
  }

  public void set_p_parentNodeID( String value ) {
    if (value == this.p_parentNodeID) {
      return;
    }
    String _oldValue_xjal = this.p_parentNodeID;
    this.p_parentNodeID = value;
    onChange_p_parentNodeID_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_parentNodeID.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_parentNodeID()</code> method instead.
   */
  protected void onChange_p_parentNodeID() {
    onChange_p_parentNodeID_xjal( p_parentNodeID );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_parentNodeID_xjal( String oldValue ) {  
  }


  public 
OL_GridNodeType  p_nodeType;

  /**
   * Returns default value for parameter <code>p_nodeType</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_GridNodeType _p_nodeType_DefaultValue_xjal() {
    final GridNode self = this;
    return null;
  }

  public void set_p_nodeType( OL_GridNodeType value ) {
    if (value == this.p_nodeType) {
      return;
    }
    OL_GridNodeType _oldValue_xjal = this.p_nodeType;
    this.p_nodeType = value;
    onChange_p_nodeType_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_nodeType.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_nodeType()</code> method instead.
   */
  protected void onChange_p_nodeType() {
    onChange_p_nodeType_xjal( p_nodeType );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_nodeType_xjal( OL_GridNodeType oldValue ) {  
  }


  public 
OL_EnergyCarriers  p_energyCarrier;

  /**
   * Returns default value for parameter <code>p_energyCarrier</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_EnergyCarriers _p_energyCarrier_DefaultValue_xjal() {
    final GridNode self = this;
    return null;
  }

  public void set_p_energyCarrier( OL_EnergyCarriers value ) {
    if (value == this.p_energyCarrier) {
      return;
    }
    OL_EnergyCarriers _oldValue_xjal = this.p_energyCarrier;
    this.p_energyCarrier = value;
    onChange_p_energyCarrier_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_energyCarrier.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_energyCarrier()</code> method instead.
   */
  protected void onChange_p_energyCarrier() {
    onChange_p_energyCarrier_xjal( p_energyCarrier );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_energyCarrier_xjal( OL_EnergyCarriers oldValue ) {  
  }


  public 
double  p_capacity_kW;

  /**
   * Returns default value for parameter <code>p_capacity_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_capacity_kW_DefaultValue_xjal() {
    final GridNode self = this;
    return 
0 
;
  }

  public void set_p_capacity_kW( double value ) {
    if (value == this.p_capacity_kW) {
      return;
    }
    double _oldValue_xjal = this.p_capacity_kW;
    this.p_capacity_kW = value;
    onChange_p_capacity_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_capacity_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_capacity_kW()</code> method instead.
   */
  protected void onChange_p_capacity_kW() {
    onChange_p_capacity_kW_xjal( p_capacity_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_capacity_kW_xjal( double oldValue ) {  
  }


  public 
J_EAStorageHeat  p_transportBuffer;

  /**
   * Returns default value for parameter <code>p_transportBuffer</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_EAStorageHeat _p_transportBuffer_DefaultValue_xjal() {
    final GridNode self = this;
    return 
null 
;
  }

  public void set_p_transportBuffer( J_EAStorageHeat value ) {
    if (value == this.p_transportBuffer) {
      return;
    }
    J_EAStorageHeat _oldValue_xjal = this.p_transportBuffer;
    this.p_transportBuffer = value;
    onChange_p_transportBuffer_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_transportBuffer.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_transportBuffer()</code> method instead.
   */
  protected void onChange_p_transportBuffer() {
    onChange_p_transportBuffer_xjal( p_transportBuffer );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_transportBuffer_xjal( J_EAStorageHeat oldValue ) {  
  }


  public 
GridOperator  p_ownerGridOperator;

  /**
   * Returns default value for parameter <code>p_ownerGridOperator</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public GridOperator _p_ownerGridOperator_DefaultValue_xjal() {
    final GridNode self = this;
    return 
null 
;
  }

  public void set_p_ownerGridOperator( GridOperator value ) {
    if (value == this.p_ownerGridOperator) {
      return;
    }
    GridOperator _oldValue_xjal = this.p_ownerGridOperator;
    this.p_ownerGridOperator = value;
    onChange_p_ownerGridOperator_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_ownerGridOperator.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_ownerGridOperator()</code> method instead.
   */
  protected void onChange_p_ownerGridOperator() {
    onChange_p_ownerGridOperator_xjal( p_ownerGridOperator );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_ownerGridOperator_xjal( GridOperator oldValue ) {  
  }


  public 
String  p_gridNodeOwnerID;

  /**
   * Returns default value for parameter <code>p_gridNodeOwnerID</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_gridNodeOwnerID_DefaultValue_xjal() {
    final GridNode self = this;
    return null;
  }

  public void set_p_gridNodeOwnerID( String value ) {
    if (value == this.p_gridNodeOwnerID) {
      return;
    }
    String _oldValue_xjal = this.p_gridNodeOwnerID;
    this.p_gridNodeOwnerID = value;
    onChange_p_gridNodeOwnerID_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_gridNodeOwnerID.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_gridNodeOwnerID()</code> method instead.
   */
  protected void onChange_p_gridNodeOwnerID() {
    onChange_p_gridNodeOwnerID_xjal( p_gridNodeOwnerID );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_gridNodeOwnerID_xjal( String oldValue ) {  
  }


  public 
boolean  b_transportBufferValid;

  /**
   * Returns default value for parameter <code>b_transportBufferValid</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_transportBufferValid_DefaultValue_xjal() {
    final GridNode self = this;
    return 
false 
;
  }

  public void set_b_transportBufferValid( boolean value ) {
    if (value == this.b_transportBufferValid) {
      return;
    }
    boolean _oldValue_xjal = this.b_transportBufferValid;
    this.b_transportBufferValid = value;
    onChange_b_transportBufferValid_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_transportBufferValid.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_transportBufferValid()</code> method instead.
   */
  protected void onChange_b_transportBufferValid() {
    onChange_b_transportBufferValid_xjal( b_transportBufferValid );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_transportBufferValid_xjal( boolean oldValue ) {  
  }


  public 
double  p_longitude;

  /**
   * Returns default value for parameter <code>p_longitude</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_longitude_DefaultValue_xjal() {
    final GridNode self = this;
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
    final GridNode self = this;
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
GISRegion  gisRegion;

  /**
   * Returns default value for parameter <code>gisRegion</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public GISRegion _gisRegion_DefaultValue_xjal() {
    final GridNode self = this;
    return null;
  }

  public void set_gisRegion( GISRegion value ) {
    if (value == this.gisRegion) {
      return;
    }
    GISRegion _oldValue_xjal = this.gisRegion;
    this.gisRegion = value;
    onChange_gisRegion_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter gisRegion.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_gisRegion()</code> method instead.
   */
  protected void onChange_gisRegion() {
    onChange_gisRegion_xjal( gisRegion );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_gisRegion_xjal( GISRegion oldValue ) {  
  }


  public 
String  p_description;

  /**
   * Returns default value for parameter <code>p_description</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_description_DefaultValue_xjal() {
    final GridNode self = this;
    return null;
  }

  public void set_p_description( String value ) {
    if (value == this.p_description) {
      return;
    }
    String _oldValue_xjal = this.p_description;
    this.p_description = value;
    onChange_p_description_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_description.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_description()</code> method instead.
   */
  protected void onChange_p_description() {
    onChange_p_description_xjal( p_description );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_description_xjal( String oldValue ) {  
  }


  /**
   * This value is set as true in the loader if the capacity of the grid node is available, if not, it should be set as false!
   */
  public 
boolean  p_realCapacityAvailable;

  /**
   * Returns default value for parameter <code>p_realCapacityAvailable</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _p_realCapacityAvailable_DefaultValue_xjal() {
    final GridNode self = this;
    return 
false 
;
  }

  public void set_p_realCapacityAvailable( boolean value ) {
    if (value == this.p_realCapacityAvailable) {
      return;
    }
    boolean _oldValue_xjal = this.p_realCapacityAvailable;
    this.p_realCapacityAvailable = value;
    onChange_p_realCapacityAvailable_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_realCapacityAvailable.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_realCapacityAvailable()</code> method instead.
   */
  protected void onChange_p_realCapacityAvailable() {
    onChange_p_realCapacityAvailable_xjal( p_realCapacityAvailable );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_realCapacityAvailable_xjal( boolean oldValue ) {  
  }


  public 
GISRegion  p_serviceAreaGisRegion;

  /**
   * Returns default value for parameter <code>p_serviceAreaGisRegion</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public GISRegion _p_serviceAreaGisRegion_DefaultValue_xjal() {
    final GridNode self = this;
    return null;
  }

  public void set_p_serviceAreaGisRegion( GISRegion value ) {
    if (value == this.p_serviceAreaGisRegion) {
      return;
    }
    GISRegion _oldValue_xjal = this.p_serviceAreaGisRegion;
    this.p_serviceAreaGisRegion = value;
    onChange_p_serviceAreaGisRegion_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_serviceAreaGisRegion.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_serviceAreaGisRegion()</code> method instead.
   */
  protected void onChange_p_serviceAreaGisRegion() {
    onChange_p_serviceAreaGisRegion_xjal( p_serviceAreaGisRegion );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_serviceAreaGisRegion_xjal( GISRegion oldValue ) {  
  }


  /**
   * Color used to color net neighbours. Default = gray, so all unknown net neighbours and gridnodes become gray.
   */
  public 
Color  p_uniqueColor;

  /**
   * Returns default value for parameter <code>p_uniqueColor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Color _p_uniqueColor_DefaultValue_xjal() {
    final GridNode self = this;
    return 
gray 
;
  }

  public void set_p_uniqueColor( Color value ) {
    if (value == this.p_uniqueColor) {
      return;
    }
    Color _oldValue_xjal = this.p_uniqueColor;
    this.p_uniqueColor = value;
    onChange_p_uniqueColor_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_uniqueColor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_uniqueColor()</code> method instead.
   */
  protected void onChange_p_uniqueColor() {
    onChange_p_uniqueColor_xjal( p_uniqueColor );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_uniqueColor_xjal( Color oldValue ) {  
  }


  public 
double  p_localNodalPricingFactor_eurpkWh;

  /**
   * Returns default value for parameter <code>p_localNodalPricingFactor_eurpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_localNodalPricingFactor_eurpkWh_DefaultValue_xjal() {
    final GridNode self = this;
    return 
0.20 
;
  }

  public void set_p_localNodalPricingFactor_eurpkWh( double value ) {
    if (value == this.p_localNodalPricingFactor_eurpkWh) {
      return;
    }
    double _oldValue_xjal = this.p_localNodalPricingFactor_eurpkWh;
    this.p_localNodalPricingFactor_eurpkWh = value;
    onChange_p_localNodalPricingFactor_eurpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_localNodalPricingFactor_eurpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_localNodalPricingFactor_eurpkWh()</code> method instead.
   */
  protected void onChange_p_localNodalPricingFactor_eurpkWh() {
    onChange_p_localNodalPricingFactor_eurpkWh_xjal( p_localNodalPricingFactor_eurpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_localNodalPricingFactor_eurpkWh_xjal( double oldValue ) {  
  }


  public 
Color  p_defaultLineColor;

  /**
   * Returns default value for parameter <code>p_defaultLineColor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Color _p_defaultLineColor_DefaultValue_xjal() {
    final GridNode self = this;
    return 
green.brighter() 
;
  }

  public void set_p_defaultLineColor( Color value ) {
    if (value == this.p_defaultLineColor) {
      return;
    }
    Color _oldValue_xjal = this.p_defaultLineColor;
    this.p_defaultLineColor = value;
    onChange_p_defaultLineColor_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultLineColor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultLineColor()</code> method instead.
   */
  protected void onChange_p_defaultLineColor() {
    onChange_p_defaultLineColor_xjal( p_defaultLineColor );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultLineColor_xjal( Color oldValue ) {  
  }


  public 
Color  p_defaultFillColor;

  /**
   * Returns default value for parameter <code>p_defaultFillColor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Color _p_defaultFillColor_DefaultValue_xjal() {
    final GridNode self = this;
    return 
green 
;
  }

  public void set_p_defaultFillColor( Color value ) {
    if (value == this.p_defaultFillColor) {
      return;
    }
    Color _oldValue_xjal = this.p_defaultFillColor;
    this.p_defaultFillColor = value;
    onChange_p_defaultFillColor_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultFillColor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultFillColor()</code> method instead.
   */
  protected void onChange_p_defaultFillColor() {
    onChange_p_defaultFillColor_xjal( p_defaultFillColor );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultFillColor_xjal( Color oldValue ) {  
  }


  public 
double  p_localNodalPricingTreshold_fr;

  /**
   * Returns default value for parameter <code>p_localNodalPricingTreshold_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_localNodalPricingTreshold_fr_DefaultValue_xjal() {
    final GridNode self = this;
    return 
0.5 
;
  }

  public void set_p_localNodalPricingTreshold_fr( double value ) {
    if (value == this.p_localNodalPricingTreshold_fr) {
      return;
    }
    double _oldValue_xjal = this.p_localNodalPricingTreshold_fr;
    this.p_localNodalPricingTreshold_fr = value;
    onChange_p_localNodalPricingTreshold_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_localNodalPricingTreshold_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_localNodalPricingTreshold_fr()</code> method instead.
   */
  protected void onChange_p_localNodalPricingTreshold_fr() {
    onChange_p_localNodalPricingTreshold_fr_xjal( p_localNodalPricingTreshold_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_localNodalPricingTreshold_fr_xjal( double oldValue ) {  
  }


  public 
double  p_originalCapacity_kW;

  /**
   * Returns default value for parameter <code>p_originalCapacity_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_originalCapacity_kW_DefaultValue_xjal() {
    final GridNode self = this;
    return 0.0;
  }

  public void set_p_originalCapacity_kW( double value ) {
    if (value == this.p_originalCapacity_kW) {
      return;
    }
    double _oldValue_xjal = this.p_originalCapacity_kW;
    this.p_originalCapacity_kW = value;
    onChange_p_originalCapacity_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_originalCapacity_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_originalCapacity_kW()</code> method instead.
   */
  protected void onChange_p_originalCapacity_kW() {
    onChange_p_originalCapacity_kW_xjal( p_originalCapacity_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_originalCapacity_kW_xjal( double oldValue ) {  
  }


  public 
OL_GridNodeProfileLoaderType  p_profileType;

  /**
   * Returns default value for parameter <code>p_profileType</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_GridNodeProfileLoaderType _p_profileType_DefaultValue_xjal() {
    final GridNode self = this;
    return 
OL_GridNodeProfileLoaderType.NO_PROFILE 
;
  }

  public void set_p_profileType( OL_GridNodeProfileLoaderType value ) {
    if (value == this.p_profileType) {
      return;
    }
    OL_GridNodeProfileLoaderType _oldValue_xjal = this.p_profileType;
    this.p_profileType = value;
    onChange_p_profileType_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_profileType.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_profileType()</code> method instead.
   */
  protected void onChange_p_profileType() {
    onChange_p_profileType_xjal( p_profileType );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_profileType_xjal( OL_GridNodeProfileLoaderType oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_gridNodeID = _p_gridNodeID_DefaultValue_xjal();
    p_parentNodeID = _p_parentNodeID_DefaultValue_xjal();
    p_nodeType = _p_nodeType_DefaultValue_xjal();
    p_energyCarrier = _p_energyCarrier_DefaultValue_xjal();
    p_capacity_kW = _p_capacity_kW_DefaultValue_xjal();
    p_transportBuffer = _p_transportBuffer_DefaultValue_xjal();
    p_ownerGridOperator = _p_ownerGridOperator_DefaultValue_xjal();
    p_gridNodeOwnerID = _p_gridNodeOwnerID_DefaultValue_xjal();
    b_transportBufferValid = _b_transportBufferValid_DefaultValue_xjal();
    p_longitude = _p_longitude_DefaultValue_xjal();
    p_latitude = _p_latitude_DefaultValue_xjal();
    gisRegion = _gisRegion_DefaultValue_xjal();
    p_description = _p_description_DefaultValue_xjal();
    p_realCapacityAvailable = _p_realCapacityAvailable_DefaultValue_xjal();
    p_serviceAreaGisRegion = _p_serviceAreaGisRegion_DefaultValue_xjal();
    p_uniqueColor = _p_uniqueColor_DefaultValue_xjal();
    p_localNodalPricingFactor_eurpkWh = _p_localNodalPricingFactor_eurpkWh_DefaultValue_xjal();
    p_defaultLineColor = _p_defaultLineColor_DefaultValue_xjal();
    p_defaultFillColor = _p_defaultFillColor_DefaultValue_xjal();
    p_localNodalPricingTreshold_fr = _p_localNodalPricingTreshold_fr_DefaultValue_xjal();
    p_originalCapacity_kW = _p_originalCapacity_kW_DefaultValue_xjal();
    p_profileType = _p_profileType_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_gridNodeID":
      if ( _callOnChange_xjal ) {
        set_p_gridNodeID( (String) _value_xjal );
      } else {
        p_gridNodeID = (String) _value_xjal;
      }
      return true;
    case "p_parentNodeID":
      if ( _callOnChange_xjal ) {
        set_p_parentNodeID( (String) _value_xjal );
      } else {
        p_parentNodeID = (String) _value_xjal;
      }
      return true;
    case "p_nodeType":
      if ( _callOnChange_xjal ) {
        set_p_nodeType( (OL_GridNodeType) _value_xjal );
      } else {
        p_nodeType = (OL_GridNodeType) _value_xjal;
      }
      return true;
    case "p_energyCarrier":
      if ( _callOnChange_xjal ) {
        set_p_energyCarrier( (OL_EnergyCarriers) _value_xjal );
      } else {
        p_energyCarrier = (OL_EnergyCarriers) _value_xjal;
      }
      return true;
    case "p_capacity_kW":
      if ( _callOnChange_xjal ) {
        set_p_capacity_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_capacity_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_transportBuffer":
      if ( _callOnChange_xjal ) {
        set_p_transportBuffer( (J_EAStorageHeat) _value_xjal );
      } else {
        p_transportBuffer = (J_EAStorageHeat) _value_xjal;
      }
      return true;
    case "p_ownerGridOperator":
      if ( _callOnChange_xjal ) {
        set_p_ownerGridOperator( (GridOperator) _value_xjal );
      } else {
        p_ownerGridOperator = (GridOperator) _value_xjal;
      }
      return true;
    case "p_gridNodeOwnerID":
      if ( _callOnChange_xjal ) {
        set_p_gridNodeOwnerID( (String) _value_xjal );
      } else {
        p_gridNodeOwnerID = (String) _value_xjal;
      }
      return true;
    case "b_transportBufferValid":
      if ( _callOnChange_xjal ) {
        set_b_transportBufferValid( (Boolean) _value_xjal );
      } else {
        b_transportBufferValid = (Boolean) _value_xjal;
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
    case "gisRegion":
      if ( _callOnChange_xjal ) {
        set_gisRegion( (GISRegion) _value_xjal );
      } else {
        gisRegion = (GISRegion) _value_xjal;
      }
      return true;
    case "p_description":
      if ( _callOnChange_xjal ) {
        set_p_description( (String) _value_xjal );
      } else {
        p_description = (String) _value_xjal;
      }
      return true;
    case "p_realCapacityAvailable":
      if ( _callOnChange_xjal ) {
        set_p_realCapacityAvailable( (Boolean) _value_xjal );
      } else {
        p_realCapacityAvailable = (Boolean) _value_xjal;
      }
      return true;
    case "p_serviceAreaGisRegion":
      if ( _callOnChange_xjal ) {
        set_p_serviceAreaGisRegion( (GISRegion) _value_xjal );
      } else {
        p_serviceAreaGisRegion = (GISRegion) _value_xjal;
      }
      return true;
    case "p_uniqueColor":
      if ( _callOnChange_xjal ) {
        set_p_uniqueColor( (Color) _value_xjal );
      } else {
        p_uniqueColor = (Color) _value_xjal;
      }
      return true;
    case "p_localNodalPricingFactor_eurpkWh":
      if ( _callOnChange_xjal ) {
        set_p_localNodalPricingFactor_eurpkWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_localNodalPricingFactor_eurpkWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_defaultLineColor":
      if ( _callOnChange_xjal ) {
        set_p_defaultLineColor( (Color) _value_xjal );
      } else {
        p_defaultLineColor = (Color) _value_xjal;
      }
      return true;
    case "p_defaultFillColor":
      if ( _callOnChange_xjal ) {
        set_p_defaultFillColor( (Color) _value_xjal );
      } else {
        p_defaultFillColor = (Color) _value_xjal;
      }
      return true;
    case "p_localNodalPricingTreshold_fr":
      if ( _callOnChange_xjal ) {
        set_p_localNodalPricingTreshold_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_localNodalPricingTreshold_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_originalCapacity_kW":
      if ( _callOnChange_xjal ) {
        set_p_originalCapacity_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_originalCapacity_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_profileType":
      if ( _callOnChange_xjal ) {
        set_p_profileType( (OL_GridNodeProfileLoaderType) _value_xjal );
      } else {
        p_profileType = (OL_GridNodeProfileLoaderType) _value_xjal;
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
    case "p_gridNodeID": _result_xjal = p_gridNodeID; break;
    case "p_parentNodeID": _result_xjal = p_parentNodeID; break;
    case "p_nodeType": _result_xjal = p_nodeType; break;
    case "p_energyCarrier": _result_xjal = p_energyCarrier; break;
    case "p_capacity_kW": _result_xjal = p_capacity_kW; break;
    case "p_transportBuffer": _result_xjal = p_transportBuffer; break;
    case "p_ownerGridOperator": _result_xjal = p_ownerGridOperator; break;
    case "p_gridNodeOwnerID": _result_xjal = p_gridNodeOwnerID; break;
    case "b_transportBufferValid": _result_xjal = b_transportBufferValid; break;
    case "p_longitude": _result_xjal = p_longitude; break;
    case "p_latitude": _result_xjal = p_latitude; break;
    case "gisRegion": _result_xjal = gisRegion; break;
    case "p_description": _result_xjal = p_description; break;
    case "p_realCapacityAvailable": _result_xjal = p_realCapacityAvailable; break;
    case "p_serviceAreaGisRegion": _result_xjal = p_serviceAreaGisRegion; break;
    case "p_uniqueColor": _result_xjal = p_uniqueColor; break;
    case "p_localNodalPricingFactor_eurpkWh": _result_xjal = p_localNodalPricingFactor_eurpkWh; break;
    case "p_defaultLineColor": _result_xjal = p_defaultLineColor; break;
    case "p_defaultFillColor": _result_xjal = p_defaultFillColor; break;
    case "p_localNodalPricingTreshold_fr": _result_xjal = p_localNodalPricingTreshold_fr; break;
    case "p_originalCapacity_kW": _result_xjal = p_originalCapacity_kW; break;
    case "p_profileType": _result_xjal = p_profileType; break;
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
      list.add( "p_gridNodeID" );
      list.add( "p_parentNodeID" );
      list.add( "p_nodeType" );
      list.add( "p_energyCarrier" );
      list.add( "p_capacity_kW" );
      list.add( "p_transportBuffer" );
      list.add( "p_ownerGridOperator" );
      list.add( "p_gridNodeOwnerID" );
      list.add( "b_transportBufferValid" );
      list.add( "p_longitude" );
      list.add( "p_latitude" );
      list.add( "gisRegion" );
      list.add( "p_description" );
      list.add( "p_realCapacityAvailable" );
      list.add( "p_serviceAreaGisRegion" );
      list.add( "p_uniqueColor" );
      list.add( "p_localNodalPricingFactor_eurpkWh" );
      list.add( "p_defaultLineColor" );
      list.add( "p_defaultFillColor" );
      list.add( "p_localNodalPricingTreshold_fr" );
      list.add( "p_originalCapacity_kW" );
      list.add( "p_profileType" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
double 
 v_timeOfPeakPosLoadFiltered_h;
  public 
double 
 v_timeOfPeakLoadFiltered_h;
  public 
double 
 v_timeOfPeakNegLoadFiltered_h;
  public 
double 
 v_currentCongestionPrice_eurpkWh;
  public 
double 
 v_filteredLoadCongestionPricing_kW;
  public 
ZeroAccumulator 
 acc_annualElectricityBalance_kW;
  public 
double 
 v_currentLocalNodalPrice_eurpkWh;
  public 
double 
 v_currentTotalNodalPrice_eurpkWh;
  public 
double 
 v_currentLoad_kW;
  public 
double 
 v_totalImport_MWh;
  public 
double 
 v_totalExport_MWh;
  public 
double 
 v_summerWeekImport_MWh;
  public 
double 
 v_summerWeekExport_MWh;
  public 
double 
 v_winterWeekImport_MWh;
  public 
double 
 v_winterWeekExport_MWh;
  public 
ZeroAccumulator 
 acc_annualHeatBalance_kW;
  public 
boolean 
 v_congested;
  public 
String 
 v_congestionMode;
  /**
   * Houdt de piekbelasting in kW over de modelrun bij (absolute waarde) voor kostenberekeningen netverzwaringen (totale gebiedskosten). Geupdate in f_calculateEnergyBalance.<br>
   * <br>
   * @author: Jorrit<br>
   * @since: 27-10-2022
   */
  public 
double 
 v_peakLoadAbsolute_kW;
  public 
double 
 v_currentLoadElectricityLowPassed_kW;
  public 
double 
 v_lowPassFactor_fr;
  /**
   * Houdt de piekbelasting in kW over de modelrun bij (absolute waarde) voor kostenberekeningen netverzwaringen (totale gebiedskosten). Geupdate in f_calculateEnergyBalance.<br>
   * <br>
   * @author: Jorrit<br>
   * @since: 27-10-2022
   */
  public 
double 
 v_peakLoadFilteredElectricity_kW;
  /**
   * Houdt de piekbelasting in kW over de modelrun bij (absolute waarde) voor kostenberekeningen netverzwaringen (totale gebiedskosten). Geupdate in f_calculateEnergyBalance.<br>
   * <br>
   * @author: Jorrit<br>
   * @since: 27-10-2022
   */
  public 
double 
 v_peakPosLoadElectricity_kW;
  /**
   * Houdt de piekbelasting in kW over de modelrun bij (absolute waarde) voor kostenberekeningen netverzwaringen (totale gebiedskosten). Geupdate in f_calculateEnergyBalance.<br>
   * <br>
   * @author: Jorrit<br>
   * @since: 27-10-2022
   */
  public 
double 
 v_peakNegLoadElectricity_kW;
  public 
double 
 v_lowPassFactorCongestionPricing_fr;
  public 
double 
 v_totalTimeOverloaded_h;
  public 
double 
 v_annualExcessImport_MWh;
  public 
double 
 v_annualExcessExport_MWh;
  public 
double 
 v_summerWeekExcessImport_MWh;
  public 
double 
 v_summerWeekExcessExport_MWh;
  public 
double 
 v_winterWeekExcessImport_MWh;
  public 
double 
 v_winterWeekExcessExport_MWh;
  public 
double 
 v_daytimeExcessImport_MWh;
  public 
double 
 v_daytimeExcessExport_MWh;
  public 
double 
 v_nighttimeExcessImport_MWh;
  public 
double 
 v_nighttimeExcessExport_MWh;
  public 
double 
 v_weekdayExcessImport_MWh;
  public 
double 
 v_weekdayExcessExport_MWh;
  public 
double 
 v_weekendExcessImport_MWh;
  public 
double 
 v_weekendExcessExport_MWh;
  /**
   * Given a default value for 'top' agents, this can be seen as average market price of electricity.
   */
  public 
double 
 v_currentParentNodalPrice_eurpkWh;
  public 
double 
 v_totalInstalledWindPower_kW;
  public 
double 
 v_totalInstalledPVPower_kW;
  public 
double 
 v_electricityYieldForecast_fr;
  public 
double 
 v_currentDLRCapacity_kW;
  public 
double 
 v_daytimeImport_MWh;
  public 
double 
 v_daytimeExport_MWh;
  public 
double 
 v_weekdayImport_MWh;
  public 
double 
 v_weekdayExport_MWh;
  public 
double 
 v_nighttimeImport_MWh;
  public 
double 
 v_nighttimeExport_MWh;
  public 
double 
 v_weekendImport_MWh;
  public 
double 
 v_weekendExport_MWh;
  private 
double 
 v_currentChargingPowerBalancingThisGN_kW;
  private 
int 
 v_currentNumberOfChargeRequestsBalancingThisGN;
  public 
double 
 v_lowPassedLoadFilter_kW;

  // Collection Variables
  
ArrayList <
GridConnection > c_connectedGridConnections = new ArrayList<GridConnection>();
  
ArrayList <
EnergyCoop > c_energyCoops = new ArrayList<EnergyCoop>();
  
ArrayList <
GridNode > c_connectedGridNodes = new ArrayList<GridNode>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( GridNode.class );

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


  // Functions

  void f_connectToParentNode(  ) { 

GridNode myParentNode = findFirst(energyModel.pop_gridNodes, p->p.p_gridNodeID.equals(p_parentNodeID));
if( myParentNode instanceof GridNode ) {
	//superConnection.connectTo(myParentNode);
	myParentNode.f_connectToChild(this);
}

GridOperator myParentGridOperator = findFirst(energyModel.pop_gridOperators, p->p.p_actorID.equals(p_gridNodeOwnerID)) ;
if( myParentGridOperator instanceof GridOperator) {
	p_ownerGridOperator = myParentGridOperator;
	//superConnection.connectTo(myParentGridOperator);
	myParentGridOperator.f_connectToChild(this, p_energyCarrier);
}
 
  }

  void f_connectToChild( Agent ConnectingChildNode ) { 

//subConnections.connectTo(ConnectingChildNode);

if ( ConnectingChildNode instanceof GridNode) {
	 c_connectedGridNodes.add( (GridNode)ConnectingChildNode );
}

if ( ConnectingChildNode instanceof GridConnection) {
	 c_connectedGridConnections.add( (GridConnection)ConnectingChildNode );
}

if ( ConnectingChildNode instanceof EnergyCoop) {
	 c_energyCoops.add( (EnergyCoop)ConnectingChildNode );
}

/*if( ConnectingChildNode instanceof EnergyAsset ) {
	J_EA j_ea = (J_EA) ConnectingChildNode;
	c_connectedEnergyAssets.add(j_ea);
	if (j_ea instanceof J_EAConsumption) {
		c_connectedConsumptionAssets.add((J_EAConsumption)j_ea);
	} else if (j_ea instanceof J_EAProduction ) {
		c_connectedProductionAssets.add((J_EAProduction)j_ea);
	} else if (j_ea instanceof J_EAStorage ) {
		c_connectedStorageAssets.add((J_EAStorage)j_ea);
		if (j_ea instanceof J_EAStorageHeat) {
			p_transportBuffer = (J_EAStorageHeat)j_ea;
		}
	} else if (j_ea instanceof J_EAConversion) {
		c_connectedConversionAssets.add((J_EAConversion)j_ea);
//	if (EA.j_ea instanceof J_EAConversionGasBurner || EA.j_ea instanceof J_EAConversionHeatPump || EA.j_ea instanceof J_EAConversionHeatDeliverySet ) {
	//	p_HeatingAsset = EA;
//		//traceln("heatingAsset class " + p_spaceHeatingAsset.getClass().toString());
//	}
	} else {
		traceln("f_connectToChild in EnergyAsset: Exception! EnergyAsset " + ConnectingChildNode.getId() + " is of unknown type or null! ");
	}
}*/
 
  }

  void f_sumLoads(  ) { 

v_currentLoad_kW = 0;

// determine the net energy flows from all subconnections by nodetype

for( GridNode GN : c_connectedGridNodes ) {
	v_currentLoad_kW += GN.v_currentLoad_kW;
}

for( GridConnection GC : c_connectedGridConnections) {
	v_currentLoad_kW += GC.fm_currentBalanceFlows_kW.get(p_energyCarrier);
}


/*if( p_energyType == OL_EnergyCarriers.ELECTRICITY ){
	v_electricLoadRatioExclBattery = v_currentLoadElectricity_kW / p_capacity_kW;
}*/

 
  }

  void f_nodeMetering( J_TimeVariables timeVariables, J_TimeParameters timeParameters, boolean isRapidRun ) { 

//v_averageAbsoluteLoadElectricity_kW = ( v_electricityDrawn_kWh + v_electricityDelivered_kWh ) / energyModel.t_h;
//v_loadFactor_fr = v_averageAbsoluteLoadElectricity_kW / abs(v_peakLoadAbsoluteElectricity_kW);

if (isRapidRun){
	/*if (energyModel.b_enableDLR) {
		acc_annualElectricityBalance_kW.addStep(100*v_currentLoadElectricity_kW/ (p_capacity_kW * energyModel.v_currentDLRfactor_fr));
		//acc_DLR_kW.addStep( p_capacity_kW * energyModel.v_currentDLRfactor_fr);
	} else {
		acc_annualElectricityBalance_kW.addStep(v_currentLoadElectricity_kW;
	}*/
	
	if ( ((Double)v_currentLoad_kW).isNaN() ){
		traceln("v_currentLoad_kW is NaN! On GridNode %s, time %s h", this, timeVariables.getT_h());
		pauseSimulation();
	}
	
	if (p_energyCarrier == OL_EnergyCarriers.ELECTRICITY) {
		acc_annualElectricityBalance_kW.addStep( v_currentLoad_kW);
	}
	else if (p_energyCarrier == OL_EnergyCarriers.HEAT) {
		acc_annualHeatBalance_kW.addStep( v_currentLoad_kW);
	}	
	
	double currentImport_MWh = max(0, v_currentLoad_kW) * timeParameters.getTimeStep_h() / 1000;
	double currentExport_MWh = max(0, -v_currentLoad_kW) * timeParameters.getTimeStep_h() / 1000;
	double currentExcessImport_MWh = max(0, v_currentLoad_kW - p_capacity_kW) * timeParameters.getTimeStep_h() / 1000;
	double currentExcessExport_MWh = max(0, -v_currentLoad_kW - p_capacity_kW) * timeParameters.getTimeStep_h() / 1000;
	
	v_totalImport_MWh += currentImport_MWh;
	v_totalExport_MWh += currentExport_MWh;
	v_annualExcessImport_MWh += currentExcessImport_MWh;
	v_annualExcessExport_MWh += currentExcessExport_MWh;
	
	// Year
	if (timeVariables.getT_h() % 1 == 0) {
		data_totalLoad_kW.add(timeVariables.getT_h(), v_currentLoad_kW);
	}
	// SummerWeek
	if (timeVariables.isSummerWeek()) {
		v_summerWeekImport_MWh += currentImport_MWh;
		v_summerWeekExport_MWh += currentExport_MWh;
		v_summerWeekExcessImport_MWh += currentExcessImport_MWh;
		v_summerWeekExcessExport_MWh += currentExcessExport_MWh;
		
		data_summerWeekLoad_kW.add(timeVariables.getAnyLogicTime_h(), v_currentLoad_kW);
	}
	// Winterweek
	if (timeVariables.isWinterWeek()) {
		v_winterWeekImport_MWh += currentImport_MWh;
		v_winterWeekExport_MWh += currentExport_MWh;
		v_winterWeekExcessImport_MWh += currentExcessImport_MWh;
		v_winterWeekExcessExport_MWh += currentExcessExport_MWh;
		
		data_winterWeekLoad_kW.add(timeVariables.getAnyLogicTime_h(), v_currentLoad_kW);
	}
	// Daytime
	if (timeVariables.isDaytime()) {
		v_daytimeImport_MWh += currentImport_MWh;
		v_daytimeExport_MWh += currentExport_MWh;
		v_daytimeExcessImport_MWh += currentExcessImport_MWh;
		v_daytimeExcessExport_MWh += currentExcessExport_MWh;
	}
	// Weekdays
	if (timeVariables.isWeekday()) { // Simulation starts on a Thursday, hence the +3 day offset on t_h
		v_weekdayImport_MWh += currentImport_MWh;
		v_weekdayExport_MWh += currentExport_MWh;
		v_weekdayExcessImport_MWh += currentExcessImport_MWh;
		v_weekdayExcessExport_MWh += currentExcessExport_MWh;
	}
}
else {
	data_liveCapacitySupply_kW.add(timeVariables.getT_h(), -p_capacity_kW);
	data_liveCapacityDemand_kW.add(timeVariables.getT_h(), p_capacity_kW);
	data_liveLoad_kW.add(timeVariables.getT_h(), v_currentLoad_kW);
} 
  }

  void f_setCongestionTariff( double price_eurpkWh ) { 

for (GridConnection gc: c_connectedGridConnections){
	//traceln("Gc "+ gc.toString() + ", price "+ price_eurpkWh + ", allowance "+ allowance_kW +".");
	gc.p_owner.v_currentNodalPrice_eurpkWh = price_eurpkWh;
}
for (EnergyCoop e: c_energyCoops){
	e.v_currentNodalPrice_eurpkWh = price_eurpkWh;
} 
  }

  void f_calculateEnergyBalance( J_TimeVariables timeVariables, J_TimeParameters timeParameters, boolean isRapidRun ) { 

f_sumLoads();
// Low-pass filtered grid load
//double lowPassFraction = min(1,1*1.2*energyModel.p_timeStep_h); // smaller value results in more filtering

if (p_energyCarrier == OL_EnergyCarriers.ELECTRICITY) {
	v_currentLoadElectricityLowPassed_kW += v_lowPassFactor_fr * ( v_currentLoad_kW - v_currentLoadElectricityLowPassed_kW );
	v_filteredLoadCongestionPricing_kW += v_lowPassFactorCongestionPricing_fr * ( v_currentLoad_kW - v_filteredLoadCongestionPricing_kW);
	//v_currentLocalNodalPrice_eurpkWh = v_filteredLoadCongestionPricing_kW / p_capacity_kW * p_localNodalPricingFactor_eurpkWh;
	v_currentDLRCapacity_kW = energyModel.v_currentDLRfactor_fr * p_capacity_kW;
	v_currentLocalNodalPrice_eurpkWh = signum(v_filteredLoadCongestionPricing_kW) * max(0,abs(v_filteredLoadCongestionPricing_kW) - v_currentDLRCapacity_kW * p_localNodalPricingTreshold_fr) / ((1-p_localNodalPricingTreshold_fr) * v_currentDLRCapacity_kW) * p_localNodalPricingFactor_eurpkWh;
}

//v_currentLocalNodalPrice_eurpkWh = (abs(v_filteredLoadCongestionPricing_kW / currentNodeCapacity_kW) - p_localNodalPricingTreshold_fr) / (1-p_localNodalPricingTreshold_fr) * p_localNodalPricingFactor_eurpkWh;

if (isRapidRun) {
	if (p_energyCarrier == OL_EnergyCarriers.ELECTRICITY) {
		if (abs(v_currentLoadElectricityLowPassed_kW) > p_capacity_kW) {
			//traceln("Overloaded gridNode %s! %s kW", p_gridNodeID, abs(v_currentLoadElectricityLowPassed_kW));
			v_totalTimeOverloaded_h	+= timeParameters.getTimeStep_h();
		}
		if( abs( v_currentLoadElectricityLowPassed_kW ) > abs(v_peakLoadFilteredElectricity_kW) ) { // store maximum absolute load, but retain sign!
			v_peakLoadFilteredElectricity_kW = ( v_currentLoadElectricityLowPassed_kW );
			v_timeOfPeakLoadFiltered_h = timeVariables.getT_h();
		}
		if( v_currentLoadElectricityLowPassed_kW < v_peakNegLoadElectricity_kW ) { // store peak negative load and time
			v_peakNegLoadElectricity_kW = v_currentLoadElectricityLowPassed_kW ;
			v_timeOfPeakNegLoadFiltered_h = timeVariables.getT_h();
		}
		if( v_currentLoadElectricityLowPassed_kW > v_peakPosLoadElectricity_kW ) { // store peak positive load and time
			v_peakPosLoadElectricity_kW = v_currentLoadElectricityLowPassed_kW ;
			v_timeOfPeakPosLoadFiltered_h = timeVariables.getT_h();
		}
	}

	if( abs( v_currentLoad_kW ) > abs(v_peakLoadAbsolute_kW) ) { // store maximum absolute load, but retain sign!
		v_peakLoadAbsolute_kW = v_currentLoad_kW;
		//v_timeOfPeakLoad_h = energyModel.t_h;
	}
}
else {
	data_liveLoad_kW.update();
	data_liveCapacityDemand_kW.update();
	data_liveCapacitySupply_kW.update();
}
/*
if (p_energyType.equals(OL_EnergyCarriers.HEAT) & b_transportBufferValid ) { // Thermal load unbalance goes into transportBuffer
//	double v_powerFraction_fr = Double.isNaN( -v_currentLoadHeat_kW / p_transportBuffer.getHeatCapacity_kW() )? 0 : -v_currentLoadHeat_kW / p_transportBuffer.getHeatCapacity_kW();
	//traceln("GridNode Heat v_currentLoadHeat_kW: %s", v_currentLoadHeat_kW);
	double v_powerFraction_fr = -v_currentLoadHeat_kW / p_transportBuffer.getHeatCapacity_kW();
	
	//p_transportBuffer.operate(v_powerFraction_fr);
	//traceln("DistrictHeating network heatcapacity = "+ p_transportBuffer.getHeatCapacity_kW()+" kW, water temperature " + p_transportBuffer.getCurrentTemperature() + " deg C, buffer power fraction " + v_powerFraction_fr * 100 + " %, transportbuffer HeatCapacity_kW " + p_transportBuffer.getHeatCapacity_kW());
	p_transportBuffer.f_updateAllFlows(v_powerFraction_fr);
	//traceln("DistrictHeating Grid temperature: %s degC", p_transportBuffer.getCurrentTemperature());
	//traceln("DistrictHeating network water temperature " + p_transportBuffer.getCurrentTemperature() + " deg C, buffer power fraction " + v_powerFraction_fr * 100 + " %, transportbuffer HeatCapacity_kW " + p_transportBuffer.getHeatCapacity_kW());
} else if(abs(v_currentLoadHeat_kW)>0.001) {
	traceln("Non-zero heat-load on district heating network without valid transport buffer!");
}
*/
//traceln("GridNode " + p_gridNodeID + " update at time " + time(HOUR));
f_nodeMetering(timeVariables, timeParameters, isRapidRun);

f_getCurrentChargingInformation(timeParameters); 
  }

  void f_resetStates( J_TimeParameters timeParameters ) { 

// Current status
v_currentLoad_kW = 0;
v_currentLoadElectricityLowPassed_kW = 0;
v_currentDLRCapacity_kW = p_capacity_kW;
v_congested = false;
v_currentCongestionPrice_eurpkWh = 0;
v_filteredLoadCongestionPricing_kW = 0;

// Performance variables
v_peakLoadAbsolute_kW = 0;
//v_averageAbsoluteLoadElectricity_kW = 0;
//v_loadFactor_fr = 0;
v_timeOfPeakLoadFiltered_h = 0;
v_timeOfPeakNegLoadFiltered_h = 0;
v_timeOfPeakPosLoadFiltered_h = 0;
v_peakPosLoadElectricity_kW = 0;
v_peakNegLoadElectricity_kW = 0;
v_peakLoadFilteredElectricity_kW = 0;
v_timeOfPeakLoadFiltered_h = 0;
v_totalTimeOverloaded_h = 0;

v_totalImport_MWh = 0;
v_totalExport_MWh = 0;
v_annualExcessImport_MWh = 0;
v_annualExcessExport_MWh = 0;

v_summerWeekImport_MWh = 0;
v_summerWeekExport_MWh = 0;
v_summerWeekExcessImport_MWh = 0;
v_summerWeekExcessExport_MWh = 0;

v_winterWeekImport_MWh = 0;
v_winterWeekExport_MWh = 0;
v_winterWeekExcessImport_MWh = 0;
v_winterWeekExcessExport_MWh = 0;

v_daytimeImport_MWh = 0;
v_daytimeExport_MWh = 0;
v_daytimeExcessImport_MWh = 0;
v_daytimeExcessExport_MWh = 0;

v_nighttimeImport_MWh = 0;
v_nighttimeExport_MWh = 0;
v_nighttimeExcessImport_MWh = 0;
v_nighttimeExcessExport_MWh = 0;

v_weekdayImport_MWh = 0;
v_weekdayExport_MWh = 0;
v_weekdayExcessImport_MWh = 0;
v_weekdayExcessExport_MWh = 0;

v_weekendImport_MWh = 0;
v_weekendExport_MWh = 0;
v_weekendExcessImport_MWh = 0;
v_weekendExcessExport_MWh = 0;

// Reset Accumulators
acc_annualElectricityBalance_kW = new ZeroAccumulator(true, timeParameters.getTimeStep_h(), timeParameters.getRunEndTime_h() - timeParameters.getRunStartTime_h());
acc_annualHeatBalance_kW = new ZeroAccumulator(true, timeParameters.getTimeStep_h(), timeParameters.getRunEndTime_h() - timeParameters.getRunStartTime_h());
//acc_annualElectricityBalance_kW.reset(); 
  }

  void f_calculateKPIs(  ) { 

// Calcs nighttime
v_nighttimeImport_MWh = v_totalImport_MWh - v_daytimeExcessImport_MWh;
v_nighttimeExport_MWh = v_totalExport_MWh - v_daytimeExcessExport_MWh;
v_nighttimeExcessImport_MWh = v_annualExcessImport_MWh - v_daytimeExcessImport_MWh;
v_nighttimeExcessExport_MWh = v_annualExcessExport_MWh - v_daytimeExcessExport_MWh;

// Calcs weekend
v_weekendImport_MWh = v_totalImport_MWh - v_weekdayImport_MWh;
v_weekendExport_MWh = v_totalExport_MWh - v_weekdayExport_MWh;
v_weekendExcessImport_MWh = v_annualExcessImport_MWh - v_weekdayExcessImport_MWh;
v_weekendExcessExport_MWh = v_annualExcessExport_MWh - v_weekdayExcessExport_MWh; 
  }

  /**
   * Function that gets all the directly connected grid nodes
   */
  public 
ArrayList<GridNode> 
 f_getConnectedGridNodes(  ) { 

return this.c_connectedGridNodes; 
  }

  /**
   * Function that gets all the directly connected grid connections
   */
  public 
ArrayList<GridConnection> 
 f_getConnectedGridConnections(  ) { 

return this.c_connectedGridConnections; 
  }

  void f_propagateNodalPricing(  ) { 

v_currentTotalNodalPrice_eurpkWh = v_currentParentNodalPrice_eurpkWh + v_currentLocalNodalPrice_eurpkWh;
for (GridNode GN : c_connectedGridNodes ) {
	GN.v_currentParentNodalPrice_eurpkWh = v_currentTotalNodalPrice_eurpkWh;
} 
  }

  void f_initializeGridnode(  ) { 

v_totalInstalledWindPower_kW = 0;
v_totalInstalledPVPower_kW = 0;

for (GridConnection GC : c_connectedGridConnections) {
	if (GC.v_isActive) {
		v_totalInstalledWindPower_kW += GC.v_liveAssetsMetaData.totalInstalledWindPower_kW;
		v_totalInstalledPVPower_kW += GC.v_liveAssetsMetaData.totalInstalledPVPower_kW;
	}
}

for (GridNode GN : c_connectedGridNodes) {
	v_totalInstalledWindPower_kW += GN.v_totalInstalledWindPower_kW;
	v_totalInstalledPVPower_kW += GN.v_totalInstalledPVPower_kW;
}

/*
if ( p_energyType == OL_EnergyCarriers.HEAT ) {
	double capacityHeat_kW = 1000000;
	double lossFactor_WpK = 10000;
	double heatCapacity_JpK = 10000 * 3.6e6;	
	double InitialStateOfCharge_degC = 60;
	double soilTemperature_degC = energyModel.p_undergroundTemperature_degC;
	p_transportBuffer = new J_EAStorageHeat(null, OL_EAStorageTypes.HEATBUFFER, capacityHeat_kW, lossFactor_WpK, energyModel.p_timeStep_h, InitialStateOfCharge_degC, 10.0, 90.0, InitialStateOfCharge_degC, heatCapacity_JpK, "AIR" );
	p_transportBuffer.updateAmbientTemperature(soilTemperature_degC);
	b_transportBufferValid = true;
	energyModel.c_energyAssets.add(p_transportBuffer);
	energyModel.c_storageAssets.add(p_transportBuffer);
}*/ 
  }

  void f_updateForecasts(  ) { 

// The ElectricityYieldForecast assumes solar and wind forecasts have the same forecast time
if ( v_totalInstalledPVPower_kW + v_totalInstalledWindPower_kW > 0 ) {
	v_electricityYieldForecast_fr = (energyModel.pf_PVProduction35DegSouth_fr.getForecast() * v_totalInstalledPVPower_kW + energyModel.pf_windProduction_fr.getForecast() * v_totalInstalledWindPower_kW) / (v_totalInstalledPVPower_kW + v_totalInstalledWindPower_kW);
}
 
  }

  void f_updateTotalInstalledProductionAssets( OL_EnergyAssetType energyAssetType, double power_kw, boolean increase ) { 

if (energyAssetType == OL_EnergyAssetType.WINDMILL) {
	if (increase) {
		v_totalInstalledWindPower_kW += power_kw;
	}
	else {
		v_totalInstalledWindPower_kW -= power_kw;
	}
}
else if (energyAssetType == OL_EnergyAssetType.PHOTOVOLTAIC) {
	if (increase) {
		v_totalInstalledPVPower_kW += power_kw;
	}
	else {
		v_totalInstalledPVPower_kW -= power_kw;
	}
}
else {
	throw new IllegalStateException("Wrong energy asset type");
}

if (p_parentNodeID != null) {
	GridNode myParentNode = findFirst(energyModel.pop_gridNodes, p->p.p_gridNodeID.equals(p_parentNodeID));
	if (myParentNode != null) {
		myParentNode.f_updateTotalInstalledProductionAssets(energyAssetType, power_kw, increase);
	}
} 
  }

  /**
   * Function that gets all grid nodes and the children of those grid nodes, etc. All the way to the bottom node.
   */
  public 
List<GridNode> 
 f_getLowerLVLConnectedGridNodes(  ) { 

List<GridNode> allConnectedGridNodes = new ArrayList<GridNode>();

for(GridNode GN : c_connectedGridNodes){
	allConnectedGridNodes.addAll(GN.f_getAllConnectedGridNodes_recursion(new ArrayList<GridNode>()));
}

return allConnectedGridNodes; 
  }

  /**
   * Recursion Function that gets all grid nodes and the children of those grid nodes, etc. All the way to the bottom node. For basic use should be called with an empty list!
   */
  
List<GridNode> 
 f_getAllConnectedGridNodes_recursion( List<GridNode> allConnectedGridNodes ) { 

//Add to collection
allConnectedGridNodes.add(this);

//Recursive loop (repeat this function till bottom)
if(c_connectedGridNodes.size() == 0){
	return allConnectedGridNodes;
}
else{
	for(GridNode GN : c_connectedGridNodes){
		GN.f_getAllConnectedGridNodes_recursion(allConnectedGridNodes);
		//allConnectedGridNodes.addAll(GN.f_getAllConnectedGridNodes(allConnectedGridNodes));
	}
	return allConnectedGridNodes;
}
 
  }

  /**
   * Function that gets all the directly connected grid connections
   */
  public 
ArrayList<GridConnection> 
 f_getAllLowerLVLConnectedGridConnections(  ) { 

ArrayList<GridConnection> AllLowerLVLConnectedGridConnections = new ArrayList<GridConnection>();

for(GridNode GN : f_getLowerLVLConnectedGridNodes()){
	AllLowerLVLConnectedGridConnections.addAll(GN.f_getConnectedGridConnections());
}

AllLowerLVLConnectedGridConnections.addAll(this.c_connectedGridConnections);

return AllLowerLVLConnectedGridConnections; 
  }

  public 
J_LoadDurationCurves 
 f_getDuurkrommes( J_TimeParameters timeParameters ) { 

return new J_LoadDurationCurves(acc_annualElectricityBalance_kW.getTimeSeries_kW(), timeParameters); 
  }

  public 
DataSet 
 f_getPeakImportWeekDataSet( J_TimeParameters timeParameters ) { 

double[] elecBalance_kW = acc_annualElectricityBalance_kW.getTimeSeries_kW();

Integer maxIndex = 0; // index with peak import
for (int i = 1; i < elecBalance_kW.length; i++) {
    if (elecBalance_kW[i] > elecBalance_kW[maxIndex]) {
        maxIndex = i;
    }
}

double peakTime_h = maxIndex*timeParameters.getTimeStep_h();
double duration_h = acc_annualElectricityBalance_kW.getDuration();
double accStartTime_h = min(duration_h-7*24,max(0,peakTime_h - 3.5*24));
DataSet ds = acc_annualElectricityBalance_kW.getDataSet(timeParameters.getRunStartTime_h(), accStartTime_h, accStartTime_h+24*7);
   
return ds; 
  }

  public 
DataSet 
 f_getPeakExportWeekDataSet( J_TimeParameters timeParameters ) { 

double[] elecBalance_kW = acc_annualElectricityBalance_kW.getTimeSeries_kW();

Integer minIndex = 0; // index with peak import
for (int i = 1; i < elecBalance_kW.length; i++) {
    if (elecBalance_kW[i] < elecBalance_kW[minIndex]) {
        minIndex = i;
    }
}

double peakTime_h = minIndex*timeParameters.getTimeStep_h();
double duration_h = acc_annualElectricityBalance_kW.getDuration();
double accStartTime_h = min(duration_h-7*24,max(0,peakTime_h - 3.5*24));
DataSet ds = acc_annualElectricityBalance_kW.getDataSet(timeParameters.getRunStartTime_h(), accStartTime_h, accStartTime_h+24*7);
   
return ds; 
  }

  void f_getCurrentChargingInformation( J_TimeParameters timeParameters ) { 

v_currentChargingPowerBalancingThisGN_kW = 0;
v_currentNumberOfChargeRequestsBalancingThisGN = 0;

for(GridConnection GC : c_connectedGridConnections){
	if(GC.f_getChargingManagement() instanceof J_ChargingManagementGridBalancing){
		for(J_EAEV ev : GC.c_electricVehicles){
			v_currentChargingPowerBalancingThisGN_kW += ev.getLastFlows().get(OL_EnergyCarriers.ELECTRICITY);
		}
		for(J_EAChargingSession cs : GC.c_chargingSessions){
			v_currentChargingPowerBalancingThisGN_kW += cs.getLastFlows().get(OL_EnergyCarriers.ELECTRICITY);
		}
		v_currentNumberOfChargeRequestsBalancingThisGN += GC.f_getChargePoint().getCurrentNumberOfChargeRequests();
	}
}

// Low pass filter
double filterTimeScale_h = 5*24;
double filterDiffGain_r = 1/(filterTimeScale_h/timeParameters.getTimeStep_h());
v_lowPassedLoadFilter_kW += (v_currentLoad_kW - v_currentChargingPowerBalancingThisGN_kW - v_lowPassedLoadFilter_kW) * filterDiffGain_r;	
//v_lowPassedLoadFilter_kW += (v_currentLoad_kW - v_lowPassedLoadFilter_kW) * filterDiffGain_r;	
 
  }

  
int 
 f_getCurrentNumberOfChargeRequestsBalancingThisGN(  ) { 

return v_currentNumberOfChargeRequestsBalancingThisGN; 
  }

  
double 
 f_getCurrentChargingPowerBalancingThisGN_kW(  ) { 

return v_currentChargingPowerBalancingThisGN_kW; 
  }
  // Analysis Data Elements
private double _datasetUpdateTime_xjal() {
	return time();
}
  public DataSet data_liveLoad_kW = new DataSet( 672 );
  
  public DataSet data_liveCapacityDemand_kW = new DataSet( 672 );
  
  public DataSet data_liveCapacitySupply_kW = new DataSet( 672 );
  
  public DataSet data_totalLoad_kW = new DataSet( 8760, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), 0 );
      _lastUpdateX = time();
    }
    @Override
    public double getDataXValue() {
      return time();
    }
  } );
  
  public DataSet data_summerWeekLoad_kW = new DataSet( 672, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), 0 );
      _lastUpdateX = time();
    }
    @Override
    public double getDataXValue() {
      return time();
    }
  } );
  
  public DataSet data_winterWeekLoad_kW = new DataSet( 672, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), 0 );
      _lastUpdateX = time();
    }
    @Override
    public double getDataXValue() {
      return time();
    }
  } );
  
  // View areas
  public ViewArea va_gridNode = new ViewArea( this, null, 0, 0, 1920, 980 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1920.0, 980.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "va_gridNode", this.va_gridNode );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text7_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _line4 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _line7 = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _text7 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _line2 = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 8;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 9;

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
	  level.addAll(line, text, text4, line4, line7, text7, line2, text2);
  }

  protected ShapeLine line;
  protected ShapeText text;
  protected ShapeText text4;
  protected ShapeLine line4;
  protected ShapeLine line7;
  protected ShapeText text7;
  protected ShapeLine line2;
  protected ShapeText text2;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 10.0, 40.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 20.0, 0.0, 0.0,
        black,"Parameters",
        _text_Font, ALIGNMENT_LEFT );
    text4 = new ShapeText(
        SHAPE_DRAW_2D, true,820.0, 20.0, 0.0, 0.0,
        black,"Functions",
        _text4_Font, ALIGNMENT_LEFT );
    line4 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 770.0, 40.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line7 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 400.0, 470.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text7 = new ShapeText(
        SHAPE_DRAW_2D, true,450.0, 450.0, 0.0, 0.0,
        black,"Performance",
        _text7_Font, ALIGNMENT_LEFT );
    line2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 50.0, 520.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, 500.0, 0.0, 0.0,
        black,"Current status",
        _text2_Font, ALIGNMENT_LEFT );
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
  public GridNode( Engine engine, Agent owner, AgentList<? extends GridNode> ownerPopulation ) {
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
  public GridNode() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public GridNode( String p_gridNodeID, String p_parentNodeID, OL_GridNodeType p_nodeType, OL_EnergyCarriers p_energyCarrier, double p_capacity_kW, J_EAStorageHeat p_transportBuffer, GridOperator p_ownerGridOperator, String p_gridNodeOwnerID, boolean b_transportBufferValid, double p_longitude, double p_latitude, GISRegion gisRegion, String p_description, boolean p_realCapacityAvailable, GISRegion p_serviceAreaGisRegion, Color p_uniqueColor, double p_localNodalPricingFactor_eurpkWh, Color p_defaultLineColor, Color p_defaultFillColor, double p_localNodalPricingTreshold_fr, double p_originalCapacity_kW, OL_GridNodeProfileLoaderType p_profileType ) {
    markParametersAreSet();
    this.p_gridNodeID = p_gridNodeID;
    this.p_parentNodeID = p_parentNodeID;
    this.p_nodeType = p_nodeType;
    this.p_energyCarrier = p_energyCarrier;
    this.p_capacity_kW = p_capacity_kW;
    this.p_transportBuffer = p_transportBuffer;
    this.p_ownerGridOperator = p_ownerGridOperator;
    this.p_gridNodeOwnerID = p_gridNodeOwnerID;
    this.b_transportBufferValid = b_transportBufferValid;
    this.p_longitude = p_longitude;
    this.p_latitude = p_latitude;
    this.gisRegion = gisRegion;
    this.p_description = p_description;
    this.p_realCapacityAvailable = p_realCapacityAvailable;
    this.p_serviceAreaGisRegion = p_serviceAreaGisRegion;
    this.p_uniqueColor = p_uniqueColor;
    this.p_localNodalPricingFactor_eurpkWh = p_localNodalPricingFactor_eurpkWh;
    this.p_defaultLineColor = p_defaultLineColor;
    this.p_defaultFillColor = p_defaultFillColor;
    this.p_localNodalPricingTreshold_fr = p_localNodalPricingTreshold_fr;
    this.p_originalCapacity_kW = p_originalCapacity_kW;
    this.p_profileType = p_profileType;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_GridNode_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( GridNode.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon = new ShapeModelElementsGroup( GridNode.this, getElementProperty( "zero_engine.GridNode.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
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
    setupInitialConditions_xjal( GridNode.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_GridNode_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_GridNode_xjal() {
    v_congested = 
false 
;
    v_congestionMode = 
"No congestion atm" 
;
    v_peakLoadAbsolute_kW = 
0 
;
    v_currentLoadElectricityLowPassed_kW = 
0 
;
    v_lowPassFactor_fr = 
min(1, 0.8 * 0.25) // min(1, 0.8 * energyModel.p_timeStep_h), is there an initialisation function for GridNode? 
;
    v_peakLoadFilteredElectricity_kW = 
0 
;
    v_peakPosLoadElectricity_kW = 
0 
;
    v_peakNegLoadElectricity_kW = 
0 
;
    v_lowPassFactorCongestionPricing_fr = 
min(1, 0.25 * 0.25) // min(1, 0.25 * energyModel.p_timeStep_h), is there an initialisation function for GridNode? 
;
    v_totalTimeOverloaded_h = 
0 
;
    v_annualExcessImport_MWh = 
0 
;
    v_annualExcessExport_MWh = 
0 
;
    v_summerWeekExcessImport_MWh = 
0 
;
    v_summerWeekExcessExport_MWh = 
0 
;
    v_winterWeekExcessImport_MWh = 
0 
;
    v_winterWeekExcessExport_MWh = 
0 
;
    v_daytimeExcessImport_MWh = 
0 
;
    v_daytimeExcessExport_MWh = 
0 
;
    v_nighttimeExcessImport_MWh = 
0 
;
    v_nighttimeExcessExport_MWh = 
0 
;
    v_weekdayExcessImport_MWh = 
0 
;
    v_weekdayExcessExport_MWh = 
0 
;
    v_weekendExcessImport_MWh = 
0 
;
    v_weekendExcessExport_MWh = 
0 
;
    v_currentParentNodalPrice_eurpkWh = 
0.1 
;
    v_totalInstalledWindPower_kW = 
0 
;
    v_totalInstalledPVPower_kW = 
0 
;
    v_electricityYieldForecast_fr = 
0.0 
;
    v_currentDLRCapacity_kW = 
0 
;
    v_daytimeImport_MWh = 
0 
;
    v_daytimeExport_MWh = 
0 
;
    v_weekdayImport_MWh = 
0 
;
    v_weekdayExport_MWh = 
0 
;
    v_nighttimeImport_MWh = 
0 
;
    v_nighttimeExport_MWh = 
0 
;
    v_weekendImport_MWh = 
0 
;
    v_weekendExport_MWh = 
0 
;
    v_currentChargingPowerBalancingThisGN_kW = 
0 
;
    v_currentNumberOfChargeRequestsBalancingThisGN = 
0 
;
    v_lowPassedLoadFilter_kW = 
0 
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

  public AgentList<? extends GridNode> getPopulation() {
    return (AgentList<? extends GridNode>) super.getPopulation();
  }

  public List<? extends GridNode> agentsInRange( double distance ) {
    return (List<? extends GridNode>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
  // Analysis Data Elements
    data_liveLoad_kW.destroyUpdater_xjal();
    data_liveCapacityDemand_kW.destroyUpdater_xjal();
    data_liveCapacitySupply_kW.destroyUpdater_xjal();
    data_totalLoad_kW.destroyUpdater_xjal();
    data_summerWeekLoad_kW.destroyUpdater_xjal();
    data_winterWeekLoad_kW.destroyUpdater_xjal();
    logToDB( data_liveLoad_kW, "data_liveLoad_kW" );
    logToDB( data_liveCapacityDemand_kW, "data_liveCapacityDemand_kW" );
    logToDB( data_liveCapacitySupply_kW, "data_liveCapacitySupply_kW" );
    logToDB( data_totalLoad_kW, "data_totalLoad_kW" );
    logToDB( data_summerWeekLoad_kW, "data_summerWeekLoad_kW" );
    logToDB( data_winterWeekLoad_kW, "data_winterWeekLoad_kW" );
    super.onDestroy();
  }

  // Additional class code

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
