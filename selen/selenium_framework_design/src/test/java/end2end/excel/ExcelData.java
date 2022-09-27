package end2end.excel;

import com.google.common.collect.Table.Cell;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

  public static void main(String[] args) throws IOException {
    FileInputStream fis = new FileInputStream(
      "C:/Users/dexte/Documents/testCase.xlsx"
    );

    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    int sheets = workbook.getNumberOfSheets();

    for (int i = 0; i < sheets; i++) {
      if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
        // ovako smo dosli do zeljenog sheeta
        XSSFSheet sheet = workbook.getSheetAt(i);

        //Sada hocemo da identifikujemo odredjenu kolonu
        //Skeniranjem celog prvog reda

        Iterator<Row> rows = sheet.iterator(); // SHEET je kolektcija ROWS

        Row firstRow = rows.next();

        Iterator<org.apache.poi.ss.usermodel.Cell> ce = firstRow.cellIterator(); // ROWS je kolekcija CELSS
        int k = 0;
        int column = 0;

        while (ce.hasNext()) {
          org.apache.poi.ss.usermodel.Cell value = ce.next();

          if (value.getStringCellValue().equalsIgnoreCase("TestCase")) {
            // zeljena kolona
            column = k;
          }
          k++;
        }
        System.out.println(column);
        //Sada kada smo identifikovali kolonu , sada cemo je skenirati da bi nasli row od reci "Purchase"

        while (rows.hasNext()) {
          Row r = rows.next();

          if (
            r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")
          ) {
            // sada kada smo nasli zeljeni red hvatamo sve podatke iz tog reda

            Iterator<org.apache.poi.ss.usermodel.Cell> cv = r.cellIterator();

            while (cv.hasNext()) {
              System.out.println(cv.next().getStringCellValue());
            }
          }
        }
      }
    }
  }
}
