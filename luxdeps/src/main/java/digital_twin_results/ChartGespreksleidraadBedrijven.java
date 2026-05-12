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

public class ChartGespreksleidraadBedrijven extends digital_twin_results.ChartArea
{
  // Parameters
  // Plain Variables

  public 
Color 
 v_selfConsumedEnergyColor;
  public 
Color 
 v_importedEnergyColor;
  public 
Color 
 v_exportedEnergyColor;
  public 
String 
 v_selfConsumedEnergyText;
  public 
String 
 v_importedEnergyText;
  public 
String 
 v_exportedEnergyText;
  public 
Color 
 v_selfConsumedElectricityColor;
  public 
Color 
 v_importedElectricityColor;
  public 
Color 
 v_exportedElectricityColor;
  public 
Color 
 v_naturalGasDemandColor;
  public 
Color 
 v_districtHeatDemandColor;
  public 
Color 
 v_electricityBaseloadDemandColor;
  public 
Color 
 v_electricityForTransportDemandColor;
  public 
Color 
 v_electricityForHydrogenDemandColor;
  public 
Color 
 v_electricityForHeatDemandColor;
  public 
Color 
 v_electricityForStorageDemandColor;
  public 
Color 
 v_PVElectricitySupplyColor;
  public 
Color 
 v_windElectricitySupplyColor;
  public 
Color 
 v_storageElectricitySupplyColor;
  public 
Color 
 v_V2GElectricitySupplyColor;
  public 
String 
 v_petroleumProductsDemandText;
  public 
Color 
 v_petroleumProductsDemandColor;
  public 
Color 
 v_naturalGasSupplyColor;
  public 
Color 
 v_petroleumProductsSupplyColor;
  public 
Color 
 v_districtHeatHeatSupplyColor;
  public 
String 
 v_naturalGasDemandText;
  public 
String 
 v_districtHeatDemandText;
  public 
String 
 v_electricityBaseloadDemandText;
  public 
String 
 v_electricityForTransportDemandText;
  public 
String 
 v_electricityForHydrogenDemandText;
  public 
String 
 v_electricityForHeatDemandText;
  public 
String 
 v_electricityForStorageDemandText;
  public 
String 
 v_PVElectricitySupplyText;
  public 
String 
 v_windElectricitySupplyText;
  public 
String 
 v_storageElectricitySupplyText;
  public 
String 
 v_V2GElectricitySupplyText;
  public 
String 
 v_naturalGasSupplyText;
  public 
String 
 v_petroleumProductsSupplyText;
  public 
String 
 v_districtHeatHeatSupplyText;
  public 
Color 
 v_energyDemandColor;
  public 
String 
 v_energyDemandText;
  public 
Color 
 v_electricityDemandColor;
  public 
Color 
 v_hydrogenDemandColor;
  public 
String 
 v_electricityDemandText;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartGespreksleidraadBedrijven.class );

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
  public EventTimeout _energyDemandChartYearGespreksleidraad1_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_barChartGSLDSummary3_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _energyDemandChartYearGespreksleidraad1_autoUpdateEvent_xjal ) return "energyDemandChartYearGespreksleidraad1 auto update event";
     if( _e == _chart_barChartGSLDSummary3_autoUpdateEvent_xjal ) return "chart_barChartGSLDSummary3 auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _energyDemandChartYearGespreksleidraad1_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart_barChartGSLDSummary3_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _energyDemandChartYearGespreksleidraad1_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _chart_barChartGSLDSummary3_autoUpdateEvent_xjal ) {
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
    if( _e == _energyDemandChartYearGespreksleidraad1_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _chart_barChartGSLDSummary3_autoUpdateEvent_xjal) {
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
    if ( _e == _energyDemandChartYearGespreksleidraad1_autoUpdateEvent_xjal ) {
      energyDemandChartYearGespreksleidraad1.updateData();
      return;
    }
    if ( _e == _chart_barChartGSLDSummary3_autoUpdateEvent_xjal ) {
      chart_barChartGSLDSummary3.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = digital_twin_results.ChartArea._STATECHART_COUNT_xjal + 0;


  // Functions

  void f_setGespreksleidraadBedrijvenCharts(  ) { 

gr_GSLDSummary1.setVisible(false);
gr_GSLDSummary2.setVisible(false);
gr_GSLDSummary3.setVisible(false);
f_setWarningScreen(false);


		
I_EnergyData data = uI_Results.f_getSelectedObjectData();

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 85, true);

if(uI_Results.v_selectedObjectScope != OL_ResultScope.ENERGYCOOP && uI_Results.v_selectedObjectScope != OL_ResultScope.ENERGYMODEL){
	f_setWarningScreen(true);
	return;
}

if (rb_gespreksleidraadBedrijvenChartType.getValue()==0) {
	gr_GSLDSummary1.setVisible(true);
	f_setChartsGespreksleidraadBedrijven1(data);
} else if (rb_gespreksleidraadBedrijvenChartType.getValue()==1) {
	gr_GSLDSummary2.setVisible(true);
	f_setChartsGespreksleidraadBedrijven2(data);
} else if (rb_gespreksleidraadBedrijvenChartType.getValue()==2) {
	gr_GSLDSummary3.setVisible(true);
	f_setChartsGespreksleidraadBedrijven3(data);
}
 
  }

  void f_setChartsGespreksleidraadBedrijven1( I_EnergyData data ) { 

f_setEnergyBalanceChartTotal(data);

f_setDemandAndSupplyGespreksleidraadBedrijven1(data);


 
  }

  void f_setChartsGespreksleidraadBedrijven2( I_EnergyData data ) { 

double annualSelfConsumedElectricityIndividual_MWh = 0;
if (data instanceof EnergyCoop COOP){
	annualSelfConsumedElectricityIndividual_MWh = COOP.v_cumulativeIndividualSelfconsumptionElectricity_MWh;
}
else if(data instanceof EnergyModel EM){
	annualSelfConsumedElectricityIndividual_MWh = sum(EM.f_getActiveGridConnections(), GC -> GC.v_rapidRunData.getTotalElectricitySelfConsumed_MWh());
}

annualSelfConsumedElectricityIndividual_MWh = max(0, annualSelfConsumedElectricityIndividual_MWh);

f_setSelfConsumptionChart(annualSelfConsumedElectricityIndividual_MWh, data.getRapidRunData().getTotalElectricitySelfConsumed_MWh(), data.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.ELECTRICITY),
					pl_productionChartIndividual, pl_productionChartCollective);


 
  }

  void f_setSelfConsumptionChart( double selfConsumedEnergyIndividual_MWh, double selfConsumedEnergyCollective_MWh, double export_MWh, StackChart pl_individualChart, StackChart pl_collectiveChart ) { 

//gr_onbalansGraphs.setVisible(false);

DataItem d1 = new DataItem();
d1.setValue(selfConsumedEnergyIndividual_MWh);
DataItem d2 = new DataItem();
d2.setValue(selfConsumedEnergyCollective_MWh);
DataItem d3 = new DataItem();
d3.setValue(export_MWh);
DataItem d4 = new DataItem();
d4.setValue((selfConsumedEnergyCollective_MWh+export_MWh)-selfConsumedEnergyIndividual_MWh);
pl_individualChart.removeAll();
pl_collectiveChart.removeAll();
pl_individualChart.addDataItem(d1,"Zelf gebruikt",v_selfConsumedElectricityColor);
pl_individualChart.addDataItem(d4,"Teruggeleverd",v_exportedEnergyColor);
//pl_consumptionChart.addDataItem(d4,"Overbelasting [MWh]",red);
pl_collectiveChart.addDataItem(d2,"Lokaal gebruikt",v_selfConsumedElectricityColor);
pl_collectiveChart.addDataItem(d3,"Geëxporteerd",v_exportedEnergyColor);
//pl_productionChart.addDataItem(d5,"Overbelasting [MWh]",red);
double chartScale_MWh = selfConsumedEnergyCollective_MWh+export_MWh;
pl_individualChart.setFixedScale(chartScale_MWh);
pl_collectiveChart.setFixedScale(chartScale_MWh);

 
  }

  void f_setDemandAndSupplyGespreksleidraadBedrijven1( I_EnergyData data ) { 

//Electricity demand chart
energyDemandChartYearGespreksleidraad1.removeAll();

double startTime_h = 0;
energyDemandChartYearGespreksleidraad1.addDataSet(data.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(startTime_h), v_electricityDemandText, v_energyDemandColor, true, false, Chart.INTERPOLATION_LINEAR, 2, Chart.POINT_NONE);

//Electricity supply chart
energySupplyChartYearGespreksleidraad1.removeAll();
if(data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.windProductionElectric_kW)){
	energySupplyChartYearGespreksleidraad1.addDataSet(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.windProductionElectric_kW).getDataSet(startTime_h, 24.0), v_windElectricitySupplyText, v_windElectricitySupplyColor);
}
if(data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW)){
	energySupplyChartYearGespreksleidraad1.addDataSet(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.pvProductionElectric_kW).getDataSet(startTime_h, 24.0), v_PVElectricitySupplyText, v_PVElectricitySupplyColor);
}
if(data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.batteriesDischargingPower_kW)){
	energySupplyChartYearGespreksleidraad1.addDataSet(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.batteriesDischargingPower_kW).getDataSet(startTime_h, 24.0), v_storageElectricitySupplyText, v_storageElectricitySupplyColor);
}
if(data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.V2GPower_kW)){
	energySupplyChartYearGespreksleidraad1.addDataSet(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.V2GPower_kW).getDataSet(startTime_h, 24.0), v_V2GElectricitySupplyText, v_V2GElectricitySupplyColor);
}
if(data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.CHPProductionElectric_kW)){
	energySupplyChartYearGespreksleidraad1.addDataSet(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.CHPProductionElectric_kW).getDataSet(startTime_h, 24.0), "WKK plec prod.", gray);
}
double maxScale = max(data.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getMaxPower_kW(),data.getRapidRunData().am_dailyAverageProductionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getMaxPower_kW());
//double maxScale = max(energySupplyChartYearGespreksleidraad1.getScaleY(), energyDemandChartYearGespreksleidraad1.getScaleY());
energyDemandChartYearGespreksleidraad1.setFixedVerticalScale(0, maxScale);
energySupplyChartYearGespreksleidraad1.setFixedVerticalScale(maxScale);

//Reset view
energyDemandChartYearGespreksleidraad1.setVisible(false);
energySupplyChartYearGespreksleidraad1.setVisible(false);
energyDemandChartYearGespreksleidraad1.setVisible(true);
energySupplyChartYearGespreksleidraad1.setVisible(true); 
  }

  void f_setChartsGespreksleidraadBedrijven3( I_EnergyData data ) { 

chart_barChartGSLDSummary3.removeAll();

t_titleGespreksleidraadBedrijven3.setText("Wat is de maximale piek van\n het collectief vs individueel");
DataItem totalGTV_kW = new DataItem();
DataItem peakIndividual_kW = new DataItem();
DataItem peakCollective_kW = new DataItem();
String text_peakType = "";

if (data instanceof EnergyCoop COOP){
	if(rb_GSLDSummary3_delivery_or_feedin.getValue() == 0){//Delivery
		totalGTV_kW.setValue(data.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW());
		peakIndividual_kW.setValue(COOP.v_cumulativeIndividualPeakDelivery_kW);
		peakCollective_kW.setValue(data.getRapidRunData().getPeakDelivery_kW());
		text_peakType = "levering";
	}
	else if(rb_GSLDSummary3_delivery_or_feedin.getValue() == 1){//Feedin
		totalGTV_kW.setValue(data.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW());
		peakIndividual_kW.setValue(COOP.v_cumulativeIndividualPeakFeedin_kW);
		peakCollective_kW.setValue(data.getRapidRunData().getPeakFeedin_kW());
		text_peakType = "teruglevering";
	}
}
else if(data instanceof EnergyModel EM){
	if(rb_GSLDSummary3_delivery_or_feedin.getValue() == 0){//Delivery
		totalGTV_kW.setValue(data.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW());
		peakIndividual_kW.setValue(sum(EM.f_getActiveGridConnections(), GC -> GC.v_rapidRunData.getPeakDelivery_kW()));
		peakCollective_kW.setValue(data.getRapidRunData().getPeakDelivery_kW());
		text_peakType = "levering";
	}
	else if(rb_GSLDSummary3_delivery_or_feedin.getValue() == 1){//Feedin
		totalGTV_kW.setValue(data.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW());
		peakIndividual_kW.setValue(sum(EM.f_getActiveGridConnections(), GC -> GC.v_rapidRunData.getPeakFeedin_kW()));
		peakCollective_kW.setValue(data.getRapidRunData().getPeakFeedin_kW());
		text_peakType = "teruglevering";
	}
}



chart_barChartGSLDSummary3.addDataItem(totalGTV_kW,"Totaal GTV " + text_peakType,darkMagenta);
chart_barChartGSLDSummary3.addDataItem(peakIndividual_kW,"Piek " + text_peakType + " individueel",orange);
chart_barChartGSLDSummary3.addDataItem(peakCollective_kW,"Piek " + text_peakType + " collectief",green);
 
  }

  void f_setWarningScreen( boolean showWarningScreen ) { 

gr_warningScreen.setVisible(showWarningScreen); 
  }

  void f_setEnergyBalanceChartTotal( I_EnergyData dataObject ) { 

//Reset charts
pl_productionChartBalanceTotal.removeAll();
pl_consumptionChartBalanceTotal.removeAll();

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
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_gespreksleidraadBedrijvenChartType_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_GSLDSummary3_delivery_or_feedin_Font = _rb_gespreksleidraadBedrijvenChartType_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText3_Font = new Font("Arial", 0, 28 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextYear_Font = new Font("Arial", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextYear_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_xlabel1_Font = new Font("Arial", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_ylabel1_Font = _t_duurkromme_xlabel1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText7_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text594_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text595_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_titleGespreksleidraadBedrijven3_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_ylabel2_Font = _t_duurkromme_xlabel1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_WarningScreenMessage_Font = new Font("SansSerif", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_resultsSmall3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_productionTextYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_consumptionTextYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_onbalansBarplot4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_xlabel1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_ylabel1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_GSLDSummary1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText7 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _text594 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_KPIzelfvoorzienendheid1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _text595 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_KPIzelfvoorzienendheid2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_zelfconsumptieBarplots = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GSLDSummary2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_GSLDSummary2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GSLDSummary3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_titleGespreksleidraadBedrijven3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_ylabel2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_GSLDSummary3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_warningScreenGespreksleidraadBedrijven = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_WarningScreenMessage = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_warningScreen = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartBalanceTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartBalanceTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _energySupplyChartYearGespreksleidraad1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _energyDemandChartYearGespreksleidraad1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartIndividual = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartCollective = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart_barChartGSLDSummary3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_gespreksleidraadBedrijvenChartType = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_GSLDSummary3_delivery_or_feedin = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;

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
	  level.addAll(gr_GSLDSummary1, rectangle, rb_gespreksleidraadBedrijvenChartType, gr_GSLDSummary2, gr_GSLDSummary3, gr_warningScreen);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _rect_warningScreenGespreksleidraadBedrijven:
        if (true) {
          ShapeRectangle self = this.rect_warningScreenGespreksleidraadBedrijven;
          
int click = 0; 
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
      case _rb_gespreksleidraadBedrijvenChartType: {
          ShapeRadioButtonGroup self = this.rb_gespreksleidraadBedrijvenChartType;
f_setGespreksleidraadBedrijvenCharts(); 
;}
        break;
      case _rb_GSLDSummary3_delivery_or_feedin: {
          ShapeRadioButtonGroup self = this.rb_GSLDSummary3_delivery_or_feedin;
f_setGespreksleidraadBedrijvenCharts(); 
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
      case _rb_gespreksleidraadBedrijvenChartType: return 
0 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_barChartGSLDSummary3_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_barChartGSLDSummary3_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_barChartGSLDSummary3_DataItem2Value() {
    return 
0 
;
  }
  protected ShapeRadioButtonGroup rb_gespreksleidraadBedrijvenChartType;
  protected ShapeRadioButtonGroup rb_GSLDSummary3_delivery_or_feedin;
  protected StackChart pl_productionChartBalanceTotal;
  protected StackChart pl_consumptionChartBalanceTotal;
  protected TimeStackChart energySupplyChartYearGespreksleidraad1;
  protected TimePlot energyDemandChartYearGespreksleidraad1;
  protected StackChart pl_productionChartIndividual;
  protected StackChart pl_productionChartCollective;
  protected BarChart chart_barChartGSLDSummary3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_resultsSmall3_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
lavender 
);
  }
  
  protected ShapeRectangle rect_resultsSmall3;
  protected ShapeText tx_topBarplotText3;
  protected ShapeText t_productionTextYear;
  protected ShapeText t_consumptionTextYear;
  protected ShapeGroup gr_onbalansBarplot4;
  protected ShapeText t_duurkromme_xlabel1;
  protected ShapeText t_duurkromme_ylabel1;
  protected ShapeGroup gr_GSLDSummary1;
  
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
  protected ShapeText tx_topBarplotText7;
  protected ShapeText text594;
  protected ShapeGroup gr_KPIzelfvoorzienendheid1;
  protected ShapeText text595;
  protected ShapeGroup gr_KPIzelfvoorzienendheid2;
  protected ShapeGroup gr_zelfconsumptieBarplots;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GSLDSummary2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
lavender 
);
  }
  
  protected ShapeRectangle rect_GSLDSummary2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_GSLDSummary2_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
265 
);
    shape.setY(
435 
);
  }
  
  protected ShapeGroup gr_GSLDSummary2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GSLDSummary3_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
lavender 
);
  }
  
  protected ShapeRectangle rect_GSLDSummary3;
  protected ShapeText t_titleGespreksleidraadBedrijven3;
  protected ShapeText t_duurkromme_ylabel2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_GSLDSummary3_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
240 
);
    shape.setY(
420 
);
  }
  
  protected ShapeGroup gr_GSLDSummary3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_warningScreenGespreksleidraadBedrijven_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_lineColor 
);
    shape.setLineWidth(
v_lineWidth 
);
  }
  
  protected ShapeRectangle rect_warningScreenGespreksleidraadBedrijven;
  protected ShapeText txt_WarningScreenMessage;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_warningScreen_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
230 
);
    shape.setY(
410 
);
  }
  
  protected ShapeGroup gr_warningScreen;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rb_gespreksleidraadBedrijvenChartType = new ShapeRadioButtonGroup(
ChartGespreksleidraadBedrijven.this, true, 120.0, 5.0,
			220.0, 80.0,
            black, true,
_rb_gespreksleidraadBedrijvenChartType_Font, true,
            new String[]{"Opwek en verbruik over het jaar", "Individuele en collectieve zelfconsumptie", "Capaciteit en pieken", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_gespreksleidraadBedrijvenChartType, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _rb_gespreksleidraadBedrijvenChartType, 0 ) );
      }
    };
    rb_GSLDSummary3_delivery_or_feedin = new ShapeRadioButtonGroup(
ChartGespreksleidraadBedrijven.this, true, -80.0, -300.0,
			170.0, 60.0,
            black, true,
_rb_GSLDSummary3_delivery_or_feedin_Font, false,
            new String[]{"Afname", "Teruglevering", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_GSLDSummary3_delivery_or_feedin, 0, value );
      }
    };
    rect_resultsSmall3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-260.0, -360.0, 0.0, 0.0,
            gray, null,
			460.0, 660.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_resultsSmall3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_resultsSmall3.setVisible( false );
    tx_topBarplotText3 = new ShapeText(
        SHAPE_DRAW_2D, true,-30.0, -310.0, 0.0, 0.0,
        black,"Hoeveel energieverbruik\nen opwek is er over het jaar?",
        _tx_topBarplotText3_Font, ALIGNMENT_CENTER );
    t_productionTextYear = new ShapeText(
        SHAPE_DRAW_2D, true,-260.0, -101.212, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextYear_Font, ALIGNMENT_RIGHT );
    t_consumptionTextYear = new ShapeText(
        SHAPE_DRAW_2D, true,-260.0, 40.808, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextYear_Font, ALIGNMENT_RIGHT );
    t_duurkromme_xlabel1 = new ShapeText(
        SHAPE_DRAW_2D, true,155.0, 220.0, 0.0, 0.0,
        black,"Maand",
        _t_duurkromme_xlabel1_Font, ALIGNMENT_LEFT );
    t_duurkromme_ylabel1 = new ShapeText(
        SHAPE_DRAW_2D, true,-231.0, 70.0, 0.0, 1.5707963267948966,
        black,"Gemiddeld elektrisch vermogen [kW]",
        _t_duurkromme_ylabel1_Font, ALIGNMENT_LEFT );
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
    tx_topBarplotText7 = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, -290.0, 0.0, 0.0,
        black,"Kan ik verbruik en opwek\nop elkaar afstemmen?",
        _tx_topBarplotText7_Font, ALIGNMENT_CENTER );
    text594 = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -80.0, 0.0, 0.0,
        black,"Individuele\nzelfconsumptie\n[MWh]",
        _text594_Font, ALIGNMENT_CENTER );
    text595 = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -80.0, 0.0, 0.0,
        black,"Collectieve\nzelfconsumptie\n[MWh]",
        _text595_Font, ALIGNMENT_CENTER );
    rect_GSLDSummary2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-265.333, -354.667, 0.0, 0.0,
            gray, null,
			460.0, 669.667, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GSLDSummary2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GSLDSummary2.setVisible( false );
    rect_GSLDSummary3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-240.0, -340.0, 0.0, 0.0,
            gray, null,
			460.0, 670.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GSLDSummary3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GSLDSummary3.setVisible( false );
    t_titleGespreksleidraadBedrijven3 = new ShapeText(
        SHAPE_DRAW_2D, true,-10.0, -230.0, 0.0, 0.0,
        black,"Wat is de maximale piek van\nhet collectief vs individueel?",
        _t_titleGespreksleidraadBedrijven3_Font, ALIGNMENT_CENTER );
    t_duurkromme_ylabel2 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, 20.0, 0.0, 4.71238898038469,
        black,"kW",
        _t_duurkromme_ylabel2_Font, ALIGNMENT_CENTER );
    rect_warningScreenGespreksleidraadBedrijven = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -330.0, 0.0, 0.0,
            lavender, lavender,
			460.0, 660.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_warningScreenGespreksleidraadBedrijven_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_warningScreenGespreksleidraadBedrijven, 0, clickx, clicky );
      }
    };
    txt_WarningScreenMessage = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, -110.0, 0.0, 0.0,
        black,"LET OP: Het geselecteerde object wordt \nniet ondersteund door deze grafiek!\n\nSelecteer het gehele gebied \nof maak een selectie van aansluitingen \nom deze grafieken te gebruiken.",
        _txt_WarningScreenMessage_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartBalanceTotal = new StackChart(
ChartGespreksleidraadBedrijven.this, true, -292.133, -141.007,
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
ChartGespreksleidraadBedrijven.this, true, -293.04, 0.0,
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
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    energySupplyChartYearGespreksleidraad1 = new TimeStackChart(
ChartGespreksleidraadBedrijven.this, true, -260.0, 60.0,
			460.0, 210.0,
            null, null,
            70.0, 30.0,
			360.0, 120.0, white, null, black,
            30.0, Chart.SOUTH,

365 
             * day(), Chart.WINDOW_MOVES_WITH_TIME, "MM", Chart.SCALE_AUTO
,0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    energyDemandChartYearGespreksleidraad1 = new TimePlot(
ChartGespreksleidraadBedrijven.this, true, -260.0, 50.0,
			460.0, 260.0,
            null, null,
            70.0, 30.0,
			360.0, 120.0, null, null, black,
            40.0, Chart.SOUTH,

365 
             * day(), Chart.WINDOW_MOVES_WITH_TIME, "MM", Chart.SCALE_AUTO,
0, 0, Chart.GRID_NONE, Chart.GRID_NONE,
            null, null, _items, _titles, _appearances );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartIndividual = new StackChart(
ChartGespreksleidraadBedrijven.this, true, -324.675, -112.208,
			132.948, 216.007,
            null, null,
            60.0, 30.0,
			54.67500000000001, 147.208, null, black, black,
            36.007000000000005, Chart.SOUTH,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartCollective = new StackChart(
ChartGespreksleidraadBedrijven.this, true, -120.0, -112.208,
			160.0, 215.065,
            null, null,
            55.0, 30.0,
			55.0, 147.208, null, black, black,
            35.0, Chart.SOUTH,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 3 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_barChartGSLDSummary3_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_barChartGSLDSummary3_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_barChartGSLDSummary3_DataItem2Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 3 );
    _titles.add( "Totaal GTV" );
    _titles.add( "Piek levering individueel" );
    _titles.add( "Piek levering collectief" );
    List<Color> _colors = new ArrayList<>( 3 );
    _colors.add( darkMagenta );
    _colors.add( orange );
    _colors.add( darkKhaki );
    chart_barChartGSLDSummary3 = new BarChart(
ChartGespreksleidraadBedrijven.this, true, -190.0, -110.0,
			350.0, 330.0,
            null, null,
            50.0, 30.0,
			270.0, 200.0, white, black, black,
            70.0, Chart.SOUTH,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    gr_onbalansBarplot4 = new ShapeGroup( ChartGespreksleidraadBedrijven.this, SHAPE_DRAW_2D3D, true, 120.0, -120.0, 0.0, 0.0
	
	     , pl_productionChartBalanceTotal
	     , pl_consumptionChartBalanceTotal
	     , t_productionTextYear
	     , t_consumptionTextYear );
    }
    {
    gr_GSLDSummary1 = new ShapeGroup( ChartGespreksleidraadBedrijven.this, SHAPE_DRAW_2D3D, true, 260.0, 440.0, 0.0, 0.0
	
	     , rect_resultsSmall3
	     , tx_topBarplotText3
	     , gr_onbalansBarplot4
	     , energySupplyChartYearGespreksleidraad1
	     , energyDemandChartYearGespreksleidraad1
	     , t_duurkromme_xlabel1
	     , t_duurkromme_ylabel1 );
    }
    {
    gr_KPIzelfvoorzienendheid1 = new ShapeGroup( ChartGespreksleidraadBedrijven.this, SHAPE_DRAW_2D3D, true, -150.0, -120.0, 0.0, 0.0
	
	     , text594 );
    }
    {
    gr_KPIzelfvoorzienendheid2 = new ShapeGroup( ChartGespreksleidraadBedrijven.this, SHAPE_DRAW_2D3D, true, 50.0, -120.0, 0.0, 0.0
	
	     , text595 );
    }
    {
    gr_zelfconsumptieBarplots = new ShapeGroup( ChartGespreksleidraadBedrijven.this, SHAPE_DRAW_2D3D, true, 90.0, -20.0, 0.0, 0.0
	
	     , pl_productionChartIndividual
	     , pl_productionChartCollective );
    }
    {
    gr_GSLDSummary2 = new ShapeGroup( ChartGespreksleidraadBedrijven.this, SHAPE_DRAW_2D3D, true, 750.0, 435.0, 0.0, 0.0
	
	     , tx_topBarplotText7
	     , gr_KPIzelfvoorzienendheid1
	     , gr_KPIzelfvoorzienendheid2
	     , gr_zelfconsumptieBarplots
	     , rect_GSLDSummary2 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_GSLDSummary2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_GSLDSummary2.setVisible( false );
    {
    gr_GSLDSummary3 = new ShapeGroup( ChartGespreksleidraadBedrijven.this, SHAPE_DRAW_2D3D, true, 1210.0, 420.0, 0.0, 0.0
	
	     , rect_GSLDSummary3
	     , t_titleGespreksleidraadBedrijven3
	     , chart_barChartGSLDSummary3
	     , t_duurkromme_ylabel2
	     , rb_GSLDSummary3_delivery_or_feedin ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_GSLDSummary3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_GSLDSummary3.setVisible( false );
    {
    gr_warningScreen = new ShapeGroup( ChartGespreksleidraadBedrijven.this, SHAPE_DRAW_2D3D, true, 1680.0, 420.0, 0.0, 0.0
	
	     , rect_warningScreenGespreksleidraadBedrijven
	     , txt_WarningScreenMessage ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_warningScreen_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_warningScreen.setVisible( false );
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
  public ChartGespreksleidraadBedrijven( Engine engine, Agent owner, AgentList<? extends ChartGespreksleidraadBedrijven> ownerPopulation ) {
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
  public ChartGespreksleidraadBedrijven() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartGespreksleidraadBedrijven_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartGespreksleidraadBedrijven.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartGespreksleidraadBedrijven.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    rb_gespreksleidraadBedrijvenChartType.setValueToDefault();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _energyDemandChartYearGespreksleidraad1_autoUpdateEvent_xjal.start();
    _chart_barChartGSLDSummary3_autoUpdateEvent_xjal.start();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartGespreksleidraadBedrijven_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartGespreksleidraadBedrijven_xjal() {
    v_selfConsumedEnergyColor = 
yellowGreen 
;
    v_importedEnergyColor = 
brown 
;
    v_exportedEnergyColor = 
navy 
;
    v_selfConsumedEnergyText = 
"Zelfconsumptie [MWh]" 
;
    v_importedEnergyText = 
"Invoer [MWh]" 
;
    v_exportedEnergyText = 
"Uitvoer [MWh]" 
;
    v_selfConsumedElectricityColor = 
yellowGreen 
;
    v_importedElectricityColor = 
brown 
;
    v_exportedElectricityColor = 
navy 
;
    v_naturalGasDemandColor = 
silver 
;
    v_districtHeatDemandColor = 
peru 
;
    v_electricityBaseloadDemandColor = 
lightBlue 
;
    v_electricityForTransportDemandColor = 
indigo 
;
    v_electricityForHydrogenDemandColor = 
dodgerBlue 
;
    v_electricityForHeatDemandColor = 
violetRed 
;
    v_electricityForStorageDemandColor = 
thistle 
;
    v_PVElectricitySupplyColor = 
gold 
;
    v_windElectricitySupplyColor = 
lightSkyBlue 
;
    v_storageElectricitySupplyColor = 
yellowGreen 
;
    v_V2GElectricitySupplyColor = 
mediumOrchid 
;
    v_petroleumProductsDemandText = 
"Brandstoffen" 
;
    v_petroleumProductsDemandColor = 
darkGray 
;
    v_naturalGasSupplyColor = 
silver 
;
    v_petroleumProductsSupplyColor = 
darkGray 
;
    v_districtHeatHeatSupplyColor = 
peru 
;
    v_naturalGasDemandText = 
"Aardgas" 
;
    v_districtHeatDemandText = 
"Warmte" 
;
    v_electricityBaseloadDemandText = 
"Elek. basislast" 
;
    v_electricityForTransportDemandText = 
"Elek. vervoer" 
;
    v_electricityForHydrogenDemandText = 
"Elek. waterstof" 
;
    v_electricityForHeatDemandText = 
"Elek. warmtepompen" 
;
    v_electricityForStorageDemandText = 
"Elek. opslag" 
;
    v_PVElectricitySupplyText = 
"Zon PV" 
;
    v_windElectricitySupplyText = 
"Wind" 
;
    v_storageElectricitySupplyText = 
"Ontladen opslag" 
;
    v_V2GElectricitySupplyText = 
"Ontladen V2G" 
;
    v_naturalGasSupplyText = 
"Aardgas" 
;
    v_petroleumProductsSupplyText = 
"Brandstoffen" 
;
    v_districtHeatHeatSupplyText = 
"Warmte" 
;
    v_energyDemandColor = 
fireBrick 
;
    v_energyDemandText = 
"Energievraag" 
;
    v_electricityDemandColor = 
lightGreen 
;
    v_hydrogenDemandColor = 
cornflowerBlue 
;
    v_electricityDemandText = 
"Elektriciteitsvraag" 
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

  public AgentList<? extends ChartGespreksleidraadBedrijven> getPopulation() {
    return (AgentList<? extends ChartGespreksleidraadBedrijven>) super.getPopulation();
  }

  public List<? extends ChartGespreksleidraadBedrijven> agentsInRange( double distance ) {
    return (List<? extends ChartGespreksleidraadBedrijven>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _energyDemandChartYearGespreksleidraad1_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart_barChartGSLDSummary3_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _energyDemandChartYearGespreksleidraad1_autoUpdateEvent_xjal.onDestroy();
    _chart_barChartGSLDSummary3_autoUpdateEvent_xjal.onDestroy();
  	for (int _pIdx = 0; _pIdx < energySupplyChartYearGespreksleidraad1.getCount(); _pIdx++) {
  		DataSet _ds = energySupplyChartYearGespreksleidraad1.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = energySupplyChartYearGespreksleidraad1.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "energySupplyChartYearGespreksleidraad1 : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < energyDemandChartYearGespreksleidraad1.getCount(); _pIdx++) {
  		DataSet _ds = energyDemandChartYearGespreksleidraad1.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = energyDemandChartYearGespreksleidraad1.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "energyDemandChartYearGespreksleidraad1 : " + _t );
  	}
    super.onDestroy();
  }

  // Additional class code

public ShapeRadioButtonGroup getRb_gespreksleidraadBedrijvenChartType(){
	return rb_gespreksleidraadBedrijvenChartType;
}
 
  // End of additional class code

}
