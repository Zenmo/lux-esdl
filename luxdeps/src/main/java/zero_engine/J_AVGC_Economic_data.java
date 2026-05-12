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
 * J_AVGC_Economic_data
 */	
public class J_AVGC_Economic_data {

	//Energy costs
	private Map<OL_EnergyCarriers, Double> map_avgCostOfEnergyCarrier_eurpkWh;
	private Map<OL_EnergyCarriers, Double> map_energyTaxesECImport_eurpkWh;
	private Map<OL_EnergyCarriers, Map<OL_EnergyTaxesBracket, Double>> map_bracketDependentEnergyTaxesECImport_eurpkWh;
	private double reductionInEnergyTaxes_eurpyr;
	private double VAT_energy_fr;

	
	//CAPEX & OPEX
	private Map<OL_EnergyAssetType, Double> map_avgAssetBaseCAPEX_eur;
	private Map<OL_EnergyAssetType, Double> map_avgAssetSizeDependentCAPEX_eurpkW;
	private Map<OL_EnergyAssetType, Double> map_avgAssetBaseOPEX_eurpyr;
	private Map<OL_EnergyAssetType, Double> map_avgAssetSizeDependentOPEX_eurpkWpyr;
	private Map<OL_EnergyAssetType, Double> map_avgAssetLifeTime_yr;

	private double VAT_CAPEXAndOPEX_fr;
	
	//Connection costs
	private I_GridOperatorTariffs gridOperatorTariffs;
	
    /**
     * Default constructor
     */
    public J_AVGC_Economic_data() {
    }
    
    ////Setters
    
    //Energy costs
    public void setMap_avgCostOfEnergyCarrier_eurpkWh(Map<OL_EnergyCarriers, Double> map_avgCostOfEnergyCarrier_eurpkWh) {
        this.map_avgCostOfEnergyCarrier_eurpkWh = map_avgCostOfEnergyCarrier_eurpkWh;
    }
    public void setMap_energyTaxesECImport_eurpkWh(Map<OL_EnergyCarriers, Double> map_energyTaxesECImport_eurpkWh) {
        this.map_energyTaxesECImport_eurpkWh = map_energyTaxesECImport_eurpkWh;
    }
    public void setMap_bracketDependentEnergyTaxesECImport_eurpkWh(Map<OL_EnergyCarriers, Map<OL_EnergyTaxesBracket, Double>> map_bracketDependentEnergyTaxesECImport_eurpkWh) {
        this.map_bracketDependentEnergyTaxesECImport_eurpkWh = map_bracketDependentEnergyTaxesECImport_eurpkWh;
    }
    public void setReductionInEnergyTaxes_eurpyr(double p_reductionInEnergyTaxes_eurpyr) {
        this.reductionInEnergyTaxes_eurpyr = p_reductionInEnergyTaxes_eurpyr;
    }
    public void setVAT_energy_fr(double VAT_energy_fr) {
        this.VAT_energy_fr = VAT_energy_fr;
    }

    // CAPEX & OPEX
    public void setMap_avgAssetBaseCAPEX_eur(Map<OL_EnergyAssetType, Double> map_avgAssetBaseCAPEX_eur) {
        this.map_avgAssetBaseCAPEX_eur = map_avgAssetBaseCAPEX_eur;
    }
    public void setMap_avgAssetSizeDependentCAPEX_eurpkW(Map<OL_EnergyAssetType, Double> map_avgAssetSizeDependentCAPEX_eurpkW) {
        this.map_avgAssetSizeDependentCAPEX_eurpkW = map_avgAssetSizeDependentCAPEX_eurpkW;
    }
    public void setMap_avgAssetBaseOPEX_eurpyr(Map<OL_EnergyAssetType, Double> map_avgAssetBaseOPEX_eurpyr) {
        this.map_avgAssetBaseOPEX_eurpyr = map_avgAssetBaseOPEX_eurpyr;
    }
    public void setMap_avgAssetSizeDependentOPEX_eurpkWpyr(Map<OL_EnergyAssetType, Double> map_avgAssetSizeDependentOPEX_eurpkWpyr) {
        this.map_avgAssetSizeDependentOPEX_eurpkWpyr = map_avgAssetSizeDependentOPEX_eurpkWpyr;
    }
    public void setMap_avgAssetLifeTime_yr(Map<OL_EnergyAssetType, Double> map_avgAssetLifeTime_yr) {
        this.map_avgAssetLifeTime_yr = map_avgAssetLifeTime_yr;
    }
    public void setVAT_CAPEXAndOPEX_fr(double VAT_CAPEXAndOPEX_fr) {
        this.VAT_CAPEXAndOPEX_fr = VAT_CAPEXAndOPEX_fr;
    }

    //Connection costs
    public void setGridOperatorTariffs(I_GridOperatorTariffs gridOperatorTariffs) {
        this.gridOperatorTariffs = gridOperatorTariffs;
    }
    
    
    
    ////Getters
    
    //Energy costs
    public double getAvgCostOfEnergyCarrier_eurpkWh(OL_EnergyCarriers EC) {
        return map_avgCostOfEnergyCarrier_eurpkWh.get(EC);
    }
    public double getEnergyTaxesECImport_eurpkWh(OL_EnergyCarriers EC, double yearlyECImport_kWh) { // Excluding VAT!
    	double energyTaxes_eurpkWh = 0;
    	if(map_bracketDependentEnergyTaxesECImport_eurpkWh.get(EC) != null) {
    		if(EC == OL_EnergyCarriers.ELECTRICITY) {
    			return map_bracketDependentEnergyTaxesECImport_eurpkWh.get(EC).get(getEnergyTaxesBracket_Electricity(yearlyECImport_kWh));
    		}
    		else if(EC == OL_EnergyCarriers.METHANE) {
    			return map_bracketDependentEnergyTaxesECImport_eurpkWh.get(EC).get(getEnergyTaxesBracket_Methane(yearlyECImport_kWh));
    		}
    		else {
    			throw new RuntimeException("EC found that has bracketDependendEnergyTaxes data, but no specific getter for it.");
    		}
    	}
    	else {
    		return map_energyTaxesECImport_eurpkWh.get(EC);
    	}
    }
    public double getReductionInEnergyTaxes_eurpyr() {
        return reductionInEnergyTaxes_eurpyr;
    }
    public double getVAT_energy_fr() {
        return VAT_energy_fr;
    }
    
    
    //CAPEX & OPEX
    public double getAvgAssetBaseCAPEX_eur(OL_EnergyAssetType assetType) {
        return map_avgAssetBaseCAPEX_eur.get(assetType);
    }
    public double getAvgAssetSizeDependentCAPEX_eurpkW(OL_EnergyAssetType assetType) {
        return map_avgAssetSizeDependentCAPEX_eurpkW.get(assetType);
    }
    public double getAvgAssetBaseOPEX_eurpyr(OL_EnergyAssetType assetType) {
        return map_avgAssetBaseOPEX_eurpyr.get(assetType);
    }
    public double getAvgAssetSizeDependentOPEX_eurpkWpyr(OL_EnergyAssetType assetType) {
        return map_avgAssetSizeDependentOPEX_eurpkWpyr.get(assetType);
    }
    public double getAvgAssetLifeTime_yr(OL_EnergyAssetType assetType) {
        return map_avgAssetLifeTime_yr.get(assetType);
    }
    public double getVAT_CAPEXAndOPEX_fr() {
        return VAT_CAPEXAndOPEX_fr;
    }
    
    
    //Grid operator tarrifs
    public I_GridOperatorTariffs getGridOperatorTariffs() {
        return gridOperatorTariffs;
    }
    
    
    ////Support functions
    //Energy taxes bracket getters
    public OL_EnergyTaxesBracket getEnergyTaxesBracket_Electricity(double yearlyElectricityConsumption_kWh) { // Source: https://www.greenchoice.nl/zakelijk/wet-overheid/overheidsheffingen/
    	if(yearlyElectricityConsumption_kWh < 2901) {return OL_EnergyTaxesBracket.BRACKET_1;}
    	else if(yearlyElectricityConsumption_kWh < 10_001) {return OL_EnergyTaxesBracket.BRACKET_2;}
    	else if(yearlyElectricityConsumption_kWh < 50_001) {return OL_EnergyTaxesBracket.BRACKET_3;}
    	else if(yearlyElectricityConsumption_kWh < 10_000_001) {return OL_EnergyTaxesBracket.BRACKET_4;}
    	else {return OL_EnergyTaxesBracket.BRACKET_5;}
    }
    public OL_EnergyTaxesBracket getEnergyTaxesBracket_Methane(double yearlyMethaneConsumption_kWh) { // Source: https://www.greenchoice.nl/zakelijk/wet-overheid/overheidsheffingen/
    	if(yearlyMethaneConsumption_kWh < 1_001) {return OL_EnergyTaxesBracket.BRACKET_1;}
    	else if(yearlyMethaneConsumption_kWh < 170_001) {return OL_EnergyTaxesBracket.BRACKET_2;}
    	else if(yearlyMethaneConsumption_kWh < 1_000_001) {return OL_EnergyTaxesBracket.BRACKET_3;}
    	else if(yearlyMethaneConsumption_kWh < 10_000_001) {return OL_EnergyTaxesBracket.BRACKET_4;}
    	else {return OL_EnergyTaxesBracket.BRACKET_5;}   	
    }
} 
