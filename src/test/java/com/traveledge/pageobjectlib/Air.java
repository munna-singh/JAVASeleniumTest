package com.traveledge.pageobjectlib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.traveledge.common.ExcelLib;
import com.traveledge.common.WebDriverCommonLib;


public class Air extends WebDriverCommonLib{
	
	@FindBy(xpath="//div[text()='New Air ']")
	private WebElement newAirQuote;
	
	@FindBy(xpath="//label[@class='btn btn-default label-normal one-way-label']")
	private WebElement onWay;
	
	@FindBy(id="airport-from-1")
	private WebElement from;
	
	@FindBy(xpath="//input[@name='airport-to-1']")
	private WebElement to;
	
	@FindBy(xpath=".//*[@id='air']/div/div[2]/div/div/div/form/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/input")
	private WebElement depart;
	
	@FindBy(xpath=".//*[@id='air']/div/div[2]/div/div/div/form/div[2]/div/div[2]/div/div/div/div[1]/div/div[1]/div/div/input")
	private WebElement Return;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-search-airfare']")
	private WebElement flightsearch;
	
	@FindBy(xpath="//input[@placeholder='Enter Airline Code or Airline Name']")
	private WebElement airlinesAndAlliances;
	
	@FindBy(xpath="//select[@name='inventory-source']")
	private WebElement inventorySourceGDS;
	
    ExcelLib e= new ExcelLib();
	//String travellerName=e.getExcelData(sheetName, rowNum, colNum);
	
	
	
	
	
	public void selectGDS() throws InterruptedException{
		
		Select s= new Select(inventorySourceGDS);
		s.selectByValue("2");
		
	}
	
	
	@FindBy(xpath="//th[@class='next']")
	private WebElement nextMonth;
	@FindBy(xpath="//td[@class='day' and text()='16']")
	private WebElement date;
	
	
	public void searchFlightOneWay(Actions act) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		newAirQuote.click();
		onWay.click();
		String fromAir=e.getExcelData("Air",0,1);
		String toAir=e.getExcelData("Air",1,1);
	
		
		from.sendKeys(fromAir);
		Thread.sleep(4000);
		act.sendKeys(Keys.ARROW_DOWN);
		act.sendKeys(Keys.ENTER).perform();
		to.sendKeys(toAir);
		Thread.sleep(4000);
		act.sendKeys(Keys.ARROW_DOWN);
		act.sendKeys(Keys.ENTER).perform();
		
		depart.click();
		Thread.sleep(5000);
		nextMonth.click();nextMonth.click();
		nextMonth.click();nextMonth.click();
		nextMonth.click();
		Thread.sleep(3000);
		date.click();
//		act.sendKeys(Keys.ARROW_RIGHT);
//		act.sendKeys(Keys.ENTER).perform();
		
		addAirLines(act);
		selectGDS();
		flightsearch.click();
		waitForPageToLoad();
		
	}
	

	@FindBy(xpath="//label[@class='btn btn-default label-normal round-trip-label active']")
	private WebElement roundTrip;
	
	
	public void searchFlightRoundTrip(Actions act) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		newAirQuote.click();
		roundTrip.click();
		String fromAir=e.getExcelData("Air",0,1);
		String toAir=e.getExcelData("Air",1,1);		
		from.sendKeys(fromAir);
		Thread.sleep(4000);
		act.sendKeys(Keys.ARROW_DOWN);
		act.sendKeys(Keys.ENTER).perform();
		to.sendKeys(toAir);
		Thread.sleep(4000);
		act.sendKeys(Keys.ARROW_DOWN);
		act.sendKeys(Keys.ENTER).perform();
		
		depart.click();
		act.sendKeys(Keys.ARROW_RIGHT);
		act.sendKeys(Keys.ENTER).perform();
		
		Return.click();
		act.sendKeys(Keys.ARROW_RIGHT);
		act.sendKeys(Keys.ENTER).perform();
		
		addAirLines(act);
		selectGDS();
		
		flightsearch.click();
		waitForPageToLoad();
		
	}
	public void addAirLines(Actions act) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		
		airlinesAndAlliances.click();
		String airLine=e.getExcelData("Air",3,1);		
		airlinesAndAlliances.sendKeys(airLine);
		Thread.sleep(3000);		
		act.sendKeys(Keys.ARROW_DOWN);
		act.sendKeys(Keys.ENTER).perform();
		
	}
	

	
	
	
	
	
	
	 public void selectFromDropDown(WebElement wb,String value){
		 Select s=new Select(wb);
		 s.selectByValue(value);
		 
	 }
	

}
