package com.vtiger.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonLib {
	
	public static void fn_Click(WebElement element,int timeout) {
		
		ElementUtils.waitForElementToBeDisplayed(element, timeout).click();
		System.out.println("click on element");
	}
	
	public static void fn_SendKeys(WebElement element,String value,int timeout) {
		
		WebElement ele = ElementUtils.waitForElementToBeDisplayed(element, timeout);
		ele.clear();
		ele.sendKeys(value);
		System.out.println("Entered the value on input :"+value);
		
	}
	
	public static void fn_MouseHoverUsingAction(WebElement element,int timeout) {
		Actions act = new Actions(DriverFactory.driver);
		act.moveToElement(ElementUtils.waitForElementToBeDisplayed(element, timeout)).perform();
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		
		return ElementUtils.waitForElementToBeDisplayed(element, 10).isDisplayed();
		
	}
	
	public static void fn_SelectDropDownValueUsingText(WebElement element,Object groupName) {
		
		WebElement element1 = ElementUtils.waitForElementToBeDisplayed(element, 10);
		Select sc = new Select(element1);
		sc.selectByVisibleText((String) groupName);
		
	}
	
	public static void fn_SelectDropDownValueUsingValue(WebElement element,String value) {
		
		WebElement element1 = ElementUtils.waitForElementToBeDisplayed(element, 10);
		Select sc = new Select(element1);
		sc.selectByValue(value);;
		
	}


	public static String TakeScreenshot() {
		String path=System.getProperty("user.dir")+"/Reports/SS/Screenshot"+new Random().nextInt(10)+".png";
		File dest =new File(path);
		File src=((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}
	
	
	public static String readPropertyData(String keyName) {
		FileInputStream fis;
		Properties prop=	new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\credentials.properties");
			
			prop.load(fis);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(keyName);
		
	}
	
	public static List<Object> readDataFromExcelFile(String filePath,String sheetName,String value)
	{
		int cellNo=0;
		File file=new File(filePath);
		 int rowNo=0;
		 List<Object> data=new ArrayList<>();

		try {
			FileInputStream fis=new FileInputStream(file);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			int cellSize = sheet.getRow(0).getLastCellNum();
			
			for(int i=0;i<=cellSize;i++) {
				if(sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(value)) {
					
					cellNo=i;
					break;
				}
			}
			int rowSize = sheet.getLastRowNum();
			
			
			
			for(int j=1;j<rowSize;j++) {
				if(sheet.getRow(j).getCell(cellNo).getCellType().name().equalsIgnoreCase("String")){
					data.add(sheet.getRow(j).getCell(cellNo).getStringCellValue());
				}
				else {
					data.add(sheet.getRow(j).getCell(cellNo).getNumericCellValue());
				}
			}
		
			
		
			
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}
	
	public static Object readDataFromExcelFile1(String filePath,String sheetName,int rowNo,int cellNo)
	{
		
		File file=new File(filePath);
		
		 List<Object> data=new ArrayList<>();

		try {
			FileInputStream fis=new FileInputStream(file);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			int cellSize = sheet.getRow(0).getLastCellNum();
			
			
			
			
			
				if(sheet.getRow(rowNo).getCell(cellNo).getCellType().name().equalsIgnoreCase("String")){
				return	sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
				}
				else {
					return sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue();
				}
			
		
			
		
			
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	
	

	
}
