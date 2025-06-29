package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(xpath = "//input[@name='search_text']/..//following-sibling::td//select")
	private WebElement selectDropDown;
	
	@FindBy(xpath = "//input[@name='submit' and @value=' Search Now ']")
	private WebElement searchBtn;
	
	
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSelectDropDown() {
		return selectDropDown;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	

}
