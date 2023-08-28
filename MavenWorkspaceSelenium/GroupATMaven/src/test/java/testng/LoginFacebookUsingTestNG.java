package testng;

import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFacebookUsingTestNG {
	WebDriver driver = new ChromeDriver();
	

	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://www.facebook.com/");
	}
	

	@Test
	public void facebookLogin() throws InterruptedException {
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(4000);
		driver.findElement(By.name("email")).sendKeys("akkie.2595@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("skywalker");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();	
	}
	
	@AfterTest
	public void exit()
	{
		driver.close();
	}

}
