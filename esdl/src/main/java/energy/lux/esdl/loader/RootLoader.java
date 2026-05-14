package energy.lux.esdl.loader;

import esdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.EnergyModel;
import zerointerfaceloader.Zero_Loader;

/**
 * Transform ESDL EnergySystem to a LUX EnergyModel.
 */
public class RootLoader {
    private static final Logger logger = LoggerFactory.getLogger(RootLoader.class);

    /**
     * LUX {@link EnergyModel} is a property of the loader {@link Zero_Loader}.
     * The loader is passed because it might have some useful methods.
     */
    public static void loadEsdlIntoLux(
            EnergySystem esdlEnergySystem,
            Zero_Loader luxLoader
    ) {
        loadEnvironmentalProfiles(esdlEnergySystem.getEnergySystemInformation(), luxLoader);
        loadParties(esdlEnergySystem.getParties(), luxLoader);
        loadMeasures(esdlEnergySystem.getMeasures(), luxLoader);
        loadServices(esdlEnergySystem.getServices(), luxLoader);

        for (Instance instance : esdlEnergySystem.getInstance()) {
            Area area = instance.getArea();
            if (area != null) {
                AreaLoader.loadArea(area, luxLoader);
            }
        }
    }

    private static void loadEnvironmentalProfiles(
            EnergySystemInformation info,
            Zero_Loader luxLoader
    ) {
        if (info == null) return;
        EnvironmentalProfiles environmentalProfiles = info.getEnvironmentalProfiles();
        if (environmentalProfiles == null) return;

        DateTimeProfileLoader.loadOutsideTemperature(environmentalProfiles, luxLoader);
        DateTimeProfileLoader.loadSolarIrradiance(environmentalProfiles, luxLoader);

        if (environmentalProfiles.getSoilTemperatureProfile() != null) {
            logger.info("Skipping soil temperature profile, not implemented in LUX");
        }
    }

    private static void loadParties(Parties parties, Zero_Loader luxLoader) {
        if (parties == null) return;
        for (Party party : parties.getParty()) {
            // TODO: handle party (e.g. DSO)
        }
    }

    private static void loadMeasures(Measures measures, Zero_Loader luxLoader) {
        if (measures == null) return;
        for (AbstractMeasure abstractMeasure : measures.getMeasure()) {
            if (abstractMeasure instanceof Measure measure) {
                CostInformation costInfo = measure.getCostInformation();
                // TODO: use cost information (e.g. bandwidth tariff prices)
            }
        }
    }

    private static void loadServices(Services services, Zero_Loader luxLoader) {
        if (services == null) return;
        for (Service service : services.getService()) {
            if (service instanceof EnergyMarket energyMarket) {
                DateTimeProfileLoader.loadDayAheadElectricityPricing(energyMarket, luxLoader);
            } else {
                logger.warn("Loading ESDL service type {} not implemented", service.getClass());
            }
        }
    }
}
