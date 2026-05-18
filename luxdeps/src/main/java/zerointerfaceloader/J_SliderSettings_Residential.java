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

/**
 * J_SliderSettings_Residential
 */	
public class J_SliderSettings_Residential {
	
	////Electricity
	private double housesWithPV_pct;
	private double pvHousesWithBattery_pct;
	private boolean cb_householdCurtailmentActive;
	private double cooking_pct;
	private double electricityDemandIncrease_pct;
	private double largeScalePV_ha;
	private double largeScaleWind_MW;
	private double averageNeighbourhoodBatterySize_kWh;
	private boolean cb_gridCurtailmentActive;

	////Heating
	private double housesWithGasBurners_pct;
	private double housesWithHybridHeatpump_pct;
	private double housesWithElectricHeatpump_pct;
	private boolean cb_householdHTDistrictHeatingActive;
	private boolean cb_householdLTDistrictHeatingActive;
	private double housesWithAirco_pct;
	private double housesWithImprovedInsulation_pct;
	private double nbHousesWithPT_pct;

	////Mobility
	private double privateEVs_pct;
	private double privateEVsThatSupportV2G_pct;
	private String selectedChargingAttitudeStringPrivateEVs;
	private boolean V2GActivePrivateEVs;
	private double activePublicChargers_pct;
	private double chargersV1G_pct;
	private double chargersV2G_pct;
	private String selectedChargingAttitudeStringChargers;
	private boolean V2GActiveChargers;
	
	
	
    /**
     * Default constructor
     */
    public J_SliderSettings_Residential() {
    }
	
	// ====== Setters ======
    // Electricity
	public void setHousesWithPV_pct(double housesWithPV_pct) {
	    this.housesWithPV_pct = housesWithPV_pct;
	}

	public void setPvHousesWithBattery_pct(double pvHousesWithBattery_pct) {
	    this.pvHousesWithBattery_pct = pvHousesWithBattery_pct;
	}
	
	public void setCb_householdCurtailmentActive(boolean cb_householdCurtailmentActive) {
	    this.cb_householdCurtailmentActive = cb_householdCurtailmentActive;
	}

	public void setCooking_pct(double cooking_pct) {
	    this.cooking_pct = cooking_pct;
	}

	public void setElectricityDemandIncrease_pct(double electricityDemandIncrease_pct) {
	    this.electricityDemandIncrease_pct = electricityDemandIncrease_pct;
	}
	
	public void setLargeScalePV_ha(double largeScalePV_ha) {
	    this.largeScalePV_ha = largeScalePV_ha;
	}
	
	public void setLargeScaleWind_MW(double largeScaleWind_MW) {
	    this.largeScaleWind_MW = largeScaleWind_MW;
	}

	public void setAverageNeighbourhoodBatterySize_kWh(double averageNeighbourhoodBatterySize_kWh) {
	    this.averageNeighbourhoodBatterySize_kWh = averageNeighbourhoodBatterySize_kWh;
	}
	
	public void setCb_gridCurtailmentActive(boolean cb_gridCurtailmentActive) {
	    this.cb_gridCurtailmentActive = cb_gridCurtailmentActive;
	}

	// Heating
	public void setHousesWithGasBurners_pct(double housesWithGasBurners_pct) {
	    this.housesWithGasBurners_pct = housesWithGasBurners_pct;
	}

	public void setHousesWithHybridHeatpump_pct(double housesWithHybridHeatpump_pct) {
	    this.housesWithHybridHeatpump_pct = housesWithHybridHeatpump_pct;
	}

	public void setHousesWithElectricHeatpump_pct(double housesWithElectricHeatpump_pct) {
	    this.housesWithElectricHeatpump_pct = housesWithElectricHeatpump_pct;
	}

	public void setCb_householdHTDistrictHeatingActive(boolean cb_householdHTDistrictHeatingActive) {
	    this.cb_householdHTDistrictHeatingActive = cb_householdHTDistrictHeatingActive;
	}

	public void setCb_householdLTDistrictHeatingActive(boolean cb_householdLTDistrictHeatingActive) {
	    this.cb_householdLTDistrictHeatingActive = cb_householdLTDistrictHeatingActive;
	}

	public void setHousesWithAirco_pct(double housesWithAirco_pct) {
	    this.housesWithAirco_pct = housesWithAirco_pct;
	}

	public void setHousesWithImprovedInsulation_pct(double housesWithImprovedInsulation_pct) {
	    this.housesWithImprovedInsulation_pct = housesWithImprovedInsulation_pct;
	}

	public void setNbHousesWithPT_pct(double nbHousesWithPT_pct) {
	    this.nbHousesWithPT_pct = nbHousesWithPT_pct;
	}

	// Mobility
	public void setPrivateEVs_pct(double privateEVs_pct) {
	    this.privateEVs_pct = privateEVs_pct;
	}

	public void setPrivateEVsThatSupportV2G_pct(double privateEVsThatSupportV2G_pct) {
	    this.privateEVsThatSupportV2G_pct = privateEVsThatSupportV2G_pct;
	}

	public void setSelectedChargingAttitudeStringPrivateEVs(String selectedChargingAttitudeStringPrivateEVs) {
	    this.selectedChargingAttitudeStringPrivateEVs = selectedChargingAttitudeStringPrivateEVs;
	}

	public void setV2GActivePrivateEVs(boolean V2GActivePrivateEVs) {
	    this.V2GActivePrivateEVs = V2GActivePrivateEVs;
	}

	public void setActivePublicChargers_pct(double activePublicChargers_pct) {
	    this.activePublicChargers_pct = activePublicChargers_pct;
	}

	public void setChargersV1G_pct(double chargersV1G_pct) {
	    this.chargersV1G_pct = chargersV1G_pct;
	}

	public void setChargersV2G_pct(double chargersV2G_pct) {
	    this.chargersV2G_pct = chargersV2G_pct;
	}

	public void setSelectedChargingAttitudeStringChargers(String selectedChargingAttitudeStringChargers) {
	    this.selectedChargingAttitudeStringChargers = selectedChargingAttitudeStringChargers;
	}

	public void setV2GActiveChargers(boolean V2GActiveChargers) {
	    this.V2GActiveChargers = V2GActiveChargers;
	}

	// ====== Getters ======
	// Electricity
	public double getHousesWithPV_pct() {
	    return housesWithPV_pct;
	}

	public double getPvHousesWithBattery_pct() {
	    return pvHousesWithBattery_pct;
	}
	
	public boolean getCb_householdCurtailmentActive() {
	    return cb_householdCurtailmentActive;
	}

	public double getCooking_pct() {
	    return cooking_pct;
	}

	public double getElectricityDemandIncrease_pct() {
	    return electricityDemandIncrease_pct;
	}
	
	public double getLargeScalePV_ha() {
	    return largeScalePV_ha;
	}
	
	public double getLargeScaleWind_MW() {
	    return largeScaleWind_MW;
	}

	public double getAverageNeighbourhoodBatterySize_kWh() {
	    return averageNeighbourhoodBatterySize_kWh;
	}
	
	public boolean getCb_gridCurtailmentActive() {
	    return cb_gridCurtailmentActive;
	}

	// Heating
	public double getHousesWithGasBurners_pct() {
	    return housesWithGasBurners_pct;
	}

	public double getHousesWithHybridHeatpump_pct() {
	    return housesWithHybridHeatpump_pct;
	}

	public double getHousesWithElectricHeatpump_pct() {
	    return housesWithElectricHeatpump_pct;
	}

	public boolean getCb_householdHTDistrictHeatingActive() {
	    return cb_householdHTDistrictHeatingActive;
	}

	public boolean getCb_householdLTDistrictHeatingActive() {
	    return cb_householdLTDistrictHeatingActive;
	}

	public double getHousesWithAirco_pct() {
	    return housesWithAirco_pct;
	}

	public double getHousesWithImprovedInsulation_pct() {
	    return housesWithImprovedInsulation_pct;
	}

	public double getNbHousesWithPT_pct() {
	    return nbHousesWithPT_pct;
	}

	// Mobility
	public double getPrivateEVs_pct() {
	    return privateEVs_pct;
	}

	public double getPrivateEVsThatSupportV2G_pct() {
	    return privateEVsThatSupportV2G_pct;
	}

	public String getSelectedChargingAttitudeStringPrivateEVs() {
	    return selectedChargingAttitudeStringPrivateEVs;
	}

	public boolean getV2GActivePrivateEVs() {
	    return V2GActivePrivateEVs;
	}

	public double getActivePublicChargers_pct() {
	    return activePublicChargers_pct;
	}

	public double getChargersV1G_pct() {
	    return chargersV1G_pct;
	}

	public double getChargersV2G_pct() {
	    return chargersV2G_pct;
	}

	public String getSelectedChargingAttitudeStringChargers() {
	    return selectedChargingAttitudeStringChargers;
	}

	public boolean getV2GActiveChargers() {
	    return V2GActiveChargers;
	}
	
} 
