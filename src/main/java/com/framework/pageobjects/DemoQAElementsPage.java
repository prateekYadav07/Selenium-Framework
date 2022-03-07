package com.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.base.BaseClass;
import com.framework.utility.Log;

public class DemoQAElementsPage extends BaseClass{
	
	@FindBy(css = "#close-fixedban")
	WebElement adClose;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]")
	WebElement textAreaSpan;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div")
	WebElement printField;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/input")
	WebElement usernameFld;
	
	@FindBy(css = "#submit")
	WebElement submitBtn;

	@FindBy(xpath = "//*[@id=\"item-1\"]")
	WebElement checkBoxSpan;
	
	@FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")
	WebElement checkBox;
	
	@FindBy(xpath = "//*[@id=\"item-1\"]/span")
	WebElement resultSpan;
	
	@FindBy(xpath = "//*[@id=\"item-2\"]/span")
	WebElement radioBtnSpan;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label")
	WebElement yesRadioBtn;
	
	@FindBy(id = "impressiveRadio")
	WebElement impressiveRadioBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[4]/input")
	WebElement noRadioBtn;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span")
	WebElement yesSpan;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span")
	WebElement imprSpan;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/span/div")
	WebElement widgetSpan;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[5]")
	WebElement progressBar;
	
	@FindBy(xpath = "//*[@id=\"startStopButton\"]")
	WebElement startButton;
	
	@FindBy(id = "resetButton")
	WebElement resetBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]")
	WebElement alertsSpan;
	
	@FindBy(css = "#alertButton.btn.btn-primary")
	WebElement alertBtn;
	
	@FindBy(css = "#confirmButton")
	WebElement confirmButton;
	
	@FindBy(css = "#confirmButton")
	WebElement confirmAlertText;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[6]")
	WebElement linksSpan;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[3]/a")
	WebElement createdLink;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[10]")
	WebElement apiResult;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[6]/a")
	WebElement badRequest;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[5]/a")
	WebElement moved;
	
	public DemoQAElementsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//------------------------------------------
	
	public void selectTextArea() {
		adClose.click();
		Log.info("Ad Panel closed Down");
		
		textAreaSpan.click();
		Log.info("text area clicked");
	}
	
	public void enterUsername() {
		usernameFld.sendKeys(getProperty("elmPageUname"));
		Log.info("username entered");
	}
	
	public void clickSubmit() {
		js.executeScript("arguments[0].scrollIntoView()", submitBtn);
		submitBtn.click();
		Log.info("submit button clicked");
	}
	
	public void verifyVisibilityOfTextArea() {
		waitUntil(printField, driver);
		Assert.assertTrue(printField.isDisplayed());
		Log.info("Text Area Visibility verified");
	}
	
	//-------------------------------------------
	
	public void selectCheckBox() {
		js.executeScript("arguments[0].scrollIntoView()", checkBoxSpan);
		checkBoxSpan.click();
		Log.info("Check Box selected");
	}
	
	public void checkCheckBox() {
		js.executeScript("arguments[0].scrollIntoView()", checkBox);
		checkBox.click();
		Log.info("Check Box checked");
	}
	
	public void verifyVisibilityOfResult() {
		Assert.assertTrue(resultSpan.isDisplayed());
		Log.info("'You have selected Check Box' span is visible");
	}
	
	//-------------------------------------------
	
	public void selectRadioBtn() {
		adClose.click();
		Log.info("Ad Panel closed Down");
		
		js.executeScript("arguments[0].scrollIntoView()", radioBtnSpan);
		radioBtnSpan.click();
		Log.info("Radio button span selected");
	}
	
	public void clickYesRadioBtn() {
		js.executeScript("arguments[0].scrollIntoView()", yesRadioBtn);
		
		yesRadioBtn.click();
		Log.info("Yes Btn clicked");
	}
	
	public void verifyYesMsg() {
		Assert.assertEquals(yesSpan.getText(), "Yes");
		Log.info("Yes Button Verified");
	}
	
	public void clickImprRadioBtn() {
		js.executeScript("arguments[0].scrollIntoView()", impressiveRadioBtn);
		
		impressiveRadioBtn.click();
		Log.info("impressive radio button clicked");
	}
	
	public void verifyImprMsg() {
		Assert.assertEquals(imprSpan.getText(), "Impressive");
		Log.info("Impressive button verified");
	}
	
	public void verifyNoRadioBtnDisabled() {
		Assert.assertFalse(noRadioBtn.isEnabled());
		Log.info("Verified that No Button is disabled");
	}
	
	//------------------------------------
	
	public void clickOnProgressBar() {
		adClose.click();
		Log.info("Ad Panel closed Down");
		
		waitUntil(progressBar, driver);
		progressBar.click();
		Log.info("Progrss Bar clicked");
	}
	
	public void clickOnStartBtn() {
		waitUntil(startButton, driver);
		startButton.click();
		Log.info("Start Button clicked");
	}
	
	public void verifyResetButton() {
		waitUntil(resetBtn, driver);
		Assert.assertTrue(resetBtn.isDisplayed());
		Log.info("Reset Button appears");
	}
	
	//------------------------------------
	
	public void clickOnAlertsSpan() {
		adClose.click();
		Log.info("Ad Panel closed Down");
		
		alertsSpan.click();
		Log.info("Alerts Clicked");
	}
	
	public void clickOnAlertBtn() {
		waitUntil(alertBtn, driver);
		alertBtn.click();
		Log.info("Alert Button pressed");
	}
	
	public void verifyAlert() {
		driver.switchTo().alert().accept();
		Log.info("Alert window verified");
	}
	
	public void clickAndVerifyConfirmAlertButton() {
		waitUntil(confirmButton, driver);
		confirmButton.click();
		Log.info("Confirm Button Pressed");

		driver.switchTo().alert().accept();
		Log.debug("ALert accepted: "+ confirmAlertText.getText());
		
		confirmButton.click();
		Log.info("Confirm Button clicked Again");
		
		driver.switchTo().alert().dismiss();
		Log.debug("Alert Rejected: "+ confirmAlertText.getText());
	}
	
	//-------------------------------------
	
	public void clickOnLinks() {
		adClose.click();
		Log.info("Ad Panel closed Down");
		
		linksSpan.click();
		Log.info("Links Span Clicked");
	}
	
	public void clickAndVerifyAPILinks() {
		createdLink.click();
		Log.info("Created link clicked");
		waitUntil(apiResult, driver);
		Assert.assertTrue(apiResult.isDisplayed());
		Log.info("Result: "+apiResult.getText());
		
		badRequest.click();
		Log.info("Bad Request clicked");
		Assert.assertTrue(apiResult.isDisplayed());
		Log.info("Result: "+ apiResult.getText());
		
		moved.click();
		Log.info("Moved clicked");
		Assert.assertTrue(apiResult.isDisplayed());
		Log.info("Result: "+apiResult.getText());
		
	}
}
