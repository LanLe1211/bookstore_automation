package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vn.edu.funix.lanltfx01326.bookstoreautomation.helper.wait.WaitHelper;

import vn.edu.funix.lanltfx01326.bookstoreautomation.helper.wait.WaitHelper;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@name=\"term\"]")
	WebElement searchInput;

	@FindBy(xpath = "//form[@action='/search']/button[@type=\"submit\"]")
	WebElement searchButton;
	
	
	private String bookContainerXpath = "//div[contains(@class, 'book_container')]";

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
		List<WebElement> bookContainerList = driver.findElements(By.xpath(getBookContainerLocator()));
		for (WebElement element: bookContainerList) {
			bookContainer.add(new BookContainer(element));
		}
		return bookContainer;
	}
	
	public String getTitleLocator() {
		return "//a[@class=\"navbar-brand\"]";
	}
	
	public String getBookContainerLocator() {
		return this.bookContainerXpath;
	}
	
	
	public WebElement getBookTitleFromBookContainer(WebElement bookContainer) {
		return null;
	}
}
