package testCases;

import java.io.FileReader;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import zephyr.zephyr.Driverclass;

public class BASECLASS 
{
		public  WebDriver driver;
		public Logger log; //log4j
		public Properties p;

		@BeforeClass
		@Parameters({"browser"})
	    public  void startdriver(String br) throws Throwable 
	    {	
			//logging mandatory line
			log=LogManager.getLogger(this.getClass());
			
			driver=Driverclass.getDriver(br);
			
			driver.get("https://tutorialsninja.com/demo/");  //reading value from properties file. 
			
	    }

	    @AfterClass
	    public void closeDriver() 
	    {
	        Driverclass.quitDriver();
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
