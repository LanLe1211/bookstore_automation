package vn.edu.funix.lanltfx01326.bookstoreautomation.testRunner;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

@CucumberOptions(
		features = "src/test/resources/OnlineBookstoreFeatures", 
		glue = {"vn/edu/funix/lanltfx01326/bookstoreautomation/stepDefinitions" }, 
		plugin = { "pretty",
				"html:target/cucumber-html-reports/report.html",
				"json:target/cucumber-reports/CucumberTestReport.json" })
public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeClass(alwaysRun = true)
	@Override
	public void setUpClass(ITestContext context) {
		super.setUpClass(context);
		TestBase.initDriverForBrowser("chrome");
	}

	@AfterClass(alwaysRun = true)
	@Override
	public void tearDownClass() {
		super.tearDownClass();
		WebDriver driver = TestBase.getCurrentWebDriver();
		if (driver != null) {
			driver.close();
		}
	}

}
