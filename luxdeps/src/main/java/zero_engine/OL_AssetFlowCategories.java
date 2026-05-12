package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_AssetFlowCategories {
  fixedConsumptionElectric_kW, heatPumpElectricityConsumption_kW, airConditionersElectricPower_kW, evChargingPower_kW, V2GPower_kW, batteriesChargingPower_kW, batteriesDischargingPower_kW, electrolyserElectricityConsumption_kW, electricHobConsumption_kW, districtHeatDelivery_kW, pvProductionElectric_kW, 
  windProductionElectric_kW, ptProductionHeat_kW, CHPProductionElectric_kW, hotWaterConsumption_kW, spaceHeating_kW, electricHeaterElectricityConsumption_kW, dieselGeneratorProductionElectric_kW, methaneGeneratorProductionElectric_kW, hydrogenFuelCellProductionElectric_kW;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_AssetFlowCategories random( Agent agent ) {
    return agent.randomFrom( OL_AssetFlowCategories.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_AssetFlowCategories random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_AssetFlowCategories.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_AssetFlowCategories random( Random r ) {
    return Utilities.randomFrom( OL_AssetFlowCategories.class, r );
  }
}
