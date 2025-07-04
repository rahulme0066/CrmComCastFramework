package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountPopupPage {
	
	WebDriver driver;

	public AccountPopupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement selcctDropDown;
	
	@FindBy(name="search")
	private WebElement searchBtn;

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSelcctDropDown() {
		return selcctDropDown;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void clickOnDynamicAccount(String orgName) {
		searchEdt.sendKeys(orgName);
		Select sec=new Select(selcctDropDown);
		sec.selectByVisibleText("Organization Name");
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		
	}
	
	



}
