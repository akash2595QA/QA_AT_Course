package com.bankingproject.testCases;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bankingproject.pageObjects.LoginPage;
import com.bankingproject.utilities.Log;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TC_LoginTestDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginCredData")
	public void loginTestDDT(String uname, String pass) throws InterruptedException, IOException
	{
		//driver.get(baseURL);
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(uname);
		Log.info("Entered Username");
		Thread.sleep(3000);
		lp.setPassword(pass);
		Log.info("Entered Password");
		lp.clickLogin();
		Log.info("Clicked on Login Button");
		//lp.clickReset();
		
		//String expectedTitle = "Guru999 Bank Manager HomePage";
		if (isAlertPresent()==true)
		{
			captureScreen(driver, "loginTest");
			Log.info("Screenshot captured");
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Log.info("Login DDT test case failed");
		}
		else
		{
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			Log.info("Login DDT test case Passed");
		}
	}
	
	private boolean isAlertPresent() {
		// user generated method
		
		try{
		driver.switchTo().alert();
		return true;}
		
		catch(Exception e)
		{
			return false;
		}
		
	}

	@DataProvider(name="LoginCredData")
	public String[][] getData() throws IOException
	{
		String filePath="C:\\Akash\\eclipse-workspace";
		String fileName="guru99_demo_cred.xlsx";
		String sheetName="Sheet1";
		
		File file = new File(filePath+"\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook workbook = null;
	//	String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();
		//System.out.println(rowCount);
			
		Row row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		//System.out.println(colCount);
		String[][] loginCred = new String[rowCount][colCount];
		
		workbook.close();
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				Row row1 = sheet.getRow(i);
				loginCred[i-1][j] = row1.getCell(j).getStringCellValue();
			}
		}
		return loginCred;
				

	}

}
