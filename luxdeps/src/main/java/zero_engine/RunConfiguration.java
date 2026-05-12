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
import java.util.Optional;
import java.io.File;

public class RunConfiguration implements IRunConfiguration<EnergyModel> {
	/**
	 * Constructor
	 */
	public RunConfiguration() {
	}

	@Override
	@AnyLogicInternalCodegenAPI
	public void setupEngine(Engine engine) {
    engine.setATOL( 1.0 );
    engine.setRTOL( 1.0 );
    engine.setTTOL( 0.1 );
    engine.setHTOL( 1.0 );
    engine.setSolverODE( Engine.SOLVER_ODE_EULER );
    engine.setSolverNAE( Engine.SOLVER_NAE_MODIFIED_NEWTON );
    engine.setSolverDAE( Engine.SOLVER_DAE_RK45_NEWTON );
    engine.setInspectionWindowColorTheme(InspectionWindowColorTheme.DEFAULT);
    engine.setVMethods( 427029 );

		engine.setSimultaneousEventsSelectionMode(Engine.EVENT_SELECTION_LIFO);

		engine.setStartTime( 0.0 );
		engine.setTimeUnit( HOUR );
		engine.setStartDate( toDate( 2023, JANUARY, 1, 0, 0, 0 ) );
		engine.setStopDate( toDate( 2024, JANUARY, 1, 0, 0, 0 ) );
	}

	@Override
    public EnergyModel createRootAgent(Engine engine) {
    	return new EnergyModel( engine, null, null );
    }
	
	@Override
	@AnyLogicInternalCodegenAPI
	public void setupRootParameters( final EnergyModel root, boolean callOnChangeActions,
			IRunValueAccessor parameterSource ) {

		if (callOnChangeActions) {
			root.set_b_parallelizeConnectionOwners( parameterSource.getValue("B add kpi visuals", boolean.class, null).orElseGet(() -> root._b_parallelizeConnectionOwners_DefaultValue_xjal()) );
			root.set_b_parallelizeGridConnections( parameterSource.getValue("P parallelize", boolean.class, null).orElseGet(() -> root._b_parallelizeGridConnections_DefaultValue_xjal()) );
			root.set_p_tempForecastTime_h( root._p_tempForecastTime_h_DefaultValue_xjal() );
			root.set_p_truckTripsCsv( root._p_truckTripsCsv_DefaultValue_xjal() );
			root.set_p_householdTripsCsv( root._p_householdTripsCsv_DefaultValue_xjal() );
			root.set_p_cookingPatternCsv( root._p_cookingPatternCsv_DefaultValue_xjal() );
			root.set_avgc_data( root._avgc_data_DefaultValue_xjal() );
			root.set_b_enableDLR( root._b_enableDLR_DefaultValue_xjal() );
			root.set_b_isInitialized( root._b_isInitialized_DefaultValue_xjal() );
			root.set_b_storePreviousRapidRunData( root._b_storePreviousRapidRunData_DefaultValue_xjal() );
			root.set_p_regionName( root._p_regionName_DefaultValue_xjal() );
			root.set_b_isDeserialised( root._b_isDeserialised_DefaultValue_xjal() );
			root.set_p_timeVariables( root._p_timeVariables_DefaultValue_xjal() );
			root.set_p_timeParameters( root._p_timeParameters_DefaultValue_xjal() );
			root.set_p_pvForecastTime_h( root._p_pvForecastTime_h_DefaultValue_xjal() );
			root.set_p_windForecastTime_h( root._p_windForecastTime_h_DefaultValue_xjal() );
			root.set_p_epexForecastTime_h( root._p_epexForecastTime_h_DefaultValue_xjal() );
			root.set_p_CO2EmissionFactorForecastTime_h( root._p_CO2EmissionFactorForecastTime_h_DefaultValue_xjal() );
		} else {
			root.b_parallelizeConnectionOwners = parameterSource.getValue("B add kpi visuals", boolean.class, null).orElseGet(() -> root._b_parallelizeConnectionOwners_DefaultValue_xjal());
			root.b_parallelizeGridConnections = parameterSource.getValue("P parallelize", boolean.class, null).orElseGet(() -> root._b_parallelizeGridConnections_DefaultValue_xjal());
			root.p_tempForecastTime_h = root._p_tempForecastTime_h_DefaultValue_xjal();
			root.p_truckTripsCsv = root._p_truckTripsCsv_DefaultValue_xjal();
			root.p_householdTripsCsv = root._p_householdTripsCsv_DefaultValue_xjal();
			root.p_cookingPatternCsv = root._p_cookingPatternCsv_DefaultValue_xjal();
			root.avgc_data = root._avgc_data_DefaultValue_xjal();
			root.b_enableDLR = root._b_enableDLR_DefaultValue_xjal();
			root.b_isInitialized = root._b_isInitialized_DefaultValue_xjal();
			root.b_storePreviousRapidRunData = root._b_storePreviousRapidRunData_DefaultValue_xjal();
			root.p_regionName = root._p_regionName_DefaultValue_xjal();
			root.b_isDeserialised = root._b_isDeserialised_DefaultValue_xjal();
			root.p_timeVariables = root._p_timeVariables_DefaultValue_xjal();
			root.p_timeParameters = root._p_timeParameters_DefaultValue_xjal();
			root.p_pvForecastTime_h = root._p_pvForecastTime_h_DefaultValue_xjal();
			root.p_windForecastTime_h = root._p_windForecastTime_h_DefaultValue_xjal();
			root.p_epexForecastTime_h = root._p_epexForecastTime_h_DefaultValue_xjal();
			root.p_CO2EmissionFactorForecastTime_h = root._p_CO2EmissionFactorForecastTime_h_DefaultValue_xjal();
		}
	}
	
	@Override
	@AnyLogicInternalAPI
	public void getOutputValues(EnergyModel root, IRunOutputsConsumer outputsConsumer) {
	}

	@Override
	@AnyLogicInternalAPI
	public void setup( IExperimentHost host ) {
		host.setSpeed( 10.0 );
		host.setZoomAndPanningEnabled( true );
		host.setDeveloperPanelEnabled( true );
		host.setDeveloperPanelVisibleOnStart( false );
	}

}
