package com.itstep.automationpractice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private static WebDriver driver;
    private final ChromeOptions chromeOptions = new ChromeOptions();

    private Browser() {
        driver = DriverFactory.createDriver();
    }

    public static WebDriver getBrowser() {
        if (driver == null) {
            new Browser();
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
