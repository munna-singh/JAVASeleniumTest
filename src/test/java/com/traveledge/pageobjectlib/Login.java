package com.traveledge.pageobjectlib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.traveledge.common.Browser;
import com.traveledge.common.ExcelLib;
import com.traveledge.common.WebDriverCommonLib;



public class Login extends WebDriverCommonLib{

	 @FindBy(id="username")
	 private WebElement userNameEdt;
	 
	 @FindBy(id="password")
	 private WebElement passwordEdt;
	 
	 @FindBy(xpath="//button[@class='btn btn-primary btn-login']")
	 private WebElement signIn;
	 
	 ExcelLib e= new ExcelLib();
		
		
		
	 
	 public void navigateToApp() throws EncryptedDocumentException, InvalidFormatException, IOException{
		 waitForPageToLoad();
		
		 
		 String url=e.getExcelData("Login",2,1);
		 Browser.driver.get(url);
		 //driver.manage().window().maximize();
		 waitForPageToLoad();
	 }
	 
	 
	 public void loginToAPP() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		 
		String userName=e.getExcelData("Login",0,1);
		String passWord=e.getExcelData("Login",1,1);
		System.out.println(userName + "" +passWord);
		
		 userNameEdt.sendKeys(userName);
		 passwordEdt.sendKeys(passWord);
		 Thread.sleep(4000);
		 
		 try{  
			 
			//code that may throw exception  
			 signIn.click();
			}catch(Exception ref){
		
				signIn.click();
				
			}  
		 signIn.click();
		 Thread.sleep(4000);
		 waitForPageToLoad();

}
}
