package com.comcast.crm.baseTest;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public WebDriver driver=null;

	
	DataBaseUtility dlib=new DataBaseUtility();
	FileUtility flib=new FileUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	@BeforeSuite(groups= {"smoke" ,"regression"})
	public void configBs() {
		System.out.println("==connect to DB , report Config==");
	//	dlib.getDBConnection("", "", "");
	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke" ,"regression"})
	public void configBc(String browser) throws IOException {
		System.out.println("==Launch the Browser==");
		String BROWSER=browser;
//		String BROWSER = flib.getDataFromPropertyFile("Browser");
		if(BROWSER.equals("Chrome")){
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("Firefox")){
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		wlib.waitForPageToload(driver, 20);
	}
	@BeforeMethod(groups= {"smoke" ,"regression"})
	public void configBm() throws IOException {
		System.out.println("==Login==");
		 String URL = flib.getDataFromPropertyFile("Url");
		 String USERNAME=flib.getDataFromPropertyFile("Username");
		 String PASSWORD=flib.getDataFromPropertyFile("Password");
		 LoginPage lp=new LoginPage(driver);
		 lp.loginToApp(URL, USERNAME, PASSWORD);

	}
	
	@AfterMethod(groups= {"smoke" ,"regression"})
	public void configAm() {
		System.out.println("==Logout==");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups= {"smoke" ,"regression"})
	public void configAc() {
		System.out.println("===close the browser===");

		driver.quit();
	}
	@AfterSuite(groups= {"smoke" ,"regression"})
	public void configAs() {
		System.out.println("==Close the connection and report backup==");
		dlib.closeDbConnection();
		
	}
	

}
