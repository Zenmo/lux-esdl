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

import energy.lux.uplux.TemporaryFileRepository;
import java.nio.file.Path;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileOutputStream;
import java.io.File;
import zeroPackage.ZeroMath;
import java.text.SimpleDateFormat; 

public class ChartProfielen extends digital_twin_results.ChartArea
{
  // Parameters

  public 
String  p_selectedExportUnit;

  /**
   * Returns default value for parameter <code>p_selectedExportUnit</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_selectedExportUnit_DefaultValue_xjal() {
    final ChartProfielen self = this;
    return 
"kWh" 
;
  }

  public void set_p_selectedExportUnit( String value ) {
    if (value == this.p_selectedExportUnit) {
      return;
    }
    String _oldValue_xjal = this.p_selectedExportUnit;
    this.p_selectedExportUnit = value;
    onChange_p_selectedExportUnit_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_selectedExportUnit.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_selectedExportUnit()</code> method instead.
   */
  protected void onChange_p_selectedExportUnit() {
    onChange_p_selectedExportUnit_xjal( p_selectedExportUnit );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_selectedExportUnit_xjal( String oldValue ) {  
  }


  public 
Map<OL_AssetFlowCategories, ShapeCheckBox>  map_ACToCheckBox;

  /**
   * Returns default value for parameter <code>map_ACToCheckBox</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_AssetFlowCategories, ShapeCheckBox> _map_ACToCheckBox_DefaultValue_xjal() {
    final ChartProfielen self = this;
    return 
Map.ofEntries(
Map.entry(OL_AssetFlowCategories.fixedConsumptionElectric_kW, checkbox_baseLoad),
Map.entry(OL_AssetFlowCategories.batteriesChargingPower_kW, checkbox_battery),
Map.entry(OL_AssetFlowCategories.batteriesDischargingPower_kW, checkbox_battery),
Map.entry(OL_AssetFlowCategories.CHPProductionElectric_kW, checkbox_exportCHP),
Map.entry(OL_AssetFlowCategories.districtHeatDelivery_kW, checkbox_heat),
Map.entry(OL_AssetFlowCategories.electricHobConsumption_kW, checkbox_elecCooking),
Map.entry(OL_AssetFlowCategories.electrolyserElectricityConsumption_kW, checkbox_electricityForH2),
Map.entry(OL_AssetFlowCategories.evChargingPower_kW, checkbox_vehicleCharging),
Map.entry(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW, checkbox_electricityForHeating),
//Map.entry(OL_AssetFlowCategories.ptProductionHeat_kW, checkbox_PT),
Map.entry(OL_AssetFlowCategories.pvProductionElectric_kW, checkbox_PV),
Map.entry(OL_AssetFlowCategories.V2GPower_kW, checkbox_v2g),
Map.entry(OL_AssetFlowCategories.windProductionElectric_kW, checkbox_wind),
Map.entry(OL_AssetFlowCategories.airConditionersElectricPower_kW, checkbox_aircos),
Map.entry(OL_AssetFlowCategories.dieselGeneratorProductionElectric_kW, checkbox_exportDieselGen),
Map.entry(OL_AssetFlowCategories.methaneGeneratorProductionElectric_kW, checkbox_exportMethaneGen),
Map.entry(OL_AssetFlowCategories.hydrogenFuelCellProductionElectric_kW, checkbox_exportFuelCell)
) 
;
  }

  public void set_map_ACToCheckBox( Map<OL_AssetFlowCategories, ShapeCheckBox> value ) {
    if (value == this.map_ACToCheckBox) {
      return;
    }
    Map<OL_AssetFlowCategories, ShapeCheckBox> _oldValue_xjal = this.map_ACToCheckBox;
    this.map_ACToCheckBox = value;
    onChange_map_ACToCheckBox_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_ACToCheckBox.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_ACToCheckBox()</code> method instead.
   */
  protected void onChange_map_ACToCheckBox() {
    onChange_map_ACToCheckBox_xjal( map_ACToCheckBox );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_ACToCheckBox_xjal( Map<OL_AssetFlowCategories, ShapeCheckBox> oldValue ) {  
  }


  public 
Map<OL_EnergyCarriers, ShapeCheckBox>  map_ECToCheckBox;

  /**
   * Returns default value for parameter <code>map_ECToCheckBox</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_EnergyCarriers, ShapeCheckBox> _map_ECToCheckBox_DefaultValue_xjal() {
    final ChartProfielen self = this;
    return 
Map.ofEntries(
Map.entry(OL_EnergyCarriers.ELECTRICITY, checkbox_electricity),
Map.entry(OL_EnergyCarriers.METHANE, checkbox_methane),
Map.entry(OL_EnergyCarriers.HYDROGEN, checkbox_hydrogen),
Map.entry(OL_EnergyCarriers.PETROLEUM_FUEL, checkbox_fuel)//,
//Map.entry(OL_EnergyCarriers.HEAT, checkbox_heat),
) 
;
  }

  public void set_map_ECToCheckBox( Map<OL_EnergyCarriers, ShapeCheckBox> value ) {
    if (value == this.map_ECToCheckBox) {
      return;
    }
    Map<OL_EnergyCarriers, ShapeCheckBox> _oldValue_xjal = this.map_ECToCheckBox;
    this.map_ECToCheckBox = value;
    onChange_map_ECToCheckBox_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_ECToCheckBox.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_ECToCheckBox()</code> method instead.
   */
  protected void onChange_map_ECToCheckBox() {
    onChange_map_ECToCheckBox_xjal( map_ECToCheckBox );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_ECToCheckBox_xjal( Map<OL_EnergyCarriers, ShapeCheckBox> oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_selectedExportUnit = _p_selectedExportUnit_DefaultValue_xjal();
    map_ACToCheckBox = _map_ACToCheckBox_DefaultValue_xjal();
    map_ECToCheckBox = _map_ECToCheckBox_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_selectedExportUnit":
      if ( _callOnChange_xjal ) {
        set_p_selectedExportUnit( (String) _value_xjal );
      } else {
        p_selectedExportUnit = (String) _value_xjal;
      }
      return true;
    case "map_ACToCheckBox":
      if ( _callOnChange_xjal ) {
        set_map_ACToCheckBox( (Map<OL_AssetFlowCategories, ShapeCheckBox>) _value_xjal );
      } else {
        map_ACToCheckBox = (Map<OL_AssetFlowCategories, ShapeCheckBox>) _value_xjal;
      }
      return true;
    case "map_ECToCheckBox":
      if ( _callOnChange_xjal ) {
        set_map_ECToCheckBox( (Map<OL_EnergyCarriers, ShapeCheckBox>) _value_xjal );
      } else {
        map_ECToCheckBox = (Map<OL_EnergyCarriers, ShapeCheckBox>) _value_xjal;
      }
      return true;
    default:
      return super.setParameter( _name_xjal, _value_xjal, _callOnChange_xjal );
    }
  }

  @Override
  public <T> T getParameter(String _name_xjal) {
    Object _result_xjal;
    switch ( _name_xjal ) {
    case "p_selectedExportUnit": _result_xjal = p_selectedExportUnit; break;
    case "map_ACToCheckBox": _result_xjal = map_ACToCheckBox; break;
    case "map_ECToCheckBox": _result_xjal = map_ECToCheckBox; break;
    default: _result_xjal = super.getParameter( _name_xjal ); break;
    }
    return (T) _result_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private static String[] _parameterNames_xjal;

  @Override
  public String[] getParameterNames() {
    String[] result = _parameterNames_xjal;
    if (result == null) {
      List<String> list = new ArrayList<>( Arrays.asList( super.getParameterNames() ) );
      list.add( "p_selectedExportUnit" );
      list.add( "map_ACToCheckBox" );
      list.add( "map_ECToCheckBox" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
ShapeText 
 v_weekLabel;
  public 
boolean 
 b_subdivideEnergyCoopFlows;
  public 
ShapeRadioButtonGroup 
 v_periodRadioButton;

  // Collection Variables
  public 
ArrayList <
OL_EnergyCarriers > c_selectedExportEC = new ArrayList<OL_EnergyCarriers>();
  public 
ArrayList <
OL_AssetFlowCategories > c_selectedExportAC = new ArrayList<OL_AssetFlowCategories>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartProfielen.class );

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

  private void f_addOtherEnergyFlows_Year( I_EnergyData dataObject ) { 

double startTime_h = 0;

EnumSet<OL_EnergyCarriers> activeProductionEnergyCarriers = EnumSet.copyOf(dataObject.getRapidRunData().activeProductionEnergyCarriers);
EnumSet<OL_EnergyCarriers> activeConsumptionEnergyCarriers = EnumSet.copyOf(dataObject.getRapidRunData().activeConsumptionEnergyCarriers);

activeProductionEnergyCarriers.remove( OL_EnergyCarriers.ELECTRICITY );
activeConsumptionEnergyCarriers.remove( OL_EnergyCarriers.ELECTRICITY );

for (OL_EnergyCarriers EC_consumption : activeConsumptionEnergyCarriers) {
	if(EC_consumption != OL_EnergyCarriers.HEAT){
		energyDemandChartYear.addDataSet( dataObject.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(EC_consumption).getDataSet(startTime_h, 24.0), uI_Results.f_getECName(EC_consumption), uI_Results.cm_consumptionColors.get(EC_consumption)); 
	}
	else if(dataObject.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW)){//Only heat import, not all consumption (part of gas, elec, etc. already)
		energyDemandChartYear.addDataSet( dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getDataSet(startTime_h, 24.0), "Warmte net", uI_Results.cm_consumptionColors.get(EC_consumption)); 
	}
}

for (OL_EnergyCarriers EC_production : activeProductionEnergyCarriers) {
	if(EC_production != OL_EnergyCarriers.HEAT){
		energySupplyChartYear.addDataSet( dataObject.getRapidRunData().am_dailyAverageProductionAccumulators_kW.get(EC_production).getDataSet(startTime_h, 24.0), uI_Results.f_getECName(EC_production), uI_Results.cm_productionColors.get(EC_production)); 
	}
	else if(dataObject.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW)){
		energySupplyChartYear.addDataSet( dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getDataSet(startTime_h, 24.0), "PT", uI_Results.cm_productionColors.get(EC_production)); 
	}
}
 
  }

  private void f_addElectricityFlows_Year( I_EnergyData dataObject ) { 

gr_year.setVisible(true);

double startTime_h = 0;

if (uI_Results.v_selectedObjectScope == OL_ResultScope.ENERGYCOOP && b_subdivideEnergyCoopFlows) {
	List<Color> colorSpectrum = new ArrayList<>();
	List<GridConnection> memberGridConnections = ((EnergyCoop)dataObject).f_getAllChildMemberGridConnections();
	
	for (int k = 0; k < memberGridConnections.size(); k++) {
	    colorSpectrum.add(UtilitiesColor.spectrumColor(k, memberGridConnections.size()).darker());
		energyDemandChartYear.addDataSet(memberGridConnections.get(k).getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(startTime_h, 24.0), memberGridConnections.get(k).p_ownerID, colorSpectrum.get(k));
		energySupplyChartYear.addDataSet(memberGridConnections.get(k).getRapidRunData().am_dailyAverageProductionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(startTime_h, 24.0), memberGridConnections.get(k).p_ownerID, colorSpectrum.get(k));	
	}
}
else{	
	// Still need to convert to daily averages!
	for (OL_AssetFlowCategories AC : dataObject.getRapidRunData().assetsMetaData.activeAssetFlows) {
		if (uI_Results.v_electricAssetFlows.contains(AC)) {
			if (uI_Results.v_consumptionAssetFlows.contains(AC)) {
				energyDemandChartYear.addDataSet(dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AC).getDataSet(startTime_h, 24.0), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
			} else {
				energySupplyChartYear.addDataSet(dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AC).getDataSet(startTime_h, 24.0), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
			}
		}
	}
} 
  }

  private void f_addOtherEnergyCarriers_Live( I_EnergyData dataObject ) { 

EnumSet<OL_EnergyCarriers> activeConsumptionEnergyCarriers = EnumSet.copyOf(dataObject.getLiveData().activeConsumptionEnergyCarriers);
EnumSet<OL_EnergyCarriers> activeProductionEnergyCarriers = EnumSet.copyOf(dataObject.getLiveData().activeProductionEnergyCarriers);

activeConsumptionEnergyCarriers.remove( OL_EnergyCarriers.ELECTRICITY );
activeProductionEnergyCarriers.remove( OL_EnergyCarriers.ELECTRICITY );

for (OL_EnergyCarriers EC_consumption : activeConsumptionEnergyCarriers) {
	if(EC_consumption != OL_EnergyCarriers.HEAT){
		energyDemandChart.addDataSet( dataObject.getLiveData().dsm_liveDemand_kW.get(EC_consumption), uI_Results.f_getECName(EC_consumption), uI_Results.cm_consumptionColors.get(EC_consumption)); 
	}
	else if(dataObject.getLiveData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW)){//Only heat import, not all consumption (part of gas, elec, etc. already)
		energyDemandChart.addDataSet( dataObject.getLiveData().dsm_liveAssetFlows_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW), "Warmte net", uI_Results.cm_consumptionColors.get(EC_consumption)); 
	}
}


for (OL_EnergyCarriers EC_production : activeProductionEnergyCarriers) {
	if(EC_production != OL_EnergyCarriers.HEAT){
		energySupplyChart.addDataSet( dataObject.getLiveData().dsm_liveSupply_kW.get(EC_production), uI_Results.f_getECName(EC_production), uI_Results.cm_productionColors.get(EC_production));  
	}
	else if(dataObject.getLiveData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW)){
		energySupplyChart.addDataSet( dataObject.getLiveData().dsm_liveAssetFlows_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW), "PT", uI_Results.cm_productionColors.get(EC_production)); 
	}
}
 
  }

  private void f_addElectricityFlows_Live( I_EnergyData dataObject ) { 

gr_week.setVisible(true);
v_weekLabel.setX(220);
v_weekLabel.setText("");

if (uI_Results.v_selectedObjectScope == OL_ResultScope.ENERGYCOOP && b_subdivideEnergyCoopFlows) {
	List<Color> colorSpectrum = new ArrayList<>();
	List<GridConnection> memberGridConnections = ((EnergyCoop)dataObject).f_getAllChildMemberGridConnections();
	
	for (int k = 0; k < memberGridConnections.size(); k++) {
	    colorSpectrum.add(UtilitiesColor.spectrumColor(k, memberGridConnections.size()).darker());
		energyDemandChart.addDataSet(memberGridConnections.get(k).getLiveData().dsm_liveDemand_kW.get(OL_EnergyCarriers.ELECTRICITY), memberGridConnections.get(k).p_ownerID, colorSpectrum.get(k));
		energySupplyChart.addDataSet(memberGridConnections.get(k).getLiveData().dsm_liveSupply_kW.get(OL_EnergyCarriers.ELECTRICITY), memberGridConnections.get(k).p_ownerID, colorSpectrum.get(k));	
	}
}
else{
	for (OL_AssetFlowCategories AC : dataObject.getLiveData().assetsMetaData.activeAssetFlows) {
		if (uI_Results.v_electricAssetFlows.contains(AC)) {
			if (uI_Results.v_consumptionAssetFlows.contains(AC)) {
				energyDemandChart.addDataSet(dataObject.getLiveData().dsm_liveAssetFlows_kW.get(AC), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
			} else {
				energySupplyChart.addDataSet(dataObject.getLiveData().dsm_liveAssetFlows_kW.get(AC), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
			}
		}
	}
}
 
  }

  private void f_addOtherEnergyFlows_Week( I_EnergyData dataObject, boolean isSummerWeek ) { 


EnumSet<OL_EnergyCarriers> activeProductionEnergyCarriers = EnumSet.copyOf(dataObject.getRapidRunData().activeProductionEnergyCarriers);
EnumSet<OL_EnergyCarriers> activeConsumptionEnergyCarriers = EnumSet.copyOf(dataObject.getRapidRunData().activeConsumptionEnergyCarriers);

activeProductionEnergyCarriers.remove( OL_EnergyCarriers.ELECTRICITY );
activeConsumptionEnergyCarriers.remove( OL_EnergyCarriers.ELECTRICITY );
activeProductionEnergyCarriers.remove( OL_EnergyCarriers.HEAT );

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
	double peakWeekStart_h = dataObject.getRapidRunData().getPeakWeekStart_h(peakTime_h);
	for (OL_EnergyCarriers EC_consumption : activeConsumptionEnergyCarriers) {
		if(EC_consumption != OL_EnergyCarriers.HEAT){
			energyDemandChart.addDataSet( dataObject.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.get(EC_consumption).getDataSet(dataSetStartTime_h, peakWeekStart_h, peakWeekStart_h+24*7), uI_Results.f_getECName(EC_consumption), uI_Results.cm_consumptionColors.get(EC_consumption));
			//dataObject.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW
		} else if(dataObject.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW)){//Only heat import, not all consumption (part of gas, elec, etc. already)
			energyDemandChart.addDataSet( dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getDataSet(dataSetStartTime_h, peakWeekStart_h, peakWeekStart_h+24*7), "Warmte net", uI_Results.cm_consumptionColors.get(EC_consumption)); 
		}
	}
	
	for (OL_EnergyCarriers EC_production : activeProductionEnergyCarriers) {
		if(EC_production != OL_EnergyCarriers.HEAT){
			energySupplyChart.addDataSet( dataObject.getRapidRunData().am_dailyAverageProductionAccumulators_kW.get(EC_production).getDataSet(dataSetStartTime_h, peakWeekStart_h, peakWeekStart_h+24*7), uI_Results.f_getECName(EC_production), uI_Results.cm_productionColors.get(EC_production));
		} else if(dataObject.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW)){
			energySupplyChart.addDataSet( dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getDataSet(dataSetStartTime_h, peakWeekStart_h, peakWeekStart_h+24*7), "PT", uI_Results.cm_productionColors.get(EC_production)); 
		}
	}
} else {
	double startTime_h;
	if (isSummerWeek) {
		startTime_h = uI_Results.energyModel.p_timeParameters.getStartOfSummerWeek_h() - uI_Results.energyModel.p_timeParameters.getRunStartTime_h();
	} else {
		startTime_h = uI_Results.energyModel.p_timeParameters.getStartOfWinterWeek_h() - uI_Results.energyModel.p_timeParameters.getRunStartTime_h();
	}
	if (startTime_h<0) {
		startTime_h +=8760;
	}
	for (OL_EnergyCarriers EC_consumption : activeConsumptionEnergyCarriers) {
		if(EC_consumption != OL_EnergyCarriers.HEAT){
			if (isSummerWeek) {
				energyDemandChart.addDataSet( dataObject.getRapidRunData().am_summerWeekConsumptionAccumulators_kW.get(EC_consumption).getDataSet(startTime_h), uI_Results.f_getECName(EC_consumption), uI_Results.cm_consumptionColors.get(EC_consumption));
			} else {
				energyDemandChart.addDataSet( dataObject.getRapidRunData().am_winterWeekConsumptionAccumulators_kW.get(EC_consumption).getDataSet(startTime_h), uI_Results.f_getECName(EC_consumption), uI_Results.cm_consumptionColors.get(EC_consumption));
			}
		}
		else if(dataObject.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW)){//Only heat import, not all consumption (part of gas, elec, etc. already)
			if (isSummerWeek) {
				energyDemandChart.addDataSet( dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getDataSet(startTime_h), "Warmte net", uI_Results.cm_consumptionColors.get(EC_consumption)); 
			} else {
				energyDemandChart.addDataSet( dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getDataSet(startTime_h), "Warmte net", uI_Results.cm_consumptionColors.get(EC_consumption)); 
			}
		}
	}
	
	for (OL_EnergyCarriers EC_production : activeProductionEnergyCarriers) {
		if(EC_production != OL_EnergyCarriers.HEAT){
			if (isSummerWeek) {
				energySupplyChart.addDataSet( dataObject.getRapidRunData().am_summerWeekProductionAccumulators_kW.get(EC_production).getDataSet(startTime_h), uI_Results.f_getECName(EC_production), uI_Results.cm_productionColors.get(EC_production));
			} else {
				energySupplyChart.addDataSet( dataObject.getRapidRunData().am_winterWeekProductionAccumulators_kW.get(EC_production).getDataSet(startTime_h), uI_Results.f_getECName(EC_production), uI_Results.cm_productionColors.get(EC_production));
			}
		}
		else if(dataObject.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW)){
			if (isSummerWeek) {
				energySupplyChart.addDataSet( dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getDataSet(startTime_h), "PT", uI_Results.cm_productionColors.get(EC_production)); 
			} else {
				energySupplyChart.addDataSet( dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW).getDataSet(startTime_h), "PT", uI_Results.cm_productionColors.get(EC_production)); 
			}
		}
	}
} 
  }

  private void f_addElectricityFlows_Week( I_EnergyData dataObject, boolean isSummerWeek ) { 

gr_week.setVisible(true);
double dataSetWeekStartTime_h;

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
	String dateTimeString = f_getDateTimeFromHour(peakTime_h);
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
	}
	v_weekLabel.setX(80);
	double peakWeekStart_h = dataObject.getRapidRunData().getPeakWeekStart_h(peakTime_h);
	//for (OL_AssetFlowCategories AC : dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.keySet()) {
	for (OL_AssetFlowCategories AC : dataObject.getRapidRunData().assetsMetaData.activeAssetFlows) {
		if (uI_Results.v_electricAssetFlows.contains(AC)) {
			if (uI_Results.v_consumptionAssetFlows.contains(AC)) {
				energyDemandChart.addDataSet(dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AC).getDataSet(dataSetStartTime_h,peakWeekStart_h, peakWeekStart_h + 7*24), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
			} else {
				energySupplyChart.addDataSet(dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AC).getDataSet(dataSetStartTime_h,peakWeekStart_h, peakWeekStart_h + 7*24), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
			}
		}
	}
} else {
	if (isSummerWeek) {
		dataSetWeekStartTime_h = uI_Results.energyModel.p_timeParameters.getStartOfSummerWeek_h() - uI_Results.energyModel.p_timeParameters.getRunStartTime_h();
	} else {
		dataSetWeekStartTime_h = uI_Results.energyModel.p_timeParameters.getStartOfWinterWeek_h() - uI_Results.energyModel.p_timeParameters.getRunStartTime_h();
	}
	if (dataSetWeekStartTime_h<0) {
		dataSetWeekStartTime_h +=8760;
	}
	if (uI_Results.v_selectedObjectScope == OL_ResultScope.ENERGYCOOP && b_subdivideEnergyCoopFlows) {
		List<Color> colorSpectrum = new ArrayList<>();
		List<GridConnection> memberGridConnections = ((EnergyCoop)dataObject).f_getAllChildMemberGridConnections();
		
		for (int k = 0; k < memberGridConnections.size(); k++) {
		    colorSpectrum.add(UtilitiesColor.spectrumColor(k, memberGridConnections.size()).darker());
		    if (isSummerWeek){
				energyDemandChart.addDataSet(memberGridConnections.get(k).getRapidRunData().am_summerWeekConsumptionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(dataSetWeekStartTime_h), memberGridConnections.get(k).p_ownerID, colorSpectrum.get(k));
				energySupplyChart.addDataSet(memberGridConnections.get(k).getRapidRunData().am_summerWeekProductionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(dataSetWeekStartTime_h), memberGridConnections.get(k).p_ownerID, colorSpectrum.get(k));	
			} else {
				energyDemandChart.addDataSet(memberGridConnections.get(k).getRapidRunData().am_winterWeekConsumptionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(dataSetWeekStartTime_h), memberGridConnections.get(k).p_ownerID, colorSpectrum.get(k));
				energySupplyChart.addDataSet(memberGridConnections.get(k).getRapidRunData().am_winterWeekProductionAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(dataSetWeekStartTime_h), memberGridConnections.get(k).p_ownerID, colorSpectrum.get(k));	
			}
		}
	}
	else{
		for (OL_AssetFlowCategories AC : dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.keySet()) {
			if (uI_Results.v_electricAssetFlows.contains(AC)) {
				if (isSummerWeek){
					if (uI_Results.v_consumptionAssetFlows.contains(AC)) {
						energyDemandChart.addDataSet(dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(AC).getDataSet(dataSetWeekStartTime_h), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
					} else {
						energySupplyChart.addDataSet(dataObject.getRapidRunData().am_assetFlowsSummerWeek_kW.get(AC).getDataSet(dataSetWeekStartTime_h), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
					}
				} else {
					if (uI_Results.v_consumptionAssetFlows.contains(AC)) {
						energyDemandChart.addDataSet(dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(AC).getDataSet(dataSetWeekStartTime_h), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
					} else {
						energySupplyChart.addDataSet(dataObject.getRapidRunData().am_assetFlowsWinterWeek_kW.get(AC).getDataSet(dataSetWeekStartTime_h), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
					}
				}
			}
		}	
	}
} 
  }

  private void f_resetCharts(  ) { 

gr_week.setVisible(false);
gr_year.setVisible(false);
gr_day.setVisible(false);
gr_trafoWeek.setVisible(false);
gr_trafoDay.setVisible(false);
gr_netLoadWeek.setVisible(false);
gr_netLoadDay.setVisible(false);
gr_exportMenu.setVisible(false);

plot_trafo_week.removeAll();
plot_trafo_day.removeAll();
plot_netload_week.removeAll();
plot_netload_day.removeAll();
energyDemandChart.removeAll();
energySupplyChart.removeAll();
energyDemandChartYear.removeAll();
energySupplyChartYear.removeAll();
energyDemandChartDay.removeAll();
energySupplyChartDay.removeAll();

radio_periodLive.setVisible(false);
rb_periodIncludingYear.setVisible(false);
rb_periodExcludingYear.setVisible(false);
rb_periodPeaksIncludingYear.setVisible(false);
rb_periodPeaksExcludingYear.setVisible(false);
v_weekLabel.setText("");
 
  }

  public void f_setCharts(  ) { 

f_resetCharts();

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 115, true);

if (v_periodRadioButton.getValue() == 0) {
	radio_periodLive.setVisible(true);
}

I_EnergyData dataObject = uI_Results.f_getSelectedObjectData();

if (dataObject.getRapidRunData()!=null && dataObject.getRapidRunData().getStoreTotalAssetFlows()) {
	if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
		v_periodRadioButton = rb_periodPeaksExcludingYear;
	} else {
		v_periodRadioButton = rb_periodPeaksIncludingYear;
	}
} else {
	if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
		v_periodRadioButton = rb_periodExcludingYear;
	} else {
		v_periodRadioButton = rb_periodIncludingYear;
	}
}
v_periodRadioButton.setVisible(true);
int radioValue = v_periodRadioButton.getValue();

if (radio_energyType.getValue() == 2) { // Line Plot (Net Load)
	switch (radioValue) {
		case 0: // Live
			if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
				if (radio_periodLive.getValue() == 0) {
					f_addElectricityFlowsTrafo_Live(uI_Results.v_gridNode);
				}
				else {
					f_addElectricityFlowsTrafo_LiveDay(uI_Results.v_gridNode);
				}
			}
			else {
				if (radio_periodLive.getValue() == 0) {
					f_addElectricityNetLoad_Live(dataObject);
				}
				else {
					f_addElectricityNetLoad_LiveDay(dataObject);
				}
			}
			break;
		
		case 2: // Summer
			if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
				f_addElectricityFlowsTrafo_Week(uI_Results.v_gridNode,true);
			}
			else {
				f_addElectricityNetLoad_Week(dataObject, true);
			}
			break;
		
		case 1: // Winter
			if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
				f_addElectricityFlowsTrafo_Week(uI_Results.v_gridNode, false);
			}
			else {
				f_addElectricityNetLoad_Week(dataObject, false);
			}
			break;
		
		case 3: // Year
			if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
				//f_addElectricityFlowsTrafo_Year(uI_Results.v_gridNode);
				throw new RuntimeException("The Year Graph does not exist for GridNodes.");				
			}
			else {
				//f_addElectricityNetLoad_Year(dataObject);
				throw new RuntimeException("The Net Balance Year Graph does not exist.");				
			}
			//break;
			
		default:
			throw new RuntimeException("Unrecognized option selected in Period Radio Button for Line Plots (Net Load).");
	}
}
else { // Stack Chart
	switch (radioValue) {
		case 0: // Live
			if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
				if (radio_periodLive.getValue() == 0) {
					f_addElectricityFlowsTrafo_Live(uI_Results.v_gridNode);
				}
				else {
					f_addElectricityFlowsTrafo_LiveDay(uI_Results.v_gridNode);
				}				
			}
			else {
				if (radio_periodLive.getValue() == 0) {
					f_addElectricityFlows_Live(dataObject);				
				}
				else {
					f_addElectricityFlows_LiveDay(dataObject);				
				}
				if( radio_energyType.getValue() == 1){
					if (radio_periodLive.getValue() == 0) {
						f_addOtherEnergyCarriers_Live(dataObject);
					}
					else {
						f_addOtherEnergyCarriers_LiveDay(dataObject);
					}
				}
			}
			break;
		
		case 2: // Summer
			if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
				f_addElectricityFlowsTrafo_Week(uI_Results.v_gridNode, true);
			}
			else {
				f_addElectricityFlows_Week(dataObject, true);
				if( radio_energyType.getValue() == 1){
					f_addOtherEnergyFlows_Week(dataObject, true);
				}
			}
			break;
			
		case 1: // Winter
			if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
				f_addElectricityFlowsTrafo_Week(uI_Results.v_gridNode, false);
			} else {
				f_addElectricityFlows_Week(dataObject, false);
				if( radio_energyType.getValue() == 1){
					f_addOtherEnergyFlows_Week(dataObject, false);
				}
			}
			break;
			
		case 3: // Year
			if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
				// This graph does not exist, defaulting back to the live plot
				throw new RuntimeException("The Year Graph does not exist for GridNodes.");				
				//radio_period.setValue(0);
				//radio_period_peaks.setValue(0);
				//f_setCharts();
			} else {
				f_addElectricityFlows_Year(dataObject);
				if( radio_energyType.getValue() == 1){
					f_addOtherEnergyFlows_Year(dataObject);
				}
			}
			break;
		
		default:
			throw new RuntimeException("Unrecognized option selected in Period Radio Button for Stack Charts.");	
			//break;
	}
} 
  }

  private void f_addElectricityFlowsTrafo_Live( GridNode GN ) { 

String deliveryCapacityLabel = "Geschatte piek leveringscapaciteit";
String feedinCapacityLabel = "Geschatte piek terugleveringscapaciteit";
Color  deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;
Color  feedinCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;

if(GN.p_realCapacityAvailable){
	deliveryCapacityLabel = "Piek leveringscapaciteit";
	deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_known;
	feedinCapacityLabel = "Piek terugleveringscapaciteit";
	feedinCapacityColor		= uI_Results.v_electricityCapacityColor_known;
}

gr_trafoWeek.setVisible(true);
plot_trafo_week.addDataSet(GN.data_liveCapacityDemand_kW, deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_trafo_week.addDataSet(GN.data_liveCapacitySupply_kW, feedinCapacityLabel, feedinCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_trafo_week.addDataSet(GN.data_liveLoad_kW, "Netto vermogen afname", uI_Results.v_electricityDemandColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1.5, Chart.PointStyle.POINT_NONE);

/*
int maxValue = roundToInt(max(GN.data_liveLoad_kW.getYMax(), GN.v_dataElectricityDeliveryCapacityLiveWeek_kW.getYMax()));
int minValue = roundToInt(min(GN.data_liveLoad_kW.getYMin(), GN.v_dataElectricityFeedInCapacityLiveWeek_kW.getYMin()));
plot_trafo_week.setFixedVerticalScale(minValue + minValue * 0.15, maxValue + maxValue * 0.15);
*/ 
  }

  private void f_addElectricityFlowsTrafo_Week( GridNode GN, boolean isSummerWeek ) { 

String deliveryCapacityLabel = "Geschatte piek leveringscapaciteit";
String feedinCapacityLabel = "Geschatte piek terugleveringscapaciteit";
Color  deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;
Color  feedinCapacityColor		= uI_Results.v_electricityCapacityColor_estimated;

if(GN.p_realCapacityAvailable){
	deliveryCapacityLabel = "Piek leveringscapaciteit";
	deliveryCapacityColor		= uI_Results.v_electricityCapacityColor_known;
	feedinCapacityLabel = "Piek terugleveringscapaciteit";
	feedinCapacityColor		= uI_Results.v_electricityCapacityColor_known;
}

gr_trafoWeek.setVisible(true);

/*
//Add datasets to plot summer week
//double startTime_h = uI_Results.energyModel.p_startOfSummerWeek_h - uI_Results.energyModel.p_runStartTime_h;
plot_trafo_week.addDataSet(uI_Results.f_createFlatDataset(startTime_h, 168, GN.p_capacity_kW), deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_trafo_week.addDataSet(uI_Results.f_createFlatDataset(startTime_h, 168, -GN.p_capacity_kW), feedinCapacityLabel, feedinCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_trafo_week.addDataSet(GN.data_summerWeekLoad_kW, "Netto vermogen afname", uI_Results.v_electricityDemandColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1.5, Chart.PointStyle.POINT_NONE);
*/
//Add datasets to plot peak feedin week
DataSet ds;
if (isSummerWeek) {
	ds = GN.f_getPeakExportWeekDataSet(uI_Results.energyModel.p_timeParameters);
} else {
	ds = GN.f_getPeakImportWeekDataSet(uI_Results.energyModel.p_timeParameters);
}

plot_trafo_week.addDataSet(ds, "Netto vermogen afname", uI_Results.v_electricityDemandColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1.5, Chart.PointStyle.POINT_NONE);
plot_trafo_week.addDataSet(uI_Results.f_createFlatDataset(ds.getXMin(), 168, GN.p_capacity_kW), deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_trafo_week.addDataSet(uI_Results.f_createFlatDataset(ds.getXMin(), 168, -GN.p_capacity_kW), feedinCapacityLabel, feedinCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);



/*
int maxValue = roundToInt(max(GN.v_dataElectricityBaseloadConsumptionSummerWeek_kW.getYMax(), GN.p_capacity_kW));
int minValue = roundToInt(min(GN.v_dataElectricityBaseloadConsumptionSummerWeek_kW.getYMin(), -GN.p_capacity_kW));
plot_trafo_week.setFixedVerticalScale(minValue + minValue * 0.15, maxValue + maxValue * 0.15);
*/ 
  }

  void f_addElectricityNetLoad_Live( I_EnergyData dataObject ) { 

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

//Add datasets to plot
plot_netload_week.addDataSet(dataObject.getLiveData().data_gridCapacityDemand_kW, deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_netload_week.addDataSet(dataObject.getLiveData().data_gridCapacitySupply_kW, feedinCapacityLabel, feedinCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_netload_week.addDataSet(dataObject.getLiveData().data_liveElectricityBalance_kW, "Netto vermogen", uI_Results.v_electricityDemandColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 4.0, Chart.PointStyle.POINT_NONE);

//Specific coop plot additions
if (dataObject.getScope() == OL_ResultScope.ENERGYCOOP ) {

	if(uI_Results.b_showGroupContractValues) {
		//plot_netload_week.addDataSet(uI_Results.v_dataEHubDeliveryCapacityLiveWeek_kW, "Groeps GTV afname (Rekenmethode Stedin)", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		//plot_netload_week.addDataSet(uI_Results.v_dataEHubFeedInCapacityLiveWeek_kW, "Groeps GTV teruglevering (Rekenmethode Stedin)", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
	}
	if (b_subdivideEnergyCoopFlows) {
		List<GridConnection> memberGridConnections = ((EnergyCoop)dataObject).f_getAllChildMemberGridConnections();
		for (GridConnection GC : memberGridConnections) {
			plot_netload_week.addDataSet(GC.getLiveData().data_liveElectricityBalance_kW, GC.p_gridConnectionID, blue, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1.5, Chart.PointStyle.POINT_NONE);
		}
	}
}

/*
int maxValue = roundToInt(max(dataObject.v_dataNetLoadLiveWeek_kW.getYMax(), dataObject.v_dataElectricityDeliveryCapacityLiveWeek_kW.getYMax()));
int minValue = roundToInt(min(dataObject.v_dataNetLoadLiveWeek_kW.getYMin(), dataObject.v_dataElectricityFeedInCapacityLiveWeek_kW.getYMin()));
plot_netload_week.setFixedVerticalScale(minValue + minValue * 0.3, maxValue + maxValue * 0.3);
*/
gr_netLoadWeek.setVisible(true); 
  }

  void f_addElectricityNetLoad_Week( I_EnergyData dataObject, boolean isSummerWeek ) { 

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

//Specific coop plot additions
if (dataObject.getScope() == OL_ResultScope.ENERGYCOOP ) {

	if(uI_Results.b_showGroupContractValues) {
		plot_netload_week.addDataSet(uI_Results.f_createFlatDataset(startTime_h, 168, ((EnergyCoop)dataObject).f_getGroupContractDeliveryCapacity_kW(dataObject.getRapidRunData(), uI_Results.energyModel.p_timeParameters)), "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		plot_netload_week.addDataSet(uI_Results.f_createFlatDataset(startTime_h, 168, ((EnergyCoop)dataObject).f_getGroupContractFeedinCapacity_kW(dataObject.getRapidRunData(), uI_Results.energyModel.p_timeParameters)), "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
	}
	if (b_subdivideEnergyCoopFlows) {
		List<GridConnection> memberGridConnections = ((EnergyCoop)dataObject).f_getAllChildMemberGridConnections();
		for (GridConnection GC : memberGridConnections) {
			plot_netload_week.addDataSet(GC.v_rapidRunData.am_summerWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(uI_Results.energyModel.p_timeParameters.getStartOfSummerWeek_h()), GC.p_gridConnectionID, blue, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1.5, Chart.PointStyle.POINT_NONE);
		}
	}
}

/*
//Set vertical scale
int maxValue = roundToInt(max(dataObject.v_dataNetLoadSummerWeek_kW.getYMax(), dataObject.v_gridCapacityDelivery_kW));
int minValue = roundToInt(min(dataObject.v_dataNetLoadSummerWeek_kW.getYMin(), -dataObject.v_gridCapacityFeedIn_kW));
plot_netload_week.setFixedVerticalScale(minValue + minValue * 0.15, maxValue + maxValue * 0.15);
*/
gr_netLoadWeek.setVisible(true);
 
  }

  private void f_addOtherEnergyCarriers_LiveDay( I_EnergyData dataObject ) { 

EnumSet<OL_EnergyCarriers> activeConsumptionEnergyCarriers = EnumSet.copyOf(dataObject.getLiveData().activeConsumptionEnergyCarriers);
EnumSet<OL_EnergyCarriers> activeProductionEnergyCarriers = EnumSet.copyOf(dataObject.getLiveData().activeProductionEnergyCarriers);

activeConsumptionEnergyCarriers.remove( OL_EnergyCarriers.ELECTRICITY );
activeProductionEnergyCarriers.remove( OL_EnergyCarriers.ELECTRICITY );

for (OL_EnergyCarriers EC_consumption : activeConsumptionEnergyCarriers) {
	if(EC_consumption != OL_EnergyCarriers.HEAT){
		energyDemandChartDay.addDataSet( dataObject.getLiveData().dsm_liveDemand_kW.get(EC_consumption), uI_Results.f_getECName(EC_consumption), uI_Results.cm_consumptionColors.get(EC_consumption)); 
	}
	else if(dataObject.getLiveData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW)){//Only heat import, not all consumption (part of gas, elec, etc. already)
		energyDemandChartDay.addDataSet( dataObject.getLiveData().dsm_liveAssetFlows_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW), "Warmte net", uI_Results.cm_consumptionColors.get(EC_consumption)); 
	}
}


for (OL_EnergyCarriers EC_production : activeProductionEnergyCarriers) {
	if(EC_production != OL_EnergyCarriers.HEAT){
		energySupplyChartDay.addDataSet( dataObject.getLiveData().dsm_liveSupply_kW.get(EC_production), uI_Results.f_getECName(EC_production), uI_Results.cm_productionColors.get(EC_production));  
	}
	else if(dataObject.getLiveData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW)){
		energySupplyChartDay.addDataSet( dataObject.getLiveData().dsm_liveAssetFlows_kW.get(OL_AssetFlowCategories.ptProductionHeat_kW), "PT", uI_Results.cm_productionColors.get(EC_production));
	}
}
 
  }

  private void f_addElectricityFlows_LiveDay( I_EnergyData dataObject ) { 

//Set speed to slower.
getExperimentHost().setSpeed(5);

gr_day.setVisible(true);


if (uI_Results.v_selectedObjectScope == OL_ResultScope.ENERGYCOOP && b_subdivideEnergyCoopFlows) {
	List<Color> colorSpectrum = new ArrayList<>();
	List<GridConnection> memberGridConnections = ((EnergyCoop)dataObject).f_getAllChildMemberGridConnections();
	
	for (int k = 0; k < memberGridConnections.size(); k++) {
	    colorSpectrum.add(UtilitiesColor.spectrumColor(k, memberGridConnections.size()).darker());
		energyDemandChartDay.addDataSet(memberGridConnections.get(k).getLiveData().dsm_liveDemand_kW.get(OL_EnergyCarriers.ELECTRICITY), memberGridConnections.get(k).p_ownerID, colorSpectrum.get(k));
		energySupplyChartDay.addDataSet(memberGridConnections.get(k).getLiveData().dsm_liveSupply_kW.get(OL_EnergyCarriers.ELECTRICITY), memberGridConnections.get(k).p_ownerID, colorSpectrum.get(k));	
	}
}
else{
	for (OL_AssetFlowCategories AC : dataObject.getLiveData().assetsMetaData.activeAssetFlows) {
		if (uI_Results.v_electricAssetFlows.contains(AC)) {
			if (uI_Results.v_consumptionAssetFlows.contains(AC)) {
				energyDemandChartDay.addDataSet(dataObject.getLiveData().dsm_liveAssetFlows_kW.get(AC), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
			} else {
				energySupplyChartDay.addDataSet(dataObject.getLiveData().dsm_liveAssetFlows_kW.get(AC), uI_Results.lm_assetFlowLabels.get(AC), get_UI_Results().cm_assetFlowColors.get(AC));
			}
		}
	}
} 
  }

  private void f_addElectricityFlowsTrafo_LiveDay( GridNode GN ) { 

gr_trafoDay.setVisible(true);

String deliveryCapacityLabel = "Geschatte piek leveringscapaciteit";
String feedinCapacityLabel = "Geschatte piek terugleveringscapaciteit";
Color  deliveryCapacityColor = uI_Results.v_electricityCapacityColor_estimated;
Color  feedinCapacityColor = uI_Results.v_electricityCapacityColor_estimated;

if(GN.p_realCapacityAvailable){
	deliveryCapacityLabel = "Piek leveringscapaciteit";
	deliveryCapacityColor = uI_Results.v_electricityCapacityColor_known;
	feedinCapacityLabel = "Piek terugleveringscapaciteit";
	feedinCapacityColor = uI_Results.v_electricityCapacityColor_known;
}

plot_trafo_day.addDataSet(GN.data_liveCapacityDemand_kW, deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_trafo_day.addDataSet(GN.data_liveCapacitySupply_kW, feedinCapacityLabel, feedinCapacityColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_trafo_day.addDataSet(GN.data_liveLoad_kW, "Netto vermogen afname", uI_Results.v_electricityDemandColor,true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1.5, Chart.PointStyle.POINT_NONE);

/*
// TODO: Change these to only look at the day instead of the week?
int maxValue = roundToInt(max(GN.v_dataElectricityBaseloadConsumptionLiveWeek_kW.getYMax(), GN.v_dataElectricityDeliveryCapacityLiveWeek_kW.getYMax()));
int minValue = roundToInt(min(GN.v_dataElectricityBaseloadConsumptionLiveWeek_kW.getYMin(), GN.v_dataElectricityFeedInCapacityLiveWeek_kW.getYMin()));
plot_trafo_day.setFixedVerticalScale(minValue + minValue * 0.15, maxValue + maxValue * 0.15);
*/ 
  }

  void f_addElectricityNetLoad_LiveDay( I_EnergyData dataObject ) { 

String deliveryCapacityLabel = "Geschatte piek leveringscapaciteit";
String feedinCapacityLabel = "Geschatte piek terugleveringscapaciteit";
Color  deliveryCapacityColor = uI_Results.v_electricityCapacityColor_estimated;
Color  feedinCapacityColor = uI_Results.v_electricityCapacityColor_estimated;

if(dataObject.getLiveData().connectionMetaData.getContractedDeliveryCapacityKnown()){
	deliveryCapacityLabel = "Piek leveringscapaciteit";
	deliveryCapacityColor = uI_Results.v_electricityCapacityColor_known;
}
if(dataObject.getLiveData().connectionMetaData.getContractedFeedinCapacityKnown()){
	feedinCapacityLabel = "Piek terugleveringscapaciteit";
	feedinCapacityColor	= uI_Results.v_electricityCapacityColor_known;
}

//Add datasets to plot
plot_netload_day.addDataSet(dataObject.getLiveData().data_gridCapacityDemand_kW, deliveryCapacityLabel, deliveryCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_netload_day.addDataSet(dataObject.getLiveData().data_gridCapacitySupply_kW, feedinCapacityLabel, feedinCapacityColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
plot_netload_day.addDataSet(dataObject.getLiveData().data_liveElectricityBalance_kW, "Netto vermogen", uI_Results.v_electricityDemandColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 4.0, Chart.PointStyle.POINT_NONE);

//Specific coop plot additions
if (dataObject.getScope() == OL_ResultScope.ENERGYCOOP ) {

	if(uI_Results.b_showGroupContractValues) {
		//plot_netload_day.addDataSet(uI_Results.v_dataEHubDeliveryCapacityLiveWeek_kW, "Groeps GTV afname", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);
		//plot_netload_day.addDataSet(uI_Results.v_dataEHubFeedInCapacityLiveWeek_kW, "Groeps GTV teruglevering", uI_Results.v_groupGTVColor, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1, Chart.PointStyle.POINT_NONE);	
	}
	if (b_subdivideEnergyCoopFlows) {
		List<GridConnection> memberGridConnections = ((EnergyCoop)dataObject).f_getAllChildMemberGridConnections();
		for (GridConnection GC : memberGridConnections) {
			plot_netload_day.addDataSet(GC.getLiveData().data_liveElectricityBalance_kW, GC.p_gridConnectionID, blue, true, false, Chart.InterpolationType.INTERPOLATION_LINEAR, 1.5, Chart.PointStyle.POINT_NONE);
		}
	}
}

/*
int maxValue = roundToInt(max(dataObject.v_dataNetLoadLiveWeek_kW.getYMax(), dataObject.v_dataElectricityDeliveryCapacityLiveWeek_kW.getYMax()));
int minValue = roundToInt(min(dataObject.v_dataNetLoadLiveWeek_kW.getYMin(), dataObject.v_dataElectricityFeedInCapacityLiveWeek_kW.getYMin()));
plot_netload_day.setFixedVerticalScale(minValue + minValue * 0.3, maxValue + maxValue * 0.3);
*/
gr_netLoadDay.setVisible(true); 
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

  void f_createExport(  ) { 

traceln("Start writing Electricity Load Balance data to excel!");
pauseSimulation();
gr_loadingScreen.setVisible(true);

new Thread( () -> {
	f_deletePreviousExcel();
	
	try {
	    // 1. Generate unique filename
	    String newFilename = "Export_ModelData_" + 
	        new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date()) + ".xlsx";
		
	    // 2. Get data
	    Map<String, Map<String, double[]>> map_exportData =  new HashMap<>();
	    if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE){
			map_exportData = f_getGridNodeExportMap();
	    }
	    else{
			map_exportData = f_getEnergyDataExportMap();
	    }
	
	    // 4. Create workbook and sheet
	    XSSFWorkbook wb = new XSSFWorkbook();

	
	    // 5. Create sheet for each object and write data rows
	    for(String objectName : map_exportData.keySet()){
	    	
	    	//5.a Initialize sheet
	    	XSSFSheet sheet = wb.createSheet(objectName);
	    	XSSFRow header = sheet.createRow(0);
			
			//5.b Seperate the timeStep_h profiles from daily average profiles
			List<String> timeStepProfileNames = new ArrayList<>();
			List<String> dailyAverageProfileNames = new ArrayList<>();
			for(String dataArrayName : map_exportData.get(objectName).keySet() ){
		    	if(dataArrayName.startsWith(f_getProfileTypeName(24))){
		    		dailyAverageProfileNames.add(dataArrayName);
		    	}
		    	else{
		    		timeStepProfileNames.add(dataArrayName);
		    	}
		    }
			
			//Initialize column number
			int dataColumnNumber = 0; 
			
			////5.c First create date column with size of timeStep_h
			if(timeStepProfileNames.size()>0){
				//Create date column
			    int totalRowsBalance = roundToInt(uI_Results.energyModel.p_timeParameters.getRunDuration_h()/uI_Results.energyModel.p_timeParameters.getTimeStep_h());
				
			    header.createCell(dataColumnNumber).setCellValue("Datum");
	    		for (int i = 0; i < totalRowsBalance; i++) {
			        XSSFRow row = sheet.createRow(i + 1);
			        row.createCell(dataColumnNumber).setCellValue(f_getDate_ISO8601(i));
		        }
		        //Increase data column number
		        dataColumnNumber++;
		        
		        //Create timeStep profile data columns
			    for(String dataArrayName : timeStepProfileNames){
			    	if(dataArrayName.startsWith(f_getProfileTypeName(24))){
			    		dailyAverageProfileNames.add(dataArrayName);
			    		continue;
			    	}
				    header.createCell(dataColumnNumber).setCellValue(dataArrayName);
				    double[] dataArray = map_exportData.get(objectName).get(dataArrayName);
				    for (int i = 0; i < dataArray.length; i++) {
				        XSSFRow row = sheet.getRow(i + 1);
				        row.createCell(dataColumnNumber).setCellValue(dataArray[i]);
				    }
					dataColumnNumber++;
				}
				
				//Create empty columns if daily average profiles are exported aswell
				if(dailyAverageProfileNames.size()>0){
					dataColumnNumber++;
					dataColumnNumber++;
				}
			}
			
			////5.d Create the daily average date and data columns
			if(dailyAverageProfileNames.size()>0){
				int totalDays = roundToInt(uI_Results.energyModel.p_timeParameters.getRunDuration_h()/24.0);
	
				//Create date column
				header.createCell(dataColumnNumber).setCellValue("Datum");
				if(timeStepProfileNames.size()>0){
					for (int i = 0; i < totalDays; i++) {
				        XSSFRow row = sheet.getRow(i + 1);
				        row.createCell(dataColumnNumber).setCellValue(f_getDate_days(i));
			        }
		        }
		        else{
		        	for (int i = 0; i < totalDays; i++) {
				        XSSFRow row = sheet.createRow(i + 1);
				        row.createCell(dataColumnNumber).setCellValue(f_getDate_days(i));
			        }
		        }
		        //Increase column number
		        dataColumnNumber++;
		        
		        //Add daily average profiles
			    for(String dataArrayName : dailyAverageProfileNames ){
				    header.createCell(dataColumnNumber).setCellValue(dataArrayName);
				    double[] dataArray = map_exportData.get(objectName).get(dataArrayName);
				    for (int i = 0; i < dataArray.length; i++) {
				        XSSFRow row = sheet.getRow(i + 1);
				        row.createCell(dataColumnNumber).setCellValue(dataArray[i]);
				    }
					dataColumnNumber++;
				}
			}
	    }
	
	    // 6. Save file
	    FileOutputStream fos = new FileOutputStream(newFilename);
	    wb.write(fos);
	    fos.close();
	    wb.close();
	    traceln("Finished writing Electricity Load Balance data to excel!");
	
	    // 7. Create download link
	    traceln("Creating download link for the excel...");
	    String urlForExcelDownload = TemporaryFileRepository.builder().build().createTemporaryDownloadLink(Path.of(newFilename));
	    this.getExperimentHost().openWebSite(urlForExcelDownload);
	    traceln("Finished creating download link for the excel.");
	
	} catch(Exception e){
	    traceln("Failed writing file: " + e.getMessage());
	    e.printStackTrace();
	}
	gr_loadingScreen.setVisible(false);
	runSimulation();
}).start();

 
  }

  void f_deletePreviousExcel(  ) { 


File folder = new File(".");
for(File f : folder.listFiles()){
    if(f.getName().startsWith("Export_ModelData_") && f.getName().endsWith(".xlsx")){
        f.delete();
        traceln("Deleted old file: " + f.getName());
    }
} 
  }

  
Map<String, Map<String, double[]>> 
 f_getEnergyDataExportMap(  ) { 

Map<String, Map<String, double[]>> map_exportData =  new LinkedHashMap<>(); // Linked hashmap to preserve insertion order
I_EnergyData dataObject = uI_Results.f_getSelectedObjectData();
String selectedObjectName;
if(dataObject instanceof GridConnection gc){
	int connectionOwnerGCNumber =  gc.p_owner.f_getOwnedGridConnections().indexOf(gc) + 1;
	String objectAddress = gc.p_address != null ? gc.p_address.getAddress() : "";
    selectedObjectName = gc.p_ownerID + ", " + objectAddress;
    map_exportData.put(selectedObjectName, f_getEnergyDataObjectExportMap(dataObject));
}
else if(dataObject instanceof EnergyCoop coop){
    selectedObjectName = "Totaal van groep aansluitingen";
    map_exportData.put(selectedObjectName, f_getEnergyDataObjectExportMap(dataObject));
    if(checkbox_exportPerGCCoop.isSelected()){
    	List<String> currentSheetNames = new ArrayList<>();//No duplicate (sheets max length 31 char) allowed! : So to keep track, and prevent duplicates this list is used
	    for(GridConnection memberGC : coop.f_getAllChildMemberGridConnections()){
			String objectAddress = memberGC.p_address != null ? memberGC.p_address.getAddress() : "";
	    	String prefferedMemberGCName = memberGC.p_ownerID + ", " + objectAddress;
	    	String actualMemberGCName = prefferedMemberGCName.length() > 28 ? prefferedMemberGCName.substring(0, 28) : prefferedMemberGCName; // Cut off at 28 char always.
	    	if(currentSheetNames.contains(actualMemberGCName)){
	    		String defaultActualMemberGCName = actualMemberGCName;
	    		int currentNrOfSheetsWithSameName = findAll(currentSheetNames, str -> str.startsWith(defaultActualMemberGCName)).size();
	    		actualMemberGCName += "(" + currentNrOfSheetsWithSameName + ")"; // Adds three more char -> 28 + 3 = 31 total = limit sheet name length
	    	}
	    	currentSheetNames.add(actualMemberGCName);
	    	map_exportData.put(actualMemberGCName, f_getEnergyDataObjectExportMap(memberGC));
	    }
    }
}
else{
    selectedObjectName = "Totaal van gebied";
    map_exportData.put(selectedObjectName, f_getEnergyDataObjectExportMap(dataObject));
}

return map_exportData; 
  }

  
Map<String, Map<String, double[]>> 
 f_getGridNodeExportMap(  ) { 

Map<String, Map<String, double[]>> map_exportData =  new LinkedHashMap<>();
String selectedObjectName = "Trafo " + uI_Results.v_gridNode.p_gridNodeID;
Map<String, double[]> map_ObjectExportData =  new LinkedHashMap<>();

//GridNode data is always in timesteps of p_timeStep_h!
String profileTypeName = f_getProfileTypeName(uI_Results.energyModel.p_timeParameters.getTimeStep_h()); 
double arrayUnitScalingFactor = p_selectedExportUnit.equals("kWh") ? uI_Results.energyModel.p_timeParameters.getTimeStep_h() : 1;
if(c_selectedExportEC.contains(OL_EnergyCarriers.ELECTRICITY) && uI_Results.v_gridNode.p_energyCarrier == OL_EnergyCarriers.ELECTRICITY){
	map_ObjectExportData.put(profileTypeName + uI_Results.f_getECName(OL_EnergyCarriers.ELECTRICITY) + " profiel [" + p_selectedExportUnit + "]", ZeroMath.arrayMultiply(uI_Results.v_gridNode.acc_annualElectricityBalance_kW.getTimeSeries_kW(), arrayUnitScalingFactor));
}
if(c_selectedExportEC.contains(OL_EnergyCarriers.HEAT) && uI_Results.v_gridNode.p_energyCarrier == OL_EnergyCarriers.HEAT){
	map_ObjectExportData.put(profileTypeName + uI_Results.f_getECName(OL_EnergyCarriers.HEAT) + " profiel [" + p_selectedExportUnit + "]", ZeroMath.arrayMultiply(uI_Results.v_gridNode.acc_annualHeatBalance_kW.getTimeSeries_kW(), arrayUnitScalingFactor));
}


map_exportData.put(selectedObjectName, map_ObjectExportData);
return map_exportData; 
  }

  
Map<String, double[]> 
 f_getEnergyDataObjectExportMap( I_EnergyData dataObject ) { 

Map<String, double[]> map_ObjectExportData =  new LinkedHashMap<>();
double timeStep_h = uI_Results.energyModel.p_timeParameters.getTimeStep_h();

double arrayUnitScalingFactor = p_selectedExportUnit.equals("kWh") ? uI_Results.energyModel.p_timeParameters.getTimeStep_h() : 1;

for(OL_EnergyCarriers EC : c_selectedExportEC){
	if(dataObject.getRapidRunData().activeEnergyCarriers.contains(EC)){
		if(EC == OL_EnergyCarriers.ELECTRICITY){ // First do all the assetFlow categories
			for(OL_AssetFlowCategories AC : c_selectedExportAC){
				if(uI_Results.v_electricAssetFlows.contains(AC) && dataObject.getRapidRunData().assetsMetaData.activeAssetFlows.contains(AC)){
					String profileTypeNameAC = f_getProfileTypeName(dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AC).getSignalResolution_h()); 
					map_ObjectExportData.put(profileTypeNameAC + uI_Results.lm_assetFlowLabels.get(AC) + " profiel [" + p_selectedExportUnit + "]", ZeroMath.arrayMultiply(dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(AC).getTimeSeries_kW().clone(), arrayUnitScalingFactor));
				}
			}
		}
		if(EC == OL_EnergyCarriers.HEAT){ //Only export district heat delivery
			if(uI_Results.v_electricAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW) && dataObject.getRapidRunData().assetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.districtHeatDelivery_kW)){
				String profileTypeNameAC = f_getProfileTypeName(dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getSignalResolution_h()); 
				map_ObjectExportData.put(profileTypeNameAC + uI_Results.lm_assetFlowLabels.get(OL_AssetFlowCategories.districtHeatDelivery_kW) + " profiel [" + p_selectedExportUnit + "]", ZeroMath.arrayMultiply(dataObject.getRapidRunData().am_assetFlowsAccumulators_kW.get(OL_AssetFlowCategories.districtHeatDelivery_kW).getTimeSeries_kW().clone(), arrayUnitScalingFactor));
			}
		}
		else{
			String profileTypeName = f_getProfileTypeName(dataObject.getRapidRunData().am_totalBalanceAccumulators_kW.get(EC).getSignalResolution_h()); 
			map_ObjectExportData.put(profileTypeName + uI_Results.f_getECName(EC) + " profiel [" + p_selectedExportUnit + "]", ZeroMath.arrayMultiply(dataObject.getRapidRunData().am_totalBalanceAccumulators_kW.get(EC).getTimeSeries_kW().clone(), arrayUnitScalingFactor));
		}
	}
}

return map_ObjectExportData; 
  }

  void f_reorderSelectedExportEC(  ) { 

c_selectedExportEC.sort((a, b) -> 
    uI_Results.c_defaultOrderEC.indexOf(a) - uI_Results.c_defaultOrderEC.indexOf(b)
); 
  }

  void f_reorderSelectedExportAC(  ) { 

c_selectedExportAC.sort((a, b) -> 
    uI_Results.c_defaultOrderAC.indexOf(a) - uI_Results.c_defaultOrderAC.indexOf(b)
); 
  }

  
String 
 f_getDate_ISO8601( int timeStepsElapsed ) { 

Date startDate = getExperiment().getEngine().getStartDate();
long startDateUnixTime_ms = startDate.getTime();
long runtime_ms = (long) (timeStepsElapsed * uI_Results.energyModel.p_timeParameters.getTimeStep_h() * 60 * 60 * 1000);
Date date = new Date();
date.setTime(startDateUnixTime_ms + runtime_ms);

SimpleDateFormat formatter = new SimpleDateFormat();
formatter.applyPattern("yyyy-MM-dd'T'HH:mmXXX"); // ISO standaard 8601 (ss (seconden) weggelaten)

return formatter.format(date); 
  }

  
String 
 f_getDate_days( int elapsedDays ) { 

double numberOfTimeStepsInADay = 24.0/uI_Results.energyModel.p_timeParameters.getTimeStep_h();


Date startDate = getExperiment().getEngine().getStartDate();
long startDateUnixTime_ms = startDate.getTime();
long runtime_ms = (long) (elapsedDays*numberOfTimeStepsInADay * uI_Results.energyModel.p_timeParameters.getTimeStep_h() * 60 * 60 * 1000);
Date date = new Date();
date.setTime(startDateUnixTime_ms + runtime_ms);

SimpleDateFormat formatter = new SimpleDateFormat();
formatter.applyPattern("yyyy-MM-dd");

return formatter.format(date); 
  }

  
String 
 f_getProfileTypeName( double profileSignalResolution_h ) { 

if(profileSignalResolution_h == uI_Results.energyModel.p_timeParameters.getTimeStep_h()){
	return "Netto ";
}
else if(profileSignalResolution_h == 24){
	return "Dag gemiddeld ";
}
else{
	throw new RuntimeException("Unsupported profile size found!!");
} 
  }

  void f_initializeExportButtons(  ) { 

//Get EC and AC options
Set<OL_EnergyCarriers> energyCarriers = new HashSet<>();
Set<OL_AssetFlowCategories> assetFlows = new HashSet<>();

if (uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE) {
	if(uI_Results.v_gridNode.p_energyCarrier == OL_EnergyCarriers.ELECTRICITY){
		energyCarriers.add(OL_EnergyCarriers.ELECTRICITY);		
	}
	else if(uI_Results.v_gridNode.p_energyCarrier == OL_EnergyCarriers.HEAT){
		energyCarriers.add(OL_EnergyCarriers.HEAT);
	}
}
else{
	I_EnergyData data = uI_Results.f_getSelectedObjectData();
	energyCarriers.addAll(data.getRapidRunData().activeEnergyCarriers);
	assetFlows.addAll(data.getRapidRunData().assetsMetaData.activeAssetFlows);
	
	if(energyCarriers.contains(OL_EnergyCarriers.HEAT)){
		energyCarriers.remove(OL_EnergyCarriers.HEAT); // Heat can only be exported if district heating, which is flow in AC.
	}
}

//Activate all check box buttons initially, and select the ones that are selected according to the c_includeAssetSelection
map_ECToCheckBox.values().forEach(cb -> cb.setEnabled(true));	
for(OL_EnergyCarriers EC : c_selectedExportEC){ // Set all current 'includedAssetSelection' to 'checked', without calling action.
	map_ECToCheckBox.get(EC).setSelected(true, false);
}

//EC is not present: disable and deselect the checkbox (without calling action).
for(OL_EnergyCarriers EC : map_ECToCheckBox.keySet()){
	if(!energyCarriers.contains(EC)){ 
		map_ECToCheckBox.get(EC).setEnabled(false);
		map_ECToCheckBox.get(EC).setSelected(false, false);	
	}
}

//Activate all check box buttons initially, and select the ones that are selected according to the c_includeAssetSelection
map_ACToCheckBox.values().forEach(cb -> cb.setEnabled(true));	
for(OL_AssetFlowCategories AC : c_selectedExportAC){ // Set all current 'includedAssetSelection' to 'checked', without calling action.
	map_ACToCheckBox.get(AC).setSelected(true, false);
}

//AC is not present: disable and deselect the checkbox (without calling action).
for(OL_AssetFlowCategories AC : map_ACToCheckBox.keySet()){
	if(!assetFlows.contains(AC)){ 
		map_ACToCheckBox.get(AC).setEnabled(false);
		map_ACToCheckBox.get(AC).setSelected(false, false);	
	}
} 
  }

  void f_enableExportButton( boolean enable ) { 

gr_exportMenuButton.setVisible(enable);
gr_exportMenuButtonDisabled.setVisible(!enable); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_periodIncludingYear_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_periodPeaksIncludingYear_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _radio_energyType_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _radio_periodLive_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_subdivideEnergyCoopFlows_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_periodExcludingYear_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_periodPeaksExcludingYear_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_electricity_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_hydrogen_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_fuel_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_heat_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_methane_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_exportPerGCCoop_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_baseLoad_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_PV_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_vehicleCharging_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_wind_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_battery_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_elecCooking_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_electricityForHeating_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_v2g_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_electricityForH2_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_aircos_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_exportDieselGen_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_exportMethaneGen_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_exportFuelCell_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_exportCHP_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_exportUnit_Font = _rb_periodIncludingYear_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energieAanbod2_Font = new Font("Calibri", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energieVraag6_Font = _t_energieAanbod2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_weekProfile_ylabel2_Font = new Font("Calibri", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_weekProfile_ylabel3_Font = _t_weekProfile_ylabel2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energieAanbod1_Font = _t_energieAanbod2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energieVraag1_Font = _t_energieAanbod2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_weekProfile_ylabel_Font = _t_weekProfile_ylabel2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_weekProfile_ylabel1_Font = _t_weekProfile_ylabel2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energieAanbod3_Font = _t_energieAanbod2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energieVraag9_Font = _t_energieAanbod2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_weekProfile_ylabel4_Font = _t_weekProfile_ylabel2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_weekProfile_ylabel5_Font = _t_weekProfile_ylabel2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energieVraag7_Font = _t_energieAanbod2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_weekProfileTrafo_ylabel2_Font = _t_weekProfile_ylabel2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energieVraag2_Font = _t_energieAanbod2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_weekProfileTrafo_ylabel_Font = _t_weekProfile_ylabel2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energieVraag8_Font = _t_energieAanbod2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_weekProfileTrafo_ylabel3_Font = _t_weekProfile_ylabel2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_energieVraag4_Font = _t_energieAanbod2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_weekProfileTrafo_ylabel1_Font = _t_weekProfile_ylabel2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_writeToExcelFunctions_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_exportButton_Font = new Font("SansSerif", 1, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_exportEC_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_exportAC_Font = _txt_exportEC_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_configureExport_Font = new Font("SansSerif", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_exportUnit_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_exportExcelIsCreated_Font = _txt_configureExport_Font;
  protected static final Color _rect_exportButton_Fill_Color = new Color( 0xFF007E84, true );
  protected static final Color _rect_exportButton_Line_Color = new Color( 0xFFC1E6E6, true );
  protected static final Color _rect_exportMenuButton_Fill_Color = new Color( 0xFF007E84, true );
  protected static final Color _rect_exportMenuButton_Line_Color = new Color( 0xFFC1E6E6, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_radioButtons = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energieAanbod2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energieVraag6 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_weekProfile_ylabel2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_weekProfile_ylabel3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_consumptionDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_productionDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_day = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energieAanbod1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energieVraag1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_weekProfile_ylabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_weekProfile_ylabel1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_consumptionWeek = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_productionWeek = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energieAanbod3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energieVraag9 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_weekProfile_ylabel4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_weekProfile_ylabel5 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_consumptionYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_productionYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_year = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energieVraag7 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_weekProfileTrafo_ylabel2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_trafoDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_trafoDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energieVraag2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_weekProfileTrafo_ylabel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_trafoWeek = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_trafoWeek = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energieVraag8 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_weekProfileTrafo_ylabel3 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_netLoadDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_netLoadDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_energieVraag4 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_weekProfileTrafo_ylabel1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_netLoadWeek = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_netLoadWeek = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_exportToExcelFunctions = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_writeToExcelFunctions = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_exportMenu = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_exportButton = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_exportButton = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_exportButton = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_exportButtons = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_exportEC = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_exportAC = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_exportAssetFlows = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_configureExport = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_exportUnit = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_exportUnit = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_exportMenu = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_loadingScreen = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_loadIcon = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_exportExcelIsCreated = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_loadingScreen = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_exportMenuButton1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_exportMenuButton1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_exportMenuButtonDisabled = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_exportMenuButton = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _image_exportMenuButton = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_exportMenuButton = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _energyDemandChartDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _energySupplyChartDay = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _energyDemandChart = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _energySupplyChart = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _energyDemandChartYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _energySupplyChartYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_trafo_day = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_trafo_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_netload_day = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot_netload_week = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_periodIncludingYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_periodPeaksIncludingYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio_energyType = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio_periodLive = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 76;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_subdivideEnergyCoopFlows = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 77;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_periodExcludingYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 78;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_periodPeaksExcludingYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 79;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_electricity = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 80;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_hydrogen = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 81;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_fuel = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 82;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_heat = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 83;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_methane = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 84;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_exportPerGCCoop = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 85;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_baseLoad = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 86;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_PV = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 87;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_vehicleCharging = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 88;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_wind = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 89;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_battery = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 90;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_elecCooking = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 91;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_electricityForHeating = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 92;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_v2g = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 93;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_electricityForH2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 94;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_aircos = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 95;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_exportDieselGen = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 96;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_exportMethaneGen = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 97;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_exportFuelCell = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 98;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox_exportCHP = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 99;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_exportUnit = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 100;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 101;

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
	  level.addAll(rect_radioButtons, rb_periodIncludingYear, rb_periodPeaksIncludingYear, radio_energyType, radio_periodLive, gr_day, gr_week, gr_year, gr_trafoDay, gr_trafoWeek, gr_netLoadDay, gr_netLoadWeek, cb_subdivideEnergyCoopFlows, rb_periodExcludingYear, rb_periodPeaksExcludingYear, rect_exportToExcelFunctions, txt_writeToExcelFunctions, gr_exportMenu, gr_loadingScreen, gr_exportMenuButtonDisabled, gr_exportMenuButton);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_consumptionDay:
        if (true) {
          ShapeImage self = this.i_consumptionDay;
          
uI_Results.f_setInfoText(i_consumptionDay, uI_Results.v_infoText.consumption, i_consumptionDay.getX() + gr_day.getX(), i_consumptionDay.getY() + gr_day.getY()); 
        }
        break;
      case _i_productionDay:
        if (true) {
          ShapeImage self = this.i_productionDay;
          
uI_Results.f_setInfoText(i_productionDay, uI_Results.v_infoText.production, i_productionDay.getX() + gr_day.getX(), i_productionDay.getY() + gr_day.getY()); 
        }
        break;
      case _i_consumptionWeek:
        if (true) {
          ShapeImage self = this.i_consumptionWeek;
          
uI_Results.f_setInfoText(i_consumptionWeek, uI_Results.v_infoText.consumption, i_consumptionWeek.getX() + gr_week.getX(), i_consumptionWeek.getY() + gr_week.getY()); 
        }
        break;
      case _i_productionWeek:
        if (true) {
          ShapeImage self = this.i_productionWeek;
          
uI_Results.f_setInfoText(i_productionWeek, uI_Results.v_infoText.production, i_productionWeek.getX() + gr_week.getX(), i_productionWeek.getY() + gr_week.getY()); 
        }
        break;
      case _i_consumptionYear:
        if (true) {
          ShapeImage self = this.i_consumptionYear;
          
uI_Results.f_setInfoText(i_consumptionYear, uI_Results.v_infoText.consumptionYear, i_consumptionYear.getX() + gr_year.getX(), i_consumptionYear.getY() + gr_year.getY()); 
        }
        break;
      case _i_productionYear:
        if (true) {
          ShapeImage self = this.i_productionYear;
          
uI_Results.f_setInfoText(i_productionYear, uI_Results.v_infoText.productionYear, i_productionYear.getX() + gr_year.getX(), i_productionYear.getY() + gr_year.getY()); 
        }
        break;
      case _i_trafoDay:
        if (true) {
          ShapeImage self = this.i_trafoDay;
          
uI_Results.f_setInfoText(i_trafoDay, uI_Results.v_infoText.trafoBalance, i_trafoDay.getX() + gr_trafoDay.getX(), i_trafoDay.getY() + gr_trafoDay.getY()); 
        }
        break;
      case _i_trafoWeek:
        if (true) {
          ShapeImage self = this.i_trafoWeek;
          
uI_Results.f_setInfoText(i_trafoWeek, uI_Results.v_infoText.trafoBalance, i_trafoWeek.getX() + gr_trafoWeek.getX(), i_trafoWeek.getY() + gr_trafoWeek.getY()); 
        }
        break;
      case _i_netLoadDay:
        if (true) {
          ShapeImage self = this.i_netLoadDay;
          
uI_Results.f_setInfoText(i_netLoadDay, uI_Results.v_infoText.netBalance, i_netLoadDay.getX() + gr_netLoadDay.getX(), i_netLoadDay.getY() + gr_netLoadDay.getY()); 
        }
        break;
      case _i_netLoadWeek:
        if (true) {
          ShapeImage self = this.i_netLoadWeek;
          
uI_Results.f_setInfoText(i_netLoadWeek, uI_Results.v_infoText.netBalance, i_netLoadWeek.getX() + gr_netLoadWeek.getX(), i_netLoadWeek.getY() + gr_netLoadWeek.getY()); 
        }
        break;
      case _gr_exportButtons:
        if (true) {
          ShapeGroup self = this.gr_exportButtons;
          
f_createExport(); 
        }
        break;
      case _gr_exportMenuButtonDisabled:
        if (true) {
          ShapeGroup self = this.gr_exportMenuButtonDisabled;
          
String clickableButDoesNothing = ""; 
        }
        break;
      case _gr_exportMenuButton:
        if (true) {
          ShapeGroup self = this.gr_exportMenuButton;
          
gr_exportMenu.setVisible(!gr_exportMenu.isVisible());

if(gr_exportMenu.isVisible()){
	f_initializeExportButtons();
} 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, boolean value ) {
    switch( _shape ) {
      case _cb_subdivideEnergyCoopFlows:
        b_subdivideEnergyCoopFlows = value; {
          ShapeCheckBox self = this.cb_subdivideEnergyCoopFlows;
f_setCharts(); 
;}
        break;
      case _checkbox_electricity: {
          ShapeCheckBox self = this.checkbox_electricity;
if(checkbox_electricity.isSelected()){
	c_selectedExportEC.add(OL_EnergyCarriers.ELECTRICITY);
	gr_exportAssetFlows.setVisible(true);
}
else{
	c_selectedExportEC.remove(OL_EnergyCarriers.ELECTRICITY);
	gr_exportAssetFlows.setVisible(false);
}

f_reorderSelectedExportEC(); 
;}
        break;
      case _checkbox_hydrogen: {
          ShapeCheckBox self = this.checkbox_hydrogen;
if(checkbox_hydrogen.isSelected()){
	c_selectedExportEC.add(OL_EnergyCarriers.HYDROGEN);
}
else{
	c_selectedExportEC.remove(OL_EnergyCarriers.HYDROGEN);
}

f_reorderSelectedExportEC(); 
;}
        break;
      case _checkbox_fuel: {
          ShapeCheckBox self = this.checkbox_fuel;
if(checkbox_fuel.isSelected()){
	c_selectedExportEC.add(OL_EnergyCarriers.PETROLEUM_FUEL);
}
else{
	c_selectedExportEC.remove(OL_EnergyCarriers.PETROLEUM_FUEL);
}

f_reorderSelectedExportEC(); 
;}
        break;
      case _checkbox_heat: {
          ShapeCheckBox self = this.checkbox_heat;
if(checkbox_heat.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.districtHeatDelivery_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.districtHeatDelivery_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_methane: {
          ShapeCheckBox self = this.checkbox_methane;
if(checkbox_methane.isSelected()){
	c_selectedExportEC.add(OL_EnergyCarriers.METHANE);
}
else{
	c_selectedExportEC.remove(OL_EnergyCarriers.METHANE);
}

f_reorderSelectedExportEC(); 
;}
        break;
      case _checkbox_baseLoad: {
          ShapeCheckBox self = this.checkbox_baseLoad;
if(checkbox_baseLoad.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.fixedConsumptionElectric_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.fixedConsumptionElectric_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_PV: {
          ShapeCheckBox self = this.checkbox_PV;
if(checkbox_PV.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.pvProductionElectric_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.pvProductionElectric_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_vehicleCharging: {
          ShapeCheckBox self = this.checkbox_vehicleCharging;
if(checkbox_vehicleCharging.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.evChargingPower_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.evChargingPower_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_wind: {
          ShapeCheckBox self = this.checkbox_wind;
if(checkbox_wind.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.windProductionElectric_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.windProductionElectric_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_battery: {
          ShapeCheckBox self = this.checkbox_battery;
if(checkbox_battery.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.batteriesChargingPower_kW);
	c_selectedExportAC.add(OL_AssetFlowCategories.batteriesDischargingPower_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.batteriesChargingPower_kW);
	c_selectedExportAC.remove(OL_AssetFlowCategories.batteriesDischargingPower_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_elecCooking: {
          ShapeCheckBox self = this.checkbox_elecCooking;
if(checkbox_elecCooking.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.electricHobConsumption_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.electricHobConsumption_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_electricityForHeating: {
          ShapeCheckBox self = this.checkbox_electricityForHeating;
if(checkbox_electricityForHeating.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_v2g: {
          ShapeCheckBox self = this.checkbox_v2g;
if(checkbox_v2g.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.V2GPower_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.V2GPower_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_electricityForH2: {
          ShapeCheckBox self = this.checkbox_electricityForH2;
if(checkbox_electricityForH2.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.electrolyserElectricityConsumption_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.electrolyserElectricityConsumption_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_aircos: {
          ShapeCheckBox self = this.checkbox_aircos;
if(checkbox_aircos.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.airConditionersElectricPower_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.airConditionersElectricPower_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_exportDieselGen: {
          ShapeCheckBox self = this.checkbox_exportDieselGen;
if(checkbox_exportDieselGen.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.dieselGeneratorProductionElectric_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.dieselGeneratorProductionElectric_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_exportMethaneGen: {
          ShapeCheckBox self = this.checkbox_exportMethaneGen;
if(checkbox_exportMethaneGen.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.methaneGeneratorProductionElectric_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.methaneGeneratorProductionElectric_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_exportFuelCell: {
          ShapeCheckBox self = this.checkbox_exportFuelCell;
if(checkbox_exportFuelCell.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.hydrogenFuelCellProductionElectric_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.hydrogenFuelCellProductionElectric_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      case _checkbox_exportCHP: {
          ShapeCheckBox self = this.checkbox_exportCHP;
if(checkbox_exportCHP.isSelected()){
	c_selectedExportAC.add(OL_AssetFlowCategories.CHPProductionElectric_kW);
}
else{
	c_selectedExportAC.remove(OL_AssetFlowCategories.CHPProductionElectric_kW);
}

f_reorderSelectedExportAC(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, int value ) {
    switch( _shape ) {
      case _rb_periodIncludingYear: {
          ShapeRadioButtonGroup self = this.rb_periodIncludingYear;
f_setCharts(); 
;}
        break;
      case _rb_periodPeaksIncludingYear: {
          ShapeRadioButtonGroup self = this.rb_periodPeaksIncludingYear;
f_setCharts(); 
;}
        break;
      case _radio_energyType: {
          ShapeRadioButtonGroup self = this.radio_energyType;
f_setCharts(); 
;}
        break;
      case _radio_periodLive: {
          ShapeRadioButtonGroup self = this.radio_periodLive;
f_setCharts(); 
;}
        break;
      case _rb_periodExcludingYear: {
          ShapeRadioButtonGroup self = this.rb_periodExcludingYear;
f_setCharts(); 
;}
        break;
      case _rb_periodPeaksExcludingYear: {
          ShapeRadioButtonGroup self = this.rb_periodPeaksExcludingYear;
f_setCharts(); 
;}
        break;
      case _rb_exportUnit: {
          ShapeRadioButtonGroup self = this.rb_exportUnit;
switch(rb_exportUnit.getValue()){
	case 0:
		p_selectedExportUnit = "kWh";
		break;
	case 1:
		p_selectedExportUnit = "kW";	
		break;
	default:
		throw new RuntimeException("Unsupported unit type selected!");
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
  public boolean getShapeControlDefaultValueBoolean( int _shape, int index ) {
    switch(_shape) {
      case _cb_subdivideEnergyCoopFlows: return 
b_subdivideEnergyCoopFlows 
;
      case _checkbox_electricity: return 
true 
;
      case _checkbox_hydrogen: return 
false 
;
      case _checkbox_fuel: return 
false 
;
      case _checkbox_heat: return 
false 
;
      case _checkbox_methane: return 
false 
;
      case _checkbox_baseLoad: return 
false 
;
      case _checkbox_PV: return 
false 
;
      case _checkbox_vehicleCharging: return 
false 
;
      case _checkbox_wind: return 
false 
;
      case _checkbox_battery: return 
false 
;
      case _checkbox_elecCooking: return 
false 
;
      case _checkbox_electricityForHeating: return 
false 
;
      case _checkbox_v2g: return 
false 
;
      case _checkbox_electricityForH2: return 
false 
;
      case _checkbox_aircos: return 
false 
;
      case _checkbox_exportDieselGen: return 
false 
;
      case _checkbox_exportMethaneGen: return 
false 
;
      case _checkbox_exportFuelCell: return 
false 
;
      case _checkbox_exportCHP: return 
false 
;
      default: return super.getShapeControlDefaultValueBoolean( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getShapeControlDefaultValueInt( int _shape, int index ) {
    switch(_shape) {
      case _rb_periodIncludingYear: return 
0 
;
      case _rb_periodPeaksIncludingYear: return 
0 
;
      case _radio_energyType: return 
0 
;
      case _radio_periodLive: return 
0 
;
      case _rb_periodExcludingYear: return 
0 
;
      case _rb_periodPeaksExcludingYear: return 
0 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  protected ShapeRadioButtonGroup rb_periodIncludingYear;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rb_periodPeaksIncludingYear_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    shape.setX(
30 
);
    shape.setY(
3 
);
  }
  
  protected ShapeRadioButtonGroup rb_periodPeaksIncludingYear;
  
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
  protected ShapeRadioButtonGroup radio_periodLive;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _cb_subdivideEnergyCoopFlows_SetDynamicParams_xjal( ShapeCheckBox shape ) {
    boolean _visible = 
uI_Results.v_selectedObjectScope == OL_ResultScope.ENERGYCOOP && radio_energyType.getValue() != 1 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
uI_Results.v_selectedObjectScope == OL_ResultScope.ENERGYCOOP && radio_energyType.getValue() != 1 
);
 	}
  }
  
  protected ShapeCheckBox cb_subdivideEnergyCoopFlows;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rb_periodExcludingYear_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    shape.setX(
90 
);
    shape.setY(
3 
);
  }
  
  protected ShapeRadioButtonGroup rb_periodExcludingYear;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rb_periodPeaksExcludingYear_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    shape.setX(
80 
);
    shape.setY(
3 
);
  }
  
  protected ShapeRadioButtonGroup rb_periodPeaksExcludingYear;
  protected ShapeCheckBox checkbox_electricity;
  protected ShapeCheckBox checkbox_hydrogen;
  protected ShapeCheckBox checkbox_fuel;
  protected ShapeCheckBox checkbox_heat;
  protected ShapeCheckBox checkbox_methane;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _checkbox_exportPerGCCoop_SetDynamicParams_xjal( ShapeCheckBox shape ) {
    boolean _visible = 
uI_Results.v_selectedObjectScope == OL_ResultScope.ENERGYCOOP 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeCheckBox checkbox_exportPerGCCoop;
  protected ShapeCheckBox checkbox_baseLoad;
  protected ShapeCheckBox checkbox_PV;
  protected ShapeCheckBox checkbox_vehicleCharging;
  protected ShapeCheckBox checkbox_wind;
  protected ShapeCheckBox checkbox_battery;
  protected ShapeCheckBox checkbox_elecCooking;
  protected ShapeCheckBox checkbox_electricityForHeating;
  protected ShapeCheckBox checkbox_v2g;
  protected ShapeCheckBox checkbox_electricityForH2;
  protected ShapeCheckBox checkbox_aircos;
  protected ShapeCheckBox checkbox_exportDieselGen;
  protected ShapeCheckBox checkbox_exportMethaneGen;
  protected ShapeCheckBox checkbox_exportFuelCell;
  protected ShapeCheckBox checkbox_exportCHP;
  protected ShapeRadioButtonGroup rb_exportUnit;
  protected TimeStackChart energyDemandChartDay;
  protected TimeStackChart energySupplyChartDay;
  protected TimeStackChart energyDemandChart;
  protected TimeStackChart energySupplyChart;
  protected TimeStackChart energyDemandChartYear;
  protected TimeStackChart energySupplyChartYear;
  protected TimePlot plot_trafo_day;
  protected TimePlot plot_trafo_week;
  protected TimePlot plot_netload_day;
  protected TimePlot plot_netload_week;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_radioButtons_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_lineColor 
);
    shape.setLineWidth(
v_lineWidth 
);
  }
  
  protected ShapeRectangle rect_radioButtons;
  protected ShapeText t_energieAanbod2;
  protected ShapeText t_energieVraag6;
  protected ShapeText t_weekProfile_ylabel2;
  protected ShapeText t_weekProfile_ylabel3;
  protected ShapeImage i_consumptionDay;
  protected ShapeImage i_productionDay;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_day_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_day;
  protected ShapeText t_energieAanbod1;
  protected ShapeText t_energieVraag1;
  protected ShapeText t_weekProfile_ylabel;
  protected ShapeText t_weekProfile_ylabel1;
  protected ShapeImage i_consumptionWeek;
  protected ShapeImage i_productionWeek;
  protected ShapeGroup gr_week;
  protected ShapeText t_energieAanbod3;
  protected ShapeText t_energieVraag9;
  protected ShapeText t_weekProfile_ylabel4;
  protected ShapeText t_weekProfile_ylabel5;
  protected ShapeImage i_consumptionYear;
  protected ShapeImage i_productionYear;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_year_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_year;
  protected ShapeText t_energieVraag7;
  protected ShapeText t_weekProfileTrafo_ylabel2;
  protected ShapeImage i_trafoDay;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_trafoDay_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_trafoDay;
  protected ShapeText t_energieVraag2;
  protected ShapeText t_weekProfileTrafo_ylabel;
  protected ShapeImage i_trafoWeek;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_trafoWeek_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_trafoWeek;
  protected ShapeText t_energieVraag8;
  protected ShapeText t_weekProfileTrafo_ylabel3;
  protected ShapeImage i_netLoadDay;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_netLoadDay_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_netLoadDay;
  protected ShapeText t_energieVraag4;
  protected ShapeText t_weekProfileTrafo_ylabel1;
  protected ShapeImage i_netLoadWeek;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_netLoadWeek_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_netLoadWeek;
  protected ShapeRectangle rect_exportToExcelFunctions;
  protected ShapeText txt_writeToExcelFunctions;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_exportMenu_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_lineColor 
);
    shape.setLineWidth(
v_lineWidth 
);
    shape.setLineStyle(
v_lineStyle 
);
  }
  
  protected ShapeRectangle rect_exportMenu;
  protected ShapeRoundedRectangle rect_exportButton;
  protected ShapeText txt_exportButton;
  protected ShapeImage image_exportButton;
  protected ShapeGroup gr_exportButtons;
  protected ShapeText txt_exportEC;
  protected ShapeText txt_exportAC;
  protected ShapeGroup gr_exportAssetFlows;
  protected ShapeText txt_configureExport;
  protected ShapeText txt_exportUnit;
  protected ShapeGroup gr_exportUnit;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_exportMenu_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
220 
);
    shape.setY(
465 
);
  }
  
  protected ShapeGroup gr_exportMenu;
  protected ShapeRectangle rect_loadingScreen;
  protected ShapeImage image_loadIcon;
  protected ShapeText txt_exportExcelIsCreated;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_loadingScreen_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
210 
);
    shape.setY(
425 
);
  }
  
  protected ShapeGroup gr_loadingScreen;
  protected ShapeRoundedRectangle rect_exportMenuButton1;
  protected ShapeImage image_exportMenuButton1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_exportMenuButtonDisabled_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
gr_exportMenuButton.getX() 
);
    shape.setY(
gr_exportMenuButton.getY() 
);
  }
  
  protected ShapeGroup gr_exportMenuButtonDisabled;
  protected ShapeRoundedRectangle rect_exportMenuButton;
  protected ShapeImage image_exportMenuButton;
  protected ShapeGroup gr_exportMenuButton;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rb_periodIncludingYear = new ShapeRadioButtonGroup(
ChartProfielen.this, true, 40.0, 3.0,
			370.0, 40.0,
            black, true,
_rb_periodIncludingYear_Font, false,
            new String[]{"Live Simulatie", "Winter Week", "Zomer Week", "Jaar Overzicht", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_periodIncludingYear, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _rb_periodIncludingYear, 0 ) );
      }
    };
    rb_periodPeaksIncludingYear = new ShapeRadioButtonGroup(
ChartProfielen.this, true, 1580.0, 520.0,
			400.0, 40.0,
            black, true,
_rb_periodPeaksIncludingYear_Font, false,
            new String[]{"Live Simulatie", "Hoogste afname", "Laagste afname", "Jaar Overzicht", } ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rb_periodPeaksIncludingYear_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_periodPeaksIncludingYear, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _rb_periodPeaksIncludingYear, 0 ) );
      }
    };
    radio_energyType = new ShapeRadioButtonGroup(
ChartProfielen.this, true, 60.0, 35.0,
			320.0, 40.0,
            black, true,
_radio_energyType_Font, false,
            new String[]{"Alleen elektriciteit", "Alle energiedragers", "Netto Balans", } ) {
	
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
    radio_periodLive = new ShapeRadioButtonGroup(
ChartProfielen.this, true, 180.0, 65.0,
			100.0, 40.0,
            black, true,
_radio_periodLive_Font, false,
            new String[]{"Week", "Dag", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _radio_periodLive, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _radio_periodLive, 0 ) );
      }
    };
    cb_subdivideEnergyCoopFlows = new ShapeCheckBox(
ChartProfielen.this,true,0.0, 710.0,
		220.0, 30.0,
            black, true,
            _cb_subdivideEnergyCoopFlows_Font,
			"Toon onderscheid tussen aansluitingen" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _cb_subdivideEnergyCoopFlows_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_subdivideEnergyCoopFlows, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_subdivideEnergyCoopFlows, 0 ) );
      }
    };
    rb_periodExcludingYear = new ShapeRadioButtonGroup(
ChartProfielen.this, true, 1580.0, 475.0,
			280.0, 40.0,
            black, true,
_rb_periodExcludingYear_Font, false,
            new String[]{"Live Simulatie", "Winter Week", "Zomer Week", } ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rb_periodExcludingYear_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_periodExcludingYear, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _rb_periodExcludingYear, 0 ) );
      }
    };
    rb_periodPeaksExcludingYear = new ShapeRadioButtonGroup(
ChartProfielen.this, true, 1580.0, 565.0,
			300.0, 40.0,
            black, true,
_rb_periodPeaksExcludingYear_Font, false,
            new String[]{"Live Simulatie", "Hoogste afname", "Laagste afname", } ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rb_periodPeaksExcludingYear_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_periodPeaksExcludingYear, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _rb_periodPeaksExcludingYear, 0 ) );
      }
    };
    checkbox_electricity = new ShapeCheckBox(
ChartProfielen.this,true,-120.0, -190.0,
		100.0, 30.0,
            black, true,
            _checkbox_electricity_Font,
			"Stroom" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_electricity, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_electricity, 0 ) );
      }
    };
    checkbox_hydrogen = new ShapeCheckBox(
ChartProfielen.this,true,-120.0, -150.0,
		100.0, 30.0,
            black, true,
            _checkbox_hydrogen_Font,
			"Waterstof" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_hydrogen, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_hydrogen, 0 ) );
      }
    };
    checkbox_fuel = new ShapeCheckBox(
ChartProfielen.this,true,-120.0, -130.0,
		120.0, 30.0,
            black, true,
            _checkbox_fuel_Font,
			"Diesel & Benzine" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_fuel, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_fuel, 0 ) );
      }
    };
    checkbox_heat = new ShapeCheckBox(
ChartProfielen.this,true,-120.0, -110.0,
		140.0, 30.0,
            black, true,
            _checkbox_heat_Font,
			"Warmte uit warmtenet" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_heat, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_heat, 0 ) );
      }
    };
    checkbox_methane = new ShapeCheckBox(
ChartProfielen.this,true,-120.0, -170.0,
		100.0, 30.0,
            black, true,
            _checkbox_methane_Font,
			"Gas" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_methane, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_methane, 0 ) );
      }
    };
    checkbox_exportPerGCCoop = new ShapeCheckBox(
ChartProfielen.this,true,-130.0, 110.0,
		330.0, 30.0,
            black, true,
            _checkbox_exportPerGCCoop_Font,
			"Exporteer apart voor elke aansluiting in de groep" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _checkbox_exportPerGCCoop_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    checkbox_baseLoad = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, -110.0,
		100.0, 30.0,
            black, true,
            _checkbox_baseLoad_Font,
			"Basis last" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_baseLoad, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_baseLoad, 0 ) );
      }
    };
    checkbox_PV = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, -70.0,
		100.0, 30.0,
            black, true,
            _checkbox_PV_Font,
			"PV" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_PV, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_PV, 0 ) );
      }
    };
    checkbox_vehicleCharging = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, -50.0,
		100.0, 30.0,
            black, true,
            _checkbox_vehicleCharging_Font,
			"Opladen EVs" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_vehicleCharging, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_vehicleCharging, 0 ) );
      }
    };
    checkbox_wind = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, -30.0,
		100.0, 30.0,
            black, true,
            _checkbox_wind_Font,
			"Wind" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_wind, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_wind, 0 ) );
      }
    };
    checkbox_battery = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, -90.0,
		100.0, 30.0,
            black, true,
            _checkbox_battery_Font,
			"Batterij" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_battery, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_battery, 0 ) );
      }
    };
    checkbox_elecCooking = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, 10.0,
		100.0, 30.0,
            black, true,
            _checkbox_elecCooking_Font,
			"Elektr. koken" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_elecCooking, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_elecCooking, 0 ) );
      }
    };
    checkbox_electricityForHeating = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, -10.0,
		120.0, 30.0,
            black, true,
            _checkbox_electricityForHeating_Font,
			"Elektr. voor warmte" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_electricityForHeating, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_electricityForHeating, 0 ) );
      }
    };
    checkbox_v2g = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, 50.0,
		100.0, 30.0,
            black, true,
            _checkbox_v2g_Font,
			"V2G" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_v2g, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_v2g, 0 ) );
      }
    };
    checkbox_electricityForH2 = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, 30.0,
		210.0, 30.0,
            black, true,
            _checkbox_electricityForH2_Font,
			"Elektr. behoefte elektrolysers" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_electricityForH2, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_electricityForH2, 0 ) );
      }
    };
    checkbox_aircos = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, 70.0,
		165.0, 30.0,
            black, true,
            _checkbox_aircos_Font,
			"Elektr. behoefte Airco's" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_aircos, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_aircos, 0 ) );
      }
    };
    checkbox_exportDieselGen = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, 90.0,
		170.0, 30.0,
            black, true,
            _checkbox_exportDieselGen_Font,
			"Elektr. Opwek Diesel Gen." ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_exportDieselGen, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_exportDieselGen, 0 ) );
      }
    };
    checkbox_exportMethaneGen = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, 110.0,
		155.0, 30.0,
            black, true,
            _checkbox_exportMethaneGen_Font,
			"Elektr. Opwek Gas Gen." ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_exportMethaneGen, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_exportMethaneGen, 0 ) );
      }
    };
    checkbox_exportFuelCell = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, 130.0,
		185.0, 30.0,
            black, true,
            _checkbox_exportFuelCell_Font,
			"Elektr. Opwek H2 Fuel Cell" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_exportFuelCell, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_exportFuelCell, 0 ) );
      }
    };
    checkbox_exportCHP = new ShapeCheckBox(
ChartProfielen.this,true,-60.0, 150.0,
		185.0, 30.0,
            black, true,
            _checkbox_exportCHP_Font,
			"Elektr. Opwek WKK" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox_exportCHP, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox_exportCHP, 0 ) );
      }
    };
    rb_exportUnit = new ShapeRadioButtonGroup(
ChartProfielen.this, true, -30.0, -20.0,
			150.0, 30.0,
            black, true,
_rb_exportUnit_Font, false,
            new String[]{"kWh", "kW", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _rb_exportUnit, 0, value );
      }
    };
    rect_radioButtons = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            lavender, whiteSmoke,
			460.0, 105.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_radioButtons_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_energieAanbod2 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 280.0, 0.0, 0.0,
        black,"Productie",
        _t_energieAanbod2_Font, ALIGNMENT_CENTER );
    t_energieVraag6 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 0.0, 0.0, 0.0,
        black,"Consumptie",
        _t_energieVraag6_Font, ALIGNMENT_CENTER );
    t_weekProfile_ylabel2 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 50.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_weekProfile_ylabel2_Font, ALIGNMENT_LEFT );
    t_weekProfile_ylabel3 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 330.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_weekProfile_ylabel3_Font, ALIGNMENT_LEFT );
    i_consumptionDay = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 280.0, 0.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_consumptionDay, 0, clickx, clicky );
      }
    };
    i_productionDay = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 270.0, 280.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_productionDay, 0, clickx, clicky );
      }
    };
    t_energieAanbod1 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 280.0, 0.0, 0.0,
        black,"Productie",
        _t_energieAanbod1_Font, ALIGNMENT_CENTER );
    t_energieVraag1 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 0.0, 0.0, 0.0,
        black,"Consumptie",
        _t_energieVraag1_Font, ALIGNMENT_CENTER );
    t_weekProfile_ylabel = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 50.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_weekProfile_ylabel_Font, ALIGNMENT_LEFT );
    t_weekProfile_ylabel1 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 330.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_weekProfile_ylabel1_Font, ALIGNMENT_LEFT );
    i_consumptionWeek = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 280.0, 0.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_consumptionWeek, 0, clickx, clicky );
      }
    };
    i_productionWeek = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 270.0, 280.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_productionWeek, 0, clickx, clicky );
      }
    };
    t_energieAanbod3 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 280.0, 0.0, 0.0,
        black,"Productie",
        _t_energieAanbod3_Font, ALIGNMENT_CENTER );
    t_energieVraag9 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 0.0, 0.0, 0.0,
        black,"Consumptie",
        _t_energieVraag9_Font, ALIGNMENT_CENTER );
    t_weekProfile_ylabel4 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 50.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_weekProfile_ylabel4_Font, ALIGNMENT_LEFT );
    t_weekProfile_ylabel5 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 330.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_weekProfile_ylabel5_Font, ALIGNMENT_LEFT );
    i_consumptionYear = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 280.0, 0.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_consumptionYear, 0, clickx, clicky );
      }
    };
    i_productionYear = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 270.0, 280.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_productionYear, 0, clickx, clicky );
      }
    };
    t_energieVraag7 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 0.0, 0.0, 0.0,
        black,"Trafo belasting en capaciteit",
        _t_energieVraag7_Font, ALIGNMENT_CENTER );
    t_weekProfileTrafo_ylabel2 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 75.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_weekProfileTrafo_ylabel2_Font, ALIGNMENT_LEFT );
    i_trafoDay = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 340.0, 0.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_trafoDay, 0, clickx, clicky );
      }
    };
    t_energieVraag2 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 0.0, 0.0, 0.0,
        black,"Trafo belasting en capaciteit",
        _t_energieVraag2_Font, ALIGNMENT_CENTER );
    t_weekProfileTrafo_ylabel = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 75.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_weekProfileTrafo_ylabel_Font, ALIGNMENT_LEFT );
    i_trafoWeek = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 340.0, 0.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_trafoWeek, 0, clickx, clicky );
      }
    };
    t_energieVraag8 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 0.0, 0.0, 0.0,
        black,"Netto Belasting",
        _t_energieVraag8_Font, ALIGNMENT_CENTER );
    t_weekProfileTrafo_ylabel3 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 75.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_weekProfileTrafo_ylabel3_Font, ALIGNMENT_LEFT );
    i_netLoadDay = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 290.0, 0.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_netLoadDay, 0, clickx, clicky );
      }
    };
    t_energieVraag4 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 0.0, 0.0, 0.0,
        black,"Netto Belasting",
        _t_energieVraag4_Font, ALIGNMENT_CENTER );
    t_weekProfileTrafo_ylabel1 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 75.0, 0.0, 1.5707963267948966,
        black,"Vermogen [kW]",
        _t_weekProfileTrafo_ylabel1_Font, ALIGNMENT_LEFT );
    i_netLoadWeek = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 290.0, 0.0, 0.0, 0.0,
20.0, 20.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_netLoadWeek, 0, clickx, clicky );
      }
    };
    rect_exportToExcelFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,1260.0, 1080.0, 0.0, 0.0,
            black, white,
			570.0, 310.0, 10.0, 1.0, LINE_STYLE_SOLID );
    txt_writeToExcelFunctions = new ShapeText(
        SHAPE_DRAW_2D, false,1300.0, 1100.0, 0.0, 0.0,
        black,"Write data to excel",
        _txt_writeToExcelFunctions_Font, ALIGNMENT_LEFT );
    rect_exportMenu = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-220.0, -360.0, 0.0, 0.0,
            black, white,
			460.0, 645.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_exportMenu_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_exportButton = new ShapeRoundedRectangle(
true,-110.0, -30.0, 0.0,
        _rect_exportButton_Line_Color, _rect_exportButton_Fill_Color,
220.0, 50.0,10.0,
		1.0, LINE_STYLE_SOLID );
    txt_exportButton = new ShapeText(
        SHAPE_DRAW_2D, true,-75.0, -19.0, 0.0, 0.0,
        white,"Exporteer",
        _txt_exportButton_Font, ALIGNMENT_LEFT );
    image_exportButton = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, 48.0, -17.654, 0.0, 0.0,
27.0, 23.884, "/digital_twin_results/",
			new String[]{"load_icon_white.png",} );
    txt_exportEC = new ShapeText(
        SHAPE_DRAW_2D, true,-80.0, -220.0, 0.0, 0.0,
        black,"Welke energiedragers \nwil je exporteren?",
        _txt_exportEC_Font, ALIGNMENT_CENTER );
    txt_exportAC = new ShapeText(
        SHAPE_DRAW_2D, true,-10.0, -140.0, 0.0, 0.0,
        black,"Welke elektrische asset profielen \nwil je exporteren?",
        _txt_exportAC_Font, ALIGNMENT_CENTER );
    txt_configureExport = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -270.0, 0.0, 0.0,
        black,"Wat wil je exporteren?",
        _txt_configureExport_Font, ALIGNMENT_CENTER );
    txt_exportUnit = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -12.0, 0.0, 0.0,
        black,"Eenheid:",
        _txt_exportUnit_Font, ALIGNMENT_LEFT );
    rect_loadingScreen = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-210.0, -320.0, 0.0, 0.0,
            null, white,
			460.0, 645.0, 10.0, 0.0, LINE_STYLE_SOLID );
    image_loadIcon = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, -65.0, -110.0, 0.0, 0.0,
170.0, 170.0, "/digital_twin_results/",
			new String[]{"icon_loading.gif",} );
    txt_exportExcelIsCreated = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, -180.0, 0.0, 0.0,
        black,"Excel export wordt gemaakt...",
        _txt_exportExcelIsCreated_Font, ALIGNMENT_CENTER );
    rect_exportMenuButton1 = new ShapeRoundedRectangle(
true,-22.442, -17.682, 0.0,
        lavender, silver,
41.147, 31.829,10.0,
		1.0, LINE_STYLE_SOLID );
    image_exportMenuButton1 = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, -11.223, -10.607, 0.0, 0.0,
20.199, 16.892, "/digital_twin_results/",
			new String[]{"load_icon_white.png",} );
    rect_exportMenuButton = new ShapeRoundedRectangle(
true,-22.442, -17.682, 0.0,
        _rect_exportMenuButton_Line_Color, _rect_exportMenuButton_Fill_Color,
41.147, 31.829,10.0,
		1.0, LINE_STYLE_SOLID );
    image_exportMenuButton = new ShapeImage(
		ChartProfielen.this, SHAPE_DRAW_2D3D, true, -11.223, -10.607, 0.0, 0.0,
20.199, 16.892, "/digital_twin_results/",
			new String[]{"load_icon_white.png",} );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    energyDemandChartDay = new TimeStackChart(
ChartProfielen.this, true, 0.0, 0.0,
			460.0, 210.0,
            null, null,
            50.0, 30.0,
			380.0, 120.0, white, black, black,
            30.0, Chart.SOUTH,

24 
            , Chart.WINDOW_MOVES_WITH_DATA, "HH:mm", Chart.SCALE_AUTO
,0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    energySupplyChartDay = new TimeStackChart(
ChartProfielen.this, true, 0.0, 280.0,
			460.0, 210.0,
            null, null,
            50.0, 30.0,
			380.0, 120.0, white, black, black,
            30.0, Chart.SOUTH,

24 
            , Chart.WINDOW_MOVES_WITH_DATA, "HH:mm", Chart.SCALE_AUTO
,0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    energyDemandChart = new TimeStackChart(
ChartProfielen.this, true, 0.0, 0.0,
			460.0, 210.0,
            null, null,
            50.0, 30.0,
			380.0, 120.0, white, black, black,
            30.0, Chart.SOUTH,

168 
            , Chart.WINDOW_MOVES_WITH_DATA, "dd.MM", Chart.SCALE_AUTO
,0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    energySupplyChart = new TimeStackChart(
ChartProfielen.this, true, 0.0, 280.0,
			460.0, 210.0,
            null, null,
            50.0, 30.0,
			380.0, 120.0, white, black, black,
            30.0, Chart.SOUTH,

168 
            , Chart.WINDOW_MOVES_WITH_DATA, "dd.MM", Chart.SCALE_AUTO
,0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    energyDemandChartYear = new TimeStackChart(
ChartProfielen.this, true, 0.0, 0.0,
			460.0, 210.0,
            null, null,
            50.0, 30.0,
			380.0, 120.0, white, black, black,
            30.0, Chart.SOUTH,

8760 
            , Chart.WINDOW_MOVES_WITH_DATA, "MMM", Chart.SCALE_AUTO
,0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Color> _colors = new ArrayList<>( 0 );
    energySupplyChartYear = new TimeStackChart(
ChartProfielen.this, true, 0.0, 280.0,
			460.0, 210.0,
            null, null,
            50.0, 30.0,
			380.0, 120.0, white, black, black,
            30.0, Chart.SOUTH,

8760 
            , Chart.WINDOW_MOVES_WITH_DATA, "MM", Chart.SCALE_AUTO
,0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_trafo_day = new TimePlot(
ChartProfielen.this, true, 0.0, 0.0,
			460.0, 260.0,
            null, null,
            50.0, 30.0,
			380.0, 170.0, white, black, black,
            30.0, Chart.SOUTH,

24 
            , Chart.WINDOW_MOVES_WITH_DATA, "HH:mm", Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_trafo_week = new TimePlot(
ChartProfielen.this, true, 0.0, 0.0,
			460.0, 260.0,
            null, null,
            50.0, 30.0,
			380.0, 170.0, white, black, black,
            30.0, Chart.SOUTH,

168 
            , Chart.WINDOW_MOVES_WITH_DATA, "dd.MM", Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_netload_day = new TimePlot(
ChartProfielen.this, true, 0.0, 0.0,
			460.0, 260.0,
            null, null,
            50.0, 30.0,
			380.0, 170.0, white, black, black,
            30.0, Chart.SOUTH,

24 
            , Chart.WINDOW_MOVES_WITH_DATA, "HH:mm", Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    List<DataSet> _items = new ArrayList<DataSet>( 0 );
    List<String> _titles = new ArrayList<>( 0 );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 0 );
    plot_netload_week = new TimePlot(
ChartProfielen.this, true, 0.0, 0.0,
			460.0, 260.0,
            null, null,
            50.0, 30.0,
			380.0, 170.0, white, black, black,
            30.0, Chart.SOUTH,

168 
            , Chart.WINDOW_MOVES_WITH_DATA, "dd.MM", Chart.SCALE_AUTO,
0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    {
    gr_day = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 1010.0, 190.0, 0.0, 0.0
	
	     , energyDemandChartDay
	     , energySupplyChartDay
	     , t_energieAanbod2
	     , t_energieVraag6
	     , t_weekProfile_ylabel2
	     , t_weekProfile_ylabel3
	     , i_consumptionDay
	     , i_productionDay ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_day_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_week = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 0.0, 190.0, 0.0, 0.0
	
	     , energyDemandChart
	     , energySupplyChart
	     , t_energieAanbod1
	     , t_energieVraag1
	     , t_weekProfile_ylabel
	     , t_weekProfile_ylabel1
	     , i_consumptionWeek
	     , i_productionWeek );
    }
    {
    gr_year = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 520.0, 190.0, 0.0, 0.0
	
	     , energyDemandChartYear
	     , energySupplyChartYear
	     , t_energieAanbod3
	     , t_energieVraag9
	     , t_weekProfile_ylabel4
	     , t_weekProfile_ylabel5
	     , i_consumptionYear
	     , i_productionYear ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_year_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_trafoDay = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 2490.0, 190.0, 0.0, 0.0
	
	     , plot_trafo_day
	     , t_energieVraag7
	     , t_weekProfileTrafo_ylabel2
	     , i_trafoDay ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_trafoDay_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_trafoWeek = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 1520.0, 190.0, 0.0, 0.0
	
	     , plot_trafo_week
	     , t_energieVraag2
	     , t_weekProfileTrafo_ylabel
	     , i_trafoWeek ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_trafoWeek_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_netLoadDay = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 4010.0, 190.0, 0.0, 0.0
	
	     , plot_netload_day
	     , t_energieVraag8
	     , t_weekProfileTrafo_ylabel3
	     , i_netLoadDay ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_netLoadDay_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_netLoadWeek = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 3020.0, 190.0, 0.0, 0.0
	
	     , plot_netload_week
	     , t_energieVraag4
	     , t_weekProfileTrafo_ylabel1
	     , i_netLoadWeek ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_netLoadWeek_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_exportButtons = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 0.0, 220.0, 0.0, 0.0
	
	     , rect_exportButton
	     , txt_exportButton
	     , image_exportButton ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_exportButtons, 0, clickx, clicky );
      }
    };
    }
    {
    gr_exportAssetFlows = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 80.0, -80.0, 0.0, 0.0
	
	     , checkbox_baseLoad
	     , checkbox_PV
	     , checkbox_vehicleCharging
	     , checkbox_wind
	     , checkbox_battery
	     , checkbox_elecCooking
	     , checkbox_electricityForHeating
	     , txt_exportAC
	     , checkbox_v2g
	     , checkbox_electricityForH2
	     , checkbox_aircos
	     , checkbox_exportDieselGen
	     , checkbox_exportMethaneGen
	     , checkbox_exportFuelCell
	     , checkbox_exportCHP );
    }
    {
    gr_exportUnit = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 20.0, 170.0, 0.0, 0.0
	
	     , rb_exportUnit
	     , txt_exportUnit );
    }
    {
    gr_exportMenu = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 1280.0, 1760.0, 0.0, 0.0
	
	     , rect_exportMenu
	     , gr_exportButtons
	     , checkbox_electricity
	     , checkbox_hydrogen
	     , checkbox_fuel
	     , checkbox_heat
	     , checkbox_methane
	     , checkbox_exportPerGCCoop
	     , txt_exportEC
	     , gr_exportAssetFlows
	     , txt_configureExport
	     , gr_exportUnit ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_exportMenu_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    {
    gr_loadingScreen = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 1760.0, 1720.0, 0.0, 0.0
	
	     , rect_loadingScreen
	     , image_loadIcon
	     , txt_exportExcelIsCreated ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_loadingScreen_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_loadingScreen.setVisible( false );
    {
    gr_exportMenuButtonDisabled = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 1930.0, 1200.0, 0.0, 0.0
	
	     , rect_exportMenuButton1
	     , image_exportMenuButton1 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_exportMenuButtonDisabled_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_exportMenuButtonDisabled, 0, clickx, clicky );
      }
    };
    }
    {
    gr_exportMenuButton = new ShapeGroup( ChartProfielen.this, SHAPE_DRAW_2D3D, true, 425.0, 80.0, 0.0, 0.0
	
	     , rect_exportMenuButton
	     , image_exportMenuButton ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_exportMenuButton, 0, clickx, clicky );
      }
    };
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
  public ChartProfielen( Engine engine, Agent owner, AgentList<? extends ChartProfielen> ownerPopulation ) {
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
  public ChartProfielen() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public ChartProfielen( String p_selectedExportUnit, Map<OL_AssetFlowCategories, ShapeCheckBox> map_ACToCheckBox, Map<OL_EnergyCarriers, ShapeCheckBox> map_ECToCheckBox ) {
    markParametersAreSet();
    this.p_selectedExportUnit = p_selectedExportUnit;
    this.map_ACToCheckBox = map_ACToCheckBox;
    this.map_ECToCheckBox = map_ECToCheckBox;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartProfielen_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    addAll( c_selectedExportEC, new OL_EnergyCarriers[] 
{OL_EnergyCarriers.ELECTRICITY} 
    );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartProfielen.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartProfielen.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    rb_periodIncludingYear.setValueToDefault();
    rb_periodPeaksIncludingYear.setValueToDefault();
    radio_energyType.setValueToDefault();
    radio_periodLive.setValueToDefault();
    cb_subdivideEnergyCoopFlows.setValueToDefault();
    rb_periodExcludingYear.setValueToDefault();
    rb_periodPeaksExcludingYear.setValueToDefault();
    checkbox_electricity.setValueToDefault();
    checkbox_hydrogen.setValueToDefault();
    checkbox_fuel.setValueToDefault();
    checkbox_heat.setValueToDefault();
    checkbox_methane.setValueToDefault();
    checkbox_baseLoad.setValueToDefault();
    checkbox_PV.setValueToDefault();
    checkbox_vehicleCharging.setValueToDefault();
    checkbox_wind.setValueToDefault();
    checkbox_battery.setValueToDefault();
    checkbox_elecCooking.setValueToDefault();
    checkbox_electricityForHeating.setValueToDefault();
    checkbox_v2g.setValueToDefault();
    checkbox_electricityForH2.setValueToDefault();
    checkbox_aircos.setValueToDefault();
    checkbox_exportDieselGen.setValueToDefault();
    checkbox_exportMethaneGen.setValueToDefault();
    checkbox_exportFuelCell.setValueToDefault();
    checkbox_exportCHP.setValueToDefault();
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
v_weekLabel.setText("Zomerweek");
v_weekLabel.setFont(new Font("Calibri", 0, 20));
//gr_week.add(v_weekLabel);
this.presentation.add(v_weekLabel);
v_weekLabel.setX(210);
v_weekLabel.setY(160); 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartProfielen_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartProfielen_xjal() {
    b_subdivideEnergyCoopFlows = 
false 
;
    v_periodRadioButton = 
rb_periodPeaksIncludingYear 
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

  public AgentList<? extends ChartProfielen> getPopulation() {
    return (AgentList<? extends ChartProfielen>) super.getPopulation();
  }

  public List<? extends ChartProfielen> agentsInRange( double distance ) {
    return (List<? extends ChartProfielen>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
  	for (int _pIdx = 0; _pIdx < energyDemandChartDay.getCount(); _pIdx++) {
  		DataSet _ds = energyDemandChartDay.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = energyDemandChartDay.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "energyDemandChartDay : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < energySupplyChartDay.getCount(); _pIdx++) {
  		DataSet _ds = energySupplyChartDay.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = energySupplyChartDay.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "energySupplyChartDay : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < energyDemandChart.getCount(); _pIdx++) {
  		DataSet _ds = energyDemandChart.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = energyDemandChart.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "energyDemandChart : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < energySupplyChart.getCount(); _pIdx++) {
  		DataSet _ds = energySupplyChart.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = energySupplyChart.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "energySupplyChart : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < energyDemandChartYear.getCount(); _pIdx++) {
  		DataSet _ds = energyDemandChartYear.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = energyDemandChartYear.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "energyDemandChartYear : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < energySupplyChartYear.getCount(); _pIdx++) {
  		DataSet _ds = energySupplyChartYear.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = energySupplyChartYear.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "energySupplyChartYear : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < plot_trafo_day.getCount(); _pIdx++) {
  		DataSet _ds = plot_trafo_day.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_trafo_day.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_trafo_day : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < plot_trafo_week.getCount(); _pIdx++) {
  		DataSet _ds = plot_trafo_week.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_trafo_week.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_trafo_week : " + _t );
  	}
  	for (int _pIdx = 0; _pIdx < plot_netload_day.getCount(); _pIdx++) {
  		DataSet _ds = plot_netload_day.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plot_netload_day.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plot_netload_day : " + _t );
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
	return this.v_periodRadioButton;
}

public List<ShapeRadioButtonGroup> getAllPeriodRadioButtons() {
	return Arrays.asList(this.rb_periodIncludingYear, this.rb_periodExcludingYear, this.rb_periodPeaksIncludingYear, this.rb_periodPeaksExcludingYear);
}

public ShapeRadioButtonGroup getEnergyTypeRadioButton() {
	return this.radio_energyType;
}

public ShapeGroup getChartGroupWeek() {
	return this.gr_week;
}

public ShapeGroup getChartGroupYear() {
	return this.gr_year;
} 
  // End of additional class code

}
