package utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitUtils {
	
	private static final Logger log = LogManager.getLogger(WaitUtils.class);
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public WaitUtils(WebDriver driver, int timeoutSeconds) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	}
	
	public WebElement waitForVisibility(By locator) {
		log.info("Waiting for visibility: {}", locator);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitForClickable(By locator) {
		log.info("Waiting for clickable: {}", locator);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForPageLoadComplete() {
		log.info("Waiting for page load complete");
		wait.until((Function<WebDriver, Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}
	
	public WebElement fluentWait(By locator, int timeoutSeconds, int pollingSec) {
		log.info("fluent wait for: {}", locator);
		return new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(timeoutSeconds))
				.pollingEvery(Duration.ofSeconds(pollingSec))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
