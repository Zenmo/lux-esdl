package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.NotImplemented;
import esdl.Area;
import esdl.Building;
import esdl.EnergyAsset;
import esdl.EsdlFactory;
import esdl.HeatDemandTypeEnum;
import esdl.HeatingDemand;
import esdl.InPort;
import esdl.OutPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * A small hand-made ESDL in the shape of decorated_test_normalized.esdl: the demands sit in the
 * area, the heat pumps and buffers in the buildings, and one space heating demand is shared by a
 * heat pump house and a hybrid house.
 */
public class HeatingChainFinderTest {
    private static final EsdlFactory factory = EsdlFactory.eINSTANCE;

    private Area area;
    private HeatingDemand sharedSpaceHeatingDemand;
    private HeatingDemand hotWaterDemand;

    @BeforeEach
    public void createArea() {
        area = factory.createArea();
        sharedSpaceHeatingDemand = addDemand(HeatDemandTypeEnum.SPACE_HEATING);
        hotWaterDemand = addDemand(HeatDemandTypeEnum.HOT_TAPWATER);
    }

    @Test
    public void heatPumpHouseHasAChainThroughEachBuffer() {
        var building = addBuilding();
        var heatPump = addToBuilding(building, factory.createHeatPump());
        var hotWaterBuffer = addToBuilding(building, factory.createWaterBuffer());
        var spaceHeatingBuffer = addToBuilding(building, factory.createWaterBuffer());
        connect(heatPump, hotWaterBuffer);
        connect(hotWaterBuffer, hotWaterDemand);
        connect(heatPump, spaceHeatingBuffer);
        connect(spaceHeatingBuffer, sharedSpaceHeatingDemand);
        connect(heatPump, addToBuilding(building, factory.createElectricityNetwork()));

        var chains = HeatingChainFinder.findHeatPumpChains(heatPump);

        assertThat(chains).containsExactlyInAnyOrder(
                new HeatingChain(hotWaterDemand, hotWaterBuffer),
                new HeatingChain(sharedSpaceHeatingDemand, spaceHeatingBuffer)
        );
    }

    @Test
    public void hybridHouseFeedsHotWaterDirectlyAndSharesTheSpaceHeatingDemand() {
        var heatPumpBuilding = addBuilding();
        var heatPumpBuffer = addToBuilding(heatPumpBuilding, factory.createWaterBuffer());
        connect(heatPumpBuffer, sharedSpaceHeatingDemand);

        var hybridBuilding = addBuilding();
        var hybridHeatPump = addToBuilding(hybridBuilding, factory.createHybridHeatPump());
        var spaceHeatingBuffer = addToBuilding(hybridBuilding, factory.createWaterBuffer());
        connect(hybridHeatPump, hotWaterDemand);
        connect(hybridHeatPump, spaceHeatingBuffer);
        connect(spaceHeatingBuffer, sharedSpaceHeatingDemand);

        var chains = HeatingChainFinder.findHybridHeatPumpChains(hybridHeatPump);

        assertThat(HeatingChainFinder.findChainOfType(chains, HeatDemandTypeEnum.HOT_TAPWATER))
                .isEqualTo(new HeatingChain(hotWaterDemand, null));
        assertThat(HeatingChainFinder.findChainOfType(chains, HeatDemandTypeEnum.SPACE_HEATING))
                .isEqualTo(new HeatingChain(sharedSpaceHeatingDemand, spaceHeatingBuffer));
        assertThat(HeatingChainFinder.isReachedByHeatPump(sharedSpaceHeatingDemand)).isTrue();
    }

    @Test
    public void hotWaterBufferAtAHybridThrows() {
        var building = addBuilding();
        var hybridHeatPump = addToBuilding(building, factory.createHybridHeatPump());
        var hotWaterBuffer = addToBuilding(building, factory.createWaterBuffer());
        var spaceHeatingBuffer = addToBuilding(building, factory.createWaterBuffer());
        connect(hybridHeatPump, hotWaterBuffer);
        connect(hotWaterBuffer, hotWaterDemand);
        connect(hybridHeatPump, spaceHeatingBuffer);
        connect(spaceHeatingBuffer, sharedSpaceHeatingDemand);

        assertThatThrownBy(() -> HeatingChainFinder.findHybridHeatPumpChains(hybridHeatPump))
                .isInstanceOf(NotImplemented.class);
    }

    @Test
    public void heatPumpHouseWithoutHotWaterBufferThrows() {
        var building = addBuilding();
        var heatPump = addToBuilding(building, factory.createHeatPump());
        var spaceHeatingBuffer = addToBuilding(building, factory.createWaterBuffer());
        connect(heatPump, hotWaterDemand);
        connect(heatPump, spaceHeatingBuffer);
        connect(spaceHeatingBuffer, sharedSpaceHeatingDemand);

        assertThatThrownBy(() -> HeatingChainFinder.findHeatPumpChains(heatPump))
                .isInstanceOf(NotImplemented.class);
    }

    @Test
    public void bufferWithTwoDemandsThrows() {
        var building = addBuilding();
        var heatPump = addToBuilding(building, factory.createHeatPump());
        var buffer = addToBuilding(building, factory.createWaterBuffer());
        connect(heatPump, buffer);
        connect(buffer, hotWaterDemand);
        connect(buffer, sharedSpaceHeatingDemand);

        assertThatThrownBy(() -> HeatingChainFinder.findHeatPumpChains(heatPump))
                .isInstanceOf(NotImplemented.class);
    }

    @Test
    public void houseWithoutSpaceHeatingChainThrows() {
        var building = addBuilding();
        var hybridHeatPump = addToBuilding(building, factory.createHybridHeatPump());
        connect(hybridHeatPump, hotWaterDemand);

        assertThatThrownBy(() -> HeatingChainFinder.findHybridHeatPumpChains(hybridHeatPump))
                .isInstanceOf(NotImplemented.class);
    }

    @Test
    public void twoChainsOfTheSameTypeThrow() {
        var building = addBuilding();
        var heatPump = addToBuilding(building, factory.createHeatPump());
        var firstBuffer = addToBuilding(building, factory.createWaterBuffer());
        var secondBuffer = addToBuilding(building, factory.createWaterBuffer());
        connect(heatPump, firstBuffer);
        connect(firstBuffer, sharedSpaceHeatingDemand);
        connect(heatPump, secondBuffer);
        connect(secondBuffer, addDemand(HeatDemandTypeEnum.SPACE_HEATING));

        assertThatThrownBy(() -> HeatingChainFinder.findHeatPumpChains(heatPump))
                .isInstanceOf(NotImplemented.class);
    }

    private HeatingDemand addDemand(HeatDemandTypeEnum demandType) {
        var demand = factory.createHeatingDemand();
        demand.setType(demandType);
        area.getAsset().add(demand);
        return demand;
    }

    private Building addBuilding() {
        var building = factory.createBuilding();
        area.getAsset().add(building);
        return building;
    }

    private static <T extends EnergyAsset> T addToBuilding(Building building, T asset) {
        building.getAsset().add(asset);
        return asset;
    }

    /**
     * Gives each connection its own pair of ports, as the decorator does.
     */
    private static void connect(EnergyAsset from, EnergyAsset to) {
        OutPort outPort = factory.createOutPort();
        InPort inPort = factory.createInPort();
        from.getPort().add(outPort);
        to.getPort().add(inPort);
        outPort.getConnectedTo().add(inPort);
    }
}
