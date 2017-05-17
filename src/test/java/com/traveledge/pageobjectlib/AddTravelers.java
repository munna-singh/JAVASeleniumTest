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


public class AddTravelers extends WebDriverCommonLib{
	
	@FindBy(id="clientSearch")
	private WebElement addTraveler;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-select-client']")
	private WebElement selectTraveler;
	
	@FindBy(id="view21_traveling")
	private WebElement isTravelling;
	
	@FindBy(xpath="//button[text()='Close']")
	private WebElement closeExp;
		
	@FindBy(xpath="//select[@name='Title']")
	private WebElement title;
	
	@FindBy(xpath="//input[@name='FirstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='LastName']")
	private WebElement lastName;
	
	@FindBy(xpath="(//select[@class='day form-control de-form-control'])[1]")
	private WebElement date;
	
	@FindBy(xpath="(//select[@class='month form-control de-form-control'])[1]")
	private WebElement month;
	
	@FindBy(xpath="(//select[@class='year form-control de-form-control'])[1]")
	private WebElement year;
	
	@FindBy(xpath="//label[@class='de-label']/input[@value='M']")
	private WebElement male;

	@FindBy(xpath="//select[@name='Nationality']")
	private WebElement nationality;


	@FindBy(xpath="//button[text()='Book Only']")
    private WebElement bookOnly;
	
	ExcelLib e= new ExcelLib();
	
	
	public void addTravelers(Actions act) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		
		String travellerName=e.getExcelData("Client Traveler", 0, 1);
		addTraveler.sendKeys(travellerName);
		act.sendKeys(Keys.ENTER).perform();
		selectTraveler.click();
		//act.moveToElement(isTravelling).click().perform();
		Thread.sleep(5000);
		
		//closeExp.click();
		String Title=e.getExcelData("Add Traveller", 0, 1);
		selectFromDropDown(title,Title);
		String firstname=e.getExcelData("Add Traveller", 1, 1);		
		firstName.sendKeys(firstname);
		String lastname=e.getExcelData("Add Traveller", 2, 1);			
		lastName.sendKeys(lastname);
		String dT=e.getExcelData("Add Traveller", 3, 1);
		String mN=e.getExcelData("Add Traveller", 4, 1);
		String yR=e.getExcelData("Add Traveller", 5, 1);
		System.out.println(dT+" ### "+mN+" ### "+yR);
		selectFromDropDown(date, dT);
		selectFromDropDown(month, mN);
		selectFromDropDown(year, yR);
		String nationaliTy=e.getExcelData("Add Traveller", 6, 1);
		selectFromDropDown(nationality, nationaliTy);
		act.moveToElement(bookOnly).click().build().perform();
	
		//bookOnly.click();
		
		waitForPageToLoad();
		
	}
	
	@FindBy(xpath="//input[@class='traveler-verified']")
	private WebElement verified;
	
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement Continue;
	
	public void verifyTravelersLegalNames() throws InterruptedException{
		
		Thread.sleep(10000);
		verified.click();
		Continue.click();
		
	}
	
	 public void selectFromDropDown(WebElement wb,String value){
		 Select s=new Select(wb);
		 s.selectByValue(value);
		 
	 }

}
