package ExtentReport.ExtentReport;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfigChanges {

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports(); //Extent report Engine
		
		//There are 4 types of Extent Reporters which are also called destinations where our
		//entire report is printed in its respective format -> one of it is ExtentSparkReporter
		
		/*To make changes in the configuration we need to use methods in ExtentSpartReporter Class
		 * - Change the theme(dark or white)
		 * - change the report name
		 * - change the document title
		 * - change date and timestamp
		 * - Apply CSS
		 * - Run the javascript
		 */
		File file = new File("extent-report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Report Name");
		sparkReporter.config().setDocumentTitle("Doc Title");		
		sparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		sparkReporter.config().setCss(".badge-primary{background-color: #d3df65}");
		sparkReporter.config().setJs("document.getElementsByClassName(\"logo\")[0].style.display='none';");
		extent.attachReporter(sparkReporter); 
		
		extent.createTest("Test 1").pass("This test passed");
		extent.createTest("Test 2").log(Status.FAIL, "This test fails");
		extent.createTest("Test 3").skip("skip this test");
		
		//It is mandatory to call the flush method to ensure
		//information is written to the started reporters.
		
		extent.flush(); //Use this at the end after recording all the cases
		
		Desktop.getDesktop().browse(new File("extent-report.html").toURI());
		
	}

}
