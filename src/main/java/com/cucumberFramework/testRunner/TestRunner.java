package com.cucumberFramework.testRunner;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cucumberFramework.testBase.TestBase;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/test/resources/OrderingFeatures", 
	glue = {"com/cucumberFramework/stepDefinitions" }, 
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
