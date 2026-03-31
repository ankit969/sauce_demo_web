package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class JSUtils {
	
	private static final Logger log = LogManager.getLogger(JSUtils.class);
	private final WebDriver driver;
	private final WaitUtils wait;
	
	
	public JSUtils(WebDriver driver, WaitUtils wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	protected void scrollToElement(By locator) {
		log.info("Scrolling to element: {}", locator);
		WebElement element = wait.waitForVisibility(locator);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void jsClick(By locator) {
		log.info("Performing JS click on: {}", locator);
		WebElement element = wait.waitForVisibility(locator);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	
	

}
