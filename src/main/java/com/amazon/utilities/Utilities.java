package com.amazon.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.amazon.base.Base;

public class Utilities {

	public String captureScreenShot(String testCaseName, WebDriver driver) {
		/*
		 * This method is used to capture screenshot and save it in reports folder
		 */
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String screenShotName = System.getProperty("user.dir") + "\\reports\\" + testCaseName + "-" + timeStamp()
				+ ".png";
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");

			FileUtils.copyFile(source, new File(screenShotName));

			String filePath = screenShotName.toString();
			System.out.println(filePath);

			Reporter.log("<a target=\"_blanck\" href=" + screenShotName + ">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blanck\" href=" + screenShotName + "><img src=\" " + screenShotName
					+ " \"' height='400' width='400'/> </a>");
//			Reporter.log(
//					"<a href="+ screenShotName +"> Screenshot </a>");
//			Reporter.log("<br>");
//			Reporter.log("<a href="+ screenShotName +"<img src="+screenShotName+"</a>");
//			Reporter.log(path);
//			Reporter.log("<br>  <img src='" + screenShotName + "' height='100' width='100' /><br>");
//			Reporter.log("<a href=" + screenShotName + "></a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenShotName;

	}

	public static String timeStamp() {
		// This method returns timeStamp
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	}
}
