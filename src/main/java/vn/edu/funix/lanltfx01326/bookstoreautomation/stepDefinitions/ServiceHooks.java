package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import vn.edu.funix.lanltfx01326.bookstoreautomation.enums.Browsers;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

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
