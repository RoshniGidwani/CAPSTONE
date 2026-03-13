package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getExcelData() throws IOException
    {
        String path = "src/test/resources/flightData.xlsx";

        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++)
        {
            Row row = sheet.getRow(i);

            for (int j = 0; j < colCount; j++)
            {
                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.toString();
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}