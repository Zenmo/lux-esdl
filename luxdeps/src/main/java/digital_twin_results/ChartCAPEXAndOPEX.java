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

public class ChartCAPEXAndOPEX extends digital_twin_results.ChartArea
{
  // Parameters

  public 
String  p_totalName;

  /**
   * Returns default value for parameter <code>p_totalName</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public String _p_totalName_DefaultValue_xjal() {
    final ChartCAPEXAndOPEX self = this;
    return 
"Totaal" 
;
  }

  public void set_p_totalName( String value ) {
    if (value == this.p_totalName) {
      return;
    }
    String _oldValue_xjal = this.p_totalName;
    this.p_totalName = value;
    onChange_p_totalName_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_totalName.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_totalName()</code> method instead.
   */
  protected void onChange_p_totalName() {
    onChange_p_totalName_xjal( p_totalName );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_totalName_xjal( String oldValue ) {  
  }


  public 
Map<OL_EnergyAssetType, ShapeCheckBox>  map_assetToCheckBox;

  /**
   * Returns default value for parameter <code>map_assetToCheckBox</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_EnergyAssetType, ShapeCheckBox> _map_assetToCheckBox_DefaultValue_xjal() {
    final ChartCAPEXAndOPEX self = this;
    return 
Map.ofEntries(
Map.entry(OL_EnergyAssetType.STORAGE_ELECTRIC, cb_includeAssetBattery),
Map.entry(OL_EnergyAssetType.PHOTOVOLTAIC, cb_includeAssetPV),
Map.entry(OL_EnergyAssetType.HEAT_PUMP_AIR, cb_includeAssetHeatpump),
Map.entry(OL_EnergyAssetType.PHOTOTHERMAL, cb_includeAssetPT),
Map.entry(OL_EnergyAssetType.WINDMILL, cb_includeAssetWindTurbine),
Map.entry(OL_EnergyAssetType.ELECTROLYSER, cb_includeAssetElectrolyser),
Map.entry(OL_EnergyAssetType.DIESEL_GENERATOR, cb_includeAssetDieselGenerator),
Map.entry(OL_EnergyAssetType.METHANE_GENERATOR, cb_includeAssetGasGenerator),
Map.entry(OL_EnergyAssetType.GAS_BURNER, cb_includeAssetGasburner),
Map.entry(OL_EnergyAssetType.ELECTRIC_VEHICLE, cb_includeAssetECar),
Map.entry(OL_EnergyAssetType.ELECTRIC_VAN, cb_includeAssetEVan),
Map.entry(OL_EnergyAssetType.ELECTRIC_TRUCK, cb_includeAssetETruck),
Map.entry(OL_EnergyAssetType.HYDROGEN_TRUCK, cb_includeAssetH2Truck)
) 
;
  }

  public void set_map_assetToCheckBox( Map<OL_EnergyAssetType, ShapeCheckBox> value ) {
    if (value == this.map_assetToCheckBox) {
      return;
    }
    Map<OL_EnergyAssetType, ShapeCheckBox> _oldValue_xjal = this.map_assetToCheckBox;
    this.map_assetToCheckBox = value;
    onChange_map_assetToCheckBox_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_assetToCheckBox.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_assetToCheckBox()</code> method instead.
   */
  protected void onChange_map_assetToCheckBox() {
    onChange_map_assetToCheckBox_xjal( map_assetToCheckBox );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_assetToCheckBox_xjal( Map<OL_EnergyAssetType, ShapeCheckBox> oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_totalName = _p_totalName_DefaultValue_xjal();
    map_assetToCheckBox = _map_assetToCheckBox_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_totalName":
      if ( _callOnChange_xjal ) {
        set_p_totalName( (String) _value_xjal );
      } else {
        p_totalName = (String) _value_xjal;
      }
      return true;
    case "map_assetToCheckBox":
      if ( _callOnChange_xjal ) {
        set_map_assetToCheckBox( (Map<OL_EnergyAssetType, ShapeCheckBox>) _value_xjal );
      } else {
        map_assetToCheckBox = (Map<OL_EnergyAssetType, ShapeCheckBox>) _value_xjal;
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
    case "p_totalName": _result_xjal = p_totalName; break;
    case "map_assetToCheckBox": _result_xjal = map_assetToCheckBox; break;
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
      list.add( "p_totalName" );
      list.add( "map_assetToCheckBox" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
String 
 v_selectedAsset;

  // Collection Variables
  public 
ArrayList <
OL_EnergyAssetType > c_includeAssetSelection = new ArrayList<OL_EnergyAssetType>();
  public 
ArrayList <
OL_EnergyAssetType > c_defaultOrderAssets = new ArrayList<OL_EnergyAssetType>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartCAPEXAndOPEX.class );

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

  public void f_setChartCAPEXAndOPEX(  ) { 

I_EnergyData data = uI_Results.f_getSelectedObjectData();

if(uI_Results.v_selectedObjectScope == OL_ResultScope.GRIDNODE){
	List<OL_ResultScope> supportedResultScopes = new ArrayList<>(List.of(OL_ResultScope.GRIDCONNECTION, OL_ResultScope.ENERGYMODEL, OL_ResultScope.ENERGYCOOP));
	uI_Results.f_activateChartBlocker(supportedResultScopes);
	return;
}

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 60, true);

//Reset chart
f_resetChart();


////Get the netload values
f_initializeAssetSelectionButtons(data);

//Set the actual values of the chart (while trying to maintain the previous selected EC)
String currentSelectedAssetReadableName = v_selectedAsset.equals(p_totalName) ? p_totalName : uI_Results.f_getAssetName(OL_EnergyAssetType.valueOf(v_selectedAsset));
if (Arrays.asList(cb_assetSelection.getItems()).contains(currentSelectedAssetReadableName)) {
	cb_assetSelection.setValue(currentSelectedAssetReadableName, true);
}
else{
	cb_assetSelection.setValue(p_totalName, true);
}
 
  }

  void f_resetChart(  ) { 

//Previous values
t_previousEstimatedLifeTime.setText("");
t_previousCAPEXTotal.setText("");
t_previousCAPEXPerYear.setText("");
t_previousOPEXTotal.setText("");
t_previousOPEXPerYear.setText("");
t_previousCAPEXAndOPEXTotal.setText("");
t_previousCAPEXAndOPEXPerYear.setText("");
 
  }

  
double 
 f_getTotalCAPEXAndOPEXCosts_eurpyr( J_RapidRunData rapidRunData ) { 

double totalCAPEXAndOPEXCosts_eur = 0;

//Initialize variables
double CAPEX_eurpyr = 0;
double OPEX_eurpyr = 0;

//Get only the assets that should be included in calculation
List<OL_EnergyAssetType> selectedAssetList = new ArrayList<>(rapidRunData.assetsMetaData.getActiveAssets());
selectedAssetList.retainAll(c_includeAssetSelection); //Only keep 'included' asset types

for(OL_EnergyAssetType assetType : selectedAssetList){
	//Get economicAVGC values
	double assetExpectedLifeTime_yr = uI_Results.energyModel.avgc_data.economicAVGC.getAvgAssetLifeTime_yr(assetType);
	double assetBaseCAPEX_eur = uI_Results.energyModel.avgc_data.economicAVGC.getAvgAssetBaseCAPEX_eur(assetType);
	double assetBaseOPEX_eurpyr = uI_Results.energyModel.avgc_data.economicAVGC.getAvgAssetBaseOPEX_eurpyr(assetType);
	double assetSizeDependentCAPEX_eurpkW = uI_Results.energyModel.avgc_data.economicAVGC.getAvgAssetSizeDependentCAPEX_eurpkW(assetType);
	double assetSizeDependentOPEX_eurpkWpyr = uI_Results.energyModel.avgc_data.economicAVGC.getAvgAssetSizeDependentOPEX_eurpkWpyr(assetType);

	//Get Current number of assets and their total capacity
	double numberOfAssets = rapidRunData.assetsMetaData.getNumberOfActiveAssets(assetType);
	double assetCapacity_kW = rapidRunData.assetsMetaData.getActiveAssetCapacity_kW(assetType);
	
	if(numberOfAssets > 0){
		CAPEX_eurpyr += (assetCapacity_kW * assetSizeDependentCAPEX_eurpkW + numberOfAssets*assetBaseCAPEX_eur)/ assetExpectedLifeTime_yr;
		OPEX_eurpyr += assetCapacity_kW * assetSizeDependentOPEX_eurpkWpyr + numberOfAssets*assetBaseOPEX_eurpyr;
	}
}

//Return values
return CAPEX_eurpyr + OPEX_eurpyr; 
  }

  void f_initializeAssetSelectionButtons( I_EnergyData data ) { 

//Get energy carrier options (also previous run EC that are not in current).
Set<OL_EnergyAssetType> assets = new HashSet<>();

assets.addAll(data.getRapidRunData().assetsMetaData.getActiveAssets());
if(data.getPreviousRapidRunData() != null){
	assets.addAll(data.getPreviousRapidRunData().assetsMetaData.getActiveAssets());
}

//Activate all check box buttons initially, and select the ones that are selected according to the c_includeAssetSelection
map_assetToCheckBox.values().forEach(cb -> cb.setEnabled(true));	
for(OL_EnergyAssetType EAType : c_includeAssetSelection){ // Set all current 'includedAssetSelection' to 'checked', without calling action.
	map_assetToCheckBox.get(EAType).setSelected(true, false);
}

//EA type is not present: disable and deselect the checkbox (without calling action).
for(OL_EnergyAssetType EAType : c_defaultOrderAssets){
	if(!assets.contains(EAType)){ 
		map_assetToCheckBox.get(EAType).setEnabled(false);
		map_assetToCheckBox.get(EAType).setSelected(false, false);	
	}
}

//Only keep 'included' asset types for the drop down menu
assets.retainAll(c_includeAssetSelection); 

//Order the list to always have the same order in the drop down menu
List<OL_EnergyAssetType> orderedAssets = new ArrayList<>();
for(OL_EnergyAssetType EAType : c_defaultOrderAssets){
	if(assets.contains(EAType)){
		orderedAssets.add(EAType);
	}
}

//Convert to the readable combobox options
String[] comboBoxOptions = new String[orderedAssets.size() + 1];
int i = 0;
for(OL_EnergyAssetType EAType : orderedAssets){
	comboBoxOptions[i] = uI_Results.f_getAssetName(EAType);
	i++;
}
comboBoxOptions[i] = p_totalName;

cb_assetSelection.setItems(comboBoxOptions);
 
  }

  void f_setChartCAPEXAndOPEXValues(  ) { 

I_EnergyData data = uI_Results.f_getSelectedObjectData();

//Reset chart
f_resetChart();

//Initialize variables
double lifeTime_yr = 0;
double CAPEX_eurpyr = 0;
double OPEX_eurpyr = 0;
Double previousLifeTime_yr = null;
Double previousCAPEX_eurpyr = null;
Double previousOPEX_eurpyr = null;


//Get selected List
List<OL_EnergyAssetType> selectedAssetList;
if(v_selectedAsset.equals(p_totalName)){
	selectedAssetList = new ArrayList<>(data.getRapidRunData().assetsMetaData.getActiveAssets());
	selectedAssetList.retainAll(c_includeAssetSelection); //Only keep 'included' asset types
}
else{
	selectedAssetList = new ArrayList<>(List.of(OL_EnergyAssetType.valueOf(v_selectedAsset)));
}

for(OL_EnergyAssetType assetType : selectedAssetList){
	//Get economicAVGC values
	double assetExpectedLifeTime_yr = uI_Results.energyModel.avgc_data.economicAVGC.getAvgAssetLifeTime_yr(assetType);
	double assetBaseCAPEX_eur = uI_Results.energyModel.avgc_data.economicAVGC.getAvgAssetBaseCAPEX_eur(assetType);
	double assetBaseOPEX_eurpyr = uI_Results.energyModel.avgc_data.economicAVGC.getAvgAssetBaseOPEX_eurpyr(assetType);
	double assetSizeDependentCAPEX_eurpkW = uI_Results.energyModel.avgc_data.economicAVGC.getAvgAssetSizeDependentCAPEX_eurpkW(assetType);
	double assetSizeDependentOPEX_eurpkWpyr = uI_Results.energyModel.avgc_data.economicAVGC.getAvgAssetSizeDependentOPEX_eurpkWpyr(assetType);

	//Get Current number of assets and their total capacity
	double numberOfAssets = data.getRapidRunData().assetsMetaData.getNumberOfActiveAssets(assetType);
	double assetCapacity_kW = data.getRapidRunData().assetsMetaData.getActiveAssetCapacity_kW(assetType);

	//Calculate the values
	if(numberOfAssets > 0){
		lifeTime_yr = assetExpectedLifeTime_yr;
		CAPEX_eurpyr += (assetCapacity_kW * assetSizeDependentCAPEX_eurpkW +  numberOfAssets*assetBaseCAPEX_eur)/ assetExpectedLifeTime_yr;
		OPEX_eurpyr += assetCapacity_kW * assetSizeDependentOPEX_eurpkWpyr  +  numberOfAssets*assetBaseOPEX_eurpyr;
	}
	
	//Get previous values, if previous rapid is available
	if(data.getPreviousRapidRunData() != null){
		if(previousCAPEX_eurpyr == null){
			previousLifeTime_yr = 0.0;
			previousCAPEX_eurpyr = 0.0;
			previousOPEX_eurpyr = 0.0;
		}
		//Get previous number of assets and their total capacity	
		double previousNumberOfAssets = data.getPreviousRapidRunData().assetsMetaData.getNumberOfActiveAssets(assetType);
		double previousAssetCapacity_kW = data.getPreviousRapidRunData().assetsMetaData.getActiveAssetCapacity_kW(assetType);
		
		if(previousNumberOfAssets > 0){
			previousLifeTime_yr = assetExpectedLifeTime_yr;
			previousCAPEX_eurpyr += (previousAssetCapacity_kW * assetSizeDependentCAPEX_eurpkW +  previousNumberOfAssets*assetBaseCAPEX_eur) / assetExpectedLifeTime_yr;
			previousOPEX_eurpyr += previousAssetCapacity_kW * assetSizeDependentOPEX_eurpkWpyr +  previousNumberOfAssets*assetBaseOPEX_eurpyr;
		}
	}
}

// For 'total' capex and opex (so multiple assets), the default life time is set to 20, so all calculations are done with the same length
if(v_selectedAsset.equals(p_totalName)){
	lifeTime_yr = 20;
	if(data.getPreviousRapidRunData() != null){
		previousLifeTime_yr = 20.0; 
	}
}

//Set KPIs in chart
f_setYearlyKPIs(lifeTime_yr, CAPEX_eurpyr, OPEX_eurpyr, previousLifeTime_yr, previousCAPEX_eurpyr, previousOPEX_eurpyr);
 
  }

  void f_setYearlyKPIs( double lifeTime_yr, double CAPEX_eurpyr, double OPEX_eurpyr, Double previousLifeTime_yr, Double previousCAPEX_eurpyr, Double previousOPEX_eurpyr ) { 

//Set new values text
DecimalFormat df = new DecimalFormat("#,##0");

double CAPEXLifeTimeTotal_eur = CAPEX_eurpyr * lifeTime_yr;
double OPEXLifeTimeTotal_eur = OPEX_eurpyr * lifeTime_yr;
double CAPEXAndOPEXLifeTimeTotal_eur = CAPEXLifeTimeTotal_eur + OPEXLifeTimeTotal_eur;
double CAPEXAndOPEX_eurpyr = CAPEX_eurpyr + OPEX_eurpyr;

//Set chart texts
t_estimatedLifeTime.setText(roundToDecimal(lifeTime_yr, 2) + " jaar");
t_CAPEXTotal.setText("€ " + df.format(CAPEXLifeTimeTotal_eur));
t_CAPEXPerYear.setText("€ " + df.format(CAPEX_eurpyr));
t_OPEXTotal.setText("€ " + df.format(OPEXLifeTimeTotal_eur));
t_OPEXPerYear.setText("€ " + df.format(OPEX_eurpyr));
t_CAPEXAndOPEXTotal.setText("€ " + df.format(CAPEXAndOPEXLifeTimeTotal_eur));
t_CAPEXAndOPEXPerYear.setText("€ " + df.format(CAPEXAndOPEX_eurpyr));

//If previous values are known, set them as well
if(previousCAPEX_eurpyr != null){

	double previousCAPEXLifeTimeTotal_eur = previousCAPEX_eurpyr * lifeTime_yr;
	double previousOPEXLifeTimeTotal_eur = previousOPEX_eurpyr * lifeTime_yr;
	double previousCAPEXAndOPEXLifeTimeTotal_eur = previousCAPEXLifeTimeTotal_eur + previousOPEXLifeTimeTotal_eur;
	double previousCAPEXAndOPEX_eurpyr = previousCAPEX_eurpyr + previousOPEX_eurpyr;
	
	t_previousEstimatedLifeTime.setText(roundToDecimal(previousLifeTime_yr, 2) + " jaar");
	t_previousCAPEXTotal.setText("€ " + df.format(previousCAPEXLifeTimeTotal_eur));
	t_previousCAPEXPerYear.setText("€ " + df.format(previousCAPEX_eurpyr));
	t_previousOPEXTotal.setText("€ " + df.format(previousOPEXLifeTimeTotal_eur));
	t_previousOPEXPerYear.setText("€ " + df.format(previousOPEX_eurpyr));
	t_previousCAPEXAndOPEXTotal.setText("€ " + df.format(previousCAPEXAndOPEXLifeTimeTotal_eur));
	t_previousCAPEXAndOPEXPerYear.setText("€ " + df.format(previousCAPEXAndOPEX_eurpyr));
}	
	/*
	////Set arrows
	//Import
	if(previousTotalImportCosts_eur > totalImportCosts_eur){
		arrow_down_green_import.setVisible(true);
	}
	else if(totalImportCosts_eur > previousTotalImportCosts_eur){
		arrow_up_red_import.setVisible(true);
	}
	else{
		line_import.setVisible(true);
	}
	
	//Export
	if(previousTotalExportRevenue_eur > totalExportRevenue_eur){
		arrow_down_red_export.setVisible(true);
	}
	else if(totalExportRevenue_eur > previousTotalExportRevenue_eur){
		arrow_up_green_export.setVisible(true);
	}
	else{
		line_export.setVisible(true);
	}
	
	//Net
	if(previousTotalNetElectricityCosts_eur > totalNetElectricityCosts_eur){
		arrow_down_green_netEnergy.setVisible(true);
	}
	else if(totalNetElectricityCosts_eur > previousTotalNetElectricityCosts_eur){
		arrow_up_red_netEnergy.setVisible(true);
	}
	else{
		line_total.setVisible(true);
	}
}
else{ // No previous rapid data -> dont show previous values
	//t_previousTotalImportCosts_eur.setText("-");
	//t_previousTotalExportRevenue_eur.setText("-");
	//t_previousTotalNetEnergyCosts_eur.setText("-");
}
*/ 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_assetSelection_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetBattery_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetECar_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetEVan_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetETruck_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetHeatpump_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetGasburner_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetElectrolyser_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetDieselGenerator_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetGasGenerator_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetPV_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetWindTurbine_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetH2Truck_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_includeAssetPT_Font = _cb_assetSelection_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_CAPEXAndOPEX_Font = new Font("SansSerif", 1, 26 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_openIncludeAssetSelection_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_CAPEXTotal_Font = new Font("SansSerif", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_OPEXTotal_Font = _txt_CAPEXTotal_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_CAPEXAndOPEXTotal_Font = _txt_CAPEXTotal_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_CAPEXAndOPEXPerYear_Font = _txt_CAPEXTotal_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_estimatedLifeTime_Font = _txt_CAPEXTotal_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_OPEXPerYear_Font = _txt_CAPEXTotal_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_CAPEXPerYear_Font = _txt_CAPEXTotal_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_estimatedLifeTime_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_CAPEXTotal_Font = _t_estimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_OPEXTotal_Font = _t_estimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_CAPEXAndOPEXTotal_Font = _t_estimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_CAPEXAndOPEXPerYear_Font = _t_estimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_OPEXPerYear_Font = _t_estimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_CAPEXPerYear_Font = _t_estimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousEstimatedLifeTime_Font = new Font("SansSerif", 2, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousCAPEXTotal_Font = _t_previousEstimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousOPEXTotal_Font = _t_previousEstimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousCAPEXAndOPEXTotal_Font = _t_previousEstimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousCAPEXAndOPEXPerYear_Font = _t_previousEstimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousOPEXPerYear_Font = _t_previousEstimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousCAPEXPerYear_Font = _t_previousEstimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_selectedAsset_Font = _t_estimatedLifeTime_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_includeAssetSelection_Font = _txt_CAPEXTotal_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_includeAssetSelectionExplainer_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_headerKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_CAPEXAndOPEX = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_chartCAPEXAndOPEX = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_openIncludeAssetSelection = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_openIncludeAssetSelection = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_openIncludeAssetSelection = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_CAPEXTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_OPEXTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_CAPEXAndOPEXTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_CAPEXAndOPEXPerYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_estimatedLifeTime = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_OPEXPerYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_CAPEXPerYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_estimatedLifeTime = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_CAPEXTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_OPEXTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_CAPEXAndOPEXTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_CAPEXAndOPEXPerYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_OPEXPerYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_CAPEXPerYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousEstimatedLifeTime = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousCAPEXTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousOPEXTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousCAPEXAndOPEXTotal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousCAPEXAndOPEXPerYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousOPEXPerYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousCAPEXPerYear = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_selectedAsset = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_assetSelection = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_includeAssetSelection = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_includeAssetSelection = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_includeAssetSelectionExplainer = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_close1 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_close2 = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_closeIncludeAssetSelectionGroup = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_includeAssetSelection = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_assetSelection = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetBattery = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetECar = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetEVan = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetETruck = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetHeatpump = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetGasburner = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetElectrolyser = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetDieselGenerator = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetGasGenerator = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetPV = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetWindTurbine = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetH2Truck = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_includeAssetPT = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 52;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 53;

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
	  level.addAll(rect_headerKPI, txt_CAPEXAndOPEX, i_chartCAPEXAndOPEX, gr_openIncludeAssetSelection, txt_CAPEXTotal, txt_OPEXTotal, line, txt_CAPEXAndOPEXTotal, txt_CAPEXAndOPEXPerYear, txt_estimatedLifeTime, txt_OPEXPerYear, txt_CAPEXPerYear, t_estimatedLifeTime, t_CAPEXTotal, t_OPEXTotal, t_CAPEXAndOPEXTotal, t_CAPEXAndOPEXPerYear, t_OPEXPerYear, t_CAPEXPerYear, t_previousEstimatedLifeTime, t_previousCAPEXTotal, t_previousOPEXTotal, t_previousCAPEXAndOPEXTotal, t_previousCAPEXAndOPEXPerYear, t_previousOPEXPerYear, t_previousCAPEXPerYear, gr_assetSelection, gr_includeAssetSelection);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_chartCAPEXAndOPEX:
        if (true) {
          ShapeImage self = this.i_chartCAPEXAndOPEX;
          
uI_Results.f_setInfoText(i_chartCAPEXAndOPEX, uI_Results.v_infoText.chartCAPEXAndOPEX, i_chartCAPEXAndOPEX.getX(), i_chartCAPEXAndOPEX.getY()); 
        }
        break;
      case _gr_openIncludeAssetSelection:
        if (true) {
          ShapeGroup self = this.gr_openIncludeAssetSelection;
          
gr_includeAssetSelection.setVisible(!gr_includeAssetSelection.isVisible()); 
        }
        break;
      case _gr_closeIncludeAssetSelectionGroup:
        if (true) {
          ShapeGroup self = this.gr_closeIncludeAssetSelectionGroup;
          
gr_includeAssetSelection.setVisible(false); 
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
      case _cb_includeAssetBattery: {
          ShapeCheckBox self = this.cb_includeAssetBattery;
if(!cb_includeAssetBattery.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.STORAGE_ELECTRIC);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.STORAGE_ELECTRIC);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetECar: {
          ShapeCheckBox self = this.cb_includeAssetECar;
if(!cb_includeAssetECar.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.ELECTRIC_VEHICLE);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.ELECTRIC_VEHICLE);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetEVan: {
          ShapeCheckBox self = this.cb_includeAssetEVan;
if(!cb_includeAssetEVan.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.ELECTRIC_VAN);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.ELECTRIC_VAN);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetETruck: {
          ShapeCheckBox self = this.cb_includeAssetETruck;
if(!cb_includeAssetETruck.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.ELECTRIC_TRUCK);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.ELECTRIC_TRUCK);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetHeatpump: {
          ShapeCheckBox self = this.cb_includeAssetHeatpump;
if(!cb_includeAssetHeatpump.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.HEAT_PUMP_AIR);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.HEAT_PUMP_AIR);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetGasburner: {
          ShapeCheckBox self = this.cb_includeAssetGasburner;
if(!cb_includeAssetGasburner.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.GAS_BURNER);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.GAS_BURNER);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetElectrolyser: {
          ShapeCheckBox self = this.cb_includeAssetElectrolyser;
if(!cb_includeAssetElectrolyser.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.ELECTROLYSER);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.ELECTROLYSER);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetDieselGenerator: {
          ShapeCheckBox self = this.cb_includeAssetDieselGenerator;
if(!cb_includeAssetDieselGenerator.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.DIESEL_GENERATOR);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.DIESEL_GENERATOR);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetGasGenerator: {
          ShapeCheckBox self = this.cb_includeAssetGasGenerator;
if(!cb_includeAssetGasGenerator.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.METHANE_GENERATOR);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.METHANE_GENERATOR);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetPV: {
          ShapeCheckBox self = this.cb_includeAssetPV;
if(!cb_includeAssetPV.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.PHOTOVOLTAIC);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.PHOTOVOLTAIC);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetWindTurbine: {
          ShapeCheckBox self = this.cb_includeAssetWindTurbine;
if(!cb_includeAssetWindTurbine.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.WINDMILL);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.WINDMILL);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetH2Truck: {
          ShapeCheckBox self = this.cb_includeAssetH2Truck;
if(!cb_includeAssetH2Truck.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.HYDROGEN_TRUCK);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.HYDROGEN_TRUCK);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      case _cb_includeAssetPT: {
          ShapeCheckBox self = this.cb_includeAssetPT;
if(!cb_includeAssetPT.isSelected()){
	c_includeAssetSelection.remove(OL_EnergyAssetType.PHOTOTHERMAL);
}
else{
	c_includeAssetSelection.add(OL_EnergyAssetType.PHOTOTHERMAL);
}

f_setChartCAPEXAndOPEX(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }


  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, String value ) {
    switch( _shape ) {
      case _cb_assetSelection: {
          ShapeComboBox self = this.cb_assetSelection;
if(cb_assetSelection.getValue().equals(p_totalName)){
	v_selectedAsset = p_totalName;
}
else{
	for(OL_EnergyAssetType EAType : c_defaultOrderAssets){
		if(cb_assetSelection.getValue().equals(uI_Results.f_getAssetName(EAType))){
			v_selectedAsset = EAType.toString();
		}
	}
}

f_setChartCAPEXAndOPEXValues(); 
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
      case _cb_includeAssetBattery: return 
true 
;
      case _cb_includeAssetECar: return 
true 
;
      case _cb_includeAssetEVan: return 
true 
;
      case _cb_includeAssetETruck: return 
true 
;
      case _cb_includeAssetHeatpump: return 
true 
;
      case _cb_includeAssetGasburner: return 
true 
;
      case _cb_includeAssetElectrolyser: return 
true 
;
      case _cb_includeAssetDieselGenerator: return 
true 
;
      case _cb_includeAssetGasGenerator: return 
true 
;
      case _cb_includeAssetPV: return 
true 
;
      case _cb_includeAssetWindTurbine: return 
true 
;
      case _cb_includeAssetH2Truck: return 
true 
;
      case _cb_includeAssetPT: return 
true 
;
      default: return super.getShapeControlDefaultValueBoolean( _shape, index );
    }
  }

  protected ShapeComboBox cb_assetSelection;
  protected ShapeCheckBox cb_includeAssetBattery;
  protected ShapeCheckBox cb_includeAssetECar;
  protected ShapeCheckBox cb_includeAssetEVan;
  protected ShapeCheckBox cb_includeAssetETruck;
  protected ShapeCheckBox cb_includeAssetHeatpump;
  protected ShapeCheckBox cb_includeAssetGasburner;
  protected ShapeCheckBox cb_includeAssetElectrolyser;
  protected ShapeCheckBox cb_includeAssetDieselGenerator;
  protected ShapeCheckBox cb_includeAssetGasGenerator;
  protected ShapeCheckBox cb_includeAssetPV;
  protected ShapeCheckBox cb_includeAssetWindTurbine;
  protected ShapeCheckBox cb_includeAssetH2Truck;
  protected ShapeCheckBox cb_includeAssetPT;
  
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
  protected ShapeText txt_CAPEXAndOPEX;
  protected ShapeImage i_chartCAPEXAndOPEX;
  protected ShapeRectangle rect_openIncludeAssetSelection;
  protected ShapeText txt_openIncludeAssetSelection;
  protected ShapeGroup gr_openIncludeAssetSelection;
  protected ShapeText txt_CAPEXTotal;
  protected ShapeText txt_OPEXTotal;
  protected ShapeLine line;
  protected ShapeText txt_CAPEXAndOPEXTotal;
  protected ShapeText txt_CAPEXAndOPEXPerYear;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_estimatedLifeTime_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
v_selectedAsset.equals(p_totalName) ? "Berekend voor een duur van:" : "Verwachte levensduur:" 
);
  }
  
  protected ShapeText txt_estimatedLifeTime;
  protected ShapeText txt_OPEXPerYear;
  protected ShapeText txt_CAPEXPerYear;
  protected ShapeText t_estimatedLifeTime;
  protected ShapeText t_CAPEXTotal;
  protected ShapeText t_OPEXTotal;
  protected ShapeText t_CAPEXAndOPEXTotal;
  protected ShapeText t_CAPEXAndOPEXPerYear;
  protected ShapeText t_OPEXPerYear;
  protected ShapeText t_CAPEXPerYear;
  protected ShapeText t_previousEstimatedLifeTime;
  protected ShapeText t_previousCAPEXTotal;
  protected ShapeText t_previousOPEXTotal;
  protected ShapeText t_previousCAPEXAndOPEXTotal;
  protected ShapeText t_previousCAPEXAndOPEXPerYear;
  protected ShapeText t_previousOPEXPerYear;
  protected ShapeText t_previousCAPEXPerYear;
  protected ShapeText txt_selectedAsset;
  protected ShapeGroup gr_assetSelection;
  protected ShapeRectangle rect_includeAssetSelection;
  protected ShapeText txt_includeAssetSelection;
  protected ShapeText txt_includeAssetSelectionExplainer;
  protected ShapeRectangle rectangle;
  protected ShapeLine line_close1;
  protected ShapeLine line_close2;
  protected ShapeGroup gr_closeIncludeAssetSelectionGroup;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_includeAssetSelection_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
220 
);
    shape.setY(
260 
);
  }
  
  protected ShapeGroup gr_includeAssetSelection;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    cb_assetSelection = new ShapeComboBox(
ChartCAPEXAndOPEX.this, true, 10.0, -10.0,
			150.0, 20.0,
            white, black, true,
_cb_assetSelection_Font,
            new String[]{}, false, ShapeControl.TYPE_STRING ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_assetSelection, 0, value );
      }
    };
    cb_includeAssetBattery = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,-140.0, -40.0,
		100.0, 30.0,
            black, true,
            _cb_includeAssetBattery_Font,
			"Batterij" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetBattery, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetBattery, 0 ) );
      }
    };
    cb_includeAssetECar = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,40.0, -20.0,
		130.0, 30.0,
            black, true,
            _cb_includeAssetECar_Font,
			"Elektrische Auto's" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetECar, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetECar, 0 ) );
      }
    };
    cb_includeAssetEVan = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,40.0, 0.0,
		150.0, 30.0,
            black, true,
            _cb_includeAssetEVan_Font,
			"Elektrische busjes" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetEVan, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetEVan, 0 ) );
      }
    };
    cb_includeAssetETruck = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,40.0, 20.0,
		140.0, 30.0,
            black, true,
            _cb_includeAssetETruck_Font,
			"Elektrische Trucks" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetETruck, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetETruck, 0 ) );
      }
    };
    cb_includeAssetHeatpump = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,-140.0, 0.0,
		100.0, 30.0,
            black, true,
            _cb_includeAssetHeatpump_Font,
			"Warmtepompen" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetHeatpump, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetHeatpump, 0 ) );
      }
    };
    cb_includeAssetGasburner = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,40.0, -40.0,
		100.0, 30.0,
            black, true,
            _cb_includeAssetGasburner_Font,
			"Gasbranders" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetGasburner, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetGasburner, 0 ) );
      }
    };
    cb_includeAssetElectrolyser = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,-140.0, 60.0,
		140.0, 30.0,
            black, true,
            _cb_includeAssetElectrolyser_Font,
			"Waterstof Electrolyser" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetElectrolyser, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetElectrolyser, 0 ) );
      }
    };
    cb_includeAssetDieselGenerator = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,-140.0, 80.0,
		110.0, 30.0,
            black, true,
            _cb_includeAssetDieselGenerator_Font,
			"Diesel generator" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetDieselGenerator, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetDieselGenerator, 0 ) );
      }
    };
    cb_includeAssetGasGenerator = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,-140.0, 100.0,
		100.0, 30.0,
            black, true,
            _cb_includeAssetGasGenerator_Font,
			"Gas generator" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetGasGenerator, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetGasGenerator, 0 ) );
      }
    };
    cb_includeAssetPV = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,-140.0, -20.0,
		100.0, 30.0,
            black, true,
            _cb_includeAssetPV_Font,
			"Zonnepanelen" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetPV, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetPV, 0 ) );
      }
    };
    cb_includeAssetWindTurbine = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,-140.0, 40.0,
		100.0, 30.0,
            black, true,
            _cb_includeAssetWindTurbine_Font,
			"Windturbine" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetWindTurbine, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetWindTurbine, 0 ) );
      }
    };
    cb_includeAssetH2Truck = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,40.0, 40.0,
		140.0, 30.0,
            black, true,
            _cb_includeAssetH2Truck_Font,
			"Waterstof Trucks" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetH2Truck, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetH2Truck, 0 ) );
      }
    };
    cb_includeAssetPT = new ShapeCheckBox(
ChartCAPEXAndOPEX.this,true,-140.0, 20.0,
		100.0, 30.0,
            black, true,
            _cb_includeAssetPT_Font,
			"PT-panelen" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_includeAssetPT, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_includeAssetPT, 0 ) );
      }
    };
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
    txt_CAPEXAndOPEX = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 10.0, 0.0, 0.0,
        black,"CAPEX & OPEX",
        _txt_CAPEXAndOPEX_Font, ALIGNMENT_CENTER );
    i_chartCAPEXAndOPEX = new ShapeImage(
		ChartCAPEXAndOPEX.this, SHAPE_DRAW_2D3D, true, 340.0, 10.0, 0.0, 0.0,
30.0, 30.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_chartCAPEXAndOPEX, 0, clickx, clicky );
      }
    };
    rect_openIncludeAssetSelection = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, -20.0, 0.0, 0.0,
            silver, white,
			400.0, 40.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_openIncludeAssetSelection = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -6.0, 0.0, 0.0,
        black,"Klik hier om de CAPEX & OPEX berekening te configureren",
        _txt_openIncludeAssetSelection_Font, ALIGNMENT_CENTER );
    txt_CAPEXTotal = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 324.0, 0.0, 0.0,
        black,"CAPEX totaal:",
        _txt_CAPEXTotal_Font, ALIGNMENT_LEFT );
    txt_OPEXTotal = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 454.0, 0.0, 0.0,
        black,"OPEX totaal:",
        _txt_OPEXTotal_Font, ALIGNMENT_LEFT );
    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 30.0, 571.0, 0.0, black,
 		400.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    txt_CAPEXAndOPEXTotal = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 604.0, 0.0, 0.0,
        black,"CAPEX & OPEX totaal:",
        _txt_CAPEXAndOPEXTotal_Font, ALIGNMENT_LEFT );
    txt_CAPEXAndOPEXPerYear = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 674.0, 0.0, 0.0,
        black,"CAPEX & OPEX per jaar:",
        _txt_CAPEXAndOPEXPerYear_Font, ALIGNMENT_LEFT );
    txt_estimatedLifeTime = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 254.0, 0.0, 0.0,
        black,"Verwachte levensduur:",
        _txt_estimatedLifeTime_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_estimatedLifeTime_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_OPEXPerYear = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 514.0, 0.0, 0.0,
        black,"OPEX per jaar:",
        _txt_OPEXPerYear_Font, ALIGNMENT_LEFT );
    txt_CAPEXPerYear = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 384.0, 0.0, 0.0,
        black,"CAPEX per jaar:",
        _txt_CAPEXPerYear_Font, ALIGNMENT_LEFT );
    t_estimatedLifeTime = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 251.0, 0.0, 0.0,
        black,"20.5 jaar",
        _t_estimatedLifeTime_Font, ALIGNMENT_RIGHT );
    t_CAPEXTotal = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 321.0, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_CAPEXTotal_Font, ALIGNMENT_RIGHT );
    t_OPEXTotal = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 451.0, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_OPEXTotal_Font, ALIGNMENT_RIGHT );
    t_CAPEXAndOPEXTotal = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 601.0, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_CAPEXAndOPEXTotal_Font, ALIGNMENT_RIGHT );
    t_CAPEXAndOPEXPerYear = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 671.0, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_CAPEXAndOPEXPerYear_Font, ALIGNMENT_RIGHT );
    t_OPEXPerYear = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 511.0, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_OPEXPerYear_Font, ALIGNMENT_RIGHT );
    t_CAPEXPerYear = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 381.0, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_CAPEXPerYear_Font, ALIGNMENT_RIGHT );
    t_previousEstimatedLifeTime = new ShapeText(
        SHAPE_DRAW_2D, true,419.5, 280.5, 0.0, 0.0,
        black,"20.5 jaar",
        _t_previousEstimatedLifeTime_Font, ALIGNMENT_RIGHT );
    t_previousCAPEXTotal = new ShapeText(
        SHAPE_DRAW_2D, true,419.5, 350.5, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_previousCAPEXTotal_Font, ALIGNMENT_RIGHT );
    t_previousOPEXTotal = new ShapeText(
        SHAPE_DRAW_2D, true,419.5, 480.5, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_previousOPEXTotal_Font, ALIGNMENT_RIGHT );
    t_previousCAPEXAndOPEXTotal = new ShapeText(
        SHAPE_DRAW_2D, true,419.5, 630.5, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_previousCAPEXAndOPEXTotal_Font, ALIGNMENT_RIGHT );
    t_previousCAPEXAndOPEXPerYear = new ShapeText(
        SHAPE_DRAW_2D, true,419.5, 700.5, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_previousCAPEXAndOPEXPerYear_Font, ALIGNMENT_RIGHT );
    t_previousOPEXPerYear = new ShapeText(
        SHAPE_DRAW_2D, true,419.5, 540.5, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_previousOPEXPerYear_Font, ALIGNMENT_RIGHT );
    t_previousCAPEXPerYear = new ShapeText(
        SHAPE_DRAW_2D, true,419.5, 410.5, 0.0, 0.0,
        black,"€ 3,200,000",
        _t_previousCAPEXPerYear_Font, ALIGNMENT_RIGHT );
    txt_selectedAsset = new ShapeText(
        SHAPE_DRAW_2D, true,-170.0, -10.0, 0.0, 0.0,
        black,"Geselecteerde asset:",
        _txt_selectedAsset_Font, ALIGNMENT_LEFT );
    rect_includeAssetSelection = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-200.0, -140.0, 0.0, 0.0,
            black, white,
			420.0, 280.0, 10.0, 2.0, LINE_STYLE_SOLID );
    txt_includeAssetSelection = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, -120.0, 0.0, 0.0,
        black,"Welke assets moeten meegenomen \nworden in de totaal berekening?",
        _txt_includeAssetSelection_Font, ALIGNMENT_CENTER );
    txt_includeAssetSelectionExplainer = new ShapeText(
        SHAPE_DRAW_2D, true,-120.0, -70.0, 0.0, 0.0,
        black,"(Selecteer welke assets wel moeten worden meegenomen)",
        _txt_includeAssetSelectionExplainer_Font, ALIGNMENT_LEFT );
    rectangle = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-15.0, -15.0, 0.0, 0.0,
            silver, white,
			25.0, 25.0, 10.0, 1.0, LINE_STYLE_SOLID );
    line_close1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, -10.0, 5.0, 0.0, silver,
 		15.0,	-15.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line_close2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 5.0, 5.0, 0.0, silver,
 		-15.0,	-15.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_openIncludeAssetSelection = new ShapeGroup( ChartCAPEXAndOPEX.this, SHAPE_DRAW_2D3D, true, 230.0, 140.0, 0.0, 0.0
	
	     , rect_openIncludeAssetSelection
	     , txt_openIncludeAssetSelection ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_openIncludeAssetSelection, 0, clickx, clicky );
      }
    };
    }
    {
    gr_assetSelection = new ShapeGroup( ChartCAPEXAndOPEX.this, SHAPE_DRAW_2D3D, true, 240.0, 190.0, 0.0, 0.0
	
	     , txt_selectedAsset
	     , cb_assetSelection );
    }
    {
    gr_closeIncludeAssetSelectionGroup = new ShapeGroup( ChartCAPEXAndOPEX.this, SHAPE_DRAW_2D3D, true, 200.0, -115.0, 0.0, 0.0
	
	     , rectangle
	     , line_close1
	     , line_close2 ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _gr_closeIncludeAssetSelectionGroup, 0, clickx, clicky );
      }
    };
    }
    {
    gr_includeAssetSelection = new ShapeGroup( ChartCAPEXAndOPEX.this, SHAPE_DRAW_2D3D, true, 800.0, 230.0, 0.0, 0.0
	
	     , rect_includeAssetSelection
	     , cb_includeAssetBattery
	     , txt_includeAssetSelection
	     , txt_includeAssetSelectionExplainer
	     , cb_includeAssetECar
	     , cb_includeAssetEVan
	     , cb_includeAssetETruck
	     , cb_includeAssetHeatpump
	     , cb_includeAssetGasburner
	     , cb_includeAssetElectrolyser
	     , cb_includeAssetDieselGenerator
	     , cb_includeAssetGasGenerator
	     , cb_includeAssetPV
	     , cb_includeAssetWindTurbine
	     , cb_includeAssetH2Truck
	     , cb_includeAssetPT
	     , gr_closeIncludeAssetSelectionGroup ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_includeAssetSelection_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_includeAssetSelection.setVisible( false );
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
  public ChartCAPEXAndOPEX( Engine engine, Agent owner, AgentList<? extends ChartCAPEXAndOPEX> ownerPopulation ) {
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
  public ChartCAPEXAndOPEX() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public ChartCAPEXAndOPEX( String p_totalName, Map<OL_EnergyAssetType, ShapeCheckBox> map_assetToCheckBox ) {
    markParametersAreSet();
    this.p_totalName = p_totalName;
    this.map_assetToCheckBox = map_assetToCheckBox;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartCAPEXAndOPEX_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    addAll( c_includeAssetSelection, new OL_EnergyAssetType[] 
{
OL_EnergyAssetType.STORAGE_ELECTRIC,
OL_EnergyAssetType.PHOTOVOLTAIC,
OL_EnergyAssetType.HEAT_PUMP_AIR,
OL_EnergyAssetType.PHOTOTHERMAL,
OL_EnergyAssetType.WINDMILL,
OL_EnergyAssetType.ELECTROLYSER,
OL_EnergyAssetType.DIESEL_GENERATOR,
OL_EnergyAssetType.METHANE_GENERATOR,
OL_EnergyAssetType.GAS_BURNER,
OL_EnergyAssetType.ELECTRIC_VEHICLE,
OL_EnergyAssetType.ELECTRIC_VAN,
OL_EnergyAssetType.ELECTRIC_TRUCK,
OL_EnergyAssetType.HYDROGEN_TRUCK
} 
    );
    addAll( c_defaultOrderAssets, new OL_EnergyAssetType[] 
{
OL_EnergyAssetType.STORAGE_ELECTRIC,
OL_EnergyAssetType.PHOTOVOLTAIC,
OL_EnergyAssetType.HEAT_PUMP_AIR,
OL_EnergyAssetType.PHOTOTHERMAL,
OL_EnergyAssetType.WINDMILL,
OL_EnergyAssetType.ELECTROLYSER,
OL_EnergyAssetType.DIESEL_GENERATOR,
OL_EnergyAssetType.METHANE_GENERATOR,
OL_EnergyAssetType.GAS_BURNER,
OL_EnergyAssetType.ELECTRIC_VEHICLE,
OL_EnergyAssetType.ELECTRIC_VAN,
OL_EnergyAssetType.ELECTRIC_TRUCK,
OL_EnergyAssetType.HYDROGEN_TRUCK
} 
    );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartCAPEXAndOPEX.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartCAPEXAndOPEX.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    cb_includeAssetBattery.setValueToDefault();
    cb_includeAssetECar.setValueToDefault();
    cb_includeAssetEVan.setValueToDefault();
    cb_includeAssetETruck.setValueToDefault();
    cb_includeAssetHeatpump.setValueToDefault();
    cb_includeAssetGasburner.setValueToDefault();
    cb_includeAssetElectrolyser.setValueToDefault();
    cb_includeAssetDieselGenerator.setValueToDefault();
    cb_includeAssetGasGenerator.setValueToDefault();
    cb_includeAssetPV.setValueToDefault();
    cb_includeAssetWindTurbine.setValueToDefault();
    cb_includeAssetH2Truck.setValueToDefault();
    cb_includeAssetPT.setValueToDefault();
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
    setupPlainVariables_ChartCAPEXAndOPEX_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartCAPEXAndOPEX_xjal() {
    v_selectedAsset = 
p_totalName 
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

  public AgentList<? extends ChartCAPEXAndOPEX> getPopulation() {
    return (AgentList<? extends ChartCAPEXAndOPEX>) super.getPopulation();
  }

  public List<? extends ChartCAPEXAndOPEX> agentsInRange( double distance ) {
    return (List<? extends ChartCAPEXAndOPEX>) super.agentsInRange( distance );
  }


}
