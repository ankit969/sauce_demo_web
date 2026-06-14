package bdd.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"bdd.stepdefinitions", "hooks"},
	    plugin = {"pretty", "html:target/cucumber-report.html", "rerun:target/failed_scenarios.txt"}
	)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
