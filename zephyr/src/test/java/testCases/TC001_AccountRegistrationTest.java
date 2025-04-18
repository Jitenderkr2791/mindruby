package testCases;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BASECLASS
{	

	@Test
	public void verify_account_Registrration() 
	{	log.info("========starting TC001_AccountRegistrationTest=======");   //log4j
		
		try
		{
			HomePage hp = new HomePage(driver);
		
		/*
		 * WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wb.until(ExpectedConditions.elementToBeClickable(hp.clickMyAccount()));
		 */
		
		log.info("=======clicked on My Account link");		//log4j
		hp.clickMyAccount();
		log.info("=======clicked on register link");		//log4j
		hp.clickRegister();
		
		String password = randomAlphaNumeric();
		
		AccountRegistrationPage ac=new AccountRegistrationPage(driver);
		log.info("providing Customer details.....");			//log4j
		ac.setfirstName(RandomString().toUpperCase())
		.setlastName(RandomString().toUpperCase())
		.setemail(RandomString()+"@gmail.com")
		.settelephone(Randomnumber())
		.clickNewsletterRandomly()
		.setpassword(password)
		.setCnfPassword(password)
		.checkPrivacyPolicy()
		.clickcontinue();
		
		log.info("validating expected message..");
		String confirmmsgString = ac.confirmMsg();
		Assert.assertEquals(confirmmsgString, "Congratulations! Your new account has been successfully created!");
		
		
		  } catch(Exception e) { log.error("Test failed.."); log.debug("debug logs..");
		  Assert.fail(); }
		  log.info("=========finished TC001_AccountRegistrationTest ");
		 
		 
	}	
}
