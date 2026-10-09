package energy.lux.esdl.core;

import esdl.EnergySystem;
import esdl.EsdlPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.io.IOException;
import java.net.URL;
import java.util.TimeZone;

/**
 * Read ESDL XML to an object.
 */
public class ESDLReader {
    static {
        pinDateParsingToUtc();
        EsdlPackage.eINSTANCE.eClass();
    }

    /**
     * Make EMF resolve the ESDL's timestamps as UTC rather than as local time of this machine.
     * <p>
     * The ESDL writes a startDateTime as "2050-01-01T00:00:00.000000", and an xsd:dateTime with no
     * offset is a local time of unspecified zone, so EMF resolves it against the default zone of
     * the JVM. On a machine set to Europe/Amsterdam that puts the sun an hour and three quarters
     * out of position: averaged over a summer the irradiance of these files peaks at 13:50
     * Amsterdam time when read as UTC, against a true solar noon of 13:40, and at 11:50 when read
     * as local. It also made the same file load differently on differently configured machines.
     * <p>
     * EMF captures the zone the first time it converts a date and reuses it from then on, so the
     * only way to steer it is to get in first. Parsing one date here with the default set to UTC
     * pins it, after which the default is restored: setting it for the whole run is not an option,
     * because the simulation year is derived from a start date of midnight in Amsterdam, which is
     * the 31st of December in UTC, and LUX has no averages table for that year.
     * <p>
     * A stamp that does carry an offset, as the weather of the older files does, names an absolute
     * moment and is unaffected by any of this.
     */
    private static void pinDateParsingToUtc() {
        var callerTimeZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        try {
            EcoreUtil.createFromString(EcorePackage.eINSTANCE.getEDate(), "2050-01-01T00:00:00.000000");
        } finally {
            TimeZone.setDefault(callerTimeZone);
        }
    }

    public static EnergySystem readResource(String fileName) {
        try {
            var javaUrl = new URL("file:" + fileName);
            return readResource(javaUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static EnergySystem readResource(URL javaUrl) {
        var eclipseUri = URI.createURI(javaUrl.toString());

        XMIResource resource = new XMIResourceImpl(eclipseUri);
        try {
            resource.load(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (EnergySystem) resource.getContents().get(0);
    }
}
