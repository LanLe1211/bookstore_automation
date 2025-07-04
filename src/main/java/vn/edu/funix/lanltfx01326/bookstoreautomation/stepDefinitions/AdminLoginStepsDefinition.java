package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import java.time.Duration;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.AdminLoginPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.AdminPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class AdminLoginStepsDefinition extends TestBase {

	AdminLoginPage loginPage;
	AdminPage adminPage;

	@Then("user is on login page as {string}")
	public void i_am_on_the_login_page_url(String urlLogin) throws Throwable {
		waitHelper.waitForUrl(urlLogin, 5);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(urlLogin, currentUrl);
		loginPage = new AdminLoginPage(driver);
	}

	@When("^user enters the username as \"([^\"]*)\"$")
	public void i_enter_username_as(String username) throws Throwable {
		loginPage.enterUsername(username);
	}

	@When("^user enter the password as \"([^\"]*)\"$")
	public void i_enter_password_as(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@When("^user clicks on the login button$")
	public void i_click_on_login_button() throws Throwable {
		loginPage.clickLoginButton();
	}

	@Then("user is presented with the following message \"([^\"]*)\"$")
	public void user_is_presented_with_the_following_message_as(String message) throws Throwable {
		String displayMessage = loginPage.getMessage();
		Assert.assertEquals(message, displayMessage);
	}

	@When("admin logs in with username as {string} and password as {string}")
	public void admin_logs_in_with_username_as_and_password_as(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
	}
}
