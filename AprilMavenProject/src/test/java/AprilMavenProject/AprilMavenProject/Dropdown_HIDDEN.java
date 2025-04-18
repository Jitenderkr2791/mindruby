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
import base.AprilMavenProject.login;

public class Dropdown_HIDDEN 
{
	WebDriver driver;
	 login loginpage;
	
	@BeforeClass()
	public void startdriver()
	{
		driver =Driver.getDriver("google");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginpage = new login(driver);
	}
	@Test()
	public void hiddendropdown()
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 loginpage.enterusername("Admin").enterpassword("admin123").submitButtonClick().pimClick();
		 
		 driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div[1]/div[1]")).click();
		 //driver.findElement(By.xpath("//span[text()='Account Assistant']")).click();
		 
		 List<WebElement> dropdownelements= driver.findElements(By.xpath("//div[@role='listbox']//span"));
		 System.out.println(dropdownelements.size());
		 for( WebElement elements:dropdownelements)
		 {
			 System.out.println(elements.getText());
		 }
	}
	
	@AfterClass()
	public void closedriver()
	{
		Driver.quitDriver();
	}
}
