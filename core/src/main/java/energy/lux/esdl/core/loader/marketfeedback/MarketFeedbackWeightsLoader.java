package energy.lux.esdl.core.loader.marketfeedback;

import energy.lux.engine.EnergyModel;
import energy.lux.engine.actors.EnergyCoop;
import energy.lux.engine.dataclasses.J_MarketFeedbackWeights;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.managementclasses.aggregatormanagements.aggregatorenergymanagements.J_ISIE_Aggregator_EMS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Gives the ISIE aggregators the weights that make their price feedback that of the assets in the country their
 * neighbourhood stands for. A weight is the number of planned assets of a kind in the country, the national count
 * times the dynamic contract share, divided by the number the aggregators plan in this model. All aggregators of the
 * model get the same weights, because the ESDL as a whole stands for the archetype.
 * <p>
 * Without a represented archetype the aggregators keep their national constants.
 */
public final class MarketFeedbackWeightsLoader {
    private static final Logger logger = LoggerFactory.getLogger(MarketFeedbackWeightsLoader.class);

    private MarketFeedbackWeightsLoader() {
    }

    public static void setMarketFeedbackWeights(EnergyModel energyModel, RepresentedArchetype archetype) {
        var coops = findIsieCoops(energyModel);
        if (archetype == null || coops.isEmpty()) {
            logger.info("No represented archetype or no ISIE aggregators, so the market feedback uses the national constants");
            return;
        }
        var weights = weightsOf(NationalAssetCounts.of(archetype), archetype.dynamicContractShare(), plannedAssetCounts(coops));
        for (var coop : coops) {
            ((J_ISIE_Aggregator_EMS) coop.f_getAggregatorEnergyManagement()).setMarketFeedbackWeights(weights);
        }
        logger.info("Set the market feedback weights of {} aggregators to {} for {}", coops.size(), weights, archetype);
    }

    static J_MarketFeedbackWeights weightsOf(NationalAssetCounts national, double dynamicContractShare, PlannedAssetCounts planned) {
        return new J_MarketFeedbackWeights(
                weight("heat pumps", national.heatPumps() * dynamicContractShare, planned.heatPumps()),
                weight("hybrid heat pumps", national.hybridHeatPumps() * dynamicContractShare, planned.hybridHeatPumps()),
                weight("EVs", national.evs() * dynamicContractShare, planned.evs()),
                weight("V2G EVs", national.v2gEvs() * dynamicContractShare, planned.v2gEvs()),
                weight("batteries", national.batteries() * dynamicContractShare, planned.batteries())
        );
    }

    /**
     * Zero when the model plans none of a kind, as there is nothing to weigh. The planned assets of that kind in the
     * country then move the price in no model, which is worth a warning.
     */
    private static double weight(String kind, double nationalPlanned, int planned) {
        if (planned == 0) {
            if (nationalPlanned > 0) {
                logger.warn("The model plans no {}, so the {} planned in the country it stands for do not move the price", kind, Math.round(nationalPlanned));
            }
            return 0;
        }
        if (nationalPlanned == 0) {
            logger.warn("The country plans no {} in this archetype, so the {} the model plans do not move the price", kind, planned);
        }
        return nationalPlanned / planned;
    }

    private static PlannedAssetCounts plannedAssetCounts(List<EnergyCoop> coops) {
        List<GridConnection> gridConnections = new ArrayList<>();
        for (var coop : coops) {
            gridConnections.addAll(coop.f_getAllChildMemberGridConnections());
        }
        return PlannedAssetCounts.of(gridConnections);
    }

    private static List<EnergyCoop> findIsieCoops(EnergyModel energyModel) {
        var coops = new ArrayList<EnergyCoop>();
        for (var energyCoop : energyModel.pop_energyCoops) {
            if (energyCoop.f_getAggregatorEnergyManagement() instanceof J_ISIE_Aggregator_EMS) {
                coops.add(energyCoop);
            }
        }
        return coops;
    }
}
