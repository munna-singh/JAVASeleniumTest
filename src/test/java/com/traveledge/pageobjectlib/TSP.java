package com.traveledge.pageobjectlib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.traveledge.common.WebDriverCommonLib;


public class TSP extends WebDriverCommonLib {

	@FindBy(xpath="//a[@class='btn btn-primary air-update-price']")
	private WebElement itenaryBook;
	
	@FindBy(xpath="//a[@class='btn btn-primary air-payment']")
	private WebElement ticketFlight;

	@FindBy(xpath="//a[text()='Back to Trip Services']")
	private WebElement tsp;

	@FindBy(xpath="//span[@class='label-status label-ticketed' and text()='ticketed']")
	private WebElement ticketed;	
	
	
	
	public void clickOnItenaryBook(){
		itenaryBook.click();
		waitForPageToLoad();
	}
	
	public void clickOnTicketFlight(){
		ticketFlight.click();	
		waitForPageToLoad();
	}
	
	public void backToTsp(){
		tsp.click();
		waitForPageToLoad();
		
	}
	public void checkTicketed(){
		Assert.assertTrue(ticketed.isDisplayed(), "staus is not ticketed");
	}
	
}
