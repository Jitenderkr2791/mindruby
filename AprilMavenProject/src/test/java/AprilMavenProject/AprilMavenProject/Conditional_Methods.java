package AprilMavenProject.AprilMavenProject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import base.AprilMavenProject.Driver;

public class Conditional_Methods 
{
	static WebDriver driver;
	
	
@BeforeClass()
public static void Driverrun()
{
		driver = Driver.getDriver("chrome");
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
}	


@Test(priority = 1, description = "is Displayed")
	public static void isDisplayed()
	{			WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
			    boolean result = logo.isDisplayed();
				System.out.println("result : " + result);
				System.out.println("logo.isDisplayed() : " +logo.isDisplayed());
	}

@Test(priority = 2, description = "isEnabled Method")
	public static void isEnabled()
	{	boolean status = driver.findElement(By.xpath("//button[text()='Register']")).isEnabled();
			System.out.println("submit button is enabled :" + status);
		}


@Test(priority = 3, description = "isSelected Method")
	public static void isSeleceted()
	{
		WebElement ml_rd =driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement FM_rd =driver.findElement(By.xpath("//input[@id='gender-female']"));
		WebElement NW_ch = driver.findElement(By.xpath("//input[@id='Newsletter']"));
		 
		System.out.println("================before selection=============");
		System.out.println("ml_rd.isSelected() : " +ml_rd.isSelected());
		System.out.println("FM_rd.isSelected() : " +FM_rd.isSelected());
		System.out.println("NW_ch.isSelected() : " +NW_ch.isSelected());
		
		System.out.println("=============after selection male=============");
		ml_rd.click();
		System.out.println("ml_rd.isSelected() : " + ml_rd.isSelected());
		System.out.println("FM_rd.isSelected() : " + FM_rd.isSelected());
		System.out.println("NW_ch.isSelected() : " +NW_ch.isSelected());
		
		System.out.println("=============after selection Female=============");
		FM_rd.click();
		System.out.println("ml_rd.isSelected() : " + ml_rd.isSelected());
		System.out.println("FM_rd.isSelected() : " + FM_rd.isSelected());
		System.out.println("NW_ch.isSelected() : " +NW_ch.isSelected());
		
		System.out.println("=============after deselection Newsletter=============");
		NW_ch.click();
		System.out.println("ml_rd.isSelected() : " + ml_rd.isSelected());
		System.out.println("FM_rd.isSelected() : " + FM_rd.isSelected());
		System.out.println("NW_ch.isSelected() : " + NW_ch.isSelected());
		}

@Test(priority = 4, description = "validation messages")
public static void isDisplayed2() 
{
	driver.findElement(By.xpath("//button[text()='Register']")).click();
	List<WebElement> VD_Message = driver.findElements(By.xpath("//span[contains(@id,'-error')]"));
	for( WebElement messages:VD_Message)
	{
		System.out.println("validation messages are : " +messages.getText());
	}
}

@AfterClass()
	 public static void closeDriver()
	 {	
		Driver.quitDriver();
	 }
	
		
}
