package ExtentReport.ExtentReport;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportBasics {

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports(); //Extent report Engine		
		
		//There are 4 types of Extent Reporters which are also called destinations where our our
		//entire report is printed in its respective format -> one of it is ExtentSparkReporter
		File file = new File("extent-report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReporter); 
		
		extent.createTest("Test 1").pass("This test passed");
		extent.createTest("Test 2").log(Status.FAIL, "This test fails");
		extent.createTest("Test 3").warning("skip this test");
		
		//It is mandatory to call the flush method to ensure
		//information is written to the started reporters.
		
		extent.flush(); //Use this at the end after recording all the cases
		
		Desktop.getDesktop().browse(new File("extent-report.html").toURI());
		
	}

}
