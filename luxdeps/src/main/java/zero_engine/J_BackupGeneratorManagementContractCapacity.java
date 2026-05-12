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
 * J_BackupGeneratorManagementContractCapacity: Very simple management: backup generator is used to stay within contracted delivery capacity.
 */	
public class J_BackupGeneratorManagementContractCapacity implements I_BackupGeneratorManagement {
	
	private GridConnection gc;
	private J_TimeParameters timeParameters;

    /**
     * Empty constructor for serialization
     */
    public J_BackupGeneratorManagementContractCapacity() {
    }
    
    /**
     * Default constructor
     */
    public J_BackupGeneratorManagementContractCapacity(GridConnection gc, J_TimeParameters timeParameters) {
    	this.gc = gc;
    	this.timeParameters = timeParameters;
    }
    
    public void manageBackupGenerator(J_TimeVariables timeVariables) {
    	//Get the backup generator asset
    	List<J_EAConversion> backupGenerators = findAll(gc.c_conversionAssets, asset -> asset.getEAType() == OL_EnergyAssetType.DIESEL_GENERATOR || 
																	    		   asset.getEAType() == OL_EnergyAssetType.METHANE_GENERATOR ||
																	    		   asset.getEAType() == OL_EnergyAssetType.FUEL_CELL);
    	for(J_EAConversion backupGenerator : backupGenerators) {//Order determined by order in c_conversionAssets of GC.
	    	//Determine backupGeneratorSetpoint based on current load: If load is higher then contracted delivery capacity: (try to) compensate it with the backup generator.
	    	double backupGeneratorSetpoint_kW = max(0, gc.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY) - gc.v_liveConnectionMetaData.getContractedDeliveryCapacity_kW());
	    	
	    	//Calculate power fraction (if output capacity > 0) else: power fraction = 0.
	    	double backupGeneratorPowerFraction_fr = backupGenerator.getOutputCapacity_kW() > 0 ? backupGeneratorSetpoint_kW/backupGenerator.getOutputCapacity_kW() : 0;
	    	
	    	//Update f_updateFlexAssetFlows of asset (and with that fm_currentBalanceFlows_kW of gc) with found setpoint
	    	gc.f_updateFlexAssetFlows(backupGenerator, backupGeneratorPowerFraction_fr, timeVariables);
    	}
    }
    
    ////Store and reset states
	public void storeStatesAndReset() {
		//Nothing to store and reset
	}
	public void restoreStates() {
		//Nothing to restore
	}
	
	@Override
	public String toString() {
		List<J_EAConversion> backupGenerators = findAll(gc.c_conversionAssets, asset -> asset.getEAType() == OL_EnergyAssetType.DIESEL_GENERATOR || 
	    		   asset.getEAType() == OL_EnergyAssetType.METHANE_GENERATOR ||
	    		   asset.getEAType() == OL_EnergyAssetType.FUEL_CELL);
		StringBuilder backupGeneratorsString = new StringBuilder();
		for(J_EAConversion backupGenerator : backupGenerators) {
			backupGeneratorsString.append(System.lineSeparator());
			backupGeneratorsString.append(backupGenerator.toString());
		}
		
		return "J_BackupGeneratorManagementContractCapacity: " + System.lineSeparator() +
				"Currently controlling backupGenerators: " + 
				backupGeneratorsString.toString();
	}

} 
