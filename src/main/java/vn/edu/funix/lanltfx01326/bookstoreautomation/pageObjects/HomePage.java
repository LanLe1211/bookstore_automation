package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@name=\"term\"]")
	WebElement searchInput;

	@FindBy(xpath = "//form[@action='/search']/button[@type=\"submit\"]")
	WebElement searchButton;

	@FindBy(xpath = "//div[contains(@class, 'book_container')]")
	List<WebElement> bookContainerList;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void enterSearchText(String term) {
		this.searchInput.sendKeys(term);
	}

	public void submitSearch() {
		this.searchButton.click();
	}
	
	public List<BookContainer> getBookContainerList() {
		List<BookContainer> bookContainer = new ArrayList<>();
		for (WebElement element: bookContainerList) {
			bookContainer.add(new BookContainer(element));
		}
		return bookContainer;
	}
	
	public String getTitleLocator() {
		return "//a[@class=\"navbar-brand\"]";
	}
	
	public WebElement getBookTitleFromBookContainer(WebElement bookContainer) {
		return null;
	}
}
