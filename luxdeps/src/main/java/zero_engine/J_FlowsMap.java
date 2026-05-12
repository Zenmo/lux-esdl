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
 * J_FlowsMap
 */	
import zeroPackage.ZeroMath;
import java.util.EnumSet;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
@JsonIgnoreType
public class J_FlowsMap implements Serializable {
	
	private double[] valuesArray = new double[OL_EnergyCarriers.values().length]; // Use array with size of all possible energyCarriers; more than strictly needed but memory footprint is negligable anyway.;
	private EnumSet<OL_EnergyCarriers> energyCarrierList = EnumSet.noneOf(OL_EnergyCarriers.class);
    /**
     * Default constructor
     */
    public J_FlowsMap() {
    	
    }

    public final double get(OL_EnergyCarriers key) {
		return valuesArray[key.ordinal()];
	}
    	

	public final void put(OL_EnergyCarriers key, double value) {
		valuesArray[key.ordinal()] = value;
		energyCarrierList.add(key);
	}
	
	public final void clear() {
		energyCarrierList.clear();
		Arrays.fill(valuesArray, 0.0);
		/*for(int i=0; i<valuesArray.length; i++) {
			valuesArray[i]=0.0;
		}*/
	}
    
    //public J_FlowsMap addFlows( J_FlowsMap f) {
    public final J_FlowsMap addFlowsSlow( J_FlowsMap f) {
    	for (OL_EnergyCarriers key : f.energyCarrierList) {
    		this.addFlow(key, f.get(key));
    	}
    	return this;
    }
    
    //public J_FlowsMap addToExistingFlows( J_FlowsMap f) {
    public final J_FlowsMap addFlows( J_FlowsMap f) {
    	int len = valuesArray.length;
		for(int i=0; i<len; i++) {
			//this.valuesArray[i]=this.valuesArray[i]+f.valuesArray[i];
			this.valuesArray[i]+=f.valuesArray[i];
		}
		this.energyCarrierList.addAll(f.energyCarrierList); 
    	return this;
    }
    
    public final J_FlowsMap removeFlows( J_FlowsMap f) {
    	int len = valuesArray.length;
		for(int i=0; i<len; i++) {
			//this.valuesArray[i]=this.valuesArray[i]+f.valuesArray[i];
			this.valuesArray[i]-=f.valuesArray[i];
		}
		this.energyCarrierList.addAll(f.energyCarrierList); 
    	return this;
    }
    
    public final J_FlowsMap addFlow( OL_EnergyCarriers key, double value) {
    	energyCarrierList.add(key);
    	this.valuesArray[key.ordinal()]+=value;
    	//double currentValue = this.get(key);
    	//this.put(key, currentValue + value);
    	return this;
    }
    
    public final J_FlowsMap cloneMap(J_FlowsMap flowMap) {
    	//this.clear();
    	//this.addFlows(flowMap);
    	
    	// Custom 'addflows' version that doesn't add, just 'copies'. Might be faster?
    	int len = valuesArray.length;
		for(int i=0; i<len; i++) {
			this.valuesArray[i]=flowMap.valuesArray[i];
		}
		
		//this.energyCarrierList = flowMap.energyCarrierList.clone(); // This or first clear list and then addAll? Which is faster?
		this.energyCarrierList.clear();
		this.energyCarrierList.addAll(flowMap.energyCarrierList); 
    	return this;    	
    }
    
    public double totalSum() {
    	return ZeroMath.arraySum(valuesArray);
    }
    
    public final EnumSet<OL_EnergyCarriers> keySet(){
    	return energyCarrierList;
    }
        
    public String toString() {
        if (this.energyCarrierList.size() == 0) {
            return "{}";        	
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (OL_EnergyCarriers key : this.energyCarrierList) {
        	double value = this.get(key);
            sb.append(key);
            sb.append(" = ");
            sb.append(value);
            sb.append("\n ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append('}');
        return sb.toString();
    }

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;

} 
