package base.AprilMavenProject;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver 
{
	  private static WebDriver driver;

	    public static WebDriver getDriver(String browser) 
	    {
	        if (driver == null) 
	        {
	            switch (browser.toLowerCase())
	            {
	                case "chrome":
	                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jitender.Kumar\\eclipse-workspace\\AprilMavenProject\\chromedriver.exe");
	                    ChromeOptions options = new ChromeOptions();
	                    options.addArguments("--headless=new");			//for headless test script execution.
	                    options.addArguments("--window-size=1920,1080");
	                    options.setAcceptInsecureCerts(true);			//For SSL certificate
	                    driver = new ChromeDriver(options);
	                    break;
	                case "firefox":
	                    System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
	                    driver = new FirefoxDriver();
	                    break;
	                case "edge":
	                    System.setProperty("webdriver.edge.driver", "C:\\Users\\Jitender.Kumar\\eclipse-workspace\\AprilMavenProject\\msedgedriver.exe");
	                    driver = new EdgeDriver();
	                    break;
	                default:
	                    throw new IllegalArgumentException("Invalid browser: " + browser);
	            }
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        }
	        return driver;
	    }

	    
	    public static void quitDriver() 
	    {
	        if (driver != null) 
	        {
	            driver.quit();
	            driver = null;
	        }
	    }
	}