package Qus.automationInternship.tests;


import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Qus.automationInternship.drivers.BaseDriver;
import Qus.automationInternship.drivers.PageDriver;

import Qus.automationInternship.pages.ExcelOutput;
import Qus.automationInternship.pages.GoogleSearch;



public class GoogleSearchTest extends BaseDriver{
@BeforeClass
	 public void openUrl() {
		  PageDriver.getCurrentDriver().manage().window().maximize(); 
		  PageDriver.getCurrentDriver().get(url);   
}

@Test(priority = -1)
public void Exel() throws IOException  {
	GoogleSearch GoogleSearch = new GoogleSearch();
	GoogleSearch.Exel();
}
@Test(priority = 1)
public void ExcelOparetion() throws IOException  {
ExcelOutput ExcelOutput = new ExcelOutput();
ExcelOutput.Senddata();
}

	
}
