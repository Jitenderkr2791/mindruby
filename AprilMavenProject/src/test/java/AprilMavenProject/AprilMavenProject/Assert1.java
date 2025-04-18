package AprilMavenProject.AprilMavenProject;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;

public class Assert1 {
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
		Assert.assertTrue(status.isDisplayed());		//boolean Assertion	
	}
	
	
	@Test
	public void test2() 
	{	 
		boolean status = driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed();
		Assert.assertEquals(status, true);		//boolean Assertion		
	}
	
	
	@Test
	public void test3() 
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test
	public void test4() 
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	
	@AfterClass
	public void closeDriver()
	{
		Driver.quitDriver();
	}
}
