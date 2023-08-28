package test;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Home;
import pages.Login;
import utils.Setup;

public class LoginAndForgetPasswordTest {
	
	public WebDriver driver;
	public Properties prop;

	Setup setup = new Setup();
	
	@Test(enabled = true)
	public void loginWithValidCredentials() {
		Login loginPage = new Login(driver);
		String loginUrl = prop.getProperty("loginUrl");
		driver.get(loginUrl);
		loginPage.emailTextBox.sendKeys("admin@gmail.com");
		loginPage.passwordTextBox.sendKeys("Admin@123");
		loginPage.signInButton.click();
		Assert.assertEquals(driver.getTitle(), "Home | Neoline");
	}
	
	@Test(enabled = false)
	public void loginWithValidCredentialsAndSignOut() {
		Login loginPage = new Login(driver);
		String loginUrl = prop.getProperty("loginUrl");
		driver.get(loginUrl);
		loginPage.emailTextBox.sendKeys("admin@gmail.com");
		loginPage.passwordTextBox.sendKeys("Admin@123");
		loginPage.signInButton.click();
		Home homePage = new Home(driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOf(homePage.profile));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage.profile.click();
		homePage.SignOut.click();
		Assert.assertEquals(driver.getTitle(), "Neoline");
		
	}
	
	
	@Test(enabled = false, dataProvider = "invalidData")
	public void loginWithInvalidCredentials(String email, String password) {
		Login loginPage = new Login(driver);
		String loginUrl = prop.getProperty("loginUrl");
		driver.get(loginUrl);
		loginPage.emailTextBox.sendKeys(email);
		loginPage.passwordTextBox.sendKeys(password);
		loginPage.signInButton.click();
		Assert.assertEquals(driver.getTitle(), "Neoline");
		
	}
	
	@DataProvider(name="invalidData")
	public String[][] getData(){
		String[][] data = {{"EmailId", "Password"},
		  				   {"email@id", "password"},
		  				   {"admin123@gmail.com", "admin@123"},
		  				   {"admin123@gmail.com", ""},
		  				   {"", ""},
		  				   {"Admin123@gmail.com", "Admin@123"}};
		return data;
	}
	
	
	@AfterMethod
	public void afterMethod() {
//		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		this.driver = setup.driver;
		this.prop = setup.prop;
	}
	  

}
