package com.traveledge.pageobjectlib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.traveledge.common.WebDriverCommonLib;



public class Quote4 extends WebDriverCommonLib{
	
	@FindBy(xpath="//button[@class='btn btn-primary on-quote-only-click']")
	private WebElement quote;
	 
	 public void quoteIt(){
		 quote.click();
		 waitForPageToLoad();
	 }

}
