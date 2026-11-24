package energy.lux.esdl.core.loader.pv;

import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.NotImplemented;
import esdl.Geometry;
import esdl.PVInstallation;
import esdl.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Where the PV panels are, which pvlib needs for the position of the sun and so for splitting the global horizontal
 * irradiance into its direct and diffuse parts.
 * The time zone is not in the ESDL; all ESDL files are of Dutch neighbourhoods.
 */
public record PVSite(
        double latitudeDegrees,
        double longitudeDegrees,
        String timeZone
) {
    private static final Logger logger = LoggerFactory.getLogger(PVSite.class);

    private static final String dutchTimeZone = "Europe/Amsterdam";
    // Point.CRS has no default; ESDL means latitude and longitude when it is left out.
    private static final Set<String> latitudeLongitudeCRSs = Set.of("WGS84", "WGS-84", "EPSG:4326");

    /**
     * The KNMI measurement mast at Cabauw. Stands in for ESDL files that do not locate their PV, as files before the
     * November 2026 ISIE generation did.
     */
    public static PVSite cabauw() {
        return new PVSite(51.971, 4.927, dutchTimeZone);
    }

    /**
     * The profiles are generated per orientation and shared by every installation with that orientation, so all
     * installations need one site. An installation without a location gets the site of the others.
     */
    public static PVSite readFrom(Collection<PVInstallation> pvInstallations) {
        var statedSites = new LinkedHashSet<PVSite>();
        for (var pvInstallation : pvInstallations) {
            var site = readSite(pvInstallation);
            if (site != null) {
                statedSites.add(site);
            }
        }
        if (statedSites.isEmpty()) {
            logger.warn("No PV installation states its location, so the PV profiles are modelled at Cabauw");
            return cabauw();
        }
        if (statedSites.size() > 1) {
            throw new NotImplemented(
                    "The PV installations state different locations, " + statedSites
                            + ", but LUX models the PV profiles of an ESDL at one site"
            );
        }
        var site = statedSites.iterator().next();
        logger.info("The PV profiles are modelled at the location the PV installations state, {}", site);
        return site;
    }

    // Null when the installation has no location.
    private static PVSite readSite(PVInstallation pvInstallation) {
        Geometry geometry = pvInstallation.getGeometry();
        if (geometry == null) {
            return null;
        }
        if (!(geometry instanceof Point point)) {
            throw new NotImplemented(String.format(
                    "PV installation %s has a %s as its geometry; only a Point is read as its location",
                    pvInstallation.getName(),
                    geometry.eClass().getName()
            ));
        }
        assertLatitudeLongitude(point, pvInstallation);
        return new PVSite(point.getLat(), point.getLon(), dutchTimeZone);
    }

    private static void assertLatitudeLongitude(Point point, PVInstallation pvInstallation) {
        var crs = point.getCRS();
        if (crs != null && !latitudeLongitudeCRSs.contains(crs.toUpperCase())) {
            throw new EsdlException(String.format(
                    "PV installation %s is located in CRS %s, but its location is read as latitude and longitude",
                    pvInstallation.getName(),
                    crs
            ));
        }
    }
}
