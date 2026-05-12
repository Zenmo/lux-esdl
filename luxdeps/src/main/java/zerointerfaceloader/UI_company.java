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
		GC.p_parentNodeHeat = findFirst(zero_Interface.energyModel.f_getGridNodesTopLevel(), node -> node.p_energyCarrier == OL_EnergyCarriers.HEAT);
		if(GC.p_parentNodeHeat == null){
			GridNode GN_heat = zero_Interface.energyModel.add_pop_gridNodes();
			zero_Interface.energyModel.f_getGridNodesTopLevel().add(GN_heat);
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

if (GC.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW)){
	J_EAProduction pvAsset = findFirst(GC.c_productionAssets, p -> p.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC );
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

  void f_createVehicle( GridConnection parentGC, OL_EnergyAssetType vehicleType, J_ActivityTrackerTrips tripTracker, boolean available, boolean isAdditionalVehicle ) { 

double energyConsumption_kWhpkm = 0;
double vehicleScaling 			= 1.0;
J_TimeParameters timeParameters	= zero_Interface.energyModel.p_timeParameters;

if (vehicleType == OL_EnergyAssetType.ELECTRIC_VEHICLE || vehicleType == OL_EnergyAssetType.ELECTRIC_VAN || vehicleType == OL_EnergyAssetType.ELECTRIC_TRUCK ){ // Create EVS
	double storageCapacity_kWh 		= 0;
	double capacityElectricity_kW 	= 0;
	double stateOfCharge_fr  		= 1; // Initial state of charge

	switch(vehicleType){
		case ELECTRIC_VEHICLE:
			capacityElectricity_kW	= (p_scenarioSettings_Current.getCurrentEVCarChargePower_kW() > 0) ? p_scenarioSettings_Current.getCurrentEVCarChargePower_kW() : zero_Interface.energyModel.avgc_data.p_avgEVMaxChargePowerCar_kW;
			storageCapacity_kWh		= zero_Interface.energyModel.avgc_data.p_avgEVStorageCar_kWh;
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm;
		break;
		case ELECTRIC_VAN:
			capacityElectricity_kW	= (p_scenarioSettings_Current.getCurrentEVVanChargePower_kW() > 0) ? p_scenarioSettings_Current.getCurrentEVVanChargePower_kW() : zero_Interface.energyModel.avgc_data.p_avgEVMaxChargePowerVan_kW;
			storageCapacity_kWh		= zero_Interface.energyModel.avgc_data.p_avgEVStorageVan_kWh;
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionVan_kWhpkm;
		break;
		case ELECTRIC_TRUCK:
			capacityElectricity_kW	= (p_scenarioSettings_Current.getCurrentEVTruckChargePower_kW() > 0) ? p_scenarioSettings_Current.getCurrentEVTruckChargePower_kW() : zero_Interface.energyModel.avgc_data.p_avgEVMaxChargePowerTruck_kW;
			storageCapacity_kWh		= zero_Interface.energyModel.avgc_data.p_avgEVStorageTruck_kWh;
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionTruck_kWhpkm;
		break;
	
	}
	
	//Create EV and connect to GC and selected trip tracker
	J_EAEV electricVehicle = new J_EAEV(parentGC, capacityElectricity_kW, storageCapacity_kWh, stateOfCharge_fr, timeParameters, energyConsumption_kWhpkm, vehicleScaling, vehicleType, tripTracker, available);	
	
	
	if (isAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).add(electricVehicle);
	}
	else{
		zero_Interface.c_orderedVehicles.add(0, electricVehicle);
	}
	
	//Check if charging management is present if not: add default management
	if(parentGC.f_getCurrentChargingType() == OL_ChargingAttitude.NONE){
		parentGC.f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
	}
}

else if (vehicleType == OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE || vehicleType == OL_EnergyAssetType.PETROLEUM_FUEL_VAN || vehicleType == OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK ){ // Create petroleumFuel vehicles
	switch (vehicleType){
		
		case PETROLEUM_FUEL_VEHICLE:
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgGasolineConsumptionCar_kWhpkm;
		break;
		
		case PETROLEUM_FUEL_VAN:
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgDieselConsumptionVan_kWhpkm;
		break;
		
		case PETROLEUM_FUEL_TRUCK:
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgDieselConsumptionTruck_kWhpkm;
		break;
	}
	
	//Create PetroleumFuel vehicle and connect to GC and selected trip tracker
	J_EAFuelVehicle petroleumFuelVehicle = new J_EAFuelVehicle(parentGC, energyConsumption_kWhpkm, timeParameters, vehicleScaling, vehicleType, tripTracker, OL_EnergyCarriers.PETROLEUM_FUEL, available);
	
	
	
	if (isAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).add(petroleumFuelVehicle);
	}
	else{
		zero_Interface.c_orderedVehicles.add(0, petroleumFuelVehicle);
	}
}

else{ // (Hydrogen vehicles)
	switch (vehicleType){
		case HYDROGEN_VEHICLE:
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgHydrogenConsumptionCar_kWhpkm;
		break;
		case HYDROGEN_VAN:
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgHydrogenConsumptionVan_kWhpkm;
		break;
		case HYDROGEN_TRUCK:
			energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgHydrogenConsumptionTruck_kWhpkm;
		break;
		
	}
	
	//Create Hydrogen vehicle and connect to GC and selected trip tracker
	J_EAFuelVehicle hydrogenVehicle = new J_EAFuelVehicle(parentGC, energyConsumption_kWhpkm, timeParameters, vehicleScaling, vehicleType, tripTracker, OL_EnergyCarriers.HYDROGEN, available);
	
	
	
	if (isAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).add(hydrogenVehicle);
	}
	else{
		zero_Interface.c_orderedVehicles.add(0, hydrogenVehicle);
	}
}

 
  }

  void f_setElectricVehicleSliders( GridConnection GC, OL_EnergyAssetType vehicleType, int setAmountOfVehicles ) { 

int local_EV_nb;
int local_PetroleumFuelV_nb;
int local_HydrogenV_nb;
int max_amount_petroleumFuel_vehicles;

OL_EnergyAssetType vehicleType_petroleumFuel;
OL_EnergyAssetType vehicleType_hydrogen;

switch (vehicleType){
	
	case ELECTRIC_VEHICLE:

	vehicleType_petroleumFuel = OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE;
	vehicleType_hydrogen = OL_EnergyAssetType.HYDROGEN_VEHICLE;

	local_EV_nb = v_nbEVCars;
	local_PetroleumFuelV_nb = v_nbPetroleumFuelCars;
	local_HydrogenV_nb = v_nbHydrogenCars;
	
	max_amount_petroleumFuel_vehicles = v_maxPetroleumFuelCarSlider;
	
	break;
	
	case ELECTRIC_VAN:
	
	vehicleType_petroleumFuel = OL_EnergyAssetType.PETROLEUM_FUEL_VAN;
	vehicleType_hydrogen = OL_EnergyAssetType.HYDROGEN_VAN;
	
	local_EV_nb = v_nbEVVans;
	local_PetroleumFuelV_nb = v_nbPetroleumFuelVans;
	local_HydrogenV_nb = v_nbHydrogenVans;
	
	max_amount_petroleumFuel_vehicles = v_maxPetroleumFuelVanSlider;
	
	break;
	
	case ELECTRIC_TRUCK:

	vehicleType_petroleumFuel = OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK;
	vehicleType_hydrogen = OL_EnergyAssetType.HYDROGEN_TRUCK;
	
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
	int nbOfOtherAdditionalVehiclesOfThisClass = findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), p -> p.getEAType() == vehicleType_petroleumFuel || p.getEAType() == vehicleType_hydrogen).size();
	while(setAmountOfVehicles > local_EV_nb && nbOfOtherAdditionalVehiclesOfThisClass > 0 ){
		
		// Find an additional PetroleumFuel vehicle
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), p -> p.getEAType() == vehicleType_petroleumFuel);
		
		if(petroleumFuelVehicle != null){
			J_ActivityTrackerTrips tripTracker = petroleumFuelVehicle.getTripTracker();
			
			// Remove PetroleumFuel vehicle		
			boolean available = petroleumFuelVehicle.getAvailability();
			petroleumFuelVehicle.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(petroleumFuelVehicle);
			zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
			
			//Create new additional EV
			f_createVehicle(GC, vehicleType, tripTracker, available, true);			

			//Update local variables
			local_EV_nb++;
			local_PetroleumFuelV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
		else{
			// Find an additional Hydrogen vehicle
			J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), p -> p.getEAType() == vehicleType_hydrogen);
			J_ActivityTrackerTrips tripTracker = hydrogenVehicle.getTripTracker();
			
			// Remove Hydrogen vehicle		
			boolean available = hydrogenVehicle.getAvailability();
			hydrogenVehicle.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(hydrogenVehicle);
			zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
			
			//Create new additional EV
			f_createVehicle(GC, vehicleType, tripTracker, available, true);

			//Update local variables
			local_EV_nb++;
			local_HydrogenV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
	}
	
	while ( setAmountOfVehicles > local_EV_nb && local_PetroleumFuelV_nb > 0) {
		
		// Find a PetroleumFuel vehicle
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == vehicleType_petroleumFuel && ((GridConnection)p.getOwner()) == GC);
		J_ActivityTrackerTrips tripTracker = petroleumFuelVehicle.getTripTracker(); 
		
		// Remove PetroleumFuel vehicle		
		boolean available = petroleumFuelVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
		petroleumFuelVehicle.removeEnergyAsset();

		//Create new EV
		f_createVehicle(GC, vehicleType, tripTracker, available, false);
			
		//Update variables
		local_EV_nb++;
		local_PetroleumFuelV_nb--;
	}
	while (setAmountOfVehicles > local_EV_nb && local_HydrogenV_nb > 0){
	
		// Find a Hydrogen vehicle
		J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == vehicleType_hydrogen  && ((GridConnection)p.getOwner()) == GC);
		J_ActivityTrackerTrips tripTracker = hydrogenVehicle.getTripTracker();
		
		// Remove Hydrogen vehicle		
		boolean available = hydrogenVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
		hydrogenVehicle.removeEnergyAsset();

		//Create new EV
		f_createVehicle(GC, vehicleType, tripTracker, available, false);
	
		//Update variables
		local_EV_nb++;
		local_HydrogenV_nb--;
	}
	while (setAmountOfVehicles > local_EV_nb){ //If still not enough EV:
		
		// Create additional vehicles
		f_createVehicle(GC, vehicleType, null, true, true);
		
		//Update variables
		local_EV_nb++;
	}
	
}
else if(setAmountOfVehicles < local_EV_nb){ // Slider has decreased the amount of selected vehicles
	
	ArrayList<I_Vehicle> additionalVehicles = new ArrayList<>(findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getEAType() == vehicleType ));
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
		J_EAEV ev = (J_EAEV)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == vehicleType && !zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).contains(p)  && ((GridConnection)p.getOwner()) == GC);
		J_ActivityTrackerTrips tripTracker = ev.getTripTracker();

		//Remove EV
		boolean available = ev.getAvailability();
		zero_Interface.c_orderedVehicles.remove(ev);
		ev.removeEnergyAsset();
		
		// Create petroleumFuel vehicle	
		f_createVehicle(GC, vehicleType_petroleumFuel, tripTracker, available, false);				
		
		local_EV_nb--;
		local_PetroleumFuelV_nb++;
		}
}



//Update variables
switch (vehicleType){
	
	case ELECTRIC_VEHICLE:
	
	v_nbEVCars = local_EV_nb;
	v_nbPetroleumFuelCars = local_PetroleumFuelV_nb;
	v_nbHydrogenCars = local_HydrogenV_nb;
	
	break;
	
	case ELECTRIC_VAN:
	
	v_nbEVVans = local_EV_nb;
	v_nbPetroleumFuelVans = local_PetroleumFuelV_nb;
	v_nbHydrogenVans = local_HydrogenV_nb;
	
	break;
	
	case ELECTRIC_TRUCK:
	
	v_nbEVTrucks = local_EV_nb;
	v_nbPetroleumFuelTrucks = local_PetroleumFuelV_nb;
	v_nbHydrogenTrucks = local_HydrogenV_nb;
		
	break;
} 
  }

  void f_setPetroleumFuelVehicleSliders( GridConnection GC, OL_EnergyAssetType vehicleType, int setAmountOfVehicles ) { 

int local_EV_nb;
int local_PetroleumFuelV_nb;
int local_HydrogenV_nb;

int min_amount_EV;
int	max_amount_EV;

OL_EnergyAssetType vehicleType_electric;
OL_EnergyAssetType vehicleType_hydrogen;
	
switch (vehicleType){
	
	case PETROLEUM_FUEL_VEHICLE:

	vehicleType_electric = OL_EnergyAssetType.ELECTRIC_VEHICLE;
	vehicleType_hydrogen = OL_EnergyAssetType.HYDROGEN_VEHICLE;

	local_EV_nb = v_nbEVCars;
	local_PetroleumFuelV_nb = v_nbPetroleumFuelCars;
	local_HydrogenV_nb = v_nbHydrogenCars;
	
	min_amount_EV = v_minEVCarSlider;
	max_amount_EV = v_maxEVCarSlider;
	
	break;
	
	case PETROLEUM_FUEL_VAN:
	
	vehicleType_electric = OL_EnergyAssetType.ELECTRIC_VAN;
	vehicleType_hydrogen = OL_EnergyAssetType.HYDROGEN_VAN;
	
	local_EV_nb = v_nbEVVans;
	local_PetroleumFuelV_nb = v_nbPetroleumFuelVans;
	local_HydrogenV_nb = v_nbHydrogenVans;
	
	min_amount_EV = v_minEVVanSlider;
	max_amount_EV = v_maxEVVanSlider;
	
	break;
	
	case PETROLEUM_FUEL_TRUCK:

	vehicleType_electric = OL_EnergyAssetType.ELECTRIC_TRUCK;
	vehicleType_hydrogen = OL_EnergyAssetType.HYDROGEN_TRUCK;
	
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
	int nbOfOtherAdditionalVehiclesOfThisClass = findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), p -> p.getEAType() == vehicleType_hydrogen || p.getEAType() == vehicleType_electric).size();
	while(setAmountOfVehicles > local_PetroleumFuelV_nb && nbOfOtherAdditionalVehiclesOfThisClass > 0 ){

		// Find an additional EV vehicle
		J_EAEV ev = (J_EAEV)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), p -> p.getEAType() == vehicleType_electric);
			
		if(ev != null){
			J_ActivityTrackerTrips tripTracker = ev.getTripTracker();
		
			// Remove EV
			boolean available = ev.getAvailability();
			ev.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(ev);
			zero_Interface.c_orderedVehicles.remove(ev);
			
			//Create new additional PetroleumFuel vehicle
			f_createVehicle(GC, vehicleType, tripTracker, available, true);

			//Update local variables
			local_PetroleumFuelV_nb++;
			local_EV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
		else{
			// Find an additional Hydrogen vehicle
			J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), p -> p.getEAType() == vehicleType_hydrogen);
			J_ActivityTrackerTrips tripTracker = hydrogenVehicle.getTripTracker();
			
			// Remove Hydrogen vehicle		
			boolean available = hydrogenVehicle.getAvailability();
			hydrogenVehicle.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(hydrogenVehicle);
			zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
			
			//Create new additional PetroleumFuel vehicle
			f_createVehicle(GC, vehicleType, tripTracker, available, true);

			//Update local variables
			local_PetroleumFuelV_nb++;
			local_HydrogenV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
	}
	while ( setAmountOfVehicles > local_PetroleumFuelV_nb && local_EV_nb > min_amount_EV) {

		// Find an EV
		J_EAEV ev = (J_EAEV)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == vehicleType_electric  && ((GridConnection)p.getOwner()) == GC);
		J_ActivityTrackerTrips tripTracker = ev.getTripTracker();
		
		//Remove one EV
		boolean available = ev.getAvailability();
		zero_Interface.c_orderedVehicles.remove(ev);
		ev.removeEnergyAsset();
		
		//Create new PetroleumFuel vehicle
		f_createVehicle(GC, vehicleType, tripTracker, available, false);
			
		//Update variables
		local_PetroleumFuelV_nb++;
		local_EV_nb--;
	}
	while (setAmountOfVehicles > local_PetroleumFuelV_nb && local_HydrogenV_nb > 0){
	
		// Find a Hydrogen vehicle
		J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == vehicleType_hydrogen  && ((GridConnection)p.getOwner()) == GC);
		J_ActivityTrackerTrips tripTracker = hydrogenVehicle.getTripTracker();
		
		// Remove hydrogen vehicle			
		boolean available = hydrogenVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
		hydrogenVehicle.removeEnergyAsset();
		
		//Create new PetroleumFuel vehicle
		f_createVehicle(GC, vehicleType, tripTracker, available, false);
	
		//Update variables
		local_PetroleumFuelV_nb++;
		local_HydrogenV_nb--;
	}
	while (setAmountOfVehicles > local_PetroleumFuelV_nb){ // Create additional vehicles
	
	f_createVehicle(GC, vehicleType, null, true, true);

	local_PetroleumFuelV_nb++;
	}
}
else if(setAmountOfVehicles < local_PetroleumFuelV_nb){ // Slider has decreased the amount of selected vehicles
	
	ArrayList<I_Vehicle> additionalVehicles = new ArrayList<>(findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getEAType() == vehicleType ));
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
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == vehicleType && !zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).contains(p)  && ((GridConnection)p.getOwner()) == GC);
		J_ActivityTrackerTrips tripTracker = petroleumFuelVehicle.getTripTracker();
		
		// Remove petroleumFuel vehicle		
		boolean available = petroleumFuelVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
		petroleumFuelVehicle.removeEnergyAsset();
		
		//Create new EV
		f_createVehicle(GC, vehicleType_electric, tripTracker, available, false);
			
		//Update variables
		local_PetroleumFuelV_nb--;
		local_EV_nb++;
	}
}



//Update variables
switch (vehicleType){
	
	case PETROLEUM_FUEL_VEHICLE:
	v_nbEVCars = local_EV_nb;
	v_nbPetroleumFuelCars = local_PetroleumFuelV_nb;
	v_nbHydrogenCars = local_HydrogenV_nb;
	break;
	
	case PETROLEUM_FUEL_VAN:
	v_nbEVVans = local_EV_nb;
	v_nbPetroleumFuelVans = local_PetroleumFuelV_nb;
	v_nbHydrogenVans = local_HydrogenV_nb;
	break;
	
	case PETROLEUM_FUEL_TRUCK:
	v_nbEVTrucks = local_EV_nb;
	v_nbPetroleumFuelTrucks = local_PetroleumFuelV_nb;
	v_nbHydrogenTrucks = local_HydrogenV_nb;
	break;
} 
  }

  public void f_setHydrogenVehicleSliders( GridConnection GC, OL_EnergyAssetType vehicleType, int setAmountOfVehicles ) { 

int local_EV_nb;
int local_PetroleumFuelV_nb;
int local_HydrogenV_nb;

int min_amount_EV;
int	max_amount_EV;

OL_EnergyAssetType vehicleType_electric;
OL_EnergyAssetType vehicleType_petroleumFuel;
	
switch (vehicleType){
	
	case HYDROGEN_VEHICLE:

	vehicleType_electric = OL_EnergyAssetType.ELECTRIC_VEHICLE;
	vehicleType_petroleumFuel = OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE;

	local_EV_nb = v_nbEVCars;
	local_PetroleumFuelV_nb = v_nbPetroleumFuelCars;
	local_HydrogenV_nb = v_nbHydrogenCars;
	
	min_amount_EV = v_minEVCarSlider;
	max_amount_EV = v_maxEVCarSlider;
	
	break;
	
	case HYDROGEN_VAN:
	
	vehicleType_electric = OL_EnergyAssetType.ELECTRIC_VAN;
	vehicleType_petroleumFuel = OL_EnergyAssetType.PETROLEUM_FUEL_VAN;
	
	local_EV_nb = v_nbEVVans;
	local_PetroleumFuelV_nb = v_nbPetroleumFuelVans;
	local_HydrogenV_nb = v_nbHydrogenVans;
	
	min_amount_EV = v_minEVVanSlider;
	max_amount_EV = v_maxEVVanSlider;
	
	break;
	
	case HYDROGEN_TRUCK:

	vehicleType_electric = OL_EnergyAssetType.ELECTRIC_TRUCK;
	vehicleType_petroleumFuel = OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK;
	
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
	int nbOfOtherAdditionalVehiclesOfThisClass = findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), p -> p.getEAType() == vehicleType_petroleumFuel || p.getEAType() == vehicleType_electric).size();
	while(setAmountOfVehicles > local_HydrogenV_nb && nbOfOtherAdditionalVehiclesOfThisClass > 0 ){
		
		// Find an additional PetroleumFuel vehicle
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), p -> p.getEAType() == vehicleType_petroleumFuel);
		
		if(petroleumFuelVehicle != null){
			J_ActivityTrackerTrips tripTracker = petroleumFuelVehicle.getTripTracker();
			
			// Remove PetroleumFuel vehicle		
			boolean available = petroleumFuelVehicle.getAvailability();
			petroleumFuelVehicle.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(petroleumFuelVehicle);
			zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
			
			//Create new additional Hydrogen vehicle
			f_createVehicle(GC, vehicleType, tripTracker, available, true);			

			//Update local variables
			local_HydrogenV_nb++;
			local_PetroleumFuelV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
		else{
			// Find an additional EV vehicle
			J_EAEV ev = (J_EAEV)findFirst(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), p -> p.getEAType() == vehicleType_electric);
			J_ActivityTrackerTrips tripTracker = ev.getTripTracker();
		
			// Remove EV
			boolean available = ev.getAvailability();
			ev.removeEnergyAsset();
			zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).remove(ev);
			zero_Interface.c_orderedVehicles.remove(ev);
			
			//Create new additional Hydrogen vehicle
			f_createVehicle(GC, vehicleType, tripTracker, available, true);

			//Update local variables
			local_HydrogenV_nb++;
			local_EV_nb--;
			nbOfOtherAdditionalVehiclesOfThisClass--;
		}
	}
	while ( setAmountOfVehicles > local_HydrogenV_nb && local_PetroleumFuelV_nb > 0) {

		// Find a to be removed PetroleumFuel vehicle
		J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == vehicleType_petroleumFuel  && ((GridConnection)p.getOwner()) == GC);
		J_ActivityTrackerTrips tripTracker = petroleumFuelVehicle.getTripTracker();

		//Remove petroleumFuel vehicle
		boolean available = petroleumFuelVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(petroleumFuelVehicle);
		petroleumFuelVehicle.removeEnergyAsset();
		
		//Create new Hydrogen vehicle
		f_createVehicle(GC, vehicleType, tripTracker, available, false);
			
		//Update variables
		local_HydrogenV_nb++;
		local_PetroleumFuelV_nb--;
		
	}
	while (setAmountOfVehicles > local_HydrogenV_nb && local_EV_nb > min_amount_EV){
		
		// Find a to be removed EV
		J_EAEV ev = (J_EAEV)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == vehicleType_electric  && ((GridConnection)p.getOwner()) == GC);
		J_ActivityTrackerTrips tripTracker = ev.getTripTracker();
		
		// Remove EV
		boolean available = ev.getAvailability();
		zero_Interface.c_orderedVehicles.remove(ev);
		ev.removeEnergyAsset();
		
		//Create new Hydrogen vehicle
		f_createVehicle(GC, vehicleType, tripTracker, available, false);
			
		//Update variables
		local_HydrogenV_nb++;
		local_EV_nb--;
	}
	while (setAmountOfVehicles > local_HydrogenV_nb){ // Create additional vehicles
	
	f_createVehicle(GC, vehicleType, null, true, true);
	local_HydrogenV_nb++;	
	}

	
}
else if(setAmountOfVehicles < local_HydrogenV_nb){ // Slider has decreased the amount of selected vehicles
	
	ArrayList<I_Vehicle> additionalVehicles = new ArrayList<>(findAll(zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid), vehicle -> vehicle.getEAType() == vehicleType ));
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
		J_EAFuelVehicle hydrogenVehicle = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == vehicleType && !zero_Interface.c_additionalVehicles.get(p_gridConnection.p_uid).contains(p)  && ((GridConnection)p.getOwner()) == GC);
		J_ActivityTrackerTrips tripTracker = hydrogenVehicle.getTripTracker();
		
		// Remove hydrogen vehicle			
		boolean available = hydrogenVehicle.getAvailability();
		zero_Interface.c_orderedVehicles.remove(hydrogenVehicle);
		hydrogenVehicle.removeEnergyAsset();
		
		//Create new EV vehicle
		f_createVehicle(GC, vehicleType_electric, tripTracker, available, false);
	
		//Update variables
		local_HydrogenV_nb--;
		local_EV_nb++;
	}
}

//Update variables
switch (vehicleType){
	
	case HYDROGEN_VEHICLE:
	
	v_nbEVCars = local_EV_nb;
	v_nbPetroleumFuelCars = local_PetroleumFuelV_nb;
	v_nbHydrogenCars = local_HydrogenV_nb;
	
	break;
	
	case HYDROGEN_VAN:
	
	v_nbEVVans = local_EV_nb;
	v_nbPetroleumFuelVans = local_PetroleumFuelV_nb;
	v_nbHydrogenVans = local_HydrogenV_nb;
	
	break;
	
	case HYDROGEN_TRUCK:
	
	v_nbEVTrucks = local_EV_nb;
	v_nbPetroleumFuelTrucks = local_PetroleumFuelV_nb;
	v_nbHydrogenTrucks = local_HydrogenV_nb;
	
	break;
} 
  }

  void f_setResultsUIPresets(  ) { 

//Set the order of the resultsUI to front but behind simulation screen group and load icon
presentation.remove(uI_Results_presentation);
presentation.insert(presentation.size()-1, uI_Results_presentation);
presentation.remove(gr_loadIcon);
presentation.insert(presentation.size()-1, gr_loadIcon);
presentation.remove(gr_simulateYearScreen);
presentation.insert(presentation.size()-1, gr_simulateYearScreen);
presentation.remove(gr_GCisPausedScreen);
presentation.insert(presentation.size()-1, gr_GCisPausedScreen);



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

int nameLength = p_companyName.length();

int i = 0;
if(nameLength > 24){
	while(24+i != nameLength){
	
		t_companyName.setScale(0.9);
		i++;
	}
}
//Works for now: Possible to make it more accurate using getFontMetrics package and comparing width of text with the name text box width.
//--> Not done for now, as it feels unnecessary. 
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
  protected static final Color _ovalTransportButton1_Fill_Color = new Color( 0xFFD7EFF2, true );
  protected static final Color _rect_loadIcon_Fill_Color = new Color( 0xE9F5F5F5, true );
  protected static final Color _rect_loadIcon_Line_Color = new Color( 0xE9F5F5F5, true );
  protected static final Color _rect_GCisPausedScreen_Fill_Color = new Color( 0xE9F5F5F5, true );
  protected static final Color _rect_GCisPausedScreen_Line_Color = new Color( 0xE9F5F5F5, true );
  protected static final Color _rect_errorScreenGrayOut_Fill_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_errorScreenGrayOut_Line_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_errorScreenClickBlocking_Fill_Color = new Color( 0x85D3D3D3, true );
  protected static final Color _rect_errorScreenClickBlocking_Line_Color = new Color( 0x85D3D3D3, true );
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
  protected static final int _button1 = 138;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_scenariosPrivateUI = 139;
  @AnyLogicInternalCodegenAPI
  protected static final int _button2 = 140;
  @AnyLogicInternalCodegenAPI
  protected static final int _button3 = 141;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_GCCapacityCompany = 142;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatDemandCompanyReduction = 143;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricityDemandCompanyReduction = 144;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricVansCompany = 145;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_hydrogenVansCompany = 146;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_petroleumFuelVansCompany = 147;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_hydrogenTrucksCompany = 148;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricTrucksCompany = 149;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_petroleumFuelTrucksCompany = 150;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricCarsCompany = 151;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_mobilityDemandCompanyReduction = 152;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_hydrogenCarsCompany = 153;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_petroleumFuelCarsCompany = 154;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_selectGC = 155;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_batteryCompany = 156;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_heatingTypePrivateUI = 157;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_rooftopPVCompany = 158;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_GCCapacityCompany_Feedin = 159;
  @AnyLogicInternalCodegenAPI
  protected static final int _button = 160;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_curtailmentCompany = 161;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_showGridloadPlot = 162;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 163;

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
	  level.addAll(rect_canvas, rect_background, rect_sliders, rect_scenarios, text, text4, txt_storedScenarios, button1, gr_scenarioRB, txt_scenarioSettings, txt_sliderPresetsAndLimits, txt_sliderFunctions, button2, button3, txt_initialization, txt_uiResult, gr_companyUISliders, button, gr_companyDetails, uI_Results_presentation, mask_resultsUI1, mask_resultsUI2, gr_chartNameLeft, gr_chartNameMiddle, gr_chartNameRight, gr_simulateYearScreen, gr_loadIcon, txt_curtailmentDescriptionCompany, cb_curtailmentCompany, txt_nfatoValues, gr_TableConnectionCapacity, gr_GCisPausedScreen, cb_showGridloadPlot, gr_errorScreen, txt_setSimYearScreen, txt_selectDifferentOwnedGC);
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
      case _button: {
          ShapeButton self = this.button;
zero_Interface.uI_Results.getCheckbox_KPISummary().setSelected(false, true);

zero_Interface.va_Interface.navigateTo();
zero_Interface.v_currentViewArea = zero_Interface.va_Interface;
 
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
f_setElectricVehicleSliders(p_gridConnection, OL_EnergyAssetType.ELECTRIC_VAN, (int)sl_electricVansCompany.getValue());

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
f_setHydrogenVehicleSliders(p_gridConnection, OL_EnergyAssetType.HYDROGEN_VAN, (int)sl_hydrogenVansCompany.getValue());

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
f_setPetroleumFuelVehicleSliders(p_gridConnection, OL_EnergyAssetType.PETROLEUM_FUEL_VAN, (int)sl_petroleumFuelVansCompany.getValue());

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
f_setHydrogenVehicleSliders(p_gridConnection, OL_EnergyAssetType.HYDROGEN_TRUCK, (int)sl_hydrogenTrucksCompany.getValue());

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
f_setElectricVehicleSliders(p_gridConnection, OL_EnergyAssetType.ELECTRIC_TRUCK, (int)sl_electricTrucksCompany.getValue());

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
f_setPetroleumFuelVehicleSliders(p_gridConnection, OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK, (int)sl_petroleumFuelTrucksCompany.getValue());

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
f_setElectricVehicleSliders(p_gridConnection, OL_EnergyAssetType.ELECTRIC_VEHICLE, (int)sl_electricCarsCompany.getValue());

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
p_gridConnection.c_tripTrackers.forEach(tt -> tt.distanceScaling_fr = 1-sl_mobilityDemandCompanyReduction.getValue()/100);

//Set scenario to custom
f_setScenario(2);

// Simulate Year screen
f_setSimulateYearScreen(); 
;}
        break;
      case _sl_hydrogenCarsCompany: {
          ShapeSlider self = this.sl_hydrogenCarsCompany;
//Slider function
f_setHydrogenVehicleSliders(p_gridConnection, OL_EnergyAssetType.HYDROGEN_VEHICLE, (int)sl_hydrogenCarsCompany.getValue());

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
f_setPetroleumFuelVehicleSliders(p_gridConnection, OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE, (int)sl_petroleumFuelCarsCompany.getValue());

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
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
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
        black,"Autos",
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
  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP1_xjal() {
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
  public UI_company( String p_companyName, int p_maxAddedVehicles, J_scenario_Current p_scenarioSettings_Current, J_scenario_Future p_scenarioSettings_Future, GridConnection p_gridConnection, double p_maxSavingsSliders_default, double p_minSavingsSliders_default ) {
    markParametersAreSet();
    this.p_companyName = p_companyName;
    this.p_maxAddedVehicles = p_maxAddedVehicles;
    this.p_scenarioSettings_Current = p_scenarioSettings_Current;
    this.p_scenarioSettings_Future = p_scenarioSettings_Future;
    this.p_gridConnection = p_gridConnection;
    this.p_maxSavingsSliders_default = p_maxSavingsSliders_default;
    this.p_minSavingsSliders_default = p_minSavingsSliders_default;
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
    presentation.getConfiguration3D().setBackgroundColor( silver );
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
new Color( 204, 72, 118);  
;
    v_companyUILineColor = 
black 
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
