package AamazonMaven.Amazon_Maven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import resources.Base;

public class HomePage extends Base {
	SignUp_page signUp = new SignUp_page();
	static WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	
	//object constructor
	@BeforeTest
	public void initialize() throws IOException {
		/**
		 * This test is used to initialize WebDriver object and open that specific
		 * browser. It returns webDriver object so using that we can interact with
		 * web-elements
		 **/
		driver = setupMethod();
		log.info("Initialized");
	}

	@Test
	public void signUp() throws IOException {
		/**
		 * This Test is used for signing up new user.
		 * Here webSite will be fetched from chrome_locators property file
		 **/
		driver.get(prop.getProperty("webSite"));

		signUp.signUp(driver);
	}

	@AfterTest
	public void finalizer() {
		// Finalize Test - used to quit
		driver.quit();
	}
}
