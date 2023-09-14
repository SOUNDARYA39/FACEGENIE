package POMCLASS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginPage {
	public void LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="email")
	private WebElement EmailText;
	
	@FindBy(id="password")
	private WebElement PasswordText;
	
	@FindBy(linkText = "Log In")
	private WebElement LoginButton;

	
		

	
public WebElement getEmailText() {
		return EmailText;
	}





	public WebElement getPasswordText() {
		return PasswordText;
	}





	public WebElement getLoginButton() {
		return LoginButton;
	}





public    void LogintoApp(String Email, String Password)
	{
		EmailText.sendKeys(Email);
		PasswordText.sendKeys(Password);
		LoginButton.click();
	}

}
