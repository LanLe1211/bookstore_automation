package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.AdminPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.AdminPageBookTable;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.BookFormPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class AdminPageStepsDefinition extends TestBase {
	AdminPage adminPage;
	BookFormPage bookFormPage;

	@When("user clicks on button Orders")
	public void user_clicks_on_button_orders() {
		adminPage.clickOrdersButtonToViewOrderDetails();
	}

	@Then("user is navigated to admin details page in url as {string}")
	public void user_is_navigated_to_admin_details_page_in_url_as(String url) throws Throwable {
		waitHelper.waitForUrl(url, 5);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, currentUrl);
		adminPage = new AdminPage(driver);
	}

	// navigate to home page
	@Then("user is navigated to home page in url as {string}")
	public void user_is_navigated_to_home_page_in_url_as(String url) throws Throwable {
		waitHelper.waitForUrl(url, 5);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, currentUrl);
		adminPage = new AdminPage(driver);
	}

	// click New book to add new book by admin - for the addnewbook feature
	@When("user clicks on button New book")
	public void user_clicks_on_button_new_book() {
		adminPage.clickNewBookButton();
	}

	@Then("a new row is seen with details book name as {string} price as {string} author as {string} ISBN as {string} publisher as {string} date as {string}")
	public void a_new_row_is_seen_with_details_book_name_as_price_as_author_as_isbn_as_publisher_as_date_as(String name,
			String price, String author, String isbn, String publisher, String date) {
		adminPage.checkBookDetailExists(name, price, author, isbn, publisher, date);
	}

	@When("user clicks on Logout button$")
	public void user_clicks_on_Logout_button() throws Throwable {
		adminPage.clickLogoutFromAdminPage();
	}

	@Then("user clicks on delete book button of the book {string}")
	public void user_clicks_on_delete_book_button_of_the_book(String bookName) {
		WebElement bookRow = adminPage.getBookRowWithBookName(bookName);
		Assert.assertNotNull(bookRow);
		WebElement deleteButton = AdminPageBookTable.getBookDeleteElementFromTableRow(bookRow);
		deleteButton.click();
	}

	@Then("there is no books with details book name as {string}")
	public void there_is_no_books_with_details_book_name_as(String bookName) {
		WebElement bookRow = adminPage.getBookRowWithBookName(bookName);
		Assert.assertNull(bookRow);
	}
	
	@Then("success message is displayed as {string}")
	public void success_message_is_displayed_as (String message) {
		String displayMessage = adminPage.getAddUpdateDeleteBookSuccessMessage();
		Assert.assertEquals(message, displayMessage);
	}

	//step for admin_editbook 
	@Then("user clicks on edit book button of the book {string}")
	public void user_clicks_on_edit_book_button_of_the_book(String bookName) {
		WebElement bookRow = adminPage.getBookRowWithBookName(bookName);
		Assert.assertNotNull(bookRow);
		WebElement editButton = AdminPageBookTable.getBookEditElementFromTableRow(bookRow);
		editButton.click();
	}

	@When("user enters admin search keyword as {string}")
	public void user_enters_admin_search_keyword_as(String string) {
		adminPage.enterSearchText(string);
		adminPage.submitSearch();
	}
	
	@Then("user is directed to admin search page as {string}")
	public void user_is_directed_to_admin_search_page_as(String string) {
		waitHelper.waitForUrlContains(string, 5);
	}
	
	@Then("user enters the admin search number of results as {int}")
	public void user_enters_the_admin_search_number_of_results_as(Integer resultCount) {
	    List<WebElement> bookRowList = adminPage.getAllBookRowElements();
	    Assert.assertEquals(bookRowList.size(), resultCount);
	}
	@Then("user sees admin search result contain {string}")
	public void user_sees_admin_search_result_contain(String bookNameStrings) {
		List<String> titleList = Arrays.asList(bookNameStrings.split("\\s*,\\s*"));
		List<WebElement> bookRowElementList = adminPage.getAllBookRowElements();
		
		for(WebElement bookRowElement :bookRowElementList ) {
			String bookName = AdminPageBookTable.getBookNameElementFromTableRow(bookRowElement).getText();
			Assert.assertListContainsObject(titleList, bookName, null);
		}
	    
	}
	
	

}
