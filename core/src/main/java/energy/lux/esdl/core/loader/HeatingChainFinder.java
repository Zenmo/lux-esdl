package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.util.Util;
import esdl.AbstractBuilding;
import esdl.Asset;
import esdl.ElectricityNetwork;
import esdl.EnergyAsset;
import esdl.HeatDemandTypeEnum;
import esdl.HeatPump;
import esdl.HeatingDemand;
import esdl.HybridHeatPump;
import esdl.InPort;
import esdl.OutPort;
import esdl.Port;
import esdl.WaterBuffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Find which buffer feeds which heat demand of a house, by following the ports from its heat pump.
 * <p>
 * The decorated ESDL files do not put the HeatingDemand inside the building. It sits in the area
 * and is shared between the houses that have the same demand, so the ports of the heat pump are
 * the only way to it. The buffers sit in the building, but nothing besides the ports says which
 * demand they serve: their names are not to be relied on.
 */
public class HeatingChainFinder {

    /**
     * A full heat pump fills a hot water buffer and a space heating buffer, each in front of
     * its own demand.
     */
    public static List<HeatingChain> findHeatPumpChains(HeatPump heatPump) {
        var chains = findHeatingChains(heatPump);
        assertSpaceHeatingChainWithBuffer(heatPump, chains);
        assertHotWaterChainWithBuffer(heatPump, chains);
        return chains;
    }

    /**
     * A hybrid fills a space heating buffer and heats the hot water with its gas burner in the
     * timestep it is drawn. A hot water buffer would never be used, so it is not accepted.
     */
    public static List<HeatingChain> findHybridHeatPumpChains(HybridHeatPump hybridHeatPump) {
        var chains = findHeatingChains(hybridHeatPump);
        assertSpaceHeatingChainWithBuffer(hybridHeatPump, chains);
        assertNoHotWaterBuffer(hybridHeatPump, chains);
        return chains;
    }

    /**
     * @return the chain that ends in a demand of this type, or null when there is none
     */
    public static HeatingChain findChainOfType(List<HeatingChain> chains, HeatDemandTypeEnum demandType) {
        HeatingChain found = null;
        for (HeatingChain chain : chains) {
            if (chain.type() != demandType) {
                continue;
            }
            if (found != null) {
                throw new NotImplemented(String.format(
                        "Two %s chains behind one heat pump, through buffers %s and %s",
                        demandType,
                        describeBuffer(found),
                        describeBuffer(chain)
                ));
            }
            found = chain;
        }
        return found;
    }

    public static boolean containsHeatPump(AbstractBuilding building) {
        for (Asset asset : building.getAsset()) {
            if (isHeatPump(asset)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return whether a heat pump feeds this demand, directly or through a water buffer
     */
    public static boolean isReachedByHeatPump(HeatingDemand heatingDemand) {
        for (EnergyAsset feedingAsset : feedingAssets(heatingDemand)) {
            if (isHeatPump(feedingAsset)) {
                return true;
            }
            if (feedingAsset instanceof WaterBuffer waterBuffer && isFedByHeatPump(waterBuffer)) {
                return true;
            }
        }
        return false;
    }

    static List<HeatingChain> findHeatingChains(EnergyAsset heatPump) {
        var chains = new ArrayList<HeatingChain>();
        for (EnergyAsset connectedAsset : connectedAssets(heatPump)) {
            addChainStartingAt(connectedAsset, heatPump, chains);
        }
        return chains;
    }

    private static void addChainStartingAt(EnergyAsset asset, EnergyAsset heatPump, List<HeatingChain> chains) {
        if (asset instanceof WaterBuffer waterBuffer) {
            chains.add(new HeatingChain(findSingleDemandBehind(waterBuffer), waterBuffer));
        } else if (asset instanceof HeatingDemand heatingDemand) {
            chains.add(new HeatingChain(assertKnownType(heatingDemand), null));
        } else if (asset instanceof ElectricityNetwork) {
            // The heat pump also feeds the phase it draws its electricity from, which is not heat.
        } else {
            throw new NotImplemented(String.format(
                    "Heat pump %s feeds %s, only a WaterBuffer, a HeatingDemand or an ElectricityNetwork is implemented",
                    Util.printItem(heatPump),
                    Util.printItem(asset)
            ));
        }
    }

    private static HeatingDemand findSingleDemandBehind(WaterBuffer waterBuffer) {
        var demands = new ArrayList<HeatingDemand>();
        for (EnergyAsset connectedAsset : connectedAssets(waterBuffer)) {
            demands.add(assertKnownType(asHeatingDemand(connectedAsset, waterBuffer)));
        }
        if (demands.size() != 1) {
            throw new NotImplemented(String.format(
                    "Water buffer %s feeds %d heating demands, exactly one is implemented",
                    Util.printItem(waterBuffer),
                    demands.size()
            ));
        }
        return demands.get(0);
    }

    private static HeatingDemand asHeatingDemand(EnergyAsset asset, WaterBuffer waterBuffer) {
        if (asset instanceof HeatingDemand heatingDemand) {
            return heatingDemand;
        }
        throw new NotImplemented(String.format(
                "Water buffer %s feeds %s, only a HeatingDemand is implemented",
                Util.printItem(waterBuffer),
                Util.printItem(asset)
        ));
    }

    private static HeatingDemand assertKnownType(HeatingDemand heatingDemand) {
        var demandType = heatingDemand.getType();
        if (demandType != HeatDemandTypeEnum.HOT_TAPWATER && demandType != HeatDemandTypeEnum.SPACE_HEATING) {
            throw new NotImplemented(String.format(
                    "HeatingDemand %s has type %s, only HOT_TAPWATER and SPACE_HEATING are implemented",
                    heatingDemand.getName(),
                    demandType
            ));
        }
        return heatingDemand;
    }

    private static void assertSpaceHeatingChainWithBuffer(EnergyAsset heatPump, List<HeatingChain> chains) {
        var spaceHeatingChain = findChainOfType(chains, HeatDemandTypeEnum.SPACE_HEATING);
        if (spaceHeatingChain == null || spaceHeatingChain.buffer() == null) {
            throw new NotImplemented(
                    "Heat pump " + Util.printItem(heatPump) + " does not feed a space heating demand through a water buffer"
            );
        }
    }

    private static void assertHotWaterChainWithBuffer(HeatPump heatPump, List<HeatingChain> chains) {
        var hotWaterChain = findChainOfType(chains, HeatDemandTypeEnum.HOT_TAPWATER);
        if (hotWaterChain == null || hotWaterChain.buffer() == null) {
            throw new NotImplemented(
                    "Heat pump " + Util.printItem(heatPump) + " does not feed a hot water demand through a water buffer"
            );
        }
    }

    private static void assertNoHotWaterBuffer(HybridHeatPump hybridHeatPump, List<HeatingChain> chains) {
        var hotWaterChain = findChainOfType(chains, HeatDemandTypeEnum.HOT_TAPWATER);
        if (hotWaterChain != null && hotWaterChain.buffer() != null) {
            throw new NotImplemented(String.format(
                    "Hybrid heat pump %s feeds its hot water through buffer %s, but its gas burner heats the hot water"
                            + " in the timestep it is drawn, so a buffer would never be used",
                    Util.printItem(hybridHeatPump),
                    Util.printItem(hotWaterChain.buffer())
            ));
        }
    }

    private static boolean isFedByHeatPump(WaterBuffer waterBuffer) {
        for (EnergyAsset feedingAsset : feedingAssets(waterBuffer)) {
            if (isHeatPump(feedingAsset)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isHeatPump(Asset asset) {
        return asset instanceof HeatPump || asset instanceof HybridHeatPump;
    }

    /**
     * @return the owners of the InPorts the OutPorts of this asset are connected to
     */
    private static List<EnergyAsset> connectedAssets(EnergyAsset asset) {
        var connectedAssets = new ArrayList<EnergyAsset>();
        for (Port port : asset.getPort()) {
            if (port instanceof OutPort outPort) {
                for (InPort connectedInPort : outPort.getConnectedTo()) {
                    connectedAssets.add(connectedInPort.getEnergyasset());
                }
            }
        }
        return connectedAssets;
    }

    /**
     * @return the owners of the OutPorts the InPorts of this asset are connected to
     */
    private static List<EnergyAsset> feedingAssets(EnergyAsset asset) {
        var feedingAssets = new ArrayList<EnergyAsset>();
        for (Port port : asset.getPort()) {
            if (port instanceof InPort inPort) {
                for (OutPort connectedOutPort : inPort.getConnectedTo()) {
                    feedingAssets.add(connectedOutPort.getEnergyasset());
                }
            }
        }
        return feedingAssets;
    }

    private static String describeBuffer(HeatingChain chain) {
        return chain.buffer() == null ? "none" : Util.printItem(chain.buffer());
    }
}
