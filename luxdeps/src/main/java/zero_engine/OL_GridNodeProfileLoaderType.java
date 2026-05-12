package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

/**
 * NO_PROFILE => No gridnode profile<br>
 * NET_LOAD => Copy exact net load onto grid node (delivery and feedin exact but doesnt represent consumption and production accurately)<br>
 * INCLUDE_PV => Use PV profile to preprocess gridnode profile to create a more accurate consumption profile and also create a production profile on the gridnode (delivery will be exact, consumption will be more accurate but feedin will not be exact).<br>
 * EXCLUDE_PV => Use PV profile to preprocess gridnode profile to create a more accurate consumption profile but will not create a production profile on the gridnode itself -> it is necessary that the gridconnections get their own production assets (delivery will be exact, consumption will be more accurate but feedin will not be exact).
 */
public enum OL_GridNodeProfileLoaderType {
  NO_PROFILE, NET_LOAD, INCLUDE_PV, EXCLUDE_PV;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_GridNodeProfileLoaderType random( Agent agent ) {
    return agent.randomFrom( OL_GridNodeProfileLoaderType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_GridNodeProfileLoaderType random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_GridNodeProfileLoaderType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_GridNodeProfileLoaderType random( Random r ) {
    return Utilities.randomFrom( OL_GridNodeProfileLoaderType.class, r );
  }
}
