package AprilMavenProject.AprilMavenProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;

public class keyboardaction 
{
	WebDriver driver;
@BeforeMethod
	public void startDriver()
	{
		driver = Driver.getDriver("chrome");
		}

//@Test()
	public void slideraction() throws Throwable
	{ 
		driver.get("https://testautomationpractice.blogspot.com/#");
		WebElement min_slider= driver.findElement(By.xpath("//span[@tabindex='0'][1]"));
		WebElement max_slider= driver.findElement(By.xpath("//span[@tabindex='0'][2]"));
		System.out.println("min_slider location (x,y) : " +min_slider.getLocation());
		System.out.println("max_slider location (x,y) : " +max_slider.getLocation());
		Actions act = new Actions(driver);
		act.dragAndDropBy(min_slider,200, 0).perform();
		act.dragAndDropBy(max_slider,-1500,0).perform();
		Thread.sleep(3000);
	}


//	@Test()
public void keyboardactions() throws InterruptedException
{
	driver.get("http://textcompare.com/");
	driver.findElement(By.xpath("//textarea[@name='frm_compare_1']")).sendKeys("my name is jitender");
	Actions act = new Actions(driver);
	
	// ctrl + A (to select all the text)
	act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
	
	//ctrl + c (To copy all the selected text
	act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
	
	//tab to navigate to next tab
	act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
	
	//ctrl + v (to paste the copied text) 
	act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	
	Thread.sleep(5000);
	
	String value2 = driver.findElement(By.xpath("//textarea[@name='frm_compare_2']")).getAttribute("value");
	String value1 =  driver.findElement(By.xpath("//textarea[@name='frm_compare_1']")).getAttribute("value");
	Assert.assertEquals(value1, value2, "does not matched");
	System.out.println(value2);
	System.out.println(value1);
}

@Test()
public void newTabKeyBoardAction() throws Throwable
{
	driver.get("https://www.flipkart.com/");
	
	System.out.println("===========store the original window before clicking==========");
	String winmain = driver.getWindowHandle();
	System.out.println(winmain.toString());
	
	// Open Cart in new tab using Ctrl + Click
	WebElement cart = driver.findElement(By.xpath("//a[@title=\"Cart\"][1]"));
	Actions act = new Actions(driver);
	act.keyDown(Keys.CONTROL).click(cart).keyUp(Keys.CONTROL).perform();
	
	// Get all windows and switch to the new one
	Set<String> windids = driver.getWindowHandles();
	List<String> ids = new ArrayList (windids);
	
	/*
	 * for (String id : ids) { if (!id.equals(winmain)) {
	 * driver.switchTo().window(id); break; } }
	 */
	driver.switchTo().window(ids.get(1));
	
	//explicit wait to fetch the element
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement helpsupport =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Help Center']")));
	 
	//javascript ex
	act.keyDown(Keys.CONTROL).click(helpsupport).keyUp(Keys.CONTROL).perform();
	
	driver.switchTo().window(winmain);
	System.out.println("Switched back to main window.");
}
//@Test
public void newtab_newwindow()
{	driver.get("https://demo.nopcommerce.com/");
	// open new tab and hit the URL
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	//open new window and hit the url
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get("https://testautomationpractice.blogspot.com/");
	
	}

@AfterMethod()
	public void closedriver()
	
	{ Driver.quitDriver();
		}
}
