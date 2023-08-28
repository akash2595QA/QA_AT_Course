package com.bankingproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer 
{
	WebDriver ldriver;
	public AddNewCustomer(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	WebElement addNewCustBtn;
	
	@FindBy(how = How.NAME, using ="name")
	WebElement txtCustName;
	
	@FindBy(how = How.NAME, using ="rad1")
	WebElement rdCustGen;
	
	@FindBy(how = How.NAME, using ="dob")
	WebElement txtDOB;
	
	@FindBy(how = How.NAME, using ="addr")
	WebElement txtCustAddr;
	
	@FindBy(how = How.NAME, using ="city")
	WebElement txtCustCity;
	
	@FindBy(how = How.NAME, using ="state")
	WebElement txtCustState;
	
	@FindBy(how = How.NAME, using ="pinno")
	WebElement txtCustPin;
	
	@FindBy(how = How.NAME, using ="telephoneno")
	WebElement txtCustMobile;
	
	@FindBy(how = How.NAME, using ="emailid")
	WebElement txtCustEmail;
	
	@FindBy(how = How.NAME, using ="password")
	WebElement txtCustPass;
	
	@FindBy(how = How.NAME, using ="sub")
	WebElement submitBtn;
	
	public void clickAddNewCustBtn()
	{
		addNewCustBtn.click();
	}
	
	public void setCustName(String cname)
	{
		txtCustName.sendKeys(cname);
	}
	
	public void setGenderMale()
	{
		rdCustGen.click();
	}
	
	public void setDOB(String dd, String mm, String yy)
	{
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(yy);
	}
	
	public void setAddress(String addr)
	{
		txtCustAddr.sendKeys(addr);
	}
	
	public void setCity(String city)
	{
		txtCustCity.sendKeys(city);
	}
	
	public void setState(String state)
	{
		txtCustState.sendKeys(state);
	}
	
	public void setPIN(String pin)
	{
		txtCustPin.sendKeys(pin);
	}
	
	public void setTelephone(String tele)
	{
		txtCustMobile.sendKeys(tele);
	}
	
	public void setEmail(String email)
	{
		txtCustEmail.sendKeys(email);
	}
	
	public void setPwd(String pw)
	{
		txtCustPass.sendKeys(pw);
	}
	
	public void clickSubmit()
	{
		submitBtn.click();
	}

}
