package energy.lux.esdl.core.loader.profile;

import esdl.QuantityAndUnitType;
import esdl.UnitEnum;
import esdl.util.EsdlSwitch;
import zero_engine.OL_ProfileUnits;

public class UnitReader {
    public OL_ProfileUnits esdlToLuxUnit(
            QuantityAndUnitType quantityAndUnit,
            String profileDescription
    ) {
        switch (quantityAndUnit.getUnit()) {
            UnitEnum.NONE ->
        }
    }
}
