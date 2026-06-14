package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigReader {
	
	private static final Logger log = LogManager.getLogger(ConfigReader.class);
	private static final Properties prop = new Properties();
	
	static {
		try(InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")){
			if(inputStream == null) {
				throw new RuntimeException("config.properties file not found");
			}
			prop.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties file", e);
		}
	}
	
	private ConfigReader() {}

	public static String getProperty(String key) {
		String value = prop.getProperty(key);
		
		if(value == null || value.trim().isEmpty()) {
			throw new RuntimeException("Property" + key + "not found or empty in config.properties file");
		}
		return value;
	}
	
	

}
