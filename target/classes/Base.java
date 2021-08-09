package resources;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import amazon.pages.Home_page;

import org.apache.logging.log4j.Logger;

public class Base {
	// This method will call before class begins its execution so required
	// initialization completes
	public WebDriver driver;
	Logger log = LogManager.getLogger(Home_page.class);
	public static Properties prop = new Properties(), common_prop = new Properties();

	public Base() {
		if (driver == null) {
			// Loads properties files of common properties and chrome locator properties
			try {
				FileInputStream common_path = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\main\\java\\resources\\common_properties.properties");
				common_prop.load(common_path);

				FileInputStream prop_path = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\main\\java\\AamazonMaven\\Amazon_Maven\\chrome_locators.properties");
				prop.load(prop_path);

				String browser = "chrome";

				// Initializing appropriate browser for now you can select either chrome or
				// firefox
				if (browser.equalsIgnoreCase("chrome")) {
					log.debug("Initializing chrome browser");
					System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
					driver = new ChromeDriver();

				} else if (browser.equalsIgnoreCase("firefox")) {
					log.debug("Initializing firefox browser");
					System.setProperty("webdriver.chrome.driver", "D:\\geckodriver.exe");
					driver = new FirefoxDriver();

				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				driver.get(prop.getProperty("webSite"));
				System.out.println(driver.getClass().getName());
				log.info("Browser opened successfully");
			} catch (Exception e) {
				log.error("Unable to find provided properties files");
			}

		}
	}

	public void quitDriver() {

		driver.quit();

	}
}
