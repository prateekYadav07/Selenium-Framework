package com.framework.actiondriver;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.framework.base.BaseClass;

public class Action extends BaseClass implements ActionInterface {

	public void click(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}

	public String getCurrentUrl(WebDriver driver) {
		String text = driver.getCurrentUrl();
		return text;
	}

	public String getTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}

	public void getScreenshot(WebDriver driver, String fileName) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshot\\" + fileName + "_" + dateName + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean isElementDisplayed(WebElement element) {
		boolean flag = false;
		flag = element.isDisplayed();
		if(flag) {
			System.out.println("ELement is displayed");
		}
		else {
			System.out.println("Element is not displayed");
		}
		return flag;
	}


	public void typeText(WebElement element, String text) {
		boolean flag = false;
		if (element.isDisplayed()) {
			element.sendKeys(text);
			flag = true;
		}
		if (flag)
			System.out.println(text + " entered");
		else {
			System.out.println(text + " not entered");
		}
	}

	/*
	 * public void implicitWait(WebDriver driver, int timeout) {​​​
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 *
	 * }​​​
	 */
	public void verifyVisible(WebElement element) {
		boolean found = false;
		found = element.isDisplayed();
		Assert.assertTrue(found);
	}
	
	public void verifyNotVisible(WebElement element) {
		boolean flag = true;
		flag = element.isDisplayed();
		Assert.assertFalse(flag);
	}
}
