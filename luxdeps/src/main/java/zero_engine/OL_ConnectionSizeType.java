package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

/**
 * SMALL_CONNECTION (kleinverbruik, <= 3x80)<br>
 * LARGE_CONNECTION (grootverbruik, > 3x80)
 */
public enum OL_ConnectionSizeType {
  SMALL_CONNECTION, LARGE_CONNECTION;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_ConnectionSizeType random( Agent agent ) {
    return agent.randomFrom( OL_ConnectionSizeType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_ConnectionSizeType random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_ConnectionSizeType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_ConnectionSizeType random( Random r ) {
    return Utilities.randomFrom( OL_ConnectionSizeType.class, r );
  }
}
