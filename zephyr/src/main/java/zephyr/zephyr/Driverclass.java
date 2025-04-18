package zephyr.zephyr;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Driverclass 
{
		static WebDriver driver;
	    public static WebDriver getDriver(String browser) 
	    {  	
	        if (driver == null) 
	        {
	            switch (browser.toLowerCase())
	            {
	                case "chrome":
	                	 WebDriverManager.chromedriver().setup();
	                    ChromeOptions options = new ChromeOptions();
	                   // options.addArguments("--headless=new");			//for headless test script execution.
	                    options.addArguments("--window-size=1920,1080");
	                    options.setAcceptInsecureCerts(true);			//For SSL certificate
	                    driver = new ChromeDriver(options);
	                    break;
	                case "firefox":
	                	 WebDriverManager.firefoxdriver().setup();
	                	 FirefoxOptions foptions = new FirefoxOptions();
	                	 foptions.addArguments("--headless");
	                	 foptions.setAcceptInsecureCerts(true);
	                    driver = new FirefoxDriver(foptions);
	                    break;
	                case "edge":
	                	 WebDriverManager.edgedriver().setup();
	                	 EdgeOptions eoptions = new EdgeOptions();
	                	 eoptions.addArguments("--headless=new");
	                	 eoptions.setAcceptInsecureCerts(true);
	                    driver = new EdgeDriver(eoptions);
	                    break;
	                default:
	                    throw new IllegalArgumentException("Invalid browser: " + browser);
	            }
	            driver.manage().deleteAllCookies();
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
	   

