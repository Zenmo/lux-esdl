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
 * J_BatteryManagementPrice
 */	

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,    // 
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)

public class J_BatteryManagementPrice implements I_BatteryManagement {

    private GridConnection gc;
    J_TimeParameters timeParameters;
    // Parameters used:
    private boolean stayWithinConnectionLimits = true; // When this flag is true the battery stays within the contracted capacity of the GC
    private double chargeDischarge_offset_eurpkWh = 0.0; // This term determines the minimal price difference before the battery is used
    private double WTPfeedbackGain_eurpSOC = 0.5; // This term determines the unwillingness to use the battery when it is almost full or empty
    private double priceGain_kWhpeur = 2.0; // This term determines how strongly to ramp up power with price-delta's
    private double lowPassFactor_fr = 0.001;
    
    // Internal State
    private double electricityPriceLowPassed_eurpkWh;
    private double storedElectricityPriceLowPassed_eurpkWh;
    
    /**
     * Default constructor
     */
    
    public J_BatteryManagementPrice() {
		
	}
    
    public J_BatteryManagementPrice( GridConnection gc, J_TimeParameters timeParameters ) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    }
    
    public J_BatteryManagementPrice( GridConnection gc, J_TimeParameters timeParameters, boolean stayWithinConnectionLimits, double chargeDischarge_offset_eurpkWh, double WTPfeedbackGain_eurpSOC, double priceGain_kWhpeur, double priceTimescale_h ) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    	this.stayWithinConnectionLimits = stayWithinConnectionLimits;
    	this.chargeDischarge_offset_eurpkWh = chargeDischarge_offset_eurpkWh;
    	this.WTPfeedbackGain_eurpSOC = WTPfeedbackGain_eurpSOC;
    	this.priceGain_kWhpeur = priceGain_kWhpeur;
        this.lowPassFactor_fr = timeParameters.getTimeStep_h() / priceTimescale_h;
    }
    
    /**
     * This algorithm determines the battery behaviour with the historical national EPEX price. 
     * It has a boolean flag wether or not to take the GC's connection capacity into account.
     */
    public void manageBattery(J_TimeVariables timeVariables) {
    	if(gc.p_batteryAsset != null && gc.p_batteryAsset.getStorageCapacity_kWh() > 0) {
		    // Get the national EPEX price
		    double currentElectricityPriceCharge_eurpkWh = gc.energyModel.nationalEnergyMarket.f_getNationalElectricityPrice_eurpMWh()/1000;
		
		    // Base the WTP on a moving average price and the SOC
		    electricityPriceLowPassed_eurpkWh += lowPassFactor_fr * ( currentElectricityPriceCharge_eurpkWh - electricityPriceLowPassed_eurpkWh );
		    
		    double SOC_setpoint_fr = 0.5;
		    double SOC_deficit_fr = SOC_setpoint_fr - gc.p_batteryAsset.getCurrentStateOfCharge_fr(); // How far away from desired SOC? SOC too LOW is a POSITIVE deficit
		
		    // Define WTP price for charging and discharging!
		    double WTP_charge_eurpkWh = electricityPriceLowPassed_eurpkWh - chargeDischarge_offset_eurpkWh + SOC_deficit_fr * WTPfeedbackGain_eurpSOC;
		    double WTP_discharge_eurpkWh = electricityPriceLowPassed_eurpkWh + chargeDischarge_offset_eurpkWh + SOC_deficit_fr * WTPfeedbackGain_eurpSOC;
		
		    // Choose charging power based on prices and desired SOC level
		    double chargeSetpoint_kW = 0;
		    if ( WTP_charge_eurpkWh > currentElectricityPriceCharge_eurpkWh ) {
		    	chargeSetpoint_kW = gc.p_batteryAsset.getCapacityElectric_kW()*(WTP_charge_eurpkWh - currentElectricityPriceCharge_eurpkWh)*priceGain_kWhpeur;
		    }
		    else if (WTP_discharge_eurpkWh < currentElectricityPriceCharge_eurpkWh) {
		    	chargeSetpoint_kW = -gc.p_batteryAsset.getCapacityElectric_kW()*(currentElectricityPriceCharge_eurpkWh - WTP_discharge_eurpkWh)*priceGain_kWhpeur;
		    }
		
		    // limit charging power to available connection capacity
		    if( stayWithinConnectionLimits ) {
		    	double availableChargePower_kW = gc.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW() - gc.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY); // Max battery charging power within grid capacity
		    	double availableDischargePower_kW = gc.v_liveConnectionMetaData.getContractedFeedinCapacity_kW() + gc.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY); // Max discharging power within grid capacity
		    	chargeSetpoint_kW = min(max(chargeSetpoint_kW, -availableDischargePower_kW),availableChargePower_kW); // Don't allow too much (dis)charging!
		    }
		
	    	gc.f_updateFlexAssetFlows(gc.p_batteryAsset, chargeSetpoint_kW / gc.p_batteryAsset.getCapacityElectric_kW(), timeVariables);
    	}
    }
    
    
    
    
    //Get parentagent
    public Agent getParentAgent() {
    	return this.gc;
    }
    
    
    //Store and reset states
	public void storeStatesAndReset() {
		this.storedElectricityPriceLowPassed_eurpkWh = electricityPriceLowPassed_eurpkWh;
		this.electricityPriceLowPassed_eurpkWh = 0;
	}
	public void restoreStates() {
		this.electricityPriceLowPassed_eurpkWh = this.storedElectricityPriceLowPassed_eurpkWh;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
} 
