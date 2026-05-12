package digital_twin_results;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_RadioButtonSetup {
  DEFAULT, DEFAULT_AND_GESPREKSLEIDRAADBEDRIJVEN, DEFAULT_AND_GESPREKSLEIDRAAD, DEFAULT_AND_BATTERY, DEFAULT_AND_BATTERY_AND_GESPREKSLEIDRAADBEDRIJVEN, DEFAULT_AND_BATTERY_AND_ECONOMIC, OFF, DEFAULT_AND_GESPREKSLEIDRAADBEDRIJVEN_AND_GTO;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_RadioButtonSetup random( Agent agent ) {
    return agent.randomFrom( OL_RadioButtonSetup.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_RadioButtonSetup random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_RadioButtonSetup.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_RadioButtonSetup random( Random r ) {
    return Utilities.randomFrom( OL_RadioButtonSetup.class, r );
  }
}
