package PAGES;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver ;
	private By usernamefield = By.xpath("//input[@name='username']");
	private By passwordfield = By.xpath("//input[@name='password']");
	private By orangehrm_inc = By.xpath("//a[text()='OrangeHRM, Inc']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
			
	public void enterusername(String username) 
		{
			driver.findElement(usernamefield).sendKeys(username);
		}
	
	public void enterpassword(String password) 
	{
		driver.findElement(passwordfield).sendKeys(password);
	}

	public void childwindow()
	{
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
	    Set <String> allwindows =driver.getWindowHandles();
	    
	    List <String>windowid = new ArrayList(allwindows);
	
	    String childwindow = windowid.get(1);
	    driver.switchTo().window(childwindow);	   
	}
	public void parentwindow()
	{
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
	    Set <String> allwindows =driver.getWindowHandles();
	    
	    List <String>windowid = new ArrayList(allwindows);
	
	    String childwindow = windowid.get(0);
	    driver.switchTo().window(childwindow);	   
	}
}

