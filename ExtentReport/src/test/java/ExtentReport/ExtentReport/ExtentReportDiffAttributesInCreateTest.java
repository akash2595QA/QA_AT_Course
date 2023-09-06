package ExtentReport.ExtentReport;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDiffAttributesInCreateTest {

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports(); //Extent report Engine
		
		//There are 4 types of Extent Reporters which are also called destinations where our our
		//entire report is printed in its respective format -> one of it is ExtentSparkReporter
		File file = new File("extent-report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReporter); 
		
		/*
		Different attributes available for a test are
		- Author
		- Category()
		- Device(eg. browser version)
		*/
		extent.createTest("Attribute Test1")
			.assignAuthor("Sky")
			.assignCategory("Smoke")
			.assignDevice("Chrome 99")
			.pass("This test is passed");	
		
		extent.createTest("Attribute Test2")
		.assignAuthor("John")
		.assignCategory("Regression")
		.assignDevice("Edge 99")
		.pass("This test is passed");
		
		//multiple informtion
		extent.createTest("Attribute Test3")
		.assignAuthor("John")
		.assignAuthor("Sky")
		.assignCategory("Regression")
		.assignCategory("Smoke")
		.assignDevice("Edge 99")
		.assignDevice("Chrome99")
		.pass("This test is passed");
		
		//multiple informtion in other way
		extent.createTest("Attribute Test4")
		.assignAuthor("John", "Rebecca", "Aditi")
		.assignCategory("Regression", "Smoke", "Sanity")
		.assignDevice("Edge 99", "Chrome99", "Mozilla 99")
		.pass("This test is passed");
		//It is mandatory to call the flush method to ensure
		//information is written to the started reporters.
		
		extent.flush(); //Use this at the end after recording all the cases	
		Desktop.getDesktop().browse(new File("extent-report.html").toURI());
		
	}

}
