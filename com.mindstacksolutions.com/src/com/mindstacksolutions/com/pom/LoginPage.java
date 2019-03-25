package com.mindstacksolutions.com.pom;

/**
 * @Loginpage
 * @linnkeddots
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mindstacksolutions.com.generics.BaseClass;


public class LoginPage extends BaseClass {

	By userNameTB = By.xpath("//input[@id='__xmlview1--userName-inner']");
	By passwordTB = By.xpath("//input[@id='__xmlview1--password-inner']");
	By clkDropdown = By.xpath("//span[@id='__xmlview1--site-arrow']");
	By clkTSK = By.xpath("//*[@id='__item4'][text()='TSK']");
	By clkLogin = By.xpath("//bdi[text()='Log In']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void testLogin(String Username, String password) {

		printText("This is Login Page ");
		waitForPageLoaded();
		enterText(userNameTB, Username);
		enterText(passwordTB, password);
		waitInSeconds(1);
		clickElement(clkDropdown);
		waitInSeconds(1);
		waitInSeconds(1);
		clickElement(clkLogin);

	}

}
