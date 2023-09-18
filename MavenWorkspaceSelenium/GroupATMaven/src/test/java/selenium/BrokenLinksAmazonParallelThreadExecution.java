package selenium;

//import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;

public class BrokenLinksAmazonParallelThreadExecution {
	
	@Test
	public void test_brokenLinks() throws InterruptedException, MalformedURLException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(3000);
		
		List <WebElement> elements = driver.findElements(By.tagName("a"));
		System.out.println(elements);
		
		List<String> urlArray = new ArrayList<>();
		
		for(WebElement ele: elements)
		{
			String url = ele.getAttribute("href");
			//verifyLink(url);
			
			urlArray.add(url);
		}	
		
		
/*			urlArray.parallelStream().forEach(e -> {
				try {
					verifyLink(e);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			});
			System.out.println(urlArray.size()); */
	}
	public void verifyLink(String url) throws MalformedURLException
	{
		URL link = new URL(url);
		try {
			HttpURLConnection httpURLconnect = (HttpURLConnection)link.openConnection(); //open connection
			httpURLconnect.setConnectTimeout(5000);//set timeout
			httpURLconnect.connect();
			if (httpURLconnect.getResponseCode() >= 400)
			{
				System.out.println(url+" - "+httpURLconnect.getResponseMessage()+" is a broken link");
				System.out.println("broken link");
			}
			else
				System.out.println(url+" - "+httpURLconnect.getResponseMessage());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
