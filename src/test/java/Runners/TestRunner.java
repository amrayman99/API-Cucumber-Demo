package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "steps", plugin = {"json:target/cucumber.json"})
public class TestRunner {
}
// plugin = {"pretty","html:target/reports/report.html"}