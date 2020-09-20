package com.briq.exercise;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import conversion.Utility.FileUtilities;
import conversion.common.Testbase;
import conversion.model.JSONModel;

public class TC01_ConvertJSON2Excel extends Testbase{
	
	FileUtilities fileFunctions = new FileUtilities();
	
	
	@Test
	public void Json2ExcelConvertion() throws Exception {
		System.out.println("JSON 2 Excel ---> START");	  
		//Convert JSON data to string 
		String jsonStr = fileFunctions.readFileAsString(jsonPath_JSON2Excel);
	    //Convert String to OBJECT
		List<JSONModel> jsonModelList = fileFunctions.convertJsonString2Objects(jsonStr);
	    //Write down Converted object data to excel by setting up column headers
		fileFunctions.writeObjects2ExcelFile(jsonModelList, System.getProperty("user.dir")+"/src/test/resources/com/briq/conversion/excel/JSON2ExcelWriter.xlsx");
		System.out.println("JSON 2 Excel ---> DONE");	  
	}

}
