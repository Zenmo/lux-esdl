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

public class tabElectricity extends zerointerfaceloader.tabArea
{
  // Parameters

  public 
double  p_currentPVOnLand_ha;

  /**
   * Returns default value for parameter <code>p_currentPVOnLand_ha</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_currentPVOnLand_ha_DefaultValue_xjal() {
    final tabElectricity self = this;
    return 
0 
;
  }

  public void set_p_currentPVOnLand_ha( double value ) {
    if (value == this.p_currentPVOnLand_ha) {
      return;
    }
    double _oldValue_xjal = this.p_currentPVOnLand_ha;
    this.p_currentPVOnLand_ha = value;
    onChange_p_currentPVOnLand_ha_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_currentPVOnLand_ha.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_currentPVOnLand_ha()</code> method instead.
   */
  protected void onChange_p_currentPVOnLand_ha() {
    onChange_p_currentPVOnLand_ha_xjal( p_currentPVOnLand_ha );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_currentPVOnLand_ha_xjal( double oldValue ) {  
  }


  public 
double  p_currentWindTurbines_MW;

  /**
   * Returns default value for parameter <code>p_currentWindTurbines_MW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_currentWindTurbines_MW_DefaultValue_xjal() {
    final tabElectricity self = this;
    return 
0 
;
  }

  public void set_p_currentWindTurbines_MW( double value ) {
    if (value == this.p_currentWindTurbines_MW) {
      return;
    }
    double _oldValue_xjal = this.p_currentWindTurbines_MW;
    this.p_currentWindTurbines_MW = value;
    onChange_p_currentWindTurbines_MW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_currentWindTurbines_MW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_currentWindTurbines_MW()</code> method instead.
   */
  protected void onChange_p_currentWindTurbines_MW() {
    onChange_p_currentWindTurbines_MW_xjal( p_currentWindTurbines_MW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_currentWindTurbines_MW_xjal( double oldValue ) {  
  }


  public 
double  p_currentTotalGridBatteryCapacity_MWh;

  /**
   * Returns default value for parameter <code>p_currentTotalGridBatteryCapacity_MWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_currentTotalGridBatteryCapacity_MWh_DefaultValue_xjal() {
    final tabElectricity self = this;
    return 
0 
;
  }

  public void set_p_currentTotalGridBatteryCapacity_MWh( double value ) {
    if (value == this.p_currentTotalGridBatteryCapacity_MWh) {
      return;
    }
    double _oldValue_xjal = this.p_currentTotalGridBatteryCapacity_MWh;
    this.p_currentTotalGridBatteryCapacity_MWh = value;
    onChange_p_currentTotalGridBatteryCapacity_MWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_currentTotalGridBatteryCapacity_MWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_currentTotalGridBatteryCapacity_MWh()</code> method instead.
   */
  protected void onChange_p_currentTotalGridBatteryCapacity_MWh() {
    onChange_p_currentTotalGridBatteryCapacity_MWh_xjal( p_currentTotalGridBatteryCapacity_MWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_currentTotalGridBatteryCapacity_MWh_xjal( double oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_currentPVOnLand_ha = _p_currentPVOnLand_ha_DefaultValue_xjal();
    p_currentWindTurbines_MW = _p_currentWindTurbines_MW_DefaultValue_xjal();
    p_currentTotalGridBatteryCapacity_MWh = _p_currentTotalGridBatteryCapacity_MWh_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_currentPVOnLand_ha":
      if ( _callOnChange_xjal ) {
        set_p_currentPVOnLand_ha( ((Number) _value_xjal).doubleValue() );
      } else {
        p_currentPVOnLand_ha = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_currentWindTurbines_MW":
      if ( _callOnChange_xjal ) {
        set_p_currentWindTurbines_MW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_currentWindTurbines_MW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_currentTotalGridBatteryCapacity_MWh":
      if ( _callOnChange_xjal ) {
        set_p_currentTotalGridBatteryCapacity_MWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_currentTotalGridBatteryCapacity_MWh = ((Number) _value_xjal).doubleValue();
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
    case "p_currentPVOnLand_ha": _result_xjal = p_currentPVOnLand_ha; break;
    case "p_currentWindTurbines_MW": _result_xjal = p_currentWindTurbines_MW; break;
    case "p_currentTotalGridBatteryCapacity_MWh": _result_xjal = p_currentTotalGridBatteryCapacity_MWh; break;
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
      list.add( "p_currentPVOnLand_ha" );
      list.add( "p_currentWindTurbines_MW" );
      list.add( "p_currentTotalGridBatteryCapacity_MWh" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }

  // Collection Variables
  public 
ArrayList <
GridConnection > c_electricityTabEASliderGCs = new ArrayList<GridConnection>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( tabElectricity.class );

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
   * Function that changes the electric capacity of the energy asset of the "Solar field". Takes an area size in hectares as a parameter and assumes that 1 MWp of solarpannels fits on 1 ha. The variables for amount of installed PV are updated automatically in the zero_engine. The function also modifies the connection capacity of the energy production site to match the new installed PV Power. Passing a list of gcs sets all gcs to the same input value.
   */
  public void f_setPVOnLand( double hectare, List<GCEnergyProduction> gcListProduction ) { 

// TODO: Change to work for multiple solar fields in one model.
// to do so it should probably first calculate the total installed pv in all solar fields
for ( GCEnergyProduction GCEP : gcListProduction) {
	for(J_EAProduction j_ea : GCEP.c_productionAssets) {
		if (j_ea.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC) {
			if (!GCEP.v_isActive) {
				GCEP.f_setActive(true, zero_Interface.energyModel.p_timeVariables);
			}
			
			double solarFieldPower_kW = (double)roundToInt(hectare * zero_Interface.energyModel.avgc_data.p_avgSolarFieldPower_kWppha);
			j_ea.setCapacityElectric_kW(solarFieldPower_kW, GCEP);
			GCEP.v_liveConnectionMetaData.setCapacities_kW(GCEP.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW(), solarFieldPower_kW, solarFieldPower_kW);
			
			if(hectare == 0){
				GCEP.f_setActive(false, zero_Interface.energyModel.p_timeVariables);
			}
			
			break;
		}
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
  public void f_setPVSystemHouses( List<GCHouse> gcList, double PV_pct ) { 

ArrayList<GCHouse> houses = new ArrayList<GCHouse>(zero_Interface.c_orderedPVSystemsHouses.stream().filter(gcList::contains).toList());
int nbHouses = houses.size();
int nbHousesWithPV = count(houses, x -> x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW));
int nbHousesWithPVGoal = roundToInt(PV_pct / 100.0 * nbHouses);

while ( nbHousesWithPVGoal < nbHousesWithPV ) { // remove excess PV systems
	GCHouse house = findFirst(houses, x -> x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW));	
	J_EA pvAsset = findFirst(house.c_productionAssets, p -> p.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC );
	if (pvAsset != null) {
		pvAsset.removeEnergyAsset();
		houses.remove(house);
		zero_Interface.c_orderedPVSystemsHouses.remove(house);
		zero_Interface.c_orderedPVSystemsHouses.add(0, house);
		nbHousesWithPV --; 
		
		if(house.p_batteryAsset != null ){
			house.p_batteryAsset.removeEnergyAsset();
			house.f_removeExternalAssetManagement(I_BatteryManagement.class);
		}
	}
	else {
		traceln(" cant find PV asset in house that should have PV asset in f_setPVHouses (Interface)");
	}
}

while ( nbHousesWithPVGoal > nbHousesWithPV ) {
	GCHouse house = findFirst(houses, x -> x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW) == false);
	if (house == null){
		traceln("No gridconnection without PV panels found! Current PVsystems count: %s", nbHousesWithPV);
		break;
	}
	else {
		String assetName = "Rooftop PV";
		double installedPVCapacity_kW = house.v_liveAssetsMetaData.PVPotential_kW;
		
		//Compensate for pt if it is present
		if(house.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.ptProductionHeat_kW)){
			installedPVCapacity_kW = max(0, installedPVCapacity_kW-zero_Interface.energyModel.avgc_data.p_avgPTPanelSize_m2*zero_Interface.energyModel.avgc_data.p_avgPVPower_kWpm2); //For now just 1 panel
		}
		J_ProfilePointer profilePointer = f_getPVTProfilePointer(house.v_liveAssetsMetaData.PVOrientation, house.p_gridConnectionID);
		J_EAProduction productionAsset = new J_EAProduction ( house, OL_EnergyAssetType.PHOTOVOLTAIC, assetName, OL_EnergyCarriers.ELECTRICITY, installedPVCapacity_kW, zero_Interface.energyModel.p_timeParameters, profilePointer );
		houses.remove(house);
		zero_Interface.c_orderedPVSystemsHouses.remove(house);
		zero_Interface.c_orderedPVSystemsHouses.add(0, house);
		nbHousesWithPV ++;	
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  /**
   * Function that changes the electric capacity of the energy asset of the "Wind Farm". Takes an amount of MW as a parameter. The variables for amount of installed Wind are updated automatically in the zero_engine. The function also modifies the connection capacity of the energy production site to match the new installed Wind Power. Passing a list of gcs sets all gcs to the same input value.
   */
  public void f_setWindTurbines( double AllocatedWindPower_MW, List<GCEnergyProduction> gcListProduction ) { 

// TODO: Change to work for multiple wind farms in one model.
// to do so it should probably first calculate the total installed wind power in all wind farms

for ( GCEnergyProduction GCEP : gcListProduction) {
	for(J_EAProduction j_ea : GCEP.c_productionAssets) {
		if (j_ea.getEAType() == OL_EnergyAssetType.WINDMILL) {
			if (!GCEP.v_isActive) {
				GCEP.f_setActive(true, zero_Interface.energyModel.p_timeVariables);
			}
			double setCapacity_kW = roundToInt(1000*AllocatedWindPower_MW);
			j_ea.setCapacityElectric_kW(setCapacity_kW, GCEP);
			GCEP.v_liveConnectionMetaData.setCapacities_kW(GCEP.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW(), setCapacity_kW, setCapacity_kW);
			
			if(AllocatedWindPower_MW == 0){
				GCEP.f_setActive(false, zero_Interface.energyModel.p_timeVariables);
			}
			break;
		}
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  /**
   * Function that reduces the electricity demand of all consumption assets. Takes as an argument a percentage to reduce by compared to the default value of the consumption assets.
   */
  public void f_setDemandReduction( List<GridConnection> gcList, double demandReduction_pct ) { 

double scalingFactor = 1 - demandReduction_pct/100;

for (GridConnection gc : gcList) {
	// Set Profile Assets
	for (J_EAProfile j_ea : gc.c_profileAssets) {
		if(j_ea.getAssetFlowCategory() == OL_AssetFlowCategories.fixedConsumptionElectric_kW){
			j_ea.setProfileScaling_fr( scalingFactor );
		}
	}
}

// Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  public void f_getCurrentPVOnLandAndWindturbineValues(  ) { 

p_currentPVOnLand_ha = 0;
p_currentWindTurbines_MW = 0;
for(GCEnergyProduction GCProd : uI_Tabs.f_getAllSliderGridConnections_production()){
	if(!c_electricityTabEASliderGCs.contains(GCProd) && GCProd.v_isActive){
		for(J_EAProduction ea : GCProd.c_productionAssets){
			if(ea.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC){
				p_currentPVOnLand_ha += ea.getCapacityElectric_kW()/zero_Interface.energyModel.avgc_data.p_avgSolarFieldPower_kWppha;
			}
			else if(ea.getEAType() == OL_EnergyAssetType.WINDMILL){
				p_currentWindTurbines_MW += ea.getCapacityElectric_kW()/1000;
			}
		}
	}
} 
  }

  /**
   * Calculates the amount of installed PV compared to the total potential based on roof surface area. Assumes that 50% of the roof surface is available for PV. If a GridConnection already has more than this installed it takes the installed capacity instead.
   */
  public 
Pair<Double, Double> 
 f_getPVSystemPercentage( List<GridConnection> gcList ) { 

double installedPV_kWp = 0.0;
double PVPotential_kWp = 0.0;
double averageEffectivePV_kWppm2 = zero_Interface.energyModel.avgc_data.p_avgRatioRoofPotentialPV * zero_Interface.energyModel.avgc_data.p_avgPVPower_kWpm2;

for (GridConnection gc : gcList ) {
	double gcInstalledPV_kWp = 0.0;
	if ( gc.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW) ) {
		for ( J_EAProduction j_ea : gc.c_productionAssets ) {
			if ( j_ea.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC ) {
				gcInstalledPV_kWp += j_ea.getCapacityElectric_kW();
			}
		}
	}
	installedPV_kWp += gcInstalledPV_kWp;
	PVPotential_kWp += max( gcInstalledPV_kWp, max(0.1, gc.p_roofSurfaceArea_m2 * averageEffectivePV_kWppm2) );
}

return new Pair(installedPV_kWp, PVPotential_kWp); 
  }

  /**
   * Adds or removes photovoltaic production assets to GridConnections. Takes as arguments a list of Gridconnections and a target percentage. It runs untill that list of GCs has that percentage of PV installed, compared to the total potential PV. If a new asset is created it determines its electric capacity by the total roof area of all the buildings connected to the GC. The function also updates the PV slider in the company UI if the GC is a company. The variables in the engine that keep track of the amount of installed PV are updated automatically.
   */
  public void f_setPVSystemCompanies( List<GCUtility> gcList, double target_pct, ShapeSlider slider ) { 

List<GCUtility> activeGCs = new ArrayList<GCUtility>(zero_Interface.c_orderedPVSystemsCompanies.stream().filter(x -> x.v_isActive).filter(gcList::contains).toList());
Pair<Double, Double> pair = f_getPVSystemPercentage( new ArrayList<GridConnection>(activeGCs) );
double remaining_kWp = target_pct / 100 * pair.getSecond() - pair.getFirst();
double averageEffectivePV_kWppm2 = zero_Interface.energyModel.avgc_data.p_avgRatioRoofPotentialPV * zero_Interface.energyModel.avgc_data.p_avgPVPower_kWpm2;
if ( remaining_kWp > 0 ) {
	// add more PV
	for ( GCUtility company : new ArrayList<GCUtility>(activeGCs) ) {
		double remainingPotential_kWp = min( remaining_kWp, company.p_roofSurfaceArea_m2 * averageEffectivePV_kWppm2 - company.v_liveAssetsMetaData.totalInstalledPVPower_kW );
		
		if ( remainingPotential_kWp > 0 ) {
			remaining_kWp -= remainingPotential_kWp;
			f_addPVSystem( company, remainingPotential_kWp );
		}
		
		if ( remaining_kWp <= 0 ) {
			// Update variable to change to custom scenario
			if(!zero_Interface.b_runningMainInterfaceScenarios){
				zero_Interface.f_setScenarioToCustom();
			}
			zero_Interface.f_resetSettings();		
			return;
		}
	}
}
else {
	// remove pv
	for ( GCUtility company : new ArrayList<GCUtility>(activeGCs) ) {
		if ( company.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW) ) {
			// find companyUI to check if the company already has PV on model startup			
			remaining_kWp += company.v_liveAssetsMetaData.totalInstalledPVPower_kW;
			f_removePVSystem( company );
			double PVAtStartup_kWp = zero_Interface.c_scenarioMap_Current.get(company.p_uid).getCurrentPV_kW();
			if (PVAtStartup_kWp != 0) {
				f_addPVSystem( company, PVAtStartup_kWp );
				remaining_kWp -= PVAtStartup_kWp;
			}
		}
		if ( remaining_kWp >= 0 ) {
			// removed slightly too much pv
			f_addPVSystem( company, remaining_kWp );
			
			// Update variable to change to custom scenario
			if(!zero_Interface.b_runningMainInterfaceScenarios){
				zero_Interface.f_setScenarioToCustom();
			}
			
			zero_Interface.f_resetSettings();			
			return;
		}
	}
	// All companies are at the starting PV amount. Set slider to corresponding value.
	pair = f_getPVSystemPercentage( new ArrayList<GridConnection>( activeGCs ) );
	int installed_pct = roundToInt(100.0 * pair.getFirst() / pair.getSecond());	
	slider.setValue(installed_pct, false);
}

// Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  /**
   * Takes as an argument a GridConnection and a capacity. If the GC already has a solar panel, it adds the capacity to the existing one. Otherwise it creates a new energy asset. If the GridConnection is a GCUtility it also updates the companyUI if it exists.
   */
  public void f_addPVSystem( GridConnection gc, double capacity_kWp ) { 

J_EAProduction pvAsset = findFirst(gc.c_productionAssets, p -> p.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC);
if (pvAsset != null) {
	capacity_kWp += pvAsset.getCapacityElectric_kW();
	pvAsset.setCapacityElectric_kW( capacity_kWp, gc );
}
else {
	// Create a new asset
	OL_EnergyAssetType assetType = OL_EnergyAssetType.PHOTOVOLTAIC;
	String assetName = "Rooftop PV";
	J_ProfilePointer profilePointer = f_getPVTProfilePointer(gc.v_liveAssetsMetaData.PVOrientation, gc.p_gridConnectionID);
	J_EAProduction productionAsset = new J_EAProduction ( gc, assetType, assetName, OL_EnergyCarriers.ELECTRICITY, capacity_kWp, zero_Interface.energyModel.p_timeParameters, profilePointer );
}

// Update the ordered collection
if ( gc instanceof GCHouse ) {
	zero_Interface.c_orderedPVSystemsHouses.remove(gc);
	zero_Interface.c_orderedPVSystemsHouses.add(0, (GCHouse)gc);	
}
else if ( gc instanceof GCUtility ) {
	zero_Interface.c_orderedPVSystemsCompanies.remove(gc);
	zero_Interface.c_orderedPVSystemsCompanies.add(0, (GCUtility)gc);
}
else {
	throw new RuntimeException("Unknown GridConnection type passed to f_addPVSystem.");
} 
  }

  public void f_removePVSystem( GridConnection gc ) { 

J_EAProduction pvAsset = findFirst(gc.c_productionAssets, p -> p.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC);
if ( pvAsset != null ) {
	pvAsset.removeEnergyAsset();

	if ( gc instanceof GCHouse ) {
		zero_Interface.c_orderedPVSystemsHouses.remove(gc);
		zero_Interface.c_orderedPVSystemsHouses.add(0, (GCHouse)gc);	
	}
	else if ( gc instanceof GCUtility ) {
		zero_Interface.c_orderedPVSystemsCompanies.remove(gc);
		zero_Interface.c_orderedPVSystemsCompanies.add(0, (GCUtility)gc);
	}
} 
  }

  public void f_setResidentialBatteries( double homeBatteries_pct, List<GCHouse> gcListHouses ) { 

// Setting houseBatteries
double nbHouseBatteries = count(gcListHouses, h -> h.p_batteryAsset != null); //f_getEnergyAssets(), p -> p.energyAssetType == OL_EnergyAssetType.STORAGE_ELECTRIC && p.getParentAgent() instanceof GCHouse);
double nbHousesWithPV = count(gcListHouses, x -> x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW)); //count(energyModel.f_getGridConnections(), p->p instanceof GCHouse);
double nbHousesWithBatteryGoal = roundToInt(nbHousesWithPV * homeBatteries_pct / 100);

if( nbHousesWithPV > 0 ){
	while ( nbHouseBatteries > nbHousesWithBatteryGoal ) {
		GCHouse house = findFirst(gcListHouses, p -> p.p_batteryAsset != null );
		house.p_batteryAsset.removeEnergyAsset();
		house.f_removeExternalAssetManagement(I_BatteryManagement.class);
		nbHouseBatteries--;
	}
	while ( nbHouseBatteries < nbHousesWithBatteryGoal) {
		GCHouse house = findFirst(gcListHouses, p -> p.p_batteryAsset == null && p.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW));
		
		double batteryStorageCapacity_kWh = zero_Interface.energyModel.avgc_data.p_avgRatioHouseBatteryStorageCapacity_v_PVPower*house.v_liveAssetsMetaData.totalInstalledPVPower_kW;
		double batteryCapacity_kW = batteryStorageCapacity_kWh / zero_Interface.energyModel.avgc_data.p_avgRatioBatteryCapacity_v_Power;
		double batteryStateOfCharge = 0.5;

		new J_EAStorageElectric(house, batteryCapacity_kW, batteryStorageCapacity_kWh, batteryStateOfCharge, zero_Interface.energyModel.p_timeParameters );
		house.f_setBatteryManagement(new J_BatteryManagementSelfConsumption( house, zero_Interface.energyModel.p_timeParameters ));
		nbHouseBatteries++;
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  /**
   * Passing a list of gcs sets all gcs to the same input value.
   */
  public void f_setGridBatteries( double storageCapacity_kWh, List<GCGridBattery> gcListGridBatteries ) { 

for ( GCGridBattery battery : gcListGridBatteries) {
	if(battery.p_batteryAsset == null){
		throw new RuntimeException("GCGridBattery found without p_batteryAsset");
	}
	
	J_EAStorageElectric batteryAsset = battery.p_batteryAsset;
	if (!battery.v_isActive) {
		battery.f_setActive(true, zero_Interface.energyModel.p_timeVariables);
	}
	
	
	double capacity_kW = storageCapacity_kWh / zero_Interface.energyModel.avgc_data.p_avgRatioBatteryCapacity_v_Power;
	if(batteryAsset.getCapacityElectric_kW() > 0 && batteryAsset.getStorageCapacity_kWh() > 0){ //If already existing power present: keep relation between power and storage capacity the same.
		capacity_kW = storageCapacity_kWh * ( batteryAsset.getStorageCapacity_kWh() / batteryAsset.getCapacityElectric_kW());
	}
	batteryAsset.setCapacityElectric_kW( capacity_kW );
	batteryAsset.setStorageCapacity_kWh( storageCapacity_kWh, battery );
	battery.v_liveConnectionMetaData.setCapacities_kW(capacity_kW, capacity_kW, capacity_kW);
	
	if(storageCapacity_kWh == 0){
		battery.f_setActive(false, zero_Interface.energyModel.p_timeVariables);
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  public void f_setElectricCooking( List<GCHouse> gcListHouses, double electricCookingGoal_pct ) { 

int nbHousesWithElectricCooking = findAll(gcListHouses, x -> x.p_cookingMethod == OL_HouseholdCookingMethod.ELECTRIC).size();
int nbHousesWithElectricCookingGoal = roundToInt(electricCookingGoal_pct / 100 * gcListHouses.size());


while ( nbHousesWithElectricCooking > nbHousesWithElectricCookingGoal ) { // remove excess cooking systems
	GCHouse house = randomWhere(gcListHouses, x -> x.p_cookingMethod == OL_HouseholdCookingMethod.ELECTRIC);		
	J_EAConsumption cookingAsset = findFirst(house.c_consumptionAssets, p -> p.getEAType() == OL_EnergyAssetType.ELECTRIC_HOB );
	if (cookingAsset != null) {
		double yearlyCookingDemand_kWh = cookingAsset.getBaseConsumption_kWh();
		cookingAsset.removeEnergyAsset();
   		
   		J_ProfilePointer pp = zero_Interface.energyModel.f_findProfile("default_house_cooking_demand_fr");
		new J_EAConsumption(house, OL_EnergyAssetType.GAS_PIT, "default_house_cooking_demand_fr", yearlyCookingDemand_kWh, OL_EnergyCarriers.METHANE, zero_Interface.energyModel.p_timeParameters, pp);
		house.p_cookingMethod = OL_HouseholdCookingMethod.GAS;
		nbHousesWithElectricCooking --; 
	}
	else {
		throw new RuntimeException("Cant find cooking asset in house that should have cooking asset in f_ElectricCooking (tabElectricity)");
	}
}
 
while ( nbHousesWithElectricCooking < nbHousesWithElectricCookingGoal) {
	GCHouse house = randomWhere(gcListHouses, x -> x.p_cookingMethod == OL_HouseholdCookingMethod.GAS);
	if (house == null){
		throw new RuntimeException("No gridconnection without GAS cooking asset found! Current electric cooking count: " + nbHousesWithElectricCooking);
	}
	else {
		J_EAConsumption cookingAsset = findFirst(house.c_consumptionAssets, p -> p.getEAType() == OL_EnergyAssetType.GAS_PIT );
		if (cookingAsset != null) {
			double yearlyCookingDemand_kWh = cookingAsset.getBaseConsumption_kWh();
			cookingAsset.removeEnergyAsset();
			
			J_ProfilePointer pp = zero_Interface.energyModel.f_findProfile("default_house_cooking_demand_fr");
			new J_EAConsumption(house, OL_EnergyAssetType.ELECTRIC_HOB, "default_house_cooking_demand_fr", yearlyCookingDemand_kWh, OL_EnergyCarriers.ELECTRICITY, zero_Interface.energyModel.p_timeParameters, pp);
			house.p_cookingMethod = OL_HouseholdCookingMethod.ELECTRIC;
			nbHousesWithElectricCooking ++; 
		}
		else {
			throw new RuntimeException("Cant find cooking asset in house that should have cooking asset in f_ElectricCooking (tabElectricity)");
		}
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  public void f_setDemandIncrease( List<GridConnection> gcList, double demandReduction_pct ) { 

f_setDemandReduction(gcList, -demandReduction_pct); 
  }

  protected void f_updateSliders_Electricity(  ) { 

if(gr_electricitySliders_default.isVisible()){
	f_updateElectricitySliders_default();
}
else if(gr_electricitySliders_businesspark.isVisible()){
	f_updateElectricitySliders_businesspark();
}
else if(gr_electricitySliders_residential.isVisible()){
	f_updateElectricitySliders_residential();
}
else{
	f_updateElectricitySliders_custom();
} 
  }

  void f_updateElectricitySliders_default(  ) { 

List<GridConnection> allConsumerGridConnections = uI_Tabs.f_getActiveSliderGridConnections_consumption();


//Savings
double totalBaseConsumption_kWh = 0;
double totalSavedConsumption_kWh = 0;
for(GridConnection GC : allConsumerGridConnections){
	if(GC.v_isActive){
		List<J_EAProfile> profileEAs = findAll(GC.c_profileAssets, profile -> profile.getAssetFlowCategory() == OL_AssetFlowCategories.fixedConsumptionElectric_kW);
		for(J_EAProfile profileEA : profileEAs){
			double baseConsumption_kWh = profileEA.getBaseConsumption_kWh();
			totalBaseConsumption_kWh += baseConsumption_kWh;
			totalSavedConsumption_kWh += (1 - profileEA.getProfileScaling_fr()) * baseConsumption_kWh;
		}
	}
}

double electricitySavings_pct = totalBaseConsumption_kWh > 0 ? (totalSavedConsumption_kWh/totalBaseConsumption_kWh * 100) : 0;
sl_electricityDemandReduction_pct.setValue(roundToInt(electricitySavings_pct), false);


//Companies rooftop PV
List<GCUtility> utilityGridConnections = uI_Tabs.f_getActiveSliderGridConnections_utilities();

List<GridConnection> utilityGridConnections_GC = new ArrayList<>(utilityGridConnections);
Pair<Double, Double> pair = f_getPVSystemPercentage( utilityGridConnections_GC );
int PV_pct = roundToInt(100.0 * pair.getFirst() / pair.getSecond());
sl_rooftopPVCompanies_pct.setValue(PV_pct, false);

//Houses rooftop PV
List<GCHouse> houseGridConnections = uI_Tabs.f_getActiveSliderGridConnections_houses();

List<GridConnection> houseGridConnections_GC = new ArrayList<>(utilityGridConnections);
pair = f_getPVSystemPercentage( houseGridConnections_GC );
PV_pct = roundToInt(100.0 * pair.getFirst() / pair.getSecond());
sl_rooftopPVHouses_pct.setValue(PV_pct, false);

//Large scale EA production systems (PV on land And Wind)
f_getCurrentPVOnLandAndWindturbineValues(); // Used for slider minimum: non adjustable GCProductions

double totalPVOnLand_kW = 0; // Of movable slider GC
double totalWind_kW = 0; // Of movable slider GC

for(GridConnection productionGC : c_electricityTabEASliderGCs){
	if(productionGC instanceof GCEnergyProduction && productionGC.v_isActive){
		for(J_EAProduction productionEA : productionGC.c_productionAssets){
			if(productionEA.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC){
				totalPVOnLand_kW += productionEA.getCapacityElectric_kW();
				break;
			}
			else if(productionEA.getEAType() == OL_EnergyAssetType.WINDMILL){
				totalWind_kW += productionEA.getCapacityElectric_kW();
				break;
			}
		}
	}
}
sl_largeScalePV_ha.setRange(0, 1000); // Needed to prevent anylogic range bug
sl_largeScalePV_ha.setValue((totalPVOnLand_kW/zero_Interface.energyModel.avgc_data.p_avgSolarFieldPower_kWppha) + p_currentPVOnLand_ha, false);
sl_largeScaleWind_MW.setRange(0, 1000); // Needed to prevent anylogic range bug
sl_largeScaleWind_MW.setValue((totalWind_kW/1000) + p_currentWindTurbines_MW, false);

//Curtailment
boolean curtailment = true;
for(GridConnection GC : allConsumerGridConnections){
	if(!GC.f_isAssetManagementActive(I_CurtailManagement.class)){
		curtailment = false;
		break;
	}
}
cb_curtailment_default.setSelected(curtailment, false);


//Large scale battery systems
f_getCurrentGridBatterySize(); // Used for slider minimum: non adjustable GCGridBatteries

double totalBatteryStorage_kWh = 0;
for(GridConnection batteryGC : c_electricityTabEASliderGCs){
	if(batteryGC instanceof GCGridBattery && batteryGC.v_isActive){
		totalBatteryStorage_kWh += batteryGC.p_batteryAsset.getStorageCapacity_kWh();
	}
}
sl_collectiveBattery_MWh_default.setRange(0, 1000);
sl_collectiveBattery_MWh_default.setValue((totalBatteryStorage_kWh/1000.0) + p_currentTotalGridBatteryCapacity_MWh, false);
 
  }

  protected void f_updateElectricitySliders_residential(  ) { 

List<GCHouse> houseGridConnections = uI_Tabs.f_getActiveSliderGridConnections_houses();

int nbHouses = houseGridConnections.size();
int nbHousesWithPV = count(houseGridConnections, x -> x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW));
double pv_pct = 100.0 * nbHousesWithPV / nbHouses;
sl_householdPVResidentialArea_pct.setValue(roundToInt(pv_pct), false);

if ( nbHousesWithPV != 0 ) {
	int nbHousesWithHomeBattery = count(houseGridConnections, x -> x.v_liveAssetsMetaData.activeAssetFlows.contains(OL_AssetFlowCategories.pvProductionElectric_kW) && x.p_batteryAsset != null);
	double battery_pct = 100.0 * nbHousesWithHomeBattery / nbHousesWithPV;
	sl_householdBatteriesResidentialArea_pct.setValue(roundToInt(battery_pct), false);
}

//Electric cooking
int nbHousesWithElectricCooking = count(houseGridConnections, x -> x.p_cookingMethod == OL_HouseholdCookingMethod.ELECTRIC);
double cooking_pct = 100.0 * nbHousesWithElectricCooking / nbHouses;
sl_householdElectricCookingResidentialArea_pct.setValue(roundToInt(cooking_pct), false);

//Consumption growth
double totalBaseConsumption_kWh = 0;
double totalSavedConsumption_kWh = 0;
for(GCHouse GC : houseGridConnections){
	if(GC.v_isActive){
		List<J_EAProfile> profileEAs = findAll(GC.c_profileAssets, profile -> profile.getAssetFlowCategory() == OL_AssetFlowCategories.fixedConsumptionElectric_kW);
		for(J_EAProfile profileEA : profileEAs){
			double baseConsumption_kWh = profileEA.getBaseConsumption_kWh();
			totalBaseConsumption_kWh += baseConsumption_kWh;
			totalSavedConsumption_kWh += (1 - profileEA.getProfileScaling_fr()) * baseConsumption_kWh;
		}
	}
}

double electricityDemandIncrease_pct = totalBaseConsumption_kWh > 0 ? ( (- totalSavedConsumption_kWh)/totalBaseConsumption_kWh * 100) : 0;
sl_electricityDemandIncreaseResidentialArea_pct.setValue(roundToInt(electricityDemandIncrease_pct), false);


//Large scale EA production systems (PV on land And Wind)
f_getCurrentPVOnLandAndWindturbineValues(); // Used for slider minimum: non adjustable GCProductions

double totalPVOnLand_kW = 0; // Of movable slider GC
double totalWind_kW = 0; // Of movable slider GC

for(GridConnection productionGC : c_electricityTabEASliderGCs){
	if(productionGC instanceof GCEnergyProduction && productionGC.v_isActive){
		for(J_EAProduction productionEA : productionGC.c_productionAssets){
			if(productionEA.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC){
				totalPVOnLand_kW += productionEA.getCapacityElectric_kW();
				break;
			}
			else if(productionEA.getEAType() == OL_EnergyAssetType.WINDMILL){
				totalWind_kW += productionEA.getCapacityElectric_kW();
				break;
			}
		}
	}
}
sl_largeScalePV_ha_Residential.setRange(0, 1000); // Needed to prevent anylogic range bug
sl_largeScalePV_ha_Residential.setValue((totalPVOnLand_kW/zero_Interface.energyModel.avgc_data.p_avgSolarFieldPower_kWppha) + p_currentPVOnLand_ha, false);
sl_largeScaleWind_MW_Residential.setRange(0, 1000); // Needed to prevent anylogic range bug
sl_largeScaleWind_MW_Residential.setValue((totalWind_kW/1000) + p_currentWindTurbines_MW, false);


//Gridbatteries
List<GCGridBattery> sliderGridBatteryGridConnections = new ArrayList<>();
for(GridConnection sliderGC : c_electricityTabEASliderGCs){
	if(sliderGC.v_isActive && sliderGC instanceof GCGridBattery sliderGridBattery){
		sliderGridBatteryGridConnections.add(sliderGridBattery);
	}
}

double averageNeighbourhoodBatterySize_kWh = 0;
for (GCGridBattery gc : sliderGridBatteryGridConnections) {
	averageNeighbourhoodBatterySize_kWh += gc.p_batteryAsset.getStorageCapacity_kWh()/sliderGridBatteryGridConnections.size();
}
sl_gridBatteriesResidentialArea_kWh.setValue(averageNeighbourhoodBatterySize_kWh, false);
 
  }

  void f_updateElectricitySliders_businesspark(  ) { 

//Get the utility connections
List<GridConnection> utilityGridConnections = new ArrayList<>(uI_Tabs.f_getActiveSliderGridConnections_utilities());


//Savings
double totalBaseConsumption_kWh = 0;
double totalSavedConsumption_kWh = 0;
for(GridConnection GC : utilityGridConnections){
	if(GC.v_isActive){
		List<J_EAProfile> profileEAs = findAll(GC.c_profileAssets, profile -> profile.getAssetFlowCategory() == OL_AssetFlowCategories.fixedConsumptionElectric_kW);
		for(J_EAProfile profileEA : profileEAs){
			double baseConsumption_kWh = profileEA.getBaseConsumption_kWh();
			totalBaseConsumption_kWh += baseConsumption_kWh;
			totalSavedConsumption_kWh += (1 - profileEA.getProfileScaling_fr()) * baseConsumption_kWh;
		}
	}
}

double electricitySavings_pct = totalBaseConsumption_kWh > 0 ? (totalSavedConsumption_kWh/totalBaseConsumption_kWh * 100) : 0;
sl_electricityDemandReduction_pct_Businesspark.setValue(roundToInt(electricitySavings_pct), false);

// Rooftop PV SYSTEMS:
Pair<Double, Double> pair = f_getPVSystemPercentage( utilityGridConnections );
int PV_pct = roundToInt(100.0 * pair.getFirst() / pair.getSecond());
sl_rooftopPVCompanies_pct_Businesspark.setValue(PV_pct, false);

//Large scale EA production systems (PV on land And Wind)
f_getCurrentPVOnLandAndWindturbineValues(); // Used for slider minimum: non adjustable GCProductions

double totalPVOnLand_kW = 0; // Of movable slider GC
double totalWind_kW = 0; // Of movable slider GC

for(GridConnection productionGC : c_electricityTabEASliderGCs){
	if(productionGC instanceof GCEnergyProduction && productionGC.v_isActive){
		for(J_EAProduction productionEA : productionGC.c_productionAssets){
			if(productionEA.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC){
				totalPVOnLand_kW += productionEA.getCapacityElectric_kW();
				break;
			}
			else if(productionEA.getEAType() == OL_EnergyAssetType.WINDMILL){
				totalWind_kW += productionEA.getCapacityElectric_kW();
				break;
			}
		}
	}
}
sl_largeScalePV_ha_Businesspark.setRange(0, 1000); // Needed to prevent anylogic range bug
sl_largeScalePV_ha_Businesspark.setValue((totalPVOnLand_kW/zero_Interface.energyModel.avgc_data.p_avgSolarFieldPower_kWppha) + p_currentPVOnLand_ha, false);
sl_largeScaleWind_MW_Businesspark.setRange(0, 1000); // Needed to prevent anylogic range bug
sl_largeScaleWind_MW_Businesspark.setValue((totalWind_kW/1000) + p_currentWindTurbines_MW, false);

//Curtailment
boolean curtailment = true;
for(GridConnection GC : utilityGridConnections){
	if(!GC.f_isAssetManagementActive(I_CurtailManagement.class)){
		curtailment = false;
		break;
	}
}
cb_curtailment_businesspark.setSelected(curtailment, false);


//Large scale battery systems
f_getCurrentGridBatterySize(); // Used for slider minimum: non adjustable GCGridBatteries

double totalBatteryStorage_kWh = 0;
for(GridConnection batteryGC : c_electricityTabEASliderGCs){
	if(batteryGC instanceof GCGridBattery && batteryGC.v_isActive){
		totalBatteryStorage_kWh += batteryGC.p_batteryAsset.getStorageCapacity_kWh();
	}
}
sl_collectiveBattery_MWh_businesspark.setRange(0, 1000); // Needed to prevent anylogic range bug
sl_collectiveBattery_MWh_businesspark.setValue((totalBatteryStorage_kWh/1000.0) + p_currentTotalGridBatteryCapacity_MWh, false);

 
  }

  protected void f_updateElectricitySliders_custom(  ) { 

//If you have a custom tab, 
//override this function to make it update automatically
traceln("Forgot to override the update custom electricity sliders functionality"); 
  }

  public void f_setCurtailment( boolean activateCurtailment, List<GridConnection> gcList ) { 

for (GridConnection GC : gcList) {
	if(activateCurtailment){
		GC.f_setExternalAssetManagement(new J_CurtailManagementContractCapacity(GC, zero_Interface.energyModel.p_timeParameters));
	}
	else{
		GC.f_removeExternalAssetManagement(I_CurtailManagement.class);
	}
}



//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  protected void f_initializeTab_Electricity( List<GridConnection> electricityTabEASliderGCs ) { 

c_electricityTabEASliderGCs.addAll(electricityTabEASliderGCs);

f_getCurrentPVOnLandAndWindturbineValues();
f_getCurrentGridBatterySize(); 
  }

  public void f_getCurrentGridBatterySize(  ) { 

p_currentTotalGridBatteryCapacity_MWh = 0;
for(GCGridBattery GCBat : uI_Tabs.f_getAllSliderGridConnections_gridBatteries()){
	if(!c_electricityTabEASliderGCs.contains(GCBat) && GCBat.v_isActive){
		p_currentTotalGridBatteryCapacity_MWh += (GCBat.p_batteryAsset.getStorageCapacity_kWh()/1000.0);
	}
} 
  }

  public 
J_ProfilePointer 
 f_getPVTProfilePointer( OL_PVOrientation pvtOrientation, String gridConnectionID ) { 

J_ProfilePointer profilePointer = null;

switch (pvtOrientation){
	case EASTWEST:
		profilePointer = zero_Interface.energyModel.pp_PVProduction15DegEastWest_fr;
		break;
	case SOUTH:
		profilePointer = zero_Interface.energyModel.pp_PVProduction35DegSouth_fr;
		break;
	case CUSTOM:
		profilePointer = zero_Interface.energyModel.f_findProfile("GC: " + gridConnectionID + " custom pv profile");
		if(profilePointer == null){
			throw new RuntimeException("Can't find custom profile pointer for GC with custom orientation.");
		}
		break;
}

return profilePointer; 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_curtailment_default_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_curtailment_businesspark_Font = _cb_curtailment_default_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_trafoReinforcement_Font = _cb_curtailment_default_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_confirmTrafoReinforcement_Font = _cb_curtailment_default_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_resetTrafoReinforcement_Font = _cb_curtailment_default_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_closeTrafoReinforcement_Font = new Font("Dialog", 0, 8 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricityDemandReduction_pct_Font = new Font("Dialog", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricityDemandReductionDescription_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_productionDescription_Font = new Font("Calibri", 1, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_rooftopPVCompanies_pct_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_rooftopPVCompaniesDescription_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_largeScalePV_ha_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_largeScalePVDescription_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_batteryDescription_default_Font = _txt_productionDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_largeScaleWindDescription_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_largeScaleWind_MW_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_rooftopPVHouses_pct_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_rooftopPVHousesDescription_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_collectiveBatteries_default_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_curtailmentDescription_default_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_collectiveBatteryDescription_default_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_ProductionFunctionsDescription_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_demandFunctionsDescription_Font = _txt_ProductionFunctionsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_genericFunctions_Font = new Font("SansSerif", 0, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricityDemandReduction_pct_Businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_electricityDemandReductionDescription_Businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_productionDescription_Businesspark_Font = _txt_productionDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_rooftopPVCompanies_pct_Businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_rooftopPVCompaniesDescription_Businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_largeScalePV_ha_Businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_largeScalePVDescription_Businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_batteryDescription_businesspark_Font = _txt_productionDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_largeScaleWindDescription_Businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_largeScaleWind_MW_Businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_curtailmentDescription_businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_collectiveBatteryDescription_businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_collectiveBatteries_businesspark_Font = _t_electricityDemandReduction_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricityDemandIncreaseResidentialArea_pct_Font = new Font("Dialog", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdPVResidentialArea_pct_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdPVResidentialAreaDescription_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_electricitDemandSlidersResidentialAreaDescription_Font = new Font("Dialog", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdBatteriesResidentialAreaDescription_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdBatteriesResidentialArea_pct_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gridBatteriesResidentialAreaDescription_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_gridBatteriesResidentialArea_kW_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_electricityDemandIncreaseResidentialAreaDescription_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdElectricCookingResidentialAreaDescription_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_householdElectricCookingResidentialArea_pct_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_largeScalePV_ha_Residential_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_largeScalePVDescription_Residential_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_largeScaleWindDescription_Residential_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_largeScaleWind_MW_Residential_Font = _t_electricityDemandIncreaseResidentialArea_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_electricityTabResidential_Collective_Font = _txt_electricitDemandSlidersResidentialAreaDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_addTrafoDescription_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_minTrafoReinforcement_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_maxTrafoReinforcement_Font = _t_minTrafoReinforcement_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_trafoReinforcementValue_Font = _t_minTrafoReinforcement_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_currentTrafoReinforcement_Font = _t_addTrafoDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_titleTrafoReinforcement_Font = new Font("Calibri", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_batteryFunctionsDescription_Font = new Font("Dialog", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_genericFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_electricityDemandSliders = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricityDemandReduction_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricityDemandReductionDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_productionDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_rooftopPVCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_rooftopPVCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_largeScalePV_ha = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_largeScalePVDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_batteryDescription_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_largeScaleWindDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_largeScaleWind_MW = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_rooftopPVHouses_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_rooftopPVHousesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdPV = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_landPV = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyPV = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_electricityReduction = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_landWind = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_collectiveBatteries_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_curtailmentDescription_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_collectiveBatteryDescription_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_curtailment_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_collectiveBatteries_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_electricitySliders_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_PVFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_ProductionFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_demandFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_demandFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_genericFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_electricityDemandSliders_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricityDemandReduction_pct_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_electricityDemandReductionDescription_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_productionDescription_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_rooftopPVCompanies_pct_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_rooftopPVCompaniesDescription_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_largeScalePV_ha_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_largeScalePVDescription_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_batteryDescription_businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_largeScaleWindDescription_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_largeScaleWind_MW_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_landPV_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companyPV_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_electricityReduction_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_landWind_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_curtailmentDescription_businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_curtailment_businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_collectiveBatteries_businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_collectiveBatteryDescription_businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_collectiveBatteries_businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_electricitySliders_businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_electricityDemandSlidersResidentialArea = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricityDemandIncreaseResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdPVResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdPVResidentialAreaDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_electricitDemandSlidersResidentialAreaDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdBatteriesResidentialAreaDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdBatteriesResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gridBatteriesResidentialAreaDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_gridBatteriesResidentialArea_kW = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_electricityDemandIncreaseResidentialAreaDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdElectricCookingResidentialAreaDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_householdElectricCookingResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdRooftopPV = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdBatteries = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdElectricCooking = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdElectricityGrowth = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdNeighbourhoodBatteries = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_largeScalePV_ha_Residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_largeScalePVDescription_Residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_largeScaleWindDescription_Residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_largeScaleWind_MW_Residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_landPV_Residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_landWind_Residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_electricityTabResidential_Collective = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_electricitySliders_residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 76;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_trafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 77;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_addTrafoDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 78;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_minTrafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 79;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_maxTrafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 80;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_trafoReinforcementValue = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 81;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_currentTrafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 82;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_closeTrafoReinforcement1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 83;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_closeTrafoReinforcement2 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 84;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_titleTrafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 85;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_trafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 86;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_batteryFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 87;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_batteryFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 88;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricityDemandReduction_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 89;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_rooftopPVCompanies_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 90;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_largeScalePV_ha = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 91;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_largeScaleWind_MW = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 92;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_rooftopPVHouses_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 93;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_collectiveBattery_MWh_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 94;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_curtailment_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 95;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricityDemandReduction_pct_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 96;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_rooftopPVCompanies_pct_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 97;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_largeScalePV_ha_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 98;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_largeScaleWind_MW_Businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 99;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_curtailment_businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 100;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_collectiveBattery_MWh_businesspark = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 101;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdPVResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 102;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdBatteriesResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 103;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_gridBatteriesResidentialArea_kWh = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 104;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_electricityDemandIncreaseResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 105;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdElectricCookingResidentialArea_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 106;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_trafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 107;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_largeScalePV_ha_Residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 108;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_largeScaleWind_MW_Residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 109;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_trafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 110;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_confirmTrafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 111;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_resetTrafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 112;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_closeTrafoReinforcement = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 113;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 114;

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
	  level.addAll(rect_genericFunctions, gr_electricitySliders_default, rect_PVFunctions, txt_ProductionFunctionsDescription, rect_demandFunctions, t_demandFunctionsDescription, t_genericFunctions, gr_electricitySliders_businesspark, gr_electricitySliders_residential, gr_trafoReinforcement, rect_batteryFunctions, t_batteryFunctionsDescription);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_householdPV:
        if (true) {
          ShapeImage self = this.i_householdPV;
          
zero_Interface.f_setInfoText(i_householdPV, zero_Interface.v_infoText.householdRooftopPV, i_householdPV.getX() + uI_Tabs.v_presentationXOffset, i_householdPV.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_landPV:
        if (true) {
          ShapeImage self = this.i_landPV;
          
zero_Interface.f_setInfoText(i_landPV, zero_Interface.v_infoText.landPV, i_landPV.getX() + uI_Tabs.v_presentationXOffset, i_landPV.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyPV:
        if (true) {
          ShapeImage self = this.i_companyPV;
          
zero_Interface.f_setInfoText(i_companyPV, zero_Interface.v_infoText.companyRooftopPV, i_companyPV.getX() + uI_Tabs.v_presentationXOffset, i_companyPV.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_electricityReduction:
        if (true) {
          ShapeImage self = this.i_electricityReduction;
          
zero_Interface.f_setInfoText(i_electricityReduction, zero_Interface.v_infoText.electricityDemandReduction, i_electricityReduction.getX() + uI_Tabs.v_presentationXOffset, i_electricityReduction.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_landWind:
        if (true) {
          ShapeImage self = this.i_landWind;
          
zero_Interface.f_setInfoText(i_landWind, zero_Interface.v_infoText.landWind, i_landWind.getX() + uI_Tabs.v_presentationXOffset, i_landWind.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_curtailment_default:
        if (true) {
          ShapeImage self = this.i_curtailment_default;
          
zero_Interface.f_setInfoText(i_curtailment_default, zero_Interface.v_infoText.curtailment, i_curtailment_default.getX() + uI_Tabs.v_presentationXOffset, i_curtailment_default.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_collectiveBatteries_default:
        if (true) {
          ShapeImage self = this.i_collectiveBatteries_default;
          
zero_Interface.f_setInfoText(i_collectiveBatteries_default, zero_Interface.v_infoText.gridBattery_default, i_collectiveBatteries_default.getX() + uI_Tabs.v_presentationXOffset, i_collectiveBatteries_default.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_landPV_Businesspark:
        if (true) {
          ShapeImage self = this.i_landPV_Businesspark;
          
zero_Interface.f_setInfoText(i_landPV_Businesspark, zero_Interface.v_infoText.landPV, i_landPV_Businesspark.getX() + uI_Tabs.v_presentationXOffset, i_landPV_Businesspark.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companyPV_Businesspark:
        if (true) {
          ShapeImage self = this.i_companyPV_Businesspark;
          
zero_Interface.f_setInfoText(i_companyPV_Businesspark, zero_Interface.v_infoText.companyRooftopPV, i_companyPV_Businesspark.getX() + uI_Tabs.v_presentationXOffset, i_companyPV_Businesspark.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_electricityReduction_Businesspark:
        if (true) {
          ShapeImage self = this.i_electricityReduction_Businesspark;
          
zero_Interface.f_setInfoText(i_electricityReduction_Businesspark, zero_Interface.v_infoText.electricityDemandReduction, i_electricityReduction_Businesspark.getX() + uI_Tabs.v_presentationXOffset, i_electricityReduction_Businesspark.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_landWind_Businesspark:
        if (true) {
          ShapeImage self = this.i_landWind_Businesspark;
          
zero_Interface.f_setInfoText(i_landWind_Businesspark, zero_Interface.v_infoText.landWind, i_landWind_Businesspark.getX() + uI_Tabs.v_presentationXOffset, i_landWind_Businesspark.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_curtailment_businesspark:
        if (true) {
          ShapeImage self = this.i_curtailment_businesspark;
          
zero_Interface.f_setInfoText(i_curtailment_businesspark, zero_Interface.v_infoText.curtailment, i_curtailment_businesspark.getX() + uI_Tabs.v_presentationXOffset, i_curtailment_businesspark.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_collectiveBatteries_businesspark:
        if (true) {
          ShapeImage self = this.i_collectiveBatteries_businesspark;
          
zero_Interface.f_setInfoText(i_collectiveBatteries_businesspark, zero_Interface.v_infoText.gridBattery_default, i_collectiveBatteries_businesspark.getX() + uI_Tabs.v_presentationXOffset, i_collectiveBatteries_businesspark.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdRooftopPV:
        if (true) {
          ShapeImage self = this.i_householdRooftopPV;
          
zero_Interface.f_setInfoText(i_householdRooftopPV, zero_Interface.v_infoText.householdRooftopPV, i_householdRooftopPV.getX() + uI_Tabs.v_presentationXOffset, i_householdRooftopPV.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdBatteries:
        if (true) {
          ShapeImage self = this.i_householdBatteries;
          
zero_Interface.f_setInfoText(i_householdBatteries, zero_Interface.v_infoText.householdBatteries, i_householdBatteries.getX() + uI_Tabs.v_presentationXOffset, i_householdBatteries.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdElectricCooking:
        if (true) {
          ShapeImage self = this.i_householdElectricCooking;
          
zero_Interface.f_setInfoText(i_householdElectricCooking, zero_Interface.v_infoText.householdElectricCooking, i_householdElectricCooking.getX() + uI_Tabs.v_presentationXOffset, i_householdElectricCooking.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdElectricityGrowth:
        if (true) {
          ShapeImage self = this.i_householdElectricityGrowth;
          
zero_Interface.f_setInfoText(i_householdElectricityGrowth, zero_Interface.v_infoText.householdElectricityConsumptionGrowth, i_householdElectricityGrowth.getX() + uI_Tabs.v_presentationXOffset, i_householdElectricityGrowth.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdNeighbourhoodBatteries:
        if (true) {
          ShapeImage self = this.i_householdNeighbourhoodBatteries;
          
zero_Interface.f_setInfoText(i_householdNeighbourhoodBatteries, zero_Interface.v_infoText.gridBattery_residential, i_householdNeighbourhoodBatteries.getX() + uI_Tabs.v_presentationXOffset, i_householdNeighbourhoodBatteries.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_landPV_Residential:
        if (true) {
          ShapeImage self = this.i_landPV_Residential;
          
zero_Interface.f_setInfoText(i_landPV_Residential, zero_Interface.v_infoText.landPV, i_landPV_Residential.getX() + uI_Tabs.v_presentationXOffset, i_landPV_Residential.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_landWind_Residential:
        if (true) {
          ShapeImage self = this.i_landWind_Residential;
          
zero_Interface.f_setInfoText(i_landWind_Residential, zero_Interface.v_infoText.landWind, i_landWind_Residential.getX() + uI_Tabs.v_presentationXOffset, i_landWind_Residential.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _button_trafoReinforcement: {
          ShapeButton self = this.button_trafoReinforcement;
//gr_electricityDemandSlidersResidentialAreaScale.setVisible(false);
gr_trafoReinforcement.setVisible(true);
 
;}
        break;
      case _t_confirmTrafoReinforcement: {
          ShapeButton self = this.t_confirmTrafoReinforcement;
zero_Interface.v_clickedGridNode.p_capacity_kW += sl_trafoReinforcement.getValue();

zero_Interface.f_setTrafoText(); 
;}
        break;
      case _t_resetTrafoReinforcement: {
          ShapeButton self = this.t_resetTrafoReinforcement;
for (GridNode GN : zero_Interface.energyModel.f_getGridNodesNotTopLevel() ){
	GN.p_capacity_kW = GN.p_originalCapacity_kW;
}
for (GridNode GN : zero_Interface.energyModel.f_getGridNodesTopLevel() ){
	GN.p_capacity_kW = GN.p_originalCapacity_kW;
} 
zero_Interface.f_setTrafoText();
 
;}
        break;
      case _t_closeTrafoReinforcement: {
          ShapeButton self = this.t_closeTrafoReinforcement;
gr_trafoReinforcement.setVisible(false); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, boolean value ) {
    switch( _shape ) {
      case _cb_curtailment_default: {
          ShapeCheckBox self = this.cb_curtailment_default;
f_setCurtailment(cb_curtailment_default.isSelected(), uI_Tabs.f_getActiveSliderGridConnections_consumption()); 
;}
        break;
      case _cb_curtailment_businesspark: {
          ShapeCheckBox self = this.cb_curtailment_businesspark;
f_setCurtailment(cb_curtailment_businesspark.isSelected(), new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities())); 
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
      case _sl_electricityDemandReduction_pct: {
          ShapeSlider self = this.sl_electricityDemandReduction_pct;
f_setDemandReduction( uI_Tabs.f_getActiveSliderGridConnections_consumption(), sl_electricityDemandReduction_pct.getValue() ); 
;}
        break;
      case _sl_rooftopPVCompanies_pct: {
          ShapeSlider self = this.sl_rooftopPVCompanies_pct;
f_setPVSystemCompanies( uI_Tabs.f_getActiveSliderGridConnections_utilities(), sl_rooftopPVCompanies_pct.getValue(), sl_rooftopPVCompanies_pct );

if(zero_Interface.rb_mapOverlay != null && zero_Interface.c_loadedMapOverlayTypes.get(zero_Interface.rb_mapOverlay.getValue()) == OL_MapOverlayTypes.PV_PRODUCTION){
	zero_Interface.rb_mapOverlay.setValue(zero_Interface.c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.PV_PRODUCTION),true);
} 
;}
        break;
      case _sl_largeScalePV_ha: {
          ShapeSlider self = this.sl_largeScalePV_ha;
List<GCEnergyProduction> sliderPVFarmGCList = new ArrayList<>();
for(GridConnection gc : c_electricityTabEASliderGCs){
	if(gc instanceof GCEnergyProduction energyProductionSite){
		for(J_EAProduction j_ea : energyProductionSite.c_productionAssets) {
			if (j_ea.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC) {
				sliderPVFarmGCList.add(energyProductionSite);
				break;
			}
		}
	}
}

if(sliderPVFarmGCList.size() == 0){
	throw new IllegalStateException("Model does not contain any PVFarmSliderGC agent");
}


f_setPVOnLand(sl_largeScalePV_ha.getValue() - p_currentPVOnLand_ha, sliderPVFarmGCList); 
;}
        break;
      case _sl_largeScaleWind_MW: {
          ShapeSlider self = this.sl_largeScaleWind_MW;
List<GCEnergyProduction> sliderWindFarmGCList = new ArrayList<>();
for(GridConnection gc : c_electricityTabEASliderGCs){
	if(gc instanceof GCEnergyProduction energyProductionSite){
		for(J_EAProduction j_ea : energyProductionSite.c_productionAssets) {
			if (j_ea.getEAType() == OL_EnergyAssetType.WINDMILL) {
				sliderWindFarmGCList.add(energyProductionSite);
				break;
			}
		}
	}
}

if(sliderWindFarmGCList.size() == 0){
	throw new IllegalStateException("Model does not contain any sliderWindFarmGC agent");
}

f_setWindTurbines( sl_largeScaleWind_MW.getValue() - p_currentWindTurbines_MW, sliderWindFarmGCList); 
;}
        break;
      case _sl_rooftopPVHouses_pct: {
          ShapeSlider self = this.sl_rooftopPVHouses_pct;
f_setPVSystemHouses( uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_rooftopPVHouses_pct.getValue() );

if(zero_Interface.rb_mapOverlay != null  && zero_Interface.c_loadedMapOverlayTypes.get(zero_Interface.rb_mapOverlay.getValue()) == OL_MapOverlayTypes.PV_PRODUCTION){
	zero_Interface.rb_mapOverlay.setValue(zero_Interface.c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.PV_PRODUCTION),true);
} 
;}
        break;
      case _sl_collectiveBattery_MWh_default: {
          ShapeSlider self = this.sl_collectiveBattery_MWh_default;
List<GCGridBattery> gcListGridBatteries = new ArrayList<>();
for(GridConnection gc : c_electricityTabEASliderGCs){
	if(gc instanceof GCGridBattery gridbattery){
		gcListGridBatteries.add(gridbattery);
	}
}

if(gcListGridBatteries.size() == 0){
	throw new IllegalStateException("Model does not contain any GCGridBattery agent");
}

f_setGridBatteries(sl_collectiveBattery_MWh_default.getValue() * 1000, gcListGridBatteries); 
;}
        break;
      case _sl_electricityDemandReduction_pct_Businesspark: {
          ShapeSlider self = this.sl_electricityDemandReduction_pct_Businesspark;
f_setDemandReduction( uI_Tabs.f_getActiveSliderGridConnections_consumption(), sl_electricityDemandReduction_pct_Businesspark.getValue() ); 
;}
        break;
      case _sl_rooftopPVCompanies_pct_Businesspark: {
          ShapeSlider self = this.sl_rooftopPVCompanies_pct_Businesspark;
f_setPVSystemCompanies( uI_Tabs.f_getActiveSliderGridConnections_utilities(), sl_rooftopPVCompanies_pct_Businesspark.getValue(), sl_rooftopPVCompanies_pct_Businesspark );

//If on pv map overlay, adjust colouring
if(zero_Interface.rb_mapOverlay != null  && zero_Interface.c_loadedMapOverlayTypes.get(zero_Interface.rb_mapOverlay.getValue()) == OL_MapOverlayTypes.PV_PRODUCTION){
	zero_Interface.rb_mapOverlay.setValue(zero_Interface.c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.PV_PRODUCTION),true);
} 
;}
        break;
      case _sl_largeScalePV_ha_Businesspark: {
          ShapeSlider self = this.sl_largeScalePV_ha_Businesspark;
List<GCEnergyProduction> sliderPVFarmGCList = new ArrayList<>();
for(GridConnection gc : c_electricityTabEASliderGCs){
	if(gc instanceof GCEnergyProduction energyProductionSite){
		for(J_EAProduction j_ea : energyProductionSite.c_productionAssets) {
			if (j_ea.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC) {
				sliderPVFarmGCList.add(energyProductionSite);
				break;
			}
		}
	}
}

if(sliderPVFarmGCList.size() == 0){
	throw new IllegalStateException("Model does not contain any PVFarmSliderGC agent");
}


f_setPVOnLand(sl_largeScalePV_ha_Businesspark.getValue() - p_currentPVOnLand_ha, sliderPVFarmGCList); 
;}
        break;
      case _sl_largeScaleWind_MW_Businesspark: {
          ShapeSlider self = this.sl_largeScaleWind_MW_Businesspark;
List<GCEnergyProduction> sliderWindFarmGCList = new ArrayList<>();
for(GridConnection gc : c_electricityTabEASliderGCs){
	if(gc instanceof GCEnergyProduction energyProductionSite){
		for(J_EAProduction j_ea : energyProductionSite.c_productionAssets) {
			if (j_ea.getEAType() == OL_EnergyAssetType.WINDMILL) {
				sliderWindFarmGCList.add(energyProductionSite);
				break;
			}
		}
	}
}

if(sliderWindFarmGCList.size() == 0){
	throw new IllegalStateException("Model does not contain any sliderWindFarmGC agent");
}

f_setWindTurbines( sl_largeScaleWind_MW_Businesspark.getValue() - p_currentWindTurbines_MW, sliderWindFarmGCList); 
;}
        break;
      case _sl_collectiveBattery_MWh_businesspark: {
          ShapeSlider self = this.sl_collectiveBattery_MWh_businesspark;
List<GCGridBattery> gcListGridBatteries = new ArrayList<>();
for(GridConnection gc : c_electricityTabEASliderGCs){
	if(gc instanceof GCGridBattery gridbattery){
		gcListGridBatteries.add(gridbattery);
	}
}

if(gcListGridBatteries.size() == 0){
	throw new IllegalStateException("Model does not contain any GCGridBattery agent");
}

f_setGridBatteries(sl_collectiveBattery_MWh_businesspark.getValue() * 1000, gcListGridBatteries); 
;}
        break;
      case _sl_householdPVResidentialArea_pct: {
          ShapeSlider self = this.sl_householdPVResidentialArea_pct;
f_setPVSystemHouses( uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_householdPVResidentialArea_pct.getValue() );

//If on pv map overlay, adjust colouring
if(zero_Interface.rb_mapOverlay != null && zero_Interface.c_loadedMapOverlayTypes.get(zero_Interface.rb_mapOverlay.getValue()) == OL_MapOverlayTypes.PV_PRODUCTION){
	zero_Interface.rb_mapOverlay.setValue(zero_Interface.c_loadedMapOverlayTypes.indexOf(OL_MapOverlayTypes.PV_PRODUCTION),true);
}

// Also updates the home batteries
f_setResidentialBatteries( sl_householdBatteriesResidentialArea_pct.getValue(), uI_Tabs.f_getActiveSliderGridConnections_houses() ); 
;}
        break;
      case _sl_householdBatteriesResidentialArea_pct: {
          ShapeSlider self = this.sl_householdBatteriesResidentialArea_pct;
f_setResidentialBatteries( sl_householdBatteriesResidentialArea_pct.getValue(), uI_Tabs.f_getActiveSliderGridConnections_houses() ); 
;}
        break;
      case _sl_gridBatteriesResidentialArea_kWh: {
          ShapeSlider self = this.sl_gridBatteriesResidentialArea_kWh;
List<GCGridBattery> gcListGridBatteries = new ArrayList<>();
for(GridConnection gc : c_electricityTabEASliderGCs){
	if(gc instanceof GCGridBattery gridbattery){
		gcListGridBatteries.add(gridbattery);
	}
}

if(gcListGridBatteries.size() == 0){
	throw new IllegalStateException("Model does not contain any GCGridBattery agent");
}

f_setGridBatteries(sl_gridBatteriesResidentialArea_kWh.getValue(), gcListGridBatteries); 
;}
        break;
      case _sl_electricityDemandIncreaseResidentialArea_pct: {
          ShapeSlider self = this.sl_electricityDemandIncreaseResidentialArea_pct;
f_setDemandIncrease( new ArrayList<GridConnection>(findAll(zero_Interface.energyModel.Houses, x -> true)), sl_electricityDemandIncreaseResidentialArea_pct.getValue() );
 
;}
        break;
      case _sl_householdElectricCookingResidentialArea_pct: {
          ShapeSlider self = this.sl_householdElectricCookingResidentialArea_pct;
f_setElectricCooking(uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_householdElectricCookingResidentialArea_pct.getValue() ); 
;}
        break;
      case _sl_largeScalePV_ha_Residential: {
          ShapeSlider self = this.sl_largeScalePV_ha_Residential;
List<GCEnergyProduction> sliderPVFarmGCList = new ArrayList<>();
for(GridConnection gc : c_electricityTabEASliderGCs){
	if(gc instanceof GCEnergyProduction energyProductionSite){
		for(J_EAProduction j_ea : energyProductionSite.c_productionAssets) {
			if (j_ea.getEAType() == OL_EnergyAssetType.PHOTOVOLTAIC) {
				sliderPVFarmGCList.add(energyProductionSite);
				break;
			}
		}
	}
}

if(sliderPVFarmGCList.size() == 0){
	throw new IllegalStateException("Model does not contain any PVFarmSliderGC agent");
}


f_setPVOnLand(sl_largeScalePV_ha_Residential.getValue() - p_currentPVOnLand_ha, sliderPVFarmGCList); 
;}
        break;
      case _sl_largeScaleWind_MW_Residential: {
          ShapeSlider self = this.sl_largeScaleWind_MW_Residential;
List<GCEnergyProduction> sliderWindFarmGCList = new ArrayList<>();
for(GridConnection gc : c_electricityTabEASliderGCs){
	if(gc instanceof GCEnergyProduction energyProductionSite){
		for(J_EAProduction j_ea : energyProductionSite.c_productionAssets) {
			if (j_ea.getEAType() == OL_EnergyAssetType.WINDMILL) {
				sliderWindFarmGCList.add(energyProductionSite);
				break;
			}
		}
	}
}

if(sliderWindFarmGCList.size() == 0){
	throw new IllegalStateException("Model does not contain any sliderWindFarmGC agent");
}

f_setWindTurbines( sl_largeScaleWind_MW_Residential.getValue() - p_currentWindTurbines_MW, sliderWindFarmGCList); 
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
      case _sl_electricityDemandReduction_pct: return 
0 
;
      case _sl_rooftopPVCompanies_pct: return 
0 
;
      case _sl_largeScalePV_ha: return 
0 
;
      case _sl_largeScaleWind_MW: return 
0 
;
      case _sl_rooftopPVHouses_pct: return 
0 
;
      case _sl_collectiveBattery_MWh_default: return 
0 
;
      case _sl_electricityDemandReduction_pct_Businesspark: return 
0 
;
      case _sl_rooftopPVCompanies_pct_Businesspark: return 
0 
;
      case _sl_largeScalePV_ha_Businesspark: return 
0 
;
      case _sl_largeScaleWind_MW_Businesspark: return 
0 
;
      case _sl_collectiveBattery_MWh_businesspark: return 
0 
;
      case _sl_householdPVResidentialArea_pct: return 
0 
;
      case _sl_householdBatteriesResidentialArea_pct: return 
0 
;
      case _sl_gridBatteriesResidentialArea_kWh: return 
0 
;
      case _sl_electricityDemandIncreaseResidentialArea_pct: return 
0 
;
      case _sl_householdElectricCookingResidentialArea_pct: return 
0 
;
      case _sl_largeScalePV_ha_Residential: return 
0 
;
      case _sl_largeScaleWind_MW_Residential: return 
0 
;
      case _sl_trafoReinforcement: return 
0 
;
      default: return super.getShapeControlDefaultValueDouble( _shape, index );
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_electricityDemandReduction_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_electricityDemandReduction_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_rooftopPVCompanies_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_rooftopPVCompanies_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_largeScalePV_ha_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
p_currentPVOnLand_ha ;
      @AnyLogicInternalCodegenAPI
      double _max = 
p_currentPVOnLand_ha + 50 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_largeScalePV_ha;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_largeScaleWind_MW_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
p_currentWindTurbines_MW ;
      @AnyLogicInternalCodegenAPI
      double _max = 
p_currentWindTurbines_MW + 10 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_largeScaleWind_MW;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_rooftopPVHouses_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_rooftopPVHouses_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_collectiveBattery_MWh_default_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
p_currentTotalGridBatteryCapacity_MWh ;
      @AnyLogicInternalCodegenAPI
      double _max = 
p_currentTotalGridBatteryCapacity_MWh + 50 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_collectiveBattery_MWh_default;
  protected ShapeCheckBox cb_curtailment_default;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_electricityDemandReduction_pct_Businesspark_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_electricityDemandReduction_pct_Businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_rooftopPVCompanies_pct_Businesspark_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_rooftopPVCompanies_pct_Businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_largeScalePV_ha_Businesspark_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
p_currentPVOnLand_ha ;
      @AnyLogicInternalCodegenAPI
      double _max = 
p_currentPVOnLand_ha + 50 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_largeScalePV_ha_Businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_largeScaleWind_MW_Businesspark_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
p_currentWindTurbines_MW ;
      @AnyLogicInternalCodegenAPI
      double _max = 
p_currentWindTurbines_MW + 10 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_largeScaleWind_MW_Businesspark;
  protected ShapeCheckBox cb_curtailment_businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_collectiveBattery_MWh_businesspark_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
p_currentTotalGridBatteryCapacity_MWh ;
      @AnyLogicInternalCodegenAPI
      double _max = 
p_currentTotalGridBatteryCapacity_MWh + 50 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_collectiveBattery_MWh_businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdPVResidentialArea_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdPVResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdBatteriesResidentialArea_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdBatteriesResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_gridBatteriesResidentialArea_kWh_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
1000 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_gridBatteriesResidentialArea_kWh;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_electricityDemandIncreaseResidentialArea_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_electricityDemandIncreaseResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdElectricCookingResidentialArea_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdElectricCookingResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_trafoReinforcement_SetDynamicParams_xjal( ShapeButton shape ) {
    boolean _visible = 
false; // DOESNT WORK PROPERLY 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
zero_Interface.v_clickedGridNode != null 
);
 	}
  }
  
  protected ShapeButton button_trafoReinforcement;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_largeScalePV_ha_Residential_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
p_currentPVOnLand_ha ;
      @AnyLogicInternalCodegenAPI
      double _max = 
p_currentPVOnLand_ha + 50 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_largeScalePV_ha_Residential;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_largeScaleWind_MW_Residential_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
p_currentWindTurbines_MW ;
      @AnyLogicInternalCodegenAPI
      double _max = 
p_currentWindTurbines_MW + 10 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_largeScaleWind_MW_Residential;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_trafoReinforcement_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
1000 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_trafoReinforcement;
  protected ShapeButton t_confirmTrafoReinforcement;
  protected ShapeButton t_resetTrafoReinforcement;
  protected ShapeButton t_closeTrafoReinforcement;
  protected ShapeRectangle rect_genericFunctions;
  protected ShapeRectangle rect_electricityDemandSliders;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_electricityDemandReduction_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_electricityDemandReduction_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_electricityDemandReduction_pct;
  protected ShapeText t_electricityDemandReductionDescription;
  protected ShapeText txt_productionDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_rooftopPVCompanies_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_rooftopPVCompanies_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_rooftopPVCompanies_pct;
  protected ShapeText t_rooftopPVCompaniesDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_largeScalePV_ha_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_largeScalePV_ha.getValue() + " ha" 
);
  }
  
  protected ShapeText t_largeScalePV_ha;
  protected ShapeText t_largeScalePVDescription;
  protected ShapeText txt_batteryDescription_default;
  protected ShapeText t_largeScaleWindDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_largeScaleWind_MW_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_largeScaleWind_MW.getValue() + " MW" 
);
  }
  
  protected ShapeText t_largeScaleWind_MW;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_rooftopPVHouses_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_rooftopPVHouses_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_rooftopPVHouses_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_rooftopPVHouses_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_rooftopPVHousesDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_rooftopPVHouses_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_rooftopPVHousesDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdPV_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_rooftopPVHouses_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdPV;
  protected ShapeImage i_landPV;
  protected ShapeImage i_companyPV;
  protected ShapeImage i_electricityReduction;
  protected ShapeImage i_landWind;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_collectiveBatteries_default_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_collectiveBattery_MWh_default.getIntValue() + " MWh" 
);
  }
  
  protected ShapeText t_collectiveBatteries_default;
  protected ShapeText txt_curtailmentDescription_default;
  protected ShapeText txt_collectiveBatteryDescription_default;
  protected ShapeImage i_curtailment_default;
  protected ShapeImage i_collectiveBatteries_default;
  protected ShapeGroup gr_electricitySliders_default;
  protected ShapeRectangle rect_PVFunctions;
  protected ShapeText txt_ProductionFunctionsDescription;
  protected ShapeRectangle rect_demandFunctions;
  protected ShapeText t_demandFunctionsDescription;
  protected ShapeText t_genericFunctions;
  protected ShapeRectangle rect_electricityDemandSliders_Businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_electricityDemandReduction_pct_Businesspark_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_electricityDemandReduction_pct_Businesspark.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_electricityDemandReduction_pct_Businesspark;
  protected ShapeText txt_electricityDemandReductionDescription_Businesspark;
  protected ShapeText txt_productionDescription_Businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_rooftopPVCompanies_pct_Businesspark_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_rooftopPVCompanies_pct_Businesspark.getIntValue() + "%" 
);
  }
  
  protected ShapeText t_rooftopPVCompanies_pct_Businesspark;
  protected ShapeText txt_rooftopPVCompaniesDescription_Businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_largeScalePV_ha_Businesspark_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_largeScalePV_ha_Businesspark.getValue() + " ha" 
);
  }
  
  protected ShapeText t_largeScalePV_ha_Businesspark;
  protected ShapeText txt_largeScalePVDescription_Businesspark;
  protected ShapeText txt_batteryDescription_businesspark;
  protected ShapeText txt_largeScaleWindDescription_Businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_largeScaleWind_MW_Businesspark_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_largeScaleWind_MW_Businesspark.getValue() + " MW" 
);
  }
  
  protected ShapeText t_largeScaleWind_MW_Businesspark;
  protected ShapeImage i_landPV_Businesspark;
  protected ShapeImage i_companyPV_Businesspark;
  protected ShapeImage i_electricityReduction_Businesspark;
  protected ShapeImage i_landWind_Businesspark;
  protected ShapeText txt_curtailmentDescription_businesspark;
  protected ShapeImage i_curtailment_businesspark;
  protected ShapeImage i_collectiveBatteries_businesspark;
  protected ShapeText txt_collectiveBatteryDescription_businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_collectiveBatteries_businesspark_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_collectiveBattery_MWh_businesspark.getIntValue() + " MWh" 
);
  }
  
  protected ShapeText t_collectiveBatteries_businesspark;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_electricitySliders_businesspark_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_electricitySliders_businesspark;
  protected ShapeRectangle rect_electricityDemandSlidersResidentialArea;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_electricityDemandIncreaseResidentialArea_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_electricityDemandIncreaseResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_electricityDemandIncreaseResidentialArea_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_electricityDemandIncreaseResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdPVResidentialArea_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdPVResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdPVResidentialArea_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_householdPVResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdPVResidentialAreaDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdPVResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_householdPVResidentialAreaDescription;
  protected ShapeText txt_electricitDemandSlidersResidentialAreaDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdBatteriesResidentialAreaDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdBatteriesResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_householdBatteriesResidentialAreaDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdBatteriesResidentialArea_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdBatteriesResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdBatteriesResidentialArea_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_householdBatteriesResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_gridBatteriesResidentialAreaDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_gridBatteriesResidentialArea_kWh.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_gridBatteriesResidentialAreaDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_gridBatteriesResidentialArea_kW_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_gridBatteriesResidentialArea_kWh.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_gridBatteriesResidentialArea_kWh.getIntValue() + " kWh" 
);
 	}
  }
  
  protected ShapeText t_gridBatteriesResidentialArea_kW;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_electricityDemandIncreaseResidentialAreaDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_electricityDemandIncreaseResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_electricityDemandIncreaseResidentialAreaDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdElectricCookingResidentialAreaDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdElectricCookingResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText t_householdElectricCookingResidentialAreaDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_householdElectricCookingResidentialArea_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdElectricCookingResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdElectricCookingResidentialArea_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_householdElectricCookingResidentialArea_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdRooftopPV_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdPVResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdRooftopPV;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdBatteries_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdBatteriesResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdBatteries;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdElectricCooking_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdElectricCookingResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdElectricCooking;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdElectricityGrowth_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_electricityDemandIncreaseResidentialArea_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdElectricityGrowth;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdNeighbourhoodBatteries_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_gridBatteriesResidentialArea_kWh.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdNeighbourhoodBatteries;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_largeScalePV_ha_Residential_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_largeScalePV_ha_Residential.getValue() + " ha" 
);
  }
  
  protected ShapeText t_largeScalePV_ha_Residential;
  protected ShapeText txt_largeScalePVDescription_Residential;
  protected ShapeText txt_largeScaleWindDescription_Residential;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_largeScaleWind_MW_Residential_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_largeScaleWind_MW_Residential.getValue() + " MW" 
);
  }
  
  protected ShapeText t_largeScaleWind_MW_Residential;
  protected ShapeImage i_landPV_Residential;
  protected ShapeImage i_landWind_Residential;
  protected ShapeText txt_electricityTabResidential_Collective;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_electricitySliders_residential_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_electricitySliders_residential;
  protected ShapeRectangle rect_trafoReinforcement;
  protected ShapeText t_addTrafoDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_minTrafoReinforcement_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_trafoReinforcement.getMin() 
);
  }
  
  protected ShapeText t_minTrafoReinforcement;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_maxTrafoReinforcement_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_trafoReinforcement.getMax() 
);
  }
  
  protected ShapeText t_maxTrafoReinforcement;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_trafoReinforcementValue_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_trafoReinforcement.getIntValue() + " kVA" 
);
  }
  
  protected ShapeText t_trafoReinforcementValue;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_currentTrafoReinforcement_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Huidige LS-capaciteit: " + roundToInt(zero_Interface.v_clickedGridNode.p_capacity_kW)  + " kVA" 
);
  }
  
  protected ShapeText t_currentTrafoReinforcement;
  protected ShapeLine line_closeTrafoReinforcement1;
  protected ShapeLine line_closeTrafoReinforcement2;
  protected ShapeText t_titleTrafoReinforcement;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_trafoReinforcement_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
  }
  
  protected ShapeGroup gr_trafoReinforcement;
  protected ShapeRectangle rect_batteryFunctions;
  protected ShapeText t_batteryFunctionsDescription;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    sl_electricityDemandReduction_pct = new ShapeSlider(
tabElectricity.this, true, 260.0, 15.0,
			100.0, 30.0,
            true, false,
            -50
            , 50
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_electricityDemandReduction_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_electricityDemandReduction_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_electricityDemandReduction_pct, 0 ), getMax() ) );
      }
    };
    sl_rooftopPVCompanies_pct = new ShapeSlider(
tabElectricity.this, true, 260.0, 75.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_rooftopPVCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_rooftopPVCompanies_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_rooftopPVCompanies_pct, 0 ), getMax() ) );
      }
    };
    sl_largeScalePV_ha = new ShapeSlider(
tabElectricity.this, true, 260.0, 140.0,
			100.0, 30.0,
            true, false,
            p_currentPVOnLand_ha
            , p_currentPVOnLand_ha + 50
            , 0.1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_largeScalePV_ha_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_largeScalePV_ha, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_largeScalePV_ha, 0 ), getMax() ) );
      }
    };
    sl_largeScaleWind_MW = new ShapeSlider(
tabElectricity.this, true, 260.0, 170.0,
			100.0, 30.0,
            true, false,
            p_currentWindTurbines_MW
            , p_currentWindTurbines_MW + 10
            , 0.1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_largeScaleWind_MW_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_largeScaleWind_MW, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_largeScaleWind_MW, 0 ), getMax() ) );
      }
    };
    sl_rooftopPVHouses_pct = new ShapeSlider(
tabElectricity.this, true, 260.0, 105.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_rooftopPVHouses_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_rooftopPVHouses_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_rooftopPVHouses_pct, 0 ), getMax() ) );
      }
    };
    sl_collectiveBattery_MWh_default = new ShapeSlider(
tabElectricity.this, true, 260.0, 270.0,
			100.0, 30.0,
            true, false,
            p_currentTotalGridBatteryCapacity_MWh
            , p_currentTotalGridBatteryCapacity_MWh + 50
            , 0.1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_collectiveBattery_MWh_default_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_collectiveBattery_MWh_default, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_collectiveBattery_MWh_default, 0 ), getMax() ) );
      }
    };
    cb_curtailment_default = new ShapeCheckBox(
tabElectricity.this,true,300.0, 202.0,
		40.0, 30.0,
            black, true,
            _cb_curtailment_default_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_curtailment_default, 0, value );
      }
    };
    sl_electricityDemandReduction_pct_Businesspark = new ShapeSlider(
tabElectricity.this, true, 260.0, 15.0,
			100.0, 30.0,
            true, false,
            -50
            , 50
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_electricityDemandReduction_pct_Businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_electricityDemandReduction_pct_Businesspark, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_electricityDemandReduction_pct_Businesspark, 0 ), getMax() ) );
      }
    };
    sl_rooftopPVCompanies_pct_Businesspark = new ShapeSlider(
tabElectricity.this, true, 260.0, 75.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_rooftopPVCompanies_pct_Businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_rooftopPVCompanies_pct_Businesspark, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_rooftopPVCompanies_pct_Businesspark, 0 ), getMax() ) );
      }
    };
    sl_largeScalePV_ha_Businesspark = new ShapeSlider(
tabElectricity.this, true, 260.0, 110.0,
			100.0, 30.0,
            true, false,
            p_currentPVOnLand_ha
            , p_currentPVOnLand_ha + 50
            , 0.1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_largeScalePV_ha_Businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_largeScalePV_ha_Businesspark, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_largeScalePV_ha_Businesspark, 0 ), getMax() ) );
      }
    };
    sl_largeScaleWind_MW_Businesspark = new ShapeSlider(
tabElectricity.this, true, 260.0, 145.0,
			100.0, 30.0,
            true, false,
            p_currentWindTurbines_MW
            , p_currentWindTurbines_MW + 10
            , 0.1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_largeScaleWind_MW_Businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_largeScaleWind_MW_Businesspark, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_largeScaleWind_MW_Businesspark, 0 ), getMax() ) );
      }
    };
    cb_curtailment_businesspark = new ShapeCheckBox(
tabElectricity.this,true,300.0, 177.0,
		40.0, 30.0,
            black, true,
            _cb_curtailment_businesspark_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_curtailment_businesspark, 0, value );
      }
    };
    sl_collectiveBattery_MWh_businesspark = new ShapeSlider(
tabElectricity.this, true, 260.0, 255.0,
			100.0, 30.0,
            true, false,
            p_currentTotalGridBatteryCapacity_MWh
            , p_currentTotalGridBatteryCapacity_MWh + 50
            , 0.1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_collectiveBattery_MWh_businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_collectiveBattery_MWh_businesspark, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_collectiveBattery_MWh_businesspark, 0 ), getMax() ) );
      }
    };
    sl_householdPVResidentialArea_pct = new ShapeSlider(
tabElectricity.this, true, 265.0, 45.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdPVResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdPVResidentialArea_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdPVResidentialArea_pct, 0 ), getMax() ) );
      }
    };
    sl_householdBatteriesResidentialArea_pct = new ShapeSlider(
tabElectricity.this, true, 265.0, 75.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 5
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdBatteriesResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdBatteriesResidentialArea_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdBatteriesResidentialArea_pct, 0 ), getMax() ) );
      }
    };
    sl_gridBatteriesResidentialArea_kWh = new ShapeSlider(
tabElectricity.this, true, 266.0, 300.0,
			100.0, 30.0,
            true, false,
            0
            , 1000
            , 10
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_gridBatteriesResidentialArea_kWh_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_gridBatteriesResidentialArea_kWh, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_gridBatteriesResidentialArea_kWh, 0 ), getMax() ) );
      }
    };
    sl_electricityDemandIncreaseResidentialArea_pct = new ShapeSlider(
tabElectricity.this, true, 265.0, 155.0,
			100.0, 30.0,
            true, false,
            -50
            , 50
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_electricityDemandIncreaseResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_electricityDemandIncreaseResidentialArea_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_electricityDemandIncreaseResidentialArea_pct, 0 ), getMax() ) );
      }
    };
    sl_householdElectricCookingResidentialArea_pct = new ShapeSlider(
tabElectricity.this, true, 265.0, 115.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 2
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdElectricCookingResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdElectricCookingResidentialArea_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdElectricCookingResidentialArea_pct, 0 ), getMax() ) );
      }
    };
    button_trafoReinforcement = new ShapeButton(
tabElectricity.this, true, 238.0, 0.0,
			130.0, 25.0,
            black, true,
_button_trafoReinforcement_Font,
			"Trafo uitbereiding" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_trafoReinforcement_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_trafoReinforcement, 0 );
      }
    };
    sl_largeScalePV_ha_Residential = new ShapeSlider(
tabElectricity.this, true, 265.0, 230.0,
			100.0, 30.0,
            true, false,
            p_currentPVOnLand_ha
            , p_currentPVOnLand_ha + 50
            , 0.1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_largeScalePV_ha_Residential_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_largeScalePV_ha_Residential, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_largeScalePV_ha_Residential, 0 ), getMax() ) );
      }
    };
    sl_largeScaleWind_MW_Residential = new ShapeSlider(
tabElectricity.this, true, 265.0, 265.0,
			100.0, 30.0,
            true, false,
            p_currentWindTurbines_MW
            , p_currentWindTurbines_MW + 10
            , 0.1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_largeScaleWind_MW_Residential_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_largeScaleWind_MW_Residential, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_largeScaleWind_MW_Residential, 0 ), getMax() ) );
      }
    };
    sl_trafoReinforcement = new ShapeSlider(
tabElectricity.this, true, 20.0, 90.0,
			150.0, 30.0,
            true, false,
            0
            , 1000
            , 50
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_trafoReinforcement_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_trafoReinforcement, 0 ), getMax() ) );
      }
    };
    t_confirmTrafoReinforcement = new ShapeButton(
tabElectricity.this, true, 210.0, 94.0,
			142.0, 32.0,
            black, true,
_t_confirmTrafoReinforcement_Font,
			"Voer netuitbreiding uit" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _t_confirmTrafoReinforcement, 0 );
      }
    };
    t_resetTrafoReinforcement = new ShapeButton(
tabElectricity.this, true, 215.0, 300.0,
			140.0, 30.0,
            black, true,
_t_resetTrafoReinforcement_Font,
			"Reset trafostations" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _t_resetTrafoReinforcement, 0 );
      }
    };
    t_closeTrafoReinforcement = new ShapeButton(
tabElectricity.this, true, 350.0, 2.0,
			18.0, 18.0,
            black, true,
_t_closeTrafoReinforcement_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _t_closeTrafoReinforcement, 0 );
      }
    };
    rect_genericFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,10.0, 480.0, 0.0, 0.0,
            silver, white,
			370.0, 730.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_electricityDemandSliders = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, lightYellow,
			370.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_electricityDemandReduction_pct = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 20.0, 0.0, 0.0,
        black,"#",
        _t_electricityDemandReduction_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_electricityDemandReduction_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_electricityDemandReductionDescription = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, 20.0, 0.0, 0.0,
        black,"Besparing verbruik",
        _t_electricityDemandReductionDescription_Font, ALIGNMENT_LEFT );
    txt_productionDescription = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 55.0, 0.0, 0.0,
        black,"Opwek",
        _txt_productionDescription_Font, ALIGNMENT_LEFT );
    t_rooftopPVCompanies_pct = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 80.0, 0.0, 0.0,
        black,"#",
        _t_rooftopPVCompanies_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_rooftopPVCompanies_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_rooftopPVCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 80.0, 0.0, 0.0,
        black,"Zon op dak bedrijven",
        _t_rooftopPVCompaniesDescription_Font, ALIGNMENT_LEFT );
    t_largeScalePV_ha = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 145.0, 0.0, 0.0,
        black,"#",
        _t_largeScalePV_ha_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_largeScalePV_ha_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_largeScalePVDescription = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 145.0, 0.0, 0.0,
        black,"Zon op land",
        _t_largeScalePVDescription_Font, ALIGNMENT_LEFT );
    txt_batteryDescription_default = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 250.0, 0.0, 0.0,
        black,"Batterijen",
        _txt_batteryDescription_default_Font, ALIGNMENT_LEFT );
    t_largeScaleWindDescription = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 175.0, 0.0, 0.0,
        black,"Wind op land",
        _t_largeScaleWindDescription_Font, ALIGNMENT_LEFT );
    t_largeScaleWind_MW = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 175.0, 0.0, 0.0,
        black,"#",
        _t_largeScaleWind_MW_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_largeScaleWind_MW_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_rooftopPVHouses_pct = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 110.0, 0.0, 0.0,
        black,"#",
        _t_rooftopPVHouses_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_rooftopPVHouses_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_rooftopPVHousesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 110.0, 0.0, 0.0,
        black,"Zon op dak huizen",
        _t_rooftopPVHousesDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_rooftopPVHousesDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdPV = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 110.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdPV_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdPV, 0, clickx, clicky );
      }
    };
    i_landPV = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 145.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_landPV, 0, clickx, clicky );
      }
    };
    i_companyPV = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 80.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyPV, 0, clickx, clicky );
      }
    };
    i_electricityReduction = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 20.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_electricityReduction, 0, clickx, clicky );
      }
    };
    i_landWind = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 175.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_landWind, 0, clickx, clicky );
      }
    };
    t_collectiveBatteries_default = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 275.0, 0.0, 0.0,
        black,"#",
        _t_collectiveBatteries_default_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_collectiveBatteries_default_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_curtailmentDescription_default = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 210.0, 0.0, 0.0,
        black,"Curtailment opwek",
        _txt_curtailmentDescription_default_Font, ALIGNMENT_LEFT );
    txt_collectiveBatteryDescription_default = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 275.0, 0.0, 0.0,
        black,"Collectieve batterijen",
        _txt_collectiveBatteryDescription_default_Font, ALIGNMENT_LEFT );
    i_curtailment_default = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 210.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_curtailment_default, 0, clickx, clicky );
      }
    };
    i_collectiveBatteries_default = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 275.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_collectiveBatteries_default, 0, clickx, clicky );
      }
    };
    rect_PVFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,40.0, 670.0, 0.0, 0.0,
            gold, white,
			310.0, 290.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_ProductionFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,190.0, 680.0, 0.0, 0.0,
        black,"Production Functions",
        _txt_ProductionFunctionsDescription_Font, ALIGNMENT_CENTER );
    rect_demandFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,40.0, 540.0, 0.0, 0.0,
            olive, white,
			310.0, 120.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_demandFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,190.0, 550.0, 0.0, 0.0,
        black,"Demand Functions",
        _t_demandFunctionsDescription_Font, ALIGNMENT_CENTER );
    t_genericFunctions = new ShapeText(
        SHAPE_DRAW_2D, false,100.0, 500.0, 0.0, 0.0,
        black,"Generic Functions",
        _t_genericFunctions_Font, ALIGNMENT_LEFT );
    rect_electricityDemandSliders_Businesspark = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, lightYellow,
			370.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_electricityDemandReduction_pct_Businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 20.0, 0.0, 0.0,
        black,"#",
        _t_electricityDemandReduction_pct_Businesspark_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_electricityDemandReduction_pct_Businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_electricityDemandReductionDescription_Businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, 20.0, 0.0, 0.0,
        black,"Besparing verbruik",
        _txt_electricityDemandReductionDescription_Businesspark_Font, ALIGNMENT_LEFT );
    txt_productionDescription_Businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 55.0, 0.0, 0.0,
        black,"Opwek",
        _txt_productionDescription_Businesspark_Font, ALIGNMENT_LEFT );
    t_rooftopPVCompanies_pct_Businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 80.0, 0.0, 0.0,
        black,"#",
        _t_rooftopPVCompanies_pct_Businesspark_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_rooftopPVCompanies_pct_Businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_rooftopPVCompaniesDescription_Businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 80.0, 0.0, 0.0,
        black,"Zon op dak bedrijven",
        _txt_rooftopPVCompaniesDescription_Businesspark_Font, ALIGNMENT_LEFT );
    t_largeScalePV_ha_Businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 115.0, 0.0, 0.0,
        black,"#",
        _t_largeScalePV_ha_Businesspark_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_largeScalePV_ha_Businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_largeScalePVDescription_Businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 115.0, 0.0, 0.0,
        black,"Zon op land",
        _txt_largeScalePVDescription_Businesspark_Font, ALIGNMENT_LEFT );
    txt_batteryDescription_businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 230.0, 0.0, 0.0,
        black,"Batterijen",
        _txt_batteryDescription_businesspark_Font, ALIGNMENT_LEFT );
    txt_largeScaleWindDescription_Businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 150.0, 0.0, 0.0,
        black,"Wind op land",
        _txt_largeScaleWindDescription_Businesspark_Font, ALIGNMENT_LEFT );
    t_largeScaleWind_MW_Businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 150.0, 0.0, 0.0,
        black,"#",
        _t_largeScaleWind_MW_Businesspark_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_largeScaleWind_MW_Businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_landPV_Businesspark = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 115.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_landPV_Businesspark, 0, clickx, clicky );
      }
    };
    i_companyPV_Businesspark = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 80.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companyPV_Businesspark, 0, clickx, clicky );
      }
    };
    i_electricityReduction_Businesspark = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 20.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_electricityReduction_Businesspark, 0, clickx, clicky );
      }
    };
    i_landWind_Businesspark = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 150.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_landWind_Businesspark, 0, clickx, clicky );
      }
    };
    txt_curtailmentDescription_businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 185.0, 0.0, 0.0,
        black,"Curtailment opwek",
        _txt_curtailmentDescription_businesspark_Font, ALIGNMENT_LEFT );
    i_curtailment_businesspark = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 185.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_curtailment_businesspark, 0, clickx, clicky );
      }
    };
    i_collectiveBatteries_businesspark = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 260.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_collectiveBatteries_businesspark, 0, clickx, clicky );
      }
    };
    txt_collectiveBatteryDescription_businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 260.0, 0.0, 0.0,
        black,"Collectieve batterijen",
        _txt_collectiveBatteryDescription_businesspark_Font, ALIGNMENT_LEFT );
    t_collectiveBatteries_businesspark = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 260.0, 0.0, 0.0,
        black,"#",
        _t_collectiveBatteries_businesspark_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_collectiveBatteries_businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    rect_electricityDemandSlidersResidentialArea = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, lightYellow,
			370.0, 350.0, 10.0, 5.0, LINE_STYLE_SOLID );
    t_electricityDemandIncreaseResidentialArea_pct = new ShapeText(
        SHAPE_DRAW_2D, true,250.0, 160.0, 0.0, 0.0,
        black,"0%",
        _t_electricityDemandIncreaseResidentialArea_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_electricityDemandIncreaseResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdPVResidentialArea_pct = new ShapeText(
        SHAPE_DRAW_2D, true,250.0, 50.0, 0.0, 0.0,
        black,"10%",
        _t_householdPVResidentialArea_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdPVResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdPVResidentialAreaDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 50.0, 0.0, 0.0,
        black,"Aandeel huizen met PV",
        _t_householdPVResidentialAreaDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdPVResidentialAreaDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_electricitDemandSlidersResidentialAreaDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 20.0, 0.0, 0.0,
        black,"Huizen",
        _txt_electricitDemandSlidersResidentialAreaDescription_Font, ALIGNMENT_LEFT );
    t_householdBatteriesResidentialAreaDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 80.0, 0.0, 0.0,
        black,"Welke een batterij hebben",
        _t_householdBatteriesResidentialAreaDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdBatteriesResidentialAreaDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdBatteriesResidentialArea_pct = new ShapeText(
        SHAPE_DRAW_2D, true,250.0, 80.0, 0.0, 0.0,
        black,"0%",
        _t_householdBatteriesResidentialArea_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdBatteriesResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gridBatteriesResidentialAreaDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 306.0, 0.0, 0.0,
        black,"Trafo batterij capaciteit",
        _t_gridBatteriesResidentialAreaDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_gridBatteriesResidentialAreaDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_gridBatteriesResidentialArea_kW = new ShapeText(
        SHAPE_DRAW_2D, true,251.0, 305.0, 0.0, 0.0,
        black,"0 kWh",
        _t_gridBatteriesResidentialArea_kW_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_gridBatteriesResidentialArea_kW_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_electricityDemandIncreaseResidentialAreaDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 160.0, 0.0, 0.0,
        black,"Groei in elektr. consumptie",
        _t_electricityDemandIncreaseResidentialAreaDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_electricityDemandIncreaseResidentialAreaDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdElectricCookingResidentialAreaDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 120.0, 0.0, 0.0,
        black,"Aandeel die elektrisch koken",
        _t_householdElectricCookingResidentialAreaDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdElectricCookingResidentialAreaDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_householdElectricCookingResidentialArea_pct = new ShapeText(
        SHAPE_DRAW_2D, true,250.0, 120.0, 0.0, 0.0,
        black,"0%",
        _t_householdElectricCookingResidentialArea_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_householdElectricCookingResidentialArea_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdRooftopPV = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 180.0, 50.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdRooftopPV_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdRooftopPV, 0, clickx, clicky );
      }
    };
    i_householdBatteries = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 180.0, 80.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdBatteries_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdBatteries, 0, clickx, clicky );
      }
    };
    i_householdElectricCooking = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 180.0, 120.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdElectricCooking_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdElectricCooking, 0, clickx, clicky );
      }
    };
    i_householdElectricityGrowth = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 180.0, 160.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdElectricityGrowth_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdElectricityGrowth, 0, clickx, clicky );
      }
    };
    i_householdNeighbourhoodBatteries = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 305.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdNeighbourhoodBatteries_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdNeighbourhoodBatteries, 0, clickx, clicky );
      }
    };
    t_largeScalePV_ha_Residential = new ShapeText(
        SHAPE_DRAW_2D, true,250.0, 235.0, 0.0, 0.0,
        black,"0 ha",
        _t_largeScalePV_ha_Residential_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_largeScalePV_ha_Residential_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_largeScalePVDescription_Residential = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 235.0, 0.0, 0.0,
        black,"Zon op land",
        _txt_largeScalePVDescription_Residential_Font, ALIGNMENT_LEFT );
    txt_largeScaleWindDescription_Residential = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 270.0, 0.0, 0.0,
        black,"Wind op land",
        _txt_largeScaleWindDescription_Residential_Font, ALIGNMENT_LEFT );
    t_largeScaleWind_MW_Residential = new ShapeText(
        SHAPE_DRAW_2D, true,250.0, 270.0, 0.0, 0.0,
        black,"0 MW",
        _t_largeScaleWind_MW_Residential_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_largeScaleWind_MW_Residential_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_landPV_Residential = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 235.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_landPV_Residential, 0, clickx, clicky );
      }
    };
    i_landWind_Residential = new ShapeImage(
		tabElectricity.this, SHAPE_DRAW_2D3D, true, 160.0, 270.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_landWind_Residential, 0, clickx, clicky );
      }
    };
    txt_electricityTabResidential_Collective = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 205.0, 0.0, 0.0,
        black,"Collectief",
        _txt_electricityTabResidential_Collective_Font, ALIGNMENT_LEFT );
    rect_trafoReinforcement = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, lightYellow,
			370.0, 350.0, 10.0, 1.0, LINE_STYLE_SOLID );
  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP1_xjal() {
    t_addTrafoDescription = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, 70.0, 0.0, 0.0,
        black,"Trafostation uitbreiden/bijplaatsen",
        _t_addTrafoDescription_Font, ALIGNMENT_LEFT );
    t_minTrafoReinforcement = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 120.0, 0.0, 0.0,
        black,"min",
        _t_minTrafoReinforcement_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_minTrafoReinforcement_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_maxTrafoReinforcement = new ShapeText(
        SHAPE_DRAW_2D, true,170.0, 120.0, 0.0, 0.0,
        black,"max",
        _t_maxTrafoReinforcement_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_maxTrafoReinforcement_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_trafoReinforcementValue = new ShapeText(
        SHAPE_DRAW_2D, true,95.0, 120.0, 0.0, 0.0,
        black,"value",
        _t_trafoReinforcementValue_Font, ALIGNMENT_CENTER ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_trafoReinforcementValue_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_currentTrafoReinforcement = new ShapeText(
        SHAPE_DRAW_2D, true,200.0, 70.0, 0.0, 0.0,
        black,"Huidige LS-capaciteit: 300 kVA",
        _t_currentTrafoReinforcement_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_currentTrafoReinforcement_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    line_closeTrafoReinforcement1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 353.0, 17.0, 0.0, lightGrey,
 		12.0,	-12.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    line_closeTrafoReinforcement2 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 365.0, 17.0, 0.0, lightGrey,
 		-12.0,	-12.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );
    t_titleTrafoReinforcement = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 21.0, 0.0, 0.0,
        black,"Trafostation uitbereiding",
        _t_titleTrafoReinforcement_Font, ALIGNMENT_LEFT );
    rect_batteryFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,39.0, 991.0, 0.0, 0.0,
            teal, white,
			311.0, 109.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_batteryFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,189.0, 996.0, 0.0, 0.0,
        black,"Battery Functions",
        _t_batteryFunctionsDescription_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_electricitySliders_default = new ShapeGroup( tabElectricity.this, SHAPE_DRAW_2D3D, true, -10.0, 0.0, 0.0, 0.0
	
	     , rect_electricityDemandSliders
	     , t_electricityDemandReduction_pct
	     , sl_electricityDemandReduction_pct
	     , t_electricityDemandReductionDescription
	     , txt_productionDescription
	     , t_rooftopPVCompanies_pct
	     , sl_rooftopPVCompanies_pct
	     , t_rooftopPVCompaniesDescription
	     , t_largeScalePV_ha
	     , sl_largeScalePV_ha
	     , t_largeScalePVDescription
	     , txt_batteryDescription_default
	     , sl_largeScaleWind_MW
	     , t_largeScaleWindDescription
	     , t_largeScaleWind_MW
	     , t_rooftopPVHouses_pct
	     , sl_rooftopPVHouses_pct
	     , t_rooftopPVHousesDescription
	     , i_householdPV
	     , i_landPV
	     , i_companyPV
	     , i_electricityReduction
	     , i_landWind
	     , t_collectiveBatteries_default
	     , sl_collectiveBattery_MWh_default
	     , txt_curtailmentDescription_default
	     , txt_collectiveBatteryDescription_default
	     , cb_curtailment_default
	     , i_curtailment_default
	     , i_collectiveBatteries_default );
    }
    gr_electricitySliders_default.setVisible( false );
    {
    gr_electricitySliders_businesspark = new ShapeGroup( tabElectricity.this, SHAPE_DRAW_2D3D, true, 400.0, 0.0, 0.0, 0.0
	
	     , rect_electricityDemandSliders_Businesspark
	     , t_electricityDemandReduction_pct_Businesspark
	     , sl_electricityDemandReduction_pct_Businesspark
	     , txt_electricityDemandReductionDescription_Businesspark
	     , txt_productionDescription_Businesspark
	     , t_rooftopPVCompanies_pct_Businesspark
	     , sl_rooftopPVCompanies_pct_Businesspark
	     , txt_rooftopPVCompaniesDescription_Businesspark
	     , t_largeScalePV_ha_Businesspark
	     , sl_largeScalePV_ha_Businesspark
	     , txt_largeScalePVDescription_Businesspark
	     , txt_batteryDescription_businesspark
	     , sl_largeScaleWind_MW_Businesspark
	     , txt_largeScaleWindDescription_Businesspark
	     , t_largeScaleWind_MW_Businesspark
	     , i_landPV_Businesspark
	     , i_companyPV_Businesspark
	     , i_electricityReduction_Businesspark
	     , i_landWind_Businesspark
	     , txt_curtailmentDescription_businesspark
	     , cb_curtailment_businesspark
	     , i_curtailment_businesspark
	     , i_collectiveBatteries_businesspark
	     , txt_collectiveBatteryDescription_businesspark
	     , t_collectiveBatteries_businesspark
	     , sl_collectiveBattery_MWh_businesspark ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_electricitySliders_businesspark_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_electricitySliders_businesspark.setVisible( false );
    {
    gr_electricitySliders_residential = new ShapeGroup( tabElectricity.this, SHAPE_DRAW_2D3D, true, 800.0, 0.0, 0.0, 0.0
	
	     , rect_electricityDemandSlidersResidentialArea
	     , t_electricityDemandIncreaseResidentialArea_pct
	     , t_householdPVResidentialArea_pct
	     , sl_householdPVResidentialArea_pct
	     , t_householdPVResidentialAreaDescription
	     , txt_electricitDemandSlidersResidentialAreaDescription
	     , t_householdBatteriesResidentialAreaDescription
	     , sl_householdBatteriesResidentialArea_pct
	     , t_householdBatteriesResidentialArea_pct
	     , sl_gridBatteriesResidentialArea_kWh
	     , t_gridBatteriesResidentialAreaDescription
	     , t_gridBatteriesResidentialArea_kW
	     , t_electricityDemandIncreaseResidentialAreaDescription
	     , sl_electricityDemandIncreaseResidentialArea_pct
	     , t_householdElectricCookingResidentialAreaDescription
	     , sl_householdElectricCookingResidentialArea_pct
	     , t_householdElectricCookingResidentialArea_pct
	     , button_trafoReinforcement
	     , i_householdRooftopPV
	     , i_householdBatteries
	     , i_householdElectricCooking
	     , i_householdElectricityGrowth
	     , i_householdNeighbourhoodBatteries
	     , t_largeScalePV_ha_Residential
	     , sl_largeScalePV_ha_Residential
	     , txt_largeScalePVDescription_Residential
	     , sl_largeScaleWind_MW_Residential
	     , txt_largeScaleWindDescription_Residential
	     , t_largeScaleWind_MW_Residential
	     , i_landPV_Residential
	     , i_landWind_Residential
	     , txt_electricityTabResidential_Collective ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_electricitySliders_residential_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_electricitySliders_residential.setVisible( false );
    {
    gr_trafoReinforcement = new ShapeGroup( tabElectricity.this, SHAPE_DRAW_2D3D, true, 1200.0, 0.0, 0.0, 0.0
	
	     , rect_trafoReinforcement
	     , t_addTrafoDescription
	     , sl_trafoReinforcement
	     , t_minTrafoReinforcement
	     , t_maxTrafoReinforcement
	     , t_trafoReinforcementValue
	     , t_confirmTrafoReinforcement
	     , t_currentTrafoReinforcement
	     , t_resetTrafoReinforcement
	     , t_closeTrafoReinforcement
	     , line_closeTrafoReinforcement1
	     , line_closeTrafoReinforcement2
	     , t_titleTrafoReinforcement ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_trafoReinforcement_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_trafoReinforcement.setVisible( false );
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
  public tabElectricity( Engine engine, Agent owner, AgentList<? extends tabElectricity> ownerPopulation ) {
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
  public tabElectricity() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public tabElectricity( double p_currentPVOnLand_ha, double p_currentWindTurbines_MW, double p_currentTotalGridBatteryCapacity_MWh ) {
    markParametersAreSet();
    this.p_currentPVOnLand_ha = p_currentPVOnLand_ha;
    this.p_currentWindTurbines_MW = p_currentWindTurbines_MW;
    this.p_currentTotalGridBatteryCapacity_MWh = p_currentTotalGridBatteryCapacity_MWh;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_tabElectricity_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "zerointerfaceloader.tabElectricity.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( tabElectricity.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    sl_electricityDemandReduction_pct.setValueToDefault();
    sl_rooftopPVCompanies_pct.setValueToDefault();
    sl_largeScalePV_ha.setValueToDefault();
    sl_largeScaleWind_MW.setValueToDefault();
    sl_rooftopPVHouses_pct.setValueToDefault();
    sl_collectiveBattery_MWh_default.setValueToDefault();
    sl_electricityDemandReduction_pct_Businesspark.setValueToDefault();
    sl_rooftopPVCompanies_pct_Businesspark.setValueToDefault();
    sl_largeScalePV_ha_Businesspark.setValueToDefault();
    sl_largeScaleWind_MW_Businesspark.setValueToDefault();
    sl_collectiveBattery_MWh_businesspark.setValueToDefault();
    sl_householdPVResidentialArea_pct.setValueToDefault();
    sl_householdBatteriesResidentialArea_pct.setValueToDefault();
    sl_gridBatteriesResidentialArea_kWh.setValueToDefault();
    sl_electricityDemandIncreaseResidentialArea_pct.setValueToDefault();
    sl_householdElectricCookingResidentialArea_pct.setValueToDefault();
    sl_largeScalePV_ha_Residential.setValueToDefault();
    sl_largeScaleWind_MW_Residential.setValueToDefault();
    sl_trafoReinforcement.setValueToDefault();
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
    setupPlainVariables_tabElectricity_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_tabElectricity_xjal() {
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

  public AgentList<? extends tabElectricity> getPopulation() {
    return (AgentList<? extends tabElectricity>) super.getPopulation();
  }

  public List<? extends tabElectricity> agentsInRange( double distance ) {
    return (List<? extends tabElectricity>) super.agentsInRange( distance );
  }

  // Additional class code

// Default Sliders
public ShapeGroup getGroupElectricityDemandSliders() {
	return this.gr_electricitySliders_default;
}

public ShapeGroup getGroupElectricityDemandSliders_Businesspark() {
	return this.gr_electricitySliders_businesspark;
}

public ShapeGroup getGroupElectricityDemandSliders_ResidentialArea() {
	return this.gr_electricitySliders_residential;
}
public ShapeSlider getSliderElectricityDemandReduction_pct() {
	return this.sl_electricityDemandReduction_pct;
}

public ShapeSlider getSliderRooftopPVCompanies_pct(){
	return this.sl_rooftopPVCompanies_pct;
}

public ShapeSlider getSliderLargeScalePV_ha(){
	return this.sl_largeScalePV_ha;
}

public ShapeSlider getSliderLargeScalePV_ha_Businesspark(){
	return this.sl_largeScalePV_ha_Businesspark;
}

public ShapeSlider getWindSlider(){
	return this.sl_largeScaleWind_MW;
}

public ShapeSlider getSl_rooftopPVCompanies_pct_Businesspark(){
	return this.sl_rooftopPVCompanies_pct_Businesspark;
}

//Households/Residential Area
public ShapeSlider getSliderRooftopPVHouses_pct(){
	return this.sl_rooftopPVHouses_pct;
}

public ShapeSlider getSliderHouseholdPVResidentialArea_pct(){
	return this.sl_householdPVResidentialArea_pct;
}

public ShapeSlider getSliderHouseholdBatteriesResidentialArea_pct(){
	return this.sl_householdBatteriesResidentialArea_pct;
}

public ShapeSlider getSliderHouseholdElectricCookingResidentialArea_pct(){
	return this.sl_householdElectricCookingResidentialArea_pct;
}

public ShapeSlider getSliderElectricityDemandIncreaseResidentialArea_pct(){
	return this.sl_electricityDemandIncreaseResidentialArea_pct;
}

public ShapeSlider getSliderGridBatteriesResidentialArea_kWh(){
	return this.sl_gridBatteriesResidentialArea_kWh;
} 
  // End of additional class code

}
