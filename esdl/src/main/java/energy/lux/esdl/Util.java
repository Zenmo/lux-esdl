package energy.lux.esdl;

import esdl.Item;

public class Util {
    public static String printItem(Item esdlItem) {
        return esdlItem.eClass().getInstanceClassName() + "[id=" + esdlItem.getId() + "]";
    }
}
