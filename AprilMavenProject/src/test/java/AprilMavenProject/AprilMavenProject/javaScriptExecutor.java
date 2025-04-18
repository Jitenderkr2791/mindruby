package AprilMavenProject.AprilMavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;

public class javaScriptExecutor {
	WebDriver driver;
	@BeforeMethod()
	public void startdriver()
	{
	    driver = Driver.getDriver("chrome");
	}
	
	@Test()
	public void javaScript() throws Throwable
	{
		driver.get("https://testautomationpractice.blogspot.com/#");
	
		// perform sendkeys() action via javascript.
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].setAttribute('value','john')", name);
	    
	    
	    //perform click(). action via javascript
	   WebElement radioBtn = driver.findElement(By.xpath("//label[text()='Male']"));
	   js.executeScript("arguments[0].click()",radioBtn);
	   Thread.sleep(5000); 
	}
	
	@Test(priority =1)
	public void scolldowntillPixel() throws Throwable
	{ 
		driver.get("https://testautomationpractice.blogspot.com/#");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)","");
		System.out.println(js.executeScript("return window.pageYOffset"));
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void scrolldowntoelement() throws Throwable
	{
		driver.get("https://testautomationpractice.blogspot.com/#");
		WebElement ele = driver.findElement(By.xpath("//h4[text()='Mobile Labels']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",ele);
		System.out.println(js.executeScript("return window.pageYOffset"));
		Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void scrollDownTillBottom() throws Throwable
	{
		driver.get("https://testautomationpractice.blogspot.com/#");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));
		Thread.sleep(5000);
	}
	@Test(priority = 4)
	public void ZoomIn50() throws Throwable
	{
		driver.get("https://testautomationpractice.blogspot.com/#");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '50%' ");
		Thread.sleep(5000);
		js.executeScript("document.body.style.zoom = '25%' ");
		Thread.sleep(5000);
	}
	
	@Test(priority = 5)
	public void uploadfile() throws Throwable
	{
		driver.get("https://testautomationpractice.blogspot.com/#");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele =driver.findElement(By.xpath("//input[@id='singleFileInput']"));
		ele.sendKeys("D:\\text1.txt");
		js.executeScript("arguments[0].scrollIntoView()", ele);
		driver.findElement(By.xpath("//button[text()='Upload Single File']")).click();
		String actualtext = driver.findElement(By.xpath("//p[(text()='Single file selected: text1.txt, Size: 5 bytes, Type: text/plain')]")).getText();
		if(actualtext.equalsIgnoreCase("Single file selected: text1.txt, Size: 5 bytes, Type: text/plain"))
		{ System.out.println("file is uploaded successfully ");		}
		else
		{ System.out.println("file is not uploaded successfully");		}
		Thread.sleep(5000);
	}
	
	@Test(priority = 6)
	public void uploadMultiplefile() throws Throwable
	{
		driver.get("https://testautomationpractice.blogspot.com/#");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String file1 ="D:\\text1.txt";
		String file2 ="D:\\text2.txt";
		WebElement ele =driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		js.executeScript("arguments[0].scrollIntoView()", ele);
		ele.sendKeys(file1+"\n"+file2);
		
		driver.findElement(By.xpath("//button[text()='Upload Multiple Files']")).click();
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 //WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("multipleFilesStatus")));
		    WebElement status = driver.findElement(By.id("multipleFilesStatus"));
		    String statusText = status.getText();
		    System.out.println("Upload Status:\n" + statusText);

		    // Validate text
		    Assert.assertTrue(statusText.contains("Multiple files selected"));
		    Assert.assertTrue(statusText.contains("text1.txt"));
		    Assert.assertTrue(statusText.contains("text2.txt"));
		
		
		
		//if(actualtext.equalsIgnoreCase("Single file selected: text1.txt, Size: 5 bytes, Type: text/plain"))
		//{ System.out.println("file is uploaded successfully ");		}
		//else
		//{ System.out.println("file is not uploaded successfully");		}
		Thread.sleep(5000);
	}

	@AfterMethod()
	public void closedriver()
	{
		Driver.quitDriver();
	}
}
