package AprilMavenProject.AprilMavenProject;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.AprilMavenProject.Driver;

public class Dropdown_Select 
{
	WebDriver driver;
	@BeforeClass()
	public void startDriver()
	{
		driver = Driver.getDriver("google");
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	@Test(priority = 1, description = "select by visible text")
	public void selectByVisibleText()
	{
		WebElement droplements=driver.findElement(By.xpath("//select[@id='country']"));
		System.out.println("=======select by visible text==========");
		Select dropOptions = new Select(droplements);
		dropOptions.selectByVisibleText("United States");
	}
	
	@Test(priority = 2, description = "select by value")
	public void selectByValue()
	{
		WebElement droplements=driver.findElement(By.xpath("//select[@id='country']"));
		System.out.println("=======select by value==========");
		Select dropOptions = new Select(droplements);
		dropOptions.selectByValue("usa");
	}
	
	@Test(priority = 3, description = "select by index")
	public void selectByindex()
	{
		WebElement droplements=driver.findElement(By.xpath("//select[@id='country']"));
		System.out.println("=======select by index==========");
		Select dropOptions = new Select(droplements);
		dropOptions.selectByIndex(2);
	}
	@Test(priority = 4, description = "number of elements via for each loop")
	public void countElementInDropdown()
	{
		System.out.println("==========number of elements via for each loop============");
	List<WebElement> dropoptions = driver.findElements(By.xpath("//select[@id='country']/child::*"));
	System.out.println(dropoptions.size());
	for(WebElement option:dropoptions) 
		{
			System.out.println(option.getText());
		}
	
	}
	
	@Test(priority = 5, description = "number of elements via for loop")
	public void printElementInDropdown()
	{ System.out.println("==========number of elements via for loop============");
	List<WebElement> dropoptions = driver.findElements(By.xpath("//select[@id='country']/child::*"));
	System.out.println(dropoptions.size());
	for(int i=0;i<dropoptions.size();i++)
		{
		System.out.println(dropoptions.get(i).getText());
		}
	
	}
	
	@Test(priority = 6, description = "number of elements via iterator")
	public void printElementInDropdownViaIterator()
	{ System.out.println("==========number of elements via iterator============");
	List<WebElement> dropoptions = driver.findElements(By.xpath("//select[@id='country']/child::*"));
	System.out.println(dropoptions.size());
		Iterator<WebElement> it =dropoptions.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getText());
		}
	
	}
	
	
	@AfterClass()
	public void closedriver()
	{
		Driver.quitDriver();
	}
}
