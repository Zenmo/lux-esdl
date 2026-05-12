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

import java.lang.reflect.Field;


//@JsonIgnoreProperties({"va_building", "va_parcel", "_origin_VA","gisRegion",
//	"p_defaultFillColor", "p_defaultLineColor", "p_defaultLineStyle"}) 

/**
 * Generic Object for GISRegions. Is used for GridConnections of type: GCEnergyProduction, GCEnergyConversion, GCGridBattery, GCPublicCharger.
 */
public class GIS_Object extends Agent
{
  // Parameters

  public 
GISRegion  gisRegion;

  /**
   * Returns default value for parameter <code>gisRegion</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public GISRegion _gisRegion_DefaultValue_xjal() {
    final GIS_Object self = this;
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
double  p_longitude;

  /**
   * Returns default value for parameter <code>p_longitude</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_longitude_DefaultValue_xjal() {
    final GIS_Object self = this;
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
    final GIS_Object self = this;
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
OL_GISObjectType  p_GISObjectType;

  /**
   * Returns default value for parameter <code>p_GISObjectType</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_GISObjectType _p_GISObjectType_DefaultValue_xjal() {
    final GIS_Object self = this;
    return null;
  }

  public void set_p_GISObjectType( OL_GISObjectType value ) {
    if (value == this.p_GISObjectType) {
      return;
    }
    OL_GISObjectType _oldValue_xjal = this.p_GISObjectType;
    this.p_GISObjectType = value;
    onChange_p_GISObjectType_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_GISObjectType.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_GISObjectType()</code> method instead.
   */
  protected void onChange_p_GISObjectType() {
    onChange_p_GISObjectType_xjal( p_GISObjectType );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_GISObjectType_xjal( OL_GISObjectType oldValue ) {  
  }


  public 
String  p_id;

  /**
   * Returns default value for parameter <code>p_id</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_id_DefaultValue_xjal() {
    final GIS_Object self = this;
    return null;
  }

  public void set_p_id( String value ) {
    if (value == this.p_id) {
      return;
    }
    String _oldValue_xjal = this.p_id;
    this.p_id = value;
    onChange_p_id_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_id.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_id()</code> method instead.
   */
  protected void onChange_p_id() {
    onChange_p_id_xjal( p_id );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_id_xjal( String oldValue ) {  
  }


  public 
Color  p_defaultLineColor;

  /**
   * Returns default value for parameter <code>p_defaultLineColor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Color _p_defaultLineColor_DefaultValue_xjal() {
    final GIS_Object self = this;
    return null;
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
    final GIS_Object self = this;
    return null;
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
double  p_defaultLineWidth;

  /**
   * Returns default value for parameter <code>p_defaultLineWidth</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_defaultLineWidth_DefaultValue_xjal() {
    final GIS_Object self = this;
    return 
1 
;
  }

  public void set_p_defaultLineWidth( double value ) {
    if (value == this.p_defaultLineWidth) {
      return;
    }
    double _oldValue_xjal = this.p_defaultLineWidth;
    this.p_defaultLineWidth = value;
    onChange_p_defaultLineWidth_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultLineWidth.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultLineWidth()</code> method instead.
   */
  protected void onChange_p_defaultLineWidth() {
    onChange_p_defaultLineWidth_xjal( p_defaultLineWidth );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultLineWidth_xjal( double oldValue ) {  
  }


  public 
LineStyle  p_defaultLineStyle;

  /**
   * Returns default value for parameter <code>p_defaultLineStyle</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public LineStyle _p_defaultLineStyle_DefaultValue_xjal() {
    final GIS_Object self = this;
    return 
LineStyle.LINE_STYLE_SOLID 
;
  }

  public void set_p_defaultLineStyle( LineStyle value ) {
    if (value == this.p_defaultLineStyle) {
      return;
    }
    LineStyle _oldValue_xjal = this.p_defaultLineStyle;
    this.p_defaultLineStyle = value;
    onChange_p_defaultLineStyle_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultLineStyle.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultLineStyle()</code> method instead.
   */
  protected void onChange_p_defaultLineStyle() {
    onChange_p_defaultLineStyle_xjal( p_defaultLineStyle );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultLineStyle_xjal( LineStyle oldValue ) {  
  }


  public 
String  p_annotation;

  /**
   * Returns default value for parameter <code>p_annotation</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_annotation_DefaultValue_xjal() {
    final GIS_Object self = this;
    return null;
  }

  public void set_p_annotation( String value ) {
    if (value == this.p_annotation) {
      return;
    }
    String _oldValue_xjal = this.p_annotation;
    this.p_annotation = value;
    onChange_p_annotation_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_annotation.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_annotation()</code> method instead.
   */
  protected void onChange_p_annotation() {
    onChange_p_annotation_xjal( p_annotation );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_annotation_xjal( String oldValue ) {  
  }


  public 
String  p_defaultFillColorString;

  /**
   * Returns default value for parameter <code>p_defaultFillColorString</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_defaultFillColorString_DefaultValue_xjal() {
    final GIS_Object self = this;
    return null;
  }

  public void set_p_defaultFillColorString( String value ) {
    if (value == this.p_defaultFillColorString) {
      return;
    }
    String _oldValue_xjal = this.p_defaultFillColorString;
    this.p_defaultFillColorString = value;
    onChange_p_defaultFillColorString_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultFillColorString.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultFillColorString()</code> method instead.
   */
  protected void onChange_p_defaultFillColorString() {
    onChange_p_defaultFillColorString_xjal( p_defaultFillColorString );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultFillColorString_xjal( String oldValue ) {  
  }


  public 
String  p_defaultLineColorString;

  /**
   * Returns default value for parameter <code>p_defaultLineColorString</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_defaultLineColorString_DefaultValue_xjal() {
    final GIS_Object self = this;
    return null;
  }

  public void set_p_defaultLineColorString( String value ) {
    if (value == this.p_defaultLineColorString) {
      return;
    }
    String _oldValue_xjal = this.p_defaultLineColorString;
    this.p_defaultLineColorString = value;
    onChange_p_defaultLineColorString_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultLineColorString.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultLineColorString()</code> method instead.
   */
  protected void onChange_p_defaultLineColorString() {
    onChange_p_defaultLineColorString_xjal( p_defaultLineColorString );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultLineColorString_xjal( String oldValue ) {  
  }


  public 
String  p_defaultLineStyleString;

  /**
   * Returns default value for parameter <code>p_defaultLineStyleString</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_defaultLineStyleString_DefaultValue_xjal() {
    final GIS_Object self = this;
    return null;
  }

  public void set_p_defaultLineStyleString( String value ) {
    if (value == this.p_defaultLineStyleString) {
      return;
    }
    String _oldValue_xjal = this.p_defaultLineStyleString;
    this.p_defaultLineStyleString = value;
    onChange_p_defaultLineStyleString_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultLineStyleString.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultLineStyleString()</code> method instead.
   */
  protected void onChange_p_defaultLineStyleString() {
    onChange_p_defaultLineStyleString_xjal( p_defaultLineStyleString );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultLineStyleString_xjal( String oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    gisRegion = _gisRegion_DefaultValue_xjal();
    p_longitude = _p_longitude_DefaultValue_xjal();
    p_latitude = _p_latitude_DefaultValue_xjal();
    p_GISObjectType = _p_GISObjectType_DefaultValue_xjal();
    p_id = _p_id_DefaultValue_xjal();
    p_defaultLineColor = _p_defaultLineColor_DefaultValue_xjal();
    p_defaultFillColor = _p_defaultFillColor_DefaultValue_xjal();
    p_defaultLineWidth = _p_defaultLineWidth_DefaultValue_xjal();
    p_defaultLineStyle = _p_defaultLineStyle_DefaultValue_xjal();
    p_annotation = _p_annotation_DefaultValue_xjal();
    p_defaultFillColorString = _p_defaultFillColorString_DefaultValue_xjal();
    p_defaultLineColorString = _p_defaultLineColorString_DefaultValue_xjal();
    p_defaultLineStyleString = _p_defaultLineStyleString_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "gisRegion":
      if ( _callOnChange_xjal ) {
        set_gisRegion( (GISRegion) _value_xjal );
      } else {
        gisRegion = (GISRegion) _value_xjal;
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
    case "p_GISObjectType":
      if ( _callOnChange_xjal ) {
        set_p_GISObjectType( (OL_GISObjectType) _value_xjal );
      } else {
        p_GISObjectType = (OL_GISObjectType) _value_xjal;
      }
      return true;
    case "p_id":
      if ( _callOnChange_xjal ) {
        set_p_id( (String) _value_xjal );
      } else {
        p_id = (String) _value_xjal;
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
    case "p_defaultLineWidth":
      if ( _callOnChange_xjal ) {
        set_p_defaultLineWidth( ((Number) _value_xjal).doubleValue() );
      } else {
        p_defaultLineWidth = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_defaultLineStyle":
      if ( _callOnChange_xjal ) {
        set_p_defaultLineStyle( (LineStyle) _value_xjal );
      } else {
        p_defaultLineStyle = (LineStyle) _value_xjal;
      }
      return true;
    case "p_annotation":
      if ( _callOnChange_xjal ) {
        set_p_annotation( (String) _value_xjal );
      } else {
        p_annotation = (String) _value_xjal;
      }
      return true;
    case "p_defaultFillColorString":
      if ( _callOnChange_xjal ) {
        set_p_defaultFillColorString( (String) _value_xjal );
      } else {
        p_defaultFillColorString = (String) _value_xjal;
      }
      return true;
    case "p_defaultLineColorString":
      if ( _callOnChange_xjal ) {
        set_p_defaultLineColorString( (String) _value_xjal );
      } else {
        p_defaultLineColorString = (String) _value_xjal;
      }
      return true;
    case "p_defaultLineStyleString":
      if ( _callOnChange_xjal ) {
        set_p_defaultLineStyleString( (String) _value_xjal );
      } else {
        p_defaultLineStyleString = (String) _value_xjal;
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
    case "gisRegion": _result_xjal = gisRegion; break;
    case "p_longitude": _result_xjal = p_longitude; break;
    case "p_latitude": _result_xjal = p_latitude; break;
    case "p_GISObjectType": _result_xjal = p_GISObjectType; break;
    case "p_id": _result_xjal = p_id; break;
    case "p_defaultLineColor": _result_xjal = p_defaultLineColor; break;
    case "p_defaultFillColor": _result_xjal = p_defaultFillColor; break;
    case "p_defaultLineWidth": _result_xjal = p_defaultLineWidth; break;
    case "p_defaultLineStyle": _result_xjal = p_defaultLineStyle; break;
    case "p_annotation": _result_xjal = p_annotation; break;
    case "p_defaultFillColorString": _result_xjal = p_defaultFillColorString; break;
    case "p_defaultLineColorString": _result_xjal = p_defaultLineColorString; break;
    case "p_defaultLineStyleString": _result_xjal = p_defaultLineStyleString; break;
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
      list.add( "gisRegion" );
      list.add( "p_longitude" );
      list.add( "p_latitude" );
      list.add( "p_GISObjectType" );
      list.add( "p_id" );
      list.add( "p_defaultLineColor" );
      list.add( "p_defaultFillColor" );
      list.add( "p_defaultLineWidth" );
      list.add( "p_defaultLineStyle" );
      list.add( "p_annotation" );
      list.add( "p_defaultFillColorString" );
      list.add( "p_defaultLineColorString" );
      list.add( "p_defaultLineStyleString" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }

  // Collection Variables
  public 
ArrayList <
GridConnection > c_containedGridConnections = new ArrayList<GridConnection>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( GIS_Object.class );

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

  public void f_style( Color fillColor, Color lineColor, Double width, LineStyle lineStyle ) { 

if (fillColor == null) {
	fillColor = p_defaultFillColor;
}
gisRegion.setFillColor( fillColor );
if (lineColor == null) {
	lineColor = p_defaultLineColor;
}
gisRegion.setLineColor( lineColor );
if (width == null) {
	width = p_defaultLineWidth;
}
gisRegion.setLineWidth( width );
if (lineStyle == null) {
	lineStyle = p_defaultLineStyle;
}
gisRegion.setLineStyle( lineStyle ); 
  }

  public void f_writeStyleStrings(  ) { 

if (p_defaultFillColor!=null){
	p_defaultFillColorString = p_defaultFillColor.getRed() + "," + p_defaultFillColor.getGreen() + "," + p_defaultFillColor.getBlue();
}
if (p_defaultLineColor!=null){
	p_defaultLineColorString = p_defaultLineColor.getRed() + "," + p_defaultLineColor.getGreen() + "," + p_defaultLineColor.getBlue();
}
if (p_defaultLineStyle!=null){
	p_defaultLineStyleString = p_defaultLineStyle.toString();
} 
  }

  public void f_resetStyle(  ) { 

String[] rgb;
if (p_defaultFillColorString!=null){
	rgb = p_defaultFillColorString.split(",");
	
	if (rgb.length == 3) {
	    p_defaultFillColor = new Color(
	        Integer.parseInt(rgb[0]),
	        Integer.parseInt(rgb[1]),
	        Integer.parseInt(rgb[2])
	    );
	} 
}

if (p_defaultLineColorString!=null){
	rgb = p_defaultLineColorString.split(",");
	if (rgb.length == 3) {
	    p_defaultLineColor = new Color(
	        Integer.parseInt(rgb[0]),
	        Integer.parseInt(rgb[1]),
	        Integer.parseInt(rgb[2])
	    );
	} 
} 
if (p_defaultLineStyleString!=null){
	p_defaultLineStyle = LineStyle.valueOf(LineStyle.class, p_defaultLineStyleString);
} 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1920.0, 980.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_serializationFunctions_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_serializationFunctions = 1;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 2;

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
	  level.addAll(txt_serializationFunctions);
  }

  protected ShapeText txt_serializationFunctions;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    txt_serializationFunctions = new ShapeText(
        SHAPE_DRAW_2D, true,810.0, 10.0, 0.0, 0.0,
        black,"Functions needed for Serialization",
        _txt_serializationFunctions_Font, ALIGNMENT_LEFT );
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
  public GIS_Object( Engine engine, Agent owner, AgentList<? extends GIS_Object> ownerPopulation ) {
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
  public GIS_Object() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public GIS_Object( GISRegion gisRegion, double p_longitude, double p_latitude, OL_GISObjectType p_GISObjectType, String p_id, Color p_defaultLineColor, Color p_defaultFillColor, double p_defaultLineWidth, LineStyle p_defaultLineStyle, String p_annotation, String p_defaultFillColorString, String p_defaultLineColorString, String p_defaultLineStyleString ) {
    markParametersAreSet();
    this.gisRegion = gisRegion;
    this.p_longitude = p_longitude;
    this.p_latitude = p_latitude;
    this.p_GISObjectType = p_GISObjectType;
    this.p_id = p_id;
    this.p_defaultLineColor = p_defaultLineColor;
    this.p_defaultFillColor = p_defaultFillColor;
    this.p_defaultLineWidth = p_defaultLineWidth;
    this.p_defaultLineStyle = p_defaultLineStyle;
    this.p_annotation = p_annotation;
    this.p_defaultFillColorString = p_defaultFillColorString;
    this.p_defaultLineColorString = p_defaultLineColorString;
    this.p_defaultLineStyleString = p_defaultLineStyleString;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_GIS_Object_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( GIS_Object.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon = new ShapeModelElementsGroup( GIS_Object.this, getElementProperty( "zero_engine.GIS_Object.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
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
    setupInitialConditions_xjal( GIS_Object.class );
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
    setupPlainVariables_GIS_Object_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_GIS_Object_xjal() {
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

  public AgentList<? extends GIS_Object> getPopulation() {
    return (AgentList<? extends GIS_Object>) super.getPopulation();
  }

  public List<? extends GIS_Object> agentsInRange( double distance ) {
    return (List<? extends GIS_Object>) super.agentsInRange( distance );
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
