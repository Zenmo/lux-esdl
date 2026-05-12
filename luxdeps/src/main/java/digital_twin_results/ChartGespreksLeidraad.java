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

public class ChartGespreksLeidraad extends digital_twin_results.ChartArea
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
 v_selfConsumedElectricityColor_individual;
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
  public 
Color 
 v_ElektrischeWPColor;
  public 
Color 
 v_HybrideWPColor;
  public 
Color 
 v_MTDistrictHeatingColor;
  public 
Color 
 v_LTDistrictHeatingColor;
  public 
Color 
 v_GreenGasBoilerColor;
  public 
Color 
 v_uitgeslotenColor;
  public 
Color 
 v_energieLabelAColor;
  public 
Color 
 v_energieLabelBColor;
  public 
Color 
 v_energieLabelCColor;
  public 
Color 
 v_energieLabelDColor;
  public 
Color 
 v_energieLabelEColor;
  public 
Color 
 v_energieLabelFColor;
  public 
Color 
 v_energieLabelOnbekendColor;
  public 
Color 
 v_energieLabelGColor;
  public 
Color 
 v_highlightParticipantsColor;
  public 
Color 
 v_heatPumpHeatSupplyColor;
  public 
Color 
 v_potentialColor;
  public 
Color 
 v_curtailedColor;
  public 
Color 
 v_selfConsumedElectricityColor_collective;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartGespreksLeidraad.class );

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
  public EventTimeout _energyDemandChartYearGespreksleidraad5_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _pl_consumptionChart3v2_pieLegenda_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _pl_productionChart3v2_pieLegenda_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _pl_productionChart3v2_pie_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _pl_consumptionChart3v2_pie_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _energyDemandChartYearGespreksleidraad5_autoUpdateEvent_xjal ) return "energyDemandChartYearGespreksleidraad5 auto update event";
     if( _e == _pl_consumptionChart3v2_pieLegenda_autoUpdateEvent_xjal ) return "pl_consumptionChart3v2_pieLegenda auto update event";
     if( _e == _pl_productionChart3v2_pieLegenda_autoUpdateEvent_xjal ) return "pl_productionChart3v2_pieLegenda auto update event";
     if( _e == _pl_productionChart3v2_pie_autoUpdateEvent_xjal ) return "pl_productionChart3v2_pie auto update event";
     if( _e == _pl_consumptionChart3v2_pie_autoUpdateEvent_xjal ) return "pl_consumptionChart3v2_pie auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _energyDemandChartYearGespreksleidraad5_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _pl_consumptionChart3v2_pieLegenda_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _pl_productionChart3v2_pieLegenda_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _pl_productionChart3v2_pie_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _pl_consumptionChart3v2_pie_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _energyDemandChartYearGespreksleidraad5_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _pl_consumptionChart3v2_pieLegenda_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _pl_productionChart3v2_pieLegenda_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _pl_productionChart3v2_pie_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _pl_consumptionChart3v2_pie_autoUpdateEvent_xjal ) {
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
    if( _e == _energyDemandChartYearGespreksleidraad5_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _pl_consumptionChart3v2_pieLegenda_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _pl_productionChart3v2_pieLegenda_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _pl_productionChart3v2_pie_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _pl_consumptionChart3v2_pie_autoUpdateEvent_xjal) {
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
    if ( _e == _energyDemandChartYearGespreksleidraad5_autoUpdateEvent_xjal ) {
      energyDemandChartYearGespreksleidraad5.updateData();
      return;
    }
    if ( _e == _pl_consumptionChart3v2_pieLegenda_autoUpdateEvent_xjal ) {
      pl_consumptionChart3v2_pieLegenda.updateData();
      return;
    }
    if ( _e == _pl_productionChart3v2_pieLegenda_autoUpdateEvent_xjal ) {
      pl_productionChart3v2_pieLegenda.updateData();
      return;
    }
    if ( _e == _pl_productionChart3v2_pie_autoUpdateEvent_xjal ) {
      pl_productionChart3v2_pie.updateData();
      return;
    }
    if ( _e == _pl_consumptionChart3v2_pie_autoUpdateEvent_xjal ) {
      pl_consumptionChart3v2_pie.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = digital_twin_results.ChartArea._STATECHART_COUNT_xjal + 0;


  // Functions

  void f_selectGespreksleidraadCharts(  ) { 

f_setWarningScreen(false);
gr_gespreksleidraad1.setVisible(false);
gr_gespreksleidraad2.setVisible(false);
gr_gespreksleidraad3.setVisible(false);
gr_gespreksleidraad4.setVisible(false);
gr_gespreksleidraad5.setVisible(false);
gr_gespreksleidraad6.setVisible(false);
gr_gespreksleidraad3v2.setVisible(false);

I_EnergyData data = uI_Results.f_getSelectedObjectData();

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(null, null, false);
//t_selectedObjectDisplayTextGSLD.setText(t_selectedObjectDisplayText.getText().replace("Data van: ", ""));

if(data.getScope() != OL_ResultScope.ENERGYMODEL && data.getScope() != OL_ResultScope.ENERGYCOOP){
	f_setWarningScreen(true);
	return;
}


switch(rb_gespreksleidraad.getValue()+1){
	case 1:
		f_setChartsGespreksleidraad1(data);
		f_setChartDescriptionText("i_gespreksleidraad1", false);
		gr_gespreksleidraad1.setVisible(true);
		break;	
	case 2:
		f_setChartsGespreksleidraad2(data);
		f_setChartDescriptionText("i_gespreksleidraad2", false);
		gr_gespreksleidraad2.setVisible(true);	
		break;	
	case 3:
		f_setChartsGespreksleidraad3v2(data);
		f_setChartDescriptionText("i_gespreksleidraad3", false);
		gr_gespreksleidraad3v2.setVisible(true);	
		break;	
	case 4:
		f_setChartsGespreksleidraad4(data);
		f_setChartDescriptionText("i_gespreksleidraad4", false);
		gr_gespreksleidraad4.setVisible(true);	
		break;	
	case 5:
		f_setChartsGespreksleidraad5(data);
		f_setChartDescriptionText("i_gespreksleidraad5", false);
		gr_gespreksleidraad5.setVisible(true);		
		break;
}
 
  }

  void f_setChartsGespreksleidraad1( I_EnergyData data ) { 

double selfConsumedEnergy_MWh = data.getRapidRunData().getTotalEnergySelfConsumed_MWh();
double importE_MWh = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.ELECTRICITY) ? data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.ELECTRICITY) : 0; 
double importG_MWh = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.METHANE) ? data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.METHANE) : 0;
double importF_MWh = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.PETROLEUM_FUEL) ? data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.PETROLEUM_FUEL) : 0; 
double importH_MWh = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.HYDROGEN) ? data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.HYDROGEN) : 0; 
double exportE_MWh = data.getRapidRunData().getTotalEnergyExport_MWh();
double districtHeating_consumption_MWh ;
if ( data.getRapidRunData().am_assetFlowsAccumulators_kW.keySet().contains(OL_AssetFlowCategories.districtHeatDelivery_kW) ) {
	districtHeating_consumption_MWh = data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getIntegral_MWh();
} else {
	districtHeating_consumption_MWh = 0;
}
StackChart pl_consumptionChart = pl_consumptionChartGespreksleidraad1; 
StackChart pl_productionChart = pl_productionChartGespreksleidraad1; 
ShapeText t_OpwekText = t_opwekTextGespreksleidraad1;
ShapeText t_GebruikText = t_gebruikTextGespreksleidraad1;

//Reset charts
pl_productionChart.removeAll();
pl_consumptionChart.removeAll();


//Get production values
DataItem d1 = new DataItem();
d1.setValue(selfConsumedEnergy_MWh/1000);
DataItem d2 = new DataItem();
d2.setValue(exportE_MWh/1000);


pl_consumptionChart.addDataItem(d1,"Lokaal opgewekt [MWh]",v_selfConsumedEnergyColor);
pl_productionChart.addDataItem(d1,"Lokaal gebruik gebied [MWh]",v_selfConsumedEnergyColor);
pl_productionChart.addDataItem(d2,"Teruggeleverde elektriciteit [MWh]",v_exportedEnergyColor);

//Add consumption values
if (importE_MWh > 0) {
	DataItem d3 = new DataItem();
	d3.setValue(importE_MWh/1000);
	pl_consumptionChart.addDataItem(d3,"Elektriciteit uit het net [MWh]",v_importedElectricityColor);
}
if (importG_MWh > 0 ) {
	DataItem d4 = new DataItem();
	d4.setValue((importG_MWh)/1000); //Fix for now, cause fed by gas
	pl_consumptionChart.addDataItem(d4,"Aardgas [MWh]",v_naturalGasDemandColor);
}	
if (importF_MWh > 0 ) {
	DataItem d5 = new DataItem();
	d5.setValue(importF_MWh/1000); // fuel
	pl_consumptionChart.addDataItem(d5,"Benzine/diesel[MWh]",v_petroleumProductsDemandColor);
}
if (importH_MWh > 0 ) {
	DataItem d6 = new DataItem();
	d6.setValue(importH_MWh/1000); // Hydrogen
	pl_consumptionChart.addDataItem(d6,"Waterstof [MWh]",v_hydrogenDemandColor);
}
if (districtHeating_consumption_MWh > 0){
	DataItem d8 = new DataItem();
	d8.setValue(districtHeating_consumption_MWh/1000); // Warmtenet
	pl_consumptionChart.addDataItem(d8,"Warmte uit warmtenet [MWh]",v_districtHeatHeatSupplyColor);
}


double chartScale_MWh = max(selfConsumedEnergy_MWh+exportE_MWh, selfConsumedEnergy_MWh+importE_MWh+importG_MWh+importF_MWh+importH_MWh+districtHeating_consumption_MWh);
pl_consumptionChart.setFixedScale(chartScale_MWh/1000);
pl_productionChart.setFixedScale(chartScale_MWh/1000);

if (chartScale_MWh<10) {
	t_OpwekText.setText("Opwek" + System.lineSeparator() + roundToInt((selfConsumedEnergy_MWh+exportE_MWh)*1000) + " kWh");
	t_GebruikText.setText("Gebruik" + System.lineSeparator() + roundToInt((selfConsumedEnergy_MWh+importE_MWh+importG_MWh+importF_MWh+importH_MWh+districtHeating_consumption_MWh)*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_OpwekText.setText("Opwek" + System.lineSeparator() + roundToInt((selfConsumedEnergy_MWh+exportE_MWh)) + " MWh");
	t_GebruikText.setText("Gebruik" + System.lineSeparator() + roundToInt((selfConsumedEnergy_MWh+importE_MWh+importG_MWh+importF_MWh+importH_MWh+districtHeating_consumption_MWh)) + " MWh");
} else {
	t_OpwekText.setText("Opwek" + System.lineSeparator() + roundToDecimal((selfConsumedEnergy_MWh+exportE_MWh)/1000, 1) + " GWh");
	t_GebruikText.setText("Gebruik" + System.lineSeparator() + roundToDecimal((selfConsumedEnergy_MWh+importE_MWh+importG_MWh+importF_MWh+importH_MWh+districtHeating_consumption_MWh)/1000,1) + " GWh");
}					 				  
  }

  void f_setGespreksleidraadGraphsLocation( double location_x, double location_y, boolean isVisible ) { 

gr_gespreksleidraad1.setPos(location_x, location_y);
gr_gespreksleidraad2.setPos(location_x, location_y);
gr_gespreksleidraad3.setPos(location_x, location_y);
gr_gespreksleidraad3v2.setPos(location_x, location_y);
gr_gespreksleidraad4.setPos(location_x-30, location_y-130);
gr_gespreksleidraad5.setPos(location_x-30, location_y-30);
gr_gespreksleidraad6.setPos(location_x, location_y);
gr_infoButtonText.setPos(location_x-30, location_y);

gr_gespreksleidraad1.setVisible(isVisible);
gr_gespreksleidraad2.setVisible(isVisible);
gr_gespreksleidraad3.setVisible(isVisible);
gr_gespreksleidraad3v2.setVisible(isVisible);
gr_gespreksleidraad4.setVisible(isVisible);
gr_gespreksleidraad5.setVisible(isVisible);
gr_gespreksleidraad6.setVisible(isVisible);
gr_infoButtonText.setVisible(isVisible); 
  }

  void f_setChartDescriptionText( String infoName, boolean infoTextVisible ) { 

gr_infoButtonText.setVisible(infoTextVisible);
String legendInfo = "";

if(infoName.equals("i_samenvattingSupplyDemand")){
	legendInfo = "Deze grafieken laten zien wat er gebeurt met de totaal jaarlijkse energieopwek, en van welke bronnen het gebruik komt. In en uitvoer worden daarbij per uur bijgehouden, je kunt dus zowel invoer (op momenten van tekort) als uitvoer (op momenten van overschot) hebben in één jaar.";
}
else if(infoName.equals("i_samenvattingAnnual")){
	legendInfo = "In deze grafiek zie je de opwek per dag per energiebron. Daarovereen staat als lijn de totale vraag per dag. In het huidige systeem zal je zien dat de opwek nog in het niet valt bij de totale vraag.";
}
else if(infoName.equals("i_gespreksleidraad1")){
	legendInfo = "Deze grafieken laten zien wat er gebeurt met de totaal jaarlijkse energieopwek, en van welke bronnen het gebruik komt. In en uitvoer worden daarbij per uur bijgehouden, je kunt dus zowel invoer (op momenten van tekort) als uitvoer (op momenten van overschot) hebben in één jaar.";
}
else if(infoName.equals("i_gespreksleidraad2")){
	legendInfo = "In de bovenste grafieken zie je het totale energiegebruik per jaar uitgesplits naar sector. In een scenario met veel warmtepompen en elektrisch vervoer zul je een hoog elektriciteitsverbruik zien in deze sectoren, welke vervolgens ook wordt meegenomen in de elektriciteitsvraag. De onderste grafieken laten de opwek zien naar de totale potentie. De potentie van wind is nog onbekend, de potentie van zon is hierbij afgestemd op geschikt dakoppervlak voor zon op dak.";
}
else if(infoName.equals("i_gespreksleidraad3")){
	legendInfo = "Deze grafieken zijn belangrijk om te zien of buurten lokaal afhankelijk zijn, of dat ze juist gezamenlijk veel potentie tot uitwisseling hebben. Bij een laag aandeel gebruik eigen opwek in de buurt en een hoog aandeel gebruik eigen opwek in de regio betekent het dat buurten onderling goed kunnen uitwisselen. Bij gebruik eigen opwek betekent hetzelfde dat er veel potentie is tussen uitwisseling tussen regio's.";
}
else if(infoName.equals("i_gespreksleidraad4")){
	legendInfo = "De belastingduurkromme rangschikt de netbelasting voor ieder uur van het jaar op volgorde van hoogste levering tot hoogste teruglevering. Hieraan kun je zien of er enkele pieken zijn of langdurige overbelasting, en of dit plaats vindt op afname of op opwek. De netbelasting is indicatief aangezien de netbeheerder hier berekeningen met meer detail en betere data over kan uitvoeren";
}
else if(infoName.equals("i_gespreksleidraad5")){
	legendInfo = "Deze grafiek laat zien wat de effect is over de seizoenen, voor zowel de elektriciteitsvraag als de energievraag. Als het aandeel invoer geminimaliseerd kan worden zal de regio minder afhankelijk van het net worden en meer eigen opwek zelf kunnen gebruiken.";
}


String formattedText = formatText(legendInfo, 42);
t_infoButtonText.setText(formattedText);
 
  }

  
String 
 formatText( String originalText, int maxCharacterCount ) { 

   
StringBuilder formattedText = new StringBuilder();
StringBuilder currentLine = new StringBuilder();

for (String word : originalText.split("\\s+")) {
	if (currentLine.length() + word.length() <= maxCharacterCount) {
		currentLine.append(word).append(" ");
	} else {
		formattedText.append(currentLine.toString().trim()).append("\n");
		currentLine.setLength(0); // reset current line
		currentLine.append(word).append(" ");
	}
}

// Append the last line
formattedText.append(currentLine.toString().trim());

return formattedText.toString();

 
  }

  void f_setChartsGespreksleidraad2( I_EnergyData data ) { 

//Electricity consumption
sc_electricityDemandStack.removeAll();

DataItem annualSelfConsumed_GWh = new DataItem();
annualSelfConsumed_GWh.setValue(data.getRapidRunData().getTotalElectricitySelfConsumed_MWh()/1000);
sc_electricityDemandStack.addDataItem(annualSelfConsumed_GWh, "Lokaal opgewekt", uI_Results.v_selfConsumedElectricityColor);

DataItem annualImport_GWh = new DataItem();
annualImport_GWh.setValue(data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.ELECTRICITY)/1000);
sc_electricityDemandStack.addDataItem(annualImport_GWh, "Invoer", uI_Results.v_importedEnergyColor);


//Heat consumption
sc_heatDemandStack.removeAll();

DataItem totalEnergyConsumptionForDistrictHeating_GWh = new DataItem();
if(data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW) ) {
	
	totalEnergyConsumptionForDistrictHeating_GWh.setValue(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getIntegral_MWh()/1000);
	totalEnergyConsumptionForDistrictHeating_GWh.getValue();
	sc_heatDemandStack.addDataItem(totalEnergyConsumptionForDistrictHeating_GWh, "Energie voor warmtenet", v_districtHeatDemandColor);
} 
DataItem totalElectricityConsumptionHeatpumps_GWh = new DataItem();
if(data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW) ) {	
	totalElectricityConsumptionHeatpumps_GWh.setValue(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW).getIntegral_MWh()/1000);
	sc_heatDemandStack.addDataItem(totalElectricityConsumptionHeatpumps_GWh, "Elek. voor warmtepompen", v_heatPumpHeatSupplyColor);
}
DataItem totalNaturalGasDemand_GWh = new DataItem();
totalNaturalGasDemand_GWh.setValue(data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.METHANE)/1000);
sc_heatDemandStack.addDataItem(totalNaturalGasDemand_GWh, "Gas", v_naturalGasSupplyColor);


// Transport consumption
sc_transportDemandStack.removeAll();


//Set scales
double chartScale_MWh = max(data.getRapidRunData().getTotalElectricitySelfConsumed_MWh() + 
							data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.ELECTRICITY), 
							(totalEnergyConsumptionForDistrictHeating_GWh.getValue()) + 
							(totalElectricityConsumptionHeatpumps_GWh.getValue()) + 
							data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.METHANE));
							
sc_electricityDemandStack.setFixedScale(chartScale_MWh/1000);
sc_heatDemandStack.setFixedScale(chartScale_MWh/1000);
sc_transportDemandStack.setFixedScale(chartScale_MWh/1000);


////Production charts

//Calcualte total full load hours production assets for potential energy production

//Full load hours Wind
double totalFullLoadHoursWind_hr = 0;
for (double value : uI_Results.energyModel.pp_windProduction_fr.getAllValues()) {
    totalFullLoadHoursWind_hr += value;
}

//Full load hours Solar
double totalFullLoadHoursSolar_hr = 0;
for (double value : uI_Results.energyModel.pp_PVProduction35DegSouth_fr.getAllValues()) {
    totalFullLoadHoursSolar_hr += value;
}

//Production (Wind)
sc_windSupplyStack.removeAll();

DataItem totalWindProduction_GWh = new DataItem();
if (data.getRapidRunData().am_assetFlowsAccumulators_kW.keySet().contains(OL_AssetFlowCategories.windProductionElectric_kW)) {
	totalWindProduction_GWh.setValue(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.windProductionElectric_kW).getIntegral_MWh()/1000);
} else {
	totalWindProduction_GWh.setValue(0.0);
}
sc_windSupplyStack.addDataItem(totalWindProduction_GWh, "Opwek wind", v_windElectricitySupplyColor);

DataItem totalCurtailedWindEnergy_GWh = new DataItem();
totalCurtailedWindEnergy_GWh.setValue(0); //data.getRapidRunData().v_totalWindEnergyCurtailed_MWh/1000);
sc_windSupplyStack.addDataItem(totalCurtailedWindEnergy_GWh, "Totaal gecurtailde wind energy", v_curtailedColor);

DataItem remainingWindPotential_GWh = new DataItem();
remainingWindPotential_GWh.setValue(max(0,((data.getRapidRunData().assetsMetaData.windPotential_kW - data.getRapidRunData().assetsMetaData.totalInstalledWindPower_kW)*totalFullLoadHoursWind_hr/1000000)));
sc_windSupplyStack.addDataItem(remainingWindPotential_GWh, "Resterende potentie wind energie", v_potentialColor);

//Production (Solar)			
sc_PVSupplyStack.removeAll();

DataItem totalSolarProduction_GWh = new DataItem();
if (data.getRapidRunData().am_assetFlowsAccumulators_kW.keySet().contains(OL_AssetFlowCategories.pvProductionElectric_kW)) {
	totalSolarProduction_GWh.setValue(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.pvProductionElectric_kW).getIntegral_MWh()/1000);
} else {
	totalSolarProduction_GWh.setValue(0.0);
}
sc_PVSupplyStack.addDataItem(totalSolarProduction_GWh, "Opwek zon", v_PVElectricitySupplyColor);


DataItem totalCurtailedPVEnergy_GWh = new DataItem();
totalCurtailedPVEnergy_GWh.setValue(0); //data.getRapidRunData().v_totalPVEnergyCurtailed_MWh/1000);
sc_PVSupplyStack.addDataItem(totalCurtailedPVEnergy_GWh, "Totaal gecurtailde zonne energy", v_curtailedColor);

DataItem remainingRoofSolarPotential_GWh = new DataItem();
remainingRoofSolarPotential_GWh.setValue(max(0,((data.getRapidRunData().assetsMetaData.PVPotential_kW - data.getRapidRunData().assetsMetaData.totalInstalledPVPower_kW)*totalFullLoadHoursSolar_hr/1000000)));
sc_PVSupplyStack.addDataItem(remainingRoofSolarPotential_GWh, "Resterende potentie zon op dak", v_potentialColor);

//Set production charts scaling
double chartScaleSupply_GWh = max(totalWindProduction_GWh.getValue() + totalCurtailedWindEnergy_GWh.getValue() + remainingWindPotential_GWh.getValue(), 
								  totalSolarProduction_GWh.getValue() + totalCurtailedPVEnergy_GWh.getValue() + remainingRoofSolarPotential_GWh.getValue());
sc_windSupplyStack.setFixedScale(chartScaleSupply_GWh);
sc_PVSupplyStack.setFixedScale(chartScaleSupply_GWh);
 
  }

  void f_setChartsGespreksleidraad4( I_EnergyData data ) { 

f_setBelastingPlots(data); 
  }

  void f_setChartsGespreksleidraad5( I_EnergyData data ) { 

//Electricity demand chart
energyDemandChartYearGespreksleidraad5.removeAll();
double startTime_h = 0;
double maxDemandChart = 0;
if(rb_gespreksleidraad5.getValue() == 0){ // Electricity
	energyDemandChartYearGespreksleidraad5.addDataSet(data.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(startTime_h), "Elektriciteitsvraag", v_energyDemandColor, true, false, Chart.INTERPOLATION_LINEAR, 2, Chart.POINT_NONE);
	maxDemandChart = data.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getMaxPower_kW();
}
else if(rb_gespreksleidraad5.getValue() == 1){ // Energy
	energyDemandChartYearGespreksleidraad5.addDataSet(data.getRapidRunData().acc_dailyAverageFinalEnergyConsumption_kW.getDataSet(startTime_h), "Energievraag", v_energyDemandColor, true, false, Chart.INTERPOLATION_LINEAR, 2, Chart.POINT_NONE);
	maxDemandChart = data.getRapidRunData().acc_dailyAverageFinalEnergyConsumption_kW.getMaxPower_kW();
}
energyDemandChartYearGespreksleidraad5.setVisible(true);

//Electricity supply chart
energySupplyChartYearGespreksleidraad5.removeAll();
if (data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.windProductionElectric_kW)) {
	energySupplyChartYearGespreksleidraad5.addDataSet(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.windProductionElectric_kW).getDataSet(startTime_h), v_windElectricitySupplyText, v_windElectricitySupplyColor);
}
if (data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW)) {
	energySupplyChartYearGespreksleidraad5.addDataSet(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.pvProductionElectric_kW).getDataSet(startTime_h), v_PVElectricitySupplyText, v_PVElectricitySupplyColor);
}
if (data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.batteriesChargingPower_kW)) {
	energySupplyChartYearGespreksleidraad5.addDataSet(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.batteriesChargingPower_kW).getDataSet(startTime_h), v_storageElectricitySupplyText, v_storageElectricitySupplyColor);
}
if (data.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.V2GPower_kW)) {
	energySupplyChartYearGespreksleidraad5.addDataSet(data.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.V2GPower_kW).getDataSet(startTime_h), v_V2GElectricitySupplyText, v_V2GElectricitySupplyColor);
}


//energySupplyChartYearGespreksleidraad1.addDataSet(area.data_petroleumProductsSupplyYear_MWh, v_petroleumProductsSupplyText, v_petroleumProductsSupplyColor);
//energySupplyChartYearGespreksleidraad1.addDataSet(area.data_districtHeatHeatSupplyYear_MWh, v_districtHeatHeatSupplyText, v_districtHeatHeatSupplyColor);

double maxScale = max(maxDemandChart, data.getRapidRunData().am_dailyAverageProductionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getMaxPower_kW());
//double maxScale = max(uI_Results.energySupplyChartYearGespreksleidraad1.getScaleY(), uI_Results.energyDemandChartYearGespreksleidraad1.getScaleY());
energyDemandChartYearGespreksleidraad5.setFixedVerticalScale(0, maxScale);
energySupplyChartYearGespreksleidraad5.setFixedVerticalScale(maxScale);

energySupplyChartYearGespreksleidraad5.setVisible(false);
energySupplyChartYearGespreksleidraad5.setVisible(true);
 
  }

  void f_setChartsGespreksleidraad3v2( I_EnergyData data ) { 

f_setChartsGespreksleidraad3v2_PieChart(data);
/*
//Clear
pl_consumptionChart3v2.removeAll();
pl_productionChart3v2.removeAll();


double annualSelfConsumedElectricityIndividual_MWh;

if (! (area.v_individualSelfconsumption_fr > 0) ) {
	annualSelfConsumedElectricityIndividual_MWh = 0.0;
	traceln("NaN detected!");
} else {
	annualSelfConsumedElectricityIndividual_MWh = (area.v_totalElectricitySelfConsumed_MWh + area.fm_totalExports_MWh.get(OL_EnergyCarriers.ELECTRICITY)) * area.v_individualSelfconsumption_fr;
}
					
double selfConsumedElectricityIndividual_MWh = annualSelfConsumedElectricityIndividual_MWh;
double additionalSelfConsumedElectricityCollective_MWh = area.v_totalElectricitySelfConsumed_MWh - annualSelfConsumedElectricityIndividual_MWh;
double totalExportedElectricity_MWh = area.fm_totalExports_MWh.get(OL_EnergyCarriers.ELECTRICITY);
double totalImportedElectricity_MWh = area.fm_totalImports_MWh.get(OL_EnergyCarriers.ELECTRICITY);



DataItem annualSelfConsumedNBH = new DataItem();
annualSelfConsumedNBH.setValue(selfConsumedElectricityIndividual_MWh);
pl_productionChart3v2.addDataItem(annualSelfConsumedNBH, "Lokaal gebruikt(Buurt)[MWh]", v_selfConsumedElectricityColor_individual);
pl_consumptionChart3v2.addDataItem(annualSelfConsumedNBH, "Lokaal opgewekt(Buurt)[MWh]", v_selfConsumedElectricityColor_individual);


DataItem annualSelfConsumedRegion = new DataItem();
annualSelfConsumedRegion.setValue(additionalSelfConsumedElectricityCollective_MWh);
pl_productionChart3v2.addDataItem(annualSelfConsumedRegion, "Lokaal gebruikt (Regio)[MWh]", v_selfConsumedElectricityColor_collective);
pl_consumptionChart3v2.addDataItem(annualSelfConsumedRegion, "Lokaal opgewekt (Regio)[MWh]", v_selfConsumedElectricityColor_collective);


DataItem annualImport = new DataItem();
annualImport.setValue(totalImportedElectricity_MWh);
pl_consumptionChart3v2.addDataItem(annualImport, "Invoer [MWh]", v_importedEnergyColor);

DataItem annualExport = new DataItem();
annualExport.setValue(totalExportedElectricity_MWh);
pl_productionChart3v2.addDataItem(annualExport, "Uitvoer [MWh]", v_exportedEnergyColor);

double production_MWh = area.v_totalElectricitySelfConsumed_MWh + area.fm_totalExports_MWh.get(OL_EnergyCarriers.ELECTRICITY);
double consumption_MWh = area.v_totalElectricitySelfConsumed_MWh + area.fm_totalImports_MWh.get(OL_EnergyCarriers.ELECTRICITY);
double chartScale_MWh = max(production_MWh, consumption_MWh);
pl_consumptionChart3v2.setFixedScale(chartScale_MWh);
pl_productionChart3v2.setFixedScale(chartScale_MWh);


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
*/ 
  }

  void f_setChartsGespreksleidraad3v2_PieChart( I_EnergyData data ) { 

//Clear
pl_productionChart3v2_pieLegenda.removeAll();
pl_consumptionChart3v2_pieLegenda.removeAll();
pl_productionChart3v2_pie.removeAll();
pl_consumptionChart3v2_pie.removeAll();
pl_productionChart3v2_pie.setScale(1);
pl_consumptionChart3v2_pie.setScale(1);
pl_productionChart3v2_pie.setPos(-250, -50);
pl_consumptionChart3v2_pie.setPos(-20, -50);

double annualSelfConsumedElectricityIndividual_MWh = 0;
if (data instanceof EnergyCoop COOP){
	annualSelfConsumedElectricityIndividual_MWh = COOP.v_cumulativeIndividualSelfconsumptionElectricity_MWh;
}
else if (data instanceof EnergyModel EM) {
	annualSelfConsumedElectricityIndividual_MWh = sum(EM.f_getActiveGridConnections(), GC -> GC.v_rapidRunData.getTotalElectricitySelfConsumed_MWh());
}
				
double selfConsumedElectricityIndividual_MWh = max(0, annualSelfConsumedElectricityIndividual_MWh);
double additionalSelfConsumedElectricityCollective_MWh = data.getRapidRunData().getTotalElectricitySelfConsumed_MWh() - annualSelfConsumedElectricityIndividual_MWh;
double totalExportedElectricity_MWh = data.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.ELECTRICITY);
double totalImportedElectricity_MWh = data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.ELECTRICITY);

double production_MWh = data.getRapidRunData().getTotalElectricityProduced_MWh();
double consumption_MWh = data.getRapidRunData().getTotalElectricityConsumed_MWh(); 

double selfConsumedElectricityIndividual_scaledUnit;
double additionalSelfConsumedElectricityCollective_scaledUnit;
double totalExportedElectricity_scaledUnit;
double totalImportedElectricity_scaledUnit;



if (consumption_MWh < 10 || production_MWh < 10) { // --> Convert all to kWh
	selfConsumedElectricityIndividual_scaledUnit = selfConsumedElectricityIndividual_MWh*1000;
	additionalSelfConsumedElectricityCollective_scaledUnit = additionalSelfConsumedElectricityCollective_MWh*1000;
	totalExportedElectricity_scaledUnit = totalExportedElectricity_MWh*1000;	
	totalImportedElectricity_scaledUnit = totalImportedElectricity_MWh*1000;	
}
else if (consumption_MWh < 1000 || production_MWh < 1000) { // --> Convert all to MWh
	selfConsumedElectricityIndividual_scaledUnit = selfConsumedElectricityIndividual_MWh;
	additionalSelfConsumedElectricityCollective_scaledUnit = additionalSelfConsumedElectricityCollective_MWh;
	totalExportedElectricity_scaledUnit = totalExportedElectricity_MWh;
	totalImportedElectricity_scaledUnit = totalImportedElectricity_MWh;	
}
else {// --> Convert all to GWh
	selfConsumedElectricityIndividual_scaledUnit = selfConsumedElectricityIndividual_MWh/1000;
	additionalSelfConsumedElectricityCollective_scaledUnit = additionalSelfConsumedElectricityCollective_MWh/1000;
	totalExportedElectricity_scaledUnit = totalExportedElectricity_MWh/1000;
	totalImportedElectricity_scaledUnit = totalImportedElectricity_MWh/1000;
}



DataItem annualSelfConsumedNBH = new DataItem();
annualSelfConsumedNBH.setValue(selfConsumedElectricityIndividual_scaledUnit);
pl_productionChart3v2_pie.addDataItem(annualSelfConsumedNBH, "Lokaal gebruikt (Buurt)", v_selfConsumedElectricityColor_individual);
pl_consumptionChart3v2_pie.addDataItem(annualSelfConsumedNBH, "Lokaal opgewekt (Buurt)", v_selfConsumedElectricityColor_individual);
pl_productionChart3v2_pieLegenda.addDataItem(annualSelfConsumedNBH, "Lokaal gebruikt (Buurt)", v_selfConsumedElectricityColor_individual);
pl_consumptionChart3v2_pieLegenda.addDataItem(annualSelfConsumedNBH, "Lokaal opgewekt (Buurt)", v_selfConsumedElectricityColor_individual);


DataItem annualSelfConsumedRegion = new DataItem();
annualSelfConsumedRegion.setValue(additionalSelfConsumedElectricityCollective_scaledUnit);
pl_productionChart3v2_pie.addDataItem(annualSelfConsumedRegion, "Lokaal gebruikt (Regio)", v_selfConsumedElectricityColor_collective);
pl_consumptionChart3v2_pie.addDataItem(annualSelfConsumedRegion, "Lokaal opgewekt (Regio)", v_selfConsumedElectricityColor_collective);
pl_productionChart3v2_pieLegenda.addDataItem(annualSelfConsumedRegion, "Lokaal gebruikt (Regio)", v_selfConsumedElectricityColor_collective);
pl_consumptionChart3v2_pieLegenda.addDataItem(annualSelfConsumedRegion, "Lokaal opgewekt (Regio)", v_selfConsumedElectricityColor_collective);

DataItem annualExport = new DataItem();
annualExport.setValue(totalExportedElectricity_scaledUnit);
pl_productionChart3v2_pie.addDataItem(annualExport, "Uitvoer", v_exportedEnergyColor);
pl_productionChart3v2_pieLegenda.addDataItem(annualExport, "Uitvoer", v_exportedEnergyColor);

DataItem annualImport = new DataItem();
annualImport.setValue(totalImportedElectricity_scaledUnit);
pl_consumptionChart3v2_pie.addDataItem(annualImport, "Invoer", v_importedEnergyColor);
pl_consumptionChart3v2_pieLegenda.addDataItem(annualImport, "Invoer", v_importedEnergyColor);


//Scale pie charts
if(production_MWh < consumption_MWh){
	double v_scalePie3v2_production = sqrt(production_MWh/consumption_MWh);
	double newXlocation = pl_productionChart3v2_pie.getX() + pl_productionChart3v2_pie.getWidth()*(1-v_scalePie3v2_production)/2;
	double newYlocation = pl_productionChart3v2_pie.getY() + pl_productionChart3v2_pie.getHeight()*(1-v_scalePie3v2_production)/2;
	pl_productionChart3v2_pie.setPos(newXlocation, newYlocation);
	pl_productionChart3v2_pie.setScale(v_scalePie3v2_production);
}
else if(production_MWh > consumption_MWh){
	double v_scalePie3v2_consumption = sqrt(consumption_MWh/production_MWh);
	double newXlocation = pl_consumptionChart3v2_pie.getX() + pl_consumptionChart3v2_pie.getWidth()*(1-v_scalePie3v2_consumption)/2;
	double newYlocation = pl_consumptionChart3v2_pie.getY() + pl_consumptionChart3v2_pie.getHeight()*(1-v_scalePie3v2_consumption)/2;
	pl_consumptionChart3v2_pie.setPos(newXlocation, newYlocation);
	pl_consumptionChart3v2_pie.setScale(v_scalePie3v2_consumption);
}


//Set the total production and consumption text
if (consumption_MWh < 10 || production_MWh < 10) {
	t_totalProductionYear.setText("Opwek [kWh]" + System.lineSeparator() + "Totaal : " + roundToInt(production_MWh*1000));// + " kWh");
	t_totalConsumptionYear.setText("Gebruik [kWh]" + System.lineSeparator() + "Totaal : " + roundToInt(consumption_MWh*1000));// + " kWh");
} else if (consumption_MWh < 1000 || production_MWh < 1000) {
	t_totalProductionYear.setText("Opwek [MWh]" + System.lineSeparator() + "Totaal : " + roundToInt(production_MWh));// + " MWh");
	t_totalConsumptionYear.setText("Gebruik [MWh]" + System.lineSeparator() + "Totaal : " + roundToInt(consumption_MWh));// + " MWh");
} else {
	t_totalProductionYear.setText("Opwek [GWh]" + System.lineSeparator() + "Totaal : " + roundToDecimal(production_MWh/1000, 1));// + " GWh");
	t_totalConsumptionYear.setText("Gebruik [GWh]" + System.lineSeparator() + "Totaal : " + roundToDecimal(consumption_MWh/1000,1));// + " GWh");
}

 
  }

  void f_setWarningScreen( boolean showWarningScreen ) { 

gr_warningScreen.setVisible(showWarningScreen); 
  }

  void f_setBelastingPlots( I_EnergyData data ) { 

f_resetPlots();

J_LoadDurationCurves loadDurationCurves = data.getRapidRunData().getLoadDurationCurves();

f_addDataToPlots(data, loadDurationCurves);
f_addTrafoLimits(data); 

double maxDemand_kW = max(0, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMax());
double maxSupply_kW = abs(min(0, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMin()));
double maxDemandSupply_kW = max(maxDemand_kW, maxSupply_kW);
/*
if (maxDemandSupply_kW < 1 * pow(10,3)) {
	tx_maxDemand.setText(roundToDecimal(maxDemand_kW, 0) + " kW");
	tx_maxSupply.setText(roundToDecimal(maxSupply_kW, 0) + " kW");
} else if (maxDemandSupply_kW<1 * pow(10,6)) {
	tx_maxDemand.setText(roundToDecimal(maxDemand_kW / pow(10,3), 0) + " MW");
	tx_maxSupply.setText(roundToDecimal(maxSupply_kW / pow(10,3), 0) + " MW");
} else {
	tx_maxDemand.setText(roundToDecimal(maxDemand_kW / pow(10,6), 1) + " GW");
	tx_maxSupply.setText(roundToDecimal(maxSupply_kW / pow(10,6), 1) + " GW");
} */

if (maxDemandSupply_kW < 1 * pow(10,3)) {
	tx_maxDemand.setText(String.format("%.0f", maxDemand_kW) + " kW");
	tx_maxSupply.setText(String.format("%.0f", maxSupply_kW) + " kW");
} else if (maxDemandSupply_kW<1 * pow(10,6)) {
	tx_maxDemand.setText(String.format("%.2f", maxDemand_kW / pow(10,3)) + " MW");
	tx_maxSupply.setText(String.format("%.2f", maxSupply_kW / pow(10,3)) + " MW");
	//tx_maxDemand.setText(roundToDecimal(maxDemand_kW / pow(10,3), 0) + " MW");
	//tx_maxSupply.setText(roundToDecimal(maxSupply_kW / pow(10,3), 0) + " MW");
} else {
	tx_maxDemand.setText(String.format("%.2f", maxDemand_kW / pow(10,6)) + " GW");
	tx_maxSupply.setText(String.format("%.2f", maxSupply_kW / pow(10,6)) + " GW");
	//tx_maxDemand.setText(roundToDecimal(maxDemand_kW / pow(10,6), 1) + " GW");
	//tx_maxSupply.setText(roundToDecimal(maxSupply_kW / pow(10,6), 1) + " GW");
} 


f_setNetAverageLoad(data, loadDurationCurves); 
  }

  void f_setNetAverageLoad( I_EnergyData dataObject, J_LoadDurationCurves loadDurationCurves ) { 

double benuttingsgraad = 0;
double totalAbsoluteLoad_kW = 0;
for(int i=0; i< loadDurationCurves.ds_loadDurationCurveTotal_kW.size(); i++){
	totalAbsoluteLoad_kW += abs(loadDurationCurves.ds_loadDurationCurveTotal_kW.getY(i))* uI_Results.energyModel.p_timeParameters.getTimeStep_h();
}
benuttingsgraad = totalAbsoluteLoad_kW / ((dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW() + dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW()) * 8760) * 100;
t_KPIBenuttingsgraad.setText(roundToDecimal(benuttingsgraad, 0) + "%"); 
  }

  void f_resetPlots(  ) { 

plot_jaar.removeAll();
plot_week.removeAll();
plot_dagnacht.removeAll();
plot_seizoen.removeAll(); 
  }

  void f_addDataToPlots( I_EnergyData dataObject, J_LoadDurationCurves loadDurationCurves ) { 

double scaleMin_kW;
double scaleMax_kW;

double gridCapacityDelivery_kW = dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW();
double gridCapacityFeedin_kW = dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW();

//Jaar
plot_jaar.addDataSet(loadDurationCurves.ds_loadDurationCurveTotal_kW,"Belasting jaar");
scaleMin_kW = -1 + min(-gridCapacityFeedin_kW*1.2, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMin());
scaleMax_kW = 1 + max(gridCapacityDelivery_kW*1.2, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMax());
plot_jaar.setFixedVerticalScale(scaleMin_kW, scaleMax_kW);
//if (area.v_dataNetbelastingDuurkrommeYearVorige_kW != null) {
	//plot_jaar.addDataSet(area.v_dataNetbelastingDuurkrommeYearVorige_kW,"Vorige situatie");
	//plot_jaar.setColor(3,gray);
//}

//summer/winter
plot_seizoen.addDataSet(loadDurationCurves.ds_loadDurationCurveSummer_kW,"Belasting zomerweek");
plot_seizoen.addDataSet(loadDurationCurves.ds_loadDurationCurveWinter_kW,"Belasting winterweek");
plot_seizoen.setColor(0,blue);
plot_seizoen.setColor(1,green);
scaleMin_kW = -1 + min(-gridCapacityFeedin_kW*1.2, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMin());
scaleMax_kW = 1 + max(gridCapacityDelivery_kW*1.2, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMax());
plot_seizoen.setFixedVerticalScale(scaleMin_kW, scaleMax_kW);


// Day/night
plot_dagnacht.addDataSet(loadDurationCurves.ds_loadDurationCurveDaytime_kW,"Belasting overdag");
plot_dagnacht.addDataSet(loadDurationCurves.ds_loadDurationCurveNighttime_kW,"Belasting 's nachts");
plot_dagnacht.setColor(0,blue);
plot_dagnacht.setColor(1,green);	
scaleMin_kW = -1 + min(-gridCapacityFeedin_kW*1.2, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMin());
scaleMax_kW = 1 + max(gridCapacityDelivery_kW*1.2, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMax());
plot_dagnacht.setFixedVerticalScale(scaleMin_kW, scaleMax_kW);


// Weekday/weekend
plot_week.addDataSet(loadDurationCurves.ds_loadDurationCurveWeekday_kW,"Belasting weekdagen");
plot_week.addDataSet(loadDurationCurves.ds_loadDurationCurveWeekend_kW,"Belasting weekenddagen");
plot_week.setColor(0,blue);
plot_week.setColor(1,green);
scaleMin_kW = -1 + min(-gridCapacityFeedin_kW*1.2, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMin());
scaleMax_kW = 1 + max(gridCapacityDelivery_kW*1.2, loadDurationCurves.ds_loadDurationCurveTotal_kW.getYMax());
plot_week.setFixedVerticalScale(scaleMin_kW, scaleMax_kW);
 
  }

  void f_addTrafoLimits( I_EnergyData dataObject ) { 

//Add and color grid capacities
String deliveryCapacityLabel = "Geschatte capaciteit afname";
String feedinCapacityLabel = "Geschatte capaciteit teruglevering";
Color  deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;
Color  feedinCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;

//Create delivery and capacity year datasets
DataSet gridCapacityDelivery_kW = uI_Results.f_createFlatDataset(0, 8760, dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW());
DataSet gridCapacityFeedin_kW = uI_Results.f_createFlatDataset(0, 8760, -dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW());
	
if(uI_Results.b_showGroupContractValues && uI_Results.v_selectedObjectScope == OL_ResultScope.ENERGYCOOP){
	deliveryCapacityLabel = "Cumulatieve GTV afname van bedrijven";
	deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_known;
	feedinCapacityLabel = "Cumulatieve GTV teruglevering van bedrijven";
	feedinCapacityColor		= uI_Results.v_electricityCapacityColor_known;
	
	//And: add group contract values
	DataSet groupContractCapacityDelivery_kW = uI_Results.f_createFlatDataset(0, 8760, ((EnergyCoop)dataObject).f_getGroupContractDeliveryCapacity_kW(dataObject.getRapidRunData(), uI_Results.energyModel.p_timeParameters));
	DataSet groupContractCapacityFeedin_kW = uI_Results.f_createFlatDataset(0, 8760, -((EnergyCoop)dataObject).f_getGroupContractFeedinCapacity_kW(dataObject.getRapidRunData(), uI_Results.energyModel.p_timeParameters));
	
	plot_jaar.addDataSet(groupContractCapacityDelivery_kW, "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
	plot_jaar.addDataSet(groupContractCapacityFeedin_kW, "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
	plot_week.addDataSet(groupContractCapacityDelivery_kW, "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
	plot_week.addDataSet(groupContractCapacityFeedin_kW, "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
	plot_dagnacht.addDataSet(groupContractCapacityDelivery_kW, "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
	plot_dagnacht.addDataSet(groupContractCapacityFeedin_kW, "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
	plot_seizoen.addDataSet(groupContractCapacityDelivery_kW, "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
	plot_seizoen.addDataSet(groupContractCapacityFeedin_kW, "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
}
else{
	if(dataObject.getRapidRunData().connectionMetaData.getContractedDeliveryCapacityKnown()){
		deliveryCapacityLabel = "Capaciteit afname";
		deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_known;
	}
	if(dataObject.getRapidRunData().connectionMetaData.getContractedFeedinCapacityKnown()){
		feedinCapacityLabel = "Capaciteit teruglevering";
		feedinCapacityColor		= uI_Results.v_electricityCapacityColor_known;
	}
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
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_gespreksleidraad3_Font = new Font("Arial", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_gespreksleidraad5_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_gespreksleidraad_Font = new Font("Arial", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_gespreksleidraad4_Font = _rb_gespreksleidraad5_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text18_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text19_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text20_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText3_Font = new Font("Arial", 0, 28 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_opwekTextGespreksleidraad1_Font = new Font("Arial", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gebruikTextGespreksleidraad1_Font = _t_opwekTextGespreksleidraad1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText4_Font = new Font("Arial", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gespreksleidraadLegend9_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gespreksleidraadLegend10_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gespreksleidraadLegend11_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gespreksleidraadLegend12_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gespreksleidraadLegend13_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gespreksleidraadLegend14_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gespreksleidraadLegend15_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_exportPerNeighborhood5_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_exportPerNeighborhood6_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText8_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_GSLD2_wind_Font = new Font("Arial", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_gsld2_solar_Font = _txt_GSLD2_wind_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText9_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _txt_GSLD2_wind_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _txt_GSLD2_wind_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text6_Font = _txt_GSLD2_wind_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text7_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text8_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text9_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text10_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text11_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text12_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text13_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text16_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text17_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyDemand_ylabel2_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energyDemand_ylabel3_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text24_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text25_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text26_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText7_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_selfConsumptionPerNeighborhood2_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_exportPerNeighborhood1_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_selfConsumptionPerRegion2_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_exportPerRegion1_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1125_Font = _tx_topBarplotText4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1124_Font = _tx_topBarplotText4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText28_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_selfConsumptionPerNeighborhood3_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_importPerNeighborhood1_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_selfConsumptionPerRegion3_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_importPerRegion1_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1131_Font = _tx_topBarplotText4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1132_Font = _tx_topBarplotText4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText13_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_xlabel3_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_gespreksleidraad5_Font = _tx_topBarplotText4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_ylabel2_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText38_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText39_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText40_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText41_Font = new Font("Arial", 0, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText42_Font = _tx_topBarplotText41_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText43_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText44_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText45_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText46_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText47_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText48_Font = _txt_GSLD2_wind_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_numberOfPeaksDemand_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_averageTimePeakDemand_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_averageEnergyPeakDemand_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_maxTimePeakDemand_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_maxEnergyPeakDemand_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_averagePowerPeakDemand_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_maxPowerPeakDemand_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_maxEnergyPeakSupply_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_averageTimePeakSupply_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_numberOfPeaksSupply_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_maxTimePeakSupply_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_averageEnergyPeakSupply_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_maxPowerPeakSupply_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_averagePowerPeakSupply_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text22_Font = _t_opwekTextGespreksleidraad1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text23_Font = _tx_topBarplotText4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText11_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText2_Font = new Font("Calibri", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_xlabel_Font = new Font("Calibri", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_ylabel_Font = _t_duurkromme_xlabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText52_Font = _tx_topBarplotText4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_maxDemand_Font = new Font("Arial", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_maxSupply_Font = _tx_maxDemand_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText55_Font = _tx_topBarplotText4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_KPIBenuttingsgraad_Font = new Font("SansSerif", 1, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1123_Font = new Font("SansSerif", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text593_Font = new Font("Calibri", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_ylabel6_Font = _t_duurkromme_xlabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_xlabel1_Font = _t_duurkromme_xlabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_ylabel7_Font = _t_duurkromme_xlabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText5_Font = _t_duurkromme_xlabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_ylabel1_Font = _t_duurkromme_xlabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_xlabel5_Font = _t_duurkromme_xlabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText6_Font = _t_duurkromme_xlabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText14_Font = _t_duurkromme_xlabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_duurkromme_xlabel2_Font = _t_duurkromme_xlabel_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_KPIselfsufficiency_pct4_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText17_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText26_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText19_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText12_Font = new Font("Arial", 0, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText25_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText21_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText15_Font = _tx_topBarplotText12_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText18_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText24_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_KPIselfsufficiency_pct3_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_KPIselfsufficiency_pct5_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText20_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotText37_Font = new Font("Arial", 1, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text21_Font = _rb_gespreksleidraad3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalConsumptionYear_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalProductionYear_Font = _t_totalConsumptionYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_gebruikEigenElecOpwekBuurt3v2_Font = _tx_topBarplotText4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _tx_topBarplotTexttxt_gebruikEigenElecOpwekBuurt3v2_Font = _tx_topBarplotText3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_gebruikEigenElecGebruikRegio3v2_Font = _tx_topBarplotText4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_scenarioName1_Font = new Font("Calibri", 1, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_infoButtonText_Font = new Font("SansSerif", 0, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_WarningScreenMessage_Font = new Font("SansSerif", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_displayedDataOf_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_selectedObjectDisplayTextGSLD_Font = _t_totalConsumptionYear_Font;
  protected static final Color _rect_hoverBlockingPieChart_Fill_Color = new Color( 0xFFFFFF, true );
  protected static final Color _rectangle17_Fill_Color = new Color( 0xE8FFFFFF, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_rbGSLD = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _text18 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _text19 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle12 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle11 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle10 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _text20 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GSL1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_opwekTextGespreksleidraad1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gebruikTextGespreksleidraad1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_onbalansBarplot4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval26 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gespreksleidraadLegend9 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval27 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gespreksleidraadLegend10 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval28 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gespreksleidraadLegend11 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval29 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gespreksleidraadLegend12 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gespreksleidraadLegend13 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval30 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gespreksleidraadLegend14 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval31 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval32 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gespreksleidraadLegend15 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_exportPerNeighborhood5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_exportPerNeighborhood6 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_gespreksleidraad1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gespreksleidraad1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GSL2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText8 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_GSLD2_wind = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_gsld2_solar = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText9 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _text6 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle13 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _text7 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _text8 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _text9 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _text10 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _text11 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _text12 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle6 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle7 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _text13 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle8 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _text16 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle9 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _text17 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyDemand_ylabel2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energyDemand_ylabel3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle14 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _text24 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle15 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _text25 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_gespreksleidraad2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle18 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _text26 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gespreksleidraad2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText7 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval18 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_selfConsumptionPerNeighborhood2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval19 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_exportPerNeighborhood1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval20 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_selfConsumptionPerRegion2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 76;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval21 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 77;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_exportPerRegion1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 78;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1125 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 79;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1124 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 80;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_opwekZelfgebruik = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 81;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText28 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 82;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval22 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 83;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_selfConsumptionPerNeighborhood3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 84;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval23 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 85;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_importPerNeighborhood1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 86;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval24 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 87;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_selfConsumptionPerRegion3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 88;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval25 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 89;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_importPerRegion1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 90;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1131 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 91;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1132 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 92;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gebruikEigenOpwek = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 93;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_gespreksleidraad3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 94;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GSL3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 95;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gespreksleidraad3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 96;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText13 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 97;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_xlabel3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 98;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_gespreksleidraad5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 99;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_gespreksleidraad5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 100;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GSL5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 101;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_ylabel2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 102;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gespreksleidraad5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 103;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GSL6 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 104;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText38 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 105;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText39 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 106;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText40 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 107;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText41 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 108;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText42 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 109;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText43 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 110;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText44 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 111;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText45 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 112;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText46 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 113;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText47 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 114;
  @AnyLogicInternalCodegenAPI
  protected static final int _line19 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 115;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText48 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 116;
  @AnyLogicInternalCodegenAPI
  protected static final int _line20 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 117;
  @AnyLogicInternalCodegenAPI
  protected static final int _line21 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 118;
  @AnyLogicInternalCodegenAPI
  protected static final int _line22 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 119;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_numberOfPeaksDemand = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 120;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_averageTimePeakDemand = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 121;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_averageEnergyPeakDemand = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 122;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_maxTimePeakDemand = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 123;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_maxEnergyPeakDemand = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 124;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_averagePowerPeakDemand = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 125;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_maxPowerPeakDemand = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 126;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_maxEnergyPeakSupply = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 127;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_averageTimePeakSupply = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 128;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_numberOfPeaksSupply = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 129;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_maxTimePeakSupply = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 130;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_averageEnergyPeakSupply = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 131;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_maxPowerPeakSupply = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 132;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_averagePowerPeakSupply = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 133;
  @AnyLogicInternalCodegenAPI
  protected static final int _text22 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 134;
  @AnyLogicInternalCodegenAPI
  protected static final int _text23 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 135;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gespreksleidraad6 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 136;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_rb = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 137;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GSL4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 138;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText11 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 139;
  @AnyLogicInternalCodegenAPI
  protected static final int _group_jaar = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 140;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalNetbelasting4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 141;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalNetbelasting3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 142;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 143;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_xlabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 144;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_ylabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 145;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText52 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 146;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_maxDemand = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 147;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_maxSupply = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 148;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText55 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 149;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalNetbelasting1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 150;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_KPIBenuttingsgraad = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 151;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1123 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 152;
  @AnyLogicInternalCodegenAPI
  protected static final int _text593 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 153;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gespreksleidraad4_A = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 154;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_ylabel6 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 155;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_xlabel1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 156;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_ylabel7 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 157;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 158;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_ylabel1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 159;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_xlabel5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 160;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText6 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 161;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText14 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 162;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_duurkromme_xlabel2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 163;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gespreksleidraad4_B = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 164;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gespreksleidraad4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 165;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_KPIselfsufficiency_pct4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 166;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalZelfvoorzienendheid3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 167;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText17 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 168;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalZelfvoorzienendheid5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 169;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText26 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 170;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 171;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText19 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 172;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalZelfvoorzienendheid4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 173;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText12 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 174;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText25 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 175;
  @AnyLogicInternalCodegenAPI
  protected static final int _line6 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 176;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText21 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 177;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText15 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 178;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText18 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 179;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText24 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 180;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_KPIselfsufficiency_pct3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 181;
  @AnyLogicInternalCodegenAPI
  protected static final int _line4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 182;
  @AnyLogicInternalCodegenAPI
  protected static final int _line3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 183;
  @AnyLogicInternalCodegenAPI
  protected static final int _line5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 184;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_KPIselfsufficiency_pct5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 185;
  @AnyLogicInternalCodegenAPI
  protected static final int _line2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 186;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 187;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText20 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 188;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_oldNetbelastingInfo = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 189;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle16 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 190;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotText37 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 191;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 192;
  @AnyLogicInternalCodegenAPI
  protected static final int _line15 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 193;
  @AnyLogicInternalCodegenAPI
  protected static final int _line16 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 194;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_closeWindow = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 195;
  @AnyLogicInternalCodegenAPI
  protected static final int _text21 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 196;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_netcapaciteitInDeTwin = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 197;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_gespreksleidraad3v2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 198;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_GSL3v2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 199;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalConsumptionYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 200;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalProductionYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 201;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_gebruikEigenElecOpwekBuurt3v2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 202;
  @AnyLogicInternalCodegenAPI
  protected static final int _tx_topBarplotTexttxt_gebruikEigenElecOpwekBuurt3v2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 203;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_gebruikEigenElecGebruikRegio3v2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 204;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_legendaPieChartBlock = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 205;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_hoverBlockingPieChart = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 206;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gespreksleidraad3v2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 207;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle17 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 208;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval17 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 209;
  @AnyLogicInternalCodegenAPI
  protected static final int _line23 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 210;
  @AnyLogicInternalCodegenAPI
  protected static final int _line24 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 211;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_closeWindow5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 212;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_scenarioName1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 213;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_infoButtonText = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 214;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_infoButtonText = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 215;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 216;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_warningScreenGespreksleidraadBedrijven = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 217;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_WarningScreenMessage = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 218;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_warningScreen = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 219;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_displayedDataOf = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 220;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_selectedObjectDisplayTextGSLD = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 221;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartGespreksleidraad1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 222;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartGespreksleidraad1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 223;
  @AnyLogicInternalCodegenAPI
  protected static final int _sc_windSupplyStack = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 224;
  @AnyLogicInternalCodegenAPI
  protected static final int _sc_PVSupplyStack = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 225;
  @AnyLogicInternalCodegenAPI
  protected static final int _sc_electricityDemandStack = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 226;
  @AnyLogicInternalCodegenAPI
  protected static final int _sc_heatDemandStack = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 227;
  @AnyLogicInternalCodegenAPI
  protected static final int _sc_transportDemandStack = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 228;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartIndividual = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 229;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartCollective = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 230;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_selfSufficiencyChartIndividual1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 231;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_selfSufficiencyChartCollective1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 232;
  @AnyLogicInternalCodegenAPI
  protected static final int _energySupplyChartYearGespreksleidraad5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 233;
  @AnyLogicInternalCodegenAPI
  protected static final int _energyDemandChartYearGespreksleidraad5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 234;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_jaar = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 235;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_dagnacht = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 236;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_seizoen = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 237;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 238;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChart3v2_pieLegenda = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 239;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChart3v2_pieLegenda = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 240;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChart3v2_pie = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 241;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChart3v2_pie = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 242;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_gespreksleidraad3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 243;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_gespreksleidraad5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 244;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_gespreksleidraad = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 245;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_gespreksleidraad4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 246;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 247;

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
	  level.addAll(rect_rbGSLD, text18, text19, rectangle12, rectangle11, rectangle10, text20, gr_gespreksleidraad1, gr_gespreksleidraad2, gr_gespreksleidraad3, gr_gespreksleidraad5, gr_gespreksleidraad6, rb_gespreksleidraad, gr_gespreksleidraad4, gr_oldNetbelastingInfo, gr_netcapaciteitInDeTwin, gr_gespreksleidraad3v2, gr_infoButtonText, text, gr_warningScreen, txt_displayedDataOf, t_selectedObjectDisplayTextGSLD);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_gespreksleidraad1:
        if (true) {
          ShapeImage self = this.i_gespreksleidraad1;
          
boolean setVisible = true;
if(gr_infoButtonText.isVisible()){
 setVisible = false;
}


f_setChartDescriptionText(i_gespreksleidraad1.getName(), setVisible); 
        }
        break;
      case _i_gespreksleidraad2:
        if (true) {
          ShapeImage self = this.i_gespreksleidraad2;
          
boolean setVisible = true;
if(gr_infoButtonText.isVisible()){
 setVisible = false;
}

f_setChartDescriptionText(i_gespreksleidraad2.getName(), setVisible); 
        }
        break;
      case _i_gespreksleidraad3:
        if (true) {
          ShapeImage self = this.i_gespreksleidraad3;
          
boolean setVisible = true;
if(gr_infoButtonText.isVisible()){
 setVisible = false;
}

f_setChartDescriptionText(i_gespreksleidraad3.getName(), setVisible); 
        }
        break;
      case _i_gespreksleidraad5:
        if (true) {
          ShapeImage self = this.i_gespreksleidraad5;
          
boolean setVisible = true;
if(gr_infoButtonText.isVisible()){
 setVisible = false;
}

f_setChartDescriptionText(i_gespreksleidraad5.getName(), setVisible); 
        }
        break;
      case _gr_closeWindow:
        if (true) {
          ShapeGroup self = this.gr_closeWindow;
          
gr_netcapaciteitInDeTwin.setVisible(false); 
        }
        break;
      case _i_gespreksleidraad3v2:
        if (true) {
          ShapeImage self = this.i_gespreksleidraad3v2;
          
boolean setVisible = true;
if(gr_infoButtonText.isVisible()){
 setVisible = false;
}

f_setChartDescriptionText(i_gespreksleidraad3.getName(), setVisible); 
        }
        break;
      case _rect_hoverBlockingPieChart:
        if (true) {
          ShapeRectangle self = this.rect_hoverBlockingPieChart;
          
double do_nothing = 0; 
        }
        break;
      case _gr_closeWindow5:
        if (true) {
          ShapeGroup self = this.gr_closeWindow5;
          
gr_infoButtonText.setVisible(false);
 
        }
        break;
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
      case _rb_gespreksleidraad3: {
          ShapeRadioButtonGroup self = this.rb_gespreksleidraad3;
if(rb_gespreksleidraad3.getValue() == 0){
	gr_gebruikEigenOpwek.setVisible(false);
	gr_opwekZelfgebruik.setVisible(true);
}
else{
	gr_gebruikEigenOpwek.setVisible(true);
	gr_opwekZelfgebruik.setVisible(false);
} 
;}
        break;
      case _rb_gespreksleidraad5: {
          ShapeRadioButtonGroup self = this.rb_gespreksleidraad5;
f_setChartsGespreksleidraad5(uI_Results.f_getSelectedObjectData()); 
;}
        break;
      case _rb_gespreksleidraad: {
          ShapeRadioButtonGroup self = this.rb_gespreksleidraad;
f_selectGespreksleidraadCharts(); 
;}
        break;
      case _rb_gespreksleidraad4: {
          ShapeRadioButtonGroup self = this.rb_gespreksleidraad4;
if (rb_gespreksleidraad4.getValue() == 0){
	gr_gespreksleidraad4_A.setVisible(true);
	gr_gespreksleidraad4_B.setVisible(false);
}
else {
	gr_gespreksleidraad4_A.setVisible(false);
	gr_gespreksleidraad4_B.setVisible(true);
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
      case _rb_gespreksleidraad4: return 
0 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pl_consumptionChart3v2_pieLegenda_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pl_consumptionChart3v2_pieLegenda_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pl_productionChart3v2_pieLegenda_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pl_productionChart3v2_pieLegenda_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pl_productionChart3v2_pie_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pl_productionChart3v2_pie_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pl_consumptionChart3v2_pie_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pl_consumptionChart3v2_pie_DataItem1Value() {
    return 
0 
;
  }
  protected ShapeRadioButtonGroup rb_gespreksleidraad3;
  protected ShapeRadioButtonGroup rb_gespreksleidraad5;
  protected ShapeRadioButtonGroup rb_gespreksleidraad;
  protected ShapeRadioButtonGroup rb_gespreksleidraad4;
  protected StackChart pl_productionChartGespreksleidraad1;
  protected StackChart pl_consumptionChartGespreksleidraad1;
  protected StackChart sc_windSupplyStack;
  protected StackChart sc_PVSupplyStack;
  protected StackChart sc_electricityDemandStack;
  protected StackChart sc_heatDemandStack;
  protected StackChart sc_transportDemandStack;
  protected StackChart pl_productionChartIndividual;
  protected StackChart pl_productionChartCollective;
  protected StackChart pl_selfSufficiencyChartIndividual1;
  protected StackChart pl_selfSufficiencyChartCollective1;
  protected TimeStackChart energySupplyChartYearGespreksleidraad5;
  protected TimePlot energyDemandChartYearGespreksleidraad5;
  protected Plot plot_jaar;
  protected Plot plot_dagnacht;
  protected Plot plot_seizoen;
  protected Plot plot_week;
  protected PieChart pl_consumptionChart3v2_pieLegenda;
  protected PieChart pl_productionChart3v2_pieLegenda;
  protected PieChart pl_productionChart3v2_pie;
  protected PieChart pl_consumptionChart3v2_pie;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_rbGSLD_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_lineColor 
);
    shape.setLineWidth(
v_lineWidth 
);
  }
  
  protected ShapeRectangle rect_rbGSLD;
  protected ShapeText text18;
  protected ShapeText text19;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle12_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_naturalGasSupplyColor 
);
  }
  
  protected ShapeRectangle rectangle12;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle11_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_districtHeatDemandColor 
);
  }
  
  protected ShapeRectangle rectangle11;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle10_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_heatPumpHeatSupplyColor 
);
  }
  
  protected ShapeRectangle rectangle10;
  protected ShapeText text20;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GSL1_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
lavender 
);
  }
  
  protected ShapeRectangle rect_GSL1;
  protected ShapeText tx_topBarplotText3;
  protected ShapeText t_opwekTextGespreksleidraad1;
  protected ShapeText t_gebruikTextGespreksleidraad1;
  protected ShapeText tx_topBarplotText4;
  protected ShapeGroup gr_onbalansBarplot4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval26_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_selfConsumedElectricityColor_individual 
);
  }
  
  protected ShapeOval oval26;
  protected ShapeText t_gespreksleidraadLegend9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval27_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_exportedElectricityColor 
);
  }
  
  protected ShapeOval oval27;
  protected ShapeText t_gespreksleidraadLegend10;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval28_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_selfConsumedElectricityColor_individual 
);
  }
  
  protected ShapeOval oval28;
  protected ShapeText t_gespreksleidraadLegend11;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval29_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_importedElectricityColor 
);
  }
  
  protected ShapeOval oval29;
  protected ShapeText t_gespreksleidraadLegend12;
  protected ShapeText t_gespreksleidraadLegend13;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval30_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_districtHeatHeatSupplyColor 
);
  }
  
  protected ShapeOval oval30;
  protected ShapeText t_gespreksleidraadLegend14;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval31_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_naturalGasSupplyColor 
);
  }
  
  protected ShapeOval oval31;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval32_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_petroleumProductsSupplyColor 
);
  }
  
  protected ShapeOval oval32;
  protected ShapeText t_gespreksleidraadLegend15;
  protected ShapeText t_exportPerNeighborhood5;
  protected ShapeText t_exportPerNeighborhood6;
  protected ShapeImage i_gespreksleidraad1;
  protected ShapeGroup gr_gespreksleidraad1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GSL2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
lavender 
);
  }
  
  protected ShapeRectangle rect_GSL2;
  protected ShapeText tx_topBarplotText8;
  protected ShapeText txt_GSLD2_wind;
  protected ShapeText txt_gsld2_solar;
  protected ShapeText tx_topBarplotText9;
  protected ShapeText text4;
  protected ShapeText text5;
  protected ShapeText text6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle13_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_selfConsumedElectricityColor_individual 
);
  }
  
  protected ShapeRectangle rectangle13;
  protected ShapeText text2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle1_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_importedElectricityColor 
);
  }
  
  protected ShapeRectangle rectangle1;
  protected ShapeText text7;
  protected ShapeText text8;
  protected ShapeText text9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_heatPumpHeatSupplyColor 
);
  }
  
  protected ShapeRectangle rectangle2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle3_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_districtHeatDemandColor 
);
  }
  
  protected ShapeRectangle rectangle3;
  protected ShapeText text10;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle4_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_naturalGasSupplyColor 
);
  }
  
  protected ShapeRectangle rectangle4;
  protected ShapeText text11;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle5_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_hydrogenDemandColor 
);
  }
  
  protected ShapeRectangle rectangle5;
  protected ShapeText text12;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle6_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_electricityDemandColor 
);
  }
  
  protected ShapeRectangle rectangle6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle7_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_petroleumProductsDemandColor 
);
  }
  
  protected ShapeRectangle rectangle7;
  protected ShapeText text13;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle8_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_windElectricitySupplyColor 
);
  }
  
  protected ShapeRectangle rectangle8;
  protected ShapeText text16;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle9_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_potentialColor 
);
  }
  
  protected ShapeRectangle rectangle9;
  protected ShapeText text17;
  protected ShapeText t_energyDemand_ylabel2;
  protected ShapeText t_energyDemand_ylabel3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle14_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_PVElectricitySupplyColor 
);
  }
  
  protected ShapeRectangle rectangle14;
  protected ShapeText text24;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle15_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_curtailedColor 
);
  }
  
  protected ShapeRectangle rectangle15;
  protected ShapeText text25;
  protected ShapeImage i_gespreksleidraad2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle18_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_potentialColor 
);
  }
  
  protected ShapeRectangle rectangle18;
  protected ShapeText text26;
  protected ShapeGroup gr_gespreksleidraad2;
  protected ShapeText tx_topBarplotText7;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval18_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_selfConsumedElectricityColor_individual 
);
  }
  
  protected ShapeOval oval18;
  protected ShapeText t_selfConsumptionPerNeighborhood2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval19_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_exportedElectricityColor 
);
  }
  
  protected ShapeOval oval19;
  protected ShapeText t_exportPerNeighborhood1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval20_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_selfConsumedElectricityColor_individual 
);
  }
  
  protected ShapeOval oval20;
  protected ShapeText t_selfConsumptionPerRegion2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval21_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_exportedElectricityColor 
);
  }
  
  protected ShapeOval oval21;
  protected ShapeText t_exportPerRegion1;
  protected ShapeText text1125;
  protected ShapeText text1124;
  protected ShapeGroup gr_opwekZelfgebruik;
  protected ShapeText tx_topBarplotText28;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval22_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_selfConsumedElectricityColor_individual 
);
  }
  
  protected ShapeOval oval22;
  protected ShapeText t_selfConsumptionPerNeighborhood3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval23_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_importedElectricityColor 
);
  }
  
  protected ShapeOval oval23;
  protected ShapeText t_importPerNeighborhood1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval24_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_selfConsumedElectricityColor_individual 
);
  }
  
  protected ShapeOval oval24;
  protected ShapeText t_selfConsumptionPerRegion3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval25_SetDynamicParams_xjal( ShapeOval shape ) {
    shape.setFillColor(
v_importedElectricityColor 
);
  }
  
  protected ShapeOval oval25;
  protected ShapeText t_importPerRegion1;
  protected ShapeText text1131;
  protected ShapeText text1132;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_gebruikEigenOpwek_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setY(
-20 
);
  }
  
  protected ShapeGroup gr_gebruikEigenOpwek;
  protected ShapeImage i_gespreksleidraad3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GSL3_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
lavender 
);
  }
  
  protected ShapeRectangle rect_GSL3;
  protected ShapeGroup gr_gespreksleidraad3;
  protected ShapeText tx_topBarplotText13;
  protected ShapeText t_duurkromme_xlabel3;
  protected ShapeText tx_gespreksleidraad5;
  protected ShapeImage i_gespreksleidraad5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GSL5_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
lavender 
);
  }
  
  protected ShapeRectangle rect_GSL5;
  protected ShapeText t_duurkromme_ylabel2;
  protected ShapeGroup gr_gespreksleidraad5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GSL6_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
lavender 
);
  }
  
  protected ShapeRectangle rect_GSL6;
  protected ShapeText tx_topBarplotText38;
  protected ShapeText tx_topBarplotText39;
  protected ShapeText tx_topBarplotText40;
  protected ShapeText tx_topBarplotText41;
  protected ShapeText tx_topBarplotText42;
  protected ShapeText tx_topBarplotText43;
  protected ShapeText tx_topBarplotText44;
  protected ShapeText tx_topBarplotText45;
  protected ShapeText tx_topBarplotText46;
  protected ShapeText tx_topBarplotText47;
  protected ShapeLine line19;
  protected ShapeText tx_topBarplotText48;
  protected ShapeLine line20;
  protected ShapeLine line21;
  protected ShapeLine line22;
  protected ShapeText tx_numberOfPeaksDemand;
  protected ShapeText tx_averageTimePeakDemand;
  protected ShapeText tx_averageEnergyPeakDemand;
  protected ShapeText tx_maxTimePeakDemand;
  protected ShapeText tx_maxEnergyPeakDemand;
  protected ShapeText tx_averagePowerPeakDemand;
  protected ShapeText tx_maxPowerPeakDemand;
  protected ShapeText tx_maxEnergyPeakSupply;
  protected ShapeText tx_averageTimePeakSupply;
  protected ShapeText tx_numberOfPeaksSupply;
  protected ShapeText tx_maxTimePeakSupply;
  protected ShapeText tx_averageEnergyPeakSupply;
  protected ShapeText tx_maxPowerPeakSupply;
  protected ShapeText tx_averagePowerPeakSupply;
  protected ShapeText text22;
  protected ShapeText text23;
  protected ShapeGroup gr_gespreksleidraad6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_rb_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_lineColor 
);
    shape.setLineWidth(
v_lineWidth 
);
  }
  
  protected ShapeRectangle rect_rb;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GSL4_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
lavender 
);
  }
  
  protected ShapeRectangle rect_GSL4;
  protected ShapeText tx_topBarplotText11;
  protected ShapeGroup group_jaar;
  protected ShapeOval ovalNetbelasting4;
  protected ShapeOval ovalNetbelasting3;
  protected ShapeText tx_topBarplotText2;
  protected ShapeText t_duurkromme_xlabel;
  protected ShapeText t_duurkromme_ylabel;
  protected ShapeText tx_topBarplotText52;
  protected ShapeText tx_maxDemand;
  protected ShapeText tx_maxSupply;
  protected ShapeText tx_topBarplotText55;
  protected ShapeOval ovalNetbelasting1;
  protected ShapeText t_KPIBenuttingsgraad;
  protected ShapeText text1123;
  protected ShapeText text593;
  protected ShapeGroup gr_gespreksleidraad4_A;
  protected ShapeText t_duurkromme_ylabel6;
  protected ShapeText t_duurkromme_xlabel1;
  protected ShapeText t_duurkromme_ylabel7;
  protected ShapeText tx_topBarplotText5;
  protected ShapeText t_duurkromme_ylabel1;
  protected ShapeText t_duurkromme_xlabel5;
  protected ShapeText tx_topBarplotText6;
  protected ShapeText tx_topBarplotText14;
  protected ShapeText t_duurkromme_xlabel2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_gespreksleidraad4_B_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setY(
160 
);
  }
  
  protected ShapeGroup gr_gespreksleidraad4_B;
  protected ShapeGroup gr_gespreksleidraad4;
  protected ShapeText t_KPIselfsufficiency_pct4;
  protected ShapeOval ovalZelfvoorzienendheid3;
  protected ShapeText tx_topBarplotText17;
  protected ShapeOval ovalZelfvoorzienendheid5;
  protected ShapeText tx_topBarplotText26;
  protected ShapeLine line1;
  protected ShapeText tx_topBarplotText19;
  protected ShapeOval ovalZelfvoorzienendheid4;
  protected ShapeText tx_topBarplotText12;
  protected ShapeText tx_topBarplotText25;
  protected ShapeLine line6;
  protected ShapeText tx_topBarplotText21;
  protected ShapeText tx_topBarplotText15;
  protected ShapeText tx_topBarplotText18;
  protected ShapeText tx_topBarplotText24;
  protected ShapeText t_KPIselfsufficiency_pct3;
  protected ShapeLine line4;
  protected ShapeLine line3;
  protected ShapeLine line5;
  protected ShapeText t_KPIselfsufficiency_pct5;
  protected ShapeLine line2;
  protected ShapeLine line;
  protected ShapeText tx_topBarplotText20;
  protected ShapeGroup gr_oldNetbelastingInfo;
  protected ShapeRectangle rectangle16;
  protected ShapeText tx_topBarplotText37;
  protected ShapeOval oval;
  protected ShapeLine line15;
  protected ShapeLine line16;
  protected ShapeGroup gr_closeWindow;
  protected ShapeText text21;
  protected ShapeGroup gr_netcapaciteitInDeTwin;
  protected ShapeImage i_gespreksleidraad3v2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_GSL3v2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
lavender 
);
  }
  
  protected ShapeRectangle rect_GSL3v2;
  protected ShapeText t_totalConsumptionYear;
  protected ShapeText t_totalProductionYear;
  protected ShapeText txt_gebruikEigenElecOpwekBuurt3v2;
  protected ShapeText tx_topBarplotTexttxt_gebruikEigenElecOpwekBuurt3v2;
  protected ShapeText txt_gebruikEigenElecGebruikRegio3v2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_legendaPieChartBlock_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
v_backgroundColor 
);
  }
  
  protected ShapeRectangle rect_legendaPieChartBlock;
  protected ShapeRectangle rect_hoverBlockingPieChart;
  protected ShapeGroup gr_gespreksleidraad3v2;
  protected ShapeRectangle rectangle17;
  protected ShapeOval oval17;
  protected ShapeLine line23;
  protected ShapeLine line24;
  protected ShapeGroup gr_closeWindow5;
  protected ShapeText t_scenarioName1;
  protected ShapeText t_infoButtonText;
  protected ShapeGroup gr_infoButtonText;
  protected ShapeText text;
  
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
  protected ShapeText txt_displayedDataOf;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_selectedObjectDisplayTextGSLD_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
uI_Results.t_selectedObjectDisplayText.getText().replace("Data van: ", "") 
);
  }
  
  protected ShapeText t_selectedObjectDisplayTextGSLD;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rb_gespreksleidraad3 = new ShapeRadioButtonGroup(
ChartGespreksLeidraad.this, true, -230.0, -290.0,
			370.0, 60.0,
            black, true,
_rb_gespreksleidraad3_Font, true,
            new String[]{"Kan ik meer opwek lokaal zelf gebruiken?", "Kan ik meer gebruik lokaal zelf opwekken?", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_gespreksleidraad3, 0, value );
      }
    };
    rb_gespreksleidraad5 = new ShapeRadioButtonGroup(
ChartGespreksLeidraad.this, true, -200.0, -140.0,
			150.0, 50.0,
            black, true,
_rb_gespreksleidraad5_Font, false,
            new String[]{"Elektriciteit", "Energie", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_gespreksleidraad5, 0, value );
      }
    };
    rb_gespreksleidraad = new ShapeRadioButtonGroup(
ChartGespreksLeidraad.this, true, 10.0, 10.0,
			300.0, 110.0,
            black, true,
_rb_gespreksleidraad_Font, true,
            new String[]{"1. Hoeveel energie wordt er opgewekt en verbruikt?", "2. Meer lokaal opwekken?", "3. Lokaal opwek en verbruik afstemmen?", "4. Netcapaciteit beter benutten?", "5. Wat is de seizoensbalans?", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_gespreksleidraad, 0, value );
      }
    };
    rb_gespreksleidraad4 = new ShapeRadioButtonGroup(
ChartGespreksLeidraad.this, true, -80.0, -180.0,
			160.0, 40.0,
            black, true,
_rb_gespreksleidraad4_Font, false,
            new String[]{"Jaar overzicht", "Details", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_gespreksleidraad4, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _rb_gespreksleidraad4, 0 ) );
      }
    };
    rect_rbGSLD = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            lavender, whiteSmoke,
			460.0, 140.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_rbGSLD_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text18 = new ShapeText(
        SHAPE_DRAW_2D, true,2240.0, 1216.0, 0.0, 0.0,
        black,"Warmtepompen",
        _text18_Font, ALIGNMENT_LEFT );
    text19 = new ShapeText(
        SHAPE_DRAW_2D, true,2240.0, 1195.0, 0.0, 0.0,
        black,"Zelfconsumptie gebied [MWh]",
        _text19_Font, ALIGNMENT_LEFT );
    rectangle12 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,2220.0, 1240.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle12_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rectangle11 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,2220.0, 1199.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle11_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rectangle10 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,2220.0, 1220.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle10_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text20 = new ShapeText(
        SHAPE_DRAW_2D, true,2240.0, 1236.0, 0.0, 0.0,
        black,"Gas ketels",
        _text20_Font, ALIGNMENT_LEFT );
    rect_GSL1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-260.0, -310.0, 0.0, 0.0,
            gray, null,
			460.0, 610.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GSL1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GSL1.setVisible( false );
    tx_topBarplotText3 = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, -280.0, 0.0, 0.0,
        black,"Hoeveel energie opwek \nen verbruik heb ik?",
        _tx_topBarplotText3_Font, ALIGNMENT_CENTER );
    t_opwekTextGespreksleidraad1 = new ShapeText(
        SHAPE_DRAW_2D, true,-270.0, -20.0, 0.0, 0.0,
        black,"Opwek",
        _t_opwekTextGespreksleidraad1_Font, ALIGNMENT_CENTER );
    t_gebruikTextGespreksleidraad1 = new ShapeText(
        SHAPE_DRAW_2D, true,-45.0, -20.0, 0.0, 0.0,
        black,"Gebruik",
        _t_gebruikTextGespreksleidraad1_Font, ALIGNMENT_CENTER );
    tx_topBarplotText4 = new ShapeText(
        SHAPE_DRAW_2D, true,-320.0, -70.0, 0.0, 0.0,
        black,"Hoe wordt de opwek gebruikt en waar komt het gebruik \nvandaan per jaar en naar energiedrager",
        _tx_topBarplotText4_Font, ALIGNMENT_LEFT );
    oval26 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-215.0, 130.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval26_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gespreksleidraadLegend9 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, 123.0, 0.0, 0.0,
        black,"Lokaal gebruikt",
        _t_gespreksleidraadLegend9_Font, ALIGNMENT_LEFT );
    oval27 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-215.0, 150.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval27_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gespreksleidraadLegend10 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, 142.5, 0.0, 0.0,
        black,"Uitvoer elektriciteit",
        _t_gespreksleidraadLegend10_Font, ALIGNMENT_LEFT );
    oval28 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,10.0, 130.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval28_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gespreksleidraadLegend11 = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 123.0, 0.0, 0.0,
        black,"Lokaal opgewekt",
        _t_gespreksleidraadLegend11_Font, ALIGNMENT_LEFT );
    oval29 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,10.0, 150.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval29_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gespreksleidraadLegend12 = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 142.5, 0.0, 0.0,
        black,"Invoer elektriciteit",
        _t_gespreksleidraadLegend12_Font, ALIGNMENT_LEFT );
    t_gespreksleidraadLegend13 = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 162.5, 0.0, 0.0,
        black,"Invoer aardgas",
        _t_gespreksleidraadLegend13_Font, ALIGNMENT_LEFT );
    oval30 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,10.0, 210.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval30_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gespreksleidraadLegend14 = new ShapeText(
        SHAPE_DRAW_2D, true,26.0, 203.0, 0.0, 0.0,
        black,"Energie voor warmtenet",
        _t_gespreksleidraadLegend14_Font, ALIGNMENT_LEFT );
    oval31 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,10.0, 170.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval31_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    oval32 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,10.0, 190.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval32_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gespreksleidraadLegend15 = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 182.5, 0.0, 0.0,
        black,"Invoer benzine/diesel",
        _t_gespreksleidraadLegend15_Font, ALIGNMENT_LEFT );
    t_exportPerNeighborhood5 = new ShapeText(
        SHAPE_DRAW_2D, true,-220.0, -70.0, 0.0, 0.0,
        black,"[GWh]",
        _t_exportPerNeighborhood5_Font, ALIGNMENT_LEFT );
    t_exportPerNeighborhood6 = new ShapeText(
        SHAPE_DRAW_2D, true,5.0, -70.0, 0.0, 0.0,
        black,"[GWh]",
        _t_exportPerNeighborhood6_Font, ALIGNMENT_LEFT );
    i_gespreksleidraad1 = new ShapeImage(
		ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 170.0, -280.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_gespreksleidraad1, 0, clickx, clicky );
      }
    };
    rect_GSL2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-260.0, -320.0, 0.0, 0.0,
            gray, null,
			460.0, 610.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GSL2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GSL2.setVisible( false );
    tx_topBarplotText8 = new ShapeText(
        SHAPE_DRAW_2D, true,-30.0, 20.0, 0.0, 0.0,
        black,"Kan ik meer opwekken?",
        _tx_topBarplotText8_Font, ALIGNMENT_CENTER );
    txt_GSLD2_wind = new ShapeText(
        SHAPE_DRAW_2D, true,-100.0, 200.0, 0.0, 0.0,
        black,"Wind",
        _txt_GSLD2_wind_Font, ALIGNMENT_LEFT );
    txt_gsld2_solar = new ShapeText(
        SHAPE_DRAW_2D, true,35.0, 200.0, 0.0, 0.0,
        black,"Zon",
        _txt_gsld2_solar_Font, ALIGNMENT_LEFT );
    tx_topBarplotText9 = new ShapeText(
        SHAPE_DRAW_2D, true,-30.0, -300.0, 0.0, 0.0,
        black,"Kan mijn gebruik duurzamer?",
        _tx_topBarplotText9_Font, ALIGNMENT_CENTER );
    text4 = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, -110.0, 0.0, 0.0,
        black,"Transport \nen vervoer",
        _text4_Font, ALIGNMENT_LEFT );
    text5 = new ShapeText(
        SHAPE_DRAW_2D, true,-60.0, -110.0, 0.0, 0.0,
        black,"Warmte",
        _text5_Font, ALIGNMENT_LEFT );
    text6 = new ShapeText(
        SHAPE_DRAW_2D, true,-180.0, -110.0, 0.0, 0.0,
        black,"Elektriciteit",
        _text6_Font, ALIGNMENT_LEFT );
    rectangle13 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-210.0, -61.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle13_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, -65.0, 0.0, 0.0,
        black,"Lokale opwek",
        _text2_Font, ALIGNMENT_LEFT );
    rectangle1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-210.0, -40.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text7 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, -44.0, 0.0, 0.0,
        black,"Invoer",
        _text7_Font, ALIGNMENT_LEFT );
    text8 = new ShapeText(
        SHAPE_DRAW_2D, true,-75.0, -44.0, 0.0, 0.0,
        black,"Elek. voor \nwarmtepompen",
        _text8_Font, ALIGNMENT_LEFT );
    text9 = new ShapeText(
        SHAPE_DRAW_2D, true,-75.0, -65.0, 0.0, 0.0,
        black,"Warmtenet",
        _text9_Font, ALIGNMENT_LEFT );
    rectangle2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-95.0, -40.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rectangle3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-95.0, -61.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text10 = new ShapeText(
        SHAPE_DRAW_2D, true,-75.0, -9.0, 0.0, 0.0,
        black,"Gas ketels",
        _text10_Font, ALIGNMENT_LEFT );
    rectangle4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-95.0, -5.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle4_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text11 = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, -24.0, 0.0, 0.0,
        black,"Fossiele brandstof",
        _text11_Font, ALIGNMENT_LEFT );
    rectangle5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,30.0, -40.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle5_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text12 = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, -65.0, 0.0, 0.0,
        black,"Elektriciteit",
        _text12_Font, ALIGNMENT_LEFT );
    rectangle6 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,30.0, -61.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle6_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rectangle7 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,30.0, -20.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle7_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text13 = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, -44.0, 0.0, 0.0,
        black,"Waterstof",
        _text13_Font, ALIGNMENT_LEFT );
    rectangle8 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-130.0, 225.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle8_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text16 = new ShapeText(
        SHAPE_DRAW_2D, true,-110.0, 221.0, 0.0, 0.0,
        black,"Opwek wind",
        _text16_Font, ALIGNMENT_LEFT );
    rectangle9 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,5.0, 265.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle9_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text17 = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 260.0, 0.0, 0.0,
        black,"Rest potentieel zon op dak",
        _text17_Font, ALIGNMENT_LEFT );
    t_energyDemand_ylabel2 = new ShapeText(
        SHAPE_DRAW_2D, true,-250.0, -260.0, 0.0, 0.0,
        black,"[GWh]",
        _t_energyDemand_ylabel2_Font, ALIGNMENT_LEFT );
    t_energyDemand_ylabel3 = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, 70.0, 0.0, 0.0,
        black,"[GWh]",
        _t_energyDemand_ylabel3_Font, ALIGNMENT_LEFT );
    rectangle14 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,5.0, 225.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle14_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text24 = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 221.0, 0.0, 0.0,
        black,"Opwek zon",
        _text24_Font, ALIGNMENT_LEFT );
    rectangle15 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,5.0, 245.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle15_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text25 = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 240.0, 0.0, 0.0,
        black,"Gecurtailde energie",
        _text25_Font, ALIGNMENT_LEFT );
    i_gespreksleidraad2 = new ShapeImage(
		ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 170.0, -300.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_gespreksleidraad2, 0, clickx, clicky );
      }
    };
    rectangle18 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-130.0, 265.0, 0.0, 0.0,
            null, yellowGreen,
			12.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rectangle18_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    text26 = new ShapeText(
        SHAPE_DRAW_2D, true,-110.0, 260.0, 0.0, 0.0,
        black,"Rest Potentieel",
        _text26_Font, ALIGNMENT_LEFT );
    tx_topBarplotText7 = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -190.0, 0.0, 0.0,
        black,"Kan ik meer elektriciteitsopwek \nlokaal zelf gebruiken?",
        _tx_topBarplotText7_Font, ALIGNMENT_CENTER );
    oval18 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-175.0, 150.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval18_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_selfConsumptionPerNeighborhood2 = new ShapeText(
        SHAPE_DRAW_2D, true,-160.0, 143.0, 0.0, 0.0,
        black,"Zelfconsumptie [GWh]",
        _t_selfConsumptionPerNeighborhood2_Font, ALIGNMENT_LEFT );
    oval19 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-175.0, 170.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval19_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_exportPerNeighborhood1 = new ShapeText(
        SHAPE_DRAW_2D, true,-160.0, 162.5, 0.0, 0.0,
        black,"Uitvoer [GWh]",
        _t_exportPerNeighborhood1_Font, ALIGNMENT_LEFT );
    oval20 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,50.0, 150.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval20_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_selfConsumptionPerRegion2 = new ShapeText(
        SHAPE_DRAW_2D, true,65.0, 143.0, 0.0, 0.0,
        black,"Zelfconsumptie [GWh]",
        _t_selfConsumptionPerRegion2_Font, ALIGNMENT_LEFT );
    oval21 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,50.0, 170.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval21_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_exportPerRegion1 = new ShapeText(
        SHAPE_DRAW_2D, true,65.0, 162.5, 0.0, 0.0,
        black,"Uitvoer [GWh]",
        _t_exportPerRegion1_Font, ALIGNMENT_LEFT );
    text1125 = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, -80.0, 0.0, 0.0,
        black,"Gebruik eigen elektriciteits-\nopwek binnen regio",
        _text1125_Font, ALIGNMENT_LEFT );
    text1124 = new ShapeText(
        SHAPE_DRAW_2D, true,-195.0, -80.0, 0.0, 0.0,
        black,"Gebruik eigen elektriciteits-\nopwek per buurt",
        _text1124_Font, ALIGNMENT_LEFT );
    tx_topBarplotText28 = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -190.0, 0.0, 0.0,
        black,"Kan ik meer elektriciteitsgebruik \nlokaal zelf opwekken?",
        _tx_topBarplotText28_Font, ALIGNMENT_CENTER );
    oval22 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-185.0, 150.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval22_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_selfConsumptionPerNeighborhood3 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, 143.0, 0.0, 0.0,
        black,"Zelfconsumptie [GWh]",
        _t_selfConsumptionPerNeighborhood3_Font, ALIGNMENT_LEFT );
    oval23 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-185.0, 170.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval23_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_importPerNeighborhood1 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, 162.5, 0.0, 0.0,
        black,"Invoer [GWh]",
        _t_importPerNeighborhood1_Font, ALIGNMENT_LEFT );
    oval24 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,40.0, 150.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval24_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_selfConsumptionPerRegion3 = new ShapeText(
        SHAPE_DRAW_2D, true,55.0, 143.0, 0.0, 0.0,
        black,"Zelfconsumptie [GWh]",
        _t_selfConsumptionPerRegion3_Font, ALIGNMENT_LEFT );
    oval25 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,40.0, 170.0, 0.0, 0.0,
       null, yellowGreen,
	   7.0, 7.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _oval25_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_importPerRegion1 = new ShapeText(
        SHAPE_DRAW_2D, true,55.0, 162.5, 0.0, 0.0,
        black,"Invoer [GWh]",
        _t_importPerRegion1_Font, ALIGNMENT_LEFT );
    text1131 = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, -80.0, 0.0, 0.0,
        black,"Bron elektriciteits-\nvraag binnen regio",
        _text1131_Font, ALIGNMENT_LEFT );
    text1132 = new ShapeText(
        SHAPE_DRAW_2D, true,-205.0, -80.0, 0.0, 0.0,
        black,"Bron elektriciteits-\nvraag per buurt",
        _text1132_Font, ALIGNMENT_LEFT );
    i_gespreksleidraad3 = new ShapeImage(
		ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 170.0, -290.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_gespreksleidraad3, 0, clickx, clicky );
      }
    };
    rect_GSL3 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-260.0, -310.0, 0.0, 0.0,
            gray, null,
			460.0, 610.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GSL3_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GSL3.setVisible( false );
    tx_topBarplotText13 = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -260.0, 0.0, 0.0,
        black,"Kan ik opwek en verbruik over de\nseizoenen balanceren?",
        _tx_topBarplotText13_Font, ALIGNMENT_CENTER );
    t_duurkromme_xlabel3 = new ShapeText(
        SHAPE_DRAW_2D, true,-20.0, 90.0, 0.0, 0.0,
        black,"Maand",
        _t_duurkromme_xlabel3_Font, ALIGNMENT_LEFT );
    tx_gespreksleidraad5 = new ShapeText(
        SHAPE_DRAW_2D, true,-225.0, -170.0, 0.0, 0.0,
        black,"Invoer en opwek van energie per bron in gemiddeld dag vermogen [kW]",
        _tx_gespreksleidraad5_Font, ALIGNMENT_LEFT );
    i_gespreksleidraad5 = new ShapeImage(
		ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 200.0, -230.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_gespreksleidraad5, 0, clickx, clicky );
      }
    };
    rect_GSL5 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -280.0, 0.0, 0.0,
            gray, null,
			460.0, 610.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GSL5_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GSL5.setVisible( false );
  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP1_xjal() {
    t_duurkromme_ylabel2 = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, -90.0, 0.0, 1.5707963267948966,
        black,"Gemiddeld vermogen per dag [kW]",
        _t_duurkromme_ylabel2_Font, ALIGNMENT_LEFT );
    rect_GSL6 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -260.0, 0.0, 0.0,
            gray, null,
			460.0, 610.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GSL6_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GSL6.setVisible( false );
    tx_topBarplotText38 = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -250.0, 0.0, 0.0,
        black,"Kunnen wij pieken vermijden?",
        _tx_topBarplotText38_Font, ALIGNMENT_CENTER );
    tx_topBarplotText39 = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, -150.0, 0.0, 0.0,
        black,"Aantal pieken",
        _tx_topBarplotText39_Font, ALIGNMENT_LEFT );
    tx_topBarplotText40 = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, -125.0, 0.0, 0.0,
        black,"Gemiddelde duur [h]",
        _tx_topBarplotText40_Font, ALIGNMENT_LEFT );
    tx_topBarplotText41 = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, -190.0, 0.0, 0.0,
        black,"Afname",
        _tx_topBarplotText41_Font, ALIGNMENT_LEFT );
    tx_topBarplotText42 = new ShapeText(
        SHAPE_DRAW_2D, true,120.0, -190.0, 0.0, 0.0,
        black,"Teruglevering",
        _tx_topBarplotText42_Font, ALIGNMENT_LEFT );
    tx_topBarplotText43 = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, -100.0, 0.0, 0.0,
        black,"Gemiddelde energievraag [MWh]",
        _tx_topBarplotText43_Font, ALIGNMENT_LEFT );
    tx_topBarplotText44 = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, -50.0, 0.0, 0.0,
        black,"Maximale duur [h]",
        _tx_topBarplotText44_Font, ALIGNMENT_LEFT );
    tx_topBarplotText45 = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, -25.0, 0.0, 0.0,
        black,"Maximale energievraag [MWh]",
        _tx_topBarplotText45_Font, ALIGNMENT_LEFT );
    tx_topBarplotText46 = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, -75.0, 0.0, 0.0,
        black,"Gemiddelde piek overbelasting [MW]",
        _tx_topBarplotText46_Font, ALIGNMENT_LEFT );
    tx_topBarplotText47 = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, 0.0, 0.0, 0.0,
        black,"Maximale piek overbelasting [MW]",
        _tx_topBarplotText47_Font, ALIGNMENT_LEFT );
    line19 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -210.0, -160.0, 0.0, black,
 		415.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    tx_topBarplotText48 = new ShapeText(
        SHAPE_DRAW_2D, true,-210.0, -190.0, 0.0, 0.0,
        black,"Overbelasting",
        _tx_topBarplotText48_Font, ALIGNMENT_LEFT );
    line20 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -210.0, 30.0, 0.0, black,
 		415.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line21 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 0.0, -150.0, 0.0, black,
 		0.0,	170.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line22 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 110.0, -150.0, 0.0, black,
 		0.0,	170.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    tx_numberOfPeaksDemand = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, -150.0, 0.0, 0.0,
        black,"100",
        _tx_numberOfPeaksDemand_Font, ALIGNMENT_RIGHT );
    tx_averageTimePeakDemand = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, -125.0, 0.0, 0.0,
        black,"6",
        _tx_averageTimePeakDemand_Font, ALIGNMENT_RIGHT );
    tx_averageEnergyPeakDemand = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, -100.0, 0.0, 0.0,
        black,"30",
        _tx_averageEnergyPeakDemand_Font, ALIGNMENT_RIGHT );
    tx_maxTimePeakDemand = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, -50.0, 0.0, 0.0,
        black,"12",
        _tx_maxTimePeakDemand_Font, ALIGNMENT_RIGHT );
    tx_maxEnergyPeakDemand = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, -25.0, 0.0, 0.0,
        black,"35",
        _tx_maxEnergyPeakDemand_Font, ALIGNMENT_RIGHT );
    tx_averagePowerPeakDemand = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, -75.0, 0.0, 0.0,
        black,"20",
        _tx_averagePowerPeakDemand_Font, ALIGNMENT_RIGHT );
    tx_maxPowerPeakDemand = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, 0.0, 0.0, 0.0,
        black,"40",
        _tx_maxPowerPeakDemand_Font, ALIGNMENT_RIGHT );
    tx_maxEnergyPeakSupply = new ShapeText(
        SHAPE_DRAW_2D, true,185.0, -24.5, 0.0, 0.0,
        black,"35",
        _tx_maxEnergyPeakSupply_Font, ALIGNMENT_RIGHT );
    tx_averageTimePeakSupply = new ShapeText(
        SHAPE_DRAW_2D, true,185.0, -124.5, 0.0, 0.0,
        black,"6",
        _tx_averageTimePeakSupply_Font, ALIGNMENT_RIGHT );
    tx_numberOfPeaksSupply = new ShapeText(
        SHAPE_DRAW_2D, true,185.0, -149.5, 0.0, 0.0,
        black,"100",
        _tx_numberOfPeaksSupply_Font, ALIGNMENT_RIGHT );
    tx_maxTimePeakSupply = new ShapeText(
        SHAPE_DRAW_2D, true,185.0, -49.5, 0.0, 0.0,
        black,"12",
        _tx_maxTimePeakSupply_Font, ALIGNMENT_RIGHT );
    tx_averageEnergyPeakSupply = new ShapeText(
        SHAPE_DRAW_2D, true,185.0, -99.5, 0.0, 0.0,
        black,"30",
        _tx_averageEnergyPeakSupply_Font, ALIGNMENT_RIGHT );
    tx_maxPowerPeakSupply = new ShapeText(
        SHAPE_DRAW_2D, true,185.0, 0.5, 0.0, 0.0,
        black,"40",
        _tx_maxPowerPeakSupply_Font, ALIGNMENT_RIGHT );
    tx_averagePowerPeakSupply = new ShapeText(
        SHAPE_DRAW_2D, true,185.0, -74.5, 0.0, 0.0,
        black,"20",
        _tx_averagePowerPeakSupply_Font, ALIGNMENT_RIGHT );
    text22 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, 50.0, 0.0, 0.0,
        black,"Verduurzamingsperspectief:",
        _text22_Font, ALIGNMENT_LEFT );
    text23 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, 90.0, 0.0, 0.0,
        black,"1. Stem vraag en aanbod op elkaar af\n2. Zijn er enkele pieken per jaar voor teruglevering? \n    Kijk naar curtailment\n3. Zijn er enkele pieken per jaar voor afname? \n    Probeer slim laden en aansturing van warmtepompen\n4. Zijn er nog steeds veel pieken met een gemiddelde duur \n    van enkele uren? \n    Probeer batterijen of V2G.\n5. Zijn er lange periodes van tekorten? \n    Zorg voor meer en gevarieerde opwek.\n6. Zijn er lange periodes van overschotten?\n    Kijk naar elektrificering, warmteopslag en conversie\n7. Zijn er pieken bij individuele bedrijven?\n    Bekijk de potentie van groepscontracten",
        _text23_Font, ALIGNMENT_LEFT );
    rect_rb = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -180.0, 0.0, 0.0,
            lavender, whiteSmoke,
			460.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_rb_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GSL4 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -180.0, 0.0, 0.0,
            gray, null,
			460.0, 610.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GSL4_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GSL4.setVisible( false );
    tx_topBarplotText11 = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -120.0, 0.0, 0.0,
        black,"Kan ik netcapaciteit\nbeter benutten?",
        _tx_topBarplotText11_Font, ALIGNMENT_CENTER );
    ovalNetbelasting4 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,30.0, 340.0, 0.0, 0.0,
       null, burlyWood,
	   30.0, 30.0, 10.0, 1.0, LINE_STYLE_SOLID );
    ovalNetbelasting3 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,150.0, 340.0, 0.0, 0.0,
       null, mediumSeaGreen,
	   30.0, 30.0, 10.0, 1.0, LINE_STYLE_SOLID );
    tx_topBarplotText2 = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -50.0, 0.0, 0.0,
        black,"Belastingduurkromme",
        _tx_topBarplotText2_Font, ALIGNMENT_CENTER );
    t_duurkromme_xlabel = new ShapeText(
        SHAPE_DRAW_2D, true,-5.0, 185.0, 0.0, 0.0,
        black,"Duur [u]",
        _t_duurkromme_xlabel_Font, ALIGNMENT_LEFT );
    t_duurkromme_ylabel = new ShapeText(
        SHAPE_DRAW_2D, true,-205.0, 25.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_duurkromme_ylabel_Font, ALIGNMENT_LEFT );
    tx_topBarplotText52 = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, 290.0, 0.0, 0.0,
        black,"Max afname",
        _tx_topBarplotText52_Font, ALIGNMENT_CENTER );
    tx_maxDemand = new ShapeText(
        SHAPE_DRAW_2D, true,28.0, 330.0, 0.0, 0.0,
        white,"xx MW",
        _tx_maxDemand_Font, ALIGNMENT_CENTER );
    tx_maxSupply = new ShapeText(
        SHAPE_DRAW_2D, true,149.0, 330.0, 0.0, 0.0,
        white,"xx MW",
        _tx_maxSupply_Font, ALIGNMENT_CENTER );
    tx_topBarplotText55 = new ShapeText(
        SHAPE_DRAW_2D, true,145.0, 290.0, 0.0, 0.0,
        black,"Max teruglevering",
        _tx_topBarplotText55_Font, ALIGNMENT_CENTER );
    ovalNetbelasting1 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-135.0, 342.0, 0.0, 0.0,
       null, cornflowerBlue,
	   45.0, 45.0, 10.0, 1.0, LINE_STYLE_SOLID );
    t_KPIBenuttingsgraad = new ShapeText(
        SHAPE_DRAW_2D, true,-135.0, 325.0, 0.0, 0.0,
        white,"20%",
        _t_KPIBenuttingsgraad_Font, ALIGNMENT_CENTER );
    text1123 = new ShapeText(
        SHAPE_DRAW_2D, true,-130.0, 397.0, 0.0, 0.0,
        black,"Gemiddelde benutting",
        _text1123_Font, ALIGNMENT_CENTER );
    text593 = new ShapeText(
        SHAPE_DRAW_2D, true,-140.0, 270.0, 0.0, 0.0,
        black,"Benuttingsgraad",
        _text593_Font, ALIGNMENT_CENTER );
    t_duurkromme_ylabel6 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, 85.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_duurkromme_ylabel6_Font, ALIGNMENT_LEFT );
    t_duurkromme_xlabel1 = new ShapeText(
        SHAPE_DRAW_2D, true,-15.0, -152.0, 0.0, 0.0,
        black,"Duur [u]",
        _t_duurkromme_xlabel1_Font, ALIGNMENT_LEFT );
    t_duurkromme_ylabel7 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, -85.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_duurkromme_ylabel7_Font, ALIGNMENT_LEFT );
    tx_topBarplotText5 = new ShapeText(
        SHAPE_DRAW_2D, true,-10.0, -290.0, 0.0, 0.0,
        black,"Belastingduurkromme zomer/winter week\n",
        _tx_topBarplotText5_Font, ALIGNMENT_CENTER );
    t_duurkromme_ylabel1 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, -255.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_duurkromme_ylabel1_Font, ALIGNMENT_LEFT );
    t_duurkromme_xlabel5 = new ShapeText(
        SHAPE_DRAW_2D, true,-15.0, 20.0, 0.0, 0.0,
        black,"Duur [u]",
        _t_duurkromme_xlabel5_Font, ALIGNMENT_LEFT );
    tx_topBarplotText6 = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, -120.0, 0.0, 0.0,
        black,"Belastingduurkromme dag/nacht",
        _tx_topBarplotText6_Font, ALIGNMENT_CENTER );
    tx_topBarplotText14 = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, 50.0, 0.0, 0.0,
        black,"Belastingduurkromme week/weekend",
        _tx_topBarplotText14_Font, ALIGNMENT_CENTER );
    t_duurkromme_xlabel2 = new ShapeText(
        SHAPE_DRAW_2D, true,-15.0, 200.0, 0.0, 0.0,
        black,"Duur [u]",
        _t_duurkromme_xlabel2_Font, ALIGNMENT_LEFT );
    t_KPIselfsufficiency_pct4 = new ShapeText(
        SHAPE_DRAW_2D, true,-15.0, 50.0, 0.0, 0.0,
        black,"200 \nuur",
        _t_KPIselfsufficiency_pct4_Font, ALIGNMENT_CENTER );
    ovalZelfvoorzienendheid3 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-15.0, -70.0, 0.0, 0.0,
       black, yellowGreen,
	   37.0, 37.0, 10.0, 1.0, LINE_STYLE_SOLID );
    tx_topBarplotText17 = new ShapeText(
        SHAPE_DRAW_2D, false,-210.0, -80.0, 0.0, 0.0,
        black,"Hoog naar\nmiddenspanningsnet",
        _tx_topBarplotText17_Font, ALIGNMENT_LEFT );
    ovalZelfvoorzienendheid5 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,130.0, 65.0, 0.0, 0.0,
       black, yellowGreen,
	   30.0, 30.0, 10.0, 1.0, LINE_STYLE_SOLID );
    tx_topBarplotText26 = new ShapeText(
        SHAPE_DRAW_2D, false,130.0, -5.0, 0.0, 0.0,
        black,"Overbelasting \n[aantal trafo's]",
        _tx_topBarplotText26_Font, ALIGNMENT_CENTER );
    line1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 55.0, -120.0, 0.0, black,
 		0.0,	100.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    tx_topBarplotText19 = new ShapeText(
        SHAPE_DRAW_2D, false,70.0, -65.0, 0.0, 0.0,
        black,"Beschikbare \ncapaciteit \nafname",
        _tx_topBarplotText19_Font, ALIGNMENT_LEFT );
    ovalZelfvoorzienendheid4 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-15.0, 65.0, 0.0, 0.0,
       black, orangeRed,
	   30.0, 30.0, 10.0, 1.0, LINE_STYLE_SOLID );
    tx_topBarplotText12 = new ShapeText(
        SHAPE_DRAW_2D, false,-210.0, -110.0, 0.0, 0.0,
        black,"Regionaal:",
        _tx_topBarplotText12_Font, ALIGNMENT_LEFT );
    tx_topBarplotText25 = new ShapeText(
        SHAPE_DRAW_2D, false,-15.0, -5.0, 0.0, 0.0,
        black,"Overbelasting \n[totaal aantal uur]",
        _tx_topBarplotText25_Font, ALIGNMENT_CENTER );
    line6 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -220.0, -130.0, 0.0, black,
 		415.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    tx_topBarplotText21 = new ShapeText(
        SHAPE_DRAW_2D, false,190.0, -50.0, 0.0, 0.0,
        black,"12 MVA",
        _tx_topBarplotText21_Font, ALIGNMENT_RIGHT );
    tx_topBarplotText15 = new ShapeText(
        SHAPE_DRAW_2D, false,-210.0, 10.0, 0.0, 0.0,
        black,"Lokaal",
        _tx_topBarplotText15_Font, ALIGNMENT_LEFT );
    tx_topBarplotText18 = new ShapeText(
        SHAPE_DRAW_2D, false,70.0, -115.0, 0.0, 0.0,
        black,"Beschikbare \ncapaciteit \nafname",
        _tx_topBarplotText18_Font, ALIGNMENT_LEFT );
    tx_topBarplotText24 = new ShapeText(
        SHAPE_DRAW_2D, false,-210.0, 40.0, 0.0, 0.0,
        black,"Midden en\nlaagspanningsnet",
        _tx_topBarplotText24_Font, ALIGNMENT_LEFT );
    t_KPIselfsufficiency_pct3 = new ShapeText(
        SHAPE_DRAW_2D, true,-15.0, -85.0, 0.0, 0.0,
        black,"Capaciteit\nbeschikbaar",
        _t_KPIselfsufficiency_pct3_Font, ALIGNMENT_CENTER );
    line4 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -85.0, 0.0, 0.0, black,
 		0.0,	100.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line3 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -215.0, -10.0, 0.0, black,
 		415.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line5 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -220.0, 110.0, 0.0, black,
 		415.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    t_KPIselfsufficiency_pct5 = new ShapeText(
        SHAPE_DRAW_2D, true,130.0, 55.0, 0.0, 0.0,
        black,"6",
        _t_KPIselfsufficiency_pct5_Font, ALIGNMENT_CENTER );
    line2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 55.0, 0.0, 0.0, black,
 		0.0,	100.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -85.0, -120.0, 0.0, black,
 		0.0,	100.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    tx_topBarplotText20 = new ShapeText(
        SHAPE_DRAW_2D, false,190.0, -100.0, 0.0, 0.0,
        black,"21 MVA",
        _tx_topBarplotText20_Font, ALIGNMENT_RIGHT );
    rectangle16 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-210.0, -150.0, 0.0, 0.0,
            black, white,
			410.0, 290.0, 10.0, 1.0, LINE_STYLE_SOLID );
    tx_topBarplotText37 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, -130.0, 0.0, 0.0,
        black,"Netcapaciteit in de twin",
        _tx_topBarplotText37_Font, ALIGNMENT_LEFT );
    oval = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       black, darkGray,
	   12.0, 12.0, 10.0, 1.0, LINE_STYLE_SOLID );
    line15 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -6.0, 6.0, 0.0, white,
 		12.0,	-12.0, 0.0, 3.0, 10.0, LINE_STYLE_SOLID );
    line16 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 6.0, 6.0, 0.0, white,
 		-12.0,	-12.0, 0.0, 3.0, 10.0, LINE_STYLE_SOLID );
    text21 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, -90.0, 0.0, 0.0,
        black,"Netcongesetie kan optreden op verschillende netvlakken. Lokaal op \nlaag en middenspanning. Regionaal op de koppeling van hoog naar \nmiddenspanning, of op de hoogspanningskabels zelf. \n\nOok de oplossingen van netcongestie verschillen per vlak. Energy \nhubs maken beter gebruik van het lokale net, maar kunnen hogere\nnetvlakken nog steeds te veel belasten. Als energy hubs groeps-\ntransportovereenkomsten met de netbeheerder af willen sluiten zal\ndie dus altijd nog extra netimpact berekenen moeten maken voor \nhiermee akkoord te kunnen gaan\n\nIn deze digital twin kijken we per buurt naar laagspanning, en naar\nde hoog naar middenspanningsstations in de drechtsteden. De \naannames zijn indicatief, gebaseerd op data en kengetallen. \nControleer je plannen daarom altijd bij de netbeheerder.\n",
        _text21_Font, ALIGNMENT_LEFT );
    i_gespreksleidraad3v2 = new ShapeImage(
		ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 170.0, -290.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_gespreksleidraad3v2, 0, clickx, clicky );
      }
    };
    rect_GSL3v2 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-260.0, -310.0, 0.0, 0.0,
            gray, null,
			460.0, 610.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_GSL3v2_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_GSL3v2.setVisible( false );
    t_totalConsumptionYear = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, -110.0, 0.0, 0.0,
        black,"Totale Verbruik: \n0.00 [MWh]",
        _t_totalConsumptionYear_Font, ALIGNMENT_CENTER );
    t_totalProductionYear = new ShapeText(
        SHAPE_DRAW_2D, true,-150.0, -110.0, 0.0, 0.0,
        black,"Totale Opwek: \n0.00 [MWh]",
        _t_totalProductionYear_Font, ALIGNMENT_CENTER );
    txt_gebruikEigenElecOpwekBuurt3v2 = new ShapeText(
        SHAPE_DRAW_2D, true,-220.0, -200.0, 0.0, 0.0,
        black,"Gebruik eigen elektriciteits-\nopwek",
        _txt_gebruikEigenElecOpwekBuurt3v2_Font, ALIGNMENT_LEFT );
    tx_topBarplotTexttxt_gebruikEigenElecOpwekBuurt3v2 = new ShapeText(
        SHAPE_DRAW_2D, true,-25.0, -300.0, 0.0, 0.0,
        black,"Kan ik meer elektriciteitsopwek \nlokaal zelf gebruiken?",
        _tx_topBarplotTexttxt_gebruikEigenElecOpwekBuurt3v2_Font, ALIGNMENT_CENTER );
    txt_gebruikEigenElecGebruikRegio3v2 = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, -200.0, 0.0, 0.0,
        black,"Bron elektriciteits-\nvraag",
        _txt_gebruikEigenElecGebruikRegio3v2_Font, ALIGNMENT_LEFT );
    rect_legendaPieChartBlock = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-255.0, -50.0, 0.0, 0.0,
            null, white,
			450.0, 200.0, 10.0, 0.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_legendaPieChartBlock_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_hoverBlockingPieChart = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-250.0, -60.0, 0.0, 0.0,
            null, _rect_hoverBlockingPieChart_Fill_Color,
			445.0, 210.0, 10.0, 0.0, LINE_STYLE_SOLID ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rect_hoverBlockingPieChart, 0, clickx, clicky );
      }
    };
    rectangle17 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-210.0, -230.0, 0.0, 0.0,
            lavender, _rectangle17_Fill_Color,
			420.0, 490.0, 10.0, 1.0, LINE_STYLE_DOTTED );
    oval17 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       black, darkGray,
	   12.0, 12.0, 10.0, 1.0, LINE_STYLE_SOLID );
    line23 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -6.0, 6.0, 0.0, white,
 		12.0,	-12.0, 0.0, 3.0, 10.0, LINE_STYLE_SOLID );
    line24 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 6.0, 6.0, 0.0, white,
 		-12.0,	-12.0, 0.0, 3.0, 10.0, LINE_STYLE_SOLID );
  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP2_xjal() {
    t_scenarioName1 = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, -180.0, 0.0, 0.0,
        black,"Beschrijving",
        _t_scenarioName1_Font, ALIGNMENT_LEFT );
    t_infoButtonText = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, -130.0, 0.0, 0.0,
        black,"Warmtenet worden ook aangelegd op enkele \nbedrijventerreinen waar een deel van de \nbedrijven wordt aangesloten. Wij nemen aan \ndat zo'n 20% van de bedrijven aangelsoten \nworden op het warmtenet. Bedrijven moeten \nrestwarmte zelf terugwinnen in hun eigen \nbedrijfsprocessen dan valt het onder energie-\nbesparen. In uitzonderlijke gevallen waar dit \nniet mogelijk is kan een warmtenet toch uit-\nkomst bieden.\n",
        _t_infoButtonText_Font, ALIGNMENT_LEFT );
    text = new ShapeText(
        SHAPE_DRAW_2D, true,640.0, 705.0, 0.0, 0.0,
        black,"text",
        _text_Font, ALIGNMENT_LEFT );
    rect_warningScreenGespreksleidraadBedrijven = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-230.0, -270.0, 0.0, 0.0,
            lavender, lavender,
			460.0, 600.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
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
    txt_displayedDataOf = new ShapeText(
        SHAPE_DRAW_2D, true,340.0, 90.0, 0.0, 0.0,
        black,"Data van:",
        _txt_displayedDataOf_Font, ALIGNMENT_CENTER );
    t_selectedObjectDisplayTextGSLD = new ShapeText(
        SHAPE_DRAW_2D, true,340.0, 110.0, 0.0, 0.0,
        black,"Een selectie van aansluitingen",
        _t_selectedObjectDisplayTextGSLD_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_selectedObjectDisplayTextGSLD_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartGespreksleidraad1 = new StackChart(
ChartGespreksLeidraad.this, true, -230.0, -100.0,
			142.133, 225.007,
            null, null,
            50.0, 30.0,
			62.13300000000004, 181.007, null, black, black,
            36.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_consumptionChartGespreksleidraad1 = new StackChart(
ChartGespreksLeidraad.this, true, -5.0, -100.0,
			140.0, 224.0,
            null, null,
            50.0, 30.0,
			60.0, 180.0, null, black, black,
            36.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    sc_windSupplyStack = new StackChart(
ChartGespreksLeidraad.this, true, -190.0, 40.0,
			200.0, 190.0,
            null, null,
            45.0, 30.0,
			130.0, 120.0, white, black, black,
            40.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.5,
            Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    sc_PVSupplyStack = new StackChart(
ChartGespreksLeidraad.this, true, -45.0, 40.0,
			200.0, 190.0,
            null, null,
            30.0, 30.0,
			130.0, 120.0, white, black, black,
            40.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.5,
            Chart.GRID_DEFAULT,
            black, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    sc_electricityDemandStack = new StackChart(
ChartGespreksLeidraad.this, true, -230.0, -270.0,
			200.0, 210.0,
            null, null,
            50.0, 10.0,
			100.0, 140.0, white, black, black,
            70.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.5,
            Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    sc_heatDemandStack = new StackChart(
ChartGespreksLeidraad.this, true, -130.0, -270.0,
			200.0, 210.0,
            null, null,
            50.0, 10.0,
			100.0, 140.0, white, black, black,
            70.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.5,
            Chart.GRID_DEFAULT,
            black, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    sc_transportDemandStack = new StackChart(
ChartGespreksLeidraad.this, true, -30.0, -270.0,
			200.0, 210.0,
            null, null,
            50.0, 10.0,
			100.0, 140.0, white, black, black,
            70.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.5,
            Chart.GRID_DEFAULT,
            black, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartIndividual = new StackChart(
ChartGespreksLeidraad.this, true, -190.0, -50.0,
			142.133, 195.007,
            null, null,
            50.0, 30.0,
			62.13300000000004, 151.007, null, black, black,
            36.0, Chart.NONE,
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
ChartGespreksLeidraad.this, true, 20.0, -50.0,
			140.0, 194.0,
            null, null,
            50.0, 30.0,
			60.0, 150.0, null, black, black,
            36.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_selfSufficiencyChartIndividual1 = new StackChart(
ChartGespreksLeidraad.this, true, -200.0, -50.0,
			142.133, 195.007,
            null, null,
            50.0, 30.0,
			62.13300000000004, 151.007, null, black, black,
            36.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_selfSufficiencyChartCollective1 = new StackChart(
ChartGespreksLeidraad.this, true, 25.0, -50.0,
			140.0, 194.0,
            null, null,
            50.0, 30.0,
			60.0, 150.0, null, black, black,
            36.0, Chart.NONE,
            Chart.NORTH, Chart.SCALE_AUTO,
0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    energySupplyChartYearGespreksleidraad5 = new TimeStackChart(
ChartGespreksLeidraad.this, true, -220.0, -80.0,
			460.0, 210.0,
            null, null,
            50.0, 30.0,
			380.0, 120.0, white, null, black,
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
    energyDemandChartYearGespreksleidraad5 = new TimePlot(
ChartGespreksLeidraad.this, true, -230.0, -80.0,
			460.0, 260.0,
            null, null,
            60.0, 30.0,
			380.0, 120.0, null, null, black,
            40.0, Chart.SOUTH,

365 
             * day(), Chart.WINDOW_MOVES_WITH_TIME, null, Chart.SCALE_AUTO,
0, 0, Chart.GRID_NONE, Chart.GRID_NONE,
            null, null, _items, _titles, _appearances );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_jaar = new Plot(
ChartGespreksLeidraad.this, true, -200.0, -30.0,
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
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_dagnacht = new Plot(
ChartGespreksLeidraad.this, true, -210.0, -130.0,
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
    plot_seizoen = new Plot(
ChartGespreksLeidraad.this, true, -210.0, -300.0,
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
    plot_week = new Plot(
ChartGespreksLeidraad.this, true, -210.0, 50.0,
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
    List<DataItem> _items = new ArrayList<>( 2 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pl_consumptionChart3v2_pieLegenda_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pl_consumptionChart3v2_pieLegenda_DataItem1Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 2 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    List<Color> _colors = new ArrayList<>( 2 );
    _colors.add( coral );
    _colors.add( limeGreen );
    pl_consumptionChart3v2_pieLegenda = new PieChart(
ChartGespreksLeidraad.this, true, -20.0, -50.0,
			200.0, 240.0,
            null, null,
            0.0, 0.0,
			200.0, 200.0, null, black,
            40.0, Chart.SOUTH,
            _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 2 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pl_productionChart3v2_pieLegenda_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pl_productionChart3v2_pieLegenda_DataItem1Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 2 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    List<Color> _colors = new ArrayList<>( 2 );
    _colors.add( darkMagenta );
    _colors.add( orange );
    pl_productionChart3v2_pieLegenda = new PieChart(
ChartGespreksLeidraad.this, true, -250.0, -50.0,
			200.0, 240.0,
            null, null,
            0.0, 0.0,
			200.0, 200.0, null, black,
            40.0, Chart.SOUTH,
            _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 2 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pl_productionChart3v2_pie_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pl_productionChart3v2_pie_DataItem1Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 2 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    List<Color> _colors = new ArrayList<>( 2 );
    _colors.add( darkMagenta );
    _colors.add( orange );
    pl_productionChart3v2_pie = new PieChart(
ChartGespreksLeidraad.this, true, -250.0, -50.0,
			200.0, 200.0,
            null, null,
            0.0, 0.0,
			200.0, 200.0, null, black,
            40.0, Chart.NONE,
            _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 2 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pl_consumptionChart3v2_pie_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pl_consumptionChart3v2_pie_DataItem1Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 2 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    List<Color> _colors = new ArrayList<>( 2 );
    _colors.add( coral );
    _colors.add( limeGreen );
    pl_consumptionChart3v2_pie = new PieChart(
ChartGespreksLeidraad.this, true, -20.0, -50.0,
			200.0, 200.0,
            null, null,
            0.0, 0.0,
			200.0, 200.0, null, black,
            40.0, Chart.NONE,
            _items, _titles, _colors );
    }
    {
    gr_onbalansBarplot4 = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 120.0, -120.0, 0.0, 0.0
	
	     , t_opwekTextGespreksleidraad1
	     , t_gebruikTextGespreksleidraad1
	     , tx_topBarplotText4 );
    }
    {
    gr_gespreksleidraad1 = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 260.0, 450.0, 0.0, 0.0
	
	     , rect_GSL1
	     , tx_topBarplotText3
	     , gr_onbalansBarplot4
	     , pl_productionChartGespreksleidraad1
	     , pl_consumptionChartGespreksleidraad1
	     , oval26
	     , t_gespreksleidraadLegend9
	     , oval27
	     , t_gespreksleidraadLegend10
	     , oval28
	     , t_gespreksleidraadLegend11
	     , oval29
	     , t_gespreksleidraadLegend12
	     , t_gespreksleidraadLegend13
	     , oval30
	     , t_gespreksleidraadLegend14
	     , oval31
	     , oval32
	     , t_gespreksleidraadLegend15
	     , t_exportPerNeighborhood5
	     , t_exportPerNeighborhood6
	     , i_gespreksleidraad1 );
    }
    gr_gespreksleidraad1.setVisible( false );
    {
    gr_gespreksleidraad2 = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 750.0, 460.0, 0.0, 0.0
	
	     , rect_GSL2
	     , tx_topBarplotText8
	     , sc_windSupplyStack
	     , txt_GSLD2_wind
	     , txt_gsld2_solar
	     , tx_topBarplotText9
	     , text4
	     , text5
	     , text6
	     , sc_PVSupplyStack
	     , sc_electricityDemandStack
	     , sc_heatDemandStack
	     , sc_transportDemandStack
	     , rectangle13
	     , text2
	     , rectangle1
	     , text7
	     , text8
	     , text9
	     , rectangle2
	     , rectangle3
	     , text10
	     , rectangle4
	     , text11
	     , rectangle5
	     , text12
	     , rectangle6
	     , rectangle7
	     , text13
	     , rectangle8
	     , text16
	     , rectangle9
	     , text17
	     , t_energyDemand_ylabel2
	     , t_energyDemand_ylabel3
	     , rectangle14
	     , text24
	     , rectangle15
	     , text25
	     , i_gespreksleidraad2
	     , rectangle18
	     , text26 );
    }
    gr_gespreksleidraad2.setVisible( false );
    {
    gr_opwekZelfgebruik = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, -30.0, -20.0, 0.0, 0.0
	
	     , tx_topBarplotText7
	     , pl_productionChartIndividual
	     , pl_productionChartCollective
	     , oval18
	     , t_selfConsumptionPerNeighborhood2
	     , oval19
	     , t_exportPerNeighborhood1
	     , oval20
	     , t_selfConsumptionPerRegion2
	     , oval21
	     , t_exportPerRegion1
	     , text1125
	     , text1124 );
    }
    {
    gr_gebruikEigenOpwek = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, -30.0, 550.0, 0.0, 0.0
	
	     , tx_topBarplotText28
	     , pl_selfSufficiencyChartIndividual1
	     , pl_selfSufficiencyChartCollective1
	     , oval22
	     , t_selfConsumptionPerNeighborhood3
	     , oval23
	     , t_importPerNeighborhood1
	     , oval24
	     , t_selfConsumptionPerRegion3
	     , oval25
	     , t_importPerRegion1
	     , text1131
	     , text1132 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_gebruikEigenOpwek_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_gebruikEigenOpwek.setVisible( false );
    {
    gr_gespreksleidraad3 = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 1240.0, 450.0, 0.0, 0.0
	
	     , gr_opwekZelfgebruik
	     , gr_gebruikEigenOpwek
	     , rb_gespreksleidraad3
	     , i_gespreksleidraad3
	     , rect_GSL3 );
    }
    gr_gespreksleidraad3.setVisible( false );
    {
    gr_gespreksleidraad5 = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 2190.0, 420.0, 0.0, 0.0
	
	     , tx_topBarplotText13
	     , energySupplyChartYearGespreksleidraad5
	     , t_duurkromme_xlabel3
	     , tx_gespreksleidraad5
	     , rb_gespreksleidraad5
	     , i_gespreksleidraad5
	     , rect_GSL5
	     , energyDemandChartYearGespreksleidraad5
	     , t_duurkromme_ylabel2 );
    }
    {
    gr_gespreksleidraad6 = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 2690.0, 400.0, 0.0, 0.0
	
	     , rect_GSL6
	     , tx_topBarplotText38
	     , tx_topBarplotText39
	     , tx_topBarplotText40
	     , tx_topBarplotText41
	     , tx_topBarplotText42
	     , tx_topBarplotText43
	     , tx_topBarplotText44
	     , tx_topBarplotText45
	     , tx_topBarplotText46
	     , tx_topBarplotText47
	     , line19
	     , tx_topBarplotText48
	     , line20
	     , line21
	     , line22
	     , tx_numberOfPeaksDemand
	     , tx_averageTimePeakDemand
	     , tx_averageEnergyPeakDemand
	     , tx_maxTimePeakDemand
	     , tx_maxEnergyPeakDemand
	     , tx_averagePowerPeakDemand
	     , tx_maxPowerPeakDemand
	     , tx_maxEnergyPeakSupply
	     , tx_averageTimePeakSupply
	     , tx_numberOfPeaksSupply
	     , tx_maxTimePeakSupply
	     , tx_averageEnergyPeakSupply
	     , tx_maxPowerPeakSupply
	     , tx_averagePowerPeakSupply
	     , text22
	     , text23 );
    }
    {
    group_jaar = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, -10.0, 90.0, 0.0, 0.0
	 );
    }
    {
    gr_gespreksleidraad4_A = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , tx_topBarplotText11
	     , group_jaar
	     , ovalNetbelasting4
	     , ovalNetbelasting3
	     , tx_topBarplotText2
	     , plot_jaar
	     , t_duurkromme_xlabel
	     , t_duurkromme_ylabel
	     , tx_topBarplotText52
	     , tx_maxDemand
	     , tx_maxSupply
	     , tx_topBarplotText55
	     , ovalNetbelasting1
	     , t_KPIBenuttingsgraad
	     , text1123
	     , text593 );
    }
    {
    gr_gespreksleidraad4_B = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 0.0, 800.0, 0.0, 0.0
	
	     , t_duurkromme_ylabel6
	     , t_duurkromme_xlabel1
	     , t_duurkromme_ylabel7
	     , tx_topBarplotText5
	     , t_duurkromme_ylabel1
	     , t_duurkromme_xlabel5
	     , plot_dagnacht
	     , tx_topBarplotText6
	     , plot_seizoen
	     , tx_topBarplotText14
	     , t_duurkromme_xlabel2
	     , plot_week ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_gespreksleidraad4_B_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_gespreksleidraad4_B.setVisible( false );
    {
    gr_gespreksleidraad4 = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 1700.0, 320.0, 0.0, 0.0
	
	     , rect_rb
	     , rb_gespreksleidraad4
	     , rect_GSL4
	     , gr_gespreksleidraad4_A
	     , gr_gespreksleidraad4_B );
    }
    {
    gr_oldNetbelastingInfo = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, false, 1720.0, 1640.0, 0.0, 0.0
	
	     , t_KPIselfsufficiency_pct4
	     , ovalZelfvoorzienendheid3
	     , tx_topBarplotText17
	     , ovalZelfvoorzienendheid5
	     , tx_topBarplotText26
	     , line1
	     , tx_topBarplotText19
	     , ovalZelfvoorzienendheid4
	     , tx_topBarplotText12
	     , tx_topBarplotText25
	     , line6
	     , tx_topBarplotText21
	     , tx_topBarplotText15
	     , tx_topBarplotText18
	     , tx_topBarplotText24
	     , t_KPIselfsufficiency_pct3
	     , line4
	     , line3
	     , line5
	     , t_KPIselfsufficiency_pct5
	     , line2
	     , line
	     , tx_topBarplotText20 );
    }
    {
    gr_closeWindow = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 180.0, -130.0, 0.0, 0.0
	
	     , oval
	     , line15
	     , line16 ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_closeWindow, 0, clickx, clicky );
      }
    };
    }
    {
    gr_netcapaciteitInDeTwin = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 1560.0, 2470.0, 0.0, 0.0
	
	     , rectangle16
	     , tx_topBarplotText37
	     , gr_closeWindow
	     , text21 );
    }
    gr_netcapaciteitInDeTwin.setVisible( false );
    {
    gr_gespreksleidraad3v2 = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 3220.0, 450.0, 0.0, 0.0
	
	     , i_gespreksleidraad3v2
	     , rect_GSL3v2
	     , t_totalConsumptionYear
	     , t_totalProductionYear
	     , txt_gebruikEigenElecOpwekBuurt3v2
	     , tx_topBarplotTexttxt_gebruikEigenElecOpwekBuurt3v2
	     , txt_gebruikEigenElecGebruikRegio3v2
	     , pl_consumptionChart3v2_pieLegenda
	     , pl_productionChart3v2_pieLegenda
	     , rect_legendaPieChartBlock
	     , pl_productionChart3v2_pie
	     , pl_consumptionChart3v2_pie
	     , rect_hoverBlockingPieChart );
    }
    gr_gespreksleidraad3v2.setVisible( false );
    {
    gr_closeWindow5 = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 175.0, -195.0, 0.0, 0.0
	
	     , oval17
	     , line23
	     , line24 ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_closeWindow5, 0, clickx, clicky );
      }
    };
    }
    {
    gr_infoButtonText = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 4400.0, 460.0, 0.0, 0.0
	
	     , rectangle17
	     , gr_closeWindow5
	     , t_scenarioName1
	     , t_infoButtonText );
    }
    gr_infoButtonText.setVisible( false );
    {
    gr_warningScreen = new ShapeGroup( ChartGespreksLeidraad.this, SHAPE_DRAW_2D3D, true, 3700.0, 420.0, 0.0, 0.0
	
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
    _createPersistentElementsBP1_xjal();
    _createPersistentElementsBP2_xjal();
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
  public ChartGespreksLeidraad( Engine engine, Agent owner, AgentList<? extends ChartGespreksLeidraad> ownerPopulation ) {
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
  public ChartGespreksLeidraad() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartGespreksLeidraad_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartGespreksLeidraad.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartGespreksLeidraad.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    rb_gespreksleidraad4.setValueToDefault();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _energyDemandChartYearGespreksleidraad5_autoUpdateEvent_xjal.start();
    _pl_consumptionChart3v2_pieLegenda_autoUpdateEvent_xjal.start();
    _pl_productionChart3v2_pieLegenda_autoUpdateEvent_xjal.start();
    _pl_productionChart3v2_pie_autoUpdateEvent_xjal.start();
    _pl_consumptionChart3v2_pie_autoUpdateEvent_xjal.start();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

f_setGespreksleidraadGraphsLocation(gr_gespreksleidraad1.getX(), gr_gespreksleidraad1.getY(), false); 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartGespreksLeidraad_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartGespreksLeidraad_xjal() {
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
    v_selfConsumedElectricityColor_individual = 
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
    v_ElektrischeWPColor = 
lightBlue 
;
    v_HybrideWPColor = 
yellowGreen 
;
    v_MTDistrictHeatingColor = 
sandyBrown 
;
    v_LTDistrictHeatingColor = 
peachPuff 
;
    v_GreenGasBoilerColor = 
oliveDrab 
;
    v_uitgeslotenColor = 
whiteSmoke 
;
    v_energieLabelAColor = 
darkGreen 
;
    v_energieLabelBColor = 
green 
;
    v_energieLabelCColor = 
yellowGreen 
;
    v_energieLabelDColor = 
gold 
;
    v_energieLabelEColor = 
orange 
;
    v_energieLabelFColor = 
orangeRed 
;
    v_energieLabelOnbekendColor = 
peru 
;
    v_energieLabelGColor = 
red 
;
    v_highlightParticipantsColor = 
greenYellow 
;
    v_heatPumpHeatSupplyColor = 
orange 
;
    v_potentialColor = 
darkKhaki 
;
    v_curtailedColor = 
coral 
;
    v_selfConsumedElectricityColor_collective = 
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

  public AgentList<? extends ChartGespreksLeidraad> getPopulation() {
    return (AgentList<? extends ChartGespreksLeidraad>) super.getPopulation();
  }

  public List<? extends ChartGespreksLeidraad> agentsInRange( double distance ) {
    return (List<? extends ChartGespreksLeidraad>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _energyDemandChartYearGespreksleidraad5_autoUpdateEvent_xjal ) return false;
    if ( _e == _pl_consumptionChart3v2_pieLegenda_autoUpdateEvent_xjal ) return false;
    if ( _e == _pl_productionChart3v2_pieLegenda_autoUpdateEvent_xjal ) return false;
    if ( _e == _pl_productionChart3v2_pie_autoUpdateEvent_xjal ) return false;
    if ( _e == _pl_consumptionChart3v2_pie_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _energyDemandChartYearGespreksleidraad5_autoUpdateEvent_xjal.onDestroy();
    _pl_consumptionChart3v2_pieLegenda_autoUpdateEvent_xjal.onDestroy();
    _pl_productionChart3v2_pieLegenda_autoUpdateEvent_xjal.onDestroy();
    _pl_productionChart3v2_pie_autoUpdateEvent_xjal.onDestroy();
    _pl_consumptionChart3v2_pie_autoUpdateEvent_xjal.onDestroy();
  	for (int _pIdx = 0; _pIdx < energySupplyChartYearGespreksleidraad5.getCount(); _pIdx++) {
  		DataSet _ds = energySupplyChartYearGespreksleidraad5.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = energySupplyChartYearGespreksleidraad5.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "energySupplyChartYearGespreksleidraad5 : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < energyDemandChartYearGespreksleidraad5.getCount(); _pIdx++) {
  		DataSet _ds = energyDemandChartYearGespreksleidraad5.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = energyDemandChartYearGespreksleidraad5.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "energyDemandChartYearGespreksleidraad5 : " + _t );
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
  	for (int _pIdx = 0; _pIdx < plot_dagnacht.getCount(); _pIdx++) {
  		DataSet _ds = plot_dagnacht.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_dagnacht.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_dagnacht : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < plot_seizoen.getCount(); _pIdx++) {
  		DataSet _ds = plot_seizoen.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_seizoen.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_seizoen : " + _t );
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
    super.onDestroy();
  }


}
