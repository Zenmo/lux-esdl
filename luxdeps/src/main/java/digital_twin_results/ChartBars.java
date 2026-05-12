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

public class ChartBars extends digital_twin_results.ChartArea
{
  // Parameters
  // Plain Variables

  /**
   * When true the barchart with the selfconsumption of electricity is visible, when false it is showing the electricity use per asset type. Toggled by the button button_electricityChart
   */
  public 
boolean 
 v_showingElectricitySelfConsumption;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartBars.class );

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
				if (v_showingElectricitySelfConsumption) {
					f_setElectricitySelfConsumptionBarChartTotal(data);
				}
				else {
					f_setElectricityAssetsBarChartTotal(data);
				}
				break;
			case 1:
				if (v_showingElectricitySelfConsumption) {
					f_setElectricitySelfConsumptionBarChartSummerWinter(data);
				}
				else {
					f_setElectricityAssetsBarChartSummerWinter(data);
				}
				break;
			case 2:
				if (v_showingElectricitySelfConsumption) {
					f_setElectricitySelfConsumptionBarChartDayNight(data);
				}
				else {
					f_setElectricityAssetsBarChartDayNight(data);
				}						
				break;
			case 3:
				if (v_showingElectricitySelfConsumption) {
					f_setElectricitySelfConsumptionBarChartWeekdayWeekend(data);
				}
				else {
					f_setElectricityAssetsBarChartWeekdayWeekend(data);
				}
				break;
		}
	}
	else if( radio_energyType.getValue() == 1){
		switch(radio_period.getValue()){
			case 0:
				f_setHeatBarChartTotal(data);
				break;
			case 1:
				f_setHeatBarChartSummerWinter(data);
				break;
			case 2:
				f_setHeatBarChartDayNight(data);
				break;
			case 3:
				f_setHeatBarChartWeekdayWeekend(data);
				break;
		}
	}
	else if( radio_energyType.getValue() == 2){
		switch(radio_period.getValue()){
			case 0:
				f_setEnergyBarChartTotal(data);
				break;
			case 1:
				f_setEnergyBarChartSummerWinter(data);
				break;
			case 2:
				f_setEnergyBarChartDayNight(data);
				break;
			case 3:
				f_setEnergyBarChartWeekdayWeekend(data);
				break;
		}
	}
} 
  }

  void f_setElectricitySelfConsumptionBarChartTotal( I_EnergyData dataObject ) { 

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

  void f_setElectricitySelfConsumptionBarChartSummerWinter( I_EnergyData dataObject ) { 

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

  void f_setElectricitySelfConsumptionBarChartDayNight( I_EnergyData dataObject ) { 

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

  void f_setElectricitySelfConsumptionBarChartWeekdayWeekend( I_EnergyData dataObject ) { 

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

  void f_setVisiblity(  ) { 

gr_Total.setVisible(false);
gr_SummerWinter.setVisible(false);
gr_DayNight.setVisible(false);
gr_WeekdayWeekend.setVisible(false);
gr_monthlyTotals.setVisible(false);

button_electricityChart.setVisible(false);
if (radio_energyType.getValue() == 0 && uI_Results.v_selectedObjectScope != OL_ResultScope.GRIDNODE) {
	button_electricityChart.setVisible(true);
}

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

  void f_setHeatBarChartTotal( I_EnergyData dataObject ) { 

if ( !dataObject.getRapidRunData().activeEnergyCarriers.contains(OL_EnergyCarriers.HEAT) ) {
	return;
}

double totalConsumption_MWh = 0;
double totalProduction_MWh = 0;
double consumption_MWh = 0;
double production_MWh = 0;

// Consumption
// Space heating
if (dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet().contains(OL_AssetFlowCategories.spaceHeating_kW)) {
	double spaceHeating_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.spaceHeating_kW).getIntegral_MWh();
	if (spaceHeating_MWh > uI_Results.p_cutOff_MWh) {
		totalConsumption_MWh += spaceHeating_MWh;
		DataItem spaceHeating = new DataItem();
		spaceHeating.setValue(spaceHeating_MWh);
		pl_consumptionChartBalanceTotal.addDataItem(spaceHeating, "Ruimteverwarming [MWh]", orange);
	}
}

// DHW
if (dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet().contains(OL_AssetFlowCategories.hotWaterConsumption_kW)) {
	consumption_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.hotWaterConsumption_kW).getIntegral_MWh();
	if ( consumption_MWh > uI_Results.p_cutOff_MWh ) {
		totalConsumption_MWh += consumption_MWh;
		DataItem hotWater = new DataItem();
		hotWater.setValue(consumption_MWh);
		pl_consumptionChartBalanceTotal.addDataItem(hotWater, "Warmwater [MWh]", cornflowerBlue);
	}
}

// Production
// Standard Heating Assets
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().am_totalConsumptionForHeating_kW.keySet()) {
	if(EC == OL_EnergyCarriers.HEAT || EC == OL_EnergyCarriers.ELECTRICITY){
		continue; //-> Heat grid is calculated seperatly below, for electricity we look at individual assetflowcategories
	}
	if (dataObject.getRapidRunData().am_totalHeatFromEnergyCarrier_kW.keySet().contains(EC)) {
		double ECConsumption_MWh = dataObject.getRapidRunData().am_totalConsumptionForHeating_kW.get(EC).getIntegral_MWh();
		double heatProduction_MWh = dataObject.getRapidRunData().am_totalHeatFromEnergyCarrier_kW.get(EC).getIntegral_MWh();
		double losses_MWh = max(0, ECConsumption_MWh - heatProduction_MWh);
		if ( ECConsumption_MWh > uI_Results.p_cutOff_MWh ) {
			totalProduction_MWh += ECConsumption_MWh;
			DataItem heatProduction = new DataItem();
			heatProduction.setValue(ECConsumption_MWh);
			pl_productionChartBalanceTotal.addDataItem(heatProduction, uI_Results.f_getECName(EC) + " [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
		if (losses_MWh > uI_Results.p_cutOff_MWh ) {
			totalConsumption_MWh += losses_MWh;
			DataItem ECLosses = new DataItem();
			ECLosses.setValue(losses_MWh);
			pl_consumptionChartBalanceTotal.addDataItem(ECLosses, uI_Results.f_getECName(EC) + " verliezen [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
	}
}

// Heatgrid
//if (dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet().contains(OL_AssetFlowCategories.districtHeatDelivery_kW)) {
if(dataObject.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.HEAT) > uI_Results.p_cutOff_MWh){
	double import_MWh = dataObject.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.HEAT);
	production_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getIntegral_MWh();
	double losses_MWh = max(0, import_MWh - production_MWh);
	if (import_MWh > uI_Results.p_cutOff_MWh) {
		totalProduction_MWh += import_MWh;
		DataItem heatgridImport = new DataItem();
		heatgridImport.setValue(import_MWh);
		pl_productionChartBalanceTotal.addDataItem(heatgridImport, "Warmte uit Warmtenet [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.districtHeatDelivery_kW));
	}
	if (losses_MWh > uI_Results.p_cutOff_MWh) {
		totalConsumption_MWh += losses_MWh;
		DataItem heatgridLosses = new DataItem();
		heatgridLosses.setValue(losses_MWh);
		pl_consumptionChartBalanceTotal.addDataItem(heatgridLosses, "Warmtenet Verliezen [MWh]", gray);
	}
}

// Heatpumps
if (dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet().contains(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW)) {
	production_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW).getIntegral_MWh();
	if (production_MWh > uI_Results.p_cutOff_MWh) {
		totalProduction_MWh += production_MWh;
		DataItem heatpumpElectricity = new DataItem();
		heatpumpElectricity.setValue(production_MWh);
		pl_productionChartBalanceTotal.addDataItem(heatpumpElectricity, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));
		double import_MWh = dataObject.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.HEAT);
		if (import_MWh <= uI_Results.p_cutOff_MWh){	
			production_MWh = dataObject.getRapidRunData().acc_totalPrimaryEnergyProductionHeatpumps_kW.getIntegral_MWh();
			totalProduction_MWh += production_MWh;
			DataItem heatpumpEnvironment = new DataItem();
			heatpumpEnvironment.setValue(production_MWh);
			pl_productionChartBalanceTotal.addDataItem(heatpumpEnvironment, "Warmte uit Omgeving [MWh]", lightSkyBlue);
		}
	}
}
// Electric Heaters
if (dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet().contains(OL_AssetFlowCategories.electricHeaterElectricityConsumption_kW)) {
	production_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.electricHeaterElectricityConsumption_kW).getIntegral_MWh();
	if (production_MWh > uI_Results.p_cutOff_MWh) {
		totalProduction_MWh += production_MWh;
		DataItem heatpumpElectricity = new DataItem();
		heatpumpElectricity.setValue(production_MWh);
		pl_productionChartBalanceTotal.addDataItem(heatpumpElectricity, "Stroom voor Electrische Kachel [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));
	}
}

// PVT
if (dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet().contains(OL_AssetFlowCategories.ptProductionHeat_kW)) {
	production_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getIntegral_MWh();
	if (production_MWh > uI_Results.p_cutOff_MWh) {
		totalProduction_MWh += production_MWh;
		DataItem pt = new DataItem();
		pt.setValue(production_MWh);
		pl_productionChartBalanceTotal.addDataItem(pt, "PT [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.ptProductionHeat_kW));
	}
}


double chartScale_MWh = max(totalConsumption_MWh, totalProduction_MWh);
pl_consumptionChartBalanceTotal.setFixedScale(chartScale_MWh);
pl_productionChartBalanceTotal.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumption_MWh*1000) + " kWh");
	t_productionTextYear.setText("Bron" + System.lineSeparator() + roundToInt(totalProduction_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumption_MWh) + " MWh");
	t_productionTextYear.setText("Bron" + System.lineSeparator() + roundToInt(totalProduction_MWh) + " MWh");
} else {
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalConsumption_MWh/1000,1) + " GWh");
	t_productionTextYear.setText("Bron" + System.lineSeparator() + roundToDecimal(totalProduction_MWh/1000, 1) + " GWh");
} 
  }

  void f_setHeatBarChartSummerWinter( I_EnergyData dataObject ) { 

if ( !dataObject.getRapidRunData().activeEnergyCarriers.contains(OL_EnergyCarriers.HEAT) ) {
	return;
}

double totalConsumptionSummer_MWh = 0;
double totalProductionSummer_MWh = 0;
double totalConsumptionWinter_MWh = 0;
double totalProductionWinter_MWh = 0;
double consumption_MWh = 0;
double production_MWh= 0;

// Summer
// Consumption
// Space heating
double spaceHeating_MWh  = 0;
/*
if (dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.keySet().contains(OL_AssetFlowCategories.buildingHeating_kW)) {
	spaceHeating_MWh += dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(OL_AssetFlowCategories.buildingHeating_kW).getIntegral_MWh();
}
*/
if (dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.keySet().contains(OL_AssetFlowCategories.spaceHeating_kW)) {
	spaceHeating_MWh += dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(OL_AssetFlowCategories.spaceHeating_kW).getIntegral_MWh();
}
if (spaceHeating_MWh > uI_Results.p_cutOff_MWh) {
	totalConsumptionSummer_MWh += spaceHeating_MWh;
	DataItem spaceHeating = new DataItem();
	spaceHeating.setValue(spaceHeating_MWh);
	pl_consumptionChartSummer.addDataItem(spaceHeating, "Ruimteverwarming [MWh]", orange);
}

// DHW
if (dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.keySet().contains(OL_AssetFlowCategories.hotWaterConsumption_kW)) {
	consumption_MWh = dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(OL_AssetFlowCategories.hotWaterConsumption_kW).getIntegral_MWh();
	if ( consumption_MWh > uI_Results.p_cutOff_MWh ) {
		totalConsumptionSummer_MWh += consumption_MWh;
		DataItem hotWater = new DataItem();
		hotWater.setValue(consumption_MWh);
		pl_consumptionChartSummer.addDataItem(hotWater, "Warmwater [MWh]", cornflowerBlue);
	}
}

// Production
// Standard Heating Assets
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().am_summerWeekConsumptionForHeating_kW.keySet()) {
	if(EC == OL_EnergyCarriers.HEAT || EC == OL_EnergyCarriers.ELECTRICITY){
		continue; //-> Heat grid is calculated seperatly below, for electricity we look at individual assetflowcategories
	}
	if (dataObject.getRapidRunData().am_summerWeekHeatFromEnergyCarrier_kW.keySet().contains(EC)) {
		double ECConsumption_MWh = dataObject.getRapidRunData().am_summerWeekConsumptionForHeating_kW.get(EC).getIntegral_MWh();
		double heatProduction_MWh = dataObject.getRapidRunData().am_summerWeekHeatFromEnergyCarrier_kW.get(EC).getIntegral_MWh();
		double losses_MWh = max(0, ECConsumption_MWh - heatProduction_MWh);
		if ( ECConsumption_MWh > uI_Results.p_cutOff_MWh ) {
			totalProductionSummer_MWh += ECConsumption_MWh;
			DataItem heatProduction = new DataItem();
			heatProduction.setValue(ECConsumption_MWh);
			pl_productionChartSummer.addDataItem(heatProduction, uI_Results.f_getECName(EC) + " [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
		if (losses_MWh > uI_Results.p_cutOff_MWh ) {
			totalConsumptionSummer_MWh += losses_MWh;
			DataItem ECLosses = new DataItem();
			ECLosses.setValue(losses_MWh);
			pl_consumptionChartSummer.addDataItem(ECLosses, uI_Results.f_getECName(EC) + " verliezen [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
	}
}
// Heatpumps
if (dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.keySet().contains(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW)) {
	production_MWh = dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW).getIntegral_MWh();
	if (production_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionSummer_MWh += production_MWh;
		DataItem heatpumpElectricity = new DataItem();
		heatpumpElectricity.setValue(production_MWh);
		pl_productionChartSummer.addDataItem(heatpumpElectricity, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));
		double import_MWh = dataObject.getRapidRunData().getSummerWeekImport_MWh(OL_EnergyCarriers.HEAT);
		if (import_MWh <= uI_Results.p_cutOff_MWh){	
			production_MWh = dataObject.getRapidRunData().acc_summerWeekPrimaryEnergyProductionHeatpumps_kW.getIntegral_MWh();
			totalProductionSummer_MWh += production_MWh;
			DataItem heatpumpEnvironment = new DataItem();
			heatpumpEnvironment.setValue(production_MWh);
			pl_productionChartSummer.addDataItem(heatpumpEnvironment, "Warmte uit Omgeving [MWh]", lightSkyBlue);
		}
	}
}
// Electric Heater
if (dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.keySet().contains(OL_AssetFlowCategories.electricHeaterElectricityConsumption_kW)) {
	production_MWh = dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(OL_AssetFlowCategories.electricHeaterElectricityConsumption_kW).getIntegral_MWh();
	if (production_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionSummer_MWh += production_MWh;
		DataItem heatpumpElectricity = new DataItem();
		heatpumpElectricity.setValue(production_MWh);
		pl_productionChartSummer.addDataItem(heatpumpElectricity, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));
	}
}
// PVT
if (dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.keySet().contains(OL_AssetFlowCategories.ptProductionHeat_kW)) {
	production_MWh = dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getIntegral_MWh();
	if (production_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionSummer_MWh += production_MWh;
		DataItem pt = new DataItem();
		pt.setValue(production_MWh);
		pl_productionChartSummer.addDataItem(pt, "PT [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.ptProductionHeat_kW));
	}
}
// Heatgrid
if (dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.keySet().contains(OL_AssetFlowCategories.districtHeatDelivery_kW)) {
	double import_MWh = dataObject.getRapidRunData().getSummerWeekImport_MWh(OL_EnergyCarriers.HEAT);
	production_MWh = dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getIntegral_MWh();
	double losses_MWh = max(0, import_MWh - production_MWh);
	if (import_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionSummer_MWh += import_MWh;
		DataItem heatgridDemand = new DataItem();
		heatgridDemand.setValue(import_MWh);
		pl_productionChartSummer.addDataItem(heatgridDemand, "Warmte uit Warmtenet [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.districtHeatDelivery_kW));
	}
	if (losses_MWh > uI_Results.p_cutOff_MWh) {
		totalConsumptionSummer_MWh += losses_MWh;
		DataItem heatgridLosses = new DataItem();
		heatgridLosses.setValue(losses_MWh);
		pl_consumptionChartSummer.addDataItem(heatgridLosses, "Warmtenet Verliezen [MWh]", gray);
	}
}


// Winter
// Consumption
// Space heating
spaceHeating_MWh  = 0;
/*
if (dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.keySet().contains(OL_AssetFlowCategories.buildingHeating_kW)) {
	spaceHeating_MWh += dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(OL_AssetFlowCategories.buildingHeating_kW).getIntegral_MWh();
}
*/
if (dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.keySet().contains(OL_AssetFlowCategories.spaceHeating_kW)) {
	spaceHeating_MWh += dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(OL_AssetFlowCategories.spaceHeating_kW).getIntegral_MWh();
}
if (spaceHeating_MWh > uI_Results.p_cutOff_MWh) {
	totalConsumptionWinter_MWh += spaceHeating_MWh;
	DataItem spaceHeating = new DataItem();
	spaceHeating.setValue(spaceHeating_MWh);
	pl_consumptionChartWinter.addDataItem(spaceHeating, "Ruimteverwarming [MWh]", orange);
}

// DHW
if (dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.keySet().contains(OL_AssetFlowCategories.hotWaterConsumption_kW)) {
	consumption_MWh = dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(OL_AssetFlowCategories.hotWaterConsumption_kW).getIntegral_MWh();
	if ( consumption_MWh > uI_Results.p_cutOff_MWh ) {
		totalConsumptionWinter_MWh += consumption_MWh;
		DataItem hotWater = new DataItem();
		hotWater.setValue(consumption_MWh);
		pl_consumptionChartWinter.addDataItem(hotWater, "Warmwater [MWh]", cornflowerBlue);
	}
}

// Production
// Standard Heating Assets
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().am_winterWeekConsumptionForHeating_kW.keySet()) {
	if(EC == OL_EnergyCarriers.HEAT || EC == OL_EnergyCarriers.ELECTRICITY){
		continue; //-> Heat grid is calculated seperatly below, for electricity we look at individual assetflowcategories
	}
	if (dataObject.getRapidRunData().am_winterWeekHeatFromEnergyCarrier_kW.keySet().contains(EC)) {
		double ECConsumption_MWh = dataObject.getRapidRunData().am_winterWeekConsumptionForHeating_kW.get(EC).getIntegral_MWh();
		double heatProduction_MWh = dataObject.getRapidRunData().am_winterWeekHeatFromEnergyCarrier_kW.get(EC).getIntegral_MWh();
		double losses_MWh = max(0, ECConsumption_MWh - heatProduction_MWh);
		if ( ECConsumption_MWh > uI_Results.p_cutOff_MWh ) {
			totalProductionWinter_MWh += ECConsumption_MWh;
			DataItem heatProduction = new DataItem();
			heatProduction.setValue(ECConsumption_MWh);
			pl_productionChartWinter.addDataItem(heatProduction, uI_Results.f_getECName(EC) + " [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
		if (losses_MWh > uI_Results.p_cutOff_MWh ) {
			totalConsumptionWinter_MWh += losses_MWh;
			DataItem ECLosses = new DataItem();
			ECLosses.setValue(losses_MWh);
			pl_consumptionChartWinter.addDataItem(ECLosses, uI_Results.f_getECName(EC) + " verliezen [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
	}
}
// Heatpumps
if (dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.keySet().contains(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW)) {
	production_MWh = dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW).getIntegral_MWh();
	if (production_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionWinter_MWh += production_MWh;
		DataItem heatpumpElectricity = new DataItem();
		heatpumpElectricity.setValue(production_MWh);
		pl_productionChartWinter.addDataItem(heatpumpElectricity, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));
		
		double import_MWh = dataObject.getRapidRunData().getWinterWeekImport_MWh(OL_EnergyCarriers.HEAT);
		if (import_MWh <= uI_Results.p_cutOff_MWh) {
			production_MWh = dataObject.getRapidRunData().acc_winterWeekPrimaryEnergyProductionHeatpumps_kW.getIntegral_MWh();
			totalProductionWinter_MWh += production_MWh;
			DataItem heatpumpEnvironment = new DataItem();
			heatpumpEnvironment.setValue(production_MWh);
			pl_productionChartWinter.addDataItem(heatpumpEnvironment, "Warmte uit Omgeving [MWh]", lightSkyBlue);
		}
	}
}
// Electric Heater
if (dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.keySet().contains(OL_AssetFlowCategories.electricHeaterElectricityConsumption_kW)) {
	production_MWh = dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(OL_AssetFlowCategories.electricHeaterElectricityConsumption_kW).getIntegral_MWh();
	if (production_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionWinter_MWh += production_MWh;
		DataItem heatpumpElectricity = new DataItem();
		heatpumpElectricity.setValue(production_MWh);
		pl_productionChartWinter.addDataItem(heatpumpElectricity, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));
	}
}
// PVT
if (dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.keySet().contains(OL_AssetFlowCategories.ptProductionHeat_kW)) {
	production_MWh = dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getIntegral_MWh();
	if (production_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionWinter_MWh += production_MWh;
		DataItem pt = new DataItem();
		pt.setValue(production_MWh);
		pl_productionChartWinter.addDataItem(pt, "PT [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.ptProductionHeat_kW));
	}
}
// Heatgrid
if (dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.keySet().contains(OL_AssetFlowCategories.districtHeatDelivery_kW)) {
	double import_MWh = dataObject.getRapidRunData().getWinterWeekImport_MWh(OL_EnergyCarriers.HEAT);
	production_MWh = dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getIntegral_MWh();
	double losses_MWh = max(0, import_MWh - production_MWh);
	if (import_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionWinter_MWh += import_MWh;
		DataItem heatgridDemand = new DataItem();
		heatgridDemand.setValue(import_MWh);
		pl_productionChartWinter.addDataItem(heatgridDemand, "Warmte uit Warmtenet [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.districtHeatDelivery_kW));
	}
	if (losses_MWh > uI_Results.p_cutOff_MWh) {
		totalConsumptionWinter_MWh += losses_MWh;
		DataItem heatgridLosses = new DataItem();
		heatgridLosses.setValue(losses_MWh);
		pl_consumptionChartWinter.addDataItem(heatgridLosses, "Warmtenet Verliezen [MWh]", gray);
	}
}

double chartScaleSummer_MWh = max(totalConsumptionSummer_MWh, totalProductionSummer_MWh);
pl_consumptionChartSummer.setFixedScale(chartScaleSummer_MWh);
pl_productionChartSummer.setFixedScale(chartScaleSummer_MWh);
double chartScaleWinter_MWh = max(totalConsumptionWinter_MWh, totalProductionWinter_MWh);
pl_consumptionChartWinter.setFixedScale(chartScaleWinter_MWh);
pl_productionChartWinter.setFixedScale(chartScaleWinter_MWh);
double chartScale_MWh = max(chartScaleSummer_MWh, chartScaleWinter_MWh);

if (chartScale_MWh<10) {
	t_productionTextSummer.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionSummer_MWh*1000) + " kWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionSummer_MWh*1000) + " kWh");
	t_productionTextWinter.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionWinter_MWh*1000) + " kWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionWinter_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextSummer.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionSummer_MWh) + " MWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionSummer_MWh) + " MWh");
	t_productionTextWinter.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionWinter_MWh) + " MWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionWinter_MWh) + " MWh");
} else {
	t_productionTextSummer.setText("Bron" + System.lineSeparator() + roundToDecimal(totalProductionSummer_MWh/1000, 1) + " GWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalConsumptionSummer_MWh/1000,1) + " GWh");
	t_productionTextWinter.setText("Bron" + System.lineSeparator() + roundToDecimal(totalProductionWinter_MWh/1000, 1) + " GWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalConsumptionWinter_MWh/1000,1) + " GWh");
} 
  }

  void f_setHeatBarChartDayNight( I_EnergyData dataObject ) { 

if ( !dataObject.getRapidRunData().activeEnergyCarriers.contains(OL_EnergyCarriers.HEAT) ) {
	return;
}

double totalConsumptionDay_MWh = 0;
double totalProductionDay_MWh = 0;
double totalConsumptionNight_MWh = 0;
double totalProductionNight_MWh = 0;
double consumptionNight_MWh = 0;
double consumptionDay_MWh = 0;
double productionDay_MWh = 0;
double productionNight_MWh = 0;

// Consumption
// Space heating
double spaceHeatingDay_MWh  = 0;
double spaceHeatingNight_MWh  = 0;
/*
if (dataObject.getRapidRunData().am_assetFlowsDaytime_kW.keySet().contains(OL_AssetFlowCategories.buildingHeating_kW)) {
	double buildingHeatDay_MWh = dataObject.getRapidRunData().am_assetFlowsDaytime_kW.get(OL_AssetFlowCategories.buildingHeating_kW).getIntegral_MWh();
	double buildingHeatTotal_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.buildingHeating_kW).getIntegral_MWh();
	spaceHeatingDay_MWh += buildingHeatDay_MWh;
	spaceHeatingNight_MWh += buildingHeatTotal_MWh - buildingHeatDay_MWh;
}
*/
if (dataObject.getRapidRunData().am_assetFlowsDaytime_kW.keySet().contains(OL_AssetFlowCategories.spaceHeating_kW)) {
	double profileDay_MWh = dataObject.getRapidRunData().am_assetFlowsDaytime_kW.get(OL_AssetFlowCategories.spaceHeating_kW).getIntegral_MWh();
	double profileTotal_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.spaceHeating_kW).getIntegral_MWh();
	spaceHeatingDay_MWh += profileDay_MWh;
	spaceHeatingNight_MWh += profileTotal_MWh - profileDay_MWh;
}
if (spaceHeatingDay_MWh > uI_Results.p_cutOff_MWh) {
	totalConsumptionDay_MWh += spaceHeatingDay_MWh;
	DataItem spaceHeatingDay = new DataItem();
	spaceHeatingDay.setValue(spaceHeatingDay_MWh);
	pl_consumptionChartDay.addDataItem(spaceHeatingDay, "Ruimteverwarming [MWh]", orange);
}
if (spaceHeatingNight_MWh > uI_Results.p_cutOff_MWh) {
	totalConsumptionNight_MWh += spaceHeatingNight_MWh;
	DataItem spaceHeatingNight = new DataItem();
	spaceHeatingNight.setValue(spaceHeatingNight_MWh);
	pl_consumptionChartNight.addDataItem(spaceHeatingNight, "Ruimteverwarming [MWh]", orange);
}

// DHW
if (dataObject.getRapidRunData().am_assetFlowsDaytime_kW.keySet().contains(OL_AssetFlowCategories.hotWaterConsumption_kW)) {
	double hotWaterDay_MWh = dataObject.getRapidRunData().am_assetFlowsDaytime_kW.get(OL_AssetFlowCategories.hotWaterConsumption_kW).getIntegral_MWh();
	double hotWaterNight_MWh = -hotWaterDay_MWh + dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.hotWaterConsumption_kW).getIntegral_MWh();
	if ( hotWaterDay_MWh > uI_Results.p_cutOff_MWh ) {
		totalConsumptionDay_MWh += hotWaterDay_MWh;
		DataItem hotWaterDay = new DataItem();
		hotWaterDay.setValue(hotWaterDay_MWh);
		pl_consumptionChartDay.addDataItem(hotWaterDay, "Warmwater [MWh]", cornflowerBlue);
	}
	if ( hotWaterNight_MWh > uI_Results.p_cutOff_MWh ) {
		totalConsumptionNight_MWh += hotWaterNight_MWh;
		DataItem hotWaterNight = new DataItem();
		hotWaterNight.setValue(hotWaterNight_MWh);
		pl_consumptionChartNight.addDataItem(hotWaterNight, "Warmwater [MWh]", cornflowerBlue);
	}
}

// Production
// Standard Heating Assets
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().am_daytimeConsumptionForHeating_kW.keySet()) {
	if(EC == OL_EnergyCarriers.HEAT || EC == OL_EnergyCarriers.ELECTRICITY){
		continue; //-> Heat grid is calculated seperatly below, for electricity we look at individual assetflowcategories
	}
	if (dataObject.getRapidRunData().am_daytimeHeatFromEnergyCarrier_kW.keySet().contains(EC)) {
		double ECConsumptionDay_MWh = dataObject.getRapidRunData().am_daytimeConsumptionForHeating_kW.get(EC).getIntegral_MWh();
		double heatProductionDay_MWh = dataObject.getRapidRunData().am_daytimeHeatFromEnergyCarrier_kW.get(EC).getIntegral_MWh();
		double ECConsumptionNight_MWh = -ECConsumptionDay_MWh + dataObject.getRapidRunData().am_totalConsumptionForHeating_kW.get(EC).getIntegral_MWh();
		double heatProductionNight_MWh = -heatProductionDay_MWh + dataObject.getRapidRunData().am_totalHeatFromEnergyCarrier_kW.get(EC).getIntegral_MWh();
		double lossesDay_MWh = max(0, ECConsumptionDay_MWh - heatProductionDay_MWh);
		double lossesNight_MWh = max(0, ECConsumptionNight_MWh - heatProductionNight_MWh);
		if ( ECConsumptionDay_MWh > uI_Results.p_cutOff_MWh ) {
			totalProductionDay_MWh += ECConsumptionDay_MWh;
			DataItem heatProductionDay = new DataItem();
			heatProductionDay.setValue(ECConsumptionDay_MWh);
			pl_productionChartDay.addDataItem(heatProductionDay, uI_Results.f_getECName(EC) + " [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
		if (lossesDay_MWh > uI_Results.p_cutOff_MWh ) {
			totalConsumptionDay_MWh += lossesDay_MWh;
			DataItem ECLossesDay = new DataItem();
			ECLossesDay.setValue(lossesDay_MWh);
			pl_consumptionChartDay.addDataItem(ECLossesDay, uI_Results.f_getECName(EC) + " verliezen [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
		if ( ECConsumptionNight_MWh > uI_Results.p_cutOff_MWh ) {
			totalProductionNight_MWh += ECConsumptionNight_MWh;
			DataItem heatProductionNight = new DataItem();
			heatProductionNight.setValue(ECConsumptionNight_MWh);
			pl_productionChartNight.addDataItem(heatProductionNight, uI_Results.f_getECName(EC) + " [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
		if (lossesNight_MWh > uI_Results.p_cutOff_MWh ) {
			totalConsumptionNight_MWh += lossesNight_MWh;
			DataItem ECLossesNight = new DataItem();
			ECLossesNight.setValue(lossesNight_MWh);
			pl_consumptionChartNight.addDataItem(ECLossesNight, uI_Results.f_getECName(EC) + " verliezen [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
	}
}
// Heatpumps
if (dataObject.getRapidRunData().am_assetFlowsDaytime_kW.keySet().contains(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW)) {
	productionDay_MWh = dataObject.getRapidRunData().am_assetFlowsDaytime_kW.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW).getIntegral_MWh();
	productionNight_MWh = -productionDay_MWh + dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW).getIntegral_MWh();
	if (productionDay_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionDay_MWh += productionDay_MWh;
		DataItem heatpumpElectricityDay = new DataItem();
		heatpumpElectricityDay.setValue(productionDay_MWh);
		pl_productionChartDay.addDataItem(heatpumpElectricityDay, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));
		
		totalProductionNight_MWh += productionNight_MWh;
		DataItem heatpumpElectricityNight = new DataItem();
		heatpumpElectricityNight.setValue(productionNight_MWh);
		pl_productionChartNight.addDataItem(heatpumpElectricityNight, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));	
		
		double importDay_MWh = dataObject.getRapidRunData().getDaytimeImport_MWh(OL_EnergyCarriers.HEAT);
		double importNight_MWh = -importDay_MWh + dataObject.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.HEAT);
		if (importDay_MWh <= uI_Results.p_cutOff_MWh) {
			productionDay_MWh = dataObject.getRapidRunData().acc_daytimePrimaryEnergyProductionHeatpumps_kW.getIntegral_MWh();
			productionNight_MWh = -productionDay_MWh + dataObject.getRapidRunData().acc_totalPrimaryEnergyProductionHeatpumps_kW.getIntegral_MWh();
			
			totalProductionDay_MWh += productionDay_MWh;
			DataItem heatpumpEnvironmentDay = new DataItem();
			heatpumpEnvironmentDay.setValue(totalProductionDay_MWh);
			pl_productionChartDay.addDataItem(heatpumpEnvironmentDay, "Warmte uit Omgeving [MWh]", lightSkyBlue);
			
			totalProductionNight_MWh += productionNight_MWh;
			DataItem heatpumpEnvironmentNight = new DataItem();
			heatpumpEnvironmentNight.setValue(totalProductionNight_MWh);
			pl_productionChartNight.addDataItem(heatpumpEnvironmentNight, "Warmte uit Omgeving [MWh]", lightSkyBlue);
		}
	}
}
// Electric Heater
if (dataObject.getRapidRunData().am_assetFlowsDaytime_kW.keySet().contains(OL_AssetFlowCategories.electricHeaterElectricityConsumption_kW)) {
	productionDay_MWh = dataObject.getRapidRunData().am_assetFlowsDaytime_kW.get(OL_AssetFlowCategories.electricHeaterElectricityConsumption_kW).getIntegral_MWh();
	productionNight_MWh = -productionDay_MWh + dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW).getIntegral_MWh();
	if (productionDay_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionDay_MWh += productionDay_MWh;
		DataItem heatpumpElectricityDay = new DataItem();
		heatpumpElectricityDay.setValue(productionDay_MWh);
		pl_productionChartDay.addDataItem(heatpumpElectricityDay, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));
		
		totalProductionNight_MWh += productionNight_MWh;
		DataItem heatpumpElectricityNight = new DataItem();
		heatpumpElectricityNight.setValue(productionNight_MWh);
		pl_productionChartNight.addDataItem(heatpumpElectricityNight, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));	
	}
}
// PVT
if (dataObject.getRapidRunData().am_assetFlowsDaytime_kW.keySet().contains(OL_AssetFlowCategories.ptProductionHeat_kW)) {
	productionDay_MWh = dataObject.getRapidRunData().am_assetFlowsDaytime_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getIntegral_MWh();
	productionNight_MWh = -productionDay_MWh + dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getIntegral_MWh();
	if (productionDay_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionDay_MWh += productionDay_MWh;
		DataItem ptDay = new DataItem();
		ptDay.setValue(productionDay_MWh);
		pl_productionChartDay.addDataItem(ptDay, "PT [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.ptProductionHeat_kW));
	}
	if (productionNight_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionNight_MWh += productionNight_MWh;
		DataItem ptNight = new DataItem();
		ptNight.setValue(productionNight_MWh);
		pl_productionChartNight.addDataItem(ptNight, "PT [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.ptProductionHeat_kW));
	}
}
// Heatgrid
if (dataObject.getRapidRunData().am_assetFlowsDaytime_kW.keySet().contains(OL_AssetFlowCategories.districtHeatDelivery_kW)) {
	double importDay_MWh = dataObject.getRapidRunData().getDaytimeImport_MWh(OL_EnergyCarriers.HEAT);
	double importNight_MWh = -importDay_MWh + dataObject.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.HEAT);
	productionDay_MWh = dataObject.getRapidRunData().am_assetFlowsDaytime_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getIntegral_MWh();
	productionNight_MWh = -productionDay_MWh + dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getIntegral_MWh();
	double lossesDay_MWh = max(0, importDay_MWh - productionDay_MWh);
	double lossesNight_MWh = max(0, importNight_MWh - productionNight_MWh);
	if (importDay_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionDay_MWh += importDay_MWh;
		DataItem heatgridImportDay = new DataItem();
		heatgridImportDay.setValue(importDay_MWh);
		pl_productionChartDay.addDataItem(heatgridImportDay, "Warmte uit Warmtenet [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.districtHeatDelivery_kW));
	}
	if (lossesDay_MWh > uI_Results.p_cutOff_MWh) {
		totalConsumptionDay_MWh += lossesDay_MWh;
		DataItem heatgridLossesDay = new DataItem();
		heatgridLossesDay.setValue(lossesDay_MWh);
		pl_consumptionChartDay.addDataItem(heatgridLossesDay, "Warmtenet Verliezen [MWh]", gray);
	}
	if (importNight_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionNight_MWh += importNight_MWh;
		DataItem heatgridImportNight = new DataItem();
		heatgridImportNight.setValue(importNight_MWh);
		pl_productionChartNight.addDataItem(heatgridImportNight, "Warmte uit Warmtenet [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.districtHeatDelivery_kW));
	}
	if (lossesNight_MWh > uI_Results.p_cutOff_MWh) {
		totalConsumptionNight_MWh += lossesNight_MWh;
		DataItem heatgridLossesNight = new DataItem();
		heatgridLossesNight.setValue(lossesNight_MWh);
		pl_consumptionChartNight.addDataItem(heatgridLossesNight, "Warmtenet Verliezen [MWh]", gray);
	}
}

double chartScaleDay_MWh = max(totalConsumptionDay_MWh, totalProductionDay_MWh);
pl_consumptionChartDay.setFixedScale(chartScaleDay_MWh);
pl_productionChartDay.setFixedScale(chartScaleDay_MWh);
double chartScaleNight_MWh = max(totalConsumptionNight_MWh, totalProductionNight_MWh);
pl_consumptionChartNight.setFixedScale(chartScaleNight_MWh);
pl_productionChartNight.setFixedScale(chartScaleNight_MWh);

double chartScale_MWh = max(chartScaleDay_MWh, chartScaleNight_MWh);

if (chartScale_MWh<10) {
	t_productionTextDay.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionDay_MWh*1000) + " kWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionDay_MWh*1000) + " kWh");
	t_productionTextNight.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionNight_MWh*1000) + " kWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionNight_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextDay.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionDay_MWh) + " MWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionDay_MWh) + " MWh");
	t_productionTextNight.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionNight_MWh) + " MWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionNight_MWh) + " MWh");
} else {
	t_productionTextDay.setText("Bron" + System.lineSeparator() + roundToDecimal(totalProductionDay_MWh/1000, 1) + " GWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalConsumptionDay_MWh/1000,1) + " GWh");
	t_productionTextNight.setText("Bron" + System.lineSeparator() + roundToDecimal(totalProductionNight_MWh/1000, 1) + " GWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalConsumptionNight_MWh/1000,1) + " GWh");
}

 
  }

  void f_setHeatBarChartWeekdayWeekend( I_EnergyData dataObject ) { 

if ( !dataObject.getRapidRunData().activeEnergyCarriers.contains(OL_EnergyCarriers.HEAT) ) {
	return;
}

double totalConsumptionWeekend_MWh = 0;
double totalProductionWeekend_MWh = 0;
double totalConsumptionWeekday_MWh = 0;
double totalProductionWeekday_MWh = 0;
double consumptionWeekday_MWh = 0;
double consumptionWeekend_MWh = 0;
double productionWeekend_MWh = 0;
double productionWeekday_MWh = 0;

// Consumption
// Space heating
double spaceHeatingWeekend_MWh  = 0;
double spaceHeatingWeekday_MWh  = 0;
/*
if (dataObject.getRapidRunData().am_assetFlowsWeekend_kW.keySet().contains(OL_AssetFlowCategories.buildingHeating_kW)) {
	double buildingHeatWeekend_MWh = dataObject.getRapidRunData().am_assetFlowsWeekend_kW.get(OL_AssetFlowCategories.buildingHeating_kW).getIntegral_MWh();
	double buildingHeatTotal_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.buildingHeating_kW).getIntegral_MWh();
	spaceHeatingWeekend_MWh += buildingHeatWeekend_MWh;
	spaceHeatingWeekday_MWh += buildingHeatTotal_MWh - buildingHeatWeekend_MWh;
}
*/
if (dataObject.getRapidRunData().am_assetFlowsWeekend_kW.keySet().contains(OL_AssetFlowCategories.spaceHeating_kW)) {
	double profileWeekend_MWh = dataObject.getRapidRunData().am_assetFlowsWeekend_kW.get(OL_AssetFlowCategories.spaceHeating_kW).getIntegral_MWh();
	double profileTotal_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.spaceHeating_kW).getIntegral_MWh();
	spaceHeatingWeekend_MWh += profileWeekend_MWh;
	spaceHeatingWeekday_MWh += profileTotal_MWh - profileWeekend_MWh;
}
if (spaceHeatingWeekend_MWh > uI_Results.p_cutOff_MWh) {
	totalConsumptionWeekend_MWh += spaceHeatingWeekend_MWh;
	DataItem spaceHeatingWeekend = new DataItem();
	spaceHeatingWeekend.setValue(spaceHeatingWeekend_MWh);
	pl_consumptionChartWeekend.addDataItem(spaceHeatingWeekend, "Ruimteverwarming [MWh]", orange);
}
if (spaceHeatingWeekday_MWh > uI_Results.p_cutOff_MWh) {
	totalConsumptionWeekday_MWh += spaceHeatingWeekday_MWh;
	DataItem spaceHeatingWeekday = new DataItem();
	spaceHeatingWeekday.setValue(spaceHeatingWeekday_MWh);
	pl_consumptionChartWeekday.addDataItem(spaceHeatingWeekday, "Ruimteverwarming [MWh]", orange);
}

// DHW
if (dataObject.getRapidRunData().am_assetFlowsWeekend_kW.keySet().contains(OL_AssetFlowCategories.hotWaterConsumption_kW)) {
	double hotWaterWeekend_MWh = dataObject.getRapidRunData().am_assetFlowsWeekend_kW.get(OL_AssetFlowCategories.hotWaterConsumption_kW).getIntegral_MWh();
	double hotWaterWeekday_MWh = -hotWaterWeekend_MWh + dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.hotWaterConsumption_kW).getIntegral_MWh();
	if ( hotWaterWeekend_MWh > uI_Results.p_cutOff_MWh ) {
		totalConsumptionWeekend_MWh += hotWaterWeekend_MWh;
		DataItem hotWaterWeekend = new DataItem();
		hotWaterWeekend.setValue(hotWaterWeekend_MWh);
		pl_consumptionChartWeekend.addDataItem(hotWaterWeekend, "Warmwater [MWh]", cornflowerBlue);
	}
	if ( hotWaterWeekday_MWh > uI_Results.p_cutOff_MWh ) {
		totalConsumptionWeekday_MWh += hotWaterWeekday_MWh;
		DataItem hotWaterWeekday = new DataItem();
		hotWaterWeekday.setValue(hotWaterWeekday_MWh);
		pl_consumptionChartWeekday.addDataItem(hotWaterWeekday, "Warmwater [MWh]", cornflowerBlue);
	}
}

// Production
// Standard Heating Assets
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().am_weekendConsumptionForHeating_kW.keySet()) {
	if(EC == OL_EnergyCarriers.HEAT || EC == OL_EnergyCarriers.ELECTRICITY){
		continue; //-> Heat grid is calculated seperatly below, for electricity we look at individual assetflowcategories
	}
	if (dataObject.getRapidRunData().am_weekendHeatFromEnergyCarrier_kW.keySet().contains(EC)) {
		double ECConsumptionWeekend_MWh = dataObject.getRapidRunData().am_weekendConsumptionForHeating_kW.get(EC).getIntegral_MWh();
		double heatProductionWeekend_MWh = dataObject.getRapidRunData().am_weekendHeatFromEnergyCarrier_kW.get(EC).getIntegral_MWh();
		double ECConsumptionWeekday_MWh = -ECConsumptionWeekend_MWh + dataObject.getRapidRunData().am_totalConsumptionForHeating_kW.get(EC).getIntegral_MWh();
		double heatProductionWeekday_MWh = -heatProductionWeekend_MWh + dataObject.getRapidRunData().am_totalHeatFromEnergyCarrier_kW.get(EC).getIntegral_MWh();
		double lossesWeekend_MWh = max(0, ECConsumptionWeekend_MWh - heatProductionWeekend_MWh);
		double lossesWeekday_MWh = max(0, ECConsumptionWeekday_MWh - heatProductionWeekday_MWh);
		if ( ECConsumptionWeekend_MWh > uI_Results.p_cutOff_MWh ) {
			totalProductionWeekend_MWh += ECConsumptionWeekend_MWh;
			DataItem heatProductionWeekend = new DataItem();
			heatProductionWeekend.setValue(ECConsumptionWeekend_MWh);
			pl_productionChartWeekend.addDataItem(heatProductionWeekend, uI_Results.f_getECName(EC) + " [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
		if (lossesWeekend_MWh > uI_Results.p_cutOff_MWh ) {
			totalConsumptionWeekend_MWh += lossesWeekend_MWh;
			DataItem ECLossesWeekend = new DataItem();
			ECLossesWeekend.setValue(lossesWeekend_MWh);
			pl_consumptionChartWeekend.addDataItem(ECLossesWeekend, uI_Results.f_getECName(EC) + " verliezen [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
		if ( ECConsumptionWeekday_MWh > uI_Results.p_cutOff_MWh ) {
			totalProductionWeekday_MWh += ECConsumptionWeekday_MWh;
			DataItem heatProductionWeekday = new DataItem();
			heatProductionWeekday.setValue(ECConsumptionWeekday_MWh);
			pl_productionChartWeekday.addDataItem(heatProductionWeekday, uI_Results.f_getECName(EC) + " [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
		if (lossesWeekday_MWh > uI_Results.p_cutOff_MWh ) {
			totalConsumptionWeekday_MWh += lossesWeekday_MWh;
			DataItem ECLossesWeekday = new DataItem();
			ECLossesWeekday.setValue(lossesWeekday_MWh);
			pl_consumptionChartWeekday.addDataItem(ECLossesWeekday, uI_Results.f_getECName(EC) + " verliezen [MWh]", uI_Results.cm_consumptionColors.get(EC));
		}
	}
}
// Heatpumps
if (dataObject.getRapidRunData().am_assetFlowsWeekend_kW.keySet().contains(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW)) {
	productionWeekend_MWh = dataObject.getRapidRunData().am_assetFlowsWeekend_kW.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW).getIntegral_MWh();
	productionWeekday_MWh = -productionWeekend_MWh + dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW).getIntegral_MWh();
	if (productionWeekend_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionWeekend_MWh += productionWeekend_MWh;
		DataItem heatpumpElectricityWeekend = new DataItem();
		heatpumpElectricityWeekend.setValue(productionWeekend_MWh);
		pl_productionChartWeekend.addDataItem(heatpumpElectricityWeekend, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));
		
		totalProductionWeekday_MWh += productionWeekday_MWh;
		DataItem heatpumpElectricityWeekday = new DataItem();
		heatpumpElectricityWeekday.setValue(productionWeekday_MWh);
		pl_productionChartWeekday.addDataItem(heatpumpElectricityWeekday, "Stroom voor Warmtepomp [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW));	
		
		double importWeekend_MWh = dataObject.getRapidRunData().getWeekendImport_MWh(OL_EnergyCarriers.HEAT);
		double importWeekday_MWh = -importWeekend_MWh + dataObject.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.HEAT);
		if (importWeekend_MWh <= uI_Results.p_cutOff_MWh){
			productionWeekend_MWh = dataObject.getRapidRunData().acc_weekendPrimaryEnergyProductionHeatpumps_kW.getIntegral_MWh();
			productionWeekday_MWh = -productionWeekend_MWh + dataObject.getRapidRunData().acc_totalPrimaryEnergyProductionHeatpumps_kW.getIntegral_MWh();
			
			totalProductionWeekend_MWh += productionWeekend_MWh;
			DataItem heatpumpEnvironmentWeekend = new DataItem();
			heatpumpEnvironmentWeekend.setValue(totalProductionWeekend_MWh);
			pl_productionChartWeekend.addDataItem(heatpumpEnvironmentWeekend, "Warmte uit Omgeving [MWh]", lightSkyBlue);
			
			totalProductionWeekday_MWh += productionWeekday_MWh;
			DataItem heatpumpEnvironmentWeekday = new DataItem();
			heatpumpEnvironmentWeekday.setValue(totalProductionWeekday_MWh);
			pl_productionChartWeekday.addDataItem(heatpumpEnvironmentWeekday, "Warmte uit Omgeving [MWh]", lightSkyBlue);
		}
	}
}
// PVT
if (dataObject.getRapidRunData().am_assetFlowsWeekend_kW.keySet().contains(OL_AssetFlowCategories.ptProductionHeat_kW)) {
	productionWeekend_MWh = dataObject.getRapidRunData().am_assetFlowsWeekend_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getIntegral_MWh();
	productionWeekday_MWh = -productionWeekend_MWh + dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getIntegral_MWh();
	if (productionWeekend_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionWeekend_MWh += productionWeekend_MWh;
		DataItem ptWeekend = new DataItem();
		ptWeekend.setValue(productionWeekend_MWh);
		pl_productionChartWeekend.addDataItem(ptWeekend, "PT [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.ptProductionHeat_kW));
	}
	if (productionWeekday_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionWeekday_MWh += productionWeekday_MWh;
		DataItem ptWeekday = new DataItem();
		ptWeekday.setValue(productionWeekday_MWh);
		pl_productionChartWeekday.addDataItem(ptWeekday, "PT [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.ptProductionHeat_kW));
	}
}
// Heatgrid
if (dataObject.getRapidRunData().am_assetFlowsWeekend_kW.keySet().contains(OL_AssetFlowCategories.districtHeatDelivery_kW)) {
	double importWeekend_MWh = dataObject.getRapidRunData().getWeekendImport_MWh(OL_EnergyCarriers.HEAT);
	double importWeekday_MWh = -importWeekend_MWh + dataObject.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.HEAT);
	productionWeekend_MWh = dataObject.getRapidRunData().am_assetFlowsWeekend_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getIntegral_MWh();
	productionWeekday_MWh = -productionWeekend_MWh + dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getIntegral_MWh();
	double lossesWeekend_MWh = max(0, importWeekend_MWh - productionWeekend_MWh);
	double lossesWeekday_MWh = max(0, importWeekday_MWh - productionWeekday_MWh);
	if (importWeekend_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionWeekend_MWh += importWeekend_MWh;
		DataItem heatgridImportWeekend = new DataItem();
		heatgridImportWeekend.setValue(importWeekend_MWh);
		pl_productionChartWeekend.addDataItem(heatgridImportWeekend, "Warmte uit Warmtenet [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.districtHeatDelivery_kW));
	}
	if (lossesWeekend_MWh > uI_Results.p_cutOff_MWh) {
		totalConsumptionWeekend_MWh += lossesWeekend_MWh;
		DataItem heatgridLossesWeekend = new DataItem();
		heatgridLossesWeekend.setValue(lossesWeekend_MWh);
		pl_consumptionChartWeekend.addDataItem(heatgridLossesWeekend, "Warmtenet Verliezen [MWh]", gray);
	}
	if (importWeekday_MWh > uI_Results.p_cutOff_MWh) {
		totalProductionWeekday_MWh += importWeekday_MWh;
		DataItem heatgridImportWeekday = new DataItem();
		heatgridImportWeekday.setValue(importWeekday_MWh);
		pl_productionChartWeekday.addDataItem(heatgridImportWeekday, "Warmte uit Warmtenet [MWh]", uI_Results.cm_assetFlowColors.get(OL_AssetFlowCategories.districtHeatDelivery_kW));
	}
	if (lossesWeekday_MWh > uI_Results.p_cutOff_MWh) {
		totalConsumptionWeekday_MWh += lossesWeekday_MWh;
		DataItem heatgridLossesWeekday = new DataItem();
		heatgridLossesWeekday.setValue(lossesWeekday_MWh);
		pl_consumptionChartWeekday.addDataItem(heatgridLossesWeekday, "Warmtenet Verliezen [MWh]", gray);
	}
}

double chartScaleWeekend_MWh = max(totalConsumptionWeekend_MWh, totalProductionWeekend_MWh);
pl_consumptionChartWeekend.setFixedScale(chartScaleWeekend_MWh);
pl_productionChartWeekend.setFixedScale(chartScaleWeekend_MWh);
double chartScaleWeekday_MWh = max(totalConsumptionWeekday_MWh, totalProductionWeekday_MWh);
pl_consumptionChartWeekday.setFixedScale(chartScaleWeekday_MWh);
pl_productionChartWeekday.setFixedScale(chartScaleWeekday_MWh);

double chartScale_MWh = max(chartScaleWeekend_MWh, chartScaleWeekday_MWh);

if (chartScale_MWh<10) {
	t_productionTextWeekend.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionWeekend_MWh*1000) + " kWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionWeekend_MWh*1000) + " kWh");
	t_productionTextWeekday.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionWeekday_MWh*1000) + " kWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionWeekday_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextWeekend.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionWeekend_MWh) + " MWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionWeekend_MWh) + " MWh");
	t_productionTextWeekday.setText("Bron" + System.lineSeparator() + roundToInt(totalProductionWeekday_MWh) + " MWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumptionWeekday_MWh) + " MWh");
} else {
	t_productionTextWeekend.setText("Bron" + System.lineSeparator() + roundToDecimal(totalProductionWeekend_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalConsumptionWeekend_MWh/1000,1) + " GWh");
	t_productionTextWeekday.setText("Bron" + System.lineSeparator() + roundToDecimal(totalProductionWeekday_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalConsumptionWeekday_MWh/1000,1) + " GWh");
}

 
  }

  /**
   * Only shows Import and Export
   */
  void f_setEnergyBarChartTotal( I_EnergyData dataObject ) { 

for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeConsumptionEnergyCarriers) {
	if (dataObject.getRapidRunData().getTotalImport_MWh(EC) > uI_Results.p_cutOff_MWh) {
		DataItem totalImport = new DataItem();
		totalImport.setValue(dataObject.getRapidRunData().getTotalImport_MWh(EC));
		pl_consumptionChartBalanceTotal.addDataItem(totalImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_consumptionColors.get(EC));
	}
}
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeProductionEnergyCarriers) {
	if (dataObject.getRapidRunData().getTotalExport_MWh(EC) > uI_Results.p_cutOff_MWh) {
		DataItem totalExport = new DataItem();
		totalExport.setValue(dataObject.getRapidRunData().getTotalExport_MWh(EC));
		pl_productionChartBalanceTotal.addDataItem(totalExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}
}

double consumption_MWh = dataObject.getRapidRunData().getTotalEnergyImport_MWh();
double production_MWh = dataObject.getRapidRunData().getTotalEnergyExport_MWh();
double chartScale_MWh = max(production_MWh, consumption_MWh);
pl_consumptionChartBalanceTotal.setFixedScale(chartScale_MWh);
pl_productionChartBalanceTotal.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_consumptionTextYear.setText("Import" + System.lineSeparator() + roundToInt(consumption_MWh*1000) + " kWh");
	t_productionTextYear.setText("Export" + System.lineSeparator() + roundToInt(production_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_consumptionTextYear.setText("Import" + System.lineSeparator() + roundToInt(consumption_MWh) + " MWh");
	t_productionTextYear.setText("Export" + System.lineSeparator() + roundToInt(production_MWh) + " MWh");
} else {
	t_consumptionTextYear.setText("Import" + System.lineSeparator() + roundToDecimal(consumption_MWh/1000,1) + " GWh");
	t_productionTextYear.setText("Export" + System.lineSeparator() + roundToDecimal(production_MWh/1000, 1) + " GWh");
}
 
  }

  /**
   * Only shows Import and Export
   */
  void f_setEnergyBarChartSummerWinter( I_EnergyData dataObject ) { 

for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeConsumptionEnergyCarriers) {
	if (dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem summerImport = new DataItem();
		summerImport.setValue(dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh());
		pl_consumptionChartSummer.addDataItem(summerImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
	if (dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem winterImport = new DataItem();
		winterImport.setValue(dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(EC).getIntegralPos_MWh());
		pl_consumptionChartWinter.addDataItem(winterImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
}
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeProductionEnergyCarriers) {
	if (-dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralNeg_MWh() > uI_Results.p_cutOff_MWh) {
		DataItem summerExport = new DataItem();
		summerExport.setValue(-dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(EC).getIntegralNeg_MWh());
		pl_productionChartSummer.addDataItem(summerExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}
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
	t_consumptionTextSummer.setText("Import" + System.lineSeparator() + roundToInt(summerConsumption_MWh*1000) + " kWh");
	t_productionTextSummer.setText("Export" + System.lineSeparator() + roundToInt(summerProduction_MWh*1000) + " kWh");
	t_consumptionTextWinter.setText("Import" + System.lineSeparator() + roundToInt(winterConsumption_MWh*1000) + " kWh");
	t_productionTextWinter.setText("Export" + System.lineSeparator() + roundToInt(winterProduction_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_consumptionTextSummer.setText("Import" + System.lineSeparator() + roundToInt(summerConsumption_MWh) + " MWh");
	t_productionTextSummer.setText("Export" + System.lineSeparator() + roundToInt(summerProduction_MWh) + " MWh");
	t_consumptionTextWinter.setText("Import" + System.lineSeparator() + roundToInt(winterConsumption_MWh) + " MWh");
	t_productionTextWinter.setText("Export" + System.lineSeparator() + roundToInt(winterProduction_MWh) + " MWh");
} else {
	t_consumptionTextSummer.setText("Import" + System.lineSeparator() + roundToDecimal(summerConsumption_MWh/1000,1) + " GWh");
	t_productionTextSummer.setText("Export" + System.lineSeparator() + roundToDecimal(summerProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWinter.setText("Import" + System.lineSeparator() + roundToDecimal(winterConsumption_MWh/1000,1) + " GWh");
	t_productionTextWinter.setText("Export" + System.lineSeparator() + roundToDecimal(winterProduction_MWh/1000, 1) + " GWh");
} 
  }

  /**
   * Only shows Import and Export
   */
  void f_setEnergyBarChartDayNight( I_EnergyData dataObject ) { 

for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeConsumptionEnergyCarriers) {
	if (dataObject.getRapidRunData().getDaytimeImport_MWh(EC) > uI_Results.p_cutOff_MWh) {
		DataItem daytimeImport = new DataItem();
		daytimeImport.setValue(dataObject.getRapidRunData().getDaytimeImport_MWh(EC));
		pl_consumptionChartDay.addDataItem(daytimeImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
	if (dataObject.getRapidRunData().getNighttimeImport_MWh(EC) > uI_Results.p_cutOff_MWh) {
		DataItem nighttimeImport = new DataItem();
		nighttimeImport.setValue(dataObject.getRapidRunData().getNighttimeImport_MWh(EC));
		pl_consumptionChartNight.addDataItem(nighttimeImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}	
}
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeProductionEnergyCarriers) {
	if (dataObject.getRapidRunData().getDaytimeExport_MWh(EC) > uI_Results.p_cutOff_MWh) {	
		DataItem daytimeExport = new DataItem();
		daytimeExport.setValue(dataObject.getRapidRunData().getDaytimeExport_MWh(EC));
		pl_productionChartDay.addDataItem(daytimeExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}	
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
	t_consumptionTextDay.setText("Import" + System.lineSeparator() + roundToInt(dayConsumption_MWh*1000) + " kWh");
	t_productionTextDay.setText("Export" + System.lineSeparator() + roundToInt(dayProduction_MWh*1000) + " kWh");
	t_consumptionTextNight.setText("Import" + System.lineSeparator() + roundToInt(nightConsumption_MWh*1000) + " kWh");
	t_productionTextNight.setText("Export" + System.lineSeparator() + roundToInt(nightProduction_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_consumptionTextDay.setText("Import" + System.lineSeparator() + roundToInt(dayConsumption_MWh) + " MWh");
	t_productionTextDay.setText("Export" + System.lineSeparator() + roundToInt(dayProduction_MWh) + " MWh");
	t_consumptionTextNight.setText("Import" + System.lineSeparator() + roundToInt(nightConsumption_MWh) + " MWh");
	t_productionTextNight.setText("Export" + System.lineSeparator() + roundToInt(nightProduction_MWh) + " MWh");
} else {
	t_consumptionTextDay.setText("Import" + System.lineSeparator() + roundToDecimal(dayConsumption_MWh/1000,1) + " GWh");
	t_productionTextDay.setText("Export" + System.lineSeparator() + roundToDecimal(dayProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextNight.setText("Import" + System.lineSeparator() + roundToDecimal(nightConsumption_MWh/1000,1) + " GWh");
	t_productionTextNight.setText("Export" + System.lineSeparator() + roundToDecimal(nightProduction_MWh/1000, 1) + " GWh");
}
 
  }

  /**
   * Only shows Import and Export
   */
  void f_setEnergyBarChartWeekdayWeekend( I_EnergyData dataObject ) { 

for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeConsumptionEnergyCarriers) {
	if (dataObject.getRapidRunData().getWeekdayImport_MWh(EC) > uI_Results.p_cutOff_MWh) {	
		DataItem weekdayImport = new DataItem();
		weekdayImport.setValue(dataObject.getRapidRunData().getWeekdayImport_MWh(EC));
		pl_consumptionChartWeekday.addDataItem(weekdayImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
	if (dataObject.getRapidRunData().getWeekendImport_MWh(EC) > uI_Results.p_cutOff_MWh) {	
		DataItem weekendImport = new DataItem();
		weekendImport.setValue(dataObject.getRapidRunData().getWeekendImport_MWh(EC));
		pl_consumptionChartWeekend.addDataItem(weekendImport, uI_Results.f_getECName(EC) + " Import [MWh]", uI_Results.cm_productionColors.get(EC));
	}
}
for (OL_EnergyCarriers EC : dataObject.getRapidRunData().activeProductionEnergyCarriers) {
	if (dataObject.getRapidRunData().getWeekdayExport_MWh(EC) > uI_Results.p_cutOff_MWh) {	
		DataItem weekdayExport = new DataItem();
		weekdayExport.setValue(dataObject.getRapidRunData().getWeekdayExport_MWh(EC));
		pl_productionChartWeekday.addDataItem(weekdayExport, uI_Results.f_getECName(EC) + " Export [MWh]", uI_Results.cm_productionColors.get(EC));
	}
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
	t_consumptionTextWeekday.setText("Import" + System.lineSeparator() + roundToInt(weekdayConsumption_MWh*1000) + " kWh");
	t_productionTextWeekday.setText("Export" + System.lineSeparator() + roundToInt(weekdayProduction_MWh*1000) + " kWh");
	t_consumptionTextWeekend.setText("Import" + System.lineSeparator() + roundToInt(weekendConsumption_MWh*1000) + " kWh");
	t_productionTextWeekend.setText("Export" + System.lineSeparator() + roundToInt(weekendProduction_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_consumptionTextWeekday.setText("Import" + System.lineSeparator() + roundToInt(weekdayConsumption_MWh) + " MWh");
	t_productionTextWeekday.setText("Export" + System.lineSeparator() + roundToInt(weekdayProduction_MWh) + " MWh");
	t_consumptionTextWeekend.setText("Import" + System.lineSeparator() + roundToInt(weekendConsumption_MWh) + " MWh");
	t_productionTextWeekend.setText("Export" + System.lineSeparator() + roundToInt(weekendProduction_MWh) + " MWh");
} else {
	t_consumptionTextWeekday.setText("Import" + System.lineSeparator() + roundToDecimal(weekdayConsumption_MWh/1000,1) + " GWh");
	t_productionTextWeekday.setText("Export" + System.lineSeparator() + roundToDecimal(weekdayProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekend.setText("Import" + System.lineSeparator() + roundToDecimal(weekendConsumption_MWh/1000,1) + " GWh");
	t_productionTextWeekend.setText("Export" + System.lineSeparator() + roundToDecimal(weekendProduction_MWh/1000, 1) + " GWh");
} 
  }

  void f_setElectricityAssetsBarChartTotal( I_EnergyData dataObject ) { 

double totalConsumption_MWh = 0;
double totalProduction_MWh = 0;
double consumption_MWh = 0;
double production_MWh= 0;
DataItem di = null;

for (OL_AssetFlowCategories AFC : dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet()) {
	if (uI_Results.v_electricAssetFlows.contains(AFC)) {
		if (uI_Results.v_consumptionAssetFlows.contains(AFC)) {
			consumption_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AFC).getIntegral_MWh();
			totalConsumption_MWh += consumption_MWh;
			di = new DataItem();
			di.setValue(consumption_MWh);
			pl_consumptionChartBalanceTotal.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));
		}
		else {
			production_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AFC).getIntegral_MWh();
			totalProduction_MWh += production_MWh;
			di = new DataItem();
			di.setValue(production_MWh);
			pl_productionChartBalanceTotal.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));	
		}
	}
}

double chartScale_MWh = max(totalConsumption_MWh, totalProduction_MWh);

if (chartScale_MWh<10) {
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumption_MWh*1000) + " kWh");
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToInt(totalProduction_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToInt(totalConsumption_MWh) + " MWh");
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToInt(totalProduction_MWh) + " MWh");
} else {
	t_consumptionTextYear.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalConsumption_MWh/1000,1) + " GWh");
	t_productionTextYear.setText("Opwek" + System.lineSeparator() + roundToDecimal(totalProduction_MWh/1000, 1) + " GWh");
} 
  }

  void f_setElectricityAssetsBarChartSummerWinter( I_EnergyData dataObject ) { 

double totalSummerConsumption_MWh = 0;
double totalSummerProduction_MWh = 0;
double totalWinterConsumption_MWh = 0;
double totalWinterProduction_MWh = 0;
double consumption_MWh = 0;
double production_MWh = 0;
DataItem di = null;

for (OL_AssetFlowCategories AFC : dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet()) {
	if (uI_Results.v_electricAssetFlows.contains(AFC)) {
		if (uI_Results.v_consumptionAssetFlows.contains(AFC)) {
			// Summer
			consumption_MWh = dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(AFC).getIntegral_MWh();
			totalSummerConsumption_MWh += consumption_MWh;
			di = new DataItem();
			di.setValue(consumption_MWh);
			pl_consumptionChartSummer.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));
			// Winter
			consumption_MWh = dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(AFC).getIntegral_MWh();
			totalWinterConsumption_MWh += consumption_MWh;
			di = new DataItem();
			di.setValue(consumption_MWh);
			pl_consumptionChartWinter.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));
		}
		else {
			// Summer
			production_MWh = dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(AFC).getIntegral_MWh();
			totalSummerProduction_MWh += production_MWh;
			di = new DataItem();
			di.setValue(production_MWh);
			pl_productionChartSummer.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));	
			// Winter
			production_MWh = dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(AFC).getIntegral_MWh();
			totalWinterProduction_MWh += production_MWh;
			di = new DataItem();
			di.setValue(production_MWh);
			pl_productionChartWinter.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));	
		}
	}
}

double chartScale_MWh = max(max(totalSummerProduction_MWh, totalWinterProduction_MWh), max(totalSummerConsumption_MWh, totalWinterConsumption_MWh));
pl_productionChartSummer.setFixedScale(chartScale_MWh);
pl_productionChartWinter.setFixedScale(chartScale_MWh);
pl_consumptionChartSummer.setFixedScale(chartScale_MWh);
pl_consumptionChartWinter.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(totalSummerProduction_MWh*1000) + " kWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(totalSummerConsumption_MWh*1000) + " kWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(totalWinterProduction_MWh*1000) + " kWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(totalWinterConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToInt(totalSummerProduction_MWh) + " MWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToInt(totalSummerConsumption_MWh) + " MWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToInt(totalWinterProduction_MWh) + " MWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToInt(totalWinterConsumption_MWh) + " MWh");
} else {
	t_productionTextSummer.setText("Opwek" + System.lineSeparator() + roundToDecimal(totalSummerProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextSummer.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalSummerConsumption_MWh/1000,1) + " GWh");
	t_productionTextWinter.setText("Opwek" + System.lineSeparator() + roundToDecimal(totalWinterProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWinter.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalWinterConsumption_MWh/1000,1) + " GWh");
} 
  }

  void f_setElectricityAssetsBarChartDayNight( I_EnergyData dataObject ) { 

double totalDayConsumption_MWh = 0;
double totalDayProduction_MWh = 0;
double totalNightConsumption_MWh = 0;
double totalNightProduction_MWh = 0;
double dayConsumption_MWh = 0;
double dayProduction_MWh = 0;
double nightConsumption_MWh = 0;
double nightProduction_MWh = 0;

DataItem di = null;

for (OL_AssetFlowCategories AFC : dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet()) {
	if (uI_Results.v_electricAssetFlows.contains(AFC)) {
		if (uI_Results.v_consumptionAssetFlows.contains(AFC)) {
			// Day
			dayConsumption_MWh = dataObject.getRapidRunData().am_assetFlowsDaytime_kW.get(AFC).getIntegral_MWh();
			totalDayConsumption_MWh += dayConsumption_MWh;
			di = new DataItem();
			di.setValue(dayConsumption_MWh);
			pl_consumptionChartDay.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));
			// Night
			nightConsumption_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AFC).getIntegral_MWh() - dayConsumption_MWh;
			totalNightConsumption_MWh += nightConsumption_MWh;
			di = new DataItem();
			di.setValue(nightConsumption_MWh);
			pl_consumptionChartNight.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));
		}
		else {
			// Day
			dayProduction_MWh = dataObject.getRapidRunData().am_assetFlowsDaytime_kW.get(AFC).getIntegral_MWh();
			totalDayProduction_MWh += dayProduction_MWh;
			di = new DataItem();
			di.setValue(dayProduction_MWh);
			pl_productionChartDay.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));	
			// Night
			nightProduction_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AFC).getIntegral_MWh() - dayProduction_MWh;
			totalNightProduction_MWh += nightProduction_MWh;
			di = new DataItem();
			di.setValue(nightProduction_MWh);
			pl_productionChartNight.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));	
		}
	}
}

double chartScale_MWh = max(max(totalDayProduction_MWh, totalNightProduction_MWh), max(totalDayConsumption_MWh, totalNightConsumption_MWh));
pl_productionChartDay.setFixedScale(chartScale_MWh);
pl_productionChartNight.setFixedScale(chartScale_MWh);
pl_consumptionChartDay.setFixedScale(chartScale_MWh);
pl_consumptionChartNight.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToInt(totalDayProduction_MWh*1000) + " kWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToInt(totalDayConsumption_MWh*1000) + " kWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToInt(totalNightProduction_MWh*1000) + " kWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToInt(totalNightConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToInt(totalDayProduction_MWh) + " MWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToInt(totalDayConsumption_MWh) + " MWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToInt(totalNightProduction_MWh) + " MWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToInt(totalNightConsumption_MWh) + " MWh");
} else {
	t_productionTextDay.setText("Opwek" + System.lineSeparator() + roundToDecimal(totalDayProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextDay.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalDayConsumption_MWh/1000,1) + " GWh");
	t_productionTextNight.setText("Opwek" + System.lineSeparator() + roundToDecimal(totalNightProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextNight.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalNightConsumption_MWh/1000,1) + " GWh");
}
 
  }

  void f_setElectricityAssetsBarChartWeekdayWeekend( I_EnergyData dataObject ) { 

double totalWeekendConsumption_MWh = 0;
double totalWeekendProduction_MWh = 0;
double totalWeekdayConsumption_MWh = 0;
double totalWeekdayProduction_MWh = 0;
double weekendConsumption_MWh = 0;
double weekendProduction_MWh = 0;
double weekdayConsumption_MWh = 0;
double weekdayProduction_MWh = 0;

DataItem di = null;

for (OL_AssetFlowCategories AFC : dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet()) {
	if (uI_Results.v_electricAssetFlows.contains(AFC)) {
		if (uI_Results.v_consumptionAssetFlows.contains(AFC)) {			
			// Weekend
			weekendConsumption_MWh = dataObject.getRapidRunData().am_assetFlowsWeekend_kW.get(AFC).getIntegral_MWh();
			totalWeekendConsumption_MWh += weekendConsumption_MWh;
			di = new DataItem();
			di.setValue(weekendConsumption_MWh);
			pl_consumptionChartWeekend.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));
			// Weekday
			weekdayConsumption_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AFC).getIntegral_MWh() - weekendConsumption_MWh;
			totalWeekdayConsumption_MWh += weekdayConsumption_MWh;
			di = new DataItem();
			di.setValue(weekdayConsumption_MWh);
			pl_consumptionChartWeekday.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));
		}
		else {
			// Weekend
			weekendProduction_MWh = dataObject.getRapidRunData().am_assetFlowsWeekend_kW.get(AFC).getIntegral_MWh();
			totalWeekendProduction_MWh += weekendProduction_MWh;
			di = new DataItem();
			di.setValue(weekendProduction_MWh);
			pl_productionChartWeekend.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));	
			// Weekday
			weekdayProduction_MWh = dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AFC).getIntegral_MWh() - weekendProduction_MWh;
			totalWeekdayProduction_MWh += weekdayProduction_MWh;
			di = new DataItem();
			di.setValue(weekdayProduction_MWh);
			pl_productionChartWeekday.addDataItem(di, uI_Results.lm_assetFlowLabels.get(AFC), uI_Results.cm_assetFlowColors.get(AFC));	
		}
	}
}

double chartScale_MWh = max(max(totalWeekdayProduction_MWh, totalWeekendProduction_MWh), max(totalWeekdayConsumption_MWh, totalWeekendConsumption_MWh));
pl_productionChartWeekday.setFixedScale(chartScale_MWh);
pl_productionChartWeekend.setFixedScale(chartScale_MWh);
pl_consumptionChartWeekday.setFixedScale(chartScale_MWh);
pl_consumptionChartWeekend.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToInt(totalWeekdayProduction_MWh*1000) + " kWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToInt(totalWeekdayConsumption_MWh*1000) + " kWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToInt(totalWeekendProduction_MWh*1000) + " kWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToInt(totalWeekendConsumption_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToInt(totalWeekdayProduction_MWh) + " MWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToInt(totalWeekdayConsumption_MWh) + " MWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToInt(totalWeekendProduction_MWh) + " MWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToInt(totalWeekendConsumption_MWh) + " MWh");
} else {
	t_productionTextWeekday.setText("Opwek" + System.lineSeparator() + roundToDecimal(totalWeekdayProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekday.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalWeekdayConsumption_MWh/1000,1) + " GWh");
	t_productionTextWeekend.setText("Opwek" + System.lineSeparator() + roundToDecimal(totalWeekendProduction_MWh/1000, 1) + " GWh");
	t_consumptionTextWeekend.setText("Gebruik" + System.lineSeparator() + roundToDecimal(totalWeekendConsumption_MWh/1000,1) + " GWh");
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
  protected static final Font _button_electricityChart_Font = _radio_energyType_Font;
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
  @AnyLogicInternalCodegenAPI
  protected static final int _button_electricityChart = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 73;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 74;

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
	  level.addAll(rectangle, radio_energyType, radio_period, gr_Total, gr_SummerWinter, gr_DayNight, gr_WeekdayWeekend, gr_monthlyTotals, button_electricityChart);
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
      case _button_electricityChart: {
          ShapeButton self = this.button_electricityChart;
// We were showing the electricity self consumption charts before and will switch to the assets charts
if (v_showingElectricitySelfConsumption) {
	button_electricityChart.setText("Zelfconsumptie");
}
// We were showing the electricity asset charts before and will switch to the self consumption charts
else {
	button_electricityChart.setText("Apparaten");
}

v_showingElectricitySelfConsumption = !v_showingElectricitySelfConsumption;
f_setCharts(); 
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

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _radio_energyType_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    boolean _visible = 
uI_Results.v_selectedObjectScope != OL_ResultScope.GRIDNODE 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
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
  protected ShapeButton button_electricityChart;
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
ChartBars.this, true, 80.0, 0.0,
			300.0, 40.0,
            black, true,
_radio_energyType_Font, false,
            new String[]{"Elektriciteit", "Warmte", "Alle energiedragers", } ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _radio_energyType_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

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
ChartBars.this, true, 20.0, 35.0,
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
ChartBars.this, true, 100.0, 350.0,
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
ChartBars.this, true, 100.0, 380.0,
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
    button_electricityChart = new ShapeButton(
ChartBars.this, true, 20.0, 700.0,
			110.0, 30.0,
            black, true,
_button_electricityChart_Font,
			"Apparaten" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_electricityChart, 0 );
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
        SHAPE_DRAW_2D, true,-120.0, -20.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextYear_Font, ALIGNMENT_RIGHT );
    t_consumptionTextYear = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -170.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextYear_Font, ALIGNMENT_RIGHT );
    t_productionTextSummer = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -100.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextSummer_Font, ALIGNMENT_RIGHT );
    t_consumptionTextSummer = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -240.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextSummer_Font, ALIGNMENT_RIGHT );
    t_topBarplotText1 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, -170.0, 0.0, 0.0,
        black,"Zomer week",
        _t_topBarplotText1_Font, ALIGNMENT_CENTER );
    t_productionTextWinter = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 220.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextWinter_Font, ALIGNMENT_RIGHT );
    t_consumptionTextWinter = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 70.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextWinter_Font, ALIGNMENT_RIGHT );
    t_bottomBarplotText1 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, 143.0, 0.0, 0.0,
        black,"Winter week",
        _t_bottomBarplotText1_Font, ALIGNMENT_CENTER );
    t_productionTextDay = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -100.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextDay_Font, ALIGNMENT_RIGHT );
    t_consumptionTextDay = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -240.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextDay_Font, ALIGNMENT_RIGHT );
    t_topBarplotText2 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, -170.0, 0.0, 0.0,
        black,"Dag\n",
        _t_topBarplotText2_Font, ALIGNMENT_CENTER );
    t_productionTextNight = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 220.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextNight_Font, ALIGNMENT_RIGHT );
    t_consumptionTextNight = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 70.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextNight_Font, ALIGNMENT_RIGHT );
    t_bottomBarplotText2 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, 143.0, 0.0, 0.0,
        black,"Nacht",
        _t_bottomBarplotText2_Font, ALIGNMENT_CENTER );
    t_productionTextWeekday = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -100.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextWeekday_Font, ALIGNMENT_RIGHT );
    t_consumptionTextWeekday = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -240.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextWeekday_Font, ALIGNMENT_RIGHT );
    t_topBarplotText3 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, -170.0, 0.0, 0.0,
        black,"Weekdagen\n",
        _t_topBarplotText3_Font, ALIGNMENT_CENTER );
    t_productionTextWeekend = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 220.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextWeekend_Font, ALIGNMENT_RIGHT );
    t_consumptionTextWeekend = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 70.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextWeekend_Font, ALIGNMENT_RIGHT );
    t_bottomBarplotText3 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, 143.0, 0.0, 0.0,
        black,"Weekenden",
        _t_bottomBarplotText3_Font, ALIGNMENT_CENTER );
    t_monthlyProductionYLabel = new ShapeText(
        SHAPE_DRAW_2D, true,-195.0, 170.0, 0.0, 1.5707963267948966,
        black,"Export [MWh]",
        _t_monthlyProductionYLabel_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel = new ShapeText(
        SHAPE_DRAW_2D, true,-153.0, 264.0, 0.0, 5.235987755982989,
        black,"jan",
        _t_monthlyProductionXLabel_Font, ALIGNMENT_CENTER );
    t_monthlyConsumptionYLabel = new ShapeText(
        SHAPE_DRAW_2D, true,-195.0, -90.0, 0.0, 1.5707963267948966,
        black,"Import [MWh]",
        _t_monthlyConsumptionYLabel_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel1 = new ShapeText(
        SHAPE_DRAW_2D, true,-123.0, 264.0, 0.0, 5.235987755982989,
        black,"feb",
        _t_monthlyProductionXLabel1_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel2 = new ShapeText(
        SHAPE_DRAW_2D, true,-93.0, 264.0, 0.0, 5.235987755982989,
        black,"mrt",
        _t_monthlyProductionXLabel2_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel3 = new ShapeText(
        SHAPE_DRAW_2D, true,-3.0, 264.0, 0.0, 5.235987755982989,
        black,"jun",
        _t_monthlyProductionXLabel3_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel4 = new ShapeText(
        SHAPE_DRAW_2D, true,-33.0, 264.0, 0.0, 5.235987755982989,
        black,"mei",
        _t_monthlyProductionXLabel4_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel5 = new ShapeText(
        SHAPE_DRAW_2D, true,-63.0, 264.0, 0.0, 5.235987755982989,
        black,"apr",
        _t_monthlyProductionXLabel5_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel6 = new ShapeText(
        SHAPE_DRAW_2D, true,177.0, 264.0, 0.0, 5.235987755982989,
        black,"dec",
        _t_monthlyProductionXLabel6_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel7 = new ShapeText(
        SHAPE_DRAW_2D, true,57.0, 264.0, 0.0, 5.235987755982989,
        black,"aug",
        _t_monthlyProductionXLabel7_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel8 = new ShapeText(
        SHAPE_DRAW_2D, true,27.0, 264.0, 0.0, 5.235987755982989,
        black,"jul",
        _t_monthlyProductionXLabel8_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel9 = new ShapeText(
        SHAPE_DRAW_2D, true,117.0, 264.0, 0.0, 5.235987755982989,
        black,"okt",
        _t_monthlyProductionXLabel9_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel10 = new ShapeText(
        SHAPE_DRAW_2D, true,147.0, 264.0, 0.0, 5.235987755982989,
        black,"nov",
        _t_monthlyProductionXLabel10_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel11 = new ShapeText(
        SHAPE_DRAW_2D, true,87.0, 264.0, 0.0, 5.235987755982989,
        black,"sep",
        _t_monthlyProductionXLabel11_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel12 = new ShapeText(
        SHAPE_DRAW_2D, true,-153.0, -6.0, 0.0, 5.235987755982989,
        black,"jan",
        _t_monthlyProductionXLabel12_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel13 = new ShapeText(
        SHAPE_DRAW_2D, true,-123.0, -6.0, 0.0, 5.235987755982989,
        black,"feb",
        _t_monthlyProductionXLabel13_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel14 = new ShapeText(
        SHAPE_DRAW_2D, true,-93.0, -6.0, 0.0, 5.235987755982989,
        black,"mrt",
        _t_monthlyProductionXLabel14_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel15 = new ShapeText(
        SHAPE_DRAW_2D, true,-3.0, -6.0, 0.0, 5.235987755982989,
        black,"jun",
        _t_monthlyProductionXLabel15_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel16 = new ShapeText(
        SHAPE_DRAW_2D, true,-33.0, -6.0, 0.0, 5.235987755982989,
        black,"mei",
        _t_monthlyProductionXLabel16_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel17 = new ShapeText(
        SHAPE_DRAW_2D, true,-63.0, -6.0, 0.0, 5.235987755982989,
        black,"apr",
        _t_monthlyProductionXLabel17_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel18 = new ShapeText(
        SHAPE_DRAW_2D, true,177.0, -6.0, 0.0, 5.235987755982989,
        black,"dec",
        _t_monthlyProductionXLabel18_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel19 = new ShapeText(
        SHAPE_DRAW_2D, true,57.0, -6.0, 0.0, 5.235987755982989,
        black,"aug",
        _t_monthlyProductionXLabel19_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel20 = new ShapeText(
        SHAPE_DRAW_2D, true,27.0, -6.0, 0.0, 5.235987755982989,
        black,"jul",
        _t_monthlyProductionXLabel20_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel21 = new ShapeText(
        SHAPE_DRAW_2D, true,117.0, -6.0, 0.0, 5.235987755982989,
        black,"okt",
        _t_monthlyProductionXLabel21_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel22 = new ShapeText(
        SHAPE_DRAW_2D, true,147.0, -6.0, 0.0, 5.235987755982989,
        black,"nov",
        _t_monthlyProductionXLabel22_Font, ALIGNMENT_CENTER );
    t_monthlyProductionXLabel23 = new ShapeText(
        SHAPE_DRAW_2D, true,87.0, -6.0, 0.0, 5.235987755982989,
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
ChartBars.this, true, -160.0, -60.0,
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
ChartBars.this, true, -160.0, -210.0,
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
ChartBars.this, true, -160.0, -140.0,
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
ChartBars.this, true, -160.0, -280.0,
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
ChartBars.this, true, -160.0, 180.0,
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
ChartBars.this, true, -160.0, 30.0,
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
ChartBars.this, true, -160.0, -140.0,
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
ChartBars.this, true, -160.0, -280.0,
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
ChartBars.this, true, -160.0, 180.0,
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
ChartBars.this, true, -160.0, 30.0,
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
ChartBars.this, true, -160.0, -140.0,
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
ChartBars.this, true, -160.0, -280.0,
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
ChartBars.this, true, -160.0, 180.0,
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
ChartBars.this, true, -160.0, 30.0,
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
ChartBars.this, true, -210.0, 80.0,
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
ChartBars.this, true, -210.0, -190.0,
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
    gr_Total = new ShapeGroup( ChartBars.this, SHAPE_DRAW_2D3D, true, 230.0, 350.0, 0.0, 0.0
	
	     , pl_productionChartBalanceTotal
	     , pl_consumptionChartBalanceTotal
	     , t_productionTextYear
	     , t_consumptionTextYear
	     , button_monthlyDetails );
    }
    {
    gr_SummerWinter = new ShapeGroup( ChartBars.this, SHAPE_DRAW_2D3D, true, 690.0, 380.0, 0.0, 0.0
	
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
    gr_DayNight = new ShapeGroup( ChartBars.this, SHAPE_DRAW_2D3D, true, 1120.0, 380.0, 0.0, 0.0
	
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
    gr_WeekdayWeekend = new ShapeGroup( ChartBars.this, SHAPE_DRAW_2D3D, true, 1550.0, 380.0, 0.0, 0.0
	
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
    gr_monthlyTotals = new ShapeGroup( ChartBars.this, SHAPE_DRAW_2D3D, true, 2040.0, 320.0, 0.0, 0.0
	
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
  public ChartBars( Engine engine, Agent owner, AgentList<? extends ChartBars> ownerPopulation ) {
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
  public ChartBars() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartBars_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartBars.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartBars.class );
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
    setupPlainVariables_ChartBars_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartBars_xjal() {
    v_showingElectricitySelfConsumption = 
true 
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

  public AgentList<? extends ChartBars> getPopulation() {
    return (AgentList<? extends ChartBars>) super.getPopulation();
  }

  public List<? extends ChartBars> agentsInRange( double distance ) {
    return (List<? extends ChartBars>) super.agentsInRange( distance );
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

  // Additional class code

public ShapeButton getButton_monthlyDetails(){
	return button_monthlyDetails;
}
 
public ShapeRadioButtonGroup getRadio_period(){
	return radio_period;
} 
  // End of additional class code

}
