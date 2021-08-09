package com.amazon.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.amazon.base.Base;
import com.amazon.methods.SupportMethods;

public class Search_page extends Base {
// this file contains methods for search product, get prices, find minimum price.
	Logger log = LogManager.getLogger(Search_page.class);
	SupportMethods method = new SupportMethods();

	public void findProduct() throws IOException {
		/**
		 * This method is used to search for product from homepage's searchBar
		 * 
		 * @param driver - WebDriver's object
		 */
		String product = "Samsung";

		// Method to search product mentioned in common_details.properties file
		log.info("Searching for product " + product);
		method.sendText(prop.getProperty("searchbar"), "id", driver, product);

		method.clickElement(prop.getProperty("search"), "id", driver);

	}

	public List<Integer> getPrice() throws InterruptedException, IOException {
		/**
		 * This method will be called after search product so this will be used to fetch
		 * all prices available on current web page
		 * 
		 * @param driver - WebDriver's object
		 * @returns prices - list of fetched prices
		 */
		List<Integer> prices = new ArrayList<>();

		// Fetch price
		List<WebElement> price = method.find_Elements(prop.getProperty("priceTag"), "className", driver);

		log.info("Fetching prices");
		// Currency Symbol
		String priceSymbol = method.getText(prop.getProperty("priceSymbol"), "className", driver);
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
