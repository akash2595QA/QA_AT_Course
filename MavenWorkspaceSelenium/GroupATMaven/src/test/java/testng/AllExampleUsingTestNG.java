package testng;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AllExampleUsingTestNG {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");	}
	@Test
	public void assertMethod() throws InterruptedException {
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
	@Test
	public void CreateGmailAccount() throws InterruptedException
	{
		driver.get("https://accounts.google.com/signup/v2/createaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		Thread.sleep(4000);	
		driver.findElement(By.name("firstName")).sendKeys("sky");
		driver.findElement(By.name("lastName")).sendKeys("walker");
		driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']")).click();		
		Thread.sleep(2000);
		WebElement ddown_day = driver.findElement(By.id("month"));
		Select select = new Select(ddown_day);
		select.selectByVisibleText("July");
		driver.findElement(By.name("day")).sendKeys("25");
		driver.findElement(By.name("year")).sendKeys("1995");		
		WebElement ddown_gender = driver.findElement(By.id("gender"));
		Select select1 = new Select(ddown_gender);
		select1.selectByVisibleText("Male");
		driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']")).click();		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"selectionc2\"]")).click();
		driver.findElement(By.xpath("//div/div[1]/input")).sendKeys("skywalker12340y7354");
		driver.findElement(By.xpath("//*[@id=\"next\"]/div/button/span")).click();				
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("skywalker6578");
		driver.findElement(By.xpath("//input[@name='PasswdAgain']")).sendKeys("skywalker6578");
		driver.findElement(By.xpath("//span[@jsname='V67aGc']")).click();		
	}	
	@Test
	public void LoginFacebook() throws InterruptedException
	{
		driver.get("https://www.facebook.com/");
		Thread.sleep(4000);
		driver.findElement(By.name("email")).sendKeys("akkie.2595@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("skywalker");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();	
	}	
	@Test
	public void loginHRM() throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();			
	}	
	@Test
	public void dragNdrop() throws InterruptedException
	{
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Draggable")).click();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions action = new Actions(driver);
		WebElement dragSource = driver.findElement(By.id("draggable"));
		action.dragAndDropBy(dragSource, 50, 80).build().perform();
	}
}
