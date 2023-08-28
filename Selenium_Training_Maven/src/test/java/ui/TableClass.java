package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Akash/Assignments/AT%20notes/class%20notes/WebTable.html");
		Thread.sleep(5000);
		
		String cellText = driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")).getText();
		System.out.println("The selected cell contains "+cellText);
		
	}

}
