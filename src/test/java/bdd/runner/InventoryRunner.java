package bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"bdd.stepdefinitions", "hooks"},
	    tags = "@inventory",
	    plugin = {"pretty", "html:target/cucumber-report.html"}
	)
public class InventoryRunner extends AbstractTestNGCucumberTests{

}
