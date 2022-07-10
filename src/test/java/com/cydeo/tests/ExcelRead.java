package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_excel_file() throws IOException {
        String path = "SampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Employees");

        System.out.println(sheet.getRow(1).getCell(0));

        System.out.println(sheet.getRow(2).getCell(2));

        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);

        for (int i = 0; i < usedRows; i++) {
            if(sheet.getRow(i).getCell(0).toString().equals("Rauf")){
                System.out.println(sheet.getRow(i).getCell(0));
            }
        }


        for (int i = 0; i < usedRows; i++) {
            if(sheet.getRow(i).getCell(0).toString().equals("Rauf")){
                System.out.println(sheet.getRow(i).getCell(0));
            }
        }

    }
}
