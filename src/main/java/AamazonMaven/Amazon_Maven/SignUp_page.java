package AamazonMaven.Amazon_Maven;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import resources.Base;
import support_methods.DriverMethods;

public class SignUp_page {

	Logger log = LogManager.getLogger(SignUp_page.class);
	DriverMethods method = new DriverMethods();

	public void signUp(WebDriver driver) throws IOException {
		/**
		 * This method is used to add new customer.
		 * 
		 * @param driver - WebDriver's object
		 */

		// Using selenium action to hover on SignIn/SignUp element
		method.performAction(driver, Base.prop.getProperty("signinElement"), "xpath");

		// click on sign-up
		method.clickElement(Base.prop.getProperty("signup_link_text"), "linkText", driver);
		log.info("Successfully hovered onto signup details");

		log.info("Filling signup details");

		// Filling sign-up details

		method.sendText(Base.prop.getProperty("CustomerName"), "name", driver,
				Base.common_prop.getProperty("customer"));
		method.sendText(Base.prop.getProperty("CustomerEmail"), "name", driver, Base.common_prop.getProperty("email"));
		method.sendText(Base.prop.getProperty("password"), "name", driver, Base.common_prop.getProperty("Password"));
		method.sendText(Base.prop.getProperty("checkPassword"), "name", driver,
				Base.common_prop.getProperty("Password"));
		method.clickElement(Base.prop.getProperty("Continue"), "id", driver);

		log.info("Filled info Name " + Base.common_prop.getProperty("customer") + " and email"
				+ Base.common_prop.getProperty("email"));
	}
}
