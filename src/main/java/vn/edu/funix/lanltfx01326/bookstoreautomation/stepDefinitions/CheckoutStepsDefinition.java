package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.CheckOutPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class CheckoutStepsDefinition extends TestBase {
	CheckOutPage checkoutPage;

	@Then("user is directed to checkout page as {string}")
	public void user_is_directed_to_checkout_page_as(String url) {
		waitHelper.waitForUrl(url, 5);
		checkoutPage = new CheckOutPage(driver);
	}

	@Then("book title is seen in checkout page as {string} and price as {double}")
	public void booktitle_is_seen_in_checkout_page_as_and_price_as(String title, Double price) {
		Assert.assertTrue(checkoutPage.isBookDetailPresented(title, price),
				"Expected book is not presented in check out page");
	}

	@Then("delivery cost is seen in checkout page as {string}")
	public void delivery_cost_is_seen_in_checkout_page_as(String deliveryCost) {
		Assert.assertEquals(checkoutPage.getShippingCostText(), deliveryCost);
	}

	@Then("total cos is seen in checkout as {string}")
	public void total_cos_is_seen_in_checkout_as(String string) {
		Assert.assertEquals(checkoutPage.getTotalPriceText(), string);
	}

	@When("user enters name as {string} surname as {string} country region as {string} street as {string} city as {string} postal code as {string} phone as {string} email as {string}")
	public void user_enters_name_as_surname_as_country_region_as_street_as_city_as_buford_postal_code_as_phone_as_email_as_lan_gmail_com(
			String name, String surname, String country, String street, String city, String postalCode, String phone,String email) {
		checkoutPage.fillCheckOutForm(name, surname, country, street, city, postalCode, phone, email);
	}

	@When("user clicks on Place Order button")
	public void user_clicks_on_place_order_button() {
		checkoutPage.clickCheckoutOrder();
	}

}
