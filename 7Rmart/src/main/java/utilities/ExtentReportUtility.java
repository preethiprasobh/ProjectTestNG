package utilities; // to customize the report, for that include the dependency aventstack

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();
	
	public synchronized static ExtentReports createExtentReports() {
			ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//location in which the report will generate
			reporter.config().setReportName("7RMart");
			extentReports.attachReporter(reporter);
			extentReports.setSystemInfo("Organization", "Obsqura");
			extentReports.setSystemInfo("Name", "Preethi");
			return extentReports;
		}

}
