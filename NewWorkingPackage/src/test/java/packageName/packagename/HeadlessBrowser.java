package packageName.packagename;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowser {

	
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String browser ="chrome";
		if(browser.equals("chrome"))
		{	
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			runChromeHeadlessTest();
		}
		
		if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			driver = new FirefoxDriver(options);
			runFirefoxHeadlessTest();
		}
		
	}
	
	static void runChromeHeadlessTest()
	{
		driver.get("https://www.google.com/");
		System.out.println("Chrome Headless Title of the page is "+driver.getTitle());
	}
	static void runFirefoxHeadlessTest()
	{
		driver.get("https://www.google.com/");
		System.out.println("FireFox Headless Title of the page is "+driver.getTitle());
	}
	

	

}
