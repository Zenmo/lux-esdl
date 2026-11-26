package energy.lux.esdl.core;

import energy.lux.engine.EnergyModel;
import energy.lux.engine.J_ProfilePointer;
import energy.lux.engine.energyassets.J_EAConversionHeatPump;
import energy.lux.engine.energyassets.J_EAEV;
import energy.lux.engine.energyassets.J_EAProduction;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.managementclasses.aggregatormanagements.aggregatorenergymanagements.J_ISIE_Aggregator_EMS;
import energy.lux.engine.optionlists.OL_EnergyCarriers;
import energy.lux.esdl.core.iterator.RootIterator;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static energy.lux.esdl.core.TestUtil.findGridConnectionById;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Loads and runs single_home.esdl, a fabricated ESDL in the convention of the ISIE ESDLs: one house
 * with a heat pump, PV, a home battery and an EV on a dynamic contract, under a time of use tariff and
 * an active local congestion measure on a 3 kVA transformer. Its profiles are constant over the year,
 * or the same every day, so that what the loader should make of them can be worked out by hand.
 * <p>
 * The PV is modelled with pvlib, so this needs the Python that luxPythonExecutable names. That takes
 * long enough to load the file only once; the tests that read what was loaded do not depend on the
 * one that runs the model.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SingleHomeTest {
    private static final String gridConnectionId = "connection";

    private EnergyModel luxEngine;
    private GridConnection house;

    @BeforeAll
    public void loadSingleHome() {
        var esdl = ESDLReader.readResource(getClass().getResource("/single_home.esdl"));
        luxEngine = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, luxEngine);
        house = findGridConnectionById(luxEngine, gridConnectionId);
    }

    @Test
    public void testAssetsOfTheHouse() {
        assertThat(luxEngine.c_gridConnections).hasSize(1);
        assertThat(house.c_energyAssets).filteredOn(asset -> asset instanceof J_EAConversionHeatPump).hasSize(1);
        assertThat(house.c_energyAssets).filteredOn(asset -> asset instanceof J_EAProduction).hasSize(1);
        assertThat(house.c_energyAssets).filteredOn(asset -> asset instanceof J_EAEV).hasSize(1);
        assertThat(house.p_batteryAsset.getStorageCapacity_kWh()).isEqualTo(10.0, Offset.offset(1e-9));
    }

    @Test
    public void testBaseLoadIsScaledToTheTotalInItsName() {
        var baseLoad = house.c_consumptionAssets.stream()
                .filter(asset -> asset.getEnergyCarrier() == OL_EnergyCarriers.ELECTRICITY)
                .findFirst()
                .orElseThrow();
        assertThat(baseLoad.getBaseConsumption_kWh()).isEqualTo(3000.0, Offset.offset(0.01));
    }

    /**
     * The car is plugged in every evening and charges 10 kWh at the charge point, of which the
     * efficiency of 0.95 leaves 9.5 kWh in the battery for the trip of the next day.
     */
    @Test
    public void testTripsFollowFromChargingSessions() {
        var electricVehicle = findElectricVehicle();
        assertThat(electricVehicle.getStorageCapacity_kWh()).isEqualTo(75.0);
        assertThat(electricVehicle.getChargingEfficiency_r()).isEqualTo(0.95);

        var trips = electricVehicle.getTripTracker().getTripsStartingBetween_h(0, 2 * 8760);
        // 365 sessions leave 364 gaps between them.
        assertThat(trips).hasSize(364);

        var expectedDistance_km = 10.0 * 0.95 / electricVehicle.getEnergyConsumption_kWhpkm();
        for (var trip : trips) {
            assertThat(trip.endTime_h() - trip.startTime_h()).isEqualTo(10.0, Offset.offset(1e-9));
            assertThat(trip.distance_km()).isEqualTo(expectedDistance_km, Offset.offset(1e-9));
        }
    }

    /**
     * The ESDL states the tariff in UTC, so in winter its blocks fall an hour later on the Dutch
     * clock and in summer two. The weights are worth 600 EUR/MWh each.
     */
    @Test
    public void testTimeOfUseTariffFollowsTheSeason() {
        var tariff = findProfile("esdl_time_of_use_tariff_eur_per_mwh");

        var januaryFifteenth_h = 14 * 24.0;
        assertThat(tariff.getValue(januaryFifteenth_h + 4)).isEqualTo(0.5 * 600, Offset.offset(1e-9));
        assertThat(tariff.getValue(januaryFifteenth_h + 18)).isEqualTo(1.0 * 600, Offset.offset(1e-9));

        var julyFifteenth_h = 195 * 24.0;
        assertThat(tariff.getValue(julyFifteenth_h + 13)).isEqualTo(0.0, Offset.offset(1e-9));
        assertThat(tariff.getValue(julyFifteenth_h + 20)).isEqualTo(0.7 * 600, Offset.offset(1e-9));
    }

    @Test
    public void testAggregatorGetsTheTariffAndTheCongestionMeasure() {
        var aggregator = findAggregator();
        assertThat(aggregator.getTimeOfUseTariffProfile()).isSameAs(findProfile("esdl_time_of_use_tariff_eur_per_mwh"));
        assertThat(aggregator.getCongestionFactor_eurpMWhpkW()).isEqualTo(1000.0);
        // 90% of the 3 kVA transformer.
        assertThat(aggregator.getCongestionDeadzone_kW()).isEqualTo(2.7, Offset.offset(1e-9));
    }

    /**
     * The EV starts full and its trips take 9.5 kWh a day, so it first has to charge in the night
     * after the seventh day. From then on it charges 10 kWh every night, which without the congestion
     * factor takes the house to about 3.2 kW in the cheap night hours; with it the aggregator spreads
     * the charging so the house stays around the deadzone.
     * <p>
     * The only test that runs the model, since the others read the same loaded model.
     */
    @Test
    public void testCongestionKeepsTheHouseWithinTheDeadzone() {
        var deadzone_kW = findAggregator().getCongestionDeadzone_kW();
        luxEngine.f_initializeEngine();

        var peakLoad_kW = 0.0;
        var stepsInTenDays = (int) Math.round(10 * 24 / luxEngine.p_timeParameters.getTimeStep_h());
        for (int step = 0; step < stepsInTenDays; step++) {
            luxEngine.f_runTimestep();
            peakLoad_kW = Math.max(peakLoad_kW, house.fm_currentBalanceFlows_kW.get(OL_EnergyCarriers.ELECTRICITY));
        }

        assertThat(luxEngine.v_timeStepsElapsed).isEqualTo(stepsInTenDays);
        // The congestion factor is a price, not a cap: the house goes over the deadzone as far as the
        // cheap hours still pay for at 1000 EUR/MWh per kW. Their largest advantage, about 121 EUR/MWh
        // of day-ahead price and 145 of tariff with VAT, pays for some 0.27 kW.
        assertThat(peakLoad_kW).isLessThanOrEqualTo(deadzone_kW + 0.3);
        // Close to the deadzone, so it is the congestion that holds the house back.
        assertThat(peakLoad_kW).isGreaterThan(deadzone_kW - 0.5);
    }

    private J_ISIE_Aggregator_EMS findAggregator() {
        assertThat(luxEngine.pop_energyCoops).hasSize(1);
        return (J_ISIE_Aggregator_EMS) luxEngine.pop_energyCoops.get(0).f_getAggregatorEnergyManagement();
    }

    private J_ProfilePointer findProfile(String name) {
        return luxEngine.c_profiles.stream()
                .filter(profile -> profile.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No profile " + name + " was loaded"));
    }

    private J_EAEV findElectricVehicle() {
        return house.c_energyAssets.stream()
                .filter(asset -> asset instanceof J_EAEV)
                .map(asset -> (J_EAEV) asset)
                .findFirst()
                .orElseThrow();
    }
}
