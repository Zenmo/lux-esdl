double storageCapacity_kWh 		= 0;
double energyConsumption_kWhpkm = 0;
double capacityElectricity_kW 	= 0;
double stateOfCharge_fr  		= 1; // Initial state of charge
J_TimeParameters timeParameters	= energyModel.p_timeParameters;
double vehicleScaling 			= 1.0;

switch(vehicle_type){
	
	/*
	case ELECTRIC_VEHICLE_COMUTERS: // ??? Hoe laad je andere laadprofielen in.?? Deze moet ander laadprofiel dan de Standaard Electric_vehicle 
		capacityElectricity_kW	= avgc_data.p_avgEVMaxChargePowerCar_kW;
		storageCapacity_kWh		= avgc_data.p_avgEVStorageCar_kWh;
		energyConsumption_kWhpkm = avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm;
	break;
	*/
	
	case ELECTRIC_VEHICLE:
		capacityElectricity_kW	= avgc_data.p_avgEVMaxChargePowerCar_kW;
		storageCapacity_kWh		= avgc_data.p_avgEVStorageCar_kWh;
		energyConsumption_kWhpkm = avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm;
	break;
	
	case ELECTRIC_VAN:
		capacityElectricity_kW 	= avgc_data.p_avgEVMaxChargePowerVan_kW;
		storageCapacity_kWh		= avgc_data.p_avgEVStorageVan_kWh;
		energyConsumption_kWhpkm = avgc_data.p_avgEVEnergyConsumptionVan_kWhpkm;
	break;
	
	case ELECTRIC_TRUCK:
		capacityElectricity_kW	= avgc_data.p_avgEVMaxChargePowerTruck_kW;
		storageCapacity_kWh		= avgc_data.p_avgEVStorageTruck_kWh;
		energyConsumption_kWhpkm = avgc_data.p_avgEVEnergyConsumptionTruck_kWhpkm;
	break;
	
}

if (!isDefaultVehicle && maxChargingPower_kW > 0){
	capacityElectricity_kW	= maxChargingPower_kW;
}
if (!isDefaultVehicle && maxChargingPower_kW <= 0) {
	traceln("Trying to create an EV with no/negative maxChargingPower_kW: %s", maxChargingPower_kW);
}

//Create the EV vehicle energy asset with the set parameters + links
J_EAEV electricVehicle = new J_EAEV(parentGC, capacityElectricity_kW, storageCapacity_kWh, stateOfCharge_fr, timeParameters, energyConsumption_kWhpkm, vehicleScaling, vehicle_type, tripTracker);	

// Trips that were handed in state the real distances of this vehicle, scaling them to an
// average annual distance would throw that away.
if (tripTracker == null) {
	if (!isDefaultVehicle && annualTravelDistance_km > avgc_data.p_minAnnualTravelDistanceSurveyVehicle_km){
			electricVehicle.getTripTracker().setAnnualDistance_km(annualTravelDistance_km);
	}
	else if (vehicle_type == OL_EnergyAssetType.ELECTRIC_VAN){
			electricVehicle.getTripTracker().setAnnualDistance_km(avgc_data.p_avgAnnualTravelDistanceVan_km);
	}
}

if (parentGC.f_getChargingManagement() == null) {
	parentGC.f_addChargingManagement(chargingAttitude);
}
else {
	if (parentGC.f_getCurrentChargingType() != chargingAttitude) {
		throw new RuntimeException( String.format("Tried to add EV with charging attitude %s to GC %s with charging type %s",
			chargingAttitude,
			parentGC.p_gridConnectionID,
			parentGC.f_getCurrentChargingType()
			)
		);
	}
}

return electricVehicle;
