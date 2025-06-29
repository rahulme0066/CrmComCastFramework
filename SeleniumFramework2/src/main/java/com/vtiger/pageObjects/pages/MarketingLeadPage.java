package com.vtiger.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.CommonLib;

public class MarketingLeadPage {
	
	 WebDriver driver;

	public MarketingLeadPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@title='Create Lead...']/ancestor::a")
	private WebElement createLeadLink;
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement LeadNameTypeDropDown;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement leadFirstNameInput;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement leadLastNameInput;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement leadCompanyInput;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement assignTypeRadioButton;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement assignTypeDropDown;
	
	
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement saveButton;
	
	public void createLeadRecord(String NameTypeText,String FirstName,String LastName,String LeadCompany,String dropDownValue) {
		CommonLib.fn_Click(createLeadLink, 20);
		CommonLib.fn_SelectDropDownValueUsingText(LeadNameTypeDropDown, NameTypeText);
		CommonLib.fn_SendKeys(leadFirstNameInput, FirstName, 10);
		CommonLib.fn_SendKeys(leadLastNameInput, LastName, 10);
		CommonLib.fn_SendKeys(leadCompanyInput, LeadCompany, 10);
		CommonLib.fn_Click(assignTypeRadioButton, 10);
		CommonLib.fn_SelectDropDownValueUsingText(assignTypeDropDown, dropDownValue);
		CommonLib.fn_Click(saveButton, 10);
	}
	
	

}
