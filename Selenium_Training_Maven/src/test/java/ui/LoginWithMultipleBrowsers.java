package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithMultipleBrowsers 
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
		
		driver.get("https://www.salesforce.com/au/");
		
		//adding wait time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/hgf-c360nav//header/div/div[1]/nav[2]/div/hgf-button")));
			
		/*
		 * driver.findElement(By.name("username")).sendKeys("Admin");
		 * driver.findElement(By.name("password")).sendKeys("admin123");
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).
		 * click(); driver.close();
		 */

		driver.manage().window().maximize();
		
	    driver.findElement(By.xpath("/html/body/div[2]/hgf-c360nav//header/div/div[1]/nav[2]/div/hgf-button")).click();
	}
}
