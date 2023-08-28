package stepdefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvaliCredentialInHRM {
	WebDriver driver = new ChromeDriver();
	@Given("Web Browser is open")
	public void web_browser_is_open() {
			System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Given("user is on Login page")
	public void user_is_on_login_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));	
	}

	@When("User enters Wrong username and password")
	public void user_enters_wrong_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}
	@Then("Invalid credential message is displayed")
	public void invalid_credential_message_is_displayed() throws InterruptedException {
		SoftAssert sft = new SoftAssert();
		System.out.println(driver.getPageSource().contains("Invalid credentials"));
		if(driver.getPageSource().contains("Invalid credentials")==true)
		{
		
			sft.assertTrue(true);
		}
		else
			sft.assertTrue(false);
		sft.assertAll();
		Thread.sleep(2000);
		driver.findElement(By.className("oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
	}

}
