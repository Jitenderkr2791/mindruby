package AprilMavenProject.AprilMavenProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import base.AprilMavenProject.Driver;
public class LogiIsDisplayed 
{
	static WebDriver driver; 
	
	@BeforeClass
	public static void setup() 
	{
	driver = Driver.getDriver("google");
	driver.get("https://demo.opencart.com/");
	}
	
	@Test
	public static void logoIsDisplayed()
	{
		 boolean logodisplaystatus = driver.findElement(By.xpath("//img[@title ='Your Store']")).isDisplayed();
			/*
			 * WebElement iframeElement = driver.findElement(By.
			 * xpath("//iframe[contains(@src, 'challenges.cloudflare.com')]"));
			 * driver.switchTo().frame(iframeElement);
			 * 
			 * // Execute JavaScript to access Shadow DOM JavascriptExecutor js =
			 * (JavascriptExecutor) driver; WebElement checkbox = (WebElement)
			 * js.executeScript(
			 * "return document.querySelector('iframe').contentWindow.document.querySelector('label.cb-hb input[type=\"checkbox\"]');"
			 * );
			 * 
			 * // Click the checkbox if (checkbox != null) { checkbox.click();
			 * System.out.println("Checkbox clicked successfully!"); } else {
			 * System.out.println("Checkbox not found!"); }
			 * 
			 * // Switch back to main page driver.switchTo().defaultContent();
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 */
		 System.out.println(logodisplaystatus);
	}
	
	 @AfterClass 
	 public void quitdriver()
	 { 
		 Driver.quitDriver();
		 }
	 
}
