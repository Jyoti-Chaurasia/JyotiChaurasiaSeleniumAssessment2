package com.automation.stepdefinitions;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.automation.url.*;
import com.automation.utils.ApplicationWrappers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class UrlValidation {

	UrlValidate url= new UrlValidate();

	@Given("URL current page")
	public void url_current_page() {
		url.navigateTo("http://www.mycontactform.com");
	}

	@Then("extracting urls")
	public List<WebElement> extracting_urls() {
	    return url.extractingUrlLinks();
	}

	@Then("Validating Link")
	public void validating_link() {
		List<WebElement> urlList= extracting_urls();
		 
		 System.out.println("Validating URLs...");
			for (WebElement url : urlList) {
				String href= url.getAttribute("href");
				ApplicationWrappers.validateLink(href);
			}
		System.out.println("All links validated successfully!");
	}
}
