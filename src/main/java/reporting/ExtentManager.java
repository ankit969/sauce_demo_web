package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			String path = System.getProperty("user.dir") + "/reports/extent-report.html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Automation Report");
			reporter.config().setDocumentTitle("Execution Report");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}

}
