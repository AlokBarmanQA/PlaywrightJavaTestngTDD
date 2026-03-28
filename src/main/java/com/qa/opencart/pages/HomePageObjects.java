package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePageObjects {

	private Page page;
	
	public HomePageObjects(Page page) {
		this.page=page;
	}
	
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchProductHeader = "div#content h1";
	private String myAccountDropDown = "//span[text()='My Account']";
	private String registerLink = "//a[text()='Register']";
	private String loginLink = "//a[text()='Login']";
	
	
	public String getHomePageTitle() {
		String homepageTitle = page.title();
		System.out.println("Page title: "+homepageTitle);
		return homepageTitle;
	}
	
	public String getHomePageURL() {
		String homepageURL = page.url();
		System.out.println("Page URL: "+homepageURL);
		return homepageURL;
	}
	
	public String searchForProduct(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		String searchProductHeaderName = page.textContent(searchProductHeader);
		System.out.println("Search Product Header name: "+searchProductHeaderName);
		return searchProductHeaderName;
	}
	
	public LoginPageObjects navigateToLoginPage() {
		page.click(myAccountDropDown);
		page.click(loginLink);
		return new LoginPageObjects(page);
	}
	
	public void navigateToRegisterPage() {
		page.click(myAccountDropDown);
		page.click(registerLink);
	}
}
