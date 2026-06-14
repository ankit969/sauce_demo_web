package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import enums.BrowserType;
import enums.ExecutionType;

public final class DriverFactory {
	
	private DriverFactory() {}
	
	public static void initDriver() {
		String browserName = ConfigReader.getProperty("browser").toUpperCase();
		String executionName = ConfigReader.getProperty("execution").toUpperCase();
		
		BrowserType browserType = BrowserType.valueOf(browserName);
		ExecutionType executionType = ExecutionType.valueOf(executionName);
		
		WebDriver driver;
		
		switch (executionType) {
		case LOCAL:
			driver = LocalDriverFactory.createLocalDriver(browserType);
			break;
			
		case REMOTE:
			driver = RemoteDriverFactory.createRemoteDriver(browserType);

		default:
			throw new IllegalArgumentException("Unsupported execution type: "+executionType);
		}
		
		DriverManager.setDriver(driver);
		applyCommonSettings();
	}
	
	private static void applyCommonSettings() {
		WebDriver driver = DriverManager.getDriver();
		
		int pageLoadTimeout = Integer.parseInt(ConfigReader.getProperty("pageLoadTimeout"));
		int scriptTimeout = Integer.parseInt(ConfigReader.getProperty("scriptTimeout"));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeout));
		
		driver.manage().window().maximize();
	}

}
