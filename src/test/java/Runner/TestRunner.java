package Runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featurefiles", // The path of feature files
        glue={"stepdefinitions"},  // The path of the step definition files
        plugin = {"pretty", "html:target/cucumber-reports.html", "html:test-output", "json: json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
        monochrome = true // Display the console output in a proper readable format
)

public class TestRunner {

}
