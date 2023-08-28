package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import org.testng.asserts.SoftAssert;

public class AssertExample2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		
	//	WebDriverWait wait = new WebDriverWait(driver);
		
	//	driver.switchTo().frame("login_page");
	//	driver.findElement(By.linkText("CONTINUE")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		driver.switchTo().defaultContent();
		
		System.out.println("The actual text in alert window is: "+actualText);
		
		String expectedText = "Customer ID  cannot be left blank.";
		
		Assert.assertEquals("Actual and expected are not matching", expectedText, actualText);
	//	SoftAssert sft = new SoftAssert();
		
		
		
		
		
		
		

	}

}
