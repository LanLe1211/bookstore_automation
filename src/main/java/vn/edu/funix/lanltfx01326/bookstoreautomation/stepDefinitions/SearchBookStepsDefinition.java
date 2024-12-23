package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.BookContainer;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.HomePage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class SearchBookStepsDefinition extends TestBase {
	private static Logger logger = LogManager.getLogger(SearchBookStepsDefinition.class);
	private HomePage homePage = new HomePage(driver);

	@Given("User is on bookstore homepage {string}")
	public void user_is_on_hrm_login_page(String string) {
		WebDriver driver = getCurrentWebDriver();
		driver.get(string);
		waitHelper.WaitForElementLocatorVisible(homePage.getTitleLocator(), 10, 100);

	}

	@When("I enter keyword as {string}")
	public void i_enter_keyword_as(String string) {
		homePage.enterSearchText(string);
		homePage.submitSearch();
	}

	@Then("I see search result contain {string}")
	public void i_see_search_result_contain_abcd(String string) {
		List<BookContainer> bookContainerList = homePage.getBookContainerList();
		assert (bookContainerList.size() == 1);
		BookContainer searchResult = bookContainerList.get(0);
		logger.info(string);
		logger.info(searchResult.getBookTitle());
		assert (string.equals(searchResult.getBookTitle()));
	}
}
