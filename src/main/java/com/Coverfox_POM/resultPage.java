package com.Coverfox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class resultPage {
  
	
	@FindBy(xpath="//div[contains(text(),'matching')]")private WebElement result;
	
	@FindBy(className="plan-card-container")private List<WebElement> result1;
	
	public resultPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void showresult() throws InterruptedException
	{
		Thread.sleep(8000);
		String Mainresult=result.getText();
		
		String[] Result2=Mainresult.split(" ");
		System.out.println(Result2[0]);
		
		int resultinInt=Integer.parseInt(Result2[0]);
		
		Thread.sleep(8000);
		
		int totalresult=result1.size();
		
		System.out.println(totalresult);
		if(totalresult==resultinInt)
		{
			System.out.println("Test Case Pass");
		}
		else
		{
			System.out.println("Test Case Fail");
		}
		
	}
	
	public int getlannumberfromtext() throws InterruptedException
	{
		Reporter.log("Getting plan number from text",true);
		Thread.sleep(3000);
		String planresult=result.getText();
		String[] planresult1=planresult.split(" ");
		int planno=Integer.parseInt(planresult1[0]);
		return planno;
		
	}
	
	public int getlannumberfromcards() throws InterruptedException
	{
		Reporter.log("Getting plan number from card",true);
		Thread.sleep(3000);
		int plannumfromCards = result1.size();
		return plannumfromCards;
		
	}
}
