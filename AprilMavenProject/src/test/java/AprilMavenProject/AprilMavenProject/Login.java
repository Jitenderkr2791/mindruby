package AprilMavenProject.AprilMavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import base.AprilMavenProject.Driver;

public class Login {
	
	static WebDriver driver ;
	
	@BeforeClass
	public static void setup() 
	{
		
	driver = Driver.getDriver("chrome");
	driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public static void login()
	{
	    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		String expected_Title = "OrangeHRM";
		
		/*
		 * if(actual_title.equals(expected_Title) ) {
		 * System.out.println("title gets matched " + " \nActual Title :" +
		 * actual_title); } else {System.out.println("title won't matched");}
		 */
		
		 Assert.assertEquals(actual_title, expected_Title,"title not matched");
		 System.out.println("Assertion Passed: Titles match!");
	}
	
	 @AfterClass
	    public void quitDriver()
	 {
	        Driver.quitDriver();
	    }
}
