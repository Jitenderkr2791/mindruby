package base.AprilMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {

	WebDriver driver ;
	private By usernamefield = By.xpath("//input[@name='username']");
	private By passwordfield = By.xpath("//input[@name='password']");
	private By orangehrm_inc = By.xpath("//a[text()='OrangeHRM, Inc']");
	private By submitbutton = By.xpath("//button[@type='submit']");
	private By pimclick = By.linkText("PIM");

	
	public login(WebDriver driver)
	{
		this.driver=driver;
	}
			
	public login enterusername(String username) 
		{
			driver.findElement(usernamefield).sendKeys(username);
			return this;
		}
	
	public login enterpassword(String password) 
	{
		driver.findElement(passwordfield).sendKeys(password);
		return this;
	}
	
	public login submitButtonClick() 
	{
		driver.findElement(submitbutton).click();
		return this;
	}
	
	public login OrangeHRMClick()
	{
		driver.findElement(orangehrm_inc).click();
		return this;
	}
	
	public login pimClick()
	{
		driver.findElement(pimclick).click();
		return this;
	}
	
}
