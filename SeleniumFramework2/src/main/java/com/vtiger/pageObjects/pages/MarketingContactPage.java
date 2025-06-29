package com.vtiger.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.CommonLib;

public class MarketingContactPage extends BasePage {
	
	 WebDriver driver;

		public MarketingContactPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

	
	
	@FindBy(xpath="//img[@title='Create Contact...']/ancestor::a")
	private WebElement createContactLink;
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement contactNameTypeDropDown;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement contactFirstNameInput;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement contactLastNameInput;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement assignTypeRadioButton;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement assignTypeDropDown;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement saveButton;
	
	public void createContactRecord(String NameTypeText,String FirstName,String LastName,String assignTypeText) {
		CommonLib.fn_Click(createContactLink, 20);
		CommonLib.fn_SelectDropDownValueUsingText(contactNameTypeDropDown, NameTypeText);
		CommonLib.fn_SendKeys(contactFirstNameInput, FirstName, 10);
		CommonLib.fn_SendKeys(contactLastNameInput, LastName, 10);
		CommonLib.fn_Click(assignTypeRadioButton, 10);
		CommonLib.fn_SelectDropDownValueUsingText(assignTypeDropDown, assignTypeText);
		CommonLib.fn_Click(saveButton, 10);
		
	}

	
	
	
	

}
