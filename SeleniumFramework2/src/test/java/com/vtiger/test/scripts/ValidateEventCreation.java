package com.vtiger.test.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.vtiger.utils.CommonLib.fn_SelectDropDownValueUsingValue;


import com.vtiger.pageObjects.pages.HomePage;
import com.vtiger.pageObjects.pages.LoginPage;
import com.vtiger.pageObjects.pages.QuickCreateEventPage;
import com.vtiger.utils.CommonLib;
import com.vtiger.utils.DriverFactory;


public class ValidateEventCreation extends DriverFactory{
	
//	public WebDriver driver;
	
	@Test
	public void varifyEventCreationFromQuickCreate() {
		new LoginPage(driver).doValidLogin("admin", "admin");
		Assert.assertTrue(new HomePage(driver).varifyHomePage(), "Login is not performed as Home page is not visible");

		
//		WebElement Sec = driver.findElement(By.xpath("//select[@id='qccombo']"));
	//	CommonLib.fn_SelectDropDownValueUsingText(driver.findElement(By.xpath("//select[@id='qccombo']")), "Events");
		fn_SelectDropDownValueUsingValue(driver.findElement(By.xpath("//select[@id='qccombo']")), "Events");
		new QuickCreateEventPage(driver).createEventRecord("SumitSubject", "Held", "2025-02-02", "2025-02-02", "15:25", "Meeting", "Support Group");

//		Select Select = new Select(Sec);
//		Select.selectByValue("Events");
//		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("RahulSubject");
//		Select sec1 = new Select(driver.findElement(By.xpath("//select[@name='eventstatus']")));
//		sec1.selectByValue("Held");
//		driver.findElement(By.xpath("//input[@name='due_date']")).sendKeys("2025-02-03");
//		driver.findElement(By.xpath("//input[@name='date_start']")).sendKeys("2025-02-01");
//		
//		driver.findElement(By.xpath("//input[@name='time_start']")).sendKeys("04:18");
//		Select sec2 = new Select(driver.findElement(By.xpath("//select[@name='activitytype']"))) ;
//		sec2.selectByValue("Meeting");
//		
//		driver.findElement(By.xpath("//input[@name='assigntype' and @value='T']")).click();
//		
//		driver.findElement(By.xpath("//input[@value='  Save']")).click();

		
		
	}

}
