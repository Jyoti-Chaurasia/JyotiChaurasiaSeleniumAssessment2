package com.automation.utils;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplicationWrappers {
	
		public static void clickElementbyXpath(WebDriver driver, String elementXpath) {
			driver.findElement(By.xpath(elementXpath)).click();
		}
		
		public static void validateLink(String link) {
			int statusCode = getStatusCode(link);
			if(statusCode!=200) {
				System.out.println(link + " is Broken!");
			}
		}

		private static int getStatusCode(String Url) {
		      try {
		            URL url = new URL(Url);
		            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		            connection.setRequestMethod("HEAD");  
		            connection.setConnectTimeout(5000); 
		            connection.setReadTimeout(5000);
		            connection.connect();
		            
		            return connection.getResponseCode();
		        } catch (Exception e) {
		            return 500; 
		        }
		    }
}
