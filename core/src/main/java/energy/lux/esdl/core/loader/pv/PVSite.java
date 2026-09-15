package energy.lux.esdl.core.loader.pv;

public record PVSite(
        double latitudeDegrees,
        double longitudeDegrees,
        String timeZone
) {
    /**
     * The KNMI measurement mast at Cabauw.
     */
    public static PVSite cabauw() {
        return new PVSite(51.971, 4.927, "Europe/Amsterdam");
    }
}
