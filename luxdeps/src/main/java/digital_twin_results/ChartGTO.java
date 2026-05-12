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

public class ChartGTO extends digital_twin_results.ChartArea
{
  // Parameters
  // Plain Variables

  public 
Color 
 v_originalValueColor;
  public 
Color 
 v_scenarioDeltaValueColor;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartGTO.class );

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
  public EventTimeout _chart_GTV_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_peakCollective_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_peakIndividual_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_GTO_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _chart_GTV_autoUpdateEvent_xjal ) return "chart_GTV auto update event";
     if( _e == _chart_peakCollective_autoUpdateEvent_xjal ) return "chart_peakCollective auto update event";
     if( _e == _chart_peakIndividual_autoUpdateEvent_xjal ) return "chart_peakIndividual auto update event";
     if( _e == _chart_GTO_autoUpdateEvent_xjal ) return "chart_GTO auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _chart_GTV_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_peakCollective_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_peakIndividual_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_GTO_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _chart_GTV_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_peakCollective_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_peakIndividual_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_GTO_autoUpdateEvent_xjal ) {
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
    if( _e == _chart_GTV_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_peakCollective_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_peakIndividual_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_GTO_autoUpdateEvent_xjal) {
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
    if ( _e == _chart_GTV_autoUpdateEvent_xjal ) {
      chart_GTV.updateData();
      return;
    }
    if ( _e == _chart_peakCollective_autoUpdateEvent_xjal ) {
      chart_peakCollective.updateData();
      return;
    }
    if ( _e == _chart_peakIndividual_autoUpdateEvent_xjal ) {
      chart_peakIndividual.updateData();
      return;
    }
    if ( _e == _chart_GTO_autoUpdateEvent_xjal ) {
      chart_GTO.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = digital_twin_results.ChartArea._STATECHART_COUNT_xjal + 0;


  // Functions

  public void f_setChartGTO(  ) { 

I_EnergyData data = uI_Results.f_getSelectedObjectData();

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 60, true);

if(uI_Results.v_selectedObjectScope != OL_ResultScope.ENERGYCOOP){
	List<OL_ResultScope> supportedResultScopes = new ArrayList<>(List.of(OL_ResultScope.ENERGYCOOP));
	uI_Results.f_activateChartBlocker(supportedResultScopes);
	return;
}

//Reset chart
f_resetChart();

//Set Charts
EnergyCoop energyCoop = (EnergyCoop)data;
f_setGTOBarChart(energyCoop);
 
  }

  void f_resetChart(  ) { 

chart_GTO.removeAll();
chart_peakIndividual.removeAll();
chart_peakCollective.removeAll();
chart_GTV.removeAll();
gr_GTOChart.setVisible(false); // Needed to refresh the graph
gr_barChartLegend.setVisible(false);
txt_warningNoOriginalRapidRun.setVisible(false); 
  }

  void f_setGTOBarChart( EnergyCoop COOP ) { 

if(COOP.v_originalRapidRunData == null){
	f_setGTOBarChart_noOriginalRapidRun(COOP);
	return;
}

gr_barChartLegend.setVisible(true);

double originalGTO_kW = 0;
double originalPeakIndividual_kW = 0;
double originalPeakCollective_kW = 0;
double originalTotalGTV_kW = 0;

double scenarioDeltaGTO_kW = 0;
double scenarioDeltaPeakIndividual_kW = 0;
double scenarioDeltaPeakCollective_kW = 0;
double scenarioDeltaTotalGTV_kW = 0;
	
//Get the values
if(rb_GTO_delivery_or_feedin.getValue() == 0){//Delivery
	originalGTO_kW = COOP.f_getGroupContractDeliveryCapacity_kW(COOP.v_originalRapidRunData, uI_Results.energyModel.p_timeParameters);
	originalPeakIndividual_kW = COOP.v_cumulativeIndividualPeakDeliveryOriginal_kW;
	originalPeakCollective_kW = COOP.v_originalRapidRunData.getPeakDelivery_kW();
	originalTotalGTV_kW = COOP.v_originalRapidRunData.connectionMetaData.getContractedDeliveryCapacity_kW();

	scenarioDeltaGTO_kW = COOP.f_getGroupContractDeliveryCapacity_kW(COOP.v_rapidRunData, uI_Results.energyModel.p_timeParameters)  - originalGTO_kW;
	scenarioDeltaPeakIndividual_kW = COOP.v_cumulativeIndividualPeakDelivery_kW  - originalPeakIndividual_kW;
	scenarioDeltaPeakCollective_kW = COOP.v_rapidRunData.getPeakDelivery_kW()  - originalPeakCollective_kW;
	scenarioDeltaTotalGTV_kW = COOP.v_rapidRunData.connectionMetaData.getContractedDeliveryCapacity_kW()  - originalTotalGTV_kW;
}
else if(rb_GTO_delivery_or_feedin.getValue() == 1){//Feedin
	originalGTO_kW = COOP.f_getGroupContractFeedinCapacity_kW(COOP.v_originalRapidRunData, uI_Results.energyModel.p_timeParameters);
	originalPeakIndividual_kW = COOP.v_cumulativeIndividualPeakFeedinOriginal_kW;
	originalPeakCollective_kW = COOP.v_originalRapidRunData.getPeakFeedin_kW();
	originalTotalGTV_kW = COOP.v_originalRapidRunData.connectionMetaData.getContractedFeedinCapacity_kW();

	scenarioDeltaGTO_kW = COOP.f_getGroupContractFeedinCapacity_kW(COOP.v_rapidRunData, uI_Results.energyModel.p_timeParameters)  - originalGTO_kW;
	scenarioDeltaPeakIndividual_kW = COOP.v_cumulativeIndividualPeakFeedin_kW  - originalPeakIndividual_kW;
	scenarioDeltaPeakCollective_kW = COOP.v_rapidRunData.getPeakFeedin_kW()  - originalPeakCollective_kW;
	scenarioDeltaTotalGTV_kW = COOP.v_rapidRunData.connectionMetaData.getContractedFeedinCapacity_kW()  - originalTotalGTV_kW;
}


//Check wheter scenario should be smalles bar or original -> adjust accordingly (smaller bar is upfront, so difference can always be seen)
Pair<Double, Double> dataValues_chartGTO_kW = new Pair(originalGTO_kW, scenarioDeltaGTO_kW);
Pair<Color, Color> colors_chartGTO = new Pair(v_originalValueColor, v_scenarioDeltaValueColor);
Pair<String, String> legendLabels_chartGTO = new Pair("Huidige situatie", "Scenario");  
if(scenarioDeltaGTO_kW < 0){
	dataValues_chartGTO_kW = new Pair(originalGTO_kW + scenarioDeltaGTO_kW, -1*scenarioDeltaGTO_kW);
	colors_chartGTO = new Pair(v_scenarioDeltaValueColor, v_originalValueColor); 
	legendLabels_chartGTO = new Pair("Scenario", "Huidige situatie");   
}

Pair<Double, Double> dataValues_chartPeakIndividual_kW = new Pair(originalPeakIndividual_kW, scenarioDeltaPeakIndividual_kW);
Pair<Color, Color> colors_chartPeakIndividual = new Pair(v_originalValueColor, v_scenarioDeltaValueColor);
Pair<String, String> legendLabels_chartPeakIndividual = new Pair("Huidige situatie", "Scenario");   
if(scenarioDeltaPeakIndividual_kW < 0){
	dataValues_chartPeakIndividual_kW = new Pair(originalPeakIndividual_kW + scenarioDeltaPeakIndividual_kW, -1*scenarioDeltaPeakIndividual_kW);
	colors_chartPeakIndividual = new Pair(v_scenarioDeltaValueColor, v_originalValueColor); 
	legendLabels_chartPeakIndividual = new Pair("Scenario", "Huidige situatie");   
}

Pair<Double, Double> dataValues_chartPeakCollective_kW = new Pair(originalPeakCollective_kW, scenarioDeltaPeakCollective_kW);
Pair<Color, Color> colors_chartPeakCollective = new Pair(v_originalValueColor, v_scenarioDeltaValueColor);
Pair<String, String> legendLabels_chartPeakCollective = new Pair("Huidige situatie", "Scenario");   
if(scenarioDeltaPeakCollective_kW < 0){
	dataValues_chartPeakCollective_kW = new Pair(originalPeakCollective_kW + scenarioDeltaPeakCollective_kW, -1*scenarioDeltaPeakCollective_kW);
	colors_chartPeakCollective = new Pair(v_scenarioDeltaValueColor, v_originalValueColor); 
	legendLabels_chartPeakCollective = new Pair("Scenario", "Huidige situatie");   
}

Pair<Double, Double> dataValues_chartGTV_kW = new Pair(originalTotalGTV_kW, scenarioDeltaTotalGTV_kW);
Pair<Color, Color> colors_chartGTV = new Pair(v_originalValueColor, v_scenarioDeltaValueColor);
Pair<String, String> legendLabels_chartGTV = new Pair("Huidige situatie", "Scenario");   
if(scenarioDeltaTotalGTV_kW < 0){
	dataValues_chartGTV_kW = new Pair(originalTotalGTV_kW + scenarioDeltaTotalGTV_kW, -1*scenarioDeltaTotalGTV_kW);
	colors_chartGTV = new Pair(v_scenarioDeltaValueColor, v_originalValueColor); 
	legendLabels_chartGTV = new Pair("Scenario", "Huidige situatie");   
}	

//Create data items
DataItem first_DataItem_GTO_kW = new DataItem();
DataItem second_DataItem_GTO_kW = new DataItem();
DataItem first_DataItem_PeakIndividual_kW = new DataItem();
DataItem second_DataItem_PeakIndividual_kW = new DataItem();
DataItem first_DataItem_PeakCollective_kW = new DataItem();
DataItem second_DataItem_PeakCollective_kW = new DataItem();
DataItem first_DataItem_GTV_kW = new DataItem();
DataItem second_DataItem_GTV_kW = new DataItem();


//Set data item values
first_DataItem_GTO_kW.setValue(dataValues_chartGTO_kW.getFirst());
second_DataItem_GTO_kW.setValue(dataValues_chartGTO_kW.getSecond());
first_DataItem_PeakIndividual_kW.setValue(dataValues_chartPeakIndividual_kW.getFirst());
second_DataItem_PeakIndividual_kW.setValue(dataValues_chartPeakIndividual_kW.getSecond());
first_DataItem_PeakCollective_kW.setValue(dataValues_chartPeakCollective_kW.getFirst());
second_DataItem_PeakCollective_kW.setValue(dataValues_chartPeakCollective_kW.getSecond());
first_DataItem_GTV_kW.setValue(dataValues_chartGTV_kW.getFirst());
second_DataItem_GTV_kW.setValue(dataValues_chartGTV_kW.getSecond());

//Scale axis to same value for all 4 stack charts
double[] chartHeights_kW = {dataValues_chartGTO_kW.getFirst() + dataValues_chartGTO_kW.getSecond(), 
							dataValues_chartPeakIndividual_kW.getFirst() + dataValues_chartPeakIndividual_kW.getSecond(),
							dataValues_chartPeakCollective_kW.getFirst() + dataValues_chartPeakCollective_kW.getSecond(),
							dataValues_chartGTV_kW.getFirst() + dataValues_chartGTV_kW.getSecond()}; 
double chartScale_kW = max(chartHeights_kW);
chart_GTO.setFixedScale(chartScale_kW);
chart_peakIndividual.setFixedScale(chartScale_kW);
chart_peakCollective.setFixedScale(chartScale_kW);
chart_GTV.setFixedScale(chartScale_kW);


chart_GTO.addDataItem(first_DataItem_GTO_kW, legendLabels_chartGTO.getFirst(), colors_chartGTO.getFirst());
chart_GTO.addDataItem(second_DataItem_GTO_kW, legendLabels_chartGTO.getSecond(),  colors_chartGTO.getSecond());

chart_peakIndividual.addDataItem(first_DataItem_PeakIndividual_kW, legendLabels_chartPeakIndividual.getFirst(), colors_chartPeakIndividual.getFirst());
chart_peakIndividual.addDataItem(second_DataItem_PeakIndividual_kW, legendLabels_chartPeakIndividual.getSecond(), colors_chartPeakIndividual.getSecond());

chart_peakCollective.addDataItem(first_DataItem_PeakCollective_kW, legendLabels_chartPeakCollective.getFirst(), colors_chartPeakCollective.getFirst());
chart_peakCollective.addDataItem(second_DataItem_PeakCollective_kW, legendLabels_chartPeakCollective.getSecond(), colors_chartPeakCollective.getSecond());

chart_GTV.addDataItem(first_DataItem_GTV_kW, legendLabels_chartGTV.getFirst(), colors_chartGTV.getFirst());
chart_GTV.addDataItem(second_DataItem_GTV_kW, legendLabels_chartGTV.getSecond(), colors_chartGTV.getSecond());

gr_GTOChart.setVisible(true);  // Needed to refresh the graph 
  }

  void f_setGTOBarChart_noOriginalRapidRun( EnergyCoop COOP ) { 

txt_warningNoOriginalRapidRun.setVisible(true);

double scenarioGTO_kW = 0;
double scenarioPeakIndividual_kW = 0;
double scenarioPeakCollective_kW = 0;
double scenarioTotalGTV_kW = 0;
	
//Get the values
if(rb_GTO_delivery_or_feedin.getValue() == 0){//Delivery
	scenarioGTO_kW = COOP.f_getGroupContractDeliveryCapacity_kW(COOP.v_rapidRunData, uI_Results.energyModel.p_timeParameters);
	scenarioPeakIndividual_kW = COOP.v_cumulativeIndividualPeakDelivery_kW;
	scenarioPeakCollective_kW = COOP.v_rapidRunData.getPeakDelivery_kW();
	scenarioTotalGTV_kW = COOP.v_rapidRunData.connectionMetaData.getContractedDeliveryCapacity_kW();
}
else if(rb_GTO_delivery_or_feedin.getValue() == 1){//Feedin
	scenarioGTO_kW = COOP.f_getGroupContractFeedinCapacity_kW(COOP.v_rapidRunData, uI_Results.energyModel.p_timeParameters);
	scenarioPeakIndividual_kW = COOP.v_cumulativeIndividualPeakFeedin_kW;
	scenarioPeakCollective_kW = COOP.v_rapidRunData.getPeakFeedin_kW();
	scenarioTotalGTV_kW = COOP.v_rapidRunData.connectionMetaData.getContractedFeedinCapacity_kW();
}

//Create data items
DataItem first_DataItem_GTO_kW = new DataItem();
DataItem first_DataItem_PeakIndividual_kW = new DataItem();
DataItem first_DataItem_PeakCollective_kW = new DataItem();
DataItem first_DataItem_GTV_kW = new DataItem();

//Set data item values
first_DataItem_GTO_kW.setValue(scenarioGTO_kW);
first_DataItem_PeakIndividual_kW.setValue(scenarioPeakIndividual_kW);
first_DataItem_PeakCollective_kW.setValue(scenarioPeakCollective_kW);
first_DataItem_GTV_kW.setValue(scenarioTotalGTV_kW);

//Scale axis to same value for all 4 stack charts
double[] chartHeights_kW = {scenarioGTO_kW, 
							scenarioPeakIndividual_kW,
							scenarioPeakCollective_kW,
							scenarioTotalGTV_kW}; 
double chartScale_kW = max(chartHeights_kW);
chart_GTO.setFixedScale(chartScale_kW);
chart_peakIndividual.setFixedScale(chartScale_kW);
chart_peakCollective.setFixedScale(chartScale_kW);
chart_GTV.setFixedScale(chartScale_kW);


chart_GTO.addDataItem(first_DataItem_GTO_kW, "Scenario GTO", v_scenarioDeltaValueColor);
chart_peakIndividual.addDataItem(first_DataItem_PeakIndividual_kW, "Scenario piek individueel", v_scenarioDeltaValueColor);
chart_peakCollective.addDataItem(first_DataItem_PeakCollective_kW, "Scenario piek collectief", v_scenarioDeltaValueColor);
chart_GTV.addDataItem(first_DataItem_GTV_kW, "Scenario cumulatieve GTV", v_scenarioDeltaValueColor);

gr_GTOChart.setVisible(true);  // Needed to refresh the graph 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_GTO_delivery_or_feedin_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chartGTO_Font = new Font("SansSerif", 1, 26 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_titleGTO_Font = new Font("Arial", 1, 28 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_gtoValuesYlabel_Font = new Font("Arial", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_GTO_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_peakIndividual_Font = _txt_GTO_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_peakCollective_Font = _txt_GTO_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_cumulativeGTV_Font = _txt_GTO_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_barChartLegendItem1_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_barChartLegendItem2_Font = _txt_barChartLegendItem1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_warningNoOriginalRapidRun_Font = new Font("SansSerif", 1, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_header = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chartGTO = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_titleGTO = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_gtoValuesYlabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_GTO = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_peakIndividual = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_peakCollective = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_cumulativeGTV = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_barChartLegendItem1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_barChartLegendItem1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_barChartLegendItem2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_barChartLegendItem2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_barChartLegend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_barChartGTO = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_warningNoOriginalRapidRun = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_GTOChart = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_GTV = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_peakCollective = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_peakIndividual = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_GTO = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_GTO_delivery_or_feedin = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;

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
	  level.addAll(gr_GTOChart);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, int value ) {
    switch( _shape ) {
      case _rb_GTO_delivery_or_feedin: {
          ShapeRadioButtonGroup self = this.rb_GTO_delivery_or_feedin;
f_setChartGTO(); 
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
  private double _chart_GTV_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_GTV_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_peakCollective_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_peakCollective_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_peakIndividual_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_peakIndividual_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_GTO_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_GTO_DataItem1Value() {
    return 
0 
;
  }
  protected ShapeRadioButtonGroup rb_GTO_delivery_or_feedin;
  protected StackChart chart_GTV;
  protected StackChart chart_peakCollective;
  protected StackChart chart_peakIndividual;
  protected StackChart chart_GTO;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_header_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_lineColor 
);
    shape.setLineWidth(
v_lineWidth 
);
  }
  
  protected ShapeRectangle rect_header;
  protected ShapeText txt_chartGTO;
  protected ShapeText txt_titleGTO;
  protected ShapeText txt_gtoValuesYlabel;
  protected ShapeText txt_GTO;
  protected ShapeText txt_peakIndividual;
  protected ShapeText txt_peakCollective;
  protected ShapeText txt_cumulativeGTV;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval_barChartLegendItem1_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_originalValueColor 
);
  }
  
  protected ShapeOval oval_barChartLegendItem1;
  protected ShapeText txt_barChartLegendItem1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval_barChartLegendItem2_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_scenarioDeltaValueColor 
);
  }
  
  protected ShapeOval oval_barChartLegendItem2;
  protected ShapeText txt_barChartLegendItem2;
  protected ShapeGroup gr_barChartLegend;
  protected ShapeGroup gr_barChartGTO;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_warningNoOriginalRapidRun_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setX(
230 
);
    shape.setY(
580 
);
  }
  
  protected ShapeText txt_warningNoOriginalRapidRun;
  protected ShapeGroup gr_GTOChart;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rb_GTO_delivery_or_feedin = new ShapeRadioButtonGroup(
ChartGTO.this, true, 140.0, 100.0,
			170.0, 60.0,
            black, true,
_rb_GTO_delivery_or_feedin_Font, false,
            new String[]{"Afname", "Teruglevering", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_GTO_delivery_or_feedin, 0, value );
      }
    };
    rect_header = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            lavender, whiteSmoke,
			460.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_header_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_chartGTO = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 10.0, 0.0, 0.0,
        black,"Groepscontract overeenkomst",
        _txt_chartGTO_Font, ALIGNMENT_CENTER );
    txt_titleGTO = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 190.0, 0.0, 0.0,
        black,"Groepscontract capaciteit",
        _txt_titleGTO_Font, ALIGNMENT_CENTER );
    txt_gtoValuesYlabel = new ShapeText(
        SHAPE_DRAW_2D, true,-340.0, -20.0, 0.0, 4.71238898038469,
        black,"kW",
        _txt_gtoValuesYlabel_Font, ALIGNMENT_CENTER );
    txt_GTO = new ShapeText(
        SHAPE_DRAW_2D, true,-245.0, -160.0, 0.0, 0.0,
        black,"GTO",
        _txt_GTO_Font, ALIGNMENT_CENTER );
    txt_peakIndividual = new ShapeText(
        SHAPE_DRAW_2D, true,-165.0, -170.0, 0.0, 0.0,
        black,"Piek\nindividueel",
        _txt_peakIndividual_Font, ALIGNMENT_CENTER );
    txt_peakCollective = new ShapeText(
        SHAPE_DRAW_2D, true,-85.0, -170.0, 0.0, 0.0,
        black,"Piek\ncollectief",
        _txt_peakCollective_Font, ALIGNMENT_CENTER );
    txt_cumulativeGTV = new ShapeText(
        SHAPE_DRAW_2D, true,-5.0, -170.0, 0.0, 0.0,
        black,"Cumulatieve\nGTV",
        _txt_cumulativeGTV_Font, ALIGNMENT_CENTER );
    oval_barChartLegendItem1 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-55.0, -10.0, 0.0, 0.0,
       null, teal,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval_barChartLegendItem1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_barChartLegendItem1 = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, -17.0, 0.0, 0.0,
        black,"Huidige situatie",
        _txt_barChartLegendItem1_Font, ALIGNMENT_LEFT );
    oval_barChartLegendItem2 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-55.0, 10.0, 0.0, 0.0,
       null, orange,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval_barChartLegendItem2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_barChartLegendItem2 = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, 2.5, 0.0, 0.0,
        black,"Ingesteld scenario",
        _txt_barChartLegendItem2_Font, ALIGNMENT_LEFT );
    txt_warningNoOriginalRapidRun = new ShapeText(
        SHAPE_DRAW_2D, true,1820.0, 560.0, 0.0, 0.0,
        red,"Let op: Normaal laat deze grafiek de verschillen zien tussen de huidige situatie\nen het ingestelde scenario, echter, doordat er bedrijven zijn toevoegd aan de selectie\nwaar we geen data van hebben ontvangen, staat deze functionaliteit uit en zie je alleen\nde data van het ingestelde scenario.",
        _txt_warningNoOriginalRapidRun_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_warningNoOriginalRapidRun_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataItem> _items = new ArrayList<>( 2 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_GTV_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_GTV_DataItem1Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 2 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    List<Color> _colors = new ArrayList<>( 2 );
    _colors.add( teal );
    _colors.add( orange );
    chart_GTV = new StackChart(
ChartGTO.this, true, -95.0, -140.0,
			260.0, 270.0,
            null, null,
            50.0, 10.0,
			80.0, 230.0, white, black, black,
            50.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.5,
            Chart.GRID_NONE,
            null, darkGray, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 2 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_peakCollective_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_peakCollective_DataItem1Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 2 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    List<Color> _colors = new ArrayList<>( 2 );
    _colors.add( teal );
    _colors.add( orange );
    chart_peakCollective = new StackChart(
ChartGTO.this, true, -175.0, -140.0,
			260.0, 270.0,
            null, null,
            50.0, 10.0,
			80.0, 230.0, white, black, black,
            50.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.5,
            Chart.GRID_NONE,
            null, darkGray, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 2 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_peakIndividual_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_peakIndividual_DataItem1Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 2 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    List<Color> _colors = new ArrayList<>( 2 );
    _colors.add( teal );
    _colors.add( orange );
    chart_peakIndividual = new StackChart(
ChartGTO.this, true, -255.0, -140.0,
			260.0, 270.0,
            null, null,
            50.0, 10.0,
			80.0, 230.0, white, black, black,
            50.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.5,
            Chart.GRID_NONE,
            null, darkGray, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 2 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_GTO_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_GTO_DataItem1Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 2 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    List<Color> _colors = new ArrayList<>( 2 );
    _colors.add( teal );
    _colors.add( orange );
    chart_GTO = new StackChart(
ChartGTO.this, true, -325.0, -140.0,
			260.0, 270.0,
            null, null,
            40.0, 10.0,
			80.0, 230.0, white, black, black,
            50.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.5,
            Chart.GRID_DEFAULT,
            null, darkGray, _items, _titles, _colors );
    }
    {
    gr_barChartLegend = new ShapeGroup( ChartGTO.this, SHAPE_DRAW_2D3D, true, -220.0, 145.0, 0.0, 0.0
	
	     , oval_barChartLegendItem1
	     , txt_barChartLegendItem1
	     , oval_barChartLegendItem2
	     , txt_barChartLegendItem2 );
    }
    {
    gr_barChartGTO = new ShapeGroup( ChartGTO.this, SHAPE_DRAW_2D3D, true, 370.0, 450.0, 0.0, 0.0
	
	     , txt_gtoValuesYlabel
	     , chart_GTV
	     , chart_peakCollective
	     , chart_peakIndividual
	     , chart_GTO
	     , txt_GTO
	     , txt_peakIndividual
	     , txt_peakCollective
	     , txt_cumulativeGTV
	     , gr_barChartLegend );
    }
    {
    gr_GTOChart = new ShapeGroup( ChartGTO.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , rb_GTO_delivery_or_feedin
	     , rect_header
	     , txt_chartGTO
	     , txt_titleGTO
	     , gr_barChartGTO
	     , txt_warningNoOriginalRapidRun );
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
  public ChartGTO( Engine engine, Agent owner, AgentList<? extends ChartGTO> ownerPopulation ) {
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
  public ChartGTO() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartGTO_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartGTO.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartGTO.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _chart_GTV_autoUpdateEvent_xjal.start();
    _chart_peakCollective_autoUpdateEvent_xjal.start();
    _chart_peakIndividual_autoUpdateEvent_xjal.start();
    _chart_GTO_autoUpdateEvent_xjal.start();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartGTO_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartGTO_xjal() {
    v_originalValueColor = 
teal 
;
    v_scenarioDeltaValueColor = 
orange 
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

  public AgentList<? extends ChartGTO> getPopulation() {
    return (AgentList<? extends ChartGTO>) super.getPopulation();
  }

  public List<? extends ChartGTO> agentsInRange( double distance ) {
    return (List<? extends ChartGTO>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _chart_GTV_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_peakCollective_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_peakIndividual_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_GTO_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _chart_GTV_autoUpdateEvent_xjal.onDestroy();
    _chart_peakCollective_autoUpdateEvent_xjal.onDestroy();
    _chart_peakIndividual_autoUpdateEvent_xjal.onDestroy();
    _chart_GTO_autoUpdateEvent_xjal.onDestroy();
    super.onDestroy();
  }


}
