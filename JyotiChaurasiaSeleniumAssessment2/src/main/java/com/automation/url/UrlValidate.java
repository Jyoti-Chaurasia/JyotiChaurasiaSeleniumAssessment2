package com.automation.url;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.DriverManager;
import com.automation.utils.ApplicationWrappers;

public class UrlValidate {
	
	private WebDriver driver;

	public UrlValidate() {
		 driver = DriverManager.getDriver();
	}
	
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	public List<WebElement> extractingUrlLinks() {
		List<WebElement> urlList= driver.findElements(By.xpath("//a"));
		return urlList;
	}
}

