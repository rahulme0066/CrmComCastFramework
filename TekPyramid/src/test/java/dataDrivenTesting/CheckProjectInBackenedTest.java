package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CheckProjectInBackenedTest {

	public static void main(String[] args) throws SQLException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Ninja.properties");
		  Properties prop = new  Properties();
		  prop.load(fis);

		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("Url");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		
		//read data from excel file
		FileInputStream fis1=new FileInputStream("./src/test/resources/Organisation.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("Project");
		Row row = sheet.getRow(1);
		//  String projectName = row.getCell(1).toString()+randomInt;
		  String managerName = row.getCell(2).toString();
		  String projectStatus = row.getCell(3).toString();
         wb.close();
         
         Map<String, Object> chromePrefs = new HashMap<>();
         chromePrefs.put("credentials_enable_service", false);
         chromePrefs.put("profile.password_manager_enabled", false);
         chromePrefs.put("profile.password_manager_leak_detection", false);

          ChromeOptions chromeOptions = new ChromeOptions();
         chromeOptions.setExperimentalOption("prefs", chromePrefs);
        
	
		WebDriver driver=null;
		if(BROWSER.equals("Chrome")){
			driver=new ChromeDriver(chromeOptions);
		}
		else if(BROWSER.equals("Firefox")){
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		String projectName = "Patanjali_03";
		boolean flag=false;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.className("form-control")).sendKeys(managerName);
		WebElement status = driver.findElement(By.xpath("//label[text()='Project Status* ']/following-sibling::select[@name='status']"));
         Select sec=new Select(status);
         sec.selectByValue("Created");
         driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		
Driver driverRef=new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projects","root", "root");
		
		Statement stat = conn.createStatement();
		
		ResultSet resultSet = stat.executeQuery("select * from project");
		
		while(resultSet.next()) {
			String actProjectName = resultSet.getString(4);
			if(projectName.equals(actProjectName)) {
				flag=true;
				System.out.println(projectName +" is avilable in DB==>PASS");
				
			}


		}
		if(flag==false) {
			System.out.println(projectName +" is not avilable in DB==>FAIL");
		}

	}

}
