package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    private WebElement welcome;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWelcomeDisplayed() {
        welcome= driver.findElement(By.xpath("//*[@id=\"user_bar\"]/h5"));
        return welcome.isDisplayed();
    }
}

