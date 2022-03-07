package com.framework.utility;

/*
* This class is responsible for handling Extent Reports. Extent report is an html file which consists of information
* regarding test cases, both passed and failed, which provides a convenient way for a tester to assess the situation and
* act upon. Its better than default TestNG reports in many ways.
* */

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.base.BaseClass;

public class ExtentReportsManager extends BaseClass{

	// Fields are necessarily marked as static for the reason provided in base class.
	
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	
	/*
	* First method to be invoked to initialize all the fields required would be setExtent. This method is invoked in
	* setupConfig in base class. It initializes all the Objects stated above before every single test class.
	* */
	
	public static void setExtent() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReports.html");
		//to create an extentReport object and attaching reporter
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//to set some of system information
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", getProperty("browser"));
		//configuration items to change the look and feel
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	// To flush the report this method is invoked in BaseClass with @AfterClass annotations
	public static void endReport() {
		extent.flush();
	}
	
		/*
		* This is a custom method which creates copy of every single extentReport with a separate copy named after every
		* test class. To use this, invoke this method in test classes with @AfterSuite annotations. Copied report would reside
		* in the path provided below in destPath field.
		* */
	public static void copyExtentReport(String testClassName) throws IOException{

		String srcPath =
		"C:\\Users\\PRATEEK\\eclipse-workspace\\Framework\\test-output\\ExtentReport\\MyReports.html";
		String destPath =
		"C:\\Users\\PRATEEK\\eclipse-workspace\\Framework\\test-output\\ExtentReport\\" + testClassName +".html";
		
		FileUtils.copyFile(new File(srcPath), new File(destPath));
	}
}
