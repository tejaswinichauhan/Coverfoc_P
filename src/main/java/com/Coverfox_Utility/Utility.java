package com.Coverfox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
//	public static String readdatafromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException
//	{
//		Reporter.log("Entering data from Excel",true);
//	   FileInputStream myfile=new FileInputStream("C:\\Users\\chauh\\Downloads\\seleniumExcelfile\\Book1.xlsx");
//	   Sheet mysheet=WorkbookFactory.create(myfile).getSheet(sheetname);
//	   String data = mysheet.getRow(row).getCell(cell).getStringCellValue();
//	   Reporter.log("Reading data from excel",true);
//	   return data;		
//	}
	
	
	public static String readdatafromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException
	{
		Reporter.log("Get data from excel",true);
		FileInputStream myfile=new FileInputStream("C:\\Users\\chauh\\Downloads\\seleniumExcelfile\\Book1.xlsx");
	    Sheet mysheet=WorkbookFactory.create(myfile).getSheet(sheetname);
	    String data=mysheet.getRow(row).getCell(cell).getStringCellValue();
	    return data;
		
	}
	public static void takescreenshot(WebDriver driver,String ss) throws IOException
	{
	
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\chauh\\eclipse-workspace\\SeleniumStudy\\src\\screenshot\\"+ss+".png");
		FileHandler.copy(src, des);
		Reporter.log("Took screen shot",true);
		
		
	}
     
	public static void scrollintoView(WebDriver driver,WebElement element)
	{
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView(true)",element);
	 Reporter.log("Scrolling through webpage",true);
		
		
		
	}
	
	public static String takeProperties(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"coverfox.properties");
		
		prop.load(myfile);
		
		String value = prop.getProperty(key);
		Reporter.log("Getting key value from properties",true);
		return value;
		
	}


}
