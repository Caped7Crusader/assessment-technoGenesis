package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	public WebDriver driver;
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper']//img")
	public WebElement profile;
	@FindBy(xpath = "//span[text()='Sign out']")
	public WebElement SignOut;


	public Home(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
