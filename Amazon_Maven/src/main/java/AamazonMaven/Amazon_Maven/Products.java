package AamazonMaven.Amazon_Maven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Support_Methods.support_methods;

public class Products {
// this file conains methods for search product, get prices, find minimum price.
	Logger log = LogManager.getLogger(Products.class);
	// Logger log = org.testng.log4testng.Logger.getLogger(getClass());
	support_methods method = new support_methods();

	private static Properties prop = new Properties();

	public void Search_Product(WebDriver driver) throws IOException {
		String product = "Samsung";
		FileInputStream prop_path = new FileInputStream(
				"C:\\Users\\112208\\eclipse-selenium-workspace\\Amazon_Maven\\src\\main\\java\\AamazonMaven\\Amazon_Maven\\chrome_locators.properties");
		prop.load(prop_path);

		// Method to search product mentioned in common_details.properties file
		log.info("Searching for product "+ product);
//		System.out.println("Searching for product " + product);

		method.sendKeys(prop.getProperty("searchbar"), product, "id", driver);
		method.clickElement(prop.getProperty("search"), "id", driver);
	}

	public List<Integer> get_price(WebDriver driver) throws InterruptedException {
		// Method to get all prices available on web page

		List<Integer> prices = new ArrayList<>();
		List<WebElement> price = driver.findElements(By.className(prop.getProperty("priceTag")));

		log.info("Fetching prices");
		// Currency Symbol
		String priceSymbol = driver.findElement(By.className(prop.getProperty("priceSymbol"))).getText();
		log.info("Prices are in: " + priceSymbol);

		// Loop to add stored price in int form
		for (WebElement p : price) {

			Integer pr1 = Integer.parseInt(p.getText());
			prices.add(pr1);

		}
		log.info("Prices Stored successfully");
		log.info("Fetched prices are: " + prices);
		return prices;
	}

	public void min_price(List<Integer> prices) {
		int min_price = Collections.min(prices);
		log.info("Minimun amount is:" + min_price);
	}

}
