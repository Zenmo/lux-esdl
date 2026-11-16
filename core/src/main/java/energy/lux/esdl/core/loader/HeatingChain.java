package energy.lux.esdl.core.loader;

import esdl.HeatDemandTypeEnum;
import esdl.HeatingDemand;
import esdl.WaterBuffer;

/**
 * One path the heat of a house's heat pump takes to a demand profile, as the ports of the ESDL
 * lay it out: straight to the demand, or through one water buffer.
 * <p>
 * The demand usually sits in the area and is shared by several houses, so it says nothing about
 * this house beyond its profile and its comfort band.
 *
 * @param buffer null when the heat pump feeds the demand directly, which is how a hybrid heats
 *               its hot water
 */
public record HeatingChain(HeatingDemand demand, WaterBuffer buffer) {
    public HeatDemandTypeEnum type() {
        return demand.getType();
    }
}
