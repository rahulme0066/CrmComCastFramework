package com.vtiger.pageObjects.pages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.CommonLib;

public class QuickCreateEventPage {
	WebDriver driver;
	public QuickCreateEventPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	
	
	@FindBy(xpath="//input[@name='subject']")
	private WebElement subjectNameInput;
	
	@FindBy(xpath="//select[@name='eventstatus']")
	private WebElement eventStatusDropDown;
	
	@FindBy(xpath="//input[@name='due_date']")
	private WebElement endDateInput;
	
	@FindBy(xpath="//input[@name='date_start']")
	private WebElement startDateInput;
	
	@FindBy(xpath="//input[@name='time_start']")
	private WebElement timeStartInput;
	
	@FindBy(xpath="//select[@name='activitytype']")
	private WebElement activityTypeDropDown;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement assignTypeRadioButton;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement assignTypeDropDown;
	
	@FindBy(xpath="//input[@value='  Save']")
	private WebElement saveInput;
	
	public void createEventRecord(String subjectName,String eventStatus,String endDate,String startDate,String timeStart,String activityTypeValue,String assignTypeValue ) {
        CommonLib.fn_SendKeys(subjectNameInput, subjectName, 10);
        CommonLib.fn_SelectDropDownValueUsingValue(eventStatusDropDown, eventStatus);
        CommonLib.fn_SendKeys(endDateInput, endDate, 10);
        CommonLib.fn_SendKeys(startDateInput, startDate, 10);
        CommonLib.fn_SendKeys(timeStartInput, timeStart, 10);
        CommonLib.fn_SelectDropDownValueUsingValue(activityTypeDropDown, activityTypeValue);      
        CommonLib.fn_Click(assignTypeRadioButton, 10);
        CommonLib.fn_SelectDropDownValueUsingText(assignTypeDropDown, assignTypeValue);
        CommonLib.fn_Click(saveInput, 10);
        
        
	}
	

}
