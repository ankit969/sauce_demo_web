package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.BrowserType;

public final class LocalDriverFactory {
	
	private LocalDriverFactory() {}
	
	public static WebDriver createLocalDriver(BrowserType browserType) {
		switch (browserType) {
		case CHROME:
			return new ChromeDriver(DriverOptionsFactory.getChromeOptions());
			
		case FIREFOX:
			return new FirefoxDriver(DriverOptionsFactory.getFirefoxOptions());
			
		case EDGE:
			return new EdgeDriver(DriverOptionsFactory.getEdgeOptions());
			
		default:
			throw new IllegalArgumentException("Unsupported local browser: "+browserType);
		}
	}

}
