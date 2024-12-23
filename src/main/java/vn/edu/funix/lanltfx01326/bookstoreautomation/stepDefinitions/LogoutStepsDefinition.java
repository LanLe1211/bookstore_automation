package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Given;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.AdminLoginPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.BookDetailsPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class LogoutStepsDefinition extends TestBase {

	AdminLoginPage loginPage = new AdminLoginPage(driver);
	BookDetailsPage bookDetailsPage = new BookDetailsPage(driver);

	@Given("^I am on the login page URL logout \"([^\"]*)\"$")
	public void i_am_on_the_login_page_url_logout(String url_Login) throws Throwable {
		driver.get(url_Login);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	@Then("^I see Login page logout$")
//	public void i_see_Login_Page_logout() throws Throwable {
//		loginPage = new LoginPage(driver);
//		loginPage.ttl_AviationID.isDisplayed();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//
//	@When("^I enter aviationID as logout \"([^\"]*)\"$")
//	public void i_enter_aviationId_as_logout(String aviationID) throws Throwable {
//		loginPage.enterAviationId(aviationID);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//
//	@When("^I enter password as logout \"([^\"]*)\"$")
//	public void i_enter_password_as_logout(String password) throws Throwable {
//		loginPage.enterPassword(password);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//
//	@When("^I click Login button as logout$")
//	public void i_click_on_login_button_logout() throws Throwable {
//		loginPage.clickLoginButton();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
//		Thread.sleep(10000); 
//	}
//
//
//	@Then("^I see RM Search Page as logout$")
//	public void i_see_RM_Search_page_logout() throws Throwable {
//		sRDashboard = new SkyReadyDashboard(driver);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
//	}
//	
//	@When("^I click hamburger menu$")
//	public void i_click_hamburger_menu() throws Throwable{
//		sRDashboard.clickHamburgerMenu();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
//	}
//	
//
//	@And("^I click logout button$")
//	public void i_click_logout_button() throws Throwable {
//		sRDashboard.btn_logout_r_AR.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//
//	@And("^I choose logout button$")
//	public void i_choose_logout_button() throws Throwable {
//		sRDashboard.btn_logoutconfirmation_logout.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//
//	@Then("^I stay at landing page$")
//	public void i_stay_at_landing_page() throws Throwable {
//		Thread.sleep(20000); 
//		landingPage = new LandingPage(driver);
//		String URL = driver.getCurrentUrl();
//		Assert.assertEquals(URL, "https://clcontent-dev-bcnl.azurewebsites.net/#/auth/landing");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	}

}
