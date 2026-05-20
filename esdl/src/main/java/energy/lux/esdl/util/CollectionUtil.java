package energy.lux.esdl.util;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class CollectionUtil {
    public static <E> E findSingle(Iterable<E> collection, Function<? super E, Boolean> matchFn) {
        return findSingle(collection, matchFn, "item");
    }

    public static <E> E findSingle(Iterable<E> collection, Function<? super E, Boolean> matchFn, String itemDescription) {
        var matches = new ArrayList<E>();

        for (var item: collection) {
            if (matchFn.apply(item)) {
                matches.add(item);
            }
        }

        return single(matches, itemDescription);
    }

    public static <E> E single(List<E> items, String itemDescription) {
        return switch (items.size()) {
            case 0 -> throw new NoSuchElementException(
                    String.format("No %s found, expected exactly one", itemDescription)
            );
            case 1 -> items.get(0);
            default -> throw new NoSuchElementException(
                    String.format("Multiple %s found, expected exactly one", itemDescription)
            );
        };
    }
}
