package stepdefinations;
import java.time.Duration;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class HRMLogin {
	
	public static WebDriver driver = new ChromeDriver();

	@Test
	@Given("Browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Assert.assertTrue(true);
	}
	@Given("application is on Login page")
	public void application_is_on_login_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));	
	}
	@When("User enters username and password")
	public void user_enters_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}
	@Then("Homepage is displayed")
	public void homepage_is_displayed() {
		String ActualHomepageUrl = driver.getCurrentUrl();
		System.out.println("The actual homepage url is: "+ActualHomepageUrl);
		String ExpectedHomepageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		System.out.println("The expected homepage url is: "+ExpectedHomepageUrl);
		
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(ActualHomepageUrl, ExpectedHomepageUrl, "Failed test case message is displayed here");
		sft.assertAll();	
	}
	@Then("Logged Out")
	public void logged_out() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.className("oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
	}




}
