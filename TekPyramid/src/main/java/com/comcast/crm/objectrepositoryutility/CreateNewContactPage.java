package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactPage {

	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement contactLastNameEdt;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement plusOrgBtn;

	@FindBy(name = "support_start_date")
	private WebElement supportStartDateEdt;

	@FindBy(name = "support_end_date")
	private WebElement supportEndDateEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	public WebElement getContactLastNameEdt() {
		return contactLastNameEdt;
	}

	public WebElement getPlusOrgBtn() {
		return plusOrgBtn;
	}

	public WebElement getSupportStartDateEdt() {
		return supportStartDateEdt;
	}

	public WebElement getSupportEndDateEdt() {
		return supportEndDateEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createContact(String lastName) {
		contactLastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createContactWithOrg(String contactLastName,String orgName) {
		contactLastNameEdt.sendKeys(contactLastName);
		plusOrgBtn.click();
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.switchToTabOnUrl(driver,"Accounts&action");
		AccountPopupPage app=new AccountPopupPage(driver);
		app.clickOnDynamicAccount(orgName);
		wlib.switchToTabOnUrl(driver, "Contacts&action");
		saveBtn.click();
		
	}
	

}
