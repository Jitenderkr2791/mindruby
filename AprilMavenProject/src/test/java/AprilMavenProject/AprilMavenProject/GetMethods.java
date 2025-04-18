package AprilMavenProject.AprilMavenProject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import base.AprilMavenProject.Driver;
public class GetMethods 
{
	static WebDriver driver ;
	
	@BeforeClass()
	public static void setup()
	{
		driver=Driver.getDriver("google");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	
	}
	
	
	@Test()
	public static void test()
	{
		String Title = driver.getTitle();
		String URL = driver.getCurrentUrl();
		String Page_Source= driver.getPageSource();
		String id = driver.getWindowHandle();
		
		System.out.println("Title : "+ Title + "\n" + "URL : " + URL + "\n" +"id : " +id+  "\n" + "Page_Source : " +Page_Source );
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Set<String>ids = driver.getWindowHandles();
		
		System.out.println("Windows ids : " +ids);
	} 


	@AfterClass()
	public void closeBrowser()
	{
		Driver.quitDriver();
	}
}
 