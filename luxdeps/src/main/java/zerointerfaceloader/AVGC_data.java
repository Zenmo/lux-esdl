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

public class AVGC_data extends Agent
{
  // Parameters

  /**
   * https://www.enexis.nl/aansluitingen/welke-aansluiting-heb-ik-nodig<br>
   * 3*25 A --> 3*25*230 = 17.25 kW
   */
  public 
double  p_avgHouseConnectionCapacity_kW;

  /**
   * Returns default value for parameter <code>p_avgHouseConnectionCapacity_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgHouseConnectionCapacity_kW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
17.25 
;
  }

  public void set_p_avgHouseConnectionCapacity_kW( double value ) {
    if (value == this.p_avgHouseConnectionCapacity_kW) {
      return;
    }
    double _oldValue_xjal = this.p_avgHouseConnectionCapacity_kW;
    this.p_avgHouseConnectionCapacity_kW = value;
    onChange_p_avgHouseConnectionCapacity_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHouseConnectionCapacity_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHouseConnectionCapacity_kW()</code> method instead.
   */
  protected void onChange_p_avgHouseConnectionCapacity_kW() {
    onChange_p_avgHouseConnectionCapacity_kW_xjal( p_avgHouseConnectionCapacity_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHouseConnectionCapacity_kW_xjal( double oldValue ) {  
  }


  public 
OL_GridConnectionHeatingType  p_avgHouseHeatingMethod;

  /**
   * Returns default value for parameter <code>p_avgHouseHeatingMethod</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_GridConnectionHeatingType _p_avgHouseHeatingMethod_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
OL_GridConnectionHeatingType.GAS_BURNER 
;
  }

  public void set_p_avgHouseHeatingMethod( OL_GridConnectionHeatingType value ) {
    if (value == this.p_avgHouseHeatingMethod) {
      return;
    }
    OL_GridConnectionHeatingType _oldValue_xjal = this.p_avgHouseHeatingMethod;
    this.p_avgHouseHeatingMethod = value;
    onChange_p_avgHouseHeatingMethod_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHouseHeatingMethod.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHouseHeatingMethod()</code> method instead.
   */
  protected void onChange_p_avgHouseHeatingMethod() {
    onChange_p_avgHouseHeatingMethod_xjal( p_avgHouseHeatingMethod );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHouseHeatingMethod_xjal( OL_GridConnectionHeatingType oldValue ) {  
  }


  /**
   * https://www.enexis.nl/aansluitingen/welke-aansluiting-heb-ik-nodig<br>
   * -> 17.25 -> set to 17, to prevent slider errors (stepsize cant be double, otherwise to small for user experience)<br>
   * <br>
   * --> 17.25 is way to small -> 3x80 is taken : 55 kW
   */
  public 
double  p_avgUtilityConnectionCapacity_kW;

  /**
   * Returns default value for parameter <code>p_avgUtilityConnectionCapacity_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgUtilityConnectionCapacity_kW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
55 
;
  }

  public void set_p_avgUtilityConnectionCapacity_kW( double value ) {
    if (value == this.p_avgUtilityConnectionCapacity_kW) {
      return;
    }
    double _oldValue_xjal = this.p_avgUtilityConnectionCapacity_kW;
    this.p_avgUtilityConnectionCapacity_kW = value;
    onChange_p_avgUtilityConnectionCapacity_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgUtilityConnectionCapacity_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgUtilityConnectionCapacity_kW()</code> method instead.
   */
  protected void onChange_p_avgUtilityConnectionCapacity_kW() {
    onChange_p_avgUtilityConnectionCapacity_kW_xjal( p_avgUtilityConnectionCapacity_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgUtilityConnectionCapacity_kW_xjal( double oldValue ) {  
  }


  public 
OL_GridConnectionHeatingType  p_avgUtilityHeatingMethod;

  /**
   * Returns default value for parameter <code>p_avgUtilityHeatingMethod</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_GridConnectionHeatingType _p_avgUtilityHeatingMethod_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
OL_GridConnectionHeatingType.GAS_BURNER 
;
  }

  public void set_p_avgUtilityHeatingMethod( OL_GridConnectionHeatingType value ) {
    if (value == this.p_avgUtilityHeatingMethod) {
      return;
    }
    OL_GridConnectionHeatingType _oldValue_xjal = this.p_avgUtilityHeatingMethod;
    this.p_avgUtilityHeatingMethod = value;
    onChange_p_avgUtilityHeatingMethod_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgUtilityHeatingMethod.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgUtilityHeatingMethod()</code> method instead.
   */
  protected void onChange_p_avgUtilityHeatingMethod() {
    onChange_p_avgUtilityHeatingMethod_xjal( p_avgUtilityHeatingMethod );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgUtilityHeatingMethod_xjal( OL_GridConnectionHeatingType oldValue ) {  
  }


  /**
   * - https://www.milieucentraal.nl/energie-besparen/inzicht-in-je-energierekening/gemiddeld-energieverbruik/<br>
   * - https://www.overstappen.nl/energie/gemiddeld-energieverbruik/ <br>
   * --> 2479 kWh/yr is the average of NL<br>
   * --> Overwrite if numbers are available in the project selection agent
   */
  public 
double  p_avgHouseElectricityConsumption_kWh_yr;

  /**
   * Returns default value for parameter <code>p_avgHouseElectricityConsumption_kWh_yr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgHouseElectricityConsumption_kWh_yr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
2479 
;
  }

  public void set_p_avgHouseElectricityConsumption_kWh_yr( double value ) {
    if (value == this.p_avgHouseElectricityConsumption_kWh_yr) {
      return;
    }
    double _oldValue_xjal = this.p_avgHouseElectricityConsumption_kWh_yr;
    this.p_avgHouseElectricityConsumption_kWh_yr = value;
    onChange_p_avgHouseElectricityConsumption_kWh_yr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHouseElectricityConsumption_kWh_yr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHouseElectricityConsumption_kWh_yr()</code> method instead.
   */
  protected void onChange_p_avgHouseElectricityConsumption_kWh_yr() {
    onChange_p_avgHouseElectricityConsumption_kWh_yr_xjal( p_avgHouseElectricityConsumption_kWh_yr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHouseElectricityConsumption_kWh_yr_xjal( double oldValue ) {  
  }


  /**
   * - https://www.overstappen.nl/energie/gemiddeld-energieverbruik/<br>
   * - https://www.milieucentraal.nl/energie-besparen/inzicht-in-je-energierekening/gemiddeld-energieverbruik/<br>
   *  --> 1169 m3 is the average of NL<br>
   * --> Overwrite if numbers are available in the project selection agent
   */
  public 
double  p_avgHouseGasConsumption_m3_yr;

  /**
   * Returns default value for parameter <code>p_avgHouseGasConsumption_m3_yr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgHouseGasConsumption_m3_yr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1169 
;
  }

  public void set_p_avgHouseGasConsumption_m3_yr( double value ) {
    if (value == this.p_avgHouseGasConsumption_m3_yr) {
      return;
    }
    double _oldValue_xjal = this.p_avgHouseGasConsumption_m3_yr;
    this.p_avgHouseGasConsumption_m3_yr = value;
    onChange_p_avgHouseGasConsumption_m3_yr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHouseGasConsumption_m3_yr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHouseGasConsumption_m3_yr()</code> method instead.
   */
  protected void onChange_p_avgHouseGasConsumption_m3_yr() {
    onChange_p_avgHouseGasConsumption_m3_yr_xjal( p_avgHouseGasConsumption_m3_yr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHouseGasConsumption_m3_yr_xjal( double oldValue ) {  
  }


  /**
   * share of EVs in the netherlands. --> 5% (feb 2024).<br>
   * <br>
   * https://www.rvo.nl/onderwerpen/elektrisch-vervoer/stand-van-zaken 
   */
  public 
double  p_shareOfElectricVehicleOwnership;

  /**
   * Returns default value for parameter <code>p_shareOfElectricVehicleOwnership</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_shareOfElectricVehicleOwnership_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.05 
;
  }

  public void set_p_shareOfElectricVehicleOwnership( double value ) {
    if (value == this.p_shareOfElectricVehicleOwnership) {
      return;
    }
    double _oldValue_xjal = this.p_shareOfElectricVehicleOwnership;
    this.p_shareOfElectricVehicleOwnership = value;
    onChange_p_shareOfElectricVehicleOwnership_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_shareOfElectricVehicleOwnership.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_shareOfElectricVehicleOwnership()</code> method instead.
   */
  protected void onChange_p_shareOfElectricVehicleOwnership() {
    onChange_p_shareOfElectricVehicleOwnership_xjal( p_shareOfElectricVehicleOwnership );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_shareOfElectricVehicleOwnership_xjal( double oldValue ) {  
  }


  /**
   * How many houses have installed PV in The Netherlands: 25% (end of 2022)<br>
   * https://solarmagazine.nl/nieuws-zonne-energie/i34591/de-harde-cijfers-drenthe-verstevigt-koppositie-38-procent-woningen-heeft-zonnepanelen
   */
  public 
double  p_ratioHouseInstalledPV;

  /**
   * Returns default value for parameter <code>p_ratioHouseInstalledPV</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_ratioHouseInstalledPV_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.25 
;
  }

  public void set_p_ratioHouseInstalledPV( double value ) {
    if (value == this.p_ratioHouseInstalledPV) {
      return;
    }
    double _oldValue_xjal = this.p_ratioHouseInstalledPV;
    this.p_ratioHouseInstalledPV = value;
    onChange_p_ratioHouseInstalledPV_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_ratioHouseInstalledPV.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_ratioHouseInstalledPV()</code> method instead.
   */
  protected void onChange_p_ratioHouseInstalledPV() {
    onChange_p_ratioHouseInstalledPV_xjal( p_ratioHouseInstalledPV );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_ratioHouseInstalledPV_xjal( double oldValue ) {  
  }


  /**
   * volgens gegevens van het CBS (Centraal Bureau voor de Statistiek) en RVO (Rijksdienst voor Ondernemend Nederland), was het gemiddelde geïnstalleerde piekvermogen van residentiële zonnepanelen in Nederland in 2020 ongeveer 4 kilowatt piek (kWp) per huishouden. --> 4kWp
   */
  public 
double  p_avgHousePVInstallationPower_kWp;

  /**
   * Returns default value for parameter <code>p_avgHousePVInstallationPower_kWp</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgHousePVInstallationPower_kWp_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
4 
;
  }

  public void set_p_avgHousePVInstallationPower_kWp( double value ) {
    if (value == this.p_avgHousePVInstallationPower_kWp) {
      return;
    }
    double _oldValue_xjal = this.p_avgHousePVInstallationPower_kWp;
    this.p_avgHousePVInstallationPower_kWp = value;
    onChange_p_avgHousePVInstallationPower_kWp_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHousePVInstallationPower_kWp.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHousePVInstallationPower_kWp()</code> method instead.
   */
  protected void onChange_p_avgHousePVInstallationPower_kWp() {
    onChange_p_avgHousePVInstallationPower_kWp_xjal( p_avgHousePVInstallationPower_kWp );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHousePVInstallationPower_kWp_xjal( double oldValue ) {  
  }


  /**
   * -https://www.eonenergy.com/electric-vehicle-charging/running-costs-and-benefits/battery-capacity-and-lifespan.html<br>
   * <br>
   * -https://www.edi.be/blog/laadstation-3/hoe-is-het-gesteld-met-de-autonomie-van-de-elektrische-auto-in-2023-12<br>
   * <br>
   * 40 kWh (kleine autos)<br>
   * <br>
   * 50-80 kWh (middel grote autos) <br>
   * <br>
   * 80-100 kWh (grote autos)<br>
   * <br>
   * Minimaal: 116 kWh minimum nodig, anders soms negatieve SOC.
   */
  public 
double  p_avgEVStorageCar_kWh;

  /**
   * Returns default value for parameter <code>p_avgEVStorageCar_kWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEVStorageCar_kWh_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
116 
;
  }

  public void set_p_avgEVStorageCar_kWh( double value ) {
    if (value == this.p_avgEVStorageCar_kWh) {
      return;
    }
    double _oldValue_xjal = this.p_avgEVStorageCar_kWh;
    this.p_avgEVStorageCar_kWh = value;
    onChange_p_avgEVStorageCar_kWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEVStorageCar_kWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEVStorageCar_kWh()</code> method instead.
   */
  protected void onChange_p_avgEVStorageCar_kWh() {
    onChange_p_avgEVStorageCar_kWh_xjal( p_avgEVStorageCar_kWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEVStorageCar_kWh_xjal( double oldValue ) {  
  }


  /**
   * Bron???
   */
  public 
double  p_avgEVMaxChargePowerCar_kW;

  /**
   * Returns default value for parameter <code>p_avgEVMaxChargePowerCar_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEVMaxChargePowerCar_kW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
11 
;
  }

  public void set_p_avgEVMaxChargePowerCar_kW( double value ) {
    if (value == this.p_avgEVMaxChargePowerCar_kW) {
      return;
    }
    double _oldValue_xjal = this.p_avgEVMaxChargePowerCar_kW;
    this.p_avgEVMaxChargePowerCar_kW = value;
    onChange_p_avgEVMaxChargePowerCar_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEVMaxChargePowerCar_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEVMaxChargePowerCar_kW()</code> method instead.
   */
  protected void onChange_p_avgEVMaxChargePowerCar_kW() {
    onChange_p_avgEVMaxChargePowerCar_kW_xjal( p_avgEVMaxChargePowerCar_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEVMaxChargePowerCar_kW_xjal( double oldValue ) {  
  }


  /**
   * ????
   */
  public 
double  p_avgEVStorageVan_kWh;

  /**
   * Returns default value for parameter <code>p_avgEVStorageVan_kWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEVStorageVan_kWh_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
200 
;
  }

  public void set_p_avgEVStorageVan_kWh( double value ) {
    if (value == this.p_avgEVStorageVan_kWh) {
      return;
    }
    double _oldValue_xjal = this.p_avgEVStorageVan_kWh;
    this.p_avgEVStorageVan_kWh = value;
    onChange_p_avgEVStorageVan_kWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEVStorageVan_kWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEVStorageVan_kWh()</code> method instead.
   */
  protected void onChange_p_avgEVStorageVan_kWh() {
    onChange_p_avgEVStorageVan_kWh_xjal( p_avgEVStorageVan_kWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEVStorageVan_kWh_xjal( double oldValue ) {  
  }


  /**
   * ??
   */
  public 
double  p_avgEVStorageTruck_kWh;

  /**
   * Returns default value for parameter <code>p_avgEVStorageTruck_kWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEVStorageTruck_kWh_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
500 
;
  }

  public void set_p_avgEVStorageTruck_kWh( double value ) {
    if (value == this.p_avgEVStorageTruck_kWh) {
      return;
    }
    double _oldValue_xjal = this.p_avgEVStorageTruck_kWh;
    this.p_avgEVStorageTruck_kWh = value;
    onChange_p_avgEVStorageTruck_kWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEVStorageTruck_kWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEVStorageTruck_kWh()</code> method instead.
   */
  protected void onChange_p_avgEVStorageTruck_kWh() {
    onChange_p_avgEVStorageTruck_kWh_xjal( p_avgEVStorageTruck_kWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEVStorageTruck_kWh_xjal( double oldValue ) {  
  }


  /**
   * Bron???
   */
  public 
double  p_avgEVMaxChargePowerVan_kW;

  /**
   * Returns default value for parameter <code>p_avgEVMaxChargePowerVan_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEVMaxChargePowerVan_kW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
11 
;
  }

  public void set_p_avgEVMaxChargePowerVan_kW( double value ) {
    if (value == this.p_avgEVMaxChargePowerVan_kW) {
      return;
    }
    double _oldValue_xjal = this.p_avgEVMaxChargePowerVan_kW;
    this.p_avgEVMaxChargePowerVan_kW = value;
    onChange_p_avgEVMaxChargePowerVan_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEVMaxChargePowerVan_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEVMaxChargePowerVan_kW()</code> method instead.
   */
  protected void onChange_p_avgEVMaxChargePowerVan_kW() {
    onChange_p_avgEVMaxChargePowerVan_kW_xjal( p_avgEVMaxChargePowerVan_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEVMaxChargePowerVan_kW_xjal( double oldValue ) {  
  }


  /**
   * Bron???
   */
  public 
double  p_avgEVMaxChargePowerTruck_kW;

  /**
   * Returns default value for parameter <code>p_avgEVMaxChargePowerTruck_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEVMaxChargePowerTruck_kW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
200 
;
  }

  public void set_p_avgEVMaxChargePowerTruck_kW( double value ) {
    if (value == this.p_avgEVMaxChargePowerTruck_kW) {
      return;
    }
    double _oldValue_xjal = this.p_avgEVMaxChargePowerTruck_kW;
    this.p_avgEVMaxChargePowerTruck_kW = value;
    onChange_p_avgEVMaxChargePowerTruck_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEVMaxChargePowerTruck_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEVMaxChargePowerTruck_kW()</code> method instead.
   */
  protected void onChange_p_avgEVMaxChargePowerTruck_kW() {
    onChange_p_avgEVMaxChargePowerTruck_kW_xjal( p_avgEVMaxChargePowerTruck_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEVMaxChargePowerTruck_kW_xjal( double oldValue ) {  
  }


  /**
   * https://ev-database.org/nl/auto/1555/Tesla-Model-3: 0.142 kWh/km<br>
   * <br>
   * https://www.vattenfall.nl/elektrische-auto/verbruik/<br>
   * <br>
   * --> Tesla model 3: 15.1 kWh per 100 km --> 0.151 kWh/km<br>
   * --> Kia niro: 17.1 kWh per 100 km --> 0.171 kWh/km<br>
   * --> taking 0.16 kWh/km as the average
   */
  public 
double  p_avgEVEnergyConsumptionCar_kWhpkm;

  /**
   * Returns default value for parameter <code>p_avgEVEnergyConsumptionCar_kWhpkm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEVEnergyConsumptionCar_kWhpkm_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.16 
;
  }

  public void set_p_avgEVEnergyConsumptionCar_kWhpkm( double value ) {
    if (value == this.p_avgEVEnergyConsumptionCar_kWhpkm) {
      return;
    }
    double _oldValue_xjal = this.p_avgEVEnergyConsumptionCar_kWhpkm;
    this.p_avgEVEnergyConsumptionCar_kWhpkm = value;
    onChange_p_avgEVEnergyConsumptionCar_kWhpkm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEVEnergyConsumptionCar_kWhpkm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEVEnergyConsumptionCar_kWhpkm()</code> method instead.
   */
  protected void onChange_p_avgEVEnergyConsumptionCar_kWhpkm() {
    onChange_p_avgEVEnergyConsumptionCar_kWhpkm_xjal( p_avgEVEnergyConsumptionCar_kWhpkm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEVEnergyConsumptionCar_kWhpkm_xjal( double oldValue ) {  
  }


  /**
   * praktijkverbruik van 26,9 kWh per 100 kilometer:<br>
   * https://www.debedrijfswagenadviseurs.nl/praktijkverbruik-elektrische-bedrijfswagen/ 
   */
  public 
double  p_avgEVEnergyConsumptionVan_kWhpkm;

  /**
   * Returns default value for parameter <code>p_avgEVEnergyConsumptionVan_kWhpkm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEVEnergyConsumptionVan_kWhpkm_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.269 
;
  }

  public void set_p_avgEVEnergyConsumptionVan_kWhpkm( double value ) {
    if (value == this.p_avgEVEnergyConsumptionVan_kWhpkm) {
      return;
    }
    double _oldValue_xjal = this.p_avgEVEnergyConsumptionVan_kWhpkm;
    this.p_avgEVEnergyConsumptionVan_kWhpkm = value;
    onChange_p_avgEVEnergyConsumptionVan_kWhpkm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEVEnergyConsumptionVan_kWhpkm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEVEnergyConsumptionVan_kWhpkm()</code> method instead.
   */
  protected void onChange_p_avgEVEnergyConsumptionVan_kWhpkm() {
    onChange_p_avgEVEnergyConsumptionVan_kWhpkm_xjal( p_avgEVEnergyConsumptionVan_kWhpkm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEVEnergyConsumptionVan_kWhpkm_xjal( double oldValue ) {  
  }


  /**
   * https://www.elektrischevrachtwagen.nl/post/hoe-ver-kan-een-elektrische-vrachtwagen-rijden, https://topsectorlogistiek.nl/wp-content/uploads/2024/06/20240126_Stappenplan-ZE-vrachtwagens.pdf<br>
   * 0.9 - 1.7 kWh/km<br>
   * --> pak gemiddelde: 1.3
   */
  public 
double  p_avgEVEnergyConsumptionTruck_kWhpkm;

  /**
   * Returns default value for parameter <code>p_avgEVEnergyConsumptionTruck_kWhpkm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEVEnergyConsumptionTruck_kWhpkm_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1.3 
;
  }

  public void set_p_avgEVEnergyConsumptionTruck_kWhpkm( double value ) {
    if (value == this.p_avgEVEnergyConsumptionTruck_kWhpkm) {
      return;
    }
    double _oldValue_xjal = this.p_avgEVEnergyConsumptionTruck_kWhpkm;
    this.p_avgEVEnergyConsumptionTruck_kWhpkm = value;
    onChange_p_avgEVEnergyConsumptionTruck_kWhpkm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEVEnergyConsumptionTruck_kWhpkm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEVEnergyConsumptionTruck_kWhpkm()</code> method instead.
   */
  protected void onChange_p_avgEVEnergyConsumptionTruck_kWhpkm() {
    onChange_p_avgEVEnergyConsumptionTruck_kWhpkm_xjal( p_avgEVEnergyConsumptionTruck_kWhpkm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEVEnergyConsumptionTruck_kWhpkm_xjal( double oldValue ) {  
  }


  /**
   * - https://www.greenchoice.nl/stroom-en-gas/bosgecompenseerd-gas/hoeveel-is-1-kuub-gas/<br>
   * - https://econvice.nl/op-gas-of-elektra-verwarmen-wat-is-gunstig/<br>
   * - https://www.joostdevree.nl/shtmls/calorische_waarde.shtml
   */
  public 
double  p_gas_kWhpm3;

  /**
   * Returns default value for parameter <code>p_gas_kWhpm3</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_gas_kWhpm3_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
9.77 
;
  }

  public void set_p_gas_kWhpm3( double value ) {
    if (value == this.p_gas_kWhpm3) {
      return;
    }
    double _oldValue_xjal = this.p_gas_kWhpm3;
    this.p_gas_kWhpm3 = value;
    onChange_p_gas_kWhpm3_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_gas_kWhpm3.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_gas_kWhpm3()</code> method instead.
   */
  protected void onChange_p_gas_kWhpm3() {
    onChange_p_gas_kWhpm3_xjal( p_gas_kWhpm3 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_gas_kWhpm3_xjal( double oldValue ) {  
  }


  /**
   * https://www.enapter.com/kb_post/what-is-the-energy-content-of-hydrogen <br>
   * <br>
   * LHV = 3.00 kWh/Nm3<br>
   * HHV = 3.54 kWh/Nm3
   */
  public 
double  p_hydrogenEnergyDensity_kWh_Nm3;

  /**
   * Returns default value for parameter <code>p_hydrogenEnergyDensity_kWh_Nm3</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_hydrogenEnergyDensity_kWh_Nm3_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
3.00 
;
  }

  public void set_p_hydrogenEnergyDensity_kWh_Nm3( double value ) {
    if (value == this.p_hydrogenEnergyDensity_kWh_Nm3) {
      return;
    }
    double _oldValue_xjal = this.p_hydrogenEnergyDensity_kWh_Nm3;
    this.p_hydrogenEnergyDensity_kWh_Nm3 = value;
    onChange_p_hydrogenEnergyDensity_kWh_Nm3_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_hydrogenEnergyDensity_kWh_Nm3.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_hydrogenEnergyDensity_kWh_Nm3()</code> method instead.
   */
  protected void onChange_p_hydrogenEnergyDensity_kWh_Nm3() {
    onChange_p_hydrogenEnergyDensity_kWh_Nm3_xjal( p_hydrogenEnergyDensity_kWh_Nm3 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_hydrogenEnergyDensity_kWh_Nm3_xjal( double oldValue ) {  
  }


  /**
   * https://keengas.com/gases/hydrogen/
   */
  public 
double  p_hydrogenDensity_kg_Nm3;

  /**
   * Returns default value for parameter <code>p_hydrogenDensity_kg_Nm3</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_hydrogenDensity_kg_Nm3_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.08988 
;
  }

  public void set_p_hydrogenDensity_kg_Nm3( double value ) {
    if (value == this.p_hydrogenDensity_kg_Nm3) {
      return;
    }
    double _oldValue_xjal = this.p_hydrogenDensity_kg_Nm3;
    this.p_hydrogenDensity_kg_Nm3 = value;
    onChange_p_hydrogenDensity_kg_Nm3_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_hydrogenDensity_kg_Nm3.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_hydrogenDensity_kg_Nm3()</code> method instead.
   */
  protected void onChange_p_hydrogenDensity_kg_Nm3() {
    onChange_p_hydrogenDensity_kg_Nm3_xjal( p_hydrogenDensity_kg_Nm3 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_hydrogenDensity_kg_Nm3_xjal( double oldValue ) {  
  }


  /**
   * http://www.uigi.com/o2_conv.html
   */
  public 
double  p_oxygenDensity_kg_Nm3;

  /**
   * Returns default value for parameter <code>p_oxygenDensity_kg_Nm3</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_oxygenDensity_kg_Nm3_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1.4291 
;
  }

  public void set_p_oxygenDensity_kg_Nm3( double value ) {
    if (value == this.p_oxygenDensity_kg_Nm3) {
      return;
    }
    double _oldValue_xjal = this.p_oxygenDensity_kg_Nm3;
    this.p_oxygenDensity_kg_Nm3 = value;
    onChange_p_oxygenDensity_kg_Nm3_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_oxygenDensity_kg_Nm3.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_oxygenDensity_kg_Nm3()</code> method instead.
   */
  protected void onChange_p_oxygenDensity_kg_Nm3() {
    onChange_p_oxygenDensity_kg_Nm3_xjal( p_oxygenDensity_kg_Nm3 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_oxygenDensity_kg_Nm3_xjal( double oldValue ) {  
  }


  /**
   * H20 = 2H + O<br>
   * MM H = 1.008 g/mol<br>
   * MM O = 16 g/mol<br>
   * --> 1.008*2/16 = 0.126.<br>
   * 0.126 g waterstof per g water conversie.<br>
   * 1-0.126 = 0.874 g zuurstof per gram water conversie.<br>
   * <br>
   * --> 1/0.126 =7.9365 gram zuurstof productie per gram waterstof productie.
   */
  public 
double  p_oxygenProduction_kgO2pkgH2;

  /**
   * Returns default value for parameter <code>p_oxygenProduction_kgO2pkgH2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_oxygenProduction_kgO2pkgH2_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
7.9365 
;
  }

  public void set_p_oxygenProduction_kgO2pkgH2( double value ) {
    if (value == this.p_oxygenProduction_kgO2pkgH2) {
      return;
    }
    double _oldValue_xjal = this.p_oxygenProduction_kgO2pkgH2;
    this.p_oxygenProduction_kgO2pkgH2 = value;
    onChange_p_oxygenProduction_kgO2pkgH2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_oxygenProduction_kgO2pkgH2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_oxygenProduction_kgO2pkgH2()</code> method instead.
   */
  protected void onChange_p_oxygenProduction_kgO2pkgH2() {
    onChange_p_oxygenProduction_kgO2pkgH2_xjal( p_oxygenProduction_kgO2pkgH2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_oxygenProduction_kgO2pkgH2_xjal( double oldValue ) {  
  }


  /**
   * https://www.cenex.co.uk/app/uploads/2021/05/Intro-to-hydrogen-1.pdf --> 33.6
   */
  public 
double  p_hydrogenSpecificEnergy_kWh_kg;

  /**
   * Returns default value for parameter <code>p_hydrogenSpecificEnergy_kWh_kg</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_hydrogenSpecificEnergy_kWh_kg_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
33.6 
;
  }

  public void set_p_hydrogenSpecificEnergy_kWh_kg( double value ) {
    if (value == this.p_hydrogenSpecificEnergy_kWh_kg) {
      return;
    }
    double _oldValue_xjal = this.p_hydrogenSpecificEnergy_kWh_kg;
    this.p_hydrogenSpecificEnergy_kWh_kg = value;
    onChange_p_hydrogenSpecificEnergy_kWh_kg_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_hydrogenSpecificEnergy_kWh_kg.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_hydrogenSpecificEnergy_kWh_kg()</code> method instead.
   */
  protected void onChange_p_hydrogenSpecificEnergy_kWh_kg() {
    onChange_p_hydrogenSpecificEnergy_kWh_kg_xjal( p_hydrogenSpecificEnergy_kWh_kg );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_hydrogenSpecificEnergy_kWh_kg_xjal( double oldValue ) {  
  }


  /**
   * https://www.joostdevree.nl/shtmls/calorische_waarde.shtml
   */
  public 
double  p_diesel_kWhpl;

  /**
   * Returns default value for parameter <code>p_diesel_kWhpl</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_diesel_kWhpl_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
10 
;
  }

  public void set_p_diesel_kWhpl( double value ) {
    if (value == this.p_diesel_kWhpl) {
      return;
    }
    double _oldValue_xjal = this.p_diesel_kWhpl;
    this.p_diesel_kWhpl = value;
    onChange_p_diesel_kWhpl_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_diesel_kWhpl.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_diesel_kWhpl()</code> method instead.
   */
  protected void onChange_p_diesel_kWhpl() {
    onChange_p_diesel_kWhpl_xjal( p_diesel_kWhpl );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_diesel_kWhpl_xjal( double oldValue ) {  
  }


  /**
   * https://www.unitedconsumers.com/blog/auto/zuinig-rijden.jsp
   */
  public 
double  p_avgDieselConsumptionCar_kmpl;

  /**
   * Returns default value for parameter <code>p_avgDieselConsumptionCar_kmpl</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgDieselConsumptionCar_kmpl_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
21 
;
  }

  public void set_p_avgDieselConsumptionCar_kmpl( double value ) {
    if (value == this.p_avgDieselConsumptionCar_kmpl) {
      return;
    }
    double _oldValue_xjal = this.p_avgDieselConsumptionCar_kmpl;
    this.p_avgDieselConsumptionCar_kmpl = value;
    onChange_p_avgDieselConsumptionCar_kmpl_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgDieselConsumptionCar_kmpl.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgDieselConsumptionCar_kmpl()</code> method instead.
   */
  protected void onChange_p_avgDieselConsumptionCar_kmpl() {
    onChange_p_avgDieselConsumptionCar_kmpl_xjal( p_avgDieselConsumptionCar_kmpl );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgDieselConsumptionCar_kmpl_xjal( double oldValue ) {  
  }


  /**
   * https://www.unitedconsumers.com/blog/auto/zuinig-rijden.jsp
   */
  public 
double  p_avgGasolineConsumptionCar_kmpl;

  /**
   * Returns default value for parameter <code>p_avgGasolineConsumptionCar_kmpl</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgGasolineConsumptionCar_kmpl_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
15 
;
  }

  public void set_p_avgGasolineConsumptionCar_kmpl( double value ) {
    if (value == this.p_avgGasolineConsumptionCar_kmpl) {
      return;
    }
    double _oldValue_xjal = this.p_avgGasolineConsumptionCar_kmpl;
    this.p_avgGasolineConsumptionCar_kmpl = value;
    onChange_p_avgGasolineConsumptionCar_kmpl_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgGasolineConsumptionCar_kmpl.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgGasolineConsumptionCar_kmpl()</code> method instead.
   */
  protected void onChange_p_avgGasolineConsumptionCar_kmpl() {
    onChange_p_avgGasolineConsumptionCar_kmpl_xjal( p_avgGasolineConsumptionCar_kmpl );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgGasolineConsumptionCar_kmpl_xjal( double oldValue ) {  
  }


  /**
   * https://www.joostdevree.nl/shtmls/calorische_waarde.shtml
   */
  public 
double  p_gasoline_kWhpl;

  /**
   * Returns default value for parameter <code>p_gasoline_kWhpl</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_gasoline_kWhpl_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
8.8 
;
  }

  public void set_p_gasoline_kWhpl( double value ) {
    if (value == this.p_gasoline_kWhpl) {
      return;
    }
    double _oldValue_xjal = this.p_gasoline_kWhpl;
    this.p_gasoline_kWhpl = value;
    onChange_p_gasoline_kWhpl_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_gasoline_kWhpl.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_gasoline_kWhpl()</code> method instead.
   */
  protected void onChange_p_gasoline_kWhpl() {
    onChange_p_gasoline_kWhpl_xjal( p_gasoline_kWhpl );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_gasoline_kWhpl_xjal( double oldValue ) {  
  }


  public 
double  p_avgDieselConsumptionCar_kWhpkm;

  /**
   * Returns default value for parameter <code>p_avgDieselConsumptionCar_kWhpkm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgDieselConsumptionCar_kWhpkm_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
p_diesel_kWhpl/p_avgDieselConsumptionCar_kmpl 
;
  }

  public void set_p_avgDieselConsumptionCar_kWhpkm( double value ) {
    if (value == this.p_avgDieselConsumptionCar_kWhpkm) {
      return;
    }
    double _oldValue_xjal = this.p_avgDieselConsumptionCar_kWhpkm;
    this.p_avgDieselConsumptionCar_kWhpkm = value;
    onChange_p_avgDieselConsumptionCar_kWhpkm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgDieselConsumptionCar_kWhpkm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgDieselConsumptionCar_kWhpkm()</code> method instead.
   */
  protected void onChange_p_avgDieselConsumptionCar_kWhpkm() {
    onChange_p_avgDieselConsumptionCar_kWhpkm_xjal( p_avgDieselConsumptionCar_kWhpkm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgDieselConsumptionCar_kWhpkm_xjal( double oldValue ) {  
  }


  public 
double  p_avgGasolineConsumptionCar_kWhpkm;

  /**
   * Returns default value for parameter <code>p_avgGasolineConsumptionCar_kWhpkm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgGasolineConsumptionCar_kWhpkm_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
p_gasoline_kWhpl/p_avgGasolineConsumptionCar_kmpl 
;
  }

  public void set_p_avgGasolineConsumptionCar_kWhpkm( double value ) {
    if (value == this.p_avgGasolineConsumptionCar_kWhpkm) {
      return;
    }
    double _oldValue_xjal = this.p_avgGasolineConsumptionCar_kWhpkm;
    this.p_avgGasolineConsumptionCar_kWhpkm = value;
    onChange_p_avgGasolineConsumptionCar_kWhpkm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgGasolineConsumptionCar_kWhpkm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgGasolineConsumptionCar_kWhpkm()</code> method instead.
   */
  protected void onChange_p_avgGasolineConsumptionCar_kWhpkm() {
    onChange_p_avgGasolineConsumptionCar_kWhpkm_xjal( p_avgGasolineConsumptionCar_kWhpkm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgGasolineConsumptionCar_kWhpkm_xjal( double oldValue ) {  
  }


  /**
   * https://www.webfleet.com/nl_nl/webfleet/blog/hoeveel-diesel-verbruikt-een-vrachtwagen-per-kilometer/<br>
   * <br>
   * 11 liter per 100 km = 9.1 km per liter.
   */
  public 
double  p_avgDieselConsumptionVan_kmpl;

  /**
   * Returns default value for parameter <code>p_avgDieselConsumptionVan_kmpl</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgDieselConsumptionVan_kmpl_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
9.1 
;
  }

  public void set_p_avgDieselConsumptionVan_kmpl( double value ) {
    if (value == this.p_avgDieselConsumptionVan_kmpl) {
      return;
    }
    double _oldValue_xjal = this.p_avgDieselConsumptionVan_kmpl;
    this.p_avgDieselConsumptionVan_kmpl = value;
    onChange_p_avgDieselConsumptionVan_kmpl_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgDieselConsumptionVan_kmpl.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgDieselConsumptionVan_kmpl()</code> method instead.
   */
  protected void onChange_p_avgDieselConsumptionVan_kmpl() {
    onChange_p_avgDieselConsumptionVan_kmpl_xjal( p_avgDieselConsumptionVan_kmpl );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgDieselConsumptionVan_kmpl_xjal( double oldValue ) {  
  }


  public 
double  p_avgDieselConsumptionVan_kWhpkm;

  /**
   * Returns default value for parameter <code>p_avgDieselConsumptionVan_kWhpkm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgDieselConsumptionVan_kWhpkm_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
p_diesel_kWhpl/p_avgDieselConsumptionVan_kmpl 
;
  }

  public void set_p_avgDieselConsumptionVan_kWhpkm( double value ) {
    if (value == this.p_avgDieselConsumptionVan_kWhpkm) {
      return;
    }
    double _oldValue_xjal = this.p_avgDieselConsumptionVan_kWhpkm;
    this.p_avgDieselConsumptionVan_kWhpkm = value;
    onChange_p_avgDieselConsumptionVan_kWhpkm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgDieselConsumptionVan_kWhpkm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgDieselConsumptionVan_kWhpkm()</code> method instead.
   */
  protected void onChange_p_avgDieselConsumptionVan_kWhpkm() {
    onChange_p_avgDieselConsumptionVan_kWhpkm_xjal( p_avgDieselConsumptionVan_kWhpkm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgDieselConsumptionVan_kWhpkm_xjal( double oldValue ) {  
  }


  /**
   * https://www.webfleet.com/nl_nl/webfleet/blog/hoeveel-diesel-verbruikt-een-vrachtwagen-per-kilometer/<br>
   * <br>
   * --> 25 - 30 - 40 liter per 100 km. = 4 - 3.33 - 2.5 km per l<br>
   * Heavely dependend on load, city/highway, etc.<br>
   * For now: Picking 3.33 km per l
   */
  public 
double  p_avgDieselConsumptionTruck_kmpl;

  /**
   * Returns default value for parameter <code>p_avgDieselConsumptionTruck_kmpl</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgDieselConsumptionTruck_kmpl_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
3.33 
;
  }

  public void set_p_avgDieselConsumptionTruck_kmpl( double value ) {
    if (value == this.p_avgDieselConsumptionTruck_kmpl) {
      return;
    }
    double _oldValue_xjal = this.p_avgDieselConsumptionTruck_kmpl;
    this.p_avgDieselConsumptionTruck_kmpl = value;
    onChange_p_avgDieselConsumptionTruck_kmpl_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgDieselConsumptionTruck_kmpl.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgDieselConsumptionTruck_kmpl()</code> method instead.
   */
  protected void onChange_p_avgDieselConsumptionTruck_kmpl() {
    onChange_p_avgDieselConsumptionTruck_kmpl_xjal( p_avgDieselConsumptionTruck_kmpl );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgDieselConsumptionTruck_kmpl_xjal( double oldValue ) {  
  }


  public 
double  p_avgDieselConsumptionTruck_kWhpkm;

  /**
   * Returns default value for parameter <code>p_avgDieselConsumptionTruck_kWhpkm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgDieselConsumptionTruck_kWhpkm_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
p_diesel_kWhpl/p_avgDieselConsumptionTruck_kmpl 
;
  }

  public void set_p_avgDieselConsumptionTruck_kWhpkm( double value ) {
    if (value == this.p_avgDieselConsumptionTruck_kWhpkm) {
      return;
    }
    double _oldValue_xjal = this.p_avgDieselConsumptionTruck_kWhpkm;
    this.p_avgDieselConsumptionTruck_kWhpkm = value;
    onChange_p_avgDieselConsumptionTruck_kWhpkm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgDieselConsumptionTruck_kWhpkm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgDieselConsumptionTruck_kWhpkm()</code> method instead.
   */
  protected void onChange_p_avgDieselConsumptionTruck_kWhpkm() {
    onChange_p_avgDieselConsumptionTruck_kWhpkm_xjal( p_avgDieselConsumptionTruck_kWhpkm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgDieselConsumptionTruck_kWhpkm_xjal( double oldValue ) {  
  }


  /**
   * https://www.vaillant.be/consumenten/ons-advies/blog/het-rendement-van-een-warmtepomp/<br>
   * <br>
   * Gemiddelde COP is 4.
   */
  public 
double  p_avgCOPHeatpump;

  /**
   * Returns default value for parameter <code>p_avgCOPHeatpump</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgCOPHeatpump_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
4 
;
  }

  public void set_p_avgCOPHeatpump( double value ) {
    if (value == this.p_avgCOPHeatpump) {
      return;
    }
    double _oldValue_xjal = this.p_avgCOPHeatpump;
    this.p_avgCOPHeatpump = value;
    onChange_p_avgCOPHeatpump_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgCOPHeatpump.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgCOPHeatpump()</code> method instead.
   */
  protected void onChange_p_avgCOPHeatpump() {
    onChange_p_avgCOPHeatpump_xjal( p_avgCOPHeatpump );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgCOPHeatpump_xjal( double oldValue ) {  
  }


  /**
   * FIND SOURCE!!! ????????
   */
  public 
double  p_avgUtilityPVPower_kWp;

  /**
   * Returns default value for parameter <code>p_avgUtilityPVPower_kWp</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgUtilityPVPower_kWp_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1 
;
  }

  public void set_p_avgUtilityPVPower_kWp( double value ) {
    if (value == this.p_avgUtilityPVPower_kWp) {
      return;
    }
    double _oldValue_xjal = this.p_avgUtilityPVPower_kWp;
    this.p_avgUtilityPVPower_kWp = value;
    onChange_p_avgUtilityPVPower_kWp_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgUtilityPVPower_kWp.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgUtilityPVPower_kWp()</code> method instead.
   */
  protected void onChange_p_avgUtilityPVPower_kWp() {
    onChange_p_avgUtilityPVPower_kWp_xjal( p_avgUtilityPVPower_kWp );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgUtilityPVPower_kWp_xjal( double oldValue ) {  
  }


  /**
   * Ratio of how many trucks are electric vs petroleumFuel.<br>
   * ???<br>
   * https://nos.nl/artikel/2483604-elektrische-vrachtwagens-blijven-achter-door-complexe-serie-aan-uitdagingen --> 'volgens cbs nog geen half procent.'
   */
  public 
double  p_ratioElectricTrucks;

  /**
   * Returns default value for parameter <code>p_ratioElectricTrucks</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_ratioElectricTrucks_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.005 
;
  }

  public void set_p_ratioElectricTrucks( double value ) {
    if (value == this.p_ratioElectricTrucks) {
      return;
    }
    double _oldValue_xjal = this.p_ratioElectricTrucks;
    this.p_ratioElectricTrucks = value;
    onChange_p_ratioElectricTrucks_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_ratioElectricTrucks.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_ratioElectricTrucks()</code> method instead.
   */
  protected void onChange_p_ratioElectricTrucks() {
    onChange_p_ratioElectricTrucks_xjal( p_ratioElectricTrucks );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_ratioElectricTrucks_xjal( double oldValue ) {  
  }


  /**
   * Source?? --> Should definatly be still the case in 2024
   */
  public 
OL_GridConnectionHeatingType  p_avgCompanyHeatingMethod;

  /**
   * Returns default value for parameter <code>p_avgCompanyHeatingMethod</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_GridConnectionHeatingType _p_avgCompanyHeatingMethod_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
OL_GridConnectionHeatingType.GAS_BURNER 
;
  }

  public void set_p_avgCompanyHeatingMethod( OL_GridConnectionHeatingType value ) {
    if (value == this.p_avgCompanyHeatingMethod) {
      return;
    }
    OL_GridConnectionHeatingType _oldValue_xjal = this.p_avgCompanyHeatingMethod;
    this.p_avgCompanyHeatingMethod = value;
    onChange_p_avgCompanyHeatingMethod_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgCompanyHeatingMethod.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgCompanyHeatingMethod()</code> method instead.
   */
  protected void onChange_p_avgCompanyHeatingMethod() {
    onChange_p_avgCompanyHeatingMethod_xjal( p_avgCompanyHeatingMethod );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgCompanyHeatingMethod_xjal( OL_GridConnectionHeatingType oldValue ) {  
  }


  /**
   * https://hallostroom.nl/zonnepanelen/opbrengst/per-m2/ --> 177 W/m2<br>
   * https://www.zonneplan.nl/kenniscentrum/zonnepanelen/vermogen --> 212 W/m2<br>
   * https://www.zonnepanelennoord.nl/vermogen-zonnepanelen/ --> 215 W/m2
   */
  public 
double  p_avgPVPower_kWpm2;

  /**
   * Returns default value for parameter <code>p_avgPVPower_kWpm2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgPVPower_kWpm2_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.2 
;
  }

  public void set_p_avgPVPower_kWpm2( double value ) {
    if (value == this.p_avgPVPower_kWpm2) {
      return;
    }
    double _oldValue_xjal = this.p_avgPVPower_kWpm2;
    this.p_avgPVPower_kWpm2 = value;
    onChange_p_avgPVPower_kWpm2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgPVPower_kWpm2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgPVPower_kWpm2()</code> method instead.
   */
  protected void onChange_p_avgPVPower_kWpm2() {
    onChange_p_avgPVPower_kWpm2_xjal( p_avgPVPower_kWpm2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgPVPower_kWpm2_xjal( double oldValue ) {  
  }


  /**
   * Average ratio of battery capacity over battery power.<br>
   * --> If battery capacity (in kWh) is twice the battery power (in kW) --> ratio = 2.
   */
  public 
double  p_avgRatioBatteryCapacity_v_Power;

  /**
   * Returns default value for parameter <code>p_avgRatioBatteryCapacity_v_Power</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgRatioBatteryCapacity_v_Power_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
2 
;
  }

  public void set_p_avgRatioBatteryCapacity_v_Power( double value ) {
    if (value == this.p_avgRatioBatteryCapacity_v_Power) {
      return;
    }
    double _oldValue_xjal = this.p_avgRatioBatteryCapacity_v_Power;
    this.p_avgRatioBatteryCapacity_v_Power = value;
    onChange_p_avgRatioBatteryCapacity_v_Power_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgRatioBatteryCapacity_v_Power.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgRatioBatteryCapacity_v_Power()</code> method instead.
   */
  protected void onChange_p_avgRatioBatteryCapacity_v_Power() {
    onChange_p_avgRatioBatteryCapacity_v_Power_xjal( p_avgRatioBatteryCapacity_v_Power );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgRatioBatteryCapacity_v_Power_xjal( double oldValue ) {  
  }


  /**
   * https://magnuscmd.com/hydrogen-fuel-cell-vehicles-a-threat-to-the-electric-car/<br>
   * <br>
   * --> avg: 29 kWh per 100 km --> 0.29 kWh/km
   */
  public 
double  p_avgHydrogenConsumptionCar_kWhpkm;

  /**
   * Returns default value for parameter <code>p_avgHydrogenConsumptionCar_kWhpkm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgHydrogenConsumptionCar_kWhpkm_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.29 
;
  }

  public void set_p_avgHydrogenConsumptionCar_kWhpkm( double value ) {
    if (value == this.p_avgHydrogenConsumptionCar_kWhpkm) {
      return;
    }
    double _oldValue_xjal = this.p_avgHydrogenConsumptionCar_kWhpkm;
    this.p_avgHydrogenConsumptionCar_kWhpkm = value;
    onChange_p_avgHydrogenConsumptionCar_kWhpkm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHydrogenConsumptionCar_kWhpkm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHydrogenConsumptionCar_kWhpkm()</code> method instead.
   */
  protected void onChange_p_avgHydrogenConsumptionCar_kWhpkm() {
    onChange_p_avgHydrogenConsumptionCar_kWhpkm_xjal( p_avgHydrogenConsumptionCar_kWhpkm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHydrogenConsumptionCar_kWhpkm_xjal( double oldValue ) {  
  }


  /**
   * https://www.huiskes-kokkeler.nl/bedrijfswagens/volkswagen-bedrijfswagens/modellen/crafter-hymotion-concept<br>
   * --> 1.4 kg Waterstof per 100 km = 0.014 kg/km<br>
   * -->  0.014 * 33.6 (p_hydrogenSpecificEnergy_kWh_kg = 0.47 kWh/kg
   */
  public 
double  p_avgHydrogenConsumptionVan_kWhpkm;

  /**
   * Returns default value for parameter <code>p_avgHydrogenConsumptionVan_kWhpkm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgHydrogenConsumptionVan_kWhpkm_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.47 
;
  }

  public void set_p_avgHydrogenConsumptionVan_kWhpkm( double value ) {
    if (value == this.p_avgHydrogenConsumptionVan_kWhpkm) {
      return;
    }
    double _oldValue_xjal = this.p_avgHydrogenConsumptionVan_kWhpkm;
    this.p_avgHydrogenConsumptionVan_kWhpkm = value;
    onChange_p_avgHydrogenConsumptionVan_kWhpkm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHydrogenConsumptionVan_kWhpkm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHydrogenConsumptionVan_kWhpkm()</code> method instead.
   */
  protected void onChange_p_avgHydrogenConsumptionVan_kWhpkm() {
    onChange_p_avgHydrogenConsumptionVan_kWhpkm_xjal( p_avgHydrogenConsumptionVan_kWhpkm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHydrogenConsumptionVan_kWhpkm_xjal( double oldValue ) {  
  }


  /**
   * https://transportenmilieu.nl/nieuwsarchief/item/hyundai-op-waterstof-voor-havi-zwitserland<br>
   * --> 6.6 kg Waterstof per 100 km = 0.066 kg/km<br>
   * --> 0.066 * 33.6 (p_hydrogenSpecificEnergy_kWh_kg = 2.22 kWh/kg
   */
  public 
double  p_avgHydrogenConsumptionTruck_kWhpkm;

  /**
   * Returns default value for parameter <code>p_avgHydrogenConsumptionTruck_kWhpkm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgHydrogenConsumptionTruck_kWhpkm_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
2.22 
;
  }

  public void set_p_avgHydrogenConsumptionTruck_kWhpkm( double value ) {
    if (value == this.p_avgHydrogenConsumptionTruck_kWhpkm) {
      return;
    }
    double _oldValue_xjal = this.p_avgHydrogenConsumptionTruck_kWhpkm;
    this.p_avgHydrogenConsumptionTruck_kWhpkm = value;
    onChange_p_avgHydrogenConsumptionTruck_kWhpkm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHydrogenConsumptionTruck_kWhpkm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHydrogenConsumptionTruck_kWhpkm()</code> method instead.
   */
  protected void onChange_p_avgHydrogenConsumptionTruck_kWhpkm() {
    onChange_p_avgHydrogenConsumptionTruck_kWhpkm_xjal( p_avgHydrogenConsumptionTruck_kWhpkm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHydrogenConsumptionTruck_kWhpkm_xjal( double oldValue ) {  
  }


  /**
   * value for the ratio of the avg Usable Roof Area For PV fr
   */
  public 
double  p_avgRatioRoofPotentialPV;

  /**
   * Returns default value for parameter <code>p_avgRatioRoofPotentialPV</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgRatioRoofPotentialPV_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.5 
;
  }

  public void set_p_avgRatioRoofPotentialPV( double value ) {
    if (value == this.p_avgRatioRoofPotentialPV) {
      return;
    }
    double _oldValue_xjal = this.p_avgRatioRoofPotentialPV;
    this.p_avgRatioRoofPotentialPV = value;
    onChange_p_avgRatioRoofPotentialPV_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgRatioRoofPotentialPV.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgRatioRoofPotentialPV()</code> method instead.
   */
  protected void onChange_p_avgRatioRoofPotentialPV() {
    onChange_p_avgRatioRoofPotentialPV_xjal( p_avgRatioRoofPotentialPV );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgRatioRoofPotentialPV_xjal( double oldValue ) {  
  }


  /**
   * Efficiency (eta_r) used to calculate the COP in the energy asset based on temperature differences. <br>
   * <br>
   * '0.5' comes from old code, no source found for it yet.
   */
  public 
double  p_avgEfficiencyHeatpump_fr;

  /**
   * Returns default value for parameter <code>p_avgEfficiencyHeatpump_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEfficiencyHeatpump_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.5 
;
  }

  public void set_p_avgEfficiencyHeatpump_fr( double value ) {
    if (value == this.p_avgEfficiencyHeatpump_fr) {
      return;
    }
    double _oldValue_xjal = this.p_avgEfficiencyHeatpump_fr;
    this.p_avgEfficiencyHeatpump_fr = value;
    onChange_p_avgEfficiencyHeatpump_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEfficiencyHeatpump_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEfficiencyHeatpump_fr()</code> method instead.
   */
  protected void onChange_p_avgEfficiencyHeatpump_fr() {
    onChange_p_avgEfficiencyHeatpump_fr_xjal( p_avgEfficiencyHeatpump_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEfficiencyHeatpump_fr_xjal( double oldValue ) {  
  }


  /**
   * https://www.milieucentraal.nl/energie-besparen/duurzaam-verwarmen-en-koelen/volledige-warmtepomp/?utm_source=chatgpt.com - max 45-55<br>
   * https://warmtepomp-panel.nl/afgiftesysteem.html?utm_source=chatgpt.com -> 35 graden afgifte bij -10 graden.<br>
   * <br>
   * -> Voor nu gemiddeld 40 genomen.
   */
  public 
double  p_avgOutputTemperatureElectricHeatpump_degC;

  /**
   * Returns default value for parameter <code>p_avgOutputTemperatureElectricHeatpump_degC</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgOutputTemperatureElectricHeatpump_degC_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
40 
;
  }

  public void set_p_avgOutputTemperatureElectricHeatpump_degC( double value ) {
    if (value == this.p_avgOutputTemperatureElectricHeatpump_degC) {
      return;
    }
    double _oldValue_xjal = this.p_avgOutputTemperatureElectricHeatpump_degC;
    this.p_avgOutputTemperatureElectricHeatpump_degC = value;
    onChange_p_avgOutputTemperatureElectricHeatpump_degC_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgOutputTemperatureElectricHeatpump_degC.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgOutputTemperatureElectricHeatpump_degC()</code> method instead.
   */
  protected void onChange_p_avgOutputTemperatureElectricHeatpump_degC() {
    onChange_p_avgOutputTemperatureElectricHeatpump_degC_xjal( p_avgOutputTemperatureElectricHeatpump_degC );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgOutputTemperatureElectricHeatpump_degC_xjal( double oldValue ) {  
  }


  /**
   * Average heating efficiency of a gas burner.<br>
   * https://www.mdpi.com/1999-4893/18/7/416 -> 100-104 % efficiency, based on gas energy density of 8.8 kWh/m3 (lower heating value), we use higher heating value: 9.77 -> 8.8*1.04/9.77 = 0.94
   */
  public 
double  p_avgEfficiencyGasBurner_fr;

  /**
   * Returns default value for parameter <code>p_avgEfficiencyGasBurner_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEfficiencyGasBurner_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.94 
;
  }

  public void set_p_avgEfficiencyGasBurner_fr( double value ) {
    if (value == this.p_avgEfficiencyGasBurner_fr) {
      return;
    }
    double _oldValue_xjal = this.p_avgEfficiencyGasBurner_fr;
    this.p_avgEfficiencyGasBurner_fr = value;
    onChange_p_avgEfficiencyGasBurner_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEfficiencyGasBurner_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEfficiencyGasBurner_fr()</code> method instead.
   */
  protected void onChange_p_avgEfficiencyGasBurner_fr() {
    onChange_p_avgEfficiencyGasBurner_fr_xjal( p_avgEfficiencyGasBurner_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEfficiencyGasBurner_fr_xjal( double oldValue ) {  
  }


  /**
   * Average output temperature of a gas burner unit in degC.<br>
   * <br>
   * --> Source?
   */
  public 
double  p_avgOutputTemperatureGasBurner_degC;

  /**
   * Returns default value for parameter <code>p_avgOutputTemperatureGasBurner_degC</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgOutputTemperatureGasBurner_degC_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
90 
;
  }

  public void set_p_avgOutputTemperatureGasBurner_degC( double value ) {
    if (value == this.p_avgOutputTemperatureGasBurner_degC) {
      return;
    }
    double _oldValue_xjal = this.p_avgOutputTemperatureGasBurner_degC;
    this.p_avgOutputTemperatureGasBurner_degC = value;
    onChange_p_avgOutputTemperatureGasBurner_degC_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgOutputTemperatureGasBurner_degC.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgOutputTemperatureGasBurner_degC()</code> method instead.
   */
  protected void onChange_p_avgOutputTemperatureGasBurner_degC() {
    onChange_p_avgOutputTemperatureGasBurner_degC_xjal( p_avgOutputTemperatureGasBurner_degC );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgOutputTemperatureGasBurner_degC_xjal( double oldValue ) {  
  }


  /**
   * Average heating efficiency of a hydrogen burner.<br>
   * <br>
   * - https://h2sciencecoalition.com/blog/hydrogen-for-heating-a-comparison-with-heat-pumps-part-1/<br>
   * <br>
   * - https://www.csrf.ac.uk/blog/hydrogen-for-heating/
   */
  public 
double  p_avgEfficiencyHydrogenBurner_fr;

  /**
   * Returns default value for parameter <code>p_avgEfficiencyHydrogenBurner_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEfficiencyHydrogenBurner_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.90 
;
  }

  public void set_p_avgEfficiencyHydrogenBurner_fr( double value ) {
    if (value == this.p_avgEfficiencyHydrogenBurner_fr) {
      return;
    }
    double _oldValue_xjal = this.p_avgEfficiencyHydrogenBurner_fr;
    this.p_avgEfficiencyHydrogenBurner_fr = value;
    onChange_p_avgEfficiencyHydrogenBurner_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEfficiencyHydrogenBurner_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEfficiencyHydrogenBurner_fr()</code> method instead.
   */
  protected void onChange_p_avgEfficiencyHydrogenBurner_fr() {
    onChange_p_avgEfficiencyHydrogenBurner_fr_xjal( p_avgEfficiencyHydrogenBurner_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEfficiencyHydrogenBurner_fr_xjal( double oldValue ) {  
  }


  /**
   * Average output temperature of a hydrogen burner unit in degC.<br>
   * <br>
   * --> Source?
   */
  public 
double  p_avgOutputTemperatureHydrogenBurner_degC;

  /**
   * Returns default value for parameter <code>p_avgOutputTemperatureHydrogenBurner_degC</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgOutputTemperatureHydrogenBurner_degC_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
90 
;
  }

  public void set_p_avgOutputTemperatureHydrogenBurner_degC( double value ) {
    if (value == this.p_avgOutputTemperatureHydrogenBurner_degC) {
      return;
    }
    double _oldValue_xjal = this.p_avgOutputTemperatureHydrogenBurner_degC;
    this.p_avgOutputTemperatureHydrogenBurner_degC = value;
    onChange_p_avgOutputTemperatureHydrogenBurner_degC_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgOutputTemperatureHydrogenBurner_degC.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgOutputTemperatureHydrogenBurner_degC()</code> method instead.
   */
  protected void onChange_p_avgOutputTemperatureHydrogenBurner_degC() {
    onChange_p_avgOutputTemperatureHydrogenBurner_degC_xjal( p_avgOutputTemperatureHydrogenBurner_degC );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgOutputTemperatureHydrogenBurner_degC_xjal( double oldValue ) {  
  }


  /**
   * When not using default charger profiles, this parameter is used to define how much J_EAEV should be created per charger socket. To simulate a charging need.
   */
  public 
int  p_defaultNrOfVehiclesPerChargerSocket;

  /**
   * Returns default value for parameter <code>p_defaultNrOfVehiclesPerChargerSocket</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _p_defaultNrOfVehiclesPerChargerSocket_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
2 
;
  }

  public void set_p_defaultNrOfVehiclesPerChargerSocket( int value ) {
    if (value == this.p_defaultNrOfVehiclesPerChargerSocket) {
      return;
    }
    int _oldValue_xjal = this.p_defaultNrOfVehiclesPerChargerSocket;
    this.p_defaultNrOfVehiclesPerChargerSocket = value;
    onChange_p_defaultNrOfVehiclesPerChargerSocket_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultNrOfVehiclesPerChargerSocket.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultNrOfVehiclesPerChargerSocket()</code> method instead.
   */
  protected void onChange_p_defaultNrOfVehiclesPerChargerSocket() {
    onChange_p_defaultNrOfVehiclesPerChargerSocket_xjal( p_defaultNrOfVehiclesPerChargerSocket );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultNrOfVehiclesPerChargerSocket_xjal( int oldValue ) {  
  }


  /**
   * https://www.cbs.nl/nl-nl/visualisaties/verkeer-en-vervoer/verkeer/verkeersprestaties-bestelautos -> 4 jaar oude bestlbussen gemiddeld 22.2 duizend km in een jaar.
   */
  public 
double  p_avgAnnualTravelDistanceVan_km;

  /**
   * Returns default value for parameter <code>p_avgAnnualTravelDistanceVan_km</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgAnnualTravelDistanceVan_km_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
22200 
;
  }

  public void set_p_avgAnnualTravelDistanceVan_km( double value ) {
    if (value == this.p_avgAnnualTravelDistanceVan_km) {
      return;
    }
    double _oldValue_xjal = this.p_avgAnnualTravelDistanceVan_km;
    this.p_avgAnnualTravelDistanceVan_km = value;
    onChange_p_avgAnnualTravelDistanceVan_km_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgAnnualTravelDistanceVan_km.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgAnnualTravelDistanceVan_km()</code> method instead.
   */
  protected void onChange_p_avgAnnualTravelDistanceVan_km() {
    onChange_p_avgAnnualTravelDistanceVan_km_xjal( p_avgAnnualTravelDistanceVan_km );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgAnnualTravelDistanceVan_km_xjal( double oldValue ) {  
  }


  /**
   * https://www.cbs.nl/nl-nl/visualisaties/verkeer-en-vervoer/verkeer/verkeersprestaties-personenautos
   */
  public 
double  p_avgAnnualTravelDistanceCompanyCar_km;

  /**
   * Returns default value for parameter <code>p_avgAnnualTravelDistanceCompanyCar_km</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgAnnualTravelDistanceCompanyCar_km_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
20500 
;
  }

  public void set_p_avgAnnualTravelDistanceCompanyCar_km( double value ) {
    if (value == this.p_avgAnnualTravelDistanceCompanyCar_km) {
      return;
    }
    double _oldValue_xjal = this.p_avgAnnualTravelDistanceCompanyCar_km;
    this.p_avgAnnualTravelDistanceCompanyCar_km = value;
    onChange_p_avgAnnualTravelDistanceCompanyCar_km_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgAnnualTravelDistanceCompanyCar_km.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgAnnualTravelDistanceCompanyCar_km()</code> method instead.
   */
  protected void onChange_p_avgAnnualTravelDistanceCompanyCar_km() {
    onChange_p_avgAnnualTravelDistanceCompanyCar_km_xjal( p_avgAnnualTravelDistanceCompanyCar_km );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgAnnualTravelDistanceCompanyCar_km_xjal( double oldValue ) {  
  }


  /**
   * https://www.cbs.nl/nl-nl/cijfers/detail/84651NED
   */
  public 
double  p_avgAnnualTravelDistanceTruck_km;

  /**
   * Returns default value for parameter <code>p_avgAnnualTravelDistanceTruck_km</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgAnnualTravelDistanceTruck_km_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
54505 
;
  }

  public void set_p_avgAnnualTravelDistanceTruck_km( double value ) {
    if (value == this.p_avgAnnualTravelDistanceTruck_km) {
      return;
    }
    double _oldValue_xjal = this.p_avgAnnualTravelDistanceTruck_km;
    this.p_avgAnnualTravelDistanceTruck_km = value;
    onChange_p_avgAnnualTravelDistanceTruck_km_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgAnnualTravelDistanceTruck_km.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgAnnualTravelDistanceTruck_km()</code> method instead.
   */
  protected void onChange_p_avgAnnualTravelDistanceTruck_km() {
    onChange_p_avgAnnualTravelDistanceTruck_km_xjal( p_avgAnnualTravelDistanceTruck_km );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgAnnualTravelDistanceTruck_km_xjal( double oldValue ) {  
  }


  /**
   * Parameter used to estimate the total solar production in a year in a function like:<br>
   * p_avgFullLoadHoursPV_hr * kWp_of_PV_panels = XXX kWh pv production in a year.
   */
  public 
double  p_avgFullLoadHoursPV_hr;

  /**
   * Returns default value for parameter <code>p_avgFullLoadHoursPV_hr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgFullLoadHoursPV_hr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
920 
;
  }

  public void set_p_avgFullLoadHoursPV_hr( double value ) {
    if (value == this.p_avgFullLoadHoursPV_hr) {
      return;
    }
    double _oldValue_xjal = this.p_avgFullLoadHoursPV_hr;
    this.p_avgFullLoadHoursPV_hr = value;
    onChange_p_avgFullLoadHoursPV_hr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgFullLoadHoursPV_hr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgFullLoadHoursPV_hr()</code> method instead.
   */
  protected void onChange_p_avgFullLoadHoursPV_hr() {
    onChange_p_avgFullLoadHoursPV_hr_xjal( p_avgFullLoadHoursPV_hr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgFullLoadHoursPV_hr_xjal( double oldValue ) {  
  }


  /**
   * https://www.odyssee-mure.eu/publications/efficiency-by-sector/services/offices-specific-energy-and-electricity-consumption.html<br>
   * <br>
   * --> 188 kWh/m2 for offices in NL
   */
  public 
double  p_avgCompanyElectricityConsumption_kWhpm2;

  /**
   * Returns default value for parameter <code>p_avgCompanyElectricityConsumption_kWhpm2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgCompanyElectricityConsumption_kWhpm2_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
188 
;
  }

  public void set_p_avgCompanyElectricityConsumption_kWhpm2( double value ) {
    if (value == this.p_avgCompanyElectricityConsumption_kWhpm2) {
      return;
    }
    double _oldValue_xjal = this.p_avgCompanyElectricityConsumption_kWhpm2;
    this.p_avgCompanyElectricityConsumption_kWhpm2 = value;
    onChange_p_avgCompanyElectricityConsumption_kWhpm2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgCompanyElectricityConsumption_kWhpm2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgCompanyElectricityConsumption_kWhpm2()</code> method instead.
   */
  protected void onChange_p_avgCompanyElectricityConsumption_kWhpm2() {
    onChange_p_avgCompanyElectricityConsumption_kWhpm2_xjal( p_avgCompanyElectricityConsumption_kWhpm2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgCompanyElectricityConsumption_kWhpm2_xjal( double oldValue ) {  
  }


  /**
   * https://publications.tno.nl/publication/34629408/3xJn98/e16056.pdf -> page 28<br>
   * <br>
   * 9 m3 p m2 for label A<br>
   * 12 m3 p m2 for label B<br>
   * to 18 m3 p m2 for label G<br>
   * <br>
   * --> take 7 for now.
   */
  public 
double  p_avgCompanyGasConsumption_m3pm2;

  /**
   * Returns default value for parameter <code>p_avgCompanyGasConsumption_m3pm2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgCompanyGasConsumption_m3pm2_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
7 
;
  }

  public void set_p_avgCompanyGasConsumption_m3pm2( double value ) {
    if (value == this.p_avgCompanyGasConsumption_m3pm2) {
      return;
    }
    double _oldValue_xjal = this.p_avgCompanyGasConsumption_m3pm2;
    this.p_avgCompanyGasConsumption_m3pm2 = value;
    onChange_p_avgCompanyGasConsumption_m3pm2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgCompanyGasConsumption_m3pm2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgCompanyGasConsumption_m3pm2()</code> method instead.
   */
  protected void onChange_p_avgCompanyGasConsumption_m3pm2() {
    onChange_p_avgCompanyGasConsumption_m3pm2_xjal( p_avgCompanyGasConsumption_m3pm2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgCompanyGasConsumption_m3pm2_xjal( double oldValue ) {  
  }


  /**
   * https://www.wearepossible.org/parks-toolkit/5-investigating-heat-demand<br>
   * <br>
   * --> estimated benchmark 100 kWh/m2
   */
  public 
double  p_avgCompanyHeatConsumption_kWhpm2;

  /**
   * Returns default value for parameter <code>p_avgCompanyHeatConsumption_kWhpm2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgCompanyHeatConsumption_kWhpm2_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
100 
;
  }

  public void set_p_avgCompanyHeatConsumption_kWhpm2( double value ) {
    if (value == this.p_avgCompanyHeatConsumption_kWhpm2) {
      return;
    }
    double _oldValue_xjal = this.p_avgCompanyHeatConsumption_kWhpm2;
    this.p_avgCompanyHeatConsumption_kWhpm2 = value;
    onChange_p_avgCompanyHeatConsumption_kWhpm2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgCompanyHeatConsumption_kWhpm2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgCompanyHeatConsumption_kWhpm2()</code> method instead.
   */
  protected void onChange_p_avgCompanyHeatConsumption_kWhpm2() {
    onChange_p_avgCompanyHeatConsumption_kWhpm2_xjal( p_avgCompanyHeatConsumption_kWhpm2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgCompanyHeatConsumption_kWhpm2_xjal( double oldValue ) {  
  }


  /**
   * 1000
   */
  public 
double  p_avgSolarFieldPower_kWppha;

  /**
   * Returns default value for parameter <code>p_avgSolarFieldPower_kWppha</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgSolarFieldPower_kWppha_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1000 
;
  }

  public void set_p_avgSolarFieldPower_kWppha( double value ) {
    if (value == this.p_avgSolarFieldPower_kWppha) {
      return;
    }
    double _oldValue_xjal = this.p_avgSolarFieldPower_kWppha;
    this.p_avgSolarFieldPower_kWppha = value;
    onChange_p_avgSolarFieldPower_kWppha_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgSolarFieldPower_kWppha.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgSolarFieldPower_kWppha()</code> method instead.
   */
  protected void onChange_p_avgSolarFieldPower_kWppha() {
    onChange_p_avgSolarFieldPower_kWppha_xjal( p_avgSolarFieldPower_kWppha );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgSolarFieldPower_kWppha_xjal( double oldValue ) {  
  }


  /**
   * 50% -> blijkt uit aangeleverde data door "kas als energiebron". (https://www.kasalsenergiebron.nl/)<br>
   * Ook te vinden hier: https://www.kasalsenergiebron.nl/content/nieuws/2023/E22001_Rapport_WKK_Barometer_2023.pdf
   */
  public 
double  p_avgEfficiencyCHP_thermal_fr;

  /**
   * Returns default value for parameter <code>p_avgEfficiencyCHP_thermal_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEfficiencyCHP_thermal_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.5 
;
  }

  public void set_p_avgEfficiencyCHP_thermal_fr( double value ) {
    if (value == this.p_avgEfficiencyCHP_thermal_fr) {
      return;
    }
    double _oldValue_xjal = this.p_avgEfficiencyCHP_thermal_fr;
    this.p_avgEfficiencyCHP_thermal_fr = value;
    onChange_p_avgEfficiencyCHP_thermal_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEfficiencyCHP_thermal_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEfficiencyCHP_thermal_fr()</code> method instead.
   */
  protected void onChange_p_avgEfficiencyCHP_thermal_fr() {
    onChange_p_avgEfficiencyCHP_thermal_fr_xjal( p_avgEfficiencyCHP_thermal_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEfficiencyCHP_thermal_fr_xjal( double oldValue ) {  
  }


  /**
   * 42% -> blijkt uit aangeleverde data door "kas als energiebron". (https://www.kasalsenergiebron.nl/)<br>
   * Ook te vinden hier: https://www.kasalsenergiebron.nl/content/nieuws/2023/E22001_Rapport_WKK_Barometer_2023.pdf
   */
  public 
double  p_avgEfficiencyCHP_electric_fr;

  /**
   * Returns default value for parameter <code>p_avgEfficiencyCHP_electric_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEfficiencyCHP_electric_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.42 
;
  }

  public void set_p_avgEfficiencyCHP_electric_fr( double value ) {
    if (value == this.p_avgEfficiencyCHP_electric_fr) {
      return;
    }
    double _oldValue_xjal = this.p_avgEfficiencyCHP_electric_fr;
    this.p_avgEfficiencyCHP_electric_fr = value;
    onChange_p_avgEfficiencyCHP_electric_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEfficiencyCHP_electric_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEfficiencyCHP_electric_fr()</code> method instead.
   */
  protected void onChange_p_avgEfficiencyCHP_electric_fr() {
    onChange_p_avgEfficiencyCHP_electric_fr_xjal( p_avgEfficiencyCHP_electric_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEfficiencyCHP_electric_fr_xjal( double oldValue ) {  
  }


  /**
   * Average output temperature of a hydrogen burner unit in degC.<br>
   * <br>
   * --> Source?
   */
  public 
double  p_avgOutputTemperatureCHP_degC;

  /**
   * Returns default value for parameter <code>p_avgOutputTemperatureCHP_degC</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgOutputTemperatureCHP_degC_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
90 
;
  }

  public void set_p_avgOutputTemperatureCHP_degC( double value ) {
    if (value == this.p_avgOutputTemperatureCHP_degC) {
      return;
    }
    double _oldValue_xjal = this.p_avgOutputTemperatureCHP_degC;
    this.p_avgOutputTemperatureCHP_degC = value;
    onChange_p_avgOutputTemperatureCHP_degC_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgOutputTemperatureCHP_degC.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgOutputTemperatureCHP_degC()</code> method instead.
   */
  protected void onChange_p_avgOutputTemperatureCHP_degC() {
    onChange_p_avgOutputTemperatureCHP_degC_xjal( p_avgOutputTemperatureCHP_degC );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgOutputTemperatureCHP_degC_xjal( double oldValue ) {  
  }


  /**
   * Average heating efficiency of a district heating delivery set<br>
   * Set as 0.8 to account for the losses of the heatgrid, as they are not yet part of our model.<br>
   * https://www.grundfos.com/nl/learn/research-and-insights/pipe-heat-loss<br>
   * https://www.klimaat030.nl/warmteverlies-van-stadsverwarming-gigantisch/
   */
  public 
double  p_avgEfficiencyDistrictHeatingDeliverySet_fr;

  /**
   * Returns default value for parameter <code>p_avgEfficiencyDistrictHeatingDeliverySet_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgEfficiencyDistrictHeatingDeliverySet_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.8 
;
  }

  public void set_p_avgEfficiencyDistrictHeatingDeliverySet_fr( double value ) {
    if (value == this.p_avgEfficiencyDistrictHeatingDeliverySet_fr) {
      return;
    }
    double _oldValue_xjal = this.p_avgEfficiencyDistrictHeatingDeliverySet_fr;
    this.p_avgEfficiencyDistrictHeatingDeliverySet_fr = value;
    onChange_p_avgEfficiencyDistrictHeatingDeliverySet_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgEfficiencyDistrictHeatingDeliverySet_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgEfficiencyDistrictHeatingDeliverySet_fr()</code> method instead.
   */
  protected void onChange_p_avgEfficiencyDistrictHeatingDeliverySet_fr() {
    onChange_p_avgEfficiencyDistrictHeatingDeliverySet_fr_xjal( p_avgEfficiencyDistrictHeatingDeliverySet_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgEfficiencyDistrictHeatingDeliverySet_fr_xjal( double oldValue ) {  
  }


  /**
   * Average output temperature of a districtheating delivery set in degC.<br>
   * <br>
   * 70 -> https://www.nplw.nl/warmtenet/warmtetechnieken/middentemperatuur-warmtenet
   */
  public 
double  p_avgOutputTemperatureDistrictHeatingDeliverySet_degC;

  /**
   * Returns default value for parameter <code>p_avgOutputTemperatureDistrictHeatingDeliverySet_degC</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgOutputTemperatureDistrictHeatingDeliverySet_degC_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
70 
;
  }

  public void set_p_avgOutputTemperatureDistrictHeatingDeliverySet_degC( double value ) {
    if (value == this.p_avgOutputTemperatureDistrictHeatingDeliverySet_degC) {
      return;
    }
    double _oldValue_xjal = this.p_avgOutputTemperatureDistrictHeatingDeliverySet_degC;
    this.p_avgOutputTemperatureDistrictHeatingDeliverySet_degC = value;
    onChange_p_avgOutputTemperatureDistrictHeatingDeliverySet_degC_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgOutputTemperatureDistrictHeatingDeliverySet_degC.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgOutputTemperatureDistrictHeatingDeliverySet_degC()</code> method instead.
   */
  protected void onChange_p_avgOutputTemperatureDistrictHeatingDeliverySet_degC() {
    onChange_p_avgOutputTemperatureDistrictHeatingDeliverySet_degC_xjal( p_avgOutputTemperatureDistrictHeatingDeliverySet_degC );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgOutputTemperatureDistrictHeatingDeliverySet_degC_xjal( double oldValue ) {  
  }


  /**
   * SOURCE!?!?!?!
   */
  public 
double  p_v2gProbability;

  /**
   * Returns default value for parameter <code>p_v2gProbability</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_v2gProbability_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.2 
;
  }

  public void set_p_v2gProbability( double value ) {
    if (value == this.p_v2gProbability) {
      return;
    }
    double _oldValue_xjal = this.p_v2gProbability;
    this.p_v2gProbability = value;
    onChange_p_v2gProbability_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_v2gProbability.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_v2gProbability()</code> method instead.
   */
  protected void onChange_p_v2gProbability() {
    onChange_p_v2gProbability_xjal( p_v2gProbability );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_v2gProbability_xjal( double oldValue ) {  
  }


  /**
   * SOURCE!?!?!?!
   */
  public 
double  p_v1gProbability;

  /**
   * Returns default value for parameter <code>p_v1gProbability</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_v1gProbability_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.8 
;
  }

  public void set_p_v1gProbability( double value ) {
    if (value == this.p_v1gProbability) {
      return;
    }
    double _oldValue_xjal = this.p_v1gProbability;
    this.p_v1gProbability = value;
    onChange_p_v1gProbability_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_v1gProbability.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_v1gProbability()</code> method instead.
   */
  protected void onChange_p_v1gProbability() {
    onChange_p_v1gProbability_xjal( p_v1gProbability );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_v1gProbability_xjal( double oldValue ) {  
  }


  public 
double  p_avgPTPower_kWpm2;

  /**
   * Returns default value for parameter <code>p_avgPTPower_kWpm2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgPTPower_kWpm2_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.5 
;
  }

  public void set_p_avgPTPower_kWpm2( double value ) {
    if (value == this.p_avgPTPower_kWpm2) {
      return;
    }
    double _oldValue_xjal = this.p_avgPTPower_kWpm2;
    this.p_avgPTPower_kWpm2 = value;
    onChange_p_avgPTPower_kWpm2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgPTPower_kWpm2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgPTPower_kWpm2()</code> method instead.
   */
  protected void onChange_p_avgPTPower_kWpm2() {
    onChange_p_avgPTPower_kWpm2_xjal( p_avgPTPower_kWpm2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgPTPower_kWpm2_xjal( double oldValue ) {  
  }


  /**
   * https://www.kachelplaats.nl/buffervaten-cv-houtkachels/ -> 25 liter per kW warmtepomp vermogen = 0.025 m3/kW
   */
  public 
double  p_avgHeatBufferWaterVolumePerHPPower_m3pkW;

  /**
   * Returns default value for parameter <code>p_avgHeatBufferWaterVolumePerHPPower_m3pkW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgHeatBufferWaterVolumePerHPPower_m3pkW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.025 
;
  }

  public void set_p_avgHeatBufferWaterVolumePerHPPower_m3pkW( double value ) {
    if (value == this.p_avgHeatBufferWaterVolumePerHPPower_m3pkW) {
      return;
    }
    double _oldValue_xjal = this.p_avgHeatBufferWaterVolumePerHPPower_m3pkW;
    this.p_avgHeatBufferWaterVolumePerHPPower_m3pkW = value;
    onChange_p_avgHeatBufferWaterVolumePerHPPower_m3pkW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHeatBufferWaterVolumePerHPPower_m3pkW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHeatBufferWaterVolumePerHPPower_m3pkW()</code> method instead.
   */
  protected void onChange_p_avgHeatBufferWaterVolumePerHPPower_m3pkW() {
    onChange_p_avgHeatBufferWaterVolumePerHPPower_m3pkW_xjal( p_avgHeatBufferWaterVolumePerHPPower_m3pkW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHeatBufferWaterVolumePerHPPower_m3pkW_xjal( double oldValue ) {  
  }


  /**
   * https://www.kachelplaats.nl/buffervaten-cv-houtkachels/ -> 50 liter per m2 zonnecollector = 0.050 m3/m2
   */
  public 
double  p_avgHeatBufferWaterVolumePerPTSurface_m3pm2;

  /**
   * Returns default value for parameter <code>p_avgHeatBufferWaterVolumePerPTSurface_m3pm2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgHeatBufferWaterVolumePerPTSurface_m3pm2_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.05 
;
  }

  public void set_p_avgHeatBufferWaterVolumePerPTSurface_m3pm2( double value ) {
    if (value == this.p_avgHeatBufferWaterVolumePerPTSurface_m3pm2) {
      return;
    }
    double _oldValue_xjal = this.p_avgHeatBufferWaterVolumePerPTSurface_m3pm2;
    this.p_avgHeatBufferWaterVolumePerPTSurface_m3pm2 = value;
    onChange_p_avgHeatBufferWaterVolumePerPTSurface_m3pm2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHeatBufferWaterVolumePerPTSurface_m3pm2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHeatBufferWaterVolumePerPTSurface_m3pm2()</code> method instead.
   */
  protected void onChange_p_avgHeatBufferWaterVolumePerPTSurface_m3pm2() {
    onChange_p_avgHeatBufferWaterVolumePerPTSurface_m3pm2_xjal( p_avgHeatBufferWaterVolumePerPTSurface_m3pm2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHeatBufferWaterVolumePerPTSurface_m3pm2_xjal( double oldValue ) {  
  }


  /**
   * https://www.engineeringtoolbox.com/water-thermal-properties-d_162.html -> 4185 J/kg K bij 20 *C<br>
   * <br>
   * -> Verschilt eigenlijk met temperatuur, weer net iets lager bij 40 graden (4180), weer 4185 bij 60*C en net iets hoger bij 80 graden. (4197 bij 80 *C).<br>
   * <br>
   * Voor nu gekozen voor 4185.
   */
  public 
double  p_waterHeatCapacity_JpkgK;

  /**
   * Returns default value for parameter <code>p_waterHeatCapacity_JpkgK</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_waterHeatCapacity_JpkgK_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
4185 
;
  }

  public void set_p_waterHeatCapacity_JpkgK( double value ) {
    if (value == this.p_waterHeatCapacity_JpkgK) {
      return;
    }
    double _oldValue_xjal = this.p_waterHeatCapacity_JpkgK;
    this.p_waterHeatCapacity_JpkgK = value;
    onChange_p_waterHeatCapacity_JpkgK_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_waterHeatCapacity_JpkgK.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_waterHeatCapacity_JpkgK()</code> method instead.
   */
  protected void onChange_p_waterHeatCapacity_JpkgK() {
    onChange_p_waterHeatCapacity_JpkgK_xjal( p_waterHeatCapacity_JpkgK );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_waterHeatCapacity_JpkgK_xjal( double oldValue ) {  
  }


  /**
   * https://www.sigmaaldrich.com/NL/en/substance/densitystandard998kgm318027732185 --> 998 kg/m3
   */
  public 
double  p_waterDensity_kgpm3;

  /**
   * Returns default value for parameter <code>p_waterDensity_kgpm3</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_waterDensity_kgpm3_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
998 
;
  }

  public void set_p_waterDensity_kgpm3( double value ) {
    if (value == this.p_waterDensity_kgpm3) {
      return;
    }
    double _oldValue_xjal = this.p_waterDensity_kgpm3;
    this.p_waterDensity_kgpm3 = value;
    onChange_p_waterDensity_kgpm3_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_waterDensity_kgpm3.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_waterDensity_kgpm3()</code> method instead.
   */
  protected void onChange_p_waterDensity_kgpm3() {
    onChange_p_waterDensity_kgpm3_xjal( p_waterDensity_kgpm3 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_waterDensity_kgpm3_xjal( double oldValue ) {  
  }


  /**
   * ???
   */
  public 
double  p_avgMaxHeatBufferTemperature_degC;

  /**
   * Returns default value for parameter <code>p_avgMaxHeatBufferTemperature_degC</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgMaxHeatBufferTemperature_degC_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
85 
;
  }

  public void set_p_avgMaxHeatBufferTemperature_degC( double value ) {
    if (value == this.p_avgMaxHeatBufferTemperature_degC) {
      return;
    }
    double _oldValue_xjal = this.p_avgMaxHeatBufferTemperature_degC;
    this.p_avgMaxHeatBufferTemperature_degC = value;
    onChange_p_avgMaxHeatBufferTemperature_degC_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgMaxHeatBufferTemperature_degC.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgMaxHeatBufferTemperature_degC()</code> method instead.
   */
  protected void onChange_p_avgMaxHeatBufferTemperature_degC() {
    onChange_p_avgMaxHeatBufferTemperature_degC_xjal( p_avgMaxHeatBufferTemperature_degC );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgMaxHeatBufferTemperature_degC_xjal( double oldValue ) {  
  }


  public 
double  p_avgMinHeatBufferTemperature_degC;

  /**
   * Returns default value for parameter <code>p_avgMinHeatBufferTemperature_degC</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgMinHeatBufferTemperature_degC_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
60 
;
  }

  public void set_p_avgMinHeatBufferTemperature_degC( double value ) {
    if (value == this.p_avgMinHeatBufferTemperature_degC) {
      return;
    }
    double _oldValue_xjal = this.p_avgMinHeatBufferTemperature_degC;
    this.p_avgMinHeatBufferTemperature_degC = value;
    onChange_p_avgMinHeatBufferTemperature_degC_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgMinHeatBufferTemperature_degC.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgMinHeatBufferTemperature_degC()</code> method instead.
   */
  protected void onChange_p_avgMinHeatBufferTemperature_degC() {
    onChange_p_avgMinHeatBufferTemperature_degC_xjal( p_avgMinHeatBufferTemperature_degC );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgMinHeatBufferTemperature_degC_xjal( double oldValue ) {  
  }


  /**
   * https://www.econo.nl/m24hpcpc-400-h2-heatpipe-zonnecollector-prisma-pro-24-cpc -> +- 4 m2
   */
  public 
double  p_avgPTPanelSize_m2;

  /**
   * Returns default value for parameter <code>p_avgPTPanelSize_m2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgPTPanelSize_m2_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
4 
;
  }

  public void set_p_avgPTPanelSize_m2( double value ) {
    if (value == this.p_avgPTPanelSize_m2) {
      return;
    }
    double _oldValue_xjal = this.p_avgPTPanelSize_m2;
    this.p_avgPTPanelSize_m2 = value;
    onChange_p_avgPTPanelSize_m2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgPTPanelSize_m2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgPTPanelSize_m2()</code> method instead.
   */
  protected void onChange_p_avgPTPanelSize_m2() {
    onChange_p_avgPTPanelSize_m2_xjal( p_avgPTPanelSize_m2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgPTPanelSize_m2_xjal( double oldValue ) {  
  }


  /**
   * https://www.essent.nl/thuisbatterij/capaciteit-thuisbatterij : Essent: "Over het algemeen kun je ervan uitgaan dat een thuisbatterij zo'n 1 à 1,5 kWh capaciteit nodig heeft per kWp zonnepanelen vermogen. " 
   */
  public 
double  p_avgRatioHouseBatteryStorageCapacity_v_PVPower;

  /**
   * Returns default value for parameter <code>p_avgRatioHouseBatteryStorageCapacity_v_PVPower</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgRatioHouseBatteryStorageCapacity_v_PVPower_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1.25 
;
  }

  public void set_p_avgRatioHouseBatteryStorageCapacity_v_PVPower( double value ) {
    if (value == this.p_avgRatioHouseBatteryStorageCapacity_v_PVPower) {
      return;
    }
    double _oldValue_xjal = this.p_avgRatioHouseBatteryStorageCapacity_v_PVPower;
    this.p_avgRatioHouseBatteryStorageCapacity_v_PVPower = value;
    onChange_p_avgRatioHouseBatteryStorageCapacity_v_PVPower_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgRatioHouseBatteryStorageCapacity_v_PVPower.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgRatioHouseBatteryStorageCapacity_v_PVPower()</code> method instead.
   */
  protected void onChange_p_avgRatioHouseBatteryStorageCapacity_v_PVPower() {
    onChange_p_avgRatioHouseBatteryStorageCapacity_v_PVPower_xjal( p_avgRatioHouseBatteryStorageCapacity_v_PVPower );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgRatioHouseBatteryStorageCapacity_v_PVPower_xjal( double oldValue ) {  
  }


  /**
   * https://opendata.cbs.nl/#/CBS/nl/dataset/85039NED/table?searchKeywords=motorvoertuigen -> 1.1
   */
  public 
double  p_avgNrOfCarsPerHouse;

  /**
   * Returns default value for parameter <code>p_avgNrOfCarsPerHouse</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgNrOfCarsPerHouse_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1.1 
;
  }

  public void set_p_avgNrOfCarsPerHouse( double value ) {
    if (value == this.p_avgNrOfCarsPerHouse) {
      return;
    }
    double _oldValue_xjal = this.p_avgNrOfCarsPerHouse;
    this.p_avgNrOfCarsPerHouse = value;
    onChange_p_avgNrOfCarsPerHouse_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgNrOfCarsPerHouse.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgNrOfCarsPerHouse()</code> method instead.
   */
  protected void onChange_p_avgNrOfCarsPerHouse() {
    onChange_p_avgNrOfCarsPerHouse_xjal( p_avgNrOfCarsPerHouse );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgNrOfCarsPerHouse_xjal( double oldValue ) {  
  }


  /**
   * https://www.cbs.nl/nl-nl/visualisaties/verkeer-en-vervoer/verkeer/verkeersprestaties-personenautos
   */
  public 
double  p_avgAnnualTravelDistancePrivateCar_km;

  /**
   * Returns default value for parameter <code>p_avgAnnualTravelDistancePrivateCar_km</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgAnnualTravelDistancePrivateCar_km_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
11200 
;
  }

  public void set_p_avgAnnualTravelDistancePrivateCar_km( double value ) {
    if (value == this.p_avgAnnualTravelDistancePrivateCar_km) {
      return;
    }
    double _oldValue_xjal = this.p_avgAnnualTravelDistancePrivateCar_km;
    this.p_avgAnnualTravelDistancePrivateCar_km = value;
    onChange_p_avgAnnualTravelDistancePrivateCar_km_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgAnnualTravelDistancePrivateCar_km.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgAnnualTravelDistancePrivateCar_km()</code> method instead.
   */
  protected void onChange_p_avgAnnualTravelDistancePrivateCar_km() {
    onChange_p_avgAnnualTravelDistancePrivateCar_km_xjal( p_avgAnnualTravelDistancePrivateCar_km );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgAnnualTravelDistancePrivateCar_km_xjal( double oldValue ) {  
  }


  /**
   * Scaling factor used to scale down the average annual travel distance of the additional cars for households that have multiple cars. SOURCE!???
   */
  public 
double  p_avgAnnualTravelDistanceSecondVSFirstCar_fr;

  /**
   * Returns default value for parameter <code>p_avgAnnualTravelDistanceSecondVSFirstCar_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgAnnualTravelDistanceSecondVSFirstCar_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.6 
;
  }

  public void set_p_avgAnnualTravelDistanceSecondVSFirstCar_fr( double value ) {
    if (value == this.p_avgAnnualTravelDistanceSecondVSFirstCar_fr) {
      return;
    }
    double _oldValue_xjal = this.p_avgAnnualTravelDistanceSecondVSFirstCar_fr;
    this.p_avgAnnualTravelDistanceSecondVSFirstCar_fr = value;
    onChange_p_avgAnnualTravelDistanceSecondVSFirstCar_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgAnnualTravelDistanceSecondVSFirstCar_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgAnnualTravelDistanceSecondVSFirstCar_fr()</code> method instead.
   */
  protected void onChange_p_avgAnnualTravelDistanceSecondVSFirstCar_fr() {
    onChange_p_avgAnnualTravelDistanceSecondVSFirstCar_fr_xjal( p_avgAnnualTravelDistanceSecondVSFirstCar_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgAnnualTravelDistanceSecondVSFirstCar_fr_xjal( double oldValue ) {  
  }


  /**
   * Map that contains data, with key per year, and value a pair where pair.getFirst() == summertimeStartHour and pair.getSecond() == winterTimeStartHour.
   */
  public 
Map<Integer, Pair<Double, Double>>  map_yearlySummerWinterTimeStartHour;

  /**
   * Returns default value for parameter <code>map_yearlySummerWinterTimeStartHour</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<Integer, Pair<Double, Double>> _map_yearlySummerWinterTimeStartHour_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.of(
2023, new Pair<>(2018.0, 7247.0), 
2024, new Pair<>(2162.0, 7203.0),
2025, new Pair<>(2114.0, 7131.0)
) 
;
  }

  public void set_map_yearlySummerWinterTimeStartHour( Map<Integer, Pair<Double, Double>> value ) {
    if (value == this.map_yearlySummerWinterTimeStartHour) {
      return;
    }
    Map<Integer, Pair<Double, Double>> _oldValue_xjal = this.map_yearlySummerWinterTimeStartHour;
    this.map_yearlySummerWinterTimeStartHour = value;
    onChange_map_yearlySummerWinterTimeStartHour_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_yearlySummerWinterTimeStartHour.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_yearlySummerWinterTimeStartHour()</code> method instead.
   */
  protected void onChange_map_yearlySummerWinterTimeStartHour() {
    onChange_map_yearlySummerWinterTimeStartHour_xjal( map_yearlySummerWinterTimeStartHour );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_yearlySummerWinterTimeStartHour_xjal( Map<Integer, Pair<Double, Double>> oldValue ) {  
  }


  /**
   * https://comfortklimaat.nl/collectie/warmtepompen -> Thermisch vermogen is minimaal 4.<br>
   * https://www.bluesolid.nl/warmtepomp-monoblock-9-kw-1ph.html -> Thermisch vermogen van minimaal 5.<br>
   * https://www.dewarmte.nl/all-electric-warmtepomp/ -> thermisch vermogen van 2-8 kW. <br>
   * <br>
   * -> (4+5+2)/3 -> Gemiddeld ongeveer 3.6 thermisch-> 3.6/3  = 1.2 elektrisch
   */
  public 
double  p_minHeatpumpElectricCapacity_kW;

  /**
   * Returns default value for parameter <code>p_minHeatpumpElectricCapacity_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_minHeatpumpElectricCapacity_kW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1.2 
;
  }

  public void set_p_minHeatpumpElectricCapacity_kW( double value ) {
    if (value == this.p_minHeatpumpElectricCapacity_kW) {
      return;
    }
    double _oldValue_xjal = this.p_minHeatpumpElectricCapacity_kW;
    this.p_minHeatpumpElectricCapacity_kW = value;
    onChange_p_minHeatpumpElectricCapacity_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_minHeatpumpElectricCapacity_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_minHeatpumpElectricCapacity_kW()</code> method instead.
   */
  protected void onChange_p_minHeatpumpElectricCapacity_kW() {
    onChange_p_minHeatpumpElectricCapacity_kW_xjal( p_minHeatpumpElectricCapacity_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_minHeatpumpElectricCapacity_kW_xjal( double oldValue ) {  
  }


  /**
   * https://www.warmteservice.nl/Verwarming/CV-ketel/HR-Combiketel/c/163 -> Minimum ranged van 4 - 7.8 -> gekozen voor 6 
   */
  public 
double  p_minGasBurnerOutputCapacity_kW;

  /**
   * Returns default value for parameter <code>p_minGasBurnerOutputCapacity_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_minGasBurnerOutputCapacity_kW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
6 
;
  }

  public void set_p_minGasBurnerOutputCapacity_kW( double value ) {
    if (value == this.p_minGasBurnerOutputCapacity_kW) {
      return;
    }
    double _oldValue_xjal = this.p_minGasBurnerOutputCapacity_kW;
    this.p_minGasBurnerOutputCapacity_kW = value;
    onChange_p_minGasBurnerOutputCapacity_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_minGasBurnerOutputCapacity_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_minGasBurnerOutputCapacity_kW()</code> method instead.
   */
  protected void onChange_p_minGasBurnerOutputCapacity_kW() {
    onChange_p_minGasBurnerOutputCapacity_kW_xjal( p_minGasBurnerOutputCapacity_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_minGasBurnerOutputCapacity_kW_xjal( double oldValue ) {  
  }


  /**
   * Zelfde gekozen als gasbrander.
   */
  public 
double  p_minHydrogenBurnerOutputCapacity_kW;

  /**
   * Returns default value for parameter <code>p_minHydrogenBurnerOutputCapacity_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_minHydrogenBurnerOutputCapacity_kW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
6 
;
  }

  public void set_p_minHydrogenBurnerOutputCapacity_kW( double value ) {
    if (value == this.p_minHydrogenBurnerOutputCapacity_kW) {
      return;
    }
    double _oldValue_xjal = this.p_minHydrogenBurnerOutputCapacity_kW;
    this.p_minHydrogenBurnerOutputCapacity_kW = value;
    onChange_p_minHydrogenBurnerOutputCapacity_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_minHydrogenBurnerOutputCapacity_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_minHydrogenBurnerOutputCapacity_kW()</code> method instead.
   */
  protected void onChange_p_minHydrogenBurnerOutputCapacity_kW() {
    onChange_p_minHydrogenBurnerOutputCapacity_kW_xjal( p_minHydrogenBurnerOutputCapacity_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_minHydrogenBurnerOutputCapacity_kW_xjal( double oldValue ) {  
  }


  /**
   * 25 kw is a default set: https://www.acm.nl/nl/energie/warmte-en-koude/warmtetarieven/tarieven-warmte-en-koude
   */
  public 
double  p_minDistrictHeatingDeliverySetOutputCapacity_kW;

  /**
   * Returns default value for parameter <code>p_minDistrictHeatingDeliverySetOutputCapacity_kW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_minDistrictHeatingDeliverySetOutputCapacity_kW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
25 
;
  }

  public void set_p_minDistrictHeatingDeliverySetOutputCapacity_kW( double value ) {
    if (value == this.p_minDistrictHeatingDeliverySetOutputCapacity_kW) {
      return;
    }
    double _oldValue_xjal = this.p_minDistrictHeatingDeliverySetOutputCapacity_kW;
    this.p_minDistrictHeatingDeliverySetOutputCapacity_kW = value;
    onChange_p_minDistrictHeatingDeliverySetOutputCapacity_kW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_minDistrictHeatingDeliverySetOutputCapacity_kW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_minDistrictHeatingDeliverySetOutputCapacity_kW()</code> method instead.
   */
  protected void onChange_p_minDistrictHeatingDeliverySetOutputCapacity_kW() {
    onChange_p_minDistrictHeatingDeliverySetOutputCapacity_kW_xjal( p_minDistrictHeatingDeliverySetOutputCapacity_kW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_minDistrictHeatingDeliverySetOutputCapacity_kW_xjal( double oldValue ) {  
  }


  /**
   * https://www.milieucentraal.nl/energie-besparen/duurzaam-verwarmen-en-koelen/volledige-warmtepomp/? -> max 45-55<br>
   * https://warmtepomp-panel.nl/afgiftesysteem.html? -> 35 graden afgifte bij -10 graden.<br>
   * <br>
   * -> Voor nu gemiddeld 45 genomen.
   */
  public 
double  p_avgOutputTemperatureHybridHeatpump_degC;

  /**
   * Returns default value for parameter <code>p_avgOutputTemperatureHybridHeatpump_degC</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgOutputTemperatureHybridHeatpump_degC_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
45 
;
  }

  public void set_p_avgOutputTemperatureHybridHeatpump_degC( double value ) {
    if (value == this.p_avgOutputTemperatureHybridHeatpump_degC) {
      return;
    }
    double _oldValue_xjal = this.p_avgOutputTemperatureHybridHeatpump_degC;
    this.p_avgOutputTemperatureHybridHeatpump_degC = value;
    onChange_p_avgOutputTemperatureHybridHeatpump_degC_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgOutputTemperatureHybridHeatpump_degC.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgOutputTemperatureHybridHeatpump_degC()</code> method instead.
   */
  protected void onChange_p_avgOutputTemperatureHybridHeatpump_degC() {
    onChange_p_avgOutputTemperatureHybridHeatpump_degC_xjal( p_avgOutputTemperatureHybridHeatpump_degC );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgOutputTemperatureHybridHeatpump_degC_xjal( double oldValue ) {  
  }


  public 
double  p_minAnnualTravelDistanceSurveyVehicle_km;

  /**
   * Returns default value for parameter <code>p_minAnnualTravelDistanceSurveyVehicle_km</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_minAnnualTravelDistanceSurveyVehicle_km_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1000 
;
  }

  public void set_p_minAnnualTravelDistanceSurveyVehicle_km( double value ) {
    if (value == this.p_minAnnualTravelDistanceSurveyVehicle_km) {
      return;
    }
    double _oldValue_xjal = this.p_minAnnualTravelDistanceSurveyVehicle_km;
    this.p_minAnnualTravelDistanceSurveyVehicle_km = value;
    onChange_p_minAnnualTravelDistanceSurveyVehicle_km_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_minAnnualTravelDistanceSurveyVehicle_km.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_minAnnualTravelDistanceSurveyVehicle_km()</code> method instead.
   */
  protected void onChange_p_minAnnualTravelDistanceSurveyVehicle_km() {
    onChange_p_minAnnualTravelDistanceSurveyVehicle_km_xjal( p_minAnnualTravelDistanceSurveyVehicle_km );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_minAnnualTravelDistanceSurveyVehicle_km_xjal( double oldValue ) {  
  }


  /**
   * Manually calibrated value tested on 3 neighborhoods to get the total nbh yearly total to match with the expected outcome.
   */
  public 
double  p_PBL_HeatingLossFactor_fr;

  /**
   * Returns default value for parameter <code>p_PBL_HeatingLossFactor_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_PBL_HeatingLossFactor_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
52.5 //deviates a some of percentages based on neighborhood 
;
  }

  public void set_p_PBL_HeatingLossFactor_fr( double value ) {
    if (value == this.p_PBL_HeatingLossFactor_fr) {
      return;
    }
    double _oldValue_xjal = this.p_PBL_HeatingLossFactor_fr;
    this.p_PBL_HeatingLossFactor_fr = value;
    onChange_p_PBL_HeatingLossFactor_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_PBL_HeatingLossFactor_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_PBL_HeatingLossFactor_fr()</code> method instead.
   */
  protected void onChange_p_PBL_HeatingLossFactor_fr() {
    onChange_p_PBL_HeatingLossFactor_fr_xjal( p_PBL_HeatingLossFactor_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_PBL_HeatingLossFactor_fr_xjal( double oldValue ) {  
  }


  public 
Map<OL_GridConnectionInsulationLabel, Double>  map_insulationLabel_lossfactorPerFloorSurface_WpKm2;

  /**
   * Returns default value for parameter <code>map_insulationLabel_lossfactorPerFloorSurface_WpKm2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_GridConnectionInsulationLabel, Double> _map_insulationLabel_lossfactorPerFloorSurface_WpKm2_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.of(
OL_GridConnectionInsulationLabel.A, 0.35, 
OL_GridConnectionInsulationLabel.B, 0.45,
OL_GridConnectionInsulationLabel.C, 0.65,
OL_GridConnectionInsulationLabel.D, 0.85, 
OL_GridConnectionInsulationLabel.E, 1.05,
OL_GridConnectionInsulationLabel.F, 1.25,
OL_GridConnectionInsulationLabel.G, 1.45
)
 
;
  }

  public void set_map_insulationLabel_lossfactorPerFloorSurface_WpKm2( Map<OL_GridConnectionInsulationLabel, Double> value ) {
    if (value == this.map_insulationLabel_lossfactorPerFloorSurface_WpKm2) {
      return;
    }
    Map<OL_GridConnectionInsulationLabel, Double> _oldValue_xjal = this.map_insulationLabel_lossfactorPerFloorSurface_WpKm2;
    this.map_insulationLabel_lossfactorPerFloorSurface_WpKm2 = value;
    onChange_map_insulationLabel_lossfactorPerFloorSurface_WpKm2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_insulationLabel_lossfactorPerFloorSurface_WpKm2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_insulationLabel_lossfactorPerFloorSurface_WpKm2()</code> method instead.
   */
  protected void onChange_map_insulationLabel_lossfactorPerFloorSurface_WpKm2() {
    onChange_map_insulationLabel_lossfactorPerFloorSurface_WpKm2_xjal( map_insulationLabel_lossfactorPerFloorSurface_WpKm2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_insulationLabel_lossfactorPerFloorSurface_WpKm2_xjal( Map<OL_GridConnectionInsulationLabel, Double> oldValue ) {  
  }


  /**
   * Roughly aligned with data-analysis/fitting by Zin Li (TU/e PhD) based on measured data of 100 houses in Dalenm during DACS-HW project. Increased by a factor ~2 after manual testing/calibration by Gillis and Naud.
   */
  public 
double  p_solarAbsorptionFloorSurfaceScalingFactor_fr;

  /**
   * Returns default value for parameter <code>p_solarAbsorptionFloorSurfaceScalingFactor_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_solarAbsorptionFloorSurfaceScalingFactor_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.04 
;
  }

  public void set_p_solarAbsorptionFloorSurfaceScalingFactor_fr( double value ) {
    if (value == this.p_solarAbsorptionFloorSurfaceScalingFactor_fr) {
      return;
    }
    double _oldValue_xjal = this.p_solarAbsorptionFloorSurfaceScalingFactor_fr;
    this.p_solarAbsorptionFloorSurfaceScalingFactor_fr = value;
    onChange_p_solarAbsorptionFloorSurfaceScalingFactor_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_solarAbsorptionFloorSurfaceScalingFactor_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_solarAbsorptionFloorSurfaceScalingFactor_fr()</code> method instead.
   */
  protected void onChange_p_solarAbsorptionFloorSurfaceScalingFactor_fr() {
    onChange_p_solarAbsorptionFloorSurfaceScalingFactor_fr_xjal( p_solarAbsorptionFloorSurfaceScalingFactor_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_solarAbsorptionFloorSurfaceScalingFactor_fr_xjal( double oldValue ) {  
  }


  public 
double  p_avgSpaceHeatingTotalGasConsumptionShare_fr;

  /**
   * Returns default value for parameter <code>p_avgSpaceHeatingTotalGasConsumptionShare_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgSpaceHeatingTotalGasConsumptionShare_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.85 
;
  }

  public void set_p_avgSpaceHeatingTotalGasConsumptionShare_fr( double value ) {
    if (value == this.p_avgSpaceHeatingTotalGasConsumptionShare_fr) {
      return;
    }
    double _oldValue_xjal = this.p_avgSpaceHeatingTotalGasConsumptionShare_fr;
    this.p_avgSpaceHeatingTotalGasConsumptionShare_fr = value;
    onChange_p_avgSpaceHeatingTotalGasConsumptionShare_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgSpaceHeatingTotalGasConsumptionShare_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgSpaceHeatingTotalGasConsumptionShare_fr()</code> method instead.
   */
  protected void onChange_p_avgSpaceHeatingTotalGasConsumptionShare_fr() {
    onChange_p_avgSpaceHeatingTotalGasConsumptionShare_fr_xjal( p_avgSpaceHeatingTotalGasConsumptionShare_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgSpaceHeatingTotalGasConsumptionShare_fr_xjal( double oldValue ) {  
  }


  public 
double  p_avgCookingTotalGasConsumptionShare_fr;

  /**
   * Returns default value for parameter <code>p_avgCookingTotalGasConsumptionShare_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgCookingTotalGasConsumptionShare_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.05 
;
  }

  public void set_p_avgCookingTotalGasConsumptionShare_fr( double value ) {
    if (value == this.p_avgCookingTotalGasConsumptionShare_fr) {
      return;
    }
    double _oldValue_xjal = this.p_avgCookingTotalGasConsumptionShare_fr;
    this.p_avgCookingTotalGasConsumptionShare_fr = value;
    onChange_p_avgCookingTotalGasConsumptionShare_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgCookingTotalGasConsumptionShare_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgCookingTotalGasConsumptionShare_fr()</code> method instead.
   */
  protected void onChange_p_avgCookingTotalGasConsumptionShare_fr() {
    onChange_p_avgCookingTotalGasConsumptionShare_fr_xjal( p_avgCookingTotalGasConsumptionShare_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgCookingTotalGasConsumptionShare_fr_xjal( double oldValue ) {  
  }


  public 
double  p_avgDHWTotalGasConsumptionShare_fr;

  /**
   * Returns default value for parameter <code>p_avgDHWTotalGasConsumptionShare_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_avgDHWTotalGasConsumptionShare_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.1 
;
  }

  public void set_p_avgDHWTotalGasConsumptionShare_fr( double value ) {
    if (value == this.p_avgDHWTotalGasConsumptionShare_fr) {
      return;
    }
    double _oldValue_xjal = this.p_avgDHWTotalGasConsumptionShare_fr;
    this.p_avgDHWTotalGasConsumptionShare_fr = value;
    onChange_p_avgDHWTotalGasConsumptionShare_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgDHWTotalGasConsumptionShare_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgDHWTotalGasConsumptionShare_fr()</code> method instead.
   */
  protected void onChange_p_avgDHWTotalGasConsumptionShare_fr() {
    onChange_p_avgDHWTotalGasConsumptionShare_fr_xjal( p_avgDHWTotalGasConsumptionShare_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgDHWTotalGasConsumptionShare_fr_xjal( double oldValue ) {  
  }


  public 
double  p_heatCapacitySizingConstant_JpK;

  /**
   * Returns default value for parameter <code>p_heatCapacitySizingConstant_JpK</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_heatCapacitySizingConstant_JpK_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0 
;
  }

  public void set_p_heatCapacitySizingConstant_JpK( double value ) {
    if (value == this.p_heatCapacitySizingConstant_JpK) {
      return;
    }
    double _oldValue_xjal = this.p_heatCapacitySizingConstant_JpK;
    this.p_heatCapacitySizingConstant_JpK = value;
    onChange_p_heatCapacitySizingConstant_JpK_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_heatCapacitySizingConstant_JpK.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_heatCapacitySizingConstant_JpK()</code> method instead.
   */
  protected void onChange_p_heatCapacitySizingConstant_JpK() {
    onChange_p_heatCapacitySizingConstant_JpK_xjal( p_heatCapacitySizingConstant_JpK );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_heatCapacitySizingConstant_JpK_xjal( double oldValue ) {  
  }


  public 
double  p_heatCapacitySizingSlope_JpKm2;

  /**
   * Returns default value for parameter <code>p_heatCapacitySizingSlope_JpKm2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_heatCapacitySizingSlope_JpKm2_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
50000
 
;
  }

  public void set_p_heatCapacitySizingSlope_JpKm2( double value ) {
    if (value == this.p_heatCapacitySizingSlope_JpKm2) {
      return;
    }
    double _oldValue_xjal = this.p_heatCapacitySizingSlope_JpKm2;
    this.p_heatCapacitySizingSlope_JpKm2 = value;
    onChange_p_heatCapacitySizingSlope_JpKm2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_heatCapacitySizingSlope_JpKm2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_heatCapacitySizingSlope_JpKm2()</code> method instead.
   */
  protected void onChange_p_heatCapacitySizingSlope_JpKm2() {
    onChange_p_heatCapacitySizingSlope_JpKm2_xjal( p_heatCapacitySizingSlope_JpKm2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_heatCapacitySizingSlope_JpKm2_xjal( double oldValue ) {  
  }


  public 
double  p_heatCapacitySizingFactor_fr;

  /**
   * Returns default value for parameter <code>p_heatCapacitySizingFactor_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_heatCapacitySizingFactor_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1 
;
  }

  public void set_p_heatCapacitySizingFactor_fr( double value ) {
    if (value == this.p_heatCapacitySizingFactor_fr) {
      return;
    }
    double _oldValue_xjal = this.p_heatCapacitySizingFactor_fr;
    this.p_heatCapacitySizingFactor_fr = value;
    onChange_p_heatCapacitySizingFactor_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_heatCapacitySizingFactor_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_heatCapacitySizingFactor_fr()</code> method instead.
   */
  protected void onChange_p_heatCapacitySizingFactor_fr() {
    onChange_p_heatCapacitySizingFactor_fr_xjal( p_heatCapacitySizingFactor_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_heatCapacitySizingFactor_fr_xjal( double oldValue ) {  
  }


  public 
double  p_maxAvgHouseElectricityConsumptionOffset_kWhpa;

  /**
   * Returns default value for parameter <code>p_maxAvgHouseElectricityConsumptionOffset_kWhpa</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_maxAvgHouseElectricityConsumptionOffset_kWhpa_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
1000 
;
  }

  public void set_p_maxAvgHouseElectricityConsumptionOffset_kWhpa( double value ) {
    if (value == this.p_maxAvgHouseElectricityConsumptionOffset_kWhpa) {
      return;
    }
    double _oldValue_xjal = this.p_maxAvgHouseElectricityConsumptionOffset_kWhpa;
    this.p_maxAvgHouseElectricityConsumptionOffset_kWhpa = value;
    onChange_p_maxAvgHouseElectricityConsumptionOffset_kWhpa_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_maxAvgHouseElectricityConsumptionOffset_kWhpa.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_maxAvgHouseElectricityConsumptionOffset_kWhpa()</code> method instead.
   */
  protected void onChange_p_maxAvgHouseElectricityConsumptionOffset_kWhpa() {
    onChange_p_maxAvgHouseElectricityConsumptionOffset_kWhpa_xjal( p_maxAvgHouseElectricityConsumptionOffset_kWhpa );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_maxAvgHouseElectricityConsumptionOffset_kWhpa_xjal( double oldValue ) {  
  }


  public 
double  p_maxAvgHouseGasConsumptionOffset_m3pa;

  /**
   * Returns default value for parameter <code>p_maxAvgHouseGasConsumptionOffset_m3pa</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _p_maxAvgHouseGasConsumptionOffset_m3pa_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
500 
;
  }

  public void set_p_maxAvgHouseGasConsumptionOffset_m3pa( double value ) {
    if (value == this.p_maxAvgHouseGasConsumptionOffset_m3pa) {
      return;
    }
    double _oldValue_xjal = this.p_maxAvgHouseGasConsumptionOffset_m3pa;
    this.p_maxAvgHouseGasConsumptionOffset_m3pa = value;
    onChange_p_maxAvgHouseGasConsumptionOffset_m3pa_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_maxAvgHouseGasConsumptionOffset_m3pa.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_maxAvgHouseGasConsumptionOffset_m3pa()</code> method instead.
   */
  protected void onChange_p_maxAvgHouseGasConsumptionOffset_m3pa() {
    onChange_p_maxAvgHouseGasConsumptionOffset_m3pa_xjal( p_maxAvgHouseGasConsumptionOffset_m3pa );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_maxAvgHouseGasConsumptionOffset_m3pa_xjal( double oldValue ) {  
  }


  /**
   * Map that contains average values for the cooldown period in hours per insulation label.<br>
   * The cooldown period is defined as the duration of time before a building  is cooled down to the outside temperature (when there is no internal heat source).<br>
   * <br>
   * FIND SOURCE AND CORRECT THE NUMBERS BEFORE USE!
   */
  public 
Map<OL_GridConnectionInsulationLabel, Double>  map_insulationLabel_cooldownPeriod_hr;

  /**
   * Returns default value for parameter <code>map_insulationLabel_cooldownPeriod_hr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_GridConnectionInsulationLabel, Double> _map_insulationLabel_cooldownPeriod_hr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 

Map.of(
OL_GridConnectionInsulationLabel.A, 48.0, 
OL_GridConnectionInsulationLabel.B, 24.0,
OL_GridConnectionInsulationLabel.C, 16.0,
OL_GridConnectionInsulationLabel.D, 10.0, 
OL_GridConnectionInsulationLabel.E, 8.0,
OL_GridConnectionInsulationLabel.F, 6.0,
OL_GridConnectionInsulationLabel.G, 4.0
)

 
;
  }

  public void set_map_insulationLabel_cooldownPeriod_hr( Map<OL_GridConnectionInsulationLabel, Double> value ) {
    if (value == this.map_insulationLabel_cooldownPeriod_hr) {
      return;
    }
    Map<OL_GridConnectionInsulationLabel, Double> _oldValue_xjal = this.map_insulationLabel_cooldownPeriod_hr;
    this.map_insulationLabel_cooldownPeriod_hr = value;
    onChange_map_insulationLabel_cooldownPeriod_hr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_insulationLabel_cooldownPeriod_hr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_insulationLabel_cooldownPeriod_hr()</code> method instead.
   */
  protected void onChange_map_insulationLabel_cooldownPeriod_hr() {
    onChange_map_insulationLabel_cooldownPeriod_hr_xjal( map_insulationLabel_cooldownPeriod_hr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_insulationLabel_cooldownPeriod_hr_xjal( Map<OL_GridConnectionInsulationLabel, Double> oldValue ) {  
  }


  public 
OL_HouseholdCookingMethod  p_avgHouseCookingMethod;

  /**
   * Returns default value for parameter <code>p_avgHouseCookingMethod</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_HouseholdCookingMethod _p_avgHouseCookingMethod_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
OL_HouseholdCookingMethod.GAS 
;
  }

  public void set_p_avgHouseCookingMethod( OL_HouseholdCookingMethod value ) {
    if (value == this.p_avgHouseCookingMethod) {
      return;
    }
    OL_HouseholdCookingMethod _oldValue_xjal = this.p_avgHouseCookingMethod;
    this.p_avgHouseCookingMethod = value;
    onChange_p_avgHouseCookingMethod_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_avgHouseCookingMethod.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_avgHouseCookingMethod()</code> method instead.
   */
  protected void onChange_p_avgHouseCookingMethod() {
    onChange_p_avgHouseCookingMethod_xjal( p_avgHouseCookingMethod );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_avgHouseCookingMethod_xjal( OL_HouseholdCookingMethod oldValue ) {  
  }


  public 
int  p_defaultNrOfSocketsPerCharger;

  /**
   * Returns default value for parameter <code>p_defaultNrOfSocketsPerCharger</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _p_defaultNrOfSocketsPerCharger_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
2 
;
  }

  public void set_p_defaultNrOfSocketsPerCharger( int value ) {
    if (value == this.p_defaultNrOfSocketsPerCharger) {
      return;
    }
    int _oldValue_xjal = this.p_defaultNrOfSocketsPerCharger;
    this.p_defaultNrOfSocketsPerCharger = value;
    onChange_p_defaultNrOfSocketsPerCharger_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultNrOfSocketsPerCharger.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultNrOfSocketsPerCharger()</code> method instead.
   */
  protected void onChange_p_defaultNrOfSocketsPerCharger() {
    onChange_p_defaultNrOfSocketsPerCharger_xjal( p_defaultNrOfSocketsPerCharger );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultNrOfSocketsPerCharger_xjal( int oldValue ) {  
  }


  /**
   * data_Generic\Sources\EnergyCarrierPrices
   */
  public 
Map<Integer, Map<OL_EnergyCarriers, Double>>  map_avgCostOfEnergyCarrier_eurpkWh;

  /**
   * Returns default value for parameter <code>map_avgCostOfEnergyCarrier_eurpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<Integer, Map<OL_EnergyCarriers, Double>> _map_avgCostOfEnergyCarrier_eurpkWh_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.of(
		2025, Map.of(
		       OL_EnergyCarriers.ELECTRICITY, 0.0850,
		       OL_EnergyCarriers.HEAT, 0.1576,
		       OL_EnergyCarriers.METHANE, 0.0407,
		       OL_EnergyCarriers.PETROLEUM_FUEL, 0.1864,
		       OL_EnergyCarriers.HYDROGEN, 0.066//Grey hydrogen
		       //OL_EnergyCarriers.HYDROGEN, 0.225,//green hydrogen
		       //OL_EnergyCarriers.IRON_POWDER, 0.6
		),
		2024, Map.of(
		       OL_EnergyCarriers.ELECTRICITY, 0.078,
		       OL_EnergyCarriers.HEAT, 0.1681,
		       OL_EnergyCarriers.METHANE, 0.0346,
		       OL_EnergyCarriers.PETROLEUM_FUEL, 0.189,
		       OL_EnergyCarriers.HYDROGEN, 0.06//Grey hydrogen
		       //OL_EnergyCarriers.HYDROGEN, 0.21,//green hydrogen
		       //OL_EnergyCarriers.IRON_POWDER, 0.6
		),
		2023, Map.of(
		       OL_EnergyCarriers.ELECTRICITY, 0.097,
		       OL_EnergyCarriers.HEAT, 0.1706,
		       OL_EnergyCarriers.METHANE, 0.0396,
		       OL_EnergyCarriers.PETROLEUM_FUEL, 0.1843,
		       OL_EnergyCarriers.HYDROGEN, 0.075//Grey hydrogen
		       //OL_EnergyCarriers.HYDROGEN, 0.195,//green hydrogen
		       //OL_EnergyCarriers.IRON_POWDER, 0.6
		)
) 
;
  }

  public void set_map_avgCostOfEnergyCarrier_eurpkWh( Map<Integer, Map<OL_EnergyCarriers, Double>> value ) {
    if (value == this.map_avgCostOfEnergyCarrier_eurpkWh) {
      return;
    }
    Map<Integer, Map<OL_EnergyCarriers, Double>> _oldValue_xjal = this.map_avgCostOfEnergyCarrier_eurpkWh;
    this.map_avgCostOfEnergyCarrier_eurpkWh = value;
    onChange_map_avgCostOfEnergyCarrier_eurpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_avgCostOfEnergyCarrier_eurpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_avgCostOfEnergyCarrier_eurpkWh()</code> method instead.
   */
  protected void onChange_map_avgCostOfEnergyCarrier_eurpkWh() {
    onChange_map_avgCostOfEnergyCarrier_eurpkWh_xjal( map_avgCostOfEnergyCarrier_eurpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_avgCostOfEnergyCarrier_eurpkWh_xjal( Map<Integer, Map<OL_EnergyCarriers, Double>> oldValue ) {  
  }


  /**
   * data_Generic\Sources\CAPEX_OPEX_LifeTime/capex_references
   */
  public 
Map<OL_EnergyAssetType, Double>  map_avgAssetSizeDependentCAPEX_eurpkW;

  /**
   * Returns default value for parameter <code>map_avgAssetSizeDependentCAPEX_eurpkW</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_EnergyAssetType, Double> _map_avgAssetSizeDependentCAPEX_eurpkW_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.ofEntries(
    Map.entry(OL_EnergyAssetType.STORAGE_ELECTRIC, 180.0/2.0),//Value is in kWh -> Divided by 2 to get kW for C-rate of 0.5
    Map.entry(OL_EnergyAssetType.PHOTOVOLTAIC, 640.0),
    Map.entry(OL_EnergyAssetType.HEAT_PUMP_AIR, 1800.0),
    Map.entry(OL_EnergyAssetType.PHOTOTHERMAL, 600.0),
    Map.entry(OL_EnergyAssetType.WINDMILL, 1200.0),
    Map.entry(OL_EnergyAssetType.ELECTROLYSER, 1300.0),
    Map.entry(OL_EnergyAssetType.DIESEL_GENERATOR, 500.0),
    Map.entry(OL_EnergyAssetType.METHANE_GENERATOR, 8.0),
    Map.entry(OL_EnergyAssetType.GAS_BURNER, 9.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_VEHICLE, 0.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_VAN, 0.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_TRUCK, 0.0),
    Map.entry(OL_EnergyAssetType.HYDROGEN_TRUCK, 0.0)
) 
;
  }

  public void set_map_avgAssetSizeDependentCAPEX_eurpkW( Map<OL_EnergyAssetType, Double> value ) {
    if (value == this.map_avgAssetSizeDependentCAPEX_eurpkW) {
      return;
    }
    Map<OL_EnergyAssetType, Double> _oldValue_xjal = this.map_avgAssetSizeDependentCAPEX_eurpkW;
    this.map_avgAssetSizeDependentCAPEX_eurpkW = value;
    onChange_map_avgAssetSizeDependentCAPEX_eurpkW_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_avgAssetSizeDependentCAPEX_eurpkW.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_avgAssetSizeDependentCAPEX_eurpkW()</code> method instead.
   */
  protected void onChange_map_avgAssetSizeDependentCAPEX_eurpkW() {
    onChange_map_avgAssetSizeDependentCAPEX_eurpkW_xjal( map_avgAssetSizeDependentCAPEX_eurpkW );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_avgAssetSizeDependentCAPEX_eurpkW_xjal( Map<OL_EnergyAssetType, Double> oldValue ) {  
  }


  /**
   * data_Generic\Sources\CAPEX_OPEX_LifeTime/asset_lifetime_references
   */
  public 
Map<OL_EnergyAssetType, Double>  map_avgAssetLifeTime_yr;

  /**
   * Returns default value for parameter <code>map_avgAssetLifeTime_yr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_EnergyAssetType, Double> _map_avgAssetLifeTime_yr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.ofEntries(
    Map.entry(OL_EnergyAssetType.STORAGE_ELECTRIC, 15.0),
    Map.entry(OL_EnergyAssetType.PHOTOVOLTAIC, 30.0),
    Map.entry(OL_EnergyAssetType.HEAT_PUMP_AIR, 20.0),
    Map.entry(OL_EnergyAssetType.PHOTOTHERMAL, 25.0),
    Map.entry(OL_EnergyAssetType.WINDMILL, 25.0),
    Map.entry(OL_EnergyAssetType.ELECTROLYSER, 20.0),
    Map.entry(OL_EnergyAssetType.DIESEL_GENERATOR, 25.0),
    Map.entry(OL_EnergyAssetType.METHANE_GENERATOR, 25.0),
    Map.entry(OL_EnergyAssetType.GAS_BURNER, 30.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_VEHICLE, 15.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_VAN, 12.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_TRUCK, 12.0),
    Map.entry(OL_EnergyAssetType.HYDROGEN_TRUCK, 12.0)
) 
;
  }

  public void set_map_avgAssetLifeTime_yr( Map<OL_EnergyAssetType, Double> value ) {
    if (value == this.map_avgAssetLifeTime_yr) {
      return;
    }
    Map<OL_EnergyAssetType, Double> _oldValue_xjal = this.map_avgAssetLifeTime_yr;
    this.map_avgAssetLifeTime_yr = value;
    onChange_map_avgAssetLifeTime_yr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_avgAssetLifeTime_yr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_avgAssetLifeTime_yr()</code> method instead.
   */
  protected void onChange_map_avgAssetLifeTime_yr() {
    onChange_map_avgAssetLifeTime_yr_xjal( map_avgAssetLifeTime_yr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_avgAssetLifeTime_yr_xjal( Map<OL_EnergyAssetType, Double> oldValue ) {  
  }


  /**
   * data_Generic\Sources\CAPEX_OPEX_LifeTime/opex_references
   */
  public 
Map<OL_EnergyAssetType, Double>  map_avgAssetSizeDependentOPEX_eurpkWpyr;

  /**
   * Returns default value for parameter <code>map_avgAssetSizeDependentOPEX_eurpkWpyr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_EnergyAssetType, Double> _map_avgAssetSizeDependentOPEX_eurpkWpyr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.ofEntries(
    Map.entry(OL_EnergyAssetType.STORAGE_ELECTRIC, 8.0/2.0),// value is in kWh -> /2.0 to get for kW assuming C-rate of 0.5 
    Map.entry(OL_EnergyAssetType.PHOTOVOLTAIC, 10.0),
    Map.entry(OL_EnergyAssetType.HEAT_PUMP_AIR, 30.0),
    Map.entry(OL_EnergyAssetType.PHOTOTHERMAL, 15.0),
    Map.entry(OL_EnergyAssetType.WINDMILL, 25.0),
    Map.entry(OL_EnergyAssetType.ELECTROLYSER, 35.0),
    Map.entry(OL_EnergyAssetType.DIESEL_GENERATOR, 15.0),
    Map.entry(OL_EnergyAssetType.METHANE_GENERATOR, 30.0),
    Map.entry(OL_EnergyAssetType.GAS_BURNER, 3.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_VEHICLE, 0.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_VAN, 0.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_TRUCK, 0.0),
    Map.entry(OL_EnergyAssetType.HYDROGEN_TRUCK, 0.0)
) 
;
  }

  public void set_map_avgAssetSizeDependentOPEX_eurpkWpyr( Map<OL_EnergyAssetType, Double> value ) {
    if (value == this.map_avgAssetSizeDependentOPEX_eurpkWpyr) {
      return;
    }
    Map<OL_EnergyAssetType, Double> _oldValue_xjal = this.map_avgAssetSizeDependentOPEX_eurpkWpyr;
    this.map_avgAssetSizeDependentOPEX_eurpkWpyr = value;
    onChange_map_avgAssetSizeDependentOPEX_eurpkWpyr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_avgAssetSizeDependentOPEX_eurpkWpyr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_avgAssetSizeDependentOPEX_eurpkWpyr()</code> method instead.
   */
  protected void onChange_map_avgAssetSizeDependentOPEX_eurpkWpyr() {
    onChange_map_avgAssetSizeDependentOPEX_eurpkWpyr_xjal( map_avgAssetSizeDependentOPEX_eurpkWpyr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_avgAssetSizeDependentOPEX_eurpkWpyr_xjal( Map<OL_EnergyAssetType, Double> oldValue ) {  
  }


  /**
   * See gridoperator tarrif classes for the sources!
   */
  public 
Map<OL_GridOperator, Map<Integer, Class<? extends I_GridOperatorTariffs>>>  map_gridOperatorTarrifs;

  /**
   * Returns default value for parameter <code>map_gridOperatorTarrifs</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_GridOperator, Map<Integer, Class<? extends I_GridOperatorTariffs>>> _map_gridOperatorTarrifs_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.of(
      	OL_GridOperator.ENEXIS, Map.of(
	       //2026, J_GridOperatorTariffsEnexis_2026.class,
	       2025, J_GridOperatorTariffsEnexis_2025.class,
	       2024, J_GridOperatorTariffsEnexis_2025.class,
	       2023, J_GridOperatorTariffsEnexis_2025.class
		)/*,
		OL_GridOperator.LIANDER, Map.of(
	       //2026, J_GridOperatorTariffsStedin_2026.class,
	       //2025, J_GridOperatorTariffsStedin_2025.class //,
	       //2024, J_GridOperatorTariffsStedin_2024.class,
		),
		OL_GridOperator.STEDIN, Map.of(
	       //2026, J_GridOperatorTariffsStedin_2026.class,
	       //2025, J_GridOperatorTariffsStedin_2025.class //,
	       //2024, J_GridOperatorTariffsStedin_2024.class,
		)*/
	) 
;
  }

  public void set_map_gridOperatorTarrifs( Map<OL_GridOperator, Map<Integer, Class<? extends I_GridOperatorTariffs>>> value ) {
    if (value == this.map_gridOperatorTarrifs) {
      return;
    }
    Map<OL_GridOperator, Map<Integer, Class<? extends I_GridOperatorTariffs>>> _oldValue_xjal = this.map_gridOperatorTarrifs;
    this.map_gridOperatorTarrifs = value;
    onChange_map_gridOperatorTarrifs_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_gridOperatorTarrifs.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_gridOperatorTarrifs()</code> method instead.
   */
  protected void onChange_map_gridOperatorTarrifs() {
    onChange_map_gridOperatorTarrifs_xjal( map_gridOperatorTarrifs );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_gridOperatorTarrifs_xjal( Map<OL_GridOperator, Map<Integer, Class<? extends I_GridOperatorTariffs>>> oldValue ) {  
  }


  public 
Map<Integer, Map<OL_EnergyCarriers, Double>>  map_energyTaxesECImport_eurpkWh;

  /**
   * Returns default value for parameter <code>map_energyTaxesECImport_eurpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<Integer, Map<OL_EnergyCarriers, Double>> _map_energyTaxesECImport_eurpkWh_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.of(
      	2025, Map.of(
	       OL_EnergyCarriers.HEAT, 0.0,
	       OL_EnergyCarriers.PETROLEUM_FUEL, 0.04367,
	       OL_EnergyCarriers.HYDROGEN, 0.0,
	       OL_EnergyCarriers.IRON_POWDER, 0.0
		),
		2024, Map.of(
	       OL_EnergyCarriers.HEAT, 0.0,
	       OL_EnergyCarriers.PETROLEUM_FUEL, 0.04255,
	       OL_EnergyCarriers.HYDROGEN, 0.0,
	       OL_EnergyCarriers.IRON_POWDER, 0.0
		),
		2023, Map.of(
	       OL_EnergyCarriers.HEAT, 0.0,
	       OL_EnergyCarriers.PETROLEUM_FUEL, 0.04255,
	       OL_EnergyCarriers.HYDROGEN, 0.0,
	       OL_EnergyCarriers.IRON_POWDER, 0.0
		)
	) 
;
  }

  public void set_map_energyTaxesECImport_eurpkWh( Map<Integer, Map<OL_EnergyCarriers, Double>> value ) {
    if (value == this.map_energyTaxesECImport_eurpkWh) {
      return;
    }
    Map<Integer, Map<OL_EnergyCarriers, Double>> _oldValue_xjal = this.map_energyTaxesECImport_eurpkWh;
    this.map_energyTaxesECImport_eurpkWh = value;
    onChange_map_energyTaxesECImport_eurpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_energyTaxesECImport_eurpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_energyTaxesECImport_eurpkWh()</code> method instead.
   */
  protected void onChange_map_energyTaxesECImport_eurpkWh() {
    onChange_map_energyTaxesECImport_eurpkWh_xjal( map_energyTaxesECImport_eurpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_energyTaxesECImport_eurpkWh_xjal( Map<Integer, Map<OL_EnergyCarriers, Double>> oldValue ) {  
  }


  /**
   * https://www.rijksoverheid.nl/onderwerpen/belasting-betalen/vraag-en-antwoord/betaal-ik-btw-over-mijn-energiebelasting
   */
  public 
double  VAT_energy_fr;

  /**
   * Returns default value for parameter <code>VAT_energy_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _VAT_energy_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.21 
;
  }

  public void set_VAT_energy_fr( double value ) {
    if (value == this.VAT_energy_fr) {
      return;
    }
    double _oldValue_xjal = this.VAT_energy_fr;
    this.VAT_energy_fr = value;
    onChange_VAT_energy_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter VAT_energy_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_VAT_energy_fr()</code> method instead.
   */
  protected void onChange_VAT_energy_fr() {
    onChange_VAT_energy_fr_xjal( VAT_energy_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_VAT_energy_fr_xjal( double oldValue ) {  
  }


  /**
   * https://www.belastingdienst.nl/wps/wcm/connect/bldcontentnl/belastingdienst/zakelijk/btw/tarieven_en_vrijstellingen/tarieven_en_vrijstellingen
   */
  public 
double  VAT_CAPEXAndOPEX_fr;

  /**
   * Returns default value for parameter <code>VAT_CAPEXAndOPEX_fr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _VAT_CAPEXAndOPEX_fr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
0.21 
;
  }

  public void set_VAT_CAPEXAndOPEX_fr( double value ) {
    if (value == this.VAT_CAPEXAndOPEX_fr) {
      return;
    }
    double _oldValue_xjal = this.VAT_CAPEXAndOPEX_fr;
    this.VAT_CAPEXAndOPEX_fr = value;
    onChange_VAT_CAPEXAndOPEX_fr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter VAT_CAPEXAndOPEX_fr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_VAT_CAPEXAndOPEX_fr()</code> method instead.
   */
  protected void onChange_VAT_CAPEXAndOPEX_fr() {
    onChange_VAT_CAPEXAndOPEX_fr_xjal( VAT_CAPEXAndOPEX_fr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_VAT_CAPEXAndOPEX_fr_xjal( double oldValue ) {  
  }


  /**
   * data_Generic\Sources\CO2Emissions
   */
  public 
Map<OL_EnergyCarriers, Double>  map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh;

  /**
   * Returns default value for parameter <code>map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_EnergyCarriers, Double> _map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.of(
       OL_EnergyCarriers.ELECTRICITY, 0.0,
       OL_EnergyCarriers.HEAT, 0.0,
       OL_EnergyCarriers.METHANE, 0.202,
       OL_EnergyCarriers.PETROLEUM_FUEL, 0.264,
       OL_EnergyCarriers.HYDROGEN, 0.0,
       OL_EnergyCarriers.IRON_POWDER, 0.0
)

	 
;
  }

  public void set_map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh( Map<OL_EnergyCarriers, Double> value ) {
    if (value == this.map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh) {
      return;
    }
    Map<OL_EnergyCarriers, Double> _oldValue_xjal = this.map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh;
    this.map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh = value;
    onChange_map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh()</code> method instead.
   */
  protected void onChange_map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh() {
    onChange_map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh_xjal( map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh_xjal( Map<OL_EnergyCarriers, Double> oldValue ) {  
  }


  public 
OL_PVOrientation  p_defaultPVOrientation;

  /**
   * Returns default value for parameter <code>p_defaultPVOrientation</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public OL_PVOrientation _p_defaultPVOrientation_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
OL_PVOrientation.SOUTH 
;
  }

  public void set_p_defaultPVOrientation( OL_PVOrientation value ) {
    if (value == this.p_defaultPVOrientation) {
      return;
    }
    OL_PVOrientation _oldValue_xjal = this.p_defaultPVOrientation;
    this.p_defaultPVOrientation = value;
    onChange_p_defaultPVOrientation_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_defaultPVOrientation.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_defaultPVOrientation()</code> method instead.
   */
  protected void onChange_p_defaultPVOrientation() {
    onChange_p_defaultPVOrientation_xjal( p_defaultPVOrientation );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_defaultPVOrientation_xjal( OL_PVOrientation oldValue ) {  
  }


  /**
   * data_Generic\Sources\CO2Emissions
   */
  public 
Map<OL_EnergyCarriers, Double>  map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh;

  /**
   * Returns default value for parameter <code>map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_EnergyCarriers, Double> _map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.of(
       OL_EnergyCarriers.ELECTRICITY, 0.349, // 0.328–0.370
       OL_EnergyCarriers.HEAT, 0.095,
       OL_EnergyCarriers.METHANE, 0.244,
       OL_EnergyCarriers.PETROLEUM_FUEL, 0.312,
       OL_EnergyCarriers.HYDROGEN, 0.300 // Grey hydrogen
       //OL_EnergyCarriers.HYDROGEN, 0.0225, // 0.015–0.030, Green hydrogen       
       //OL_EnergyCarriers.IRON_POWDER, ???
)

	 
;
  }

  public void set_map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh( Map<OL_EnergyCarriers, Double> value ) {
    if (value == this.map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh) {
      return;
    }
    Map<OL_EnergyCarriers, Double> _oldValue_xjal = this.map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh;
    this.map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh = value;
    onChange_map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh()</code> method instead.
   */
  protected void onChange_map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh() {
    onChange_map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh_xjal( map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh_xjal( Map<OL_EnergyCarriers, Double> oldValue ) {  
  }


  /**
   * Numbers are excluding VAT!<br>
   * Full subtraction of energy taxes are including VAT!<br>
   * <br>
   * -https://www.engie.nl/klantenservice/overheidsheffingen/vermindering-energiebelasting<br>
   * -https://www.rijksoverheid.nl/onderwerpen/energie-thuis/vraag-en-antwoord/opbouw-energierekening<br>
   * <br>
   * Definition: In the Netherlands each year every GridConnection that is considered a 'Verblijfsobject' (All houses, most companies) get a fixed reduction in energy costs. 
   */
  public 
Map<Integer, Double>  p_reductionInEnergyTaxes_eurpyr;

  /**
   * Returns default value for parameter <code>p_reductionInEnergyTaxes_eurpyr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<Integer, Double> _p_reductionInEnergyTaxes_eurpyr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.of(
   2026, 519.80,
   2025, 524.95,
   2024, 521.81,
   2023, 493.27
) 
;
  }

  public void set_p_reductionInEnergyTaxes_eurpyr( Map<Integer, Double> value ) {
    if (value == this.p_reductionInEnergyTaxes_eurpyr) {
      return;
    }
    Map<Integer, Double> _oldValue_xjal = this.p_reductionInEnergyTaxes_eurpyr;
    this.p_reductionInEnergyTaxes_eurpyr = value;
    onChange_p_reductionInEnergyTaxes_eurpyr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter p_reductionInEnergyTaxes_eurpyr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_p_reductionInEnergyTaxes_eurpyr()</code> method instead.
   */
  protected void onChange_p_reductionInEnergyTaxes_eurpyr() {
    onChange_p_reductionInEnergyTaxes_eurpyr_xjal( p_reductionInEnergyTaxes_eurpyr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_p_reductionInEnergyTaxes_eurpyr_xjal( Map<Integer, Double> oldValue ) {  
  }


  /**
   * Source: https://www.belastingdienst.nl/wps/wcm/connect/bldcontentnl/belastingdienst/zakelijk/overige_belastingen/belastingen_op_milieugrondslag/energiebelasting/?utm_source=chatgpt.com
   */
  public 
Map<Integer, Map<OL_EnergyCarriers, Map<OL_EnergyTaxesBracket, Double>>>  map_bracketDependentEnergyTaxesECImport_eurpkWh;

  /**
   * Returns default value for parameter <code>map_bracketDependentEnergyTaxesECImport_eurpkWh</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<Integer, Map<OL_EnergyCarriers, Map<OL_EnergyTaxesBracket, Double>>> _map_bracketDependentEnergyTaxesECImport_eurpkWh_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.of(
2026, Map.of(
    OL_EnergyCarriers.ELECTRICITY, Map.of(
        OL_EnergyTaxesBracket.BRACKET_1, 0.09161,
        OL_EnergyTaxesBracket.BRACKET_2, 0.09161,
        OL_EnergyTaxesBracket.BRACKET_3, 0.06671,
        OL_EnergyTaxesBracket.BRACKET_4, 0.03735,
        OL_EnergyTaxesBracket.BRACKET_5, 0.00379
    ),
    OL_EnergyCarriers.METHANE, Map.of(
        OL_EnergyTaxesBracket.BRACKET_1, 0.60066,
        OL_EnergyTaxesBracket.BRACKET_2, 0.60066,
        OL_EnergyTaxesBracket.BRACKET_3, 0.33085,
        OL_EnergyTaxesBracket.BRACKET_4, 0.21396,
        OL_EnergyTaxesBracket.BRACKET_5, 0.05313
    )
),
2025, Map.of(
    OL_EnergyCarriers.ELECTRICITY, Map.of(
        OL_EnergyTaxesBracket.BRACKET_1, 0.10154,
        OL_EnergyTaxesBracket.BRACKET_2, 0.10154,
        OL_EnergyTaxesBracket.BRACKET_3, 0.06937,
        OL_EnergyTaxesBracket.BRACKET_4, 0.03868,
        OL_EnergyTaxesBracket.BRACKET_5, 0.00321
    ),
    OL_EnergyCarriers.METHANE, Map.of(
        OL_EnergyTaxesBracket.BRACKET_1, 0.57816,
        OL_EnergyTaxesBracket.BRACKET_2, 0.57816,
        OL_EnergyTaxesBracket.BRACKET_3, 0.31573,
        OL_EnergyTaxesBracket.BRACKET_4, 0.20347,
        OL_EnergyTaxesBracket.BRACKET_5, 0.05385
    )
),
2024, Map.of(
    OL_EnergyCarriers.ELECTRICITY, Map.of(
        OL_EnergyTaxesBracket.BRACKET_1, 0.10880,
        OL_EnergyTaxesBracket.BRACKET_2, 0.10880,
        OL_EnergyTaxesBracket.BRACKET_3, 0.09037,
        OL_EnergyTaxesBracket.BRACKET_4, 0.03943,
        OL_EnergyTaxesBracket.BRACKET_5, 0.00254
    ),
    OL_EnergyCarriers.METHANE, Map.of(
        OL_EnergyTaxesBracket.BRACKET_1, 0.58301,
        OL_EnergyTaxesBracket.BRACKET_2, 0.58301,
        OL_EnergyTaxesBracket.BRACKET_3, 0.22378,
        OL_EnergyTaxesBracket.BRACKET_4, 0.12855,
        OL_EnergyTaxesBracket.BRACKET_5, 0.04886
    )
),
2023, Map.of(
    OL_EnergyCarriers.ELECTRICITY, Map.of(
        OL_EnergyTaxesBracket.BRACKET_1, 0.12599,
        OL_EnergyTaxesBracket.BRACKET_2, 0.12599,
        OL_EnergyTaxesBracket.BRACKET_3, 0.10046,
        OL_EnergyTaxesBracket.BRACKET_4, 0.03942,
        OL_EnergyTaxesBracket.BRACKET_5, 0.00115
    ),
    OL_EnergyCarriers.METHANE, Map.of(
        OL_EnergyTaxesBracket.BRACKET_1, 0.48980,
        OL_EnergyTaxesBracket.BRACKET_2, 0.48980,
        OL_EnergyTaxesBracket.BRACKET_3, 0.09621,
        OL_EnergyTaxesBracket.BRACKET_4, 0.05109,
        OL_EnergyTaxesBracket.BRACKET_5, 0.03919
    )
)
) 
;
  }

  public void set_map_bracketDependentEnergyTaxesECImport_eurpkWh( Map<Integer, Map<OL_EnergyCarriers, Map<OL_EnergyTaxesBracket, Double>>> value ) {
    if (value == this.map_bracketDependentEnergyTaxesECImport_eurpkWh) {
      return;
    }
    Map<Integer, Map<OL_EnergyCarriers, Map<OL_EnergyTaxesBracket, Double>>> _oldValue_xjal = this.map_bracketDependentEnergyTaxesECImport_eurpkWh;
    this.map_bracketDependentEnergyTaxesECImport_eurpkWh = value;
    onChange_map_bracketDependentEnergyTaxesECImport_eurpkWh_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_bracketDependentEnergyTaxesECImport_eurpkWh.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_bracketDependentEnergyTaxesECImport_eurpkWh()</code> method instead.
   */
  protected void onChange_map_bracketDependentEnergyTaxesECImport_eurpkWh() {
    onChange_map_bracketDependentEnergyTaxesECImport_eurpkWh_xjal( map_bracketDependentEnergyTaxesECImport_eurpkWh );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_bracketDependentEnergyTaxesECImport_eurpkWh_xjal( Map<Integer, Map<OL_EnergyCarriers, Map<OL_EnergyTaxesBracket, Double>>> oldValue ) {  
  }


  /**
   * data_Generic\Sources\CAPEX_OPEX_LifeTime/capex_references
   */
  public 
Map<OL_EnergyAssetType, Double>  map_avgAssetBaseCAPEX_eur;

  /**
   * Returns default value for parameter <code>map_avgAssetBaseCAPEX_eur</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_EnergyAssetType, Double> _map_avgAssetBaseCAPEX_eur_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.ofEntries(
    Map.entry(OL_EnergyAssetType.STORAGE_ELECTRIC, 0.0),
    Map.entry(OL_EnergyAssetType.PHOTOVOLTAIC, 0.0),
    Map.entry(OL_EnergyAssetType.HEAT_PUMP_AIR, 0.0),
    Map.entry(OL_EnergyAssetType.PHOTOTHERMAL, 0.0),
    Map.entry(OL_EnergyAssetType.WINDMILL, 0.0),
    Map.entry(OL_EnergyAssetType.ELECTROLYSER, 0.0),
    Map.entry(OL_EnergyAssetType.DIESEL_GENERATOR, 0.0),
    Map.entry(OL_EnergyAssetType.METHANE_GENERATOR, 0.0),
    Map.entry(OL_EnergyAssetType.GAS_BURNER, 0.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_VEHICLE, 57_000.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_VAN, 55_000.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_TRUCK, 300_000.0),
    Map.entry(OL_EnergyAssetType.HYDROGEN_TRUCK, 350_000.0)
) 
;
  }

  public void set_map_avgAssetBaseCAPEX_eur( Map<OL_EnergyAssetType, Double> value ) {
    if (value == this.map_avgAssetBaseCAPEX_eur) {
      return;
    }
    Map<OL_EnergyAssetType, Double> _oldValue_xjal = this.map_avgAssetBaseCAPEX_eur;
    this.map_avgAssetBaseCAPEX_eur = value;
    onChange_map_avgAssetBaseCAPEX_eur_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_avgAssetBaseCAPEX_eur.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_avgAssetBaseCAPEX_eur()</code> method instead.
   */
  protected void onChange_map_avgAssetBaseCAPEX_eur() {
    onChange_map_avgAssetBaseCAPEX_eur_xjal( map_avgAssetBaseCAPEX_eur );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_avgAssetBaseCAPEX_eur_xjal( Map<OL_EnergyAssetType, Double> oldValue ) {  
  }


  /**
   * data_Generic\Sources\CAPEX_OPEX_LifeTime/capex_references
   */
  public 
Map<OL_EnergyAssetType, Double>  map_avgAssetBaseOPEX_eurpyr;

  /**
   * Returns default value for parameter <code>map_avgAssetBaseOPEX_eurpyr</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<OL_EnergyAssetType, Double> _map_avgAssetBaseOPEX_eurpyr_DefaultValue_xjal() {
    final AVGC_data self = this;
    return 
Map.ofEntries(
    Map.entry(OL_EnergyAssetType.STORAGE_ELECTRIC, 0.0),
    Map.entry(OL_EnergyAssetType.PHOTOVOLTAIC, 0.0),
    Map.entry(OL_EnergyAssetType.HEAT_PUMP_AIR, 0.0),
    Map.entry(OL_EnergyAssetType.PHOTOTHERMAL, 0.0),
    Map.entry(OL_EnergyAssetType.WINDMILL, 0.0),
    Map.entry(OL_EnergyAssetType.ELECTROLYSER, 0.0),
    Map.entry(OL_EnergyAssetType.DIESEL_GENERATOR, 0.0),
    Map.entry(OL_EnergyAssetType.METHANE_GENERATOR, 0.0),
    Map.entry(OL_EnergyAssetType.GAS_BURNER, 0.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_VEHICLE, 57_000.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_VAN, 55_000.0),
    Map.entry(OL_EnergyAssetType.ELECTRIC_TRUCK, 300_000.0),
    Map.entry(OL_EnergyAssetType.HYDROGEN_TRUCK, 350_000.0)
) 
;
  }

  public void set_map_avgAssetBaseOPEX_eurpyr( Map<OL_EnergyAssetType, Double> value ) {
    if (value == this.map_avgAssetBaseOPEX_eurpyr) {
      return;
    }
    Map<OL_EnergyAssetType, Double> _oldValue_xjal = this.map_avgAssetBaseOPEX_eurpyr;
    this.map_avgAssetBaseOPEX_eurpyr = value;
    onChange_map_avgAssetBaseOPEX_eurpyr_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_avgAssetBaseOPEX_eurpyr.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_avgAssetBaseOPEX_eurpyr()</code> method instead.
   */
  protected void onChange_map_avgAssetBaseOPEX_eurpyr() {
    onChange_map_avgAssetBaseOPEX_eurpyr_xjal( map_avgAssetBaseOPEX_eurpyr );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_avgAssetBaseOPEX_eurpyr_xjal( Map<OL_EnergyAssetType, Double> oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    p_avgHouseConnectionCapacity_kW = _p_avgHouseConnectionCapacity_kW_DefaultValue_xjal();
    p_avgHouseHeatingMethod = _p_avgHouseHeatingMethod_DefaultValue_xjal();
    p_avgUtilityConnectionCapacity_kW = _p_avgUtilityConnectionCapacity_kW_DefaultValue_xjal();
    p_avgUtilityHeatingMethod = _p_avgUtilityHeatingMethod_DefaultValue_xjal();
    p_avgHouseElectricityConsumption_kWh_yr = _p_avgHouseElectricityConsumption_kWh_yr_DefaultValue_xjal();
    p_avgHouseGasConsumption_m3_yr = _p_avgHouseGasConsumption_m3_yr_DefaultValue_xjal();
    p_shareOfElectricVehicleOwnership = _p_shareOfElectricVehicleOwnership_DefaultValue_xjal();
    p_ratioHouseInstalledPV = _p_ratioHouseInstalledPV_DefaultValue_xjal();
    p_avgHousePVInstallationPower_kWp = _p_avgHousePVInstallationPower_kWp_DefaultValue_xjal();
    p_avgEVStorageCar_kWh = _p_avgEVStorageCar_kWh_DefaultValue_xjal();
    p_avgEVMaxChargePowerCar_kW = _p_avgEVMaxChargePowerCar_kW_DefaultValue_xjal();
    p_avgEVStorageVan_kWh = _p_avgEVStorageVan_kWh_DefaultValue_xjal();
    p_avgEVStorageTruck_kWh = _p_avgEVStorageTruck_kWh_DefaultValue_xjal();
    p_avgEVMaxChargePowerVan_kW = _p_avgEVMaxChargePowerVan_kW_DefaultValue_xjal();
    p_avgEVMaxChargePowerTruck_kW = _p_avgEVMaxChargePowerTruck_kW_DefaultValue_xjal();
    p_avgEVEnergyConsumptionCar_kWhpkm = _p_avgEVEnergyConsumptionCar_kWhpkm_DefaultValue_xjal();
    p_avgEVEnergyConsumptionVan_kWhpkm = _p_avgEVEnergyConsumptionVan_kWhpkm_DefaultValue_xjal();
    p_avgEVEnergyConsumptionTruck_kWhpkm = _p_avgEVEnergyConsumptionTruck_kWhpkm_DefaultValue_xjal();
    p_gas_kWhpm3 = _p_gas_kWhpm3_DefaultValue_xjal();
    p_hydrogenEnergyDensity_kWh_Nm3 = _p_hydrogenEnergyDensity_kWh_Nm3_DefaultValue_xjal();
    p_hydrogenDensity_kg_Nm3 = _p_hydrogenDensity_kg_Nm3_DefaultValue_xjal();
    p_oxygenDensity_kg_Nm3 = _p_oxygenDensity_kg_Nm3_DefaultValue_xjal();
    p_oxygenProduction_kgO2pkgH2 = _p_oxygenProduction_kgO2pkgH2_DefaultValue_xjal();
    p_hydrogenSpecificEnergy_kWh_kg = _p_hydrogenSpecificEnergy_kWh_kg_DefaultValue_xjal();
    p_diesel_kWhpl = _p_diesel_kWhpl_DefaultValue_xjal();
    p_avgDieselConsumptionCar_kmpl = _p_avgDieselConsumptionCar_kmpl_DefaultValue_xjal();
    p_avgGasolineConsumptionCar_kmpl = _p_avgGasolineConsumptionCar_kmpl_DefaultValue_xjal();
    p_gasoline_kWhpl = _p_gasoline_kWhpl_DefaultValue_xjal();
    p_avgDieselConsumptionCar_kWhpkm = _p_avgDieselConsumptionCar_kWhpkm_DefaultValue_xjal();
    p_avgGasolineConsumptionCar_kWhpkm = _p_avgGasolineConsumptionCar_kWhpkm_DefaultValue_xjal();
    p_avgDieselConsumptionVan_kmpl = _p_avgDieselConsumptionVan_kmpl_DefaultValue_xjal();
    p_avgDieselConsumptionVan_kWhpkm = _p_avgDieselConsumptionVan_kWhpkm_DefaultValue_xjal();
    p_avgDieselConsumptionTruck_kmpl = _p_avgDieselConsumptionTruck_kmpl_DefaultValue_xjal();
    p_avgDieselConsumptionTruck_kWhpkm = _p_avgDieselConsumptionTruck_kWhpkm_DefaultValue_xjal();
    p_avgCOPHeatpump = _p_avgCOPHeatpump_DefaultValue_xjal();
    p_avgUtilityPVPower_kWp = _p_avgUtilityPVPower_kWp_DefaultValue_xjal();
    p_ratioElectricTrucks = _p_ratioElectricTrucks_DefaultValue_xjal();
    p_avgCompanyHeatingMethod = _p_avgCompanyHeatingMethod_DefaultValue_xjal();
    p_avgPVPower_kWpm2 = _p_avgPVPower_kWpm2_DefaultValue_xjal();
    p_avgRatioBatteryCapacity_v_Power = _p_avgRatioBatteryCapacity_v_Power_DefaultValue_xjal();
    p_avgHydrogenConsumptionCar_kWhpkm = _p_avgHydrogenConsumptionCar_kWhpkm_DefaultValue_xjal();
    p_avgHydrogenConsumptionVan_kWhpkm = _p_avgHydrogenConsumptionVan_kWhpkm_DefaultValue_xjal();
    p_avgHydrogenConsumptionTruck_kWhpkm = _p_avgHydrogenConsumptionTruck_kWhpkm_DefaultValue_xjal();
    p_avgRatioRoofPotentialPV = _p_avgRatioRoofPotentialPV_DefaultValue_xjal();
    p_avgEfficiencyHeatpump_fr = _p_avgEfficiencyHeatpump_fr_DefaultValue_xjal();
    p_avgOutputTemperatureElectricHeatpump_degC = _p_avgOutputTemperatureElectricHeatpump_degC_DefaultValue_xjal();
    p_avgEfficiencyGasBurner_fr = _p_avgEfficiencyGasBurner_fr_DefaultValue_xjal();
    p_avgOutputTemperatureGasBurner_degC = _p_avgOutputTemperatureGasBurner_degC_DefaultValue_xjal();
    p_avgEfficiencyHydrogenBurner_fr = _p_avgEfficiencyHydrogenBurner_fr_DefaultValue_xjal();
    p_avgOutputTemperatureHydrogenBurner_degC = _p_avgOutputTemperatureHydrogenBurner_degC_DefaultValue_xjal();
    p_defaultNrOfVehiclesPerChargerSocket = _p_defaultNrOfVehiclesPerChargerSocket_DefaultValue_xjal();
    p_avgAnnualTravelDistanceVan_km = _p_avgAnnualTravelDistanceVan_km_DefaultValue_xjal();
    p_avgAnnualTravelDistanceCompanyCar_km = _p_avgAnnualTravelDistanceCompanyCar_km_DefaultValue_xjal();
    p_avgAnnualTravelDistanceTruck_km = _p_avgAnnualTravelDistanceTruck_km_DefaultValue_xjal();
    p_avgFullLoadHoursPV_hr = _p_avgFullLoadHoursPV_hr_DefaultValue_xjal();
    p_avgCompanyElectricityConsumption_kWhpm2 = _p_avgCompanyElectricityConsumption_kWhpm2_DefaultValue_xjal();
    p_avgCompanyGasConsumption_m3pm2 = _p_avgCompanyGasConsumption_m3pm2_DefaultValue_xjal();
    p_avgCompanyHeatConsumption_kWhpm2 = _p_avgCompanyHeatConsumption_kWhpm2_DefaultValue_xjal();
    p_avgSolarFieldPower_kWppha = _p_avgSolarFieldPower_kWppha_DefaultValue_xjal();
    p_avgEfficiencyCHP_thermal_fr = _p_avgEfficiencyCHP_thermal_fr_DefaultValue_xjal();
    p_avgEfficiencyCHP_electric_fr = _p_avgEfficiencyCHP_electric_fr_DefaultValue_xjal();
    p_avgOutputTemperatureCHP_degC = _p_avgOutputTemperatureCHP_degC_DefaultValue_xjal();
    p_avgEfficiencyDistrictHeatingDeliverySet_fr = _p_avgEfficiencyDistrictHeatingDeliverySet_fr_DefaultValue_xjal();
    p_avgOutputTemperatureDistrictHeatingDeliverySet_degC = _p_avgOutputTemperatureDistrictHeatingDeliverySet_degC_DefaultValue_xjal();
    p_v2gProbability = _p_v2gProbability_DefaultValue_xjal();
    p_v1gProbability = _p_v1gProbability_DefaultValue_xjal();
    p_avgPTPower_kWpm2 = _p_avgPTPower_kWpm2_DefaultValue_xjal();
    p_avgHeatBufferWaterVolumePerHPPower_m3pkW = _p_avgHeatBufferWaterVolumePerHPPower_m3pkW_DefaultValue_xjal();
    p_avgHeatBufferWaterVolumePerPTSurface_m3pm2 = _p_avgHeatBufferWaterVolumePerPTSurface_m3pm2_DefaultValue_xjal();
    p_waterHeatCapacity_JpkgK = _p_waterHeatCapacity_JpkgK_DefaultValue_xjal();
    p_waterDensity_kgpm3 = _p_waterDensity_kgpm3_DefaultValue_xjal();
    p_avgMaxHeatBufferTemperature_degC = _p_avgMaxHeatBufferTemperature_degC_DefaultValue_xjal();
    p_avgMinHeatBufferTemperature_degC = _p_avgMinHeatBufferTemperature_degC_DefaultValue_xjal();
    p_avgPTPanelSize_m2 = _p_avgPTPanelSize_m2_DefaultValue_xjal();
    p_avgRatioHouseBatteryStorageCapacity_v_PVPower = _p_avgRatioHouseBatteryStorageCapacity_v_PVPower_DefaultValue_xjal();
    p_avgNrOfCarsPerHouse = _p_avgNrOfCarsPerHouse_DefaultValue_xjal();
    p_avgAnnualTravelDistancePrivateCar_km = _p_avgAnnualTravelDistancePrivateCar_km_DefaultValue_xjal();
    p_avgAnnualTravelDistanceSecondVSFirstCar_fr = _p_avgAnnualTravelDistanceSecondVSFirstCar_fr_DefaultValue_xjal();
    map_yearlySummerWinterTimeStartHour = _map_yearlySummerWinterTimeStartHour_DefaultValue_xjal();
    p_minHeatpumpElectricCapacity_kW = _p_minHeatpumpElectricCapacity_kW_DefaultValue_xjal();
    p_minGasBurnerOutputCapacity_kW = _p_minGasBurnerOutputCapacity_kW_DefaultValue_xjal();
    p_minHydrogenBurnerOutputCapacity_kW = _p_minHydrogenBurnerOutputCapacity_kW_DefaultValue_xjal();
    p_minDistrictHeatingDeliverySetOutputCapacity_kW = _p_minDistrictHeatingDeliverySetOutputCapacity_kW_DefaultValue_xjal();
    p_avgOutputTemperatureHybridHeatpump_degC = _p_avgOutputTemperatureHybridHeatpump_degC_DefaultValue_xjal();
    p_minAnnualTravelDistanceSurveyVehicle_km = _p_minAnnualTravelDistanceSurveyVehicle_km_DefaultValue_xjal();
    p_PBL_HeatingLossFactor_fr = _p_PBL_HeatingLossFactor_fr_DefaultValue_xjal();
    map_insulationLabel_lossfactorPerFloorSurface_WpKm2 = _map_insulationLabel_lossfactorPerFloorSurface_WpKm2_DefaultValue_xjal();
    p_solarAbsorptionFloorSurfaceScalingFactor_fr = _p_solarAbsorptionFloorSurfaceScalingFactor_fr_DefaultValue_xjal();
    p_avgSpaceHeatingTotalGasConsumptionShare_fr = _p_avgSpaceHeatingTotalGasConsumptionShare_fr_DefaultValue_xjal();
    p_avgCookingTotalGasConsumptionShare_fr = _p_avgCookingTotalGasConsumptionShare_fr_DefaultValue_xjal();
    p_avgDHWTotalGasConsumptionShare_fr = _p_avgDHWTotalGasConsumptionShare_fr_DefaultValue_xjal();
    p_heatCapacitySizingConstant_JpK = _p_heatCapacitySizingConstant_JpK_DefaultValue_xjal();
    p_heatCapacitySizingSlope_JpKm2 = _p_heatCapacitySizingSlope_JpKm2_DefaultValue_xjal();
    p_heatCapacitySizingFactor_fr = _p_heatCapacitySizingFactor_fr_DefaultValue_xjal();
    p_maxAvgHouseElectricityConsumptionOffset_kWhpa = _p_maxAvgHouseElectricityConsumptionOffset_kWhpa_DefaultValue_xjal();
    p_maxAvgHouseGasConsumptionOffset_m3pa = _p_maxAvgHouseGasConsumptionOffset_m3pa_DefaultValue_xjal();
    map_insulationLabel_cooldownPeriod_hr = _map_insulationLabel_cooldownPeriod_hr_DefaultValue_xjal();
    p_avgHouseCookingMethod = _p_avgHouseCookingMethod_DefaultValue_xjal();
    p_defaultNrOfSocketsPerCharger = _p_defaultNrOfSocketsPerCharger_DefaultValue_xjal();
    map_avgCostOfEnergyCarrier_eurpkWh = _map_avgCostOfEnergyCarrier_eurpkWh_DefaultValue_xjal();
    map_avgAssetSizeDependentCAPEX_eurpkW = _map_avgAssetSizeDependentCAPEX_eurpkW_DefaultValue_xjal();
    map_avgAssetLifeTime_yr = _map_avgAssetLifeTime_yr_DefaultValue_xjal();
    map_avgAssetSizeDependentOPEX_eurpkWpyr = _map_avgAssetSizeDependentOPEX_eurpkWpyr_DefaultValue_xjal();
    map_gridOperatorTarrifs = _map_gridOperatorTarrifs_DefaultValue_xjal();
    map_energyTaxesECImport_eurpkWh = _map_energyTaxesECImport_eurpkWh_DefaultValue_xjal();
    VAT_energy_fr = _VAT_energy_fr_DefaultValue_xjal();
    VAT_CAPEXAndOPEX_fr = _VAT_CAPEXAndOPEX_fr_DefaultValue_xjal();
    map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh = _map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh_DefaultValue_xjal();
    p_defaultPVOrientation = _p_defaultPVOrientation_DefaultValue_xjal();
    map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh = _map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh_DefaultValue_xjal();
    p_reductionInEnergyTaxes_eurpyr = _p_reductionInEnergyTaxes_eurpyr_DefaultValue_xjal();
    map_bracketDependentEnergyTaxesECImport_eurpkWh = _map_bracketDependentEnergyTaxesECImport_eurpkWh_DefaultValue_xjal();
    map_avgAssetBaseCAPEX_eur = _map_avgAssetBaseCAPEX_eur_DefaultValue_xjal();
    map_avgAssetBaseOPEX_eurpyr = _map_avgAssetBaseOPEX_eurpyr_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "p_avgHouseConnectionCapacity_kW":
      if ( _callOnChange_xjal ) {
        set_p_avgHouseConnectionCapacity_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgHouseConnectionCapacity_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgHouseHeatingMethod":
      if ( _callOnChange_xjal ) {
        set_p_avgHouseHeatingMethod( (OL_GridConnectionHeatingType) _value_xjal );
      } else {
        p_avgHouseHeatingMethod = (OL_GridConnectionHeatingType) _value_xjal;
      }
      return true;
    case "p_avgUtilityConnectionCapacity_kW":
      if ( _callOnChange_xjal ) {
        set_p_avgUtilityConnectionCapacity_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgUtilityConnectionCapacity_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgUtilityHeatingMethod":
      if ( _callOnChange_xjal ) {
        set_p_avgUtilityHeatingMethod( (OL_GridConnectionHeatingType) _value_xjal );
      } else {
        p_avgUtilityHeatingMethod = (OL_GridConnectionHeatingType) _value_xjal;
      }
      return true;
    case "p_avgHouseElectricityConsumption_kWh_yr":
      if ( _callOnChange_xjal ) {
        set_p_avgHouseElectricityConsumption_kWh_yr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgHouseElectricityConsumption_kWh_yr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgHouseGasConsumption_m3_yr":
      if ( _callOnChange_xjal ) {
        set_p_avgHouseGasConsumption_m3_yr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgHouseGasConsumption_m3_yr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_shareOfElectricVehicleOwnership":
      if ( _callOnChange_xjal ) {
        set_p_shareOfElectricVehicleOwnership( ((Number) _value_xjal).doubleValue() );
      } else {
        p_shareOfElectricVehicleOwnership = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_ratioHouseInstalledPV":
      if ( _callOnChange_xjal ) {
        set_p_ratioHouseInstalledPV( ((Number) _value_xjal).doubleValue() );
      } else {
        p_ratioHouseInstalledPV = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgHousePVInstallationPower_kWp":
      if ( _callOnChange_xjal ) {
        set_p_avgHousePVInstallationPower_kWp( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgHousePVInstallationPower_kWp = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEVStorageCar_kWh":
      if ( _callOnChange_xjal ) {
        set_p_avgEVStorageCar_kWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEVStorageCar_kWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEVMaxChargePowerCar_kW":
      if ( _callOnChange_xjal ) {
        set_p_avgEVMaxChargePowerCar_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEVMaxChargePowerCar_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEVStorageVan_kWh":
      if ( _callOnChange_xjal ) {
        set_p_avgEVStorageVan_kWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEVStorageVan_kWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEVStorageTruck_kWh":
      if ( _callOnChange_xjal ) {
        set_p_avgEVStorageTruck_kWh( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEVStorageTruck_kWh = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEVMaxChargePowerVan_kW":
      if ( _callOnChange_xjal ) {
        set_p_avgEVMaxChargePowerVan_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEVMaxChargePowerVan_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEVMaxChargePowerTruck_kW":
      if ( _callOnChange_xjal ) {
        set_p_avgEVMaxChargePowerTruck_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEVMaxChargePowerTruck_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEVEnergyConsumptionCar_kWhpkm":
      if ( _callOnChange_xjal ) {
        set_p_avgEVEnergyConsumptionCar_kWhpkm( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEVEnergyConsumptionCar_kWhpkm = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEVEnergyConsumptionVan_kWhpkm":
      if ( _callOnChange_xjal ) {
        set_p_avgEVEnergyConsumptionVan_kWhpkm( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEVEnergyConsumptionVan_kWhpkm = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEVEnergyConsumptionTruck_kWhpkm":
      if ( _callOnChange_xjal ) {
        set_p_avgEVEnergyConsumptionTruck_kWhpkm( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEVEnergyConsumptionTruck_kWhpkm = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_gas_kWhpm3":
      if ( _callOnChange_xjal ) {
        set_p_gas_kWhpm3( ((Number) _value_xjal).doubleValue() );
      } else {
        p_gas_kWhpm3 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_hydrogenEnergyDensity_kWh_Nm3":
      if ( _callOnChange_xjal ) {
        set_p_hydrogenEnergyDensity_kWh_Nm3( ((Number) _value_xjal).doubleValue() );
      } else {
        p_hydrogenEnergyDensity_kWh_Nm3 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_hydrogenDensity_kg_Nm3":
      if ( _callOnChange_xjal ) {
        set_p_hydrogenDensity_kg_Nm3( ((Number) _value_xjal).doubleValue() );
      } else {
        p_hydrogenDensity_kg_Nm3 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_oxygenDensity_kg_Nm3":
      if ( _callOnChange_xjal ) {
        set_p_oxygenDensity_kg_Nm3( ((Number) _value_xjal).doubleValue() );
      } else {
        p_oxygenDensity_kg_Nm3 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_oxygenProduction_kgO2pkgH2":
      if ( _callOnChange_xjal ) {
        set_p_oxygenProduction_kgO2pkgH2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_oxygenProduction_kgO2pkgH2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_hydrogenSpecificEnergy_kWh_kg":
      if ( _callOnChange_xjal ) {
        set_p_hydrogenSpecificEnergy_kWh_kg( ((Number) _value_xjal).doubleValue() );
      } else {
        p_hydrogenSpecificEnergy_kWh_kg = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_diesel_kWhpl":
      if ( _callOnChange_xjal ) {
        set_p_diesel_kWhpl( ((Number) _value_xjal).doubleValue() );
      } else {
        p_diesel_kWhpl = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgDieselConsumptionCar_kmpl":
      if ( _callOnChange_xjal ) {
        set_p_avgDieselConsumptionCar_kmpl( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgDieselConsumptionCar_kmpl = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgGasolineConsumptionCar_kmpl":
      if ( _callOnChange_xjal ) {
        set_p_avgGasolineConsumptionCar_kmpl( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgGasolineConsumptionCar_kmpl = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_gasoline_kWhpl":
      if ( _callOnChange_xjal ) {
        set_p_gasoline_kWhpl( ((Number) _value_xjal).doubleValue() );
      } else {
        p_gasoline_kWhpl = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgDieselConsumptionCar_kWhpkm":
      if ( _callOnChange_xjal ) {
        set_p_avgDieselConsumptionCar_kWhpkm( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgDieselConsumptionCar_kWhpkm = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgGasolineConsumptionCar_kWhpkm":
      if ( _callOnChange_xjal ) {
        set_p_avgGasolineConsumptionCar_kWhpkm( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgGasolineConsumptionCar_kWhpkm = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgDieselConsumptionVan_kmpl":
      if ( _callOnChange_xjal ) {
        set_p_avgDieselConsumptionVan_kmpl( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgDieselConsumptionVan_kmpl = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgDieselConsumptionVan_kWhpkm":
      if ( _callOnChange_xjal ) {
        set_p_avgDieselConsumptionVan_kWhpkm( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgDieselConsumptionVan_kWhpkm = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgDieselConsumptionTruck_kmpl":
      if ( _callOnChange_xjal ) {
        set_p_avgDieselConsumptionTruck_kmpl( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgDieselConsumptionTruck_kmpl = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgDieselConsumptionTruck_kWhpkm":
      if ( _callOnChange_xjal ) {
        set_p_avgDieselConsumptionTruck_kWhpkm( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgDieselConsumptionTruck_kWhpkm = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgCOPHeatpump":
      if ( _callOnChange_xjal ) {
        set_p_avgCOPHeatpump( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgCOPHeatpump = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgUtilityPVPower_kWp":
      if ( _callOnChange_xjal ) {
        set_p_avgUtilityPVPower_kWp( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgUtilityPVPower_kWp = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_ratioElectricTrucks":
      if ( _callOnChange_xjal ) {
        set_p_ratioElectricTrucks( ((Number) _value_xjal).doubleValue() );
      } else {
        p_ratioElectricTrucks = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgCompanyHeatingMethod":
      if ( _callOnChange_xjal ) {
        set_p_avgCompanyHeatingMethod( (OL_GridConnectionHeatingType) _value_xjal );
      } else {
        p_avgCompanyHeatingMethod = (OL_GridConnectionHeatingType) _value_xjal;
      }
      return true;
    case "p_avgPVPower_kWpm2":
      if ( _callOnChange_xjal ) {
        set_p_avgPVPower_kWpm2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgPVPower_kWpm2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgRatioBatteryCapacity_v_Power":
      if ( _callOnChange_xjal ) {
        set_p_avgRatioBatteryCapacity_v_Power( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgRatioBatteryCapacity_v_Power = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgHydrogenConsumptionCar_kWhpkm":
      if ( _callOnChange_xjal ) {
        set_p_avgHydrogenConsumptionCar_kWhpkm( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgHydrogenConsumptionCar_kWhpkm = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgHydrogenConsumptionVan_kWhpkm":
      if ( _callOnChange_xjal ) {
        set_p_avgHydrogenConsumptionVan_kWhpkm( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgHydrogenConsumptionVan_kWhpkm = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgHydrogenConsumptionTruck_kWhpkm":
      if ( _callOnChange_xjal ) {
        set_p_avgHydrogenConsumptionTruck_kWhpkm( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgHydrogenConsumptionTruck_kWhpkm = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgRatioRoofPotentialPV":
      if ( _callOnChange_xjal ) {
        set_p_avgRatioRoofPotentialPV( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgRatioRoofPotentialPV = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEfficiencyHeatpump_fr":
      if ( _callOnChange_xjal ) {
        set_p_avgEfficiencyHeatpump_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEfficiencyHeatpump_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgOutputTemperatureElectricHeatpump_degC":
      if ( _callOnChange_xjal ) {
        set_p_avgOutputTemperatureElectricHeatpump_degC( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgOutputTemperatureElectricHeatpump_degC = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEfficiencyGasBurner_fr":
      if ( _callOnChange_xjal ) {
        set_p_avgEfficiencyGasBurner_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEfficiencyGasBurner_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgOutputTemperatureGasBurner_degC":
      if ( _callOnChange_xjal ) {
        set_p_avgOutputTemperatureGasBurner_degC( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgOutputTemperatureGasBurner_degC = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEfficiencyHydrogenBurner_fr":
      if ( _callOnChange_xjal ) {
        set_p_avgEfficiencyHydrogenBurner_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEfficiencyHydrogenBurner_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgOutputTemperatureHydrogenBurner_degC":
      if ( _callOnChange_xjal ) {
        set_p_avgOutputTemperatureHydrogenBurner_degC( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgOutputTemperatureHydrogenBurner_degC = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_defaultNrOfVehiclesPerChargerSocket":
      if ( _callOnChange_xjal ) {
        set_p_defaultNrOfVehiclesPerChargerSocket( ((Number) _value_xjal).intValue() );
      } else {
        p_defaultNrOfVehiclesPerChargerSocket = ((Number) _value_xjal).intValue();
      }
      return true;
    case "p_avgAnnualTravelDistanceVan_km":
      if ( _callOnChange_xjal ) {
        set_p_avgAnnualTravelDistanceVan_km( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgAnnualTravelDistanceVan_km = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgAnnualTravelDistanceCompanyCar_km":
      if ( _callOnChange_xjal ) {
        set_p_avgAnnualTravelDistanceCompanyCar_km( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgAnnualTravelDistanceCompanyCar_km = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgAnnualTravelDistanceTruck_km":
      if ( _callOnChange_xjal ) {
        set_p_avgAnnualTravelDistanceTruck_km( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgAnnualTravelDistanceTruck_km = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgFullLoadHoursPV_hr":
      if ( _callOnChange_xjal ) {
        set_p_avgFullLoadHoursPV_hr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgFullLoadHoursPV_hr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgCompanyElectricityConsumption_kWhpm2":
      if ( _callOnChange_xjal ) {
        set_p_avgCompanyElectricityConsumption_kWhpm2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgCompanyElectricityConsumption_kWhpm2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgCompanyGasConsumption_m3pm2":
      if ( _callOnChange_xjal ) {
        set_p_avgCompanyGasConsumption_m3pm2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgCompanyGasConsumption_m3pm2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgCompanyHeatConsumption_kWhpm2":
      if ( _callOnChange_xjal ) {
        set_p_avgCompanyHeatConsumption_kWhpm2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgCompanyHeatConsumption_kWhpm2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgSolarFieldPower_kWppha":
      if ( _callOnChange_xjal ) {
        set_p_avgSolarFieldPower_kWppha( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgSolarFieldPower_kWppha = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEfficiencyCHP_thermal_fr":
      if ( _callOnChange_xjal ) {
        set_p_avgEfficiencyCHP_thermal_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEfficiencyCHP_thermal_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEfficiencyCHP_electric_fr":
      if ( _callOnChange_xjal ) {
        set_p_avgEfficiencyCHP_electric_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEfficiencyCHP_electric_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgOutputTemperatureCHP_degC":
      if ( _callOnChange_xjal ) {
        set_p_avgOutputTemperatureCHP_degC( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgOutputTemperatureCHP_degC = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgEfficiencyDistrictHeatingDeliverySet_fr":
      if ( _callOnChange_xjal ) {
        set_p_avgEfficiencyDistrictHeatingDeliverySet_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgEfficiencyDistrictHeatingDeliverySet_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgOutputTemperatureDistrictHeatingDeliverySet_degC":
      if ( _callOnChange_xjal ) {
        set_p_avgOutputTemperatureDistrictHeatingDeliverySet_degC( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgOutputTemperatureDistrictHeatingDeliverySet_degC = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_v2gProbability":
      if ( _callOnChange_xjal ) {
        set_p_v2gProbability( ((Number) _value_xjal).doubleValue() );
      } else {
        p_v2gProbability = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_v1gProbability":
      if ( _callOnChange_xjal ) {
        set_p_v1gProbability( ((Number) _value_xjal).doubleValue() );
      } else {
        p_v1gProbability = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgPTPower_kWpm2":
      if ( _callOnChange_xjal ) {
        set_p_avgPTPower_kWpm2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgPTPower_kWpm2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgHeatBufferWaterVolumePerHPPower_m3pkW":
      if ( _callOnChange_xjal ) {
        set_p_avgHeatBufferWaterVolumePerHPPower_m3pkW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgHeatBufferWaterVolumePerHPPower_m3pkW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgHeatBufferWaterVolumePerPTSurface_m3pm2":
      if ( _callOnChange_xjal ) {
        set_p_avgHeatBufferWaterVolumePerPTSurface_m3pm2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgHeatBufferWaterVolumePerPTSurface_m3pm2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_waterHeatCapacity_JpkgK":
      if ( _callOnChange_xjal ) {
        set_p_waterHeatCapacity_JpkgK( ((Number) _value_xjal).doubleValue() );
      } else {
        p_waterHeatCapacity_JpkgK = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_waterDensity_kgpm3":
      if ( _callOnChange_xjal ) {
        set_p_waterDensity_kgpm3( ((Number) _value_xjal).doubleValue() );
      } else {
        p_waterDensity_kgpm3 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgMaxHeatBufferTemperature_degC":
      if ( _callOnChange_xjal ) {
        set_p_avgMaxHeatBufferTemperature_degC( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgMaxHeatBufferTemperature_degC = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgMinHeatBufferTemperature_degC":
      if ( _callOnChange_xjal ) {
        set_p_avgMinHeatBufferTemperature_degC( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgMinHeatBufferTemperature_degC = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgPTPanelSize_m2":
      if ( _callOnChange_xjal ) {
        set_p_avgPTPanelSize_m2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgPTPanelSize_m2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgRatioHouseBatteryStorageCapacity_v_PVPower":
      if ( _callOnChange_xjal ) {
        set_p_avgRatioHouseBatteryStorageCapacity_v_PVPower( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgRatioHouseBatteryStorageCapacity_v_PVPower = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgNrOfCarsPerHouse":
      if ( _callOnChange_xjal ) {
        set_p_avgNrOfCarsPerHouse( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgNrOfCarsPerHouse = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgAnnualTravelDistancePrivateCar_km":
      if ( _callOnChange_xjal ) {
        set_p_avgAnnualTravelDistancePrivateCar_km( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgAnnualTravelDistancePrivateCar_km = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgAnnualTravelDistanceSecondVSFirstCar_fr":
      if ( _callOnChange_xjal ) {
        set_p_avgAnnualTravelDistanceSecondVSFirstCar_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgAnnualTravelDistanceSecondVSFirstCar_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "map_yearlySummerWinterTimeStartHour":
      if ( _callOnChange_xjal ) {
        set_map_yearlySummerWinterTimeStartHour( (Map<Integer, Pair<Double, Double>>) _value_xjal );
      } else {
        map_yearlySummerWinterTimeStartHour = (Map<Integer, Pair<Double, Double>>) _value_xjal;
      }
      return true;
    case "p_minHeatpumpElectricCapacity_kW":
      if ( _callOnChange_xjal ) {
        set_p_minHeatpumpElectricCapacity_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_minHeatpumpElectricCapacity_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_minGasBurnerOutputCapacity_kW":
      if ( _callOnChange_xjal ) {
        set_p_minGasBurnerOutputCapacity_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_minGasBurnerOutputCapacity_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_minHydrogenBurnerOutputCapacity_kW":
      if ( _callOnChange_xjal ) {
        set_p_minHydrogenBurnerOutputCapacity_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_minHydrogenBurnerOutputCapacity_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_minDistrictHeatingDeliverySetOutputCapacity_kW":
      if ( _callOnChange_xjal ) {
        set_p_minDistrictHeatingDeliverySetOutputCapacity_kW( ((Number) _value_xjal).doubleValue() );
      } else {
        p_minDistrictHeatingDeliverySetOutputCapacity_kW = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgOutputTemperatureHybridHeatpump_degC":
      if ( _callOnChange_xjal ) {
        set_p_avgOutputTemperatureHybridHeatpump_degC( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgOutputTemperatureHybridHeatpump_degC = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_minAnnualTravelDistanceSurveyVehicle_km":
      if ( _callOnChange_xjal ) {
        set_p_minAnnualTravelDistanceSurveyVehicle_km( ((Number) _value_xjal).doubleValue() );
      } else {
        p_minAnnualTravelDistanceSurveyVehicle_km = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_PBL_HeatingLossFactor_fr":
      if ( _callOnChange_xjal ) {
        set_p_PBL_HeatingLossFactor_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_PBL_HeatingLossFactor_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "map_insulationLabel_lossfactorPerFloorSurface_WpKm2":
      if ( _callOnChange_xjal ) {
        set_map_insulationLabel_lossfactorPerFloorSurface_WpKm2( (Map<OL_GridConnectionInsulationLabel, Double>) _value_xjal );
      } else {
        map_insulationLabel_lossfactorPerFloorSurface_WpKm2 = (Map<OL_GridConnectionInsulationLabel, Double>) _value_xjal;
      }
      return true;
    case "p_solarAbsorptionFloorSurfaceScalingFactor_fr":
      if ( _callOnChange_xjal ) {
        set_p_solarAbsorptionFloorSurfaceScalingFactor_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_solarAbsorptionFloorSurfaceScalingFactor_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgSpaceHeatingTotalGasConsumptionShare_fr":
      if ( _callOnChange_xjal ) {
        set_p_avgSpaceHeatingTotalGasConsumptionShare_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgSpaceHeatingTotalGasConsumptionShare_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgCookingTotalGasConsumptionShare_fr":
      if ( _callOnChange_xjal ) {
        set_p_avgCookingTotalGasConsumptionShare_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgCookingTotalGasConsumptionShare_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_avgDHWTotalGasConsumptionShare_fr":
      if ( _callOnChange_xjal ) {
        set_p_avgDHWTotalGasConsumptionShare_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_avgDHWTotalGasConsumptionShare_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_heatCapacitySizingConstant_JpK":
      if ( _callOnChange_xjal ) {
        set_p_heatCapacitySizingConstant_JpK( ((Number) _value_xjal).doubleValue() );
      } else {
        p_heatCapacitySizingConstant_JpK = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_heatCapacitySizingSlope_JpKm2":
      if ( _callOnChange_xjal ) {
        set_p_heatCapacitySizingSlope_JpKm2( ((Number) _value_xjal).doubleValue() );
      } else {
        p_heatCapacitySizingSlope_JpKm2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_heatCapacitySizingFactor_fr":
      if ( _callOnChange_xjal ) {
        set_p_heatCapacitySizingFactor_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        p_heatCapacitySizingFactor_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_maxAvgHouseElectricityConsumptionOffset_kWhpa":
      if ( _callOnChange_xjal ) {
        set_p_maxAvgHouseElectricityConsumptionOffset_kWhpa( ((Number) _value_xjal).doubleValue() );
      } else {
        p_maxAvgHouseElectricityConsumptionOffset_kWhpa = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "p_maxAvgHouseGasConsumptionOffset_m3pa":
      if ( _callOnChange_xjal ) {
        set_p_maxAvgHouseGasConsumptionOffset_m3pa( ((Number) _value_xjal).doubleValue() );
      } else {
        p_maxAvgHouseGasConsumptionOffset_m3pa = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "map_insulationLabel_cooldownPeriod_hr":
      if ( _callOnChange_xjal ) {
        set_map_insulationLabel_cooldownPeriod_hr( (Map<OL_GridConnectionInsulationLabel, Double>) _value_xjal );
      } else {
        map_insulationLabel_cooldownPeriod_hr = (Map<OL_GridConnectionInsulationLabel, Double>) _value_xjal;
      }
      return true;
    case "p_avgHouseCookingMethod":
      if ( _callOnChange_xjal ) {
        set_p_avgHouseCookingMethod( (OL_HouseholdCookingMethod) _value_xjal );
      } else {
        p_avgHouseCookingMethod = (OL_HouseholdCookingMethod) _value_xjal;
      }
      return true;
    case "p_defaultNrOfSocketsPerCharger":
      if ( _callOnChange_xjal ) {
        set_p_defaultNrOfSocketsPerCharger( ((Number) _value_xjal).intValue() );
      } else {
        p_defaultNrOfSocketsPerCharger = ((Number) _value_xjal).intValue();
      }
      return true;
    case "map_avgCostOfEnergyCarrier_eurpkWh":
      if ( _callOnChange_xjal ) {
        set_map_avgCostOfEnergyCarrier_eurpkWh( (Map<Integer, Map<OL_EnergyCarriers, Double>>) _value_xjal );
      } else {
        map_avgCostOfEnergyCarrier_eurpkWh = (Map<Integer, Map<OL_EnergyCarriers, Double>>) _value_xjal;
      }
      return true;
    case "map_avgAssetSizeDependentCAPEX_eurpkW":
      if ( _callOnChange_xjal ) {
        set_map_avgAssetSizeDependentCAPEX_eurpkW( (Map<OL_EnergyAssetType, Double>) _value_xjal );
      } else {
        map_avgAssetSizeDependentCAPEX_eurpkW = (Map<OL_EnergyAssetType, Double>) _value_xjal;
      }
      return true;
    case "map_avgAssetLifeTime_yr":
      if ( _callOnChange_xjal ) {
        set_map_avgAssetLifeTime_yr( (Map<OL_EnergyAssetType, Double>) _value_xjal );
      } else {
        map_avgAssetLifeTime_yr = (Map<OL_EnergyAssetType, Double>) _value_xjal;
      }
      return true;
    case "map_avgAssetSizeDependentOPEX_eurpkWpyr":
      if ( _callOnChange_xjal ) {
        set_map_avgAssetSizeDependentOPEX_eurpkWpyr( (Map<OL_EnergyAssetType, Double>) _value_xjal );
      } else {
        map_avgAssetSizeDependentOPEX_eurpkWpyr = (Map<OL_EnergyAssetType, Double>) _value_xjal;
      }
      return true;
    case "map_gridOperatorTarrifs":
      if ( _callOnChange_xjal ) {
        set_map_gridOperatorTarrifs( (Map<OL_GridOperator, Map<Integer, Class<? extends I_GridOperatorTariffs>>>) _value_xjal );
      } else {
        map_gridOperatorTarrifs = (Map<OL_GridOperator, Map<Integer, Class<? extends I_GridOperatorTariffs>>>) _value_xjal;
      }
      return true;
    case "map_energyTaxesECImport_eurpkWh":
      if ( _callOnChange_xjal ) {
        set_map_energyTaxesECImport_eurpkWh( (Map<Integer, Map<OL_EnergyCarriers, Double>>) _value_xjal );
      } else {
        map_energyTaxesECImport_eurpkWh = (Map<Integer, Map<OL_EnergyCarriers, Double>>) _value_xjal;
      }
      return true;
    case "VAT_energy_fr":
      if ( _callOnChange_xjal ) {
        set_VAT_energy_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        VAT_energy_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "VAT_CAPEXAndOPEX_fr":
      if ( _callOnChange_xjal ) {
        set_VAT_CAPEXAndOPEX_fr( ((Number) _value_xjal).doubleValue() );
      } else {
        VAT_CAPEXAndOPEX_fr = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh":
      if ( _callOnChange_xjal ) {
        set_map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh( (Map<OL_EnergyCarriers, Double>) _value_xjal );
      } else {
        map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh = (Map<OL_EnergyCarriers, Double>) _value_xjal;
      }
      return true;
    case "p_defaultPVOrientation":
      if ( _callOnChange_xjal ) {
        set_p_defaultPVOrientation( (OL_PVOrientation) _value_xjal );
      } else {
        p_defaultPVOrientation = (OL_PVOrientation) _value_xjal;
      }
      return true;
    case "map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh":
      if ( _callOnChange_xjal ) {
        set_map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh( (Map<OL_EnergyCarriers, Double>) _value_xjal );
      } else {
        map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh = (Map<OL_EnergyCarriers, Double>) _value_xjal;
      }
      return true;
    case "p_reductionInEnergyTaxes_eurpyr":
      if ( _callOnChange_xjal ) {
        set_p_reductionInEnergyTaxes_eurpyr( (Map<Integer, Double>) _value_xjal );
      } else {
        p_reductionInEnergyTaxes_eurpyr = (Map<Integer, Double>) _value_xjal;
      }
      return true;
    case "map_bracketDependentEnergyTaxesECImport_eurpkWh":
      if ( _callOnChange_xjal ) {
        set_map_bracketDependentEnergyTaxesECImport_eurpkWh( (Map<Integer, Map<OL_EnergyCarriers, Map<OL_EnergyTaxesBracket, Double>>>) _value_xjal );
      } else {
        map_bracketDependentEnergyTaxesECImport_eurpkWh = (Map<Integer, Map<OL_EnergyCarriers, Map<OL_EnergyTaxesBracket, Double>>>) _value_xjal;
      }
      return true;
    case "map_avgAssetBaseCAPEX_eur":
      if ( _callOnChange_xjal ) {
        set_map_avgAssetBaseCAPEX_eur( (Map<OL_EnergyAssetType, Double>) _value_xjal );
      } else {
        map_avgAssetBaseCAPEX_eur = (Map<OL_EnergyAssetType, Double>) _value_xjal;
      }
      return true;
    case "map_avgAssetBaseOPEX_eurpyr":
      if ( _callOnChange_xjal ) {
        set_map_avgAssetBaseOPEX_eurpyr( (Map<OL_EnergyAssetType, Double>) _value_xjal );
      } else {
        map_avgAssetBaseOPEX_eurpyr = (Map<OL_EnergyAssetType, Double>) _value_xjal;
      }
      return true;
    default:
      return super.setParameter( _name_xjal, _value_xjal, _callOnChange_xjal );
    }
  }

  @Override
  public <T> T getParameter(String _name_xjal) {
    Object _result_xjal;
    switch ( _name_xjal ) {
    case "p_avgHouseConnectionCapacity_kW": _result_xjal = p_avgHouseConnectionCapacity_kW; break;
    case "p_avgHouseHeatingMethod": _result_xjal = p_avgHouseHeatingMethod; break;
    case "p_avgUtilityConnectionCapacity_kW": _result_xjal = p_avgUtilityConnectionCapacity_kW; break;
    case "p_avgUtilityHeatingMethod": _result_xjal = p_avgUtilityHeatingMethod; break;
    case "p_avgHouseElectricityConsumption_kWh_yr": _result_xjal = p_avgHouseElectricityConsumption_kWh_yr; break;
    case "p_avgHouseGasConsumption_m3_yr": _result_xjal = p_avgHouseGasConsumption_m3_yr; break;
    case "p_shareOfElectricVehicleOwnership": _result_xjal = p_shareOfElectricVehicleOwnership; break;
    case "p_ratioHouseInstalledPV": _result_xjal = p_ratioHouseInstalledPV; break;
    case "p_avgHousePVInstallationPower_kWp": _result_xjal = p_avgHousePVInstallationPower_kWp; break;
    case "p_avgEVStorageCar_kWh": _result_xjal = p_avgEVStorageCar_kWh; break;
    case "p_avgEVMaxChargePowerCar_kW": _result_xjal = p_avgEVMaxChargePowerCar_kW; break;
    case "p_avgEVStorageVan_kWh": _result_xjal = p_avgEVStorageVan_kWh; break;
    case "p_avgEVStorageTruck_kWh": _result_xjal = p_avgEVStorageTruck_kWh; break;
    case "p_avgEVMaxChargePowerVan_kW": _result_xjal = p_avgEVMaxChargePowerVan_kW; break;
    case "p_avgEVMaxChargePowerTruck_kW": _result_xjal = p_avgEVMaxChargePowerTruck_kW; break;
    case "p_avgEVEnergyConsumptionCar_kWhpkm": _result_xjal = p_avgEVEnergyConsumptionCar_kWhpkm; break;
    case "p_avgEVEnergyConsumptionVan_kWhpkm": _result_xjal = p_avgEVEnergyConsumptionVan_kWhpkm; break;
    case "p_avgEVEnergyConsumptionTruck_kWhpkm": _result_xjal = p_avgEVEnergyConsumptionTruck_kWhpkm; break;
    case "p_gas_kWhpm3": _result_xjal = p_gas_kWhpm3; break;
    case "p_hydrogenEnergyDensity_kWh_Nm3": _result_xjal = p_hydrogenEnergyDensity_kWh_Nm3; break;
    case "p_hydrogenDensity_kg_Nm3": _result_xjal = p_hydrogenDensity_kg_Nm3; break;
    case "p_oxygenDensity_kg_Nm3": _result_xjal = p_oxygenDensity_kg_Nm3; break;
    case "p_oxygenProduction_kgO2pkgH2": _result_xjal = p_oxygenProduction_kgO2pkgH2; break;
    case "p_hydrogenSpecificEnergy_kWh_kg": _result_xjal = p_hydrogenSpecificEnergy_kWh_kg; break;
    case "p_diesel_kWhpl": _result_xjal = p_diesel_kWhpl; break;
    case "p_avgDieselConsumptionCar_kmpl": _result_xjal = p_avgDieselConsumptionCar_kmpl; break;
    case "p_avgGasolineConsumptionCar_kmpl": _result_xjal = p_avgGasolineConsumptionCar_kmpl; break;
    case "p_gasoline_kWhpl": _result_xjal = p_gasoline_kWhpl; break;
    case "p_avgDieselConsumptionCar_kWhpkm": _result_xjal = p_avgDieselConsumptionCar_kWhpkm; break;
    case "p_avgGasolineConsumptionCar_kWhpkm": _result_xjal = p_avgGasolineConsumptionCar_kWhpkm; break;
    case "p_avgDieselConsumptionVan_kmpl": _result_xjal = p_avgDieselConsumptionVan_kmpl; break;
    case "p_avgDieselConsumptionVan_kWhpkm": _result_xjal = p_avgDieselConsumptionVan_kWhpkm; break;
    case "p_avgDieselConsumptionTruck_kmpl": _result_xjal = p_avgDieselConsumptionTruck_kmpl; break;
    case "p_avgDieselConsumptionTruck_kWhpkm": _result_xjal = p_avgDieselConsumptionTruck_kWhpkm; break;
    case "p_avgCOPHeatpump": _result_xjal = p_avgCOPHeatpump; break;
    case "p_avgUtilityPVPower_kWp": _result_xjal = p_avgUtilityPVPower_kWp; break;
    case "p_ratioElectricTrucks": _result_xjal = p_ratioElectricTrucks; break;
    case "p_avgCompanyHeatingMethod": _result_xjal = p_avgCompanyHeatingMethod; break;
    case "p_avgPVPower_kWpm2": _result_xjal = p_avgPVPower_kWpm2; break;
    case "p_avgRatioBatteryCapacity_v_Power": _result_xjal = p_avgRatioBatteryCapacity_v_Power; break;
    case "p_avgHydrogenConsumptionCar_kWhpkm": _result_xjal = p_avgHydrogenConsumptionCar_kWhpkm; break;
    case "p_avgHydrogenConsumptionVan_kWhpkm": _result_xjal = p_avgHydrogenConsumptionVan_kWhpkm; break;
    case "p_avgHydrogenConsumptionTruck_kWhpkm": _result_xjal = p_avgHydrogenConsumptionTruck_kWhpkm; break;
    case "p_avgRatioRoofPotentialPV": _result_xjal = p_avgRatioRoofPotentialPV; break;
    case "p_avgEfficiencyHeatpump_fr": _result_xjal = p_avgEfficiencyHeatpump_fr; break;
    case "p_avgOutputTemperatureElectricHeatpump_degC": _result_xjal = p_avgOutputTemperatureElectricHeatpump_degC; break;
    case "p_avgEfficiencyGasBurner_fr": _result_xjal = p_avgEfficiencyGasBurner_fr; break;
    case "p_avgOutputTemperatureGasBurner_degC": _result_xjal = p_avgOutputTemperatureGasBurner_degC; break;
    case "p_avgEfficiencyHydrogenBurner_fr": _result_xjal = p_avgEfficiencyHydrogenBurner_fr; break;
    case "p_avgOutputTemperatureHydrogenBurner_degC": _result_xjal = p_avgOutputTemperatureHydrogenBurner_degC; break;
    case "p_defaultNrOfVehiclesPerChargerSocket": _result_xjal = p_defaultNrOfVehiclesPerChargerSocket; break;
    case "p_avgAnnualTravelDistanceVan_km": _result_xjal = p_avgAnnualTravelDistanceVan_km; break;
    case "p_avgAnnualTravelDistanceCompanyCar_km": _result_xjal = p_avgAnnualTravelDistanceCompanyCar_km; break;
    case "p_avgAnnualTravelDistanceTruck_km": _result_xjal = p_avgAnnualTravelDistanceTruck_km; break;
    case "p_avgFullLoadHoursPV_hr": _result_xjal = p_avgFullLoadHoursPV_hr; break;
    case "p_avgCompanyElectricityConsumption_kWhpm2": _result_xjal = p_avgCompanyElectricityConsumption_kWhpm2; break;
    case "p_avgCompanyGasConsumption_m3pm2": _result_xjal = p_avgCompanyGasConsumption_m3pm2; break;
    case "p_avgCompanyHeatConsumption_kWhpm2": _result_xjal = p_avgCompanyHeatConsumption_kWhpm2; break;
    case "p_avgSolarFieldPower_kWppha": _result_xjal = p_avgSolarFieldPower_kWppha; break;
    case "p_avgEfficiencyCHP_thermal_fr": _result_xjal = p_avgEfficiencyCHP_thermal_fr; break;
    case "p_avgEfficiencyCHP_electric_fr": _result_xjal = p_avgEfficiencyCHP_electric_fr; break;
    case "p_avgOutputTemperatureCHP_degC": _result_xjal = p_avgOutputTemperatureCHP_degC; break;
    case "p_avgEfficiencyDistrictHeatingDeliverySet_fr": _result_xjal = p_avgEfficiencyDistrictHeatingDeliverySet_fr; break;
    case "p_avgOutputTemperatureDistrictHeatingDeliverySet_degC": _result_xjal = p_avgOutputTemperatureDistrictHeatingDeliverySet_degC; break;
    case "p_v2gProbability": _result_xjal = p_v2gProbability; break;
    case "p_v1gProbability": _result_xjal = p_v1gProbability; break;
    case "p_avgPTPower_kWpm2": _result_xjal = p_avgPTPower_kWpm2; break;
    case "p_avgHeatBufferWaterVolumePerHPPower_m3pkW": _result_xjal = p_avgHeatBufferWaterVolumePerHPPower_m3pkW; break;
    case "p_avgHeatBufferWaterVolumePerPTSurface_m3pm2": _result_xjal = p_avgHeatBufferWaterVolumePerPTSurface_m3pm2; break;
    case "p_waterHeatCapacity_JpkgK": _result_xjal = p_waterHeatCapacity_JpkgK; break;
    case "p_waterDensity_kgpm3": _result_xjal = p_waterDensity_kgpm3; break;
    case "p_avgMaxHeatBufferTemperature_degC": _result_xjal = p_avgMaxHeatBufferTemperature_degC; break;
    case "p_avgMinHeatBufferTemperature_degC": _result_xjal = p_avgMinHeatBufferTemperature_degC; break;
    case "p_avgPTPanelSize_m2": _result_xjal = p_avgPTPanelSize_m2; break;
    case "p_avgRatioHouseBatteryStorageCapacity_v_PVPower": _result_xjal = p_avgRatioHouseBatteryStorageCapacity_v_PVPower; break;
    case "p_avgNrOfCarsPerHouse": _result_xjal = p_avgNrOfCarsPerHouse; break;
    case "p_avgAnnualTravelDistancePrivateCar_km": _result_xjal = p_avgAnnualTravelDistancePrivateCar_km; break;
    case "p_avgAnnualTravelDistanceSecondVSFirstCar_fr": _result_xjal = p_avgAnnualTravelDistanceSecondVSFirstCar_fr; break;
    case "map_yearlySummerWinterTimeStartHour": _result_xjal = map_yearlySummerWinterTimeStartHour; break;
    case "p_minHeatpumpElectricCapacity_kW": _result_xjal = p_minHeatpumpElectricCapacity_kW; break;
    case "p_minGasBurnerOutputCapacity_kW": _result_xjal = p_minGasBurnerOutputCapacity_kW; break;
    case "p_minHydrogenBurnerOutputCapacity_kW": _result_xjal = p_minHydrogenBurnerOutputCapacity_kW; break;
    case "p_minDistrictHeatingDeliverySetOutputCapacity_kW": _result_xjal = p_minDistrictHeatingDeliverySetOutputCapacity_kW; break;
    case "p_avgOutputTemperatureHybridHeatpump_degC": _result_xjal = p_avgOutputTemperatureHybridHeatpump_degC; break;
    case "p_minAnnualTravelDistanceSurveyVehicle_km": _result_xjal = p_minAnnualTravelDistanceSurveyVehicle_km; break;
    case "p_PBL_HeatingLossFactor_fr": _result_xjal = p_PBL_HeatingLossFactor_fr; break;
    case "map_insulationLabel_lossfactorPerFloorSurface_WpKm2": _result_xjal = map_insulationLabel_lossfactorPerFloorSurface_WpKm2; break;
    case "p_solarAbsorptionFloorSurfaceScalingFactor_fr": _result_xjal = p_solarAbsorptionFloorSurfaceScalingFactor_fr; break;
    case "p_avgSpaceHeatingTotalGasConsumptionShare_fr": _result_xjal = p_avgSpaceHeatingTotalGasConsumptionShare_fr; break;
    case "p_avgCookingTotalGasConsumptionShare_fr": _result_xjal = p_avgCookingTotalGasConsumptionShare_fr; break;
    case "p_avgDHWTotalGasConsumptionShare_fr": _result_xjal = p_avgDHWTotalGasConsumptionShare_fr; break;
    case "p_heatCapacitySizingConstant_JpK": _result_xjal = p_heatCapacitySizingConstant_JpK; break;
    case "p_heatCapacitySizingSlope_JpKm2": _result_xjal = p_heatCapacitySizingSlope_JpKm2; break;
    case "p_heatCapacitySizingFactor_fr": _result_xjal = p_heatCapacitySizingFactor_fr; break;
    case "p_maxAvgHouseElectricityConsumptionOffset_kWhpa": _result_xjal = p_maxAvgHouseElectricityConsumptionOffset_kWhpa; break;
    case "p_maxAvgHouseGasConsumptionOffset_m3pa": _result_xjal = p_maxAvgHouseGasConsumptionOffset_m3pa; break;
    case "map_insulationLabel_cooldownPeriod_hr": _result_xjal = map_insulationLabel_cooldownPeriod_hr; break;
    case "p_avgHouseCookingMethod": _result_xjal = p_avgHouseCookingMethod; break;
    case "p_defaultNrOfSocketsPerCharger": _result_xjal = p_defaultNrOfSocketsPerCharger; break;
    case "map_avgCostOfEnergyCarrier_eurpkWh": _result_xjal = map_avgCostOfEnergyCarrier_eurpkWh; break;
    case "map_avgAssetSizeDependentCAPEX_eurpkW": _result_xjal = map_avgAssetSizeDependentCAPEX_eurpkW; break;
    case "map_avgAssetLifeTime_yr": _result_xjal = map_avgAssetLifeTime_yr; break;
    case "map_avgAssetSizeDependentOPEX_eurpkWpyr": _result_xjal = map_avgAssetSizeDependentOPEX_eurpkWpyr; break;
    case "map_gridOperatorTarrifs": _result_xjal = map_gridOperatorTarrifs; break;
    case "map_energyTaxesECImport_eurpkWh": _result_xjal = map_energyTaxesECImport_eurpkWh; break;
    case "VAT_energy_fr": _result_xjal = VAT_energy_fr; break;
    case "VAT_CAPEXAndOPEX_fr": _result_xjal = VAT_CAPEXAndOPEX_fr; break;
    case "map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh": _result_xjal = map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh; break;
    case "p_defaultPVOrientation": _result_xjal = p_defaultPVOrientation; break;
    case "map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh": _result_xjal = map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh; break;
    case "p_reductionInEnergyTaxes_eurpyr": _result_xjal = p_reductionInEnergyTaxes_eurpyr; break;
    case "map_bracketDependentEnergyTaxesECImport_eurpkWh": _result_xjal = map_bracketDependentEnergyTaxesECImport_eurpkWh; break;
    case "map_avgAssetBaseCAPEX_eur": _result_xjal = map_avgAssetBaseCAPEX_eur; break;
    case "map_avgAssetBaseOPEX_eurpyr": _result_xjal = map_avgAssetBaseOPEX_eurpyr; break;
    default: _result_xjal = super.getParameter( _name_xjal ); break;
    }
    return (T) _result_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private static String[] _parameterNames_xjal;

  @Override
  public String[] getParameterNames() {
    String[] result = _parameterNames_xjal;
    if (result == null) {
      List<String> list = new ArrayList<>( Arrays.asList( super.getParameterNames() ) );
      list.add( "p_avgHouseConnectionCapacity_kW" );
      list.add( "p_avgHouseHeatingMethod" );
      list.add( "p_avgUtilityConnectionCapacity_kW" );
      list.add( "p_avgUtilityHeatingMethod" );
      list.add( "p_avgHouseElectricityConsumption_kWh_yr" );
      list.add( "p_avgHouseGasConsumption_m3_yr" );
      list.add( "p_shareOfElectricVehicleOwnership" );
      list.add( "p_ratioHouseInstalledPV" );
      list.add( "p_avgHousePVInstallationPower_kWp" );
      list.add( "p_avgEVStorageCar_kWh" );
      list.add( "p_avgEVMaxChargePowerCar_kW" );
      list.add( "p_avgEVStorageVan_kWh" );
      list.add( "p_avgEVStorageTruck_kWh" );
      list.add( "p_avgEVMaxChargePowerVan_kW" );
      list.add( "p_avgEVMaxChargePowerTruck_kW" );
      list.add( "p_avgEVEnergyConsumptionCar_kWhpkm" );
      list.add( "p_avgEVEnergyConsumptionVan_kWhpkm" );
      list.add( "p_avgEVEnergyConsumptionTruck_kWhpkm" );
      list.add( "p_gas_kWhpm3" );
      list.add( "p_hydrogenEnergyDensity_kWh_Nm3" );
      list.add( "p_hydrogenDensity_kg_Nm3" );
      list.add( "p_oxygenDensity_kg_Nm3" );
      list.add( "p_oxygenProduction_kgO2pkgH2" );
      list.add( "p_hydrogenSpecificEnergy_kWh_kg" );
      list.add( "p_diesel_kWhpl" );
      list.add( "p_avgDieselConsumptionCar_kmpl" );
      list.add( "p_avgGasolineConsumptionCar_kmpl" );
      list.add( "p_gasoline_kWhpl" );
      list.add( "p_avgDieselConsumptionCar_kWhpkm" );
      list.add( "p_avgGasolineConsumptionCar_kWhpkm" );
      list.add( "p_avgDieselConsumptionVan_kmpl" );
      list.add( "p_avgDieselConsumptionVan_kWhpkm" );
      list.add( "p_avgDieselConsumptionTruck_kmpl" );
      list.add( "p_avgDieselConsumptionTruck_kWhpkm" );
      list.add( "p_avgCOPHeatpump" );
      list.add( "p_avgUtilityPVPower_kWp" );
      list.add( "p_ratioElectricTrucks" );
      list.add( "p_avgCompanyHeatingMethod" );
      list.add( "p_avgPVPower_kWpm2" );
      list.add( "p_avgRatioBatteryCapacity_v_Power" );
      list.add( "p_avgHydrogenConsumptionCar_kWhpkm" );
      list.add( "p_avgHydrogenConsumptionVan_kWhpkm" );
      list.add( "p_avgHydrogenConsumptionTruck_kWhpkm" );
      list.add( "p_avgRatioRoofPotentialPV" );
      list.add( "p_avgEfficiencyHeatpump_fr" );
      list.add( "p_avgOutputTemperatureElectricHeatpump_degC" );
      list.add( "p_avgEfficiencyGasBurner_fr" );
      list.add( "p_avgOutputTemperatureGasBurner_degC" );
      list.add( "p_avgEfficiencyHydrogenBurner_fr" );
      list.add( "p_avgOutputTemperatureHydrogenBurner_degC" );
      list.add( "p_defaultNrOfVehiclesPerChargerSocket" );
      list.add( "p_avgAnnualTravelDistanceVan_km" );
      list.add( "p_avgAnnualTravelDistanceCompanyCar_km" );
      list.add( "p_avgAnnualTravelDistanceTruck_km" );
      list.add( "p_avgFullLoadHoursPV_hr" );
      list.add( "p_avgCompanyElectricityConsumption_kWhpm2" );
      list.add( "p_avgCompanyGasConsumption_m3pm2" );
      list.add( "p_avgCompanyHeatConsumption_kWhpm2" );
      list.add( "p_avgSolarFieldPower_kWppha" );
      list.add( "p_avgEfficiencyCHP_thermal_fr" );
      list.add( "p_avgEfficiencyCHP_electric_fr" );
      list.add( "p_avgOutputTemperatureCHP_degC" );
      list.add( "p_avgEfficiencyDistrictHeatingDeliverySet_fr" );
      list.add( "p_avgOutputTemperatureDistrictHeatingDeliverySet_degC" );
      list.add( "p_v2gProbability" );
      list.add( "p_v1gProbability" );
      list.add( "p_avgPTPower_kWpm2" );
      list.add( "p_avgHeatBufferWaterVolumePerHPPower_m3pkW" );
      list.add( "p_avgHeatBufferWaterVolumePerPTSurface_m3pm2" );
      list.add( "p_waterHeatCapacity_JpkgK" );
      list.add( "p_waterDensity_kgpm3" );
      list.add( "p_avgMaxHeatBufferTemperature_degC" );
      list.add( "p_avgMinHeatBufferTemperature_degC" );
      list.add( "p_avgPTPanelSize_m2" );
      list.add( "p_avgRatioHouseBatteryStorageCapacity_v_PVPower" );
      list.add( "p_avgNrOfCarsPerHouse" );
      list.add( "p_avgAnnualTravelDistancePrivateCar_km" );
      list.add( "p_avgAnnualTravelDistanceSecondVSFirstCar_fr" );
      list.add( "map_yearlySummerWinterTimeStartHour" );
      list.add( "p_minHeatpumpElectricCapacity_kW" );
      list.add( "p_minGasBurnerOutputCapacity_kW" );
      list.add( "p_minHydrogenBurnerOutputCapacity_kW" );
      list.add( "p_minDistrictHeatingDeliverySetOutputCapacity_kW" );
      list.add( "p_avgOutputTemperatureHybridHeatpump_degC" );
      list.add( "p_minAnnualTravelDistanceSurveyVehicle_km" );
      list.add( "p_PBL_HeatingLossFactor_fr" );
      list.add( "map_insulationLabel_lossfactorPerFloorSurface_WpKm2" );
      list.add( "p_solarAbsorptionFloorSurfaceScalingFactor_fr" );
      list.add( "p_avgSpaceHeatingTotalGasConsumptionShare_fr" );
      list.add( "p_avgCookingTotalGasConsumptionShare_fr" );
      list.add( "p_avgDHWTotalGasConsumptionShare_fr" );
      list.add( "p_heatCapacitySizingConstant_JpK" );
      list.add( "p_heatCapacitySizingSlope_JpKm2" );
      list.add( "p_heatCapacitySizingFactor_fr" );
      list.add( "p_maxAvgHouseElectricityConsumptionOffset_kWhpa" );
      list.add( "p_maxAvgHouseGasConsumptionOffset_m3pa" );
      list.add( "map_insulationLabel_cooldownPeriod_hr" );
      list.add( "p_avgHouseCookingMethod" );
      list.add( "p_defaultNrOfSocketsPerCharger" );
      list.add( "map_avgCostOfEnergyCarrier_eurpkWh" );
      list.add( "map_avgAssetSizeDependentCAPEX_eurpkW" );
      list.add( "map_avgAssetLifeTime_yr" );
      list.add( "map_avgAssetSizeDependentOPEX_eurpkWpyr" );
      list.add( "map_gridOperatorTarrifs" );
      list.add( "map_energyTaxesECImport_eurpkWh" );
      list.add( "VAT_energy_fr" );
      list.add( "VAT_CAPEXAndOPEX_fr" );
      list.add( "map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh" );
      list.add( "p_defaultPVOrientation" );
      list.add( "map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh" );
      list.add( "p_reductionInEnergyTaxes_eurpyr" );
      list.add( "map_bracketDependentEnergyTaxesECImport_eurpkWh" );
      list.add( "map_avgAssetBaseCAPEX_eur" );
      list.add( "map_avgAssetBaseOPEX_eurpyr" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  /**
   * Hour of year per month (not leap year) --> Houdt dit rekening met zomer/winter tijd?
   */
  public 
double[] 
 monthStartHours_default;
  /**
   * Hour of year per month (leap year) --> Houdt dit rekening met zomer/winter tijd?
   */
  public 
double[] 
 monthStartHours_leapYear;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( AVGC_data.class );

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
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Functions

  public void f_setAVGC_data( OL_GridOperator gridOperator, int simulationYear ) { 

//Perform sanity checks on the values
f_sanityChecks();

//Create AVGC_data class, assign the values and send to the engine
J_AVGC_data dataAVGC = new J_AVGC_data();
zero_Loader.energyModel.avgc_data = dataAVGC;

////Averages
//House
dataAVGC.p_avgHouseGasConsumption_m3_yr = p_avgHouseGasConsumption_m3_yr;
dataAVGC.p_maxAvgHouseGasConsumptionOffset_m3pa = p_maxAvgHouseGasConsumptionOffset_m3pa;
dataAVGC.p_avgHouseElectricityConsumption_kWh_yr = p_avgHouseElectricityConsumption_kWh_yr;
dataAVGC.p_maxAvgHouseElectricityConsumptionOffset_kWhpa = p_maxAvgHouseElectricityConsumptionOffset_kWhpa;
dataAVGC.p_avgHouseConnectionCapacity_kW = p_avgHouseConnectionCapacity_kW;
dataAVGC.p_avgNrOfCarsPerHouse = p_avgNrOfCarsPerHouse;
dataAVGC.p_avgHouseHeatingMethod = p_avgHouseHeatingMethod;
dataAVGC.p_avgHouseCookingMethod = p_avgHouseCookingMethod;
dataAVGC.p_ratioEVHousePersonalCars = p_shareOfElectricVehicleOwnership;
dataAVGC.p_avgHousePVInstallationPower_kWp = p_avgHousePVInstallationPower_kWp;
dataAVGC.p_ratioHouseInstalledPV = p_ratioHouseInstalledPV;
dataAVGC.p_avgRatioHouseBatteryStorageCapacity_v_PVPower = p_avgRatioHouseBatteryStorageCapacity_v_PVPower;

dataAVGC.p_avgSpaceHeatingTotalGasConsumptionShare_fr = p_avgSpaceHeatingTotalGasConsumptionShare_fr;
dataAVGC.p_avgDHWTotalGasConsumptionShare_fr = p_avgDHWTotalGasConsumptionShare_fr;
dataAVGC.p_avgCookingTotalGasConsumptionShare_fr = p_avgCookingTotalGasConsumptionShare_fr;


//Utilities
dataAVGC.p_avgUtilityHeatingMethod = p_avgUtilityHeatingMethod;
dataAVGC.p_avgUtilityConnectionCapacity_kW = p_avgUtilityConnectionCapacity_kW;
dataAVGC.p_avgUtilityPVPower_kWp = p_avgUtilityPVPower_kWp;
dataAVGC.p_ratioElectricTrucks = p_ratioElectricTrucks;
dataAVGC.p_avgCompanyHeatingMethod = p_avgCompanyHeatingMethod;
dataAVGC.p_avgCompanyElectricityConsumption_kWhpm2 = p_avgCompanyElectricityConsumption_kWhpm2;
dataAVGC.p_avgCompanyGasConsumption_m3pm2 = p_avgCompanyGasConsumption_m3pm2;
dataAVGC.p_avgCompanyHeatConsumption_kWhpm2 = p_avgCompanyHeatConsumption_kWhpm2;

//Vehicles
dataAVGC.p_avgEVMaxChargePowerCar_kW = p_avgEVMaxChargePowerCar_kW;
dataAVGC.p_avgEVMaxChargePowerVan_kW = p_avgEVMaxChargePowerVan_kW;
dataAVGC.p_avgEVMaxChargePowerTruck_kW = p_avgEVMaxChargePowerTruck_kW;
dataAVGC.p_avgEVStorageCar_kWh = p_avgEVStorageCar_kWh;
dataAVGC.p_avgEVStorageVan_kWh = p_avgEVStorageVan_kWh;
dataAVGC.p_avgEVStorageTruck_kWh = p_avgEVStorageTruck_kWh;
dataAVGC.p_avgEVEnergyConsumptionCar_kWhpkm = p_avgEVEnergyConsumptionCar_kWhpkm;
dataAVGC.p_avgEVEnergyConsumptionVan_kWhpkm = p_avgEVEnergyConsumptionVan_kWhpkm;
dataAVGC.p_avgEVEnergyConsumptionTruck_kWhpkm = p_avgEVEnergyConsumptionTruck_kWhpkm;
dataAVGC.p_avgDieselConsumptionCar_kmpl = p_avgDieselConsumptionCar_kmpl;
dataAVGC.p_avgGasolineConsumptionCar_kmpl = p_avgGasolineConsumptionCar_kmpl;
dataAVGC.p_avgDieselConsumptionCar_kWhpkm = p_avgDieselConsumptionCar_kWhpkm;
dataAVGC.p_avgGasolineConsumptionCar_kWhpkm = p_avgGasolineConsumptionCar_kWhpkm;
dataAVGC.p_avgDieselConsumptionVan_kmpl = p_avgDieselConsumptionVan_kmpl;
dataAVGC.p_avgDieselConsumptionVan_kWhpkm = p_avgDieselConsumptionVan_kWhpkm;
dataAVGC.p_avgDieselConsumptionTruck_kmpl = p_avgDieselConsumptionTruck_kmpl;
dataAVGC.p_avgDieselConsumptionTruck_kWhpkm = p_avgDieselConsumptionTruck_kWhpkm;
dataAVGC.p_avgHydrogenConsumptionCar_kWhpkm = p_avgHydrogenConsumptionCar_kWhpkm;
dataAVGC.p_avgHydrogenConsumptionVan_kWhpkm = p_avgHydrogenConsumptionVan_kWhpkm;
dataAVGC.p_avgHydrogenConsumptionTruck_kWhpkm = p_avgHydrogenConsumptionTruck_kWhpkm;

dataAVGC.p_v1gProbability = p_v1gProbability;
dataAVGC.p_v2gProbability = p_v2gProbability;
dataAVGC.p_defaultNrOfVehiclesPerChargerSocket = p_defaultNrOfVehiclesPerChargerSocket;
dataAVGC.p_defaultNrOfSocketsPerCharger = p_defaultNrOfSocketsPerCharger;

dataAVGC.p_avgAnnualTravelDistancePrivateCar_km = p_avgAnnualTravelDistancePrivateCar_km;
dataAVGC.p_avgAnnualTravelDistanceCompanyCar_km = p_avgAnnualTravelDistanceCompanyCar_km;
dataAVGC.p_avgAnnualTravelDistanceVan_km = p_avgAnnualTravelDistanceVan_km;
dataAVGC.p_avgAnnualTravelDistanceTruck_km = p_avgAnnualTravelDistanceTruck_km;
dataAVGC.p_minAnnualTravelDistanceSurveyVehicle_km = p_minAnnualTravelDistanceSurveyVehicle_km;


//Heating assets
dataAVGC.p_avgCOPHeatpump = p_avgCOPHeatpump;
dataAVGC.p_avgEfficiencyHeatpump_fr = p_avgEfficiencyHeatpump_fr;
dataAVGC.p_avgOutputTemperatureElectricHeatpump_degC = p_avgOutputTemperatureElectricHeatpump_degC;
dataAVGC.p_avgOutputTemperatureHybridHeatpump_degC = p_avgOutputTemperatureHybridHeatpump_degC;
dataAVGC.p_minHeatpumpElectricCapacity_kW = p_minHeatpumpElectricCapacity_kW;

dataAVGC.p_avgEfficiencyGasBurner_fr = p_avgEfficiencyGasBurner_fr;
dataAVGC.p_avgOutputTemperatureGasBurner_degC = p_avgOutputTemperatureGasBurner_degC;
dataAVGC.p_minGasBurnerOutputCapacity_kW = p_minGasBurnerOutputCapacity_kW;

dataAVGC.p_avgEfficiencyHydrogenBurner_fr = p_avgEfficiencyHydrogenBurner_fr;
dataAVGC.p_avgOutputTemperatureHydrogenBurner_degC = p_avgOutputTemperatureHydrogenBurner_degC;
dataAVGC.p_minHydrogenBurnerOutputCapacity_kW = p_minHydrogenBurnerOutputCapacity_kW;

dataAVGC.p_avgEfficiencyDistrictHeatingDeliverySet_fr = p_avgEfficiencyDistrictHeatingDeliverySet_fr;
dataAVGC.p_avgOutputTemperatureDistrictHeatingDeliverySet_degC = p_avgOutputTemperatureDistrictHeatingDeliverySet_degC;
dataAVGC.p_minDistrictHeatingDeliverySetOutputCapacity_kW = p_minDistrictHeatingDeliverySetOutputCapacity_kW;

dataAVGC.p_avgEfficiencyCHP_thermal_fr = p_avgEfficiencyCHP_thermal_fr;
dataAVGC.p_avgEfficiencyCHP_electric_fr = p_avgEfficiencyCHP_electric_fr;
dataAVGC.p_avgOutputTemperatureCHP_degC = p_avgOutputTemperatureCHP_degC;

dataAVGC.p_avgPTPower_kWpm2 = p_avgPTPower_kWpm2;
dataAVGC.p_avgPTPanelSize_m2 = p_avgPTPanelSize_m2;

dataAVGC.p_avgMaxHeatBufferTemperature_degC = p_avgMaxHeatBufferTemperature_degC;
dataAVGC.p_avgMinHeatBufferTemperature_degC = p_avgMinHeatBufferTemperature_degC;
dataAVGC.p_avgHeatBufferWaterVolumePerPTSurface_m3pm2 = p_avgHeatBufferWaterVolumePerPTSurface_m3pm2;
dataAVGC.p_avgHeatBufferWaterVolumePerHPPower_m3pkW = p_avgHeatBufferWaterVolumePerHPPower_m3pkW;


//Electricity assets
dataAVGC.p_avgPVPower_kWpm2= p_avgPVPower_kWpm2;
dataAVGC.p_avgRatioRoofPotentialPV = p_avgRatioRoofPotentialPV;
dataAVGC.p_avgRatioBatteryCapacity_v_Power = p_avgRatioBatteryCapacity_v_Power;
dataAVGC.p_avgSolarFieldPower_kWppha = p_avgSolarFieldPower_kWppha;
dataAVGC.p_defaultPVOrientation = p_defaultPVOrientation;

//Thermal model parameters
dataAVGC.p_PBL_HeatingLossFactor_fr = p_PBL_HeatingLossFactor_fr;
dataAVGC.map_insulationLabel_lossfactorPerFloorSurface_WpKm2 = map_insulationLabel_lossfactorPerFloorSurface_WpKm2;
dataAVGC.p_solarAbsorptionFloorSurfaceScalingFactor_fr = p_solarAbsorptionFloorSurfaceScalingFactor_fr;
dataAVGC.map_insulationLabel_cooldownPeriod_hr = map_insulationLabel_cooldownPeriod_hr;
dataAVGC.p_heatCapacitySizingConstant_JpK = p_heatCapacitySizingConstant_JpK;
dataAVGC.p_heatCapacitySizingSlope_JpKm2 = p_heatCapacitySizingSlope_JpKm2;
dataAVGC.p_heatCapacitySizingFactor_fr = p_heatCapacitySizingFactor_fr;

//Emissions
dataAVGC.map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh = map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh;
dataAVGC.map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh = map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh;

////Constants
dataAVGC.p_gas_kWhpm3 = p_gas_kWhpm3;
dataAVGC.p_diesel_kWhpl = p_diesel_kWhpl;
dataAVGC.p_gasoline_kWhpl = p_gasoline_kWhpl;
dataAVGC.p_waterHeatCapacity_JpkgK = p_waterHeatCapacity_JpkgK;
dataAVGC.p_waterDensity_kgpm3 = p_waterDensity_kgpm3;
dataAVGC.p_hydrogenEnergyDensity_kWh_Nm3 = p_hydrogenEnergyDensity_kWh_Nm3;
dataAVGC.p_hydrogenSpecificEnergy_kWh_kg = p_hydrogenSpecificEnergy_kWh_kg;
dataAVGC.p_hydrogenDensity_kg_Nm3 = p_hydrogenDensity_kg_Nm3;
dataAVGC.p_oxygenDensity_kg_Nm3 = p_oxygenDensity_kg_Nm3;
dataAVGC.p_oxygenProduction_kgO2pkgH2 = p_oxygenProduction_kgO2pkgH2;

dataAVGC.economicAVGC = f_getEconomicAVGC(gridOperator, simulationYear); 
  }

  /**
   * Function where sanity checks can be implemented that will be performed when the data is send to the engine (start of model, after custom project parameters have been set).
   */
  void f_sanityChecks(  ) { 

if(p_avgSpaceHeatingTotalGasConsumptionShare_fr +
	p_avgCookingTotalGasConsumptionShare_fr +
	p_avgDHWTotalGasConsumptionShare_fr != 1){
throw new RuntimeException("Total average heating+dhw+cooking house gas consumption shares dont add up to 1");
} 
  }

  public 
J_AVGC_Economic_data 
 f_getEconomicAVGC( OL_GridOperator gridOperator, int year ) { 

J_AVGC_Economic_data economicAVGC = new J_AVGC_Economic_data();

//Energy costs
economicAVGC.setMap_avgCostOfEnergyCarrier_eurpkWh(map_avgCostOfEnergyCarrier_eurpkWh.get(year));
economicAVGC.setMap_energyTaxesECImport_eurpkWh(map_energyTaxesECImport_eurpkWh.get(year));
economicAVGC.setMap_bracketDependentEnergyTaxesECImport_eurpkWh(map_bracketDependentEnergyTaxesECImport_eurpkWh.get(year));
economicAVGC.setReductionInEnergyTaxes_eurpyr(p_reductionInEnergyTaxes_eurpyr.get(year));
economicAVGC.setVAT_energy_fr(VAT_energy_fr);

//CAPEX & OPEX
economicAVGC.setMap_avgAssetBaseCAPEX_eur(map_avgAssetBaseCAPEX_eur);
economicAVGC.setMap_avgAssetSizeDependentCAPEX_eurpkW(map_avgAssetSizeDependentCAPEX_eurpkW);
economicAVGC.setMap_avgAssetBaseOPEX_eurpyr(map_avgAssetBaseOPEX_eurpyr);
economicAVGC.setMap_avgAssetSizeDependentOPEX_eurpkWpyr(map_avgAssetSizeDependentOPEX_eurpkWpyr);
economicAVGC.setMap_avgAssetLifeTime_yr(map_avgAssetLifeTime_yr);
economicAVGC.setVAT_CAPEXAndOPEX_fr(VAT_CAPEXAndOPEX_fr);

//Grid operator tariffs
if(gridOperator != null){
	try {
		economicAVGC.setGridOperatorTariffs(map_gridOperatorTarrifs.get(gridOperator).get(year).getDeclaredConstructor().newInstance());
	}
	catch (Exception e) {
		traceln("No gridOperatorTariffs sheet found for this GridOperator ( " + gridOperator + " ) and/or simulation year ( " + year + " ) -> Connection costs chart won't be supported.");
	}
}
else{
	traceln("No GridOperator found -> Connection costs chart won't be supported.");
}
return economicAVGC; 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1920.0, 980.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_houses_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_avgCompanies_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_avgEV_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = new Font("SansSerif", 1, 24 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_hydrogenC_Font = new Font("SansSerif", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_avgFossil_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_Heatassets_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_avgPV_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_avgBat_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_avgFCV_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_heatpumps_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_gasburners_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_hydrogenburners_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_valuesToEngine_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_timeC_Font = new Font("SansSerif", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_avgTravelDistances_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_CHP_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_districtHeatingDeliverySet_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_avgHeatBuffer_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_avgPT_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_thermalModelParameters_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_economicAVGC_Font = _txt_hydrogenC_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_avgEmissions_Font = _txt_houses_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_constants = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_avg = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_houses = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_avgCompanies = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_avgEV = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_hydrogenC = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_hydrogenC = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_avgFossil = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_Heatassets = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_avgPV = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_avgBat = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_avgFCV = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_heatpumps = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_gasburners = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_hydrogenburners = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_sendToEngine = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_valuesToEngine = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_timeC = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_avgTravelDistances = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_CHP = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_districtHeatingDeliverySet = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_avgHeatBuffer = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_avgPT = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_thermalModelParameters = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_economicAVGC = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_economicAVGC = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_avgEmissions = 31;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 32;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rect_constants, rect_avg, txt_houses, txt_avgCompanies, txt_avgEV, text3, text4, text5, rect_hydrogenC, txt_hydrogenC, txt_avgFossil, txt_Heatassets, txt_avgPV, txt_avgBat, txt_avgFCV, txt_heatpumps, txt_gasburners, txt_hydrogenburners, rect_sendToEngine, txt_valuesToEngine, txt_timeC, text, txt_avgTravelDistances, txt_CHP, txt_districtHeatingDeliverySet, txt_avgHeatBuffer, txt_avgPT, txt_thermalModelParameters, rect_economicAVGC, txt_economicAVGC, txt_avgEmissions);
  }

  protected ShapeRectangle rect_constants;
  protected ShapeRectangle rect_avg;
  protected ShapeText txt_houses;
  protected ShapeText txt_avgCompanies;
  protected ShapeText txt_avgEV;
  protected ShapeText text3;
  protected ShapeText text4;
  protected ShapeText text5;
  protected ShapeRectangle rect_hydrogenC;
  protected ShapeText txt_hydrogenC;
  protected ShapeText txt_avgFossil;
  protected ShapeText txt_Heatassets;
  protected ShapeText txt_avgPV;
  protected ShapeText txt_avgBat;
  protected ShapeText txt_avgFCV;
  protected ShapeText txt_heatpumps;
  protected ShapeText txt_gasburners;
  protected ShapeText txt_hydrogenburners;
  protected ShapeRectangle rect_sendToEngine;
  protected ShapeText txt_valuesToEngine;
  protected ShapeText txt_timeC;
  protected ShapeText text;
  protected ShapeText txt_avgTravelDistances;
  protected ShapeText txt_CHP;
  protected ShapeText txt_districtHeatingDeliverySet;
  protected ShapeText txt_avgHeatBuffer;
  protected ShapeText txt_avgPT;
  protected ShapeText txt_thermalModelParameters;
  protected ShapeRectangle rect_economicAVGC;
  protected ShapeText txt_economicAVGC;
  protected ShapeText txt_avgEmissions;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rect_constants = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,1500.0, 0.0, 0.0, 0.0,
            black, white,
			416.894, 1400.0, 10.0, 3.0, LINE_STYLE_SOLID );
    rect_avg = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,0.0, 0.0, 0.0, 0.0,
            black, white,
			1500.0, 1400.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_houses = new ShapeText(
        SHAPE_DRAW_2D, false,40.0, 120.0, 0.0, 0.0,
        black,"Average values for houses",
        _txt_houses_Font, ALIGNMENT_LEFT );
    txt_avgCompanies = new ShapeText(
        SHAPE_DRAW_2D, false,40.0, 480.0, 0.0, 0.0,
        black,"Average values for companies/utilities",
        _txt_avgCompanies_Font, ALIGNMENT_LEFT );
    txt_avgEV = new ShapeText(
        SHAPE_DRAW_2D, false,1000.0, 115.0, 0.0, 0.0,
        black,"Average values for Electric Vehicles",
        _txt_avgEV_Font, ALIGNMENT_LEFT );
    text3 = new ShapeText(
        SHAPE_DRAW_2D, false,1680.0, 40.0, 0.0, 0.0,
        black,"Constants",
        _text3_Font, ALIGNMENT_CENTER );
    text4 = new ShapeText(
        SHAPE_DRAW_2D, false,1540.0, 240.0, 0.0, 0.0,
        black,"Energy conversion constants",
        _text4_Font, ALIGNMENT_LEFT );
    text5 = new ShapeText(
        SHAPE_DRAW_2D, false,750.0, 40.0, 0.0, 0.0,
        black,"Averages",
        _text5_Font, ALIGNMENT_CENTER );
    rect_hydrogenC = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,1540.0, 440.0, 0.0, 0.0,
            cyan, white,
			360.0, 200.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_hydrogenC = new ShapeText(
        SHAPE_DRAW_2D, false,1560.0, 460.0, 0.0, 0.0,
        black,"Hydrogen constants",
        _txt_hydrogenC_Font, ALIGNMENT_LEFT );
    txt_avgFossil = new ShapeText(
        SHAPE_DRAW_2D, false,1000.0, 400.0, 0.0, 0.0,
        black,"Average values for Fossil fueled vehicles",
        _txt_avgFossil_Font, ALIGNMENT_LEFT );
    txt_Heatassets = new ShapeText(
        SHAPE_DRAW_2D, true,500.0, 115.0, 0.0, 0.0,
        black,"Heat assets",
        _txt_Heatassets_Font, ALIGNMENT_LEFT );
    txt_avgPV = new ShapeText(
        SHAPE_DRAW_2D, true,510.0, 825.0, 0.0, 0.0,
        black,"PV panels",
        _txt_avgPV_Font, ALIGNMENT_LEFT );
    txt_avgBat = new ShapeText(
        SHAPE_DRAW_2D, true,510.0, 960.0, 0.0, 0.0,
        black,"Batteries",
        _txt_avgBat_Font, ALIGNMENT_LEFT );
    txt_avgFCV = new ShapeText(
        SHAPE_DRAW_2D, false,1000.0, 650.0, 0.0, 0.0,
        black,"Average values for Hydrogen vehicles",
        _txt_avgFCV_Font, ALIGNMENT_LEFT );
    txt_heatpumps = new ShapeText(
        SHAPE_DRAW_2D, true,520.0, 135.0, 0.0, 0.0,
        black,"Heatpumps",
        _txt_heatpumps_Font, ALIGNMENT_LEFT );
    txt_gasburners = new ShapeText(
        SHAPE_DRAW_2D, true,520.0, 265.0, 0.0, 0.0,
        black,"Gasburners",
        _txt_gasburners_Font, ALIGNMENT_LEFT );
    txt_hydrogenburners = new ShapeText(
        SHAPE_DRAW_2D, true,520.0, 355.0, 0.0, 0.0,
        black,"Hydrogenburners",
        _txt_hydrogenburners_Font, ALIGNMENT_LEFT );
    rect_sendToEngine = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,10.0, 10.0, 0.0, 0.0,
            red, white,
			260.0, 80.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_valuesToEngine = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 20.0, 0.0, 0.0,
        black,"Send values to Engine",
        _txt_valuesToEngine_Font, ALIGNMENT_LEFT );
    txt_timeC = new ShapeText(
        SHAPE_DRAW_2D, true,1540.0, 140.0, 0.0, 0.0,
        black,"Time constants",
        _txt_timeC_Font, ALIGNMENT_LEFT );
    text = new ShapeText(
        SHAPE_DRAW_2D, true,1000.0, 940.0, 0.0, 0.0,
        black,"Chargingcentres and chargepoints",
        _text_Font, ALIGNMENT_LEFT );
    txt_avgTravelDistances = new ShapeText(
        SHAPE_DRAW_2D, true,1000.0, 740.0, 0.0, 0.0,
        black,"Average travel distances per vehicle type",
        _txt_avgTravelDistances_Font, ALIGNMENT_LEFT );
    txt_CHP = new ShapeText(
        SHAPE_DRAW_2D, true,520.0, 445.0, 0.0, 0.0,
        black,"CHP",
        _txt_CHP_Font, ALIGNMENT_LEFT );
    txt_districtHeatingDeliverySet = new ShapeText(
        SHAPE_DRAW_2D, true,520.0, 535.0, 0.0, 0.0,
        black,"District Heating delivery set",
        _txt_districtHeatingDeliverySet_Font, ALIGNMENT_LEFT );
    txt_avgHeatBuffer = new ShapeText(
        SHAPE_DRAW_2D, true,520.0, 690.0, 0.0, 0.0,
        black,"Heat Buffer",
        _txt_avgHeatBuffer_Font, ALIGNMENT_LEFT );
    txt_avgPT = new ShapeText(
        SHAPE_DRAW_2D, true,520.0, 620.0, 0.0, 0.0,
        black,"PT panels",
        _txt_avgPT_Font, ALIGNMENT_LEFT );
    txt_thermalModelParameters = new ShapeText(
        SHAPE_DRAW_2D, true,510.0, 1030.0, 0.0, 0.0,
        black,"Thermal model parameters",
        _txt_thermalModelParameters_Font, ALIGNMENT_LEFT );
    rect_economicAVGC = new ShapeRectangle(
       SHAPE_DRAW_2D3D, false,1920.0, 0.0, 0.0, 0.0,
            lime, white,
			680.0, 600.0, 10.0, 3.0, LINE_STYLE_SOLID );
    txt_economicAVGC = new ShapeText(
        SHAPE_DRAW_2D, false,1950.0, 20.0, 0.0, 0.0,
        black,"Economic AVGC",
        _txt_economicAVGC_Font, ALIGNMENT_LEFT );
    txt_avgEmissions = new ShapeText(
        SHAPE_DRAW_2D, false,1000.0, 1040.0, 0.0, 0.0,
        black,"Average values for CO2 emissions",
        _txt_avgEmissions_Font, ALIGNMENT_LEFT );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }



  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
    _createPersistentElementsBP0_xjal();
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

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
  public AVGC_data( Engine engine, Agent owner, AgentList<? extends AVGC_data> ownerPopulation ) {
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
    zero_Loader = get_Zero_Loader();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public AVGC_data() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public AVGC_data( double p_avgHouseConnectionCapacity_kW, OL_GridConnectionHeatingType p_avgHouseHeatingMethod, double p_avgUtilityConnectionCapacity_kW, OL_GridConnectionHeatingType p_avgUtilityHeatingMethod, double p_avgHouseElectricityConsumption_kWh_yr, double p_avgHouseGasConsumption_m3_yr, double p_shareOfElectricVehicleOwnership, double p_ratioHouseInstalledPV, double p_avgHousePVInstallationPower_kWp, double p_avgEVStorageCar_kWh, double p_avgEVMaxChargePowerCar_kW, double p_avgEVStorageVan_kWh, double p_avgEVStorageTruck_kWh, double p_avgEVMaxChargePowerVan_kW, double p_avgEVMaxChargePowerTruck_kW, double p_avgEVEnergyConsumptionCar_kWhpkm, double p_avgEVEnergyConsumptionVan_kWhpkm, double p_avgEVEnergyConsumptionTruck_kWhpkm, double p_gas_kWhpm3, double p_hydrogenEnergyDensity_kWh_Nm3, double p_hydrogenDensity_kg_Nm3, double p_oxygenDensity_kg_Nm3, double p_oxygenProduction_kgO2pkgH2, double p_hydrogenSpecificEnergy_kWh_kg, double p_diesel_kWhpl, double p_avgDieselConsumptionCar_kmpl, double p_avgGasolineConsumptionCar_kmpl, double p_gasoline_kWhpl, double p_avgDieselConsumptionCar_kWhpkm, double p_avgGasolineConsumptionCar_kWhpkm, double p_avgDieselConsumptionVan_kmpl, double p_avgDieselConsumptionVan_kWhpkm, double p_avgDieselConsumptionTruck_kmpl, double p_avgDieselConsumptionTruck_kWhpkm, double p_avgCOPHeatpump, double p_avgUtilityPVPower_kWp, double p_ratioElectricTrucks, OL_GridConnectionHeatingType p_avgCompanyHeatingMethod, double p_avgPVPower_kWpm2, double p_avgRatioBatteryCapacity_v_Power, double p_avgHydrogenConsumptionCar_kWhpkm, double p_avgHydrogenConsumptionVan_kWhpkm, double p_avgHydrogenConsumptionTruck_kWhpkm, double p_avgRatioRoofPotentialPV, double p_avgEfficiencyHeatpump_fr, double p_avgOutputTemperatureElectricHeatpump_degC, double p_avgEfficiencyGasBurner_fr, double p_avgOutputTemperatureGasBurner_degC, double p_avgEfficiencyHydrogenBurner_fr, double p_avgOutputTemperatureHydrogenBurner_degC, int p_defaultNrOfVehiclesPerChargerSocket, double p_avgAnnualTravelDistanceVan_km, double p_avgAnnualTravelDistanceCompanyCar_km, double p_avgAnnualTravelDistanceTruck_km, double p_avgFullLoadHoursPV_hr, double p_avgCompanyElectricityConsumption_kWhpm2, double p_avgCompanyGasConsumption_m3pm2, double p_avgCompanyHeatConsumption_kWhpm2, double p_avgSolarFieldPower_kWppha, double p_avgEfficiencyCHP_thermal_fr, double p_avgEfficiencyCHP_electric_fr, double p_avgOutputTemperatureCHP_degC, double p_avgEfficiencyDistrictHeatingDeliverySet_fr, double p_avgOutputTemperatureDistrictHeatingDeliverySet_degC, double p_v2gProbability, double p_v1gProbability, double p_avgPTPower_kWpm2, double p_avgHeatBufferWaterVolumePerHPPower_m3pkW, double p_avgHeatBufferWaterVolumePerPTSurface_m3pm2, double p_waterHeatCapacity_JpkgK, double p_waterDensity_kgpm3, double p_avgMaxHeatBufferTemperature_degC, double p_avgMinHeatBufferTemperature_degC, double p_avgPTPanelSize_m2, double p_avgRatioHouseBatteryStorageCapacity_v_PVPower, double p_avgNrOfCarsPerHouse, double p_avgAnnualTravelDistancePrivateCar_km, double p_avgAnnualTravelDistanceSecondVSFirstCar_fr, Map<Integer, Pair<Double, Double>> map_yearlySummerWinterTimeStartHour, double p_minHeatpumpElectricCapacity_kW, double p_minGasBurnerOutputCapacity_kW, double p_minHydrogenBurnerOutputCapacity_kW, double p_minDistrictHeatingDeliverySetOutputCapacity_kW, double p_avgOutputTemperatureHybridHeatpump_degC, double p_minAnnualTravelDistanceSurveyVehicle_km, double p_PBL_HeatingLossFactor_fr, Map<OL_GridConnectionInsulationLabel, Double> map_insulationLabel_lossfactorPerFloorSurface_WpKm2, double p_solarAbsorptionFloorSurfaceScalingFactor_fr, double p_avgSpaceHeatingTotalGasConsumptionShare_fr, double p_avgCookingTotalGasConsumptionShare_fr, double p_avgDHWTotalGasConsumptionShare_fr, double p_heatCapacitySizingConstant_JpK, double p_heatCapacitySizingSlope_JpKm2, double p_heatCapacitySizingFactor_fr, double p_maxAvgHouseElectricityConsumptionOffset_kWhpa, double p_maxAvgHouseGasConsumptionOffset_m3pa, Map<OL_GridConnectionInsulationLabel, Double> map_insulationLabel_cooldownPeriod_hr, OL_HouseholdCookingMethod p_avgHouseCookingMethod, int p_defaultNrOfSocketsPerCharger, Map<Integer, Map<OL_EnergyCarriers, Double>> map_avgCostOfEnergyCarrier_eurpkWh, Map<OL_EnergyAssetType, Double> map_avgAssetSizeDependentCAPEX_eurpkW, Map<OL_EnergyAssetType, Double> map_avgAssetLifeTime_yr, Map<OL_EnergyAssetType, Double> map_avgAssetSizeDependentOPEX_eurpkWpyr, Map<OL_GridOperator, Map<Integer, Class<? extends I_GridOperatorTariffs>>> map_gridOperatorTarrifs, Map<Integer, Map<OL_EnergyCarriers, Double>> map_energyTaxesECImport_eurpkWh, double VAT_energy_fr, double VAT_CAPEXAndOPEX_fr, Map<OL_EnergyCarriers, Double> map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh, OL_PVOrientation p_defaultPVOrientation, Map<OL_EnergyCarriers, Double> map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh, Map<Integer, Double> p_reductionInEnergyTaxes_eurpyr, Map<Integer, Map<OL_EnergyCarriers, Map<OL_EnergyTaxesBracket, Double>>> map_bracketDependentEnergyTaxesECImport_eurpkWh, Map<OL_EnergyAssetType, Double> map_avgAssetBaseCAPEX_eur, Map<OL_EnergyAssetType, Double> map_avgAssetBaseOPEX_eurpyr ) {
    markParametersAreSet();
    this.p_avgHouseConnectionCapacity_kW = p_avgHouseConnectionCapacity_kW;
    this.p_avgHouseHeatingMethod = p_avgHouseHeatingMethod;
    this.p_avgUtilityConnectionCapacity_kW = p_avgUtilityConnectionCapacity_kW;
    this.p_avgUtilityHeatingMethod = p_avgUtilityHeatingMethod;
    this.p_avgHouseElectricityConsumption_kWh_yr = p_avgHouseElectricityConsumption_kWh_yr;
    this.p_avgHouseGasConsumption_m3_yr = p_avgHouseGasConsumption_m3_yr;
    this.p_shareOfElectricVehicleOwnership = p_shareOfElectricVehicleOwnership;
    this.p_ratioHouseInstalledPV = p_ratioHouseInstalledPV;
    this.p_avgHousePVInstallationPower_kWp = p_avgHousePVInstallationPower_kWp;
    this.p_avgEVStorageCar_kWh = p_avgEVStorageCar_kWh;
    this.p_avgEVMaxChargePowerCar_kW = p_avgEVMaxChargePowerCar_kW;
    this.p_avgEVStorageVan_kWh = p_avgEVStorageVan_kWh;
    this.p_avgEVStorageTruck_kWh = p_avgEVStorageTruck_kWh;
    this.p_avgEVMaxChargePowerVan_kW = p_avgEVMaxChargePowerVan_kW;
    this.p_avgEVMaxChargePowerTruck_kW = p_avgEVMaxChargePowerTruck_kW;
    this.p_avgEVEnergyConsumptionCar_kWhpkm = p_avgEVEnergyConsumptionCar_kWhpkm;
    this.p_avgEVEnergyConsumptionVan_kWhpkm = p_avgEVEnergyConsumptionVan_kWhpkm;
    this.p_avgEVEnergyConsumptionTruck_kWhpkm = p_avgEVEnergyConsumptionTruck_kWhpkm;
    this.p_gas_kWhpm3 = p_gas_kWhpm3;
    this.p_hydrogenEnergyDensity_kWh_Nm3 = p_hydrogenEnergyDensity_kWh_Nm3;
    this.p_hydrogenDensity_kg_Nm3 = p_hydrogenDensity_kg_Nm3;
    this.p_oxygenDensity_kg_Nm3 = p_oxygenDensity_kg_Nm3;
    this.p_oxygenProduction_kgO2pkgH2 = p_oxygenProduction_kgO2pkgH2;
    this.p_hydrogenSpecificEnergy_kWh_kg = p_hydrogenSpecificEnergy_kWh_kg;
    this.p_diesel_kWhpl = p_diesel_kWhpl;
    this.p_avgDieselConsumptionCar_kmpl = p_avgDieselConsumptionCar_kmpl;
    this.p_avgGasolineConsumptionCar_kmpl = p_avgGasolineConsumptionCar_kmpl;
    this.p_gasoline_kWhpl = p_gasoline_kWhpl;
    this.p_avgDieselConsumptionCar_kWhpkm = p_avgDieselConsumptionCar_kWhpkm;
    this.p_avgGasolineConsumptionCar_kWhpkm = p_avgGasolineConsumptionCar_kWhpkm;
    this.p_avgDieselConsumptionVan_kmpl = p_avgDieselConsumptionVan_kmpl;
    this.p_avgDieselConsumptionVan_kWhpkm = p_avgDieselConsumptionVan_kWhpkm;
    this.p_avgDieselConsumptionTruck_kmpl = p_avgDieselConsumptionTruck_kmpl;
    this.p_avgDieselConsumptionTruck_kWhpkm = p_avgDieselConsumptionTruck_kWhpkm;
    this.p_avgCOPHeatpump = p_avgCOPHeatpump;
    this.p_avgUtilityPVPower_kWp = p_avgUtilityPVPower_kWp;
    this.p_ratioElectricTrucks = p_ratioElectricTrucks;
    this.p_avgCompanyHeatingMethod = p_avgCompanyHeatingMethod;
    this.p_avgPVPower_kWpm2 = p_avgPVPower_kWpm2;
    this.p_avgRatioBatteryCapacity_v_Power = p_avgRatioBatteryCapacity_v_Power;
    this.p_avgHydrogenConsumptionCar_kWhpkm = p_avgHydrogenConsumptionCar_kWhpkm;
    this.p_avgHydrogenConsumptionVan_kWhpkm = p_avgHydrogenConsumptionVan_kWhpkm;
    this.p_avgHydrogenConsumptionTruck_kWhpkm = p_avgHydrogenConsumptionTruck_kWhpkm;
    this.p_avgRatioRoofPotentialPV = p_avgRatioRoofPotentialPV;
    this.p_avgEfficiencyHeatpump_fr = p_avgEfficiencyHeatpump_fr;
    this.p_avgOutputTemperatureElectricHeatpump_degC = p_avgOutputTemperatureElectricHeatpump_degC;
    this.p_avgEfficiencyGasBurner_fr = p_avgEfficiencyGasBurner_fr;
    this.p_avgOutputTemperatureGasBurner_degC = p_avgOutputTemperatureGasBurner_degC;
    this.p_avgEfficiencyHydrogenBurner_fr = p_avgEfficiencyHydrogenBurner_fr;
    this.p_avgOutputTemperatureHydrogenBurner_degC = p_avgOutputTemperatureHydrogenBurner_degC;
    this.p_defaultNrOfVehiclesPerChargerSocket = p_defaultNrOfVehiclesPerChargerSocket;
    this.p_avgAnnualTravelDistanceVan_km = p_avgAnnualTravelDistanceVan_km;
    this.p_avgAnnualTravelDistanceCompanyCar_km = p_avgAnnualTravelDistanceCompanyCar_km;
    this.p_avgAnnualTravelDistanceTruck_km = p_avgAnnualTravelDistanceTruck_km;
    this.p_avgFullLoadHoursPV_hr = p_avgFullLoadHoursPV_hr;
    this.p_avgCompanyElectricityConsumption_kWhpm2 = p_avgCompanyElectricityConsumption_kWhpm2;
    this.p_avgCompanyGasConsumption_m3pm2 = p_avgCompanyGasConsumption_m3pm2;
    this.p_avgCompanyHeatConsumption_kWhpm2 = p_avgCompanyHeatConsumption_kWhpm2;
    this.p_avgSolarFieldPower_kWppha = p_avgSolarFieldPower_kWppha;
    this.p_avgEfficiencyCHP_thermal_fr = p_avgEfficiencyCHP_thermal_fr;
    this.p_avgEfficiencyCHP_electric_fr = p_avgEfficiencyCHP_electric_fr;
    this.p_avgOutputTemperatureCHP_degC = p_avgOutputTemperatureCHP_degC;
    this.p_avgEfficiencyDistrictHeatingDeliverySet_fr = p_avgEfficiencyDistrictHeatingDeliverySet_fr;
    this.p_avgOutputTemperatureDistrictHeatingDeliverySet_degC = p_avgOutputTemperatureDistrictHeatingDeliverySet_degC;
    this.p_v2gProbability = p_v2gProbability;
    this.p_v1gProbability = p_v1gProbability;
    this.p_avgPTPower_kWpm2 = p_avgPTPower_kWpm2;
    this.p_avgHeatBufferWaterVolumePerHPPower_m3pkW = p_avgHeatBufferWaterVolumePerHPPower_m3pkW;
    this.p_avgHeatBufferWaterVolumePerPTSurface_m3pm2 = p_avgHeatBufferWaterVolumePerPTSurface_m3pm2;
    this.p_waterHeatCapacity_JpkgK = p_waterHeatCapacity_JpkgK;
    this.p_waterDensity_kgpm3 = p_waterDensity_kgpm3;
    this.p_avgMaxHeatBufferTemperature_degC = p_avgMaxHeatBufferTemperature_degC;
    this.p_avgMinHeatBufferTemperature_degC = p_avgMinHeatBufferTemperature_degC;
    this.p_avgPTPanelSize_m2 = p_avgPTPanelSize_m2;
    this.p_avgRatioHouseBatteryStorageCapacity_v_PVPower = p_avgRatioHouseBatteryStorageCapacity_v_PVPower;
    this.p_avgNrOfCarsPerHouse = p_avgNrOfCarsPerHouse;
    this.p_avgAnnualTravelDistancePrivateCar_km = p_avgAnnualTravelDistancePrivateCar_km;
    this.p_avgAnnualTravelDistanceSecondVSFirstCar_fr = p_avgAnnualTravelDistanceSecondVSFirstCar_fr;
    this.map_yearlySummerWinterTimeStartHour = map_yearlySummerWinterTimeStartHour;
    this.p_minHeatpumpElectricCapacity_kW = p_minHeatpumpElectricCapacity_kW;
    this.p_minGasBurnerOutputCapacity_kW = p_minGasBurnerOutputCapacity_kW;
    this.p_minHydrogenBurnerOutputCapacity_kW = p_minHydrogenBurnerOutputCapacity_kW;
    this.p_minDistrictHeatingDeliverySetOutputCapacity_kW = p_minDistrictHeatingDeliverySetOutputCapacity_kW;
    this.p_avgOutputTemperatureHybridHeatpump_degC = p_avgOutputTemperatureHybridHeatpump_degC;
    this.p_minAnnualTravelDistanceSurveyVehicle_km = p_minAnnualTravelDistanceSurveyVehicle_km;
    this.p_PBL_HeatingLossFactor_fr = p_PBL_HeatingLossFactor_fr;
    this.map_insulationLabel_lossfactorPerFloorSurface_WpKm2 = map_insulationLabel_lossfactorPerFloorSurface_WpKm2;
    this.p_solarAbsorptionFloorSurfaceScalingFactor_fr = p_solarAbsorptionFloorSurfaceScalingFactor_fr;
    this.p_avgSpaceHeatingTotalGasConsumptionShare_fr = p_avgSpaceHeatingTotalGasConsumptionShare_fr;
    this.p_avgCookingTotalGasConsumptionShare_fr = p_avgCookingTotalGasConsumptionShare_fr;
    this.p_avgDHWTotalGasConsumptionShare_fr = p_avgDHWTotalGasConsumptionShare_fr;
    this.p_heatCapacitySizingConstant_JpK = p_heatCapacitySizingConstant_JpK;
    this.p_heatCapacitySizingSlope_JpKm2 = p_heatCapacitySizingSlope_JpKm2;
    this.p_heatCapacitySizingFactor_fr = p_heatCapacitySizingFactor_fr;
    this.p_maxAvgHouseElectricityConsumptionOffset_kWhpa = p_maxAvgHouseElectricityConsumptionOffset_kWhpa;
    this.p_maxAvgHouseGasConsumptionOffset_m3pa = p_maxAvgHouseGasConsumptionOffset_m3pa;
    this.map_insulationLabel_cooldownPeriod_hr = map_insulationLabel_cooldownPeriod_hr;
    this.p_avgHouseCookingMethod = p_avgHouseCookingMethod;
    this.p_defaultNrOfSocketsPerCharger = p_defaultNrOfSocketsPerCharger;
    this.map_avgCostOfEnergyCarrier_eurpkWh = map_avgCostOfEnergyCarrier_eurpkWh;
    this.map_avgAssetSizeDependentCAPEX_eurpkW = map_avgAssetSizeDependentCAPEX_eurpkW;
    this.map_avgAssetLifeTime_yr = map_avgAssetLifeTime_yr;
    this.map_avgAssetSizeDependentOPEX_eurpkWpyr = map_avgAssetSizeDependentOPEX_eurpkWpyr;
    this.map_gridOperatorTarrifs = map_gridOperatorTarrifs;
    this.map_energyTaxesECImport_eurpkWh = map_energyTaxesECImport_eurpkWh;
    this.VAT_energy_fr = VAT_energy_fr;
    this.VAT_CAPEXAndOPEX_fr = VAT_CAPEXAndOPEX_fr;
    this.map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh = map_avgDirectCO2EmissionOfEnergyCarrier_kgpkWh;
    this.p_defaultPVOrientation = p_defaultPVOrientation;
    this.map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh = map_avgLifeCycleCO2EmissionOfEnergyCarrier_kgpkWh;
    this.p_reductionInEnergyTaxes_eurpyr = p_reductionInEnergyTaxes_eurpyr;
    this.map_bracketDependentEnergyTaxesECImport_eurpkWh = map_bracketDependentEnergyTaxesECImport_eurpkWh;
    this.map_avgAssetBaseCAPEX_eur = map_avgAssetBaseCAPEX_eur;
    this.map_avgAssetBaseOPEX_eurpyr = map_avgAssetBaseOPEX_eurpyr;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_AVGC_data_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( AVGC_data.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon = new ShapeModelElementsGroup( AVGC_data.this, getElementProperty( "zerointerfaceloader.AVGC_data.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );


    // Space setup
    {
      double _x_xjal = 
500 
;
      double _y_xjal = 
500 
;
      double _z_xjal = 
0 
;
      setupSpace( _x_xjal, _y_xjal, _z_xjal );
    }
    disableSteps();
    setNetworkUserDefined();
    setLayoutType( LAYOUT_USER_DEFINED );
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( AVGC_data.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
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
    setupPlainVariables_AVGC_data_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_AVGC_data_xjal() {
    monthStartHours_default = 
new double[] {
    0,    // Jan
    744,  // Feb
    1416, // Mar
    2160, // Apr
    2880, // May
    3624, // Jun
    4344, // Jul
    5088, // Aug
    5832, // Sep
    6552, // Oct
    7296, // Nov
    8016  // Dec
} 
;
    monthStartHours_leapYear = 
new double[] {
    0,    // Jan
    744,  // Feb
    1440, // Mar
    2184, // Apr
    2904, // May
    3648, // Jun
    4368, // Jul
    5112, // Aug
    5856, // Sep
    6576, // Oct
    7320, // Nov
    8040  // Dec
} 
;
  }

  // User API -----------------------------------------------------
  public Zero_Loader get_Zero_Loader() {
    {
      Agent owner = getOwner();
      if ( owner instanceof Zero_Loader ) return (Zero_Loader) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient zerointerfaceloader.Zero_Loader zero_Loader;

  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }


  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public AgentList<? extends AVGC_data> getPopulation() {
    return (AgentList<? extends AVGC_data>) super.getPopulation();
  }

  public List<? extends AVGC_data> agentsInRange( double distance ) {
    return (List<? extends AVGC_data>) super.agentsInRange( distance );
  }


}
