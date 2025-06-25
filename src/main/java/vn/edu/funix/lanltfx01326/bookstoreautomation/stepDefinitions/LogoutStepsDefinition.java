package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.AdminLoginPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.AdminPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class LogoutStepsDefinition extends TestBase {

	AdminLoginPage loginPage = new AdminLoginPage(driver);
	AdminPage adminPage = new AdminPage(driver);
}
