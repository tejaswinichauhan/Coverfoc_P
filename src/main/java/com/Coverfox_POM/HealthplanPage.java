package com.Coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HealthplanPage {
	
	@FindBy(xpath="//div[text()='Husband']")private  WebElement husband;
	
	@FindBy(xpath="//div[text()=' Next ']")private WebElement Nextbutton;
	
	public HealthplanPage(WebDriver driver)
	{
	   PageFactory.initElements(driver,this);	
	}
	public void clickonHusband()
	{
		Reporter.log("Click on husband",true);
		husband.click();
		
	}
	public void clickbutton()
	{
		Reporter.log("Click on next button on health plan page",true);
		Nextbutton.click();
	}
	

}
