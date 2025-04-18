package AprilMavenProject.AprilMavenProject;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import base.AprilMavenProject.Driver;
import base.AprilMavenProject.login;
public class webtable_dynamic 
{
	WebDriver driver ;	
	login loginPage;
		
@BeforeMethod()
	public void  startDriver()
		{
	driver =Driver.getDriver("chrome");
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	loginPage = new login(driver); 
		}
		
@Test()
public void dynamic_Table() throws Throwable
{	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	loginPage.enterusername("Admin").enterpassword("admin123").submitButtonClick().pimClick();
	Thread.sleep(5000);
	
	/*
	 * String s =" (189) Records Found"; //(189) Records Found String text =
	 * driver.findElement(By.xpath("//span[text()=' (189) Records Found']")).getText
	 * (); int Totalrecords
	 * =Integer.parseInt(text.substring(text.indexOf("(")+1),text.indexOf(")")-1);
	 */			
			
	List<WebElement> pages = driver.findElements(By.xpath("//ul[@class='oxd-pagination__ul']/li/button[not(contains(@class, 'previous-next'))]"));	
	System.out.println(pages.size());
	System.out.println("========================================================================");
	
		  for(int i=1;i<=pages.size();i++)
		  {
		  driver.findElement(By.xpath("//ul[@class='oxd-pagination__ul']/li["+i+"]")).click(); 
		  List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
		  System.out.println(rows.size()); }
		  
		  }
		 
	
@AfterMethod()
	public void closeDriver()
	{	Driver.quitDriver(); 
	 }
}
//ul[@class='oxd-pagination__ul']/li/button[text()='1']