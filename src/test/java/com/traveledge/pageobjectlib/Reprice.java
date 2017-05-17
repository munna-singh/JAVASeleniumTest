package com.traveledge.pageobjectlib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.traveledge.common.WebDriverCommonLib;


public class Reprice extends WebDriverCommonLib {
	
	@FindBy(xpath="//button[@class='btn btn-primary on-book-click']")
	private WebElement rePriceBook;
	
	public void repriceBook(){
		
		rePriceBook.click();
		waitForPageToLoad();
		
	}
}
