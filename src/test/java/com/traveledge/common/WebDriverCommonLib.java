//=====================================================================================
//File:        common functionality
//Created:      2017/04/07
//Last Changed: 
//Author:       Pritam Samantaray

//=====================================================================================




package com.traveledge.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	
	public WebDriver driver;
	
	public void waitForPageToLoad(){
		Browser.driver.manage().timeouts().implicitlyWait
		                         (50, TimeUnit.SECONDS);
	}

	public void waitForLinkNamePresent(String linkName){
		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated
				(By.linkText(linkName)));
		
	}
	
	public void waitForXpathPresent(String wbXpath){
		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated
				(By.xpath(wbXpath)));
		
	}
	
	//isClickable
	public  boolean isClickable(WebElement wb)      
	{
	try
	{
	   WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	   wait.until(ExpectedConditions.elementToBeClickable(wb));
	   return true;
	}
	catch (Exception e)
	{
	  return false;
	}
	}
	public void waitForIDPresent(String wbID){
		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated
				(By.id(wbID)));
		
	}
	
	
	public boolean verifyTest(WebElement wb , String expectedMsg){
		boolean flag = false;
		String actMsg = wb.getText();
		if(expectedMsg.equals(actMsg)){
			flag = true;
			System.out.println("msg is verfied==PASS");
		}else{
			System.out.println("msg is not verfied==FAIL");
		}
		return flag;
	}
	
	public void acceptAlert(){
		Alert alt = Browser.driver.switchTo().alert();
		alt.accept();
	}
	
	
	public void cancelAlert(){
		Alert alt = Browser.driver.switchTo().alert();
		alt.dismiss();
	}
	
	
	public void selectFromDropdown(WebElement wb, String elementTobeClicked){
		Select s=new Select(wb);
		s.deselectByValue(elementTobeClicked);
		}
	
	
	
}
