package energy.lux.esdl.core.loader;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import energy.lux.esdl.core.loader.profile.bare.BareProfileChecker;
import energy.lux.esdl.core.loader.profile.bare.BareProfileReader;
import energy.lux.esdl.core.util.DateTimeUtil;
import energy.lux.esdl.core.util.Util;
import esdl.*;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

import java.time.Year;
import java.util.regex.Pattern;

public class ElectricityDemandLoader {

    /**
     * The decorated congestion files put the yearly total in the name of the demand asset,
     * for example {@code name="Total: 3958.0000000349996 kwh"}, and normalize the profile
     * itself. It is the only place the yearly total is stated.
     */
    private static final Pattern annualDemandInName = Pattern.compile(
            "^\\s*Total:\\s*([0-9.eE+-]+)\\s*kwh\\s*$",
            Pattern.CASE_INSENSITIVE
    );

    /**
     * A normalized profile integrates to exactly 1 over the year. Allow a little slack for
     * the rounding in the file, but not enough to let a profile in a different unit through.
     */
    private static final double normalizedProfileTolerance = 0.01;

    private final Zero_Loader luxLoader;

    private final ProfilePointerRegistry profilePointerRegistry;

    private final BareProfileReader bareProfileReader;

    public ElectricityDemandLoader(
            Zero_Loader luxLoader,
            ProfilePointerRegistry profilePointerRegistry
    ) {
        this.luxLoader = luxLoader;
        this.profilePointerRegistry = profilePointerRegistry;

        var energyModel = luxLoader.energyModel;
        var timeParameters = energyModel.p_timeParameters;

        this.bareProfileReader = new BareProfileReader(
                DateTimeUtil.hoursToDuration(timeParameters.getTimeStep_h()),
                new BareProfileChecker(Year.of(timeParameters.getStartYear()))
        );
    }

    public void loadElectricityDemand(
            ElectricityDemand demand,
            GridConnection luxGridConnection
    ) {
        var profile = Util.findFirstProfile(demand);
        if (profile != null) {
            loadProfile(profile, demand, luxGridConnection);
            return;
        }

        double annualDemandKwh = demand.getFullLoadHours() * demand.getPower() * 0.001;
        if (annualDemandKwh != 0.0) {
            luxLoader.f_addElectricityDemandProfile(luxGridConnection, annualDemandKwh, 0.0, false, "default_house_electricity_demand_fr");
            return;
        }

        throw new NotImplemented("This type of ElectricityDemand is not implemented: " + Util.printItem(demand));
    }

    /**
     * The ESDL files state no units, so the shape of the asset decides how to read the profile:
     * a yearly total in the name means the profile is normalized, anything else is read as power.
     */
    private void loadProfile(
            GenericProfile profile,
            ElectricityDemand demand,
            GridConnection luxGridConnection
    ) {
        var annualDemandKwh = parseAnnualDemandKwh(demand.getName());
        if (annualDemandKwh != null) {
            loadNormalizedProfile(profile, demand, luxGridConnection, annualDemandKwh);
        } else {
            loadPowerProfile(profile, demand, luxGridConnection);
        }
    }

    /**
     * A normalized profile is registered as a {@link OL_ProfileUnits#YEARLYTOTALFRACTION} and
     * scaled back up by the yearly total, which is what J_EAConsumption does with that unit.
     * <p>
     * The same profile serves three or four grid connections, so the pointer is shared while
     * every grid connection still gets its own demand asset.
     */
    private void loadNormalizedProfile(
            GenericProfile profile,
            ElectricityDemand demand,
            GridConnection luxGridConnection,
            double annualDemandKwh
    ) {
        var profilePointer = this.profilePointerRegistry.getOrCreateProfilePointer(
                profile,
                profilePointerName(demand),
                OL_ProfileUnits.YEARLYTOTALFRACTION,
                esdlProfile -> readNormalizedProfile(esdlProfile, demand)
        );

        luxLoader.f_addElectricityDemandProfile(
                luxGridConnection,
                annualDemandKwh,
                null,
                false,
                profilePointer.name
        );
    }

    private ArrayTimeSeries readNormalizedProfile(GenericProfile profile, ElectricityDemand demand) {
        var timeSeries = this.bareProfileReader.readProfile(profile);
        assertProfileIsNormalized(timeSeries, demand);
        return timeSeries;
    }

    private static void assertProfileIsNormalized(ArrayTimeSeries timeSeries, ElectricityDemand demand) {
        var stepHours = DateTimeUtil.durationToHours(timeSeries.getStep());

        var yearlyTotal = 0.0;
        for (double value : timeSeries.copyValuesArray()) {
            yearlyTotal += value * stepHours;
        }

        if (Math.abs(yearlyTotal - 1.0) > normalizedProfileTolerance) {
            throw new EsdlException(String.format(
                    "ElectricityDemand %s states a yearly total in its name, so its profile is expected"
                            + " to be normalized, but the profile integrates to %s instead of 1",
                    demand.getName(),
                    yearlyTotal
            ));
        }
    }

    /**
     * The older ESDL files hold the demand itself rather than a shape, in watts.
     */
    private J_EAProfile loadPowerProfile(
            GenericProfile profile,
            ElectricityDemand demand,
            GridConnection luxGridConnection
    ) {
        var luxProfile = this.profilePointerRegistry.getOrCreateProfilePointer(
                profile,
                profilePointerName(demand),
                OL_ProfileUnits.KW,
                this::readProfileAsKilowatt
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

    private ArrayTimeSeries readProfileAsKilowatt(GenericProfile profile) {
        var timeSeries = this.bareProfileReader.readProfile(profile);

        // Convert W to kW
        // TODO: read units from ESDL, warn if not present
        var values = timeSeries.copyValuesArray();
        for (int i = 0; i < values.length; i++) {
            values[i] *= 0.001;
        }

        return (ArrayTimeSeries) timeSeries.toBuilder()
                .values(values)
                .build();
    }

    private static Double parseAnnualDemandKwh(String demandName) {
        if (demandName == null) {
            return null;
        }

        var matcher = annualDemandInName.matcher(demandName);
        if (!matcher.matches()) {
            return null;
        }

        return Double.parseDouble(matcher.group(1));
    }

    /**
     * LUX resolves a profile by name, so the name has to identify the demand it belongs to.
     * <p>
     * The demand assets of the congestion scenarios carry no id, only a description such as
     * "base_load_Klant 1", while the older files have an id and a name but no description.
     * The registry appends a counter if two demands still end up with the same name.
     */
    private static String profilePointerName(ElectricityDemand demand) {
        return Util.firstNonBlank(demand.getId(), demand.getDescription(), demand.getName(), "electricity") + "_demand";
    }

}
