package com.eurotech.test.day20_DDF;

import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {
    @Test
    public void readExcelFile() {
        /*
         * Create an object from ExcelUtil
         * it accepts two arguments
         * argument 1: location of the file(path)
         * argument 2: sheet that we want to open (sheetName)
         */
        ExcelUtil testData = new ExcelUtil("src/test/resources/Batch7DevEx.xlsx", "Test Data");

        // How many rows in the sheet
        System.out.println("testDate.rowCount() = " + testData.rowCount());
        //How many columns in the sheet
        System.out.println("testDate.columnCount() = " + testData.columnCount());
        // Get all column names
        System.out.println("testDate.getColumnsNames() = " + testData.getColumnsNames());
        // Get all data  in list of string
        List<Map<String,String>> dataList = testData.getDataList();
        for (Map<String ,String> oneRow : dataList){
            System.out.println("oneRow = " + oneRow);
        }
        // How can I take 3rd row
        System.out.println("dataList.get(2) = " + dataList.get(2));

        // Get Alex's company
        System.out.println("dataList.get(2).get(3) = " + dataList.get(4).get("Company"));

        // Get Roma' s company
        System.out.println("dataList.get(3).get(\"Title\") = " + dataList.get(3).get("Title"));

        // get all data
        String[][] dataArray
= testData.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));

    }
}
