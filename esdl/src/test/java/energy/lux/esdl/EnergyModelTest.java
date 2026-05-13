package energy.lux.esdl;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;
import zero_engine.OL_EnergyCarriers;
import zero_engine.OL_PVOrientation;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EnergyModelTest {
    @Test
    public void testEmptyEnergyModel() throws IOException, InvalidFormatException {
        var loader = GenericInit.createEnergyModel();
        var energyModel = loader.energyModel;
        energyModel.f_initializeEngine();

        assertEquals(0, energyModel.v_timeStepsElapsed);
        energyModel.f_runTimestep();
        assertEquals(1, energyModel.v_timeStepsElapsed);
        energyModel.f_runTimestep();
        assertEquals(2, energyModel.v_timeStepsElapsed);
    }

    @Test
    public void testEnergyModelWithResidentialPv() throws IOException, InvalidFormatException {
        var loader = GenericInit.createEnergyModel();
        var energyModel = loader.energyModel;

        var gridNode = energyModel.add_pop_gridNodes();
        gridNode.p_gridNodeID = "gridNode_1";
        gridNode.p_energyCarrier = OL_EnergyCarriers.ELECTRICITY;

        var house = energyModel.add_Houses();
        house.p_gridConnectionID = "house_1";
        house.set_p_parentNodeElectric(gridNode);
        house.set_p_parentNodeElectricID(gridNode.p_gridNodeID);

        var owner = energyModel.add_pop_connectionOwners();
        house.p_ownerID = owner.p_actorID = house.p_gridConnectionID + "_owner";

        loader.f_addPVProductionAsset(house, "prosumer panels", 17.0, OL_PVOrientation.SOUTH);

        energyModel.f_initializeEngine();
        // run for 24 hours
        var i = 0;
        for (
                double hours = 0.0;
                hours < 24;
                hours += energyModel.p_timeParameters.getTimeStep_h()
        ) {
            i++;
            energyModel.f_runTimestep();
        }

        assertEquals(i, energyModel.v_timeStepsElapsed);

        // we have some PV generation on the 1st of january
        var supplyDataSet = energyModel.v_liveData.dsm_liveSupply_kW.get(OL_EnergyCarriers.ELECTRICITY);
        assertTrue(supplyDataSet.getYMax() > 0.2);

        // but no demand because we did not add any consumption assets
        var demandDataSet = energyModel.v_liveData.dsm_liveDemand_kW.get(OL_EnergyCarriers.ELECTRICITY);
        assertEquals(0.0, demandDataSet.getYMax());
    }
}
