package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_GridConnectionEnergyLabel {
  A, B, C, D, E, F, G, NONE, UNKNOWN;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_GridConnectionEnergyLabel random( Agent agent ) {
    return agent.randomFrom( OL_GridConnectionEnergyLabel.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_GridConnectionEnergyLabel random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_GridConnectionEnergyLabel.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_GridConnectionEnergyLabel random( Random r ) {
    return Utilities.randomFrom( OL_GridConnectionEnergyLabel.class, r );
  }
}
