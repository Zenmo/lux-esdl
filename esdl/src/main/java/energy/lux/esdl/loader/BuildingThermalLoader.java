package energy.lux.esdl.loader;

import energy.lux.esdl.NotImplemented;
import energy.lux.esdl.Util;
import esdl.AbstractBuilding;
import esdl.EnergyLabelEnum;
import esdl.GenericBuilding;
import zero_engine.GridConnection;
import zero_engine.J_HeatingPreferences;
import zero_engine.OL_GridConnectionEnergyLabel;
import zero_engine.OL_GridConnectionInsulationLabel;
import zerointerfaceloader.Zero_Loader;

public class BuildingThermalLoader {
    private static final double defaultFloorArea = 100;

    public static void loadBuilding(AbstractBuilding building, Zero_Loader luxLoader, GridConnection luxGridConnection) {
        if (building instanceof GenericBuilding genericBuilding) {
            loadGenericBuilding(genericBuilding, luxLoader, luxGridConnection);
        } else {
            throw new NotImplemented("Not implemented building type " + Util.printItem(building));
        }
    }

    private static void loadGenericBuilding(GenericBuilding building, Zero_Loader luxLoader, GridConnection luxGridConnection) {
        // Lux complains if these are not set
        luxGridConnection.p_energyLabel = toLuxEnergyLabel(building.getEnergyLabel());
        luxGridConnection.p_insulationLabel = toLuxInsulationLabel(building.getEnergyLabel());

        var floorAreaM2 = Util.defaultIfZero(building.getFloorArea(), defaultFloorArea);
        luxLoader.f_addBuildingHeatModel(luxGridConnection, floorAreaM2, null, new J_HeatingPreferences());
    }

    private static OL_GridConnectionEnergyLabel toLuxEnergyLabel(EnergyLabelEnum esdlEnergyLabel) {
        if (esdlEnergyLabel == null) {
            return OL_GridConnectionEnergyLabel.UNKNOWN;
        }

        return switch (esdlEnergyLabel) {
            case LABEL_A -> OL_GridConnectionEnergyLabel.A;
            case LABEL_B -> OL_GridConnectionEnergyLabel.B;
            case LABEL_C -> OL_GridConnectionEnergyLabel.C;
            case LABEL_D -> OL_GridConnectionEnergyLabel.D;
            case LABEL_E -> OL_GridConnectionEnergyLabel.E;
            case LABEL_F -> OL_GridConnectionEnergyLabel.F;
            case LABEL_G -> OL_GridConnectionEnergyLabel.G;
            case UNDEFINED -> OL_GridConnectionEnergyLabel.NONE;
            default -> throw new NotImplemented("Unknown energy label: " + esdlEnergyLabel);
        };
    }

    private static OL_GridConnectionInsulationLabel toLuxInsulationLabel(EnergyLabelEnum esdlEnergyLabel) {
        if (esdlEnergyLabel == null) {
            return OL_GridConnectionInsulationLabel.UNKNOWN;
        }

        return switch (esdlEnergyLabel) {
            case LABEL_A -> OL_GridConnectionInsulationLabel.A;
            case LABEL_B -> OL_GridConnectionInsulationLabel.B;
            case LABEL_C -> OL_GridConnectionInsulationLabel.C;
            case LABEL_D -> OL_GridConnectionInsulationLabel.D;
            case LABEL_E -> OL_GridConnectionInsulationLabel.E;
            case LABEL_F -> OL_GridConnectionInsulationLabel.F;
            case LABEL_G -> OL_GridConnectionInsulationLabel.G;
            case UNDEFINED -> OL_GridConnectionInsulationLabel.NONE;
            default -> throw new NotImplemented("Unknown energy label: " + esdlEnergyLabel);
        };
    }
}
