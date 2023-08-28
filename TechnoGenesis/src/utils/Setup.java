package utils;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {
	public static WebDriver driver;
	public static Properties prop;
	
	static {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			File file = new File(".\\allLinks.properties");
			FileInputStream read = new FileInputStream(file);
			prop = new Properties();
			prop.load(read);
		}catch(Exception e) {
			
		}
	}

}
