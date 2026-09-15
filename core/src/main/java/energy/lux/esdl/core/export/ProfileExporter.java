package energy.lux.esdl.core.export;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.EnergyModel;
import zero_engine.I_EnergyData;
import zero_engine.OL_AssetFlowCategories;
import zero_engine.OL_EnergyCarriers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
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
 * {@link zero_engine.GridConnection} is one house.
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
        var columns = new LinkedHashMap<String, double[]>();
        var rapidRunData = scope.getRapidRunData();
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
