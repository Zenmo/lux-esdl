package energy.lux.esdl.core.loader.pv;

/**
 * The place the sun is computed for.
 * <p>
 * This cannot be read from the ESDL: the coordinates in the congestion scenario files are
 * obfuscated, placing the same neighbourhood in Cornwall and in central France, and at least
 * one of them has latitude and longitude the wrong way round. The irradiance series in those
 * same files is Dutch, measured at Cabauw, which is also where the two PV profiles that LUX
 * shipped with were measured.
 */
public record PVSite(
        double latitudeDegrees,
        double longitudeDegrees,
        String timeZone
) {
    /**
     * The KNMI measurement mast at Cabauw, the source of the irradiance in the scenario files.
     */
    public static PVSite cabauw() {
        return new PVSite(51.971, 4.927, "Europe/Amsterdam");
    }
}
