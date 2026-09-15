package energy.lux.esdl.core.util;

import esdl.EnergyAsset;
import esdl.GenericProfile;
import esdl.Item;
import esdl.Port;
import org.eclipse.emf.ecore.EObject;

public class Util {
    public static String printObject(EObject eCoreObject) {
        if (eCoreObject instanceof Item item) {
            return printItem(item);
        } else {
            return eCoreObject.eClass().getInstanceClassName();
        }
    }

    public static String printItem(Item esdlItem) {
        return esdlItem.eClass().getInstanceClassName() + "[id=" + esdlItem.getId() + "]";
    }

    /**
     * The assets in the decorated ESDL files carry at most one profile,
     * but which port holds it differs per file.
     */
    public static GenericProfile findFirstProfile(EnergyAsset asset) {
        for (Port port : asset.getPort()) {
            for (GenericProfile profile : port.getProfile()) {
                if (profile != null) {
                    return profile;
                }
            }
        }
        return null;
    }

    /**
     * Assets in the decorated files identify themselves through whichever of id, description
     * and name their generator happened to fill in, so a name is built from the first one that
     * is there.
     */
    public static String firstNonBlank(String... candidates) {
        for (String candidate : candidates) {
            if (candidate != null && !candidate.isBlank()) {
                return candidate;
            }
        }
        throw new IllegalArgumentException("No non-blank candidate given");
    }

    public static double defaultIfZero(double value, double defaultValue) {
        if (value == 0.0) {
            return defaultValue;
        } else {
            return value;
        }
    }

    public static void throwIfZero(double value, Item esdlItem, String property) {
        if (value == 0.0) {
            throw new RuntimeException(
                    String.format("%s of %s is zero", uppercaseFirst(property), printItem(esdlItem))
            );
        }
    }

    private static String uppercaseFirst(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
