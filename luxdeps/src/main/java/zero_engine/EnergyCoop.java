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

import zeroPackage.ZeroMath;
//import zeroPackage.ZeroAccumulator;

import java.util.EnumSet;

/*
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
*/
//@JsonIgnoreProperties({"va_coop"})
//@JsonIgnoreProperties({"_origin_VA"})
 

public class EnergyCoop extends zero_engine.Actor
        implements 
I_EnergyData 
{
  // Parameters

  public 
com.fasterxml.jackson.databind.node.ArrayNode  p_actorContractList;

  /**
   * Returns default value for parameter <code>p_actorContractList</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public com.fasterxml.jackson.databind.node.ArrayNode _p_actorContractList_DefaultValue_xjal() {
    final EnergyCoop self = this;
    return null;
  }

  public void set_p_actorContractList( com.fasterxml.jackson.databind.node.ArrayNode value ) {
    if (value == this.p_actorContractList) {
      return;
    }
    com.fasterxml.jackson.databind.node.ArrayNode _oldValue_xjal = this.p_actorContractList;
    this.p_actorContractList = value;
    onChange_p_actorContractList_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_actorContractList.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_actorContractList()</code> method instead.
   */
  protected void onChange_p_actorContractList() {
    onChange_p_actorContractList_xjal( p_actorContractList );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_actorContractList_xjal( com.fasterxml.jackson.databind.node.ArrayNode oldValue ) {  
  }


  /**
   * Pointer of the designated parent actor (e.g. a Coop or energy supplier)<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */
  public 
Actor  p_electricitySupplier;

  /**
   * Returns default value for parameter <code>p_electricitySupplier</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Actor _p_electricitySupplier_DefaultValue_xjal() {
    final EnergyCoop self = this;
    return null;
  }

  public void set_p_electricitySupplier( Actor value ) {
    if (value == this.p_electricitySupplier) {
      return;
    }
    Actor _oldValue_xjal = this.p_electricitySupplier;
    this.p_electricitySupplier = value;
    onChange_p_electricitySupplier_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_electricitySupplier.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_electricitySupplier()</code> method instead.
   */
  protected void onChange_p_electricitySupplier() {
    onChange_p_electricitySupplier_xjal( p_electricitySupplier );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_electricitySupplier_xjal( Actor oldValue ) {  
  }


  public 
Actor  p_CoopParent;

  /**
   * Returns default value for parameter <code>p_CoopParent</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Actor _p_CoopParent_DefaultValue_xjal() {
    final EnergyCoop self = this;
    return 
null 
;
  }

  public void set_p_CoopParent( Actor value ) {
    if (value == this.p_CoopParent) {
      return;
    }
    Actor _oldValue_xjal = this.p_CoopParent;
    this.p_CoopParent = value;
    onChange_p_CoopParent_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_CoopParent.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_CoopParent()</code> method instead.
   */
  protected void onChange_p_CoopParent() {
    onChange_p_CoopParent_xjal( p_CoopParent );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_CoopParent_xjal( Actor oldValue ) {  
  }


  public 
Actor  p_gridOperator;

  /**
   * Returns default value for parameter <code>p_gridOperator</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Actor _p_gridOperator_DefaultValue_xjal() {
    final EnergyCoop self = this;
    return null;
  }

  public void set_p_gridOperator( Actor value ) {
    if (value == this.p_gridOperator) {
      return;
    }
    Actor _oldValue_xjal = this.p_gridOperator;
    this.p_gridOperator = value;
    onChange_p_gridOperator_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_gridOperator.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_gridOperator()</code> method instead.
   */
  protected void onChange_p_gridOperator() {
    onChange_p_gridOperator_xjal( p_gridOperator );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_gridOperator_xjal( Actor oldValue ) {  
  }


  /**
   * Pointer of the designated parent actor (e.g. a Coop or energy supplier)<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */
  public 
Actor  p_methaneSupplier;

  /**
   * Returns default value for parameter <code>p_methaneSupplier</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Actor _p_methaneSupplier_DefaultValue_xjal() {
    final EnergyCoop self = this;
    return null;
  }

  public void set_p_methaneSupplier( Actor value ) {
    if (value == this.p_methaneSupplier) {
      return;
    }
    Actor _oldValue_xjal = this.p_methaneSupplier;
    this.p_methaneSupplier = value;
    onChange_p_methaneSupplier_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_methaneSupplier.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_methaneSupplier()</code> method instead.
   */
  protected void onChange_p_methaneSupplier() {
    onChange_p_methaneSupplier_xjal( p_methaneSupplier );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_methaneSupplier_xjal( Actor oldValue ) {  
  }


  /**
   * Pointer of the designated parent actor (e.g. a Coop or energy supplier)<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */
  public 
Actor  p_hydrogenSupplier;

  /**
   * Returns default value for parameter <code>p_hydrogenSupplier</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Actor _p_hydrogenSupplier_DefaultValue_xjal() {
    final EnergyCoop self = this;
    return null;
  }

  public void set_p_hydrogenSupplier( Actor value ) {
    if (value == this.p_hydrogenSupplier) {
      return;
    }
    Actor _oldValue_xjal = this.p_hydrogenSupplier;
    this.p_hydrogenSupplier = value;
    onChange_p_hydrogenSupplier_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_hydrogenSupplier.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_hydrogenSupplier()</code> method instead.
   */
  protected void onChange_p_hydrogenSupplier() {
    onChange_p_hydrogenSupplier_xjal( p_hydrogenSupplier );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_hydrogenSupplier_xjal( Actor oldValue ) {  
  }


  /**
   * Pointer of the designated parent actor (e.g. a Coop or energy supplier)<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */
  public 
Actor  p_heatSupplier;

  /**
   * Returns default value for parameter <code>p_heatSupplier</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Actor _p_heatSupplier_DefaultValue_xjal() {
    final EnergyCoop self = this;
    return null;
  }

  public void set_p_heatSupplier( Actor value ) {
    if (value == this.p_heatSupplier) {
      return;
    }
    Actor _oldValue_xjal = this.p_heatSupplier;
    this.p_heatSupplier = value;
    onChange_p_heatSupplier_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_heatSupplier.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_heatSupplier()</code> method instead.
   */
  protected void onChange_p_heatSupplier() {
    onChange_p_heatSupplier_xjal( p_heatSupplier );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_heatSupplier_xjal( Actor oldValue ) {  
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
    p_actorContractList = _p_actorContractList_DefaultValue_xjal();
    p_electricitySupplier = _p_electricitySupplier_DefaultValue_xjal();
    p_CoopParent = _p_CoopParent_DefaultValue_xjal();
    p_gridOperator = _p_gridOperator_DefaultValue_xjal();
    p_methaneSupplier = _p_methaneSupplier_DefaultValue_xjal();
    p_hydrogenSupplier = _p_hydrogenSupplier_DefaultValue_xjal();
    p_heatSupplier = _p_heatSupplier_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_actorContractList":
      if ( _callOnChange_xjal ) {
        set_p_actorContractList( (com.fasterxml.jackson.databind.node.ArrayNode) _value_xjal );
      } else {
        p_actorContractList = (com.fasterxml.jackson.databind.node.ArrayNode) _value_xjal;
      }
      return true;
    case "p_electricitySupplier":
      if ( _callOnChange_xjal ) {
        set_p_electricitySupplier( (Actor) _value_xjal );
      } else {
        p_electricitySupplier = (Actor) _value_xjal;
      }
      return true;
    case "p_CoopParent":
      if ( _callOnChange_xjal ) {
        set_p_CoopParent( (Actor) _value_xjal );
      } else {
        p_CoopParent = (Actor) _value_xjal;
      }
      return true;
    case "p_gridOperator":
      if ( _callOnChange_xjal ) {
        set_p_gridOperator( (Actor) _value_xjal );
      } else {
        p_gridOperator = (Actor) _value_xjal;
      }
      return true;
    case "p_methaneSupplier":
      if ( _callOnChange_xjal ) {
        set_p_methaneSupplier( (Actor) _value_xjal );
      } else {
        p_methaneSupplier = (Actor) _value_xjal;
      }
      return true;
    case "p_hydrogenSupplier":
      if ( _callOnChange_xjal ) {
        set_p_hydrogenSupplier( (Actor) _value_xjal );
      } else {
        p_hydrogenSupplier = (Actor) _value_xjal;
      }
      return true;
    case "p_heatSupplier":
      if ( _callOnChange_xjal ) {
        set_p_heatSupplier( (Actor) _value_xjal );
      } else {
        p_heatSupplier = (Actor) _value_xjal;
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
    case "p_actorContractList": _result_xjal = p_actorContractList; break;
    case "p_electricitySupplier": _result_xjal = p_electricitySupplier; break;
    case "p_CoopParent": _result_xjal = p_CoopParent; break;
    case "p_gridOperator": _result_xjal = p_gridOperator; break;
    case "p_methaneSupplier": _result_xjal = p_methaneSupplier; break;
    case "p_hydrogenSupplier": _result_xjal = p_hydrogenSupplier; break;
    case "p_heatSupplier": _result_xjal = p_heatSupplier; break;
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
      list.add( "p_actorContractList" );
      list.add( "p_electricitySupplier" );
      list.add( "p_CoopParent" );
      list.add( "p_gridOperator" );
      list.add( "p_methaneSupplier" );
      list.add( "p_hydrogenSupplier" );
      list.add( "p_heatSupplier" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
Double 
 v_allowedCapacity_kW;
  public 
J_ActorData 
 j_ActorData;
  public 
J_DeliveryContract 
 v_contractDelivery;
  public 
J_TransportContract 
 v_contractTransport;
  public 
J_TaxContract 
 v_contractTax;
  public 
J_ConnectionContract 
 v_contractConnection;
  public 
double 
 v_electricityVariablePrice_eurpkWh;
  public 
double 
 v_methanePrice_eurpkWh;
  public 
double 
 v_hydrogenPrice_eurpkWh;
  public 
double 
 v_heatPrice_eurpkWh;
  public 
double 
 v_lowPassFactor_fr;
  public 
double 
 v_currentEnergyCurtailed_kW;
  public 
double 
 v_currentOwnElectricityProduction_kW;
  public 
ZeroAccumulator 
 acc_totalOwnElectricityProduction_kW;
  public 
double 
 v_currentCustomerFeedIn_kW;
  public 
ZeroAccumulator 
 acc_totalCustomerFeedIn_kW;
  public 
J_FlowsMap 
 fm_currentConsumptionFlows_kW;
  public 
J_FlowsMap 
 fm_currentProductionFlows_kW;
  public 
J_FlowsMap 
 fm_currentBalanceFlows_kW;
  public 
double 
 v_currentPrimaryEnergyProduction_kW;
  public 
double 
 v_currentFinalEnergyConsumption_kW;
  public 
double 
 v_currentPrimaryEnergyProductionHeatpumps_kW;
  public 
ZeroAccumulator 
 acc_totalCustomerDelivery_kW;
  public 
double 
 v_currentCustomerDelivery_kW;
  public 
double 
 v_totalCustomerFeedIn_MWh;
  public 
double 
 v_totalCustomerDelivery_MWh;
  public 
double 
 v_totalOwnElectricityProduction_MWh;
  public 
double 
 v_cumulativeIndividualSelfconsumptionElectricity_fr;
  public 
double 
 v_cumulativeIndividualSelfconsumptionEnergy_fr;
  public 
double 
 v_cumulativeIndividualSelfSufficiencyElectricity_fr;
  public 
double 
 v_cumulativeIndividualSelfSufficiencyEnergy_fr;
  public 
double 
 v_cumulativeIndividualSelfconsumptionElectricity_MWh;
  public 
double 
 v_cumulativeIndividualSelfconsumptionEnergy_MWh;
  public 
double 
 v_cumulativeIndividualPeakFeedin_kW;
  public 
double 
 v_cumulativeIndividualPeakDelivery_kW;
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
double 
 v_batteryStoredEnergy_kWh;
  public 
J_RapidRunData 
 v_originalRapidRunData;
  public 
double 
 v_cumulativeIndividualPeakFeedinOriginal_kW;
  public 
double 
 v_cumulativeIndividualPeakDeliveryOriginal_kW;
  public 
J_FlowsMap 
 fm_consumptionForHeating_kW;
  public 
J_FlowsMap 
 fm_heatFromEnergyCarrier_kW;
  /**
   * Is variable to be able to make it private, but functions as a parameter -> doesnt change during rapid run.
   */
  private 
I_AggregatorEnergyManagement 
 p_aggregatorEnergyManagement;
  public 
double 
 v_electricitySurplus_kW;
  public 
double 
 v_balanceElectricityDelivery_eur;
  public 
double 
 v_balanceElectricityTransport_eur;
  public 
double 
 v_balanceElectricityTax_eur;
  public 
double 
 v_currentNodalPrice_eurpkWh;
  public 
double 
 v_balanceElectricity_eur;
  public 
double 
 v_electricitySurplusLowPassed_kW;
  public 
J_RapidRunData 
 v_previousRunData;

  // Collection Variables
  public 
ArrayList <
J_Contract > c_actorContracts = new ArrayList<J_Contract>();
  
ArrayList <
Actor > c_coopMembers = new ArrayList<Actor>();
  
ArrayList <
Actor > c_coopCustomers = new ArrayList<Actor>();
  private 
ArrayList <
GridConnection > c_memberGridConnections = new ArrayList<GridConnection>();
  private 
ArrayList <
GridConnection > c_customerGridConnections = new ArrayList<GridConnection>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( EnergyCoop.class );

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

  void f_connectToChild( Actor ConnectingChildActor, OL_EnergyCarriers EnergyCarrier ) { 

/*switch( EnergyCarrier ) {
		case ELECTRICITY:
			subConnectionsElectricity.connectTo(ConnectingChildNode);
		break;
		case METHANE:
			subConnectionsMethane.connectTo(ConnectingChildNode);
		break;
		case HYDROGEN:
			subConnectionsHydrogen.connectTo(ConnectingChildNode);
		break;
		case HEAT:
			subConnectionsHeat.connectTo(ConnectingChildNode);
		break;
		default:
				
		break;		
}*/
if (ConnectingChildActor.p_actorGroup != null) {
	if (ConnectingChildActor.p_actorGroup.contains("production") || ConnectingChildActor.p_actorGroup.contains("Production") || ConnectingChildActor.p_actorGroup.contains("member")) { // Count owned production-sites as 'behind the meter'
		c_coopMembers.add( ConnectingChildActor);
		c_memberGridConnections.addAll(((ConnectionOwner)ConnectingChildActor).c_ownedGridConnections);
		(((ConnectionOwner)ConnectingChildActor).c_ownedGridConnections).forEach( gc -> gc.c_parentCoops.add(this));
		//traceln("Adding: %s", ((ConnectionOwner)ConnectingChildActor).c_ownedGridConnections);
	} else {
		c_coopCustomers.add( ConnectingChildActor );
		c_customerGridConnections.addAll(((ConnectionOwner)ConnectingChildActor).c_ownedGridConnections);
	}
} else {
	c_coopCustomers.add( ConnectingChildActor );
	c_customerGridConnections.addAll(((ConnectionOwner)ConnectingChildActor).c_ownedGridConnections);
	//traceln("Adding: %s", ((ConnectionOwner)ConnectingChildActor).c_ownedGridConnections);
}

/*
if ( v_contractGridOperator.equals("NODALPRICING")) {
//	traceln("Enabling nodal pricing for Coop memmber!");
	if (ConnectingChildNode instanceof ConnectionOwner) {
		//((ConnectionOwner)ConnectingChildNode).v_contractGridOperator = v_contractGridOperator;
		((ConnectionOwner)ConnectingChildNode).v_congestionTariff_b = true;
	}
}
if ( v_contractEnergySupplier.equals("VARIABLE")) {
	if (ConnectingChildNode instanceof ConnectionOwner) {
		((ConnectionOwner)ConnectingChildNode).v_electricityContractType = OL_DeliveryContractType.ELECTRICITY_VARIABLE;
		//((ConnectionOwner)ConnectingChildNode).v_contractEnergySupplier= v_contractEnergySupplier;
		//((ConnectionOwner)ConnectingChildNode).v_updatePriceBands_b = true;
	}
}
*/ 
  }

  /**
   * Creates an agentLink in superConnection if a parentActorID is designated in the config-excel. Called from f_configureBackBone() in main for profiling reasons, so no parameters are given.<br>
   * <br>
   * @param: none<br>
   * @return: none<br>
   * @since: Sprint 6<br>
   * @author: HOUJ
   */
  void f_connectToParentActor(  ) { 

Actor mySupplier = null;
mySupplier = findFirst(energyModel.pop_energySuppliers, p->p.p_actorID.equals(v_contractDelivery.contractScope)) ;
if (mySupplier != null) {
	((EnergySupplier)mySupplier).f_connectToChild(this);	
} else {
	mySupplier = findFirst(energyModel.pop_energyCoops, p->p.p_actorID.equals(v_contractDelivery.contractScope)) ;
	if (mySupplier != null) {
		((EnergyCoop)mySupplier).f_connectToChild(this,OL_EnergyCarriers.ELECTRICITY);	
	}
}

if (mySupplier != null) {
	p_electricitySupplier = mySupplier;
} 
else { 
	p_electricitySupplier = energyModel.pop_energySuppliers.get(0);  // this is a harcoded fix to make the buurtmodel run for 21-3-2023
	traceln("Connection owner %s --> f_connectToParentActor --> no parent actor %s found, this should not be happening", this, v_contractDelivery.contractScope);
}

Actor myGridoperator = null;
// Connect to grid operator (can be a Coop!)
myGridoperator = findFirst(energyModel.pop_gridOperators, p->p.p_actorID.equals(v_contractTransport.contractScope)) ;
if (myGridoperator == null) {
	myGridoperator = findFirst(energyModel.pop_energyCoops, p->p.p_actorID.equals(v_contractTransport.contractScope)) ;
}

if (myGridoperator != null) {
	p_gridOperator = myGridoperator;	
} else { 
	//p_gridOperator = main.pop_gridOperators.get( 0 ) ; // this is a harcoded fix to make the buurtmodel run for 21-3-2023
	traceln("Connection owner --> f_connectToParentActor --> no parent actor found, this should not be happening");
}
 
  }

  void f_calculateEnergyBalance( J_TimeVariables timeVariables, boolean isRapidRun ) { 

v_currentOwnElectricityProduction_kW = 0; // Only electricity production from 'members' as opposed to 'customers'.
v_currentCustomerFeedIn_kW = 0; // Feedin from customers (self-consumption behind-the-meter is not counted for customers)
v_currentCustomerDelivery_kW = 0; // Delivery to customers (self-consumption behind-the-meter is not counted for customers)

fm_currentProductionFlows_kW.clear();
fm_currentConsumptionFlows_kW.clear();
fm_currentBalanceFlows_kW.clear();
fm_currentAssetFlows_kW.clear();
fm_heatFromEnergyCarrier_kW.clear();
fm_consumptionForHeating_kW.clear();
v_currentPrimaryEnergyProduction_kW = 0;
v_currentFinalEnergyConsumption_kW = 0;
v_currentEnergyCurtailed_kW = 0;
v_batteryStoredEnergy_kWh = 0;
v_currentPrimaryEnergyProductionHeatpumps_kW = 0;


for(GridConnection gc : c_memberGridConnections) { // Can't do this in parallel due to different threads writing to the same values!
	if(gc.v_isActive){
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
		v_currentOwnElectricityProduction_kW += gc.fm_currentProductionFlows_kW.get(OL_EnergyCarriers.ELECTRICITY);	
	}
}

// gather electricity flows
for(Agent a :  c_coopMembers ) { // Take 'behind the meter' production and consumption!
	if (a instanceof EnergyCoop) {
		EnergyCoop EC = (EnergyCoop)a;
		
		fm_currentBalanceFlows_kW.addFlows(EC.fm_currentBalanceFlows_kW);
		fm_currentProductionFlows_kW.addFlows(EC.fm_currentProductionFlows_kW);
		fm_currentConsumptionFlows_kW.addFlows(EC.fm_currentConsumptionFlows_kW);
		fm_heatFromEnergyCarrier_kW.addFlows(EC.fm_heatFromEnergyCarrier_kW);
		fm_consumptionForHeating_kW.addFlows(EC.fm_consumptionForHeating_kW);
		fm_currentAssetFlows_kW.addFlows(EC.fm_currentAssetFlows_kW);
		v_currentPrimaryEnergyProduction_kW += EC.v_currentPrimaryEnergyProduction_kW;
		v_currentFinalEnergyConsumption_kW += EC.v_currentFinalEnergyConsumption_kW;
		v_currentEnergyCurtailed_kW += EC.v_currentEnergyCurtailed_kW;
		v_batteryStoredEnergy_kWh += EC.v_batteryStoredEnergy_kWh;
		v_currentPrimaryEnergyProductionHeatpumps_kW += EC.v_currentPrimaryEnergyProductionHeatpumps_kW;
		v_currentOwnElectricityProduction_kW += EC.fm_currentProductionFlows_kW.get(OL_EnergyCarriers.ELECTRICITY); 
	}
}

for (GridConnection GC : c_customerGridConnections) { // Don't look at 'behind the meter' production/consumption, but use 'nett flow' as measure of consumption/production
	if(GC.v_isActive){
		for (OL_EnergyCarriers energyCarrier : v_liveData.activeEnergyCarriers) {
			double nettConsumption_kW = GC.fm_currentBalanceFlows_kW.get(energyCarrier);
			fm_currentProductionFlows_kW.addFlow( energyCarrier, max(0, -nettConsumption_kW));
			fm_currentConsumptionFlows_kW.addFlow( energyCarrier, max(0, nettConsumption_kW));
			fm_currentBalanceFlows_kW.addFlow( energyCarrier, nettConsumption_kW);
			
			if (energyCarrier == OL_EnergyCarriers.ELECTRICITY) {
				v_currentCustomerFeedIn_kW += max(0,-nettConsumption_kW);
				v_currentCustomerDelivery_kW += max(0,nettConsumption_kW);
			}
		}
	}				
}

for(Agent a :  c_coopCustomers ) { // Don't look at 'behind the meter' production/consumption, but use 'nett flow' as measure of consumption/production
	if (a instanceof EnergyCoop) {
		EnergyCoop EC = (EnergyCoop)a;
				
		fm_currentBalanceFlows_kW.addFlows(EC.fm_currentBalanceFlows_kW);
		fm_currentProductionFlows_kW.addFlows(EC.fm_currentProductionFlows_kW);
		fm_currentConsumptionFlows_kW.addFlows(EC.fm_currentConsumptionFlows_kW);
		fm_currentAssetFlows_kW.addFlows(EC.fm_currentAssetFlows_kW);
		v_currentCustomerFeedIn_kW += EC.v_currentCustomerFeedIn_kW;
		v_currentCustomerDelivery_kW += EC.v_currentCustomerDelivery_kW;
	}
}

v_electricitySurplus_kW = -fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY);

//Coop update data classes
if (isRapidRun){
	f_rapidRunDataLogging(timeVariables);
} else {
	f_updateLiveDataSets(timeVariables);
} 
  }

  /**
   * v_currentNodalPrice_eurpkWh = node van deze Coop -> p_gridNodeUnderResponsibility. Mogelijk niet robuust! TODO: checken of dit goed gaat!
   */
  
double 
 f_getVariableEnergyPrice(  ) { 

double energyPrice_eurpkWh = v_electricityVariablePrice_eurpkWh + v_contractDelivery.deliveryPrice_eurpkWh;

if ( v_contractTransport.transportContractType==OL_TransportContractType.NODALPRICING) {
	energyPrice_eurpkWh += v_currentNodalPrice_eurpkWh;
} 

//traceln("Coop received energy price of: " + energyPrice_eurpkWh + " eur/kWh");
return energyPrice_eurpkWh; 
  }

  void f_setContractValues(  ) { 

if( p_actorContractList != null) {
	//traceln("Contract list connectionOwner " + p_actorID + ": " + p_actorContractList.toString());
} else {
	traceln( "No contract data for connectionOwner " + p_actorID );
}

double methaneDeliveryPrice_eurpkWh = 0.0;
double methaneDeliveryTax_eurpkWh = 0.0;
double methaneVAT_pct = 0.0;
double hydrogenDeliveryPrice_eurpkWh = 0.0;
double hydrogenDeliveryTax_eurpkWh = 0.0;
double hydrogenVAT_pct = 0.0;
double heatDeliveryPrice_eurpkWh = 0.0;
double heatDeliveryTax_eurpkWh = 0.0;
double heatVAT_pct = 0.0;

for( JsonNode contractJson : p_actorContractList) {
	//traceln("Contract hashmap l: " + l);
	OL_ContractType contractService = OL_ContractType.valueOf(contractJson.required("contractType").textValue());
	String contractScope = contractJson.required( "contractScope" ).textValue();
	OL_EnergyCarriers energyCarrier = OL_EnergyCarriers.valueOf(contractJson.required("energyCarrier").textValue());
	double annualFee_eur = contractJson.required("annualFee_eur").doubleValue();
	Actor mySupplier = null;
	if (energyCarrier.equals(OL_EnergyCarriers.ELECTRICITY)){
		switch( contractService ) {
			case DELIVERY:
				//String contractScope = (String)l.get( "contract_scope" );
				OL_DeliveryContractType deliveryContractType = OL_DeliveryContractType.valueOf(contractJson.get("deliveryContractType").textValue());
				double deliveryPrice_eurpkWh = contractJson.required("deliveryPrice_eurpkWh").doubleValue();
				double feedinPrice_eurpkWh = contractJson.required("feedinPrice_eurpkWh").doubleValue();
				v_contractDelivery = new J_DeliveryContract(contractScope, deliveryContractType, OL_EnergyCarriers.ELECTRICITY, deliveryPrice_eurpkWh, feedinPrice_eurpkWh, annualFee_eur);
				//traceln("Delivery contract: " + v_contractDelivery);
				c_actorContracts.add(v_contractDelivery);
			break;
			case TRANSPORT:
				OL_TransportContractType transportContractType = OL_TransportContractType.valueOf(contractJson.get("transportContractType").textValue());
				double bandwidthTreshold_kW = contractJson.path("bandwidthTreshold_kW").doubleValue();
				double bandwidthTariff_eurpkWh = contractJson.path("bandwidthTariff_eurpkWh").doubleValue();
				v_contractTransport = new J_TransportContract(contractScope, transportContractType, energyCarrier, bandwidthTreshold_kW, bandwidthTariff_eurpkWh, annualFee_eur);			
				c_actorContracts.add(v_contractTransport);
			break;
			case CONNECTION:
				OL_ConnectionContractType connectionContractType = OL_ConnectionContractType.valueOf(contractJson.required("connectionContractType").textValue());
				//traceln("Initializing connection contract with ConnectionContractType: " + connectionContractType);
				double nfATOstart_h = contractJson.path("nfATO_starttime_h").doubleValue();
				double nfATOend_h = contractJson.path("nfATO_endtime_h").doubleValue();
				double nfATOcapacity_kW = contractJson.path("nfATO_capacity_kW").doubleValue();
				v_contractConnection = new J_ConnectionContract(contractScope, connectionContractType, energyCarrier, nfATOstart_h, nfATOend_h, nfATOcapacity_kW, annualFee_eur);
				c_actorContracts.add(v_contractConnection);
			break;
			case TAX:
				double taxDelivery_eurpkWh = contractJson.required("taxDelivery_eurpkWh").doubleValue();
				double taxFeedin_eurpkWh = contractJson.required("taxFeedin_eurpkWh").doubleValue();
				double proportionalTax_pct = contractJson.required("proportionalTax_pct").doubleValue();
				v_contractTax = new J_TaxContract(contractScope, OL_EnergyCarriers.ELECTRICITY, taxDelivery_eurpkWh, taxFeedin_eurpkWh, proportionalTax_pct, annualFee_eur);
				c_actorContracts.add(v_contractTax);
			break;
			default:
			
			break;		
		}
	//} else if (energyCarrier.equals(OL_EnergyCarriers.METHANE)){
	} else {
		switch( contractService ) {
			case DELIVERY:					
				OL_DeliveryContractType deliveryContractType = OL_DeliveryContractType.valueOf(contractJson.required("deliveryContractType").textValue());
				double deliveryPrice_eurpkWh = contractJson.required("deliveryPrice_eurpkWh").doubleValue();
				double feedinPrice_eurpkWh = contractJson.required("feedinPrice_eurpkWh").doubleValue();
				J_DeliveryContract contractDelivery = new J_DeliveryContract(contractScope, deliveryContractType, energyCarrier, deliveryPrice_eurpkWh, feedinPrice_eurpkWh, annualFee_eur);
				//traceln("Delivery contract: " + v_contractDelivery);
				c_actorContracts.add(contractDelivery);
				//String contractScope = (String)l.get( "contractScope" );
				mySupplier = findFirst(energyModel.pop_energySuppliers, p->p.p_actorID.equals(contractScope)) ;
				if (mySupplier != null) {
					((EnergySupplier)mySupplier).f_connectToChild(this);	
				} else {
					mySupplier = findFirst(energyModel.pop_energyCoops, p->p.p_actorID.equals(contractScope)) ;
					if (mySupplier != null) {
						((EnergyCoop)mySupplier).f_connectToChild(this,energyCarrier);	
						//p_CoopParent = (EnergyCoop)mySupplier;
					}
				}
				//traceln("Methane supplier: " + contractScope + " for actor " + p_actorID );
				if (mySupplier != null) {
					//energySupplier.connectTo(mySupplier);
					if (energyCarrier==OL_EnergyCarriers.METHANE) {
						p_methaneSupplier = mySupplier;
						methaneDeliveryPrice_eurpkWh=deliveryPrice_eurpkWh;
					} else if(energyCarrier==OL_EnergyCarriers.HYDROGEN) {
						p_hydrogenSupplier = mySupplier;
						hydrogenDeliveryPrice_eurpkWh=deliveryPrice_eurpkWh;
					} else if(energyCarrier==OL_EnergyCarriers.HEAT) {
						p_heatSupplier = mySupplier;
						heatDeliveryPrice_eurpkWh=deliveryPrice_eurpkWh;
					}
					//traceln("MethaneSupplier " + mySupplier);
					//energySupplier.f_connectToChild(this);	
				} else { 
					traceln("Connection owner --> f_connectToParentActor --> " + energyCarrier + " supplier not found, this should not be happening");
				}
			break;
			case TAX:
				double DeliveryTax_eurpkWh = contractJson.required("taxDelivery_eurpkWh").doubleValue();
				double taxFeedin_eurpkWh = contractJson.required("taxFeedin_eurpkWh").doubleValue();
				double VAT_pct = contractJson.required("proportionalTax_pct").doubleValue();
				J_TaxContract contractTax = new J_TaxContract(contractScope, energyCarrier, DeliveryTax_eurpkWh, taxFeedin_eurpkWh, VAT_pct, annualFee_eur);
				c_actorContracts.add(contractTax);
				if (energyCarrier==OL_EnergyCarriers.METHANE) {						
						methaneDeliveryTax_eurpkWh=DeliveryTax_eurpkWh;
						methaneVAT_pct=VAT_pct;
					} else if(energyCarrier==OL_EnergyCarriers.HYDROGEN) {
						hydrogenDeliveryTax_eurpkWh=DeliveryTax_eurpkWh;
						hydrogenVAT_pct=VAT_pct;
					} else if(energyCarrier==OL_EnergyCarriers.HEAT) {
						heatVAT_pct=VAT_pct;
					}
			break;
			case CONNECTION:
				OL_ConnectionContractType connectionContractType = OL_ConnectionContractType.valueOf(contractJson.required("connectionContractType").textValue());
				J_ConnectionContract contractConnection = new J_ConnectionContract(contractScope, connectionContractType, energyCarrier, 0.0, 0.0, 0.0, annualFee_eur);
				c_actorContracts.add(contractConnection);



			break;
			case TRANSPORT:
				OL_TransportContractType transportContractType = OL_TransportContractType.valueOf(contractJson.required("transportContractType").textValue());
				double bandwidthTreshold_kW = contractJson.path("bandwidthTreshold_kW").doubleValue();
				double bandwidthTariff_eurpkWh = contractJson.path("bandwidthTariff_eurpkWh").doubleValue();
				J_TransportContract contractTransport = new J_TransportContract(contractScope, transportContractType, energyCarrier, bandwidthTreshold_kW, bandwidthTariff_eurpkWh, annualFee_eur);			
				c_actorContracts.add(contractTransport);
			break;
			default:
				traceln("Unrecognized contract type!");
			break;	
		}	
	}
}

// Calculate nett gas and hydrogen price
v_methanePrice_eurpkWh = (methaneDeliveryPrice_eurpkWh + methaneDeliveryTax_eurpkWh) * (1 + methaneVAT_pct);
v_hydrogenPrice_eurpkWh = (hydrogenDeliveryPrice_eurpkWh + hydrogenDeliveryTax_eurpkWh) * (1 + hydrogenVAT_pct);
v_heatPrice_eurpkWh = (heatDeliveryPrice_eurpkWh + heatDeliveryTax_eurpkWh) * (1 + heatVAT_pct);
		/*} else if (energyCarrier.equals(OL_EnergyCarriers.HYDROGEN)){
			switch( contractService ) {
				case DELIVERY:
					OL_DeliveryContractType deliveryContractType = OL_DeliveryContractType.valueOf((String)l.get("deliveryContractType"));
					double deliveryPrice_eurpkWh = (double)l.get("deliveryPrice_eurpkWh");
					double feedinPrice_eurpkWh = (double)l.get("feedinPrice_eurpkWh");
					v_contractDelivery = new J_DeliveryContract(contractScope, deliveryContractType, OL_EnergyCarriers.HYDROGEN, deliveryPrice_eurpkWh, feedinPrice_eurpkWh);
					//traceln("Delivery contract: " + v_contractDelivery);
					c_actorContracts.add(v_contractDelivery);
					mySupplier = findFirst(main.pop_energySuppliers, p->p.p_actorID.equals(contractScope)) ;
					if (mySupplier != null) {
						((EnergySupplier)mySupplier).f_connectToChild(this);
					} else {
						mySupplier = findFirst(main.pop_energyCoops, p->p.p_actorID.equals(contractScope)) ;
						if (mySupplier != null) {
							((EnergyCoop)mySupplier).f_connectToChild(this,OL_EnergyCarriers.HYDROGEN);
							//p_CoopParent = (EnergyCoop)mySupplier;
						}
					}
					if (mySupplier != null) {
						//energySupplier.connectTo(mySupplier);
						p_hydrogenSupplier = mySupplier;
						//energySupplier.f_connectToChild(this);
					} else {
						traceln("Connection owner --> f_connectToParentActor --> hydrogen supplier not found, this should not be happening");
					}
				break;
				case TAX:
					hydrogenDeliveryTax_eurpkWh = (double)l.get("taxDelivery_eurpkWh");
					//double taxFeedin_eurpkWh = (double)l.get("taxFeedin_eurpkWh");
					hydrogenVAT_pct = (double)l.get("proportionalTax_pct");
					v_contractTax = new J_TaxContract(contractScope, OL_EnergyCarriers.HYDROGEN, hydrogenDeliveryTax_eurpkWh, 0, hydrogenVAT_pct);
					c_actorContracts.add(v_contractTax);
				break;
				default:

				break;
			}
		} else if (energyCarrier.equals(OL_EnergyCarriers.HEAT)){
			switch( contractService ) {
				case DELIVERY:
					heatDeliveryPrice_eurpkWh = (double)l.get("deliveryPrice_eurpkWh");
					mySupplier = findFirst(main.pop_energySuppliers, p->p.p_actorID.equals(contractScope)) ;
					if (mySupplier != null) {
						((EnergySupplier)mySupplier).f_connectToChild(this);
					} else {
						mySupplier = findFirst(main.pop_energyCoops, p->p.p_actorID.equals(contractScope)) ;
						if (mySupplier != null) {
							((EnergyCoop)mySupplier).f_connectToChild(this,OL_EnergyCarriers.HYDROGEN);
							//p_CoopParent = (EnergyCoop)mySupplier;
						}
					}
					if (mySupplier != null) {
						//energySupplier.connectTo(mySupplier);
						p_hydrogenSupplier = mySupplier;
						//energySupplier.f_connectToChild(this);
					} else {
						traceln("Connection owner --> f_connectToParentActor --> heat supplier not found, this should not be happening");
					}
				break;
				case TAX:
					hydrogenDeliveryTax_eurpkWh = (double)l.get("taxDelivery_eurpkWh");
					//double taxFeedin_eurpkWh = (double)l.get("taxFeedin_eurpkWh");
					hydrogenVAT_pct = (double)l.get("proportionalTax_pct");
				break;
				default:
				
				break;
			}
		}*/

 
  }

  void f_initialize( J_TimeParameters timeParameters ) { 

double cumulativeContractedDeliveryCapacity_kW = 0;
double cumulativeContractedFeedinCapacity_kW = 0;
boolean cumulativeContractedDeliveryCapacityKnown = true;
boolean cumulativeContractedFeedinCapacityKnown = true;

v_liveData.activeEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeProductionEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeConsumptionEnergyCarriers= EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.assetsMetaData.activeAssetFlows.clear();
v_liveConnectionMetaData.setCapacities_kW(0, 0, 0);

//Get energy carriers and capacities boolean
for(GridConnection GC:c_memberGridConnections){
	if(GC.v_isActive){
		cumulativeContractedDeliveryCapacity_kW += GC.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW();
		cumulativeContractedFeedinCapacity_kW += GC.v_liveConnectionMetaData.getContractedFeedinCapacity_kW();
		v_liveData.activeEnergyCarriers.addAll(GC.v_liveData.activeEnergyCarriers);
		v_liveData.activeProductionEnergyCarriers.addAll(GC.v_liveData.activeProductionEnergyCarriers);
		v_liveData.activeConsumptionEnergyCarriers.addAll(GC.v_liveData.activeConsumptionEnergyCarriers);
		v_liveData.assetsMetaData.activeAssetFlows.addAll(GC.v_liveData.assetsMetaData.activeAssetFlows);
	
		if(!GC.v_liveConnectionMetaData.getContractedDeliveryCapacityKnown()){
			cumulativeContractedDeliveryCapacityKnown = false;
		}
	
		if(!GC.v_liveConnectionMetaData.getContractedFeedinCapacityKnown()){
			cumulativeContractedFeedinCapacityKnown = false;
		} 
	}
}
//For coops this value does not make sense, but is mandatory for the model currently so just get the max of the 2 contracted.
double physicalCapacity_kW = max(cumulativeContractedDeliveryCapacity_kW, cumulativeContractedFeedinCapacity_kW);

//Set connection values
v_liveConnectionMetaData.setCapacities_kW(cumulativeContractedDeliveryCapacity_kW, cumulativeContractedFeedinCapacity_kW, physicalCapacity_kW);
v_liveConnectionMetaData.setCapacitiesKnown(cumulativeContractedDeliveryCapacityKnown, cumulativeContractedFeedinCapacityKnown, false);


acc_totalOwnElectricityProduction_kW = new ZeroAccumulator(true, timeParameters.getTimeStep_h(), 8760);
acc_totalCustomerDelivery_kW = new ZeroAccumulator(true, timeParameters.getTimeStep_h(), 8760);
acc_totalCustomerFeedIn_kW = new ZeroAccumulator(true, timeParameters.getTimeStep_h(), 8760);

//========== LIVE WEEK DATASETS ==========//
v_liveData.dsm_liveDemand_kW.createEmptyDataSets(v_liveData.activeConsumptionEnergyCarriers, roundToInt(168/timeParameters.getTimeStep_h()));
v_liveData.dsm_liveSupply_kW.createEmptyDataSets(v_liveData.activeProductionEnergyCarriers, roundToInt(168/timeParameters.getTimeStep_h()));
v_liveData.dsm_liveAssetFlows_kW.createEmptyDataSets(v_liveData.assetsMetaData.activeAssetFlows, roundToInt(168/timeParameters.getTimeStep_h()));

v_lowPassFactor_fr = min(1, 0.8*1.2 * timeParameters.getTimeStep_h()); //0.2  
  }

  void f_updateIncentives(  ) { 

v_electricitySurplusLowPassed_kW += v_lowPassFactor_fr * ( v_electricitySurplus_kW - v_electricitySurplusLowPassed_kW );

/* if (v_contractDelivery.deliveryContractType==OL_DeliveryContractType.ELECTRICITY_VARIABLE) {
	if (p_electricitySupplier instanceof EnergySupplier) {
		v_electricityVariablePrice_eurpkWh = ((EnergySupplier)p_electricitySupplier).f_getVariableEnergyPrice();
	} else if (p_electricitySupplier instanceof EnergyCoop) {
		v_electricityVariablePrice_eurpkWh = ((EnergyCoop)p_electricitySupplier).f_getVariableEnergyPrice();
	}
}

f_setElectricityPriceBands(); */ // temporarily disabled!!
 
  }

  public void f_resetStates(  ) { 

v_electricitySurplusLowPassed_kW= 0;
v_totalOwnElectricityProduction_MWh = 0;
v_totalCustomerFeedIn_MWh = 0;
v_totalCustomerDelivery_MWh = 0;

acc_totalOwnElectricityProduction_kW.reset();
acc_totalCustomerDelivery_kW.reset();
acc_totalCustomerFeedIn_kW.reset();

v_rapidRunData.resetAccumulators(v_liveData.activeEnergyCarriers, v_liveData.activeConsumptionEnergyCarriers, v_liveData.activeProductionEnergyCarriers); //f_initializeAccumulators();
 
  }

  void f_updateLiveDataSets( J_TimeVariables timeVariables ) { 

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

  public void f_calculateKPIs(  ) { 

//Cumulative KPIs of each grid connection individually
f_getCumulativeIndividualGCValues();

//Costumer delivery and feedin
v_totalCustomerFeedIn_MWh = acc_totalCustomerFeedIn_kW.getIntegral_kWh() / 1000;
v_totalCustomerDelivery_MWh = acc_totalCustomerDelivery_kW.getIntegral_kWh() / 1000;
v_totalOwnElectricityProduction_MWh = acc_totalOwnElectricityProduction_kW.getIntegral_kWh() / 1000;
 
  }

  void f_collectGridConnectionRapidRunData(  ) { 

// Make collective profiles, electricity per timestep, other energy carriers per day!

for (GridConnection gc : c_memberGridConnections) {
	if(gc.v_isActive){
		// Totals
		v_rapidRunData.am_totalBalanceAccumulators_kW.add(gc.v_rapidRunData.am_totalBalanceAccumulators_kW);
		v_rapidRunData.am_totalHeatFromEnergyCarrier_kW.add(gc.v_rapidRunData.am_totalHeatFromEnergyCarrier_kW);
		v_rapidRunData.am_totalConsumptionForHeating_kW.add(gc.v_rapidRunData.am_totalConsumptionForHeating_kW);
		v_rapidRunData.am_dailyAverageConsumptionAccumulators_kW.add(gc.v_rapidRunData.am_dailyAverageConsumptionAccumulators_kW);
		v_rapidRunData.am_dailyAverageProductionAccumulators_kW.add(gc.v_rapidRunData.am_dailyAverageProductionAccumulators_kW);
		v_rapidRunData.acc_dailyAverageEnergyProduction_kW.add(gc.v_rapidRunData.acc_dailyAverageEnergyProduction_kW);
		v_rapidRunData.acc_dailyAverageFinalEnergyConsumption_kW.add(gc.v_rapidRunData.acc_dailyAverageFinalEnergyConsumption_kW);
		v_rapidRunData.acc_totalEnergyCurtailed_kW.add(gc.v_rapidRunData.acc_totalEnergyCurtailed_kW);
		v_rapidRunData.acc_totalPrimaryEnergyProductionHeatpumps_kW.add(gc.v_rapidRunData.acc_totalPrimaryEnergyProductionHeatpumps_kW);
		v_rapidRunData.am_assetFlowsAccumulators_kW.add(gc.v_rapidRunData.am_assetFlowsAccumulators_kW);
		
		// Daytime
		v_rapidRunData.acc_daytimeElectricityConsumption_kW.add(gc.v_rapidRunData.acc_daytimeElectricityConsumption_kW);
		v_rapidRunData.acc_daytimeElectricityProduction_kW.add(gc.v_rapidRunData.acc_daytimeElectricityProduction_kW);
		v_rapidRunData.acc_daytimeEnergyProduction_kW.add(gc.v_rapidRunData.acc_daytimeEnergyProduction_kW);
		v_rapidRunData.acc_daytimeFinalEnergyConsumption_kW.add(gc.v_rapidRunData.acc_daytimeFinalEnergyConsumption_kW);
		v_rapidRunData.am_daytimeImports_kW.add(gc.v_rapidRunData.am_daytimeImports_kW);
		v_rapidRunData.am_daytimeExports_kW.add(gc.v_rapidRunData.am_daytimeExports_kW);	
		v_rapidRunData.am_daytimeHeatFromEnergyCarrier_kW.add(gc.v_rapidRunData.am_daytimeHeatFromEnergyCarrier_kW);
		v_rapidRunData.am_daytimeConsumptionForHeating_kW.add(gc.v_rapidRunData.am_daytimeConsumptionForHeating_kW);

		// Weekend
		v_rapidRunData.acc_weekendElectricityConsumption_kW.add(gc.v_rapidRunData.acc_weekendElectricityConsumption_kW);
		v_rapidRunData.acc_weekendElectricityProduction_kW.add(gc.v_rapidRunData.acc_weekendElectricityProduction_kW);
		v_rapidRunData.acc_weekendEnergyProduction_kW.add(gc.v_rapidRunData.acc_weekendEnergyProduction_kW);
		v_rapidRunData.acc_weekendFinalEnergyConsumption_kW.add(gc.v_rapidRunData.acc_weekendFinalEnergyConsumption_kW);
		v_rapidRunData.am_weekendImports_kW.add(gc.v_rapidRunData.am_weekendImports_kW);
		v_rapidRunData.am_weekendExports_kW.add(gc.v_rapidRunData.am_weekendExports_kW);	
		v_rapidRunData.am_weekendHeatFromEnergyCarrier_kW.add(gc.v_rapidRunData.am_weekendHeatFromEnergyCarrier_kW);
		v_rapidRunData.am_weekendConsumptionForHeating_kW.add(gc.v_rapidRunData.am_weekendConsumptionForHeating_kW);

		// Summerweek
		v_rapidRunData.am_summerWeekBalanceAccumulators_kW.add(gc.v_rapidRunData.am_summerWeekBalanceAccumulators_kW);
		v_rapidRunData.am_summerWeekConsumptionAccumulators_kW.add(gc.v_rapidRunData.am_summerWeekConsumptionAccumulators_kW);
		v_rapidRunData.am_summerWeekProductionAccumulators_kW.add(gc.v_rapidRunData.am_summerWeekProductionAccumulators_kW);
		v_rapidRunData.am_summerWeekHeatFromEnergyCarrier_kW.add(gc.v_rapidRunData.am_summerWeekHeatFromEnergyCarrier_kW);
		v_rapidRunData.am_summerWeekConsumptionForHeating_kW.add(gc.v_rapidRunData.am_summerWeekConsumptionForHeating_kW);
		v_rapidRunData.acc_summerWeekEnergyProduction_kW.add(gc.v_rapidRunData.acc_summerWeekEnergyProduction_kW);
		v_rapidRunData.acc_summerWeekFinalEnergyConsumption_kW.add(gc.v_rapidRunData.acc_summerWeekFinalEnergyConsumption_kW);
		v_rapidRunData.acc_summerWeekEnergyCurtailed_kW.add(gc.v_rapidRunData.acc_summerWeekEnergyCurtailed_kW);
		v_rapidRunData.acc_summerWeekPrimaryEnergyProductionHeatpumps_kW.add(gc.v_rapidRunData.acc_summerWeekPrimaryEnergyProductionHeatpumps_kW);
		v_rapidRunData.am_assetFlowsSummerWeek_kW.add(gc.v_rapidRunData.am_assetFlowsSummerWeek_kW);
		
		// Winterweek
		v_rapidRunData.am_winterWeekBalanceAccumulators_kW.add(gc.v_rapidRunData.am_winterWeekBalanceAccumulators_kW);
		v_rapidRunData.am_winterWeekConsumptionAccumulators_kW.add(gc.v_rapidRunData.am_winterWeekConsumptionAccumulators_kW);
		v_rapidRunData.am_winterWeekProductionAccumulators_kW.add(gc.v_rapidRunData.am_winterWeekProductionAccumulators_kW);
		v_rapidRunData.am_winterWeekHeatFromEnergyCarrier_kW.add(gc.v_rapidRunData.am_winterWeekHeatFromEnergyCarrier_kW);
		v_rapidRunData.am_winterWeekConsumptionForHeating_kW.add(gc.v_rapidRunData.am_winterWeekConsumptionForHeating_kW);
		v_rapidRunData.acc_winterWeekEnergyProduction_kW.add(gc.v_rapidRunData.acc_winterWeekEnergyProduction_kW);
		v_rapidRunData.acc_winterWeekFinalEnergyConsumption_kW.add(gc.v_rapidRunData.acc_winterWeekFinalEnergyConsumption_kW);
		v_rapidRunData.acc_winterWeekEnergyCurtailed_kW.add(gc.v_rapidRunData.acc_winterWeekEnergyCurtailed_kW);
		v_rapidRunData.acc_winterWeekPrimaryEnergyProductionHeatpumps_kW.add(gc.v_rapidRunData.acc_winterWeekPrimaryEnergyProductionHeatpumps_kW);
		v_rapidRunData.am_assetFlowsWinterWeek_kW.add(gc.v_rapidRunData.am_assetFlowsWinterWeek_kW);
	}
}

// This is only true because we have no customers and only members of the Coop for this implementation
acc_totalOwnElectricityProduction_kW = v_rapidRunData.am_dailyAverageProductionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY);
//acc_summerWeekOwnElectricityProduction_kW = am_summerWeekProductionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY);
//acc_winterWeekOwnElectricityProduction_kW = am_winterWeekProductionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY);

//Calculate cumulative asset capacities
f_getTotalInstalledCapacityOfAssets_rapidRun();
 
  }

  void f_initializeCustomCoop( List<GridConnection> gcList, J_TimeParameters timeParameters ) { 

c_memberGridConnections.addAll(gcList);

//Basic initialization
f_initialize(timeParameters);

//Collect live datasets
f_collectGridConnectionLiveData();

boolean allGCHaveRapidRun = true;
boolean allGCHaveOriginalRapidRun = true;
for(GridConnection GC : c_memberGridConnections){
	if(GC.v_rapidRunData == null && GC.v_isActive){
		allGCHaveRapidRun = false;
	}
	if(GC.v_originalRapidRunData == null && GC.v_isActive){
		allGCHaveOriginalRapidRun = false;
	}
	if(!allGCHaveRapidRun && !allGCHaveOriginalRapidRun){
		break;
	}
}

if(allGCHaveRapidRun){
	
	//Create rapid run data class used to store combined values of the members
	f_createAndInitializeRapidRunDataClass(timeParameters);
	
	//Collect current totals
	f_collectGridConnectionRapidRunData();
	
	//Calculate KPIs
	f_calculateKPIs();
}

if(allGCHaveOriginalRapidRun){
	
	//Create rapid run data class used to store combined values of the members
	f_createAndInitializeOriginalRapidRunDataClass(timeParameters);
	
	//Collect current totals
	f_collectGridConnectionOriginalRapidRunData();
	
	//Calculate orignial KPIs
	f_getOriginalCumulativeIndividualGCValues();
} 
  }

  public 
double 
 f_getGroupContractDeliveryCapacity_kW( J_RapidRunData rapidRunData, J_TimeParameters timeParameters ) { 

DataSet data_netbelastingDuurkromme_kW = rapidRunData.getLoadDurationCurves().ds_loadDurationCurveTotal_kW;
int arraySize = data_netbelastingDuurkromme_kW.size();
if (arraySize < 8760/timeParameters.getTimeStep_h()){
	traceln("GroupContractDeliveryCapacity is zero because simulation is less than a full year long!");
	return 0.0;
} else {
	return max(0,data_netbelastingDuurkromme_kW.getY(roundToInt(0.25*35/timeParameters.getTimeStep_h())));
} 
  }

  public 
double 
 f_getGroupContractFeedinCapacity_kW( J_RapidRunData rapidRunData, J_TimeParameters timeParameters ) { 

DataSet data_netbelastingDuurkromme_kW = rapidRunData.getLoadDurationCurves().ds_loadDurationCurveTotal_kW;
int arraySize = data_netbelastingDuurkromme_kW.size();
if (arraySize < 8760/timeParameters.getTimeStep_h()){
	traceln("GroupContractDeliveryCapacity is zero because simulation is less than a full year long!");
	return 0.0;
} else {
	return -min(0,data_netbelastingDuurkromme_kW.getY(arraySize-roundToInt(0.25*35/timeParameters.getTimeStep_h())));
} 
  }

  void f_getCumulativeIndividualGCValues(  ) { 

//Self consumption and sufficiency
v_cumulativeIndividualSelfconsumptionElectricity_MWh = 0;
v_cumulativeIndividualSelfconsumptionElectricity_fr = 0;
v_cumulativeIndividualSelfSufficiencyElectricity_fr = 0;

v_cumulativeIndividualSelfconsumptionEnergy_MWh = 0;
v_cumulativeIndividualSelfconsumptionEnergy_fr = 0;
v_cumulativeIndividualSelfSufficiencyEnergy_fr = 0;

//Max peaks
v_cumulativeIndividualPeakDelivery_kW = 0;
v_cumulativeIndividualPeakFeedin_kW = 0;

v_cumulativeIndividualPeakDeliveryOriginal_kW = 0;
v_cumulativeIndividualPeakFeedinOriginal_kW = 0;


//Loop over membered grid connections
for(GridConnection GC : c_memberGridConnections){
	if(GC.v_isActive){
		//Add self consumption of gc individually
		v_cumulativeIndividualSelfconsumptionElectricity_MWh += GC.v_rapidRunData.getTotalElectricitySelfConsumed_MWh();
		v_cumulativeIndividualSelfconsumptionEnergy_MWh += GC.v_rapidRunData.getTotalEnergySelfConsumed_MWh();
		
		//Add all peaks for member grid connections
		v_cumulativeIndividualPeakDelivery_kW += GC.v_rapidRunData.getPeakDelivery_kW();
		v_cumulativeIndividualPeakFeedin_kW += GC.v_rapidRunData.getPeakFeedin_kW();
		
		if(v_originalRapidRunData != null && GC.v_originalRapidRunData != null){
			v_cumulativeIndividualPeakDeliveryOriginal_kW += GC.v_originalRapidRunData.getPeakDelivery_kW();
			v_cumulativeIndividualPeakFeedinOriginal_kW += GC.v_originalRapidRunData.getPeakFeedin_kW();
		}
	}	
}

//Add all max peaks of GC

//Do this also for the 'child' coops
for(Agent a :  c_coopMembers ) { // Take 'behind the meter' production and consumption!
	if (a instanceof EnergyCoop) {
		EnergyCoop EC = (EnergyCoop)a;
		EC.f_getCumulativeIndividualGCValues();
		v_cumulativeIndividualSelfconsumptionElectricity_MWh += EC.v_cumulativeIndividualSelfconsumptionElectricity_MWh;
		v_cumulativeIndividualPeakDelivery_kW  += EC.v_cumulativeIndividualPeakDelivery_kW;
		v_cumulativeIndividualPeakFeedin_kW  += EC.v_cumulativeIndividualPeakFeedin_kW;
		
		if(v_originalRapidRunData != null && EC.v_originalRapidRunData != null){
			v_cumulativeIndividualPeakDeliveryOriginal_kW += EC.v_cumulativeIndividualPeakDeliveryOriginal_kW;
			v_cumulativeIndividualPeakFeedinOriginal_kW += EC.v_cumulativeIndividualPeakFeedinOriginal_kW;
		}
	}
}

v_cumulativeIndividualSelfconsumptionElectricity_fr = v_rapidRunData.getTotalElectricityProduced_MWh() > 0 ? v_cumulativeIndividualSelfconsumptionElectricity_MWh / v_rapidRunData.getTotalElectricityProduced_MWh() : 0;
v_cumulativeIndividualSelfSufficiencyElectricity_fr = v_rapidRunData.getTotalElectricityConsumed_MWh()  > 0 ? v_cumulativeIndividualSelfconsumptionElectricity_MWh / v_rapidRunData.getTotalElectricityConsumed_MWh() : 0;

v_cumulativeIndividualSelfconsumptionEnergy_fr = v_rapidRunData.getTotalEnergyProduced_MWh() > 0 ? v_cumulativeIndividualSelfconsumptionEnergy_MWh / v_rapidRunData.getTotalEnergyProduced_MWh() : 0;
v_cumulativeIndividualSelfSufficiencyEnergy_fr = v_rapidRunData.getTotalEnergyConsumed_MWh() > 0 ? v_cumulativeIndividualSelfconsumptionEnergy_MWh / v_rapidRunData.getTotalEnergyConsumed_MWh() : 0;
 
  }

  void f_getTotalInstalledCapacityOfAssets_rapidRun(  ) { 

//Collect rapid run asset totals
v_rapidRunData.assetsMetaData.totalInstalledWindPower_kW = 0.0;
v_rapidRunData.assetsMetaData.totalInstalledPVPower_kW = 0.0;
v_rapidRunData.assetsMetaData.totalInstalledBatteryStorageCapacity_MWh = 0.0;

//Add all battery storage capacities of gc
for(GridConnection GC : c_memberGridConnections){
	if(GC.v_isActive){
		v_rapidRunData.assetsMetaData.totalInstalledWindPower_kW += GC.v_rapidRunData.assetsMetaData.totalInstalledWindPower_kW;
		v_rapidRunData.assetsMetaData.totalInstalledPVPower_kW += GC.v_rapidRunData.assetsMetaData.totalInstalledPVPower_kW;
		v_rapidRunData.assetsMetaData.totalInstalledBatteryStorageCapacity_MWh += GC.v_rapidRunData.assetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
	}
}

//Do this also for the 'child' coops
for(Agent a :  c_coopMembers ) { // Take 'behind the meter' production and consumption!
	if (a instanceof EnergyCoop) {
		EnergyCoop EC = (EnergyCoop)a;
		EC.f_getTotalInstalledCapacityOfAssets_rapidRun();
		v_rapidRunData.assetsMetaData.totalInstalledWindPower_kW += EC.v_rapidRunData.assetsMetaData.totalInstalledWindPower_kW;
		v_rapidRunData.assetsMetaData.totalInstalledPVPower_kW += EC.v_rapidRunData.assetsMetaData.totalInstalledPVPower_kW;
		v_rapidRunData.assetsMetaData.totalInstalledBatteryStorageCapacity_MWh += EC.v_rapidRunData.assetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
	}
} 
  }

  /**
   * Function that gets all grid nodes and the children of those grid nodes, etc. All the way to the bottom node.
   */
  public 
ArrayList<GridConnection> 
 f_getAllChildMemberGridConnections(  ) { 

return new ArrayList(f_getAllChildMemberGridConnections_recursion(new HashSet<GridConnection>())); 
  }

  /**
   * Recursion Function that gets all grid nodes and the children of those grid nodes, etc. All the way to the bottom node. For basic use should be called with an empty list!
   */
  
HashSet<GridConnection> 
 f_getAllChildMemberGridConnections_recursion( HashSet<GridConnection> allMemberGridConnections ) { 

//Add to collection
allMemberGridConnections.addAll(this.c_memberGridConnections);

//Recursive loop (repeat this function till bottom)
List<Actor> childCoops = findAll(c_coopMembers, coopMember -> coopMember instanceof EnergyCoop);

if(childCoops.size() == 0){
	return allMemberGridConnections;
}
else{
	for(Agent childCoop : childCoops){
		((EnergyCoop)childCoop).f_getAllChildMemberGridConnections_recursion(allMemberGridConnections);
	}
	return allMemberGridConnections;
}
 
  }

  public 
ArrayList<GridConnection> 
 f_getAllChildCustomerGridConnections(  ) { 

return new ArrayList(f_getAllChildCustomerGridConnections_recursion(new HashSet<GridConnection>())); 
  }

  
HashSet<GridConnection> 
 f_getAllChildCustomerGridConnections_recursion( HashSet<GridConnection> allCustomerGridConnections ) { 

//Add to collection
allCustomerGridConnections.addAll(this.c_customerGridConnections);

//Recursive loop (repeat this function till bottom)
List<Actor> childCoops = findAll(c_coopCustomers, coopCustomer -> coopCustomer instanceof EnergyCoop);
if(childCoops.size() == 0){
	return allCustomerGridConnections;
}
else{
	for(Agent childCoop : childCoops){
		((EnergyCoop)childCoop).f_getAllChildCustomerGridConnections_recursion(allCustomerGridConnections);
	}
	return allCustomerGridConnections;
}
 
  }

  public void f_collectGridConnectionLiveData(  ) { 

List<GridConnection> gcList = findAll(f_getAllChildMemberGridConnections(), gc -> gc.v_isActive);

int liveWeekSize = gcList.get(0).v_liveData.data_gridCapacityDemand_kW.size();

for (int i=0; i < liveWeekSize; i++){
	
	double timeAxisValue = gcList.get(0).v_liveData.data_gridCapacityDemand_kW.getX(i); // we get the X value from a random dataset 
	
	// Demand
	J_FlowsMap fm_demand_kW = new J_FlowsMap();
	J_ValueMap<OL_AssetFlowCategories> fm_currentAssetFlows_kW = new J_ValueMap(OL_AssetFlowCategories.class);
	
	double electricityDemandCapacityLiveWeek_kW = 0;
	double electricitySupplyCapacityLiveWeek_kW = 0;
	double netLoadLiveWeek_kW = 0;

	double districtHeatingDemandLiveWeek_kW = 0;
	
	// Supply
	J_FlowsMap fm_supply_kW = new J_FlowsMap();

	//Other
	double batteryStoredEnergyLiveWeek_MWh = 0;
	
	for (GridConnection gc : gcList){
		for (OL_EnergyCarriers EC_consumption : gc.v_liveData.activeConsumptionEnergyCarriers) {
			fm_demand_kW.addFlow( EC_consumption, gc.v_liveData.dsm_liveDemand_kW.get(EC_consumption).getY(i));			
		}
		for (OL_EnergyCarriers EC_production : gc.v_liveData.activeProductionEnergyCarriers) {
			fm_supply_kW.addFlow( EC_production, gc.v_liveData.dsm_liveSupply_kW.get(EC_production).getY(i));
		}
		for (OL_AssetFlowCategories AC : gc.v_liveAssetsMetaData.activeAssetFlows) {
			fm_currentAssetFlows_kW.addFlow(AC, gc.v_liveData.dsm_liveAssetFlows_kW.get(AC).getY(i));
		}
		
		electricityDemandCapacityLiveWeek_kW += gc.v_liveData.data_gridCapacityDemand_kW.getY(i);
		electricitySupplyCapacityLiveWeek_kW += gc.v_liveData.data_gridCapacitySupply_kW.getY(i);
		netLoadLiveWeek_kW  += gc.v_liveData.data_liveElectricityBalance_kW.getY(i);

		//Other 
		batteryStoredEnergyLiveWeek_MWh += 	gc.v_liveData.data_batteryStoredEnergyLiveWeek_MWh.getY(i);
	}
	
	for (OL_EnergyCarriers EC_consumption : v_liveData.activeConsumptionEnergyCarriers) {
		v_liveData.dsm_liveDemand_kW.get(EC_consumption).add(timeAxisValue, roundToDecimal(fm_demand_kW.get(EC_consumption), 3));
	}
	for (OL_EnergyCarriers EC_production : v_liveData.activeProductionEnergyCarriers) {
		v_liveData.dsm_liveSupply_kW.get(EC_production).add(timeAxisValue, roundToDecimal(fm_supply_kW.get(EC_production), 3));
	}
	
	for (OL_AssetFlowCategories AC : fm_currentAssetFlows_kW.keySet()) {
		v_liveData.dsm_liveAssetFlows_kW.get(AC).add(timeAxisValue, roundToDecimal(fm_currentAssetFlows_kW.get(AC), 3));
	}
	
	v_liveData.data_gridCapacityDemand_kW.add(timeAxisValue, electricityDemandCapacityLiveWeek_kW);
	v_liveData.data_gridCapacitySupply_kW.add(timeAxisValue, electricitySupplyCapacityLiveWeek_kW);
	v_liveData.data_liveElectricityBalance_kW.add(timeAxisValue, netLoadLiveWeek_kW);

	//Stored
	v_liveData.data_batteryStoredEnergyLiveWeek_MWh.add(timeAxisValue, batteryStoredEnergyLiveWeek_MWh);
}


//Calculate cumulative asset capacities
f_getTotalInstalledCapacityOfAssets_live();

//Recalculate SOC ts for energycoop
f_recalculateSOCDataSet_live();
 
  }

  void f_rapidRunDataLogging( J_TimeVariables timeVariables ) { 

// EnergyCoop specific
acc_totalOwnElectricityProduction_kW.addStep( v_currentOwnElectricityProduction_kW );
acc_totalCustomerDelivery_kW.addStep( v_currentCustomerDelivery_kW );
acc_totalCustomerFeedIn_kW.addStep( v_currentCustomerFeedIn_kW );

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
							timeVariables); 
  }

  void f_getTotalInstalledCapacityOfAssets_live(  ) { 

//Collect live asset totals
v_liveAssetsMetaData.totalInstalledWindPower_kW = 0.0;
v_liveAssetsMetaData.totalInstalledPVPower_kW = 0.0;
v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh = 0.0;

//Add all battery storage capacities of gc
for(GridConnection GC : c_memberGridConnections){
	if(GC.v_isActive){
		v_liveAssetsMetaData.totalInstalledWindPower_kW += GC.v_liveAssetsMetaData.totalInstalledWindPower_kW;
		v_liveAssetsMetaData.totalInstalledPVPower_kW += GC.v_liveAssetsMetaData.totalInstalledPVPower_kW;
		v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh += GC.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
	}
}

//Do this also for the 'child' coops
for(Agent a :  c_coopMembers ) { // Take 'behind the meter' production and consumption!
	if (a instanceof EnergyCoop) {
		EnergyCoop EC = (EnergyCoop)a;
		EC.f_getTotalInstalledCapacityOfAssets_live();
		v_liveAssetsMetaData.totalInstalledWindPower_kW += EC.v_liveAssetsMetaData.totalInstalledWindPower_kW;
		v_liveAssetsMetaData.totalInstalledPVPower_kW += EC.v_liveAssetsMetaData.totalInstalledPVPower_kW;
		v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh += EC.v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
	}
} 
  }

  void f_recalculateSOCDataSet_live(  ) { 

double totalInstalledBatteryStorageCapacity_MWh = v_liveAssetsMetaData.totalInstalledBatteryStorageCapacity_MWh;


double currentSOC = 0;
int liveWeekSize = v_liveData.data_batteryStoredEnergyLiveWeek_MWh.size();

for (int i=0; i < liveWeekSize; i++){
	if(totalInstalledBatteryStorageCapacity_MWh > 0){
		currentSOC = v_liveData.data_batteryStoredEnergyLiveWeek_MWh.getY(i)/totalInstalledBatteryStorageCapacity_MWh;
	}
	else{
		currentSOC = 0;
	}
	v_liveData.data_batterySOC_fr.add(v_liveData.data_batteryStoredEnergyLiveWeek_MWh.getX(i), roundToDecimal(currentSOC, 3));
} 
  }

  public void f_startAfterDeserialisation( J_TimeParameters timeParameters ) { 

acc_totalOwnElectricityProduction_kW = new ZeroAccumulator(true, timeParameters.getTimeStep_h(), 8760);
acc_totalCustomerDelivery_kW = new ZeroAccumulator(true, timeParameters.getTimeStep_h(), 8760);
acc_totalCustomerFeedIn_kW = new ZeroAccumulator(true, timeParameters.getTimeStep_h(), 8760);

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
 
  }

  public void f_addConsumptionEnergyCarrier( OL_EnergyCarriers EC, J_TimeParameters timeParameters, J_TimeVariables timeVariables ) { 

if (!v_liveData.activeConsumptionEnergyCarriers.contains(EC)) {
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
  }

  public void f_addProductionEnergyCarrier( OL_EnergyCarriers EC, J_TimeParameters timeParameters, J_TimeVariables timeVariables ) { 

if (!v_liveData.activeProductionEnergyCarriers.contains(EC)) {
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
		dsAsset = new DataSet( (int)(168 / timeParameters.getTimeStep_h()) );
		
		for (double t = startTime; t <= endTime; t += timeParameters.getTimeStep_h()) {
			dsAsset.add( t, 0);
		}
		v_liveData.dsm_liveAssetFlows_kW.put( OL_AssetFlowCategories.batteriesDischargingPower_kW, dsAsset);
	}
	if (AC == OL_AssetFlowCategories.V2GPower_kW && !v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.evChargingPower_kW)) { // also add evCharging!
		dsAsset = new DataSet( (int)(168 / timeParameters.getTimeStep_h()) );
		
		for (double t = startTime; t <= endTime; t += timeParameters.getTimeStep_h()) {
			dsAsset.add( t, 0);
		}
		v_liveData.dsm_liveAssetFlows_kW.put( OL_AssetFlowCategories.evChargingPower_kW, dsAsset);
	}			
} 
  }

  void f_createAndInitializeRapidRunDataClass( J_TimeParameters timeParameters ) { 

//Create rapid run data class used to collect rapid run data of other gc
v_rapidRunData = new J_RapidRunData(timeParameters, true);
v_rapidRunData.assetsMetaData = new J_AssetsMetaData(this);

EnumSet<OL_EnergyCarriers> activeEnergyCarriers_rapidRun = EnumSet.noneOf(OL_EnergyCarriers.class);
EnumSet<OL_EnergyCarriers> activeConsumptionEnergyCarriers_rapidRun = EnumSet.noneOf(OL_EnergyCarriers.class);
EnumSet<OL_EnergyCarriers> activeProductionEnergyCarriers_rapidRun = EnumSet.noneOf(OL_EnergyCarriers.class);
EnumSet<OL_AssetFlowCategories> activeAssetFlows_rapidRun = EnumSet.noneOf(OL_AssetFlowCategories.class);
Map<OL_EnergyAssetType, Double> map_numberOfActiveAssets_rapidRun = new HashMap<>();
Map<OL_EnergyAssetType, Double> map_activeAssetsCapacity_kW_rapidRun = new HashMap<>();

//Need to do this, for if the sliders have changed, otherwise potential errors/missing data
boolean storeTotalAssetFlows = true;
for(GridConnection GC : c_memberGridConnections){
	if(GC.v_isActive){
		activeEnergyCarriers_rapidRun.addAll(GC.v_rapidRunData.activeEnergyCarriers);
		activeConsumptionEnergyCarriers_rapidRun.addAll(GC.v_rapidRunData.activeConsumptionEnergyCarriers);
		activeProductionEnergyCarriers_rapidRun.addAll(GC.v_rapidRunData.activeProductionEnergyCarriers);
		activeAssetFlows_rapidRun.addAll(GC.v_rapidRunData.assetsMetaData.activeAssetFlows);
		GC.v_rapidRunData.assetsMetaData.getNumberOfActiveAssetsMap().forEach((key, value) -> map_numberOfActiveAssets_rapidRun.merge(key, value, Double::sum));
		GC.v_rapidRunData.assetsMetaData.getActiveAssetsCapacityMap().forEach((key, value) -> map_activeAssetsCapacity_kW_rapidRun.merge(key, value, Double::sum));
		
		if(GC.v_rapidRunData.getStoreTotalAssetFlows() == false){
			storeTotalAssetFlows = false;
		}
	}
}

//Adjust StoreTotalAssetFlows accordingly to the member data
v_rapidRunData.setStoreTotalAssetFlows(storeTotalAssetFlows);

//For now assumed to stay the same even after slider change: can't see rapid run graphs anyway after slider change
v_rapidRunData.connectionMetaData = v_liveConnectionMetaData.getClone();

//Initialize the rapid run data
v_rapidRunData.initializeAccumulators(activeEnergyCarriers_rapidRun, activeConsumptionEnergyCarriers_rapidRun, activeProductionEnergyCarriers_rapidRun, activeAssetFlows_rapidRun);

//Initialize the asset maps
v_rapidRunData.assetsMetaData.setActiveAssetsInfoMaps(map_numberOfActiveAssets_rapidRun, map_activeAssetsCapacity_kW_rapidRun); 
  }

  public 
ArrayList<GridConnection> 
 f_getMemberGridConnectionsCollectionPointer(  ) { 

return this.c_memberGridConnections; // This should NOT be a copy, it should be a pointer!! 
  }

  public void f_addMemberGCs( List<GridConnection> gcList, J_TimeParameters timeParameters ) { 

f_initializeCustomCoop(gcList, timeParameters);

// Adding this coop to the list of coops in the GC
gcList.forEach(gc -> gc.c_parentCoops.add(this));
 
  }

  public void f_removeMemberGCs( List<GridConnection> gcList, J_TimeParameters timeParameters ) { 

c_memberGridConnections.removeAll(gcList);
List<GridConnection> newMemberGridConnectionsList = new ArrayList<GridConnection>(c_memberGridConnections);
c_memberGridConnections.clear();

// Remove this coop from the list of coops in the GC
gcList.forEach(gc -> gc.c_parentCoops.remove(this));

f_initializeCustomCoop(newMemberGridConnectionsList, timeParameters); 
  }

  void f_operateAggregatorEnergyManagement( J_TimeVariables timeVariables ) { 

if(p_aggregatorEnergyManagement != null){
	p_aggregatorEnergyManagement.operateAggregatorEnergyManagement(timeVariables);
} 
  }

  void f_collectGridConnectionOriginalRapidRunData(  ) { 

// Make collective profiles, electricity per timestep, other energy carriers per day!

for (GridConnection gc : c_memberGridConnections) {
	if(gc.v_isActive){
		// Totals
		v_originalRapidRunData.am_totalBalanceAccumulators_kW.add(gc.v_originalRapidRunData.am_totalBalanceAccumulators_kW);
		v_originalRapidRunData.am_totalHeatFromEnergyCarrier_kW.add(gc.v_originalRapidRunData.am_totalHeatFromEnergyCarrier_kW);
		v_originalRapidRunData.am_totalConsumptionForHeating_kW.add(gc.v_originalRapidRunData.am_totalConsumptionForHeating_kW);
		v_originalRapidRunData.am_dailyAverageConsumptionAccumulators_kW.add(gc.v_originalRapidRunData.am_dailyAverageConsumptionAccumulators_kW);
		v_originalRapidRunData.am_dailyAverageProductionAccumulators_kW.add(gc.v_originalRapidRunData.am_dailyAverageProductionAccumulators_kW);
		v_originalRapidRunData.acc_dailyAverageEnergyProduction_kW.add(gc.v_originalRapidRunData.acc_dailyAverageEnergyProduction_kW);
		v_originalRapidRunData.acc_dailyAverageFinalEnergyConsumption_kW.add(gc.v_originalRapidRunData.acc_dailyAverageFinalEnergyConsumption_kW);
		v_originalRapidRunData.acc_totalEnergyCurtailed_kW.add(gc.v_originalRapidRunData.acc_totalEnergyCurtailed_kW);
		v_originalRapidRunData.acc_totalPrimaryEnergyProductionHeatpumps_kW.add(gc.v_originalRapidRunData.acc_totalPrimaryEnergyProductionHeatpumps_kW);
		v_originalRapidRunData.am_assetFlowsAccumulators_kW.add(gc.v_originalRapidRunData.am_assetFlowsAccumulators_kW);
		
		// Daytime
		v_originalRapidRunData.acc_daytimeElectricityConsumption_kW.add(gc.v_originalRapidRunData.acc_daytimeElectricityConsumption_kW);
		v_originalRapidRunData.acc_daytimeElectricityProduction_kW.add(gc.v_originalRapidRunData.acc_daytimeElectricityProduction_kW);
		v_originalRapidRunData.acc_daytimeEnergyProduction_kW.add(gc.v_originalRapidRunData.acc_daytimeEnergyProduction_kW);
		v_originalRapidRunData.acc_daytimeFinalEnergyConsumption_kW.add(gc.v_originalRapidRunData.acc_daytimeFinalEnergyConsumption_kW);
		v_originalRapidRunData.am_daytimeImports_kW.add(gc.v_originalRapidRunData.am_daytimeImports_kW);
		v_originalRapidRunData.am_daytimeExports_kW.add(gc.v_originalRapidRunData.am_daytimeExports_kW);	
		v_originalRapidRunData.am_daytimeHeatFromEnergyCarrier_kW.add(gc.v_originalRapidRunData.am_daytimeHeatFromEnergyCarrier_kW);
		v_originalRapidRunData.am_daytimeConsumptionForHeating_kW.add(gc.v_originalRapidRunData.am_daytimeConsumptionForHeating_kW);

		// Weekend
		v_originalRapidRunData.acc_weekendElectricityConsumption_kW.add(gc.v_originalRapidRunData.acc_weekendElectricityConsumption_kW);
		v_originalRapidRunData.acc_weekendElectricityProduction_kW.add(gc.v_originalRapidRunData.acc_weekendElectricityProduction_kW);
		v_originalRapidRunData.acc_weekendEnergyProduction_kW.add(gc.v_originalRapidRunData.acc_weekendEnergyProduction_kW);
		v_originalRapidRunData.acc_weekendFinalEnergyConsumption_kW.add(gc.v_originalRapidRunData.acc_weekendFinalEnergyConsumption_kW);
		v_originalRapidRunData.am_weekendImports_kW.add(gc.v_originalRapidRunData.am_weekendImports_kW);
		v_originalRapidRunData.am_weekendExports_kW.add(gc.v_originalRapidRunData.am_weekendExports_kW);	
		v_originalRapidRunData.am_weekendHeatFromEnergyCarrier_kW.add(gc.v_originalRapidRunData.am_weekendHeatFromEnergyCarrier_kW);
		v_originalRapidRunData.am_weekendConsumptionForHeating_kW.add(gc.v_originalRapidRunData.am_weekendConsumptionForHeating_kW);

		// Summerweek
		v_originalRapidRunData.am_summerWeekBalanceAccumulators_kW.add(gc.v_originalRapidRunData.am_summerWeekBalanceAccumulators_kW);
		v_originalRapidRunData.am_summerWeekConsumptionAccumulators_kW.add(gc.v_originalRapidRunData.am_summerWeekConsumptionAccumulators_kW);
		v_originalRapidRunData.am_summerWeekProductionAccumulators_kW.add(gc.v_originalRapidRunData.am_summerWeekProductionAccumulators_kW);
		v_originalRapidRunData.am_summerWeekHeatFromEnergyCarrier_kW.add(gc.v_originalRapidRunData.am_summerWeekHeatFromEnergyCarrier_kW);
		v_originalRapidRunData.am_summerWeekConsumptionForHeating_kW.add(gc.v_originalRapidRunData.am_summerWeekConsumptionForHeating_kW);
		v_originalRapidRunData.acc_summerWeekEnergyProduction_kW.add(gc.v_originalRapidRunData.acc_summerWeekEnergyProduction_kW);
		v_originalRapidRunData.acc_summerWeekFinalEnergyConsumption_kW.add(gc.v_originalRapidRunData.acc_summerWeekFinalEnergyConsumption_kW);
		v_originalRapidRunData.acc_summerWeekEnergyCurtailed_kW.add(gc.v_originalRapidRunData.acc_summerWeekEnergyCurtailed_kW);
		v_originalRapidRunData.acc_summerWeekPrimaryEnergyProductionHeatpumps_kW.add(gc.v_originalRapidRunData.acc_summerWeekPrimaryEnergyProductionHeatpumps_kW);
		v_originalRapidRunData.am_assetFlowsSummerWeek_kW.add(gc.v_originalRapidRunData.am_assetFlowsSummerWeek_kW);
		
		// Winterweek
		v_originalRapidRunData.am_winterWeekBalanceAccumulators_kW.add(gc.v_originalRapidRunData.am_winterWeekBalanceAccumulators_kW);
		v_originalRapidRunData.am_winterWeekConsumptionAccumulators_kW.add(gc.v_originalRapidRunData.am_winterWeekConsumptionAccumulators_kW);
		v_originalRapidRunData.am_winterWeekProductionAccumulators_kW.add(gc.v_originalRapidRunData.am_winterWeekProductionAccumulators_kW);
		v_originalRapidRunData.am_winterWeekHeatFromEnergyCarrier_kW.add(gc.v_originalRapidRunData.am_winterWeekHeatFromEnergyCarrier_kW);
		v_originalRapidRunData.am_winterWeekConsumptionForHeating_kW.add(gc.v_originalRapidRunData.am_winterWeekConsumptionForHeating_kW);
		v_originalRapidRunData.acc_winterWeekEnergyProduction_kW.add(gc.v_originalRapidRunData.acc_winterWeekEnergyProduction_kW);
		v_originalRapidRunData.acc_winterWeekFinalEnergyConsumption_kW.add(gc.v_originalRapidRunData.acc_winterWeekFinalEnergyConsumption_kW);
		v_originalRapidRunData.acc_winterWeekEnergyCurtailed_kW.add(gc.v_originalRapidRunData.acc_winterWeekEnergyCurtailed_kW);
		v_originalRapidRunData.acc_winterWeekPrimaryEnergyProductionHeatpumps_kW.add(gc.v_originalRapidRunData.acc_winterWeekPrimaryEnergyProductionHeatpumps_kW);
		v_originalRapidRunData.am_assetFlowsWinterWeek_kW.add(gc.v_originalRapidRunData.am_assetFlowsWinterWeek_kW);
	}
}

//Calculate cumulative asset capacities
f_getTotalInstalledCapacityOfAssets_originalRapidRun();
 
  }

  void f_getTotalInstalledCapacityOfAssets_originalRapidRun(  ) { 

//Collect rapid run asset totals
v_originalRapidRunData.assetsMetaData.totalInstalledWindPower_kW = 0.0;
v_originalRapidRunData.assetsMetaData.totalInstalledPVPower_kW = 0.0;
v_originalRapidRunData.assetsMetaData.totalInstalledBatteryStorageCapacity_MWh = 0.0;

//Add all battery storage capacities of gc
for(GridConnection GC : c_memberGridConnections){
	if(GC.v_isActive){
		v_originalRapidRunData.assetsMetaData.totalInstalledWindPower_kW += GC.v_originalRapidRunData.assetsMetaData.totalInstalledWindPower_kW;
		v_originalRapidRunData.assetsMetaData.totalInstalledPVPower_kW += GC.v_originalRapidRunData.assetsMetaData.totalInstalledPVPower_kW;
		v_originalRapidRunData.assetsMetaData.totalInstalledBatteryStorageCapacity_MWh += GC.v_originalRapidRunData.assetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
	}
}

//Do this also for the 'child' coops
for(Agent a :  c_coopMembers ) { // Take 'behind the meter' production and consumption!
	if (a instanceof EnergyCoop) {
		EnergyCoop EC = (EnergyCoop)a;
		EC.f_getTotalInstalledCapacityOfAssets_rapidRun();
		v_originalRapidRunData.assetsMetaData.totalInstalledWindPower_kW += EC.v_originalRapidRunData.assetsMetaData.totalInstalledWindPower_kW;
		v_originalRapidRunData.assetsMetaData.totalInstalledPVPower_kW += EC.v_originalRapidRunData.assetsMetaData.totalInstalledPVPower_kW;
		v_originalRapidRunData.assetsMetaData.totalInstalledBatteryStorageCapacity_MWh += EC.v_originalRapidRunData.assetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
	}
} 
  }

  void f_createAndInitializeOriginalRapidRunDataClass(  J_TimeParameters timeParameters ) { 

//Create rapid run data class used to collect rapid run data of other gc
v_originalRapidRunData = new J_RapidRunData(timeParameters, true);
v_originalRapidRunData.assetsMetaData = new J_AssetsMetaData(this);
   
EnumSet<OL_EnergyCarriers> activeEnergyCarriers_rapidRun = EnumSet.noneOf(OL_EnergyCarriers.class);
EnumSet<OL_EnergyCarriers> activeConsumptionEnergyCarriers_rapidRun = EnumSet.noneOf(OL_EnergyCarriers.class);
EnumSet<OL_EnergyCarriers> activeProductionEnergyCarriers_rapidRun = EnumSet.noneOf(OL_EnergyCarriers.class);
EnumSet<OL_AssetFlowCategories> activeAssetFlows_rapidRun = EnumSet.noneOf(OL_AssetFlowCategories.class);
Map<OL_EnergyAssetType, Double> map_numberOfActiveAssets_rapidRun = new HashMap<>();
Map<OL_EnergyAssetType, Double> map_activeAssetsCapacity_kW_rapidRun = new HashMap<>();

//Need to do this, for if the sliders have changed, otherwise potential errors/missing data  ????
boolean storeTotalAssetFlows = true;
for(GridConnection GC : c_memberGridConnections){
	if(GC.v_isActive){
		activeEnergyCarriers_rapidRun.addAll(GC.v_originalRapidRunData.activeEnergyCarriers);
		activeConsumptionEnergyCarriers_rapidRun.addAll(GC.v_originalRapidRunData.activeConsumptionEnergyCarriers);
		activeProductionEnergyCarriers_rapidRun.addAll(GC.v_originalRapidRunData.activeProductionEnergyCarriers);
		activeAssetFlows_rapidRun.addAll(GC.v_originalRapidRunData.assetsMetaData.activeAssetFlows);
		GC.v_originalRapidRunData.assetsMetaData.getNumberOfActiveAssetsMap().forEach((key, value) -> map_numberOfActiveAssets_rapidRun.merge(key, value, Double::sum));
		GC.v_originalRapidRunData.assetsMetaData.getActiveAssetsCapacityMap().forEach((key, value) -> map_activeAssetsCapacity_kW_rapidRun.merge(key, value, Double::sum));
		
		if(GC.v_rapidRunData.getStoreTotalAssetFlows() == false){
			storeTotalAssetFlows = false;
		}
	}
}

//Adjust StoreTotalAssetFlows accordingly to the member data
v_originalRapidRunData.setStoreTotalAssetFlows(storeTotalAssetFlows);

//For now assumed to stay the same even after slider change: can't see rapid run graphs anyway after slider change
v_originalRapidRunData.connectionMetaData = v_liveConnectionMetaData.getClone();

//Initialize the rapid run data
v_originalRapidRunData.initializeAccumulators(activeEnergyCarriers_rapidRun, activeConsumptionEnergyCarriers_rapidRun, activeProductionEnergyCarriers_rapidRun, activeAssetFlows_rapidRun);

//Initialize the asset maps
v_originalRapidRunData.assetsMetaData.setActiveAssetsInfoMaps(map_numberOfActiveAssets_rapidRun, map_activeAssetsCapacity_kW_rapidRun); 
  }

  void f_getOriginalCumulativeIndividualGCValues(  ) { 

v_cumulativeIndividualPeakDeliveryOriginal_kW = 0;
v_cumulativeIndividualPeakFeedinOriginal_kW = 0;

//Loop over membered grid connections
for(GridConnection GC : c_memberGridConnections){
	if(GC.v_isActive){
		//Add all peaks for member grid connections
		v_cumulativeIndividualPeakDeliveryOriginal_kW += GC.v_originalRapidRunData.getPeakDelivery_kW();
		v_cumulativeIndividualPeakFeedinOriginal_kW += GC.v_originalRapidRunData.getPeakFeedin_kW();
	}	
}

for(Agent a :  c_coopMembers ) { // Take 'behind the meter' production and consumption!
	if (a instanceof EnergyCoop) {
		EnergyCoop EC = (EnergyCoop)a;
		EC.f_getOriginalCumulativeIndividualGCValues();

		if(v_originalRapidRunData != null && EC.v_originalRapidRunData != null){
			v_cumulativeIndividualPeakDeliveryOriginal_kW += EC.v_cumulativeIndividualPeakDeliveryOriginal_kW;
			v_cumulativeIndividualPeakFeedinOriginal_kW += EC.v_cumulativeIndividualPeakFeedinOriginal_kW;
		}
	}
} 
  }

  public void f_setAggregatorEnergyManagement( I_AggregatorEnergyManagement aggregatorEnergyManagement ) { 

this.p_aggregatorEnergyManagement = aggregatorEnergyManagement; 
  }

  public 
I_AggregatorEnergyManagement 
 f_getAggregatorEnergyManagement(  ) { 

return this.p_aggregatorEnergyManagement; 
  }

  public void f_setExternalAggregatorAssetManagement( I_AggregatorAssetManagement externalAggregatorAssetManagement ) { 

if(this.p_aggregatorEnergyManagement == null){
	this.p_aggregatorEnergyManagement = new J_AggregatorEnergyManagementDefault(this, energyModel.p_timeParameters);
}
this.p_aggregatorEnergyManagement.setExternalAggregatorAssetManagement(externalAggregatorAssetManagement);
     
  }

  public 
<T extends I_AggregatorAssetManagement> T 
 f_getExternalAggregatorAssetManagement( Class<T>  aggregatorAssetManagementInterfaceType ) { 

if(this.p_aggregatorEnergyManagement != null){
	return this.p_aggregatorEnergyManagement.getExternalAggregatorAssetManagement(aggregatorAssetManagementInterfaceType);
}
else{
	return null;
} 
  }

  public void f_removeExternalAggregatorAssetManagement( Class<? extends I_AggregatorAssetManagement> aggregatorAssetManagementInterfaceType ) { 

if(this.p_aggregatorEnergyManagement != null){
	this.p_aggregatorEnergyManagement.removeExternalAggregatorAssetManagement(aggregatorAssetManagementInterfaceType);
} 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea va_coop = new ViewArea( this, null, 0, 0, 1920, 980 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "va_coop", this.va_coop );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_viewData_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_cumulativeIndividualGCValues_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text8_Font = new Font("SansSerif", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_energyBalanceMonitor = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_cumulativeIndividualGCValues = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _text8 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_viewData = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 4;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 5;

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
	  level.addAll(rect_energyBalanceMonitor, txt_cumulativeIndividualGCValues, text8, button_viewData);
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
  protected ShapeRectangle rect_energyBalanceMonitor;
  protected ShapeText txt_cumulativeIndividualGCValues;
  protected ShapeText text8;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    button_viewData = new ShapeButton(
EnergyCoop.this, true, 240.0, -90.0,
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
    rect_energyBalanceMonitor = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 980.0, 0.0, 0.0,
            lightSkyBlue, white,
			840.0, 720.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_cumulativeIndividualGCValues = new ShapeText(
        SHAPE_DRAW_2D, true,1420.0, 680.0, 0.0, 0.0,
        black,"Cumulative individual GC values",
        _txt_cumulativeIndividualGCValues_Font, ALIGNMENT_LEFT );
    text8 = new ShapeText(
        SHAPE_DRAW_2D, false,400.0, 1010.0, 0.0, 0.0,
        black,"Energy balance monitor",
        _text8_Font, ALIGNMENT_CENTER );
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
  public EnergyCoop( Engine engine, Agent owner, AgentList<? extends EnergyCoop> ownerPopulation ) {
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
  public EnergyCoop() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public EnergyCoop( String p_actorID, String p_actorGroup, String p_actorSubgroup, com.fasterxml.jackson.databind.node.ArrayNode p_actorContractList, Actor p_electricitySupplier, Actor p_CoopParent, Actor p_gridOperator, Actor p_methaneSupplier, Actor p_hydrogenSupplier, Actor p_heatSupplier ) {
    super( p_actorID, p_actorGroup, p_actorSubgroup );
    this.p_actorContractList = p_actorContractList;
    this.p_electricitySupplier = p_electricitySupplier;
    this.p_CoopParent = p_CoopParent;
    this.p_gridOperator = p_gridOperator;
    this.p_methaneSupplier = p_methaneSupplier;
    this.p_hydrogenSupplier = p_hydrogenSupplier;
    this.p_heatSupplier = p_heatSupplier;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_EnergyCoop_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "zero_engine.EnergyCoop.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( EnergyCoop.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

v_liveData = new J_LiveData();
v_liveData.activeEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeProductionEnergyCarriers = EnumSet.of(OL_EnergyCarriers.ELECTRICITY);
v_liveData.activeConsumptionEnergyCarriers= EnumSet.of(OL_EnergyCarriers.ELECTRICITY);

v_liveConnectionMetaData = new J_ConnectionMetaData(this);
v_liveAssetsMetaData = new J_AssetsMetaData(this);
v_liveData.connectionMetaData = v_liveConnectionMetaData;
v_liveData.assetsMetaData = v_liveAssetsMetaData;
energyModel.c_actors.add(this);

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
    super.setupPlainVariables_xjal();
    setupPlainVariables_EnergyCoop_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_EnergyCoop_xjal() {
    v_electricitySurplus_kW = 
0 
;
    v_balanceElectricityDelivery_eur = 
0 
;
    v_balanceElectricityTransport_eur = 
0 
;
    v_balanceElectricityTax_eur = 
0 
;
    v_currentNodalPrice_eurpkWh = 
0 
;
    v_balanceElectricity_eur = 
0 
;
    v_electricitySurplusLowPassed_kW = 
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

  public AgentList<? extends EnergyCoop> getPopulation() {
    return (AgentList<? extends EnergyCoop>) super.getPopulation();
  }

  public List<? extends EnergyCoop> agentsInRange( double distance ) {
    return (List<? extends EnergyCoop>) super.agentsInRange( distance );
  }

  // Additional class code

public OL_ResultScope getScope(){return OL_ResultScope.ENERGYCOOP;}
public J_RapidRunData getRapidRunData(){return v_rapidRunData;}
public J_LiveData getLiveData(){return v_liveData;}
public J_RapidRunData getPreviousRapidRunData(){return v_previousRunData;} 
  // End of additional class code

}
