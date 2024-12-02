package com.cucumberFramework.stepDefinitions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.cucumberFramework.enums.Browsers;
import com.cucumberFramework.testBase.TestBase;

public class ServiceHooks {
	TestBase testBase;
	@BeforeMethod
	public void initializeTest() {
		testBase = new TestBase();
		testBase.initDriverForBrowser(Browsers.CHROME.name());
	}
	
	@AfterMethod
	public void endTest() {   
		testBase.getCurrentWebDriver().quit();
	}
}
