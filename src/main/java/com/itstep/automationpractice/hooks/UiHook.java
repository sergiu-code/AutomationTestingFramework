package com.itstep.automationpractice.hooks;

import com.itstep.automationpractice.selenium.Browser;
import com.itstep.automationpractice.utils.ScenarioContext;
import com.itstep.automationpractice.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class UiHook {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before
    public void setupWebDriver() {
        logger.debug("Chrome driver Set UP");
        WebDriver driver = Browser.getBrowser();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Window is maximized");
    }

    @Before
    public void setupReport(Scenario scenario) {
        System.setProperty("cucumber.reporting.config.file", "src/test/resources/cucumber-reporting.properties");
        ScreenshotUtils.setScenario(scenario);
    }

    @Before
    public void createFirstName() {
        String firstName = "Sergiu";
        ScenarioContext.setContext("FirstName", firstName);
    }

    @Before
    public void createLastName() {
        String lastName = "Balan";
        ScenarioContext.setContext("LastName", lastName);
    }

    @Before
    public void createNewEmail() {
        String email = "balansergiu" + System.currentTimeMillis() + "@getnada.com";
        ScenarioContext.setContext("New Email", email);

    }

    @Before
    public void createNewPass() {
        String pass = "sergiubalan" + System.currentTimeMillis();
        ScenarioContext.setContext("New Pass", pass);

    }

    @After(order = 100)
    public void onFail(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.takeScreenshot("onFail");
        }
    }

    @After(order = 1)
    public void tearDown() {
        Browser.quitDriver();
        ScenarioContext.clearContext();
    }
}

