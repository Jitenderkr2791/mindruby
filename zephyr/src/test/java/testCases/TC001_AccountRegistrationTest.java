package testCases;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BASECLASS
{	

	@Test
	public void verify_account_Registrration() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		/*
		 * WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wb.until(ExpectedConditions.elementToBeClickable(hp.clickMyAccount()));
		 */
		Thread.sleep(5000);
		hp.clickMyRegister();
		
		String password = randomAlphaNumeric();
		
		AccountRegistrationPage ac=new AccountRegistrationPage(driver);
		ac.setfirstName(RandomString().toUpperCase())
		.setlastName(RandomString().toUpperCase())
		.setemail(RandomString()+"@gmail.com")
		.settelephone(Randomnumber())
		.setcompanyname(RandomString())
		.clickNewsletter()
		.setpassword(password)
		.setCnfPassword(password)
		.clickregister();
		String confirmmsgString = ac.confirmMsg();
		Assert.assertEquals(confirmmsgString, "Your registration completed");
	}

	
}
