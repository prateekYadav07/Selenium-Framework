package com.framework.datadriver;

/*
* This class consists of all the dataProviders required in testCases.
* It uses ApachePOI open source library to read data from different file formats like xlx, xlsx, csv, json.
* currently only xlx and xlsx are implemented, other formats will be added soon.
* */

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.framework.base.BaseClass;

public class DataProviders extends BaseClass{
	
	/*
	* This is a dataProvider method which returns a 2D array of Object class (this instance returns String array)
	* user has to provide its name and class in DataProvider in @test annotation of test case.
	* */
	
	@DataProvider(name = "titleVerification")
	public static String[][] getUrlsAndTitles(){
		String[][] data = null;
		try {
			
			FileInputStream finStream = new FileInputStream(new File(getProperty("url")));
			XSSFWorkbook workbook = new XSSFWorkbook(finStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
			Row temp_var = sheet.getRow(0);
			int columnCount = temp_var.getLastCellNum();
			data = new String[rowCount][columnCount];
			
			for(int i=0; i<rowCount + 1; i++) {
				Row row = sheet.getRow(i);
				for(int j=0;j<row.getLastCellNum(); j++) {
					data[i][j] = row.getCell(j).getStringCellValue();
				}
			}
			workbook.close();
		}
		catch(Exception e) {
			e.getMessage();
		}
		return data;
	}

}
