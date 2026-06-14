package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class BasicActionsUtils {
	
	private static final Logger log = LogManager.getLogger(BasicActionsUtils.class);
	private final WaitUtils wait;
	
	public BasicActionsUtils(WaitUtils wait) {
		this.wait = wait;
	}
	
	public void click(By locator) {
		log.info("Clicking on element: {}", locator);
		wait.waitForClickable(locator).click();
	}
	
	public void click(By locator, String elementName) {//method overloading-compile time poly-morphism
		log.info("Clicking on element: {}", elementName);
		wait.waitForClickable(locator).click();
	}
	
	public void enter(By locator, String text) {
		log.info("Typing '{}' into element: {}", text, locator);
		WebElement element = wait.waitForVisibility(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public void enter(By locator, String text, String fieldName) {
		log.info("Typing '{}' into element: {}", text, fieldName);
		WebElement element = wait.waitForVisibility(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public String getText(By locator) {
		log.info("Getting text from element: {}", locator);
		return wait.waitForVisibility(locator).getText();
	}
	
	

}
