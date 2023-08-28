package selenium;

//import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;;

public class AssertExampleHRM {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//adding explicit wait time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//	FluentWait wait1 = new FluentWait(driver);
		//wait1.withTimeout(Duration.ofSeconds(20));
		//wait1.pollingEvery(Duration.ofSeconds(5));
		
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		String ActualHomepageUrl = driver.getCurrentUrl();
		System.out.println("The actual homepage url is: "+ActualHomepageUrl);
		String ExpectedHomepageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		System.out.println("The expected homepage url is: "+ExpectedHomepageUrl);
		
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(ActualHomepageUrl, ExpectedHomepageUrl, "Failed test case message is displayed here");
		sft.assertAll();	
	}

}
