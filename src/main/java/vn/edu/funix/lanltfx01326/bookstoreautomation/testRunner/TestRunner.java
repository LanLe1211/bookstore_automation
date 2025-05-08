package vn.edu.funix.lanltfx01326.bookstoreautomation.testRunner;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

@CucumberOptions(
	features = "src/test/resources/OnlineBookstoreFeatures/login_admin.feature", 
	glue = {"vn/edu/funix/lanltfx01326/bookstoreautomation/stepDefinitions" }, 
	plugin = { 
		"pretty",
		"html:target/cucumber-reports/cucumber-pretty/report.html",
		"json:target/cucumber-reports/CucumberTestReport.json",
		"rerun:target/cucumber-reports/rerun.txt"
	}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context) {
    	super.setUpClass(context);
    	TestBase.initDriverForBrowser("chrome");
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
    	TestBase.getCurrentWebDriver().quit();
    }
}
