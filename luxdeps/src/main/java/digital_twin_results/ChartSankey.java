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

// jFree plots
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.flow.FlowPlot;
import org.jfree.data.flow.FlowDataset;
import java.awt.geom.Rectangle2D;
import org.jfree.data.flow.DefaultFlowDataset;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.data.flow.NodeKey;
import org.jfree.graphics2d.svg.SVGUnits; 

public class ChartSankey extends digital_twin_results.ChartArea
{
  // Parameters
  // Plain Variables

  public 
DefaultFlowDataset 
 flowDataset;
  public 
FlowPlot 
 flowPlot;
  public 
JFreeChart 
 flowChart;
  public 
SVGGraphics2D 
 svg2d;
  public 
ShapeSVG 
 svgImgJfree;

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( ChartSankey.class );

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
  protected static final int _STATECHART_COUNT_xjal = digital_twin_results.ChartArea._STATECHART_COUNT_xjal + 0;


  // Functions

  void f_setSankey(  ) { 

//Set selected object display
uI_Results.f_setSelectedObjectDisplay(230, 10, true);

I_EnergyData data = uI_Results.f_getSelectedObjectData();

double selfConsumedEnergy_MWh = data.getRapidRunData().getTotalEnergySelfConsumed_MWh();
double importE_MWh = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.ELECTRICITY) ? data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.ELECTRICITY) : 0;
double importG_MWh = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.METHANE) ? data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.METHANE) : 0;
double importF_MWh = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.PETROLEUM_FUEL) ? data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.PETROLEUM_FUEL) : 0;
double importHeat_MWh = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.HEAT) ? data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.HEAT) : 0;
double importH_MWh = data.getRapidRunData().activeConsumptionEnergyCarriers.contains(OL_EnergyCarriers.HYDROGEN) ? data.getRapidRunData().getTotalImport_MWh(OL_EnergyCarriers.HYDROGEN) : 0;
double exportH_MWh = data.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.HYDROGEN) ? data.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.HYDROGEN) : 0;
double exportE_MWh = data.getRapidRunData().activeProductionEnergyCarriers.contains(OL_EnergyCarriers.ELECTRICITY) ? data.getRapidRunData().getTotalExport_MWh(OL_EnergyCarriers.ELECTRICITY) : 0;
double heatProduced_MWh = 0;

flowDataset = new DefaultFlowDataset();

if (heatProduced_MWh > 0.001) {
	flowDataset.setFlow(0, "opwek warmte", "verbruik", heatProduced_MWh);
	NodeKey key1 = new NodeKey<>(0, "opwek warmte");
	flowPlot.setNodeFillColor(key1, yellowGreen);
	if (selfConsumedEnergy_MWh-heatProduced_MWh > 0.001) {
		flowDataset.setFlow(0, "opwek stroom", "verbruik", (selfConsumedEnergy_MWh-heatProduced_MWh));
	}
	if (exportE_MWh > 0.001) {
		flowDataset.setFlow(0, "opwek stroom", "export stroom", exportE_MWh);
	}
	if (selfConsumedEnergy_MWh-heatProduced_MWh > 0.001 || exportE_MWh > 0.001) {
		NodeKey key2 = new NodeKey<>(0, "opwek stroom");
		flowPlot.setNodeFillColor(key2, yellowGreen);
	}
} else {
	if (selfConsumedEnergy_MWh > 0.001) {
		flowDataset.setFlow(0, "eigen opwek", "verbruik", (selfConsumedEnergy_MWh));
	}
	if ( exportE_MWh > 0.001) {
		NodeKey exportKey = new NodeKey<>(1,"export stroom");
		flowPlot.setNodeFillColor(exportKey, darkBlue);
		flowDataset.setFlow(0, "eigen opwek", "export stroom", exportE_MWh);
	}
	if (selfConsumedEnergy_MWh > 0.001 ||  exportE_MWh > 0.001) {
		NodeKey key2 = new NodeKey<>(0, "eigen opwek");
		flowPlot.setNodeFillColor(key2, yellowGreen);
	}
}
//flowDataset.setFlow(0, "import", "export", 0);

if (importE_MWh > 0.001) {
	flowDataset.setFlow(0, "import stroom", "verbruik", importE_MWh);
	NodeKey key3 = new NodeKey<>(0, "import stroom");
	flowPlot.setNodeFillColor(key3, red);
}
if (importG_MWh > 0.001 ) {
	flowDataset.setFlow(0, "import gas", "verbruik", importG_MWh);	
	NodeKey key4 = new NodeKey<>(0, "import gas");
	flowPlot.setNodeFillColor(key4, new Color(200,150,0));
}	
if (importF_MWh > 0.001 ) {
	flowDataset.setFlow(0, "import brandstof", "verbruik", importF_MWh);
	NodeKey key5 = new NodeKey<>(0, "import brandstof");
	flowPlot.setNodeFillColor(key5, gray);
}
if(importHeat_MWh > 0.001 ) {
	flowDataset.setFlow(0, "import warmtenet", "verbruik", importHeat_MWh);
	NodeKey key5 = new NodeKey<>(0, "import warmtenet");
	flowPlot.setNodeFillColor(key5, orange);
}
if (importH_MWh > 0.001 ) {
	flowDataset.setFlow(0, "import waterstof", "verbruik", importH_MWh);
	NodeKey key6 = new NodeKey<>(0, "import waterstof");
	flowPlot.setNodeFillColor(key6, dodgerBlue);
}
if (exportH_MWh > 0.001 ) {
	flowDataset.setFlow(0, "eigen opwek", "export waterstof", exportH_MWh);
	NodeKey key7 = new NodeKey<>(1, "export waterstof");
	flowPlot.setNodeFillColor(key7, dodgerBlue);
}

//traceln(flowDataset.getAllNodes());
//traceln(flowDataset.getAllFlows());



//NodeKey hydrogenExportKey = new NodeKey<>(1, "export waterstof");
//flowPlot.setNodeFillColor(hydrogenExportKey, dodgerBlue);

//JFreeChart flowChart = new JFreeChart(flowPlot);
flowChart.setTitle("Energiestromen");
flowChart.setAntiAlias(true);
// Increasing NodeMargin is a crude way to prevent overlapping text
flowPlot.setNodeMargin(0.05);
flowPlot.setDefaultNodeLabelFont(new Font("SansSerif", Font.BOLD, 18));
//flowPlot.setDefaultNodeLabelPaint(darkBlue);
flowPlot.setDataset(flowDataset);	
int widthOfSVG = 400;
int heightOfSVG = 600;

flowChart.draw(svg2d,new Rectangle2D.Double(0, 0, widthOfSVG, heightOfSVG));
svgImgJfree.setSVG(svg2d.getSVGElement());
svgImgJfree.setVisible(true);
gr_sankey.setVisible(true); 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final int _gr_sankey = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 1;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = digital_twin_results.ChartArea._SHAPE_NEXT_ID_xjal + 2;

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
	  level.addAll(gr_sankey);
  }

  protected ShapeGroup gr_sankey;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    gr_sankey = new ShapeGroup( ChartSankey.this, SHAPE_DRAW_2D3D, true, 230.0, 150.0, 0.0, 0.0
	 );
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
  public ChartSankey( Engine engine, Agent owner, AgentList<? extends ChartSankey> ownerPopulation ) {
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
  public ChartSankey() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_ChartSankey_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation.initialize_xjal( false, false , level );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    icon.initialize_xjal( this.<ModelElementDescriptorUtils[]>getElementProperty( "digital_twin_results.ChartSankey.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );


	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( ChartSankey.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

gr_sankey.add(svgImgJfree); // Need to add ShapeSVG object to group on canvas for it to become visible!
svgImgJfree.setPos(svgImgJfree.getX()-200, svgImgJfree.getY()-40);
 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_ChartSankey_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_ChartSankey_xjal() {
    flowDataset = 
new DefaultFlowDataset() 
;
    flowPlot = 
new FlowPlot(flowDataset); 
;
    flowChart = 
new JFreeChart(flowPlot); 
;
    svg2d = 
new SVGGraphics2D(400, 600) 
;
    svgImgJfree = 
new ShapeSVG() 
;
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

  public AgentList<? extends ChartSankey> getPopulation() {
    return (AgentList<? extends ChartSankey>) super.getPopulation();
  }

  public List<? extends ChartSankey> agentsInRange( double distance ) {
    return (List<? extends ChartSankey>) super.agentsInRange( distance );
  }


}
