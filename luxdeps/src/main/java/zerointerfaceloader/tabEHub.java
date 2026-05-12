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

import java.awt.geom.Arc2D;

public class tabEHub extends zerointerfaceloader.tabArea
{
  // Parameters
  // Plain Variables

  public 
boolean 
 b_inCapacitySharingSelectionMode;
  public 
GridConnection 
 v_recievingGC;
  public 
GridConnection 
 v_sendingGC;
  public 
boolean 
 b_capacitySharingContractWeekendDistinction;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( tabEHub.class );

  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 10.0 );

  @Override
  public Scale getScale() {
    return scale;
  }




  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = zerointerfaceloader.tabArea._STATECHART_COUNT_xjal + 0;


  // Functions

  /**
   * Sets the relevant parameters in the engine for the NFATO. The first selected GC will receive capacity from the second GC.
   */
  protected void f_setCapacitySharingContract( double[] weekCapacities, double[] weekendCapacities ) { 

double[] sharedWeekDeliveryCapacity_kW = new double[24];
double[] sharedWeekendDeliveryCapacity_kW = new double[24];
double[] sharedWeekFeedinCapacity_kW = new double[24];
double[] sharedWeekendFeedinCapacity_kW = new double[24];

switch (rb_capacitySharingDeliveryOrFeedin.getValue()) {
	case 0: // Delivery
		// Set the variables of the GCs
		for (int i = 0; i < 24; i++) {
			sharedWeekDeliveryCapacity_kW[i] = weekCapacities[i];
			sharedWeekendDeliveryCapacity_kW[i] = weekendCapacities[i];
		}
		break;
		
	case 1: // Feed In
		// Set the variables of the GCs
		for (int i = 0; i < 24; i++) {
			sharedWeekFeedinCapacity_kW[i] = weekCapacities[i];
			sharedWeekendFeedinCapacity_kW[i] = weekendCapacities[i];
		}
		break;
		
	case 2: // Both
		// Set the variables of the GCs
		for (int i = 0; i < 24; i++) {
			sharedWeekDeliveryCapacity_kW[i] = weekCapacities[i];
			sharedWeekendDeliveryCapacity_kW[i] = weekendCapacities[i];
			sharedWeekFeedinCapacity_kW[i] = weekCapacities[i];
			sharedWeekendFeedinCapacity_kW[i] = weekendCapacities[i];
		}	
		break;
		
	default:
		throw new IllegalStateException("Invalid Setting in rb_deliveryOrFeedin");
}


new J_CapacitySharingContract(v_recievingGC, v_sendingGC, sharedWeekDeliveryCapacity_kW, sharedWeekendDeliveryCapacity_kW, 
								 sharedWeekFeedinCapacity_kW, sharedWeekendFeedinCapacity_kW, zero_Interface.energyModel.p_timeVariables); 
  }

  /**
   * When b_NFATOListener is true checks wether the selected coordinates are a valid GC for the NFATO. If so saves the GC and updates the text fields
   */
  protected void f_checkGISRegion( double clickx, double clicky ) { 

//Check if click was on Building
for ( GIS_Building b : zero_Interface.energyModel.pop_GIS_Buildings ){
	if( b.gisRegion != null && b.gisRegion.contains(clickx, clicky) ){
		if (b.gisRegion.isVisible()) {
			GridConnection GC = b.c_containedGridConnections.get(0);
			if (GC != null && GC != v_recievingGC) {
				// found a valid GC
				// Check if it is the first GC
				if (v_recievingGC == null) {
					t_capacitySharingRecievingGC.setText(GC.p_ownerID + " zal ontvangen");
					t_capacitySharingSendingGC.setText("Klik op een gebouw dat zijn capaciteit gaat afstaan");
					v_recievingGC = GC;
				}
				else {
					v_sendingGC = GC;
					t_capacitySharingSendingGC.setText(GC.p_ownerID + " zal leveren");
					//for (GIS_Building b : GC.c_connectedBuildings) {
						//b.gisRegion.setFillColor(v_selectionColorAddBuildings);
					//}
					// We found two buildings, return to the default clicking functionality
					b_inCapacitySharingSelectionMode = false;
				}
			}
		}
	}
} 
  }

  /**
   * Checks if the current NFATO settings could generate a valid contract. Returns true if NFATO is possible.
   */
  protected 
boolean 
 f_checkCapacitySharingContract( double[] weekCapacities, double[] weekendCapacities ) { 

if (v_recievingGC == null || v_sendingGC == null || v_recievingGC == v_sendingGC) {
	throw new IllegalStateException("Invalid Capacity sharing contract settings, Please select two (different) gridconnections.");
}
 
    
double[] weekTestDelivery = new double[24];
double[] weekendTestDelivery = new double[24];
double[] weekTestFeedin = new double[24];
double[] weekendTestFeedin = new double[24];

double maxSharedDeliveryCapacity_kW;
double maxSharedFeedinCapacity_kW;
		
switch (rb_capacitySharingDeliveryOrFeedin.getValue()) {
	case 0: // Delivery
		for (int i = 0; i < 24; i++) {
			weekTestDelivery[i] = weekCapacities[i] - v_sendingGC.v_liveConnectionMetaData.getSharedDeliveryCapacityAtHourOfWeekDay_kW(i);
			weekendTestDelivery[i] = weekendCapacities[i] - v_sendingGC.v_liveConnectionMetaData.getSharedDeliveryCapacityAtHourOfWeekendDay_kW(i);
		}
		maxSharedDeliveryCapacity_kW = max(max(weekTestDelivery), max(weekendTestDelivery));

		// Check if sendingGC has enough capacity with the original connection capacity
		if ( maxSharedDeliveryCapacity_kW > v_sendingGC.v_liveConnectionMetaData.getDefaultContractedDeliveryCapacity_kW() ) {
			zero_Interface.f_setErrorScreen("Invalid Capacity Sharing settings, " + v_sendingGC.p_ownerID + " does not have a delivery capacity of " + maxSharedDeliveryCapacity_kW + " kW available", 0, 0);
			return false;
		}
		return true;	
	case 1: // Feed In
		for (int i = 0; i < 24; i++) {
			weekTestFeedin[i] = weekCapacities[i] - v_sendingGC.v_liveConnectionMetaData.getSharedFeedinCapacityAtHourOfWeekDay_kW(i);
			weekendTestFeedin[i] = weekendCapacities[i] - v_sendingGC.v_liveConnectionMetaData.getSharedFeedinCapacityAtHourOfWeekendDay_kW(i);
		}
		maxSharedFeedinCapacity_kW = max(max(weekTestFeedin), max(weekendTestFeedin));
		
		// Check if gc2 has enough capacity with the original connection capacity
		if ( maxSharedFeedinCapacity_kW > v_sendingGC.v_liveConnectionMetaData.getDefaultContractedFeedinCapacity_kW() ) {
			zero_Interface.f_setErrorScreen("Invalid Non-Firm ATO Settings, " + v_sendingGC.p_ownerID + " does not have a feed in capacity of " + maxSharedFeedinCapacity_kW + " kW available", 0, 0);
			return false;
		}
		return true;		
	case 2: // Both
		for (int i = 0; i < 24; i++) {
			weekTestDelivery[i] = weekCapacities[i] - v_sendingGC.v_liveConnectionMetaData.getSharedDeliveryCapacityAtHourOfWeekDay_kW(i);
			weekendTestDelivery[i] = weekendCapacities[i] - v_sendingGC.v_liveConnectionMetaData.getSharedDeliveryCapacityAtHourOfWeekendDay_kW(i);
		}
		for (int i = 0; i < 24; i++) {
			weekTestFeedin[i] = weekCapacities[i] - v_sendingGC.v_liveConnectionMetaData.getSharedFeedinCapacityAtHourOfWeekDay_kW(i);
			weekendTestFeedin[i] = weekendCapacities[i] - v_sendingGC.v_liveConnectionMetaData.getSharedFeedinCapacityAtHourOfWeekendDay_kW(i);
		}
		
		maxSharedDeliveryCapacity_kW = max(max(weekTestDelivery), max(weekendTestDelivery));
		maxSharedFeedinCapacity_kW = max(max(weekTestFeedin), max(weekendTestFeedin));
		
		// Check if sendingGC has enough capacity with the original connection capacity
		if ( maxSharedDeliveryCapacity_kW > v_sendingGC.v_liveConnectionMetaData.getDefaultContractedDeliveryCapacity_kW() ) {
			zero_Interface.f_setErrorScreen("Invalid Non-Firm ATO Settings, " + v_sendingGC.p_ownerID + " does not have a delivery capacity of " + maxSharedDeliveryCapacity_kW + " kW available", 0, 0);
			return false;
		}
		else if ( maxSharedFeedinCapacity_kW > v_sendingGC.v_liveConnectionMetaData.getDefaultContractedFeedinCapacity_kW() ) {
			zero_Interface.f_setErrorScreen("Invalid Non-Firm ATO Settings, " + v_sendingGC.p_ownerID + " does not have a feed in capacity of " + maxSharedFeedinCapacity_kW + " kW available", 0, 0);
			return false;
		}
		return true;			
	default:
		throw new IllegalStateException("Invalid Setting in rb_deliveryOrFeedin");
} 
  }

  /**
   * Uses the NFATO slider values to construct two arrays of the change in capacity at every hour. One array for weekdays, one for weekends
   */
  protected 
double[][] 
 f_constructCapacitySharingArrays(  ) { 

// Construct arrays from slider values
// Week
int weekStart_h = (int) sl_capacitySharingWeekStartTime.getValue();
int weekEnd_h = (int) sl_capacitySharingWeekEndTime.getValue();
int weekCapacity_kW = (int) sl_capacitySharingWeekCapacity.getValue();

double[] weekCapacities = new double[24];
double[] weekendCapacities = new double[24];

if (weekStart_h < weekEnd_h) {
	for (int i = 0; i < weekStart_h; i++) {
		weekCapacities[i] = 0;
	}
	for (int j = weekStart_h; j < weekEnd_h; j ++) {
		weekCapacities[j] = weekCapacity_kW;
	}
	for (int k = weekEnd_h; k < 24; k ++) {
		weekCapacities[k] = 0;
	}
}
else { // If the start time is higher than the end time we share capacity at night
	for (int i = 0; i < weekEnd_h; i++) {
		weekCapacities[i] = weekCapacity_kW;
	}
	for (int j = weekEnd_h; j < weekStart_h ; j ++) {
		weekCapacities[j] = 0;
	}
	for (int k = weekStart_h; k < 24; k ++) {
		weekCapacities[k] = weekCapacity_kW;
	}
}

if (b_capacitySharingContractWeekendDistinction) {
	// repeat above code for weekend
	int weekendStart_h = (int) sl_capacitySharingWeekendStartTime.getValue();
	int weekendEnd_h = (int) sl_capacitySharingWeekendEndTime.getValue();
	int weekendCapacity_kW = (int) sl_capacitySharingWeekendCapacity.getValue();
	
	
	if (weekendStart_h < weekendEnd_h) {
		for (int i = 0; i < weekendStart_h; i++) {
			weekendCapacities[i] = 0;
		}
		for (int j = weekendStart_h; j < weekendEnd_h; j ++) {
			weekendCapacities[j] = weekendCapacity_kW;
		}
		for (int k = weekendEnd_h; k < 24; k ++) {
			weekendCapacities[k] = 0;
		}
	}
	else { // If the start time is higher than the end time we share capacity at night
		for (int i = 0; i < weekendEnd_h; i++) {
			weekendCapacities[i] = weekendCapacity_kW;
		}
		for (int j = weekendEnd_h; j < weekendStart_h; j ++) {
			weekendCapacities[j] = 0;
		}
		for (int k = weekendStart_h; k < 24; k ++) {
			weekendCapacities[k] = weekendCapacity_kW;
		}
	}
}
else {
	// no distinction means the settings are the same during the weekend
	weekendCapacities = weekCapacities;
}

double[][] arr = {weekCapacities, weekendCapacities};
return arr; 
  }

  /**
   * Resets the group of NFATO Settings after a contract is added or canceled.
   */
  protected void f_resetCapacitySharingSettings(  ) { 

t_capacitySharingRecievingGC.setText("Klik op een gebouw dat capaciteit gaat ontvangen");
t_capacitySharingSendingGC.setText("");
v_recievingGC = null;
v_sendingGC = null;
b_inCapacitySharingSelectionMode = false; 
  }

  /**
   * Function that ensures the correct tab is visible
   */
  protected void f_setTab( OL_CustomScenarioTabs selectedTabType ) { 

if (selectedTabType == OL_CustomScenarioTabs.NFATO) {
	gr_nfatoSettings.setVisible(true);
	gr_hubSliders.setVisible(false);
}
else {
	gr_nfatoSettings.setVisible(false);
	gr_hubSliders.setVisible(true);
} 
  }

  protected void f_updateSliders_EHub(  ) { 

//Function that can be used to update sliders/buttons to the engine state
//--> empty for now 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_add_capacitySharingContract_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_remove_capacitySharingContracts_Font = _button_add_capacitySharingContract_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_createEnergyHub_Font = _button_add_capacitySharingContract_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_loadScenario_Font = _button_add_capacitySharingContract_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _cb_capacitySharingWeekendDistinction_Font = new Font("Dialog", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_confirm_capacitySharingContract_Font = _button_add_capacitySharingContract_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_cancel_capacitySharging_Font = _button_add_capacitySharingContract_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _rb_capacitySharingDeliveryOrFeedin_Font = _button_add_capacitySharingContract_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_CapacitySharingOptions_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_energyHubOptions_Font = _txt_CapacitySharingOptions_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_loadScenario_Font = _txt_CapacitySharingOptions_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_capacitySharingRecievingGC_Font = _cb_capacitySharingWeekendDistinction_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_capacitySharingSendingGC_Font = _cb_capacitySharingWeekendDistinction_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_capacitySharingWeekStartTime_Font = _cb_capacitySharingWeekendDistinction_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_capacitySharingWeekEndTime_Font = _cb_capacitySharingWeekendDistinction_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_capacitySharingCapacity_Font = _cb_capacitySharingWeekendDistinction_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_capacitySharingWeek_Font = _cb_capacitySharingWeekendDistinction_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_capacitySharingWeekend_Font = _cb_capacitySharingWeekendDistinction_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_capacitySharingFunctionsDescription_Font = new Font("Dialog", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_generalFunctionsDescription_Font = new Font("SansSerif", 0, 18 );
  protected static final Color _rect_hubSliders_Fill_Color = new Color( 0xFFC6FBC6, true );
  protected static final Color _rect_nfatoSettings_Fill_Color = new Color( 0xFFC6FBC6, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_generalFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_nfatoFunctions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_hubSliders = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_CapacitySharingOptions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_energyHubOptions = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_loadScenario = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_hubSliders = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_nfatoSettings = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_capacitySharingRecievingGC = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_capacitySharingSendingGC = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_capacitySharingWeekStartTime = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_capacitySharingWeekEndTime = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_capacitySharingCapacity = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_capacitySharingWeek = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_capacitySharingWeekend = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_nfatoSettings = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_capacitySharingFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_generalFunctionsDescription = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_add_capacitySharingContract = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_remove_capacitySharingContracts = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_createEnergyHub = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_loadScenario = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_capacitySharingWeekStartTime = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _cb_capacitySharingWeekendDistinction = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_capacitySharingWeekEndTime = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_capacitySharingWeekCapacity = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_confirm_capacitySharingContract = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _button_cancel_capacitySharging = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_capacitySharingWeekendStartTime = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_capacitySharingWeekendEndTime = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _sl_capacitySharingWeekendCapacity = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _rb_capacitySharingDeliveryOrFeedin = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 32;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = zerointerfaceloader.tabArea._SHAPE_NEXT_ID_xjal + 33;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return super.isPublicPresentationDefined() || true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rect_generalFunctions, rect_nfatoFunctions, gr_hubSliders, gr_nfatoSettings, txt_capacitySharingFunctionsDescription, t_generalFunctionsDescription);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _button_add_capacitySharingContract: {
          ShapeButton self = this.button_add_capacitySharingContract;
/*
if (v_NFATOListener) {
	// This should not be reachable anymore
	traceln("Quitting NF ATO settings");
	v_NFATOListener = false;
	return;
}
*/

if (zero_Interface.v_clickedObjectType != null && zero_Interface.v_clickedObjectType == OL_GISObjectType.BUILDING && zero_Interface.c_selectedGridConnections.size() != 0) {
	v_recievingGC = zero_Interface.c_selectedGridConnections.get(0);
	t_capacitySharingRecievingGC.setText(v_recievingGC.p_ownerID + " zal ontvangen");
	t_capacitySharingSendingGC.setText("Klik op een gebouw dat zijn capaciteit gaat afstaan");	
}

// When this boolean is true clicking on the GIS Map will select another building for the NF ATO
b_inCapacitySharingSelectionMode = true;
f_setTab(NFATO);


if (b_capacitySharingContractWeekendDistinction) {
	txt_capacitySharingWeek.setVisible(true);
	txt_capacitySharingWeekend.setVisible(true);
	sl_capacitySharingWeekendStartTime.setVisible(true);
	sl_capacitySharingWeekendEndTime.setVisible(true);
	sl_capacitySharingWeekendCapacity.setVisible(true);
}
else {
	txt_capacitySharingWeek.setVisible(false);
	txt_capacitySharingWeekend.setVisible(false);
	sl_capacitySharingWeekendStartTime.setVisible(false);
	sl_capacitySharingWeekendEndTime.setVisible(false);
	sl_capacitySharingWeekendCapacity.setVisible(false);
}


// TODO: Color the companies on the GIS Map (e.g. according to grid topology) 
;}
        break;
      case _button_remove_capacitySharingContracts: {
          ShapeButton self = this.button_remove_capacitySharingContracts;
for (GridConnection GC : zero_Interface.energyModel.f_getActiveGridConnections()) {
	GC.v_liveConnectionMetaData.clearSharedCapacityManagers();
}

//Update variable to change to custom scenario
if(!zero_Interface.b_runningMainInterfaceScenarios){
	zero_Interface.f_setScenarioToCustom();
}

button_remove_capacitySharingContracts.setEnabled(false);

zero_Interface.f_resetSettings(); 
;}
        break;
      case _button_createEnergyHub: {
          ShapeButton self = this.button_createEnergyHub;
zero_Interface.f_startEnergyHubConfiguration(); 
;}
        break;
      case _button_loadScenario: {
          ShapeButton self = this.button_loadScenario;
// First check if there are any save files, if there are none we display an error screen

zero_Interface.uI_EnergyHub.f_initializeUserSavedScenarios(zero_Interface.uI_EnergyHub.combobox_selectScenario);
if (zero_Interface.uI_EnergyHub.combobox_selectScenario.getItems().length == 0) {
	zero_Interface.f_setErrorScreen("Er zijn nog geen scenario's opgeslagen.", 0, 0);
	return;
}

zero_Interface.f_setLoadingScreen(true, 0, 0);

new Thread( () -> {	
	// Opens the filter menu on the main interface
	zero_Interface.f_startEnergyHubConfiguration();
	
	// Add a manual select to the filter with all (active) gridconnections
	// We should follow the usual procedure of creating an E-Hub so that the user could cancel and reconfigure
	zero_Interface.f_setFilter(OL_FilterOptionsGC.MANUAL_SELECTION);
	zero_Interface.c_selectedGridConnections = zero_Interface.energyModel.f_getActiveGridConnections();
	zero_Interface.f_applyFilter(OL_FilterOptionsGC.MANUAL_SELECTION, "");
	
	zero_Interface.f_setLoadingScreen(false, 0, 0);
	
	// Create a coop with the selection
	zero_Interface.f_finalizeEnergyHubConfiguration();	
	
	// Select load scenario in the E-Hub configurator
	zero_Interface.uI_EnergyHub.button_loadScenario.action();

}).start();
 
;}
        break;
      case _button_confirm_capacitySharingContract: {
          ShapeButton self = this.button_confirm_capacitySharingContract;
if (sl_capacitySharingWeekStartTime.getValue() == sl_capacitySharingWeekEndTime.getValue()) {
	traceln("Week start time is the same as end time");
}
else if (sl_capacitySharingWeekendStartTime.getValue() == sl_capacitySharingWeekendEndTime.getValue()) {
	traceln("Weekend start time is the same as end time");
}
else {
	double[][] arr = f_constructCapacitySharingArrays();
	
	double[] weekCapacities = arr[0];
	double[] weekendCapacities = arr[1];
	
	if (f_checkCapacitySharingContract(weekCapacities, weekendCapacities)) {	
		f_setCapacitySharingContract(weekCapacities, weekendCapacities);
		f_setTab(HUB);
		// reset the nfato settings
		f_resetCapacitySharingSettings();
		zero_Interface.f_resetSettings();
		
		button_remove_capacitySharingContracts.setEnabled(true);
		
		//Update variable to change to custom scenario
		if(!zero_Interface.b_runningMainInterfaceScenarios){
			zero_Interface.f_setScenarioToCustom();
		}
	}
}

 
;}
        break;
      case _button_cancel_capacitySharging: {
          ShapeButton self = this.button_cancel_capacitySharging;
f_setTab(HUB);
f_resetCapacitySharingSettings(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, boolean value ) {
    switch( _shape ) {
      case _cb_capacitySharingWeekendDistinction:
        b_capacitySharingContractWeekendDistinction = value; {
          ShapeCheckBox self = this.cb_capacitySharingWeekendDistinction;
if (b_capacitySharingContractWeekendDistinction) {
	txt_capacitySharingWeek.setVisible(true);
	txt_capacitySharingWeekend.setVisible(true);
	sl_capacitySharingWeekendStartTime.setVisible(true);
	sl_capacitySharingWeekendEndTime.setVisible(true);
	sl_capacitySharingWeekendCapacity.setVisible(true);
}
else {
	txt_capacitySharingWeek.setVisible(false);
	txt_capacitySharingWeekend.setVisible(false);
	sl_capacitySharingWeekendStartTime.setVisible(false);
	sl_capacitySharingWeekendEndTime.setVisible(false);
	sl_capacitySharingWeekendCapacity.setVisible(false);
} 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
 
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean getShapeControlDefaultValueBoolean( int _shape, int index ) {
    switch(_shape) {
      case _cb_capacitySharingWeekendDistinction: return 
b_capacitySharingContractWeekendDistinction 
;
      default: return super.getShapeControlDefaultValueBoolean( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getShapeControlDefaultValueInt( int _shape, int index ) {
    switch(_shape) {
      case _rb_capacitySharingDeliveryOrFeedin: return 
2 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlDefaultValueDouble( int _shape, int index ) {
    switch(_shape) {
      case _sl_capacitySharingWeekStartTime: return 
8 
;
      case _sl_capacitySharingWeekEndTime: return 
20 
;
      case _sl_capacitySharingWeekCapacity: return 
100 
;
      case _sl_capacitySharingWeekendStartTime: return 
8 
;
      case _sl_capacitySharingWeekendEndTime: return 
20 
;
      case _sl_capacitySharingWeekendCapacity: return 
100 
;
      default: return super.getShapeControlDefaultValueDouble( _shape, index );
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_add_capacitySharingContract_SetDynamicParams_xjal( ShapeButton shape ) {
    shape.setEnabled(
!zero_Interface.settings.isPublicModel() 
);
  }
  
  protected ShapeButton button_add_capacitySharingContract;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_remove_capacitySharingContracts_SetDynamicParams_xjal( ShapeButton shape ) {
    boolean _visible = 
!zero_Interface.settings.isPublicModel() 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeButton button_remove_capacitySharingContracts;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_createEnergyHub_SetDynamicParams_xjal( ShapeButton shape ) {
    shape.setEnabled(
!zero_Interface.settings.isPublicModel() 
);
  }
  
  protected ShapeButton button_createEnergyHub;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_loadScenario_SetDynamicParams_xjal( ShapeButton shape ) {
    shape.setEnabled(
!zero_Interface.settings.isPublicModel() 
);
  }
  
  protected ShapeButton button_loadScenario;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_capacitySharingWeekStartTime_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
24 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_capacitySharingWeekStartTime;
  protected ShapeCheckBox cb_capacitySharingWeekendDistinction;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_capacitySharingWeekEndTime_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
24 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_capacitySharingWeekEndTime;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_capacitySharingWeekCapacity_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
2000 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_capacitySharingWeekCapacity;
  protected ShapeButton button_confirm_capacitySharingContract;
  protected ShapeButton button_cancel_capacitySharging;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_capacitySharingWeekendStartTime_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
24 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_capacitySharingWeekendStartTime;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_capacitySharingWeekendEndTime_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
24 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_capacitySharingWeekendEndTime;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sl_capacitySharingWeekendCapacity_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
2000 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider sl_capacitySharingWeekendCapacity;
  protected ShapeRadioButtonGroup rb_capacitySharingDeliveryOrFeedin;
  protected ShapeRectangle rect_generalFunctions;
  protected ShapeRectangle rect_nfatoFunctions;
  protected ShapeRectangle rect_hubSliders;
  protected ShapeText txt_CapacitySharingOptions;
  protected ShapeText txt_energyHubOptions;
  protected ShapeText txt_loadScenario;
  protected ShapeGroup gr_hubSliders;
  protected ShapeRectangle rect_nfatoSettings;
  protected ShapeText t_capacitySharingRecievingGC;
  protected ShapeText t_capacitySharingSendingGC;
  protected ShapeText txt_capacitySharingWeekStartTime;
  protected ShapeText txt_capacitySharingWeekEndTime;
  protected ShapeText txt_capacitySharingCapacity;
  protected ShapeText txt_capacitySharingWeek;
  protected ShapeText txt_capacitySharingWeekend;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _gr_nfatoSettings_SetDynamicParams_xjal( ShapeGroup shape ) {
    shape.setX(
0 
);
    shape.setY(
0 
);
  }
  
  protected ShapeGroup gr_nfatoSettings;
  protected ShapeText txt_capacitySharingFunctionsDescription;
  protected ShapeText t_generalFunctionsDescription;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    button_add_capacitySharingContract = new ShapeButton(
tabEHub.this, true, 40.0, 45.0,
			290.0, 30.0,
            black, true,
_button_add_capacitySharingContract_Font,
			"Voeg contractuele capaciteitsdeling toe" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_add_capacitySharingContract_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_add_capacitySharingContract, 0 );
      }
    };
    button_remove_capacitySharingContracts = new ShapeButton(
tabEHub.this, true, 40.0, 85.0,
			290.0, 30.0,
            black, true,
_button_remove_capacitySharingContracts_Font,
			"Verwijder alle contractuele capaciteitsdelingen" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_remove_capacitySharingContracts_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_remove_capacitySharingContracts, 0 );
      }
    };
    button_createEnergyHub = new ShapeButton(
tabEHub.this, true, 40.0, 160.0,
			290.0, 70.0,
            black, true,
_button_createEnergyHub_Font,
			"Creeër je eigen Energie Hub" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_createEnergyHub_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_createEnergyHub, 0 );
      }
    };
    button_loadScenario = new ShapeButton(
tabEHub.this, true, 40.0, 280.0,
			290.0, 50.0,
            black, true,
_button_loadScenario_Font,
			"Laad een opgeslagen scenario in" ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _button_loadScenario_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_loadScenario, 0 );
      }
    };
    sl_capacitySharingWeekStartTime = new ShapeSlider(
tabEHub.this, true, 125.0, 180.0,
			100.0, 30.0,
            true, false,
            0
            , 24
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_capacitySharingWeekStartTime_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_capacitySharingWeekStartTime, 0 ), getMax() ) );
      }
    };
    cb_capacitySharingWeekendDistinction = new ShapeCheckBox(
tabEHub.this,true,25.0, 75.0,
		190.0, 30.0,
            black, true,
            _cb_capacitySharingWeekendDistinction_Font,
			"verschil week & weekend" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cb_capacitySharingWeekendDistinction, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cb_capacitySharingWeekendDistinction, 0 ) );
      }
    };
    sl_capacitySharingWeekEndTime = new ShapeSlider(
tabEHub.this, true, 125.0, 210.0,
			100.0, 30.0,
            true, false,
            0
            , 24
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_capacitySharingWeekEndTime_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_capacitySharingWeekEndTime, 0 ), getMax() ) );
      }
    };
    sl_capacitySharingWeekCapacity = new ShapeSlider(
tabEHub.this, true, 125.0, 245.0,
			100.0, 30.0,
            true, false,
            0
            , 2000
            , 10
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_capacitySharingWeekCapacity_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_capacitySharingWeekCapacity, 0 ), getMax() ) );
      }
    };
    button_confirm_capacitySharingContract = new ShapeButton(
tabEHub.this, true, 25.0, 295.0,
			195.0, 30.0,
            black, true,
_button_confirm_capacitySharingContract_Font,
			"Voltooi capaciteitsdeling contract" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_confirm_capacitySharingContract, 0 );
      }
    };
    button_cancel_capacitySharging = new ShapeButton(
tabEHub.this, true, 275.0, 295.0,
			75.0, 30.0,
            black, true,
_button_cancel_capacitySharging_Font,
			"Cancel" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button_cancel_capacitySharging, 0 );
      }
    };
    sl_capacitySharingWeekendStartTime = new ShapeSlider(
tabEHub.this, true, 247.0, 180.0,
			100.0, 30.0,
            true, false,
            0
            , 24
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_capacitySharingWeekendStartTime_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_capacitySharingWeekendStartTime, 0 ), getMax() ) );
      }
    };
    sl_capacitySharingWeekendEndTime = new ShapeSlider(
tabEHub.this, true, 247.0, 210.0,
			100.0, 30.0,
            true, false,
            0
            , 24
            , 1
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_capacitySharingWeekendEndTime_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_capacitySharingWeekendEndTime, 0 ), getMax() ) );
      }
    };
    sl_capacitySharingWeekendCapacity = new ShapeSlider(
tabEHub.this, true, 247.0, 245.0,
			100.0, 30.0,
            true, false,
            0
            , 2000
            , 10
            , ShapeControl.TYPE_DOUBLE ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _sl_capacitySharingWeekendCapacity_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sl_capacitySharingWeekendCapacity, 0 ), getMax() ) );
      }
    };
    rb_capacitySharingDeliveryOrFeedin = new ShapeRadioButtonGroup(
tabEHub.this, true, 25.0, 105.0,
			70.0, 70.0,
            black, true,
_rb_capacitySharingDeliveryOrFeedin_Font, true,
            new String[]{"Delivery", "Feed in", "Both", } ) {

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _rb_capacitySharingDeliveryOrFeedin, 0 ) );
      }
    };
    rect_generalFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,430.0, 650.0, 0.0, 0.0,
            black, white,
			230.0, 170.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_nfatoFunctions = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,700.0, 650.0, 0.0, 0.0,
            lime, white,
			440.0, 300.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_hubSliders = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, _rect_hubSliders_Fill_Color,
			370.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_CapacitySharingOptions = new ShapeText(
        SHAPE_DRAW_2D, true,185.0, 20.0, 0.0, 0.0,
        black,"Contract Capaciteit delen",
        _txt_CapacitySharingOptions_Font, ALIGNMENT_CENTER );
    txt_energyHubOptions = new ShapeText(
        SHAPE_DRAW_2D, true,185.0, 135.0, 0.0, 0.0,
        black,"Energie Hub",
        _txt_energyHubOptions_Font, ALIGNMENT_CENTER );
    txt_loadScenario = new ShapeText(
        SHAPE_DRAW_2D, true,180.0, 250.0, 0.0, 0.0,
        black,"Opgeslagen Scenario's",
        _txt_loadScenario_Font, ALIGNMENT_CENTER );
    rect_nfatoSettings = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            null, _rect_nfatoSettings_Fill_Color,
			370.0, 350.0, 10.0, 3.0, LINE_STYLE_SOLID );
    t_capacitySharingRecievingGC = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 20.0, 0.0, 0.0,
        black,"Klik op een gebouw dat capaciteit gaat ontvangen",
        _t_capacitySharingRecievingGC_Font, ALIGNMENT_LEFT );
    t_capacitySharingSendingGC = new ShapeText(
        SHAPE_DRAW_2D, true,25.0, 50.0, 0.0, 0.0,
        black,"",
        _t_capacitySharingSendingGC_Font, ALIGNMENT_LEFT );
    txt_capacitySharingWeekStartTime = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 185.0, 0.0, 0.0,
        black,"Start tijd (uur)",
        _txt_capacitySharingWeekStartTime_Font, ALIGNMENT_LEFT );
    txt_capacitySharingWeekEndTime = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 215.0, 0.0, 0.0,
        black,"Eind tijd (uur)",
        _txt_capacitySharingWeekEndTime_Font, ALIGNMENT_LEFT );
    txt_capacitySharingCapacity = new ShapeText(
        SHAPE_DRAW_2D, true,10.0, 250.0, 0.0, 0.0,
        black,"Capaciteit (kW)",
        _txt_capacitySharingCapacity_Font, ALIGNMENT_LEFT );
    txt_capacitySharingWeek = new ShapeText(
        SHAPE_DRAW_2D, true,155.0, 155.0, 0.0, 0.0,
        black,"Week\n",
        _txt_capacitySharingWeek_Font, ALIGNMENT_LEFT );
    txt_capacitySharingWeek.setVisible( false );
    txt_capacitySharingWeekend = new ShapeText(
        SHAPE_DRAW_2D, true,265.0, 155.0, 0.0, 0.0,
        black,"Weekend\n",
        _txt_capacitySharingWeekend_Font, ALIGNMENT_LEFT );
    txt_capacitySharingWeekend.setVisible( false );
    txt_capacitySharingFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,840.0, 665.0, 0.0, 0.0,
        black,"Capacity Sharing Functions",
        _txt_capacitySharingFunctionsDescription_Font, ALIGNMENT_CENTER );
    t_generalFunctionsDescription = new ShapeText(
        SHAPE_DRAW_2D, false,460.0, 660.0, 0.0, 0.0,
        black,"General Functions",
        _t_generalFunctionsDescription_Font, ALIGNMENT_LEFT );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_hubSliders = new ShapeGroup( tabEHub.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     , rect_hubSliders
	     , button_add_capacitySharingContract
	     , button_remove_capacitySharingContracts
	     , button_createEnergyHub
	     , txt_CapacitySharingOptions
	     , txt_energyHubOptions
	     , button_loadScenario
	     , txt_loadScenario );
    }
    gr_hubSliders.setVisible( false );
    {
    gr_nfatoSettings = new ShapeGroup( tabEHub.this, SHAPE_DRAW_2D3D, true, 0.0, 410.0, 0.0, 0.0
	
	     , rect_nfatoSettings
	     , t_capacitySharingRecievingGC
	     , t_capacitySharingSendingGC
	     , sl_capacitySharingWeekStartTime
	     , cb_capacitySharingWeekendDistinction
	     , sl_capacitySharingWeekEndTime
	     , sl_capacitySharingWeekCapacity
	     , button_confirm_capacitySharingContract
	     , button_cancel_capacitySharging
	     , txt_capacitySharingWeekStartTime
	     , txt_capacitySharingWeekEndTime
	     , txt_capacitySharingCapacity
	     , txt_capacitySharingWeek
	     , txt_capacitySharingWeekend
	     , sl_capacitySharingWeekendStartTime
	     , sl_capacitySharingWeekendEndTime
	     , sl_capacitySharingWeekendCapacity
	     , rb_capacitySharingDeliveryOrFeedin ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _gr_nfatoSettings_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    }
    gr_nfatoSettings.setVisible( false );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }



  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = concatenateArrays( super.getLevels(), 
      level );
    _createPersistentElementsBP0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

	


  /**
   * Constructor
   */
  public tabEHub( Engine engine, Agent owner, AgentList<? extends tabEHub> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    uI_Tabs = get_UI_Tabs();
    zero_Interface = get_Zero_Interface();
    uI_EnergyHub = get_UI_EnergyHub();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public tabEHub() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_tabEHub_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "zerointerfaceloader.tabEHub.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( tabEHub.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    sl_capacitySharingWeekStartTime.setValueToDefault();
    cb_capacitySharingWeekendDistinction.setValueToDefault();
    sl_capacitySharingWeekEndTime.setValueToDefault();
    sl_capacitySharingWeekCapacity.setValueToDefault();
    sl_capacitySharingWeekendStartTime.setValueToDefault();
    sl_capacitySharingWeekendEndTime.setValueToDefault();
    sl_capacitySharingWeekendCapacity.setValueToDefault();
    rb_capacitySharingDeliveryOrFeedin.setValueToDefault();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_tabEHub_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_tabEHub_xjal() {
    b_capacitySharingContractWeekendDistinction = 
false 
;
  }

  // User API -----------------------------------------------------
  public UI_Tabs get_UI_Tabs() {
    {
      Agent owner = getOwner();
      if ( owner instanceof UI_Tabs ) return (UI_Tabs) owner;
    }
    return null;
  }

  public UI_EnergyHub get_UI_EnergyHub() {
    {
      UI_Tabs ownerAccessor = get_UI_Tabs();
      if (ownerAccessor != null) {
        UI_EnergyHub owner = ownerAccessor.get_UI_EnergyHub();
        if (owner != null) return owner;
      }
    }
    return null;
  }

  public Zero_Interface get_Zero_Interface() {
    {
      UI_Tabs ownerAccessor = get_UI_Tabs();
      if (ownerAccessor != null) {
        Zero_Interface owner = ownerAccessor.get_Zero_Interface();
        if (owner != null) return owner;
      }
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zerointerfaceloader.UI_Tabs uI_Tabs;

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zerointerfaceloader.Zero_Interface zero_Interface;

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zerointerfaceloader.UI_EnergyHub uI_EnergyHub;

  public AgentList<? extends tabEHub> getPopulation() {
    return (AgentList<? extends tabEHub>) super.getPopulation();
  }

  public List<? extends tabEHub> agentsInRange( double distance ) {
    return (List<? extends tabEHub>) super.agentsInRange( distance );
  }

  // Additional class code

public ShapeGroup getGroupHubSliders() {
	return this.gr_hubSliders;
}

public ShapeButton getButton_remove_nfato() {
	return this.button_remove_capacitySharingContracts;
}

public ShapeButton getButton_createEnergyHub() {
	return this.button_createEnergyHub;
} 
  // End of additional class code

}
