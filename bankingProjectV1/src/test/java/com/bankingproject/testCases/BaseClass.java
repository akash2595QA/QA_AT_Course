package com.bankingproject.testCases;

import com.bankingproject.utilities.Log;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;

import com.bankingproject.utilities.*;

public class BaseClass 
{
	ReadConfig readconfig = new ReadConfig();
	public static WebDriver driver;
	public String baseURL = readconfig.getWebURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String br) throws InterruptedException
	{
		
		if(br.equals("chrome"))
		{
			
	//	ChromeOptions opt = new ChromeOptions();	
		//opt.addExtensions(new File("./Extentions/adblock_chrome.crx"));
		System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriverPath());
		//driver = new ChromeDriver(opt);
		driver = new ChromeDriver();
		Log.info("Chrome driver is selected");
		}
		
		if(br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxDriverPath());
		driver = new FirefoxDriver();
		Log.info("Firefox driver is selected");
		}
		
		if(br.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver", readconfig.getEdgeDriverpath());
		driver = new EdgeDriver();
		Log.info("Edge driver is selected");
		}
		
		driver.get(baseURL);
		Log.info("Opened the URL");
		driver.manage().window().maximize();
		Log.info("Maximized the window");
		Thread.sleep(3000);
		
		
	}
	
	
	public void teardown()
	{
		driver.quit();
		Log.info("All windows are shuddowm");
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
