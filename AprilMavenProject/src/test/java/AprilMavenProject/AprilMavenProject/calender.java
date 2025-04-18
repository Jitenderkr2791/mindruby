package AprilMavenProject.AprilMavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;
import base.AprilMavenProject.login;

public class calender {
	WebDriver driver;
	 login loginpage;
	 
	@BeforeClass()
	public void startdriver()
	{
		driver =Driver.getDriver("chrome");
		driver.get("https://testautomationpractice.blogspot.com/");
		loginpage = new login(driver);
	}
	
	public void futuredate(WebDriver driver, String Month, String Year, String date )
	{	
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		while(true)
		{
			String actual_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String actual_Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		
			if((actual_year.equalsIgnoreCase(Year)) && (actual_Month.equalsIgnoreCase(Month)))
				{		break;  	}
			else 	 { driver.findElement(By.xpath("//span[text()='Next']")).click(); }
				  // { driver.findElement(By.xpath("//span[text()='Prev']")).click(); }	
		}
		 
		List <WebElement> actual_date = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
			for(WebElement dt:actual_date)
			{
				if(dt.getText().equalsIgnoreCase(date))
				{	dt.click();
				    break;
				}
			}
	}
	
	public void pastDate(WebDriver driver, String Month, String Year, String date )
	{	
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		while(true)
		{
			String actual_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String actual_Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		
			if((actual_year.equalsIgnoreCase(Year)) && (actual_Month.equalsIgnoreCase(Month)))
				{		break;  	}
			else 	// { driver.findElement(By.xpath("//span[text()='Next']")).click(); }
				  	   { driver.findElement(By.xpath("//span[text()='Prev']")).click(); }
		
		}
		List <WebElement> actual_date = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
			for(WebElement dt:actual_date)
			{
				if(dt.getText().equalsIgnoreCase(date))
				{	dt.click();
				    break;
				}
			}
	}
	
	@Test()
	public void calenderhandle() throws Throwable
		{
			pastDate(driver, "april", "2024", "05");
			Thread.sleep(5000);
			futuredate(driver, "december", "2026","25");
			calender2(driver,"2023","Jul","25");
			
		}
	
	public void calender2 (WebDriver driver, String Year, String Month , String Date ) throws Throwable
	{
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select Yr = new Select(year);
		Yr.selectByVisibleText(Year);
		
		Thread.sleep(5000);
		WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select Mn = new Select(month);
		Mn.selectByVisibleText(Month);
		
		List <WebElement> actual_date = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		for(WebElement dt:actual_date)
		{
			if(dt.getText().equalsIgnoreCase(Date))
			{	dt.click();
			    break;
			}
		}
	}
	
	@AfterMethod()
	public void closedriver()
	{
		Driver.quitDriver();
	}
}
