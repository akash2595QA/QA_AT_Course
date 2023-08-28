package com.bankingproject.testCases;
import java.io.IOException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.bankingproject.pageObjects.LoginPage;
import com.bankingproject.utilities.Log;
import com.bankingproject.pageObjects.AddNewCustomer;

public class TC_AddNewCust_003 extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		//driver.get(baseURL);
		//logger.info("Website is opened");
		//logger.error("WebSite opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		Log.info("Entered Username");
		Thread.sleep(3000);
		lp.setPassword(password);
		Log.info("Entered Password");
		lp.clickLogin();
		Log.info("Clicked on Login");
		//lp.clickReset();
		Thread.sleep(2000);
		
		AddNewCustomer nc = new AddNewCustomer(driver);
		nc.clickAddNewCustBtn();
		Log.info("Clicked on Add new Customer button");
		Thread.sleep(2000);
		driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/svg")).click();
	//	Thread.sleep(2000);
		nc.setCustName("Akash");
		Log.info("Entered Name");
		nc.setGenderMale();
		Log.info("Selected Gender");
		nc.setDOB("25", "07", "1995");
		Log.info("Entered DOB");
		nc.setAddress("Borivli Maharashtra India");
		Log.info("Entered Address");
		nc.setCity("Mumbai");
		Log.info("Entered City");
		nc.setState("Maharashtra");
		Log.info("Entered State");
		nc.setPIN("400091");
		Log.info("Entered PIN");
		nc.setTelephone("9897487858");
		Log.info("Entered Mobile");
		nc.setEmail(generateRandonString()+"@gmail.com");
		Log.info("Entered mail");
		nc.setPwd("12345678");
		Log.info("Entered password");
		nc.clickSubmit();
		Log.info("Clicked on Submit button");
		Thread.sleep(2000);
		
		
		String expectedText = "Customer Registered Successfully!!!";
		if (driver.getPageSource().contains(expectedText))
		{
		//	captureScreen(driver, "AddNewCustomer");
		//	Log.info("Screenshot taken");
			Assert.assertTrue(true);
			Log.info("Add new Customer Testcase passed");
		}
		else
		{
			captureScreen(driver, "AddNewCustomer");
			Log.info("Screenshot taken");
			Assert.assertTrue(false);
			Log.info("Add new Customer Testcase failed");
		}
	}
	
	public String generateRandonString()
	{
		return RandomStringUtils.randomAlphabetic(8);
	}

}
