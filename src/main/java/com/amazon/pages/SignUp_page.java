package com.amazon.pages;

import java.io.IOException;

import org.apache.logging.log4j.*;

import com.amazon.base.Base;
import com.amazon.methods.SupportMethods;

public class SignUp_page extends Base{

	Logger log = LogManager.getLogger(SignUp_page.class);
	SupportMethods method = new SupportMethods();

	public void signUp() throws IOException {
		/**
		 * This method is used to add new customer.
		 * 
		 * @param driver - WebDriver's object
		 */

		// Using selenium action to hover on SignIn/SignUp element
		method.performAction(driver, prop.getProperty("signinElement"), "xpath");

		// click on sign-up
		method.clickElement(prop.getProperty("signup_link_text"), "linkText", driver);
		log.info("Successfully hovered onto signup details");

		log.info("Filling signup details");

		// Filling sign-up details

		method.sendText(prop.getProperty("CustomerName"), "name", driver,
				common_prop.getProperty("customer"));
		method.sendText(prop.getProperty("CustomerEmail"), "name", driver, common_prop.getProperty("email"));
		method.sendText(prop.getProperty("password"), "name", driver, common_prop.getProperty("Password"));
		method.sendText(prop.getProperty("checkPassword"), "name", driver,
				common_prop.getProperty("Password"));
		method.clickElement(prop.getProperty("Continue"), "id", driver);

		log.info("Filled info Name " + common_prop.getProperty("customer") + " and email"
				+ common_prop.getProperty("email"));
	}
}
