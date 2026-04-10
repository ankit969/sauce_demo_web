package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.ConfigReader;
import utils.WaitUtils;


public abstract class BasePage {
	
	protected final Logger log = LogManager.getLogger(this.getClass());
	protected final WebDriver driver;
	protected final WaitUtils wait;
	
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		int explicitWait = Integer.parseInt(ConfigReader.getProperty("explicitWait"));
		this.wait = new WaitUtils(driver, explicitWait);
	}
	
	protected void click(By locator) {
		wait.waitForClickable(locator).click();
		log.info("Clicked on element: {}", locator);
	}
	
	protected void enter(By locator, String text) {
		WebElement element = wait.waitForVisibility(locator);
		element.clear();
		element.sendKeys(text);
		log.info("Entered '{}' into element: {}", text, locator);
	}
	
	protected String getText(By locator) {
		log.info("Getting text from element: {}", locator);
		return wait.waitForVisibility(locator).getText();
	}
	
	protected boolean isDisplayed(By locator) {
	    try {
	        boolean status = getElement(locator).isDisplayed();
	        log.info("Element displayed status for {}: {}", locator, status);
	        return status;
	    } catch (Exception e) {
	        log.error("Element not displayed: {}", locator);
	        return false;
	    }
	}
	
	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	protected WebElement getElement(By locator) {
	    return wait.waitForVisibility(locator);
	}
	
	protected List<WebElement> getElements(By locator) {
	    List<WebElement> elements = wait.waitForAllVisible(locator);
	    log.info("Found {} elements for locator: {}", elements.size(), locator);
	    return elements;
	}
	

}
