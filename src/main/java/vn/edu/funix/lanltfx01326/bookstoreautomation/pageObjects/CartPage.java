package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	private WebDriver driver;
	
	@FindBy(id = "checkout_submit")
	WebElement cart_checkoutButton;

	@FindBy(xpath = "//form[@action='/search']/button[@type=\"submit\"]")
	WebElement searchButton;

	@FindBy(xpath = "//div[contains(@class, 'card text')]")
	List<WebElement> displayList;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	public void submitCheckout() {
		this.cart_checkoutButton.click();
	}
	
	public List<WebElement> getDisplayItems() {
		return displayList;
	}
	
	public String getTitleLocator() {
		return "//a[@class=\"navbar-brand\"]";
	}
}
