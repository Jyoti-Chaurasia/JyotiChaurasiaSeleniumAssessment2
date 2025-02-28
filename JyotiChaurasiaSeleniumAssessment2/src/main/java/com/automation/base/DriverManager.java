package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver setDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = new ChromeDriver();  // Create new driver instance
            driver.manage().window().maximize();
            driverThreadLocal.set(driver);  // Store it in ThreadLocal
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();  // Quit WebDriver instance
            driverThreadLocal.remove();  // Remove driver instance from ThreadLocal
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();  // Retrieve WebDriver for the current thread
    }
}
