package utilites;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class Helper {
    //A method that takes a screenshot if the TestCase is failed

    public static void captureScreenShot(WebDriver driver, String screenshotName) {
        Path dest = Paths.get("./Screenshots", screenshotName + ".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Error while taking a screenshot" + e.getMessage());
        }
    }

    int rowNumber = 0;

    public String readDataFromExcel(String filePath) throws IOException {

        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row;
        Cell cell;
        String cellValue = "";
//        row = sheet.getRow(0);


        int rowsCount = sheet.getPhysicalNumberOfRows();
        for (int r = 1; r < rowsCount; r++) {
//        while (rowNumber == 1){
            row = sheet.getRow(r);
            rowNumber = row.getRowNum();
            int cellCount = row.getPhysicalNumberOfCells();
            if (row != null) {
                for (int c = 0; c < cellCount; c++) {
                    cell = row.getCell(c);
                    if (cell.getCellType() == CellType.STRING)
                        cellValue = cell.getStringCellValue();
                    else if (cell.getCellType() == CellType.NUMERIC)
                        cellValue = String.valueOf(cell.getNumericCellValue());
                }
            }
        }

//        Iterator<Row> rowIterator = sheet.iterator();
//        Row headerRow = rowIterator.next();
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//            Iterator<Cell> cellIterator = row.cellIterator();
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                //Check the cell type and format accordingly
//                switch (cell.getCellType()) {
//                    case NUMERIC:
//                        cellValue = String.valueOf(cell.getNumericCellValue());
//                        break;
//                    case STRING:
//                        cellValue = cell.getStringCellValue();
//                        break;
//                }
//            }
//        }
        return cellValue;
    }
}
