package digital_twin_results;

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

import static digital_twin_results.OL_ChartTypes.*;
import static digital_twin_results.OL_ChartPeriod.*;
import static digital_twin_results.OL_RadioButtonSetup.*;

import java.awt.geom.Arc2D;

import java.text.DecimalFormat; 

public class ChartTotalCosts extends digital_twin_results.ChartArea
{
  // Parameters

  public 
Map<String, Color>  map_catagoryToColor;

  /**
   * Returns default value for parameter <code>map_catagoryToColor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Map<String, Color> _map_catagoryToColor_DefaultValue_xjal() {
    final ChartTotalCosts self = this;
    return 
Map.of(
"Energiekosten", mediumSeaGreen,
"Netaansluitingskosten", deepPink,
"CAPEX & OPEX", darkOrange
)

 
;
  }

  public void set_map_catagoryToColor( Map<String, Color> value ) {
    if (value == this.map_catagoryToColor) {
      return;
    }
    Map<String, Color> _oldValue_xjal = this.map_catagoryToColor;
    this.map_catagoryToColor = value;
    onChange_map_catagoryToColor_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter map_catagoryToColor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_map_catagoryToColor()</code> method instead.
   */
  protected void onChange_map_catagoryToColor() {
    onChange_map_catagoryToColor_xjal( map_catagoryToColor );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_map_catagoryToColor_xjal( Map<String, Color> oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    map_catagoryToColor = _map_catagoryToColor_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "map_catagoryToColor":
      if ( _callOnChange_xjal ) {
        set_map_catagoryToColor( (Map<String, Color>) _value_xjal );
      } else {
        map_catagoryToColor = (Map<String, Color>) _value_xjal;
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
    case "map_catagoryToColor": _result_xjal = map_catagoryToColor; break;
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
      list.add( "map_catagoryToColor" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartTotalCosts.class );

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


  // Events
	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _pieChart_totalSubdivision_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal ) return "pieChart_totalSubdivision auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    return super.getFirstOccurrenceTime( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( EventTimeout _e ) {
    double _t;
    if( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal ) {
      pieChart_totalSubdivision.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = digital_twin_results.ChartArea._STATECHART_COUNT_xjal + 0;


  // Functions

  public void f_setChartTotalCosts(  ) { 

I_EnergyData data = uI_Results.f_getSelectedObjectData();

//For now: Only support single GCs
if(uI_Results.v_selectedObjectScope != OL_ResultScope.GRIDCONNECTION){
	List<OL_ResultScope> supportedResultScopes = new ArrayList<>(List.of(OL_ResultScope.GRIDCONNECTION));
	uI_Results.f_activateChartBlocker(supportedResultScopes);
	return;
}

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 60, true);

//Reset chart
f_resetChart();

////Get and set the values with help from the economic charts
DecimalFormat df = new DecimalFormat("#,##0");
Map<String, Double> map_totalCostsPerCatagory_eur = new HashMap<>();
double totalEnergyCosts_eurpyr = uI_Results.chartEnergyCosts.f_getTotalEnergyCosts_eurpyr(data.getRapidRunData());
map_totalCostsPerCatagory_eur.put("Energiekosten", totalEnergyCosts_eurpyr);
t_totalEnergyCosts.setText("€ " + df.format(roundToInt(totalEnergyCosts_eurpyr)) + " /yr");

double[] netLoad_kW = data.getRapidRunData().am_totalBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getTimeSeries_kW();	
double totalConnectionCosts_eurpyr = uI_Results.chartConnectionCosts.f_calculateTotalConnectionCosts_eurpyr(data.getRapidRunData().connectionMetaData, netLoad_kW);
map_totalCostsPerCatagory_eur.put("Netaansluitingskosten", totalConnectionCosts_eurpyr);
t_totalConnectionCosts.setText("€ " + df.format(roundToInt(totalConnectionCosts_eurpyr)) + " /yr");

double totalCAPEXAndOPEXCosts_eurpyr = uI_Results.chartCAPEXAndOPEX.f_getTotalCAPEXAndOPEXCosts_eurpyr(data.getRapidRunData());
map_totalCostsPerCatagory_eur.put("CAPEX & OPEX", totalCAPEXAndOPEXCosts_eurpyr);
t_CAPEXAndOPEXCosts.setText("€ " + df.format(roundToInt(totalCAPEXAndOPEXCosts_eurpyr)) + " /yr");

double totalCosts_eurpyr = totalEnergyCosts_eurpyr + totalConnectionCosts_eurpyr + totalCAPEXAndOPEXCosts_eurpyr;	
t_totalCosts.setText("€ " + df.format(roundToInt(totalCosts_eurpyr)) + " /yr");

if(data.getPreviousRapidRunData() != null){
	double previousTotalEnergyCosts_eurpyr = uI_Results.chartEnergyCosts.f_getTotalEnergyCosts_eurpyr(data.getPreviousRapidRunData());
	t_previousTotalEnergyCosts.setText("€ " + df.format(roundToInt(previousTotalEnergyCosts_eurpyr)) + " /yr");
	
	double previousNetLoad_kW[] = data.getPreviousRapidRunData().am_totalBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY).getTimeSeries_kW();
	double previousTotalConnectionCosts_eurpyr = uI_Results.chartConnectionCosts.f_calculateTotalConnectionCosts_eurpyr(data.getPreviousRapidRunData().connectionMetaData, netLoad_kW);
	t_previousTotalConnectionCosts.setText("€ " + df.format(roundToInt(previousTotalConnectionCosts_eurpyr)) + " /yr");
	
	double previousTotalCAPEXAndOPEXCosts_eurpyr = uI_Results.chartCAPEXAndOPEX.f_getTotalCAPEXAndOPEXCosts_eurpyr(data.getPreviousRapidRunData());
	t_previousCAPEXAndOPEXCosts.setText("€ " + df.format(roundToInt(previousTotalCAPEXAndOPEXCosts_eurpyr)) + " /yr");
	
	double previousTotalCosts_eurpyr = previousTotalEnergyCosts_eurpyr + previousTotalConnectionCosts_eurpyr + previousTotalCAPEXAndOPEXCosts_eurpyr;	
	t_previousTotalCosts.setText("€ " + df.format(roundToInt(previousTotalCosts_eurpyr)) + " /yr");
}

//Set Pie chart
f_setPieChart(map_totalCostsPerCatagory_eur); 
  }

  void f_resetChart(  ) { 

t_previousTotalEnergyCosts.setText("");
t_previousTotalConnectionCosts.setText("");
t_previousCAPEXAndOPEXCosts.setText("");
t_previousTotalCosts.setText("");

//Clear pie chart
pieChart_totalSubdivision.removeAll();
gr_chartTotalSubdivision.setVisible(false); 
  }

  void f_setPieChart( Map<String, Double> map_totalCostsPerCatagory_eur ) { 

for(String catagory : map_totalCostsPerCatagory_eur.keySet()){
	DataItem costs = new DataItem();
	costs.setValue(roundToInt(map_totalCostsPerCatagory_eur.get(catagory)));
	pieChart_totalSubdivision.addDataItem(costs, catagory + " [€/yr]", map_catagoryToColor.get(catagory));
}
gr_chartTotalSubdivision.setVisible(true); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalCostsChart_Font = new Font("SansSerif", 1, 26 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalCosts_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalEnergyCosts_Font = new Font("SansSerif", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_CAPEXAndOPEXCosts_Font = _txt_totalEnergyCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalEnergyCosts_Font = _t_totalCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_CAPEXAndOPEXCosts_Font = _t_totalCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalConnectionCosts_Font = _txt_totalEnergyCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_totalConnectionCosts_Font = _t_totalCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalCosts_Font = _txt_totalEnergyCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalConnectionCosts_Font = new Font("SansSerif", 2, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalEnergyCosts_Font = _t_previousTotalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousCAPEXAndOPEXCosts_Font = _t_previousTotalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _t_previousTotalCosts_Font = _t_previousTotalConnectionCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _txt_totalSubdivision_Font = new Font("SansSerif", 0, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final int _rect_headerKPI = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalCostsChart = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _i_chartTotalCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalEnergyCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_CAPEXAndOPEXCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalEnergyCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _line_total = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_CAPEXAndOPEXCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_totalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalConnectionCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalEnergyCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousCAPEXAndOPEXCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _t_previousTotalCosts = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _txt_totalSubdivision = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_chartTotalSubdivision = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _pieChart_totalSubdivision = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 19;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 20;

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
	  level.addAll(rect_headerKPI, txt_totalCostsChart, i_chartTotalCosts, t_totalCosts, txt_totalEnergyCosts, txt_CAPEXAndOPEXCosts, t_totalEnergyCosts, line_total, t_CAPEXAndOPEXCosts, txt_totalConnectionCosts, t_totalConnectionCosts, txt_totalCosts, t_previousTotalConnectionCosts, t_previousTotalEnergyCosts, t_previousCAPEXAndOPEXCosts, t_previousTotalCosts, gr_chartTotalSubdivision);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _i_chartTotalCosts:
        if (true) {
          ShapeImage self = this.i_chartTotalCosts;
          
uI_Results.f_setInfoText(i_chartTotalCosts, uI_Results.v_infoText.chartTotalCosts, i_chartTotalCosts.getX(), i_chartTotalCosts.getY()); 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pieChart_totalSubdivision_DataItem0Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pieChart_totalSubdivision_DataItem1Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pieChart_totalSubdivision_DataItem2Value() {
    return 
0 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _pieChart_totalSubdivision_DataItem3Value() {
    return 
0 
;
  }
  protected PieChart pieChart_totalSubdivision;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rect_headerKPI_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setLineColor(
v_lineColor 
);
    shape.setLineWidth(
v_lineWidth 
);
  }
  
  protected ShapeRectangle rect_headerKPI;
  protected ShapeText txt_totalCostsChart;
  protected ShapeImage i_chartTotalCosts;
  protected ShapeText t_totalCosts;
  protected ShapeText txt_totalEnergyCosts;
  protected ShapeText txt_CAPEXAndOPEXCosts;
  protected ShapeText t_totalEnergyCosts;
  protected ShapeLine line_total;
  protected ShapeText t_CAPEXAndOPEXCosts;
  protected ShapeText txt_totalConnectionCosts;
  protected ShapeText t_totalConnectionCosts;
  protected ShapeText txt_totalCosts;
  protected ShapeText t_previousTotalConnectionCosts;
  protected ShapeText t_previousTotalEnergyCosts;
  protected ShapeText t_previousCAPEXAndOPEXCosts;
  protected ShapeText t_previousTotalCosts;
  protected ShapeText txt_totalSubdivision;
  protected ShapeGroup gr_chartTotalSubdivision;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rect_headerKPI = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 0.0, 0.0, 0.0,
            lavender, whiteSmoke,
			460.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
	
      @Override
	
      public void updateDynamicProperties() {
	
      _rect_headerKPI_SetDynamicParams_xjal( this );
	
      super.updateDynamicProperties();
	
      }
    };
    txt_totalCostsChart = new ShapeText(
        SHAPE_DRAW_2D, true,235.0, 10.0, 0.0, 0.0,
        black,"Totale kosten",
        _txt_totalCostsChart_Font, ALIGNMENT_CENTER );
    i_chartTotalCosts = new ShapeImage(
		ChartTotalCosts.this, SHAPE_DRAW_2D3D, true, 360.0, 10.0, 0.0, 0.0,
30.0, 30.0, "/digital_twin_results/",
			new String[]{"icon_i.png",} ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _i_chartTotalCosts, 0, clickx, clicky );
      }
    };
    t_totalCosts = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 352.0, 0.0, 0.0,
        black,"€ 1,210,563 / yr ",
        _t_totalCosts_Font, ALIGNMENT_RIGHT );
    txt_totalEnergyCosts = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 134.0, 0.0, 0.0,
        black,"Totale energiekosten:",
        _txt_totalEnergyCosts_Font, ALIGNMENT_LEFT );
    txt_CAPEXAndOPEXCosts = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 274.0, 0.0, 0.0,
        black,"CAPEX & OPEX",
        _txt_CAPEXAndOPEXCosts_Font, ALIGNMENT_LEFT );
    t_totalEnergyCosts = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 132.0, 0.0, 0.0,
        black,"€ 1,210,563 / yr ",
        _t_totalEnergyCosts_Font, ALIGNMENT_RIGHT );
    line_total = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 20.0, 330.0, 0.0, silver,
 		420.0,	0.0, 0.0, 2.0, 10.0, LINE_STYLE_SOLID );
    t_CAPEXAndOPEXCosts = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 267.0, 0.0, 0.0,
        black,"€ 1,210,563 / yr ",
        _t_CAPEXAndOPEXCosts_Font, ALIGNMENT_RIGHT );
    txt_totalConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 204.0, 0.0, 0.0,
        black,"Totale netaansluitingskosten:",
        _txt_totalConnectionCosts_Font, ALIGNMENT_LEFT );
    t_totalConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 202.0, 0.0, 0.0,
        black,"€ 1,210,563 / yr ",
        _t_totalConnectionCosts_Font, ALIGNMENT_RIGHT );
    txt_totalCosts = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 354.0, 0.0, 0.0,
        black,"Totale kosten:",
        _txt_totalCosts_Font, ALIGNMENT_LEFT );
    t_previousTotalConnectionCosts = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 232.0, 0.0, 0.0,
        black,"€ 1,210,563 / yr ",
        _t_previousTotalConnectionCosts_Font, ALIGNMENT_RIGHT );
    t_previousTotalEnergyCosts = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 162.0, 0.0, 0.0,
        black,"€ 1,210,563 / yr ",
        _t_previousTotalEnergyCosts_Font, ALIGNMENT_RIGHT );
    t_previousCAPEXAndOPEXCosts = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 297.0, 0.0, 0.0,
        black,"€ 1,210,563 / yr ",
        _t_previousCAPEXAndOPEXCosts_Font, ALIGNMENT_RIGHT );
    t_previousTotalCosts = new ShapeText(
        SHAPE_DRAW_2D, true,420.0, 382.0, 0.0, 0.0,
        black,"€ 1,210,563 / yr ",
        _t_previousTotalCosts_Font, ALIGNMENT_RIGHT );
    txt_totalSubdivision = new ShapeText(
        SHAPE_DRAW_2D, true,0.0, -170.0, 0.0, 0.0,
        black,"Totaal verdeling",
        _txt_totalSubdivision_Font, ALIGNMENT_CENTER );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataItem> _items = new ArrayList<>( 4 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pieChart_totalSubdivision_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pieChart_totalSubdivision_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pieChart_totalSubdivision_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _pieChart_totalSubdivision_DataItem3Value() );
      }
    });
    List<String> _titles = new ArrayList<>( 4 );
    _titles.add( "Title" );
    _titles.add( "Title 1" );
    _titles.add( "Title 2" );
    _titles.add( "Title 3" );
    List<Color> _colors = new ArrayList<>( 4 );
    _colors.add( lightSlateBlue );
    _colors.add( deepPink );
    _colors.add( darkOrange );
    _colors.add( mediumSeaGreen );
    pieChart_totalSubdivision = new PieChart(
ChartTotalCosts.this, true, -160.0, -140.0,
			320.0, 274.444,
            null, null,
            60.0, 10.0,
			200.0, 200.0, null, black,
            50.0, Chart.SOUTH,
            _items, _titles, _colors );
    }
    {
    gr_chartTotalSubdivision = new ShapeGroup( ChartTotalCosts.this, SHAPE_DRAW_2D3D, true, 230.0, 600.0, 0.0, 0.0
	
	     , pieChart_totalSubdivision
	     , txt_totalSubdivision );
    }
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
  public ChartTotalCosts( Engine engine, Agent owner, AgentList<? extends ChartTotalCosts> ownerPopulation ) {
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
    uI_Results = get_UI_Results();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public ChartTotalCosts() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public ChartTotalCosts( Map<String, Color> map_catagoryToColor ) {
    markParametersAreSet();
    this.map_catagoryToColor = map_catagoryToColor;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartTotalCosts_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartTotalCosts.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartTotalCosts.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _pieChart_totalSubdivision_autoUpdateEvent_xjal.start();
  }


  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartTotalCosts_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartTotalCosts_xjal() {
  }

  // User API -----------------------------------------------------
  public UI_Results get_UI_Results() {
    {
      Agent owner = getOwner();
      if ( owner instanceof UI_Results ) return (UI_Results) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient digital_twin_results.UI_Results uI_Results;

  public AgentList<? extends ChartTotalCosts> getPopulation() {
    return (AgentList<? extends ChartTotalCosts>) super.getPopulation();
  }

  public List<? extends ChartTotalCosts> agentsInRange( double distance ) {
    return (List<? extends ChartTotalCosts>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _pieChart_totalSubdivision_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _pieChart_totalSubdivision_autoUpdateEvent_xjal.onDestroy();
    super.onDestroy();
  }


}
