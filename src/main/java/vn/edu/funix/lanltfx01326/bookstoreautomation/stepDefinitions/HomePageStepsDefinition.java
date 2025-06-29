package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.HomePage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.HomePageBookContainer;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class HomePageStepsDefinition extends TestBase {
	private HomePage homePage;

	
	@Given("User is on bookstore homepage {string}")
	public void user_is_on_home_page(String string) {
		WebDriver driver = getCurrentWebDriver();
		driver.get(string);
		homePage = new HomePage(driver);
		waitHelper.WaitForElementVisibleById(homePage.getTitleId(), 10, 100);
	}
	
	@Then("homepage title is {string}")
	public void home_page_title_is(String string) {
		WebDriver driver = getCurrentWebDriver();
		waitHelper.WaitForElementVisibleById(homePage.getTitleId(), 10, 100);
		WebElement pageTitle = driver.findElement(By.id(homePage.getTitleId()));
		Assert.assertEquals(string, pageTitle.getText()); 
	}
	
	
	//Search books
	@When("user enters keyword as {string}")
	public void user_enter_keyword_as(String string) {
		homePage.enterSearchText(string);
		homePage.submitSearch();
	}
	
	@Then ("user sees the number of results as {int}")
	public void user_see_the_number_of_results_as(int resultcount) {
		List<HomePageBookContainer> bookContainerList = homePage.getBookContainerList();
		Assert.assertEquals(bookContainerList.size(), resultcount);
	}

	@Then("user sees search result contain {string}")
	public void user_see_search_result_contain_string(String titleListString) throws InterruptedException {
		List<String> titleList = Arrays.asList(titleListString.split("\\s*,\\s*"));
		List<HomePageBookContainer> bookContainerList = homePage.getBookContainerList();
		for(HomePageBookContainer book:bookContainerList) {
			Assert.assertListContainsObject(titleList, book.getBookTitle(), null);
		}
	}
	
	// Navigate link to admin page
	@When("user click on the admin link")
	public void user_click_on_the_admin_link() {
		homePage.navigateToAdminPage();
	}

	@Then("user is directed to search page as {string}")
	public void user_is_directed_to_search_page_as(String string) {
		waitHelper.waitForUrlContains(string, 5);
	}
	
	@Then("user sees error message {string}")
	public void user_sees_error_message(String message) {
	    String actualMessage = homePage.getNoBookMessage();
	    Assert.assertEquals(actualMessage, message);
	}
}
