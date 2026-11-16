package energy.lux.esdl.core.loader;

import energy.lux.engine.EnergyModel;
import energy.lux.engine.energyassets.J_EAStorageHeat;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.optionlists.OL_AmbientTempType;
import energy.lux.engine.optionlists.OL_EnergyAssetType;
import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.util.Util;
import esdl.WaterBuffer;

/**
 * Turns a WaterBuffer of the ESDL into a heat store of LUX.
 * <p>
 * Content only matters as energy: the temperatures of the ESDL only turn the volume into a
 * capacity in kWh. The buffer does not have to reach a temperature before it can supply its demand.
 */
public class WaterBufferLoader {
    /**
     * The heat a cubic metre of water holds per kelvin: 1000 kg/m³ × 4186 J/(kg·K).
     * <p>
     * J_AVGC_data has fields for the density and heat capacity of water, but the AVGC reader of
     * the LUX loader does not fill them, and its data file does not state them, so they read 0.
     */
    public static final double waterHeatCapacityPerVolume_JpKm3 = 1000.0 * 4186.0;

    /**
     * The buffer starts full, so the first day does not begin with a shortfall the heat pump
     * has to catch up with.
     *
     * @param capacityHeat_kW the most heat that may flow in or out per timestep. LUX caps the flow
     *                        at this, so it has to cover the heat pump on its warmest hour and the
     *                        peak of the demand the buffer serves, or the heat does not balance.
     */
    public static J_EAStorageHeat loadWaterBuffer(
            WaterBuffer waterBuffer,
            GridConnection luxGridConnection,
            EnergyModel energyModel,
            double capacityHeat_kW
    ) {
        var lossFactor_WpK = readLossFactor_WpK(waterBuffer);
        assertTemperatureRange(waterBuffer);
        var heatCapacity_JpK = heatCapacity_JpK(waterBuffer);
        var maxTemperature_degC = waterBuffer.getMaxStorageTemperature();

        // Ambient FIXED: a lossless buffer has no use for the outside temperature.
        return new J_EAStorageHeat(
                luxGridConnection,
                OL_EnergyAssetType.STORAGE_HEAT,
                capacityHeat_kW,
                lossFactor_WpK,
                energyModel.p_timeParameters,
                maxTemperature_degC,
                waterBuffer.getMinStorageTemperature(),
                maxTemperature_degC,
                maxTemperature_degC,
                heatCapacity_JpK,
                OL_AmbientTempType.FIXED
        );
    }

    /**
     * The ESDL gives a self discharge rate, LUX a loss factor in W/K against the ambient
     * temperature. How one maps onto the other is not settled, and the files leave it at 0.
     */
    private static double readLossFactor_WpK(WaterBuffer waterBuffer) {
        if (waterBuffer.getSelfDischargeRate() != 0.0) {
            throw new NotImplemented(String.format(
                    "Water buffer %s has a self discharge rate of %s, only 0 is implemented",
                    Util.printItem(waterBuffer),
                    waterBuffer.getSelfDischargeRate()
            ));
        }
        return 0.0;
    }

    private static void assertTemperatureRange(WaterBuffer waterBuffer) {
        if (!(waterBuffer.getMaxStorageTemperature() > waterBuffer.getMinStorageTemperature())) {
            throw new EsdlException(String.format(
                    "Water buffer %s has a maximum storage temperature of %s °C, which is not above its minimum of %s °C",
                    Util.printItem(waterBuffer),
                    waterBuffer.getMaxStorageTemperature(),
                    waterBuffer.getMinStorageTemperature()
            ));
        }
    }

    /**
     * @return the heat the water holds per kelvin. The ESDL volume is in m³.
     */
    private static double heatCapacity_JpK(WaterBuffer waterBuffer) {
        Util.throwIfZero(waterBuffer.getVolume(), waterBuffer, "volume");
        return waterBuffer.getVolume() * waterHeatCapacityPerVolume_JpKm3;
    }
}
