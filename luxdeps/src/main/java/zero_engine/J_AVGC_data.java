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

import static com.anylogic.engine.Utilities.*;

/**
 * J_AVGC_data
 */	
public class J_AVGC_data {
	
	////Averages
	
	//Houses
	public double p_avgHouseGasConsumption_m3_yr;
	public double p_maxAvgHouseGasConsumptionOffset_m3pa;
	public double p_avgHouseElectricityConsumption_kWh_yr;
	public double p_maxAvgHouseElectricityConsumptionOffset_kWhpa;
	public double p_avgHousePVInstallationPower_kWp;
	public double p_avgHouseConnectionCapacity_kW;
	public OL_GridConnectionHeatingType p_avgHouseHeatingMethod;
	public OL_HouseholdCookingMethod p_avgHouseCookingMethod;
	public double p_avgNrOfCarsPerHouse;
	public double p_ratioEVHousePersonalCars;
	public double p_ratioHouseInstalledPV;
	public double p_avgRatioHouseBatteryStorageCapacity_v_PVPower;
	public double p_avgSpaceHeatingTotalGasConsumptionShare_fr;
	public double p_avgDHWTotalGasConsumptionShare_fr;
	public double p_avgCookingTotalGasConsumptionShare_fr;
	
	//Utilities
	public OL_GridConnectionHeatingType p_avgUtilityHeatingMethod;
	public double p_avgUtilityConnectionCapacity_kW;
	public double p_avgUtilityPVPower_kWp;
	public double p_ratioElectricTrucks;
	public OL_GridConnectionHeatingType p_avgCompanyHeatingMethod;
	public double p_avgCompanyElectricityConsumption_kWhpm2;
	public double p_avgCompanyGasConsumption_m3pm2;
	public double p_avgCompanyHeatConsumption_kWhpm2;

	
	//Energy assets
	public double p_avgCOPHeatpump;
	public double p_avgEfficiencyHeatpump_fr;
	public double p_avgOutputTemperatureElectricHeatpump_degC;
	public double p_avgOutputTemperatureHybridHeatpump_degC;
	public double p_minHeatpumpElectricCapacity_kW;

	public double p_avgEfficiencyGasBurner_fr;
	public double p_avgOutputTemperatureGasBurner_degC;
	public double p_minGasBurnerOutputCapacity_kW;
	
	public double p_avgEfficiencyHydrogenBurner_fr;
	public double p_avgOutputTemperatureHydrogenBurner_degC;
	public double p_minHydrogenBurnerOutputCapacity_kW;

	public double p_avgEfficiencyDistrictHeatingDeliverySet_fr;
	public double p_avgOutputTemperatureDistrictHeatingDeliverySet_degC;
	public double p_minDistrictHeatingDeliverySetOutputCapacity_kW;

	
	public double p_avgPVPower_kWpm2;
	public double p_avgAnnualProductionPV_kWhpWp;
	public double p_avgRatioRoofPotentialPV;
	public double p_avgSolarFieldPower_kWppha;
	public OL_PVOrientation p_defaultPVOrientation;
	
	public double p_avgEfficiencyCHP_thermal_fr;
	public double p_avgEfficiencyCHP_electric_fr;
	public double p_avgOutputTemperatureCHP_degC;

	public double p_avgPTPower_kWpm2;
	public double p_avgPTPanelSize_m2;
	
	public double p_avgMaxHeatBufferTemperature_degC;
	public double p_avgMinHeatBufferTemperature_degC;
	public double p_avgHeatBufferWaterVolumePerPTSurface_m3pm2;
	public double p_avgHeatBufferWaterVolumePerHPPower_m3pkW;
	
	public double p_avgRatioBatteryCapacity_v_Power;
	
	//Thermal model parametes
	public double p_PBL_HeatingLossFactor_fr;
	public Map<OL_GridConnectionInsulationLabel, Double> map_insulationLabel_lossfactorPerFloorSurface_WpKm2;
	public double p_solarAbsorptionFloorSurfaceScalingFactor_fr;
	public Map<OL_GridConnectionInsulationLabel, Double> map_insulationLabel_cooldownPeriod_hr;
	public double p_heatCapacitySizingConstant_JpK;
	public double p_heatCapacitySizingSlope_JpKm2;
	public double p_heatCapacitySizingFactor_fr;

	//Vehicles
	public double p_avgEVMaxChargePowerCar_kW;
	public double p_avgEVMaxChargePowerVan_kW;
	public double p_avgEVMaxChargePowerTruck_kW;
	public double p_avgEVStorageCar_kWh;
	public double p_avgEVStorageVan_kWh;
	public double p_avgEVStorageTruck_kWh;

	public double p_avgEVEnergyConsumptionCar_kWhpkm;
	public double p_avgEVEnergyConsumptionVan_kWhpkm;
	public double p_avgEVEnergyConsumptionTruck_kWhpkm;	
	public double p_avgDieselConsumptionCar_kmpl;
	public double p_avgGasolineConsumptionCar_kmpl;	
	public double p_avgDieselConsumptionCar_kWhpkm;
	public double p_avgGasolineConsumptionCar_kWhpkm;
	public double p_avgDieselConsumptionVan_kmpl;
	public double p_avgDieselConsumptionVan_kWhpkm;
	public double p_avgDieselConsumptionTruck_kmpl;
	public double p_avgDieselConsumptionTruck_kWhpkm;
	public double p_avgHydrogenConsumptionCar_kWhpkm;
	public double p_avgHydrogenConsumptionVan_kWhpkm;
	public double p_avgHydrogenConsumptionTruck_kWhpkm;
	
	public int p_defaultNrOfVehiclesPerChargerSocket;
	public int p_defaultNrOfSocketsPerCharger;
	
	public double p_v1gProbability;
	public double p_v2gProbability;
	
	public double p_avgAnnualTravelDistancePrivateCar_km;
	public double p_avgAnnualTravelDistanceCompanyCar_km;
	public double p_avgAnnualTravelDistanceVan_km;
	public double p_avgAnnualTravelDistanceTruck_km;
	public double p_minAnnualTravelDistanceSurveyVehicle_km;
	
	//Emissions
	public Map<OL_EnergyCarriers, Double> map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh;
	public Map<OL_EnergyCarriers, Double> map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh;
	
	public J_AVGC_Economic_data economicAVGC;
	
	////Constants
	public double p_gas_kWhpm3;
	public double p_diesel_kWhpl;
	public double p_gasoline_kWhpl;
	public double p_waterHeatCapacity_JpkgK;
	public double p_waterDensity_kgpm3;
	
	public double p_hydrogenEnergyDensity_kWh_Nm3;
	public double p_hydrogenSpecificEnergy_kWh_kg;
	public double p_hydrogenDensity_kg_Nm3;
	public double p_oxygenDensity_kg_Nm3;
	public double p_oxygenProduction_kgO2pkgH2;
	
	
	/**
     * Default constructor
     */
    public J_AVGC_data() {
    	
    }

	@Override
	public String toString() {
		return super.toString();
	}
} 
