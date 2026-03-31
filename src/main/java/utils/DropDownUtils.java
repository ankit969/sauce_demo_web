package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public final class DropDownUtils {
	
	private static final Logger log = LogManager.getLogger(DropDownUtils.class);
	private final WaitUtils wait;
	
	public DropDownUtils(WaitUtils wait) {
		this.wait = wait;
	}
	
	public void selectByVisibleText(By locator, String text) {
		log.info("Selecting '{}' from dropdown: {}", text, locator);
		Select select = new Select(wait.waitForVisibility(locator));
		select.selectByVisibleText(text);
	}
	
	public void selectByValue(By locator, String value) {
		log.info("Selecting by value '{}' from dropdown: {}", value, locator);
		Select select = new Select(wait.waitForVisibility(locator));
		select.selectByValue(value);
	}

}
