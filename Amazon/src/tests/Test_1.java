package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import methods.Method_1;

public class Test_1 extends Method_1 {

	TimeUnit time = TimeUnit.SECONDS;

//	@Parameters({"webURL"})
	@BeforeClass
	public void setups() throws IOException, InterruptedException {
		//Setup driver and necessary objects
		WebDriver driver = setup_method();
		driver.get("https://www.amazon.com");
		time.sleep(5);
	}

	@Test(priority = 1)
	public void ClosePopup() {
		//Test to close auto pop up of amazon site
		close_popup();
	}

	@Test(priority = 2)
	public void SearchProduct() {
		//Test to search any product
		Search_Product();
	}

	@Test(priority = 3)
	public void getPrices() {
		//Get dispalyed prices of prodct shown on webpage
		get_price();
	}

	@Test(priority = 4)
	public void lowestPrice() {
		//Test to prit lowest amount 
		lowest_price();
	}

	@Test(priority = 5)
	public void changeLanguage() throws InterruptedException {
		change_language();
	}

	@Test(priority = 6)
	public void setDefaultLanguage() {
		DefaultLanguage();
	}

	@Test(priority = 7)
	public void signup() throws InterruptedException {
		SignUp();
	}

	@AfterClass
	public void finalizer() {
		finalizer_method();
	}

}