package support_methods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import AamazonMaven.Amazon_Maven.Home_page;

public class SupportMethods {

	private WebElement webElement;
	List<WebElement> webElements;
	Logger log = LogManager.getLogger(Home_page.class);

	public void clickOnElement(WebElement webElement) {
		// Method for clicking element
		webElement.click();
		log.info("Element clicked");
	}

	public void sendKeys(WebElement webElement, String write) {
		// Method to write
		webElement.sendKeys(write);
		log.info("Text written" + write);
	}

	public void pressEnter(WebElement webElement) {
		// Method to press enter
		webElement.sendKeys(Keys.ENTER);
		log.info("Enter pressed");
	}// webElement = find_element(element, findBy, driver);

	public void closePopup(WebDriver driver) {
		// Close pop-up
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			log.debug("Closing popups");
			WebElement element = find_Element("//*[@data-action-type='DISMISS']", "xpath", driver);
			clickOnElement(element);
			log.info("popup closed");
		} catch (Exception e) {
			System.out.println("pop up not shown");
		}
	}

	public void hoverAction(WebElement webElement, Actions action) {
		// Method to perform mouse Hover action
		action.moveToElement(webElement).build().perform();
		log.info("Hovered successfully");
	}

	public WebElement find_Element(String element, String findBy, WebDriver driver) {
		// Method for find element
		switch (findBy) {
		case "xpath":
			webElement = driver.findElement(By.xpath(element));
			break;
		case "id":
			webElement = driver.findElement(By.id(element));
			break;
		case "css":
			webElement = driver.findElement(By.cssSelector(element));
			break;
		case "name":
			webElement = driver.findElement(By.name(element));
			break;
		case "className":
			webElement = driver.findElement(By.className(element));
			break;
		case "linkText":
			webElement = driver.findElement(By.linkText(element));
			break;
		}
		return webElement;
	}

	public List<WebElement> find_Elements(String element, String findBy, WebDriver driver) {
		// Method for find elements
		switch (findBy) {
		case "xpath":
			webElements = driver.findElements(By.xpath(element));
			break;
		case "id":
			webElements = driver.findElements(By.id(element));
			break;
		case "css":
			webElements = driver.findElements(By.cssSelector(element));
			break;
		case "name":
			webElements = driver.findElements(By.name(element));
			break;
		case "className":
			webElements = driver.findElements(By.className(element));
			break;
		case "linkText":
			webElements = driver.findElements(By.linkText(element));
			break;
		}
		return webElements;
	}

}
