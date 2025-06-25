package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
	@FindBy(id = "admin_btn")
	WebElement AdminDirectoryButtonElement;
	
	private WebDriver driver;

	public OrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnMostRecentOrder() {
		List<WebElement> orderIdElements = driver.findElements(By.className("order_id"));
		WebElement latestOrderIdElement = null;
		for (WebElement orderIdElement: orderIdElements) {
			if (latestOrderIdElement == null) {
				latestOrderIdElement = orderIdElement;
			} else {
				int currentValue = Integer.valueOf(orderIdElement.getText());
				int currentLatest = Integer.valueOf(latestOrderIdElement.getText());
				if (currentValue > currentLatest) {
					latestOrderIdElement = orderIdElement;
				}
			}
		}
		
		latestOrderIdElement.click();
	}
	
	public void clickOnAdminDirectoryBtn() {
		AdminDirectoryButtonElement.click();
	}
	
}
