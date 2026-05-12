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

public class ChartKPISummary extends digital_twin_results.ChartArea
{
  // Parameters
  // Plain Variables

  public 
double 
 v_sameColor;
  public 
Color 
 v_badColor;
  public 
Color 
 v_goodColor;
  public 
Color 
 v_backgroundColor_override;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartKPISummary.class );

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

  public void f_setKPISummaryChart(  ) { 

I_EnergyData data = uI_Results.f_getSelectedObjectData();

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 60, true);

//At least for now grid nodes are not supported
if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE){
	return;
}


//Reset chart
f_resetChart();

//Set KPIs
f_setKPIs(data);

//Set visible
uI_Results.chartKPISummary_presentation.setVisible(true);
 
  }

  void f_setKPIs( I_EnergyData data ) { 

double simulationLength_hr =  uI_Results.energyModel.p_timeParameters.getRunEndTime_h() - uI_Results.energyModel.p_timeParameters.getRunStartTime_h();

////Calculate the values

//Calculate and set new values
double totalEnergyConsumption_MWh = data.getRapidRunData().getTotalEnergyConsumed_MWh();
double totalImport_MWh = data.getRapidRunData().getTotalEnergyImport_MWh();
double totalExport_MWh = data.getRapidRunData().getTotalEnergyExport_MWh();
	
double elecConsumption_pct = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.ELECTRICITY) ? data.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getIntegral_MWh() / totalEnergyConsumption_MWh * 100 : 0;
double gasConsumption_pct = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.METHANE) ? data.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.METHANE).getIntegral_MWh() / totalEnergyConsumption_MWh * 100 : 0;
double FFconsumption_pct = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.PETROLEUM_FUEL) ? data.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.PETROLEUM_FUEL).getIntegral_MWh() / totalEnergyConsumption_MWh * 100 : 0;
double h2consumption_pct = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.HYDROGEN) ? data.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.HYDROGEN).getIntegral_MWh() / totalEnergyConsumption_MWh * 100 : 0;
double production_MWh = data.getRapidRunData().getTotalEnergyProduced_MWh();

double KPIselfsufficiency_pct = data.getRapidRunData().getTotalEnergySelfConsumed_MWh() / totalEnergyConsumption_MWh * 100;

//Total overload hours as a Pct of total simulation hours 
double KPIOverloadHours_pct = (data.getRapidRunData().getTotalOverloadDurationDelivery_hr() + data.getRapidRunData().getTotalOverloadDurationFeedin_hr())/simulationLength_hr * 100;



//Set new values text
DecimalFormat df = new DecimalFormat("0.0");

if(roundToInt(totalEnergyConsumption_MWh) >= 1000){
	t_totalconsumption_MWh.setText(df.format(totalEnergyConsumption_MWh/1000));
	t_totalImport_MWh.setText(df.format(totalImport_MWh/1000));
	t_totalExport_MWh.setText(df.format(totalExport_MWh/1000));
	t_totals.setText("Jaar totalen energie (GWh)");
}
else{
	t_totalconsumption_MWh.setText(df.format(totalEnergyConsumption_MWh));
	t_totalImport_MWh.setText(df.format(totalImport_MWh));
	t_totalExport_MWh.setText(df.format(totalExport_MWh));
	t_totals.setText("Jaar totalen energie (MWh)");
}

t_elecConsumption_pct.setText(df.format(elecConsumption_pct) + " %");
t_gasconsumption_pct.setText(df.format(gasConsumption_pct) + " %");
t_FFconsumption_pct.setText(df.format(FFconsumption_pct) + " %");
t_h2consumption_pct.setText(df.format(h2consumption_pct) + " %");

//Convert to GWh when over 1000 MWh
if(roundToInt(production_MWh) >= 1000){
	t_production_pct.setText(df.format(production_MWh/1000) + " GWh");
}
else{
	t_production_pct.setText(df.format(production_MWh) + " MWh");
}

t_KPIselfsufficiency_pct.setText(df.format(KPIselfsufficiency_pct) + " %");
t_KPIOverloadHours_pct.setText(df.format(KPIOverloadHours_pct) + " %");


//Calculate and set previous values (if they exist) + arrows and styling
if(data.getPreviousRapidRunData() != null && data.getPreviousRapidRunData().getTotalEnergyConsumed_MWh() > 0){

	double previousTotalEnergyConsumption_MWh = data.getPreviousRapidRunData().getTotalEnergyConsumed_MWh();
	double previousTotalImport_MWh = data.getPreviousRapidRunData().getTotalEnergyImport_MWh();
	double previousTotalExport_MWh = data.getPreviousRapidRunData().getTotalEnergyExport_MWh();
	
	
	double previousElectricityConsumption_pct = data.getPreviousRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.ELECTRICITY) ? data.getPreviousRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getIntegral_MWh() / previousTotalEnergyConsumption_MWh * 100 : 0;
	double previousGasConsumption_pct = data.getPreviousRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.METHANE) ? data.getPreviousRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.METHANE).getIntegral_MWh() / previousTotalEnergyConsumption_MWh * 100 : 0;
	double previousFFConsumption_pct = data.getPreviousRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.PETROLEUM_FUEL) ? data.getPreviousRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.PETROLEUM_FUEL).getIntegral_MWh() / previousTotalEnergyConsumption_MWh * 100 : 0;
	double previousH2Consumption_pct = data.getPreviousRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.HYDROGEN) ? data.getPreviousRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.HYDROGEN).getIntegral_MWh() / previousTotalEnergyConsumption_MWh * 100 : 0; 
	double previousProduction_MWh = data.getPreviousRapidRunData().getTotalEnergyProduced_MWh();  
	
	double previousKPIselfsufficiency_pct = data.getPreviousRapidRunData().getTotalEnergySelfConsumed_MWh() / previousTotalEnergyConsumption_MWh * 100; 
	
	//Overload of GC for GC and overload of all gridnodes combined for Region (GN is not supported and shows same KPIs as whole region)
	double previousKPIOverloadHours_pct = (data.getPreviousRapidRunData().getTotalOverloadDurationDelivery_hr() + data.getPreviousRapidRunData().getTotalOverloadDurationFeedin_hr())/ simulationLength_hr * 100;
	
	//Set previous values text (convert to same unit as totalEnergyConsumption text, so same if statement)
	if(roundToInt(totalEnergyConsumption_MWh) >= 1000){
		t_previousTotalconsumption_MWh.setText(df.format(previousTotalEnergyConsumption_MWh/1000));
		t_previousTotalImport_MWh.setText(df.format(previousTotalImport_MWh/1000));
		t_previousTotalExport_MWh.setText(df.format(previousTotalExport_MWh/1000));
	}
	else{
		t_previousTotalconsumption_MWh.setText(df.format(previousTotalEnergyConsumption_MWh));
		t_previousTotalImport_MWh.setText(df.format(previousTotalImport_MWh));
		t_previousTotalExport_MWh.setText(df.format(previousTotalExport_MWh));
	}

	t_previousElectricityConsumption_pct.setText(df.format(previousElectricityConsumption_pct) + " %");
	t_previousGasConsumption_pct.setText(df.format(previousGasConsumption_pct) + " %");
	t_previousFFConsumption_pct.setText(df.format(previousFFConsumption_pct) + " %");
	t_previousH2Consumption_pct.setText(df.format(previousH2Consumption_pct) + " %");
	
	//Convert to GWh when over 1000
	if(roundToInt(previousProduction_MWh) >= 1000){
		t_previousProduction_pct.setText(df.format(previousProduction_MWh/1000) + " GWh");
	}
	else{
		t_previousProduction_pct.setText(df.format(previousProduction_MWh) + " MWh");
	}

	t_previousKPIselfsufficiency_pct.setText(df.format(previousKPIselfsufficiency_pct) + " %");
	t_previousKPIOverloadHours_pct.setText(df.format(previousKPIOverloadHours_pct) + " %");
	
	////Set correct arrow and colors
	//Total consumption
	if(t_totalconsumption_MWh.getText().equals(t_previousTotalconsumption_MWh.getText())){
		line_total.setVisible(true);
	} else if(totalEnergyConsumption_MWh > previousTotalEnergyConsumption_MWh){
		arrow_up_red_totalconsumption.setVisible(true);
	} else if(totalEnergyConsumption_MWh < previousTotalEnergyConsumption_MWh){
		arrow_down_green_totalconsumption.setVisible(true);
	}
	
	//Import
	if(t_totalImport_MWh.getText().equals(t_previousTotalImport_MWh.getText())){
		line_import.setVisible(true);
	} else if(totalImport_MWh > previousTotalImport_MWh){
		arrow_up_red_import.setVisible(true);
	} else if(totalImport_MWh < previousTotalImport_MWh){
		arrow_down_green_import.setVisible(true);
	}
	
	//Export
	if(t_totalExport_MWh.getText().equals(t_previousTotalExport_MWh.getText())){
		line_export.setVisible(true);
	} else if(totalExport_MWh > previousTotalExport_MWh){
		arrow_up_red_export.setVisible(true);
	} else if(totalExport_MWh < previousTotalExport_MWh){
		arrow_down_green_export.setVisible(true);
	}
	
	//Electricity
	if(t_elecConsumption_pct.getText().equals(t_previousElectricityConsumption_pct.getText())){
		line_electricity.setVisible(true);
	} else if(elecConsumption_pct > previousElectricityConsumption_pct){
		arrow_up_green_electricity.setVisible(true);
	} else if(elecConsumption_pct < previousElectricityConsumption_pct){
		arrow_down_red_electricity.setVisible(true);
	}
	
	//Gas
	if(t_gasconsumption_pct.getText().equals(t_previousGasConsumption_pct.getText())){
		line_gas.setVisible(true);
	} else if(gasConsumption_pct > previousGasConsumption_pct){
		arrow_up_red_gas.setVisible(true);
	} else if(gasConsumption_pct < previousGasConsumption_pct){
		arrow_down_green_gas.setVisible(true);
	}
	
	//FF
	if(t_FFconsumption_pct.getText().equals(t_previousFFConsumption_pct.getText())){
		line_FF.setVisible(true);
	} else if(FFconsumption_pct > previousFFConsumption_pct){
		arrow_up_red_FF.setVisible(true);
	} else if(FFconsumption_pct < previousFFConsumption_pct){
		arrow_down_green_FF.setVisible(true);
	}
	
	//H2
	if(t_h2consumption_pct.getText().equals(t_previousH2Consumption_pct.getText())){
		line_h2.setVisible(true);
	} else if(h2consumption_pct > previousH2Consumption_pct){
		arrow_up_green_h2.setVisible(true);
	} else if(h2consumption_pct < previousH2Consumption_pct){
		arrow_down_red_h2.setVisible(true);
	}
	
	//Production
	if(t_production_pct.getText().equals(t_previousProduction_pct.getText())){
		line_production.setVisible(true);
	} else if(production_MWh > previousProduction_MWh){
		arrow_up_green_production.setVisible(true);
	} else if(production_MWh < previousProduction_MWh){
		arrow_down_red_production.setVisible(true);
	}
	
	//Self sufficiency
	if(t_KPIselfsufficiency_pct.getText().equals(t_previousKPIselfsufficiency_pct.getText())){
		line_selfsufficiency.setVisible(true);
	} else if(KPIselfsufficiency_pct > previousKPIselfsufficiency_pct){
		arrow_up_green_selfsufficiency.setVisible(true);
	} else if(KPIselfsufficiency_pct < previousKPIselfsufficiency_pct){
		arrow_down_red_selfsufficiency.setVisible(true);
	}
	
	//Gridload
	if(t_KPIOverloadHours_pct.getText().equals(t_previousKPIOverloadHours_pct.getText())){
		line_gridload.setVisible(true);
	} else if(KPIOverloadHours_pct > previousKPIOverloadHours_pct){
		arrow_up_red_gridload.setVisible(true);
	} else if(KPIOverloadHours_pct < previousKPIOverloadHours_pct){
		arrow_down_green_gridload.setVisible(true);
	}
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

//Reset all previous text
t_previousTotalconsumption_MWh.setText("");
t_previousTotalImport_MWh.setText("");
t_previousTotalExport_MWh.setText("");

t_previousElectricityConsumption_pct.setText("");
t_previousGasConsumption_pct.setText("");
t_previousFFConsumption_pct.setText("");
t_previousH2Consumption_pct.setText("");
t_previousProduction_pct.setText("");

t_previousKPIselfsufficiency_pct.setText("");
t_previousKPIOverloadHours_pct.setText("");

//Reset all arrow visibility
arrow_down_green_totalconsumption.setVisible(false);
arrow_down_green_import.setVisible(false);
arrow_down_green_export.setVisible(false);
arrow_up_red_totalconsumption.setVisible(false);
arrow_up_red_export.setVisible(false);
arrow_up_red_import.setVisible(false);
line_total.setVisible(false);
line_import.setVisible(false);
line_export.setVisible(false);

arrow_down_red_electricity.setVisible(false);
arrow_down_green_gas.setVisible(false);
arrow_down_green_FF.setVisible(false);
arrow_down_red_h2.setVisible(false);
arrow_down_red_production.setVisible(false);
arrow_up_green_electricity.setVisible(false);
arrow_up_red_gas.setVisible(false);
arrow_up_red_FF.setVisible(false);
arrow_up_green_h2.setVisible(false);
arrow_up_green_production.setVisible(false);
line_electricity.setVisible(false);
line_gas.setVisible(false);
line_FF.setVisible(false);
line_h2.setVisible(false);
line_production.setVisible(false);

arrow_down_red_selfsufficiency.setVisible(false);
arrow_down_green_gridload.setVisible(false);
arrow_up_green_selfsufficiency.setVisible(false);
arrow_up_red_gridload.setVisible(false);
line_selfsufficiency.setVisible(false);
line_gridload.setVisible(false); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_KPISummary_Font = new Font("SansSerif", 1, 26 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totals_Font = new Font("Arial", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_h2consumtption2_Font = new Font("Calibri", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_h2consumption_pct_Font = new Font("SansSerif", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousH2Consumption_pct_Font = new Font("SansSerif", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_h2_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gasconsumption_pct_Font = _t_h2consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_gasconsumtption_Font = _txt_h2consumtption2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousGasConsumption_pct_Font = _t_previousH2Consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_elecConsumption_pct_Font = _t_h2consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_electricityconsumtption_Font = _txt_h2consumtption2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousElectricityConsumption_pct_Font = _t_previousH2Consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_FFconsumption_pct_Font = _t_h2consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_FFconsumtption_Font = _txt_h2consumtption2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousFFConsumption_pct_Font = _t_previousH2Consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_production_Font = _txt_h2consumtption2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_production_pct_Font = _t_h2consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousProduction_pct_Font = _t_previousH2Consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalSubGroups1_Font = new Font("Calibri", 0, 24 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalSubGroups2_Font = _txt_totalSubGroups1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalImport_MWh_Font = new Font("SansSerif", 0, 24 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalImport_MWh_Font = _t_previousH2Consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalconsumption_MWh_Font = _t_totalImport_MWh_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalconsumption_MWh_Font = _t_previousH2Consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalSubGroups_Font = _txt_totalSubGroups1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalExport_MWh_Font = _t_totalImport_MWh_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalExport_MWh_Font = _t_previousH2Consumption_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousKPIOverloadHours_pct_Font = new Font("Arial", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_gridload_Font = _t_totals_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_overload_Font = new Font("Arial", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_KPIOverloadHours_pct_Font = _t_totals_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousKPIselfsufficiency_pct_Font = _t_previousKPIOverloadHours_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_selfsufficiency_Font = _t_totals_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_selfsufficiencyPercentage_Font = _txt_overload_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_KPIselfsufficiency_pct_Font = _t_totals_Font;
  protected static final Color _ovalSelfsufficiency_Fill_Color = new Color( 0xFFACFBAC, true );
  protected static final Color _ovalSelfsufficiency_Line_Color = new Color( 0xFF71F471, true );
  protected static final Color _ovalGridload_Fill_Color = new Color( 0xFFFEDED5, true );
  protected static final Color _ovalGas_Fill_Color = new Color( 0xFFDFB08C, true );
  protected static final Color _ovalproduction_Fill_Color = new Color( 0xFFA5F752, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalSelfsufficiency = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalGridload = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_headerKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_KPISummary = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_exitKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_exitKPI1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_exitKPI2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_exitSummaryKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totals = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_h2consumtption2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_h2consumption_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousH2Consumption_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalH2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_h2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_H2image = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_red_h2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_green_h2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_h2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_h2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_h2KPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalGas = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _image10 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gasImage = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gasconsumption_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_gasconsumtption = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousGasConsumption_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_red_gas = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_green_gas = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_gas = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_gas = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_gasKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_elecConsumption_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalElectricity = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _image3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_electricityImage = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_electricityconsumtption = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousElectricityConsumption_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_red_electricity = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_green_electricity = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_electricity = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_electricity = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_electricityKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_FFconsumption_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_FFconsumtption = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousFFConsumption_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalFF = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_imageFF = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_FF = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_red_FF = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_green_FF = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_FF = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_FF = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_FFKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_production = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_production_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousProduction_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _ovalproduction = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_productionImage = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_red_production = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_green_production = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_production = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_production = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_productionKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_production = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_totalsSeperate = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_red_totalconsumption = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_green_totalconsumption = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_total = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_totalconsumption = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_red_import = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_green_import = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_import = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_import = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_red_export = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_green_export = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_export = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 76;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_export = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 77;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 78;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 79;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalSubGroups1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 80;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalSubGroups2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 81;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalImport_MWh = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 82;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalImport_MWh = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 83;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalconsumption_MWh = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 84;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalconsumption_MWh = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 85;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalSubGroups = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 86;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalExport_MWh = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 87;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalExport_MWh = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 88;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_red_gridload = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 89;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_green_gridload = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 90;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_gridload = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 91;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_gridload = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 92;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousKPIOverloadHours_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 93;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_gridload = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 94;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_overload = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 95;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_KPIOverloadHours_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 96;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_down_red_selfsufficiency = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 97;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrow_up_green_selfsufficiency = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 98;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_selfsufficiency = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 99;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrows_selfsufficiency = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 100;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousKPIselfsufficiency_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 101;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_selfsufficiency = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 102;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_selfsufficiencyPercentage = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 103;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_KPIselfsufficiency_pct = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 104;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 105;

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
	  level.addAll(ovalSelfsufficiency, ovalGridload, rect_headerKPI, txt_KPISummary, gr_exitSummaryKPI, t_totals, gr_totalsSeperate, arrows_totalconsumption, arrows_import, arrows_export, line, line1, txt_totalSubGroups1, txt_totalSubGroups2, t_totalImport_MWh, t_previousTotalImport_MWh, t_totalconsumption_MWh, t_previousTotalconsumption_MWh, txt_totalSubGroups, t_totalExport_MWh, t_previousTotalExport_MWh, arrows_gridload, t_previousKPIOverloadHours_pct, txt_gridload, txt_overload, t_KPIOverloadHours_pct, arrows_selfsufficiency, t_previousKPIselfsufficiency_pct, txt_selfsufficiency, txt_selfsufficiencyPercentage, t_KPIselfsufficiency_pct);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _gr_exitSummaryKPI:
        if (true) {
          ShapeGroup self = this.gr_exitSummaryKPI;
          
uI_Results.checkbox_KPISummary.setSelected(false, true); 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  protected ShapeOval ovalSelfsufficiency;
  protected ShapeOval ovalGridload;
  
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
  protected ShapeText txt_KPISummary;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_exitKPI_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineWidth(
v_lineWidth 
);
  }
  
  protected ShapeRectangle rect_exitKPI;
  protected ShapeLine line_exitKPI1;
  protected ShapeLine line_exitKPI2;
  protected ShapeGroup gr_exitSummaryKPI;
  protected ShapeText t_totals;
  protected ShapeText txt_h2consumtption2;
  protected ShapeText t_h2consumption_pct;
  protected ShapeText t_previousH2Consumption_pct;
  protected ShapeOval ovalH2;
  protected ShapeText txt_h2;
  protected ShapeGroup gr_H2image;
  protected ShapeImage arrow_down_red_h2;
  protected ShapeImage arrow_up_green_h2;
  protected ShapeLine line_h2;
  protected ShapeGroup arrows_h2;
  protected ShapeGroup gr_h2KPI;
  protected ShapeOval ovalGas;
  protected ShapeImage image10;
  protected ShapeGroup gr_gasImage;
  protected ShapeText t_gasconsumption_pct;
  protected ShapeText txt_gasconsumtption;
  protected ShapeText t_previousGasConsumption_pct;
  protected ShapeImage arrow_up_red_gas;
  protected ShapeImage arrow_down_green_gas;
  protected ShapeLine line_gas;
  protected ShapeGroup arrows_gas;
  protected ShapeGroup gr_gasKPI;
  protected ShapeText t_elecConsumption_pct;
  protected ShapeOval ovalElectricity;
  protected ShapeImage image3;
  protected ShapeGroup gr_electricityImage;
  protected ShapeText txt_electricityconsumtption;
  protected ShapeText t_previousElectricityConsumption_pct;
  protected ShapeImage arrow_down_red_electricity;
  protected ShapeImage arrow_up_green_electricity;
  protected ShapeLine line_electricity;
  protected ShapeGroup arrows_electricity;
  protected ShapeGroup gr_electricityKPI;
  protected ShapeText t_FFconsumption_pct;
  protected ShapeText txt_FFconsumtption;
  protected ShapeText t_previousFFConsumption_pct;
  protected ShapeOval ovalFF;
  protected ShapeGroup gr_imageFF;
  protected ShapeImage image_FF;
  protected ShapeImage arrow_up_red_FF;
  protected ShapeImage arrow_down_green_FF;
  protected ShapeLine line_FF;
  protected ShapeGroup arrows_FF;
  protected ShapeGroup gr_FFKPI;
  protected ShapeText txt_production;
  protected ShapeText t_production_pct;
  protected ShapeText t_previousProduction_pct;
  protected ShapeOval ovalproduction;
  protected ShapeGroup gr_productionImage;
  protected ShapeImage arrow_down_red_production;
  protected ShapeImage arrow_up_green_production;
  protected ShapeLine line_production;
  protected ShapeGroup arrows_production;
  protected ShapeGroup gr_productionKPI;
  protected ShapeImage image_production;
  protected ShapeGroup gr_totalsSeperate;
  protected ShapeImage arrow_up_red_totalconsumption;
  protected ShapeImage arrow_down_green_totalconsumption;
  protected ShapeLine line_total;
  protected ShapeGroup arrows_totalconsumption;
  protected ShapeImage arrow_up_red_import;
  protected ShapeImage arrow_down_green_import;
  protected ShapeLine line_import;
  protected ShapeGroup arrows_import;
  protected ShapeImage arrow_up_red_export;
  protected ShapeImage arrow_down_green_export;
  protected ShapeLine line_export;
  protected ShapeGroup arrows_export;
  protected ShapeLine line;
  protected ShapeLine line1;
  protected ShapeText txt_totalSubGroups1;
  protected ShapeText txt_totalSubGroups2;
  protected ShapeText t_totalImport_MWh;
  protected ShapeText t_previousTotalImport_MWh;
  protected ShapeText t_totalconsumption_MWh;
  protected ShapeText t_previousTotalconsumption_MWh;
  protected ShapeText txt_totalSubGroups;
  protected ShapeText t_totalExport_MWh;
  protected ShapeText t_previousTotalExport_MWh;
  protected ShapeImage arrow_up_red_gridload;
  protected ShapeImage arrow_down_green_gridload;
  protected ShapeLine line_gridload;
  protected ShapeGroup arrows_gridload;
  protected ShapeText t_previousKPIOverloadHours_pct;
  protected ShapeText txt_gridload;
  protected ShapeText txt_overload;
  protected ShapeText t_KPIOverloadHours_pct;
  protected ShapeImage arrow_down_red_selfsufficiency;
  protected ShapeImage arrow_up_green_selfsufficiency;
  protected ShapeLine line_selfsufficiency;
  protected ShapeGroup arrows_selfsufficiency;
  protected ShapeText t_previousKPIselfsufficiency_pct;
  protected ShapeText txt_selfsufficiency;
  protected ShapeText txt_selfsufficiencyPercentage;
  protected ShapeText t_KPIselfsufficiency_pct;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    ovalSelfsufficiency = new ShapeOval(
       SHAPE_DRAW_2D3D, true,130.0, 650.0, 0.0, 0.0,
       _ovalSelfsufficiency_Line_Color, _ovalSelfsufficiency_Fill_Color,
	   45.0, 45.0, 10.0, 4.0, LINE_STYLE_SOLID );
    ovalGridload = new ShapeOval(
       SHAPE_DRAW_2D3D, true,346.0, 650.0, 0.0, 0.0,
       lightSalmon, _ovalGridload_Fill_Color,
	   45.0, 45.0, 10.0, 4.0, LINE_STYLE_SOLID );
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
    txt_KPISummary = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 10.0, 0.0, 0.0,
        black,"Samenvatting energiestromen",
        _txt_KPISummary_Font, ALIGNMENT_CENTER );
    rect_exitKPI = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-6.0, -13.0, 0.0, 0.0,
            darkGray, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_exitKPI_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    line_exitKPI1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -2.0, -9.0, 0.0, gray,
 		18.0,	17.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_exitKPI2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 15.0, -9.0, 0.0, gray,
 		-17.0,	17.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    t_totals = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 105.0, 0.0, 0.0,
        black,"Jaar totalen energie (MWh)",
        _t_totals_Font, ALIGNMENT_CENTER );
    txt_h2consumtption2 = new ShapeText(
        SHAPE_DRAW_2D, true,-155.0, -20.0, 0.0, 0.0,
        black,"Aandeel waterstof",
        _txt_h2consumtption2_Font, ALIGNMENT_LEFT );
    t_h2consumption_pct = new ShapeText(
        SHAPE_DRAW_2D, true,90.0, -25.0, 0.0, 0.0,
        black,"10.0 %",
        _t_h2consumption_pct_Font, ALIGNMENT_LEFT );
    t_previousH2Consumption_pct = new ShapeText(
        SHAPE_DRAW_2D, true,95.0, 0.0, 0.0, 0.0,
        black,"-",
        _t_previousH2Consumption_pct_Font, ALIGNMENT_LEFT );
    ovalH2 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-1.0, -1.0, 0.0, 0.0,
       whiteSmoke, skyBlue,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_h2 = new ShapeText(
        SHAPE_DRAW_2D, true,-9.0, -10.0, 0.0, 0.0,
        black,"H2",
        _txt_h2_Font, ALIGNMENT_LEFT );
    arrow_down_red_h2 = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_red.png",} );
    arrow_down_red_h2.setVisible( false );
    arrow_up_green_h2 = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_green.png",} );
    arrow_up_green_h2.setVisible( false );
    line_h2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_h2.setVisible( false );
    ovalGas = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       whiteSmoke, _ovalGas_Fill_Color,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    image10 = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -13.0, -12.0, 0.0, 0.0,
28.0, 24.0, "/digital_twin_results/",
			new String[]{"noun-fire-2429630.png",} );
    t_gasconsumption_pct = new ShapeText(
        SHAPE_DRAW_2D, true,90.0, -25.0, 0.0, 0.0,
        black,"10.0 %",
        _t_gasconsumption_pct_Font, ALIGNMENT_LEFT );
    txt_gasconsumtption = new ShapeText(
        SHAPE_DRAW_2D, true,-155.0, -20.0, 0.0, 0.0,
        black,"Aandeel gas:",
        _txt_gasconsumtption_Font, ALIGNMENT_LEFT );
    t_previousGasConsumption_pct = new ShapeText(
        SHAPE_DRAW_2D, true,95.0, 0.0, 0.0, 0.0,
        black,"-",
        _t_previousGasConsumption_pct_Font, ALIGNMENT_LEFT );
    arrow_up_red_gas = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_red.png",} );
    arrow_up_red_gas.setVisible( false );
    arrow_down_green_gas = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_green.png",} );
    arrow_down_green_gas.setVisible( false );
    line_gas = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_gas.setVisible( false );
    t_elecConsumption_pct = new ShapeText(
        SHAPE_DRAW_2D, true,90.0, -25.0, 0.0, 0.0,
        black,"10.0 %",
        _t_elecConsumption_pct_Font, ALIGNMENT_LEFT );
    ovalElectricity = new ShapeOval(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
       whiteSmoke, lemonChiffon,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    image3 = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -13.0, -11.0, 0.0, 0.0,
28.0, 24.0, "/digital_twin_results/",
			new String[]{"noun-electricity-3408805.png",} );
    txt_electricityconsumtption = new ShapeText(
        SHAPE_DRAW_2D, true,-155.0, -20.0, 0.0, 0.0,
        black,"Aandeel elektriciteit",
        _txt_electricityconsumtption_Font, ALIGNMENT_LEFT );
    t_previousElectricityConsumption_pct = new ShapeText(
        SHAPE_DRAW_2D, true,95.0, 0.0, 0.0, 0.0,
        black,"-",
        _t_previousElectricityConsumption_pct_Font, ALIGNMENT_LEFT );
    arrow_down_red_electricity = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_red.png",} );
    arrow_down_red_electricity.setVisible( false );
    arrow_up_green_electricity = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_green.png",} );
    arrow_up_green_electricity.setVisible( false );
    line_electricity = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_electricity.setVisible( false );
    t_FFconsumption_pct = new ShapeText(
        SHAPE_DRAW_2D, true,89.0, -25.0, 0.0, 0.0,
        black,"10.0 %",
        _t_FFconsumption_pct_Font, ALIGNMENT_LEFT );
    txt_FFconsumtption = new ShapeText(
        SHAPE_DRAW_2D, true,-156.0, -20.0, 0.0, 0.0,
        black,"Aandeel brandstof:",
        _txt_FFconsumtption_Font, ALIGNMENT_LEFT );
    t_previousFFConsumption_pct = new ShapeText(
        SHAPE_DRAW_2D, true,94.0, 0.0, 0.0, 0.0,
        black,"-",
        _t_previousFFConsumption_pct_Font, ALIGNMENT_LEFT );
    ovalFF = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-1.0, -1.0, 0.0, 0.0,
       whiteSmoke, gainsboro,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    image_FF = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -213.0, -26.0, 0.0, 0.0,
35.0, 29.0, "/digital_twin_results/",
			new String[]{"noun-fuel-removebg-preview.png",} );
    arrow_up_red_FF = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_red.png",} );
    arrow_up_red_FF.setVisible( false );
    arrow_down_green_FF = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_green.png",} );
    arrow_down_green_FF.setVisible( false );
    line_FF = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_FF.setVisible( false );
    txt_production = new ShapeText(
        SHAPE_DRAW_2D, true,-155.0, -20.0, 0.0, 0.0,
        black,"Totale opwek:",
        _txt_production_Font, ALIGNMENT_LEFT );
    t_production_pct = new ShapeText(
        SHAPE_DRAW_2D, true,90.0, -25.0, 0.0, 0.0,
        black,"100.1 MWh",
        _t_production_pct_Font, ALIGNMENT_LEFT );
    t_previousProduction_pct = new ShapeText(
        SHAPE_DRAW_2D, true,95.0, 0.0, 0.0, 0.0,
        black,"-",
        _t_previousProduction_pct_Font, ALIGNMENT_LEFT );
    ovalproduction = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-1.0, -1.0, 0.0, 0.0,
       whiteSmoke, _ovalproduction_Fill_Color,
	   20.0, 20.0, 10.0, 2.0, LINE_STYLE_SOLID );
    arrow_down_red_production = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_red.png",} );
    arrow_down_red_production.setVisible( false );
    arrow_up_green_production = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_green.png",} );
    arrow_up_green_production.setVisible( false );
    line_production = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_production.setVisible( false );
    image_production = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -110.0, 95.0, 0.0, 0.0,
30.0, 26.0, "/digital_twin_results/",
			new String[]{"noun-windmill.png",} );
    arrow_up_red_totalconsumption = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_red.png",} );
    arrow_up_red_totalconsumption.setVisible( false );
    arrow_down_green_totalconsumption = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_green.png",} );
    arrow_down_green_totalconsumption.setVisible( false );
    line_total = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_total.setVisible( false );
    arrow_up_red_import = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_red.png",} );
    arrow_up_red_import.setVisible( false );
    arrow_down_green_import = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_green.png",} );
    arrow_down_green_import.setVisible( false );
    line_import = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_import.setVisible( false );
    arrow_up_red_export = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_up_red.png",} );
    arrow_up_red_export.setVisible( false );
    arrow_down_green_export = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -12.0, -10.0, 0.0, 0.0,
23.0, 18.0, "/digital_twin_results/",
			new String[]{"icon_arrow_down_green.png",} );
    arrow_down_green_export.setVisible( false );
    line_export = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -11.0, -1.0, 0.0, silver,
 		21.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_export.setVisible( false );
    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 80.0, 230.0, 0.0, whiteSmoke,
 		300.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 100.0, 550.0, 0.0, whiteSmoke,
 		300.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    txt_totalSubGroups1 = new ShapeText(
        SHAPE_DRAW_2D, true,220.0, 150.0, 0.0, 0.0,
        black,"Import",
        _txt_totalSubGroups1_Font, ALIGNMENT_CENTER );
    txt_totalSubGroups2 = new ShapeText(
        SHAPE_DRAW_2D, true,370.0, 150.0, 0.0, 0.0,
        black,"Export",
        _txt_totalSubGroups2_Font, ALIGNMENT_CENTER );
    t_totalImport_MWh = new ShapeText(
        SHAPE_DRAW_2D, true,210.0, 170.0, 0.0, 0.0,
        black,"100.1",
        _t_totalImport_MWh_Font, ALIGNMENT_LEFT );
    t_previousTotalImport_MWh = new ShapeText(
        SHAPE_DRAW_2D, true,215.0, 195.0, 0.0, 0.0,
        black,"-",
        _t_previousTotalImport_MWh_Font, ALIGNMENT_LEFT );
    t_totalconsumption_MWh = new ShapeText(
        SHAPE_DRAW_2D, true,60.0, 170.0, 0.0, 0.0,
        black,"100.1",
        _t_totalconsumption_MWh_Font, ALIGNMENT_LEFT );
    t_previousTotalconsumption_MWh = new ShapeText(
        SHAPE_DRAW_2D, true,65.0, 195.0, 0.0, 0.0,
        black,"-",
        _t_previousTotalconsumption_MWh_Font, ALIGNMENT_LEFT );
    txt_totalSubGroups = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, 150.0, 0.0, 0.0,
        black,"Verbruik",
        _txt_totalSubGroups_Font, ALIGNMENT_CENTER );
    t_totalExport_MWh = new ShapeText(
        SHAPE_DRAW_2D, true,360.0, 170.0, 0.0, 0.0,
        black,"100.1",
        _t_totalExport_MWh_Font, ALIGNMENT_LEFT );
    t_previousTotalExport_MWh = new ShapeText(
        SHAPE_DRAW_2D, true,365.0, 195.0, 0.0, 0.0,
        black,"-",
        _t_previousTotalExport_MWh_Font, ALIGNMENT_LEFT );
    arrow_up_red_gridload = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -8.308, -6.842, 0.0, 0.0,
15.923, 12.316, "/digital_twin_results/",
			new String[]{"icon_arrow_up_red.png",} );
    arrow_up_red_gridload.setVisible( false );
    arrow_down_green_gridload = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -8.308, -6.842, 0.0, 0.0,
15.923, 12.316, "/digital_twin_results/",
			new String[]{"icon_arrow_down_green.png",} );
    arrow_down_green_gridload.setVisible( false );
    line_gridload = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -7.615, -0.684, 0.0, silver,
 		14.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_gridload.setVisible( false );
    t_previousKPIOverloadHours_pct = new ShapeText(
        SHAPE_DRAW_2D, true,345.0, 660.0, 0.0, 0.0,
        black,"-",
        _t_previousKPIOverloadHours_pct_Font, ALIGNMENT_LEFT );
    txt_gridload = new ShapeText(
        SHAPE_DRAW_2D, true,346.0, 570.0, 0.0, 0.0,
        black,"Overbelasting",
        _txt_gridload_Font, ALIGNMENT_CENTER );
    txt_overload = new ShapeText(
        SHAPE_DRAW_2D, true,346.0, 707.0, 0.0, 0.0,
        black,"Uren overbelasting",
        _txt_overload_Font, ALIGNMENT_CENTER );
    t_KPIOverloadHours_pct = new ShapeText(
        SHAPE_DRAW_2D, true,346.0, 637.0, 0.0, 0.0,
        black,"20.1%",
        _t_KPIOverloadHours_pct_Font, ALIGNMENT_CENTER );
    arrow_down_red_selfsufficiency = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -8.352, -6.908, 0.0, 0.0,
16.007, 12.435, "/digital_twin_results/",
			new String[]{"icon_arrow_down_red.png",} );
    arrow_down_red_selfsufficiency.setVisible( false );
    arrow_up_green_selfsufficiency = new ShapeImage(
		ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -8.352, -6.908, 0.0, 0.0,
16.007, 12.435, "/digital_twin_results/",
			new String[]{"icon_arrow_up_green.png",} );
    arrow_up_green_selfsufficiency.setVisible( false );
    line_selfsufficiency = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -7.656, -0.69, 0.0, silver,
 		14.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    line_selfsufficiency.setVisible( false );
    t_previousKPIselfsufficiency_pct = new ShapeText(
        SHAPE_DRAW_2D, true,125.0, 660.0, 0.0, 0.0,
        black,"-",
        _t_previousKPIselfsufficiency_pct_Font, ALIGNMENT_LEFT );
    txt_selfsufficiency = new ShapeText(
        SHAPE_DRAW_2D, true,130.0, 570.0, 0.0, 0.0,
        black,"Zelfvoorzienendheid",
        _txt_selfsufficiency_Font, ALIGNMENT_CENTER );
    txt_selfsufficiencyPercentage = new ShapeText(
        SHAPE_DRAW_2D, true,130.0, 707.0, 0.0, 0.0,
        black,"aandeel energieverbruik \nlokaal opgewekt",
        _txt_selfsufficiencyPercentage_Font, ALIGNMENT_CENTER );
    t_KPIselfsufficiency_pct = new ShapeText(
        SHAPE_DRAW_2D, true,130.0, 637.0, 0.0, 0.0,
        black,"20.1%",
        _t_KPIselfsufficiency_pct_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_exitSummaryKPI = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 441.0, 13.0, 0.0, 0.0
	
	     , rect_exitKPI
	     , line_exitKPI1
	     , line_exitKPI2 ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_exitSummaryKPI, 0, clickx, clicky );
      }
    };
    }
    {
    gr_H2image = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -194.0, -10.0, 0.0, 0.0
	
	     , ovalH2
	     , txt_h2 );
    }
    {
    arrows_h2 = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 71.0, -11.0, 0.0, 0.0
	
	     , arrow_down_red_h2
	     , arrow_up_green_h2
	     , line_h2 );
    }
    {
    gr_h2KPI = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 100.0, 60.0, 0.0, 0.0
	
	     , txt_h2consumtption2
	     , t_h2consumption_pct
	     , t_previousH2Consumption_pct
	     , gr_H2image
	     , arrows_h2 );
    }
    {
    gr_gasImage = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -195.0, -11.0, 0.0, 0.0
	
	     , ovalGas
	     , image10 );
    }
    {
    arrows_gas = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 71.0, -11.0, 0.0, 0.0
	
	     , arrow_up_red_gas
	     , arrow_down_green_gas
	     , line_gas );
    }
    {
    gr_gasKPI = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 100.0, -60.0, 0.0, 0.0
	
	     , gr_gasImage
	     , t_gasconsumption_pct
	     , txt_gasconsumtption
	     , t_previousGasConsumption_pct
	     , arrows_gas );
    }
    {
    gr_electricityImage = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -195.0, -11.0, 0.0, 0.0
	
	     , ovalElectricity
	     , image3 );
    }
    {
    arrows_electricity = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 71.0, -11.0, 0.0, 0.0
	
	     , arrow_down_red_electricity
	     , arrow_up_green_electricity
	     , line_electricity );
    }
    {
    gr_electricityKPI = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 100.0, -120.0, 0.0, 0.0
	
	     , t_elecConsumption_pct
	     , gr_electricityImage
	     , txt_electricityconsumtption
	     , t_previousElectricityConsumption_pct
	     , arrows_electricity );
    }
    {
    gr_imageFF = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -194.0, -10.0, 0.0, 0.0
	
	     , ovalFF );
    }
    {
    arrows_FF = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 71.0, -11.0, 0.0, 0.0
	
	     , arrow_up_red_FF
	     , arrow_down_green_FF
	     , line_FF );
    }
    {
    gr_FFKPI = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 100.0, 0.0, 0.0, 0.0
	
	     , t_FFconsumption_pct
	     , txt_FFconsumtption
	     , t_previousFFConsumption_pct
	     , gr_imageFF
	     , image_FF
	     , arrows_FF );
    }
    {
    gr_productionImage = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, -194.0, -10.0, 0.0, 0.0
	
	     , ovalproduction );
    }
    {
    arrows_production = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 71.0, -11.0, 0.0, 0.0
	
	     , arrow_down_red_production
	     , arrow_up_green_production
	     , line_production );
    }
    {
    gr_productionKPI = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 100.0, 120.0, 0.0, 0.0
	
	     , txt_production
	     , t_production_pct
	     , t_previousProduction_pct
	     , gr_productionImage
	     , arrows_production );
    }
    {
    gr_totalsSeperate = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 150.0, 400.0, 0.0, 0.0
	
	     , gr_h2KPI
	     , gr_gasKPI
	     , gr_electricityKPI
	     , gr_FFKPI
	     , gr_productionKPI
	     , image_production );
    }
    {
    arrows_totalconsumption = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 40.0, 188.0, 0.0, 0.0
	
	     , arrow_up_red_totalconsumption
	     , arrow_down_green_totalconsumption
	     , line_total );
    }
    {
    arrows_import = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 190.0, 188.0, 0.0, 0.0
	
	     , arrow_up_red_import
	     , arrow_down_green_import
	     , line_import );
    }
    {
    arrows_export = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 340.0, 188.0, 0.0, 0.0
	
	     , arrow_up_red_export
	     , arrow_down_green_export
	     , line_export );
    }
    {
    arrows_gridload = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 329.0, 668.0, 0.0, 0.0
	
	     , arrow_up_red_gridload
	     , arrow_down_green_gridload
	     , line_gridload );
    }
    {
    arrows_selfsufficiency = new ShapeGroup( ChartKPISummary.this, SHAPE_DRAW_2D3D, true, 109.0, 668.0, 0.0, 0.0
	
	     , arrow_down_red_selfsufficiency
	     , arrow_up_green_selfsufficiency
	     , line_selfsufficiency );
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
  public ChartKPISummary( Engine engine, Agent owner, AgentList<? extends ChartKPISummary> ownerPopulation ) {
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
  public ChartKPISummary() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartKPISummary_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartKPISummary.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartKPISummary.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

f_styleBackground_override(null, null, null, null); 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartKPISummary_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartKPISummary_xjal() {
    v_badColor = 
red 
;
    v_goodColor = 
green 
;
    v_backgroundColor_override = 
white 
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

  public AgentList<? extends ChartKPISummary> getPopulation() {
    return (AgentList<? extends ChartKPISummary>) super.getPopulation();
  }

  public List<? extends ChartKPISummary> agentsInRange( double distance ) {
    return (List<? extends ChartKPISummary>) super.agentsInRange( distance );
  }

  // Additional class code

@Override
public void f_styleBackground(Color backgroundColor, Color lineColor, Double lineWidth, LineStyle lineStyle) {
    f_styleBackground_override(backgroundColor, lineColor, lineWidth, lineStyle);
} 
  // End of additional class code

}
