package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.TestBase;
import com.qa.opencart.constants.AppEnum;

public class HomePageTests extends TestBase {
	
	@Test
	public void homePageTitleTest() {
		String actualTitle = homePageObjects.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppEnum.HOME_PAGE_TITLE);
	}
	
	@Test
	public void homePageURLTest() {
		String actualURL = homePageObjects.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "Macbook" }, { "HP" }, { "Samsung" } };
	}

	@Test(dataProvider = "getProductData")
	public void searchProductTest(String product) {
		String actualProductHeader = homePageObjects.searchForProduct(product);
		Assert.assertEquals(actualProductHeader, "Search - " + product);
	}

	
}
