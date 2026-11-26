package energy.lux.esdl.core.loader.marketfeedback;

import energy.lux.engine.dataclasses.J_MarketFeedbackWeights;
import energy.lux.esdl.core.EsdlException;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

public class MarketFeedbackWeightsLoaderTest {
    private static final RepresentedArchetype oldHousesWithoutDistrictHeating = new RepresentedArchetype("km", "1woDH", 0.8);

    // The houses from before 1920 without district heating, summed over the pockets of the archetype data.
    @Test
    public void readsTheCountsOfAnArchetype() {
        var counts = NationalAssetCounts.of(oldHousesWithoutDistrictHeating);

        assertThat(counts.households()).isCloseTo(482243.1, within(0.1));
        assertThat(counts.evs()).isCloseTo(215017.9, within(0.1));
        assertThat(counts.batteries()).isCloseTo(11989.9, within(0.1));
    }

    @Test
    public void readsTheCountsOfAnArchetypeInOnePocket() {
        var counts = NationalAssetCounts.of(new RepresentedArchetype("km", 1, "1woDH", 0.8));

        assertThat(counts.households()).isCloseTo(32896.0, within(0.1));
        assertThat(counts.heatPumps()).isCloseTo(20350.8, within(0.1));
        assertThat(counts.hybridHeatPumps()).isCloseTo(9289.1, within(0.1));
        assertThat(counts.evs()).isCloseTo(13514.2, within(0.1));
        assertThat(counts.v2gEvs()).isCloseTo(1932.5, within(0.1));
        assertThat(counts.batteries()).isCloseTo(1261.5, within(0.1));
    }

    // Otherwise the ESDLs of the pockets would together stand for more or less than the country.
    @Test
    public void thePocketsOfAnArchetypeAddUpToTheCountry() {
        var wholeCountry = NationalAssetCounts.of(oldHousesWithoutDistrictHeating);
        var householdsOfPockets = IntStream.rangeClosed(1, 16)
                .mapToObj(pocket -> new RepresentedArchetype("km", pocket, "1woDH", 0.8))
                .mapToDouble(archetype -> NationalAssetCounts.of(archetype).households())
                .sum();

        assertThat(householdsOfPockets).isCloseTo(wholeCountry.households(), within(0.1));
    }

    @Test
    public void aPocketThatIsNotInTheTableIsRefused() {
        assertThatThrownBy(() -> NationalAssetCounts.of(new RepresentedArchetype("km", 17, "1woDH", 0.8)))
                .isInstanceOf(EsdlException.class)
                .hasMessageContaining("pocket 17");
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
