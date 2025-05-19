package com.Coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class coverfoxHomepage {
	
	//1.variable===webelement
	
	@FindBy(xpath="//div[text()='Female']")private WebElement gender;
	
	//2.constructor
	
	public coverfoxHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickonGender()
	{
		
		Reporter.log("Click on gender to continue",true);
		gender.click();
	}
	
	
    
}
