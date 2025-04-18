package WITHOUTPAGEFACTORYAPPROACH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	
		//constructor
		LoginPage(WebDriver driver)
		{
			this.driver = driver;
		}
		
		//locators
		private By username = By.xpath("//input[@placeholder='Username']");
		private	By password = By.xpath("//input[@placeholder='Password']");
		private	By login_btn= By.xpath("//button[normalize-space()='Login']");
		private	By Forgot_your_password= By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
		private	By OrangeHRM_Inc = By.xpath("//a[normalize-space()='OrangeHRM, Inc']");
		private	By company_branding = By.xpath("//img[@alt='company-branding']");


		//actions
		public void setusername(String name)
		 {
			 driver.findElement(username).sendKeys(name);
		 }
		 
		 public void setpassword(String pass)
		 {
			 driver.findElement(password).sendKeys(pass);
		 }
		
		 
		 public void clickLoginBtn()
		 {
			 driver.findElement(login_btn).click();
		 }
		
		 public void forgetPasswordBtn()
		 {
			 driver.findElement(Forgot_your_password).click();
		 }
		
		public void clickOrangeHRM()
		{
			driver.findElement(OrangeHRM_Inc).click();
		}
		















}