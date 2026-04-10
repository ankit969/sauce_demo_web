package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import driver.DriverManager;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener{
	
	private static ExtentReports extent = ExtentManager.getInstance();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		ExtentTestManager.setTest(test);
	}
	
	@Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test Passed");
    }
	
	@Override
	public void onTestFailure(ITestResult result) {

	    int retryCount = result.getMethod().getCurrentInvocationCount();

	    String path = ScreenshotUtils.captureScreenshot(
	            DriverManager.getDriver(),
	            result.getMethod().getMethodName()
	    );

	    ExtentTestManager.getTest()
	        .fail("Test Failed - Retry Count: " + retryCount)
	        .fail(result.getThrowable())
	        .addScreenCaptureFromPath(path);
	}
	
	@Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }

}
