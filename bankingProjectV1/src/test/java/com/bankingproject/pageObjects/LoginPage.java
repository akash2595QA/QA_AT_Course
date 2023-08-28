package com.bankingproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name="uid")
	WebElement txUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(name="btnReset")
	WebElement resetBtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logoutBtn;
	
	public void setUserName(String uname)
	{
		txUserName.sendKeys(uname);
	}

	public void setPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	public void clickReset()
	{
		resetBtn.click();
	}
	
	public void clickLogout()
	{
		logoutBtn.click();
	}
}
