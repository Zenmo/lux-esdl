package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.NotImplemented;
import esdl.EsdlFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WaterBufferLoaderTest {

    /**
     * The self discharge rate is checked before anything is built, so no model is needed.
     */
    @Test
    public void bufferWithSelfDischargeThrows() {
        var waterBuffer = EsdlFactory.eINSTANCE.createWaterBuffer();
        waterBuffer.setVolume(0.2);
        waterBuffer.setMinStorageTemperature(15);
        waterBuffer.setMaxStorageTemperature(55);
        waterBuffer.setSelfDischargeRate(0.01);

        assertThatThrownBy(() -> WaterBufferLoader.loadWaterBuffer(waterBuffer, null, null, 10))
                .isInstanceOf(NotImplemented.class);
    }
}
