package AprilMavenProject.AprilMavenProject;
import org.testng.annotations.*;
import org.testng.AssertJUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import base.AprilMavenProject.Driver;

 
public class Assert2listeners {
	WebDriver driver;

	@BeforeClass
	public void startDriver() 
	{
	 driver = Driver.getDriver("chrome");
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	
	@Test
	public void test1() 
	{
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		WebElement status = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt=\"company-branding\"]")));
		AssertJUnit.assertTrue(status.isDisplayed());		//boolean Assertion	
	}
	
	
	@Test
	public void test2() 
	{	 
		boolean status = driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed();
		AssertJUnit.assertEquals(status, false);		//boolean Assertion		
	}
	
	
	@Test(dependsOnMethods = "test2")
	public void test3() 
	{
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test
	public void test4() 
	{
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	
	@AfterClass
	public void closeDriver()
	{
		Driver.quitDriver();
	}
}
