package energy.lux.esdl.core.loader.profile;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import esdl.GenericProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.EnergyModel;
import zero_engine.J_ProfilePointer;
import zero_engine.OL_ProfileUnits;

import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * Creates at most one LUX profile pointer per ESDL profile, under a name that is unique
 * within the LUX model.
 * <p>
 * Both guarantees are needed because of how the decorated ESDL files are put together.
 * The assets carrying the demand profiles have no id, so a name has to be derived from
 * whatever descriptive attributes the asset does have, and those are not guaranteed unique.
 * A single profile is also referenced by several grid connections through the connectedTo of
 * its port, and every grid connection is loaded separately, so without this cache the same
 * series would be handed to the engine once per grid connection.
 * <p>
 * Uniqueness matters because {@link EnergyModel#f_findProfile} resolves a profile by name and
 * returns the first match.
 * <p>
 * One instance is shared for the duration of loading one ESDL file.
 */
public class ProfilePointerRegistry {
    private static final Logger logger = LoggerFactory.getLogger(ProfilePointerRegistry.class);

    private final ProfilePointerFactory profilePointerFactory;

    /**
     * Identity rather than equality: two ESDL profiles holding the same numbers are still
     * two profiles, and EMF objects do not define value equality anyway.
     */
    private final Map<GenericProfile, J_ProfilePointer> pointersByEsdlProfile = new IdentityHashMap<>();

    private final Set<String> usedNames = new HashSet<>();

    /**
     * Every profile this registry created, so that one can also be found back by its name.
     * Needed by the profiles that are modelled rather than read from the ESDL, which have no
     * ESDL profile to key on.
     */
    private final Map<String, J_ProfilePointer> profilePointersByName = new HashMap<>();

    public ProfilePointerRegistry(EnergyModel luxModel) {
        this.profilePointerFactory = new ProfilePointerFactory(luxModel);

        // The LUX engine registers profiles of its own, and the model-wide profiles have
        // already been added by the time this registry is built. Their names are taken too.
        for (var existingProfile : luxModel.c_profiles) {
            usedNames.add(existingProfile.name);
        }
    }

    /**
     * Return the pointer already registered for this ESDL profile,
     * or read it and register it with the LUX engine.
     *
     * @param preferredName  a readable name derived from the asset that owns the profile.
     *                       A counter is appended when it is already taken.
     * @param readTimeSeries reads the profile and converts it to the unit LUX expects.
     *                       Only called the first time a profile is seen.
     */
    public J_ProfilePointer getOrCreateProfilePointer(
            GenericProfile esdlProfile,
            String preferredName,
            OL_ProfileUnits unit,
            Function<GenericProfile, ArrayTimeSeries> readTimeSeries
    ) {
        var existingPointer = pointersByEsdlProfile.get(esdlProfile);
        if (existingPointer != null) {
            return existingPointer;
        }

        var timeSeries = readTimeSeries.apply(esdlProfile);
        var name = makeNameUnique(preferredName);
        var profilePointer = profilePointerFactory.timeSeriesToProfilePointer(timeSeries, name, unit);

        pointersByEsdlProfile.put(esdlProfile, profilePointer);
        profilePointersByName.put(name, profilePointer);
        return profilePointer;
    }

    /**
     * Register a profile that has no ESDL profile behind it, under exactly the name given.
     * <p>
     * The PV production profiles are modelled rather than read, so there is no
     * {@link GenericProfile} to key them on. They are found back by name instead, which only
     * works if the name is not decorated the way {@link #makeNameUnique} would: a caller that
     * builds the same name to look one up would no longer find it.
     */
    public J_ProfilePointer registerProfilePointer(
            String name,
            ArrayTimeSeries timeSeries,
            OL_ProfileUnits unit
    ) {
        if (!usedNames.add(name)) {
            throw new IllegalStateException(
                    "A profile named " + name + " is already registered with the LUX engine"
            );
        }

        var profilePointer = profilePointerFactory.timeSeriesToProfilePointer(timeSeries, name, unit);
        profilePointersByName.put(name, profilePointer);
        return profilePointer;
    }

    /**
     * @return the profile registered under this name, or null when there is none
     */
    public J_ProfilePointer findProfilePointer(String name) {
        return profilePointersByName.get(name);
    }

    private String makeNameUnique(String preferredName) {
        var candidate = sanitize(preferredName);
        if (usedNames.add(candidate)) {
            return candidate;
        }

        for (int suffix = 2; ; suffix++) {
            var alternative = candidate + "_" + suffix;
            if (usedNames.add(alternative)) {
                logger.info("Profile name {} was already taken, using {} instead", candidate, alternative);
                return alternative;
            }
        }
    }

    /**
     * The names in the ESDL contain spaces and punctuation.
     * LUX only ever compares profile names, but they also end up in traces and charts.
     */
    private static String sanitize(String name) {
        if (name == null || name.isBlank()) {
            return "esdl_profile";
        }
        return name.trim().replaceAll("[^A-Za-z0-9]+", "_");
    }
}
