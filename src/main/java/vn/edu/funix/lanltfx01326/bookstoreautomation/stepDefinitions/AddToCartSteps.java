package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.CartPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.CartPageBookContainer;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.CheckOutPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.HomePage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.HomePageBookContainer;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class AddToCartSteps extends TestBase {
	HomePage homePage;
	CartPage cartPage;

	@When("user clicks button Add To Cart the book having title as {string}")
	public void user_clicks_button_add_to_cart_the_book_having_title_as(String string) {
		WebDriver driver = getCurrentWebDriver();
		homePage = new HomePage(driver);
		HomePageBookContainer homePageBookContainer = homePage.getBookContainerByBookTitle(string);
		Assert.assertNotNull(homePageBookContainer, "There is no books with that title");
		WebElement addToCartButton = homePageBookContainer.addToCartButton();
		addToCartButton.click();
	}

	@Then("user is directed to cartpage as {string}")
	public void user_is_directed_to_cartpage_as(String url) {
		waitHelper.waitForUrl(url, 5);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, url);
		cartPage = new CartPage(getCurrentWebDriver());
	}

	@Then("book title is seen in cart page as {string}")
	public void book_title_is_seen_in_cart_page_as(String string) {
		CartPageBookContainer cartPageBookContainer = cartPage.getCartPageBookContainerByBookTitle(string);
		Assert.assertNotNull(cartPageBookContainer, "There is no books in cart with that title");
	}

	@When("user clicks remove button of the book with title as {string}")
	public void user_clicks_remove_button_of_the_book_with_title_as(String string) {
		CartPageBookContainer cartPageBookContainer = cartPage.getCartPageBookContainerByBookTitle(string);
		Assert.assertNotNull(cartPageBookContainer, "There is no books in cart with that title");
		WebElement removeFromCartButton = cartPageBookContainer.removeFromCartButton();
		removeFromCartButton.click();
	}

	@Then("user sees success message as {string}")
	public void user_sees_success_message_as(String emptyBasketMsgExpected) {
		String emptyBasketMsgActual = cartPage.getEmptyCartMsg();
		Assert.assertEquals(emptyBasketMsgActual, emptyBasketMsgExpected);
	}

//Add more than 1 book

	@When("user clicks Online Book Store textbutton")
	public void user_clicks_online_book_store_textbutton() {
		cartPage.clickOnlineBookStoreButton();
	}

	@Then("user is directed back to homepage as {string}")
	public void user_is_directed_back_to_homepage_as(String url) {
		String currentUrl = driver.getCurrentUrl();
		waitHelper.waitForUrl(currentUrl, 5);
		Assert.assertEquals(currentUrl, url);
		homePage = new HomePage(getCurrentWebDriver());
	}

	@When("user clicks delete all button")
	public void user_clicks_delete_all_button() {
		cartPage.clickOnDeleteAllCartButton();
	}

	@When("user clicks button Checkout button")
	public void user_clicks_button_checkout_button() {
		cartPage.submitCheckout();
	}

}
