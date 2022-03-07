package com.framework.base;

/*
 * This framework has been developed by Prateek Yadav.
 * It is a hybrid framework which uses keyword as well as data from external files for test scripts.
 * It consists of different Packages with different classes having different functionalities required, which are
 * rigorously tested, to automate scripts using selenium WebDriver.
 *
 * Wrapper Classes are in progress and will be added soon.
 * */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.framework.utility.ExtentReportsManager;
import com.framework.utility.Log;

/*
 * Base Class consists of all the necessary functionalities required for selenium web driver
 * It also has some helper methods which can be used in Page Objects and Tests
 * Also This class is parent class of every single class in this framework including testClasses (except ExtentManager)
 * */

public class BaseClass {

	/*
	 * These fields and some other fields in entire framework can be seen with
	 * static modifier so as to facilitate a consistent access of unique and
	 * consistent fields for every single class.
	 */

	public static Properties properties;
	public static WebDriver driver;
	public static ChromeOptions chromeOptions = new ChromeOptions();
	public static JavascriptExecutor js;
	public static WebDriverWait wait;

	/*
	 * setUpConfig method would be to first one to be invoked in every single
	 * testClass It initializes properties and extent Manager via respective helper
	 * methods preset in individual classes It also initiates Log configuration for
	 * the storage of logs
	 */
	@BeforeSuite
	public void setUpConfig() {
		PropertyConfigurator
				.configure(getProperty("log4j"));
		Log.debug(" *** log.Properties file is loaded ***");
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream(new File(getProperty("config")));
			properties.load(ip);
			ExtentReportsManager.setExtent();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

// A helper method to fetch values from properties file using keys
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	/*
	 * This method facilitates launch of different browsers specified by user in
	 * properties file It also initialize JavaScriptExecutor object which can be
	 * used to perform different functions on Web page. Every test class must invoke
	 * this method with annotation @BeforeMethod to initialize a driver and js
	 * object otherwise NullPointerExpection will be thrown.
	 */
	public void launchBrowser() {
		String browserName = properties.getProperty("browser");
		chromeOptions.addArguments("--headless","--window-size=1920,1080");
		if (browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
		} else if (browserName.contains("FireFox")) {
			System.setProperty("webdriver.firefox.driver", getProperty("geckodriver"));
			driver = new FirefoxDriver();
		} else if (browserName.contains("Edge")) {
			System.setProperty("webdriver.edge.driver",getProperty("edgedriver"));
			driver = new EdgeDriver();
		}
		js = (JavascriptExecutor) driver;
		System.out.println("driver: " + driver);
	}

	/*
	 * Also a helper method to invoke explicitWait (by default) with 30 seconds of
	 * waiting time with 500 milliseconds interval. It takes an active driver and
	 * element as input and returns nothing It can (should) be used in PageObjects
	 * as well as TestClasses
	 */
	public static void waitUntil(WebElement element, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * Helper Method to invoke implicit wait which takes driver object and seconds
	 * as input ideally time should be around 10 seconds but user has freedom to
	 * provide as per requirement
	 */
	public static void implicitWait(WebDriver driver, int timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	/*
	 * This is the last method that would be invoked after every test in test
	 * classes. user should not explicitly invoke this method, It would be invoked
	 * automatically.
	 */
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	/*
	 * This method flushes the extent report and creates an html file in provided
	 * location. It uses an helper method endReport() which is defined in
	 * ExtentReportManager class.
	 */
	@AfterClass
	public void afterSuite() throws IOException {
		ExtentReportsManager.endReport();
	}
}
