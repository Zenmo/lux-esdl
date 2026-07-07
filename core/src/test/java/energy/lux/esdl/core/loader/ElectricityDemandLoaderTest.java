package energy.lux.esdl.core.loader;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import energy.lux.esdl.core.LuxModelFactory;
import energy.lux.esdl.core.NotImplemented;
import esdl.EsdlFactory;
import esdl.MultiplierEnum;
import esdl.UnitEnum;
import org.junit.jupiter.api.Test;
import zero_engine.GridConnection;
import zero_engine.J_EAProfile;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import static energy.lux.esdl.core.TestUtil.captureLogs;
import static energy.lux.esdl.core.util.DateTimeUtil.luxJan1stInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ElectricityDemandLoaderTest {
    private final EsdlFactory esdlFactory = EsdlFactory.eINSTANCE;

    @Test
    public void testWattProfileIsConvertedToKilowatt() {
        var luxLoader = LuxModelFactory.createEnergyModel();
        var energyModel = luxLoader.energyModel;
        var loader = new ElectricityDemandLoader(luxLoader);

        var demand = esdlFactory.createElectricityDemand();
        demand.setName("Test Demand");
        demand.setId("test_demand");

        var port = esdlFactory.createInPort();
        demand.getPort().add(port);

        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.getValues().addAll(List.of(1000.0));

        var quantityAndUnit = esdlFactory.createQuantityAndUnitType();
        quantityAndUnit.setUnit(UnitEnum.WATT);
        quantityAndUnit.setMultiplier(MultiplierEnum.NONE);
        profile.setProfileQuantityAndUnit(quantityAndUnit);

        port.getProfile().add(profile);

        var luxGridConnection = energyModel.add_pop_gridConnections();

        loader.loadElectricityDemand(demand, luxGridConnection);

        assertEquals(1, luxGridConnection.c_profileAssets.size());
        J_EAProfile asset = luxGridConnection.c_profileAssets.get(0);
        assertEquals(1.0, asset.getProfilePointer().getValue(0.0));
    }

    @Test
    public void testKilowattProfileIsKeptAsIs() {
        var luxLoader = LuxModelFactory.createEnergyModel();
        var energyModel = luxLoader.energyModel;
        var loader = new ElectricityDemandLoader(luxLoader);

        var demand = esdlFactory.createElectricityDemand();
        demand.setName("Test Demand");
        demand.setId("test_demand");

        var port = esdlFactory.createInPort();
        demand.getPort().add(port);

        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.getValues().addAll(List.of(1.0));

        var quantityAndUnit = esdlFactory.createQuantityAndUnitType();
        quantityAndUnit.setUnit(UnitEnum.WATT);
        quantityAndUnit.setMultiplier(MultiplierEnum.KILO);
        profile.setProfileQuantityAndUnit(quantityAndUnit);

        port.getProfile().add(profile);

        var luxGridConnection = energyModel.add_pop_gridConnections();

        loader.loadElectricityDemand(demand, luxGridConnection);

        assertEquals(1, luxGridConnection.c_profileAssets.size());
        J_EAProfile asset = luxGridConnection.c_profileAssets.get(0);
        assertEquals(1.0, asset.getProfilePointer().getValue(0.0));
    }

    @Test
    public void testNoUnitLogsErrorAndAssumesWatt() {
        var luxLoader = LuxModelFactory.createEnergyModel();
        var energyModel = luxLoader.energyModel;
        var loader = new ElectricityDemandLoader(luxLoader);

        var demand = esdlFactory.createElectricityDemand();
        demand.setName("Test Demand");
        demand.setId("test_demand");

        var port = esdlFactory.createInPort();
        demand.getPort().add(port);

        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.getValues().addAll(List.of(1000.0));

        port.getProfile().add(profile);

        var luxGridConnection = energyModel.add_pop_gridConnections();

        var logEvents = captureLogs();
        loader.loadElectricityDemand(demand, luxGridConnection);

        var errorMessages = logEvents.stream()
                .filter(event -> event.getLevel() == Level.ERROR)
                .map(ILoggingEvent::getMessage);

        assertThat(errorMessages).anyMatch(
                message -> message.contains("No unit given for electricity demand. Assuming W")
        );

        assertEquals(1, luxGridConnection.c_profileAssets.size());
        J_EAProfile asset = luxGridConnection.c_profileAssets.get(0);
        assertEquals(1.0, asset.getProfilePointer().getValue(0.0));
    }

    @Test
    public void testUnsupportedUnitThrowsNotImplemented() {
        var luxLoader = LuxModelFactory.createEnergyModel();
        var energyModel = luxLoader.energyModel;
        var loader = new ElectricityDemandLoader(luxLoader);

        var demand = esdlFactory.createElectricityDemand();
        demand.setName("Test Demand");
        demand.setId("test_demand");

        var port = esdlFactory.createInPort();
        demand.getPort().add(port);

        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.getValues().addAll(List.of(1.0));

        var quantityAndUnit = esdlFactory.createQuantityAndUnitType();
        quantityAndUnit.setUnit(UnitEnum.JOULE);
        profile.setProfileQuantityAndUnit(quantityAndUnit);

        port.getProfile().add(profile);

        var luxGridConnection = energyModel.add_pop_gridConnections();

        assertThrows(NotImplemented.class, () ->
                loader.loadElectricityDemand(demand, luxGridConnection)
        );
    }
}
