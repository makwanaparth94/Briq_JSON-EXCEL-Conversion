# Briq_JSON-EXCEL-Conversion
## Table of contents
* [Project info](#project-info)
* [Folder Structure](#folder-structure)
* [Required Key Points before Execution](#required-key-points-before-execution)
* [Setup](#setup)

## Project info
This Project is converting a Excel to Json & Json to Excel using Testng with Maven & core java language


## Folder Structure
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;src/main/java <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;conversion.common [Used to define a input for Json file for Json 2 EXCEL && Excel file for Excel to Json Conversion]  <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;conversion.model  [Used to define model for serialization & deserialization]  <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;conversion.Utility [Used to define File function Utilities---> Write Objects to JSON,Convert JSON string to Objects,Convert JSON to String, Read Excel File &       convertinto Java List Objects,Convert Java Objects to JSON File etc]  <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;src/test/java  <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;conversion.briq.exercise  [Designed all test cases here only  <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;src/test/resources <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;com.briq.conversion.excel [Used to store pre-defined(leads/xlsx) excel file and generate runtime excel by using JSON 2 EXCEL Conversion] <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;com.briq.conversion.JSON [Used to store pre-defined(JSON2Excel.json) json file and generate runtime JSON by using Excel 2 JSON Conversion] <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;com.briq.conversion.runner [Used to defined testng.xml file] <br />
          
	
## Setup
To run this project, pull it in local:

```
$ cd Briq_JSON-EXCEL-Conversion
$ mvn clean install
```
