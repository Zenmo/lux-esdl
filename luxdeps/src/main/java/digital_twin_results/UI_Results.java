package digital_twin_results;

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

import static digital_twin_results.OL_ChartTypes.*;
import static digital_twin_results.OL_ChartPeriod.*;
import static digital_twin_results.OL_RadioButtonSetup.*;

import java.awt.geom.Arc2D;

import java.util.EnumSet;
import java.util.EnumMap; 

public class UI_Results extends Agent
{
  // Parameters

  public 
EnergyModel  energyModel;

  /**
   * Returns default value for parameter <code>energyModel</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public EnergyModel _energyModel_DefaultValue_xjal() {
    final UI_Results self = this;
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
  }


  public 
double  p_cutOff_MWh;

  /**
   * Returns default value for parameter <code>p_cutOff_MWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_cutOff_MWh_DefaultValue_xjal() {
    final UI_Results self = this;
    return 
0.001 
;
  }

  public void set_p_cutOff_MWh( double value ) {
    if (value == this.p_cutOff_MWh) {
      return;
    }
    double _oldValue_xjal = this.p_cutOff_MWh;
    this.p_cutOff_MWh = value;
    onChange_p_cutOff_MWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_cutOff_MWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_cutOff_MWh()</code> method instead.
   */
  protected void onChange_p_cutOff_MWh() {
    onChange_p_cutOff_MWh_xjal( p_cutOff_MWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_cutOff_MWh_xjal( double oldValue ) {  
  }


  public 
ShapeGroup  gr_infoText;

  /**
   * Returns default value for parameter <code>gr_infoText</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ShapeGroup _gr_infoText_DefaultValue_xjal() {
    final UI_Results self = this;
    return null;
  }

  public void set_gr_infoText( ShapeGroup value ) {
    if (value == this.gr_infoText) {
      return;
    }
    ShapeGroup _oldValue_xjal = this.gr_infoText;
    this.gr_infoText = value;
    onChange_gr_infoText_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter gr_infoText.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_gr_infoText()</code> method instead.
   */
  protected void onChange_gr_infoText() {
    onChange_gr_infoText_xjal( gr_infoText );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_gr_infoText_xjal( ShapeGroup oldValue ) {  
  }


  public 
ShapeGroup  gr_closeInfoText;

  /**
   * Returns default value for parameter <code>gr_closeInfoText</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ShapeGroup _gr_closeInfoText_DefaultValue_xjal() {
    final UI_Results self = this;
    return null;
  }

  public void set_gr_closeInfoText( ShapeGroup value ) {
    if (value == this.gr_closeInfoText) {
      return;
    }
    ShapeGroup _oldValue_xjal = this.gr_closeInfoText;
    this.gr_closeInfoText = value;
    onChange_gr_closeInfoText_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter gr_closeInfoText.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_gr_closeInfoText()</code> method instead.
   */
  protected void onChange_gr_closeInfoText() {
    onChange_gr_closeInfoText_xjal( gr_closeInfoText );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_gr_closeInfoText_xjal( ShapeGroup oldValue ) {  
  }


  public 
ShapeText  t_infoTextDescription;

  /**
   * Returns default value for parameter <code>t_infoTextDescription</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ShapeText _t_infoTextDescription_DefaultValue_xjal() {
    final UI_Results self = this;
    return null;
  }

  public void set_t_infoTextDescription( ShapeText value ) {
    if (value == this.t_infoTextDescription) {
      return;
    }
    ShapeText _oldValue_xjal = this.t_infoTextDescription;
    this.t_infoTextDescription = value;
    onChange_t_infoTextDescription_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter t_infoTextDescription.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_t_infoTextDescription()</code> method instead.
   */
  protected void onChange_t_infoTextDescription() {
    onChange_t_infoTextDescription_xjal( t_infoTextDescription );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_t_infoTextDescription_xjal( ShapeText oldValue ) {  
  }


  public 
ShapeRoundedRectangle  rect_infoText;

  /**
   * Returns default value for parameter <code>rect_infoText</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ShapeRoundedRectangle _rect_infoText_DefaultValue_xjal() {
    final UI_Results self = this;
    return null;
  }

  public void set_rect_infoText( ShapeRoundedRectangle value ) {
    if (value == this.rect_infoText) {
      return;
    }
    ShapeRoundedRectangle _oldValue_xjal = this.rect_infoText;
    this.rect_infoText = value;
    onChange_rect_infoText_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter rect_infoText.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_rect_infoText()</code> method instead.
   */
  protected void onChange_rect_infoText() {
    onChange_rect_infoText_xjal( rect_infoText );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_rect_infoText_xjal( ShapeRoundedRectangle oldValue ) {  
  }


  public 
List<ShapeImage>  p_currentActiveInfoBubble;

  /**
   * Returns default value for parameter <code>p_currentActiveInfoBubble</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public List<ShapeImage> _p_currentActiveInfoBubble_DefaultValue_xjal() {
    final UI_Results self = this;
    return null;
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
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    energyModel = _energyModel_DefaultValue_xjal();
    p_cutOff_MWh = _p_cutOff_MWh_DefaultValue_xjal();
    gr_infoText = _gr_infoText_DefaultValue_xjal();
    gr_closeInfoText = _gr_closeInfoText_DefaultValue_xjal();
    t_infoTextDescription = _t_infoTextDescription_DefaultValue_xjal();
    rect_infoText = _rect_infoText_DefaultValue_xjal();
    p_currentActiveInfoBubble = _p_currentActiveInfoBubble_DefaultValue_xjal();
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
    case "p_cutOff_MWh":
      if ( _callOnChange_xjal ) {
        set_p_cutOff_MWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_cutOff_MWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "gr_infoText":
      if ( _callOnChange_xjal ) {
        set_gr_infoText( (ShapeGroup) _value_xjal );
      } else {
        gr_infoText = (ShapeGroup) _value_xjal;
      }
      return true;
    case "gr_closeInfoText":
      if ( _callOnChange_xjal ) {
        set_gr_closeInfoText( (ShapeGroup) _value_xjal );
      } else {
        gr_closeInfoText = (ShapeGroup) _value_xjal;
      }
      return true;
    case "t_infoTextDescription":
      if ( _callOnChange_xjal ) {
        set_t_infoTextDescription( (ShapeText) _value_xjal );
      } else {
        t_infoTextDescription = (ShapeText) _value_xjal;
      }
      return true;
    case "rect_infoText":
      if ( _callOnChange_xjal ) {
        set_rect_infoText( (ShapeRoundedRectangle) _value_xjal );
      } else {
        rect_infoText = (ShapeRoundedRectangle) _value_xjal;
      }
      return true;
    case "p_currentActiveInfoBubble":
      if ( _callOnChange_xjal ) {
        set_p_currentActiveInfoBubble( (List<ShapeImage>) _value_xjal );
      } else {
        p_currentActiveInfoBubble = (List<ShapeImage>) _value_xjal;
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
    case "p_cutOff_MWh": _result_xjal = p_cutOff_MWh; break;
    case "gr_infoText": _result_xjal = gr_infoText; break;
    case "gr_closeInfoText": _result_xjal = gr_closeInfoText; break;
    case "t_infoTextDescription": _result_xjal = t_infoTextDescription; break;
    case "rect_infoText": _result_xjal = rect_infoText; break;
    case "p_currentActiveInfoBubble": _result_xjal = p_currentActiveInfoBubble; break;
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
      list.add( "p_cutOff_MWh" );
      list.add( "gr_infoText" );
      list.add( "gr_closeInfoText" );
      list.add( "t_infoTextDescription" );
      list.add( "rect_infoText" );
      list.add( "p_currentActiveInfoBubble" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  protected 
GridNode 
 v_gridNode;
  public 
J_ColorMap<OL_EnergyCarriers> 
 cm_productionColors;
  public 
J_ColorMap<OL_EnergyCarriers> 
 cm_consumptionColors;
  public 
boolean 
 b_isCompanyUIResultsUI;
  public 
J_ColorMap<OL_AssetFlowCategories> 
 cm_assetFlowColors;
  public 
EnumMap<OL_AssetFlowCategories, String> 
 lm_assetFlowLabels;
  public 
EnumSet<OL_AssetFlowCategories> 
 v_consumptionAssetFlows;
  public 
EnumSet<OL_AssetFlowCategories> 
 v_electricAssetFlows;
  public 
ShapeRadioButtonGroup 
 rb_chartType_Energy;
  public 
ShapeRadioButtonGroup 
 rb_chartType_Economic;
  public 
ShapeRadioButtonGroup 
 rb_resultsUIMode;
  public 
Color 
 v_naturalGasDemandColor;
  public 
Color 
 v_ElektrischeWPColor;
  public 
Color 
 v_HybrideWPColor;
  public 
Color 
 v_MTDistrictHeatingColor;
  public 
Color 
 v_LTDistrictHeatingColor;
  public 
Color 
 v_GreenGasBoilerColor;
  public 
Color 
 v_uitgeslotenColor;
  public 
Color 
 v_energieLabelAColor;
  public 
Color 
 v_energieLabelBColor;
  public 
Color 
 v_energieLabelCColor;
  public 
Color 
 v_energieLabelDColor;
  public 
Color 
 v_energieLabelEColor;
  public 
Color 
 v_energieLabelFColor;
  public 
Color 
 v_energieLabelOnbekendColor;
  public 
Color 
 v_energieLabelGColor;
  public 
Color 
 v_districtHeatDemandColor;
  public 
Color 
 v_highlightParticipantsColor;
  public 
Color 
 v_electricityBaseloadDemandColor;
  public 
Color 
 v_electricityForTransportDemandColor;
  public 
Color 
 v_electricityForHydrogenDemandColor;
  public 
Color 
 v_electricityForHeatDemandColor;
  public 
Color 
 v_electricityForStorageDemandColor;
  public 
Color 
 v_PVElectricitySupplyColor;
  public 
Color 
 v_windElectricitySupplyColor;
  public 
Color 
 v_storageElectricitySupplyColor;
  public 
Color 
 v_V2GElectricitySupplyColor;
  public 
Color 
 v_petroleumProductsDemandColor;
  public 
Color 
 v_naturalGasSupplyColor;
  public 
Color 
 v_petroleumProductsSupplyColor;
  public 
Color 
 v_districtHeatHeatSupplyColor;
  public 
Color 
 v_energyDemandColor;
  public 
Color 
 v_heatPumpHeatSupplyColor;
  public 
Color 
 v_electricityDemandColor;
  public 
Color 
 v_hydrogenDemandColor;
  public 
Color 
 v_electricitySupplyColor;
  /**
   * used to be: salmon
   */
  public 
Color 
 v_electricityCapacityColor_known;
  protected 
OL_ResultScope 
 v_selectedObjectScope;
  public 
OL_ChartTypes 
 v_selectedChartType;
  public 
Color 
 v_selfConsumedElectricityColor;
  public 
Color 
 v_importedEnergyColor;
  public 
Color 
 v_exportedEnergyColor;
  public 
Color 
 v_selfConsumedEnergyColor;
  public 
Color 
 v_hydrogenSupplyColor;
  public 
Color 
 v_electricityForCookingDemandColor;
  public 
boolean 
 b_showKPISummary;
  public 
Color 
 v_electricityCapacityColor_estimated;
  public 
Color 
 v_CHPElectricitySupplyColor;
  public 
boolean 
 b_showGroupContractValues;
  public 
Color 
 v_cumulativeGTVColor;
  public 
Color 
 v_groupGTVColor;
  public 
I_EnergyData 
 v_selectedObjectInterface;
  /**
   * (Temporary) boolean used to turn on the checkbox that can show the groupcontract calculation charts
   */
  public 
boolean 
 b_enableGroupContractMode;
  public 
double 
 v_resultsUIPresentationXOffset;
  public 
double 
 v_resultsUIPresentationYOffset;
  public 
J_InfoTextResultsUI 
 v_infoText;
  public 
double 
 v_interfaceViewAreaWidth;
  public 
double 
 v_interfaceViewAreaHeight;
  public 
double 
 v_interfaceViewAreaXOffset;
  public 
double 
 v_interfaceViewAreaYOffset;
  public 
Color 
 v_ptProductionColor;
  public 
Color 
 v_methaneElectricitySupplyColor;
  public 
Color 
 v_petroleumProductsElectricitySupplyColor;
  public 
Color 
 v_ironPowderDemandColor;
  public 
Color 
 v_ironPowderSupplyColor;

  // Collection Variables
  public 
ArrayList <
OL_ChartTypes > c_loadedChartTypes_Energy = new ArrayList<OL_ChartTypes>();
  public 
ArrayList <
OL_ChartTypes > c_loadedChartTypes_Economic = new ArrayList<OL_ChartTypes>();
  public 
ArrayList <
OL_EnergyCarriers > c_defaultOrderEC = new ArrayList<OL_EnergyCarriers>();
  public 
ArrayList <
OL_AssetFlowCategories > c_defaultOrderAC = new ArrayList<OL_AssetFlowCategories>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( UI_Results.class );

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
  private static final AgentAnimationSettings _chartProfielen_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartBatteries_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartNetbelasting_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartBalans_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartBars_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartSankey_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartKPISummary_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartGTO_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartEnergyCosts_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartGespreksLeidraad_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartGespreksleidraadBedrijven_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartGelijktijdigheid_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartCAPEXAndOPEX_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartTotalCosts_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartConnectionCosts_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _chartCO2_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  public ChartProfielen chartProfielen;
  public ChartBatteries chartBatteries;
  public ChartNetbelasting chartNetbelasting;
  public ChartBalans chartBalans;
  public ChartBars chartBars;
  public ChartSankey chartSankey;
  public ChartKPISummary chartKPISummary;
  public ChartGTO chartGTO;
  public ChartEnergyCosts chartEnergyCosts;
  public ChartGespreksLeidraad chartGespreksLeidraad;
  public ChartGespreksleidraadBedrijven chartGespreksleidraadBedrijven;
  public ChartGelijktijdigheid chartGelijktijdigheid;
  public ChartCAPEXAndOPEX chartCAPEXAndOPEX;
  public ChartTotalCosts chartTotalCosts;
  public ChartConnectionCosts chartConnectionCosts;
  public ChartCO2 chartCO2;

  public String getNameOf( Agent ao ) {
    if ( ao == chartProfielen ) return "chartProfielen";
    if ( ao == chartBatteries ) return "chartBatteries";
    if ( ao == chartNetbelasting ) return "chartNetbelasting";
    if ( ao == chartBalans ) return "chartBalans";
    if ( ao == chartBars ) return "chartBars";
    if ( ao == chartSankey ) return "chartSankey";
    if ( ao == chartKPISummary ) return "chartKPISummary";
    if ( ao == chartGTO ) return "chartGTO";
    if ( ao == chartEnergyCosts ) return "chartEnergyCosts";
    if ( ao == chartGespreksLeidraad ) return "chartGespreksLeidraad";
    if ( ao == chartGespreksleidraadBedrijven ) return "chartGespreksleidraadBedrijven";
    if ( ao == chartGelijktijdigheid ) return "chartGelijktijdigheid";
    if ( ao == chartCAPEXAndOPEX ) return "chartCAPEXAndOPEX";
    if ( ao == chartTotalCosts ) return "chartTotalCosts";
    if ( ao == chartConnectionCosts ) return "chartConnectionCosts";
    if ( ao == chartCO2 ) return "chartCO2";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    if ( ao == chartProfielen ) return _chartProfielen_animationSettings_xjal;
    if ( ao == chartBatteries ) return _chartBatteries_animationSettings_xjal;
    if ( ao == chartNetbelasting ) return _chartNetbelasting_animationSettings_xjal;
    if ( ao == chartBalans ) return _chartBalans_animationSettings_xjal;
    if ( ao == chartBars ) return _chartBars_animationSettings_xjal;
    if ( ao == chartSankey ) return _chartSankey_animationSettings_xjal;
    if ( ao == chartKPISummary ) return _chartKPISummary_animationSettings_xjal;
    if ( ao == chartGTO ) return _chartGTO_animationSettings_xjal;
    if ( ao == chartEnergyCosts ) return _chartEnergyCosts_animationSettings_xjal;
    if ( ao == chartGespreksLeidraad ) return _chartGespreksLeidraad_animationSettings_xjal;
    if ( ao == chartGespreksleidraadBedrijven ) return _chartGespreksleidraadBedrijven_animationSettings_xjal;
    if ( ao == chartGelijktijdigheid ) return _chartGelijktijdigheid_animationSettings_xjal;
    if ( ao == chartCAPEXAndOPEX ) return _chartCAPEXAndOPEX_animationSettings_xjal;
    if ( ao == chartTotalCosts ) return _chartTotalCosts_animationSettings_xjal;
    if ( ao == chartConnectionCosts ) return _chartConnectionCosts_animationSettings_xjal;
    if ( ao == chartCO2 ) return _chartCO2_animationSettings_xjal;
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
  protected ChartProfielen instantiate_chartProfielen_xjal() {
    ChartProfielen _result_xjal = new ChartProfielen( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartProfielen_xjal( final ChartProfielen self, TableInput _t ) {
    self.p_selectedExportUnit = self._p_selectedExportUnit_DefaultValue_xjal();
    self.map_ACToCheckBox = self._map_ACToCheckBox_DefaultValue_xjal();
    self.map_ECToCheckBox = self._map_ECToCheckBox_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartProfielen_xjal( ChartProfielen self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 0.0
;
double _y_xjal = 0.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected ChartBatteries instantiate_chartBatteries_xjal() {
    ChartBatteries _result_xjal = new ChartBatteries( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartBatteries_xjal( final ChartBatteries self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartBatteries_xjal( ChartBatteries self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = -490.0
;
double _y_xjal = -370.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected ChartNetbelasting instantiate_chartNetbelasting_xjal() {
    ChartNetbelasting _result_xjal = new ChartNetbelasting( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartNetbelasting_xjal( final ChartNetbelasting self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartNetbelasting_xjal( ChartNetbelasting self, TableInput _t ) {
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
  protected ChartBalans instantiate_chartBalans_xjal() {
    ChartBalans _result_xjal = new ChartBalans( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartBalans_xjal( final ChartBalans self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartBalans_xjal( ChartBalans self, TableInput _t ) {
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
  protected ChartBars instantiate_chartBars_xjal() {
    ChartBars _result_xjal = new ChartBars( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartBars_xjal( final ChartBars self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartBars_xjal( ChartBars self, TableInput _t ) {
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
  protected ChartSankey instantiate_chartSankey_xjal() {
    ChartSankey _result_xjal = new ChartSankey( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartSankey_xjal( final ChartSankey self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartSankey_xjal( ChartSankey self, TableInput _t ) {
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
  protected ChartKPISummary instantiate_chartKPISummary_xjal() {
    ChartKPISummary _result_xjal = new ChartKPISummary( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartKPISummary_xjal( final ChartKPISummary self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartKPISummary_xjal( ChartKPISummary self, TableInput _t ) {
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
  protected ChartGTO instantiate_chartGTO_xjal() {
    ChartGTO _result_xjal = new ChartGTO( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartGTO_xjal( final ChartGTO self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartGTO_xjal( ChartGTO self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = -800.0
;
double _y_xjal = -380.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected ChartEnergyCosts instantiate_chartEnergyCosts_xjal() {
    ChartEnergyCosts _result_xjal = new ChartEnergyCosts( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartEnergyCosts_xjal( final ChartEnergyCosts self, TableInput _t ) {
    self.p_totalName = self._p_totalName_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartEnergyCosts_xjal( ChartEnergyCosts self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = -230.0
;
double _y_xjal = -380.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected ChartGespreksLeidraad instantiate_chartGespreksLeidraad_xjal() {
    ChartGespreksLeidraad _result_xjal = new ChartGespreksLeidraad( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartGespreksLeidraad_xjal( final ChartGespreksLeidraad self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartGespreksLeidraad_xjal( ChartGespreksLeidraad self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = -1800.0
;
double _y_xjal = -940.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected ChartGespreksleidraadBedrijven instantiate_chartGespreksleidraadBedrijven_xjal() {
    ChartGespreksleidraadBedrijven _result_xjal = new ChartGespreksleidraadBedrijven( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartGespreksleidraadBedrijven_xjal( final ChartGespreksleidraadBedrijven self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartGespreksleidraadBedrijven_xjal( ChartGespreksleidraadBedrijven self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 0.0
;
double _y_xjal = 0.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected ChartGelijktijdigheid instantiate_chartGelijktijdigheid_xjal() {
    ChartGelijktijdigheid _result_xjal = new ChartGelijktijdigheid( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartGelijktijdigheid_xjal( final ChartGelijktijdigheid self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartGelijktijdigheid_xjal( ChartGelijktijdigheid self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 0.0
;
double _y_xjal = 0.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected ChartCAPEXAndOPEX instantiate_chartCAPEXAndOPEX_xjal() {
    ChartCAPEXAndOPEX _result_xjal = new ChartCAPEXAndOPEX( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartCAPEXAndOPEX_xjal( final ChartCAPEXAndOPEX self, TableInput _t ) {
    self.p_totalName = self._p_totalName_DefaultValue_xjal();
    self.map_assetToCheckBox = self._map_assetToCheckBox_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartCAPEXAndOPEX_xjal( ChartCAPEXAndOPEX self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = -230.0
;
double _y_xjal = -380.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected ChartTotalCosts instantiate_chartTotalCosts_xjal() {
    ChartTotalCosts _result_xjal = new ChartTotalCosts( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartTotalCosts_xjal( final ChartTotalCosts self, TableInput _t ) {
    self.map_catagoryToColor = self._map_catagoryToColor_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartTotalCosts_xjal( ChartTotalCosts self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = -230.0
;
double _y_xjal = -380.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected ChartConnectionCosts instantiate_chartConnectionCosts_xjal() {
    ChartConnectionCosts _result_xjal = new ChartConnectionCosts( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartConnectionCosts_xjal( final ChartConnectionCosts self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartConnectionCosts_xjal( ChartConnectionCosts self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = -230.0
;
double _y_xjal = -380.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected ChartCO2 instantiate_chartCO2_xjal() {
    ChartCO2 _result_xjal = new ChartCO2( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_chartCO2_xjal( final ChartCO2 self, TableInput _t ) {
    self.map_customCO2Additions_kg = self._map_customCO2Additions_kg_DefaultValue_xjal();
    self.p_totalName = self._p_totalName_DefaultValue_xjal();
    self.map_customCO2Additions_previous_kg = self._map_customCO2Additions_previous_kg_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_chartCO2_xjal( ChartCO2 self, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = -230.0
;
double _y_xjal = -380.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
  }

  // Functions

  public void f_showCorrectChart(  ) { 

gr_chartProfielen_presentation.setVisible(false);
gr_chartBalans_presentation.setVisible(false);
gr_chartNetbelasting_presentation.setVisible(false);
gr_chartSankey_presentation.setVisible(false);
gr_chartSummary_presentation.setVisible(false);
gr_chartGespreksLeidraad_presentation.setVisible(false);
gr_chartKPISummary_presentation.setVisible(false);
gr_chartBatteries_presentation.setVisible(false);
gr_chartGTO_presentation.setVisible(false);
gr_chartBars_presentation.setVisible(false);
gr_chartCO2_presentation.setVisible(false);
gr_chartEnergyCosts_presentation.setVisible(false);
gr_chartConnectionCosts_presentation.setVisible(false);
gr_chartCAPEXAndOPEX_presentation.setVisible(false);
gr_chartTotalCosts_presentation.setVisible(false);
gr_chartBlocker.setVisible(false);

switch (v_selectedChartType) {
	case PROFILES:
		gr_chartProfielen_presentation.setVisible(true);
		chartProfielen.f_setCharts();
		break;
	case BAR_TOTALS:
		//gr_chartBalans_presentation.setVisible(true);
		gr_chartBars_presentation.setVisible(true);
		chartBars.f_setCharts();
		break;
	case LOAD_DURATION_CURVES:
		gr_chartNetbelasting_presentation.setVisible(true);
		chartNetbelasting.f_setCharts();
		break;
	case SANKEY:
		gr_chartSankey_presentation.setVisible(true);
		chartSankey.f_setSankey();
		break;
	case GESPREKSLEIDRAAD_BEDRIJVEN:
		gr_chartSummary_presentation.setVisible(true);
		chartGespreksleidraadBedrijven.f_setGespreksleidraadBedrijvenCharts();
		break;
	case GESPREKSLEIDRAAD:
		gr_chartGespreksLeidraad_presentation.setVisible(true);
		chartGespreksLeidraad.f_selectGespreksleidraadCharts();
		break;
	case BATTERY:
		gr_chartBatteries_presentation.setVisible(true);
		chartBatteries.f_setChartsBatteries();
		break;
	case GTO:
		gr_chartGTO_presentation.setVisible(true);
		chartGTO.f_setChartGTO();
		break;
	case CO2:
		gr_chartCO2_presentation.setVisible(true);
		chartCO2.f_setChartCO2();
		break;
	case ENERGY_COSTS:
		gr_chartEnergyCosts_presentation.setVisible(true);
		chartEnergyCosts.f_setChartEnergyCosts();
		break;
	case CONNECTION_COSTS:
		gr_chartConnectionCosts_presentation.setVisible(true);
		chartConnectionCosts.f_setChartConnectionCosts();
		break;
	case CAPEX_AND_OPEX:
		gr_chartCAPEXAndOPEX_presentation.setVisible(true);
		chartCAPEXAndOPEX.f_setChartCAPEXAndOPEX();
		break;
	case TOTAL_COSTS:
		gr_chartTotalCosts_presentation.setVisible(true);
		chartTotalCosts.f_setChartTotalCosts();
		break;
}

if(b_showKPISummary){
	gr_chartKPISummary_presentation.setVisible(true);
	chartKPISummary.f_setKPISummaryChart();
} 
  }

  public void f_setResultsUIHeader( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the radiobuttons

//Set x axis
if(location_x != null){
	gr_resultsUIHeader.setX(location_x);
}

//Set y axis
if(location_x != null){
	gr_resultsUIHeader.setY(location_y);
}

//Set visibility
gr_resultsUIHeader.setVisible(visible); 
  }

  public void f_setChartSankey_Presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the sankey charts presentation

//Set x axis
if(location_x != null){
	gr_chartSankey_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartSankey_presentation.setY(location_y);
}

//Set visibility
gr_chartSankey_presentation.setVisible(visible); 
  }

  public void f_setChartGridLoad_Presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the gridload charts presentation

//Set x axis
if(location_x != null){
	gr_chartNetbelasting_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartNetbelasting_presentation.setY(location_y);
}

//Set visibility
gr_chartNetbelasting_presentation.setVisible(visible); 
  }

  public void f_setChartBalance_Presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the balance charts presentation

//Set x axis
if(location_x != null){
	gr_chartBalans_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartBalans_presentation.setY(location_y);
}

//Set visibility
gr_chartBalans_presentation.setVisible(visible); 
  }

  public void f_setChartProfiles_Presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the profiles charts presentation

//Set x axis
if(location_x != null){
	gr_chartProfielen_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartProfielen_presentation.setY(location_y);
}

//Set visibility
gr_chartProfielen_presentation.setVisible(visible); 
  }

  public void f_setAllCharts(  ) { 

//Function to set all charts, without changing visibilities
chartProfielen.f_setCharts();
chartBalans.f_setCharts();
chartNetbelasting.f_setCharts();
chartSankey.f_setSankey();
chartGespreksleidraadBedrijven.f_setGespreksleidraadBedrijvenCharts();

if(b_showKPISummary){
	chartKPISummary.f_setKPISummaryChart();
} 
  }

  public void f_styleAllCharts( Color backgroundColor, Color lineColor, Double lineWidth, LineStyle lineStyle ) { 

//Function to style all chart (backgrounds)
chartProfielen.f_styleBackground(backgroundColor, lineColor, lineWidth, lineStyle);
chartBalans.f_styleBackground(backgroundColor, lineColor, lineWidth, lineStyle);
chartNetbelasting.f_styleBackground(backgroundColor, lineColor, lineWidth, lineStyle);
chartSankey.f_styleBackground(backgroundColor, lineColor, lineWidth, lineStyle);
chartKPISummary.f_styleBackground(backgroundColor, lineColor, lineWidth, lineStyle);
chartGespreksLeidraad.f_styleBackground(backgroundColor, lineColor, lineWidth, lineStyle);
chartGespreksleidraadBedrijven.f_styleBackground(backgroundColor, lineColor, lineWidth, lineStyle);
chartBatteries.f_styleBackground(backgroundColor, lineColor, lineWidth, lineStyle);
chartEnergyCosts.f_styleBackground(backgroundColor, lineColor, lineWidth, lineStyle);
chartGTO.f_styleBackground(backgroundColor, lineColor, lineWidth, lineStyle); 
  }

  public void f_styleResultsUIHeader( Color backgroundColor, Color lineColor, double lineWidth, LineStyle lineStyle ) { 

//Function to style all chart (backgrounds)
rect_resultsMenuLarge.setFillColor(backgroundColor);
rect_resultsMenuLarge.setLineColor(lineColor);
rect_resultsMenuLarge.setLineWidth(lineWidth);
rect_resultsMenuLarge.setLineStyle(lineStyle);
 
  }

  public void f_setChartSummary_Presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the GSLD Summary charts presentation

//Set x axis
if(location_x != null){
	gr_chartSummary_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartSummary_presentation.setY(location_y);
}

//Set visibility
gr_chartSummary_presentation.setVisible(visible); 
  }

  public void f_setChartKPISummary_Presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the KPI summary charts presentation

//Set x axis
if(location_x != null){
	gr_chartKPISummary_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartKPISummary_presentation.setY(location_y);
}

//Set visibility
gr_chartKPISummary_presentation.setVisible(visible); 
  }

  public 
I_EnergyData 
 f_getSelectedObjectData(  ) { 

return v_selectedObjectInterface; 
  }

  public void f_setAllChart_Presentations( Integer location_x, Integer location_y, boolean visible ) { 

//Function used to set all charts at the same place
f_setChartProfiles_Presentation(location_x, location_y, visible);
f_setChartBalance_Presentation(location_x, location_y, visible);
f_setChartBars_Presentation(location_x, location_y, visible);
f_setChartGridLoad_Presentation(location_x, location_y, visible);
f_setChartSankey_Presentation(location_x, location_y, visible);
f_setChartSummary_Presentation(location_x, location_y, visible);
f_setChartGSLD_Presentation(location_x, location_y, visible);
f_setChartKPISummary_Presentation(location_x, location_y, visible);
f_setChartBatteries_presentation(location_x, location_y, visible);
f_setChartCO2_presentation(location_x, location_y, visible);
f_setChartEnergyCosts_presentation(location_x, location_y, visible);
f_setChartConnectionCosts_presentation(location_x, location_y, visible);
f_setChartCAPEXAndOPEX_presentation(location_x, location_y, visible);
f_setChartTotalCosts_presentation(location_x, location_y, visible); 
  }

  public void f_setChartGSLD_Presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the GSLD charts presentation

//Set x axis
if(location_x != null){
	gr_chartGespreksLeidraad_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartGespreksLeidraad_presentation.setY(location_y);
}

//Set visibility
gr_chartGespreksLeidraad_presentation.setVisible(visible); 
  }

  
String 
 f_getECName( OL_EnergyCarriers energyCarrier ) { 

switch (energyCarrier) {
	case ELECTRICITY:
		return "Elektriciteit";
	case HEAT:
		return "Warmte";
	case METHANE:
		return "Gas";
	case PETROLEUM_FUEL:
		return "Diesel & Benzine";
	case HYDROGEN:
		return "Waterstof";
	case IRON_POWDER:
		return "IJzerpoeder";
	default:
		throw new RuntimeException("Onbekende energiedrager, kan niet vertaald worden.");
}



// The code below return the name in English
/*
String s = energyCarrier.toString();
return s.substring(0, 1) + s.substring(1).toLowerCase();
*/ 
  }

  public void f_setChartGelijktijdigheid_Presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the balance charts presentation

//Set x axis
if(location_x != null){
	gr_chartGelijktijdigheid_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartGelijktijdigheid_presentation.setY(location_y);
}

//Set visibility
gr_chartGelijktijdigheid_presentation.setVisible(visible); 
  }

  public void f_setChartBatteries_presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the Batteries charts presentation

//Set x axis
if(location_x != null){
	gr_chartBatteries_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartBatteries_presentation.setY(location_y);
}

//Set visibility
gr_chartBatteries_presentation.setVisible(visible); 
  }

  public void f_setChartsBatteries(  ) { 

chartBatteries.f_setChartsBatteries(); 
  }

  public void f_initializeResultsUI( List<OL_ChartTypes> selectedChartTypes_Energy, List<OL_ChartTypes> selectedChartTypes_Economic ) { 

f_updateResultsUI(energyModel);

//Set the selected radiobutton setup
f_initializeResultsUIMainRB(selectedChartTypes_Energy, selectedChartTypes_Economic);

//Initialize profiles graph (starting chart)
chartProfielen.f_setCharts();
 
  }

  public void f_updateUIresultsGridNode( GridNode GN ) { 

v_selectedObjectScope = OL_ResultScope.GRIDNODE;
v_gridNode = GN;
f_setSelectedObjectText(null);
f_showCorrectChart();

/*
// Can't use pointer for (immutable) primitives in Java, so need to manually update results after a year-sim!!
area.v_gridCapacityDelivery_kW = GN.p_capacity_kW;
area.v_gridCapacityFeedIn_kW = GN.p_capacity_kW;
area.b_isRealDeliveryCapacityAvailable = GN.p_realCapacityAvailable;
area.b_isRealFeedinCapacityAvailable = GN.p_realCapacityAvailable;


// Datasets for profile plot
area.v_dataElectricityBaseloadConsumptionLiveWeek_kW = GN.data_liveLoad_kW;
area.v_dataElectricityBaseloadConsumptionYear_kW = GN.data_totalLoad_kW;
area.v_dataElectricityBaseloadConsumptionSummerWeek_kW = GN.data_summerWeekLoad_kW;
area.v_dataElectricityBaseloadConsumptionWinterWeek_kW = GN.data_winterWeekLoad_kW;


area.v_dataElectricityDeliveryCapacityLiveWeek_kW = GN.data_liveCapacityDemand_kW;
area.v_dataElectricityFeedInCapacityLiveWeek_kW = GN.data_liveCapacitySupply_kW;

// Data for Opwek & Verbruik
// Year
area.fm_totalImports_MWh.put(GN.p_energyCarrier, GN.v_totalImport_MWh);
area.fm_totalExports_MWh.put(GN.p_energyCarrier, GN.v_totalExport_MWh);
area.v_annualExcessImport_MWh = GN.v_annualExcessImport_MWh;
area.v_annualExcessExport_MWh = GN.v_annualExcessExport_MWh;

// Summer / Winter
area.fm_summerWeekImports_MWh.put(GN.p_energyCarrier, GN.v_summerWeekImport_MWh);
area.fm_summerWeekExports_MWh.put(GN.p_energyCarrier, GN.v_summerWeekExport_MWh);
area.v_summerWeekExcessImport_MWh = GN.v_summerWeekExcessImport_MWh;
area.v_summerWeekExcessExport_MWh = GN.v_summerWeekExcessExport_MWh;

area.fm_winterWeekImports_MWh.put(GN.p_energyCarrier, GN.v_winterWeekImport_MWh);
area.fm_winterWeekExports_MWh.put(GN.p_energyCarrier, GN.v_winterWeekExport_MWh);
area.v_winterWeekExcessImport_MWh = GN.v_winterWeekExcessImport_MWh;
area.v_winterWeekExcessExport_MWh = GN.v_winterWeekExcessExport_MWh;

// Day / Night
area.fm_daytimeImports_MWh.put(GN.p_energyCarrier, GN.v_daytimeImport_MWh);
area.fm_daytimeExports_MWh.put(GN.p_energyCarrier, GN.v_daytimeExport_MWh);
area.v_daytimeExcessImport_MWh = GN.v_daytimeExcessImport_MWh;
area.v_daytimeExcessExport_MWh = GN.v_daytimeExcessExport_MWh;

area.fm_nighttimeImports_MWh.put(GN.p_energyCarrier, GN.v_nighttimeImport_MWh);
area.fm_nighttimeExports_MWh.put(GN.p_energyCarrier, GN.v_nighttimeExport_MWh);
area.v_nighttimeExcessImport_MWh = GN.v_nighttimeExcessImport_MWh;
area.v_nighttimeExcessExport_MWh = GN.v_nighttimeExcessExport_MWh;

// Weekday / Weekend
area.fm_weekdayImports_MWh.put(GN.p_energyCarrier, GN.v_weekdayImport_MWh);
area.fm_weekdayExports_MWh.put(GN.p_energyCarrier, GN.v_weekdayExport_MWh);
area.v_weekdayExcessImport_MWh = GN.v_weekdayExcessImport_MWh;
area.v_weekdayExcessExport_MWh = GN.v_weekdayExcessExport_MWh;

area.fm_weekendImports_MWh.put(GN.p_energyCarrier, GN.v_weekendImport_MWh);
area.fm_weekendExports_MWh.put(GN.p_energyCarrier, GN.v_weekendExport_MWh);
area.v_weekendExcessImport_MWh = GN.v_weekendExcessImport_MWh;
area.v_weekendExcessExport_MWh = GN.v_weekendExcessExport_MWh;

// Year
area.v_dataNetbelastingDuurkrommeYear_kW = GN.f_getDuurkromme();;
area.v_dataNetbelastingDuurkrommeYearVorige_kW = GN.data_netbelastingDuurkrommeVorige_kW;

// Summer / Winter
area.v_dataNetbelastingDuurkrommeSummer_kW = GN.data_summerWeekNetbelastingDuurkromme_kW;
area.v_dataNetbelastingDuurkrommeWinter_kW = GN.data_winterWeekNetbelastingDuurkromme_kW;
// Day / Night
area.v_dataNetbelastingDuurkrommeDaytime_kW = GN.data_daytimeNetbelastingDuurkromme_kW;
area.v_dataNetbelastingDuurkrommeNighttime_kW = GN.data_nighttimeNetbelastingDuurkromme_kW;

// Weekday / Weekend
area.v_dataNetbelastingDuurkrommeWeekday_kW = GN.data_weekdayNetbelastingDuurkromme_kW;
area.v_dataNetbelastingDuurkrommeWeekend_kW = GN.data_weekendNetbelastingDuurkromme_kW;
*/

 
  }

  public void f_enableNonLivePlotRadioButtons( boolean active ) { 

if(rb_resultsUIMode != null){
	rb_resultsUIMode.setEnabled(active);
}
if(rb_chartType_Energy != null){
	rb_chartType_Energy.setEnabled(active);
}
if(rb_chartType_Economic != null){
	rb_chartType_Economic.setEnabled(active);
}
chartProfielen.rb_periodIncludingYear.setEnabled(active);
chartProfielen.rb_periodExcludingYear.setEnabled(active);
chartProfielen.rb_periodPeaksIncludingYear.setEnabled(active);
chartProfielen.rb_periodPeaksExcludingYear.setEnabled(active);
chartProfielen.f_enableExportButton(active);
chartNetbelasting.radio.setEnabled(active);
chartBalans.radio_period.setEnabled(active); 
  }

  
DataSet 
 f_createFlatDataset( double startTime_hr, double duration_hr, double value ) { 

DataSet flatDataset = new DataSet(2);
flatDataset.add(startTime_hr, value);
flatDataset.add(startTime_hr + duration_hr, value);

return flatDataset; 
  }

  public void f_updateResultsUI( I_EnergyData selectedObjectInterface ) { 

v_selectedObjectInterface = selectedObjectInterface;
v_selectedObjectScope = v_selectedObjectInterface.getScope();
f_setSelectedObjectText(null);
f_showCorrectChart(); 
  }

  void f_setSelectedObjectText( String customSelectedObjectText ) { 

String selectedObjectText = "";

if(customSelectedObjectText != null){
	selectedObjectText = customSelectedObjectText;
}
else{
	if(v_selectedObjectScope == OL_ResultScope.GRIDCONNECTION){
		GridConnection GC = ((GridConnection)v_selectedObjectInterface);
		String connectionDisplayName = GC.p_ownerID;
		if(GC.c_connectedGISObjects.size() > 0 && GC.c_connectedGISObjects.get(0).p_annotation != null && GC.c_connectedGISObjects.get(0).c_containedGridConnections.size() == 1){
			connectionDisplayName = GC.c_connectedGISObjects.get(0).p_annotation;
		}
		
		if(connectionDisplayName == null){
			connectionDisplayName = GC.p_gridConnectionID;
		}
		
		if(connectionDisplayName.contains("verblijfsobject.") || connectionDisplayName.contains("pand.")){
			selectedObjectText = "Een generieke aansluiting";
		}
		else{
			selectedObjectText = connectionDisplayName;
		}
	}
	else if(v_selectedObjectScope == OL_ResultScope.GRIDNODE){
		selectedObjectText = "Trafo-station : " + v_gridNode.p_gridNodeID;
	}
	else if(v_selectedObjectScope == OL_ResultScope.ENERGYCOOP){
		List<GridConnection> memberGCList = findAll(((EnergyCoop)v_selectedObjectInterface).f_getAllChildMemberGridConnections(), GC -> !(GC instanceof GCGridBattery && GC.f_getBatteryManagement() instanceof J_BatteryManagementPeakShaving && ((J_BatteryManagementPeakShaving)GC.f_getBatteryManagement()).getTargetType() == OL_ResultScope.ENERGYCOOP));
		
		if (memberGCList.size() != 0) {
			boolean allGCInOneBuilding = false;
			ArrayList<GIS_Object> firstMemberGCBuildings = memberGCList.get(0).c_connectedGISObjects;
			
			for(GIS_Object gisobject : firstMemberGCBuildings){
				allGCInOneBuilding = true;
				for(GridConnection memberGC : memberGCList){
					if(!gisobject.c_containedGridConnections.contains(memberGC)){
						allGCInOneBuilding = false;
						break;
					}
				}
				if(allGCInOneBuilding){
					break;
				}
			}

			if(allGCInOneBuilding){
				selectedObjectText = memberGCList.size() + " aansluitingen in één pand";
			}
			else{
				selectedObjectText = "Een selectie van aansluitingen"; // Een selectie van aansluitinge in meerdere panden (door middel van bijv filter).
			}
		} else {
			selectedObjectText = "klanten van energiecoöperatie"; // Geen aansluitingen in deze selectie
		}
	
	}
	else if(v_selectedObjectScope == OL_ResultScope.ENERGYMODEL){
			selectedObjectText = "Het gehele model";
		if(((EnergyModel)v_selectedObjectInterface).p_regionName != null){
			selectedObjectText = ((EnergyModel)v_selectedObjectInterface).p_regionName;
		}
	}
}

//Limit visible length
int maxStringLength = 40;
if (selectedObjectText.length() > maxStringLength){
     selectedObjectText = selectedObjectText.substring(0, maxStringLength);
}

t_selectedObjectDisplayText.setText("Data van: " + selectedObjectText); 
  }

  public void f_setCB_KPISummary_Presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the checkbox for the KPI summary chart

//Set x axis
if(location_x != null){
	checkbox_KPISummary.setX(location_x);
}

//Set y axis
if(location_y != null){
	checkbox_KPISummary.setY(location_y);
}

//Set visibility
checkbox_KPISummary.setVisible(visible); 
  }

  public void f_setSelectedObjectDisplay( Integer location_x, Integer location_y, boolean setVisible ) { 

//Set the location and visibility of the checkbox for the 'selected object display' group

//Set x axis
if(location_x != null){
	gr_selectedObjectDisplay.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_selectedObjectDisplay.setY(location_y);
}


//Set visibility
if(b_isCompanyUIResultsUI){
	gr_selectedObjectDisplay.setVisible(false);
}
else{
	gr_selectedObjectDisplay.setVisible(setVisible);
}
 
  }

  
DataSet 
 f_createNewDataSetDividedByValue( DataSet inputDataSet, double dividedByValue ) { 

if(dividedByValue == 0){
	new RuntimeException("Can't divide a dataset by zero!");
}

if(dividedByValue == 1){
	return inputDataSet;
}

DataSet newDataset = new DataSet(inputDataSet.size());
for (int i = 0; i < inputDataSet.size(); i++) {
    double newValue = inputDataSet.getY(i) / dividedByValue;
    newDataset.add(inputDataSet.getX(i), newValue);
}
return newDataset; 
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
	if ((v_interfaceViewAreaXOffset + v_resultsUIPresentationXOffset + xPosition) < (v_interfaceViewAreaXOffset + v_interfaceViewAreaWidth/2) ) {
		// bubble is on the left half, so text should appear to the right
		gr_infoText.setX( v_interfaceViewAreaXOffset + v_resultsUIPresentationXOffset + xPosition + margin_px + infoBubble.getWidth()/2);
	}
	else {
		// bubble is on the right half, so text should appear to the left
		gr_infoText.setX( v_interfaceViewAreaXOffset + v_resultsUIPresentationXOffset + xPosition - margin_px + infoBubble.getWidth()/2 - rect_infoText.getWidth());
	}
	
	// In AnyLogic the Y-Axis is inverted
	if ((v_interfaceViewAreaYOffset + v_resultsUIPresentationYOffset + yPosition) > (v_interfaceViewAreaYOffset + v_interfaceViewAreaHeight/2) ) {
		// bubble is on the bottom half, so text should appear above
		gr_infoText.setY( v_interfaceViewAreaYOffset + v_resultsUIPresentationYOffset + yPosition - margin_px  + infoBubble.getHeight()/2 - rect_infoText.getHeight());
	}
	else {
		// bubble is on the top half, so text should appear below
		gr_infoText.setY( v_interfaceViewAreaYOffset + v_resultsUIPresentationYOffset + yPosition + margin_px + infoBubble.getHeight()/2);
	}
	
	// Position of close button
	gr_closeInfoText.setX( width_ch * 7.5 - 20 ); // 20 px offset from the right hand side

	gr_infoText.setVisible(true);
} 
  }

  public void f_setChartEnergyCosts_presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the EnergyCosts charts presentation

//Set x axis
if(location_x != null){
	gr_chartEnergyCosts_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartEnergyCosts_presentation.setY(location_y);
}

//Set visibility
gr_chartEnergyCosts_presentation.setVisible(visible); 
  }

  public void f_setChartGTO_presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the Batteries charts presentation

//Set x axis
if(location_x != null){
	gr_chartGTO_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartGTO_presentation.setY(location_y);
}

//Set visibility
gr_chartGTO_presentation.setVisible(visible); 
  }

  public void f_setChartBars_Presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the balance charts presentation

//Set x axis
if(location_x != null){
	gr_chartBars_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartBars_presentation.setY(location_y);
}

//Set visibility
gr_chartBars_presentation.setVisible(visible); 
  }

  void f_initializeChartSelectionRB_Energy( List<OL_ChartTypes> selectedCharts_Energy ) { 

//Set active map overlay types if they are set in the project settings
if(selectedCharts_Energy != null && selectedCharts_Energy.size() > 0){
	c_loadedChartTypes_Energy = new ArrayList<OL_ChartTypes>(selectedCharts_Energy);
	if(c_loadedChartTypes_Energy.contains(OL_ChartTypes.PROFILES)){
		c_loadedChartTypes_Energy.remove(OL_ChartTypes.PROFILES);
	}
	c_loadedChartTypes_Energy.add(0, OL_ChartTypes.PROFILES); // Force profiles to always be present and to be the first one (for now!). Needed to not break 'enable live plots only'.
}
else{//No chart types loaded but profiles is required.
	c_loadedChartTypes_Energy = new ArrayList<OL_ChartTypes>();
	c_loadedChartTypes_Energy.add(OL_ChartTypes.PROFILES); // Force profiles to always be present and to be the first one (for now!). Needed to not break 'enable live plots only'.
}

//Never allow more than 6 chart types (for now) (does not fit in rb location) -> If more than 6, remove final option(s)
while(c_loadedChartTypes_Energy.size()>6){
	c_loadedChartTypes_Energy.remove(c_loadedChartTypes_Energy.get(6));
}

//Adjust the visualisation of the radiobuttons
Presentable presentable = gr_mainRadioButtons.getPresentable();
boolean ispublic = true;
double x = 300;
double y = -147 + (6 - c_loadedChartTypes_Energy.size()) * 11;
double width = 130;
double height = 0;//Not needed, automatically adjust by adding options
Color textColor = Color.BLACK;
boolean enabled = true;
Font font = new Font("Dialog", Font.PLAIN, 11);
boolean vertical = true;


//Set words for the radiobutton options
List<String> RadioButtonOptions_list = new ArrayList<String>();
for(OL_ChartTypes chartType : c_loadedChartTypes_Energy){
	switch(chartType){
		case PROFILES:
			RadioButtonOptions_list.add("Profielen");
			break;
		case BAR_TOTALS:
			RadioButtonOptions_list.add("Opwek/Verbruik diagram");
			break;
		case LOAD_DURATION_CURVES:
			RadioButtonOptions_list.add("Netbelasting");
			break;
		case SANKEY:
			RadioButtonOptions_list.add("Energiestromen");
			break;
		case GESPREKSLEIDRAAD_BEDRIJVEN:
			RadioButtonOptions_list.add("Gespreksleidraad Bedrijven");
			break;
		case GESPREKSLEIDRAAD:
			RadioButtonOptions_list.add("Gespreksleidraad");
			break;
		case BATTERY:
			RadioButtonOptions_list.add("Batterij");
			break;
		case GTO:
			RadioButtonOptions_list.add("GTO");
			break;
		case CO2:
			RadioButtonOptions_list.add("CO2 uitstoot");
			break;
		default:
			throw new RuntimeException("chartType '" + chartType + "' is not supported for the Energy options.");
	}
} 

String[] RadioButtonOptions = RadioButtonOptions_list.toArray(String[]::new);

//Create the radiobutton and set the correct action.
rb_chartType_Energy = new ShapeRadioButtonGroup(presentable, ispublic, x ,y, width, height, textColor, enabled, font, vertical, RadioButtonOptions){
	@Override
	public void action() {
		f_setChart_Energy();
	}
};

presentation.add(rb_chartType_Energy); 
  }

  void f_setChart_Energy(  ) { 

//Get chart type, based on loaded order of the radio buttons
v_selectedChartType = c_loadedChartTypes_Energy.get(rb_chartType_Energy.getValue());

if(b_showKPISummary){
	checkbox_KPISummary.setSelected(false, true);
}

f_showCorrectChart(); 
  }

  void f_initializeChartSelectionRB_Economic( List<OL_ChartTypes> selectedCharts_Economic ) { 

//Set active map overlay types if they are set in the project settings
if(selectedCharts_Economic != null && selectedCharts_Economic.size() > 0){
	c_loadedChartTypes_Economic = new ArrayList<OL_ChartTypes>(selectedCharts_Economic);
}
else{//No chart types loaded in: return.
	return;
}


//Adjust the visualisation of the radiobuttons
Presentable presentable = gr_mainRadioButtons.getPresentable();
boolean ispublic = true;
double x = 300;
double y = -147 + (6 - c_loadedChartTypes_Economic.size()) * 11;
double width = 130;
double height = 0;//Not needed, automatically adjust by adding options
Color textColor = Color.BLACK;
boolean enabled = true;
Font font = new Font("Dialog", Font.PLAIN, 11);
boolean vertical = true;


//Set words for the radiobutton options
List<String> RadioButtonOptions_list = new ArrayList<String>();
for(OL_ChartTypes chartType : c_loadedChartTypes_Economic){
	switch(chartType){
		case ENERGY_COSTS:
			RadioButtonOptions_list.add("Energie kosten");
			break;
		case CONNECTION_COSTS:
			RadioButtonOptions_list.add("Aansluitings kosten");
			break;
		case CAPEX_AND_OPEX:
			RadioButtonOptions_list.add("CAPEX & OPEX");
			break;
		case TOTAL_COSTS:
			RadioButtonOptions_list.add("Totale kosten");
			break;
		default:
			throw new RuntimeException("chartType '" + chartType + "' is not supported for the Economic options.");
	}
} 

String[] RadioButtonOptions = RadioButtonOptions_list.toArray(String[]::new);

//Create the radiobutton and set the correct action.
rb_chartType_Economic = new ShapeRadioButtonGroup(presentable, ispublic, x ,y, width, height, textColor, enabled, font, vertical, RadioButtonOptions){
	@Override
	public void action() {
		f_setChart_Economic();
	}
};

presentation.add(rb_chartType_Economic); 
  }

  void f_initializeResultsUIMainRB( List<OL_ChartTypes> selectedCharts_Energy, List<OL_ChartTypes> selectedCharts_Economic ) { 

//Set words for the radiobutton options
List<String> RadioButtonOptions_list = new ArrayList<String>();

//Add energy rb option and create the energy charts rb
RadioButtonOptions_list.add("Energie");
f_initializeChartSelectionRB_Energy(selectedCharts_Energy);

//Add economic rb option and create the economic charts rb if selected.
if(selectedCharts_Economic != null && selectedCharts_Economic.size() > 0){
	f_initializeChartSelectionRB_Economic(selectedCharts_Economic);
	RadioButtonOptions_list.add("Financieel");
	rb_chartType_Economic.setVisible(false);
}
else{ //No economic charts: no subdivisions: only energy rb/charts. -> No rb for mode switch needed.
	return;
}

//Adjust the visualisation of the radiobuttons
Presentable presentable = gr_resultsUIHeader.getPresentable();
boolean ispublic = true;
double x = 50;
double y =  -120;
double width = 130;
double height = 10;
Color textColor = Color.BLACK;
boolean enabled = true;
Font font = new Font("Dialog", Font.PLAIN, 12);
boolean vertical = false;

//Convert radio button option list to string[]
String[] RadioButtonOptions = RadioButtonOptions_list.toArray(String[]::new);

//Create the radiobutton and set the correct action.
rb_resultsUIMode = new ShapeRadioButtonGroup(presentable, ispublic, x ,y, width, height, textColor, enabled, font, vertical, RadioButtonOptions){
	@Override
	public void action() {
		if(rb_resultsUIMode.getValue() == 0){
			rb_chartType_Economic.setVisible(false);
			rb_chartType_Energy.setVisible(true);
			rb_chartType_Energy.setValue(rb_chartType_Energy.getValue(), true);
		}
		else{
			rb_chartType_Energy.setVisible(false);
			rb_chartType_Economic.setVisible(true);
			rb_chartType_Economic.setValue(rb_chartType_Economic.getValue(), true);		
		}
	}
};

presentation.add(rb_resultsUIMode); 
  }

  void f_setChart_Economic(  ) { 

//Get chart type, based on loaded order of the radio buttons
v_selectedChartType = c_loadedChartTypes_Economic.get(rb_chartType_Economic.getValue());

if(b_showKPISummary){
	checkbox_KPISummary.setSelected(false, true);
}

f_showCorrectChart(); 
  }

  public void f_setChartCO2_presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the Batteries charts presentation

//Set x axis
if(location_x != null){
	gr_chartCO2_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartCO2_presentation.setY(location_y);
}

//Set visibility
gr_chartCO2_presentation.setVisible(visible); 
  }

  public void f_setChartConnectionCosts_presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the ConnectionCosts charts presentation

//Set x axis
if(location_x != null){
	gr_chartConnectionCosts_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartConnectionCosts_presentation.setY(location_y);
}

//Set visibility
gr_chartConnectionCosts_presentation.setVisible(visible); 
  }

  public void f_setChartCAPEXAndOPEX_presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the CAPEXAndOPEX charts presentation

//Set x axis
if(location_x != null){
	gr_chartCAPEXAndOPEX_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartCAPEXAndOPEX_presentation.setY(location_y);
}

//Set visibility
gr_chartCAPEXAndOPEX_presentation.setVisible(visible); 
  }

  public void f_setChartTotalCosts_presentation( Integer location_x, Integer location_y, boolean visible ) { 

//Set the location and visibility of the TotalCosts charts presentation

//Set x axis
if(location_x != null){
	gr_chartTotalCosts_presentation.setX(location_x);
}

//Set y axis
if(location_y != null){
	gr_chartTotalCosts_presentation.setY(location_y);
}

//Set visibility
gr_chartTotalCosts_presentation.setVisible(visible); 
  }

  
String 
 f_getAssetName( OL_EnergyAssetType assetType ) { 

switch (assetType) {
	case STORAGE_ELECTRIC:
		return "Batterij";
	case PHOTOVOLTAIC:
		return "PV";
	case HEAT_PUMP_AIR:
		return "Warmtepomp";
	case PHOTOTHERMAL:
		return "PT-Panelen";
	case WINDMILL:
		return "Windturbine";
	case ELECTROLYSER:
		return "Electrolyser";
	case DIESEL_GENERATOR:
		return "Diesel generator";
	case METHANE_GENERATOR:
		return "Gas generator";
	case GAS_BURNER:
		return "Gasbrander";
	case ELECTRIC_VEHICLE:
		return "Elektrische autos";
	case ELECTRIC_VAN:
		return "Elektrische busjes";
	case ELECTRIC_TRUCK:
		return "Elektrische trucks";
	case HYDROGEN_TRUCK:
		return "Waterstof trucks";
		default:
			throw new RuntimeException("Onbekende assetType, kan niet vertaald worden.");
}



// The code below return the name in English
/*
String s = energyCarrier.toString();
return s.substring(0, 1) + s.substring(1).toLowerCase();
*/ 
  }

  void f_activateChartBlocker( List<OL_ResultScope> supportedResultScopes ) { 

gr_chartBlocker.setVisible(true);
String warningScreenMessage = "";
for(OL_ResultScope supportedScope : supportedResultScopes){
	switch(supportedScope){
		case GRIDCONNECTION:
			warningScreenMessage += "- één aansluiting";
			break;
		case ENERGYMODEL:
			warningScreenMessage += "- het hele gebied";
			break;
		case ENERGYCOOP:
			warningScreenMessage += "- een groep van aansluitingen";
			break;
		case GRIDNODE:
			warningScreenMessage += "- één trafo";
			break;
	}
	warningScreenMessage += "\n"; 
}
t_chartBlockerMessage.setText(warningScreenMessage); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea va_main = new ViewArea( this, null, 0, 0, 1920, 980 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1920.0, 980.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "va_main", this.va_main );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_locationTemplate_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_KPISummary_Font = _rb_locationTemplate_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_whatDoYouWantToLookAt_Font = new Font("Yu Gothic UI", 1, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_oldCode_Font = new Font("SansSerif", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text55_Font = new Font("SansSerif", 1, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_resultsUICode_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_resultsUISetupAndStylingFunctions_Font = _txt_oldCode_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_resultsUIDataUpdateFunctions_Font = _txt_oldCode_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_resultsUIInitialization_Font = _txt_oldCode_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_selectedObjectDisplayText_Font = _txt_oldCode_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_infoBubbleFunctions_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartBlockerMessageDefault_Font = new Font("SansSerif", 1, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_chartBlockerMessage_Font = new Font("SansSerif", 2, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartBlockerMessageDefault2_Font = new Font("SansSerif", 0, 20 );
  protected static final Color _rect_resultsMenuLarge_Fill_Color = new Color( 0xFFD6EFEF, true );
  protected static final Color _rect_selectedObjectDisplayBar_Fill_Color = new Color( 0xD0D0F5, true );
  protected static final Color _rect_selectedObjectDisplayBar_Line_Color = new Color( 0x9E9EC3, true );
  protected static final Color _rect_chartBlocker_Fill_Color = new Color( 0xFF5FBCBF, true );
  protected static final Color _rect_chartBlocker_Line_Color = new Color( 0xFF5FBCBF, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_old = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_resultsMenuLarge = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_whatDoYouWantToLookAt = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_mainRadioButtons = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_resultsUIHeader = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_canvas = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_canvas2 = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_oldCode = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_legendaColors = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _text55 = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartGTO_presentation = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartGTO_presentation = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartBatteries_presentation = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartBatteries_presentation = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartGespreksleidraadBedrijven_presentation = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartSummary_presentation = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartBalans_presentation = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartBalans_presentation = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartNetbelasting_presentation = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartNetbelasting_presentation = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartSankey_presentation = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartSankey_presentation = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartProfielen_presentation = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartProfielen_presentation = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartGespreksLeidraad_presentation = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartGespreksLeidraad_presentation = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartGelijktijdigheid_presentation = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartGelijktijdigheid_presentation = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartBars_presentation = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartBars_presentation = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartCO2_presentation = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartCO2_presentation = 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartEnergyCosts_presentation = 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartEnergyCosts_presentation = 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartCAPEXAndOPEX_presentation = 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartCAPEXAndOPEX_presentation = 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartTotalCosts_presentation = 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartTotalCosts_presentation = 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartConnectionCosts_presentation = 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartConnectionCosts_presentation = 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _chartKPISummary_presentation = 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartKPISummary_presentation = 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_ResultsUICode = 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_resultsUICodetxt = 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_resultsUICode = 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_setupAndStylingFunctions = 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_resultsUISetupAndStylingFunctions = 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_areaCollectionUpdateFunctions = 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_resultsUIDataUpdateFunctions = 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_areaCollectionUpdateFunctions1 = 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_resultsUIInitialization = 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_selectedObjectDisplayBar = 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_selectedObjectDisplayText = 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_selectedObjectDisplay = 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_infoBubbleFunctions = 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_infoBubbleFunctions = 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_chartBlocker = 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartBlockerMessageDefault = 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_chartBlockerMessage = 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartBlockerMessageDefault2 = 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartBlocker = 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_locationTemplate = 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_KPISummary = 64;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 65;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    if (_a == chartGTO) { return true; }
    if (_a == chartBatteries) { return true; }
    if (_a == chartGespreksleidraadBedrijven) { return true; }
    if (_a == chartBalans) { return true; }
    if (_a == chartNetbelasting) { return true; }
    if (_a == chartSankey) { return true; }
    if (_a == chartProfielen) { return true; }
    if (_a == chartGespreksLeidraad) { return true; }
    if (_a == chartGelijktijdigheid) { return true; }
    if (_a == chartBars) { return true; }
    if (_a == chartCO2) { return true; }
    if (_a == chartEnergyCosts) { return true; }
    if (_a == chartCAPEXAndOPEX) { return true; }
    if (_a == chartTotalCosts) { return true; }
    if (_a == chartConnectionCosts) { return true; }
    if (_a == chartKPISummary) { return true; }
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rect_old, gr_resultsUIHeader, rect_canvas, rect_canvas2, txt_oldCode, rect_legendaColors, text55, gr_chartGTO_presentation, gr_chartBatteries_presentation, gr_chartSummary_presentation, gr_chartBalans_presentation, gr_chartNetbelasting_presentation, gr_chartSankey_presentation, gr_chartProfielen_presentation, gr_chartGespreksLeidraad_presentation, gr_chartGelijktijdigheid_presentation, gr_chartBars_presentation, gr_chartCO2_presentation, gr_chartEnergyCosts_presentation, gr_chartCAPEXAndOPEX_presentation, gr_chartTotalCosts_presentation, gr_chartConnectionCosts_presentation, gr_chartKPISummary_presentation, rect_ResultsUICode, rect_resultsUICodetxt, txt_resultsUICode, rectangle, checkbox_KPISummary, rect_setupAndStylingFunctions, txt_resultsUISetupAndStylingFunctions, rect_areaCollectionUpdateFunctions, txt_resultsUIDataUpdateFunctions, rect_areaCollectionUpdateFunctions1, txt_resultsUIInitialization, gr_selectedObjectDisplay, rect_infoBubbleFunctions, txt_infoBubbleFunctions, gr_chartBlocker);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _rect_chartBlocker:
        if (true) {
          ShapeRectangle self = this.rect_chartBlocker;
          
int click = 0; 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, boolean value ) {
    switch( _shape ) {
      case _checkbox_KPISummary:
        b_showKPISummary = value; {
          ShapeCheckBox self = this.checkbox_KPISummary;
if(b_isCompanyUIResultsUI){
	f_setAllCharts();
	if(checkbox_KPISummary.isSelected()){
		gr_chartKPISummary_presentation.setVisible(true);
	}
	else{
		gr_chartKPISummary_presentation.setVisible(false);
	}
}
else{
	f_showCorrectChart();
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
      case _checkbox_KPISummary: return 
b_showKPISummary 
;
      default: return super.getShapeControlDefaultValueBoolean( _shape, index );
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rb_locationTemplate_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    boolean _visible = 
false; 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeRadioButtonGroup rb_locationTemplate;
  protected ShapeCheckBox checkbox_KPISummary;
  protected ShapeRectangle rect_old;
  protected ShapeRectangle rect_resultsMenuLarge;
  protected ShapeText txt_whatDoYouWantToLookAt;
  protected ShapeGroup gr_mainRadioButtons;
  protected ShapeGroup gr_resultsUIHeader;
  protected ShapeRectangle rect_canvas;
  protected ShapeRectangle rect_canvas2;
  protected ShapeText txt_oldCode;
  protected ShapeRectangle rect_legendaColors;
  protected ShapeText text55;
  protected ShapeEmbeddedObjectPresentation chartGTO_presentation;
  protected ShapeGroup gr_chartGTO_presentation;
  protected ShapeEmbeddedObjectPresentation chartBatteries_presentation;
  protected ShapeGroup gr_chartBatteries_presentation;
  protected ShapeEmbeddedObjectPresentation chartGespreksleidraadBedrijven_presentation;
  protected ShapeGroup gr_chartSummary_presentation;
  protected ShapeEmbeddedObjectPresentation chartBalans_presentation;
  protected ShapeGroup gr_chartBalans_presentation;
  protected ShapeEmbeddedObjectPresentation chartNetbelasting_presentation;
  protected ShapeGroup gr_chartNetbelasting_presentation;
  protected ShapeEmbeddedObjectPresentation chartSankey_presentation;
  protected ShapeGroup gr_chartSankey_presentation;
  protected ShapeEmbeddedObjectPresentation chartProfielen_presentation;
  protected ShapeGroup gr_chartProfielen_presentation;
  protected ShapeEmbeddedObjectPresentation chartGespreksLeidraad_presentation;
  protected ShapeGroup gr_chartGespreksLeidraad_presentation;
  protected ShapeEmbeddedObjectPresentation chartGelijktijdigheid_presentation;
  protected ShapeGroup gr_chartGelijktijdigheid_presentation;
  protected ShapeEmbeddedObjectPresentation chartBars_presentation;
  protected ShapeGroup gr_chartBars_presentation;
  protected ShapeEmbeddedObjectPresentation chartCO2_presentation;
  protected ShapeGroup gr_chartCO2_presentation;
  protected ShapeEmbeddedObjectPresentation chartEnergyCosts_presentation;
  protected ShapeGroup gr_chartEnergyCosts_presentation;
  protected ShapeEmbeddedObjectPresentation chartCAPEXAndOPEX_presentation;
  protected ShapeGroup gr_chartCAPEXAndOPEX_presentation;
  protected ShapeEmbeddedObjectPresentation chartTotalCosts_presentation;
  protected ShapeGroup gr_chartTotalCosts_presentation;
  protected ShapeEmbeddedObjectPresentation chartConnectionCosts_presentation;
  protected ShapeGroup gr_chartConnectionCosts_presentation;
  protected ShapeEmbeddedObjectPresentation chartKPISummary_presentation;
  protected ShapeGroup gr_chartKPISummary_presentation;
  protected ShapeRectangle rect_ResultsUICode;
  protected ShapeRectangle rect_resultsUICodetxt;
  protected ShapeText txt_resultsUICode;
  protected ShapeRectangle rectangle;
  protected ShapeRectangle rect_setupAndStylingFunctions;
  protected ShapeText txt_resultsUISetupAndStylingFunctions;
  protected ShapeRectangle rect_areaCollectionUpdateFunctions;
  protected ShapeText txt_resultsUIDataUpdateFunctions;
  protected ShapeRectangle rect_areaCollectionUpdateFunctions1;
  protected ShapeText txt_resultsUIInitialization;
  protected ShapeRectangle rect_selectedObjectDisplayBar;
  protected ShapeText t_selectedObjectDisplayText;
  protected ShapeGroup gr_selectedObjectDisplay;
  protected ShapeRectangle rect_infoBubbleFunctions;
  protected ShapeText txt_infoBubbleFunctions;
  protected ShapeRectangle rect_chartBlocker;
  protected ShapeText txt_chartBlockerMessageDefault;
  protected ShapeText t_chartBlockerMessage;
  protected ShapeText txt_chartBlockerMessageDefault2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_chartBlocker_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
230 
);
    shape.setY(
270 
);
  }
  
  protected ShapeGroup gr_chartBlocker;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rb_locationTemplate = new ShapeRadioButtonGroup(
UI_Results.this, true, -60.0, -60.0,
			150.0, 100.0,
            black, false,
_rb_locationTemplate_Font, true,
            new String[]{"Profielen", "Opwek/verbruik diagram", "Netbelasting", "Energiestromen", } ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rb_locationTemplate_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    checkbox_KPISummary = new ShapeCheckBox(
UI_Results.this,true,5.0, -30.0,
		190.0, 30.0,
            black, true,
            _checkbox_KPISummary_Font,
			"Toon simulatie samenvatting" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_KPISummary, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_KPISummary, 0 ) );
      }
    };
    rect_old = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,-700.0, 0.0, 0.0, 0.0,
            black, white,
			400.0, 340.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_resultsMenuLarge = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-250.0, -165.0, 0.0, 0.0,
            null, _rect_resultsMenuLarge_Fill_Color,
			460.0, 145.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_whatDoYouWantToLookAt = new ShapeText(
        SHAPE_DRAW_2D, true,-125.0, -110.0, 0.0, 0.0,
        black,"Wat wil je bekijken?",
        _txt_whatDoYouWantToLookAt_Font, ALIGNMENT_CENTER );
    rect_canvas = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,460.0, 0.0, 0.0, 0.0,
            null, white,
			1460.0, 980.0, 10.0, 0.0, LINE_STYLE_SOLID );
    rect_canvas2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,0.0, 740.0, 0.0, 0.0,
            null, white,
			460.0, 240.0, 10.0, 0.0, LINE_STYLE_SOLID );
    txt_oldCode = new ShapeText(
        SHAPE_DRAW_2D, false,-660.0, 20.0, 0.0, 0.0,
        black,"Old Code",
        _txt_oldCode_Font, ALIGNMENT_LEFT );
    rect_legendaColors = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,0.0, 980.0, 0.0, 0.0,
            black, white,
			460.0, 1170.0, 10.0, 1.0, LINE_STYLE_SOLID );
    text55 = new ShapeText(
        SHAPE_DRAW_2D, false,80.0, 1000.0, 0.0, 0.0,
        black,"Legenda Colors",
        _text55_Font, ALIGNMENT_LEFT );
    rect_ResultsUICode = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,500.0, 0.0, 0.0, 0.0,
            red, white,
			1420.0, 980.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_resultsUICodetxt = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,500.0, 0.0, 0.0, 0.0,
            red, white,
			160.0, 60.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_resultsUICode = new ShapeText(
        SHAPE_DRAW_2D, false,520.0, 20.0, 0.0, 0.0,
        black,"ResultsUI code",
        _txt_resultsUICode_Font, ALIGNMENT_LEFT );
    rectangle = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,360.0, 1520.0, 0.0, 0.0,
            black, forestGreen,
			80.0, 60.0, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_setupAndStylingFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,1520.0, 20.0, 0.0, 0.0,
            red, white,
			390.0, 640.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_resultsUISetupAndStylingFunctions = new ShapeText(
        SHAPE_DRAW_2D, false,1530.0, 30.0, 0.0, 0.0,
        black,"Locations and styling",
        _txt_resultsUISetupAndStylingFunctions_Font, ALIGNMENT_LEFT );
    rect_areaCollectionUpdateFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,1120.0, 320.0, 0.0, 0.0,
            dodgerBlue, white,
			380.0, 160.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_resultsUIDataUpdateFunctions = new ShapeText(
        SHAPE_DRAW_2D, false,1130.0, 330.0, 0.0, 0.0,
        black,"Update data functions",
        _txt_resultsUIDataUpdateFunctions_Font, ALIGNMENT_LEFT );
    rect_areaCollectionUpdateFunctions1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,1120.0, 20.0, 0.0, 0.0,
            black, white,
			380.0, 280.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_resultsUIInitialization = new ShapeText(
        SHAPE_DRAW_2D, false,1140.0, 30.0, 0.0, 0.0,
        black,"Initialization",
        _txt_resultsUIInitialization_Font, ALIGNMENT_LEFT );
    rect_selectedObjectDisplayBar = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-225.0, -10.0, 0.0, 0.0,
            _rect_selectedObjectDisplayBar_Line_Color, _rect_selectedObjectDisplayBar_Fill_Color,
			450.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_selectedObjectDisplayText = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, 10.0, 0.0, 0.0,
        black,"Data van: Een selectie van aansluitingen",
        _t_selectedObjectDisplayText_Font, ALIGNMENT_CENTER );
    rect_infoBubbleFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,490.0, 1000.0, 0.0, 0.0,
            black, white,
			342.0, 420.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_infoBubbleFunctions = new ShapeText(
        SHAPE_DRAW_2D, false,520.0, 1020.0, 0.0, 0.0,
        black,"Info Bubble Functions",
        _txt_infoBubbleFunctions_Font, ALIGNMENT_LEFT );
    rect_chartBlocker = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-229.006, -269.104, 0.0, 0.0,
            _rect_chartBlocker_Line_Color, _rect_chartBlocker_Fill_Color,
			458.013, 749.104, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_chartBlocker, 0, clickx, clicky );
      }
    };
    txt_chartBlockerMessageDefault = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -10.0, 0.0, 0.0,
        black,"LET OP: Het geselecteerde object wordt \nniet ondersteund door deze grafiek!",
        _txt_chartBlockerMessageDefault_Font, ALIGNMENT_CENTER );
    t_chartBlockerMessage = new ShapeText(
        SHAPE_DRAW_2D, true,-160.0, 130.0, 0.0, 0.0,
        black,"- één aansluiting\n- het hele gebied\n- een groep van aansluitingen\n- één trafo",
        _t_chartBlockerMessage_Font, ALIGNMENT_LEFT );
    txt_chartBlockerMessageDefault2 = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, 100.0, 0.0, 0.0,
        black,"Om deze grafiek te gebruiken selecteer:",
        _txt_chartBlockerMessageDefault2_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_mainRadioButtons = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 90.0, -80.0, 0.0, 0.0
	
	     , rb_locationTemplate );
    }
    {
    gr_resultsUIHeader = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 250.0, 20.0, 0.0, 0.0
	
	     , rect_resultsMenuLarge
	     , txt_whatDoYouWantToLookAt
	     , gr_mainRadioButtons );
    }
    {
    chartGTO_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartGTO_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 800.0, 380.0, 0.0, 0.0
	
	     , chartGTO_presentation );
    }
    {
    chartBatteries_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartBatteries_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 490.0, 370.0, 0.0, 0.0
	
	     , chartBatteries_presentation );
    }
    gr_chartBatteries_presentation.setVisible( false );
    {
    chartGespreksleidraadBedrijven_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartSummary_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , chartGespreksleidraadBedrijven_presentation );
    }
    gr_chartSummary_presentation.setVisible( false );
    {
    chartBalans_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartBalans_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , chartBalans_presentation );
    }
    gr_chartBalans_presentation.setVisible( false );
    {
    chartNetbelasting_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartNetbelasting_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , chartNetbelasting_presentation );
    }
    gr_chartNetbelasting_presentation.setVisible( false );
    {
    chartSankey_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartSankey_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , chartSankey_presentation );
    }
    gr_chartSankey_presentation.setVisible( false );
    {
    chartProfielen_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartProfielen_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , chartProfielen_presentation );
    }
    {
    chartGespreksLeidraad_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartGespreksLeidraad_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 1800.0, 940.0, 0.0, 0.0
	
	     , chartGespreksLeidraad_presentation );
    }
    gr_chartGespreksLeidraad_presentation.setVisible( false );
    {
    chartGelijktijdigheid_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartGelijktijdigheid_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , chartGelijktijdigheid_presentation );
    }
    gr_chartGelijktijdigheid_presentation.setVisible( false );
    {
    chartBars_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartBars_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , chartBars_presentation );
    }
    {
    chartCO2_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartCO2_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 230.0, 380.0, 0.0, 0.0
	
	     , chartCO2_presentation );
    }
    {
    chartEnergyCosts_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartEnergyCosts_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 230.0, 380.0, 0.0, 0.0
	
	     , chartEnergyCosts_presentation );
    }
    {
    chartCAPEXAndOPEX_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartCAPEXAndOPEX_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 230.0, 380.0, 0.0, 0.0
	
	     , chartCAPEXAndOPEX_presentation );
    }
    {
    chartTotalCosts_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartTotalCosts_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 230.0, 380.0, 0.0, 0.0
	
	     , chartTotalCosts_presentation );
    }
    {
    chartConnectionCosts_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartConnectionCosts_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 230.0, 380.0, 0.0, 0.0
	
	     , chartConnectionCosts_presentation );
    }
    {
    chartKPISummary_presentation = new ShapeEmbeddedObjectPresentation( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_chartKPISummary_presentation = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , chartKPISummary_presentation );
    }
    gr_chartKPISummary_presentation.setVisible( false );
    {
    gr_selectedObjectDisplay = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 230.0, 55.0, 0.0, 0.0
	
	     , rect_selectedObjectDisplayBar
	     , t_selectedObjectDisplayText );
    }
    {
    gr_chartBlocker = new ShapeGroup( UI_Results.this, SHAPE_DRAW_2D3D, true, 2200.0, 320.0, 0.0, 0.0
	
	     , rect_chartBlocker
	     , txt_chartBlockerMessageDefault
	     , t_chartBlockerMessage
	     , txt_chartBlockerMessageDefault2 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_chartBlocker_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_chartBlocker.setVisible( false );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
    chartGTO_presentation.setEmbeddedObject_xjal( chartGTO );
    chartBatteries_presentation.setEmbeddedObject_xjal( chartBatteries );
    chartGespreksleidraadBedrijven_presentation.setEmbeddedObject_xjal( chartGespreksleidraadBedrijven );
    chartBalans_presentation.setEmbeddedObject_xjal( chartBalans );
    chartNetbelasting_presentation.setEmbeddedObject_xjal( chartNetbelasting );
    chartSankey_presentation.setEmbeddedObject_xjal( chartSankey );
    chartProfielen_presentation.setEmbeddedObject_xjal( chartProfielen );
    chartGespreksLeidraad_presentation.setEmbeddedObject_xjal( chartGespreksLeidraad );
    chartGelijktijdigheid_presentation.setEmbeddedObject_xjal( chartGelijktijdigheid );
    chartBars_presentation.setEmbeddedObject_xjal( chartBars );
    chartCO2_presentation.setEmbeddedObject_xjal( chartCO2 );
    chartEnergyCosts_presentation.setEmbeddedObject_xjal( chartEnergyCosts );
    chartCAPEXAndOPEX_presentation.setEmbeddedObject_xjal( chartCAPEXAndOPEX );
    chartTotalCosts_presentation.setEmbeddedObject_xjal( chartTotalCosts );
    chartConnectionCosts_presentation.setEmbeddedObject_xjal( chartConnectionCosts );
    chartKPISummary_presentation.setEmbeddedObject_xjal( chartKPISummary );
    chartGTO_presentation.setEmbeddedObject_xjal( chartGTO );
    chartBatteries_presentation.setEmbeddedObject_xjal( chartBatteries );
    chartGespreksleidraadBedrijven_presentation.setEmbeddedObject_xjal( chartGespreksleidraadBedrijven );
    chartBalans_presentation.setEmbeddedObject_xjal( chartBalans );
    chartNetbelasting_presentation.setEmbeddedObject_xjal( chartNetbelasting );
    chartSankey_presentation.setEmbeddedObject_xjal( chartSankey );
    chartProfielen_presentation.setEmbeddedObject_xjal( chartProfielen );
    chartGespreksLeidraad_presentation.setEmbeddedObject_xjal( chartGespreksLeidraad );
    chartGelijktijdigheid_presentation.setEmbeddedObject_xjal( chartGelijktijdigheid );
    chartBars_presentation.setEmbeddedObject_xjal( chartBars );
    chartCO2_presentation.setEmbeddedObject_xjal( chartCO2 );
    chartEnergyCosts_presentation.setEmbeddedObject_xjal( chartEnergyCosts );
    chartCAPEXAndOPEX_presentation.setEmbeddedObject_xjal( chartCAPEXAndOPEX );
    chartTotalCosts_presentation.setEmbeddedObject_xjal( chartTotalCosts );
    chartConnectionCosts_presentation.setEmbeddedObject_xjal( chartConnectionCosts );
    chartKPISummary_presentation.setEmbeddedObject_xjal( chartKPISummary );
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
  public UI_Results( Engine engine, Agent owner, AgentList<? extends UI_Results> ownerPopulation ) {
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
    chartProfielen = instantiate_chartProfielen_xjal();
    chartBatteries = instantiate_chartBatteries_xjal();
    chartNetbelasting = instantiate_chartNetbelasting_xjal();
    chartBalans = instantiate_chartBalans_xjal();
    chartBars = instantiate_chartBars_xjal();
    chartSankey = instantiate_chartSankey_xjal();
    chartKPISummary = instantiate_chartKPISummary_xjal();
    chartGTO = instantiate_chartGTO_xjal();
    chartEnergyCosts = instantiate_chartEnergyCosts_xjal();
    chartGespreksLeidraad = instantiate_chartGespreksLeidraad_xjal();
    chartGespreksleidraadBedrijven = instantiate_chartGespreksleidraadBedrijven_xjal();
    chartGelijktijdigheid = instantiate_chartGelijktijdigheid_xjal();
    chartCAPEXAndOPEX = instantiate_chartCAPEXAndOPEX_xjal();
    chartTotalCosts = instantiate_chartTotalCosts_xjal();
    chartConnectionCosts = instantiate_chartConnectionCosts_xjal();
    chartCO2 = instantiate_chartCO2_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public UI_Results() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public UI_Results( EnergyModel energyModel, double p_cutOff_MWh, ShapeGroup gr_infoText, ShapeGroup gr_closeInfoText, ShapeText t_infoTextDescription, ShapeRoundedRectangle rect_infoText, List<ShapeImage> p_currentActiveInfoBubble ) {
    markParametersAreSet();
    this.energyModel = energyModel;
    this.p_cutOff_MWh = p_cutOff_MWh;
    this.gr_infoText = gr_infoText;
    this.gr_closeInfoText = gr_closeInfoText;
    this.t_infoTextDescription = t_infoTextDescription;
    this.rect_infoText = rect_infoText;
    this.p_currentActiveInfoBubble = p_currentActiveInfoBubble;
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
    setupPlainVariables_UI_Results_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( UI_Results.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    addAll( c_defaultOrderEC, new OL_EnergyCarriers[] 
{
OL_EnergyCarriers.ELECTRICITY,
OL_EnergyCarriers.METHANE,
OL_EnergyCarriers.PETROLEUM_FUEL,
OL_EnergyCarriers.HEAT,
OL_EnergyCarriers.HYDROGEN,
OL_EnergyCarriers.IRON_POWDER
} 
    );
    addAll( c_defaultOrderAC, new OL_AssetFlowCategories[] 
{
OL_AssetFlowCategories.fixedConsumptionElectric_kW,
OL_AssetFlowCategories.batteriesChargingPower_kW,
OL_AssetFlowCategories.batteriesDischargingPower_kW,
OL_AssetFlowCategories.CHPProductionElectric_kW,
OL_AssetFlowCategories.districtHeatDelivery_kW,
OL_AssetFlowCategories.electricHobConsumption_kW,
OL_AssetFlowCategories.electrolyserElectricityConsumption_kW,
OL_AssetFlowCategories.evChargingPower_kW,
OL_AssetFlowCategories.heatPumpElectricityConsumption_kW,
OL_AssetFlowCategories.pvProductionElectric_kW,
OL_AssetFlowCategories.V2GPower_kW,
OL_AssetFlowCategories.windProductionElectric_kW,
OL_AssetFlowCategories.airConditionersElectricPower_kW,
OL_AssetFlowCategories.dieselGeneratorProductionElectric_kW,
OL_AssetFlowCategories.methaneGeneratorProductionElectric_kW,
OL_AssetFlowCategories.hydrogenFuelCellProductionElectric_kW,
OL_AssetFlowCategories.districtHeatDelivery_kW,
OL_AssetFlowCategories.ptProductionHeat_kW
} 
    );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( UI_Results.this, getElementProperty( "digital_twin_results.UI_Results.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
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
    setupParameters_chartProfielen_xjal( chartProfielen, null );
    doBeforeCreate_chartProfielen_xjal( chartProfielen, null );
    chartProfielen.createAsEmbedded();
    setupParameters_chartBatteries_xjal( chartBatteries, null );
    doBeforeCreate_chartBatteries_xjal( chartBatteries, null );
    chartBatteries.createAsEmbedded();
    setupParameters_chartNetbelasting_xjal( chartNetbelasting, null );
    doBeforeCreate_chartNetbelasting_xjal( chartNetbelasting, null );
    chartNetbelasting.createAsEmbedded();
    setupParameters_chartBalans_xjal( chartBalans, null );
    doBeforeCreate_chartBalans_xjal( chartBalans, null );
    chartBalans.createAsEmbedded();
    setupParameters_chartBars_xjal( chartBars, null );
    doBeforeCreate_chartBars_xjal( chartBars, null );
    chartBars.createAsEmbedded();
    setupParameters_chartSankey_xjal( chartSankey, null );
    doBeforeCreate_chartSankey_xjal( chartSankey, null );
    chartSankey.createAsEmbedded();
    setupParameters_chartKPISummary_xjal( chartKPISummary, null );
    doBeforeCreate_chartKPISummary_xjal( chartKPISummary, null );
    chartKPISummary.createAsEmbedded();
    setupParameters_chartGTO_xjal( chartGTO, null );
    doBeforeCreate_chartGTO_xjal( chartGTO, null );
    chartGTO.createAsEmbedded();
    setupParameters_chartEnergyCosts_xjal( chartEnergyCosts, null );
    doBeforeCreate_chartEnergyCosts_xjal( chartEnergyCosts, null );
    chartEnergyCosts.createAsEmbedded();
    setupParameters_chartGespreksLeidraad_xjal( chartGespreksLeidraad, null );
    doBeforeCreate_chartGespreksLeidraad_xjal( chartGespreksLeidraad, null );
    chartGespreksLeidraad.createAsEmbedded();
    setupParameters_chartGespreksleidraadBedrijven_xjal( chartGespreksleidraadBedrijven, null );
    doBeforeCreate_chartGespreksleidraadBedrijven_xjal( chartGespreksleidraadBedrijven, null );
    chartGespreksleidraadBedrijven.createAsEmbedded();
    setupParameters_chartGelijktijdigheid_xjal( chartGelijktijdigheid, null );
    doBeforeCreate_chartGelijktijdigheid_xjal( chartGelijktijdigheid, null );
    chartGelijktijdigheid.createAsEmbedded();
    setupParameters_chartCAPEXAndOPEX_xjal( chartCAPEXAndOPEX, null );
    doBeforeCreate_chartCAPEXAndOPEX_xjal( chartCAPEXAndOPEX, null );
    chartCAPEXAndOPEX.createAsEmbedded();
    setupParameters_chartTotalCosts_xjal( chartTotalCosts, null );
    doBeforeCreate_chartTotalCosts_xjal( chartTotalCosts, null );
    chartTotalCosts.createAsEmbedded();
    setupParameters_chartConnectionCosts_xjal( chartConnectionCosts, null );
    doBeforeCreate_chartConnectionCosts_xjal( chartConnectionCosts, null );
    chartConnectionCosts.createAsEmbedded();
    setupParameters_chartCO2_xjal( chartCO2, null );
    doBeforeCreate_chartCO2_xjal( chartCO2, null );
    chartCO2.createAsEmbedded();
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( UI_Results.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    checkbox_KPISummary.setValueToDefault();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    chartProfielen.startAsEmbedded();
    chartBatteries.startAsEmbedded();
    chartNetbelasting.startAsEmbedded();
    chartBalans.startAsEmbedded();
    chartBars.startAsEmbedded();
    chartSankey.startAsEmbedded();
    chartKPISummary.startAsEmbedded();
    chartGTO.startAsEmbedded();
    chartEnergyCosts.startAsEmbedded();
    chartGespreksLeidraad.startAsEmbedded();
    chartGespreksleidraadBedrijven.startAsEmbedded();
    chartGelijktijdigheid.startAsEmbedded();
    chartCAPEXAndOPEX.startAsEmbedded();
    chartTotalCosts.startAsEmbedded();
    chartConnectionCosts.startAsEmbedded();
    chartCO2.startAsEmbedded();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

// TODO: Fill cm_consumptionColors and cm_productionColors here?
cm_productionColors = new J_ColorMap<>(OL_EnergyCarriers.class);
cm_productionColors.put(OL_EnergyCarriers.ELECTRICITY, v_electricitySupplyColor);
cm_productionColors.put(OL_EnergyCarriers.HEAT, v_districtHeatHeatSupplyColor);
cm_productionColors.put(OL_EnergyCarriers.METHANE, v_naturalGasSupplyColor);
cm_productionColors.put(OL_EnergyCarriers.PETROLEUM_FUEL, v_petroleumProductsSupplyColor);
cm_productionColors.put(OL_EnergyCarriers.HYDROGEN, v_hydrogenSupplyColor);
cm_productionColors.put(OL_EnergyCarriers.IRON_POWDER, v_ironPowderSupplyColor);

cm_consumptionColors = new J_ColorMap<>(OL_EnergyCarriers.class);
cm_consumptionColors.put(OL_EnergyCarriers.ELECTRICITY, v_electricityDemandColor);
cm_consumptionColors.put(OL_EnergyCarriers.HEAT, v_districtHeatDemandColor);
cm_consumptionColors.put(OL_EnergyCarriers.METHANE, v_naturalGasDemandColor);
cm_consumptionColors.put(OL_EnergyCarriers.PETROLEUM_FUEL, v_petroleumProductsDemandColor);
cm_consumptionColors.put(OL_EnergyCarriers.HYDROGEN, v_hydrogenDemandColor);
cm_consumptionColors.put(OL_EnergyCarriers.IRON_POWDER, v_ironPowderDemandColor);

// Fill assetFlowLabels:
lm_assetFlowLabels = new EnumMap<>(OL_AssetFlowCategories.class);
lm_assetFlowLabels.put(OL_AssetFlowCategories.fixedConsumptionElectric_kW,"Elektr. behoefte basis");
lm_assetFlowLabels.put(OL_AssetFlowCategories.batteriesChargingPower_kW,"Opladen batterijen");
lm_assetFlowLabels.put(OL_AssetFlowCategories.batteriesDischargingPower_kW,"Ontladen batterijen");
lm_assetFlowLabels.put(OL_AssetFlowCategories.CHPProductionElectric_kW,"Elektr. opwek WKK");
lm_assetFlowLabels.put(OL_AssetFlowCategories.districtHeatDelivery_kW,"Warmte uit warmtenet");
lm_assetFlowLabels.put(OL_AssetFlowCategories.electricHobConsumption_kW,"Elektrisch koken");
lm_assetFlowLabels.put(OL_AssetFlowCategories.electrolyserElectricityConsumption_kW,"Elektr. behoefte elektrolysers");
lm_assetFlowLabels.put(OL_AssetFlowCategories.evChargingPower_kW,"Opladen EVs");
lm_assetFlowLabels.put(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW,"Elektr. behoefte warmte");
lm_assetFlowLabels.put(OL_AssetFlowCategories.ptProductionHeat_kW,"Warmte zonnecollectoren");
lm_assetFlowLabels.put(OL_AssetFlowCategories.pvProductionElectric_kW,"Opwek zonne-energie");
lm_assetFlowLabels.put(OL_AssetFlowCategories.V2GPower_kW,"Vehicle to Grid");
lm_assetFlowLabels.put(OL_AssetFlowCategories.windProductionElectric_kW,"Opwek wind");
lm_assetFlowLabels.put(OL_AssetFlowCategories.airConditionersElectricPower_kW,"Elektr. behoefte Airco's");
lm_assetFlowLabels.put(OL_AssetFlowCategories.dieselGeneratorProductionElectric_kW, "Elektr. opwek diesel gen.");
lm_assetFlowLabels.put(OL_AssetFlowCategories.methaneGeneratorProductionElectric_kW, "Elektr. opwek gas gen.");
lm_assetFlowLabels.put(OL_AssetFlowCategories.hydrogenFuelCellProductionElectric_kW, "Elektr. opwek H2 fuelcell");

cm_assetFlowColors = new J_ColorMap<>(OL_AssetFlowCategories.class);
cm_assetFlowColors.put(OL_AssetFlowCategories.fixedConsumptionElectric_kW, v_electricityBaseloadDemandColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.batteriesChargingPower_kW, v_electricityForStorageDemandColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.batteriesDischargingPower_kW, v_storageElectricitySupplyColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.CHPProductionElectric_kW, v_CHPElectricitySupplyColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.districtHeatDelivery_kW, v_districtHeatDemandColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.electricHobConsumption_kW, v_electricityForCookingDemandColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.electrolyserElectricityConsumption_kW, v_electricityForHydrogenDemandColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.evChargingPower_kW, v_electricityForTransportDemandColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW, v_electricityForHeatDemandColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.ptProductionHeat_kW, v_ptProductionColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.pvProductionElectric_kW, v_PVElectricitySupplyColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.V2GPower_kW, v_V2GElectricitySupplyColor);  
cm_assetFlowColors.put(OL_AssetFlowCategories.windProductionElectric_kW, v_windElectricitySupplyColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.airConditionersElectricPower_kW, v_PVElectricitySupplyColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.dieselGeneratorProductionElectric_kW, v_petroleumProductsElectricitySupplyColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.methaneGeneratorProductionElectric_kW, v_methaneElectricitySupplyColor);
cm_assetFlowColors.put(OL_AssetFlowCategories.hydrogenFuelCellProductionElectric_kW, v_electricityForHydrogenDemandColor);

v_consumptionAssetFlows = EnumSet.noneOf(OL_AssetFlowCategories.class);
v_consumptionAssetFlows.add(OL_AssetFlowCategories.fixedConsumptionElectric_kW);
v_consumptionAssetFlows.add(OL_AssetFlowCategories.batteriesChargingPower_kW);
v_consumptionAssetFlows.add(OL_AssetFlowCategories.districtHeatDelivery_kW);
v_consumptionAssetFlows.add(OL_AssetFlowCategories.electricHobConsumption_kW);
v_consumptionAssetFlows.add(OL_AssetFlowCategories.electrolyserElectricityConsumption_kW);
v_consumptionAssetFlows.add(OL_AssetFlowCategories.evChargingPower_kW);
v_consumptionAssetFlows.add(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW);
v_consumptionAssetFlows.add(OL_AssetFlowCategories.airConditionersElectricPower_kW);

v_electricAssetFlows = EnumSet.noneOf(OL_AssetFlowCategories.class);
v_electricAssetFlows.add(OL_AssetFlowCategories.fixedConsumptionElectric_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.batteriesChargingPower_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.batteriesDischargingPower_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.CHPProductionElectric_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.electricHobConsumption_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.electrolyserElectricityConsumption_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.evChargingPower_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.pvProductionElectric_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.V2GPower_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.windProductionElectric_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.airConditionersElectricPower_kW);
v_electricAssetFlows.add(OL_AssetFlowCategories.hydrogenFuelCellProductionElectric_kW); 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_UI_Results_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_UI_Results_xjal() {
    v_naturalGasDemandColor = 
new Color(212, 186, 157) 
;
    v_ElektrischeWPColor = 
lightBlue 
;
    v_HybrideWPColor = 
yellowGreen 
;
    v_MTDistrictHeatingColor = 
sandyBrown 
;
    v_LTDistrictHeatingColor = 
peachPuff 
;
    v_GreenGasBoilerColor = 
oliveDrab 
;
    v_uitgeslotenColor = 
whiteSmoke 
;
    v_energieLabelAColor = 
darkGreen 
;
    v_energieLabelBColor = 
green 
;
    v_energieLabelCColor = 
yellowGreen 
;
    v_energieLabelDColor = 
gold 
;
    v_energieLabelEColor = 
orange 
;
    v_energieLabelFColor = 
orangeRed 
;
    v_energieLabelOnbekendColor = 
peru 
;
    v_energieLabelGColor = 
red 
;
    v_districtHeatDemandColor = 
peru 
;
    v_highlightParticipantsColor = 
greenYellow 
;
    v_electricityBaseloadDemandColor = 
lightBlue 
;
    v_electricityForTransportDemandColor = 
new Color(127, 127, 230) 
;
    v_electricityForHydrogenDemandColor = 
dodgerBlue 
;
    v_electricityForHeatDemandColor = 
new Color(194, 65, 194) 
;
    v_electricityForStorageDemandColor = 
thistle 
;
    v_PVElectricitySupplyColor = 
gold 
;
    v_windElectricitySupplyColor = 
lightSkyBlue 
;
    v_storageElectricitySupplyColor = 
yellowGreen 
;
    v_V2GElectricitySupplyColor = 
mediumOrchid 
;
    v_petroleumProductsDemandColor = 
new Color(132, 132, 132) 
;
    v_naturalGasSupplyColor = 
silver 
;
    v_petroleumProductsSupplyColor = 
darkGray 
;
    v_districtHeatHeatSupplyColor = 
peru 
;
    v_energyDemandColor = 
fireBrick 
;
    v_heatPumpHeatSupplyColor = 
orange 
;
    v_electricityDemandColor = 
lightGreen 
;
    v_hydrogenDemandColor = 
dodgerBlue 
;
    v_electricitySupplyColor = 
yellow 
;
    v_electricityCapacityColor_known = 
darkOrange 
;
    v_selectedObjectScope = 
OL_ResultScope.ENERGYMODEL 
;
    v_selectedChartType = 
PROFILES 
;
    v_selfConsumedElectricityColor = 
green 
;
    v_importedEnergyColor = 
darkRed 
;
    v_exportedEnergyColor = 
darkRed 
;
    v_selfConsumedEnergyColor = 
green 
;
    v_hydrogenSupplyColor = 
dodgerBlue 
;
    v_electricityForCookingDemandColor = 
peachPuff 
;
    b_showKPISummary = 
false 
;
    v_electricityCapacityColor_estimated = 
gray 
;
    v_CHPElectricitySupplyColor = 
forestGreen 
;
    b_showGroupContractValues = 
false 
;
    v_cumulativeGTVColor = 
burlyWood 
;
    v_groupGTVColor = 
red 
;
    v_selectedObjectInterface = 
energyModel 
;
    b_enableGroupContractMode = 
false 
;
    v_resultsUIPresentationXOffset = 
1440 
;
    v_resultsUIPresentationYOffset = 
230 
;
    v_infoText = 
new J_InfoTextResultsUI() 
;
    v_interfaceViewAreaWidth = 
1920 
;
    v_interfaceViewAreaHeight = 
980 
;
    v_interfaceViewAreaXOffset = 
0 
;
    v_interfaceViewAreaYOffset = 
0 
;
    v_ptProductionColor = 
indianRed 
;
    v_methaneElectricitySupplyColor = 
new Color(212, 186, 157) 
;
    v_petroleumProductsElectricitySupplyColor = 
new Color(132, 132, 132) 
;
    v_ironPowderDemandColor = 
new Color(170, 39, 4) 
;
    v_ironPowderSupplyColor = 
new Color(170, 39, 4) 
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
    list.add( chartProfielen );
    list.add( chartBatteries );
    list.add( chartNetbelasting );
    list.add( chartBalans );
    list.add( chartBars );
    list.add( chartSankey );
    list.add( chartKPISummary );
    list.add( chartGTO );
    list.add( chartEnergyCosts );
    list.add( chartGespreksLeidraad );
    list.add( chartGespreksleidraadBedrijven );
    list.add( chartGelijktijdigheid );
    list.add( chartCAPEXAndOPEX );
    list.add( chartTotalCosts );
    list.add( chartConnectionCosts );
    list.add( chartCO2 );
    return list;
  }

  public AgentList<? extends UI_Results> getPopulation() {
    return (AgentList<? extends UI_Results>) super.getPopulation();
  }

  public List<? extends UI_Results> agentsInRange( double distance ) {
    return (List<? extends UI_Results>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    chartProfielen.onDestroy();
    chartBatteries.onDestroy();
    chartNetbelasting.onDestroy();
    chartBalans.onDestroy();
    chartBars.onDestroy();
    chartSankey.onDestroy();
    chartKPISummary.onDestroy();
    chartGTO.onDestroy();
    chartEnergyCosts.onDestroy();
    chartGespreksLeidraad.onDestroy();
    chartGespreksleidraadBedrijven.onDestroy();
    chartGelijktijdigheid.onDestroy();
    chartCAPEXAndOPEX.onDestroy();
    chartTotalCosts.onDestroy();
    chartConnectionCosts.onDestroy();
    chartCO2.onDestroy();
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    chartProfielen.doFinish();
    chartBatteries.doFinish();
    chartNetbelasting.doFinish();
    chartBalans.doFinish();
    chartBars.doFinish();
    chartSankey.doFinish();
    chartKPISummary.doFinish();
    chartGTO.doFinish();
    chartEnergyCosts.doFinish();
    chartGespreksLeidraad.doFinish();
    chartGespreksleidraadBedrijven.doFinish();
    chartGelijktijdigheid.doFinish();
    chartCAPEXAndOPEX.doFinish();
    chartTotalCosts.doFinish();
    chartConnectionCosts.doFinish();
    chartCO2.doFinish();
  }

  // Additional class code

public ShapeCheckBox getCheckbox_KPISummary(){
	return checkbox_KPISummary;
}

public ShapeRadioButtonGroup getResultsUIModeRadioButtons() {
	return this.rb_resultsUIMode;
}
public ShapeRadioButtonGroup getEnergyRadioButtons() {
	return this.rb_chartType_Energy;
}
public ShapeRadioButtonGroup getEconomicRadioButtons() {
	return this.rb_chartType_Economic;
}
public ShapeGroup getGr_resultsUIHeader(){
	return gr_resultsUIHeader;
}
 
  // End of additional class code

}
