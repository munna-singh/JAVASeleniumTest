//=====================================================================================
//File:       Browser (Multiple)
//Created:      2017/04/07
//Last Changed: 
//Author:       Pritam Samantaray

//=====================================================================================




package com.traveledge.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	public static WebDriver driver;
	
	public static WebDriver getBrowser(){
		
		if(Constants.browser.equals("chrome")){
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/requiredSource/chromedriverLatest.exe");
		  
		  //Disable extension for chrome
		  
		  // Create object of ChromeOptions class
		  
		  ChromeOptions options = new ChromeOptions();
		   
		  // add parameter which will disable the extension
		  
		  options.addArguments("disable-infobars");
		  
		  options.addArguments("--disable-extensions");
		   
		  // Start the chrome session
		  driver = new ChromeDriver(options);
		  
		  
		  
		  driver.manage().window().maximize();
		}else if(Constants.browser.equals("ie")){
			  System.setProperty("webdriver.ie.driver", "C:\\Users\\Administrator.Jenifer-PC\\Desktop\\new\\IEDriverServer.exe");
			  driver = new InternetExplorerDriver();
		}else if(Constants.browser.equals("firefox")){
			  driver = new FirefoxDriver();
		}else{
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	
	
	
	
	
	
	
	
	
	
}
