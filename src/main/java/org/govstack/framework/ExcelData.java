package org.govstack.framework;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.concurrent.ConcurrentHashMap;

public class ExcelData {
    private static final ConcurrentHashMap<Integer, String> keys = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, String> values = new ConcurrentHashMap<>();
    static ConcurrentHashMap<String, String> dataComb = new ConcurrentHashMap<>();


    public static ConcurrentHashMap<String, String> readExcelData(String testCaseNumber, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//TestData//TestData.xlsx");
            Workbook wb = WorkbookFactory.create(file);
            Sheet sheet;
            sheet = wb.getSheet(sheetName);
            for (Row row : sheet) {
                Cell cellNumber = row.getCell(row.getFirstCellNum());
                String cellValue = cellNumber.getStringCellValue();
                if (cellValue.equals("TestCaseNumber")) {
                    for (Cell cell : row) {
                        keys.put(cell.getColumnIndex(), cell.getStringCellValue());
                    }
                } else if (cellValue.equals(testCaseNumber)) {
                    for (Cell cell : row) {
                        values.put(cell.getColumnIndex(), cell.getStringCellValue());
                    }
                }
            }
            for (Integer index : values.keySet()) {
                if (!values.get(index).isEmpty()) {
                    dataComb.put(keys.get(index), values.get(index));
                }
            }
            ExtentReporter.log(LogStatus.INFO, "Test Data " + dataComb);
            return dataComb;
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to read test data "+e.getMessage());
            return null;
        }

    }

}
