package energy.lux.esdl.core.loader.pv;

import esdl.PVInstallation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The tilt and azimuth of a PV installation, rounded to the resolution
 * at which production profiles are generated.
 * <p>
 * Rounding matters because every distinct orientation costs one pvlib model run and one profile
 * held in memory for the whole simulation. The congestion scenario files describe each roof
 * separately, so the raw pairs are almost as numerous as the installations themselves, while
 * two roofs a few degrees apart produce profiles that cannot be told apart.
 * <p>
 * Azimuth follows the convention shared by ESDL and pvlib: degrees clockwise from north,
 * so 90 is east, 180 is south and 270 is west.
 */
public record PVOrientation(int tiltDegrees, int azimuthDegrees) {
    private static final Logger logger = LoggerFactory.getLogger(PVOrientation.class);

    private static final int binSizeDegrees = 5;

    private static final int maximumTiltDegrees = 90;

    /**
     * Used when the ESDL states neither a tilt nor an azimuth. A tilted south-facing roof is
     * the common Dutch installation and matches the orientation that LUX assumed for every
     * installation before profiles were generated per orientation.
     */
    private static final PVOrientation unstatedOrientation = new PVOrientation(35, 180);

    /**
     * Read the orientation of an installation, rounded into its bin.
     * <p>
     * Both the up-front scan and the loading of an individual installation go through here,
     * so that the key a profile is stored under is the key it is later looked up by.
     */
    public static PVOrientation of(PVInstallation pvInstallation) {
        var tiltDegrees = pvInstallation.getAngle();
        var azimuthDegrees = pvInstallation.getOrientation();

        if (isUnstated(tiltDegrees, azimuthDegrees)) {
            logger.warn(
                    "PV installation {} states neither an angle nor an orientation, assuming {}",
                    pvInstallation.getName(),
                    unstatedOrientation
            );
            return unstatedOrientation;
        }

        return bin(tiltDegrees, azimuthDegrees);
    }

    /**
     * An absent attribute and an explicit zero are the same value in ESDL, so a flat
     * north-facing panel cannot be told apart from an installation that describes neither.
     * The latter is far more common: tue.esdl describes only roof area and panel efficiency.
     */
    private static boolean isUnstated(int tiltDegrees, int azimuthDegrees) {
        return tiltDegrees == 0 && azimuthDegrees == 0;
    }

    public static PVOrientation bin(int tiltDegrees, int azimuthDegrees) {
        return new PVOrientation(
                binTilt(tiltDegrees),
                binAzimuth(azimuthDegrees)
        );
    }

    private static int binTilt(int tiltDegrees) {
        if (tiltDegrees < 0 || tiltDegrees > maximumTiltDegrees) {
            throw new IllegalArgumentException(
                    "PV tilt of " + tiltDegrees + " degrees is outside [0, " + maximumTiltDegrees + "]"
            );
        }
        return roundToBin(tiltDegrees);
    }

    /**
     * A full turn lands back on north rather than on a 360 degree bin of its own.
     */
    private static int binAzimuth(int azimuthDegrees) {
        return roundToBin(Math.floorMod(azimuthDegrees, 360)) % 360;
    }

    private static int roundToBin(int degrees) {
        return Math.round((float) degrees / binSizeDegrees) * binSizeDegrees;
    }

    /**
     * The name the profile is registered under with the LUX engine.
     * The _fr suffix marks it as a fraction of installed power, as the engine's own PV
     * profiles do.
     */
    public String profileName() {
        return "pv_production_tilt" + tiltDegrees + "_azimuth" + azimuthDegrees + "_fr";
    }

    /**
     * How the orientation is written in the request to the profile generator.
     */
    public String toKey() {
        return tiltDegrees + ":" + azimuthDegrees;
    }

    public static PVOrientation fromKey(String key) {
        var parts = key.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Cannot read a PV orientation from " + key);
        }
        return new PVOrientation(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    @Override
    public String toString() {
        return tiltDegrees + " degrees tilt, " + azimuthDegrees + " degrees azimuth";
    }
}
