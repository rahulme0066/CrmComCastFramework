package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
  author Rahul
 **/ 

public class ExcelUtility {
	FileInputStream fis;
	public String getDataFromExcel(String sheetName,int rowNo,int cellNo) throws Throwable {
		 fis=new FileInputStream("./src/test/resources/Organisation.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String data=sh.getRow(rowNo).getCell(cellNo).toString();
		return data;
		
	}
	
	public int getRowCount(String sheetName) throws Throwable {
		fis=new FileInputStream("./src/test/resources/Organisation.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		 return rowCount;
	}
	
	public void setDataInToExcel(String sheetName,int rowNo,int cellNo,String data) throws Throwable {
	 fis=new FileInputStream("./src/test/resources/Organisation.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.getRow(rowNo).createCell(cellNo).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Organisation.xlsx");
		wb.close();
		
	}
	
	

}
