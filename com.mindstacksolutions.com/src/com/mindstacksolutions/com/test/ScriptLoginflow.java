package com.mindstacksolutions.com.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.mindstacksolutions.com.generics.BaseTest;
import com.mindstacksolutions.com.generics.UtilityConstants;
import com.mindstacksolutions.com.pom.LoginPage;


public class ScriptLoginflow extends BaseTest {

	@Test
	public void testMethod() throws InterruptedException, InvalidFormatException, IOException {

		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);


	
	}

}
