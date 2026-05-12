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

public class EnergySupplier extends zero_engine.Actor
{
  // Parameters

  public 
double  p_fixedElectricityPrice_eurpkWh;

  /**
   * Returns default value for parameter <code>p_fixedElectricityPrice_eurpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_fixedElectricityPrice_eurpkWh_DefaultValue_xjal() {
    final EnergySupplier self = this;
    return 0.0;
  }

  public void set_p_fixedElectricityPrice_eurpkWh( double value ) {
    if (value == this.p_fixedElectricityPrice_eurpkWh) {
      return;
    }
    double _oldValue_xjal = this.p_fixedElectricityPrice_eurpkWh;
    this.p_fixedElectricityPrice_eurpkWh = value;
    onChange_p_fixedElectricityPrice_eurpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_fixedElectricityPrice_eurpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_fixedElectricityPrice_eurpkWh()</code> method instead.
   */
  protected void onChange_p_fixedElectricityPrice_eurpkWh() {
    onChange_p_fixedElectricityPrice_eurpkWh_xjal( p_fixedElectricityPrice_eurpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_fixedElectricityPrice_eurpkWh_xjal( double oldValue ) {  
  }


  public 
double  p_fixedHeatPrice_eurpkWh;

  /**
   * Returns default value for parameter <code>p_fixedHeatPrice_eurpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_fixedHeatPrice_eurpkWh_DefaultValue_xjal() {
    final EnergySupplier self = this;
    return 0.0;
  }

  public void set_p_fixedHeatPrice_eurpkWh( double value ) {
    if (value == this.p_fixedHeatPrice_eurpkWh) {
      return;
    }
    double _oldValue_xjal = this.p_fixedHeatPrice_eurpkWh;
    this.p_fixedHeatPrice_eurpkWh = value;
    onChange_p_fixedHeatPrice_eurpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_fixedHeatPrice_eurpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_fixedHeatPrice_eurpkWh()</code> method instead.
   */
  protected void onChange_p_fixedHeatPrice_eurpkWh() {
    onChange_p_fixedHeatPrice_eurpkWh_xjal( p_fixedHeatPrice_eurpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_fixedHeatPrice_eurpkWh_xjal( double oldValue ) {  
  }


  public 
double  p_fixedMethanePrice_eurpkWh;

  /**
   * Returns default value for parameter <code>p_fixedMethanePrice_eurpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_fixedMethanePrice_eurpkWh_DefaultValue_xjal() {
    final EnergySupplier self = this;
    return 0.0;
  }

  public void set_p_fixedMethanePrice_eurpkWh( double value ) {
    if (value == this.p_fixedMethanePrice_eurpkWh) {
      return;
    }
    double _oldValue_xjal = this.p_fixedMethanePrice_eurpkWh;
    this.p_fixedMethanePrice_eurpkWh = value;
    onChange_p_fixedMethanePrice_eurpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_fixedMethanePrice_eurpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_fixedMethanePrice_eurpkWh()</code> method instead.
   */
  protected void onChange_p_fixedMethanePrice_eurpkWh() {
    onChange_p_fixedMethanePrice_eurpkWh_xjal( p_fixedMethanePrice_eurpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_fixedMethanePrice_eurpkWh_xjal( double oldValue ) {  
  }


  public 
double  p_fixedHydrogenPrice_eurpkWh;

  /**
   * Returns default value for parameter <code>p_fixedHydrogenPrice_eurpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_fixedHydrogenPrice_eurpkWh_DefaultValue_xjal() {
    final EnergySupplier self = this;
    return 0.0;
  }

  public void set_p_fixedHydrogenPrice_eurpkWh( double value ) {
    if (value == this.p_fixedHydrogenPrice_eurpkWh) {
      return;
    }
    double _oldValue_xjal = this.p_fixedHydrogenPrice_eurpkWh;
    this.p_fixedHydrogenPrice_eurpkWh = value;
    onChange_p_fixedHydrogenPrice_eurpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_fixedHydrogenPrice_eurpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_fixedHydrogenPrice_eurpkWh()</code> method instead.
   */
  protected void onChange_p_fixedHydrogenPrice_eurpkWh() {
    onChange_p_fixedHydrogenPrice_eurpkWh_xjal( p_fixedHydrogenPrice_eurpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_fixedHydrogenPrice_eurpkWh_xjal( double oldValue ) {  
  }


  public 
double  p_variableElectricityPriceOverNational_eurpkWh;

  /**
   * Returns default value for parameter <code>p_variableElectricityPriceOverNational_eurpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_variableElectricityPriceOverNational_eurpkWh_DefaultValue_xjal() {
    final EnergySupplier self = this;
    return 0.0;
  }

  public void set_p_variableElectricityPriceOverNational_eurpkWh( double value ) {
    if (value == this.p_variableElectricityPriceOverNational_eurpkWh) {
      return;
    }
    double _oldValue_xjal = this.p_variableElectricityPriceOverNational_eurpkWh;
    this.p_variableElectricityPriceOverNational_eurpkWh = value;
    onChange_p_variableElectricityPriceOverNational_eurpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_variableElectricityPriceOverNational_eurpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_variableElectricityPriceOverNational_eurpkWh()</code> method instead.
   */
  protected void onChange_p_variableElectricityPriceOverNational_eurpkWh() {
    onChange_p_variableElectricityPriceOverNational_eurpkWh_xjal( p_variableElectricityPriceOverNational_eurpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_variableElectricityPriceOverNational_eurpkWh_xjal( double oldValue ) {  
  }


  public 
double  p_fixedFeedinTariff_eurpkWh;

  /**
   * Returns default value for parameter <code>p_fixedFeedinTariff_eurpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_fixedFeedinTariff_eurpkWh_DefaultValue_xjal() {
    final EnergySupplier self = this;
    return 0.0;
  }

  public void set_p_fixedFeedinTariff_eurpkWh( double value ) {
    if (value == this.p_fixedFeedinTariff_eurpkWh) {
      return;
    }
    double _oldValue_xjal = this.p_fixedFeedinTariff_eurpkWh;
    this.p_fixedFeedinTariff_eurpkWh = value;
    onChange_p_fixedFeedinTariff_eurpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_fixedFeedinTariff_eurpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_fixedFeedinTariff_eurpkWh()</code> method instead.
   */
  protected void onChange_p_fixedFeedinTariff_eurpkWh() {
    onChange_p_fixedFeedinTariff_eurpkWh_xjal( p_fixedFeedinTariff_eurpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_fixedFeedinTariff_eurpkWh_xjal( double oldValue ) {  
  }


  public 
boolean  p_salderenActive;

  /**
   * Returns default value for parameter <code>p_salderenActive</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _p_salderenActive_DefaultValue_xjal() {
    final EnergySupplier self = this;
    return false;
  }

  public void set_p_salderenActive( boolean value ) {
    if (value == this.p_salderenActive) {
      return;
    }
    boolean _oldValue_xjal = this.p_salderenActive;
    this.p_salderenActive = value;
    onChange_p_salderenActive_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_salderenActive.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_salderenActive()</code> method instead.
   */
  protected void onChange_p_salderenActive() {
    onChange_p_salderenActive_xjal( p_salderenActive );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_salderenActive_xjal( boolean oldValue ) {  
  }


  /**
   * Unique identifier of this actor in String format. Designated in Config-excel and used to link actors to netConnections.<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */

  /**
   * Actor type in OL_ActorType format. Designated in Config-excel and used to determine actor-type specific functionalities later.<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */

  /**
   * Actor type in OL_ActorType format. Designated in Config-excel and used to determine actor-type specific functionalities later.<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */

  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_fixedElectricityPrice_eurpkWh = _p_fixedElectricityPrice_eurpkWh_DefaultValue_xjal();
    p_fixedHeatPrice_eurpkWh = _p_fixedHeatPrice_eurpkWh_DefaultValue_xjal();
    p_fixedMethanePrice_eurpkWh = _p_fixedMethanePrice_eurpkWh_DefaultValue_xjal();
    p_fixedHydrogenPrice_eurpkWh = _p_fixedHydrogenPrice_eurpkWh_DefaultValue_xjal();
    p_variableElectricityPriceOverNational_eurpkWh = _p_variableElectricityPriceOverNational_eurpkWh_DefaultValue_xjal();
    p_fixedFeedinTariff_eurpkWh = _p_fixedFeedinTariff_eurpkWh_DefaultValue_xjal();
    p_salderenActive = _p_salderenActive_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_fixedElectricityPrice_eurpkWh":
      if ( _callOnChange_xjal ) {
        set_p_fixedElectricityPrice_eurpkWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_fixedElectricityPrice_eurpkWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_fixedHeatPrice_eurpkWh":
      if ( _callOnChange_xjal ) {
        set_p_fixedHeatPrice_eurpkWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_fixedHeatPrice_eurpkWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_fixedMethanePrice_eurpkWh":
      if ( _callOnChange_xjal ) {
        set_p_fixedMethanePrice_eurpkWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_fixedMethanePrice_eurpkWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_fixedHydrogenPrice_eurpkWh":
      if ( _callOnChange_xjal ) {
        set_p_fixedHydrogenPrice_eurpkWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_fixedHydrogenPrice_eurpkWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_variableElectricityPriceOverNational_eurpkWh":
      if ( _callOnChange_xjal ) {
        set_p_variableElectricityPriceOverNational_eurpkWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_variableElectricityPriceOverNational_eurpkWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_fixedFeedinTariff_eurpkWh":
      if ( _callOnChange_xjal ) {
        set_p_fixedFeedinTariff_eurpkWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_fixedFeedinTariff_eurpkWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_salderenActive":
      if ( _callOnChange_xjal ) {
        set_p_salderenActive( (Boolean) _value_xjal );
      } else {
        p_salderenActive = (Boolean) _value_xjal;
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
    case "p_fixedElectricityPrice_eurpkWh": _result_xjal = p_fixedElectricityPrice_eurpkWh; break;
    case "p_fixedHeatPrice_eurpkWh": _result_xjal = p_fixedHeatPrice_eurpkWh; break;
    case "p_fixedMethanePrice_eurpkWh": _result_xjal = p_fixedMethanePrice_eurpkWh; break;
    case "p_fixedHydrogenPrice_eurpkWh": _result_xjal = p_fixedHydrogenPrice_eurpkWh; break;
    case "p_variableElectricityPriceOverNational_eurpkWh": _result_xjal = p_variableElectricityPriceOverNational_eurpkWh; break;
    case "p_fixedFeedinTariff_eurpkWh": _result_xjal = p_fixedFeedinTariff_eurpkWh; break;
    case "p_salderenActive": _result_xjal = p_salderenActive; break;
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
      list.add( "p_fixedElectricityPrice_eurpkWh" );
      list.add( "p_fixedHeatPrice_eurpkWh" );
      list.add( "p_fixedMethanePrice_eurpkWh" );
      list.add( "p_fixedHydrogenPrice_eurpkWh" );
      list.add( "p_variableElectricityPriceOverNational_eurpkWh" );
      list.add( "p_fixedFeedinTariff_eurpkWh" );
      list.add( "p_salderenActive" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
double 
 v_currentVariableElectricityPrice_eurpkWh;
  /**
   * Bank account balance for electricity traded with clients.<br>
   * <br>
   * @author: Jorrit<br>
   * @since: Sprint 6
   */
  public 
double 
 v_currentBalanceElectricityClients_eur;
  /**
   * Bank account balance for heat traded with clients.<br>
   * <br>
   * @author: Jorrit<br>
   * @since: Sprint 6
   */
  public 
double 
 v_currentBalanceHeatClients_eur;
  /**
   * Bank account balance for methane<br>
   * @author: Jorrit<br>
   * @since: Sprint 6
   */
  public 
double 
 v_currentBalanceMethaneClients_eur;
  /**
   * Bank account balance for hydrogen traded with clients.<br>
   * <br>
   * @author: Jorrit<br>
   * @since: Sprint 6
   */
  public 
double 
 v_currentBalanceHydrogenClients_eur;
  public 
J_ActorData 
 j_ActorData;
  /**
   * Bank account balance for all energy carriers traded with clients.<br>
   * <br>
   * @author: Gillis<br>
   * @since: Sprint 6
   */
  public 
double 
 v_currentBalanceClients_eur;
  public 
double 
 v_totalElectricitySoldToClients_kWh;
  public 
double 
 v_totalElectricityBoughtFromClients_kWh;
  public 
double 
 v_currentBalanceNat_eur;
  public 
double 
 v_totalElectricitySoldToNat_kWh;
  public 
double 
 v_totalElectricityBoughtFromNat_kWh;
  public 
double 
 v_currentNettElectricityVolume_kWh;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( EnergySupplier.class );

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
  protected static final int _STATECHART_COUNT_xjal = zero_engine.Actor._STATECHART_COUNT_xjal + 0;


  // Functions

  public void f_connectToChild( Agent ConnectingChildNode ) { 

subConnections.connectTo(ConnectingChildNode);
 
  }

  public 
double 
 f_doEnergyTransaction( double transactionVolume_kWh, OL_ContractType contractType ) { 

double transactionCostClient_eur = 0;
double transactionCostNat_eur = 0;
/*switch (contractType) {
	case ELECTRICITY_FIXED:
			transactionCostClient_eur = transactionVolume_kWh * p_fixedElectricityPrice_eurpkWh;
			transactionCostNat_eur = - transactionVolume_kWh * v_currentVariableElectricityPrice_eurpkWh;
			v_totalElectricitySoldToClients_kWh += max(0,transactionVolume_kWh);
			v_totalElectricityBoughtFromClients_kWh -= min(0,transactionVolume_kWh);
			v_currentNettElectricityVolume_kWh += transactionVolume_kWh;
			v_currentBalanceElectricityClients_eur += transactionCostClient_eur;
		break;
	case ELECTRICITY_VARIABLE:
			transactionCostClient_eur = transactionVolume_kWh * (p_variableElectricityPriceOverNational_eurpkWh + v_currentVariableElectricityPrice_eurpkWh);
			transactionCostNat_eur = - transactionVolume_kWh * v_currentVariableElectricityPrice_eurpkWh;
			v_currentBalanceElectricityClients_eur += transactionCostClient_eur;
		break;
	case HEAT_FIXED:
			transactionCostClient_eur = transactionVolume_kWh * p_fixedHeatPrice_eurpkWh;
			transactionCostNat_eur = - transactionVolume_kWh * 0;
			v_currentBalanceHeatClients_eur += transactionCostClient_eur;
		break;
	case METHANE_FIXED:
			transactionCostClient_eur = transactionVolume_kWh * p_fixedMethanePrice_eurpkWh;
			transactionCostNat_eur = - transactionVolume_kWh * 0;
			v_currentBalanceMethaneClients_eur += transactionCostClient_eur;
		break;
	case HYDROGEN_FIXED:
			transactionCostClient_eur = transactionVolume_kWh * p_fixedHydrogenPrice_eurpkWh;
			transactionCostNat_eur = - transactionVolume_kWh * 0;
			v_currentBalanceHydrogenClients_eur += transactionCostClient_eur;
		break;
	default:
		throw new IllegalStateException("Invalid contract type: " + contractType);
}*/
v_currentBalanceClients_eur += transactionCostClient_eur;
return transactionCostClient_eur; 
  }

  public 
double 
 f_getVariableEnergyPrice(  ) { 

return v_currentVariableElectricityPrice_eurpkWh; 
  }

  public void f_updateEnergyPrice(  ) { 

v_currentVariableElectricityPrice_eurpkWh = energyModel.nationalEnergyMarket.f_getNationalElectricityPrice_eurpMWh()/1000;
v_currentNettElectricityVolume_kWh = 0; 
  }

  public void f_updateFinances(  ) { 

v_totalElectricityBoughtFromNat_kWh += max(0,v_currentNettElectricityVolume_kWh);
v_totalElectricitySoldToNat_kWh -= min(0,v_currentNettElectricityVolume_kWh);
v_currentBalanceNat_eur -= v_currentNettElectricityVolume_kWh * v_currentVariableElectricityPrice_eurpkWh; 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text6_Font = _text4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _text4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = _text4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _line4 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _line5 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _text6 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _line6 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 8;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 9;

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
	  level.addAll(line4, text4, line5, text6, line6, text5, line1, text1);
  }

  protected ShapeLine line4;
  protected ShapeText text4;
  protected ShapeLine line5;
  protected ShapeText text6;
  protected ShapeLine line6;
  protected ShapeText text5;
  protected ShapeLine line1;
  protected ShapeText text1;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    line4 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 770.0, 40.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text4 = new ShapeText(
        SHAPE_DRAW_2D, true,820.0, 20.0, 0.0, 0.0,
        black,"Functions",
        _text4_Font, ALIGNMENT_LEFT );
    line5 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 760.0, 60.0, 0.0, black,
 		0.0,	40.0, 0.0, 1.0, 10.0, LINE_STYLE_DOTTED );
    text6 = new ShapeText(
        SHAPE_DRAW_2D, true,740.0, 190.0, 0.0, 4.71238898038469,
        black,"Occuring",
        _text6_Font, ALIGNMENT_LEFT );
    line6 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 760.0, 130.0, 0.0, black,
 		0.0,	80.0, 0.0, 1.0, 10.0, LINE_STYLE_DOTTED );
    text5 = new ShapeText(
        SHAPE_DRAW_2D, true,740.0, 90.0, 0.0, 4.71238898038469,
        black,"Init",
        _text5_Font, ALIGNMENT_LEFT );
    line1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 290.0, 40.0, 0.0, black,
 		240.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,380.0, 20.0, 0.0, 0.0,
        black,"Fixed tariffs",
        _text1_Font, ALIGNMENT_LEFT );
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
  public EnergySupplier( Engine engine, Agent owner, AgentList<? extends EnergySupplier> ownerPopulation ) {
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
  public EnergySupplier() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public EnergySupplier( String p_actorID, String p_actorGroup, String p_actorSubgroup, double p_fixedElectricityPrice_eurpkWh, double p_fixedHeatPrice_eurpkWh, double p_fixedMethanePrice_eurpkWh, double p_fixedHydrogenPrice_eurpkWh, double p_variableElectricityPriceOverNational_eurpkWh, double p_fixedFeedinTariff_eurpkWh, boolean p_salderenActive ) {
    super( p_actorID, p_actorGroup, p_actorSubgroup );
    this.p_fixedElectricityPrice_eurpkWh = p_fixedElectricityPrice_eurpkWh;
    this.p_fixedHeatPrice_eurpkWh = p_fixedHeatPrice_eurpkWh;
    this.p_fixedMethanePrice_eurpkWh = p_fixedMethanePrice_eurpkWh;
    this.p_fixedHydrogenPrice_eurpkWh = p_fixedHydrogenPrice_eurpkWh;
    this.p_variableElectricityPriceOverNational_eurpkWh = p_variableElectricityPriceOverNational_eurpkWh;
    this.p_fixedFeedinTariff_eurpkWh = p_fixedFeedinTariff_eurpkWh;
    this.p_salderenActive = p_salderenActive;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_EnergySupplier_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "zero_engine.EnergySupplier.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( EnergySupplier.class );
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
    setupPlainVariables_EnergySupplier_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_EnergySupplier_xjal() {
    v_currentBalanceClients_eur = 
0 
;
    v_totalElectricitySoldToClients_kWh = 
0 
;
    v_totalElectricityBoughtFromClients_kWh = 
0 
;
    v_currentBalanceNat_eur = 
0 
;
    v_totalElectricitySoldToNat_kWh = 
0 
;
    v_totalElectricityBoughtFromNat_kWh = 
0 
;
    v_currentNettElectricityVolume_kWh = 
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

  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _superConnection_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> superConnection = new LinkToAgentCollectionImpl<Agent, Agent>(this, _superConnection_commonAnimationSettings_xjal);

  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _subConnections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> subConnections = new LinkToAgentCollectionImpl<Agent, Agent>(this, _subConnections_commonAnimationSettings_xjal);


  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, superConnection, false, false );
    }
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, subConnections, false, false );
    }
  }

  public AgentList<? extends EnergySupplier> getPopulation() {
    return (AgentList<? extends EnergySupplier>) super.getPopulation();
  }

  public List<? extends EnergySupplier> agentsInRange( double distance ) {
    return (List<? extends EnergySupplier>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    superConnection.onDestroy();
    subConnections.onDestroy();
    super.onDestroy();
  }


}
