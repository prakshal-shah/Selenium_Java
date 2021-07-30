package AamazonMaven.Amazon_Maven;

import java.util.List;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import resources.Base;

public class SearchProduct extends Base {

	Search_page product = new Search_page();
	Home_page home = new Home_page();
	WebDriver driver;
	List<Integer> prices;

	@BeforeTest
	public void initialize() throws IOException {
		/**
		 * This test is used to initialize WebDriver object and open that specific
		 * browser. It returns webDriver object so using that we can interact with
		 * web-elements
		 **/
		driver = setupMethod();

	}

	@Test(priority = 1)
	public void searchProduct() throws IOException {
		// Test to search for given product
		driver.get(prop.getProperty("webSite"));

		home.findProduct(driver);
	}

	@Test(priority = 2)
	public void getPrice() throws InterruptedException, IOException {
		// Test to fetch prices of the product
		prices = product.getPrice(driver);

	}

	@Test(priority = 3)
	public void minPrice() {
		// Test to find minimum price from price list
		product.minPrice(prices);
	}

	@AfterTest
	public void finalizer() {
		// Finalize Test - used to quit

		driver.quit();
	}
}
