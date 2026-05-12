package zero_engine;

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

import com.anylogic.libraries.modules.markup_descriptors.*;

import static zero_engine.OL_GridNodeType.*;
import static zero_engine.OL_EnergyCarriers.*;
import static zero_engine.OL_ElectrolyserState.*;
import static zero_engine.OL_GISObjectType.*;
import static zero_engine.OL_EnergyAssetType.*;
import static zero_engine.OL_PBL_OwnershipType.*;
import static zero_engine.OL_ContractType.*;
import static zero_engine.OL_DeliveryContractType.*;
import static zero_engine.OL_TransportContractType.*;
import static zero_engine.OL_ConnectionContractType.*;
import static zero_engine.OL_TaxContractType.*;
import static zero_engine.OL_GridConnectionHeatingType.*;
import static zero_engine.OL_GridConnectionInsulationLabel.*;
import static zero_engine.OL_MobilityPatternType.*;
import static zero_engine.OL_ChargingAttitude.*;
import static zero_engine.OL_BatteryOperationMode.*;
import static zero_engine.OL_ElectrolyserOperationMode.*;
import static zero_engine.OL_ConnectionOwnerType.*;
import static zero_engine.OL_ProfileUnits.*;
import static zero_engine.OL_HouseholdCookingMethod.*;
import static zero_engine.OL_FlowsMapKeys.*;
import static zero_engine.OL_EnergyTaxesBracket.*;
import static zero_engine.OL_ResultScope.*;
import static zero_engine.OL_ParkingSpaceType.*;
import static zero_engine.OL_AmbientTempType.*;
import static zero_engine.OL_AssetFlowCategories.*;
import static zero_engine.OL_VehicleType.*;
import static zero_engine.OL_Days.*;
import static zero_engine.OL_PBL_DwellingType.*;
import static zero_engine.OL_GridConnectionEnergyLabel.*;
import static zero_engine.OL_GridNodeProfileLoaderType.*;
import static zero_engine.OL_GridOperator.*;
import static zero_engine.OL_ConnectionSizeType.*;
import static zero_engine.OL_PVOrientation.*;

import java.awt.geom.Arc2D;

import java.util.EnumSet; 

public class EnergyDataViewer extends Agent
{
  // Parameters

  public 
OL_GISObjectType  p_areaType;

  /**
   * Returns default value for parameter <code>p_areaType</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_GISObjectType _p_areaType_DefaultValue_xjal() {
    final EnergyDataViewer self = this;
    return null;
  }

  public void set_p_areaType( OL_GISObjectType value ) {
    if (value == this.p_areaType) {
      return;
    }
    OL_GISObjectType _oldValue_xjal = this.p_areaType;
    this.p_areaType = value;
    onChange_p_areaType_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_areaType.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_areaType()</code> method instead.
   */
  protected void onChange_p_areaType() {
    onChange_p_areaType_xjal( p_areaType );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_areaType_xjal( OL_GISObjectType oldValue ) {  
  }


  public 
String  p_name;

  /**
   * Returns default value for parameter <code>p_name</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_name_DefaultValue_xjal() {
    final EnergyDataViewer self = this;
    return null;
  }

  public void set_p_name( String value ) {
    if (value == this.p_name) {
      return;
    }
    String _oldValue_xjal = this.p_name;
    this.p_name = value;
    onChange_p_name_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_name.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_name()</code> method instead.
   */
  protected void onChange_p_name() {
    onChange_p_name_xjal( p_name );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_name_xjal( String oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_areaType = _p_areaType_DefaultValue_xjal();
    p_name = _p_name_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_areaType":
      if ( _callOnChange_xjal ) {
        set_p_areaType( (OL_GISObjectType) _value_xjal );
      } else {
        p_areaType = (OL_GISObjectType) _value_xjal;
      }
      return true;
    case "p_name":
      if ( _callOnChange_xjal ) {
        set_p_name( (String) _value_xjal );
      } else {
        p_name = (String) _value_xjal;
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
    case "p_areaType": _result_xjal = p_areaType; break;
    case "p_name": _result_xjal = p_name; break;
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
      list.add( "p_areaType" );
      list.add( "p_name" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
double 
 v_totalEnergySelfConsumed_MWh;
  public 
double 
 v_totalEnergyImport_MWh;
  public 
double 
 v_totalEnergyExport_MWh;
  public 
double 
 v_gridCapacityFeedIn_kW;
  public 
double 
 v_gridCapacityDelivery_kW;
  public 
DataSet 
 v_dataDistrictHeatConsumptionLiveWeek_kW;
  public 
double 
 v_summerWeekEnergySelfConsumed_MWh;
  public 
double 
 v_summerWeekEnergyImport_MWh;
  public 
double 
 v_summerWeekEnergyExport_MWh;
  public 
double 
 v_summerWeekElectricitySelfConsumed_MWh;
  public 
double 
 v_totalElectricitySelfConsumed_MWh;
  public 
double 
 v_totalElectricityConsumed_MWh;
  public 
double 
 v_rooftopPVPotential_kW;
  public 
double 
 v_windPotential_kW;
  public 
DataSet 
 data_dailyAverageFinalEnergyConsumption_kW;
  public 
double 
 v_individualSelfSufficiencyElectricity_fr;
  public 
DataSet 
 v_dataNetbelastingDuurkrommeYear_kW;
  public 
DataSet 
 v_dataNetbelastingDuurkrommeSummer_kW;
  public 
DataSet 
 v_dataNetbelastingDuurkrommeWinter_kW;
  public 
DataSet 
 v_dataNetbelastingDuurkrommeDaytime_kW;
  public 
DataSet 
 v_dataNetbelastingDuurkrommeNighttime_kW;
  public 
DataSet 
 v_dataNetbelastingDuurkrommeWeekend_kW;
  public 
DataSet 
 v_dataNetbelastingDuurkrommeWeekday_kW;
  public 
double 
 v_individualSelfconsumptionElectricity_fr;
  public 
DataSet 
 v_dataNetbelastingDuurkrommeYearVorige_kW;
  public 
DataSet 
 v_dataElectricityFeedInCapacityLiveWeek_kW;
  public 
DataSet 
 v_dataElectricityDeliveryCapacityLiveWeek_kW;
  public 
DataSet 
 v_dataNetLoadLiveWeek_kW;
  public 
DataSet 
 v_dataNetLoadSummerWeek_kW;
  public 
DataSet 
 v_dataNetLoadWinterWeek_kW;
  public 
double 
 v_totalEnergyConsumed_MWh;
  public 
double 
 v_totalEnergyProduced_MWh;
  public 
double 
 v_annualOverloadDurationDelivery_hr;
  public 
double 
 v_annualOverloadDurationFeedin_hr;
  public 
double 
 v_totalEnergyConsumptionForDistrictHeating_MWh;
  public 
double 
 v_totalPrimaryEnergyProductionHeatpumps_MWh;
  public 
double 
 v_totalElectricityProduced_MWh;
  public 
double 
 v_summerWeekEnergyConsumed_MWh;
  public 
double 
 v_summerWeekEnergyProduced_MWh;
  public 
double 
 v_summerWeekElectricityConsumed_MWh;
  public 
double 
 v_summerWeekElectricityProduced_MWh;
  public 
double 
 v_winterWeekEnergyConsumed_MWh;
  public 
double 
 v_winterWeekEnergyProduced_MWh;
  public 
double 
 v_winterWeekEnergySelfConsumed_MWh;
  public 
double 
 v_winterWeekElectricityConsumed_MWh;
  public 
double 
 v_winterWeekElectricitySelfConsumed_MWh;
  public 
double 
 v_winterWeekElectricityProduced_MWh;
  public 
double 
 v_winterWeekEnergyImport_MWh;
  public 
double 
 v_winterWeekEnergyExport_MWh;
  public 
double 
 v_daytimeEnergyImport_MWh;
  public 
double 
 v_daytimeEnergyExport_MWh;
  public 
double 
 v_daytimeEnergyConsumed_MWh;
  public 
double 
 v_daytimeEnergyProduced_MWh;
  public 
double 
 v_daytimeEnergySelfConsumed_MWh;
  public 
double 
 v_nighttimeEnergyImport_MWh;
  public 
double 
 v_nighttimeEnergyExport_MWh;
  public 
double 
 v_nighttimeEnergyConsumed_MWh;
  public 
double 
 v_nighttimeEnergyProduced_MWh;
  public 
double 
 v_nighttimeEnergySelfConsumed_MWh;
  public 
double 
 v_weekdayEnergyImport_MWh;
  public 
double 
 v_weekdayEnergyExport_MWh;
  public 
double 
 v_weekdayEnergyConsumed_MWh;
  public 
double 
 v_weekdayEnergyProduced_MWh;
  public 
double 
 v_weekdayEnergySelfConsumed_MWh;
  public 
double 
 v_weekendEnergyImport_MWh;
  public 
double 
 v_weekendEnergyExport_MWh;
  public 
double 
 v_weekendEnergyConsumed_MWh;
  public 
double 
 v_weekendEnergyProduced_MWh;
  public 
double 
 v_weekendEnergySelfConsumed_MWh;
  public 
double 
 v_totalEnergyCurtailed_MWh;
  public 
double 
 v_totalWindGeneration_MWh;
  public 
double 
 v_totalPVGeneration_MWh;
  public 
EnumSet<OL_EnergyCarriers> 
 v_liveProductionEnergyCarriers;
  public 
EnumSet<OL_EnergyCarriers> 
 v_liveConsumptionEnergyCarriers;
  public 
double 
 v_totalWindEnergyCurtailed_MWh;
  public 
double 
 v_totalPVEnergyCurtailed_MWh;
  public 
double 
 v_rooftopPVInstalled_kW;
  public 
double 
 v_windInstalled_kW;
  public 
DataSet 
 v_dataBatterySOCYear_fr;
  public 
DataSet 
 v_dataBatterySOCSummerWeek_fr;
  public 
DataSet 
 v_dataBatterySOCWinterWeek_fr;
  public 
double 
 v_batteryStorageCapacityInstalled_MWh;
  public 
double 
 v_individualSelfSufficiencyEnergy_fr;
  public 
double 
 v_individualSelfconsumptionEnergy_fr;
  public 
double 
 v_individualPeakDelivery_kW;
  public 
double 
 v_individualPeakFeedin_kW;
  public 
double 
 v_gridCapacityDelivery_groupcontract_kW;
  public 
double 
 v_gridCapacityFeedin_groupcontract_kW;
  public 
I_EnergyData 
 v_engineAgent;
  public 
double 
 v_gridCapacityFeedIn_kW_rapidRun;
  public 
double 
 v_gridCapacityDelivery_kW_rapidRun;
  public 
double 
 v_summerWeekPrimaryEnergyProductionHeatpumps_MWh;
  public 
double 
 v_winterWeekPrimaryEnergyProductionHeatpumps_MWh;
  public 
double 
 v_daytimePrimaryEnergyProductionHeatpumps_MWh;
  public 
double 
 v_nighttimePrimaryEnergyProductionHeatpumps_MWh;
  public 
double 
 v_weekdayPrimaryEnergyProductionHeatpumps_MWh;
  public 
double 
 v_weekendPrimaryEnergyProductionHeatpumps_MWh;
  public 
EnumSet<OL_AssetFlowCategories> 
 v_liveAssetFlowCategories;
  public 
EnumSet<OL_EnergyCarriers> 
 v_rapidRunProductionEnergyCarriers;
  public 
EnumSet<OL_EnergyCarriers> 
 v_rapidRunConsumptionEnergyCarriers;
  public 
EnumSet<OL_AssetFlowCategories> 
 v_rapidRunAssetFlowCategories;
  public 
J_FlowsMap 
 fm_totalImports_MWh;
  public 
J_FlowsMap 
 fm_totalExports_MWh;
  public 
J_FlowsMap 
 fm_summerWeekImports_MWh;
  public 
J_FlowsMap 
 fm_summerWeekExports_MWh;
  public 
J_FlowsMap 
 fm_winterWeekImports_MWh;
  public 
J_FlowsMap 
 fm_winterWeekExports_MWh;
  public 
J_FlowsMap 
 fm_daytimeImports_MWh;
  public 
J_FlowsMap 
 fm_daytimeExports_MWh;
  public 
double 
 v_daytimeElectricityConsumed_MWh;
  public 
double 
 v_daytimeElectricityProduced_MWh;
  public 
double 
 v_daytimeElectricitySelfConsumed_MWh;
  public 
double 
 v_nighttimeElectricityConsumed_MWh;
  public 
double 
 v_weekdayElectricityConsumed_MWh;
  public 
double 
 v_weekendElectricityConsumed_MWh;
  public 
double 
 v_nighttimeElectricityProduced_MWh;
  public 
double 
 v_nighttimeElectricitySelfConsumed_MWh;
  public 
double 
 v_weekdayElectricityProduced_MWh;
  public 
double 
 v_weekdayElectricitySelfConsumed_MWh;
  public 
double 
 v_weekendElectricityProduced_MWh;
  public 
double 
 v_weekendElectricitySelfConsumed_MWh;
  public 
J_FlowsMap 
 fm_nighttimeImports_MWh;
  public 
J_FlowsMap 
 fm_nighttimeExports_MWh;
  public 
J_FlowsMap 
 fm_weekdayImports_MWh;
  public 
J_FlowsMap 
 fm_weekdayExports_MWh;
  public 
J_FlowsMap 
 fm_weekendImports_MWh;
  public 
J_FlowsMap 
 fm_weekendExports_MWh;
  public 
J_DataSetMap 
 dsm_dailyAverageConsumptionDataSets_kW;
  public 
J_DataSetMap 
 dsm_dailyAverageProductionDataSets_kW;
  public 
J_DataSetMap 
 dsm_summerWeekConsumptionDataSets_kW;
  public 
J_DataSetMap 
 dsm_summerWeekProductionDataSets_kW;
  public 
J_DataSetMap 
 dsm_winterWeekConsumptionDataSets_kW;
  public 
J_DataSetMap 
 dsm_winterWeekProductionDataSets_kW;
  public 
J_DataSetMap 
 dsm_liveConsumption_kW;
  public 
J_DataSetMap 
 dsm_liveProduction_kW;
  public 
boolean 
 b_isRealDeliveryCapacityAvailable;
  public 
boolean 
 b_isRealFeedinCapacityAvailable;
  public 
DataSet 
 v_dataBatterySOCLiveWeek_fr;
  public 
J_DataSetMap 
 dsm_assetFlowsSummerWeek_kW;
  public 
J_DataSetMap 
 dsm_assetFlowsWinterWeek_kW;
  public 
J_DataSetMap 
 dsm_assetFlowsAccumulators_kW;
  public 
J_DataSetMap 
 dsm_liveAssetFlowsAccumulators_kW;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( EnergyDataViewer.class );

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
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Functions

  public void f_initializeMaps(  ) { 

// FlowsMaps
fm_totalImports_MWh = new J_FlowsMap();
fm_totalExports_MWh = new J_FlowsMap();
fm_summerWeekImports_MWh = new J_FlowsMap();
fm_summerWeekExports_MWh = new J_FlowsMap();
fm_winterWeekImports_MWh = new J_FlowsMap();
fm_winterWeekExports_MWh = new J_FlowsMap();
fm_daytimeImports_MWh = new J_FlowsMap();
fm_daytimeExports_MWh = new J_FlowsMap();
fm_nighttimeImports_MWh = new J_FlowsMap();
fm_nighttimeExports_MWh = new J_FlowsMap();
fm_weekdayImports_MWh = new J_FlowsMap();
fm_weekdayExports_MWh = new J_FlowsMap();
fm_weekendImports_MWh = new J_FlowsMap();
fm_weekendExports_MWh = new J_FlowsMap();

// DataSetMaps
dsm_liveConsumption_kW = new J_DataSetMap(OL_EnergyCarriers.class);
dsm_liveProduction_kW = new J_DataSetMap(OL_EnergyCarriers.class);
dsm_dailyAverageConsumptionDataSets_kW = new J_DataSetMap(OL_EnergyCarriers.class);
dsm_dailyAverageProductionDataSets_kW = new J_DataSetMap(OL_EnergyCarriers.class);
dsm_summerWeekConsumptionDataSets_kW = new J_DataSetMap(OL_EnergyCarriers.class);
dsm_summerWeekProductionDataSets_kW = new J_DataSetMap(OL_EnergyCarriers.class);
dsm_winterWeekConsumptionDataSets_kW = new J_DataSetMap(OL_EnergyCarriers.class);
dsm_winterWeekProductionDataSets_kW = new J_DataSetMap(OL_EnergyCarriers.class);
 
  }

  public void f_fillEnergyDataViewer( I_EnergyData data, J_TimeParameters timeParameters ) { 

v_engineAgent = data;

//Set live and rapidrun EnumSets for EnergyCarriers and AssetFlowCategories
v_liveConsumptionEnergyCarriers = data.getLiveData().activeConsumptionEnergyCarriers;
v_liveProductionEnergyCarriers = data.getLiveData().activeProductionEnergyCarriers;
v_liveAssetFlowCategories = data.getLiveData().assetsMetaData.activeAssetFlows;

//Update variables
f_updateLiveDatasets(data);

if (data.getRapidRunData() != null) {
	v_rapidRunConsumptionEnergyCarriers = data.getRapidRunData().activeConsumptionEnergyCarriers;
	v_rapidRunProductionEnergyCarriers = data.getRapidRunData().activeProductionEnergyCarriers;
	v_rapidRunAssetFlowCategories = data.getRapidRunData().assetsMetaData.activeAssetFlows;

	//Update variables
	f_updateVariables(data);
	
	//Update variables
	f_updateWeeklyDatasets(data, timeParameters);
	
	//Update variables
	f_updateYearlyDatasets(data, timeParameters);
	
	//Get duurkromme
	f_updateLoadDurationCurve(data);
}
 
  }

  void f_updateVariables( I_EnergyData data ) { 

//Grid capacity
v_gridCapacityDelivery_kW = data.getLiveData().connectionMetaData.getContractedDeliveryCapacity_kW();
v_gridCapacityFeedIn_kW = data.getLiveData().connectionMetaData.getContractedFeedinCapacity_kW();

v_gridCapacityDelivery_kW_rapidRun = data.getRapidRunData().connectionMetaData.getContractedDeliveryCapacity_kW();
v_gridCapacityFeedIn_kW_rapidRun = data.getRapidRunData().connectionMetaData.getContractedFeedinCapacity_kW();
//area.v_gridCapacityDelivery_groupcontract_kW = GC.p_contractedDeliveryCapacity_kW;
//area.v_gridCapacityFeedin_groupcontract_kW = GC.p_contractedFeedinCapacity_kW;

b_isRealDeliveryCapacityAvailable = data.getLiveData().connectionMetaData.getContractedDeliveryCapacityKnown();
b_isRealFeedinCapacityAvailable = data.getLiveData().connectionMetaData.getContractedFeedinCapacityKnown();

//Installed Asset variables
v_batteryStorageCapacityInstalled_MWh = data.getLiveData().assetsMetaData.totalInstalledBatteryStorageCapacity_MWh;

// KPIs for individual vs collective plots 
v_individualSelfconsumptionElectricity_fr = data.getRapidRunData().getTotalElectricitySelfConsumed_MWh()/data.getRapidRunData().getTotalElectricityConsumed_MWh();
v_individualSelfSufficiencyElectricity_fr = data.getRapidRunData().getTotalElectricitySelfConsumed_MWh()/data.getRapidRunData().getTotalElectricityProduced_MWh();

v_individualSelfconsumptionEnergy_fr = data.getRapidRunData().getTotalEnergySelfConsumed_MWh()/data.getRapidRunData().getTotalEnergyConsumed_MWh();
v_individualSelfSufficiencyEnergy_fr = data.getRapidRunData().getTotalEnergySelfConsumed_MWh()/data.getRapidRunData().getTotalEnergyProduced_MWh();

v_individualPeakDelivery_kW = data.getRapidRunData().getPeakDelivery_kW();
v_individualPeakFeedin_kW = data.getRapidRunData().getPeakFeedin_kW();

//========== TOTALS ==========//
fm_totalImports_MWh.clear();
fm_totalExports_MWh.clear();

for (OL_EnergyCarriers energyCarrier : data.getRapidRunData().activeConsumptionEnergyCarriers) {
	fm_totalImports_MWh.put( energyCarrier, data.getRapidRunData().getTotalImport_MWh(energyCarrier) );
}
for (OL_EnergyCarriers energyCarrier : data.getRapidRunData().activeProductionEnergyCarriers) {
	fm_totalExports_MWh.put( energyCarrier, data.getRapidRunData().getTotalExport_MWh(energyCarrier) );
}

v_totalEnergyImport_MWh = data.getRapidRunData().getTotalEnergyImport_MWh();
v_totalEnergyExport_MWh = data.getRapidRunData().getTotalEnergyExport_MWh();

v_totalEnergyConsumed_MWh = data.getRapidRunData().getTotalEnergyConsumed_MWh();
v_totalEnergyProduced_MWh = data.getRapidRunData().getTotalEnergyProduced_MWh();
v_totalEnergySelfConsumed_MWh = data.getRapidRunData().getTotalEnergySelfConsumed_MWh();

v_totalElectricityConsumed_MWh = data.getRapidRunData().getTotalElectricityConsumed_MWh();
v_totalElectricityProduced_MWh = data.getRapidRunData().getTotalElectricityProduced_MWh();
v_totalElectricitySelfConsumed_MWh = data.getRapidRunData().getTotalElectricitySelfConsumed_MWh();

v_annualOverloadDurationDelivery_hr = data.getRapidRunData().getTotalOverloadDurationDelivery_hr();
v_annualOverloadDurationFeedin_hr = data.getRapidRunData().getTotalOverloadDurationFeedin_hr();

v_totalEnergyConsumptionForDistrictHeating_MWh = data.getRapidRunData().getTotalDistrictHeatingConsumption_MWh();
v_totalPrimaryEnergyProductionHeatpumps_MWh = data.getRapidRunData().getTotalPrimaryEnergyProductionHeatpumps_MWh();

//========== SUMMER/WINTER WEEK ==========//
fm_summerWeekImports_MWh.clear();
fm_winterWeekImports_MWh.clear();
fm_summerWeekExports_MWh.clear();
fm_winterWeekExports_MWh.clear();

for (OL_EnergyCarriers energyCarrier : data.getRapidRunData().activeConsumptionEnergyCarriers) {
	fm_summerWeekImports_MWh.put( energyCarrier, data.getRapidRunData().getSummerWeekImport_MWh(energyCarrier) );
	fm_winterWeekImports_MWh.put( energyCarrier, data.getRapidRunData().getWinterWeekImport_MWh(energyCarrier) );
}
for (OL_EnergyCarriers energyCarrier : data.getRapidRunData().activeProductionEnergyCarriers) {
	fm_summerWeekExports_MWh.put( energyCarrier, data.getRapidRunData().getSummerWeekExport_MWh(energyCarrier) );
	fm_winterWeekExports_MWh.put( energyCarrier, data.getRapidRunData().getWinterWeekExport_MWh(energyCarrier) );
}

v_summerWeekEnergyImport_MWh = data.getRapidRunData().getSummerWeekEnergyImport_MWh();
v_summerWeekEnergyExport_MWh = data.getRapidRunData().getSummerWeekEnergyExport_MWh();

v_summerWeekEnergyConsumed_MWh = data.getRapidRunData().getSummerWeekEnergyConsumed_MWh();
v_summerWeekEnergyProduced_MWh = data.getRapidRunData().getSummerWeekEnergyProduced_MWh();
v_summerWeekEnergySelfConsumed_MWh = data.getRapidRunData().getSummerWeekEnergySelfConsumed_MWh();

v_summerWeekElectricityConsumed_MWh = data.getRapidRunData().getSummerWeekElectricityConsumed_MWh();
v_summerWeekElectricityProduced_MWh = data.getRapidRunData().getSummerWeekElectricityProduced_MWh();
v_summerWeekElectricitySelfConsumed_MWh = data.getRapidRunData().getSummerWeekElectricitySelfConsumed_MWh();

v_summerWeekPrimaryEnergyProductionHeatpumps_MWh = data.getRapidRunData().getSummerWeekPrimaryEnergyProductionHeatpumps_MWh();

v_winterWeekEnergyImport_MWh = data.getRapidRunData().getWinterWeekEnergyImport_MWh();
v_winterWeekEnergyExport_MWh = data.getRapidRunData().getWinterWeekEnergyExport_MWh();

v_winterWeekEnergyConsumed_MWh = data.getRapidRunData().getWinterWeekEnergyConsumed_MWh();
v_winterWeekEnergyProduced_MWh = data.getRapidRunData().getWinterWeekEnergyProduced_MWh();
v_winterWeekEnergySelfConsumed_MWh = data.getRapidRunData().getWinterWeekEnergySelfConsumed_MWh();

v_winterWeekElectricityConsumed_MWh = data.getRapidRunData().getWinterWeekElectricityConsumed_MWh();
v_winterWeekElectricityProduced_MWh = data.getRapidRunData().getWinterWeekElectricityProduced_MWh();
v_winterWeekElectricitySelfConsumed_MWh = data.getRapidRunData().getWinterWeekElectricitySelfConsumed_MWh();

v_winterWeekPrimaryEnergyProductionHeatpumps_MWh = data.getRapidRunData().getWinterWeekPrimaryEnergyProductionHeatpumps_MWh();

//========== DAY/NIGHT ==========//
fm_daytimeImports_MWh.clear();
fm_nighttimeImports_MWh.clear();
fm_daytimeExports_MWh.clear();
fm_nighttimeExports_MWh.clear();

for (OL_EnergyCarriers energyCarrier : data.getRapidRunData().activeConsumptionEnergyCarriers) {
	fm_daytimeImports_MWh.put( energyCarrier, data.getRapidRunData().getDaytimeImport_MWh(energyCarrier) );
	fm_nighttimeImports_MWh.put( energyCarrier, data.getRapidRunData().getNighttimeImport_MWh(energyCarrier) );
}
for (OL_EnergyCarriers energyCarrier : data.getRapidRunData().activeProductionEnergyCarriers) {
	fm_daytimeExports_MWh.put( energyCarrier, data.getRapidRunData().getDaytimeExport_MWh(energyCarrier) );
	fm_nighttimeExports_MWh.put( energyCarrier, data.getRapidRunData().getNighttimeExport_MWh(energyCarrier) );
}

v_daytimeEnergyImport_MWh = data.getRapidRunData().getDaytimeEnergyImport_MWh();
v_daytimeEnergyExport_MWh = data.getRapidRunData().getDaytimeEnergyExport_MWh();

v_daytimeEnergyConsumed_MWh = data.getRapidRunData().getDaytimeEnergyConsumed_MWh();
v_daytimeEnergyProduced_MWh = data.getRapidRunData().getDaytimeEnergyProduced_MWh();
v_daytimeEnergySelfConsumed_MWh = data.getRapidRunData().getDaytimeEnergySelfConsumed_MWh();

v_daytimeElectricityConsumed_MWh = data.getRapidRunData().getDaytimeElectricityConsumed_MWh();
v_daytimeElectricityProduced_MWh = data.getRapidRunData().getDaytimeElectricityProduced_MWh();
v_daytimeElectricitySelfConsumed_MWh = data.getRapidRunData().getDaytimeElectricitySelfConsumed_MWh();

v_daytimePrimaryEnergyProductionHeatpumps_MWh = data.getRapidRunData().getDaytimePrimaryEnergyProductionHeatpumps_MWh();

v_nighttimeEnergyImport_MWh = data.getRapidRunData().getNighttimeEnergyImport_MWh();
v_nighttimeEnergyExport_MWh = data.getRapidRunData().getNighttimeEnergyExport_MWh();

v_nighttimeEnergyConsumed_MWh = data.getRapidRunData().getNighttimeEnergyConsumed_MWh();
v_nighttimeEnergyProduced_MWh = data.getRapidRunData().getNighttimeEnergyProduced_MWh();
v_nighttimeEnergySelfConsumed_MWh = data.getRapidRunData().getNighttimeEnergySelfConsumed_MWh();

v_nighttimeElectricityConsumed_MWh = data.getRapidRunData().getNighttimeElectricityConsumed_MWh();
v_nighttimeElectricityProduced_MWh = data.getRapidRunData().getNighttimeElectricityProduced_MWh();
v_nighttimeElectricitySelfConsumed_MWh = data.getRapidRunData().getNighttimeElectricitySelfConsumed_MWh();

v_nighttimePrimaryEnergyProductionHeatpumps_MWh = data.getRapidRunData().getNighttimePrimaryEnergyProductionHeatpumps_MWh();

//========== WEEK/WEEKEND ==========//
fm_weekdayImports_MWh.clear();
fm_weekendImports_MWh.clear();
fm_weekdayExports_MWh.clear();
fm_weekendExports_MWh.clear();

for (OL_EnergyCarriers energyCarrier : data.getRapidRunData().activeConsumptionEnergyCarriers) {
	fm_weekdayImports_MWh.put( energyCarrier, data.getRapidRunData().getWeekdayImport_MWh(energyCarrier) );
	fm_weekendImports_MWh.put( energyCarrier, data.getRapidRunData().getWeekendImport_MWh(energyCarrier) );
}
for (OL_EnergyCarriers energyCarrier : data.getRapidRunData().activeProductionEnergyCarriers) {
	fm_weekdayExports_MWh.put( energyCarrier, data.getRapidRunData().getWeekdayExport_MWh(energyCarrier) );
	fm_weekendExports_MWh.put( energyCarrier, data.getRapidRunData().getWeekendExport_MWh(energyCarrier) );
}

v_weekdayEnergyImport_MWh = data.getRapidRunData().getWeekdayEnergyImport_MWh();
v_weekdayEnergyExport_MWh = data.getRapidRunData().getWeekdayEnergyExport_MWh();

v_weekdayEnergyConsumed_MWh = data.getRapidRunData().getWeekdayEnergyConsumed_MWh();
v_weekdayEnergyProduced_MWh = data.getRapidRunData().getWeekdayEnergyProduced_MWh();
v_weekdayEnergySelfConsumed_MWh = data.getRapidRunData().getWeekdayEnergySelfConsumed_MWh();

v_weekdayElectricityConsumed_MWh = data.getRapidRunData().getWeekdayElectricityConsumed_MWh();
v_weekdayElectricityProduced_MWh = data.getRapidRunData().getWeekdayElectricityProduced_MWh();
v_weekdayElectricitySelfConsumed_MWh = data.getRapidRunData().getWeekdayElectricitySelfConsumed_MWh();

v_weekdayPrimaryEnergyProductionHeatpumps_MWh = data.getRapidRunData().getWeekdayPrimaryEnergyProductionHeatpumps_MWh();

v_weekendEnergyImport_MWh = data.getRapidRunData().getWeekendEnergyImport_MWh();
v_weekendEnergyExport_MWh = data.getRapidRunData().getWeekendEnergyExport_MWh();

v_weekendEnergyConsumed_MWh = data.getRapidRunData().getWeekendEnergyConsumed_MWh();
v_weekendEnergyProduced_MWh = data.getRapidRunData().getWeekendEnergyProduced_MWh();
v_weekendEnergySelfConsumed_MWh = data.getRapidRunData().getWeekendEnergySelfConsumed_MWh();

v_weekendElectricityConsumed_MWh = data.getRapidRunData().getWeekendElectricityConsumed_MWh();
v_weekendElectricityProduced_MWh = data.getRapidRunData().getWeekendElectricityProduced_MWh();
v_weekendElectricitySelfConsumed_MWh = data.getRapidRunData().getWeekendElectricitySelfConsumed_MWh();

v_weekendPrimaryEnergyProductionHeatpumps_MWh = data.getRapidRunData().getWeekendPrimaryEnergyProductionHeatpumps_MWh();
 
  }

  void f_updateLiveDatasets( I_EnergyData data ) { 

//Datasets for live charts
//========== CONSUMPTION ==========//
dsm_liveConsumption_kW = data.getLiveData().dsm_liveDemand_kW;
dsm_liveAssetFlowsAccumulators_kW = data.getLiveData().dsm_liveAssetFlows_kW;
/*
v_dataElectricityBaseloadConsumptionLiveWeek_kW = data.getLiveData().data_baseloadElectricityDemand_kW;
v_dataElectricityForHeatConsumptionLiveWeek_kW = data.getLiveData().data_heatPumpElectricityDemand_kW;
v_dataElectricityForTransportConsumptionLiveWeek_kW = data.getLiveData().data_electricVehicleDemand_kW;
v_dataElectricityForStorageConsumptionLiveWeek_kW = data.getLiveData().data_batteryCharging_kW;
v_dataElectricityForHydrogenConsumptionLiveWeek_kW = data.getLiveData().data_hydrogenElectricityDemand_kW;
v_dataElectricityForCookingConsumptionLiveWeek_kW = data.getLiveData().data_cookingElectricityDemand_kW;
v_dataDistrictHeatConsumptionLiveWeek_kW = data.getLiveData().data_districtHeatDelivery_kW;
*/
//========== PRODUCTION ==========//
dsm_liveProduction_kW = data.getLiveData().dsm_liveSupply_kW;
/*
v_dataWindElectricityProductionLiveWeek_kW = data.getLiveData().data_windGeneration_kW;
v_dataPVElectricityProductionLiveWeek_kW = data.getLiveData().data_PVGeneration_kW;
v_dataStorageElectricityProductionLiveWeek_kW = data.getLiveData().data_batteryDischarging_kW;
v_dataV2GElectricityProductionLiveWeek_kW = data.getLiveData().data_V2GSupply_kW;
v_dataCHPElectricityProductionLiveWeek_kW = data.getLiveData().data_CHPElectricityProductionLiveWeek_kW;
*/
//SOC
v_dataBatterySOCLiveWeek_fr.reset();
for (int i = 0; i < data.getLiveData().data_batteryStoredEnergyLiveWeek_MWh.size(); i++) {
    // Get the x and y values from the source dataset
    double x = data.getLiveData().data_batteryStoredEnergyLiveWeek_MWh.getX(i);
    double y = data.getLiveData().data_batteryStoredEnergyLiveWeek_MWh.getY(i);
    
    // Modify the y value (e.g., divide it by 2)
    double SOC = v_batteryStorageCapacityInstalled_MWh > 0 ? y / v_batteryStorageCapacityInstalled_MWh : 0;
    
    // Add the new x and y values to the target dataset
    v_dataBatterySOCLiveWeek_fr.add(x, SOC);
}

//Total
v_dataNetLoadLiveWeek_kW = data.getLiveData().data_liveElectricityBalance_kW;

//Capacity
v_dataElectricityDeliveryCapacityLiveWeek_kW = data.getLiveData().data_gridCapacityDemand_kW;
v_dataElectricityFeedInCapacityLiveWeek_kW = data.getLiveData().data_gridCapacitySupply_kW;
 
  }

  void f_updateWeeklyDatasets( I_EnergyData data, J_TimeParameters timeParameters ) { 

//========== SUMMER WEEK ==========//
// Consumption
double summerWeekStartTime_h = timeParameters.getStartOfSummerWeek_h() - timeParameters.getRunStartTime_h();
dsm_summerWeekConsumptionDataSets_kW = data.getRapidRunData().am_summerWeekConsumptionAccumulators_kW.getDataSetMap(summerWeekStartTime_h);
for (OL_AssetFlowCategories AC : data.getRapidRunData().am_assetFlowsSummerWeek_kW.keySet()) {
	dsm_assetFlowsSummerWeek_kW.put(AC, data.getRapidRunData().am_assetFlowsSummerWeek_kW.get(AC).getDataSet(summerWeekStartTime_h));
}
/*
v_dataElectricityBaseloadConsumptionSummerWeek_kW = data.getRapidRunData().acc_summerWeekBaseloadElectricityConsumption_kW.getDataSet(summerWeekStartTime_h);
v_dataElectricityForHeatConsumptionSummerWeek_kW = data.getRapidRunData().acc_summerWeekHeatPumpElectricityConsumption_kW.getDataSet(summerWeekStartTime_h);
v_dataElectricityForTransportConsumptionSummerWeek_kW = data.getRapidRunData().acc_summerWeekElectricVehicleConsumption_kW.getDataSet(summerWeekStartTime_h);
v_dataElectricityForStorageConsumptionSummerWeek_kW = data.getRapidRunData().acc_summerWeekBatteriesConsumption_kW.getDataSet(summerWeekStartTime_h);
v_dataElectricityForCookingConsumptionSummerWeek_kW = data.getRapidRunData().acc_summerWeekElectricCookingConsumption_kW.getDataSet(summerWeekStartTime_h);
v_dataElectricityForHydrogenConsumptionSummerWeek_kW = data.getRapidRunData().acc_summerWeekElectrolyserElectricityConsumption_kW.getDataSet(summerWeekStartTime_h);
v_dataDistrictHeatConsumptionSummerWeek_kW = data.getRapidRunData().acc_summerWeekDistrictHeatingConsumption_kW.getDataSet(summerWeekStartTime_h);
*/
// Production
dsm_summerWeekProductionDataSets_kW = data.getRapidRunData().am_summerWeekProductionAccumulators_kW.getDataSetMap(summerWeekStartTime_h);
/*
v_dataElectricityWindProductionSummerWeek_kW = data.getRapidRunData().acc_summerWeekWindProduction_kW.getDataSet(summerWeekStartTime_h);
v_dataElectricityPVProductionSummerWeek_kW = data.getRapidRunData().acc_summerWeekPVProduction_kW.getDataSet(summerWeekStartTime_h);
v_dataElectricityStorageProductionSummerWeek_kW = data.getRapidRunData().acc_summerWeekBatteriesProduction_kW.getDataSet(summerWeekStartTime_h);
v_dataElectricityV2GProductionSummerWeek_kW = data.getRapidRunData().acc_summerWeekV2GProduction_kW.getDataSet(summerWeekStartTime_h);
v_dataElectricityCHPProductionSummerWeek_kW = data.getRapidRunData().acc_summerWeekCHPElectricityProduction_kW.getDataSet(summerWeekStartTime_h);
*/
// Other
v_dataNetLoadSummerWeek_kW = data.getRapidRunData().am_summerWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(summerWeekStartTime_h);

v_dataBatterySOCSummerWeek_fr = new DataSet((int) (168 / timeParameters.getTimeStep_h()));
DataSet summerWeekBatteryStorage = data.getRapidRunData().ts_summerWeekBatteriesStoredEnergy_MWh.getDataSet(summerWeekStartTime_h);
for (int i = 0; i < summerWeekBatteryStorage.size(); i++) {
    // Get the x and y values from the source dataset
    double x = summerWeekBatteryStorage.getX(i);
    double y = summerWeekBatteryStorage.getY(i);
    
    // Modify the y value (e.g., divide it by 2)
    double SOC = v_batteryStorageCapacityInstalled_MWh > 0 ? y / v_batteryStorageCapacityInstalled_MWh : 0;
    
    // Add the new x and y values to the target dataset
    v_dataBatterySOCSummerWeek_fr.add(x, SOC);
}

//========== WINTER WEEK ==========//
// Consumption
double winterWeekStartTime_h = timeParameters.getStartOfWinterWeek_h() - timeParameters.getRunStartTime_h();

dsm_winterWeekConsumptionDataSets_kW = data.getRapidRunData().am_winterWeekConsumptionAccumulators_kW.getDataSetMap(winterWeekStartTime_h);
for (OL_AssetFlowCategories AC : data.getRapidRunData().am_assetFlowsWinterWeek_kW.keySet()) {
	dsm_assetFlowsWinterWeek_kW.put(AC, data.getRapidRunData().am_assetFlowsWinterWeek_kW.get(AC).getDataSet(winterWeekStartTime_h));
}

/*v_dataElectricityBaseloadConsumptionWinterWeek_kW = data.getRapidRunData().acc_winterWeekBaseloadElectricityConsumption_kW.getDataSet(winterWeekStartTime_h);
v_dataElectricityForHeatConsumptionWinterWeek_kW = data.getRapidRunData().acc_winterWeekHeatPumpElectricityConsumption_kW.getDataSet(winterWeekStartTime_h);
v_dataElectricityForTransportConsumptionWinterWeek_kW = data.getRapidRunData().acc_winterWeekElectricVehicleConsumption_kW.getDataSet(winterWeekStartTime_h);
v_dataElectricityForStorageConsumptionWinterWeek_kW = data.getRapidRunData().acc_winterWeekBatteriesConsumption_kW.getDataSet(winterWeekStartTime_h);
v_dataElectricityForCookingConsumptionWinterWeek_kW = data.getRapidRunData().acc_winterWeekElectricCookingConsumption_kW.getDataSet(winterWeekStartTime_h);
v_dataElectricityForHydrogenConsumptionWinterWeek_kW = data.getRapidRunData().acc_winterWeekElectrolyserElectricityConsumption_kW.getDataSet(winterWeekStartTime_h);
v_dataDistrictHeatConsumptionWinterWeek_kW = data.getRapidRunData().acc_winterWeekDistrictHeatingConsumption_kW.getDataSet(winterWeekStartTime_h);
*/
// Production
dsm_winterWeekProductionDataSets_kW = data.getRapidRunData().am_winterWeekProductionAccumulators_kW.getDataSetMap(winterWeekStartTime_h);
/*
v_dataElectricityWindProductionWinterWeek_kW = data.getRapidRunData().acc_winterWeekWindProduction_kW.getDataSet(winterWeekStartTime_h);
v_dataElectricityPVProductionWinterWeek_kW = data.getRapidRunData().acc_winterWeekPVProduction_kW.getDataSet(winterWeekStartTime_h);
v_dataElectricityStorageProductionWinterWeek_kW = data.getRapidRunData().acc_winterWeekBatteriesProduction_kW.getDataSet(winterWeekStartTime_h);
v_dataElectricityV2GProductionWinterWeek_kW = data.getRapidRunData().acc_winterWeekV2GProduction_kW.getDataSet(winterWeekStartTime_h);
v_dataElectricityCHPProductionWinterWeek_kW = data.getRapidRunData().acc_winterWeekCHPElectricityProduction_kW.getDataSet(winterWeekStartTime_h);
*/
// Other
v_dataNetLoadWinterWeek_kW = data.getRapidRunData().am_winterWeekBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getDataSet(winterWeekStartTime_h);
v_dataBatterySOCWinterWeek_fr = new DataSet((int) (168 / timeParameters.getTimeStep_h()));
DataSet winterWeekBatteryStorage = data.getRapidRunData().ts_winterWeekBatteriesStoredEnergy_MWh.getDataSet(winterWeekStartTime_h);
for (int i = 0; i < winterWeekBatteryStorage.size(); i++) {
    // Get the x and y values from the source dataset
    double x = winterWeekBatteryStorage.getX(i);
    double y = winterWeekBatteryStorage.getY(i);
    
    // Modify the y value (e.g., divide it by 2)
    double SOC = v_batteryStorageCapacityInstalled_MWh > 0 ? y / v_batteryStorageCapacityInstalled_MWh : 0;
    
    // Add the new x and y values to the target dataset
    v_dataBatterySOCWinterWeek_fr.add(x, SOC);
} 
  }

  void f_updateYearlyDatasets( I_EnergyData data, J_TimeParameters timeParameters ) { 

//Datasets for yearly profiles chart
//Demand
double startTime_h = timeParameters.getRunStartTime_h();
dsm_dailyAverageConsumptionDataSets_kW = data.getRapidRunData().am_dailyAverageConsumptionAccumulators_kW.getDataSetMap(startTime_h);
dsm_dailyAverageProductionDataSets_kW = data.getRapidRunData().am_dailyAverageProductionAccumulators_kW.getDataSetMap(startTime_h);
dsm_assetFlowsAccumulators_kW = data.getRapidRunData().am_assetFlowsAccumulators_kW.getDataSetMap(startTime_h);
/*
v_dataElectricityBaseloadConsumptionYear_kW = data.getRapidRunData().acc_dailyAverageBaseloadElectricityConsumption_kW.getDataSet(startTime_h);
v_dataElectricityForHeatConsumptionYear_kW = data.getRapidRunData().acc_dailyAverageHeatPumpElectricityConsumption_kW.getDataSet(startTime_h);
v_dataElectricityForTransportConsumptionYear_kW = data.getRapidRunData().acc_dailyAverageElectricVehicleConsumption_kW.getDataSet(startTime_h);
v_dataElectricityForStorageConsumptionYear_kW = data.getRapidRunData().acc_dailyAverageBatteriesConsumption_kW.getDataSet(startTime_h);
v_dataElectricityForHydrogenConsumptionYear_kW = data.getRapidRunData().acc_dailyAverageElectrolyserElectricityConsumption_kW.getDataSet(startTime_h);
v_dataElectricityForCookingConsumptionYear_kW = data.getRapidRunData().acc_dailyAverageElectricCookingConsumption_kW.getDataSet(startTime_h);
v_dataDistrictHeatConsumptionYear_kW = data.getRapidRunData().acc_dailyAverageDistrictHeatingConsumption_kW.getDataSet(startTime_h);
*/
data_dailyAverageFinalEnergyConsumption_kW = data.getRapidRunData().acc_dailyAverageFinalEnergyConsumption_kW.getDataSet(startTime_h);

//Supply
/*
v_dataElectricityWindProductionYear_kW = data.getRapidRunData().acc_dailyAverageWindProduction_kW.getDataSet(startTime_h);
v_dataElectricityPVProductionYear_kW = data.getRapidRunData().acc_dailyAveragePVProduction_kW.getDataSet(startTime_h);
v_dataElectricityStorageProductionYear_kW = data.getRapidRunData().acc_dailyAverageBatteriesProduction_kW.getDataSet(startTime_h);
v_dataElectricityV2GProductionYear_kW = data.getRapidRunData().acc_dailyAverageV2GProduction_kW.getDataSet(startTime_h);
v_dataElectricityCHPProductionYear_kW = data.getRapidRunData().acc_dailyAverageCHPElectricityProduction_kW.getDataSet(startTime_h);
*/

if (data.getRapidRunData().ts_dailyAverageBatteriesStoredEnergy_MWh != null) {
	v_dataBatterySOCYear_fr = new DataSet(roundToInt((timeParameters.getRunEndTime_h() - startTime_h)/24));
	DataSet totalBatteryStorage = data.getRapidRunData().ts_dailyAverageBatteriesStoredEnergy_MWh.getDataSet(startTime_h);
	for (int i = 0; i < totalBatteryStorage.size(); i++) {
	    // Get the x and y values from the source dataset
	    double x = totalBatteryStorage.getX(i);
	    double y = totalBatteryStorage.getY(i);
	    
	    // Modify the y value (e.g., divide it by 2)
	    double SOC = v_batteryStorageCapacityInstalled_MWh > 0 ? y / v_batteryStorageCapacityInstalled_MWh : 0;
	    
	    // Add the new x and y values to the target dataset
	    v_dataBatterySOCYear_fr.add(x, SOC);
	}
} 
  }

  void f_updateLoadDurationCurve( I_EnergyData data ) { 

J_LoadDurationCurves ldc = data.getRapidRunData().getLoadDurationCurves();

v_dataNetbelastingDuurkrommeYear_kW = ldc.ds_loadDurationCurveTotal_kW;
v_dataNetbelastingDuurkrommeYearVorige_kW = ldc.ds_previousLoadDurationCurveTotal_kW;

v_dataNetbelastingDuurkrommeSummer_kW = ldc.ds_loadDurationCurveSummer_kW;
v_dataNetbelastingDuurkrommeWinter_kW = ldc.ds_loadDurationCurveWinter_kW;
v_dataNetbelastingDuurkrommeDaytime_kW = ldc.ds_loadDurationCurveDaytime_kW;
v_dataNetbelastingDuurkrommeNighttime_kW = ldc.ds_loadDurationCurveNighttime_kW;
v_dataNetbelastingDuurkrommeWeekend_kW = ldc.ds_loadDurationCurveWeekend_kW;
v_dataNetbelastingDuurkrommeWeekday_kW = ldc.ds_loadDurationCurveWeekday_kW; 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea viewArea = new ViewArea( this, null, 0, 0, 1920, 980 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1920.0, 980.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "viewArea", this.viewArea );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_back_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_profiles_Font = new Font("SansSerif", 0, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totals_Font = _t_profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_liveWeek_Font = new Font("SansSerif", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_year_Font = _txt_liveWeek_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_summerWeek_Font = _txt_liveWeek_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_winterWeek_Font = _txt_liveWeek_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_yearTotals_Font = _txt_liveWeek_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_SummerWinterWeekTotals_Font = _txt_liveWeek_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_belastingduurkromme_Font = _t_profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gn_Font = _t_profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_other_Font = _t_profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_DayNightTotals_Font = _txt_liveWeek_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_WeekdayWeekendTotals_Font = _txt_liveWeek_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_liveData_Font = _t_profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_rapidRunData_Font = _t_profiles_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_profiles = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totals = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_liveWeek = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_year = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_summerWeek = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_winterWeek = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_yearTotals = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_SummerWinterWeekTotals = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_belastingduurkromme = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gn = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_other = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_DayNightTotals = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_WeekdayWeekendTotals = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_liveData = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_rapidRunData = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_back = 16;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 17;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(t_profiles, t_totals, txt_liveWeek, txt_year, txt_summerWeek, txt_winterWeek, txt_yearTotals, txt_SummerWinterWeekTotals, t_belastingduurkromme, t_gn, t_other, txt_DayNightTotals, txt_WeekdayWeekendTotals, t_liveData, button_back, t_rapidRunData);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _button_back: {
          ShapeButton self = this.button_back;
if (v_engineAgent != null) {
	if (v_engineAgent instanceof GridConnection) {
		((GridConnection)v_engineAgent).va_gridConnection.navigateTo();
	}
	else if (v_engineAgent instanceof EnergyCoop) {
		((EnergyCoop)v_engineAgent).va_coop.navigateTo();	
	}
	else if (v_engineAgent instanceof EnergyModel) {
		((EnergyModel)v_engineAgent).va_engine.navigateTo();	
	}
} 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  protected ShapeButton button_back;
  protected ShapeText t_profiles;
  protected ShapeText t_totals;
  protected ShapeText txt_liveWeek;
  protected ShapeText txt_year;
  protected ShapeText txt_summerWeek;
  protected ShapeText txt_winterWeek;
  protected ShapeText txt_yearTotals;
  protected ShapeText txt_SummerWinterWeekTotals;
  protected ShapeText t_belastingduurkromme;
  protected ShapeText t_gn;
  protected ShapeText t_other;
  protected ShapeText txt_DayNightTotals;
  protected ShapeText txt_WeekdayWeekendTotals;
  protected ShapeText t_liveData;
  protected ShapeText t_rapidRunData;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    button_back = new ShapeButton(
EnergyDataViewer.this, true, 270.0, -100.0,
			100.0, 30.0,
            black, true,
_button_back_Font,
			"Back to Agent" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_back, 0 );
      }
    };
    t_profiles = new ShapeText(
        SHAPE_DRAW_2D, true,316.0, 20.0, 0.0, 0.0,
        black,"Profiles",
        _t_profiles_Font, ALIGNMENT_LEFT );
    t_totals = new ShapeText(
        SHAPE_DRAW_2D, true,796.0, 30.0, 0.0, 0.0,
        black,"Totals",
        _t_totals_Font, ALIGNMENT_LEFT );
    txt_liveWeek = new ShapeText(
        SHAPE_DRAW_2D, true,151.0, 60.0, 0.0, 0.0,
        black,"Live Week",
        _txt_liveWeek_Font, ALIGNMENT_LEFT );
    txt_year = new ShapeText(
        SHAPE_DRAW_2D, true,151.0, 460.0, 0.0, 0.0,
        black,"Year",
        _txt_year_Font, ALIGNMENT_LEFT );
    txt_summerWeek = new ShapeText(
        SHAPE_DRAW_2D, true,150.0, 780.0, 0.0, 0.0,
        black,"Summer Week\n",
        _txt_summerWeek_Font, ALIGNMENT_LEFT );
    txt_winterWeek = new ShapeText(
        SHAPE_DRAW_2D, true,150.0, 1010.0, 0.0, 0.0,
        black,"Winter Week\n",
        _txt_winterWeek_Font, ALIGNMENT_LEFT );
    txt_yearTotals = new ShapeText(
        SHAPE_DRAW_2D, true,646.0, 60.0, 0.0, 0.0,
        black,"Year",
        _txt_yearTotals_Font, ALIGNMENT_LEFT );
    txt_SummerWinterWeekTotals = new ShapeText(
        SHAPE_DRAW_2D, true,616.0, 620.0, 0.0, 0.0,
        black,"Summer / Winter",
        _txt_SummerWinterWeekTotals_Font, ALIGNMENT_LEFT );
    t_belastingduurkromme = new ShapeText(
        SHAPE_DRAW_2D, true,1286.0, 20.0, 0.0, 0.0,
        black,"Belastingduurkromme\n",
        _t_belastingduurkromme_Font, ALIGNMENT_LEFT );
    t_gn = new ShapeText(
        SHAPE_DRAW_2D, true,1246.0, 320.0, 0.0, 0.0,
        black,"GridNode & Capacity",
        _t_gn_Font, ALIGNMENT_LEFT );
    t_other = new ShapeText(
        SHAPE_DRAW_2D, true,1766.0, 40.0, 0.0, 0.0,
        black,"Other",
        _t_other_Font, ALIGNMENT_LEFT );
    txt_DayNightTotals = new ShapeText(
        SHAPE_DRAW_2D, true,626.0, 1210.0, 0.0, 0.0,
        black,"Day / Night",
        _txt_DayNightTotals_Font, ALIGNMENT_LEFT );
    txt_WeekdayWeekendTotals = new ShapeText(
        SHAPE_DRAW_2D, true,626.0, 1850.0, 0.0, 0.0,
        black,"Weekday / Weekend",
        _txt_WeekdayWeekendTotals_Font, ALIGNMENT_LEFT );
    t_liveData = new ShapeText(
        SHAPE_DRAW_2D, true,1280.0, 620.0, 0.0, 0.0,
        black,"Live Data",
        _t_liveData_Font, ALIGNMENT_LEFT );
    t_rapidRunData = new ShapeText(
        SHAPE_DRAW_2D, true,1580.0, 620.0, 0.0, 0.0,
        black,"RapidRun Data",
        _t_rapidRunData_Font, ALIGNMENT_LEFT );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }



  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
    _createPersistentElementsBP0_xjal();
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

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
  public EnergyDataViewer( Engine engine, Agent owner, AgentList<? extends EnergyDataViewer> ownerPopulation ) {
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
    energyModel = get_EnergyModel();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public EnergyDataViewer() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public EnergyDataViewer( OL_GISObjectType p_areaType, String p_name ) {
    markParametersAreSet();
    this.p_areaType = p_areaType;
    this.p_name = p_name;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_EnergyDataViewer_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( EnergyDataViewer.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon = new ShapeModelElementsGroup( EnergyDataViewer.this, getElementProperty( "zero_engine.EnergyDataViewer.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );


    // Space setup
    {
      double _x_xjal = 
500 
;
      double _y_xjal = 
500 
;
      double _z_xjal = 
0 
;
      setupSpace( _x_xjal, _y_xjal, _z_xjal );
    }
    disableSteps();
    setNetworkUserDefined();
    setLayoutType( LAYOUT_USER_DEFINED );
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( EnergyDataViewer.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
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
    setupPlainVariables_EnergyDataViewer_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_EnergyDataViewer_xjal() {
    fm_totalImports_MWh = 
new J_FlowsMap() 
;
    fm_totalExports_MWh = 
new J_FlowsMap() 
;
    fm_summerWeekImports_MWh = 
new J_FlowsMap() 
;
    fm_summerWeekExports_MWh = 
new J_FlowsMap() 
;
    fm_winterWeekImports_MWh = 
new J_FlowsMap() 
;
    fm_winterWeekExports_MWh = 
new J_FlowsMap() 
;
    fm_daytimeImports_MWh = 
new J_FlowsMap() 
;
    fm_daytimeExports_MWh = 
new J_FlowsMap() 
;
    v_daytimeElectricityConsumed_MWh = 
0 
;
    v_daytimeElectricityProduced_MWh = 
0 
;
    v_daytimeElectricitySelfConsumed_MWh = 
0 
;
    v_nighttimeElectricityConsumed_MWh = 
0 
;
    v_weekdayElectricityConsumed_MWh = 
0 
;
    v_weekendElectricityConsumed_MWh = 
0 
;
    v_nighttimeElectricityProduced_MWh = 
0 
;
    v_nighttimeElectricitySelfConsumed_MWh = 
0 
;
    v_weekdayElectricityProduced_MWh = 
0 
;
    v_weekdayElectricitySelfConsumed_MWh = 
0 
;
    v_weekendElectricityProduced_MWh = 
0 
;
    v_weekendElectricitySelfConsumed_MWh = 
0 
;
    fm_nighttimeImports_MWh = 
new J_FlowsMap() 
;
    fm_nighttimeExports_MWh = 
new J_FlowsMap() 
;
    fm_weekdayImports_MWh = 
new J_FlowsMap() 
;
    fm_weekdayExports_MWh = 
new J_FlowsMap() 
;
    fm_weekendImports_MWh = 
new J_FlowsMap() 
;
    fm_weekendExports_MWh = 
new J_FlowsMap() 
;
    dsm_dailyAverageConsumptionDataSets_kW = 
new J_DataSetMap(OL_EnergyCarriers.class) 
;
    dsm_dailyAverageProductionDataSets_kW = 
new J_DataSetMap(OL_EnergyCarriers.class) 
;
    dsm_summerWeekConsumptionDataSets_kW = 
new J_DataSetMap(OL_EnergyCarriers.class) 
;
    dsm_summerWeekProductionDataSets_kW = 
new J_DataSetMap(OL_EnergyCarriers.class) 
;
    dsm_winterWeekConsumptionDataSets_kW = 
new J_DataSetMap(OL_EnergyCarriers.class) 
;
    dsm_winterWeekProductionDataSets_kW = 
new J_DataSetMap(OL_EnergyCarriers.class) 
;
    dsm_liveConsumption_kW = 
new J_DataSetMap(OL_EnergyCarriers.class) 
;
    dsm_liveProduction_kW = 
new J_DataSetMap(OL_EnergyCarriers.class) 
;
    b_isRealDeliveryCapacityAvailable = 
false 
;
    b_isRealFeedinCapacityAvailable = 
false 
;
    v_dataBatterySOCLiveWeek_fr = 
new DataSet(672) 
;
    dsm_assetFlowsSummerWeek_kW = 
new J_DataSetMap(OL_AssetFlowCategories.class) 
;
    dsm_assetFlowsWinterWeek_kW = 
new J_DataSetMap(OL_AssetFlowCategories.class) 
;
    dsm_assetFlowsAccumulators_kW = 
new J_DataSetMap(OL_AssetFlowCategories.class) 
;
    dsm_liveAssetFlowsAccumulators_kW = 
new J_DataSetMap(OL_AssetFlowCategories.class) 
;
  }

  // User API -----------------------------------------------------
  public EnergyModel get_EnergyModel() {
    {
      Agent owner = getOwner();
      if ( owner instanceof EnergyModel ) return (EnergyModel) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zero_engine.EnergyModel energyModel;

  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }


  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public AgentList<? extends EnergyDataViewer> getPopulation() {
    return (AgentList<? extends EnergyDataViewer>) super.getPopulation();
  }

  public List<? extends EnergyDataViewer> agentsInRange( double distance ) {
    return (List<? extends EnergyDataViewer>) super.agentsInRange( distance );
  }


}
