package com.vtiger.test.scripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.pageObjects.pages.BasePage;
import com.vtiger.pageObjects.pages.HomePage;
import com.vtiger.pageObjects.pages.LoginPage;
import com.vtiger.pageObjects.pages.MarketingAccountPage;
import com.vtiger.pageObjects.pages.MarketingContactPage;
import com.vtiger.pageObjects.pages.MarketingLeadPage;
import com.vtiger.utils.CommonLib;
import com.vtiger.utils.DriverFactory;

public class ValidateAccountCreation extends DriverFactory {
//	 WebDriver driver;
	
		@Test
	public void VarifyAccountCreationFromMarketingPage() throws InterruptedException {
		HomePage home= new HomePage(driver);
		BasePage base= new BasePage(driver);
		MarketingAccountPage mp= new MarketingAccountPage(driver);
		LoginPage lp= new LoginPage(driver);
		
		

		lp.doValidLogin(CommonLib.readPropertyData("Username"),CommonLib.readPropertyData("Password"));
//		logger.log(Status.INFO		, "Login successful");
		 Assert.assertTrue(home.varifyHomePage(), "Login is not performed as Home page is not visible");
		 base.openHeaderLinkPage("Marketing", "Accounts");
		 Object accName = CommonLib.readDataFromExcelFile1(System.getProperty("user.dir")+"\\src\\main\\resources\\name.xlsx","Sheet1",1,0);
		 Object groupName = CommonLib.readDataFromExcelFile1(System.getProperty("user.dir")+"\\src\\main\\resources\\name.xlsx","Sheet1",1,1);
		// mp.createAccountRecord("RahulKeshari", "Team Selling");
		 mp.createAccountRecord(accName, groupName);
		
		
	}
//		@Test
//		public void VarifyContactCreationFromMarketingPage() {
//			HomePage home= new HomePage(driver);
//			BasePage base= new BasePage(driver);
//			MarketingContactPage mc= new MarketingContactPage(driver);
//			LoginPage lp= new LoginPage(driver);
//			
//			 lp.doValidLogin("admin", "admin");
//			 Assert.assertTrue( home.varifyHomePage(), "Login is not performed as Home page is not visible");
//			base.openHeaderLinkPage("Marketing", "Contacts");
//			mc.createContactRecord("Mr.","Rahul","Contact","Support Group");
//		
//
//	}
		
//		@Test
//		public void VarifyLeadtCreationFromMarketingPage() {
//			HomePage home= new HomePage(driver);
//			BasePage base= new BasePage(driver);
//			MarketingLeadPage ml= new MarketingLeadPage(driver);
//			LoginPage lp= new LoginPage(driver);
//			
//		 lp.doValidLogin("admin", "admin");
//		 Assert.assertTrue(home.varifyHomePage(), "Login is not performed as Home page is not visible");
//		base.openHeaderLinkPage("Marketing", "Leads");
//		ml.createLeadRecord("Mr.", "Rahul", "Lead", "Navatar","Team Selling");
//	
//		}
	

	
}
