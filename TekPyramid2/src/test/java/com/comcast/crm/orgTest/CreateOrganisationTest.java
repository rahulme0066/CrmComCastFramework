package com.comcast.crm.orgTest;

import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganisationTest extends BaseClass {
	
	@Test(groups= "smoke")
	public void createorgTest() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
		cnop.createOrg(orgName);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName = oip.getActOrgName().getText();
		if(actOrgName.equals(orgName)) {
			System.out.println(orgName+"==information is varified==>Pass");
		}
		else {
			System.out.println(orgName+"==information is not varified==>Fail");
		}

	}
	
	@Test(groups= {"smoke" ,"regression"})
	public void createOrgWithIndustryTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String orgName = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();
		String industryType = elib.getDataFromExcel("org", 4, 3);
		cnop.createOrgWithIndustry(orgName, industryType);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actIndustryType = oip.getIndustryName().getText();
		
		if(actIndustryType.equals(industryType)) {
			System.out.println(industryType+" dropdown is varified==>Pass ");
		}
		else {
			System.out.println(industryType+" dropdown is not varified==>Fail ");
			
		}
		


		
	}

}
