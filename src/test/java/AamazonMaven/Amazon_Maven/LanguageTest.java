package AamazonMaven.Amazon_Maven;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;
import support_methods.SupportMethods;

public class LanguageTest extends Base {

	SupportMethods method = new SupportMethods();
	WebDriver driver;
	Home_page language = new Home_page();

	@BeforeTest
	public void initialization() throws IOException {
		/**
		 * This test is used to initialize WebDriver object and open that specific
		 * browser.
		 * 
		 **/
		driver = setupMethod();
	}

	@Test
	public void changeLanguage() throws IOException, InterruptedException {
		/**
		 * Test to change language of amazon site, currently it will change language to
		 * Português
		 **/
		driver.get(prop.getProperty("webSite"));
		language.changeLanguage(driver);

	}

	@AfterTest
	public void finalizer() {
		// Finalize Test - used to quit
		driver.quit();
	}
}
