package com.amazon.testcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.methods.DriverMethods;
import com.amazon.pages.Home_page;


@Listeners(com.amazon.listeners.Listeners.class)
public class LanguageTest extends BaseTest {

	DriverMethods method = new DriverMethods();
//	WebDriver driver;
	Home_page language = new Home_page();

	@Test
	public void changeLanguage() throws IOException, InterruptedException {
		/*
		 * Test to change language of amazon site, currently it will change language to
		 * Português
		 **/
//		driver.get(prop.getProperty("webSite"));
		language.changeLanguage();

	}
}
