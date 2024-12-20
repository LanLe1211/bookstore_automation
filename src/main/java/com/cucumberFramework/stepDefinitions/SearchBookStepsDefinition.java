package com.cucumberFramework.stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumberFramework.enums.Browsers;
import com.cucumberFramework.pageObjects.HomePage;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBookStepsDefinition extends TestBase {
	private static Logger logger = LogManager.getLogger(SearchBookStepsDefinition.class);
	private HomePage homePage = new HomePage(driver);
	
	@Given("User is on bookstore homepage {string}")
	public void user_is_on_hrm_login_page(String string) {
		WebDriver driver = this.getCurrentWebDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(string);
	}
	@When("I enter keyword as {string}")
	public void i_enter_keyword_as(String string) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage(driver);
		homePage.enterSearchText(string);
		homePage.submitSearch();
	}
	@Then("I see search result contain {string}")
	public void i_see_search_result_contain_abcd(String string) {
		List<WebElement> bookList = homePage.getDisplayItems();
		assert(bookList.size() == 1);
	}

	@Before
	public void initializeTest() {
		this.initDriverForBrowser(Browsers.CHROME.name());
	}
	
	@After
	public void endTest() {   
		this.getCurrentWebDriver().quit();
	}
}
