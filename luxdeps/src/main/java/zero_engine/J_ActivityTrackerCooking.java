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
 * J_ActivityTrackerCooking
 */	

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class J_ActivityTrackerCooking extends zero_engine.J_ActivityTracker {
	private ArrayList<Double> powerFractions_fr = new ArrayList<>();
	public J_EAConversion HOB;
	public double powerFraction_fr=0;
	private int rowIndex;
	private boolean cooking = false;
	private double timeStep_min;
	private ArrayList<Double> initalStarttimes_min;
	private ArrayList<Double> initalEndtimes_min;
	private ArrayList<Double> storedStarttimes_min;
	private ArrayList<Double> storedEndtimes_min;

	/**
     * Default constructor
     */
    public J_ActivityTrackerCooking() {
    }

    public J_ActivityTrackerCooking(TextFile inputCookingActivities, int rowIndex, double time_min, J_EAConversion HOB) {
  
    	this.rowIndex = rowIndex;
    	this.HOB=HOB;
    	//int rowIndex = uniform_discr(2, 300); 

    	this.timeStep_min = 60 * this.HOB.timeParameters.getTimeStep_h();
    	
    	inputCookingActivities.close();
    	inputCookingActivities.canReadMore();
    	inputCookingActivities.readLine(); // Skips first line
    	
    	while (roundToInt(inputCookingActivities.readDouble())!=rowIndex && inputCookingActivities.canReadMore()) { // Skip until rowIndex found
    		inputCookingActivities.readLine(); 
    		//String line = tripsCsv.readLine(); // Does this also skip to the next line?
    		//traceln("Skipping line: " + line);
    	}
    	int currentLineNb = inputCookingActivities.getLineNumber();
    	traceln("rowIndex %s found on line: %s", rowIndex, currentLineNb);
    	int nbActivities = inputCookingActivities.readInt();
    	traceln("Number of trips: %s", nbActivities);    	
   	
    			
    	for (int i = 0; i < nbActivities; i++){
    		starttimes_min.add(inputCookingActivities.readDouble());
    		endtimes_min.add(inputCookingActivities.readDouble());
    		
    		double ratio = inputCookingActivities.readDouble() / HOB.getOutputCapacity_kW();
    		powerFractions_fr.add(ratio);
    	}
    	
    	while ( starttimes_min.get(eventIndex) - time_min < 0) {
    		starttimes_min.set( eventIndex, starttimes_min.get(eventIndex) + 1440 );  // Source data is always just one day, repeating every day.
    		endtimes_min.set( eventIndex, endtimes_min.get(eventIndex) + 1440 ); // Source data is always just one day, repeating every day.
    		eventIndex++;
    		if ( eventIndex > starttimes_min.size() - 1 ) {
    			eventIndex = 0;
    		}
    	}
    	
    	initalStarttimes_min = new ArrayList<>(starttimes_min);
    	initalEndtimes_min = new ArrayList<>(endtimes_min);
    	//traceln("Current model time in minutes: " + energyModel.t_h*60 + ", nb sessions: " + nbOfCookingSessions);
    	//traceln("Starttimes: %s", starttimes_min);
    	//traceln("Endtimes: %s", endtimes_min);
    }
    
    public void manageActivities(J_TimeVariables timeVariables) {
    	double time_min = timeVariables.getAnyLogicTime_h() * 60;
    	//traceln("Cooking tracker current time: " + time_min);
    	//traceln("Event index: " + eventIndex);
    	//traceln("startTimes: " + starttimes_min);
    	//traceln("endTimes: " + endtimes_min);
    	//traceln("powerFractions_fr: "  + powerFractions_fr);
    	
    	if (cooking) {
	    	if (time_min >= endtimes_min.get(eventIndex) ) { // end cooking session. Also check if a new one starts in this timestep!

	    		//main.v_activeCookingSessions.decrementAndGet();
	    		//traceln("End of cooking session, currently active cooking sessions %s", main.v_activeCookingSessions);
				// factor to compensate for the fact that you might not be cooking for the entire timestep.
				double fr = (time_min - this.endtimes_min.get(this.eventIndex)) / this.timeStep_min;
				this.powerFraction_fr = fr * this.powerFractions_fr.get(this.eventIndex);
	    		
				starttimes_min.set( eventIndex, starttimes_min.get(eventIndex) + 1440 );
				endtimes_min.set( eventIndex, endtimes_min.get(eventIndex) + 1440 );
				eventIndex++;
				if ( eventIndex >= starttimes_min.size() ) {
					eventIndex = 0;
				}
				cooking=false;
				
				if (time_min >= starttimes_min.get(eventIndex)) {
					// factor to compensate for the fact that you might not be cooking for the entire timestep.
					fr = (time_min - this.starttimes_min.get(this.eventIndex)) / this.timeStep_min;
					this.powerFraction_fr = fr * this.powerFractions_fr.get(this.eventIndex);	    		
					//main.v_activeCookingSessions.incrementAndGet();
					cooking=true;
					traceln("Starting next cooking session in same timestep as previous session ended!! Rowindex %s, eventIndex %s\", rowIndex, eventIndex");
				}
	    	}
	    	else {
	    		this.powerFraction_fr = this.starttimes_min.get(this.eventIndex);
	    	}
    	} else if (time_min >= starttimes_min.get(eventIndex) ) { // start cooking session. Also check if it ends within this timestep!
    		/*if (endtimes_min.get(eventIndex) - starttimes_min.get(eventIndex) > 100) {
			traceln("Cooking event longer than 100 minutes!! Rowindex %s, eventIndex %s.", rowIndex, eventIndex);
			}*/
    		
			// factor to compensate for the fact that you might not be cooking for the entire timestep.
			double fr = (time_min - this.starttimes_min.get(this.eventIndex)) / this.timeStep_min;
			this.powerFraction_fr = fr * this.powerFractions_fr.get(this.eventIndex);	    		
			//main.v_activeCookingSessions.incrementAndGet();
			cooking=true;
			if (time_min >= endtimes_min.get(eventIndex) ) { // end cooking session in the same timestep? Still need to fix energy use for this case!! 
	    	
	    		//main.v_activeCookingSessions.decrementAndGet();
	    		//traceln("End of cooking session, currently active cooking sessions %s", main.v_activeCookingSessions);
				fr = (this.endtimes_min.get(this.eventIndex) - this.starttimes_min.get(this.eventIndex)) / this.timeStep_min;	    		
				this.powerFraction_fr = fr * this.powerFractions_fr.get(this.eventIndex);	    		
	    		
				starttimes_min.set( eventIndex, starttimes_min.get(eventIndex) + 1440 );
				endtimes_min.set( eventIndex, endtimes_min.get(eventIndex) + 1440 );
				eventIndex++;
				if ( eventIndex >= starttimes_min.size() ) {
					eventIndex = 0;
				}
				cooking=false;
			}
    	}
    	else {
    		this.powerFraction_fr = 0;
    	}
    	//if (powerFraction_fr > 0 ) { traceln("Cooking event in progress!"); }
    	HOB.f_updateAllFlows(powerFraction_fr, timeVariables);
    }
    
    @Override
    public void storeStatesAndReset() {
    	eventIndexStored = eventIndex;
    	storedStarttimes_min = new ArrayList<>(starttimes_min);
    	storedEndtimes_min = new ArrayList<>(endtimes_min);    	
		starttimes_min = new ArrayList<>(initalStarttimes_min);
		endtimes_min = new ArrayList<>(initalEndtimes_min);
    	eventIndex = 0;
    }
    
    @Override
    public void restoreStates() {
    	eventIndex = eventIndexStored;
		starttimes_min = new ArrayList<>(storedStarttimes_min);
		endtimes_min = new ArrayList<>(storedEndtimes_min);
	}
    
    @Override
	public String toString() {
		return super.toString();
	}
}
 
