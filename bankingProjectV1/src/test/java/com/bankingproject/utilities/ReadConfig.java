package com.bankingproject.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	public ReadConfig()
	{
		File file = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fs = new FileInputStream(file);
			pro = new Properties();
			pro.load(fs);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String getWebURL()
	{
		return pro.getProperty("baseURL");
	}
	
	public String getUsername()
	{
		return pro.getProperty("username");
	}
	
	public String getPassword()
	{
		return pro.getProperty("password");
	}
	
	public String getChromeDriverPath()
	{
		return pro.getProperty("chromedriver");
	}
	
	public String getFirefoxDriverPath()
	{
		return pro.getProperty("firefoxdriver");
	}
	
	public String getEdgeDriverpath()
	{
		return pro.getProperty("edgedriver");
	}
}
