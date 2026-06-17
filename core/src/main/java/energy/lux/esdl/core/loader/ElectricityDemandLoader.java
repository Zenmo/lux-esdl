package energy.lux.esdl.core.loader;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import com.zenmo.timeseries.untyped.TimeSeries;
import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.loader.profile.ProfilePointerFactory;
import energy.lux.esdl.core.loader.profile.bare.BareProfileChecker;
import energy.lux.esdl.core.loader.profile.bare.BareProfileReader;
import energy.lux.esdl.core.util.DateTimeUtil;
import energy.lux.esdl.core.util.Util;
import esdl.*;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

import java.time.Year;

public class ElectricityDemandLoader {

    private final Zero_Loader luxLoader;

    private final ProfilePointerFactory profilePointerFactory;

    private final BareProfileReader bareProfileReader;

    public ElectricityDemandLoader(
            Zero_Loader luxLoader
    ) {
        this.luxLoader = luxLoader;

        var energyModel = luxLoader.energyModel;
        var timeParameters = energyModel.p_timeParameters;

        this.profilePointerFactory = new ProfilePointerFactory(energyModel);
        this.bareProfileReader = new BareProfileReader(
                DateTimeUtil.hoursToDuration(timeParameters.getTimeStep_h()),
                new BareProfileChecker(Year.of(timeParameters.getStartYear()))
        );
    }

    public void loadElectricityDemand(
            ElectricityDemand demand,
            GridConnection luxGridConnection
    ) {
        var dateTimeProfile = findFirstProfile(demand);
        if (dateTimeProfile != null) {
            loadProfile(dateTimeProfile, demand, luxGridConnection);
            return;
        }

        double annualDemandKwh = demand.getFullLoadHours() * demand.getPower() * 0.001;
        if (annualDemandKwh != 0.0) {
            luxLoader.f_addElectricityDemandProfile(luxGridConnection, annualDemandKwh, 0.0, false, "default_house_electricity_demand_fr");
            return;
        }

        throw new NotImplemented("This type of ElectricityDemand is not implemented: " + Util.printItem(demand));
    }

    private J_EAProfile loadProfile(
            GenericProfile profile,
            ElectricityDemand demand,
            GridConnection luxGridConnection
    ) {
        var timeSeries = this.bareProfileReader.readProfile(profile);

        // Convert W to kW
        // TODO: read units from ESDL, warn if not present
        var values = timeSeries.copyValuesArray();
        for (int i = 0; i < values.length; i++) {
            values[i] *= 0.001;
        }

        var transformedTimeSeries = (ArrayTimeSeries) timeSeries.toBuilder()
                .values(values)
                .build();

        var luxProfile = this.profilePointerFactory.timeSeriesToProfilePointer(
                transformedTimeSeries,
                demand.getId() + "_demand",
                OL_ProfileUnits.KW
        );

        var luxEngine = luxLoader.energyModel;
        var demandAsset = new J_EAProfile(
                luxGridConnection,
                OL_EnergyCarriers.ELECTRICITY,
                luxProfile,
                OL_AssetFlowCategories.fixedConsumptionElectric_kW,
                luxEngine.p_timeParameters
        );
        demandAsset.setEnergyAssetName(demand.getName());
        return demandAsset;
    }

    private GenericProfile findFirstProfile(EnergyAsset asset) {
        for (Port port : asset.getPort()) {
            for (GenericProfile profile : port.getProfile()) {
                if (profile != null) {
                    return profile;
                }
            }
        }
        return null;
    }
}
