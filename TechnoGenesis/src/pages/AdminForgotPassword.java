package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AdminForgotPassword {
	public WebDriver driver;
	
	@FindBy(name = "Email")
	public WebElement emailTextbox;
	@FindBy(xpath = "//span[text()  = 'Submit']")
	public WebElement submitButton;
	@FindBy(className = "font-weight-bold mat-color-primary" )
	public WebElement backToLogin;
	
	public AdminForgotPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
