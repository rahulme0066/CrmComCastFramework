package com.vtiger.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.CommonLib;

public class MarketingAccountPage extends BasePage {
	
	 WebDriver driver;

	public MarketingAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//img[@title='Create Account...']/ancestor::a")
	private WebElement createAccountLink;
	
	
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement accountNameInput;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement assignTypeRadioButton;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement assignTypeDropdown;
	
	
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement saveButton;
	
	public void createAccountRecord(Object accName,Object groupName) {
		
		CommonLib.fn_Click(createAccountLink, 10);
		CommonLib.fn_SendKeys(accountNameInput, "rahulKeshari", 10);
		CommonLib.fn_Click(assignTypeRadioButton, 10);
		CommonLib.fn_SelectDropDownValueUsingText(assignTypeDropdown, groupName);
		CommonLib.fn_Click(saveButton, 10);
	}
	
	


}
