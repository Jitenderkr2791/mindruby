package AprilMavenProject.AprilMavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;

public class Mouse_hover {
	WebDriver driver;
	
	@BeforeMethod()
	public void wakeupDriver()
	{
		driver = Driver.getDriver("chrome");
	}

	// @Test(priority = 1)
	public  void mouseAction() throws Throwable
	
	{	driver.get("https://demo.nopcommerce.com/");
		WebElement Computers =driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Computers ']"));
		WebElement Desktops = driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//ul[@class='sublist first-level']//a[text()='Desktops ']"));
		
		Actions act = new Actions(driver);
		
		//mouse hover action
		act.moveToElement(Computers).moveToElement(Desktops).build().perform();
		Thread.sleep(3000);
		
		//mouse hover action and click on mac
		//act.moveToElement(Computers).moveToElement(Desktops).click().build().perform();

		//mouse hover action
	//+	act.moveToElement(Computers).moveToElement(Desktops).perform();
	}
	
	//@Test(priority = 2)
	public void hovermouse() throws Throwable
	{
		driver.get("https://testautomationpractice.blogspot.com");
		
		WebElement point= driver.findElement(By.xpath("//button[text()='Point Me']"));
		WebElement mobiles = driver.findElement(By.xpath("//a[text()='Mobiles']"));
		WebElement laptops = driver.findElement(By.xpath("//a[text()='Laptops']"));
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.moveToElement(point).moveToElement(mobiles).build().perform();
		Thread.sleep(3000);
		act.moveToElement(point).moveToElement(laptops).click().perform();
	}
	 
	// @Test(priority = 3)
	public void doubleClick() throws Throwable
	{
		driver.get("https://testautomationpractice.blogspot.com");
       WebElement copylink = driver.findElement(By.xpath("//button[text()='Copy Text']"));
       WebElement Field_1 = driver.findElement(By.xpath("//input[@id='field1']"));
       WebElement Field_2 = driver.findElement(By.xpath("//input[@id='field2']"));
       
       Field_1.clear();
       Field_1.sendKeys("welcome back");
       Field_2.sendKeys("new welcome");
       Thread.sleep(3000);
       Actions act = new Actions(driver);
       act.doubleClick(copylink).perform();
       
       String field1Value = Field_1.getAttribute("value");
       String field2Value = Field_2.getAttribute("value");
       Assert.assertEquals(field1Value, field2Value, "Values do not match after copy.");
       Thread.sleep(3000);
       
       if(field1Value.equals(field2Value))
       { System.out.println("matched");  }
       else { System.out.println("not matched"); }	
       
	}
	
	// @Test(priority = 4)
		public void dragdrop() throws Throwable
		{
			driver.get("https://testautomationpractice.blogspot.com");
			WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
			WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
			Actions act = new Actions(driver);
			act.dragAndDrop(source, target).perform();  
			Thread.sleep(5000);
		
		}
	
	// @Test(priority = 5)
		public void Action_vs_Actions() throws Throwable
		{
			driver.get("https://testautomationpractice.blogspot.com");
			WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
			WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
			Actions act = new Actions(driver);
			Action my_action =act.dragAndDrop(source, target).build(); // building/creating an action and store it into a variable.
			my_action.perform();                                         // we are performing/completing action.
		}	
	 
	 @Test(priority = 6)
	 
		 public void rightclick()
		 {
		 	driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		 	WebElement Rightclick= driver.findElement(By.xpath("//span[text()='right click me']"));
		 	
		 	// rightclick on the button
		 	Actions act = new Actions(driver);
		 	act.contextClick(Rightclick).build().perform();
		 	
		 	//click on the copy element
		 	driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']")).click();
		 	
		 	driver.switchTo().alert().accept();
		 	
		 	

		 
		 }		
	@AfterMethod()
	public void closeDriver()
	{
		Driver.quitDriver();
	}
}
