package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    static Workbook workbook;
    static Sheet sheet;

    public static void openExcel(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method opens excel worksheet
    public static void getSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
    }

    // method returns count of rows
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // method returns count of columns
    public static int getColumnsCount(int rowIndex) {
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    // method will give the cell data in string format
    public static String getCellData(int rowIndex, int columnIndex) {
        return sheet.getRow(rowIndex).getCell(columnIndex).toString();
    }

    // method will return list of maps having all the data from excel file
    public static List<Map<String, String>> excelListIntoMap(String filePath, String sheetName) {
        openExcel(filePath);
        getSheet(sheetName);
        // creating a list of maps for all rows
        List<Map<String, String>> listData = new ArrayList<>();
        // loops - outer loop is always takes care of rows
        for (int row = 1; row < getRowCount(); row++) {
            // map for every row
            Map<String, String> map = new LinkedHashMap<>();
            for (int col = 0; col < getColumnsCount(row); col++) {
                map.put(getCellData(0, col), getCellData(row, col));
            }
            listData.add(map);
        }
        return listData;
    }
}
