package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotUtils {
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String path = System.getProperty("user.dir") + "/reports/screenshots/" + testName + "_" + timestamp + ".png";
		
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(path);
			dest.getParentFile().mkdirs();
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

}
