package com.briq.exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import conversion.Utility.FileUtilities;
import conversion.common.Testbase;
import conversion.model.JSONModel;
import conversion.model.Leads;


public class TC02_ConvertExcel2JSON extends Testbase{
	  
	FileUtilities fileFunctions = new FileUtilities();
	
	@Test
	public void Excel2JsonConvertion() throws Exception {
		System.out.println("Excel 2 JSON ---> Started");	  
		// Step 1: Read Excel File into Java List Objects
		List<Leads> leadExcel = fileFunctions.readExcelFile(excelPath_EXCEL2Json);
		// Step 2: Write Java List Objects to JSON File
	    fileFunctions.writeObjects2JsonFile(leadExcel, System.getProperty("user.dir")+"/src/test/resources/com/briq/conversion/JSON/EXCEL2JSON_Lead.json");  
	    System.out.println("Excel 2 JSON ---> DONE");	  
	}
	  
	  

}
