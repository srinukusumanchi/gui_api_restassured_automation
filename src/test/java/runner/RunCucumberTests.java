package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = "steps",
        tags="@regression",
        plugin = {"json:target/cucumber-report.json",
        "html:target/cucumber-report"})              
public class RunCucumberTests{
	
}
