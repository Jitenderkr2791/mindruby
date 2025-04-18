package AprilMavenProject.AprilMavenProject;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.AprilMavenProject.Driver;

public class checkboxes {

	WebDriver driver;
	@BeforeClass()
	public void driverstart()
	{
		driver = Driver.getDriver("chrome");
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority = 1)
	public void Selectcheckboxes() throws Throwable
	{ 
	   System.out.println("=================Approach 1====================================");
	   List <WebElement>checkboxes = driver.findElements(By.xpath("//label[text()='Days:']/following-sibling::div//input[@type='checkbox']"));
	   for(WebElement days:checkboxes) 
	   {
		days.click();   
	   }
	   Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void Selectcheckboxes2() throws Throwable
	{ 
	   System.out.println("=================Approach 2====================================");
	   List <WebElement>checkboxes = driver.findElements(By.xpath("//label[text()='Days:']/following-sibling::div//input[@type='checkbox']"));
	   for(int i=0;i<checkboxes.size();i++)
	   {
		 checkboxes.get(i).click();   
	   }
	   Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void Selectcheckboxes3() throws Throwable
	{  
	   System.out.println("=================Approach3 : only last 3 checkboxes need to select = 7-3 = 4 ====================================");
	   List <WebElement>checkboxes = driver.findElements(By.xpath("//label[text()='Days:']/following-sibling::div//input[@type='checkbox']"));
	   for(int i=4;i<checkboxes.size();i++)
	   {
		 checkboxes.get(i).click(); 
		 Thread.sleep(5000);
		 checkboxes.get(i).click();
	   }
	   Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void Selectcheckboxes4() throws Throwable
	{  
	   System.out.println("=================Approach : only first 3 checkboxes need to select  ====================================");
	   List <WebElement>checkboxes = driver.findElements(By.xpath("//label[text()='Days:']/following-sibling::div//input[@type='checkbox']"));
	   for(int i=0;i<3;i++)
	   {
		 checkboxes.get(i).click();   
	   }
	   Thread.sleep(5000);
	}
	
	@Test(priority = 5)
	public void Selectcheckboxes5() throws Throwable
	{  
	   System.out.println("=================Approach : uncheck only selected checkboxes which was previously selected  ====================================");
	   List <WebElement>checkboxes = driver.findElements(By.xpath("//label[text()='Days:']/following-sibling::div//input[@type='checkbox']"));
	   for(int i=0;i<3;i++)
	   {
		 if(checkboxes.get(i).isSelected())
		 { 	checkboxes.get(i).click();    }
	}
	   }
	
	@AfterClass()
	public void closeDriver()
	{
		Driver.quitDriver();
	}
}
