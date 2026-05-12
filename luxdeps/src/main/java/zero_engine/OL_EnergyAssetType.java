package zero_engine;

import com.anylogic.engine.Agent;
import com.anylogic.engine.Experiment;
import com.anylogic.engine.Utilities;
import java.util.Random;

public enum OL_EnergyAssetType {
  ELECTRICITY_DEMAND, HEAT_DEMAND, WINDMILL, PHOTOVOLTAIC, PHOTOTHERMAL, GAS_BURNER, HEAT_PUMP_AIR, HEAT_PUMP_GROUND, STORAGE_HEAT, STORAGE_ELECTRIC, HOT_WATER_CONSUMPTION, 
  HEAT_DELIVERY_SET, METHANE_FURNACE, HYDROGEN_FURNACE, ELECTRIC_HEATER, ELECTROLYSER, HYDROGEN_DEMAND, ELECTRIC_HOB, RESIDUALHEATHT, RESIDUALHEATLT, METHANE_CHP, GAS_PIT, 
  BUILDINGTHERMALS, HEAT_PUMP_WATER, DISTRICT_EBOILER_CHPPEAK, LIVESTOCK, STORAGE_GAS, PETROLEUM_FUEL_DEMAND, BIOGAS_METHANE_CONVERTER, METHANE_DEMAND, PETROLEUM_FUEL_VEHICLE, PETROLEUM_FUEL_VAN, PETROLEUM_FUEL_TRUCK, 
  ELECTRIC_VEHICLE, ELECTRIC_VAN, ELECTRIC_TRUCK, HYDROGEN_VEHICLE, HYDROGEN_VAN, HYDROGEN_TRUCK, HYDROGEN_BURNER, FUEL_CELL, CHARGER, METHANE_GENERATOR, DIESEL_GENERATOR, 
  AIR_CONDITIONER, HYDROGEN_STORAGE;
  
  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param agent agent to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_EnergyAssetType random( Agent agent ) {
    return agent.randomFrom( OL_EnergyAssetType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param experiment experiment to be used as a source of random number generation
   * @return the randomly chosen option list item
   */
  public static OL_EnergyAssetType random( Experiment<?> experiment ) {
    return experiment.randomFrom( OL_EnergyAssetType.class );
  }

  /**
   * Returns the randomly chosen option list item.
   * Uses the specified random number generator to choose the constant.
   * @param r the random number generator
   * @return the randomly chosen option list item
   */
  public static OL_EnergyAssetType random( Random r ) {
    return Utilities.randomFrom( OL_EnergyAssetType.class, r );
  }
}
