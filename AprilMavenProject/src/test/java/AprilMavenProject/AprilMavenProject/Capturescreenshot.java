package AprilMavenProject.AprilMavenProject;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;

public class Capturescreenshot 
{
	WebDriver driver;
	
@BeforeMethod
public void startDriver()
	{ driver= Driver.getDriver("chrome");
	
	}
@Test (priority = 1,description = "using (user.dir) and FileUtils.copy(ss, path) method")
public void fullscreenshot1() throws Throwable
	{ 
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)", "");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		//File path = new File("C:\\Users\\Jitender.Kumar\\eclipse-workspace\\AprilMavenProject\\src\\test\\java\\screenshots\\fullpagescreenshot.png");
		File path = new File(System.getProperty("user.dir")+"\\screenshots\\fullpagescreenshot.png");
		//ss.renameTo(path);
		FileUtils.copyFile(ss, path);
	}
@Test(priority = 2, description = "using (full path) and ss.renameto(path) method")
public void fullscreenshot()
{ 
	driver.get("https://testautomationpractice.blogspot.com/");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
	TakesScreenshot ts = (TakesScreenshot)driver;
	File ss = ts.getScreenshotAs(OutputType.FILE);
	File path = new File("C:\\Users\\Jitender.Kumar\\eclipse-workspace\\AprilMavenProject\\src\\test\\java\\screenshots\\fullpagescreenshot.png");
	//File path = new File(System.getProperty("user.dir")+"\\screenshots\\fullpagescreenshot.png");
	ss.renameTo(path);
	//FileUtils.copyFile(ss, path);
}

@Test(priority = 3, description = "specific screenshot and FileUtils.copy(ss, path) method")
public void specificComponentScreenshot() throws Throwable
{
	driver.get("https://testautomationpractice.blogspot.com/");
	WebElement staticWebTable=driver.findElement(By.xpath("//div[@id='HTML1']"));
	TakesScreenshot ts =(TakesScreenshot)driver;
	File ss =staticWebTable.getScreenshotAs(OutputType.FILE);
	File newpath = new File(System.getProperty("user.dir")+ "\\screenshots\\specificscreenshot.png");
	FileUtils.copyFile(ss, newpath);
}
@AfterMethod
public void closeDriver()
	{	Driver.quitDriver(); 	}
}
