package ExtentReport.ExtentReport;
import java.awt.Desktop;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
public class ExtentReportAddSystemAndEnvInfo {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//getCapabilities is in RemoteWebdriver
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		
		ExtentReports extent = new ExtentReports(); //Extent report Engine
		
		//There are 4 types of Extent Reporters which are also called destinations where our our
		//entire report is printed in its respective format -> one of it is ExtentSparkReporter
		File file = new File("extent-report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		//We have to set sys and env info at ExtentReport level i.e. at engine level
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Browser", capabilities.getBrowserName() + capabilities.getBrowserVersion());
		extent.setSystemInfo("User Name", "xyz@gmail.com");
		extent.setSystemInfo("password", "xyz");
		
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
