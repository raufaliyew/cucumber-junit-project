package com.cydeo.tests;

import com.cydeo.pages.GasMilageCalculatePage;
import com.cydeo.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GasMilageTests {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    GasMilageCalculatePage gmc = new GasMilageCalculatePage();

    @Test
    public void gas_milage_calculation() throws IOException {

        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");
        String path = "src/test/resources/TestData/GasMilageTestData.xlsx";

        fileInputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("GMC");

        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {

            XSSFRow currentRow = sheet.getRow(rowNum);

            if(!currentRow.getCell(0).toString().equals("Y")){
                if (currentRow.getCell(6)==null){
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("Skip Requested!");
                continue;
            }


            //================================================================

            double current = currentRow.getCell(1).getNumericCellValue();
            gmc.inputCurrentOdo.clear();
            gmc.inputCurrentOdo.sendKeys(String.valueOf(current));

            double previous = currentRow.getCell(2).getNumericCellValue();
            gmc.inputPreviousOdo.clear();
            gmc.inputPreviousOdo.sendKeys(String.valueOf(previous));

            double gas = currentRow.getCell(3).getNumericCellValue();
            gmc.inputGas.clear();
            gmc.inputGas.sendKeys(String.valueOf(gas));

            gmc.calculateBtn.click();

            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            String formatted = decimalFormat.format((current - previous) / gas);

            String[] actualArr = gmc.resultInGas.getText().split(" ");

            String actualResult = actualArr[0];
            String expectedResult = String.valueOf(formatted);

            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);
            }
            currentRow.getCell(4).setCellValue(formatted);

            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);
            }
            currentRow.getCell(5).setCellValue(formatted);

            if (currentRow.getCell(6) == null) {
                currentRow.createCell(6);
            }

            if (actualResult.equals(expectedResult)) {
//System.out.println("PASS!");
                currentRow.getCell(6).setCellValue("PASS!");
            } else {
//System.out.println("FAIL!");
                currentRow.getCell(6).setCellValue("FAIL!");
            }


            if (currentRow.getCell(7) == null) {
                currentRow.createCell(7);
            }
            DateTimeFormatter DTF = DateTimeFormatter.ofPattern("hh:mm:ss a");
            currentRow.getCell(7).setCellValue(LocalTime.now().format(DTF));
        }
        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}




















