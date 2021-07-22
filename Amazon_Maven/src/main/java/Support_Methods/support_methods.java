package Support_Methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class support_methods {

	public WebDriver driver;

	public void clickElement(String element, String findBy, WebDriver driver) {
		switch (findBy) {
		case "xpath":
			driver.findElement(By.xpath(element)).click();
			break;
		case "id":
			driver.findElement(By.id(element)).click();
			break;
		case "css":
			driver.findElement(By.cssSelector(element)).click();
			break;
		case "name":
			driver.findElement(By.name(element)).click();
			break;
		case "class_name":
			driver.findElement(By.className(element)).click();
			break;
		case "linkText":
			driver.findElement(By.linkText(element)).click();
		}

	}

	public void sendKeys(String element, String write, String findby, WebDriver driver) {
		switch (findby) {

		case "xpath":
			driver.findElement(By.xpath(element)).sendKeys(write);
			break;
		case "id":
			driver.findElement(By.id(element)).sendKeys(write);
			break;
		case "css":
			driver.findElement(By.cssSelector(element)).sendKeys(write);
			break;
		case "name":
			driver.findElement(By.name(element)).sendKeys(write);
			break;
		case "class_name":
			driver.findElement(By.className(element)).sendKeys(write);
			break;
		case "linkText":
			driver.findElement(By.linkText(element)).sendKeys(write);
			break;
		}

	}

	public void pressEnter(String element, String findby, WebDriver driver) {
		switch (findby) {

		case "xpath":
			driver.findElement(By.xpath(element)).sendKeys(Keys.ENTER);
			break;
		case "id":
			driver.findElement(By.id(element)).sendKeys(Keys.ENTER);
			break;
		case "css":
			driver.findElement(By.cssSelector(element)).sendKeys(Keys.ENTER);
			break;
		case "name":
			driver.findElement(By.name(element)).sendKeys(Keys.ENTER);
			break;
		case "class_name":
			driver.findElement(By.className(element)).sendKeys(Keys.ENTER);
			break;
		case "linkText":
			driver.findElement(By.linkText(element)).sendKeys(Keys.ENTER);
		}
	}
	public void close_popup() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			log.debug("Closing popups");
//			driver.findElement(By.xpath("//*[@data-action-type='DISMISS']")).click();
			clickElement("//*[@data-action-type='DISMISS']", "xpath", driver);
//			log.info("popup closed");
		} catch (Exception e) {
			System.out.println("pop up not shown");
		}
	}
}
