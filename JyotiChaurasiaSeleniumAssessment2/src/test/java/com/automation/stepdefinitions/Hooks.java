package com.automation.stepdefinitions;
import org.openqa.selenium.WebDriver;

import com.automation.base.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	WebDriver driver;
	@Before 
	public void before_all() {
		driver= DriverManager.setDriver();
	}
	
	@After
	public void after_all() {
		DriverManager.quitDriver();
	}
}
