package praactice.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrgAndDeleteTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		//Read common data from property File
		FileUtility fu=new FileUtility();
		String BROWSER = fu.getDataFromPropertyFile("Browser");
		String URL = fu.getDataFromPropertyFile("Url");
		String USERNAME = fu.getDataFromPropertyFile("Username");
		String PASSWORD = fu.getDataFromPropertyFile("Password");
		
		if(BROWSER.equals("Chrome")){
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("Firefox")){
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		//step 1: login to app
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.doLogin(USERNAME, PASSWORD);
							
				//generate the random number
					JavaUtility ju=new JavaUtility();
				//read data from excel file
				ExcelUtility eu=new ExcelUtility();
								 
				  String orgName=eu.getDataFromExcel("org",1,2)+ju.getRandomNumber();
		         		
					HomePage hp=new HomePage(driver);
					hp.getOrgLink().click();
					
					OrganizationPage op=new OrganizationPage(driver);
					op.getCreateNewOrgBtn().click();
					
					CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
					cnop.createOrg(orgName);
					
									
			
				
				//step 2:navigate to organisation module
					
				//varify Header msg expected result
					OrganizationInfoPage oif=new OrganizationInfoPage(driver);
					String headerInfo=oif.getHeaderMsg().getText();
			
				if(headerInfo.contains(orgName)) {
					System.out.println(orgName +" header is varified==Pass");
				}
				else {
					System.out.println(orgName +" header is not varified==Fail");
					
				}
				
				//varify Header orgName info Expected Result
				String actOrgName=oif.getActOrgName().getText();
				if(actOrgName.equals(orgName)) {
					System.out.println(orgName+" record is created==pass");
				}
				else {
					System.out.println(orgName+" record is not created==fail");
					
				}
				
				hp.getOrgLink().click();
				op.getSearchEdt().sendKeys(orgName);
			//	op.getSelectDropDown()
				WebDriverUtility wu=new WebDriverUtility();
				wu.select(op.getSelectDropDown(), "Organization Name");
				op.getSearchBtn().click();
				driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]//a[text()='del']")).click();

				
				//step 5: logout
	//			hp.logout();
				
	//			driver.quit();
			  	
				

				



	}

}
