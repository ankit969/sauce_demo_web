package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public final class MouseActionsUtils {
	
	private static final Logger log = LogManager.getLogger(MouseActionsUtils.class);
	private final WebDriver driver;
	private final WaitUtils wait;
	private final Actions action;
	
	public MouseActionsUtils(WebDriver driver, WaitUtils wait) {
		this.driver = driver;
		this.wait = wait;
		action = new Actions(driver);
	}
	
	public void hover(By locator) {
		log.info("Hovering over element: {}", locator);
		action.moveToElement(wait.waitForVisibility(locator)).perform();
	}
	
	public void doubleClick(By locator) {
		log.info("Double clicking element: {}", locator);
		action.doubleClick(wait.waitForClickable(locator)).perform();
	}
	
	public void rightClick(By locator) {
		log.info("Right clicking element: {}", locator);
		action.contextClick(wait.waitForClickable(locator)).perform();
	}

}
