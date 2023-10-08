package Qus.automationInternship.pages;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Qus.automationInternship.drivers.BaseDriver;


public class ExcelOutput extends BaseDriver{
	
 public static void timeout() throws InterruptedException{
	 Thread.sleep(3000);
 }
 public static void timeout(int time) throws InterruptedException{
	 Thread.sleep(time);
 }
 
 static ArrayList<String> mindata = new ArrayList<String>();
 static ArrayList<String> maxdata = new ArrayList<String>();
    public void getData(String max,String min) {
    	mindata.add(max);
		maxdata.add(min);
    }
    public void Senddata() throws IOException {
		 
	Exel(mindata,maxdata);
		 
	 }
	 
    
	String TodayName;
	public  void getDate() {  
		
	     String dayNames[] = new DateFormatSymbols().getWeekdays();  
	     Calendar date = Calendar.getInstance();  
	     TodayName = dayNames[date.get(Calendar.DAY_OF_WEEK)];
	   
	  }  
	

	
	@SuppressWarnings("resource")
	  public void Exel(ArrayList<String> data, ArrayList<String> data2) throws IOException {
		
	      getDate();
	      try {
	      String FilePath = ".\\src\\Excel.xlsx";
	      FileInputStream file = new FileInputStream(FilePath);
	      XSSFWorkbook workbook = new XSSFWorkbook(file);
	      XSSFSheet sheet = workbook.getSheet(TodayName);
	      System.out.println("Connected for Input");

	      int LastRowCount = sheet.getLastRowNum()+1;
	      int FristRowCount  = sheet.getFirstRowNum()+2;
	      System.out.println(FristRowCount);
        
//	      Insert data on Excel Sheet:
      
      for(int r=FristRowCount;r<LastRowCount;r++) {
    	  XSSFCell coll = sheet.getRow(r).createCell(3);
    	  coll.setCellValue(maxdata.get(r-2));
    	  
      }
          
      for(int r=FristRowCount;r<LastRowCount;r++) {
    	  XSSFCell coll = sheet.getRow(r).createCell(4);
    	  coll.setCellValue(mindata.get(r-2));
    	 
      }
      

          file.close();
          
          FileOutputStream fileOutputStream = new FileOutputStream(FilePath);
          workbook.write(fileOutputStream);
          fileOutputStream.close();
         
          
   
	       
	      }
	      catch(Exception e) {
	      System.out.println(e);
	      }
	      System.out.println("Updated");
	    }


}
