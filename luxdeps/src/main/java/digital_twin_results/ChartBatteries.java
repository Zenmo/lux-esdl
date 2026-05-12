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

import com.querydsl.core.group.Group;
import java.util.EnumSet;
import java.text.DecimalFormat;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; 

public class ChartBatteries extends digital_twin_results.ChartArea
{
  // Parameters
  // Plain Variables

  public 
ShapeText 
 v_weekLabel;
  public 
double 
 v_cycleCount;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartBatteries.class );

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
  protected static final int _STATECHART_COUNT_xjal = digital_twin_results.ChartArea._STATECHART_COUNT_xjal + 0;


  // Functions

  private void f_addSOC_total( I_EnergyData dataObject ) { 


if (dataObject.getRapidRunData().assetsMetaData.totalInstalledBatteryStorageCapacity_MWh>0){
	double startTime_h = 0;
	SOCChart_year.addDataSet(dataObject.getRapidRunData().getBatteriesSOCts_fr().getDataSet(startTime_h), "Batterij SOC", uI_Results.v_electricityBaseloadDemandColor);
}
 
  }

  private void f_addSOC_live( I_EnergyData dataObject ) { 

SOCChart_week.addDataSet(dataObject.getLiveData().data_batterySOC_fr, "Batterij SOC", uI_Results.v_electricityBaseloadDemandColor);
 
  }

  private void f_addSOC_Week( I_EnergyData dataObject, boolean isSummerWeek ) { 

if (dataObject.getRapidRunData().assetsMetaData.totalInstalledBatteryStorageCapacity_MWh>0){
	if (dataObject.getRapidRunData().getStoreTotalAssetFlows()) {
		double dataSetStartTime_h = uI_Results.energyModel.p_timeParameters.getRunStartTime_h(); //
		double peakTime_h;
		double peak_kW;
	if (isSummerWeek) {
		peakTime_h = dataObject.getRapidRunData().getLowestBalanceTime_h(OL_EnergyCarriers.ELECTRICITY);
		peak_kW = -1 * dataObject.getRapidRunData().getLowestBalance_kW(OL_EnergyCarriers.ELECTRICITY);
	} else {
		peakTime_h = dataObject.getRapidRunData().getHighestBalanceTime_h(OL_EnergyCarriers.ELECTRICITY);
		peak_kW = dataObject.getRapidRunData().getHighestBalance_kW(OL_EnergyCarriers.ELECTRICITY);
	}
		//traceln("Plotting peak feedin week instead of fixed summer week! Peak feedin occured at: %s hours, power was: %s", peakFeedinTime_h, peakFeedin_kW);
		
		// Output the result
		/*String dateTimeString = f_getDateTimeFromHour(peakTime_h);
	    if (isSummerWeek) {
		    if (peak_kW > 0) {
				v_weekLabel.setText("Hoogste invoeding op: " + dateTimeString);
			} else {
				v_weekLabel.setText("Laagste afname op: " + dateTimeString);
			}
		} else {
			if (peak_kW > 0) {
				v_weekLabel.setText("Hoogste afname op: " + dateTimeString);
			} else {
				v_weekLabel.setText("Laagste invoeding op: " + dateTimeString);
			}
		}*/
		double peakWeekStart_h = dataObject.getRapidRunData().getPeakWeekStart_h(peakTime_h);
		SOCChart_week.addDataSet(dataObject.getRapidRunData().getBatteriesSOCts_fr().getDataSet(dataSetStartTime_h, peakWeekStart_h, peakWeekStart_h+24*7), "Batterij SOC", uI_Results.v_electricityBaseloadDemandColor);
	} else {
		if (isSummerWeek){
			double startTime_h = uI_Results.energyModel.p_timeParameters.getStartOfSummerWeek_h() - uI_Results.energyModel.p_timeParameters.getRunStartTime_h();
			if (startTime_h<0) {
				startTime_h +=8760;
			}
			
			SOCChart_week.addDataSet(dataObject.getRapidRunData().ts_summerWeekBatteriesSOC_fr.getDataSet(startTime_h), "Batterij SOC", uI_Results.v_electricityBaseloadDemandColor);
		} else {
			double startTime_h = uI_Results.energyModel.p_timeParameters.getStartOfWinterWeek_h() - uI_Results.energyModel.p_timeParameters.getRunStartTime_h();
			if (startTime_h<0) {
				startTime_h +=8760;
			}
			
			SOCChart_week.addDataSet(dataObject.getRapidRunData().ts_winterWeekBatteriesSOC_fr.getDataSet(startTime_h), "Batterij SOC", uI_Results.v_electricityBaseloadDemandColor);
		
		}
	}
} 
  }

  private void f_resetCharts(  ) { 

gr_week.setVisible(false);
gr_year.setVisible(false);
gr_batteryCycles.setVisible(false);
gr_batteryLifetime.setVisible(false);
SOCChart_week.removeAll();
SOCChart_year.removeAll();
plot_netload_week.removeAll();
plot_netload_year.removeAll();
 
  }

  public void f_setChartsBatteries(  ) { 

f_resetCharts();
I_EnergyData data = uI_Results.f_getSelectedObjectData();

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 60, true);

//Set battery capacity
f_addBatteryCapacity(data);

/*
String[] stringArray = {"live", "week 1", "week 2", "jaar"};
ShapeRadioButtonGroup radio_period2 = new ShapeRadioButtonGroup(this.presentation.getPresentable(), true, 50, 100, 300, 50, Color.BLACK, true, new Font("Calibri", 0, 15), false, stringArray){
	@Override
	public void action() {
		f_setChartsBatteries();
	}
};
*/

//Set correct period chart
switch(radio_period.getValue()){
	case 0:
		gr_week.setVisible(true);
		f_addSOC_live(data);
		f_addBatteryGridLoad_live(data);
		break;
	case 1:
		gr_week.setVisible(true);
		f_addSOC_Week(data,false);
		f_addElectricityGridLoad_Week(data, false);//f_addBatteryNetLoad_summerWeek(data);
		f_addBatteryKPIs_Week(data, false);
		break;
	case 2:
		gr_week.setVisible(true);
		f_addSOC_Week(data,true);
		f_addElectricityGridLoad_Week(data, true);
		f_addBatteryKPIs_Week(data, true);
		break;
	case 3:
		gr_year.setVisible(true);
		f_addSOC_total(data);
		f_addBatteryNetLoad_total(data);
		f_addBatteryKPIs_total(data);
		break;
}


 
  }

  void f_addBatteryGridLoad_live( I_EnergyData dataObject ) { 

txt_netload_week.setText("Netto Belasting net");

String deliveryCapacityLabel = "Geschatte piek leveringscapaciteit";
String feedinCapacityLabel = "Geschatte piek terugleveringscapaciteit";
Color  deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;
Color  feedinCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;

if(dataObject.getLiveData().connectionMetaData.getContractedDeliveryCapacityKnown()){
	deliveryCapacityLabel = "Piek leveringscapaciteit";
	deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_known;
}
if(dataObject.getLiveData().connectionMetaData.getContractedFeedinCapacityKnown()){
	feedinCapacityLabel = "Piek terugleveringscapaciteit";
	feedinCapacityColor		= uI_Results.v_electricityCapacityColor_known;
}

plot_netload_week.addDataSet(dataObject.getLiveData().data_gridCapacityDemand_kW, deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_netload_week.addDataSet(dataObject.getLiveData().data_gridCapacitySupply_kW, feedinCapacityLabel, feedinCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);

plot_netload_week.addDataSet(dataObject.getLiveData().data_liveElectricityBalance_kW, "Netto vermogen", uI_Results.v_electricityDemandColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 4.0, Chart.PointStyle.POINT_NONE);
 
  }

  void f_addBatteryNetLoad_total( I_EnergyData dataObject ) { 

group_netload_year.setVisible(true);

//plot_netload_year.addDataSet(dataObject.getRapidRunData().acc_summerWeekDeliveryCapacity_kW.getDataSet(), "Piek leveringscapaciteit", uI_Results.v_electricityCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
//plot_netload_year.addDataSet(dataObject.getRapidRunData().acc_summerWeekFeedinCapacity_kW.getDataSet(dataSetWeekStartTime_h), "Piek terugleveringscapaciteit", uI_Results.v_electricityCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_netload_year.addDataSet(dataObject.getRapidRunData().am_totalBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(0), "Netto vermogen", uI_Results.v_electricityDemandColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1.5, Chart.PointStyle.POINT_NONE);

//int maxValue = roundToInt(max(dataObject.v_dataNetLoadLiveWeek_kW.getYMax(), dataObject.v_dataElectricityDemandCapacityLiveWeek_kW.getYMax()));
//int minValue = roundToInt(min(dataObject.v_dataNetLoadLiveWeek_kW.getYMin(), dataObject.v_dataElectricitySupplyCapacityLiveWeek_kW.getYMin()));
//plot_netload_year.setFixedVerticalScale(minValue + minValue * 0.15, maxValue + maxValue * 0.15);
 
  }

  void f_addBatteryKPIs_Week( I_EnergyData dataObject, boolean isSummerWeek ) { 

gr_batteryCycles.setVisible(true);

DecimalFormat df_1decimal = new DecimalFormat("0.0");
if(dataObject.getRapidRunData().assetsMetaData.totalInstalledBatteryStorageCapacity_MWh > 0){
	if (isSummerWeek) {
		t_batteryCycles.setText(df_1decimal.format(dataObject.getRapidRunData().getSummerWeekBatteryCycles()));
	} else {
		t_batteryCycles.setText(df_1decimal.format(dataObject.getRapidRunData().getWinterWeekBatteryCycles()));
	}
}
else{
	t_batteryCycles.setText("0");
}

//Add battery lifetime
f_addBatteryLifetime(dataObject); 
  }

  void f_addBatteryKPIs_total( I_EnergyData dataObject ) { 

gr_batteryCycles.setVisible(true);

DecimalFormat df_1decimal = new DecimalFormat("0.0");
if(dataObject.getRapidRunData().assetsMetaData.totalInstalledBatteryStorageCapacity_MWh > 0){
	t_batteryCycles.setText(df_1decimal.format(dataObject.getRapidRunData().getTotalBatteryCycles()));
}
else{
	t_batteryCycles.setText("0");
}

//Add battery lifetime
f_addBatteryLifetime(dataObject); 
  }

  void f_addBatteryCapacity( I_EnergyData dataObject ) { 

DecimalFormat df_1decimal = new DecimalFormat("0.0");
DecimalFormat df_2decimal = new DecimalFormat("0.00");

double batteryStorageCapacity = 0;
if(radio_period.getValue() == 0){
	batteryStorageCapacity = dataObject.getLiveData().assetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
}
else{
	batteryStorageCapacity = dataObject.getRapidRunData().assetsMetaData.totalInstalledBatteryStorageCapacity_MWh;
}
String batteryStorageCapacity_unitString = "[MWh]";

if(batteryStorageCapacity < 1){
	batteryStorageCapacity_unitString = "[kWh]";
	batteryStorageCapacity = batteryStorageCapacity*1000;
}
else if(batteryStorageCapacity < 1000){
	batteryStorageCapacity_unitString = "[MWh]";
	batteryStorageCapacity = batteryStorageCapacity;
}
else if(batteryStorageCapacity > 1000){
	batteryStorageCapacity_unitString = "[GWh]";
	batteryStorageCapacity = batteryStorageCapacity/1000;
}

batteryStorageCapacity = max(0, batteryStorageCapacity);

if(batteryStorageCapacity > 100){
	t_totalBatteryCapacity.setText(roundToInt(batteryStorageCapacity));
}
else if(batteryStorageCapacity > 10){
	t_totalBatteryCapacity.setText(df_1decimal.format(batteryStorageCapacity));
}
else{
	t_totalBatteryCapacity.setText(df_2decimal.format(batteryStorageCapacity));
}
	
t_batteryCapacityLabel.setText("Batterij capaciteit " + batteryStorageCapacity_unitString);
 
  }

  private 
String 
 f_getDateTimeFromHour( double peakTime_h ) { 

int dayOfYear = (int)Math.floor(peakTime_h / 24) + 1;
int hourOfDay = roundToInt(peakTime_h % 24);
LocalDate date = LocalDate.ofYearDay(uI_Results.energyModel.p_timeParameters.getStartYear(), dayOfYear);
LocalDateTime dateTime = date.atStartOfDay().plusHours(hourOfDay);

// Output the result
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
return dateTime.format(formatter); 
  }

  void f_addElectricityGridLoad_Week( I_EnergyData dataObject, boolean isSummerWeek ) { 

String deliveryCapacityLabel = "Geschatte piek leveringscapaciteit";
String feedinCapacityLabel = "Geschatte piek terugleveringscapaciteit";
Color  deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;
Color  feedinCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;

if(dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacityKnown()){
	deliveryCapacityLabel = "Piek leveringscapaciteit";
	deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_known;
}
if(dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacityKnown()){
	feedinCapacityLabel = "Piek terugleveringscapaciteit";
	feedinCapacityColor		= uI_Results.v_electricityCapacityColor_known;
}

//Add datasets to plot
double startTime_h = uI_Results.energyModel.p_timeParameters.getStartOfSummerWeek_h() - uI_Results.energyModel.p_timeParameters.getRunStartTime_h();


if (dataObject.getRapidRunData().getStoreTotalAssetFlows()) { // 
	double dataSetStartTime_h = uI_Results.energyModel.p_timeParameters.getRunStartTime_h(); //
	double peakTime_h;
	double peak_kW;
	if (isSummerWeek) {
		peakTime_h = dataObject.getRapidRunData().getLowestBalanceTime_h(OL_EnergyCarriers.ELECTRICITY);
		peak_kW = -1 * dataObject.getRapidRunData().getLowestBalance_kW(OL_EnergyCarriers.ELECTRICITY);
	} else {
		peakTime_h = dataObject.getRapidRunData().getHighestBalanceTime_h(OL_EnergyCarriers.ELECTRICITY);
		peak_kW = dataObject.getRapidRunData().getHighestBalance_kW(OL_EnergyCarriers.ELECTRICITY);
	}

	double peakWeekStart_h = dataObject.getRapidRunData().getPeakWeekStart_h(peakTime_h);
	String dateTimeString = f_getDateTimeFromHour(peakTime_h);
    if (isSummerWeek) {
	    if (peak_kW > 0) {
			txt_netload_week.setText("Hoogste invoeding op: " + dateTimeString);
		} else {
			txt_netload_week.setText("Laagste afname op: " + dateTimeString);
		}
	} else {
		if (peak_kW > 0) {
			txt_netload_week.setText("Hoogste afname op: " + dateTimeString);
		} else {
			txt_netload_week.setText("Laagste invoeding op: " + dateTimeString);
		}
	}
	v_weekLabel.setX(80);
	if (isSummerWeek) {
		plot_netload_week.addDataSet(dataObject.getRapidRunData().acc_summerWeekDeliveryCapacity_kW.getDataSet(peakWeekStart_h-uI_Results.energyModel.p_timeParameters.getRunStartTime_h()), deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_netload_week.addDataSet(dataObject.getRapidRunData().acc_summerWeekFeedinCapacity_kW.getDataSet(peakWeekStart_h-uI_Results.energyModel.p_timeParameters.getRunStartTime_h()), feedinCapacityLabel, feedinCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
	} else {
		plot_netload_week.addDataSet(dataObject.getRapidRunData().acc_winterWeekDeliveryCapacity_kW.getDataSet(peakWeekStart_h-uI_Results.energyModel.p_timeParameters.getRunStartTime_h()), deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_netload_week.addDataSet(dataObject.getRapidRunData().acc_winterWeekFeedinCapacity_kW.getDataSet(peakWeekStart_h-uI_Results.energyModel.p_timeParameters.getRunStartTime_h()), feedinCapacityLabel, feedinCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
	}
	plot_netload_week.addDataSet(dataObject.getRapidRunData().am_totalBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(uI_Results.energyModel.p_timeParameters.getRunStartTime_h(),peakWeekStart_h, peakWeekStart_h+24*7), "Netto vermogen", uI_Results.v_electricityDemandColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 4.0, Chart.PointStyle.POINT_NONE);
} else {
	double dataSetWeekStartTime_h;
	if (isSummerWeek) {
		dataSetWeekStartTime_h = uI_Results.energyModel.p_timeParameters.getStartOfSummerWeek_h() - uI_Results.energyModel.p_timeParameters.getRunStartTime_h();
	} else {
		dataSetWeekStartTime_h = uI_Results.energyModel.p_timeParameters.getStartOfWinterWeek_h() - uI_Results.energyModel.p_timeParameters.getRunStartTime_h();
	}
	if (dataSetWeekStartTime_h<0) {
		dataSetWeekStartTime_h +=8760;
	}
	if (isSummerWeek) {
		plot_netload_week.addDataSet(dataObject.getRapidRunData().acc_summerWeekDeliveryCapacity_kW.getDataSet(dataSetWeekStartTime_h), deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_netload_week.addDataSet(dataObject.getRapidRunData().acc_summerWeekFeedinCapacity_kW.getDataSet(dataSetWeekStartTime_h), feedinCapacityLabel, feedinCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
	
		//plot_netload_week.addDataSet(dataObject.getRapidRunData().acc_summerWeekFeedinCapacity_kW.getDataSet(startTime_h), feedinCapacityLabel, feedinCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_netload_week.addDataSet(dataObject.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(dataSetWeekStartTime_h), "Netto vermogen", uI_Results.v_electricityDemandColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 4.0, Chart.PointStyle.POINT_NONE);
	} else {
		plot_netload_week.addDataSet(dataObject.getRapidRunData().acc_winterWeekDeliveryCapacity_kW.getDataSet(dataSetWeekStartTime_h), deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_netload_week.addDataSet(dataObject.getRapidRunData().acc_winterWeekFeedinCapacity_kW.getDataSet(dataSetWeekStartTime_h), feedinCapacityLabel, feedinCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
	
		//plot_netload_week.addDataSet(dataObject.getRapidRunData().acc_summerWeekFeedinCapacity_kW.getDataSet(startTime_h), feedinCapacityLabel, feedinCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_netload_week.addDataSet(dataObject.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(dataSetWeekStartTime_h), "Netto vermogen", uI_Results.v_electricityDemandColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 4.0, Chart.PointStyle.POINT_NONE);
	}
}

/*
//Specific coop plot additions
if (dataObject.getScope() == OL_ResultScope.ENERGYCOOP ) {

	if(uI_Results.b_showGroupContractValues) {
		plot_netload_week.addDataSet(uI_Results.f_createFlatDataset(startTime_h, 168, ((EnergyCoop)dataObject.getRapidRunData().parentAgent).f_getGroupContractDeliveryCapacity_kW()), "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_netload_week.addDataSet(uI_Results.f_createFlatDataset(startTime_h, 168, ((EnergyCoop)dataObject.getRapidRunData().parentAgent).f_getGroupContractFeedinCapacity_kW()), "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
	}
	if (b_subdivideEnergyCoopFlows) {
		List<GridConnection> memberGridConnections = ((EnergyCoop)dataObject.getRapidRunData().parentAgent).f_getAllChildMemberGridConnections();
		for (GridConnection GC : memberGridConnections) {
			plot_netload_week.addDataSet(GC.v_rapidRunData.am_summerWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(uI_Results.energyModel.p_startOfSummerWeek_h), GC.p_gridConnectionID, blue, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1.5, Chart.PointStyle.POINT_NONE);
		}
	}
}*/


//gr_netLoadWeek.setVisible(true);
 
  }

  void f_addBatteryLifetime( I_EnergyData dataObject ) { 

if (dataObject.getRapidRunData().assetsMetaData.totalInstalledBatteryStorageCapacity_MWh>0){
	gr_batteryLifetime.setVisible(true);
	DecimalFormat df_2decimal = new DecimalFormat("0.00");
	
	double lifetimeBattery_yr = f_calculateBatteryLifetime_yr(dataObject, dataObject.getRapidRunData().getBatteriesSOCts_fr().getTimeSeries());
	t_batteryLifetime.setText(df_2decimal.format(lifetimeBattery_yr));
}
else{
	t_batteryLifetime.setText("-");
} 
  }

  
double 
 f_calculateBatteryLifetime_yr( I_EnergyData dataObject, double[] arraySoC_fr ) { 

double averageDoD = f_calculateAverageDoD_fr(arraySoC_fr);
    	 
double totalYearlyCycles = dataObject.getRapidRunData().getTotalBatteryCycles(); // Defined that total annual energy charged/battery capacity
 
// function and parameters (li-ion) are extracted from source:
// https://www.researchgate.net/publication/330142356_Optimal_Operational_Planning_of_Scalable_DC_Microgrid_with_Demand_Response_Islanding_and_Battery_Degradation_Cost_Considerations
double alpha = -5440.35;
double beta = 1191.54;
 
double batteryCycleLife_cycles = alpha * Math.log(averageDoD) + beta;
//traceln("Battery Lifetime from totalYearlyCycles is " + batteryCycleLife_cycles/totalYearlyCycles);
double lifetimeBattery_yr = batteryCycleLife_cycles/v_cycleCount;
return lifetimeBattery_yr;
 
  }

  
double 
 f_calculateAverageDoD_fr( double[] arraySoC_fr ) { 

v_cycleCount = 0; // Cycle is NOT defined as amount of chargeEnergy/batteryCapacity; but rather as a count of activities
double cumulativeDoD = 0;

ArrayList<Double> localBatteryTurningPoints_fr = f_calculateTurningPoints(arraySoC_fr);

while (localBatteryTurningPoints_fr.size() > 2) {
	boolean hasFoundCycle = false;
	for (int i=0; i < localBatteryTurningPoints_fr.size()-2; i++) {
		
		if (abs(localBatteryTurningPoints_fr.get(i+1)-localBatteryTurningPoints_fr.get(i+2)) <= abs(localBatteryTurningPoints_fr.get(i)-localBatteryTurningPoints_fr.get(i+1))) { //abs(Y-Z) <= abs(Z-Y)
			cumulativeDoD += abs(localBatteryTurningPoints_fr.get(i+1)-localBatteryTurningPoints_fr.get(i+2));
			localBatteryTurningPoints_fr.remove(i+2); //Remove Z first, otherwise order changes
			localBatteryTurningPoints_fr.remove(i+1); //Remove Y
			v_cycleCount += 1; //Remove 2 point-> 2lines -> 2 half cycles -> 1 full cycle 
			hasFoundCycle = true;
			break;
			// charge or discharge is or is not included in DoD -> TBD; so amountOfCycles could be 0.5 (if we had additional while loop) or 1
		}
	}
	if (!hasFoundCycle) {
		break; //fail safe to prevent stuck in loop
	}
}

//Add final residual half-cycle
if (localBatteryTurningPoints_fr.size() > 1) {
	cumulativeDoD += abs(localBatteryTurningPoints_fr.get(0)-localBatteryTurningPoints_fr.get(1));
	v_cycleCount += 0.5;
}

double averageDoD = cumulativeDoD/v_cycleCount;
return averageDoD; 
  }

  
ArrayList<Double> 
 f_calculateTurningPoints( double[] arraySoC_fr ) { 

double[] previousTwoBatterySoC_fr = new double[]{0,0};
ArrayList<Double> batteryTurningPoints_fr = new ArrayList();

for(double SoC_fr: arraySoC_fr) {
	SoC_fr = roundToDecimal(SoC_fr,8);

	if (previousTwoBatterySoC_fr[0] >= previousTwoBatterySoC_fr[1] && previousTwoBatterySoC_fr[1] < SoC_fr) {
		batteryTurningPoints_fr.add(previousTwoBatterySoC_fr[1]);
	}
	else if (previousTwoBatterySoC_fr[0] <= previousTwoBatterySoC_fr[1] && previousTwoBatterySoC_fr[1] > SoC_fr) {
		batteryTurningPoints_fr.add(previousTwoBatterySoC_fr[1]);
	}
	previousTwoBatterySoC_fr[0] = previousTwoBatterySoC_fr[1];
	previousTwoBatterySoC_fr[1] = SoC_fr;
}
return batteryTurningPoints_fr; 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _radio_period_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_batterySOCYear_Font = new Font("Calibri", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_yearProfile_ylabel_Font = new Font("Calibri", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_netload_year_Font = _txt_batterySOCYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_netload_ylabel_year_Font = _txt_yearProfile_ylabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_batterySOCLive_Font = _txt_batterySOCYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_weekProfile_ylabel_Font = _txt_yearProfile_ylabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_netload_week_Font = _txt_batterySOCYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_netload_ylabel_week_Font = _txt_yearProfile_ylabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalBatteryCapacity_Font = new Font("SansSerif", 1, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_batteryCapacityLabel_Font = new Font("Calibri", 1, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_batteryCycles_Font = _t_totalBatteryCapacity_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_batteryCycles_Font = _t_batteryCapacityLabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_batteryLifetime_Font = _t_totalBatteryCapacity_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_batteryLifetime_Font = _t_batteryCapacityLabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_radiobuttons = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_batterySOCYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_yearProfile_ylabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _group_year_SOC = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_netload_year = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_netload_ylabel_year = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _group_netload_year = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_year = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_batterySOCLive = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_weekProfile_ylabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _group_week_SOC = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_netload_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_netload_ylabel_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _group_netload_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_totalBatteryCapacity = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalBatteryCapacity = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_batteryCapacityLabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_batteryCycles = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_batteryCycles = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_batteryCycles = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_batteryCycles = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_batteryLifetime = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_batteryLifetime = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_batteryLifetime = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_batteryLifetime = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _SOCChart_year = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_netload_year = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _SOCChart_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_netload_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio_period = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;

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
	  level.addAll(rect_radiobuttons, radio_period, gr_year, gr_week, oval_totalBatteryCapacity, t_totalBatteryCapacity, t_batteryCapacityLabel, gr_batteryCycles, gr_batteryLifetime);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, int value ) {
    switch( _shape ) {
      case _radio_period: {
          ShapeRadioButtonGroup self = this.radio_period;
f_setChartsBatteries(); 
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
      case _radio_period: return 
0 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  protected ShapeRadioButtonGroup radio_period;
  protected TimeStackChart SOCChart_year;
  protected TimePlot plot_netload_year;
  protected TimeStackChart SOCChart_week;
  protected TimePlot plot_netload_week;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_radiobuttons_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_lineColor 
);
    shape.setLineWidth(
v_lineWidth 
);
  }
  
  protected ShapeRectangle rect_radiobuttons;
  protected ShapeText txt_batterySOCYear;
  protected ShapeText txt_yearProfile_ylabel;
  protected ShapeGroup group_year_SOC;
  protected ShapeText txt_netload_year;
  protected ShapeText txt_netload_ylabel_year;
  protected ShapeGroup group_netload_year;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_year_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
250 
);
    shape.setY(
390 
);
  }
  
  protected ShapeGroup gr_year;
  protected ShapeText txt_batterySOCLive;
  protected ShapeText txt_weekProfile_ylabel;
  protected ShapeGroup group_week_SOC;
  protected ShapeText txt_netload_week;
  protected ShapeText txt_netload_ylabel_week;
  protected ShapeGroup group_netload_week;
  protected ShapeGroup gr_week;
  protected ShapeOval oval_totalBatteryCapacity;
  protected ShapeText t_totalBatteryCapacity;
  protected ShapeText t_batteryCapacityLabel;
  protected ShapeOval oval_batteryCycles;
  protected ShapeText t_batteryCycles;
  protected ShapeText txt_batteryCycles;
  protected ShapeGroup gr_batteryCycles;
  protected ShapeOval oval_batteryLifetime;
  protected ShapeText t_batteryLifetime;
  protected ShapeText txt_batteryLifetime;
  protected ShapeGroup gr_batteryLifetime;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    radio_period = new ShapeRadioButtonGroup(
ChartBatteries.this, true, 50.0, 4.0,
			360.0, 40.0,
            black, true,
_radio_period_Font, false,
            new String[]{"Live Simulatie", "Hoogste afname", "Laagste afname", "Jaar Overzicht", } ) {

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
    rect_radiobuttons = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            lavender, whiteSmoke,
			460.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_radiobuttons_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_batterySOCYear = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, -150.0, 0.0, 0.0,
        black,"State of charge van de batterij(en)",
        _txt_batterySOCYear_Font, ALIGNMENT_CENTER );
    txt_yearProfile_ylabel = new ShapeText(
        SHAPE_DRAW_2D, true,-235.0, -80.0, 0.0, 1.5707963267948966,
        black,"SOC [-]",
        _txt_yearProfile_ylabel_Font, ALIGNMENT_LEFT );
    txt_netload_year = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -110.0, 0.0, 0.0,
        black,"Netto Belasting net",
        _txt_netload_year_Font, ALIGNMENT_CENTER );
    txt_netload_ylabel_year = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, -35.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _txt_netload_ylabel_year_Font, ALIGNMENT_LEFT );
    txt_batterySOCLive = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -250.0, 0.0, 0.0,
        black,"State of charge van de batterij(en)",
        _txt_batterySOCLive_Font, ALIGNMENT_CENTER );
    txt_weekProfile_ylabel = new ShapeText(
        SHAPE_DRAW_2D, true,-215.0, -180.0, 0.0, 1.5707963267948966,
        black,"SOC [-]",
        _txt_weekProfile_ylabel_Font, ALIGNMENT_LEFT );
    txt_netload_week = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -110.0, 0.0, 0.0,
        black,"Netto Belasting net",
        _txt_netload_week_Font, ALIGNMENT_CENTER );
    txt_netload_ylabel_week = new ShapeText(
        SHAPE_DRAW_2D, true,-215.0, -35.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _txt_netload_ylabel_week_Font, ALIGNMENT_LEFT );
    oval_totalBatteryCapacity = new ShapeOval(
       SHAPE_DRAW_2D3D, true,130.0, 693.0, 0.0, 0.0,
       null, cornflowerBlue,
	   45.0, 45.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_totalBatteryCapacity = new ShapeText(
        SHAPE_DRAW_2D, true,130.0, 677.0, 0.0, 0.0,
        white,"100",
        _t_totalBatteryCapacity_Font, ALIGNMENT_CENTER );
    t_batteryCapacityLabel = new ShapeText(
        SHAPE_DRAW_2D, true,130.0, 620.0, 0.0, 0.0,
        black,"Batterij capaciteit [MWh]",
        _t_batteryCapacityLabel_Font, ALIGNMENT_CENTER );
    oval_batteryCycles = new ShapeOval(
       SHAPE_DRAW_2D3D, true,5.0, 12.0, 0.0, 0.0,
       null, cornflowerBlue,
	   45.0, 45.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_batteryCycles = new ShapeText(
        SHAPE_DRAW_2D, true,5.0, -5.0, 0.0, 0.0,
        white,"100",
        _t_batteryCycles_Font, ALIGNMENT_CENTER );
    txt_batteryCycles = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -60.0, 0.0, 0.0,
        black,"Aantal batterij cycli",
        _txt_batteryCycles_Font, ALIGNMENT_CENTER );
    oval_batteryLifetime = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 12.0, 0.0, 0.0,
       null, cornflowerBlue,
	   45.0, 45.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_batteryLifetime = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -5.0, 0.0, 0.0,
        white,"100",
        _t_batteryLifetime_Font, ALIGNMENT_CENTER );
    txt_batteryLifetime = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -60.0, 0.0, 0.0,
        black,"Levensduur [jaar]",
        _txt_batteryLifetime_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    SOCChart_year = new TimeStackChart(
ChartBatteries.this, true, -250.0, -150.0,
			460.0, 210.0,
            null, null,
            50.0, 30.0,
			380.0, 120.0, white, black, black,
            30.0, Chart.SOUTH,

365 
             * day(), Chart.WINDOW_MOVES_WITH_TIME, "MM", Chart.SCALE_FIXED
,
1 
, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_netload_year = new TimePlot(
ChartBatteries.this, true, -230.0, -110.0,
			460.0, 260.0,
            null, null,
            50.0, 30.0,
			380.0, 170.0, white, black, black,
            30.0, Chart.SOUTH,

365 
             * day(), Chart.WINDOW_MOVES_WITH_TIME, "dd.MM", Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    SOCChart_week = new TimeStackChart(
ChartBatteries.this, true, -230.0, -250.0,
			460.0, 210.0,
            null, null,
            50.0, 30.0,
			380.0, 120.0, white, black, black,
            30.0, Chart.SOUTH,

168 
            , Chart.WINDOW_MOVES_WITH_DATA, "dd.MM", Chart.SCALE_FIXED
,
1 
, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_netload_week = new TimePlot(
ChartBatteries.this, true, -230.0, -110.0,
			460.0, 260.0,
            null, null,
            40.0, 30.0,
			380.0, 170.0, white, black, black,
            30.0, Chart.SOUTH,

168 
            , Chart.WINDOW_MOVES_WITH_DATA, "dd.MM", Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    group_year_SOC = new ShapeGroup( ChartBatteries.this, SHAPE_DRAW_2D3D, true, 0.0, -140.0, 0.0, 0.0
	
	     , SOCChart_year
	     , txt_batterySOCYear
	     , txt_yearProfile_ylabel );
    }
    {
    group_netload_year = new ShapeGroup( ChartBatteries.this, SHAPE_DRAW_2D3D, true, -20.0, 40.0, 0.0, 0.0
	
	     , plot_netload_year
	     , txt_netload_year
	     , txt_netload_ylabel_year );
    }
    {
    gr_year = new ShapeGroup( ChartBatteries.this, SHAPE_DRAW_2D3D, true, 770.0, 380.0, 0.0, 0.0
	
	     , group_year_SOC
	     , group_netload_year ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_year_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    group_week_SOC = new ShapeGroup( ChartBatteries.this, SHAPE_DRAW_2D3D, true, -10.0, -70.0, 0.0, 0.0
	
	     , SOCChart_week
	     , txt_batterySOCLive
	     , txt_weekProfile_ylabel );
    }
    {
    group_netload_week = new ShapeGroup( ChartBatteries.this, SHAPE_DRAW_2D3D, true, 0.0, 10.0, 0.0, 0.0
	
	     , plot_netload_week
	     , txt_netload_week
	     , txt_netload_ylabel_week );
    }
    {
    gr_week = new ShapeGroup( ChartBatteries.this, SHAPE_DRAW_2D3D, true, 240.0, 420.0, 0.0, 0.0
	
	     , group_week_SOC
	     , group_netload_week );
    }
    {
    gr_batteryCycles = new ShapeGroup( ChartBatteries.this, SHAPE_DRAW_2D3D, true, 350.0, 680.0, 0.0, 0.0
	
	     , oval_batteryCycles
	     , t_batteryCycles
	     , txt_batteryCycles );
    }
    gr_batteryCycles.setVisible( false );
    {
    gr_batteryLifetime = new ShapeGroup( ChartBatteries.this, SHAPE_DRAW_2D3D, true, 630.0, 680.0, 0.0, 0.0
	
	     , oval_batteryLifetime
	     , t_batteryLifetime
	     , txt_batteryLifetime );
    }
    gr_batteryLifetime.setVisible( false );
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
  public ChartBatteries( Engine engine, Agent owner, AgentList<? extends ChartBatteries> ownerPopulation ) {
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
  public ChartBatteries() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartBatteries_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartBatteries.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartBatteries.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    radio_period.setValueToDefault();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

v_weekLabel = new ShapeText();
v_weekLabel.setText("");
v_weekLabel.setFont(new Font("Calibri", 0, 20));
//gr_week.add(v_weekLabel);
this.presentation.add(v_weekLabel);
v_weekLabel.setX(150);
v_weekLabel.setY(60);

/*
String[] stringArray = {"live", "week 1", "week 2", "jaar"};
ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
ArrayList<String> options = new ArrayList<String>();
    cars.add("live");
    cars.add("week 1");
    cars.add("week 2");
    cars.add("jaar");
radio_period = new radioButtonChangableOptions(this.presentation.getPresentable(), true, 50, 4, 300, 50, Color.BLACK, true, new Font("Calibri", 0, 15), false, stringArray){
	@Override
	public void action() {
		f_setChartsBatteries();
	}
	
};
radio_period.setOptions(options, cars);
this.presentation.add(radio_period);
*/
//radio_period2.setVisible(true);
//radio_period2.setEnabled(true);
 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartBatteries_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartBatteries_xjal() {
    v_cycleCount = 
0 
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

  public AgentList<? extends ChartBatteries> getPopulation() {
    return (AgentList<? extends ChartBatteries>) super.getPopulation();
  }

  public List<? extends ChartBatteries> agentsInRange( double distance ) {
    return (List<? extends ChartBatteries>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
  	for (int _pIdx = 0; _pIdx < SOCChart_year.getCount(); _pIdx++) {
  		DataSet _ds = SOCChart_year.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = SOCChart_year.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "SOCChart_year : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < plot_netload_year.getCount(); _pIdx++) {
  		DataSet _ds = plot_netload_year.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_netload_year.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_netload_year : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < SOCChart_week.getCount(); _pIdx++) {
  		DataSet _ds = SOCChart_week.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = SOCChart_week.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "SOCChart_week : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < plot_netload_week.getCount(); _pIdx++) {
  		DataSet _ds = plot_netload_week.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_netload_week.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_netload_week : " + _t );
  	}
    super.onDestroy();
  }

  // Additional class code

public ShapeRadioButtonGroup getPeriodRadioButton() {
	return this.radio_period;
}

public ShapeGroup getChartGroupWeek() {
	return this.gr_week;
}

public ShapeGroup getChartGroupYear() {
	return this.gr_year;
} 
  // End of additional class code

}
