package com.framework.pageobjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.base.BaseClass;
import com.framework.utility.Log;

public class UrlAndTitle extends BaseClass{
	
	public UrlAndTitle() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyingActualAndExpectedTitle(String url, String title) {
		driver.get(url);
		Log.info("Url launched");
		
		System.out.println(url +" = " + title);
		
		Assert.assertEquals(driver.getTitle(), title);
		Log.info("Title Verified");
	}

}