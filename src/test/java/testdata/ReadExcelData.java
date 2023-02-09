package testdata;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelData {
    public String[][] getData() throws IOException {
        File file = new File("src/test/java/testdata/TestData.xlsx");
        FileInputStream fin = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fin);
        XSSFSheet sheet = workbook.getSheet("AddNewPayee");

        String data[][] = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=1;i<=sheet.getLastRowNum();i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }
        return data;
    }
}
