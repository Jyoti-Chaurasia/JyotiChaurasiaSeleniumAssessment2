package com.automation.stepdefinitions;
import configurationProperties.ConfigureProperties;
import excelfile.ExcelReader;
import io.cucumber.java.en.Given;

public class ExcelFile {
	private ConfigureProperties config = new ConfigureProperties();	
	ExcelReader reader = new ExcelReader(config.getProperty("excelDir")+"product_inventory.xlsx");
	@Given("I read data from Excel sheet")
    public void readExcelData() {
        reader.readCompleteExcel("Sheet1");
    }
}
