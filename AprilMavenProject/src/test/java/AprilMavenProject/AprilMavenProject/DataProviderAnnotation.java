package AprilMavenProject.AprilMavenProject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;
import base.AprilMavenProject.login;

public class DataProviderAnnotation
{
	WebDriver driver;
	login lt;
	
@BeforeMethod()
public void startDriver()
{  driver = Driver.getDriver("chrome");
	 lt = new login(driver);
	}


@DataProvider(name="dp", indices = {0,2})
Object[][] logindata()
	{	
		Object[][] data= {
							{"Admin","admin123"},
							{"admin","Admin123"},
							{"Admin","Admin1234"},
							{"Admin","Admin12"}
						};
		return data;
	}


@Test(priority = 1, dataProvider = "dp")
public void Test(String name, String pass) throws Throwable
{ 	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	lt.enterusername(name).enterpassword(pass).submitButtonClick();
	
	Thread.sleep(5000);
		String actualurl = driver.getCurrentUrl();
	    String expectedurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"; 
		Assert.assertEquals(actualurl, expectedurl);
		 
}



@AfterMethod()
public void closedriver()
	{	Driver.quitDriver(); 
		}
	
} 