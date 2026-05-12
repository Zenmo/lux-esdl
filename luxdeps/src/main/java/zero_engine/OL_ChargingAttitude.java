package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_ChargingAttitude {
  SIMPLE, PRICE, PRICE_MARKET_FEEDBACK, BALANCE_LOCAL, BALANCE_GRID, MAX_POWER, OFF_PEAK_INTERVAL, NONE, CUSTOM;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_ChargingAttitude random( Agent agent ) {
    return agent.randomFrom( OL_ChargingAttitude.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_ChargingAttitude random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_ChargingAttitude.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_ChargingAttitude random( Random r ) {
    return Utilities.randomFrom( OL_ChargingAttitude.class, r );
  }
}
