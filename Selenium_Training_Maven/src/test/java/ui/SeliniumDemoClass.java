package ui;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeliniumDemoClass {

	
	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
	//	System.setProperty("webdriver.chrome.driver", "C:\\Browser Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}

}
