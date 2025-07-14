package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vn.edu.funix.lanltfx01326.bookstoreautomation.helper.wait.WaitHelper;

public class CartPage {

	private WebDriver driver;
	private WaitHelper waitHelper;

	@FindBy(id = "checkout_submit")
	WebElement cart_checkoutButton;

	@FindBy(xpath = "//div[contains(@class, 'book_container')]")
	List<WebElement> displayList;
	
	@FindBy(id="home_nav_link")
	WebElement onlineBookStoreButton;
	
	@FindBy(id="checkout_delete_all")
	WebElement deleteAllCartButton;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.waitHelper = new WaitHelper(driver);
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
		String findByBookTitleXpath = "//div[contains(@class, 'book_container') and .//h5[contains(@class, 'book_name') and normalize-space() = '"
				+ bookTitle + "']]";
/* 	//div[contains(@class, 'book_container') and .//h5[contains(@class, 'book_name') and normalize-space() = 'Hannibal']]    */
		
		WebElement cartPageBookContainerWebElement = driver.findElement(By.xpath(findByBookTitleXpath));
		if (cartPageBookContainerWebElement != null) {
			CartPageBookContainer cartPageBookContainer = new CartPageBookContainer(cartPageBookContainerWebElement);
			return cartPageBookContainer;
		} else {
			return null;
		}
	}
	
	public String getEmptyCartMsg() {
		waitHelper.WaitForElementVisibleById("cart_empty_message", 5, 100);
		WebElement basketEmptyElement = driver.findElement(By.id("cart_empty_message"));
		return basketEmptyElement.getText();	
	}
	
	public void clickOnlineBookStoreButton() {
		this.onlineBookStoreButton.click();
	}
	
	public void clickOnDeleteAllCartButton() {
		this.deleteAllCartButton.click();
	}	
	
	public String getOrderSuccessMsg() {
		WebElement orderSuccessMessage = driver.findElement(By.id("checkout_success_message"));
		return orderSuccessMessage.getText();	
	}
}
