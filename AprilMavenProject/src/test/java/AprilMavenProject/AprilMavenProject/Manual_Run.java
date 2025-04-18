package AprilMavenProject.AprilMavenProject;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;


public class Manual_Run {
	WebDriver driver;

@BeforeClass
@Parameters("browser")
public void startDriver(String br) 
{
	switch(br.toLowerCase())
  { case "chrome" :driver = new ChromeDriver(); break;
	case "firefox" :driver = new FirefoxDriver(); break;
	case "edge" :driver = new EdgeDriver(); break;
	default : System.out.println("invalid browser");
  }	
 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}

@Test
public void test1() 
{
	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	WebElement status = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt=\"company-branding\"]")));
	Assert.assertTrue(status.isDisplayed());		//boolean Assertion
}

@AfterClass
public void closeDriver()
{	driver.close();
	}
}