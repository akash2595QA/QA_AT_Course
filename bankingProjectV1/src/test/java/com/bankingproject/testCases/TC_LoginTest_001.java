package com.bankingproject.testCases;
import java.io.IOException;
import com.bankingproject.utilities.Log;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.bankingproject.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		//driver.get(baseURL);

		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		Log.info("Entered Username");
		Thread.sleep(3000);
		lp.setPassword(password);
		Log.info("Entered Password");
		lp.clickLogin();
		Log.info("Clicked on Login Button");
		//lp.clickReset();
		
		String expectedTitle = "Guru999 Bank Manager HomePage";
		if (driver.getTitle().equals(expectedTitle))
		{
			Assert.assertTrue(true);
			Log.info("Login Test case passed");
		}
		else
		{
			captureScreen(driver, "loginTest_failed_sc");
			logger.info("ScreenShot Taken");
			Assert.assertTrue(false);
			Log.info("Login Test case failed");
			
		}
	}

}
