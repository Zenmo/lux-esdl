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

if(gr_heatingSliders_default.isVisible()){
	f_updateHeatingSliders_default();
}
else if(gr_heatingSliders_businesspark.isVisible()){
	f_updateHeatingSliders_businesspark();
}
else if(gr_heatingSliders_residential.isVisible()){
	f_updateHeatingSliders_residential();
}
else{
	f_updateHeatingSliders_custom();
} 
  }

  void f_updateHeatingSliders_default(  ) { 

////Companies
List<GCUtility> utilityGridConnections = uI_Tabs.f_getActiveSliderGridConnections_utilities();

//Savings (IN PROGRESS, WHAT ABOUT THERMAL BUILDINGS?????)
double totalBaseConsumption_kWh = 0;
double totalSavedConsumption_kWh = 0;
for(GridConnection GC : utilityGridConnections){
	if(GC.v_isActive){
		List<J_EAProfile> profileEAs = findAll(GC.c_profileAssets, profile -> profile.getEnergyCarrier() == OL_EnergyCarriers.HEAT && !(profile instanceof J_EAProduction));
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
sl_heatDemandReductionCompanies_pct.setValue(roundToInt(heatSavings_pct), false);


//Heating assets
//Heating type
int totalCompaniesWithHeating = 0;
int nbOfCompaniesWithGasBurners = 0;
int nbOfCompaniesWithHybridHeatpumps = 0;
int nbOfCompaniesWithElectricHeatpumps = 0;
int nbOfCompaniesOnHTHeatGrid = 0;
int nbOfCompaniesOnLTHeatGrid = 0;

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
		}
	}
}

int companiesWithGasBurners_pct = roundToInt(100.0 * nbOfCompaniesWithGasBurners / totalCompaniesWithHeating);
int companiesWithHybridHeatpump_pct = roundToInt(100.0 * nbOfCompaniesWithHybridHeatpumps / totalCompaniesWithHeating);
int companiesWithElectricHeatpump_pct = roundToInt(100.0 * nbOfCompaniesWithElectricHeatpumps / totalCompaniesWithHeating);
int companiesWithHTDistrictHeat_pct = roundToInt(100.0 * nbOfCompaniesOnHTHeatGrid / totalCompaniesWithHeating);

sl_gasBurnerCompanies_pct.setValue(companiesWithGasBurners_pct, false);
sl_hybridHeatPumpCompanies_pct.setValue(companiesWithHybridHeatpump_pct, false);
sl_electricHeatPumpCompanies_pct.setValue(companiesWithElectricHeatpump_pct, false);
sl_districtHeatingCompanies_pct.setValue(companiesWithHTDistrictHeat_pct, false);


////Houses
List<GCHouse> houseGridConnections = uI_Tabs.f_getActiveSliderGridConnections_houses();

//Savings
double averageScalingFactor = 0;
double totalScalingFactors = 0;
for(GCHouse GC : houseGridConnections){
	if(GC.v_isActive){
		List<J_EAProfile> profileEAs = findAll(GC.c_profileAssets, profile -> profile.getEnergyCarrier() == OL_EnergyCarriers.HEAT && !(profile instanceof J_EAProduction));
		for(J_EAProfile profileEA : profileEAs){
			double totalScalingFactorValue = averageScalingFactor*totalScalingFactors;
			double newTotalScalingFactorValue = totalScalingFactorValue + profileEA.getProfileScaling_fr();
			totalScalingFactors++;
			averageScalingFactor = newTotalScalingFactorValue/totalScalingFactors;
		}	
		if(GC.p_BuildingThermalAsset != null){
			double totalScalingFactorValue = averageScalingFactor*totalScalingFactors;
			double newTotalScalingFactorValue = totalScalingFactorValue + GC.p_BuildingThermalAsset.getLossScalingFactor_fr();
			totalScalingFactors++;
			averageScalingFactor = newTotalScalingFactorValue/totalScalingFactors;
		}
	}
}
double averageSavingsFactor_pct = (1-averageScalingFactor)*100.0;
sl_heatDemandReductionHouseholds_pct.setValue(roundToInt(averageSavingsFactor_pct), false);


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
int housesWithHTDistrictHeat_pct = roundToInt(100.0 * nbOfHousesOnHTHeatGrid / totalHousesWithHeating);

sl_gasBurnerHouseholds_pct.setValue(housesWithGasBurners_pct, false);
sl_hybridHeatPumpHouseholds_pct.setValue(housesWithHybridHeatpump_pct, false);
sl_electricHeatPumpHouseholds_pct.setValue(housesWithElectricHeatpump_pct, false);
sl_districtHeatingHouseholds_pct.setValue(housesWithHTDistrictHeat_pct, false);
 
  }

  void f_updateHeatingSliders_residential(  ) { 

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

sl_householdGasBurnerResidentialArea_pct.setValue(housesWithGasBurners_pct, false);
sl_householdHybridHeatpumpResidentialArea.setValue(housesWithHybridHeatpump_pct, false);
sl_householdElectricHeatPumpResidentialArea_pct.setValue(housesWithElectricHeatpump_pct, false);
cb_householdHTDistrictHeatingResidentialArea.setSelected(false, false);
cb_householdLTDistrictHeatingResidentialArea.setSelected(false, false);

if(nbOfHousesOnHTHeatGrid == totalHousesWithHeating){
	cb_householdHTDistrictHeatingResidentialArea.setSelected(true, false);
}
if(nbOfHousesOnLTHeatGrid == totalHousesWithHeating){
	cb_householdLTDistrictHeatingResidentialArea.setSelected(true, false);
}

//Houses with Airco
double nbHouses = houseGridConnections.size();
double nbHousesWithAirco = count(houseGridConnections, x -> x.p_airco != null);
double pctOfHousesWithAirco = (nbHousesWithAirco*100.0)/nbHouses;
sl_householdAircoResidentialArea_pct.setValue(pctOfHousesWithAirco, false);


//Houses with better isolation
int nbHousesThatCanGetImprovedIsolation = count(houseGridConnections, x -> x.p_insulationLabel != OL_GridConnectionInsulationLabel.A);
int nbHousesWithImprovedInsulation = count(houseGridConnections, x -> x.p_BuildingThermalAsset.getLossScalingFactor_fr() < 1 && x.p_insulationLabel != OL_GridConnectionInsulationLabel.A);
double pctOfHousesWithImprovedInsulation = 100.0 * ((double)nbHousesWithImprovedInsulation)/nbHousesThatCanGetImprovedIsolation;
sl_householdHeatDemandReductionResidentialArea_pct.setValue(roundToInt(pctOfHousesWithImprovedInsulation), false);


//PT
int nbHousesWithPT = count(houseGridConnections, x -> x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW));

sl_rooftopPTHouses_pct.setValue(roundToInt((nbHousesWithPT*100.0)/nbHouses), false); 
  }

  void f_updateHeatingSliders_businesspark(  ) { 

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
sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct.setValue(roundToInt(heatSavings_pct), false);


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


sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct.setValue(companiesWithGasBurners_pct, false);
sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct.setValue(companiesWithHybridHeatpump_pct, false);
sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct.setValue(companiesWithElectricHeatpump_pct, false);
sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct.setValue(companiesWithHTDistrictHeat_pct, false);
//sl_heatDemandSlidersCompaniesLTDistrictHeatingCompanies_pct.setValue(companiesWithLTDistrictHeat_pct, false); Doesnt exist (yet) for companies
sl_heatingTypeSlidersCompaniesCustom_pct.setValue(companiesWithCustomHeating_pct, false);
 
  }

  protected void f_updateHeatingSliders_custom(  ) { 

//If you have a custom tab, 
//override this function to make it update automatically
traceln("Forgot to override the update custom heating sliders functionality"); 
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

// Check wether transformer capacity is known or estimated
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
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_householdHTDistrictHeatingResidentialArea_Font = new Font("Dialog", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_householdLTDistrictHeatingResidentialArea_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_genericFunctions_Font = new Font("SansSerif", 0, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gasBurnerHouseholdsDescription_Font = new Font("Dialog", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_hybridHeatPumpHouseholdsDescription_Font = new Font("SansSerif", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricHeatPumpHouseholdsDescription_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_districtHeatingHouseholdsDescription_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricHeatPumpHouseholds_pct_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gasBurnerHouseholds_pct_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_districtHeatingHouseholds_pct_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_hybridHeatPumpHouseholds_pct_Font = _t_hybridHeatPumpHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_heatDemandReductionHouseholds_pct_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_heatDemandReductionHouseholdsDescription_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdsDescription_Font = new Font("Calibri", 1, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_heatDemandReductionCompaniesDescription_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_heatDemandReductionCompanies_pct_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gasBurnerCompaniesDescription_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_hybridHeatPumpCompaniesDescription_Font = _t_hybridHeatPumpHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricHeatPumpCompaniesDescription_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_districtHeatingCompaniesDescription_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricHeatPumpCompanies_pct_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gasBurnerCompanies_pct_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_districtHeatingCompanies_pct_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_hybridHeatPumpCompanies_pct_Font = _t_hybridHeatPumpHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_companiesDescription_Font = _t_householdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_heatDemandReductionCompaniesDescription1_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_heatDemandReductionCompanies_pct1_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gasBurnerCompaniesDescription1_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_hybridHeatPumpCompaniesDescription1_Font = _t_hybridHeatPumpHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricHeatPumpCompaniesDescription1_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_districtHeatingCompaniesDescription1_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricHeatPumpCompanies_pct1_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gasBurnerCompanies_pct1_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_districtHeatingCompanies_pct1_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_hybridHeatPumpCompanies_pct1_Font = _t_hybridHeatPumpHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_companiesDescription1_Font = _t_householdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_eBoilerCompanies_pct_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_eBoilerCompaniesDescription_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_customHeatingTypeCompanies_pct_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_customHeatingDemandCompaniesDescription_Font = _t_gasBurnerHouseholdsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_demandFunctionsDescription_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_heatingFunctionsDescription_Font = _txt_demandFunctionsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdGasBurnerDescriptionResidentialArea_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdElectricHeatPumpDescriptionResidentialArea_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdElectricHeatPumpResidentialArea_pct_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdGasBurnerResidentialArea_pct_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdHeatDemandReductionResidentialArea_pct_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdHeatDemandReductionDescriptionResidentialArea_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdHeatingTypeDescriptionResidentialArea_Font = new Font("Dialog", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdAircoDescriptionResidentialArea_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdAircoResidentialArea_pct_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_rooftopPTHouses_pct_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_rooftopPTHousesDescription_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdHybridHeatpumpDescriptionResidentialArea_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdElectricHeatPumpResidentialArea_pct1_Font = _cb_householdHTDistrictHeatingResidentialArea_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_districtheatingFunctionsDescription_Font = _txt_demandFunctionsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_heatingProductionFunctionsDescription_Font = _txt_demandFunctionsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_genericFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_genericFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_heatDemandSliders = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gasBurnerHouseholdsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_hybridHeatPumpHouseholdsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricHeatPumpHouseholdsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_districtHeatingHouseholdsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricHeatPumpHouseholds_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gasBurnerHouseholds_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_districtHeatingHouseholds_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_hybridHeatPumpHouseholds_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_heatDemandReductionHouseholds_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_heatDemandReductionHouseholdsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_heatDemandReductionCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_heatDemandReductionCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gasBurnerCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_hybridHeatPumpCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricHeatPumpCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_districtHeatingCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricHeatPumpCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gasBurnerCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_districtHeatingCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_hybridHeatPumpCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_companiesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyReduction = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyGasBoiler = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyElectricHeatpump = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyHybridHeatpump = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyHeatGrid = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdElectricHeatpump = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdReduction = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdGasBoiler = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdHeatGrid = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdHybridHeatpump = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_heatingSliders_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_heatDemandSliders1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_heatDemandReductionCompaniesDescription1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_heatDemandReductionCompanies_pct1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gasBurnerCompaniesDescription1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_hybridHeatPumpCompaniesDescription1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricHeatPumpCompaniesDescription1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_districtHeatingCompaniesDescription1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricHeatPumpCompanies_pct1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gasBurnerCompanies_pct1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_districtHeatingCompanies_pct1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_hybridHeatPumpCompanies_pct1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_companiesDescription1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_eBoilerCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_eBoilerCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyReduction_Company = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyGasBoiler_Company = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyElectricHeatpump_Company = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyHybridHeatpump_Company = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyHeatGrid_Company = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyEBoiler_Company = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_customHeatingTypeCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_customHeatingDemandCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyCustomHeatingType_Company = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_heatingSliders_businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_demandFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_demandFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_heatingFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_heatingFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_heatDeandSlidersResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdGasBurnerDescriptionResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdElectricHeatPumpDescriptionResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdElectricHeatPumpResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdGasBurnerResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdHeatDemandReductionResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdHeatDemandReductionDescriptionResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdHeatingTypeDescriptionResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdAircoDescriptionResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdAircoResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdGasBurner = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdHeatPump = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 76;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdHTDistrictHeating = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 77;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdLTDistrictHeating = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 78;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdAirconditioning = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 79;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdAdditionalInsulation = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 80;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_ptSlidersHouses = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 81;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_rooftopPTHouses_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 82;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_rooftopPTHousesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 83;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdPT = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 84;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdHybridHeatpumpDescriptionResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 85;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdHybridHeatPump = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 86;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdElectricHeatPumpResidentialArea_pct1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 87;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_heatingSliders_residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 88;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_districtHeatingFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 89;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_districtheatingFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 90;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_heatingProductionFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 91;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_heatingProductionFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 92;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_districtHeatingHouseholds_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 93;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_gasBurnerHouseholds_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 94;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_hybridHeatPumpHouseholds_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 95;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricHeatPumpHouseholds_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 96;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatDemandReductionHouseholds_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 97;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatDemandReductionCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 98;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_districtHeatingCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 99;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_gasBurnerCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 100;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_hybridHeatPumpCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 101;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricHeatPumpCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 102;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 103;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 104;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 105;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 106;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 107;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatDemandSlidersCompaniesEBoiler_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 108;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_heatingTypeSlidersCompaniesCustom_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 109;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdGasBurnerResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 110;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdElectricHeatPumpResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 111;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdHeatDemandReductionResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 112;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdAircoResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 113;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_householdHTDistrictHeatingResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 114;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_householdLTDistrictHeatingResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 115;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_rooftopPTHouses_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 116;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdHybridHeatpumpResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 117;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 118;

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
	  level.addAll(rect_genericFunctions, t_genericFunctions, gr_heatingSliders_default, gr_heatingSliders_businesspark, rect_demandFunctions, txt_demandFunctionsDescription, rect_heatingFunctions, txt_heatingFunctionsDescription, gr_heatingSliders_residential, rect_districtHeatingFunctions, txt_districtheatingFunctionsDescription, rect_heatingProductionFunctions, txt_heatingProductionFunctionsDescription);
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
      case _i_householdElectricHeatpump:
        if (true) {
          ShapeImage self = this.i_householdElectricHeatpump;
          
zero_Interface.f_setInfoText(i_householdElectricHeatpump, zero_Interface.v_infoText.householdElectricHeatpump, i_householdElectricHeatpump.getX() + uI_Tabs.v_presentationXOffset, i_householdElectricHeatpump.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdReduction:
        if (true) {
          ShapeImage self = this.i_householdReduction;
          
zero_Interface.f_setInfoText(i_householdReduction, zero_Interface.v_infoText.householdHeatDemandReduction, i_householdReduction.getX() + uI_Tabs.v_presentationXOffset, i_householdReduction.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdGasBoiler:
        if (true) {
          ShapeImage self = this.i_householdGasBoiler;
          
zero_Interface.f_setInfoText(i_householdGasBoiler, zero_Interface.v_infoText.householdGasBoiler, i_householdGasBoiler.getX() + uI_Tabs.v_presentationXOffset, i_householdGasBoiler.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdHeatGrid:
        if (true) {
          ShapeImage self = this.i_householdHeatGrid;
          
zero_Interface.f_setInfoText(i_householdHeatGrid, zero_Interface.v_infoText.householdHeatGrid, i_householdHeatGrid.getX() + uI_Tabs.v_presentationXOffset, i_householdHeatGrid.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdHybridHeatpump:
        if (true) {
          ShapeImage self = this.i_householdHybridHeatpump;
          
zero_Interface.f_setInfoText(i_householdHybridHeatpump, zero_Interface.v_infoText.householdHybridHeatpump, i_householdHybridHeatpump.getX() + uI_Tabs.v_presentationXOffset, i_householdHybridHeatpump.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyReduction_Company:
        if (true) {
          ShapeImage self = this.i_companyReduction_Company;
          
zero_Interface.f_setInfoText(i_companyReduction_Company, zero_Interface.v_infoText.companyHeatDemandReduction, i_companyReduction_Company.getX() + uI_Tabs.v_presentationXOffset, i_companyReduction_Company.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyGasBoiler_Company:
        if (true) {
          ShapeImage self = this.i_companyGasBoiler_Company;
          
zero_Interface.f_setInfoText(i_companyGasBoiler_Company, zero_Interface.v_infoText.companyGasBoiler, i_companyGasBoiler_Company.getX() + uI_Tabs.v_presentationXOffset, i_companyGasBoiler_Company.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyElectricHeatpump_Company:
        if (true) {
          ShapeImage self = this.i_companyElectricHeatpump_Company;
          
zero_Interface.f_setInfoText(i_companyElectricHeatpump_Company, zero_Interface.v_infoText.companyElectricHeatpump, i_companyElectricHeatpump_Company.getX() + uI_Tabs.v_presentationXOffset, i_companyElectricHeatpump_Company.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyHybridHeatpump_Company:
        if (true) {
          ShapeImage self = this.i_companyHybridHeatpump_Company;
          
zero_Interface.f_setInfoText(i_companyHybridHeatpump_Company, zero_Interface.v_infoText.companyHybridHeatpump, i_companyHybridHeatpump_Company.getX() + uI_Tabs.v_presentationXOffset, i_companyHybridHeatpump_Company.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyHeatGrid_Company:
        if (true) {
          ShapeImage self = this.i_companyHeatGrid_Company;
          
zero_Interface.f_setInfoText(i_companyHeatGrid_Company, zero_Interface.v_infoText.companyHeatGrid, i_companyHeatGrid_Company.getX() + uI_Tabs.v_presentationXOffset, i_companyHeatGrid_Company.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyEBoiler_Company:
        if (true) {
          ShapeImage self = this.i_companyEBoiler_Company;
          
zero_Interface.f_setInfoText(i_companyEBoiler_Company, zero_Interface.v_infoText.companyElectricBoiler, i_companyEBoiler_Company.getX() + uI_Tabs.v_presentationXOffset, i_companyEBoiler_Company.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyCustomHeatingType_Company:
        if (true) {
          ShapeImage self = this.i_companyCustomHeatingType_Company;
          
zero_Interface.f_setInfoText(i_companyCustomHeatingType_Company, zero_Interface.v_infoText.companyCustomHeating, i_companyCustomHeatingType_Company.getX() + uI_Tabs.v_presentationXOffset, i_companyCustomHeatingType_Company.getY() + uI_Tabs.v_presentationYOffset); 
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
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, boolean value ) {
    switch( _shape ) {
      case _cb_householdHTDistrictHeatingResidentialArea: {
          ShapeCheckBox self = this.cb_householdHTDistrictHeatingResidentialArea;
if ( cb_householdHTDistrictHeatingResidentialArea.isSelected() ){
	sl_householdGasBurnerResidentialArea_pct.setValue(0, false);
	sl_householdElectricHeatPumpResidentialArea_pct.setValue(0, false);
	cb_householdLTDistrictHeatingResidentialArea.setSelected(false, false);
	f_addDistrictHeatingToAllHouses(uI_Tabs.f_getActiveSliderGridConnections_houses());
}
else{
	sl_householdGasBurnerResidentialArea_pct.setValue(100, false);
	sl_householdElectricHeatPumpResidentialArea_pct.setValue(0, false);
	cb_householdLTDistrictHeatingResidentialArea.setSelected(false, false);
	f_removeDistrictHeatingFromAllHouses(uI_Tabs.f_getActiveSliderGridConnections_houses());
} 
;}
        break;
      case _cb_householdLTDistrictHeatingResidentialArea: {
          ShapeCheckBox self = this.cb_householdLTDistrictHeatingResidentialArea;
if ( cb_householdLTDistrictHeatingResidentialArea.isSelected() ){
	sl_householdElectricHeatPumpResidentialArea_pct.setValue(0, false);
	sl_householdGasBurnerResidentialArea_pct.setValue(0, false);
	cb_householdHTDistrictHeatingResidentialArea.setSelected(false, false);
	f_addLTDH(uI_Tabs.f_getActiveSliderGridConnections_houses());
}
else{
	sl_householdElectricHeatPumpResidentialArea_pct.setValue(0, false);
	sl_householdGasBurnerResidentialArea_pct.setValue(100, false);
	cb_householdHTDistrictHeatingResidentialArea.setSelected(false, false);
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
      case _sl_districtHeatingHouseholds_pct: {
          ShapeSlider self = this.sl_districtHeatingHouseholds_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsHouses), OL_GridConnectionHeatingType.DISTRICTHEAT, sl_gasBurnerHouseholds_pct, sl_hybridHeatPumpHouseholds_pct, sl_electricHeatPumpHouseholds_pct, sl_districtHeatingHouseholds_pct, null, null );
 
;}
        break;
      case _sl_gasBurnerHouseholds_pct: {
          ShapeSlider self = this.sl_gasBurnerHouseholds_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsHouses), OL_GridConnectionHeatingType.GAS_BURNER, sl_gasBurnerHouseholds_pct, sl_hybridHeatPumpHouseholds_pct, sl_electricHeatPumpHouseholds_pct, sl_districtHeatingHouseholds_pct, null, null );
 
;}
        break;
      case _sl_hybridHeatPumpHouseholds_pct: {
          ShapeSlider self = this.sl_hybridHeatPumpHouseholds_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsHouses), OL_GridConnectionHeatingType.HYBRID_HEATPUMP, sl_gasBurnerHouseholds_pct, sl_hybridHeatPumpHouseholds_pct, sl_electricHeatPumpHouseholds_pct, sl_districtHeatingHouseholds_pct, null, null );
 
;}
        break;
      case _sl_electricHeatPumpHouseholds_pct: {
          ShapeSlider self = this.sl_electricHeatPumpHouseholds_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsHouses), OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, sl_gasBurnerHouseholds_pct, sl_hybridHeatPumpHouseholds_pct, sl_electricHeatPumpHouseholds_pct, sl_districtHeatingHouseholds_pct, null, null );
 
;}
        break;
      case _sl_heatDemandReductionHouseholds_pct: {
          ShapeSlider self = this.sl_heatDemandReductionHouseholds_pct;
f_setDemandReductionHeating( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), sl_heatDemandReductionHouseholds_pct.getValue() ); 
;}
        break;
      case _sl_heatDemandReductionCompanies_pct: {
          ShapeSlider self = this.sl_heatDemandReductionCompanies_pct;
f_setDemandReductionHeating( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_heatDemandReductionCompanies_pct.getValue() ); 
;}
        break;
      case _sl_districtHeatingCompanies_pct: {
          ShapeSlider self = this.sl_districtHeatingCompanies_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.DISTRICTHEAT, sl_gasBurnerCompanies_pct, sl_hybridHeatPumpCompanies_pct, sl_electricHeatPumpCompanies_pct, sl_districtHeatingCompanies_pct, null, null );
 
;}
        break;
      case _sl_gasBurnerCompanies_pct: {
          ShapeSlider self = this.sl_gasBurnerCompanies_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.GAS_BURNER, sl_gasBurnerCompanies_pct, sl_hybridHeatPumpCompanies_pct, sl_electricHeatPumpCompanies_pct, sl_districtHeatingCompanies_pct, null, null );
 
;}
        break;
      case _sl_hybridHeatPumpCompanies_pct: {
          ShapeSlider self = this.sl_hybridHeatPumpCompanies_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.HYBRID_HEATPUMP, sl_gasBurnerCompanies_pct, sl_hybridHeatPumpCompanies_pct, sl_electricHeatPumpCompanies_pct, sl_districtHeatingCompanies_pct, null, null );
 
;}
        break;
      case _sl_electricHeatPumpCompanies_pct: {
          ShapeSlider self = this.sl_electricHeatPumpCompanies_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, sl_gasBurnerCompanies_pct, sl_hybridHeatPumpCompanies_pct, sl_electricHeatPumpCompanies_pct, sl_districtHeatingCompanies_pct, null, null );
 
;}
        break;
      case _sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct: {
          ShapeSlider self = this.sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct;
f_setDemandReductionHeating( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct.getValue()); 
;}
        break;
      case _sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct: {
          ShapeSlider self = this.sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.DISTRICTHEAT, sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct, sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct, sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct, sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct, null, sl_heatingTypeSlidersCompaniesCustom_pct );
 
;}
        break;
      case _sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct: {
          ShapeSlider self = this.sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.GAS_BURNER, sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct, sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct, sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct, sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct, null, sl_heatingTypeSlidersCompaniesCustom_pct );
 
;}
        break;
      case _sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct: {
          ShapeSlider self = this.sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.HYBRID_HEATPUMP, sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct, sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct, sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct, sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct, null, sl_heatingTypeSlidersCompaniesCustom_pct );
 
;}
        break;
      case _sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct: {
          ShapeSlider self = this.sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct;
f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsCompanies), OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct, sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct, sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct, sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct, null, sl_heatingTypeSlidersCompaniesCustom_pct );
 
;}
        break;
      case _sl_heatDemandSlidersCompaniesEBoiler_pct: {
          ShapeSlider self = this.sl_heatDemandSlidersCompaniesEBoiler_pct;
traceln("Slider doet nog niets!!");//f_setHeatingSlidersCompanies(3);
//f_resetNeighborhoodHeatingSystems(4); 
;}
        break;
      case _sl_heatingTypeSlidersCompaniesCustom_pct: {
          ShapeSlider self = this.sl_heatingTypeSlidersCompaniesCustom_pct;
new RuntimeException("This slider action should not be called, this slider is purely for visualisation of the amount of custom heating types for companies"); 
;}
        break;
      case _sl_householdGasBurnerResidentialArea_pct: {
          ShapeSlider self = this.sl_householdGasBurnerResidentialArea_pct;
if (cb_householdHTDistrictHeatingResidentialArea.isSelected()) {
	cb_householdHTDistrictHeatingResidentialArea.setSelected(false, false);
	f_removeDistrictHeatingFromAllHouses(uI_Tabs.f_getActiveSliderGridConnections_houses());
}
if (cb_householdLTDistrictHeatingResidentialArea.isSelected()) {
	cb_householdLTDistrictHeatingResidentialArea.setSelected(false, false);
	f_removeLTDH(uI_Tabs.f_getActiveSliderGridConnections_houses());
}

f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsHouses), OL_GridConnectionHeatingType.GAS_BURNER, sl_householdGasBurnerResidentialArea_pct, sl_householdHybridHeatpumpResidentialArea, sl_householdElectricHeatPumpResidentialArea_pct, null, null, null );
 
;}
        break;
      case _sl_householdElectricHeatPumpResidentialArea_pct: {
          ShapeSlider self = this.sl_householdElectricHeatPumpResidentialArea_pct;
if (cb_householdHTDistrictHeatingResidentialArea.isSelected()) {
	cb_householdHTDistrictHeatingResidentialArea.setSelected(false, false);
	f_removeDistrictHeatingFromAllHouses(uI_Tabs.f_getActiveSliderGridConnections_houses());
}
if (cb_householdLTDistrictHeatingResidentialArea.isSelected()) {
	cb_householdLTDistrictHeatingResidentialArea.setSelected(false, false);
	f_removeLTDH(uI_Tabs.f_getActiveSliderGridConnections_houses());
}

f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsHouses), OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, sl_householdGasBurnerResidentialArea_pct, sl_householdHybridHeatpumpResidentialArea, sl_householdElectricHeatPumpResidentialArea_pct, null, null, null );
 
;}
        break;
      case _sl_householdHeatDemandReductionResidentialArea_pct: {
          ShapeSlider self = this.sl_householdHeatDemandReductionResidentialArea_pct;
f_householdInsulation( uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_householdHeatDemandReductionResidentialArea_pct.getValue() ); 
;}
        break;
      case _sl_householdAircoResidentialArea_pct: {
          ShapeSlider self = this.sl_householdAircoResidentialArea_pct;
f_setAircos(uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_householdAircoResidentialArea_pct.getValue() / 100.0); 
;}
        break;
      case _sl_rooftopPTHouses_pct: {
          ShapeSlider self = this.sl_rooftopPTHouses_pct;
f_setPTSystemHouses( uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_rooftopPTHouses_pct.getValue() ); 
;}
        break;
      case _sl_householdHybridHeatpumpResidentialArea: {
          ShapeSlider self = this.sl_householdHybridHeatpumpResidentialArea;
if (cb_householdHTDistrictHeatingResidentialArea.isSelected()) {
	cb_householdHTDistrictHeatingResidentialArea.setSelected(false, false);
	f_removeDistrictHeatingFromAllHouses(uI_Tabs.f_getActiveSliderGridConnections_houses());
}
if (cb_householdLTDistrictHeatingResidentialArea.isSelected()) {
	cb_householdLTDistrictHeatingResidentialArea.setSelected(false, false);
	f_removeLTDH(uI_Tabs.f_getActiveSliderGridConnections_houses());
}

f_setHeatingSliders( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), new ArrayList<GridConnection>(zero_Interface.c_orderedHeatingSystemsHouses), OL_GridConnectionHeatingType.HYBRID_HEATPUMP, sl_householdGasBurnerResidentialArea_pct, sl_householdHybridHeatpumpResidentialArea, sl_householdElectricHeatPumpResidentialArea_pct, null, null, null );
 
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
      case _sl_districtHeatingHouseholds_pct: return 
0 
;
      case _sl_gasBurnerHouseholds_pct: return 
0 
;
      case _sl_hybridHeatPumpHouseholds_pct: return 
0 
;
      case _sl_electricHeatPumpHouseholds_pct: return 
0 
;
      case _sl_heatDemandReductionHouseholds_pct: return 
0 
;
      case _sl_heatDemandReductionCompanies_pct: return 
0 
;
      case _sl_districtHeatingCompanies_pct: return 
0 
;
      case _sl_gasBurnerCompanies_pct: return 
0 
;
      case _sl_hybridHeatPumpCompanies_pct: return 
0 
;
      case _sl_electricHeatPumpCompanies_pct: return 
0 
;
      case _sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct: return 
0 
;
      case _sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct: return 
0 
;
      case _sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct: return 
0 
;
      case _sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct: return 
0 
;
      case _sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct: return 
0 
;
      case _sl_heatDemandSlidersCompaniesEBoiler_pct: return 
0 
;
      case _sl_heatingTypeSlidersCompaniesCustom_pct: return 
0 
;
      case _sl_householdGasBurnerResidentialArea_pct: return 
100 
;
      case _sl_householdElectricHeatPumpResidentialArea_pct: return 
0 
;
      case _sl_householdHeatDemandReductionResidentialArea_pct: return 
0 
;
      case _sl_householdAircoResidentialArea_pct: return 
0 
;
      case _sl_rooftopPTHouses_pct: return 
0 
;
      case _sl_householdHybridHeatpumpResidentialArea: return 
0 
;
      default: return super.getShapeControlDefaultValueDouble( _shape, index );
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_districtHeatingHouseholds_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
false 
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
  
  protected ShapeSlider sl_districtHeatingHouseholds_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_gasBurnerHouseholds_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_gasBurnerHouseholds_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_hybridHeatPumpHouseholds_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
false 
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
  
  protected ShapeSlider sl_hybridHeatPumpHouseholds_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_electricHeatPumpHouseholds_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_electricHeatPumpHouseholds_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_heatDemandReductionHouseholds_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_heatDemandReductionHouseholds_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_heatDemandReductionCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_heatDemandReductionCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_districtHeatingCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
false 
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
  
  protected ShapeSlider sl_districtHeatingCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_gasBurnerCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_gasBurnerCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_hybridHeatPumpCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
false 
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
  
  protected ShapeSlider sl_hybridHeatPumpCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_electricHeatPumpCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_electricHeatPumpCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_heatDemandSlidersCompaniesEBoiler_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
sl_heatDemandSlidersCompaniesEBoiler_pct.isEnabled() 
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
  
  protected ShapeSlider sl_heatDemandSlidersCompaniesEBoiler_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_heatingTypeSlidersCompaniesCustom_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_heatingTypeSlidersCompaniesCustom_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdGasBurnerResidentialArea_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdGasBurnerResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdElectricHeatPumpResidentialArea_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdElectricHeatPumpResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdHeatDemandReductionResidentialArea_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdHeatDemandReductionResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdAircoResidentialArea_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdAircoResidentialArea_pct;
  protected ShapeCheckBox cb_householdHTDistrictHeatingResidentialArea;
  protected ShapeCheckBox cb_householdLTDistrictHeatingResidentialArea;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_rooftopPTHouses_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_rooftopPTHouses_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdHybridHeatpumpResidentialArea_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdHybridHeatpumpResidentialArea;
  protected ShapeRectangle rect_genericFunctions;
  protected ShapeText t_genericFunctions;
  protected ShapeRectangle rect_heatDemandSliders;
  protected ShapeText t_gasBurnerHouseholdsDescription;
  protected ShapeText t_hybridHeatPumpHouseholdsDescription;
  protected ShapeText t_electricHeatPumpHouseholdsDescription;
  protected ShapeText t_districtHeatingHouseholdsDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_electricHeatPumpHouseholds_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_electricHeatPumpHouseholds_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_electricHeatPumpHouseholds_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_gasBurnerHouseholds_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_gasBurnerHouseholds_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_gasBurnerHouseholds_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_districtHeatingHouseholds_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_districtHeatingHouseholds_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_districtHeatingHouseholds_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_hybridHeatPumpHouseholds_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_hybridHeatPumpHouseholds_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_hybridHeatPumpHouseholds_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_heatDemandReductionHouseholds_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_heatDemandReductionHouseholds_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_heatDemandReductionHouseholds_pct;
  protected ShapeText t_heatDemandReductionHouseholdsDescription;
  protected ShapeText t_householdsDescription;
  protected ShapeText t_heatDemandReductionCompaniesDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_heatDemandReductionCompanies_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_heatDemandReductionCompanies_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_heatDemandReductionCompanies_pct;
  protected ShapeText t_gasBurnerCompaniesDescription;
  protected ShapeText t_hybridHeatPumpCompaniesDescription;
  protected ShapeText t_electricHeatPumpCompaniesDescription;
  protected ShapeText t_districtHeatingCompaniesDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_electricHeatPumpCompanies_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_electricHeatPumpCompanies_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_electricHeatPumpCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_gasBurnerCompanies_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_gasBurnerCompanies_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_gasBurnerCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_districtHeatingCompanies_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_districtHeatingCompanies_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_districtHeatingCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_hybridHeatPumpCompanies_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_hybridHeatPumpCompanies_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_hybridHeatPumpCompanies_pct;
  protected ShapeText t_companiesDescription;
  protected ShapeImage i_companyReduction;
  protected ShapeImage i_companyGasBoiler;
  protected ShapeImage i_companyElectricHeatpump;
  protected ShapeImage i_companyHybridHeatpump;
  protected ShapeImage i_companyHeatGrid;
  protected ShapeImage i_householdElectricHeatpump;
  protected ShapeImage i_householdReduction;
  protected ShapeImage i_householdGasBoiler;
  protected ShapeImage i_householdHeatGrid;
  protected ShapeImage i_householdHybridHeatpump;
  protected ShapeGroup gr_heatingSliders_default;
  protected ShapeRectangle rect_heatDemandSliders1;
  protected ShapeText t_heatDemandReductionCompaniesDescription1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_heatDemandReductionCompanies_pct1_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_heatDemandReductionCompanies_pct1;
  protected ShapeText t_gasBurnerCompaniesDescription1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_hybridHeatPumpCompaniesDescription1_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_hybridHeatPumpCompaniesDescription1;
  protected ShapeText t_electricHeatPumpCompaniesDescription1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_districtHeatingCompaniesDescription1_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_districtHeatingCompaniesDescription1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_electricHeatPumpCompanies_pct1_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_electricHeatPumpCompanies_pct1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_gasBurnerCompanies_pct1_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_gasBurnerCompanies_pct1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_districtHeatingCompanies_pct1_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_districtHeatingCompanies_pct1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_hybridHeatPumpCompanies_pct1_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_hybridHeatPumpCompanies_pct1;
  protected ShapeText t_companiesDescription1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_eBoilerCompanies_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_heatDemandSlidersCompaniesEBoiler_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_heatDemandSlidersCompaniesEBoiler_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_eBoilerCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_eBoilerCompaniesDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_heatDemandSlidersCompaniesEBoiler_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_eBoilerCompaniesDescription;
  protected ShapeImage i_companyReduction_Company;
  protected ShapeImage i_companyGasBoiler_Company;
  protected ShapeImage i_companyElectricHeatpump_Company;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyHybridHeatpump_Company_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyHybridHeatpump_Company;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyHeatGrid_Company_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyHeatGrid_Company;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyEBoiler_Company_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_heatDemandSlidersCompaniesEBoiler_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyEBoiler_Company;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_customHeatingTypeCompanies_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_heatingTypeSlidersCompaniesCustom_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_heatingTypeSlidersCompaniesCustom_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_customHeatingTypeCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_customHeatingDemandCompaniesDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_heatingTypeSlidersCompaniesCustom_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_customHeatingDemandCompaniesDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companyCustomHeatingType_Company_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_heatingTypeSlidersCompaniesCustom_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companyCustomHeatingType_Company;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_heatingSliders_businesspark_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_heatingSliders_businesspark;
  protected ShapeRectangle rect_demandFunctions;
  protected ShapeText txt_demandFunctionsDescription;
  protected ShapeRectangle rect_heatingFunctions;
  protected ShapeText txt_heatingFunctionsDescription;
  protected ShapeRectangle rect_heatDeandSlidersResidentialArea;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdGasBurnerDescriptionResidentialArea_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdGasBurnerResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_householdGasBurnerDescriptionResidentialArea;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdElectricHeatPumpDescriptionResidentialArea_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdElectricHeatPumpResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_householdElectricHeatPumpDescriptionResidentialArea;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdElectricHeatPumpResidentialArea_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdElectricHeatPumpResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdElectricHeatPumpResidentialArea_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_householdElectricHeatPumpResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdGasBurnerResidentialArea_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdGasBurnerResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdGasBurnerResidentialArea_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_householdGasBurnerResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdHeatDemandReductionResidentialArea_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdHeatDemandReductionResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdHeatDemandReductionResidentialArea_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_householdHeatDemandReductionResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdHeatDemandReductionDescriptionResidentialArea_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdHeatDemandReductionResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_householdHeatDemandReductionDescriptionResidentialArea;
  protected ShapeText t_householdHeatingTypeDescriptionResidentialArea;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdAircoDescriptionResidentialArea_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdAircoResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_householdAircoDescriptionResidentialArea;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdAircoResidentialArea_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdAircoResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdAircoResidentialArea_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_householdAircoResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdGasBurner_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdGasBurnerResidentialArea_pct.isVisible() 
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
sl_householdElectricHeatPumpResidentialArea_pct.isVisible() 
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
cb_householdHTDistrictHeatingResidentialArea.isVisible() 
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
cb_householdLTDistrictHeatingResidentialArea.isVisible() 
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
sl_householdAircoResidentialArea_pct.isVisible() 
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
sl_householdHeatDemandReductionResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdAdditionalInsulation;
  protected ShapeGroup gr_ptSlidersHouses;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_rooftopPTHouses_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_rooftopPTHouses_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_rooftopPTHouses_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_rooftopPTHouses_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_rooftopPTHousesDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_rooftopPTHouses_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_rooftopPTHousesDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdPT_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_rooftopPTHouses_pct.isVisible() 
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
  private void _txt_householdHybridHeatpumpDescriptionResidentialArea_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdHybridHeatpumpResidentialArea.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdHybridHeatpumpDescriptionResidentialArea;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdHybridHeatPump_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdHybridHeatpumpResidentialArea.isVisible() 
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
  private void _t_householdElectricHeatPumpResidentialArea_pct1_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdHybridHeatpumpResidentialArea.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdHybridHeatpumpResidentialArea.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_householdElectricHeatPumpResidentialArea_pct1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_heatingSliders_residential_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_heatingSliders_residential;
  protected ShapeRectangle rect_districtHeatingFunctions;
  protected ShapeText txt_districtheatingFunctionsDescription;
  protected ShapeRectangle rect_heatingProductionFunctions;
  protected ShapeText txt_heatingProductionFunctionsDescription;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    sl_districtHeatingHouseholds_pct = new ShapeSlider(
tabHeating.this, true, 265.0, 310.0,
			100.0, 30.0,
            false, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_districtHeatingHouseholds_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_districtHeatingHouseholds_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_districtHeatingHouseholds_pct, 0 ), getMax() ) );
      }
    };
    sl_gasBurnerHouseholds_pct = new ShapeSlider(
tabHeating.this, true, 265.0, 235.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_gasBurnerHouseholds_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_gasBurnerHouseholds_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_gasBurnerHouseholds_pct, 0 ), getMax() ) );
      }
    };
    sl_hybridHeatPumpHouseholds_pct = new ShapeSlider(
tabHeating.this, true, 265.0, 260.0,
			100.0, 30.0,
            false, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_hybridHeatPumpHouseholds_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_hybridHeatPumpHouseholds_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_hybridHeatPumpHouseholds_pct, 0 ), getMax() ) );
      }
    };
    sl_electricHeatPumpHouseholds_pct = new ShapeSlider(
tabHeating.this, true, 265.0, 285.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_electricHeatPumpHouseholds_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_electricHeatPumpHouseholds_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_electricHeatPumpHouseholds_pct, 0 ), getMax() ) );
      }
    };
    sl_heatDemandReductionHouseholds_pct = new ShapeSlider(
tabHeating.this, true, 265.0, 200.0,
			100.0, 30.0,
            true, false,
            -50
            , 50
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_heatDemandReductionHouseholds_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_heatDemandReductionHouseholds_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_heatDemandReductionHouseholds_pct, 0 ), getMax() ) );
      }
    };
    sl_heatDemandReductionCompanies_pct = new ShapeSlider(
tabHeating.this, true, 265.0, 35.0,
			100.0, 30.0,
            true, false,
            -50
            , 50
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_heatDemandReductionCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_heatDemandReductionCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_heatDemandReductionCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_districtHeatingCompanies_pct = new ShapeSlider(
tabHeating.this, true, 265.0, 145.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_districtHeatingCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_districtHeatingCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_districtHeatingCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_gasBurnerCompanies_pct = new ShapeSlider(
tabHeating.this, true, 265.0, 70.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_gasBurnerCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_gasBurnerCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_gasBurnerCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_hybridHeatPumpCompanies_pct = new ShapeSlider(
tabHeating.this, true, 265.0, 95.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_hybridHeatPumpCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_hybridHeatPumpCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_hybridHeatPumpCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_electricHeatPumpCompanies_pct = new ShapeSlider(
tabHeating.this, true, 265.0, 120.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_electricHeatPumpCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_electricHeatPumpCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_electricHeatPumpCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct = new ShapeSlider(
tabHeating.this, true, 255.0, 50.0,
			100.0, 30.0,
            true, false,
            -50
            , 50
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct = new ShapeSlider(
tabHeating.this, true, 255.0, 160.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct = new ShapeSlider(
tabHeating.this, true, 255.0, 85.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct = new ShapeSlider(
tabHeating.this, true, 255.0, 110.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct = new ShapeSlider(
tabHeating.this, true, 255.0, 135.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_heatDemandSlidersCompaniesEBoiler_pct = new ShapeSlider(
tabHeating.this, true, 255.0, 185.0,
			100.0, 30.0,
            false, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_heatDemandSlidersCompaniesEBoiler_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_heatDemandSlidersCompaniesEBoiler_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_heatDemandSlidersCompaniesEBoiler_pct, 0 ), getMax() ) );
      }
    };
    sl_heatingTypeSlidersCompaniesCustom_pct = new ShapeSlider(
tabHeating.this, true, 255.0, 220.0,
			100.0, 30.0,
            false, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_heatingTypeSlidersCompaniesCustom_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_heatingTypeSlidersCompaniesCustom_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_heatingTypeSlidersCompaniesCustom_pct, 0 ), getMax() ) );
      }
    };
    sl_householdGasBurnerResidentialArea_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 50.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdGasBurnerResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdGasBurnerResidentialArea_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdGasBurnerResidentialArea_pct, 0 ), getMax() ) );
      }
    };
    sl_householdElectricHeatPumpResidentialArea_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 100.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdElectricHeatPumpResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdElectricHeatPumpResidentialArea_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdElectricHeatPumpResidentialArea_pct, 0 ), getMax() ) );
      }
    };
    sl_householdHeatDemandReductionResidentialArea_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 245.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdHeatDemandReductionResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdHeatDemandReductionResidentialArea_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdHeatDemandReductionResidentialArea_pct, 0 ), getMax() ) );
      }
    };
    sl_householdAircoResidentialArea_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 216.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 5
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdAircoResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdAircoResidentialArea_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdAircoResidentialArea_pct, 0 ), getMax() ) );
      }
    };
    cb_householdHTDistrictHeatingResidentialArea = new ShapeCheckBox(
tabHeating.this,true,20.0, 130.0,
		135.0, 30.0,
            black, true,
            _cb_householdHTDistrictHeatingResidentialArea_Font,
			"HT-Warmtenet" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_householdHTDistrictHeatingResidentialArea, 0, value );
      }
    };
    cb_householdLTDistrictHeatingResidentialArea = new ShapeCheckBox(
tabHeating.this,true,20.0, 165.0,
		185.0, 30.0,
            black, true,
            _cb_householdLTDistrictHeatingResidentialArea_Font,
			"LT-Warmtenet" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_householdLTDistrictHeatingResidentialArea, 0, value );
      }
    };
    sl_rooftopPTHouses_pct = new ShapeSlider(
tabHeating.this, true, 260.0, 294.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_rooftopPTHouses_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_rooftopPTHouses_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_rooftopPTHouses_pct, 0 ), getMax() ) );
      }
    };
    sl_householdHybridHeatpumpResidentialArea = new ShapeSlider(
tabHeating.this, true, 260.0, 75.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdHybridHeatpumpResidentialArea_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdHybridHeatpumpResidentialArea, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdHybridHeatpumpResidentialArea, 0 ), getMax() ) );
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
    rect_heatDemandSliders = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, mistyRose,
			370.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_gasBurnerHouseholdsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, 240.0, 0.0, 0.0,
        black,"HR ketel aardgas",
        _t_gasBurnerHouseholdsDescription_Font, ALIGNMENT_LEFT );
    t_hybridHeatPumpHouseholdsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, 265.0, 0.0, 0.0,
        black,"Hybride warmtepomp",
        _t_hybridHeatPumpHouseholdsDescription_Font, ALIGNMENT_LEFT );
    t_hybridHeatPumpHouseholdsDescription.setVisible( false );
    t_electricHeatPumpHouseholdsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, 290.0, 0.0, 0.0,
        black,"Elek. warmtepomp",
        _t_electricHeatPumpHouseholdsDescription_Font, ALIGNMENT_LEFT );
    t_districtHeatingHouseholdsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, 315.0, 0.0, 0.0,
        black,"Warmtenet",
        _t_districtHeatingHouseholdsDescription_Font, ALIGNMENT_LEFT );
    t_districtHeatingHouseholdsDescription.setVisible( false );
    t_electricHeatPumpHouseholds_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 290.0, 0.0, 0.0,
        black,"#",
        _t_electricHeatPumpHouseholds_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_electricHeatPumpHouseholds_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gasBurnerHouseholds_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 240.0, 0.0, 0.0,
        black,"#",
        _t_gasBurnerHouseholds_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_gasBurnerHouseholds_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_districtHeatingHouseholds_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 315.0, 0.0, 0.0,
        black,"#",
        _t_districtHeatingHouseholds_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_districtHeatingHouseholds_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_districtHeatingHouseholds_pct.setVisible( false );
    t_hybridHeatPumpHouseholds_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 265.0, 0.0, 0.0,
        black,"#",
        _t_hybridHeatPumpHouseholds_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_hybridHeatPumpHouseholds_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_hybridHeatPumpHouseholds_pct.setVisible( false );
    t_heatDemandReductionHouseholds_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 205.0, 0.0, 0.0,
        black,"#",
        _t_heatDemandReductionHouseholds_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_heatDemandReductionHouseholds_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_heatDemandReductionHouseholdsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,30.0, 205.0, 0.0, 0.0,
        black,"Besparing warmte",
        _t_heatDemandReductionHouseholdsDescription_Font, ALIGNMENT_LEFT );
    t_householdsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 180.0, 0.0, 0.0,
        black,"Huishoudens",
        _t_householdsDescription_Font, ALIGNMENT_LEFT );
    t_heatDemandReductionCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 40.0, 0.0, 0.0,
        black,"Besparing warmte",
        _t_heatDemandReductionCompaniesDescription_Font, ALIGNMENT_LEFT );
    t_heatDemandReductionCompanies_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 40.0, 0.0, 0.0,
        black,"#",
        _t_heatDemandReductionCompanies_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_heatDemandReductionCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gasBurnerCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 75.0, 0.0, 0.0,
        black,"HR ketel aardgas",
        _t_gasBurnerCompaniesDescription_Font, ALIGNMENT_LEFT );
    t_hybridHeatPumpCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 100.0, 0.0, 0.0,
        black,"Hybride warmtepomp",
        _t_hybridHeatPumpCompaniesDescription_Font, ALIGNMENT_LEFT );
    t_hybridHeatPumpCompaniesDescription.setVisible( false );
    t_electricHeatPumpCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 125.0, 0.0, 0.0,
        black,"Elek. warmtepomp",
        _t_electricHeatPumpCompaniesDescription_Font, ALIGNMENT_LEFT );
    t_districtHeatingCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 150.0, 0.0, 0.0,
        black,"Warmtenet",
        _t_districtHeatingCompaniesDescription_Font, ALIGNMENT_LEFT );
    t_districtHeatingCompaniesDescription.setVisible( false );
    t_electricHeatPumpCompanies_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 125.0, 0.0, 0.0,
        black,"#",
        _t_electricHeatPumpCompanies_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_electricHeatPumpCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gasBurnerCompanies_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 75.0, 0.0, 0.0,
        black,"#",
        _t_gasBurnerCompanies_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_gasBurnerCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_districtHeatingCompanies_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 150.0, 0.0, 0.0,
        black,"#",
        _t_districtHeatingCompanies_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_districtHeatingCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_districtHeatingCompanies_pct.setVisible( false );
    t_hybridHeatPumpCompanies_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 100.0, 0.0, 0.0,
        black,"#",
        _t_hybridHeatPumpCompanies_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_hybridHeatPumpCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_hybridHeatPumpCompanies_pct.setVisible( false );
    t_companiesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 15.0, 0.0, 0.0,
        black,"Bedrijven",
        _t_companiesDescription_Font, ALIGNMENT_LEFT );
    i_companyReduction = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 170.0, 40.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyReduction, 0, clickx, clicky );
      }
    };
    i_companyGasBoiler = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 170.0, 75.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyGasBoiler, 0, clickx, clicky );
      }
    };
    i_companyElectricHeatpump = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 170.0, 125.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyElectricHeatpump, 0, clickx, clicky );
      }
    };
    i_companyHybridHeatpump = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 170.0, 100.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyHybridHeatpump, 0, clickx, clicky );
      }
    };
    i_companyHeatGrid = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 170.0, 150.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyHeatGrid, 0, clickx, clicky );
      }
    };
    i_householdElectricHeatpump = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 170.0, 290.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdElectricHeatpump, 0, clickx, clicky );
      }
    };
    i_householdReduction = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 170.0, 205.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdReduction, 0, clickx, clicky );
      }
    };
    i_householdGasBoiler = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 170.0, 240.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdGasBoiler, 0, clickx, clicky );
      }
    };
    i_householdHeatGrid = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 170.0, 315.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdHeatGrid, 0, clickx, clicky );
      }
    };
    i_householdHybridHeatpump = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 170.0, 265.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdHybridHeatpump, 0, clickx, clicky );
      }
    };
    rect_heatDemandSliders1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, mistyRose,
			370.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_heatDemandReductionCompaniesDescription1 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 55.0, 0.0, 0.0,
        black,"Besparing warmte",
        _t_heatDemandReductionCompaniesDescription1_Font, ALIGNMENT_LEFT );
    t_heatDemandReductionCompanies_pct1 = new ShapeText(
        SHAPE_DRAW_2D, true,225.0, 55.0, 0.0, 0.0,
        black,"#",
        _t_heatDemandReductionCompanies_pct1_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_heatDemandReductionCompanies_pct1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gasBurnerCompaniesDescription1 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 90.0, 0.0, 0.0,
        black,"HR ketel aardgas",
        _t_gasBurnerCompaniesDescription1_Font, ALIGNMENT_LEFT );
    t_hybridHeatPumpCompaniesDescription1 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 115.0, 0.0, 0.0,
        black,"Hybride warmtepomp",
        _t_hybridHeatPumpCompaniesDescription1_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_hybridHeatPumpCompaniesDescription1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_electricHeatPumpCompaniesDescription1 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 140.0, 0.0, 0.0,
        black,"Elek. warmtepomp",
        _t_electricHeatPumpCompaniesDescription1_Font, ALIGNMENT_LEFT );
    t_districtHeatingCompaniesDescription1 = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 165.0, 0.0, 0.0,
        black,"Warmtenet",
        _t_districtHeatingCompaniesDescription1_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_districtHeatingCompaniesDescription1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_electricHeatPumpCompanies_pct1 = new ShapeText(
        SHAPE_DRAW_2D, true,225.0, 140.0, 0.0, 0.0,
        black,"#",
        _t_electricHeatPumpCompanies_pct1_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_electricHeatPumpCompanies_pct1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gasBurnerCompanies_pct1 = new ShapeText(
        SHAPE_DRAW_2D, true,225.0, 90.0, 0.0, 0.0,
        black,"#",
        _t_gasBurnerCompanies_pct1_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_gasBurnerCompanies_pct1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_districtHeatingCompanies_pct1 = new ShapeText(
        SHAPE_DRAW_2D, true,225.0, 165.0, 0.0, 0.0,
        black,"#",
        _t_districtHeatingCompanies_pct1_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_districtHeatingCompanies_pct1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_hybridHeatPumpCompanies_pct1 = new ShapeText(
        SHAPE_DRAW_2D, true,225.0, 115.0, 0.0, 0.0,
        black,"#",
        _t_hybridHeatPumpCompanies_pct1_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_hybridHeatPumpCompanies_pct1_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_companiesDescription1 = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, 20.0, 0.0, 0.0,
        black,"Bedrijven",
        _t_companiesDescription1_Font, ALIGNMENT_LEFT );
    t_eBoilerCompanies_pct = new ShapeText(
        SHAPE_DRAW_2D, true,225.0, 190.0, 0.0, 0.0,
        black,"#",
        _t_eBoilerCompanies_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_eBoilerCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_eBoilerCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 190.0, 0.0, 0.0,
        black,"E-boiler",
        _t_eBoilerCompaniesDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_eBoilerCompaniesDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_companyReduction_Company = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 160.0, 55.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyReduction_Company, 0, clickx, clicky );
      }
    };
    i_companyGasBoiler_Company = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 160.0, 90.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyGasBoiler_Company, 0, clickx, clicky );
      }
    };
    i_companyElectricHeatpump_Company = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 160.0, 140.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyElectricHeatpump_Company, 0, clickx, clicky );
      }
    };
    i_companyHybridHeatpump_Company = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 160.0, 115.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyHybridHeatpump_Company_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyHybridHeatpump_Company, 0, clickx, clicky );
      }
    };
    i_companyHeatGrid_Company = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 160.0, 165.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyHeatGrid_Company_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyHeatGrid_Company, 0, clickx, clicky );
      }
    };
    i_companyEBoiler_Company = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 160.0, 190.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyEBoiler_Company_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyEBoiler_Company, 0, clickx, clicky );
      }
    };
    t_customHeatingTypeCompanies_pct = new ShapeText(
        SHAPE_DRAW_2D, true,225.0, 225.0, 0.0, 0.0,
        black,"#",
        _t_customHeatingTypeCompanies_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_customHeatingTypeCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_customHeatingDemandCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 225.0, 0.0, 0.0,
        black,"Custom systeem",
        _txt_customHeatingDemandCompaniesDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_customHeatingDemandCompaniesDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_companyCustomHeatingType_Company = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 160.0, 225.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companyCustomHeatingType_Company_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyCustomHeatingType_Company, 0, clickx, clicky );
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
    t_householdGasBurnerDescriptionResidentialArea = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 55.0, 0.0, 0.0,
        black,"Gas brander",
        _t_householdGasBurnerDescriptionResidentialArea_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdGasBurnerDescriptionResidentialArea_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdElectricHeatPumpDescriptionResidentialArea = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 105.0, 0.0, 0.0,
        black,"Elec. warmtepomp",
        _t_householdElectricHeatPumpDescriptionResidentialArea_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdElectricHeatPumpDescriptionResidentialArea_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdElectricHeatPumpResidentialArea_pct = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 105.0, 0.0, 0.0,
        black,"#",
        _t_householdElectricHeatPumpResidentialArea_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdElectricHeatPumpResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdGasBurnerResidentialArea_pct = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 55.0, 0.0, 0.0,
        black,"#",
        _t_householdGasBurnerResidentialArea_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdGasBurnerResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdHeatDemandReductionResidentialArea_pct = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 250.0, 0.0, 0.0,
        black,"#",
        _t_householdHeatDemandReductionResidentialArea_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdHeatDemandReductionResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdHeatDemandReductionDescriptionResidentialArea = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 250.0, 0.0, 0.0,
        black,"Huizen met betere isolatie",
        _t_householdHeatDemandReductionDescriptionResidentialArea_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdHeatDemandReductionDescriptionResidentialArea_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdHeatingTypeDescriptionResidentialArea = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 20.0, 0.0, 0.0,
        black,"Verwarming en koeling",
        _t_householdHeatingTypeDescriptionResidentialArea_Font, ALIGNMENT_LEFT );
    t_householdAircoDescriptionResidentialArea = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 220.0, 0.0, 0.0,
        black,"Huizen met Airco",
        _t_householdAircoDescriptionResidentialArea_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdAircoDescriptionResidentialArea_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdAircoResidentialArea_pct = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 220.0, 0.0, 0.0,
        black,"#",
        _t_householdAircoResidentialArea_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdAircoResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdGasBurner = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 55.0, 0.0, 0.0,
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
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 105.0, 0.0, 0.0,
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
  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP1_xjal() {
    i_householdHTDistrictHeating = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 220.0, 135.0, 0.0, 0.0,
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
		tabHeating.this, SHAPE_DRAW_2D3D, true, 220.0, 170.0, 0.0, 0.0,
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
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 220.0, 0.0, 0.0,
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
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 250.0, 0.0, 0.0,
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
    t_rooftopPTHouses_pct = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 299.0, 0.0, 0.0,
        black,"#",
        _t_rooftopPTHouses_pct_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_rooftopPTHouses_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_rooftopPTHousesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 300.0, 0.0, 0.0,
        black,"Huizen met PT",
        _txt_rooftopPTHousesDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_rooftopPTHousesDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdPT = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 298.0, 0.0, 0.0,
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
    txt_householdHybridHeatpumpDescriptionResidentialArea = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 80.0, 0.0, 0.0,
        black,"Hybride warmtepomp",
        _txt_householdHybridHeatpumpDescriptionResidentialArea_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdHybridHeatpumpDescriptionResidentialArea_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdHybridHeatPump = new ShapeImage(
		tabHeating.this, SHAPE_DRAW_2D3D, true, 180.0, 80.0, 0.0, 0.0,
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
    t_householdElectricHeatPumpResidentialArea_pct1 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 80.0, 0.0, 0.0,
        black,"#",
        _t_householdElectricHeatPumpResidentialArea_pct1_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdElectricHeatPumpResidentialArea_pct1_SetDynamicParams_xjal( this );
	
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
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_heatingSliders_default = new ShapeGroup( tabHeating.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , rect_heatDemandSliders
	     , t_gasBurnerHouseholdsDescription
	     , t_hybridHeatPumpHouseholdsDescription
	     , t_electricHeatPumpHouseholdsDescription
	     , t_districtHeatingHouseholdsDescription
	     , t_electricHeatPumpHouseholds_pct
	     , t_gasBurnerHouseholds_pct
	     , t_districtHeatingHouseholds_pct
	     , t_hybridHeatPumpHouseholds_pct
	     , sl_districtHeatingHouseholds_pct
	     , sl_gasBurnerHouseholds_pct
	     , sl_hybridHeatPumpHouseholds_pct
	     , sl_electricHeatPumpHouseholds_pct
	     , sl_heatDemandReductionHouseholds_pct
	     , t_heatDemandReductionHouseholds_pct
	     , t_heatDemandReductionHouseholdsDescription
	     , t_householdsDescription
	     , sl_heatDemandReductionCompanies_pct
	     , t_heatDemandReductionCompaniesDescription
	     , t_heatDemandReductionCompanies_pct
	     , t_gasBurnerCompaniesDescription
	     , t_hybridHeatPumpCompaniesDescription
	     , t_electricHeatPumpCompaniesDescription
	     , t_districtHeatingCompaniesDescription
	     , t_electricHeatPumpCompanies_pct
	     , t_gasBurnerCompanies_pct
	     , t_districtHeatingCompanies_pct
	     , t_hybridHeatPumpCompanies_pct
	     , sl_districtHeatingCompanies_pct
	     , sl_gasBurnerCompanies_pct
	     , sl_hybridHeatPumpCompanies_pct
	     , sl_electricHeatPumpCompanies_pct
	     , t_companiesDescription
	     , i_companyReduction
	     , i_companyGasBoiler
	     , i_companyElectricHeatpump
	     , i_companyHybridHeatpump
	     , i_companyHeatGrid
	     , i_householdElectricHeatpump
	     , i_householdReduction
	     , i_householdGasBoiler
	     , i_householdHeatGrid
	     , i_householdHybridHeatpump );
    }
    gr_heatingSliders_default.setVisible( false );
    {
    gr_heatingSliders_businesspark = new ShapeGroup( tabHeating.this, SHAPE_DRAW_2D3D, true, 800.0, 0.0, 0.0, 0.0
	
	     , rect_heatDemandSliders1
	     , sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct
	     , t_heatDemandReductionCompaniesDescription1
	     , t_heatDemandReductionCompanies_pct1
	     , t_gasBurnerCompaniesDescription1
	     , t_hybridHeatPumpCompaniesDescription1
	     , t_electricHeatPumpCompaniesDescription1
	     , t_districtHeatingCompaniesDescription1
	     , t_electricHeatPumpCompanies_pct1
	     , t_gasBurnerCompanies_pct1
	     , t_districtHeatingCompanies_pct1
	     , t_hybridHeatPumpCompanies_pct1
	     , sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct
	     , sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct
	     , sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct
	     , sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct
	     , t_companiesDescription1
	     , t_eBoilerCompanies_pct
	     , sl_heatDemandSlidersCompaniesEBoiler_pct
	     , t_eBoilerCompaniesDescription
	     , i_companyReduction_Company
	     , i_companyGasBoiler_Company
	     , i_companyElectricHeatpump_Company
	     , i_companyHybridHeatpump_Company
	     , i_companyHeatGrid_Company
	     , i_companyEBoiler_Company
	     , t_customHeatingTypeCompanies_pct
	     , sl_heatingTypeSlidersCompaniesCustom_pct
	     , txt_customHeatingDemandCompaniesDescription
	     , i_companyCustomHeatingType_Company ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_heatingSliders_businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_heatingSliders_businesspark.setVisible( false );
    {
    gr_ptSlidersHouses = new ShapeGroup( tabHeating.this, SHAPE_DRAW_2D3D, true, 200.0, 320.0, 0.0, 0.0
	 );
    }
    {
    gr_heatingSliders_residential = new ShapeGroup( tabHeating.this, SHAPE_DRAW_2D3D, true, 400.0, 0.0, 0.0, 0.0
	
	     , rect_heatDeandSlidersResidentialArea
	     , t_householdGasBurnerDescriptionResidentialArea
	     , t_householdElectricHeatPumpDescriptionResidentialArea
	     , t_householdElectricHeatPumpResidentialArea_pct
	     , t_householdGasBurnerResidentialArea_pct
	     , sl_householdGasBurnerResidentialArea_pct
	     , sl_householdElectricHeatPumpResidentialArea_pct
	     , sl_householdHeatDemandReductionResidentialArea_pct
	     , t_householdHeatDemandReductionResidentialArea_pct
	     , t_householdHeatDemandReductionDescriptionResidentialArea
	     , t_householdHeatingTypeDescriptionResidentialArea
	     , sl_householdAircoResidentialArea_pct
	     , t_householdAircoDescriptionResidentialArea
	     , t_householdAircoResidentialArea_pct
	     , cb_householdHTDistrictHeatingResidentialArea
	     , cb_householdLTDistrictHeatingResidentialArea
	     , i_householdGasBurner
	     , i_householdHeatPump
	     , i_householdHTDistrictHeating
	     , i_householdLTDistrictHeating
	     , i_householdAirconditioning
	     , i_householdAdditionalInsulation
	     , gr_ptSlidersHouses
	     , t_rooftopPTHouses_pct
	     , sl_rooftopPTHouses_pct
	     , txt_rooftopPTHousesDescription
	     , i_householdPT
	     , txt_householdHybridHeatpumpDescriptionResidentialArea
	     , sl_householdHybridHeatpumpResidentialArea
	     , i_householdHybridHeatPump
	     , t_householdElectricHeatPumpResidentialArea_pct1 ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_heatingSliders_residential_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_heatingSliders_residential.setVisible( false );
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
    sl_districtHeatingHouseholds_pct.setValueToDefault();
    sl_gasBurnerHouseholds_pct.setValueToDefault();
    sl_hybridHeatPumpHouseholds_pct.setValueToDefault();
    sl_electricHeatPumpHouseholds_pct.setValueToDefault();
    sl_heatDemandReductionHouseholds_pct.setValueToDefault();
    sl_heatDemandReductionCompanies_pct.setValueToDefault();
    sl_districtHeatingCompanies_pct.setValueToDefault();
    sl_gasBurnerCompanies_pct.setValueToDefault();
    sl_hybridHeatPumpCompanies_pct.setValueToDefault();
    sl_electricHeatPumpCompanies_pct.setValueToDefault();
    sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct.setValueToDefault();
    sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct.setValueToDefault();
    sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct.setValueToDefault();
    sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct.setValueToDefault();
    sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct.setValueToDefault();
    sl_heatDemandSlidersCompaniesEBoiler_pct.setValueToDefault();
    sl_heatingTypeSlidersCompaniesCustom_pct.setValueToDefault();
    sl_householdGasBurnerResidentialArea_pct.setValueToDefault();
    sl_householdElectricHeatPumpResidentialArea_pct.setValueToDefault();
    sl_householdHeatDemandReductionResidentialArea_pct.setValueToDefault();
    sl_householdAircoResidentialArea_pct.setValueToDefault();
    sl_rooftopPTHouses_pct.setValueToDefault();
    sl_householdHybridHeatpumpResidentialArea.setValueToDefault();
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

// Default Sliders
public ShapeGroup getGroupHeatDemandSliders() {
	return this.gr_heatingSliders_default;
}

public ShapeSlider getSliderHeatDemandReductionCompanies_pct() { 
	return this.sl_heatDemandReductionCompanies_pct;
}

public ShapeSlider getSliderGasBurnerCompanies_pct() { 
	return this.sl_gasBurnerCompanies_pct;
}

public ShapeSlider getSliderElectricHeatPumpCompanies_pct() { 
	return this.sl_electricHeatPumpCompanies_pct;
}

public ShapeSlider getSliderHeatDemandReductionHouseholds_pct() { 
	return this.sl_heatDemandReductionHouseholds_pct;
}

public ShapeSlider getSliderGasBurnerHouseholds_pct() { 
	return this.sl_gasBurnerHouseholds_pct;
}

public ShapeSlider getSliderElectricHeatPumpHouseholds_pct() { 
	return this.sl_electricHeatPumpHouseholds_pct;
}

// Residential Tab Sliders
public ShapeGroup getGroupHeatDemandSlidersResidentialArea() {
	return this.gr_heatingSliders_residential;
}

public ShapeSlider getSliderHeatDemandSlidersResidentialAreaHouseholdsGasBurner_pct() { 
	return this.sl_householdGasBurnerResidentialArea_pct;
}
public ShapeSlider getSl_householdHybridHeatpumpResidentialArea() { 
	return this.sl_householdHybridHeatpumpResidentialArea;
}

public ShapeSlider getSliderHeatDemandSlidersResidentialAreaHouseholdsElectricHeatPump_pct() { 
	return this.sl_householdElectricHeatPumpResidentialArea_pct;
}

// Company Tab Sliders
public ShapeGroup getGroupHeatDemandSlidersCompanies() {
	return this.gr_heatingSliders_businesspark;
}

public ShapeSlider getSliderHeatDemandSlidersCompaniesHeatDemandReductionCompanies_pct() { 
	return this.sl_heatDemandSlidersCompaniesHeatDemandReductionCompanies_pct;
}

public ShapeSlider getSliderHeatDemandSlidersCompaniesGasBurnerCompanies_pct() { 
	return this.sl_heatDemandSlidersCompaniesGasBurnerCompanies_pct;
}

public ShapeSlider getSliderHeatDemandSlidersCompaniesElectricHeatPumpCompanies_pct() { 
	return this.sl_heatDemandSlidersCompaniesElectricHeatPumpCompanies_pct;
}

public ShapeSlider getSl_heatingTypeSlidersCompaniesCustom_pct(){
	return this.sl_heatingTypeSlidersCompaniesCustom_pct;
}

public ShapeSlider getSl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct(){
	return this.sl_heatDemandSlidersCompaniesHybridHeatPumpCompanies_pct;
}

public ShapeSlider getSl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct(){
	return this.sl_heatDemandSlidersCompaniesDistrictHeatingCompanies_pct;
} 
  // End of additional class code

}
