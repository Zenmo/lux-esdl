package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_GISObjectType {
  REGION, NEIGHBOURHOOD, PARCEL, BUILDING, GRIDNODE, CHARGER, SOLARFARM, WINDFARM, BATTERY, ELECTROLYSER, ANTI_LAYER, 
  LV_CABLE, MV_CABLE, REMAINING_BUILDING, GN_SERVICE_AREA, OTHER, COOP, PARKING;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_GISObjectType random( Agent agent ) {
    return agent.randomFrom( OL_GISObjectType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_GISObjectType random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_GISObjectType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_GISObjectType random( Random r ) {
    return Utilities.randomFrom( OL_GISObjectType.class, r );
  }
}
