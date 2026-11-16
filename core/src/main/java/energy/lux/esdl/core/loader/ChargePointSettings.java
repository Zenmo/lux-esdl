package energy.lux.esdl.core.loader;

import energy.lux.engine.energyassets.J_EAEV;
import energy.lux.esdl.core.EsdlException;
import esdl.AbstractBuilding;
import esdl.Area;
import esdl.Asset;
import esdl.EVChargingStation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The settings of a charge point and its EV that the ESDL has no fields for. The ISIE decorator
 * writes them as JSON into the description of the EVChargingStation, for example
 * {"min_charge_rate_kwh": 1.4, "min_soc_percentage_v2g": 0.3, "efficiency": 0.95, "capacity_kwh": 75.0}.
 * Every setting is null when the description leaves it out.
 * <p>
 * The keys do not say what they mean in their units, so the following is assumed:
 * min_charge_rate_kwh is a power in kW, the 6 A minimum current of the charger on one phase;
 * min_soc_percentage_v2g is a fraction of the battery, not a percentage, and stating it is what
 * says the EV takes part in V2G; capacity_kwh is the battery of the EV.
 * efficiency is a value of the charge point, the converter, that holds for each direction:
 * charging puts that share of the grid energy in the battery, and discharging delivers that share
 * of the battery energy to the grid. It is not a round trip efficiency, so it is not square-rooted.
 * Without it the EV charges and discharges without losses.
 *
 * @param minimumChargePower_kW      min_charge_rate_kwh
 * @param v2gMinimumStateOfCharge_fr min_soc_percentage_v2g
 * @param chargingEfficiency_fr      efficiency
 * @param batteryCapacity_kWh        capacity_kwh
 */
public record ChargePointSettings(
        Double minimumChargePower_kW,
        Double v2gMinimumStateOfCharge_fr,
        Double chargingEfficiency_fr,
        Double batteryCapacity_kWh
) {
    private static final Logger logger = LoggerFactory.getLogger(ChargePointSettings.class);
    private static final JsonMapper jsonMapper = JsonMapper.builder().build();

    private static final String minimumChargePowerKey = "min_charge_rate_kwh";
    private static final String v2gMinimumStateOfChargeKey = "min_soc_percentage_v2g";
    private static final String chargingEfficiencyKey = "efficiency";
    private static final String batteryCapacityKey = "capacity_kwh";
    private static final Set<String> knownKeys = Set.of(
            minimumChargePowerKey,
            v2gMinimumStateOfChargeKey,
            chargingEfficiencyKey,
            batteryCapacityKey
    );

    public static final ChargePointSettings none = new ChargePointSettings(null, null, null, null);

    public boolean statesV2G() {
        return v2gMinimumStateOfCharge_fr != null;
    }

    // An EV keeps its default of no losses when the charge point states no efficiency.
    public void setChargingEfficienciesOf(J_EAEV electricVehicle) {
        if (chargingEfficiency_fr != null) {
            electricVehicle.setChargingEfficiencies(chargingEfficiency_fr, chargingEfficiency_fr);
        }
    }

    public static ChargePointSettings read(EVChargingStation chargingStation) {
        var description = chargingStation.getDescription();
        if (description == null || description.isBlank()) {
            return none;
        }
        if (!description.strip().startsWith("{")) {
            logger.warn(
                    "The description of charge point {} is not JSON, so it states no settings: {}",
                    chargingStation.getName(),
                    description
            );
            return none;
        }

        var json = parse(chargingStation, description);
        warnAboutUnknownKeys(chargingStation, json);
        var settings = new ChargePointSettings(
                readNumber(chargingStation, json, minimumChargePowerKey),
                readNumber(chargingStation, json, v2gMinimumStateOfChargeKey),
                readNumber(chargingStation, json, chargingEfficiencyKey),
                readNumber(chargingStation, json, batteryCapacityKey)
        );
        settings.assertV2GMinimumIsFraction(chargingStation);
        return settings;
    }

    /**
     * The settings of every charge point in the area and its sub-areas, the ones in buildings
     * included. Charge points whose description states nothing are left out.
     */
    public static List<ChargePointSettings> readAll(Area area) {
        var allSettings = new ArrayList<ChargePointSettings>();
        addSettingsOfArea(area, allSettings);
        return allSettings;
    }

    private static void addSettingsOfArea(Area area, List<ChargePointSettings> allSettings) {
        addSettingsOfAssets(area.getAsset(), allSettings);
        for (Area subArea : area.getArea()) {
            addSettingsOfArea(subArea, allSettings);
        }
    }

    private static void addSettingsOfAssets(List<Asset> assets, List<ChargePointSettings> allSettings) {
        for (Asset asset : assets) {
            if (asset instanceof AbstractBuilding building) {
                addSettingsOfAssets(building.getAsset(), allSettings);
            } else if (asset instanceof EVChargingStation chargingStation) {
                addSettingsOfChargingStation(chargingStation, allSettings);
            }
        }
    }

    private static void addSettingsOfChargingStation(
            EVChargingStation chargingStation,
            List<ChargePointSettings> allSettings
    ) {
        var settings = read(chargingStation);
        if (!settings.equals(none)) {
            allSettings.add(settings);
        }
    }

    private static JsonNode parse(EVChargingStation chargingStation, String description) {
        try {
            return jsonMapper.readTree(description);
        } catch (JacksonException exception) {
            throw new EsdlException(
                    "The description of charge point " + chargingStation.getName() + " is not valid JSON: " + description,
                    exception
            );
        }
    }

    private static void warnAboutUnknownKeys(EVChargingStation chargingStation, JsonNode json) {
        for (Map.Entry<String, JsonNode> property : json.properties()) {
            if (!knownKeys.contains(property.getKey())) {
                logger.warn(
                        "Charge point {} states {}, which the loader does not know, so it is ignored",
                        chargingStation.getName(),
                        property.getKey()
                );
            }
        }
    }

    private static Double readNumber(EVChargingStation chargingStation, JsonNode json, String key) {
        var value = json.get(key);
        if (value == null || value.isNull()) {
            return null;
        }
        if (!value.isNumber()) {
            throw new EsdlException(String.format(
                    "Charge point %s states %s as %s, which is not a number",
                    chargingStation.getName(),
                    key,
                    value
            ));
        }
        return value.doubleValue();
    }

    // Guards the assumption that it is a fraction despite its name: 30 instead of 0.3 would block all V2G.
    private void assertV2GMinimumIsFraction(EVChargingStation chargingStation) {
        if (v2gMinimumStateOfCharge_fr != null && (v2gMinimumStateOfCharge_fr < 0 || v2gMinimumStateOfCharge_fr >= 1)) {
            throw new EsdlException(String.format(
                    "Charge point %s states %s %s, but a fraction from 0 up to 1 is expected",
                    chargingStation.getName(),
                    v2gMinimumStateOfChargeKey,
                    v2gMinimumStateOfCharge_fr
            ));
        }
    }
}
