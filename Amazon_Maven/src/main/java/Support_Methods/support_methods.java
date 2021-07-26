package Support_Methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class support_methods {

	private WebDriver driver;
	private WebElement webElement;
	public void clickElement(String element, String findBy, WebDriver driver) {

		webElement = find_element(element, findBy);
		webElement.click();
		

	}

	public void sendKeys(String element, String write, String findBy, WebDriver driver) {
		
		webElement = find_element(element, findBy);
		webElement.sendKeys(write);

	}

	public void pressEnter(String element, String findBy, WebDriver driver) {
		webElement = find_element(element, findBy);
		webElement.sendKeys(Keys.ENTER);
		
	}
	
	public WebElement find_element(String element, String findBy) {
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
		case "class_name":
			webElement = driver.findElement(By.className(element));
			break;
		case "linkText":
			webElement = driver.findElement(By.linkText(element));
		}
		return webElement;
	}
	
	public void close_popup() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			log.debug("Closing popups");
			clickElement("//*[@data-action-type='DISMISS']", "xpath", driver);
//			log.info("popup closed");
		} catch (Exception e) {
			System.out.println("pop up not shown");
		}
	}
}
