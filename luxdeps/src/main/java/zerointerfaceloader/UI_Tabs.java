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

public class UI_Tabs extends Agent
{
  // Parameters
  // Plain Variables

  private 
List<GridConnection> 
 v_activeSliderGridConnections;
  private 
List<GridConnection> 
 v_pausedSliderGridConnections;
  public 
OL_CustomScenarioTabs 
 v_selectedTabType;
  public 
double 
 v_presentationXOffset;
  public 
double 
 v_presentationYOffset;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( UI_Tabs.class );

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
  private static final AgentAnimationSettings _pop_tabMobility_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _pop_tabElectricity_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _pop_tabHeating_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _pop_tabEHub_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);

  public String getNameOf( Agent ao ) {
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    return super.getAnimationSettingsOf( ao );
  }

  public class _pop_tabMobility_Population extends AgentArrayList<tabMobility> {
    _pop_tabMobility_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public tabMobility instantiateAgent( int index ) {
    	return instantiate_pop_tabMobility_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( tabMobility agent, int index, TableInput tableInput ) {
      setupParameters_pop_tabMobility_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( tabMobility agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_tabMobility_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "tabMobility")
  public _pop_tabMobility_Population pop_tabMobility = new _pop_tabMobility_Population( this );
  public class _pop_tabElectricity_Population extends AgentArrayList<tabElectricity> {
    _pop_tabElectricity_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public tabElectricity instantiateAgent( int index ) {
    	return instantiate_pop_tabElectricity_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( tabElectricity agent, int index, TableInput tableInput ) {
      setupParameters_pop_tabElectricity_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( tabElectricity agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_tabElectricity_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "tabElectricity")
  public _pop_tabElectricity_Population pop_tabElectricity = new _pop_tabElectricity_Population( this );
  public class _pop_tabHeating_Population extends AgentArrayList<tabHeating> {
    _pop_tabHeating_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public tabHeating instantiateAgent( int index ) {
    	return instantiate_pop_tabHeating_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( tabHeating agent, int index, TableInput tableInput ) {
      setupParameters_pop_tabHeating_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( tabHeating agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_tabHeating_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "tabHeating")
  public _pop_tabHeating_Population pop_tabHeating = new _pop_tabHeating_Population( this );
  public class _pop_tabEHub_Population extends AgentArrayList<tabEHub> {
    _pop_tabEHub_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public tabEHub instantiateAgent( int index ) {
    	return instantiate_pop_tabEHub_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( tabEHub agent, int index, TableInput tableInput ) {
      setupParameters_pop_tabEHub_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( tabEHub agent, int index, TableInput tableInput ) {
      doBeforeCreate_pop_tabEHub_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "tabEHub")
  public _pop_tabEHub_Population pop_tabEHub = new _pop_tabEHub_Population( this );

  public String getNameOf( AgentList<?> aolist ) {
    if( aolist == pop_tabMobility ) return "pop_tabMobility";
    if( aolist == pop_tabElectricity ) return "pop_tabElectricity";
    if( aolist == pop_tabHeating ) return "pop_tabHeating";
    if( aolist == pop_tabEHub ) return "pop_tabEHub";
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    if( aolist == pop_tabMobility ) return _pop_tabMobility_animationSettings_xjal;
    if( aolist == pop_tabElectricity ) return _pop_tabElectricity_animationSettings_xjal;
    if( aolist == pop_tabHeating ) return _pop_tabHeating_animationSettings_xjal;
    if( aolist == pop_tabEHub ) return _pop_tabEHub_animationSettings_xjal;
    return super.getAnimationSettingsOf( aolist );
  }

  /**
   * Returns the agent element at the specified position in pop_tabMobility
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public tabMobility pop_tabMobility(int index) {
    return pop_tabMobility.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_tabMobility<br>
   * @return newly created embedded object
   */
  public tabMobility add_pop_tabMobility() {
    int index = pop_tabMobility.size();
    tabMobility _result_xjal = instantiate_pop_tabMobility_xjal( index );
    pop_tabMobility.callSetupParameters( _result_xjal, index );
    pop_tabMobility.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_tabMobility<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_tabMobility - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_tabMobility
   */
  public boolean remove_pop_tabMobility( tabMobility object ) {
    if( ! pop_tabMobility._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_tabElectricity
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public tabElectricity pop_tabElectricity(int index) {
    return pop_tabElectricity.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_tabElectricity<br>
   * @return newly created embedded object
   */
  public tabElectricity add_pop_tabElectricity() {
    int index = pop_tabElectricity.size();
    tabElectricity _result_xjal = instantiate_pop_tabElectricity_xjal( index );
    pop_tabElectricity.callSetupParameters( _result_xjal, index );
    pop_tabElectricity.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_tabElectricity<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>pop_tabElectricity.size()</code> method <strong>before</strong> this method is called
   * @param p_currentPVOnLand_ha
   * @param p_currentWindTurbines_MW
   * @param p_currentTotalGridBatteryCapacity_MWh
   * @return newly created embedded object
   */
  public tabElectricity add_pop_tabElectricity( double p_currentPVOnLand_ha, double p_currentWindTurbines_MW, double p_currentTotalGridBatteryCapacity_MWh ) {
    int index = pop_tabElectricity.size();
    tabElectricity _result_xjal = instantiate_pop_tabElectricity_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.p_currentPVOnLand_ha = p_currentPVOnLand_ha;
    _result_xjal.p_currentWindTurbines_MW = p_currentWindTurbines_MW;
    _result_xjal.p_currentTotalGridBatteryCapacity_MWh = p_currentTotalGridBatteryCapacity_MWh;
    // Finish embedded object creation
    pop_tabElectricity.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_tabElectricity<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_tabElectricity - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_tabElectricity
   */
  public boolean remove_pop_tabElectricity( tabElectricity object ) {
    if( ! pop_tabElectricity._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_tabHeating
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public tabHeating pop_tabHeating(int index) {
    return pop_tabHeating.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_tabHeating<br>
   * @return newly created embedded object
   */
  public tabHeating add_pop_tabHeating() {
    int index = pop_tabHeating.size();
    tabHeating _result_xjal = instantiate_pop_tabHeating_xjal( index );
    pop_tabHeating.callSetupParameters( _result_xjal, index );
    pop_tabHeating.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_tabHeating<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_tabHeating - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_tabHeating
   */
  public boolean remove_pop_tabHeating( tabHeating object ) {
    if( ! pop_tabHeating._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in pop_tabEHub
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public tabEHub pop_tabEHub(int index) {
    return pop_tabEHub.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection pop_tabEHub<br>
   * @return newly created embedded object
   */
  public tabEHub add_pop_tabEHub() {
    int index = pop_tabEHub.size();
    tabEHub _result_xjal = instantiate_pop_tabEHub_xjal( index );
    pop_tabEHub.callSetupParameters( _result_xjal, index );
    pop_tabEHub.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection pop_tabEHub<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object pop_tabEHub - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to pop_tabEHub
   */
  public boolean remove_pop_tabEHub( tabEHub object ) {
    if( ! pop_tabEHub._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected tabMobility instantiate_pop_tabMobility_xjal( final int index ) {
    tabMobility _result_xjal = new tabMobility( getEngine(), this, pop_tabMobility );
    
    pop_tabMobility._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_tabMobility_xjal( final tabMobility self, final int index, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_tabMobility_xjal( tabMobility self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 0.0
;
double _y_xjal = 0.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected tabElectricity instantiate_pop_tabElectricity_xjal( final int index ) {
    tabElectricity _result_xjal = new tabElectricity( getEngine(), this, pop_tabElectricity );
    
    pop_tabElectricity._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_tabElectricity_xjal( final tabElectricity self, final int index, TableInput _t ) {
    self.p_currentPVOnLand_ha = self._p_currentPVOnLand_ha_DefaultValue_xjal();
    self.p_currentWindTurbines_MW = self._p_currentWindTurbines_MW_DefaultValue_xjal();
    self.p_currentTotalGridBatteryCapacity_MWh = self._p_currentTotalGridBatteryCapacity_MWh_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_tabElectricity_xjal( tabElectricity self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 0.0
;
double _y_xjal = 0.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected tabHeating instantiate_pop_tabHeating_xjal( final int index ) {
    tabHeating _result_xjal = new tabHeating( getEngine(), this, pop_tabHeating );
    
    pop_tabHeating._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_tabHeating_xjal( final tabHeating self, final int index, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_tabHeating_xjal( tabHeating self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 0.0
;
double _y_xjal = 0.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected tabEHub instantiate_pop_tabEHub_xjal( final int index ) {
    tabEHub _result_xjal = new tabEHub( getEngine(), this, pop_tabEHub );
    
    pop_tabEHub._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pop_tabEHub_xjal( final tabEHub self, final int index, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pop_tabEHub_xjal( tabEHub self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 0.0
;
double _y_xjal = 0.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }

  // Functions

  public void f_showCorrectTab(  ) { 

pop_tabElectricity_presentation.setVisible(false);
pop_tabHeating_presentation.setVisible(false);
pop_tabMobility_presentation.setVisible(false);
pop_tabEHub_presentation.setVisible(false);

switch (v_selectedTabType) {
	case ELECTRICITY:
		pop_tabElectricity_presentation.setVisible(true);
		break;
	case HEAT:
		pop_tabHeating_presentation.setVisible(true);
		break;
	case MOBILITY:
		pop_tabMobility_presentation.setVisible(true);
		break;
	case HUB:
	case NFATO:
		pop_tabEHub_presentation.setVisible(true);
		break;
}
 
  }

  public void f_setTab( OL_CustomScenarioTabs tab ) { 

v_selectedTabType = tab;
f_showCorrectTab();
 
  }

  void f_initializeSliderGCPointers( List<GridConnection> activeGridConnections, List<GridConnection> pausedGridConnections ) { 

if(activeGridConnections != null){
	v_activeSliderGridConnections = activeGridConnections;
}
else{
	v_activeSliderGridConnections = new ArrayList<>();
	traceln("WARNING: UI_TABS HAS BEEN INITIALIZED WITH NO ACTIVE GC");
}

if(pausedGridConnections != null){
	v_pausedSliderGridConnections = pausedGridConnections;
}
else{
	v_pausedSliderGridConnections = new ArrayList<>();
} 
  }

  void f_initializeUI_Tabs( List<GridConnection> activeGridConnections, List<GridConnection> pausedGridConnections, List<GridConnection> electricityTabEASliderGCs ) { 

//Initialize the GridConnections
f_initializeSliderGCPointers(activeGridConnections, pausedGridConnections);

//Initialize the tabs
f_initializeActiveTabs(electricityTabEASliderGCs);

//Set sliders to engine state of the gridconnections
f_updateSliders();

//Show correct tab
f_showCorrectTab(); 
  }

  public 
List<GCHouse> 
 f_getActiveSliderGridConnections_houses(  ) { 

List<GCHouse> houseGridConnections = new ArrayList<>();

for(GridConnection GC : v_activeSliderGridConnections){
	if(GC instanceof GCHouse){
		houseGridConnections.add((GCHouse)GC);		
	}
}

return houseGridConnections; 
  }

  public 
List<GCUtility> 
 f_getActiveSliderGridConnections_utilities(  ) { 

List<GCUtility> utilityGridConnections = new ArrayList<>();

for(GridConnection GC : v_activeSliderGridConnections){
	if(GC instanceof GCUtility){
		utilityGridConnections.add((GCUtility)GC);
	}
}

return utilityGridConnections; 
  }

  public 
List<GCGridBattery> 
 f_getAllSliderGridConnections_gridBatteries(  ) { 

List<GCGridBattery> gridBatteryGridConnections = new ArrayList<>();

for(GridConnection GC : v_activeSliderGridConnections){
	if(GC instanceof GCGridBattery){
		gridBatteryGridConnections.add((GCGridBattery)GC);		
	}
}
if(v_pausedSliderGridConnections != null){
	for(GridConnection GC : v_pausedSliderGridConnections){
		if(GC instanceof GCGridBattery){
			gridBatteryGridConnections.add((GCGridBattery)GC);
		}
	}
}
return gridBatteryGridConnections; 
  }

  public 
List<GCPublicCharger> 
 f_getSliderGridConnections_chargers(  ) { 

List<GCPublicCharger> chargerGridConnections = new ArrayList<>();

for(GridConnection GC : v_activeSliderGridConnections){
	if(GC instanceof GCPublicCharger){
		chargerGridConnections.add((GCPublicCharger)GC);		
	}
}

return chargerGridConnections; 
  }

  public 
List<GCEnergyProduction> 
 f_getAllSliderGridConnections_production(  ) { 

List<GCEnergyProduction> productionGridConnections = new ArrayList<>();

for(GridConnection GC : v_activeSliderGridConnections){
	if(GC instanceof GCEnergyProduction){
		productionGridConnections.add((GCEnergyProduction)GC);
	}
}
if(v_pausedSliderGridConnections != null){
	for(GridConnection GC : v_pausedSliderGridConnections){
		if(GC instanceof GCEnergyProduction){
			productionGridConnections.add((GCEnergyProduction)GC);
		}
	}
}
return productionGridConnections; 
  }

  void f_updateSliders(  ) { 

if(!pop_tabElectricity.isEmpty()){
	pop_tabElectricity.get(0).f_updateSliders_Electricity();
}
if(!pop_tabHeating.isEmpty()){
	pop_tabHeating.get(0).f_updateSliders_Heating();
}
if(!pop_tabMobility.isEmpty()){
	pop_tabMobility.get(0).f_updateSliders_Mobility();
}
if(!pop_tabEHub.isEmpty()){
	pop_tabEHub.get(0).f_updateSliders_EHub();
} 
  }

  public 
List<GridConnection> 
 f_getActiveSliderGridConnections_consumption(  ) { 

List<GridConnection> consumptionGridConnections = new ArrayList<>();

for(GridConnection GC : v_activeSliderGridConnections){
	if(GC instanceof GCUtility){
		consumptionGridConnections.add(GC);
	}
	else if(GC instanceof GCHouse){
		consumptionGridConnections.add(GC);
	}
}

return consumptionGridConnections; 
  }

  public 
List<GridConnection> 
 f_getActiveSliderGridConnections_all(  ) { 

List<GridConnection> gridConnections = new ArrayList<>(v_activeSliderGridConnections);

return gridConnections; 
  }

  public 
List<GCPublicCharger> 
 f_getPausedSliderGridConnections_chargers(  ) { 

List<GCPublicCharger> pausedChargerGridConnections = new ArrayList<>();

if(v_pausedSliderGridConnections != null){
	for(GridConnection GC : v_pausedSliderGridConnections){
		if(GC instanceof GCPublicCharger){
			pausedChargerGridConnections.add((GCPublicCharger)GC);		
		}
	}
}

return pausedChargerGridConnections; 
  }

  void f_initializeActiveTabs( List<GridConnection> electricityTabEASliderGCs ) { 

if(!pop_tabElectricity.isEmpty()){
	pop_tabElectricity.get(0).f_initializeTab_Electricity(electricityTabEASliderGCs);
}
if(!pop_tabHeating.isEmpty()){
	//pop_tabHeating.get(0).f_initializeTab_Heating();
}
if(!pop_tabMobility.isEmpty()){
	pop_tabMobility.get(0).f_initializeTab_Mobility();
}
if(!pop_tabEHub.isEmpty()){
	//pop_tabEHub.get(0).f_initializeTab_EHub();
} 
  }

  public 
List<GCPublicCharger> 
 f_getAllSliderGridConnections_chargers(  ) { 

List<GCPublicCharger> chargerGridConnections = new ArrayList<>();

for(GridConnection GC : v_activeSliderGridConnections){
	if(GC instanceof GCPublicCharger){
		chargerGridConnections.add((GCPublicCharger)GC);		
	}
}
if(v_pausedSliderGridConnections != null){
	for(GridConnection GC : v_pausedSliderGridConnections){
		if(GC instanceof GCPublicCharger){
			chargerGridConnections.add((GCPublicCharger)GC);		
		}
	}
}

return chargerGridConnections; 
  }

  public 
List<GridConnection> 
 f_getAllSliderGridConnections_consumption(  ) { 

List<GridConnection> consumptionGridConnections = new ArrayList<>();

for(GridConnection GC : v_activeSliderGridConnections){
	if(GC instanceof GCUtility){
		consumptionGridConnections.add(GC);
	}
	else if(GC instanceof GCHouse){
		consumptionGridConnections.add(GC);
	}
}

for(GridConnection GC : v_pausedSliderGridConnections){
	if(GC instanceof GCUtility){
		consumptionGridConnections.add(GC);
	}
	else if(GC instanceof GCHouse){
		consumptionGridConnections.add(GC);
	}
}

return consumptionGridConnections; 
  }

  public 
List<GridConnection> 
 f_getPausedSliderGridConnections_all(  ) { 

List<GridConnection> gridConnections = new ArrayList<>(v_activeSliderGridConnections);

return gridConnections; 
  }

  public 
List<GridConnection> 
 f_getAllSliderGridConnections_all(  ) { 

List<GridConnection> gridConnections = new ArrayList<>(v_activeSliderGridConnections);
gridConnections.addAll(v_pausedSliderGridConnections);

return gridConnections; 
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
  protected static final Font _txt_electricityButtonDescription_Font = new Font("Calibri", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_heatButtonDescription_Font = _txt_electricityButtonDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mobilityButtonDescription_Font = _txt_electricityButtonDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_eHubButtonDescription_Font = _txt_electricityButtonDescription_Font;
  protected static final Color _ovalTransportButton_Fill_Color = new Color( 0xFFD7EFF2, true );
  protected static final Color _ovalHubButton_Fill_Color = new Color( 0xFFC6FBC6, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalElectricityButton = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _image3 = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_electricityButton = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalHeatButton = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _image10 = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_heatButton = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalTransportButton = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _image15 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_mobilityButton = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalHubButton = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _line2 = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval1 = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _line3 = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval4 = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval3 = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_eHubButton = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_electricityButtonDescription = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_heatButtonDescription = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mobilityButtonDescription = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_eHubButtonDescription = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_energyDemandSettings = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _pop_tabElectricity_presentation = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_tabElectricity_presentation = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _pop_tabHeating_presentation = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_tabHeating_presentation = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _pop_tabEHub_presentation = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_tabEHub_presentation = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _pop_tabMobility_presentation = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_tabMobility_presentation = 32;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 33;

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
	  level.addAll(gr_energyDemandSettings, gr_tabElectricity_presentation, gr_tabHeating_presentation, gr_tabEHub_presentation, gr_tabMobility_presentation);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _gr_electricityButton:
        if (true) {
          ShapeGroup self = this.gr_electricityButton;
          
f_setTab(OL_CustomScenarioTabs.ELECTRICITY); 
        }
        break;
      case _gr_heatButton:
        if (true) {
          ShapeGroup self = this.gr_heatButton;
          
f_setTab(OL_CustomScenarioTabs.HEAT); 
        }
        break;
      case _gr_mobilityButton:
        if (true) {
          ShapeGroup self = this.gr_mobilityButton;
          
f_setTab(OL_CustomScenarioTabs.MOBILITY); 
        }
        break;
      case _gr_eHubButton:
        if (true) {
          ShapeGroup self = this.gr_eHubButton;
          
f_setTab(OL_CustomScenarioTabs.HUB); 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  protected ShapeOval ovalElectricityButton;
  protected ShapeImage image3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_electricityButton_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
!pop_tabElectricity.isEmpty() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeGroup gr_electricityButton;
  protected ShapeOval ovalHeatButton;
  protected ShapeImage image10;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_heatButton_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
!pop_tabHeating.isEmpty() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeGroup gr_heatButton;
  protected ShapeOval ovalTransportButton;
  protected ShapeImage image15;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_mobilityButton_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
!pop_tabMobility.isEmpty() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeGroup gr_mobilityButton;
  protected ShapeOval ovalHubButton;
  protected ShapeLine line;
  protected ShapeLine line1;
  protected ShapeLine line2;
  protected ShapeOval oval;
  protected ShapeOval oval1;
  protected ShapeLine line3;
  protected ShapeOval oval4;
  protected ShapeOval oval3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_eHubButton_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
!pop_tabEHub.isEmpty() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeGroup gr_eHubButton;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_electricityButtonDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
gr_electricityButton.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_electricityButtonDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_heatButtonDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
gr_heatButton.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_heatButtonDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_mobilityButtonDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
gr_mobilityButton.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_mobilityButtonDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_eHubButtonDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
gr_eHubButton.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_eHubButtonDescription;
  protected ShapeGroup gr_energyDemandSettings;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _pop_tabElectricity_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, _a );
    return shape;
  }

  protected ShapeAgentPopulationGroup pop_tabElectricity_presentation;
  protected ShapeGroup gr_tabElectricity_presentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _pop_tabHeating_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, _a );
    return shape;
  }

  protected ShapeAgentPopulationGroup pop_tabHeating_presentation;
  protected ShapeGroup gr_tabHeating_presentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _pop_tabEHub_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, _a );
    return shape;
  }

  protected ShapeAgentPopulationGroup pop_tabEHub_presentation;
  protected ShapeGroup gr_tabEHub_presentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _pop_tabMobility_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, _a );
    return shape;
  }

  protected ShapeAgentPopulationGroup pop_tabMobility_presentation;
  protected ShapeGroup gr_tabMobility_presentation;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    ovalElectricityButton = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       whiteSmoke, lightYellow,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    image3 = new ShapeImage(
		UI_Tabs.this, SHAPE_DRAW_2D3D, true, -14.0, -12.0, 0.0, 0.0,
28.0, 24.0, "/zerointerfaceloader/",
			new String[]{"noun-electricity-3408805.png",} );
    ovalHeatButton = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       whiteSmoke, mistyRose,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    image10 = new ShapeImage(
		UI_Tabs.this, SHAPE_DRAW_2D3D, true, -14.0, -12.0, 0.0, 0.0,
28.0, 24.0, "/zerointerfaceloader/",
			new String[]{"noun-fire-2429630.png",} );
    ovalTransportButton = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       whiteSmoke, _ovalTransportButton_Fill_Color,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    image15 = new ShapeImage(
		UI_Tabs.this, SHAPE_DRAW_2D3D, true, -14.0, -12.0, 0.0, 0.0,
28.0, 24.0, "/zerointerfaceloader/",
			new String[]{"noun-car-1777731.png",} );
    ovalHubButton = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       whiteSmoke, _ovalHubButton_Fill_Color,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -10.0, -7.0, 0.0, black,
 		20.0,	-2.0, 0.0, 1.5, 10.0, LINE_STYLE_SOLID );
    line1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -6.0, 6.0, 0.0, black,
 		16.0,	-15.0, 0.0, 1.5, 10.0, LINE_STYLE_SOLID );
    line2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -10.0, -4.0, 0.0, black,
 		18.0,	15.0, 0.0, 1.5, 10.0, LINE_STYLE_SOLID );
    oval = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-11.0, -6.0, 0.0, 0.0,
       black, whiteSmoke,
	   3.0, 3.0, 10.0, 1.0, LINE_STYLE_SOLID );
    oval1 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-8.0, 8.0, 0.0, 0.0,
       black, whiteSmoke,
	   3.0, 3.0, 10.0, 1.0, LINE_STYLE_SOLID );
    line3 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 8.0, 10.0, 0.0, black,
 		1.0,	-17.0, 0.0, 1.0, 10.0, LINE_STYLE_DOTTED );
    oval4 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,8.0, 10.0, 0.0, 0.0,
       black, whiteSmoke,
	   3.0, 3.0, 10.0, 1.0, LINE_STYLE_SOLID );
    oval3 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,10.0, -9.0, 0.0, 0.0,
       black, whiteSmoke,
	   3.0, 3.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_electricityButtonDescription = new ShapeText(
        SHAPE_DRAW_2D, true,-125.0, 10.0, 0.0, 0.0,
        black,"Elektriciteit",
        _txt_electricityButtonDescription_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_electricityButtonDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_heatButtonDescription = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, 10.0, 0.0, 0.0,
        black,"Warmte",
        _txt_heatButtonDescription_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_heatButtonDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_mobilityButtonDescription = new ShapeText(
        SHAPE_DRAW_2D, true,45.0, 10.0, 0.0, 0.0,
        black,"Transport",
        _txt_mobilityButtonDescription_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_mobilityButtonDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_eHubButtonDescription = new ShapeText(
        SHAPE_DRAW_2D, true,130.0, 10.0, 0.0, 0.0,
        black,"E-hub",
        _txt_eHubButtonDescription_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_eHubButtonDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_electricityButton = new ShapeGroup( UI_Tabs.this, SHAPE_DRAW_2D3D, true, -125.0, -25.0, 0.0, 0.0
	
	     , ovalElectricityButton
	     , image3 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_electricityButton_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_electricityButton, 0, clickx, clicky );
      }
    };
    }
    {
    gr_heatButton = new ShapeGroup( UI_Tabs.this, SHAPE_DRAW_2D3D, true, -40.0, -25.0, 0.0, 0.0
	
	     , ovalHeatButton
	     , image10 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_heatButton_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_heatButton, 0, clickx, clicky );
      }
    };
    }
    {
    gr_mobilityButton = new ShapeGroup( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 45.0, -25.0, 0.0, 0.0
	
	     , ovalTransportButton
	     , image15 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_mobilityButton_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_mobilityButton, 0, clickx, clicky );
      }
    };
    }
    {
    gr_eHubButton = new ShapeGroup( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 130.0, -25.0, 0.0, 0.0
	
	     , ovalHubButton
	     , line
	     , line1
	     , line2
	     , oval
	     , oval1
	     , line3
	     , oval4
	     , oval3 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_eHubButton_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_eHubButton, 0, clickx, clicky );
      }
    };
    }
    {
    gr_energyDemandSettings = new ShapeGroup( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 200.0, 580.0, 0.0, 0.0
	
	     , gr_electricityButton
	     , gr_heatButton
	     , gr_mobilityButton
	     , gr_eHubButton
	     , txt_electricityButtonDescription
	     , txt_heatButtonDescription
	     , txt_mobilityButtonDescription
	     , txt_eHubButtonDescription );
    }
    pop_tabElectricity_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, pop_tabElectricity) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _pop_tabElectricity_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
    };
    {
    gr_tabElectricity_presentation = new ShapeGroup( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 15.0, 630.0, 0.0, 0.0
	
	     , pop_tabElectricity_presentation );
    }
    pop_tabHeating_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, pop_tabHeating) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _pop_tabHeating_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
    };
    {
    gr_tabHeating_presentation = new ShapeGroup( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 15.0, 630.0, 0.0, 0.0
	
	     , pop_tabHeating_presentation );
    }
    pop_tabEHub_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, pop_tabEHub) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _pop_tabEHub_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
    };
    {
    gr_tabEHub_presentation = new ShapeGroup( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 15.0, 630.0, 0.0, 0.0
	
	     , pop_tabEHub_presentation );
    }
    pop_tabMobility_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, pop_tabMobility) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _pop_tabMobility_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
    };
    {
    gr_tabMobility_presentation = new ShapeGroup( UI_Tabs.this, SHAPE_DRAW_2D3D, true, 15.0, 630.0, 0.0, 0.0
	
	     , pop_tabMobility_presentation );
    }
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
  public UI_Tabs( Engine engine, Agent owner, AgentList<? extends UI_Tabs> ownerPopulation ) {
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
    zero_Interface = get_Zero_Interface();
    uI_EnergyHub = get_UI_EnergyHub();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public UI_Tabs() {
  }

  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
    {
      int _cnt = 
0 
;
      for ( int i = pop_tabMobility.size(); i < _cnt; i++ ) {
        instantiate_pop_tabMobility_xjal( i );
      }
    }
    {
      int _cnt = 
0 
;
      for ( int i = pop_tabElectricity.size(); i < _cnt; i++ ) {
        instantiate_pop_tabElectricity_xjal( i );
      }
    }
    {
      int _cnt = 
0 
;
      for ( int i = pop_tabHeating.size(); i < _cnt; i++ ) {
        instantiate_pop_tabHeating_xjal( i );
      }
    }
    {
      int _cnt = 
0 
;
      for ( int i = pop_tabEHub.size(); i < _cnt; i++ ) {
        instantiate_pop_tabEHub_xjal( i );
      }
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_UI_Tabs_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( UI_Tabs.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( UI_Tabs.this, getElementProperty( "zerointerfaceloader.UI_Tabs.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
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
    pop_tabMobility.setEnvironment( this );
    for ( int i = 0; i < pop_tabMobility.size(); i++ ) {
      tabMobility _a = pop_tabMobility.get(i);
      setupParameters_pop_tabMobility_xjal( _a, i, null );
      doBeforeCreate_pop_tabMobility_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    pop_tabElectricity.setEnvironment( this );
    for ( int i = 0; i < pop_tabElectricity.size(); i++ ) {
      tabElectricity _a = pop_tabElectricity.get(i);
      setupParameters_pop_tabElectricity_xjal( _a, i, null );
      doBeforeCreate_pop_tabElectricity_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    pop_tabHeating.setEnvironment( this );
    for ( int i = 0; i < pop_tabHeating.size(); i++ ) {
      tabHeating _a = pop_tabHeating.get(i);
      setupParameters_pop_tabHeating_xjal( _a, i, null );
      doBeforeCreate_pop_tabHeating_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    pop_tabEHub.setEnvironment( this );
    for ( int i = 0; i < pop_tabEHub.size(); i++ ) {
      tabEHub _a = pop_tabEHub.get(i);
      setupParameters_pop_tabEHub_xjal( _a, i, null );
      doBeforeCreate_pop_tabEHub_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    setupInitialConditions_xjal( UI_Tabs.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    for (Agent embeddedObject : pop_tabMobility) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_tabElectricity) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_tabHeating) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : pop_tabEHub) {
      embeddedObject.startAsEmbedded();
    }
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_UI_Tabs_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_UI_Tabs_xjal() {
    v_selectedTabType = 
OL_CustomScenarioTabs.ELECTRICITY 
;
    v_presentationXOffset = 
15 
;
    v_presentationYOffset = 
630 
;
  }

  // User API -----------------------------------------------------
  public UI_EnergyHub get_UI_EnergyHub() {
    {
      Agent owner = getOwner();
      if ( owner instanceof UI_EnergyHub ) return (UI_EnergyHub) owner;
    }
    return null;
  }

  public Zero_Interface get_Zero_Interface() {
    {
      Agent owner = getOwner();
      if ( owner instanceof Zero_Interface ) return (Zero_Interface) owner;
    }
    {
      UI_EnergyHub ownerAccessor = get_UI_EnergyHub();
      if (ownerAccessor != null) {
        Zero_Interface owner = ownerAccessor.get_Zero_Interface();
        if (owner != null) return owner;
      }
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zerointerfaceloader.Zero_Interface zero_Interface;

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zerointerfaceloader.UI_EnergyHub uI_EnergyHub;

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
    list.add( pop_tabMobility );
    list.add( pop_tabElectricity );
    list.add( pop_tabHeating );
    list.add( pop_tabEHub );
    return list;
  }

  public AgentList<? extends UI_Tabs> getPopulation() {
    return (AgentList<? extends UI_Tabs>) super.getPopulation();
  }

  public List<? extends UI_Tabs> agentsInRange( double distance ) {
    return (List<? extends UI_Tabs>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    for (Agent _item : pop_tabMobility) {
      _item.onDestroy();
    }
    for (Agent _item : pop_tabElectricity) {
      _item.onDestroy();
    }
    for (Agent _item : pop_tabHeating) {
      _item.onDestroy();
    }
    for (Agent _item : pop_tabEHub) {
      _item.onDestroy();
    }
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    for (Agent _item : pop_tabMobility) {
      _item.doFinish();
    }
    for (Agent _item : pop_tabElectricity) {
      _item.doFinish();
    }
    for (Agent _item : pop_tabHeating) {
      _item.doFinish();
    }
    for (Agent _item : pop_tabEHub) {
      _item.doFinish();
    }
  }

  // Additional class code

// Mobility button
public ShapeGroup getGr_mobilityButton(){
	return gr_mobilityButton;
}
public ShapeText getTxt_mobilityButtonDescription(){
	return txt_mobilityButtonDescription;
}
 
// Electricity Button
public ShapeGroup getGr_electricityButton(){
	return gr_electricityButton;
}
public ShapeText getTxt_electricityButtonDescription(){
	return txt_electricityButtonDescription;
}
 
// EHub button
public ShapeGroup getGr_eHubButton(){
	return gr_eHubButton;
}
public ShapeText getTxt_eHubButtonDescription(){
	return txt_eHubButtonDescription;
} 
  // End of additional class code

}
