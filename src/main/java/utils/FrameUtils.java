package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class FrameUtils {
	
	private static final Logger log = LogManager.getLogger(FrameUtils.class);
	private final WebDriver driver;
	private final WaitUtils wait;
	
	public FrameUtils(WebDriver driver, WaitUtils wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void switchToFrame(By locator) {
		log.info("Switching to frame: {}", locator);
		driver.switchTo().frame(wait.waitForVisibility(locator));
	}
	
	public void switchToDefaultContent() {
		log.info("Switching to default content");
		driver.switchTo().defaultContent();
	}

}
