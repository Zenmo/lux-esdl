package energy.lux.esdl.core.loader.pv;

import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.NotImplemented;
import esdl.EsdlFactory;
import esdl.PVInstallation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * The November 2026 ISIE files locate every PV installation at the same point in Zeeland, without a CRS.
 */
public class PVSiteTest {
    private static final EsdlFactory factory = EsdlFactory.eINSTANCE;

    @Test
    public void theLocationThePVInstallationsShareIsTheSite() {
        var site = PVSite.readFrom(List.of(
                locatedAt(51.532534, 3.882267, null),
                locatedAt(51.532534, 3.882267, "WGS84"),
                unlocated()
        ));

        assertThat(site).isEqualTo(new PVSite(51.532534, 3.882267, "Europe/Amsterdam"));
    }

    @Test
    public void withoutLocationsThePVIsModelledAtCabauw() {
        assertThat(PVSite.readFrom(List.of(unlocated()))).isEqualTo(PVSite.cabauw());
    }

    @Test
    public void differentLocationsAreNotImplemented() {
        var pvInstallations = List.of(locatedAt(51.5, 3.9, null), locatedAt(52.0, 4.9, null));

        assertThatThrownBy(() -> PVSite.readFrom(pvInstallations)).isInstanceOf(NotImplemented.class);
    }

    // The ISIE files place their assets on a diagram with CRS "Simple"; that is not a place on earth.
    @Test
    public void aLocationThatIsNotLatitudeAndLongitudeIsRefused() {
        var pvInstallations = List.of(locatedAt(360.0, 236.0, "Simple"));

        assertThatThrownBy(() -> PVSite.readFrom(pvInstallations)).isInstanceOf(EsdlException.class);
    }

    private static PVInstallation locatedAt(double latitude, double longitude, String crs) {
        var point = factory.createPoint();
        point.setLat(latitude);
        point.setLon(longitude);
        point.setCRS(crs);
        var pvInstallation = unlocated();
        pvInstallation.setGeometry(point);
        return pvInstallation;
    }

    private static PVInstallation unlocated() {
        var pvInstallation = factory.createPVInstallation();
        pvInstallation.setName("pv");
        return pvInstallation;
    }
}
