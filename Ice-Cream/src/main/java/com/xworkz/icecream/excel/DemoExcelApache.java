package com.xworkz.icecream.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class DemoExcelApache {

    public static void main(String[] args) throws IOException {

        String excel = "C:\\Users\\ninga\\IdeaProjects\\Ice-Cream\\src\\main\\resources\\ice-cream.xlsx";

        try {
            FileInputStream fileInputStream = new FileInputStream(excel);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.cloneSheet(0);
            // XSSFSheet sheet = workbook.getSheet("Sheet1");

            Iterator iterator = sheet.iterator();

            while (iterator.hasNext()) {

                XSSFRow row = (XSSFRow) iterator.next();
                Iterator celliterator = row.cellIterator();

                while (celliterator.hasNext()) {

                    XSSFCell cell = (XSSFCell) celliterator.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + " ");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + " ");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + " ");
                            break;
                    }
                    System.out.print("  |  ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");

        } catch (IOException e) {
            System.out.println("IOException"+e.getMessage());
        }


    }
}
