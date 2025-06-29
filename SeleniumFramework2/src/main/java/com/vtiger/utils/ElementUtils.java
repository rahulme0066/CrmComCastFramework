package com.vtiger.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	public static WebElement waitForElementToBeDisplayed(WebElement element,int time) {
		WebDriverWait wait=new WebDriverWait(DriverFactory.driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static WebElement findElements(By by,int time) {
		
		return waitForElementToBeDisplayed(DriverFactory.driver.findElement(by),time) ;
	}

}
