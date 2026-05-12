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

public class Actor extends Agent
{
  // Parameters

  /**
   * Unique identifier of this actor in String format. Designated in Config-excel and used to link actors to netConnections.<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */
  public 
String  p_actorID;

  /**
   * Returns default value for parameter <code>p_actorID</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_actorID_DefaultValue_xjal() {
    final Actor self = this;
    return null;
  }

  public void set_p_actorID( String value ) {
    if (value == this.p_actorID) {
      return;
    }
    String _oldValue_xjal = this.p_actorID;
    this.p_actorID = value;
    onChange_p_actorID_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_actorID.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_actorID()</code> method instead.
   */
  protected void onChange_p_actorID() {
    onChange_p_actorID_xjal( p_actorID );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_actorID_xjal( String oldValue ) {  
  }


  /**
   * Actor type in OL_ActorType format. Designated in Config-excel and used to determine actor-type specific functionalities later.<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */
  public 
String  p_actorGroup;

  /**
   * Returns default value for parameter <code>p_actorGroup</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_actorGroup_DefaultValue_xjal() {
    final Actor self = this;
    return null;
  }

  public void set_p_actorGroup( String value ) {
    if (value == this.p_actorGroup) {
      return;
    }
    String _oldValue_xjal = this.p_actorGroup;
    this.p_actorGroup = value;
    onChange_p_actorGroup_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_actorGroup.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_actorGroup()</code> method instead.
   */
  protected void onChange_p_actorGroup() {
    onChange_p_actorGroup_xjal( p_actorGroup );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_actorGroup_xjal( String oldValue ) {  
  }


  /**
   * Actor type in OL_ActorType format. Designated in Config-excel and used to determine actor-type specific functionalities later.<br>
   * <br>
   * @since: Sprint 6<br>
   * @author: Gillis
   */
  public 
String  p_actorSubgroup;

  /**
   * Returns default value for parameter <code>p_actorSubgroup</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_actorSubgroup_DefaultValue_xjal() {
    final Actor self = this;
    return null;
  }

  public void set_p_actorSubgroup( String value ) {
    if (value == this.p_actorSubgroup) {
      return;
    }
    String _oldValue_xjal = this.p_actorSubgroup;
    this.p_actorSubgroup = value;
    onChange_p_actorSubgroup_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_actorSubgroup.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_actorSubgroup()</code> method instead.
   */
  protected void onChange_p_actorSubgroup() {
    onChange_p_actorSubgroup_xjal( p_actorSubgroup );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_actorSubgroup_xjal( String oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_actorID = _p_actorID_DefaultValue_xjal();
    p_actorGroup = _p_actorGroup_DefaultValue_xjal();
    p_actorSubgroup = _p_actorSubgroup_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_actorID":
      if ( _callOnChange_xjal ) {
        set_p_actorID( (String) _value_xjal );
      } else {
        p_actorID = (String) _value_xjal;
      }
      return true;
    case "p_actorGroup":
      if ( _callOnChange_xjal ) {
        set_p_actorGroup( (String) _value_xjal );
      } else {
        p_actorGroup = (String) _value_xjal;
      }
      return true;
    case "p_actorSubgroup":
      if ( _callOnChange_xjal ) {
        set_p_actorSubgroup( (String) _value_xjal );
      } else {
        p_actorSubgroup = (String) _value_xjal;
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
    case "p_actorID": _result_xjal = p_actorID; break;
    case "p_actorGroup": _result_xjal = p_actorGroup; break;
    case "p_actorSubgroup": _result_xjal = p_actorSubgroup; break;
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
      list.add( "p_actorID" );
      list.add( "p_actorGroup" );
      list.add( "p_actorSubgroup" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Actor.class );

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
  protected static final Font _text_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final int _line = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 2;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 3;

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
	  level.addAll(line, text);
  }

  protected ShapeLine line;
  protected ShapeText text;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 20.0, 40.0, 0.0, black,
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    text = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 20.0, 0.0, 0.0,
        black,"ID & connections",
        _text_Font, ALIGNMENT_LEFT );
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
  public Actor( Engine engine, Agent owner, AgentList<? extends Actor> ownerPopulation ) {
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
  public Actor() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public Actor( String p_actorID, String p_actorGroup, String p_actorSubgroup ) {
    markParametersAreSet();
    this.p_actorID = p_actorID;
    this.p_actorGroup = p_actorGroup;
    this.p_actorSubgroup = p_actorSubgroup;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_Actor_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Actor.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon = new ShapeModelElementsGroup( Actor.this, getElementProperty( "zero_engine.Actor.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
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
    setupInitialConditions_xjal( Actor.class );
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
    setupPlainVariables_Actor_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Actor_xjal() {
  }

  // User API -----------------------------------------------------
  public AgentList<? extends Actor> getPopulation() {
    return (AgentList<? extends Actor>) super.getPopulation();
  }

  public List<? extends Actor> agentsInRange( double distance ) {
    return (List<? extends Actor>) super.agentsInRange( distance );
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
