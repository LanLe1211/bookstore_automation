package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.AdminPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.BookFormPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.CheckOutPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class BookFormFillingStepsDefinition extends TestBase {
	BookFormPage bookFormPage;

	// add new book
	@Then("user is navigated to books form page in url as {string}")
	public void user_is_navigated_to_books_form_page_in_url_as(String url) {
		waitHelper.waitForUrl(url, 5);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, currentUrl);
		bookFormPage = new BookFormPage(driver);
	}

	@When("user enters book name as {string} price as {string} author as {string} ISBN as {string} publisher as {string} date as {string}")
	public void user_enters_book_name_as_price_as_author_as_isbn_as_publisher_as_date_as(String bookname, String price,
			String author, String isbn, String publisher, String date) {
		bookFormPage.filNewBookForm(bookname, price, author, isbn, publisher, date);
	}

	@When("user tap on Add Book Save button")
	public void user_tap_on_add_book_save_button() {
		bookFormPage.clickSaveNewBookButton();
	}

	@And("error message is seen as {string} in element with html id {string}")
	public void error_message_is_seen_as(String addbookerrormsg, String id) throws Throwable {
		waitHelper.WaitForElementVisibleById(id, 5, 100);
		String actualAddBookErrorMsg = bookFormPage.getAddNewBookErrorMsg(id);
		Assert.assertEquals(actualAddBookErrorMsg, addbookerrormsg);
	}

	// edit book
	@Then("user is navigated to edit book url as {string}")
	public void user_is_navigated_to_edit_book_url_as(String url) {
		waitHelper.waitForUrlContains(url, 5);
		bookFormPage = new BookFormPage(driver);		
	}

}
