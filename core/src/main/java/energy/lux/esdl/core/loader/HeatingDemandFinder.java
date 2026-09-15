package energy.lux.esdl.core.loader;

import esdl.AbstractBuilding;
import esdl.Asset;
import esdl.HeatDemandTypeEnum;
import esdl.HeatPump;
import esdl.HeatingDemand;
import esdl.HybridHeatPump;
import esdl.OutPort;
import esdl.Port;

/**
 * Find the heat demand of a house.
 * <p>
 * The decorated congestion files do not put the HeatingDemand inside the building. It sits in
 * the area and is shared between the houses that happen to have the same demand, so the only
 * way to it is through the OutPorts of the building's heat pump. A house without a heat pump
 * therefore has no heat demand stated at all, and there are 172 of those out of 224.
 */
public class HeatingDemandFinder {

    public static HeatingDemand findHeatingDemand(AbstractBuilding building, HeatDemandTypeEnum demandType) {
        for (Asset asset : building.getAsset()) {
            if (!isHeatPump(asset)) {
                continue;
            }

            var heatingDemand = findHeatingDemandBehindHeatPump((esdl.EnergyAsset) asset, demandType);
            if (heatingDemand != null) {
                return heatingDemand;
            }
        }
        return null;
    }

    private static boolean isHeatPump(Asset asset) {
        return asset instanceof HeatPump || asset instanceof HybridHeatPump;
    }

    private static HeatingDemand findHeatingDemandBehindHeatPump(
            esdl.EnergyAsset heatPump,
            HeatDemandTypeEnum demandType
    ) {
        for (Port port : heatPump.getPort()) {
            if (!(port instanceof OutPort outPort)) {
                continue;
            }
            for (var connectedInPort : outPort.getConnectedTo()) {
                var connectedAsset = connectedInPort.getEnergyasset();
                if (connectedAsset instanceof HeatingDemand heatingDemand
                        && heatingDemand.getType() == demandType) {
                    return heatingDemand;
                }
            }
        }
        return null;
    }
}
