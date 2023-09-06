package ExtentReport.ExtentReport;

import java.awt.Desktop;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportScreenShots {
	public static WebDriver driver;

	// This returns path of the screenshot file
	public static String screenShotCapture(String filename) {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File srcFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" + filename);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.getAbsolutePath();
	}

	// This returns Base64 of the screenshot
	public static String screenShotCapture() {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		String base64Code = takeScreenshot.getScreenshotAs(OutputType.BASE64);
		return base64Code;
	}

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports(); // Extent report Engine

		// There are 4 types of Extent Reporters which are also called destinations
		// where our our
		// entire report is printed in its respective format -> one of it is
		// ExtentSparkReporter
		File file = new File("extent-report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

		extent.attachReporter(sparkReporter);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String base64Code = screenShotCapture();
		String scPath = screenShotCapture("7google.jpg");
		driver.quit();
		// Screenshot can be attached at test level and log level
		// 1)screenShot at test level

		extent.createTest("ScreenShot Test 1", "Description: Attach screenshot(base64Code) at test level")
				.info("This is info message").addScreenCaptureFromBase64String(base64Code);

		extent.createTest("ScreenShot Test 2", "Description: Attach screenshot(path) at test level")
				.info("This is info message").addScreenCaptureFromPath(scPath);

		// 2) Screenshot at log level
		extent.createTest("ScreenShot Test 3", "Description: Attach screenshot(base64Code) at log level")
				.info("This is info message")
				.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build());

		extent.createTest("ScreenShot Test 4", "Description: Attach screenshot(path) at log level")
				.info("This is info message").fail(MediaEntityBuilder.createScreenCaptureFromPath(scPath).build());

		// It is mandatory to call the flush method to ensure
		// information is written to the started reporters.

		extent.flush(); // Use this at the end after recording all the cases

		Desktop.getDesktop().browse(new File("extent-report.html").toURI());

	}

}
