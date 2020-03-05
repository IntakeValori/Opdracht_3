package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featurefiles",
        glue={"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

// @TODO: In the future it might be nice to keep a history of the test results. I.e. with a timestamped folder name in CucumberOptions: plugin

public class TestRunner {

}