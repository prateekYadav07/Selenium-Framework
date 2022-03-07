package com.framework.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.base.BaseClass;
import com.framework.utility.Log;

public class DemoQAHomePage extends BaseClass{
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	@FindBy(className = "banner-image")
	WebElement joinNowBanner;
	
	@FindBy(className = "tools-qa-header__logo")
	WebElement toolsQaLogo;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[2]")
	WebElement elementsCard;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[2]")
	WebElement formsCard;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[2]")
	WebElement alertsCard;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[4]/div/div[2]")
	WebElement widgetsCard;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[5]/div/div[2]")
	WebElement interactionsCard;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]/div/div[2]")
	WebElement booksCard;
	
	public DemoQAHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBanner() {
		Log.info("Join Now Banner clicked");
		joinNowBanner.click();
		
		String parentHandle = driver.getWindowHandle();
		Set<String> winHandles = driver.getWindowHandles();
		Iterator<String> itr = winHandles.iterator();
		
		while(itr.hasNext()) {
			String handle = itr.next();
			if(!parentHandle.equals(handle)) {
				driver.switchTo().window(handle);
				wait.until(ExpectedConditions.visibilityOf(toolsQaLogo));
				Assert.assertEquals(driver.getTitle(), getProperty("join_now_title"));
				Log.info("Redirected Page url verified");
				break;
			}
		}
	}
	
	public DemoQAElementsPage clickOnElementsCard() {
		js.executeScript("arguments[0].scrollIntoView();", elementsCard);
		elementsCard.click();
		Log.info("Elements card Clicked");
		
		return new DemoQAElementsPage();
	}
	
	public void verifyElementCardClick() {
		Assert.assertEquals(driver.getCurrentUrl(), getProperty("elements_page"));
		Log.info("Elements card click redirection verified");
	}
	
	public void clickOnFormsCard() {
		formsCard.click();
		Log.info("forms card clicked");
		Assert.assertEquals(driver.getCurrentUrl(), getProperty("forms_page"));
		Log.info("forms card redirection verified");
	}
	
	public DemoQAElementsPage clickOnAlertsCard() {
		alertsCard.click();
		Log.info("alert card clicked");
		
		return new DemoQAElementsPage();
	}
	
	public void verifyAlertsCardClick() {
		Assert.assertEquals(driver.getCurrentUrl(), getProperty("alerts_page"));
		Log.info("alert card redirection verified");
	}
	
	public DemoQAElementsPage clickOnWidgetsCard() {
		widgetsCard.click();
		Log.info("Widget Card clicked");
		
		return new DemoQAElementsPage();
	}
	
	public void verifyClickOnWidgetsButton() {
		Assert.assertEquals(driver.getCurrentUrl(), getProperty("widgets_page"));
		Log.info("widget card redirection verified");
	}
	
	public void clickOnInteractionsCard() {
		interactionsCard.click();
		Log.info("Interactions Card clicked");
		
		Assert.assertEquals(driver.getCurrentUrl(), getProperty("inter_page"));
		Log.info("Interactions card redirection verified");
	}
	
	public void clickOnBooksCard() {
		booksCard.click();
		Log.info("Books Card clicked");
		
		Assert.assertEquals(driver.getCurrentUrl(), getProperty("books_page"));
		Log.info("Books card redirection verified");
	}
}