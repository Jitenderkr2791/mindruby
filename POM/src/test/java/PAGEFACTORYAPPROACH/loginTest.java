package PAGEFACTORYAPPROACH;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class loginTest
{
	WebDriver driver;
	
	@BeforeClass
	public void startdriver()
	{
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test
	public void test1()
	{
		Loginpage Lp = new Loginpage(driver);
		Lp.setusername("Admin");
		Lp.setpassword("admin123");
		Lp.clickLoginBtn();
		@Nullable
		String title = driver.getTitle();
		
		Assert.assertEquals(title,"OrangeHRM");	
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
