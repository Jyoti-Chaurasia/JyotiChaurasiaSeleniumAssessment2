package com.automation.login;
//import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

import configurationProperties.ConfigureProperties;

public class LoginTest {
	private LoginPage loginPage;
	private HomePage homePage;
	private ConfigureProperties config;
	private WebDriver driver;
	
	public LoginTest(WebDriver driver) {

		config = new ConfigureProperties();
		this.driver= driver;
	}
	
	public void openLogin() {
		driver.get(config.getProperty("URL"));
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

    public void testValidLogin() throws InterruptedException {

		driver.get(config.getProperty("URL"));
		Thread.sleep(1000);
        loginPage.enterUsername(config.getProperty("validUsername"));
        Thread.sleep(1000);
        loginPage.enterPassword(config.getProperty("validPassword"));
        Thread.sleep(1000);
        loginPage.clickLogin();
        if (homePage.isWelcomeDisplayed()) {
            System.out.println("Test Passed: Welcome message is displayed.");
        } else {
            System.out.println("Test Failed: Welcome message is NOT displayed.");
        }

    }

    public void testInvalidLogin() throws InterruptedException {

		driver.get(config.getProperty("URL"));
		Thread.sleep(1000);
        loginPage.enterUsername(config.getProperty("invalidUsername"));
        Thread.sleep(1000);
        loginPage.enterPassword(config.getProperty("invalidPassword"));
        loginPage.clickLogin();
        String actualMessage = driver.findElement(By.cssSelector("#right_col_top_err")).getText();
        String expectedMessage = "Incorrect login, please try again.";

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Test Passed: Correct error message is displayed.");
        } else {
            System.out.println("Test Failed: Expected error message '" + expectedMessage + "' but got '" + actualMessage + "'.");
        }
 }
}
