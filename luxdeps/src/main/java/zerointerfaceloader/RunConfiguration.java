package zerointerfaceloader;

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

import zero_engine.*;
import digital_twin_results.*;

import static zerointerfaceloader.OL_FilterOptionsGC.*;
import static zerointerfaceloader.OL_GISBuildingTypes.*;
import static zerointerfaceloader.OL_ProjectType.*;
import static zerointerfaceloader.OL_CustomScenarioTabs.*;
import static zerointerfaceloader.OL_SurveyType.*;
import static zerointerfaceloader.OL_MapOverlayTypes.*;
import static zerointerfaceloader.OL_UserGCAccessType.*;
import static zerointerfaceloader.OL_UserNBHAccessType.*;

import static com.anylogic.engine.Utilities.*;
import java.util.Optional;
import java.io.File;

public class RunConfiguration implements IRunConfiguration<Zero_Interface> {
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
    public Zero_Interface createRootAgent(Engine engine) {
    	return new Zero_Interface( engine, null, null );
    }
	
	@Override
	@AnyLogicInternalCodegenAPI
	public void setupRootParameters( final Zero_Interface root, boolean callOnChangeActions,
			IRunValueAccessor parameterSource ) {

		if (callOnChangeActions) {
			root.set_energyModel( root._energyModel_DefaultValue_xjal() );
			root.set_settings( root._settings_DefaultValue_xjal() );
			root.set_p_currentActiveInfoBubble( root._p_currentActiveInfoBubble_DefaultValue_xjal() );
			root.set_p_minSelectedGCForPublicAggregation( root._p_minSelectedGCForPublicAggregation_DefaultValue_xjal() );
			root.set_b_inEnergyHubSelectionMode( root._b_inEnergyHubSelectionMode_DefaultValue_xjal() );
			root.set_b_inEnergyHubMode( root._b_inEnergyHubMode_DefaultValue_xjal() );
			root.set_user( root._user_DefaultValue_xjal() );
			root.set_project_data( root._project_data_DefaultValue_xjal() );
			root.set_uI_Company( root._uI_Company_DefaultValue_xjal() );
			root.set_uI_EnergyHub( root._uI_EnergyHub_DefaultValue_xjal() );
			root.set_rb_scenarios( root._rb_scenarios_DefaultValue_xjal() );
			root.set_t_scenario_current( root._t_scenario_current_DefaultValue_xjal() );
			root.set_t_scenario_future( root._t_scenario_future_DefaultValue_xjal() );
			root.set_t_scenario_custom( root._t_scenario_custom_DefaultValue_xjal() );
			root.set_p_residentialScenario_Current( root._p_residentialScenario_Current_DefaultValue_xjal() );
			root.set_map_filterOptionUINames( root._map_filterOptionUINames_DefaultValue_xjal() );
			root.set_map_UINamesFilterOption( root._map_UINamesFilterOption_DefaultValue_xjal() );
			root.set_p_defaultMainSliderGCName_solarfarm( root._p_defaultMainSliderGCName_solarfarm_DefaultValue_xjal() );
			root.set_p_defaultMainSliderGCName_windfarm( root._p_defaultMainSliderGCName_windfarm_DefaultValue_xjal() );
			root.set_p_defaultMainSliderGCName_battery( root._p_defaultMainSliderGCName_battery_DefaultValue_xjal() );
			root.set_p_defaultEnergyHubSliderGCName_solarfarm( root._p_defaultEnergyHubSliderGCName_solarfarm_DefaultValue_xjal() );
			root.set_p_defaultEnergyHubSliderGCName_windfarm( root._p_defaultEnergyHubSliderGCName_windfarm_DefaultValue_xjal() );
			root.set_p_defaultEnergyHubSliderGCName_battery( root._p_defaultEnergyHubSliderGCName_battery_DefaultValue_xjal() );
			root.set_p_customMapOverlayName( root._p_customMapOverlayName_DefaultValue_xjal() );
			root.set_p_customMapOverlayLegend( root._p_customMapOverlayLegend_DefaultValue_xjal() );
		} else {
			root.energyModel = root._energyModel_DefaultValue_xjal();
			root.settings = root._settings_DefaultValue_xjal();
			root.p_currentActiveInfoBubble = root._p_currentActiveInfoBubble_DefaultValue_xjal();
			root.p_minSelectedGCForPublicAggregation = root._p_minSelectedGCForPublicAggregation_DefaultValue_xjal();
			root.b_inEnergyHubSelectionMode = root._b_inEnergyHubSelectionMode_DefaultValue_xjal();
			root.b_inEnergyHubMode = root._b_inEnergyHubMode_DefaultValue_xjal();
			root.user = root._user_DefaultValue_xjal();
			root.project_data = root._project_data_DefaultValue_xjal();
			root.uI_Company = root._uI_Company_DefaultValue_xjal();
			root.uI_EnergyHub = root._uI_EnergyHub_DefaultValue_xjal();
			root.rb_scenarios = root._rb_scenarios_DefaultValue_xjal();
			root.t_scenario_current = root._t_scenario_current_DefaultValue_xjal();
			root.t_scenario_future = root._t_scenario_future_DefaultValue_xjal();
			root.t_scenario_custom = root._t_scenario_custom_DefaultValue_xjal();
			root.p_residentialScenario_Current = root._p_residentialScenario_Current_DefaultValue_xjal();
			root.map_filterOptionUINames = root._map_filterOptionUINames_DefaultValue_xjal();
			root.map_UINamesFilterOption = root._map_UINamesFilterOption_DefaultValue_xjal();
			root.p_defaultMainSliderGCName_solarfarm = root._p_defaultMainSliderGCName_solarfarm_DefaultValue_xjal();
			root.p_defaultMainSliderGCName_windfarm = root._p_defaultMainSliderGCName_windfarm_DefaultValue_xjal();
			root.p_defaultMainSliderGCName_battery = root._p_defaultMainSliderGCName_battery_DefaultValue_xjal();
			root.p_defaultEnergyHubSliderGCName_solarfarm = root._p_defaultEnergyHubSliderGCName_solarfarm_DefaultValue_xjal();
			root.p_defaultEnergyHubSliderGCName_windfarm = root._p_defaultEnergyHubSliderGCName_windfarm_DefaultValue_xjal();
			root.p_defaultEnergyHubSliderGCName_battery = root._p_defaultEnergyHubSliderGCName_battery_DefaultValue_xjal();
			root.p_customMapOverlayName = root._p_customMapOverlayName_DefaultValue_xjal();
			root.p_customMapOverlayLegend = root._p_customMapOverlayLegend_DefaultValue_xjal();
		}
	}
	
	@Override
	@AnyLogicInternalAPI
	public void getOutputValues(Zero_Interface root, IRunOutputsConsumer outputsConsumer) {
	}

	@Override
	@AnyLogicInternalAPI
	public void setup( IExperimentHost host ) {
		host.setSpeed( 5.0 );
		host.setZoomAndPanningEnabled( false );
		host.setDeveloperPanelEnabled( false );
		host.setDeveloperPanelVisibleOnStart( false );
	}

}
