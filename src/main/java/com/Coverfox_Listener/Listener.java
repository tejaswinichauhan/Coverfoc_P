package com.Coverfox_Listener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.Coverfox_Base.Base;

public class Listener extends Base implements ITestListener{
	
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("Test case "+result.getName()+" passed",true);
	}
	
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("Test case "+result.getName()+" skipped",true);
	}
	
	

}
