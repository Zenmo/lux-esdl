package energy.lux.esdl.core.loader;

import esdl.Building;
import esdl.EsdlFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class BuildingThermalLoaderTest {
    private static final EsdlFactory factory = EsdlFactory.eINSTANCE;

    @Test
    public void heatBatteryOfHome11_1() {
        var building = createHome11_1();

        assertThat(BuildingThermalLoader.internalHeatCapacity_JpK(building)).isCloseTo(38.02e6, within(0.01e6));
        // 150.5 W/K ventilation, built before 1968, plus 186.0 W/K through floor, walls, roof,
        // windows and doors.
        assertThat(BuildingThermalLoader.heatLossCoefficient_WpK(building)).isCloseTo(336.5, within(0.1));
        assertThat(BuildingThermalLoader.heatBatteryLossFactor_WpK(building)).isCloseTo(560.8, within(0.2));
    }

    /**
     * The values DOTS computed for its reference house, rijwoning hoek 1965-1974.
     */
    @Test
    public void dotsReferenceHouse() {
        var building = factory.createBuilding();
        building.setFloorArea(115.96);
        building.setBuildingYear(1970);

        assertThat(BuildingThermalLoader.ventilationLoss_WpK(building)).isCloseTo(95.8316627533737, within(1e-6));
        assertThat(BuildingThermalLoader.internalHeatCapacity_JpK(building)).isCloseTo(29_243_792, within(1.0));
    }

    @Test
    public void airTightnessFallsOffAfter1967() {
        assertThat(BuildingThermalLoader.airTightness_dm3pspm2(buildingFrom(1967))).isEqualTo(4.0);
        assertThat(BuildingThermalLoader.airTightness_dm3pspm2(buildingFrom(1968))).isCloseTo(3.77, within(0.01));
        assertThat(BuildingThermalLoader.airTightness_dm3pspm2(buildingFrom(2010))).isCloseTo(0.552, within(0.001));
    }

    private static Building buildingFrom(int buildingYear) {
        var building = factory.createBuilding();
        building.setBuildingYear(buildingYear);
        return building;
    }

    /**
     * Home11_1 of decorated_test_normalized.esdl, with its two BuildingStructureInformation
     * entries as the decorator writes them: the areas in one, the rc and u values in the other.
     */
    private static Building createHome11_1() {
        var building = factory.createBuilding();
        building.setFloorArea(153.28);
        building.setSurfaceArea(89);
        building.setBuildingYear(1964);

        var areas = factory.createBuildingStructureInformation();
        areas.setWallArea(131.12);
        areas.setWindowArea(28.36);
        areas.setDoorArea(8.04);
        areas.setFlatRoofArea(29.31);
        areas.setSlantedRoofArea(84.42);
        building.getBuildinginformation().add(areas);

        var insulation = factory.createBuildingStructureInformation();
        insulation.setRcWall(1.7);
        insulation.setRcRoof(3.5);
        insulation.setRcFloor(3.5);
        insulation.setUWindow(1.4);
        insulation.setUDoor(1.4);
        building.getBuildinginformation().add(insulation);

        return building;
    }
}
