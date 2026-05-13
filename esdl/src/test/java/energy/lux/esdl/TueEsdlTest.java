package energy.lux.esdl;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TueEsdlTest {
    @Test
    public void testTueEsdl() throws URISyntaxException {
        var javaUrl = getClass().getResource("/tue.esdl");
        var energyModel = ESDLReader.readResource(javaUrl);
        assertNotNull(energyModel);
    }
}
