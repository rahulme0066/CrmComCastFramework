package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement actOrgName;
	
	@FindBy(id = "mouseArea_Industry")
	private WebElement industryName;
	
	
	public WebElement getHeaderMsg() {
		return headerMsg;
		
		
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}
	
	public WebElement getIndustryName() {
		return industryName;
	
	}
}
	
