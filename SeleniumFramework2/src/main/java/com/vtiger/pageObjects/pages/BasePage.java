package com.vtiger.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vtiger.utils.CommonLib;
import com.vtiger.utils.DriverFactory;
import com.vtiger.utils.ElementUtils;

public class BasePage extends DriverFactory {
	public WebDriver driver;
	
	public BasePage(WebDriver driver) {
	this.driver=driver;	
	}

	
	
public void openHeaderLinkPage(String HeaderLink,String SubHeaderLink) {
		
		String xpathHeader="//a[text()='"+HeaderLink+"']";
		String xpathHeaderOfSubLink="//div[@id='Marketing_sub']//a[text()='"+SubHeaderLink+"']";
		CommonLib.fn_MouseHoverUsingAction(ElementUtils.findElements(By.xpath(xpathHeader), 20), 20);
		CommonLib.fn_Click(ElementUtils.findElements(By.xpath(xpathHeaderOfSubLink), 20), 20);
		
	}
}
