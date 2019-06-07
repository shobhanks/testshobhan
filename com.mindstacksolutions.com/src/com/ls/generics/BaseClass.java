package com.ls.generics;

/**
 * @linkeddots
 * @BaseClass -- reusable methods   
 * 
 */

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BaseClass {
	public WebDriver driver;
	public WebDriverWait wait;

	public BaseClass() {
		PageFactory.initElements(driver, this);
	}

	// ================================================================================
	// Start of page general methods 1st set
	// ================================================================================

	// Print a message
	public void printText(String text) {
		Reporter.log(text, true);
	}

	// Waiting in seconds
	public void waitInSeconds(int seconds) {
		try {
			// printText("waiting for "+seconds+"seconds");
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	// to find the element
	public WebElement findElement(By byLocator) {
		WebElement element = driver.findElement(byLocator);
		return element;
	}

	// to find the elements
	public List<WebElement> findElements(By byLocator) {
		List<WebElement> element = driver.findElements(byLocator);
		return element;
	}

	// to click on the element
	public void clickElement(By byLocator) {
		waitUntilLoadedAndElementClickable(byLocator);
		waitUntilLoadedAndVisibilityOfElementLocated(byLocator);
		driver.findElement(byLocator).click();
	}

	public void clickElement1(By byLocator) {
		driver.findElement(byLocator).click();
	}

	// to enter values in the textbox
	public void enterText(By byLocator, String text) {
		driver.findElement(byLocator).sendKeys(text);
	}

	// to clear the text present in the textbox
	public void clearText(By byLocator) {
		driver.findElement(byLocator).clear();
	}

	// to find the element Text
	public String getElementText(By byLocator) {
		return driver.findElement(byLocator).getText();
	}

	public ArrayList<String> getElementTexts(By byLocator) {
		List<WebElement> ele1 = findElements(byLocator);
		ArrayList<String> al1 = new ArrayList<String>();
		for (WebElement element : ele1) {
			String d1 = element.getText();
			System.out.println(d1);
			al1.add(d1);
		}
		return al1;
	}

	// to check element is displayed or not
	public Boolean isElementDisplayed(By byLocator) {
		return driver.findElement(byLocator).isDisplayed();
	}

	// to check radio button.. is enabled or not
	public Boolean isElementEnabled(By byLocator) {
		return driver.findElement(byLocator).isEnabled();
	}

	// to check checkbox button.. is enabled or not
	public Boolean isElementSelected(By byLocator) {
		return driver.findElement(byLocator).isSelected();
	}

	// to get the Screenshot
	public void takeScreensnap() {

		String filePath = "/Extras/Screenshot";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			FileHandler.copy(scrFile, new File(filePath + getDate() + getCurrentTime() + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Alert getAlertMethods() {
		Alert alert = driver.switchTo().alert();
		return alert;

	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	// ================================================================================
	// End of page general methods 1st set
	// ================================================================================

	// ================================================================================
	// Start of page general methods 2nd set
	// ================================================================================

	// to get the Current time
	public String getCurrentTime() {

		String timeformat = "HH:mm:ss a";
		SimpleDateFormat formatter1 = new SimpleDateFormat(timeformat);
		Date time = new Date();
		System.out.println(formatter1.format(time));
		return timeformat;
	}

	// to get the Current Date
	public String getDate() {

		String dateformat = "dd/MM/yyyy";
		SimpleDateFormat formatter1 = new SimpleDateFormat(dateformat);
		Date date = new Date();
		System.out.println(formatter1.format(date));
		return formatter1.format(date);
	}

	// to get the Current Date
	public String getCustomisedDate(int incdecDays) {

		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // declare as DateFormat
		Calendar today = Calendar.getInstance();
		Calendar y = Calendar.getInstance();
		y.add(Calendar.DATE, incdecDays);
		Date d = y.getTime(); // get a Date object
		String yesDate = sdf.format(d); // toString for Calendars is mostly not really useful
		// System.out.println(yesDate);
		return yesDate;
	}

	// ================================================================================
	// End of page general methods 2nd set
	// ================================================================================

	// =================================================================================
	// Wait methods Start
	// =================================================================================

	public void waitAndGetTitle(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleIs(expectedTitle));
	}

	public void waitUntilLoadedAndElementClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitUntilLoadedAndElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilLoadedAndPresenceOfElementLocated(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitUntilLoadedAndPresenceOfAllElementsLocated(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void waitUntilLoadedAndStalenessOffElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
	}

	public void waitUntilLoadedAndTextToBePresentInElementLocated(By locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public void waitUntilLoadedAndTextToBePresentInElementLocated(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void waitUntilLoadedAndVisibilityOfElementLocated(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitUntilLoadedAndVisibilityOfElementLocated(By element) {
		WebElement ele = findElement(element);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	// ================================================================================
	// END of wait methods
	// ================================================================================

	// ================================================================================
	// Start of page action methods
	// ================================================================================

	public void hoverAndClick(WebElement mainElement, WebElement subElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(mainElement).moveToElement(subElement).click().build().perform();
	}

	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).doubleClick().perform();
	}

	// ================================================================================
	// END of page action methods
	// ================================================================================

	// extras added methods

	// to get the Number from the string
	public String getNumber(By byLocator) {
		String v = driver.findElement(byLocator).getText();
		String numberOnly = v.replaceAll("[^0-9]", "");
		return numberOnly;
	}

	public void scrollBy(By byLocator) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(byLocator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println(element.getText());

	}

}
