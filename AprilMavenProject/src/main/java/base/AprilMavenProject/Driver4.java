package base.AprilMavenProject;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver4 
{
	private static WebDriver driver;

	    public static WebDriver getDriver(String browser)
	    {
	        if (driver == null) {
	            switch (browser.toLowerCase()) {
	                case "chrome":
	                    WebDriverManager.chromedriver().setup();
	                    ChromeOptions options = new ChromeOptions();
	                    options.addArguments("--headless=new");			//for headless test script execution.
	                    options.addArguments("--window-size=1920,1080");
	                    options.setAcceptInsecureCerts(true);		
	                    driver= new ChromeDriver(options);
	                    break;
	                case "firefox":
	                    WebDriverManager.firefoxdriver().setup();
	                    driver = new FirefoxDriver();
	                    break;
	                case "edge":
	                    WebDriverManager.edgedriver().setup();
	                    driver = new EdgeDriver();
	                    break;
	                default:
	                    throw new IllegalArgumentException("Invalid browser: " + browser);
	            }

	            // Configure browser settings
	            
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            driver.manage().deleteAllCookies();
	        }
	        return driver;
	    }

	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null ;
	        }
	    }
	}
