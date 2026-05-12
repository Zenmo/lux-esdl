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

import zeroPackage.ZeroMath;
/**
 * J_EAProfile
 */
public class J_EAProfile extends zero_engine.J_EAFixed{
	protected J_ProfilePointer profilePointer;
	protected double profileUnitScaler_r = 4.0; // This factor translates tablefunction data in kWh/qh, normalized power or consumption-fraction into power [kW]. To go from kWh/qh to kW, that is a factor 4.
	protected OL_EnergyCarriers energyCarrier; // = OL_EnergyCarriers.ELECTRICITY;
	protected double lostLoad_kWh = 0;
	protected double profileScaling_fr = 1.0; // This factor can be used to change the magnitude of the profile in this asset, for example when an energy-saving slider is operated.
	protected double signScaler_r = 1.0;

    /**
     * Default constructor
     */
    public J_EAProfile() {
    }

    /**
     * Constructor initializing the fields
     */

    public J_EAProfile(I_AssetOwner owner, OL_EnergyCarriers energyCarrier, J_ProfilePointer profile, OL_AssetFlowCategories assetCategory, J_TimeParameters timeParameters) {
	    this.setOwner(owner);
	    this.timeParameters = timeParameters;
	    this.energyCarrier = energyCarrier;
		if (profile == null) {
			throw new RuntimeException("Cannot create J_EAProfile without a valid ProfilePointer!");
		} else {
			profilePointer = profile;
			if (profilePointer.getProfileUnits() == OL_ProfileUnits.KWHPQUARTERHOUR) {
				profileUnitScaler_r = 4.0;
			} else if (profilePointer.getProfileUnits() == OL_ProfileUnits.KW) {
				profileUnitScaler_r = 1.0;				
			} else {
				throw new RuntimeException("Unsupported ProfileUnits of profilePointer for J_EAProfile!");
			}
		}	
	    this.assetFlowCategory = assetCategory;
	    
	    this.activeConsumptionEnergyCarriers.add(this.energyCarrier);
	    
		registerEnergyAsset(timeParameters);
	}
       
    public J_FlowPacket f_updateAllFlows(J_TimeVariables timeVariables) {
    	double profileValue = profilePointer.getCurrentValue();		
    	double currentPower_kW = profileValue * this.profileUnitScaler_r * this.profileScaling_fr * this.signScaler_r;
		
    	this.energyUse_kW = currentPower_kW;
    	this.energyUsed_kWh += this.energyUse_kW * this.timeParameters.getTimeStep_h();

		flowsMap.put(this.energyCarrier, currentPower_kW);		
		if (this.assetFlowCategory != null) {
			assetFlowsMap.put(this.assetFlowCategory, Math.abs(currentPower_kW));
		}
     	J_FlowsMap flowsMapCopy = new J_FlowsMap();    	
     	J_ValueMap assetFlowsMapCopy = new J_ValueMap(OL_AssetFlowCategories.class);
     	J_FlowPacket flowPacket = new J_FlowPacket(flowsMapCopy.cloneMap(this.flowsMap), this.energyUse_kW, assetFlowsMapCopy.cloneMap(this.assetFlowsMap));
		this.lastFlowsMap.cloneMap(this.flowsMap);
    	this.lastEnergyUse_kW = this.energyUse_kW;
    	this.clear();
    	return flowPacket;
    }
    
	@Override
	public void operate(J_TimeVariables timeVariables) {
		throw new RuntimeException("J_EAProfile method operate() is not used!");
   	}
    

    public J_FlowPacket curtailElectricityConsumption(double curtailmentSetpoint_kW) {
    	double currentElectricityConsumption_kW = max(0,this.lastFlowsMap.get(OL_EnergyCarriers.ELECTRICITY));
    	double curtailmentPower_kW = max(0,min(currentElectricityConsumption_kW, curtailmentSetpoint_kW));
    	energyUsed_kWh -= curtailmentPower_kW * this.timeParameters.getTimeStep_h();
    	lostLoad_kWh += curtailmentPower_kW * this.timeParameters.getTimeStep_h();
    	J_FlowsMap flowsMap = new J_FlowsMap();
    	flowsMap.put(OL_EnergyCarriers.ELECTRICITY, curtailmentPower_kW);    	
    	J_ValueMap<OL_AssetFlowCategories> assetFlows_kW = new J_ValueMap(OL_AssetFlowCategories.class);
    	assetFlows_kW.put(this.assetFlowCategory, curtailmentPower_kW);
    	
    	this.lastFlowsMap.put(OL_EnergyCarriers.ELECTRICITY, this.lastFlowsMap.get(OL_EnergyCarriers.ELECTRICITY) - curtailmentPower_kW);
    	this.lastEnergyUse_kW -= curtailmentPower_kW;

    	//gc.f_removeFlows(flowsMap, this.energyUse_kW, assetFlows_kW, this);    	    
    	J_FlowPacket flowPacket = new J_FlowPacket(flowsMap, curtailmentPower_kW, assetFlows_kW);
     	return flowPacket;

    }    
    
    public J_ProfilePointer getProfilePointer() {
    	return this.profilePointer;
    }
    
    public double getProfileUnitScaler_fr() {
    	return this.profileUnitScaler_r;
    }
    
    public double getProfileScaling_fr() {
    	return this.profileScaling_fr;
    }
    
    public void setProfileScaling_fr( double scaling_fr ) {
    	this.profileScaling_fr = scaling_fr;
    }
    
    public double getPeakConsumptionPower_kW() {
    	if (this.signScaler_r < 0) {
    		return 0.0;
	    } else {
	    	return max(profilePointer.getAllValues()) * this.profileUnitScaler_r * this.profileScaling_fr;
	    }
    }
    
    public double getPeakProductionPower_kW() {
    	if (this.signScaler_r > 0) {
    		return 0.0;
	    } else {
	    	return max(profilePointer.getAllValues()) * this.profileUnitScaler_r * this.profileScaling_fr;
	    }
    }
    
    public double getBaseConsumption_kWh() {
    	if (this.signScaler_r < 0) {
    		return 0.0;
	    } else {
	    	double[] values = profilePointer.getAllValues();
	    	double dataTimeStep_h = profilePointer.getDataTimeStep_h(); 
	    	double baseConsumption_kWh = ZeroMath.arraySumPos(values) * dataTimeStep_h * this.profileUnitScaler_r;
	    	return baseConsumption_kWh;
	    }
    }
    
    public double getTotalConsumption_kWh() {
    	return this.getBaseConsumption_kWh() * this.profileScaling_fr;
    }
    
    public OL_EnergyCarriers getEnergyCarrier() {
    	return this.energyCarrier;
    }
    
	@Override
	public String toString() {
		return
			"owner = " + this.getOwner() +", Energy consumed = " + this.energyUsed_kWh +
			"assetFlowCategory = " + this.assetFlowCategory + " ";
	}
}
 
