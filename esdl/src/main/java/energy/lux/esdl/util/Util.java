package energy.lux.esdl.util;

import esdl.Item;

public class Util {
    public static String printItem(Item esdlItem) {
        return esdlItem.eClass().getInstanceClassName() + "[id=" + esdlItem.getId() + "]";
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
