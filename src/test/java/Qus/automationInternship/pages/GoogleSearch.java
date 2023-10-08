package Qus.automationInternship.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Qus.automationInternship.drivers.PageDriver;

public class GoogleSearch extends ExcelOutput{
	
	public  GoogleSearch() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
	// Get day name:
	String TodayName;
	public  void getDate() {  
	     String dayNames[] = new DateFormatSymbols().getWeekdays();  
	     Calendar date = Calendar.getInstance();  
	     TodayName = dayNames[date.get(Calendar.DAY_OF_WEEK)];
	     System.out.println("Today is "+ dayNames[date.get(Calendar.DAY_OF_WEEK)]);   
	          }  
	
//	Excel Connect:
	
	@SuppressWarnings("resource")
	  public void Exel() throws IOException {
		
	    getDate();
	      try {
	      String File = ".\\src\\Excel.xlsx";
	      FileInputStream file = new FileInputStream(File);
	      XSSFWorkbook workbook = new XSSFWorkbook(file);
	      XSSFSheet sheet = workbook.getSheet(TodayName);
	      System.out.println("Connected for Outpur");
	      int rows=sheet.getLastRowNum()+1;
	
	      
	    
	     
	      for(int r=2;r<rows;r++) {
	        XSSFRow row = sheet.getRow(r);
	        XSSFCell cell = row.getCell(2);
	        Search(cell.getStringCellValue());

	      }
	      
	       
	      }
	      catch(Exception e) {
	      System.out.println(e);
	      }
	    }

	
	

	 @FindBys({
			@FindBy(xpath="//textarea[@id='APjFqb']"),
		
		})
		WebElement SearchBox;
	 

	 @FindBys({
			@FindBy(xpath="//li[@class='sbct sbre']//div[@class='wM6W7d']/span"),
		
		})
    	List<WebElement> Text;
	
	 

	
	 public void Search(String Text) {
			
			
		 try {
			 if(SearchBox.isEnabled()) {	
				 SearchBox.click();
				 SearchBox.sendKeys(Text);
				 timeout();
				 SearchResult();
				 timeout();
				 SearchBox.clear();
				 timeout();
				 
			 }
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		 
	 }
	 
	
	 
	 public void SearchResult() throws IOException   {
		 
		 int total = Text.size();
		 ArrayList<String> SearchTxt = new ArrayList<String>(); 
		 for(int i=0;i<total;i++) 
		 {
			 String texts=Text.get(i).getText(); 
			 SearchTxt.add(texts);
		
		}
		   String max = Collections.max(SearchTxt); 
		   String min = Collections.min(SearchTxt);
		   
		  
		   
		   getData(min,max);
		  
		}
	

	
	 

}

