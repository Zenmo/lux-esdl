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

public class GCHouse extends zero_engine.GridConnection
{
  // Parameters

  public 
int  p_buildYear;

  /**
   * Returns default value for parameter <code>p_buildYear</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _p_buildYear_DefaultValue_xjal() {
    final GCHouse self = this;
    return 0;
  }

  public void set_p_buildYear( int value ) {
    if (value == this.p_buildYear) {
      return;
    }
    int _oldValue_xjal = this.p_buildYear;
    this.p_buildYear = value;
    onChange_p_buildYear_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_buildYear.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_buildYear()</code> method instead.
   */
  protected void onChange_p_buildYear() {
    onChange_p_buildYear_xjal( p_buildYear );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_buildYear_xjal( int oldValue ) {  
  }


  public 
boolean  p_eigenOprit;

  /**
   * Returns default value for parameter <code>p_eigenOprit</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _p_eigenOprit_DefaultValue_xjal() {
    final GCHouse self = this;
    return false;
  }

  public void set_p_eigenOprit( boolean value ) {
    if (value == this.p_eigenOprit) {
      return;
    }
    boolean _oldValue_xjal = this.p_eigenOprit;
    this.p_eigenOprit = value;
    onChange_p_eigenOprit_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_eigenOprit.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_eigenOprit()</code> method instead.
   */
  protected void onChange_p_eigenOprit() {
    onChange_p_eigenOprit_xjal( p_eigenOprit );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_eigenOprit_xjal( boolean oldValue ) {  
  }


  public 
OL_HouseholdCookingMethod  p_cookingMethod;

  /**
   * Returns default value for parameter <code>p_cookingMethod</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_HouseholdCookingMethod _p_cookingMethod_DefaultValue_xjal() {
    final GCHouse self = this;
    return 
OL_HouseholdCookingMethod.NONE 
;
  }

  public void set_p_cookingMethod( OL_HouseholdCookingMethod value ) {
    if (value == this.p_cookingMethod) {
      return;
    }
    OL_HouseholdCookingMethod _oldValue_xjal = this.p_cookingMethod;
    this.p_cookingMethod = value;
    onChange_p_cookingMethod_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_cookingMethod.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_cookingMethod()</code> method instead.
   */
  protected void onChange_p_cookingMethod() {
    onChange_p_cookingMethod_xjal( p_cookingMethod );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_cookingMethod_xjal( OL_HouseholdCookingMethod oldValue ) {  
  }


  public 
J_PBLParameters  p_PBLParameters;

  /**
   * Returns default value for parameter <code>p_PBLParameters</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public J_PBLParameters _p_PBLParameters_DefaultValue_xjal() {
    final GCHouse self = this;
    return null;
  }

  public void set_p_PBLParameters( J_PBLParameters value ) {
    if (value == this.p_PBLParameters) {
      return;
    }
    J_PBLParameters _oldValue_xjal = this.p_PBLParameters;
    this.p_PBLParameters = value;
    onChange_p_PBLParameters_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_PBLParameters.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_PBLParameters()</code> method instead.
   */
  protected void onChange_p_PBLParameters() {
    onChange_p_PBLParameters_xjal( p_PBLParameters );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_PBLParameters_xjal( J_PBLParameters oldValue ) {  
  }



















  /**
   * A Java class that contains all the relevant information about the grid connection address. The class contains a method .getAddress() which returns a formatted String of the address.
   */






  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_buildYear = _p_buildYear_DefaultValue_xjal();
    p_eigenOprit = _p_eigenOprit_DefaultValue_xjal();
    p_cookingMethod = _p_cookingMethod_DefaultValue_xjal();
    p_PBLParameters = _p_PBLParameters_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_buildYear":
      if ( _callOnChange_xjal ) {
        set_p_buildYear( ((Number) _value_xjal).intValue() );
      } else {
        p_buildYear = ((Number) _value_xjal).intValue();
      }
      return true;
    case "p_eigenOprit":
      if ( _callOnChange_xjal ) {
        set_p_eigenOprit( (Boolean) _value_xjal );
      } else {
        p_eigenOprit = (Boolean) _value_xjal;
      }
      return true;
    case "p_cookingMethod":
      if ( _callOnChange_xjal ) {
        set_p_cookingMethod( (OL_HouseholdCookingMethod) _value_xjal );
      } else {
        p_cookingMethod = (OL_HouseholdCookingMethod) _value_xjal;
      }
      return true;
    case "p_PBLParameters":
      if ( _callOnChange_xjal ) {
        set_p_PBLParameters( (J_PBLParameters) _value_xjal );
      } else {
        p_PBLParameters = (J_PBLParameters) _value_xjal;
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
    case "p_buildYear": _result_xjal = p_buildYear; break;
    case "p_eigenOprit": _result_xjal = p_eigenOprit; break;
    case "p_cookingMethod": _result_xjal = p_cookingMethod; break;
    case "p_PBLParameters": _result_xjal = p_PBLParameters; break;
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
      list.add( "p_buildYear" );
      list.add( "p_eigenOprit" );
      list.add( "p_cookingMethod" );
      list.add( "p_PBLParameters" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( GCHouse.class );

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

  public void f_operateFlexAssets_overwrite( J_TimeVariables timeVariables ) { 

f_manageCookingTracker(timeVariables);
//f_manageAirco(timeVariables);
super.f_operateFlexAssets(timeVariables); 
  }

  protected void f_manageCookingTracker( J_TimeVariables timeVariables ) { 

// Add heat from cooking assets to house
if (p_cookingTracker != null) { // check for presence of cooking asset
	p_cookingTracker.manageActivities(timeVariables); // also calls f_updateAllFlows in HOB asset	
	
	double residualHeatGasPit_kW = -p_cookingTracker.HOB.getLastFlows().get(OL_EnergyCarriers.HEAT);
	throw new RuntimeException("Cooking trackers and HOBs are not properly integrated with current heating management!");
	/*if (p_BuildingThermalAsset != null) {
		p_BuildingThermalAsset.v_powerFraction_fr += residualHeatGasPit_kW / p_BuildingThermalAsset.getCapacityHeat_kW(); // Does this work out correctly with new heatingManagement structure??
	}*/
} 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = zero_engine.GridConnection._SHAPE_NEXT_ID_xjal + 1;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return super.isPublicPresentationDefined() || false;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll();
  }

  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
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
  public GCHouse( Engine engine, Agent owner, AgentList<? extends GCHouse> ownerPopulation ) {
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
  public GCHouse() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public GCHouse( String p_parentNodeElectricID, String p_gridConnectionID, String p_parentNodeHeatID, J_EABuilding p_BuildingThermalAsset, String p_ownerID, J_EAStorageElectric p_batteryAsset, J_EAStorageHeat p_heatBuffer, J_EAStorageGas p_gasBuffer, J_ActivityTrackerCooking p_cookingTracker, OL_GridConnectionInsulationLabel p_insulationLabel, J_EAProfile p_DHWAsset, double p_longitude, double p_latitude, double p_floorSurfaceArea_m2, ConnectionOwner p_owner, double p_roofSurfaceArea_m2, String p_purposeBAG, J_Address p_address, GridNode p_parentNodeHeat, GridNode p_parentNodeElectric, boolean v_isActive, OL_GridConnectionEnergyLabel p_energyLabel, J_EAConversionAirConditioner p_airco, int p_buildYear, boolean p_eigenOprit, OL_HouseholdCookingMethod p_cookingMethod, J_PBLParameters p_PBLParameters ) {
    super( p_parentNodeElectricID, p_gridConnectionID, p_parentNodeHeatID, p_BuildingThermalAsset, p_ownerID, p_batteryAsset, p_heatBuffer, p_gasBuffer, p_cookingTracker, p_insulationLabel, p_DHWAsset, p_longitude, p_latitude, p_floorSurfaceArea_m2, p_owner, p_roofSurfaceArea_m2, p_purposeBAG, p_address, p_parentNodeHeat, p_parentNodeElectric, v_isActive, p_energyLabel, p_airco );
    this.p_buildYear = p_buildYear;
    this.p_eigenOprit = p_eigenOprit;
    this.p_cookingMethod = p_cookingMethod;
    this.p_PBLParameters = p_PBLParameters;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_GCHouse_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "zero_engine.GCHouse.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( GCHouse.class );
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
    setupPlainVariables_GCHouse_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_GCHouse_xjal() {
  }

  // User API -----------------------------------------------------
  public EnergyModel get_EnergyModel() {
    {
      Agent owner = getOwner();
      if ( owner instanceof EnergyModel ) return (EnergyModel) owner;
    }
    return null;
  }

  public AgentList<? extends GCHouse> getPopulation() {
    return (AgentList<? extends GCHouse>) super.getPopulation();
  }

  public List<? extends GCHouse> agentsInRange( double distance ) {
    return (List<? extends GCHouse>) super.agentsInRange( distance );
  }

  // Additional class code

@Override
public void f_operateFlexAssets(J_TimeVariables timeVariables){
	f_operateFlexAssets_overwrite(timeVariables);
}
 
  // End of additional class code

}
