package com.Coverfox_Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base {
	
	public WebDriver driver;
	
	public void openbrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://www.coverfox.com/");
		Reporter.log("Browser Launched",true);
	}

	public void closebrowser() throws InterruptedException
	{
		driver.quit();
		Reporter.log("Close browser",true);
	}
}
