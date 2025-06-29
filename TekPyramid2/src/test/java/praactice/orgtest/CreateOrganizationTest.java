package praactice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
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

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {
		
		//Read common data from property File
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		  Properties prop = new  Properties();
		  prop.load(fis);

		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("Url");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		
		//generate the random number
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		
		//read data from excel file
		FileInputStream fis1=new FileInputStream("./src/test/resources/Organisation.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("org");
		Row row = sheet.getRow(1);
		  String orgName = row.getCell(2).toString()+randomInt;
          wb.close();		
				
		WebDriver driver=null;
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
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step 2:navigate to organisation module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 3:click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step 4:enter all the details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//varify Header msg expected result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName)) {
			System.out.println(orgName +" header is varified==Pass");
		}
		else {
			System.out.println(orgName +" header is not varified==Fail");
			
		}
		
		//varify Header orgName info Expected Result
		
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actOrgName.equals(orgName)) {
			System.out.println(orgName+" record is created==pass");
		}
		else {
			System.out.println(orgName+" record is not created==fail");
			
		}
		
		//step 5: logout
		
		driver.quit();
	  	
		

		

	}

}
