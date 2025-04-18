package AprilMavenProject.AprilMavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;

public class Google_auto_Suggestion_option {

	WebDriver driver;

	@BeforeClass()
	public void driverstart() {
		driver = Driver.getDriver("google");
		driver.get("https://www.google.com/");
	}

	@Test(priority = 1)
	public void googlesuggestion() throws Throwable {
		WebElement search = driver.findElement(By.xpath("//textarea[@name='q']"));
		search.sendKeys("selenium");
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		System.out.println(elements.size());
		
		for (WebElement E : elements) 
		{
			Thread.sleep(5000);
			 if(E.getText().equals("selenium rich foods"))
			 {
				 E.click();
			 
			 Thread.sleep(15000);
			 }
			System.out.println(E.getText());
		}
	}

	
	  @Test(priority = 2) 
	  public void googlesuggestion2() throws Throwable
 {
	  WebElement search =driver.findElement(By.xpath("//textarea[@name='q']"));
	  search.sendKeys("selenium"); 
	  List<WebElement>elements = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
	  System.out.println(elements.size()); 
	  for(int i=0; i<elements.size();i++) 
		  {
		  System.out.println(elements.get(i).getText());
		  
		  if(elements.get(i).getText().equals("selenium rich foods")) 
			  {
			  elements.get(i).click(); System.out.println(driver.getTitle()); 
			  }
		  
		  } 
  }
	 

	@AfterClass()
	public void closedriver() {
		Driver.quitDriver();
	}

}
