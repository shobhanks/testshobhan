package com.ls.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.ls.generics.BaseTest;
import com.ls.generics.UtilityConstants;
import com.ls.pom.LoginPage;


public class ScriptLoginflow extends BaseTest {

	@Test
	public void testMethod() throws InterruptedException, InvalidFormatException, IOException {

		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);


	
	}

}
