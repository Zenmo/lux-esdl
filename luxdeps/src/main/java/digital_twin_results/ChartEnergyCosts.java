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

import java.text.DecimalFormat;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.data.flow.NodeKey;
import org.jfree.graphics2d.svg.SVGUnits;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.CategoryAxis;
import zeroPackage.ZeroMath; 

public class ChartEnergyCosts extends digital_twin_results.ChartArea
{
  // Parameters

  public 
String  p_totalName;

  /**
   * Returns default value for parameter <code>p_totalName</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_totalName_DefaultValue_xjal() {
    final ChartEnergyCosts self = this;
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


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_totalName = _p_totalName_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_totalName":
      if ( _callOnChange_xjal ) {
        set_p_totalName( (String) _value_xjal );
      } else {
        p_totalName = (String) _value_xjal;
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
    case "p_totalName": _result_xjal = p_totalName; break;
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
      list.add( "p_totalName" );
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
Color 
 v_netECCostColor;
  public 
double 
 v_netECCostLineWidth;
  public 
String 
 v_selectedEnergyCarrier;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartEnergyCosts.class );

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
  public EventTimeout _bar_importEnergyCostsMonthly_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _bar_exportEnergyRevenueMonthly_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _bar_importEnergyCostsMonthly_autoUpdateEvent_xjal ) return "bar_importEnergyCostsMonthly auto update event";
     if( _e == _bar_exportEnergyRevenueMonthly_autoUpdateEvent_xjal ) return "bar_exportEnergyRevenueMonthly auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _bar_importEnergyCostsMonthly_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _bar_exportEnergyRevenueMonthly_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _bar_importEnergyCostsMonthly_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _bar_exportEnergyRevenueMonthly_autoUpdateEvent_xjal ) {
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
    if( _e == _bar_importEnergyCostsMonthly_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _bar_exportEnergyRevenueMonthly_autoUpdateEvent_xjal) {
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
    if ( _e == _bar_importEnergyCostsMonthly_autoUpdateEvent_xjal ) {
      bar_importEnergyCostsMonthly.updateData();
      return;
    }
    if ( _e == _bar_exportEnergyRevenueMonthly_autoUpdateEvent_xjal ) {
      bar_exportEnergyRevenueMonthly.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = digital_twin_results.ChartArea._STATECHART_COUNT_xjal + 0;


  // Functions

  public void f_setChartEnergyCosts(  ) { 

//Initialization of data object.
I_EnergyData data = uI_Results.f_getSelectedObjectData();

if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE){
	List<OL_ResultScope> supportedResultScopes = new ArrayList<>(List.of(OL_ResultScope.GRIDCONNECTION, OL_ResultScope.ENERGYMODEL, OL_ResultScope.ENERGYCOOP));
	uI_Results.f_activateChartBlocker(supportedResultScopes);
	return;
}

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 60, true);

//Initialize the EnergyCarrier selection ComboBox
f_initializeECSelectionComboBox(data);

//Set the actual values of the chart (while trying to maintain the previous selected EC)
String currentSelectedECReadableName = v_selectedEnergyCarrier.equals(p_totalName) ? p_totalName : uI_Results.f_getECName(OL_EnergyCarriers.valueOf(v_selectedEnergyCarrier));
if (Arrays.asList(cb_energyCarrierSelection.getItems()).contains(currentSelectedECReadableName)) {
	cb_energyCarrierSelection.setValue(currentSelectedECReadableName, true);
}
else{
	cb_energyCarrierSelection.setValue(uI_Results.f_getECName(OL_EnergyCarriers.ELECTRICITY), true);
} 
  }

  void f_setYearlyKPIs( double totalImportCosts_eur, double totalExportRevenue_eur, double totalNetElectricityCosts_eur, Double previousTotalImportCosts_eur, Double previousTotalExportRevenue_eur, Double previousTotalNetElectricityCosts_eur ) { 

//Set new values text
DecimalFormat df = new DecimalFormat("#,##0");

t_totalImportCosts_eur.setText("€ " + df.format(roundToInt(totalImportCosts_eur)));
t_totalExportRevenue_eur.setText("€ " + df.format(roundToInt(totalExportRevenue_eur)));
t_totalNetEnergyCosts_eur.setText("€ " + df.format(roundToInt(totalNetElectricityCosts_eur)));

if(previousTotalImportCosts_eur != null){
	t_previousTotalImportCosts_eur.setText("€ " + df.format(roundToInt(previousTotalImportCosts_eur)));
	t_previousTotalExportRevenue_eur.setText("€ " + df.format(roundToInt(previousTotalExportRevenue_eur)));
	t_previousTotalNetEnergyCosts_eur.setText("€ " + df.format(roundToInt(previousTotalNetElectricityCosts_eur)));
	
	////Set arrows
	//Import
	if(previousTotalImportCosts_eur > totalImportCosts_eur){
		arrow_down_green_import.setVisible(true);
	}
	else if(totalImportCosts_eur > previousTotalImportCosts_eur){
		arrow_up_red_import.setVisible(true);
	}
	else{
		line_import.setVisible(true);
	}
	
	//Export
	if(previousTotalExportRevenue_eur > totalExportRevenue_eur){
		arrow_down_red_export.setVisible(true);
	}
	else if(totalExportRevenue_eur > previousTotalExportRevenue_eur){
		arrow_up_green_export.setVisible(true);
	}
	else{
		line_export.setVisible(true);
	}
	
	//Net
	if(previousTotalNetElectricityCosts_eur > totalNetElectricityCosts_eur){
		arrow_down_green_netEnergy.setVisible(true);
	}
	else if(totalNetElectricityCosts_eur > previousTotalNetElectricityCosts_eur){
		arrow_up_red_netEnergy.setVisible(true);
	}
	else{
		line_total.setVisible(true);
	}
}
else{ // No previous rapid data -> dont show previous values
	t_previousTotalImportCosts_eur.setText("");
	t_previousTotalExportRevenue_eur.setText("");
	t_previousTotalNetEnergyCosts_eur.setText("");
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
arrow_down_green_import.setVisible(false);
arrow_up_green_export.setVisible(false);
arrow_down_green_netEnergy.setVisible(false);
arrow_up_red_import.setVisible(false);
arrow_down_red_export.setVisible(false);
arrow_up_red_netEnergy.setVisible(false);
line_total.setVisible(false);
line_import.setVisible(false);
line_export.setVisible(false);

//Clear monthly chart
bar_importEnergyCostsMonthly.removeAll();
bar_exportEnergyRevenueMonthly.removeAll();
plot_netEnergyCostsMonthly.removeAll();
gr_monthlyECCostCharts.setVisible(false); 
  }

  void f_setMonthlyChart( double[] monthlyElectricityImportCosts_eur, double[] monthlyElectricityExportRevenue_eur, double[] monthlyNetElectricityCosts_eur ) { 

DataSet netCosts_eur = new DataSet(12);
int nDecimalDigits = 2;
double maxChartValue_eur = 0;

for (int i = 0; i < 12; i++) {
	//Import cost
	DataItem importCosts_eur = new DataItem();
	importCosts_eur.setValue(roundToDecimal(monthlyElectricityImportCosts_eur[i], nDecimalDigits));
	bar_importEnergyCostsMonthly.addDataItem(importCosts_eur, "", uI_Results.v_electricityDemandColor);

	//Export revenue
	DataItem exportRevenue_eur = new DataItem();
	exportRevenue_eur.setValue(roundToDecimal(monthlyElectricityExportRevenue_eur[i], nDecimalDigits));
	bar_exportEnergyRevenueMonthly.addDataItem(exportRevenue_eur, "", uI_Results.v_electricitySupplyColor);
	
	//Net balance
	netCosts_eur.add(i+1, roundToDecimal(monthlyNetElectricityCosts_eur[i], nDecimalDigits));
	
	//Determine max value of the bars 
	maxChartValue_eur = max(maxChartValue_eur, max(monthlyElectricityImportCosts_eur[i], monthlyElectricityExportRevenue_eur[i]));
}

//Net costs
plot_netEnergyCostsMonthly.addDataSet(netCosts_eur, "", v_netECCostColor, true, Chart.InterpolationType.INTERPOLATION_LINEAR, v_netECCostLineWidth, Chart.PointStyle.POINT_CIRCLE);

//Set fixed scale
maxChartValue_eur *=1.2;
maxChartValue_eur +=1; //To prevent [0 0] axis errors if EC is not active.
bar_importEnergyCostsMonthly.setFixedScale(0, maxChartValue_eur);
bar_exportEnergyRevenueMonthly.setFixedScale(0, maxChartValue_eur);
plot_netEnergyCostsMonthly.setFixedVerticalScale(-maxChartValue_eur, maxChartValue_eur);
plot_netEnergyCostsMonthly.setFixedHorizontalScale(0.5, 12.5);

gr_monthlyECCostCharts.setVisible(true);
 
  }

  
double[] 
 f_calculateMonthlyEnergyImportCosts_eur( double[] ECBalance_kW, double signalResolution_h, OL_EnergyCarriers EC ) { 

double[] startHourPerMonth = uI_Results.energyModel.p_timeParameters.getMonthStartHours();
double timeStep_h = uI_Results.energyModel.p_timeParameters.getTimeStep_h();

double energyCarrierCost_eur_p_kWh = uI_Results.energyModel.avgc_data.economicAVGC.getAvgCostOfEnergyCarrier_eurpkWh(EC);
double[] values_dayAheadElectricityPricing_eurpMWh = uI_Results.energyModel.pp_dayAheadElectricityPricing_eurpMWh.getAllValues();
double energyTaxes_eur_p_kwh = uI_Results.energyModel.avgc_data.economicAVGC.getEnergyTaxesECImport_eurpkWh(EC, ZeroMath.arraySumPos(ECBalance_kW)*signalResolution_h);
double VAT_fr = uI_Results.energyModel.avgc_data.economicAVGC.getVAT_energy_fr();


double[] monthlyECImportCosts_euro = new double[12];

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
		energyCarrierCost_eur_p_kWh = uI_Results.energyModel.pp_dayAheadElectricityPricing_eurpMWh.getValue((i*signalResolution_h + modelStartTime_h) % hoursInYear)/1000.0;
	}
	
    monthlyECImportCosts_euro[currentMonth] += (1 + VAT_fr)*((energyCarrierCost_eur_p_kWh + energyTaxes_eur_p_kwh) * currentECImport_kW * signalResolution_h);
}

return monthlyECImportCosts_euro;
 
  }

  
double[] 
 f_calculateMonthlyEnergyExportRevenue_eur( double[] ECBalance_kW, double signalResolution_h, OL_EnergyCarriers EC ) { 

double[] startHourPerMonth = uI_Results.energyModel.p_timeParameters.getMonthStartHours();
double timeStep_h = uI_Results.energyModel.p_timeParameters.getTimeStep_h();

double energyCarrierCost_eur_p_kWh = uI_Results.energyModel.avgc_data.economicAVGC.getAvgCostOfEnergyCarrier_eurpkWh(EC);
double[] values_dayAheadElectricityPricing_eurpMWh = uI_Results.energyModel.pp_dayAheadElectricityPricing_eurpMWh.getAllValues();

double[] monthlyECExportRevenue_euro = new double[12];


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
	
	double currentECExport_kW = max(0, -ECBalance_kW[i]);
	if(currentECExport_kW == 0){
		continue;
	}

	if(EC == OL_EnergyCarriers.ELECTRICITY){
		energyCarrierCost_eur_p_kWh = uI_Results.energyModel.pp_dayAheadElectricityPricing_eurpMWh.getValue((i*signalResolution_h + modelStartTime_h) % hoursInYear)/1000.0;
	}

    monthlyECExportRevenue_euro[currentMonth] += energyCarrierCost_eur_p_kWh * currentECExport_kW * signalResolution_h;
}

return monthlyECExportRevenue_euro;
 
  }

  
double[] 
 f_calculateMonthlyNetEnergyCosts_eur( double[] monthlyECImportCosts_euro, double[] monthlyECExportRevenue_euro ) { 

if(monthlyECImportCosts_euro.length != monthlyECExportRevenue_euro.length){
	throw new RuntimeException("Trying to calculate the net energy cost per month for a monthly import and export array that is not the same size!");
}

double[] monthlyNetEnergyCost_euro = new double[monthlyECImportCosts_euro.length];

for (int i = 0; i < monthlyECImportCosts_euro.length; i++) {
    monthlyNetEnergyCost_euro[i] = monthlyECImportCosts_euro[i] - monthlyECExportRevenue_euro[i];
}

return monthlyNetEnergyCost_euro;
 
  }

  void f_setChartEnergyCostsValues(  ) { 

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
		selectedECList = new ArrayList<>(data.getRapidRunData().activeEnergyCarriers);
	}
}
else{
	selectedECList = new ArrayList<>(List.of(OL_EnergyCarriers.valueOf(v_selectedEnergyCarrier)));
}


double[] monthlyImportCosts_eur = new double[12];
double[] monthlyExportRevenue_eur = new double[12];

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
	double[] monthlyECImportCosts_eur = f_calculateMonthlyEnergyImportCosts_eur(ECBalance_kW, signalResolution_h, EC);
	double[] monthlyECExportRevenue_eur = f_calculateMonthlyEnergyExportRevenue_eur(ECBalance_kW, signalResolution_h, EC);
	
	//Add values of this EC to the total
	for(int i = 0; i < 12; i++){
		monthlyImportCosts_eur[i] += monthlyECImportCosts_eur[i];
		monthlyExportRevenue_eur[i] += monthlyECExportRevenue_eur[i];
	}	
}

double[] monthlyNetCosts_eur = f_calculateMonthlyNetEnergyCosts_eur(monthlyImportCosts_eur, monthlyExportRevenue_eur);
	
double totalImportCosts_eur = ZeroMath.arraySum(monthlyImportCosts_eur);
double totalExportRevenue_eur = ZeroMath.arraySum(monthlyExportRevenue_eur);
double totalNetCosts_eur = ZeroMath.arraySum(monthlyNetCosts_eur);


//Previous values
Double previousTotalImportCosts_eur = null;
Double previousTotalExportRevenue_eur = null;
Double previousTotalNetCosts_eur = null;

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
	previousTotalImportCosts_eur = 0.0;
	previousTotalExportRevenue_eur = 0.0;
	previousTotalNetCosts_eur = 0.0;		

	for(OL_EnergyCarriers EC : selectedECList_previousRapidRun){
		if(EC == OL_EnergyCarriers.HEAT && !data.getPreviousRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW)){
			continue;
		}
		
		double[] previousECBalance_kW = data.getPreviousRapidRunData().am_totalBalanceAccumulators_kW.get(EC).getTimeSeries_kW();
		double previousSignalResolution_h = data.getPreviousRapidRunData().am_totalBalanceAccumulators_kW.get(EC).getSignalResolution_h();
		
		double[] previousMonthlyECImportCosts_eur = f_calculateMonthlyEnergyImportCosts_eur(previousECBalance_kW, previousSignalResolution_h, EC);
		double[] previousMonthlyECExportRevenue_eur = f_calculateMonthlyEnergyExportRevenue_eur(previousECBalance_kW, previousSignalResolution_h, EC);
		double[] previousMonthlyNetECCosts_eur = f_calculateMonthlyNetEnergyCosts_eur(previousMonthlyECImportCosts_eur, previousMonthlyECExportRevenue_eur);
		
	
		previousTotalImportCosts_eur += ZeroMath.arraySum(previousMonthlyECImportCosts_eur);
		previousTotalExportRevenue_eur += ZeroMath.arraySum(previousMonthlyECExportRevenue_eur);
		previousTotalNetCosts_eur += ZeroMath.arraySum(previousMonthlyNetECCosts_eur);
	}
}


//Set yearly kpis
f_setYearlyKPIs(totalImportCosts_eur, totalExportRevenue_eur, totalNetCosts_eur, previousTotalImportCosts_eur, previousTotalExportRevenue_eur, previousTotalNetCosts_eur);

//Set monthly chart
if(uI_Results.energyModel.p_timeParameters.getRunDuration_h() >= 8760){
	f_setMonthlyChart(monthlyImportCosts_eur, monthlyExportRevenue_eur, monthlyNetCosts_eur);
}
 
  }

  
double 
 f_getTotalEnergyCosts_eurpyr( J_RapidRunData rapidRunData ) { 

double[] monthlyImportCosts_eur = new double[12];
double[] monthlyExportRevenue_eur = new double[12];

for(OL_EnergyCarriers EC : rapidRunData.activeEnergyCarriers){
	if(EC == OL_EnergyCarriers.HEAT && !rapidRunData.assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW)){
		continue;
	}
	//Get the ECBalance values
	double[] ECBalance_kW;
	double signalResolution_h;
	ECBalance_kW = rapidRunData.am_totalBalanceAccumulators_kW.get(EC).getTimeSeries_kW();
	signalResolution_h = rapidRunData.am_totalBalanceAccumulators_kW.get(EC).getSignalResolution_h();
	
	//Current values
	double[] monthlyECImportCosts_eur = f_calculateMonthlyEnergyImportCosts_eur(ECBalance_kW, signalResolution_h, EC);
	double[] monthlyECExportRevenue_eur = f_calculateMonthlyEnergyExportRevenue_eur(ECBalance_kW, signalResolution_h, EC);

	//Add values of this EC to the total
	for(int i = 0; i < 12; i++){
		monthlyImportCosts_eur[i] += monthlyECImportCosts_eur[i];
		monthlyExportRevenue_eur[i] += monthlyECExportRevenue_eur[i];
	}
}

double[] monthlyNetCosts_eur = f_calculateMonthlyNetEnergyCosts_eur(monthlyImportCosts_eur, monthlyExportRevenue_eur);

double totalNetCosts_eur = ZeroMath.arraySum(monthlyNetCosts_eur);

return totalNetCosts_eur; 
  }

  void f_initializeECSelectionComboBox( I_EnergyData data ) { 

//Get energy carrier options (also previous run EC that are not in current).
Set<OL_EnergyCarriers> energyCarriers = new HashSet<>();
if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE){
	energyCarriers.add(uI_Results.v_gridNode.p_energyCarrier);
}
else{
	energyCarriers.addAll(data.getRapidRunData().activeEnergyCarriers);
	boolean hasHadDistrictHeating = data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW);
	
	if(data.getPreviousRapidRunData() != null){
		energyCarriers.addAll(data.getPreviousRapidRunData().activeEnergyCarriers);
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
for(OL_EnergyCarriers EC : uI_Results.c_defaultOrderEC){
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
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_energyCarrierSelection_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_EnergyCosts_Font = new Font("SansSerif", 1, 26 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_netEnergyCosts_Font = new Font("SansSerif", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalExportCosts_Font = _txt_netEnergyCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalImportCosts_Font = _txt_netEnergyCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalImportCosts_eur_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalImportCosts_eur_Font = new Font("SansSerif", 2, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalExportRevenue_eur_Font = _t_totalImportCosts_eur_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalExportRevenue_eur_Font = _t_previousTotalImportCosts_eur_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalNetEnergyCosts_eur_Font = _t_totalImportCosts_eur_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalNetEnergyCosts_eur_Font = _t_previousTotalImportCosts_eur_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_yearlyEnergyCosts_Font = new Font("SansSerif", 0, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_monthlyEnergyCosts_Font = _txt_yearlyEnergyCosts_Font;
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
  protected static final Font _txt_barChartLegendImport_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_barChartLegendExport_Font = _txt_barChartLegendImport_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_barChartLegendNet_Font = _txt_barChartLegendImport_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_monthlyChartYAxis_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_selectedEnergyCarrier_Font = _t_totalImportCosts_eur_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_headerKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_EnergyCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_netEnergyCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalExportCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalImportCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_red_import = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_green_import = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_import = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_diffTotalImportCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_green_export = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_red_export = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_export = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_diffTotalExportRevenue = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalImportCosts_eur = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalImportCosts_eur = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalExportRevenue_eur = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalExportRevenue_eur = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalNetEnergyCosts_eur = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalNetEnergyCosts_eur = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_red_netEnergy = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_green_netEnergy = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_total = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_diffTotalNetEnergyCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_yearlyEnergyCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_totalEnergyCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_monthlyEnergyCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_jan = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_feb = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_mar = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_apr = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_mei = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_jun = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_jul = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_aug = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_sep = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_okt = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_nov = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_dec = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_monthlyChartXaxis = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_barChartLegendImport = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_barChartLegendExport = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_barChartLegendNet = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_monthlyCostsLegend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_monthlyChartYAxis = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_monthlyECCostCharts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_chartEnergyCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_selectedEnergyCarrier = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _bar_importEnergyCostsMonthly = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _bar_exportEnergyRevenueMonthly = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_netEnergyCostsMonthly = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_energyCarrierSelection = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 55;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 56;

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
	  level.addAll(rect_headerKPI, txt_EnergyCosts, gr_totalEnergyCosts, gr_monthlyECCostCharts, i_chartEnergyCosts, cb_energyCarrierSelection, txt_selectedEnergyCarrier);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_chartEnergyCosts:
        if (true) {
          ShapeImage self = this.i_chartEnergyCosts;
          
uI_Results.f_setInfoText(i_chartEnergyCosts, uI_Results.v_infoText.economicKPIs, i_chartEnergyCosts.getX(), i_chartEnergyCosts.getY()); 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
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
	for(OL_EnergyCarriers EC : uI_Results.c_defaultOrderEC){
		if(cb_energyCarrierSelection.getValue().equals(uI_Results.f_getECName(EC))){
			v_selectedEnergyCarrier = EC.toString();
		}
	}
}

f_setChartEnergyCostsValues();
 
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
  private double _bar_importEnergyCostsMonthly_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem4Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem5Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem6Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem7Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem8Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem9Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem10Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_importEnergyCostsMonthly_DataItem11Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem4Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem5Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem6Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem7Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem8Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem9Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem10Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _bar_exportEnergyRevenueMonthly_DataItem11Value() {
    return 
0 
;
  }
  protected ShapeComboBox cb_energyCarrierSelection;
  protected BarChart bar_importEnergyCostsMonthly;
  protected BarChart bar_exportEnergyRevenueMonthly;
  protected Plot plot_netEnergyCostsMonthly;
  
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
  protected ShapeText txt_EnergyCosts;
  protected ShapeText txt_netEnergyCosts;
  protected ShapeText txt_totalExportCosts;
  protected ShapeText txt_totalImportCosts;
  protected ShapeImage arrow_up_red_import;
  protected ShapeImage arrow_down_green_import;
  protected ShapeLine line_import;
  protected ShapeGroup arrows_diffTotalImportCosts;
  protected ShapeImage arrow_up_green_export;
  protected ShapeImage arrow_down_red_export;
  protected ShapeLine line_export;
  protected ShapeGroup arrows_diffTotalExportRevenue;
  protected ShapeText t_totalImportCosts_eur;
  protected ShapeText t_previousTotalImportCosts_eur;
  protected ShapeText t_totalExportRevenue_eur;
  protected ShapeText t_previousTotalExportRevenue_eur;
  protected ShapeText t_totalNetEnergyCosts_eur;
  protected ShapeText t_previousTotalNetEnergyCosts_eur;
  protected ShapeImage arrow_up_red_netEnergy;
  protected ShapeImage arrow_down_green_netEnergy;
  protected ShapeLine line_total;
  protected ShapeGroup arrows_diffTotalNetEnergyCosts;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_yearlyEnergyCosts_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Jaarlijkse kosten " + cb_energyCarrierSelection.getValue() 
);
  }
  
  protected ShapeText txt_yearlyEnergyCosts;
  protected ShapeLine line1;
  protected ShapeGroup gr_totalEnergyCosts;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_monthlyEnergyCosts_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Maandelijkse kosten " + cb_energyCarrierSelection.getValue() 
);
  }
  
  protected ShapeText txt_monthlyEnergyCosts;
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
  private void _rectangle_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
uI_Results.v_electricitySupplyColor 
);
  }
  
  protected ShapeRectangle rectangle;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle1_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
uI_Results.v_electricityDemandColor 
);
  }
  
  protected ShapeRectangle rectangle1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line_SetDynamicParams_xjal( ShapeLine shape ) {
    shape.setColor(
v_netECCostColor 
);
    shape.setLineWidth(
v_netECCostLineWidth 
);
  }
  
  protected ShapeLine line;
  protected ShapeText txt_barChartLegendImport;
  protected ShapeText txt_barChartLegendExport;
  protected ShapeText txt_barChartLegendNet;
  protected ShapeGroup gr_monthlyCostsLegend;
  protected ShapeText txt_monthlyChartYAxis;
  protected ShapeGroup gr_monthlyECCostCharts;
  protected ShapeImage i_chartEnergyCosts;
  protected ShapeText txt_selectedEnergyCarrier;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    cb_energyCarrierSelection = new ShapeComboBox(
ChartEnergyCosts.this, true, 290.0, 110.0,
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
    txt_EnergyCosts = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 10.0, 0.0, 0.0,
        black,"Energiekosten",
        _txt_EnergyCosts_Font, ALIGNMENT_CENTER );
    txt_netEnergyCosts = new ShapeText(
        SHAPE_DRAW_2D, true,-180.0, 60.0, 0.0, 0.0,
        black,"Nettokosten:",
        _txt_netEnergyCosts_Font, ALIGNMENT_LEFT );
    txt_totalExportCosts = new ShapeText(
        SHAPE_DRAW_2D, true,-180.0, -10.0, 0.0, 0.0,
        black,"Exportopbrengsten:",
        _txt_totalExportCosts_Font, ALIGNMENT_LEFT );
    txt_totalImportCosts = new ShapeText(
        SHAPE_DRAW_2D, true,-180.0, -50.0, 0.0, 0.0,
        black,"Importkosten:",
        _txt_totalImportCosts_Font, ALIGNMENT_LEFT );
    arrow_up_red_import = new ShapeImage(
		ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_red.png",} );
    arrow_up_red_import.setVisible( false );
    arrow_down_green_import = new ShapeImage(
		ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_green.png",} );
    arrow_down_green_import.setVisible( false );
    line_import = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_import.setVisible( false );
    arrow_up_green_export = new ShapeImage(
		ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_green.png",} );
    arrow_up_green_export.setVisible( false );
    arrow_down_red_export = new ShapeImage(
		ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_red.png",} );
    arrow_down_red_export.setVisible( false );
    line_export = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_export.setVisible( false );
    t_totalImportCosts_eur = new ShapeText(
        SHAPE_DRAW_2D, true,160.0, -50.0, 0.0, 0.0,
        black,"€ 1.000.000",
        _t_totalImportCosts_eur_Font, ALIGNMENT_RIGHT );
    t_previousTotalImportCosts_eur = new ShapeText(
        SHAPE_DRAW_2D, true,160.0, -28.0, 0.0, 0.0,
        black,"-",
        _t_previousTotalImportCosts_eur_Font, ALIGNMENT_RIGHT );
    t_totalExportRevenue_eur = new ShapeText(
        SHAPE_DRAW_2D, true,160.0, -10.0, 0.0, 0.0,
        black,"€ 1.000.000",
        _t_totalExportRevenue_eur_Font, ALIGNMENT_RIGHT );
    t_previousTotalExportRevenue_eur = new ShapeText(
        SHAPE_DRAW_2D, true,160.0, 12.0, 0.0, 0.0,
        black,"-",
        _t_previousTotalExportRevenue_eur_Font, ALIGNMENT_RIGHT );
    t_totalNetEnergyCosts_eur = new ShapeText(
        SHAPE_DRAW_2D, true,160.0, 60.0, 0.0, 0.0,
        black,"€ 1.000.000",
        _t_totalNetEnergyCosts_eur_Font, ALIGNMENT_RIGHT );
    t_previousTotalNetEnergyCosts_eur = new ShapeText(
        SHAPE_DRAW_2D, true,160.0, 82.0, 0.0, 0.0,
        black,"-",
        _t_previousTotalNetEnergyCosts_eur_Font, ALIGNMENT_RIGHT );
    arrow_up_red_netEnergy = new ShapeImage(
		ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_red.png",} );
    arrow_up_red_netEnergy.setVisible( false );
    arrow_down_green_netEnergy = new ShapeImage(
		ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_green.png",} );
    arrow_down_green_netEnergy.setVisible( false );
    line_total = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_total.setVisible( false );
    txt_yearlyEnergyCosts = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -100.0, 0.0, 0.0,
        black,"Jaarlijkse kosten Elektriciteit",
        _txt_yearlyEnergyCosts_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_yearlyEnergyCosts_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    line1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -200.0, 40.0, 0.0, silver,
 		390.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    txt_monthlyEnergyCosts = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, -150.0, 0.0, 0.0,
        black,"Maandelijkse kosten elektriciteit",
        _txt_monthlyEnergyCosts_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_monthlyEnergyCosts_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
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
    rectangle = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-100.0, -10.0, 0.0, 0.0,
            black, yellowGreen,
			10.0, 10.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rectangle1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-100.0, -30.0, 0.0, 0.0,
            black, red,
			10.0, 10.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -100.0, 15.0, 0.0, black,
 		10.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _line_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_barChartLegendImport = new ShapeText(
        SHAPE_DRAW_2D, true,-80.0, -30.0, 0.0, 0.0,
        black,"Importkosten per maand [€]",
        _txt_barChartLegendImport_Font, ALIGNMENT_LEFT );
    txt_barChartLegendExport = new ShapeText(
        SHAPE_DRAW_2D, true,-80.0, -10.0, 0.0, 0.0,
        black,"Exportopbrengsten per maand [€]",
        _txt_barChartLegendExport_Font, ALIGNMENT_LEFT );
    txt_barChartLegendNet = new ShapeText(
        SHAPE_DRAW_2D, true,-80.0, 10.0, 0.0, 0.0,
        black,"Nettokosten per maand [€]",
        _txt_barChartLegendNet_Font, ALIGNMENT_LEFT );
    txt_monthlyChartYAxis = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, 0.0, 0.0, 0.0,
        black,"[€]",
        _txt_monthlyChartYAxis_Font, ALIGNMENT_LEFT );
    i_chartEnergyCosts = new ShapeImage(
		ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, 350.0, 10.0, 0.0, 0.0,
30.0, 30.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_chartEnergyCosts, 0, clickx, clicky );
      }
    };
    txt_selectedEnergyCarrier = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 110.0, 0.0, 0.0,
        black,"Geselecteerde energiedrager:",
        _txt_selectedEnergyCarrier_Font, ALIGNMENT_LEFT );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataItem> _items = new ArrayList<>( 12 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem3Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem4Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem5Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem6Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem7Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem8Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem9Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem10Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_importEnergyCostsMonthly_DataItem11Value() );
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
    bar_importEnergyCostsMonthly = new BarChart(
ChartEnergyCosts.this, true, -220.0, -140.0,
			440.0, 180.0,
            null, null,
            50.0, 30.0,
			370.0, 120.0, white, black, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0, 0.75,
            Chart.GRID_NONE,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 12 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem3Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem4Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem5Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem6Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem7Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem8Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem9Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem10Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _bar_exportEnergyRevenueMonthly_DataItem11Value() );
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
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    _colors.add( yellowGreen );
    bar_exportEnergyRevenueMonthly = new BarChart(
ChartEnergyCosts.this, true, -220.0, -20.0,
			440.0, 180.0,
            null, null,
            50.0, 30.0,
			370.0, 120.0, white, black, black,
            30.0, Chart.NONE,
            Chart.SOUTH, Chart.SCALE_AUTO,
0, 0, 0.75,
            Chart.GRID_NONE,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_netEnergyCostsMonthly = new Plot(
ChartEnergyCosts.this, true, -220.0, -140.0,
			460.0, 300.0,
            null, null,
            50.0, 30.0,
			370.0, 240.0, null, darkGray, black,
            30.0, Chart.NONE,
            Chart.SCALE_FIXED,

0.5 
            , 
12.5 
, Chart.SCALE_AUTO,
0, 0, Chart.GRID_NONE, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    arrows_diffTotalImportCosts = new ShapeGroup( ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, 182.0, -21.0, 0.0, 0.0
	
	     , arrow_up_red_import
	     , arrow_down_green_import
	     , line_import );
    }
    {
    arrows_diffTotalExportRevenue = new ShapeGroup( ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, 182.0, 19.0, 0.0, 0.0
	
	     , arrow_up_green_export
	     , arrow_down_red_export
	     , line_export );
    }
    {
    arrows_diffTotalNetEnergyCosts = new ShapeGroup( ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, 182.0, 89.0, 0.0, 0.0
	
	     , arrow_up_red_netEnergy
	     , arrow_down_green_netEnergy
	     , line_total );
    }
    {
    gr_totalEnergyCosts = new ShapeGroup( ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, 235.0, 250.0, 0.0, 0.0
	
	     , txt_netEnergyCosts
	     , txt_totalExportCosts
	     , txt_totalImportCosts
	     , arrows_diffTotalImportCosts
	     , arrows_diffTotalExportRevenue
	     , t_totalImportCosts_eur
	     , t_previousTotalImportCosts_eur
	     , t_totalExportRevenue_eur
	     , t_previousTotalExportRevenue_eur
	     , t_totalNetEnergyCosts_eur
	     , t_previousTotalNetEnergyCosts_eur
	     , arrows_diffTotalNetEnergyCosts
	     , txt_yearlyEnergyCosts
	     , line1 );
    }
    {
    gr_monthlyChartXaxis = new ShapeGroup( ChartEnergyCosts.this, SHAPE_DRAW_2D, true, 15.0, 140.0, 0.0, 0.0
	
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
    gr_monthlyCostsLegend = new ShapeGroup( ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, -70.0, 195.0, 0.0, 0.0
	
	     , rectangle
	     , rectangle1
	     , line
	     , txt_barChartLegendImport
	     , txt_barChartLegendExport
	     , txt_barChartLegendNet );
    }
    {
    gr_monthlyECCostCharts = new ShapeGroup( ChartEnergyCosts.this, SHAPE_DRAW_2D3D, true, 225.0, 520.0, 0.0, 0.0
	
	     , txt_monthlyEnergyCosts
	     , bar_importEnergyCostsMonthly
	     , bar_exportEnergyRevenueMonthly
	     , plot_netEnergyCostsMonthly
	     , gr_monthlyChartXaxis
	     , gr_monthlyCostsLegend
	     , txt_monthlyChartYAxis );
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
  public ChartEnergyCosts( Engine engine, Agent owner, AgentList<? extends ChartEnergyCosts> ownerPopulation ) {
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
  public ChartEnergyCosts() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public ChartEnergyCosts( String p_totalName ) {
    markParametersAreSet();
    this.p_totalName = p_totalName;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartEnergyCosts_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartEnergyCosts.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartEnergyCosts.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _bar_importEnergyCostsMonthly_autoUpdateEvent_xjal.start();
    _bar_exportEnergyRevenueMonthly_autoUpdateEvent_xjal.start();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartEnergyCosts_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartEnergyCosts_xjal() {
    v_backgroundColor_override = 
white 
;
    v_netECCostColor = 
black 
;
    v_netECCostLineWidth = 
2 
;
    v_selectedEnergyCarrier = 
"ELECTRICITY" 
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

  public AgentList<? extends ChartEnergyCosts> getPopulation() {
    return (AgentList<? extends ChartEnergyCosts>) super.getPopulation();
  }

  public List<? extends ChartEnergyCosts> agentsInRange( double distance ) {
    return (List<? extends ChartEnergyCosts>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _bar_importEnergyCostsMonthly_autoUpdateEvent_xjal ) return false;
    if ( _e == _bar_exportEnergyRevenueMonthly_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _bar_importEnergyCostsMonthly_autoUpdateEvent_xjal.onDestroy();
    _bar_exportEnergyRevenueMonthly_autoUpdateEvent_xjal.onDestroy();
  	for (int _pIdx = 0; _pIdx < plot_netEnergyCostsMonthly.getCount(); _pIdx++) {
  		DataSet _ds = plot_netEnergyCostsMonthly.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_netEnergyCostsMonthly.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_netEnergyCostsMonthly : " + _t );
  	}
    super.onDestroy();
  }

  // Additional class code

@Override
public void f_styleBackground(Color backgroundColor, Color lineColor, Double lineWidth, LineStyle lineStyle) {
    f_styleBackground_override(backgroundColor, lineColor, lineWidth, lineStyle);
} 
  // End of additional class code

}
