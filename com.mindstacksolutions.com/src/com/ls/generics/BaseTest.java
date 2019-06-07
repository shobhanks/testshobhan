package com.ls.generics;


/**
 * @linkeddots
 * @BaseTest
 * Annototion : @BeforeMethod and @AfterMethod 
 *
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		System.out.println("open the browser");
		System.setProperty(UtilityConstants.CHROME_KEY, UtilityConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.get(UtilityConstants.URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
	}

//	@AfterMethod
//	public void afterMethod() {
//		driver.manage().deleteAllCookies();
//		System.out.println("Close the browser");
//		driver.close();
//		driver.quit();
//	}

}

