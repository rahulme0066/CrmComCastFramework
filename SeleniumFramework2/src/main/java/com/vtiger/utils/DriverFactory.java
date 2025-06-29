package com.vtiger.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DriverFactory extends Listeners {
	
	public static  WebDriver driver;
	
	
	
	
	
	@BeforeSuite
	public void reportConfig() {
		ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir")+"/report.html");
		 reports= new ExtentReports();
		reports.attachReporter(html);
		
		

	}
	
	@BeforeClass
	public  WebDriver initDriver() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(CommonLib.readPropertyData("Url"));
		return driver;
		
	}
	
	
	
	@AfterSuite
	public  void closeDriver() {
		reports.flush();
		driver.quit();
	}

}
