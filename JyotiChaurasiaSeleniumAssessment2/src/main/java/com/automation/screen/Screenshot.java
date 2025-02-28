package com.automation.screen;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import configurationProperties.ConfigureProperties;

import com.automation.base.DriverManager;

public class Screenshot {
	private WebDriver driver;
	private ConfigureProperties config = new ConfigureProperties();	 
	
	public Screenshot() {
		 driver = DriverManager.getDriver();
		 driver.get(config.getProperty("URL"));
	}
	
	public void takeScreenshot() {
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinitionFile = new File(config.getProperty("screenshotDir")+ config.getProperty("fileName") + ".png");
		try {
			FileHandler.copy(srcFile, destinitionFile);
			System.out.println("Screen Shot saved: "+destinitionFile.getAbsolutePath());
		}catch(IOException e) {
			System.out.println("Failed to take screenshot");
		}
	}
}
