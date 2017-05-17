package com.traveledge.pageobjectlib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.traveledge.common.WebDriverCommonLib;


public class FlightSearchResult extends WebDriverCommonLib {
	
	@FindBy(xpath="(//button[@class='btn btn-primary add-flight'])[1]")
	private WebElement selectFlight;
	
	public void selectOneWayFlight(){
	selectFlight.click();
	waitForPageToLoad();
	}
	

	@FindBy(xpath="(//button[@class='btn btn-primary add-flight'])[1]")
	private WebElement selectFlightRoumdTrip;

	
	public void selectFlight(Actions act){
		waitForXpathPresent("(//button[@class='btn btn-primary add-flight'])[1]");
		
		selectFlightRoumdTrip.click();
		waitForPageToLoad();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		
		}
}
