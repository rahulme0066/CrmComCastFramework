package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	 WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Email")
	private WebElement emailLink;
	
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	
	@FindBy(linkText ="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText ="Contacts")
	private WebElement contactLink;

	@FindBy(linkText ="More")
	private WebElement moreLink;
	
	@FindBy(linkText ="Campaigns")
	private WebElement campaignLink;

	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText ="Sign Out")
	private WebElement logoutBtn;


	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}
	 
	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void navigateToCampaignPage() {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		logoutBtn.click();
		
	}
	


}
