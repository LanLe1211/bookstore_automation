package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import java.time.Duration;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.AdminLoginPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.BookDetailsPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;


public class AdminLoginSteps extends TestBase {
	
	AdminLoginPage loginPage;
	BookDetailsPage bookDetailsPage;
	
	@Given("^I am on the login page URL \"([^\"]*)\"$")
	public void i_am_on_the_login_page_url(String url_Login) throws Throwable {
		driver.get(url_Login);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("^I see Admin hyperlinktext$")
	public void i_see_Admin_hyperlink_text() throws Throwable {

		loginPage = new AdminLoginPage(driver);
		loginPage.admin_nav_link.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String username) throws Throwable {
		loginPage.enterUsername(username);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String password) throws Throwable {
		loginPage.enterPassword(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("^I click Login button$")
	public void i_click_on_login_button() throws Throwable {
		loginPage.clickLoginButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("^I see Admin Details Page$")
	public void i_see_AdminDetails_page() throws Throwable {
		bookDetailsPage = new BookDetailsPage(driver);
		//String textHeader = bookDetailsPage.getTextHeader();
		//Assert.assertEquals(textHeader, "Search - Select search type to begin search");
		String URL =driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://cl.dev.bcnl.digitalaviationservices.com/sky-ready/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(15000); 
		
	}
}
