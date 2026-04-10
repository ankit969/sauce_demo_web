package bdd.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.ScreenshotUtils;
import io.cucumber.java.*;

public class Hooks {
	
	WebDriver driver;
	private static ExtentReports extent = ExtentManager.getInstance();
	
	@Before
    public void setUp(Scenario scenario) {
        DriverFactory.initDriver();
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getProperty("url"));

        ExtentTest test = extent.createTest(scenario.getName());
        ExtentTestManager.setTest(test);
    }
	
	@After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            String path = ScreenshotUtils.captureScreenshot(driver, scenario.getName());

            ExtentTestManager.getTest()
                    .fail("Scenario Failed")
                    .addScreenCaptureFromPath(path);
        } else {
            ExtentTestManager.getTest().pass("Scenario Passed");
        }

        DriverManager.quitDriver();
    }
	
	@AfterAll
    public static void flushReport() {
        extent.flush();
    }

}
