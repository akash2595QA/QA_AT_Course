package selenium;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateFacebookAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("firstname")).sendKeys("Akash");
		driver.findElement(By.name("lastname")).sendKeys("Akash");
		driver.findElement(By.name("reg_email__")).sendKeys("skywalker@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("skywalker@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("skywalker@1234");
		
		WebElement ddown_day = driver.findElement(By.name("birthday_day"));
		Select select = new Select(ddown_day);
		select.selectByVisibleText("25");	
		WebElement ddown_month = driver.findElement(By.name("birthday_month"));
		Select select1 = new Select(ddown_month);
		select1.selectByIndex(6);		
		WebElement ddown_year = driver.findElement(By.name("birthday_year"));
		Select select2 = new Select(ddown_year);
		select2.selectByVisibleText("1995");
		
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/label")).click();  //Radio button male
		driver.findElement(By.xpath("//button[@name='websubmit']")).click(); //clicking on Signup button			
	}
}
