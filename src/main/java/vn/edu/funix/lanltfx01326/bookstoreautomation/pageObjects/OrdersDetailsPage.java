package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrdersDetailsPage {
	@FindBy(id = "order_id")
	WebElement orderIdElement;

	@FindBy(id = "customer_full_name")
	WebElement customerFullNameElement;

	@FindBy(id = "customer_address")
	WebElement customerAddressElement;

	@FindBy(id = "customer_phone_and_email")
	WebElement customerPhoneAndEmailElement;

	@FindBy(className = "book_name")
	List<WebElement> bookNameList;

	@FindBy(className = "book_price")
	List<WebElement> bookPriceList;

	@FindBy(id = "orders_btn")
	WebElement OrdersDirectoryButtonElement;

	private WebDriver driver;

	public OrdersDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void orderDetailsAvailability(String name, String sur, String country, String street, String city,
			String postalCode, String phone, String email) {
		String actualFullNameDetail = customerFullNameElement.getText();
		String actualFullAddressDetail = customerAddressElement.getText();
		String actualPersonalInfoDetail = customerPhoneAndEmailElement.getText();

		Assert.assertTrue(actualFullNameDetail.contains(name + " " + sur), "Incorrect full name details");

		Assert.assertTrue(actualFullAddressDetail.contains(country), "Incorrect full address details");
		Assert.assertTrue(actualFullAddressDetail.contains(street), "Incorrect full address details");
		Assert.assertTrue(actualFullAddressDetail.contains(city), "Incorrect full address details");
		Assert.assertTrue(actualFullAddressDetail.contains(postalCode), "Incorrect full address details");

		Assert.assertTrue(actualPersonalInfoDetail.contains(phone), "Incorrect personal details");
		Assert.assertTrue(actualPersonalInfoDetail.contains(email), "Incorrect personal details");
	}

	public boolean isOrderedBookTitleAndPricePresented(String title, Double price) {
		int titleIndex = -1;
		for (WebElement cartBookTitleEle : bookNameList) {
			titleIndex++;
			if (title.equals(cartBookTitleEle.getText())) {
				break;
			}
		}
		String sameRowPriceText = bookPriceList.get(titleIndex).getText();
		if (price.equals(Double.valueOf(sameRowPriceText))) {
			return true;
		}
		return false;
	}

	public void clickOrdersDirectoryButton() {
		OrdersDirectoryButtonElement.click();
	}

}
