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

public class GCNeighborhood extends zero_engine.GridConnection
{
  // Parameters

  public 
int  p_nbCompaniesTotal;

  /**
   * Returns default value for parameter <code>p_nbCompaniesTotal</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _p_nbCompaniesTotal_DefaultValue_xjal() {
    final GCNeighborhood self = this;
    return 0;
  }

  public void set_p_nbCompaniesTotal( int value ) {
    if (value == this.p_nbCompaniesTotal) {
      return;
    }
    int _oldValue_xjal = this.p_nbCompaniesTotal;
    this.p_nbCompaniesTotal = value;
    onChange_p_nbCompaniesTotal_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_nbCompaniesTotal.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_nbCompaniesTotal()</code> method instead.
   */
  protected void onChange_p_nbCompaniesTotal() {
    onChange_p_nbCompaniesTotal_xjal( p_nbCompaniesTotal );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_nbCompaniesTotal_xjal( int oldValue ) {  
  }


  public 
int  p_nbHouseholds;

  /**
   * Returns default value for parameter <code>p_nbHouseholds</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _p_nbHouseholds_DefaultValue_xjal() {
    final GCNeighborhood self = this;
    return 0;
  }

  public void set_p_nbHouseholds( int value ) {
    if (value == this.p_nbHouseholds) {
      return;
    }
    int _oldValue_xjal = this.p_nbHouseholds;
    this.p_nbHouseholds = value;
    onChange_p_nbHouseholds_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_nbHouseholds.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_nbHouseholds()</code> method instead.
   */
  protected void onChange_p_nbHouseholds() {
    onChange_p_nbHouseholds_xjal( p_nbHouseholds );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_nbHouseholds_xjal( int oldValue ) {  
  }


  public 
String  p_municipalityCode;

  /**
   * Returns default value for parameter <code>p_municipalityCode</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_municipalityCode_DefaultValue_xjal() {
    final GCNeighborhood self = this;
    return null;
  }

  public void set_p_municipalityCode( String value ) {
    if (value == this.p_municipalityCode) {
      return;
    }
    String _oldValue_xjal = this.p_municipalityCode;
    this.p_municipalityCode = value;
    onChange_p_municipalityCode_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_municipalityCode.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_municipalityCode()</code> method instead.
   */
  protected void onChange_p_municipalityCode() {
    onChange_p_municipalityCode_xjal( p_municipalityCode );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_municipalityCode_xjal( String oldValue ) {  
  }


  public 
int  p_nbServices;

  /**
   * Returns default value for parameter <code>p_nbServices</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _p_nbServices_DefaultValue_xjal() {
    final GCNeighborhood self = this;
    return 0;
  }

  public void set_p_nbServices( int value ) {
    if (value == this.p_nbServices) {
      return;
    }
    int _oldValue_xjal = this.p_nbServices;
    this.p_nbServices = value;
    onChange_p_nbServices_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_nbServices.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_nbServices()</code> method instead.
   */
  protected void onChange_p_nbServices() {
    onChange_p_nbServices_xjal( p_nbServices );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_nbServices_xjal( int oldValue ) {  
  }


  public 
int  p_nbIndustry;

  /**
   * Returns default value for parameter <code>p_nbIndustry</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _p_nbIndustry_DefaultValue_xjal() {
    final GCNeighborhood self = this;
    return 0;
  }

  public void set_p_nbIndustry( int value ) {
    if (value == this.p_nbIndustry) {
      return;
    }
    int _oldValue_xjal = this.p_nbIndustry;
    this.p_nbIndustry = value;
    onChange_p_nbIndustry_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_nbIndustry.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_nbIndustry()</code> method instead.
   */
  protected void onChange_p_nbIndustry() {
    onChange_p_nbIndustry_xjal( p_nbIndustry );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_nbIndustry_xjal( int oldValue ) {  
  }


  public 
int  p_nbAgriculture;

  /**
   * Returns default value for parameter <code>p_nbAgriculture</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _p_nbAgriculture_DefaultValue_xjal() {
    final GCNeighborhood self = this;
    return 0;
  }

  public void set_p_nbAgriculture( int value ) {
    if (value == this.p_nbAgriculture) {
      return;
    }
    int _oldValue_xjal = this.p_nbAgriculture;
    this.p_nbAgriculture = value;
    onChange_p_nbAgriculture_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_nbAgriculture.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_nbAgriculture()</code> method instead.
   */
  protected void onChange_p_nbAgriculture() {
    onChange_p_nbAgriculture_xjal( p_nbAgriculture );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_nbAgriculture_xjal( int oldValue ) {  
  }


  public 
boolean  p_ignoreGridCapacityBattery;

  /**
   * Returns default value for parameter <code>p_ignoreGridCapacityBattery</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _p_ignoreGridCapacityBattery_DefaultValue_xjal() {
    final GCNeighborhood self = this;
    return 
false 
;
  }

  public void set_p_ignoreGridCapacityBattery( boolean value ) {
    if (value == this.p_ignoreGridCapacityBattery) {
      return;
    }
    boolean _oldValue_xjal = this.p_ignoreGridCapacityBattery;
    this.p_ignoreGridCapacityBattery = value;
    onChange_p_ignoreGridCapacityBattery_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_ignoreGridCapacityBattery.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_ignoreGridCapacityBattery()</code> method instead.
   */
  protected void onChange_p_ignoreGridCapacityBattery() {
    onChange_p_ignoreGridCapacityBattery_xjal( p_ignoreGridCapacityBattery );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_ignoreGridCapacityBattery_xjal( boolean oldValue ) {  
  }


  public 
J_EAConversionGasCHP  p_chpAsset;

  /**
   * Returns default value for parameter <code>p_chpAsset</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_EAConversionGasCHP _p_chpAsset_DefaultValue_xjal() {
    final GCNeighborhood self = this;
    return null;
  }

  public void set_p_chpAsset( J_EAConversionGasCHP value ) {
    if (value == this.p_chpAsset) {
      return;
    }
    J_EAConversionGasCHP _oldValue_xjal = this.p_chpAsset;
    this.p_chpAsset = value;
    onChange_p_chpAsset_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_chpAsset.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_chpAsset()</code> method instead.
   */
  protected void onChange_p_chpAsset() {
    onChange_p_chpAsset_xjal( p_chpAsset );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_chpAsset_xjal( J_EAConversionGasCHP oldValue ) {  
  }



















  /**
   * A Java class that contains all the relevant information about the grid connection address. The class contains a method .getAddress() which returns a formatted String of the address.
   */






  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_nbCompaniesTotal = _p_nbCompaniesTotal_DefaultValue_xjal();
    p_nbHouseholds = _p_nbHouseholds_DefaultValue_xjal();
    p_municipalityCode = _p_municipalityCode_DefaultValue_xjal();
    p_nbServices = _p_nbServices_DefaultValue_xjal();
    p_nbIndustry = _p_nbIndustry_DefaultValue_xjal();
    p_nbAgriculture = _p_nbAgriculture_DefaultValue_xjal();
    p_ignoreGridCapacityBattery = _p_ignoreGridCapacityBattery_DefaultValue_xjal();
    p_chpAsset = _p_chpAsset_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_nbCompaniesTotal":
      if ( _callOnChange_xjal ) {
        set_p_nbCompaniesTotal( ((Number) _value_xjal).intValue() );
      } else {
        p_nbCompaniesTotal = ((Number) _value_xjal).intValue();
      }
      return true;
    case "p_nbHouseholds":
      if ( _callOnChange_xjal ) {
        set_p_nbHouseholds( ((Number) _value_xjal).intValue() );
      } else {
        p_nbHouseholds = ((Number) _value_xjal).intValue();
      }
      return true;
    case "p_municipalityCode":
      if ( _callOnChange_xjal ) {
        set_p_municipalityCode( (String) _value_xjal );
      } else {
        p_municipalityCode = (String) _value_xjal;
      }
      return true;
    case "p_nbServices":
      if ( _callOnChange_xjal ) {
        set_p_nbServices( ((Number) _value_xjal).intValue() );
      } else {
        p_nbServices = ((Number) _value_xjal).intValue();
      }
      return true;
    case "p_nbIndustry":
      if ( _callOnChange_xjal ) {
        set_p_nbIndustry( ((Number) _value_xjal).intValue() );
      } else {
        p_nbIndustry = ((Number) _value_xjal).intValue();
      }
      return true;
    case "p_nbAgriculture":
      if ( _callOnChange_xjal ) {
        set_p_nbAgriculture( ((Number) _value_xjal).intValue() );
      } else {
        p_nbAgriculture = ((Number) _value_xjal).intValue();
      }
      return true;
    case "p_ignoreGridCapacityBattery":
      if ( _callOnChange_xjal ) {
        set_p_ignoreGridCapacityBattery( (Boolean) _value_xjal );
      } else {
        p_ignoreGridCapacityBattery = (Boolean) _value_xjal;
      }
      return true;
    case "p_chpAsset":
      if ( _callOnChange_xjal ) {
        set_p_chpAsset( (J_EAConversionGasCHP) _value_xjal );
      } else {
        p_chpAsset = (J_EAConversionGasCHP) _value_xjal;
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
    case "p_nbCompaniesTotal": _result_xjal = p_nbCompaniesTotal; break;
    case "p_nbHouseholds": _result_xjal = p_nbHouseholds; break;
    case "p_municipalityCode": _result_xjal = p_municipalityCode; break;
    case "p_nbServices": _result_xjal = p_nbServices; break;
    case "p_nbIndustry": _result_xjal = p_nbIndustry; break;
    case "p_nbAgriculture": _result_xjal = p_nbAgriculture; break;
    case "p_ignoreGridCapacityBattery": _result_xjal = p_ignoreGridCapacityBattery; break;
    case "p_chpAsset": _result_xjal = p_chpAsset; break;
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
      list.add( "p_nbCompaniesTotal" );
      list.add( "p_nbHouseholds" );
      list.add( "p_municipalityCode" );
      list.add( "p_nbServices" );
      list.add( "p_nbIndustry" );
      list.add( "p_nbAgriculture" );
      list.add( "p_ignoreGridCapacityBattery" );
      list.add( "p_chpAsset" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
double 
 v_currentLoadLowPassed_kW;
  public 
double 
 v_SOC_setp_fr_offset_balance;
  public 
double 
 v_FeedbackGain_kWpSOC_factor_balance;
  public 
double 
 v_SOC_setp_fr_price;
  public 
double 
 v_priceGain_kWhpeur;
  public 
double 
 v_batteryMoneyMade_euro;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( GCNeighborhood.class );

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
  protected static final int _STATECHART_COUNT_xjal = zero_engine.GridConnection._STATECHART_COUNT_xjal + 0;


  // Functions

  void f_resetSpecificGCStates_override(  ) { 

v_batteryMoneyMade_euro = 0;
v_currentLoadLowPassed_kW = 0; 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_batterySliderFunctionality_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_AdditionalGCNBHParameters_Font = _txt_batterySliderFunctionality_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_batteryBalance_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_batteryPrice_Font = _txt_batteryBalance_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_batterySliderFunctionality = zero_engine.GridConnection._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_batterySliderFunctionality = zero_engine.GridConnection._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle4 = zero_engine.GridConnection._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_AdditionalGCNBHParameters = zero_engine.GridConnection._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_batteryBalance = zero_engine.GridConnection._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_batteryPrice = zero_engine.GridConnection._SHAPE_NEXT_ID_xjal + 6;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = zero_engine.GridConnection._SHAPE_NEXT_ID_xjal + 7;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return super.isPublicPresentationDefined() || true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rect_batterySliderFunctionality, txt_batterySliderFunctionality, rectangle4, txt_AdditionalGCNBHParameters, txt_batteryBalance, txt_batteryPrice);
  }

  protected ShapeRectangle rect_batterySliderFunctionality;
  protected ShapeText txt_batterySliderFunctionality;
  protected ShapeRectangle rectangle4;
  protected ShapeText txt_AdditionalGCNBHParameters;
  protected ShapeText txt_batteryBalance;
  protected ShapeText txt_batteryPrice;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rect_batterySliderFunctionality = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1940.0, 60.0, 0.0, 0.0,
            lime, white,
			960.0, 170.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_batterySliderFunctionality = new ShapeText(
        SHAPE_DRAW_2D, true,1960.0, 60.0, 0.0, 0.0,
        black,"Battery control",
        _txt_batterySliderFunctionality_Font, ALIGNMENT_LEFT );
    rectangle4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1330.0, 720.0, 0.0, 0.0,
            black, white,
			430.0, 230.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_AdditionalGCNBHParameters = new ShapeText(
        SHAPE_DRAW_2D, true,1350.0, 740.0, 0.0, 0.0,
        black,"Extra specifieke Parameters",
        _txt_AdditionalGCNBHParameters_Font, ALIGNMENT_LEFT );
    txt_batteryBalance = new ShapeText(
        SHAPE_DRAW_2D, true,1960.0, 90.0, 0.0, 0.0,
        black,"Balance",
        _txt_batteryBalance_Font, ALIGNMENT_LEFT );
    txt_batteryPrice = new ShapeText(
        SHAPE_DRAW_2D, true,2400.0, 90.0, 0.0, 0.0,
        black,"Prijs",
        _txt_batteryPrice_Font, ALIGNMENT_LEFT );
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
	_getLevels_xjal = concatenateArrays( super.getLevels(), 
      level );
    _createPersistentElementsBP0_xjal();
  }

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
  public GCNeighborhood( Engine engine, Agent owner, AgentList<? extends GCNeighborhood> ownerPopulation ) {
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
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public GCNeighborhood() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public GCNeighborhood( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco, int p_nbCompaniesTotal, int p_nbHouseholds, String p_municipalityCode, int p_nbServices, int p_nbIndustry, int p_nbAgriculture, boolean p_ignoreGridCapacityBattery, J_EAConversionGasCHP p_chpAsset ) {
    super( p_parentNodeElectricID, p_gridConnectionID, p_parentNodeHeatID, p_BuildingThermalAsset, p_ownerID, p_batteryAsset, p_heatBuffer, p_gasBuffer, p_cookingTracker, p_insulationLabel, p_DHWAsset, p_longitude, p_latitude, p_floorSurfaceArea_m2, p_owner, p_roofSurfaceArea_m2, p_purposeBAG, p_address, p_parentNodeHeat, p_parentNodeElectric, v_isActive, p_energyLabel, p_airco );
    this.p_nbCompaniesTotal = p_nbCompaniesTotal;
    this.p_nbHouseholds = p_nbHouseholds;
    this.p_municipalityCode = p_municipalityCode;
    this.p_nbServices = p_nbServices;
    this.p_nbIndustry = p_nbIndustry;
    this.p_nbAgriculture = p_nbAgriculture;
    this.p_ignoreGridCapacityBattery = p_ignoreGridCapacityBattery;
    this.p_chpAsset = p_chpAsset;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_GCNeighborhood_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "zero_engine.GCNeighborhood.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( GCNeighborhood.class );
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
    super.setupPlainVariables_xjal();
    setupPlainVariables_GCNeighborhood_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_GCNeighborhood_xjal() {
    v_SOC_setp_fr_offset_balance = 
0.6 
;
    v_FeedbackGain_kWpSOC_factor_balance = 
0.4 
;
    v_SOC_setp_fr_price = 
0.5 
;
    v_priceGain_kWhpeur = 
2 
;
    v_batteryMoneyMade_euro = 
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

  public AgentList<? extends GCNeighborhood> getPopulation() {
    return (AgentList<? extends GCNeighborhood>) super.getPopulation();
  }

  public List<? extends GCNeighborhood> agentsInRange( double distance ) {
    return (List<? extends GCNeighborhood>) super.agentsInRange( distance );
  }

  // Additional class code

@Override
public void f_resetSpecificGCStates(){
	f_resetSpecificGCStates_override();
} 
  // End of additional class code

}
