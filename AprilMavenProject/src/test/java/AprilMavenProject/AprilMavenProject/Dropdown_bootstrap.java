package AprilMavenProject.AprilMavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.AprilMavenProject.Driver;

public class Dropdown_bootstrap {
	WebDriver driver;
	@BeforeClass()
	public void startdriver()
	{
		driver =Driver.getDriver("chrome");
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	@Test(priority = 1)
	public void bootstrapsinglecheckbox() throws Throwable
	{
		driver.findElement(By.xpath("//select[@id='colors']/child::option[@value='blue']")).click();
		Thread.sleep(3000);
	}
	@Test(priority = 2)
	public void bootstrapmultipleselectdropdown() throws Throwable
	{
		 
		List<WebElement>options = driver.findElements(By.xpath("//select[@id='colors']/option"));
		System.out.println(options.size());
		for (WebElement op :options)
		{
			String dropname = op.getText();
			System.out.println(dropname);
			if(dropname.equals("red")||dropname.equals("blue")||dropname.equals("green"))
			{ 
				op.click(); 
				
			}
			Thread.sleep(3000);
		}
	}
	
	@AfterClass()
	public void closedriver()
	{
		Driver.quitDriver();
	}

}
