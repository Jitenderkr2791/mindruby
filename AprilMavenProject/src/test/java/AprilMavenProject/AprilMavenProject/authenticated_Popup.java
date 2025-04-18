package AprilMavenProject.AprilMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.AprilMavenProject.Driver;

public class authenticated_Popup 
{
	WebDriver driver;
	@BeforeClass()
	public void startDriver()
	{
		driver = Driver.getDriver("chrome");
				
	}
	@Test()
	public void authenticatedPopup()
	{
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		boolean title1 = driver.findElement(By.xpath("//p")).isDisplayed();
		System.out.println(title1);
		String Title = driver.findElement(By.xpath("//p")).getText();
		System.out.println(Title);
	}
	
	@AfterClass()
	public void closedriver()
	{
		Driver.quitDriver();
	}
	
}
