package AprilMavenProject.AprilMavenProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import base.AprilMavenProject.Driver;

public class windowhandle 
{
	WebDriver driver;
	
	@BeforeClass
	public void getDriver()
	{
		driver= Driver.getDriver("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	
	}
	@Test(priority = 1)
	public void windowhandle1()
	{
		System.out.println("===========appproach 1=============");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		 Set<String> windowsall =driver.getWindowHandles();
		 
		 List<String> windowsid = new ArrayList<>(windowsall);
		 String parentID = windowsid.get(0);
		 String ChildID = windowsid.get(1);
		 
		 driver.switchTo().window(ChildID);
		 System.out.println(driver.getTitle());
		 
		 driver.switchTo().window(parentID);
		 System.out.println(driver.getTitle());
	}
	
	@Test(priority = 2)
	public void windowHandleApproach()
	{
		System.out.println("=======approach 2==========");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Set<String> windowsall =driver.getWindowHandles();
		for(String win:windowsall) 
		{
		 String Title = driver.switchTo().window(win).getTitle();
		 System.out.println(Title);
		}
	}

	@Test(priority = 3)
	public void childwindow()
	{	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
	    Set <String> allwindows =driver.getWindowHandles();
	    
	    List <String>windowid = new ArrayList<>(allwindows);
	
	    String childwindow = windowid.get(1);
	    driver.switchTo().window(childwindow);	   
	}
	
@AfterClass()
	public void closewindow()
	{    Driver.quitDriver();
		}
}