package pageObjects;

import java.time.Duration;
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
	@FindBy(id= "gender-male")
	WebElement maleRadio;

	@FindBy(id = "gender-female")
	WebElement femaleRadio;
	
	@FindBy(xpath="//input[@name='FirstName']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@name=\"LastName\"]")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@name=\"Email\"]")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name=\"Telephone\"]")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@name=\"Company\"]")
	WebElement txtCompanyName;
	
	@FindBy(xpath="//input[@id=\"Newsletter\"]")
	WebElement chckbNewsLetter;
	
	@FindBy(xpath="//input[@name=\"Password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name=\"ConfirmPassword\"]")
	WebElement txtConfirmpassword;
	
	@FindBy(xpath="//button[@id=\"register-button\"]")
	WebElement btnRegister;
	
	@FindBy(xpath ="//div[text()='Your registration completed']")
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
	public AccountRegistrationPage setcompanyname(String Cpyname)
	{
		txtCompanyName.sendKeys(Cpyname);
		return this;
	}
	
	public AccountRegistrationPage clickNewsletter()
	{
		chckbNewsLetter.click();
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
	
	public AccountRegistrationPage clickregister()
	{
		btnRegister.click();
		
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
