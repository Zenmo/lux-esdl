package energy.lux.esdl;

import esdl.Import;
import esdl.Item;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Util {
    public static String printItem(Item esdlItem) {
        return esdlItem.eClass().getInstanceClassName() + "[id=" + esdlItem.getId() + "]";
    }

    public static <E> E findSingle(Iterable<E> collection, Function<? super E, Boolean> matchFn, String itemDescription) {
        var matches = new ArrayList<E>();

        for (var item: collection) {
            if (matchFn.apply(item)) {
                matches.add(item);
            }
        }

        return switch (matches.size()) {
            case 0 -> throw new NoSuchElementException(String.format("No %s found, expected exactly one", itemDescription));
            case 1 -> matches.get(0);
            default -> throw new NoSuchElementException(String.format("Multiple %s found, expected exactly one", itemDescription));
        };
    }

    public static double defaultIfZero(double value, double defaultValue) {
        if (value == 0.0) {
            return defaultValue;
        } else {
            return value;
        }
    }
}
