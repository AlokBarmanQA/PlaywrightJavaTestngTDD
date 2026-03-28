
package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePageObjects;
import com.qa.opencart.pages.LoginPageObjects;

public class TestBase {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	protected HomePageObjects homePageObjects;
	protected LoginPageObjects loginPageObjects;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) {
		pf = new PlaywrightFactory();
		prop = pf.initializeProperties();
		if(browserName != null) {
			prop.setProperty("browser", browserName);
		}
		page = pf.initializeBrowser(prop);
		homePageObjects = new HomePageObjects(page);
	}
	
	@AfterTest
	public void tearDown() {
		//page.context().browser().close();
		// Clean up resources
        if (PlaywrightFactory.getPage() != null) {
        	PlaywrightFactory.getPage().close();
        }
        if (PlaywrightFactory.getPage() != null) {
        	PlaywrightFactory.getPlaywright().close();
        }
	}
	
}
