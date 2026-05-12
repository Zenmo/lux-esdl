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
 * ZeroTimeSeries
 */	

import zeroPackage.ZeroMath;
import java.lang.Math;
import java.util.Arrays;
import java.lang.RuntimeException;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
@JsonIgnoreType
public class ZeroTimeSeries implements Serializable {

	    private double[] timeSeries;
	    private double duration_h;
	    private double signalResolution_h = 0.25;
	    private double timeStep_h = 0.25;
	    private double sampleWeight = timeStep_h / signalResolution_h;
	    
	    private double max = 0;
	    private double min = 0;

	    private int numStepsAdded = 0;
	    private int numStepsAddedThisEntry = 0; // Used when signal resolution is different from the timestep
	    /**
	     * Default constructor
	     */
	    public ZeroTimeSeries() {
	    }

	    /**
	     * Constructor initializing the fields
	     */
	    public ZeroTimeSeries(double signalResolution_h, double duration_h) {
	        if (signalResolution_h < this.timeStep_h) {
	        	throw new RuntimeException("Impossible to construct a ZeroAccumulator with Signal Resolution: " + signalResolution_h + " h, as it is shorter than the timestep.");
	        }

	        this.signalResolution_h = signalResolution_h;
	        this.sampleWeight = timeStep_h / signalResolution_h;
	        this.duration_h = duration_h;
	        //this.arraySize = (int) Math.round(duration_h / signalResolution_h);
            timeSeries = new double[(int) Math.round(duration_h / signalResolution_h)];
	    }

	    public void setTimeStep_h(double timeStep_h) {
	        this.timeStep_h = timeStep_h;
	        sampleWeight = timeStep_h / signalResolution_h;
	    }

	    public void reset() {

	        numStepsAdded = 0;
	        max = 0;
	        min = 0;
	        timeSeries = new double[(int) Math.round(duration_h / signalResolution_h)];
	        
	    }
	    
	    public ZeroTimeSeries getClone() {
	    	ZeroTimeSeries ts = new ZeroTimeSeries(this.signalResolution_h, this.duration_h);
	    	ts.timeStep_h = this.timeStep_h;
    		ts.timeSeries = this.timeSeries.clone();
    		ts.max = this.max;
    		ts.min = this.min;
    		ts.numStepsAdded = this.numStepsAdded;
			ts.numStepsAddedThisEntry = this.numStepsAddedThisEntry;
	    	return ts;
	    }
	    
    
	    public void addStep(double value) {
            this.timeSeries[this.numStepsAdded] += value * sampleWeight;
	        
	        if (value > max) {
	            max = value;
	        }
	        if (value < min) {
	            min = value;
	        }
	        
	        this.numStepsAddedThisEntry ++;
	        if (this.numStepsAddedThisEntry == roundToInt(this.signalResolution_h / this.timeStep_h)) {
	        	this.numStepsAddedThisEntry = 0;
	        	this.numStepsAdded++;
	        }
	    }

	    public double getSum() {
            return ZeroMath.arraySum(timeSeries);
	        //return sum;
	    }

	    public double getSumPos() {
            return ZeroMath.arraySumPos(timeSeries);
	        //return posSum;
	    }
	    
	    public double getSumNeg() {
            return ZeroMath.arraySumNeg(timeSeries);
	        //return negSum;
	    }

	    public double[] getTimeSeries() {
            return this.timeSeries;
	    }

	    public void setTimeSeries(double[] timeSeries) {
            this.timeSeries = timeSeries;
	    }
	    
	    public Double getY(int i) {
            return timeSeries[i];
	    }

	    public double getMax() {
	        return max;
	    }

	    public double getMin() {
	        return min;
	    }
	    
	    public double getSignalResolution_h() {
	    	return this.signalResolution_h;
	    }

	    public double getDuration() {
	    	return duration_h;
	    }
	    
	    public ZeroTimeSeries add(ZeroTimeSeries zts) {
	        if ((this.duration_h == zts.duration_h) && (this.signalResolution_h == zts.signalResolution_h)) {
	            for (int i = 0; i < this.timeSeries.length; i++) {
	                this.timeSeries[i] += zts.timeSeries[i];
	            }
	        } else {
	            throw new RuntimeException("Impossible to add these incompatible timeSeries");
	        }
	        return this;
	    }

	    public ZeroTimeSeries subtract(ZeroTimeSeries zts) {
	        if ((this.duration_h == zts.duration_h) && (this.signalResolution_h == zts.signalResolution_h)) {
	            for (int i = 0; i < this.timeSeries.length; i++) {
	                this.timeSeries[i] -= zts.timeSeries[i];
	            }
	        } else {
	            throw new RuntimeException("Impossible to subtract these incompatible timeSeries");
	        }
	        return this;
	    }
	    
	    public DataSet getDataSet(double startTime_h) {
			DataSet ds = new DataSet(timeSeries.length);
			for (int i = 0; i < timeSeries.length; i++) {
				ds.add(startTime_h + i * this.signalResolution_h, this.timeSeries[i] );
			}
			
			return ds;
	    }
	    
	    public DataSet getDataSet(double startTime_h, double accStartTime_h, double accEndTime_h) {
	    	
	    	double dataSetDuration_h = accEndTime_h - accStartTime_h;
	    	if (dataSetDuration_h > duration_h) {    		
	    		throw new RuntimeException("Too long dataSet interval requested from ZeroAccumulator.getDataSet().");    	
	    	}
	    	int startIdx = roundToInt(accStartTime_h / this.signalResolution_h);
	    	int endIdx = roundToInt(accEndTime_h / this.signalResolution_h);
	    	startIdx = max(0,startIdx);
	    	//endIdx = max(endIdx, roundToInt(dataSetDuration_h/signalResolution_h));
	    	endIdx = min(endIdx, roundToInt(duration_h / signalResolution_h));
	    	//startIdx = min(startIdx, endIdx - roundToInt(dataSetDuration_h/signalResolution_h));

			DataSet ds = new DataSet(endIdx-startIdx);
			for (int i = startIdx; i < endIdx; i++) {
				ds.add(startTime_h + i * this.signalResolution_h, roundToDecimal(this.timeSeries[i],3) );
			}
			return ds;
    	
	    }
	    
	    public int getLength() {
	    	return timeSeries.length;
	    }
		
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();

	        sb.append("ZeroTimeSeries, current number of steps in time-series: ");
	        sb.append(this.numStepsAdded);

	        return sb.toString();
	    }

		/**
		 * This number is here for model snapshot storing purpose<br>
		 * It needs to be changed when this class gets changed
		 */ 
		private static final long serialVersionUID = 1L;

	} 
