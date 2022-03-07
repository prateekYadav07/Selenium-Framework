package com.framework.testCases;

import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.pageobjects.DemoQAHomePage;
import com.framework.utility.ExtentReportsManager;
import com.framework.utility.Log;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class DemoQAHomePageTest extends BaseClass {
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		driver.get(getProperty("demoqa_url"));
	}

	@AfterSuite
	public void report() throws IOException {
		ExtentReportsManager.copyExtentReport("DemoQAHomePageTest");
	}

	@Test
	public void t1_BannerClickRedirectsToPage() {
		Log.startOfTestCase("t1_BannerClickRedirectsToPage");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		dqaHomePage.clickOnBanner();
		Log.endOfTestCase("t1_BannerClickRedirectsToPage");
	}

	@Test
	public void t2_ElementsCardClickVerification() {
		Log.startOfTestCase("t2_ElementsCardClickVerification");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		dqaHomePage.clickOnElementsCard();
		dqaHomePage.verifyElementCardClick();
		Log.endOfTestCase("t2_ElementsCardClickVerification");
	}

	@Test
	public void t3_FormsCardClickVerification() {
		Log.startOfTestCase("t3_FormsCardClickVerification");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		dqaHomePage.clickOnFormsCard();
		Log.endOfTestCase("t3_FormsCardClickVerification");
	}

	@Test
	public void t4_AlertWindowsClickVerification() {
		Log.startOfTestCase("t4_AlertWindowsClickVerification");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		dqaHomePage.clickOnAlertsCard();
		dqaHomePage.verifyAlertsCardClick();
		Log.endOfTestCase("t4_AlertWindowsClickVerification");
	}

	@Test
	public void t5_WidgetsClickVerification() {
		Log.startOfTestCase("t5_WidgetsClickVerification");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		dqaHomePage.clickOnWidgetsCard();
		dqaHomePage.verifyAlertsCardClick();
		Log.endOfTestCase("t5_WidgetsClickVerification");
	}

	@Test
	public void t6_InteractionsClickVerification() {
		Log.startOfTestCase("t6_InteractionsClickVerification");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		dqaHomePage.clickOnInteractionsCard();
		Log.endOfTestCase("t6_InteractionsClickVerification");
	}

	@Test
	public void t7_BooksCardClickVerification() {
		Log.startOfTestCase("t7_BooksCardClickVerification");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		dqaHomePage.clickOnBooksCard();
		Log.endOfTestCase("t7_BooksCardClickVerification");
	}
}
