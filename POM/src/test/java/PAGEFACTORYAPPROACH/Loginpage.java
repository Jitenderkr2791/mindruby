package PAGEFACTORYAPPROACH;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	//constructor
	Loginpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//locators
	@FindBy(xpath="//input[@placeholder='Username']") 
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath ="//button[normalize-space()='Login']")
	WebElement login_btn;
	
	@FindBy(how=How.XPATH, using ="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement Forgot_your_password;
	
	 @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
	 WebElement errorMsg;
	
	@FindBy(tagName = "a")
	List<WebElement>links;
	
	
	//Actions
	
	public void setusername(String name)
	 {
		 username.clear();
		 username.sendKeys(name);
	 }
	 
	 public void setpassword(String pass)
	 {	
		 password.clear();
		 password.sendKeys(pass);
	 }
	
	 public void clickLoginBtn()
	 {
		 login_btn.click();
	 }
	
	 public String getErrorMessage() 
	 	{
	        return errorMsg.getText();
	    }

	 public boolean isLoginButtonDisplayed()
	    {
	        return login_btn.isDisplayed();
	    }
}
