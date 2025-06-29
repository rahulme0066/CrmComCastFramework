package com.vtiger.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.CommonLib;
import com.vtiger.utils.ElementUtils;

public class HomePage extends BasePage {
	
	 WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	}
	
	
	@FindBy(xpath="//a[text()='My Home Page']")
	private WebElement homepageLogo;
	
	@FindBy(xpath="//a[text()='Marketing']")
	private WebElement marketingLink;
	
	public boolean varifyHomePage() {
		
		return CommonLib.isElementDisplayed(homepageLogo);
	}
	
	

}
