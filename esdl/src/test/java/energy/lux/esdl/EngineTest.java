package energy.lux.esdl;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;
import java.io.IOException;


public class EngineTest {
    @Test
    public void testEmptyEnergyModel() throws IOException, InvalidFormatException {
        var energyModel = Init.createEnergyModel();
        energyModel.f_runTimestep();
    }
}
