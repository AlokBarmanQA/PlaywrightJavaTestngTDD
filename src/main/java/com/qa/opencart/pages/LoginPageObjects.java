package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPageObjects {
	
	private Page page;
	
	public LoginPageObjects(Page page) {
		this.page = page;
	}
	
	private String textbox_EMail_Address="input#input-email";
	private String textbox_Password="input#input-password";
	private String btn_login = "//input[@value='Login']";
	private String link_forgot_password = "(//a[text()='Forgotten Password'])[1]";
	
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgotPasswordLinkExist() {
		return page.isVisible(link_forgot_password);
	}
	
	public void loginToApplication(String appUserName, String appPassword) {
		page.fill(textbox_EMail_Address, appUserName);
		page.fill(textbox_Password, appPassword);
		page.click(btn_login);
	}
}
