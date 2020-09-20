package conversion.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import conversion.model.JSONModel;
import conversion.model.Leads;


public class FileUtilities {

	/*
	 * Write Converted objects into Excel file
	 */
	 public static void writeObjects2ExcelFile(List<JSONModel> jsonModel, String filePath) throws IOException,NullPointerException {
		    String[] columns = {"computed_region_rxqg_mtj9","location_latitude","location_address","location_longitude", "filed_date", "record_id", "zipcode","street_number","computed_region_ajp5_b2md","existing_units","existing_use","computed_region_yftq_j783","computed_region_bh8s_q3mv","computed_region_uruc_drv6","block","computed_region_jx4q_fizf","permit_type_definition","computed_region_qgnn_b9vv","neighborhoods_analysis_boundaries","supervisor_district","plansets","estimated_cost","description","proposed_use","revised_cost","permit_creation_date","street_name","street_suffix","permit_number","status_date","status","number_of_existing_stories","computed_region_26cr_cadq","lot","number_of_proposed_stories","computed_region_6qbp_sg9q","permit_type","location_recording"};
		    
		    Workbook workbook = new XSSFWorkbook();
		    Sheet sheet = workbook.createSheet("Sheet1");
		  
		    // Row for Header
		    Row headerRow = sheet.createRow(0);
		 
		    // Header
		    for (int col = 0; col < columns.length; col++) {
		    	Cell cell = headerRow.createCell(col);
		    	cell.setCellValue(columns[col]);
		     }
		    
		    //Write data into Excel w.r.t respective headers
		    int rowid = 1;
		    for (JSONModel json2excel : jsonModel) {
		      Row row = sheet.createRow(rowid++);
		 
		      try{
		    	  row.createCell(0).setCellValue(json2excel.getComputed_region_rxqg_mtj9());
		    	  
		    	  row.createCell(1).setCellValue(json2excel.getLocation().getLatitude());
		    	  row.createCell(2).setCellValue(json2excel.getLocation().getHuman_address());
		          row.createCell(3).setCellValue(json2excel.getLocation().getLongitude());
		          
		          row.createCell(4).setCellValue(json2excel.getFiled_date());
		          row.createCell(5).setCellValue(json2excel.getRecord_id());
		          row.createCell(6).setCellValue(json2excel.getZipcode());
		          row.createCell(7).setCellValue(json2excel.getStreet_number());
		          row.createCell(8).setCellValue(json2excel.getComputed_region_ajp5_b2md());
		          row.createCell(9).setCellValue(json2excel.getExisting_units());
		          row.createCell(10).setCellValue(json2excel.getExisting_use());
		          row.createCell(11).setCellValue(json2excel.getComputed_region_yftq_j783());
		          row.createCell(13).setCellValue(json2excel.getComputed_region_uruc_drv6());
		          row.createCell(14).setCellValue(json2excel.getBlock());
		          row.createCell(15).setCellValue(json2excel.getComputed_region_jx4q_fizf());
		          row.createCell(16).setCellValue(json2excel.getPermit_type_definition());
		          row.createCell(17).setCellValue(json2excel.getComputed_region_qgnn_b9vv());
		          row.createCell(18).setCellValue(json2excel.getNeighborhoods_analysis_boundaries());
		          row.createCell(19).setCellValue(json2excel.getSupervisor_district());
		          row.createCell(20).setCellValue(json2excel.getPlansets());
		          row.createCell(21).setCellValue(json2excel.getEstimated_cost());
		          row.createCell(22).setCellValue(json2excel.getDescription());
		          row.createCell(23).setCellValue(json2excel.getProposed_use());
		          row.createCell(24).setCellValue(json2excel.getRevised_cost());
		          row.createCell(25).setCellValue(json2excel.getPermit_creation_date());
		          row.createCell(26).setCellValue(json2excel.getStreet_name());
		          row.createCell(27).setCellValue(json2excel.getStreet_suffix());
		          row.createCell(28).setCellValue(json2excel.getPermit_number());
		          row.createCell(29).setCellValue(json2excel.getStatus_date());
		          row.createCell(30).setCellValue(json2excel.getStatus());
		          row.createCell(31).setCellValue(json2excel.getNumber_of_existing_stories());
		          row.createCell(32).setCellValue(json2excel.getComputed_region_26cr_cadq());
		          row.createCell(33).setCellValue(json2excel.getLot());
		          row.createCell(34).setCellValue(json2excel.getNumber_of_proposed_stories());
		          row.createCell(35).setCellValue(json2excel.getComputed_region_6qbp_sg9q());
		          row.createCell(36).setCellValue(json2excel.getPermit_type());      
		        
		          Cell ageCell = row.createCell(37);
				  ageCell.setCellValue(json2excel.getLocation().isNeed_recording());	
				  
		      }catch(NullPointerException e) { }
		 }
		 
		    FileOutputStream fileOut = new FileOutputStream(filePath);
		    workbook.write(fileOut);
		    fileOut.close();
	}
	 
	 /*
	  * Convert JSON String to Collection 
	  */
	  public static List<JSONModel> convertJsonString2Objects(String jsonString){
		    List<JSONModel> json2excelList = null;
		    
		    try {
		    	ObjectMapper mapper = new ObjectMapper();
		    	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		    	TypeReference<List<JSONModel>> typeRef = new TypeReference<List<JSONModel>>() {
				};
				json2excelList = mapper.readValue(jsonString, typeRef);
		    } catch (JsonParseException e) {
		      e.printStackTrace();
		    } catch (JsonMappingException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    
		    return json2excelList;
		}
	  
	  /*
	   *  Convert JSON to String
	   */
	  public static String readFileAsString(String file)throws Exception
	  {
	      return new String(Files.readAllBytes(Paths.get(file)));
	  }
	  
	  /*
	   * Read Excel File into Java List Objects
	   */
	  public static List<Leads> readExcelFile(String filePath){
	    try {
	      FileInputStream excelFile = new FileInputStream(new File(filePath));
	        Workbook workbook = new XSSFWorkbook(excelFile);
	     
	        Sheet sheet = workbook.getSheetAt(0);
	        Iterator<Row> rows = sheet.iterator();
	        
	        List<Leads> leadExcel2Jsonlist = new ArrayList<Leads>();
	        
	        int rowNumber = 0;
	        while (rows.hasNext()) {
	          Row currentRow = rows.next();
	          
	          // skip header
	          if(rowNumber == 0) {
	            rowNumber++;
	            continue;
	          }
	          
	          Iterator<Cell> cells = currentRow.iterator();
	 
	          Leads lead = new Leads();
	          
	          int cellNumber = 0;
	          while(cells.hasNext()) {
					Cell currentCell = cells.next();
					
					if(cellNumber == 0) {
						lead.setProjectName(currentCell.getStringCellValue());
					}else if(cellNumber == 1) {
						lead.setProjectType((currentCell.getStringCellValue()));
					}else if(cellNumber == 2) {
						lead.setDescription((currentCell.getStringCellValue()));
					}else if(cellNumber == 3) {
						lead.setSqft((currentCell.getStringCellValue()));
					}else if(cellNumber == 4) {
						lead.setEstimatedProjectCost((currentCell.getStringCellValue()));
					}else if(cellNumber == 5) {
						lead.setPermitNumber((currentCell.getStringCellValue()));
					}else if(cellNumber == 6) {
						lead.setNoticeType((currentCell.getStringCellValue()));
					}else if(cellNumber == 7) {
						lead.setStreet((currentCell.getStringCellValue()));
					}else if(cellNumber == 8) {
						lead.setCity((currentCell.getStringCellValue()));
					}else if(cellNumber == 9) {
						lead.setState((currentCell.getStringCellValue()));
					}else if(cellNumber == 10) {
						lead.setZipcode((currentCell.getStringCellValue()));
					}else if(cellNumber == 12) {
						lead.setContactPhone(currentCell.getStringCellValue());
					}//else if(cellNumber == 13) {
						//lead.setContactAddress(currentCell.getNumericCellValue());
					//}
					else if(cellNumber == 14) {
						lead.setContactEmail(currentCell.getStringCellValue());
					}//else if(cellNumber == 15) {
						//lead.setOwner(currentCell.getStringCellValue());
					//}
					else if(cellNumber == 16) {
						lead.setArchitect(currentCell.getStringCellValue());
					}else if(cellNumber == 17) {
						lead.setApplicationDate(currentCell.getStringCellValue());
					}else if(cellNumber == 18) {
						lead.setUploadDate(currentCell.getStringCellValue());
					}else if(cellNumber == 19) {
						lead.setStatus(currentCell.getStringCellValue());
					}else if(cellNumber == 20) {
						lead.setLink(currentCell.getStringCellValue());
					}else if(cellNumber == 21) {
						lead.setSource(currentCell.getStringCellValue());
					}else if(cellNumber == 22) {
						lead.setConstructionStartDate(currentCell.getDateCellValue());
					}
					
				cellNumber++;	
				}
	          
	          leadExcel2Jsonlist.add(lead);
	        }
  
	        return leadExcel2Jsonlist;
	        } catch (IOException e) {
	          throw new RuntimeException("FAIL! -> message = " + e.getMessage());
	        }
	  }
	  
	    /* 
	     * Convert Java Objects to JSON File
	     */
	    public static void writeObjects2JsonFile(List<Leads> leadExcel, String pathFile) {
	        ObjectMapper mapper = new ObjectMapper();
	 
	        File file = new File(pathFile);
	        try {
	            // Serialize Java object info JSON file.
	            mapper.writeValue(file, leadExcel);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
