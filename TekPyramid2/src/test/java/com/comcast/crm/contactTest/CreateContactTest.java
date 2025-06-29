package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.baseTest.BaseClass2;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

import junit.framework.Assert;

public class CreateContactTest extends BaseClass2 {

	@Test(groups = { "smoke" })
	public void createContactTest() throws Throwable {

		HomePage hp = new HomePage(driver);
		ListImpClass.test.log(Status.INFO, "navigate to contact link");

		hp.getContactLink().click();
		ListImpClass.test.log(Status.INFO, "Navigate to create contact page");

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		ListImpClass.test.log(Status.INFO, "Read data from excel");
		String contactName = elib.getDataFromExcel("Contact", 1, 1) + jlib.getRandomNumber();
		ListImpClass.test.log(Status.INFO, "Create a new contact");

		cncp.createContact(contactName);
		ListImpClass.test.log(Status.INFO, contactName+" contact is created");


		ContactInfoPage cip = new ContactInfoPage(driver);  
		String actHeadermsg = cip.getHeaderMsg().getText();
		Assert.assertEquals(true, actHeadermsg.contains(contactName));

	}

//	@Test(groups= {"smoke" ,"regression"})
	public void createContactWithOrgTest() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
		cnop.createOrg(orgName);

		Thread.sleep(2000);

		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		String contactLastName = elib.getDataFromExcel("Contact", 1, 1);
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContactWithOrg(contactLastName, orgName);

		ContactInfoPage cip = new ContactInfoPage(driver);
		String actOrgName = cip.getActualOrg().getText();

		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " information is created==>>PASS");
		} else {
			System.out.println(orgName + " information is not created==>>FAIL");
		}

	}

}
