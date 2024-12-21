package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import vn.edu.funix.lanltfx01326.bookstoreautomation.enums.Browsers;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

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
