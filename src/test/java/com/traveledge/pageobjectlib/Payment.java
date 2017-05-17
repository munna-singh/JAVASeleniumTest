package com.traveledge.pageobjectlib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.traveledge.common.ExcelLib;
import com.traveledge.common.WebDriverCommonLib;


public class Payment extends WebDriverCommonLib {

	@FindBy(id="firstName")
	private WebElement cardHolderFirstName;
	
	@FindBy(xpath="//input[@name='LastName']")
	private WebElement cardHolderLastName;
	
	@FindBy(id="creditCardNumber")
	private WebElement cardNumber;
	
	@FindBy(id="month")
	private WebElement expiryMonth;
	
	@FindBy(xpath="//select[@name='Year']")
	private WebElement expiryYear;
	
	@FindBy(id="verificationCode")
	private WebElement verificationNumber;
	
	@FindBy(id="address1")
	private WebElement address;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="country")
	private WebElement country;
	
	@FindBy(id="stateProvince")
	private WebElement state;
	
	@FindBy(id="zipPostalCode")
	private WebElement zip;
	
	@FindBy(xpath="//input[@name='UseAddressForInvoice' and @value='Yes']")
	private WebElement noInvoiceAddressUseAddressEnteredHere;
		
	@FindBy(xpath="//input[@class='accept-toc-checkbox']")
	private WebElement acceptCondition;
	
	
	
	@FindBy(id="payAndTicket")
	private WebElement payAndTicket;
	
    ExcelLib e= new ExcelLib();
	
	
	public void makePayment() throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		String firstNmae=e.getExcelData("Payment", 0, 1);
		String lastName=e.getExcelData("Payment", 1, 1);
		String CardNumber=e.getExcelData("Payment", 2, 1);
		String expMonth=e.getExcelData("Payment", 3, 1);
		String expYear=e.getExcelData("Payment", 4, 1);
		String verificationCode=e.getExcelData("Payment", 5, 1);
		String Address=e.getExcelData("Payment", 6, 1);
		String City=e.getExcelData("Payment", 7, 1);
		String Country=e.getExcelData("Payment", 8, 1);
		String State=e.getExcelData("Payment", 9, 1);
		String Zip=e.getExcelData("Payment", 10, 1);
		cardHolderFirstName.sendKeys(firstNmae);
		cardHolderLastName.sendKeys(lastName);
		cardNumber.sendKeys(CardNumber);
		selectFromDropDown(expiryMonth,expMonth);
		selectFromDropDown(expiryYear,expYear);
		verificationNumber.sendKeys(verificationCode);
		address.sendKeys(Address);
		city.sendKeys(City);
		selectFromDropDown(country,Country);
		selectFromDropDown(state,State);
		zip.sendKeys(Zip);
		acceptCondition.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(!payAndTicket.isEnabled()){
			
			noInvoiceAddressUseAddressEnteredHere.click();
			
		}
				
		
		
		
		payAndTicket.click();
		waitForPageToLoad();
		
		
	}

	 public void selectFromDropDown(WebElement wb,String value){
		 Select s=new Select(wb);
		 s.selectByValue(value);
		 
	 }

}
