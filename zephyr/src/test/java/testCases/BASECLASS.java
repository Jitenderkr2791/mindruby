package testCases;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BASECLASS {
		public  WebDriver driver;

		@BeforeClass
	    public  WebDriver getDriver(String browser) 
	    {
	        if (driver == null) 
	        {
	            switch (browser.toLowerCase())
	            {
	                case "chrome":
	                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jitender.Kumar\\eclipse-workspace\\AprilMavenProject\\chromedriver.exe");
	                    ChromeOptions options = new ChromeOptions();
	                 //   options.addArguments("--headless=new");			//for headless test script execution.
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
	            driver.manage().deleteAllCookies();
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        }
	        return driver;
	    }

	    @AfterClass
	    public void quitDriver() 
	    {
	        if (driver != null) 
	        {
	            driver.quit();
	            driver = null;
	        }
	    }
	    
	    
	    public String RandomString()
		{
			String GeneratedString = RandomStringUtils.randomAlphabetic(6);
			return GeneratedString;
		}
		
	    public String Randomnumber()
		{
			String Generatednumber = RandomStringUtils.randomNumeric(10);
			return Generatednumber;
		}
		
		public String randomAlphaNumeric()
		{
			String GeneratedString = RandomStringUtils.randomAlphanumeric(10);
					return GeneratedString;
			/*String GeneratedString = RandomStringUtils.randomAlphabetic(6);
			String Generatednumber = RandomStringUtils.randomNumeric(10);
			return (Generatednumber+"@" +GeneratedString);*/
		}
}
