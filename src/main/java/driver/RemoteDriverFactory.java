package driver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import config.ConfigReader;
import enums.BrowserType;

public final class RemoteDriverFactory {
	
	private RemoteDriverFactory() {}
	
	public static WebDriver createRemoteDriver(BrowserType browserType) {
		String remoteUrl = ConfigReader.getProperty("remoteUrl");
		
		try {
			switch (browserType) {
			case CHROME:
				return new RemoteWebDriver(new URL(remoteUrl), DriverOptionsFactory.getChromeOptions());
				
			case FIREFOX:
				return new RemoteWebDriver(new URL(remoteUrl), DriverOptionsFactory.getFirefoxOptions());
				
			case EDGE:
				return new RemoteWebDriver(new URL(remoteUrl), DriverOptionsFactory.getEdgeOptions());

			default:
				throw new IllegalArgumentException("Unsupported remote browser: "+browserType);
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Invalid remote URL in config.properties: "+remoteUrl, e);
		}
	}

}
