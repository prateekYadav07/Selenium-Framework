package com.framework.testCases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.pageobjects.DemoQAElementsPage;
import com.framework.pageobjects.DemoQAHomePage;
import com.framework.utility.ExtentReportsManager;
import com.framework.utility.Log;

public class ElementsPageTest extends BaseClass {

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		driver.get(getProperty("demoqa_url"));
	}

	@AfterSuite
	public void report() throws IOException {
		ExtentReportsManager.copyExtentReport("ElementsPageTest");
	}

	@Test
	public void t1_visibilityOfTextArea() {
		Log.startOfTestCase("visibilityOfTextArea");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		DemoQAElementsPage dqaElmPage = dqaHomePage.clickOnElementsCard();
		dqaElmPage.selectTextArea();
		dqaElmPage.enterUsername();
		dqaElmPage.clickSubmit();
		dqaElmPage.verifyVisibilityOfTextArea();
		Log.endOfTestCase("visibilityOfTextArea");
	}

	@Test
	public void t2_visibilityOfResultSpanAfterCheckBoxChecked() {
		Log.startOfTestCase("visibilityOfResultSpanAfterCheckBoxChecked");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		DemoQAElementsPage dqaElmPage = dqaHomePage.clickOnElementsCard();
		dqaElmPage.selectCheckBox();
		dqaElmPage.checkCheckBox();
		dqaElmPage.verifyVisibilityOfResult();
		Log.endOfTestCase("visibilityOfResultSpanAfterCheckBoxChecked");
	}

	@Test
	public void t3_allThreeRadioButtonsWork() {
		Log.startOfTestCase("allThreeRadioButtonsWork");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		DemoQAElementsPage dqaElmPage = dqaHomePage.clickOnElementsCard();
		dqaElmPage.selectRadioBtn();
		dqaElmPage.clickYesRadioBtn();
		dqaElmPage.verifyYesMsg();
// dqaElmPage.clickImprRadioBtn();
// dqaElmPage.verifyImprMsg();
		dqaElmPage.verifyNoRadioBtnDisabled();
		Log.endOfTestCase("allThreeRadioButtonsWork");
	}

	@Test
	public void t4_progressBar() {
		Log.startOfTestCase("progrssBar");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		DemoQAElementsPage dqaElmPage = dqaHomePage.clickOnWidgetsCard();
		dqaElmPage.clickOnProgressBar();
		dqaElmPage.clickOnStartBtn();
		dqaElmPage.verifyResetButton();
		Log.endOfTestCase("progrssBar");
	}

	@Test
	public void t5_alertWindows() {
		Log.startOfTestCase("alertWindows");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		DemoQAElementsPage dqaElmPage = dqaHomePage.clickOnAlertsCard();
		dqaElmPage.clickOnAlertsSpan();
		dqaElmPage.clickOnAlertBtn();
		dqaElmPage.verifyAlert();
		dqaElmPage.clickAndVerifyConfirmAlertButton();
		Log.endOfTestCase("alertWindows");
	}

	@Test
	public void t6_APILinksVerification() {
		Log.startOfTestCase("APILinksVerification");
		DemoQAHomePage dqaHomePage = new DemoQAHomePage();
		DemoQAElementsPage dqaElmPage = dqaHomePage.clickOnElementsCard();
		dqaElmPage.clickOnLinks();
		dqaElmPage.clickAndVerifyAPILinks();
		Log.endOfTestCase("APILinksVerification");
	}
}