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
import com.Coverfox_POM.resultPage;
import com.Coverfox_Utility.Utility;

public class CoverFoxTestNG extends Base{
	
	
	Logger logger;
	coverfoxHomepage CoverfoxHomepage;
	MemberDetails memberDetails;
	//addressDetails AddressDetails;
	addressDetails AddressDetails;
	HealthplanPage healthplanPage;
	resultPage ResultPage;
	
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
		 
		
		
	}
//	 @BeforeMethod
//	 public void coverfoxprecondition() throws InterruptedException, EncryptedDocumentException, IOException
//	 {
		 
		 
//		 CoverfoxHomepage.clickonGender();
//		 Thread.sleep(4000);
//		 healthplanPage.clickonHusband();
//		 Thread.sleep(4000);
//		 healthplanPage.clickbutton();
//		 Thread.sleep(4000);
//		 memberDetails.husband();
//		 
//		 memberDetails.wife();
//		 memberDetails.nextbuttonMD();
//		 Thread.sleep(4000);
//		 
		 
		 
		 
//		 AddressDetails.enterPincode(Utility.readdatafromExcel("Sheet1", 0, 0));
//	
//		 Thread.sleep(4000);
//		 
//		 AddressDetails.entermobNo(Utility.readdatafromExcel("Sheet1", 1, 0));
//		
//		 Thread.sleep(4000);
		 
		 
		 
//		 Utility.takescreenshot(driver, "main"); 	 
//	 }
	 
	 @Test(priority = 1)
	 public void validateAddressDetails() throws InterruptedException, EncryptedDocumentException, IOException
	 {
		 AddressDetails.clickoncontinue();
		 Thread.sleep(3000);
		 String actualMsgpincode = AddressDetails.validatepincode();
		 System.out.println(actualMsgpincode);
		 String expmsgPincode="Please enter a valid pincode";
		 Assert.assertEquals(actualMsgpincode, expmsgPincode,"TC failed,Error Message for pincode is not matching");
		Reporter.log("Pincode error msg validated",true);
		 
		 String actualMsgMobno = AddressDetails.validatemobno();
		 System.out.println(actualMsgMobno);
		 String expmsgMobno="Please enter a valid mobile no.";
		 Assert.assertEquals(actualMsgMobno, expmsgMobno,"TC failed,Error Message for mobile number is not matching");
	     Reporter.log("TC1 validated",true);
	     
	     
		 
	     AddressDetails.enterPincode(Utility.readdatafromExcel("Sheet1", 0, 0));
		 Thread.sleep(4000);
		 AddressDetails.entermobNo(Utility.readdatafromExcel("Sheet1", 1, 0));
		 Thread.sleep(4000);
		 AddressDetails.clickoncontinue();
		 
		 
	 }
	 
	
	
	
	
  @Test(priority = 2)
  public void validatecoverfox() throws InterruptedException 
  {
	  int numfromText = ResultPage.getlannumberfromtext();
	  System.out.println(numfromText);
		int numfromCards = ResultPage.getlannumberfromcards();
		System.out.println(numfromCards); 
		//Thread.sleep(3000);
		Assert.assertEquals(numfromText, numfromCards,"TC failed, numbers are not matching");
		 Thread.sleep(3000);
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
