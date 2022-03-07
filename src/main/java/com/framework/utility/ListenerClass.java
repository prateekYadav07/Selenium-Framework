package com.framework.utility;

/*
 * This listener class acts like an agent which adds every single instruction being executed during automation 
 * test script into Extent Reports. use this in xml suite with tag listener and provide full class name. It uses
 * ITestListener interface to provide input data for extent reports
 * */

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerClass extends ExtentReportsManager implements ITestListener{
	
	// invoked after test class is instantiated and before execution of any testNG method
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}
	
	// invoked on the success of a test
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test case Passed", ExtentColor.GREEN));
		}
	}
	
	// invoked on the failure of a test
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test case Failed", ExtentColor.RED));
			
			try {
				String imgPath = saveScreenshot(result.getName());
				test.fail("Screenshot attached: "+MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	 
	// invoked when a test is skipped
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test case Skipped", ExtentColor.YELLOW));
		}
	}
	
	// this method saves a screenshot and returns its path
	public String saveScreenshot(String fileName) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imgPath = "C:\\Users\\PRATEEK\\eclipse-workspace\\Framework\\Screenshot\\" + fileName +".png";
		File scrPath =new File(imgPath);
		
		FileUtils.copyFile(srcFile, scrPath);
		
		return imgPath;
	}
}
