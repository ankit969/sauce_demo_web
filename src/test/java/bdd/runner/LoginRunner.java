package bdd.runner;

import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import reporting.ExtentManager;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"bdd.stepdefinitions", "hooks"},
	    tags = "@login",
	    plugin = {"pretty", "html:target/cucumber-report.html"},
	    monochrome = true
	)
public class LoginRunner extends AbstractTestNGCucumberTests{
	
	@AfterSuite
	public void tearDown() {
		ExtentReports extent = ExtentManager.getInstance();
				extent.flush();
	}

}
