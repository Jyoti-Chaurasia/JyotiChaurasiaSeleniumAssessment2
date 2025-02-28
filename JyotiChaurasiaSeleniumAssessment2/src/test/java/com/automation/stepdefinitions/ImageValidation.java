package com.automation.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.automation.image.*;
import com.automation.utils.ApplicationWrappers;

import configurationProperties.ConfigureProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ImageValidation {
	
	ImageValidate image= new ImageValidate();
	private ConfigureProperties config = new ConfigureProperties();	

	 @Given("current Image Validation page")
		public void current_image_validation_page() {
		 image.navigateTo(config.getProperty("URL"));
		}
	 
	 @Then("extracting the Image links")
	 public List<WebElement> extracting_the_image_links() {
		 return image.extractingImageLinks();
	 }

	 @Then("Validating Image Links")
	 public void validating_image_links() {
		 List<WebElement> imageList= extracting_the_image_links();
		 
		 System.out.println("Validating URLs...");
			for (WebElement img : imageList) {
				String src= img.getAttribute("src");
				ApplicationWrappers.validateLink(src);
			}
		System.out.println("All links validated successfully!");
	 }
		
}
