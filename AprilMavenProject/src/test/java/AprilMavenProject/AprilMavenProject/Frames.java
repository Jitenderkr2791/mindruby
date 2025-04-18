package AprilMavenProject.AprilMavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;

public class Frames 
{
	WebDriver driver;
	@BeforeClass() 
	public void startdriver()
	{
		driver =Driver.getDriver("chrome");
		driver.get("https://ui.vision/demo/webtest/frames/");
	}
	@Test()
	public void iframeHandling() throws Throwable
	{
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("WELCOME");
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("WELCOME");
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("WELCOME");
		Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@data-value='Hi, I am the UI.Vision IDE']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Web Testing']")).click();
		Thread.sleep(5000);
		
		
		
	}
	
	@AfterClass()
	public void closedriver()
	{
		Driver.quitDriver();
	}
}
