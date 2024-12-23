package com.cucumberFramework.stepDefinitions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.cucumberFramework.enums.Browsers;
import com.cucumberFramework.testBase.TestBase;

public class ServiceHooks {
	@BeforeSuite
	public void initializeTest() {
		TestBase.initDriverForBrowser(Browsers.CHROME.name());
	}
	
	@AfterSuite
	public void endTest() {   
		TestBase.getCurrentWebDriver().quit();
	}
}
