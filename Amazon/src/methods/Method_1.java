package methods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Method_1 {

	// Initializing global variables arraysLists and properties object
	public WebDriver driver;
	private static Logger log = LogManager.getLogger();
	private static List<Integer> prices = new ArrayList<>();
	private Actions action;
	private Properties prop = new Properties();
	private Properties common_prop = new Properties();

	public WebDriver setup_method() throws IOException {
		// This method will call before class begins its execution so required
		// initialization completes

		// Setting up properties
		FileInputStream common_details = new FileInputStream(
				"C:\\Users\\112208\\eclipse-selenium-workspace\\Amazon\\src\\methods\\common_details.properties");
		common_prop.load(common_details);

		FileInputStream chrome_locators = new FileInputStream(
				"C:\\Users\\112208\\eclipse-selenium-workspace\\Amazon\\src\\methods\\chrome_locators.properties");
		prop.load(chrome_locators);
		
		// Fetch browser name form property file
		String browser = prop.getProperty("browser");

		// Initializing appropriate browser for now you can select either chrome or firefox
		if (browser.equalsIgnoreCase("chrome")) {
			log.debug("Initializing chrome browser");
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("firefox")) {
			log.debug("Initializing firefox browser");
			System.setProperty("webdriver.chrome.driver", "D:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		return driver;

	}

	public void close_popup() {
		// there is an popup shown when amazon.com opened (pop up is of change address)
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			log.debug("Closing popups");
			driver.findElement(By.xpath("//*[@data-action-type='DISMISS']")).click();
			log.info("popup closed");
		} catch (Exception e) {

			System.out.println("pop up not shown");
		}
	}

	public void Search_Product() {
		// Method to search product mentioned in common_details.properties file
		log.info("Searching for product ", common_prop.getProperty("product"));
		driver.findElement(By.id(prop.getProperty("searchbar"))).sendKeys(common_prop.getProperty("product"));
		driver.findElement(By.id(prop.getProperty("searchbar"))).sendKeys(Keys.ENTER);
	}

	public void get_price() {
		// Method to get all prices available on web page

		List<WebElement> price = driver.findElements(By.className(prop.getProperty("priceTag")));
		
		log.info("Fetching prices");
		// Currency Symbol
		String priceSymbol = driver.findElement(By.className(prop.getProperty("priceSymbol"))).getText();
		System.out.println(("Prices are in: " + priceSymbol));

		for (WebElement p : price) {

			Integer pr1 = Integer.parseInt(p.getText());
			prices.add(pr1);

		}
		log.info("Prices Stored");

		System.out.println("Prices are: " + prices);
	}

	public void lowest_price() {
		// find lowest price from all available prices
		System.out.println("Lowest ammount is: " + Collections.min(prices));
	}

	public void change_language() throws InterruptedException {

		// Selenium action methods to hover on languages
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id(prop.getProperty("languageElement")))).build().perform();
		log.info("Move action performed to hover on language element");

		// loop to select expected language from dropdown
		List<WebElement> language = driver.findElements(By.xpath(prop.getProperty("languageDropDown")));
		for (WebElement lang : language) {
			String Lang_Text = lang.getText();
			if (Lang_Text.equalsIgnoreCase(prop.getProperty("ExpectedLanguage"))) {
				lang.click();
				log.info("Selected Language is ", Lang_Text);
				break;
			}
		}
	}

	public void DefaultLanguage() {

		// Using selenium action to hover on languages
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id(prop.getProperty("languageElement")))).build().perform();
		log.info("Move action performed to hover on language element");

		// loop to select expected language from dropdown
		List<WebElement> language = driver.findElements(By.xpath(prop.getProperty("languageDropDown")));
		for (WebElement lang : language) {
			String Lang_Text = lang.getText();
			if (Lang_Text.equalsIgnoreCase(prop.getProperty("DefaultLanguage"))) {
				lang.click();
				log.info("Selected Language is ", Lang_Text);
				break;
			}
		}
	}

	public void SignUp() throws InterruptedException {
		// Creating Amazom account, details are fetched from chrome_locators.properties file

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Using selenium action to hover on SignIn/SignUp element
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(prop.getProperty("signinElement")))).build().perform();
		driver.findElement(By.linkText("Start here.")).click();
		log.info("Filling signup details");

		// Filling signup details
		driver.findElement(By.name("customerName")).sendKeys(common_prop.getProperty("CustomerName"));
		driver.findElement(By.name("email")).sendKeys(common_prop.getProperty("CustomerEmail"));
		driver.findElement(By.name("password")).sendKeys(common_prop.getProperty("Password"));
		driver.findElement(By.name("passwordCheck")).sendKeys(common_prop.getProperty("Password"));
		driver.findElement(By.id("continue")).click();
		log.info("Filled info Name and email : ", common_prop.getProperty("CustomerName"),
				common_prop.getProperty("CustomerEmail"));
	}

	public void finalizer_method() {
		driver.quit();
//		System.out.println("Uncomment this");
	}

}
