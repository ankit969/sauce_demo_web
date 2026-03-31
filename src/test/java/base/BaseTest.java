package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import pages.LoginPage;

public class BaseTest {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	
	@BeforeSuite
	public void setUp() {
		DriverFactory.initDriver();
		driver = DriverManager.getDriver();
		initializePages();
		driver.get(ConfigReader.getProperty("url"));
	}
	
	@AfterSuite
	public void tearDown() {
		DriverManager.quitDriver();
	}
	
	protected void initializePages() {
		loginPage = new LoginPage();
	}

}
