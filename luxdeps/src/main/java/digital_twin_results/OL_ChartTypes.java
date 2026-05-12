package digital_twin_results;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_ChartTypes {
  PROFILES, BAR_TOTALS, LOAD_DURATION_CURVES, SANKEY, GESPREKSLEIDRAAD_BEDRIJVEN, KPISUMMARY, GESPREKSLEIDRAAD, BATTERY, GTO, CO2, ENERGY_COSTS, 
  CONNECTION_COSTS, CAPEX_AND_OPEX, TOTAL_COSTS;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_ChartTypes random( Agent agent ) {
    return agent.randomFrom( OL_ChartTypes.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_ChartTypes random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_ChartTypes.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_ChartTypes random( Random r ) {
    return Utilities.randomFrom( OL_ChartTypes.class, r );
  }
}
