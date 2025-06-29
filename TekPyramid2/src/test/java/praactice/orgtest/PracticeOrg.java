package praactice.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass2;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class PracticeOrg extends BaseClass2 {
	
	@Test(priority = 1)
	public void createorgTest() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String orgName = "Rahul-1";
		cnop.createOrg("Sushil-2");
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName = oip.getActOrgName().getText();
		Assert.assertEquals(actOrgName, orgName);
//		if(actOrgName.equals(orgName)) {
//			System.out.println(orgName+"==information is varified==>Pass");
//		}
//		else {
//			System.out.println(orgName+"==information is not varified==>Fail");
//		}

	}
	
	@Test(priority = 2)
	public void createOrgWithIndustryTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String orgName = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();
		String industryType ="Energy";
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
