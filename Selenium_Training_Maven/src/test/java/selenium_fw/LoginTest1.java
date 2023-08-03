package selenium_fw;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import base.BaseClass;


public class LoginTest1 extends BaseClass {
	@Test
	public static void LoginTestMethod() throws InterruptedException {
			
		System.out.println("Clicked Successflly inside LoginTest class");
		//adding wait time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
			
		driver.findElement(By.name(loc.getProperty("login_username_field"))).sendKeys("Admin");
		driver.findElement(By.name(loc.getProperty("login_pwd_field"))).sendKeys("admin123");
		driver.findElement(By.xpath(loc.getProperty("login_button"))).click();
		Thread.sleep(3000);
		driver.findElement(By.className(loc.getProperty("settings_dropdown"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("logout_button"))).click();
		//driver.close();

	}

}
