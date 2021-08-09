package com.amazon.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.pages.SignUp_page;



@Listeners(com.amazon.listeners.Listeners.class)
public class HomePage extends BaseTest {
	SignUp_page signUp = new SignUp_page();
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test
	public void signUp() throws IOException {
		/**
		 * This Test is used for signing up new user. Here webSite will be fetched from
		 * chrome_locators property file
		 **/
//		driver.get(prop.getProperty("webSite"));

		signUp.signUp();
	}

}
