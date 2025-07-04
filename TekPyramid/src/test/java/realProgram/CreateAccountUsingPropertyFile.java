package realProgram;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateAccountUsingPropertyFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		  Properties prop = new  Properties();
		  prop.load(fis);

		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("Url");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");



		
		
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
		driver.manage().window().maximize();
		Random ran =new  Random();
		int ranInt = ran.nextInt(1000);
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("Marketing"))).perform();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Account...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Rahul"+ranInt);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		driver.findElement(By.linkText("Sign Out")).click();
	


	}

}
