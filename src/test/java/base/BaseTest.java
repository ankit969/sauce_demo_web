package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import pages.LoginPage;

public class BaseTest {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		DriverFactory.initDriver();
		driver = DriverManager.getDriver();
		//driver.get(ConfigReader.getProperty("url"));
		initializePages();
		loginPage.open();
		
		preCondition();
	}
	
	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
	}
	
	protected void initializePages() {
		loginPage = new LoginPage(driver);
	}
	
	protected void preCondition() {
		//Default: do nothing
	}

}
