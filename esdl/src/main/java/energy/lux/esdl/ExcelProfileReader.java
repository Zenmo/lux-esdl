package energy.lux.esdl;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import zerointerfaceloader.DefaultProfiles_data;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read columns of numbers from an Excel sheet to a list.
 * Replaces the AnyLogic logic which first loads an Excel file to a Database.
 * Uses the Apache POI library which is included with AnyLogic.
 */
public class ExcelProfileReader {
    @Nonnull
    private final XSSFSheet sheet;

    public ExcelProfileReader(File file, String sheetName) throws IOException, InvalidFormatException {
        var workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
    }

    public List<Double> readColumn(String columnHeader) {
        // Get the header row (assumed to be the first row)
        var columnIndex = findColumnIndex(columnHeader);

        return readColumn(columnIndex);
    }

    public List<Double> readHourlyYearColumn(String columnHeader) {
        var values = readColumn(columnHeader);
        if (values.size() != 8760) {
            throw new RuntimeException("Expected 8760 values for column " + columnHeader + ", but got " + values.size());

        }
        return values;
    }

    int findColumnIndex(String columnHeader) {
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            throw new RuntimeException("No header row found in the sheet.");
        }

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell cell = headerRow.getCell(i);
            if (cell != null && columnHeader.equals(cell.getStringCellValue())) {
                return i;
            }
        }

        throw new RuntimeException("Column '" + columnHeader + "' not found in the sheet.");
    }

    /**
     * Read all values from the column
     */
    List<Double> readColumn(int columnIndex) {
        List<Double> result = new ArrayList<>();

        // Starting from row 1, skipping header
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                return result;
            }
            Cell cell = row.getCell(columnIndex);
            if (cell == null) {
                return result;
            }

            if (cell.getCellType() == CellType.BLANK) {
                return result;
            }

            if (cell.getCellType() != CellType.NUMERIC) {
                throw new RuntimeException(
                        "Cell is not numeric: "
                                + cell.getAddress().formatAsString()
                                + " sheet " + sheet.getSheetName()
                );
            }

            result.add(cell.getNumericCellValue());
        }

        return result;
    }

    public static DefaultProfiles_data loadDefaultProfiles2025() throws IOException, InvalidFormatException {
        var reader = new ExcelProfileReader(
                new File("data_Generic/db_profiles.xlsx"),
                "profiles_2025"
        );

        return DefaultProfiles_data.builder()
                .arguments_hr(reader.readHourlyYearColumn("t_h"))
                .ambientTemperatureProfile_degC(reader.readHourlyYearColumn("ambientTemperature_degC"))
                .PVProductionProfile35DegSouth_fr(reader.readHourlyYearColumn("solar_e_prod_south35deg_normalized"))
                .PVProductionProfile15DegEastWest_fr(reader.readHourlyYearColumn("solar_e_prod_eastwest15deg_normalized"))
                .windProductionProfile_fr(reader.readHourlyYearColumn("wind_e_prod_normalized"))
                .epexProfile_eurpMWh(reader.readHourlyYearColumn("day_ahead_price_eur_p_mwh"))
                .CO2EmissionFactorElectricityImport_kgpkWh(reader.readHourlyYearColumn("co2_factor_kg_per_kwh"))
                .defaultHouseElectricityDemandProfile_fr(reader.readHourlyYearColumn("house_e_demand_other"))
                .defaultHouseHotWaterDemandProfile_fr(reader.readHourlyYearColumn("house_h_demand_hot_water"))
                .defaultHouseCookingDemandProfile_fr(reader.readHourlyYearColumn("house_cooking_demand"))
                .defaultOfficeElectricityDemandProfile_fr(reader.readHourlyYearColumn("building_e_demand_other"))
                .defaultBuildingHeatDemandProfile_fr(reader.readHourlyYearColumn("building_h_demand"))
                .build();
    }
}
