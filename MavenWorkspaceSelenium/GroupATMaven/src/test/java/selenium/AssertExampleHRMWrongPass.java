package selenium;

//import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;;

public class AssertExampleHRMWrongPass {
	@Test
	public void assertTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//adding explicit wait time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
			
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin13");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		
		SoftAssert sft = new SoftAssert();
		System.out.println(driver.getPageSource().contains("Invalid credentials"));
		if(driver.getPageSource().contains("Invalid credentials")==true)
		{
		
			sft.assertTrue(true);
		}
		else
			sft.assertTrue(false);
		sft.assertAll();
			
	}

}
