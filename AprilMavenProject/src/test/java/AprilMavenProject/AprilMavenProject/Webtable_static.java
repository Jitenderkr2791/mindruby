package AprilMavenProject.AprilMavenProject;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.AprilMavenProject.Driver;

public class Webtable_static 
{
	WebDriver driver ;
	
	@BeforeClass()
	public void  startdriver()
	{
	driver=Driver.getDriver("chrome");
	driver.get("https://testautomationpractice.blogspot.com/");
	
	}
	
	@Test(priority = 1)
	public void staticwebtable()
	
	{	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("=================No. of rows ==================");
		List<WebElement> rows =driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println(rows.size());
		for(WebElement r:rows)
		{	
			System.out.println(r.getText());
		}
		
		System.out.println("=================No. of columns===========");
		List<WebElement> columns =driver.findElements(By.xpath("//table[@name='BookTable']//tr/th"));
		System.out.println(columns.size());
		for(WebElement c:columns)
		{
			System.out.println(c.getText());
		}
		
		System.out.println("=================specific components===========");
		WebElement ele1=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]"));
		System.out.println(ele1.getText());
	}
	
	@Test (priority = 2)
	public void staticWebtable2()
	{
		System.out.println("==============print complete table via for loop===============");
		List<WebElement> rows =driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		List<WebElement> columns =driver.findElements(By.xpath("//table[@name='BookTable']//tr/th"));
		for(int r=2;r<=rows.size();r++)
		{ for(int c=1;c<=columns.size();c++)
		   { WebElement ele1 =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]"));
		   		System.out.print("\t" + ele1.getText());
		  }
		 System.out.println(); 	
		}
	}
	@Test(priority = 3)
	public void staticWebtable3() {
	    System.out.println("============== Print Complete Table for each loop ==============");
	    WebElement table = driver.findElement(By.xpath("//table[@name='BookTable']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    for (WebElement row : rows) 
	    {
	        List<WebElement> cells = row.findElements(By.tagName("th")); // for headers
	        if (cells.isEmpty())
	        {
	            cells = row.findElements(By.tagName("td")); // for data rows
	        }
	        for (WebElement cell : cells) {
	            System.out.print("\t" + cell.getText());
	        }
	        System.out.println();
	    }
	}
	@Test(priority = 4)
	public void staticWebtable4() {
	    System.out.println("============== Print book name whose author is mukesh ==============");
	    List<WebElement> rows =driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
	    for (int r=2 ; r<=rows.size();r++) 
	    { 	String author_name =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
	    	if(author_name.equals("Mukesh"))
	    	{
	    		String bookname =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
	    		System.out.println(bookname +"  " +author_name );
	    		
	    	}	 
	    }    	    
	}
	@Test( priority = 5,  description = "find total price of all books")
	public void staticWebtable5() {
		int total = 0;
	    System.out.println("============== find total price of all books ==============");
	    List<WebElement> rows =driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
	    for (int r=2 ; r<=rows.size();r++)
	    {	String bookname =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
	     	String price =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
	     	System.out.println(bookname+ " " +price );
	     	total = total + Integer.parseInt(price);
	     	
	    	}	 
	    System.out.println(total);
	    }    
	
	@AfterClass()
	public void closedriver()
	{
		Driver.quitDriver();
	}
}
