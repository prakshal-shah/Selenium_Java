package AamazonMaven.Amazon_Maven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import AamazonMaven.Amazon_Maven.Products;
import resources.base;

public class homePage extends base {
	SignUp signUp = new SignUp();
	static WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		//Initialize driver
		driver = setup_method();
		log.info("Initialized");
	}

	@Test
	public void signup() throws IOException {
		//test for sign-up, TO-DO: web-url dynamic 
		System.out.println("");
		driver.get("https://www.amazon.com/");

		signUp.Sign_Up(driver);
	}

	@AfterTest
	public void finalizer() {
		driver.quit();
	}
}
