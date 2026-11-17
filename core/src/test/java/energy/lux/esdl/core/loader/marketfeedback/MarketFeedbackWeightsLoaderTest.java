package energy.lux.esdl.core.loader.marketfeedback;

import energy.lux.engine.dataclasses.J_MarketFeedbackWeights;
import energy.lux.esdl.core.EsdlException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

public class MarketFeedbackWeightsLoaderTest {
    private static final RepresentedArchetype oldHousesWithoutDistrictHeating = new RepresentedArchetype("km", "1woDH", 0.8);

    // The houses from before 1920 without district heating, summed over the pockets of the archetype data.
    @Test
    public void readsTheCountsOfAnArchetype() {
        var counts = NationalAssetCounts.of(oldHousesWithoutDistrictHeating);

        assertThat(counts.households()).isCloseTo(480158.8, within(0.1));
        assertThat(counts.evs()).isCloseTo(187899.7, within(0.1));
        assertThat(counts.batteries()).isCloseTo(10462.4, within(0.1));
    }

    @Test
    public void anArchetypeThatIsNotInTheTableIsRefused() {
        assertThatThrownBy(() -> NationalAssetCounts.of(new RepresentedArchetype("km", "9woDH", 0.8)))
                .isInstanceOf(EsdlException.class)
                .hasMessageContaining("9woDH");
    }

    // Only the dynamic contract share of the national assets is planned, and spread over the assets planned here.
    @Test
    public void aWeightIsThePlannedNationalCountPerPlannedAsset() {
        var national = new NationalAssetCounts(1000, 100, 200, 400, 50, 80);
        var planned = new PlannedAssetCounts(10, 20, 40, 5, 4);

        var weights = MarketFeedbackWeightsLoader.weightsOf(national, 0.5, planned);

        assertThat(weights).isEqualTo(new J_MarketFeedbackWeights(5, 5, 5, 5, 10));
    }

    @Test
    public void aKindTheModelDoesNotPlanWeighsNothing() {
        var national = new NationalAssetCounts(1000, 100, 200, 400, 50, 80);
        var planned = new PlannedAssetCounts(10, 20, 40, 0, 4);

        var weights = MarketFeedbackWeightsLoader.weightsOf(national, 1.0, planned);

        assertThat(weights.v2gEV()).isZero();
    }

    @Test
    public void aDynamicContractShareAboveOneIsRefused() {
        assertThatThrownBy(() -> new RepresentedArchetype("km", "1woDH", 1.5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
