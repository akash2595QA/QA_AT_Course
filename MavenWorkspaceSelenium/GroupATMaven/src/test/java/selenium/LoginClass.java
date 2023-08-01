package selenium;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(4000);
		driver.findElement(By.name("email")).sendKeys("akkie.2595@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("skywalker");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		
	}

}
