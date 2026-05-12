package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

/**
 * - SOUTH:<br>
 * - EASTWEST:<br>
 * - CUSTOM: If a custom profile pv profile has been created, this orientation is used.
 */
public enum OL_PVOrientation {
  SOUTH, EASTWEST, CUSTOM;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_PVOrientation random( Agent agent ) {
    return agent.randomFrom( OL_PVOrientation.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_PVOrientation random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_PVOrientation.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_PVOrientation random( Random r ) {
    return Utilities.randomFrom( OL_PVOrientation.class, r );
  }
}
