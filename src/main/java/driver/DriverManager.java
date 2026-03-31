package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private static final ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();
	
	private DriverManager() {}
	
	public static void setDriver(WebDriver driver) {
		tDriver.set(driver);
	}
	
	public static WebDriver getDriver() {
		WebDriver driver = tDriver.get();
		
		if(driver == null) {
			throw new IllegalStateException("WebDriver is not initialized for current thread");
		}
		
		return driver;
	}
	
	public static void unload() {
		tDriver.remove();
	}
	
	public static void quitDriver() {
		WebDriver driver = tDriver.get();
		
		if(driver != null) {
			driver.quit();
			tDriver.remove();
		}
	}

}
