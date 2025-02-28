package com.automation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;

    // Constructor to initialize elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        usernameField= driver.findElement(By.cssSelector("#user"));
        passwordField= driver.findElement(By.cssSelector("#pass"));
        loginButton= driver.findElement(By.xpath("//*[@id=\"right_col_top\"]/form/div/input"));
    }

    // Actions
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    
}
