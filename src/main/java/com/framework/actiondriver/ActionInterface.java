package com.framework.actiondriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	public void click(WebDriver driver, WebElement element);

	public void typeText(WebElement element, String text);

	public String getCurrentUrl(WebDriver driver);

	public String getTitle(WebDriver driver);

	public void getScreenshot(WebDriver driver, String fileName);

	public boolean isElementDisplayed(WebElement element);

// public void fluentWait(WebDriver driver, WebElement element, int timeout);
// public void implicitWait(WebDriver driver,int timeout);
//	public void explicitWait(WebDriver driver, WebElement element, int timeout);

// public void pageLoadTimeout(WebDriver driver, int timeout);
	public void verifyVisible(WebElement element);

	public void verifyNotVisible(WebElement element);
}
