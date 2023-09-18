package packageName.packagename;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFilesUsingSikuli {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("imagesrc")).click();
		

	}

}
