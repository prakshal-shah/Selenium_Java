package com.amazon.testcases;

import java.util.List;
import java.io.IOException;

import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import com.amazon.pages.Search_page;



@Listeners(com.amazon.listeners.Listeners.class)
public class SearchProduct extends BaseTest {

//	Home_page home_page= new Home_page();
	Search_page sp = new Search_page();
	List<Integer> prices;

	@Test(priority = 1)
	public void searchProduct() throws IOException {
		// Test to search for given product
//		driver.get(prop.getProperty("webSite"));

		sp.findProduct();
	}

	@Test(priority = 2)
	public void getPrice() throws InterruptedException, IOException {
		// Test to fetch prices of the product
		prices = sp.getPrice();

	}

	@Test(priority = 3)
	public void minPrice() {
		// Test to find minimum price from price list
		sp.minPrice(prices);
	}

//	@AfterTest
//	public void finalizer() {
//		// Finalize Test - used to quit
//
//		driver.quit();
//	}
}
