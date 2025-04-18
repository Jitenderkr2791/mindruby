package pageObjects;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage
{
	//constructor
	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
		//locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmpassword;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	WebElement rdoNewsLetterYes;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='0']")
	WebElement rdoNewsLetterNO;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chckbPrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath ="//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement confirmationMsg;
	
	
	//actions
	public AccountRegistrationPage setfirstName(String Fname)
	{
		txtFirstname.sendKeys(Fname);
		return this;
	}
	
	public AccountRegistrationPage setlastName(String Lname)
	{
		txtLastname.sendKeys(Lname);
		return this;
	}
	
	public AccountRegistrationPage setemail(String email)
	{
		txtEmail.sendKeys(email);
		return this;
	}
	
	public AccountRegistrationPage settelephone(String phone)
	{
		txtTelephone.sendKeys(phone);
		return this;
	}
	
	public AccountRegistrationPage clickNewsletterRandomly() 
	{
	    Random rand = new Random();
	    boolean selectYes = rand.nextBoolean(); // true or false randomly

	    if (selectYes) {
	        rdoNewsLetterYes.click();
	        System.out.println("Randomly selected: Yes for Newsletter");
	    } else {
	        rdoNewsLetterNO.click();
	        System.out.println("Randomly selected: No for Newsletter");
	    }
	    return this;
	}
	
	public AccountRegistrationPage setpassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
		return this;
	}
	
	public AccountRegistrationPage setCnfPassword(String CnfPwd)
	{
		txtConfirmpassword.sendKeys(CnfPwd);
		return this;
	}
	
	public AccountRegistrationPage checkPrivacyPolicy()
	{
		chckbPrivacyPolicy.click();
		return this;
	}
	public AccountRegistrationPage clickcontinue()
	{
		btnContinue.click();
		
		/*
		 * sol 1 : btnContinue.submit();
		 * 
		 * sol 2 : Actions act = new Actions(driver);
		 * act.moveToElement(btnContinue).click().perform();
		 * 
		 * sol 3 : JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click", btnContinue);
		 * 
		 * sol 4 : WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click(); 		  
		 */	
		return this;
	}
	
	public String confirmMsg()
	{
		try {
			return (confirmationMsg.getText());
			} 
		catch(Exception e)
			{
			return(e.getMessage());
			}
	}
	
}
