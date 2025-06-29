package com.vtiger.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.vtiger.utils.CommonLib;
import com.vtiger.utils.ElementUtils;

public class LoginPage extends BasePage {
	
	 WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//input[@name='user_name']")
	public WebElement usernameInput;
//	 public WebElement getUsername() {
//		 return usernameInput;
//	 }
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passwordInput;
	
	@FindBy(xpath="//input[@name='Login']")
	private WebElement loginButton;
	
	public void doValidLogin(String username,String Password) {
		
		CommonLib.fn_SendKeys(ElementUtils.waitForElementToBeDisplayed(usernameInput, 20), username, 20);
//		logger.log(Status.INFO, "Username entered:"+username);
		CommonLib.fn_SendKeys(ElementUtils.waitForElementToBeDisplayed(passwordInput, 20), Password, 20);
//		logger.log(Status.INFO, "password entered:"+Password);
		CommonLib.fn_Click(ElementUtils.waitForElementToBeDisplayed(loginButton, 10), 20);
//		logger.log(Status.INFO, "click on login button");
	}



}
