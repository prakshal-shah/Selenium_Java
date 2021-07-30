package resources;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import AamazonMaven.Amazon_Maven.Home_page;

import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;

public class Base {
	// This method will call before class begins its execution so required
	// initialization completes
	WebDriver driver;
	Logger log = LogManager.getLogger(Home_page.class);
	public static Properties prop = new Properties(), common_prop = new Properties();

	public Base() {
		// Loads properties files of common properties and chrome locator properties
		try {
			FileInputStream common_path = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\common_properties.properties");
			common_prop.load(common_path);

			FileInputStream prop_path = new FileInputStream(
					System.getProperty("user.dir") +"\\src\\main\\java\\AamazonMaven\\Amazon_Maven\\chrome_locators.properties");
			prop.load(prop_path);
		} catch (Exception e) {
			log.error("Unable to find provided properties files");
		}

	}

	public WebDriver setupMethod() throws IOException {
		/*
		 * This method is used to create WebDriver object and open mentioned browser
		 */
		// Fetch browser name form property file
		String browser = "chrome";

		// Initializing appropriate browser for now you can select either chrome or
		// firefox
		if (browser.equalsIgnoreCase("chrome")) {
			log.debug("Initializing chrome browser");
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

			log.info("Browser opened successfully");

		} else if (browser.equalsIgnoreCase("firefox")) {
			log.debug("Initializing firefox browser");
			System.setProperty("webdriver.chrome.driver", "D:\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			log.info("Browser opened successfully");
		}

		return driver;

	}

	public String captureScreenShot(String testCaseName, WebDriver driver) {
		/*
		 * This method is used to capture screenshot and save it in reports folder
		 */
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + "-" + timeStamp()
				+ ".png";
		try {
			FileUtils.copyFile(source,
					new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + "ss"));
			FileUtils.copyFile(source, new File(destinationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationFile;

	}

	public static String timeStamp() {
		// This method returns timeStamp 
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	}
}