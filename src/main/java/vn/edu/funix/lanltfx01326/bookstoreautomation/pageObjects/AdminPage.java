package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdminPage {
	private WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search")
	WebElement searchInput;

	@FindBy(id="search_btn")
	WebElement searchButton;
	
	@FindBy(id = "orders_btn")
	WebElement orderButton;

	@FindBy(id = "logout_btn")
	WebElement logoutButtonElement;
	
	@FindBy(id = "new_book_btn")
	WebElement newBookButtonElement;
	
	
	
	public void clickOrdersButtonToViewOrderDetails() {
		orderButton.click();
	}
	
	public void clickLogoutFromAdminPage() {
		logoutButtonElement.click();
	}
	
	public void clickNewBookButton() {
		newBookButtonElement.click();
	}
	
	public void enterSearchText(String term) {
		this.searchInput.clear();
		this.searchInput.sendKeys(term);
	}

	public void submitSearch() {
		this.searchButton.click();

	}
	
	public String getSuccessMessage() {
		WebElement successMsgElement = driver.findElement(By.id("success_mesage"));
		return successMsgElement.getText();
	}
	
	public WebElement getBookRowWithBookName(String name) {
		WebElement bookListTable = driver.findElement(By.tagName("table"));
		AdminPageBookTable adminPageBookTable = new AdminPageBookTable(bookListTable);
		List<WebElement> tableRowElementList = adminPageBookTable.getAllTableRow();
		
		for (WebElement tableRowElement : tableRowElementList) {
			String bookName = AdminPageBookTable.getBookNameElementFromTableRow(tableRowElement).getText();
			if (bookName.equals(name)) {
				return tableRowElement;
			}
		}	
		return null;
	}
	
	public List<WebElement> getAllBookRowElements() {
		WebElement bookListTable = driver.findElement(By.tagName("table"));
		AdminPageBookTable adminPageBookTable = new AdminPageBookTable(bookListTable);
		return adminPageBookTable.getAllTableRow();
	}
	
	public void checkBookDetailExists(String name, String price, String author, String isbn, String publisher, String date) {
		WebElement tableRowElement = getBookRowWithBookName(name);
		Assert.assertNotNull(tableRowElement, "Table Row not found for book name");
		
		String actualPriceString = AdminPageBookTable.getBookPriceElementFromTableRow(tableRowElement).getText();
		Assert.assertEquals(Double.valueOf(actualPriceString), Double.valueOf(price));
		
		String actualAuthor = AdminPageBookTable.getBookAuthorElementFromTableRow(tableRowElement).getText();
		Assert.assertEquals(actualAuthor, author);
	}
	
	public String getNoBookMessage() {
		WebElement noBookMessageElement = driver.findElement(By.id("no_book_message"));
		return noBookMessageElement.getText();
	}
}
