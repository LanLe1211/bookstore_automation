package com.cucumberFramework.testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(features = "src/test/resources/OrderingFeatures", glue = {
		"com/cucumberFramework/stepDefinitions" }, plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty/report.html",
				"json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt" })
public class TestRunner extends AbstractTestNGCucumberTests{


}
