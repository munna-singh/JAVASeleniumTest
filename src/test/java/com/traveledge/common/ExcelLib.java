//=====================================================================================
//File:        Excel Operation
//Created:      2017/04/07
//Last Changed: 
//Author:       Pritam Samantaray

//=====================================================================================




package com.traveledge.common;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelLib {	
	
	String filePath = System.getProperty("user.dir")+"/requiredSource/TestData.xlsx";
	Object Data;
	String convetedData;
	public String getExcelData(String sheetName , int rowNum, int colNum) throws EncryptedDocumentException, IOException, InvalidFormatException{
		
		File src=new File(filePath);
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook  wb = new XSSFWorkbook(fis);
		
		//Workbook wb = WorkbookFactory.create(fis);
		XSSFSheet sh = wb.getSheet(sheetName);
		XSSFRow row = sh.getRow(rowNum);
		XSSFCell cel = row.getCell(colNum);
		
		 if (cel.getCellType() == XSSFCell.CELL_TYPE_STRING){
			 String data = cel.getStringCellValue();
			 System.out.println(data);
			 Data=data;
			 convetedData=(String) Data;
					 
		 }
		 
		 else if(cel.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
			 long data = (long) cel.getNumericCellValue();
			 
			 System.out.println(data);
			 Data=data;
			 System.out.println("Data value" + Data);
			 convetedData=Data.toString();
			 System.out.println("conveted Data value "+convetedData);
		 }
		 
		 else if((cel.getCellType() != XSSFCell.CELL_TYPE_NUMERIC)&& (cel.getCellType() != XSSFCell.CELL_TYPE_STRING)){
			 
			 Date data = cel.getDateCellValue();
			 DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			 String date=df.format(data);
			 
			 Data=date;
			 System.out.println("Data value" + Data);
			 convetedData=Data.toString();
			 System.out.println("conveted Data Date value "+convetedData);
		 }
		 
		 System.out.println(convetedData);
		 return convetedData;
		
		
		
	}
	//getNumericCellValue()
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException,IOException, InvalidFormatException{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	
	
	String dataToSet= null;
	//pass the row count here
	public String getexcelRepeatativeData(String sheetName , int rowcount, int colNum) throws IOException{
		
		for(int i=0;i<=rowcount;i++){
			
			File src=new File(filePath);
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook  wb = new XSSFWorkbook(fis);
			
			XSSFSheet sh = wb.getSheet(sheetName);
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(colNum);
			dataToSet = cel.getStringCellValue();
			 
			System.out.println(dataToSet);
			
			
		}
		return dataToSet;
		
		
	}
	
//	public void setExcelData(String sheetName , int rowNum,int colNum, String data) throws EncryptedDocumentException,IOException, InvalidFormatException{
//		FileInputStream fis = new FileInputStream(filePath);
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet(sheetName);
//		Row row = sh.getRow(rowNum);
//		Cell cel = (Cell) row.createCell(colNum);
//		cel.setCellType(cel.);
//		FileOutputStream fos = new FileOutputStream(filePath);
//		cel.setCellValue(data);
//		wb.write(fos);
//	
//	}
	
	
	
	
	
	
	
	
	

}
