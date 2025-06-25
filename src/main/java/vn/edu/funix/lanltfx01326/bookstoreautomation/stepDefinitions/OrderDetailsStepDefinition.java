package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.OrdersDetailsPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.OrdersPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class OrderDetailsStepDefinition extends TestBase {
	OrdersDetailsPage orderDetailsPage;
	OrdersPage ordersPage;

	@Then("user is navigated to orders details page in url as {string}")
	public void i_see_OrderDetails_page(String url) throws Throwable {
		waitHelper.waitForUrl(url, 5);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, currentUrl);
		ordersPage = new OrdersPage(driver);
	}

	@When("user clicks on the most recent orderID")
	public void user_clicks_on_most_recent_orderID() {
		ordersPage.clickOnMostRecentOrder();
	}

	@Then("user is directed to order details page {string}")
	public void user_is_directed_to_order_details_page(String url) {
		waitHelper.waitForUrlContains(url, 5);
		orderDetailsPage = new OrdersDetailsPage(driver);
	}
	
	
	@Then("user see details name as {string} surname as {string} country region as {string} street as {string} city as {string} postal code as {string} phone as {string} email as {string}")
	public void user_see_details_name_as_country_region_as_street_as_city_as_buford_postal_code_as_phone_as_email(
			String name, String sur, String country, String street, String city, String postalCode, String phone, String email) {
		orderDetailsPage.orderDetailsAvailability(name, sur, country, street, city, postalCode, phone, email);
	}

	@Then("user see details title as {string} and price as {double}")
	public void user_see_details_title_as_and_price_as(String title, Double price) {
		Assert.assertTrue(orderDetailsPage.isOrderedBookTitleAndPricePresented(title, price),
				"Not the ordered title and price");
	}

	@When("user clicks OrdersDirectory button")
	public void user_clicks_orders_directory_button() {
		orderDetailsPage.clickOrdersDirectoryButton();
	}
	
	@When("user clicks AdminDirectory button")
	public void user_clicks_on_button_admins() {
		ordersPage.clickOnAdminDirectoryBtn();
	}
}
