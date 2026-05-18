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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
 
import java.io.IOException;
 
import energy.lux.uplux.*;
import java.util.UUID;
import java.util.function.Predicate;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule; 

public class UI_EnergyHub extends Agent
{
  // Parameters

  public 
Color  p_energyHubBackGroundColor;

  /**
   * Returns default value for parameter <code>p_energyHubBackGroundColor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Color _p_energyHubBackGroundColor_DefaultValue_xjal() {
    final UI_EnergyHub self = this;
    return 
new Color(198, 251, 198) 
;
  }

  public void set_p_energyHubBackGroundColor( Color value ) {
    if (value == this.p_energyHubBackGroundColor) {
      return;
    }
    Color _oldValue_xjal = this.p_energyHubBackGroundColor;
    this.p_energyHubBackGroundColor = value;
    onChange_p_energyHubBackGroundColor_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_energyHubBackGroundColor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_energyHubBackGroundColor()</code> method instead.
   */
  protected void onChange_p_energyHubBackGroundColor() {
    onChange_p_energyHubBackGroundColor_xjal( p_energyHubBackGroundColor );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_energyHubBackGroundColor_xjal( Color oldValue ) {  
  }


  public 
Color  p_energyHubLineColor;

  /**
   * Returns default value for parameter <code>p_energyHubLineColor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Color _p_energyHubLineColor_DefaultValue_xjal() {
    final UI_EnergyHub self = this;
    return 
new Color(118, 171, 118) 
;
  }

  public void set_p_energyHubLineColor( Color value ) {
    if (value == this.p_energyHubLineColor) {
      return;
    }
    Color _oldValue_xjal = this.p_energyHubLineColor;
    this.p_energyHubLineColor = value;
    onChange_p_energyHubLineColor_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_energyHubLineColor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_energyHubLineColor()</code> method instead.
   */
  protected void onChange_p_energyHubLineColor() {
    onChange_p_energyHubLineColor_xjal( p_energyHubLineColor );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_energyHubLineColor_xjal( Color oldValue ) {  
  }


  public 
double  p_energyHubLineWidth;

  /**
   * Returns default value for parameter <code>p_energyHubLineWidth</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_energyHubLineWidth_DefaultValue_xjal() {
    final UI_EnergyHub self = this;
    return 
2.0 
;
  }

  public void set_p_energyHubLineWidth( double value ) {
    if (value == this.p_energyHubLineWidth) {
      return;
    }
    double _oldValue_xjal = this.p_energyHubLineWidth;
    this.p_energyHubLineWidth = value;
    onChange_p_energyHubLineWidth_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_energyHubLineWidth.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_energyHubLineWidth()</code> method instead.
   */
  protected void onChange_p_energyHubLineWidth() {
    onChange_p_energyHubLineWidth_xjal( p_energyHubLineWidth );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_energyHubLineWidth_xjal( double oldValue ) {  
  }


  public 
LineStyle  p_energyHubLineStyle;

  /**
   * Returns default value for parameter <code>p_energyHubLineStyle</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public LineStyle _p_energyHubLineStyle_DefaultValue_xjal() {
    final UI_EnergyHub self = this;
    return 
LINE_STYLE_SOLID 
;
  }

  public void set_p_energyHubLineStyle( LineStyle value ) {
    if (value == this.p_energyHubLineStyle) {
      return;
    }
    LineStyle _oldValue_xjal = this.p_energyHubLineStyle;
    this.p_energyHubLineStyle = value;
    onChange_p_energyHubLineStyle_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_energyHubLineStyle.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_energyHubLineStyle()</code> method instead.
   */
  protected void onChange_p_energyHubLineStyle() {
    onChange_p_energyHubLineStyle_xjal( p_energyHubLineStyle );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_energyHubLineStyle_xjal( LineStyle oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_energyHubBackGroundColor = _p_energyHubBackGroundColor_DefaultValue_xjal();
    p_energyHubLineColor = _p_energyHubLineColor_DefaultValue_xjal();
    p_energyHubLineWidth = _p_energyHubLineWidth_DefaultValue_xjal();
    p_energyHubLineStyle = _p_energyHubLineStyle_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_energyHubBackGroundColor":
      if ( _callOnChange_xjal ) {
        set_p_energyHubBackGroundColor( (Color) _value_xjal );
      } else {
        p_energyHubBackGroundColor = (Color) _value_xjal;
      }
      return true;
    case "p_energyHubLineColor":
      if ( _callOnChange_xjal ) {
        set_p_energyHubLineColor( (Color) _value_xjal );
      } else {
        p_energyHubLineColor = (Color) _value_xjal;
      }
      return true;
    case "p_energyHubLineWidth":
      if ( _callOnChange_xjal ) {
        set_p_energyHubLineWidth( ((Number) _value_xjal).doubleValue() );
      } else {
        p_energyHubLineWidth = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_energyHubLineStyle":
      if ( _callOnChange_xjal ) {
        set_p_energyHubLineStyle( (LineStyle) _value_xjal );
      } else {
        p_energyHubLineStyle = (LineStyle) _value_xjal;
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
    case "p_energyHubBackGroundColor": _result_xjal = p_energyHubBackGroundColor; break;
    case "p_energyHubLineColor": _result_xjal = p_energyHubLineColor; break;
    case "p_energyHubLineWidth": _result_xjal = p_energyHubLineWidth; break;
    case "p_energyHubLineStyle": _result_xjal = p_energyHubLineStyle; break;
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
      list.add( "p_energyHubBackGroundColor" );
      list.add( "p_energyHubLineColor" );
      list.add( "p_energyHubLineWidth" );
      list.add( "p_energyHubLineStyle" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
EnergyCoop 
 v_energyHubCoop;
  public 
String 
 v_scenarioName;
  public 
ObjectMapper 
 v_objectMapper;

  // Collection Variables
  public 
ArrayList <
GridConnection > c_sliderEAGCs = new ArrayList<GridConnection>();
  public 
LinkedHashMap <
String , 
GISRegion > c_GISregions = new LinkedHashMap<String, GISRegion>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( UI_EnergyHub.class );

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
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _uI_Tabs_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  public digital_twin_results.UI_Results uI_Results;
  public UI_Tabs uI_Tabs;

  public String getNameOf( Agent ao ) {
    if ( ao == uI_Results ) return "uI_Results";
    if ( ao == uI_Tabs ) return "uI_Tabs";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    if ( ao == uI_Results ) return _uI_Results_animationSettings_xjal;
    if ( ao == uI_Tabs ) return _uI_Tabs_animationSettings_xjal;
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
    self.energyModel = self._energyModel_DefaultValue_xjal();
    self.p_cutOff_MWh = self._p_cutOff_MWh_DefaultValue_xjal();
    self.gr_infoText = 
zero_Interface.gr_infoText 
;
    self.gr_closeInfoText = 
zero_Interface.gr_closeInfoText 
;
    self.t_infoTextDescription = 
zero_Interface.t_infoTextDescription 
;
    self.rect_infoText = 
zero_Interface.rect_infoText 
;
    self.p_currentActiveInfoBubble = 
zero_Interface.p_currentActiveInfoBubble 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_uI_Results_xjal( digital_twin_results.UI_Results self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected UI_Tabs instantiate_uI_Tabs_xjal() {
    UI_Tabs _result_xjal = new UI_Tabs( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_uI_Tabs_xjal( final UI_Tabs self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_uI_Tabs_xjal( UI_Tabs self, TableInput _t ) {
  }

  // Functions

  void f_initializeEnergyHubDashboard(  ) { 

//Set map to correct layout
zero_Interface.rb_mapOverlay.setValue(zero_Interface.c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.DEFAULT),true);
zero_Interface.b_updateLiveCongestionColors = false;

// Zoom map to the selected EHub members
f_zoomMapToBuildings();

// Sets the names of the members below the map (call before adding sliders)
f_initializeEnergyHubMemberNames();

//Add slider GC Needs to happen before EnergyCoop creation in some way!!!
f_addSliderEAGridConnections();

//Initialize the ui_results
f_initializeEnergyHubResultsUI();

//Initialize the ui_tabs
f_initializeEnergyHubTabs();

//Initialize custom user saved scenarios
f_initializeUserSavedScenarios(combobox_selectScenario);


runSimulation(); 
  }

  void f_initializeEnergyHubResultsUI(  ) { 

//Initialize the ui_results
uI_Results.energyModel = zero_Interface.energyModel;
uI_Results.v_interfaceViewAreaXOffset = zero_Interface.va_EHubDashboard.getX();
uI_Results.v_interfaceViewAreaYOffset = zero_Interface.va_EHubDashboard.getY();

//Style resultsUI
f_styleEnergyHubResultsUI();

//Set the selected radiobutton setup Energy
List<OL_ChartTypes> selectedChartTypes_Energy = new ArrayList<>(List.of(
												OL_ChartTypes.PROFILES,
												OL_ChartTypes.BAR_TOTALS,
												OL_ChartTypes.LOAD_DURATION_CURVES,
												OL_ChartTypes.SANKEY,
												OL_ChartTypes.GESPREKSLEIDRAAD_BEDRIJVEN,
												OL_ChartTypes.GTO
												));

//Set the selected radiobutton setup Economic
List<OL_ChartTypes> selectedChartTypes_Economic = new ArrayList<>();// Leave empty for now!

//Connect resultsUI
uI_Results.f_initializeResultsUI(selectedChartTypes_Energy, selectedChartTypes_Economic);
uI_Results.f_updateResultsUI(v_energyHubCoop); 
  }

  void f_initializeEnergyHubTabs(  ) { 

//Initialize the ui_tabs
uI_Tabs.add_pop_tabElectricity();
uI_Tabs.add_pop_tabHeating();
uI_Tabs.add_pop_tabMobility();

//Adjust location of buttons to account for missing e-hub tab
uI_Tabs.gr_energyDemandSettings.setX(zero_Interface.uI_Tabs.gr_energyDemandSettings.getX()+40);

//Initialize slider gcs and set sliders
uI_Tabs.f_initializeUI_Tabs(v_energyHubCoop.f_getMemberGridConnectionsCollectionPointer(), new ArrayList<>(), c_sliderEAGCs);

uI_Tabs.v_presentationXOffset += zero_Interface.va_EHubDashboard.getX();
uI_Tabs.v_presentationYOffset += zero_Interface.va_EHubDashboard.getY(); 
  }

  void f_styleEnergyHubResultsUI(  ) { 

uI_Results.f_styleAllCharts(white, p_energyHubLineColor, p_energyHubLineWidth, p_energyHubLineStyle);
uI_Results.f_styleResultsUIHeader(p_energyHubLineColor, p_energyHubLineColor, p_energyHubLineWidth, p_energyHubLineStyle); 
  }

  void f_addSliderEAGridConnections(  ) { 

//Check if a slider EA GC has been manually selected
GridConnection manualSelectedSliderGC_solarFarm = null;
GridConnection manualSelectedSliderGC_windFarm = null;
GridConnection manualSelectedSliderGC_gridBattery = null;
for (GridConnection GC : v_energyHubCoop.f_getMemberGridConnectionsCollectionPointer()) {
	if(GC instanceof GCEnergyProduction){
	    if (((GCEnergyProduction)GC).p_isSliderGC) {
	        if(manualSelectedSliderGC_solarFarm == null && GC.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW)){
				manualSelectedSliderGC_solarFarm = GC;
			}
			else if(manualSelectedSliderGC_windFarm == null && GC.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.windProductionElectric_kW)){
				manualSelectedSliderGC_windFarm = GC;
			}
	    }
	}
	if(manualSelectedSliderGC_gridBattery == null && GC instanceof GCGridBattery && ((GCGridBattery)GC).p_isSliderGC && GC.p_batteryAsset != null){
		manualSelectedSliderGC_gridBattery = GC;
	}
}

//If a slider EA GC has not been manually selected:
GridConnection sliderGC_solarFarm = null;
GridConnection sliderGC_windFarm = null;
GridConnection sliderGC_gridBattery = null;
if(manualSelectedSliderGC_solarFarm == null){
	sliderGC_solarFarm = findFirst(zero_Interface.energyModel.EnergyProductionSites, gc -> gc.p_gridConnectionID.equals(zero_Interface.p_defaultEnergyHubSliderGCName_solarfarm));
}
if(manualSelectedSliderGC_windFarm == null){
	sliderGC_windFarm = findFirst(zero_Interface.energyModel.EnergyProductionSites, gc -> gc.p_gridConnectionID.equals(zero_Interface.p_defaultEnergyHubSliderGCName_windfarm));
}
if(manualSelectedSliderGC_gridBattery == null){
	sliderGC_gridBattery = findFirst(zero_Interface.energyModel.GridBatteries, gc -> gc.p_gridConnectionID.equals(zero_Interface.p_defaultEnergyHubSliderGCName_battery));
}

//Add to coop and other collections
if(sliderGC_solarFarm != null){
	c_sliderEAGCs.add(sliderGC_solarFarm);
}
if(sliderGC_windFarm != null){
	c_sliderEAGCs.add(sliderGC_windFarm);
}
if(sliderGC_gridBattery != null){
	c_sliderEAGCs.add(sliderGC_gridBattery);
}

v_energyHubCoop.f_addMemberGCs(c_sliderEAGCs, zero_Interface.energyModel.p_timeParameters); 
  }

  void f_initializeEnergyHubMemberNames(  ) { 

t_energyHubMember1.setVisible(false);
t_energyHubMember2.setVisible(false);
t_energyHubMember3.setVisible(false);
t_energyHubMember4.setVisible(false);
t_energyHubMember5.setVisible(false);
t_energyHubMember6.setVisible(false);
t_energyHubMember7.setVisible(false);
t_energyHubMemberOthers.setVisible(false);

int maxChars = 25;
String name = "";

// Filter out GCs without building that are sliderGCs
List<GridConnection> members = v_energyHubCoop.f_getMemberGridConnectionsCollectionPointer();
Predicate<GridConnection> isGenericSliderGC = gc -> (gc instanceof GCGridBattery && ((GCGridBattery)gc).p_isSliderGC && gc.c_connectedGISObjects.size() == 0) || (gc instanceof GCEnergyProduction && ((GCEnergyProduction)gc).p_isSliderGC && gc.c_connectedGISObjects.size() == 0);
members.removeIf(isGenericSliderGC);

try {
	name = members.get(0).p_ownerID;
	t_energyHubMember1.setText(f_formatName(name, maxChars));
	t_energyHubMember1.setVisible(true);
	name = members.get(1).p_ownerID;
	t_energyHubMember2.setText(f_formatName(name, maxChars));
	t_energyHubMember2.setVisible(true);
	name = members.get(2).p_ownerID;
	t_energyHubMember3.setText(f_formatName(name, maxChars));
	t_energyHubMember3.setVisible(true);
	name = members.get(3).p_ownerID;
	t_energyHubMember4.setText(f_formatName(name, maxChars));
	t_energyHubMember4.setVisible(true);
	name = members.get(4).p_ownerID;
	t_energyHubMember5.setText(f_formatName(name, maxChars));
	t_energyHubMember5.setVisible(true);
	name = members.get(5).p_ownerID;
	t_energyHubMember6.setText(f_formatName(name, maxChars));
	t_energyHubMember6.setVisible(true);
	name = members.get(6).p_ownerID;
	t_energyHubMember7.setText(f_formatName(name, maxChars));
	t_energyHubMember7.setVisible(true);
	if (members.size() == 8) {
		name = members.get(7).p_ownerID;		
		t_energyHubMemberOthers.setText(f_formatName(name, maxChars));
		t_energyHubMemberOthers.setVisible(true);
	}
	else if (members.size() > 8) {
		int nbOthers = members.size() - 7;
		t_energyHubMemberOthers.setText("En nog " + nbOthers + " andere leden");
		t_energyHubMemberOthers.setVisible(true);
	}
}
catch (Exception exception) {
	if (exception instanceof IndexOutOfBoundsException) {
		traceln("Ignoring IndexOutOfBoundsException"); // do nothing
	}
	else {
		exception.printStackTrace();
	}
} 
  }

  void f_initializeUserSavedScenarios( ShapeComboBox combo ) { 

if ( zero_Interface.user.userIdToken() == null || zero_Interface.user.userIdToken() == "") {
	return;
}
UserScenarioRepository repository = f_getUserScenarioRepository();

var scenarioList = repository.listUserScenarios();
int nbScenarios = scenarioList.size();
String[] scenarioNames = new String[nbScenarios];
for (int i = 0; i < nbScenarios; i++) {
	scenarioNames[i] = scenarioList.get(i).getName();
}
combo.setItems(scenarioNames); 
  }

  void f_loadScenario( int index ) { 

zero_Interface.f_setScenarioToCustom();

for (UI_Results ui_results : zero_Interface.c_UIResultsInstances) {
	if (ui_results.f_getSelectedObjectData() != null) {	
		zero_Interface.f_enableLivePlotsOnly(ui_results);
	}
}


if ( zero_Interface.user.userIdToken() == null || zero_Interface.user.userIdToken() == "") {
	zero_Interface.f_setErrorScreen("Niet mogelijk om scenario's in te laden. Er is geen gebruiker ingelogd.", zero_Interface.va_EHubDashboard.getX(), zero_Interface.va_EHubDashboard.getY());
	return;
}
traceln("Loading modelSave...");
//pauseSimulation();

// Collect GIS_Objects into hashmap, to link to new EnergyModel.
zero_Interface.energyModel.pop_GIS_Buildings.forEach(x->{c_GISregions.put(x.p_id, x.gisRegion);});
zero_Interface.energyModel.pop_GIS_Objects.forEach(x->{c_GISregions.put(x.p_id, x.gisRegion);});
zero_Interface.energyModel.pop_GIS_Parcels.forEach(x->{c_GISregions.put(x.p_id, x.gisRegion);});
pauseSimulation();
try {
	v_objectMapper = new ObjectMapper();
	v_objectMapper.registerModule(new JavaTimeModule());
	f_addMixins();
	
	UserScenarioRepository repository = f_getUserScenarioRepository();
      
    var scenarioList = repository.listUserScenarios();   

	// Deserialize the JSON into a new EnergyModel instance:
    var jsonStream = repository.fetchUserScenarioContent(scenarioList.get(index).getId());
    
	J_ModelSave saveObject = v_objectMapper.readValue(jsonStream, J_ModelSave.class);
	
	// Check last saved date, compare to current status of projectdata.
	if (!saveObject.projectDataLastModifiedDate.equals(zero_Interface.zero_loader.v_projectDataLastChangedDate)) {
		traceln("Current data last modified date: %s", zero_Interface.zero_loader.v_projectDataLastChangedDate);
		traceln("Save-file data last modified date: %s", saveObject.projectDataLastModifiedDate);
		getExperimentHost().showMessageDialog("Het opgeslagen scenario bevat data die niet overeenkomt met de huidige dataset in de data portal."); 
		System.err.println("Data-last-changed-dates DON'T match!");
	} else {
		traceln("Current data last modified date: %s", zero_Interface.zero_loader.v_projectDataLastChangedDate);
		traceln("Save-file data last modified date: %s", saveObject.projectDataLastModifiedDate);
		traceln("Data-last-changed-dates match!");
		
		
		EnergyModel deserializedEnergyModel = saveObject.energyModel;
			
		// Reconstruct all Agents
		f_reconstructEnergyModel(deserializedEnergyModel);		
		f_reconstructGridConnections(deserializedEnergyModel);
		f_reconstructActors(deserializedEnergyModel);
		f_reconstructGridNodes(deserializedEnergyModel, saveObject.c_gridNodes);
		
		f_reconstructGIS_Objects(deserializedEnergyModel, saveObject.c_GISObjects);
		
		// Get profilePointer tableFunctions from 'original' energyModel
		/* deserializedEnergyModel.c_profiles.forEach(x->{
			J_ProfilePointer origProfile = zero_Interface.energyModel.f_findProfile(x.name);
			x.setTableFunction(origProfile.getTableFunction());
		}); */
		// get heatingTypeHashmap from 'old' energyModel.
		deserializedEnergyModel.c_defaultHeatingStrategies = zero_Interface.energyModel.c_defaultHeatingStrategies;
		
		zero_Interface.zero_loader.energyModel = deserializedEnergyModel;
		zero_Interface.energyModel = deserializedEnergyModel;
		zero_Interface.uI_Results.energyModel = deserializedEnergyModel;
		uI_Results.energyModel = deserializedEnergyModel;
		
		deserializedEnergyModel.f_startAfterDeserialisation();
		
		f_setEngineInputDataAfterDeserialisation(deserializedEnergyModel);
		
		
		// Putting back the ordered collections in the interface
		f_reconstructOrderedCollections(saveObject);
		
		
		//Get the correct coop for the E-Hub Dashboard
		v_energyHubCoop = findFirst(zero_Interface.energyModel.pop_energyCoops,x->x.p_actorID.equals("eHubConfiguratorCoop"));
		if (v_energyHubCoop == null){
			throw new RuntimeException("No energyCoop found with p_actorID = eHubConfiguratorCoop");
		}
		zero_Interface.v_customEnergyCoop = v_energyHubCoop;
		
		//Get the slider gcs of the reloaded EnergyHub
		c_sliderEAGCs = f_getEnergyHubsliderEAGCsLoadedScenario(v_energyHubCoop);
		
		// Update the E-Hub Dashboard with the loaded E-Hub from savefile
		f_initializeEnergyHubMemberNames();
		uI_Tabs.f_initializeUI_Tabs(v_energyHubCoop.f_getMemberGridConnectionsCollectionPointer(), null, c_sliderEAGCs);
		gr_uI_Tabs_presentation.setVisible(false);
		gr_uI_Tabs_presentation.setVisible(true);
		uI_Results.f_updateResultsUI(v_energyHubCoop);
		
		// Update the main interface with the loaded E-Hub from savefile
		zero_Interface.c_selectedGridConnections = new ArrayList<>(v_energyHubCoop.f_getMemberGridConnectionsCollectionPointer());
		
		// Update the main interface tabs with the GCs from the new engine
		zero_Interface.uI_Tabs.f_initializeUI_Tabs(zero_Interface.energyModel.f_getGridConnectionsCollectionPointer(), zero_Interface.energyModel.f_getPausedGridConnectionsCollectionPointer(), zero_Interface.f_getMainInterfaceSliderEAGCs());
		
		// Reset all colors on the GIS map
		zero_Interface.energyModel.pop_GIS_Buildings.forEach(x -> zero_Interface.f_styleAreas(x));
		zero_Interface.energyModel.pop_GIS_Objects.forEach(x -> zero_Interface.f_styleAreas(x));
		zero_Interface.energyModel.pop_GIS_Parcels.forEach(x -> zero_Interface.f_styleAreas(x));
		
		// Color all selected GC 
		for (GridConnection gc : zero_Interface.c_selectedGridConnections) {
			gc.c_connectedGISObjects.forEach(x -> x.gisRegion.setFillColor(zero_Interface.v_selectionColor));		
		}
		
		// Zoom GIS Map to selected buildings
		f_zoomMapToBuildings();
				
		// Simulate a year
		gr_simulateYearEnergyHub.setVisible(false);		
		gr_loadIconYearSimulationEnergyHub.setVisible(true);
		
		
		zero_Interface.f_simulateYearFromMainInterface();	
		
		traceln("ModelSave loaded succesfully!");
	}
		
} catch (IOException e) {
	e.printStackTrace();
}

 
  }

  void f_saveScenario( String scenarioName ) { 

if ( zero_Interface.user.userIdToken() == null || zero_Interface.user.userIdToken() == "") {
	zero_Interface.f_setErrorScreen("Niet mogelijk om scenario's op te slaan. Er is geen gebruiker ingelogd.", zero_Interface.va_EHubDashboard.getX(), zero_Interface.va_EHubDashboard.getY());
	return;
}

traceln("Starting model serialisation...");
J_ModelSave saveObject = new J_ModelSave();
saveObject.projectDataLastModifiedDate = zero_Interface.zero_loader.v_projectDataLastChangedDate;

saveObject.energyModel = zero_Interface.energyModel;

zero_Interface.energyModel.pop_gridNodes.forEach(x->saveObject.c_gridNodes.add(x));
zero_Interface.energyModel.pop_GIS_Buildings.forEach(x->{saveObject.c_GISObjects.add(x); c_GISregions.put(x.p_id, x.gisRegion);x.f_writeStyleStrings();});
zero_Interface.energyModel.pop_GIS_Objects.forEach(x->{saveObject.c_GISObjects.add(x); c_GISregions.put(x.p_id, x.gisRegion);x.f_writeStyleStrings();});
zero_Interface.energyModel.pop_GIS_Parcels.forEach(x->{saveObject.c_GISObjects.add(x); c_GISregions.put(x.p_id, x.gisRegion);x.f_writeStyleStrings();});

saveObject.c_orderedPVSystemsCompanies = zero_Interface.c_orderedPVSystemsCompanies;
saveObject.c_orderedPVSystemsHouses = zero_Interface.c_orderedPVSystemsHouses;
saveObject.c_orderedVehicles = zero_Interface.c_orderedVehicles;
saveObject.c_orderedHeatingSystemsCompanies = zero_Interface.c_orderedHeatingSystemsCompanies;
saveObject.c_orderedHeatingSystemsHouses = zero_Interface.c_orderedHeatingSystemsHouses;
saveObject.c_orderedVehiclesPrivateParking = zero_Interface.c_orderedVehiclesPrivateParking;
saveObject.c_orderedParkingSpaces = zero_Interface.c_orderedParkingSpaces;
saveObject.c_orderedV1GChargers = zero_Interface.c_orderedV1GChargers;
saveObject.c_orderedV2GChargers = zero_Interface.c_orderedV2GChargers;
saveObject.c_orderedPublicChargers = zero_Interface.c_orderedPublicChargers;
saveObject.c_mappingOfVehiclesPerCharger = zero_Interface.c_mappingOfVehiclesPerCharger;
saveObject.c_scenarioMap_Current = zero_Interface.c_scenarioMap_Current;
saveObject.c_scenarioMap_Future = zero_Interface.c_scenarioMap_Future;
saveObject.c_additionalVehicleHashMaps = zero_Interface.c_additionalVehicles;

v_objectMapper = new ObjectMapper();
v_objectMapper.registerModule(new JavaTimeModule());
f_addMixins();
v_objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
traceln("Model serialisation has been completed.");

traceln("Trying to save to file...");
try {
	UserScenarioRepository repository = f_getUserScenarioRepository();
	repository.saveUserScenario(
        scenarioName,
        v_objectMapper.writeValueAsBytes(saveObject)
	);
	
	traceln("Scenario saved to file.");
	
} catch (IOException e) {
	traceln("Saving to file has failed.");
	e.printStackTrace();
}
 
  }

  protected void f_addMixins(  ) { 

v_objectMapper.addMixIn(Agent.class, AgentMixin.class);
//v_objectMapper.addMixIn(EnergyModel.class, EnergyModelMixin.class);

//v_objectMapper.addMixIn(Actor.class, ActorMixin.class);
//v_objectMapper.addMixIn(DataSet.class, DataSetMixin.class);

//Ignore classes

v_objectMapper.addMixIn(java.awt.Font.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(java.awt.Color.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(java.awt.Paint.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(ShapeLine.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(ShapeLineFill.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(ShapeText.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(AgentArrayList.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(ViewArea.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(TextFile.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(EnergyDataViewer.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(DataSet.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(Level.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(TableFunction.class, IgnoreClassMixin.class);
//objectMapper.addMixIn(com.anylogic.engine.TableFunction.class, TableFunctionMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.markup.GISRegion.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.presentation.ViewArea.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.AgentSpacePosition.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.presentation.ShapeModelElementsGroup.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.presentation.ShapeButton.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.analysis.TimePlot.class, IgnoreClassMixin.class);


// Weirdness regarding material handling toolbox	
v_objectMapper.addMixIn(com.anylogic.engine.markup.AbstractWall.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.markup.RailwayTrack.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.markup.PalletRack.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.markup.RoadNetwork.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.markup.AreaNode.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.markup.AbstractFluidMarkup.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.markup.Lift.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.markup.ConveyorNode.class, IgnoreClassMixin.class);
v_objectMapper.addMixIn(com.anylogic.engine.markup.Node.class, IgnoreClassMixin.class);
 
  }

  /**
   * Functie van gillis voor inladen weer data!
   */
  public void f_setEngineInputDataAfterDeserialisation( EnergyModel deserializedEnergyModel ) { 

deserializedEnergyModel.p_truckTripsCsv = zero_Interface.energyModel.p_truckTripsCsv;
deserializedEnergyModel.p_householdTripsCsv = zero_Interface.energyModel.p_householdTripsCsv;
deserializedEnergyModel.p_cookingPatternCsv = zero_Interface.energyModel.p_cookingPatternCsv;

//deserializedEnergyModel.avgc_data = zero_Interface.energyModel.avgc_data;
deserializedEnergyModel.c_defaultHeatingStrategies = zero_Interface.energyModel.c_defaultHeatingStrategies; 
  }

  void f_reconstructGridConnections( EnergyModel deserializedEnergyModel ) { 

ArrayList<GridConnection> allConnections = new ArrayList<>();
allConnections.addAll(deserializedEnergyModel.c_gridConnections);
allConnections.addAll(deserializedEnergyModel.c_pausedGridConnections);

for(GridConnection GC : allConnections){
	GC.energyModel = deserializedEnergyModel;
	if (GC instanceof GCHouse){
		//toMove.add(GC);
		f_reconstructAgent(GC, deserializedEnergyModel.Houses, deserializedEnergyModel);
	} else if (GC instanceof GCEnergyProduction) {
		f_reconstructAgent(GC, deserializedEnergyModel.EnergyProductionSites, deserializedEnergyModel);
	} else if (GC instanceof GCEnergyConversion) {
		f_reconstructAgent(GC, deserializedEnergyModel.EnergyConversionSites, deserializedEnergyModel);
	} else if (GC instanceof GCGridBattery) {
		f_reconstructAgent(GC, deserializedEnergyModel.GridBatteries, deserializedEnergyModel);
	} else if (GC instanceof GCNeighborhood) {
		f_reconstructAgent(GC, deserializedEnergyModel.Neighborhoods, deserializedEnergyModel);
	} else if (GC instanceof GCPublicCharger) {
		f_reconstructAgent(GC, deserializedEnergyModel.PublicChargers, deserializedEnergyModel);
	} else if (GC instanceof GCUtility) {
		f_reconstructAgent(GC, deserializedEnergyModel.UtilityConnections, deserializedEnergyModel);
	}
	//GC.f_startAfterDeserialisation();
}

 
  }

  void f_reconstructEnergyModel( EnergyModel energyModel ) { 

// Code Instead of Agent.goToPopulation() (which resets all parameters to default!)	
/*
try{ // Reflection trick to get to Agent.owner private field
	energyModel.forceSetOwner(energyModel, pop_energyModels);
} catch (Exception e) {
	e.printStackTrace();
}
*/

Agent root = zero_Interface.getRootAgent();
traceln("root: " + root);
energyModel.restoreOwner(zero_Interface.zero_loader);

energyModel.setEngine(getEngine());	
energyModel.instantiateBaseStructure_xjal();
energyModel.setEnvironment(zero_Interface.zero_loader.getEnvironment());

traceln("EnergyModel owner: %s", energyModel.getOwner());

energyModel.create();
//energyModel.start(); // Why is this needed? 
  }

  void f_reconstructAgent( Agent agent, AgentArrayList pop, EnergyModel energyModel ) { 

/* // Code Instead of Agent.goToPopulation() (which resets many variables to default!)	
try{ // Reflection trick to get to Agent.owner private field
	if (agent instanceof GridNode) {
		((GridNode)agent).forceSetOwner(agent,pop);
	} else if (agent instanceof GridConnection) {
		((GridConnection)agent).forceSetOwner(agent,pop);
	} else if (agent instanceof Actor) {
		((Actor)agent).forceSetOwner(agent,pop);
	} else if (agent instanceof GIS_Object) {
		((GIS_Object)agent).forceSetOwner(agent,pop);
	}
} catch (Exception e) {
	e.printStackTrace();
}*/ 

agent.restoreOwner(energyModel); // simply sets agent.d = root, should replace reflection hack
agent.restoreCollection_xjal(pop); // simple sets agent.j = pop, should replace reflection hack

agent.setEngine(getEngine());	
agent.instantiateBaseStructure_xjal();
agent.setEnvironment(pop.getEnvironment());

pop._add(agent); // Add to the population	
//int popSize = pop.size(); 
//pop.callCreate(agent, popSize); // Update population object
agent.create(); 
  }

  void f_reconstructActors( EnergyModel deserializedEnergyModel ) { 

for(Actor AC : deserializedEnergyModel.c_actors){
		
		if (AC instanceof ConnectionOwner) {
			((ConnectionOwner)AC).energyModel = deserializedEnergyModel;
			f_reconstructAgent(AC, deserializedEnergyModel.pop_connectionOwners, deserializedEnergyModel);
		} else if (AC instanceof EnergySupplier) {
			((EnergySupplier)AC).energyModel = deserializedEnergyModel;
			f_reconstructAgent(AC, deserializedEnergyModel.pop_energySuppliers, deserializedEnergyModel);
		} else if (AC instanceof EnergyCoop) {
			((EnergyCoop)AC).energyModel = deserializedEnergyModel;
			f_reconstructAgent(AC, deserializedEnergyModel.pop_energyCoops, deserializedEnergyModel);
			//((EnergyCoop)AC).f_startAfterDeserialisation();
		} else if (AC instanceof GridOperator) {
			((GridOperator)AC).energyModel = deserializedEnergyModel;
			f_reconstructAgent(AC, deserializedEnergyModel.pop_gridOperators, deserializedEnergyModel);
		}
	}
 
  }

  void f_reconstructGIS_Objects( EnergyModel deserializedEnergyModel, ArrayList<GIS_Object> c_GISObjects ) { 

for(GIS_Object GO : c_GISObjects){
	GO.gisRegion = c_GISregions.get(GO.p_id);
	
	if (GO instanceof GIS_Building) {
		((GIS_Building)GO).energyModel = deserializedEnergyModel;
		f_reconstructAgent(GO, deserializedEnergyModel.pop_GIS_Buildings, deserializedEnergyModel);
	} else if (GO instanceof GIS_Parcel) {
		((GIS_Parcel)GO).energyModel = deserializedEnergyModel;
		f_reconstructAgent(GO, deserializedEnergyModel.pop_GIS_Parcels, deserializedEnergyModel);
	} else {
		GO.energyModel = deserializedEnergyModel;
		f_reconstructAgent(GO, deserializedEnergyModel.pop_GIS_Objects, deserializedEnergyModel);
		//GO.f_startAfterDeserialisation();
	}
	GO.f_resetStyle();
} 
  }

  void f_reconstructGridNodes( EnergyModel deserializedEnergyModel, ArrayList<GridNode> c_gridNodes ) { 

for(GridNode GN : c_gridNodes){
	GN.energyModel = deserializedEnergyModel;
	f_reconstructAgent(GN, deserializedEnergyModel.pop_gridNodes, deserializedEnergyModel);
}
 
  }

  void f_reconstructOrderedCollections( J_ModelSave saveObject ) { 

zero_Interface.c_orderedPVSystemsCompanies = saveObject.c_orderedPVSystemsCompanies;
zero_Interface.c_orderedPVSystemsHouses = saveObject.c_orderedPVSystemsHouses;
zero_Interface.c_orderedVehicles = saveObject.c_orderedVehicles;
zero_Interface.c_orderedHeatingSystemsCompanies = saveObject.c_orderedHeatingSystemsCompanies;
zero_Interface.c_orderedHeatingSystemsHouses = saveObject.c_orderedHeatingSystemsHouses;
zero_Interface.c_orderedVehiclesPrivateParking = saveObject.c_orderedVehiclesPrivateParking;
zero_Interface.c_orderedParkingSpaces = saveObject.c_orderedParkingSpaces;
zero_Interface.c_orderedV1GChargers = saveObject.c_orderedV1GChargers;
zero_Interface.c_orderedV2GChargers = saveObject.c_orderedV2GChargers;
zero_Interface.c_orderedPublicChargers = saveObject.c_orderedPublicChargers;
zero_Interface.c_mappingOfVehiclesPerCharger = saveObject.c_mappingOfVehiclesPerCharger;
zero_Interface.c_scenarioMap_Current = saveObject.c_scenarioMap_Current;
zero_Interface.c_scenarioMap_Future = saveObject.c_scenarioMap_Future;
zero_Interface.c_additionalVehicles = saveObject.c_additionalVehicleHashMaps;
 
  }

  
String 
 f_formatName( String fullName, int maxChars ) { 

if (fullName.length() <= maxChars) {
	return fullName;
}
StringBuilder output = new StringBuilder();
String[] subNames = fullName.split(" ");
int remainingChars = maxChars;
for (String subName : subNames) {
	remainingChars -= subName.length() + 1;
	if (remainingChars >= 0) {
		output.append(subName);
		output.append(" ");
	}
}
// If the output is empty (because the first word is longer than maxChars) cut the first word off at maxChars
if (output.toString().length() == 0) {
	output.append(fullName.substring(0, maxChars));
}
output.append("...");
return output.toString(); 
  }

  void f_zoomMapToBuildings(  ) { 

List<GIS_Object> gisObjects = new ArrayList<>();
for (GridConnection GC : v_energyHubCoop.f_getMemberGridConnectionsCollectionPointer()) { //Buildings that are grouped, select as well.
	for (GIS_Object object : GC.c_connectedGISObjects) { //Buildings that are grouped, select as well.
		gisObjects.add(object);
		object.gisRegion.setFillColor(zero_Interface.v_selectionColorAddBuildings);
	}
}
zero_Interface.f_setMapViewBounds(gisObjects); 
  }

  void f_loadScenarioButton(  ) { 

// The function creates a new thread, otherwise visibilities are only updated after the entire button action is finished, which is not enough feedback for the user
gr_forceSaveLoadScenario.setVisible(false);
gr_loadScenario.setVisible(false);
zero_Interface.f_setLoadingScreen(true, zero_Interface.va_EHubDashboard.getX(), zero_Interface.va_EHubDashboard.getY());

new Thread( () -> {
	f_loadScenario(combobox_selectScenario.getValueIndex());
	zero_Interface.f_setLoadingScreen(false, 0, 0);
}).start(); 
  }

  void f_saveScenarioButton(  ) { 

// The function creates a new thread, otherwise visibilities are only updated after the entire button action is finished, which is not enough feedback for the user
gr_forceSaveLoadScenario.setVisible(false);
gr_saveScenario.setVisible(false);
zero_Interface.f_setLoadingScreen(true, zero_Interface.va_EHubDashboard.getX(), zero_Interface.va_EHubDashboard.getY());

new Thread( () -> {
	f_saveScenario(v_scenarioName);
	zero_Interface.f_setLoadingScreen(false, 0, 0);
}).start();
 
  }

  
ArrayList<GridConnection> 
 f_getEnergyHubsliderEAGCsLoadedScenario( EnergyCoop energyHubCoop ) { 

ArrayList<GridConnection> energyHubSliderEAGCs = new ArrayList<GridConnection>();
for(GridConnection gc : energyHubCoop.f_getMemberGridConnectionsCollectionPointer()){
	if(gc instanceof GCGridBattery battery){
		if(battery.p_isSliderGC){
			energyHubSliderEAGCs.add(battery);
		}
	}
	if(gc instanceof GCEnergyProduction productionSite){
		if(productionSite.p_isSliderGC){
			energyHubSliderEAGCs.add(productionSite);
		}
	}
}

if(energyHubSliderEAGCs.size() != 3){
	throw new RuntimeException("energyHubsliderEAGCs.size() != 3 -> Should be exactly 3: 1 solarfarm, 1 windfarm and 1 battery");
}

return energyHubSliderEAGCs; 
  }

  
UserScenarioRepository 
 f_getUserScenarioRepository(  ) { 

UserScenarioRepository repository;
try{
	repository = UserScenarioRepository.builder()
    .userIdToken(zero_Interface.user.userIdToken())
    .modelName(zero_Interface.project_data.project_name())
    .build();
}
catch(Exception e) {
	traceln("Warning: NO correct userIdToken found, trying to read it as a UUID instead!");
	repository = UserScenarioRepository.builder()
    .userId(UUID.fromString(zero_Interface.user.userIdToken()))
    .modelName(zero_Interface.project_data.project_name())
    .build();
}

return repository; 
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
  protected static final Font _button_reconfigureEnergyHub_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_exit_Font = _button_reconfigureEnergyHub_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_cancelSaveLoadScenario_Font = _button_reconfigureEnergyHub_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _eb_scenarioName_Font = _button_reconfigureEnergyHub_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _combobox_selectScenario_Font = _button_reconfigureEnergyHub_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_saveScenario_Font = _button_reconfigureEnergyHub_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_loadScenario_Font = _button_reconfigureEnergyHub_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_scenario_Font = new Font("SansSerif", 0, 36 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_settings_Font = _t_scenario_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_energyHubTitle_Font = new Font("SansSerif", 0, 48 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_loadIconSmall_Font = new Font("SansSerif", 1, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_simulateYearToCalculateCostsSmall_Font = _t_loadIconSmall_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyHubMember1_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyHubMembers_Font = _t_scenario_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyHubMember3_Font = _t_energyHubMember1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyHubMember2_Font = _t_energyHubMember1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyHubMember4_Font = _t_energyHubMember1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyHubMember5_Font = _t_energyHubMember1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyHubMember7_Font = _t_energyHubMember1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyHubMemberOthers_Font = _t_energyHubMember1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyHubMember6_Font = _t_energyHubMember1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_saveScenarioInstructions_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_loadScenarioInstructions_Font = _t_saveScenarioInstructions_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_date_Font = new Font("SansSerif", 1, 16 );
  protected static final Color _ovalEnergyHubLogo_Fill_Color = new Color( 0xFFC6FBC6, true );
  protected static final Color _rect_loadIconSmall_Fill_Color = new Color( 0xE9F5F5F5, true );
  protected static final Color _rect_forceSaveLoadScenarioClickBlocker1_Fill_Color = new Color( 0xFFFFFF, true );
  protected static final Color _rect_forceSaveLoadScenarioClickBlocker2_Fill_Color = new Color( 0xFFFFFF, true );
  protected static final Color _rect_forceSaveLoadScenarioClickBlocker3_Fill_Color = new Color( 0xFFFFFF, true );
  protected static final Color _rect_forceSaveLoadScenarioClickBlocker4_Fill_Color = new Color( 0xFFFFFF, true );
  protected static final Color _rect_forceSaveLoadScenario1_Fill_Color = new Color( 0x96C0C0C0, true );
  protected static final Color _rect_forceSaveLoadScenario2_Fill_Color = new Color( 0x96C0C0C0, true );
  protected static final Color _rect_forceSaveLoadScenario3_Fill_Color = new Color( 0x96C0C0C0, true );
  protected static final Color _rect_forceSaveLoadScenario4_Fill_Color = new Color( 0x96C0C0C0, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_backGround = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_settings = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _uI_Tabs_presentation = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_uI_Tabs_presentation = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_uITabsModelBlocker = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_scenarios = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_scenario = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_settings = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_map = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_title = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_energyHubTitle = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalEnergyHubLogo = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _line2 = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval1 = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _line3 = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval4 = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval3 = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_energyHubLogo = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_energyHubTitle = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _uI_Results_presentation = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_uI_Results_presentation = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_exit = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_exitButton = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_loadIconSmall = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_loadIconSmall = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_loadIconSmall = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_loadIconYearSimulationEnergyHub = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_simulateYearScreenSmall = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_simulateYearToCalculateCostsSmall = 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_simulateYearToCalculateCostsSmall = 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_simulateYearButtonEnergyHub = 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_simulateYearEnergyHub = 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_simulateYearScreenEnergyHub = 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_memberNames = 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyHubMember1 = 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyHubMembers = 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyHubMember3 = 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyHubMember2 = 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyHubMember4 = 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyHubMember5 = 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyHubMember7 = 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyHubMemberOthers = 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyHubMember6 = 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceSaveLoadScenarioClickBlocker1 = 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceSaveLoadScenarioClickBlocker2 = 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceSaveLoadScenarioClickBlocker3 = 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceSaveLoadScenarioClickBlocker4 = 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceSaveLoadScenario1 = 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceSaveLoadScenario2 = 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceSaveLoadScenario3 = 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_forceSaveLoadScenario4 = 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_forceSaveLoadScenario = 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_saveScenario = 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_saveScenarioInstructions = 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_saveScenario = 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_loadScenario = 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_loadScenarioInstructions = 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_loadScenario = 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_saveAndLoadScenarios = 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_date = 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_reconfigureEnergyHub = 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_exit = 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_cancelSaveLoadScenario = 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _eb_scenarioName = 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _combobox_selectScenario = 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_saveScenario = 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_loadScenario = 70;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 71;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    if (_a == uI_Tabs) { return true; }
    if (_a == uI_Results) { return true; }
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rect_backGround, rect_settings, gr_uI_Tabs_presentation, rect_uITabsModelBlocker, rect_scenarios, t_scenario, txt_settings, rect_map, gr_energyHubTitle, gr_uI_Results_presentation, button_reconfigureEnergyHub, gr_exitButton, gr_simulateYearScreenEnergyHub, rect_memberNames, t_energyHubMember1, t_energyHubMembers, t_energyHubMember3, t_energyHubMember2, t_energyHubMember4, t_energyHubMember5, t_energyHubMember7, t_energyHubMemberOthers, t_energyHubMember6, gr_forceSaveLoadScenario, gr_saveAndLoadScenarios, t_date);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _gr_simulateYearButtonEnergyHub:
        if (true) {
          ShapeGroup self = this.gr_simulateYearButtonEnergyHub;
          
gr_simulateYearEnergyHub.setVisible(false);		
gr_loadIconYearSimulationEnergyHub.setVisible(true);
zero_Interface.f_simulateYearFromMainInterface();	 
        }
        break;
      case _rect_forceSaveLoadScenarioClickBlocker1:
        if (true) {
          ShapeRectangle self = this.rect_forceSaveLoadScenarioClickBlocker1;
          
; 
        }
        break;
      case _rect_forceSaveLoadScenarioClickBlocker2:
        if (true) {
          ShapeRectangle self = this.rect_forceSaveLoadScenarioClickBlocker2;
          
; 
        }
        break;
      case _rect_forceSaveLoadScenarioClickBlocker3:
        if (true) {
          ShapeRectangle self = this.rect_forceSaveLoadScenarioClickBlocker3;
          
; 
        }
        break;
      case _rect_forceSaveLoadScenarioClickBlocker4:
        if (true) {
          ShapeRectangle self = this.rect_forceSaveLoadScenarioClickBlocker4;
          
; 
        }
        break;
      case _image_saveScenario:
        if (true) {
          ShapeImage self = this.image_saveScenario;
          
f_saveScenarioButton(); 
        }
        break;
      case _image_loadScenario:
        if (true) {
          ShapeImage self = this.image_loadScenario;
          
f_loadScenarioButton(); 
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
      case _button_reconfigureEnergyHub: {
          ShapeButton self = this.button_reconfigureEnergyHub;
pauseSimulation();

//Remove slider GCs from coop
v_energyHubCoop.f_removeMemberGCs(c_sliderEAGCs, zero_Interface.energyModel.p_timeParameters);


zero_Interface.f_getScenarioButtons().setPos( 19, 144);

zero_Interface.map.setScale( 1.0, 1.0);
zero_Interface.map.setPos(410, 130);

zero_Interface.va_Interface.navigateTo();
zero_Interface.v_currentViewArea = zero_Interface.va_Interface;
//zero_Interface.c_selectedGridConnections = new ArrayList<GridConnection>(c_selectedEnergyHubGC);
//zero_Interface.v_customEnergyCoop = v_energyHubCoop;
	
v_energyHubCoop = null;

zero_Interface.b_inEnergyHubSelectionMode = true; 
;}
        break;
      case _button_exit: {
          ShapeButton self = this.button_exit;
//Remove slider GCs from coop
v_energyHubCoop.f_removeMemberGCs(c_sliderEAGCs, zero_Interface.energyModel.p_timeParameters);
c_sliderEAGCs.clear();

zero_Interface.f_getScenarioButtons().setPos( 19, 144);

zero_Interface.map.setScale( 1.0, 1.0);
zero_Interface.map.setPos(410, 130);


zero_Interface.button_clearFilters.action();
zero_Interface.rb_mapOverlay.setValue(zero_Interface.c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.DEFAULT),true);
zero_Interface.cb_showFilterInterface.setSelected(false, true);
zero_Interface.f_updateMainInterfaceSliders();

zero_Interface.f_setStartView();

v_energyHubCoop = null;

zero_Interface.b_inEnergyHubMode = false;

runSimulation(); 
;}
        break;
      case _button_cancelSaveLoadScenario: {
          ShapeButton self = this.button_cancelSaveLoadScenario;
gr_saveScenario.setVisible(false);
gr_loadScenario.setVisible(false);
gr_forceSaveLoadScenario.setVisible(false); 
;}
        break;
      case _button_saveScenario: {
          ShapeButton self = this.button_saveScenario;
gr_loadScenario.setVisible(false);
gr_forceSaveLoadScenario.setVisible(true);
gr_saveScenario.setVisible(true); 
;}
        break;
      case _button_loadScenario: {
          ShapeButton self = this.button_loadScenario;
f_initializeUserSavedScenarios(combobox_selectScenario);
if (combobox_selectScenario.getItems().length == 0) {
	zero_Interface.f_setErrorScreen("Er zijn nog geen scenario's opgeslagen.", zero_Interface.va_EHubDashboard.getX(), zero_Interface.va_EHubDashboard.getY());
	return;
}

gr_saveScenario.setVisible(false);
gr_forceSaveLoadScenario.setVisible(true);
gr_loadScenario.setVisible(true);

 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }


  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, String value ) {
    switch( _shape ) {
      case _eb_scenarioName:
        v_scenarioName = value;
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
        
  @Override
  @AnyLogicInternalCodegenAPI
  public String getShapeControlDefaultValueString( int _shape, int index ) {
    switch(_shape) {
      case _eb_scenarioName: return 
v_scenarioName 
;
      default: return super.getShapeControlDefaultValueString( _shape, index );
    }
  }

  protected ShapeButton button_reconfigureEnergyHub;
  protected ShapeButton button_exit;
  protected ShapeButton button_cancelSaveLoadScenario;
  protected ShapeTextField eb_scenarioName;
  protected ShapeComboBox combobox_selectScenario;
  protected ShapeButton button_saveScenario;
  protected ShapeButton button_loadScenario;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_backGround_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
p_energyHubBackGroundColor 
);
  }
  
  protected ShapeRectangle rect_backGround;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_settings_SetDynamicParams_xjal( ShapeRoundedRectangle shape ) {
    shape.setLineColor(
p_energyHubLineColor 
);
    shape.setLineWidth(
p_energyHubLineWidth 
);
    shape.setLineStyle(
p_energyHubLineStyle 
);
  }
  
  protected ShapeRoundedRectangle rect_settings;
  protected ShapeEmbeddedObjectPresentation uI_Tabs_presentation;
  protected ShapeGroup gr_uI_Tabs_presentation;
  protected ShapeRectangle rect_uITabsModelBlocker;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_scenarios_SetDynamicParams_xjal( ShapeRoundedRectangle shape ) {
    shape.setLineColor(
p_energyHubLineColor 
);
    shape.setLineWidth(
p_energyHubLineWidth 
);
    shape.setLineStyle(
p_energyHubLineStyle 
);
  }
  
  protected ShapeRoundedRectangle rect_scenarios;
  protected ShapeText t_scenario;
  protected ShapeText txt_settings;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_map_SetDynamicParams_xjal( ShapeRoundedRectangle shape ) {
    shape.setLineColor(
p_energyHubLineColor 
);
    shape.setFillColor(
p_energyHubLineColor 
);
    shape.setLineWidth(
p_energyHubLineWidth 
);
    shape.setLineStyle(
p_energyHubLineStyle 
);
  }
  
  protected ShapeRoundedRectangle rect_map;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_title_SetDynamicParams_xjal( ShapeRoundedRectangle shape ) {
    shape.setLineColor(
p_energyHubLineColor 
);
    shape.setLineWidth(
p_energyHubLineWidth 
);
    shape.setLineStyle(
p_energyHubLineStyle 
);
  }
  
  protected ShapeRoundedRectangle rect_title;
  protected ShapeText txt_energyHubTitle;
  protected ShapeOval ovalEnergyHubLogo;
  protected ShapeLine line;
  protected ShapeLine line1;
  protected ShapeLine line2;
  protected ShapeOval oval;
  protected ShapeOval oval1;
  protected ShapeLine line3;
  protected ShapeOval oval4;
  protected ShapeOval oval3;
  protected ShapeGroup gr_energyHubLogo;
  protected ShapeGroup gr_energyHubTitle;
  protected ShapeEmbeddedObjectPresentation uI_Results_presentation;
  protected ShapeGroup gr_uI_Results_presentation;
  protected ShapeRoundedRectangle rect_exit;
  protected ShapeGroup gr_exitButton;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_loadIconSmall_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
p_energyHubLineColor 
);
  }
  
  protected ShapeRectangle rect_loadIconSmall;
  protected ShapeImage image_loadIconSmall;
  protected ShapeText t_loadIconSmall;
  protected ShapeGroup gr_loadIconYearSimulationEnergyHub;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_simulateYearScreenSmall_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
p_energyHubLineColor 
);
  }
  
  protected ShapeRectangle rect_simulateYearScreenSmall;
  protected ShapeText t_simulateYearToCalculateCostsSmall;
  protected ShapeImage image_simulateYearToCalculateCostsSmall;
  protected ShapeGroup gr_simulateYearButtonEnergyHub;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_simulateYearEnergyHub_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
-250 
);
    shape.setY(
15 
);
  }
  
  protected ShapeGroup gr_simulateYearEnergyHub;
  protected ShapeGroup gr_simulateYearScreenEnergyHub;
  protected ShapeRoundedRectangle rect_memberNames;
  protected ShapeText t_energyHubMember1;
  protected ShapeText t_energyHubMembers;
  protected ShapeText t_energyHubMember3;
  protected ShapeText t_energyHubMember2;
  protected ShapeText t_energyHubMember4;
  protected ShapeText t_energyHubMember5;
  protected ShapeText t_energyHubMember7;
  protected ShapeText t_energyHubMemberOthers;
  protected ShapeText t_energyHubMember6;
  protected ShapeRectangle rect_forceSaveLoadScenarioClickBlocker1;
  protected ShapeRectangle rect_forceSaveLoadScenarioClickBlocker2;
  protected ShapeRectangle rect_forceSaveLoadScenarioClickBlocker3;
  protected ShapeRectangle rect_forceSaveLoadScenarioClickBlocker4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_forceSaveLoadScenario1_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
zero_Interface.v_forcedClickScreenColor 
);
  }
  
  protected ShapeRectangle rect_forceSaveLoadScenario1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_forceSaveLoadScenario2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
zero_Interface.v_forcedClickScreenColor 
);
  }
  
  protected ShapeRectangle rect_forceSaveLoadScenario2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_forceSaveLoadScenario3_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
zero_Interface.v_forcedClickScreenColor 
);
  }
  
  protected ShapeRectangle rect_forceSaveLoadScenario3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_forceSaveLoadScenario4_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
zero_Interface.v_forcedClickScreenColor 
);
  }
  
  protected ShapeRectangle rect_forceSaveLoadScenario4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_forceSaveLoadScenario_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setY(
0 
);
  }
  
  protected ShapeGroup gr_forceSaveLoadScenario;
  protected ShapeImage image_saveScenario;
  protected ShapeText t_saveScenarioInstructions;
  protected ShapeGroup gr_saveScenario;
  protected ShapeImage image_loadScenario;
  protected ShapeText t_loadScenarioInstructions;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_loadScenario_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setY(
610 
);
  }
  
  protected ShapeGroup gr_loadScenario;
  protected ShapeGroup gr_saveAndLoadScenarios;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_date_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
zero_Interface.energyModel.v_isRapidRun ? zero_Interface.f_getDateString() : zero_Interface.f_getDateAndTimeString() 
);
  }
  
  protected ShapeText t_date;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    button_reconfigureEnergyHub = new ShapeButton(
UI_EnergyHub.this, true, 1100.0, 760.0,
			220.0, 40.0,
            black, true,
_button_reconfigureEnergyHub_Font,
			"Herconfigureer de EnergyHub" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_reconfigureEnergyHub, 0 );
      }
    };
    button_exit = new ShapeButton(
UI_EnergyHub.this, true, -86.886, -23.025,
			164.0, 46.0,
            null, true,
_button_exit_Font,
			"Terug naar hoofdscherm" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_exit, 0 );
      }
    };
    button_cancelSaveLoadScenario = new ShapeButton(
UI_EnergyHub.this, true, 305.0, 355.0,
			80.0, 30.0,
            black, true,
_button_cancelSaveLoadScenario_Font,
			"annuleren" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_cancelSaveLoadScenario, 0 );
      }
    };
    eb_scenarioName = new ShapeTextField(
UI_EnergyHub.this, true,0.0, 0.0,
			220.0, 25.0,
            white, black, true, _eb_scenarioName_Font ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _eb_scenarioName, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setText( getShapeControlDefaultValueString( _eb_scenarioName, 0 ) );
      }
    };
    combobox_selectScenario = new ShapeComboBox(
UI_EnergyHub.this, true, 0.0, 0.0,
			220.0, 25.0,
            white, black, true,
_combobox_selectScenario_Font,
            new String[]{"Geen Saves Beschikbaar", }, false, ShapeControl.TYPE_STRING );
    button_saveScenario = new ShapeButton(
UI_EnergyHub.this, true, -331.0, 555.0,
			140.0, 30.0,
            black, true,
_button_saveScenario_Font,
			"Bewaar een scenario" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_saveScenario, 0 );
      }
    };
    button_loadScenario = new ShapeButton(
UI_EnergyHub.this, true, -181.0, 555.0,
			140.0, 30.0,
            black, true,
_button_loadScenario_Font,
			"Laad een scenario in" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_loadScenario, 0 );
      }
    };
    rect_backGround = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            black, white,
			1920.0, 980.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_backGround_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_settings = new ShapeRoundedRectangle(
true,10.0, 440.0, 0.0,
        black, white,
380.0, 530.0,10.0,
		1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_settings_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_uITabsModelBlocker = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,400.0, 10.0, 0.0, 0.0,
            null, white,
			1500.0, 960.0, 10.0, 0.0, LINE_STYLE_SOLID );
    rect_uITabsModelBlocker.setVisible( false );
    rect_scenarios = new ShapeRoundedRectangle(
true,10.0, 90.0, 0.0,
        black, white,
380.0, 300.0,10.0,
		1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_scenarios_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_scenario = new ShapeText(
        SHAPE_DRAW_2D, true,200.0, 100.0, 0.0, 0.0,
        black,"Scenario's",
        _t_scenario_Font, ALIGNMENT_CENTER );
    txt_settings = new ShapeText(
        SHAPE_DRAW_2D, true,200.0, 460.0, 0.0, 0.0,
        black,"Instellingen",
        _txt_settings_Font, ALIGNMENT_CENTER );
    rect_map = new ShapeRoundedRectangle(
true,470.0, 190.0, 0.0,
        black, white,
870.0, 550.0,10.0,
		1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_map_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_title = new ShapeRoundedRectangle(
true,-440.0, -50.0, 0.0,
        black, white,
870.0, 110.0,10.0,
		1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_title_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_energyHubTitle = new ShapeText(
        SHAPE_DRAW_2D, true,-25.0, -25.0, 0.0, 0.0,
        black,"EnergyHub Configurator",
        _txt_energyHubTitle_Font, ALIGNMENT_CENTER );
    ovalEnergyHubLogo = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       whiteSmoke, _ovalEnergyHubLogo_Fill_Color,
	   48.1235, 48.1235, 10.0, 2.0, LINE_STYLE_SOLID );
    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -24.062, -16.844, 0.0, black,
 		47.0,	-6.0, 0.0, 1.5, 10.0, LINE_STYLE_SOLID );
    line1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -14.437, 14.437, 0.0, black,
 		37.0,	-38.0, 0.0, 1.5, 10.0, LINE_STYLE_SOLID );
    line2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -24.062, -9.625, 0.0, black,
 		42.0,	35.0, 0.0, 1.5, 10.0, LINE_STYLE_SOLID );
    oval = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-26.468, -14.437, 0.0, 0.0,
       black, whiteSmoke,
	   7.2185, 7.2185, 10.0, 1.0, LINE_STYLE_SOLID );
    oval1 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-19.25, 19.25, 0.0, 0.0,
       black, whiteSmoke,
	   7.2185, 7.2185, 10.0, 1.0, LINE_STYLE_SOLID );
    line3 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 19.25, 24.062, 0.0, black,
 		1.0,	-42.0, 0.0, 1.0, 10.0, LINE_STYLE_DOTTED );
    oval4 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,19.25, 24.062, 0.0, 0.0,
       black, whiteSmoke,
	   7.2185, 7.2185, 10.0, 1.0, LINE_STYLE_SOLID );
    oval3 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,24.062, -21.656, 0.0, 0.0,
       black, whiteSmoke,
	   7.2185, 7.2185, 10.0, 1.0, LINE_STYLE_SOLID );
    rect_exit = new ShapeRoundedRectangle(
true,-91.459, -27.63, 0.0,
        black, white,
173.773, 55.262,10.0,
		1.0, LINE_STYLE_SOLID );
    rect_loadIconSmall = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-219.0, -50.0, 0.0, 0.0,
            lavender, _rect_loadIconSmall_Fill_Color,
			460.0, 250.0, 10.0, 1.0, LINE_STYLE_DASHED ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_loadIconSmall_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    image_loadIconSmall = new ShapeImage(
		UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, -30.0, 60.0, 0.0, 0.0,
60.0, 60.0, "/zerointerfaceloader/",
			new String[]{"icon_loading.gif",} );
    t_loadIconSmall = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, 15.0, 0.0, 0.0,
        black,"Jaar wordt gesimuleerd ",
        _t_loadIconSmall_Font, ALIGNMENT_CENTER );
    rect_simulateYearScreenSmall = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -90.0, 0.0, 0.0,
            null, white,
			460.0, 180.0, 10.0, 1.0, LINE_STYLE_DASHED ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_simulateYearScreenSmall_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_simulateYearToCalculateCostsSmall = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, -60.0, 0.0, 0.0,
        black,"Simuleer jaar voor KPI's",
        _t_simulateYearToCalculateCostsSmall_Font, ALIGNMENT_CENTER );
    image_simulateYearToCalculateCostsSmall = new ShapeImage(
		UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, -200.0, -75.0, 0.0, 0.0,
60.0, 60.0, "/zerointerfaceloader/",
			new String[]{"icon_greater_than.png",} );
    rect_memberNames = new ShapeRoundedRectangle(
true,470.0, 760.0, 0.0,
        black, white,
500.0, 200.0,10.0,
		1.0, LINE_STYLE_SOLID );
    t_energyHubMember1 = new ShapeText(
        SHAPE_DRAW_2D, true,500.0, 820.0, 0.0, 0.0,
        black,"name 1",
        _t_energyHubMember1_Font, ALIGNMENT_LEFT );
    t_energyHubMembers = new ShapeText(
        SHAPE_DRAW_2D, true,720.0, 765.0, 0.0, 0.0,
        black,"E-Hub Members",
        _t_energyHubMembers_Font, ALIGNMENT_CENTER );
    t_energyHubMember3 = new ShapeText(
        SHAPE_DRAW_2D, true,500.0, 850.0, 0.0, 0.0,
        black,"name 3",
        _t_energyHubMember3_Font, ALIGNMENT_LEFT );
    t_energyHubMember2 = new ShapeText(
        SHAPE_DRAW_2D, true,930.0, 820.0, 0.0, 0.0,
        black,"name 2",
        _t_energyHubMember2_Font, ALIGNMENT_RIGHT );
    t_energyHubMember4 = new ShapeText(
        SHAPE_DRAW_2D, true,930.0, 850.0, 0.0, 0.0,
        black,"name 4",
        _t_energyHubMember4_Font, ALIGNMENT_RIGHT );
    t_energyHubMember5 = new ShapeText(
        SHAPE_DRAW_2D, true,500.0, 880.0, 0.0, 0.0,
        black,"name 5",
        _t_energyHubMember5_Font, ALIGNMENT_LEFT );
    t_energyHubMember7 = new ShapeText(
        SHAPE_DRAW_2D, true,500.0, 910.0, 0.0, 0.0,
        black,"name 7",
        _t_energyHubMember7_Font, ALIGNMENT_LEFT );
    t_energyHubMemberOthers = new ShapeText(
        SHAPE_DRAW_2D, true,930.0, 910.0, 0.0, 0.0,
        black,"Etc",
        _t_energyHubMemberOthers_Font, ALIGNMENT_RIGHT );
    t_energyHubMember6 = new ShapeText(
        SHAPE_DRAW_2D, true,930.0, 880.0, 0.0, 0.0,
        black,"name 6",
        _t_energyHubMember6_Font, ALIGNMENT_RIGHT );
    rect_forceSaveLoadScenarioClickBlocker1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, _rect_forceSaveLoadScenarioClickBlocker1_Fill_Color,
			10.0, 980.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_forceSaveLoadScenarioClickBlocker1, 0, clickx, clicky );
      }
    };
    rect_forceSaveLoadScenarioClickBlocker2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,10.0, 0.0, 0.0, 0.0,
            null, _rect_forceSaveLoadScenarioClickBlocker2_Fill_Color,
			380.0, 275.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_forceSaveLoadScenarioClickBlocker2, 0, clickx, clicky );
      }
    };
    rect_forceSaveLoadScenarioClickBlocker3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,10.0, 390.0, 0.0, 0.0,
            null, _rect_forceSaveLoadScenarioClickBlocker3_Fill_Color,
			380.0, 590.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_forceSaveLoadScenarioClickBlocker3, 0, clickx, clicky );
      }
    };
    rect_forceSaveLoadScenarioClickBlocker4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,390.0, 0.0, 0.0, 0.0,
            null, _rect_forceSaveLoadScenarioClickBlocker4_Fill_Color,
			1530.0, 980.0, 10.0, 1.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_forceSaveLoadScenarioClickBlocker4, 0, clickx, clicky );
      }
    };
    rect_forceSaveLoadScenario1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, _rect_forceSaveLoadScenario1_Fill_Color,
			10.0, 980.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_forceSaveLoadScenario1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_forceSaveLoadScenario2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,10.0, 0.0, 0.0, 0.0,
            null, _rect_forceSaveLoadScenario2_Fill_Color,
			380.0, 275.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_forceSaveLoadScenario2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_forceSaveLoadScenario3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,10.0, 390.0, 0.0, 0.0,
            null, _rect_forceSaveLoadScenario3_Fill_Color,
			380.0, 590.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_forceSaveLoadScenario3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_forceSaveLoadScenario4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,390.0, 0.0, 0.0, 0.0,
            null, _rect_forceSaveLoadScenario4_Fill_Color,
			1530.0, 980.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_forceSaveLoadScenario4_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    image_saveScenario = new ShapeImage(
		UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 225.0, -5.0, 0.0, 0.0,
32.0, 32.0, "/zerointerfaceloader/",
			new String[]{"save_icon.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _image_saveScenario, 0, clickx, clicky );
      }
    };
    t_saveScenarioInstructions = new ShapeText(
        SHAPE_DRAW_2D, true,5.0, -20.0, 0.0, 0.0,
        black,"Geef je scenario een naam en klik rechts op het icoontje",
        _t_saveScenarioInstructions_Font, ALIGNMENT_LEFT );
    image_loadScenario = new ShapeImage(
		UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 225.0, -5.0, 0.0, 0.0,
32.0, 32.0, "/zerointerfaceloader/",
			new String[]{"load_icon.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _image_loadScenario, 0, clickx, clicky );
      }
    };
    t_loadScenarioInstructions = new ShapeText(
        SHAPE_DRAW_2D, true,5.0, -20.0, 0.0, 0.0,
        black,"Selecteer een scenario in de keuzelijst en klik op het icoontje",
        _t_loadScenarioInstructions_Font, ALIGNMENT_LEFT );
    t_date = new ShapeText(
        SHAPE_DRAW_2D, true,490.0, 160.0, 0.0, 0.0,
        black,"Datum",
        _t_date_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_date_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    uI_Tabs_presentation = new ShapeEmbeddedObjectPresentation( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_uI_Tabs_presentation = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 0.0, -20.0, 0.0, 0.0
	
	     , uI_Tabs_presentation );
    }
    {
    gr_energyHubLogo = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, -350.0, 5.0, 0.0, 0.0
	
	     , ovalEnergyHubLogo
	     , line
	     , line1
	     , line2
	     , oval
	     , oval1
	     , line3
	     , oval4
	     , oval3 );
    }
    {
    gr_energyHubTitle = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 910.0, 80.0, 0.0, 0.0
	
	     , rect_title
	     , txt_energyHubTitle
	     , gr_energyHubLogo );
    }
    {
    uI_Results_presentation = new ShapeEmbeddedObjectPresentation( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, null );
    }
    {
    gr_uI_Results_presentation = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 1420.0, 200.0, 0.0, 0.0
	
	     , uI_Results_presentation );
    }
    {
    gr_exitButton = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 1245.0, 85.0, 0.0, 0.0
	
	     , rect_exit
	     , button_exit );
    }
    {
    gr_loadIconYearSimulationEnergyHub = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, -261.0, -25.0, 0.0, 0.0
	
	     , rect_loadIconSmall
	     , image_loadIconSmall
	     , t_loadIconSmall );
    }
    gr_loadIconYearSimulationEnergyHub.setVisible( false );
    {
    gr_simulateYearButtonEnergyHub = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 10.0, 50.0, 0.0, 0.0
	
	     , t_simulateYearToCalculateCostsSmall
	     , image_simulateYearToCalculateCostsSmall ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_simulateYearButtonEnergyHub, 0, clickx, clicky );
      }
    };
    }
    {
    gr_simulateYearEnergyHub = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 270.0, 20.0, 0.0, 0.0
	
	     , rect_simulateYearScreenSmall
	     , gr_simulateYearButtonEnergyHub ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_simulateYearEnergyHub_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_simulateYearEnergyHub.setVisible( false );
    {
    gr_simulateYearScreenEnergyHub = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 1900.0, 130.0, 0.0, 0.0
	
	     , gr_loadIconYearSimulationEnergyHub
	     , gr_simulateYearEnergyHub );
    }
    {
    gr_forceSaveLoadScenario = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 0.0, -1500.0, 0.0, 0.0
	
	     , rect_forceSaveLoadScenarioClickBlocker1
	     , rect_forceSaveLoadScenarioClickBlocker2
	     , rect_forceSaveLoadScenarioClickBlocker3
	     , rect_forceSaveLoadScenarioClickBlocker4
	     , rect_forceSaveLoadScenario1
	     , rect_forceSaveLoadScenario2
	     , rect_forceSaveLoadScenario3
	     , rect_forceSaveLoadScenario4
	     , button_cancelSaveLoadScenario ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_forceSaveLoadScenario_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_forceSaveLoadScenario.setVisible( false );
    {
    gr_saveScenario = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, -330.0, 610.0, 0.0, 0.0
	
	     , image_saveScenario
	     , eb_scenarioName
	     , t_saveScenarioInstructions );
    }
    gr_saveScenario.setVisible( false );
    {
    gr_loadScenario = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, -330.0, 665.0, 0.0, 0.0
	
	     , image_loadScenario
	     , combobox_selectScenario
	     , t_loadScenarioInstructions ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_loadScenario_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_loadScenario.setVisible( false );
    {
    gr_saveAndLoadScenarios = new ShapeGroup( UI_EnergyHub.this, SHAPE_DRAW_2D3D, true, 365.0, -270.0, 0.0, 0.0
	
	     , gr_saveScenario
	     , gr_loadScenario
	     , button_saveScenario
	     , button_loadScenario );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
    uI_Tabs_presentation.setEmbeddedObject_xjal( uI_Tabs );
    uI_Results_presentation.setEmbeddedObject_xjal( uI_Results );
    uI_Tabs_presentation.setEmbeddedObject_xjal( uI_Tabs );
    uI_Results_presentation.setEmbeddedObject_xjal( uI_Results );
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
  public UI_EnergyHub( Engine engine, Agent owner, AgentList<? extends UI_EnergyHub> ownerPopulation ) {
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
    uI_Tabs = instantiate_uI_Tabs_xjal();
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
  public UI_EnergyHub() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public UI_EnergyHub( Color p_energyHubBackGroundColor, Color p_energyHubLineColor, double p_energyHubLineWidth, LineStyle p_energyHubLineStyle ) {
    markParametersAreSet();
    this.p_energyHubBackGroundColor = p_energyHubBackGroundColor;
    this.p_energyHubLineColor = p_energyHubLineColor;
    this.p_energyHubLineWidth = p_energyHubLineWidth;
    this.p_energyHubLineStyle = p_energyHubLineStyle;
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
    setupPlainVariables_UI_EnergyHub_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( UI_EnergyHub.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( UI_EnergyHub.this, getElementProperty( "zerointerfaceloader.UI_EnergyHub.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
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
    setupParameters_uI_Tabs_xjal( uI_Tabs, null );
    doBeforeCreate_uI_Tabs_xjal( uI_Tabs, null );
    uI_Tabs.createAsEmbedded();
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( UI_EnergyHub.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    eb_scenarioName.setValueToDefault();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    uI_Results.startAsEmbedded();
    uI_Tabs.startAsEmbedded();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

zero_Interface.c_UIResultsInstances.add(uI_Results); 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_UI_EnergyHub_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_UI_EnergyHub_xjal() {
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
    list.add( uI_Results );
    list.add( uI_Tabs );
    return list;
  }

  public AgentList<? extends UI_EnergyHub> getPopulation() {
    return (AgentList<? extends UI_EnergyHub>) super.getPopulation();
  }

  public List<? extends UI_EnergyHub> agentsInRange( double distance ) {
    return (List<? extends UI_EnergyHub>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    uI_Results.onDestroy();
    uI_Tabs.onDestroy();
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    uI_Results.doFinish();
    uI_Tabs.doFinish();
  }


}
