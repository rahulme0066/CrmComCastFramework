package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.baseTest.BaseClass;

public class CreateContactWithOrg extends BaseClass{

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
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
		Sheet sheet = wb.getSheet("Contact");
		Row row = sheet.getRow(1);
		  String orgName = row.getCell(2).toString()+randomInt;
			String contactName=row.getCell(1).toString()+randomInt;

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
		
		
		
		
		
		
		
		
		
		//navigate to contact and create contact
		Thread.sleep(2000);
				
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		Set<String> allWinId = driver.getWindowHandles();
		Iterator<String> itr = allWinId.iterator();
		while(itr.hasNext()) {
			String winId = itr.next();
			driver.switchTo().window(winId);
				String actUrl = driver.getCurrentUrl();
				if(actUrl.contains("module=Accounts&action")) {
					break;
				}
		}
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();   //======>>>>Dynamic xpathhhhhh
		
		//Switch to paraent window
		Set<String> allWinID = driver.getWindowHandles();
		Iterator<String> itr1 = allWinID.iterator();
		while(itr1.hasNext()) {
			String winId = itr1.next();
			driver.switchTo().window(winId);
				String actUrl = driver.getCurrentUrl();
				if(actUrl.contains("Contacts&action")) {
					break;
				}
		}
		
Date dataObj=new Date();
		
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sim.format(dataObj);
		System.out.println(startDate);
         
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String endDate = sim.format(cal.getTime());
		System.out.println(endDate);
	
		driver.findElement(By.xpath("//input[@name='support_start_date']")).clear();
		driver.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(startDate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		Thread.sleep(2000);
		
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	String actStartDate = driver.findElement(By.id("mouseArea_Support Start Date")).getText();
	System.out.println(actStartDate);
	if(actStartDate.trim().equals(startDate)) {
		System.out.println(startDate+" information is varified==>>PASS");
	}
	else {
		System.out.println(startDate+" information is NOT varified==>>FAIL");
	}
	
	String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	System.out.println(actOrgName);
	if(actOrgName.trim().equals(orgName)) {
		System.out.println(orgName+" information is created==>>PASS");
	}
	else {
		System.out.println(orgName+" information is not created==>>FAIL");
	}

		
		
		driver.quit();
		


	}

}
