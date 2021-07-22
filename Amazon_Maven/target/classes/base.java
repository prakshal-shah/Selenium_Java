package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public  class base {
	// This method will call before class begins its execution so required
	// initialization completes
	WebDriver driver;
//	Properties prop,common_prop;
	public WebDriver setup_method() throws IOException {

	
	// Setting up properties
	FileInputStream common_details = new FileInputStream(
			"C:\\Users\\112208\\eclipse-selenium-workspace\\Amazon\\src\\methods\\common_details.properties");
//	common_prop.load(common_details);

	FileInputStream chrome_locators = new FileInputStream(
			"C:\\Users\\112208\\eclipse-selenium-workspace\\Amazon\\src\\methods\\chrome_locators.properties");
//	prop.load(chrome_locators);
	
	// Fetch browser name form property file
	String browser ="chrome";

	// Initializing appropriate browser for now you can select either chrome or firefox
	if (browser.equalsIgnoreCase("chrome")) {
//		log.debug("Initializing chrome browser");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);

	} else if (browser.equalsIgnoreCase("firefox")) {
//		log.debug("Initializing firefox browser");
		System.setProperty("webdriver.chrome.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);

	}

	return driver;

}
}