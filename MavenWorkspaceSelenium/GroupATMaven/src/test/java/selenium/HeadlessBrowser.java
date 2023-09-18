package selenium;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeadlessBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver gdriver = null;

		String browser = "chrome";
		if(browser=="chrome")
		{
			WebDriverManager.chromedriver().setup();
			runHeadlessChrome(gdriver);
			
		}
		else if(browser=="firefox")
		{
			WebDriverManager.firefoxdriver().setup();

			runHeadlessFirefox(gdriver);
		}
		else if(browser=="htmlUnit")
		{
			runHeadlessHtmlUnitBrowser(gdriver);
		}
		
		
		
	}
	
	static void runHeadlessChrome(WebDriver driver)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		System.out.println("Chrome: Title of the page is "+driver.getTitle());
	}
	
	static void runHeadlessFirefox(WebDriver driver)
	{
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless=new");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		System.out.println("FireFox: Title of the page is "+driver.getTitle());
	}
	
	static void runHeadlessHtmlUnitBrowser(WebDriver driver)
	{
		
	}
	

	
}
