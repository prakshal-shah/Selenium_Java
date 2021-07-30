package AamazonMaven.Amazon_Maven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import resources.Base;
import support_methods.*;
//page factory
public class Home_page extends Base {

	Logger log = LogManager.getLogger(Home_page.class);
	DriverMethods method = new DriverMethods();

	public void findProduct(WebDriver driver) throws IOException {
		/**
		 * This method is used to search for product from homepage's searchBar
		 * 
		 * @param driver - WebDriver's object
		 */
		String product = "Samsung";

		// Method to search product mentioned in common_details.properties file
		log.info("Searching for product " + product);
		method.sendText(Base.prop.getProperty("searchbar"), "id", driver, product);

		method.clickElement(Base.prop.getProperty("search"), "id", driver);

	}

	public void changeLanguage(WebDriver driver) throws IOException, InterruptedException {
		/**
		 * This method is used to change language of the site.
		 * 
		 * @param driver - WebDriver's object 
		 */
		
		// Perform mouse hover action
		method.performAction(driver, Base.prop.getProperty("languageElement"), "id");
		log.info("Move action performed to hover on language element");

		// loop to select expected language from dropdown
		method.dpSelect(Base.prop.getProperty("languageDropDown"), "xpath", prop.getProperty("ExpectedLanguage"),
				driver);
		log.info("Language selected successfully");
	}
}
