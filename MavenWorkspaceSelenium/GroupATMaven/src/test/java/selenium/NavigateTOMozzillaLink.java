package selenium;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigateTOMozzillaLink {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Akash\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		
	}

}
