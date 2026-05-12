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

public class ChartConnectionCosts extends digital_twin_results.ChartArea
{
  // Parameters
  // Plain Variables

  public 
Color 
 color_physicalConnectionCosts;
  public 
Color 
 color_contractConnectionCosts;
  public 
Color 
 color_transportConnectionCosts;
  public 
Color 
 color_monthlyPeakConnectionCosts;

  // Collection Variables
  public 
ArrayList <
StackChart > c_orderedStackCharts = new ArrayList<StackChart>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartConnectionCosts.class );

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
  public EventTimeout _chart_layout_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_jan_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_apr_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_jul_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_sep_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_dec_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_nov_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_aug_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_jun_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_may_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_mar_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_feb_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_monthlyConnectionCosts_okt_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _chart_layout_autoUpdateEvent_xjal ) return "chart_layout auto update event";
     if( _e == _chart_monthlyConnectionCosts_jan_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_jan auto update event";
     if( _e == _chart_monthlyConnectionCosts_apr_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_apr auto update event";
     if( _e == _chart_monthlyConnectionCosts_jul_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_jul auto update event";
     if( _e == _chart_monthlyConnectionCosts_sep_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_sep auto update event";
     if( _e == _chart_monthlyConnectionCosts_dec_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_dec auto update event";
     if( _e == _chart_monthlyConnectionCosts_nov_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_nov auto update event";
     if( _e == _chart_monthlyConnectionCosts_aug_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_aug auto update event";
     if( _e == _chart_monthlyConnectionCosts_jun_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_jun auto update event";
     if( _e == _chart_monthlyConnectionCosts_may_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_may auto update event";
     if( _e == _chart_monthlyConnectionCosts_mar_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_mar auto update event";
     if( _e == _chart_monthlyConnectionCosts_feb_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_feb auto update event";
     if( _e == _chart_monthlyConnectionCosts_okt_autoUpdateEvent_xjal ) return "chart_monthlyConnectionCosts_okt auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _chart_layout_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_jan_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_apr_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_jul_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_sep_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_dec_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_nov_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_aug_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_jun_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_may_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_mar_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_feb_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_monthlyConnectionCosts_okt_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _chart_layout_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_jan_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_apr_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_jul_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_sep_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_dec_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_nov_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_aug_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_jun_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_may_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_mar_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_feb_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_monthlyConnectionCosts_okt_autoUpdateEvent_xjal ) {
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
    if( _e == _chart_layout_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_jan_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_apr_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_jul_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_sep_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_dec_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_nov_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_aug_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_jun_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_may_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_mar_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_feb_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_monthlyConnectionCosts_okt_autoUpdateEvent_xjal) {
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
    if ( _e == _chart_layout_autoUpdateEvent_xjal ) {
      chart_layout.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_jan_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_jan.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_apr_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_apr.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_jul_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_jul.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_sep_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_sep.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_dec_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_dec.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_nov_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_nov.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_aug_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_aug.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_jun_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_jun.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_may_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_may.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_mar_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_mar.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_feb_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_feb.updateData();
      return;
    }
    if ( _e == _chart_monthlyConnectionCosts_okt_autoUpdateEvent_xjal ) {
      chart_monthlyConnectionCosts_okt.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = digital_twin_results.ChartArea._STATECHART_COUNT_xjal + 0;


  // Functions

  public void f_setChartConnectionCosts(  ) { 

I_EnergyData data = uI_Results.f_getSelectedObjectData();

if(uI_Results.v_selectedObjectScope != OL_ResultScope.GRIDCONNECTION){
	List<OL_ResultScope> supportedResultScopes = new ArrayList<>(List.of(OL_ResultScope.GRIDCONNECTION));
	uI_Results.f_activateChartBlocker(supportedResultScopes);
	return;
}

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 60, true);

//Reset chart
f_resetChart();


////Get the netload values
double[] netLoad_kW;
double[] previousNetLoad_kW = null;
if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE){
	netLoad_kW = uI_Results.v_gridNode.acc_annualElectricityBalance_kW.getTimeSeries_kW();
}
else{
	netLoad_kW = data.getRapidRunData().am_totalBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getTimeSeries_kW();
	if(data.getPreviousRapidRunData() != null){
		previousNetLoad_kW = data.getPreviousRapidRunData().am_totalBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getTimeSeries_kW();
	}
}

//Set yearly chart
f_setYearlyKPIs(data, netLoad_kW, previousNetLoad_kW);

//Set monthly chart
if(uI_Results.energyModel.p_timeParameters.getRunDuration_h() >= 8760){
	f_setMonthlyChart(data, netLoad_kW);
} 
  }

  void f_resetChart(  ) { 

c_orderedStackCharts.forEach(chart -> chart.removeAll());
gr_monthlyConnectionCostCharts.setVisible(false);

t_previousPhysicalConnectionCosts.setText("-");
t_previousDefaultContractCosts.setText("-");
t_previousEnergyTransportCosts.setText("-");
t_previousPeakConsumptionCosts.setText("-");
t_previousTotalConnectionCosts.setText("-"); 
  }

  
double[] 
 f_calculateMonthlyPeakElectricityDelivery_kW( double[] netLoad_kW ) { 

double[] startHourPerMonth = uI_Results.energyModel.p_timeParameters.getMonthStartHours();
double timeStep_h = uI_Results.energyModel.p_timeParameters.getTimeStep_h();

double[] monthlyPeakElectricityDelivery_kW = new double[12];

int currentMonth = 0;

for (int i = 0; i < netLoad_kW.length; i++) {
	if(currentMonth != 11 && startHourPerMonth[currentMonth+1] < i*timeStep_h){
		currentMonth += 1;
	}
	monthlyPeakElectricityDelivery_kW[currentMonth] = max(monthlyPeakElectricityDelivery_kW[currentMonth], netLoad_kW[i]);
}

return monthlyPeakElectricityDelivery_kW;
 
  }

  
double[] 
 f_calculateMonthlyElectricityDelivery_kWh( double[] netLoad_kW ) { 

double[] startHourPerMonth = uI_Results.energyModel.p_timeParameters.getMonthStartHours();
double timeStep_h = uI_Results.energyModel.p_timeParameters.getTimeStep_h();

double[] monthlyElectricityDelivery_kWh = new double[12];

int currentMonth = 0;

for (int i = 0; i < netLoad_kW.length; i++) {
	if(currentMonth != 11 && startHourPerMonth[currentMonth+1] < i*timeStep_h){
		currentMonth += 1;
	}
	monthlyElectricityDelivery_kWh[currentMonth] += max(0, netLoad_kW[i]) * timeStep_h;
}

return monthlyElectricityDelivery_kWh;
 
  }

  void f_setMonthlyChart( I_EnergyData data, double[] netLoad_kW ) { 

DataSet netCosts_eur = new DataSet(12);

double maxChartValue_eur = 0;
I_GridOperatorTariffs gridOperatorTariffs = uI_Results.energyModel.avgc_data.economicAVGC.getGridOperatorTariffs();

//Get monthly values
double monthlyPhysicalConnectionCosts_eur = f_calculatePhysicalConnectionCosts_eurpyr(data.getRapidRunData().connectionMetaData)/12.0;
double monthlyContractConnectionCosts_eur = f_calculateContractConnectionCosts_eurpyr(data.getRapidRunData().connectionMetaData)/12.0;

double[] monthlyTotalElectricityTransport_kWh = f_calculateMonthlyElectricityDelivery_kWh(netLoad_kW);
double[] monthlyPeakLoad_kW = f_calculateMonthlyPeakElectricityDelivery_kW(netLoad_kW);
double[] monthlyTransportCosts_eur = new double[12];
double[] monthlyPeakCosts_eur = new double[12];
for(int i = 0; i<12 ; i++){
	monthlyTransportCosts_eur[i] = gridOperatorTariffs.getTransportCost_eur(data.getRapidRunData().connectionMetaData, monthlyTotalElectricityTransport_kWh[i]);
	monthlyPeakCosts_eur[i] = gridOperatorTariffs.getMonthlyPeakCost_eur(data.getRapidRunData().connectionMetaData, monthlyPeakLoad_kW[i]);
}

for (int i = 0; i < 12; i++) {
	StackChart chart_monthlyConnectionCosts = c_orderedStackCharts.get(i);
	
	//Physical connection cost
	DataItem physicalConnectionCosts_eur = new DataItem();
	physicalConnectionCosts_eur.setValue(monthlyPhysicalConnectionCosts_eur);
	chart_monthlyConnectionCosts.addDataItem(physicalConnectionCosts_eur, "Fysieke aansluitings kosten", color_physicalConnectionCosts);
	
	//Contract connection cost
	DataItem contractConnectionCosts_eur = new DataItem();
	contractConnectionCosts_eur.setValue(monthlyContractConnectionCosts_eur);
	chart_monthlyConnectionCosts.addDataItem(contractConnectionCosts_eur, "Vaste contract kosten", color_contractConnectionCosts);
		
	//Transport cost
	DataItem transportCosts_eur = new DataItem();
	transportCosts_eur.setValue(monthlyTransportCosts_eur[i]);
	chart_monthlyConnectionCosts.addDataItem(transportCosts_eur, "Transport kosten", color_transportConnectionCosts);
		
	//Peak costs
	DataItem peakCosts_eur = new DataItem();
	peakCosts_eur.setValue(monthlyPeakCosts_eur[i]);
	chart_monthlyConnectionCosts.addDataItem(peakCosts_eur, "Maandelijkse piek kosten", color_monthlyPeakConnectionCosts);
			
	//Determine max value of the bars 
	maxChartValue_eur = max(maxChartValue_eur, 
							monthlyPhysicalConnectionCosts_eur + 
							monthlyContractConnectionCosts_eur +
							monthlyTransportCosts_eur[i] +
							monthlyPeakCosts_eur[i]
							);
}

//Set fixed scale
maxChartValue_eur *=1.2;
for (int i = 0; i < 12; i++) {
	c_orderedStackCharts.get(i).setFixedScale(maxChartValue_eur);
}
chart_layout.setFixedScale(maxChartValue_eur);

gr_monthlyConnectionCostCharts.setVisible(true); 
  }

  void f_setYearlyKPIs( I_EnergyData data, double[] netLoad_kW, double[] previousNetLoad_kW ) { 

//Set new values text
DecimalFormat df = new DecimalFormat("#,##0");

double physicalConnectionCosts_eur = f_calculatePhysicalConnectionCosts_eurpyr(data.getRapidRunData().connectionMetaData);
double contractConnectionCosts_eur = f_calculateContractConnectionCosts_eurpyr(data.getRapidRunData().connectionMetaData);
double totalTransportCosts_eur = f_calculateTotalTransportCosts_eur(data.getRapidRunData().connectionMetaData, netLoad_kW);
double totalPeakCosts_eur = f_calculateTotalPeakCosts_eur(data.getRapidRunData().connectionMetaData, netLoad_kW);
double totalConnectionCosts_eur = physicalConnectionCosts_eur + contractConnectionCosts_eur + 
								  totalTransportCosts_eur + totalPeakCosts_eur; 



t_physicalConnectionCosts.setText("€ " + df.format(roundToInt(physicalConnectionCosts_eur)));
t_defaultContractCosts.setText("€ " + df.format(roundToInt(contractConnectionCosts_eur)));
t_energyTransportCosts.setText("€ " + df.format(roundToInt(totalTransportCosts_eur)));
t_peakConsumptionCosts.setText("€ " + df.format(roundToInt(totalPeakCosts_eur)));
t_totalConnectionCosts.setText("€ " + df.format(roundToInt(totalConnectionCosts_eur)));


if(previousNetLoad_kW != null){

	double previousPhysicalConnectionCosts_eur = f_calculatePhysicalConnectionCosts_eurpyr(data.getPreviousRapidRunData().connectionMetaData);
	double previousContractConnectionCosts_eur = f_calculateContractConnectionCosts_eurpyr(data.getPreviousRapidRunData().connectionMetaData);
	double previousTotalTransportCosts_eur = f_calculateTotalTransportCosts_eur(data.getPreviousRapidRunData().connectionMetaData, previousNetLoad_kW);
	double previousTotalPeakCosts_eur = f_calculateTotalPeakCosts_eur(data.getPreviousRapidRunData().connectionMetaData, previousNetLoad_kW);
	double previousTotalConnectionCosts_eur = previousPhysicalConnectionCosts_eur + previousContractConnectionCosts_eur + 
									  previousTotalTransportCosts_eur + previousTotalPeakCosts_eur; 


	t_previousPhysicalConnectionCosts.setText("€ " + df.format(roundToInt(previousPhysicalConnectionCosts_eur)));
	t_previousDefaultContractCosts.setText("€ " + df.format(roundToInt(previousContractConnectionCosts_eur)));
	t_previousEnergyTransportCosts.setText("€ " + df.format(roundToInt(previousTotalTransportCosts_eur)));
	t_previousPeakConsumptionCosts.setText("€ " + df.format(roundToInt(previousTotalPeakCosts_eur)));
	t_previousTotalConnectionCosts.setText("€ " + df.format(roundToInt(previousTotalConnectionCosts_eur)));
	
	
	/*
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
		arrow_down_green_netElectricity.setVisible(true);
	}
	else if(totalNetElectricityCosts_eur > previousTotalNetElectricityCosts_eur){
		arrow_up_red_netElectricity.setVisible(true);
	}
	else{
		line_total.setVisible(true);
	}
	*/
}
else{ // No previous rapid data -> dont show previous values
	//t_previousTotalImportCosts_eur.setText("-");
	//t_previousTotalExportRevenue_eur.setText("-");
	//t_previousTotalNetElectricityCosts_eur.setText("-");
}
 
  }

  
double 
 f_calculatePhysicalConnectionCosts_eurpyr( J_ConnectionMetaData connectionMetaData ) { 

return uI_Results.energyModel.avgc_data.economicAVGC.getGridOperatorTariffs().getPhysicalCapacityCost_eurpyr(connectionMetaData); 
  }

  
double 
 f_calculateContractConnectionCosts_eurpyr( J_ConnectionMetaData connectionMetaData ) { 

return uI_Results.energyModel.avgc_data.economicAVGC.getGridOperatorTariffs().getContractCapacityCost_eurpyr(connectionMetaData); 
  }

  
double 
 f_calculateTotalTransportCosts_eur( J_ConnectionMetaData connectionMetaData, double[] netLoad_kW ) { 

double yearlyTransportedElectricity_kWh = ZeroMath.arraySum(f_calculateMonthlyElectricityDelivery_kWh(netLoad_kW));
return uI_Results.energyModel.avgc_data.economicAVGC.getGridOperatorTariffs().getTransportCost_eur(connectionMetaData, yearlyTransportedElectricity_kWh); 
  }

  
double 
 f_calculateTotalPeakCosts_eur( J_ConnectionMetaData connectionMetaData, double[] netLoad_kW ) { 

double yearTotalMonthlyPeakLoad_kW = ZeroMath.arraySum(f_calculateMonthlyPeakElectricityDelivery_kW(netLoad_kW));
return uI_Results.energyModel.avgc_data.economicAVGC.getGridOperatorTariffs().getMonthlyPeakCost_eur(connectionMetaData, yearTotalMonthlyPeakLoad_kW); 
  }

  
double 
 f_calculateTotalConnectionCosts_eurpyr( J_ConnectionMetaData connectionMetaData, double[] yearlyNetLoad_kW ) { 

return f_calculatePhysicalConnectionCosts_eurpyr(connectionMetaData)+
	   f_calculateContractConnectionCosts_eurpyr(connectionMetaData)+
	   f_calculateTotalTransportCosts_eur(connectionMetaData, yearlyNetLoad_kW)+
	   f_calculateTotalPeakCosts_eur(connectionMetaData, yearlyNetLoad_kW); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_connectionCosts_Font = new Font("SansSerif", 1, 26 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalConnectionCosts_Font = new Font("SansSerif", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_peakConsumptionCosts_Font = _txt_totalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_energyTransportCosts_Font = _txt_totalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_physicalConnectionCosts_Font = _txt_totalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_defaultContractCosts_Font = _txt_totalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_MonthlyConnectionCosts_Font = new Font("SansSerif", 0, 22 );
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
  protected static final Font _txt_legendPhysicalConnectionCosts_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_legendContractCosts_Font = _txt_legendPhysicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_legendTransportCosts_Font = _txt_legendPhysicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_legendMonthlyPeakCosts_Font = _txt_legendPhysicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_monthlyChartYAxis_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_physicalConnectionCosts_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_defaultContractCosts_Font = _t_physicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyTransportCosts_Font = _t_physicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_peakConsumptionCosts_Font = _t_physicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalConnectionCosts_Font = _t_physicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousPhysicalConnectionCosts_Font = new Font("SansSerif", 2, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousDefaultContractCosts_Font = _t_previousPhysicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousEnergyTransportCosts_Font = _t_previousPhysicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousPeakConsumptionCosts_Font = _t_previousPhysicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalConnectionCosts_Font = _t_previousPhysicalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_headerKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_connectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_chartConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_peakConsumptionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_energyTransportCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_physicalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_defaultContractCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_total = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_MonthlyConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_jan = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_feb = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_mar = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_apr = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_mei = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_jun = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_jul = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_aug = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_sep = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_okt = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_nov = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartXaxis_dec = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_monthlyChartXaxis = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_legendPhysicalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_legendPhysicalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_legendContractCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_legendContractCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_legendTransportCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_legendTransportCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_legendMonthlyPeakCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_legendMonthlyPeakCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_connectionCostsMonthlyLegend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_stackedBarChartMonthlyConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_monthlyChartYAxis = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_monthlyConnectionCostCharts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_physicalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_defaultContractCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyTransportCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_peakConsumptionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousPhysicalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousDefaultContractCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousEnergyTransportCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousPeakConsumptionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_layout = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_jan = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_apr = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_jul = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_sep = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_dec = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_nov = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_aug = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_jun = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_may = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_mar = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_feb = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_monthlyConnectionCosts_okt = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 58;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 59;

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
	  level.addAll(rect_headerKPI, txt_connectionCosts, i_chartConnectionCosts, txt_totalConnectionCosts, txt_peakConsumptionCosts, txt_energyTransportCosts, txt_physicalConnectionCosts, txt_defaultContractCosts, line_total, gr_monthlyConnectionCostCharts, t_physicalConnectionCosts, t_defaultContractCosts, t_energyTransportCosts, t_peakConsumptionCosts, t_totalConnectionCosts, t_previousPhysicalConnectionCosts, t_previousDefaultContractCosts, t_previousEnergyTransportCosts, t_previousPeakConsumptionCosts, t_previousTotalConnectionCosts);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_chartConnectionCosts:
        if (true) {
          ShapeImage self = this.i_chartConnectionCosts;
          
uI_Results.f_setInfoText(i_chartConnectionCosts, uI_Results.v_infoText.chartConnectionCosts, i_chartConnectionCosts.getX(), i_chartConnectionCosts.getY()); 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jan_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jan_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jan_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jan_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_apr_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_apr_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_apr_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_apr_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jul_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jul_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jul_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jul_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_sep_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_sep_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_sep_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_sep_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_dec_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_dec_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_dec_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_dec_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_nov_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_nov_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_nov_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_nov_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_aug_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_aug_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_aug_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_aug_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jun_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jun_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jun_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_jun_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_may_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_may_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_may_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_may_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_mar_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_mar_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_mar_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_mar_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_feb_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_feb_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_feb_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_feb_DataItem3Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_okt_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_okt_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_okt_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_monthlyConnectionCosts_okt_DataItem3Value() {
    return 
0 
;
  }
  protected StackChart chart_layout;
  protected StackChart chart_monthlyConnectionCosts_jan;
  protected StackChart chart_monthlyConnectionCosts_apr;
  protected StackChart chart_monthlyConnectionCosts_jul;
  protected StackChart chart_monthlyConnectionCosts_sep;
  protected StackChart chart_monthlyConnectionCosts_dec;
  protected StackChart chart_monthlyConnectionCosts_nov;
  protected StackChart chart_monthlyConnectionCosts_aug;
  protected StackChart chart_monthlyConnectionCosts_jun;
  protected StackChart chart_monthlyConnectionCosts_may;
  protected StackChart chart_monthlyConnectionCosts_mar;
  protected StackChart chart_monthlyConnectionCosts_feb;
  protected StackChart chart_monthlyConnectionCosts_okt;
  
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
  protected ShapeText txt_connectionCosts;
  protected ShapeImage i_chartConnectionCosts;
  protected ShapeText txt_totalConnectionCosts;
  protected ShapeText txt_peakConsumptionCosts;
  protected ShapeText txt_energyTransportCosts;
  protected ShapeText txt_physicalConnectionCosts;
  protected ShapeText txt_defaultContractCosts;
  protected ShapeLine line_total;
  protected ShapeText txt_MonthlyConnectionCosts;
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
  private void _rect_legendPhysicalConnectionCosts_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
color_physicalConnectionCosts 
);
  }
  
  protected ShapeRectangle rect_legendPhysicalConnectionCosts;
  protected ShapeText txt_legendPhysicalConnectionCosts;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_legendContractCosts_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
color_contractConnectionCosts 
);
  }
  
  protected ShapeRectangle rect_legendContractCosts;
  protected ShapeText txt_legendContractCosts;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_legendTransportCosts_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
color_transportConnectionCosts 
);
  }
  
  protected ShapeRectangle rect_legendTransportCosts;
  protected ShapeText txt_legendTransportCosts;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_legendMonthlyPeakCosts_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
color_monthlyPeakConnectionCosts 
);
  }
  
  protected ShapeRectangle rect_legendMonthlyPeakCosts;
  protected ShapeText txt_legendMonthlyPeakCosts;
  protected ShapeGroup gr_connectionCostsMonthlyLegend;
  protected ShapeGroup gr_stackedBarChartMonthlyConnectionCosts;
  protected ShapeText txt_monthlyChartYAxis;
  protected ShapeGroup gr_monthlyConnectionCostCharts;
  protected ShapeText t_physicalConnectionCosts;
  protected ShapeText t_defaultContractCosts;
  protected ShapeText t_energyTransportCosts;
  protected ShapeText t_peakConsumptionCosts;
  protected ShapeText t_totalConnectionCosts;
  protected ShapeText t_previousPhysicalConnectionCosts;
  protected ShapeText t_previousDefaultContractCosts;
  protected ShapeText t_previousEnergyTransportCosts;
  protected ShapeText t_previousPeakConsumptionCosts;
  protected ShapeText t_previousTotalConnectionCosts;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
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
    txt_connectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 10.0, 0.0, 0.0,
        black,"Netaansluitingskosten",
        _txt_connectionCosts_Font, ALIGNMENT_CENTER );
    i_chartConnectionCosts = new ShapeImage(
		ChartConnectionCosts.this, SHAPE_DRAW_2D3D, true, 384.0, 12.0, 0.0, 0.0,
30.0, 30.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_chartConnectionCosts, 0, clickx, clicky );
      }
    };
    txt_totalConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 340.0, 0.0, 0.0,
        black,"Totale kosten:",
        _txt_totalConnectionCosts_Font, ALIGNMENT_LEFT );
    txt_peakConsumptionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 270.0, 0.0, 0.0,
        black,"Maandelijkse piek kosten:",
        _txt_peakConsumptionCosts_Font, ALIGNMENT_LEFT );
    txt_energyTransportCosts = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 220.0, 0.0, 0.0,
        black,"Transport kosten:",
        _txt_energyTransportCosts_Font, ALIGNMENT_LEFT );
    txt_physicalConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 120.0, 0.0, 0.0,
        black,"Fysieke aansluitingskosten:",
        _txt_physicalConnectionCosts_Font, ALIGNMENT_LEFT );
    txt_defaultContractCosts = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 170.0, 0.0, 0.0,
        black,"Vaste contract kosten:",
        _txt_defaultContractCosts_Font, ALIGNMENT_LEFT );
    line_total = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 40.0, 320.0, 0.0, silver,
 		380.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    txt_MonthlyConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -130.0, 0.0, 0.0,
        black,"Maandelijkse netaansluitingskosten",
        _txt_MonthlyConnectionCosts_Font, ALIGNMENT_CENTER );
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
    rect_legendPhysicalConnectionCosts = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-90.0, -25.0, 0.0, 0.0,
            null, red,
			10.0, 10.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_legendPhysicalConnectionCosts_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_legendPhysicalConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,-70.0, -25.0, 0.0, 0.0,
        black,"Fysieke aansluitingskosten",
        _txt_legendPhysicalConnectionCosts_Font, ALIGNMENT_LEFT );
    rect_legendContractCosts = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-90.0, -5.0, 0.0, 0.0,
            null, red,
			10.0, 10.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_legendContractCosts_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_legendContractCosts = new ShapeText(
        SHAPE_DRAW_2D, true,-70.0, -5.0, 0.0, 0.0,
        black,"Vaste contract kosten",
        _txt_legendContractCosts_Font, ALIGNMENT_LEFT );
    rect_legendTransportCosts = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,120.0, -25.0, 0.0, 0.0,
            null, red,
			10.0, 10.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_legendTransportCosts_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_legendTransportCosts = new ShapeText(
        SHAPE_DRAW_2D, true,140.0, -25.0, 0.0, 0.0,
        black,"Transport kosten",
        _txt_legendTransportCosts_Font, ALIGNMENT_LEFT );
    rect_legendMonthlyPeakCosts = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,120.0, -5.0, 0.0, 0.0,
            null, red,
			10.0, 10.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_legendMonthlyPeakCosts_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_legendMonthlyPeakCosts = new ShapeText(
        SHAPE_DRAW_2D, true,140.0, -5.0, 0.0, 0.0,
        black,"Maandelijkse piek kosten",
        _txt_legendMonthlyPeakCosts_Font, ALIGNMENT_LEFT );
    txt_monthlyChartYAxis = new ShapeText(
        SHAPE_DRAW_2D, true,-220.0, 18.0, 0.0, 0.0,
        black,"[€]",
        _txt_monthlyChartYAxis_Font, ALIGNMENT_CENTER );
    t_physicalConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 120.0, 0.0, 0.0,
        black,"€ 210.56",
        _t_physicalConnectionCosts_Font, ALIGNMENT_RIGHT );
    t_defaultContractCosts = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 170.0, 0.0, 0.0,
        black,"€ 210.56",
        _t_defaultContractCosts_Font, ALIGNMENT_RIGHT );
    t_energyTransportCosts = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 220.0, 0.0, 0.0,
        black,"€ 210.56",
        _t_energyTransportCosts_Font, ALIGNMENT_RIGHT );
    t_peakConsumptionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 270.0, 0.0, 0.0,
        black,"€ 210.56",
        _t_peakConsumptionCosts_Font, ALIGNMENT_RIGHT );
    t_totalConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 340.0, 0.0, 0.0,
        black,"€ 210.56",
        _t_totalConnectionCosts_Font, ALIGNMENT_RIGHT );
    t_previousPhysicalConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 145.0, 0.0, 0.0,
        black,"€ 210.56",
        _t_previousPhysicalConnectionCosts_Font, ALIGNMENT_RIGHT );
    t_previousDefaultContractCosts = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 195.0, 0.0, 0.0,
        black,"€ 210.56",
        _t_previousDefaultContractCosts_Font, ALIGNMENT_RIGHT );
    t_previousEnergyTransportCosts = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 245.0, 0.0, 0.0,
        black,"€ 210.56",
        _t_previousEnergyTransportCosts_Font, ALIGNMENT_RIGHT );
    t_previousPeakConsumptionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,410.0, 295.0, 0.0, 0.0,
        black,"€ 210.56",
        _t_previousPeakConsumptionCosts_Font, ALIGNMENT_RIGHT );
    t_previousTotalConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,409.0, 365.0, 0.0, 0.0,
        black,"€ 210.56",
        _t_previousTotalConnectionCosts_Font, ALIGNMENT_RIGHT );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    chart_layout = new StackChart(
ChartConnectionCosts.this, true, -50.0, -140.0,
			430.0, 300.0,
            null, null,
            40.0, 30.0,
			360.0, 210.0, white, black, black,
            30.0, Chart.SOUTH,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            null, darkGray, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jan_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jan_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jan_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jan_DataItem3Value() );
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
    chart_monthlyConnectionCosts_jan = new StackChart(
ChartConnectionCosts.this, true, -55.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_apr_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_apr_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_apr_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_apr_DataItem3Value() );
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
    chart_monthlyConnectionCosts_apr = new StackChart(
ChartConnectionCosts.this, true, 35.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jul_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jul_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jul_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jul_DataItem3Value() );
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
    chart_monthlyConnectionCosts_jul = new StackChart(
ChartConnectionCosts.this, true, 125.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_sep_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_sep_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_sep_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_sep_DataItem3Value() );
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
    chart_monthlyConnectionCosts_sep = new StackChart(
ChartConnectionCosts.this, true, 185.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_dec_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_dec_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_dec_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_dec_DataItem3Value() );
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
    chart_monthlyConnectionCosts_dec = new StackChart(
ChartConnectionCosts.this, true, 275.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_nov_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_nov_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_nov_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_nov_DataItem3Value() );
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
    chart_monthlyConnectionCosts_nov = new StackChart(
ChartConnectionCosts.this, true, 245.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_aug_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_aug_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_aug_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_aug_DataItem3Value() );
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
    chart_monthlyConnectionCosts_aug = new StackChart(
ChartConnectionCosts.this, true, 155.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jun_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jun_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jun_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_jun_DataItem3Value() );
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
    chart_monthlyConnectionCosts_jun = new StackChart(
ChartConnectionCosts.this, true, 95.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_may_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_may_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_may_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_may_DataItem3Value() );
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
    chart_monthlyConnectionCosts_may = new StackChart(
ChartConnectionCosts.this, true, 65.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_mar_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_mar_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_mar_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_mar_DataItem3Value() );
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
    chart_monthlyConnectionCosts_mar = new StackChart(
ChartConnectionCosts.this, true, 5.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_feb_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_feb_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_feb_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_feb_DataItem3Value() );
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
    chart_monthlyConnectionCosts_feb = new StackChart(
ChartConnectionCosts.this, true, -25.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_okt_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_okt_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_okt_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_monthlyConnectionCosts_okt_DataItem3Value() );
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
    chart_monthlyConnectionCosts_okt = new StackChart(
ChartConnectionCosts.this, true, 215.0, -135.0,
			110.0, 265.0,
            null, null,
            50.0, 30.0,
			20.0, 205.0, white, null, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_NONE,
            null, null, _items, _titles, _colors );
    }
    {
    gr_monthlyChartXaxis = new ShapeGroup( ChartConnectionCosts.this, SHAPE_DRAW_2D, true, 10.0, 140.0, 0.0, 0.0
	
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
    gr_connectionCostsMonthlyLegend = new ShapeGroup( ChartConnectionCosts.this, SHAPE_DRAW_2D3D, true, -70.0, 195.0, 0.0, 0.0
	
	     , rect_legendPhysicalConnectionCosts
	     , txt_legendPhysicalConnectionCosts
	     , rect_legendContractCosts
	     , txt_legendContractCosts
	     , rect_legendTransportCosts
	     , txt_legendTransportCosts
	     , rect_legendMonthlyPeakCosts
	     , txt_legendMonthlyPeakCosts );
    }
    {
    gr_stackedBarChartMonthlyConnectionCosts = new ShapeGroup( ChartConnectionCosts.this, SHAPE_DRAW_2D3D, true, -160.0, 30.0, 0.0, 0.0
	
	     , chart_layout
	     , chart_monthlyConnectionCosts_jan
	     , chart_monthlyConnectionCosts_apr
	     , chart_monthlyConnectionCosts_jul
	     , chart_monthlyConnectionCosts_sep
	     , chart_monthlyConnectionCosts_dec
	     , chart_monthlyConnectionCosts_nov
	     , chart_monthlyConnectionCosts_aug
	     , chart_monthlyConnectionCosts_jun
	     , chart_monthlyConnectionCosts_may
	     , chart_monthlyConnectionCosts_mar
	     , chart_monthlyConnectionCosts_feb
	     , chart_monthlyConnectionCosts_okt );
    }
    {
    gr_monthlyConnectionCostCharts = new ShapeGroup( ChartConnectionCosts.this, SHAPE_DRAW_2D3D, true, 230.0, 540.0, 0.0, 0.0
	
	     , txt_MonthlyConnectionCosts
	     , gr_monthlyChartXaxis
	     , gr_connectionCostsMonthlyLegend
	     , gr_stackedBarChartMonthlyConnectionCosts
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
  public ChartConnectionCosts( Engine engine, Agent owner, AgentList<? extends ChartConnectionCosts> ownerPopulation ) {
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
  public ChartConnectionCosts() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartConnectionCosts_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartConnectionCosts.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartConnectionCosts.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _chart_layout_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_jan_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_apr_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_jul_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_sep_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_dec_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_nov_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_aug_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_jun_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_may_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_mar_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_feb_autoUpdateEvent_xjal.start();
    _chart_monthlyConnectionCosts_okt_autoUpdateEvent_xjal.start();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

c_orderedStackCharts.add(chart_monthlyConnectionCosts_jan);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_feb);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_mar);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_apr);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_may);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_jun);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_jul);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_aug);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_sep);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_okt);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_nov);
c_orderedStackCharts.add(chart_monthlyConnectionCosts_dec);
 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartConnectionCosts_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartConnectionCosts_xjal() {
    color_physicalConnectionCosts = 
purple 
;
    color_contractConnectionCosts = 
red 
;
    color_transportConnectionCosts = 
orange 
;
    color_monthlyPeakConnectionCosts = 
green 
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

  public AgentList<? extends ChartConnectionCosts> getPopulation() {
    return (AgentList<? extends ChartConnectionCosts>) super.getPopulation();
  }

  public List<? extends ChartConnectionCosts> agentsInRange( double distance ) {
    return (List<? extends ChartConnectionCosts>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _chart_layout_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_jan_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_apr_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_jul_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_sep_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_dec_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_nov_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_aug_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_jun_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_may_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_mar_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_feb_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_monthlyConnectionCosts_okt_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _chart_layout_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_jan_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_apr_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_jul_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_sep_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_dec_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_nov_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_aug_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_jun_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_may_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_mar_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_feb_autoUpdateEvent_xjal.onDestroy();
    _chart_monthlyConnectionCosts_okt_autoUpdateEvent_xjal.onDestroy();
    super.onDestroy();
  }


}
