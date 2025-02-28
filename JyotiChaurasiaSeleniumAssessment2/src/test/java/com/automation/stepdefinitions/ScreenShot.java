package com.automation.stepdefinitions;

import com.automation.screen.*;

import io.cucumber.java.en.Given;

public class ScreenShot {
	Screenshot ss= new Screenshot();
	
	@Given("Screenshot current page")
	public void current_page() {
	    ss.takeScreenshot();
	}

}
