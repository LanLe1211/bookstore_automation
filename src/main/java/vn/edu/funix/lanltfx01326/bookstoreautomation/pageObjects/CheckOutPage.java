package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	private WebDriver driver;

	@FindBy(className = "cart_book_title")
	List<WebElement> checkoutPageBookTitleList;

	@FindBy(className = "cart_book_price")
	List<WebElement> checkoutPageBookPriceList;

	@FindBy(id = "shipping_cost")
	WebElement shippingCostElement;

	@FindBy(id = "total_price")
	WebElement totalPriceElement;

	@FindBy(id = "name")
	WebElement nameInput;

	@FindBy(id = "surname")
	WebElement surnameInput;

	@FindBy(id = "countryRegion")
	WebElement countryRegionInput;

	@FindBy(id = "streetAndHouseNumber")
	WebElement streetAndHouseNumberInput;

	@FindBy(id = "city")
	WebElement cityInput;

	@FindBy(id = "postalCode")
	WebElement postalCodeInput;

	@FindBy(id = "phoneNumber")
	WebElement phoneNumberInput;

	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(id = "place_order_submit")
	WebElement placeOrderButton;
	

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isBookDetailPresented(String title, Double price) {
		int titleIndex = -1;
		for (WebElement cartBookTitleElement : checkoutPageBookTitleList) {
			titleIndex++;
			if (title.equals(cartBookTitleElement.getText())) {
				break;
			}
		}
		String sameRowPriceText = checkoutPageBookPriceList.get(titleIndex).getText();
		if (price.equals(Double.valueOf(sameRowPriceText))) {
			return true;
		}
		return false;
	}

	public String getShippingCostText() {
		return shippingCostElement.getText().trim();
	}

	public String getTotalPriceText() {
		return totalPriceElement.getText().trim();
	}
	
	public void fillCheckOutForm(String name, String surname, String country, String street, String city, String postalCode, String phone, String email) {
		nameInput.sendKeys(name);
		surnameInput.sendKeys(surname);
		countryRegionInput.sendKeys(country);
		streetAndHouseNumberInput.sendKeys(street);
		cityInput.sendKeys(city);
		postalCodeInput.sendKeys(postalCode);
		phoneNumberInput.sendKeys(phone);
		emailInput.sendKeys(email);		
	}
	
	public void clickCheckoutOrder() {
		placeOrderButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
