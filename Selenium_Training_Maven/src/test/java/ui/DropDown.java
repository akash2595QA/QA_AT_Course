package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown 
{
	
	public static String browser="chrome";
	public static WebDriver driver; 
	
	public static void main(String[] args) throws InterruptedException {
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
			
	/*	String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		driver.manage().window().maximize();
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);  */
		
		//adding wait time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
				
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")));
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/i[@class='oxd-icon bi-chevron-down']")));

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span/i")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li/a[@class='oxd-topbar-body-nav-tab-link']")).click();
		
		
		
		 
		
		
//		Select select = new Select(ddown);
//		
//		select.selectByIndex(0);
		

	//	driver.navigate().to("https://www.google.com");
		
	//	driver.close();

	}
}
