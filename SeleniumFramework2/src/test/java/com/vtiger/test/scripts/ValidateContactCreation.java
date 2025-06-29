
package com.vtiger.test.scripts;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ValidateContactCreation {
	
	@Test
	public void VarifyContactCreationFromMarketingPage() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		boolean HomePageVisible = driver.findElement(By.xpath("//a[text()='My Home Page']")).isDisplayed();
		assertTrue(HomePageVisible, "Login is not performed as Home page is not visible");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Marketing']"))).perform();
		act.moveToElement(driver.findElement(By.xpath("//div[@id='Marketing_sub']//a[text()='Contacts']"))).click().perform();
		driver.findElement(By.xpath("//img[@title='Create Contact...']/ancestor::a")).click();
		Select select=new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
		select.selectByValue("Dr.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Contact");
		driver.findElement(By.xpath("//input[@name='assigntype' and @value='T']")).click();
		Select select1=new Select(driver.findElement(By.xpath("//select[@name='assigned_group_id']")));
		select1.selectByValue("4");
		driver.findElement(By.id("phone")).sendKeys("8527236110");
		driver.findElement(By.id("email")).sendKeys("rahulme0066@gmail.com");
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();

		

	}
}
