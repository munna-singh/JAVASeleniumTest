//=====================================================================================
//File:        Reporting
//Created:      2017/04/07
//Last Changed: 
//Author:       Pritam Samantaray

//=====================================================================================






package com.traveledge.common;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport
{
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    
    @BeforeSuite
    public void setUp()
    {
    	
    	
    	String currentDate=getDateTime();
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+currentDate+"MyOwnReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Host Name", "CI");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Pritam");
         
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting Report");
        htmlReporter.config().setReportName("testReport");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }
     
    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
        	String screenShotPath = GetScreenShot.capture(Browser.driver, "screenShotName");
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
            test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
           }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
        extent.flush();
    }
     
    @AfterSuite
    public void tearDown()
    {
       // extent.flush();
    }
    
    public String getDateTime(){
        	
    	 // Create object of SimpleDateFormat class and decide the format
    	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	 
    	 //get current date time with Date()
    	 Date date = new Date();
    	 
    	 // Now format the date
    	 String currentDate= dateFormat.format(date);
    	 
    	String newDate=currentDate.replace('/' , '_');
    	 String newCurrentDate=newDate.replace(':', '.');
    	 // Print the Date
    	 System.out.println("Current date and time is " + newCurrentDate );
		return newCurrentDate;
    	
    }
}