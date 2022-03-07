package com.framework.testCases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.datadriver.DataProviders;
import com.framework.pageobjects.UrlAndTitle;
import com.framework.utility.ExtentReportsManager;
import com.framework.utility.Log;

public class PagesTesting extends BaseClass{
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	
	@AfterSuite
	public void report() throws IOException {
		ExtentReportsManager.copyExtentReport("PagesTesting");
	}
	
	
	@Test(dataProvider = "titleVerification", dataProviderClass = DataProviders.class)
	public void t1_titleVerification(String url, String title) {
		Log.startOfTestCase("titleVerification");
		UrlAndTitle urt = new UrlAndTitle();
		urt.verifyingActualAndExpectedTitle(url, title);
		Log.endOfTestCase("titleVerification");
	}
	
}
