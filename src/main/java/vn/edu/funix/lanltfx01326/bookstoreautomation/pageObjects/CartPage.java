package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//div[contains(@class, 'book_container')]")
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

	public CartPageBookContainer getCartPageBookContainerByBookTitle(String bookTitle) {
		String findByBookTitleXpath = "//div[contains(@class, 'book_container') and .//h5[contains(@class, 'book_title') and normalize-space() = '"
				+ bookTitle + "']]";

		WebElement cartPageBookContainerWebElement = driver.findElement(By.xpath(findByBookTitleXpath));
		if (cartPageBookContainerWebElement != null) {
			CartPageBookContainer cartPageBookContainer = new CartPageBookContainer(cartPageBookContainerWebElement);
			return cartPageBookContainer;
		} else {
			return null;
		}
	}
	
	public String getEmptyCartMsg() {
		return null;
		
	}
}
