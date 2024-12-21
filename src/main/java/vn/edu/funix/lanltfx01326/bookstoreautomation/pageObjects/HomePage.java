package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(id = "search")
	WebElement searchInput;

	@FindBy(xpath = "search_submit")
	WebElement searchButton;

	@FindBy(xpath = "//div[contains(@class, 'card text')]")
	List<WebElement> displayList;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterSearchText(String searchText) {
		this.searchInput.sendKeys(searchText);
	}

	public void submitSearch() {
		this.searchButton.click();
	}
	
	public List<WebElement> getDisplayItems() {
		return displayList;
	}
	
	public String getTitleLocator() {
		return "//a[@class=\"navbar-brand\"]";
	}
}
