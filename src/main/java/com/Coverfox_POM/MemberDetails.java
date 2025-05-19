package com.Coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class MemberDetails {

	
	@FindBy(id="Age-You")private WebElement  wife;
	@FindBy(id="Age-Spouse")private WebElement husband;
	@FindBy(className="next-btn")private WebElement nextbutton1;
	
	public MemberDetails(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void wife()
	{
		Reporter.log("Select the member1",true);
		Select wifeAge=new Select(wife);
		wifeAge.selectByValue("24y");
	}
	
	public void husband()
	{
		Reporter.log("Select the member2",true);
		Select husbandAge=new Select(husband);
		husbandAge.selectByValue("40y");
		
	}
	
	public void nextbuttonMD()
	{
		
		Reporter.log("Click on next button on member details page",true);
		nextbutton1.click();
	}
	

}
