package selenium;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigateToEdgeLink {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "C:\\Akash\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		
	}

}
