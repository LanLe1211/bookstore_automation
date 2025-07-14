package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	@FindBy(id = "search")
	WebElement searchInput;

	@FindBy(id = "search_submit")
	WebElement searchButton;

	@FindBy(id = "admin_nav_link")
	WebElement adminButton;
	
	@FindBy(id = "home_nav_link")
	WebElement onlineBookStoreMasterNavigation;

	//for all book containers
	private String bookContainerXpath = "//div[contains(@class, 'book_container')]";

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void enterSearchText(String term) {
		this.searchInput.clear();
		this.searchInput.sendKeys(term);
	}

	public void submitSearch() {
		this.searchButton.click();
	}

	public void navigateToAdminPage() {
		this.adminButton.click();
	}

	//convert list of web elements into list of custom classes; return the number of book containers on screen
	public List<HomePageBookContainer> getBookContainerList() {
		List<HomePageBookContainer> homePageBookContainerList = new ArrayList<>();
		List<WebElement> bookContainerList = driver.findElements(By.xpath(getBookContainerLocator()));
		for (WebElement element : bookContainerList) {
			homePageBookContainerList.add(new HomePageBookContainer(element));
		}
		return homePageBookContainerList;
	}

	public String getTitleId() {
		return "home_nav_link";
	}

	public String getBookContainerLocator() {
		return this.bookContainerXpath;
	}

	public WebElement getBookTitleFromBookContainer(WebElement bookContainer) {
		return null;
	}

	
	public HomePageBookContainer getBookContainerByBookTitle(String bookTitle) {
		String findByBookTitleXpath = "//div[contains(@class, 'book_container') and .//h5[contains(@class, 'book_title') and normalize-space() = '"
				+ bookTitle + "']]";

		WebElement bookContainerWebElement = driver.findElement(By.xpath(findByBookTitleXpath));
		if (bookContainerWebElement != null) {
			HomePageBookContainer homePageBookContainer = new HomePageBookContainer(bookContainerWebElement);
			return homePageBookContainer;
		} else {
			return null;
		}
	}

	public String getNoBookMessage() {
		WebElement noBookMessageElement = driver.findElement(By.id("no_book_message"));
		return noBookMessageElement.getText();
	}
	
	
	
	
}
