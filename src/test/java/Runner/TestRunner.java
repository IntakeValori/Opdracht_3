package Runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featurefiles"
        ,glue={"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
        tags = ""
)

public class TestRunner {

}