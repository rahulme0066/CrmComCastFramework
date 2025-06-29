package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	public WebElement usernameEdt;
	
	
	
	@FindBy(name="user_password")
	 WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	WebElement loginbtn;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

   public void doLogin(String username,String password) {
	   usernameEdt.sendKeys(username);
	   passwordEdt.sendKeys(password);
	   getLoginbtn().click();
	   
   }
   /**
    * 
    * @param url
    * @param username
    * @param password
    */
   public void loginToApp(String url,String username,String password) {
	   driver.get(url);
	   usernameEdt.sendKeys(username);
	   passwordEdt.sendKeys(password);
	   getLoginbtn().click();
	   
	   
   }

}
