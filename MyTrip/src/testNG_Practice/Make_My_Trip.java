package testNG_Practice;

import methods.Methods_For_Trip;
import locators.Chrome_Locators_For_Trip;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
//import org.testng.annotations.BeforeTest;

public class Make_My_Trip {
		Methods_For_Trip method = new Methods_For_Trip();
		Chrome_Locators_For_Trip locators = new Chrome_Locators_For_Trip();
	
	
		@BeforeClass
		public void setup() {
			method.setup();
			String site = "https://www.makemytrip.com/";
			method.Search_Site(site, locators.initial_pop_up);
		}
		
		@Test(priority = 1)
		public void fill_details() {
			method.fill_details();
		}
		
		@Test(priority = 2)
		public void estimation() {
			method.estimate_prices();
		}
		
		@Test(priority = 3)
		public void low_price() {
			method.low_price();
		}
		
		@AfterClass
		public void main() {
			method.quit();
		}
		
}
