package energy.lux.esdl.core.loader.marketfeedback;

/**
 * The part of the country a neighbourhood ESDL stands for. Several neighbourhoods, one per archetype, together stand
 * for all Dutch households; ISIE/Pockets_to_archetypes divides the national scenarios over them.
 * <p>
 * The ESDL does not state this yet, so whoever loads it names it. Later ESDL files are to state it themselves.
 *
 * @param stockFamily          the national scenario as far as it decides what households own: km, minflex, meerflex
 *                             or meerflex_minElek, the part of the scen_key of the archetype data before the adoption level
 * @param subArchetype         the GO-e archetype with or without district heating, for example 1woDH
 * @param dynamicContractShare the share of households in the country whose assets an aggregator plans
 *                             (adoptieniveau_prijsprikkels). Not the share in the ESDL, which the decorator may have
 *                             set otherwise.
 */
public record RepresentedArchetype(String stockFamily, String subArchetype, double dynamicContractShare) {
    public RepresentedArchetype {
        if (!(dynamicContractShare >= 0 && dynamicContractShare <= 1)) {
            throw new IllegalArgumentException(
                    "The dynamic contract share must be from 0 to 1, got " + dynamicContractShare
            );
        }
    }
}
