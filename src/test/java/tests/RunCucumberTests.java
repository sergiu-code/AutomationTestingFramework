package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        stepNotifications = true,
        tags = "@checkProduct",
        features = "src/test/resources/feature",
        glue = {"com.itstep.automationpractice.steps",
                "com.itstep.automationpractice.hooks"})
public class RunCucumberTests {
}

