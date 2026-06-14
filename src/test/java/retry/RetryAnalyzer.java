package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	private int count = 0;
    private int maxRetryCount = Integer.parseInt(System.getProperty("retryCount", "1"));

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetryCount) {
            count++;
            return true;
        }
        return false;
    }

}
