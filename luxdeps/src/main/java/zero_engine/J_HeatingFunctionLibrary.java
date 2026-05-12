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
 * J_HeatingFunctionLibrary
 */	
public abstract class J_HeatingFunctionLibrary {
	public static double heatingDaysAvgTempTreshold_degC = 18;
	public static double heatLossByWindowVentilationMultiplier = 5;
	/*
	public void setHeatingDaysSetpoint_degC(double value) {
		this.heatingDaysSetpoint_degC = value;
	}
	public double getHeatingDaysSetpoint_degC() {
		return this.heatingDaysSetpoint_degC;
	}*/
	
	public static double  managePTAndHotWaterHeatBuffer(J_EAStorageHeat hotWaterBuffer, List<J_EAProduction> ptAssets, double hotWaterDemand_kW, J_TimeVariables timeVariables, GridConnection gc){
    	//Calculate the pt production
    	double ptProduction_kW = 0;
    	for (J_EA j_ea : ptAssets) {
    		ptProduction_kW -= j_ea.getLastFlows().get(OL_EnergyCarriers.HEAT);
    	}
    	
    	//Calculate the remaining hot water energy need after pt production, also calculate the remaining unused pt production
    	double remainingHotWater_kW = max(0, hotWaterDemand_kW - ptProduction_kW); // Need to do this, because pt has already compensated the hot water demand in the gc flows, so just need to update this value
    	double remainingPTProduction_kW = max(0, ptProduction_kW - hotWaterDemand_kW);
    	
    	if(hotWaterBuffer != null){
    		double chargeSetpoint_kW = 0;
    		if(remainingHotWater_kW > 0) {
    			chargeSetpoint_kW = -remainingHotWater_kW;
    		}
    		else if(remainingPTProduction_kW > 0) {
    			chargeSetpoint_kW = remainingPTProduction_kW;
    		}
    		double powerFraction_fr = chargeSetpoint_kW / hotWaterBuffer.getCapacityHeat_kW();
        	gc.f_updateFlexAssetFlows(hotWaterBuffer, powerFraction_fr, timeVariables);

    		
			double heatBufferCharge_kW = hotWaterBuffer.getLastFlows().get(OL_EnergyCarriers.HEAT);
			
    		if(remainingHotWater_kW > 0){//Only if the current pt production, wasnt enough, adjust the hotwater demand with the buffer, cause then the buffer will have tried to discharge
    			remainingHotWater_kW = max(0, remainingHotWater_kW + heatBufferCharge_kW);
    		}
    		else {//Curtail the remaining pt that is not used for hot water
    			remainingPTProduction_kW = max(0, remainingPTProduction_kW - heatBufferCharge_kW);
    		}
    	}
    	
    	if (remainingPTProduction_kW > 0) {//Heat (for now always curtail over produced heat!)
    		for (J_EAProduction j_ea : ptAssets) {
    			J_FlowPacket flowPacket = j_ea.curtailEnergyCarrierProduction( OL_EnergyCarriers.HEAT, remainingPTProduction_kW);
    			gc.f_removeFlows(flowPacket, j_ea);
    			remainingPTProduction_kW += flowPacket.energyUse_kW; // Curtailed energyUse_kW will be a negative number when curtailing a production asset, hence the += !
    			
    			if (remainingPTProduction_kW <= 0) {
    				break;
    			}
    		}
    	}
    	return remainingHotWater_kW;
    }
	
	public static double  manageHotWaterHeatBuffer(J_EAStorageHeat hotWaterBuffer, double hotWaterDemand_kW, double availableHeatingPower_kWth, double timeStep_h, J_TimeVariables timeVariables, GridConnection gc){
		if(hotWaterDemand_kW > availableHeatingPower_kWth + hotWaterBuffer.getCurrentStateOfCharge_kWh() / timeStep_h) {
			throw new RuntimeException("Hot water demand is higher than available power.");
		}
		
		//Heating asset should always try to fill the heat buffer as fast as possible.
		double hotWaterDemandFromHeatingAsset_kW = min(availableHeatingPower_kWth, hotWaterDemand_kW + (hotWaterBuffer.getStorageCapacity_kWh() - hotWaterBuffer.getCurrentStateOfCharge_kWh()));
		double heatIntoBuffer_kW =  hotWaterDemandFromHeatingAsset_kW - hotWaterDemand_kW;
				

		double powerFraction_fr = heatIntoBuffer_kW / hotWaterBuffer.getCapacityHeat_kW();
    	gc.f_updateFlexAssetFlows(hotWaterBuffer, powerFraction_fr, timeVariables);


		
    	return hotWaterDemandFromHeatingAsset_kW;
    }
	
	public static void setWindowVentilation_fr( J_EABuilding dwelling, double windowOpenSetpoint_degc) {
		double additionalVentilation_fr = 0;
		
		if( dwelling.getCurrentTemperature() > windowOpenSetpoint_degc && dwelling.getAmbientTemperature_degC() < dwelling.getCurrentTemperature() ) {
			additionalVentilation_fr = heatLossByWindowVentilationMultiplier;
		}
		dwelling.setAdditionalVentilation_fr(additionalVentilation_fr);
	}
}
 
 
 
 
 
 
 
 
 
  
