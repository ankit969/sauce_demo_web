package pages;

import org.openqa.selenium.WebDriver;
import config.ConfigReader;
import driver.DriverManager;
import utils.BasicActionsUtils;
import utils.WaitUtils;


public abstract class BasePage {
	
	protected final WebDriver driver;
	protected final WaitUtils wait;
	protected final BasicActionsUtils basicActionsUtils;
	
	
	protected BasePage() {
		this.driver = DriverManager.getDriver();
		int explicitWait = Integer.parseInt(ConfigReader.getProperty("explicitWait"));
		this.wait = new WaitUtils(driver, explicitWait);
		this.basicActionsUtils = new BasicActionsUtils(driver, wait);
	}

}
