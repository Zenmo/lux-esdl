package energy.lux.esdl.core;

import esdl.EsdlPackage;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The ESDL states its profile timestamps without a time zone, and they mean UTC. This guards the
 * pinning in {@link ESDLReader}, which relies on EMF capturing the zone of its first conversion.
 */
class EsdlTimestampZoneTest {

    private static Instant parse(String text) {
        try {
            // Referencing the class is not enough; this runs its static block, which does the pinning.
            Class.forName(ESDLReader.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        var type = (EDataType) EsdlPackage.eINSTANCE.getTimeSeriesProfile_StartDateTime().getEType();
        return Instant.ofEpochMilli(((Date) EcoreUtil.createFromString(type, text)).getTime());
    }

    @Test
    void readsAnUnzonedTimestampAsUtc() {
        assertThat(parse("2050-01-01T00:00:00.000000")).isEqualTo(Instant.parse("2050-01-01T00:00:00Z"));
        assertThat(parse("2050-06-01T00:00:00.000000")).isEqualTo(Instant.parse("2050-06-01T00:00:00Z"));
    }

    @Test
    void leavesAStampThatStatesItsOffsetAlone() {
        assertThat(parse("2050-06-01T00:00:00.000000+0000")).isEqualTo(Instant.parse("2050-06-01T00:00:00Z"));
        assertThat(parse("2050-06-01T00:00:00.000000+0200")).isEqualTo(Instant.parse("2050-05-31T22:00:00Z"));
    }
}
