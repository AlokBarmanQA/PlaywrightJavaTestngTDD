package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.TestBase;
import com.qa.opencart.constants.AppEnum;

public class LoginPageTests extends TestBase {

	@Test(priority = 1)
	public void loginPageNavigationTest() {
		loginPageObjects = homePageObjects.navigateToLoginPage();
		String actualLoginPageTitle = loginPageObjects.getLoginPageTitle();
		System.out.println("Login page actual title: "+actualLoginPageTitle);
		Assert.assertEquals(actualLoginPageTitle, AppEnum.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyForgotPasswordLinkTest() {
		Assert.assertTrue(loginPageObjects.isForgotPasswordLinkExist());
	}
	
	@Test(priority = 3)
	public void applicationLoginTest() {
		loginPageObjects.loginToApplication(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
}
