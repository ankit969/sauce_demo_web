package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public final class AlertUtils {
	
	private static final Logger log = LogManager.getLogger(AlertUtils.class);
	private final WebDriver driver;
	
	public AlertUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acceptAlert() {
		log.info("Accepting alert");
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert() {
		log.info("Dismissing alert");
		driver.switchTo().alert().dismiss();
	}
	
	public String getAlertText() {
		log.info("Getting alert text");
		return driver.switchTo().alert().getText();
	}
	

}
