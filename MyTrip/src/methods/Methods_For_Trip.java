package methods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.Chrome_Locators_For_Trip;
import locators.Chrome_Locators_For_Trip.*;

public class Methods_For_Trip {

	TimeUnit time = TimeUnit.SECONDS;
	static WebDriver driver;
	Chrome_Locators_For_Trip locators = new Chrome_Locators_For_Trip();

	static List<Integer> prices = new ArrayList<>();

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		driver = new ChromeDriver();

	}

	public void fill_details() {
		try {
			driver.findElement(By.xpath(locators.from)).click();
			driver.findElement(By.xpath(locators.from_place)).sendKeys("Ahmedabad");
			// driver.findElement(By.xpath(locators.place
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			// time.sleep(1);
			driver.findElement(By.xpath(locators.place)).click();
			driver.findElement(By.xpath(locators.to_place)).sendKeys("Jharsuguda");
//		time.sleep(1);
			driver.findElement(By.xpath(locators.place)).click();
			driver.findElement(By.xpath(locators.dept_date)).click();
			driver.findElement(By.xpath(locators.returns)).click();
			driver.findElement(By.xpath(locators.return_date)).click();
//		time.sleep(2);
			driver.findElement(By.xpath(locators.travellers)).click();
//		time.sleep(1);
			driver.findElement(By.xpath(locators.adlt_passanger)).click();
			driver.findElement(By.xpath(locators.travel_apply)).click();
//		time.sleep(1);
			driver.findElement(By.xpath(locators.search)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Please review fill_details method");
		} 
		
	}

	public void estimate_prices() {

		List<WebElement> price = driver.findElements(By.xpath(locators.price_tag));

		for (WebElement p : price) {
			String[] pr = p.getText().replace(",", "").split(" ");
			Integer pr1 = Integer.parseInt(pr[1]);
			prices.add(pr1);
		}
		System.out.println("Prices are:" + prices);
	}

	public void low_price() {
		int low_price = 0;
		System.out.println("MIN: " + Collections.min(prices));
//		for(int low : prices) {
//			
//			if (low_price<low) {
//				low_price = low;
//				System.out.println("Low price is: "+low_price);
//			}
//		}
	}

	public void average_price() {
		int min_price = Collections.min(prices);
		int max_price = Collections.max(prices);
		int average_price = (min_price + max_price) / 2;
		System.out.println("Avergae price is:" + average_price);
	}

	public void quit() {
		driver.quit();
	}

	public void Search_Site(String site, String path) {
		driver.manage().window().maximize();
		driver.get(site);
		WebDriverWait web_wait = new WebDriverWait(driver, 5); // here driver is webdriver object and 5 is second. example of explicit wait
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
//				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class); // here if elemet not found
//																								// after waiting the no
//																								// such element found
//																								// error can be ignored
//																								// its an optional.
//
//		WebElement fluent_funnc = wait.until(new Function<WebDriver,WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.xpath(path));
//			}
//		});
		
//		web_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path))); //for waiting till another frame appears
		try {
			if (driver.findElement(By.xpath(path)).isDisplayed()) {
				driver.findElement(By.xpath("//li[@data-cy='account']")).click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Validate xpath");
		}

	}
}
