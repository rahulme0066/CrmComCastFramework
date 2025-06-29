package com.vtiger.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listeners implements ITestListener,ITestNGListener{

	
	public static ExtentReports  reports;
	public static ExtentTest  logger;
	
	public void test() {
		
	}
	
	
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		logger.log(Status.PASS, "Pass Testcase:"+result.getMethod().getMethodName());
}
	
	 @Override
	public void onFinish(ITestContext context) {
		 
		 

	}
	 
	 @Override
	public void onTestSkipped(ITestResult result) {
		
		 logger.log(Status.SKIP, "Test skipped:"+result.getMethod().getMethodName());
	}
	 
	 @Override
	public void onTestStart(ITestResult result) {
		   logger = reports.createTest(result.getMethod().getMethodName());
			logger.log(Status.INFO, "********Test Started: "+result.getMethod().getMethodName()+"*********");
		 
	}
	 
	 @Override
	public void onTestFailure(ITestResult result) {
		
		String path= CommonLib.TakeScreenshot();

		 logger.log(Status.FAIL, "Failed Testcase:"+result.getMethod().getMethodName());
		 try {
			logger.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	 
}
