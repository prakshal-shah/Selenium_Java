package AamazonMaven.Amazon_Maven;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;
import AamazonMaven.Amazon_Maven.language;
import Support_Methods.support_methods;

public class LanguageTest {

	support_methods method = new support_methods();
	WebDriver driver;
	String web_url = "https://www.amazon.com/";
	language language = new language();

	@BeforeTest
	public void initialization() throws IOException {
		// Setting-up for test, initializing driver
		base b = new base();
		driver = b.setup_method();
	}

	@Test
	public void changeLanguage() throws IOException, InterruptedException {
		// Test to change language of amazon site, currently it will change language to
		// Português
		driver.manage().window().maximize();
		driver.get(web_url);
		language.change_language(driver);

	}

	@AfterTest
	public void finalizer() {
		driver.quit();
	}
}
