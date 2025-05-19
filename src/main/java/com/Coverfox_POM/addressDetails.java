package com.Coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class addressDetails {
  
	
	@FindBy(className="mp-input-text")private WebElement pincode;
	@FindBy(id="want-expert")private WebElement mobileno;
	@FindBy(xpath="//div[text()='Continue']")private  WebElement  continuebutton;
	@FindBy(xpath="//div[contains(text(),'valid pincode')]")private WebElement pincodeMsg;
	@FindBy(xpath="//div[contains(text(),'mobile no.')]")private WebElement mobnoMsg;
	
	public addressDetails(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterPincode(String pincodee)
	{
		Reporter.log("Entering pincode",true);
		pincode.sendKeys(pincodee);
	}
	
	public void entermobNo(String mobno)
	{
		Reporter.log("Enter mobile number",true);
		mobileno.sendKeys(mobno);
	}
	
	public String validatepincode()
	{
		String errormsg1 = pincodeMsg.getText();
		return errormsg1;
		
		
		
	}
	public String validatemobno()
	{
		String errormsg2 = mobnoMsg.getText();
		return errormsg2;
		
	}
	
	public void clickoncontinue()
	{
		Reporter.log("Click on continue button on address page",true);
		continuebutton.click();
	}
}
