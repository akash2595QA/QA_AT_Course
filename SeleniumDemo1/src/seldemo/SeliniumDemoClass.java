package seldemo;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeliniumDemoClass {

	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Browser Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}

}
