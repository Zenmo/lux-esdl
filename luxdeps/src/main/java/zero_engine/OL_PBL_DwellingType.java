package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

/**
 * PBL Dwellingtypes: <br>
 * 1: vrijstaand<br>
 * 2: 2-onder-1 kap<br>
 * 3: rijwoning hoekwoning<br>
 * 4: rijwoning tussenwoning<br>
 * 5: appartementen t/m 4 (meergezinswoningen t/m 4 verdiepingen)<br>
 * 6: appartementen 5>= (meergezinswoningen 5 of meer verdiepingen)
 */
public enum OL_PBL_DwellingType {
  TYPE_1, TYPE_2, TYPE_3, TYPE_4, TYPE_5, TYPE_6, UNKNOWN;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_PBL_DwellingType random( Agent agent ) {
    return agent.randomFrom( OL_PBL_DwellingType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_PBL_DwellingType random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_PBL_DwellingType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_PBL_DwellingType random( Random r ) {
    return Utilities.randomFrom( OL_PBL_DwellingType.class, r );
  }
}
