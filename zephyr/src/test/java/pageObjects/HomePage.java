package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage 
{
	
	  public HomePage(WebDriver driver)
	  { 	
		  super(driver); 
	  }
	 
	//locators
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkregister;
	
	//actions
	public HomePage clickMyAccount() 
	{
		lnkMyAccount.click();
		return this;
	}
	
	public HomePage clickRegister() 
	{
		lnkregister.click();
		return this;
	}
	
}
