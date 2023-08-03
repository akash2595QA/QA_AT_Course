package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	// Common statements are written here
	
	public static WebDriver driver;
	public static FileReader fr;
	public static FileReader fr_loc;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	
	@BeforeTest
	public void setup() throws IOException
	{
		System.out.println("path is "+System.getProperty("user.dir"));
		//if (driver == null)
		//{
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configurations\\config.properties");
			//System.out.println(fr);
			fr_loc = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configurations\\locators.properties");
			prop.load(fr);
			loc.load(fr_loc);
		//}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//System.out.println(driver);
			driver.get(prop.getProperty("testurl"));
			System.out.println("Clicked Successflly inside base class");
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("mozilla"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
		}
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		System.out.println("Teardown Successfull");
	}
	
}
