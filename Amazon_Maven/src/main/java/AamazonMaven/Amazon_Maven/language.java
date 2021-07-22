package AamazonMaven.Amazon_Maven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class language {
	Actions action;
	TimeUnit time = TimeUnit.SECONDS;
	Logger log = LogManager.getLogger(language.class);
	private static Properties prop = new Properties();

	public void change_language(WebDriver driver) throws IOException, InterruptedException {

		FileInputStream prop_path = new FileInputStream(
				"C:\\Users\\112208\\eclipse-selenium-workspace\\Amazon_Maven\\src\\main\\java\\AamazonMaven\\Amazon_Maven\\chrome_locators.properties");
		prop.load(prop_path);
		log.info("Properties path attached");
		
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id(prop.getProperty("languageElement")))).build().perform();
		log.info("Move action performed to hover on language element");

		// loop to select expected language from dropdown
		List<WebElement> language = driver.findElements(By.xpath(prop.getProperty("languageDropDown")));
		
		for (WebElement lang : language) {
			String Lang_Text = lang.getText();
			if (Lang_Text.equalsIgnoreCase(prop.getProperty("ExpectedLanguage"))) {
				lang.click();
				log.info("Selected Language is " + Lang_Text);
				break;
			}
		}
	
	}
}
