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
 * J_EAStorageGas
 */
public class J_EAStorageGas extends zero_engine.J_EAStorage {

	private OL_EnergyCarriers energyCarrier = OL_EnergyCarriers.METHANE;
	private double lossFactor_r = 0;
	protected double capacityGas_kW;

    /**
     * Default constructor
     */
    public J_EAStorageGas() {
    }

    /**
     * Constructor initializing the fields
     */
    public J_EAStorageGas(I_AssetOwner owner, double capacityGas_kW, double storageCapacity_kWh, double stateOfCharge_fr, J_TimeParameters timeParameters ) {
		this.setOwner(owner);
		this.timeParameters = timeParameters;
		this.capacityGas_kW = capacityGas_kW;
		this.storageCapacity_kWh = storageCapacity_kWh;
		this.stateOfCharge_fr = stateOfCharge_fr;
	    this.activeProductionEnergyCarriers.add(this.energyCarrier);		
		this.activeConsumptionEnergyCarriers.add(this.energyCarrier);
		registerEnergyAsset(timeParameters);
    }

	@Override
	public void operate(double powerFraction_fr, J_TimeVariables timeVariables) {
    	double inputPower_kW = powerFraction_fr * capacityGas_kW; // Gas power going into Storage, negative if going out.

    	double deltaEnergy_kWh = inputPower_kW * timeParameters.getTimeStep_h();
    	deltaEnergy_kWh = - min( -deltaEnergy_kWh, (stateOfCharge_fr * storageCapacity_kWh) ); // Prevent negative charge
    	deltaEnergy_kWh = min(deltaEnergy_kWh, (1 - stateOfCharge_fr) * storageCapacity_kWh ); // Prevent overcharge

    	inputPower_kW = deltaEnergy_kWh / timeParameters.getTimeStep_h();

		double methaneProduction_kW = max(-inputPower_kW, 0);
		double methaneConsumption_kW = max(inputPower_kW, 0);
		discharged_kWh += methaneProduction_kW * timeParameters.getTimeStep_h();
		charged_kWh += methaneConsumption_kW * timeParameters.getTimeStep_h();
		
		updateStateOfCharge( deltaEnergy_kWh );
		flowsMap.put(OL_EnergyCarriers.METHANE, methaneConsumption_kW-methaneProduction_kW);
	}

	@Override
	public String toString() {
		return 
			"type = " + this.getClass().toString() + " " +
			"stateOfCharge_fr = " + this.stateOfCharge_fr+" "+
			"storageCapacity_kWh = " + this.storageCapacity_kWh +" "+
			"capacityGas_kW = " + this.capacityGas_kW +" "+
			"discharged_kWh " + this.discharged_kWh+" "+
			"charged_kWh " + this.charged_kWh+" ";
	}

	@Override
	protected void updateStateOfCharge( double deltaEnergy_kWh ) {
		stateOfCharge_fr += deltaEnergy_kWh / storageCapacity_kWh;
	}

	public double getCapacityAvailable_kW() {
		double availableCapacity_kW;
		if ( stateOfCharge_fr * storageCapacity_kWh  > capacityGas_kW * timeParameters.getTimeStep_h()) {
			availableCapacity_kW = capacityGas_kW;
		}
		else {
			availableCapacity_kW =  stateOfCharge_fr * storageCapacity_kWh / timeParameters.getTimeStep_h(); // Allow to drain completely
		}
		return availableCapacity_kW;
	}
	
    public double getCapacityGas_kW() {
    	return capacityGas_kW;
    }
	
	public double getTotalChargeAmount_kWh() {
		return charged_kWh;
	}
	public double getTotalDischargeAmount_kWh() {
		return discharged_kWh;
	}
} 
 
 
