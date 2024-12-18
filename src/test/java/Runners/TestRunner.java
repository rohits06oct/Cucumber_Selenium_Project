package Runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "StepDefinitions",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports"
        }
)
public class TestRunner {
}
