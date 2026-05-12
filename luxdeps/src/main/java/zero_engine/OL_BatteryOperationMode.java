package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_BatteryOperationMode {
  OFF, SELF_CONSUMPTION, SELF_CONSUMPTION_PARENT_NODE, PRICE, PEAK_SHAVING, PEAK_SHAVING_PARENT_NODE, PEAK_SHAVING_COOP, PEAK_SHAVING_FORECAST, LOCAL_BALANCING, CUSTOM;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_BatteryOperationMode random( Agent agent ) {
    return agent.randomFrom( OL_BatteryOperationMode.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_BatteryOperationMode random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_BatteryOperationMode.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_BatteryOperationMode random( Random r ) {
    return Utilities.randomFrom( OL_BatteryOperationMode.class, r );
  }
}
