package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicWebdriverMethods 
{
	
	public static String browser="chrome";
	public static WebDriver driver; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		driver.manage().window().maximize();
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		
		//adding wait time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
			
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		driver.navigate().to("https://www.google.com");
		
		driver.close();

	}
}
