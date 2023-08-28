package selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AssertExample {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login_page")));

		driver.switchTo().frame("login_page");
		driver.findElement(By.linkText("CONTINUE")).click();

		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		driver.switchTo().defaultContent();

		System.out.println("The actual text in alert window is: " + actualText);
		String expectedText = "Customer ID  cannot be left blank.";
		System.out.println("Expected title in the alert window is: " + expectedText);

		SoftAssert sft = new SoftAssert();
		sft.assertEquals(actualText, expectedText, "Test is Failed");
		sft.assertAll();

	}

}
