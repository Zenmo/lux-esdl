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
 * J_AccumulatorMap
 */	
//import java.util.EnumMap;
import java.util.EnumSet;

//import zeroPackage.ZeroAccumulator;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
@JsonIgnoreType
public class J_AccumulatorMap <E extends Enum<E>> implements Serializable {
	
	private ZeroAccumulator[] accumulatorArray;
    private final EnumSet<E> enumSet;
    private final Class<E> enumClass;
	//private ZeroAccumulator[] accumulatorArray = new ZeroAccumulator[OL_EnergyCarriers.values().length]; // Use array with size of all possible energyCarriers; more than strictly needed but memory footprint is negligable anyway.;
	//private EnumSet<OL_EnergyCarriers> energyCarrierList = EnumSet.noneOf(OL_EnergyCarriers.class);
	

    public J_AccumulatorMap(Class<E> enumClass) {
        this.enumClass = enumClass;
        this.enumSet = EnumSet.noneOf(enumClass);
        this.accumulatorArray = new ZeroAccumulator[enumClass.getEnumConstants().length];
    }
    
    public void createEmptyAccumulators(EnumSet<E> selectedFlows, boolean hasTimeSeries, double signalResolution_h, double duration_h) {
    	this.clear();
    	for (E key : selectedFlows) {
    		this.put(key, new ZeroAccumulator(hasTimeSeries, signalResolution_h, duration_h));
    	}
    }
    
    public J_AccumulatorMap getClone() {
    	J_AccumulatorMap am = new J_AccumulatorMap(enumClass);
    	for (var EC : this.enumSet) {
    		am.put(EC, accumulatorArray[EC.ordinal()].getClone());
    	}
    	return am;
    }
   
    public ZeroAccumulator get(E key) {
		return accumulatorArray[key.ordinal()];
	}
    	

	public void put(E key, ZeroAccumulator acc) {
		accumulatorArray[key.ordinal()] = acc;
		enumSet.add(key);		
	}
	
	public Set<E> keySet() {
		return enumSet;
	}
    /*
	public double totalSum() {
		double totalSum = 0.0;
		for (var EC : energyCarrierList) {
			totalSum += accumulatorArray[EC.ordinal()].getSum();
		}
		return totalSum;
	}
	*/
	public double totalIntegral_kWh() {
		double totalIntegral_kWh = 0.0;
		for (var EC : enumSet) {
			totalIntegral_kWh += accumulatorArray[EC.ordinal()].getIntegral_kWh();
		}
		return totalIntegral_kWh;
	}
	
	public double totalIntegral_MWh() {
		return this.totalIntegral_kWh() / 1000;
	}
	
	public double totalIntegralPos_kWh() {
		double totalIntegralPos_kWh = 0.0;
		for (var EC : enumSet) {
			totalIntegralPos_kWh += accumulatorArray[EC.ordinal()].getIntegralPos_kWh();
		}
		return totalIntegralPos_kWh;
	}
	
	public double totalIntegralPos_MWh() {
		return this.totalIntegralPos_kWh() / 1000;
	}
	
	public double totalIntegralNeg_kWh() {
		double totalIntegralNeg_kWh = 0.0;
		for (var EC : enumSet) {
			totalIntegralNeg_kWh += accumulatorArray[EC.ordinal()].getIntegralNeg_kWh();
		}
		return totalIntegralNeg_kWh;
	}
	
	public double totalIntegralNeg_MWh() {
		return this.totalIntegralNeg_kWh() / 1000;
	}
	
	public void clear() {
		accumulatorArray = new ZeroAccumulator[this.enumClass.getEnumConstants().length];
		enumSet.clear();
	}
	
	public void reset() {
		for (var EC : enumSet) {
			accumulatorArray[EC.ordinal()].reset();
		}
	}
	
	public J_AccumulatorMap<E> add( J_AccumulatorMap<E> accumulatorMap ) {
		for (var EC : accumulatorMap.enumSet) {
			if (!this.enumSet.contains(EC)) {
				// make a new one?
				traceln("this enumSet: " + this.enumSet);
				traceln("other enumSet: " + accumulatorMap.enumSet);
				throw new RuntimeException("Tried to add two AccumulatorMaps without matching keys.");
			}
			this.get(EC).add(accumulatorMap.get(EC));
		}
		return this;
	}
	
	public J_AccumulatorMap<E> subtract( J_AccumulatorMap<E> accumulatorMap ) {
		for (var EC : accumulatorMap.enumSet) {
			if (!this.enumSet.contains(EC)) {
				// make a new one?
				throw new RuntimeException("Tried to subtract two AccumulatorMaps without matching keys.");
			}
			this.get(EC).subtract(accumulatorMap.get(EC));
		}
		return this;
	}
	
	public J_DataSetMap getDataSetMap( double startTime_h ) {
		J_DataSetMap dsm = new J_DataSetMap(this.enumClass);
		for (var EC : this.enumSet) {
			dsm.put(EC, this.get(EC).getDataSet(startTime_h));
		}
		return dsm;
	}
	
	public J_DataSetMap getDataSetMap( double startTime_h, double dataSetSignalResolution_h ) {
		J_DataSetMap dsm = new J_DataSetMap(this.enumClass);
		for (var EC : this.enumSet) {
			dsm.put(EC, this.get(EC).getDataSet(startTime_h, dataSetSignalResolution_h));
		}
		return dsm;
	}
	
    public String toString() {
        if (this.accumulatorArray.length == 0) {
            return "{}";        	
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (E key : this.enumSet) {
        	ZeroAccumulator acc = this.get(key);
        	//double value = this.get(key);
        	if (acc.getIntegral_kWh() == 0.0) {
        		continue;
        	}
        	
        	sb.append(key);
        	sb.append(" ");
            sb.append(acc.toString());
            //sb.append(" = ");
            //sb.append(value);
            sb.append(", ");
        }
        //sb.delete(sb.length()-2, sb.length());
        sb.append('}');
        return sb.toString();
    }

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;

} 
