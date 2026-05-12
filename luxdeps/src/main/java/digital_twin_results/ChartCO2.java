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

import zeroPackage.ZeroMath;
import java.text.DecimalFormat; 

public class ChartCO2 extends digital_twin_results.ChartArea
{
  // Parameters

  public 
Map<String, Pair<Double, Color>>  map_customCO2Additions_kg;

  /**
   * Returns default value for parameter <code>map_customCO2Additions_kg</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<String, Pair<Double, Color>> _map_customCO2Additions_kg_DefaultValue_xjal() {
    final ChartCO2 self = this;
    return null;
  }

  public void set_map_customCO2Additions_kg( Map<String, Pair<Double, Color>> value ) {
    if (value == this.map_customCO2Additions_kg) {
      return;
    }
    Map<String, Pair<Double, Color>> _oldValue_xjal = this.map_customCO2Additions_kg;
    this.map_customCO2Additions_kg = value;
    onChange_map_customCO2Additions_kg_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_customCO2Additions_kg.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_customCO2Additions_kg()</code> method instead.
   */
  protected void onChange_map_customCO2Additions_kg() {
    onChange_map_customCO2Additions_kg_xjal( map_customCO2Additions_kg );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_customCO2Additions_kg_xjal( Map<String, Pair<Double, Color>> oldValue ) {  
  }


  public 
String  p_totalName;

  /**
   * Returns default value for parameter <code>p_totalName</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_totalName_DefaultValue_xjal() {
    final ChartCO2 self = this;
    return 
"Totaal" 
;
  }

  public void set_p_totalName( String value ) {
    if (value == this.p_totalName) {
      return;
    }
    String _oldValue_xjal = this.p_totalName;
    this.p_totalName = value;
    onChange_p_totalName_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_totalName.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_totalName()</code> method instead.
   */
  protected void onChange_p_totalName() {
    onChange_p_totalName_xjal( p_totalName );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_totalName_xjal( String oldValue ) {  
  }


  public 
Map<String, Pair<Double, Color>>  map_customCO2Additions_previous_kg;

  /**
   * Returns default value for parameter <code>map_customCO2Additions_previous_kg</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<String, Pair<Double, Color>> _map_customCO2Additions_previous_kg_DefaultValue_xjal() {
    final ChartCO2 self = this;
    return null;
  }

  public void set_map_customCO2Additions_previous_kg( Map<String, Pair<Double, Color>> value ) {
    if (value == this.map_customCO2Additions_previous_kg) {
      return;
    }
    Map<String, Pair<Double, Color>> _oldValue_xjal = this.map_customCO2Additions_previous_kg;
    this.map_customCO2Additions_previous_kg = value;
    onChange_map_customCO2Additions_previous_kg_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_customCO2Additions_previous_kg.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_customCO2Additions_previous_kg()</code> method instead.
   */
  protected void onChange_map_customCO2Additions_previous_kg() {
    onChange_map_customCO2Additions_previous_kg_xjal( map_customCO2Additions_previous_kg );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_customCO2Additions_previous_kg_xjal( Map<String, Pair<Double, Color>> oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    map_customCO2Additions_kg = _map_customCO2Additions_kg_DefaultValue_xjal();
    p_totalName = _p_totalName_DefaultValue_xjal();
    map_customCO2Additions_previous_kg = _map_customCO2Additions_previous_kg_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "map_customCO2Additions_kg":
      if ( _callOnChange_xjal ) {
        set_map_customCO2Additions_kg( (Map<String, Pair<Double, Color>>) _value_xjal );
      } else {
        map_customCO2Additions_kg = (Map<String, Pair<Double, Color>>) _value_xjal;
      }
      return true;
    case "p_totalName":
      if ( _callOnChange_xjal ) {
        set_p_totalName( (String) _value_xjal );
      } else {
        p_totalName = (String) _value_xjal;
      }
      return true;
    case "map_customCO2Additions_previous_kg":
      if ( _callOnChange_xjal ) {
        set_map_customCO2Additions_previous_kg( (Map<String, Pair<Double, Color>>) _value_xjal );
      } else {
        map_customCO2Additions_previous_kg = (Map<String, Pair<Double, Color>>) _value_xjal;
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
    case "map_customCO2Additions_kg": _result_xjal = map_customCO2Additions_kg; break;
    case "p_totalName": _result_xjal = p_totalName; break;
    case "map_customCO2Additions_previous_kg": _result_xjal = map_customCO2Additions_previous_kg; break;
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
      list.add( "map_customCO2Additions_kg" );
      list.add( "p_totalName" );
      list.add( "map_customCO2Additions_previous_kg" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
Color 
 v_backgroundColor_override;
  public 
String 
 v_selectedEnergyCarrier;
  public 
String 
 v_selectedSupportChart;

  // Collection Variables
  public 
ArrayList <
OL_EnergyCarriers > c_defaultOrderEC = new ArrayList<OL_EnergyCarriers>();
  public 
ArrayList <
String > c_monthsOfTheYear = new ArrayList<String>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartCO2.class );

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


  // Events
	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _bar_CO2EmissionMonthly_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _pieChart_totalSubdivision_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _bar_CO2EmissionMonthly_autoUpdateEvent_xjal ) return "bar_CO2EmissionMonthly auto update event";
     if( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal ) return "pieChart_totalSubdivision auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _bar_CO2EmissionMonthly_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _bar_CO2EmissionMonthly_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    return super.getFirstOccurrenceTime( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( EventTimeout _e ) {
    double _t;
    if( _e == _bar_CO2EmissionMonthly_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == _bar_CO2EmissionMonthly_autoUpdateEvent_xjal ) {
      bar_CO2EmissionMonthly.updateData();
      return;
    }
    if ( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal ) {
      pieChart_totalSubdivision.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = digital_twin_results.ChartArea._STATECHART_COUNT_xjal + 0;


  // Functions

  void f_setYearlyKPIs( Double totalCO2Emission_kg, Double previousTotalCO2Emission_kg ) { 

//Set new values text
DecimalFormat df = new DecimalFormat("0.00");

t_totalCO2Emission_kg.setText(df.format(totalCO2Emission_kg/1000.0) + " ton");

if(previousTotalCO2Emission_kg != null){
	t_previousTotalCO2Emission_kg.setText(df.format(previousTotalCO2Emission_kg/1000.0) + " ton");
	
	////Set arrows
	if(previousTotalCO2Emission_kg > totalCO2Emission_kg){
		arrow_down_green_CO2Emission.setVisible(true);
	}
	else if(totalCO2Emission_kg > previousTotalCO2Emission_kg){
		arrow_up_red_CO2Emission.setVisible(true);
	}
	else{
		line_CO2Emission.setVisible(true);
	}
}
else{ // No previous rapid data -> dont show previous values
	t_previousTotalCO2Emission_kg.setText("-");
} 
  }

  void f_styleBackground_override( Color backgroundColor, Color lineColor, Double lineWidth, LineStyle lineStyle ) { 

//Function used to style the background of the graphs

v_backgroundColor = v_backgroundColor_override;

if(lineColor != null){
	v_lineColor = lineColor;
}

if(lineWidth != null){
 v_lineWidth = lineWidth;
}
if(lineStyle != null){
 v_lineStyle = lineStyle;
} 
  }

  void f_resetChart(  ) { 

//Reset all arrow visibility
arrow_down_green_CO2Emission.setVisible(false);
arrow_up_red_CO2Emission.setVisible(false);
line_CO2Emission.setVisible(false);

//Reset KPIS
t_totalCO2Emission_kg.setText("-");
t_previousTotalCO2Emission_kg.setText("-");

//Clear monthly chart
bar_CO2EmissionMonthly.removeAll();
gr_monthlyCO2EmissionCharts.setVisible(false);

//Clear pie chart
pieChart_totalSubdivision.removeAll();
gr_subChart_totalSubdivision.setVisible(false); 
  }

  void f_setMonthlyChart( double[] monthlyCO2Emission_kg ) { 

DataSet netCosts_eur = new DataSet(12);

double maxChartValue_eur = 0;

for (int i = 0; i < 12; i++) {
	//Import cost
	DataItem CO2Emission_kg = new DataItem();
	CO2Emission_kg.setValue(monthlyCO2Emission_kg[i]/1000.0);
	bar_CO2EmissionMonthly.addDataItem(CO2Emission_kg, c_monthsOfTheYear.get(i), uI_Results.v_electricityDemandColor);
	
	maxChartValue_eur = max(maxChartValue_eur, monthlyCO2Emission_kg[i]/1000.0);
}

//Set fixed scale
maxChartValue_eur *=1.2;
bar_CO2EmissionMonthly.setFixedScale(0, maxChartValue_eur);
gr_monthlyCO2EmissionCharts.setVisible(true); 
  }

  
double[] 
 f_calculateMonthlyECCO2Emission_kg( double[] ECBalance_kW, double signalResolution_h, OL_EnergyCarriers EC ) { 

double[] startHourPerMonth = uI_Results.energyModel.p_timeParameters.getMonthStartHours();
double timeStep_h = uI_Results.energyModel.p_timeParameters.getTimeStep_h();

double energyCarrierCO2Emission_kg_p_kWh = uI_Results.energyModel.avgc_data.map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh.get(EC);

double[] monthlyElectricityImportCO2Emission_kg = new double[12];


int hoursInYear = 8760;
double modelStartTime_h = uI_Results.energyModel.p_timeParameters.getRunStartTime_h();
int currentMonth = 11;
for(int i = 0; i< 11;i++){
	if(startHourPerMonth[i+1]>= modelStartTime_h){
		currentMonth = i; 
		break;
	}
}
for (int i = 0; i < ECBalance_kW.length; i++) {
	if(currentMonth == 11){
		if ((i*signalResolution_h + modelStartTime_h) > hoursInYear){
			currentMonth = 0;
		}
	}
	else if(startHourPerMonth[currentMonth+1] < (i*signalResolution_h + modelStartTime_h) % hoursInYear){
		currentMonth += 1;
	}
	
	double currentECImport_kW = max(0, ECBalance_kW[i]);
	if(currentECImport_kW == 0){
		continue;
	}
	
	if(EC == OL_EnergyCarriers.ELECTRICITY){
		energyCarrierCO2Emission_kg_p_kWh = uI_Results.energyModel.pp_CO2EmissionFactorElectricityImport_kgpkWh.getValue((i*signalResolution_h + modelStartTime_h) % hoursInYear);
	}
	
    double timestepCO2Emission_kg = energyCarrierCO2Emission_kg_p_kWh * currentECImport_kW * signalResolution_h;
    
    monthlyElectricityImportCO2Emission_kg[currentMonth] += timestepCO2Emission_kg;
}

return monthlyElectricityImportCO2Emission_kg; 
  }

  public void f_setCustomCO2Map( Map<String, Pair<Double, Color>> customCO2AdditionsMap ) { 

map_customCO2Additions_kg = customCO2AdditionsMap; 
  }

  public void f_setChartCO2(  ) { 

//Initialization of data object.
I_EnergyData data = uI_Results.f_getSelectedObjectData();

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 60, true);

//Initialize the EnergyCarrier selection ComboBox
f_initializeECSelectionComboBox(data);

//Set support chart defauls as monthly
v_selectedSupportChart = "Monthly";

//Set the actual values of the chart (while trying to maintain the previous selected EC)
String currentSelectedECReadableName = v_selectedEnergyCarrier.equals(p_totalName) ? p_totalName : uI_Results.f_getECName(OL_EnergyCarriers.valueOf(v_selectedEnergyCarrier));
if (Arrays.asList(cb_energyCarrierSelection.getItems()).contains(currentSelectedECReadableName)) {
	cb_energyCarrierSelection.setValue(currentSelectedECReadableName, true);
}
else{
	cb_energyCarrierSelection.setValue(uI_Results.f_getECName(OL_EnergyCarriers.ELECTRICITY), true);
} 
  }

  void f_setChartCO2Values(  ) { 

I_EnergyData data = uI_Results.f_getSelectedObjectData();

//Reset chart
f_resetChart();


//Get selected List
List<OL_EnergyCarriers> selectedECList;
if(v_selectedEnergyCarrier.equals(p_totalName)){
	if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE){
		selectedECList = new ArrayList<>(List.of(uI_Results.v_gridNode.p_energyCarrier));
	}
	else{
		selectedECList = new ArrayList<>(data.getRapidRunData().activeConsumptionEnergyCarriers);
	}
}
else{
	selectedECList = new ArrayList<>(List.of(OL_EnergyCarriers.valueOf(v_selectedEnergyCarrier)));
}


double[] monthlyCO2Emissions_kg = new double[12];
Map<OL_EnergyCarriers, double[]> map_monthlyCO2EmissionsPerEC_kg = new HashMap<>();

for(OL_EnergyCarriers EC : selectedECList){
	//Get the ECBalance values
	double[] ECBalance_kW;
	double signalResolution_h;
	if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE){
		if(EC == OL_EnergyCarriers.ELECTRICITY){
			ECBalance_kW = uI_Results.v_gridNode.acc_annualElectricityBalance_kW.getTimeSeries_kW();
			signalResolution_h = uI_Results.v_gridNode.acc_annualElectricityBalance_kW.getSignalResolution_h();
		}
		else{ //if(EC == OL_EnergyCarriers.HEAT){
			ECBalance_kW = uI_Results.v_gridNode.acc_annualHeatBalance_kW.getTimeSeries_kW();
			signalResolution_h = uI_Results.v_gridNode.acc_annualHeatBalance_kW.getSignalResolution_h();
		}
	}
	else{
		if(EC == OL_EnergyCarriers.HEAT && !data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW)){
			continue;
		}
		ECBalance_kW = data.getRapidRunData().am_totalBalanceAccumulators_kW.get(EC).getTimeSeries_kW();
		signalResolution_h = data.getRapidRunData().am_totalBalanceAccumulators_kW.get(EC).getSignalResolution_h();
	}
	
	//Calculate values
	double[] monthlyECCO2Emissions_kg = f_calculateMonthlyECCO2Emission_kg(ECBalance_kW, signalResolution_h, EC);
	
	//Save totals also per EC
	map_monthlyCO2EmissionsPerEC_kg.put(EC, monthlyECCO2Emissions_kg);
	
	//Add values of this EC to the total
	for(int i = 0; i < 12; i++){
		monthlyCO2Emissions_kg[i] += monthlyECCO2Emissions_kg[i];
	}	
}

//Calculate total CO2 emissions due EC import
double totalCO2Emissions_kg = ZeroMath.arraySum(monthlyCO2Emissions_kg);


//Add custom co2 additions
if(map_customCO2Additions_kg != null && map_customCO2Additions_kg.size()>0 && data instanceof EnergyModel){
	totalCO2Emissions_kg += sum(map_customCO2Additions_kg.values(), value -> max(0, value.getFirst().doubleValue()));
}


//Previous values
Double previoustotalCO2Emissions_kg = null;

if(data.getPreviousRapidRunData() != null){
	//It is possible that previous rapid run has other set of EC than current rapid run, so list needs to be recreated.
	List<OL_EnergyCarriers> selectedECList_previousRapidRun =new ArrayList<>();
	if(v_selectedEnergyCarrier.equals("Totaal")){ 
		selectedECList_previousRapidRun.addAll(data.getPreviousRapidRunData().activeEnergyCarriers);
	}
	else if(data.getPreviousRapidRunData().activeEnergyCarriers.contains(selectedECList.get(0))){
		selectedECList_previousRapidRun = selectedECList;
	}
	//Initialize previous values with 0. (Even if selectedECList_previousRapidRun remains empty due to diff in EC between rapid runs this makes sense!)
	previoustotalCO2Emissions_kg = 0.0;		

	for(OL_EnergyCarriers EC : selectedECList_previousRapidRun){
		if(EC == OL_EnergyCarriers.HEAT && !data.getPreviousRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW)){
			continue;
		}
		
		double[] previousECBalance_kW = data.getPreviousRapidRunData().am_totalBalanceAccumulators_kW.get(EC).getTimeSeries_kW();
		double previousSignalResolution_h = data.getPreviousRapidRunData().am_totalBalanceAccumulators_kW.get(EC).getSignalResolution_h();
		
		double[] previousMonthlyECCO2Emissions_kg = f_calculateMonthlyECCO2Emission_kg(previousECBalance_kW, previousSignalResolution_h, EC);
	
		previoustotalCO2Emissions_kg += ZeroMath.arraySum(previousMonthlyECCO2Emissions_kg);
	}
	
	//Add custom co2 additions previous run to previous total
	if(map_customCO2Additions_previous_kg != null && map_customCO2Additions_previous_kg.size()>0 && data instanceof EnergyModel){
		previoustotalCO2Emissions_kg += sum(map_customCO2Additions_previous_kg.values(), value -> max(0, value.getFirst().doubleValue()));
	}
}

//Set yearly kpis
f_setYearlyKPIs(totalCO2Emissions_kg, previoustotalCO2Emissions_kg);

//Set sub chart
if(uI_Results.energyModel.p_timeParameters.getRunDuration_h() >= 8760 && v_selectedSupportChart.equals("Monthly")){
	f_setMonthlyChart(monthlyCO2Emissions_kg);
}
else if(v_selectedEnergyCarrier.equals(p_totalName)){
	f_setPieChart(map_monthlyCO2EmissionsPerEC_kg, data);
}
 
  }

  void f_initializeECSelectionComboBox( I_EnergyData data ) { 

//Get energy carrier options (also previous run EC that are not in current).
Set<OL_EnergyCarriers> energyCarriers = new HashSet<>();
if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE){
	energyCarriers.add(uI_Results.v_gridNode.p_energyCarrier);
}
else{
	energyCarriers.addAll(data.getRapidRunData().activeConsumptionEnergyCarriers);
	boolean hasHadDistrictHeating = data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW);
	
	if(data.getPreviousRapidRunData() != null){
		energyCarriers.addAll(data.getPreviousRapidRunData().activeConsumptionEnergyCarriers);
		if(!hasHadDistrictHeating){
			hasHadDistrictHeating = data.getPreviousRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW);
		}
	}
	
	if(energyCarriers.contains(OL_EnergyCarriers.HEAT) && !hasHadDistrictHeating){
		energyCarriers.remove(OL_EnergyCarriers.HEAT);
	}
}

//Order the list to always have the same order
List<OL_EnergyCarriers> orderedEnergyCarriers = new ArrayList<>();
for(OL_EnergyCarriers EC : c_defaultOrderEC){
	if(energyCarriers.contains(EC)){
		orderedEnergyCarriers.add(EC);
	}
}


//Convert to the readable combobox options
String[] comboBoxOptions = new String[orderedEnergyCarriers.size() + 1];
int i = 0;
for(OL_EnergyCarriers EC : orderedEnergyCarriers){
	comboBoxOptions[i] = uI_Results.f_getECName(EC);
	i++;
}
comboBoxOptions[i] = p_totalName;

cb_energyCarrierSelection.setItems(comboBoxOptions);
 
  }

  public void f_storePreviousCustomCO2AdditionsMap(  ) { 

map_customCO2Additions_previous_kg = map_customCO2Additions_kg; 
  }

  void f_setPieChart( Map<OL_EnergyCarriers, double[]> map_totalCO2EmissionsPerEC_kg, I_EnergyData data ) { 

for(OL_EnergyCarriers EC : map_totalCO2EmissionsPerEC_kg.keySet()){
	DataItem CO2Emission_ton = new DataItem();
	CO2Emission_ton.setValue(ZeroMath.arraySum(map_totalCO2EmissionsPerEC_kg.get(EC))/1000.0);
	pieChart_totalSubdivision.addDataItem(CO2Emission_ton, uI_Results.f_getECName(EC), uI_Results.cm_consumptionColors.get(EC));
}

if(map_customCO2Additions_kg != null && data instanceof EnergyModel){
	for(String customEntry : map_customCO2Additions_kg.keySet()){
		DataItem CO2Emission_ton = new DataItem();
		CO2Emission_ton.setValue(map_customCO2Additions_kg.get(customEntry).getFirst()/1000.0);
		pieChart_totalSubdivision.addDataItem(CO2Emission_ton, customEntry, map_customCO2Additions_kg.get(customEntry).getSecond());
	}
}

v_selectedSupportChart = "Pie";
gr_subChart_totalSubdivision.setVisible(true); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_energyCarrierSelection_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_selectedSupportChart_Font = _cb_energyCarrierSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_CO2EmissionChart_Font = new Font("SansSerif", 1, 26 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalCO2Emission_kg_Font = new Font("SansSerif", 3, 24 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalCO2Emission_kg_Font = new Font("SansSerif", 3, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_yearlyCO2Emission_Font = new Font("SansSerif", 1, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_previousTotalCO2Emission_Font = new Font("SansSerif", 0, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_CO2EmissionMonthly_Font = new Font("SansSerif", 0, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_jan_Font = new Font("SansSerif", 1, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_feb_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_mar_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_apr_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_mei_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_jun_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_jul_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_aug_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_sep_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_okt_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_nov_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartXaxis_dec_Font = _txt_chartXaxis_jan_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_barChartCO2EmissionLegend_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_selectedEnergyCarrier_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalSubdivision_Font = _txt_CO2EmissionMonthly_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_headerKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_CO2EmissionChart = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_chartCO2Emission = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_red_CO2Emission = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_green_CO2Emission = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_CO2Emission = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_diffTotalCO2Emission = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalCO2Emission_kg = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalCO2Emission_kg = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_yearlyCO2Emission = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_previousTotalCO2Emission = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_yearlyCO2Consumption = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_CO2EmissionMonthly = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_jan = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_feb = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_mar = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_apr = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_mei = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_jun = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_jul = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_aug = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_sep = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_okt = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_nov = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_dec = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_monthlyChartXaxis = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_legendCO2EmissionMonthly = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_barChartCO2EmissionLegend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_CO2EmissionMonthly = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_monthlyCO2EmissionCharts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_selectedEnergyCarrier = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalSubdivision = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_subChart_totalSubdivision = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _bar_CO2EmissionMonthly = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _pieChart_totalSubdivision = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_energyCarrierSelection = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_selectedSupportChart = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 37;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 38;

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
	  level.addAll(rect_headerKPI, txt_CO2EmissionChart, i_chartCO2Emission, gr_yearlyCO2Consumption, gr_monthlyCO2EmissionCharts, txt_selectedEnergyCarrier, cb_energyCarrierSelection, button_selectedSupportChart, gr_subChart_totalSubdivision);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_chartCO2Emission:
        if (true) {
          ShapeImage self = this.i_chartCO2Emission;
          
uI_Results.f_setInfoText(i_chartCO2Emission, uI_Results.v_infoText.chartCO2, i_chartCO2Emission.getX(), i_chartCO2Emission.getY()); 
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
      case _button_selectedSupportChart: {
          ShapeButton self = this.button_selectedSupportChart;
if(v_selectedSupportChart.equals("Monthly")){
	v_selectedSupportChart = "Pie";
}
else{
	v_selectedSupportChart = "Monthly";
}

f_setChartCO2Values(); 
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
      case _cb_energyCarrierSelection: {
          ShapeComboBox self = this.cb_energyCarrierSelection;
if(cb_energyCarrierSelection.getValue().equals(p_totalName)){
	v_selectedEnergyCarrier = p_totalName;
}
else{
	for(OL_EnergyCarriers EC : c_defaultOrderEC){
		if(cb_energyCarrierSelection.getValue().equals(uI_Results.f_getECName(EC))){
			v_selectedEnergyCarrier = EC.toString();
		}
		v_selectedSupportChart = "Monthly";
	}
}

f_setChartCO2Values();
 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
        
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem4Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem5Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem6Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem7Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem8Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem9Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem10Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_CO2EmissionMonthly_DataItem11Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pieChart_totalSubdivision_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pieChart_totalSubdivision_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pieChart_totalSubdivision_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pieChart_totalSubdivision_DataItem3Value() {
    return 
0 
;
  }
  protected ShapeComboBox cb_energyCarrierSelection;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_selectedSupportChart_SetDynamicParams_xjal( ShapeButton shape ) {
    boolean _visible = 
v_selectedEnergyCarrier.equals(p_totalName) 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
uI_Results.energyModel.p_timeParameters.getRunDuration_h() >= 8760 
);
    shape.setText(
v_selectedSupportChart.equals("Monthly") ? "Totaal verdeling" : "Maandelijkse verdeling" 
);
 	}
  }
  
  protected ShapeButton button_selectedSupportChart;
  protected BarChart bar_CO2EmissionMonthly;
  protected PieChart pieChart_totalSubdivision;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_headerKPI_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_lineColor 
);
    shape.setLineWidth(
v_lineWidth 
);
  }
  
  protected ShapeRectangle rect_headerKPI;
  protected ShapeText txt_CO2EmissionChart;
  protected ShapeImage i_chartCO2Emission;
  protected ShapeImage arrow_up_red_CO2Emission;
  protected ShapeImage arrow_down_green_CO2Emission;
  protected ShapeLine line_CO2Emission;
  protected ShapeGroup arrows_diffTotalCO2Emission;
  protected ShapeText t_totalCO2Emission_kg;
  protected ShapeText t_previousTotalCO2Emission_kg;
  protected ShapeText txt_yearlyCO2Emission;
  protected ShapeText txt_previousTotalCO2Emission;
  protected ShapeGroup gr_yearlyCO2Consumption;
  protected ShapeText txt_CO2EmissionMonthly;
  protected ShapeText txt_chartXaxis_jan;
  protected ShapeText txt_chartXaxis_feb;
  protected ShapeText txt_chartXaxis_mar;
  protected ShapeText txt_chartXaxis_apr;
  protected ShapeText txt_chartXaxis_mei;
  protected ShapeText txt_chartXaxis_jun;
  protected ShapeText txt_chartXaxis_jul;
  protected ShapeText txt_chartXaxis_aug;
  protected ShapeText txt_chartXaxis_sep;
  protected ShapeText txt_chartXaxis_okt;
  protected ShapeText txt_chartXaxis_nov;
  protected ShapeText txt_chartXaxis_dec;
  protected ShapeGroup gr_monthlyChartXaxis;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_legendCO2EmissionMonthly_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
uI_Results.v_electricityDemandColor 
);
  }
  
  protected ShapeRectangle rect_legendCO2EmissionMonthly;
  protected ShapeText txt_barChartCO2EmissionLegend;
  protected ShapeGroup gr_CO2EmissionMonthly;
  protected ShapeGroup gr_monthlyCO2EmissionCharts;
  protected ShapeText txt_selectedEnergyCarrier;
  protected ShapeText txt_totalSubdivision;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_subChart_totalSubdivision_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
235 
);
    shape.setY(
540 
);
  }
  
  protected ShapeGroup gr_subChart_totalSubdivision;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    cb_energyCarrierSelection = new ShapeComboBox(
ChartCO2.this, true, 300.0, 130.0,
			130.0, 20.0,
            white, black, true,
_cb_energyCarrierSelection_Font,
            new String[]{"Elektriciteit", "Gas", "Diesel & Benzine", "Waterstof", "Warmte", "IJzerpoeder", "Totaal", }, false, ShapeControl.TYPE_STRING ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_energyCarrierSelection, 0, value );
      }
    };
    button_selectedSupportChart = new ShapeButton(
ChartCO2.this, true, 320.0, 715.0,
			135.0, 30.0,
            black, true,
_button_selectedSupportChart_Font,
			"Totaal verdeling" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_selectedSupportChart_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_selectedSupportChart, 0 );
      }
    };
    rect_headerKPI = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            lavender, whiteSmoke,
			460.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_headerKPI_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_CO2EmissionChart = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 10.0, 0.0, 0.0,
        black,"CO2 uitstoot",
        _txt_CO2EmissionChart_Font, ALIGNMENT_CENTER );
    i_chartCO2Emission = new ShapeImage(
		ChartCO2.this, SHAPE_DRAW_2D3D, true, 360.0, 10.0, 0.0, 0.0,
30.0, 30.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_chartCO2Emission, 0, clickx, clicky );
      }
    };
    arrow_up_red_CO2Emission = new ShapeImage(
		ChartCO2.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_red.png",} );
    arrow_up_red_CO2Emission.setVisible( false );
    arrow_down_green_CO2Emission = new ShapeImage(
		ChartCO2.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_green.png",} );
    arrow_down_green_CO2Emission.setVisible( false );
    line_CO2Emission = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_CO2Emission.setVisible( false );
    t_totalCO2Emission_kg = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -50.0, 0.0, 0.0,
        black,"150.5 ton",
        _t_totalCO2Emission_kg_Font, ALIGNMENT_CENTER );
    t_previousTotalCO2Emission_kg = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, 30.0, 0.0, 0.0,
        black,"150.5 ton",
        _t_previousTotalCO2Emission_kg_Font, ALIGNMENT_CENTER );
    txt_yearlyCO2Emission = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -100.0, 0.0, 0.0,
        black,"Jaarlijkse CO2 uitstoot:",
        _txt_yearlyCO2Emission_Font, ALIGNMENT_CENTER );
    txt_previousTotalCO2Emission = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, 0.0, 0.0, 0.0,
        black,"Vorige simulatie: ",
        _txt_previousTotalCO2Emission_Font, ALIGNMENT_CENTER );
    txt_CO2EmissionMonthly = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, -140.0, 0.0, 0.0,
        black,"Maandelijkse CO2 uitstoot [ton]",
        _txt_CO2EmissionMonthly_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_jan = new ShapeText(
        SHAPE_DRAW_2D, true,-169.19, -4.311, 0.0, 0.0,
        black,"jan",
        _txt_chartXaxis_jan_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_feb = new ShapeText(
        SHAPE_DRAW_2D, true,-137.91, -4.311, 0.0, 0.0,
        black,"feb",
        _txt_chartXaxis_feb_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_mar = new ShapeText(
        SHAPE_DRAW_2D, true,-107.584, -4.311, 0.0, 0.0,
        black,"mrt",
        _txt_chartXaxis_mar_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_apr = new ShapeText(
        SHAPE_DRAW_2D, true,-77.259, -4.311, 0.0, 0.0,
        black,"apr",
        _txt_chartXaxis_apr_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_mei = new ShapeText(
        SHAPE_DRAW_2D, true,-45.954, -4.311, 0.0, 0.0,
        black,"mei",
        _txt_chartXaxis_mei_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_jun = new ShapeText(
        SHAPE_DRAW_2D, true,-14.674, -4.311, 0.0, 0.0,
        black,"jun",
        _txt_chartXaxis_jun_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_jul = new ShapeText(
        SHAPE_DRAW_2D, true,15.651, -4.311, 0.0, 0.0,
        black,"jul",
        _txt_chartXaxis_jul_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_aug = new ShapeText(
        SHAPE_DRAW_2D, true,46.954, -4.311, 0.0, 0.0,
        black,"aug",
        _txt_chartXaxis_aug_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_sep = new ShapeText(
        SHAPE_DRAW_2D, true,77.259, -4.311, 0.0, 0.0,
        black,"sep",
        _txt_chartXaxis_sep_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_okt = new ShapeText(
        SHAPE_DRAW_2D, true,107.604, -4.311, 0.0, 0.0,
        black,"okt",
        _txt_chartXaxis_okt_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_nov = new ShapeText(
        SHAPE_DRAW_2D, true,138.91, -4.311, 0.0, 0.0,
        black,"nov",
        _txt_chartXaxis_nov_Font, ALIGNMENT_CENTER );
    txt_chartXaxis_dec = new ShapeText(
        SHAPE_DRAW_2D, true,169.213, -4.311, 0.0, 0.0,
        black,"dec",
        _txt_chartXaxis_dec_Font, ALIGNMENT_CENTER );
    rect_legendCO2EmissionMonthly = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-100.0, -30.0, 0.0, 0.0,
            black, red,
			10.0, 10.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_legendCO2EmissionMonthly_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_barChartCO2EmissionLegend = new ShapeText(
        SHAPE_DRAW_2D, true,-80.0, -30.0, 0.0, 0.0,
        black,"CO2 uitstoot per maand",
        _txt_barChartCO2EmissionLegend_Font, ALIGNMENT_LEFT );
    txt_selectedEnergyCarrier = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 130.0, 0.0, 0.0,
        black,"Geselecteerde energiedrager:",
        _txt_selectedEnergyCarrier_Font, ALIGNMENT_LEFT );
    txt_totalSubdivision = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -160.0, 0.0, 0.0,
        black,"Totaal verdeling",
        _txt_totalSubdivision_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataItem> _items = new ArrayList<>( 12 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem3Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem4Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem5Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem6Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem7Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem8Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem9Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem10Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_CO2EmissionMonthly_DataItem11Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 12 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    _titles.add( "Title 2" );
    _titles.add( "Title 3" );
    _titles.add( "Title 4" );
    _titles.add( "Title 5" );
    _titles.add( "Title 6" );
    _titles.add( "Title 7" );
    _titles.add( "Title 8" );
    _titles.add( "Title 9" );
    _titles.add( "Title 10" );
    _titles.add( "Title 11" );
    List<Color> _colors = new ArrayList<>( 12 );
    _colors.add( red );
    _colors.add( red );
    _colors.add( red );
    _colors.add( red );
    _colors.add( red );
    _colors.add( red );
    _colors.add( red );
    _colors.add( red );
    _colors.add( red );
    _colors.add( red );
    _colors.add( red );
    _colors.add( red );
    bar_CO2EmissionMonthly = new BarChart(
ChartCO2.this, true, -220.0, -120.0,
			440.0, 280.0,
            null, null,
            50.0, 30.0,
			370.0, 220.0, white, black, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0, 0.75,
            Chart.GRID_DEFAULT,
            silver, darkGray, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pieChart_totalSubdivision_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pieChart_totalSubdivision_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pieChart_totalSubdivision_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pieChart_totalSubdivision_DataItem3Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 4 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    _titles.add( "Title 2" );
    _titles.add( "Title 3" );
    List<Color> _colors = new ArrayList<>( 4 );
    _colors.add( lightSlateBlue );
    _colors.add( deepPink );
    _colors.add( darkOrange );
    _colors.add( mediumSeaGreen );
    pieChart_totalSubdivision = new PieChart(
ChartCO2.this, true, -160.0, -130.0,
			320.0, 284.444,
            null, null,
            60.0, 10.0,
			200.0, 200.0, null, black,
            60.0, Chart.SOUTH,
            _items, _titles, _colors );
    }
    {
    arrows_diffTotalCO2Emission = new ShapeGroup( ChartCO2.this, SHAPE_DRAW_2D3D, true, -95.0, -33.0, 0.0, 0.0
	
	     , arrow_up_red_CO2Emission
	     , arrow_down_green_CO2Emission
	     , line_CO2Emission );
    }
    {
    gr_yearlyCO2Consumption = new ShapeGroup( ChartCO2.this, SHAPE_DRAW_2D3D, true, 235.0, 290.0, 0.0, 0.0
	
	     , arrows_diffTotalCO2Emission
	     , t_totalCO2Emission_kg
	     , t_previousTotalCO2Emission_kg
	     , txt_yearlyCO2Emission
	     , txt_previousTotalCO2Emission );
    }
    {
    gr_monthlyChartXaxis = new ShapeGroup( ChartCO2.this, SHAPE_DRAW_2D, true, 15.0, 140.0, 0.0, 0.0
	
	     , txt_chartXaxis_jan
	     , txt_chartXaxis_feb
	     , txt_chartXaxis_mar
	     , txt_chartXaxis_apr
	     , txt_chartXaxis_mei
	     , txt_chartXaxis_jun
	     , txt_chartXaxis_jul
	     , txt_chartXaxis_aug
	     , txt_chartXaxis_sep
	     , txt_chartXaxis_okt
	     , txt_chartXaxis_nov
	     , txt_chartXaxis_dec );
    }
    {
    gr_CO2EmissionMonthly = new ShapeGroup( ChartCO2.this, SHAPE_DRAW_2D3D, true, -70.0, 195.0, 0.0, 0.0
	
	     , rect_legendCO2EmissionMonthly
	     , txt_barChartCO2EmissionLegend );
    }
    {
    gr_monthlyCO2EmissionCharts = new ShapeGroup( ChartCO2.this, SHAPE_DRAW_2D3D, true, 225.0, 520.0, 0.0, 0.0
	
	     , txt_CO2EmissionMonthly
	     , bar_CO2EmissionMonthly
	     , gr_monthlyChartXaxis
	     , gr_CO2EmissionMonthly );
    }
    {
    gr_subChart_totalSubdivision = new ShapeGroup( ChartCO2.this, SHAPE_DRAW_2D3D, true, 820.0, 480.0, 0.0, 0.0
	
	     , pieChart_totalSubdivision
	     , txt_totalSubdivision ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_subChart_totalSubdivision_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
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
  public ChartCO2( Engine engine, Agent owner, AgentList<? extends ChartCO2> ownerPopulation ) {
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
    uI_Results = get_UI_Results();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public ChartCO2() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public ChartCO2( Map<String, Pair<Double, Color>> map_customCO2Additions_kg, String p_totalName, Map<String, Pair<Double, Color>> map_customCO2Additions_previous_kg ) {
    markParametersAreSet();
    this.map_customCO2Additions_kg = map_customCO2Additions_kg;
    this.p_totalName = p_totalName;
    this.map_customCO2Additions_previous_kg = map_customCO2Additions_previous_kg;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartCO2_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
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
    addAll( c_monthsOfTheYear, new String[] 
{
"Jan",
"Feb",
"Mar",
"Apr",
"Mei",
"Jun",
"Jul",
"Aug",
"Sep",
"Okt",
"Nov",
"Dec",
} 
    );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartCO2.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartCO2.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _bar_CO2EmissionMonthly_autoUpdateEvent_xjal.start();
    _pieChart_totalSubdivision_autoUpdateEvent_xjal.start();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartCO2_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartCO2_xjal() {
    v_backgroundColor_override = 
white 
;
    v_selectedEnergyCarrier = 
"ELECTRICITY" 
;
    v_selectedSupportChart = 
"Monthly" 
;
  }

  // User API -----------------------------------------------------
  public UI_Results get_UI_Results() {
    {
      Agent owner = getOwner();
      if ( owner instanceof UI_Results ) return (UI_Results) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient digital_twin_results.UI_Results uI_Results;

  public AgentList<? extends ChartCO2> getPopulation() {
    return (AgentList<? extends ChartCO2>) super.getPopulation();
  }

  public List<? extends ChartCO2> agentsInRange( double distance ) {
    return (List<? extends ChartCO2>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _bar_CO2EmissionMonthly_autoUpdateEvent_xjal ) return false;
    if ( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _bar_CO2EmissionMonthly_autoUpdateEvent_xjal.onDestroy();
    _pieChart_totalSubdivision_autoUpdateEvent_xjal.onDestroy();
    super.onDestroy();
  }


}
