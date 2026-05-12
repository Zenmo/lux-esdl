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
 * J_Address
 */	
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,    // ✅ only public fields are serialized
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")

public class J_Address{

	private String streetName;
	private Integer houseNumber;
	private String houseLetter;
	private String houseAddition;
	private String postalcode;
	private String city;
	
    /**
     * Default constructor
     */
    public J_Address() {
    }
    
    public J_Address(String streetName, Integer houseNumber, String houseLetter, String houseAddition, String postalcode, String city) {
    	setStreetName(streetName);
    	setHouseNumber(houseNumber);
    	setHouseLetter(houseLetter);
    	setHouseAddition(houseAddition);
    	setPostalcode(postalcode);
    	setCity(city);
    }
    
    //Get formated address
    public String getAddress() {
    	StringBuilder sb = new StringBuilder();
    	
    	if ( this.streetName != null ) {
    		sb.append(this.streetName);
    	}
    	else {
    		sb.append("Onbekend adres");
    		return sb.toString();
    	}
    	if(this.houseNumber != null) {
	    	sb.append(" ");
	    	sb.append(this.houseNumber);
			if ( this.houseLetter != null ) {
		    	sb.append(" ");
		    	sb.append(this.houseLetter);
		    }
			if ( this.houseAddition != null ) {
		    	sb.append(" ");
		    	sb.append(this.houseAddition);
		    }
    	}
		if ( this.postalcode != null || this.city != null) {
			sb.append(",");
		}
		if ( this.postalcode != null ){
			sb.append(" ");
			sb.append(this.postalcode);
		}
		if ( this.city != null ){
			sb.append(" ");
			sb.append(this.city);
		}
		
		return sb.toString();
    }
    
    
    //Setters
    public void setStreetName( String streetName ) { 
    	if (isNotEmptyString(streetName)) {
    	    this.streetName = getFormattedName(streetName);
    	}
    	else {
    		this.streetName = null;
    	}
	}
	public void setHouseNumber( Integer houseNumber ) { 
        this.houseNumber = houseNumber;
	}
	public void setHouseLetter( String houseLetter ) { 
    	if(isNotEmptyString(houseLetter)) {
    		this.houseLetter = houseLetter;
    	}
    	else {
    		this.houseLetter = null;
    	}
	}
	public void setHouseAddition( String houseAddition ) { 
    	if(isNotEmptyString(houseAddition)) {
    		this.houseAddition = houseAddition;
    	}
    	else {
    		this.houseAddition = null;
    	}
	}
	public void setPostalcode( String postalcode ) { 
    	if(isNotEmptyString(postalcode)) {
    		this.postalcode = postalcode.toUpperCase().replaceAll("\\s","");
    	}
    	else {
    		this.postalcode = null;
    	}
	}
	public void setCity( String city ) {
		if(isNotEmptyString(city)) {
			this.city = getFormattedName(city);
		}
		else {
			this.city = null;
		}
	}
	
	
	//Getters
	public String getStreetName() { 
        return this.streetName;
	}
	public Integer getHouseNumber() {
	     return this.houseNumber;   	
	}
	public String getHouseLetter() {
        return this.houseLetter;
	}
	public String getHouseAddition() {
        return this.houseAddition;
	}
	public String getPostalcode() {
        return this.postalcode;
	}
	public String getCity() {
        return this.city;
	}
	
	
	
	//Support function for (Street/City) names to remove double white spaces and make every thing lower space, except the first letter of every word 
	private String getFormattedName(String name) {
		String[] words = name.trim().toLowerCase().split("\\s+");
	    StringBuilder sb = new StringBuilder();
	
	    for (String word : words) {
	        sb.append(Character.toUpperCase(word.charAt(0)))
	          .append(word.substring(1))
	          .append(" ");
	    }
	
	    return sb.toString().trim();
	}
	
	//Check used to see if address (String) item is filled in/usefull
	private boolean isNotEmptyString(String str) {
        // Return true if str is not null, empty and doesnt only contain spaces
	    return str != null && !str.trim().isEmpty();
	}
	
	
	@Override
	public String toString() {
		return "J_Address(" + getAddress() + ")";
	}
} 
