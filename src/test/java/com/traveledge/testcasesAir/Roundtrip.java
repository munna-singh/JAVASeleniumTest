//=====================================================================================
//File:        Travel edge Air OneWay
//Created:      2017/04/07
//Last Changed: 
//Author:       Pritam Samantaray
//Jira ID or Test case name:  Air roundTrip search validation    
//Jira Link:   if available
//=====================================================================================




package com.traveledge.testcasesAir;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.traveledge.common.Browser;
import com.traveledge.common.ExcelLib;
import com.traveledge.common.ExtentReport;
import com.traveledge.common.WebDriverCommonLib;
import com.traveledge.pageobjectlib.AddTravelers;
import com.traveledge.pageobjectlib.Air;
import com.traveledge.pageobjectlib.FlightSearchResult;
import com.traveledge.pageobjectlib.Login;
import com.traveledge.pageobjectlib.Logout;
import com.traveledge.pageobjectlib.Payment;
import com.traveledge.pageobjectlib.Quote4;
import com.traveledge.pageobjectlib.Reprice;
import com.traveledge.pageobjectlib.TSP;


public class Roundtrip extends ExtentReport{
	WebDriver driver;
	//ExcelLib eLib = new ExcelLib();	
	WebDriverCommonLib wLib;
	
	Login loginPage;
	Air air;
	FlightSearchResult flightSearchResult;
	Quote4 quote4;
	Reprice reprice;
	TSP tsp;
	AddTravelers addTravelers;
	Payment payment;
	Logout logout;
	ExcelLib eLib = new ExcelLib();	
	
	
	

	
//	@BeforeSuite
//	public void report(){
//
//	
//	
//	}
	
	@BeforeClass
	public void configBrforeClass(){
		//object initialization
		
		driver = Browser.getBrowser();
		wLib = new WebDriverCommonLib();
		loginPage = PageFactory.initElements(driver, Login.class);
		air = PageFactory.initElements(driver, Air.class);
		flightSearchResult = PageFactory.initElements(driver, FlightSearchResult.class);
		quote4 = PageFactory.initElements(driver, Quote4.class);
		reprice = PageFactory.initElements(driver, Reprice.class);
		tsp = PageFactory.initElements(driver, TSP.class);
		addTravelers = PageFactory.initElements(driver, AddTravelers.class);
		payment = PageFactory.initElements(driver, Payment.class);
		logout = PageFactory.initElements(driver, Logout.class);
		
		
		
	}
		

	public void login() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		
		wLib.waitForPageToLoad();
		loginPage.navigateToApp();
		loginPage.loginToAPP();
		
		
//		test = extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
//		
//		 Assert.assertTrue(1 > 0);
		
		
		
				
		
	}


	
	@Test(priority=1)
    public void bookRoundTrip() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		
		login();
		
		
		test = extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		// Assert.assertTrue(1 < 0);
		
		Actions act = new Actions(driver);
		
		air.searchFlightRoundTrip(act);
		flightSearchResult.selectFlight(act);
		Thread.sleep(5000);
		flightSearchResult.selectFlight(act);		
		quote4.quoteIt();
		tsp.clickOnItenaryBook();
		reprice.repriceBook();
		addTravelers.addTravelers(act);
		addTravelers.verifyTravelersLegalNames();
		tsp.clickOnTicketFlight();
		payment.makePayment();
//		Thread.sleep(50000);
//		
//		if(driver.findElement(By.id("payAndTicket")).isDisplayed()){
//			tsp.backToTsp();
//		}
//		else{
//			WebElement wb = driver.findElement(By.xpath("//span[@class='text-darkgrey']"));
//			
//			Assert.assertTrue(wb.isDisplayed());
//		}
//		
	}
	
//	 @AfterMethod
//     public  void LogTestResult(ITestResult result) throws Exception
//     {
//    	 if(result.getStatus()==ITestResult.FAILURE)
//    	 {
//    	  
////    	 String screenshot_path=Utility.captureScreenshot(driver, result.getName());
////    	 String image= logger.addScreenCapture(screenshot_path);
//    	//	 ExtentReport.logger.log(LogStatus.FAIL, "Title verification");
//    	 }
//    	  
//    	 
//     	
//     }
//    
     
//     @AfterSuite
//     public void generateReport(){
////     	generateExtentReport.endReport();
//     }
	

}
