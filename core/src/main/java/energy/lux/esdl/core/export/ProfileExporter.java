package energy.lux.esdl.core.export;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import energy.lux.engine.EnergyModel;
import energy.lux.engine.I_EnergyData;
import energy.lux.engine.dataclasses.J_RapidRunData;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.optionlists.OL_AssetFlowCategories;
import energy.lux.engine.optionlists.OL_EnergyCarriers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static energy.lux.esdl.core.util.DateTimeUtil.luxTimeZone;

/**
 * Write the electricity profiles of one result scope to an Excel file,
 * the way the export menu of ChartProfielen does.
 * <p>
 * The results UI cannot do this in a headless run, because the interface it lives in is part of
 * the AnyLogic project rather than of the engine. This reads the same accumulators that the UI
 * reads, straight off {@link I_EnergyData#getRapidRunData}, so a scope here means the same thing
 * it means in the UI: an {@link EnergyModel} is the whole region, a
 * {@link energy.lux.engine.gridconnections.GridConnection} is one house.
 */
public class ProfileExporter {
    private static final Logger logger = LoggerFactory.getLogger(ProfileExporter.class);

    /**
     * The unit the UI offers besides kWh. Values are accumulated in kW, so kW needs no scaling.
     */
    private static final String unit = "kW";

    private static final DateTimeFormatter timeStepDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mmXXX");

    private final EnergyModel energyModel;

    private final ZonedDateTime simulationStart;

    public ProfileExporter(EnergyModel energyModel) {
        this.energyModel = energyModel;
        this.simulationStart = ZonedDateTime.of(
                energyModel.p_timeParameters.getStartYear(), 1, 1, 0, 0, 0, 0, luxTimeZone);
    }

    /**
     * @param sheetName the name the UI would give the sheet, such as "Totaal van gebied".
     */
    public void writeElectricityProfiles(I_EnergyData scope, String sheetName, Path destination) {
        var columns = collectElectricityColumns(scope);
        if (columns.isEmpty()) {
            throw new IllegalStateException(
                    "No electricity profiles found for " + sheetName
                            + ". Was the rapid simulation run before exporting?"
            );
        }

        writeWorkbook(columns, sheetName, destination);
        logger.info("Wrote {} columns of {} to {}", columns.size(), sheetName, destination);
    }

    /**
     * Mirrors the electricity half of {@code ChartProfielen.f_getEnergyDataObjectExportMap}:
     * every asset flow the UI counts as electric and that this scope actually has, followed by
     * the total electricity balance.
     */
    private Map<String, double[]> collectElectricityColumns(I_EnergyData scope) {
        var rapidRunData = scope.getRapidRunData();
        var columns = new LinkedHashMap<String, double[]>();
        if (rapidRunData == null || !rapidRunData.activeEnergyCarriers.contains(OL_EnergyCarriers.ELECTRICITY)) {
            return columns;
        }

        var timeStep_h = energyModel.p_timeParameters.getTimeStep_h();

        for (OL_AssetFlowCategories assetFlow : ResultLabels.electricAssetFlows) {
            if (!rapidRunData.assetsMetaData.activeAssetFlows.contains(assetFlow)) {
                continue;
            }
            var accumulator = rapidRunData.am_assetFlowsAccumulators_kW.get(assetFlow);
            var name = ResultLabels.profileTypeName(accumulator.getSignalResolution_h(), timeStep_h)
                    + ResultLabels.assetFlowLabel(assetFlow)
                    + " profiel [" + unit + "]";
            columns.put(name, accumulator.getTimeSeries_kW().clone());
        }

        var totalBalance = rapidRunData.am_totalBalanceAccumulators_kW.get(OL_EnergyCarriers.ELECTRICITY);
        var totalName = ResultLabels.profileTypeName(totalBalance.getSignalResolution_h(), timeStep_h)
                + ResultLabels.energyCarrierName(OL_EnergyCarriers.ELECTRICITY)
                + " profiel [" + unit + "]";
        columns.put(totalName, totalBalance.getTimeSeries_kW().clone());

        return columns;
    }

    /**
     * The heat side of a scope, which the UI export does not offer: the two heat demands, the
     * electricity of the heat pumps, the gas the hybrids burn and the heat balance, which stays at
     * 0 while every heat flow finds an asset that takes it.
     */
    public void writeHeatProfiles(I_EnergyData scope, String sheetName, Path destination) {
        var rapidRunData = scope.getRapidRunData();
        if (rapidRunData == null) {
            throw new IllegalStateException(
                    "No results for " + sheetName + ". Was the rapid simulation run before exporting?"
            );
        }

        var columns = new LinkedHashMap<String, double[]>();
        for (OL_AssetFlowCategories assetFlow : ResultLabels.heatAssetFlows) {
            addAssetFlowColumn(columns, rapidRunData, assetFlow);
        }
        addHeatPumpElectricityByHeatingTypeColumns(columns, scope, rapidRunData);
        addTotalBalanceColumn(columns, rapidRunData, OL_EnergyCarriers.METHANE);
        addTotalBalanceColumn(columns, rapidRunData, OL_EnergyCarriers.HEAT);
        if (columns.isEmpty()) {
            logger.warn("{} has no heat flows, so no heat profiles are written", sheetName);
            return;
        }

        writeWorkbook(columns, sheetName, destination);
        logger.info("Wrote {} heat columns of {} to {}", columns.size(), sheetName, destination);
    }

    private void addAssetFlowColumn(
            Map<String, double[]> columns,
            J_RapidRunData rapidRunData,
            OL_AssetFlowCategories assetFlow
    ) {
        if (!rapidRunData.assetsMetaData.activeAssetFlows.contains(assetFlow)) {
            return;
        }
        var accumulator = rapidRunData.am_assetFlowsAccumulators_kW.get(assetFlow);
        var name = ResultLabels.profileTypeName(accumulator.getSignalResolution_h(), timeStep_h())
                + ResultLabels.assetFlowLabel(assetFlow)
                + " profiel [" + unit + "]";
        columns.put(name, accumulator.getTimeSeries_kW().clone());
    }

    /**
     * The heat pump electricity of the scope, split into houses with an all-electric heat pump and
     * houses with a hybrid one.
     * <p>
     * The engine models a hybrid heat pump as the same heat pump asset as an all-electric one, next
     * to a gas burner, so the asset flow totals of a scope cannot tell them apart. Other models
     * report the two separately, and the ISIE model comparison compares them with and without
     * the hybrids. Every grid connection keeps its own asset flows over the rapid run, and its
     * heating type says which kind of heat pump it has, so the split is a sum over the grid
     * connections of the scope. The two columns add up to the heat pump electricity column.
     */
    private void addHeatPumpElectricityByHeatingTypeColumns(
            Map<String, double[]> columns,
            I_EnergyData scope,
            J_RapidRunData scopeRapidRunData
    ) {
        var heatPumpFlow = OL_AssetFlowCategories.heatPumpElectricityConsumption_kW;
        if (!scopeRapidRunData.assetsMetaData.activeAssetFlows.contains(heatPumpFlow)) {
            return;
        }
        var scopeAccumulator = scopeRapidRunData.am_assetFlowsAccumulators_kW.get(heatPumpFlow);
        var numberOfTimeSteps = scopeAccumulator.getTimeSeries_kW().length;
        var allElectric_kW = new double[numberOfTimeSteps];
        var hybrid_kW = new double[numberOfTimeSteps];

        for (GridConnection gridConnection : gridConnectionsOf(scope)) {
            var heatPumpElectricity_kW = heatPumpElectricityOf(gridConnection, numberOfTimeSteps);
            if (heatPumpElectricity_kW == null) {
                continue;
            }
            switch (gridConnection.f_getCurrentHeatingType()) {
                case ELECTRIC_HEATPUMP -> addTo(allElectric_kW, heatPumpElectricity_kW);
                case HYBRID_HEATPUMP -> addTo(hybrid_kW, heatPumpElectricity_kW);
                default -> throw new IllegalStateException(
                        "Grid connection " + gridConnection.p_gridConnectionID + " has heat pump electricity, but"
                                + " heating type " + gridConnection.f_getCurrentHeatingType()
                                + ", which is neither an all-electric nor a hybrid heat pump"
                );
            }
        }

        var profileTypeName = ResultLabels.profileTypeName(scopeAccumulator.getSignalResolution_h(), timeStep_h());
        var label = ResultLabels.assetFlowLabel(heatPumpFlow);
        columns.put(profileTypeName + label + " all-electric warmtepompen profiel [" + unit + "]", allElectric_kW);
        columns.put(profileTypeName + label + " hybride warmtepompen profiel [" + unit + "]", hybrid_kW);
        logSplitMismatch(scopeAccumulator.getTimeSeries_kW(), allElectric_kW, hybrid_kW);
    }

    private static List<GridConnection> gridConnectionsOf(I_EnergyData scope) {
        if (scope instanceof EnergyModel energyModel) {
            return energyModel.c_gridConnections;
        }
        if (scope instanceof GridConnection gridConnection) {
            return List.of(gridConnection);
        }
        throw new IllegalArgumentException(
                "Cannot split the heat pump electricity of a " + scope.getClass().getSimpleName()
        );
    }

    /**
     * @return null when the grid connection has no heat pump.
     */
    private static double[] heatPumpElectricityOf(GridConnection gridConnection, int numberOfTimeSteps) {
        var rapidRunData = gridConnection.getRapidRunData();
        var heatPumpFlow = OL_AssetFlowCategories.heatPumpElectricityConsumption_kW;
        if (rapidRunData == null || !rapidRunData.assetsMetaData.activeAssetFlows.contains(heatPumpFlow)) {
            return null;
        }
        var heatPumpElectricity_kW = rapidRunData.am_assetFlowsAccumulators_kW.get(heatPumpFlow).getTimeSeries_kW();
        if (heatPumpElectricity_kW.length != numberOfTimeSteps) {
            throw new IllegalStateException(
                    "Grid connection " + gridConnection.p_gridConnectionID + " has " + heatPumpElectricity_kW.length
                            + " heat pump time steps, its scope has " + numberOfTimeSteps
            );
        }
        return heatPumpElectricity_kW;
    }

    private static void addTo(double[] sum, double[] values) {
        for (int i = 0; i < sum.length; i++) {
            sum[i] += values[i];
        }
    }

    /**
     * A mismatch means the scope holds heat pumps outside its grid connections, such as those of
     * sub grid connections, which the split does not reach.
     */
    private static void logSplitMismatch(double[] total_kW, double[] allElectric_kW, double[] hybrid_kW) {
        var largestDifference_kW = 0.0;
        for (int i = 0; i < total_kW.length; i++) {
            var difference_kW = Math.abs(total_kW[i] - allElectric_kW[i] - hybrid_kW[i]);
            largestDifference_kW = Math.max(largestDifference_kW, difference_kW);
        }
        if (largestDifference_kW > 1e-6) {
            logger.warn(
                    "The heat pump electricity split misses up to {} kW of the heat pump electricity total",
                    largestDifference_kW
            );
        }
    }

    private void addTotalBalanceColumn(
            Map<String, double[]> columns,
            J_RapidRunData rapidRunData,
            OL_EnergyCarriers energyCarrier
    ) {
        if (!rapidRunData.activeEnergyCarriers.contains(energyCarrier)) {
            return;
        }
        var totalBalance = rapidRunData.am_totalBalanceAccumulators_kW.get(energyCarrier);
        var name = ResultLabels.profileTypeName(totalBalance.getSignalResolution_h(), timeStep_h())
                + ResultLabels.energyCarrierName(energyCarrier)
                + " profiel [" + unit + "]";
        columns.put(name, totalBalance.getTimeSeries_kW().clone());
    }

    private double timeStep_h() {
        return energyModel.p_timeParameters.getTimeStep_h();
    }

    private void writeWorkbook(Map<String, double[]> columns, String sheetName, Path destination) {
        try (var workbook = new XSSFWorkbook()) {
            var sheet = workbook.createSheet(sheetName);
            var header = sheet.createRow(0);

            var numberOfRows = columns.values().stream().mapToInt(values -> values.length).max().orElse(0);

            header.createCell(0).setCellValue("Datum");
            for (int row = 0; row < numberOfRows; row++) {
                sheet.createRow(row + 1).createCell(0).setCellValue(timeStepDate(row));
            }

            var columnNumber = 1;
            for (var column : columns.entrySet()) {
                header.createCell(columnNumber).setCellValue(column.getKey());
                var values = column.getValue();
                for (int row = 0; row < values.length; row++) {
                    sheet.getRow(row + 1).createCell(columnNumber).setCellValue(values[row]);
                }
                columnNumber++;
            }

            try (var output = new FileOutputStream(destination.toFile())) {
                workbook.write(output);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write " + destination + ": " + e.getMessage(), e);
        }
    }

    /**
     * Mirrors {@code ChartProfielen.f_getDate_ISO8601}, seconds left off as it does.
     */
    private String timeStepDate(int timeStepsElapsed) {
        var timeStep_h = energyModel.p_timeParameters.getTimeStep_h();
        var elapsed = Duration.ofSeconds(Math.round(timeStepsElapsed * timeStep_h * 3600));
        return simulationStart.plus(elapsed).format(timeStepDateFormat);
    }
}
