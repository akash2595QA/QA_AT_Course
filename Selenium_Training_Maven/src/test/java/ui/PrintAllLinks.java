package ui;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllLinks 
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
		
		//adding wait time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks);
		System.out.println("Total Tags are "+allLinks.size());
		
		for(int i=0; i < allLinks.size(); i++)
		{
			System.out.println(allLinks.get(i).getAttribute("href"));
			System.out.println(allLinks.get(i).getText());
			System.out.println();
		}
			
		/*
		 * driver.findElement(By.name("username")).sendKeys("Admin");
		 * driver.findElement(By.name("password")).sendKeys("admin123");
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).
		 * click(); driver.close();
		 */
	}
}
