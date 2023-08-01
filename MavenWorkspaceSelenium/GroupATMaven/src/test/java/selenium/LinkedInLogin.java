package selenium;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkedInLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.linkedin.com");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"session_key\"]")).sendKeys("akkie.2595@gmail.com");
		driver.findElement(By.name("session_password")).sendKeys("xyz");
		driver.findElement(By.linkText("Sign in")).click();
		
		
	}

}
