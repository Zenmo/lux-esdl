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
 * J_BatteryManagementLocalBalancing
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

public class J_BatteryManagementLocalBalancing implements I_BatteryManagement {

	private GridConnection gc;
    private J_TimeParameters timeParameters;
	
	// Parameters used:
	private double filterTimeScale_h = 5*24;
    private double filterDiffGain_r;
    private double initialValueGCdemandLowPassed_kW = 0.5;
    private double GCdemandLowPassed_kW = this.initialValueGCdemandLowPassed_kW;
    private double storedGCdemandLowPassed_kW;
    
	private double SOC_setpoint_fr = 0.5; // If there are no other influences such as vehicles or production the battery will aim for this SOC_fr
	//private double feedbackGain_fr = 1.5; // This parameter determines how strongly to aim for the SOC setpoint
	private double feedbackGain_kWpSOC;
	private double balancingGain_fr = 0.25; // How much 'peakshaving' around the average load? 1.0 is 100% peakshaving, which would result in an approximately flat profile, if the battery is big enough.
    /**
     * Default constructor
     */
	public J_BatteryManagementLocalBalancing() {
		
	}
	
    public J_BatteryManagementLocalBalancing( GridConnection gc, J_TimeParameters timeParameters ) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    	this.filterDiffGain_r = 1/(filterTimeScale_h/timeParameters.getTimeStep_h());
    	double feedbackGain_ph = 1/5;
    	this.feedbackGain_kWpSOC = gc.p_batteryAsset.getStorageCapacity_kWh() * feedbackGain_ph;
    }
    
    public J_BatteryManagementLocalBalancing( GridConnection gc, double SOC_setpoint_fr, double feedbackGain_ph, J_TimeParameters timeParameters ) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    	this.filterDiffGain_r = 1/(filterTimeScale_h/timeParameters.getTimeStep_h());
    	this.SOC_setpoint_fr = SOC_setpoint_fr;
    	this.feedbackGain_kWpSOC = gc.p_batteryAsset.getStorageCapacity_kWh() * feedbackGain_ph;
    }
    
    /**
     * This algorithm tries to aim for a flat load profile by using the battery to steer towards the a weighted averaged load of the past filterTimeScale hours
     */
    public void manageBattery(J_TimeVariables timeVariables) {
       	double currentBalanceBeforeBattery_kW = getBalanceElectricity_kW();
    	GCdemandLowPassed_kW += (currentBalanceBeforeBattery_kW - GCdemandLowPassed_kW) * filterDiffGain_r;
    	if(gc.p_batteryAsset != null && gc.p_batteryAsset.getStorageCapacity_kWh() > 0) {
	    	double chargeSetpoint_kW = (SOC_setpoint_fr - gc.p_batteryAsset.getCurrentStateOfCharge_fr()) * feedbackGain_kWpSOC + balancingGain_fr * (GCdemandLowPassed_kW - currentBalanceBeforeBattery_kW);
	    	
	    	// Try to stay within the target connection capacity
	    	double v_allowedDeliveryCapacity_kW = getDeliveryCapacity_kW();
	    	double v_allowedFeedinCapacity_kW = getFeedinCapacity_kW();
	    	double availableChargePower_kW = v_allowedDeliveryCapacity_kW - currentBalanceBeforeBattery_kW; // Max battery charging power within safety margins
	    	double availableDischargePower_kW = v_allowedFeedinCapacity_kW + currentBalanceBeforeBattery_kW; // Max discharging power within safety margins
	
	    	chargeSetpoint_kW = min(max(chargeSetpoint_kW, -availableDischargePower_kW),availableChargePower_kW); // Don't allow too much (dis)charging!
	    	gc.f_updateFlexAssetFlows(gc.p_batteryAsset, chargeSetpoint_kW / gc.p_batteryAsset.getCapacityElectric_kW(), timeVariables);
	    }
    }
  
    private double getDeliveryCapacity_kW() {
    	return gc.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW();
    }
    
    private double getFeedinCapacity_kW() {
	    return gc.v_liveConnectionMetaData.getContractedFeedinCapacity_kW();
    }
    
    private double getBalanceElectricity_kW() {
        return gc.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY);
    }
    
    public Agent getParentAgent() {
    	return this.gc;
    }
    
	public void storeStatesAndReset() {
		this.storedGCdemandLowPassed_kW = this.GCdemandLowPassed_kW;
		this.GCdemandLowPassed_kW = this.initialValueGCdemandLowPassed_kW;
	}
	public void restoreStates() {
		this.GCdemandLowPassed_kW = this.storedGCdemandLowPassed_kW;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}

 
