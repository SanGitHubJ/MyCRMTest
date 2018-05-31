package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataProviderExcel extends TestBase {

    public final static int RESPONCE_CODE_200 = 200;
    public final static int RESPONCE_CODE_201 = 201;
    public final static int RESPONCE_CODE_400 = 400;
    public final static int RESPONCE_CODE_401 = 401;


    static Workbook book;
    static Sheet sheet;

    public static String TESTDATA_SHEET_PATH = "/home/sanath/Workplace/Selenium/Intellij/"
    +"MyCRMTest/src/main/java/com/crm/qa/testdata/TestData.xlsx";

public static Object[][] getExcelTestData(String sheetName) throws IOException {

    FileInputStream file = null;
    try{
        file = new FileInputStream(TESTDATA_SHEET_PATH);
    }catch (FileNotFoundException e){
        e.printStackTrace();
    }
    try{
        book = WorkbookFactory.create(file);
    }catch (InvalidFormatException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();
    }

    sheet = book.getSheet(sheetName);
    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    for(int i= 0;i<sheet.getLastRowNum();i++){
        for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
            data[i][k] = sheet.getRow(i+1).getCell(k).toString();
        }
    }
    return data;


    }


}