package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseTest.BaseClass2;

public class ListImpClass implements ITestListener , ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suit results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add env enformation & create test

		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os", "Window-10");
		report.setSystemInfo("BROWSER", "chrome-100");

	
	}
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("=====>>"+result.getMethod().getMethodName()+"======START===>>");
		 test = report.createTest(result.getMethod().getMethodName());
		 test.log(Status.INFO, result.getMethod().getMethodName()+"=====STARTED==>>");
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("=====>>"+result.getMethod().getMethodName()+"======COMPLETED===>>");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"=====COMPLETED==>>");
	}
	@Override
	public void onTestFailure(ITestResult result) {
				String testName = result.getMethod().getMethodName();
				TakesScreenshot ts=(TakesScreenshot)BaseClass2.sdriver;
				 String srcFile = ts.getScreenshotAs(OutputType.BASE64);
				 String time = new Date().toString().replace(" ", "_").replace(":", "_");
				 test.addScreenCaptureFromBase64String(srcFile, testName+" "+time );
				 test.log(Status.FAIL, result.getMethod().getMethodName()+"=====FAILED==>>");

			
			
	}
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report BACKUP");
		
		report.flush();
		
	}
	
	

}
