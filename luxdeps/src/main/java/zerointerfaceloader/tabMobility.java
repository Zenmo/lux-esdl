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

import org.apache.commons.lang3.tuple.Triple;
import java.util.stream.Collectors; 

public class tabMobility extends zerointerfaceloader.tabArea
{
  // Parameters
  // Plain Variables

  public 
int 
 v_totalNumberOfGhostVehicle_Trucks;
  public 
int 
 v_totalNumberOfGhostVehicle_Vans;
  public 
int 
 v_totalNumberOfGhostVehicle_Cars;
  public 
int 
 v_currentPageIndex;

  // Collection Variables
  public 
ArrayList <
ShapeGroup > c_loadedPageGroups = new ArrayList<ShapeGroup>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( tabMobility.class );

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
   * Function that calculates the values of the other sliders and sets them without calling an action. Takes as parameters the index of the slider which should not be touched as well as all the slider objects. HydrogenVehicle slider is optional and an argument of null can be passed. 
   */
  protected void f_setVehicleSliders( int sliderIndex, ShapeSlider electricSlider, ShapeSlider hydrogenSlider, ShapeSlider fossilFuelSlider ) { 

double pct_electric = electricSlider.getValue();
double pct_hydrogen = 0;
double pct_fossilFuel = fossilFuelSlider.getValue();
if (hydrogenSlider != null) {
	pct_hydrogen = hydrogenSlider.getValue();
}
 
 
//Set array with pct values
double pctArray[]={pct_electric, pct_hydrogen, pct_fossilFuel};
double pctExcess = Arrays.stream(pctArray).sum() - 100;
for (int i = 0; i<pctArray.length; i++){
	if (!(i==(int)sliderIndex)) {
		pctArray[i] = max(0,pctArray[i] - pctExcess);
		pctExcess = Arrays.stream(pctArray).sum() - 100;
	}
}
if (pctExcess != 0) {
	traceln("Sliders don't add up to 100%!");
}
 
//Set Sliders
electricSlider.setValue(pctArray[0], false);
if (hydrogenSlider != null) {
	hydrogenSlider.setValue(pctArray[1], false);
}
fossilFuelSlider.setValue(pctArray[2], false);

/*
double pct_fossilFuel = fossilFuelSlider.getValue();
double pct_electric = electricSlider.getValue();
double pct_hydrogen = 0;
if (hydrogenSlider != null) {
	pct_hydrogen = hydrogenSlider.getValue();
}
 
 
//Set array with pct values
double pctArray[]={pct_fossilFuel, pct_electric, pct_hydrogen};
double pctExcess = Arrays.stream(pctArray).sum() - 100;
for (int i = 0; i<pctArray.length; i++){
	if (!(i==(int)sliderIndex)) {
		pctArray[i] = max(0,pctArray[i] - pctExcess);
		pctExcess = Arrays.stream(pctArray).sum() - 100;
	}
}
if (pctExcess != 0) {
	traceln("Sliders don't add up to 100%!");
}
 
//Set Sliders
fossilFuelSlider.setValue(pctArray[0], false);
electricSlider.setValue(pctArray[1], false);
if (hydrogenSlider != null) {
	hydrogenSlider.setValue(pctArray[2], false);
}
*/ 
  }

  /**
   * Function that reduces the distance of all triptrackers of vehicles. Takes as arguments a list of GridConnections to effect and a percentage to reduce by compared to the default distance value of the triptrackers.
   */
  protected void f_setDemandReduction( List<GridConnection> gcList, double demandReduction_pct ) { 

// TODO: when new triptrackers are created, for example in the company ui sliders,
// make sure they have this distance scaling fraction!

double scalingFactor = 1 - demandReduction_pct/100;

for (GridConnection gc : gcList) {
	for (I_Vehicle vehicle : gc.c_vehicleAssets) {
		vehicle.getTripTracker().distanceScaling_fr = scalingFactor;
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  protected 
Triple<Integer, Integer, Integer> 
 f_calculateNumberOfGhostVehicles( List<GridConnection> gcList ) { 

Integer numberOfGhostVehicle_Cars = 0;
Integer numberOfGhostVehicle_Vans = 0;
Integer numberOfGhostVehicle_Trucks = 0;

for (GridConnection gc : gcList ) {
	if(gc.v_hasQuarterHourlyValues && gc.v_isActive){
		numberOfGhostVehicle_Cars += zero_Interface.c_scenarioMap_Current.get(gc.p_uid).getCurrentEVCars();
		numberOfGhostVehicle_Vans += zero_Interface.c_scenarioMap_Current.get(gc.p_uid).getCurrentEVVans();
		numberOfGhostVehicle_Trucks += zero_Interface.c_scenarioMap_Current.get(gc.p_uid).getCurrentEVTrucks();
	}
}


return Triple.of(numberOfGhostVehicle_Cars, numberOfGhostVehicle_Vans, numberOfGhostVehicle_Trucks); 
  }

  protected void f_setPetroleumFuelTrucks( List<GridConnection> gcList, ShapeSlider sliderElectricTrucks, ShapeSlider sliderHydrogenTrucks, ShapeSlider sliderFossilFuelTrucks ) { 

double pctPetroleumFuelTrucksGoal = sliderFossilFuelTrucks.getValue();

int numberOfGhostVehicle_Trucks = f_calculateNumberOfGhostVehicles(gcList).getRight();
Triple<Integer, Integer, Integer> triple = f_calculateCurrentNumberOfTrucks( gcList, numberOfGhostVehicle_Trucks );

int nbEtruckCurrent = triple.getLeft();
int nbHydrogentrucksCurrent = triple.getMiddle();
int nbPetroleumFueltrucksCurrent = triple.getRight();
int total_vehicles = nbEtruckCurrent + nbHydrogentrucksCurrent + nbPetroleumFueltrucksCurrent;

int nbPetroleumFuelTrucksGoal = roundToInt(total_vehicles*pctPetroleumFuelTrucksGoal/100.0);
boolean finishedLookingThroughElectricTrucks = false;

if (nbPetroleumFueltrucksCurrent < nbPetroleumFuelTrucksGoal) {
	// Add PetroleumFuel Trucks
	while ( nbPetroleumFueltrucksCurrent < nbPetroleumFuelTrucksGoal ) {
		if ( nbEtruckCurrent > numberOfGhostVehicle_Trucks && !finishedLookingThroughElectricTrucks ) {
			// replace electric truck with a petroleumFuel truck
			if (!f_electricToPetroleumFuelTruck(gcList)) {
				finishedLookingThroughElectricTrucks = true;
			}
			else {
				nbPetroleumFueltrucksCurrent++;
				nbEtruckCurrent--;
			}
		}
		else{// ( nbHydrogentrucksCurrent > 0 ) {
			// replace hydrogen truck with petroleumFuel truck
			if (!f_hydrogenToPetroleumFuelTruck(gcList)) {
				f_setTruckSlidersToCurrentEngineState(gcList, sliderElectricTrucks, sliderHydrogenTrucks, sliderFossilFuelTrucks);
				return;
			}
			nbPetroleumFueltrucksCurrent++;
			nbHydrogentrucksCurrent--;
		}
		/*
		else {
			throw new RuntimeException("Can not add another petroleumFuel vehicle as there are no other vehicles to replace.");
		}
		*/
	}
}
else {
	// Remove PetroleumFuel Trucks
	while ( nbPetroleumFueltrucksCurrent > nbPetroleumFuelTrucksGoal ) {
		// replace a petroleumFuel truck with an electric truck
		if (!f_petroleumFuelToElectricTruck(gcList)) {
			f_setTruckSlidersToCurrentEngineState(gcList, sliderElectricTrucks, sliderHydrogenTrucks, sliderFossilFuelTrucks);
			return;
		}
		nbPetroleumFueltrucksCurrent--;
		nbEtruckCurrent++;
	}
}


//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}
zero_Interface.f_resetSettings(); 
  }

  protected void f_setHydrogenTrucks( List<GridConnection> gcList, ShapeSlider sliderElectricTrucks, ShapeSlider sliderHydrogenTrucks, ShapeSlider sliderFossilFuelTrucks ) { 

double pctHydrogenTrucksGoal = sliderHydrogenTrucks.getValue();

int numberOfGhostVehicle_Trucks = f_calculateNumberOfGhostVehicles(gcList).getRight();
Triple<Integer, Integer, Integer> triple = f_calculateCurrentNumberOfTrucks( gcList, numberOfGhostVehicle_Trucks );

int nbEtruckCurrent = triple.getLeft();
int nbHydrogentrucksCurrent = triple.getMiddle();
int nbPetroleumFueltrucksCurrent = triple.getRight();
int total_vehicles = nbEtruckCurrent + nbHydrogentrucksCurrent + nbPetroleumFueltrucksCurrent;

int nbHydrogenTrucksGoal = roundToInt(total_vehicles*pctHydrogenTrucksGoal/100.0);
boolean finishedLookingThroughPetroleumFuelTrucks = false;

if (nbHydrogentrucksCurrent < nbHydrogenTrucksGoal) {
	// Add Hydrogen Trucks
	while ( nbHydrogentrucksCurrent < nbHydrogenTrucksGoal && !finishedLookingThroughPetroleumFuelTrucks ) {
		if ( nbPetroleumFueltrucksCurrent > 0 ) {
			// replace a petroleumFuel truck with a hydrogen truck
			if (!f_petroleumFuelToHydrogenTruck(gcList)) {
				finishedLookingThroughPetroleumFuelTrucks = true;
			}
			else {
				nbHydrogentrucksCurrent++;
				nbPetroleumFueltrucksCurrent--;
			}
		}
		else{// ( nbEtruckCurrent > v_totalNumberOfGhostVehicle_Trucks ) {
			// replace an electric truck with a hydrogen truck
			if (!f_electricToHydrogenTruck(gcList)) {
				f_setTruckSlidersToCurrentEngineState(gcList, sliderElectricTrucks, sliderHydrogenTrucks, sliderFossilFuelTrucks);
				return;
			}
			nbHydrogentrucksCurrent++;
			nbEtruckCurrent--;	
		}
		/*else {
			throw new RuntimeException("Can not add another hydrogen vehicle as there are no other vehicles to replace.");
		}*/
	}
}
else {
	// Remove Hydrogen Trucks
	while ( nbHydrogentrucksCurrent > nbHydrogenTrucksGoal ) {
		// replace a hydrogen truck with a petroleumFuel truck
		if (!f_hydrogenToPetroleumFuelTruck(gcList)) {
			f_setTruckSlidersToCurrentEngineState(gcList, sliderElectricTrucks, sliderHydrogenTrucks, sliderFossilFuelTrucks);
			return;
		}
		nbHydrogentrucksCurrent--;
		nbPetroleumFueltrucksCurrent++;
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  protected void f_setElectricTrucks( List<GridConnection> gcList, ShapeSlider sliderElectricTrucks, ShapeSlider sliderHydrogenTrucks, ShapeSlider sliderFossilFuelTrucks ) { 

double pctElectricTrucksGoal = sliderElectricTrucks.getValue();

int numberOfGhostVehicle_Trucks = f_calculateNumberOfGhostVehicles(gcList).getRight();
Triple<Integer, Integer, Integer> triple = f_calculateCurrentNumberOfTrucks( gcList, numberOfGhostVehicle_Trucks );

int nbEtruckCurrent = triple.getLeft();
int nbHydrogentrucksCurrent = triple.getMiddle();
int nbPetroleumFueltrucksCurrent = triple.getRight();
int total_vehicles = nbEtruckCurrent + nbHydrogentrucksCurrent + nbPetroleumFueltrucksCurrent;

int nbElectricTrucksGoal = roundToInt(total_vehicles*pctElectricTrucksGoal/100.0);
boolean finishedLookingThroughPetroleumFuelTrucks = false;

if (nbEtruckCurrent < nbElectricTrucksGoal) {
	// Add Electric Trucks
	while ( nbEtruckCurrent < nbElectricTrucksGoal && !finishedLookingThroughPetroleumFuelTrucks ) {
		if ( nbPetroleumFueltrucksCurrent > 0 ) {
			// replace a petroleumFuel truck with an electric truck
			if (!f_petroleumFuelToElectricTruck(gcList)) {
				finishedLookingThroughPetroleumFuelTrucks = true;
			}
			else {
				nbEtruckCurrent++;
				nbPetroleumFueltrucksCurrent--;
			}
		}
		else{// if ( nbHydrogentrucksCurrent > 0 ) {
			// replace a hydrogen truck with an electric truck
			if (!f_hydrogenToElectricTruck(gcList)) {
				f_setTruckSlidersToCurrentEngineState(gcList, sliderElectricTrucks, sliderHydrogenTrucks, sliderFossilFuelTrucks);
				return;
			}
			nbEtruckCurrent++;
			nbHydrogentrucksCurrent--;
		}
		/*else {
			throw new RuntimeException("Can not add another hydrogen vehicle as there are no other vehicles to replace.");
		}
		*/
	}
}
else {
	// Remove Electric Trucks
	while ( nbEtruckCurrent > nbElectricTrucksGoal ) {
		// replace an electric truck with a petroleumFuel truck
		if (!f_electricToPetroleumFuelTruck(gcList)) {
			f_setTruckSlidersToCurrentEngineState(gcList, sliderElectricTrucks, sliderHydrogenTrucks, sliderFossilFuelTrucks);
			return;
		}
		nbEtruckCurrent--;
		nbPetroleumFueltrucksCurrent++;
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}
zero_Interface.f_resetSettings(); 
  }

  protected 
boolean 
 f_petroleumFuelToElectricTruck( List<GridConnection> gcList ) { 

J_EAFuelVehicle petroleumFuelTruck = null;
boolean foundAdditionalVehicle = false;

// find the petroleumFuel truck to remove, search through additional vehicles first
for (GridConnection gc : gcList ) {
	if(gc instanceof GCUtility && gc.v_isActive){
		petroleumFuelTruck = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(gc.p_uid), p -> p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK);
		if ( petroleumFuelTruck != null ) {
			foundAdditionalVehicle = true;
			break;
		}
	}
}

// if no additional vehicle was found, search through the regular ordering of vehicles
if (!foundAdditionalVehicle) {	
	petroleumFuelTruck = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK && ((GridConnection)p.getOwner()).v_isActive && gcList.contains((GridConnection)p.getOwner()));
}
if (petroleumFuelTruck!=null) {
	GridConnection gc = (GridConnection)petroleumFuelTruck.getOwner();
		
	J_ActivityTrackerTrips tripTracker = petroleumFuelTruck.getTripTracker();
	boolean available = petroleumFuelTruck.getAvailability();
	zero_Interface.c_orderedVehicles.remove(petroleumFuelTruck);
	petroleumFuelTruck.removeEnergyAsset();

	// Re-add Electric vehicle
	double capacityElectric_kW = zero_Interface.energyModel.avgc_data.p_avgEVMaxChargePowerTruck_kW;
	double storageCapacity_kWh = zero_Interface.energyModel.avgc_data.p_avgEVStorageTruck_kWh;
	double initialStateOfCharge_fr = 1.0;
	double energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionTruck_kWhpkm;
	double vehicleScalingElectric = 1.0;
	J_EAEV electricTruck = new J_EAEV(gc, capacityElectric_kW, storageCapacity_kWh, initialStateOfCharge_fr, zero_Interface.energyModel.p_timeParameters, energyConsumption_kWhpkm, vehicleScalingElectric, OL_EnergyAssetType.ELECTRIC_TRUCK, tripTracker, available);  
	
	zero_Interface.c_orderedVehicles.add(0, electricTruck);
	
	//check if was additional vehicle in companyUI, if so: add to collection
	if(foundAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(gc.p_uid).add(electricTruck);
	}
	
	//Check if charging management is present if not: add default management
	if(gc.f_getCurrentChargingType() == OL_ChargingAttitude.NONE){
		gc.f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
	}
}

else {
	return false;
	//throw new RuntimeException("Numbers suggest there is a petroleumFuel truck left, but could not find it.");
}

return true; 
  }

  protected 
boolean 
 f_hydrogenToElectricTruck( List<GridConnection> gcList ) { 

J_EAFuelVehicle hydrogenTruck = null;
boolean foundAdditionalVehicle = false;

// find the hydrogen truck to remove, search through additional vehicles first
for (GridConnection gc : gcList ) {
	if(gc instanceof GCUtility && gc.v_isActive){
		hydrogenTruck = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(gc.p_uid), p -> p.getEAType() == OL_EnergyAssetType.HYDROGEN_TRUCK);
		if ( hydrogenTruck != null ) {
			foundAdditionalVehicle = true;
			break;
		}
	}
}

// if no additional vehicle was found, search through the regular ordering of vehicles
if (!foundAdditionalVehicle) {
	hydrogenTruck = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == OL_EnergyAssetType.HYDROGEN_TRUCK && ((GridConnection)p.getOwner()).v_isActive && gcList.contains((GridConnection)p.getOwner()));
}
if (hydrogenTruck!=null) {
	GridConnection gc = (GridConnection)hydrogenTruck.getOwner();
	
	J_ActivityTrackerTrips tripTracker = hydrogenTruck.getTripTracker();
	boolean available = true;
	available = hydrogenTruck.getAvailability();
	zero_Interface.c_orderedVehicles.remove(hydrogenTruck);
	hydrogenTruck.removeEnergyAsset();


	// Re-add Electric vehicle
	double capacityElectric_kW = zero_Interface.energyModel.avgc_data.p_avgEVMaxChargePowerTruck_kW;
	double storageCapacity_kWh = zero_Interface.energyModel.avgc_data.p_avgEVStorageTruck_kWh;
	double initialStateOfCharge_fr = 1.0;
	double energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionTruck_kWhpkm;
	double vehicleScalingElectric = 1.0;
	J_EAEV electricTruck = new J_EAEV(gc, capacityElectric_kW, storageCapacity_kWh, initialStateOfCharge_fr, zero_Interface.energyModel.p_timeParameters, energyConsumption_kWhpkm, vehicleScalingElectric, OL_EnergyAssetType.ELECTRIC_TRUCK, tripTracker, available);  

	zero_Interface.c_orderedVehicles.add(0, electricTruck);
	
	//check if was additional vehicle in companyUI, if so: add to collection
	if(foundAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(gc.p_uid).add(electricTruck);
	}
	
	//Check if charging management is present if not: add default management
	if(gc.f_getCurrentChargingType() == OL_ChargingAttitude.NONE){
		gc.f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
	}
}
else {
	return false;
	//throw new RuntimeException("Numbers suggest there is a hydrogen truck left, but could not find it.");
}

return true; 
  }

  protected 
boolean 
 f_electricToHydrogenTruck( List<GridConnection> gcList ) { 

J_EAEV electricTruck = null;
boolean foundAdditionalVehicle = false;

// find the electric truck to remove, search through additional vehicles first
for (GridConnection gc : gcList ) {
	if(gc instanceof GCUtility && gc.v_isActive){
		electricTruck = (J_EAEV)findFirst(zero_Interface.c_additionalVehicles.get(gc.p_uid), p -> p.getEAType() == OL_EnergyAssetType.ELECTRIC_TRUCK);
		if ( electricTruck != null ) {
			foundAdditionalVehicle = true;
			break;
		}
	}
}

// if no additional vehicle was found, search through the regular ordering of vehicle
if (!foundAdditionalVehicle) {
	electricTruck = (J_EAEV)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == OL_EnergyAssetType.ELECTRIC_TRUCK && ((GridConnection)p.getOwner()).v_isActive && gcList.contains((GridConnection)p.getOwner()));
}
if (electricTruck!=null) {
	GridConnection gc = (GridConnection)electricTruck.getOwner();
	
	J_ActivityTrackerTrips tripTracker = electricTruck.getTripTracker();
	boolean available = true;
	available = electricTruck.getAvailability();
	zero_Interface.c_orderedVehicles.remove(electricTruck);
	electricTruck.removeEnergyAsset();

	// Re-add hydrogen vehicle
	double energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgHydrogenConsumptionTruck_kWhpkm;			
	double vehicleScaling = 1.0;
	J_EAFuelVehicle hydrogenVehicle = new J_EAFuelVehicle(gc, energyConsumption_kWhpkm, zero_Interface.energyModel.p_timeParameters, vehicleScaling, OL_EnergyAssetType.HYDROGEN_TRUCK, tripTracker, OL_EnergyCarriers.HYDROGEN, available);				
	
	zero_Interface.c_orderedVehicles.add(0, hydrogenVehicle);
	
	//check if was additional vehicle in companyUI, if so: add to collection
	if(foundAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(gc.p_uid).add(hydrogenVehicle);
	}
}				
else {
	return false;
	//throw new RuntimeException("Numbers suggest there is an electric truck left, but could not find it.");
}

return true; 
  }

  protected 
boolean 
 f_petroleumFuelToHydrogenTruck( List<GridConnection> gcList ) { 

J_EAFuelVehicle petroleumFuelTruck = null;
boolean foundAdditionalVehicle = false;

// find the petroleumFuel truck to remove, search through additional vehicles first
for (GridConnection gc : gcList ) {
	if(gc instanceof GCUtility && gc.v_isActive){
		petroleumFuelTruck = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(gc.p_uid), p -> p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK);
		if ( petroleumFuelTruck != null ) {
			foundAdditionalVehicle = true;
			break;
		}
	}
}

// if no additional vehicle was found, search through the regular ordering of vehicles
if (!foundAdditionalVehicle) {
	petroleumFuelTruck = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK && ((GridConnection)p.getOwner()).v_isActive && gcList.contains((GridConnection)p.getOwner()));
}
if (petroleumFuelTruck!=null) {
	GridConnection gc = (GridConnection)petroleumFuelTruck.getOwner();
	
	J_ActivityTrackerTrips tripTracker = petroleumFuelTruck.getTripTracker();
	boolean available = true;
	available = petroleumFuelTruck.getAvailability();
	zero_Interface.c_orderedVehicles.remove(petroleumFuelTruck);
	petroleumFuelTruck.removeEnergyAsset();

	// Re-add hydrogen vehicle
	double energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgHydrogenConsumptionTruck_kWhpkm;			
	double vehicleScaling = 1.0;
	J_EAFuelVehicle hydrogenVehicle = new J_EAFuelVehicle(gc, energyConsumption_kWhpkm, zero_Interface.energyModel.p_timeParameters, vehicleScaling, OL_EnergyAssetType.HYDROGEN_TRUCK, tripTracker, OL_EnergyCarriers.HYDROGEN, available);				
	
	zero_Interface.c_orderedVehicles.add(0, hydrogenVehicle);
	
	//check if was additional vehicle in companyUI, if so: add to collection
	if(foundAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(gc.p_uid).add(hydrogenVehicle);
	}
}
else {
	return false;
	//throw new RuntimeException("Numbers suggest there is a petroleumFuel truck left, but could not find it.");
}

return true; 
  }

  protected 
boolean 
 f_electricToPetroleumFuelTruck( List<GridConnection> gcList ) { 

J_EAEV electricTruck = null;
boolean foundAdditionalVehicle = false;

// find the electric truck to remove, search through additional vehicles first
for (GridConnection gc : gcList ) {
	if(gc instanceof GCUtility && gc.v_isActive){
		electricTruck = (J_EAEV)findFirst(zero_Interface.c_additionalVehicles.get(gc.p_uid), p -> p.getEAType() == OL_EnergyAssetType.ELECTRIC_TRUCK);
		if ( electricTruck != null ) {
			foundAdditionalVehicle = true;
			break;
		}
	}
}

// if no additional vehicle was found, search through the regular ordering of vehicles
if (!foundAdditionalVehicle) {
	electricTruck = (J_EAEV)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == OL_EnergyAssetType.ELECTRIC_TRUCK && ((GridConnection)p.getOwner()).v_isActive && gcList.contains((GridConnection)p.getOwner()));
}
if ( electricTruck != null ) {
	GridConnection gc = (GridConnection)electricTruck.getOwner();
	
	J_ActivityTrackerTrips tripTracker = electricTruck.getTripTracker();
	boolean available = true;
	available = electricTruck.getAvailability();
	zero_Interface.c_orderedVehicles.remove(electricTruck);
	electricTruck.removeEnergyAsset();

	// Re-add petroleumFuel vehicle
	double energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgDieselConsumptionTruck_kWhpkm;
	double vehicleScaling = 1.0;
	J_EAFuelVehicle petroleumFuelVehicle = new J_EAFuelVehicle(gc, energyConsumption_kWhpkm, zero_Interface.energyModel.p_timeParameters, vehicleScaling, OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK, tripTracker, OL_EnergyCarriers.PETROLEUM_FUEL, available);
	
	zero_Interface.c_orderedVehicles.add(0, petroleumFuelVehicle);
	
	//check if was additional vehicle in companyUI, if so: add to collection
	if(foundAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(gc.p_uid).add(petroleumFuelVehicle);
	}
}
else {
	return false;
	//throw new RuntimeException("Numbers suggest there is an electric truck left, but could not find it.");
}

return true; 
  }

  protected 
boolean 
 f_hydrogenToPetroleumFuelTruck( List<GridConnection> gcList ) { 

J_EAFuelVehicle hydrogenTruck = null;
boolean foundAdditionalVehicle = false;

// find the hydrogen truck to remove, search through additional vehicles first
for (GridConnection gc : gcList ) {
	if(gc instanceof GCUtility && gc.v_isActive){
		hydrogenTruck = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(gc.p_uid), p -> p.getEAType() == OL_EnergyAssetType.HYDROGEN_TRUCK);
		if ( hydrogenTruck != null ) {
			foundAdditionalVehicle = true;
			break;
		}
	}
}

// if no additional vehicle was found, search through the regular ordering of vehicles
if (!foundAdditionalVehicle) {
	hydrogenTruck = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == OL_EnergyAssetType.HYDROGEN_TRUCK && ((GridConnection)p.getOwner()).v_isActive && gcList.contains((GridConnection)p.getOwner()));
}
if ( hydrogenTruck != null ) {
	GridConnection gc = (GridConnection)hydrogenTruck.getOwner();
	
	J_ActivityTrackerTrips tripTracker = hydrogenTruck.getTripTracker();
	boolean available = true;
	available = hydrogenTruck.getAvailability();
	zero_Interface.c_orderedVehicles.remove(hydrogenTruck);
	hydrogenTruck.removeEnergyAsset();

	// Re-add petroleumFuel vehicle
	double energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgDieselConsumptionTruck_kWhpkm;
	double vehicleScaling = 1.0;
	J_EAFuelVehicle petroleumFuelVehicle = new J_EAFuelVehicle(gc, energyConsumption_kWhpkm, zero_Interface.energyModel.p_timeParameters, vehicleScaling, OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK, tripTracker, OL_EnergyCarriers.PETROLEUM_FUEL, available);
	
	zero_Interface.c_orderedVehicles.add(0, petroleumFuelVehicle);
	
	//check if was additional vehicle in companyUI, if so: add to collection
	if(foundAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(gc.p_uid).add(petroleumFuelVehicle);
	}
}
else {
	return false;
	//throw new RuntimeException("Numbers suggest there is a hydrogen truck left, but could not find it.");
}

return true; 
  }

  protected void f_setTruckSlidersToCurrentEngineState( List<GridConnection> gcList, ShapeSlider sliderElectricTrucks, ShapeSlider sliderHydrogenTrucks, ShapeSlider sliderFossilFuelTrucks ) { 

List<J_EAEV> electricVehicles = new ArrayList<>();
List<J_EAFuelVehicle> petroleumVehicles = new ArrayList<>();
List<J_EAFuelVehicle> hydrogenVehicles = new ArrayList<>();
for (GridConnection gc : gcList) {
	if (gc.v_isActive) {
		electricVehicles.addAll(gc.c_electricVehicles);
		petroleumVehicles.addAll(gc.c_petroleumFuelVehicles);
		hydrogenVehicles.addAll(gc.c_hydrogenVehicles);
	}
}

int numberOfGhostVehicle_Trucks = f_calculateNumberOfGhostVehicles(gcList).getRight();

int nbElectricTrucksCurrent = count(electricVehicles, p->p.getEAType() == OL_EnergyAssetType.ELECTRIC_TRUCK && !(p.getOwner() instanceof GCPublicCharger)) + numberOfGhostVehicle_Trucks;
int nbPetroleumFueltrucksCurrent = count(petroleumVehicles, p->p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK);
int nbHydrogentrucksCurrent = count(hydrogenVehicles, p->p.getEAType() == OL_EnergyAssetType.HYDROGEN_TRUCK);

int totalVehicles = nbElectricTrucksCurrent + nbPetroleumFueltrucksCurrent + nbHydrogentrucksCurrent;



int pct_electricTruckSlider = roundToInt(100.0*nbElectricTrucksCurrent/totalVehicles);
int pct_hydrogenTruckSlider = roundToInt(100.0*nbHydrogentrucksCurrent/totalVehicles);
int pct_petroleumFuelTruckSlider = roundToInt(100.0*nbPetroleumFueltrucksCurrent/totalVehicles);

sliderElectricTrucks.setValue(pct_electricTruckSlider, false);
if ( sliderHydrogenTrucks != null ) {
	sliderHydrogenTrucks.setValue(pct_hydrogenTruckSlider, false);
}
else if ( sliderHydrogenTrucks == null && pct_hydrogenTruckSlider != 0 ) {
	throw new RuntimeException("Hydrogen trucks found but no hydrogen slider passed to f_setTruckSlidersToCurrentEngineState");
}sliderFossilFuelTrucks.setValue(pct_petroleumFuelTruckSlider, false);


//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}
zero_Interface.f_resetSettings(); 
  }

  protected 
Triple<Integer, Integer, Integer> 
 f_calculateCurrentNumberOfTrucks( List<GridConnection> gcList, Integer numberOfGhostVehicle_Trucks ) { 

if (numberOfGhostVehicle_Trucks == null) {
	numberOfGhostVehicle_Trucks = f_calculateNumberOfGhostVehicles(gcList).getRight();
}

int nbEtruckCurrent = numberOfGhostVehicle_Trucks;
int nbHydrogenTrucksCurrent = 0;
int nbPetroleumFuelTrucksCurrent = 0;
for ( GridConnection gc : gcList ) {
	nbEtruckCurrent += count(gc.c_electricVehicles, p->p.getEAType() == OL_EnergyAssetType.ELECTRIC_TRUCK && !(gc instanceof GCPublicCharger) && gc.v_isActive);
	nbHydrogenTrucksCurrent += count(gc.c_hydrogenVehicles, p->p.getEAType() == OL_EnergyAssetType.HYDROGEN_TRUCK && gc.v_isActive);
	nbPetroleumFuelTrucksCurrent += count(gc.c_petroleumFuelVehicles, p->p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_TRUCK && gc.v_isActive);
}

return Triple.of(nbEtruckCurrent, nbHydrogenTrucksCurrent, nbPetroleumFuelTrucksCurrent); 
  }

  protected 
boolean 
 f_petroleumFuelToElectricVan( List<GridConnection> gcList ) { 

J_EAFuelVehicle petroleumFuelVan = null;
boolean foundAdditionalVehicle = false;

// find the petroleumFuel van to remove, search through additional vehicles first
for (GridConnection gc : gcList ) {
	if(gc instanceof GCUtility && gc.v_isActive){
		petroleumFuelVan = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(gc.p_uid), p -> p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VAN);
		if ( petroleumFuelVan != null ) {
			foundAdditionalVehicle = true;
			break;
		}
	}
}

// if no additional vehicle was found, search through the regular ordering of vehicles
if (!foundAdditionalVehicle) {	
	petroleumFuelVan = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VAN && ((GridConnection)p.getOwner()).v_isActive && gcList.contains((GridConnection)p.getOwner()));
}
if (petroleumFuelVan!=null) {
	GridConnection gc = (GridConnection)petroleumFuelVan.getOwner();
		
	J_ActivityTrackerTrips tripTracker = petroleumFuelVan.getTripTracker();
	boolean available = petroleumFuelVan.getAvailability();
	zero_Interface.c_orderedVehicles.remove(petroleumFuelVan);
	petroleumFuelVan.removeEnergyAsset();

	// Re-add Electric vehicle
	double capacityElectric_kW = zero_Interface.energyModel.avgc_data.p_avgEVMaxChargePowerVan_kW;
	double storageCapacity_kWh = zero_Interface.energyModel.avgc_data.p_avgEVStorageVan_kWh;
	double initialStateOfCharge_fr = 1.0;
	double energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionVan_kWhpkm;
	double vehicleScalingElectric = 1.0;
	J_EAEV electricVan = new J_EAEV(gc, capacityElectric_kW, storageCapacity_kWh, initialStateOfCharge_fr, zero_Interface.energyModel.p_timeParameters, energyConsumption_kWhpkm, vehicleScalingElectric, OL_EnergyAssetType.ELECTRIC_VAN, tripTracker, available);  
	
	zero_Interface.c_orderedVehicles.add(0, electricVan);
	
	//check if was additional vehicle in companyUI, if so: add to collection
	if(foundAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(gc.p_uid).add(electricVan);
	}
	
	//Check if charging management is present if not: add default management
	if(gc.f_getCurrentChargingType() == OL_ChargingAttitude.NONE){
		gc.f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
	}
}

else {
	return false;
	//throw new RuntimeException("Numbers suggest there is a petroleumFuel van left, but could not find it.");
}

return true; 
  }

  protected 
boolean 
 f_electricToPetroleumFuelVan( List<GridConnection> gcList ) { 

J_EAEV electricVan = null;
boolean foundAdditionalVehicle = false;

// find the electric van to remove, search through additional vehicles first
for (GridConnection gc : gcList ) {
	if(gc instanceof GCUtility && gc.v_isActive){
		electricVan = (J_EAEV)findFirst(zero_Interface.c_additionalVehicles.get(gc.p_uid), p -> p.getEAType() == OL_EnergyAssetType.ELECTRIC_VAN);
		if ( electricVan != null ) {
			foundAdditionalVehicle = true;
			break;
		}
	}
}

// if no additional vehicle was found, search through the regular ordering of vehicles
if (!foundAdditionalVehicle) {
	electricVan = (J_EAEV)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == OL_EnergyAssetType.ELECTRIC_VAN && ((GridConnection)p.getOwner()).v_isActive && gcList.contains((GridConnection)p.getOwner()));
}
if ( electricVan != null ) {
	GridConnection gc = (GridConnection)electricVan.getOwner();
	
	J_ActivityTrackerTrips tripTracker = electricVan.getTripTracker();
	boolean available = true;
	available = electricVan.getAvailability();
	zero_Interface.c_orderedVehicles.remove(electricVan);
	electricVan.removeEnergyAsset();

	// Re-add petroleumFuel vehicle
	double energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgDieselConsumptionVan_kWhpkm;
	double vehicleScaling = 1.0;
	J_EAFuelVehicle petroleumFuelVehicle = new J_EAFuelVehicle(gc, energyConsumption_kWhpkm, zero_Interface.energyModel.p_timeParameters, vehicleScaling, OL_EnergyAssetType.PETROLEUM_FUEL_VAN, tripTracker, OL_EnergyCarriers.PETROLEUM_FUEL, available);
	
	zero_Interface.c_orderedVehicles.add(0, petroleumFuelVehicle);
	
	//check if was additional vehicle in companyUI, if so: add to collection
	if(foundAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(gc.p_uid).add(petroleumFuelVehicle);
	}
}
else {
	return false;
	//throw new RuntimeException("Numbers suggest there is an electric van left, but could not find it.");
}

return true; 
  }

  protected 
boolean 
 f_petroleumFuelToElectricCar( List<GridConnection> gcList ) { 

J_EAFuelVehicle petroleumFuelCar = null;
boolean foundAdditionalVehicle = false;

// find the petroleumFuel car to remove, search through additional vehicles first
for (GridConnection gc : gcList ) {
	if(gc instanceof GCUtility && gc.v_isActive){
		petroleumFuelCar = (J_EAFuelVehicle)findFirst(zero_Interface.c_additionalVehicles.get(gc.p_uid), p -> p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE);
		if ( petroleumFuelCar != null ) {
			foundAdditionalVehicle = true;
			break;
		}
	}
}

// if no additional vehicle was found, search through the regular ordering of vehicles
if (!foundAdditionalVehicle) {	
	petroleumFuelCar = (J_EAFuelVehicle)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE && ((GridConnection)p.getOwner()).v_isActive && gcList.contains((GridConnection)p.getOwner()));
}
if (petroleumFuelCar!=null) {
	GridConnection gc = (GridConnection)petroleumFuelCar.getOwner();
		
	J_ActivityTrackerTrips tripTracker = petroleumFuelCar.getTripTracker();
	boolean available = petroleumFuelCar.getAvailability();
	zero_Interface.c_orderedVehicles.remove(petroleumFuelCar);
	petroleumFuelCar.removeEnergyAsset();

	// Re-add Electric vehicle
	double capacityElectric_kW = zero_Interface.energyModel.avgc_data.p_avgEVMaxChargePowerCar_kW;
	double storageCapacity_kWh = zero_Interface.energyModel.avgc_data.p_avgEVStorageCar_kWh;
	double initialStateOfCharge_fr = 1.0;
	double energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm;
	double vehicleScalingElectric = 1.0;
	J_EAEV electricCar = new J_EAEV(gc, capacityElectric_kW, storageCapacity_kWh, initialStateOfCharge_fr, zero_Interface.energyModel.p_timeParameters, energyConsumption_kWhpkm, vehicleScalingElectric, OL_EnergyAssetType.ELECTRIC_VEHICLE, tripTracker, available);  
	
	zero_Interface.c_orderedVehicles.add(0, electricCar);
	
	//check if was additional vehicle in companyUI, if so: add to collection
	if(foundAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(gc.p_uid).add(electricCar);
	}
	
	//Check if charging management is present if not: add default management
	if(gc.f_getCurrentChargingType() == OL_ChargingAttitude.NONE){
		gc.f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
	}
}

else {
	return false;
	//throw new RuntimeException("Numbers suggest there is a petroleumFuel car left, but could not find it.");
}

return true; 
  }

  protected 
boolean 
 f_electricToPetroleumFuelCar( List<GridConnection> gcList ) { 

J_EAEV electricCar = null;
boolean foundAdditionalVehicle = false;

// find the electric car to remove, search through additional vehicles first
for (GridConnection gc : gcList ) {
	if(gc instanceof GCUtility && gc.v_isActive){
		electricCar = (J_EAEV)findFirst(zero_Interface.c_additionalVehicles.get(gc.p_uid), p -> p.getEAType() == OL_EnergyAssetType.ELECTRIC_VEHICLE);
		if ( electricCar != null ) {
			foundAdditionalVehicle = true;
			break;
		}
	}
}

// if no additional vehicle was found, search through the regular ordering of vehicles
if (!foundAdditionalVehicle) {
	electricCar = (J_EAEV)findFirst(zero_Interface.c_orderedVehicles, p -> p.getEAType() == OL_EnergyAssetType.ELECTRIC_VEHICLE && ((GridConnection)p.getOwner()).v_isActive && gcList.contains((GridConnection)p.getOwner()));
}
if ( electricCar != null ) {
	GridConnection gc = (GridConnection)electricCar.getOwner();
	
	J_ActivityTrackerTrips tripTracker = electricCar.getTripTracker();
	boolean available = true;
	available = electricCar.getAvailability();
	zero_Interface.c_orderedVehicles.remove(electricCar);
	electricCar.removeEnergyAsset();

	// Re-add petroleumFuel vehicle
	double energyConsumption_kWhpkm = zero_Interface.energyModel.avgc_data.p_avgGasolineConsumptionCar_kWhpkm;
	double vehicleScaling = 1.0;
	J_EAFuelVehicle petroleumFuelVehicle = new J_EAFuelVehicle(gc, energyConsumption_kWhpkm, zero_Interface.energyModel.p_timeParameters, vehicleScaling, OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE, tripTracker, OL_EnergyCarriers.PETROLEUM_FUEL, available);
	
	zero_Interface.c_orderedVehicles.add(0, petroleumFuelVehicle);
	
	//check if was additional vehicle in companyUI, if so: add to collection
	if(foundAdditionalVehicle){
		zero_Interface.c_additionalVehicles.get(gc.p_uid).add(petroleumFuelVehicle);
	}
}
else {
	return false;
	//throw new RuntimeException("Numbers suggest there is an electric car left, but could not find it.");
}

return true; 
  }

  protected 
Triple<Integer, Integer, Integer> 
 f_calculateCurrentNumberOfVans( List<GridConnection> gcList, Integer numberOfGhostVehicle_Vans ) { 

if (numberOfGhostVehicle_Vans == null) {
	numberOfGhostVehicle_Vans = f_calculateNumberOfGhostVehicles(gcList).getMiddle();
}

int nbEVansCurrent = numberOfGhostVehicle_Vans;
int nbHydrogenVansCurrent = 0;
int nbPetroleumFuelVansCurrent = 0;
for ( GridConnection gc : gcList ) {
	nbEVansCurrent += count(gc.c_electricVehicles, p->p.getEAType() == OL_EnergyAssetType.ELECTRIC_VAN && !(gc instanceof GCPublicCharger) && gc.v_isActive);
	nbHydrogenVansCurrent += count(gc.c_hydrogenVehicles, p->p.getEAType() == OL_EnergyAssetType.HYDROGEN_VAN && gc.v_isActive);
	nbPetroleumFuelVansCurrent += count(gc.c_petroleumFuelVehicles, p->p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VAN && gc.v_isActive);
}

return Triple.of(nbEVansCurrent, nbHydrogenVansCurrent, nbPetroleumFuelVansCurrent); 
  }

  protected 
Triple<Integer, Integer, Integer> 
 f_calculateCurrentNumberOfCars( List<GridConnection> gcList, Integer numberOfGhostVehicle_Cars ) { 

if (numberOfGhostVehicle_Cars == null) {
	numberOfGhostVehicle_Cars = f_calculateNumberOfGhostVehicles(gcList).getMiddle();
}

int nbEVsCurrent = numberOfGhostVehicle_Cars;
int nbHydrogenCarsCurrent = 0;
int nbPetroleumFuelCarsCurrent = 0;
for ( GridConnection gc : gcList ) {
	nbEVsCurrent += count(gc.c_electricVehicles, p->p.getEAType() == OL_EnergyAssetType.ELECTRIC_VEHICLE && !(gc instanceof GCPublicCharger) && gc.v_isActive);
	nbHydrogenCarsCurrent += count(gc.c_hydrogenVehicles, p->p.getEAType() == OL_EnergyAssetType.HYDROGEN_VEHICLE && gc.v_isActive);
	nbPetroleumFuelCarsCurrent += count(gc.c_petroleumFuelVehicles, p->p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE && gc.v_isActive);
}

return Triple.of(nbEVsCurrent, nbHydrogenCarsCurrent, nbPetroleumFuelCarsCurrent); 
  }

  protected void f_setPetroleumFuelVans( List<GridConnection> gcList, ShapeSlider sliderElectricVans, ShapeSlider sliderFossilFuelVans ) { 

double pctPetroleumFuelVansGoal = sliderFossilFuelVans.getValue();

int numberOfGhostVehicle_Vans = f_calculateNumberOfGhostVehicles(gcList).getMiddle();
Triple<Integer, Integer, Integer> triple = f_calculateCurrentNumberOfVans( gcList, numberOfGhostVehicle_Vans );

int nbEvanCurrent = triple.getLeft();
int nbPetroleumFuelvansCurrent = triple.getRight();

int total_vehicles = nbEvanCurrent + nbPetroleumFuelvansCurrent;

int nbPetroleumFuelVansGoal = roundToInt(total_vehicles*pctPetroleumFuelVansGoal/100.0);

if (nbPetroleumFuelvansCurrent < nbPetroleumFuelVansGoal) {
	// Add PetroleumFuel Vans
	while ( nbPetroleumFuelvansCurrent < nbPetroleumFuelVansGoal ) {
		if ( nbEvanCurrent > numberOfGhostVehicle_Vans ) {
			// replace electric van with a petroleumFuel van
			if (!f_electricToPetroleumFuelVan(gcList)) {
				f_setVanSlidersToCurrentEngineState(gcList, sliderElectricVans, null, sliderFossilFuelVans);
				return;
			}
			else {
				nbPetroleumFuelvansCurrent++;
				nbEvanCurrent--;
			}
		}
	}
}
else {
	// Remove PetroleumFuel Vans
	while ( nbPetroleumFuelvansCurrent > nbPetroleumFuelVansGoal ) {
		// replace a petroleumFuel van with an electric van
		if (!f_petroleumFuelToElectricVan(gcList)) {
			f_setVanSlidersToCurrentEngineState(gcList, sliderElectricVans, null, sliderFossilFuelVans);
			return;
		}
		nbPetroleumFuelvansCurrent--;
		nbEvanCurrent++;
	}
}


//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}
zero_Interface.f_resetSettings(); 
  }

  protected void f_setElectricVans( List<GridConnection> gcList, ShapeSlider sliderElectricVans, ShapeSlider sliderFossilFuelVans ) { 

double pctElectricVansGoal = sliderElectricVans.getValue();

int numberOfGhostVehicle_Vans = f_calculateNumberOfGhostVehicles(gcList).getMiddle();
Triple<Integer, Integer, Integer> triple = f_calculateCurrentNumberOfVans( gcList, numberOfGhostVehicle_Vans );

int nbEvanCurrent = triple.getLeft();
int nbPetroleumFuelvansCurrent = triple.getRight();

int total_vehicles = nbEvanCurrent + nbPetroleumFuelvansCurrent;

int nbElectricVansGoal = roundToInt(total_vehicles*pctElectricVansGoal/100.0);

if (nbEvanCurrent < nbElectricVansGoal) {
	// Add Electric Vans
	while ( nbEvanCurrent < nbElectricVansGoal ) {
		if ( nbPetroleumFuelvansCurrent > 0 ) {
			// replace a petroleumFuel van with an electric van
			if (!f_petroleumFuelToElectricVan(gcList)) {
				f_setVanSlidersToCurrentEngineState(gcList, sliderElectricVans, null, sliderFossilFuelVans);
				return;
			}
			else {
				nbEvanCurrent++;
				nbPetroleumFuelvansCurrent--;
			}
		}
	}
}
else {
	// Remove Electric Vans
	while ( nbEvanCurrent > nbElectricVansGoal ) {
		// replace an electric van with a petroleumFuel van
		if (!f_electricToPetroleumFuelVan(gcList)) {
			f_setVanSlidersToCurrentEngineState(gcList, sliderElectricVans, null, sliderFossilFuelVans);
			return;
		}
		nbEvanCurrent--;
		nbPetroleumFuelvansCurrent++;
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}
zero_Interface.f_resetSettings(); 
  }

  protected void f_setPetroleumFuelCars( List<GridConnection> gcList, ShapeSlider sliderElectricCars, ShapeSlider sliderFossilFuelCars ) { 

double pctPetroleumFuelCarsGoal = sliderFossilFuelCars.getValue();

int numberOfGhostVehicle_Cars = f_calculateNumberOfGhostVehicles(gcList).getMiddle();
Triple<Integer, Integer, Integer> triple = f_calculateCurrentNumberOfCars( gcList, numberOfGhostVehicle_Cars );

int nbEcarCurrent = triple.getLeft();
int nbPetroleumFuelcarsCurrent = triple.getRight();

int total_vehicles = nbEcarCurrent + nbPetroleumFuelcarsCurrent;

int nbPetroleumFuelCarsGoal = roundToInt(total_vehicles*pctPetroleumFuelCarsGoal/100.0);

if (nbPetroleumFuelcarsCurrent < nbPetroleumFuelCarsGoal) {
	// Add PetroleumFuel Cars
	while ( nbPetroleumFuelcarsCurrent < nbPetroleumFuelCarsGoal ) {
		if ( nbEcarCurrent > numberOfGhostVehicle_Cars ) {
			// replace electric car with a petroleumFuel car
			if (!f_electricToPetroleumFuelCar(gcList)) {
				f_setCarSlidersToCurrentEngineState(gcList, sliderElectricCars, null, sliderFossilFuelCars);
				return;
			}
			else {
				nbPetroleumFuelcarsCurrent++;
				nbEcarCurrent--;
			}
		}
	}
}
else {
	// Remove PetroleumFuel Cars
	while ( nbPetroleumFuelcarsCurrent > nbPetroleumFuelCarsGoal ) {
		// replace a petroleumFuel car with an electric car
		if (!f_petroleumFuelToElectricCar(gcList)) {
			f_setCarSlidersToCurrentEngineState(gcList, sliderElectricCars, null, sliderFossilFuelCars);
			return;
		}
		nbPetroleumFuelcarsCurrent--;
		nbEcarCurrent++;
	}
}


//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}
zero_Interface.f_resetSettings(); 
  }

  protected void f_setElectricCars( List<GridConnection> gcList, ShapeSlider sliderElectricCars, ShapeSlider sliderFossilFuelCars ) { 

double pctElectricCarsGoal = sliderElectricCars.getValue();

int numberOfGhostVehicle_Cars = f_calculateNumberOfGhostVehicles(gcList).getMiddle();
Triple<Integer, Integer, Integer> triple = f_calculateCurrentNumberOfCars( gcList, numberOfGhostVehicle_Cars );

int nbEcarCurrent = triple.getLeft();
int nbPetroleumFuelcarsCurrent = triple.getRight();

int total_vehicles = nbEcarCurrent + nbPetroleumFuelcarsCurrent;

int nbElectricCarsGoal = roundToInt(total_vehicles*pctElectricCarsGoal/100.0);

if (nbEcarCurrent < nbElectricCarsGoal) {
	// Add Electric Cars
	while ( nbEcarCurrent < nbElectricCarsGoal ) {
		if ( nbPetroleumFuelcarsCurrent > 0 ) {
			// replace a petroleumFuel car with an electric car
			if (!f_petroleumFuelToElectricCar(gcList)) {
				f_setCarSlidersToCurrentEngineState(gcList, sliderElectricCars, null, sliderFossilFuelCars);
				return;
			}
			else {
				nbEcarCurrent++;
				nbPetroleumFuelcarsCurrent--;
			}
		}
	}
}
else {
	// Remove Electric Cars
	while ( nbEcarCurrent > nbElectricCarsGoal ) {
		// replace an electric car with a petroleumFuel car
		if (!f_electricToPetroleumFuelCar(gcList)) {
			f_setCarSlidersToCurrentEngineState(gcList, sliderElectricCars, null, sliderFossilFuelCars);
			return;
		}
		nbEcarCurrent--;
		nbPetroleumFuelcarsCurrent++;
	}
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}
zero_Interface.f_resetSettings(); 
  }

  protected void f_setVanSlidersToCurrentEngineState( List<GridConnection> gcList, ShapeSlider sliderElectricVans, ShapeSlider sliderHydrogenVans, ShapeSlider sliderFossilFuelVans ) { 

List<J_EAEV> electricVehicles = new ArrayList<>();
List<J_EAFuelVehicle> petroleumVehicles = new ArrayList<>();
List<J_EAFuelVehicle> hydrogenVehicles = new ArrayList<>();
for (GridConnection gc : gcList) {
	if (gc.v_isActive) {
		electricVehicles.addAll(gc.c_electricVehicles);
		petroleumVehicles.addAll(gc.c_petroleumFuelVehicles);
		hydrogenVehicles.addAll(gc.c_hydrogenVehicles);
	}
}

int numberOfGhostVehicle_Vans = f_calculateNumberOfGhostVehicles(gcList).getRight();

int nbElectricVansCurrent = count(electricVehicles, p->p.getEAType() == OL_EnergyAssetType.ELECTRIC_VAN && !(p.getOwner() instanceof GCPublicCharger)) + numberOfGhostVehicle_Vans;
int nbPetroleumFuelvansCurrent = count(petroleumVehicles, p->p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VAN);
int nbHydrogenvansCurrent = count(hydrogenVehicles, p->p.getEAType() == OL_EnergyAssetType.HYDROGEN_VAN);

int totalVehicles = nbElectricVansCurrent + nbPetroleumFuelvansCurrent + nbHydrogenvansCurrent;



int pct_electricVanSlider = roundToInt(100.0*nbElectricVansCurrent/totalVehicles);
int pct_hydrogenVanSlider = roundToInt(100.0*nbHydrogenvansCurrent/totalVehicles);
int pct_petroleumFuelVanSlider = roundToInt(100.0*nbPetroleumFuelvansCurrent/totalVehicles);

sliderElectricVans.setValue(pct_electricVanSlider, false);
if ( sliderHydrogenVans != null ) {
	sliderHydrogenVans.setValue(pct_hydrogenVanSlider, false);
}
else if ( sliderHydrogenVans == null && pct_hydrogenVanSlider != 0 ) {
	throw new RuntimeException("Hydrogen vans found but no hydrogen slider passed to f_setVanSlidersToCurrentEngineState");
}
sliderFossilFuelVans.setValue(pct_petroleumFuelVanSlider, false);


//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}
zero_Interface.f_resetSettings(); 
  }

  protected void f_setCarSlidersToCurrentEngineState( List<GridConnection> gcList, ShapeSlider sliderElectricCars, ShapeSlider sliderHydrogenCars, ShapeSlider sliderFossilFuelCars ) { 

List<J_EAEV> electricVehicles = new ArrayList<>();
List<J_EAFuelVehicle> petroleumVehicles = new ArrayList<>();
List<J_EAFuelVehicle> hydrogenVehicles = new ArrayList<>();
for (GridConnection gc : gcList) {
	if (gc.v_isActive) {
		electricVehicles.addAll(gc.c_electricVehicles);
		petroleumVehicles.addAll(gc.c_petroleumFuelVehicles);
		hydrogenVehicles.addAll(gc.c_hydrogenVehicles);
	}
}

int numberOfGhostVehicle_Cars = f_calculateNumberOfGhostVehicles(gcList).getRight();

int nbElectricCarsCurrent = count(electricVehicles, p->p.getEAType() == OL_EnergyAssetType.ELECTRIC_VEHICLE && !(p.getOwner() instanceof GCPublicCharger)) + numberOfGhostVehicle_Cars;
int nbPetroleumFuelcarsCurrent = count(petroleumVehicles, p->p.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE);
int nbHydrogencarsCurrent = count(hydrogenVehicles, p->p.getEAType() == OL_EnergyAssetType.HYDROGEN_VEHICLE);

int totalVehicles = nbElectricCarsCurrent + nbPetroleumFuelcarsCurrent + nbHydrogencarsCurrent;



int pct_electricCarSlider = roundToInt(100.0*nbElectricCarsCurrent/totalVehicles);
int pct_hydrogenCarSlider = roundToInt(100.0*nbHydrogencarsCurrent/totalVehicles);
int pct_petroleumFuelCarSlider = roundToInt(100.0*nbPetroleumFuelcarsCurrent/totalVehicles);

sliderElectricCars.setValue(pct_electricCarSlider, false);
if ( sliderHydrogenCars != null ) {
	sliderHydrogenCars.setValue(pct_hydrogenCarSlider, false);
}
else if ( sliderHydrogenCars == null && pct_hydrogenCarSlider != 0 ) {
	throw new RuntimeException("Hydrogen cars found but no hydrogen slider passed to f_setCarSlidersToCurrentEngineState");
}
sliderFossilFuelCars.setValue(pct_petroleumFuelCarSlider, false);


//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}
zero_Interface.f_resetSettings(); 
  }

  protected void f_updateSliders_Mobility(  ) { 

Triple<Integer, Integer, Integer> triple = f_calculateNumberOfGhostVehicles( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()) );
v_totalNumberOfGhostVehicle_Cars = triple.getLeft();
v_totalNumberOfGhostVehicle_Vans = triple.getMiddle();
v_totalNumberOfGhostVehicle_Trucks = triple.getRight();

// Update all loaded pages
for (ShapeGroup page : c_loadedPageGroups) {
	if(page == gr_mobilitySliders_households){
		f_updateMobilitySliders_households();
	}
	else if(page == gr_mobilitySliders_companies){
		f_updateMobilitySliders_companies();
	}
	else{
		f_updateMobilitySliders_custom(); 
	}
} 
  }

  protected void f_updateMobilitySliders_companies(  ) { 

List<GCUtility> allUtilityGridConnections = uI_Tabs.f_getActiveSliderGridConnections_utilities();

////Savings
double totalBaseTravelDistance_km = 0;
double totalSavedTravelDistance_km = 0;
for(GridConnection GC : allUtilityGridConnections){
	if(GC.v_isActive){
		for(J_ActivityTrackerTrips tripTracker : GC.c_tripTrackers){
			totalBaseTravelDistance_km += tripTracker.getAnnualDistance_km();
			totalSavedTravelDistance_km += (1-tripTracker.getDistanceScaling_fr())*tripTracker.getAnnualDistance_km();
		}
	}
}

double mobilitySavings_pct = totalBaseTravelDistance_km > 0 ? (totalSavedTravelDistance_km/totalBaseTravelDistance_km * 100) : 0;
sl_companiesMobilityDemandReduction_pct.setValue(roundToInt(mobilitySavings_pct), false);


//Smart charging
boolean smartCharging = false;
for(GridConnection GC : allUtilityGridConnections){
	if(GC.c_electricVehicles.size() > 0 && GC.f_getCurrentChargingType() != OL_ChargingAttitude.SIMPLE){
		smartCharging = true;
		break;
	}
}
cb_companiesSpreadChargingEVs.setSelected(smartCharging, false);


////Vehicles
// Initialize the vehicle counters
int PetroleumFuelCars = 0;
int ElectricCars = v_totalNumberOfGhostVehicle_Cars;
int HydrogenCars = 0;

int PetroleumFuelVans = 0;
int ElectricVans = v_totalNumberOfGhostVehicle_Vans;
int HydrogenVans = 0;

int PetroleumFuelTrucks = 0;
int ElectricTrucks = v_totalNumberOfGhostVehicle_Trucks;
int HydrogenTrucks = 0;

//Count the amount of vehicles for each type
for (GridConnection gc : allUtilityGridConnections) {
	if(gc.v_isActive){
		for (J_EAFuelVehicle vehicle : gc.c_petroleumFuelVehicles) {
			switch(vehicle.getEAType()){
		 		case PETROLEUM_FUEL_VEHICLE:
					PetroleumFuelCars += 1;
				break;
				case PETROLEUM_FUEL_VAN:
					PetroleumFuelVans += 1;
				break;
				case PETROLEUM_FUEL_TRUCK:
					PetroleumFuelTrucks += 1;
				break;
			}
		}
		for (J_EAEV vehicle : gc.c_electricVehicles) {
		 	switch(vehicle.getEAType()){
		 		case ELECTRIC_VEHICLE:
					ElectricCars += 1;
				break;
				case ELECTRIC_VAN:
					ElectricVans += 1;
				break;
				case ELECTRIC_TRUCK:
					ElectricTrucks += 1;
				break;
			}
		}
		for (J_EAFuelVehicle vehicle : gc.c_hydrogenVehicles) {
			switch(vehicle.getEAType()){
		 		case HYDROGEN_VEHICLE:
					HydrogenCars += 1;
				break;
				case HYDROGEN_VAN:
					HydrogenVans += 1;
				break;
				case HYDROGEN_TRUCK:
					HydrogenTrucks += 1;
				break;
			}
		}
	}
}


//Set CAR sliders
int totalCars = PetroleumFuelCars + ElectricCars + HydrogenCars;
int PetroleumFuelCars_pct = 0;
int ElectricCars_pct = 0;
int HydrogenCars_pct = 0;
if (totalCars != 0) {
	PetroleumFuelCars_pct = roundToInt((100.0 * PetroleumFuelCars) / totalCars);
	ElectricCars_pct = roundToInt((100.0 * ElectricCars) / totalCars);
	HydrogenCars_pct = roundToInt((100.0 * HydrogenCars) / totalCars);
}
else{
	sl_companiesFossilFuelCars_pct.setEnabled(false);
	sl_companiesElectricCars_pct.setEnabled(false);
}
sl_companiesFossilFuelCars_pct.setValue(PetroleumFuelCars_pct, false);
sl_companiesElectricCars_pct.setValue(ElectricCars_pct, false);


//Set VAN sliders
int totalVans = PetroleumFuelVans + ElectricVans + HydrogenVans;
int PetroleumFuelVans_pct = 0;
int ElectricVans_pct = 0;
int HydrogenVans_pct = 0;
if (totalVans != 0) {
	PetroleumFuelVans_pct = roundToInt(100.0 * PetroleumFuelVans / totalVans);
	ElectricVans_pct = roundToInt(100.0 * ElectricVans / totalVans);
	HydrogenVans_pct = roundToInt(100.0 * HydrogenVans / totalVans);
}
else{
	sl_companiesFossilFuelVans_pct.setEnabled(false);
	sl_companiesElectricVans_pct.setEnabled(false);
}
sl_companiesFossilFuelVans_pct.setValue(PetroleumFuelVans_pct, false);
sl_companiesElectricVans_pct.setValue(ElectricVans_pct, false);


//Set TRUCK sliders
int totalTrucks = PetroleumFuelTrucks + ElectricTrucks + HydrogenTrucks;
int PetroleumFuelTrucks_pct = 0;
int ElectricTrucks_pct = 0;
int HydrogenTrucks_pct = 0;
if (totalTrucks != 0) {
	PetroleumFuelTrucks_pct = roundToInt(100.0 * PetroleumFuelTrucks / totalTrucks);
	ElectricTrucks_pct = roundToInt(100.0 * ElectricTrucks / totalTrucks);
	HydrogenTrucks_pct = roundToInt(100.0 * HydrogenTrucks / totalTrucks);
}
else{
	sl_companiesFossilFuelTrucks_pct.setEnabled(false);
	sl_companiesElectricTrucks_pct.setEnabled(false);
	sl_companiesHydrogenTrucks_pct.setEnabled(false);
}
sl_companiesFossilFuelTrucks_pct.setValue(PetroleumFuelTrucks_pct, false);
sl_companiesElectricTrucks_pct.setValue(ElectricTrucks_pct, false);
sl_companiesHydrogenTrucks_pct.setValue(HydrogenTrucks_pct, false); 
  }

  protected void f_updateMobilitySliders_custom(  ) { 

//If you have a custom tab, override this function to make it update automatically
throw new RuntimeException("Forgot to override the update custom mobility sliders functionality"); 
  }

  protected void f_setChargingAttitude( OL_ChargingAttitude selectedChargingAttitude, List<GridConnection> gcList ) { 

gcList.forEach(x -> x.f_addChargingManagement(selectedChargingAttitude));


//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  protected void f_updateMobilitySliders_households(  ) { 

////Private EV
gr_householdActivateV2GPrivateParkedCars.setVisible(false);
cb_householdActivateV2GPrivateParkedCars.setSelected(false, false);
gr_householdSettingsV2G_privateParkedCars.setVisible(false);

List<GCHouse> houseGridConnectionsWithPrivateParking = findAll(uI_Tabs.f_getActiveSliderGridConnections_houses(), house -> house.p_eigenOprit);
List<I_Vehicle> privateParkedCars = new ArrayList<>();
houseGridConnectionsWithPrivateParking.forEach(gc -> privateParkedCars.addAll(gc.c_vehicleAssets));

if (privateParkedCars.size() > 0) {
	int nbPrivateEVs = count(privateParkedCars, x -> x instanceof J_EAEV);
	int nbPrivateEVsThatSupportV2G = count(privateParkedCars, x -> x instanceof J_EAEV && ((J_EAEV)x).getV2GCapable());
	double privateEVs_pct = 100.0 * nbPrivateEVs / privateParkedCars.size();
	double privateEVsThatSupportV2G_pct = 100.0 * nbPrivateEVsThatSupportV2G / nbPrivateEVs;
	sl_householdPrivateEVs_pct.setValue(roundToInt(privateEVs_pct), false);
	sl_householdEVsThatSupportV2G_pct.setValue(roundToInt(privateEVsThatSupportV2G_pct), false);
	
	//Selected charging mode
	GCHouse GCWithPrivateParkedEV = findFirst(houseGridConnectionsWithPrivateParking, gc -> gc.c_electricVehicles.size() > 0);
	OL_ChargingAttitude currentChargingAttitude = (GCWithPrivateParkedEV != null) ? GCWithPrivateParkedEV.f_getCurrentChargingType() : OL_ChargingAttitude.SIMPLE;
	boolean V2GActive = (GCWithPrivateParkedEV != null) ? GCWithPrivateParkedEV.f_getV2GActive() : false;
	for(GridConnection GC : houseGridConnectionsWithPrivateParking){
		if(GC.c_electricVehicles.size() > 0 ){
			if(currentChargingAttitude != OL_ChargingAttitude.CUSTOM && GC.f_getCurrentChargingType() != currentChargingAttitude){
				currentChargingAttitude = OL_ChargingAttitude.CUSTOM; // Here used as varied: in other words: custom setting
			}
			if(V2GActive && !GC.f_getV2GActive()){
				V2GActive = false;
			}
		}
		
		if(currentChargingAttitude == OL_ChargingAttitude.CUSTOM && !V2GActive){
			break;
		}
		
	}
	
	String selectedChargingAttitudeString = "";
	switch(currentChargingAttitude){
		case SIMPLE:
			selectedChargingAttitudeString = "Niet slim laden";
			break;
		case PRICE:
			selectedChargingAttitudeString = "Slim laden: Prijs gestuurd";
			gr_householdActivateV2GPrivateParkedCars.setVisible(true);
			break;
		case BALANCE_LOCAL:
			selectedChargingAttitudeString = "Slim laden: Netbewust";
			gr_householdActivateV2GPrivateParkedCars.setVisible(true);
			break;
		case CUSTOM:
			selectedChargingAttitudeString = "Gevarieerd";
			break;
	}
	
	cb_householdChargingStrategyPrivateParkedCars.setValue(selectedChargingAttitudeString, false);
	cb_householdActivateV2GPrivateParkedCars.setSelected(V2GActive, false);
	
	if(gr_householdActivateV2GPrivateParkedCars.isVisible() && V2GActive){
		gr_householdSettingsV2G_privateParkedCars.setVisible(true);
	}
}
else{
	sl_householdPrivateEVs_pct.setEnabled(false);
}

////Chargers
OL_ChargingAttitude selectedChargingAttitude = null;
gr_householdActivateV2GPublicChargers.setVisible(false);
cb_householdActivateV2GPublicChargers.setSelected(false, false);
gr_householdSettingsV1G_publicChargers.setVisible(false);
gr_householdSettingsV2G_publicChargers.setVisible(false);

List<GCPublicCharger> activeChargerGridConnections = uI_Tabs.f_getActiveSliderGridConnections_chargers();
List<GCPublicCharger> pausedChargerGridConnections = uI_Tabs.f_getPausedSliderGridConnections_chargers();


int nbPublicChargerGC = activeChargerGridConnections.size() + pausedChargerGridConnections.size();

if(nbPublicChargerGC > 0 ){
	int nbActivePublicChargersGC = activeChargerGridConnections.size();
	double activePublicChargers_pct = 100.0 * nbActivePublicChargersGC / nbPublicChargerGC;
	sl_householdPublicChargers_pct.setValue(roundToInt(activePublicChargers_pct), false);
	
	int nbV1GChargers = count(activeChargerGridConnections, x -> x.f_getChargePoint().getV1GCapable());
	int nbV2GChargers =count(activeChargerGridConnections, x -> x.f_getChargePoint().getV2GCapable());
	int nbPublicChargers = activeChargerGridConnections.size();
		
	double V1G_pct = 100.0 * nbV1GChargers / nbPublicChargers;
	double V2G_pct = 100.0 * nbV2GChargers / nbPublicChargers;
	sl_householdChargersThatSupportV1G_pct.setValue(roundToInt(V1G_pct), false);
	sl_householdChargersThatSupportV2G_pct.setValue(roundToInt(V2G_pct), false);
	
	//Selected charging mode
	OL_ChargingAttitude currentChargingAttitude = activeChargerGridConnections.size() > 0 ? activeChargerGridConnections.get(0).f_getCurrentChargingType(): OL_ChargingAttitude.SIMPLE;
	boolean V2GActive = activeChargerGridConnections.size() > 0 ? activeChargerGridConnections.get(0).f_getChargingManagement().getV2GActive(): false;
	for(GCPublicCharger charger : activeChargerGridConnections){
		if(currentChargingAttitude != OL_ChargingAttitude.CUSTOM && charger.f_getCurrentChargingType() != currentChargingAttitude){
			currentChargingAttitude = OL_ChargingAttitude.CUSTOM; // Here used as varied: in other words: custom setting
		}
		if(V2GActive && !charger.f_getChargingManagement().getV2GActive()){
			V2GActive = false;
		}
		
		if(currentChargingAttitude == OL_ChargingAttitude.CUSTOM && !V2GActive){
			break;
		}
	}
	
	String selectedChargingAttitudeString = "";
	switch(currentChargingAttitude){
		case SIMPLE:
			selectedChargingAttitudeString = "Niet slim laden";
			break;
		case PRICE:
			selectedChargingAttitudeString = "Slim laden: Prijs gestuurd";
			gr_householdSettingsV1G_publicChargers.setVisible(true);
			gr_householdActivateV2GPublicChargers.setVisible(true);
			break;
		case BALANCE_GRID:
			selectedChargingAttitudeString = "Slim laden: Netbewust";
			gr_householdSettingsV1G_publicChargers.setVisible(true);
			gr_householdActivateV2GPublicChargers.setVisible(true);
			break;
		case CUSTOM:
			selectedChargingAttitudeString = "Gevarieerd";
			break;
	}
	
	cb_householdChargingStrategyPrivatePublicChargers.setValue(selectedChargingAttitudeString, false);
	cb_householdActivateV2GPublicChargers.setSelected(V2GActive, false);
	
	if(gr_householdActivateV2GPublicChargers.isVisible() && V2GActive){
		gr_householdSettingsV2G_publicChargers.setVisible(true);
	}
}
else{
	sl_householdPublicChargers_pct.setEnabled(false);
} 
  }

  protected void f_setPublicChargingStations( List<GCPublicCharger> gcListChargers, double publicChargers_pct, ShapeSlider V1GCapableChargerSlider, ShapeSlider V2GCapableChargerSlider ) { 

int totalNbChargers = gcListChargers.size();
int currentNbChargers = count(gcListChargers, x -> x.v_isActive);
int nbChargersGoal = roundToInt(publicChargers_pct / 100 * totalNbChargers) ;

while ( currentNbChargers > nbChargersGoal ) {
	GCPublicCharger gc = findFirst(zero_Interface.c_orderedPublicChargers, x -> x.v_isActive);
	if (gc != null) {
		gc.f_setActive(false, zero_Interface.energyModel.p_timeVariables);
		zero_Interface.c_orderedPublicChargers.remove(gc);
		zero_Interface.c_orderedPublicChargers.add(0, gc);
		currentNbChargers--;
		
		for (J_EAFuelVehicle car : zero_Interface.c_mappingOfVehiclesPerCharger.get(gc.p_uid)) {
			car.reRegisterEnergyAsset(zero_Interface.energyModel.p_timeParameters);
		}
	}
	else {
		throw new RuntimeException("Charger slider error: there are not sufficient chargers to remove");
	}
}
while ( currentNbChargers < nbChargersGoal){
	GCPublicCharger gc = findFirst(zero_Interface.c_orderedPublicChargers, x -> !x.v_isActive);
	if (gc != null) {
		gc.f_setActive(true, zero_Interface.energyModel.p_timeVariables);
		zero_Interface.c_orderedPublicChargers.remove(gc);
		zero_Interface.c_orderedPublicChargers.add(0, gc);
		currentNbChargers++;
		
		for (J_EAFuelVehicle car : zero_Interface.c_mappingOfVehiclesPerCharger.get(gc.p_uid)) {
			J_ActivityTrackerTrips tripTracker = car.getTripTracker(); //Needed, as triptracker is removed when removeEnergyAsset is called.
			car.removeEnergyAsset();
			car.setTripTracker(tripTracker);//Re-set the triptracker again, for storing.
		}
	}
	else {
		throw new RuntimeException("Charger slider error: there are no more chargers to add");
	}
}

//Update the V1G and V2G capable vehicle slider accordingly to the change in vehicle dynamics
int totalActiveChargers = 0;
int totalCapableV1GChargers = 0;
int totalCapableV2GChargers = 0;

for(GCPublicCharger GC : gcListChargers){
	if(GC.v_isActive){
		totalActiveChargers++;
		if(GC.f_getChargePoint().getV1GCapable()){
			totalCapableV1GChargers++;
		}
		if(GC.f_getChargePoint().getV2GCapable()){
			totalCapableV2GChargers++;			
		}	
	}
}
V1GCapableChargerSlider.setValue(roundToInt(100.0 * totalCapableV1GChargers/totalActiveChargers));
V2GCapableChargerSlider.setValue(roundToInt(100.0 * totalCapableV2GChargers/totalActiveChargers));


//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings();
 
  }

  protected void f_setV1GChargerCapabilities( List<GCPublicCharger> gcListChargers, double goal_pct ) { 

int totalNbChargers = gcListChargers.size();
int currentNbChargers = count(gcListChargers, x -> x.f_getChargePoint().getV1GCapable());
int nbChargersGoal = roundToInt(goal_pct / 100.0 * totalNbChargers);

while (currentNbChargers < nbChargersGoal) {
	GCPublicCharger charger = findFirst(zero_Interface.c_orderedV1GChargers, x -> gcListChargers.contains(x) && !x.f_getChargePoint().getV1GCapable());
	charger.f_getChargePoint().setV1GCapability(true);
	currentNbChargers++;
	zero_Interface.c_orderedV1GChargers.remove(charger);
	zero_Interface.c_orderedV1GChargers.add(0, charger);
	
}
while (currentNbChargers > nbChargersGoal) {
	GCPublicCharger charger = findFirst(zero_Interface.c_orderedV1GChargers, x -> gcListChargers.contains(x) && x.f_getChargePoint().getV1GCapable());
	charger.f_getChargePoint().setV1GCapability(false);
	currentNbChargers--;
	zero_Interface.c_orderedV1GChargers.remove(charger);
	zero_Interface.c_orderedV1GChargers.add(0, charger);
}

// Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  protected void f_setV2GChargerCapabilities( List<GCPublicCharger> gcListChargers, double goal_pct ) { 

int totalNbChargers = gcListChargers.size();
int currentNbChargers = count(gcListChargers, x -> x.f_getChargePoint().getV2GCapable());
int nbChargersGoal = roundToInt(goal_pct / 100.0 * totalNbChargers);

while (currentNbChargers < nbChargersGoal) {
	GCPublicCharger charger = findFirst(zero_Interface.c_orderedV2GChargers, x -> gcListChargers.contains(x) && !x.f_getChargePoint().getV2GCapable());
	charger.f_getChargePoint().setV2GCapability(true);
	currentNbChargers++;
	zero_Interface.c_orderedV2GChargers.remove(charger);
	zero_Interface.c_orderedV2GChargers.add(0, charger);
	
}
while (currentNbChargers > nbChargersGoal) {
	GCPublicCharger charger = findFirst(zero_Interface.c_orderedV2GChargers, x -> gcListChargers.contains(x) && x.f_getChargePoint().getV2GCapable());
	charger.f_getChargePoint().setV2GCapability(false);
	currentNbChargers--;
	zero_Interface.c_orderedV2GChargers.remove(charger);
	zero_Interface.c_orderedV2GChargers.add(0, charger);
}

// Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  protected void f_setVehiclesPrivateParking( List<GCHouse> gcListHouses, double privateParkingEV_pct, ShapeSlider V2GCapableVehicleSlider ) { 

//Voor nu zo opgelost, echter gaat dit niet goed werken met de volgorde. BEDENK EEN BETER MANIER!?
List<I_Vehicle> gcListOrderedVehiclesPrivateParking = findAll( zero_Interface.c_orderedVehiclesPrivateParking, h -> gcListHouses.contains(((J_EA)h).getOwner()));

int nbOfPrivateParkedEV = (int)sum(findAll(gcListHouses, gc -> gc.p_eigenOprit), x -> x.c_electricVehicles.size());
int desiredNbOfPrivateParkedEV = roundToInt(privateParkingEV_pct / 100 * gcListOrderedVehiclesPrivateParking.size());


// we scale the consumption instead of getting the petroleumFuel/EV parameter from avgc data to represent the 'size' of the car
double ratioEVToPetroleumFuelConsumption = zero_Interface.energyModel.avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm / zero_Interface.energyModel.avgc_data.p_avgGasolineConsumptionCar_kWhpkm;

while ( nbOfPrivateParkedEV > desiredNbOfPrivateParkedEV){
	J_EAEV j_ea = (J_EAEV) findFirst( gcListOrderedVehiclesPrivateParking, h -> h instanceof J_EAEV);
	if (j_ea.getVehicleScaling_fr() != 1) {
		throw new RuntimeException("f_setVehiclesPrivateParking does not work with vehicles that have a vehicleScaling other than 1");
	}
	J_ActivityTrackerTrips triptracker = j_ea.getTripTracker();
	boolean availability = j_ea.getAvailability();
	double energyConsumption_kWhpkm = j_ea.getEnergyConsumption_kWhpkm() / ratioEVToPetroleumFuelConsumption; 
	j_ea.removeEnergyAsset();
	gcListOrderedVehiclesPrivateParking.remove(j_ea);
	zero_Interface.c_orderedVehiclesPrivateParking.remove(j_ea);
	J_EAFuelVehicle petroleumFuelCar = new J_EAFuelVehicle(j_ea.getOwner(), energyConsumption_kWhpkm, zero_Interface.energyModel.p_timeParameters, 1, OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE, triptracker, OL_EnergyCarriers.PETROLEUM_FUEL, availability);
	gcListOrderedVehiclesPrivateParking.add(petroleumFuelCar);
	zero_Interface.c_orderedVehiclesPrivateParking.add(petroleumFuelCar);
	nbOfPrivateParkedEV --;
}
while ( nbOfPrivateParkedEV < desiredNbOfPrivateParkedEV){
	J_EAFuelVehicle petroleumFuelVehicle = (J_EAFuelVehicle) findFirst( gcListOrderedVehiclesPrivateParking, h -> h.getEAType() == OL_EnergyAssetType.PETROLEUM_FUEL_VEHICLE);
	if (petroleumFuelVehicle.getVehicleScaling_fr() != 1) {
		throw new RuntimeException("f_setVehiclesPrivateParking does not work with vehicles that have a vehicleScaling other than 1");
	}
	J_ActivityTrackerTrips triptracker = petroleumFuelVehicle.getTripTracker();
	boolean availability = petroleumFuelVehicle.getAvailability();
	double energyConsumption_kWhpkm = petroleumFuelVehicle.getEnergyConsumption_kWhpkm() * ratioEVToPetroleumFuelConsumption;
	petroleumFuelVehicle.removeEnergyAsset();
	gcListOrderedVehiclesPrivateParking.remove(petroleumFuelVehicle);
	zero_Interface.c_orderedVehiclesPrivateParking.remove(petroleumFuelVehicle);
	double capacityElectricity_kW = randomTrue(0.6) ? randomTrue(0.4) ? 3.2 : 5.6 : 11.0;
	double storageCapacity_kWh = uniform_discr(65,90);
	J_EAEV ev = new J_EAEV(petroleumFuelVehicle.getOwner(), capacityElectricity_kW, storageCapacity_kWh, 1, zero_Interface.energyModel.p_timeParameters, energyConsumption_kWhpkm, 1, OL_EnergyAssetType.ELECTRIC_VEHICLE, triptracker, availability);	
	
	//Check if charging management is present if not: add default management
	if(((GridConnection)petroleumFuelVehicle.getOwner()).f_getCurrentChargingType() == OL_ChargingAttitude.NONE){
		((GridConnection)petroleumFuelVehicle.getOwner()).f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
	}
	
	gcListOrderedVehiclesPrivateParking.add(ev);
	zero_Interface.c_orderedVehiclesPrivateParking.add(ev);
	nbOfPrivateParkedEV++;
}


//Update the V2G capable vehicle slider accordingly to the change in vehicle dynamics
int totalCapableV2GEVs = count(gcListOrderedVehiclesPrivateParking, vehicle -> vehicle instanceof J_EAEV && ((J_EAEV)vehicle).getV2GCapable());
V2GCapableVehicleSlider.setValue(roundToInt(100.0*totalCapableV2GEVs/nbOfPrivateParkedEV));

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  protected void f_setV2GEVCapabilities( List<GCHouse> gcListHouses, double goal_pct ) { 

//Voor nu zo werkend gemaakt met gclist als input, echter gaat dit niet goed werken mochten er minder gcs tussen zitten dan in de zero_interface ordered collectie staat en gaat de volgorde veranderen. 
// -> BEDENK EEN BETER MANIER!? --> Bestaat er uberhaupt een manier voor? 

List<I_Vehicle> gcListOrderedVehiclesPrivateParking_all = findAll( zero_Interface.c_orderedVehiclesPrivateParking, vehicle -> gcListHouses.contains(((J_EA)vehicle).getOwner()) && vehicle instanceof J_EAEV && ((J_EAEV)vehicle).getEAType() == OL_EnergyAssetType.ELECTRIC_VEHICLE);

List<J_EAEV> gcListOrderedVehiclesPrivateParking = gcListOrderedVehiclesPrivateParking_all.stream().map(v -> (J_EAEV) v).collect(Collectors.toList());

int totalNbEVs = gcListOrderedVehiclesPrivateParking.size();
int currentNbEVsV2GCapable = count(gcListOrderedVehiclesPrivateParking, x -> x.getV2GCapable());
int nbEVsV2GCapableGoal = roundToInt(goal_pct / 100.0 * totalNbEVs);

while (currentNbEVsV2GCapable < nbEVsV2GCapableGoal) {
	J_EAEV j_ea = findFirst(gcListOrderedVehiclesPrivateParking, x -> x.getEAType() == OL_EnergyAssetType.ELECTRIC_VEHICLE && !x.getV2GCapable());
	j_ea.setV2GCapable(true);
	currentNbEVsV2GCapable++;
	gcListOrderedVehiclesPrivateParking.remove(j_ea);
	gcListOrderedVehiclesPrivateParking.add(0, j_ea);
	
}
while (currentNbEVsV2GCapable > nbEVsV2GCapableGoal) {
	J_EAEV j_ea = findFirst(gcListOrderedVehiclesPrivateParking, x -> x.getEAType() == OL_EnergyAssetType.ELECTRIC_VEHICLE && x.getV2GCapable());
	j_ea.setV2GCapable(false);
	currentNbEVsV2GCapable--;
	gcListOrderedVehiclesPrivateParking.remove(j_ea);
	gcListOrderedVehiclesPrivateParking.add(0, j_ea);
}

// Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  protected void f_activateV2G( List<GridConnection> gcList, boolean activateV2G ) { 

for(GridConnection GC : gcList){
	GC.f_activateV2GChargingMode(activateV2G, zero_Interface.energyModel.p_timeParameters, zero_Interface.energyModel.p_timeVariables);
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

zero_Interface.f_resetSettings(); 
  }

  protected void f_initializeTab_Mobility(  ) { 

//Use this function to initialize mobility tab settings at start of simulation
f_initializeMobilityPages(); 
  }

  protected void f_initializeMobilityPages(  ) { 

// CHOOSE WHICH PAGES IN YOUR TAB YOU WANT TO BE ABLE TO SHOW FOR YOUR PROJECT 
boolean hasHouses = uI_Tabs.f_getActiveSliderGridConnections_houses().size() > 0;
boolean hasCompanies = uI_Tabs.f_getActiveSliderGridConnections_utilities().size() > 0;

c_loadedPageGroups = new ArrayList<>();
// Load in the existing pages you want to include in the tab
if (hasHouses) {
	c_loadedPageGroups.add(gr_mobilitySliders_households);
} 
if (hasCompanies) {
	c_loadedPageGroups.add(gr_mobilitySliders_companies);
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

  protected void f_addCustomPage(  ) { 

// Override this function to add your custom page to c_loadedPageGroups, for instance, like this:
//c_loadedPageGroups.add(gr_mobilitySliders_custom); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_companiesSpreadChargingEVs_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_setChargingAttitude_Font = _cb_companiesSpreadChargingEVs_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_householdActivateV2GPrivateParkedCars_Font = _cb_companiesSpreadChargingEVs_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_householdChargingStrategyPrivateParkedCars_Font = _cb_companiesSpreadChargingEVs_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_householdChargingStrategyPrivatePublicChargers_Font = _cb_companiesSpreadChargingEVs_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_householdActivateV2GPublicChargers_Font = _cb_companiesSpreadChargingEVs_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_genericFunctions_Font = new Font("SansSerif", 0, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesFossilFuelCars_pct_Font = new Font("Dialog", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesFossilFuelCarsDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesElectricTrucksDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesElectricTrucks_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesMobilityDemandReductionDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesMobilityDemandReduction_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesHydrogenTrucksDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesHydrogenTrucks_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesFossilFuelTrucksDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_fossilFuelTrucks_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_trucksDescription_Font = new Font("Dialog", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesElectricCarsDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesElectricCars_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_carsDescription_Font = _t_trucksDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesFossilFuelVans_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesFossilFuelVansDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesElectricVansDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesElectricVans_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_vansDescription_Font = _t_trucksDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_companiesSpreadChargingEVsDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mobilitySlidersCompaniesDescription_Font = new Font("Dialog", 1, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_demandFunctionsDescription_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_mobilityFunctionsDescription_Font = _t_demandFunctionsDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_privateParkedCars_Font = _t_trucksDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_publicChargePoints_Font = _t_trucksDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdPublicEVsResidentialAreaDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdPublicEVs_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdPrivateEVsDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdPrivateEVs_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chargersThatSupportV2GDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdChargersThatSupportV2G_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdChargersThatSupportV1GDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdChargersThatSupportV1G_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdActivateV2GPrivateParkedCars_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdChargingStrategyPrivateParkedCars_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_chargingStrategyPublicChargers_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_activateV2GPrivatePublicChargers_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdEVsThatSupportV2GDescription_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_householdEVsThatSupportV2G_pct_Font = _txt_companiesFossilFuelCars_pct_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mobilitySlidersHousesholdsDescription_Font = _txt_mobilitySlidersCompaniesDescription_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_mobilityFunctionsDescription_Font = new Font("Dialog", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_mobilityFunctionsDescription1_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_pageIndicator_Font = new Font("Dialog", 0, 10 );
  protected static final Color _rect_mobilityDemandSliders_default_Fill_Color = new Color( 0xFFD7EFF2, true );
  protected static final Color _rect_mobilityDemandSliders_residential_Fill_Color = new Color( 0xFFD7EFF2, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_genericFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_genericFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mobilityDemandSliders_default = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesFossilFuelCars_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesFossilFuelCarsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesElectricTrucksDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesElectricTrucks_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesMobilityDemandReductionDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesMobilityDemandReduction_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesHydrogenTrucksDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesHydrogenTrucks_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesFossilFuelTrucksDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_fossilFuelTrucks_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_trucksDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesElectricCarsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesElectricCars_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_carsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesFossilFuelVans_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesFossilFuelVansDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesElectricVansDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesElectricVans_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_vansDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companiesMobilityReduction = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companiesElectricTruck = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companiesHydrogenTruck = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companiesFossilFuelTruck = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companiesElectricVans = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companiesFossilFuelVans = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companiesElectricCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companiesFossilFuelCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_companiesSpreadChargingEVsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_companiesMobilityChargingAttitude = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mobilitySlidersCompaniesDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_mobilitySliders_companies = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_demandFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_demandFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mobilityFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_mobilityFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mobilityDemandSliders_residential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_privateParkedCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_publicChargePoints = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdPublicEVsResidentialAreaDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdPublicEVs_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdPrivateEVsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdPrivateEVs_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chargersThatSupportV2GDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdChargersThatSupportV2G_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdPublicChargersV2G = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_householdSettingsV2G_publicChargers = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdPrivateEV = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdPublicChargers = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdChargersThatSupportV1GDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdChargersThatSupportV1G_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdPublicChargersV1G = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_householdSettingsV1G_publicChargers = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdActivateV2GPrivateParkedCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdActivateV2GPrivateParkedCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_householdActivateV2GPrivateParkedCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdChargingStrategyPrivateParkedCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdChargingStrategyPrivateParkedCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_chargingStrategyPublicChargers = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdChargingStrategyPublicChargers = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdActivateV2GPrivatePublicChargers = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_activateV2GPrivatePublicChargers = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_householdActivateV2GPublicChargers = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdEVsThatSupportV2GDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_householdEVsThatSupportV2G_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_householdEVsThatSupportV2G = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_householdSettingsV2G_privateParkedCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mobilitySlidersHousesholdsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_mobilitySliders_households = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_mobilityFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_mobilityFunctions1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_mobilityFunctionsDescription1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrowLeftResidential = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _arrowRightResidential1 = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 76;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_pageIndicator = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 77;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_pageIndicator = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 78;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesFossilFuelCars_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 79;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesElectricTrucks_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 80;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesMobilityDemandReduction_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 81;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesHydrogenTrucks_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 82;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesFossilFuelTrucks_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 83;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesElectricCars_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 84;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesFossilFuelVans_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 85;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_companiesElectricVans_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 86;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_companiesSpreadChargingEVs = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 87;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_setChargingAttitude = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 88;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdPublicChargers_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 89;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdPrivateEVs_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 90;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdChargersThatSupportV2G_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 91;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdChargersThatSupportV1G_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 92;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_householdActivateV2GPrivateParkedCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 93;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_householdChargingStrategyPrivateParkedCars = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 94;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_householdChargingStrategyPrivatePublicChargers = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 95;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_householdActivateV2GPublicChargers = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 96;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_householdEVsThatSupportV2G_pct = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 97;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 98;

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
	  level.addAll(rect_genericFunctions, t_genericFunctions, gr_mobilitySliders_companies, rect_demandFunctions, t_demandFunctionsDescription, rect_mobilityFunctions, t_mobilityFunctionsDescription, cb_setChargingAttitude, gr_mobilitySliders_households, txt_mobilityFunctionsDescription, rect_mobilityFunctions1, t_mobilityFunctionsDescription1, gr_pageIndicator);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_companiesMobilityReduction:
        if (true) {
          ShapeImage self = this.i_companiesMobilityReduction;
          
zero_Interface.f_setInfoText(i_companiesMobilityReduction, zero_Interface.v_infoText.mobilityDemandReduction, i_companiesMobilityReduction.getX() + uI_Tabs.v_presentationXOffset, i_companiesMobilityReduction.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companiesElectricTruck:
        if (true) {
          ShapeImage self = this.i_companiesElectricTruck;
          
zero_Interface.f_setInfoText(i_companiesElectricTruck, zero_Interface.v_infoText.electricTrucks, i_companiesElectricTruck.getX() + uI_Tabs.v_presentationXOffset, i_companiesElectricTruck.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companiesHydrogenTruck:
        if (true) {
          ShapeImage self = this.i_companiesHydrogenTruck;
          
zero_Interface.f_setInfoText(i_companiesHydrogenTruck, zero_Interface.v_infoText.hydrogenTrucks, i_companiesHydrogenTruck.getX() + uI_Tabs.v_presentationXOffset, i_companiesHydrogenTruck.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companiesFossilFuelTruck:
        if (true) {
          ShapeImage self = this.i_companiesFossilFuelTruck;
          
zero_Interface.f_setInfoText(i_companiesFossilFuelTruck, zero_Interface.v_infoText.fossilTrucks, i_companiesFossilFuelTruck.getX() + uI_Tabs.v_presentationXOffset, i_companiesFossilFuelTruck.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companiesElectricVans:
        if (true) {
          ShapeImage self = this.i_companiesElectricVans;
          
zero_Interface.f_setInfoText(i_companiesElectricVans, zero_Interface.v_infoText.electricVans, i_companiesElectricVans.getX() + uI_Tabs.v_presentationXOffset, i_companiesElectricVans.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companiesFossilFuelVans:
        if (true) {
          ShapeImage self = this.i_companiesFossilFuelVans;
          
zero_Interface.f_setInfoText(i_companiesFossilFuelVans, zero_Interface.v_infoText.fossilVans, i_companiesFossilFuelVans.getX() + uI_Tabs.v_presentationXOffset, i_companiesFossilFuelVans.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companiesElectricCars:
        if (true) {
          ShapeImage self = this.i_companiesElectricCars;
          
zero_Interface.f_setInfoText(i_companiesElectricCars, zero_Interface.v_infoText.electricCars, i_companiesElectricCars.getX() + uI_Tabs.v_presentationXOffset, i_companiesElectricCars.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companiesFossilFuelCars:
        if (true) {
          ShapeImage self = this.i_companiesFossilFuelCars;
          
zero_Interface.f_setInfoText(i_companiesFossilFuelCars, zero_Interface.v_infoText.fossilCars, i_companiesFossilFuelCars.getX() + uI_Tabs.v_presentationXOffset, i_companiesFossilFuelCars.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_companiesMobilityChargingAttitude:
        if (true) {
          ShapeImage self = this.i_companiesMobilityChargingAttitude;
          
zero_Interface.f_setInfoText(i_companiesMobilityChargingAttitude, zero_Interface.v_infoText.mobilitySmartCharging, i_companiesMobilityChargingAttitude.getX() + uI_Tabs.v_presentationXOffset, i_companiesMobilityChargingAttitude.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdPublicChargersV2G:
        if (true) {
          ShapeImage self = this.i_householdPublicChargersV2G;
          
zero_Interface.f_setInfoText(i_householdPublicChargersV2G, zero_Interface.v_infoText.householdPublicParkingV2G, i_householdPublicChargersV2G.getX() + gr_householdSettingsV2G_publicChargers.getX() + uI_Tabs.v_presentationXOffset, i_householdPublicChargersV2G.getY() + gr_householdSettingsV2G_publicChargers.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdPrivateEV:
        if (true) {
          ShapeImage self = this.i_householdPrivateEV;
          
zero_Interface.f_setInfoText(i_householdPrivateEV, zero_Interface.v_infoText.householdPrivateParking, i_householdPrivateEV.getX() + uI_Tabs.v_presentationXOffset, i_householdPrivateEV.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdPublicChargers:
        if (true) {
          ShapeImage self = this.i_householdPublicChargers;
          
zero_Interface.f_setInfoText(i_householdPublicChargers, zero_Interface.v_infoText.householdPublicParking, i_householdPublicChargers.getX() + uI_Tabs.v_presentationXOffset, i_householdPublicChargers.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdPublicChargersV1G:
        if (true) {
          ShapeImage self = this.i_householdPublicChargersV1G;
          
zero_Interface.f_setInfoText(i_householdPublicChargersV1G, zero_Interface.v_infoText.householdPublicParkingV1G, i_householdPublicChargersV1G.getX() + gr_householdSettingsV1G_publicChargers.getX() + uI_Tabs.v_presentationXOffset, i_householdPublicChargersV1G.getY() + gr_householdSettingsV1G_publicChargers.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdActivateV2GPrivateParkedCars:
        if (true) {
          ShapeImage self = this.i_householdActivateV2GPrivateParkedCars;
          
zero_Interface.f_setInfoText(i_householdActivateV2GPrivateParkedCars, zero_Interface.v_infoText.activateV2GPrivateParkedCars, i_householdActivateV2GPrivateParkedCars.getX() + gr_householdActivateV2GPrivateParkedCars.getX() + uI_Tabs.v_presentationXOffset, i_householdActivateV2GPrivateParkedCars.getY() + gr_householdActivateV2GPrivateParkedCars.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdChargingStrategyPrivateParkedCars:
        if (true) {
          ShapeImage self = this.i_householdChargingStrategyPrivateParkedCars;
          
zero_Interface.f_setInfoText(i_householdChargingStrategyPrivateParkedCars, zero_Interface.v_infoText.chargingAttitudePrivateParkedCars, i_householdChargingStrategyPrivateParkedCars.getX() + uI_Tabs.v_presentationXOffset, i_householdChargingStrategyPrivateParkedCars.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdChargingStrategyPublicChargers:
        if (true) {
          ShapeImage self = this.i_householdChargingStrategyPublicChargers;
          
zero_Interface.f_setInfoText(i_householdChargingStrategyPublicChargers, zero_Interface.v_infoText.chargingStrategyPublicChargers, i_householdChargingStrategyPublicChargers.getX() + uI_Tabs.v_presentationXOffset, i_householdChargingStrategyPublicChargers.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdActivateV2GPrivatePublicChargers:
        if (true) {
          ShapeImage self = this.i_householdActivateV2GPrivatePublicChargers;
          
zero_Interface.f_setInfoText(i_householdActivateV2GPrivatePublicChargers, zero_Interface.v_infoText.activateV2GPrivatePublicChargers, i_householdActivateV2GPrivatePublicChargers.getX() + gr_householdActivateV2GPublicChargers.getX() + uI_Tabs.v_presentationXOffset, i_householdActivateV2GPrivatePublicChargers.getY() + gr_householdActivateV2GPublicChargers.getY() + uI_Tabs.v_presentationYOffset); 
        }
        break;
      case _i_householdEVsThatSupportV2G:
        if (true) {
          ShapeImage self = this.i_householdEVsThatSupportV2G;
          
zero_Interface.f_setInfoText(i_householdEVsThatSupportV2G, zero_Interface.v_infoText.EVsThatSupportV2G, i_householdEVsThatSupportV2G.getX() + gr_householdSettingsV2G_privateParkedCars.getX() + uI_Tabs.v_presentationXOffset, i_householdEVsThatSupportV2G.getY() + gr_householdSettingsV2G_privateParkedCars.getY() + uI_Tabs.v_presentationYOffset); 
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
      case _cb_companiesSpreadChargingEVs: {
          ShapeCheckBox self = this.cb_companiesSpreadChargingEVs;
OL_ChargingAttitude selectedChargingAttitude = OL_ChargingAttitude.SIMPLE; 
if(cb_companiesSpreadChargingEVs.isSelected()){
	selectedChargingAttitude = OL_ChargingAttitude.MAX_POWER; 
}

f_setChargingAttitude(selectedChargingAttitude, new ArrayList<GridConnection>(uI_Tabs.f_getAllSliderGridConnections_utilities())); 
;}
        break;
      case _cb_householdActivateV2GPrivateParkedCars: {
          ShapeCheckBox self = this.cb_householdActivateV2GPrivateParkedCars;
f_activateV2G(new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()), cb_householdActivateV2GPrivateParkedCars.isSelected());
gr_householdSettingsV2G_privateParkedCars.setVisible(cb_householdActivateV2GPrivateParkedCars.isSelected()); 
;}
        break;
      case _cb_householdActivateV2GPublicChargers: {
          ShapeCheckBox self = this.cb_householdActivateV2GPublicChargers;
f_activateV2G(new ArrayList<GridConnection>(uI_Tabs.f_getAllSliderGridConnections_chargers()), cb_householdActivateV2GPublicChargers.isSelected());
gr_householdSettingsV2G_publicChargers.setVisible(cb_householdActivateV2GPublicChargers.isSelected()); 
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
      case _sl_companiesFossilFuelCars_pct: {
          ShapeSlider self = this.sl_companiesFossilFuelCars_pct;
sl_companiesElectricCars_pct.setValue(100 - sl_companiesFossilFuelCars_pct.getIntValue(), false);
f_setPetroleumFuelCars( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_companiesElectricCars_pct, sl_companiesFossilFuelCars_pct ); 
;}
        break;
      case _sl_companiesElectricTrucks_pct: {
          ShapeSlider self = this.sl_companiesElectricTrucks_pct;
f_setVehicleSliders( 0, sl_companiesElectricTrucks_pct, sl_companiesHydrogenTrucks_pct, sl_companiesFossilFuelTrucks_pct );
f_setElectricTrucks( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_companiesElectricTrucks_pct, sl_companiesHydrogenTrucks_pct, sl_companiesFossilFuelTrucks_pct ); 
;}
        break;
      case _sl_companiesMobilityDemandReduction_pct: {
          ShapeSlider self = this.sl_companiesMobilityDemandReduction_pct;
f_setDemandReduction( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_companiesMobilityDemandReduction_pct.getValue() ); 
;}
        break;
      case _sl_companiesHydrogenTrucks_pct: {
          ShapeSlider self = this.sl_companiesHydrogenTrucks_pct;
f_setVehicleSliders( 1, sl_companiesElectricTrucks_pct, sl_companiesHydrogenTrucks_pct, sl_companiesFossilFuelTrucks_pct );
f_setHydrogenTrucks( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_companiesElectricTrucks_pct, sl_companiesHydrogenTrucks_pct, sl_companiesFossilFuelTrucks_pct ); 
;}
        break;
      case _sl_companiesFossilFuelTrucks_pct: {
          ShapeSlider self = this.sl_companiesFossilFuelTrucks_pct;
f_setVehicleSliders( 2, sl_companiesElectricTrucks_pct, sl_companiesHydrogenTrucks_pct, sl_companiesFossilFuelTrucks_pct );
f_setPetroleumFuelTrucks( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_companiesElectricTrucks_pct, sl_companiesHydrogenTrucks_pct, sl_companiesFossilFuelTrucks_pct ); 
;}
        break;
      case _sl_companiesElectricCars_pct: {
          ShapeSlider self = this.sl_companiesElectricCars_pct;
sl_companiesFossilFuelCars_pct.setValue(100 - sl_companiesElectricCars_pct.getIntValue(), false);
f_setElectricCars( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_companiesElectricCars_pct, sl_companiesFossilFuelCars_pct ); 
;}
        break;
      case _sl_companiesFossilFuelVans_pct: {
          ShapeSlider self = this.sl_companiesFossilFuelVans_pct;
sl_companiesElectricVans_pct.setValue(100 - sl_companiesFossilFuelVans_pct.getIntValue(), false);
f_setPetroleumFuelVans( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_companiesElectricVans_pct, sl_companiesFossilFuelVans_pct ); 
;}
        break;
      case _sl_companiesElectricVans_pct: {
          ShapeSlider self = this.sl_companiesElectricVans_pct;
sl_companiesFossilFuelVans_pct.setValue(100 - sl_companiesElectricVans_pct.getIntValue(), false);
f_setElectricVans( new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_utilities()), sl_companiesElectricVans_pct, sl_companiesFossilFuelVans_pct ); 
;}
        break;
      case _sl_householdPublicChargers_pct: {
          ShapeSlider self = this.sl_householdPublicChargers_pct;
f_setPublicChargingStations(uI_Tabs.f_getAllSliderGridConnections_chargers(), sl_householdPublicChargers_pct.getIntValue(), sl_householdChargersThatSupportV1G_pct, sl_householdChargersThatSupportV2G_pct); 
;}
        break;
      case _sl_householdPrivateEVs_pct: {
          ShapeSlider self = this.sl_householdPrivateEVs_pct;
f_setVehiclesPrivateParking(uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_householdPrivateEVs_pct.getValue(), sl_householdEVsThatSupportV2G_pct); 
;}
        break;
      case _sl_householdChargersThatSupportV2G_pct: {
          ShapeSlider self = this.sl_householdChargersThatSupportV2G_pct;
f_setV2GChargerCapabilities( uI_Tabs.f_getActiveSliderGridConnections_chargers(), sl_householdChargersThatSupportV2G_pct.getValue() ); 
;}
        break;
      case _sl_householdChargersThatSupportV1G_pct: {
          ShapeSlider self = this.sl_householdChargersThatSupportV1G_pct;
f_setV1GChargerCapabilities( uI_Tabs.f_getActiveSliderGridConnections_chargers(), sl_householdChargersThatSupportV1G_pct.getValue() ); 
;}
        break;
      case _sl_householdEVsThatSupportV2G_pct: {
          ShapeSlider self = this.sl_householdEVsThatSupportV2G_pct;
f_setV2GEVCapabilities( uI_Tabs.f_getActiveSliderGridConnections_houses(), sl_householdEVsThatSupportV2G_pct.getValue() ); 
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
      case _cb_setChargingAttitude: {
          ShapeComboBox self = this.cb_setChargingAttitude;
OL_ChargingAttitude selectedChargingAttitude = null;
 
switch(cb_setChargingAttitude.getValue()){
	case "Standaard":
		selectedChargingAttitude = OL_ChargingAttitude.SIMPLE;
		break;
	case "Gelimiteerd vermogen":
		selectedChargingAttitude = OL_ChargingAttitude.MAX_POWER;
		break;
	/*case "Slimme spreiding":
		selectedChargingAttitude = OL_ChargingAttitude.MAX_SPREAD;
		break;*/
	case "Prijsgestuurd":
		selectedChargingAttitude = OL_ChargingAttitude.PRICE;
		break;
	case "Custom":
		selectedChargingAttitude = null;
		break;
}

if(selectedChargingAttitude != null){
	f_setChargingAttitude(selectedChargingAttitude, uI_Tabs.f_getAllSliderGridConnections_all());
} 
;}
        break;
      case _cb_householdChargingStrategyPrivateParkedCars: {
          ShapeComboBox self = this.cb_householdChargingStrategyPrivateParkedCars;
OL_ChargingAttitude selectedChargingAttitude = null;
gr_householdActivateV2GPrivateParkedCars.setVisible(false);
cb_householdActivateV2GPrivateParkedCars.setSelected(false, false);
gr_householdSettingsV2G_privateParkedCars.setVisible(false);

switch(cb_householdChargingStrategyPrivateParkedCars.getValue()){
	case "Niet slim laden":
		selectedChargingAttitude = OL_ChargingAttitude.SIMPLE;
		break;
	case "Slim laden: Prijs gestuurd":
		selectedChargingAttitude = OL_ChargingAttitude.PRICE;
		gr_householdActivateV2GPrivateParkedCars.setVisible(true);
		break;
	case "Slim laden: Prijs marktfeedback":
		selectedChargingAttitude = OL_ChargingAttitude.PRICE_MARKET_FEEDBACK;
		gr_householdActivateV2GPrivateParkedCars.setVisible(false);
		break;
	case "Slim laden: Netbewust":
		selectedChargingAttitude = OL_ChargingAttitude.BALANCE_LOCAL; // For now Balance_Local
		gr_householdActivateV2GPrivateParkedCars.setVisible(true);
		break;
	/*
	case "Slim laden: Locale balans":
		selectedChargingAttitude = OL_ChargingAttitude.BALANCE_LOCAL;
		gr_activateV2GPrivateParkedCars.setVisible(true);
		break;
	*/
	case "Gevarieerd":
		zero_Interface.f_setErrorScreen("De geselecteerde laad strategie is er alleen ter visualisatie in het geval niet elk huis dezelfde laad strategie heeft. Dit is dus niet een strategie die je handmatig aan kunt zetten. Voor nu is 'Niet slim laden' weer geselecteerd.", 0, 0);
		selectedChargingAttitude = null;
		break;
}

if(selectedChargingAttitude != null){
	f_setChargingAttitude(selectedChargingAttitude, new ArrayList<GridConnection>(uI_Tabs.f_getActiveSliderGridConnections_houses()));
}
else{
	cb_householdChargingStrategyPrivateParkedCars.setValue("Niet slim laden", true);
} 
;}
        break;
      case _cb_householdChargingStrategyPrivatePublicChargers: {
          ShapeComboBox self = this.cb_householdChargingStrategyPrivatePublicChargers;
OL_ChargingAttitude selectedChargingAttitude = null;
gr_householdActivateV2GPublicChargers.setVisible(false);
cb_householdActivateV2GPublicChargers.setSelected(false, true); // True call for now needed for chargepoints only
gr_householdSettingsV1G_publicChargers.setVisible(false);
gr_householdSettingsV2G_publicChargers.setVisible(false);

switch(cb_householdChargingStrategyPrivatePublicChargers.getValue()){
	case "Niet slim laden":
		selectedChargingAttitude = OL_ChargingAttitude.SIMPLE;
		break;
	case "Slim laden: Prijs gestuurd":
		selectedChargingAttitude = OL_ChargingAttitude.PRICE;
		gr_householdActivateV2GPublicChargers.setVisible(true);
		gr_householdSettingsV1G_publicChargers.setVisible(true);
		break;
	case "Slim laden: Prijs marktfeedback":
		selectedChargingAttitude = OL_ChargingAttitude.PRICE_MARKET_FEEDBACK;
		gr_householdActivateV2GPublicChargers.setVisible(false);
		gr_householdSettingsV1G_publicChargers.setVisible(true);
		break;
	case "Slim laden: Netbewust":
		selectedChargingAttitude = OL_ChargingAttitude.BALANCE_GRID;
		gr_householdActivateV2GPublicChargers.setVisible(true);
		gr_householdSettingsV1G_publicChargers.setVisible(true);
		break;
	case "Gevarieerd":
		zero_Interface.f_setErrorScreen("De geselecteerde laad strategie is er alleen ter visualisatie in het geval niet elk huis dezelfde laad strategie heeft. Dit is dus niet een strategie die je handmatig aan kunt zetten. Voor nu is 'Niet slim laden' weer geselecteerd.", 0, 0);
		selectedChargingAttitude = null;
		break;
}

if(selectedChargingAttitude != null){
	List<GridConnection> allChargersInModel = new ArrayList<GridConnection>(uI_Tabs.f_getAllSliderGridConnections_chargers());
	f_setChargingAttitude(selectedChargingAttitude, allChargersInModel);
}
else{
	cb_householdChargingStrategyPrivatePublicChargers.setValue("Niet slim laden", true);
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
  public double getShapeControlDefaultValueDouble( int _shape, int index ) {
    switch(_shape) {
      case _sl_companiesFossilFuelCars_pct: return 
0 
;
      case _sl_companiesElectricTrucks_pct: return 
0 
;
      case _sl_companiesMobilityDemandReduction_pct: return 
0 
;
      case _sl_companiesHydrogenTrucks_pct: return 
0 
;
      case _sl_companiesFossilFuelTrucks_pct: return 
0 
;
      case _sl_companiesElectricCars_pct: return 
0 
;
      case _sl_companiesFossilFuelVans_pct: return 
0 
;
      case _sl_companiesElectricVans_pct: return 
0 
;
      case _sl_householdPublicChargers_pct: return 
0 
;
      case _sl_householdPrivateEVs_pct: return 
0 
;
      case _sl_householdChargersThatSupportV2G_pct: return 
0 
;
      case _sl_householdChargersThatSupportV1G_pct: return 
0 
;
      case _sl_householdEVsThatSupportV2G_pct: return 
0 
;
      default: return super.getShapeControlDefaultValueDouble( _shape, index );
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesFossilFuelCars_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_companiesFossilFuelCars_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesElectricTrucks_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_companiesElectricTrucks_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesMobilityDemandReduction_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_companiesMobilityDemandReduction_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesHydrogenTrucks_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_companiesHydrogenTrucks_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesFossilFuelTrucks_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_companiesFossilFuelTrucks_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesElectricCars_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_companiesElectricCars_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesFossilFuelVans_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_companiesFossilFuelVans_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_companiesElectricVans_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_companiesElectricVans_pct;
  protected ShapeCheckBox cb_companiesSpreadChargingEVs;
  protected ShapeComboBox cb_setChargingAttitude;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdPublicChargers_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdPublicChargers_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdPrivateEVs_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdPrivateEVs_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdChargersThatSupportV2G_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdChargersThatSupportV2G_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdChargersThatSupportV1G_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdChargersThatSupportV1G_pct;
  protected ShapeCheckBox cb_householdActivateV2GPrivateParkedCars;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _cb_householdChargingStrategyPrivateParkedCars_SetDynamicParams_xjal( ShapeComboBox shape ) {
    shape.setEnabled(
sl_householdPrivateEVs_pct.isEnabled() 
);
  }
  
  protected ShapeComboBox cb_householdChargingStrategyPrivateParkedCars;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _cb_householdChargingStrategyPrivatePublicChargers_SetDynamicParams_xjal( ShapeComboBox shape ) {
    shape.setEnabled(
sl_householdPublicChargers_pct.isEnabled() 
);
  }
  
  protected ShapeComboBox cb_householdChargingStrategyPrivatePublicChargers;
  protected ShapeCheckBox cb_householdActivateV2GPublicChargers;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_householdEVsThatSupportV2G_pct_SetDynamicParams_xjal( ShapeSlider shape ) {
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
  
  protected ShapeSlider sl_householdEVsThatSupportV2G_pct;
  protected ShapeRectangle rect_genericFunctions;
  protected ShapeText t_genericFunctions;
  protected ShapeRectangle rect_mobilityDemandSliders_default;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesFossilFuelCars_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesFossilFuelCars_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesFossilFuelCars_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesFossilFuelCars_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesFossilFuelCarsDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesFossilFuelCars_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesFossilFuelCarsDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesElectricTrucksDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesElectricTrucks_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesElectricTrucksDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesElectricTrucks_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesElectricTrucks_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesElectricTrucks_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesElectricTrucks_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesMobilityDemandReductionDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesMobilityDemandReduction_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesMobilityDemandReductionDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesMobilityDemandReduction_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesMobilityDemandReduction_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesMobilityDemandReduction_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesMobilityDemandReduction_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesHydrogenTrucksDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesHydrogenTrucks_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesHydrogenTrucksDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesHydrogenTrucks_pct_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
sl_companiesHydrogenTrucks_pct.getIntValue() + "%" 
);
  }
  
  protected ShapeText txt_companiesHydrogenTrucks_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesFossilFuelTrucksDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesFossilFuelTrucks_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesFossilFuelTrucksDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _t_fossilFuelTrucks_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesFossilFuelTrucks_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesFossilFuelTrucks_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText t_fossilFuelTrucks_pct;
  protected ShapeText t_trucksDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesElectricCarsDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesElectricCars_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesElectricCarsDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesElectricCars_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesElectricCars_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesElectricCars_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesElectricCars_pct;
  protected ShapeText t_carsDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesFossilFuelVans_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesFossilFuelVans_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesFossilFuelVans_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesFossilFuelVans_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesFossilFuelVansDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesFossilFuelVans_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesFossilFuelVansDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesElectricVansDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesElectricVans_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesElectricVansDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesElectricVans_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_companiesElectricVans_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_companiesElectricVans_pct.getIntValue() + "%" 
);
 	}
  }
  
  protected ShapeText txt_companiesElectricVans_pct;
  protected ShapeText t_vansDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companiesMobilityReduction_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesMobilityDemandReduction_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companiesMobilityReduction;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companiesElectricTruck_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesElectricTrucks_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companiesElectricTruck;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companiesHydrogenTruck_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesHydrogenTrucks_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companiesHydrogenTruck;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companiesFossilFuelTruck_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesFossilFuelTrucks_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companiesFossilFuelTruck;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companiesElectricVans_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesElectricVans_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companiesElectricVans;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companiesFossilFuelVans_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesFossilFuelVans_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companiesFossilFuelVans;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companiesElectricCars_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesElectricCars_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companiesElectricCars;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companiesFossilFuelCars_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_companiesFossilFuelCars_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companiesFossilFuelCars;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_companiesSpreadChargingEVsDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
cb_companiesSpreadChargingEVs.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_companiesSpreadChargingEVsDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_companiesMobilityChargingAttitude_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
cb_companiesSpreadChargingEVs.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_companiesMobilityChargingAttitude;
  protected ShapeText txt_mobilitySlidersCompaniesDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_mobilitySliders_companies_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
    shape.setY(
0 
);
  }
  
  protected ShapeGroup gr_mobilitySliders_companies;
  protected ShapeRectangle rect_demandFunctions;
  protected ShapeText t_demandFunctionsDescription;
  protected ShapeRectangle rect_mobilityFunctions;
  protected ShapeText t_mobilityFunctionsDescription;
  protected ShapeRectangle rect_mobilityDemandSliders_residential;
  protected ShapeText txt_privateParkedCars;
  protected ShapeText txt_publicChargePoints;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdPublicEVsResidentialAreaDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdPublicChargers_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdPublicEVsResidentialAreaDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdPublicEVs_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdPublicChargers_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdPublicChargers_pct.getIntValue() + " %" 
);
 	}
  }
  
  protected ShapeText txt_householdPublicEVs_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdPrivateEVsDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdPrivateEVs_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdPrivateEVsDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdPrivateEVs_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdPrivateEVs_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdPrivateEVs_pct.getIntValue() + " %" 
);
 	}
  }
  
  protected ShapeText txt_householdPrivateEVs_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_chargersThatSupportV2GDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdChargersThatSupportV2G_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_chargersThatSupportV2GDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdChargersThatSupportV2G_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdChargersThatSupportV2G_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdChargersThatSupportV2G_pct.getIntValue() + " %" 
);
 	}
  }
  
  protected ShapeText txt_householdChargersThatSupportV2G_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdPublicChargersV2G_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdChargersThatSupportV2G_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdPublicChargersV2G;
  protected ShapeGroup gr_householdSettingsV2G_publicChargers;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdPrivateEV_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdPrivateEVs_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdPrivateEV;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdPublicChargers_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdPublicChargers_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdPublicChargers;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdChargersThatSupportV1GDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdChargersThatSupportV1G_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdChargersThatSupportV1GDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdChargersThatSupportV1G_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdChargersThatSupportV1G_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdChargersThatSupportV1G_pct.getIntValue() + " %" 
);
 	}
  }
  
  protected ShapeText txt_householdChargersThatSupportV1G_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdPublicChargersV1G_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdChargersThatSupportV1G_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdPublicChargersV1G;
  protected ShapeGroup gr_householdSettingsV1G_publicChargers;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdActivateV2GPrivateParkedCars_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
cb_householdActivateV2GPrivateParkedCars.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdActivateV2GPrivateParkedCars;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdActivateV2GPrivateParkedCars_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
cb_householdActivateV2GPrivateParkedCars.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdActivateV2GPrivateParkedCars;
  protected ShapeGroup gr_householdActivateV2GPrivateParkedCars;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdChargingStrategyPrivateParkedCars_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
cb_householdChargingStrategyPrivateParkedCars.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdChargingStrategyPrivateParkedCars;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdChargingStrategyPrivateParkedCars_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
cb_householdChargingStrategyPrivateParkedCars.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdChargingStrategyPrivateParkedCars;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_chargingStrategyPublicChargers_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
cb_householdChargingStrategyPrivatePublicChargers.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_chargingStrategyPublicChargers;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdChargingStrategyPublicChargers_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
cb_householdChargingStrategyPrivatePublicChargers.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdChargingStrategyPublicChargers;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdActivateV2GPrivatePublicChargers_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
cb_householdActivateV2GPublicChargers.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdActivateV2GPrivatePublicChargers;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_activateV2GPrivatePublicChargers_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
cb_householdActivateV2GPublicChargers.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_activateV2GPrivatePublicChargers;
  protected ShapeGroup gr_householdActivateV2GPublicChargers;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdEVsThatSupportV2GDescription_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdEVsThatSupportV2G_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeText txt_householdEVsThatSupportV2GDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _txt_householdEVsThatSupportV2G_pct_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
sl_householdEVsThatSupportV2G_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setText(
sl_householdEVsThatSupportV2G_pct.getIntValue() + " %" 
);
 	}
  }
  
  protected ShapeText txt_householdEVsThatSupportV2G_pct;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _i_householdEVsThatSupportV2G_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
sl_householdEVsThatSupportV2G_pct.isVisible() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeImage i_householdEVsThatSupportV2G;
  protected ShapeGroup gr_householdSettingsV2G_privateParkedCars;
  protected ShapeText txt_mobilitySlidersHousesholdsDescription;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_mobilitySliders_households_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
    shape.setY(
0 
);
  }
  
  protected ShapeGroup gr_mobilitySliders_households;
  protected ShapeText txt_mobilityFunctionsDescription;
  protected ShapeRectangle rect_mobilityFunctions1;
  protected ShapeText t_mobilityFunctionsDescription1;
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
    sl_companiesFossilFuelCars_pct = new ShapeSlider(
tabMobility.this, true, 260.0, 309.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesFossilFuelCars_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesFossilFuelCars_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesFossilFuelCars_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesElectricTrucks_pct = new ShapeSlider(
tabMobility.this, true, 260.0, 125.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesElectricTrucks_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesElectricTrucks_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesElectricTrucks_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesMobilityDemandReduction_pct = new ShapeSlider(
tabMobility.this, true, 260.0, 55.0,
			100.0, 30.0,
            true, false,
            -50
            , 50
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesMobilityDemandReduction_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesMobilityDemandReduction_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesMobilityDemandReduction_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesHydrogenTrucks_pct = new ShapeSlider(
tabMobility.this, true, 260.0, 147.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesHydrogenTrucks_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesHydrogenTrucks_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesHydrogenTrucks_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesFossilFuelTrucks_pct = new ShapeSlider(
tabMobility.this, true, 260.0, 169.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesFossilFuelTrucks_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesFossilFuelTrucks_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesFossilFuelTrucks_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesElectricCars_pct = new ShapeSlider(
tabMobility.this, true, 260.0, 287.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesElectricCars_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesElectricCars_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesElectricCars_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesFossilFuelVans_pct = new ShapeSlider(
tabMobility.this, true, 260.0, 239.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesFossilFuelVans_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesFossilFuelVans_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesFossilFuelVans_pct, 0 ), getMax() ) );
      }
    };
    sl_companiesElectricVans_pct = new ShapeSlider(
tabMobility.this, true, 260.0, 217.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_companiesElectricVans_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_companiesElectricVans_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_companiesElectricVans_pct, 0 ), getMax() ) );
      }
    };
    cb_companiesSpreadChargingEVs = new ShapeCheckBox(
tabMobility.this,true,302.0, 74.0,
		40.0, 30.0,
            black, true,
            _cb_companiesSpreadChargingEVs_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_companiesSpreadChargingEVs, 0, value );
      }
    };
    cb_setChargingAttitude = new ShapeComboBox(
tabMobility.this, true, 265.0, 640.0,
			100.0, 20.0,
            white, black, true,
_cb_setChargingAttitude_Font,
            new String[]{"Standaard", "Gelimiteerd vermogen", "Prijsgestuurd", "Custom", }, false, ShapeControl.TYPE_STRING ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_setChargingAttitude, 0, value );
      }
    };
    sl_householdPublicChargers_pct = new ShapeSlider(
tabMobility.this, true, 260.0, 205.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdPublicChargers_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdPublicChargers_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdPublicChargers_pct, 0 ), getMax() ) );
      }
    };
    sl_householdPrivateEVs_pct = new ShapeSlider(
tabMobility.this, true, 260.0, 75.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdPrivateEVs_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdPrivateEVs_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdPrivateEVs_pct, 0 ), getMax() ) );
      }
    };
    sl_householdChargersThatSupportV2G_pct = new ShapeSlider(
tabMobility.this, true, 251.0, 5.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdChargersThatSupportV2G_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdChargersThatSupportV2G_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdChargersThatSupportV2G_pct, 0 ), getMax() ) );
      }
    };
    sl_householdChargersThatSupportV1G_pct = new ShapeSlider(
tabMobility.this, true, 255.0, 0.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdChargersThatSupportV1G_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdChargersThatSupportV1G_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdChargersThatSupportV1G_pct, 0 ), getMax() ) );
      }
    };
    cb_householdActivateV2GPrivateParkedCars = new ShapeCheckBox(
tabMobility.this,true,132.0, -18.0,
		20.0, 30.0,
            black, true,
            _cb_householdActivateV2GPrivateParkedCars_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_householdActivateV2GPrivateParkedCars, 0, value );
      }
    };
    cb_householdChargingStrategyPrivateParkedCars = new ShapeComboBox(
tabMobility.this, true, 221.0, 103.0,
			140.0, 20.0,
            white, black, true,
_cb_householdChargingStrategyPrivateParkedCars_Font,
            new String[]{"Niet slim laden", "Slim laden: Prijs gestuurd", "Slim laden: Prijs marktfeedback", "Slim laden: Netbewust", "Gevarieerd", }, false, ShapeControl.TYPE_STRING ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _cb_householdChargingStrategyPrivateParkedCars_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_householdChargingStrategyPrivateParkedCars, 0, value );
      }
    };
    cb_householdChargingStrategyPrivatePublicChargers = new ShapeComboBox(
tabMobility.this, true, 221.0, 233.0,
			140.0, 20.0,
            white, black, true,
_cb_householdChargingStrategyPrivatePublicChargers_Font,
            new String[]{"Niet slim laden", "Slim laden: Prijs gestuurd", "Slim laden: Prijs marktfeedback", "Slim laden: Netbewust", "Gevarieerd", }, false, ShapeControl.TYPE_STRING ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _cb_householdChargingStrategyPrivatePublicChargers_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_householdChargingStrategyPrivatePublicChargers, 0, value );
      }
    };
    cb_householdActivateV2GPublicChargers = new ShapeCheckBox(
tabMobility.this,true,132.0, -18.0,
		20.0, 30.0,
            black, true,
            _cb_householdActivateV2GPublicChargers_Font,
			"" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_householdActivateV2GPublicChargers, 0, value );
      }
    };
    sl_householdEVsThatSupportV2G_pct = new ShapeSlider(
tabMobility.this, true, 251.0, 5.0,
			100.0, 30.0,
            true, false,
            0
            , 100
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_householdEVsThatSupportV2G_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _sl_householdEVsThatSupportV2G_pct, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_householdEVsThatSupportV2G_pct, 0 ), getMax() ) );
      }
    };
    rect_genericFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,10.0, 470.0, 0.0, 0.0,
            silver, white,
			960.0, 470.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_genericFunctions = new ShapeText(
        SHAPE_DRAW_2D, false,100.0, 490.0, 0.0, 0.0,
        black,"Generic Functions",
        _t_genericFunctions_Font, ALIGNMENT_LEFT );
    rect_mobilityDemandSliders_default = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, _rect_mobilityDemandSliders_default_Fill_Color,
			370.0, 350.0, 10.0, 1.0, LINE_STYLE_DOTTED );
    txt_companiesFossilFuelCars_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 314.0, 0.0, 0.0,
        black,"#",
        _txt_companiesFossilFuelCars_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesFossilFuelCars_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesFossilFuelCarsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 314.0, 0.0, 0.0,
        black,"Fossiele brandstof",
        _txt_companiesFossilFuelCarsDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesFossilFuelCarsDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesElectricTrucksDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 130.0, 0.0, 0.0,
        black,"Elektrisch",
        _txt_companiesElectricTrucksDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesElectricTrucksDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesElectricTrucks_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 130.0, 0.0, 0.0,
        black,"#",
        _txt_companiesElectricTrucks_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesElectricTrucks_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesMobilityDemandReductionDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 60.0, 0.0, 0.0,
        black,"Besparing transport",
        _txt_companiesMobilityDemandReductionDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesMobilityDemandReductionDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesMobilityDemandReduction_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 60.0, 0.0, 0.0,
        black,"#",
        _txt_companiesMobilityDemandReduction_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesMobilityDemandReduction_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesHydrogenTrucksDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 152.0, 0.0, 0.0,
        black,"Waterstof",
        _txt_companiesHydrogenTrucksDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesHydrogenTrucksDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesHydrogenTrucks_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 152.0, 0.0, 0.0,
        black,"#",
        _txt_companiesHydrogenTrucks_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesHydrogenTrucks_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesFossilFuelTrucksDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 174.0, 0.0, 0.0,
        black,"Fossiele brandstof",
        _txt_companiesFossilFuelTrucksDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesFossilFuelTrucksDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_fossilFuelTrucks_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 174.0, 0.0, 0.0,
        black,"#",
        _t_fossilFuelTrucks_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _t_fossilFuelTrucks_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_trucksDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 110.0, 0.0, 0.0,
        black,"Vrachtwagens",
        _t_trucksDescription_Font, ALIGNMENT_LEFT );
    txt_companiesElectricCarsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 292.0, 0.0, 0.0,
        black,"Elektrisch",
        _txt_companiesElectricCarsDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesElectricCarsDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesElectricCars_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 292.0, 0.0, 0.0,
        black,"#",
        _txt_companiesElectricCars_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesElectricCars_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_carsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 272.0, 0.0, 0.0,
        black,"Auto's",
        _t_carsDescription_Font, ALIGNMENT_LEFT );
    txt_companiesFossilFuelVans_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 244.0, 0.0, 0.0,
        black,"#",
        _txt_companiesFossilFuelVans_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesFossilFuelVans_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesFossilFuelVansDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 244.0, 0.0, 0.0,
        black,"Fossiele brandstof",
        _txt_companiesFossilFuelVansDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesFossilFuelVansDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesElectricVansDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 222.0, 0.0, 0.0,
        black,"Elektrisch",
        _txt_companiesElectricVansDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesElectricVansDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_companiesElectricVans_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 222.0, 0.0, 0.0,
        black,"#",
        _txt_companiesElectricVans_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesElectricVans_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    t_vansDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 202.0, 0.0, 0.0,
        black,"Busjes",
        _t_vansDescription_Font, ALIGNMENT_LEFT );
    i_companiesMobilityReduction = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 58.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companiesMobilityReduction_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companiesMobilityReduction, 0, clickx, clicky );
      }
    };
    i_companiesElectricTruck = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 128.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companiesElectricTruck_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companiesElectricTruck, 0, clickx, clicky );
      }
    };
    i_companiesHydrogenTruck = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 150.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companiesHydrogenTruck_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companiesHydrogenTruck, 0, clickx, clicky );
      }
    };
    i_companiesFossilFuelTruck = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 172.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companiesFossilFuelTruck_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companiesFossilFuelTruck, 0, clickx, clicky );
      }
    };
    i_companiesElectricVans = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 220.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companiesElectricVans_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companiesElectricVans, 0, clickx, clicky );
      }
    };
    i_companiesFossilFuelVans = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 242.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companiesFossilFuelVans_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companiesFossilFuelVans, 0, clickx, clicky );
      }
    };
    i_companiesElectricCars = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 290.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companiesElectricCars_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companiesElectricCars, 0, clickx, clicky );
      }
    };
    i_companiesFossilFuelCars = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 312.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companiesFossilFuelCars_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companiesFossilFuelCars, 0, clickx, clicky );
      }
    };
    txt_companiesSpreadChargingEVsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 82.0, 0.0, 0.0,
        black,"Slim laden",
        _txt_companiesSpreadChargingEVsDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_companiesSpreadChargingEVsDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_companiesMobilityChargingAttitude = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 80.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_companiesMobilityChargingAttitude_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_companiesMobilityChargingAttitude, 0, clickx, clicky );
      }
    };
    txt_mobilitySlidersCompaniesDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 20.0, 0.0, 0.0,
        black,"Bedrijven",
        _txt_mobilitySlidersCompaniesDescription_Font, ALIGNMENT_LEFT );
    rect_demandFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,50.0, 550.0, 0.0, 0.0,
            olive, white,
			300.0, 70.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_demandFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,200.0, 560.0, 0.0, 0.0,
        black,"Demand Functions",
        _t_demandFunctionsDescription_Font, ALIGNMENT_CENTER );
    rect_mobilityFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,50.0, 690.0, 0.0, 0.0,
            brown, white,
			900.0, 230.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_mobilityFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,170.0, 700.0, 0.0, 0.0,
        black,"Mobility Functions (default)",
        _t_mobilityFunctionsDescription_Font, ALIGNMENT_CENTER );
    rect_mobilityDemandSliders_residential = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, _rect_mobilityDemandSliders_residential_Fill_Color,
			370.0, 350.0, 10.0, 1.0, LINE_STYLE_DOTTED );
    txt_privateParkedCars = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 60.0, 0.0, 0.0,
        black,"Privé geparkeerde autos",
        _txt_privateParkedCars_Font, ALIGNMENT_LEFT );
    txt_publicChargePoints = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 190.0, 0.0, 0.0,
        black,"Publieke laadpalen",
        _txt_publicChargePoints_Font, ALIGNMENT_LEFT );
    txt_householdPublicEVsResidentialAreaDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 210.0, 0.0, 0.0,
        black,"Actieve laadpalen in gebied",
        _txt_householdPublicEVsResidentialAreaDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdPublicEVsResidentialAreaDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdPublicEVs_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 210.0, 0.0, 0.0,
        black,"0%",
        _txt_householdPublicEVs_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdPublicEVs_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdPrivateEVsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 80.0, 0.0, 0.0,
        black,"Aandeel Elektrisch",
        _txt_householdPrivateEVsDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdPrivateEVsDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdPrivateEVs_pct = new ShapeText(
        SHAPE_DRAW_2D, true,245.0, 80.0, 0.0, 0.0,
        black,"0%",
        _txt_householdPrivateEVs_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdPrivateEVs_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_chargersThatSupportV2GDescription = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, 10.0, 0.0, 0.0,
        black,"Laadpalen met V2G",
        _txt_chargersThatSupportV2GDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_chargersThatSupportV2GDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdChargersThatSupportV2G_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 10.0, 0.0, 0.0,
        black,"0%",
        _txt_householdChargersThatSupportV2G_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdChargersThatSupportV2G_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdPublicChargersV2G = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 170.0, 8.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdPublicChargersV2G_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdPublicChargersV2G, 0, clickx, clicky );
      }
    };
    i_householdPrivateEV = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 78.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdPrivateEV_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdPrivateEV, 0, clickx, clicky );
      }
    };
    i_householdPublicChargers = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 208.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdPublicChargers_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdPublicChargers, 0, clickx, clicky );
      }
    };
    txt_householdChargersThatSupportV1GDescription = new ShapeText(
        SHAPE_DRAW_2D, true,15.0, 5.0, 0.0, 0.0,
        black,"Laadpalen met V1G",
        _txt_householdChargersThatSupportV1GDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdChargersThatSupportV1GDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdChargersThatSupportV1G_pct = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 5.0, 0.0, 0.0,
        black,"0%",
        _txt_householdChargersThatSupportV1G_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdChargersThatSupportV1G_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdPublicChargersV1G = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 175.0, 3.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdPublicChargersV1G_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdPublicChargersV1G, 0, clickx, clicky );
      }
    };
    i_householdActivateV2GPrivateParkedCars = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 10.0, -12.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdActivateV2GPrivateParkedCars_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdActivateV2GPrivateParkedCars, 0, clickx, clicky );
      }
    };
    txt_householdActivateV2GPrivateParkedCars = new ShapeText(
        SHAPE_DRAW_2D, true,-150.0, -10.0, 0.0, 0.0,
        black,"Activeer V2G",
        _txt_householdActivateV2GPrivateParkedCars_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdActivateV2GPrivateParkedCars_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdChargingStrategyPrivateParkedCars = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 105.0, 0.0, 0.0,
        black,"Laad strategie",
        _txt_householdChargingStrategyPrivateParkedCars_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdChargingStrategyPrivateParkedCars_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdChargingStrategyPrivateParkedCars = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 103.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdChargingStrategyPrivateParkedCars_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdChargingStrategyPrivateParkedCars, 0, clickx, clicky );
      }
    };
    txt_chargingStrategyPublicChargers = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 235.0, 0.0, 0.0,
        black,"Laad strategie",
        _txt_chargingStrategyPublicChargers_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_chargingStrategyPublicChargers_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdChargingStrategyPublicChargers = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 180.0, 233.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdChargingStrategyPublicChargers_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdChargingStrategyPublicChargers, 0, clickx, clicky );
      }
    };
    i_householdActivateV2GPrivatePublicChargers = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 10.0, -12.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdActivateV2GPrivatePublicChargers_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdActivateV2GPrivatePublicChargers, 0, clickx, clicky );
      }
    };
    txt_activateV2GPrivatePublicChargers = new ShapeText(
        SHAPE_DRAW_2D, true,-150.0, -10.0, 0.0, 0.0,
        black,"Activeer V2G",
        _txt_activateV2GPrivatePublicChargers_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_activateV2GPrivatePublicChargers_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdEVsThatSupportV2GDescription = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, 10.0, 0.0, 0.0,
        black,"EVs die V2G ondersteunen",
        _txt_householdEVsThatSupportV2GDescription_Font, ALIGNMENT_LEFT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdEVsThatSupportV2GDescription_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_householdEVsThatSupportV2G_pct = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 10.0, 0.0, 0.0,
        black,"0%",
        _txt_householdEVsThatSupportV2G_pct_Font, ALIGNMENT_RIGHT ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _txt_householdEVsThatSupportV2G_pct_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    i_householdEVsThatSupportV2G = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 170.0, 8.0, 0.0, 0.0,
20.0, 20.0, "/zerointerfaceloader/",
			new String[]{"icon_i.png",} ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _i_householdEVsThatSupportV2G_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_householdEVsThatSupportV2G, 0, clickx, clicky );
      }
    };
    txt_mobilitySlidersHousesholdsDescription = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 20.0, 0.0, 0.0,
        black,"Huizen",
        _txt_mobilitySlidersHousesholdsDescription_Font, ALIGNMENT_LEFT );
    txt_mobilityFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,590.0, 510.0, 0.0, 0.0,
        black,"Mobility Functions",
        _txt_mobilityFunctionsDescription_Font, ALIGNMENT_CENTER );
    rect_mobilityFunctions1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,440.0, 500.0, 0.0, 0.0,
            lime, white,
			310.0, 170.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_mobilityFunctionsDescription1 = new ShapeText(
        SHAPE_DRAW_2D, false,590.0, 510.0, 0.0, 0.0,
        black,"Mobility Functions (residential)",
        _t_mobilityFunctionsDescription1_Font, ALIGNMENT_CENTER );
    arrowLeftResidential = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, -35.0, -12.0, 0.0, 1.5707963267948966,
12.0, 12.0, "/zerointerfaceloader/",
			new String[]{"icon_arrow.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _arrowLeftResidential, 0, clickx, clicky );
      }
    };
    arrowRightResidential1 = new ShapeImage(
		tabMobility.this, SHAPE_DRAW_2D3D, true, 35.0, 0.0, 0.0, 4.71238898038469,
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
    gr_mobilitySliders_companies = new ShapeGroup( tabMobility.this, SHAPE_DRAW_2D3D, true, 400.0, 0.0, 0.0, 0.0
	
	     , rect_mobilityDemandSliders_default
	     , sl_companiesFossilFuelCars_pct
	     , sl_companiesElectricTrucks_pct
	     , txt_companiesFossilFuelCars_pct
	     , txt_companiesFossilFuelCarsDescription
	     , txt_companiesElectricTrucksDescription
	     , txt_companiesElectricTrucks_pct
	     , txt_companiesMobilityDemandReductionDescription
	     , sl_companiesMobilityDemandReduction_pct
	     , txt_companiesMobilityDemandReduction_pct
	     , sl_companiesHydrogenTrucks_pct
	     , txt_companiesHydrogenTrucksDescription
	     , txt_companiesHydrogenTrucks_pct
	     , sl_companiesFossilFuelTrucks_pct
	     , txt_companiesFossilFuelTrucksDescription
	     , t_fossilFuelTrucks_pct
	     , t_trucksDescription
	     , sl_companiesElectricCars_pct
	     , txt_companiesElectricCarsDescription
	     , txt_companiesElectricCars_pct
	     , t_carsDescription
	     , sl_companiesFossilFuelVans_pct
	     , txt_companiesFossilFuelVans_pct
	     , txt_companiesFossilFuelVansDescription
	     , sl_companiesElectricVans_pct
	     , txt_companiesElectricVansDescription
	     , txt_companiesElectricVans_pct
	     , t_vansDescription
	     , i_companiesMobilityReduction
	     , i_companiesElectricTruck
	     , i_companiesHydrogenTruck
	     , i_companiesFossilFuelTruck
	     , i_companiesElectricVans
	     , i_companiesFossilFuelVans
	     , i_companiesElectricCars
	     , i_companiesFossilFuelCars
	     , cb_companiesSpreadChargingEVs
	     , txt_companiesSpreadChargingEVsDescription
	     , i_companiesMobilityChargingAttitude
	     , txt_mobilitySlidersCompaniesDescription ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_mobilitySliders_companies_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_mobilitySliders_companies.setVisible( false );
    {
    gr_householdSettingsV2G_publicChargers = new ShapeGroup( tabMobility.this, SHAPE_DRAW_2D3D, true, 10.0, 300.0, 0.0, 0.0
	
	     , sl_householdChargersThatSupportV2G_pct
	     , txt_chargersThatSupportV2GDescription
	     , txt_householdChargersThatSupportV2G_pct
	     , i_householdPublicChargersV2G );
    }
    gr_householdSettingsV2G_publicChargers.setVisible( false );
    {
    gr_householdSettingsV1G_publicChargers = new ShapeGroup( tabMobility.this, SHAPE_DRAW_2D3D, true, 5.0, 255.0, 0.0, 0.0
	
	     , sl_householdChargersThatSupportV1G_pct
	     , txt_householdChargersThatSupportV1GDescription
	     , txt_householdChargersThatSupportV1G_pct
	     , i_householdPublicChargersV1G );
    }
    gr_householdSettingsV1G_publicChargers.setVisible( false );
    {
    gr_householdActivateV2GPrivateParkedCars = new ShapeGroup( tabMobility.this, SHAPE_DRAW_2D3D, true, 170.0, 140.0, 0.0, 0.0
	
	     , cb_householdActivateV2GPrivateParkedCars
	     , i_householdActivateV2GPrivateParkedCars
	     , txt_householdActivateV2GPrivateParkedCars );
    }
    gr_householdActivateV2GPrivateParkedCars.setVisible( false );
    {
    gr_householdActivateV2GPublicChargers = new ShapeGroup( tabMobility.this, SHAPE_DRAW_2D3D, true, 170.0, 295.0, 0.0, 0.0
	
	     , cb_householdActivateV2GPublicChargers
	     , i_householdActivateV2GPrivatePublicChargers
	     , txt_activateV2GPrivatePublicChargers );
    }
    gr_householdActivateV2GPublicChargers.setVisible( false );
    {
    gr_householdSettingsV2G_privateParkedCars = new ShapeGroup( tabMobility.this, SHAPE_DRAW_2D3D, true, 10.0, 145.0, 0.0, 0.0
	
	     , sl_householdEVsThatSupportV2G_pct
	     , txt_householdEVsThatSupportV2GDescription
	     , txt_householdEVsThatSupportV2G_pct
	     , i_householdEVsThatSupportV2G );
    }
    gr_householdSettingsV2G_privateParkedCars.setVisible( false );
    {
    gr_mobilitySliders_households = new ShapeGroup( tabMobility.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , rect_mobilityDemandSliders_residential
	     , txt_privateParkedCars
	     , txt_publicChargePoints
	     , sl_householdPublicChargers_pct
	     , txt_householdPublicEVsResidentialAreaDescription
	     , txt_householdPublicEVs_pct
	     , txt_householdPrivateEVsDescription
	     , sl_householdPrivateEVs_pct
	     , txt_householdPrivateEVs_pct
	     , gr_householdSettingsV2G_publicChargers
	     , i_householdPrivateEV
	     , i_householdPublicChargers
	     , gr_householdSettingsV1G_publicChargers
	     , gr_householdActivateV2GPrivateParkedCars
	     , txt_householdChargingStrategyPrivateParkedCars
	     , cb_householdChargingStrategyPrivateParkedCars
	     , i_householdChargingStrategyPrivateParkedCars
	     , txt_chargingStrategyPublicChargers
	     , cb_householdChargingStrategyPrivatePublicChargers
	     , i_householdChargingStrategyPublicChargers
	     , gr_householdActivateV2GPublicChargers
	     , gr_householdSettingsV2G_privateParkedCars
	     , txt_mobilitySlidersHousesholdsDescription ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_mobilitySliders_households_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_mobilitySliders_households.setVisible( false );
    {
    gr_pageIndicator = new ShapeGroup( tabMobility.this, SHAPE_DRAW_2D3D, true, 185.0, 20.0, 0.0, 0.0
	
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
  public tabMobility( Engine engine, Agent owner, AgentList<? extends tabMobility> ownerPopulation ) {
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
  public tabMobility() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_tabMobility_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "zerointerfaceloader.tabMobility.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( tabMobility.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    sl_companiesFossilFuelCars_pct.setValueToDefault();
    sl_companiesElectricTrucks_pct.setValueToDefault();
    sl_companiesMobilityDemandReduction_pct.setValueToDefault();
    sl_companiesHydrogenTrucks_pct.setValueToDefault();
    sl_companiesFossilFuelTrucks_pct.setValueToDefault();
    sl_companiesElectricCars_pct.setValueToDefault();
    sl_companiesFossilFuelVans_pct.setValueToDefault();
    sl_companiesElectricVans_pct.setValueToDefault();
    sl_householdPublicChargers_pct.setValueToDefault();
    sl_householdPrivateEVs_pct.setValueToDefault();
    sl_householdChargersThatSupportV2G_pct.setValueToDefault();
    sl_householdChargersThatSupportV1G_pct.setValueToDefault();
    sl_householdEVsThatSupportV2G_pct.setValueToDefault();
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
    setupPlainVariables_tabMobility_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_tabMobility_xjal() {
    v_totalNumberOfGhostVehicle_Trucks = 
0 
;
    v_totalNumberOfGhostVehicle_Vans = 
0 
;
    v_totalNumberOfGhostVehicle_Cars = 
0 
;
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

  public AgentList<? extends tabMobility> getPopulation() {
    return (AgentList<? extends tabMobility>) super.getPopulation();
  }

  public List<? extends tabMobility> agentsInRange( double distance ) {
    return (List<? extends tabMobility>) super.agentsInRange( distance );
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
public ShapeGroup getGroupMobilitySliders_Households() {
	return this.gr_mobilitySliders_households;
}

public ShapeGroup getGroupMobilitySliders_Companies() {
	return this.gr_mobilitySliders_companies;
}

//Household sliders
public ShapeSlider getSliderHouseholdPrivateEVs_pct(){
	return this.sl_householdPrivateEVs_pct;
}

public ShapeSlider getSliderHouseholdEVsThatSupportV2G_pct(){
	return this.sl_householdEVsThatSupportV2G_pct;
}

public ShapeSlider getSliderHouseholdPublicChargers_pct(){
	return this.sl_householdPublicChargers_pct;
}

public ShapeSlider getSliderHouseholdChargersThatSupportV1G_pct(){
	return this.sl_householdChargersThatSupportV1G_pct;
}

public ShapeSlider getSliderHouseholdChargersThatSupportV2G_pct(){
	return this.sl_householdChargersThatSupportV2G_pct;
}

// Company sliders
public ShapeSlider getSliderCompaniesMobilityDemandReduction_pct () {
	return this.sl_companiesMobilityDemandReduction_pct;
}

public ShapeSlider getSliderCompaniesElectricTrucks_pct() {
	return this.sl_companiesElectricTrucks_pct;
}

public ShapeSlider getSliderCompaniesHydrogenTrucks_pct() {
	return this.sl_companiesHydrogenTrucks_pct;
}

public ShapeSlider getSliderCompaniesFossilFuelTrucks_pct() {
	return this.sl_companiesFossilFuelTrucks_pct;
}

public ShapeSlider getSliderCompaniesElectricVans_pct() {
	return this.sl_companiesElectricVans_pct;
}

public ShapeSlider getSliderCompaniesFossilFuelVans_pct() {
	return this.sl_companiesFossilFuelVans_pct;
}

public ShapeSlider getSliderCompaniesElectricCars_pct() {
	return this.sl_companiesElectricCars_pct;
}

public ShapeSlider getSliderCompaniesFossilFuelCars_pct() {
	return this.sl_companiesFossilFuelCars_pct;
} 
  // End of additional class code

}
