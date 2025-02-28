package com.automation.image;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.DriverManager;

public class ImageValidate {
	
	private WebDriver driver;

	public ImageValidate() {
		 driver = DriverManager.getDriver();
	}
	
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	public List<WebElement> extractingImageLinks() {
		List<WebElement> imageList= driver.findElements(By.xpath("//img"));
		return imageList;
	}
	
	
}
