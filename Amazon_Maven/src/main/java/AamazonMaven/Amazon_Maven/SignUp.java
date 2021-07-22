package AamazonMaven.Amazon_Maven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Support_Methods.support_methods;

public class SignUp {

	Logger log = LogManager.getLogger(SignUp.class);
	support_methods method = new support_methods();
	private static Properties prop = new Properties();
	private static Properties common_prop = new Properties();

	public void Sign_Up(WebDriver driver) throws IOException {

		// Initializing properties of chrome locators
		FileInputStream prop_path = new FileInputStream(
				"C:\\Users\\112208\\eclipse-selenium-workspace\\Amazon_Maven\\src\\main\\java\\AamazonMaven\\Amazon_Maven\\chrome_locators.properties");
		prop.load(prop_path);

		// Initializing properties of common properties
		FileInputStream common_path = new FileInputStream(
				"C:\\Users\\112208\\eclipse-selenium-workspace\\Amazon_Maven\\src\\main\\java\\resources\\common_properties.properties");
		common_prop.load(common_path);

		// Using selenium action to hover on SignIn/SignUp element
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(prop.getProperty("signinElement"))));
		method.clickElement(prop.getProperty("signup_link_text"), "linkText", driver);
		log.info("Successfully hovered onto signup details");

		log.info("Filling signup details");

		// Filling signup details
		method.sendKeys(prop.getProperty("CustomerName"), common_prop.getProperty("customer"), "name", driver);
		method.sendKeys(prop.getProperty("CustomerEmail"), common_prop.getProperty("email"), "name", driver);
		method.sendKeys(prop.getProperty("password"), common_prop.getProperty("Password"), "name", driver);
		method.sendKeys(prop.getProperty("checkPassword"), common_prop.getProperty("Password"), "name", driver);
		method.clickElement(prop.getProperty("Continue"), "id", driver);

		log.info("Filled info Name " + common_prop.getProperty("customer") + " and email"
				+ common_prop.getProperty("email"));
	}
}
