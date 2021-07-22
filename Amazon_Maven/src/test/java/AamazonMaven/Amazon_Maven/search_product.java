package AamazonMaven.Amazon_Maven;

import java.util.List;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import resources.base;

public class search_product extends base {

	Products product = new Products();
	WebDriver driver;
	List<Integer> prices;
	String web_url = "https://www.amazon.com/";

	@BeforeTest
	public void initialize() throws IOException {
		// Initializing test
		driver = setup_method();

	}

	@Test(priority = 1)
	public void search() throws IOException {
		// Test to search product
		driver.manage().window().maximize();
		driver.get(web_url);

		product.Search_Product(driver);
	}

	@Test(priority = 2)
	public void getPrice() throws InterruptedException {
		// Test to fetch all displayed prices
		prices = product.get_price(driver);

	}

	@Test(priority = 3)
	public void minPrice() {
		// Test to find minium from price list
		product.min_price(prices);
	}

	@AfterTest
	public void finalizer() {
		driver.quit();
	}
}
