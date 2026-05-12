package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_ElectrolyserState {
  SHUTDOWN, STANDBY, IDLE, FUNCTIONAL, FULLCAPACITY, POWER_UP;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_ElectrolyserState random( Agent agent ) {
    return agent.randomFrom( OL_ElectrolyserState.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_ElectrolyserState random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_ElectrolyserState.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_ElectrolyserState random( Random r ) {
    return Utilities.randomFrom( OL_ElectrolyserState.class, r );
  }
}
