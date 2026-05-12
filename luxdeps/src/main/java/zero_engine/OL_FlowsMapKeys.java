package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_FlowsMapKeys {
  ELECTRICITY_PRODUCTION_KW, ELECTRICITY_CONSUMPTION_KW, HEAT_PRODUCTION_KW, HEAT_CONSUMPTION_KW, METHANE_PRODUCTION_KW, METHANE_CONSUMPTION_KW, PETROLEUM_FUEL_PRODUCTION_KW, PETROLEUM_FUEL_CONSUMPTION_KW, HYDROGEN_PRODUCTION_KW, HYDROGEN_CONSUMPTION_KW, PRIMARY_PRODUCTION_KW, 
  FINAL_CONSUMPTION_KW;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_FlowsMapKeys random( Agent agent ) {
    return agent.randomFrom( OL_FlowsMapKeys.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_FlowsMapKeys random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_FlowsMapKeys.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_FlowsMapKeys random( Random r ) {
    return Utilities.randomFrom( OL_FlowsMapKeys.class, r );
  }
}
