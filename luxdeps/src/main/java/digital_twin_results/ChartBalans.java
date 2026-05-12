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

public class ChartBalans extends digital_twin_results.ChartArea
{
  // Parameters

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartBalans.class );

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
  public EventTimeout _bc_productionMonthlyTotals_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _bc_consumptionMonthlyTotals_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _bc_productionMonthlyTotals_autoUpdateEvent_xjal ) return "bc_productionMonthlyTotals auto update event";
     if( _e == _bc_consumptionMonthlyTotals_autoUpdateEvent_xjal ) return "bc_consumptionMonthlyTotals auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _bc_productionMonthlyTotals_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _bc_consumptionMonthlyTotals_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _bc_productionMonthlyTotals_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _bc_consumptionMonthlyTotals_autoUpdateEvent_xjal ) {
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
    if( _e == _bc_productionMonthlyTotals_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _bc_consumptionMonthlyTotals_autoUpdateEvent_xjal) {
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
    if ( _e == _bc_productionMonthlyTotals_autoUpdateEvent_xjal ) {
      bc_productionMonthlyTotals.updateData();
      return;
    }
    if ( _e == _bc_consumptionMonthlyTotals_autoUpdateEvent_xjal ) {
      bc_consumptionMonthlyTotals.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = digital_twin_results.ChartArea._STATECHART_COUNT_xjal + 0;


  // Functions

  void f_setCharts(  ) { 

f_resetCharts();
f_setVisiblity();

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 90, true);

if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
	f_setTrafoBalanceChartTotal(uI_Results.v_gridNode);
	f_setTrafoBalanceChartSummerWinter(uI_Results.v_gridNode);
	f_setTrafoBalanceChartDayNight(uI_Results.v_gridNode);
	f_setTrafoBalanceChartWeekdayWeekend(uI_Results.v_gridNode);
	}
else {
	I_EnergyData data = uI_Results.f_getSelectedObjectData();
	if( radio_energyType.getValue() == 0){
		switch(radio_period.getValue()){
			case 0:
				f_setElectricityBalanceChartTotal(data);
				break;
			case 1:
				f_setElectricityBalanceChartSummerWinter(data);
				break;
			case 2:
				f_setElectricityBalanceChartDayNight(data);
				break;
			case 3:
				f_setElectricityBalanceChartWeekdayWeekend(data);
				break;
		}
	}
	else if( radio_energyType.getValue() == 1){
	
			switch(radio_period.getValue()){
			case 0:
				f_setEnergyBalanceChartTotal(data);
				break;
			case 1:
				f_setEnergyBalanceChartSummerWinter(data);
				break;
			case 2:
				f_setEnergyBalanceChartDayNight(data);
				break;
			case 3:
				f_setEnergyBalanceChartWeekdayWeekend(data);
				break;
		}
	}
} 
  }

  void f_setElectricityBalanceChartTotal( I_EnergyData dataObject ) { 

DataItem annualSelfConsumed = new DataItem();
annualSelfConsumed.setValue(dataObject.getRapidRunData().getTotalElectricitySelfConsumed_MWh());
pl_productionChartBalanceTotal.addDataItem(annualSelfConsumed, "Lokaal gebruikt [MWh]", uI_Results.v_selfConsumedElectricityColor);
pl_consumptionChartBalanceTotal.addDataItem(annualSelfConsumed, "Lokaal opgewekt [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem annualImport = new DataItem();
annualImport.setValue(dataObject.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.ELECTRICITY));
pl_consumptionChartBalanceTotal.addDataItem(annualImport, "Externe bronnen [MWh]", uI_Results.v_importedEnergyColor);

DataItem annualExport = new DataItem();
annualExport.setValue(dataObject.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.ELECTRICITY));
pl_productionChartBalanceTotal.addDataItem(annualExport, "Teruggeleverde elektriciteit [MWh]", uI_Results.v_exportedEnergyColor);

double production_MWh = dataObject.getRapidRunData().getTotalElectricityProduced_MWh(); 
double consumption_MWh = dataObject.getRapidRunData().getTotalElectricityConsumed_MWh();
double chartScale_MWh = max(production_MWh, consumption_MWh);
pl_consumptionChartBalanceTotal.setFixedScale(chartScale_MWh);
pl_productionChartBalanceTotal.setFixedScale(chartScale_MWh);


if (chartScale_MWh<10) {
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToInt(production_MWh*1000) + " kWh");
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToInt(consumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToInt(production_MWh) + " MWh");
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToInt(consumption_MWh) + " MWh");
} else {
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToDecimal(production_MWh/1000, 1) + " GWh");
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToDecimal(consumption_MWh/1000,1) + " GWh");
} 
  }

  void f_setElectricityBalanceChartSummerWinter( I_EnergyData dataObject ) { 

// Summer
DataItem summerSelfConsumed = new DataItem();
summerSelfConsumed.setValue(dataObject.getRapidRunData().getSummerWeekElectricitySelfConsumed_MWh());
pl_productionChartSummer.addDataItem(summerSelfConsumed, "Lokaal gebruikt [MWh]", uI_Results.v_selfConsumedElectricityColor);
pl_consumptionChartSummer.addDataItem(summerSelfConsumed, "Lokaal opgewekt [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem summerImport = new DataItem();
summerImport.setValue(dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getIntegralPos_MWh());
pl_consumptionChartSummer.addDataItem(summerImport, "Externe bronnen [MWh]", uI_Results.v_importedEnergyColor);

DataItem summerExport = new DataItem();
summerExport.setValue(-dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getIntegralNeg_MWh());
pl_productionChartSummer.addDataItem(summerExport, "Teruggeleverde elektriciteit [MWh]", uI_Results.v_exportedEnergyColor);

// Winter
DataItem winterSelfConsumed = new DataItem();
winterSelfConsumed.setValue(dataObject.getRapidRunData().getWinterWeekElectricitySelfConsumed_MWh());
pl_productionChartWinter.addDataItem(winterSelfConsumed, "Lokaal gebruikt [MWh]", uI_Results.v_selfConsumedElectricityColor);
pl_consumptionChartWinter.addDataItem(winterSelfConsumed, "Lokaal opgewekt [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem winterImport = new DataItem();
winterImport.setValue(dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getIntegralPos_MWh());
pl_consumptionChartWinter.addDataItem(winterImport, "Externe bronnen [MWh]", uI_Results.v_importedEnergyColor);

DataItem winterExport = new DataItem();
winterExport.setValue(-dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getIntegralNeg_MWh());
pl_productionChartWinter.addDataItem(winterExport, "Teruggeleverde elektriciteit [MWh]", uI_Results.v_exportedEnergyColor);


double summerProduction_MWh = dataObject.getRapidRunData().getSummerWeekElectricityProduced_MWh();
double summerConsumption_MWh = dataObject.getRapidRunData().getSummerWeekElectricityConsumed_MWh();
double winterProduction_MWh = dataObject.getRapidRunData().getWinterWeekElectricityProduced_MWh();
double winterConsumption_MWh = dataObject.getRapidRunData().getWinterWeekElectricityConsumed_MWh();
double chartScale_MWh = max(max(summerProduction_MWh, winterProduction_MWh), max(summerConsumption_MWh, winterConsumption_MWh));
pl_productionChartSummer.setFixedScale(chartScale_MWh);
pl_productionChartWinter.setFixedScale(chartScale_MWh);
pl_consumptionChartSummer.setFixedScale(chartScale_MWh);
pl_consumptionChartWinter.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(summerProduction_MWh*1000) + " kWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(summerConsumption_MWh*1000) + " kWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(winterProduction_MWh*1000) + " kWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(winterConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(summerProduction_MWh) + " MWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(summerConsumption_MWh) + " MWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(winterProduction_MWh) + " MWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(winterConsumption_MWh) + " MWh");
} else {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToDecimal(summerProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToDecimal(summerConsumption_MWh/1000,1) + " GWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToDecimal(winterProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToDecimal(winterConsumption_MWh/1000,1) + " GWh");
} 
  }

  void f_setElectricityBalanceChartDayNight( I_EnergyData dataObject ) { 

// Day
DataItem daytimeSelfConsumed = new DataItem();
daytimeSelfConsumed.setValue(dataObject.getRapidRunData().getDaytimeElectricitySelfConsumed_MWh());
pl_productionChartDay.addDataItem(daytimeSelfConsumed, "Lokaal gebruikt [MWh]", uI_Results.v_selfConsumedElectricityColor);
pl_consumptionChartDay.addDataItem(daytimeSelfConsumed, "Lokaal opgewekt [MWh]", uI_Results.v_selfConsumedElectricityColor);



DataItem daytimeImport = new DataItem();
daytimeImport.setValue(dataObject.getRapidRunData().getDaytimeImport_MWh(OL_EnergyCarriers.ELECTRICITY));
pl_consumptionChartDay.addDataItem(daytimeImport, "Externe bronnen [MWh]", uI_Results.v_importedEnergyColor);


DataItem daytimeExport = new DataItem();
daytimeExport.setValue(dataObject.getRapidRunData().getDaytimeExport_MWh(OL_EnergyCarriers.ELECTRICITY));
pl_productionChartDay.addDataItem(daytimeExport, "Teruggeleverde elektriciteit [MWh]", uI_Results.v_exportedEnergyColor);


// Night
DataItem nighttimeSelfConsumed = new DataItem();
nighttimeSelfConsumed.setValue(dataObject.getRapidRunData().getNighttimeElectricitySelfConsumed_MWh());
pl_productionChartNight.addDataItem(nighttimeSelfConsumed, "Lokaal gebruikt [MWh]", uI_Results.v_selfConsumedElectricityColor);
pl_consumptionChartNight.addDataItem(nighttimeSelfConsumed, "Lokaal opgewekt [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem nighttimeImport = new DataItem();
nighttimeImport.setValue(dataObject.getRapidRunData().getNighttimeImport_MWh(OL_EnergyCarriers.ELECTRICITY));
pl_consumptionChartNight.addDataItem(nighttimeImport, "Externe bronnen [MWh]", uI_Results.v_importedEnergyColor);

DataItem nighttimeExport = new DataItem();
nighttimeExport.setValue(dataObject.getRapidRunData().getNighttimeExport_MWh(OL_EnergyCarriers.ELECTRICITY));
pl_productionChartNight.addDataItem(nighttimeExport, "Teruggeleverde elektriciteit [MWh]", uI_Results.v_exportedEnergyColor);



double dayProduction_MWh = dataObject.getRapidRunData().getDaytimeElectricityProduced_MWh();
double dayConsumption_MWh = dataObject.getRapidRunData().getDaytimeElectricityConsumed_MWh();
double nightProduction_MWh = dataObject.getRapidRunData().getNighttimeElectricityProduced_MWh();
double nightConsumption_MWh = dataObject.getRapidRunData().getNighttimeElectricityConsumed_MWh();
double chartScale_MWh = max(max(dayProduction_MWh, nightProduction_MWh), max(dayConsumption_MWh, nightConsumption_MWh));
pl_productionChartDay.setFixedScale(chartScale_MWh);
pl_productionChartNight.setFixedScale(chartScale_MWh);
pl_consumptionChartDay.setFixedScale(chartScale_MWh);
pl_consumptionChartNight.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToInt(dayProduction_MWh*1000) + " kWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToInt(dayConsumption_MWh*1000) + " kWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToInt(nightProduction_MWh*1000) + " kWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToInt(nightConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToInt(dayProduction_MWh) + " MWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToInt(dayConsumption_MWh) + " MWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToInt(nightProduction_MWh) + " MWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToInt(nightConsumption_MWh) + " MWh");
} else {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToDecimal(dayProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToDecimal(dayConsumption_MWh/1000,1) + " GWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToDecimal(nightProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToDecimal(nightConsumption_MWh/1000,1) + " GWh");
}
 
  }

  void f_setElectricityBalanceChartWeekdayWeekend( I_EnergyData dataObject ) { 

// Weekday
DataItem weekdaySelfConsumed = new DataItem();
weekdaySelfConsumed.setValue(dataObject.getRapidRunData().getWeekdayElectricitySelfConsumed_MWh());
pl_productionChartWeekday.addDataItem(weekdaySelfConsumed, "Lokaal gebruikt [MWh]", uI_Results.v_selfConsumedElectricityColor);
pl_consumptionChartWeekday.addDataItem(weekdaySelfConsumed, "Lokaal opgewekt [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem weekdayimeImport = new DataItem();
weekdayimeImport.setValue(dataObject.getRapidRunData().getWeekdayImport_MWh(OL_EnergyCarriers.ELECTRICITY));
pl_consumptionChartWeekday.addDataItem(weekdayimeImport, "Externe bronnen [MWh]", uI_Results.v_importedEnergyColor);

DataItem weekdayExport = new DataItem();
weekdayExport.setValue(dataObject.getRapidRunData().getWeekdayExport_MWh(OL_EnergyCarriers.ELECTRICITY));
pl_productionChartWeekday.addDataItem(weekdayExport, "Teruggeleverde elektriciteit [MWh]", uI_Results.v_exportedEnergyColor);

// Weekend
DataItem weekendSelfConsumed = new DataItem();
weekendSelfConsumed.setValue(dataObject.getRapidRunData().getWeekendElectricitySelfConsumed_MWh());
pl_productionChartWeekend.addDataItem(weekendSelfConsumed, "Lokaal gebruikt [MWh]", uI_Results.v_selfConsumedElectricityColor);
pl_consumptionChartWeekend.addDataItem(weekendSelfConsumed, "Lokaal opgewekt [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem weekendImport = new DataItem();
weekendImport.setValue(dataObject.getRapidRunData().getWeekendImport_MWh(OL_EnergyCarriers.ELECTRICITY));
pl_consumptionChartWeekend.addDataItem(weekendImport, "Externe bronnen [MWh]", uI_Results.v_importedEnergyColor);

DataItem weekendExport = new DataItem();
weekendExport.setValue(dataObject.getRapidRunData().getWeekendExport_MWh(OL_EnergyCarriers.ELECTRICITY));
pl_productionChartWeekend.addDataItem(weekendExport, "Teruggeleverde elektriciteit [MWh]", uI_Results.v_exportedEnergyColor);



double weekdayProduction_MWh = dataObject.getRapidRunData().getWeekdayElectricityProduced_MWh();
double weekdayConsumption_MWh = dataObject.getRapidRunData().getWeekdayElectricityConsumed_MWh();
double weekendProduction_MWh = dataObject.getRapidRunData().getWeekendElectricityProduced_MWh();
double weekendConsumption_MWh = dataObject.getRapidRunData().getWeekendElectricityConsumed_MWh();
double chartScale_MWh = max(max(weekdayProduction_MWh, weekendProduction_MWh), max(weekdayConsumption_MWh, weekendConsumption_MWh));
pl_productionChartWeekday.setFixedScale(chartScale_MWh);
pl_productionChartWeekend.setFixedScale(chartScale_MWh);
pl_consumptionChartWeekday.setFixedScale(chartScale_MWh);
pl_consumptionChartWeekend.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToInt(weekdayProduction_MWh*1000) + " kWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToInt(weekdayConsumption_MWh*1000) + " kWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToInt(weekendProduction_MWh*1000) + " kWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToInt(weekendConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToInt(weekdayProduction_MWh) + " MWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToInt(weekdayConsumption_MWh) + " MWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToInt(weekendProduction_MWh) + " MWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToInt(weekendConsumption_MWh) + " MWh");
} else {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToDecimal(weekdayProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToDecimal(weekdayConsumption_MWh/1000,1) + " GWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToDecimal(weekendProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToDecimal(weekendConsumption_MWh/1000,1) + " GWh");
} 
  }

  void f_resetCharts(  ) { 

pl_productionChartBalanceTotal.removeAll();
t_productionTextYear.setText("Opwek");
pl_consumptionChartBalanceTotal.removeAll();
t_consumptionTextYear.setText("Gebruik");
pl_productionChartSummer.removeAll();
t_productionTextSummer.setText("Opwek");
pl_consumptionChartSummer.removeAll();
t_consumptionTextSummer.setText("Gebruik");
pl_productionChartWinter.removeAll();
t_productionTextWinter.setText("Opwek");
pl_consumptionChartWinter.removeAll();
t_consumptionTextWinter.setText("Gebruik");
pl_productionChartDay.removeAll();
t_productionTextDay.setText("Opwek");
pl_consumptionChartDay.removeAll();
t_consumptionTextDay.setText("Gebruik");
pl_productionChartNight.removeAll();
t_productionTextNight.setText("Opwek");
pl_consumptionChartNight.removeAll();
t_consumptionTextNight.setText("Gebruik");
pl_productionChartWeekday.removeAll();
t_productionTextWeekday.setText("Opwek");
pl_consumptionChartWeekday.removeAll();
t_consumptionTextWeekday.setText("Gebruik");
pl_productionChartWeekend.removeAll();
t_productionTextWeekend.setText("Opwek");
pl_consumptionChartWeekend.removeAll();
t_consumptionTextWeekend.setText("Gebruik"); 
  }

  void f_setEnergyBalanceChartTotal( I_EnergyData dataObject ) { 

// SelfConsumption
double totalEnergySelfConsumed = dataObject.getRapidRunData().getTotalEnergySelfConsumed_MWh();
double totalPrimaryHeatPumpEnergyProductionSelfConsumed = dataObject.getRapidRunData().getTotalPrimaryEnergyProductionHeatpumps_MWh();

double remainingEnergySelfConsumed;
//If there is no heat export: divide total energy self consumed in to self consumed energy and self consumed energy heatpump heat
if((dataObject.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HEAT) && dataObject.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.HEAT) > uI_Results.p_cutOff_MWh) || totalPrimaryHeatPumpEnergyProductionSelfConsumed == 0){
	remainingEnergySelfConsumed = totalEnergySelfConsumed;
}
else{
	remainingEnergySelfConsumed = max(0, totalEnergySelfConsumed - totalPrimaryHeatPumpEnergyProductionSelfConsumed);
	
	DataItem totalSelfConsumedHeatpumpHeat = new DataItem();
	totalSelfConsumedHeatpumpHeat.setValue(totalPrimaryHeatPumpEnergyProductionSelfConsumed);
	pl_productionChartBalanceTotal.addDataItem(totalSelfConsumedHeatpumpHeat, "Omgevingswarmte benut door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
	pl_consumptionChartBalanceTotal.addDataItem(totalSelfConsumedHeatpumpHeat, "Omgevingswarmte gewonnen door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
}
if(remainingEnergySelfConsumed < uI_Results.p_cutOff_MWh){
	remainingEnergySelfConsumed = 0;
}

//Add selfconsumed energy
DataItem totalSelfConsumedRemainingEnergy = new DataItem();
totalSelfConsumedRemainingEnergy.setValue(remainingEnergySelfConsumed);
pl_productionChartBalanceTotal.addDataItem(totalSelfConsumedRemainingEnergy, "Lokaal gebruikte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);
pl_consumptionChartBalanceTotal.addDataItem(totalSelfConsumedRemainingEnergy, "Lokaal opgewekte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);

//Export/Import
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeConsumptionEnergyCarriers) {
		// Consumption
	if (dataObject.getRapidRunData().getTotalImport_MWh(EC) > uI_Results.p_cutOff_MWh) {
		DataItem totalImport = new DataItem();
		totalImport.setValue(dataObject.getRapidRunData().getTotalImport_MWh(EC));
		pl_consumptionChartBalanceTotal.addDataItem(totalImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_consumptionColors.get(EC));
	}
}
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeProductionEnergyCarriers) {
	// Production
	if (dataObject.getRapidRunData().getTotalExport_MWh(EC) > uI_Results.p_cutOff_MWh) {
		DataItem totalExport = new DataItem();
		totalExport.setValue(dataObject.getRapidRunData().getTotalExport_MWh(EC));
		pl_productionChartBalanceTotal.addDataItem(totalExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}
}

double production_MWh = dataObject.getRapidRunData().getTotalEnergyProduced_MWh();
double consumption_MWh = dataObject.getRapidRunData().getTotalEnergyConsumed_MWh();
double chartScale_MWh = max(production_MWh, consumption_MWh);
pl_consumptionChartBalanceTotal.setFixedScale(chartScale_MWh);
pl_productionChartBalanceTotal.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToInt(production_MWh*1000) + " kWh");
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToInt(consumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToInt(production_MWh) + " MWh");
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToInt(consumption_MWh) + " MWh");
} else {
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToDecimal(production_MWh/1000, 1) + " GWh");
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToDecimal(consumption_MWh/1000,1) + " GWh");
} 
  }

  void f_setEnergyBalanceChartSummerWinter( I_EnergyData dataObject ) { 

// Summer SelfConsumption
double totalEnergySelfConsumed_summer = dataObject.getRapidRunData().getSummerWeekEnergySelfConsumed_MWh();
double totalPrimaryHeatPumpEnergyProductionSelfConsumed_summer = dataObject.getRapidRunData().getSummerWeekPrimaryEnergyProductionHeatpumps_MWh();

double remainingEnergySelfConsumed_summer;
if((dataObject.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HEAT) && dataObject.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.HEAT) > uI_Results.p_cutOff_MWh) || totalPrimaryHeatPumpEnergyProductionSelfConsumed_summer == 0){
	remainingEnergySelfConsumed_summer = totalEnergySelfConsumed_summer;
}
else{
	remainingEnergySelfConsumed_summer = max(0, totalEnergySelfConsumed_summer - totalPrimaryHeatPumpEnergyProductionSelfConsumed_summer);
	
	DataItem summerSelfConsumedHeatpumpHeat = new DataItem();
	summerSelfConsumedHeatpumpHeat.setValue(totalPrimaryHeatPumpEnergyProductionSelfConsumed_summer);
	pl_productionChartSummer.addDataItem(summerSelfConsumedHeatpumpHeat, "Omgevingswarmte benut door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
	pl_consumptionChartSummer.addDataItem(summerSelfConsumedHeatpumpHeat, "Omgevingswarmte gewonnen door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
}
if(remainingEnergySelfConsumed_summer < uI_Results.p_cutOff_MWh){
	remainingEnergySelfConsumed_summer = 0;
}

DataItem summerSelfConsumedRemainingEnergy = new DataItem();
summerSelfConsumedRemainingEnergy.setValue(remainingEnergySelfConsumed_summer);
pl_productionChartSummer.addDataItem(summerSelfConsumedRemainingEnergy, "Lokaal gebruikte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);
pl_consumptionChartSummer.addDataItem(summerSelfConsumedRemainingEnergy, "Lokaal opgewekte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);



// Winter SelfConsumption
double totalEnergySelfConsumed_winter = dataObject.getRapidRunData().getWinterWeekEnergySelfConsumed_MWh();
double totalPrimaryHeatPumpEnergyProductionSelfConsumed_winter = dataObject.getRapidRunData().getWinterWeekPrimaryEnergyProductionHeatpumps_MWh();

double remainingEnergySelfConsumed_winter;
if((dataObject.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HEAT) && dataObject.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.HEAT) > uI_Results.p_cutOff_MWh) || totalPrimaryHeatPumpEnergyProductionSelfConsumed_winter == 0){
	remainingEnergySelfConsumed_winter = totalEnergySelfConsumed_winter;
}
else{
	remainingEnergySelfConsumed_winter = max(0, totalEnergySelfConsumed_winter - totalPrimaryHeatPumpEnergyProductionSelfConsumed_winter);
	
	DataItem winterSelfConsumedHeatpumpHeat = new DataItem();
	winterSelfConsumedHeatpumpHeat.setValue(totalPrimaryHeatPumpEnergyProductionSelfConsumed_winter);
	pl_productionChartWinter.addDataItem(winterSelfConsumedHeatpumpHeat, "Omgevingswarmte benut door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
	pl_consumptionChartWinter.addDataItem(winterSelfConsumedHeatpumpHeat, "Omgevingswarmte gewonnen door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
}
if(remainingEnergySelfConsumed_winter < uI_Results.p_cutOff_MWh){
	remainingEnergySelfConsumed_winter = 0;
}

DataItem winterSelfConsumedRemainingEnergy = new DataItem();
winterSelfConsumedRemainingEnergy.setValue(remainingEnergySelfConsumed_winter);

pl_productionChartWinter.addDataItem(winterSelfConsumedRemainingEnergy, "Lokaal gebruikte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);
pl_consumptionChartWinter.addDataItem(winterSelfConsumedRemainingEnergy, "Lokaal opgewekte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);


//Export and import
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeConsumptionEnergyCarriers) {
	// Summer Consumption
	if (dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem summerImport = new DataItem();
		summerImport.setValue(dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh());
		pl_consumptionChartSummer.addDataItem(summerImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
	// Winter Consumption
	if (dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem winterImport = new DataItem();
		winterImport.setValue(dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh());
		pl_consumptionChartWinter.addDataItem(winterImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
}
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeProductionEnergyCarriers) {
	// Summer Production
	if (-dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralNeg_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem summerExport = new DataItem();
		summerExport.setValue(-dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralNeg_MWh());
		pl_productionChartSummer.addDataItem(summerExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}
	// Winter Production
	if (-dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(EC).getIntegralNeg_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem winterExport = new DataItem();
		winterExport.setValue(-dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(EC).getIntegralNeg_MWh());
		pl_productionChartWinter.addDataItem(winterExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}

}

double summerConsumption_MWh = dataObject.getRapidRunData().getSummerWeekEnergyConsumed_MWh();
double summerProduction_MWh = dataObject.getRapidRunData().getSummerWeekEnergyProduced_MWh();
double winterConsumption_MWh = dataObject.getRapidRunData().getWinterWeekEnergyConsumed_MWh();
double winterProduction_MWh = dataObject.getRapidRunData().getWinterWeekEnergyProduced_MWh();
double chartScale_MWh = max(max(summerProduction_MWh, winterProduction_MWh), max(summerConsumption_MWh, winterConsumption_MWh));
pl_productionChartSummer.setFixedScale(chartScale_MWh);
pl_productionChartWinter.setFixedScale(chartScale_MWh);
pl_consumptionChartSummer.setFixedScale(chartScale_MWh);
pl_consumptionChartWinter.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(summerProduction_MWh*1000) + " kWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(summerConsumption_MWh*1000) + " kWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(winterProduction_MWh*1000) + " kWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(winterConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(summerProduction_MWh) + " MWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(summerConsumption_MWh) + " MWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(winterProduction_MWh) + " MWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(winterConsumption_MWh) + " MWh");
} else {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToDecimal(summerProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToDecimal(summerConsumption_MWh/1000,1) + " GWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToDecimal(winterProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToDecimal(winterConsumption_MWh/1000,1) + " GWh");
} 
  }

  void f_setEnergyBalanceChartWeekdayWeekend( I_EnergyData dataObject ) { 

// Weekday SelfConsumption
double weekdayEnergySelfConsumed = dataObject.getRapidRunData().getWeekdayEnergySelfConsumed_MWh();
double weekdayPrimaryHeatPumpEnergyProductionSelfConsumed = dataObject.getRapidRunData().getWeekdayPrimaryEnergyProductionHeatpumps_MWh();

double remainingWeekdayEnergySelfConsumed;
//If there is no heat export: divide total energy self consumed in to self consumed energy and self consumed energy heatpump heat
if((dataObject.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HEAT) && dataObject.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.HEAT) > uI_Results.p_cutOff_MWh) || weekdayPrimaryHeatPumpEnergyProductionSelfConsumed == 0){
	remainingWeekdayEnergySelfConsumed = weekdayEnergySelfConsumed;
}
else{
	remainingWeekdayEnergySelfConsumed = max(0, weekdayEnergySelfConsumed - weekdayPrimaryHeatPumpEnergyProductionSelfConsumed);
	
	DataItem weekdaySelfConsumedHeatpumpHeat = new DataItem();
	weekdaySelfConsumedHeatpumpHeat.setValue(weekdayPrimaryHeatPumpEnergyProductionSelfConsumed);
	pl_productionChartWeekday.addDataItem(weekdaySelfConsumedHeatpumpHeat, "Omgevingswarmte benut door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
	pl_consumptionChartWeekday.addDataItem(weekdaySelfConsumedHeatpumpHeat, "Omgevingswarmte gewonnen door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
}
if(remainingWeekdayEnergySelfConsumed < uI_Results.p_cutOff_MWh){
	remainingWeekdayEnergySelfConsumed = 0;
}

//Add selfconsumed energy
DataItem weekdaySelfConsumedRemainingEnergy = new DataItem();
weekdaySelfConsumedRemainingEnergy.setValue(remainingWeekdayEnergySelfConsumed);
pl_productionChartWeekday.addDataItem(weekdaySelfConsumedRemainingEnergy, "Lokaal gebruikte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);
pl_consumptionChartWeekday.addDataItem(weekdaySelfConsumedRemainingEnergy, "Lokaal opgewekte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);

// Weekend SelfConsumption
double weekendEnergySelfConsumed = dataObject.getRapidRunData().getWeekendEnergySelfConsumed_MWh();
double weekendPrimaryHeatPumpEnergyProductionSelfConsumed = dataObject.getRapidRunData().getWeekendPrimaryEnergyProductionHeatpumps_MWh();

double remainingWeekendEnergySelfConsumed;
//If there is no heat export: divide total energy self consumed in to self consumed energy and self consumed energy heatpump heat
if((dataObject.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HEAT) && dataObject.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.HEAT) > uI_Results.p_cutOff_MWh) || weekendPrimaryHeatPumpEnergyProductionSelfConsumed == 0){
	remainingWeekendEnergySelfConsumed = weekendEnergySelfConsumed;
}
else{
	remainingWeekendEnergySelfConsumed = max(0, weekendEnergySelfConsumed - weekendPrimaryHeatPumpEnergyProductionSelfConsumed);
	
	DataItem weekendSelfConsumedHeatpumpHeat = new DataItem();
	weekendSelfConsumedHeatpumpHeat.setValue(weekendPrimaryHeatPumpEnergyProductionSelfConsumed);
	pl_productionChartWeekend.addDataItem(weekendSelfConsumedHeatpumpHeat, "Omgevingswarmte benut door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
	pl_consumptionChartWeekend.addDataItem(weekendSelfConsumedHeatpumpHeat, "Omgevingswarmte gewonnen door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
}
if(remainingWeekendEnergySelfConsumed < uI_Results.p_cutOff_MWh){
	remainingWeekendEnergySelfConsumed = 0;
}

//Add selfconsumed energy
DataItem weekendSelfConsumedRemainingEnergy = new DataItem();
weekendSelfConsumedRemainingEnergy.setValue(remainingWeekendEnergySelfConsumed);
pl_productionChartWeekend.addDataItem(weekendSelfConsumedRemainingEnergy, "Lokaal gebruikte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);
pl_consumptionChartWeekend.addDataItem(weekendSelfConsumedRemainingEnergy, "Lokaal opgewekte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);


for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeConsumptionEnergyCarriers) {
	// Weekday Consumption
	if (dataObject.getRapidRunData().getWeekdayImport_MWh(EC) > uI_Results.p_cutOff_MWh) {	
		DataItem weekdayImport = new DataItem();
		weekdayImport.setValue(dataObject.getRapidRunData().getWeekdayImport_MWh(EC));
		pl_consumptionChartWeekday.addDataItem(weekdayImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
	// Weekend Consumption
	if (dataObject.getRapidRunData().getWeekendImport_MWh(EC) > uI_Results.p_cutOff_MWh) {	
		DataItem weekendImport = new DataItem();
		weekendImport.setValue(dataObject.getRapidRunData().getWeekendImport_MWh(EC));
		pl_consumptionChartWeekend.addDataItem(weekendImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
}
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeProductionEnergyCarriers) {
	// Weekday Production
	if (dataObject.getRapidRunData().getWeekdayExport_MWh(EC) > uI_Results.p_cutOff_MWh) {	
		DataItem weekdayExport = new DataItem();
		weekdayExport.setValue(dataObject.getRapidRunData().getWeekdayExport_MWh(EC));
		pl_productionChartWeekday.addDataItem(weekdayExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}
	// Weekend Production
	if (dataObject.getRapidRunData().getWeekendExport_MWh(EC) > uI_Results.p_cutOff_MWh) {	
		DataItem weekendExport = new DataItem();
		weekendExport.setValue(dataObject.getRapidRunData().getWeekendExport_MWh(EC));
		pl_productionChartWeekend.addDataItem(weekendExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}
}

double weekdayProduction_MWh = dataObject.getRapidRunData().getWeekdayEnergyProduced_MWh();
double weekdayConsumption_MWh = dataObject.getRapidRunData().getWeekdayEnergyConsumed_MWh();
double weekendProduction_MWh = dataObject.getRapidRunData().getWeekendEnergyProduced_MWh();
double weekendConsumption_MWh = dataObject.getRapidRunData().getWeekendEnergyConsumed_MWh();
double chartScale_MWh = max(max(weekdayProduction_MWh, weekendProduction_MWh), max(weekdayConsumption_MWh, weekendConsumption_MWh));
pl_productionChartWeekday.setFixedScale(chartScale_MWh);
pl_productionChartWeekend.setFixedScale(chartScale_MWh);
pl_consumptionChartWeekday.setFixedScale(chartScale_MWh);
pl_consumptionChartWeekend.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToInt(weekdayProduction_MWh*1000) + " kWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToInt(weekdayConsumption_MWh*1000) + " kWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToInt(weekendProduction_MWh*1000) + " kWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToInt(weekendConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToInt(weekdayProduction_MWh) + " MWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToInt(weekdayConsumption_MWh) + " MWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToInt(weekendProduction_MWh) + " MWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToInt(weekendConsumption_MWh) + " MWh");
} else {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToDecimal(weekdayProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToDecimal(weekdayConsumption_MWh/1000,1) + " GWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToDecimal(weekendProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToDecimal(weekendConsumption_MWh/1000,1) + " GWh");
} 
  }

  void f_setEnergyBalanceChartDayNight( I_EnergyData dataObject ) { 

// Daytime SelfConsumption
double daytimeEnergySelfConsumed = dataObject.getRapidRunData().getDaytimeEnergySelfConsumed_MWh();
double daytimePrimaryHeatPumpEnergyProductionSelfConsumed = dataObject.getRapidRunData().getDaytimePrimaryEnergyProductionHeatpumps_MWh();

double remainingDaytimeEnergySelfConsumed;
//If there is no heat export: divide total energy self consumed in to self consumed energy and self consumed energy heatpump heat
if((dataObject.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HEAT) && dataObject.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.HEAT) > uI_Results.p_cutOff_MWh) || daytimePrimaryHeatPumpEnergyProductionSelfConsumed == 0){
	remainingDaytimeEnergySelfConsumed = daytimeEnergySelfConsumed;
}
else{
	remainingDaytimeEnergySelfConsumed = max(0, daytimeEnergySelfConsumed - daytimePrimaryHeatPumpEnergyProductionSelfConsumed);
	
	DataItem daytimeSelfConsumedHeatpumpHeat = new DataItem();
	daytimeSelfConsumedHeatpumpHeat.setValue(daytimePrimaryHeatPumpEnergyProductionSelfConsumed);
	pl_productionChartDay.addDataItem(daytimeSelfConsumedHeatpumpHeat, "Omgevingswarmte benut door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
	pl_consumptionChartDay.addDataItem(daytimeSelfConsumedHeatpumpHeat, "Omgevingswarmte gewonnen door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
}
if(remainingDaytimeEnergySelfConsumed < uI_Results.p_cutOff_MWh){
	remainingDaytimeEnergySelfConsumed = 0;
}

//Add Daytime selfconsumed energy
DataItem daytimeSelfConsumedRemainingEnergy = new DataItem();
daytimeSelfConsumedRemainingEnergy.setValue(remainingDaytimeEnergySelfConsumed);
pl_productionChartDay.addDataItem(daytimeSelfConsumedRemainingEnergy, "Lokaal gebruikte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);
pl_consumptionChartDay.addDataItem(daytimeSelfConsumedRemainingEnergy, "Lokaal opgewekte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);


// Nighttime SelfConsumption
double nighttimeEnergySelfConsumed = dataObject.getRapidRunData().getNighttimeEnergySelfConsumed_MWh();
double nighttimePrimaryHeatPumpEnergyProductionSelfConsumed = dataObject.getRapidRunData().getNighttimePrimaryEnergyProductionHeatpumps_MWh();

double remainingNighttimeEnergySelfConsumed;
//If there is no heat export: divide total energy self consumed in to self consumed energy and self consumed energy heatpump heat
if((dataObject.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HEAT) && dataObject.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.HEAT) > uI_Results.p_cutOff_MWh) || nighttimePrimaryHeatPumpEnergyProductionSelfConsumed == 0){
	remainingNighttimeEnergySelfConsumed = nighttimeEnergySelfConsumed;
}
else{
	remainingNighttimeEnergySelfConsumed = max(0, nighttimeEnergySelfConsumed - nighttimePrimaryHeatPumpEnergyProductionSelfConsumed);
	
	DataItem nighttimeSelfConsumedHeatpumpHeat = new DataItem();
	nighttimeSelfConsumedHeatpumpHeat.setValue(nighttimePrimaryHeatPumpEnergyProductionSelfConsumed);
	pl_productionChartNight.addDataItem(nighttimeSelfConsumedHeatpumpHeat, "Omgevingswarmte benut door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
	pl_consumptionChartNight.addDataItem(nighttimeSelfConsumedHeatpumpHeat, "Omgevingswarmte gewonnen door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
}
if(remainingNighttimeEnergySelfConsumed < uI_Results.p_cutOff_MWh){
	remainingNighttimeEnergySelfConsumed = 0;
}

//Add selfconsumed energy
DataItem nighttimeSelfConsumedRemainingEnergy = new DataItem();
nighttimeSelfConsumedRemainingEnergy.setValue(remainingNighttimeEnergySelfConsumed);
pl_productionChartNight.addDataItem(nighttimeSelfConsumedRemainingEnergy, "Lokaal gebruikte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);
pl_consumptionChartNight.addDataItem(nighttimeSelfConsumedRemainingEnergy, "Lokaal opgewekte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);



for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeConsumptionEnergyCarriers) {
	// Daytime Consumption
	if (dataObject.getRapidRunData().getDaytimeImport_MWh(EC) > uI_Results.p_cutOff_MWh) {
		DataItem daytimeImport = new DataItem();
		daytimeImport.setValue(dataObject.getRapidRunData().getDaytimeImport_MWh(EC));
		pl_consumptionChartDay.addDataItem(daytimeImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
	// Nighttime Consumption
	if (dataObject.getRapidRunData().getNighttimeImport_MWh(EC) > uI_Results.p_cutOff_MWh) {
		DataItem nighttimeImport = new DataItem();
		nighttimeImport.setValue(dataObject.getRapidRunData().getNighttimeImport_MWh(EC));
		pl_consumptionChartNight.addDataItem(nighttimeImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}	
}
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeProductionEnergyCarriers) {
	// Daytime Production
	if (dataObject.getRapidRunData().getDaytimeExport_MWh(EC) > uI_Results.p_cutOff_MWh) {	
		DataItem daytimeExport = new DataItem();
		daytimeExport.setValue(dataObject.getRapidRunData().getDaytimeExport_MWh(EC));
		pl_productionChartDay.addDataItem(daytimeExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}	
	// Nighttime Production
	if (dataObject.getRapidRunData().getNighttimeExport_MWh(EC) > uI_Results.p_cutOff_MWh) {
		DataItem nighttimeExport = new DataItem();
		nighttimeExport.setValue(dataObject.getRapidRunData().getNighttimeExport_MWh(EC));
		pl_productionChartNight.addDataItem(nighttimeExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}
}

double dayProduction_MWh = dataObject.getRapidRunData().getDaytimeEnergyProduced_MWh();
double dayConsumption_MWh = dataObject.getRapidRunData().getDaytimeEnergyConsumed_MWh();
double nightProduction_MWh = dataObject.getRapidRunData().getNighttimeEnergyProduced_MWh();
double nightConsumption_MWh = dataObject.getRapidRunData().getNighttimeEnergyConsumed_MWh();
double chartScale_MWh = max(max(dayProduction_MWh, nightProduction_MWh), max(dayConsumption_MWh, nightConsumption_MWh));
pl_productionChartDay.setFixedScale(chartScale_MWh);
pl_productionChartNight.setFixedScale(chartScale_MWh);
pl_consumptionChartDay.setFixedScale(chartScale_MWh);
pl_consumptionChartNight.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToInt(dayProduction_MWh*1000) + " kWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToInt(dayConsumption_MWh*1000) + " kWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToInt(nightProduction_MWh*1000) + " kWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToInt(nightConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToInt(dayProduction_MWh) + " MWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToInt(dayConsumption_MWh) + " MWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToInt(nightProduction_MWh) + " MWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToInt(nightConsumption_MWh) + " MWh");
} else {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToDecimal(dayProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToDecimal(dayConsumption_MWh/1000,1) + " GWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToDecimal(nightProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToDecimal(nightConsumption_MWh/1000,1) + " GWh");
}
 
  }

  void f_setVisiblity(  ) { 

gr_Total.setVisible(false);
gr_SummerWinter.setVisible(false);
gr_DayNight.setVisible(false);
gr_WeekdayWeekend.setVisible(false);
gr_monthlyTotals.setVisible(false);

if (radio_period.getValue() == 0) {
	gr_Total.setVisible(true);
} else if (radio_period.getValue() == 1) {
	gr_SummerWinter.setVisible(true);
} else if (radio_period.getValue() == 2) {
	gr_DayNight.setVisible(true);
} else if (radio_period.getValue() == 3) {
	gr_WeekdayWeekend.setVisible(true);
} 
  }

  void f_setTrafoBalanceChartTotal( GridNode GN ) { 

DataItem annualSelfConsumed = new DataItem();
annualSelfConsumed.setValue(GN.v_totalImport_MWh - GN.v_annualExcessImport_MWh);
pl_consumptionChartBalanceTotal.addDataItem(annualSelfConsumed, "Geleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem annualSelfProduced = new DataItem();
annualSelfProduced.setValue(GN.v_totalExport_MWh - GN.v_annualExcessExport_MWh);
pl_productionChartBalanceTotal.addDataItem(annualSelfProduced, "Teruggeleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem annualImport = new DataItem();
annualImport.setValue(GN.v_annualExcessExport_MWh);
pl_productionChartBalanceTotal.addDataItem(annualImport, "Over Capaciteit [MWh]", uI_Results.v_importedEnergyColor);

DataItem annualExport = new DataItem();
annualExport.setValue(GN.v_annualExcessImport_MWh);
pl_consumptionChartBalanceTotal.addDataItem(annualExport, "Over Capaciteit [MWh]", uI_Results.v_exportedEnergyColor);

double chartScale_MWh = max(GN.v_totalImport_MWh, GN.v_totalExport_MWh);
pl_consumptionChartBalanceTotal.setFixedScale(chartScale_MWh);
pl_productionChartBalanceTotal.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToInt(GN.v_totalExport_MWh*1000) + " kWh");
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToInt(GN.v_totalImport_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToInt(GN.v_totalExport_MWh) + " MWh");
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToInt(GN.v_totalImport_MWh) + " MWh");
} else {
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToDecimal(GN.v_totalExport_MWh/1000, 1) + " GWh");
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToDecimal(GN.v_totalImport_MWh/1000, 1) + " GWh");
}
 
  }

  void f_setTrafoBalanceChartSummerWinter( GridNode GN ) { 

double summerWeekImport_MWh = GN.v_summerWeekImport_MWh;
double summerWeekExport_MWh = GN.v_summerWeekExport_MWh;;
double winterWeekImport_MWh = GN.v_winterWeekImport_MWh;
double winterWeekExport_MWh = GN.v_winterWeekExport_MWh;;

//// Summer
// Consumption
DataItem summerWeekSelfConsumed = new DataItem();
summerWeekSelfConsumed.setValue(summerWeekImport_MWh - GN.v_summerWeekExcessImport_MWh);
pl_consumptionChartSummer.addDataItem(summerWeekSelfConsumed, "Geleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem summerWeekExport = new DataItem();
summerWeekExport.setValue(GN.v_summerWeekExcessImport_MWh);
pl_consumptionChartSummer.addDataItem(summerWeekExport, "Over Capaciteit [MWh]", uI_Results.v_exportedEnergyColor);

// Production
DataItem summerWeekSelfProduced = new DataItem();
summerWeekSelfProduced.setValue(summerWeekExport_MWh - GN.v_summerWeekExcessExport_MWh);
pl_productionChartSummer.addDataItem(summerWeekSelfProduced, "Teruggeleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem summerWeekImport = new DataItem();
summerWeekImport.setValue(GN.v_summerWeekExcessExport_MWh);
pl_productionChartSummer.addDataItem(summerWeekImport, "Over Capaciteit [MWh]", uI_Results.v_importedEnergyColor);


//// Winter
// Consumption
DataItem winterWeekSelfConsumed = new DataItem();
winterWeekSelfConsumed.setValue(winterWeekImport_MWh - GN.v_winterWeekExcessImport_MWh);
pl_consumptionChartWinter.addDataItem(winterWeekSelfConsumed, "Geleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem winterWeekExport = new DataItem();
winterWeekExport.setValue(GN.v_winterWeekExcessImport_MWh);
pl_consumptionChartWinter.addDataItem(winterWeekExport, "Over Capaciteit [MWh]", uI_Results.v_exportedEnergyColor);

// Production
DataItem winterWeekSelfProduced = new DataItem();
winterWeekSelfProduced.setValue(winterWeekExport_MWh - GN.v_winterWeekExcessExport_MWh);
pl_productionChartWinter.addDataItem(winterWeekSelfProduced, "Teruggeleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem winterWeekImport = new DataItem();
winterWeekImport.setValue(GN.v_winterWeekExcessExport_MWh);
pl_productionChartWinter.addDataItem(winterWeekImport, "Over Capaciteit [MWh]", uI_Results.v_importedEnergyColor);


//// Scale & Text
double chartScale_MWh = max( max(summerWeekImport_MWh, summerWeekExport_MWh), max(winterWeekImport_MWh, winterWeekExport_MWh) );
pl_consumptionChartSummer.setFixedScale(chartScale_MWh);
pl_productionChartSummer.setFixedScale(chartScale_MWh);
pl_consumptionChartWinter.setFixedScale(chartScale_MWh);
pl_productionChartWinter.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(summerWeekExport_MWh*1000) + " kWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(summerWeekImport_MWh*1000) + " kWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(winterWeekExport_MWh*1000) + " kWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(winterWeekImport_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(summerWeekExport_MWh) + " MWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(summerWeekImport_MWh) + " MWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(winterWeekExport_MWh) + " MWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(winterWeekImport_MWh) + " MWh");
} else {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToDecimal(summerWeekExport_MWh/1000, 1) + " GWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToDecimal(summerWeekImport_MWh/1000,1) + " GWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToDecimal(winterWeekExport_MWh/1000, 1) + " GWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToDecimal(winterWeekImport_MWh/1000,1) + " GWh");
} 
  }

  void f_setTrafoBalanceChartDayNight( GridNode GN ) { 

double daytimeImport_MWh = GN.v_daytimeImport_MWh;
double daytimeExport_MWh = GN.v_daytimeExport_MWh;
double nighttimeImport_MWh = GN.v_nighttimeImport_MWh;
double nighttimeExport_MWh = GN.v_nighttimeExport_MWh;

//// Day
// Consumption
DataItem daytimeSelfConsumed = new DataItem();
daytimeSelfConsumed.setValue(daytimeImport_MWh - GN.v_daytimeExcessImport_MWh);
pl_consumptionChartDay.addDataItem(daytimeSelfConsumed, "Geleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem daytimeExport = new DataItem();
daytimeExport.setValue(GN.v_daytimeExcessImport_MWh);
pl_consumptionChartDay.addDataItem(daytimeExport, "Over Capaciteit [MWh]", uI_Results.v_exportedEnergyColor);

// Production
DataItem daytimeSelfProduced = new DataItem();
daytimeSelfProduced.setValue(daytimeExport_MWh - GN.v_daytimeExcessExport_MWh);
pl_productionChartDay.addDataItem(daytimeSelfProduced, "Teruggeleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem daytimeImport = new DataItem();
daytimeImport.setValue(GN.v_daytimeExcessExport_MWh);
pl_productionChartDay.addDataItem(daytimeImport, "Over Capaciteit [MWh]", uI_Results.v_importedEnergyColor);


//// Night
// Consumption
DataItem nighttimeSelfConsumed = new DataItem();
nighttimeSelfConsumed.setValue(nighttimeImport_MWh - GN.v_nighttimeExcessImport_MWh);
pl_consumptionChartNight.addDataItem(nighttimeSelfConsumed, "Geleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem nighttimeExport = new DataItem();
nighttimeExport.setValue(GN.v_nighttimeExcessImport_MWh);
pl_consumptionChartNight.addDataItem(nighttimeExport, "Over Capaciteit [MWh]", uI_Results.v_exportedEnergyColor);

// Production
DataItem nighttimeSelfProduced = new DataItem();
nighttimeSelfProduced.setValue(nighttimeExport_MWh - GN.v_nighttimeExcessExport_MWh);
pl_productionChartNight.addDataItem(nighttimeSelfProduced, "Teruggeleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem nighttimeImport = new DataItem();
nighttimeImport.setValue(GN.v_nighttimeExcessExport_MWh);
pl_productionChartNight.addDataItem(nighttimeImport, "Over Capaciteit [MWh]", uI_Results.v_importedEnergyColor);


//// Scale & Text
double chartScale_MWh = max( max(daytimeImport_MWh, daytimeExport_MWh), max(nighttimeImport_MWh, nighttimeExport_MWh) );
pl_consumptionChartDay.setFixedScale(chartScale_MWh);
pl_productionChartDay.setFixedScale(chartScale_MWh);
pl_consumptionChartNight.setFixedScale(chartScale_MWh);
pl_productionChartNight.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToInt(daytimeExport_MWh*1000) + " kWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToInt(daytimeImport_MWh*1000) + " kWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToInt(nighttimeExport_MWh*1000) + " kWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToInt(nighttimeImport_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToInt(daytimeExport_MWh) + " MWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToInt(daytimeImport_MWh) + " MWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToInt(nighttimeExport_MWh) + " MWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToInt(nighttimeImport_MWh) + " MWh");
} else {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToDecimal(daytimeExport_MWh/1000, 1) + " GWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToDecimal(daytimeImport_MWh/1000,1) + " GWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToDecimal(nighttimeExport_MWh/1000, 1) + " GWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToDecimal(nighttimeImport_MWh/1000,1) + " GWh");
} 
  }

  void f_setTrafoBalanceChartWeekdayWeekend( GridNode GN ) { 

double weekdayImport_MWh = GN.v_weekdayImport_MWh;
double weekdayExport_MWh = GN.v_weekdayExport_MWh;
double weekendImport_MWh = GN.v_weekendImport_MWh;
double weekendExport_MWh = GN.v_weekendExport_MWh;

//// Weekday
// Consumption
DataItem weekdaySelfConsumed = new DataItem();
weekdaySelfConsumed.setValue(weekdayImport_MWh - GN.v_weekdayExcessImport_MWh);
pl_consumptionChartWeekday.addDataItem(weekdaySelfConsumed, "Geleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem weekdayExport = new DataItem();
weekdayExport.setValue(GN.v_weekdayExcessImport_MWh);
pl_consumptionChartWeekday.addDataItem(weekdayExport, "Over Capaciteit [MWh]", uI_Results.v_exportedEnergyColor);

// Production
DataItem weekdaySelfProduced = new DataItem();
weekdaySelfProduced.setValue(weekdayExport_MWh - GN.v_weekdayExcessExport_MWh);
pl_productionChartWeekday.addDataItem(weekdaySelfProduced, "Teruggeleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem weekdayImport = new DataItem();
weekdayImport.setValue(GN.v_weekdayExcessExport_MWh);
pl_productionChartWeekday.addDataItem(weekdayImport, "Over Capaciteit [MWh]", uI_Results.v_importedEnergyColor);


//// Weekend
// Consumption
DataItem weekendSelfConsumed = new DataItem();
weekendSelfConsumed.setValue(weekendImport_MWh - GN.v_weekendExcessImport_MWh);
pl_consumptionChartWeekend.addDataItem(weekendSelfConsumed, "Geleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem weekendExport = new DataItem();
weekendExport.setValue(GN.v_weekendExcessImport_MWh);
pl_consumptionChartWeekend.addDataItem(weekendExport, "Over Capaciteit [MWh]", uI_Results.v_exportedEnergyColor);

// Production
DataItem weekendSelfProduced = new DataItem();
weekendSelfProduced.setValue(weekendExport_MWh - GN.v_weekendExcessExport_MWh);
pl_productionChartWeekend.addDataItem(weekendSelfProduced, "Teruggeleverde Stroom [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem weekendImport = new DataItem();
weekendImport.setValue(GN.v_weekendExcessExport_MWh);
pl_productionChartWeekend.addDataItem(weekendImport, "Over Capaciteit [MWh]", uI_Results.v_importedEnergyColor);


//// Scale & Text
double chartScale_MWh = max( max(weekdayImport_MWh, weekdayExport_MWh), max(weekendImport_MWh, weekendExport_MWh) );
pl_consumptionChartWeekday.setFixedScale(chartScale_MWh);
pl_productionChartWeekday.setFixedScale(chartScale_MWh);
pl_consumptionChartWeekend.setFixedScale(chartScale_MWh);
pl_productionChartWeekend.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToInt(weekdayExport_MWh*1000) + " kWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToInt(weekdayImport_MWh*1000) + " kWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToInt(weekendExport_MWh*1000) + " kWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToInt(weekendImport_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToInt(weekdayExport_MWh) + " MWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToInt(weekdayImport_MWh) + " MWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToInt(weekendExport_MWh) + " MWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToInt(weekendImport_MWh) + " MWh");
} else {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToDecimal(weekdayExport_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToDecimal(weekdayImport_MWh/1000,1) + " GWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToDecimal(weekendExport_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToDecimal(weekendImport_MWh/1000,1) + " GWh");
} 
  }

  void f_setElectricityBalanceChartPeakFeedinWeek( I_EnergyData dataObject ) { 

// Summer
DataItem summerSelfConsumed = new DataItem();
summerSelfConsumed.setValue(dataObject.getRapidRunData().getSummerWeekElectricitySelfConsumed_MWh());
pl_productionChartSummer.addDataItem(summerSelfConsumed, "Lokaal gebruikt [MWh]", uI_Results.v_selfConsumedElectricityColor);
pl_consumptionChartSummer.addDataItem(summerSelfConsumed, "Lokaal opgewekt [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem summerImport = new DataItem();
summerImport.setValue(dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getIntegralPos_MWh());
pl_consumptionChartSummer.addDataItem(summerImport, "Externe bronnen [MWh]", uI_Results.v_importedEnergyColor);

DataItem summerExport = new DataItem();
summerExport.setValue(-dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getIntegralNeg_MWh());
pl_productionChartSummer.addDataItem(summerExport, "Teruggeleverde elektriciteit [MWh]", uI_Results.v_exportedEnergyColor);

// Winter
DataItem winterSelfConsumed = new DataItem();
winterSelfConsumed.setValue(dataObject.getRapidRunData().getWinterWeekElectricitySelfConsumed_MWh());
pl_productionChartWinter.addDataItem(winterSelfConsumed, "Lokaal gebruikt [MWh]", uI_Results.v_selfConsumedElectricityColor);
pl_consumptionChartWinter.addDataItem(winterSelfConsumed, "Lokaal opgewekt [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem winterImport = new DataItem();
winterImport.setValue(dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getIntegralPos_MWh());
pl_consumptionChartWinter.addDataItem(winterImport, "Externe bronnen [MWh]", uI_Results.v_importedEnergyColor);

DataItem winterExport = new DataItem();
winterExport.setValue(-dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getIntegralNeg_MWh());
pl_productionChartWinter.addDataItem(winterExport, "Teruggeleverde elektriciteit [MWh]", uI_Results.v_exportedEnergyColor);


double summerProduction_MWh = dataObject.getRapidRunData().getSummerWeekElectricityProduced_MWh();
double summerConsumption_MWh = dataObject.getRapidRunData().getSummerWeekElectricityConsumed_MWh();
double winterProduction_MWh = dataObject.getRapidRunData().getWinterWeekElectricityProduced_MWh();
double winterConsumption_MWh = dataObject.getRapidRunData().getWinterWeekElectricityConsumed_MWh();
double chartScale_MWh = max(max(summerProduction_MWh, winterProduction_MWh), max(summerConsumption_MWh, winterConsumption_MWh));
pl_productionChartSummer.setFixedScale(chartScale_MWh);
pl_productionChartWinter.setFixedScale(chartScale_MWh);
pl_consumptionChartSummer.setFixedScale(chartScale_MWh);
pl_consumptionChartWinter.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(summerProduction_MWh*1000) + " kWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(summerConsumption_MWh*1000) + " kWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(winterProduction_MWh*1000) + " kWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(winterConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(summerProduction_MWh) + " MWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(summerConsumption_MWh) + " MWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(winterProduction_MWh) + " MWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(winterConsumption_MWh) + " MWh");
} else {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToDecimal(summerProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToDecimal(summerConsumption_MWh/1000,1) + " GWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToDecimal(winterProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToDecimal(winterConsumption_MWh/1000,1) + " GWh");
} 
  }

  void f_setEnergyBalanceChartPeakDeliveryWeek( I_EnergyData dataObject ) { 

// Summer SelfConsumption
double totalEnergySelfConsumed_summer = dataObject.getRapidRunData().getSummerWeekEnergySelfConsumed_MWh();
double totalPrimaryHeatPumpEnergyProductionSelfConsumed_summer = dataObject.getRapidRunData().getSummerWeekPrimaryEnergyProductionHeatpumps_MWh();

double remainingEnergySelfConsumed_summer;
if((dataObject.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HEAT) && dataObject.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.HEAT) > uI_Results.p_cutOff_MWh) || totalPrimaryHeatPumpEnergyProductionSelfConsumed_summer == 0){
	remainingEnergySelfConsumed_summer = totalEnergySelfConsumed_summer;
}
else{
	remainingEnergySelfConsumed_summer = max(0, totalEnergySelfConsumed_summer - totalPrimaryHeatPumpEnergyProductionSelfConsumed_summer);
	
	DataItem summerSelfConsumedHeatpumpHeat = new DataItem();
	summerSelfConsumedHeatpumpHeat.setValue(totalPrimaryHeatPumpEnergyProductionSelfConsumed_summer);
	pl_productionChartSummer.addDataItem(summerSelfConsumedHeatpumpHeat, "Omgevingswarmte benut door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
	pl_consumptionChartSummer.addDataItem(summerSelfConsumedHeatpumpHeat, "Omgevingswarmte gewonnen door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
}
if(remainingEnergySelfConsumed_summer < uI_Results.p_cutOff_MWh){
	remainingEnergySelfConsumed_summer = 0;
}

DataItem summerSelfConsumedRemainingEnergy = new DataItem();
summerSelfConsumedRemainingEnergy.setValue(remainingEnergySelfConsumed_summer);
pl_productionChartSummer.addDataItem(summerSelfConsumedRemainingEnergy, "Lokaal gebruikte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);
pl_consumptionChartSummer.addDataItem(summerSelfConsumedRemainingEnergy, "Lokaal opgewekte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);



// Winter SelfConsumption
double totalEnergySelfConsumed_winter = dataObject.getRapidRunData().getWinterWeekEnergySelfConsumed_MWh();
double totalPrimaryHeatPumpEnergyProductionSelfConsumed_winter = dataObject.getRapidRunData().getWinterWeekPrimaryEnergyProductionHeatpumps_MWh();

double remainingEnergySelfConsumed_winter;
if((dataObject.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HEAT) && dataObject.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.HEAT) > uI_Results.p_cutOff_MWh) || totalPrimaryHeatPumpEnergyProductionSelfConsumed_winter == 0){
	remainingEnergySelfConsumed_winter = totalEnergySelfConsumed_winter;
}
else{
	remainingEnergySelfConsumed_winter = max(0, totalEnergySelfConsumed_winter - totalPrimaryHeatPumpEnergyProductionSelfConsumed_winter);
	
	DataItem winterSelfConsumedHeatpumpHeat = new DataItem();
	winterSelfConsumedHeatpumpHeat.setValue(totalPrimaryHeatPumpEnergyProductionSelfConsumed_winter);
	pl_productionChartWinter.addDataItem(winterSelfConsumedHeatpumpHeat, "Omgevingswarmte benut door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
	pl_consumptionChartWinter.addDataItem(winterSelfConsumedHeatpumpHeat, "Omgevingswarmte gewonnen door warmtepomp [MWh]", uI_Results.v_heatPumpHeatSupplyColor);
}
if(remainingEnergySelfConsumed_winter < uI_Results.p_cutOff_MWh){
	remainingEnergySelfConsumed_winter = 0;
}

DataItem winterSelfConsumedRemainingEnergy = new DataItem();
winterSelfConsumedRemainingEnergy.setValue(remainingEnergySelfConsumed_winter);

pl_productionChartWinter.addDataItem(winterSelfConsumedRemainingEnergy, "Lokaal gebruikte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);
pl_consumptionChartWinter.addDataItem(winterSelfConsumedRemainingEnergy, "Lokaal opgewekte energie [MWh]", uI_Results.v_selfConsumedEnergyColor);


//Export and import
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeConsumptionEnergyCarriers) {
	// Summer Consumption
	if (dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem summerImport = new DataItem();
		summerImport.setValue(dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh());
		pl_consumptionChartSummer.addDataItem(summerImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
	// Winter Consumption
	if (dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem winterImport = new DataItem();
		winterImport.setValue(dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh());
		pl_consumptionChartWinter.addDataItem(winterImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
}
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeProductionEnergyCarriers) {
	// Summer Production
	if (-dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralNeg_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem summerExport = new DataItem();
		summerExport.setValue(-dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralNeg_MWh());
		pl_productionChartSummer.addDataItem(summerExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}
	// Winter Production
	if (-dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(EC).getIntegralNeg_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem winterExport = new DataItem();
		winterExport.setValue(-dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(EC).getIntegralNeg_MWh());
		pl_productionChartWinter.addDataItem(winterExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}

}

double summerConsumption_MWh = dataObject.getRapidRunData().getSummerWeekEnergyConsumed_MWh();
double summerProduction_MWh = dataObject.getRapidRunData().getSummerWeekEnergyProduced_MWh();
double winterConsumption_MWh = dataObject.getRapidRunData().getWinterWeekEnergyConsumed_MWh();
double winterProduction_MWh = dataObject.getRapidRunData().getWinterWeekEnergyProduced_MWh();
double chartScale_MWh = max(max(summerProduction_MWh, winterProduction_MWh), max(summerConsumption_MWh, winterConsumption_MWh));
pl_productionChartSummer.setFixedScale(chartScale_MWh);
pl_productionChartWinter.setFixedScale(chartScale_MWh);
pl_consumptionChartSummer.setFixedScale(chartScale_MWh);
pl_consumptionChartWinter.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(summerProduction_MWh*1000) + " kWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(summerConsumption_MWh*1000) + " kWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(winterProduction_MWh*1000) + " kWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(winterConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(summerProduction_MWh) + " MWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(summerConsumption_MWh) + " MWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(winterProduction_MWh) + " MWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(winterConsumption_MWh) + " MWh");
} else {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToDecimal(summerProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToDecimal(summerConsumption_MWh/1000,1) + " GWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToDecimal(winterProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToDecimal(winterConsumption_MWh/1000,1) + " GWh");
} 
  }

  void f_setMonthlyCharts(  ) { 

bc_productionMonthlyTotals.removeAll();
bc_consumptionMonthlyTotals.removeAll();

I_EnergyData data = uI_Results.f_getSelectedObjectData();

ZeroAccumulator acc_annualElectricityBalance_kW;
if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
	acc_annualElectricityBalance_kW = uI_Results.v_gridNode.acc_annualElectricityBalance_kW;
}
else {
	acc_annualElectricityBalance_kW = data.getRapidRunData().am_totalBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY);
}

double[] monthlyExport_kWh = new double[12];
double[] monthlyImport_kWh = new double[12];

int[] daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
if (uI_Results.energyModel.p_timeParameters.getStartYear() % 4 == 0 && uI_Results.energyModel.p_timeParameters.getStartYear() % 100 != 0 && uI_Results.energyModel.p_timeParameters.getStartYear() % 400 == 0) {
	daysPerMonth[1] += 1;
}

double signalResolution_h = acc_annualElectricityBalance_kW.getSignalResolution_h();
double[] electricityBalance_kW = acc_annualElectricityBalance_kW.getTimeSeries_kW();

int stepsInPreviousMonths = 0;
for (int i = 0; i < 12; i++) {
	int daysInThisMonth = daysPerMonth[i];
	int stepsInThisMonth = roundToInt(daysInThisMonth * 24 / signalResolution_h);
	for (int j = stepsInPreviousMonths; j < stepsInPreviousMonths + stepsInThisMonth; j++) {
		if (electricityBalance_kW[j] < 0) {
			monthlyExport_kWh[i] += -electricityBalance_kW[j] * signalResolution_h;
		}
		else {
			monthlyImport_kWh[i] += electricityBalance_kW[j] * signalResolution_h;
		}
	}
	stepsInPreviousMonths += stepsInThisMonth;
}

String[] monthNames = new String[]{"Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December"};
for (int i = 0; i < 12; i++) {
	DataItem di_export = new DataItem();
	di_export.setValue(monthlyExport_kWh[i] / 1000);
	bc_productionMonthlyTotals.addDataItem(di_export, monthNames[i], new Color(210,255,191));
	DataItem di_import = new DataItem();
	di_import.setValue(monthlyImport_kWh[i] / 1000);
	bc_consumptionMonthlyTotals.addDataItem(di_import, monthNames[i], new Color(210, 35, 55));
} 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea viewArea = new ViewArea( this, null, 0, 0, 1920, 980 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "viewArea", this.viewArea );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _radio_energyType_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _radio_period_Font = _radio_energyType_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_monthlyDetails_Font = _radio_energyType_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_yearTotals_Font = _radio_energyType_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextYear_Font = new Font("Calibri", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextYear_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextSummer_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextSummer_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_topBarplotText1_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextWinter_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextWinter_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_bottomBarplotText1_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextDay_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextDay_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_topBarplotText2_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextNight_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextNight_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_bottomBarplotText2_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextWeekday_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextWeekday_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_topBarplotText3_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextWeekend_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextWeekend_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_bottomBarplotText3_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionYLabel_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyConsumptionYLabel_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel1_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel2_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel3_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel4_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel5_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel6_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel7_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel8_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel9_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel10_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel11_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel12_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel13_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel14_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel15_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel16_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel17_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel18_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel19_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel20_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel21_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel22_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_monthlyProductionXLabel23_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_productionTextYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_consumptionTextYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_Total = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_productionTextSummer = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_consumptionTextSummer = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_topBarplotText1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_productionTextWinter = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_consumptionTextWinter = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_bottomBarplotText1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_SummerWinter = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_productionTextDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_consumptionTextDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_topBarplotText2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_productionTextNight = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_consumptionTextNight = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_bottomBarplotText2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_DayNight = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_productionTextWeekday = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_consumptionTextWeekday = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_topBarplotText3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_productionTextWeekend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_consumptionTextWeekend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_bottomBarplotText3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_WeekdayWeekend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionYLabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyConsumptionYLabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel6 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel7 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel8 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel9 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel10 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel11 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel12 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel13 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel14 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel15 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel16 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel17 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel18 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel19 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel20 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel21 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel22 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_monthlyProductionXLabel23 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_monthlyTotals = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartBalanceTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartBalanceTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartSummer = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartSummer = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartWinter = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartWinter = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartNight = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartNight = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartWeekday = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartWeekday = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartWeekend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartWeekend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _bc_productionMonthlyTotals = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _bc_consumptionMonthlyTotals = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio_energyType = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio_period = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_monthlyDetails = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_yearTotals = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 72;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 73;

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
	  level.addAll(rectangle, radio_energyType, radio_period, gr_Total, gr_SummerWinter, gr_DayNight, gr_WeekdayWeekend, gr_monthlyTotals);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _button_monthlyDetails: {
          ShapeButton self = this.button_monthlyDetails;
gr_Total.setVisible(false);
f_setMonthlyCharts();
gr_monthlyTotals.setVisible(true); 
;}
        break;
      case _button_yearTotals: {
          ShapeButton self = this.button_yearTotals;
gr_monthlyTotals.setVisible(false);
gr_Total.setVisible(true); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, int value ) {
    switch( _shape ) {
      case _radio_energyType: {
          ShapeRadioButtonGroup self = this.radio_energyType;
f_setCharts(); 
;}
        break;
      case _radio_period: {
          ShapeRadioButtonGroup self = this.radio_period;
f_setCharts(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getShapeControlDefaultValueInt( int _shape, int index ) {
    switch(_shape) {
      case _radio_energyType: return 
0 
;
      case _radio_period: return 
0 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  protected ShapeRadioButtonGroup radio_energyType;
  protected ShapeRadioButtonGroup radio_period;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_monthlyDetails_SetDynamicParams_xjal( ShapeButton shape ) {
    boolean _visible = 
radio_energyType.getValue() == 0 && (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE || uI_Results.f_getSelectedObjectData() instanceof EnergyModel || (uI_Results.f_getSelectedObjectData() instanceof GridConnection && ((GridConnection)uI_Results.f_getSelectedObjectData()).v_hasQuarterHourlyValues)) 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeButton button_monthlyDetails;
  protected ShapeButton button_yearTotals;
  protected StackChart pl_productionChartBalanceTotal;
  protected StackChart pl_consumptionChartBalanceTotal;
  protected StackChart pl_productionChartSummer;
  protected StackChart pl_consumptionChartSummer;
  protected StackChart pl_productionChartWinter;
  protected StackChart pl_consumptionChartWinter;
  protected StackChart pl_productionChartDay;
  protected StackChart pl_consumptionChartDay;
  protected StackChart pl_productionChartNight;
  protected StackChart pl_consumptionChartNight;
  protected StackChart pl_productionChartWeekday;
  protected StackChart pl_consumptionChartWeekday;
  protected StackChart pl_productionChartWeekend;
  protected StackChart pl_consumptionChartWeekend;
  protected BarChart bc_productionMonthlyTotals;
  protected BarChart bc_consumptionMonthlyTotals;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_lineColor 
);
    shape.setLineWidth(
v_lineWidth 
);
  }
  
  protected ShapeRectangle rectangle;
  protected ShapeText t_productionTextYear;
  protected ShapeText t_consumptionTextYear;
  protected ShapeGroup gr_Total;
  protected ShapeText t_productionTextSummer;
  protected ShapeText t_consumptionTextSummer;
  protected ShapeText t_topBarplotText1;
  protected ShapeText t_productionTextWinter;
  protected ShapeText t_consumptionTextWinter;
  protected ShapeText t_bottomBarplotText1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_SummerWinter_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
230 
);
  }
  
  protected ShapeGroup gr_SummerWinter;
  protected ShapeText t_productionTextDay;
  protected ShapeText t_consumptionTextDay;
  protected ShapeText t_topBarplotText2;
  protected ShapeText t_productionTextNight;
  protected ShapeText t_consumptionTextNight;
  protected ShapeText t_bottomBarplotText2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_DayNight_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
230 
);
  }
  
  protected ShapeGroup gr_DayNight;
  protected ShapeText t_productionTextWeekday;
  protected ShapeText t_consumptionTextWeekday;
  protected ShapeText t_topBarplotText3;
  protected ShapeText t_productionTextWeekend;
  protected ShapeText t_consumptionTextWeekend;
  protected ShapeText t_bottomBarplotText3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_WeekdayWeekend_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
230 
);
  }
  
  protected ShapeGroup gr_WeekdayWeekend;
  protected ShapeText t_monthlyProductionYLabel;
  protected ShapeText t_monthlyProductionXLabel;
  protected ShapeText t_monthlyConsumptionYLabel;
  protected ShapeText t_monthlyProductionXLabel1;
  protected ShapeText t_monthlyProductionXLabel2;
  protected ShapeText t_monthlyProductionXLabel3;
  protected ShapeText t_monthlyProductionXLabel4;
  protected ShapeText t_monthlyProductionXLabel5;
  protected ShapeText t_monthlyProductionXLabel6;
  protected ShapeText t_monthlyProductionXLabel7;
  protected ShapeText t_monthlyProductionXLabel8;
  protected ShapeText t_monthlyProductionXLabel9;
  protected ShapeText t_monthlyProductionXLabel10;
  protected ShapeText t_monthlyProductionXLabel11;
  protected ShapeText t_monthlyProductionXLabel12;
  protected ShapeText t_monthlyProductionXLabel13;
  protected ShapeText t_monthlyProductionXLabel14;
  protected ShapeText t_monthlyProductionXLabel15;
  protected ShapeText t_monthlyProductionXLabel16;
  protected ShapeText t_monthlyProductionXLabel17;
  protected ShapeText t_monthlyProductionXLabel18;
  protected ShapeText t_monthlyProductionXLabel19;
  protected ShapeText t_monthlyProductionXLabel20;
  protected ShapeText t_monthlyProductionXLabel21;
  protected ShapeText t_monthlyProductionXLabel22;
  protected ShapeText t_monthlyProductionXLabel23;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_monthlyTotals_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
230 
);
  }
  
  protected ShapeGroup gr_monthlyTotals;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    radio_energyType = new ShapeRadioButtonGroup(
ChartBalans.this, true, 110.0, 5.0,
			230.0, 40.0,
            black, true,
_radio_energyType_Font, false,
            new String[]{"Alleen elektriciteit", "Alle energiedragers", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _radio_energyType, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _radio_energyType, 0 ) );
      }
    };
    radio_period = new ShapeRadioButtonGroup(
ChartBalans.this, true, 20.0, 35.0,
			440.0, 40.0,
            black, true,
_radio_period_Font, false,
            new String[]{"Jaar overzicht", "Zomer / Winter week", "Dag / Nacht", "Week/ Weekend", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _radio_period, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _radio_period, 0 ) );
      }
    };
    button_monthlyDetails = new ShapeButton(
ChartBalans.this, true, 100.0, 330.0,
			115.0, 30.0,
            black, true,
_button_monthlyDetails_Font,
			"bekijk per maand" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_monthlyDetails_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_monthlyDetails, 0 );
      }
    };
    button_yearTotals = new ShapeButton(
ChartBalans.this, true, 110.0, 360.0,
			115.0, 30.0,
            black, true,
_button_yearTotals_Font,
			"bekijk jaartotalen" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_yearTotals, 0 );
      }
    };
    rectangle = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            lavender, whiteSmoke,
			460.0, 80.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_productionTextYear = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -170.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextYear_Font, ALIGNMENT_RIGHT );
    t_consumptionTextYear = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -20.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextYear_Font, ALIGNMENT_RIGHT );
    t_productionTextSummer = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -240.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextSummer_Font, ALIGNMENT_RIGHT );
    t_consumptionTextSummer = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -100.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextSummer_Font, ALIGNMENT_RIGHT );
    t_topBarplotText1 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, -170.0, 0.0, 0.0,
        black,"Zomer week",
        _t_topBarplotText1_Font, ALIGNMENT_CENTER );
    t_productionTextWinter = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 70.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextWinter_Font, ALIGNMENT_RIGHT );
    t_consumptionTextWinter = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 220.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextWinter_Font, ALIGNMENT_RIGHT );
    t_bottomBarplotText1 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, 143.0, 0.0, 0.0,
        black,"Winter week",
        _t_bottomBarplotText1_Font, ALIGNMENT_CENTER );
    t_productionTextDay = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -240.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextDay_Font, ALIGNMENT_RIGHT );
    t_consumptionTextDay = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -100.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextDay_Font, ALIGNMENT_RIGHT );
    t_topBarplotText2 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, -170.0, 0.0, 0.0,
        black,"Dag\n",
        _t_topBarplotText2_Font, ALIGNMENT_CENTER );
    t_productionTextNight = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 70.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextNight_Font, ALIGNMENT_RIGHT );
    t_consumptionTextNight = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 220.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextNight_Font, ALIGNMENT_RIGHT );
    t_bottomBarplotText2 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, 143.0, 0.0, 0.0,
        black,"Nacht",
        _t_bottomBarplotText2_Font, ALIGNMENT_CENTER );
    t_productionTextWeekday = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -240.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextWeekday_Font, ALIGNMENT_RIGHT );
    t_consumptionTextWeekday = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -100.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextWeekday_Font, ALIGNMENT_RIGHT );
    t_topBarplotText3 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, -170.0, 0.0, 0.0,
        black,"Weekdagen\n",
        _t_topBarplotText3_Font, ALIGNMENT_CENTER );
    t_productionTextWeekend = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 70.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextWeekend_Font, ALIGNMENT_RIGHT );
    t_consumptionTextWeekend = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 220.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextWeekend_Font, ALIGNMENT_RIGHT );
    t_bottomBarplotText3 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, 143.0, 0.0, 0.0,
        black,"Weekenden",
        _t_bottomBarplotText3_Font, ALIGNMENT_CENTER );
    t_monthlyProductionYLabel = new ShapeText(
        SHAPE_DRAW_2D, true,-195.0, -110.0, 0.0, 1.5707963267948966,
        black,"Export [MWh]",
        _t_monthlyProductionYLabel_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel = new ShapeText(
        SHAPE_DRAW_2D, true,-153.0, -16.0, 0.0, 5.235987755982989,
        black,"jan",
        _t_monthlyProductionXLabel_Font, ALIGNMENT_CENTER );
    t_monthlyConsumptionYLabel = new ShapeText(
        SHAPE_DRAW_2D, true,-195.0, 180.0, 0.0, 1.5707963267948966,
        black,"Import [MWh]",
        _t_monthlyConsumptionYLabel_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel1 = new ShapeText(
        SHAPE_DRAW_2D, true,-123.0, -16.0, 0.0, 5.235987755982989,
        black,"feb",
        _t_monthlyProductionXLabel1_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel2 = new ShapeText(
        SHAPE_DRAW_2D, true,-93.0, -16.0, 0.0, 5.235987755982989,
        black,"mrt",
        _t_monthlyProductionXLabel2_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel3 = new ShapeText(
        SHAPE_DRAW_2D, true,-3.0, -16.0, 0.0, 5.235987755982989,
        black,"jun",
        _t_monthlyProductionXLabel3_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel4 = new ShapeText(
        SHAPE_DRAW_2D, true,-33.0, -16.0, 0.0, 5.235987755982989,
        black,"mei",
        _t_monthlyProductionXLabel4_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel5 = new ShapeText(
        SHAPE_DRAW_2D, true,-63.0, -16.0, 0.0, 5.235987755982989,
        black,"apr",
        _t_monthlyProductionXLabel5_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel6 = new ShapeText(
        SHAPE_DRAW_2D, true,177.0, -16.0, 0.0, 5.235987755982989,
        black,"dec",
        _t_monthlyProductionXLabel6_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel7 = new ShapeText(
        SHAPE_DRAW_2D, true,57.0, -16.0, 0.0, 5.235987755982989,
        black,"aug",
        _t_monthlyProductionXLabel7_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel8 = new ShapeText(
        SHAPE_DRAW_2D, true,27.0, -16.0, 0.0, 5.235987755982989,
        black,"jul",
        _t_monthlyProductionXLabel8_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel9 = new ShapeText(
        SHAPE_DRAW_2D, true,117.0, -16.0, 0.0, 5.235987755982989,
        black,"okt",
        _t_monthlyProductionXLabel9_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel10 = new ShapeText(
        SHAPE_DRAW_2D, true,147.0, -16.0, 0.0, 5.235987755982989,
        black,"nov",
        _t_monthlyProductionXLabel10_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel11 = new ShapeText(
        SHAPE_DRAW_2D, true,87.0, -16.0, 0.0, 5.235987755982989,
        black,"sep",
        _t_monthlyProductionXLabel11_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel12 = new ShapeText(
        SHAPE_DRAW_2D, true,-153.0, 264.0, 0.0, 5.235987755982989,
        black,"jan",
        _t_monthlyProductionXLabel12_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel13 = new ShapeText(
        SHAPE_DRAW_2D, true,-123.0, 264.0, 0.0, 5.235987755982989,
        black,"feb",
        _t_monthlyProductionXLabel13_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel14 = new ShapeText(
        SHAPE_DRAW_2D, true,-93.0, 264.0, 0.0, 5.235987755982989,
        black,"mrt",
        _t_monthlyProductionXLabel14_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel15 = new ShapeText(
        SHAPE_DRAW_2D, true,-3.0, 264.0, 0.0, 5.235987755982989,
        black,"jun",
        _t_monthlyProductionXLabel15_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel16 = new ShapeText(
        SHAPE_DRAW_2D, true,-33.0, 264.0, 0.0, 5.235987755982989,
        black,"mei",
        _t_monthlyProductionXLabel16_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel17 = new ShapeText(
        SHAPE_DRAW_2D, true,-63.0, 264.0, 0.0, 5.235987755982989,
        black,"apr",
        _t_monthlyProductionXLabel17_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel18 = new ShapeText(
        SHAPE_DRAW_2D, true,177.0, 264.0, 0.0, 5.235987755982989,
        black,"dec",
        _t_monthlyProductionXLabel18_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel19 = new ShapeText(
        SHAPE_DRAW_2D, true,57.0, 264.0, 0.0, 5.235987755982989,
        black,"aug",
        _t_monthlyProductionXLabel19_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel20 = new ShapeText(
        SHAPE_DRAW_2D, true,27.0, 264.0, 0.0, 5.235987755982989,
        black,"jul",
        _t_monthlyProductionXLabel20_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel21 = new ShapeText(
        SHAPE_DRAW_2D, true,117.0, 264.0, 0.0, 5.235987755982989,
        black,"okt",
        _t_monthlyProductionXLabel21_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel22 = new ShapeText(
        SHAPE_DRAW_2D, true,147.0, 264.0, 0.0, 5.235987755982989,
        black,"nov",
        _t_monthlyProductionXLabel22_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel23 = new ShapeText(
        SHAPE_DRAW_2D, true,87.0, 264.0, 0.0, 5.235987755982989,
        black,"sep",
        _t_monthlyProductionXLabel23_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartBalanceTotal = new StackChart(
ChartBalans.this, true, -160.0, -210.0,
			322.133, 121.007,
            null, null,
            50.0, 30.0,
			242.133, 41.007000000000005, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_consumptionChartBalanceTotal = new StackChart(
ChartBalans.this, true, -160.0, -60.0,
			323.04, 120.0,
            null, null,
            50.0, 30.0,
			243.04000000000002, 40.0, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartSummer = new StackChart(
ChartBalans.this, true, -160.0, -280.0,
			322.133, 121.007,
            null, null,
            50.0, 30.0,
			242.133, 41.007000000000005, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_consumptionChartSummer = new StackChart(
ChartBalans.this, true, -160.0, -140.0,
			323.04, 120.0,
            null, null,
            50.0, 30.0,
			243.04000000000002, 40.0, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartWinter = new StackChart(
ChartBalans.this, true, -160.0, 30.0,
			324.0, 121.007,
            null, null,
            50.0, 30.0,
			244.00000000000003, 41.007000000000005, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_consumptionChartWinter = new StackChart(
ChartBalans.this, true, -160.0, 180.0,
			323.04, 120.0,
            null, null,
            50.0, 30.0,
			243.04000000000002, 40.0, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartDay = new StackChart(
ChartBalans.this, true, -160.0, -280.0,
			322.133, 121.007,
            null, null,
            50.0, 30.0,
			242.133, 41.007000000000005, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_consumptionChartDay = new StackChart(
ChartBalans.this, true, -160.0, -140.0,
			323.04, 120.0,
            null, null,
            50.0, 30.0,
			243.04000000000002, 40.0, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartNight = new StackChart(
ChartBalans.this, true, -160.0, 30.0,
			324.0, 121.007,
            null, null,
            50.0, 30.0,
			244.00000000000003, 41.007000000000005, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_consumptionChartNight = new StackChart(
ChartBalans.this, true, -160.0, 180.0,
			323.04, 120.0,
            null, null,
            50.0, 30.0,
			243.04000000000002, 40.0, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartWeekday = new StackChart(
ChartBalans.this, true, -160.0, -280.0,
			322.133, 121.007,
            null, null,
            50.0, 30.0,
			242.133, 41.007000000000005, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_consumptionChartWeekday = new StackChart(
ChartBalans.this, true, -160.0, -140.0,
			323.04, 120.0,
            null, null,
            50.0, 30.0,
			243.04000000000002, 40.0, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartWeekend = new StackChart(
ChartBalans.this, true, -160.0, 30.0,
			324.0, 121.007,
            null, null,
            50.0, 30.0,
			244.00000000000003, 41.007000000000005, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_consumptionChartWeekend = new StackChart(
ChartBalans.this, true, -160.0, 180.0,
			323.04, 120.0,
            null, null,
            50.0, 30.0,
			243.04000000000002, 40.0, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    bc_productionMonthlyTotals = new BarChart(
ChartBalans.this, true, -210.0, -200.0,
			430.0, 200.0,
            null, null,
            50.0, 30.0,
			360.0, 140.0, white, black, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    bc_consumptionMonthlyTotals = new BarChart(
ChartBalans.this, true, -210.0, 80.0,
			430.0, 200.0,
            null, null,
            50.0, 30.0,
			360.0, 140.0, white, black, black,
            30.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    gr_Total = new ShapeGroup( ChartBalans.this, SHAPE_DRAW_2D3D, true, 230.0, 350.0, 0.0, 0.0
	
	     , pl_productionChartBalanceTotal
	     , pl_consumptionChartBalanceTotal
	     , t_productionTextYear
	     , t_consumptionTextYear
	     , button_monthlyDetails );
    }
    {
    gr_SummerWinter = new ShapeGroup( ChartBalans.this, SHAPE_DRAW_2D3D, true, 690.0, 380.0, 0.0, 0.0
	
	     , pl_productionChartSummer
	     , pl_consumptionChartSummer
	     , t_productionTextSummer
	     , t_consumptionTextSummer
	     , t_topBarplotText1
	     , pl_productionChartWinter
	     , pl_consumptionChartWinter
	     , t_productionTextWinter
	     , t_consumptionTextWinter
	     , t_bottomBarplotText1 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_SummerWinter_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_SummerWinter.setVisible( false );
    {
    gr_DayNight = new ShapeGroup( ChartBalans.this, SHAPE_DRAW_2D3D, true, 1120.0, 380.0, 0.0, 0.0
	
	     , pl_productionChartDay
	     , pl_consumptionChartDay
	     , t_productionTextDay
	     , t_consumptionTextDay
	     , t_topBarplotText2
	     , pl_productionChartNight
	     , pl_consumptionChartNight
	     , t_productionTextNight
	     , t_consumptionTextNight
	     , t_bottomBarplotText2 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_DayNight_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_DayNight.setVisible( false );
    {
    gr_WeekdayWeekend = new ShapeGroup( ChartBalans.this, SHAPE_DRAW_2D3D, true, 1550.0, 380.0, 0.0, 0.0
	
	     , pl_productionChartWeekday
	     , pl_consumptionChartWeekday
	     , t_productionTextWeekday
	     , t_consumptionTextWeekday
	     , t_topBarplotText3
	     , pl_productionChartWeekend
	     , pl_consumptionChartWeekend
	     , t_productionTextWeekend
	     , t_consumptionTextWeekend
	     , t_bottomBarplotText3 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_WeekdayWeekend_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_WeekdayWeekend.setVisible( false );
    {
    gr_monthlyTotals = new ShapeGroup( ChartBalans.this, SHAPE_DRAW_2D3D, true, 2040.0, 320.0, 0.0, 0.0
	
	     , bc_productionMonthlyTotals
	     , bc_consumptionMonthlyTotals
	     , button_yearTotals
	     , t_monthlyProductionYLabel
	     , t_monthlyProductionXLabel
	     , t_monthlyConsumptionYLabel
	     , t_monthlyProductionXLabel1
	     , t_monthlyProductionXLabel2
	     , t_monthlyProductionXLabel3
	     , t_monthlyProductionXLabel4
	     , t_monthlyProductionXLabel5
	     , t_monthlyProductionXLabel6
	     , t_monthlyProductionXLabel7
	     , t_monthlyProductionXLabel8
	     , t_monthlyProductionXLabel9
	     , t_monthlyProductionXLabel10
	     , t_monthlyProductionXLabel11
	     , t_monthlyProductionXLabel12
	     , t_monthlyProductionXLabel13
	     , t_monthlyProductionXLabel14
	     , t_monthlyProductionXLabel15
	     , t_monthlyProductionXLabel16
	     , t_monthlyProductionXLabel17
	     , t_monthlyProductionXLabel18
	     , t_monthlyProductionXLabel19
	     , t_monthlyProductionXLabel20
	     , t_monthlyProductionXLabel21
	     , t_monthlyProductionXLabel22
	     , t_monthlyProductionXLabel23 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_monthlyTotals_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_monthlyTotals.setVisible( false );
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
  public ChartBalans( Engine engine, Agent owner, AgentList<? extends ChartBalans> ownerPopulation ) {
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
  public ChartBalans() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartBalans_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartBalans.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartBalans.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    radio_energyType.setValueToDefault();
    radio_period.setValueToDefault();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _bc_productionMonthlyTotals_autoUpdateEvent_xjal.start();
    _bc_consumptionMonthlyTotals_autoUpdateEvent_xjal.start();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartBalans_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartBalans_xjal() {
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

  public AgentList<? extends ChartBalans> getPopulation() {
    return (AgentList<? extends ChartBalans>) super.getPopulation();
  }

  public List<? extends ChartBalans> agentsInRange( double distance ) {
    return (List<? extends ChartBalans>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _bc_productionMonthlyTotals_autoUpdateEvent_xjal ) return false;
    if ( _e == _bc_consumptionMonthlyTotals_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _bc_productionMonthlyTotals_autoUpdateEvent_xjal.onDestroy();
    _bc_consumptionMonthlyTotals_autoUpdateEvent_xjal.onDestroy();
    super.onDestroy();
  }


}
