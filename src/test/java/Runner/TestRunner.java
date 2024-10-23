package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features", // Path to the feature files
        glue = "StepDefinitions",    // Path to step definition files
       tags = "@RegressionTest",

       plugin = {"pretty",
               "html:target/cucumber-reports/Report.html",
               "html:target/cucumber-reports/Report.html",
               "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
       }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
