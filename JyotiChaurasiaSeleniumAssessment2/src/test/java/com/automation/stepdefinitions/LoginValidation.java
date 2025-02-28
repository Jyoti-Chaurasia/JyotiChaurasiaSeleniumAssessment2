package com.automation.stepdefinitions;
import org.openqa.selenium.WebDriver;

import com.automation.base.*;
import com.automation.login.LoginTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginValidation {
	
	WebDriver driver= DriverManager.getDriver();
	LoginTest login = new LoginTest(driver);
	
	@Given("Login WebPage")
	public void login_web_page() {
		login.openLogin();
	}

	@Then("I test Valid Login")
	public void i_test_valid_login() {
		try{
		    login.testValidLogin();
			}
			catch (Exception e){
				e.printStackTrace();
			}
	}

	@Then("I test Invalid Login")
	public void i_test_invalid_login() {
		login_web_page();
		try{
		    login.testInvalidLogin();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		driver.close();
	}
}
