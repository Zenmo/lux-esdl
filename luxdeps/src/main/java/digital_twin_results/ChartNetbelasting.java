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

public class ChartNetbelasting extends digital_twin_results.ChartArea
{
  // Parameters

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartNetbelasting.class );

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

  void f_resetPlots(  ) { 

plot_jaar.removeAll();
plot_week.removeAll();
plot_dagnacht.removeAll();
plot_seizoen.removeAll();
gr_flexGrowthPotential.setVisible(false);
gr_growthPotential.setVisible(false);

gr_absoluteDeliveryInfo.setPos(175, 300);
gr_relativeDeliveryInfo.setPos(155, 420);
gr_absoluteFeedinInfo.setPos(305, 300);
gr_relativeFeedinInfo.setPos(305, 420);

gr_concurrencyKPI.setVisible(false); 
  }

  void f_addDataToPlots( I_EnergyData dataObject, J_LoadDurationCurves loadDurationCurves ) { 

double divisionAmountForCorrectUnit = 1;
String power_unit = "kW";

////Get the peaks
double maxDelivery_kW = max(0, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMax());
double maxFeedin_kW = abs(min(0, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMin()));
double maxDeliveryAndFeedin_kW = max(maxDelivery_kW, maxFeedin_kW);

////Put it in a usefull unit type
if(maxDeliveryAndFeedin_kW < 1){
	power_unit = "W";
	divisionAmountForCorrectUnit = 1/pow(10,3);
}
else if(maxDeliveryAndFeedin_kW < 1 * pow(10,3)){
	//Do nothing, already in right format
}
else if(maxDeliveryAndFeedin_kW < 1 * pow(10,6)){
	power_unit = "MW";
	divisionAmountForCorrectUnit = pow(10,3);
}
else{
	power_unit = "GW";
	divisionAmountForCorrectUnit = pow(10,6);
}

//Adjust y label to selected unit type
f_setYlabels(power_unit);

DataSet loadDurationCurveTotal = uI_Results.f_createNewDataSetDividedByValue(loadDurationCurves.ds_loadDurationCurveTotal_kW, divisionAmountForCorrectUnit);
double minValue = loadDurationCurveTotal.getYMin();
double maxValue = loadDurationCurveTotal.getYMax();

double gridCapacityDelivery_kW = dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW() / divisionAmountForCorrectUnit;
double gridCapacityFeedin_kW = dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW() / divisionAmountForCorrectUnit;

double scaleMax = 1 + max(gridCapacityDelivery_kW*1.2, maxValue);
double scaleMin = -1 + min(-gridCapacityFeedin_kW*1.2, minValue);



//Jaar
plot_jaar.addDataSet(loadDurationCurveTotal,"Belasting jaar");
plot_jaar.setFixedVerticalScale(scaleMin, scaleMax);

//summer/winter
DataSet loadDurationCurveSummer = uI_Results.f_createNewDataSetDividedByValue(loadDurationCurves.ds_loadDurationCurveSummer_kW, divisionAmountForCorrectUnit);
DataSet loadDurationCurveWinter = uI_Results.f_createNewDataSetDividedByValue(loadDurationCurves.ds_loadDurationCurveWinter_kW, divisionAmountForCorrectUnit);
plot_seizoen.addDataSet(loadDurationCurveSummer,"Belasting week laagste afname");
plot_seizoen.addDataSet(loadDurationCurveWinter,"Belasting week hoogste afname");
plot_seizoen.setColor(0,blue);
plot_seizoen.setColor(1,green);
plot_seizoen.setFixedVerticalScale(scaleMin, scaleMax);

// Day/night
DataSet loadDurationCurveDaytime = uI_Results.f_createNewDataSetDividedByValue(loadDurationCurves.ds_loadDurationCurveDaytime_kW, divisionAmountForCorrectUnit);
DataSet loadDurationCurveNighttime = uI_Results.f_createNewDataSetDividedByValue(loadDurationCurves.ds_loadDurationCurveNighttime_kW, divisionAmountForCorrectUnit);
plot_dagnacht.addDataSet(loadDurationCurveDaytime,"Belasting overdag");
plot_dagnacht.addDataSet(loadDurationCurveNighttime,"Belasting 's nachts");
plot_dagnacht.setColor(0,blue);
plot_dagnacht.setColor(1,green);	
plot_dagnacht.setFixedVerticalScale(scaleMin, scaleMax);

// Weekday/weekend
DataSet loadDurationCurveWeekday = uI_Results.f_createNewDataSetDividedByValue(loadDurationCurves.ds_loadDurationCurveWeekday_kW, divisionAmountForCorrectUnit);
DataSet loadDurationCurveWeekend = uI_Results.f_createNewDataSetDividedByValue(loadDurationCurves.ds_loadDurationCurveWeekend_kW, divisionAmountForCorrectUnit);
plot_week.addDataSet(loadDurationCurveWeekday,"Belasting weekdagen");
plot_week.addDataSet(loadDurationCurveWeekend,"Belasting weekenddagen");
plot_week.setColor(0,blue);
plot_week.setColor(1,green);
plot_week.setFixedVerticalScale(scaleMin, scaleMax);

//Add connection limits
f_addConnectionLimits(dataObject, divisionAmountForCorrectUnit);  
  }

  void f_addConnectionLimits( I_EnergyData dataObject, double divisionAmountForCorrectUnit ) { 

//Add and color grid capacities
String deliveryCapacityLabel = "";
String feedinCapacityLabel = "";
Color  deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_known;
Color  feedinCapacityColor		= uI_Results.v_electricityCapacityColor_known;

//Create delivery and capacity year datasets
DataSet gridCapacityDelivery_kW = uI_Results.f_createFlatDataset(0, 8760, dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW() / divisionAmountForCorrectUnit);
DataSet gridCapacityFeedin_kW = uI_Results.f_createFlatDataset(0, 8760, -dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW() / divisionAmountForCorrectUnit);

//Give specific capacity names based on selected scope	
if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDCONNECTION){
	deliveryCapacityLabel = "Gecontracteerde afname capaciteit";
	feedinCapacityLabel = "Gecontracteerde terugleverings capaciteit";
}

else if(uI_Results.v_selectedObjectScope == OL_ResultScope.ENERGYCOOP){
	deliveryCapacityLabel = "Cumulatieve GTV afname van de aansluitingen";
	feedinCapacityLabel = "Cumulatieve GTV teruglevering van de aansluitingen";
	
	if(uI_Results.b_showGroupContractValues){
		//And: add group contract values
		DataSet groupContractCapacityDelivery_kW = uI_Results.f_createFlatDataset(0, 8760, ((EnergyCoop)dataObject).f_getGroupContractDeliveryCapacity_kW(dataObject.getRapidRunData(), uI_Results.energyModel.p_timeParameters) / divisionAmountForCorrectUnit);
		DataSet groupContractCapacityFeedin_kW = uI_Results.f_createFlatDataset(0, 8760, -((EnergyCoop)dataObject).f_getGroupContractFeedinCapacity_kW(dataObject.getRapidRunData(), uI_Results.energyModel.p_timeParameters) / divisionAmountForCorrectUnit);
		
		plot_jaar.addDataSet(groupContractCapacityDelivery_kW, "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_jaar.addDataSet(groupContractCapacityFeedin_kW, "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
		plot_week.addDataSet(groupContractCapacityDelivery_kW, "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_week.addDataSet(groupContractCapacityFeedin_kW, "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
		plot_dagnacht.addDataSet(groupContractCapacityDelivery_kW, "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_dagnacht.addDataSet(groupContractCapacityFeedin_kW, "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
		plot_seizoen.addDataSet(groupContractCapacityDelivery_kW, "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_seizoen.addDataSet(groupContractCapacityFeedin_kW, "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
	}
}
else if(uI_Results.v_selectedObjectScope == OL_ResultScope.ENERGYMODEL){
	deliveryCapacityLabel = "Fysieke afname capaciteit van het gebied";
	feedinCapacityLabel = "Fysieke terugleverings capaciteit van het gebied";
}

//Add estimation tag and color if the capacities are not known
if(!dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacityKnown()){
	deliveryCapacityLabel = "Geschatte " + deliveryCapacityLabel.substring(0, 1).toLowerCase() + deliveryCapacityLabel.substring(1);
	deliveryCapacityColor = uI_Results.v_electricityCapacityColor_estimated;
}
if(!dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacityKnown()){
	feedinCapacityLabel = "Geschatte " + feedinCapacityLabel.substring(0, 1).toLowerCase() + feedinCapacityLabel.substring(1);
	feedinCapacityColor	= uI_Results.v_electricityCapacityColor_estimated;
}

        	
plot_jaar.addDataSet(gridCapacityDelivery_kW, deliveryCapacityLabel);
plot_jaar.addDataSet(gridCapacityFeedin_kW, feedinCapacityLabel);
plot_jaar.setColor(1, deliveryCapacityColor);
plot_jaar.setColor(2, feedinCapacityColor);

plot_week.addDataSet(gridCapacityDelivery_kW, deliveryCapacityLabel);
plot_week.addDataSet(gridCapacityFeedin_kW, feedinCapacityLabel);
plot_week.setColor(plot_week.getCount() - 2, deliveryCapacityColor);
plot_week.setColor(plot_week.getCount() - 1, feedinCapacityColor);

plot_dagnacht.addDataSet(gridCapacityDelivery_kW, deliveryCapacityLabel);
plot_dagnacht.addDataSet(gridCapacityFeedin_kW, feedinCapacityLabel);
plot_dagnacht.setColor(plot_dagnacht.getCount() - 2, deliveryCapacityColor);
plot_dagnacht.setColor(plot_dagnacht.getCount() - 1, feedinCapacityColor);

plot_seizoen.addDataSet(gridCapacityDelivery_kW, deliveryCapacityLabel);
plot_seizoen.addDataSet(gridCapacityFeedin_kW, feedinCapacityLabel);
plot_seizoen.setColor(plot_seizoen.getCount() - 2, deliveryCapacityColor);
plot_seizoen.setColor(plot_seizoen.getCount() - 1, feedinCapacityColor);
 
  }

  void f_setLoadPlotsGN(  ) { 

GridNode GN = uI_Results.v_gridNode;

f_addDataToPlotsGN(GN);

f_setKPIValuesGN(GN); 
 
  }

  void f_addDataToPlotsGN( GridNode GN ) { 

double divisionAmountForCorrectUnit = 1;
String power_unit = "kW";

////Get the peaks
J_LoadDurationCurves loadCurves = GN.f_getDuurkrommes(uI_Results.energyModel.p_timeParameters);
double maxDelivery_kW = max(0, loadCurves.ds_loadDurationCurveTotal_kW.getYMax());
double maxFeedin_kW = abs(min(0, loadCurves.ds_loadDurationCurveTotal_kW.getYMin()));
double maxDeliveryAndFeedin_kW = max(maxDelivery_kW, maxFeedin_kW);

////Put it in a usefull unit type
if(maxDeliveryAndFeedin_kW < 1){
	power_unit = "W";
	divisionAmountForCorrectUnit = 1/pow(10,3);
}
else if(maxDeliveryAndFeedin_kW < 1 * pow(10,3)){
	//Do nothing, already in right format
}
else if(maxDeliveryAndFeedin_kW < 1 * pow(10,6)){
	power_unit = "MW";
	divisionAmountForCorrectUnit = pow(10,3);
}
else{
	power_unit = "GW";
	divisionAmountForCorrectUnit = pow(10,6);
}

//Adjust y label to selected unit type
f_setYlabels(power_unit);

DataSet loadDurationCurveTotal = uI_Results.f_createNewDataSetDividedByValue(loadCurves.ds_loadDurationCurveTotal_kW, divisionAmountForCorrectUnit);
double minValue = loadDurationCurveTotal.getYMin();
double maxValue = loadDurationCurveTotal.getYMax();

double gridCapacityDelivery = GN.p_capacity_kW / divisionAmountForCorrectUnit;
double gridCapacityFeedin = GN.p_capacity_kW / divisionAmountForCorrectUnit;

double scaleMin = -1 + min(-gridCapacityFeedin*1.2, minValue);
double scaleMax = 1 + max(gridCapacityDelivery*1.2, maxValue);


//Jaar
plot_jaar.addDataSet(loadDurationCurveTotal,"Belasting jaar");
plot_jaar.setFixedVerticalScale(scaleMin, scaleMax);
if (loadCurves.ds_previousLoadDurationCurveTotal_kW != null) {
	//plot_jaar.addDataSet(area.v_dataNetbelastingDuurkrommeYearVorige_kW,"Vorige situatie");
	//plot_jaar.setColor(3,gray);
}

//summer/winter
if( loadCurves.ds_loadDurationCurveSummer_kW != null){
	DataSet loadDurationCurveSummer = uI_Results.f_createNewDataSetDividedByValue(loadCurves.ds_loadDurationCurveSummer_kW, divisionAmountForCorrectUnit);
	DataSet loadDurationCurveWinter = uI_Results.f_createNewDataSetDividedByValue(loadCurves.ds_loadDurationCurveWinter_kW, divisionAmountForCorrectUnit);
	plot_seizoen.addDataSet(loadDurationCurveSummer,"Belasting zomerweek");
	plot_seizoen.addDataSet(loadDurationCurveWinter,"Belasting winterweek");
	plot_seizoen.setColor(0,blue);
	plot_seizoen.setColor(1,green);
	plot_seizoen.setFixedVerticalScale(scaleMin, scaleMax);
}

// Day/night
if( loadCurves.ds_loadDurationCurveDaytime_kW != null){
	DataSet loadDurationCurveDaytime = uI_Results.f_createNewDataSetDividedByValue(loadCurves.ds_loadDurationCurveDaytime_kW, divisionAmountForCorrectUnit);
	DataSet loadDurationCurveNighttime = uI_Results.f_createNewDataSetDividedByValue(loadCurves.ds_loadDurationCurveNighttime_kW, divisionAmountForCorrectUnit);
	plot_dagnacht.addDataSet(loadDurationCurveDaytime,"Belasting overdag");
	plot_dagnacht.addDataSet(loadDurationCurveNighttime,"Belasting 's nachts");
	plot_dagnacht.setColor(0,blue);
	plot_dagnacht.setColor(1,green);	
	plot_dagnacht.setFixedVerticalScale(scaleMin, scaleMax);
}

// Weekday/weekend
if( loadCurves.ds_loadDurationCurveWeekday_kW != null){
	DataSet loadDurationCurveWeekday = uI_Results.f_createNewDataSetDividedByValue(loadCurves.ds_loadDurationCurveWeekday_kW, divisionAmountForCorrectUnit);
	DataSet loadDurationCurveWeekend = uI_Results.f_createNewDataSetDividedByValue(loadCurves.ds_loadDurationCurveWeekend_kW, divisionAmountForCorrectUnit);
	plot_week.addDataSet(loadDurationCurveWeekday,"Belasting weekdagen");
	plot_week.addDataSet(loadDurationCurveWeekend,"Belasting weekenddagen");
	plot_week.setColor(0,blue);
	plot_week.setColor(1,green);
	plot_week.setFixedVerticalScale(scaleMin, scaleMax);
}

//Add trafo limits
f_addTrafoLimitsGN(GN, divisionAmountForCorrectUnit);  
  }

  void f_addTrafoLimitsGN( GridNode GN, double divisionAmountForCorrectUnit ) { 

//Add and color grid capacities
String deliveryCapacityLabel = "Geschatte fysieke trafo capaciteit afname";
String feedinCapacityLabel = "Geschatte fysieke trafo capaciteit teruglevering";
Color  deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;
Color  feedinCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;

//Create delivery and capacity year datasets
DataSet gridCapacityDelivery_kW = uI_Results.f_createFlatDataset(0, 8760, GN.p_capacity_kW / divisionAmountForCorrectUnit);
DataSet gridCapacityFeedin_kW = uI_Results.f_createFlatDataset(0, 8760, -GN.p_capacity_kW / divisionAmountForCorrectUnit);
	
if(GN.p_realCapacityAvailable){
		deliveryCapacityLabel = "Fysieke trafo capaciteit afname";
		deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_known;
		feedinCapacityLabel = "Fysieke trafo capaciteit teruglevering";
		feedinCapacityColor		= uI_Results.v_electricityCapacityColor_known;
}
	
plot_jaar.addDataSet(gridCapacityDelivery_kW, deliveryCapacityLabel);
plot_jaar.addDataSet(gridCapacityFeedin_kW, feedinCapacityLabel);
plot_jaar.setColor(1, deliveryCapacityColor);
plot_jaar.setColor(2, feedinCapacityColor);

plot_week.addDataSet(gridCapacityDelivery_kW, deliveryCapacityLabel);
plot_week.addDataSet(gridCapacityFeedin_kW, feedinCapacityLabel);
plot_week.setColor(plot_week.getCount() - 2, deliveryCapacityColor);
plot_week.setColor(plot_week.getCount() - 1, feedinCapacityColor);

plot_dagnacht.addDataSet(gridCapacityDelivery_kW, deliveryCapacityLabel);
plot_dagnacht.addDataSet(gridCapacityFeedin_kW, feedinCapacityLabel);
plot_dagnacht.setColor(plot_dagnacht.getCount() - 2, deliveryCapacityColor);
plot_dagnacht.setColor(plot_dagnacht.getCount() - 1, feedinCapacityColor);

plot_seizoen.addDataSet(gridCapacityDelivery_kW, deliveryCapacityLabel);
plot_seizoen.addDataSet(gridCapacityFeedin_kW, feedinCapacityLabel);
plot_seizoen.setColor(plot_seizoen.getCount() - 2, deliveryCapacityColor);
plot_seizoen.setColor(plot_seizoen.getCount() - 1, feedinCapacityColor);
 
  }

  void f_setKPIValues( I_EnergyData dataObject, J_LoadDurationCurves loadDurationCurves ) { 

////Get the peaks
double maxDelivery_kW = max(0, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMax());
double maxFeedin_kW = abs(min(0, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMin()));
double maxDeliveryAndFeedin_kW = max(maxDelivery_kW, maxFeedin_kW);


////Put it in a usefull unit format
DecimalFormat df_1decimal = new DecimalFormat("0.0");
DecimalFormat df_2decimal = new DecimalFormat("0.00");

String peakLoad_unit = " kW";
double maxDelivery_unit = maxDelivery_kW;
double maxFeedin_unit = maxFeedin_kW;

if(maxDeliveryAndFeedin_kW < 1 * pow(10,3)){
	//Do nothing, already in right format
}
else if(maxDeliveryAndFeedin_kW < 1 * pow(10,6)){
	peakLoad_unit = " MW";
	maxDelivery_unit = maxDelivery_kW/ pow(10,3);
	maxFeedin_unit = maxFeedin_kW/ pow(10,3);
}
else{
	peakLoad_unit = " GW";
	maxDelivery_unit = maxDelivery_kW/ pow(10,6);
	maxFeedin_unit = maxFeedin_kW/ pow(10,6);
}

if(maxDelivery_unit > 100){
	t_maxDelivery_MW.setText(roundToInt(maxDelivery_unit) + peakLoad_unit);
}
else if(maxDelivery_unit > 10){
	t_maxDelivery_MW.setText(df_1decimal.format(maxDelivery_unit)+ peakLoad_unit);
}
else{
	t_maxDelivery_MW.setText(df_2decimal.format(maxDelivery_unit)+ peakLoad_unit);
}

if(maxFeedin_unit > 100){
	t_maxFeedin_MW.setText(roundToInt(maxFeedin_unit)+ peakLoad_unit);
}
else if(maxFeedin_unit > 10){
	t_maxFeedin_MW.setText(df_1decimal.format(maxFeedin_unit)+ peakLoad_unit);
}
else{
	t_maxFeedin_MW.setText(df_2decimal.format(maxFeedin_unit)+ peakLoad_unit);
}

////Max peaks in percentages
if (dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacityKnown() && dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW() > 0) {
	double deliveryCapacity_kW = dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW();
	t_maxDelivery_pct.setText(roundToInt(maxDelivery_kW/dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW() * 100) + " %");
	gr_relativeDeliveryInfo.setVisible(true);
}
else{
	gr_relativeDeliveryInfo.setVisible(false);
}
if (dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacityKnown() && dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW() > 0) {
	double feedinCapacity_kW = dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW();
	t_maxFeedin_pct.setText(roundToInt(maxFeedin_kW/dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW() * 100) + " %");
	gr_relativeFeedinInfo.setVisible(true);
}
else{
	gr_relativeFeedinInfo.setVisible(false);
}


/**
* Growth KPIs
* These KPIs are based on the day with the highest average delivery
* We only show these KPIs if the (delivery) connection capacity is known
* If there is room to grow, i.e. the highest average delivery is still below the capacity we also show what flex (a battery) could add
* We do not show exact percentages above 1000%, i.e. 10x growth.
*/
if (dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacityKnown() && dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW() > 0) {
	Pair<Double, Double> pair = dataObject.getRapidRunData().getFlexPotential();
	double deliveryPeak_fr = maxDelivery_kW / dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW();
	int growthWithoutFlex_pct = roundToInt((100 / deliveryPeak_fr) - 100);
	if (pair.getFirst() < 1) { 
		// The current usage is already above the capacity already, do not show flex option
		gr_growthPotential.setVisible(true);
		if (growthWithoutFlex_pct < 1000) {
			t_growthPercentage.setText( growthWithoutFlex_pct + " %" );
		}
		else {
			t_growthPercentage.setText( " >1000%" );		
		}
	}
	else {
		// Also show flex option
		gr_flexGrowthPotential.setVisible(true);
		if (growthWithoutFlex_pct < 1000) {
			t_flexGrowthWithoutBatteryPercentage.setText( growthWithoutFlex_pct + " %" );
		}
		else {
			t_flexGrowthWithoutBatteryPercentage.setText( " >1000%" );		
		}
		if (pair.getSecond() < 1000) {
			t_batterySize.setText( roundToDecimal(pair.getSecond(), 1) + " kWh" );
		}
		else if (pair.getSecond() < 1_000_000) {
			t_batterySize.setText( roundToDecimal(pair.getSecond() / 1000, 1) + " MWh" );	
		}
		else {
			t_batterySize.setText( roundToDecimal(pair.getSecond() / 1_000_000, 1) + " GWh" );
		}
		int growthWithFlex_pct = roundToInt((pair.getFirst() - 1 ) * 100);
		if (growthWithFlex_pct < 1000) {
			t_flexGrowthWithBatteryPercentage.setText( growthWithFlex_pct + " %" );
		}
		else {
			t_flexGrowthWithBatteryPercentage.setText( " >1000%" );		
		}
	}
}
else {
	// Delivery Connection Capacity Unkown, do not show these KPIs
} 
  }

  void f_setKPIValuesGN( GridNode GN ) { 

////Get the peaks
J_LoadDurationCurves loadCurves = GN.f_getDuurkrommes(uI_Results.energyModel.p_timeParameters);
double maxDelivery_kW = max(0, loadCurves.ds_loadDurationCurveTotal_kW.getYMax());
double maxFeedin_kW = abs(min(0, loadCurves.ds_loadDurationCurveTotal_kW.getYMin()));
double maxDeliveryAndFeedin_kW = max(maxDelivery_kW, maxFeedin_kW);


////Put it in a usefull unit format
DecimalFormat df_1decimal = new DecimalFormat("0.0");
DecimalFormat df_2decimal = new DecimalFormat("0.00");

String peakLoad_unit = " kW";
double maxDelivery_unit = maxDelivery_kW;
double maxFeedin_unit = maxFeedin_kW;

if(maxDeliveryAndFeedin_kW < 1 * pow(10,3)){
	//Do nothing, already in right format
}
else if(maxDeliveryAndFeedin_kW < 1 * pow(10,6)){
	peakLoad_unit = " MW";
	maxDelivery_unit = maxDelivery_kW/ pow(10,3);
	maxFeedin_unit = maxFeedin_kW/ pow(10,3);
}
else{
	peakLoad_unit = " GW";
	maxDelivery_unit = maxDelivery_kW/ pow(10,6);
	maxFeedin_unit = maxFeedin_kW/ pow(10,6);
}

if(maxDelivery_unit > 100){
	t_maxDelivery_MW.setText(roundToInt(maxDelivery_unit) + peakLoad_unit);
}
else if(maxDelivery_unit > 10){
	t_maxDelivery_MW.setText(df_1decimal.format(maxDelivery_unit)+ peakLoad_unit);
}
else{
	t_maxDelivery_MW.setText(df_2decimal.format(maxDelivery_unit)+ peakLoad_unit);
}

if(maxFeedin_unit > 100){
	t_maxFeedin_MW.setText(roundToInt(maxFeedin_unit)+ peakLoad_unit);
}
else if(maxFeedin_unit > 10){
	t_maxFeedin_MW.setText(df_1decimal.format(maxFeedin_unit)+ peakLoad_unit);
}
else{
	t_maxFeedin_MW.setText(df_2decimal.format(maxFeedin_unit)+ peakLoad_unit);
}


////Max peaks in percentages
if (GN.p_realCapacityAvailable) {
	t_maxDelivery_pct.setText(roundToInt(maxDelivery_kW/GN.p_capacity_kW * 100) + " %");
	t_maxFeedin_pct.setText(roundToInt(maxFeedin_kW/GN.p_capacity_kW * 100) + " %");

	gr_relativeDeliveryInfo.setVisible(true);
	gr_relativeFeedinInfo.setVisible(true);
}
else {
	gr_relativeDeliveryInfo.setVisible(false);
	gr_relativeFeedinInfo.setVisible(false);
}

gr_flexGrowthPotential.setVisible(false);
gr_growthPotential.setVisible(false);


//Concurrency KPI
f_setGNConcurrencyKPI(GN, maxDelivery_kW); 
  }

  void f_setYlabels( String power_unit ) { 

t_netLoadDurationCurve_ylabel.setText("Vermogen [" + power_unit + "]");
t_netLoadDurationCurveSummerWinter_ylabel.setText("Vermogen [" + power_unit + "]");
t_netLoadDurationCurveDayNight_ylabel.setText("Vermogen [" + power_unit + "]");
t_netLoadDurationCurveWeekWeekend_ylabel.setText("Vermogen [" + power_unit + "]"); 
  }

  void f_setCharts(  ) { 

f_resetPlots();

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 50, true);

if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE){
	f_setLoadPlotsGN();
	return;
}
else {
	f_setLoadPlots();
}

 
  }

  void f_setLoadPlots(  ) { 

I_EnergyData data = uI_Results.f_getSelectedObjectData();
J_LoadDurationCurves loadDurationCurves = data.getRapidRunData().getLoadDurationCurves();
f_addDataToPlots(data, loadDurationCurves);
f_setKPIValues(data, loadDurationCurves);
 
  }

  void f_setGNConcurrencyKPI( GridNode GN, double maxDelivery_kW ) { 

List<GridConnection> allLowerLevelGridConnections = findAll(GN.f_getAllLowerLVLConnectedGridConnections(), gc -> gc.v_isActive);

if(allLowerLevelGridConnections.size() < 10){
	//If less than 10 GC connected to GN, KPI is not usefull to show.
	return;
}

int nrOfHouses = 0;
int nrOfChargers = 0;
int nrOfRemainingConnections = 0;
int totalNrOfConnections = 0;
for(GridConnection connectedGC : allLowerLevelGridConnections){
	if(connectedGC instanceof GCHouse){
		nrOfHouses++;
	}
	else if(connectedGC instanceof GCPublicCharger){
		nrOfChargers++;
	}
	else{
		nrOfRemainingConnections++;
	}
	totalNrOfConnections++;
}


t_numberOfHouses.setText("Huizen: " + nrOfHouses);
t_numberOfChargers.setText("Laadpalen: " + nrOfChargers);
t_numberOfRemainingConnections.setText("Overige connecties: " + nrOfRemainingConnections);

//Calculate concurrency
double concurrencyValue_kW = roundToDecimal(maxDelivery_kW/totalNrOfConnections,2);
t_concurrencyValue.setText(concurrencyValue_kW + " kW max per aansluiting");

//Set position and visiblity
gr_concurrencyKPI.setVisible(true);

gr_absoluteDeliveryInfo.setPos(105, 370);
gr_relativeDeliveryInfo.setPos(85, 490);
gr_absoluteFeedinInfo.setPos(235, 370);
gr_relativeFeedinInfo.setPos(235, 490);
 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _radio_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText3_Font = new Font("Calibri", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText4_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText5_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_netLoadDurationCurveSummerWinter_ylabel_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_netLoadDurationCurveDayNight_ylabel_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_netLoadDurationCurveWeekWeekend_ylabel_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_xlabel1_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_xlabel2_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_xlabel3_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_netLoadDurationCurveTitle_Font = new Font("Calibri", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_netLoadDurationCurve_xlabel_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_netLoadDurationCurve_ylabel_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_maxDelivery_MW_Font = new Font("Arial", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_maxDelivery_MW_Font = new Font("Arial", 1, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_maxFeedin_MW_Font = _t_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_maxFeedin_MW_Font = _txt_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_maxDelivery_pct_Font = _t_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_maxFeedin_MW2_Font = new Font("Arial", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_maxFeedin_pct_Font = _t_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_maxFeedin_MW1_Font = _txt_maxFeedin_MW2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_growthDescription_Font = _txt_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_growthPercentage_Font = _t_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_batterySize_Font = _txt_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_flexGrowthWithBatteryDescription_Font = _txt_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_flexGrowthWithBatteryPercentage_Font = _t_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_flexGrowthWithoutBatteryDescription_Font = _txt_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_flexGrowthWithoutBatteryPercentage_Font = _t_maxDelivery_MW_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfChargers_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfHouses_Font = _t_numberOfChargers_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_concurrency_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = new Font("SansSerif", 0, 8 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_concurrencyValue_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_numberOfRemainingConnections_Font = _t_numberOfChargers_Font;
  protected static final Color _rect_concurrency_Fill_Color = new Color( 0xFFF4F8E7, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_netLoadDurationCurveSummerWinter_ylabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_netLoadDurationCurveDayNight_ylabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_netLoadDurationCurveWeekWeekend_ylabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_xlabel1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_xlabel2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_xlabel3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_details = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_netLoadDurationCurveTitle = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_netLoadDurationCurve_xlabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_netLoadDurationCurve_ylabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_netLoadDurationCurve = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalAbsolutePeakDelivery = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_maxDelivery_MW = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_maxDelivery_MW = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_maxDelivery = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_absoluteDeliveryInfo = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalAbsolutePeakFeedin = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_maxFeedin_MW = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_maxFeedin_MW = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_maxFeedin = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_absoluteFeedinInfo = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalRelativePeakDelivery = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_maxDelivery_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_maxFeedin_MW2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_relativeDeliveryInfo = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalRelativePeakFeedin = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_maxFeedin_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_maxFeedin_MW1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_relativeFeedinInfo = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_growthPotential = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_growthDescription = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_growthPercentage = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_negativeGrowth = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_growthPotential = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_batterySize = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrowImage2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_flexGrowthWithBatteryPotential = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_flexGrowthWithBatteryDescription = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_flexGrowthWithBatteryPercentage = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_battery = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_flexGrowthWithBattery = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrowImage1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval_flexGrowthWithoutBatteryPotential = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_flexGrowthWithoutBatteryDescription = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_flexGrowthWithoutBatteryPercentage = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_flexGrowthWithoutBattery = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _batteryImage = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_flexGrowthPotential = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfChargers = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_concurrency = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfHouses = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_concurrency = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_concurrencyValue = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_numberOfRemainingConnections = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_concurrencyKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_year = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_seizoen = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_dagnacht = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_jaar = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 66;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 67;

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
	  level.addAll(rectangle, gr_details, gr_year, radio);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_netLoadDurationCurve:
        if (true) {
          ShapeImage self = this.i_netLoadDurationCurve;
          
uI_Results.f_setInfoText(i_netLoadDurationCurve, uI_Results.v_infoText.netLoadDurationCurve, i_netLoadDurationCurve.getX() + gr_year.getX(), i_netLoadDurationCurve.getY() + gr_year.getY()); 
        }
        break;
      case _i_maxDelivery:
        if (true) {
          ShapeImage self = this.i_maxDelivery;
          
uI_Results.f_setInfoText(i_maxDelivery, uI_Results.v_infoText.peakDelivery, i_maxDelivery.getX() + gr_absoluteDeliveryInfo.getX() + gr_year.getX(), i_maxDelivery.getY() + gr_absoluteDeliveryInfo.getY() + gr_year.getY()); 
        }
        break;
      case _i_maxFeedin:
        if (true) {
          ShapeImage self = this.i_maxFeedin;
          
uI_Results.f_setInfoText(i_maxFeedin, uI_Results.v_infoText.peakFeedin, i_maxFeedin.getX() + gr_absoluteFeedinInfo.getX() + gr_year.getX(), i_maxFeedin.getY() + gr_absoluteFeedinInfo.getY() + gr_year.getY()); 
        }
        break;
      case _i_negativeGrowth:
        if (true) {
          ShapeImage self = this.i_negativeGrowth;
          
uI_Results.f_setInfoText(i_negativeGrowth, uI_Results.v_infoText.negativeGrowthPotential, i_negativeGrowth.getX() + gr_growthPotential.getX() + gr_year.getX(), i_negativeGrowth.getY() + gr_growthPotential.getY() + gr_year.getY()); 
        }
        break;
      case _i_battery:
        if (true) {
          ShapeImage self = this.i_battery;
          
uI_Results.f_setInfoText(i_battery, uI_Results.v_infoText.batterySize, i_battery.getX() + gr_flexGrowthPotential.getX() + gr_year.getX(), i_battery.getY() + gr_flexGrowthPotential.getY() + gr_year.getY()); 
        }
        break;
      case _i_flexGrowthWithBattery:
        if (true) {
          ShapeImage self = this.i_flexGrowthWithBattery;
          
uI_Results.f_setInfoText(i_flexGrowthWithBattery, uI_Results.v_infoText.flexGrowthPotential, i_flexGrowthWithBattery.getX() + gr_flexGrowthPotential.getX() + gr_year.getX(), i_flexGrowthWithBattery.getY() + gr_flexGrowthPotential.getY() + gr_year.getY()); 
        }
        break;
      case _i_flexGrowthWithoutBattery:
        if (true) {
          ShapeImage self = this.i_flexGrowthWithoutBattery;
          
uI_Results.f_setInfoText(i_flexGrowthWithoutBattery, uI_Results.v_infoText.positiveGrowthPotential, i_flexGrowthWithoutBattery.getX() + gr_flexGrowthPotential.getX() + gr_year.getX(), i_flexGrowthWithoutBattery.getY() + gr_flexGrowthPotential.getY() + gr_year.getY()); 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, int value ) {
    switch( _shape ) {
      case _radio: {
          ShapeRadioButtonGroup self = this.radio;
if (radio.getValue() == 0){
	gr_year.setVisible(true);
	gr_details.setVisible(false);
}
else {
	gr_year.setVisible(false);
	gr_details.setVisible(true);
} 
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
      case _radio: return 
0 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  protected ShapeRadioButtonGroup radio;
  protected Plot plot_seizoen;
  protected Plot plot_dagnacht;
  protected Plot plot_week;
  protected Plot plot_jaar;
  
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
  protected ShapeText tx_topBarplotText3;
  protected ShapeText tx_topBarplotText4;
  protected ShapeText tx_topBarplotText5;
  protected ShapeText t_netLoadDurationCurveSummerWinter_ylabel;
  protected ShapeText t_netLoadDurationCurveDayNight_ylabel;
  protected ShapeText t_netLoadDurationCurveWeekWeekend_ylabel;
  protected ShapeText t_duurkromme_xlabel1;
  protected ShapeText t_duurkromme_xlabel2;
  protected ShapeText t_duurkromme_xlabel3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_details_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
220 
);
  }
  
  protected ShapeGroup gr_details;
  protected ShapeText t_netLoadDurationCurveTitle;
  protected ShapeText t_netLoadDurationCurve_xlabel;
  protected ShapeText t_netLoadDurationCurve_ylabel;
  protected ShapeImage i_netLoadDurationCurve;
  protected ShapeOval ovalAbsolutePeakDelivery;
  protected ShapeText txt_maxDelivery_MW;
  protected ShapeText t_maxDelivery_MW;
  protected ShapeImage i_maxDelivery;
  protected ShapeGroup gr_absoluteDeliveryInfo;
  protected ShapeOval ovalAbsolutePeakFeedin;
  protected ShapeText t_maxFeedin_MW;
  protected ShapeText txt_maxFeedin_MW;
  protected ShapeImage i_maxFeedin;
  protected ShapeGroup gr_absoluteFeedinInfo;
  protected ShapeOval ovalRelativePeakDelivery;
  protected ShapeText t_maxDelivery_pct;
  protected ShapeText txt_maxFeedin_MW2;
  protected ShapeGroup gr_relativeDeliveryInfo;
  protected ShapeOval ovalRelativePeakFeedin;
  protected ShapeText t_maxFeedin_pct;
  protected ShapeText txt_maxFeedin_MW1;
  protected ShapeGroup gr_relativeFeedinInfo;
  protected ShapeOval oval_growthPotential;
  protected ShapeText t_growthDescription;
  protected ShapeText t_growthPercentage;
  protected ShapeImage i_negativeGrowth;
  protected ShapeGroup gr_growthPotential;
  protected ShapeText t_batterySize;
  protected ShapeImage arrowImage2;
  protected ShapeOval oval_flexGrowthWithBatteryPotential;
  protected ShapeText t_flexGrowthWithBatteryDescription;
  protected ShapeText t_flexGrowthWithBatteryPercentage;
  protected ShapeImage i_battery;
  protected ShapeImage i_flexGrowthWithBattery;
  protected ShapeImage arrowImage1;
  protected ShapeOval oval_flexGrowthWithoutBatteryPotential;
  protected ShapeText t_flexGrowthWithoutBatteryDescription;
  protected ShapeText t_flexGrowthWithoutBatteryPercentage;
  protected ShapeImage i_flexGrowthWithoutBattery;
  protected ShapeImage batteryImage;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_flexGrowthPotential_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
15 
);
    shape.setY(
290 
);
  }
  
  protected ShapeGroup gr_flexGrowthPotential;
  protected ShapeText t_numberOfChargers;
  protected ShapeRoundedRectangle rect_concurrency;
  protected ShapeText t_numberOfHouses;
  protected ShapeText txt_concurrency;
  protected ShapeText text5;
  protected ShapeText t_concurrencyValue;
  protected ShapeText t_numberOfRemainingConnections;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_concurrencyKPI_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
235 
);
    shape.setY(
310 
);
  }
  
  protected ShapeGroup gr_concurrencyKPI;
  protected ShapeGroup gr_year;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    radio = new ShapeRadioButtonGroup(
ChartNetbelasting.this, true, 160.0, 0.0,
			160.0, 40.0,
            black, true,
_radio_Font, false,
            new String[]{"Jaar overzicht", "Details", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _radio, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _radio, 0 ) );
      }
    };
    rectangle = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            lavender, whiteSmoke,
			460.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    tx_topBarplotText3 = new ShapeText(
        SHAPE_DRAW_2D, true,-10.0, -280.0, 0.0, 0.0,
        black,"Belastingduurkromme piek weken afname/invoeding\n",
        _tx_topBarplotText3_Font, ALIGNMENT_CENTER );
    tx_topBarplotText4 = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, -70.0, 0.0, 0.0,
        black,"Belastingduurkromme dag/nacht",
        _tx_topBarplotText4_Font, ALIGNMENT_CENTER );
    tx_topBarplotText5 = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, 130.0, 0.0, 0.0,
        black,"Belastingduurkromme week/weekend",
        _tx_topBarplotText5_Font, ALIGNMENT_CENTER );
    t_netLoadDurationCurveSummerWinter_ylabel = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, -245.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_netLoadDurationCurveSummerWinter_ylabel_Font, ALIGNMENT_LEFT );
    t_netLoadDurationCurveDayNight_ylabel = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, -35.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_netLoadDurationCurveDayNight_ylabel_Font, ALIGNMENT_LEFT );
    t_netLoadDurationCurveWeekWeekend_ylabel = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, 165.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_netLoadDurationCurveWeekWeekend_ylabel_Font, ALIGNMENT_LEFT );
    t_duurkromme_xlabel1 = new ShapeText(
        SHAPE_DRAW_2D, true,-25.0, -132.0, 0.0, 0.0,
        black,"Duur [u]",
        _t_duurkromme_xlabel1_Font, ALIGNMENT_LEFT );
    t_duurkromme_xlabel2 = new ShapeText(
        SHAPE_DRAW_2D, true,-25.0, 80.0, 0.0, 0.0,
        black,"Duur [u]",
        _t_duurkromme_xlabel2_Font, ALIGNMENT_LEFT );
    t_duurkromme_xlabel3 = new ShapeText(
        SHAPE_DRAW_2D, true,-25.0, 275.0, 0.0, 0.0,
        black,"Duur [u]",
        _t_duurkromme_xlabel3_Font, ALIGNMENT_LEFT );
    t_netLoadDurationCurveTitle = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, -40.0, 0.0, 0.0,
        black,"Belastingduurkromme",
        _t_netLoadDurationCurveTitle_Font, ALIGNMENT_CENTER );
    t_netLoadDurationCurve_xlabel = new ShapeText(
        SHAPE_DRAW_2D, true,205.0, 180.0, 0.0, 0.0,
        black,"Duur [u]",
        _t_netLoadDurationCurve_xlabel_Font, ALIGNMENT_LEFT );
    t_netLoadDurationCurve_ylabel = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, 30.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_netLoadDurationCurve_ylabel_Font, ALIGNMENT_LEFT );
    i_netLoadDurationCurve = new ShapeImage(
		ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 320.0, -40.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_netLoadDurationCurve, 0, clickx, clicky );
      }
    };
    ovalAbsolutePeakDelivery = new ShapeOval(
       SHAPE_DRAW_2D3D, true,43.0, 71.0, 0.0, 0.0,
       null, burlyWood,
	   40.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_maxDelivery_MW = new ShapeText(
        SHAPE_DRAW_2D, true,43.0, 1.0, 0.0, 0.0,
        black,"Max afname",
        _txt_maxDelivery_MW_Font, ALIGNMENT_CENTER );
    t_maxDelivery_MW = new ShapeText(
        SHAPE_DRAW_2D, true,43.0, 61.0, 0.0, 0.0,
        white,"xx MW",
        _t_maxDelivery_MW_Font, ALIGNMENT_CENTER );
    i_maxDelivery = new ShapeImage(
		ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 88.0, 1.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_maxDelivery, 0, clickx, clicky );
      }
    };
    ovalAbsolutePeakFeedin = new ShapeOval(
       SHAPE_DRAW_2D3D, true,66.0, 71.0, 0.0, 0.0,
       null, mediumSeaGreen,
	   40.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_maxFeedin_MW = new ShapeText(
        SHAPE_DRAW_2D, true,66.0, 61.0, 0.0, 0.0,
        white,"xx MW",
        _t_maxFeedin_MW_Font, ALIGNMENT_CENTER );
    txt_maxFeedin_MW = new ShapeText(
        SHAPE_DRAW_2D, true,66.0, 1.0, 0.0, 0.0,
        black,"Max teruglevering",
        _txt_maxFeedin_MW_Font, ALIGNMENT_CENTER );
    i_maxFeedin = new ShapeImage(
		ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 131.0, 1.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_maxFeedin, 0, clickx, clicky );
      }
    };
    ovalRelativePeakDelivery = new ShapeOval(
       SHAPE_DRAW_2D3D, true,64.0, 81.0, 0.0, 0.0,
       null, burlyWood,
	   40.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_maxDelivery_pct = new ShapeText(
        SHAPE_DRAW_2D, true,64.0, 71.0, 0.0, 0.0,
        white,"xx %",
        _t_maxDelivery_pct_Font, ALIGNMENT_CENTER );
    txt_maxFeedin_MW2 = new ShapeText(
        SHAPE_DRAW_2D, true,64.0, 1.0, 0.0, 0.0,
        black,"als percentage van \nafname capaciteit",
        _txt_maxFeedin_MW2_Font, ALIGNMENT_CENTER );
    ovalRelativePeakFeedin = new ShapeOval(
       SHAPE_DRAW_2D3D, true,65.0, 81.0, 0.0, 0.0,
       null, mediumSeaGreen,
	   40.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_maxFeedin_pct = new ShapeText(
        SHAPE_DRAW_2D, true,65.0, 71.0, 0.0, 0.0,
        white,"xx %",
        _t_maxFeedin_pct_Font, ALIGNMENT_CENTER );
    txt_maxFeedin_MW1 = new ShapeText(
        SHAPE_DRAW_2D, true,65.0, 1.0, 0.0, 0.0,
        black,"als percentage van \nteruglever capaciteit",
        _txt_maxFeedin_MW1_Font, ALIGNMENT_CENTER );
    oval_growthPotential = new ShapeOval(
       SHAPE_DRAW_2D3D, true,38.0, 71.0, 0.0, 0.0,
       null, cornflowerBlue,
	   40.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_growthDescription = new ShapeText(
        SHAPE_DRAW_2D, true,37.835, 0.683, 0.0, 0.0,
        black,"Groeiruimte",
        _t_growthDescription_Font, ALIGNMENT_CENTER );
    t_growthPercentage = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 60.638, 0.0, 0.0,
        white,"xx %",
        _t_growthPercentage_Font, ALIGNMENT_CENTER );
    i_negativeGrowth = new ShapeImage(
		ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 83.0, 0.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_negativeGrowth, 0, clickx, clicky );
      }
    };
    t_batterySize = new ShapeText(
        SHAPE_DRAW_2D, true,47.171, 155.0, 0.0, 0.0,
        black,"xx kWh",
        _t_batterySize_Font, ALIGNMENT_CENTER );
    arrowImage2 = new ShapeImage(
		ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 70.0, 185.0, 0.0, 1.5707963267948966,
35.0, 40.0, "/digital_twin_results/",
			new String[]{"arrow.png",} );
    oval_flexGrowthWithBatteryPotential = new ShapeOval(
       SHAPE_DRAW_2D3D, true,50.0, 285.0, 0.0, 0.0,
       null, cornflowerBlue,
	   35.0, 35.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_flexGrowthWithBatteryDescription = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 215.0, 0.0, 0.0,
        black,"Groeiruimte\nmet batterij",
        _t_flexGrowthWithBatteryDescription_Font, ALIGNMENT_CENTER );
    t_flexGrowthWithBatteryPercentage = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 275.0, 0.0, 0.0,
        white,"xx %",
        _t_flexGrowthWithBatteryPercentage_Font, ALIGNMENT_CENTER );
    i_battery = new ShapeImage(
		ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 105.0, 155.0, 0.0, 0.0,
16.062, 16.214, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_battery, 0, clickx, clicky );
      }
    };
    i_flexGrowthWithBattery = new ShapeImage(
		ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 95.0, 220.0, 0.0, 0.0,
16.062, 16.214, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_flexGrowthWithBattery, 0, clickx, clicky );
      }
    };
    arrowImage1 = new ShapeImage(
		ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 70.0, 105.0, 0.0, 1.5707963267948966,
35.0, 40.0, "/digital_twin_results/",
			new String[]{"arrow.png",} );
    oval_flexGrowthWithoutBatteryPotential = new ShapeOval(
       SHAPE_DRAW_2D3D, true,50.0, 70.0, 0.0, 0.0,
       null, cornflowerBlue,
	   35.0, 35.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_flexGrowthWithoutBatteryDescription = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 0.0, 0.0, 0.0,
        black,"Groeiruimte\nzonder batterij",
        _t_flexGrowthWithoutBatteryDescription_Font, ALIGNMENT_CENTER );
    t_flexGrowthWithoutBatteryPercentage = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 60.0, 0.0, 0.0,
        white,"xx %",
        _t_flexGrowthWithoutBatteryPercentage_Font, ALIGNMENT_CENTER );
    i_flexGrowthWithoutBattery = new ShapeImage(
		ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 95.0, 0.0, 0.0, 0.0,
15.906, 16.12, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_flexGrowthWithoutBattery, 0, clickx, clicky );
      }
    };
    batteryImage = new ShapeImage(
		ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, -15.0, 100.0, 0.0, 0.0,
132.813, 125.0, "/digital_twin_results/",
			new String[]{"emptyBattery.png",} );
    t_numberOfChargers = new ShapeText(
        SHAPE_DRAW_2D, true,-75.0, 20.0, 0.0, 0.0,
        black,"Laadpalen: 34",
        _t_numberOfChargers_Font, ALIGNMENT_LEFT );
    rect_concurrency = new ShapeRoundedRectangle(
true,-75.0, -20.0, 0.0,
        null, _rect_concurrency_Fill_Color,
220.0, 30.0,10.0,
		1.0, LINE_STYLE_SOLID );
    t_numberOfHouses = new ShapeText(
        SHAPE_DRAW_2D, true,-145.0, 20.0, 0.0, 0.0,
        black,"Huizen: 23",
        _t_numberOfHouses_Font, ALIGNMENT_LEFT );
    txt_concurrency = new ShapeText(
        SHAPE_DRAW_2D, true,-125.0, -15.0, 0.0, 0.0,
        black,"Gelijktijdigheid",
        _txt_concurrency_Font, ALIGNMENT_CENTER );
    text5 = new ShapeText(
        SHAPE_DRAW_2D, true,-105.0, 0.0, 0.0, 0.0,
        black,"(voor afname)",
        _text5_Font, ALIGNMENT_CENTER );
    t_concurrencyValue = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, -15.0, 0.0, 0.0,
        darkGray,"5.3 kW max per aansluiting",
        _t_concurrencyValue_Font, ALIGNMENT_CENTER );
    t_numberOfRemainingConnections = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 20.0, 0.0, 0.0,
        black,"Overige connecties: 34",
        _t_numberOfRemainingConnections_Font, ALIGNMENT_LEFT );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_seizoen = new Plot(
ChartNetbelasting.this, true, -210.0, -290.0,
			420.0, 170.714,
            null, null,
            50.0, 30.0,
			340.0, 100.714, null, black, black,
            39.286, Chart.NONE,
            Chart.SCALE_FIXED,

0 
            , 
24 * 7 
, Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_dagnacht = new Plot(
ChartNetbelasting.this, true, -210.0, -80.0,
			420.0, 170.714,
            null, null,
            50.0, 30.0,
			340.0, 100.714, null, black, black,
            39.286, Chart.NONE,
            Chart.SCALE_FIXED,

0 
            , 
4380 
, Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_week = new Plot(
ChartNetbelasting.this, true, -210.0, 120.0,
			420.0, 230.0,
            null, null,
            50.0, 30.0,
			340.0, 100.0, null, black, black,
            70.0, Chart.SOUTH,
            Chart.SCALE_FIXED,

0 
            , 
24*5*52 
, Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_jaar = new Plot(
ChartNetbelasting.this, true, 10.0, -40.0,
			420.0, 270.0,
            null, null,
            50.0, 30.0,
			340.0, 160.714, null, black, black,
            39.286, Chart.SOUTH,
            Chart.SCALE_FIXED,

0 
            , 
8760 
, Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    gr_details = new ShapeGroup( ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 680.0, 380.0, 0.0, 0.0
	
	     , plot_seizoen
	     , plot_dagnacht
	     , plot_week
	     , tx_topBarplotText3
	     , tx_topBarplotText4
	     , tx_topBarplotText5
	     , t_netLoadDurationCurveSummerWinter_ylabel
	     , t_netLoadDurationCurveDayNight_ylabel
	     , t_netLoadDurationCurveWeekWeekend_ylabel
	     , t_duurkromme_xlabel1
	     , t_duurkromme_xlabel2
	     , t_duurkromme_xlabel3 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_details_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_details.setVisible( false );
    {
    gr_absoluteDeliveryInfo = new ShapeGroup( ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 175.0, 300.0, 0.0, 0.0
	
	     , ovalAbsolutePeakDelivery
	     , txt_maxDelivery_MW
	     , t_maxDelivery_MW
	     , i_maxDelivery );
    }
    {
    gr_absoluteFeedinInfo = new ShapeGroup( ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 305.0, 300.0, 0.0, 0.0
	
	     , ovalAbsolutePeakFeedin
	     , t_maxFeedin_MW
	     , txt_maxFeedin_MW
	     , i_maxFeedin );
    }
    {
    gr_relativeDeliveryInfo = new ShapeGroup( ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 155.0, 420.0, 0.0, 0.0
	
	     , ovalRelativePeakDelivery
	     , t_maxDelivery_pct
	     , txt_maxFeedin_MW2 );
    }
    {
    gr_relativeFeedinInfo = new ShapeGroup( ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 305.0, 420.0, 0.0, 0.0
	
	     , ovalRelativePeakFeedin
	     , t_maxFeedin_pct
	     , txt_maxFeedin_MW1 );
    }
    {
    gr_growthPotential = new ShapeGroup( ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 40.0, 300.0, 0.0, 0.0
	
	     , oval_growthPotential
	     , t_growthDescription
	     , t_growthPercentage
	     , i_negativeGrowth );
    }
    {
    gr_flexGrowthPotential = new ShapeGroup( ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 1100.0, 210.0, 0.0, 0.0
	
	     , t_batterySize
	     , arrowImage2
	     , oval_flexGrowthWithBatteryPotential
	     , t_flexGrowthWithBatteryDescription
	     , t_flexGrowthWithBatteryPercentage
	     , i_battery
	     , i_flexGrowthWithBattery
	     , arrowImage1
	     , oval_flexGrowthWithoutBatteryPotential
	     , t_flexGrowthWithoutBatteryDescription
	     , t_flexGrowthWithoutBatteryPercentage
	     , i_flexGrowthWithoutBattery
	     , batteryImage ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_flexGrowthPotential_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_concurrencyKPI = new ShapeGroup( ChartNetbelasting.this, SHAPE_DRAW_2D, true, 1140.0, 30.0, 0.0, 0.0
	
	     , t_numberOfChargers
	     , rect_concurrency
	     , t_numberOfHouses
	     , txt_concurrency
	     , text5
	     , t_concurrencyValue
	     , t_numberOfRemainingConnections ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_concurrencyKPI_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_concurrencyKPI.setVisible( false );
    {
    gr_year = new ShapeGroup( ChartNetbelasting.this, SHAPE_DRAW_2D3D, true, 0.0, 130.0, 0.0, 0.0
	
	     , plot_jaar
	     , t_netLoadDurationCurveTitle
	     , t_netLoadDurationCurve_xlabel
	     , t_netLoadDurationCurve_ylabel
	     , i_netLoadDurationCurve
	     , gr_absoluteDeliveryInfo
	     , gr_absoluteFeedinInfo
	     , gr_relativeDeliveryInfo
	     , gr_relativeFeedinInfo
	     , gr_growthPotential
	     , gr_flexGrowthPotential
	     , gr_concurrencyKPI );
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
  public ChartNetbelasting( Engine engine, Agent owner, AgentList<? extends ChartNetbelasting> ownerPopulation ) {
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
  public ChartNetbelasting() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartNetbelasting_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartNetbelasting.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartNetbelasting.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    radio.setValueToDefault();
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
    setupPlainVariables_ChartNetbelasting_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartNetbelasting_xjal() {
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

  public AgentList<? extends ChartNetbelasting> getPopulation() {
    return (AgentList<? extends ChartNetbelasting>) super.getPopulation();
  }

  public List<? extends ChartNetbelasting> agentsInRange( double distance ) {
    return (List<? extends ChartNetbelasting>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
  	for (int _pIdx = 0; _pIdx < plot_seizoen.getCount(); _pIdx++) {
  		DataSet _ds = plot_seizoen.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_seizoen.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_seizoen : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < plot_dagnacht.getCount(); _pIdx++) {
  		DataSet _ds = plot_dagnacht.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_dagnacht.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_dagnacht : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < plot_week.getCount(); _pIdx++) {
  		DataSet _ds = plot_week.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_week.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_week : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < plot_jaar.getCount(); _pIdx++) {
  		DataSet _ds = plot_jaar.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_jaar.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_jaar : " + _t );
  	}
    super.onDestroy();
  }


}
