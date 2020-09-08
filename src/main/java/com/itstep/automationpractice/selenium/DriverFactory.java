package com.itstep.automationpractice.selenium;

import com.itstep.automationpractice.utils.ResourceBundleReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver createDriver() {

        String browserName = ResourceBundleReader.getResourceBundle().getString("browser");

        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                return new FirefoxDriver();
            case "headless":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.setHeadless(true);
                options.addArguments("window-size=1920,1080");
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("ATF is not configured for" + browserName);
        }
    }
}
