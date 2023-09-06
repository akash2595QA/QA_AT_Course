package ExtentReport.ExtentReport;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportMultiplereports {

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports(); //Extent report Engine
		
		//There are 4 types of Extent Reporters which are also called destinations where our our
		//entire report is printed in its respective format -> one of it is ExtentSparkReporter
		File file = new File("extent-report_all.html");
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter(file);
		
		//Report for only failed test cases
		ExtentSparkReporter sparkReporter_failed = new ExtentSparkReporter("extent-report_failed.html");
		sparkReporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
		//Reports only for skipped and warning test cases
		ExtentSparkReporter sparkReporter_skipnWarn = new ExtentSparkReporter("extent-report_skipnWarn.html");
		sparkReporter_skipnWarn.filter()
			.statusFilter()
			.as(new Status[] {Status.SKIP,Status.WARNING}).apply();
		
		extent.attachReporter(sparkReporter_all, sparkReporter_failed, sparkReporter_skipnWarn); 
		
		extent.createTest("Test 1").pass("This test passed");
		extent.createTest("Test 2").log(Status.FAIL, "This test fails");
		extent.createTest("Test 3").skip("skip this test");
		extent.createTest("Test 3").warning("This is warning message");
		
		//It is mandatory to call the flush method to ensure
		//information is written to the started reporters.
		
		extent.flush(); //Use this at the end after recording all the cases
		
		Desktop.getDesktop().browse(new File("extent-report_all.html").toURI());
		Desktop.getDesktop().browse(new File("extent-report_failed.html").toURI());
		Desktop.getDesktop().browse(new File("extent-report_skipnWarn.html").toURI());
	}

}
