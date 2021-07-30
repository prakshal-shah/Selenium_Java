package AamazonMaven.Amazon_Maven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;
import support_methods.DriverMethods;

public class Search_page {
// this file contains methods for search product, get prices, find minimum price.
	Logger log = LogManager.getLogger(Search_page.class);
	DriverMethods method = new DriverMethods();

	public List<Integer> getPrice(WebDriver driver) throws InterruptedException, IOException {
		/**
		 * This method will be called after search product so this will be used to fetch
		 * all prices available on current web page
		 * 
		 * @param driver - WebDriver's object
		 * @returns prices - list of fetched prices
		 */
		List<Integer> prices = new ArrayList<>();

		// Fetch price
		List<WebElement> price = method.find_Elements(Base.prop.getProperty("priceTag"), "className", driver);

		log.info("Fetching prices");
		// Currency Symbol
		String priceSymbol = method.getText(Base.prop.getProperty("priceSymbol"), "className", driver);
		log.info("Prices are in: " + priceSymbol);

		// Loop to add stored price in integer form
		for (WebElement p : price) {

			if (p.getText().contains(",")) {
				String[] pr = p.getText().replace(",", "").split(" ");
				Integer pr1 = Integer.parseInt(pr[0]);
				prices.add(pr1);
			} else {
				Integer pr1 = Integer.parseInt(p.getText());
				prices.add(pr1);
			}
		}
		log.info("Prices Stored successfully");
		log.info("Fetched prices are: " + prices);
		return prices;
	}

	public void minPrice(List<Integer> prices) {
		/**
		 * This method is used to find minimum value from integer list
		 * 
		 * @param prices - Integer list
		 */
		//
		int min_price = Collections.min(prices);
		log.info("Minimun amount is:" + min_price);
	}
}
