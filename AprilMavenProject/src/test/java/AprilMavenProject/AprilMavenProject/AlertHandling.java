package AprilMavenProject.AprilMavenProject;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;


public class AlertHandling
{
	WebDriver driver;
	
	@BeforeClass()
	public void startDriver()
	{
		driver = Driver.getDriver("chrome");
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority = 1)
	public void NormalAlert() throws Throwable
	{	System.out.println("======accepting a normal alert=========");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	}
	
	
	@Test(priority = 2)
	public void NormalAlert2()
	{	System.out.println("========get the text entered over the alert before accepting it=============");
		 driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		 Alert myalert = driver.switchTo().alert();
		 System.out.println(myalert.getText());
	    	myalert.accept();
	}
	@Test(priority = 3)
	public void confirmationAlert1() throws Throwable
	{	System.out.println("==========confrimation alert which contains two button (ok and cancel)=========");
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
	
	@Test(priority = 4)
	public void confirmationAlert2() throws Throwable
	{	System.out.println("==========get the text entered over the alert before accepting it/dismiss it=========");
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		Alert confirmationalert = driver.switchTo().alert();
		System.out.println(confirmationalert.getText());
		confirmationalert.dismiss();
		}
	
	@Test(priority = 5)
	public void promptAlert() throws Throwable
	{	System.out.println("==========Prompt alert which contains placeholder to write and two button (ok and cancel)=========");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		Alert promptalert = driver.switchTo().alert();
		promptalert.sendKeys("welcome");
		promptalert.accept();
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		Alert promptalert2 = driver.switchTo().alert();
		promptalert2.sendKeys("welcome");
		promptalert.dismiss();
	}
	
	@Test(priority = 6)
	public void promptAlertWithExplicitWait() throws Throwable
	{	
		System.out.println("==========get the text entered over the alert via im-plemenrting explicit wait and then accepting it=========");
	    WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert myalert = Wait.until(ExpectedConditions.alertIsPresent());
		myalert.sendKeys("welcome");
		myalert.accept();
		}
	
	
	@AfterClass()
	public void closebrowser()
	{
		Driver.quitDriver();
		
	}
}
