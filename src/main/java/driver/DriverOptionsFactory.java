package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import config.ConfigReader;

public final class DriverOptionsFactory {
	
	private DriverOptionsFactory() {}
	
	public static ChromeOptions getChromeOptions() {
		ChromeOptions option = new ChromeOptions();
		
		if(Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
			option.addArguments("--headless=new");
		}
		
		option.addArguments("--start-maximized");
		option.addArguments("--disable-notifications");
		option.addArguments("--remote-allow-origins=*");
		
		return option;
	}
	
	public static FirefoxOptions getFirefoxOptions() {
		FirefoxOptions option = new FirefoxOptions();
		
		if(Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
			option.addArguments("-headless");
		}
		
		return option;
	}
	
	public static EdgeOptions getEdgeOptions() {
		EdgeOptions option = new EdgeOptions();
		
		if(Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
			option.addArguments("--headless=new");
		}
		
		option.addArguments("--start-maximized");
		option.addArguments("--disable-notifications");
		
		return option;
	}

}
