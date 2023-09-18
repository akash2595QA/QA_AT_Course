package selenium;

import org.openqa.selenium.chrome.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	//	System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.firefoxdriver().setup();
	
		WebDriver driver = new ChromeDriver();
		System.out.println("reached here1");
		//driver.get("https://www.facebook.com/");

		
		
	}

}
