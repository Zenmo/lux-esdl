package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

/**
 * OwnershipType: <br>
 * 0: Koop<br>
 * 1: Particulier Huur<br>
 * 2: Sociale Huur
 */
public enum OL_PBL_OwnershipType {
  TYPE_0, TYPE_1, TYPE_2, UNKNOWN;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_PBL_OwnershipType random( Agent agent ) {
    return agent.randomFrom( OL_PBL_OwnershipType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_PBL_OwnershipType random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_PBL_OwnershipType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_PBL_OwnershipType random( Random r ) {
    return Utilities.randomFrom( OL_PBL_OwnershipType.class, r );
  }
}
