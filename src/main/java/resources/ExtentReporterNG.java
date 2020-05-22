package resources;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {

	private ExtentReports extent;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		extent = new ExtentReports(outputDirectory = File.separator + "ExtentReportsNG");

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getFailedTests(), LogStatus.PASS);
				buildTestNodes(context.getSkippedTests(), LogStatus.FAIL);
				buildTestNodes(context.getPassedTests(), LogStatus.SKIP);

			}

		}

		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap failedTests, LogStatus pass) {
	}
	// private void buildTestNodes(IResultMap skippedTests, LogStatus fail) {}
	// private void buildTestNodes(IResultMap passedTests, LogStatus skip) {}
}