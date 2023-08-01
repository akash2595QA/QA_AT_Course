package selenium;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateGmailAccount {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
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
}
