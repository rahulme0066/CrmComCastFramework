package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToload(WebDriver driver,int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void switchToTabOnUrl(WebDriver driver,String partial_Url) {
		Set<String> allWinID = driver.getWindowHandles();
		Iterator<String> itr1 = allWinID.iterator();
		while(itr1.hasNext()) {
			String winId = itr1.next();
			driver.switchTo().window(winId);
				String actUrl = driver.getCurrentUrl();
				if(actUrl.contains(partial_Url)) {
					break;
				}
		}
		
	}
	
	public void switchToTabOnTitle(WebDriver driver,String partial_Title) {
		Set<String> allWinID = driver.getWindowHandles();
		Iterator<String> itr1 = allWinID.iterator();
		while(itr1.hasNext()) {
			String winId = itr1.next();
			driver.switchTo().window(winId);
				String acttitle = driver.getTitle();
				if(acttitle.contains(partial_Title)) {
					break;
				}
		}
		
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		
	}
	
    public void switchToFrame(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}
    
     public void switchToFrame(WebDriver driver,WebElement element) {
    	 driver.switchTo().frame(element);
		
	}
     public void switchToAlertAndAccept(WebDriver driver) {
    	 driver.switchTo().alert().accept();
 		
 	}
     
     public void switchToAlertAndCancel(WebDriver driver) {
  		driver.switchTo().alert().dismiss();
  	}
     public void select(WebElement element,String text) {
    	 Select sec=new Select(element);
    	 sec.selectByVisibleText(text);
     }
     
     public void select(WebElement element,int index) {
    	 Select sec=new Select(element);
    	 sec.selectByIndex(index);
    	 
     }
     
     public void mouseMoveOnElement(WebDriver driver,WebElement element) {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(element).perform();
    	 
     }
     public void doubleClick(WebDriver driver,WebElement element) {
    	 Actions act=new Actions(driver);
    	 act.doubleClick(element).perform();
     }

	
}
