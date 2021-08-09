package com.amazon.methods;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SupportMethods extends DriverMethods {

	WebElement webElement;

	public void sendText(String element, String findBy, WebDriver driver, String text) {
		/**
		 * Method to write on element
		 * 
		 * @param element - element's path i.e. locator
		 * @param findBy  - using which findBy method we can find element, it can be id,
		 *                className, css, xpah, etc.
		 * @param driver  - WebDriver's object
		 * @param text    - String to write on element
		 */
		webElement = find_Element(element, findBy, driver);
		sendKeys(webElement, text);
	}

	public void clickElement(String element, String findBy, WebDriver driver) {
		/**
		 * Method to click on element
		 * 
		 * @param element - element's path i.e. locator
		 * @param findBy  - using which findBy method we can find element, it can be id,
		 *                className, css, xpah, etc.
		 * @param driver  - WebDriver's object
		 */
		webElement = find_Element(element, findBy, driver);
		clickOnElement(webElement);
	}

	public void enter(String element, String findBy, WebDriver driver) {
		/**
		 * Method to press Enter
		 * 
		 * @param element - element's path i.e. locator
		 * @param findBy  - using which findBy method we can find element, it can be id,
		 *                className, css, xpah, etc.
		 * @param driver  - WebDriver's object
		 */
		webElement = find_Element(element, findBy, driver);
		pressEnter(webElement);
	}

	public void performAction(WebDriver driver, String element, String findBy) {
		/**
		 * Method to hover mouse on element
		 * 
		 * @param element - element's path i.e. locator
		 * @param findBy  - using which findBy method we can find element, it can be id,
		 *                className, css, xpah, etc.
		 * @param driver  - WebDriver's object
		 */
		Actions action;
		action = new Actions(driver);
		webElement = find_Element(element, findBy, driver);
		hoverAction(webElement, action); // have to put switch statements or define each action methods separately
	}

	public void dpSelect(String element, String findBy, String expectedLanguage, WebDriver driver) {
		/**
		 * Method for selecting particular element from drop down
		 * 
		 * @param element          - element's path i.e. locator
		 * @param findBy           - using which findBy method we can find element, it
		 *                         can be id, className, css, xpah, etc.
		 * @param expectedLanguage - To Which we wanted to change language
		 * @param driver           - WebDriver's object
		 */
		List<WebElement> options = find_Elements(element, findBy, driver);

		for (WebElement op : options) {
			String op_text = op.getText();
			if (op_text.equalsIgnoreCase(expectedLanguage)) {
				op.click();
				break;
			}
		}
	}

	public String getText(String element, String string, WebDriver driver) {
		/**
		 * Fetch element's text
		 * 
		 * @param element - element's path i.e. locator
		 * @param findBy  - using which findBy method we can find element, it can be id,
		 *                className, css, xpah, etc.
		 * @param driver  - WebDriver's object
		 */
		String text = find_Element(element, string, driver).getText();

		return text;
	}

}
