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

public class ChartGelijktijdigheid extends digital_twin_results.ChartArea
{
  // Parameters

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartGelijktijdigheid.class );

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

  void f_resetCharts(  ) { 

pl_productionChartYear.removeAll();
t_productionTextYear.setText("Opwek");
pl_consumptionChartYear.removeAll();
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

gr_Year.setVisible(false);
gr_SummerWinter.setVisible(false);
gr_DayNight.setVisible(false);
gr_WeekdayWeekend.setVisible(false);

if (radio_period.getValue() == 0) {
	gr_Year.setVisible(true);
} else if (radio_period.getValue() == 1) {
	gr_SummerWinter.setVisible(true);
} else if (radio_period.getValue() == 2) {
	gr_DayNight.setVisible(true);
} else if (radio_period.getValue() == 3) {
	gr_WeekdayWeekend.setVisible(true);
} 
  }

  public void f_setCharts(  ) { 

f_resetCharts();
f_setVisiblity();
I_EnergyData data = uI_Results.f_getSelectedObjectData();

uI_Results.f_setSelectedObjectDisplay(0, 0, false);

EnergyCoop coop = (EnergyCoop)data;
f_setElectricityBalanceChartYear(coop);

/*
if (uI_Results.v_selectedObjectType == OL_SelectedObjectType.GRIDNODE) {
	f_setTrafoBalanceChartYear(area);
	f_setTrafoBalanceChartSummerWinter(area);
	f_setTrafoBalanceChartDayNight(area);
	f_setTrafoBalanceChartWeekdayWeekend(area);
	}
else {
	if( radio_energyType.getValue() == 0){
		f_setElectricityBalanceChartYear(area);
		f_setElectricityBalanceChartSummerWinter(area);
		f_setElectricityBalanceChartDayNight(area);
		f_setElectricityBalanceChartWeekdayWeekend(area);
	}
	else if( radio_energyType.getValue() == 1){
		f_setEnergyBalanceChartYear(area);
		f_setEnergyBalanceChartSummerWinter(area);
		f_setEnergyBalanceChartDayNight(area);
		f_setEnergyBalanceChartWeekdayWeekend(area);
	}
}
*/
// chart scale?
 
  }

  void f_setElectricityBalanceChartYear( EnergyCoop coop ) { 

//double production_MWh = coop.getRapidRunData().getTotalElectricitySelfConsumed_MWh() + coop.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.ELECTRICITY);
double productionTotal_MWh = coop.getRapidRunData().getTotalElectricityProduced_MWh(); // is this the same?

//double consumption_MWh = coop.getRapidRunData().getTotalElectricitySelfConsumed_MWh() + coop.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.ELECTRICITY);
//coop.getRapidRunData().getTotalElectricityConsumed_MWh(); // is this the same?

double import_MWh = coop.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.ELECTRICITY);
double export_MWh = coop.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.ELECTRICITY);
double simultaneousDelivery_MWh = coop.v_totalCustomerDelivery_MWh - import_MWh; //coop.getRapidRunData().getTotalElectricitySelfConsumed_MWh();
double batteryDeltaEnergy_MWh = productionTotal_MWh - export_MWh - simultaneousDelivery_MWh;

DataItem annualSelfConsumed = new DataItem();
annualSelfConsumed.setValue(simultaneousDelivery_MWh + min(0,batteryDeltaEnergy_MWh));
pl_productionChartYear.addDataItem(annualSelfConsumed, "Lokaal geleverd [MWh]", uI_Results.v_selfConsumedElectricityColor);
pl_consumptionChartYear.addDataItem(annualSelfConsumed, "Lokaal opgewekt [MWh]", uI_Results.v_selfConsumedElectricityColor);

DataItem annualImport = new DataItem();
annualImport.setValue(import_MWh);
pl_consumptionChartYear.addDataItem(annualImport, "Tekorten ingekocht [MWh]", uI_Results.v_importedEnergyColor);

DataItem annualExport = new DataItem();
annualExport.setValue(export_MWh);
pl_productionChartYear.addDataItem(annualExport, "Overschotten verkocht [MWh]", uI_Results.v_exportedEnergyColor);

boolean coopBattPresent = coop.v_rapidRunData.am_assetFlowsAccumulators_kW.keySet().contains(OL_AssetFlowCategories.batteriesChargingPower_kW);
//traceln("Battery present: %s", coopBattPresent);
if (coopBattPresent) {
	if (batteryDeltaEnergy_MWh>1) {
		DataItem batteryDelta = new DataItem();
		batteryDelta.setValue(batteryDeltaEnergy_MWh);
		pl_productionChartYear.addDataItem(batteryDelta, "Energie naar batterij [MWh]", uI_Results.v_electricityForStorageDemandColor);
	} else if (batteryDeltaEnergy_MWh < -1) {
		DataItem batteryDelta = new DataItem();
		batteryDelta.setValue(-batteryDeltaEnergy_MWh);
		pl_consumptionChartYear.addDataItem(batteryDelta, "Energie uit batterij [MWh]", uI_Results.v_electricityForStorageDemandColor);
	}
}
//double productionTotal_MWh = simultaneousDelivery_MWh + export_MWh + batteryDeltaEnergy_MWh;
double deliveryTotal_MWh = (simultaneousDelivery_MWh+import_MWh);
double chartScale_MWh = max(productionTotal_MWh, deliveryTotal_MWh);
pl_consumptionChartYear.setFixedScale(chartScale_MWh);
pl_productionChartYear.setFixedScale(chartScale_MWh);

if (chartScale_MWh<10) {
	t_productionTextYear.setText("Opwek + teruglevering klanten" + System.lineSeparator() + roundToInt(productionTotal_MWh*1000) + " kWh");
	t_consumptionTextYear.setText("Levering" + System.lineSeparator() + roundToInt(deliveryTotal_MWh*1000) + " kWh");
} else if (chartScale_MWh<1000) {
	t_productionTextYear.setText("Opwek + teruglevering klanten" + System.lineSeparator() + roundToInt(productionTotal_MWh) + " MWh");
	t_consumptionTextYear.setText("Levering" + System.lineSeparator() + roundToInt(deliveryTotal_MWh) + " MWh");
} else {
	t_productionTextYear.setText("Opwek + teruglevering klanten" + System.lineSeparator() + roundToDecimal(productionTotal_MWh/1000, 1) + " GWh");
	t_consumptionTextYear.setText("Levering" + System.lineSeparator() + roundToDecimal(deliveryTotal_MWh/1000,1) + " GWh");
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
  protected static final Font _t_productionTextYear_Font = new Font("Calibri", 0, 36 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextYear_Font = _t_productionTextYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextSummer_Font = new Font("Calibri", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextSummer_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_topBarplotText1_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextWinter_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextWinter_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_bottomBarplotText1_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextDay_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextDay_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_topBarplotText2_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextNight_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextNight_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_bottomBarplotText2_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextWeekday_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextWeekday_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_topBarplotText3_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_productionTextWeekend_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_consumptionTextWeekend_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_bottomBarplotText3_Font = _t_productionTextSummer_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_productionTextYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_consumptionTextYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_Year = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
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
  protected static final int _pl_productionChartYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartSummer = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartSummer = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartWinter = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartWinter = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartNight = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartNight = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartWeekday = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartWeekday = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_productionChartWeekend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _pl_consumptionChartWeekend = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio_energyType = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio_period = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 41;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 42;

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
	  level.addAll(rectangle, radio_energyType, radio_period, gr_Year, gr_SummerWinter, gr_DayNight, gr_WeekdayWeekend);
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
false 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeRadioButtonGroup radio_energyType;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _radio_period_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    boolean _visible = 
false 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeRadioButtonGroup radio_period;
  protected StackChart pl_productionChartYear;
  protected StackChart pl_consumptionChartYear;
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
  protected ShapeGroup gr_Year;
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
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    radio_energyType = new ShapeRadioButtonGroup(
ChartGelijktijdigheid.this, true, 110.0, 5.0,
			230.0, 40.0,
            black, true,
_radio_energyType_Font, false,
            new String[]{"Alleen elektriciteit", "Alle energiedragers", } ) {
	
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
ChartGelijktijdigheid.this, true, 20.0, 35.0,
			440.0, 40.0,
            black, true,
_radio_period_Font, false,
            new String[]{"Jaar overzicht", "Zomer / Winter week", "Dag / Nacht", "Week/ Weekend", } ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _radio_period_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

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
    rectangle.setVisible( false );
    t_productionTextYear = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -270.0, 0.0, 0.0,
        black,"Opwek + teruglevering klanten",
        _t_productionTextYear_Font, ALIGNMENT_CENTER );
    t_consumptionTextYear = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, 20.0, 0.0, 0.0,
        black,"Levering",
        _t_consumptionTextYear_Font, ALIGNMENT_CENTER );
    t_productionTextSummer = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -240.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextSummer_Font, ALIGNMENT_RIGHT );
    t_consumptionTextSummer = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -120.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextSummer_Font, ALIGNMENT_RIGHT );
    t_topBarplotText1 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, -180.0, 0.0, 0.0,
        black,"Zomer week",
        _t_topBarplotText1_Font, ALIGNMENT_CENTER );
    t_productionTextWinter = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 70.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextWinter_Font, ALIGNMENT_RIGHT );
    t_consumptionTextWinter = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 200.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextWinter_Font, ALIGNMENT_RIGHT );
    t_bottomBarplotText1 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, 120.0, 0.0, 0.0,
        black,"Winter week",
        _t_bottomBarplotText1_Font, ALIGNMENT_CENTER );
    t_productionTextDay = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -240.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextDay_Font, ALIGNMENT_RIGHT );
    t_consumptionTextDay = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -120.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextDay_Font, ALIGNMENT_RIGHT );
    t_topBarplotText2 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, -180.0, 0.0, 0.0,
        black,"Dag\n",
        _t_topBarplotText2_Font, ALIGNMENT_CENTER );
    t_productionTextNight = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 70.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextNight_Font, ALIGNMENT_RIGHT );
    t_consumptionTextNight = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 200.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextNight_Font, ALIGNMENT_RIGHT );
    t_bottomBarplotText2 = new ShapeText(
        SHAPE_DRAW_2D, true,-200.0, 140.0, 0.0, 0.0,
        black,"Nacht",
        _t_bottomBarplotText2_Font, ALIGNMENT_CENTER );
    t_productionTextWeekday = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -240.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextWeekday_Font, ALIGNMENT_RIGHT );
    t_consumptionTextWeekday = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -120.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextWeekday_Font, ALIGNMENT_RIGHT );
    t_topBarplotText3 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, -190.0, 0.0, 0.0,
        black,"Weekdagen\n",
        _t_topBarplotText3_Font, ALIGNMENT_CENTER );
    t_productionTextWeekend = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 70.0, 0.0, 0.0,
        black,"Opwek",
        _t_productionTextWeekend_Font, ALIGNMENT_RIGHT );
    t_consumptionTextWeekend = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, 200.0, 0.0, 0.0,
        black,"Gebruik",
        _t_consumptionTextWeekend_Font, ALIGNMENT_RIGHT );
    t_bottomBarplotText3 = new ShapeText(
        SHAPE_DRAW_2D, true,-190.0, 140.0, 0.0, 0.0,
        black,"Weekenden",
        _t_bottomBarplotText3_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartYear = new StackChart(
ChartGelijktijdigheid.this, true, -226.377, -228.191,
			455.773, 170.805,
            null, null,
            50.0, 30.0,
			375.7730000000001, 90.805, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.6,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_consumptionChartYear = new StackChart(
ChartGelijktijdigheid.this, true, -226.377, 64.692,
			457.057, 169.384,
            null, null,
            50.0, 30.0,
			377.057, 89.38399999999999, null, black, black,
            36.0, Chart.SOUTH,
            Chart.EAST, Chart.SCALE_AUTO,
0, 0.6,
            Chart.GRID_DEFAULT,
            darkGray, null, _items, _titles, _colors );
    }
    {
    List<DataItem> _items = new ArrayList<>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    pl_productionChartSummer = new StackChart(
ChartGelijktijdigheid.this, true, -160.0, -280.0,
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
ChartGelijktijdigheid.this, true, -160.0, -160.0,
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
ChartGelijktijdigheid.this, true, -160.0, 30.0,
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
ChartGelijktijdigheid.this, true, -160.0, 160.0,
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
ChartGelijktijdigheid.this, true, -160.0, -280.0,
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
ChartGelijktijdigheid.this, true, -160.0, -160.0,
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
ChartGelijktijdigheid.this, true, -160.0, 30.0,
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
ChartGelijktijdigheid.this, true, -160.0, 160.0,
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
ChartGelijktijdigheid.this, true, -160.0, -280.0,
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
ChartGelijktijdigheid.this, true, -160.0, -160.0,
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
ChartGelijktijdigheid.this, true, -160.0, 30.0,
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
ChartGelijktijdigheid.this, true, -160.0, 160.0,
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
    gr_Year = new ShapeGroup( ChartGelijktijdigheid.this, SHAPE_DRAW_2D3D, true, 230.0, 370.0, 0.0, 0.0
	
	     , pl_productionChartYear
	     , pl_consumptionChartYear
	     , t_productionTextYear
	     , t_consumptionTextYear );
    }
    {
    gr_SummerWinter = new ShapeGroup( ChartGelijktijdigheid.this, SHAPE_DRAW_2D3D, true, 690.0, 380.0, 0.0, 0.0
	
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
    gr_DayNight = new ShapeGroup( ChartGelijktijdigheid.this, SHAPE_DRAW_2D3D, true, 1120.0, 380.0, 0.0, 0.0
	
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
    gr_WeekdayWeekend = new ShapeGroup( ChartGelijktijdigheid.this, SHAPE_DRAW_2D3D, true, 1550.0, 380.0, 0.0, 0.0
	
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
  public ChartGelijktijdigheid( Engine engine, Agent owner, AgentList<? extends ChartGelijktijdigheid> ownerPopulation ) {
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
  public ChartGelijktijdigheid() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartGelijktijdigheid_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartGelijktijdigheid.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartGelijktijdigheid.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    radio_energyType.setValueToDefault();
    radio_period.setValueToDefault();
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
    setupPlainVariables_ChartGelijktijdigheid_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartGelijktijdigheid_xjal() {
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

  public AgentList<? extends ChartGelijktijdigheid> getPopulation() {
    return (AgentList<? extends ChartGelijktijdigheid>) super.getPopulation();
  }

  public List<? extends ChartGelijktijdigheid> agentsInRange( double distance ) {
    return (List<? extends ChartGelijktijdigheid>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    super.onDestroy();
  }


}
