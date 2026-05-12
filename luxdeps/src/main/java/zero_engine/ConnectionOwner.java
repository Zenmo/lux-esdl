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

//import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"va_ConnectionOwner","_origin_VA"})
 

public class ConnectionOwner extends zero_engine.Actor
{
  // Parameters

  /**
   * This 'link' is used for battery management functions that use collective (Coop) load balancing!
   */
  public 
EnergyCoop  p_coopParent;

  /**
   * Returns default value for parameter <code>p_coopParent</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public EnergyCoop _p_coopParent_DefaultValue_xjal() {
    final ConnectionOwner self = this;
    return null;
  }

  public void set_p_coopParent( EnergyCoop value ) {
    if (value == this.p_coopParent) {
      return;
    }
    EnergyCoop _oldValue_xjal = this.p_coopParent;
    this.p_coopParent = value;
    onChange_p_coopParent_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_coopParent.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_coopParent()</code> method instead.
   */
  protected void onChange_p_coopParent() {
    onChange_p_coopParent_xjal( p_coopParent );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_coopParent_xjal( EnergyCoop oldValue ) {  
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
    final ConnectionOwner self = this;
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
Actor  p_gridOperator;

  /**
   * Returns default value for parameter <code>p_gridOperator</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Actor _p_gridOperator_DefaultValue_xjal() {
    final ConnectionOwner self = this;
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
    final ConnectionOwner self = this;
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
    final ConnectionOwner self = this;
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
    final ConnectionOwner self = this;
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


  public 
OL_ConnectionOwnerType  p_connectionOwnerType;

  /**
   * Returns default value for parameter <code>p_connectionOwnerType</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_ConnectionOwnerType _p_connectionOwnerType_DefaultValue_xjal() {
    final ConnectionOwner self = this;
    return null;
  }

  public void set_p_connectionOwnerType( OL_ConnectionOwnerType value ) {
    if (value == this.p_connectionOwnerType) {
      return;
    }
    OL_ConnectionOwnerType _oldValue_xjal = this.p_connectionOwnerType;
    this.p_connectionOwnerType = value;
    onChange_p_connectionOwnerType_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_connectionOwnerType.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_connectionOwnerType()</code> method instead.
   */
  protected void onChange_p_connectionOwnerType() {
    onChange_p_connectionOwnerType_xjal( p_connectionOwnerType );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_connectionOwnerType_xjal( OL_ConnectionOwnerType oldValue ) {  
  }


  /**
   * Is it a company that filled in the survey
   */
  public 
boolean  p_detailedCompany;

  /**
   * Returns default value for parameter <code>p_detailedCompany</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _p_detailedCompany_DefaultValue_xjal() {
    final ConnectionOwner self = this;
    return false;
  }

  public void set_p_detailedCompany( boolean value ) {
    if (value == this.p_detailedCompany) {
      return;
    }
    boolean _oldValue_xjal = this.p_detailedCompany;
    this.p_detailedCompany = value;
    onChange_p_detailedCompany_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_detailedCompany.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_detailedCompany()</code> method instead.
   */
  protected void onChange_p_detailedCompany() {
    onChange_p_detailedCompany_xjal( p_detailedCompany );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_detailedCompany_xjal( boolean oldValue ) {  
  }


  /**
   * This 'link' is used for battery management functions that use collective (Coop) load balancing!
   */
  public 
String  p_energySupplierID;

  /**
   * Returns default value for parameter <code>p_energySupplierID</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_energySupplierID_DefaultValue_xjal() {
    final ConnectionOwner self = this;
    return null;
  }

  public void set_p_energySupplierID( String value ) {
    if (value == this.p_energySupplierID) {
      return;
    }
    String _oldValue_xjal = this.p_energySupplierID;
    this.p_energySupplierID = value;
    onChange_p_energySupplierID_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_energySupplierID.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_energySupplierID()</code> method instead.
   */
  protected void onChange_p_energySupplierID() {
    onChange_p_energySupplierID_xjal( p_energySupplierID );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_energySupplierID_xjal( String oldValue ) {  
  }


  /**
   * This 'link' is used for battery management functions that use collective (Coop) load balancing!
   */
  public 
String  p_energyCoopID;

  /**
   * Returns default value for parameter <code>p_energyCoopID</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_energyCoopID_DefaultValue_xjal() {
    final ConnectionOwner self = this;
    return null;
  }

  public void set_p_energyCoopID( String value ) {
    if (value == this.p_energyCoopID) {
      return;
    }
    String _oldValue_xjal = this.p_energyCoopID;
    this.p_energyCoopID = value;
    onChange_p_energyCoopID_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_energyCoopID.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_energyCoopID()</code> method instead.
   */
  protected void onChange_p_energyCoopID() {
    onChange_p_energyCoopID_xjal( p_energyCoopID );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_energyCoopID_xjal( String oldValue ) {  
  }


  public 
boolean  b_dataSharingAgreed;

  /**
   * Returns default value for parameter <code>b_dataSharingAgreed</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_dataSharingAgreed_DefaultValue_xjal() {
    final ConnectionOwner self = this;
    return 
true 
;
  }

  public void set_b_dataSharingAgreed( boolean value ) {
    if (value == this.b_dataSharingAgreed) {
      return;
    }
    boolean _oldValue_xjal = this.b_dataSharingAgreed;
    this.b_dataSharingAgreed = value;
    onChange_b_dataSharingAgreed_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_dataSharingAgreed.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_dataSharingAgreed()</code> method instead.
   */
  protected void onChange_b_dataSharingAgreed() {
    onChange_b_dataSharingAgreed_xjal( b_dataSharingAgreed );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_dataSharingAgreed_xjal( boolean oldValue ) {  
  }


  public 
boolean  b_dataIsAccessible;

  /**
   * Returns default value for parameter <code>b_dataIsAccessible</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _b_dataIsAccessible_DefaultValue_xjal() {
    final ConnectionOwner self = this;
    return 
true 
;
  }

  public void set_b_dataIsAccessible( boolean value ) {
    if (value == this.b_dataIsAccessible) {
      return;
    }
    boolean _oldValue_xjal = this.b_dataIsAccessible;
    this.b_dataIsAccessible = value;
    onChange_b_dataIsAccessible_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter b_dataIsAccessible.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_b_dataIsAccessible()</code> method instead.
   */
  protected void onChange_b_dataIsAccessible() {
    onChange_b_dataIsAccessible_xjal( b_dataIsAccessible );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_b_dataIsAccessible_xjal( boolean oldValue ) {  
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
    p_coopParent = _p_coopParent_DefaultValue_xjal();
    p_electricitySupplier = _p_electricitySupplier_DefaultValue_xjal();
    p_gridOperator = _p_gridOperator_DefaultValue_xjal();
    p_methaneSupplier = _p_methaneSupplier_DefaultValue_xjal();
    p_hydrogenSupplier = _p_hydrogenSupplier_DefaultValue_xjal();
    p_heatSupplier = _p_heatSupplier_DefaultValue_xjal();
    p_connectionOwnerType = _p_connectionOwnerType_DefaultValue_xjal();
    p_detailedCompany = _p_detailedCompany_DefaultValue_xjal();
    p_energySupplierID = _p_energySupplierID_DefaultValue_xjal();
    p_energyCoopID = _p_energyCoopID_DefaultValue_xjal();
    b_dataSharingAgreed = _b_dataSharingAgreed_DefaultValue_xjal();
    b_dataIsAccessible = _b_dataIsAccessible_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_coopParent":
      if ( _callOnChange_xjal ) {
        set_p_coopParent( (EnergyCoop) _value_xjal );
      } else {
        p_coopParent = (EnergyCoop) _value_xjal;
      }
      return true;
    case "p_electricitySupplier":
      if ( _callOnChange_xjal ) {
        set_p_electricitySupplier( (Actor) _value_xjal );
      } else {
        p_electricitySupplier = (Actor) _value_xjal;
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
    case "p_connectionOwnerType":
      if ( _callOnChange_xjal ) {
        set_p_connectionOwnerType( (OL_ConnectionOwnerType) _value_xjal );
      } else {
        p_connectionOwnerType = (OL_ConnectionOwnerType) _value_xjal;
      }
      return true;
    case "p_detailedCompany":
      if ( _callOnChange_xjal ) {
        set_p_detailedCompany( (Boolean) _value_xjal );
      } else {
        p_detailedCompany = (Boolean) _value_xjal;
      }
      return true;
    case "p_energySupplierID":
      if ( _callOnChange_xjal ) {
        set_p_energySupplierID( (String) _value_xjal );
      } else {
        p_energySupplierID = (String) _value_xjal;
      }
      return true;
    case "p_energyCoopID":
      if ( _callOnChange_xjal ) {
        set_p_energyCoopID( (String) _value_xjal );
      } else {
        p_energyCoopID = (String) _value_xjal;
      }
      return true;
    case "b_dataSharingAgreed":
      if ( _callOnChange_xjal ) {
        set_b_dataSharingAgreed( (Boolean) _value_xjal );
      } else {
        b_dataSharingAgreed = (Boolean) _value_xjal;
      }
      return true;
    case "b_dataIsAccessible":
      if ( _callOnChange_xjal ) {
        set_b_dataIsAccessible( (Boolean) _value_xjal );
      } else {
        b_dataIsAccessible = (Boolean) _value_xjal;
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
    case "p_coopParent": _result_xjal = p_coopParent; break;
    case "p_electricitySupplier": _result_xjal = p_electricitySupplier; break;
    case "p_gridOperator": _result_xjal = p_gridOperator; break;
    case "p_methaneSupplier": _result_xjal = p_methaneSupplier; break;
    case "p_hydrogenSupplier": _result_xjal = p_hydrogenSupplier; break;
    case "p_heatSupplier": _result_xjal = p_heatSupplier; break;
    case "p_connectionOwnerType": _result_xjal = p_connectionOwnerType; break;
    case "p_detailedCompany": _result_xjal = p_detailedCompany; break;
    case "p_energySupplierID": _result_xjal = p_energySupplierID; break;
    case "p_energyCoopID": _result_xjal = p_energyCoopID; break;
    case "b_dataSharingAgreed": _result_xjal = b_dataSharingAgreed; break;
    case "b_dataIsAccessible": _result_xjal = b_dataIsAccessible; break;
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
      list.add( "p_coopParent" );
      list.add( "p_electricitySupplier" );
      list.add( "p_gridOperator" );
      list.add( "p_methaneSupplier" );
      list.add( "p_hydrogenSupplier" );
      list.add( "p_heatSupplier" );
      list.add( "p_connectionOwnerType" );
      list.add( "p_detailedCompany" );
      list.add( "p_energySupplierID" );
      list.add( "p_energyCoopID" );
      list.add( "b_dataSharingAgreed" );
      list.add( "b_dataIsAccessible" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
Agent 
 v_energySupplierDistrictHeat;
  public 
J_ActorData 
 j_ActorData;
  public 
double 
 v_electricityVariablePrice_eurpkWh;
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
 v_methanePrice_eurpkWh;
  public 
double 
 v_hydrogenPrice_eurpkWh;
  public 
double 
 v_heatPrice_eurpkWh;
  public 
double 
 v_currentNodalPrice_eurpkWh;

  // Collection Variables
  public 
ArrayList <
J_Contract > c_actorContracts = new ArrayList<J_Contract>();
  
ArrayList <
GridConnection > c_ownedGridConnections = new ArrayList<GridConnection>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ConnectionOwner.class );

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

  void f_connectToChild( GridConnection ConnectingChildNode ) { 

c_ownedGridConnections.add(ConnectingChildNode);
//v_ownedGridConnection = ConnectingChildNode;
//traceln("f_connectToChild in connectionOwner agent, connection contract type: " + v_contractConnection.connectionContractType);
/*if (v_contractConnection.connectionContractType.equals(OL_ConnectionContractType.NFATO)) {
	ConnectingChildNode.v_enable_nfATO_b = true;
	ConnectingChildNode.p_nfatoStart_h = v_contractConnection.nfATOstart_h;
	ConnectingChildNode.p_nfatoEnd_h = v_contractConnection.nfATOend_h;
	ConnectingChildNode.p_nfatoLvl_kW = v_contractConnection.nfATOpower_kW;
	traceln("Setting nfATO TRUE for gridConnection: " + ConnectingChildNode.p_gridNodeID);
}*/
 
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

//f_setContractValues();
//f_setInitPriceBands();
// Connect to energy supplier (can be a Coop!)
//traceln(p_actorID + " is looking for its supplier");
if (v_contractDelivery == null) {
	throw new RuntimeException(
		String.format(
			"Actor %s has no delivery contract",
			p_actorID
		)
	);
}
Actor mySupplier = findFirst(energyModel.pop_energySuppliers, p->p.p_actorID.equals(v_contractDelivery.contractScope)) ;
if (mySupplier != null) {
	((EnergySupplier)mySupplier).f_connectToChild(this);	
} else {
	mySupplier = findFirst(energyModel.pop_energyCoops, p->p.p_actorID.equals(v_contractDelivery.contractScope)) ;
	if (mySupplier != null) {		
		((EnergyCoop)mySupplier).f_connectToChild(this,OL_EnergyCarriers.ELECTRICITY);
		p_coopParent = (EnergyCoop)mySupplier;
	}
}

if (mySupplier != null) {
	//energySupplier.connectTo(mySupplier);
	p_electricitySupplier = mySupplier;
	//energySupplier.f_connectToChild(this);	
} else { 
	/*traceln(
		"Connection owner %s --> f_connectToParentActor --> no parent actor found, this should not be happening. contract holder: %s, parent: %s",
		this,
		v_contractDelivery.contractHolder,
		v_contractDelivery.contractScope
	);*/
}

// Connect to grid operator (can be a Coop!)
if (v_contractTransport == null) {
	throw new RuntimeException(
		String.format(
			"Actor %s has no transport contract",
			p_actorID
		)
	);
}
Actor myGridoperator = findFirst(energyModel.pop_gridOperators, p->p.p_actorID.equals(v_contractTransport.contractScope)) ;
if (myGridoperator == null) {
	myGridoperator = findFirst(energyModel.pop_energyCoops, p->p.p_actorID.equals(v_contractTransport.contractScope)) ;
}

if (myGridoperator != null) {
	p_gridOperator = myGridoperator;	
} else { 
	/*traceln(
	    "Connection owner --> f_connectToParentActor --> no grid operator found, this should not be happening. contract holder: %s, operator: %s",
	    v_contractTransport.contractHolder,
	    v_contractTransport.contractScope
	);*/
}

//traceln(p_actorID + " finished looking for supplier");
 
  }

  void f_updateIncentives(  ) { 

if (v_contractDelivery.deliveryContractType==OL_DeliveryContractType.ELECTRICITY_VARIABLE) {
	if (p_electricitySupplier instanceof EnergySupplier) {
		v_electricityVariablePrice_eurpkWh = ((EnergySupplier)p_electricitySupplier).f_getVariableEnergyPrice();
	} else if (p_electricitySupplier instanceof EnergyCoop) {
		v_electricityVariablePrice_eurpkWh = ((EnergyCoop)p_electricitySupplier).f_getVariableEnergyPrice();
	}
}

// Transport pricing (nodal pricing) is 'pushed' to the connectionOwner from the GridNode, so don't have to ask for the price here.
/*if (v_contractTransport.transportContractType.equals(OL_TransportContractType.NODALPRICING)) {
	if (p_gridOperator instanceof GridOperator) {
		v_electricityVariablePrice_eurpkWh = ((GridOperator)p_gridOperator).f_getVariableEnergyPrice(v_electricityContractType, false);
	} else if (p_gridOperator instanceof EnergyCoop) {
		v_electricityVariablePrice_eurpkWh = ((EnergyCoop)p_gridOperator).f_getEnergyPrice(v_electricityContractType, false);
	}
}*/	

//f_setElectricityPriceBands();
 
  }

  void f_setContractValues(  ) { 

double methaneDeliveryPrice_eurpkWh = 0.0;
double methaneDeliveryTax_eurpkWh = 0.0;
double methaneVAT_pct = 0.0;
double hydrogenDeliveryPrice_eurpkWh = 0.0;
double hydrogenDeliveryTax_eurpkWh = 0.0;
double hydrogenVAT_pct = 0.0;
double heatDeliveryPrice_eurpkWh = 0.0;
double heatDeliveryTax_eurpkWh = 0.0;
double heatVAT_pct = 0.0;

//if( p_actorContractList == null) {
	//traceln( "No contract data for connectionOwner " + p_actorID );
	//traceln( "Creating default contracts!");

	String defaultSupplier = "defaultSupplier";
	if (p_energyCoopID != null){
		defaultSupplier = p_energyCoopID;
	}
	String defaultGridOperator = "defaultGridOperator";
	String defaultGovernmentLayer = "defaultGovernmentLayer";
	double annualFee_eur = 0;
	double deliveryPrice_eurpkWh = 0.2;
	double feedinPrice_eurpkWh = 0.2;
	double bandwidthTreshold_kW = 0.0;
	double bandwidthTariff_eurpkWh = 0.0;
	double nfATOstart_h = 0.0;
	double nfATOend_h = 0.0;
	double nfATOcapacity_kW = 0.0;
	double taxDelivery_eurpkWh = 0.13;
	double taxFeedin_eurpkWh = 0.0;
	double proportionalTax_pct = 21;

	/*if (p_actorID.equals("logistics0owner")){
		v_contractDelivery = new J_DeliveryContract("coop1", OL_DeliveryContractType.ELECTRICITY_FIXED, OL_EnergyCarriers.ELECTRICITY, deliveryPrice_eurpkWh, feedinPrice_eurpkWh, annualFee_eur);
	} else {
		v_contractDelivery = new J_DeliveryContract(defaultSupplier, OL_DeliveryContractType.ELECTRICITY_FIXED, OL_EnergyCarriers.ELECTRICITY, deliveryPrice_eurpkWh, feedinPrice_eurpkWh, annualFee_eur);
	}*/
	v_contractDelivery = new J_DeliveryContract(defaultSupplier, OL_DeliveryContractType.ELECTRICITY_FIXED, OL_EnergyCarriers.ELECTRICITY, deliveryPrice_eurpkWh, feedinPrice_eurpkWh, annualFee_eur);

	v_contractTransport = new J_TransportContract(defaultGridOperator, OL_TransportContractType.DEFAULT , OL_EnergyCarriers.ELECTRICITY, bandwidthTreshold_kW, bandwidthTariff_eurpkWh, annualFee_eur);

	v_contractConnection = new J_ConnectionContract(defaultGridOperator, OL_ConnectionContractType.DEFAULT, OL_EnergyCarriers.ELECTRICITY, nfATOstart_h, nfATOend_h, nfATOcapacity_kW, annualFee_eur);

	v_contractTax = new J_TaxContract(defaultGovernmentLayer, OL_EnergyCarriers.ELECTRICITY, taxDelivery_eurpkWh, taxFeedin_eurpkWh, proportionalTax_pct, annualFee_eur);

	c_actorContracts.add(v_contractDelivery);
	c_actorContracts.add(v_contractTransport);
	c_actorContracts.add(v_contractConnection);
	c_actorContracts.add(v_contractTax);
/*
} else {
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
}
*/
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

  
double 
 f_getElectricityPrice( double currentPowerDrawn_kW ) { 

double price_eurpkWh = 0;
if( currentPowerDrawn_kW >= 0 ){
	//Delivery
	/*if( v_priceBandsDelivery.ceilingKey(currentPowerDrawn_kW) == currentPowerDrawn_kW ){
		price += v_priceBandsDelivery.higherEntry( currentPowerDrawn_kW ).getValue();
	}
	else{
		price += v_priceBandsDelivery.ceilingEntry( currentPowerDrawn_kW ).getValue();
	}*/
	price_eurpkWh += v_contractDelivery.deliveryPrice_eurpkWh + v_electricityVariablePrice_eurpkWh;

	//Transport
	/*if( v_priceBandsTransport.ceilingKey(currentPowerDrawn_kW) == currentPowerDrawn_kW ){
		price += v_priceBandsTransport.higherEntry( currentPowerDrawn_kW ).getValue();
	}
	else{
		price += v_priceBandsTransport.ceilingEntry( currentPowerDrawn_kW ).getValue();
	}*/

	price_eurpkWh += v_currentNodalPrice_eurpkWh;
	//Tax
	/*if( v_priceBandsTax.ceilingKey(currentPowerDrawn_kW) == currentPowerDrawn_kW ){
		price += v_priceBandsTax.higherEntry( currentPowerDrawn_kW ).getValue();
	}
	else{
		price += v_priceBandsTax.ceilingEntry( currentPowerDrawn_kW ).getValue();
	}*/

	price_eurpkWh += v_contractTax.deliveryTax_eurpkWh + v_contractTax.proportionalTax_pct;// * (v_contractTax.deliveryTax_eurpkWh + v_currentNodalPrice_eurpkWh + v_contractDelivery.deliveryPrice_eurpkWh + v_electricityVariablePrice_eurpkWh)
	price_eurpkWh = price_eurpkWh * (1+0.01*v_contractTax.proportionalTax_pct);
}
else {
	//Delivery
	/*if( v_priceBandsDelivery.ceilingKey(currentPowerDrawn_kW) == currentPowerDrawn_kW ){
		price += v_priceBandsDelivery.higherEntry( currentPowerDrawn_kW ).getValue();
	}
	else{
		price += v_priceBandsDelivery.floorEntry( currentPowerDrawn_kW ).getValue();
	}*/

	price_eurpkWh += v_contractDelivery.feedinPrice_eurpkWh + v_electricityVariablePrice_eurpkWh;
	//Transport
	/*if( v_priceBandsTransport.ceilingKey(currentPowerDrawn_kW) == currentPowerDrawn_kW ){
		price += v_priceBandsTransport.higherEntry( currentPowerDrawn_kW ).getValue();
	}
	else{
		price += v_priceBandsTransport.floorEntry( currentPowerDrawn_kW ).getValue();
	}*/
	price_eurpkWh += v_contractDelivery.deliveryPrice_eurpkWh + v_electricityVariablePrice_eurpkWh;
	//Tax
	/*if( v_priceBandsTax.ceilingKey(currentPowerDrawn_kW) == currentPowerDrawn_kW ){
		price += v_priceBandsTax.higherEntry( currentPowerDrawn_kW ).getValue();
	}
	else{
		price += v_priceBandsTax.floorEntry( currentPowerDrawn_kW ).getValue();
	}*/
	price_eurpkWh += v_contractTax.feedinTax_eurpkWh + v_contractTax.proportionalTax_pct;// * (v_contractTax.deliveryTax_eurpkWh + v_currentNodalPrice_eurpkWh + v_contractDelivery.deliveryPrice_eurpkWh + v_electricityVariablePrice_eurpkWh)
	price_eurpkWh = price_eurpkWh * (1+0.01*v_contractTax.proportionalTax_pct);
}
//traceln(price_eurpkWh);
return price_eurpkWh; 
  }

  
double 
 f_getAvailablePowerAtPrice( double currentPowerDrawn_kW ) { 

double availablePower_kW;//, availablePowerDelivery, availablePowerTransport, availablePowerTax = 0;

/*if( currentPowerDrawn_kW >= 0 ){
	// Check if one of the pricebands is at a 'breakpoint'	
	if( currentPowerDrawn_kW == v_priceBandsDelivery.ceilingKey( currentPowerDrawn_kW )){
		availablePowerDelivery = v_priceBandsDelivery.higherKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	} 	else {
		availablePowerDelivery = v_priceBandsDelivery.ceilingKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	}
	if( currentPowerDrawn_kW == v_priceBandsTransport.ceilingKey( currentPowerDrawn_kW )){
		availablePowerTransport = v_priceBandsTransport.higherKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	} 	else {
		availablePowerTransport = v_priceBandsTransport.ceilingKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	}
	if( currentPowerDrawn_kW == v_priceBandsTax.ceilingKey( currentPowerDrawn_kW )){
		availablePowerTax = v_priceBandsTax.higherKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	} 	else {
		availablePowerTax = v_priceBandsTax.ceilingKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	}		
}
else {
	if( currentPowerDrawn_kW == v_priceBandsDelivery.floorKey( currentPowerDrawn_kW )){
		availablePowerDelivery = v_priceBandsDelivery.higherKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	} 	
	else {
		availablePowerDelivery = v_priceBandsDelivery.ceilingKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	}
	
	if( currentPowerDrawn_kW == v_priceBandsTransport.floorKey( currentPowerDrawn_kW )){
		availablePowerTransport = v_priceBandsTransport.higherKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	} 	
	else {
		availablePowerTransport = v_priceBandsTransport.ceilingKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	}
	
	if( currentPowerDrawn_kW == v_priceBandsTax.floorKey( currentPowerDrawn_kW )){
		availablePowerTax = v_priceBandsTax.higherKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	} 	
	else {
		availablePowerTax = v_priceBandsTax.ceilingKey( currentPowerDrawn_kW ) - currentPowerDrawn_kW;
	}		
	
}*/

//availablePower = min(min(availablePowerDelivery, availablePowerTransport), availablePowerTax);
if( currentPowerDrawn_kW >= 0 ){ // Only check if current power is positive or negative
	availablePower_kW = 1e10; // 'Infinite', in this case 10 TW. Something else should be the limiting factor on power.
} else {
	availablePower_kW = -currentPowerDrawn_kW;
}

//traceln("Still using treemaps in f_getAvailablePowerAtPrice!");
return availablePower_kW; 
  }

  /**
   * Returns the average electricity price of a given additional power demand above a current demand, taking all tariff structures into accounts. Mainly used for heatpumps that only operate at full 
   */
  
double 
 f_getAveragedElectricityPrice( double baseDemand_kW, double requestedPower_kW ) { 

double price_eurph = 0;
double availablePower_kW = 0;
double addedPrice_eurpkWh;
double addedPower_kW;
double currentPowerRequestLevel_kW;

boolean isDemandMet = false;
double loopcount = 1;

//traceln( " ");
//traceln( "starting demand: " + baseDemand_kW);
//traceln("Power request: " + requestedPower_kW);

while (! isDemandMet ) { // Loop door de treemap tot je requestedPower_kW bereikt
	//traceln( " ");
	//traceln( "loop " + loopcount + ", available Power: " + availablePower_kW);
	currentPowerRequestLevel_kW = roundToDecimal( availablePower_kW + baseDemand_kW, 5);
	//traceln("Current power request level = " + currentPowerRequestLevel_kW) ;
	
	addedPrice_eurpkWh = f_getElectricityPrice(currentPowerRequestLevel_kW);
	addedPower_kW = f_getAvailablePowerAtPrice(currentPowerRequestLevel_kW);
	//traceln("Added power " + addedPower_kW);
	
	if(addedPower_kW + availablePower_kW >= requestedPower_kW) {
		addedPower_kW = requestedPower_kW - availablePower_kW;
		price_eurph += addedPrice_eurpkWh * addedPower_kW;
		isDemandMet = true;
	} 
	else {
		availablePower_kW += addedPower_kW;
		price_eurph += addedPrice_eurpkWh * addedPower_kW;		
		loopcount += 1;
	}
	//traceln("price added " + addedPrice_eurpkWh);
}
//traceln("total price " + price_eurph);
//getEngine().pause();
traceln("Still using treemaps in f_getAveragedElectricityPrice!");

return price_eurph / requestedPower_kW;

 
  }

  
double 
 f_getMethanePrice(  ) { 

if ( v_methanePrice_eurpkWh == 0.0 ){
	throw new IllegalStateException("Missing methane contracts! No methane price available for this connection!");
}
return v_methanePrice_eurpkWh; 
  }

  
double 
 f_getHydrogenPrice(  ) { 

if ( v_hydrogenPrice_eurpkWh == 0.0 ){
	throw new IllegalStateException("Missing hydrogen contracts! No hydrogen price available for this connection!");
}
return v_hydrogenPrice_eurpkWh; 
  }

  public void f_resetStates(  ) { 

// Reset energytotals
//v_totalElectricityUsed_kWh = v_totalHeatUsed_kWh = v_totalMethaneUsed_kWh = v_totalHydrogenUsed_kWh = v_totalPetroleumFuelUsed_kWh = 0;
// Reset finances
//v_balanceElectricity_eur = v_balanceElectricityDelivery_eur = v_balanceElectricityTransport_eur = v_balanceElectricityTax_eur = 0;
 
  }

  void f_initialize(  ) { 

// What happens if this function is triggered multiple times per connectionOwner?
f_setContractValues();
f_connectToParentActor(); 
  }

  public 
ArrayList<GridConnection> 
 f_getOwnedGridConnections(  ) { 

return this.c_ownedGridConnections; 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea va_ConnectionOwner = new ViewArea( this, null, 0, 0, 1920, 980 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "va_ConnectionOwner", this.va_ConnectionOwner );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text12_Font = _text1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text13_Font = _text1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text14_Font = _text1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle5 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _text12 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _text13 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _text14 = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 6;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = zero_engine.Actor._SHAPE_NEXT_ID_xjal + 7;

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
	  level.addAll(line1, text1, rectangle5, text12, text13, text14);
  }

  protected ShapeLine line1;
  protected ShapeText text1;
  protected ShapeRectangle rectangle5;
  protected ShapeText text12;
  protected ShapeText text13;
  protected ShapeText text14;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    line1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 920.0, 60.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,950.0, 40.0, 0.0, 0.0,
        black,"Contracts",
        _text1_Font, ALIGNMENT_LEFT );
    rectangle5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,510.0, 630.0, 0.0, 0.0,
            silver, white,
			730.0, 189.967, 10.0, 2.0, LINE_STYLE_DASHED );
    text12 = new ShapeText(
        SHAPE_DRAW_2D, false,730.0, 660.0, 0.0, 0.0,
        gray,"Current consumption volumes",
        _text12_Font, ALIGNMENT_LEFT );
    text13 = new ShapeText(
        SHAPE_DRAW_2D, false,970.0, 660.0, 0.0, 0.0,
        gray,"Electricity financial accounting",
        _text13_Font, ALIGNMENT_LEFT );
    text14 = new ShapeText(
        SHAPE_DRAW_2D, false,540.0, 660.0, 0.0, 0.0,
        gray,"Total consumption",
        _text14_Font, ALIGNMENT_LEFT );
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
  public ConnectionOwner( Engine engine, Agent owner, AgentList<? extends ConnectionOwner> ownerPopulation ) {
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
  public ConnectionOwner() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public ConnectionOwner( String p_actorID, String p_actorGroup, String p_actorSubgroup, EnergyCoop p_coopParent, Actor p_electricitySupplier, Actor p_gridOperator, Actor p_methaneSupplier, Actor p_hydrogenSupplier, Actor p_heatSupplier, OL_ConnectionOwnerType p_connectionOwnerType, boolean p_detailedCompany, String p_energySupplierID, String p_energyCoopID, boolean b_dataSharingAgreed, boolean b_dataIsAccessible ) {
    super( p_actorID, p_actorGroup, p_actorSubgroup );
    this.p_coopParent = p_coopParent;
    this.p_electricitySupplier = p_electricitySupplier;
    this.p_gridOperator = p_gridOperator;
    this.p_methaneSupplier = p_methaneSupplier;
    this.p_hydrogenSupplier = p_hydrogenSupplier;
    this.p_heatSupplier = p_heatSupplier;
    this.p_connectionOwnerType = p_connectionOwnerType;
    this.p_detailedCompany = p_detailedCompany;
    this.p_energySupplierID = p_energySupplierID;
    this.p_energyCoopID = p_energyCoopID;
    this.b_dataSharingAgreed = b_dataSharingAgreed;
    this.b_dataIsAccessible = b_dataIsAccessible;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ConnectionOwner_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "zero_engine.ConnectionOwner.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ConnectionOwner.class );
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

energyModel.c_actors.add(this);
energyModel.c_connectionOwners.add(this); 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ConnectionOwner_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ConnectionOwner_xjal() {
    v_currentNodalPrice_eurpkWh = 
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

  public AgentList<? extends ConnectionOwner> getPopulation() {
    return (AgentList<? extends ConnectionOwner>) super.getPopulation();
  }

  public List<? extends ConnectionOwner> agentsInRange( double distance ) {
    return (List<? extends ConnectionOwner>) super.agentsInRange( distance );
  }


}
