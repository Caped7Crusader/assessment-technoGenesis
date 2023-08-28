package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public WebDriver driver;
	
	@FindBy(name = "Email")
	public WebElement emailTextBox;
	@FindBy(name = "password")
	public WebElement passwordTextBox;
	@FindBy(xpath = "//span[text()  = 'Sign In']")
	public WebElement signInButton;
	@FindBy(xpath = "//a[text()  = 'Forgot Password']")
	public WebElement forgetPasswordLink;

	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}


}
