package com.Coverfox_TestNG;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Coverfox_Base.Base;
import com.Coverfox_POM.HealthplanPage;
import com.Coverfox_POM.MemberDetails;
import com.Coverfox_POM.addressDetails;
import com.Coverfox_POM.coverfoxHomepage;
import com.Coverfox_POM.filtersOfResultPage;
import com.Coverfox_POM.resultPage;
import com.Coverfox_Utility.Utility;

public class FinalPage_TestNG extends Base{
	
	
	Logger logger;
	coverfoxHomepage CoverfoxHomepage;
	MemberDetails memberDetails;
	//addressDetails AddressDetails;
	addressDetails AddressDetails;
	HealthplanPage healthplanPage;
	resultPage ResultPage;
	filtersOfResultPage f;
	
	@BeforeClass
	public void launchbrowser() throws EncryptedDocumentException, IOException, InterruptedException
	{
		  logger= Logger.getLogger("My_New_log");
		  PropertyConfigurator.configure("log4j.properties");
		  logger.info("Hello");
		openbrowser();
		Thread.sleep(2000);
		
		CoverfoxHomepage=new coverfoxHomepage(driver);
		memberDetails=new MemberDetails(driver);
		AddressDetails=new addressDetails(driver);
		healthplanPage=new HealthplanPage(driver);
		ResultPage=new resultPage(driver);
		f=new filtersOfResultPage(driver);
		
		 CoverfoxHomepage.clickonGender();
		 Thread.sleep(4000);
		 healthplanPage.clickonHusband();
		 Thread.sleep(4000);
		 healthplanPage.clickbutton();
		 Thread.sleep(4000);
		 memberDetails.husband();
		 
		 memberDetails.wife();
		 memberDetails.nextbuttonMD();
		 Thread.sleep(4000);
		 
		 AddressDetails.enterPincode(Utility.readdatafromExcel("Sheet1", 0, 0));
		 Thread.sleep(4000);
		 AddressDetails.entermobNo(Utility.readdatafromExcel("Sheet1", 1, 0));
		 Thread.sleep(4000);
		 AddressDetails.clickoncontinue();
		 Thread.sleep(4000);
		 
		
		
	}
	
	
	@Test
	public void validateFinalPage() throws InterruptedException
	{
		
		f.validatesumassured("6L");
		int actualList = f.validatevisibleList();
		int visiblePlan = f.validate();
		
		Assert.assertEquals(actualList, visiblePlan, "TC failed,Value is not matching");
		Reporter.log("TC passed",true);
	
	    
		
		
	}

	
	
	@AfterClass
	  public void closebrowser() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  Reporter.log("Closing browser",true);
		  driver.quit();
		  //Thread.sleep(3000);
	  }

}
