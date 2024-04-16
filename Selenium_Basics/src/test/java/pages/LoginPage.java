package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement loginbutton;
	@FindBy (xpath="//span[text()='Login was unsuccessful. Please correct the errors and try again.']")
	WebElement error_message;
	
	public void enterUsername(String username)
	{
		WebElementUtility.enterValue(email,username);
	}
	
	public void enterPassword(String pass_word)
	{
		WebElementUtility.enterValue( password,pass_word);
	}
	
	public UserAccount clickOnLoginButton()
	{
		WebElementUtility.clickOnElement(loginbutton);
		return new UserAccount(driver);
	}
	public String userGetText() {
		String text=WebElementUtility.getText(error_message);
		return text;
		
		
	}
}
