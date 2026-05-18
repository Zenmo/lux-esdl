package zerointerfaceloader;

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
import digital_twin_results.*;

import static zerointerfaceloader.OL_FilterOptionsGC.*;
import static zerointerfaceloader.OL_GISBuildingTypes.*;
import static zerointerfaceloader.OL_ProjectType.*;
import static zerointerfaceloader.OL_CustomScenarioTabs.*;
import static zerointerfaceloader.OL_SurveyType.*;
import static zerointerfaceloader.OL_MapOverlayTypes.*;
import static zerointerfaceloader.OL_UserGCAccessType.*;
import static zerointerfaceloader.OL_UserNBHAccessType.*;

import java.awt.geom.Arc2D;

import zeroPackage.ZeroMath; 

public class tabHeating extends zerointerfaceloader.tabArea
{
  // Parameters
  // Plain Variables

  public 
int 
 v_currentPageIndex;

  // Collection Variables
  public 
ArrayList <
ShapeGroup > c_loadedPageGroups = new ArrayList<ShapeGroup>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( tabHeating.class );

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
  protected static final int _STATECHART_COUNT_xjal = zerointerfaceloader.tabArea._STATECHART_COUNT_xjal + 0;


  // Functions

  /**
   * Function that reduces the heat demand of all profile and consumption assets.  Takes as arguments a list of GridConnections to effect and a percentage to reduce by compared to the default value of the assets. Does not effect heating demand from gridconnection that have a thermal building model. 
   */
  protected void f_setDemandReductionHeating( List<GridConnection> gcList, double demandReduction_pct ) { 

double scalingFactor = 1 - demandReduction_pct/100;

for (GridConnection gc : gcList) {
	// Set Profile Assets
	for (J_EAProfile j_ea : gc.c_profileAssets) {
		if (j_ea.getEnergyCarrier() == OL_EnergyCarriers.HEAT && !(j_ea instanceof J_EAProduction)) {
			j_ea.setProfileScaling_fr( scalingFactor );
		}
	}
	
	if(gc.p_BuildingThermalAsset != null){
		gc.p_BuildingThermalAsset.setLossScalingFactor_fr(scalingFactor);
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  public 
double 
 f_calculatePeakHeatDemand_kW( GridConnection gc ) { 

double peakHeatDemand_kW = 0.0;
for (J_EAProfile j_ea : gc.c_profileAssets) {
	if (j_ea.getEnergyCarrier() == OL_EnergyCarriers.HEAT) {
		peakHeatDemand_kW += j_ea.getPeakConsumptionPower_kW();
	}
}
if (gc.p_BuildingThermalAsset != null) {
	double maximalTemperatureDifference_K = 30.0; // Approximation
	peakHeatDemand_kW += gc.p_BuildingThermalAsset.getLossFactor_WpK() * maximalTemperatureDifference_K / 1000;
}
return peakHeatDemand_kW; 
  }

  void f_addDistrictHeatingToAllHouses( List<GCHouse> housesGCList ) { 

for (GCHouse house: housesGCList ) {
	// Remove the existing heating assets
	house.f_removeAllHeatingAssets();
	
	// Add a heat node
	house.p_parentNodeHeat = findFirst(zero_Interface.energyModel.f_getGridNodesTopLevel(), node -> node.p_energyCarrier == OL_EnergyCarriers.HEAT);
	// Create a heat node if it does not exist yet
	if(house.p_parentNodeHeat == null){
		GridNode GN_heat = zero_Interface.energyModel.add_pop_gridNodes();
		zero_Interface.energyModel.f_getGridNodesTopLevel().add(GN_heat);
		GN_heat.p_gridNodeID = "Heatgrid";
		
		// Check wether transformer capacity is known or estimated
		GN_heat.p_capacity_kW = 1000000;	
		GN_heat.p_realCapacityAvailable = false;
		
		// Basic GN information
		GN_heat.p_description = "Warmtenet";
	
		//Define node type
		GN_heat.p_nodeType = OL_GridNodeType.HT;
		GN_heat.p_energyCarrier = OL_EnergyCarriers.HEAT;
	
		//Define GN location
		GN_heat.p_latitude = 0;
		GN_heat.p_longitude = 0;
		GN_heat.setLatLon(GN_heat.p_latitude, GN_heat.p_longitude);
		
		//Connect
		house.p_parentNodeHeat = GN_heat;
		
		//Show warning that heat grid is not a simple solution
		zero_Interface.f_setErrorScreen("LET OP: Er is nu een 'warmtenet' gecreëerd. Maar er is geen warmtebron aanwezig in het model. Daarom zal de benodigde warmte voor het warmtenet in de resultaten te zien zijn als warmte import.", 0, 0);
	}
	house.p_parentNodeHeatID = house.p_parentNodeHeat.p_gridNodeID;
	
	double outputTemperature_degC = zero_Interface.energyModel.avgc_data.p_avgOutputTemperatureDistrictHeatingDeliverySet_degC;
	double peakHeatDemand_kW = f_calculatePeakHeatDemand_kW(house);
	double efficiency = zero_Interface.energyModel.avgc_data.p_avgEfficiencyDistrictHeatingDeliverySet_fr;
	
	new J_EAConversionHeatDeliverySet(house, peakHeatDemand_kW, efficiency, zero_Interface.energyModel.p_timeParameters, outputTemperature_degC);
	
	house.f_addHeatManagement(OL_GridConnectionHeatingType.DISTRICTHEAT, false);
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  void f_removeDistrictHeatingFromAllHouses( List<GCHouse> housesGCList ) { 

for (GCHouse house: housesGCList ) {
	house.f_removeAllHeatingAssets();
	house.p_parentNodeHeat = null;
	house.p_parentNodeHeatID = null;
	
	//add gasburner
	double peakHeatDemand_kW = f_calculatePeakHeatDemand_kW(house);
	new J_EAConversionGasBurner(house, peakHeatDemand_kW, zero_Interface.energyModel.avgc_data.p_avgEfficiencyGasBurner_fr, zero_Interface.energyModel.p_timeParameters, 90);
	house.f_addHeatManagement(OL_GridConnectionHeatingType.GAS_BURNER, false);
	
	/*
	J_EAConsumption heatDemandAsset = findFirst(house.c_consumptionAssets, j_ea -> j_ea.getEAType() == OL_EnergyAssetType.HEAT_DEMAND);
	J_EAConversionGasBurner gasBurner;
	//if house has follows the general heat deamnd profile
	if (heatDemandAsset != null) {
		gasBurner = new J_EAConversionGasBurner(house, heatDemandAsset.getYearlyDemand_kWh()/8760*10, 0.99, zero_Interface.energyModel.p_timeParameters, 90);
	}
	//if house has a thermalBuildingAsset
	else if (house.p_BuildingThermalAsset != null){
		double gasBurnerCapacity_kW = 10;
		gasBurner = new J_EAConversionGasBurner(house, gasBurnerCapacity_kW, 0.99, zero_Interface.energyModel.p_timeParameters, 90);
	}
	// Else house has a customprofiel
	else {
		J_EAProfile heatDemandProfile = (J_EAProfile)findFirst(house.c_profileAssets, x->x instanceof J_EAProfile && x.getEnergyCarrier() == OL_EnergyCarriers.HEAT && !(x instanceof J_EAProduction));
		double peakHeatDemand_kW = heatDemandProfile.getPeakPower_kW();//heatDemandProfile.getProfileScaling_fr() * Arrays.stream(heatDemandProfile.a_energyProfile_kWh).max().orElseThrow(() -> new RuntimeException("Unable to find the maximum of the heat demand profile"));
		gasBurner = new J_EAConversionGasBurner(house, peakHeatDemand_kW, 0.99, zero_Interface.energyModel.p_timeParameters, 90);
	}	
	house.f_addHeatManagement(OL_GridConnectionHeatingType.GAS_BURNER, false);
	*/
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  void f_setAircos( List<GCHouse> gcListHouses, double desiredShare ) { 

double nbHousesWithAirco = count(gcListHouses, x -> x.p_airco != null);
double nbHouses = gcListHouses.size();

while ( roundToInt(nbHouses * desiredShare) > nbHousesWithAirco ) {
	GCHouse house = randomWhere(gcListHouses, x -> x.p_airco == null);
	double aircoPower_kW = roundToDecimal(uniform(3,6),1);
	new J_EAConversionAirConditioner(house, aircoPower_kW, zero_Interface.energyModel.p_timeParameters, house.p_BuildingThermalAsset);
	//house.f_getHeatingManagement().initializeAssets();
	nbHousesWithAirco ++;
}
while ( roundToInt(nbHouses * desiredShare) < nbHousesWithAirco ) {
	GCHouse house = randomWhere(gcListHouses, x -> x.p_airco != null);
	house.p_airco.removeEnergyAsset();
	nbHousesWithAirco --;
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings();
 
  }

  void f_addLTDH( List<GCHouse> housesGCList ) { 

for (GCHouse house: housesGCList ) {
	house.f_removeAllHeatingAssets();

	// Add a heat node
	house.p_parentNodeHeat = findFirst(zero_Interface.energyModel.f_getGridNodesTopLevel(), node -> node.p_energyCarrier == OL_EnergyCarriers.HEAT);
	// Create a heat node if it does not exist yet
	if(house.p_parentNodeHeat == null){
		GridNode GN_heat = zero_Interface.energyModel.add_pop_gridNodes();
		zero_Interface.energyModel.f_getGridNodesTopLevel().add(GN_heat);
		GN_heat.p_gridNodeID = "Heatgrid";
		
		// Check wether transformer capacity is known or estimated
		GN_heat.p_capacity_kW = 1000000;	
		GN_heat.p_realCapacityAvailable = false;
		
		// Basic GN information
		GN_heat.p_description = "Warmtenet";
	
		//Define node type
		GN_heat.p_nodeType = OL_GridNodeType.HT;
		GN_heat.p_energyCarrier = OL_EnergyCarriers.HEAT;
	
		//Define GN location
		GN_heat.p_latitude = 0;
		GN_heat.p_longitude = 0;
		GN_heat.setLatLon(GN_heat.p_latitude, GN_heat.p_longitude);
		
		//Connect
		house.p_parentNodeHeat = GN_heat;
		
		//Show warning that heat grid is not a simple solution
		zero_Interface.f_setErrorScreen("LET OP: Er is nu een 'warmtenet' gecreëerd. Maar er is geen warmtebron aanwezig in het model. Daarom zal de benodigde warmte voor het warmtenet in de resultaten te zien zijn als warmte import.", 0, 0);
	}
	house.p_parentNodeHeatID = house.p_parentNodeHeat.p_gridNodeID;
	double peakHeatDemand_kW = f_calculatePeakHeatDemand_kW(house);
	double heatpumpElectricCapacity_kW = min(peakHeatDemand_kW / 3, 1.0);
	double efficiency_fr = 0.5;
	double inputTemperature_degC = 15.0;  // TODO: Look at these temperatures!
	double outputTemperature_degC = 50.0;
	double sourceAssetHeatPower_kW = 0.0;
	double belowZeroHeatpumpEtaReductionFactor = 1.0;
	J_EAConversionHeatPump heatpump = new J_EAConversionHeatPump(house,
		heatpumpElectricCapacity_kW,
		efficiency_fr,
		zero_Interface.energyModel.p_timeParameters,
		outputTemperature_degC,
		zero_Interface.energyModel.pp_ambientTemperature_degC.getCurrentValue(),
		sourceAssetHeatPower_kW,
		belowZeroHeatpumpEtaReductionFactor,
		OL_AmbientTempType.HEAT_GRID
	);
	heatpump.updateParameters(inputTemperature_degC, outputTemperature_degC);
	house.f_addHeatManagement(OL_GridConnectionHeatingType.LT_DISTRICTHEAT, false);		
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  void f_removeLTDH( List<GCHouse> housesGCList ) { 

for (GCHouse house: housesGCList ) {
	// Disconnect from GridNode Heat
	house.p_parentNodeHeat = null;
	house.p_parentNodeHeatID = null;
		
	// Remove Heatpump and replace with gasburner
	house.f_removeAllHeatingAssets();
	double peakHeatDemand_kW = f_calculatePeakHeatDemand_kW(house);
	new J_EAConversionGasBurner(house, peakHeatDemand_kW, zero_Interface.energyModel.avgc_data.p_avgEfficiencyGasBurner_fr, zero_Interface.energyModel.p_timeParameters, zero_Interface.energyModel.avgc_data.p_avgOutputTemperatureGasBurner_degC);	
	house.f_addHeatManagement(OL_GridConnectionHeatingType.GAS_BURNER, false);
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  void f_householdInsulation( List<GCHouse> housesGCList, double houses_pct ) { 

int nbHouses = count(housesGCList, x -> x.p_insulationLabel != OL_GridConnectionInsulationLabel.A);
int nbHousesWithImprovedInsulation = count(housesGCList, x -> x.p_BuildingThermalAsset.getLossScalingFactor_fr() < 1 && x.p_insulationLabel != OL_GridConnectionInsulationLabel.A);
int targetNbHousesWithImprovedInsulation = roundToInt(houses_pct / 100.0 * nbHouses);

while (nbHousesWithImprovedInsulation < targetNbHousesWithImprovedInsulation) {
	GCHouse house = findFirst(housesGCList, x -> x.p_BuildingThermalAsset.getLossScalingFactor_fr() >= 1 && x.p_insulationLabel != OL_GridConnectionInsulationLabel.A);
	if (house != null) {
		house.p_BuildingThermalAsset.setLossScalingFactor_fr( 0.7 );
		nbHousesWithImprovedInsulation++;
	}
	else {
		throw new RuntimeException("Unable to find house that does not yet have additional insulation");
	}
}
while (nbHousesWithImprovedInsulation > targetNbHousesWithImprovedInsulation) {
	GCHouse house = findFirst(housesGCList, x -> x.p_BuildingThermalAsset.getLossScalingFactor_fr() < 1 && x.p_insulationLabel != OL_GridConnectionInsulationLabel.A);
	if (house != null) {
		house.p_BuildingThermalAsset.setLossScalingFactor_fr( 1 );
		nbHousesWithImprovedInsulation--;
	}
	else {
		throw new RuntimeException("Unable to find house that has additional insulation");
	}
}


//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  /**
   * Function that adds or removes photovoltaic production assets to houses. Takes a percentage as a parameter and runs untill that percentage of all the houses has a PV asset. If a new asset is created it takes as its electric capacity a random value between 3 and 6 kW. The variables for amount of installed PV are updated automatically in the zero_engine.
   */
  protected void f_setPTSystemHouses( List<GCHouse> gcList, double PT_pct ) { 

ArrayList<GCHouse> houses = new ArrayList<GCHouse>(zero_Interface.c_orderedPTSystemsHouses.stream().filter(gcList::contains).toList());
int nbHouses = houses.size();
int nbHousesWithPT = count(houses, x -> x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW));
int nbHousesWithPTGoal = roundToInt(PT_pct / 100.0 * nbHouses);

while ( nbHousesWithPTGoal < nbHousesWithPT ) { // remove excess PV systems
	GCHouse house = findFirst(houses, x -> x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW));	
	J_EA ptAsset = findFirst(house.c_productionAssets, p -> p.getEAType() == OL_EnergyAssetType.PHOTOTHERMAL );
		
	if (ptAsset != null) {
		ptAsset.removeEnergyAsset();
		houses.remove(house);
		zero_Interface.c_orderedPTSystemsHouses.remove(house);
		zero_Interface.c_orderedPTSystemsHouses.add(0, house);
		
		if(house.p_heatBuffer != null){
			house.p_heatBuffer.removeEnergyAsset();
		}
		if(house.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW)){
			J_EAProduction pvAsset = findFirst(house.c_productionAssets, ea -> ea.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC);
			if(pvAsset != null){
				double newInstalledPVCapacity = min(house.v_liveAssetsMetaData.PVPotential_kW, pvAsset.getCapacityElectric_kW() + zero_Interface.energyModel.avgc_data.p_avgPTPanelSize_m2*zero_Interface.energyModel.avgc_data.p_avgPVPower_kWpm2);
				pvAsset.setCapacityElectric_kW(newInstalledPVCapacity, house);
			}
		}
		nbHousesWithPT --; 
	}
	else {
		traceln(" cant find PV asset in house that should have PV asset in f_setPVHouses (Interface)");
	}
}

while ( nbHousesWithPTGoal > nbHousesWithPT ) {
	GCHouse house = findFirst(houses, x -> !x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW));
	if (house == null){
		traceln("No gridconnection without PT panels found! Current PVsystems count: %s", nbHousesWithPT);
		break;
	}
	else {
		String assetName = "Rooftop PT";
		double installedPTCapacity_kW = zero_Interface.energyModel.avgc_data.p_avgPTPanelSize_m2*zero_Interface.energyModel.avgc_data.p_avgPTPower_kWpm2;//roundToDecimal(uniform(3,6),2);
		
		//Compensate for pt if it is present
		if(house.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW)){
			J_EAProduction pvAsset = findFirst(house.c_productionAssets, ea -> ea.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC);
			if(pvAsset != null){
				double newInstalledPVCapacity = max(0, pvAsset.getCapacityElectric_kW() - zero_Interface.energyModel.avgc_data.p_avgPTPanelSize_m2*zero_Interface.energyModel.avgc_data.p_avgPVPower_kWpm2);
				pvAsset.setCapacityElectric_kW(newInstalledPVCapacity, house);
			}
		}
		J_EAProduction productionAsset = new J_EAProduction ( house, OL_EnergyAssetType.PHOTOTHERMAL, assetName, OL_EnergyCarriers.HEAT, installedPTCapacity_kW, zero_Interface.energyModel.p_timeParameters, zero_Interface.energyModel.pp_PVProduction35DegSouth_fr );
		
		//Get parameters for the heatbuffer
		double lossFactor_WpK = 0;// For now no loss factor
		double minTemperature_degC = zero_Interface.energyModel.avgc_data.p_avgMinHeatBufferTemperature_degC;
		double maxTemperature_degC = zero_Interface.energyModel.avgc_data.p_avgMaxHeatBufferTemperature_degC;
		double initialTemperature_degC = (minTemperature_degC + maxTemperature_degC)/2; 
		double setTemperature_degC = initialTemperature_degC; 
		double heatBufferStorageCapacity_m3 = zero_Interface.energyModel.avgc_data.p_avgHeatBufferWaterVolumePerPTSurface_m3pm2 * installedPTCapacity_kW/zero_Interface.energyModel.avgc_data.p_avgPTPower_kWpm2;
		double heatCapacity_JpK = zero_Interface.energyModel.avgc_data.p_waterHeatCapacity_JpkgK*(heatBufferStorageCapacity_m3*zero_Interface.energyModel.avgc_data.p_waterDensity_kgpm3);
		
		//Add heatbuffer
		J_EAStorageHeat heatbufferAsset = new J_EAStorageHeat ( house, OL_EnergyAssetType.STORAGE_HEAT, installedPTCapacity_kW, lossFactor_WpK, zero_Interface.energyModel.p_timeParameters, initialTemperature_degC, minTemperature_degC, maxTemperature_degC, setTemperature_degC, heatCapacity_JpK, OL_AmbientTempType.FIXED); 

		houses.remove(house);
		zero_Interface.c_orderedPTSystemsHouses.remove(house);
		zero_Interface.c_orderedPTSystemsHouses.add(0, house);
		nbHousesWithPT ++;	
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  /**
   * Function that calculates all the values of the other sliders and sets them without calling an action. Takes as parameters the index of the slider which should not be touched as well as all the sliders. HybridHeatPump and DistrictHeating sliders are optional and an argument of null can be passed. 
   */
  public void f_setHeatingSliders( List<GridConnection> gcList, List<GridConnection> orderedHeatingSystemGCList, OL_GridConnectionHeatingType changedSliderHeatingType, ShapeSlider gasBurnerSlider, ShapeSlider hybridHeatPumpSlider, ShapeSlider heatPumpSlider, ShapeSlider HTdistrictHeatingSlider, ShapeSlider LTdistrictHeatingSlider, ShapeSlider customHeatingSlider ) { 

////Determine the changed slider index used in the distribution for loop
int changedSliderIndex = 0;
switch(changedSliderHeatingType){
	case GAS_BURNER:
		changedSliderIndex = 0;
		break;
	case HYBRID_HEATPUMP:
		changedSliderIndex = 1;
		break;
	case ELECTRIC_HEATPUMP:
		changedSliderIndex = 2;
		break;
	case DISTRICTHEAT:
		changedSliderIndex = 3;
		break;
	case LT_DISTRICTHEAT:
	case CUSTOM:
		throw new RuntimeException("Changed a heating type slider with a currently unsupported type!");
}

//// Get current pct values (after slider change, but before correction; In other words total_pct != 100)
double pct_naturalGasBurner = gasBurnerSlider.getValue();
double pct_hybridHeatPump = hybridHeatPumpSlider != null ? hybridHeatPumpSlider.getValue() : 0;
double pct_electricHeatPump = heatPumpSlider != null ? heatPumpSlider.getValue() : 0;
double pct_HTdistrictHeating = HTdistrictHeatingSlider != null ? HTdistrictHeatingSlider.getValue() : 0;
double pct_LTdistrictHeating = LTdistrictHeatingSlider != null ? LTdistrictHeatingSlider.getValue() : 0;
double pct_customHeatingSlider = customHeatingSlider != null ? customHeatingSlider.getValue() : 0;

//Set array with pct values
double pctArray[] = {
    pct_naturalGasBurner,
    pct_hybridHeatPump,
    pct_electricHeatPump,
    pct_HTdistrictHeating,
    pct_LTdistrictHeating,    
    pct_customHeatingSlider
};

//// Create a ghost asset array, and fill it. This is used to find minimums of certain sliders. Also get the total amount of GC with heating systems.
int ghostAssetTotalArray[] = new int[pctArray.length];
int totalGCWithHeating = 0;
for(GridConnection GC : gcList){
	if(GC.f_getCurrentHeatingType() != OL_GridConnectionHeatingType.NONE && GC.v_isActive){
		totalGCWithHeating++;
		
		if(GC.f_getHeatingTypeIsGhost()){
			switch(GC.f_getCurrentHeatingType()){
				case GAS_BURNER:
					ghostAssetTotalArray[0]++;
					break;
				case HYBRID_HEATPUMP:
					ghostAssetTotalArray[1]++;
					break;
				case ELECTRIC_HEATPUMP:
					ghostAssetTotalArray[2]++;
					break;
				case DISTRICTHEAT:
					ghostAssetTotalArray[3]++;
					break;
				case LT_DISTRICTHEAT:
					ghostAssetTotalArray[4]++;
					break;
				case CUSTOM:
					ghostAssetTotalArray[5]++;
					break;
			}
		}
	}
}

//// Correct the slider change trough to the other sliders. But don't move the custom slider or set sliders lower than their unchangable ghost assets.
int customSliderIndex = 5;
double pctExcess = Arrays.stream(pctArray).sum() - 100;

for (int i = 0; i < pctArray.length && pctExcess != 0 ; i++) {
    if (i != changedSliderIndex && i != customSliderIndex) {
        double ghostMin_pct = ((double) 100.0 * ghostAssetTotalArray[i]) / totalGCWithHeating;
        double maxDown_pct = pctArray[i] - ghostMin_pct;
        double maxUp_pct = 100 - pctArray[i];

        // Determine the slider delta, positive delta -> slider increases, negative -> slider decreases
        double deltaSlider_pct = 0;
        if(pctExcess > 0){
        	deltaSlider_pct = -min(maxDown_pct, pctExcess);
        }
        else{
        	deltaSlider_pct = min(maxUp_pct, -pctExcess);
        }

        pctArray[i] += deltaSlider_pct;
        pctExcess = Arrays.stream(pctArray).sum() - 100;
    }
}

//If still not 0, then adjust the changedSlider back to solve it.
if (pctExcess != 0){
	pctArray[changedSliderIndex] = max(0, pctArray[changedSliderIndex] - pctExcess);
}

//// Set refound values to the sliders again
gasBurnerSlider.setValue(roundToInt(pctArray[0]), false);
if(hybridHeatPumpSlider != null){
	hybridHeatPumpSlider.setValue(roundToInt(pctArray[1]), false);
}
if(heatPumpSlider != null){
	heatPumpSlider.setValue(roundToInt(pctArray[2]), false);
}
if(HTdistrictHeatingSlider != null){
	HTdistrictHeatingSlider.setValue(roundToInt(pctArray[3]), false);
}
if(LTdistrictHeatingSlider != null){
	LTdistrictHeatingSlider.setValue(roundToInt(pctArray[4]), false);
}
if(customHeatingSlider != null){
	customHeatingSlider.setValue(roundToInt(pctArray[5]), false);
}


//Set the heating systems in the engine to the correct setting
f_setHeatingSystems(gcList, orderedHeatingSystemGCList, changedSliderHeatingType, pctArray[changedSliderIndex]); 
  }

  protected void f_updateSliders_Heating(  ) { 

// Update all loaded pages
for (ShapeGroup page : c_loadedPageGroups) {
	if(page == gr_heatingSliders_households){
		f_updateHeatingSliders_households();
	}
	else if(page == gr_heatingSliders_companies){
		f_updateHeatingSliders_companies();
	}
	else{
		f_updateHeatingSliders_custom(); 
	}
} 
  }

  protected void f_updateHeatingSliders_households(  ) { 

List<GCHouse> houseGridConnections = uI_Tabs.f_getActiveSliderGridConnections_houses();

//Heating type
int totalHousesWithHeating = 0;
int nbOfHousesWithGasBurners = 0;
int nbOfHousesWithHybridHeatpumps = 0;
int nbOfHousesWithElectricHeatpumps = 0;
int nbOfHousesOnHTHeatGrid = 0;
int nbOfHousesOnLTHeatGrid = 0;

for(GCHouse GC : houseGridConnections){
	if(GC.v_isActive && GC.f_getCurrentHeatingType() != OL_GridConnectionHeatingType.NONE){
		totalHousesWithHeating++;
		switch(GC.f_getCurrentHeatingType()){
			case GAS_BURNER:
				nbOfHousesWithGasBurners++;
				break;
			case HYBRID_HEATPUMP:
				nbOfHousesWithHybridHeatpumps++;
				break;
			case ELECTRIC_HEATPUMP:
				nbOfHousesWithElectricHeatpumps++;
				break;
			case DISTRICTHEAT:
				nbOfHousesOnHTHeatGrid++;
				break;
			case LT_DISTRICTHEAT:
				nbOfHousesOnLTHeatGrid++;
				break;
		}
	}
}

int housesWithGasBurners_pct = roundToInt(100.0 * nbOfHousesWithGasBurners / totalHousesWithHeating);
int housesWithHybridHeatpump_pct = roundToInt(100.0 * nbOfHousesWithHybridHeatpumps / totalHousesWithHeating);
int housesWithElectricHeatpump_pct = roundToInt(100.0 * nbOfHousesWithElectricHeatpumps / totalHousesWithHeating);

sl_householdGasBurner_pct.setValue(housesWithGasBurners_pct, false);
sl_householdHybridHeatpump_pct.setValue(housesWithHybridHeatpump_pct, false);
sl_householdElectricHeatPump_pct.setValue(housesWithElectricHeatpump_pct, false);
cb_householdHTDistrictHeating.setSelected(false, false);
cb_householdLTDistrictHeating.setSelected(false, false);

if(nbOfHousesOnHTHeatGrid == totalHousesWithHeating){
	cb_householdHTDistrictHeating.setSelected(true, false);
}
if(nbOfHousesOnLTHeatGrid == totalHousesWithHeating){
	cb_householdLTDistrictHeating.setSelected(true, false);
}

//Houses with Airco
double nbHouses = houseGridConnections.size();
double nbHousesWithAirco = count(houseGridConnections, x -> x.p_airco != null);
double pctOfHousesWithAirco = (nbHousesWithAirco*100.0)/nbHouses;
sl_householdAirco_pct.setValue(pctOfHousesWithAirco, false);


//Houses with better isolation
int nbHousesThatCanGetImprovedIsolation = count(houseGridConnections, x -> x.p_insulationLabel != OL_GridConnectionInsulationLabel.A);
int nbHousesWithImprovedInsulation = count(houseGridConnections, x -> x.p_BuildingThermalAsset.getLossScalingFactor_fr() < 1 && x.p_insulationLabel != OL_GridConnectionInsulationLabel.A);
double pctOfHousesWithImprovedInsulation = 100.0 * ((double)nbHousesWithImprovedInsulation)/nbHousesThatCanGetImprovedIsolation;
sl_householdHeatDemandReduction_pct.setValue(roundToInt(pctOfHousesWithImprovedInsulation), false);


//PT
int nbHousesWithPT = count(houseGridConnections, x -> x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW));

sl_householdRooftopPT_pct.setValue(roundToInt((nbHousesWithPT*100.0)/nbHouses), false); 
  }

  protected void f_updateHeatingSliders_companies(  ) { 

List<GCUtility> utilityGridConnections = uI_Tabs.f_getActiveSliderGridConnections_utilities();

//Savings (IN PROGRESS, WHAT ABOUT THERMAL BUILDINGS?????)
double totalBaseConsumption_kWh = 0;
double totalSavedConsumption_kWh = 0;
for(GridConnection GC : utilityGridConnections){
	if(GC.v_isActive){
		List<J_EAProfile> profileEAs = findAll(GC.c_profileAssets, profile -> profile.getEnergyCarrier() == OL_EnergyCarriers.HEAT && !(profile instanceof J_EAProduction)); // FIX FOR HOT WATER IN LONG RUN
		for(J_EAProfile profileEA : profileEAs){
			double baseConsumption_kWh = profileEA.getBaseConsumption_kWh();
			totalBaseConsumption_kWh += baseConsumption_kWh;
			totalSavedConsumption_kWh += (1 - profileEA.getProfileScaling_fr()) * baseConsumption_kWh;
		}
		if(GC.p_BuildingThermalAsset != null){
			traceln("WARNING: SLIDER SAVINGS UPDATE FUNCTION IS NOT FUNCTIONAL YET FOR COMPANIES WITH THERMAL BUILDING ASSETS");
		}
	}
}

double heatSavings_pct = totalBaseConsumption_kWh > 0 ? (totalSavedConsumption_kWh/totalBaseConsumption_kWh * 100) : 0;
sl_companiesHeatDemandReduction_pct.setValue(roundToInt(heatSavings_pct), false);


//Heating type
int totalCompaniesWithHeating = 0;
int nbOfCompaniesWithGasBurners = 0;
int nbOfCompaniesWithHybridHeatpumps = 0;
int nbOfCompaniesWithElectricHeatpumps = 0;
int nbOfCompaniesOnHTHeatGrid = 0;
int nbOfCompaniesOnLTHeatGrid = 0;
int nbOfCompaniesWithCustomHeating = 0;

for(GCUtility GC : utilityGridConnections){
	if(GC.v_isActive && GC.f_getCurrentHeatingType() != OL_GridConnectionHeatingType.NONE){
		totalCompaniesWithHeating++;
		switch(GC.f_getCurrentHeatingType()){
			case GAS_BURNER:
				nbOfCompaniesWithGasBurners++;
				break;
			case HYBRID_HEATPUMP:
				nbOfCompaniesWithHybridHeatpumps++;
				break;
			case ELECTRIC_HEATPUMP:
				nbOfCompaniesWithElectricHeatpumps++;
				break;
			case DISTRICTHEAT:
				nbOfCompaniesOnHTHeatGrid++;
				break;
			case LT_DISTRICTHEAT:
				nbOfCompaniesOnLTHeatGrid++;
				break;
			case CUSTOM:
				nbOfCompaniesWithCustomHeating++;
				break;
		}
	}
}

int companiesWithGasBurners_pct = roundToInt(100.0 * nbOfCompaniesWithGasBurners / totalCompaniesWithHeating);
int companiesWithHybridHeatpump_pct = roundToInt(100.0 * nbOfCompaniesWithHybridHeatpumps / totalCompaniesWithHeating);
int companiesWithElectricHeatpump_pct = roundToInt(100.0 * nbOfCompaniesWithElectricHeatpumps / totalCompaniesWithHeating);
int companiesWithHTDistrictHeat_pct = roundToInt(100.0 * nbOfCompaniesOnHTHeatGrid / totalCompaniesWithHeating);
int companiesWithLTDistrictHeat_pct = roundToInt(100.0 * nbOfCompaniesOnLTHeatGrid / totalCompaniesWithHeating);
int companiesWithCustomHeating_pct = roundToInt(100.0 * nbOfCompaniesWithCustomHeating / totalCompaniesWithHeating);


sl_companiesGasBurner_pct.setValue(companiesWithGasBurners_pct, false);
sl_companiesHybridHeatPump_pct.setValue(companiesWithHybridHeatpump_pct, false);
sl_companiesElectricHeatPump_pct.setValue(companiesWithElectricHeatpump_pct, false);
sl_companiesDistrictHeating_pct.setValue(companiesWithHTDistrictHeat_pct, false);
//sl_companiesLTDistrictHeating_pct.setValue(companiesWithLTDistrictHeat_pct, false); Doesnt exist (yet) for companies
sl_companiesCustom_pct.setValue(companiesWithCustomHeating_pct, false);
 
  }

  protected void f_updateHeatingSliders_custom(  ) { 

//If you have a custom tab, override this function to make it update automatically
throw new RuntimeException("Forgot to override the update custom heating sliders functionality"); 
  }

  public void f_setHeatingSystems( List<GridConnection> gcList, List<GridConnection> orderedHeatingSystemGCList, OL_GridConnectionHeatingType changedSliderHeatingType, double sliderGoal_pct ) { 

int totalNrOfHeatingSystems = 0;
int nbGasBurners = 0;
int nbHybridHeatpumps = 0;
int nbElectricHeatpumps = 0;
int nbHTHeatGrid = 0;
int nbLTHeatGrid = 0;
int nbCustomHeating = 0;
List<GridConnection> gasBurnerGCs = new ArrayList<>();
List<GridConnection> hybridHeatpumpGCs = new ArrayList<>();
List<GridConnection> electricHeatpumpGCs = new ArrayList<>();
List<GridConnection> HTHeatGridGCs = new ArrayList<>();
List<GridConnection> LTHeatGridGCs = new ArrayList<>();

for(GridConnection GC : gcList){
	if(GC.v_isActive && GC.f_getCurrentHeatingType() != OL_GridConnectionHeatingType.NONE){
		totalNrOfHeatingSystems++; 		
		switch(GC.f_getCurrentHeatingType()){
			case GAS_BURNER:
				nbGasBurners++;
				if(!GC.f_getHeatingTypeIsGhost()){
					gasBurnerGCs.add(GC);
				}
				break;
			case HYBRID_HEATPUMP:
				nbHybridHeatpumps++;
				if(!GC.f_getHeatingTypeIsGhost()){
					hybridHeatpumpGCs.add(GC);
				}
				break;
			case ELECTRIC_HEATPUMP:
				nbElectricHeatpumps++;
				if(!GC.f_getHeatingTypeIsGhost()){
					electricHeatpumpGCs.add(GC);
				}
				break;
			case DISTRICTHEAT:
				nbHTHeatGrid++;
				if(!GC.f_getHeatingTypeIsGhost()){
					HTHeatGridGCs.add(GC);
				}
				break;
			case LT_DISTRICTHEAT:
				nbLTHeatGrid++;
				if(!GC.f_getHeatingTypeIsGhost()){
					LTHeatGridGCs.add(GC);
				}
				break;
			case CUSTOM:
					nbCustomHeating++;
				if(!GC.f_getHeatingTypeIsGhost()){
					//No collection, as ghost cant be changed anyway
				}
				break;
		}
	}
}

int nbChangedHeatingTypeGoal = roundToInt(totalNrOfHeatingSystems*sliderGoal_pct/100.0);

int currentNumberOfChangedHeatingType = 0;

switch(changedSliderHeatingType){
	case GAS_BURNER:
		currentNumberOfChangedHeatingType = nbGasBurners;
		break;
	case HYBRID_HEATPUMP:
		currentNumberOfChangedHeatingType = nbHybridHeatpumps;
		break;
	case ELECTRIC_HEATPUMP:
		currentNumberOfChangedHeatingType = nbElectricHeatpumps;
		break;
	case DISTRICTHEAT:
		currentNumberOfChangedHeatingType = nbHTHeatGrid;
		break;
	case LT_DISTRICTHEAT:
		currentNumberOfChangedHeatingType = nbLTHeatGrid;
		break;
}



if (currentNumberOfChangedHeatingType < nbChangedHeatingTypeGoal) {
	while ( currentNumberOfChangedHeatingType < nbChangedHeatingTypeGoal ) {
	
		GridConnection changingGC = null;
		if(changedSliderHeatingType != OL_GridConnectionHeatingType.GAS_BURNER && gasBurnerGCs.size() > 0){
			changingGC = findFirst(orderedHeatingSystemGCList, gc -> gasBurnerGCs.contains(gc));
			gasBurnerGCs.remove(changingGC);		
		}
		else if(changedSliderHeatingType != OL_GridConnectionHeatingType.HYBRID_HEATPUMP && hybridHeatpumpGCs.size() > 0){
			changingGC = findFirst(orderedHeatingSystemGCList, gc -> hybridHeatpumpGCs.contains(gc));
			hybridHeatpumpGCs.remove(changingGC);
		}
		else if (changedSliderHeatingType != OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP && electricHeatpumpGCs.size() > 0 ) {
			changingGC = findFirst(orderedHeatingSystemGCList, gc -> electricHeatpumpGCs.contains(gc));
			electricHeatpumpGCs.remove(changingGC);
		}
		else if (changedSliderHeatingType != OL_GridConnectionHeatingType.DISTRICTHEAT && HTHeatGridGCs.size() > 0 ) {
			changingGC = findFirst(orderedHeatingSystemGCList, gc -> HTHeatGridGCs.contains(gc));
			HTHeatGridGCs.remove(changingGC);
		}
		else if (changedSliderHeatingType != OL_GridConnectionHeatingType.LT_DISTRICTHEAT && LTHeatGridGCs.size() > 0 ) {
			changingGC = findFirst(orderedHeatingSystemGCList, gc -> LTHeatGridGCs.contains(gc));
			LTHeatGridGCs.remove(changingGC);
		}
		else{
			throw new RuntimeException("No more GC left to change into raised slider type!" );
		}
		
		if(changingGC == null){
			throw new RuntimeException("orderedHeatingSystemGClist does not contain a GC found by this function! This should not be possible!" );
		}
		
		//Change the current heating type to the new one
		changingGC.f_removeAllHeatingAssets();
		f_addHeatAsset(changingGC, changedSliderHeatingType, f_calculatePeakHeatDemand_kW(changingGC));
		changingGC.f_addHeatManagement(changedSliderHeatingType, false);
		currentNumberOfChangedHeatingType ++;
	}
}
else {
	// Remove Gas burners Trucks
	while ( currentNumberOfChangedHeatingType > nbChangedHeatingTypeGoal ) {
		// replace a gasburner with a hybrid heatpump
		GridConnection changingGC = null;
		OL_GridConnectionHeatingType newHeatingType = OL_GridConnectionHeatingType.GAS_BURNER; // Always change into gasburner system.
		if(changedSliderHeatingType == OL_GridConnectionHeatingType.GAS_BURNER){
			changingGC = findFirst(orderedHeatingSystemGCList, gc -> gasBurnerGCs.contains(gc));
			gasBurnerGCs.remove(changingGC);
			newHeatingType = OL_GridConnectionHeatingType.HYBRID_HEATPUMP; // If removing gasburner, change into hybrid system.
		}
		else if(changedSliderHeatingType == OL_GridConnectionHeatingType.HYBRID_HEATPUMP){
			changingGC = findFirst(orderedHeatingSystemGCList, gc -> hybridHeatpumpGCs.contains(gc));
			hybridHeatpumpGCs.remove(changingGC);
		}
		else if(changedSliderHeatingType == OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP){
			changingGC = findFirst(orderedHeatingSystemGCList, gc -> electricHeatpumpGCs.contains(gc));
			electricHeatpumpGCs.remove(changingGC);
		}
		else if(changedSliderHeatingType == OL_GridConnectionHeatingType.DISTRICTHEAT){
			changingGC = findFirst(orderedHeatingSystemGCList, gc -> HTHeatGridGCs.contains(gc));
			HTHeatGridGCs.remove(changingGC);
		}
		else if(changedSliderHeatingType == OL_GridConnectionHeatingType.LT_DISTRICTHEAT){
			changingGC = findFirst(orderedHeatingSystemGCList, gc -> LTHeatGridGCs.contains(gc));
			LTHeatGridGCs.remove(changingGC);
		}
		changingGC.f_removeAllHeatingAssets();
		f_addHeatAsset(changingGC, newHeatingType, f_calculatePeakHeatDemand_kW(changingGC));
		changingGC.f_addHeatManagement(newHeatingType, false);
		currentNumberOfChangedHeatingType--;
	}
}


//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}
zero_Interface.f_resetSettings(); 
  }

  public void f_addHeatAsset( GridConnection parentGC, OL_GridConnectionHeatingType heatAssetType, double maxHeatOutputPower_kW ) { 

//Initialize parameters
double heatOutputCapacityGasBurner_kW;
double inputCapacityElectric_kW;
double efficiency;
double baseTemperature_degC;
double outputTemperature_degC;
OL_AmbientTempType ambientTempType;
double sourceAssetHeatPower_kW;
double belowZeroHeatpumpEtaReductionFactor;
maxHeatOutputPower_kW = maxHeatOutputPower_kW*2; // Make the asset capacity twice as high, to make sure it can handle the load in other scenarios with more heat consumption.
J_AVGC_data avgc_data = zero_Interface.energyModel.avgc_data;
J_TimeParameters timeParameters = zero_Interface.energyModel.p_timeParameters;

switch (heatAssetType){ // There is always only one heatingType, If there are many assets the type is CUSTOM

	case GAS_BURNER:
		heatOutputCapacityGasBurner_kW = max(avgc_data.p_minGasBurnerOutputCapacity_kW, maxHeatOutputPower_kW);			
		J_EAConversionGasBurner gasBurner = new J_EAConversionGasBurner(parentGC, heatOutputCapacityGasBurner_kW , avgc_data.p_avgEfficiencyGasBurner_fr, timeParameters, 90);
		break;
	
	case HYBRID_HEATPUMP:
	
		//Add primary heating asset (heatpump) (if its not part of the basic profile already
		inputCapacityElectric_kW = max(avgc_data.p_minHeatpumpElectricCapacity_kW, maxHeatOutputPower_kW / 3); //-- /3, kan nog kleiner want is hybride zodat gasbrander ook bij springt, dus kleiner MOETEN aanname voor hoe klein onderzoeken
		
		efficiency = avgc_data.p_avgEfficiencyHeatpump_fr;
		baseTemperature_degC = zero_Interface.energyModel.pp_ambientTemperature_degC.getCurrentValue();
		outputTemperature_degC = avgc_data.p_avgOutputTemperatureHybridHeatpump_degC;
		ambientTempType = OL_AmbientTempType.AMBIENT_AIR;
		sourceAssetHeatPower_kW = 0;
		belowZeroHeatpumpEtaReductionFactor = 1;
		
		J_EAConversionHeatPump heatPumpHybrid = new J_EAConversionHeatPump(parentGC, inputCapacityElectric_kW, efficiency, timeParameters, outputTemperature_degC, baseTemperature_degC, sourceAssetHeatPower_kW, belowZeroHeatpumpEtaReductionFactor, ambientTempType);

		zero_Interface.energyModel.c_ambientDependentAssets.add(heatPumpHybrid);
		
		//Add secondary heating asset (gasburner)
		heatOutputCapacityGasBurner_kW = max(avgc_data.p_minGasBurnerOutputCapacity_kW, maxHeatOutputPower_kW);	
		efficiency = avgc_data.p_avgEfficiencyGasBurner_fr;
		outputTemperature_degC = avgc_data.p_avgOutputTemperatureGasBurner_degC;
	
		J_EAConversionGasBurner gasBurnerHybrid = new J_EAConversionGasBurner(parentGC, heatOutputCapacityGasBurner_kW, efficiency, timeParameters, outputTemperature_degC);		
		break;
	
	case ELECTRIC_HEATPUMP:
		//Add primary heating asset (heatpump)
		inputCapacityElectric_kW = max(avgc_data.p_minHeatpumpElectricCapacity_kW, maxHeatOutputPower_kW); // Could be smaller due to high cop	
		efficiency = avgc_data.p_avgEfficiencyHeatpump_fr;
		baseTemperature_degC = zero_Interface.energyModel.pp_ambientTemperature_degC.getCurrentValue();
		outputTemperature_degC = avgc_data.p_avgOutputTemperatureElectricHeatpump_degC;
		ambientTempType = OL_AmbientTempType.AMBIENT_AIR;
		sourceAssetHeatPower_kW = 0;
		belowZeroHeatpumpEtaReductionFactor = 1;
		
		new J_EAConversionHeatPump(parentGC, inputCapacityElectric_kW, efficiency, timeParameters, outputTemperature_degC, baseTemperature_degC, sourceAssetHeatPower_kW, belowZeroHeatpumpEtaReductionFactor, ambientTempType );		
		break;

	case GAS_CHP:
		
		double outputCapacityElectric_kW = (maxHeatOutputPower_kW/avgc_data.p_avgEfficiencyCHP_thermal_fr) * avgc_data.p_avgEfficiencyCHP_electric_fr;
		outputTemperature_degC = avgc_data.p_avgOutputTemperatureCHP_degC;
		efficiency = avgc_data.p_avgEfficiencyCHP_thermal_fr + avgc_data.p_avgEfficiencyCHP_electric_fr;
		
		new J_EAConversionGasCHP(parentGC, outputCapacityElectric_kW, maxHeatOutputPower_kW, efficiency, timeParameters, outputTemperature_degC );
		break;

	case DISTRICTHEAT:
		double heatOutputCapacityDeliverySet_kW = max(avgc_data.p_minDistrictHeatingDeliverySetOutputCapacity_kW, maxHeatOutputPower_kW);		
		outputTemperature_degC = avgc_data.p_avgOutputTemperatureDistrictHeatingDeliverySet_degC;
		efficiency = avgc_data.p_avgEfficiencyDistrictHeatingDeliverySet_fr;
		
		new J_EAConversionHeatDeliverySet(parentGC, heatOutputCapacityDeliverySet_kW, efficiency, timeParameters, outputTemperature_degC);
		
		//Add GC to heat grid
		GridNode heatgrid = findFirst(zero_Interface.energyModel.pop_gridNodes, node -> node.p_energyCarrier == OL_EnergyCarriers.HEAT);
		if(heatgrid == null){
			heatgrid = f_createNewHeatGrid();
		}
		//Connect
		parentGC.p_parentNodeHeatID = heatgrid.p_gridNodeID;
		parentGC.p_parentNodeHeat = heatgrid;
		break;
}
 
  }

  
GridNode 
 f_createNewHeatGrid(  ) { 

GridNode GN_heat = zero_Interface.energyModel.add_pop_gridNodes();
zero_Interface.energyModel.f_getGridNodesTopLevel().add(GN_heat);
GN_heat.p_gridNodeID = "Heatgrid";

// Check whether transformer capacity is known or estimated
GN_heat.p_capacity_kW = 1000000;	
GN_heat.p_realCapacityAvailable = false;

// Basic GN information
GN_heat.p_description = "Custom toegevoegde Warmtenet";

//Define node type
GN_heat.p_nodeType = OL_GridNodeType.HT;
GN_heat.p_energyCarrier = OL_EnergyCarriers.HEAT;

//Define GN location
GN_heat.p_latitude = 0;
GN_heat.p_longitude = 0;
GN_heat.setLatLon(GN_heat.p_latitude, GN_heat.p_longitude);

//Show warning that heat grid is not a simple solution
zero_Interface.f_setErrorScreen("LET OP: Er is nu een 'warmtenet' gecreëerd. Maar er is geen warmtebron aanwezig in het model. Daarom zal de benodigde warmte voor het warmtenet in de resultaten te zien zijn als warmte import.", 0, 0);

return GN_heat; 
  }

  protected void f_initializeHeatingPages(  ) { 

// CHOOSE WHICH PAGES IN YOUR TAB YOU WANT TO BE ABLE TO SHOW FOR YOUR PROJECT 
boolean hasHouses = uI_Tabs.f_getActiveSliderGridConnections_houses().size() > 0;
boolean hasCompanies = uI_Tabs.f_getActiveSliderGridConnections_utilities().size() > 0;

c_loadedPageGroups = new ArrayList<>();
// Load in the existing pages you want to include in the tab
if (hasHouses) {
	c_loadedPageGroups.add(gr_heatingSliders_households);
} 
if (hasCompanies) {
	c_loadedPageGroups.add(gr_heatingSliders_companies);
}

// If you have a custom page, add it by using f_addCustomPage:
f_addCustomPage();

// Show/hide page indicator based on number of pages
if (c_loadedPageGroups.size() <= 1) {
    gr_pageIndicator.setVisible(false);
} else {
    gr_pageIndicator.setVisible(true);
}
// Navigate to the first page
if (!c_loadedPageGroups.isEmpty()) {
    f_goToPage(0);
} 
  }

  protected void f_goToPage( int pageIndex ) { 

for (ShapeGroup group : c_loadedPageGroups) {
    group.setVisible(false);
}

if (c_loadedPageGroups.isEmpty()) return;

v_currentPageIndex = pageIndex;
c_loadedPageGroups.get(v_currentPageIndex).setVisible(true); // Show the selected page group
f_updatePageIndicator(); // Update the page indicator text 
  }

  protected void f_nextPage(  ) { 

if (c_loadedPageGroups.isEmpty()) return;
int nextIndex = (v_currentPageIndex + 1) % c_loadedPageGroups.size();
f_goToPage(nextIndex); 
  }

  protected void f_previousPage(  ) { 

if (c_loadedPageGroups.isEmpty()) return;
int prevIndex = (v_currentPageIndex - 1 + c_loadedPageGroups.size()) % c_loadedPageGroups.size();
f_goToPage(prevIndex); 
  }

  protected void f_updatePageIndicator(  ) { 

t_pageIndicator.setText("Pagina " + (v_currentPageIndex + 1) + "/" + c_loadedPageGroups.size());
presentation.remove(gr_pageIndicator);
presentation.add(gr_pageIndicator); 
  }

  protected void f_initializeTab_Heating(  ) { 

f_initializeHeatingPages(); 
  }

  protected void f_addCustomPage(  ) { 

// Override this function to add your custom page to c_loadedPageGroups, for instance, like this:
//c_loadedPageGroups.add(gr_heatingSliders_custom); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_householdHTDistrictHeating_Font = new Font("Dialog", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_householdLTDistrictHeating_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_genericFunctions_Font = new Font("SansSerif", 0, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesHeatDemandReductionDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesHeatDemandReduction_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesGasBurnerDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesHybridHeatPumpDescription_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesElectricHeatPumpDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesDistrictHeatingCompaniesDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesElectricHeatPump_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesGasBurner_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesDistrictHeating_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesHybridHeatPump_pct_Font = _txt_companiesHybridHeatPumpDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_heatingDemandSlidersCompaniesDescription_Font = new Font("Dialog", 1, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesEBoiler_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesEBoilerDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesCustom_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesCustomDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_demandFunctionsDescription_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_heatingFunctionsDescription_Font = _txt_demandFunctionsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdGasBurnerDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdElectricHeatPumpDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdElectricHeatPump_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdGasBurner_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdHeatDemandReduction_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdHeatDemandReductionDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_heatingDemandSlidersHousesholdsDescription_Font = _txt_heatingDemandSlidersCompaniesDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdAircoDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdAirco_pct_Font = _txt_companiesHybridHeatPumpDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdRooftopPT_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdRooftopPTDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdHybridHeatpumpDescription_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdHybridHeatPump_pct_Font = _cb_householdHTDistrictHeating_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_districtheatingFunctionsDescription_Font = _txt_demandFunctionsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_heatingProductionFunctionsDescription_Font = _txt_demandFunctionsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_pageIndicator_Font = new Font("Dialog", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_genericFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_genericFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_heatDemandSliders1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesHeatDemandReductionDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesHeatDemandReduction_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesGasBurnerDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesHybridHeatPumpDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesElectricHeatPumpDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesDistrictHeatingCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesElectricHeatPump_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesGasBurner_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesDistrictHeating_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesHybridHeatPump_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_heatingDemandSlidersCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesEBoiler_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesEBoilerDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyReduction = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyGasBoiler = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyElectricHeatpump = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyHybridHeatpump = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyHeatGrid = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyEBoiler = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesCustom_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesCustomDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyCustom = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_heatingSliders_companies = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_demandFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_demandFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_heatingFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_heatingFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_heatDeandSlidersResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdGasBurnerDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdElectricHeatPumpDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdElectricHeatPump_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdGasBurner_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdHeatDemandReduction_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdHeatDemandReductionDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_heatingDemandSlidersHousesholdsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdAircoDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdAirco_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdGasBurner = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdHeatPump = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdHTDistrictHeating = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdLTDistrictHeating = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdAirconditioning = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdAdditionalInsulation = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdRooftopPT_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdRooftopPTDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdPT = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdHybridHeatpumpDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdHybridHeatPump = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdHybridHeatPump_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_heatingSliders_households = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_districtHeatingFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_districtheatingFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_heatingProductionFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_heatingProductionFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrowLeftResidential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrowRightResidential1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_pageIndicator = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_pageIndicator = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesHeatDemandReduction_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesDistrictHeating_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesGasBurner_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesHybridHeatPump_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesElectricHeatPump_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesEBoiler_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesCustom_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdGasBurner_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdElectricHeatPump_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdHeatDemandReduction_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdAirco_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_householdHTDistrictHeating = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_householdLTDistrictHeating = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdRooftopPT_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdHybridHeatpump_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 76;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 77;

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
	  level.addAll(rect_genericFunctions, t_genericFunctions, gr_heatingSliders_companies, rect_demandFunctions, txt_demandFunctionsDescription, rect_heatingFunctions, txt_heatingFunctionsDescription, gr_heatingSliders_households, rect_districtHeatingFunctions, txt_districtheatingFunctionsDescription, rect_heatingProductionFunctions, txt_heatingProductionFunctionsDescription, gr_pageIndicator);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_companyReduction:
        if (true) {
          ShapeImage self = this.i_companyReduction;
          
zero_Interface.f_setInfoText(i_companyReduction, zero_Interface.v_infoText.companyHeatDemandReduction, i_companyReduction.getX() + uI_Tabs.v_presentationXOffset, i_companyReduction.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyGasBoiler:
        if (true) {
          ShapeImage self = this.i_companyGasBoiler;
          
zero_Interface.f_setInfoText(i_companyGasBoiler, zero_Interface.v_infoText.companyGasBoiler, i_companyGasBoiler.getX() + uI_Tabs.v_presentationXOffset, i_companyGasBoiler.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyElectricHeatpump:
        if (true) {
          ShapeImage self = this.i_companyElectricHeatpump;
          
zero_Interface.f_setInfoText(i_companyElectricHeatpump, zero_Interface.v_infoText.companyElectricHeatpump, i_companyElectricHeatpump.getX() + uI_Tabs.v_presentationXOffset, i_companyElectricHeatpump.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyHybridHeatpump:
        if (true) {
          ShapeImage self = this.i_companyHybridHeatpump;
          
zero_Interface.f_setInfoText(i_companyHybridHeatpump, zero_Interface.v_infoText.companyHybridHeatpump, i_companyHybridHeatpump.getX() + uI_Tabs.v_presentationXOffset, i_companyHybridHeatpump.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyHeatGrid:
        if (true) {
          ShapeImage self = this.i_companyHeatGrid;
          
zero_Interface.f_setInfoText(i_companyHeatGrid, zero_Interface.v_infoText.companyHeatGrid, i_companyHeatGrid.getX() + uI_Tabs.v_presentationXOffset, i_companyHeatGrid.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyEBoiler:
        if (true) {
          ShapeImage self = this.i_companyEBoiler;
          
zero_Interface.f_setInfoText(i_companyEBoiler, zero_Interface.v_infoText.companyElectricBoiler, i_companyEBoiler.getX() + uI_Tabs.v_presentationXOffset, i_companyEBoiler.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyCustom:
        if (true) {
          ShapeImage self = this.i_companyCustom;
          
zero_Interface.f_setInfoText(i_companyCustom, zero_Interface.v_infoText.companyCustomHeating, i_companyCustom.getX() + uI_Tabs.v_presentationXOffset, i_companyCustom.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdGasBurner:
        if (true) {
          ShapeImage self = this.i_householdGasBurner;
          
zero_Interface.f_setInfoText(i_householdGasBurner, zero_Interface.v_infoText.householdGasBoiler, i_householdGasBurner.getX() + uI_Tabs.v_presentationXOffset, i_householdGasBurner.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdHeatPump:
        if (true) {
          ShapeImage self = this.i_householdHeatPump;
          
zero_Interface.f_setInfoText(i_householdHeatPump, zero_Interface.v_infoText.householdElectricHeatpump, i_householdHeatPump.getX() + uI_Tabs.v_presentationXOffset, i_householdHeatPump.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdHTDistrictHeating:
        if (true) {
          ShapeImage self = this.i_householdHTDistrictHeating;
          
zero_Interface.f_setInfoText(i_householdHTDistrictHeating, zero_Interface.v_infoText.householdHTDistrictHeating, i_householdHTDistrictHeating.getX() + uI_Tabs.v_presentationXOffset, i_householdHTDistrictHeating.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdLTDistrictHeating:
        if (true) {
          ShapeImage self = this.i_householdLTDistrictHeating;
          
zero_Interface.f_setInfoText(i_householdLTDistrictHeating, zero_Interface.v_infoText.householdElectricHeatpump, i_householdLTDistrictHeating.getX() + uI_Tabs.v_presentationXOffset, i_householdLTDistrictHeating.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdAirconditioning:
        if (true) {
          ShapeImage self = this.i_householdAirconditioning;
          
zero_Interface.f_setInfoText(i_householdAirconditioning, zero_Interface.v_infoText.householdAirconditioning, i_householdAirconditioning.getX() + uI_Tabs.v_presentationXOffset, i_householdAirconditioning.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdAdditionalInsulation:
        if (true) {
          ShapeImage self = this.i_householdAdditionalInsulation;
          
zero_Interface.f_setInfoText(i_householdAdditionalInsulation, zero_Interface.v_infoText.householdAdditionalInsulation, i_householdAdditionalInsulation.getX() + uI_Tabs.v_presentationXOffset, i_householdAdditionalInsulation.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdPT:
        if (true) {
          ShapeImage self = this.i_householdPT;
          
zero_Interface.f_setInfoText(i_householdPT, zero_Interface.v_infoText.householdRooftopPT, i_householdPT.getX() + uI_Tabs.v_presentationXOffset, i_householdPT.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdHybridHeatPump:
        if (true) {
          ShapeImage self = this.i_householdHybridHeatPump;
          
zero_Interface.f_setInfoText(i_householdHybridHeatPump, zero_Interface.v_infoText.householdHybridHeatpump, i_householdHybridHeatPump.getX() + uI_Tabs.v_presentationXOffset, i_householdHybridHeatPump.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _arrowLeftResidential:
        if (true) {
          ShapeImage self = this.arrowLeftResidential;
          
f_previousPage(); 
        }
        break;
      case _arrowRightResidential1:
        if (true) {
          ShapeImage self = this.arrowRightResidential1;
          
f_nextPage(); 
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
      case _cb_householdHTDistrictHeating: {
          ShapeCheckBox self = this.cb_householdHTDistrictHeating;
if ( cb_householdHTDistrictHeating.isSelected() ){
	sl_householdGasBurner_pct.setValue(0, false);
	sl_householdElectricHeatPump_pct.setValue(0, false);
	cb_householdLTDistrictHeating.setSelected(false, false);
	f_addDistrictHeatingToAllHouses(uI_Tabs.f_getActiveSliderGridConnections_houses());
}
else{
	sl_householdGasBurner_pct.setValue(100, false);
	sl_householdElectricHeatPump_pct.setValue(0, false);
	cb_householdLTDistrictHeating.setSelected(false, false);
	f_removeDistrictHeatingFromAllHouses(uI_Tabs.f_getActiveSliderGridConnections_houses());
} 
;}
        break;
      case _cb_householdLTDistrictHeating: {
          ShapeCheckBox self = this.cb_householdLTDistrictHeating;
if ( cb_householdLTDistrictHeating.isSelected() ){
	sl_householdElectricHeatPump_pct.setValue(0, false);
	sl_householdGasBurner_pct.setValue(0, false);
	cb_householdHTDistrictHeating.setSelected(false, false);
	f_addLTDH(uI_Tabs.f_getActiveSliderGridConnections_houses());
}
else{
	sl_householdElectricHeatPump_pct.setValue(0, false);
	sl_householdGasBurner_pct.setValue(100, false);
	cb_householdHTDistrictHeating.setSelected(false, false);
	f_removeLTDH(uI_Tabs.f_getActiveSliderGridConnections_houses());
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
  public void executeShapeControlAction( int _shape, int index, double value ) {
    switch( _shape ) {
      case _sl_companiesHeatDemandReduction_pct: {
          ShapeSlider self = this.sl_companiesHeatDemandReduction_pct;
f_setDemandReductionHeating( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_companiesHeatDemandReduction_pct.getValue()); 
;}
        break;
      case _sl_companiesDistrictHeating_pct: {
          ShapeSlider self = this.sl_companiesDistrictHeating_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.DISTRICTHEAT, sl_companiesGasBurner_pct, sl_companiesHybridHeatPump_pct, sl_companiesElectricHeatPump_pct, sl_companiesDistrictHeating_pct, null, sl_companiesCustom_pct );
 
;}
        break;
      case _sl_companiesGasBurner_pct: {
          ShapeSlider self = this.sl_companiesGasBurner_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.GAS_BURNER, sl_companiesGasBurner_pct, sl_companiesHybridHeatPump_pct, sl_companiesElectricHeatPump_pct, sl_companiesDistrictHeating_pct, null, sl_companiesCustom_pct );
 
;}
        break;
      case _sl_companiesHybridHeatPump_pct: {
          ShapeSlider self = this.sl_companiesHybridHeatPump_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.HYBRID_HEATPUMP, sl_companiesGasBurner_pct, sl_companiesHybridHeatPump_pct, sl_companiesElectricHeatPump_pct, sl_companiesDistrictHeating_pct, null, sl_companiesCustom_pct );
 
;}
        break;
      case _sl_companiesElectricHeatPump_pct: {
          ShapeSlider self = this.sl_companiesElectricHeatPump_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, sl_companiesGasBurner_pct, sl_companiesHybridHeatPump_pct, sl_companiesElectricHeatPump_pct, sl_companiesDistrictHeating_pct, null, sl_companiesCustom_pct ); 
;}
        break;
      case _sl_companiesEBoiler_pct: {
          ShapeSlider self = this.sl_companiesEBoiler_pct;
traceln("Slider doet nog niets!!");//f_setHeatingSlidersCompanies(3);
//f_resetNeighborhoodHeatingSystems(4); 
;}
        break;
      case _sl_companiesCustom_pct: {
          ShapeSlider self = this.sl_companiesCustom_pct;
new RuntimeException("This slider action should not be called, this slider is purely for visualisation of the amount of custom heating types for companies"); 
;}
        break;
      case _sl_householdGasBurner_pct: {
          ShapeSlider self = this.sl_householdGasBurner_pct;
if (cb_householdHTDistrictHeating.isSelected()) {
	cb_householdHTDistrictHeating.setSelected(false, false);
	f_removeDistrictHeatingFromAllHouses(uI_Tabs.f_getActiveSliderGridConnections_houses());
}
if (cb_householdLTDistrictHeating.isSelected()) {
	cb_householdLTDistrictHeating.setSelected(false, false);
	f_removeLTDH(uI_Tabs.f_getActiveSliderGridConnections_houses());
}

f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsHouses), OL_GridConnectionHeatingType.GAS_BURNER, sl_householdGasBurner_pct, sl_householdHybridHeatpump_pct, sl_householdElectricHeatPump_pct, null, null, null );
 
;}
        break;
      case _sl_householdElectricHeatPump_pct: {
          ShapeSlider self = this.sl_householdElectricHeatPump_pct;
if (cb_householdHTDistrictHeating.isSelected()) {
	cb_householdHTDistrictHeating.setSelected(false, false);
	f_removeDistrictHeatingFromAllHouses(uI_Tabs.f_getActiveSliderGridConnections_houses());
}
if (cb_householdLTDistrictHeating.isSelected()) {
	cb_householdLTDistrictHeating.setSelected(false, false);
	f_removeLTDH(uI_Tabs.f_getActiveSliderGridConnections_houses());
}

f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsHouses), OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, sl_householdGasBurner_pct, sl_householdHybridHeatpump_pct, sl_householdElectricHeatPump_pct, null, null, null );
 
;}
        break;
      case _sl_householdHeatDemandReduction_pct: {
          ShapeSlider self = this.sl_householdHeatDemandReduction_pct;
f_householdInsulation( uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_householdHeatDemandReduction_pct.getValue() ); 
;}
        break;
      case _sl_householdAirco_pct: {
          ShapeSlider self = this.sl_householdAirco_pct;
f_setAircos(uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_householdAirco_pct.getValue() / 100.0); 
;}
        break;
      case _sl_householdRooftopPT_pct: {
          ShapeSlider self = this.sl_householdRooftopPT_pct;
f_setPTSystemHouses( uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_householdRooftopPT_pct.getValue() ); 
;}
        break;
      case _sl_householdHybridHeatpump_pct: {
          ShapeSlider self = this.sl_householdHybridHeatpump_pct;
if (cb_householdHTDistrictHeating.isSelected()) {
	cb_householdHTDistrictHeating.setSelected(false, false);
	f_removeDistrictHeatingFromAllHouses(uI_Tabs.f_getActiveSliderGridConnections_houses());
}
if (cb_householdLTDistrictHeating.isSelected()) {
	cb_householdLTDistrictHeating.setSelected(false, false);
	f_removeLTDH(uI_Tabs.f_getActiveSliderGridConnections_houses());
}

f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsHouses), OL_GridConnectionHeatingType.HYBRID_HEATPUMP, sl_householdGasBurner_pct, sl_householdHybridHeatpump_pct, sl_householdElectricHeatPump_pct, null, null, null );
 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
        
  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlDefaultValueDouble( int _shape, int index ) {
    switch(_shape) {
      case _sl_companiesHeatDemandReduction_pct: return 
0 
;
      case _sl_companiesDistrictHeating_pct: return 
0 
;
      case _sl_companiesGasBurner_pct: return 
0 
;
      case _sl_companiesHybridHeatPump_pct: return 
0 
;
      case _sl_companiesElectricHeatPump_pct: return 
0 
;
      case _sl_companiesEBoiler_pct: return 
0 
;
      case _sl_companiesCustom_pct: return 
0 
;
      case _sl_householdGasBurner_pct: return 
100 
;
      case _sl_householdElectricHeatPump_pct: return 
0 
;
      case _sl_householdHeatDemandReduction_pct: return 
0 
;
      case _sl_householdAirco_pct: return 
0 
;
      case _sl_householdRooftopPT_pct: return 
0 
;
      case _sl_householdHybridHeatpump_pct: return 
0 
;
      default: return super.getShapeControlDefaultValueDouble( _shape, index );
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesHeatDemandReduction_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
-50 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
50 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_companiesHeatDemandReduction_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesDistrictHeating_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_companiesDistrictHeating_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesGasBurner_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_companiesGasBurner_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesHybridHeatPump_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_companiesHybridHeatPump_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesElectricHeatPump_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_companiesElectricHeatPump_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesEBoiler_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
sl_companiesEBoiler_pct.isEnabled() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
 	}
  }
  
  protected ShapeSlider sl_companiesEBoiler_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesCustom_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_companiesCustom_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdGasBurner_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_householdGasBurner_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdElectricHeatPump_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_householdElectricHeatPump_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdHeatDemandReduction_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_householdHeatDemandReduction_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdAirco_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_householdAirco_pct;
  protected ShapeCheckBox cb_householdHTDistrictHeating;
  protected ShapeCheckBox cb_householdLTDistrictHeating;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdRooftopPT_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_householdRooftopPT_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdHybridHeatpump_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
100 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_householdHybridHeatpump_pct;
  protected ShapeRectangle rect_genericFunctions;
  protected ShapeText t_genericFunctions;
  protected ShapeRectangle rect_heatDemandSliders1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesHeatDemandReductionDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesHeatDemandReduction_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesHeatDemandReductionDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesHeatDemandReduction_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesHeatDemandReduction_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesHeatDemandReduction_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesHeatDemandReduction_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesGasBurnerDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesGasBurner_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesGasBurnerDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesHybridHeatPumpDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesHybridHeatPump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesHybridHeatPumpDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesElectricHeatPumpDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesElectricHeatPump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesElectricHeatPumpDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesDistrictHeatingCompaniesDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesDistrictHeating_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesDistrictHeatingCompaniesDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesElectricHeatPump_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesElectricHeatPump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesElectricHeatPump_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesElectricHeatPump_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesGasBurner_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesGasBurner_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesGasBurner_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesGasBurner_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesDistrictHeating_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesDistrictHeating_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesDistrictHeating_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesDistrictHeating_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesHybridHeatPump_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesHybridHeatPump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesHybridHeatPump_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesHybridHeatPump_pct;
  protected ShapeText txt_heatingDemandSlidersCompaniesDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesEBoiler_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesEBoiler_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesDistrictHeating_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesEBoiler_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesEBoilerDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesEBoiler_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesEBoilerDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyReduction_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesHeatDemandReduction_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyReduction;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyGasBoiler_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesGasBurner_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyGasBoiler;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyElectricHeatpump_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesElectricHeatPump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyElectricHeatpump;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyHybridHeatpump_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesHybridHeatPump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyHybridHeatpump;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyHeatGrid_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesDistrictHeating_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyHeatGrid;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyEBoiler_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesEBoiler_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyEBoiler;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesCustom_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesCustom_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesCustom_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesCustom_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesCustomDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesCustom_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesCustomDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyCustom_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesCustom_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyCustom;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_heatingSliders_companies_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_heatingSliders_companies;
  protected ShapeRectangle rect_demandFunctions;
  protected ShapeText txt_demandFunctionsDescription;
  protected ShapeRectangle rect_heatingFunctions;
  protected ShapeText txt_heatingFunctionsDescription;
  protected ShapeRectangle rect_heatDeandSlidersResidentialArea;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdGasBurnerDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdGasBurner_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdGasBurnerDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdElectricHeatPumpDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdElectricHeatPump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdElectricHeatPumpDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdElectricHeatPump_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdElectricHeatPump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdElectricHeatPump_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_householdElectricHeatPump_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdGasBurner_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdGasBurner_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdGasBurner_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_householdGasBurner_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdHeatDemandReduction_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdHeatDemandReduction_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdHeatDemandReduction_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_householdHeatDemandReduction_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdHeatDemandReductionDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdHeatDemandReduction_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdHeatDemandReductionDescription;
  protected ShapeText txt_heatingDemandSlidersHousesholdsDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdAircoDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdAirco_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdAircoDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdAirco_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdAirco_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdAirco_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_householdAirco_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdGasBurner_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdGasBurner_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdGasBurner;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdHeatPump_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdElectricHeatPump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdHeatPump;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdHTDistrictHeating_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
cb_householdHTDistrictHeating.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdHTDistrictHeating;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdLTDistrictHeating_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
cb_householdLTDistrictHeating.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdLTDistrictHeating;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdAirconditioning_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdAirco_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdAirconditioning;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdAdditionalInsulation_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdHeatDemandReduction_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdAdditionalInsulation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdRooftopPT_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdRooftopPT_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdRooftopPT_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_householdRooftopPT_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdRooftopPTDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdRooftopPT_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdRooftopPTDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdPT_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdRooftopPT_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdPT;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdHybridHeatpumpDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdHybridHeatpump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdHybridHeatpumpDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdHybridHeatPump_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdHybridHeatpump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdHybridHeatPump;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdHybridHeatPump_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdHybridHeatpump_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdHybridHeatpump_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_householdHybridHeatPump_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_heatingSliders_households_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_heatingSliders_households;
  protected ShapeRectangle rect_districtHeatingFunctions;
  protected ShapeText txt_districtheatingFunctionsDescription;
  protected ShapeRectangle rect_heatingProductionFunctions;
  protected ShapeText txt_heatingProductionFunctionsDescription;
  protected ShapeImage arrowLeftResidential;
  protected ShapeImage arrowRightResidential1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_pageIndicator_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Pagina " + (v_currentPageIndex + 1) + "/" + c_loadedPageGroups.size() 
);
  }
  
  protected ShapeText t_pageIndicator;
  protected ShapeGroup gr_pageIndicator;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    sl_companiesHeatDemandReduction_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 55.0,
			100.0, 30.0,
            true, false,
            -50
            , 50
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesHeatDemandReduction_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesHeatDemandReduction_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesHeatDemandReduction_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesDistrictHeating_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 175.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesDistrictHeating_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesDistrictHeating_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesDistrictHeating_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesGasBurner_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 85.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesGasBurner_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesGasBurner_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesGasBurner_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesHybridHeatPump_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 115.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesHybridHeatPump_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesHybridHeatPump_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesHybridHeatPump_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesElectricHeatPump_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 145.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesElectricHeatPump_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesElectricHeatPump_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesElectricHeatPump_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesEBoiler_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 205.0,
			100.0, 30.0,
            false, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesEBoiler_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesEBoiler_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesEBoiler_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesCustom_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 235.0,
			100.0, 30.0,
            false, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesCustom_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesCustom_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesCustom_pct, 0 ), getMax() ) );
      }
    };
    sl_householdGasBurner_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 55.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdGasBurner_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdGasBurner_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdGasBurner_pct, 0 ), getMax() ) );
      }
    };
    sl_householdElectricHeatPump_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 115.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdElectricHeatPump_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdElectricHeatPump_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdElectricHeatPump_pct, 0 ), getMax() ) );
      }
    };
    sl_householdHeatDemandReduction_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 235.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdHeatDemandReduction_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdHeatDemandReduction_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdHeatDemandReduction_pct, 0 ), getMax() ) );
      }
    };
    sl_householdAirco_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 205.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 5
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdAirco_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdAirco_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdAirco_pct, 0 ), getMax() ) );
      }
    };
    cb_householdHTDistrictHeating = new ShapeCheckBox(
tabHeating.this,true,20.0, 142.0,
		135.0, 30.0,
            black, true,
            _cb_householdHTDistrictHeating_Font,
			"HT-Warmtenet" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_householdHTDistrictHeating, 0, value );
      }
    };
    cb_householdLTDistrictHeating = new ShapeCheckBox(
tabHeating.this,true,20.0, 172.0,
		185.0, 30.0,
            black, true,
            _cb_householdLTDistrictHeating_Font,
			"LT-Warmtenet" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_householdLTDistrictHeating, 0, value );
      }
    };
    sl_householdRooftopPT_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 265.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdRooftopPT_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdRooftopPT_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdRooftopPT_pct, 0 ), getMax() ) );
      }
    };
    sl_householdHybridHeatpump_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 85.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdHybridHeatpump_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdHybridHeatpump_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdHybridHeatpump_pct, 0 ), getMax() ) );
      }
    };
    rect_genericFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,10.0, 460.0, 0.0, 0.0,
            silver, white,
			450.0, 580.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_genericFunctions = new ShapeText(
        SHAPE_DRAW_2D, false,140.0, 480.0, 0.0, 0.0,
        black,"Generic Functions",
        _t_genericFunctions_Font, ALIGNMENT_LEFT );
    rect_heatDemandSliders1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, mistyRose,
			370.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_companiesHeatDemandReductionDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 60.0, 0.0, 0.0,
        black,"Besparing warmte",
        _txt_companiesHeatDemandReductionDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesHeatDemandReductionDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesHeatDemandReduction_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 60.0, 0.0, 0.0,
        black,"#",
        _txt_companiesHeatDemandReduction_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesHeatDemandReduction_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesGasBurnerDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 90.0, 0.0, 0.0,
        black,"HR ketel aardgas",
        _txt_companiesGasBurnerDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesGasBurnerDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesHybridHeatPumpDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 120.0, 0.0, 0.0,
        black,"Hybride warmtepomp",
        _txt_companiesHybridHeatPumpDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesHybridHeatPumpDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesElectricHeatPumpDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 150.0, 0.0, 0.0,
        black,"Elektrische warmtepomp",
        _txt_companiesElectricHeatPumpDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesElectricHeatPumpDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesDistrictHeatingCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 180.0, 0.0, 0.0,
        black,"Warmtenet",
        _txt_companiesDistrictHeatingCompaniesDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesDistrictHeatingCompaniesDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesElectricHeatPump_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 150.0, 0.0, 0.0,
        black,"#",
        _txt_companiesElectricHeatPump_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesElectricHeatPump_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesGasBurner_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 90.0, 0.0, 0.0,
        black,"#",
        _txt_companiesGasBurner_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesGasBurner_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesDistrictHeating_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 180.0, 0.0, 0.0,
        black,"#",
        _txt_companiesDistrictHeating_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesDistrictHeating_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesHybridHeatPump_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 120.0, 0.0, 0.0,
        black,"#",
        _txt_companiesHybridHeatPump_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesHybridHeatPump_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_heatingDemandSlidersCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 20.0, 0.0, 0.0,
        black,"Bedrijven",
        _txt_heatingDemandSlidersCompaniesDescription_Font, ALIGNMENT_LEFT );
    txt_companiesEBoiler_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 210.0, 0.0, 0.0,
        black,"#",
        _txt_companiesEBoiler_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesEBoiler_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesEBoilerDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 210.0, 0.0, 0.0,
        black,"E-boiler",
        _txt_companiesEBoilerDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesEBoilerDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_companyReduction = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 58.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyReduction_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyReduction, 0, clickx, clicky );
      }
    };
    i_companyGasBoiler = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 88.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyGasBoiler_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyGasBoiler, 0, clickx, clicky );
      }
    };
    i_companyElectricHeatpump = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 148.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyElectricHeatpump_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyElectricHeatpump, 0, clickx, clicky );
      }
    };
    i_companyHybridHeatpump = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 118.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyHybridHeatpump_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyHybridHeatpump, 0, clickx, clicky );
      }
    };
    i_companyHeatGrid = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 178.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyHeatGrid_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyHeatGrid, 0, clickx, clicky );
      }
    };
    i_companyEBoiler = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 208.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyEBoiler_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyEBoiler, 0, clickx, clicky );
      }
    };
    txt_companiesCustom_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 240.0, 0.0, 0.0,
        black,"#",
        _txt_companiesCustom_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesCustom_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesCustomDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 240.0, 0.0, 0.0,
        black,"Custom systeem",
        _txt_companiesCustomDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesCustomDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_companyCustom = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 238.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyCustom_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyCustom, 0, clickx, clicky );
      }
    };
    rect_demandFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,40.0, 510.0, 0.0, 0.0,
            olive, white,
			390.0, 120.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_demandFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,240.0, 520.0, 0.0, 0.0,
        black,"Demand Functions",
        _txt_demandFunctionsDescription_Font, ALIGNMENT_CENTER );
    rect_heatingFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,40.0, 640.0, 0.0, 0.0,
            brown, white,
			390.0, 150.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_heatingFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,130.0, 650.0, 0.0, 0.0,
        black,"Heating Functions",
        _txt_heatingFunctionsDescription_Font, ALIGNMENT_CENTER );
    rect_heatDeandSlidersResidentialArea = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, mistyRose,
			370.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_householdGasBurnerDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 60.0, 0.0, 0.0,
        black,"Gas brander",
        _txt_householdGasBurnerDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdGasBurnerDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdElectricHeatPumpDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 120.0, 0.0, 0.0,
        black,"Elektrische warmtepomp",
        _txt_householdElectricHeatPumpDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdElectricHeatPumpDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdElectricHeatPump_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 120.0, 0.0, 0.0,
        black,"#",
        _txt_householdElectricHeatPump_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdElectricHeatPump_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdGasBurner_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 60.0, 0.0, 0.0,
        black,"#",
        _t_householdGasBurner_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdGasBurner_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdHeatDemandReduction_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 240.0, 0.0, 0.0,
        black,"#",
        _txt_householdHeatDemandReduction_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdHeatDemandReduction_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdHeatDemandReductionDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 240.0, 0.0, 0.0,
        black,"Huizen met betere isolatie",
        _txt_householdHeatDemandReductionDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdHeatDemandReductionDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_heatingDemandSlidersHousesholdsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 20.0, 0.0, 0.0,
        black,"Huizen",
        _txt_heatingDemandSlidersHousesholdsDescription_Font, ALIGNMENT_LEFT );
    txt_householdAircoDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 210.0, 0.0, 0.0,
        black,"Huizen met Airco",
        _txt_householdAircoDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdAircoDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdAirco_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 210.0, 0.0, 0.0,
        black,"#",
        _txt_householdAirco_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdAirco_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdGasBurner = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 58.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdGasBurner_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdGasBurner, 0, clickx, clicky );
      }
    };
    i_householdHeatPump = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 118.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdHeatPump_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdHeatPump, 0, clickx, clicky );
      }
    };
    i_householdHTDistrictHeating = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 148.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdHTDistrictHeating_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdHTDistrictHeating, 0, clickx, clicky );
      }
    };
    i_householdLTDistrictHeating = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 178.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdLTDistrictHeating_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdLTDistrictHeating, 0, clickx, clicky );
      }
    };
    i_householdAirconditioning = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 208.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdAirconditioning_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdAirconditioning, 0, clickx, clicky );
      }
    };
    i_householdAdditionalInsulation = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 238.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdAdditionalInsulation_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdAdditionalInsulation, 0, clickx, clicky );
      }
    };
    txt_householdRooftopPT_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 270.0, 0.0, 0.0,
        black,"#",
        _txt_householdRooftopPT_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdRooftopPT_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdRooftopPTDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 270.0, 0.0, 0.0,
        black,"Huizen met PT",
        _txt_householdRooftopPTDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdRooftopPTDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdPT = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 268.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdPT_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdPT, 0, clickx, clicky );
      }
    };
    txt_householdHybridHeatpumpDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 90.0, 0.0, 0.0,
        black,"Hybride warmtepomp",
        _txt_householdHybridHeatpumpDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdHybridHeatpumpDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdHybridHeatPump = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 88.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdHybridHeatPump_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdHybridHeatPump, 0, clickx, clicky );
      }
    };
    t_householdHybridHeatPump_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 90.0, 0.0, 0.0,
        black,"#",
        _t_householdHybridHeatPump_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdHybridHeatPump_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_districtHeatingFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,40.0, 800.0, 0.0, 0.0,
            red, white,
			390.0, 150.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_districtheatingFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,160.0, 810.0, 0.0, 0.0,
        black,"District Heating Functions",
        _txt_districtheatingFunctionsDescription_Font, ALIGNMENT_CENTER );
    rect_heatingProductionFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,40.0, 960.0, 0.0, 0.0,
            lime, white,
			390.0, 70.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_heatingProductionFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,160.0, 970.0, 0.0, 0.0,
        black,"District Heating Functions",
        _txt_heatingProductionFunctionsDescription_Font, ALIGNMENT_CENTER );
    arrowLeftResidential = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, -35.0, -12.0, 0.0, 1.5707963267948966,
12.0, 12.0, "/zerointerfaceloader/",
			new String[]{"icon_arrow.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _arrowLeftResidential, 0, clickx, clicky );
      }
    };
    arrowRightResidential1 = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 35.0, 0.0, 0.0, 4.71238898038469,
12.0, 12.0, "/zerointerfaceloader/",
			new String[]{"icon_arrow.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _arrowRightResidential1, 0, clickx, clicky );
      }
    };
    t_pageIndicator = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -12.0, 0.0, 0.0,
        black,"Pagina 1/2",
        _t_pageIndicator_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_pageIndicator_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_heatingSliders_companies = new ShapeGroup( tabHeating.this, SHAPE_DRAW_2D3D, true, 400.0, 0.0, 0.0, 0.0
	
	     , rect_heatDemandSliders1
	     , sl_companiesHeatDemandReduction_pct
	     , txt_companiesHeatDemandReductionDescription
	     , txt_companiesHeatDemandReduction_pct
	     , txt_companiesGasBurnerDescription
	     , txt_companiesHybridHeatPumpDescription
	     , txt_companiesElectricHeatPumpDescription
	     , txt_companiesDistrictHeatingCompaniesDescription
	     , txt_companiesElectricHeatPump_pct
	     , txt_companiesGasBurner_pct
	     , txt_companiesDistrictHeating_pct
	     , txt_companiesHybridHeatPump_pct
	     , sl_companiesDistrictHeating_pct
	     , sl_companiesGasBurner_pct
	     , sl_companiesHybridHeatPump_pct
	     , sl_companiesElectricHeatPump_pct
	     , txt_heatingDemandSlidersCompaniesDescription
	     , txt_companiesEBoiler_pct
	     , sl_companiesEBoiler_pct
	     , txt_companiesEBoilerDescription
	     , i_companyReduction
	     , i_companyGasBoiler
	     , i_companyElectricHeatpump
	     , i_companyHybridHeatpump
	     , i_companyHeatGrid
	     , i_companyEBoiler
	     , txt_companiesCustom_pct
	     , sl_companiesCustom_pct
	     , txt_companiesCustomDescription
	     , i_companyCustom ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_heatingSliders_companies_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_heatingSliders_companies.setVisible( false );
    {
    gr_heatingSliders_households = new ShapeGroup( tabHeating.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , rect_heatDeandSlidersResidentialArea
	     , txt_householdGasBurnerDescription
	     , txt_householdElectricHeatPumpDescription
	     , txt_householdElectricHeatPump_pct
	     , t_householdGasBurner_pct
	     , sl_householdGasBurner_pct
	     , sl_householdElectricHeatPump_pct
	     , sl_householdHeatDemandReduction_pct
	     , txt_householdHeatDemandReduction_pct
	     , txt_householdHeatDemandReductionDescription
	     , txt_heatingDemandSlidersHousesholdsDescription
	     , sl_householdAirco_pct
	     , txt_householdAircoDescription
	     , txt_householdAirco_pct
	     , cb_householdHTDistrictHeating
	     , cb_householdLTDistrictHeating
	     , i_householdGasBurner
	     , i_householdHeatPump
	     , i_householdHTDistrictHeating
	     , i_householdLTDistrictHeating
	     , i_householdAirconditioning
	     , i_householdAdditionalInsulation
	     , txt_householdRooftopPT_pct
	     , sl_householdRooftopPT_pct
	     , txt_householdRooftopPTDescription
	     , i_householdPT
	     , txt_householdHybridHeatpumpDescription
	     , sl_householdHybridHeatpump_pct
	     , i_householdHybridHeatPump
	     , t_householdHybridHeatPump_pct ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_heatingSliders_households_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_heatingSliders_households.setVisible( false );
    {
    gr_pageIndicator = new ShapeGroup( tabHeating.this, SHAPE_DRAW_2D3D, true, 185.0, 20.0, 0.0, 0.0
	
	     , arrowLeftResidential
	     , arrowRightResidential1
	     , t_pageIndicator );
    }
    gr_pageIndicator.setVisible( false );
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
  public tabHeating( Engine engine, Agent owner, AgentList<? extends tabHeating> ownerPopulation ) {
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
    uI_Tabs = get_UI_Tabs();
    zero_Interface = get_Zero_Interface();
    uI_EnergyHub = get_UI_EnergyHub();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public tabHeating() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_tabHeating_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "zerointerfaceloader.tabHeating.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( tabHeating.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    sl_companiesHeatDemandReduction_pct.setValueToDefault();
    sl_companiesDistrictHeating_pct.setValueToDefault();
    sl_companiesGasBurner_pct.setValueToDefault();
    sl_companiesHybridHeatPump_pct.setValueToDefault();
    sl_companiesElectricHeatPump_pct.setValueToDefault();
    sl_companiesEBoiler_pct.setValueToDefault();
    sl_companiesCustom_pct.setValueToDefault();
    sl_householdGasBurner_pct.setValueToDefault();
    sl_householdElectricHeatPump_pct.setValueToDefault();
    sl_householdHeatDemandReduction_pct.setValueToDefault();
    sl_householdAirco_pct.setValueToDefault();
    sl_householdRooftopPT_pct.setValueToDefault();
    sl_householdHybridHeatpump_pct.setValueToDefault();
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
    setupPlainVariables_tabHeating_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_tabHeating_xjal() {
    v_currentPageIndex = 
0 
;
  }

  // User API -----------------------------------------------------
  public UI_Tabs get_UI_Tabs() {
    {
      Agent owner = getOwner();
      if ( owner instanceof UI_Tabs ) return (UI_Tabs) owner;
    }
    return null;
  }

  public UI_EnergyHub get_UI_EnergyHub() {
    {
      UI_Tabs ownerAccessor = get_UI_Tabs();
      if (ownerAccessor != null) {
        UI_EnergyHub owner = ownerAccessor.get_UI_EnergyHub();
        if (owner != null) return owner;
      }
    }
    return null;
  }

  public Zero_Interface get_Zero_Interface() {
    {
      UI_Tabs ownerAccessor = get_UI_Tabs();
      if (ownerAccessor != null) {
        Zero_Interface owner = ownerAccessor.get_Zero_Interface();
        if (owner != null) return owner;
      }
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zerointerfaceloader.UI_Tabs uI_Tabs;

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zerointerfaceloader.Zero_Interface zero_Interface;

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zerointerfaceloader.UI_EnergyHub uI_EnergyHub;

  public AgentList<? extends tabHeating> getPopulation() {
    return (AgentList<? extends tabHeating>) super.getPopulation();
  }

  public List<? extends tabHeating> agentsInRange( double distance ) {
    return (List<? extends tabHeating>) super.agentsInRange( distance );
  }

  // Additional class code

// Page navigation
public ShapeGroup getGroupPageIndicator() {
	return this.gr_pageIndicator;
}

public List<ShapeGroup> getLoadedPages() {
	return this.c_loadedPageGroups;
}

public int getCurrentPageIndex() {
	return this.v_currentPageIndex;
}

// Slider groups
public ShapeGroup getGroupHeatDemandSliders_Households() {
	return this.gr_heatingSliders_households;
}

public ShapeGroup getGroupHeatDemandSliders_Companies() {
	return this.gr_heatingSliders_companies;
}

// Residential Tab Sliders
public ShapeSlider getSliderHouseholdGasBurner_pct() { 
	return this.sl_householdGasBurner_pct;
}

public ShapeSlider getSliderHouseholdHybridHeatpump_pct() { 
	return this.sl_householdHybridHeatpump_pct;
}

public ShapeSlider getSliderHouseholdElectricHeatPump_pct() { 
	return this.sl_householdElectricHeatPump_pct;
}

public ShapeSlider getSliderHouseholdAirco_pct() { 
	return this.sl_householdAirco_pct;
}

public ShapeSlider getSliderHouseholdHeatDemandReduction_pct() { 
	return this.sl_householdHeatDemandReduction_pct;
}

public ShapeSlider getSliderHouseholdRooftopPT_pct() { 
	return this.sl_householdRooftopPT_pct;
}

// Company Tab Sliders
public ShapeSlider getSliderCompaniesHeatDemandReduction_pct() { 
	return this.sl_companiesHeatDemandReduction_pct;
}

public ShapeSlider getSliderCompaniesGasBurner_pct() { 
	return this.sl_companiesGasBurner_pct;
}

public ShapeSlider getSliderCompaniesHybridHeatPump_pct() { 
	return this.sl_companiesHybridHeatPump_pct;
}

public ShapeSlider getSliderCompaniesElectricHeatPump_pct() { 
	return this.sl_companiesElectricHeatPump_pct;
}

public ShapeSlider getSliderCompaniesDistrictHeating_pct(){
	return this.sl_companiesDistrictHeating_pct;
}

public ShapeSlider getSliderCompaniesEBoiler_pct(){
	return this.sl_companiesEBoiler_pct;
}

public ShapeSlider getSliderCompaniesCustomHeating_pct(){
	return this.sl_companiesCustom_pct;
}

 
  // End of additional class code

}
