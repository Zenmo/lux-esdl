package zerointerfaceloader;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_FilterOptionsGC {
  COMPANIES, HOUSES, DETAILED, NONDETAILED, HAS_PV, HAS_TRANSPORT, HAS_EV, GRIDTOPOLOGY_SELECTEDLOOP, ENERGYASSETS, SELECTED_NEIGHBORHOOD, SELECTED_MUNICIPALITY, 
  FARMER, MANUAL_SELECTION;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_FilterOptionsGC random( Agent agent ) {
    return agent.randomFrom( OL_FilterOptionsGC.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_FilterOptionsGC random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_FilterOptionsGC.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_FilterOptionsGC random( Random r ) {
    return Utilities.randomFrom( OL_FilterOptionsGC.class, r );
  }
}
